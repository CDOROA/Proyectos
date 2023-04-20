package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import correo.SendEmail;
import datos.Banners;


public class ServletContacto extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ServletContacto() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ValidaPeticion(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	public void ValidaPeticion(HttpServletRequest request, HttpServletResponse response)
	{
		
		String txtNombre = "";
		String txtCorreo = "";
		String txtTelefono = "";
		String txtMessage = "";		
		String seccion = "";
		String destinatario =""; 
		
		try
		{
			int operacion = 1;
			try
			{
				operacion = Integer.parseInt(request.getParameter("operacion"));
			}
			catch(Exception ex)
			{
				String sError= ex.getMessage().toString();
				//System.out.println("main inicio operacion ERROR: " + sError);
			}
 
			switch(operacion)
			{
				case 1:
					RedirecionaVista("Contacto.jsp", request, response);			 
				break;
				case 2:				
					txtNombre = "";
					txtCorreo = "";
					txtTelefono = "";
					txtMessage = "";		
					seccion = "Atencion al Cliente";
					destinatario ="atencionaclientes@oep.com.mx"; 
					try
					{
						txtNombre = removeCaracteres(request.getParameter("nombre"));
						txtCorreo = request.getParameter("correo");
						txtTelefono = request.getParameter("whatsapp");
						txtMessage = removeCaracteres(request.getParameter("mensaje"));
					}
					catch(Exception ex)
					{
						String sError= ex.getMessage().toString();
						System.out.println("[ Portal OEP ]- ERROR: " + sError);
					}
					
					enviarCorreo(request, response, txtNombre,txtTelefono,txtCorreo, txtMessage, seccion,destinatario);
					enviarRespuestaTextoJS(request,response, "true");		 
				break;
				case 3:		
					txtNombre = "";
					txtCorreo = "";
					txtTelefono = "";
					txtMessage = "";		
					seccion = "Soporte Tecnico";
					destinatario ="soportetecnico@oep.com.mx"; 
					try
					{
						txtNombre = removeCaracteres(request.getParameter("nombre"));
						txtCorreo = request.getParameter("correo");
						txtTelefono = request.getParameter("whatsapp");
						txtMessage = removeCaracteres(request.getParameter("mensaje"));
					}
					catch(Exception ex)
					{
						String sError= ex.getMessage().toString();
						System.out.println("[ Portal OEP ] - ERROR: " + sError);
					}
				
					enviarCorreo(request, response, txtNombre,txtTelefono,txtCorreo, txtMessage, seccion,destinatario);
					enviarRespuestaTextoJS(request,response, "true");	
				break;
		}
		}
		catch(Exception ex)
		{
			String sError= ex.getMessage().toString();
		}
	
	}
	
	private void RedirecionaVista(String pagina, HttpServletRequest request, HttpServletResponse response)
	{
		try {
			RequestDispatcher rd = request.getRequestDispatcher("/jsp/" + pagina);
			rd.forward(request, response);
		} catch (Exception e) {

		}
	}
	
	
	private void enviarRespuestaTextoJS(HttpServletRequest request, HttpServletResponse response, String respuesta)
	{
		try
		{
			PrintWriter out = response.getWriter();
		    out.write(respuesta);
		}
		catch(Exception ex)
		{
			//System.out.println("Error al re-direccionar vista." + ex.getMessage().toString());
		}
	}

	public static String removeCaracteres(String input) 
	{
	//	System.out.println("CADENA ENTRADA: " + input);
	    String original = "áàäéèëíìïóòöúùuñÁÀÄÉÈËÍÌÏÓÒÖÚÙÜÑçÇ";
	    String ascii = "aaaeeeiiiooouuunAAAEEEIIIOOOUUUNcC";
	    String output = input;
	    for (int i=0; i<original.length(); i++) {
	        output = output.replace(original.charAt(i), ascii.charAt(i));
	    }
	 //   System.out.println("CADENA SALIDA: " + output);
	    return output;
	}
	
	private void enviarCorreo(HttpServletRequest request, HttpServletResponse response,String txtNombre, String txtTelefono,String txtCorreo, String txtMessage,String seccion, String destinatario) {
		try
		{
			DateFormat df = new SimpleDateFormat("dd 'de' MMMM 'de' yyyy hh:mm:ss aaa");
			Date FechaAct = new Date();
			String Fecha= df.format(FechaAct);
			
			response.setContentType("text/html;charset=ISO-8859-1");	  
	        
	        String subject = "Contacto OEP " + Fecha;
	        
	      
	        String message ="<html><body style='text-align: center;'>"+ 
	        		"<b><font size =\"2\" face=\"Arial\">" + Fecha + "</font></b><br><br>";
			message += "<font size =\"2\" face=\"Arial\">Buen Día</font><br><br><br>";
			message += "<font size =\"2\" face=\"Arial\">Se les informa que el usuario</font> <b><font size =\"2\" face=\"Arial\">" + txtNombre + "</font></b> <font size =\"2\" face=\"Arial\"> envió sus comentarios por medio de la página de OEP, seccion "+ seccion +", para que sean atendidos.</font> <br><br><br>" ;
			
			message +="<table id=\"table_cdf\" style=\"border:1px solid black;border-collapse:collapse; \" width=\"50%\">" +			
					"<tr>" +
						"<td  width=\"20%\" align='center' style=\"border:1px solid black;border-collapse:collapse; background-color:#CCCCCC; color:black \" ><b><font size =\"2\" face=\"Arial\"> DATO </font></b></td>" +
						"<td  width=\"80%\" align='center' style=\"border:1px solid black;border-collapse:collapse; background-color:#CCCCCC; color:black \" ><b><font size =\"2\" face=\"Arial\"> RESPUESTA </font></b></td>" +
					"</tr>" +					
					
					"<tr>" +
						"<td  width=\"20%\" align='left' style=\"border:1px solid black;border-collapse:collapse;\" ><b><font size =\"2\" face=\"Arial\"> Nombre: </font></b></td>" +
						"<td  width=\"80%\" align='left' style=\"border:1px solid black;border-collapse:collapse;\" ><font size =\"2\" face=\"Arial\">"+ txtNombre + "</font></td>" +
					"</tr>" +
					"<tr>" +
					"<td width=\"20%\" align='left' style=\"border:1px solid black;border-collapse:collapse;\" ><b><font size =\"2\" face=\"Arial\"> Correo: </font></b></td>" +
					"<td width=\"80%\" align='left' style=\"border:1px solid black;border-collapse:collapse;\" ><font size =\"2\" face=\"Arial\">"+ txtCorreo + "</font></td>" +
				    "</tr>" +	
					"<tr>" +
						"<td  width=\"20%\" align='left' style=\"border:1px solid black;border-collapse:collapse;\" ><b><font size =\"2\" face=\"Arial\"> Teléfono: </font></b></td>" +
						"<td  width=\"80%\" align='left' style=\"border:1px solid black;border-collapse:collapse;\" ><font size =\"2\" face=\"Arial\">"+ txtTelefono + "</font></td>" +
					"</tr>" +
					"<tr>" +
						"<td width=\"20%\"   align='left' style=\"border:1px solid black;border-collapse:collapse;\" ><b><font size =\"2\" face=\"Arial\"> Mensaje: </font></b></td>" +
						"<td width=\"80%\"   align='left' style=\"border:1px solid black;border-collapse:collapse;\" ><font size =\"2\" face=\"Arial\">"+ txtMessage + "</font></td>" +
					"</tr>" ;
						
			message += "</table><br><br><br>";	
			
			message +=  "<b><u><font size =\"2\" face=\"Arial\"> Atte.:Página Web OEP </font></u></b> <br><br> </html>";
			
	          SendEmail.send(destinatario,subject, message);
		}
		catch(Exception ex)
		{
			String sError= ex.getMessage().toString();
		}
		
	}
	
	
}
