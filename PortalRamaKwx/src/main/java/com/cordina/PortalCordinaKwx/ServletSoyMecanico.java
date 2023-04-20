package com.cordina.PortalCordinaKwx;

import java.io.IOException;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cordina.PortalCordinaKwx.Correo.SendEmailContactoV2;
import com.cordina.PortalCordinaKwx.Util.clsLog;
import com.cordina.PortalCordinaKwx.conexionBd.connectionManagerV2;
import com.cordina.PortalCordinaKwx.dto.EspecialidadTaller;
import com.cordina.PortalCordinaKwx.dto.EstadosDto;


import com.google.gson.Gson;

public class ServletSoyMecanico extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private Connection conn;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	String DatosValidos = "";

	public ServletSoyMecanico() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
        response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
        response.setHeader("Expires", "-1"); // Proxies.

		main(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
        response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
        response.setHeader("Expires", "-1"); // Proxies.

		main(request, response);
	}

	public void main(HttpServletRequest request, HttpServletResponse response) {
		try {
			//System.out.println(" 1. INICIO ServletSoyMecanico");
			int operacion = 1;
			int producto = 0;

			List<EstadosDto> listEstados = new ArrayList<EstadosDto>();

			//System.out.println(" 2. INICIO ServletSoyMecanico");

			try {
				operacion = Integer.parseInt(request.getParameter("operacion"));
			} catch (Exception ex) {
				String sError = ex.getMessage().toString();
				System.out.println("PortalRama KWX - ERROR get operacion: " + sError);
			}

		//	System.out.println(" 3. INICIO ServletSoyMecanico OPERACION= "
		//			+ operacion);

			switch (operacion) {
			case 1:
				
				List<EspecialidadTaller> listaEspecialidades = ConsutlaEspecialidaTalleres();
				listEstados = ObtieneEstados();
// System.out.println("listaEspecialidades:"+ listaEspecialidades.size());
				request.setAttribute("listEstados", listEstados);
				request.setAttribute("listaEspecialidades",listaEspecialidades);
				request.setAttribute("str_estado", 0);
				RequestDispatcher rd = request
						.getRequestDispatcher("/jsp/SoyMecanico.jsp");
				rd.forward(request, response);
				break;
			case 2:
			//	System.out.println("entrando a recuperaInfrmacion...");
				recuperaInfrmacion(request, response);
				Gson gson = new Gson();
				String listaJson = gson.toJson("");
				response.setContentType("application/json");
				PrintWriter out = response.getWriter();
				out.write(listaJson);
				break;
			case 3:
				listEstados = ObtieneEstados();

				request.setAttribute("listEstados", listEstados);
				request.setAttribute("str_estado", 0);
				RequestDispatcher rd2 = request
						.getRequestDispatcher("/jsp/SoyMecanico2.jsp");
				rd2.forward(request, response);
				break;
			}

		} catch (Exception ex) {
			String sError = ex.getMessage().toString();
			System.out.println("PortalRama KWX - ServletSoyMecanico error= " + sError);

		}
	}

	private void recuperaInfrmacion(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			String Estado = request.getParameter("cmbListaEstados");
			String Municipio = request.getParameter("cmbMunicipios");
			String Colonia = request.getParameter("txtColonia");
			String Cp = request.getParameter("txtCp");
			String Calle = request.getParameter("txtCalle");
			String NumExt = request.getParameter("txtNumExt");
			String NumInt = request.getParameter("txtNumInt");
			String NombreTaller = request.getParameter("txtNombreTaller");
			String NombreEncargado = request.getParameter("txtEncargado");
			String BrindaServisioDomicilio = request
					.getParameter("cmbBrindaServisioDomicilio");
			String Telefono = request.getParameter("txtTelefono");
			String Whatsapp = request.getParameter("txtWhatsapp");
			String Email = request.getParameter("txtEmail");
			String fotografia = request.getParameter("fotografia");
			String RecibirInfo = request.getParameter("chkRecibirInfo");
			String latitud = request.getParameter("lat");
			String longitud = request.getParameter("lon");

			String radio = request.getParameter("radio");
			String especialidad = request.getParameter("especialidad");
			
			String dataForm = request.getParameter("dataForm");
			String fileUp = request.getParameter("fileUp");
			// fotografia = "nombreFoto";

			//System.out.println("Estado: " + Estado);
			//System.out.println("Municipio: " + Municipio);
			//System.out.println("Colonia: " + Colonia);
			//System.out.println("Cp: " + Cp);
			//System.out.println("Calle: " + Calle);
			//System.out.println("NumExt:" + NumExt);
			//System.out.println("NumInt: " + NumInt);
			//System.out.println("NombreTaller: " + NombreTaller);
			//System.out.println("NombreEncargado: " + NombreEncargado);
			//System.out.println("BrindaServisioDomicilio: "
			//					+ BrindaServisioDomicilio);
			//System.out.println("Telefono: " + Telefono);
			//System.out.println("Whatsapp: " + Whatsapp);
			//System.out.println("Email: " + Email);
			//System.out.println("fotografia: " + fotografia);
			//System.out.println("RecibirInfo: " + RecibirInfo);
			//System.out.println("latitud: " + latitud);
			//System.out.println("longitud: " + longitud);

			// System.out.println("dataForm: " + dataForm.toString());
			// Part filePart = request.getPart("fileUp"); // Retrieves <input
			// type="file" name="file">
			// System.out.println("fileUp: " + fileUp);
			// System.out.println("fileUpbytes: " +
			// request.getParameter("fileUp").getBytes());

			int result = CargaInformacionBD(Estado, Municipio, Colonia, Cp,
					Calle, NumExt, NumInt, NombreTaller, NombreEncargado,
					BrindaServisioDomicilio, Telefono, Whatsapp, Email, radio, especialidad,
					fotografia, RecibirInfo, latitud, longitud);

			//  if (result == 1) {
			//	EnviarCorreoContacto(request, response, Email);		
			//	}
			
		} catch (Exception ex) {
			System.out.println("PortalRama KWX - error recuperaInfrmacion :" + ex);
		}
	}

	private int CargaInformacionBD(String Estado, String Municipio,
			String Colonia, String Cp, String Calle, String NumExt,
			String NumInt, String NombreTaller, String NombreEncargado,
			String BrindaServisioDomicilio, String Telefono, String Whatsapp,
			String Email, String radio, String especialidad, String fotografia, String RecibirInfo,
			String latitud, String longitud) {
		int Resultado = 0;
		try {
			//System.out.println("CargaInformacionBD... 1");
			String Qry = "INSERT INTO KWX.c_mecanicos (estado, municipio, colonia, cp, calle, num_ext, num_int, nombre_taller,nombre_encargado, servicio_a_domicilo,"
					+ " telefono, whatsapp, email,fotografia,recibir_informacion, latitud, longitud, estatus,id_especialidad,como_se_entero_pagina, fecha_pro, hora_pro) VALUES ("
					+ "'"
					+ Estado.trim().toUpperCase()
					+ "', '"
					+ Municipio.trim().toUpperCase()
					+ "', '"
					+ Colonia.trim().toUpperCase()
					+ "', '"
					+ Cp
					+ "', '"
					+ Calle.trim().toUpperCase()
					+ "', '"
					+ NumExt
					+ "', '"
					+ NumInt
					+ "', '"
					+ NombreTaller.trim().toUpperCase()
					+ "', '"
					+ NombreEncargado.trim().toUpperCase()
					+ "','"
					+ BrindaServisioDomicilio.trim().toUpperCase()
					+ "', '"
					+ Telefono
					+ "', '"
					+ Whatsapp
					+ "', '"
					+ Email
					+ "', '"
					+ fotografia.trim()
					+ "','"
					+ RecibirInfo.trim().toUpperCase()
					+ "','"
					+ latitud
					+ "', '" + longitud + "','P"
					+ "','"
					+ especialidad
					+ "','"
					+radio
					+ "', "
					+"DATE(NOW()),TIME(NOW()));";
			//System.out.println("CargaInformacionBD... 2");

			Resultado = CrearConexionBaseDatosInsert(Qry);
			//System.out.println("CargaInformacionBD... 3");
			//System.out.println("resultado insert: " + Resultado);

			CierraConexion();
			//System.out.println("CargaInformacionBD... 4");
		} catch (Exception e) {
			String sError = e.getMessage().toString();

			System.out.println("PortalRama KWX - Error SendEmailContactoNuevoMecanico.SEND :" + e);
			System.out.println("PortalRama KWX - Error al CargaInformacionBD: " + e);
			System.out.println("PortalRama KWX - Error al CargaInformacionBD getLocalizedMessage: " + e.getLocalizedMessage());
			System.out.println("PortalRama KWX - Error al CargaInformacionBD getMessage: " + e.getMessage());
			System.out.println("PortalRama KWX - Error al CargaInformacionBD getCause: " + e.getCause());
			System.out.println("PortalRama KWX - Error al CargaInformacionBD getClass().getName: " + e.getClass().getName());
			clsLog.RegistraLog("PortalRama KWX - ServletSoyMecanico.CargaInformacionBD", "getLocalizedMessage: "+ e.getLocalizedMessage().replace("'",""));
			clsLog.RegistraLog("PortalRama KWX - ServletSoyMecanico.CargaInformacionBD", "getMessage: "+ e.getMessage().replace("'",""));
			clsLog.RegistraLog("PortalRama KWX - ServletSoyMecanico.CargaInformacionBD", "getCause: "+ e.getClass().getName().replace("'",""));
			clsLog.RegistraLog("PortalRama KWX - ServletSoyMecanico.CargaInformacionBD", "getClass().getName: "+ e.getLocalizedMessage().replace("'",""));
			return 0;
		}
		return Resultado;
	}

	public List<EstadosDto> ObtieneEstados() {
		List<EstadosDto> listEstados = new ArrayList<EstadosDto>();

		try {
			String Qry = "SELECT  DISTINCT A.id_cve_edo, "
					+ "A.nombre  "
					+ "FROM 	comercio_electronico.c_estados AS A WHERE A.id_cve_edo !='40' ORDER BY A.nombre;";

			ResultSet rs_estados = CrearConexionBaseDatos(Qry);

			if (rs_estados != null) {
				while (rs_estados.next()) {
					try {
						EstadosDto estado = new EstadosDto();
						estado.setCve_estado(rs_estados.getInt("id_cve_edo"));
						estado.setDescripcion(rs_estados.getString("nombre"));
						listEstados.add(estado);
					} catch (Exception ex) {
						String sError = ex.getMessage().toString();
						CierraConexion();
					}
				}
			}
			
		} catch (Exception ex) {
			
			String sError = ex.getMessage().toString();
		}
		finally {
			CierraConexion();
		}
		return listEstados;
	}

	public ResultSet CrearConexionBaseDatos(String sql) {
		ResultSet rs1 = null;
		try {
			conn = connectionManagerV2.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs1 = pstmt.executeQuery();

		} catch (Exception e) {
			CierraConexion();
			String sError = e.getMessage().toString();
			clsLog.RegistraLog("ServletSoyMecanico.CrearConexionBaseDatos", "getLocalizedMessage: "+ e.getLocalizedMessage().replace("'",""));
			clsLog.RegistraLog("ServletSoyMecanico.CrearConexionBaseDatos", "getMessage: "+ e.getMessage().replace("'",""));
			clsLog.RegistraLog("ServletSoyMecanico.CrearConexionBaseDatos", "getCause: "+ e.getClass().getName().replace("'",""));
			clsLog.RegistraLog("ServletSoyMecanico.CrearConexionBaseDatos", "getClass().getName: "+ e.getLocalizedMessage().replace("'",""));
		}
		return rs1;
	}

	public int CrearConexionBaseDatosInsert(String sql) {
		int isInsertadoAc = 0;
		try {
			conn = connectionManagerV2.getConnection();
			pstmt = conn.prepareStatement(sql);
			isInsertadoAc = pstmt.executeUpdate();
		} catch (Exception e) {
			CierraConexion();
			String sError = e.getMessage().toString();
			clsLog.RegistraLog("ServletSoyMecanico.CrearConexionBaseDatosInsert", "getLocalizedMessage: "+ e.getLocalizedMessage().replace("'",""));
			clsLog.RegistraLog("ServletSoyMecanico.CrearConexionBaseDatosInsert", "getMessage: "+ e.getMessage().replace("'",""));
			clsLog.RegistraLog("ServletSoyMecanico.CrearConexionBaseDatosInsert", "getCause: "+ e.getClass().getName().replace("'",""));
			clsLog.RegistraLog("ServletSoyMecanico.CrearConexionBaseDatosInsert", "getClass().getName: "+ e.getLocalizedMessage().replace("'",""));
		}
		
		return isInsertadoAc;
	}

	public void CierraConexion() {
		try {
			connectionManagerV2.closeConnection(conn);

		} catch (Exception ex) {
			String sError = ex.getMessage().toString();
			System.out.println("PortalRama KWX - ERROR: " + sError);
		}
	}

	public void EnviarCorreoContacto(HttpServletRequest request,
			HttpServletResponse response, String emailDestinatario) {
		try {
			//System.out.println("EnviarCorreoContacto entro...");
			DateFormat df = new SimpleDateFormat(
					"dd 'de' MMMM 'de' yyyy hh:mm:ss aaa");
			Date FechaAct = new Date();
			String Fecha = df.format(FechaAct);

			response.setContentType("text/html;charset=ISO-8859-1");
			String to = emailDestinatario;
			String subject = "Contacto Kwx " + Fecha;

			String message = "<b><font size =\"2\" face=\"Arial\">" + Fecha
					+ "</font></b><br><br>";
			message += "<font size =\"2\" face=\"Arial\">Buen Día</font><br><br><br>";
			message += "<font size =\"2\" face=\"Arial\">Se les informa que el usuario</font> <b><font size =\"2\" face=\"Arial\"> </font></b> <font size =\"2\" face=\"Arial\"> envió sus comentarios por medio de la página de KWX, para que sean atendidos.</font> <br><br><br>";

			message += "<table id=\"table_cdf\" style=\"border:1px solid black;border-collapse:collapse; \" width=\"30%\">"
					+ "<tr>"
					+ "<td  width=\"10%\" align='center' style=\"border:1px solid black;border-collapse:collapse; background-color:#CCCCCC; color:black \" ><b><font size =\"1\" face=\"Arial\"> DATO </font></b></td>"
					+ "<td  width=\"90%\" align='center' style=\"border:1px solid black;border-collapse:collapse; background-color:#CCCCCC; color:black \" ><b><font size =\"1\" face=\"Arial\"> RESPUESTA </font></b></td>"
					+ "</tr>"
					+

					"<tr>"
					+ "<td  width=\"10%\" align='left' style=\"border:1px solid black;border-collapse:collapse;\" ><b><font size =\"1\" face=\"Arial\"> Nombre: </font></b></td>"
					+ "<td  width=\"90%\" align='left' style=\"border:1px solid black;border-collapse:collapse;\" ><font size =\"0\" face=\"Arial\"><font size =\"1\" face=\"Arial\"> <img src=\"cid:image\"> </font></font></td>"
					+ "</tr>"
					+ "<tr>"
					+ "<td  width=\"10%\" align='left' style=\"border:1px solid black;border-collapse:collapse;\" ><b><font size =\"1\" face=\"Arial\"> País: </font></b></td>"
					+ "<td  width=\"90%\" align='left' style=\"border:1px solid black;border-collapse:collapse;\" ><font size =\"0\" face=\"Arial\"><font size =\"1\" face=\"Arial\"> </font></font></td>"
					+ "</tr>"
					+ "<tr>"
					+ "<td  width=\"10%\" align='left' style=\"border:1px solid black;border-collapse:collapse;\" ><b><font size =\"1\" face=\"Arial\"> Ciudad: </font></b></td>"
					+ "<td  width=\"90%\" align='left' style=\"border:1px solid black;border-collapse:collapse;\" ><font size =\"0\" face=\"Arial\"><font size =\"1\" face=\"Arial\"> </font></font></td>"
					+ "</tr>"
					+

					"<tr>"
					+ "<td  width=\"10%\" align='left' style=\"border:1px solid black;border-collapse:collapse;\" ><b><font size =\"1\" face=\"Arial\"> Calle: </font></b></td>"
					+ "<td  width=\"90%\" align='left' style=\"border:1px solid black;border-collapse:collapse;\" ><font size =\"0\" face=\"Arial\"><font size =\"1\" face=\"Arial\"> </font></font></td>"
					+ "</tr>"
					+ "<tr>"
					+ "<td  width=\"10%\" align='left' style=\"border:1px solid black;border-collapse:collapse;\" ><b><font size =\"1\" face=\"Arial\"> Num. Int.: </font></b></td>"
					+ "<td  width=\"90%\" align='left' style=\"border:1px solid black;border-collapse:collapse;\" ><font size =\"0\" face=\"Arial\"><font size =\"1\" face=\"Arial\"> </font></font></td>"
					+ "</tr>"
					+ "<tr>"
					+ "<td  width=\"10%\" align='left' style=\"border:1px solid black;border-collapse:collapse;\" ><b><font size =\"1\" face=\"Arial\"> Num. Ext.: </font></b></td>"
					+ "<td  width=\"90%\" align='left' style=\"border:1px solid black;border-collapse:collapse;\" ><font size =\"0\" face=\"Arial\"><font size =\"1\" face=\"Arial\"> </font></font></td>"
					+ "</tr>"
					+

					"<tr>"
					+ "<td  width=\"10%\" align='left' style=\"border:1px solid black;border-collapse:collapse;\" ><b><font size =\"1\" face=\"Arial\"> Colonia: </font></b></td>"
					+ "<td  width=\"90%\" align='left' style=\"border:1px solid black;border-collapse:collapse;\" ><font size =\"0\" face=\"Arial\"><font size =\"1\" face=\"Arial\"> </font></font></td>"
					+ "</tr>"
					+ "<tr>"
					+ "<td  width=\"10%\" align='left' style=\"border:1px solid black;border-collapse:collapse;\" ><b><font size =\"1\" face=\"Arial\"> Del./Mun.: </font></b></td>"
					+ "<td  width=\"90%\" align='left' style=\"border:1px solid black;border-collapse:collapse;\" ><font size =\"0\" face=\"Arial\"><font size =\"1\" face=\"Arial\"> </font></font></td>"
					+ "</tr>"
					+ "<tr>"
					+ "<td  width=\"10%\" align='left' style=\"border:1px solid black;border-collapse:collapse;\" ><b><font size =\"1\" face=\"Arial\"> C.P.: </font></b></td>"
					+ "<td  width=\"90%\" align='left' style=\"border:1px solid black;border-collapse:collapse;\" ><font size =\"0\" face=\"Arial\"><font size =\"1\" face=\"Arial\"> </font></font></td>"
					+ "</tr>"
					+

					"<tr>"
					+ "<td  width=\"10%\" align='left' style=\"border:1px solid black;border-collapse:collapse;\" ><b><font size =\"1\" face=\"Arial\"> Lada: </font></b></td>"
					+ "<td  width=\"90%\" align='left' style=\"border:1px solid black;border-collapse:collapse;\" ><font size =\"0\" face=\"Arial\"><font size =\"1\" face=\"Arial\"> </font></font></td>"
					+ "</tr>"
					+ "<tr>"
					+ "<td  width=\"10%\" align='left' style=\"border:1px solid black;border-collapse:collapse;\" ><b><font size =\"1\" face=\"Arial\"> Teléfono: </font></b></td>"
					+ "<td  width=\"90%\" align='left' style=\"border:1px solid black;border-collapse:collapse;\" ><font size =\"0\" face=\"Arial\"><font size =\"1\" face=\"Arial\"> </font></font></td>"
					+ "</tr>"
					+ "<tr>"
					+ "<td  width=\"10%\" align='left' style=\"border:1px solid black;border-collapse:collapse;\" ><b><font size =\"1\" face=\"Arial\"> Celular: </font></b></td>"
					+ "<td  width=\"90%\" align='left' style=\"border:1px solid black;border-collapse:collapse;\" ><font size =\"0\" face=\"Arial\"><font size =\"1\" face=\"Arial\"> </font></font></td>"
					+ "</tr>"
					+

					"<tr>"
					+ "<td width=\"10%\" colspan=\"1\"  align='left' style=\"border:1px solid black;border-collapse:collapse;\" ><b><font size =\"1\" face=\"Arial\"> Correo: </font></b></td>"
					+ "<td width=\"90%\" colspan=\"5\"  align='left' style=\"border:1px solid black;border-collapse:collapse;\" ><font size =\"0\" face=\"Arial\"><font size =\"1\" face=\"Arial\"> </font></font></td>"
					+ "</tr>"
					+

					"<tr>"
					+ "<td width=\"10%\" colspan=\"1\"  align='left' style=\"border:1px solid black;border-collapse:collapse;\" ><b><font size =\"1\" face=\"Arial\"> Mensaje: </font></b></td>"
					+ "<td width=\"90%\" colspan=\"5\"  align='left' style=\"border:1px solid black;border-collapse:collapse;\" ><font size =\"0\" face=\"Arial\"><font size =\"1\" face=\"Arial\"> </font></font></td>"
					+ "</tr>";

			message += "</table><br><br><br>";

			message += "<b><u><font size =\"2\" face=\"Arial\"> Atte.:Página Web KWX </font></u></b> <br><br>";
			//System.out.println("EnviarCorreoContacto preparado mensaje...");
			SendEmailContactoV2.send(to, subject, message);
		//	System.out.println("EnviarCorreoContacto envio mensage...");
		} catch (Exception ex) {
			String sError = ex.getMessage().toString();
			System.out.println("EnviarCorreoContacto sError..." + sError);
		}
	}
	
	public List<EspecialidadTaller> ConsutlaEspecialidaTalleres(){
		
		ResultSet rs = null;
		try {
			List<EspecialidadTaller> listaEspecialidades = new ArrayList<EspecialidadTaller>();
			String qry = "SELECT id_especialidad as id, trim(descripcion) as descripcion FROM KWX.c_especialidad_taller;";

			rs = CrearConexionBaseDatos(qry);

			if (rs != null) {
				while (rs.next()) {
					EspecialidadTaller esp = new EspecialidadTaller();
					esp.setId(rs.getInt("id"));
					esp.setDescripcion(rs.getString("descripcion"));
					listaEspecialidades.add(esp);
				}
			}
			CierraConexion();
		
				
			return listaEspecialidades;
		}catch(Exception ex)
		{
			System.out.println("PortalRama KWX - Error - ConsutlaEspecialidaTalleres:" + ex);
			return null;
		}
		finally {
			CierraConexion();
		}
	}
	
	
}
