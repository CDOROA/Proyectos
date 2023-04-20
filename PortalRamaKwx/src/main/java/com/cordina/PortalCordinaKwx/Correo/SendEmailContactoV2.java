package com.cordina.PortalCordinaKwx.Correo;

import java.io.InputStream;
import java.util.Properties;

import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import com.cordina.PortalCordinaKwx.Util.clsLog;

public class SendEmailContactoV2 {
private static String imagePath;
	
	
	
	public static void send(String to, String sub, String msg)
	{ 
		//System.out.println("SEND....1");
		Properties properties = new Properties();

		String Ruta = "";

		try {
			InputStream inputStream = SendEmailContactoV2.class.getClassLoader()
					.getResourceAsStream("/properties/mail.properties");
			properties.load(inputStream);
		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println("PortalRama KWX - EROR AL LEER Properties: " + ex);
		}

		Ruta = "ImagesCorreo/";

		
		try {
			//System.out.println("SEND....2");
			Session  session = Session.getInstance(properties, new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication("adminkwx@cdoautopartes.com.mx", "StEhS6er89");
				//	return new PasswordAuthentication("webadmin@cedisa.com.mx","3at0pX7L");
				}
			});
		//	System.out.println("SEND....3");
			
			MimeMessage message = new MimeMessage(session); // (session);
			message.setFrom(new InternetAddress("adminkwx@cdoautopartes.com.mx"));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			message.addRecipient(Message.RecipientType.TO,new
			InternetAddress("aux2-mkt-cdf@cedisa.com.mx"));
			message.addRecipient(Message.RecipientType.TO,new
			InternetAddress("gmp-cdmx@cedisa.com.mx"));
			message.addRecipient(Message.RecipientType.TO,new
			InternetAddress("jp-cdf@cedisa.com.mx"));
			message.addRecipient(Message.RecipientType.CC,new
			InternetAddress("soportetecnico@cedisa.com.mx"));
			message.addRecipient(Message.RecipientType.CC,new
			InternetAddress("atencionaclientes@kwx.com.mx"));
			message.addRecipient(Message.RecipientType.BCC,new InternetAddress("armando.rosas@corprama.com.mx"));
		
			
			
