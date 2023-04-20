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
 
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.json.JSONArray;
import org.json.JSONObject;
 

import cdo.Datos.InfoCliente;
import cdo.Datos.Log;
import cdo.Datos.PedidoCdo;
import cdo.Datos.PedidoCdoDetalle;
import cdo.Datos.PedidoCdoFacturas;
import cdo.Datos.Querys;
import cdo.Datos.SeguimientoPedidosResumen;
import cdo.Util.Cls_Log;
import cdo.Util.Cls_MetodosGlobales;
import cdo.Util.Cls_Querys;
import cdo.Util.ConexionBD;
import cdo.Util.EjecutaQuerysBD;

public class GestorSeguimientoDePedidos {
	
	private  static Properties properties = null;
	 private  static Properties propertiesWs = null;
 
	 
	 static 
	 {
	      try  
	      {
		      properties = new Properties();
		      InputStream  inputStream  = GestorIniciaSession.class.getClassLoader().getResourceAsStream("/properties/mail.properties");
		      properties.load(inputStream);
		      
		      propertiesWs = new Properties();
		      InputStream  inputStreamWs  = GestorIniciaSession.class.getClassLoader().getResourceAsStream("/properties/configuracion.properties");
		      propertiesWs.load(inputStreamWs);
	      }
	      catch  (Exception ex) 
	      {
	        ex.printStackTrace();
	      }
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
			
			//System.out.println("[NuevoportalRamaCDO.- Error: Consulta resumen del historial de pedidos,  Clase: GestorSeguimientoDePedidos,  Detalle: " + ex.getMessage().toString() +"]");
			Log log=new Log(1,infoCliente.getCve_cdo(),infoCliente.getCve_cliente() ,0, "[Error: Consulta resumen del historial de pedidos,  Clase: GestorSeguimientoDePedidos,  Detalle: " + ex.getMessage().toString() +"]");
			Cls_Log.insertaLog(log);
		}
		finally 
		{
			try {pstm.close();} catch (SQLException e) {e.printStackTrace();}
			try {connBD.close();} catch (SQLException e) {e.printStackTrace();}
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
			System.out.println("[Error: Llena clase resumen del historial de pedidos,  Clase: GestorSeguimientoDePedidos,  Detalle: " + ex.getMessage().toString() +"]");
			Log log=new Log(1,infoCliente.getCve_cdo(),infoCliente.getCve_cliente() ,0, "[Error: Consulta resumen del historial de pedidos,  Clase: GestorSeguimientoDePedidos,  Detalle: " + ex.getMessage().toString() +"]");
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
	
	
	/*** Consulta al detalle del pedido ***/
	public List<PedidoCdo>  ConsultaPedidosCliente(InfoCliente infoCliente, String pedidos,List<Querys> listaQuerys,String PedidoWWW)
	{
	//	System.out.println("ConsultaPedidosCliente. pedidos:"  + pedidos);
		
		List<PedidoCdo> Listapedidos = null;
		try {
			URL url = new URL(propertiesWs.getProperty("URL_WS_ESTATUS_PEDIDO")  + "?cveCentro=" + infoCliente.getCentro() + "&cliente=" +infoCliente.getCve_cliente() + "&pedidos=" + pedidos);
			
			//System.out.println("URL URL_WS_ESTATUS_PEDIDO: " + url);
			
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		    conn.setRequestMethod("GET");
		    conn.setRequestProperty("Accept", "application/json");
		    Log log=new Log(1,infoCliente.getCve_cdo(),infoCliente.getCve_cliente() ,0, "[Accion: Consulta informacion de Pedidos, Cliente:  " + infoCliente.getCve_cliente() +". Pedidos: "+ pedidos +" ]");
		    Cls_Log.insertaLog(log);
		    if (conn.getResponseCode() != 200) 
	        {
		    	
	        	log=new Log(1,infoCliente.getCve_cdo(),infoCliente.getCve_cliente() ,0, "[NuevoportalRamaCDO.- Error: Exception al conectar con URL_WS_ESTATUS_PEDIDO,  Clase: GestorSeguimientoDePedidos.ConsultaPedidosCliente, URL: "+ propertiesWs.getProperty("URL_WS_ESTATUS_PEDIDO")  + "relacionBodega?cve_centro=" + infoCliente.getCentro() + "&cliente=" + infoCliente.getCve_cliente() + ".  Detalle: " + conn.getResponseCode() +"]");
				Cls_Log.insertaLog(log);
            }
	        else
	        {
	        	 conn.connect();
	 	         InputStreamReader in = new InputStreamReader(conn.getInputStream());
	             BufferedReader br = new BufferedReader(in);
	             JsonReader lecturaJson = Json.createReader(new StringReader(br.readLine()));
	 			 JsonObject jsonPedidoCliente = lecturaJson.readObject();
	 			 if(Cls_MetodosGlobales.lecturaValidacionJson(jsonPedidoCliente, infoCliente, " consulta de detalle de Pedido  ", "GestorSeguimientoDePedidos","wsEstatusPedido"))
	 			 {
	 				 if( jsonPedidoCliente.getInt("registros") > 0  )
	 				 {
	 					if(ValidaEstatusPdidos(infoCliente, jsonPedidoCliente))
	 					{
  	 				  		Listapedidos = LlenaListaPedidos(infoCliente, jsonPedidoCliente);
	 					}
	 					else
	 					{
	 						Listapedidos = LlenaListaPedidosdesdeTablasWWW(infoCliente,listaQuerys,PedidoWWW);
	 					}
	 				 }else
	 				 {
	 				   Listapedidos = LlenaListaPedidosdesdeTablasWWW(infoCliente,listaQuerys,PedidoWWW);
	 				 }
	 			 }	             
	 			 
	        }
	        conn.disconnect();
		}
		catch(Exception ex)
		{
		//	System.out.println("[NuevoportalRamaCDO.- Error: Consulta Pedido Cliente,  Clase: GestorSeguimientoDePedidos,  Detalle: " + ex.getMessage().toString() +"]");
			Log log=new Log(1,infoCliente.getCve_cdo(),infoCliente.getCve_cliente() ,0, "[Error: Consulta resumen del historial de pedidos,  Clase: GestorSeguimientoDePedidos,  Detalle: " + ex.getMessage().toString() +"]");
			Cls_Log.insertaLog(log);
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
			System.out.println("[NuevoportalRamaCDO.- Error: Consulta resumen del historial de pedidos,  Clase: GestorSeguimientoDePedidos,  Detalle: " + ex.getMessage().toString() +"]");
			Log log=new Log(1,infoCliente.getCve_cdo(),infoCliente.getCve_cliente() ,0, "[Error: Consulta resumen del historial de pedidos,  Clase: GestorSeguimientoDePedidos,  Detalle: " + ex.getMessage().toString() +"]");
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
		 
			querys = Cls_Querys.ObtieneQuerys(42, listaQuerys, querys);
			querys = inicializaQueryNumero42(querys, infoCliente, numeroPedidoWWW);
 
			pstm = connBD.prepareStatement("{call " + "comercio_electronico.usp_EXECUTE_QUERY(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			ResultSet rs=  EjecutaQuerysBD.EjecutarQuery(querys[0], querys[1],querys[2], querys[3], querys[4], querys[5], querys[6],
														 querys[7], querys[8], querys[9],querys[10], querys[11], querys[12], querys[13], 
														 querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], 
														 querys[21], querys[22], querys[23], querys[24], "",pstm, connBD);
			
			//System.out.println("query 42");
			Cls_Querys.ImprimeQuerysConsola(querys,false,"Query 42");

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
		           
				     listaDetalle.add(pCdoD);
				     renglon ++;
				}
			}
			
