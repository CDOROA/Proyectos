package cdo.Persistencia;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;

import cdo.Datos.EstadoDeCuenta;
import cdo.Datos.EstadoDeCuentaDetalle;
import cdo.Datos.EstadoDeCuentaFacturasDelDia;
import cdo.Datos.EstadoDeCuentaPedidosDelDia;
import cdo.Datos.InfoCliente;
import cdo.Datos.Log;
import cdo.Datos.Querys;
import cdo.Util.Cls_Log;
import cdo.Util.Cls_MetodosGlobales;
import cdo.Util.Cls_Querys;
import cdo.Util.ConexionBD;
import cdo.Util.EjecutaQuerysBD;

public class GestorEstadoDeCuenta 
{
	DecimalFormat formatoDecimal = new DecimalFormat("#,###.00");
	private  static Properties properties = null;
	
	 static 
	 {
	      try  
	      {
		      properties = new Properties();
		      InputStream  inputStream  = GestorBolsaDeTrabajo.class.getClassLoader().getResourceAsStream("/properties/configuracion.properties");
		      properties.load(inputStream);
		      
	      }
	      catch  (Exception ex) 
	      {
	        ex.printStackTrace();
	      }
	 }	
		
	public EstadoDeCuenta consultaEstadoDeCuentaPorCliente(InfoCliente infoCliente)
	{
		EstadoDeCuenta estadoCuentaGeneral = new EstadoDeCuenta();	
		estadoCuentaGeneral = consultaEstadoDeCuentaGeneral(infoCliente, estadoCuentaGeneral);
		estadoCuentaGeneral = consultaEstadoCuentaConFactDelDia(infoCliente, estadoCuentaGeneral);
		estadoCuentaGeneral = consultaEstadoCuentaConPedidosDelDia(infoCliente, estadoCuentaGeneral);
		return estadoCuentaGeneral;
	}
		
