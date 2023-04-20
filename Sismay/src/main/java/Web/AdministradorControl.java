package Web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;

import Datos.ProcesoWeb;
import Datos.Querys;

/**
 * Servlet implementation class AdministradorRHWWW
 */
public class AdministradorControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdministradorControl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		if(session!=null)
		{
			request.setAttribute("nombre", session.getAttribute("nombre"));
			request.setAttribute("nombreCdo", session.getAttribute("nombreCdo"));
			request.setAttribute("departamento", session.getAttribute("departamento"));
			request.setAttribute("uname", session.getAttribute("uname"));
			validaPeticion(request, response, session);
	    }  
		else
		{  
			if(session == null)
			{
				RequestDispatcher rdIndex = request.getRequestDispatcher("/inicio.jsp");			    	
				rdIndex.forward(request, response);
			}
		}
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	private void validaPeticion(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		 try {
			// System.out.println("ruta de proyecto:" + this.getServletContext().getRealPath("Images")); ;
			 List<Querys> listaQuerys = (List<Querys>) session.getAttribute("querys");
			 String accion = String.valueOf(request.getParameter("accion"));
			 JSONObject listaProcesosJson = new JSONObject();	
			  //System.out.println("accion:" + accion);
					switch (accion) {
					case "Inicio":
						redireccionarVista(request, response, "/AdministradorControl.jsp");
						break;
					case "Cargar":
						listaProcesosJson=cargaInformacion(request, response, session, listaQuerys);
						EviarRespuestaJsonJS(request,response, "["+ listaProcesosJson.toString()+"]");
						
						break;
					}
		 }
		 catch(Exception ex)
		 {
	
		 }
		}
	private JSONObject cargaInformacion(HttpServletRequest request, HttpServletResponse response, HttpSession session,
			List<Querys> listaQuerys) {
		JSONObject listaProcesosJson = new JSONObject();
		List<ProcesoWeb> listaProcesos=new ArrayList<>();
		listaProcesos.add(new ProcesoWeb("151","http://deswebcdo18:8080/RHWWW/UsuarioServlet","RHWWW"));
		listaProcesos.add(new ProcesoWeb("151","http://deswebcdo18:8080/ControlDeIngresos/ServidorUsuario","CONTROL DE INGRESOS"));
		listaProcesos.add(new ProcesoWeb("151","http://deswebcdo18:8080/RHWWW/","SISCEN"));
		listaProcesosJson.put("listaProcesos", listaProcesos);
		return listaProcesosJson;
	}

	public void redireccionarVista(HttpServletRequest request, HttpServletResponse response, String vista)
	{
		try
		{
			RequestDispatcher rdIndex = request.getRequestDispatcher("jsp/" + vista);			    	
		    rdIndex.forward(request, response);
		}
		catch(Exception ex)
		{
			try {
			RequestDispatcher rdIndex = request.getRequestDispatcher(vista);			    	
		    rdIndex.forward(request, response);
			}
			catch (Exception e) {
				System.out.println("Error al re-direccionar vista." + e.getMessage().toString());
			}
		}
	}
	private void EviarRespuestaJsonJS(HttpServletRequest request, HttpServletResponse response, String respuesta)
	{
		try
		{
			response.setContentType("application/json");
			PrintWriter out = response.getWriter();
			out.write(respuesta);
		}
		catch(Exception ex)
		{
			System.out.println("Error al re-direccionar vista." + ex.getMessage().toString());
		}
	}

}
