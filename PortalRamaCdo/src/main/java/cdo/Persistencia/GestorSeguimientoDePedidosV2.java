package cdo.Persistencia;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Properties;

import org.json.JSONArray;
import org.json.JSONObject;

import cdo.Datos.Articulos;
import cdo.Datos.InfoCliente;
import cdo.Datos.Log;
import cdo.Datos.PedidoCdo;
import cdo.Datos.PedidoCdoDetalle;
import cdo.Datos.PedidosDetallesCdo;
import cdo.Datos.Querys;
import cdo.Datos.SeguimientoPedidosResumen;
import cdo.Util.Cls_Log;
 
import cdo.Util.Cls_Querys;
import cdo.Util.ConexionBD;
import cdo.Util.EjecutaQuerysBD;

public class GestorSeguimientoDePedidosV2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private Client cliente = null;
	private  static Properties properties = null;
	 private  static Properties propertiesWs = null;
 
	 
	 static 
	 {
	      try  
	      {
		      properties = new Properties();
		      InputStream  inputStream  = GestorIniciaSessionV2.class.getClassLoader().getResourceAsStream("/properties/mail.properties");
		      properties.load(inputStream);
		      
		      propertiesWs = new Properties();
		      InputStream  inputStreamWs  = GestorIniciaSessionV2.class.getClassLoader().getResourceAsStream("/properties/configuracion.properties");
		      propertiesWs.load(inputStreamWs);
	      }
	      catch  (Exception ex) 
	      {
	        ex.printStackTrace();
	      }
	 }	
	 
	 @Override
	 public void init() throws ServletException {
	   	super.init();
	   	this.cliente = ClientBuilder.newClient();
	 }
	     
	 @Override
	 public void destroy() {
			this.cliente.close();
			super.destroy();
	 }
	 
	 
	DecimalFormat formatoDecimal = new DecimalFormat("#,###.00");
	public List<SeguimientoPedidosResumen> consultarResumenDePedidos(List<Querys> listaQuerys,InfoCliente infoCliente, String fechaIni,String fechaFin,int numeroPedido)
	{
		List<SeguimientoPedidosResumen> listSeguimientoResumen = new ArrayList<>();
		Connection connBD = null;
		PreparedStatement pstm= null;
		connBD = ConexionBD.abrirConexionBD();
		try
		{
			String[] querys = new String[25];	
			querys = Cls_Querys.LimpiaListaQuerys(querys);
			/* se sustituye  query 24 por query 25*/
			querys = Cls_Querys.ObtieneQuerys(25, listaQuerys, querys);
			querys = inicializaQueryNumero24(querys, infoCliente, fechaIni,fechaFin,numeroPedido);
 
			pstm = connBD.prepareStatement("{call " + "comercio_electronico.usp_EXECUTE_QUERY(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			ResultSet rs=  EjecutaQuerysBD.EjecutarQuery(querys[0], querys[1],querys[2], querys[3], querys[4], querys[5], querys[6],
														 querys[7], querys[8], querys[9],querys[10], querys[11], querys[12], querys[13], 
														 querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], 
														 querys[21], querys[22], querys[23], querys[24], "",pstm, connBD);
			
			 //System.out.println("query 25");
			Cls_Querys.ImprimeQuerysConsola(querys,false,"query 25");
			
			if(rs != null)
			{
				listSeguimientoResumen = llenaClaseResumenPedidos(rs, infoCliente);
			}
			
			Log log=new Log(1,infoCliente.getCve_cdo(),infoCliente.getCve_cliente() ,0, "[Accion: Consulta resumen del historial de pedidos. ]");
			Cls_Log.insertaLog(log);
		}
		catch(Exception ex)
		{
			// System.out.println("[NuevoportalRamaCDO.- Consulta Base de Datos resumen del historial de pedidos no disponible,  Clase: GestorSeguimientoDePedidosV2,  Detalle: " + ex.getMessage().toString() +"]");
			Log log=new Log(1,infoCliente.getCve_cdo(),infoCliente.getCve_cliente() ,0, "[Error: Consulta resumen del historial de pedidos,  Clase: GestorSeguimientoDePedidosV2,  Detalle: " + ex.getMessage().toString() +"]");
			Cls_Log.insertaLog(log);
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
		finally 
		{
			try {pstm.close();} catch (SQLException e) { }
			try {connBD.close();} catch (SQLException e) { }
		}
		return listSeguimientoResumen;
	}
		
	private List<SeguimientoPedidosResumen> llenaClaseResumenPedidos(ResultSet rs, InfoCliente infoCliente)
	{
		List<SeguimientoPedidosResumen> listSeguimientoResumen = new ArrayList<>();
		try
		{
			GestorPedidoMayorista pedMay = new GestorPedidoMayorista();
			pedMay.init();
			while(rs.next())
			{
				SeguimientoPedidosResumen resumen = new SeguimientoPedidosResumen();
				resumen.setCantPedida(rs.getInt("cantPedida"));
				resumen.setCantSurtida(rs.getInt("cantSurtida"));
				resumen.setCveEstatusBr(rs.getInt("cveEstatusBr"));
				resumen.setCveEstatusCdo(rs.getInt("cveEstatusCdo"));
				// resumen.setEstatusBr(rs.getString("EstatusBr"));
				resumen.setEstatusCdo(rs.getString("EstatusCdo"));
				resumen.setFecha(rs.getString("fecha"));
				resumen.setHora(rs.getString("hora"));
				resumen.setImporteFacturado(formatoDecimal.format(Double.parseDouble(rs.getString("importeFacturado"))));
				resumen.setImportePedido(formatoDecimal.format(Double.parseDouble(rs.getString("importePedido"))));
				resumen.setPedido(rs.getInt("pedido"));
				resumen.setPedMayBr(rs.getInt("PedMayBr"));
				resumen.setPedMayCdo(rs.getInt("PedMayCdo"));
				resumen.setPed72Hrs(rs.getString("pedidos_72hrs"));
				resumen.setPed72HrsDescrip(rs.getString("pedidos_72hrsDescrip"));
				
				resumen.setEstatusEntrega("");
				resumen.setTransporte("");
				resumen.setImgEntrega("EstCapturado.png");
				
				if ( resumen.getPedido() > 0 )
				{
					
					resumen = pedMay.consultaPedidoMayWs(infoCliente.getCentro(), infoCliente.getCve_cliente(), resumen.getPedMayCdo(), resumen);
				
					//  System.out.println("nuevo resumen: " + resumen);
				}
				
				listSeguimientoResumen.add(resumen);
			}
			pedMay.destroy();
		}
		catch(Exception ex)
		{
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
			
			//System.out.println("[Error: Llena clase resumen del historial de pedidos,  Clase: GestorSeguimientoDePedidosV2,  Detalle: " + ex.getMessage().toString() +"]");
			Log log=new Log(1,infoCliente.getCve_cdo(),infoCliente.getCve_cliente() ,0, "[NuevoportalRamaCDO .- Error: Consulta resumen del historial de pedidos,  Clase: GestorSeguimientoDePedidosV2.llenaClaseResumenPedidos,  Detalle: " + ex.getMessage().toString() +"]");
			Cls_Log.insertaLog(log);
		}
		
		return listSeguimientoResumen;
	}
	
	/******   INICIALIZA QUERYS    ******/	
	private String[] inicializaQueryNumero24(String[] ListaQuerys, InfoCliente infocte,String fechaIni,String fechaFin,int numeroPedido ) 
	{
		if(!fechaIni.equals("NA"))
		{
			fechaIni = formatearFecha(fechaIni);
			fechaFin = formatearFecha(fechaFin);
		}
			
		String fechas = (fechaIni.equals("NA")) ? "" : " AND  hp.ped_fecha >= '" +  fechaIni  + "' AND hp.ped_fecha <= '" + fechaFin + "' " ;		
		String numPedido = (numeroPedido <= 0) ? "" : " AND hp.cve_pedido IN (" + numeroPedido + ") ";		
		for (int i=0;i <ListaQuerys.length; i++)
		{
			ListaQuerys[i]= ListaQuerys[i].replace("{CVE_CENTRO}",String.valueOf(infocte.getCentro()));
			ListaQuerys[i]= ListaQuerys[i].replace("{CVE_CLIENTE}", String.valueOf(infocte.getCve_cliente()));		
			ListaQuerys[i]= ListaQuerys[i].replace("{FECHAS}", fechas);
			ListaQuerys[i]= ListaQuerys[i].replace("{NUMERO_PEDIDO}", numPedido);			
		}
		return ListaQuerys;
	}
		
	private String formatearFecha(String fecha)
	{
		String arrayFecha[] = fecha.split("/"); 
		String fechaConFormato = arrayFecha[2] + "-" + arrayFecha[1] + "-" + arrayFecha[0];
		return fechaConFormato;
	}
	
	
	public List<PedidoCdo>  ConsultaPedidosClienteOtros(InfoCliente infoCliente, String pedidos,List<Querys> listaQuerys,String PedidoWWW)
	{
		 
		List<PedidoCdo> ListapedidosWS = null;
		 
		try {
			ListapedidosWS =  ConsultaPedidoWS(infoCliente, pedidos, listaQuerys, PedidoWWW);
			 
		}
	
	catch(Exception ex)
	{
		//System.out.println("[NuevoportalRamaCDO.- Error: Consulta Pedido Cliente,  Clase: GestorSeguimientoDePedidosV2.ConsultaPedidosCliente,  Detalle: " + ex.getMessage().toString() +"]");
		Log log=new Log(1,infoCliente.getCve_cdo(),infoCliente.getCve_cliente() ,0, "[Error: Consulta resumen del historial de pedidos,  Clase: GestorSeguimientoDePedidosV2.ConsultaPedidoWS,  Detalle: " + ex.getMessage().toString() +"]");
		Cls_Log.insertaLog(log);
	}
		return  ListapedidosWS;
	}
	
	
	/*** Consulta al detalle del pedido ***/
	public List<PedidosDetallesCdo>  ConsultaPedidosCliente(InfoCliente infoCliente, String pedidos,List<Querys> listaQuerys,String PedidoWWW)
	{
		List<PedidosDetallesCdo> ListapedidosCompleta = null;
		List<PedidoCdo> ListapedidosWS = null;
		List<PedidoCdo> ListapedidosBD = null;
		try {
			ListapedidosWS =  ConsultaPedidoWS(infoCliente, pedidos, listaQuerys, PedidoWWW);
			ListapedidosBD =LlenaListaPedidosdesdeTablasWWW(infoCliente,listaQuerys,PedidoWWW);
			
			ListapedidosCompleta = GeneraListaDePEdidosCompletaV2(infoCliente,ListapedidosWS, ListapedidosBD);
			
		
		}
	
	catch(Exception ex)
	{
		//System.out.println("[NuevoportalRamaCDO.- Error: Consulta Pedido Cliente,  Clase: GestorSeguimientoDePedidosV2.ConsultaPedidosCliente,  Detalle: " + ex.getMessage().toString() +"]");
		Log log=new Log(1,infoCliente.getCve_cdo(),infoCliente.getCve_cliente() ,0, "[Error: Consulta resumen del historial de pedidos,  Clase: GestorSeguimientoDePedidosV2.ConsultaPedidoWS,  Detalle: " + ex.getMessage().toString() +"]");
		Cls_Log.insertaLog(log);
	}
		return  ListapedidosCompleta;
	}

	
	private List<PedidoCdo> GeneraListaDePEdidosCompleta(InfoCliente infoCliente,List<PedidoCdo> listapedidosWS,
			List<PedidoCdo> listapedidosBD) {
		List<PedidoCdo> ListapedidosCompleta  =  new ArrayList<PedidoCdo>();
	 try
	 {
		 	 
				procesaRenglones(infoCliente, listapedidosBD, listapedidosWS);
	 
		PedidoCdo ped = new PedidoCdo();
		ped.setDetallePedidoCdo(listapedidosBD.get(0).getDetallePedidoCdo() );
	 ListapedidosCompleta.add(ped);;
	}
	catch (Exception ex) {
		Log log=new Log(1,infoCliente.getCve_cdo(),infoCliente.getCve_cliente() ,0, "[Error: Al generar la lista completa del pedido Clase: GestorSeguimientoDePedidosV2.GeneraListaDePEdidosCompleta,  Detalle: " + ex.getMessage().toString() +"]");
		Cls_Log.insertaLog(log);
	}
		return ListapedidosCompleta;
	}

	/*Metodo Anterior 2022-04-25*/
	private List<PedidoCdo> ConsultaPedidoWS(InfoCliente infoCliente, String pedidos, List<Querys> listaQuerys,
			String PedidoWWW) {
		List<PedidoCdo> Listapedidos = null;
		
		JSONObject rs = null;	 
		try
		{
			init();
			 	
			String respuestaJsonString = this.cliente.target(propertiesWs.getProperty("URL_WS_ESTATUS_PEDIDO")  + "?cveCentro=" + infoCliente.getCentro() + "&cliente=" +infoCliente.getCve_cliente() + "&pedidos=" + pedidos)
			.request(MediaType.APPLICATION_JSON).get(String.class);	
			
	// System.out.println(propertiesWs.getProperty("URL_WS_ESTATUS_PEDIDO")  + "?cveCentro=" + infoCliente.getCentro() + "&cliente=" +infoCliente.getCve_cliente() + "&pedidos=" + pedidos);
			rs = new JSONObject(respuestaJsonString);		
		
	 				 if( rs.getInt("registros") > 0  )
	 				 {
	 					if(ValidaEstatusPdidos(infoCliente, rs))
	 					{
  	 				  		Listapedidos = LlenaListaPedidos(infoCliente, rs);
	 					}
	 					else
	 					{
	 						Listapedidos = LlenaListaPedidosdesdeTablasWWW(infoCliente,listaQuerys,PedidoWWW);
	 					}
	 				 }else
	 				 {
	 				   Listapedidos = LlenaListaPedidosdesdeTablasWWW(infoCliente,listaQuerys,PedidoWWW);
	 				 }
			
		 
			
	 				 destroy();
		}
		catch(Exception ex)
		{
			//System.out.println("[NuevoportalRamaCDO.- Error: Consulta Pedido Cliente,  Clase: GestorSeguimientoDePedidosV2.ConsultaPedidosCliente,  Detalle: " + ex.getMessage().toString() +"]");
			Log log=new Log(1,infoCliente.getCve_cdo(),infoCliente.getCve_cliente() ,0, "[Error: Consulta resumen del historial de pedidos,  Clase: GestorSeguimientoDePedidosV2.ConsultaPedidoWS,  Detalle: " + ex.getMessage().toString() +"]");
			Cls_Log.insertaLog(log);
			 destroy();
		}
	 
		return Listapedidos;
	}
	
	private List<PedidoCdoDetalle> ConsultaPedidoDetalleWS(InfoCliente infoCliente, String pedidos, List<Querys> listaQuerys,
			String PedidoWWW) {
		List<PedidoCdoDetalle> Listapedidos = null;
		Response respuestaJsonString = null;
		JSONObject rs = null;	 
		try
		{
			init();
			//System.out.println("Consulta Pedido: " +  propertiesWs.getProperty("URL_WS_ESTATUS_PEDIDO")  + "?cveCentro=" + infoCliente.getCentro() + "&cliente=" +infoCliente.getCve_cliente() + "&pedidos=" + pedidos);
			
			 respuestaJsonString = this.cliente.target(propertiesWs.getProperty("URL_WS_ESTATUS_PEDIDO")  + "?cveCentro=" + infoCliente.getCentro() + "&cliente=" +infoCliente.getCve_cliente() + "&pedidos=" + pedidos)
			.request(MediaType.APPLICATION_JSON).get();		
			rs = new JSONObject(respuestaJsonString);		
		
			//System.out.println(propertiesWs.getProperty("URL_WS_ESTATUS_PEDIDO")  + "?cveCentro=" + infoCliente.getCentro() + "&cliente=" +infoCliente.getCve_cliente() + "&pedidos=" + pedidos);
	 			
  	 		 Listapedidos = LlenaListaPedidosDetalle(infoCliente, rs);
			
	 		destroy();
		}
		catch(Exception ex)
		{
			//System.out.println("[NuevoportalRamaCDO.- Error: Consulta Pedido Cliente,  Clase: GestorSeguimientoDePedidosV2.ConsultaPedidosCliente,  Detalle: " + ex.getMessage().toString() +"]");
			
			Log log=new Log(01,infoCliente.getCve_cdo(),infoCliente.getCve_cliente() ,0, "URL_WS_ESTATUS_PEDIDO, Error al valiar conexion con BD CDO,  Clase: GestorSeguimientoDePedidosV2, Metodo: ConsultaPedidoDetalleWS, "+
					" Url: "+ properties.getProperty("URL_WS_ESTATUS_PEDIDO")  + "?cveCentro=" + infoCliente.getCentro() + "&cliente=" +infoCliente.getCve_cliente() + "&pedidos=" + pedidos +
					". Estatus: " + respuestaJsonString.getStatus() + " - " + respuestaJsonString.getStatusInfo());
		Cls_Log.insertaLog(log);
			

			 destroy();
		}
	 
		return Listapedidos;
	}
	
	
	
 
	private List<PedidoCdo> LlenaListaPedidosdesdeTablasWWW(InfoCliente infoCliente, List<Querys> listaQuerys, String numeroPedidoWWW) {
		List<PedidoCdo> listaPedidos =  new ArrayList<PedidoCdo>();
		Connection connBD = null;
		PreparedStatement pstm= null;
		connBD = ConexionBD.abrirConexionBD();
		try
		{
			String[] querys = new String[25];	
			querys = Cls_Querys.LimpiaListaQuerys(querys);
			/* se sustituye  query 41*/
			querys = Cls_Querys.ObtieneQuerys(41, listaQuerys, querys);
			querys = inicializaQueryNumero41(querys, infoCliente, numeroPedidoWWW);
 
			pstm = connBD.prepareStatement("{call " + "comercio_electronico.usp_EXECUTE_QUERY(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			ResultSet rs=  EjecutaQuerysBD.EjecutarQuery(querys[0], querys[1],querys[2], querys[3], querys[4], querys[5], querys[6],
														 querys[7], querys[8], querys[9],querys[10], querys[11], querys[12], querys[13], 
														 querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], 
														 querys[21], querys[22], querys[23], querys[24], "",pstm, connBD);
			
			//System.out.println("query 41");
			Cls_Querys.ImprimeQuerysConsola(querys,false,"Query 41");

			
			if(rs != null)
			{
				while(rs.next())
				{
				PedidoCdo pCdo = new PedidoCdo();
				pCdo.setNumPedido(Integer.parseInt(rs.getString("num_pedido")));
				pCdo.setEstatus( rs.getString("estatus"));
				pCdo.setDescripcionEstatus(rs.getString("descripcion_estatus"));
				pCdo.setUname(rs.getString("uname"));
				pCdo.setDescripcionUname(rs.getString("descripcion_uname"));
				pCdo.setFechaPedido(rs.getString("fecha_pedido"));
				pCdo.setTipo("M");
				pCdo.setDetallePedidoCdo( GeneraCortePorFacturaDesdeTablasWWW( infoCliente, listaQuerys,numeroPedidoWWW )); 
				
				listaPedidos.add(pCdo);
				}
			}
			
			Log log=new Log(1,infoCliente.getCve_cdo(),infoCliente.getCve_cliente() ,0, "[Accion: Consulta resumen del historial de pedidos. ]");
			Cls_Log.insertaLog(log);
		}
		catch(Exception ex)
		{
			System.out.println("[NuevoportalRamaCDO.- Error: Consulta resumen del historial de pedidos,  Clase: GestorSeguimientoDePedidosV2,  Detalle: " + ex.getMessage().toString() +"]");
			Log log=new Log(1,infoCliente.getCve_cdo(),infoCliente.getCve_cliente() ,0, "[Error: Consulta resumen del historial de pedidos,  Clase: GestorSeguimientoDePedidosV2,  Detalle: " + ex.getMessage().toString() +"]");
			Cls_Log.insertaLog(log);
		}
		finally 
		{
			try {pstm.close();} catch (SQLException e) {e.printStackTrace();}
			try {connBD.close();} catch (SQLException e) {e.printStackTrace();}
		}
		return listaPedidos;
	}

	private List<PedidoCdoDetalle> GeneraCortePorFacturaDesdeTablasWWW(InfoCliente infoCliente,
			List<Querys> listaQuerys, String numeroPedidoWWW) {
		 List<PedidoCdoDetalle> listaDetalle = new ArrayList<PedidoCdoDetalle>();
		Connection connBD = null;
		PreparedStatement pstm= null;
		connBD = ConexionBD.abrirConexionBD();
		try
		{
			String[] querys = new String[25];	
			querys = Cls_Querys.LimpiaListaQuerys(querys);
		 
			/*Query 57 Sustituye al query 42*/
			querys = Cls_Querys.ObtieneQuerys(57, listaQuerys, querys);
			querys = inicializaQueryNumero42(querys, infoCliente, numeroPedidoWWW);
 
			pstm = connBD.prepareStatement("{call " + "comercio_electronico.usp_EXECUTE_QUERY(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			ResultSet rs=  EjecutaQuerysBD.EjecutarQuery(querys[0], querys[1],querys[2], querys[3], querys[4], querys[5], querys[6],
														 querys[7], querys[8], querys[9],querys[10], querys[11], querys[12], querys[13], 
														 querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], 
														 querys[21], querys[22], querys[23], querys[24], "",pstm, connBD);
			
			//System.out.println("query 42");
			Cls_Querys.ImprimeQuerysConsola(querys,false,"Query 57");

			int renglon = 1;
			if(rs != null)
			{
				while(rs.next())
				{
					 PedidoCdoDetalle pCdoD = new PedidoCdoDetalle();
					 pCdoD.setRenglon(renglon);
					 pCdoD.setNumArt(rs.getString("art_numart_cdo"));
					 pCdoD.setDescripcion(rs.getString("nombreArticulo"));
					 pCdoD.setCveUnidad( " ");
					 pCdoD.setCantPedida(rs.getInt("ped_cant_p"));
					 pCdoD.setCantSurt(rs.getInt("ped_cant_surtida_cdo"));
					 pCdoD.setCant72Hrs(rs.getInt("ped_cant_72"));
				     pCdoD.setPrecioUni(formatoDecimal.format(rs.getDouble("ped_precio")));
				     pCdoD.setImporte(formatoDecimal.format(rs.getDouble("importe")));
			         pCdoD.setFactura(rs.getString("factura"));
		             pCdoD.setImporteFac(formatoDecimal.format(rs.getDouble("importe_factura")));
		             pCdoD.setDescuentosFac(formatoDecimal.format(rs.getDouble("descuento")));
		             pCdoD.setSubtotalFac(formatoDecimal.format(rs.getDouble("descuento")));
		             pCdoD.setIvaFac(formatoDecimal.format(rs.getDouble("iva")));
		             pCdoD.setTotalFAc(formatoDecimal.format(rs.getDouble("total_fac")));
		             pCdoD.setCdoTraspaso(generaNombreCDOTraspaso(rs.getString("cdo_traspaso")) );
		             pCdoD.setCveUnidad(rs.getString("cve_unidad") );
		        //     System.out.println(pCdoD);
		            
				     listaDetalle.add(pCdoD);
				     renglon ++;
				}
			}
			
			Log log=new Log(1,infoCliente.getCve_cdo(),infoCliente.getCve_cliente() ,0, "[Accion: Consulta resumen del historial de pedidos. ]");
			Cls_Log.insertaLog(log);
		}
		catch(Exception ex)
		{
			// System.out.println("[NuevoportalRamaCDO.- Error: Consulta resumen del historial de pedidos,  Clase: GestorSeguimientoDePedidosV2,  Detalle: " + ex.getMessage().toString() +"]");
			Log log=new Log(1,infoCliente.getCve_cdo(),infoCliente.getCve_cliente() ,0, "[Error: Consulta resumen del historial de pedidos,  Clase: GestorSeguimientoDePedidosV2,  Detalle: " + ex.getMessage().toString() +"]");
			Cls_Log.insertaLog(log);
		}
		finally 
		{
			try {pstm.close();} catch (SQLException e) {e.printStackTrace();}
			try {connBD.close();} catch (SQLException e) {e.printStackTrace();}
		}
		return listaDetalle;
	}


	private String generaNombreCDOTraspaso(String cdoTraspaso) {
		String NombreCdoTraspaso = "";
		try
		{
		switch (cdoTraspaso.toUpperCase()) {
		case "CDF":
			NombreCdoTraspaso = "CDMX";
			break;
		case "CD2":
			NombreCdoTraspaso  = "Puebla";
			break;
		case "CDL":
			NombreCdoTraspaso  = "Leon";
			break;
		case "CDM":
			NombreCdoTraspaso  = "Mty";
			break;
		default:
			NombreCdoTraspaso  = "";
			break;
		}
		}
		catch (Exception e) {
			NombreCdoTraspaso  = "";
		}
		return NombreCdoTraspaso;
	}

	private String[] inicializaQueryNumero41(String[] ListaQuerys, InfoCliente infoCliente, String numeroPedidoWWW) {
		for (int i=0;i <ListaQuerys.length; i++)
		{
			ListaQuerys[i]= ListaQuerys[i].replace("{CENTRO}",String.valueOf(infoCliente.getCentro()));
			ListaQuerys[i]= ListaQuerys[i].replace("{CLIENTE}", String.valueOf(infoCliente.getCve_cliente()));		
 			ListaQuerys[i]= ListaQuerys[i].replace("{PEDIDO}", numeroPedidoWWW);			
		}
		return ListaQuerys;

	}

	private String[] inicializaQueryNumero42(String[] ListaQuerys, InfoCliente infoCliente, String numeroPedidoWWW) {
		for (int i=0;i <ListaQuerys.length; i++)
		{
			ListaQuerys[i]= ListaQuerys[i].replace("{CENTRO}",String.valueOf(infoCliente.getCentro()));
			ListaQuerys[i]= ListaQuerys[i].replace("{CLIENTE}", String.valueOf(infoCliente.getCve_cliente()));		
 			ListaQuerys[i]= ListaQuerys[i].replace("{PEDIDO}", numeroPedidoWWW);			
		}
		return ListaQuerys;
	}

	private boolean ValidaEstatusPdidos(InfoCliente infoCliente, JSONObject jsonPedidoCliente) {
		boolean pedidosCorrectos =false;
		try {
     		JSONArray jsonArrayPedidos = new JSONArray(jsonPedidoCliente.getJSONArray("datos").toString());
 
     		for (int i = 0; i < jsonArrayPedidos.length(); i++) {
	
     			JSONObject rs = jsonArrayPedidos.getJSONObject(i);
					if (!rs.getString("status").equalsIgnoreCase("EstSinExistencia.png"))
					{
						pedidosCorrectos = true;
						return pedidosCorrectos;
					}
     		}
		}
		catch(Exception ex)
		{
			System.out.println("[NuevoportalRamaCDO.- Error: ValidaEstatusPdidos,  Clase: GestorSeguimientoDePedidosV2,  Detalle: " + ex.getMessage().toString() +"]");
			Log log=new Log(1,infoCliente.getCve_cdo(),infoCliente.getCve_cliente() ,0, "[Error: Consulta resumen del historial de pedidos,  Clase: GestorSeguimientoDePedidosV2,  Detalle: " + ex.getMessage().toString() +"]");
			Cls_Log.insertaLog(log);

		}
		//System.out.println("ValidaEstatusPdidos: " + pedidosCorrectos);
		return pedidosCorrectos;
	}

	/*Metodo Anterior 2022-04-25*/
	private List<PedidoCdo> LlenaListaPedidos(InfoCliente infoCliente, JSONObject jsonPedidoCliente) {
		List<PedidoCdo> listaPedidos =  new ArrayList<PedidoCdo>();
		try {
     		JSONArray jsonArrayPedidos = new JSONArray(jsonPedidoCliente.getJSONArray("datos").toString());
 
     		for (int i = 0; i < jsonArrayPedidos.length(); i++) {
	
				JSONObject rs = jsonArrayPedidos.getJSONObject(i);
				
				
				PedidoCdo pCdo = new PedidoCdo();
				
				if (!rs.getString("pedido").equalsIgnoreCase(""))
				{
				pCdo.setNumPedido(Integer.parseInt(rs.getString("pedido")));
				pCdo.setEstatus( rs.getString("status"));
				pCdo.setDescripcionEstatus(rs.getString("descripcionEstatus"));
				pCdo.setUname(rs.getString("uname"));
				pCdo.setDescripcionUname(rs.getString("descripcionUname"));
				pCdo.setTipo(rs.getString("tipo"));
	
				pCdo.setDetallePedidoCdo( GeneraCortePorFactura( infoCliente, rs.getJSONArray("detalle"))); 
				
				listaPedidos.add(pCdo);
				}
     		}
		}
		catch(Exception ex)
		{
			 System.out.println("[NuevoportalRamaCDO.- Error: Consulta Pedido Cliente(LlenaListaPedidos) Metodo Anterior,  Clase: GestorSeguimientoDePedidosV2,  Detalle: " + ex.getMessage().toString() +"]");
			Log log=new Log(1,infoCliente.getCve_cdo(),infoCliente.getCve_cliente() ,0, "[Error: Consulta resumen del historial de pedidos,  Clase: GestorSeguimientoDePedidosV2.LlenaListaPedidos,  Detalle: " + ex.getMessage().toString() +"]");
			Cls_Log.insertaLog(log);

		}
		return listaPedidos;
	}
	

	private List<PedidoCdoDetalle> LlenaListaPedidosDetalle(InfoCliente infoCliente, JSONObject jsonPedidoCliente) {
		List<PedidoCdo> listaPedidos =  new ArrayList<PedidoCdo>();
		PedidoCdo pCdo = new PedidoCdo();
		try {
     		JSONArray jsonArrayPedidos = new JSONArray(jsonPedidoCliente.getJSONArray("datos").toString());
 
     		for (int i = 0; i < jsonArrayPedidos.length(); i++) {
	
				JSONObject rs = jsonArrayPedidos.getJSONObject(i);

				pCdo.setNumPedido(Integer.parseInt(rs.getString("pedido")));
				pCdo.setEstatus( rs.getString("status"));
				pCdo.setDescripcionEstatus(rs.getString("descripcionEstatus"));
				pCdo.setUname(rs.getString("uname"));
				pCdo.setDescripcionUname(rs.getString("descripcionUname"));
				pCdo.setTipo(rs.getString("tipo"));
	
				pCdo.setDetallePedidoCdo( GeneraCortePorFactura( infoCliente, rs.getJSONArray("detalle"))); 
				
				listaPedidos.add(pCdo);
     		}
		}
		catch(Exception ex)
		{
			System.out.println("[NuevoportalRamaCDO.- Error: Consulta Pedido Cliente(LlenaListaPedidos),  Clase: GestorSeguimientoDePedidosV2,  Detalle: " + ex.getMessage().toString() +"]");
			Log log=new Log(1,infoCliente.getCve_cdo(),infoCliente.getCve_cliente() ,0, "[Error: Consulta resumen del historial de pedidos,  Clase: GestorSeguimientoDePedidosV2,  Detalle: " + ex.getMessage().toString() +"]");
			Cls_Log.insertaLog(log);

		}
		return pCdo.getDetallePedidoCdo();
	}
	
	

