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
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.json.JSONArray;
import org.json.JSONObject;

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

public class GestorEstadoDeCuentaV2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Client cliente = null;
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
	 
	 
		
	public EstadoDeCuenta consultaEstadoDeCuentaPorCliente(InfoCliente infoCliente)
	{
		EstadoDeCuenta  estadoCuentaGeneral = new EstadoDeCuenta();
		try {
			init();
			estadoCuentaGeneral = consultaEstadoDeCuentaGeneral(infoCliente, estadoCuentaGeneral);
			estadoCuentaGeneral = consultaEstadoCuentaConFactDelDia(infoCliente, estadoCuentaGeneral);
			estadoCuentaGeneral = consultaEstadoCuentaConPedidosDelDia(infoCliente, estadoCuentaGeneral);	
			destroy();
		} catch (Exception e) {
			Log log=new Log(0, 0, 0 ,0, "[Error consultaEstadoDeCuentaPorCliente,  Clase: GestorEstadoDeCuentaV2,  Detalle: " + e +"]");
			Cls_Log.insertaLog(log);
			destroy();
		}	
		return estadoCuentaGeneral;
	}
		
	/***  ESTADO DE CUENTA GENERAL ***/	
	private EstadoDeCuenta consultaEstadoDeCuentaGeneral(InfoCliente infoCliente, EstadoDeCuenta estadoCueGeneral)
	{		
		JSONObject rs = null;	
		Response cadUsisario = null;
		try
		{
			//System.out.println("URL: " + properties.getProperty("URL_WS_ESTADO_CUENTA")  + "total?cve_centro=" + infoCliente.getCentro() + "&num_cli=" + infoCliente.getCve_cliente());
	
			 cadUsisario = this.cliente.target(properties.getProperty("URL_WS_ESTADO_CUENTA")  + "total?cve_centro=" + infoCliente.getCentro() + "&num_cli=" + infoCliente.getCve_cliente())
						.request(MediaType.APPLICATION_JSON).post(Entity.json("Row"));
			 String respuestaJsonString = cadUsisario.readEntity(String.class);
			 rs = new JSONObject(respuestaJsonString);	
			
			// System.out.println("Respuesta: " + respuestaJsonString);
		}
		catch(Exception ex)
		{
			 Log log=new Log(01,infoCliente.getCve_cdo(),infoCliente.getCve_cliente() ,0, "URL_WS_ESTADO_CUENTA, Error al llamar a servicio,  Clase: GestorEstadoDeCuentaV2, Metodo: consultaEstadoDeCuentaGeneral, "+
						" Url: "+ properties.getProperty("URL_WS_ESTADO_CUENTA")    + "total?cve_centro=" + infoCliente.getCentro() + "&num_cli=" + infoCliente.getCve_cliente() +
						". Estatus: " + cadUsisario.getStatus() + " - " + cadUsisario.getStatusInfo());
			Cls_Log.insertaLog(log);
		}		  
        	  estadoCueGeneral = llenarClaseEstadoCuentaGeneral(infoCliente, rs, estadoCueGeneral); 				 
	 	return estadoCueGeneral;

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
	private EstadoDeCuenta llenarClaseEstadoCuentaGeneral( InfoCliente infoCliente,JSONObject jsonEdoCuenta, EstadoDeCuenta estadoCuentaGeneral)
	{
		try 
		{
			JSONArray detalleJson = jsonEdoCuenta.getJSONArray("datos");
			if(detalleJson.length() > 0)
			{
				for (int i = 0; i < detalleJson.length(); i++) 
				{	
					estadoCuentaGeneral.setNum_cliente(Integer.parseInt(detalleJson.getJSONObject(i).getString("num_cli")));
		       	 	estadoCuentaGeneral.setSaldo_total("$ " + formatoDecimal.format(Double.parseDouble(detalleJson.getJSONObject(i).getString("total"))));
		       	 	estadoCuentaGeneral.setSaldo_vencido("$ " + formatoDecimal.format(Double.parseDouble(detalleJson.getJSONObject(i).getString("vencido"))));	
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
		
		 JSONObject rs = null;	 
			try
			{

				Response cadUsisario = this.cliente.target(properties.getProperty("URL_WS_ESTADO_CUENTA")  + "compras?cve_centro=" + infoCliente.getCentro() + "&num_cli=" + infoCliente.getCve_cliente())
						.request(MediaType.APPLICATION_JSON).post(Entity.json("Row"));
			String respuestaJsonString = cadUsisario.readEntity(String.class);
			 rs = new JSONObject(respuestaJsonString);	
			
			 //System.out.println("Respuesta: " + respuestaJsonString);
				
	 				listFacturasDelDia = llenarClaseEstadoCuentaFacDia(infoCliente, rs);
	 				
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
	
	private List<EstadoDeCuentaFacturasDelDia>  llenarClaseEstadoCuentaFacDia( InfoCliente infoCliente, JSONObject jsonEdoCuenta)
	{
		List<EstadoDeCuentaFacturasDelDia> listFacturasDelDia = new ArrayList<>();	
		try 
		{		
			JSONArray detalleJson = jsonEdoCuenta.getJSONArray("datos");
			if(detalleJson.length() > 0)
			{
				for (int i = 0; i < detalleJson.length(); i++) 
				{	
					if(!detalleJson.getJSONObject(i).getString("num_fac").equals(""))
					{
						EstadoDeCuentaFacturasDelDia facturaDeldia= new EstadoDeCuentaFacturasDelDia();
						facturaDeldia.setFecha_factura(detalleJson.getJSONObject(i).getString("fecha_pro"));
	                	facturaDeldia.setImporte_factura("$ " + formatoDecimal.format(Double.parseDouble(detalleJson.getJSONObject(i).getString("imp_total"))));
	                	facturaDeldia.setNum_factura(detalleJson.getJSONObject(i).getString("num_fac"));
	                	facturaDeldia.setOde_factura(Integer.parseInt(detalleJson.getJSONObject(i).getString("ode")));
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
		
		 JSONObject rs = null;	 
			try
			{
				
				Response cadUsisario = this.cliente.target(properties.getProperty("URL_WS_ESTADO_CUENTA")  + "pedidos?cve_centro=" + infoCliente.getCentro() + "&num_cli=" + infoCliente.getCve_cliente())
						.request(MediaType.APPLICATION_JSON).post(Entity.json("Row"));
			String respuestaJsonString = cadUsisario.readEntity(String.class);
			 rs = new JSONObject(respuestaJsonString);	
			
			// System.out.println("Respuesta: " + respuestaJsonString);

	 				listPedidosDelDia = llenarClaseEstadoCuentaPedDia(infoCliente, rs);	             
   
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
	
	private List<EstadoDeCuentaPedidosDelDia>  llenarClaseEstadoCuentaPedDia( InfoCliente infoCliente, JSONObject jsonEdoCuenta)
	{
		List<EstadoDeCuentaPedidosDelDia> listPedidosDelDia = new ArrayList<>();			
		try 
		{		
			JSONArray detalleJson = jsonEdoCuenta.getJSONArray("datos");
			if(detalleJson.length() > 0)
			{
				for (int i = 0; i < detalleJson.length(); i++) 
				{	
					if(!detalleJson.getJSONObject(i).getString("pedido").equals(""))
					{
						EstadoDeCuentaPedidosDelDia pedidoDelDia= new EstadoDeCuentaPedidosDelDia();
						pedidoDelDia.setNum_ped(detalleJson.getJSONObject(i).getString("pedido"));
	            		pedidoDelDia.setHora_peido(detalleJson.getJSONObject(i).getString("hora") + " hrs.");
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
		try {
			init();
			listDetalleEdoCuenta=consultaDetalleEstadoDeCuentaWS(infoCliente,listDetalleEdoCuenta);
			destroy();
		} catch (Exception e) {
			Log log=new Log(0, 0, 0 ,0, "[Error consultaDetalleEstadoDeCuentaXCte,  Clase: GestorEstadoDeCuentaV2,  Detalle: " + e +"]");
			Cls_Log.insertaLog(log);
			destroy();
		}	
		return listDetalleEdoCuenta;
	}
	
	private List<EstadoDeCuentaDetalle> consultaDetalleEstadoDeCuentaWS(InfoCliente infoCliente, List<EstadoDeCuentaDetalle> listDetalleEdoCuenta)
	{	
		JSONObject rs = null;
		try
		{
			//System.out.println(properties.getProperty("URL_WS_ESTADO_CUENTA")  + "facturas?cve_centro=" + infoCliente.getCentro() + "&num_cli=" + infoCliente.getCve_cliente());
		   
			Response cadUsisario = this.cliente.target(properties.getProperty("URL_WS_ESTADO_CUENTA")  + "facturas?cve_centro=" + infoCliente.getCentro() + "&num_cli=" + infoCliente.getCve_cliente())
					.request(MediaType.APPLICATION_JSON).post(Entity.json("Row"));
		    String respuestaJsonString = cadUsisario.readEntity(String.class);

			rs = new JSONObject(respuestaJsonString);

	 		listDetalleEdoCuenta= llenarClaseEstadoCuentaDetalle(infoCliente, rs, listDetalleEdoCuenta);
     
		}
		catch(Exception ex)
		{
			System.out.println("[NuevoportalRamaCDO.- Error: Invocar wsFacturas para estado de cuenta general,  Clase: GestorEstadoDeCuenta,  Detalle: " + ex.getMessage().toString() +"]");
			Log log=new Log(1,infoCliente.getCve_cdo(),infoCliente.getCve_cliente() ,0, "[Error: Invocar wsFacturas para estado de cuenta general,  Clase: GestorEstadoDeCuenta,  Detalle: " + ex.getMessage().toString() +"]");
			Cls_Log.insertaLog(log);
		}
		return listDetalleEdoCuenta;
	}
	
	private List<EstadoDeCuentaDetalle>  llenarClaseEstadoCuentaDetalle( InfoCliente infoCliente, JSONObject jsonEdoCuenta, List<EstadoDeCuentaDetalle> listDetalleEdoCuenta)
	{
		try 
		{		
			JSONArray detalleJson = jsonEdoCuenta.getJSONArray("datos");
			if(detalleJson.length() > 0)
			{
				for (int i = 0; i < detalleJson.length(); i++) 
				{	
					if(!detalleJson.getJSONObject(i).getString("num_fac").equals(""))
					{
						EstadoDeCuentaDetalle detalleFac= new EstadoDeCuentaDetalle();	            		
	                	detalleFac.setFactura(detalleJson.getJSONObject(i).getString("num_fac"));
	                	detalleFac.setFecha_factura(detalleJson.getJSONObject(i).getString("fecha_factura"));
	                	detalleFac.setImporte_real("$ " + formatoDecimal.format(Double.parseDouble(detalleJson.getJSONObject(i).getString("imp_real"))));
	                	detalleFac.setSaldo("$ " + formatoDecimal.format(Double.parseDouble(detalleJson.getJSONObject(i).getString("saldo"))));
	                	detalleFac.setFecha_vencimiento(detalleJson.getJSONObject(i).getString("fecha_vencimiento"));
	                	detalleFac.setDias_vencidos(detalleJson.getJSONObject(i).getString("dias_vencidos"));
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