	/***  ESTADO DE CUENTA GENERAL ***/	
	private EstadoDeCuenta consultaEstadoDeCuentaGeneral(InfoCliente infoCliente, EstadoDeCuenta estadoCuentaGeneral)
	{
		try
		{
			URL url = new URL(properties.getProperty("URL_WS_ESTADO_CUENTA")  + "total?cve_centro=" + infoCliente.getCentro() + "&num_cli=" + infoCliente.getCve_cliente());			
	        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	        conn.setRequestMethod("POST");
	     //   System.out.println("url estado de Cuenta: " + url);
	        Log log=new Log(1,infoCliente.getCve_cdo(),infoCliente.getCve_cliente() ,0, "[Accion: Consulta estado de cuenta general, Cliente:  " + infoCliente.getCve_cliente() +" ]");
	        Cls_Log.insertaLog(log);
	       // System.out.println("url estado de Cuenta conn.getResponseCode() " + conn.getResponseCode());
	        if (conn.getResponseCode() > 200) 
	        {
	        	System.out.println("[NuevoportalRamaCDO.- Error: Exception al conectar con wsFacturas,  Clase: GestorEstadoDeCuenta,  Detalle: " + conn.getResponseCode() +"]");
				log=new Log(1,infoCliente.getCve_cdo(),infoCliente.getCve_cliente() ,0, "[Error: Exception al conectar con wsFacturas,  Clase: GestorEstadoDeCuenta,  Detalle: " + conn.getResponseCode() +"]");
				Cls_Log.insertaLog(log);
            }
	        else
	        {
	        	//  System.out.println("...1");
	        	 conn.connect();
	        	// System.out.println("...2");
	        	 InputStreamReader in = new InputStreamReader(conn.getInputStream());
	        	// System.out.println("...3");
	             BufferedReader br = new BufferedReader(in);
	           //  System.out.println("...4");
	             JsonReader lecturaJson = Json.createReader(new StringReader(br.readLine()));
	           //  System.out.println("...5");
	 			 JsonObject jsonEdoCuenta = lecturaJson.readObject();
	 			//System.out.println("...6");
	 			 if(Cls_MetodosGlobales.lecturaValidacionJson(jsonEdoCuenta, infoCliente, "estado de cuenta general", "GestorEstadoDeCuenta","wsFacturas"))
	 			 {
	 			//	System.out.println("...7");
	 				 estadoCuentaGeneral = llenarClaseEstadoCuentaGeneral(infoCliente, jsonEdoCuenta, estadoCuentaGeneral); 				 
	 			 }
	 			//System.out.println("...8");
	        }
	        conn.disconnect();
		}
		catch(Exception ex)
		{
			System.out.println("[NuevoportalRamaCDO.- Error ex: Invocar wsFacturas para estado de cuenta general,  Clase: GestorEstadoDeCuenta,  Detalle: " + ex.toString() +"]");
			Log log=new Log(1,infoCliente.getCve_cdo(),infoCliente.getCve_cliente() ,0, "[Error: Invocar wsFacturas para estado de cuenta general,  Clase: GestorEstadoDeCuenta,  Detalle: " + ex.getMessage().toString() +"]");
			Cls_Log.insertaLog(log);
		}
		return estadoCuentaGeneral;
	}
	public String validarPassword(String pass, InfoCliente infoCliente, List<Querys> listaQuerys) 
	{
		String respuesta = "0";
		Connection connBD = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		connBD = ConexionBD.abrirConexionBD();
		try 
		{
			String [] querys = new String [25];
			querys = Cls_Querys.LimpiaListaQuerys(querys);
			querys = Cls_Querys.ObtieneQuerys(49, listaQuerys, querys);
			querys= inicializaQueryNumero49(querys,infoCliente,pass );
			pstm = connBD.prepareStatement("{call " + "comercio_electronico.usp_EXECUTE_QUERY(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			rs = EjecutaQuerysBD.EjecutarQuery(querys[0], querys[1],querys[2], querys[3], querys[4], querys[5], querys[6],
					 querys[7], querys[8], querys[9],querys[10], querys[11], querys[12], querys[13], 
					 querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], 
					 querys[21], querys[22], querys[23], querys[24], "",pstm, connBD);
			
			Cls_Querys.ImprimeQuerysConsola(querys,false,"Query 49");
			if(rs != null)
			{
				 
				while(rs.next())
				{
					//System.out.println(pass  + "."+rs.getString("pass"));
					if (rs.getString("pass").equals(pass)) 
					{
						respuesta = "1";
					}
				}
			}
			
		}
		catch(Exception ex)
		{
			Log log=new Log(01,infoCliente.getCve_cdo(),infoCliente.getCve_cliente() ,0, "[Error:  validar password estado de cuenta,  Clase: GestorCarritoDeCompras,  Detalle: " + ex.getMessage().toString().replace("'","´") +"]");
			Cls_Log.insertaLog(log);
		}
		finally
		{
			try {connBD.close();} catch (SQLException e) {e.printStackTrace();}
			try {pstm.close();} catch (SQLException e) {e.printStackTrace();}
		}
		return respuesta;
	}
	private String[] inicializaQueryNumero49(String[] ListaQuerys, InfoCliente infoCliente, String password) 
	{
		for (int i=0;i <ListaQuerys.length; i++)
		{
			ListaQuerys[i]= ListaQuerys[i].replace("{CLIENTE}",String.valueOf(infoCliente.getCve_cliente()));
			ListaQuerys[i]= ListaQuerys[i].replace("{CVE_CENTRO}", String.valueOf(infoCliente.getCentro()));
		}
		return ListaQuerys;
	}
	private EstadoDeCuenta llenarClaseEstadoCuentaGeneral( InfoCliente infoCliente,JsonObject jsonEdoCuenta, EstadoDeCuenta estadoCuentaGeneral)
	{
		try 
		{
			JsonArray detalleJson = jsonEdoCuenta.getJsonArray("datos");
			if(detalleJson.size() > 0)
			{
				for (int i = 0; i < detalleJson.size(); i++) 
				{	
					estadoCuentaGeneral.setNum_cliente(Integer.parseInt(detalleJson.getJsonObject(i).getString("num_cli")));
		       	 	estadoCuentaGeneral.setSaldo_total("$ " + formatoDecimal.format(Double.parseDouble(detalleJson.getJsonObject(i).getString("total"))));
		       	 	estadoCuentaGeneral.setSaldo_vencido("$ " + formatoDecimal.format(Double.parseDouble(detalleJson.getJsonObject(i).getString("vencido"))));	
				}
			}			
		}
		catch(Exception ex)
		{
			System.out.println("[NuevoportalRamaCDO.- Error: LLenar clase estado de cuenta general,  Clase: GestorEstadoDeCuenta,  Detalle: " + ex.getMessage().toString() +"]");
			Log log=new Log(1,infoCliente.getCve_cdo(),infoCliente.getCve_cliente() ,0, "[Error: LLenar clase estado de cuenta general,  Clase: GestorEstadoDeCuenta,  Detalle: " + ex.getMessage().toString() +"]");
			Cls_Log.insertaLog(log);
		}		
		return estadoCuentaGeneral;
	}
	
		
	/***  ESTADO DE CUENTA FACTURAS DEL DIA  ***/	
	private EstadoDeCuenta  consultaEstadoCuentaConFactDelDia(InfoCliente infoCliente, EstadoDeCuenta estadoCuentaGeneral)
	{
		 List<EstadoDeCuentaFacturasDelDia> listFacturasDelDia = new ArrayList<>();
		try
		{
			URL url = new URL(properties.getProperty("URL_WS_ESTADO_CUENTA")  + "compras?cve_centro=" + infoCliente.getCentro() + "&num_cli=" + infoCliente.getCve_cliente());			
			 
	        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	        conn.setRequestMethod("POST");
	        
	        Log log=new Log(1,infoCliente.getCve_cdo(),infoCliente.getCve_cliente() ,0, "[Accion: Consulta estado de cuenta para facturas del dia, Cliente:  " + infoCliente.getCve_cliente() +" ]");
	        Cls_Log.insertaLog(log);

	        if (conn.getResponseCode() != 200) 
	        {
	        	System.out.println("[NuevoportalRamaCDO.- Error: Exception al conectar con wsFacturas,  Clase: GestorEstadoDeCuenta,  Detalle: " + conn.getResponseCode() +"]");
				log=new Log(1,infoCliente.getCve_cdo(),infoCliente.getCve_cliente() ,0, "[Error: Exception al conectar con wsFacturas,  Clase: GestorEstadoDeCuenta,  Detalle: " + conn.getResponseCode() +"]");
				Cls_Log.insertaLog(log);
            }
	        else
	        {
	        	 conn.connect();
	 	         InputStreamReader in = new InputStreamReader(conn.getInputStream());
	             BufferedReader br = new BufferedReader(in);	             
	             JsonReader lecturaJson = Json.createReader(new StringReader(br.readLine()));
	 			 JsonObject jsonEdoCuenta = lecturaJson.readObject();	 			 
	 			 if(Cls_MetodosGlobales.lecturaValidacionJson(jsonEdoCuenta, infoCliente, "estado de cuenta general facturas del dia", "GestorEstadoDeCuenta","wsFacturas"))
	 			 {
	 				listFacturasDelDia = llenarClaseEstadoCuentaFacDia(infoCliente, jsonEdoCuenta);
	 			 }
	        }
	        conn.disconnect();
	        estadoCuentaGeneral.setListFacturasDia(listFacturasDelDia);
		}
		catch(Exception ex)
		{
			System.out.println("[NuevoportalRamaCDO.- Error: Invocar wsFacturas para facturas del dia ,  Clase: GestorEstadoDeCuenta,  Detalle: " + ex.getMessage().toString() +"]");
			Log log=new Log(1,infoCliente.getCve_cdo(),infoCliente.getCve_cliente() ,0, "[Error: Invocar wsFacturas para facturas del dia,  Clase: GestorEstadoDeCuenta,  Detalle: " + ex.getMessage().toString() +"]");
			Cls_Log.insertaLog(log);
		}
		 
		return estadoCuentaGeneral;
	}
	
	private List<EstadoDeCuentaFacturasDelDia>  llenarClaseEstadoCuentaFacDia( InfoCliente infoCliente, JsonObject jsonEdoCuenta)
	{
		List<EstadoDeCuentaFacturasDelDia> listFacturasDelDia = new ArrayList<>();	
		try 
		{		
			JsonArray detalleJson = jsonEdoCuenta.getJsonArray("datos");
			if(detalleJson.size() > 0)
			{
				for (int i = 0; i < detalleJson.size(); i++) 
				{	
					if(!detalleJson.getJsonObject(i).getString("num_fac").equals(""))
					{
						EstadoDeCuentaFacturasDelDia facturaDeldia= new EstadoDeCuentaFacturasDelDia();
						facturaDeldia.setFecha_factura(detalleJson.getJsonObject(i).getString("fecha_pro"));
	                	facturaDeldia.setImporte_factura("$ " + formatoDecimal.format(Double.parseDouble(detalleJson.getJsonObject(i).getString("imp_total"))));
	                	facturaDeldia.setNum_factura(detalleJson.getJsonObject(i).getString("num_fac"));
	                	facturaDeldia.setOde_factura(Integer.parseInt(detalleJson.getJsonObject(i).getString("ode")));
	                	listFacturasDelDia.add(facturaDeldia);
					}
				}
			}	
		}
		catch(Exception ex)
		{
			System.out.println("[NuevoportalRamaCDO.- Error: LLenar clase estado de cuenta  facturas del dia,  Clase: GestorEstadoDeCuenta,  Detalle: " + ex.getMessage().toString() +"]");
			Log log=new Log(1,infoCliente.getCve_cdo(),infoCliente.getCve_cliente() ,0, "[Error: LLenar clase estado de cuenta  facturas del dia,  Clase: GestorEstadoDeCuenta,  Detalle: " + ex.getMessage().toString() +"]");
			Cls_Log.insertaLog(log);
		}
		return listFacturasDelDia;
	}
	
	
	/***  ESTADO DE CUENTA PEDIDOS DEL DIA  ***/
	private EstadoDeCuenta  consultaEstadoCuentaConPedidosDelDia(InfoCliente infoCliente, EstadoDeCuenta estadoCuentaGeneral)
	{
		 List<EstadoDeCuentaPedidosDelDia> listPedidosDelDia = new ArrayList<>();
		try
		{
			URL url = new URL(properties.getProperty("URL_WS_ESTADO_CUENTA")  + "pedidos?cve_centro=" + infoCliente.getCentro() + "&num_cli=" + infoCliente.getCve_cliente());			
	        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	        conn.setRequestMethod("POST");
	        
	        Log log=new Log(1,infoCliente.getCve_cdo(),infoCliente.getCve_cliente() ,0, "[Accion: Consulta estado de cuenta para pedidos del dia, Cliente:  " + infoCliente.getCve_cliente() +" ]");
	        Cls_Log.insertaLog(log);

	        if (conn.getResponseCode() != 200) 
	        {
	        	System.out.println("[NuevoportalRamaCDO.- Error: Exception al conectar con wsFacturas,  Clase: GestorEstadoDeCuenta,  Detalle: " + conn.getResponseCode() +"]");
				log=new Log(1,infoCliente.getCve_cdo(),infoCliente.getCve_cliente() ,0, "[Error: Exception al conectar con wsFacturas,  Clase: GestorEstadoDeCuenta,  Detalle: " + conn.getResponseCode() +"]");
				Cls_Log.insertaLog(log);
            }
	        else
	        {
	        	 conn.connect();
	 	         InputStreamReader in = new InputStreamReader(conn.getInputStream());
	             BufferedReader br = new BufferedReader(in);
	             JsonReader lecturaJson = Json.createReader(new StringReader(br.readLine()));
	 			 JsonObject jsonEdoCuenta = lecturaJson.readObject();	 			 
	 			 if(Cls_MetodosGlobales.lecturaValidacionJson(jsonEdoCuenta, infoCliente, "estado de cuenta general pedidos del dia", "GestorEstadoDeCuenta","wsFacturas"))
	 			 {
	 				listPedidosDelDia = llenarClaseEstadoCuentaPedDia(infoCliente, jsonEdoCuenta);
	 			 }	             
	        }
	        conn.disconnect();
	        estadoCuentaGeneral.setListPedidosDia(listPedidosDelDia);
		}
		catch(Exception ex)
		{
			System.out.println("[NuevoportalRamaCDO.- Error: Invocar wsFacturas para facturas del dia ,  Clase: GestorEstadoDeCuenta,  Detalle: " + ex.getMessage().toString() +"]");
			Log log=new Log(1,infoCliente.getCve_cdo(),infoCliente.getCve_cliente() ,0, "[Error: Invocar wsFacturas para facturas del dia,  Clase: GestorEstadoDeCuenta,  Detalle: " + ex.getMessage().toString() +"]");
			Cls_Log.insertaLog(log);
		}
		
		return estadoCuentaGeneral;
	}
	
	private List<EstadoDeCuentaPedidosDelDia>  llenarClaseEstadoCuentaPedDia( InfoCliente infoCliente, JsonObject jsonEdoCuenta)
	{
		List<EstadoDeCuentaPedidosDelDia> listPedidosDelDia = new ArrayList<>();			
		try 
		{		
			JsonArray detalleJson = jsonEdoCuenta.getJsonArray("datos");
			if(detalleJson.size() > 0)
			{
				for (int i = 0; i < detalleJson.size(); i++) 
				{	
					if(!detalleJson.getJsonObject(i).getString("pedido").equals(""))
					{
						EstadoDeCuentaPedidosDelDia pedidoDelDia= new EstadoDeCuentaPedidosDelDia();
						pedidoDelDia.setNum_ped(detalleJson.getJsonObject(i).getString("pedido"));
	            		pedidoDelDia.setHora_peido(detalleJson.getJsonObject(i).getString("hora") + " hrs.");
	            		listPedidosDelDia.add(pedidoDelDia);
					}
				}
			}	 
		}
		catch(Exception ex)
		{
			System.out.println("[NuevoportalRamaCDO.- Error: LLenar clase estado de cuenta  pedidos del dia,  Clase: GestorEstadoDeCuenta,  Detalle: " + ex.getMessage().toString() +"]");
			Log log=new Log(1,infoCliente.getCve_cdo(),infoCliente.getCve_cliente() ,0, "[Error: LLenar clase estado de cuenta  pedidos del dia,  Clase: GestorEstadoDeCuenta,  Detalle: " + ex.getMessage().toString() +"]");
			Cls_Log.insertaLog(log);
		}
		return listPedidosDelDia;
	}
	
	
	/***  ESTADO DE CUENTA DETALLE DE TODAS LAS FACTURAS  ***/	
	public List<EstadoDeCuentaDetalle> consultaDetalleEstadoDeCuentaXCte(InfoCliente infoCliente)
	{
		List<EstadoDeCuentaDetalle> listDetalleEdoCuenta = new ArrayList<>();
		listDetalleEdoCuenta=consultaDetalleEstadoDeCuentaWS(infoCliente,listDetalleEdoCuenta);
		return listDetalleEdoCuenta;
	}
	
	private List<EstadoDeCuentaDetalle> consultaDetalleEstadoDeCuentaWS(InfoCliente infoCliente, List<EstadoDeCuentaDetalle> listDetalleEdoCuenta)
	{
		try
		{
			URL url = new URL(properties.getProperty("URL_WS_ESTADO_CUENTA")  + "facturas?cve_centro=" + infoCliente.getCentro() + "&num_cli=" + infoCliente.getCve_cliente());			
	        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	        conn.setRequestMethod("POST");
	        
	        Log log=new Log(1,infoCliente.getCve_cdo(),infoCliente.getCve_cliente() ,0, "[Accion: Consulta estado de cuenta detalle facturas, Cliente:  " + infoCliente.getCve_cliente() +" ]");
	        Cls_Log.insertaLog(log);

	        if (conn.getResponseCode() != 200) 
	        {
	        	System.out.println("[NuevoportalRamaCDO.- Error: Exception al conectar con wsFacturas,  Clase: GestorEstadoDeCuenta,  Detalle: " + conn.getResponseCode() +"]");
				log=new Log(1,infoCliente.getCve_cdo(),infoCliente.getCve_cliente() ,0, "[Error: Exception al conectar con wsFacturas,  Clase: GestorEstadoDeCuenta,  Detalle: " + conn.getResponseCode() +"]");
				Cls_Log.insertaLog(log);
            }
	        else
	        {
	        	conn.connect();
	 	         InputStreamReader in = new InputStreamReader(conn.getInputStream());
	             BufferedReader br = new BufferedReader(in);	  
	             JsonReader lecturaJson = Json.createReader(new StringReader(br.readLine()));
	 			 JsonObject jsonEdoCuenta = lecturaJson.readObject();	
	 			 if(Cls_MetodosGlobales.lecturaValidacionJson(jsonEdoCuenta, infoCliente, "estado de cuenta general detalle de facturas", "GestorEstadoDeCuenta","wsFacturas"))
	 			 {
	 				listDetalleEdoCuenta= llenarClaseEstadoCuentaDetalle(infoCliente, jsonEdoCuenta, listDetalleEdoCuenta);
	 			 }	
	        }
	        conn.disconnect();
		}
		catch(Exception ex)
		{
			System.out.println("[NuevoportalRamaCDO.- Error: Invocar wsFacturas para estado de cuenta general,  Clase: GestorEstadoDeCuenta,  Detalle: " + ex.getMessage().toString() +"]");
			Log log=new Log(1,infoCliente.getCve_cdo(),infoCliente.getCve_cliente() ,0, "[Error: Invocar wsFacturas para estado de cuenta general,  Clase: GestorEstadoDeCuenta,  Detalle: " + ex.getMessage().toString() +"]");
			Cls_Log.insertaLog(log);
		}
		return listDetalleEdoCuenta;
	}
	
	private List<EstadoDeCuentaDetalle>  llenarClaseEstadoCuentaDetalle( InfoCliente infoCliente, JsonObject jsonEdoCuenta, List<EstadoDeCuentaDetalle> listDetalleEdoCuenta)
	{
		try 
		{		
			JsonArray detalleJson = jsonEdoCuenta.getJsonArray("datos");
			if(detalleJson.size() > 0)
			{
				for (int i = 0; i < detalleJson.size(); i++) 
				{	
					if(!detalleJson.getJsonObject(i).getString("num_fac").equals(""))
					{
						EstadoDeCuentaDetalle detalleFac= new EstadoDeCuentaDetalle();	            		
	                	detalleFac.setFactura(detalleJson.getJsonObject(i).getString("num_fac"));
	                	detalleFac.setFecha_factura(detalleJson.getJsonObject(i).getString("fecha_factura"));
	                	detalleFac.setImporte_real("$ " + formatoDecimal.format(Double.parseDouble(detalleJson.getJsonObject(i).getString("imp_real"))));
	                	detalleFac.setSaldo("$ " + formatoDecimal.format(Double.parseDouble(detalleJson.getJsonObject(i).getString("saldo"))));
	                	detalleFac.setFecha_vencimiento(detalleJson.getJsonObject(i).getString("fecha_vencimiento"));
	                	detalleFac.setDias_vencidos(detalleJson.getJsonObject(i).getString("dias_vencidos"));
	                	listDetalleEdoCuenta.add(detalleFac);	            		
					}
				}
			}	 
		}
		catch(Exception ex)
		{
			System.out.println("[NuevoportalRamaCDO.- Error: LLenar clase estado de cuenta  detalle facturas,  Clase: GestorEstadoDeCuenta,  Detalle: " + ex.getMessage().toString() +"]");
			Log log=new Log(1,infoCliente.getCve_cdo(),infoCliente.getCve_cliente() ,0, "[Error: LLenar clase estado de cuenta  detalle facturas,  Clase: GestorEstadoDeCuenta,  Detalle: " + ex.getMessage().toString() +"]");
			Cls_Log.insertaLog(log);
		}
		return listDetalleEdoCuenta;
	}
	
	
	
	
	
}
