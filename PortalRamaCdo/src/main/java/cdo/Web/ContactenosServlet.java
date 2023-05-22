package cdo.Web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import cdo.Datos.ArticulosCarritoPedidoCompleto;
import cdo.Datos.Consignatarios;
import cdo.Datos.Contactenos;
import cdo.Datos.InfoCliente;
import cdo.Datos.Log;
import cdo.Datos.Querys;
import cdo.Datos.Transportes;
import cdo.Persistencia.GestorContactenos;
import cdo.Persistencia.GestorPaginaPrincipal;
import cdo.Util.Cls_Log;

public class ContactenosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	GestorPaginaPrincipal gestorInicial;
	List<Querys> querys;
	GestorContactenos gestorContactenos;

    public ContactenosServlet() {    	
        super();
        gestorInicial=new GestorPaginaPrincipal();
        this.querys = null;
        
        gestorContactenos= new GestorContactenos();
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
		
	private void verificaPeticionOrigen(HttpServletRequest request, HttpServletResponse response)
	{
		this.querys = gestorInicial.ConsultaTablaQuerysBD();
		String vistaOrigen= String.valueOf(request.getParameter("vista"));
		String operacion = String.valueOf(request.getParameter("operacion"));
		
		switch(vistaOrigen)
		{
		
			case "Contactenos.jsp":
				switch(operacion)
				{
					case "RegistraContacto":
						boolean insertoCorrectamente = insertaContactoEnB(request);
						enviarRespuestaTextoJS(request,response, String.valueOf(insertoCorrectamente));
					break;
				}
			break;
		}
	}	
	
	/******  BUSCA ARTICULOS DE PEDIDO ACTUAL EN  CARRITO    ******/
	private boolean insertaContactoEnB( HttpServletRequest request)
	{
		boolean insertoCorrectamente = false;
		try
		{
			Contactenos contacto= new Contactenos();
			contacto .setApellido_materno(request.getParameter("apellido_paterno"));
			contacto.setApellido_paterno(request.getParameter("apellido_materno"));
			contacto.setCorreo(request.getParameter("correo"));
			contacto.setEs_cliente_cdo(Integer.parseInt(request.getParameter("esCliente")));
			contacto.setId_cve_estado(Integer.parseInt(request.getParameter("id_estado")));
			contacto.setMensaje(request.getParameter("mensaje"));
			contacto.setNombre(request.getParameter("nombre"));
			contacto.setNum_cli(Integer.parseInt(request.getParameter("num_cli")));
			contacto.setTelefono(request.getParameter("telefono"));
			contacto.setTipoNegocio(Integer.parseInt(request.getParameter("tipoNegocio")));
			contacto.setNombreTipoNegocio(request.getParameter("nombreTipoNegocio"));
			insertoCorrectamente = gestorContactenos.insertaRegistroContactenos(this.querys,contacto);
		}
		catch(Exception ex)
		{
			//System.out.println("[Error: Insertar datos del contacto,  Clase: GestorContactenos,  Detalle: " + ex.getMessage().toString() +"]");
			Log log=new Log(0,0,0 ,0, "[Error:  Insertar datos del contacto,  Clase: GestorContactenos,  Detalle: " + ex.getMessage().toString() +"]");
			Cls_Log.insertaLog(log);
		}
		return insertoCorrectamente;
	}
		
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

}
