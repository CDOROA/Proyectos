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

import cdo.Datos.EstadoDeCuenta;
import cdo.Datos.EstadoDeCuentaDetalle;
import cdo.Datos.InfoCliente;
import cdo.Datos.Querys;
//import cdo.Persistencia.GestorEstadoDeCuenta;
import cdo.Persistencia.GestorEstadoDeCuentaV2;
import cdo.Persistencia.GestorPaginaPrincipal;

public class EstadoDeCuentaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	GestorEstadoDeCuentaV2 gestorEdocuenta;
	GestorPaginaPrincipal gestorInicial;
	List<Querys> querys;
       
    public EstadoDeCuentaServlet() {
        super();
        gestorInicial=new GestorPaginaPrincipal();
        gestorEdocuenta = new GestorEstadoDeCuentaV2();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
		response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
		response.setHeader("Expires", "-1"); // Proxies.
		HttpSession session = request.getSession(false);
		if(session != null)
		{
			this.querys = gestorInicial.ConsultaTablaQuerysBD();
			verificaPeticionOrigen(request,response, session);
		}
		else
		{
			if(session == null)
			{
				//System.out.println("Estado de Cuenta: Session no valida");
				request.getRequestDispatcher("/index.jsp").forward(request, response);
				return;
			}
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	
	private void verificaPeticionOrigen(HttpServletRequest request, HttpServletResponse response,HttpSession session)
	{
		String vistaOrigen= String.valueOf(request.getParameter("vista"));
		String operacion= String.valueOf(request.getParameter("operacion"));
		Gson gson = new Gson();
		
		switch(vistaOrigen)
		{
			case "CarritoDeCompras.jsp":
					
				switch(operacion)
				{
					case "ConsultaEstadoDeCuenta":
						 EstadoDeCuenta estadoCuentaGeneral = consultaEstadoDeCuenta(request, session);
						 String listaJson = gson.toJson(estadoCuentaGeneral);
						 enviarRespuestaJsonJS(request,response, listaJson);
						break;	
						
					case "ConsultaDetalleEstadoDeCuenta":
						 List<EstadoDeCuentaDetalle> listDetalleEdoCuenta = consultaEstadoDeCuentaDetalle(request, session);
						 String listaJsonDetalle = gson.toJson(listDetalleEdoCuenta);
						 enviarRespuestaJsonJS(request,response, listaJsonDetalle);
						break;	
					case "ValidarPasswordEdoCuenta":
						InfoCliente cliente = (InfoCliente) session.getAttribute("infoCliente");
						//System.out.println("pass: "+String.valueOf(request.getAttribute("pass")));
						String respuestaPassword = gestorEdocuenta.validarPassword(String.valueOf(request.getParameter("pass")),cliente,this.querys);
						EviarRespuestaTextoJS(request, response, respuestaPassword);
					break;
				}
									
			break;
		}
	}	
	
	public void EviarRespuestaTextoJS(HttpServletRequest request, HttpServletResponse response, String respuesta)
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
	/******  ESTADO DE CUENTA DEL CLIENTE  ******/	
	private EstadoDeCuenta  consultaEstadoDeCuenta(HttpServletRequest request,HttpSession session)
	{
		InfoCliente infoCliente = (InfoCliente) session.getAttribute("infoCliente");
		EstadoDeCuenta estadoCuentaGeneral =  gestorEdocuenta.consultaEstadoDeCuentaPorCliente(infoCliente);
		return estadoCuentaGeneral;
	}
	
	/******  ESTADO DE CUENTA DEL CLIENTE DETALLE ******/	
	private List<EstadoDeCuentaDetalle>  consultaEstadoDeCuentaDetalle(HttpServletRequest request,HttpSession session)
	{
		InfoCliente infoCliente = (InfoCliente) session.getAttribute("infoCliente");
		List<EstadoDeCuentaDetalle> listDetalleEdoCuenta =  gestorEdocuenta.consultaDetalleEstadoDeCuentaXCte(infoCliente);
		return listDetalleEdoCuenta;
	}
	
	/******  RESPUESTAS   AJAX  ******/	
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

	private void enviarRespuestaTextoJS(HttpServletRequest request, HttpServletResponse response, String respuesta)
	{
		try
		{
			PrintWriter out = response.getWriter();
		    out.write(respuesta);
		}
		catch(Exception ex)
		{
		//	System.out.println("Error al re-direccionar vista." + ex.getMessage().toString());
		}
	}
	
	
	
	
}