			Log log=new Log(1,infoCliente.getCve_cdo(),infoCliente.getCve_cliente() ,0, "[Accion: Consulta resumen del historial de pedidos. ]");
			Cls_Log.insertaLog(log);
		}
		catch(Exception ex)
		{
			System.out.println("[NuevoportalRamaCDO.- Error: Consulta resumen del historial de pedidos,  Clase: GestorSeguimientoDePedidos,  Detalle: " + ex.getMessage().toString() +"]");
			Log log=new Log(1,infoCliente.getCve_cdo(),infoCliente.getCve_cliente() ,0, "[Error: Consulta resumen del historial de pedidos,  Clase: GestorSeguimientoDePedidos,  Detalle: " + ex.getMessage().toString() +"]");
			Cls_Log.insertaLog(log);
		}
		finally 
		{
			try {pstm.close();} catch (SQLException e) {e.printStackTrace();}
			try {connBD.close();} catch (SQLException e) {e.printStackTrace();}
		}
		return listaDetalle;
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

	private boolean ValidaEstatusPdidos(InfoCliente infoCliente, JsonObject jsonPedidoCliente) {
		boolean pedidosCorrectos =false;
		try {
     		JSONArray jsonArrayPedidos = new JSONArray(jsonPedidoCliente.getJsonArray("datos").toString());
 
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
			System.out.println("[NuevoportalRamaCDO.- Error: ValidaEstatusPdidos,  Clase: GestorSeguimientoDePedidos,  Detalle: " + ex.getMessage().toString() +"]");
			Log log=new Log(1,infoCliente.getCve_cdo(),infoCliente.getCve_cliente() ,0, "[Error: Consulta resumen del historial de pedidos,  Clase: GestorSeguimientoDePedidos,  Detalle: " + ex.getMessage().toString() +"]");
			Cls_Log.insertaLog(log);

		}
		//System.out.println("ValidaEstatusPdidos: " + pedidosCorrectos);
		return pedidosCorrectos;
	}
	
	private List<PedidoCdo> LlenaListaPedidos(InfoCliente infoCliente, JsonObject jsonPedidoCliente) {
		List<PedidoCdo> listaPedidos =  new ArrayList<PedidoCdo>();
		try {
     		JSONArray jsonArrayPedidos = new JSONArray(jsonPedidoCliente.getJsonArray("datos").toString());
 
     		for (int i = 0; i < jsonArrayPedidos.length(); i++) {
	
			JSONObject rs = jsonArrayPedidos.getJSONObject(i);
			
			
			PedidoCdo pCdo = new PedidoCdo();
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
			System.out.println("[NuevoportalRamaCDO.- Error: Consulta Pedido Cliente(LlenaListaPedidos),  Clase: GestorSeguimientoDePedidos,  Detalle: " + ex.getMessage().toString() +"]");
			Log log=new Log(1,infoCliente.getCve_cdo(),infoCliente.getCve_cliente() ,0, "[Error: Consulta resumen del historial de pedidos,  Clase: GestorSeguimientoDePedidos,  Detalle: " + ex.getMessage().toString() +"]");
			Cls_Log.insertaLog(log);

		}
		return listaPedidos;
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
			System.out.println("[NuevoportalRamaCDO.- Error: Consulta Pedido Cliente(GeneraCortePorFactura),  Clase: GestorSeguimientoDePedidos,  Detalle: " + ex.getMessage().toString() +"]");
			Log log=new Log(1,infoCliente.getCve_cdo(),infoCliente.getCve_cliente() ,0, "[Error: Consulta resumen del historial de pedidos,  Clase: GestorSeguimientoDePedidos,  Detalle: " + ex.getMessage().toString() +"]");
			Cls_Log.insertaLog(log);
		}
	return listaDetalle;
}
}
