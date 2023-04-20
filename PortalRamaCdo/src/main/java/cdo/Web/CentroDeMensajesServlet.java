package cdo.Web;

import java.io.IOException;
import java.io.PrintWriter;
 

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

 
 
import cdo.Datos.InfoCliente;
import cdo.Datos.Log;
 
import cdo.Persistencia.GestorCentroDeMensajes;
import cdo.Util.Cls_Log;


public class CentroDeMensajesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public CentroDeMensajesServlet() {
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
		
		// response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

	private void verificaPeticionOrigen(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws ServletException, IOException
	{
		String vistaOrigen= String.valueOf(request.getParameter("vista"));
		String operacion = String.valueOf(request.getParameter("operacion"));

		
		
				switch(operacion)
				{
					case "ConsultaMensajes":
						String mensajesJson = ConsultaMensajesWS(request, session);
						// System.out.println("mensajesJson ConsultaMensajes :" + mensajesJson);
						enviarRespuestaJsonJS(request, response, mensajesJson);
					break;
					
					case "ActualizaMensajes":
						String RespmensajesJson = ActualizaMensajes(request, session);
						//  System.out.println("ActualizaMensajes mensajesJson:" + RespmensajesJson);
						enviarRespuestaTextoJS(request, response, RespmensajesJson);
					break;
					
					case "ConsultaNuevosMensajes":
						int RespuetaTotalPendientes = ConsultaNuevosMensajes(request, session);
						 // System.out.println("Mensajes a RespuetaConsultaNuevosMensajes: " + RespuetaTotalPendientes);
						enviarRespuestaTextoJS(request, response, Integer.toString(RespuetaTotalPendientes));
					break;
				}
		
	}

	private String ConsultaMensajesWS(HttpServletRequest request, HttpSession session) {
		InfoCliente infoCliente = (InfoCliente) session.getAttribute("infoCliente");
		GestorCentroDeMensajes centroMsn = new GestorCentroDeMensajes();
		String mensajesJson="";
		try
		{
			centroMsn.init();
			mensajesJson = centroMsn.consultaMensajes(infoCliente.getCentro(), infoCliente.getCve_cliente());
			centroMsn.destroy();
		}
		catch(Exception ex)
		{
			
			// System.out.println("Error en Centro de Mensajes: " + ex.toString());
			 
			//Log log=new Log(1,infoCliente.getCve_cdo(),infoCliente.getCve_cliente() ,0, "[ Centro de mensajes: Error Al consultar mensajes: "+ ex.toString() +"].");
			//Cls_Log.insertaLog(log);
		}
		return mensajesJson;
	}


	private String ActualizaMensajes(HttpServletRequest request, HttpSession session) {
		String RespuetaActualizo="";
		InfoCliente infoCliente = (InfoCliente) session.getAttribute("infoCliente");
		try {
			String mensajes= String.valueOf(request.getParameter("mensajes"));
			int estatus= Integer.parseInt(String.valueOf(request.getParameter("estatus")));
			// System.out.println("Mensajes a Actualizar: " + mensajes);
			
			GestorCentroDeMensajes gestorMsn = new GestorCentroDeMensajes();
			
			gestorMsn.init();
			gestorMsn.actualizaMensajes(infoCliente.getCentro(), infoCliente.getCve_cliente(), mensajes, estatus);
			gestorMsn.destroy();
		}
		catch(Exception ex)
		{
			// System.out.println("Error al Actualizar Centro de Mensajes: " + ex.toString());
			 Log log=new Log(1,infoCliente.getCve_cdo(),infoCliente.getCve_cliente() ,0, "[ Centro de mensajes: Error Al Actualizar: "+ ex.toString() +"].");
				Cls_Log.insertaLog(log);
		}
		return RespuetaActualizo;
	}

	

	private int ConsultaNuevosMensajes(HttpServletRequest request, HttpSession session) {
		int RespuetaTotalPendientes=0;
		InfoCliente infoCliente = (InfoCliente) session.getAttribute("infoCliente");
		try {
			GestorCentroDeMensajes gestorMsn = new GestorCentroDeMensajes();
			gestorMsn.init();
			RespuetaTotalPendientes= gestorMsn.RecuperaTotalMensajes(infoCliente.getCentro(), infoCliente.getCve_cliente());
			gestorMsn.destroy();
		}
		catch(Exception ex)
		{
			RespuetaTotalPendientes=0;
		}
		return RespuetaTotalPendientes;
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
			 System.out.println("Error al enviarRespuestaJsonJS." + ex.getMessage().toString());
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