			message.setSubject(sub);
			//message.setContent(msg, "text/html; charset=ISO-8859-1");
		//	System.out.println("SEND....4");
			// first part (the html)
			BodyPart messageBodyPart = new MimeBodyPart();
			String htmlText = "<html><body style='text-align: center;'>"
					// +"<table id=\"table_cdf\" style=\"width=\"50%\">"
					+ "<table id='table_cdf' style='width:75%;'>"
					+ "<tr><td style='text-align: left;'> <H2>Estimado mecánico</H2></td></tr>"
					+ "<tr><td style='text-align: justify;'><p style='font-size: 18px;'>Le damos la bienvenida a nuestra página de registro, le informamos que su registro ha sido exitoso, ahora forma parte de nuestra base de datos para que pueda llegar a más clientes finales."
					+ "Lo invitamos a conocer más de nuestros productos, dónde comprarlos y nuestra ficha de inspección para mantenimiento que le será de gran utilidad en su taller mecánico."
					+ "</p></tr></td>" 
					+ "<tr><td><img width='100%'  src='http://www.kwx.com.mx/PortalRamaKwx/image/mecanicos/Correo_ficha_inspeccion2.png'> </br> </tr></td>"				 
					+ "<tr><td><a href='https://youtu.be/1qgZAg0NCz8'><img width='33%' src='http://www.kwx.com.mx/PortalRamaKwx/image/mecanicos/Boton_Ficha_inspeccion.png'> </a> </br> </tr></td>"
					+ "<tr><td><img width='100%' src='http://www.kwx.com.mx/PortalRamaKwx/image/mecanicos/Correo_productos_kwx2.png'>  </br> </tr></td>"
					+ "<tr><td><a href='https://cutt.ly/7rw7oNg'><img width='33%' src='http://www.kwx.com.mx/PortalRamaKwx/image/mecanicos/Boton_productosKWX.png'> </a> </br> </tr></td>"
					+ "<tr><td><img width=\"100%\" src='http://www.kwx.com.mx/PortalRamaKwx/image/mecanicos/Correo_kits2.png'>  </br> </tr></td>"
					+ "<tr><td><table tyle=\"width=\"100%\"><tr>"
					+ "<td style=\"width=\"33%\"><a href='https://cutt.ly/brTLd7I'><img width=\"100%\" src='http://www.kwx.com.mx/PortalRamaKwx/image/mecanicos/Boton_Guia_kits_lub.png'></a></td>"
					+ "<td style=\"width=\"33%\"><a href='https://cutt.ly/7rTLfze'><img width=\"100%\" src='http://www.kwx.com.mx/PortalRamaKwx/image/mecanicos/Boton_Kits_afin_c-a.png'></a></td>"
					+ "<td style=\"width=\"33%\"><a href='https://cutt.ly/5rTLf8F'><img width=\"100%\" src='http://www.kwx.com.mx/PortalRamaKwx/image/mecanicos/Boton_Kits_afin_s_a.png'></a></td>"
					+ "</tr></table></td></tr>" + "<tr><td><img width=\"100%\" src='http://www.kwx.com.mx/PortalRamaKwx/image/mecanicos/Correo_recuerda2.png'>  </br> </tr></td>"
					+ "<tr><td>" + "<table tyle=\"width=\"100%\"><tr>"
					+ "<td style=\"width=\"33%\"><a href='https://www.facebook.com/kwxautomotriz'><img src='http://www.kwx.com.mx/PortalRamaKwx/image/mecanicos/Correo_redes1.png' width='5%' ></a>"
					+ "<a href='https://www.youtube.com/channel/UCek61qopOCr8N2S_zRwhgBw'><img src='http://www.kwx.com.mx/PortalRamaKwx/image/mecanicos/Correo_redes2.png' width='5%' ></a>"
					+ "<a href='https://www.pinterest.com.mx/kwxautomotriz/pins/'><img src='http://www.kwx.com.mx/PortalRamaKwx/image/mecanicos/Correo_redes3.png'  width='5%' ></a> "
					+ " <img  src='http://www.kwx.com.mx/PortalRamaKwx/image/mecanicos/Correo_redes4.png' width='20%' > &nbsp; &nbsp; &nbsp;"
					+ "<a href='https://www.instagram.com/kwx_automotriz/'><img src='http://www.kwx.com.mx/PortalRamaKwx/image/mecanicos/Correo_redes5.png' width='5%' ></a>"
					+ "<img src='http://www.kwx.com.mx/PortalRamaKwx/image/mecanicos/Correo_redes6.png' width='20%' > &nbsp; &nbsp; &nbsp;"
					+ "<a href='http://www.kwx.com.mx/PortalRamaKwx/'><img  src='http://www.kwx.com.mx/PortalRamaKwx/image/mecanicos/Correo_redes7.png' width='5%' ></a>"
					+ "<img src='http://www.kwx.com.mx/PortalRamaKwx/image/mecanicos/Correo_redes8.png' width='20%' >" + "</td>"
					/*
					 * +"<td style=\"width=\"33%\">" + "</td>" +"<td style=\"width=\"33%\">"
					 * +"</td>"
					 */
					+ "</tr></table>" + "</tr></td>" + " </table> </body></html>";
			messageBodyPart.setContent(htmlText, "text/html; charset=ISO-8859-1");

		//	System.out.println("SEND....6");
			// add it
			MimeMultipart multipart = new MimeMultipart("related");
			multipart.addBodyPart(messageBodyPart);

			
			messageBodyPart = new MimeBodyPart();

			message.setContent(multipart);
			Transport.send(message);

		} catch (Exception e) {
			e.printStackTrace();
			clsLog.RegistraLog("PortalRama KWX - SendEmailContactoV2.SEND", "getLocalizedMessage: "+ e.getLocalizedMessage().replace("'",""));
			clsLog.RegistraLog("PortalRama KWX - SendEmailContactoV2.SEND", "getMessage: "+ e.getMessage().replace("'",""));
			clsLog.RegistraLog("PortalRama KWX - SendEmailContactoV2.SEND", "getCause: "+ e.getClass().getName().replace("'",""));
			clsLog.RegistraLog("PortalRama KWX - SendEmailContactoV2.SEND", "getClass().getName: "+ e.getLocalizedMessage().replace("'",""));
		
		}
	}
	
}
