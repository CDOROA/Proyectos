package persistencia;

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
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocumentList;
import org.apache.zookeeper.server.ExitCode;
import org.json.JSONArray;
import org.json.JSONObject;

import datos.Articulos;
import datos.Querys;
import datos.SugerenciaBusqueda;

public class GestorCarritoDeCompras {

	DecimalFormat formatoDecimal = new DecimalFormat("#,###.00");
	private  static Properties properties = null;
	
	 static 
	 {
	      try  
	      {
		      properties = new Properties();
		      InputStream  inputStream  = GestorCarritoDeCompras.class.getClassLoader().getResourceAsStream("/properties/oep.properties");
		      properties.load(inputStream);
		      
	      }
	      catch  (Exception ex) 
	      {
	        ex.printStackTrace();
	      }
	 }	
	
	private static final SolrClient CLIENTE_SOLR = new HttpSolrClient.Builder(properties.getProperty("URL_SEVIDOR_SOLR")).build();
	private static final SolrClient CLIENTE_SOLR_APLICACIONES = new HttpSolrClient.Builder(properties.getProperty("URL_SEVIDOR_SOLR_APLICACION")).build();

	/******   TIPOS DE  CONSULTA DE ARTICULOS    ******/
	public List<Articulos> consultaGeneralArticulos(List<Querys> listaQuerys, String descArticulo)
	{	
		List<Articulos> listaArticulos = new ArrayList<>(); 
		try
		{
			SolrDocumentList resultadosArt = qryConsultaGeneralAticulosEnSolr(descArticulo);
			listaArticulos= llenaClaseArticulos(resultadosArt, descArticulo, true);
		}
		catch(Exception  ex)
		{
			System.out.println("[Portal OEP ]  Error: Consulta general de articulos consultaGeneralArticulos,  Clase: GestorCarritoDeCompras,  Detalle: " + ex.getMessage().toString() +"]");
		}	
		return listaArticulos;
	}
	
	/******    FORMA QUERYS SEGUN LA BUSQUEDA DE ARTICULOS    ******/
	private SolrDocumentList qryConsultaGeneralAticulosEnSolr(String descArticulo) 
	{

		SolrDocumentList resultadosArt = null;		
		try
		{
			
			String arrayDesActr[]= descArticulo.split(" ");
			String sentencia = "";
			for (int i=0; i <  arrayDesActr.length; i++) 
			{
		 
				if(arrayDesActr[i].replace("-", "").trim().length() > 0)
				{
					if(i > 0 && !sentencia.equals(""))
					{
						sentencia += " AND ";
					}
					sentencia +=   "(marca: OEP OR proveedor: OEP) AND (num_art_cdo:" + arrayDesActr[i].replace("-", "")+"*" + 
								   " OR num_art_prov:" + arrayDesActr[i].replace("-", "") +"*" +
								   " OR num_art_cdo_sin_guion:" + arrayDesActr[i].replace("-", "") +"*" +
								   " OR num_art_prov_sin_guion:" + arrayDesActr[i].replace("-", "") +"*" +
								   " OR num_art_anterior_sin_guion:" + arrayDesActr[i].replace("-", "") +"*" +
								   " OR intercambios:" + arrayDesActr[i].replace("-", "") +"*" +
								   " OR intercambios_sin_guion:" + arrayDesActr[i].replace("-", "") +"*" +
								   " OR proveedor:" + arrayDesActr[i].replace("-", "") +"*" +
								   " OR marca:" + arrayDesActr[i].replace("-", "") +"*" +
								   " OR descripcion:" + arrayDesActr[i].replace("-", "") +"*" +
								   " OR armadora:" + arrayDesActr[i].replace("-", "") +"*" +
								   " OR modelo:" + arrayDesActr[i].replace("-", "") +"*" +
								   " OR grupo:" + arrayDesActr[i].replace("-", "") +"*" +
								   " OR submodelo:" + arrayDesActr[i].replace("-", "") +"*" +
								   " OR num_original:" + arrayDesActr[i].replace("-", "") +"*" +
					 			   " OR cilindros:" + arrayDesActr[i].replace("-", "") +"*" +
					 			   " OR litros:" + arrayDesActr[i].replace("-", "")+"*"  ;
					
					//sentencia += ") ";
					try
					{
						int anio = Integer.parseInt(arrayDesActr[i].replace("-", ""));
						if(String.valueOf(String.valueOf(anio).length()).equals("4")){
							// sentencia += " OR (anio:[" + anio + " TO *] AND anio: [* TO " + (anio + 1)+ "]))" ;
							sentencia += " OR anio:" + anio + ")" ;
							
						}
						else{
							sentencia += ") ";
						}
						
					}
					catch(Exception ex)
					{
						sentencia += ") ";
					}
				}
				
			}
 
			//System.out.println( "querysolor v1: " +sentencia);
			
			SolrQuery  query = new SolrQuery();
			query.setStart(0);
			query.setRows(1000);
			query.setSort("orden", ORDER.asc);
			// query.addSort("nombre_producto", ORDER.asc);
			String rnk =  "cdf_rnk";
			query.addSort( rnk, ORDER.asc);
			//query.addSort("num_art_cdo", ORDER.asc);
			query.setQuery(sentencia);

 
			QueryResponse respuestaSolr = CLIENTE_SOLR.query(query);
	        resultadosArt = respuestaSolr.getResults();	  
	        
	        
		}
		catch(Exception ex)
		{
			System.out.println("[Portal OEP ]  Error: Consultar articulos por parametro en Solr,  Clase: GestorCarritoDeCompras,  Detalle: " + ex.getMessage().toString() +"]");

		}
		return resultadosArt;
	}
	
/******  LLENA CLASE DE ARTICULOS   ******/
	private List<Articulos> llenaClaseArticulos(SolrDocumentList resultadosArt,  String descArticulo, boolean validaCombioNumero)
	{
		List<Articulos> listaArticulos = new ArrayList<>();
		try
		{
			String cambioNumeroNuevo="";	
			for (int i = 0; i < resultadosArt.size(); ++i) 
	        {   
				if(!resultadosArt.get(i).getFieldValue("vigencia").toString().trim().equals("*"))
				{
	
					 String preciolista= resultadosArt.get(i).getFieldValue("precio").toString();

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
					
					articulo.setCve_venta(resultadosArt.get(i).getFieldValue("cve_venta").toString().replace("[", "").replace("]", "").trim());
					articulo.setMultiplo_rc(resultadosArt.get(i).getFieldValue("multiplo_rc").toString().replace("[", "").replace("]", "").trim());
				
					articulo.setProdutcsId(resultadosArt.get(i).getFieldValue("products_id").toString().trim());
					articulo.setCustomAttrs(resultadosArt.get(i).getFieldValue("custom_attrs").toString().trim());
					
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
			System.out.println("[Portal OEP ]  Error: Llenar clase de Articulos con Solr ,  Clase: GestorCarritoDeCompras,  Detalle: " + ex.getMessage().toString() +"]");
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
			if(arrayDesActr[i].replace("-", "").trim().length() > 0)
			{
				for(int e = 0; e < arrayDescIntercambios.length; e++)
				{
					if(arrayDescIntercambios[e].equals(arrayDesActr[i].replace("-", "")))
					{
						if(!arrayDescIntercambios[e].equals(numArtSinGuion) && !arrayDescIntercambios[e].equals(numartAnterior))
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
	

	private static String getTwoDecimals(String valor){
	    DecimalFormat df = new DecimalFormat("0.00");
	    return df.format(Double.parseDouble(valor));
	}
}
