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
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Currency;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.json.JSONArray;
import org.json.JSONObject;

import cdo.Datos.ArticulosCarritoDetalle;
import cdo.Datos.ArticulosCarritoEncabezado;
import cdo.Datos.ArticulosCarritoPedidoCompleto;
import cdo.Datos.ExistenciasPorArticulo;
import cdo.Datos.InfoCliente;
import cdo.Datos.Log;
import cdo.Datos.PedidoCdo;
import cdo.Datos.Querys;
import cdo.Datos.ValidadorTaspaso72hrs;
import cdo.Util.Cls_Log;
import cdo.Util.Cls_MetodosGlobales;
import cdo.Util.Cls_Querys;
import cdo.Util.ConexionBD;
import cdo.Util.EjecutaQuerysBD;

public class GestorMantenimientoCarritoComprasV2 extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	 private  static Properties properties = null;
	 private Client cliente = null;
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
	 
	 
	/******  CONSULTA DE PEDIDO ACTUAL EN CARRITO   ******/
	public ArticulosCarritoPedidoCompleto  consultaPedidoActualEnCarritoCompras(List<Querys> listaQuerys,InfoCliente infoCliente)
	{
		ArticulosCarritoPedidoCompleto pedidoCompletoCarrito = new ArticulosCarritoPedidoCompleto();
		Connection connBD = null;
		PreparedStatement pstm= null;
		connBD = ConexionBD.abrirConexionBD();
		try
		{
			String[] querys = new String[25];	
			querys = Cls_Querys.LimpiaListaQuerys(querys);	
			querys = Cls_Querys.ObtieneQuerys(21, listaQuerys, querys);
			querys = inicializaQueryNumero21(querys, infoCliente);
			pstm = connBD.prepareStatement("{call " + "comercio_electronico.usp_EXECUTE_QUERY(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");	
			
			ResultSet rs=  EjecutaQuerysBD.EjecutarQuery(querys[0], querys[1],querys[2], querys[3], querys[4], querys[5], querys[6],
														 querys[7], querys[8], querys[9],querys[10], querys[11], querys[12], querys[13], 
														 querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], 
														 querys[21], querys[22], querys[23], querys[24], "",pstm, connBD);
			
			Cls_Querys.ImprimeQuerysConsola(querys,false,"Query 21");
			
			
			
			if(rs != null)
			{
				//System.out.println("... consultaPedidoActualEnCarritoCompras 1");
				pedidoCompletoCarrito.setEncabezadoPedido(llenaClaseEncabezadoArticulosCarrito(rs));
				//System.out.println("... consultaPedidoActualEnCarritoCompras 2");
				pedidoCompletoCarrito.setDetallePedido(llenaClaseDetalleArticulosCarrito(infoCliente, rs));
				//System.out.println("... consultaPedidoActualEnCarritoCompras 3 ");
			}
			
			 
		}
		catch(Exception ex)
		{
		   System.out.println("Error consultar query 21" + ex);
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
			//System.out.println("[NuevoportalRamaCDO.- Error: Consulta pedido actual en el carrito de compras,  Clase: GestorMantenimientoCarritoComprasV2.consultaPedidoActualEnCarritoCompras,  Detalle: " + ex.toString() +"]");
			Log log=new Log(1,infoCliente.getCve_cdo(),infoCliente.getCve_cliente() ,0, "[Error: Consulta pedido actual en el carrito de compras,  Clase: GestorMantenimientoCarritoComprasV2.consultaPedidoActualEnCarritoCompras,  Detalle: " + ex.getMessage().toString() +"]");
			Cls_Log.insertaLog(log);
		}
		finally 
		{
			try {pstm.close();} catch (SQLException e) {e.printStackTrace();}
			try {connBD.close();} catch (SQLException e) {e.printStackTrace();}
		}

		return pedidoCompletoCarrito;
		
	}
		
	private ArticulosCarritoEncabezado llenaClaseEncabezadoArticulosCarrito(ResultSet rs)
	{
		ArticulosCarritoEncabezado header= new ArticulosCarritoEncabezado();
		int contador =0;
		try
		{
			while(rs.next())
			{
				if(rs.getString("tipo").equals("A"))
				{
					header.setCve_centro(rs.getInt("cve_centro"));
					header.setFecha_pedido(rs.getString("ped_fecha"));
					header.setNombre_cliente(rs.getString("cli_nombre"));
					header.setNum_cliente(rs.getInt("cve_client"));
					header.setNum_pedido(rs.getInt("cve_pedido"));
				}
				
				if(rs.getString("tipo").equals("D"))
				{
					contador ++;
					header.setTotalArticulosEnCarrito(contador);
				}
				
			}
		}
		catch(Exception ex)
		{
			System.out.println("[NuevoportalRamaCDO.- Error: Llenar clase encabezado del carrito,  Clase: GestorMantenimientoCarritoComprasV2,  Detalle: " + ex.getMessage().toString() +"]");
			Log log=new Log(1,0,0 ,0, "[Error: Llenar clase encabezado del carrito,  Clase: GestorMantenimientoCarritoComprasV2,  Detalle: " + ex.getMessage().toString() +"]");
			Cls_Log.insertaLog(log);
		}
		return header;		
	}
		
	private List<ArticulosCarritoDetalle> llenaClaseDetalleArticulosCarrito(InfoCliente infoCliente, ResultSet rs)
	{
		List<ArticulosCarritoDetalle> detallePedidoCarrito= new ArrayList<>();		
		
		try
		{
			
			rs.beforeFirst();
			String esTraspaso="";
			String nombre="";
		
			while(rs.next())
			{
				if(rs.getString("tipo").equals("D") || rs.getString("tipo").equals("T") )
				{
				
				//	System.out.println("....1");
					ArticulosCarritoDetalle detalle = new ArticulosCarritoDetalle();

					
			
					detalle.setCantidadPedida(rs.getInt("ped_cant_p")); 
					detalle.setCantidadPorSurtirCdo(rs.getInt("ped_cant_surtida_cdo"));
					detalle.setCantidadPorSurtirBr(rs.getInt("ped_cant_surtida_br"));
					detalle.setCantidadPorSurtir72(rs.getInt("ped_cant_surtida_72"));
				 	detalle.setCdoMacro(infoCliente.getNombre_cdo());	
					detalle.setCdoTraspaso(rs.getString("descripcion_cdo"));
					detalle.setCdoBr(infoCliente.getNombre_bodega());
					

				/*	detalle.setCantidadPorSurtirCdo(rs.getInt("ped_cant_surtida_cdo"));
					detalle.setCantidadPorSurtirBr(rs.getInt("ped_cant_surtida_br"));
					detalle.setCantidadPorSurtir72(rs.getInt("ped_cant_surtida_72"));
				
					*/
					
					/* SE recupera las leyendas de los CDOs de WS.-*/
					//detalle.setCdoMacro("");	
					//detalle.setCdoBr("");	
					//detalle.setCdoTraspaso("");
					//System.out.println("....5 " + JsonRs);
					/*
					 * 
					 */
					
					/*
					 * 	init();
			int conexionConCDO = ValidaConnCDO(infoCliente);
					JSONObject JsonRs = null;
					try {
						
					    JsonRs = consultaExistenciasEnWS2(infoCliente, rs.getString("art_numart_cdo"),rs.getInt("ped_cant_p"), conexionConCDO );
					    
						if(JsonRs != null && (JsonRs.getInt("macro_cantidad") > 0 ||JsonRs.getInt("regional_cantidad") >0 || JsonRs.getInt("macro_traspaso_cantidad") > 0 ) )
						{	
							//System.out.println("....5");
							detalle.setCdoMacro(JsonRs.getString("descripcion_macro").toUpperCase());
							//System.out.println("....5.1");
							detalle.setCdoBr(JsonRs.getString("regional_descripcion").toUpperCase());
							//System.out.println("....5.2");
							detalle.setCdoTraspaso(JsonRs.getString("descripcion_macro_traspaso").toUpperCase());
							//System.out.println("....5.3");
						
						 				
						detalle.setCantidadPorSurtirCdo(JsonRs.getInt("macro_cantidad"));
						detalle.setCantidadPorSurtirBr(JsonRs.getInt("regional_cantidad"));
						detalle.setCantidadPorSurtir72(JsonRs.getInt("macro_traspaso_cantidad"));
						detalle.setCdoMacro(JsonRs.getString("descripcion_macro").toUpperCase());	
						detalle.setCdoBr(JsonRs.getString("regional_descripcion").toUpperCase());	
						detalle.setCdoTraspaso(JsonRs.getString("descripcion_macro_traspaso").toUpperCase());
						
						}						
					
					  
					} catch (Exception e) { 
					
						
						detalle.setCantidadPorSurtirCdo(rs.getInt("ped_cant_surtida_cdo"));
						detalle.setCantidadPorSurtirBr(rs.getInt("ped_cant_surtida_br"));
						detalle.setCantidadPorSurtir72(rs.getInt("ped_cant_surtida_72"));
					 	detalle.setCdoMacro(infoCliente.getNombre_cdo());	
						detalle.setCdoTraspaso(rs.getString("descripcion_cdo"));
						detalle.setCdoBr(infoCliente.getNombre_bodega());
					}
					 
					*/

					
					//System.out.println("....6");
					esTraspaso= (rs.getString("cdo_traspaso").equals(infoCliente.getUname_cdo())) ?  "NO" : "SI" ;
					//System.out.println("....7");
					detalle.setEsTraspaso(esTraspaso);
					//System.out.println("....8");
					detalle.setDescuentoXMarca(rs.getString("desc_x_marca"));
					//System.out.println("....9");
					detalle.setPorcDescuento(rs.getDouble("descuento"));
					//System.out.println("....10");
					detalle.setNumArticuloCDO(rs.getString("art_numart_cdo"));
					//System.out.println("....11");
					nombre= formatearDescripcion(rs.getString("nombreArticulo"));
					//System.out.println("....12");
					detalle.setNombreArticulo(validaNombreProducto(nombre));
					//System.out.println("....13");
					// detalle.setImporte(formatDecimal(Float.parseFloat(rs.getString("importe"))));
					detalle.setImporte(rs.getString("importe"));
					//System.out.println("....14");
					detalle.setNum_pedido(rs.getInt("cve_pedido"));
					//System.out.println("....15");
					detalle.setNumArticuloRC(rs.getString("art_numart_rc"));
					//System.out.println("....16");
					//detalle.setPrecioArticulo( formatDecimal(Float.parseFloat(rs.getString("ped_precio"))) );
					detalle.setPrecioArticulo( rs.getString("ped_precio"));
					//System.out.println("....17");
					detalle.setImagen_bxa(rs.getString("imagen_bxa"));
					//System.out.println("....18");
					detalle.setImagen_ecommerce(rs.getString("imagen_ecommerce"));
					//System.out.println("....19");
					detalle.setBloqueo72hrs(rs.getString("bloqueo_72hrs"));
					//System.out.println("....20");
					detalle.setBloqueoExpres(rs.getString("bloqueo_expres"));
					//System.out.println("....21");
					detallePedidoCarrito.add(detalle);
					//System.out.println("....22. fin");
				}
			}
		
		}
		catch(Exception ex)
		{
			 
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
			detallePedidoCarrito.add(detalle);

//			System.out.println("[NuevoportalRamaCDO.- Error: Llenar clase detalle del carrito,  Clase: GestorMantenimientoCarritoComprasV2,  Detalle: " + ex.getMessage().toString() +"]");
			Log log=new Log(1,0,0 ,0, "[Error: Llenar clase detalle del carrito,  Clase: GestorMantenimientoCarritoComprasV2,  Detalle: " + ex.getMessage().toString() +"]");
			Cls_Log.insertaLog(log);
		}
 
		return detallePedidoCarrito;
	}
 
	private int ValidaConnCDO(InfoCliente infoCliente) {
		int conexionExitosa = 9;
		Response cadUsisario = null;
		 JSONObject rs  = null;
		String Parametros ="";
		try
		{
		
			 Parametros = "validaBD?cve_centro=" + infoCliente.getCentro(); 
		
			  cadUsisario = this.cliente.target(properties.getProperty("URL_WS_EXISTENCIAS") + Parametros)
						.request(MediaType.APPLICATION_JSON).post(Entity.json("Row"));
		
		
			 String respuestaJson = cadUsisario.readEntity(String.class);
		
		
				String respuestaJsonString = cadUsisario.readEntity(String.class);
				  rs = new JSONObject(respuestaJsonString);	
				 
				 conexionExitosa = rs.getInt("codigo");
	 
		}
		catch(Exception ex)
		{
			conexionExitosa = 0;
		if (cadUsisario.getStatus() != 200)
		{
			conexionExitosa = 9;
			Log log=new Log(01,infoCliente.getCve_cdo(),infoCliente.getCve_cliente() ,0, "WS_EXISTENCIAS, Error al valiar conexion con BD CDO,  Clase: GestorCarritoDeCompras, Metodo: ValidaConnCDO, "+
					" Url: "+ properties.getProperty("URL_WS_EXISTENCIAS")  + Parametros +
					". Estatus: " + cadUsisario.getStatus() + " - " + cadUsisario.getStatusInfo());
		Cls_Log.insertaLog(log);
		}
	
		
		}		
		 //System.out.println(" return rs: " + rs);
		return conexionExitosa;
	}

	private String formatearDescripcion(String descripcionCompleta)
	{
		String descripcion = "";
	
		try
		{
		String descripciones[] = descripcionCompleta.split(",");
		
		for(int i = 0; i < descripciones.length; i++)
		{
			if(descripciones[i].length() > 0)
			{
				descripcion += descripciones[i] +",";
			}
		}
		
		descripcion = descripcion.substring(0,descripcion.length()-1);
		}
		catch (Exception e) {
			descripcion = ""; 
		}
		return descripcion;
	}
	
	private String validaNombreProducto(String nombreProducto)
	{
		String nombreCorrecto = "[";
		String []nombres = nombreProducto.replace("[", "").replace("]", "").split(",");
		List<String> nombresValidos = new ArrayList<>();
		boolean nombreNuevo = false;
		
		for(int i = 0; i < nombres.length ; i++)
		{
			nombreNuevo=false;
			if(i <= 0)
			{
				nombresValidos.add(nombres[i].trim());
			}
			else
			{
				for(int e = 0; e < nombresValidos.size(); e++)
				{
					if(nombres[i].equals(nombresValidos.get(e)))
					{
						nombreNuevo = true;
						break;
					}
				}
				
				if(nombreNuevo == false)
				{
					nombresValidos.add(nombres[i].trim());
				}
			}
		}
		
		for(int u= 0; u< nombresValidos.size(); u++)
		{
			nombreCorrecto += nombresValidos.get(u).trim() +",";
		}
		
		nombreCorrecto =  nombreCorrecto.substring(0, (nombreCorrecto.length() -1)) + "]";
		return nombreCorrecto;
	}
	
	/*CONSULTA DE EXISTENCIAS EN TIEMPO REAL*/
	/*No se ocupa*/
	private JSONObject consultaExistenciasEnWS(InfoCliente infoCliente, String num_art, int cantidad)
	{
		JSONObject rs = null;
	 
		try
		{
			String uname ="";
			try {
				uname = infoCliente.getUname_bodega();
				
			if (infoCliente.getUname_bodega().equalsIgnoreCase("null"))
			{
				uname = infoCliente.getUname_cdo();
			
			}
			if (infoCliente.getUname_bodega().equalsIgnoreCase(""))
			{
				uname = infoCliente.getUname_cdo();
			
			}
			}
			catch(Exception e){uname = infoCliente.getUname_cdo();}
			
			URL url = new URL(properties.getProperty("URL_WS_EXISTENCIAS")  + "existencias?cve_centro="+infoCliente.getCentro() +"&articulo=" + num_art +"&uname_br="+ uname +"&cantidad=" + cantidad);
			 //System.out.println("infoCliente     : " + infoCliente);
			 //System.out.println("url Existencias : " + url);
			
	        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	        conn.setRequestMethod("POST");
	        ;
	        if (conn.getResponseCode() != 200) 
	        {
	        	System.out.println("[NuevoportalRamaCDO.- Error: Exception al conectar con wsExistencias,  Clase: GestorCarritoDeCompras,  Detalle: " + conn.getResponseCode() +"]");
				Log log=new Log(1,infoCliente.getCve_cdo(),infoCliente.getCve_cliente() ,0, "[Error: Exception al conectar con wsExistencias,  Clase: GestorCarritoDeCompras,  Detalle: " + conn.getResponseCode() +"]");
				Cls_Log.insertaLog(log);
            }
	        else
	        {
	        	 conn.connect();
	 	         InputStreamReader in = new InputStreamReader(conn.getInputStream());
	             BufferedReader br = new BufferedReader(in);
	             JsonReader lecturaJson = Json.createReader(new StringReader(br.readLine()));
	 			 JsonObject jsonConsignatarios = lecturaJson.readObject();	 			 
	 			 if(Cls_MetodosGlobales.lecturaValidacionJson(jsonConsignatarios, infoCliente, " consulta de existencias por articulo ", "GestorCarritoDeCompras","wsExistencias"))
	 			 {
	 				JSONArray jsonArrayPedidos = new JSONArray(jsonConsignatarios.getJsonArray("datos").toString());
                    rs = jsonArrayPedidos.getJSONObject(0);
	 			 }
	        }
	        conn.disconnect();
		}
		catch(Exception ex)
		{
			System.out.println("[NuevoportalRamaCDO.- Error: Invocar wsExistencias para consulta de exietncias x articulo ,  Clase: GestorCarritoDeComprasV2.consultaExistenciasEnWS,  Detalle: " + ex.getMessage().toString() +"]");
			Log log=new Log(1,infoCliente.getCve_cdo(),infoCliente.getCve_cliente() ,0, "[Error: Invocar wsExistencias para consulta de exietncias x articulo,  Clase: GestorCarritoDeComprasV2.consultaExistenciasEnWS,  Detalle: " + ex.getMessage().toString() +"]");
			Cls_Log.insertaLog(log);
		}		
		 //System.out.println(" return rs: " + rs);
		return rs;
	}
	
	private JSONObject consultaExistenciasEnWS2(InfoCliente infoCliente, String num_art, int cantidad, int conectaCDO )
	{
		JSONObject rs = null;
		Response cadUsisario =  null;
		String uname ="";
		try
		{
			
			try {
				uname = infoCliente.getUname_bodega();
				
			if (infoCliente.getUname_bodega().equalsIgnoreCase("null"))
			{
				uname = infoCliente.getUname_cdo();
			
			}
			if (infoCliente.getUname_bodega().equalsIgnoreCase(""))
			{
				uname = infoCliente.getUname_cdo();
			
			}
			}
			catch(Exception e){uname = infoCliente.getUname_cdo();}
			 
		//	System.out.println("conectaCDO: " + conectaCDO);
			if (conectaCDO == 0)
			{
				
				cadUsisario = this.cliente.target(properties.getProperty("URL_WS_EXISTENCIAS")  + "existencias?cve_centro="+infoCliente.getCentro() +"&articulo=" + num_art +"&uname_br="+ uname +"&cantidad=" + cantidad)
					.request(MediaType.APPLICATION_JSON).post(Entity.json("Row"));
				
			}else{
				
				cadUsisario = this.cliente.target(properties.getProperty("URL_WS_EXISTENCIAS")  + "existenciasDBM?cve_centro="+infoCliente.getCentro() +"&articulo=" + num_art +"&uname_br="+ uname +"&cantidad=" + cantidad)
						.request(MediaType.APPLICATION_JSON).post(Entity.json("Row"));
			}
			
		String respuestaJsonString = cadUsisario.readEntity(String.class);
		//System.out.println("Respuesta: " +  respuestaJsonString);
		 rs = new JSONObject(respuestaJsonString);	
		 //System.out.println("Respuesta: " +  respuestaJsonString);
				 
		 JSONArray jsonArrayPedidos = new JSONArray(rs.getJSONArray("datos").toString());
         rs = jsonArrayPedidos.getJSONObject(0);
		 
		 //System.out.println("Respuesta: " + properties.getProperty("URL_WS_EXISTENCIAS")  + "existencias?cve_centro="+infoCliente.getCentro() +"&articulo=" + num_art +"&uname_br="+ uname +"&cantidad=" + cantidad);
			
		}
		catch(Exception ex)
		{
			//System.out.println("[NuevoportalRamaCDO.- Error: Invocar wsExistencias para consulta de exietncias x articulo ,  Clase: GestorCarritoDeComprasV2.consultaExistenciasEnWS2,  Detalle: " + ex.getMessage().toString() +"]");
			//System.out.println("[NuevoportalRamaCDO.- URL_WS_EXISTENCIAS no disponible ,  Clase: GestorCarritoDeComprasV2.consultaExistenciasEnWS2,  URL: " +properties.getProperty("URL_WS_EXISTENCIAS")  + "existencias?cve_centro="+infoCliente.getCentro() +"&articulo=" + num_art +"&uname_br="+ uname +"&cantidad=" + cantidad +"]");
	//		Log log=new Log(1,infoCliente.getCve_cdo(),infoCliente.getCve_cliente() ,0, "[NuevoportalRamaCDO.- URL_WS_EXISTENCIAS no disponible ,  Clase: GestorCarritoDeComprasV2.consultaExistenciasEnWS2,  URL: " +properties.getProperty("URL_WS_EXISTENCIAS")  + "existencias?cve_centro="+infoCliente.getCentro() +"&articulo=" + num_art +"&uname_br="+ uname +"&cantidad=" + cantidad + ".  Detalle: " + ex.getMessage().toString() +"]");
	//		Cls_Log.insertaLog(log);
				rs = new JSONObject( "{\"regional\": \"\","+
	            "\"regional_cantidad\": 0,"+
	            "\"regional_descripcion\": \"\","+
	            "\"macro\": \"\","+
	            "\"macro_cantidad\": 0,"+
	            "\"descripcion_macro\": \"\","+
	            "\"macro_traspaso\": \"\","+
	            "\"macro_traspaso_cantidad\": 0,"+
	            "\"descripcion_macro_traspaso\": \"\"}") ;
	        
		}		
		 // System.out.println(" return rs: " + rs);
		return rs;
	}
	
	/******   ELIMINAR ARTICULO    ******/	
	
	public ArticulosCarritoPedidoCompleto  EiminaArticuloDelCarrito(List<Querys> listaQuerys,InfoCliente infoCliente,String articulo, int pedido)
	{
		ArticulosCarritoPedidoCompleto pedidoCompletoCarrito = new ArticulosCarritoPedidoCompleto();
		Connection connBD = null;
		PreparedStatement pstm= null;
		connBD = ConexionBD.abrirConexionBD();
		try
		{
			String[] querys = new String[25];	
			querys = Cls_Querys.LimpiaListaQuerys(querys);	
			querys = Cls_Querys.ObtieneQuerys(26, listaQuerys, querys);
			querys = inicializaQueryNumero26(querys, infoCliente, articulo, pedido);
			pstm = connBD.prepareStatement("{call " + "comercio_electronico.usp_EXECUTE_QUERY(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
            
			ValidadorTaspaso72hrs validacion72hrs = ValidaRegistros72hrs(connBD, listaQuerys,infoCliente,articulo); 
			
		//	System.out.println("registrosEnBD: " + validacion72hrs.getRegistros());
			
			if (validacion72hrs.getRegistros() <= 1)
			{
				EliminaEncabezado72hrs(connBD, listaQuerys,infoCliente,validacion72hrs);
			}
			
			
			ResultSet rs=  EjecutaQuerysBD.EjecutarQuery(querys[0], querys[1],querys[2], querys[3], querys[4], querys[5], querys[6],
														 querys[7], querys[8], querys[9],querys[10], querys[11], querys[12], querys[13], 
														 querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], 
														 querys[21], querys[22], querys[23], querys[24], "",pstm, connBD);
			
			Cls_Querys.ImprimeQuerysConsola(querys,false,"Query 26");
			
			querys = Cls_Querys.LimpiaListaQuerys(querys);	
			querys = Cls_Querys.ObtieneQuerys(21, listaQuerys, querys);
			querys = inicializaQueryNumero21(querys, infoCliente );
			pstm = connBD.prepareStatement("{call " + "comercio_electronico.usp_EXECUTE_QUERY(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");

			rs =  EjecutaQuerysBD.EjecutarQuery(querys[0], querys[1],querys[2], querys[3], querys[4], querys[5], querys[6],
														 querys[7], querys[8], querys[9],querys[10], querys[11], querys[12], querys[13], 
														 querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], 
														 querys[21], querys[22], querys[23], querys[24], "",pstm, connBD);
		
			Cls_Querys.ImprimeQuerysConsola(querys,false,"Query 21");
			
			if(rs != null)
			{
				pedidoCompletoCarrito.setEncabezadoPedido(llenaClaseEncabezadoArticulosCarrito(rs));
				pedidoCompletoCarrito.setDetallePedido(llenaClaseDetalleArticulosCarrito(infoCliente, rs));
			}
			
			 
		}
		catch(Exception ex)
		{
			System.out.println("[NuevoportalRamaCDO.- Error: Consulta pedido actual en el carrito de compras,  Clase: GestorMantenimientoCarritoComprasV2.EiminaArticuloDelCarrito,  Detalle: " + ex.getMessage().toString() +"]");
			Log log=new Log(1,infoCliente.getCve_cdo(),infoCliente.getCve_cliente() ,0, "[Error: Consulta pedido actual en el carrito de compras,  Clase: GestorMantenimientoCarritoComprasV2.EiminaArticuloDelCarrito,  Detalle: " + ex.getMessage().toString() +"]");
			Cls_Log.insertaLog(log);
		}
		finally 
		{
			try {pstm.close();} catch (SQLException e) {e.printStackTrace();}
			try {connBD.close();} catch (SQLException e) {e.printStackTrace();}
		}

		return pedidoCompletoCarrito;
		
	}

	
	private void EliminaEncabezado72hrs(Connection connBD, List<Querys> listaQuerys, InfoCliente infoCliente,
			ValidadorTaspaso72hrs validacion72hrs) {
		try {
			PreparedStatement pstm = null;
			String[] querys = new String[25];
			querys = Cls_Querys.LimpiaListaQuerys(querys);
			querys = Cls_Querys.ObtieneQuerys(54, listaQuerys, querys);
			querys = inicializaQueryNumero54(querys, infoCliente, validacion72hrs);
			pstm = connBD.prepareStatement("{call comercio_electronico.usp_EXECUTE_QUERY(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");

			ResultSet rs=  EjecutaQuerysBD.EjecutarQuery(querys[0], querys[1],querys[2], querys[3], querys[4], querys[5], querys[6],
														 querys[7], querys[8], querys[9],querys[10], querys[11], querys[12], querys[13], 
														 querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], 
														 querys[21], querys[22], querys[23], querys[24], "",pstm, connBD);
		
			Cls_Querys.ImprimeQuerysConsola(querys,false,"Query 54");

		} catch (Exception e) {

		}
	}

	private ValidadorTaspaso72hrs ValidaRegistros72hrs(Connection connBD, List<Querys> listaQuerys, InfoCliente infoCliente, String articulo) {
		
		ValidadorTaspaso72hrs validacion72hrs = new ValidadorTaspaso72hrs();
		PreparedStatement pstm= null;
		String[] querys = new String[25];	
		int totalRegistros = 0;
		try {
			
		querys = Cls_Querys.LimpiaListaQuerys(querys);	
		querys = Cls_Querys.ObtieneQuerys(53, listaQuerys, querys);
		querys = inicializaQueryNumero53(querys, infoCliente, articulo);
	
			pstm = connBD.prepareStatement("{call " + "comercio_electronico.usp_EXECUTE_QUERY(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
	
		
		ResultSet rs=  EjecutaQuerysBD.EjecutarQuery(querys[0], querys[1],querys[2], querys[3], querys[4], querys[5], querys[6],
				 									 querys[7], querys[8], querys[9],querys[10], querys[11], querys[12], querys[13], 
				                                     querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], 
				                                     querys[21], querys[22], querys[23], querys[24], "",pstm, connBD);
		
		if(rs != null)
		{
			while(rs.next())
			{
				validacion72hrs.setRegistros(rs.getInt("totalRegistros"));
				validacion72hrs.setCdoTrasp(rs.getString("cdoTrasp"));
				validacion72hrs.setRespuesta(false);
				if (rs.getInt("totalRegistros") <= 1)
				{
					validacion72hrs.setRespuesta(true);
				}
			}
		}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return validacion72hrs;
	}

	/******   llamado a wsPedidosWWW    ******/	
	public boolean EnviaPedidoAMayorista(InfoCliente infoCliente, String pedido) {
		boolean ejecucionCorrecta = false;
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
		Date fechaHoraSistema = Calendar.getInstance().getTime();
		String sFechaHoraSistema = formatter.format(fechaHoraSistema);
		// System.out.println("sFechaHoraSistema: " + sFechaHoraSistema);
		String.format("%06d", Integer.parseInt(pedido));
		String urlParaVisitar = "";
		
		urlParaVisitar = properties.getProperty("URL_WS_PEDIDO_WWW") + "?cdo=" + infoCliente.getUname_cdo()
		+ "&pedido=" + infoCliente.getCentro() + String.format("%05d", infoCliente.getCve_cliente())
		+ sFechaHoraSistema + String.format("%06d", Integer.parseInt(pedido));
		
		Log log = new Log(1, infoCliente.getCve_cdo(), infoCliente.getCve_cliente(), Integer.parseInt(pedido),
				"Llamando a URL_WS_PEDIDO_WWW  [" + urlParaVisitar + "]");
		
		String JSON_SOURCE = "";
		try {
			 
			JSONObject rs = null;
            
			String respuestaJsonString = this.cliente.target(urlParaVisitar)
					.request(MediaType.APPLICATION_JSON).get(String.class);
			//System.out.println("Respuesta: " + respuestaJsonString);		
			
			
			if(respuestaJsonString.toString().equalsIgnoreCase("0"))
		    {
		    	ejecucionCorrecta  = true;
		    }
			
			log = new Log(1, infoCliente.getCve_cdo(), infoCliente.getCve_cliente(), Integer.parseInt(pedido),
					"Resultado a URL_WS_PEDIDO_WWW [" + respuestaJsonString + "]");
						
			//System.out.println("ejecucionCorrecta: " + ejecucionCorrecta);
			Cls_Log.insertaLog(log);
		} catch (Exception e) {
			ejecucionCorrecta = false;
			System.out.println("NuevoportalRamaCDO.- : Error al ejecuar URL_WS_PEDIDO_WWW: " + e.toString());
			System.out.println("NuevoportalRamaCDO.- : Error al ejecuar URL_WS_PEDIDO_WWW: " + urlParaVisitar);
			log = new Log(1, infoCliente.getCve_cdo(), infoCliente.getCve_cliente(), Integer.parseInt(pedido),
					"[ Error al ejecuar URL_WS_PEDIDO_WWW Error: " + e.toString() + " ]");
			Cls_Log.insertaLog(log);
			log = new Log(1, infoCliente.getCve_cdo(), infoCliente.getCve_cliente(), Integer.parseInt(pedido),
					"[ Error al ejecuar URL_WS_PEDIDO_WWW Url  : " + urlParaVisitar + " ]");
			Cls_Log.insertaLog(log);
		}
	//	System.out.println("ejecucionCorrecta: " + ejecucionCorrecta);
		return ejecucionCorrecta;
	}
	
	public boolean EnviaPedido72Hrs(List<Querys> listaQuerys, InfoCliente infoCliente, String pedido) {
		boolean ejecucionCorrecta = false;
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
		Date fechaHoraSistema = Calendar.getInstance().getTime();
		String sFechaHoraSistema = formatter.format(fechaHoraSistema);
		// System.out.println("sFechaHoraSistema: " + sFechaHoraSistema);
		String.format("%06d", Integer.parseInt(pedido));
		String urlParaVisitar = "";
		urlParaVisitar = properties.getProperty("URL_WS_PEDIDO_WWW_72Hrs") + "?centro="
				+ infoCliente.getCentro() + "&pedido=" + Integer.parseInt(pedido) + "&cliente="
				+ infoCliente.getCve_cliente();
		Log log = new Log(1, infoCliente.getCve_cdo(), infoCliente.getCve_cliente(), Integer.parseInt(pedido),
				"Llamando a URL_WS_PEDIDO_WWW_72hrs  [" + urlParaVisitar + "]");
		
		String JSON_SOURCE = "";
		
		try {

			JSONObject rs = null;

			String respuestaJsonString = this.cliente.target(urlParaVisitar)
					.request(MediaType.APPLICATION_JSON).get(String.class);
					
			
			if(respuestaJsonString.toString().equalsIgnoreCase("0"))
		    {
		    	ejecucionCorrecta  = true;
		    }
			
			//JSON_SOURCE = resultado.toString();

			log = new Log(1, infoCliente.getCve_cdo(), infoCliente.getCve_cliente(), Integer.parseInt(pedido),
					"Resultado a URL_WS_PEDIDO_WWW_72hrs [" + respuestaJsonString + "]");
						
			if(respuestaJsonString.trim().equalsIgnoreCase(""))
		    {
		    	ejecucionCorrecta  = true;
		    }
			
			//System.out.println("ejecucionCorrecta: " + ejecucionCorrecta + "JSON_SOURCE: " + JSON_SOURCE);
			Cls_Log.insertaLog(log);
			 
			// Se comenta y se extrae para su envio en el estatus 17 por saturacion de licencias de cobol.
			EnvioDeDorreo72Hrs(listaQuerys, infoCliente, Integer.parseInt(pedido));
			
		} catch (Exception e) {
			ejecucionCorrecta = false;
		//	System.out.println("PortalRamaCDO: Error al ejecuar URL_WS_PEDIDO_WWW_72hrs" + e.toString());
			//System.out.println("PortalRamaCDO: Error al ejecuar URL_WS_PEDIDO_WWW_72hrs" + urlParaVisitar);
			log = new Log(1, infoCliente.getCve_cdo(), infoCliente.getCve_cliente(), Integer.parseInt(pedido),
					"[ Error al ejecuar URL_WS_PEDIDO_WWW_72hrs Error: " + e.toString() + " ]");
			Cls_Log.insertaLog(log);
			log = new Log(1, infoCliente.getCve_cdo(), infoCliente.getCve_cliente(), Integer.parseInt(pedido),
					"[ Error al ejecuar URL_WS_PEDIDO_WWW_72hrs Url  : " + urlParaVisitar + " ]");
			Cls_Log.insertaLog(log);
			
		}
	//	System.out.println("ejecucionCorrecta: " + ejecucionCorrecta);
		return ejecucionCorrecta;
	}
	
	/******   INICIALIZA QUERYS    ******/	
	private String[] inicializaQueryNumero21(String[] ListaQuerys, InfoCliente infocte) 
	{
		for (int i=0;i <ListaQuerys.length; i++)
		{
			ListaQuerys[i]= ListaQuerys[i].replace("{CVE_CENTRO}",String.valueOf(infocte.getCentro()));
			ListaQuerys[i]= ListaQuerys[i].replace("{CVE_CLIENTE}", String.valueOf(infocte.getCve_cliente()));
		}
		return ListaQuerys;
	}

	private String[] inicializaQueryNumero26(String[] ListaQuerys, InfoCliente infocte,String articulo, int pedido) 
	{
		for (int i=0;i <ListaQuerys.length; i++)
		{
			ListaQuerys[i]= ListaQuerys[i].replace("{CVE_CENTRO}",String.valueOf(infocte.getCentro()));
			ListaQuerys[i]= ListaQuerys[i].replace("{CVE_CLIENTE}", String.valueOf(infocte.getCve_cliente()));
			ListaQuerys[i]= ListaQuerys[i].replace("{NUMERO_PEDIDO}", String.valueOf(pedido));
			ListaQuerys[i]= ListaQuerys[i].replace("{ARTICULO}", articulo);
		}
		return ListaQuerys;
	}
	
	
	private String[] inicializaQueryNumero53(String[] ListaQuerys, InfoCliente infocte, String articulo) {
		for (int i=0;i <ListaQuerys.length; i++)
		{
			ListaQuerys[i]= ListaQuerys[i].replace("{CVE_CENTRO}",String.valueOf(infocte.getCentro()));
			ListaQuerys[i]= ListaQuerys[i].replace("{NUM_CTE}", String.valueOf(infocte.getCve_cliente()));
			ListaQuerys[i]= ListaQuerys[i].replace("{NUM_ART}", articulo);
		}
		return ListaQuerys;
	}

	private String[] inicializaQueryNumero54(String[] ListaQuerys, InfoCliente infocte, ValidadorTaspaso72hrs validacion72hrs) {
		for (int i=0;i <ListaQuerys.length; i++)
		{
			ListaQuerys[i]= ListaQuerys[i].replace("{CVE_CENTRO}",String.valueOf(infocte.getCentro()));
			ListaQuerys[i]= ListaQuerys[i].replace("{NUM_CTE}", String.valueOf(infocte.getCve_cliente()));
			ListaQuerys[i]= ListaQuerys[i].replace("{CDO_TRASP}", validacion72hrs.getCdoTrasp());
		}
		return ListaQuerys;
	}
	
	public ArticulosCarritoPedidoCompleto  ModificaCantidadesArticulos(List<Querys> listaQuerys,InfoCliente infoCliente,String articulo, int pedido,int Cantidad, boolean Inserta72Hr,int exietnciaCDO, int existenciaBR, int exietnciaTraspaso,
			float importe, String GeneraTraspaso, String cdoTraspaso)
	{
		ArticulosCarritoPedidoCompleto pedidoCompletoCarrito = new ArticulosCarritoPedidoCompleto();
		Connection connBD = null;

		PreparedStatement pstm= null;
		ResultSet rs= null;
		connBD = ConexionBD.abrirConexionBD();
		try
		{
			String[] querys = new String[25];	
			querys = Cls_Querys.LimpiaListaQuerys(querys);	
			// querys = Cls_Querys.ObtieneQuerys(43, listaQuerys, querys);
			querys = inicializaQueryNumero43(listaQuerys, infoCliente, articulo,pedido, Cantidad,Inserta72Hr,exietnciaCDO,existenciaBR,exietnciaTraspaso,importe, GeneraTraspaso, cdoTraspaso);
			
			pstm = connBD.prepareStatement("{call " + "comercio_electronico.usp_EXECUTE_QUERY(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
            
			rs=  EjecutaQuerysBD.EjecutarQuery(querys[0], querys[1],querys[2], querys[3], querys[4], querys[5], querys[6],
														 querys[7], querys[8], querys[9],querys[10], querys[11], querys[12], querys[13], 
														 querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], 
														 querys[21], querys[22], querys[23], querys[24], "",pstm, connBD);
			
			Cls_Querys.ImprimeQuerysConsola(querys,false,"Query 43");
            			
           
            
            if(rs != null)
			{
				pedidoCompletoCarrito.setEncabezadoPedido(llenaClaseEncabezadoArticulosCarrito(rs));
				pedidoCompletoCarrito.setDetallePedido(llenaClaseDetalleArticulosCarrito(infoCliente, rs));
			}
			
            
			 
		}
		catch(Exception ex)
		{
			System.out.println("[NuevoportalRamaCDO.- Error: Modificar Cantidades pedidas,  Clase: GestorMantenimientoCarritoComprasV2,  Detalle: " + ex.toString() +"]");
			Log log=new Log(1,infoCliente.getCve_cdo(),infoCliente.getCve_cliente() ,0, "[Error: Modificar Cantidades pedidas,  Clase: GestorMantenimientoCarritoComprasV2,  Detalle: " + ex.getMessage().toString() +"]");
			Cls_Log.insertaLog(log);
		}
		finally 
		{
			try {rs.close();} catch (SQLException e) {e.printStackTrace();}
			try {pstm.close();} catch (SQLException e) {e.printStackTrace();}
			try {connBD.close();} catch (SQLException e) {e.printStackTrace();}
		}

		return pedidoCompletoCarrito;
		
	}

	private String[] inicializaQueryNumero43(List<Querys> ListaQuerysT, InfoCliente infoCliente, String articulo,
			int pedido, int cantidad, boolean inserta72Hr, int exietnciaCDO, int existenciaBR, int exietnciaTraspaso,
			float importe, String GeneraTraspaso, String cdoTraspaso) {
		String[] ListaQuerys = new String[25];
		ListaQuerys = Cls_Querys.LimpiaListaQuerys(ListaQuerys);	
		try {
	 
		int c = 0;
		for (int i = 0; i < ListaQuerysT.size(); i++) {
			if (ListaQuerysT.get(i).getIndice_query() == 43) {
			 
				ListaQuerys[c] = ListaQuerysT.get(i).getQuery();
				
				ListaQuerys[c] = ListaQuerys[c].replace("{CVE_CENTRO}", String.valueOf(infoCliente.getCentro()));
				ListaQuerys[c] = ListaQuerys[c].replace("{CVE_CLIENTE}", String.valueOf(infoCliente.getCve_cliente()));
				ListaQuerys[c] = ListaQuerys[c].replace("{NUMERO_PEDIDO}", String.valueOf(pedido));
				ListaQuerys[c] = ListaQuerys[c].replace("{ARTICULO}", articulo);
				ListaQuerys[c] = ListaQuerys[c].replace("{UNAME}", String.valueOf(infoCliente.getUname_cdo()));
				ListaQuerys[c] = ListaQuerys[c].replace("{PRECIO_UNI}", String.valueOf(importe));
				int CantidadSurtida = exietnciaCDO + existenciaBR;
				ListaQuerys[c] = ListaQuerys[c].replace("{CANT_PEDIDO_CDO}", String.valueOf(cantidad));
				ListaQuerys[c] = ListaQuerys[c].replace("{CANT_SURT_CDO}", String.valueOf(exietnciaCDO));
				ListaQuerys[c] = ListaQuerys[c].replace("{CANT_SURT_BR}", String.valueOf(existenciaBR));
				float importeArticulo = importe * CantidadSurtida;
				ListaQuerys[c] = ListaQuerys[c].replace("{IMPORTE}", String.valueOf(importeArticulo));
				ListaQuerys[c] = ListaQuerys[c].replace("{TRASPASO}", GeneraTraspaso);
				ListaQuerys[c] = ListaQuerys[c].replace("{CDO_TRASPASO}", cdoTraspaso.toLowerCase());

				/* Para insertar traspso de 72 hrs */
				if (ListaQuerysT.get(i).getSub_indice_query() == 4) {
					if (inserta72Hr) {
						ListaQuerys[c] = ListaQuerys[c].replace("{CVE_CENTRO}",String.valueOf(infoCliente.getCentro()));
						ListaQuerys[c] = ListaQuerys[c].replace("{CVE_CLIENTE}",String.valueOf(infoCliente.getCve_cliente()));
						ListaQuerys[c] = ListaQuerys[c].replace("{UNAME}", String.valueOf(infoCliente.getUname_cdo()));
						ListaQuerys[c] = ListaQuerys[c].replace("{ARTICULO}", articulo);
						ListaQuerys[c] = ListaQuerys[c].replace("{CANT_PEDIDO_72h}", String.valueOf(exietnciaTraspaso));
						ListaQuerys[c] = ListaQuerys[c].replace("{PRECIO_UNI}", String.valueOf(importe));
						float importeArticulo72 = importe * exietnciaTraspaso;
						ListaQuerys[c] = ListaQuerys[c].replace("{IMPORTE}", String.valueOf(importeArticulo72));
						ListaQuerys[c] = ListaQuerys[c].replace("{CDO_TRASPASO}", cdoTraspaso.toLowerCase());
					} else {
						ListaQuerys[c] = "SET @NUM_PEDIDO=0;";
					}
				}
				c ++;
			}
			
		}
		
		}
		catch(Exception e)
		{
			//System.out.println("Error inicializaQueryNumero43: " + e.toString()) ;	
		} 
		return ListaQuerys;
	}
	
	private String formatDecimal(double number) {
		/*  float epsilon = 0.004f; // 4 tenths of a cent
		  if (Math.abs(Math.round(number) - number) < epsilon) {
			  
			  System.out.println( "formatDecimal: " + String.format("%10.0f", number) );
		     return String.format("%10.0f", number); // sdb
		  } else {
			  System.out.println("formatDecimal : " +String.format("%10.2f", number));
		     return String.format("%10.2f", number); // dj_segfault
		  }*/
		
		Locale usa = new Locale("en", "US");
		// Create a Currency instance for the Locale
		Currency dollars = Currency.getInstance(usa);
		// Create a formatter given the Locale
		NumberFormat dollarFormat = NumberFormat.getCurrencyInstance(usa);
		//77System.out.println(dollars.getDisplayName() + ": " + dollarFormat.format(number));
		return  dollarFormat.format(number);
		}
	
	
	private void EnvioDeDorreo72Hrs(List<Querys> listaQuerys, InfoCliente infoCliente, int  pedidoActualizado) {
		GestorEnvioCorreo72hrs gtr = new GestorEnvioCorreo72hrs();
		gtr.enviarCorreo(listaQuerys, infoCliente,  pedidoActualizado);
	}
	
}
