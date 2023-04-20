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

public class GestorConfiguracionDemonios {

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
	
	@SuppressWarnings("deprecation")
	public EjecDemonios ConsultaProcesarPedidoWS(int servidorCDO, InfoCliente infoCliente)
	{
		 EjecDemonios demonio = new EjecDemonios(); 
		 
		 
			try
			{
				String uname ="";
				try {
					uname = infoCliente.getUname_bodega();
				if (infoCliente.getUname_bodega().equalsIgnoreCase("null"))
				{
					uname = infoCliente.getUname_cdo();
				}
				}
				catch(Exception e){uname = infoCliente.getUname_cdo();}
				
				URL url = new URL(properties.getProperty("URL_WS_HORAS_PROCESOS")  + "?cve_centro=" + servidorCDO +"&programa=comelec-pedidos.sh");
				
				System.out.println("url HORAA: " + url);
				
		        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		        conn.setRequestMethod("POST");
		        
		        
		        if (conn.getResponseCode() != 200) 
		        {
		        	System.out.println("[NuevoportalRamaCDO.- Error Al consutlar Ejecucion de DEmonios por WS: " + conn.getResponseCode() +"]");
					Log log=new Log(1,infoCliente.getCve_cdo(),infoCliente.getCve_cliente() ,0, "[Error Al consutlar Ejecucion de DEmonios por WS: " + conn.getResponseCode() +"]");
					Cls_Log.insertaLog(log);
	            }
		        else
		        {
		        	 conn.connect();
		 	         InputStreamReader in = new InputStreamReader(conn.getInputStream());
		             BufferedReader br = new BufferedReader(in);
		             JsonReader lecturaJson = Json.createReader(new StringReader(br.readLine()));
		 			 JsonObject jsonConsignatarios = lecturaJson.readObject();	 		
		 			 if(Cls_MetodosGlobales.lecturaValidacionJson(jsonConsignatarios, infoCliente, " consulta de ejecucion de Demonios WS ", "GestorConfiguracionDemonios","wsProgramas"))
		 			 {
		 				JSONArray jsonArrayPedidos = new JSONArray(jsonConsignatarios.getJsonArray("datos").toString());
		 				JSONObject rs = jsonArrayPedidos.getJSONObject(0);
		 				demonio.setUname(rs.getString("uname"));
                        demonio.setIdPrograma(rs.getString("id_programa"));

		 				demonio.setHoraIni(new Time( Integer.parseInt(rs.getString("hora_ini").substring(0, 2)),Integer.parseInt(rs.getString("hora_ini").substring(3, 5)),Integer.parseInt(rs.getString("hora_ini").substring(6, 8)) ));

		 				demonio.setHoraFin(new Time( Integer.parseInt(rs.getString("hora_fin").substring(0, 2)),Integer.parseInt(rs.getString("hora_fin").substring(3, 5)),Integer.parseInt(rs.getString("hora_fin").substring(6, 8)) ));

		 				demonio.setHoraSabadoIni(new Time( Integer.parseInt(rs.getString("hora_sab_ini").substring(0, 2)),Integer.parseInt(rs.getString("hora_sab_ini").substring(3, 5)),Integer.parseInt(rs.getString("hora_sab_ini").substring(6, 8)) ));

		 				demonio.setHoraSabadoFin(new Time( Integer.parseInt(rs.getString("hora_sab_fin").substring(0, 2)),Integer.parseInt(rs.getString("hora_sab_fin").substring(3, 5)),Integer.parseInt(rs.getString("hora_sab_fin").substring(6, 8)) ));

		 				demonio.setEstatus(rs.getString("st"));

		 			 }
		        }
		        conn.disconnect();
			}
			catch(Exception ex)
			{
				System.out.println("[NuevoportalRamaCDO.- Error: WS_HORAS_PROCESOS,  Clase: GestorConfiguracionDemonios.ConsultaProcesarPedidoWS,  Detalle: " + ex.getMessage().toString() +"]");
				Log log=new Log(1,infoCliente.getCve_cdo(),infoCliente.getCve_cliente() ,0, "[Error: Error: WS_HORAS_PROCESOS,  Clase: GestorConfiguracionDemonios.ConsultaProcesarPedidoWS,  Detalle: " + ex.getMessage().toString() +"]");
				Cls_Log.insertaLog(log);
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
			System.out.println("[NuevoportalRamaCDO.- Error: Consulta resumen del historial de pedidos,  Clase: GestorSeguimientoDePedidos,  Detalle: " + ex.toString() +"]");
 
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
