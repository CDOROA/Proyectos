package cdo.Servicios;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.TimeZone;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import org.json.JSONException;
import org.json.JSONObject;

import cdo.Datos.LogPDF;
import cdo.Datos.Querys;
import cdo.Persistencia.GestorPDF;
import cdo.Util.ClsQuery;
import cdo.Util.Cls_Logs;
import cdo.Util.ConexionBD;




@Path("/PDF")
public class wsGeneraPDF {
	
	
	List<String> log =new ArrayList<>();
	
	@POST
	@Path("/generaPdf")
	@Produces({"application/pdf" })
	@Consumes(MediaType.APPLICATION_JSON)
    public Response obtenerPdf(String json) throws JSONException, IOException {
		JSONObject dato = new JSONObject(json);
		File file = File.createTempFile(dato.getString("nombre"),".pdf");
		base64StringToPDF(dato.getString("cadena"), file.toString());
        ResponseBuilder response = Response.ok((Object) file);
        response.header("Access-Control-Allow-Origin", "*");
        response.header("Access-Control-Allow-Methods","POST,OPTIONS,GET");
        response.header("Content-Disposition",
          "attachment;filename="+dato.getString("nombre")+".pdf");
        file.deleteOnExit();
        return response.build();    	
	}

	@GET
	@Path("/generaPdfXml")
	@Produces({MediaType.TEXT_PLAIN})
	@Consumes(MediaType.APPLICATION_JSON)
    public String obtenerPdfXml(@QueryParam("cdo")  String cdo, @QueryParam("serie") String serie,
    		@QueryParam("folio") String folio,@QueryParam("correo") String destinatario,@QueryParam("grupo") String grupo,@QueryParam("imp") String imp,
    		@QueryParam("lp") String lp,@QueryParam("imprime") String imprime){
		//String[] cadena= new String[10];
		String impresoras;
		log.add(date()+" Se invoca wsGeneraPDF con los siguientes parametros: "
				+ "cdo="+cdo+" serie="+serie+" folio="+folio+" correo="+destinatario+" grupo="+grupo+" imp="+imp+" lp="+lp+" imprime="+imprime);
		if(imprime==null||(imprime.replaceAll(" ", "")).length()<=0) {
			imp="n";
			imprime="o";
		}
		if (lp != null) {
			impresoras = lp;
		}else {
			impresoras = "0";
		}
		if(imp==null || (imp.replaceAll(" ", "")).length()<=0) {
			imp="n";
		}
		if(imp.equalsIgnoreCase("n")) {
			imprime="o";
		}
		if(destinatario==null|| (destinatario.replaceAll(" ", "")).length()<=0) {
			destinatario="";
		}
		boolean valida2=true;
		do {
			if(folio.length()<10) {
				folio="0"+folio;
			}else {
				valida2=false;
			}
		}while(valida2);
		String valida="false";
		String[] base64=traerBase64(serie, folio,cdo,true).split(",");
		String original="";
		String copia="";
		switch(imprime.toLowerCase()) {
			case "o":
				original=base64[0];
				break;
			case "c":
				copia=base64[1];
				break;
			case "a":
				original=base64[0];
				copia=base64[1];
				break;
			default:
				original=base64[0];
				copia=base64[1];
				imp="a";
				break;
		}
		
		String xml=traerXml(serie,folio,cdo);
		try {
		File file = File.createTempFile(serie+"-"+folio,".pdf");
		File file2 = File.createTempFile(serie+"-"+folio,".xml");
		base64StringToPDF(original, file.toString());
		base64StringToXML(xml.replaceAll("´","'"), file2.toString());
		if(imp.equalsIgnoreCase("s")) {
			File file3 = File.createTempFile(serie+"-"+folio,".pdf");
			base64StringToPDF(copia, file3.toString());
			try {
				if(imprime.equalsIgnoreCase("o")) {
					if(original.length()>0) {
			String[] comandoImprimir = {"lp","-s","-d",impresoras,file.toString()};
			final Process procesoImprimir = Runtime.getRuntime().exec(comandoImprimir);
			log.add(date()+" p-173 Se imprime original serie: "+serie+" folio: "+folio+" comando: lp -s -d " +impresoras+" "+file);
					}else {
						log.add(date()+" p-173 No se imprime original por que la cadena del pdf esta vacia serie: "+serie+" folio: "+folio+" comando: lp -s -d " +impresoras+" "+file);
					}
				}else if(imprime.equalsIgnoreCase("c")) {
					if(copia.length()>0) {
					String[] comandoImprimir = {"lp","-s","-d",impresoras,file3.toString()};
					final Process procesoImprimir = Runtime.getRuntime().exec(comandoImprimir);
					log.add(date()+" p-173 Se imprime copia serie: "+serie+" folio: "+folio+" comando: lp -s -d " +impresoras+" "+file3);
				}else {
					log.add(date()+" p-173 No se imprime copia por que la cadena del pdf esta vacia serie: "+serie+" folio: "+folio+" comando: lp -s -d " +impresoras+" "+file);
					
				}
				}else if(imprime.equalsIgnoreCase("a")){
					if(original.length()>0) {
					String[] comandoImprimir = {"lp","-s","-d",impresoras,file.toString()};
					final Process procesoImprimir = Runtime.getRuntime().exec(comandoImprimir);
					log.add(date()+" p-173 Se imprime original serie: "+serie+" folio: "+folio+" comando: lp -s -d " +impresoras+" "+file);
					}else {
						log.add(date()+" p-173 No se imprime original por que la cadena del pdf esta vacia serie: "+serie+" folio: "+folio+" comando: lp -s -d " +impresoras+" "+file);
					}
					Thread.sleep(3*1000);
					if(copia.length()>0) {
					String[] comandoImprimirc = {"lp","-s","-d",impresoras,file3.toString()};
					final Process procesoImprimirc = Runtime.getRuntime().exec(comandoImprimirc);
					log.add(date()+" p-173 Se imprime copia serie: "+serie+" folio: "+folio+" comando: lp -s -d " +impresoras+" "+file3);
					}else {
						log.add(date()+" p-173 No se imprime copia por que la cadena del pdf esta vacia serie: "+serie+" folio: "+folio+" comando: lp -s -d " +impresoras+" "+file3);
						
					}
					}
			valida="true";
			file3.deleteOnExit();
			}catch(Exception ex){
				log.add(date()+" p-173 El folio: "+folio+", serie: "+serie+" no se imprimio por: "+ex+" : lp -s -d "+impresoras+" "+file);
				valida="false";
			}
			file3.deleteOnExit();
		}else {
			List <String> correos= new ArrayList<>();
			if(grupo==null) {
				grupo="0";
			}
			if(!grupo.equalsIgnoreCase("0")) {
				correos=traeCorreos(grupo,cdo);
			}
			if(destinatario.contains(",")) {
				String[] destinatarios=destinatario.split(",");
				for(int i=0;i<destinatarios.length;i++) {
					correos.add(destinatarios[i].trim());
				}
			}else{
				correos.add(destinatario);
			}
		for(int i=0;i<correos.size();i++) {
		String[] verifica=correos.get(i).split("@");
		boolean validaCorreo=correos.get(i).contains("@");
		if(base64[0].length()>0&&xml.length()>0) {
				if(validaCorreo&&verifica[0].length()>2) {
					mandaCorreo(file,file2,correos.get(i).trim(),traerCuerpo(serie, folio,cdo),serie+"-"+folio,cdo);
					  valida="true";
				}else {
					log.add(date()+" p-173 No se enviaron archivos del folio: "+folio+", serie: "+serie+" por que el correo: "+ correos.get(i)+" no es valido.");
				}
			}else {
				//Cls_Logs.insertarLog(new LogPDF(),cdo,"l","l","Error: No se encontro registro del folio: "+folio+" y serie: "+serie);
				valida="false";
			}
		}
			//valida="true";
			file.deleteOnExit();
			file2.deleteOnExit();
		}
		} catch (IOException e) {
			//Cls_Logs.insertarLog(new LogPDF(),cdo,"l","l","No se enviaros archivos del folio: "+folio+", serie: "+serie);
			valida="false";
		}
		log.add(date()+" Se consumio el wsGeneraPDF con la url: http://172.16.251.88:8080/wsGeneraPDF/ws/PDF/generaPdfXml?cdo="+cdo+"&serie="+serie+"&folio="+folio+"&correo="+destinatario+"&grupo="+grupo+"&imp="+imp+"&lp="+lp+"&imprime="+imprime);
        String log2="";
		for(int i=0;i<log.size();i++) {
        	log2+=log.get(i)+"\n";
        }
		Cls_Logs.insertarLog(cdo,serie,folio,log2);
		return valida;    	
	}
	private List<String> traeCorreos(String grupo, String cdo) {
		Connection connBD = null;
		List <String> correos = new ArrayList<>();
    	try
    	{
	    	connBD = ConexionBD.AbrirConexionBD(cdo);
	    	List<Querys> listaQuerys = ClsQuery.ConsultaTablaQuerysBD(cdo, connBD);
	    	PreparedStatement pstmt = null; 	      	
	    	correos = GestorPDF.recuperaCorreos(cdo,connBD,pstmt,listaQuerys, grupo);     	        
    	}
    	  catch(Exception ex)
    	{
    		System.out.println("Error En metodo traePass " + ex.toString() );
    	}finally
		{
			try {connBD.close();} catch (SQLException e) {e.printStackTrace();}
		}
		return correos;
	}

