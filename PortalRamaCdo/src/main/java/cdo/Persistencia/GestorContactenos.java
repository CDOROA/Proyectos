package cdo.Persistencia;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import cdo.Datos.Contactenos;
import cdo.Datos.InfoCliente;
import cdo.Datos.Log;
import cdo.Datos.Querys;
import cdo.Util.Cls_Log;
import cdo.Util.Cls_Querys;
import cdo.Util.ConexionBD;
import cdo.Util.EjecutaQuerysBD;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class GestorContactenos {
	
	DecimalFormat formatoDecimal = new DecimalFormat("#,###.00");
	private  static Properties properties = null;	
	
	static 
	{
	      try  
	      {
		      properties = new Properties();
		      InputStream  inputStream  = GestorContactenos.class.getClassLoader().getResourceAsStream("/properties/mail.properties");
		      properties.load(inputStream);	
	      }
	      catch  (Exception ex) 
	      {
	        ex.printStackTrace();
	      }
	 }	
	
	/******  INSERTA REGISTRO DE CONTCATENOS  ******/
	public boolean insertaRegistroContactenos(List<Querys> listaQuerys, Contactenos contacto) 
	{
		boolean  insertoCorrectamente = false;		
		Connection connBD = null;
		PreparedStatement pstm = null;
		connBD = ConexionBD.abrirConexionBD();
		try
		{
			String[] querys = new String[25];	
			querys = Cls_Querys.LimpiaListaQuerys(querys);	
			querys = Cls_Querys.ObtieneQuerys(23, listaQuerys, querys);
			querys = inicializaQueryNumero23(querys, contacto);
			pstm = connBD.prepareStatement("{call " + "comercio_electronico.usp_EXECUTE_QUERY(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			ResultSet rs = EjecutaQuerysBD.EjecutarQuery(querys[0], querys[1],querys[2], querys[3], querys[4], querys[5], querys[6],
					 querys[7], querys[8], querys[9],querys[10], querys[11], querys[12], querys[13], 
					 querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], 
					 querys[21], querys[22], querys[23], querys[24], "",pstm, connBD);
			
			
			Cls_Querys.ImprimeQuerysConsola(querys,false,"Query 23");
			
			if(rs != null)
			{
				 while(rs.next())
				 {
					 contacto.setNombre_estado(rs.getString("nombreEstado"));
					 contacto.setUname_br(rs.getString("uname_br"));
				 }
			}			
			insertoCorrectamente = true;
			enviarContactoPorCorreo(contacto);
			Log log=new Log(0,0,0,0, "[Accion: Inserta datos del contacto . ]");
			Cls_Log.insertaLog(log);
		}
		catch (Exception ex) 
		{
			System.out.println("[NuevoportalRamaCDO.- Error: Insertar datos del contacto,  Clase: GestorContactenos,  Detalle: " + ex.getMessage().toString() +"]");
			Log log=new Log(0,0,0 ,0, "[Error:  Insertar datos del contacto,  Clase: GestorContactenos,  Detalle: " + ex.getMessage().toString() +"]");
			Cls_Log.insertaLog(log);
		}	
		finally 
		{
			try {pstm.close();} catch (SQLException e) {e.printStackTrace();}
			try {connBD.close();} catch (SQLException e) {e.printStackTrace();}
		}
		return insertoCorrectamente;
	}
	
	/******  ENVIA CORREO DE CONTCATENOS ******/
	public void enviarContactoPorCorreo( Contactenos contacto) throws MessagingException
    {
        String correoEmisor = properties.getProperty("mail.login.username");
        String correoHost = properties.getProperty("mail.smtp.host");
        String correoPass=  properties.getProperty("mail.login.password");
        String correoDestino=  properties.getProperty("email.mercadotecnia.rama");
        String asunto = "Venta en Línea Contactenos";
        
        String contenidoDelMensaje = generarContenidoDeCorreoContacto(contacto);
       
        Properties props = System.getProperties();
        props.put("mail.smtp.host", correoHost);
        props.put("mail.smtp.user", correoEmisor);
        props.put("mail.smtp.clave", correoPass);
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.port", "587");
        Session session = Session.getDefaultInstance(props);
        MimeMessage message = new MimeMessage(session);
   
        try
        {
            message.setFrom(new InternetAddress(correoEmisor));
            message.addRecipients(Message.RecipientType.TO, correoDestino);
            message.setSubject(asunto);
            message.setContent(contenidoDelMensaje, "text/html");
            Transport transport = session.getTransport("smtp");
            transport.connect(correoHost, correoEmisor,correoPass);
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();
        }
        catch (javax.mail.MessagingException me)
        {
            me.printStackTrace();           
        }
    }
   
    private String generarContenidoDeCorreoContacto(Contactenos contacto)
    {       
        String sFechaHoraSistema = "";
        String contenidoDelMensaje = "";
       
        SimpleDateFormat formatter = new SimpleDateFormat("dd 'de' MMMM 'de' yyyy hh:mm:ss aaa");
        Date fechaHoraSistema = Calendar.getInstance().getTime();
        sFechaHoraSistema = formatter.format(fechaHoraSistema);    
        
        String esCteCDO =(String.valueOf(contacto.getEs_cliente_cdo()).equals("0")) ? "NO" : "SI";
       
        contenidoDelMensaje += "<%@ page language=\"java\" contentType=\"text/html; charset=ISO-8859-1\" pageEncoding=\"ISO-8859-1\"%>";
        contenidoDelMensaje += "<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">";
        contenidoDelMensaje += "<html>";               
      
        contenidoDelMensaje += "<h3><font face=\"Arial\" color=#004099>Contacto registrado por www.cdoautopartes.com.mx</font></h3>";
        
        contenidoDelMensaje += "<font size =\"2\" face=\"Arial\" color=#004099>" + sFechaHoraSistema + "</font><br><br>";
        contenidoDelMensaje += "<font size =\"12px\" face=\"Arial\" color=black>Nombre: <font color=black>"+ contacto.getNombre().toUpperCase() +" "+contacto.getApellido_paterno().toUpperCase()+" "+contacto.getApellido_materno().toUpperCase()+"</font> </font><br><br>";
        contenidoDelMensaje += "<font size =\"12px\" face=\"Arial\" color=black>Telefono: <font color=black>"+contacto.getTelefono()+"</font> </font><br><br>";
        contenidoDelMensaje += "<font size =\"12px\" face=\"Arial\" color=black>Email: <font color=black>"+contacto.getCorreo()+"</font> </font><br><br>";
        contenidoDelMensaje += "<font size =\"12px\" face=\"Arial\" color=black>Estado:<font color=black> "+contacto.getNombre_estado().toUpperCase()+"</font> </font><br><br>";
        contenidoDelMensaje += "<font size =\"12px\" face=\"Arial\" color=black>Tipo Negocio:<font color=black> "+contacto.getNombreTipoNegocio().toUpperCase()+"</font> </font><br><br>";
        contenidoDelMensaje += "<font size =\"12px\" face=\"Arial\" color=black>CDO con cobertura:<font color=black> "+contacto.getUname_br().toUpperCase()+"</font> </font><br><br>";
        contenidoDelMensaje += "<font size =\"12px\" face=\"Arial\" color=black>Es Cliente de CDO: <font color=black>"+ esCteCDO +"</font> </font>";
        if(esCteCDO.equals("SI")) {
        	contenidoDelMensaje += "<font size =\"12px\" face=\"Arial\" color=black> -  Num.Cliente:<font color=black> "+contacto.getNum_cli()+"</font> </font><br><br>";
        }
        else {
        	contenidoDelMensaje +="<br><br>";
        }
        contenidoDelMensaje += "<font size =\"12px\" face=\"Arial\" color=black>Mensaje: </font>";
        contenidoDelMensaje += "<font size =\"12px\" face=\"Arial\" color=#004099>      <font color=black>   "+contacto.getMensaje()+"</font></font><br><br>";
       
        contenidoDelMensaje += "<h5><font face=\"Arial\" color=#6792A0>Atte.: www.cdoautopartes.com.mx</font></h5><br>";
        contenidoDelMensaje += "</html>";
        return contenidoDelMensaje;
    }
		    
    /******  INICIALIZA QUERYS  ******/
	private String[] inicializaQueryNumero23(String[] ListaQuerys,Contactenos contacto) 
	{	
		for (int i=0;i <ListaQuerys.length; i++)
		{	
			ListaQuerys[i]= ListaQuerys[i].replace("{NOMBRE}", contacto.getNombre());
			ListaQuerys[i]= ListaQuerys[i].replace("{APELLIDO_MATERNO}",contacto.getApellido_materno());
			ListaQuerys[i]= ListaQuerys[i].replace("{APELLIDO_PATERNO}",contacto.getApellido_paterno());
			ListaQuerys[i]= ListaQuerys[i].replace("{TELEFONO}",String.valueOf(contacto.getTelefono()));
			ListaQuerys[i]= ListaQuerys[i].replace("{CORREO}",contacto.getCorreo());
			ListaQuerys[i]= ListaQuerys[i].replace("{ES_CLIENTE}",String.valueOf(contacto.getEs_cliente_cdo()));
			ListaQuerys[i]= ListaQuerys[i].replace("{NUM_CLI}",String.valueOf(contacto.getNum_cli()));
			ListaQuerys[i]= ListaQuerys[i].replace("{CVE_ESTADO}",String.valueOf(contacto.getId_cve_estado()));
			ListaQuerys[i]= ListaQuerys[i].replace("{MENSAJE}",contacto.getMensaje());
			ListaQuerys[i]= ListaQuerys[i].replace("{TIPO_NEGOCIO}",String.valueOf(contacto.getTipoNegocio()));
		}
		return ListaQuerys;
	}
	
	
}
