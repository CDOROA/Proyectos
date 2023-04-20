package web;

import java.awt.Dimension;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JFrame;

import org.json.JSONObject;

import com.google.gson.Gson;
import com.sun.javafx.tk.Toolkit;

import datos.Anios;
import datos.Armadoras;
import datos.Banners;
import datos.Querys;
import datos.SubMarcas;
import datos.Videos;
import persistencia.GestorArmadoras;
import persistencia.GestorPaginaPrincipal;
import persistencia.GestorVideos;
import util.ConexionBD;

 
public class ServletPaginaPrincipal extends HttpServlet {
	private static final long serialVersionUID = 1L;
	List<Querys> querys = null;      
	Gson gson=new Gson();
 
    public ServletPaginaPrincipal() {
        super();
        this.querys = null;
    }

 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ValidaPeticion(request, response);
	}

	 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

	public void ValidaPeticion(HttpServletRequest request, HttpServletResponse response)
	{
		
			consultaQuerys();
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
				operacion = 1;
			}
			
			//System.out.println("2. INICIA SERVLET OPCION= " + operacion);
			
			switch(operacion)
			{
				case 1:
						List<Banners> listaBanners = ObtenListaBanners();
						request.setAttribute("listaBanners", listaBanners);
						List<Armadoras> listaArmadoras = ObtenListaArmadora();
						request.setAttribute("listaArmadoras", listaArmadoras);
						
						List<Videos> ListVideos= new ArrayList<Videos>();
						ListVideos=ObtenListaVideos();
						request.setAttribute("listaVideos", ListVideos);
						RedirecionaVista("PaginaPrincipal.jsp", request, response);			
				break;
				case 2 :
					/*Cosulta a Submarcas*/
					List<SubMarcas> listaSubMarcas = consultaSubmarcas(request);
					 
					String listaJsonSubMarcas= gson.toJson(listaSubMarcas);
					enviarRespuestaJsonJS(request, response, listaJsonSubMarcas);
					break;
				case 3 :
					/*Cosulta a Submarcas*/
					List<Anios> listaAnios = consultaListaAnios(request);
					String listaJsonAnios= gson.toJson(listaAnios);
					enviarRespuestaJsonJS(request, response, listaJsonAnios);
					break;
					
				case 4 :
					
					/*Cosulta a video*/
					String url_videoprincipal = url_videoprincipal(request);
					String respuestajs= gson.toJson(url_videoprincipal);
					enviarRespuestaJsonJS(request, response, "["+ respuestajs.toString()+"]");
					break;
		}
		}
		catch(Exception ex)
		{
			String sError= ex.getMessage().toString();
			System.out.println("error en ServletPaginaPrincipal.ValidaPeticion = " + ex);
		}
	
	}
	
	private String url_videoprincipal(HttpServletRequest request) {
		// TODO Auto-generated method stub
		
		String respuesta =  ""; 
		respuesta=GestorPaginaPrincipal.consultavideoprincipal(this.querys);
		return respuesta;
	}


	private List<Anios> consultaListaAnios(HttpServletRequest request) {
		Connection connBD = null;
		List<Anios> listaAnios =null;
		try
		{
			String descSubMArca = request.getParameter("desc_sub_marca");
			connBD = ConexionBD.abrirConexionBD();
			listaAnios = GestorArmadoras.obtieneAnios(connBD, this.querys, descSubMArca);
		}
		catch(Exception ex)
		{
			String sError= ex.getMessage().toString();
			System.out.println("[ Portal OEP ] ServletPaginaPrincipal.consultaSubmarcas Error: " + sError);
		}
			finally {
				try {connBD.close();} catch (SQLException e) {e.printStackTrace();}
			}
		return listaAnios;
 
	}


	private List<SubMarcas> consultaSubmarcas(HttpServletRequest request) {
		Connection connBD = null;
		List<SubMarcas> listaSubMarcas =null;
		try
		{
			String cve_armadora = request.getParameter("cve_armadora");
			connBD = ConexionBD.abrirConexionBD();
			listaSubMarcas = GestorArmadoras.obtieneSubMarcas(connBD, this.querys, cve_armadora);
		}
		catch(Exception ex)
		{
			String sError= ex.getMessage().toString();
			System.out.println("[ Portal OEP ] ServletPaginaPrincipal.consultaSubmarcas Error: " + sError);
		}
			finally {
				try {connBD.close();} catch (SQLException e) {e.printStackTrace();}
			}
		return listaSubMarcas;
 
	}


	private List<Armadoras> ObtenListaArmadora() {
		Connection connBD = null;
		List<Armadoras> listaArmadoras =null;
		try
		{
			connBD = ConexionBD.abrirConexionBD();
			listaArmadoras = GestorArmadoras.ObtenArmadoras(connBD, this.querys);
		}
		catch(Exception ex)
		{
			String sError= ex.getMessage().toString();
			System.out.println("[ Portal OEP ] ServletPaginaPrincipal.ObtenListaArmadora Error: " + sError);
		}
			finally {
				try {connBD.close();} catch (SQLException e) {e.printStackTrace();}
			}
		return listaArmadoras;
		}


	private List<Banners> ObtenListaBanners() {
		Connection connBD = null;
		List<Banners> listaBanners =null;
		try
		{
			connBD = ConexionBD.abrirConexionBD();
			listaBanners = GestorPaginaPrincipal.ObtenBanners(connBD, this.querys);
		}
		catch(Exception ex)
		{
			String sError= ex.getMessage().toString();
			System.out.println("[ Portal OEP ] ServletPaginaPrincipal.ObtenListaBanners Error: " + sError);
		}
			finally {
				try {connBD.close();} catch (SQLException e) {e.printStackTrace();}
			}
		return listaBanners;
		}
	
	private void consultaQuerys() {
		Connection connBD = null;
		try
		{
		connBD = ConexionBD.abrirConexionBD();
		this.querys = null;
		this.querys = GestorPaginaPrincipal.ConsultaTablaQuerysBD(connBD);
	}
	catch(Exception ex)
	{
		String sError= ex.getMessage().toString();
		System.out.println("[ Portal OEP ] ServletPaginaPrincipal.consultaQuerys Error: " + sError);
	}
		finally {
			try {connBD.close();} catch (SQLException e) {e.printStackTrace();}
		}
	}

	private List<Videos> ObtenListaVideos() {
		
		Connection connBD = null;
		List<Videos> listaVideos =null;
		try
		{
			connBD = ConexionBD.abrirConexionBD();
			listaVideos = GestorVideos.ObtenVideos(connBD, this.querys);
			
		}
		
		catch(Exception ex)
		{
		
			String sError= ex.getMessage().toString();
			System.out.println("[ Portal OEP ] ServletVideos.ObtenListaVideos Error: " + sError);
		}
			finally {
				
				try {connBD.close();} catch (SQLException e) {e.printStackTrace();}
			}
		
		return listaVideos;
		}
	
	private void RedirecionaVista(String pagina, HttpServletRequest request, HttpServletResponse response)
	{
		try {
	RequestDispatcher rd = request.getRequestDispatcher("/jsp/" + pagina);
	
	
		rd.forward(request, response);
	} catch (Exception e) {

		
	}
	}
	
	/* RESPUESTAS AJAX */	
	private void enviarRespuestaJsonJS(HttpServletRequest request, HttpServletResponse response, String listaJson)
	{
		try
		{
			response.setContentType("application/json");
			PrintWriter out = response.getWriter();
			out.write(listaJson);	
		}
		catch(Exception ex)
		{
			//System.out.println("Error al re-direccionar vista." + ex.getMessage().toString());
		}
	}
}
