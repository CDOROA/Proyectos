package cdo.Persistencia;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import cdo.Datos.InfoCliente;
import cdo.Datos.Log;
import cdo.Datos.Querys;
import cdo.Datos.detalleTraspaso72hrsCorreo;
import cdo.Util.Cls_Log;
import cdo.Util.Cls_Querys;
import cdo.Util.ConexionBD;
import cdo.Util.EjecutaQuerysBD;

public class GestorEnvioCorreo72hrs {
	 DecimalFormat formatoDecimal = new DecimalFormat("#,###.00");
	 private  static Properties properties = null;
	 private  static Properties propertiesWs = null;
 
	 
	 static 
	 {
	      try  
	      {
		      properties = new Properties();
		      InputStream  inputStream  = GestorEnvioCorreo72hrs.class.getClassLoader().getResourceAsStream("/properties/mail.properties");
		      properties.load(inputStream);
		      propertiesWs = new Properties();
		      InputStream  inputStreamWs  = GestorEnvioCorreo72hrs.class.getClassLoader().getResourceAsStream("/properties/configuracion.properties");
		      propertiesWs.load(inputStreamWs);

	      }
	      catch  (Exception ex) 
	      {
	    	  System.out.println("Error en static: " + ex);
	        ex.printStackTrace();
	      }
	 }
	 
