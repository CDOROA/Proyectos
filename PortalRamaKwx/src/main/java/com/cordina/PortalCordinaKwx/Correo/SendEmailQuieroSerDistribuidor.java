package com.cordina.PortalCordinaKwx.Correo;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cordina.PortalCordinaKwx.Util.clsLog;

import java.io.IOException;
import java.io.InputStream;


public class SendEmailQuieroSerDistribuidor {
	private static String imagePath;
	
	
	
	public static void send(HttpServletRequest request, HttpServletResponse response)
	{ 
		Properties properties= new Properties();
		
		String Ruta = "";
	 
		try  
		{
			InputStream  inputStream  = SendEmailQuieroSerDistribuidor.class.getClassLoader().getResourceAsStream("/properties/mail.properties");
			properties.load(inputStream);
		} 
		catch  (Exception ex) 
		{
			ex.printStackTrace();
		}		
		try  
		{
		 InputStream in = SendEmailQuieroSerDistribuidor.class.getClassLoader().getResourceAsStream("/properties/kwx.properties");	
		 properties.load(in);;            
         Ruta = properties.getProperty("RUTA_IMG_KWX");
         //System.out.println("Ruta correcta: " + Ruta );
		} 
		catch  (Exception ex) 
		{
			ex.printStackTrace();
		}	
		
		Session session = Session.getInstance(properties,new javax.mail.Authenticator()
		{
			protected PasswordAuthentication getPasswordAuthentication() 
			{
			
				//return new PasswordAuthentication("webadmin@cedisa.com.mx","3at0pX7L");
				return new PasswordAuthentication("adminkwx@cdoautopartes.com.mx","StEhS6er89");
			}
		});
			
		try
		{
			String nombreNegocio = request.getParameter("nombreNegocio");
			String giro = request.getParameter("giro");
			String nombreContacto = request.getParameter("nombreContacto");
			String puesto = request.getParameter("puesto");
			String correo = request.getParameter("correo");
			String whatsApp = request.getParameter("whatsApp");
			String cveEstado = request.getParameter("cveEstado");
			String descPais = request.getParameter("descPais");
			String descEstado = request.getParameter("descEstado");
			String municipio = request.getParameter("municipio");
			String codigoPostal = request.getParameter("codigoPostal");
			String fotografia = request.getParameter("fotografia");
			
			DateFormat df = new SimpleDateFormat("dd 'de' MMMM 'de' yyyy hh:mm:ss aaa");
			Date FechaAct = new Date();
			String Fecha= df.format(FechaAct);
		 
	        String subject = " Quiero ser Distribuidor " + Fecha;
	        
			MimeMessage message = new MimeMessage(session); // (session);
			
			message.setFrom(new InternetAddress("adminkwx@cdoautopartes.com.mx"));
			
		
			
			message.addRecipient(Message.RecipientType.TO,new InternetAddress("aux2-mkt-cdf@cedisa.com.mx"));
			message.addRecipient(Message.RecipientType.TO,new InternetAddress("gmp-cdmx@cedisa.com.mx"));
					 
			message.addRecipient(Message.RecipientType.TO,new InternetAddress("jp-cdf@cedisa.com.mx"));
			message.addRecipient(Message.RecipientType.CC,new InternetAddress("soportetecnico@cedisa.com.mx"));
			message.addRecipient(Message.RecipientType.CC,new InternetAddress("atencionaclientes@kwx.com.mx"));
			//message.addRecipient(Message.RecipientType.BCC,new InternetAddress("ernesto.espinosa@corprama.com.mx"));
			message.addRecipient(Message.RecipientType.BCC,new InternetAddress("armando.rosas@corprama.com.mx"));
			

			message.setSubject(subject);			
			message.setContent("", "text/html; charset=ISO-8859-1");
			
			 // first part  (the html)
	        BodyPart messageBodyPart = new MimeBodyPart();
	        String htmlText = "<html><body style='text-align: center;'>"
	        		+"<b><font size =\"2\" face=\"Arial\">" + Fecha
					+ "</font></b><br><br>"
			        + "<font size =\"2\" face=\"Arial\">Buen D&iacute;a</font><br><br><br>"
			        + "<font size =\"2\" face=\"Arial\">Se les informa que se ha dado de alta un nuevo registro de contacto para ser Distribuidor KWX</font> <br><br><br>"

	        		+"<table id=\"table_cdf\" style=\"border:1px solid black;border-collapse:collapse; \" width=\"50%\">"
					+ "<tr>"
					+ "<td  width=\"50%\" align='center' style=\"border:1px solid black;border-collapse:collapse; background-color:#CCCCCC; color:black \" ><b><font size =\"2\" face=\"Arial\"> DATO </font></b></td>"
					+ "<td  width=\"50%\" align='center' style=\"border:1px solid black;border-collapse:collapse; background-color:#CCCCCC; color:black \" ><b><font size =\"2\" face=\"Arial\"> RESPUESTA </font></b></td>"
					+ "</tr>"
					+

					"<tr>"
					+ "<td  width=\"50%\" align='left' style=\"border:1px solid black;border-collapse:collapse;\" ><b><font size =\"2\" face=\"Arial\"> Nombre del Negocio: </font></b></td>"
					+ "<td  width=\"50%\" align='left' style=\"border:1px solid black;border-collapse:collapse;\" ><font size =\"2\" face=\"Arial\">"
					+ nombreNegocio+"</font></td>"
					+ "</tr>"
					+ "<tr>"
					+ "<td  width=\"50%\" align='left' style=\"border:1px solid black;border-collapse:collapse;\" ><b><font size =\"2\" face=\"Arial\"> Giro: </font></b></td>"
					+ "<td  width=\"50%\" align='left' style=\"border:1px solid black;border-collapse:collapse;\" ><font size =\"2\" face=\"Arial\">"
					+ giro+"</font></td>"
					+ "</tr>"
					+ "<tr>"
					+ "<td  width=\"50%\" align='left' style=\"border:1px solid black;border-collapse:collapse;\" ><b><font size =\"2\" face=\"Arial\"> Nombre del contacto: </font></b></td>"
					+ "<td  width=\"50%\" align='left' style=\"border:1px solid black;border-collapse:collapse;\" ><font size =\"2\" face=\"Arial\">"
					+ nombreContacto+"</font></td>"
					+ "</tr>"
					+ "<tr>"
					+ "<td  width=\"50%\" align='left' style=\"border:1px solid black;border-collapse:collapse;\" ><b><font size =\"2\" face=\"Arial\"> Puesto: </font></b></td>"
					+ "<td  width=\"50%\" align='left' style=\"border:1px solid black;border-collapse:collapse;\" ><font size =\"2\" face=\"Arial\">"
					+ puesto+"</font></td>"
					+ "</tr>"
					+ "<tr>"
					+ "<td  width=\"50%\" align='left' style=\"border:1px solid black;border-collapse:collapse;\" ><b><font size =\"2\" face=\"Arial\"> Correo Electr&oacute;nico: </font></b></td>"
					+ "<td  width=\"50%\" align='left' style=\"border:1px solid black;border-collapse:collapse;\" ><font size =\"2\" face=\"Arial\">"
					+ correo+ "</font></td>"
					+ "</tr>"
					+ "<tr>"
					+ "<td  width=\"50%\" align='left' style=\"border:1px solid black;border-collapse:collapse;\" ><b><font size =\"2\" face=\"Arial\"> WhatsApp: </font></b></td>"
					+ "<td  width=\"50%\" align='left' style=\"border:1px solid black;border-collapse:collapse;\" ><font size =\"2\" face=\"Arial\">"
					+ whatsApp+"</font></td>"
					+ "</tr>"
					+ "<tr>"
					+ "<td  width=\"50%\" align='left' style=\"border:1px solid black;border-collapse:collapse;\" ><b><font size =\"2\" face=\"Arial\"> Pais: </font></b></td>"
					+ "<td  width=\"50%\" align='left' style=\"border:1px solid black;border-collapse:collapse;\" ><font size =\"2\" face=\"Arial\">"
					+ descPais+ "</font></td>"
					+ "</tr>"
					+ "<tr>"
					+ "<td  width=\"50%\" align='left' style=\"border:1px solid black;border-collapse:collapse;\" ><b><font size =\"2\" face=\"Arial\"> Estado: </font></b></td>"
					+ "<td  width=\"50%\" align='left' style=\"border:1px solid black;border-collapse:collapse;\" ><font size =\"2\" face=\"Arial\">"
					+ descEstado+ "</font></td>"
					+ "</tr>"
					+ "<tr>"
					+ "<td  width=\"50%\" align='left' style=\"border:1px solid black;border-collapse:collapse;\" ><b><font size =\"2\" face=\"Arial\"> alcaldia &oacute; municipio: </font></b></td>"
					+ "<td  width=\"50%\" align='left' style=\"border:1px solid black;border-collapse:collapse;\" ><font size =\"2\" face=\"Arial\">"
					+ municipio+"</font></td>"
					+ "</tr>"
				    + "<tr>"
                    + "<td  width=\"50%\" align='left' style=\"border:1px solid black;border-collapse:collapse;\" ><b><font size =\"2\" face=\"Arial\"> C&oacute;digo Postal: </font></b></td>"
                    + "<td  width=\"50%\" align='left' style=\"border:1px solid black;border-collapse:collapse;\" ><font size =\"2\" face=\"Arial\">"
                    + codigoPostal+"</font></td>"
                    + "</tr>"
					+"<tr>"
					+ "<td  width=\"50%\" align='left' style=\"border:1px solid black;border-collapse:collapse;\" ><b><font size =\"2\" face=\"Arial\"> Fotografia: </font></b></td>"
					+ "<td  width=\"50%\" align='left' style=\"border:1px solid black;border-collapse:collapse;\" ><img width=\"100%\" src='cid:image1'></td>"
					+ "</tr>"
					+ "</table><br><br><br>"

					+ "<b><u><font size =\"2\" face=\"Arial\"> Atte.:Página Web KWX </font></u></b> <br><br>";
		
	        messageBodyPart.setContent(htmlText, "text/html; charset=ISO-8859-1");
			

	        // add it
	        MimeMultipart multipart = new MimeMultipart("related");
	        multipart.addBodyPart(messageBodyPart);
	        
	        // second part (the image)
	        Properties proper = new Properties();
	        messageBodyPart = new MimeBodyPart();
	       
	        DataSource fds = new FileDataSource(Ruta+"quieroSerDistribuidor/"+ fotografia);
	     //   System.out.println("imagen: "  +Ruta+"/mecanicos/Correo_ficha_inspeccion.png");
	        messageBodyPart.setDataHandler(new DataHandler(fds));
	        messageBodyPart.setDisposition(MimeBodyPart.INLINE);
	        messageBodyPart.setHeader("Content-ID","<image1>");

	        // add it
	        multipart.addBodyPart(messageBodyPart);

	        // put everything together
	        message.setContent(multipart);
	        
	        Transport.send(message);
	        
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("PortalRama KWX - Error SendEmailContactoNuevoMecanico.SEND :" + e);
			System.out.println("PortalRama KWX - Error al enviar correo de Evaluacion: " + e);
			System.out.println("PortalRama KWX - Error al enviar correo de Evaluacion getLocalizedMessage: " + e.getLocalizedMessage());
			System.out.println("PortalRama KWX - Error al enviar correo de Evaluacion getMessage: " + e.getMessage());
			System.out.println("PortalRama KWX - Error al enviar correo de Evaluacion getCause: " + e.getCause());
			System.out.println("PortalRama KWX - Error al enviar correo de Evaluacion getClass().getName: " + e.getClass().getName());
			clsLog.RegistraLog("PortalRama KWX - SendEmailContactoNuevoMecanico.SEND", "getLocalizedMessage: "+ e.getLocalizedMessage().replace("'",""));
			clsLog.RegistraLog("PortalRama KWX - SendEmailContactoNuevoMecanico.SEND", "getMessage: "+ e.getMessage().replace("'",""));
			clsLog.RegistraLog("PortalRama KWX - SendEmailContactoNuevoMecanico.SEND", "getCause: "+ e.getClass().getName().replace("'",""));
			clsLog.RegistraLog("PortalRama KWX - SendEmailContactoNuevoMecanico.SEND", "getClass().getName: "+ e.getLocalizedMessage().replace("'",""));
		}
	}
	
}
