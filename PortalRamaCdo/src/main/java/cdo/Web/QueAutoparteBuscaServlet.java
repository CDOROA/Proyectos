package cdo.Web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import cdo.Datos.Armandoras;
import cdo.Datos.InformacionInicial;
import cdo.Datos.QueAutoparteBuscaArticulos;
import cdo.Datos.Querys;
import cdo.Datos.SubMarcas;
import cdo.Persistencia.GestorPaginaPrincipal;
import cdo.Persistencia.GestorQueAutoparteBusca;


public class QueAutoparteBuscaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static  GestorQueAutoparteBusca gestorAutoBusca;
	GestorPaginaPrincipal gestorInicial;
	static List<Querys> querys;
       
    public QueAutoparteBuscaServlet() {
        super();
        gestorAutoBusca= new GestorQueAutoparteBusca();
    	gestorInicial=new GestorPaginaPrincipal();
        this.querys = null;
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.querys = gestorInicial.ConsultaTablaQuerysBD();
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
		response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
		response.setHeader("Expires", "-1"); // Proxies.
		verificaPeticionOrigen(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	
	private void verificaPeticionOrigen(HttpServletRequest request, HttpServletResponse response)
	{
		String vistaOrigen= String.valueOf(request.getParameter("vista"));
		String operacion= String.valueOf(request.getParameter("operacion"));
		Gson gson = new Gson();
		//System.out.println("vistaOrigen: " + vistaOrigen);
		//System.out.println("operacion: " + operacion);
		switch(vistaOrigen)
		{
		
			case "PaginaPrincipal.jsp":
				switch (operacion) 
				{
					case "consultaCatalogoArmadoras":
						List<Armandoras> listaArmadoras = consultaCatalogoDeArmadoras(request);
						String listaJson = gson.toJson(listaArmadoras);
						enviarRespuestaJsonJS(request,response, listaJson);
						break;
						
					case "consultaCatalogoSubMarcas":
						List<SubMarcas> listaSubmarcas = consultaCatalogoDeSubMarca(request);
						String listaJsonSubMarcas = gson.toJson(listaSubmarcas);
						enviarRespuestaJsonJS(request,response, listaJsonSubMarcas);
						break;
					case "consultaArticulos":
						List<QueAutoparteBuscaArticulos> listaArticulos = consultaArticulos(request);						
						String listaJsonArticulos = gson.toJson(listaArticulos);
						enviarRespuestaJsonJS(request,response, listaJsonArticulos);
						break;
				}
			break;
			
		}
	}	
	
	
	/******   CONUSULTA ARMADORAS   ******/
	private List<Armandoras> consultaCatalogoDeArmadoras(HttpServletRequest request)
	{
		String desc_marca = request.getParameter("desMarca");
		String desc_artriculo = request.getParameter("desArticulo");
		List<Armandoras> listaArmadoras =gestorAutoBusca.consultaCatalogoDeArmadoras(this.querys, desc_marca, desc_artriculo);		
		return listaArmadoras;
		
	}
	
	/******   CONUSULTA SUBMARCA   ******/
	private List<SubMarcas> consultaCatalogoDeSubMarca(HttpServletRequest request)
	{
		String desc_marca = request.getParameter("desMarca");
		String desc_artriculo = request.getParameter("desArticulo");
		String desArmadora = request.getParameter("desArmadora");
		List<SubMarcas> listaSubMarcas =gestorAutoBusca.consultaCatalogoDeSubMarcas(this.querys, desc_marca, desc_artriculo,desArmadora);		
		return listaSubMarcas;
		
	}
	
	/******   CONUSULTA ARTICULOS POR PARAMETROS   ******/
	private List<QueAutoparteBuscaArticulos> consultaArticulos(HttpServletRequest request)
	{
		String desc_marca = request.getParameter("desMarca");
		String desc_artriculo = request.getParameter("desArticulo");
		String descArmadora = request.getParameter("desArmadora");
		String descSubmarca = request.getParameter("desSubmarca");
		String descGrupo = request.getParameter("desGrupo");
		List<QueAutoparteBuscaArticulos> listaArticulos =gestorAutoBusca.consultaArticulos(this.querys, desc_marca, desc_artriculo,descArmadora, descSubmarca, descGrupo);		
		return listaArticulos;
		
	}
	
	
	/******   RESPUESTAS AJAX  ******/
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
	
	private void redireccionarVista(HttpServletRequest request, HttpServletResponse response, String vista)
	{
		try
		{
			RequestDispatcher rdIndex = request.getRequestDispatcher("jsp/" + vista);			    	
		    rdIndex.forward(request, response);
		}
		catch(Exception ex)
		{
		//	System.out.println("Error al re-direccionar vista." + ex.getMessage().toString());
		}
	}

}
