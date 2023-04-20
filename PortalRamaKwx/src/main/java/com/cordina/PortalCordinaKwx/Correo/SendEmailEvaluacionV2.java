package com.cordina.PortalCordinaKwx.Correo;

import java.io.InputStream;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.cordina.PortalCordinaKwx.Util.clsLog;

public class SendEmailEvaluacionV2 {

	private static Properties properties = null;

	static {
		try {
			properties = new Properties();
			InputStream inputStream = SendEmailEvaluacionV2.class.getClassLoader()
					.getResourceAsStream("/properties/mail.properties");
			properties.load(inputStream);

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public static boolean send(String to, String sub, String msg) {
		boolean correoEnviado = false;
	//	System.out.println("SEND....1");
		String correoEmisor = properties.getProperty("mail.login.username");
		String correoReceptor = "";
		String correoHost = properties.getProperty("mail.smtp.host");
		String correoPass = properties.getProperty("mail.login.password");
	//	System.out.println("SEND....2");
		Properties props = System.getProperties();
		props.put("mail.smtp.host", correoHost);
		props.put("mail.smtp.user", correoEmisor);
		props.put("mail.smtp.clave", correoPass);
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.port", "25");
	//	System.out.println("SEND....3");
		Session session = Session.getDefaultInstance(props);
		MimeMessage message = new MimeMessage(session);
	//	System.out.println("SEND....4");
		try {
			//System.out.println("SEND....5");
			message.setFrom(new InternetAddress(correoEmisor));
		//	System.out.println("SEND....5.1");
			message.addRecipients(Message.RecipientType.TO, correoReceptor);
		//	System.out.println("SEND....5.2");
			message.setSubject(sub);
		//	System.out.println("SEND....5.3");
			// message.setContent(msg);
			message.setContent(msg, "text/html");
		//	System.out.println("SEND....5.4");
			Transport transport = session.getTransport("smtp");
		//	System.out.println("SEND....5.5.. conecatndo...");
			transport.connect(correoHost, correoEmisor, correoPass);
		//	System.out.println("SEND....5.6.. Conexion establecisa, enviando...");
			transport.sendMessage(message, message.getAllRecipients());
		//	System.out.println("SEND....5.7.. Mensage Enviado!");
			transport.close();
		//	System.out.println("SEND....6");
			correoEnviado = true;
		} catch (Exception e) {
			System.out.println("PortalRama KWX - Error SendEmailEvaluacionV2 al enviar correo: " + e);
			correoEnviado = false;
			clsLog.RegistraLog("PortalRama KWX - SendEmailEvaluacionV2.SEND", "getLocalizedMessage: "+ e.getLocalizedMessage().replace("'",""));
			clsLog.RegistraLog("PortalRama KWX - SendEmailEvaluacionV2.SEND", "getMessage: "+ e.getMessage().replace("'",""));
			clsLog.RegistraLog("PortalRama KWX - SendEmailEvaluacionV2.SEND", "getCause: "+ e.getClass().getName().replace("'",""));
			clsLog.RegistraLog("PortalRama KWX - SendEmailEvaluacionV2.SEND", "getClass().getName: "+ e.getLocalizedMessage().replace("'",""));
		}
	
		// System.out.println("SEND....7: " + correoEnviado);
		return correoEnviado;
		
	}
}
