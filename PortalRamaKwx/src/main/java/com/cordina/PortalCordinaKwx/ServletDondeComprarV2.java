package com.cordina.PortalCordinaKwx;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.cordina.PortalCordinaKwx.Util.clsLog;
import com.cordina.PortalCordinaKwx.conexionBd.connectionManager;
import com.cordina.PortalCordinaKwx.conexionBd.connectionManagerV2;
import com.cordina.PortalCordinaKwx.dto.DelegacionDto;
import com.cordina.PortalCordinaKwx.dto.EstadosDto;
import com.cordina.PortalCordinaKwx.dto.clientesKwxDto;
import com.cordina.PortalCordinaKwx.dto.productosKwxDto;
import com.google.gson.Gson;


public class ServletDondeComprarV2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private Connection conn;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
    public ServletDondeComprarV2() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
        response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
        response.setHeader("Expires", "-1"); // Proxies.

		main(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
        response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
        response.setHeader("Expires", "-1"); // Proxies.

		main(request,response);
	}
	
	@SuppressWarnings("unchecked")
	public void main(HttpServletRequest request, HttpServletResponse response)
	{
		try
		{
			//System.out.println(" 1. INICIO");
			int operacion = 1;
			int producto = 0;
			int estado = 0;
			int delegacion = 0;
			List<EstadosDto> listEstados= new ArrayList<EstadosDto>();
			List<productosKwxDto> lisArticulos = new ArrayList<productosKwxDto>();
			List<DelegacionDto> listDelegaciones= new ArrayList<DelegacionDto>();
			
			List<clientesKwxDto> listClientes= new ArrayList<clientesKwxDto>();
			
		//	System.out.println(" 2. INICIO");
			
			try
			{
				operacion = Integer.parseInt(request.getParameter("operacion"));
			}
			catch(Exception ex)
			{
				String sError= ex.getMessage().toString();
				System.out.println("PortalRama KWX - ERROR: " + sError);
			}
			
		//	System.out.println(" 3. INICIO OPERACION= " + operacion);
			
			switch(operacion)
			{
				case 1:
						listEstados = ObtieneEstados();
						lisArticulos = ObtieneProductosKwx();
						listClientes = ObtieneClientesKwx(0,0,0);
						request.setAttribute("listEstados", listEstados);
						request.setAttribute("lisArticulos",lisArticulos);
						request.setAttribute("listClientes",listClientes);
						request.setAttribute("str_estado",0);
						request.setAttribute("str_producto",0);
						request.setAttribute("str_delegacion",0);
						RequestDispatcher rd = request.getRequestDispatcher("/jsp/DondeComprarV2.jsp");
						rd.forward(request, response);
				break;
				
				case 2:			
					List<EstadosDto> listEdos= new ArrayList<EstadosDto>();
					try
					{
						producto = Integer.parseInt(request.getParameter("Producto"));
						estado = Integer.parseInt(request.getParameter("Estado"));
						delegacion = Integer.parseInt(request.getParameter("delegacion"));
						listEdos = (List<EstadosDto>)request.getAttribute("ListEdo"); 
					}
					catch(Exception ex)
					{
						String sError= ex.getMessage().toString();
						System.out.println("PortalRama KWX - ERROR: " + sError);
					}
					listEstados = ObtieneEstados();
					lisArticulos = ObtieneProductosKwx();
					listClientes = ObtieneClientesKwx(producto,estado, delegacion);
					request.setAttribute("listEstados", listEstados);
					request.setAttribute("lisArticulos",lisArticulos);
					request.setAttribute("listClientes",listClientes);
					request.setAttribute("str_estado",estado);
					request.setAttribute("str_producto",producto);
					request.setAttribute("str_delegacion",delegacion);
					RequestDispatcher rd1 = request.getRequestDispatcher("/jsp/DondeComprar.jsp");
					rd1.forward(request, response);
					break;
					
				case 3:	
					List<DelegacionDto> listDelagaciones= new ArrayList<DelegacionDto>();
					try
					{ 
						estado = Integer.parseInt(request.getParameter("cve_estado"));
					}
					catch(Exception ex)
					{
						String sError= ex.getMessage().toString();
					}
					
				//	System.out.println(" 4. ESTADO = " + estado);
					listDelagaciones = ObtieneDelgacionPorEstado(estado);
					request.setAttribute("listDelagaciones", listDelagaciones);
					Gson gson = new Gson();
					String listaJson =gson.toJson(listDelagaciones);
					response.setContentType("application/json");
					PrintWriter out = response.getWriter();
					out.write(listaJson);
				//	System.out.println(" 5. LIST DEL = " + listDelagaciones.size());
					
					break;
					
				case 4:
					listEstados = ObtieneEstados();
					lisArticulos = ObtieneProductosKwx();
					listClientes = ObtieneClientesKwx(0,0,0);
					request.setAttribute("listEstados", listEstados);
					request.setAttribute("lisArticulos",lisArticulos);
					request.setAttribute("listClientes",listClientes);
					request.setAttribute("str_estado",0);
					request.setAttribute("str_producto",0);
					request.setAttribute("str_delegacion",0);
					RequestDispatcher rd2 = request.getRequestDispatcher("/jsp/DondeComprar.jsp");
					rd2.forward(request, response);
			break;
			}
		}
		catch(Exception ex)
		{
			String sError= ex.getMessage().toString();
		}
	}
	
	public List<DelegacionDto> ObtieneDelgacionPorEstado(int cve_estado)
	{
		List<DelegacionDto> listDelagaciones= new ArrayList<DelegacionDto>();
		try
		{
			String Qry = " SELECT 	cve_delegacion, "+
								  " descripcion "+
						 " FROM 	KWX.c_delegaciones "+
						 " WHERE	id_cve_edo = " + cve_estado;
			ResultSet rs_del= CrearConexionBaseDatos(Qry);	
			
			if(rs_del != null)
			{	
	    		while (rs_del.next())
	    		{
		    		try
		    		{
		    			DelegacionDto del= new DelegacionDto();
		    			del.setCve_delegacion(rs_del.getInt("cve_delegacion"));
		    			del.setDescripcion(rs_del.getString("descripcion"));
		    			listDelagaciones.add(del);
		    		}
		    		catch(Exception ex)
		    		{
		    			String sError= ex.getMessage().toString();
		    			CierraConexion();
		    		}
	    		}
			}
			CierraConexion();
		}
		catch(Exception ex)
		{
			String sError= ex.getMessage().toString();
		}
		return listDelagaciones;
	}
	
	public List<clientesKwxDto> ObtieneClientesKwx(int articulo, int estado, int delegacion)
	{
		List<clientesKwxDto> listClientes= new ArrayList<clientesKwxDto>();
		
		try
		{
			//System.out.println("------------- BUSCAR CLIENTE estado= " + estado + " - articulo=" + articulo + " - delegacion= " + delegacion);
			String Qry = "	SELECT 	DISTINCT A.cve_cliente_kwx, "+
									"A.nombre, "+ 
									"A.razon_social,  "+
									"UPPER(A.calle) AS calle,  "+
									"UPPER(A.num_interno) AS num_interno,  "+
									"UPPER(A.num_externo) AS num_externo,  "+
									"UPPER(A.colonia) AS colonia,  "+
									"UPPER(A.cve_delegacion) AS cve_delegacion,  "+
									"UPPER(C.descripcion) AS delegacion,  "+
									"A.cp,  "+
									"A.id_cve_edo,  "+
									"A.telefono,  "+
									"A.correo_electronico,  "+
									
									"TRIM(A.latitud) AS latitud,  "+
									"TRIM(A.longitud) AS longitud,  "+
									"''  AS cve_producto_kwx," +
									"A.telefono_whatsapp AS tel_Whatsapp,  "+
									"A.cve_cliente_may,  "+
									"A.coordenadas  "+
						" FROM 		KWX.c_clientes_kwx  AS A "+
									"JOIN KWX.c_cliente_producto_Kwx AS B ON A.cve_cliente_kwx = B.cve_cliente_kwx " +
									"LEFT JOIN KWX.c_delegaciones AS C ON A.cve_delegacion = C.cve_delegacion " ;
							
			
				if(articulo > 0 && estado > 0)
				{
					Qry += " WHERE	A.id_cve_edo ='"+ estado +"' "+
									"AND B.cve_producto_kwx = '" +  articulo + "' " ;
					if(delegacion > 0)
					{
						Qry += " AND A.cve_delegacion = '" +  delegacion + "' " ; 
					}
					Qry += " ORDER BY  A.cve_cliente_kwx ASC";
				}
				else if(articulo > 0 && estado <= 0 )
				{
					Qry += " WHERE  B.cve_producto_kwx = '" +  articulo + "' " ;
					
					if(delegacion > 0)
					{
						Qry += " AND A.cve_delegacion = '" +  delegacion + "' " ; 
					}
				
					Qry +=" ORDER BY  A.cve_cliente_kwx ASC";
				}
				else if (articulo <= 0 && estado > 0 )	
				{
					Qry += " WHERE	A.id_cve_edo ='"+ estado +"' ";
					if(delegacion > 0)
					{
						Qry += " AND A.cve_delegacion = '" +  delegacion + "' " ; 
					}
						
					Qry += " ORDER BY  A.cve_cliente_kwx ASC";
				}
				else if(articulo == 0 && estado == 0)
				{
					Qry += " ORDER BY  A.cve_cliente_kwx ASC";
				}
					
			//	System.out.println("7 query = " + Qry);
				
			ResultSet rs_ctes= CrearConexionBaseDatos(Qry);		
						
			if(rs_ctes != null)
			{	
	    		while (rs_ctes.next())
	    		{
		    		try
		    		{
		    			String direc= rs_ctes.getString("calle");
		    			direc += (rs_ctes.getString("num_externo") != "" && rs_ctes.getString("num_externo")!= null)? ", " +  rs_ctes.getString("num_externo"): "" ; 
		    			direc += (rs_ctes.getString("colonia") != "" && rs_ctes.getString("colonia")!= null)? ", " +  rs_ctes.getString("colonia"): "" ; 
		    			direc += (rs_ctes.getString("delegacion") != "" && rs_ctes.getString("delegacion")!= null)? ", " +  rs_ctes.getString("delegacion"): "" ; 
		    			direc += (rs_ctes.getString("cp") != "" && rs_ctes.getString("cp")!= null)? ", C.P. " +  rs_ctes.getString("cp"): "" ;
		    					
		    			clientesKwxDto cte= new clientesKwxDto();
		    			cte.setCve_cliente(rs_ctes.getInt("cve_cliente_kwx"));
		    			cte.setNombre(rs_ctes.getString("nombre"));
		    			cte.setRazonSocial(rs_ctes.getString("razon_social"));
		    			cte.setCalle(rs_ctes.getString("calle"));
		    			cte.setNumInterno(rs_ctes.getString("num_interno"));
		    			cte.setNumExterno(rs_ctes.getString("num_externo"));
		    			cte.setColonia(rs_ctes.getString("colonia"));
		    			cte.setDelegacion(rs_ctes.getString("delegacion"));
		    			cte.setCp(rs_ctes.getString("cp"));
		    			cte.setDireccion(direc);
		    			cte.setId_cve_edo(rs_ctes.getInt("id_cve_edo"));
		    			cte.setTelefono(rs_ctes.getString("telefono"));
		    			cte.setCorreoElectronico(rs_ctes.getString("correo_electronico"));
		    			cte.setLatitud(rs_ctes.getString("latitud"));
		    			cte.setLongitud(rs_ctes.getString("longitud"));
		    			cte.setTel_Whatsapp(rs_ctes.getString("tel_Whatsapp"));
		    			cte.setCve_producto_kwx(rs_ctes.getInt("cve_producto_kwx"));
		    			cte.setCoordenadas(rs_ctes.getString("coordenadas"));
		    			listClientes.add(cte);
		    			
		    		}
		    		catch(Exception ex)
		    		{
		    			String sError= ex.getMessage().toString();
		    			CierraConexion();
		    		}
	    		}
			}
			CierraConexion();
		}
		catch(Exception ex)
		{
			String sError= ex.getMessage().toString();
		}
		
	//	System.out.println("8 query = " + listClientes.size());		
		return listClientes;
	}
	
	public List<EstadosDto> ObtieneEstados()
	{
		List<EstadosDto> listEstados= new ArrayList<EstadosDto>();
		String Qry= "";
		try
		{
			 Qry= "SELECT  DISTINCT A.id_cve_edo, "+
								 "A.nombre  "+
						"FROM 	comercio_electronico.c_estados AS A "+
								"JOIN KWX.c_clientes_kwx AS B ON A.id_cve_edo = B.id_cve_edo  " +
								"ORDER BY A.nombre;";
			
			ResultSet rs_estados= CrearConexionBaseDatos(Qry);		
			
			if(rs_estados != null)
			{
	    		while (rs_estados.next())
	    		{
		    		try
		    		{
		    			EstadosDto estado= new EstadosDto();
		    			estado.setCve_estado(rs_estados.getInt("id_cve_edo"));
		    			estado.setDescripcion(rs_estados.getString("nombre"));
		    			listEstados.add(estado);
		    		}
		    		catch(Exception ex)
		    		{
		    			String sError= ex.getMessage().toString();
		    			CierraConexion();
		    		}
	    		}
			}
			CierraConexion();
		}
		catch(Exception e)
		{
			String sError = e.getMessage().toString();
			CierraConexion();
			clsLog.RegistraLog("ServletDondeComprar.ObtieneEstados", "qry: "+Qry.replace("'", ""));
			clsLog.RegistraLog("ServletDondeComprar.ObtieneEstados", "getLocalizedMessage: "+ e.getLocalizedMessage().replace("'", ""));
			clsLog.RegistraLog("ServletDondeComprar.ObtieneEstados", "getMessage: "+ e.getMessage().replace("'", ""));
			clsLog.RegistraLog("ServletDondeComprar.ObtieneEstados", "getCause: "+ e.getClass().getName().replace("'", ""));
			clsLog.RegistraLog("ServletDondeComprar.ObtieneEstados", "getClass().getName: "+ e.getLocalizedMessage().replace("'", ""));
		}
		
		return listEstados;
	}
	
	public List<productosKwxDto> ObtieneProductosKwx()
	{
		List<productosKwxDto> lisArticulos = new ArrayList<productosKwxDto>();
		try
		{
			String Qry= " SELECT * FROM KWX.c_producto_kwx;";
			ResultSet rs_art= CrearConexionBaseDatos(Qry);		
			
			if(rs_art != null)
			{
	    		while (rs_art.next())
	    		{
		    		try
		    		{
		    			productosKwxDto producto= new productosKwxDto();
		    			producto.setCve_producto_kwx(rs_art.getInt("cve_producto_kwx"));
		    			producto.setDescripcion(rs_art.getString("descripcion"));
		    			lisArticulos.add(producto);
		    		}
		    		catch(Exception ex)
		    		{
		    			String sError= ex.getMessage().toString();
		    			CierraConexion();
		    		}
	    		}
			}
			CierraConexion();
		}
		catch(Exception ex)
		{
			String sError = ex.getMessage().toString();
		}
		return lisArticulos;
	}
		
	public ResultSet CrearConexionBaseDatos(String sql)
	{
		ResultSet rs1= null;
		try
			{
				conn = connectionManagerV2.getConnection();
				pstmt = conn.prepareStatement(sql);
				rs1 = pstmt.executeQuery();
				
			}catch(Exception e)
			{
				CierraConexion();
				String sError= e.getMessage().toString();
				System.out.println("PortalRama KWX - ERROR EJECU. QUERY: " +  sError);
				clsLog.RegistraLog("PortalRama KWX - ServletDondeComprar.CrearConexionBaseDatos", "getLocalizedMessage: "+ e.getLocalizedMessage().replace("'", ""));
				clsLog.RegistraLog("PortalRama KWX - ServletDondeComprar.CrearConexionBaseDatos", "getMessage: "+ e.getMessage().replace("'", ""));
				clsLog.RegistraLog("PortalRama KWX - ServletDondeComprar.CrearConexionBaseDatos", "getCause: "+ e.getClass().getName().replace("'", ""));
				clsLog.RegistraLog("PortalRama KWX - ServletDondeComprar.CrearConexionBaseDatos", "getClass().getName: "+ e.getLocalizedMessage().replace("'", ""));
			}
		return rs1;
	}
	
	public void CierraConexion()
	{
		try
		{
			connectionManagerV2.closeConnection(conn);
			
		}catch(Exception e)
		{
			String sError= e.getMessage().toString();
			System.out.println("PortalRama KWX - ERROR: " +  sError);
			clsLog.RegistraLog("PortalRama KWX - ServletDondeComprar.CierraConexion", "getLocalizedMessage: "+ e.getLocalizedMessage().replace("'", ""));
			clsLog.RegistraLog("PortalRama KWX - ServletDondeComprar.CierraConexion", "getMessage: "+ e.getMessage().replace("'", ""));
			clsLog.RegistraLog("PortalRama KWX - ServletDondeComprar.CierraConexion", "getCause: "+ e.getClass().getName().replace("'", ""));
			clsLog.RegistraLog("PortalRama KWX - ServletDondeComprar.CierraConexion", "getClass().getName: "+ e.getLocalizedMessage().replace("'", ""));
		}
	}
	
	

}
