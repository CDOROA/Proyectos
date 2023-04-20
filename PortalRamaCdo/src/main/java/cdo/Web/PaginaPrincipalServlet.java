package cdo.Web;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.text.BreakIterator;
import java.util.List;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import cdo.Datos.InformacionInicial;
import cdo.Datos.NuestraEmpresa;
import cdo.Datos.Querys;
import cdo.Persistencia.GestorPaginaPrincipal;

public class PaginaPrincipalServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static String URL_VIDEO;
	private static String URL_IMG_VIDEO;
	GestorPaginaPrincipal gestorInicial;
	static List<Querys> querys = null;
       
	public void init() throws ServletException 
	{
		Properties proper = new Properties();
        try 
        {
            InputStream input =this.getClass().getClassLoader().getResourceAsStream("/properties/configuracion.properties");
            proper.load(input);  
            this.URL_VIDEO = proper.getProperty("VIDEO_PAG_INICIAL");
            this.URL_IMG_VIDEO = proper.getProperty("IMG_VIDEO_PAG_INICIAL");
        }
        catch (IOException ex)
        {
        	String sError= ex.getMessage().toString();
        }
	}
	
    public PaginaPrincipalServlet() {
        super();
        gestorInicial=new GestorPaginaPrincipal();
        this.querys = null;
        // this.querys = gestorInicial.ConsultaTablaQuerysBD();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
		response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
		response.setHeader("Expires", "-1"); // Proxies.
		verificaPeticionOrigen(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	@SuppressWarnings("static-access")
	private void verificaPeticionOrigen(HttpServletRequest request, HttpServletResponse response)
	{
		
		
		String vistaOrigen= String.valueOf(request.getParameter("vista"));
		String operacion= String.valueOf(request.getParameter("operacion"));
		Gson gson = new Gson();
		
		switch(vistaOrigen)
		{
			case "index":
				this.querys = null;
				this.querys = gestorInicial.ConsultaTablaQuerysBD();
				InformacionInicial infoInicial= gestorInicial.obtieneInformacionInicialDelSistema(this.querys);
				request.setAttribute("listBanners", infoInicial.getListaBanners());
				request.setAttribute("listBoletines", infoInicial.getListaBoletines());
				request.setAttribute("listMarcas", infoInicial.getListaMarcas());
				request.setAttribute("listNuestraEmpresa", infoInicial.getListaNuestraEmpresa());
				request.setAttribute("listSistemaAutomotriz", infoInicial.getListaSistemaAutomotriz());
				request.setAttribute("listValores", infoInicial.getListaValores());
				request.setAttribute("listVentajas", infoInicial.getListaVentajas());
				request.setAttribute("listEstados", infoInicial.getListaEstados());
				request.setAttribute("listMarcasCdo", infoInicial.getListaMarcasCdo());
				request.setAttribute("listPoliticasPrivacidad", infoInicial.getListaPoliticasPrivacidad());
				request.setAttribute("listNivelAcademico", infoInicial.getListaNivelAcademico());
				request.setAttribute("listaCintilloMarcas", infoInicial.getListaCintillosImagenes());
				request.setAttribute("listaVideos", infoInicial.getListaVideos());
				RedireccionarVista(request,response, "PaginaPrincipal.jsp");
				break;	
		}
	}	
	
	
	/**** Reidrecciona a la pagina correspondiente ***/
	public void RedireccionarVista(HttpServletRequest request, HttpServletResponse response, String vista)
	{
		try
		{
			RequestDispatcher rdIndex = request.getRequestDispatcher("jsp/" + vista);			    	
		    rdIndex.forward(request, response);
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
}
