package com.cordina.PortalCordinaKwx;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cordina.PortalCordinaKwx.conexionBd.connectionManagerV2;
import com.cordina.PortalCordinaKwx.dto.EstadosDto;
import com.cordina.PortalCordinaKwx.dto.MecanicoDto;
import com.cordina.PortalCordinaKwx.dto.municipios;
import com.google.gson.Gson;

public class ServletBuscoMecanico extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Connection conn;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
    String DatosValidos = "";
  
    public ServletBuscoMecanico() {
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

	public void main(HttpServletRequest request, HttpServletResponse response)
	{
		try
		{
			//System.out.println(" 1. INICIO ServletBuscoMecanico");
			int operacion = 1;
			int producto = 0;
			String estado = "";
			int delegacion = 0;
			List<EstadosDto> listEstados= new ArrayList<EstadosDto>();
		
			//System.out.println(" 2. INICIO ServletBuscoMecanico");
			
			try
			{
				operacion = Integer.parseInt(request.getParameter("operacion"));
			}
			catch(Exception ex)
			{
				String sError= ex.getMessage().toString();
				System.out.println("PortalRama KWX - ServletBuscoMecanico ERROR: " + sError);
			}
			
			//System.out.println(" 3. INICIO ServletBuscoMecanico OPERACION= " + operacion);
			
			switch(operacion)
			{
				case 1: 
                      listEstados = ObtieneEstados();
		
					request.setAttribute("listEstados", listEstados);
					request.setAttribute("str_estado",0);
						RequestDispatcher rd = request.getRequestDispatcher("/jsp/BuscoMecanico.jsp");
						rd.forward(request, response);
				break;
				case 2:
					List<municipios>  listDelagaciones= new ArrayList<municipios>();
					try
					{ 
						estado = request.getParameter("cve_estado");
					//	System.out.println(" 2. INICIO ServletBuscoMecanico estado= " +estado);
						
					}
					catch(Exception ex)
					{
						String sError= ex.getMessage().toString();
						System.out.println(" PortalRama KWX - INICIO ServletBuscoMecanico Error estado= " + sError);
						
					}
					listDelagaciones = ObtieneDelegaciones(estado);
					
					request.setAttribute("listMunicipios", listDelagaciones);
					
					Gson gson = new Gson();
					String listaJson =gson.toJson(listDelagaciones);
					response.setContentType("application/json");
					PrintWriter out = response.getWriter();
					out.write(listaJson);
				//	System.out.println(" 5. LIST DEL = " + listDelagaciones.size());
				
				break;
		case 3:
			List<MecanicoDto>  listaMecanicos= new ArrayList<MecanicoDto>();
			String est="";
			String mun="";
			String Domicilio="";
			try
			{ 
				est = request.getParameter("cve_delegacion");
				mun = request.getParameter("cve_numcipio");
				Domicilio = request.getParameter("cve_domicilio");
				
			}
			catch(Exception ex)
			{
				String sError= ex.getMessage().toString();
				System.out.println("PortalRama KWX - INICIO ServletBuscoMecanico Error estado= " + sError);
				
			}
			listaMecanicos = ObtieneMecanicos(est,mun,Domicilio);
			
			request.setAttribute("listaMecanicos", listaMecanicos);
			
			Gson gson3 = new Gson();
			String listaJsonM =gson3.toJson(listaMecanicos);
			response.setContentType("application/json");
			PrintWriter out3 = response.getWriter();
			out3.write(listaJsonM);
		//	System.out.println(" 5. LIST DEL = " + listaMecanicos.size());
		break;
	}
			
		}
		catch(Exception ex)
		{
			String sError= ex.getMessage().toString();
			System.out.println("PortalRama KWX - ServletSoyMecanico error= " + sError);
			
		}
	}



	private List<MecanicoDto> ObtieneMecanicos(String estado, String municipio, String servicioADomicilio ) {
		List<MecanicoDto> listDelagaciones= new ArrayList<MecanicoDto>();
		try
		{
			String Qry = "SELECT estado, municipio, colonia, cp, calle,num_ext, num_int,nombre_taller,nombre_encargado,servicio_a_domicilo, telefono, whatsapp,email,fotografia,recibir_informacion, latitud,longitud"
                        + " FROM KWX.c_mecanicos  where estatus ='V' and estado = '"+estado+"' and municipio = '"+ municipio;
			
			if (!servicioADomicilio.equalsIgnoreCase("T")){
				Qry += "' and servicio_a_domicilo= '"+servicioADomicilio;
			}
			Qry += "';";
			
			//System.out.println(Qry);
			ResultSet rs_del= CrearConexionBaseDatos(Qry);	
	
			if(rs_del != null)
			{	
				//System.out.println("entro resulset ObtieneMecanicos");
	    		while (rs_del.next())
	    		{
		    		try
		    		{
		    			MecanicoDto m = new MecanicoDto();
		    			m.setEstado(rs_del.getString("estado"));
		    			m.setMunicipio(rs_del.getString("municipio"));
		    			m.setColonia(rs_del.getString("colonia"));
		    			m.setCp(rs_del.getString("cp"));
		    			m.setCalle(rs_del.getString("calle"));
		    			m.setNumExt(rs_del.getString("num_ext"));
		    			m.setNumInt(rs_del.getString("num_int"));
		    			m.setNombreTaller(rs_del.getString("nombre_taller"));
		    			m.setNombreEncargado(rs_del.getString("nombre_encargado"));
		    			m.setServicioDomicilo(rs_del.getString("servicio_a_domicilo"));
		    			m.setTelefono(rs_del.getString("telefono"));
		    			m.setWhatsapp(rs_del.getString("whatsapp"));
		    			m.setEmail(rs_del.getString("email"));
		    			m.setFotografia(rs_del.getString("fotografia"));
		    			m.setRecibirInformacion(rs_del.getString("recibir_informacion"));
		    			m.setLatitud(rs_del.getString("latitud"));
		    			m.setLongitud(rs_del.getString("longitud"));
		    			//System.out.println(m);
		    			listDelagaciones.add(m);
		    			//System.out.println(m);
		    		}
		    		catch(Exception ex)
		    		{
		    			String sError= ex.getMessage().toString();
		    			System.out.println("PortalRama KWX - error seultset resulset" + ex);
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


	private List<municipios>  ObtieneDelegaciones(String Estado) {
		
		List<municipios> listDelagaciones= new ArrayList<municipios>();
		try
		{
			String Qry = "SELECT distinct municipio FROM KWX.c_mecanicos where  estatus ='V' and estado = '"+Estado.trim()+"';";
		//	System.out.println(Qry);
			ResultSet rs_del= CrearConexionBaseDatos(Qry);	
	
			if(rs_del != null)
			{	
			//	System.out.println("entro resulset");
	    		while (rs_del.next())
	    		{
		    		try
		    		{
		    			municipios m = new municipios();
		    			m.setDescripcion(rs_del.getString("municipio"));
		    			listDelagaciones.add(m);
		    		//	System.out.println(" 2. INICIO ServletBuscoMecanico municipio= " +rs_del.getString("municipio") );
						
		    		}
		    		catch(Exception ex)
		    		{
		    			String sError= ex.getMessage().toString();
		    			System.out.println("PortalRama KWX - listDelagaciones resulset" + ex);
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

	public List<EstadosDto> ObtieneEstados()
	{
		List<EstadosDto> listEstados= new ArrayList<EstadosDto>();
		
		try
		{
			String Qry= "SELECT distinct estado FROM KWX.c_mecanicos where estatus ='V';";
			
						ResultSet rs_estados= CrearConexionBaseDatos(Qry);		
			int c =0;
			if(rs_estados != null)
			{
	    		while (rs_estados.next())
	    		{
		    		try
		    		{
		    			c++;
		    			EstadosDto estado= new EstadosDto();
		    			estado.setCve_estado(c);
		    			estado.setDescripcion(rs_estados.getString("estado"));
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
		catch(Exception ex)
		{
			String sError = ex.getMessage().toString();
		}
		
		return listEstados;
	}

	public ResultSet CrearConexionBaseDatos(String sql)
	{
		ResultSet rs1= null;
		try
			{
				conn = connectionManagerV2.getConnection();
				pstmt = conn.prepareStatement(sql);
				rs1 = pstmt.executeQuery();
				
			}catch(Exception ex)
			{
				CierraConexion();
				String sError= ex.getMessage().toString();
				System.out.println("PortalRama KWX - ERROR EJECU. QUERY: " +  sError);
			}
		return rs1;
	}

	public int CrearConexionBaseDatosInsert(String sql)
	{
    	int isInsertadoAc= 0;
		try
			{
				conn = connectionManagerV2.getConnection();
				pstmt = conn.prepareStatement(sql);
	    		isInsertadoAc =pstmt.executeUpdate();
			}catch(Exception ex)
			{
				CierraConexion();
				String sError= ex.getMessage().toString();
				System.out.println("PortalRama KWX - ERROR EJECU. QUERY: " +  sError);
			}
		return isInsertadoAc;
	}

	public void CierraConexion()
	{
		try
		{
			connectionManagerV2.closeConnection(conn);
			
		}catch(Exception ex)
		{
			String sError= ex.getMessage().toString();
			System.out.println("PortalRama KWX - ERROR: " +  sError);
		}
	}
}