	private void mandaCorreo2(File file, File file2, File file3, String destinatario, String cuerpo, String nombre,
			String cdo) {
		String[] separa= nombre.split("-");
		String serie=separa[0];
		String folio=separa[1];
		
		Properties props = new Properties();
		props.put("mail.smtp.host", "10.0.0.112");
		props.setProperty("mail.smtp.starttls.enable", "true");
		props.setProperty("mail.smtp.port","587");
		props.setProperty("mail.smtp.auth", "true");
			
		try {
			Session session = Session.getDefaultInstance(props, null);
			//session.setDebug(true);
			 MimeBodyPart messageBodyPart = new MimeBodyPart();
		     messageBodyPart.setContent(cuerpo,"text/html");      
			BodyPart adjunto = new MimeBodyPart();
			BodyPart adjunto2 = new MimeBodyPart();
			//BodyPart adjunto3 = new MimeBodyPart();
			adjunto.setDataHandler(new DataHandler(new FileDataSource(file)));
			adjunto.setFileName(nombre+".pdf");
			adjunto2.setDataHandler(new DataHandler(new FileDataSource(file2)));
			adjunto2.setFileName(nombre+".xml");
			//adjunto3.setDataHandler(new DataHandler(new FileDataSource(file3)));
			//adjunto3.setFileName(nombre+"_pac.pdf");
			MimeMultipart multiParte = new MimeMultipart();
			multiParte.addBodyPart(messageBodyPart);
			multiParte.addBodyPart(adjunto);
			multiParte.addBodyPart(adjunto2);
			//multiParte.addBodyPart(adjunto3);
			MimeMessage message = new MimeMessage(session);
	
			// Se rellena el From
			message.setFrom(new InternetAddress(traeRemitente(cdo)));
	
			// Se rellenan los destinatarios
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(destinatario));
	
			// Se rellena el subject
			message.setSubject("CFDI Centro de Distribucion Oriente "+nombre);
			// Se mete el texto y el archivo adjunto.
			message.setContent(multiParte,"text/html; charset=utf-8");
			Transport t = session.getTransport("smtp");
			t.connect(traeRemitente(cdo),traePass(cdo));
			t.sendMessage(message,message.getAllRecipients());
			t.close();
			file.delete(); 
			file2.delete(); 
			file3.delete(); 
			Cls_Logs.insertarLog(cdo,serie,folio,"p-173 Se enviaron archivos del folio: "+folio+", serie: "+serie+" al correo: "+ destinatario);
		} catch (Exception e) { 
			Cls_Logs.insertarLog(cdo,serie,folio,"Error: No se pudo enviar al correo: "+destinatario);
			e.printStackTrace();
		}
	}

	private String traerCuerpo(String serie, String folio, String cdo) {
		Connection connBD = null;
		String cuerpo = "";
    	try
    	{
	    	connBD = ConexionBD.AbrirConexionBD(cdo);
	    	List<Querys> listaQuerys = ClsQuery.ConsultaTablaQuerysBD(cdo, connBD);
	    	PreparedStatement pstmt = null; 	      	
	    	cuerpo = GestorPDF.recuperaCuerpo(cdo,connBD,pstmt,listaQuerys, serie, folio);     	        
    	}
    	  catch(Exception ex)
    	{
    		System.out.println("Error En metodo consultaDescripcion " + ex.toString() );
    	}finally
		{
			try {connBD.close();} catch (SQLException e) {e.printStackTrace();}
		}
		return cuerpo;
	}

	private String traerXml(String serie, String folio, String cdo) {
		Connection connBD = null;
		String xml = "";
    	try
    	{
    		log.add(date()+" Entra a traerXml");
	    	connBD = ConexionBD.AbrirConexionBD(cdo);
	    	List<Querys> listaQuerys = ClsQuery.ConsultaTablaQuerysBD(cdo, connBD);
	    	PreparedStatement pstmt = null; 	      	
	    	xml = GestorPDF.recuperaXML(cdo,connBD,pstmt,listaQuerys, serie, folio);
	    	log.add(date()+" Sale de traerXml");
	    	
    	}
    	  catch(Exception ex)
    	{
    		System.out.println("Error En metodo consultaDescripcion " + ex.toString() );
    	}finally
		{
			try {connBD.close();} catch (SQLException e) {e.printStackTrace();}
		}
		return xml;
	}

	private String traerBase64(String serie, String folio, String cdo, boolean valida) {
		Connection connBD = null;
		String base64 = "";
    	try
    	{
    		log.add(date()+" Entra a traeBase64");
	    	connBD = ConexionBD.AbrirConexionBD(cdo);
	    	List<Querys> listaQuerys = ClsQuery.ConsultaTablaQuerysBD(cdo, connBD);
	    	PreparedStatement pstmt = null; 	      	
	    	base64 = GestorPDF.recuperaBase64(cdo,connBD,pstmt,listaQuerys, serie, folio, valida);  
	    	log.add(date()+" Sale de traeBase64");
    	}
    	  catch(Exception ex)
    	{
    		System.out.println("Error En metodo consultaDescripcion " + ex.toString() );
    	}finally
		{
			try {connBD.close();} catch (SQLException e) {e.printStackTrace();}
		}
		return base64;
	}

	private void mandaCorreo(File file, File file2, String destinatario, String cuerpo,String nombre, String cdo) {
		String[] separa= nombre.split("-");
		String serie=separa[0];
		String folio=separa[1];
		Properties props = new Properties();
		props.put("mail.smtp.host", "10.0.0.112");
		props.setProperty("mail.smtp.starttls.enable", "true");
		props.setProperty("mail.smtp.port","587");
		props.setProperty("mail.smtp.auth", "true");
			
		try {
			Session session = Session.getDefaultInstance(props, null);
			//session.setDebug(true);
			 MimeBodyPart messageBodyPart = new MimeBodyPart();
		     messageBodyPart.setContent(cuerpo,"text/html");      
			BodyPart adjunto = new MimeBodyPart();
			BodyPart adjunto2 = new MimeBodyPart();
			adjunto.setDataHandler(new DataHandler(new FileDataSource(file)));
			adjunto.setFileName(nombre+".pdf");
			adjunto2.setDataHandler(new DataHandler(new FileDataSource(file2)));
			adjunto2.setFileName(nombre+".xml");
			MimeMultipart multiParte = new MimeMultipart();
			multiParte.addBodyPart(messageBodyPart);
			multiParte.addBodyPart(adjunto);
			multiParte.addBodyPart(adjunto2);
			MimeMessage message = new MimeMessage(session);
	
			// Se rellena el From
			message.setFrom(new InternetAddress(traeRemitente(cdo)));
	
			// Se rellenan los destinatarios
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(destinatario));
	
			// Se rellena el subject
			message.setSubject("CFDI Centro de Distribucion Oriente "+nombre);
			// Se mete el texto y el archivo adjunto.
			message.setContent(multiParte,"text/html; charset=utf-8");
			Transport t = session.getTransport("smtp");
			t.connect(traeRemitente(cdo),traePass(cdo));
			t.sendMessage(message,message.getAllRecipients());
			t.close();
			//file.delete(); 
			//file2.delete();
			log.add(date()+" p-173 Se enviaron archivos del folio: "+folio+", serie: "+serie+" al correo: "+ destinatario);
		} catch (Exception e) { 
			log.add(date()+" Error: No se pudo enviar al correo: "+destinatario);
			e.printStackTrace();
		}
	
		
	}

	private String traePass(String cdo) {
		Connection connBD = null;
		String pass = "";
    	try
    	{
	    	connBD = ConexionBD.AbrirConexionBD(cdo);
	    	List<Querys> listaQuerys = ClsQuery.ConsultaTablaQuerysBD(cdo, connBD);
	    	PreparedStatement pstmt = null; 	      	
	    	pass = GestorPDF.recuperaPass(cdo,connBD,pstmt,listaQuerys);     	        
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
	    	remitente = GestorPDF.recuperaRemitente(cdo,connBD,pstmt,listaQuerys);     	        
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

	public void base64StringToXML(String datos, String Ruta) {
		try {
			/*byte[] bytes = decoder.decodeBuffer(datos);
			ByteArrayInputStream bais = new ByteArrayInputStream(bytes);
			BufferedInputStream bin = new BufferedInputStream(bais);
			File file = new File(newFile);
			FileOutputStream fout = new FileOutputStream(file);
			BufferedOutputStream bout = new BufferedOutputStream(fout);
			byte[] buffers = new byte[1024];
			int len = bin.read(buffers);
			while (len != -1) {
				bout.write(buffers, 0, len);
				len = bin.read(buffers);
			}
			bout.flush();
			bout.close();*/
			
			//String ruta = "/ruta/filename.txt";
            //String contenido = "Contenido de ejemplo";
            File file = new File(Ruta);
            // Si el archivo no existe es creado
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(datos);
            bw.close();
		} catch (Exception e) { 
			e.printStackTrace();
		}


     }

	@POST
	@Path("/generaXml")
	@Produces({"application/pdf" })
	@Consumes(MediaType.APPLICATION_JSON)
    public Response obtenerXml(String json) throws JSONException, IOException {
		JSONObject dato = new JSONObject(json);
		File file = File.createTempFile(dato.getString("nombre"),".pdf");
		base64StringToPDF(dato.getString("cadena"), file.toString());
        ResponseBuilder response = Response.ok((Object) file);
        response.header("Access-Control-Allow-Origin", "*");
        response.header("Access-Control-Allow-Methods","POST,OPTIONS,GET");
        response.header("Content-Disposition",
          "attachment;filename="+dato.getString("nombre")+".pdf");
        file.deleteOnExit();
        return response.build();    	
	}
	
	public void base64StringToPDF(String datos, String newFile) {
		try {
			byte[] bytes = Base64.getDecoder().decode(datos);
			ByteArrayInputStream bais = new ByteArrayInputStream(bytes);
			BufferedInputStream bin = new BufferedInputStream(bais);
			File file = new File(newFile);
			FileOutputStream fout = new FileOutputStream(file);
			BufferedOutputStream bout = new BufferedOutputStream(fout);
			byte[] buffers = new byte[1024];
			int len = bin.read(buffers);
			while (len != -1) {
				bout.write(buffers, 0, len);
				len = bin.read(buffers);
			}
			bout.flush();
			bout.close();
		} catch (Exception e) { 
			e.printStackTrace();
		}

     }
	
	public String date(){
		TimeZone myTimeZoneFile = TimeZone.getTimeZone("America/Mexico_City");
		Calendar cal= Calendar.getInstance(myTimeZoneFile);
		int year= cal.get(Calendar.YEAR);
		String mes = obtenerMes((cal.get(Calendar.MONTH)+1));
		String dia = obtenerMes(cal.get(Calendar.DAY_OF_MONTH));
		TimeZone myTimeZone = TimeZone.getTimeZone("America/Mexico_City");
		DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss.SSS");
		dateFormat.setTimeZone(myTimeZone);
		Date date = new Date();
		return ""+(year)+"-"+(mes)+"-"+(dia)+" "+dateFormat.format(date)+"";
	}
		private String obtenerMes(int valor){
			String retorna = "";
			if (valor<10){
				retorna = "0"+valor;
			}else{
				retorna = String.valueOf(valor);
			}
			return retorna;
		}
	@POST
	@Path("/enviarPdf")
	@Consumes(MediaType.APPLICATION_JSON)
    public void enviarPdf(String json) throws JSONException, IOException {
		JSONObject dato = new JSONObject(json);
		File file = File.createTempFile(dato.getString("nombre"),".pdf");
		base64StringToPDF(dato.getString("cadena"), file.toString());
		Properties props = new Properties();
		props.put("mail.smtp.host", "10.0.0.112");
		props.setProperty("mail.smtp.starttls.enable", "true");
		props.setProperty("mail.smtp.port","587");
		props.setProperty("mail.smtp.auth", "true");
			
		try {
			Session session = Session.getDefaultInstance(props, null);
			//session.setDebug(true);
			BodyPart texto = new MimeBodyPart();
			texto.setText(dato.getString("cuerpo"));
			BodyPart adjunto = new MimeBodyPart();
			adjunto.setDataHandler(new DataHandler(new FileDataSource(file)));
			adjunto.setFileName(dato.getString("nombre")+".pdf");
			MimeMultipart multiParte = new MimeMultipart();
			multiParte.addBodyPart(texto);
			multiParte.addBodyPart(adjunto);
			MimeMessage message = new MimeMessage(session);
	
			// Se rellena el From
			message.setFrom(new InternetAddress("webadmin@cdoautopartes.com.mx"));
	
			// Se rellenan los destinatarios
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(dato.getString("destinatario")));
	
			// Se rellena el subject
			message.setSubject(dato.getString("nombre"));
	
			// Se mete el texto y el archivo adjunto.
			message.setContent(multiParte);
			Transport t = session.getTransport("smtp");
			t.connect("webadmin@cdoautopartes.com.mx","3at0pX7L");
			t.sendMessage(message,message.getAllRecipients());
			t.close();
			file.delete(); 
		} catch (Exception e) { 
			e.printStackTrace();
		}
	}
}
