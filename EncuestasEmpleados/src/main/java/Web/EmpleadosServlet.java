package Web;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Datos.Querys;
import Datos.Empleado;
import Persistencia.GestorEmpleados;
import Util.Cls_Querys;
import Util.ConexionBD;

/**
 * Servlet implementation class UsuarioServlet
 */
public class EmpleadosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	List<Querys> querys = null;   
     
    public EmpleadosServlet() {
        super();
        this.querys = null;
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{	
    	//String accion=String.valueOf(request.getParameter("accion"));
    	//System.out.println(accion);
    	HttpSession session = request.getSession(false);
    	 if(session!=null)
		{  

			String vistaOrigen= String.valueOf(request.getParameter("idIndex"));			
			GeneraRespuesta(request,response,vistaOrigen, session);
			
	    }  
		else
		{  
			if(session == null) {
				RequestDispatcher rdIndex = request.getRequestDispatcher("/index.jsp");			    	
				rdIndex.forward(request, response);
				return;
			}
		}
		
		
	
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}
		
	/***  METODOS  PETICIONES ***/
	
	public void GeneraRespuesta(HttpServletRequest request, HttpServletResponse response, String vistaOrigen,HttpSession session)
	{		
		try
		{
			//System.out.println("vista: " + vistaOrigen ); 
			if(vistaOrigen.equals("Inicio.jsp"))
			{
				validaCredencialesDeUsuario(request,response, session);
			}
			else
			{
				session.setAttribute("modalAMostrar", "0");
				session.invalidate();
				
				
				RedireccionarVista(request, response, "Inicio.jsp");
			}
		}
		catch(Exception ex)
		{
			System.out.println("Error al obtener la petición origen." + ex.getMessage().toString());
		}
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
	
	/***  METODOS PARA VALIDAR SESSION DE USUARIO ***/
	
	private void validaCredencialesDeUsuario(HttpServletRequest request, HttpServletResponse response,HttpSession session) {
		Connection connBD = null;
		String noEmpleado = String.valueOf(request.getParameter("noEmpleado"));
		String cdo = String.valueOf(request.getParameter("cdo"));
		String psw = String.valueOf(request.getParameter("psw"));
		Empleado emp=new Empleado();
		try {
			connBD = ConexionBD.AbrirConexionBDD(cdo);
			consultaQuerys(cdo);
             GestorEmpleados gUsu = new GestorEmpleados();
			gUsu.init();
			emp  = gUsu.consultaUsuario(noEmpleado, psw, this.querys, connBD,cdo);
			gUsu.destroy();
			if(emp.getNoEmpleado()==null||emp.getNoEmpleado().equalsIgnoreCase(""))
			{
				session.setAttribute("modalAMostrar", "9");
				session.setAttribute("SessionTitulo", "Inicio de Sesión");
				session.setAttribute("SessionMensaje", "Verifique los datos de nuevo");
				//System.out.println("hola");
				RedireccionarVista(request, response,"Inicio.jsp");

			
			}
			else
			{	
				session.setAttribute("idEmpleado", emp.getIdEmpleado());
				session.setAttribute("noEmpleado", emp.getNoEmpleado());
				session.setAttribute("querys", this.querys);
				session.setAttribute("DatosUsr", emp);
				session.setAttribute("uname", emp.getEmpresa());
				session.setAttribute("nombre", emp.getNombreCompleto());
				session.setAttribute("cdo", cdo);
				session.setAttribute("departamento", emp.getArea());
				RedireccionarVista(request, response,"../EvaluacionesServlet?accion=Inicio");
			}
		} catch (Exception e) {
			System.out.println("Aqui ERROR... validaCredencialesDeUsuario: " + e);
			
		}
	}
	
	private void consultaQuerys(String cdo) {
		Connection connBD = null;
		try
		{
		connBD = ConexionBD.AbrirConexionBDD(cdo);
		this.querys = null;
		this.querys = Cls_Querys.ConsultaTablaQuerysBD(connBD);
		//System.out.println("querys: " + this.querys);
	}
	catch(Exception ex)
	{
		String sError= ex.getMessage().toString();
		System.out.println("[ Evaluaciones : UsuarioServlet.consultaQuerys Error: " + sError + " ]");
	}
		finally {
			try {connBD.close();} catch (SQLException e) {e.printStackTrace();}
		}
	}
	
}
