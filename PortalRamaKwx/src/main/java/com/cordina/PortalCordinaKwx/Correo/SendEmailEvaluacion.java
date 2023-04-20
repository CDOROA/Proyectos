package com.cordina.PortalCordinaKwx.Correo;

import java.io.InputStream;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.cordina.PortalCordinaKwx.Util.clsLog;

public class SendEmailEvaluacion {

	
	public static void send(String to, String sub, String msg)
	{ 
		//System.out.println("SEND....1");

		Properties properties= new Properties();
		//System.out.println("SEND....2");
		try  
		{
			InputStream  inputStream  = SendEmailEvaluacion.class.getClassLoader().getResourceAsStream("/properties/mail.properties");
			properties.load(inputStream);
		} 
		catch  (Exception ex) 
		{
			ex.printStackTrace();
			System.out.println("PortalRama KWX - Error al cargar properties en envio de evaluacion: " + ex );
		}		
	
		//System.out.println("SEND....3");
			
		try
		{
			Session session = Session.getInstance(properties,new javax.mail.Authenticator()
			{
				protected PasswordAuthentication getPasswordAuthentication() 
				{
					return new PasswordAuthentication("adminkwx@cdoautopartes.com.mx","StEhS6er89");
				//	return new PasswordAuthentication("webadmin@cedisa.com.mx","3at0pX7L");
				}
			});
			//System.out.println("SEND....4");
			MimeMessage message = new MimeMessage(session); // (session);
			message.setFrom(new InternetAddress("adminkwx@cdoautopartes.com.mx"));
		
			message.addRecipient(Message.RecipientType.TO,new InternetAddress("aux2-mkt-cdf@cedisa.com.mx"));
			message.addRecipient(Message.RecipientType.TO,new InternetAddress("gmp-cdmx@cedisa.com.mx"));
			message.addRecipient(Message.RecipientType.TO,new InternetAddress("jp-cdf@cedisa.com.mx"));
			message.addRecipient(Message.RecipientType.CC,new InternetAddress("soportetecnico@cedisa.com.mx"));
			message.addRecipient(Message.RecipientType.CC,new InternetAddress("atencionaclientes@kwx.com.mx"));
	message.addRecipient(Message.RecipientType.BCC,new InternetAddress("armando.rosas@corprama.com.mx"));

			message.setSubject(sub);			
			message.setContent(msg, "text/html; charset=ISO-8859-1");
		//	System.out.println("SEND....5");
			//Transport.send(message);
			
			
			Transport transport = session.getTransport("smtp");
		//	System.out.println("SEND....5 generando objeto transport");
			transport.connect((String) properties.get("mail.smtp.host"),
					"webadmin@cedisa.com.mx","3at0pX7L");
		//	System.out.println("SEND....5 conecto con servidor");
			transport.sendMessage(message,
					message.getRecipients(javax.mail.Message.RecipientType.TO));
		//	System.out.println("SEND....5 envio mensaje");
			transport.close();
		//	System.out.println("SEND....5 cerro conexcion");
			
		//	System.out.println("SEND....6");
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("PortalRama KWX - Error al enviar correo de Evaluacion: " + e);
			System.out.println("PortalRama KWX - Error al enviar correo de Evaluacion getLocalizedMessage: " + e.getLocalizedMessage());
			System.out.println("PortalRama KWX - Error al enviar correo de Evaluacion getMessage: " + e.getMessage());
			System.out.println("PortalRama KWX - Error al enviar correo de Evaluacion getCause: " + e.getCause());
			System.out.println("PortalRama KWX - Error al enviar correo de Evaluacion getClass().getName: " + e.getClass().getName());
			clsLog.RegistraLog("PortalRama KWX - SendEmailEvaluacion.SEND", "getLocalizedMessage: "+ e.getLocalizedMessage().replace("'",""));
			clsLog.RegistraLog("PortalRama KWX - SendEmailEvaluacion.SEND", "getMessage: "+ e.getMessage().replace("'",""));
			clsLog.RegistraLog("PortalRama KWX - SendEmailEvaluacion.SEND", "getCause: "+ e.getClass().getName().replace("'",""));
			clsLog.RegistraLog("PortalRama KWX - SendEmailEvaluacion.SEND", "getClass().getName: "+ e.getLocalizedMessage().replace("'",""));
		}
	}
}

