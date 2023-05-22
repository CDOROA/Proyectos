package com.cordina.PortalCordinaKwx;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cordina.PortalCordinaKwx.Correo.SendEmailEvaluacion;
import com.cordina.PortalCordinaKwx.Correo.SendEmailEvaluacionV2;
import com.cordina.PortalCordinaKwx.conexionBd.connectionManagerV2;
import com.cordina.PortalCordinaKwx.dto.EstadosDto;
import com.cordina.PortalCordinaKwx.dto.MecanicoDto;
import com.cordina.PortalCordinaKwx.dto.municipios;
import com.google.gson.Gson;

/**
 * Servlet implementation class ServletEvaluarMecanico
 */
public class ServletEvaluarMecanico extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Connection conn;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
    String DatosValidos = "";

	public ServletEvaluarMecanico() {
		super();

	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
        response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
        response.setHeader("Expires", "-1"); // Proxies.

		main(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
        response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
        response.setHeader("Expires", "-1"); // Proxies.

		main(request, response);
	}

	public void main(HttpServletRequest request, HttpServletResponse response)
	{
		try
		{
			// System.out.println(" 1. INICIO ServletEvaluarMecanico");
			int operacion = 1;

			String estado = "";

			List<EstadosDto> listEstados= new ArrayList<EstadosDto>();

			try
			{
				operacion = Integer.parseInt(request.getParameter("operacion"));
			}
			catch(Exception ex)
			{
				String sError= ex.getMessage().toString();
				System.out.println("PortalRama KWX - ServletEvaluarMecanico ERROR: " + sError);
			}
			
			// System.out.println(" 3. INICIO ServletEvaluarMecanico OPERACION= " + operacion);
			
			switch(operacion)
			{
				case 1: 
                      listEstados = ObtieneEstados();
		
					request.setAttribute("listEstados", listEstados);
					request.setAttribute("str_estado",0);
					RequestDispatcher rd = request.getRequestDispatcher("/jsp/EvaluarMecanico.jsp");
					rd.forward(request, response);
				break;
				case 2:
					List<municipios>  listDelagaciones= new ArrayList<municipios>();
					try
					{ 
						estado = request.getParameter("cve_estado");
					}
					catch(Exception ex)
					{
						String sError= ex.getMessage().toString();
						System.out.println("PortalRama KWX - INICIO ServletEvaluarMecanico Error estado= " + sError);
						
					}
					listDelagaciones = ObtieneDelegaciones(estado);
					
					request.setAttribute("listMunicipios", listDelagaciones);
					
					Gson gson = new Gson();
					String listaJson =gson.toJson(listDelagaciones);
					response.setContentType("application/json");
					PrintWriter out = response.getWriter();
					out.write(listaJson);
break;
				case 3:
					List<MecanicoDto>  listaMecanicos= new ArrayList<MecanicoDto>();
					String est="";
					String mun="";

					try
					{ 
						est = request.getParameter("cve_delegacion");
						mun = request.getParameter("cve_numcipio");
						
					}
					catch(Exception ex)
					{
						String sError= ex.getMessage().toString();
						
					}
					listaMecanicos = ObtieneMecanicos(est,mun);
					
					request.setAttribute("listaMecanicos", listaMecanicos);
					
					Gson gson3 = new Gson();
					String listaJsonM =gson3.toJson(listaMecanicos);
					response.setContentType("application/json");
					PrintWriter out3 = response.getWriter();
					out3.write(listaJsonM);
				//	System.out.println(" 5. LIST DEL = " + listaMecanicos.size());
				break;
				case 4:
					String idTaller ="";
					String NombreTaller =""; 
					String requeriServicio ="";
					String cdmEntregoFicha ="";
					String cmbBaseDatosUtil ="";
					String cmbListaAtencion ="";
					String cmbListaCalidadTrabajo =""; 
					String cmbListaTiempoEntrega ="";
					String cmbListaSatisfechoTrabajo ="";
					String cmbListaRecomendarTaller ="";
					String cmbListallevarAuto ="";
					try
					{ 
						idTaller = request.getParameter("idTaller");
						NombreTaller = request.getParameter("NombreTaller"); 
						requeriServicio = request.getParameter("requeriServicio");
						cdmEntregoFicha = request.getParameter("cdmEntregoFicha");
						cmbBaseDatosUtil = request.getParameter("cmbBaseDatosUtil");
						cmbListaAtencion = request.getParameter("cmbListaAtencion");
						cmbListaCalidadTrabajo = request.getParameter("cmbListaCalidadTrabajo"); 
						cmbListaTiempoEntrega = request.getParameter("cmbListaTiempoEntrega");
						cmbListaSatisfechoTrabajo = request.getParameter("cmbListaSatisfechoTrabajo");
						cmbListaRecomendarTaller = request.getParameter("cmbListaRecomendarTaller");
						cmbListallevarAuto = request.getParameter("cmbListallevarAuto");
						
						 CargaInformacionBD(idTaller ,
									 NombreTaller , 
									 requeriServicio ,
									 cdmEntregoFicha ,
									 cmbBaseDatosUtil ,
									 cmbListaAtencion ,
									 cmbListaCalidadTrabajo , 
									 cmbListaTiempoEntrega ,
									 cmbListaSatisfechoTrabajo ,
									 cmbListaRecomendarTaller ,
									 cmbListallevarAuto);
						 
						 EnviarCorreoContacto(request,response,idTaller ,
								 NombreTaller , 
								 requeriServicio ,
								 cdmEntregoFicha ,
								 cmbBaseDatosUtil ,
								 cmbListaAtencion ,
								 cmbListaCalidadTrabajo , 
								 cmbListaTiempoEntrega ,
								 cmbListaSatisfechoTrabajo ,
								 cmbListaRecomendarTaller ,
								 cmbListallevarAuto);
						 
						 request.setAttribute("terminado", "terminado");
						 List<MecanicoDto>  listaMecanicos4= new ArrayList<MecanicoDto>();
							Gson gson4 = new Gson();
							String listaJsonM4 =gson4.toJson(listaMecanicos4);
							response.setContentType("application/json");
							PrintWriter out4 = response.getWriter();
							out4.write(listaJsonM4);
						
					}
					catch(Exception ex)
					{
						String sError= ex.getMessage().toString();
						
					}
					break;
	}
			
		}
		catch(Exception ex)
		{
			String sError= ex.getMessage().toString();
			System.out.println("PortalRama KWX - ServletSoyMecanico error= " + sError);
			
		}
	}
	

	public List<EstadosDto> ObtieneEstados()
	{
		List<EstadosDto> listEstados= new ArrayList<EstadosDto>();
		
		try
		{
			String Qry= "SELECT distinct estado FROM KWX.c_mecanicos;";
			
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
	
private List<municipios>  ObtieneDelegaciones(String Estado) {
		
		List<municipios> listDelagaciones= new ArrayList<municipios>();
		try
		{
			String Qry = "SELECT distinct municipio FROM KWX.c_mecanicos where estado = '"+Estado.trim()+"';";
			
			ResultSet rs_del= CrearConexionBaseDatos(Qry);	
	
			if(rs_del != null)
			{	
				
	    		while (rs_del.next())
	    		{
		    		try
		    		{
		    			municipios m = new municipios();
		    			m.setDescripcion(rs_del.getString("municipio"));
		    			listDelagaciones.add(m);
		    			
						
		    		}
		    		catch(Exception ex)
		    		{
		    			String sError= ex.getMessage().toString();
		    			System.out.println("PortalRama KWX - Error seultset resulset" + ex);
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

private List<MecanicoDto> ObtieneMecanicos(String estado, String municipio) {
	List<MecanicoDto> listDelagaciones= new ArrayList<MecanicoDto>();
	try
	{
		String Qry = "SELECT id_mecanico,estado, municipio, colonia, cp, calle,num_ext, num_int,nombre_taller,nombre_encargado,servicio_a_domicilo, telefono, whatsapp,email,fotografia,recibir_informacion, latitud,longitud"
                    + " FROM KWX.c_mecanicos  where estado = '"+estado+"' and municipio = '"+ municipio+"';";
		
		// System.out.println(Qry);
		ResultSet rs_del= CrearConexionBaseDatos(Qry);	

		if(rs_del != null)
		{	
			//System.out.println("entro resulset ObtieneMecanicos");
    		while (rs_del.next())
    		{
	    		try
	    		{
	    			MecanicoDto m = new MecanicoDto();
	    			m.setIdMecanico(rs_del.getInt("id_mecanico"));
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
	    			System.out.println("PortalRama KWX - Error seultset resulset" + ex);
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

private int CargaInformacionBD(String idTaller ,
		String NombreTaller , 
		String requeriServicio ,
		String cdmEntregoFicha ,
		String cmbBaseDatosUtil ,
		String cmbListaAtencion ,
		String cmbListaCalidadTrabajo , 
		String cmbListaTiempoEntrega ,
		String cmbListaSatisfechoTrabajo ,
		String cmbListaRecomendarTaller ,
		String cmbListallevarAuto) {
	 int Resultado =0;
	try
	{
		DateFormat df = new SimpleDateFormat("yyy-MM-dd");
		Date FechaAct = new Date();
		String Fecha= df.format(FechaAct);
		
		DateFormat df2 = new SimpleDateFormat("hh:mm:ss");
		Date FechaAct2 = new Date();
		String Hora= df2.format(FechaAct2);
		String nombreTaller2=NombreTaller.trim();
		if (NombreTaller.length() >40)
		{
			nombreTaller2 =NombreTaller.substring(1,40);
		}
		nombreTaller2 += "|" + requeriServicio;
	
	//	System.out.println("CargaInformacionBD... 1");
		String Qry= "INSERT INTO KWX.t_evaluacion_mecanico (id_mecanico, fecha, hora, nombre_taller,servicio_domicilio, entrego_ficha," +
				" atencion, calidad_trabajo, tiempo_entraga, satisfecho_con_trabajo," +
				" recomendar_taller, volveria_llevar_auto, base_datos_util) VALUES (" +
				"'"+idTaller+"', '"+Fecha+"', '"+Hora+"', '"+NombreTaller+"', '"+requeriServicio+"','"+cdmEntregoFicha+"'," +
				"'"+cmbListaAtencion+"', '"+cmbListaCalidadTrabajo+"', '"+cmbListaTiempoEntrega+"', '"+cmbListaSatisfechoTrabajo+"', " +
				"'"+cmbListaRecomendarTaller+"', '"+cmbListallevarAuto+"', '"+cmbBaseDatosUtil+"');";
	//	System.out.println("CargaInformacionBD... 2: "+ Qry);
	
    Resultado = CrearConexionBaseDatosInsert(Qry);		
//	System.out.println("CargaInformacionBD... 3");
//	System.out.println("resultado insert: "+ Resultado);

      CierraConexion();
	//	System.out.println("CargaInformacionBD... 4");
	}
	catch(Exception ex)
	{
		String sError = ex.getMessage().toString();
		
		System.out.println("PortalRama KWX - CargaInformacionBD error: "+ sError);
		return 0;
	}
	return Resultado;
}
public void EnviarCorreoContacto(HttpServletRequest request, HttpServletResponse response,String idTaller ,
		String NombreTaller , 
		String requeriServicio ,
		String cdmEntregoFicha ,
		String cmbBaseDatosUtil ,
		String cmbListaAtencion ,
		String cmbListaCalidadTrabajo , 
		String cmbListaTiempoEntrega ,
		String cmbListaSatisfechoTrabajo ,
		String cmbListaRecomendarTaller ,
		String cmbListallevarAuto)
{
	try
	{
		if(cmbBaseDatosUtil.equalsIgnoreCase("1")){
			cmbBaseDatosUtil ="S";
		}else{
			cmbBaseDatosUtil="N";
		}
		if(cmbListallevarAuto.equalsIgnoreCase("1")){
			cmbListallevarAuto ="S";
		}else
		{
			cmbListallevarAuto="N";
		}
		
		DateFormat df = new SimpleDateFormat("dd 'de' MMMM 'de' yyyy hh:mm:ss aaa");
		Date FechaAct = new Date();
		String Fecha= df.format(FechaAct);
		
		response.setContentType("text/html;charset=ISO-8859-1");	  
        String to ="armando.rosas@corprama.com.mx"; 
        String subject = " Evaluacion a Mecanico " + Fecha;
        
      
        String message = "<b><font size =\"2\" face=\"Arial\">" + Fecha + "</font></b><br><br>";
		message += "<font size =\"2\" face=\"Arial\">Buen Día</font><br><br><br>";
		message += "<font size =\"2\" face=\"Arial\">Se les informa que se ha evaluado un taller mecanico</font> <br><br><br>" ;
		
		message +="<table id=\"table_cdf\" style=\"border:1px solid black;border-collapse:collapse; \" width=\"50%\">" +			
				"<tr>" +
					"<td  width=\"50%\" align='center' style=\"border:1px solid black;border-collapse:collapse; background-color:#CCCCCC; color:black \" ><b><font size =\"1\" face=\"Arial\"> DATO </font></b></td>" +
					"<td  width=\"50%\" align='center' style=\"border:1px solid black;border-collapse:collapse; background-color:#CCCCCC; color:black \" ><b><font size =\"1\" face=\"Arial\"> RESPUESTA </font></b></td>" +
				"</tr>" +					
				
				"<tr>" +
					"<td  width=\"50%\" align='left' style=\"border:1px solid black;border-collapse:collapse;\" ><b><font size =\"1\" face=\"Arial\"> Nombre del taller: </font></b></td>" +
					"<td  width=\"50%\" align='left' style=\"border:1px solid black;border-collapse:collapse;\" ><font size =\"0\" face=\"Arial\"><font size =\"1\" face=\"Arial\">"+ NombreTaller + "</font></font></td>" +
				"</tr>" +
				"<tr>" +
					"<td  width=\"50%\" align='left' style=\"border:1px solid black;border-collapse:collapse;\" ><b><font size =\"1\" face=\"Arial\"> Acudí a Servicio a domicilio: </font></b></td>" +
					"<td  width=\"50%\" align='left' style=\"border:1px solid black;border-collapse:collapse;\" ><font size =\"0\" face=\"Arial\"><font size =\"1\" face=\"Arial\">"+ requeriServicio + "</font></font></td>" +
				"</tr>" +
				"<tr>" +
					"<td  width=\"50%\" align='left' style=\"border:1px solid black;border-collapse:collapse;\" ><b><font size =\"1\" face=\"Arial\"> Entrege Ficha Diagnóstico: </font></b></td>" +
					"<td  width=\"50%\" align='left' style=\"border:1px solid black;border-collapse:collapse;\" ><font size =\"0\" face=\"Arial\"><font size =\"1\" face=\"Arial\">"+ cdmEntregoFicha + "</font></font></td>" +
				"</tr>" +
										
				"<tr>" +
					"<td  width=\"50%\" align='left' style=\"border:1px solid black;border-collapse:collapse;\" ><b><font size =\"1\" face=\"Arial\"> La base de datos fue de utilidad: </font></b></td>" +
					"<td  width=\"50%\" align='left' style=\"border:1px solid black;border-collapse:collapse;\" ><font size =\"0\" face=\"Arial\"><font size =\"1\" face=\"Arial\">"+ cmbBaseDatosUtil + "</font></font></td>" +
				"</tr>" +
				"<tr>" +
					"<td  width=\"50%\" align='left' style=\"border:1px solid black;border-collapse:collapse;\" ><b><font size =\"1\" face=\"Arial\"> Atención: </font></b></td>" +
					"<td  width=\"50%\" align='left' style=\"border:1px solid black;border-collapse:collapse;\" ><font size =\"0\" face=\"Arial\"><font size =\"1\" face=\"Arial\">"+ cmbListaAtencion + "</font></font></td>" +
				"</tr>" +
				"<tr>" +
					"<td  width=\"50%\" align='left' style=\"border:1px solid black;border-collapse:collapse;\" ><b><font size =\"1\" face=\"Arial\"> Calidad del Trabajo: </font></b></td>" +
					"<td  width=\"50%\" align='left' style=\"border:1px solid black;border-collapse:collapse;\" ><font size =\"0\" face=\"Arial\"><font size =\"1\" face=\"Arial\">"+ cmbListaCalidadTrabajo + "</font></font></td>" +
				"</tr>" +					
				
				"<tr>" +
					"<td  width=\"50%\" align='left' style=\"border:1px solid black;border-collapse:collapse;\" ><b><font size =\"1\" face=\"Arial\"> Tiempo de entrega: </font></b></td>" +
					"<td  width=\"50%\" align='left' style=\"border:1px solid black;border-collapse:collapse;\" ><font size =\"0\" face=\"Arial\"><font size =\"1\" face=\"Arial\">"+ cmbListaTiempoEntrega + "</font></font></td>" +
				"</tr>" +
				"<tr>" +
					"<td  width=\"50%\" align='left' style=\"border:1px solid black;border-collapse:collapse;\" ><b><font size =\"1\" face=\"Arial\"> Satisfacción del cliente: </font></b></td>" +
					"<td  width=\"50%\" align='left' style=\"border:1px solid black;border-collapse:collapse;\" ><font size =\"0\" face=\"Arial\"><font size =\"1\" face=\"Arial\">"+ cmbListaSatisfechoTrabajo + "</font></font></td>" +
				"</tr>" +
				"<tr>" +
					"<td  width=\"50%\" align='left' style=\"border:1px solid black;border-collapse:collapse;\" ><b><font size =\"1\" face=\"Arial\"> El cliente recomendaria el Taller: </font></b></td>" +
					"<td  width=\"50%\" align='left' style=\"border:1px solid black;border-collapse:collapse;\" ><font size =\"0\" face=\"Arial\"><font size =\"1\" face=\"Arial\">"+ cmbListaRecomendarTaller + "</font></font></td>" +
				"</tr>" +
				
				"<tr>" +
					"<td  width=\"50%\" align='left' style=\"border:1px solid black;border-collapse:collapse;\" ><b><font size =\"1\" face=\"Arial\"> El cliente volveria a llevar su auto: </font></b></td>" +
					"<td  width=\"50%\" align='left' style=\"border:1px solid black;border-collapse:collapse;\" ><font size =\"0\" face=\"Arial\"><font size =\"1\" face=\"Arial\">"+ cmbListallevarAuto + "</font></font></td>" +
				"</tr>" ;
		message += "</table><br><br><br>";	
		
		message +=  "<b><u><font size =\"2\" face=\"Arial\"> Atte.:Página Web KWX </font></u></b> <br><br>";
		
		SendEmailEvaluacion.send(to,subject, message);
	}
	catch(Exception ex)
	{
		String sError= ex.getMessage().toString();
	}
}
}
