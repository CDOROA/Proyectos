package cdo.Web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import cdo.Datos.Credito;
import cdo.Datos.MarcadoClientes;
import cdo.Datos.PedidosConsulta;
import cdo.Datos.PedidosConsultaRC;
import cdo.Datos.Querys;
import cdo.Datos.TrayectoDatos;
import cdo.Datos.Usuario;
import cdo.Datos.VariosTickets;
import cdo.Persistencia.GestorPedidos;
import cdo.util.GenerarExcel;

public class MonitorPedidosServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
      GestorPedidos gestorPedidos = new GestorPedidos();
      private static List<Querys> querys = null;
      GenerarExcel generar = new GenerarExcel();
    public MonitorPedidosServlet() 
    {
    	super();
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
    	response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
        response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
        response.setHeader("Expires", "-1"); // Proxies.

		HttpSession session = request.getSession(false);
		if (session != null) 
		{
			this.querys  = (List<Querys>)session.getAttribute("querys");
			VerificaPeticionOrigen(request, response, session);
		}
		else
		{
			if (session == null) 
			{
				RequestDispatcher rdIndex = request.getRequestDispatcher("/index.jsp");
				rdIndex.forward(request, response);
				return;
			}
		}
	}


	private void VerificaPeticionOrigen(HttpServletRequest request, HttpServletResponse response, HttpSession session) 
	{
		String accion = request.getParameter("accion");
		switch (accion) 
		{
			case "ConsultaMarcadoClientes":
				session.setAttribute("redireccionar","1");
				consultarMarcadoClientes(request,response,session);
				
			break;
			case "ConsultarPedidos":
				session.setAttribute("redireccionar","1");
				consultarPedidos(request,response,session);
				
			break;
			
			case "ObtenerFacturasPedidos":
				session.setAttribute("redireccionar","1");
				ObtenerFacturasPedidos(request,response,session);
				
			break;
			
			case "ObtenerFacturasPedidosTrans":
				session.setAttribute("redireccionar","2");
				ObtenerFacturasPedidosTrans(request,response,session);
				
			break;
			
			case "ConsultarPedidosTrans":
				session.setAttribute("redireccionar","2");
				consultarPedidosTrans(request,response,session);
				
			break;
			case "AsignarPedidos":
				session.setAttribute("redireccionar","1");
				asignarPedidos(request,response,session);
				break;
			case "AsignarPedidosORDEN":
				session.setAttribute("redireccionar","1");
				asignarPedidosORDEN(request,response,session);	
			break;
			case "CancelarPedido":
				session.setAttribute("redireccionar","1");
				cancelarPedido(request,response,session);
				
			break;
			case "CancelarTrayecto":
				session.setAttribute("redireccionar","3");
				cancelarTrayecto(request,response,session);
				
			break;
			case "ConsultarTrayecto":
				session.setAttribute("redireccionar","3");
				consultarTrayecto(request,response,session);
				
			break;
			case "ActualizarFacturas":
				actualizarFacturas(request,response,session);
			break;
			case "ConsultarTrayectoCliente":
				session.setAttribute("redireccionar","3");
				consultarTrayectoCliente(request,response,session);
				
			break;
			case "GenerarExcel":
				generarExcel(request,response,session);
				
			break;
			case "ConsultarOde":
				consultarOde(request,response,session);
			break;
			case "imprimirticket":
				imprimirTicket(request,response,session);
			break;
			case "imprimirticketCorte":
				imprimirTicketCorte(request,response,session);
			break;
			case "AsignarPedidosTrans":
				session.setAttribute("redireccionar","2");
				asignarPedidosTrans(request,response,session);
				
			break;
			case "ConsultarDetalle":
				consultarDetalle(request,response,session);
			break;
			case "ConsultarCorte":
				consultarCorte(request,response,session);
			break;
			case "ConsultarCredito":
				consultarCredito(request,response,session);
			break;
			case "refrescar":
				refrescar(request,response,session);
			break;
			case "ConsultarPedidosRC":
				consultarPedidosRC(request,response,session);
			break;
			case "ObtenerFacturasRC":
				 obtenerFacturasRC(request,response,session);
			break;
			case "ConsultarFactura":
				consultarFactura(request,response,session);
		    break;
			case "AsignarPedidosRC":
				asignarPedidosRC(request,response,session);
			break;
			case "AsignarPedidosORDENRC":
				asignarPedidosOrdenRC(request,response,session);
			break;
			case "consultarDetalleRC":
				consultarDetalleRC(request,response,session);
			break;
			case "ObtenerCantidadDetalleRC":
				obtenerCantidadDetalleRC(request,response,session);
			break;
			case "AsignarPedidosDetalleRC":
				asignarPedidosDetalleRC(request,response,session);
			break;
			case "ActualizarPedidosDetalleRC":
				actualizarPedidosDetalleRC(request,response,session);
			break; 
			case "enviarTraspasoCDO":
				enviarTraspasoCDO(request, response, session);
			break;
		}
	}

	private void consultarMarcadoClientes(HttpServletRequest request, HttpServletResponse response,HttpSession session) 
	{
		Usuario infoUsu = (Usuario) session.getAttribute("infoUsu");
		String uname = infoUsu.getUname();
		String ruta = request.getParameter("ruta").toString();
		String tipo = request.getParameter("tipo").toString();
		String fechaInicio = request.getParameter("fechaInicio").toString();
		String fechaFin = request.getParameter("fechaFin").toString();
	    Gson gson = new Gson();
		List<MarcadoClientes> lstMarcado = new ArrayList<>();
//		lstMarcado = gestorPedidos.consultaMarcadoClientes(infoUsu.getUname().toUpperCase(),session.getAttribute("hora").toString(),session,infoUsu.getCve_usuario(),infoUsu.getUname_br(),infoUsu.getDato_alfanumerico(),querys,infoUsu,lstMarcado,ruta,tipo,aplicaFormatoFecha(fechaFin),aplicaFormatoFecha(fechaInicio));
		String listaJSON = gson.toJson(lstMarcado);
		EnviarRespuestaJsonJS(request,response,listaJSON);		
	}
	private void ObtenerFacturasPedidosTrans(HttpServletRequest request, HttpServletResponse response, HttpSession session)
	{
		List<PedidosConsulta> p = (List<PedidosConsulta>) session.getAttribute("listaPedidos");
		Gson gson = new Gson();
		String pedidos = request.getParameter("pedidos").toString();
		pedidos = pedidos+",";
		String splitPed [] = pedidos.split(",");
		int fact = 0;
		int ped = 0;
		for (String ode : splitPed) 
		{
			for (PedidosConsulta fp : p) 
			{
				if (fp.getOde().equals(ode)) 
				{
					fact++;
				}
			}
		}
		String pedidosOdes = request.getParameter("ped").toString();
		pedidosOdes = pedidosOdes+",";
		String splitPedidos [] = pedidosOdes.split(",");
		for (String string : splitPedidos) 
		{
			ped++;		}
		String listaJSON = gson.toJson("Se asignaran "+ped+" pedidos y "+fact+" facturas");
		EnviarRespuestaJsonJS(request,response,listaJSON);
		
	}
	
	private void obtenerCantidadDetalleRC(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		Gson gson = new Gson();
		int fac = 0;
		String facturasTras = request.getParameter("articulosDetalle").toString();
		facturasTras = facturasTras+",";
		String splitFacturas [] = facturasTras.split(",");
		for(String string : splitFacturas) {
			fac++;
		}
		String listaJSON = gson.toJson("Se asignaran "+fac+" articulos de la Factura.");
		EnviarRespuestaJsonJS(request,response,listaJSON);
	}

	private void obtenerFacturasRC(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		Gson gson = new Gson();
		int fac = 0;
		String facturasTras = request.getParameter("facturasTras").toString();
		facturasTras = facturasTras+",";
		String splitFacturas [] = facturasTras.split(",");
		for(String string : splitFacturas) {
			fac++;
		}
		String listaJSON = gson.toJson("Se asignaran "+fac+" facturas");
		EnviarRespuestaJsonJS(request,response,listaJSON);
	}

	private void ObtenerFacturasPedidos(HttpServletRequest request, HttpServletResponse response, HttpSession session)
	{
		List<PedidosConsulta> p = (List<PedidosConsulta>) session.getAttribute("listaPedidos");
		Gson gson = new Gson();
		String pedidos = request.getParameter("pedidos").toString();
		pedidos = pedidos+",";
		String splitPed [] = pedidos.split(",");
		int fact = 0;
		int ped = 0;
		for (String ode : splitPed) 
		{
			for (PedidosConsulta fp : p) 
			{
				if (fp.getOde().equals(ode)) 
				{
					fact++;
				}
			}
		}
		String pedidosOdes = request.getParameter("ped").toString();
		//System.out.println("pedidosOdes "+pedidosOdes);
		pedidosOdes = pedidosOdes+",";
		String splitPedidos [] = pedidosOdes.split(",");
		//System.out.println(splitPedidos.length);
		for (String string : splitPedidos) 
		{
			ped++;		}
		
		String listaJSON = gson.toJson("Se asignaran "+ped+" pedidos y "+fact+" facturas");
		EnviarRespuestaJsonJS(request,response,listaJSON);
		
	}
	private void cancelarTrayecto(HttpServletRequest request, HttpServletResponse response, HttpSession session) 
	{
		Gson gson = new Gson();
		String trayecto = request.getParameter("trayecto").toString();
		String uname_br = request.getParameter("uname_br").toString();
		String tipo = request.getParameter("tipo").toString();
		Usuario infoUsu = (Usuario) session.getAttribute("infoUsu");
		List<String> lstConsultarTipoCP = new ArrayList<>();
		 lstConsultarTipoCP = gestorPedidos.consultarTipoCP(infoUsu,session,querys);
		String rsp = gestorPedidos.cancelarTrayecto(request,session,trayecto,infoUsu,querys,uname_br,tipo,lstConsultarTipoCP);
		String listaJSON = gson.toJson(rsp);
		EnviarRespuestaJsonJS(request,response,listaJSON);
	}
	private void refrescar(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		Gson gson = new Gson();
		String listaJSON = gson.toJson("");
		EnviarRespuestaJsonJS(request,response,listaJSON);	
		
	}
	private void imprimirTicketCorte(HttpServletRequest request, HttpServletResponse response, HttpSession session) 
	{
			Usuario infoUsu = (Usuario) session.getAttribute("infoUsu");
			Gson gson = new Gson();
			String folio = request.getParameter("folio").toString();
			String rsp = gestorPedidos.imprimirTicketSeparadoCorte(folio,infoUsu,session,querys,infoUsu);
			String listaJSON = gson.toJson(rsp);
			EnviarRespuestaJsonJS(request,response,listaJSON);	
	}
	private void consultarCredito(HttpServletRequest request, HttpServletResponse response, HttpSession session) 
	{
		Gson gson = new Gson();
		String fecha =  aplicaFormatoFecha(request.getParameter("fecha").toString());
		String fechaFin =  aplicaFormatoFecha(request.getParameter("fechaFin").toString());
		String tipo = request.getParameter("tipo").toString();
		String corte = request.getParameter("corte").toString();
		String cdoCredito = request.getParameter("cdoCredito").toString();
		List<Credito> lstTreyecto = new ArrayList<>();
		Usuario infoUsu = (Usuario) session.getAttribute("infoUsu");
		lstTreyecto =  gestorPedidos.consultarCredito(request,session,infoUsu,querys,lstTreyecto,fecha,cdoCredito,tipo,fechaFin,corte);
		String listaJSON = gson.toJson(lstTreyecto);
		EnviarRespuestaJsonJS(request,response,listaJSON);
	}
	private void actualizarFacturas(HttpServletRequest request, HttpServletResponse response, HttpSession session) 
	{
		Gson gson = new Gson();
		String facturas =  request.getParameter("pedidos").toString();
		List<Credito> lstTreyecto = new ArrayList<>();
		Usuario infoUsu = (Usuario) session.getAttribute("infoUsu");
		String rsp =   gestorPedidos.actualizarCredito(request,session,infoUsu,querys,facturas);
		String listaJSON = gson.toJson(rsp);
		EnviarRespuestaJsonJS(request,response,listaJSON);		
	}
	private void consultarCorte(HttpServletRequest request, HttpServletResponse response, HttpSession session) 
	{
		String fecha =  aplicaFormatoFecha(request.getParameter("fecha").toString());
		 
		String  cdo  = request.getParameter("cdo").toString();
		Gson gson = new Gson();
		Usuario infoUsu = (Usuario) session.getAttribute("infoUsu");
		String rsp  =  gestorPedidos.consultarDetalle(request,session,fecha,infoUsu,querys,cdo);
		
		String listaJSON = gson.toJson(rsp);
		EnviarRespuestaJsonJS(request,response,listaJSON);
	}
	private void consultarDetalle(HttpServletRequest request, HttpServletResponse response, HttpSession session) 
	{
		Gson gson = new Gson();
		String folio = request.getParameter("id_trayecto").toString();
		String  uname  = request.getParameter("uname").toString();
		List<TrayectoDatos> lstTreyecto = new ArrayList<>();
		Usuario infoUsu = (Usuario) session.getAttribute("infoUsu");
		lstTreyecto =  gestorPedidos.consultarDetalle(request,session,folio,infoUsu,querys,lstTreyecto,uname);
		String listaJSON = gson.toJson(lstTreyecto);
		EnviarRespuestaJsonJS(request,response,listaJSON);
	}
	private void cancelarPedido(HttpServletRequest request, HttpServletResponse response, HttpSession session)
	{
		Gson gson = new Gson();
		String ode = request.getParameter("ode").toString();
		String uname_br = request.getParameter("uname_br").toString();
		Usuario infoUsu = (Usuario) session.getAttribute("infoUsu");
		String rsp = gestorPedidos.cancelarPedido(request,session,ode,infoUsu,querys,uname_br);
		String listaJSON = gson.toJson(rsp);
		EnviarRespuestaJsonJS(request,response,listaJSON);
		
	}
	private void consultarOde(HttpServletRequest request, HttpServletResponse response, HttpSession session) 
	{
		Gson gson = new Gson();
		String ode = request.getParameter("ode").toString();
		Usuario infoUsu = (Usuario) session.getAttribute("infoUsu");
		String rsp = gestorPedidos.consultarOde(request,session,ode,infoUsu,querys);
		String listaJSON = gson.toJson(rsp);
		EnviarRespuestaJsonJS(request,response,listaJSON);
	}
	
	private void consultarFactura(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		Gson gson = new Gson();
		String factura = request.getParameter("factura").toString();
		//System.out.println("factura: "+factura);
		Usuario infoUsu = (Usuario) session.getAttribute("infoUsu");
		String existeFact = gestorPedidos.consultarFactura(request,session,factura,infoUsu,querys);
		String listaJSON = gson.toJson(existeFact);
		EnviarRespuestaJsonJS(request,response,listaJSON);
	}
	
	private void generarExcel(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		Gson gson = new Gson();
		String tipo = request.getParameter("tipo").toString();
		String rsp = "";
		if (tipo.equals("c")) 
		{
			rsp = generar.generarExcel(session,request,response);
		}
		else
		{
			rsp = generar.generarExcelGeneral(session,request,response);
		}
		
		String listaJSON = gson.toJson(rsp);
		EnviarRespuestaJsonJS(request,response,listaJSON);
	}
	private void consultarTrayectoCliente(HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {

		String rutaInicio = request.getParameter("rutaInicio").toString();
		String rutaFin = request.getParameter("rutaFin").toString();
		String factura = request.getParameter("factura").toString();
		String choferInicio = request.getParameter("choferInicio").toString();
		String choferFin = request.getParameter("choferFin").toString();
		String fechaInicio = aplicaFormatoFecha(request.getParameter("fechaInicio").toString());
		String fechaFin = aplicaFormatoFecha(request.getParameter("fechaFin").toString());
		String cliente = request.getParameter("cliente").toString();
		String clienteFin = request.getParameter("clienteFin").toString();
		String pedido = request.getParameter("pedido").toString();
		String check = request.getParameter("cdo").toString();
		
		Gson gson = new Gson();
		Usuario infoUsu = (Usuario) session.getAttribute("infoUsu");
		
		List<TrayectoDatos> lstTreyecto = new ArrayList<>();
		List<String> lstConsultarTipoCP = new ArrayList<>();
		 lstConsultarTipoCP = gestorPedidos.consultarTipoCP(infoUsu,session,querys);
		 lstTreyecto = gestorPedidos.consultarTrayecto(infoUsu,rutaInicio,rutaFin,lstTreyecto,fechaInicio,choferInicio,choferFin,fechaFin,cliente,"ruta",clienteFin,factura,pedido,querys,check,session,lstConsultarTipoCP);
		 session.setAttribute("listaExcel", lstTreyecto);
		String listaJSON = gson.toJson(lstTreyecto);
		EnviarRespuestaJsonJS(request,response,listaJSON);
		
	}
	private void consultarTrayecto(HttpServletRequest request, HttpServletResponse response, HttpSession session)
	{
		String rutaInicio = request.getParameter("rutaInicio").toString();
		String rutaFin = request.getParameter("rutaFin").toString();
		String pedido = request.getParameter("pedido").toString();
		String choferInicio = request.getParameter("choferInicio").toString();
		String choferFin = request.getParameter("choferFin").toString();
		String fechaInicio = aplicaFormatoFecha(request.getParameter("fechaInicio").toString());
		String fechaFin = aplicaFormatoFecha(request.getParameter("fechaFin").toString());
		String factura = request.getParameter("factura").toString();
		String check = request.getParameter("cdo").toString();
		
		Gson gson = new Gson();
		Usuario infoUsu = (Usuario) session.getAttribute("infoUsu");
		
		List<TrayectoDatos> lstTreyecto = new ArrayList<>();
		List<String> lstConsultarTipoCP = new ArrayList<>();
		 lstConsultarTipoCP = gestorPedidos.consultarTipoCP(infoUsu,session,querys);
		 lstTreyecto = gestorPedidos.consultarTrayecto(infoUsu,rutaInicio,rutaFin,lstTreyecto,fechaInicio,choferInicio,choferFin,fechaFin,"","ruta","",factura,pedido,querys,check,session,lstConsultarTipoCP); 
		 session.setAttribute("listaExcelGeneral", lstTreyecto);
		String listaJSON = gson.toJson(lstTreyecto);
		EnviarRespuestaJsonJS(request,response,listaJSON);
	}
	
	private void actualizarPedidosDetalleRC(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		String articulos = request.getParameter("articulos").toString();
		Usuario infoUsu = (Usuario) session.getAttribute("infoUsu");
		boolean rsp = false;
		Gson gson = new Gson();
		rsp = gestorPedidos.actualizarPedidosDetalleRC(articulos,session,infoUsu,querys);
		String listaJSON = gson.toJson(rsp);
		EnviarRespuestaJsonJS(request,response,listaJSON);
	}
	
	private void asignarPedidosDetalleRC(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		String articulos = request.getParameter("articulos").toString();
		String posicionInsert = request.getParameter("posicionInsert");
		String chofer = request.getParameter("c").toString();		
		String numeroFacturasRC = request.getParameter("numeroFacturasRC").toString();
		String vehiculo = request.getParameter("vehiculo").toString();
		Usuario infoUsu = (Usuario) session.getAttribute("infoUsu");
		String rsp = "n";
		int nLlantas = 0;
		nLlantas = gestorPedidos.obtenerNumeroLlantas(querys, infoUsu);
		Gson gson = new Gson();
		//rsp = gestorPedidos.asignacionPedidosDetalleRC(articulos,chofer,infoUsu.getUname(),session,infoUsu.getCve_usuario(),infoUsu.getUname_br(),infoUsu.getUname_nombre(),"",infoUsu,querys,numeroFacturasRC,vehiculo,posicionInsert,nLlantas);
		String listaJSON = gson.toJson(rsp);
		EnviarRespuestaJsonJS(request,response,listaJSON);
	}
	
	private void asignarPedidosRC(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		String pedidosRC = request.getParameter("pedidosRC").toString();
		String posicionInsert = request.getParameter("posicionInsert");
		String chofer = request.getParameter("c").toString();
		String facturaAgregada = request.getParameter("facturaAgregada").toString();		
		String numeroFacturasRC = request.getParameter("numeroFacturasRC").toString();
		String vehiculo = request.getParameter("vehiculo").toString();
		Usuario infoUsu = (Usuario) session.getAttribute("infoUsu");
		String articulosFactura = request.getParameter("articulosFactura").toString();
		String rsp = "n";
		int nLlantas = 0;
		nLlantas = gestorPedidos.obtenerNumeroLlantas(querys, infoUsu);
		Gson gson = new Gson();
		rsp = gestorPedidos.asignacionPedidosRC(pedidosRC,chofer,infoUsu.getUname(),session,infoUsu.getCve_usuario(),infoUsu.getUname_br(),infoUsu.getUname_nombre(),facturaAgregada,"",infoUsu,querys,numeroFacturasRC,vehiculo,posicionInsert,nLlantas,articulosFactura);
		String listaJSON = gson.toJson(rsp);
		EnviarRespuestaJsonJS(request,response,listaJSON);
	}
	
	private void asignarPedidosOrdenRC(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		//System.out.println("Entra a asignarPedidosOrdenRC");
		String pedidosRC = request.getParameter("pedidosRC").toString();
		String chofer = request.getParameter("c").toString();
		String facturaAgregada = request.getParameter("facturaAgregada").toString();		
		String numeroFacturasRC = request.getParameter("numeroFacturasRC").toString();
		String vehiculo = request.getParameter("vehiculo").toString();
		Usuario infoUsu = (Usuario) session.getAttribute("infoUsu");
		String articulosFactura = request.getParameter("articulosFactura").toString();
		Gson gson = new Gson();
		List<MarcadoClientes> lstMarcadoClientes = new ArrayList<>();
		lstMarcadoClientes= gestorPedidos.asignacionPedidosORDENRC(pedidosRC,chofer,infoUsu.getUname(),session,infoUsu.getCve_usuario(),infoUsu.getUname_br(),infoUsu.getUname_nombre(),facturaAgregada,"",infoUsu,querys,numeroFacturasRC,vehiculo,(String)session.getAttribute("fechaFinChoferRC"),(String)session.getAttribute("fechaInicioChoferRC"));
		String listaJSON = gson.toJson(lstMarcadoClientes);
		EnviarRespuestaJsonJS(request,response,listaJSON);
	}
	
	private void asignarPedidos(HttpServletRequest request, HttpServletResponse response, HttpSession session) 
	{
		String pedidos = request.getParameter("pedidos").toString();
		String pedidosR = request.getParameter("pedidosR").toString();
		if (!pedidosR.equals("") && pedidosR.contains("r"))
		{
			pedidosR = pedidosR.replace("r","*r");
		}
		String posicionInsert = request.getParameter("posicionInsert");
		String chofer = request.getParameter("c").toString();
		String odeAgregada = request.getParameter("odeAgregada").toString();
		Gson gson = new Gson();
		String numeroFacturas = request.getParameter("numeroFacturas").toString();
		String vehiculo = request.getParameter("vehiculo").toString();
		Usuario infoUsu = (Usuario) session.getAttribute("infoUsu");
		String rsp = "n";
		int nLlantas = 0;
		nLlantas = gestorPedidos.obtenerNumeroLlantas(querys, infoUsu);
		rsp = gestorPedidos.asignacionPedidos(pedidos,chofer,infoUsu.getUname(),session,infoUsu.getCve_usuario(),infoUsu.getUname_br(),infoUsu.getUname_nombre(),odeAgregada,"",infoUsu,querys,pedidosR,numeroFacturas,vehiculo,posicionInsert,nLlantas);
		String listaJSON = gson.toJson(rsp);
		
		EnviarRespuestaJsonJS(request,response,listaJSON);	
	}
	
	private void asignarPedidosORDEN(HttpServletRequest request, HttpServletResponse response, HttpSession session) 
	{
		String pedidos = request.getParameter("pedidos").toString();
		String pedidosR = request.getParameter("pedidosR").toString();
		if (!pedidosR.equals("") && pedidosR.contains("r"))
		{
			pedidosR = pedidosR.replace("r","*r");
		}
		String chofer = request.getParameter("c").toString();
		String odeAgregada = request.getParameter("odeAgregada").toString();
		Gson gson = new Gson();
		String numeroFacturas = request.getParameter("numeroFacturas").toString();
		String vehiculo = request.getParameter("vehiculo").toString();
		Usuario infoUsu = (Usuario) session.getAttribute("infoUsu");
		List<MarcadoClientes> lstMarcadoClientes = new ArrayList<>();
		lstMarcadoClientes= gestorPedidos.asignacionPedidosORDEN(pedidos,chofer,infoUsu.getUname(),session,infoUsu.getCve_usuario(),infoUsu.getUname_br(),infoUsu.getUname_nombre(),odeAgregada,"",infoUsu,querys,pedidosR,numeroFacturas,vehiculo,(String)session.getAttribute("fechaFinChofer"),(String)session.getAttribute("fechaInicioChofer"));
		String listaJSON = gson.toJson(lstMarcadoClientes);
		EnviarRespuestaJsonJS(request,response,listaJSON);	
	}
	
	
	private void asignarPedidosTrans(HttpServletRequest request, HttpServletResponse response, HttpSession session) 
	{
		String pedidos = request.getParameter("pedidos").toString();
		String chofer = request.getParameter("c").toString();
		String odeAgregada = request.getParameter("odeAgregada").toString();
		String pedidosR = request.getParameter("pedidosR").toString();
		String numeroFacturas = request.getParameter("numeroFacturas").toString();
		if (!pedidosR.equals("") && pedidosR.contains("r"))
		{
			pedidosR = pedidosR.replace("r","*r");
		}
		String uname_regional = request.getParameter("uname_regional").toString();
		
		Gson gson = new Gson();
		
		Usuario infoUsu = (Usuario) session.getAttribute("infoUsu");
		String rsp = "n";
		
		rsp = gestorPedidos.asignacionPedidosTrans(pedidos,chofer,infoUsu.getUname(),session,infoUsu.getCve_usuario(),infoUsu.getUname_br(),infoUsu.getUname_nombre(),odeAgregada,"",infoUsu,querys,pedidosR,uname_regional,numeroFacturas);
		String listaJSON = gson.toJson(rsp);
		EnviarRespuestaJsonJS(request,response,listaJSON);		
	}
	
	private void imprimirTicket(HttpServletRequest request, HttpServletResponse response, HttpSession session)
	{
		Usuario infoUsu = (Usuario) session.getAttribute("infoUsu");
		Gson gson = new Gson();
		String folio = request.getParameter("folio").toString();
		String ticket = request.getParameter("ticket").toString();
		List<PedidosConsulta> p = (List<PedidosConsulta>) session.getAttribute("listaPedidos");
		String uname_chofer = request.getParameter("uname_chofer").toString();
		if (!uname_chofer.equals("") && !uname_chofer.equals("undefined")) 
		{
			String rsp = gestorPedidos.imprimirTicketSeparado(folio,infoUsu,p,session,querys,infoUsu,uname_chofer,ticket);
			String listaJSON = gson.toJson("VARIOS-"+rsp);
			EnviarRespuestaJsonJS(request,response,listaJSON);	
		}
		else
		{
		
		List<VariosTickets> t = new ArrayList<>();
		t = gestorPedidos.validarExistencia(folio,infoUsu,session,querys,t);
		if (t.size() == 1 || t.size() == 0)
		{
			String rsp = gestorPedidos.imprimirTicketSeparado(folio,infoUsu,p,session,querys,infoUsu,"",ticket);
			String listaJSON = gson.toJson("VARIOS-"+rsp);
			EnviarRespuestaJsonJS(request,response,listaJSON);	
		}
		else
		{
			String listaJSON = gson.toJson(t);
			EnviarRespuestaJsonJS(request,response,listaJSON);	
		}
		}
			
	}
	
	private void consultarDetalleRC(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		String factura = request.getParameter("factura").toString();
		List<PedidosConsultaRC> lstPedidosRCDet = new ArrayList<>();
		Usuario infoUsu = (Usuario) session.getAttribute("infoUsu");
		lstPedidosRCDet = gestorPedidos.consultarPedidosRCDetalle(infoUsu.getUname(),session,querys,infoUsu,factura);
		Gson gson = new Gson();
		String listaJSON = gson.toJson(lstPedidosRCDet);
		EnviarRespuestaJsonJS(request,response,listaJSON);
	}
	
	private void consultarPedidosRC(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		String fechaInicio = request.getParameter("fechaInicio").toString();
		String fechaFin = request.getParameter("fechaFin").toString();
		session.setAttribute("fechaInicioChoferRC", aplicaFormatoFecha(fechaInicio));
		session.setAttribute("fechaFinChoferRC", aplicaFormatoFecha(fechaFin));
		List<PedidosConsultaRC> lstPedidosRC = new ArrayList<>();
		Usuario infoUsu = (Usuario) session.getAttribute("infoUsu");
		List<String> lstConsultarTipoCP = new ArrayList<>();
		 lstConsultarTipoCP = gestorPedidos.consultarTipoCP(infoUsu,session,querys);
		lstPedidosRC = gestorPedidos.consultarPedidosRC(infoUsu.getUname(),session,querys,infoUsu,aplicaFormatoFecha(fechaInicio),aplicaFormatoFecha(fechaFin),lstConsultarTipoCP);
		Gson gson = new Gson();
		String listaJSON = gson.toJson(lstPedidosRC);
		EnviarRespuestaJsonJS(request,response,listaJSON);
	}
	
	
	private void consultarPedidos(HttpServletRequest request, HttpServletResponse response, HttpSession session) 
	{
		session.setAttribute("transporte","");
		String ruta = request.getParameter("ruta").toString();
		String fechaInicio = request.getParameter("fechaInicio").toString();
		String fechaFin = request.getParameter("fechaFin").toString();
		session.setAttribute("fechaInicioChofer", aplicaFormatoFecha(fechaInicio));
		session.setAttribute("fechaFinChofer", aplicaFormatoFecha(fechaFin));
		String tipo = request.getParameter("tipo").toString();
		Usuario infoUsu = (Usuario) session.getAttribute("infoUsu");
		String uname = infoUsu.getUname();
		Gson gson = new Gson();
		List<PedidosConsulta> lstPedidos = new ArrayList<>();
		
		lstPedidos = gestorPedidos.consultaPedidos(infoUsu.getUname().toUpperCase(),session.getAttribute("hora").toString(),session,infoUsu.getCve_usuario(),infoUsu.getUname_br(),infoUsu.getDato_alfanumerico(),querys,infoUsu,ruta,tipo,
				aplicaFormatoFecha(fechaFin),aplicaFormatoFecha(fechaInicio));
		String listaJSON = gson.toJson(lstPedidos);
		EnviarRespuestaJsonJS(request,response,listaJSON);		
	} 

	private void consultarPedidosTrans(HttpServletRequest request, HttpServletResponse response, HttpSession session) 
	{
		Usuario infoUsu = (Usuario) session.getAttribute("infoUsu");
		String uname = infoUsu.getUname();
		Gson gson = new Gson();
		String ruta = request.getParameter("ruta").toString();
		String tipo = request.getParameter("tipo").toString();
		String fechaInicio = request.getParameter("fechaInicio").toString();
		String fechaFin = request.getParameter("fechaFin").toString();
		List<PedidosConsulta> lstPedidos = new ArrayList<>();
		
		lstPedidos = gestorPedidos.consultaPedidosTrans(infoUsu.getUname().toUpperCase(),session.getAttribute("hora").toString(),session,infoUsu.getCve_usuario(),infoUsu.getUname_br(),infoUsu.getDato_alfanumerico2(),infoUsu,querys,ruta,tipo,aplicaFormatoFecha(fechaFin),aplicaFormatoFecha(fechaInicio));
		String listaJSON = gson.toJson(lstPedidos);
		EnviarRespuestaJsonJS(request,response,listaJSON);	
	}
	
	private void enviarTraspasoCDO(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		//System.out.println("----ENTRA A SERVLET----"); 	
		Usuario infoUsu = (Usuario) session.getAttribute("infoUsu");
		String pedidosRC = request.getParameter("pedidosRC");
		String vehiculo = request.getParameter("vehiculo");
		String chofer = request.getParameter("chofer");
		String cdoSel= request.getParameter("cdoSel"); 
		String data = request.getParameter("data");
		
//		System.out.println("pedidosRC: " + pedidosRC);
//		System.out.println("vehiculo: " + vehiculo);
//		System.out.println("chofer: " + chofer);
//		System.out.println("cdoSel: " + cdoSel);
//		System.out.println("data: " + data);
		
		String placa = "";
		String cdoDestino = "";
		
		String respuestDetalle = "";
		String respuestaEncabezado = "";
		
		String facturas = "";
		
		if(pedidosRC.contains(",")) {
			String[]splitPedidosRC = pedidosRC.split(",");
			facturas = "";
			for(int i = 0;i<splitPedidosRC.length;i++) {
				if(i == 0) {
					facturas += "'"+splitPedidosRC[i]+"'";
				}else {
					facturas += ",'"+splitPedidosRC[i]+"'";
				}
				
			}
		}else {
			facturas = "'"+pedidosRC+"'";
		}
		
				
		String splitVehiculo [] = vehiculo.split("\\*");
		placa = splitVehiculo[0];
		
		String[] splitCdo = cdoSel.split("-");
		cdoDestino = splitCdo[0];
		
		List<PedidosConsultaRC> lstFacturasDetalle = new ArrayList<>();
		lstFacturasDetalle = gestorPedidos.consultaFacturasDetalleRC(infoUsu, facturas, cdoDestino, querys);
		
		List<PedidosConsultaRC> lstFacturasEncabezado = new ArrayList<>();
		lstFacturasEncabezado = gestorPedidos.consultaFacturasEncabezadoRC(infoUsu, facturas, placa, chofer, cdoDestino, querys);
		
		if(lstFacturasEncabezado.size() != 0) {
			respuestaEncabezado = gestorPedidos.enviaTraspasoEncabezadoRC(lstFacturasEncabezado);
			if(respuestaEncabezado.equals("S")) {
				if(lstFacturasDetalle.size() != 0) {
					for(int i=0;i<lstFacturasDetalle.size();i++) {
						respuestDetalle  = gestorPedidos.enviaTraspasoDetalleRC(lstFacturasDetalle, i);
					}
				}
			}else {
				System.out.println("Servelt. enviarTraspasoCDO. Error al insertar en EncabezadoRC"); 
			}
		}		
		
		Gson gson = new Gson();
		String listaJSON = gson.toJson(data);	
		EnviarRespuestaJsonJS(request,response,listaJSON);
		
	}
	
	
	private String aplicaFormatoFecha(String fechas) {
		String fecha = fechas;
		if (fechas.contains("/")) 
		{
			String[] arrayFecha = fechas.split("/");
			fecha = arrayFecha[2] + "-" + arrayFecha[1] + "-" + arrayFecha[0];
		}
		
		return fecha;
	}

	private void EnviarRespuestaJsonJS(HttpServletRequest request, HttpServletResponse response, String listaJSON) 
	{
		try 
		{
			response.setContentType("application/json");
			PrintWriter out = response.getWriter();
			out.write(listaJSON);
		} catch (Exception e) 
		{
			System.out.println("El error es: "+e);
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doGet(request, response);
	}

}
