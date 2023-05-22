package com.cordina.PortalCordinaKwx;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Arrays;
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


public class ServletDondeComprar extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private Connection conn;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
    public ServletDondeComprar() {
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
			// System.out.println(" ServletDondeComprar 1. INICIO");
			int operacion = 1;
			int producto = 0;
			int estado = 0;
			int pais = 1;
			int delegacion = 0;
			String cp = "";
			String km = "";
			String lat = "";
			String longi = "";
			
			List<EstadosDto> listEstados= new ArrayList<EstadosDto>();
			List<productosKwxDto> lisArticulos = new ArrayList<productosKwxDto>();
			List<DelegacionDto> listDelegaciones= new ArrayList<DelegacionDto>();
			
			List<clientesKwxDto> listClientes= new ArrayList<clientesKwxDto>();
			
		 	// System.out.println("ServletDondeComprar 2. INICIO");
			
			try
			{
				operacion = Integer.parseInt(request.getParameter("operacion"));
			}
			catch(Exception ex)
			{
				String sError= ex.getMessage().toString();
				System.out.println("PortalRama KWX - ERROR: " + sError);
			}
			
		    // System.out.println("ServletDondeComprar: INICIO OPERACION= " + operacion);
			
			switch(operacion)
			{
				case 1:

					lisArticulos = ObtieneProductosKwx();
					listClientes = ObtieneClientesKwx(0,pais);
					request.setAttribute("listEstados", "");
					request.setAttribute("lisArticulos",lisArticulos);
					request.setAttribute("listClientes",listClientes);
					request.setAttribute("str_estado",0);
					request.setAttribute("str_producto",0);
					request.setAttribute("str_delegacion",0);
					request.setAttribute("latitud2", "");
					request.setAttribute("pais", "1");
					request.setAttribute("longitud2", "");
				
					request.setAttribute("distRecorr", "");
					request.setAttribute("listaCliente", "");
					RequestDispatcher rd = request.getRequestDispatcher("/jsp/DondeComprar.jsp");
					rd.forward(request, response);
				break;
				
				case 2:			
					List<EstadosDto> listEdos= new ArrayList<EstadosDto>();
					try
					{
						producto = Integer.parseInt(request.getParameter("Producto"));
						km = request.getParameter("km");
						lat = request.getParameter("lat");
						longi = request.getParameter("longi");
						cp = request.getParameter("cp");
						pais = Integer.parseInt(request.getParameter("pais"));
						//System.out.println(pais);
					}
					catch(Exception ex)
					{
						String sError= ex.getMessage().toString();
						System.out.println("PortalRama KWX - ERROR: " + sError);
					}

					lisArticulos = ObtieneProductosKwx();
					if(km != null) {
						listClientes = ObtieneClientesKwx(producto,pais);
					}

					request.setAttribute("listEstados", "");
					request.setAttribute("lisArticulos",lisArticulos);
					request.setAttribute("listClientes",listClientes);
					request.setAttribute("str_estado",estado);
					if(producto == 0 && lat != null && longi != null) {
						producto = 10000;
					}
					request.setAttribute("str_producto",producto);
					request.setAttribute("str_delegacion",delegacion);
					request.setAttribute("distRecorr", km);
					if(lat == null) {
						lat = "19.3478575";
					}
					request.setAttribute("latitud2", lat);
					if(km.equals("999999999") && cp == null) {	
						request.setAttribute("longitud2", "-99.1160392");
					}else {
						request.setAttribute("longitud2", longi);
					}
					if(cp == null) {
						cp = "";
					}
					request.setAttribute("pais", pais);
					request.setAttribute("cp", cp);
					
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
					
					//System.out.println(" 4. ESTADO = " + estado);
					//listDelagaciones = ObtieneDelgacionPorEstado(estado);
					request.setAttribute("listDelagaciones", listDelagaciones);
					Gson gson = new Gson();
					String listaJson =gson.toJson(listDelagaciones);
					response.setContentType("application/json");
					PrintWriter out = response.getWriter();
					out.write(listaJson);
					//System.out.println(" 5. LIST DEL = " + listDelagaciones.size());
					
					break;
				case 4:
										
					String listaCliente = request.getParameter("listaCliente");
					listaCliente = listaCliente.substring(0,listaCliente.length()-1);
					producto = Integer.parseInt(request.getParameter("producto"));
					if(producto == 10000) {
						producto = 0;
					}
					String listaKM = request.getParameter("listaKM");
					listaKM = listaKM.substring(0,listaKM.length()-1);		
					
					
					String[] numkms = listaKM.split(",");
					String[] cliente = listaCliente.split(","); 				

				      double [] intArray = new double[numkms.length];
				      String vector = "";
				      for(int i = 0; i < numkms.length; i++) {
				    	  
				         intArray[i] = Double.parseDouble(numkms[i]);
				         vector += intArray[i] +"-"+ cliente[i]+",";
				      }
				      /*Metodo para ordenar la lista de los KMs*/
				      Arrays.sort(intArray);
				      String kmOrden = Arrays.toString(intArray);
				      
				      kmOrden = kmOrden.substring(1, kmOrden.length() - 1);
				      
				      String[] kmordenLis = kmOrden.split(",");
				      String[] vectorLis = vector.split(",");
				      
				      String clientesOrden = "";
				      /*Metodo para ordenar los clientes*/
				      for(int i = 0; i<kmordenLis.length;i++) {
				    	  for(int j = 0;j<vectorLis.length;j++) {
					    	  String[] SplitVector = vectorLis[j].split("-");
					    	  String kmVector = SplitVector[0];
					    	  String clienVector = SplitVector[1];
					    	  kmordenLis[i] = kmordenLis[i].replace(" ", "");

				    		  if(kmordenLis[i].equalsIgnoreCase(kmVector)) {
					    			  clientesOrden += clienVector+",";
					    	  }
					    		  
				    	  }				    	  
				      }
				      /*METODO PARA ELIMINAR PALABRAS REPETIDAS DE LA CADENA ACUMULADA*/
				      String[] splitClientesOrden = clientesOrden.split(",");
				      String result = "";
				      
				      for(int i=0; i<splitClientesOrden.length; i++) {
							for(int j=i+1; j<splitClientesOrden.length; j++) {
								if(splitClientesOrden[i].equals(splitClientesOrden[j])) {
									splitClientesOrden[j] = "remove";
								}
							}
					  }
				      
				      for(String word: splitClientesOrden) {
							if(word != "remove") {
								result = result + word + ",";
							}
						}
				      /*METODO PARA ELIMINAR EL ULTIMO CARACTER DE LA CADENA*/
				      String clientesOrdenados = result.substring(0,result.length()-1);
				      clientesOrden = clientesOrden.substring(0,clientesOrden.length()-1);

					if(listaCliente != null && listaKM != null) {
						listClientes = ObtieneClientesKwxEspecificos(producto, clientesOrdenados, kmOrden,pais);
						lisArticulos = ObtieneProductosKwx();						
					}					 
					request.setAttribute("latitud2", "");
					request.setAttribute("longitud2", "");
					request.setAttribute("listEstados", "");
					request.setAttribute("lisArticulos",lisArticulos);
					request.setAttribute("listClientes",listClientes);
					request.setAttribute("str_estado",0);
					request.setAttribute("str_producto",0);
					request.setAttribute("str_delegacion",0);
					request.setAttribute("listaCliente", listaCliente);
					request.setAttribute("kmOrden", kmOrden); 
					/*METODO PARA CREAR LISTAS DE JSON Y MANDAR RESPUESTA AL AJAX*/
					JSONObject person = new JSONObject();
					  person.put("LISCLIEN", listClientes);
					  
					  //JSONObject JsoninfoUsu = new JSONObject(kmOrden);
					  person.put("KMORDEN",  kmOrden);
					
					//Gson gson1 = new Gson();
					//String listaJson1 =gson1.toJson(listClientes);
					response.setContentType("application/json");
					PrintWriter out1 = response.getWriter();
					out1.write(person.toString());
					
					//RequestDispatcher rd2 = request.getRequestDispatcher("/jsp/DondeComprar.jsp");
					//rd2.forward(request, response);
				break;	
			default:
				//List<EstadosDto> listEdos= new ArrayList<EstadosDto>();
				try
				{
					lat = request.getParameter("lat");
					longi = request.getParameter("longi");
					pais = Integer.parseInt(request.getParameter("pais"));
					//System.out.println(pais);
				}
				catch(Exception ex)
				{
					String sError= ex.getMessage().toString();
					System.out.println("PortalRama KWX - ERROR: " + sError);
				}

				lisArticulos = ObtieneProductosKwx();
				if(km != null) {
					listClientes = ObtieneClientesKwx(producto,pais);
				}

				request.setAttribute("listEstados", "");
				request.setAttribute("lisArticulos",lisArticulos);
				request.setAttribute("listClientes",listClientes);
				request.setAttribute("str_estado",estado);
				if(producto == 0 && lat != null && longi != null) {
					producto = 10000;
				}
				request.setAttribute("str_producto",producto);
				request.setAttribute("str_delegacion",delegacion);
				request.setAttribute("distRecorr", km);
				if(lat == null) {
					lat = "19.3478575";
				}
				request.setAttribute("latitud2", lat);
				request.setAttribute("longitud2", longi);
				request.setAttribute("pais", pais);
				
				RequestDispatcher rd3 = request.getRequestDispatcher("/jsp/DondeComprar.jsp");
				rd3.forward(request, response);
				break;
			}
		}
		catch(Exception ex)
		{
			String sError= ex.getMessage().toString();
			System.out.println("Error en el main del ServletDondeComprar: " + sError);
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
	
	public List<clientesKwxDto> ObtieneClientesKwx(int articulo, int pais)
	{
		List<clientesKwxDto> listClientes= new ArrayList<clientesKwxDto>();
		Connection connBD = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try
		{
			String Qry = "	SELECT 	DISTINCT A.cve_cliente_kwx, "+
									"A.nombre, "+ 
									"A.razon_social,  "+
									"UPPER(A.calle) AS calle,  "+
									"UPPER(A.num_interno) AS num_interno,  "+
									"UPPER(A.num_externo) AS num_externo,  "+
									"UPPER(A.colonia) AS colonia,  "+
									"UPPER(A.cve_delegacion) AS cve_delegacion,  "+
									//"C.descripcion AS delegacion,  "+
									"UPPER(ifnull(s.municipio,'')) as delegacion, "+
									"UPPER(A.cp) AS cp,  "+
									"UPPER(A.id_cve_edo) AS id_cve_edo,  "+
									"A.telefono,  "+
									"IFNULL(A.correo_electronico,'') as correo_electronico,  "+
									
									"TRIM(A.latitud) AS latitud,  "+
									"TRIM(A.longitud) AS longitud,  "+
									"''  AS cve_producto_kwx," +
									"IFNULL(A.telefono_whatsapp,'') AS tel_Whatsapp, " + 
									"IFNULL(A.cve_cliente_may,'') as cve_cliente_may,  " + 
									"IFNULL(A.coordenadas ,'') as coordenadas   "+
						" FROM 		KWX.c_clientes_kwx  AS A "+
									"JOIN KWX.c_cliente_producto_Kwx AS B ON A.cve_cliente_kwx = B.cve_cliente_kwx " +
									"LEFT JOIN KWX.c_delegaciones AS C ON A.cve_delegacion = C.cve_delegacion " +
									" LEFT JOIN KWX.c_sepomex AS s ON s.id_cp = A.cp ";
			
				if(articulo > 0)
				{
					Qry += " WHERE  B.cve_producto_kwx = '" +  articulo + "' AND A.id_pais="+pais ;													
					Qry +=" ORDER BY  A.cve_cliente_kwx ASC";
				}				
				else if(articulo == 0)
				{
					Qry += " WHERE A.id_pais='"+pais+"' ORDER BY  A.cve_cliente_kwx ASC";
				}
			//	System.out.println(Qry);						
			connBD = connectionManagerV2.getConnection();
			pstmt = connBD.prepareStatement(Qry);
			rs = pstmt.executeQuery();
			if(rs != null)
			{	
	    		while (rs.next())
	    		{
		    		try
		    		{
		    			String direc= rs.getString("calle");
		    			direc += (rs.getString("num_externo") != "" && rs.getString("num_externo")!= null)? ", " +  rs.getString("num_externo"): "" ; 
		    			direc += (rs.getString("colonia") != "" && rs.getString("colonia")!= null)? ", " +  rs.getString("colonia"): "" ; 
		    			direc += (rs.getString("delegacion") != "" && rs.getString("delegacion")!= null)? ", " +  rs.getString("delegacion"): "" ; 
		    			direc += (rs.getString("cp") != "" && rs.getString("cp")!= null)? ", C.P. " +  rs.getString("cp"): "" ;
		    					
		    			clientesKwxDto cte= new clientesKwxDto();
		    			cte.setCve_cliente(rs.getInt("cve_cliente_kwx"));
		    			cte.setNombre(rs.getString("nombre"));
		    			cte.setRazonSocial(rs.getString("razon_social"));
		    			cte.setCalle(rs.getString("calle"));
		    			cte.setNumInterno(rs.getString("num_interno"));
		    			cte.setNumExterno(rs.getString("num_externo"));
		    			cte.setColonia(rs.getString("colonia"));
		    			cte.setDelegacion(rs.getString("delegacion"));
		    			cte.setCp(rs.getString("cp"));
		    			cte.setDireccion(direc);
		    			cte.setId_cve_edo(rs.getInt("id_cve_edo"));
		    			cte.setTelefono(rs.getString("telefono"));
		    			cte.setCorreoElectronico(rs.getString("correo_electronico"));
		    			cte.setLatitud(rs.getString("latitud"));
		    			cte.setLongitud(rs.getString("longitud"));
		    			cte.setTel_Whatsapp(rs.getString("tel_Whatsapp"));
		    			cte.setCve_producto_kwx(rs.getInt("cve_producto_kwx"));
		    			cte.setCoordenadas(rs.getString("coordenadas"));
		    			listClientes.add(cte);
		    			
		    		}
		    		catch(Exception ex)
		    		{
		    			String sError= ex.getMessage().toString();
		    			System.out.println("Error en el Query: " + sError);
		    			//CierraConexion();
		    		}
	    		}
			}
			//CierraConexion();
		}
		catch(Exception ex)
		{
			String sError= ex.getMessage().toString();
			System.out.println("sError: "+sError);
		}finally {
			try {
			if(pstmt != null) {pstmt.close();}
			if(connBD != null) {connBD.close();}
			}catch(Exception ex) {
				System.out.println("Error al Cerrar la conexion de ObtieneClientesKwx: " + ex.toString());
			}
		}
			
		return listClientes;
	}
	
	public List<clientesKwxDto> ObtieneClientesKwxEspecificos(int articulo, String listaClientes, String listaKM,int pais)
	{
		List<clientesKwxDto> listClientes= new ArrayList<clientesKwxDto>();
		Connection connBD = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try
		{ 
			String[] cliente =  listaClientes.split(",");
			String clientes = "";
			/*METODO PARA ACOMODAR LOS CLIENTES PARA BUSCAR EN BD*/
			for(int i = 0; i < cliente.length; i++) {
				if(i == 0) {
					clientes += cliente[i];
				}else {
					clientes += " ,"+cliente[i];
				}
			}
			int contador = 0;
			String[] kms = listaKM.split(",");
			String ordenKm = "";
			for(int i = 0; i<kms.length;i++) {
				if(i == 0) {
					ordenKm += kms[i];
				}else {
					ordenKm += " ,"+kms[i];
				}
			}

			String[] km = ordenKm.split(",");
			String[] clien = clientes.split(",");
			String kmCliente = "";
			for(int i=0; i<clien.length;i++) {
				kmCliente += clien[i]+"-"+km[i]+",";
			}
			String[] kmClieneSep = kmCliente.split(",");
			
			String Qry = "	SELECT 	DISTINCT A.cve_cliente_kwx, "+
									"A.nombre, "+ 
									"A.razon_social,  "+
									"UPPER(A.calle) AS calle,  "+
									"UPPER(A.num_interno) AS num_interno,  "+
									"UPPER(A.num_externo) AS num_externo,  "+
									"UPPER(A.colonia) AS colonia,  "+
									"UPPER(A.cve_delegacion) AS cve_delegacion,  "+
									//"C.descripcion AS delegacion,  "+
									"UPPER(ifnull(s.municipio,'')) as delegacion, "+
									"A.cp,  "+
									"A.id_cve_edo,  "+
									"A.telefono,  "+
									"IFNULL(A.correo_electronico,'') as correo_electronico,  "+
									
									"TRIM(A.latitud) AS latitud,  "+
									"TRIM(A.longitud) AS longitud,  "+
									"''  AS cve_producto_kwx," +
									"IFNULL(A.telefono_whatsapp,'') AS tel_Whatsapp, " + 
									"IFNULL(A.cve_cliente_may,'') as cve_cliente_may,  " + 
									"IFNULL(A.coordenadas ,'') as coordenadas   "+
						" FROM 		KWX.c_clientes_kwx  AS A "+
									"JOIN KWX.c_cliente_producto_Kwx AS B ON A.cve_cliente_kwx = B.cve_cliente_kwx " +
									"LEFT JOIN KWX.c_delegaciones AS C ON A.cve_delegacion = C.cve_delegacion "+
									" LEFT JOIN KWX.c_sepomex AS s ON s.id_cp = A.cp ";
					if(articulo > 0 && !clientes.equals(""))
					{
						Qry += " WHERE  (B.cve_cliente_kwx in ("+clientes+") and B.cve_producto_kwx = '"+articulo+"') ";
						
					}				
					else if(articulo == 0 && !clientes.equals(""))
					{
						Qry += " WHERE A.cve_cliente_kwx in ("+clientes+") "; 						
					}
					else if(articulo > 0 && clientes.equals("")) 
					{
						Qry += " WHERE  B.cve_producto_kwx = '"+articulo+"'";
					}
					//System.out.println(Qry);
			connBD = connectionManagerV2.getConnection();
			pstmt = connBD.prepareStatement(Qry);
			rs = pstmt.executeQuery();		
			try
    		{
				if(rs != null)
				{	
					/*LLENADO DE DATOS*/
		    		while (rs.next())
		    		{	
		    				
			    			String direc= rs.getString("calle");
			    			direc += (rs.getString("num_externo") != "" && rs.getString("num_externo")!= null)? ", " +  rs.getString("num_externo"): "" ; 
			    			direc += (rs.getString("colonia") != "" && rs.getString("colonia")!= null)? ", " +  rs.getString("colonia"): "" ; 
			    			direc += (rs.getString("delegacion") != "" && rs.getString("delegacion")!= null)? ", " +  rs.getString("delegacion"): "" ; 
			    			direc += (rs.getString("cp") != "" && rs.getString("cp")!= null)? ", C.P. " +  rs.getString("cp"): "" ;
			    					
			    			clientesKwxDto cte= new clientesKwxDto();
			 
			    			for(int i = 0; i<kmClieneSep.length;i++) {
			    				String[] cliKm = kmClieneSep[i].split("-"); 
			    				String cli = cliKm[0];
			    				String kmSe = cliKm[1];		    	
			    				cli = cli.replace(" ", "");
			    				if(cli.equalsIgnoreCase(String.valueOf(rs.getInt("cve_cliente_kwx")))) {
			    					cte.setKm(kmSe);
			    					cte.setCve_cliente(rs.getInt("cve_cliente_kwx"));
					    			cte.setNombre(rs.getString("nombre"));
					    			cte.setRazonSocial(rs.getString("razon_social"));
					    			cte.setCalle(rs.getString("calle"));
					    			cte.setNumInterno(rs.getString("num_interno"));
					    			cte.setNumExterno(rs.getString("num_externo"));
					    			cte.setColonia(rs.getString("colonia"));
					    			cte.setDelegacion(rs.getString("delegacion"));
					    			cte.setCp(rs.getString("cp"));
					    			cte.setDireccion(direc);
					    			cte.setId_cve_edo(rs.getInt("id_cve_edo"));
					    			cte.setTelefono(rs.getString("telefono"));
					    			cte.setCorreoElectronico(rs.getString("correo_electronico"));
					    			cte.setLatitud(rs.getString("latitud"));
					    			cte.setLongitud(rs.getString("longitud"));
					    			cte.setTel_Whatsapp(rs.getString("tel_Whatsapp"));
					    			cte.setCve_producto_kwx(rs.getInt("cve_producto_kwx"));
					    			cte.setCoordenadas(rs.getString("coordenadas"));
					    			listClientes.add(cte);		    					
			    					
				    			}
			    			}				    	   			
			    			contador +=1;
			    		
		    		}
				}				
			}
    		catch(Exception ex)
    		{
    			String sError= ex.toString();
    			System.out.println("Error en ObtieneClientesKwxEspecificos en el Query: " + sError);
    			//CierraConexion();
    		}
		}
		catch(Exception ex)
		{
			String sError= ex.getMessage().toString();
			System.out.println("ObtieneClientesKwxEspecificos.sError: "+ex.toString()); 
			System.out.println("ObtieneClientesKwxEspecificos.sError: "+sError);
		}finally {
			try {
				if(pstmt != null) {pstmt.close();}
				if(connBD != null) { connBD.close();}
			}catch(Exception e) {
				System.out.println("Error ObtieneClientesKwxEspecificos al cerrar la conexion: " + e.toString());
			}
			
		}
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
		Connection connBD = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try
		{
			String Qry= " SELECT cve_producto_kwx, descripcion FROM KWX.c_producto_kwx;";
			//ResultSet rs_art= CrearConexionBaseDatos(Qry);		
			connBD = connectionManagerV2.getConnection();
			pstmt = connBD.prepareStatement(Qry);
			rs = pstmt.executeQuery();
			if(rs != null)
			{
	    		while (rs.next())
	    		{
		    		try
		    		{
		    			productosKwxDto producto= new productosKwxDto();
		    			producto.setCve_producto_kwx(rs.getInt("cve_producto_kwx"));
		    			producto.setDescripcion(rs.getString("descripcion"));
		    			lisArticulos.add(producto);
		    		}
		    		catch(Exception ex)
		    		{
		    			String sError= ex.getMessage().toString();
		    			System.out.println("Error en ObtieneProductosKwx Al consultar: " + sError);
		    			//CierraConexion();
		    		}
	    		}
			}
			//CierraConexion();
		}
		catch(Exception ex)
		{
			String sError = ex.getMessage().toString();
			System.out.println("Error en ObtieneProductosKwx: En el QUERY: " + sError);
			//CierraConexion();
		}finally {
			try {
				if(pstmt != null) {pstmt.close();}
				if(connBD != null) {connBD.close();}
			}catch(Exception e){
				System.out.println("Error al cerrar conexion: " + e.toString());
			}
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
