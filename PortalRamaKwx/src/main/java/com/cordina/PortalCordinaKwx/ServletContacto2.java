package com.cordina.PortalCordinaKwx;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cordina.PortalCordinaKwx.Correo.SendEmailContacto;
import com.cordina.PortalCordinaKwx.conexionBd.connectionManager;
import com.cordina.PortalCordinaKwx.conexionBd.connectionManagerV2;
import com.cordina.PortalCordinaKwx.dto.EstadosDto;
import com.cordina.PortalCordinaKwx.dto.clientesKwxDto;
// debug import com.cordina.PortalCordinaKwx.spring.controller.SendEmailContacto;
import com.google.gson.Gson;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ServletContacto2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	private Connection conn;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	 private static final String PATTERN_EMAIL = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	
    public ServletContacto2() {
        super();
        
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
        response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
        response.setHeader("Expires", "-1"); // Proxies.

		main(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
        response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
        response.setHeader("Expires", "-1"); // Proxies.
        
		main(request,response);
	}

	public void main(HttpServletRequest request, HttpServletResponse response)
	{
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
				System.out.println("PortalRama KWX - ERROR: " + sError);
			}
			switch(operacion)
			{
				case 1:
			
					List<clientesKwxDto> listClientes= new ArrayList<clientesKwxDto>();
					listClientes= ConsultaCliente();
					request.setAttribute("listClientes",listClientes);
					RequestDispatcher rd = request.getRequestDispatcher("/jsp/Contacto2.jsp");
					rd.forward(request, response);	
				break;	
				
				case 2:
					
				//	System.out.println("1. contacto");					
					String txtNombre = "";
					String txtCorreo = "";
					String txtTelefono = "";
					String txtMessage = "";					
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
						System.out.println("PortalRama KWX - ERROR: " + sError);
					}
					
				//	guardarInfoCliente(txtNombre,"", "","","", "", "","","","",txtTelefono,"",txtCorreo, txtMessage);
					EnviarCorreoContacto(request, response, txtNombre,txtTelefono,txtCorreo, txtMessage);
					Gson gson = new Gson();
					String listaJson = gson.toJson("");			
					response.setContentType("application/json");
					PrintWriter out = response.getWriter();
					out.write(listaJson);
				break;
			}
		}
		catch(Exception ex)
		{
			String sError= ex.getMessage().toString();
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
	

	public void EnviarCorreoContacto(HttpServletRequest request, HttpServletResponse response,String txtNombre, String txtTelefono,String txtCorreo, String txtMessage)
	{
		try
		{
			DateFormat df = new SimpleDateFormat("dd 'de' MMMM 'de' yyyy hh:mm:ss aaa");
			Date FechaAct = new Date();
			String Fecha= df.format(FechaAct);
			
			response.setContentType("text/html;charset=ISO-8859-1");	  
	        String to ="ana.gonzalez@corprama.com.mx"; 
	        String subject = "Contacto Kwx " + Fecha;
	        
	      
	        String message ="<html><body style='text-align: center;'>"+ 
	        		"<b><font size =\"2\" face=\"Arial\">" + Fecha + "</font></b><br><br>";
			message += "<font size =\"2\" face=\"Arial\">Buen Día</font><br><br><br>";
			message += "<font size =\"2\" face=\"Arial\">Se les informa que el usuario</font> <b><font size =\"2\" face=\"Arial\">" + txtNombre + "</font></b> <font size =\"2\" face=\"Arial\"> envió sus comentarios por medio de la página de KWX, para que sean atendidos.</font> <br><br><br>" ;
			
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
			
			message +=  "<b><u><font size =\"2\" face=\"Arial\"> Atte.:Página Web KWX </font></u></b> <br><br> </html>";
			
	          SendEmailContacto.send(to,subject, message);
		}
		catch(Exception ex)
		{
			String sError= ex.getMessage().toString();
		}
	}
	
	
	public void guardarInfoCliente(String txtNombre, String txtPais, String txtCiudad,String txtCalle, String txtNumInt, String txtNumExt, String txtColonia, String txtDelegacion, String txtCp, String txtLada, String txtTelefono, String txtCelular,String txtCorreo, String txtMessage)
	{
		try
		{
			String Qry = "INSERT 	INTO  KWX.c_contactos_kwx "+
									"(nombre, "+
									"pais, "+
									"ciudad, "+
									"calle, "+
									"num_interno, "+
									"num_externo, "+
									"colonia, "+
									"delegacion, "+
									"cp, "+
									"lada, "+
									"telefono, "+
									"celular, "+
									"correo_electronico, "+
									"mensaje, "+
									"fecha, "+
									"hora) "+
							"VALUES  ( "+
									"'" +txtNombre + "', "+
									"'" +txtPais + "', "+
									"'" +txtCiudad + "', "+
									"'" +txtCalle + "', "+
									"'" +txtNumInt + "', "+
									"'" +txtNumExt + "', "+
									"'" +txtColonia + "', "+
									"'" +txtDelegacion + "', "+
									"'" +txtCp + "', "+
									"'" +txtLada + "', "+
									"'" +txtTelefono + "', "+
									"'" +txtCelular + "', "+
									"'" +txtCorreo + "', "+
									"'" +txtMessage + "', "+
									"DATE(NOW()), "+
									"TIME(NOW()) "+
									") "  ;
		//	System.out.println("query insert: " + Qry );
			CrearConexionBaseDatosInsert(Qry);
		}
		catch(Exception ex)
		{
			System.out.println("Error al guardar registro de contacto: " + ex);
			String sError= ex.getMessage().toString();
			CierraConexion();
		}
		CierraConexion();
	}
		
	public List<clientesKwxDto> ConsultaCliente()
	{
		List<clientesKwxDto> listClientes= new ArrayList<clientesKwxDto>();
		
		try
		{
			String Qry = "SELECT 	A.cve_cliente_kwx, "+
									"A.nombre, "+
									"A.razon_social, "+
									"A.calle, "+
									"A.num_interno, "+
									"A.num_externo, "+
									"A.colonia, "+
									"A.cve_delegacion,  "+
									"C.descripcion AS delegacion,  "+
									"A.cp, "+
									"A.id_cve_edo, "+
									"A.telefono, "+
									"A.correo_electronico, "+
									"A.latitud, "+
									"A.longitud, "+
									"'' cve_producto_kwx "+
							"FROM 	KWX.c_clientes_kwx AS A " +
									" LEFT JOIN KWX.c_delegaciones AS C ON A.cve_delegacion = C.cve_delegacion 	" +
							"WHERE 	cve_cliente_kwx = 1 ";
				
			ResultSet rs_ctes= CrearConexionBaseDatos(Qry);		
						
			if(rs_ctes != null)
			{	
	    		while (rs_ctes.next())
	    		{
		    		try
		    		{
		    			String direc= rs_ctes.getString("calle") + ", Mz. " +  rs_ctes.getString("num_interno") + ", Lt. " + ", " + rs_ctes.getString("colonia") + ", " + rs_ctes.getString("delegacion") + ", C.P: " +rs_ctes.getInt("cp"); 
		    					
		    			clientesKwxDto cte= new clientesKwxDto();
		    			cte.setCve_cliente(rs_ctes.getInt("cve_cliente_kwx"));
		    			cte.setNombre(rs_ctes.getString("nombre"));
		    			cte.setRazonSocial(rs_ctes.getString("razon_social"));
		    			cte.setCalle(rs_ctes.getString("calle"));
		    			cte.setNumInterno(rs_ctes.getString("num_interno"));
		    			cte.setNumExterno(rs_ctes.getString("num_externo"));
		    			cte.setColonia(rs_ctes.getString("colonia"));
		    			cte.setDelegacion(rs_ctes.getString("delegacion"));
		    			cte.setCp(rs_ctes.getString("cp"));
		    			cte.setDireccion(direc);
		    			cte.setId_cve_edo(rs_ctes.getInt("id_cve_edo"));
		    			cte.setTelefono(rs_ctes.getString("telefono"));
		    			cte.setCorreoElectronico(rs_ctes.getString("correo_electronico"));
		    			cte.setLatitud(rs_ctes.getString("latitud"));
		    			cte.setLongitud(rs_ctes.getString("longitud"));
		    			cte.setCve_producto_kwx(rs_ctes.getInt("cve_producto_kwx"));
		    			listClientes.add(cte);
		    			
		    		}
		    		catch(Exception ex)
		    		{
		    			String sError= ex.getMessage().toString();
		    			CierraConexion();
		    		}
	    		}
			}
			CierraConexion();
		}
		catch(Exception ex)
		{
			String sError= ex.getMessage().toString();
		}
			
	//	System.out.println(" 4. CONTACTO");
		return listClientes;
	}
		
	public ResultSet CrearConexionBaseDatos(String sql)
	{
		ResultSet rs1= null;
		try
			{
				conn = connectionManagerV2.getConnection();
				pstmt = conn.prepareStatement(sql);
				rs1 = pstmt.executeQuery();
				
			}catch(Exception ex)
			{
				CierraConexion();
				String sError= ex.getMessage().toString();
				System.out.println("PortalRama KWX - ERROR EJECU. QUERY: " +  sError);
			}
		return rs1;
	}
		
	public int CrearConexionBaseDatosInsert(String sql)
	{
    	int isInsertadoAc= 0;
		try
			{
				conn = connectionManagerV2.getConnection();
				pstmt = conn.prepareStatement(sql);
	    		isInsertadoAc =pstmt.executeUpdate();
			}catch(Exception ex)
			{
				CierraConexion();
				String sError= ex.getMessage().toString();
				System.out.println("PortalRama KWX - ERROR EJECU. QUERY: " +  sError);
			}
		return isInsertadoAc;
	}
		
	public void CierraConexion()
	{
		try
		{
			connectionManagerV2.closeConnection(conn);
			
		}catch(Exception ex)
		{
			String sError= ex.getMessage().toString();
			System.out.println("PortalRama KWX - ERROR: " +  sError);
		}
	}
	
}
