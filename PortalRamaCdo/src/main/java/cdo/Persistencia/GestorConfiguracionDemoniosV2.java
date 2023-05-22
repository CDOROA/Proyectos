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
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.json.Json;
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

import cdo.Datos.EjecDemonios;
import cdo.Datos.InfoCliente;
import cdo.Datos.Log;
import cdo.Datos.SeguimientoPedidosResumen;
import cdo.Util.Cls_Log;
import cdo.Util.Cls_MetodosGlobales;
import cdo.Util.Cls_Querys;
import cdo.Util.ConexionBD;
import cdo.Util.EjecutaQuerysBD;

public class GestorConfiguracionDemoniosV2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private Client cliente = null;
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
	 
	
	@SuppressWarnings("deprecation")
	public EjecDemonios ConsultaProcesarPedidoWS(int servidorCDO, InfoCliente infoCliente)
	{
		 EjecDemonios demonio = new EjecDemonios(); 

				String uname ="";
				try {
					uname = infoCliente.getUname_bodega();
					if (infoCliente.getUname_bodega().equalsIgnoreCase("null"))
					{
						uname = infoCliente.getUname_cdo();
					}
				}
				catch(Exception e){uname = infoCliente.getUname_cdo();}
	
				JSONObject rs2 = null;	 
				Response cadUsisario = null;
				try
				{
				// System.out.println(properties.getProperty("URL_WS_HORAS_PROCESOS")  + "?cve_centro=" + servidorCDO +"&programa=comelec-pedidos.sh");	
				
				cadUsisario = this.cliente.target(properties.getProperty("URL_WS_HORAS_PROCESOS")  + "?cve_centro=" + servidorCDO +"&programa=comelec-pedidos.sh")
						.request(MediaType.APPLICATION_JSON).post(Entity.json("Row"));
				//System.out.println("...1");	
				//System.out.println("RespuestaCadUser: " + cadUsisario);
				String respuestaJsonString = cadUsisario.readEntity(String.class);
				//System.out.println("RespuestaJSON: " + respuestaJsonString);
				rs2 = new JSONObject(respuestaJsonString);	
				
				 //System.out.println("Respuesta rs2: " + rs2);
					
		 				JSONArray jsonArrayPedidos = new JSONArray(rs2.getJSONArray("datos").toString());
		 				JSONObject rs = jsonArrayPedidos.getJSONObject(0);
		 				demonio.setUname(rs.getString("uname"));
                        demonio.setIdPrograma(rs.getString("id_programa"));

		 				demonio.setHoraIni(new Time( Integer.parseInt(rs.getString("hora_ini").substring(0, 2)),Integer.parseInt(rs.getString("hora_ini").substring(3, 5)),Integer.parseInt(rs.getString("hora_ini").substring(6, 8)) ));

		 				demonio.setHoraFin(new Time( Integer.parseInt(rs.getString("hora_fin").substring(0, 2)),Integer.parseInt(rs.getString("hora_fin").substring(3, 5)),Integer.parseInt(rs.getString("hora_fin").substring(6, 8)) ));

		 				demonio.setHoraSabadoIni(new Time( Integer.parseInt(rs.getString("hora_sab_ini").substring(0, 2)),Integer.parseInt(rs.getString("hora_sab_ini").substring(3, 5)),Integer.parseInt(rs.getString("hora_sab_ini").substring(6, 8)) ));

		 				demonio.setHoraSabadoFin(new Time( Integer.parseInt(rs.getString("hora_sab_fin").substring(0, 2)),Integer.parseInt(rs.getString("hora_sab_fin").substring(3, 5)),Integer.parseInt(rs.getString("hora_sab_fin").substring(6, 8)) ));

		 				demonio.setEstatus(rs.getString("st"));

				}
				catch(Exception ex)
				{
					Log log=new Log(01,infoCliente.getCve_cdo(),infoCliente.getCve_cliente() ,0, "WS_HORAS_PROCESOS, Error al valiar conexion con BD CDO,  Clase: GestorConfiguracionDemoniosV2, Metodo: ConsultaProcesarPedidoWS, "+
							" Url: "+ properties.getProperty("WS_HORAS_PROCESOS")  + "?cve_centro=" + servidorCDO +"&programa=comelec-pedidos.sh" +
							". Estatus: " + cadUsisario.getStatus() + " - " + cadUsisario.getStatusInfo());
				Cls_Log.insertaLog(log);
				
				demonio.setUname("cdf");
                demonio.setIdPrograma("comelec-pedidos.sh");

 				demonio.setHoraIni(new Time(8,0,0));

 				demonio.setHoraFin(new Time(19,0,0 ));

 				demonio.setHoraSabadoIni(new Time(8,0,0 ));

 				demonio.setHoraSabadoFin(new Time( 14,0,0 ));

 				demonio.setEstatus("");
		 
				}

	 return  demonio;
	}
	
	
	public EjecDemonios ConsultaProcesarPedido(String servidorCDO)
	{
		 EjecDemonios demonio = new EjecDemonios(); 
		Connection connBD = null;
		PreparedStatement pstm= null;
		connBD = ConexionBD.abrirConexionBDCDO(servidorCDO);
		try
		{
			pstm = connBD.prepareStatement(InicializaQueryCDO());
     		ResultSet rs=  pstm.executeQuery();
			
			if(rs != null)
			{
				while (rs.next()) {
					demonio.setUname(rs.getString("uname"));
					demonio.setIdPrograma(rs.getString("id_programa"));
					demonio.setHoraIni(rs.getTime("hora_ini"));
					demonio.setHoraFin(rs.getTime("hora_fin"));
					demonio.setHoraSabadoIni(rs.getTime("hora_sab_ini"));
					demonio.setHoraSabadoFin(rs.getTime("hora_sab_fin"));
				}
			}
		}
		catch(Exception ex)
		{
			System.out.println("[NuevoportalRamaCDO.- Error: Consulta resumen del historial de pedidos,  Clase: GestorSeguimientoDePedidosV2,  Detalle: " + ex.toString() +"]");
 
		}
		finally 
		{
			try {pstm.close();} catch (SQLException e) {e.printStackTrace();}
			try {connBD.close();} catch (SQLException e) {e.printStackTrace();}
		}
	 return  demonio;
	}

	private static String InicializaQueryCDO()
	{
		String query="SELECT uname, id_programa, hora_ini, hora_fin, hora_sab_ini, hora_sab_fin FROM SISTEMAS.CONFIG_EJEC_DEMONIOS where id_programa = 'comelec-pedidos.sh';";
		return  query;	
	}
}
