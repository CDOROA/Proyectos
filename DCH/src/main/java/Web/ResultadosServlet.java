package Web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;

import Datos.Areas;
import Datos.Preguntas;
import Datos.Querys;
import Datos.RespuestaEmp;
import Datos.ResultadoAreas;
import Datos.SeguimientoDetalle;
import Datos.Usuario;
import Persistencia.GestorResultados;
import Persistencia.GestorSeguimiento;

/**
 * Servlet implementation class ResultadosServlet
 */
public class ResultadosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ResultadosServlet() {
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
				RequestDispatcher rdIndex = request.getRequestDispatcher("/inicio.jsp");			    	
				rdIndex.forward(request, response);
			}
		
	}
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 
		doGet(request, response);
	}

	private void validaPeticion(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		 try {
			// System.out.println("ruta de proyecto:" + this.getServletContext().getRealPath("Images")); ;
			 List<Querys> listaQuerys = (List<Querys>) session.getAttribute("querys");
			 String accion = String.valueOf(request.getParameter("accion"));
			 JSONObject listaEvaluacionesJson = new JSONObject();	
			  //System.out.println("accion:" + accion);
					switch (accion) {
					case "Inicio":
						session.setAttribute("accionServlet", "1");
						RedireccionarVista(request, response, "/Resultados.jsp");
						break;
					case "CargaAreas":
						listaEvaluacionesJson=consultaAreas(request,response, listaQuerys, session);
						EviarRespuestaJsonJS(request,response, "["+ listaEvaluacionesJson.toString()+"]");
						break;
					case "CargarEmpleados":
						listaEvaluacionesJson=consultaRespuestaEmpleados(request,response, listaQuerys, session);
						EviarRespuestaJsonJS(request,response, "["+ listaEvaluacionesJson.toString()+"]");
						break;
					case "CargaDeptos":
						listaEvaluacionesJson=consultaDeptos(request,response, listaQuerys, session);
						EviarRespuestaJsonJS(request,response, "["+ listaEvaluacionesJson.toString()+"]");
						break;
					case "CargaNiveles":
						listaEvaluacionesJson=consultaNiveles(request,response, listaQuerys, session);
						EviarRespuestaJsonJS(request,response, "["+ listaEvaluacionesJson.toString()+"]");
						break;
					case "CargarDeptosAreas":
						listaEvaluacionesJson=consultaEmpleadoArea(request,response, listaQuerys, session);
						EviarRespuestaJsonJS(request,response, "["+ listaEvaluacionesJson.toString()+"]");
						break;
					case "CargarDetalleEmpleado":
						listaEvaluacionesJson=consultaDetalleEmpleado(request,response, listaQuerys, session);
						EviarRespuestaJsonJS(request,response, "["+ listaEvaluacionesJson.toString()+"]");
						break;
					case "CargarEmpleadosDepto":
						listaEvaluacionesJson=consultaDetalleDepto(request,response, listaQuerys, session);
						EviarRespuestaJsonJS(request,response, "["+ listaEvaluacionesJson.toString()+"]");
						break;
					case "GuardaFortalezasyAreas":
						listaEvaluacionesJson=guardaFortalezasyAreas(request,response, listaQuerys, session);
						EviarRespuestaJsonJS(request,response, "["+ listaEvaluacionesJson.toString()+"]");
						break;
					case "CargaDatos":
						listaEvaluacionesJson=cargaDatosFortalezasyAreas(request,response, listaQuerys, session);
						EviarRespuestaJsonJS(request,response, "["+ listaEvaluacionesJson.toString()+"]");
						break;
					case "ConsultaOportunidad":
						listaEvaluacionesJson=consultaOportunidad(request,response, listaQuerys, session);
						EviarRespuestaJsonJS(request,response, "["+ listaEvaluacionesJson.toString()+"]");
						break;
					case "ConsultaPreguntasaAbiertas":
						listaEvaluacionesJson=consultaPreguntasAbiertas(request,response, listaQuerys, session);
						EviarRespuestaJsonJS(request,response, "["+ listaEvaluacionesJson.toString()+"]");
						break;
					case "TodasAreas":
						listaEvaluacionesJson=todasAreas(request,response, listaQuerys, session);
						EviarRespuestaJsonJS(request,response, "["+ listaEvaluacionesJson.toString()+"]");
						break;
					case "TodosDeptos":
						listaEvaluacionesJson=todosDeptos(request,response, listaQuerys, session);
						EviarRespuestaJsonJS(request,response, "["+ listaEvaluacionesJson.toString()+"]");
						break;
					case "CargarEmpleadosTipoArea":
						listaEvaluacionesJson=cargaEmpleadosTipoArea(request,response, listaQuerys, session);
						EviarRespuestaJsonJS(request,response, "["+ listaEvaluacionesJson.toString()+"]");
						break;
					case "CargarEmpleadosTipoDepto":
						listaEvaluacionesJson=cargaEmpleadosTipoDepto(request,response, listaQuerys, session);
						EviarRespuestaJsonJS(request,response, "["+ listaEvaluacionesJson.toString()+"]");
						break;
					case "CargaResultados":
						listaEvaluacionesJson=cargaResultados(request,response, listaQuerys, session);
						EviarRespuestaJsonJS(request,response, "["+ listaEvaluacionesJson.toString()+"]");
						break;
						
						
					}
		 }
		 catch(Exception ex)
		 {
	
		 }
		}
		

	private JSONObject cargaResultados(HttpServletRequest request, HttpServletResponse response,
			List<Querys> listaQuerys, HttpSession session) {
		JSONObject JsonResultado = new JSONObject();
		String cdo =  (String) session.getAttribute("uname");
		Usuario infoUsu=(Usuario) session.getAttribute("DatosUsr");
		String idTipoEncuesta=request.getParameter("idTipoEncuesta");
		String idDepto=request.getParameter("idDepto");
		boolean respuesta=GestorResultados.cargaResultados(listaQuerys,cdo,infoUsu,idTipoEncuesta,idDepto);
		String rsp="No se actualizaron las encuestas";
		if(respuesta) {
			rsp="¡Se actualizaron resultados!";
		}
		
		JsonResultado.put("rsp",rsp);
		
		return JsonResultado;
	}

	private JSONObject cargaEmpleadosTipoDepto(HttpServletRequest request, HttpServletResponse response,
			List<Querys> listaQuerys, HttpSession session) {
		JSONObject JsonResultado = new JSONObject();
		String cdo =  (String) session.getAttribute("uname");
		Usuario infoUsu=(Usuario) session.getAttribute("DatosUsr");
		String idTipoEncuesta=request.getParameter("idTipoEncuesta");
		String idDepto=request.getParameter("idDepto");
		List<ResultadoAreas> listResultados=GestorResultados.cargaEmpleadosTipoDepto(listaQuerys,cdo,infoUsu,idTipoEncuesta,idDepto);
		
		JsonResultado.put("listResultados",listResultados);
		
		return JsonResultado;
	}

	private JSONObject cargaEmpleadosTipoArea(HttpServletRequest request, HttpServletResponse response,
			List<Querys> listaQuerys, HttpSession session) {
		JSONObject JsonResultado = new JSONObject();
		String cdo =  (String) session.getAttribute("uname");
		Usuario infoUsu=(Usuario) session.getAttribute("DatosUsr");
		String idTipoEncuesta=request.getParameter("idTipoEncuesta");
		String idArea=request.getParameter("idArea");
		List<ResultadoAreas> listResultados=GestorResultados.cargaEmpleadosTipoArea(listaQuerys,cdo,infoUsu,idTipoEncuesta,idArea);
		
		JsonResultado.put("listResultados",listResultados);
		
		return JsonResultado;
	}

	private JSONObject todosDeptos(HttpServletRequest request, HttpServletResponse response, List<Querys> listaQuerys,
			HttpSession session) {
		JSONObject JsonResultado = new JSONObject();
		String cdo =  (String) session.getAttribute("uname");
		Usuario infoUsu=(Usuario) session.getAttribute("DatosUsr");
		List<Areas> listResultados=GestorResultados.cargaDeptos(listaQuerys,cdo,infoUsu);
		
		JsonResultado.put("listResultados",listResultados);
		
		return JsonResultado;
	}

	private JSONObject todasAreas(HttpServletRequest request, HttpServletResponse response, List<Querys> listaQuerys,
			HttpSession session) {
		JSONObject JsonResultado = new JSONObject();
		String cdo =  (String) session.getAttribute("uname");
		Usuario infoUsu=(Usuario) session.getAttribute("DatosUsr");
		List<Areas> listResultados=GestorResultados.cargaAreas(listaQuerys,cdo,infoUsu);
		
		JsonResultado.put("listResultados",listResultados);
		
		return JsonResultado;
	}

	private JSONObject consultaPreguntasAbiertas(HttpServletRequest request, HttpServletResponse response,
			List<Querys> listaQuerys, HttpSession session) {
		JSONObject JsonResultado = new JSONObject();
		String cdo =  (String) session.getAttribute("uname");
		Usuario infoUsu=(Usuario) session.getAttribute("DatosUsr");
		String idEmpleado=request.getParameter("idEmpleado");
		String idEncuesta=ponerTilde(request.getParameter("idEncuesta"));
		List<Preguntas> listResultados=GestorResultados.cargaPreguntasAbiertas(listaQuerys,cdo,infoUsu,idEmpleado,idEncuesta);
		
		JsonResultado.put("listResultados",listResultados);
		
		return JsonResultado;
	}

	private JSONObject consultaOportunidad(HttpServletRequest request, HttpServletResponse response,
			List<Querys> listaQuerys, HttpSession session) {
		JSONObject JsonResultado = new JSONObject();
		String cdo =  (String) session.getAttribute("uname");
		Usuario infoUsu=(Usuario) session.getAttribute("DatosUsr");
		String consulta=request.getParameter("consulta");
		String idEmpleado=request.getParameter("idEmpleado");
		String idEncuesta=ponerTilde(request.getParameter("idEncuesta"));
		List<Preguntas> listResultados=GestorResultados.cargaPreguntas(listaQuerys,cdo,infoUsu,idEmpleado,consulta,idEncuesta);
		
		JsonResultado.put("listResultados",listResultados);
		
		return JsonResultado;
	}

	private JSONObject cargaDatosFortalezasyAreas(HttpServletRequest request, HttpServletResponse response,
			List<Querys> listaQuerys, HttpSession session) {
		JSONObject JsonResultado = new JSONObject();
		String cdo =  (String) session.getAttribute("uname");
		Usuario infoUsu=(Usuario) session.getAttribute("DatosUsr");
		String idEmpleado=ponerTilde(request.getParameter("idEmpleado"));
		String idEncuesta=ponerTilde(request.getParameter("idEncuesta"));
		List<String> datos=GestorResultados.cargaDatos(listaQuerys,cdo,infoUsu,idEmpleado,idEncuesta);
		
		JsonResultado.put("listResultados",datos);
		
		return JsonResultado;
	}

	private JSONObject guardaFortalezasyAreas(HttpServletRequest request, HttpServletResponse response,
			List<Querys> listaQuerys, HttpSession session) {
		JSONObject JsonResultado = new JSONObject();
		String cdo =  (String) session.getAttribute("uname");
		Usuario infoUsu=(Usuario) session.getAttribute("DatosUsr");
		String idEmpleado=ponerTilde(request.getParameter("idEmpleado"));
		String fortalezas=ponerTilde(request.getParameter("fortalezas"));
		String areas=ponerTilde(request.getParameter("areas"));
		String idEncuesta=request.getParameter("idEncuesta");
		boolean valida=GestorResultados.guardaRetro(listaQuerys,cdo,infoUsu,idEmpleado,fortalezas,areas,idEncuesta);
		
		JsonResultado.put("listResultados",valida);
		
		return JsonResultado;
	}

	private JSONObject consultaDetalleDepto(HttpServletRequest request, HttpServletResponse response,
			List<Querys> listaQuerys, HttpSession session) {
		JSONObject JsonResultado = new JSONObject();
		String cdo =  (String) session.getAttribute("uname");
		Usuario infoUsu=(Usuario) session.getAttribute("DatosUsr");
		String idArea=request.getParameter("idArea");
		String idDepartamento=request.getParameter("idDepartamento");
		String idEncuesta=request.getParameter("idEncuesta");
		List<ResultadoAreas> listResultados =  GestorResultados.consultaEmpleadoDeptos(listaQuerys,cdo,infoUsu,idDepartamento,idEncuesta,idArea);
		
		JsonResultado.put("listResultados",listResultados);
		
		return JsonResultado;
	}

	private JSONObject consultaDetalleEmpleado(HttpServletRequest request, HttpServletResponse response,
			List<Querys> listaQuerys, HttpSession session) {
		JSONObject JsonResultado = new JSONObject();
		String cdo =  (String) session.getAttribute("uname");
		Usuario infoUsu=(Usuario) session.getAttribute("DatosUsr");
		String idEmpleado=request.getParameter("idEmpleado");
		String idEncuesta=request.getParameter("idEncuesta");
		List<ResultadoAreas> listResultados =  GestorResultados.consultaDetalleEmpleado(listaQuerys,cdo,infoUsu,idEmpleado,idEncuesta);
		
		JsonResultado.put("listResultados",listResultados);
		
		return JsonResultado;
	}

	private JSONObject consultaEmpleadoArea(HttpServletRequest request, HttpServletResponse response,
			List<Querys> listaQuerys, HttpSession session) {
		JSONObject JsonResultado = new JSONObject();
		String cdo =  (String) session.getAttribute("uname");
		Usuario infoUsu=(Usuario) session.getAttribute("DatosUsr");
		String idArea=request.getParameter("idArea");
		String idEncuesta=request.getParameter("idEncuesta");
		List<ResultadoAreas> listResultados =  GestorResultados.consultaEmpleadoAreas(listaQuerys,cdo,infoUsu,idArea,idEncuesta);
		
		JsonResultado.put("listResultados",listResultados);
		
		return JsonResultado;
	}

	private JSONObject consultaNiveles(HttpServletRequest request, HttpServletResponse response,
			List<Querys> listaQuerys, HttpSession session) {
		JSONObject JsonResultado = new JSONObject();
		String cdo =  (String) session.getAttribute("uname");
		Usuario infoUsu=(Usuario) session.getAttribute("DatosUsr");
		List<ResultadoAreas> listResultados =  GestorResultados.consultaNiveles(listaQuerys,cdo,infoUsu);
		
		JsonResultado.put("listResultados",listResultados);
		
		return JsonResultado;
	}

	private JSONObject consultaDeptos(HttpServletRequest request, HttpServletResponse response,
			List<Querys> listaQuerys, HttpSession session) {
		JSONObject JsonResultado = new JSONObject();
		String cdo =  (String) session.getAttribute("uname");
		Usuario infoUsu=(Usuario) session.getAttribute("DatosUsr");
		List<ResultadoAreas> listResultados =  GestorResultados.consultaDeptos(listaQuerys,cdo,infoUsu);
		
		JsonResultado.put("listResultados",listResultados);
		
		return JsonResultado;
	}

	private JSONObject consultaAreas(HttpServletRequest request, HttpServletResponse response, List<Querys> listaQuerys,
			HttpSession session) {
		JSONObject JsonResultado = new JSONObject();
		String cdo =  (String) session.getAttribute("uname");
		Usuario infoUsu=(Usuario) session.getAttribute("DatosUsr");
		List<ResultadoAreas> listResultados =  GestorResultados.consultaAreas(listaQuerys,cdo,infoUsu);
		
		JsonResultado.put("listResultados",listResultados);
		
		return JsonResultado;
	}

	private JSONObject consultaRespuestaEmpleados(HttpServletRequest request, HttpServletResponse response,
			List<Querys> listaQuerys, HttpSession session) {
		JSONObject JsonResultado = new JSONObject();
			String cdo =  (String) session.getAttribute("uname");
			Usuario infoUsu=(Usuario) session.getAttribute("DatosUsr");
			String idTipoEncuesta=request.getParameter("idTipoEncuesta");
			String idEncuesta=request.getParameter("idEncuesta");
			List<ResultadoAreas> listResultados =  GestorResultados.consultaEmpleado(listaQuerys,cdo,infoUsu,idTipoEncuesta,idEncuesta);
			
			JsonResultado.put("listResultados",listResultados);
			
			return JsonResultado;
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
		String[] letras= {"a1","A2","e1","E2","i1","I2","o1","O2","u1","U2","n1","N2","u3","u4"};
		String[] codigo= {"á","Á","é","É","í","Í","ó","Ó","ú","Ú","ñ","Ñ","ü","Ü"};
		for (int i = 0; i < letras.length; i++) {
			   palabra=palabra.replaceAll(letras[i],codigo[i]);
			  //alert(letras[i]+codigo[i]);
			}
		return palabra;
		
	}

}
