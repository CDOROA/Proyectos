package cdo.Web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.PageContext;

import com.google.gson.Gson;

import cdo.Datos.AntiguedadSaldos;
import cdo.Datos.Articulos;
import cdo.Datos.ArticulosCarritoDetalle;
import cdo.Datos.ArticulosCarritoEncabezado;
import cdo.Datos.ArticulosCarritoPedidoCompleto;
import cdo.Datos.Consignatarios;
import cdo.Datos.Distancia;
import cdo.Datos.InfoCliente;
import cdo.Datos.InformacionInicialCarrito;
import cdo.Datos.Log;
import cdo.Datos.Querys;
import cdo.Datos.SubMarcas;
import cdo.Datos.Transportes;
import cdo.Persistencia.GestorAltaArticuloEnCarrito;
import cdo.Persistencia.GestorBodegaCliente;
import cdo.Persistencia.GestorCentroDeMensajes;
import cdo.Persistencia.GestorConsignatarios;
import cdo.Persistencia.GestorEnvioCorreo72hrs;
//import cdo.Persistencia.GestorIniciaSession;
import cdo.Persistencia.GestorIniciaSessionV2;
//import cdo.Persistencia.GestorMantenimientoCarritoCompras;
import cdo.Persistencia.GestorMantenimientoCarritoComprasV2;
import cdo.Persistencia.GestorPaginaPrincipal;
import cdo.Persistencia.GestorTrasnportes;
import cdo.Util.Cls_Log;


public class MantenimientoCarritoCompras extends HttpServlet {
	private static final long serialVersionUID = 1L;	
	static List<Querys> querys;
	GestorPaginaPrincipal gestorInicial;
	GestorMantenimientoCarritoComprasV2 gestor_manto;
	GestorIniciaSessionV2  gestorIniSession;

