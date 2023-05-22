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
import Datos.Usuario;
import Persistencia.GestorUsuarios;
import Util.Cls_Querys;
import Util.ConexionBD;

/**
 * Servlet implementation class UsuarioServlet
 */
public class UsuarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	List<Querys> querys = null;   
     
    public UsuarioServlet() {
        super();
        this.querys = null;
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{	
    	//String accion=String.valueOf(request.getParameter("accion"));;
    	HttpSession session = request.getSession(false);
    	
    	 if(session!=null)
		{  	
			String vistaOrigen= String.valueOf(request.getParameter("vista"));			
			GeneraRespuesta(request,response,vistaOrigen, session);
	    }  
		else
		{  
			if(session == null)
			{
				RequestDispatcher rdIndex = request.getRequestDispatcher("/inicio.jsp");			    	
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
		
		try {
			String cdo = String.valueOf(request.getParameter("cdo_macro"));
			String base = String.valueOf(request.getParameter("cdo_macro"));
			String usuario = String.valueOf(request.getParameter("usuario"));
			String password = String.valueOf(request.getParameter("password"));
			session.setAttribute("usuario", usuario);
			session.setAttribute("base", base);
			session.setAttribute("cdo", cdo);
			session.setAttribute("password", password);
			int procWeb = Integer.parseInt(String.valueOf(request.getParameter("proceso_web")));

             GestorUsuarios gUsu = new GestorUsuarios();
			gUsu.init();
			Usuario usr = gUsu.consultaUsuario(cdo, base, usuario, password, procWeb);
			
			gUsu.destroy();
			
			if(usr.getCveUsuario().equalsIgnoreCase(""))
			{
				session.setAttribute("modalAMostrar", "9");
				session.setAttribute("SessionTitulo", "Inicio de Sesión");
				session.setAttribute("SessionMensaje", "Usuario y/o contraseña no válidos.");
				RedireccionarVista(request, response,"Inicio.jsp");
			
			}
			else
			{
				consultaQuerys(session);
				session.setAttribute("querys", this.querys);
				session.setAttribute("DatosUsr", usr);
				session.setAttribute("nivelUsuario", usr.getNivelUsuario());
				session.setAttribute("uname", usr.getUname());
				session.setAttribute("nombre", usr.getNombre());
				session.setAttribute("nombreCdo", usr.getNombreCotro());
				session.setAttribute("departamento", usr.getNombreDepartamento());
				RedireccionarVista(request, response,"../AdministradorEvaluaciones?accion=Inicio");
			}
		} catch (Exception e) {
			System.out.println("Aqui ERROR... validaCredencialesDeUsuario: " + e);
			
		}
	}
	
	private void consultaQuerys(HttpSession session) {
		Connection connBD = null;
		try
		{
		connBD = ConexionBD.AbrirConexionBDD(String.valueOf(session.getAttribute("cdo")));
		this.querys = null;
		this.querys = Cls_Querys.ConsultaTablaQuerysBD(connBD);
		//System.out.println("querys: " + this.querys);
	}
	catch(Exception ex)
	{
		String sError= ex.getMessage().toString();
		System.out.println("[ RhWww : UsuarioServlet.consultaQuerys Error: " + sError + " ]");
	}
		finally {
			try {connBD.close();} catch (SQLException e) {e.printStackTrace();}
		}
	}
	
}
