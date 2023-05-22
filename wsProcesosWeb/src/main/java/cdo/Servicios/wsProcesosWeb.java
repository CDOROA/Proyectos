package cdo.Servicios;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import cdo.Datos.Detalles;
import cdo.Datos.LogPDF;
import cdo.Datos.Querys;
import cdo.Persistencia.GestorProcesos;
import cdo.Util.ClsQuery;
import cdo.Util.Cls_Logs;
import cdo.Util.ConexionBD;

@Path("/ProcesosWeb")
public class wsProcesosWeb {
	String[] querys;
	List<Querys> listaDeQuerys = null;
	

	@GET
	@Path("/proceso")
	@Produces({MediaType.TEXT_PLAIN})	
    public String obtenerSerieFolio(@QueryParam("cdo")  String cdo, @QueryParam("serie") String serie,@QueryParam("folio") String folio) {
		List<Detalles> descripcion=consultaDescripcion(serie,folio,cdo);
		String respuesta="false";
		List<String> correos=correosProceso(cdo); 
		for(int i=0;i<correos.size();i++) {
			respuesta=enviaCorreos(correos.get(i), descripcion, cdo);
		}
		Cls_Logs.insertarLog(new LogPDF(),cdo,"","","LOG del folio: "+folio+" y serie: "+serie+" enviados");
		return respuesta;
	}
	
	private String enviaCorreos(String correo, List<Detalles> descripcion, String cdo) {
		Date date = new Date();
		String patron = "EEEE d 'de' MMMM 'de' YYYY 'hora:' hh:mm";
		SimpleDateFormat formatoFechaPersonal = new SimpleDateFormat(patron);
		String cuerpo="<h3>"+formatoFechaPersonal.format(date)+"</h3><br><table style='border: black 1px solid; width:max-content;'>"
				+ "<th style='border: black 1px solid;'>Serie</th><th style='border: black 1px solid;'>Folio</th>"
				+ "<th style='border: black 1px solid;'>Descripción</th><th style='border: black 1px solid;'>Fecha</th>"
				+ "<th style='border: black 1px solid;'>Hora</th>";
		Properties props = new Properties();
		props.put("mail.smtp.host", "10.0.0.112");
		props.setProperty("mail.smtp.starttls.enable", "true");
		props.setProperty("mail.smtp.port","587");
		props.setProperty("mail.smtp.auth", "true");
			
		try {
			Session session= Session.getDefaultInstance(props, null);
			//session.setDebug(true);
			BodyPart texto = new MimeBodyPart();
			for(int i=0;i<descripcion.size();i++) {
				cuerpo+="<tr><td style='border: black 1px solid;'>"+descripcion.get(i).getSerie()+"</td>"
						+ "<td style='border: black 1px solid;'>"+descripcion.get(i).getFolio()+"</td>"
						+ "<td style='border: black 1px solid;'>"+descripcion.get(i).getDescripcion()+"</td>"
						+ "<td style='border: black 1px solid;'>"+descripcion.get(i).getFecha()+"</td>"
						+ "<td style='border: black 1px solid;'>"+descripcion.get(i).getHora()+"</td></tr>";
			}
			cuerpo+="</table><br><h3>Atte. Sistemas Mayoristas</h3>";
			//texto.setContent(cuerpo, "text/html; charset=utf-8");
			MimeMultipart multiParte = new MimeMultipart();
			multiParte.addBodyPart(texto);
			MimeMessage message = new MimeMessage(session);
			//message.setHeader("Content-Type", "text/html");
			message.setContent(cuerpo, "text/html; charset=utf-8");
			// Se rellena el From
			message.setFrom(new InternetAddress(traeRemitente(cdo)));
	
			// Se rellenan los destinatarios
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(correo));
	
			// Se rellena el subject
			message.setSubject(cdo.toUpperCase()+".- Notificación del sistema por excepción de sellado serie: "+descripcion.get(0).getSerie()+" folio: "+descripcion.get(0).getFolio());
	
			// Se mete el texto y el archivo adjunto.
			//message.setContent(multiParte, "text/html;charset=UTF-8;");
			message.saveChanges();
			Transport t = session.getTransport("smtp");
			t.connect(traeRemitente(cdo),traePass(cdo));
			t.sendMessage(message,message.getAllRecipients());
			t.close();
		} catch (Exception e) { 
			e.printStackTrace();
			return "false";
		}
		return "true";
	}

	public List<Detalles> consultaDescripcion(String serie, String folio, String cdo) {
		Connection connBD = null;
		List<Detalles> descripcion = new ArrayList<>();
    	try
    	{
	    	connBD = ConexionBD.AbrirConexionBD(cdo);
	    	List<Querys> listaQuerys = ClsQuery.ConsultaTablaQuerysBD(cdo, connBD);
	    	PreparedStatement pstmt = null; 	      	
	    	descripcion = GestorProcesos.recuperaDescripcion(cdo,connBD,pstmt,listaQuerys, serie, folio);     	        
    	}
    	  catch(Exception ex)
    	{
    		System.out.println("Error En metodo consultaDescripcion " + ex.toString() );
    	}finally
		{
			try {connBD.close();} catch (SQLException e) {e.printStackTrace();}
		}
		return descripcion;
	}
	public List<String> correosProceso(String cdo) {
		Connection connBD = null;
		List<String> correos=new ArrayList<>();
    	try
    	{
	    	connBD = ConexionBD.AbrirConexionBD(cdo);
	    	List<Querys> listaQuerys = ClsQuery.ConsultaTablaQuerysBD(cdo, connBD);
	    	PreparedStatement pstmt = null; 	      	
	    	correos = GestorProcesos.consultarCorreos(cdo,connBD,pstmt,listaQuerys);     	        
    	}
    	  catch(Exception ex)
    	{
    		System.out.println("Error En metodo ConsultaRuta " + ex.toString() );
    	}finally
		{
			try {connBD.close();} catch (SQLException e) {e.printStackTrace();}
		}
		return correos;
	}
	private String traePass(String cdo) {
		Connection connBD = null;
		String pass = "";
    	try
    	{
	    	connBD = ConexionBD.AbrirConexionBD(cdo);
	    	List<Querys> listaQuerys = ClsQuery.ConsultaTablaQuerysBD(cdo, connBD);
	    	PreparedStatement pstmt = null; 	      	
	    	pass = GestorProcesos.recuperaPass(cdo,connBD,pstmt,listaQuerys);     	        
    	}
    	  catch(Exception ex)
    	{
    		System.out.println("Error En metodo traePass " + ex.toString() );
    	}finally
		{
			try {connBD.close();} catch (SQLException e) {e.printStackTrace();}
		}
		return pass;
	}

	private String traeRemitente(String cdo) {
		Connection connBD = null;
		String remitente = "";
    	try
    	{
	    	connBD = ConexionBD.AbrirConexionBD(cdo);
	    	List<Querys> listaQuerys = ClsQuery.ConsultaTablaQuerysBD(cdo, connBD);
	    	PreparedStatement pstmt = null; 	      	
	    	remitente = GestorProcesos.recuperaRemitente(cdo,connBD,pstmt,listaQuerys);     	        
    	}
    	  catch(Exception ex)
    	{
    		System.out.println("Error En metodo traeRemitente " + ex.toString() );
    	}finally
		{
			try {connBD.close();} catch (SQLException e) {e.printStackTrace();}
		}
		return remitente;
	}
}