	public String enviarCorreo( List<Querys> querys, InfoCliente infoCliente,int  pedidoActualizado )
	{
		String actualizoContrasena="Psw_Actualizada_BD";
		String sFechaHoraSistema = "";
		try 
	    {
		
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		Date fechaHoraSistema = Calendar.getInstance().getTime();
		sFechaHoraSistema = formatter.format(fechaHoraSistema);		
		
		
		List<detalleTraspaso72hrsCorreo> listaDetalle = consultaPedido72hrs(querys, infoCliente, pedidoActualizado );
		
		
	
		String correoEmisor = properties.getProperty("mail.login.username");
		String correoHost = properties.getProperty("mail.smtp.host");
		String correoPass=  properties.getProperty("mail.login.password");
		String asunto = sFechaHoraSistema +  " Traspaso de 72 hrs Generado. Cliente "+infoCliente.getCve_cliente() + " - Pedido " + pedidoActualizado ;
		// String correoDestino72Hrs=  "armando.rosas@corprama.com.mx";
		String correoDestino72Hrs=  "";
		String correosCC=  "";
		
		switch(infoCliente.getUname_cdo().toLowerCase())
		{
		case "cdf":
			correoDestino72Hrs = listaDetalle.get(0).getCorreoCdf();
			correosCC = listaDetalle.get(0).getCorreoCopiaCdf();
			break;
		case "cd2":
			correoDestino72Hrs = listaDetalle.get(0).getCorreoCd2();
			correosCC = listaDetalle.get(0).getCorreoCopiaCd2();
			break;
		case "cdl":
			correoDestino72Hrs = listaDetalle.get(0).getCorreoCdl();
			correosCC = listaDetalle.get(0).getCorreoCopiaCdl();
			break;
		case "cdm":
			correoDestino72Hrs = listaDetalle.get(0).getCorreoCdm();
			correosCC = listaDetalle.get(0).getCorreoCopiaCdm();
			break;
			
		}
		
		String contenidoDelMensaje = generarContenidoDeCorreo72Hrs(infoCliente, listaDetalle);
		
		Properties props = System.getProperties();
	    props.put("mail.smtp.host", correoHost); 
	    props.put("mail.smtp.user", correoEmisor);
	    props.put("mail.smtp.clave", correoPass);
	    props.put("mail.smtp.auth", "true"); 
	    props.put("mail.smtp.starttls.enable", "true"); 
	    props.put("mail.smtp.port","587"); 
	    
	    Session session = Session.getDefaultInstance(props);
	    MimeMessage message = new MimeMessage(session);
	
	    
	        message.setFrom(new InternetAddress(correoEmisor));
	        message.addRecipients(Message.RecipientType.TO, correoDestino72Hrs);
	        
	        if (!correosCC.equalsIgnoreCase(""))
	        {
	        	message.addRecipients(Message.RecipientType.CC, correosCC);
	        }
	        
	        message.setSubject(asunto);
	        message.setContent(contenidoDelMensaje, "text/html");
	        Transport transport = session.getTransport("smtp");
	        transport.connect(correoHost, correoEmisor,correoPass);
	        transport.sendMessage(message, message.getAllRecipients());
	        transport.close();
	        actualizoContrasena ="ContrasenaEnviada";
	    }
	    catch (MessagingException me)
	    {
	     //   me.printStackTrace(); 	   
	        Log log=new Log(1,infoCliente.getCve_cdo(),infoCliente.getCve_cliente() ,0, "[NuevoportalRamaCDO.- Error: enviarCorreo de traspaso 72 hrs,  Clase: GestorEnvioCorreo72hrs.enviarCorreo,  Detalle: " + me.getMessage().toString() +"]");
			Cls_Log.insertaLog(log);
	    }
	    return actualizoContrasena;
	}
	private List<detalleTraspaso72hrsCorreo> consultaPedido72hrs(List<Querys> listaQuerys, InfoCliente infoCliente, int pedidoActualizado) {
		Connection connBD = null;
		PreparedStatement pstm= null;
		connBD = ConexionBD.abrirConexionBD();
		List<detalleTraspaso72hrsCorreo> listaDetalle = null;
		try
		{
			String[] querys = new String[25];	
			querys = Cls_Querys.LimpiaListaQuerys(querys);	
			querys = Cls_Querys.ObtieneQuerys(55, listaQuerys, querys);
			querys = inicializaQueryNumero55(querys, infoCliente, pedidoActualizado);
			pstm = connBD.prepareStatement("{call " + "comercio_electronico.usp_EXECUTE_QUERY(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");	
			
			ResultSet rs=  EjecutaQuerysBD.EjecutarQuery(querys[0], querys[1],querys[2], querys[3], querys[4], querys[5], querys[6],
														 querys[7], querys[8], querys[9],querys[10], querys[11], querys[12], querys[13], 
														 querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], 
														 querys[21], querys[22], querys[23], querys[24], "",pstm, connBD);
			
			Cls_Querys.ImprimeQuerysConsola(querys,false,"Query 55");
			
			
			
			if(rs != null)
			{
				listaDetalle = new ArrayList<detalleTraspaso72hrsCorreo>(); 
						
				while(rs.next())
				{
					detalleTraspaso72hrsCorreo d = new detalleTraspaso72hrsCorreo(); 
					d.setPedido(rs.getInt("pedido"));
					d.setNumArt(rs.getString("num_art"));
					d.setCantidad(rs.getInt("cantidad"));
					d.setCdo72hrs(rs.getString("cdo_72hrs"));
					d.setDescripcionCdo72hrs(rs.getString("descripcion_cdo_72hrs"));
					d.setCorreoCdf(rs.getString("correo_cdf"));
					d.setCorreoCd2(rs.getString("correo_cd2"));
					d.setCorreoCdl(rs.getString("correo_cdl"));
					d.setCorreoCdm(rs.getString("correo_cdm"));
					d.setCorreoCopiaCdf(rs.getString("correo_copia_cdf"));
					d.setCorreoCopiaCd2(rs.getString("correo_copia_cd2"));
					d.setCorreoCopiaCdl(rs.getString("correo_copia_cdl"));
					d.setCorreoCopiaCdm(rs.getString("correo_copia_cdm"));
					listaDetalle.add(d);
					// System.out.println(d);
				}
			}
			
			 
		}
		catch(Exception ex)
		{
			//System.out.println("[NuevoportalRamaCDO.- Error: Consulta pedido para el envio de correo de 72 hrs.,  Clase: GestorEnvioCorreo72hrs.consultaPedido72hrs,  Detalle: " + ex.toString() +"]");
			Log log=new Log(1,infoCliente.getCve_cdo(),infoCliente.getCve_cliente() ,0, "[NuevoportalRamaCDO.- Error: Consulta pedido para el envio de correo de 72 hrs.,  Clase: GestorEnvioCorreo72hrs.consultaPedido72hrs,  Detalle: " + ex.getMessage().toString() +"]");
			Cls_Log.insertaLog(log);
		}
		finally 
		{
			try {pstm.close();} catch (SQLException e) {e.printStackTrace();}
			try {connBD.close();} catch (SQLException e) {e.printStackTrace();}
		}
		return listaDetalle;
	}
	
	
	private String[] inicializaQueryNumero55(String[] ListaQuerys, InfoCliente infocte, int pedido) {
		for (int i=0;i <ListaQuerys.length; i++)
		{
			ListaQuerys[i]= ListaQuerys[i].replace("{CVE_CENTRO}",String.valueOf(infocte.getCentro()));
			ListaQuerys[i]= ListaQuerys[i].replace("{NUM_CTE}", String.valueOf(infocte.getCve_cliente()));
			ListaQuerys[i]= ListaQuerys[i].replace("{PEDIDO}", String.valueOf(pedido) );
		}
		return ListaQuerys;
	}
	private String generarContenidoDeCorreo72Hrs(InfoCliente infoCliente, List<detalleTraspaso72hrsCorreo>  ListaDetalle) {
		String sFechaHoraSistema = "";
		String contenidoDelMensaje = "";
		
		SimpleDateFormat formatter = new SimpleDateFormat("dd 'de' MMMM 'de' yyyy hh:mm:ss aaa");
		Date fechaHoraSistema = Calendar.getInstance().getTime();
		sFechaHoraSistema = formatter.format(fechaHoraSistema);		
		
		contenidoDelMensaje += "<%@ page language=\"java\" contentType=\"text/html; charset=ISO-8859-1\" pageEncoding=\"ISO-8859-1\"%>";
		contenidoDelMensaje += "<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">";
		contenidoDelMensaje += "<html>";				
		contenidoDelMensaje += "<font size =\"4\" face=\"Arial\" color=#004099>" + sFechaHoraSistema + "</font><br><br>";
		contenidoDelMensaje += "<font size =\"14px\" face=\"Arial\" color=#000000>Buen D&iacute;a </font><br><br>";
		contenidoDelMensaje += "<font size =\"14px\" face=\"Arial\" color=#000000>Se les informa que el cliente de CDO "+ infoCliente.getNombre_cdo() +", " + infoCliente.getCve_cliente() +"-" + infoCliente.getNombre_cliente() +" realizo la solicitud de mercancía por emergencia de 72 hrs.</font><br><br>";
		
		String cdoTraspaso = "";
		
			 
		for(detalleTraspaso72hrsCorreo detalleI : ListaDetalle ){
			
			if(!cdoTraspaso.equalsIgnoreCase(detalleI.getDescripcionCdo72hrs()))
			{
				contenidoDelMensaje += "<br><br><font size =\"14px\" face=\"Arial\" color=#000000>Traspaso de CDO "+ detalleI.getDescripcionCdo72hrs().toUpperCase() +" de los articulos:</font><br><br>";
				contenidoDelMensaje +="<table style='width: 400px;'><tr>";
				contenidoDelMensaje +="<td style='width: 100px; border: 1px solid #dee2e6;'  align=\"center\">  PEDIDO </td><td style='width: 200px; border: 1px solid #dee2e6;'  align=\"center\"> ARTICULO </td><td style='width: 100px; border: 1px solid #dee2e6;'  align=\"center\"> CANTIDAD </td>";
				contenidoDelMensaje +="</tr></table>";
				cdoTraspaso = detalleI.getDescripcionCdo72hrs();
			}
			
			contenidoDelMensaje +="<table style='width: 400px;'><tr>";
			contenidoDelMensaje +="<td style='width: 100px; border: 1px solid #dee2e6;'> "+ detalleI.getPedido() +" </td><td style='width: 200px; border: 1px solid #dee2e6;'> "+ detalleI.getNumArt() +" </td><td style='width: 100px; border: 1px solid #dee2e6;' align=\"center\" > "+ detalleI.getCantidad() +" </td>";
			contenidoDelMensaje +="</tr></table>";
			
		}
		
		
		
		contenidoDelMensaje += "</b><br><br><font size =\"14px\" face=\"Arial\" color=#000000>Atte.: P&aacute;gina www ROAOnline</font><br><br>";
		
	
		contenidoDelMensaje += "<center><h3><font face=\"Arial\" color=#004099>AVISO DE PRIVACIDAD</font></h3></center>";
		contenidoDelMensaje += "<font size =\"12px;\" face=\"Arial\" color=#004099>Este correo electr&oacute;nico puede contener informaci&oacute;n confidencial y privilegiada, por lo que se proh&iacute;be el uso, reproducci&oacute;n,</font>";
		contenidoDelMensaje += "<font size =\"12px;\" face=\"Arial\" color=#004099>retransmisi&oacute;n o divulgaci&oacute;n no autorizada, parcial o total, de su contenido. Si usted no es el destinatario del presente correo, por </font>";
		contenidoDelMensaje += "<font size =\"12px;\" face=\"Arial\" color=#004099>favor notif&iacute;quelo al remitente y b&oacute;rrelo de inmediato. En Centro de Distribuci&oacute;n Oriente, S.A. de C.V., nos ocupamos de cuidar la </font>";
		contenidoDelMensaje += "<font size =\"12px;\" face=\"Arial\" color=#004099>seguridad y confidencialidad de sus datos.</font>";
		contenidoDelMensaje += "<font size =\"12px;\" face=\"Arial\" color=#004099>Consulte nuestro Aviso de Privacidad actualizado en nuestras instalaciones o accediendo a la siguiente liga:</font><br>";
		contenidoDelMensaje += "<font size =\"12px;\" face=\"Arial\" color=#004099><a href='http://www.cdoautopartes.com.mx/'>http://www.cdoautopartes.com.mx/</a></font><br>";
		
		
		contenidoDelMensaje += "</html>";
		return contenidoDelMensaje;
	}
}