private List<PedidoCdoDetalle> GeneraCortePorFactura(InfoCliente infoCliente, JSONArray jsonArray) {
	  
	 
	 List<PedidoCdoDetalle> listaDetalle = new ArrayList<PedidoCdoDetalle>();
 
	 try {   
		 for (int i = 0; i < jsonArray.length(); i++) {
 
			 JSONObject rs = jsonArray.getJSONObject(i);
			 
			 PedidoCdoDetalle pCdoD = new PedidoCdoDetalle();
			 pCdoD.setRenglon(rs.getInt("renglon"));
			 pCdoD.setNumArt(rs.getString("numArt"));
			 pCdoD.setDescripcion(rs.getString("descripcion"));
			 pCdoD.setCveUnidad(rs.getString("cveUnidad"));
			 pCdoD.setCantPedida(rs.getInt("cantPedida"));
			 pCdoD.setCantSurt(rs.getInt("cantSurt"));
		     pCdoD.setPrecioUni(formatoDecimal.format(rs.getDouble("precioUni")));
		     pCdoD.setImporte(formatoDecimal.format(rs.getDouble("importe")));
	         pCdoD.setFactura(rs.getString("num_fac"));
             pCdoD.setImporteFac(formatoDecimal.format(rs.getDouble("importeFac")));
             pCdoD.setDescuentosFac(formatoDecimal.format(rs.getDouble("descuentosFac")));
             pCdoD.setSubtotalFac(formatoDecimal.format(rs.getDouble("subtotalFac")));
             pCdoD.setIvaFac(formatoDecimal.format(rs.getDouble("ivaFac")));
             pCdoD.setTotalFAc(formatoDecimal.format(rs.getDouble("totalFac")));
             
		     listaDetalle.add(pCdoD);

		  
		  
		 }
	 }
	 catch(Exception ex)
		{
			System.out.println("[NuevoportalRamaCDO.- Error: Consulta Pedido Cliente(GeneraCortePorFactura),  Clase: GestorSeguimientoDePedidosV2,  Detalle: " + ex.getMessage().toString() +"]");
			Log log=new Log(1,infoCliente.getCve_cdo(),infoCliente.getCve_cliente() ,0, "[Error: Consulta resumen del historial de pedidos,  Clase: GestorSeguimientoDePedidosV2,  Detalle: " + ex.getMessage().toString() +"]");
			Cls_Log.insertaLog(log);
		}
	return listaDetalle;
}

