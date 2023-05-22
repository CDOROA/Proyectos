package Web;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.nio.channels.Channel;
import java.util.Calendar;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;

import Datos.CFDI;
import Datos.Comprobante;
import Datos.Conceptos;
import Datos.Documentos;
import Datos.Emisor;
import Datos.LOG;
import Datos.Nota;
import Datos.Querys;
import Datos.Receptor;
import Datos.Usuario;
import Persistencia.GestorCFDI;
import Persistencia.GestorNotas;
import Persistencia.ConexionShell;

/**
 * Servlet implementation class AdministradorNotas
 */
public class AdministradorNotas extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdministradorNotas() {
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
			 @SuppressWarnings("unchecked")
			List<Querys> listaQuerys = (List<Querys>) session.getAttribute("querys");
			 String accion = String.valueOf(request.getParameter("accion"));
			 JSONObject listaCFDIJson = new JSONObject();	
			  //System.out.println("accion:" + accion);
					switch (accion) {
					case "Inicio":
						session.setAttribute("accionServlet", "1");
						RedireccionarVista(request, response, "/AdministradorNotas.jsp");
						break;
					case "Cargar":
						listaCFDIJson=consultaNotas(request,response, listaQuerys, session);
						EviarRespuestaJsonJS(request,response, "["+ listaCFDIJson.toString()+"]");
						break;
					case "CambiarRuta":
						listaCFDIJson=cambiarRuta(request,response, listaQuerys, session);
						EviarRespuestaJsonJS(request,response, "["+ listaCFDIJson.toString()+"]");
						break;
					case "SellaNotas":
						listaCFDIJson=SellaNotas(request,response, listaQuerys, session);
						EviarRespuestaJsonJS(request,response, "["+ listaCFDIJson.toString()+"]");
						break;
						
						}
					
		 }
		 catch(Exception ex)
		 {
	
		 }
		}
		

	private JSONObject SellaNotas(HttpServletRequest request, HttpServletResponse response, List<Querys> listaQuerys,
			HttpSession session) {
		JSONObject Jsoncfdi = new JSONObject();
		String cdo =  (String) session.getAttribute("uname");
		String nota=request.getParameter("nota");
	//	String cambia=ConexionShell.sellaNota(cdo, nota);
		//Jsoncfdi.put("cambia",cambia);
		return Jsoncfdi;
	}

	private JSONObject cambiarRuta(HttpServletRequest request, HttpServletResponse response, List<Querys> listaQuerys,
			HttpSession session) throws Exception {
		JSONObject Jsoncfdi = new JSONObject();
		String cdo =  (String) session.getAttribute("uname");
		String anioO=request.getParameter("anio");
		String mesO=request.getParameter("mes");
		String diaO=request.getParameter("dia");
		String nota=request.getParameter("nota");
		Calendar fecha = Calendar.getInstance();
		String anioD = String.valueOf(fecha.get(Calendar.YEAR));
	    String mesD =  String.valueOf(fecha.get(Calendar.MONTH) + 1);
	    String diaD =  String.valueOf(fecha.get(Calendar.DAY_OF_MONTH));
		String cambia ="false";
		if(Integer.parseInt(mesD)<10) {
			mesD="0"+mesD;
		}
		if(Integer.parseInt(diaD)<10) {
			diaD="0"+diaD;
		}
		String destino="";
		String origen1="/usr/acct/GeneradorCFDI/entrada/"+anioO+"/"+mesO+"/"+diaO+"/";
		String origen2="";
		if(Integer.parseInt(diaO)<10) {
			origen2="/usr/acct/GeneradorCFDI/entrada/"+anioO+"/"+mesO+"/0"+(Integer.parseInt(diaO)+1)+"/";
		}else {
			origen2="/usr/acct/GeneradorCFDI/entrada/"+anioO+"/"+mesO+"/"+(Integer.parseInt(diaO)+1)+"/";
		}
		if(anioO.equalsIgnoreCase(anioD)) {
			
				destino="../../"+mesD+"/"+diaD;
		}else {
					destino="../../../"+anioD+"/"+mesD+"/"+diaD;
			}
        System.out.println("Desde 1: " + origen1);
        System.out.println("Desde 2: " + origen2);
	//	ConexionShell.copiaArchivo(cdo, origen1, destino,nota);
		//ConexionShell.copiaArchivo(cdo, origen2, destino,nota);
		cambia= "true";
		Jsoncfdi.put("cambia",cambia);
		
		return Jsoncfdi;
	}

	private JSONObject consultaNotas(HttpServletRequest request, HttpServletResponse response, List<Querys> listaQuerys,
			HttpSession session) {
		JSONObject Jsoncfdi = new JSONObject();
		String cdo =  (String) session.getAttribute("uname");
		Usuario infoUsu=(Usuario) session.getAttribute("DatosUsr");
		List<Nota> listNotas =  GestorNotas.consultaNotas(listaQuerys,cdo,infoUsu);
		
		Jsoncfdi.put("listNotas",listNotas);
		
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
