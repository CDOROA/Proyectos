package correo;
import java.io.InputStream;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
public class SendEmail {
	
	public static void send(String to, String sub, String msg)
	{ 
		Properties properties= new Properties();
		// System.out.println("SEND....1");
		try  
		{
			//System.out.println("SEND....1 cargando archivo");
			InputStream  inputStream  = SendEmail.class.getClassLoader().getResourceAsStream("/properties/mail.properties");
			properties.load(inputStream);
			//System.out.println("SEND....1 craga terminada");
		} 
		catch  (Exception ex) 
		{
			ex.printStackTrace();
			System.out.println("PortalRama KWX -Error al leer Properpies mail: " + ex);
		}	
	//	System.out.println("SEND....2");
		try
		{
			//System.out.println("SEND....3");
			Session session = Session.getInstance(properties,new javax.mail.Authenticator()
			{
				protected PasswordAuthentication getPasswordAuthentication() 
				{
					return new PasswordAuthentication("adminkwx@cdoautopartes.com.mx","StEhS6er89");
					//return new PasswordAuthentication("webadmin@cedisa.com.mx","3at0pX7L");
				}
			});
			//System.out.println("SEND....4");
			MimeMessage message = new MimeMessage(session); // (session);
			message.setFrom(new InternetAddress("adminkwx@cdoautopartes.com.mx"));
			//System.out.println("SEND....5");
//			 message.addRecipient(Message.RecipientType.TO,new InternetAddress("armando.rosas@corprama.com.mx"));
			
			message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));
	        message.addRecipient(Message.RecipientType.CC,new InternetAddress("armando.rosas@corprama.com.mx"));
	        message.addRecipient(Message.RecipientType.CC,new InternetAddress("ernesto.espinosa@corprama.com.mx"));
	        message.addRecipient(Message.RecipientType.CC,new InternetAddress("daniel.calderon@corprama.com.mx"));
			message.setSubject(sub);			
			message.setContent(msg, "text/html; charset=ISO-8859-1");
			Transport.send(message);
			//System.out.println("SEND....6");
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("PortalRama KWX - ERROR AL ENVIAR MAIL: " + e);
			System.out.println("PortalRama KWX - SendEmailContacto.SEND.- " + "getLocalizedMessage: "+ e.getLocalizedMessage().replace("'",""));
			System.out.println("PortalRama KWX - SendEmailContacto.SEND.- " + "getMessage: "+ e.getMessage().replace("'",""));
			System.out.println("PortalRama KWX - SendEmailContacto.SEND.- " + "getCause: "+ e.getClass().getName().replace("'",""));
			System.out.println("PortalRama KWX - SendEmailContacto.SEND.- " + "getClass().getName: "+ e.getLocalizedMessage().replace("'",""));
		}
	}
}
