package Web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;

import Datos.Nota;
import Datos.Querys;
import Datos.Usuario;
import Persistencia.ConexionShell;
import Persistencia.GestorCFDI;
import Persistencia.GestorGenera;
import Persistencia.GestorNotas;

/**
 * Servlet implementation class AdministradorGenera
 */
public class AdministradorGenera extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdministradorGenera() {
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
			if(session == null)
			{
				RequestDispatcher rdIndex = request.getRequestDispatcher("/Inicio.jsp");			    	
				rdIndex.forward(request, response);
			}
		
	}
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 
		doGet(request, response);
	}

	private void validaPeticion(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		 try {
			// System.out.println("ruta de proyecto:" + this.getServletContext().getRealPath("Images")); ;
			 //@SuppressWarnings("unchecked")
			List<Querys> listaQuerys = (List<Querys>) session.getAttribute("querys");
			 String accion = String.valueOf(request.getParameter("accion"));
			 JSONObject listaCFDIJson = new JSONObject();	
			  //System.out.println("accion:" + accion);
					switch (accion) {
					case "Inicio":
						session.setAttribute("accionServlet", "1");
						RedireccionarVista(request, response, "/AdministradorGenera.jsp");
						break;
					case "CorreShell":
						listaCFDIJson=correShell(request,response, listaQuerys, session);
						EviarRespuestaJsonJS(request,response, "["+ listaCFDIJson.toString()+"]");
						break;
						
						}
					
		 }
		 catch(Exception ex)
		 {
	
		 }
		}
		

	private JSONObject correShell(HttpServletRequest request, HttpServletResponse response, List<Querys> listaQuerys,
			HttpSession session) {
		JSONObject Jsoncfdi = new JSONObject();
		String impresora =(String) session.getAttribute("impresora");
		String cdo =  (String) session.getAttribute("uname");
		Usuario infoUsu=(Usuario) session.getAttribute("DatosUsr");
		String pedido = request.getParameter("pedido");
		String seccion=request.getParameter("seccion");
		String mes=request.getParameter("mes");
		String anio=request.getParameter("anio");
		String dia=request.getParameter("dia");
		ConexionShell.correShell(cdo, pedido,seccion,mes,anio,dia);
		
		String factura=GestorGenera.obtenFactura(listaQuerys,cdo,pedido,seccion,mes,anio,dia,infoUsu);
		String msj="";
		String serie="";
		String folio="";
		if(factura.length()>0) {
			msj="Se genero e imprimio el CFDI el numero de factura: "+factura;
			serie=factura.substring(0,5);
			folio=factura.substring(5);
			impresora=GestorCFDI.consultaImpresora(listaQuerys,cdo,infoUsu,serie,folio);
			ConexionShell.sellaCFDI(cdo, serie, folio, impresora);
		}else {
			msj="No existe factura para esta seccion. Intente con la siguiente seccion";
		}
		
		Jsoncfdi.put("msj",msj);
		return Jsoncfdi;
	}

	public void RedireccionarVista(HttpServletRequest request, HttpServletResponse response, String vista)
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
	private String ponerTilde(String palabra) {
		String[] letras= {"a1","A2","e1","E2","i1","I2","o1","O2","u1","U2","n1","N2"};
		String[] codigo= {"á","Á","é","É","í","Í","ó","Ó","ú","Ú","ñ","Ñ"};
		for (int i = 0; i < letras.length; i++) {
			   palabra=palabra.replaceAll(letras[i],codigo[i]);
			  //alert(letras[i]+codigo[i]);
			}
		return palabra;
		
	}
}
