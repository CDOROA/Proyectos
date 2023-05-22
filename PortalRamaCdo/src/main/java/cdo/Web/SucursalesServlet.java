package cdo.Web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import cdo.Datos.InformacionInicial;
import cdo.Datos.Querys;
import cdo.Datos.Sucursales;
import cdo.Persistencia.GestorPaginaPrincipal;
import cdo.Persistencia.GestorQueAutoparteBusca;
import cdo.Persistencia.GestorSucursales;


public class SucursalesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static  GestorSucursales gestorSucursales;
	GestorPaginaPrincipal gestorInicial;
	static List<Querys> querys;
 
    public SucursalesServlet() {
        super();
        gestorSucursales= new GestorSucursales();
    	gestorInicial=new GestorPaginaPrincipal();
    	this.querys =null;
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 this.querys = gestorInicial.ConsultaTablaQuerysBD();
		 response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
		 response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
		 response.setHeader("Expires", "-1"); // Proxies.
		verificaPeticionOrigen(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	private void verificaPeticionOrigen(HttpServletRequest request, HttpServletResponse response)
	{
		String vistaOrigen= String.valueOf(request.getParameter("vista"));
		String operacion= String.valueOf(request.getParameter("operacion"));
		Gson gson = new Gson();
		
		switch(vistaOrigen)
		{
			case "PaginaPrincipal.jsp":
					
				switch(operacion)
				{
					case "ConsultaSucursalxEdo":
						Sucursales listaSucursales = consultaSucursalesEstado(request);
						String listaJson = gson.toJson(listaSucursales);
						enviarRespuestaJsonJS(request,response, listaJson);
						break;		
						
					case "ConsultaSucursalesCDOs":
						List<Sucursales> listaSucursalesCDOs = consultaSucursalesCDOs(request);
						String listaJsonCdos = gson.toJson(listaSucursalesCDOs);
						enviarRespuestaJsonJS(request,response, listaJsonCdos);
						break;
				}									
			break;
		}
	}	
	
	/******   CONUSULTA TODAS LA SUCURSALES DE CDO   ******/	
	private List<Sucursales> consultaSucursalesCDOs(HttpServletRequest request)
	{
		List<Sucursales> listaSucursalesCDOs= gestorSucursales.consultaSucursalesCDOs(this.querys);
		return listaSucursalesCDOs;
	}
		
	/******   CONUSULTA ASUCURSALE POR ESTADO  ******/
	private Sucursales consultaSucursalesEstado(HttpServletRequest request)
	{
		String cve_edo = request.getParameter("cve_edo");
		Sucursales listaSucursales = new Sucursales();
		listaSucursales = gestorSucursales.consultaSucursalesXEdo(this.querys, cve_edo);
		return listaSucursales;
	}
	
	
	/******   RESPUESTAS AJAX   ******/
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
