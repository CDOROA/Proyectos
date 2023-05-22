package cdo.Persistencia;

import java.io.InputStream;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;

import org.json.JSONArray;
import org.json.JSONObject;

import cdo.Datos.Log;
import cdo.Datos.SeguimientoPedidosResumen;
import cdo.Util.Cls_Log;

public class GestorPedidoMayorista  extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private Client cliente = null;
	private  static Properties properties = null;	
	static 
	{
	      try  
	      {
	    	  properties = new Properties();
		      InputStream  inputStreamWs  = GestorIniciaSessionV2.class.getClassLoader().getResourceAsStream("/properties/configuracion.properties");
		      properties.load(inputStreamWs);
	      }
	      catch  (Exception ex) 
	      {
	        ex.printStackTrace();
	      }
	 }
	
	public GestorPedidoMayorista() {
        super();
       
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

	public SeguimientoPedidosResumen consultaPedidoMayWs(int centro, int cliente, int pedido, SeguimientoPedidosResumen resumen)
	{
		SeguimientoPedidosResumen pedidoMay = new SeguimientoPedidosResumen();
		String Parametros = "";
		String respuestaJson = "";
	
		try {
	
			 Parametros = "?cveCentro=" + centro + "&cliente="+ cliente +"&pedido=" + pedido;
	
			 respuestaJson = this.cliente.target(properties.getProperty("URL_WS_ESTATUS_PEDIDO_MAY") + Parametros)
							.request(MediaType.APPLICATION_JSON).get(String.class);
			
			 //System.out.println("URL_WS_ESTATUS_PEDIDO_MAY: " + properties.getProperty("URL_WS_ESTATUS_PEDIDO_MAY") + Parametros); 
			 
			 JSONObject jsonObj = new JSONObject(respuestaJson);
			 // System.out.println("respuestaJson nuevo: " + respuestaJson); 
			  
			 if (jsonObj.get("status").toString().equalsIgnoreCase("5"))
			 {
				 JSONObject jsonObjDatos = jsonObj.getJSONObject("datos");
	
				 
			//	 System.out.println("Estatus nuevo: " + jsonObjDatos.toString() );
				 if (!jsonObjDatos.get("estatusAlmacen").toString().trim().equalsIgnoreCase(""))
				{
					resumen.setEstatusCdo(jsonObjDatos.get("estatusAlmacen").toString());
					resumen.setEstatusEntrega(jsonObjDatos.get("estatusEntrega").toString() );
					resumen.setTransporte(jsonObjDatos.get("transporte").toString());
					resumen.setImgEntrega(jsonObjDatos.get("idEstatusPng").toString());
				}
			 }
			 
		} catch (Exception ex) {
			resumen.setEstatusCdo("");
			resumen.setEstatusEntrega("");
			resumen.setTransporte("");
			resumen.setImgEntrega("");

			//System.out.println("[NuevoportalRamaCDO Servicio URL_WS_ESTATUS_PEDIDO_MAY no disponible,  Clase: GestorPedidoMayorista.consultaPedidoMayWs, URL: "+
			//		properties.getProperty("URL_WS_ESTATUS_PEDIDO_MAY") + Parametros );
			
			Log log=new Log(1,centro,cliente ,0, "[NuevoportalRamaCDO Servicio URL_WS_ESTATUS_PEDIDO_MAY no disponible,  Clase: GestorPedidoMayorista.consultaPedidoMayWs, URL: "+
					properties.getProperty("URL_WS_ESTATUS_PEDIDO_MAY") + Parametros
			+".  Detalle: " + ex.getMessage().toString() +"]");
			Cls_Log.insertaLog(log);
			throw ex;
			}
		
		 return resumen;
	}

	public JSONArray consultaPedidoMayOtrosCanalesWs(int centro, int cliente, int rango)
	{
		JSONArray jsonObjDatos = null ;
		String Parametros = "";
		String respuestaJson = "";
		try {
			 Parametros = "?cveCentro=" + centro + "&cliente="+ cliente +"&rango=" + rango;
			 
			// System.out.println(properties.getProperty("WS_ESTATUS_PEDIDOS_MAY_OTROS_CANALES") + Parametros);
			 
			 respuestaJson = this.cliente.target(properties.getProperty("WS_ESTATUS_PEDIDOS_MAY_OTROS_CANALES") + Parametros)
							.request(MediaType.APPLICATION_JSON).get(String.class);
				 
			 JSONObject jsonObj = new JSONObject(respuestaJson);
	 
			 if (jsonObj.get("status").toString().equalsIgnoreCase("5"))
			 {			 
				  jsonObjDatos = jsonObj.getJSONArray("datos");
	
			 }
			 
		} catch (Exception ex) {
			 
			System.out.println("[NuevoportalRamaCDO Servicio WS_ESTATUS_PEDIDOS_MAY_OTROS_CANALES no disponible,  Clase: GestorPedidoMayorista.consultaPedidoMayOtrosCanalesWs, URL: "+
					properties.getProperty("WS_ESTATUS_PEDIDOS_MAY_OTROS_CANALES") + Parametros );
			
			Log log=new Log(1,centro,cliente ,0, "[NuevoportalRamaCDO Servicio WS_ESTATUS_PEDIDOS_MAY_OTROS_CANALES no disponible,  Clase: GestorPedidoMayorista.consultaPedidoMayOtrosCanalesWs, URL: "+
					properties.getProperty("WS_ESTATUS_PEDIDOS_MAY_OTROS_CANALES") + Parametros
			+".  Detalle: " + ex.getMessage().toString() +"]");
			Cls_Log.insertaLog(log);
			throw ex;
			}
		
		 return jsonObjDatos ;
	}
}
