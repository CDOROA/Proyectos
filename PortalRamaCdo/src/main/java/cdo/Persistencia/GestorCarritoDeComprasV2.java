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
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Properties;
import java.util.function.Function;
import java.util.stream.Collectors;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrQuery.ORDER;
import org.apache.solr.client.solrj.SolrRequest.METHOD;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.apache.zookeeper.server.ExitCode;
import org.json.JSONArray;
import org.json.JSONObject;

import cdo.Datos.Articulos;
import cdo.Datos.CdosTraspasosEmergencia;
import cdo.Datos.DetalleArticulo;
import cdo.Datos.ExistenciasPorArticulo;
import cdo.Datos.ExistenciasPorCDO;
import cdo.Datos.InfoCliente;
import cdo.Datos.LineasDescuentoFijo;
import cdo.Datos.Log;
import cdo.Datos.Querys;
import cdo.Datos.SubMarcas;
import cdo.Datos.SugerenciaBusqueda;
import cdo.Datos.Vacantes;
import cdo.Datos.listaNegraArticulos;
import cdo.Util.Cls_Log;
import cdo.Util.Cls_MetodosGlobales;
import cdo.Util.Cls_Querys;
import cdo.Util.ConexionBD;
import cdo.Util.EjecutaQuerysBD;

public class GestorCarritoDeComprasV2 
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
	
	  private static SolrClient CLIENTE_SOLR = new HttpSolrClient.Builder(properties.getProperty("URL_SEVIDOR_SOLR")).build();
	 private static SolrClient CLIENTE_SOLR_APLICACIONES = new HttpSolrClient.Builder(properties.getProperty("URL_SEVIDOR_SOLR_APLICACION")).build();
	 
	/******   TIPOS DE  CONSULTA DE ARTICULOS    ******/
	public List<Articulos> consultaGeneralArticulos(List<Querys> listaQuerys, InfoCliente infoCliente, String descArticulo, List<LineasDescuentoFijo> lineasDesFijo, List<CdosTraspasosEmergencia> listaCdosTraspaso)
	{	
		List<Articulos> listaArticulos = new ArrayList<>(); 
		try
		{

			SolrDocumentList resultadosArt = qryConsultaGeneralAticulosEnSolrAPLICACION(descArticulo, infoCliente);

			List<String> lista  = llenaListaeArticulosDesdeSolrAplicacion(resultadosArt,infoCliente);

			Log log=new Log(1,infoCliente.getCve_cdo(),infoCliente.getCve_cliente() ,0, "[Accion: Consulta general de articulos, Parametro:  " + descArticulo +". Registros encontrados En solr APLICACION: "+ lista.size() +" ]");
			Cls_Log.insertaLog(log);

			SolrDocumentList resultados = qryConsultaGeneralAticulosEnSolr(lista, infoCliente);

			listaArticulos= llenaClaseArticulos2(resultados, descArticulo, lineasDesFijo, listaCdosTraspaso, infoCliente, true,lista);

		}
		catch(Exception  ex)
		{
			 listaArticulos = new ArrayList<>();
			Articulos art = new Articulos();
			listaArticulos.add(art);
			// System.out.println("[NuevoportalRamaCDO.- Error: Consulta general de articulos consultaGeneralArticulos(),  Clase: GestorCarritoDeComprasv2.consultaGeneralArticulos,  Detalle: " + ex.toString() +"]");
			Log log=new Log(1,infoCliente.getCve_cdo(),infoCliente.getCve_cliente() ,0, "[Error: Consulta general de articulos,  Clase: GestorCarritoDeComprasv2.consultaGeneralArticulos,  Detalle: " + ex.getMessage().toString() +"]");
			Cls_Log.insertaLog(log);
			Articulos articulo= new Articulos();
			listaArticulos.add(0,articulo);
		}
		return listaArticulos;
	}
	
	private void insertarLog(List<Querys> listaQuerys, String descArticulo, InfoCliente infoCliente, int articulos) 
	{
		Connection connBD = null;
		PreparedStatement pstm= null;
		connBD = ConexionBD.abrirConexionBD();
		try
		{
			String[] querys = new String[25];		
			querys = Cls_Querys.LimpiaListaQuerys(querys);	
			querys = Cls_Querys.ObtieneQuerys(40, listaQuerys, querys);
			querys = inicializaQueryNumero40(querys, descArticulo,infoCliente,articulos);
			pstm = connBD.prepareStatement("{call " + "comercio_electronico.usp_EXECUTE_QUERY(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			ResultSet rs=  EjecutaQuerysBD.EjecutarQuery(querys[0], querys[1],querys[2], querys[3], querys[4], querys[5], querys[6],
														 querys[7], querys[8], querys[9],querys[10], querys[11], querys[12], querys[13], 
														 querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], 
														 querys[21], querys[22], querys[23], querys[24], "",pstm, connBD);
			
			Cls_Querys.ImprimeQuerysConsola(querys,false,"Query 40");
		}
		catch (Exception e) 
		{
			System.out.println("NuevoportalRamaCDO.- Error al insertar log buesqueda cliente. "+e.getMessage().toString());
		}	
		finally
		{
			try {connBD.close();} catch (SQLException e) {e.printStackTrace();}
			try {pstm.close();} catch (SQLException e) {e.printStackTrace();}
		}
	}
	
	private String[] inicializaQueryNumero40(String[] ListaQuerys, String articulo, InfoCliente infoCliente, int articulos) 
	{
		for (int i=0;i <ListaQuerys.length; i++)
		{
			ListaQuerys[i]= ListaQuerys[i].replace("{CVE_CENTRO}",String.valueOf(infoCliente.getCentro()));
			ListaQuerys[i]= ListaQuerys[i].replace("{CANTIDAD}", String.valueOf(articulos));
			ListaQuerys[i]= ListaQuerys[i].replace("{CLIENTE}", String.valueOf(infoCliente.getCve_cliente()));
			ListaQuerys[i]= ListaQuerys[i].replace("{ACCION}", articulo);
		}
		return ListaQuerys;	
	}

	public List<Articulos> consultaArtNuevos(List<Querys> listaQuerys, InfoCliente infoCliente, List<LineasDescuentoFijo> lineasDesFijo, List<CdosTraspasosEmergencia> listaCdosTraspaso)
	{	
		List<Articulos> listaArticulos = new ArrayList<>(); 
		try
		{
			SolrDocumentList resultadosArt = qryConsultaArticulosNuevos(infoCliente);
			listaArticulos = llenaClaseArticulos(resultadosArt, "", lineasDesFijo, listaCdosTraspaso, infoCliente, false);			
			Log log=new Log(1,infoCliente.getCve_cdo(),infoCliente.getCve_cliente() ,0, "[Accion: Consultar articulos nuevos. ]");
			Cls_Log.insertaLog(log);
		}
		catch(Exception  ex)
		{
			Articulos art = new Articulos();
			listaArticulos.add(art);
			//System.out.println("[NuevoportalRamaCDO.- Error: Consulta  de articulos por marca de calidad,  Clase: GestorCarritoDeCompras,  Detalle: " + ex.getMessage().toString() +"]");
			Log log=new Log(01,infoCliente.getCve_cdo(),infoCliente.getCve_cliente() ,0, "[Error: Consulta  de articulos por marca de calidad,  Clase: GestorCarritoDeComprasV2.consultaArtNuevos,  Detalle: " + ex.getMessage().toString() +"]");
			Cls_Log.insertaLog(log);
		}
		return listaArticulos;
	}
	
	public List<Articulos> consultaPorMarcaArticulos(List<Querys> listaQuerys, InfoCliente infoCliente, String descMarca, List<LineasDescuentoFijo> lineasDesFijo, List<CdosTraspasosEmergencia> listaCdosTraspaso)
	{	
		List<Articulos> listaArticulos = new ArrayList<>(); 
		try
		{
			SolrDocumentList resultadosArt = qryConsultaXMarcaAticulosEnSolr(descMarca, infoCliente);
			listaArticulos = llenaClaseArticulos(resultadosArt, descMarca, lineasDesFijo, listaCdosTraspaso, infoCliente, false);			
			Log log=new Log(1,infoCliente.getCve_cdo(),infoCliente.getCve_cliente() ,0, "[Accion: Consultar articulos por marca de calidad, Marca:  " + descMarca + "  ]");
			Cls_Log.insertaLog(log);
		}
		catch(Exception  ex)
		{
			System.out.println("[NuevoportalRamaCDO.- Error: Consulta  de articulos por marca de calidad,  Clase: GestorCarritoDeCompras,  Detalle: " + ex.getMessage().toString() +"]");
			Log log=new Log(01,infoCliente.getCve_cdo(),infoCliente.getCve_cliente() ,0, "[Error: Consulta  de articulos por marca de calidad,  Clase: GestorCarritoDeCompras,  Detalle: " + ex.getMessage().toString() +"]");
			Cls_Log.insertaLog(log);
		}
		return listaArticulos;
	}
	
	public List<Articulos> consultaPorVehiculo(List<Querys> listaQuerys, InfoCliente infoCliente, String descMarca, String descAuto, String descModelo, String cilindros ,String litros,  List<LineasDescuentoFijo> lineasDesFijo, List<CdosTraspasosEmergencia> listaCdosTraspaso)
	{	
		List<Articulos> listaArticulos = new ArrayList<>(); 
		try
		{
			SolrDocumentList resultadosArt = qryConsultaAutomovilAticulosEnSolr(descMarca,descAuto,descModelo, cilindros ,litros, infoCliente);
			listaArticulos = llenaClaseArticulos(resultadosArt, descMarca, lineasDesFijo, listaCdosTraspaso, infoCliente, false);
			Log log=new Log(1,infoCliente.getCve_cdo(),infoCliente.getCve_cliente() ,0, "[Accion: Consultar articulos por vehiculo, Marca:  " + descMarca + ", Auto: " + descAuto +  ", Modelo: " + descModelo +  ", cilindros: " + cilindros +  ", Litros: " + litros + "  ]");
			Cls_Log.insertaLog(log);
		}
		catch(Exception  ex)
		{
			System.out.println("[NuevoportalRamaCDO.- Error: Consultar articulos por vehiculo,  Clase: GestorCarritoDeCompras,  Detalle: " + ex.getMessage().toString() +"]");
			Log log=new Log(01,infoCliente.getCve_cdo(),infoCliente.getCve_cliente() ,0, "[Error: Consultar articulos por vehiculo,  Clase: GestorCarritoDeCompras,  Detalle: " + ex.getMessage().toString() +"]");
			Cls_Log.insertaLog(log);
		}
		return listaArticulos;
	}
	
	/******   TIPOS DE  CONSULTA DE ARTICULOS    ******/
	public List<Articulos> consultaArticulo(List<Querys> listaQuerys, InfoCliente infoCliente, String descArticulo, List<LineasDescuentoFijo> lineasDesFijo, List<CdosTraspasosEmergencia> listaCdosTraspaso)
	{	
		List<Articulos> listaArticulos = new ArrayList<>(); 
		try
		{

			SolrDocumentList resultadosArt = qryConsultaAticuloEnSolr(descArticulo, infoCliente);
			listaArticulos= llenaClaseArticulos(resultadosArt, descArticulo, lineasDesFijo, listaCdosTraspaso, infoCliente, true);
			Log log=new Log(1,infoCliente.getCve_cdo(),infoCliente.getCve_cliente() ,0, "[Accion: Consulta articulo Marca Propia, Parametro:  " + descArticulo +" ]");
			Cls_Log.insertaLog(log);
		}
		catch(Exception  ex)
		{
			System.out.println("[NuevoportalRamaCDO.- Error: Consulta general de articulos consultaArticulo,  Clase: GestorCarritoDeComprasv2.consultaArticulo,  Detalle: " + ex.getMessage().toString() +"]");
			Log log=new Log(1,infoCliente.getCve_cdo(),infoCliente.getCve_cliente() ,0, "[Error: Consulta general de articulos,  Clase: GestorCarritoDeCompras,  Detalle: " + ex.getMessage().toString() +"]");
			Cls_Log.insertaLog(log);
		}
		return listaArticulos;
	}
	
	/******    FORMA QUERYS SEGUN LA BUSQUEDA DE ARTICULOS  APLICACION  ******/
	private SolrDocumentList qryConsultaGeneralAticulosEnSolrAPLICACION(String descArticulo, InfoCliente infoCliente)
	{

		SolrDocumentList resultadosArt = null;		
		try
		{
			 
			String sentencia = "";

				if(descArticulo.trim().length() > 0)
				{
 					sentencia +=   "( a_num_art_cdo:" + descArticulo.replace(" ", "_")+"*" + 
							" OR a_criterio_descripcion_submodelo_anio:" + descArticulo.replace(" ", "_") + 
							" OR a_criterio_submodelo_descripcion_anio:" + descArticulo.replace(" ", "_") + 
							" OR a_criterio_anio_submodelo_descripcion:" + descArticulo.replace(" ", "_") + 
							" OR a_criterio_descripcion_anio_submodelo:" + descArticulo.replace(" ", "_") + 
							" OR a_criterio_anio_descripcion_submodelo:" + descArticulo.replace(" ", "_") + 
							" OR a_criterio_submodelo_descripcion:" + descArticulo.replace(" ", "_") + 
							" OR a_criterio_descripcion_submodelo:" + descArticulo.replace(" ", "_") +  
							" OR a_criterio_descripcion_anio:" + descArticulo.replace(" ", "_") + 
							" OR a_criterio_anio_descripcion:" + descArticulo.replace(" ", "_") + 
							" OR a_criterio_submodelo_anio:" + descArticulo.replace(" ", "_") + 
							" OR a_criterio_anio_submodelo: " + descArticulo.replace(" ", "_") +
							" )";
 
				}
				
	
 
			SolrQuery  query = new SolrQuery();
			query.setStart(0);
			query.setRows(10000);
		 
			// query.setSort("a_orden", ORDER.asc);
			// query.addSort("nombre_producto", ORDER.asc);
			// String rnk = "a_"+ infoCliente.getUname_cdo().toLowerCase() +  "_rnk";
			// query.addSort( rnk, ORDER.asc);
			//query.addSort("num_art_cdo", ORDER.asc);
			query.setQuery(sentencia);
			QueryResponse respuestaSolr = CLIENTE_SOLR_APLICACIONES.query(query, METHOD.POST);
	       resultadosArt = respuestaSolr.getResults();
	       
           // System.out.println("CLIENTE_SOLR_APLICACIONES Query: " + query);
	       Log log=new Log(01,infoCliente.getCve_cdo(),infoCliente.getCve_cliente() ,0, "CLIENTE_SOLR_APLICACIONES Query: " + query);
			Cls_Log.insertaLog(log);
			 
		}
		catch(Exception ex)
		{
			//System.out.println("[NuevoportalRamaCDO.- Error: Consultar articulos por parametro en Solr APLICACION,  Clase: GestorCarritoDeCompras.qryConsultaGeneralAticulosEnSolrAPLICACION,  Detalle: " + ex.getMessage().toString() +"]");
			Log log=new Log(01,infoCliente.getCve_cdo(),infoCliente.getCve_cliente() ,0, "[NuevoportalRamaCDO.- Error: Consultar articulos por parametro en Solr APLICACION,  Clase: GestorCarritoDeComprasV2.qryConsultaGeneralAticulosEnSolrAPLICACION,  Detalle: " + ex.getMessage().toString() +"]");
			Cls_Log.insertaLog(log);
			resultadosArt = new SolrDocumentList();
		}
		return resultadosArt;
	}
	
	
	/******    FORMA QUERYS SEGUN LA BUSQUEDA DE ARTICULOS    ******/
	private SolrDocumentList qryConsultaGeneralAticulosEnSolr(List<String> lista, InfoCliente infoCliente)
	{

		SolrDocumentList resultadosArt = null;		
		try
		{
			String sentencia = "";
			for (int i=0; i <  lista.size(); i++) 
			{
		 
				if(lista.get(i).replace("-", "").trim().length() > 0)
				{
					if(i > 0 && !sentencia.equals(""))
					{
						sentencia += " and ";
					}
					sentencia +=   "(id:" + lista.get(i).replace("[", "").replace("]", "") +
								
								     " or intercambios_sin_guion:" + lista.get(i).replace("[", "").replace("]", "").replace("-", "") ;
								
								   // " OR a_proveedor:" + lista.get(i).replace("-", "") +
								   // " OR a_descripcion:" + lista.get(i).replace("-", "") +
								   // " OR a_modelo:" + lista.get(i).replace("-", "") +
								   // " OR a_submodelo:" + lista.get(i).replace("-", "") +
					 			   // " OR a_cilindros:" + lista.get(i).replace("-", "") +
					 			   // " OR a_litros:" + lista.get(i).replace("-", "") ;
					 sentencia += ")";

				}
				
			}
			SolrQuery  query = new SolrQuery();
			query.setStart(0);
			query.setRows(1000);
			query.setSort("orden", ORDER.asc);
			 
			// query.addSort("nombre_producto", ORDER.asc);
			String rnk =  infoCliente.getUname_cdo().toLowerCase() +  "_rnk";
			query.addSort( rnk, ORDER.asc);
			//query.addSort("num_art_cdo", ORDER.asc);
			query.setQuery(sentencia);
			
			 QueryResponse respuestaSolr = CLIENTE_SOLR.query(query,METHOD.POST);
			 
	        resultadosArt = respuestaSolr.getResults();	  
		}
		catch(Exception ex)
		{
			System.out.println("[NuevoportalRamaCDO.- Error: Consultar articulos por parametro en Solr,  Clase: GESTOR-2.qryConsultaGeneralAticulosEnSolr,  Detalle: " + ex.getMessage().toString() +"]");
			Log log=new Log(01,infoCliente.getCve_cdo(),infoCliente.getCve_cliente() ,0, "[Error: Consultar articulos por parametro en Solr,  Clase: GESTOR-2.qryConsultaGeneralAticulosEnSolr,  Detalle: " + ex.getMessage().toString() +"]");
			Cls_Log.insertaLog(log);
			resultadosArt = new SolrDocumentList();	
		}
		return resultadosArt;
	}

	private SolrDocumentList qryConsultaArticulosNuevos(InfoCliente infoCliente)
	{
		SolrDocumentList resultadosArt = null;		
		try
		{
			 
			String sentencia = "rk:N"; 
								
			SolrQuery  query = new SolrQuery();
			query.setStart(0);
			query.setRows(1000);
			query.setSort("orden", ORDER.asc);
			String rnk =  infoCliente.getUname_cdo().toLowerCase() +  "_rnk";
			query.addSort( rnk, ORDER.asc);
			query.setQuery(sentencia);
			QueryResponse respuestaSolr = CLIENTE_SOLR.query(query,  METHOD.POST);
	        resultadosArt = respuestaSolr.getResults();
	        
		}
		catch(Exception ex)
		{
			System.out.println("[NuevoportalRamaCDO.- Error: Consultar articulos por marca en Solr,  Clase: GestorCarritoDeCompras,  Detalle: " + ex.getMessage().toString() +"]");
			Log log=new Log(01,infoCliente.getCve_cdo(),infoCliente.getCve_cliente() ,0, "[Error: Consultar articulos por marca en Solr,  Clase: GestorCarritoDeCompras,  Detalle: " + ex.getMessage().toString() +"]");
			Cls_Log.insertaLog(log);
			resultadosArt = new SolrDocumentList();
		}
		return resultadosArt;
	}
	
	private SolrDocumentList qryConsultaXMarcaAticulosEnSolr(String descMarca,InfoCliente infoCliente)
	{
		SolrDocumentList resultadosArt = null;		
		try
		{
		 
			String sentencia = "marca:" + descMarca+
								" OR proveedor:" + descMarca;
			SolrQuery  query = new SolrQuery();
			query.setStart(0);
			query.setRows(1000);
			query.setSort("orden", ORDER.asc);
			//query.addSort("nombre_producto", ORDER.asc);
			// query.addSort("rk", ORDER.asc);
			String rnk =  infoCliente.getUname_cdo().toLowerCase() +  "_rnk";
			query.addSort( rnk, ORDER.asc);
			//query.addSort("num_art_cdo", ORDER.asc);
			query.setQuery(sentencia);
			QueryResponse respuestaSolr = CLIENTE_SOLR.query(query,  METHOD.POST);
	        resultadosArt = respuestaSolr.getResults();
	      
		}
		catch(Exception ex)
		{
			System.out.println("[NuevoportalRamaCDO.- Error: Consultar articulos por marca en Solr,  Clase: GestorCarritoDeCompras,  Detalle: " + ex.getMessage().toString() +"]");
			Log log=new Log(01,infoCliente.getCve_cdo(),infoCliente.getCve_cliente() ,0, "[Error: Consultar articulos por marca en Solr,  Clase: GestorCarritoDeCompras,  Detalle: " + ex.getMessage().toString() +"]");
			Cls_Log.insertaLog(log);
			resultadosArt = new SolrDocumentList();
		}
		return resultadosArt;
	}
	
	private SolrDocumentList qryConsultaAutomovilAticulosEnSolr(String descMarca,String descAuto, String descModelo, String cilindros ,String litros, InfoCliente infoCliente)
	{
		SolrDocumentList resultadosArt = null;		
		try
		{
		 
			
			String sentencia ="";
			if(!descMarca.equals("-- Marca --"))
			{
				sentencia += "armadora:" + descMarca; 
			}
			
			if(!descAuto.equals("0"))
			{
				if(sentencia.length() > 0)
				{
					sentencia +=" AND ";
				}
				sentencia+="modelo:" + descAuto;
			}
			
			if(!descModelo.equals("0"))
			{
				if(sentencia.length() > 0)
				{
					sentencia +=" AND ";
				}
				sentencia+= "(anio:[" + descModelo + " TO *] AND anio: [* TO " + (Integer.parseInt(descModelo) + 1)+ "])" ;
			}
			
			if(!cilindros.equals("0"))
			{
				if(sentencia.length() > 0)
				{
					sentencia +=" AND ";
				}
				sentencia+= "cilindros:" + cilindros;
			}
			
			if(!litros.equals("0"))
			{
				if(sentencia.length() > 0)
				{
					sentencia +=" AND ";
				}
				sentencia+= "litros:" + litros;
			}
			
			SolrQuery  query = new SolrQuery();
			query.setStart(0);
			query.setRows(1000);
			query.setSort("orden", ORDER.asc);
			//query.addSort("nombre_producto", ORDER.asc);
			//query.addSort("rk", ORDER.asc);
			String rnk =  infoCliente.getUname_cdo().toLowerCase() +  "_rnk";
			query.addSort( rnk, ORDER.asc);
			//query.addSort("num_art_cdo", ORDER.asc);
			query.setQuery(sentencia);
			QueryResponse respuestaSolr = CLIENTE_SOLR.query(query,  METHOD.POST);
	        resultadosArt = respuestaSolr.getResults();
	     
		}
		catch(Exception ex)
		{
			System.out.println("[NuevoportalRamaCDO.- Error: Consultar articulos por automovil en Solr,  Clase: GestorCarritoDeCompras,  Detalle: " + ex.getMessage().toString() +"]");
			Log log=new Log(01,infoCliente.getCve_cdo(),infoCliente.getCve_cliente() ,0, "[Error: Consultar articulos por automovil en Solr,  Clase: GestorCarritoDeCompras,  Detalle: " + ex.getMessage().toString() +"]");
			Cls_Log.insertaLog(log);
			resultadosArt = new SolrDocumentList();
			
		}
		return resultadosArt;
	}
	private static String getTwoDecimals(String valor){
	    DecimalFormat df = new DecimalFormat("0.00");
	    return df.format(Double.parseDouble(valor));
	}
	
	/******  LLENA CLASE DE ARTICULOS   ******/
	private List<Articulos> llenaClaseArticulos(SolrDocumentList resultadosArt,  String descArticulo, List<LineasDescuentoFijo> lineasDesFijo, List<CdosTraspasosEmergencia> listaCdosTraspaso, InfoCliente infoCliente, boolean validaCombioNumero)
	{
		List<Articulos> listaArticulos = new ArrayList<>();
		try
		{
			String cambioNumeroNuevo="";	
			for (int i = 0; i < resultadosArt.size(); ++i) 
	        {   
				if(!resultadosArt.get(i).getFieldValue("vigencia").toString().trim().equals("*"))
				{
                     // EL calculo de los descuentos se pasa a la pantalla final.
				    //  String preciolista= calculaPrecioListaXCliente(resultadosArt.get(i).getFieldValue("precio").toString(),resultadosArt.get(i).getFieldValue("marca").toString(),infoCliente, lineasDesFijo,infoCliente);	
					 String preciolista= resultadosArt.get(i).getFieldValue("precio").toString();
					// System.out.println("preciolista: " + preciolista);
					String arrayFoto[] = resultadosArt.get(i).getFieldValue("imagen_ecommerce").toString().replace("[", "").replace("]", "").trim().split(",");
		        	String anios=  "";
		        			if (resultadosArt.get(i).getFieldValue("anio").toString().contains(",")) 
				        	{
				        		anios = resultadosArt.get(i).getFieldValue("anio").toString().substring(0, 5) + resultadosArt.get(i).getFieldValue("anio").toString().substring((resultadosArt.get(i).getFieldValue("anio").toString().length() - 6) ,  resultadosArt.get(i).getFieldValue("anio").toString().length() );	
							}
				        	else
				        	{
				        		anios = resultadosArt.get(i).getFieldValue("anio").toString();
				        	}
		        	Articulos articulo= new Articulos();

					articulo.setAnio(anios.replace(" ", " - "));
					articulo.setTipo_catalogo(resultadosArt.get(i).getFieldValue("tipo_catalogo").toString());
					articulo.setPrecio_iva(String.valueOf(getTwoDecimals(String.valueOf(Float.parseFloat(preciolista)*1.16))));
					
					articulo.setArmadora(resultadosArt.get(i).getFieldValue("armadora").toString());
					articulo.setCilindros(resultadosArt.get(i).getFieldValue("cilindros").toString().replace("[","").replace("]", ""));
			
					articulo.setDescripcion(validaNombreProducto(resultadosArt.get(i).getFieldValue("descripcion").toString()).toString().replace("[","").replace("]", ""));
					
					articulo.setNombre_producto(resultadosArt.get(i).getFieldValue("nombre_producto").toString());
					articulo.setGrupo(resultadosArt.get(i).getFieldValue("grupo").toString());
					articulo.setDescripcion_producto(String.valueOf(resultadosArt.get(i).getFieldValue("descripcion_producto")));
					articulo.setTipo_gasolina(String.valueOf(resultadosArt.get(i).getFieldValue("tipo_gasolina")));
					articulo.setCaracteristicas(String.valueOf(resultadosArt.get(i).getFieldValue("caracteristicas")).replace("[","").replace("]", ""));
					articulo.setLitros(resultadosArt.get(i).getFieldValue("litros").toString().toString().replace("[","").replace("]", ""));
					articulo.setMarca(resultadosArt.get(i).getFieldValue("marca").toString());
	
					articulo.setModelo(resultadosArt.get(i).getFieldValue("modelo").toString());
					articulo.setMultiplo_venta(Integer.parseInt(resultadosArt.get(i).getFieldValue("multiplo_venta").toString()));
			
					articulo.setNum_art_cdo(resultadosArt.get(i).getFieldValue("num_art_cdo").toString());
					articulo.setNum_art_prov(resultadosArt.get(i).getFieldValue("num_art_prov").toString());
			
					articulo.setNum_original(resultadosArt.get(i).getFieldValue("num_original").toString());
					articulo.setPosicion(resultadosArt.get(i).getFieldValue("posicion").toString().toString().replace("[","").replace("]", ""));
		
					articulo.setPrecio(formatoDecimal.format(Double.parseDouble(preciolista)));
					articulo.setPrecio_real(Double.parseDouble(resultadosArt.get(i).getFieldValue("precio").toString()));
			
					articulo.setProveedor(resultadosArt.get(i).getFieldValue("proveedor").toString());
					articulo.setRk(resultadosArt.get(i).getFieldValue("rk").toString());
				
					articulo.setSubmodelo(resultadosArt.get(i).getFieldValue("submodelo").toString().replace("[","").replace("]", ""));
					articulo.setTransmision(resultadosArt.get(i).getFieldValue("transmision").toString().replace(",", " , ").replace("[","").replace("]", ""));
				
					articulo.setCambioNumero(cambioNumeroNuevo);
					articulo.setOrdenamiento(resultadosArt.get(i).getFieldValue("orden").toString());
			
					articulo.setImagen_bxa(resultadosArt.get(i).getFieldValue("imagen_bxa").toString().replace("[", "").replace("]", ""));
					articulo.setImagen_ecommerce(resultadosArt.get(i).getFieldValue("imagen_ecommerce").toString().replace("[", "").replace("]", ""));
		
					articulo.setIntercambios(resultadosArt.get(i).getFieldValue("intercambios").toString());
					articulo.setIntercambio_sin_guion(resultadosArt.get(i).getFieldValue("intercambios_sin_guion").toString());
				
					articulo.setNum_art_anterior(resultadosArt.get(i).getFieldValue("num_art_anterior").toString().replace("[", "").replace("]", "").trim());				
					articulo.setVigencia(resultadosArt.get(i).getFieldValue("vigencia").toString().trim());
					
					articulo.setNum_art_marca_propia(resultadosArt.get(i).getFieldValue("num_art_marca_propia").toString().trim());
					articulo.setVarianza_marca_propia(Double.parseDouble(resultadosArt.get(i).getFieldValue("varianza_marca_propia").toString()));

					articulo.setMarcaIntercambio(validaSiEsIntercambio(descArticulo,resultadosArt.get(i).getFieldValue("intercambios_sin_guion").toString(), 
																	 resultadosArt.get(i).getFieldValue("num_art_cdo").toString().replace("-", ""),
																	 resultadosArt.get(i).getFieldValue("num_art_anterior").toString().replace("[", "").replace("]", "").trim().replace("-", "")));
 
					
					if(validaOrdenamiento(descArticulo, resultadosArt.get(i).getFieldValue("num_art_cdo").toString().replace("-", "")).equals("*") ||
					   validaOrdenamiento(descArticulo, resultadosArt.get(i).getFieldValue("num_art_anterior").toString().replace("[", "").replace("]", "").trim().replace("-", "")).equals("*"))
					{
						listaArticulos.add(0,articulo);
					}
					else
					{
						listaArticulos.add(articulo);
					}
				}				
	        } 
		}
		catch(Exception ex)
		{
			System.out.println("[NuevoportalRamaCDO.- Error: Llenar clase de Articulos con Solr ,  Clase: GestorCarritoDeCompras,  Detalle: " + ex.getMessage().toString() +"]");
			Log log=new Log(01,infoCliente.getCve_cdo(),infoCliente.getCve_cliente() ,0, "[Error: Llenar clase de Articulos con Solr,  Clase: GestorCarritoDeCompras,  Detalle: " + ex.getMessage().toString() +"]");
			Cls_Log.insertaLog(log);
		}
		return listaArticulos;
	}
	
	private List<Articulos> llenaClaseArticulos2(SolrDocumentList resultadosArt,  String descArticulo, List<LineasDescuentoFijo> lineasDesFijo, List<CdosTraspasosEmergencia> listaCdosTraspaso, InfoCliente infoCliente, boolean validaCombioNumero, List<String>  lista )
	{
		List<Articulos> listaArticulos = new ArrayList<>();
		try
		{
			String cambioNumeroNuevo="";	
			for (int i = 0; i < resultadosArt.size(); ++i) 
	        {   
				if(!resultadosArt.get(i).getFieldValue("vigencia").toString().trim().equals("*"))
				{
                     // EL calculo de los descuentos se pasa a la pantalla final.
				    //  String preciolista= calculaPrecioListaXCliente(resultadosArt.get(i).getFieldValue("precio").toString(),resultadosArt.get(i).getFieldValue("marca").toString(),infoCliente, lineasDesFijo,infoCliente);	
					 String preciolista= resultadosArt.get(i).getFieldValue("precio").toString();
					// System.out.println("preciolista: " + preciolista);
					String arrayFoto[] = resultadosArt.get(i).getFieldValue("imagen_ecommerce").toString().replace("[", "").replace("]", "").trim().split(",");
		        	String anios=  "";
		        			if (resultadosArt.get(i).getFieldValue("anio").toString().contains(",")) 
				        	{
				        		anios = resultadosArt.get(i).getFieldValue("anio").toString().substring(0, 5) + resultadosArt.get(i).getFieldValue("anio").toString().substring((resultadosArt.get(i).getFieldValue("anio").toString().length() - 6) ,  resultadosArt.get(i).getFieldValue("anio").toString().length() );	
							}
				        	else
				        	{
				        		anios = resultadosArt.get(i).getFieldValue("anio").toString();
				        	}
		        	Articulos articulo= new Articulos();

					articulo.setAnio(anios.replace(" ", " - "));
					articulo.setTipo_catalogo(resultadosArt.get(i).getFieldValue("tipo_catalogo").toString());
					articulo.setPrecio_iva(String.valueOf(getTwoDecimals(String.valueOf(Float.parseFloat(preciolista)*1.16))));
					
					articulo.setArmadora(resultadosArt.get(i).getFieldValue("armadora").toString());
					articulo.setCilindros(resultadosArt.get(i).getFieldValue("cilindros").toString().replace("[","").replace("]", ""));
			
					articulo.setDescripcion(validaNombreProducto(resultadosArt.get(i).getFieldValue("descripcion").toString()).toString().replace("[","").replace("]", ""));
					
					articulo.setNombre_producto(resultadosArt.get(i).getFieldValue("nombre_producto").toString());
					articulo.setGrupo(resultadosArt.get(i).getFieldValue("grupo").toString());
					articulo.setDescripcion_producto(String.valueOf(resultadosArt.get(i).getFieldValue("descripcion_producto")));
					articulo.setTipo_gasolina(String.valueOf(resultadosArt.get(i).getFieldValue("tipo_gasolina")));
					articulo.setCaracteristicas(String.valueOf(resultadosArt.get(i).getFieldValue("caracteristicas")).replace("[","").replace("]", ""));
					articulo.setLitros(resultadosArt.get(i).getFieldValue("litros").toString().toString().replace("[","").replace("]", ""));
					articulo.setMarca(resultadosArt.get(i).getFieldValue("marca").toString());
	
					articulo.setModelo(resultadosArt.get(i).getFieldValue("modelo").toString());
					articulo.setMultiplo_venta(Integer.parseInt(resultadosArt.get(i).getFieldValue("multiplo_venta").toString()));
			
					articulo.setNum_art_cdo(resultadosArt.get(i).getFieldValue("num_art_cdo").toString());
					articulo.setNum_art_prov(resultadosArt.get(i).getFieldValue("num_art_prov").toString());
			
					articulo.setNum_original(resultadosArt.get(i).getFieldValue("num_original").toString());
					articulo.setPosicion(resultadosArt.get(i).getFieldValue("posicion").toString().toString().replace("[","").replace("]", ""));
		
					articulo.setPrecio(formatoDecimal.format(Double.parseDouble(preciolista)));
					articulo.setPrecio_real(Double.parseDouble(resultadosArt.get(i).getFieldValue("precio").toString()));
			
					articulo.setProveedor(resultadosArt.get(i).getFieldValue("proveedor").toString());
					articulo.setRk(resultadosArt.get(i).getFieldValue("rk").toString());
				
					articulo.setSubmodelo(resultadosArt.get(i).getFieldValue("submodelo").toString().replace("[","").replace("]", ""));
					articulo.setTransmision(resultadosArt.get(i).getFieldValue("transmision").toString().replace(",", " , ").replace("[","").replace("]", ""));
				
					articulo.setCambioNumero(cambioNumeroNuevo);
					articulo.setOrdenamiento(resultadosArt.get(i).getFieldValue("orden").toString());
			
					articulo.setImagen_bxa(resultadosArt.get(i).getFieldValue("imagen_bxa").toString().replace("[", "").replace("]", ""));
					articulo.setImagen_ecommerce(resultadosArt.get(i).getFieldValue("imagen_ecommerce").toString().replace("[", "").replace("]", ""));
		
					articulo.setIntercambios(resultadosArt.get(i).getFieldValue("intercambios").toString());
					articulo.setIntercambio_sin_guion(resultadosArt.get(i).getFieldValue("intercambios_sin_guion").toString());
				
					articulo.setNum_art_anterior(resultadosArt.get(i).getFieldValue("num_art_anterior").toString().replace("[", "").replace("]", "").trim());				
					articulo.setVigencia(resultadosArt.get(i).getFieldValue("vigencia").toString().trim());
					
					articulo.setNum_art_marca_propia(resultadosArt.get(i).getFieldValue("num_art_marca_propia").toString().trim());
					articulo.setVarianza_marca_propia(Double.parseDouble(resultadosArt.get(i).getFieldValue("varianza_marca_propia").toString()));

					/*articulo.setMarcaIntercambio(validaSiEsIntercambio(descArticulo,resultadosArt.get(i).getFieldValue("intercambios_sin_guion").toString(), 
																	 resultadosArt.get(i).getFieldValue("num_art_cdo").toString().replace("-", ""),
																	 resultadosArt.get(i).getFieldValue("num_art_anterior").toString().replace("[", "").replace("]", "").trim().replace("-", "")));
					*/
					articulo.setMarcaIntercambio(validaSiEsIntercambio2(lista,resultadosArt.get(i).getFieldValue("intercambios_sin_guion").toString(), 
							 resultadosArt.get(i).getFieldValue("num_art_cdo").toString().replace("-", ""),
							 resultadosArt.get(i).getFieldValue("num_art_anterior").toString().replace("[", "").replace("]", "").trim().replace("-", "")));
					
					
					articulo.setCve_venta(resultadosArt.get(i).getFieldValue("cve_venta").toString().replace("[", "").replace("]", "").trim());
					articulo.setMultiplo_rc(resultadosArt.get(i).getFieldValue("multiplo_rc").toString().replace("[", "").replace("]", "").trim());
					
					
					if(validaOrdenamiento(descArticulo, resultadosArt.get(i).getFieldValue("num_art_cdo").toString().replace("-", "")).equals("*") ||
					   validaOrdenamiento(descArticulo, resultadosArt.get(i).getFieldValue("num_art_anterior").toString().replace("[", "").replace("]", "").trim().replace("-", "")).equals("*"))
					{
						listaArticulos.add(0,articulo);
					}
					else
					{
						listaArticulos.add(articulo);
					}
				}				
	        } 
		}
		catch(Exception ex)
		{
			System.out.println("[NuevoportalRamaCDO.- Error: Llenar clase de Articulos con Solr llenaClaseArticulos2() ,  Clase: GestorCarritoDeCompras,  Detalle: " + ex.getMessage().toString() +"]");
			Log log=new Log(01,infoCliente.getCve_cdo(),infoCliente.getCve_cliente() ,0, "[Error: Llenar clase de Articulos con Solr,  Clase: GestorCarritoDeCompras,  Detalle: " + ex.getMessage().toString() +"]");
			Cls_Log.insertaLog(log);
		}
		return listaArticulos;
	}
	private List<String> llenaListaeArticulosDesdeSolrAplicacion(SolrDocumentList resultadosArt, InfoCliente infoCliente)
	{
		List<String> listaArticulos = new ArrayList<String>();
		String articuloAuxiliar ="";
		try
		{
		 
			Log log=new Log(01,infoCliente.getCve_cdo(),infoCliente.getCve_cliente() ,0, "solr Query resultadosArt: " +  resultadosArt.size());
			Cls_Log.insertaLog(log);
			for (int i = 0; i < resultadosArt.size(); ++i)
			
			{   
					if (!articuloAuxiliar.equalsIgnoreCase(resultadosArt.get(i).getFieldValue("a_id").toString()))
					{
						listaArticulos.add(resultadosArt.get(i).getFieldValue("a_id").toString().replace("[", "").replace("]", ""));
						articuloAuxiliar = resultadosArt.get(i).getFieldValue("a_id").toString();
					} 			
	        }			
		   	log=new Log(01,infoCliente.getCve_cdo(),infoCliente.getCve_cliente() ,0, "CLIENTE_SOLR_APLICACIONES listaArticulos: " + listaArticulos);
			Cls_Log.insertaLog(log);
			 
		}
		catch(Exception ex)
		{
			System.out.println("[NuevoportalRamaCDO.- Error: Llenar clase de Articulos con Solr ,  Clase: llenaListaeArticulosDesdeSolrAplicacion,  Detalle: " + ex.getMessage().toString() +"]");
			Log log=new Log(01,infoCliente.getCve_cdo(),infoCliente.getCve_cliente() ,0, "[Error: Llenar clase de Articulos con Solr,  Clase: llenaListaeArticulosDesdeSolrAplicacion,  Detalle: " + ex.getMessage().toString() +"]");
			Cls_Log.insertaLog(log);
			return listaArticulos;
		}
		return listaArticulos;
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
		
	/* ORDENAMIENTO */
	private String validaOrdenamiento(String descArticulo, String articuloSinGuion)
	{
		String arrayDesActr[]= descArticulo.split(" ");
		String arrayDescArt[] = articuloSinGuion.replace("[", "").replace("]", "").trim().split(",");
		String esNumExacto = "";
		for (int i=0; i <  arrayDesActr.length; i++) 
		{
			if(arrayDesActr[i].replace("-", "").trim().length() > 0)
			{
				for(int e = 0; e < arrayDescArt.length; e++)
				{
					if(arrayDescArt[e].equals(arrayDesActr[i].replace("-", "")))
					{
						esNumExacto="*";
						break;
					}
				}
			}
		}
		return esNumExacto;
	}
		
	/* INTERCAMBIOS*/
	private String validaSiEsIntercambio(String descArticulo, String intercambiosSinGuion, String numArtSinGuion, String numartAnterior)
	{
		String arrayDesActr[]= descArticulo.split(" ");
		String arrayDescIntercambios[] = intercambiosSinGuion.replace("[", "").replace("]", "").trim().split(",");
		String esIntercambio = "";
		for (int i=0; i <  arrayDesActr.length; i++) 
		{
			//System.out.println(" arrayDesActr: " + numArtSinGuion.replace("[", "").replace("]", "").trim().replace("-", "").trim()  );
			// if(arrayDesActr[i].replace("-", "").trim().length() > 0)
			if(numArtSinGuion.trim().length() > 0)
			
			{
				for(int e = 0; e < arrayDescIntercambios.length; e++)
				{
					//System.out.println("arrayDescIntercambios[e]: " + arrayDescIntercambios[e]  + " - " + numArtSinGuion.replace("[", "").replace("]", "").trim());
				 	if(arrayDescIntercambios[e].equals(arrayDesActr[i].replace("-", "")))
				///	if(arrayDescIntercambios[e].equals(numArtSinGuion.replace("[", "").replace("]", "").trim()))
					{
						//System.out.println("arrayDescIntercambios[e]: " + arrayDescIntercambios[e]  + " - " + numArtSinGuion.replace("[", "").replace("]", "").trim());
						 if(!arrayDescIntercambios[e].equals(numArtSinGuion.replace("[", "").replace("]", "").trim()) && !arrayDescIntercambios[e].equals(numartAnterior))
						///	if(!arrayDescIntercambios[e].equals(numArtSinGuion.replace("[", "").replace("]", "").trim()))
						{
							esIntercambio="*";
							break;
						}
					}
				}
			}
		}
		return esIntercambio;
	}

	private String validaSiEsIntercambio2(List<String> lista, String intercambiosSinGuion, String numArtSinGuion, String numartAnterior)
	{
		String esIntercambio = "";
		for (int j=0; j <  lista.size(); j++) 
		{
	 
		String arrayDesActr[]= lista.get(j).replace("[", "").replace("]", "").trim().split(" ");
			
		
		String arrayDescIntercambios[] = intercambiosSinGuion.replace("[", "").replace("]", "").trim().split(",");
		
		for (int i=0; i <  arrayDesActr.length; i++) 
		{
		 
			// if(arrayDesActr[i].replace("-", "").trim().length() > 0)
			if(numArtSinGuion.trim().length() > 0)
			
			{
				for(int e = 0; e < arrayDescIntercambios.length; e++)
				{
					 
				 	if(arrayDescIntercambios[e].equals(arrayDesActr[i].replace("-", "")))
				///	if(arrayDescIntercambios[e].equals(numArtSinGuion.replace("[", "").replace("]", "").trim()))
					{
					 
						 if(!arrayDescIntercambios[e].equals(numArtSinGuion.replace("[", "").replace("]", "").trim()) && !arrayDescIntercambios[e].equals(numartAnterior))
						///	if(!arrayDescIntercambios[e].equals(numArtSinGuion.replace("[", "").replace("]", "").trim()))
						{
							esIntercambio="*";
							break;
						}
					}
				}
			}
		}
		}
		return esIntercambio;
	}
	
	
	/* Valida precios por cliente y marca */
	private String calculaPrecioListaXCliente(String precio_lista, String linea,  InfoCliente cliente , List<LineasDescuentoFijo> lineas, InfoCliente infoCliente)
	{
		String precioCalculado = "";
		try
		{
			double precio = 0;
			String descuentoLinea = verificaLineaConDescuentoFijo(linea, lineas);
			
			//System.out.println("descuentoLinea: " + descuentoLinea); 
			
			if(!descuentoLinea.equals("0"))
			{
				precio = Double.parseDouble(precio_lista) * Double.parseDouble(descuentoLinea);
				precioCalculado = String.valueOf(precio);
				
				//System.out.println("precioCalculado: " + precioCalculado);
			}
			else
			{
				String descuento_letra = cliente.getFac_descuento();
				precio = Double.parseDouble(precio_lista) * Double.parseDouble(descuento_letra);
				precioCalculado = String.valueOf(precio);
			}
		}
		catch(Exception ex)
		{
			System.out.println("[Error: Consultar precio de lista por cliente,  Clase: GestorCarritoDeCompras,  Detalle: " + ex.getMessage().toString() +"]");
			Log log=new Log(01,infoCliente.getCve_cdo(),infoCliente.getCve_cliente() ,0, "[Error: Consultar precio de lista por cliente,  Clase: GestorCarritoDeCompras,  Detalle: " + ex.getMessage().toString() +"]");
			Cls_Log.insertaLog(log);
		}
		return precioCalculado;
	}
	
	private String  verificaLineaConDescuentoFijo(String linea,  List<LineasDescuentoFijo> lineas)
	{
		String descuentoLinea="0";
		
		for( int i=0; i < lineas.size(); i++)
		{
			//System.out.println("liena: " + linea.trim() + "lineas.get.I: " + lineas.get(i).getLinea().trim() );
			if(linea.trim().equals(lineas.get(i).getLinea().trim()))
			{
				descuentoLinea = lineas.get(i).getDescuento();
				break;
			}
		}			
		return descuentoLinea;		
	}	
	
	
	/******  ORDENAMIENTO ******/
	public List<Articulos> ordenarProductosCarritoPorParametro( List<Articulos> listaArticulosCarrito, String orden)
	{		
		switch(orden)
		{
			case  "1":
				listaArticulosCarrito.sort(Comparator.comparing(Articulos::getGrupo));
				break;
				
			case  "2":
				listaArticulosCarrito.sort(Comparator.comparing(Articulos::getMarca));
				break;
				
			case  "3":
				listaArticulosCarrito.sort(Comparator.comparing(Articulos::getDescripcion));
				break;
				
			case  "4":
				listaArticulosCarrito.sort(Comparator.comparing(Articulos::getPrecio_real));
				break;
				
			case  "5":
				listaArticulosCarrito.sort(Comparator.comparing(Articulos::getPrecio_real).reversed());
				break;
				
			case  "6":
				listaArticulosCarrito.sort(Comparator.comparing(Articulos::getRk));
				break;
			
		}		
		return listaArticulosCarrito;
	}
		
	/******  AUTOCOMPLETADO DE SUGERENCIAS BUSQUEDA  ******/ 
	public List<Articulos> consultaSugerenciasBusqueda(List<Querys> listaQuerys, String desBusqueda, InfoCliente infoCliente)
	{
		List<Articulos> listaArticulos = new ArrayList<>(); 
		Connection connBD = null;
		PreparedStatement pstm= null;
		connBD = ConexionBD.abrirConexionBD();	
		try
		{
			int [] noQuerys = {18,32,33,34,35,36,37,38,39};
			String[] querys = new String[25];	
			for (int i = 0; i < noQuerys.length; i++) 
			{
				if (listaArticulos.size() == 0)
				{
					querys = Cls_Querys.LimpiaListaQuerys(querys);	
					querys = Cls_Querys.ObtieneQuerys(noQuerys[i], listaQuerys, querys);
					querys = inicializaQueryNumero18(querys, desBusqueda);
					pstm = connBD.prepareStatement("{call " + "comercio_electronico.usp_EXECUTE_QUERY(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
					ResultSet rs=  EjecutaQuerysBD.EjecutarQuery(querys[0], querys[1],querys[2], querys[3], querys[4], querys[5], querys[6],
																 querys[7], querys[8], querys[9],querys[10], querys[11], querys[12], querys[13], 
																 querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], 
																 querys[21], querys[22], querys[23], querys[24], "",pstm, connBD);
					
					
					if(rs != null)
					{
						while(rs.next())
						{
							Articulos articulo= new Articulos();
							articulo.setDescripcion(rs.getString("descripcion"));
							listaArticulos.add(articulo);
						}
					}
				}
				else {break;}
			}
		}
		catch(Exception ex)
		{
			System.out.println("[NuevoportalRamaCDO.- Error: Consultar sugerencias de busqueda.,  Clase: GestorCarritoDeCompras,  Detalle: " + ex.getMessage().toString() +"]");
			Log log=new Log(01,infoCliente.getCve_cdo(),infoCliente.getCve_cliente() ,0, "[Error: Consultar sugerencias de busqueda,  Clase: GestorCarritoDeCompras,  Detalle: " + ex.getMessage().toString() +"]");
			Cls_Log.insertaLog(log);
		}
		finally 
		{
			try {
				if (pstm != null) 
				{
					pstm.close();
				}

				} catch (SQLException e) {e.printStackTrace();}
			try {
				if (pstm != null) 
				{
					connBD.close();
				}
				} catch (SQLException e) {e.printStackTrace();}
		}
	
		return listaArticulos;
	}
	
	/******  AUTOCOMPLETADO DE SUGERENCIAS BUSQUEDA  SOLR ******/ 
	public Collection<SugerenciaBusqueda> consultaSugerenciasBusquedaSolr(List<Querys> listaQuerys, String desBusqueda, InfoCliente infoCliente)
	{
		List<SugerenciaBusqueda> listaArticulos = new ArrayList<>();

		try
		{
			SolrDocumentList resultadosArt = consultaSolar(desBusqueda);
			if(desBusqueda.length()>1 && String.valueOf(desBusqueda.charAt(desBusqueda.length()-1)).equals("-"))
			{
				desBusqueda = desBusqueda.substring(0, desBusqueda.length()-1);
			}
			desBusqueda = desBusqueda.toUpperCase();		
			String [] campos = {"descripcion_producto","num_art_prov","num_art_prov_sin_guion","num_art_cdo","num_art_cdo_sin_guion","num_art_anterior","num_art_anterior_sin_guion","intercambios","intercambios_sin_guion"};
			for (int i = 0; i < resultadosArt.size(); i++)
			{
				for (int j = 0; j < campos.length; j++) 
				{
					SugerenciaBusqueda a = new SugerenciaBusqueda();
					if(resultadosArt.get(i).getFieldValue(campos[j]).toString().toUpperCase().contains(desBusqueda) || resultadosArt.get(i).getFieldValue(campos[j]).toString().toUpperCase().contains(desBusqueda.replace("-","")))
					{
						String valor = resultadosArt.get(i).getFieldValue(campos[j]).toString().replace("[","").replace("]","");
						if (valor.contains(",")) 
						{
							String split [] = valor.split(",");
							for (int k = 0; k < split.length; k++)
							{
								if (resultadosArt.get(i).getFieldValue(campos[j]).toString().toUpperCase().contains(split[k])) 
								{
									SugerenciaBusqueda aa = new SugerenciaBusqueda();
									aa.setArticulo(split[k]);
									listaArticulos.add(aa);
									break;
								}
							}
						}
						else
						{
							a.setArticulo(resultadosArt.get(i).getFieldValue(campos[j]).toString().replace("[","").replace("]",""));
							listaArticulos.add(a);
						}
						break;
					}
				}
			}
		}
		catch(Exception ex)
		{
			System.out.println("[NuevoportalRamaCDO.- Error: Consultar sugerencias de busqueda.,  Clase: GestorCarritoDeCompras,  Detalle: " + ex.getMessage().toString() +"]");
		}
		
		return listaArticulos.stream().collect(Collectors.toConcurrentMap(SugerenciaBusqueda::getArticulo, Function.identity(), (p, q) -> p)).values();
	}
		
	private SolrDocumentList consultaSolar(String desBusqueda) 
	{
		
		SolrDocumentList resultadosArt = null;		
		try
		{
		 
			String sentencia = "( num_art_prov:" + desBusqueda.replace("-", "").replace("[", "").replace("]", "")+"* OR "
							 + " num_art_prov_sin_guion:"+desBusqueda.replace("-", "").replace("[", "").replace("]", "")+"* OR "
									 + " descripcion_producto:"+desBusqueda.replace("-", "").replace("[", "").replace("]", "")+"* OR "
							 + " num_art_cdo:"+desBusqueda.replace("-", "").replace("[", "").replace("]", "")+"* OR "
							 + " num_art_cdo_sin_guion:"+desBusqueda.replace("-", "").replace("[", "").replace("]", "")+"* OR "
							 + " num_art_anterior:"+desBusqueda.replace("-", "").replace("[", "").replace("]", "")+"* OR "
							 + " num_art_anterior_sin_guion:"+desBusqueda.replace("-", "").replace("[", "").replace("]", "")+"* OR "
							 + " intercambios:*"+desBusqueda.replace("-", "").replace("[", "").replace("]", "")+"* OR "
							 + " intercambios_sin_guion:*"+desBusqueda.replace("-", "").replace("[", "").replace("]", "")+"*  "
							+ ") ";
			SolrQuery  query = new SolrQuery();
			query.setStart(0);
			query.setRows(13);
			query.addSort("nombre_producto", ORDER.asc);
			query.addField("num_art_prov");
			query.addField("num_art_prov_sin_guion");
			query.addField("num_art_cdo");
			query.addField("num_art_cdo_sin_guion");
			query.addField("num_art_anterior");
			query.addField("num_art_anterior_sin_guion");
			query.addField("intercambios");
			query.addField("descripcion_producto");
			query.addField("intercambios_sin_guion");
			query.setQuery(sentencia);
			QueryResponse respuestaSolr = CLIENTE_SOLR.query(query, METHOD.POST);
	        resultadosArt = respuestaSolr.getResults();
	      
		}
		catch(Exception ex)
		{
			System.out.println("[NuevoportalRamaCDO.- Error: Consultar sugerencias en Solr,  Clase: GestorCarritoDeComprasV2.consultaSolar,  Detalle: " + ex.getMessage().toString() +"]");
			resultadosArt = new SolrDocumentList();
		}
		return resultadosArt;
	}
	
	/*** CONSULTA DE SUBMARCAS ***/
	public List<SubMarcas> obtieneSubMarcas(List<Querys> listaQuerys,String cve_armadora,InfoCliente infoCliente)
	{
		Connection connBD = null;
		PreparedStatement pstm = null;
		connBD = ConexionBD.abrirConexionBD();
		List<SubMarcas> listSubMarcas= new ArrayList<>();
		try 
		{
			String [] querys = new String [25];
			querys = Cls_Querys.LimpiaListaQuerys(querys);
			querys = Cls_Querys.ObtieneQuerys(14, listaQuerys, querys);
			querys= inicializaQueryNumero14(querys,cve_armadora);
			
			pstm = connBD.prepareStatement("{call " + "comercio_electronico.usp_EXECUTE_QUERY(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			ResultSet rs = EjecutaQuerysBD.EjecutarQuery(querys[0], querys[1],querys[2], querys[3], querys[4], querys[5], querys[6],
					 querys[7], querys[8], querys[9],querys[10], querys[11], querys[12], querys[13], 
					 querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], 
					 querys[21], querys[22], querys[23], querys[24], "",pstm, connBD);
			
			
			if(rs != null)
			{
				listSubMarcas= llenarClaseSuMarcas(rs, infoCliente);
			}
			Log log=new Log(1,infoCliente.getCve_cdo(),infoCliente.getCve_cliente() ,0, "[Accion: Consulta submarcas por armadora: " + cve_armadora +"]");
			Cls_Log.insertaLog(log);
		}
		catch(Exception ex)
		{
			System.out.println("[NuevoportalRamaCDO.- Error: Consultar subMarcas,  Clase: GestorCarritoDeCompras,  Detalle: " + ex.getMessage().toString() +"]");
			Log log=new Log(01,infoCliente.getCve_cdo(),infoCliente.getCve_cliente() ,0, "[Error: Consultar subMarcas,  Clase: GestorCarritoDeCompras,  Detalle: " + ex.getMessage().toString() +"]");
			Cls_Log.insertaLog(log);
		}
		finally
		{
			try {connBD.close();} catch (SQLException e) {e.printStackTrace();}
			try {pstm.close();} catch (SQLException e) {e.printStackTrace();}
		}
		
		return listSubMarcas;
	}
	
	public List<DetalleArticulo> consultaDetalLeArticulo(List<Querys> listaQuerys, InfoCliente infoCliente, String articulo, List<DetalleArticulo> listaArticulos) 
	{
		Connection connBD = null;
		PreparedStatement pstm = null;
		connBD = ConexionBD.abrirConexionBD();
		
		try 
		{
			String [] querys = new String [25];
			querys = Cls_Querys.LimpiaListaQuerys(querys);
			querys = Cls_Querys.ObtieneQuerys(47, listaQuerys, querys);
			querys= inicializaQueryNumero47(querys,articulo);
			pstm = connBD.prepareStatement("{call " + "comercio_electronico.usp_EXECUTE_QUERY(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			ResultSet rs = EjecutaQuerysBD.EjecutarQuery(querys[0], querys[1],querys[2], querys[3], querys[4], querys[5], querys[6],
					 querys[7], querys[8], querys[9],querys[10], querys[11], querys[12], querys[13], 
					 querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], 
					 querys[21], querys[22], querys[23], querys[24], "",pstm, connBD);
		
			
			if(rs != null)
			{
				listaArticulos = llenarDetalleArticulo(rs, listaArticulos);
			}
			Log log=new Log(1,infoCliente.getCve_cdo(),infoCliente.getCve_cliente() ,0, "[Accion: Consulta detalle de articulo: " + articulo +"]");
			Cls_Log.insertaLog(log);
		}
		catch(Exception ex)
		{
			System.out.println("[NuevoportalRamaCDO.- Error: Consultar detalle de articulo,  Clase: GestorCarritoDeCompras,  Detalle: " + ex.getMessage().toString() +"]");
			Log log=new Log(01,infoCliente.getCve_cdo(),infoCliente.getCve_cliente() ,0, "[Error: Consultar detalle de articulo,  Clase: GestorCarritoDeCompras,  Detalle: " + ex.getMessage().toString() +"]");
			Cls_Log.insertaLog(log);
		}
		finally
		{
			try {connBD.close();} catch (SQLException e) {e.printStackTrace();}
			try {pstm.close();} catch (SQLException e) {e.printStackTrace();}
		}
		
		return listaArticulos;
	}
	
	private List<DetalleArticulo> llenarDetalleArticulo(ResultSet rs, List<DetalleArticulo> listaArticulos) 
	{
		try
		{
			while(rs.next())
			{
				DetalleArticulo detArt = new DetalleArticulo();
				
				detArt.setAnio(rs.getString("anio"));
				detArt.setArmadora(rs.getString("armadora"));
				detArt.setCaracteristicas(rs.getString("caracteristicas"));
				detArt.setCilindros(rs.getString("cilindros"));
				detArt.setLitros(rs.getString("litros"));
				detArt.setModelo(rs.getString("modelo"));
				detArt.setSubmodelo(rs.getString("submodelo"));
				detArt.setTipo_combustible(rs.getString("tipo_combustible"));
				detArt.setTransmision(rs.getString("transmision"));
				
				listaArticulos.add(detArt);
			}
		}
		catch (Exception e) 
		{
			System.out.println("NuevoportalRamaCDO.- Error al cargar clientes" + e);
		}
		return listaArticulos;
	}
	
	private List<SubMarcas> llenarClaseSuMarcas(ResultSet rs,InfoCliente infoCliente)
	{
		List<SubMarcas> submarcas =new ArrayList<>();		
		try
		{
			rs.beforeFirst();
			while(rs.next())
			{
				SubMarcas submarca = new SubMarcas();
				submarca.setCve_submarca(0);
				submarca.setNombre_submarca(rs.getString("desc_sub_marca"));
				submarcas.add(submarca);
			}		
		}
		catch(Exception ex)
		{
			System.out.println("[Error: Llenar clase subMarcas,  Clase: GestorCarritoDeCompras,  Detalle: " + ex.getMessage().toString() +"]");
			Log log=new Log(01,infoCliente.getCve_cdo(),infoCliente.getCve_cliente() ,0, "[Error: Llenar clase subMarcas,  Clase: GestorCarritoDeCompras,  Detalle: " + ex.getMessage().toString() +"]");
			Cls_Log.insertaLog(log); 
		}		
		return submarcas;
	}
		
	
	/*** VALIDA SI AGREGA ARTICULO AL CARRITO ***/
	public ExistenciasPorCDO ConsutkaExistenciaArticuloWS(List<Querys> listaQuerys,InfoCliente infoCliente,String num_art, int  cantidadPedida)
	{	
		//System.out.println("...1");
		ExistenciasPorCDO  existenciaArtCDO = new ExistenciasPorCDO();
		//System.out.println("...2");
		JSONObject ExistenciasArt = consultaExistenciasEnWS(infoCliente, num_art,cantidadPedida);
		existenciaArtCDO.setNum_art(num_art);
		existenciaArtCDO.setCantidadPedida(cantidadPedida);
		existenciaArtCDO.setCdoMacro(ExistenciasArt.getString("macro").toUpperCase());
		existenciaArtCDO.setCdoMacroDescripcion(ExistenciasArt.getString("descripcion_macro"));
		existenciaArtCDO.setCdoBr(ExistenciasArt.getString("regional").toUpperCase());
		existenciaArtCDO.setCdoBrDescripcion(ExistenciasArt.getString("regional_descripcion"));
		
		existenciaArtCDO.setCdoTraspaso(ExistenciasArt.getString("macro_traspaso").toUpperCase());
		existenciaArtCDO.setCdoTraspasoDescripcion(ExistenciasArt.getString("descripcion_macro_traspaso"));
		existenciaArtCDO.setExietnciaCDO(ExistenciasArt.getInt("macro_cantidad"));
		existenciaArtCDO.setExistenciaBR(ExistenciasArt.getInt("regional_cantidad"));
		existenciaArtCDO.setExietnciaTraspaso(ExistenciasArt.getInt("macro_traspaso_cantidad"));
		//System.out.println("...3");
		existenciaArtCDO.setExistenciaCompleta(false);
		if (existenciaArtCDO.getExietnciaTraspaso() > 0)
		{
			existenciaArtCDO.setExistenciaCompleta(true);
		}
		
		List<listaNegraArticulos> listaNegra = recuperaListaNegra(listaQuerys,infoCliente, num_art);
		
		existenciaArtCDO.setArticuloBloqueo72hrs(ValidaBloquado72hrs(listaNegra,num_art));
		existenciaArtCDO.setArticuloBloqueoExpress(ValidaBloquadoExpress(listaNegra,num_art));
		
		//System.out.println("...4: " + existenciaArtCDO.toString());
		return existenciaArtCDO;
	}
	
	private String ValidaBloquadoExpress(List<listaNegraArticulos> lista ,String articulo) {
		String articuloBloqueado= "N";
		try
		{
			for (listaNegraArticulos iArt : lista) {
				if(iArt.getNumArt().equalsIgnoreCase(articulo))
				{	
					if(iArt.getCveTipo().equalsIgnoreCase("2"))
					articuloBloqueado = "S";
				}
			}
		}
		catch(Exception ex)
		{
			Log log=new Log(0, 0, 0 ,0, "[Error:ValidaBloquadoExpress,  Clase: GestorCarritoDeCompras,  Detalle: " + ex.getMessage().toString() +"]");
			Cls_Log.insertaLog(log);
		}
		return articuloBloqueado;
	}

	private String ValidaBloquado72hrs(List<listaNegraArticulos> lista ,String articulo) {
		String articuloBloqueado= "N";
		try
		{
			for (listaNegraArticulos iArt : lista) {
				if(iArt.getNumArt().equalsIgnoreCase(articulo))
				{	
					if(iArt.getCveTipo().equalsIgnoreCase("1"))
					articuloBloqueado = "S";
				}
			}
		}
		catch(Exception ex)
		{
			Log log=new Log(0, 0, 0 ,0, "[Error:ValidaBloquadoExpress,  Clase: GestorCarritoDeCompras,  Detalle: " + ex.getMessage().toString() +"]");
			Cls_Log.insertaLog(log);
		}
		return articuloBloqueado;
	}

	private List<listaNegraArticulos> recuperaListaNegra(List<Querys> listaQuerys, InfoCliente infoCliente, String num_art) {
		Connection connBD = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		connBD = ConexionBD.abrirConexionBD();
		List<listaNegraArticulos> listArticulos= new ArrayList<>();
		try 
		{
			String [] querys = new String [25];
			querys = Cls_Querys.LimpiaListaQuerys(querys);
			querys = Cls_Querys.ObtieneQuerys(44, listaQuerys, querys);
			querys= inicializaQueryNumero44(querys,infoCliente,num_art );
			
			pstm = connBD.prepareStatement("{call " + "comercio_electronico.usp_EXECUTE_QUERY(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			rs = EjecutaQuerysBD.EjecutarQuery(querys[0], querys[1],querys[2], querys[3], querys[4], querys[5], querys[6],
					 querys[7], querys[8], querys[9],querys[10], querys[11], querys[12], querys[13], 
					 querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], 
					 querys[21], querys[22], querys[23], querys[24], "",pstm, connBD);
			
			
			if(rs != null)
			{
				 
				while(rs.next())
				{
					listaNegraArticulos art = new listaNegraArticulos();
					art.setCveTipo(rs.getString("cve_tipo"));
					art.setNumArt(rs.getString("num_art_cdo"));
					art.setDescripcion(rs.getString("descripcion"));
					listArticulos.add(art);
				}
			}
			
		}
		catch(Exception ex)
		{
			System.out.println("[NuevoportalRamaCDO.- Error: Consultar lista Negra,  Clase: GestorCarritoDeCompras,  Detalle: " + ex.getMessage().toString() +"]");
			Log log=new Log(01,infoCliente.getCve_cdo(),infoCliente.getCve_cliente() ,0, "[Error: Consultar lista Negra,  Clase: GestorCarritoDeCompras,  Detalle: " + ex.getMessage().toString() +"]");
			Cls_Log.insertaLog(log);
		}
		finally
		{
			try {connBD.close();} catch (SQLException e) {e.printStackTrace();}
			try {pstm.close();} catch (SQLException e) {e.printStackTrace();}
		}
		 return listArticulos;
	}

	/*cODIGO DE ana*/
	/*private ExistenciasPorCDO validaSiagregaArticuloCarritoORIGINAL(List<Querys> listaQuerys,InfoCliente infoCliente,String num_art, int  cantidadPedida)
	{	
		ExistenciasPorCDO  existenciaArtCDO = new ExistenciasPorCDO();
		List<ExistenciasPorArticulo> listExistenciasArt= consultaExistenciasEnWS(infoCliente, num_art);
				
		if(!infoCliente.getUname_cdo().equals(infoCliente.getUname_bodega()))
		{
			existenciaArtCDO = calculaExistenciaClienteRegional(cantidadPedida, listExistenciasArt, infoCliente, existenciaArtCDO);
		}
		else
		{
			existenciaArtCDO = calculaExistenciaClienteMacro(cantidadPedida, listExistenciasArt, infoCliente, existenciaArtCDO);
		}
		return existenciaArtCDO;
	}*/
	
	/* CONSULTA DE EXISTENCIAS */
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
			}
			catch(Exception e){uname = infoCliente.getUname_cdo();}
			
			URL url = new URL(properties.getProperty("URL_WS_EXISTENCIAS")  + "existencias?cve_centro="+infoCliente.getCentro() +"&articulo=" + num_art +"&uname_br="+ uname +"&cantidad=" + cantidad);
			
