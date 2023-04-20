package cdo.Web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cdo.Datos.Consignatarios;
import cdo.Datos.InfoCliente;
import cdo.Datos.InformacionInicialCarrito;
import cdo.Datos.Log;
import cdo.Datos.Querys;
import cdo.Datos.Transportes;
import cdo.Persistencia.GestorBoletinesEmegerntes;
import cdo.Persistencia.GestorCentroDeMensajes;
//import cdo.Persistencia.GestorIniciaSession;
import cdo.Persistencia.GestorIniciaSessionV2;
import cdo.Persistencia.GestorPaginaPrincipal;
import cdo.Util.Cls_Log;


public class IniciaSessionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	GestorPaginaPrincipal gestorInicial;
	GestorIniciaSessionV2 gestorIniSession;
	static List<Querys> querys;
	
    public IniciaSessionServlet() {
        super();
        gestorIniSession=new GestorIniciaSessionV2();
        gestorInicial= new GestorPaginaPrincipal();
        this.querys = null;
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
		response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
		response.setHeader("Expires", "-1"); // Proxies.
		HttpSession anteriorSession = request.getSession(false);
        if (anteriorSession != null)
        {
        	anteriorSession.invalidate();
        }
        					
		HttpSession session = request.getSession(true);
		if(session != null)
		{
			
		    this.querys = gestorInicial.ConsultaTablaQuerysBD();
			session.setAttribute("querys", this.querys);
			session.setAttribute("respuestaAcceso", "NO");
			session.setAttribute("mostrarMsjInicioSession", "NO");
			verificaPeticionOrigen(request,response, session);
		}
		else
		{
			if(session == null)
			{
				//System.out.println("Portal Rama Cdo: Session no valida");
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
		String operacion = String.valueOf(request.getParameter("operacion"));
		String respuestaTransaccion="";
		try
		{		
			//System.out.println("vistaOrigen: " + vistaOrigen);
			//System.out.println("operacion  : " + operacion);
			
			switch(vistaOrigen)
			{
			 
				case "PaginaInicio.jsp":
					switch(operacion)
					{
						case "EntrarAlCarrito":
							validaAccesoACarritoCompras(request,session,response);			
						break;
						
						case "GenerarContrasenaNueva":
							respuestaTransaccion= generarNuevaContrasena(request);						
							enviarRespuestaTextoJS(request,response, respuestaTransaccion);
						break;
					}
				break;
				case "CarritoDeCompras.jsp":
					if(operacion.equals("SalirDelSistema"))
					{
						session.invalidate();
						request.getRequestDispatcher("/index.jsp").forward(request, response);
						return;
					}
				break;
				default:
					session.invalidate();
					request.getRequestDispatcher("/index.jsp").forward(request, response);
					 
					break;
			}
		}
		catch(Exception  ex)
		{
			//System.out.println("Error al ejecutar la peticion origen: " + ex.getMessage().toString() );
		}
	}	
		
	/******   GENERA NUEVA CONTRASEÑA   
	 * @throws Exception ******/
	private String generarNuevaContrasena(HttpServletRequest request) throws Exception
	{
		String usuario=request.getParameter("usuario");
		String contrasena=request.getParameter("contrasena");
		String contrasenaEncriptada=request.getParameter("contrasenaEncriptada");
		String respuestaProceso = gestorIniSession.generarNuevaContrasena2(usuario, contrasena, contrasenaEncriptada, this.querys);	
		return respuestaProceso;
	}	
		
	/******   VALIDA ACCESO A CARRITO   ******/
	private void validaAccesoACarritoCompras(HttpServletRequest request,HttpSession session, HttpServletResponse response)
	{
		try
		{
			//System.out.println("...1");
			String usuario=request.getParameter("txtUsuario");
			String contrasena=request.getParameter("txtContrasena");
			String navegador=request.getParameter("navegador");
			String versionNavegador=request.getParameter("versionNavegador");
			//System.out.println("...2.- " + usuario);
			//System.out.println("...2.- " + contrasena);
			String respuestaAcceso = gestorIniSession.validaInicioDeSession(usuario, contrasena, this.querys);
			//System.out.println("...3");
			if(respuestaAcceso.equals("DatosCorrectos"))
			{
				//System.out.println("...4");
				InformacionInicialCarrito infoInicialCarrito = gestorIniSession.consultaInformacionInicialDelCliente(this.querys, usuario);
				session.setAttribute("infoCliente", infoInicialCarrito.getInfocliente());
				session.setAttribute("listaMarcas", infoInicialCarrito.getListaMarcas());
				session.setAttribute("listaArmadoras", infoInicialCarrito.getListaArmadoras());
				session.setAttribute("listaGrupos", infoInicialCarrito.getListaGrupos());
				session.setAttribute("listaMarcasCalidad", infoInicialCarrito.getListaMarcasCalidad());
				session.setAttribute("lineasDescuentoFijo", infoInicialCarrito.getListaLineasDesFijo());
				session.setAttribute("cdos_traspaso_emergencia", infoInicialCarrito.getListaCdosTraspaso());
				session.setAttribute("listaCilindros", infoInicialCarrito.getListaCilindros());
				session.setAttribute("listaLitros", infoInicialCarrito.getListaLitros());
				session.setAttribute("listaLitros", infoInicialCarrito.getListaLitros());
				session.setAttribute("articulosEnElCarrito", infoInicialCarrito.getArticulosCarrito());
				session.setAttribute("numeroPedidoCarrito", infoInicialCarrito.getNumerpPedidoCarrito());
				session.setAttribute("listaDistancias", infoInicialCarrito.getListaDistancias());
				Log log=new Log(1,infoInicialCarrito.getInfocliente().getCve_cdo(),infoInicialCarrito.getInfocliente().getCve_cliente() ,Integer.parseInt(infoInicialCarrito.getNumerpPedidoCarrito()), "[Accion: Cliente Inicia Session en el Carrito desde navegador: "+ navegador +", Version: "+versionNavegador +".]");
				Cls_Log.insertaLog(log);
				//System.out.println("infoCliente: " + infoInicialCarrito.getInfocliente());
				int totalMensajes = RecuperaMensajes(infoInicialCarrito.getInfocliente().getCentro(), infoInicialCarrito.getInfocliente().getCve_cliente());
				session.setAttribute("centroMensajesTotalPEndientes", 0);
				session.setAttribute("centroMensajesImagen", "mailBlue");
				if(totalMensajes > 0)
				{
					session.setAttribute("centroMensajesTotalPEndientes", totalMensajes);
					session.setAttribute("centroMensajesImagen", "mailRed");
				}
	 
				session.setAttribute("estiloTotalProductos", "estiloCarritoProductosCERO");
				if (infoInicialCarrito.getArticulosCarrito() > 0 )
				{
					session.setAttribute("estiloTotalProductos",  "estiloCarritoProductosLleno");
				}
				
				GestorBoletinesEmegerntes boletines = new GestorBoletinesEmegerntes();
				
				String ImagenInicial =  boletines.ConsultaListaDeBoletinesEmegerntes(this.querys);
				
				session.setAttribute("imagenInicial",ImagenInicial);
				String MostrarMensaje = "none";
				if(!ImagenInicial.equalsIgnoreCase("default.png"))
				{
					 MostrarMensaje = "Block";	
				}
				session.setAttribute("MostrarPaginaEmergente", MostrarMensaje);
				//System.out.println(" aqui.... redirecciona" );
				redireccionarVista(request, response,"CarritoDeCompras.jsp");
			}
			else
			{
				//System.out.println(" Entro al else" );
				session.setAttribute("respuestaAcceso", respuestaAcceso);
				session.setAttribute("mostrarMsjInicioSession", "SI");
				request.getRequestDispatcher("/index.jsp").forward(request, response);
			}
		}
		catch(Exception ex)
		{
			//System.out.println(" Error validaAccesoACarritoCompras: "  + ex.toString() );
		}
		
	}
	
	
	private int RecuperaMensajes(int centro, int cve_cliente) {
		int totalMensajes = 0;
		try
		{
			GestorCentroDeMensajes gestorMsn = new GestorCentroDeMensajes();
			gestorMsn.init();
			totalMensajes = gestorMsn.RecuperaTotalMensajes(centro, cve_cliente);
			gestorMsn.destroy();
			
		}
		catch(Exception ex)
		{
			totalMensajes = 0;
		}
		return totalMensajes;
	}

	/******   RESPUESTAS AJAX   ******/
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

	private void redireccionarVista(HttpServletRequest request, HttpServletResponse response, String vista)
	{
		try
		{
			RequestDispatcher rdIndex = request.getRequestDispatcher("jsp/" + vista);			    	
		    rdIndex.forward(request, response);
		}
		catch(Exception ex)
		{
			//System.out.println("Error al re-direccionar vista." + ex.getMessage().toString());
		}
	}

}