    public MantenimientoCarritoCompras() {
        super();
        gestor_manto= new GestorMantenimientoCarritoComprasV2();
        gestorIniSession= new GestorIniciaSessionV2();
        gestorInicial= new GestorPaginaPrincipal();
        this.querys = null;
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
		response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
		response.setHeader("Expires", "-1"); // Proxies.
		HttpSession session = request.getSession(false);
		if(session != null)
		{
			InfoCliente cliente = (InfoCliente) session.getAttribute("infoCliente");
		
			if( cliente == null)
			{
				request.getRequestDispatcher("/index.jsp").forward(request, response);
				return;
			}
		
			   this.querys = gestorInicial.ConsultaTablaQuerysBD();
			try {
				verificaPeticionOrigen(request,response, session);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else
		{
			
		
			if(session == null )
			{
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
		Gson gson=new Gson();
		
		switch(vistaOrigen)
		{
			case "MantenimientoCarritoCompras.jsp":
				switch(operacion)
				{
					case "ConsultaDetallePedidoEnCarrito":
						ArticulosCarritoPedidoCompleto pedidoCompletoCarrito = consultaDetalleDePedidoEnCarrito(request, session);
						String listaJson= gson.toJson(pedidoCompletoCarrito);
						enviarRespuestaJsonJS(request, response, listaJson);
						
					break;
					case "EliminaArticulo":
						ArticulosCarritoPedidoCompleto pedidoCompletoCarritoE = EliminaArticulo(request, session);
					
						String listaJsonE= gson.toJson(pedidoCompletoCarritoE);
						enviarRespuestaJsonJS(request, response, listaJsonE);
					break;
					case "AgregarACarrito":
						int Respuesta = AgregarArticuloACarrito(request, session);
						session.setAttribute("articulosEnElCarrito", Respuesta);		
						session.setAttribute("estiloTotalProductos", "estiloCarritoProductosCERO");
						if ( Respuesta > 0 )
						{
							session.setAttribute("estiloTotalProductos",  "estiloCarritoProductosLleno");
						}
						enviarRespuestaTextoJS(request,response, Integer.toString(Respuesta));
						 
						break;
					case "TerminarPedido":
				        AcutalizaEstatusPedido(request, session);
					//	EnvioDeDorreo72Hrs(request, session);
						session.setAttribute("articulosEnElCarrito", 0);
						session.setAttribute("estiloTotalProductos", "estiloCarritoProductosCERO");
						enviarRespuestaTextoJS(request,response, "aqui...");
						break;
					case "ActualizaCantidadesArticulo":
						ArticulosCarritoPedidoCompleto pedidoCarrito = ModificaCantidadesArticulo(request, session);
						String listaJsonPedidoCarrito= gson.toJson(pedidoCarrito);
						enviarRespuestaJsonJS(request, response, listaJsonPedidoCarrito);
						break;
				}
				
			break;
		}
	}	

	/******  BUSCA ARTICULOS DE PEDIDO ACTUAL EN  CARRITO    
	 * @throws Exception ******/
	@SuppressWarnings("unchecked")
	private ArticulosCarritoPedidoCompleto consultaDetalleDePedidoEnCarrito( HttpServletRequest request, HttpSession session) 
	{
		ArticulosCarritoPedidoCompleto pedidoCompletoCarrito = new ArticulosCarritoPedidoCompleto();
		try {
		
		InfoCliente infoCliente = (InfoCliente) session.getAttribute("infoCliente");
		pedidoCompletoCarrito.setInfoCte(infoCliente);
		pedidoCompletoCarrito = gestor_manto.consultaPedidoActualEnCarritoCompras(this.querys, infoCliente);
		pedidoCompletoCarrito.setListaDistancias( (List<Distancia>) session.getAttribute("listaDistancias") );

		List<Consignatarios> consignatrios = GestorConsignatarios.consultaConsignatariosWS(infoCliente);

		List<Transportes> transportes = GestorTrasnportes.consultaTransportesWS(infoCliente);

		pedidoCompletoCarrito.setListConsignatarios(consignatrios);
		pedidoCompletoCarrito.setListTransportes(transportes);
		pedidoCompletoCarrito.setInfoCte(infoCliente);
		
		}
		catch(Exception ex)
		{
			System.out.println("MantenimientoCarritoCompras. consultaDetalleDePedidoEnCarrito  ERROR : " + ex);
			 pedidoCompletoCarrito = new ArticulosCarritoPedidoCompleto();
			 ArticulosCarritoEncabezado header= new ArticulosCarritoEncabezado();
				header.setCve_centro(0);
				header.setFecha_pedido("");
				header.setNombre_cliente("");
				header.setNum_cliente(0);
				header.setNum_pedido(0);
				header.setTotalArticulosEnCarrito(0);
				pedidoCompletoCarrito.setEncabezadoPedido(header);

				ArticulosCarritoDetalle detalle = new ArticulosCarritoDetalle();
				detalle.setCantidadPedida(0); 
				detalle.setCantidadPorSurtirCdo(0);
				detalle.setCantidadPorSurtirBr(0);
				detalle.setCantidadPorSurtir72(0);

				detalle.setCdoMacro("");	
				detalle.setCdoBr("");	
				detalle.setCdoTraspaso("");
	    		detalle.setCdoMacro("");
				detalle.setCdoBr("");
				detalle.setCdoTraspaso("");

				detalle.setEsTraspaso("NO");
				detalle.setDescuentoXMarca("");
				detalle.setPorcDescuento(0.0F);
				detalle.setNumArticuloCDO("");
				detalle.setNombreArticulo("");
				detalle.setImporte("");
				detalle.setNum_pedido(0);
				detalle.setNumArticuloRC("");
				detalle.setPrecioArticulo("");
				detalle.setImagen_bxa("");
				detalle.setImagen_ecommerce("");
				detalle.setBloqueo72hrs("");
				detalle.setBloqueoExpres("");
				List<ArticulosCarritoDetalle> detallePedidoCarrito= new ArrayList<>();		
				detallePedidoCarrito.add(detalle);
				pedidoCompletoCarrito.setDetallePedido(detallePedidoCarrito);
		}
		return pedidoCompletoCarrito;
	}
	
	
	/******  Eliminar Articulo del Carrito   
	 * @throws Exception ******/
	private ArticulosCarritoPedidoCompleto EliminaArticulo( HttpServletRequest request, HttpSession session)  
	{
		InfoCliente infoCliente = (InfoCliente) session.getAttribute("infoCliente");
		int pedido = Integer.parseInt((request.getParameter("pedido")));
		String articulo= String.valueOf(request.getParameter("num_articulo")); 
		ArticulosCarritoPedidoCompleto pedidoCompletoCarrito = new ArticulosCarritoPedidoCompleto();
		List<Transportes> transportes = null;
		List<Consignatarios> consignatrios = null;
		try
		{
		
			try
			{
			pedidoCompletoCarrito = gestor_manto.EiminaArticuloDelCarrito(this.querys, infoCliente, articulo, pedido);		
			}
			catch(Exception ex)
			{
				Log log=new Log(1,infoCliente.getCve_cdo(),infoCliente.getCve_cliente() ,pedido, 
						"[Error al Eliminar Articulo del carrito Metodo: EliminaArticulo submetodo  gestor_manto.EiminaArticuloDelCarrito "+ articulo + ". Ex: "+ ex.toString().replace("'", "") + "].");
				Cls_Log.insertaLog(log);
			}
			
			
			try
			{
			   consignatrios =GestorConsignatarios.consultaConsignatariosWS(infoCliente);
				pedidoCompletoCarrito.setListConsignatarios(consignatrios);
			}
			catch(Exception ex)
			{
				Log log=new Log(1,infoCliente.getCve_cdo(),infoCliente.getCve_cliente() ,pedido, 
						"[Error al Eliminar Articulo del carrito Metodo: EliminaArticulo submetodo  GestorConsignatarios.consultaConsignatariosWS "+ articulo + ". Ex: "+ ex.toString().replace("'", "") + "].");
				Cls_Log.insertaLog(log);
			}
			
			try
			{
			  transportes = GestorTrasnportes.consultaTransportesWS(infoCliente);
			  pedidoCompletoCarrito.setListTransportes(transportes);
			}
			catch(Exception ex)
			{
				Log log=new Log(1,infoCliente.getCve_cdo(),infoCliente.getCve_cliente() ,pedido, 
						"[Error al Eliminar Articulo del carrito Metodo: EliminaArticulo submetodo GestorTrasnportes.consultaTransportesWS "+ articulo + ". Ex: "+ ex.toString().replace("'", "") + "].");
				Cls_Log.insertaLog(log);
			}
			
		
			try
			{
				pedidoCompletoCarrito.setInfoCte(infoCliente);
				session.setAttribute("articulosEnElCarrito",  pedidoCompletoCarrito.getDetallePedido().size());
		
				session.setAttribute("estiloTotalProductos", "estiloCarritoProductosCERO");
				if (pedidoCompletoCarrito.getDetallePedido().size() > 0 )
				{
					session.setAttribute("estiloTotalProductos",  "estiloCarritoProductosLleno");
				}
			}
			catch (Exception e) {
				Log log=new Log(1,infoCliente.getCve_cdo(),infoCliente.getCve_cliente() ,pedido, 
						"[Error al Eliminar Articulo del carrito Metodo: EliminaArticulo submetodo GestorTrasnportes.llenarSession "+ articulo + ". Ex: "+ e.toString().replace("'", "") + "].");
				Cls_Log.insertaLog(log);
			}
			
			Log log=new Log(1,infoCliente.getCve_cdo(),infoCliente.getCve_cliente() ,pedido, "[Accion: Elimina Articulo del carrito: "+ articulo +"].");
			Cls_Log.insertaLog(log);
		}
		catch(Exception ex)
		{
			Log log=new Log(1,infoCliente.getCve_cdo(),infoCliente.getCve_cliente() ,pedido, "[Error al Eliminar Articulo del carrito: "+ articulo + ". Ex: "+ ex.toString().replace("'", "") + "].");
			Cls_Log.insertaLog(log);
		}
		return pedidoCompletoCarrito;
	}
	
	
	
	private int  AgregarArticuloACarrito(HttpServletRequest request, HttpSession session) {
		int resp = 0;
		InfoCliente infoCliente = (InfoCliente) session.getAttribute("infoCliente");
		String num_pedido_carrito = (String) session.getAttribute("numeroPedidoCarrito");

		
		String num_art= String.valueOf(request.getParameter("num_art"));
		try {
			int totalArticulos = (int) session.getAttribute("articulosEnElCarrito");
			
			if (totalArticulos > 0)
			{
			//	System.out.println("agregare A Pedido 0 Actual... ");
				resp = agregarAPedidoExistente(request, session);
			}
			else
			{
				//System.out.println("agregarPedidoNuevo... ");
				resp = agregarPedidoNuevo(request, session);
			}
			
			//Log log=new Log(1,infoCliente.getCve_cdo(),infoCliente.getCve_cliente() ,Integer.parseInt(num_pedido_carrito), "[Accion: Agrego Articulo Al carrito: "+ num_art + " ].");
			//Cls_Log.insertaLog(log);
		}
		catch (Exception ex) {
			Log log=new Log(1,infoCliente.getCve_cdo(),infoCliente.getCve_cliente() ,Integer.parseInt(num_pedido_carrito), "[Error al Agregar Articulo Al carrito: "+ num_art + ". Ex: "+ ex.toString().replace("'", "") + "].");
			Cls_Log.insertaLog(log);
		}
		return resp;
	}

	
	private int agregarAPedidoExistente(HttpServletRequest request, HttpSession session) throws Exception {
		int  resp =0;
		try{
			String num_art= String.valueOf(request.getParameter("num_art"));
			int cantidadPedida = Integer.parseInt(String.valueOf(request.getParameter("cantidadPedida")));
			int exietnciaCDO= Integer.parseInt(String.valueOf(request.getParameter("exietnciaCDO")));
			int existenciaBR =  Integer.parseInt(String.valueOf(request.getParameter("existenciaBR")));
			int exietnciaTraspaso=  Integer.parseInt(String.valueOf(request.getParameter("exietnciaTraspaso")));
			
			float importe= Float.parseFloat(String.valueOf(request.getParameter("importe")));
			boolean GeneraTraspaso = Boolean.parseBoolean(String.valueOf(request.getParameter("GeneraTraspaso")));
			String num_pedido_carrito = (String) session.getAttribute("numeroPedidoCarrito");
			InfoCliente infoCliente = (InfoCliente) session.getAttribute("infoCliente");
			int cantidad = exietnciaCDO + existenciaBR;
			String genTrasp = "";
			String cdoTraspaso = "";
			if (GeneraTraspaso == true && exietnciaTraspaso > 0)
			{
				genTrasp = "T";
				cdoTraspaso = String.valueOf(request.getParameter("cdoTraspaso"));
			}
			//System.out.println("cantiad: " + cantidad);
			//if (cantidad > 0)
			//{
				resp = GestorAltaArticuloEnCarrito.AgregarArticuloACarrito(this.querys, infoCliente,num_art, cantidadPedida,exietnciaCDO, existenciaBR, importe,genTrasp,cdoTraspaso,num_pedido_carrito );
			//}
			
			if (GeneraTraspaso == true && exietnciaTraspaso > 0)
			{
				resp = GestorAltaArticuloEnCarrito.AgregarArticuloACarrito72Hrs(this.querys, infoCliente,num_art,  exietnciaTraspaso, cdoTraspaso,importe);
			}
			
			//if (cantidad == 0 && exietnciaTraspaso == 0 )
			//{
			//	resp = GestorAltaArticuloEnCarrito.AgregarArticuloACarrito(this.querys, infoCliente,num_art, cantidadPedida,exietnciaCDO, existenciaBR, importe,genTrasp,cdoTraspaso,num_pedido_carrito );
			//}
		}
		catch (Exception e) {
		throw e;
		}
		return resp;
	}


	private int agregarPedidoNuevo(HttpServletRequest request, HttpSession session) throws Exception {
		int  resp =0;
		try{
			String num_art= String.valueOf(request.getParameter("num_art"));
			int cantidadPedida = Integer.parseInt(String.valueOf(request.getParameter("cantidadPedida")));
			int exietnciaCDO= Integer.parseInt(String.valueOf(request.getParameter("exietnciaCDO")));
			int existenciaBR =  Integer.parseInt(String.valueOf(request.getParameter("existenciaBR")));
			int exietnciaTraspaso=  Integer.parseInt(String.valueOf(request.getParameter("exietnciaTraspaso")));
			// String cdoTraspaso = String.valueOf(request.getParameter("cdoTraspaso"));
			float importe= Float.parseFloat(String.valueOf(request.getParameter("importe")));
			boolean GeneraTraspaso = Boolean.parseBoolean(String.valueOf(request.getParameter("GeneraTraspaso")));
			String num_pedido_carrito = (String) session.getAttribute("numeroPedidoCarrito");
			InfoCliente infoCliente = (InfoCliente) session.getAttribute("infoCliente");
			int cantidad = exietnciaCDO + existenciaBR;
			String genTrasp = "";
			String cdoTraspaso = "";
			if (GeneraTraspaso == true && exietnciaTraspaso > 0)
			{
				genTrasp = "T";
				cdoTraspaso = String.valueOf(request.getParameter("cdoTraspaso"));
			}
			
			//if (cantidad > 0 || exietnciaTraspaso > 0 )
			//{
				resp = GestorAltaArticuloEnCarrito.AgregarPedidoNuevo(this.querys, infoCliente,num_art, cantidadPedida,exietnciaCDO, existenciaBR, importe,genTrasp,cdoTraspaso, num_pedido_carrito );
			//}
			
			if (GeneraTraspaso == true && exietnciaTraspaso > 0)
			{
				resp = GestorAltaArticuloEnCarrito.AgregarArticuloACarrito72Hrs(this.querys, infoCliente,num_art,  exietnciaTraspaso, cdoTraspaso,importe);
			}
			//System.out.println("agregarPedidoNuevo resp: " + resp );
		}
		catch (Exception e) {
			//System.out.println("NuevoportalRamaCDO.-ERROR AL agregarPedidoNuevo " + e );
			throw e;
		}
		return resp;
	}
	
	
	private void EnvioDeDorreo72Hrs(HttpServletRequest request, HttpSession session) {
		InfoCliente infoCliente = (InfoCliente) session.getAttribute("infoCliente");
		int  pedidoActualizado = 10044;
		GestorEnvioCorreo72hrs gtr = new GestorEnvioCorreo72hrs();
		gtr.enviarCorreo(this.querys, infoCliente,  pedidoActualizado);
	}
	

	private void AcutalizaEstatusPedido(HttpServletRequest request, HttpSession session) {
		
		InfoCliente infoCliente = (InfoCliente) session.getAttribute("infoCliente");
		String num_pedido_carrito = (String) session.getAttribute("numeroPedidoCarrito");
		String num_art= String.valueOf(request.getParameter("num_art"));
		int  pedidoActualizado = 0;
		try {
			String transporte = String.valueOf(request.getParameter("transporte"));
			String consignatario = String.valueOf(request.getParameter("consignatario"));
			String pedido = String.valueOf(request.getParameter("pedido"));
			
			 pedidoActualizado = GestorAltaArticuloEnCarrito.EnviaPedido(this.querys,infoCliente, transporte,consignatario,pedido);
			
			if (pedidoActualizado > 0)
			{
				// GestorMantenimientoCarritoComprasV2 gmanto = new GestorMantenimientoCarritoComprasV2();
		
				/* DEBUG */
				if (infoCliente.getCve_cliente() != 0)
				{
			
					 //Debido a problemas de con licencias de cobol Todos los pedidos se actualizan a  Estatus 17.
					/*String enviarPedido = GestorAltaArticuloEnCarrito.EvaluaHorasProceso(infoCliente, Integer.toString(pedidoActualizado));
					
					if (enviarPedido.equalsIgnoreCase("1"))
					{
						
						gmanto.init();
						boolean envioPedido = gmanto.EnviaPedidoAMayorista(infoCliente, Integer.toString(pedidoActualizado));
						gmanto.destroy();
						//System.out.println("envioPedido: " + envioPedido);
						
						if (envioPedido == false) {
						// Aqui actualiza a 17
						GestorAltaArticuloEnCarrito.ActualizaPedidoEstatus17(this.querys,infoCliente, transporte,consignatario,Integer.toString(pedidoActualizado));
						}
						
						
						gmanto.init();
						boolean envioPedido72hrs = gmanto.EnviaPedido72Hrs(this.querys, infoCliente, Integer.toString(pedidoActualizado));
					    gmanto.destroy();
						//System.out.println("envioPedido72hrs: " + envioPedido72hrs);
						if (envioPedido72hrs == false) {
							// Aqui actualiza a 17
							GestorAltaArticuloEnCarrito.ActualizaPedido72HrsEstatus17(this.querys,infoCliente, transporte,consignatario,Integer.toString(pedidoActualizado));
						 
						}
					}*/
					GestorAltaArticuloEnCarrito.ActualizaPedidoEstatus17(this.querys,infoCliente, transporte,consignatario,Integer.toString(pedidoActualizado));
					GestorAltaArticuloEnCarrito.ActualizaPedido72HrsEstatus17(this.querys,infoCliente, transporte,consignatario,Integer.toString(pedidoActualizado));
				}
				
				GestorAltaArticuloEnCarrito.GeneraNuevoPedidoSiguiente(this.querys,infoCliente,transporte,consignatario,pedido);
			}

			RecargaInfoCliente(session, infoCliente);

		}
		catch (Exception ex) {
			Log log=new Log(1,infoCliente.getCve_cdo(),infoCliente.getCve_cliente() ,pedidoActualizado, "[Error al Finalizar Pedido  en carrito, clase: MantenimientoCarritoCompras.AcutalizaEstatusPedido: "+ num_pedido_carrito + ". Ex: "+ ex.toString().replace("'", "") + "].");
			Cls_Log.insertaLog(log);
		}	
	}
	
	
	
	private void RecargaInfoCliente( HttpSession session, InfoCliente infoCliente)  {
		GestorIniciaSessionV2 gstor = new GestorIniciaSessionV2();
		InformacionInicialCarrito infoInicialCarrito  = null;
		try {
			
			Log log=new Log(1,infoCliente.getCve_cdo(),infoCliente.getCve_cliente() ,0, "[ RecargaInfoCliente 1.-: Cargando informacion de base de datos. ]" );
			Cls_Log.insertaLog(log);
			infoInicialCarrito = gestorIniSession.consultaInformacionInicialDelCliente(this.querys, String.valueOf(infoCliente.getCve_cliente())+String.valueOf(infoCliente.getCve_cdo()));
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
		} catch (Exception e) {
			Log log=new Log(1,infoCliente.getCve_cdo(),infoCliente.getCve_cliente() ,0, "[Error en Recargar la informacion del cliente desde Session. Clase: ManrenimientoCarritoCompras, Metodo: RecargaInfoCliente. Submetodo: consultaInformacionInicialDelCliente " + e );
			Cls_Log.insertaLog(log);
		}
		
		
		try {		
			Log log=new Log(1,infoCliente.getCve_cdo(),infoCliente.getCve_cliente() ,0, "[ RecargaInfoCliente 2.-: Llamando a consultaRelacionBodegaCteWS. ]" );
			Cls_Log.insertaLog(log);
			 
			infoCliente =  GestorBodegaCliente.consultaRelacionBodegaCteWS(infoCliente);
			 
		} catch (Exception e) {
			if (infoCliente.getCve_cliente() > 0)
			{
				Log log=new Log(1,infoCliente.getCve_cdo(),infoCliente.getCve_cliente() ,0, "[Error en Recargar la informacion del cliente desde Session. Clase: ManrenimientoCarritoCompras, Metodo: RecargaInfoCliente. Submetodo: consultaRelacionBodegaCteWS " + e );
				Cls_Log.insertaLog(log);
			}
		}
		
		
		try {
			Log log=new Log(1,infoCliente.getCve_cdo(),infoCliente.getCve_cliente() ,0, "[ RecargaInfoCliente 3.-: Llamando a ConsultaPorcentajeDeDescuento. ]" );
		    Cls_Log.insertaLog(log);
			 
			infoCliente.setFac_descuento( gstor.ConsultaPorcentajeDeDescuento(this.querys, infoCliente.getLetra_descuento()  ) );	
		 
		} catch (Exception e) {
			Log log=new Log(1,infoCliente.getCve_cdo(),infoCliente.getCve_cliente() ,0, "[Error en Recargar la informacion del cliente desde Session. Clase: ManrenimientoCarritoCompras, Metodo: RecargaInfoCliente. Submetodo: consultaRelacionBodegaCteWS " + e );
			Cls_Log.insertaLog(log);
		}	
		
		try {
			Log log=new Log(1,infoCliente.getCve_cdo(),infoCliente.getCve_cliente() ,0, "[ RecargaInfoCliente 4.-: Llamando a consultaEjecucionDemonios. ]" );
		    Cls_Log.insertaLog(log);
		infoCliente =  gstor.consultaEjecucionDemonios(infoCliente); 
		} catch (Exception e) {
			Log log=new Log(1,infoCliente.getCve_cdo(),infoCliente.getCve_cliente() ,0, "[Error en Recargar la informacion del cliente desde Session. Clase: ManrenimientoCarritoCompras, Metodo: RecargaInfoCliente. Submetodo: consultaEjecucionDemonios " + e );
			Cls_Log.insertaLog(log);
		}	
		try {
			Log log=new Log(1,infoCliente.getCve_cdo(),infoCliente.getCve_cliente() ,0, "[ RecargaInfoCliente 5.-: Llamando a Servicio de Mesajes del usuario. ]" );
		    Cls_Log.insertaLog(log);
		    int totalMensajes = RecuperaMensajes(infoInicialCarrito.getInfocliente().getCentro(), infoInicialCarrito.getInfocliente().getCve_cliente());
		    session.setAttribute("centroMensajesTotalPEndientes", 0);
		    session.setAttribute("centroMensajesImagen", "mailBlue");
		    if(totalMensajes > 0)
		    {
		    	session.setAttribute("centroMensajesTotalPEndientes", totalMensajes);
		    	session.setAttribute("centroMensajesImagen", "mailRed");
		    }
		
		    session.setAttribute("estiloTotalProductos", "estiloCarritoProductosCERO");
		    if (  infoInicialCarrito.getArticulosCarrito() >0 )
		    {
		    	session.setAttribute("estiloTotalProductos",  "estiloCarritoProductosLleno");
		    }
		
		} catch (Exception e) {
			Log log=new Log(1,infoCliente.getCve_cdo(),infoCliente.getCve_cliente() ,0, "[Error en Recargar la informacion del cliente desde Session. Clase: ManrenimientoCarritoCompras, Metodo: RecargaInfoCliente. Submetodo: RecuperaMensajes " + e );
			Cls_Log.insertaLog(log);
		}	
	}

	@SuppressWarnings("unchecked")
	private ArticulosCarritoPedidoCompleto ModificaCantidadesArticulo(HttpServletRequest request, HttpSession session) {
		ArticulosCarritoPedidoCompleto pedidoCompletoCarrito = new ArticulosCarritoPedidoCompleto();
		InfoCliente infoCliente = (InfoCliente) session.getAttribute("infoCliente");

		
		String num_pedido_carrito = (String) session.getAttribute("numeroPedidoCarrito");
		String articulo= String.valueOf(request.getParameter("num_art")); 
		try {
			
			int Cantidad = Integer.parseInt(String.valueOf(request.getParameter("cantidadPedida")));
			boolean Inserta72Hr = Boolean.parseBoolean(String.valueOf(request.getParameter("GeneraTraspaso")));
			
            int pedido = Integer.parseInt((request.getParameter("pedido")));			
			
			int exietnciaCDO= Integer.parseInt(String.valueOf(request.getParameter("exietnciaCDO")));
			int existenciaBR =  Integer.parseInt(String.valueOf(request.getParameter("existenciaBR")));
			int exietnciaTraspaso=  Integer.parseInt(String.valueOf(request.getParameter("exietnciaTraspaso")));
			String cdoTraspaso ="";
			float importe= Float.parseFloat(String.valueOf(request.getParameter("importe")));
			
			String GeneraTraspaso = "";
			if (Inserta72Hr == true)
			{
				GeneraTraspaso = "T";
				cdoTraspaso = String.valueOf(request.getParameter("cdoTraspaso"));
			}

			GestorMantenimientoCarritoComprasV2 gMtto = new GestorMantenimientoCarritoComprasV2();
			
			pedidoCompletoCarrito = gMtto.ModificaCantidadesArticulos(this.querys, infoCliente, articulo, pedido, Cantidad, Inserta72Hr, exietnciaCDO, existenciaBR, exietnciaTraspaso, importe, GeneraTraspaso, cdoTraspaso);
	 
			List<Consignatarios> consignatrios = GestorConsignatarios.consultaConsignatariosWS(infoCliente);
			List<Transportes> transportes = GestorTrasnportes.consultaTransportesWS(infoCliente);
		 
			pedidoCompletoCarrito.setListConsignatarios(consignatrios);
			pedidoCompletoCarrito.setListTransportes(transportes);
			pedidoCompletoCarrito.setListaDistancias( (List<Distancia>) session.getAttribute("listaDistancias") );
			pedidoCompletoCarrito.setInfoCte(infoCliente);
			session.setAttribute("articulosEnElCarrito",  pedidoCompletoCarrito.getDetallePedido().size());
			
			session.setAttribute("estiloTotalProductos", "estiloCarritoProductosCERO");
			if ( pedidoCompletoCarrito.getDetallePedido().size() >0 )
			{
				session.setAttribute("estiloTotalProductos",  "estiloCarritoProductosLleno");
			}
			
			Log log=new Log(1,infoCliente.getCve_cdo(),infoCliente.getCve_cliente() ,Integer.parseInt(num_pedido_carrito), "[Accion: actualiza Cantidades pedidoas pieza: "+ articulo +", Cant pedida: "+ Cantidad +"].");
			Cls_Log.insertaLog(log);
			
		}
		catch (Exception e) {
			//System.out.println("NuevoportalRamaCDO.-Error: modifcar pedido: " + e.toString());
			
			Log log=new Log(1,infoCliente.getCve_cdo(),infoCliente.getCve_cliente() ,Integer.parseInt(num_pedido_carrito), "[Error en actualizar Cantidades pedidoas pieza: "+ articulo +". Ex: " + e.toString().replace("´","") +" ].");
			Cls_Log.insertaLog(log);
		}	
		return pedidoCompletoCarrito;
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
