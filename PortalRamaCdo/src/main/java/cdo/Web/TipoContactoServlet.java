package cdo.Web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cdo.Datos.InfoCliente;
import cdo.Persistencia.GestorCentroDeMensajes;
import cdo.Persistencia.GestorTipoContactoV2;

public class TipoContactoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public TipoContactoServlet() {
        super();

    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
		response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
		response.setHeader("Expires", "-1"); // Proxies.
		HttpSession session = request.getSession(false);
		if(session != null)
		{
		 
			verificaPeticionOrigen(request,response, session);
		}
		else
		{
			if(session == null)
			{
				//System.out.println("Carrito de Compras: Session no valida");
				request.getRequestDispatcher("/index.jsp").forward(request, response);
				return;
			}
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 
		doGet(request, response);
	}

	
	private void verificaPeticionOrigen(HttpServletRequest request, HttpServletResponse response, HttpSession session)
	{
		String vistaOrigen= String.valueOf(request.getParameter("vista"));
		String operacion = String.valueOf(request.getParameter("operacion"));

		
		
				switch(operacion)
				{
					case "ConsultaTipoContacto":
						String TipoContacto = ConsultaTipoContacto(request, session);
						enviarRespuestaJsonJS(request, response, TipoContacto);
					break;
					
					 
					
				}
		
	}
	
	private String ConsultaTipoContacto(HttpServletRequest request, HttpSession session) {
		InfoCliente infoCliente = (InfoCliente) session.getAttribute("infoCliente");
		GestorTipoContactoV2 tipoContacto = new GestorTipoContactoV2();
		String tipoContactoJson="";
		try
		{
			tipoContacto.init();
			tipoContactoJson = tipoContacto.consultaTipoContacto(infoCliente.getCentro(), infoCliente.getCve_cliente());
			tipoContacto.destroy();
		}
		catch(Exception ex)
		{
			
			// 
			 
			//Log log=new Log(1,infoCliente.getCve_cdo(),infoCliente.getCve_cliente() ,0, "[ Centro de mensajes: Error Al consultar mensajes: "+ ex.toString() +"].");
			//Cls_Log.insertaLog(log);
		}
		//System.out.println("ConsultaTipoContacto: " + tipoContactoJson);
		return tipoContactoJson;
	}


	/* RESPUESTAS AJAX */	
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
			//System.out.println("Error al re-direccionar vista." + ex.getMessage().toString());
		}
	}
}