/*Nuevos metodos para la consulta del detalle de los pedidos*/
private List<PedidosDetallesCdo> GeneraListaDePEdidosCompletaV2(InfoCliente infoCliente,List<PedidoCdo> listapedidosWS,
		List<PedidoCdo> listapedidosBD) {
	List<PedidosDetallesCdo> ListapedidosCompleta  =  new ArrayList<PedidosDetallesCdo>();
 try
 {
		PedidosDetallesCdo ped = new PedidosDetallesCdo();
	 List<PedidoCdo> listaPedido =  new ArrayList<PedidoCdo>();
	 
	 listaPedido.add(listapedidosBD.get(0));
		
	 ped.setPedidoCdo(procesaPedidos(listaPedido, listapedidosWS));
	 
	procesaRenglones(infoCliente, listapedidosBD, listapedidosWS);
	ped.setDetallePedidoCdo(listapedidosBD.get(0).getDetallePedidoCdo() );
	
    ListapedidosCompleta.add(ped);

}
catch (Exception ex) {
	Log log=new Log(1,infoCliente.getCve_cdo(),infoCliente.getCve_cliente() ,0, "[Error: Al generar la lista completa del pedido Clase: GestorSeguimientoDePedidosV2.GeneraListaDePEdidosCompleta,  Detalle: " + ex.getMessage().toString() +"]");
	Cls_Log.insertaLog(log);
}
	return ListapedidosCompleta;
}

	private void procesaRenglones(InfoCliente infoCliente, List<PedidoCdo> listapedidosBD,
			List<PedidoCdo> listapedidosWS) {
		try {
			for (PedidoCdo ped : listapedidosWS) {

				for (PedidoCdoDetalle DetPed : ped.getDetallePedidoCdo()) {

					listapedidosBD = registraElementoDetalle(infoCliente, listapedidosBD, DetPed, ped.getNumPedido());
				}
			}
		} catch (Exception ex) {
			Log log = new Log(1, infoCliente.getCve_cdo(), infoCliente.getCve_cliente(), 0,
					"[Error: Al generar la lista completa del pedido Clase: GestorSeguimientoDePedidosV2.procesaRenglones,  Detalle: "
							+ ex.getMessage().toString() + "]");
			Cls_Log.insertaLog(log);
		}
	}
	
	
	private List<PedidoCdo> procesaPedidos(List<PedidoCdo> listaPedido, List<PedidoCdo> listapedidosWS) {
		
		List<PedidoCdo> ListaPedidosProcesados = new ArrayList<PedidoCdo>();
		PedidoCdo pedidoBd = new PedidoCdo();
		pedidoBd = listaPedido.get(0);
	 
		for (PedidoCdo ped : listapedidosWS) {
		//System.out.println("pedidoBd.getNumPedido: " +  pedidoBd.getNumPedido() +"ped.getNumPedido: " + ped.getNumPedido());
			if ( pedidoBd.getNumPedido() == ped.getNumPedido() )
			{
				PedidoCdo pedidoBD = new PedidoCdo();
				pedidoBD.setNumPedido(ped.getNumPedido());
				pedidoBD.setEstatus(ped.getEstatus());
				pedidoBD.setDescripcionEstatus(ped.getDescripcionEstatus());
				pedidoBD.setDescripcionUname(ped.getDescripcionUname());
				pedidoBD.setUname(ped.getUname());
				pedidoBD.setFechaPedido(ped.getFechaPedido());
				pedidoBD.setTipo(ped.getTipo());
				ListaPedidosProcesados.add(pedidoBD);
			}else
			{
				PedidoCdo pedidoWs = new PedidoCdo();
				pedidoWs.setNumPedido(ped.getNumPedido());
				pedidoWs.setEstatus(ped.getEstatus());
				pedidoWs.setDescripcionEstatus(ped.getDescripcionEstatus());
				pedidoWs.setDescripcionUname(ped.getDescripcionUname());
				pedidoWs.setUname(ped.getUname());
				pedidoWs.setFechaPedido(ped.getFechaPedido());
				pedidoWs.setTipo(ped.getTipo());
				ListaPedidosProcesados.add(pedidoWs);
				//System.out.println("pedidoWs: " + pedidoWs);
			}
			
		}
		//System.out.println("lista pedidos generada: " + ListaPedidosProcesados);
	return ListaPedidosProcesados;
}
	

	private List<PedidoCdo> registraElementoDetalle(InfoCliente infoCliente, List<PedidoCdo> listapedidosBD,
			PedidoCdoDetalle detPed, int numPedidoEnWS) {

		List<PedidoCdoDetalle> detallePedidoCdo = listapedidosBD.get(0).getDetallePedidoCdo();
		try {
			String CdoTraspsoAuxiliar = "";
			int CantidadTraspso = 0;
			for (PedidoCdoDetalle pCdoD : detallePedidoCdo) {

				CdoTraspsoAuxiliar = pCdoD.getCdoTraspaso();
				CantidadTraspso = detPed.getCantPedida();
			//	System.out.println("pedido: " + numPedidoEnWS);
			//	System.out.println( pCdoD.getNumArt()+ " == " +detPed.getNumArt());
				if (pCdoD.getNumArt().trim().equalsIgnoreCase(detPed.getNumArt().trim())) {
					
					 pCdoD.setDescripcion(detPed.getDescripcion());
					
					
					if (pCdoD.getCantSurt() == detPed.getCantPedida())
					{
						pCdoD.setCveUnidad(detPed.getCveUnidad());
					 
		
						pCdoD.setFactura(detPed.getFactura());
						pCdoD.setCveUnidad(detPed.getCveUnidad());
						pCdoD.setSubtotalFac(detPed.getSubtotalFac());
						pCdoD.setIvaFac(detPed.getIvaFac());
						pCdoD.setTotalFAc(detPed.getTotalFAc());
					}
					else if(pCdoD.getCant72Hrs() == detPed.getCantPedida())
					{
						 
						pCdoD.setCantSurt(detPed.getCantSurt());
						pCdoD.setFactura(detPed.getFactura());
						pCdoD.setCveUnidad(detPed.getCveUnidad());
						pCdoD.setSubtotalFac(detPed.getSubtotalFac());
						pCdoD.setIvaFac(detPed.getIvaFac());
						pCdoD.setTotalFAc(detPed.getTotalFAc());
					}
					 
				}
			}

			detallePedidoCdo.sort(Comparator.comparing(PedidoCdoDetalle::getNumArt));
			
			
		} catch (Exception ex) {
			// System.out.println("registraElementoDetalle: " + ex);
			Log log = new Log(1, infoCliente.getCve_cdo(), infoCliente.getCve_cliente(), 0,
					"[Error: Al generar la lista completa del pedido Clase: GestorSeguimientoDePedidosV2.registraElementoDetalle,  Detalle: "
							+ ex.getMessage().toString() + "]");
			Cls_Log.insertaLog(log);
		}
		return listapedidosBD;
	}
	
	
}
