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

import com.cordina.PortalCordinaKwx.Util.clsLog;

import java.io.IOException;
import java.io.InputStream;


public class SendEmailContactoNuevoMecanico {
	private static String imagePath;
	
	
	
	public static void send(String estado, String municipio,
			String colonia, String cp, String calle, String numExt,
			String numInt, String nombreTaller, String nombreEncargado,
			String brindaServisioDomicilio, String telefono, String whatsapp,
			String email,String especialidad, String radio, String fotografia, String recibirInfo,
			String latitud, String longitud)
	{ 
		Properties properties= new Properties();
		
		String Ruta = "";
	 
		try  
		{
			InputStream  inputStream  = SendEmailContactoNuevoMecanico.class.getClassLoader().getResourceAsStream("/properties/mail.properties");
			properties.load(inputStream);
		} 
		catch  (Exception ex) 
		{
			ex.printStackTrace();
		}		
		try  
		{
		 InputStream in = SendEmailContactoNuevoMecanico.class.getClassLoader().getResourceAsStream("/properties/kwx.properties");	
		 properties.load(in);;            
         Ruta = properties.getProperty("RUTA_IMG_KWX");
       //  System.out.println("Ruta correcta: " + Ruta );
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
			DateFormat df = new SimpleDateFormat("dd 'de' MMMM 'de' yyyy hh:mm:ss aaa");
			Date FechaAct = new Date();
			String Fecha= df.format(FechaAct);
		 
	        String subject = " Alta a Mecánico " + Fecha;
	        
			MimeMessage message = new MimeMessage(session); // (session);
			
			message.setFrom(new InternetAddress("adminkwx@cdoautopartes.com.mx"));
					message.addRecipient(Message.RecipientType.TO,new InternetAddress("aux2-mkt-cdf@cedisa.com.mx"));
					message.addRecipient(Message.RecipientType.TO,new InternetAddress("gmp-cdmx@cedisa.com.mx"));
					message.addRecipient(Message.RecipientType.TO,new InternetAddress("jp-cdf@cedisa.com.mx"));
					message.addRecipient(Message.RecipientType.CC,new InternetAddress("soportetecnico@cedisa.com.mx"));
					message.addRecipient(Message.RecipientType.CC,new InternetAddress("atencionaclientes@kwx.com.mx"));
			message.addRecipient(Message.RecipientType.BCC,new InternetAddress("armando.rosas@corprama.com.mx"));

			message.setSubject(subject);			
			message.setContent("", "text/html; charset=ISO-8859-1");
			
			 // first part  (the html)
	        BodyPart messageBodyPart = new MimeBodyPart();
	        String htmlText = "<html><body style='text-align: center;'>"
	        		+"<b><font size =\"2\" face=\"Arial\">" + Fecha
					+ "</font></b><br><br>"
			        + "<font size =\"2\" face=\"Arial\">Buen Día</font><br><br><br>"
			        + "<font size =\"2\" face=\"Arial\">Se les informa que se ha dado de alta un nuevo registro de mecánico</font> <br><br><br>"

	        		+"<table id=\"table_cdf\" style=\"border:1px solid black;border-collapse:collapse; \" width=\"50%\">"
					+ "<tr>"
					+ "<td  width=\"50%\" align='center' style=\"border:1px solid black;border-collapse:collapse; background-color:#CCCCCC; color:black \" ><b><font size =\"1\" face=\"Arial\"> DATO </font></b></td>"
					+ "<td  width=\"50%\" align='center' style=\"border:1px solid black;border-collapse:collapse; background-color:#CCCCCC; color:black \" ><b><font size =\"1\" face=\"Arial\"> RESPUESTA </font></b></td>"
					+ "</tr>"
					+

					"<tr>"
					+ "<td  width=\"50%\" align='left' style=\"border:1px solid black;border-collapse:collapse;\" ><b><font size =\"1\" face=\"Arial\"> Estado: </font></b></td>"
					+ "<td  width=\"50%\" align='left' style=\"border:1px solid black;border-collapse:collapse;\" ><font size =\"0\" face=\"Arial\"><font size =\"1\" face=\"Arial\">"
					+ estado
					+ "</font></font></td>"
					+ "</tr>"
					+ "<tr>"
					+ "<td  width=\"50%\" align='left' style=\"border:1px solid black;border-collapse:collapse;\" ><b><font size =\"1\" face=\"Arial\"> Delegación o Municipio: </font></b></td>"
					+ "<td  width=\"50%\" align='left' style=\"border:1px solid black;border-collapse:collapse;\" ><font size =\"0\" face=\"Arial\"><font size =\"1\" face=\"Arial\">"
					+ municipio
					+ "</font></font></td>"
					+ "</tr>"
					+ "<tr>"
					+ "<td  width=\"50%\" align='left' style=\"border:1px solid black;border-collapse:collapse;\" ><b><font size =\"1\" face=\"Arial\"> colonia: </font></b></td>"
					+ "<td  width=\"50%\" align='left' style=\"border:1px solid black;border-collapse:collapse;\" ><font size =\"0\" face=\"Arial\"><font size =\"1\" face=\"Arial\">"
					+ colonia
					+ "</font></font></td>"
					+ "</tr>"
					+

					"<tr>"
					+ "<td  width=\"50%\" align='left' style=\"border:1px solid black;border-collapse:collapse;\" ><b><font size =\"1\" face=\"Arial\"> Código Postal: </font></b></td>"
					+ "<td  width=\"50%\" align='left' style=\"border:1px solid black;border-collapse:collapse;\" ><font size =\"0\" face=\"Arial\"><font size =\"1\" face=\"Arial\">"
					+ cp
					+ "</font></font></td>"
					+ "</tr>"
					+ "<tr>"
					+ "<td  width=\"50%\" align='left' style=\"border:1px solid black;border-collapse:collapse;\" ><b><font size =\"1\" face=\"Arial\"> Calle: </font></b></td>"
					+ "<td  width=\"50%\" align='left' style=\"border:1px solid black;border-collapse:collapse;\" ><font size =\"0\" face=\"Arial\"><font size =\"1\" face=\"Arial\">"
					+ calle
					+ "</font></font></td>"
					+ "</tr>"
					+ "<tr>"
					+ "<td  width=\"50%\" align='left' style=\"border:1px solid black;border-collapse:collapse;\" ><b><font size =\"1\" face=\"Arial\"> Número Exterior: </font></b></td>"
					+ "<td  width=\"50%\" align='left' style=\"border:1px solid black;border-collapse:collapse;\" ><font size =\"0\" face=\"Arial\"><font size =\"1\" face=\"Arial\">"
					+ numExt
					+ "</font></font></td>"
					+ "</tr>"
					+

					"<tr>"
					+ "<td  width=\"50%\" align='left' style=\"border:1px solid black;border-collapse:collapse;\" ><b><font size =\"1\" face=\"Arial\"> Número Interior: </font></b></td>"
					+ "<td  width=\"50%\" align='left' style=\"border:1px solid black;border-collapse:collapse;\" ><font size =\"0\" face=\"Arial\"><font size =\"1\" face=\"Arial\">"
					+ numInt
					+ "</font></font></td>"
					+ "</tr>"
					+ "<tr>"
					+ "<td  width=\"50%\" align='left' style=\"border:1px solid black;border-collapse:collapse;\" ><b><font size =\"1\" face=\"Arial\"> Nombre del taller: </font></b></td>"
					+ "<td  width=\"50%\" align='left' style=\"border:1px solid black;border-collapse:collapse;\" ><font size =\"0\" face=\"Arial\"><font size =\"1\" face=\"Arial\">"
					+ nombreTaller
					+ "</font></font></td>"
					+ "</tr>"
				    + "<tr>"
                    + "<td  width=\"50%\" align='left' style=\"border:1px solid black;border-collapse:collapse;\" ><b><font size =\"1\" face=\"Arial\"> Especialida del taller: </font></b></td>"
                    + "<td  width=\"50%\" align='left' style=\"border:1px solid black;border-collapse:collapse;\" ><font size =\"0\" face=\"Arial\"><font size =\"1\" face=\"Arial\">"
                    + especialidad
                    + "</font></font></td>"
                    + "</tr>"
					+ "<tr>"
					+ "<td  width=\"50%\" align='left' style=\"border:1px solid black;border-collapse:collapse;\" ><b><font size =\"1\" face=\"Arial\"> Nombre del encargado o Dueño: </font></b></td>"
					+ "<td  width=\"50%\" align='left' style=\"border:1px solid black;border-collapse:collapse;\" ><font size =\"0\" face=\"Arial\"><font size =\"1\" face=\"Arial\">"
					+ nombreEncargado
					+ "</font></font></td>"
					+ "</tr>"
					+ "<tr>"
					+ "<td  width=\"50%\" align='left' style=\"border:1px solid black;border-collapse:collapse;\" ><b><font size =\"1\" face=\"Arial\"> Brinda servicio a domicilio: </font></b></td>"
					+ "<td  width=\"50%\" align='left' style=\"border:1px solid black;border-collapse:collapse;\" ><font size =\"0\" face=\"Arial\"><font size =\"1\" face=\"Arial\">"
					+ brindaServisioDomicilio
					+ "</font></font></td>"
					+ "</tr>"
					+ "<tr>"
					+ "<td  width=\"50%\" align='left' style=\"border:1px solid black;border-collapse:collapse;\" ><b><font size =\"1\" face=\"Arial\"> Teléfono: </font></b></td>"
					+ "<td  width=\"50%\" align='left' style=\"border:1px solid black;border-collapse:collapse;\" ><font size =\"0\" face=\"Arial\"><font size =\"1\" face=\"Arial\">"
					+ telefono
					+ "</font></font></td>"
					+ "</tr>"
					+ "<tr>"
					+ "<td  width=\"50%\" align='left' style=\"border:1px solid black;border-collapse:collapse;\" ><b><font size =\"1\" face=\"Arial\"> Whatsapp: </font></b></td>"
					+ "<td  width=\"50%\" align='left' style=\"border:1px solid black;border-collapse:collapse;\" ><font size =\"0\" face=\"Arial\"><font size =\"1\" face=\"Arial\">"
					+ whatsapp
					+ "</font></font></td>"
					+ "</tr>"
					+ "<tr>"
					+ "<td  width=\"50%\" align='left' style=\"border:1px solid black;border-collapse:collapse;\" ><b><font size =\"1\" face=\"Arial\"> Correo Electrónico: </font></b></td>"
					+ "<td  width=\"50%\" align='left' style=\"border:1px solid black;border-collapse:collapse;\" ><font size =\"0\" face=\"Arial\"><font size =\"1\" face=\"Arial\">"
					+ email
					+ "</font></font></td>"
					+ "</tr>"
		            + "<tr>"
                    + "<td  width=\"50%\" align='left' style=\"border:1px solid black;border-collapse:collapse;\" ><b><font size =\"1\" face=\"Arial\"> ¿Como se enteró de la página?: </font></b></td>"
                    + "<td  width=\"50%\" align='left' style=\"border:1px solid black;border-collapse:collapse;\" ><font size =\"0\" face=\"Arial\"><font size =\"1\" face=\"Arial\">"
                    + radio
                    + "</font></font></td>"
                    + "</tr>"
					+ "<tr>"
					+ "<td  width=\"50%\" align='left' style=\"border:1px solid black;border-collapse:collapse;\" ><b><font size =\"1\" face=\"Arial\"> Deseo recibir más información de capacitaciones y productos KWX.: </font></b></td>"
					+ "<td  width=\"50%\" align='left' style=\"border:1px solid black;border-collapse:collapse;\" ><font size =\"0\" face=\"Arial\"><font size =\"1\" face=\"Arial\">"
					+ recibirInfo
					+ "</font></font></td>"
					+ "</tr>"
					+ "<tr>"
					+ "<td  width=\"50%\" align='left' style=\"border:1px solid black;border-collapse:collapse;\" ><b><font size =\"1\" face=\"Arial\"> coordenadas: </font></b></td>"
					+ "<td  width=\"50%\" align='left' style=\"border:1px solid black;border-collapse:collapse;\" ><font size =\"0\" face=\"Arial\"><font size =\"1\" face=\"Arial\">"
					+ latitud
					+ ","
					+ longitud
					+ "</font></font></td>"
					+ "</tr>"
					+

					"<tr>"
					+ "<td  width=\"50%\" align='left' style=\"border:1px solid black;border-collapse:collapse;\" ><b><font size =\"1\" face=\"Arial\"> Fotografia: </font></b></td>"
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
	       
	        DataSource fds = new FileDataSource(Ruta+"mecanicos/fachada/"+ fotografia);
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
