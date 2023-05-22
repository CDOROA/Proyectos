package cdo.Web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.mail.Session;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONArray;

import com.google.gson.Gson;
import com.sun.mail.iap.Response;
import com.sun.research.ws.wadl.Request;

import cdo.Datos.EstadoDeCuenta;
import cdo.Datos.EstadoDeCuentaDetalle;
import cdo.Datos.InfoCliente;
import cdo.Datos.PedidoCdo;
import cdo.Datos.PedidoCdoDetalle;
import cdo.Datos.PedidosDetallesCdo;
import cdo.Datos.Querys;
import cdo.Datos.SeguimientoPedidosOtrosCanales;
import cdo.Datos.SeguimientoPedidosResumen;
import cdo.Persistencia.GestorPaginaPrincipal;
import cdo.Persistencia.GestorPedidoMayorista;
import cdo.Persistencia.GestorSeguimientoDePedidosV2;

public class SeguimientoDePedidosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static List<Querys> querys;
	GestorSeguimientoDePedidosV2 gestorPedidos;
	GestorPaginaPrincipal gestorInicial;
	
    public SeguimientoDePedidosServlet() {
        super();
        gestorPedidos= new GestorSeguimientoDePedidosV2();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
		response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
		response.setHeader("Expires", "-1"); // Proxies.
		
		if(session != null)
		{
			 this.querys = gestorInicial.ConsultaTablaQuerysBD();
			verificaPeticionOrigen(request,response, session);
		}
		else
		{
			if(session == null)
			{
				System.out.println("Seguimiento de Pedidos: Session no valida");
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
					case "ConsultaSeguimientoDePedido":
						 List<SeguimientoPedidosResumen> listSeguimientoResumen = consultaResumenDePedidos(request, response, session);						 
						 String listaJson = gson.toJson(listSeguimientoResumen);
						 //  System.out.println("listaJson ConsultaSeguimientoDePedido:" + listaJson);
						 enviarRespuestaJsonJS(request,response, listaJson);
						break;	
					case "ConsultaPedidoDetalleCliente":
						List<PedidosDetallesCdo>  Listapedidos = ConsultaPedidoCliente(request, response, session);						 
						 String listaJsonPed = gson.toJson(Listapedidos);
						 // System.out.println("listaJsonPed: " + listaJsonPed.toString());
						 enviarRespuestaJsonJS(request,response, listaJsonPed);
						break;	
					case "ConsultaSeguimientoDePedidoOtrosCanales":
						JSONArray jsonObjDatos = consultaPedidosOtrosCanales(request, response, session);						 
						// System.out.println("listaJson ConsultaSeguimientoDePedido:" + jsonObjDatos);
						 enviarRespuestaJsonJS(request,response, jsonObjDatos.toString());
					break;
					case "ConsultaPedidoDetalleClienteOtrosPedidos":
						List<PedidoCdo>  ListapedidosOtros =  ConsultaPedidoClienteOtros(request, response, session);							 
						 String listaJsonPedOtros = gson.toJson(ListapedidosOtros);
						 // System.out.println("listaJsonPed: " + listaJsonPedOtros.toString());
						 enviarRespuestaJsonJS(request,response, listaJsonPedOtros);
						break;	
				}					
			break;
		}
	}	




	private List<SeguimientoPedidosResumen> consultaResumenDePedidos(HttpServletRequest request, HttpServletResponse response, HttpSession session)
	{
		List<SeguimientoPedidosResumen> listSeguimientoResumen = null;
		try
		{
		InfoCliente infoCliente = (InfoCliente) session.getAttribute("infoCliente");
		String fechaIni = request.getParameter("fechaIni");
		String fechaFin = request.getParameter("fechaFin");
		int numeroPedido = Integer.parseInt(request.getParameter("NumeroPedido"));
		  listSeguimientoResumen= gestorPedidos.consultarResumenDePedidos(this.querys, infoCliente,fechaIni,fechaFin,numeroPedido);
		}
		catch (Exception e) {
			SeguimientoPedidosResumen resumen = new SeguimientoPedidosResumen();
			resumen.setCantPedida(0);
			resumen.setCantSurtida(0);
			resumen.setCveEstatusBr(0);
			resumen.setCveEstatusCdo(0);
			resumen.setEstatusCdo("");
			resumen.setFecha("");
			resumen.setHora("");
			resumen.setImporteFacturado("0.00");
			resumen.setImportePedido("0.00");
			resumen.setPedido(0);
			resumen.setPedMayBr(0);
			resumen.setPedMayCdo(0);
			resumen.setPed72Hrs("0");
			resumen.setPed72HrsDescrip("");
			resumen.setEstatusEntrega("");
			resumen.setTransporte("");
			resumen.setImgEntrega("EstCapturado.png");
			resumen.setEstatusCdo("");
			resumen.setEstatusEntrega("");
			resumen.setTransporte("");
			resumen.setImgEntrega("");
			
			listSeguimientoResumen.add(resumen);
		}
		return listSeguimientoResumen;
	}

	private JSONArray consultaPedidosOtrosCanales(HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		JSONArray jsonObjDatos = new JSONArray();
		try {
			InfoCliente infoCliente = (InfoCliente) session.getAttribute("infoCliente");
			int rango = Integer.parseInt(request.getParameter("rango"));
			
			GestorPedidoMayorista pedMay = new GestorPedidoMayorista();
			pedMay.init();
			jsonObjDatos = pedMay.consultaPedidoMayOtrosCanalesWs(infoCliente.getCentro(), infoCliente.getCve_cliente(),rango);
			pedMay.destroy();
			
		} catch (Exception e) {
			//System.out.println("NuevoportalRamaCDO.- Error en consultaPedidosOtrosCanales: " + e);
		}
		return jsonObjDatos;
	}
	
	private List<PedidoCdo> ConsultaPedidoClienteOtros(HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		List<PedidoCdo> Listapedidos = null;
		try {
		InfoCliente infoCliente = (InfoCliente) session.getAttribute("infoCliente");
		String pedidos = request.getParameter("pedidos");
		String pedidoWWW = request.getParameter("pedidoWWW");	
	 
		Listapedidos =  gestorPedidos.ConsultaPedidosClienteOtros(infoCliente, pedidos,this.querys, pedidoWWW);
	
		}catch(Exception e) {
		// 	System.out.println("NuevoportalRamaCDO.- Error en ConsultaPedidoCliente: " + e);
			PedidosDetallesCdo ped = new PedidosDetallesCdo(); 
			List<PedidoCdo> listaPedido =  new ArrayList<PedidoCdo>();
			PedidoCdo p = new PedidoCdo();
			listaPedido.add(p);
			
			PedidoCdoDetalle dp = new PedidoCdoDetalle();
			
			List<PedidoCdoDetalle> ListaDp =  new ArrayList<PedidoCdoDetalle>();
			ListaDp.add(dp);
			
			ped.setPedidoCdo(listaPedido);
			ped.setDetallePedidoCdo(ListaDp);
			
		}
		return Listapedidos;
	}
	
	private List<PedidosDetallesCdo> ConsultaPedidoCliente(HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		List<PedidosDetallesCdo> Listapedidos = null;
		try {
		InfoCliente infoCliente = (InfoCliente) session.getAttribute("infoCliente");
		String pedidos = request.getParameter("pedidos");
		String pedidoWWW = request.getParameter("pedidoWWW");	
	 
		Listapedidos =  gestorPedidos.ConsultaPedidosCliente(infoCliente, pedidos,this.querys, pedidoWWW);
	
		}catch(Exception e) {
		// 	System.out.println("NuevoportalRamaCDO.- Error en ConsultaPedidoCliente: " + e);
			PedidosDetallesCdo ped = new PedidosDetallesCdo(); 
			List<PedidoCdo> listaPedido =  new ArrayList<PedidoCdo>();
			PedidoCdo p = new PedidoCdo();
			listaPedido.add(p);
			
			PedidoCdoDetalle dp = new PedidoCdoDetalle();
			
			List<PedidoCdoDetalle> ListaDp =  new ArrayList<PedidoCdoDetalle>();
			ListaDp.add(dp);
			
			ped.setPedidoCdo(listaPedido);
			ped.setDetallePedidoCdo(ListaDp);
			
		}
		return Listapedidos;
	}
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
	
	

}