//			 System.out.println("url Existencias: " + url);
			
	        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	        conn.setRequestMethod("POST");
	        
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
	 			// System.out.println("jsonConsignatarios Existencias: " + jsonConsignatarios);
	 			 if(Cls_MetodosGlobales.lecturaValidacionJson(jsonConsignatarios, infoCliente, " consulta de existencias por articulo ", "GestorCarritoDeCompras","wsExistencias"))
	 			 {
	 				JSONArray jsonArrayPedidos = new JSONArray(jsonConsignatarios.getJsonArray("datos").toString());
                    rs = jsonArrayPedidos.getJSONObject(0);
                    
                   // System.out.println("jsonConsignatarios Existencias rs: " + rs);
	 			 }
	        }
	        conn.disconnect();
		}
		catch(Exception ex)
		{
			System.out.println("[NuevoportalRamaCDO.- Error: Invocar wsExistencias para consulta de exietncias x articulo ,  Clase: GestorCarritoDeCompras,  Detalle: " + ex.getMessage().toString() +"]");
			Log log=new Log(1,infoCliente.getCve_cdo(),infoCliente.getCve_cliente() ,0, "[Error: Invocar wsExistencias para consulta de exietncias x articulo,  Clase: GestorCarritoDeCompras,  Detalle: " + ex.getMessage().toString() +"]");
			Cls_Log.insertaLog(log);
		}		
		// System.out.println(" return rs: " + rs);
		return rs;
	}
	
	private List<ExistenciasPorArticulo>   consultaExistenciasEnWSORIGINAL(InfoCliente infoCliente, String num_art)
	{
		List<ExistenciasPorArticulo> listExistenciasArt=new ArrayList<>();
		try
		{
			URL url = new URL(properties.getProperty("URL_WS_EXISTENCIAS")  + "existencias?cve_centro=" + infoCliente.getCentro() + "&articulo=" + num_art);
			
			//System.out.println("url Existencias: " + url);
			
	        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	        conn.setRequestMethod("POST");
	        
	        if (conn.getResponseCode() != 200) 
	        {
	        	//System.out.println("[Error: Exception al conectar con wsExistencias,  Clase: GestorCarritoDeCompras,  Detalle: " + conn.getResponseCode() +"]");
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
	 			//System.out.println("jsonConsignatarios Existencias: " + jsonConsignatarios);
	 			 if(Cls_MetodosGlobales.lecturaValidacionJson(jsonConsignatarios, infoCliente, " consulta de existencias por articulo ", "GestorCarritoDeCompras","wsExistencias"))
	 			 {
	 				listExistenciasArt = llenarClaseExistencias(infoCliente, jsonConsignatarios);
	 			 }	             
	        }
	        conn.disconnect();
		}
		catch(Exception ex)
		{
			System.out.println("[NuevoportalRamaCDO.- Error: Invocar wsExistencias para consulta de exietncias x articulo ,  Clase: GestorCarritoDeCompras,  Detalle: " + ex.getMessage().toString() +"]");
			Log log=new Log(1,infoCliente.getCve_cdo(),infoCliente.getCve_cliente() ,0, "[Error: Invocar wsExistencias para consulta de exietncias x articulo,  Clase: GestorCarritoDeCompras,  Detalle: " + ex.getMessage().toString() +"]");
			Cls_Log.insertaLog(log);
		}		
		return listExistenciasArt;
	}
	
	private List<ExistenciasPorArticulo> llenarClaseExistencias(InfoCliente infoCliente, JsonObject jsonConsignatarios)
	{
		List<ExistenciasPorArticulo> listExistenciasArt=new ArrayList<>();
		 try
		 {	
			JsonArray detalleJson = jsonConsignatarios.getJsonArray("datos");
			if(detalleJson.size() > 0)
			{
				for (int i = 0; i < detalleJson.size(); i++) 
				{	
					ExistenciasPorArticulo existencia = new ExistenciasPorArticulo();
					existencia.setNum_art(detalleJson.getJsonObject(i).getString("articulo"));				
					existencia.setTipo(detalleJson.getJsonObject(i).getString("tipo"));
					existencia.setUname(detalleJson.getJsonObject(i).getString("uname"));
					existencia.setExistencia(detalleJson.getJsonObject(i).getInt("existencia"));
					listExistenciasArt.add(existencia);
				}
			}	 
		 }
		 catch(Exception ex)
		 {
			 System.out.println("[NuevoportalRamaCDO.- Error: Llenar clase existencias por articulo,  Clase: GestorCarritoDeCompras,  Detalle: " + ex.getMessage().toString() +"]");
				Log log=new Log(01,infoCliente.getCve_cdo(),infoCliente.getCve_cliente() ,0, "[Error: Llenar clase existencias por articulo,  Clase: GestorCarritoDeCompras,  Detalle: " + ex.getMessage().toString() +"]");
				Cls_Log.insertaLog(log);
		 }
		 return listExistenciasArt;
	}
			
	/* CONSULTA EXISTENCIA PARA CLIENTE CDO REGIONAL */
	private ExistenciasPorCDO calculaExistenciaClienteRegional( int  cantidadPedida, List<ExistenciasPorArticulo> listExistenciasArt, InfoCliente infoCliente, ExistenciasPorCDO  existenciaArtCDO)
	{
		int faltante=0;		
		faltante = consultaExistenciasEnCdoRegional(infoCliente,listExistenciasArt,cantidadPedida);
		if(faltante <= 0) 
		{
			existenciaArtCDO.setExistenciaCompleta(true);
		}
		else
		{			
			existenciaArtCDO.setExistenciaCompleta(false);
			existenciaArtCDO.setExistenciaBR(cantidadPedida - faltante);	
			cantidadPedida = faltante;
			
			faltante = consultaExistenciasEnCdoMacro(infoCliente, listExistenciasArt, cantidadPedida);	
			existenciaArtCDO.setExietnciaCDO(cantidadPedida - faltante);
			cantidadPedida = faltante;
				
			if(faltante >0)
			{
				String InfoTraspaso[]= consultaExistenciasEnTraspaso(infoCliente, listExistenciasArt, cantidadPedida).split("&");
				if(InfoTraspaso.length > 1)
				{
					existenciaArtCDO.setExietnciaTraspaso(Integer.parseInt(InfoTraspaso[1]));
					existenciaArtCDO.setCdoTraspaso(InfoTraspaso[0]);
				}
			}			
		}
		return  existenciaArtCDO;
	}
		
	/* CONSULTA EXISTENCIA PARA CLIENTE CDO REGIONAL */
	private ExistenciasPorCDO calculaExistenciaClienteMacro( int  cantidadPedida, List<ExistenciasPorArticulo> listExistenciasArt, InfoCliente infoCliente, ExistenciasPorCDO  existenciaArtCDO)
	{
		int faltante=0;	
		faltante = consultaExistenciasEnCdoMacro(infoCliente, listExistenciasArt, cantidadPedida);	
		existenciaArtCDO.setExietnciaCDO(cantidadPedida - faltante);
		cantidadPedida = cantidadPedida -  faltante;
				
		if(faltante > 0)
		{
			existenciaArtCDO.setExistenciaCompleta(false);
			//faltante = consultaExistenciasEnTraspaso(infoCliente, listExistenciasArt, cantidadPedida);
			existenciaArtCDO.setExietnciaTraspaso(faltante);
		}	
		else
		{
			existenciaArtCDO.setExistenciaCompleta(true);
		}
		return existenciaArtCDO;
	}
	
	/* CONSULTA EXISTENCIA CDO /REGIONAL /TRASPASO  */
	private int consultaExistenciasEnCdoRegional(InfoCliente infoCliente, List<ExistenciasPorArticulo> listExistenciasArt, int  cantidadPedida)
	{
		int faltante= 0;
		boolean cdoEncontrado = false;
		try
		{	
			for(int i = 0; i < listExistenciasArt.size(); i++)
			{ 				
				if(listExistenciasArt.get(i).getTipo().equals("R"))
				{
					if(listExistenciasArt.get(i).getUname().toUpperCase().equals(infoCliente.getNombre_bodega().toUpperCase()))
					{
						cdoEncontrado = true;						
						if(cantidadPedida > listExistenciasArt.get(i).getExistencia())
						{
							faltante = cantidadPedida - listExistenciasArt.get(i).getExistencia();
						}
						
					} 
				}				
			}
			if(!cdoEncontrado)
			{
				faltante = cantidadPedida;
			}
		}
		catch(Exception ex)
		{
			 System.out.println("[NuevoportalRamaCDO.- Error: Validar existencias por articulo en cdo y regional,  Clase: GestorCarritoDeCompras,  Detalle: " + ex.getMessage().toString() +"]");
			 Log log=new Log(01,infoCliente.getCve_cdo(),infoCliente.getCve_cliente() ,0, "[Error: Validar existencias por articulo en cdo y regional,  Clase: GestorCarritoDeCompras,  Detalle: " + ex.getMessage().toString() +"]");
			 Cls_Log.insertaLog(log);
		}
		return faltante;
	}
	
	private int consultaExistenciasEnCdoMacro(InfoCliente infoCliente, List<ExistenciasPorArticulo> listExistenciasArt, int  cantidadPedida)
	{
		int faltante= 0;
		boolean cdoEncontrado = false;
		try
		{	
			for(int i = 0; i < listExistenciasArt.size(); i++)
			{
				if(listExistenciasArt.get(i).getTipo().equals("M"))
				{
					if(listExistenciasArt.get(i).getUname().toUpperCase().equals(infoCliente.getNombre_cdo().toUpperCase()))
					{
						cdoEncontrado = true;
						if(cantidadPedida > listExistenciasArt.get(i).getExistencia())
						{
							faltante = cantidadPedida - listExistenciasArt.get(i).getExistencia();
						}	
					} 
				}
			}
			if(!cdoEncontrado)
			{
				faltante = cantidadPedida;
			}
		}
		catch(Exception ex)
		{
			 System.out.println("[NuevoportalRamaCDO.- Error: Validar existencias por articulo en cdo y regional,  Clase: GestorCarritoDeCompras,  Detalle: " + ex.getMessage().toString() +"]");
			 Log log=new Log(01,infoCliente.getCve_cdo(),infoCliente.getCve_cliente() ,0, "[Error: Validar existencias por articulo en cdo y regional,  Clase: GestorCarritoDeCompras,  Detalle: " + ex.getMessage().toString() +"]");
			 Cls_Log.insertaLog(log);
		}
		return faltante;
	}

	private String consultaExistenciasEnTraspaso(InfoCliente infoCliente, List<ExistenciasPorArticulo> listExistenciasArt, int  cantidadPedida)
	{
		int disponible= 0;
		String cdo_traspaso = "cdo";
		try
		{					
			for(int i = 0; i < listExistenciasArt.size(); i++)
			{
				if(listExistenciasArt.get(i).getTipo().equals("M"))
				{
					if(!listExistenciasArt.get(i).getUname().toUpperCase().equals(infoCliente.getUname_cdo().toUpperCase()))
					{
						if(listExistenciasArt.get(i).getExistencia() > 0)
						{
							if(listExistenciasArt.get(i).getExistencia() > disponible)
							{
								disponible = listExistenciasArt.get(i).getExistencia();
								cdo_traspaso= listExistenciasArt.get(i).getUname();
							}
						}
					}
				}
			}	
			
			if(disponible >= cantidadPedida)
			{
				disponible = cantidadPedida;
			}
		}
		catch(Exception ex)
		{
			 System.out.println("[NuevoportalRamaCDO.- Error: Validar existencias por articulo en cdo y regional,  Clase: GestorCarritoDeCompras,  Detalle: " + ex.getMessage().toString() +"]");
			 Log log=new Log(01,infoCliente.getCve_cdo(),infoCliente.getCve_cliente() ,0, "[Error: Validar existencias por articulo en cdo y regional,  Clase: GestorCarritoDeCompras,  Detalle: " + ex.getMessage().toString() +"]");
			 Cls_Log.insertaLog(log);
		}
		return cdo_traspaso + "&" + disponible;
	}
		
	
	private SolrDocumentList qryConsultaAticuloEnSolr(String descArticulo, InfoCliente infoCliente)
	{
		SolrQuery  query = new SolrQuery();
		SolrDocumentList resultadosArt = null;		
		try
		{
			 
    		//String sentencia =   "(num_art_cdo:" + descArticulo + ") ";
			String sentencia =   "(id:" + descArticulo+"*" + ") ";
			
			
			query.setStart(0);
			query.setRows(1000);
			query.setSort("orden", ORDER.asc);
			//query.addSort("nombre_producto", ORDER.asc);
			//query.addSort("rk", ORDER.asc);
			// query.addSort("num_art_cdo", ORDER.asc);
			String rnk =  infoCliente.getUname_cdo().toLowerCase() +  "_rnk";
			query.addSort( rnk, ORDER.asc);
			query.setQuery(sentencia);
			/*ARV-2022-04-20*/
			QueryResponse respuestaSolr = CLIENTE_SOLR.query(query, METHOD.POST);
	        resultadosArt = respuestaSolr.getResults();	  
	       // System.out.println("resultadosArt : " + resultadosArt);
	       
		}
		catch(Exception ex)
		{
			// System.out.println("[NuevoportalRamaCDO.- Error: Consultar articulos por parametro en Solr,  Clase: GestorCarritoDeComprasv2.qryConsultaAticuloEnSolr,  Detalle: " + ex.getMessage().toString() +"]");
			Log log=new Log(01,infoCliente.getCve_cdo(),infoCliente.getCve_cliente() ,0, "[Error: Consultar articulos por parametro en Solr,  Clase: GestorCarritoDeComprasv2.qryConsultaAticuloEnSolr,  Detalle: " + ex.getMessage().toString() +". QUERY: " + query  +"]");
			Cls_Log.insertaLog(log);
			resultadosArt = new SolrDocumentList();
		}
		// System.out.println("qryConsultaAticuloEnSolr:" + resultadosArt);
		return resultadosArt;
	}
	
	
	
	
	/*** INICIALIZACION DE QUERYS ***/
	private String[] inicializaQueryNumero12(String[] ListaQuerys, int centro, int cve_cliente) 
	{
		for (int i=0;i <ListaQuerys.length; i++)
		{
			ListaQuerys[i]= ListaQuerys[i].replace("{CVE_CENTRO}", String.valueOf(centro));
			ListaQuerys[i]= ListaQuerys[i].replace("{CVE_CLIENTE}", String.valueOf(cve_cliente));							
		}
		return ListaQuerys;
	}

	private String[] inicializaQueryNumero14(String[] ListaQuerys, String cve_armadora) 
	{
		for (int i=0;i <ListaQuerys.length; i++)
		{
			ListaQuerys[i]= ListaQuerys[i].replace("{CVE_ARMADORA}", cve_armadora);						
		}
		return ListaQuerys;
	}
	
	private String[] inicializaQueryNumero47(String[] ListaQuerys, String articulo) 
	{
		for (int i=0;i <ListaQuerys.length; i++)
		{
			ListaQuerys[i]= ListaQuerys[i].replace("{ARTICULO}", articulo);						
		}
		return ListaQuerys;
	}
	
	private String[] inicializaQueryNumero18(String[] ListaQuerys, String descBusqueda) 
	{
		for (int i=0;i <ListaQuerys.length; i++)
		{
			ListaQuerys[i]= ListaQuerys[i].replace("{DESCRIPCION}", descBusqueda);						
		}
		return ListaQuerys;
	}
	
	private String[] inicializaQueryNumero22(String[] ListaQuerys, String num_articulo) 
	{
		for (int i=0;i <ListaQuerys.length; i++)
		{
			ListaQuerys[i]= ListaQuerys[i].replace("{NUM_ARTICULO}", num_articulo);						
		}
		return ListaQuerys;
	}
	
	private String[] inicializaQueryNumero44(String[] ListaQuerys, InfoCliente infoCliente, String num_art) {
		for (int i=0;i <ListaQuerys.length; i++)
		{
			ListaQuerys[i]= ListaQuerys[i].replace("{ARTICULO}", num_art);
			ListaQuerys[i]= ListaQuerys[i].replace("{CVE_CENTRO}", String.valueOf(infoCliente.getCentro()));
		}
		return ListaQuerys;
	}

	
	
}
