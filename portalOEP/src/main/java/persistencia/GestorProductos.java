package persistencia;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Properties;
import java.util.stream.Collectors;
import java.util.function.Function;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrQuery.ORDER;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocumentList;

import datos.Articulos;
import datos.DetalleArticulo;
import datos.Querys;
import datos.SugerenciaBusqueda;
import util.Cls_Querys;

public class GestorProductos {

	DecimalFormat formatoDecimal = new DecimalFormat("#,###.00");
	private  static Properties properties = null;
	 static 
	 {
	      try  
	      {
		      properties = new Properties();
		      InputStream  inputStream  = GestorProductos.class.getClassLoader().getResourceAsStream("/properties/oep.properties");
		      properties.load(inputStream);
	      }
	      catch  (Exception ex) 
	      {
	        ex.printStackTrace();
	      }
	 }	
	 
	 private static final SolrClient CLIENTE_SOLR = new HttpSolrClient.Builder(properties.getProperty("URL_SEVIDOR_SOLR")).build();
	 private static final SolrClient CLIENTE_SOLR_APLICACIONES = new HttpSolrClient.Builder(properties.getProperty("URL_SEVIDOR_SOLR_APLICACION")).build();
	
	/*2021-10-20 *****  AUTOCOMPLETADO DE SUGERENCIAS BUSQUEDA GENERADO POR ANDRES EN BXA Mayorista  ******/ 
	public Collection<SugerenciaBusqueda> consultaSugerenciasBusquedaBxA(String desBusqueda)
	{
		List<SugerenciaBusqueda> listaArticulos = new ArrayList<>();
		desBusqueda = desBusqueda.replace("_", " ");
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
				if (listaArticulos.stream().collect(Collectors.toConcurrentMap(SugerenciaBusqueda::getArticulo, Function.identity(), (p, q) -> p)).values().size() <15) 
				{
					desBusqueda = desBusqueda.replace(" ", "_");
					listaArticulos =  consultaSugerenciasBusquedaSolrAplicacionAplicacionVentaEnLinea(desBusqueda,listaArticulos,15 - listaArticulos.stream().collect(Collectors.toConcurrentMap(SugerenciaBusqueda::getArticulo, Function.identity(), (p, q) -> p)).values().size());
				}
				
		}
		catch(Exception ex)
		{
			System.out.println("[Portal OEP ]  Error: Consultar sugerencias de busqueda.,  Clase: GestorCarritoDeCompras,  Detalle: " + ex +"]");
			System.out.println("[Portal OEP ]  Error: Consultar sugerencias de busqueda.,  Clase: GestorCarritoDeCompras,  Detalle: " + ex.getMessage().toString() +"]");
		}
		
		return listaArticulos.stream().collect(Collectors.toConcurrentMap(SugerenciaBusqueda::getArticulo, Function.identity(), (p, q) -> p)).values();
	}
	
	private SolrDocumentList consultaSolar(String desBusqueda) 
	{
		
		SolrDocumentList resultadosArt = null;		
		try
		{
			String sentencia = " (marca: OEP OR proveedor:OEP) AND ( num_art_prov:" + "*" + desBusqueda.replace("-", "")+"* OR "
							 + " num_art_prov_sin_guion:"+ "*" +desBusqueda.replace("-", "")+"* OR "
							 + " descripcion_producto:"+ "*" +desBusqueda.replace("-", "")+"* OR "
							 + " num_art_cdo:"+ "*" +desBusqueda.replace("-", "")+"* OR "
							 + " num_art_cdo_sin_guion:"+ "*" +desBusqueda.replace("-", "")+"* OR "
							 + " num_art_anterior:"+ "*" +desBusqueda.replace("-", "")+"* OR "
							 + " num_art_anterior_sin_guion:"+ "*" +desBusqueda.replace("-", "")+"* OR "
							 + " intercambios:"+ "*" +desBusqueda.replace("-", "")+"* OR "
							 + " intercambios_sin_guion:"+ "*" +desBusqueda.replace("-", "")+"*  "
							+ ") ";
			//  System.out.println(" consultaSolar sentencia : "+ sentencia );
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
			QueryResponse respuestaSolr = CLIENTE_SOLR.query(query);
	        resultadosArt = respuestaSolr.getResults();
		}
		catch(Exception ex)
		{
			System.out.println("[Portal OEP ] Error: Consultar sugerencias en Solr,  Clase: GestorCarritoDeCompras,  Detalle: " + ex.getMessage().toString() +"]");
		}
		return resultadosArt;
	}
	
	private List<SugerenciaBusqueda> consultaSugerenciasBusquedaSolrAplicacionAplicacionVentaEnLinea(String desBusqueda,List<SugerenciaBusqueda> listaArticulos, int faltantes) 
	{
		try
		{
			SolrDocumentList resultadosArt = qryConsultaGeneralAticulosEnSolrAPLICACION(desBusqueda);
			if(desBusqueda.length()>1 && String.valueOf(desBusqueda.charAt(desBusqueda.length()-1)).equals("-"))
			{
				desBusqueda = desBusqueda.substring(0, desBusqueda.length()-1);
			
			}
			desBusqueda = desBusqueda.toUpperCase();		
			String [] campos = {"a_criterio_descripcion_submodelo_anio","a_criterio_submodelo_descripcion_anio","a_criterio_anio_submodelo_descripcion","a_criterio_descripcion_anio_submodelo","a_criterio_anio_descripcion_submodelo","a_criterio_submodelo_descripcion","a_criterio_descripcion_submodelo","a_criterio_descripcion_anio","a_criterio_anio_descripcion","a_criterio_submodelo_anio","a_criterio_anio_submodelo"};
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
									aa.setArticulo(split[k].replace("_"," "));
									listaArticulos.add(aa);
									break;
								}
							}
						}
						else
						{
							a.setArticulo(resultadosArt.get(i).getFieldValue(campos[j]).toString().replace("[","").replace("]","").replace("_"," "));
							listaArticulos.add(a);
						}
						break;
					}
				}
			}
			
		}
		catch (Exception ex) 
		{
			System.out.println("[Portal OEP ]  Error: Consultar sugerencias de busqueda en aplicacion.,  Clase: GestorCarritoDeCompras.consultaSugerenciasBusquedaSolrAplicacionAplicacionVentaEnLinea,  Detalle: " + ex+"]");
			System.out.println("[Portal OEP ]  Error: Consultar sugerencias de busqueda en aplicacion.,  Clase: GestorCarritoDeCompras,  Detalle: " + ex.getMessage().toString() +"]");
		}
		return listaArticulos;
	}
	
	
	/******    FORMA QUERYS SEGUN LA BUSQUEDA DE ARTICULOS  APLICACION  ******/
	private SolrDocumentList qryConsultaGeneralAticulosEnSolrAPLICACION(String descArticulo)
	{

		SolrDocumentList resultadosArt = null;		
		try
		{
			
			
			String sentencia = "";

				if(descArticulo.trim().length() > 0)
				{
 					sentencia +=   "(marca: OEP OR proveedor:OEP) AND ( a_num_art_cdo:" + descArticulo.replace(" ", "_")+"*" + 
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
			QueryResponse respuestaSolr = CLIENTE_SOLR_APLICACIONES.query(query);
	       resultadosArt = respuestaSolr.getResults();
	       
	      // System.out.println("CLIENTE_SOLR_APLICACIONES: " + properties.getProperty("URL_SEVIDOR_SOLR_APLICACION").toString());
           //  System.out.println("CLIENTE_SOLR_APLICACIONES Query: " + sentencia);

		}
		catch(Exception ex)
		{
			System.out.println("[Portal OEP ]  Error: Consultar articulos por parametro en Solr APLICACION,  Clase: GestorCarritoDeCompras,  Detalle: " + ex.getMessage().toString() +"]");

		}
		return resultadosArt;
	}
	
	
	public List<Articulos> consultaGeneralArticulos(List<Querys> listaQuerys, String descArticulo)
	{	
	//	System.out.println("....1");
		List<Articulos> listaArticulos = new ArrayList<>(); 
		try
		{

			SolrDocumentList resultadosArt = qryConsultaGeneralAticulosEnSolrAPLICACION(descArticulo);

		 //	System.out.println("resultadosArt: " + resultadosArt);
			
			List<String> lista  = llenaListaeArticulosDesdeSolrAplicacion(resultadosArt);

	

			SolrDocumentList resultados = qryConsultaGeneralAticulosEnSolr(lista);

			listaArticulos= llenaClaseArticulos2(resultados, descArticulo, true,lista);

		}
		catch(Exception  ex)
		{
			System.out.println("[Portal OEP ] Error: Consulta general de articulos consultaGeneralArticulos(),  Clase: GestorCarritoDeComprasv2.consultaGeneralArticulos,  Detalle: " + ex.toString() +"]");
			
		}
	//	System.out.println("....2");
		return listaArticulos;
	}
	
	private List<String> llenaListaeArticulosDesdeSolrAplicacion(SolrDocumentList resultadosArt)
	{
		List<String> listaArticulos = new ArrayList<String>();
		String articuloAuxiliar ="";
		try
		{
			for (int i = 0; i < resultadosArt.size(); ++i)
			{   
					if (!articuloAuxiliar.equalsIgnoreCase(resultadosArt.get(i).getFieldValue("a_id").toString()))
					{
						listaArticulos.add(resultadosArt.get(i).getFieldValue("a_num_art_cdo").toString().replace("[", "").replace("]", ""));
						articuloAuxiliar = resultadosArt.get(i).getFieldValue("a_num_art_cdo").toString();
					} 			
	        }			

		}
		catch(Exception ex)
		{
			System.out.println("[Portal OEP ] Error: Llenar clase de Articulos con Solr ,  Clase: llenaListaeArticulosDesdeSolrAplicacion,  Detalle: " + ex.getMessage().toString() +"]");
			return listaArticulos;
		}
		return listaArticulos;
	}

	/******    FORMA QUERYS SEGUN LA BUSQUEDA DE ARTICULOS    ******/
	private SolrDocumentList qryConsultaGeneralAticulosEnSolr(List<String> lista)
	{

		SolrDocumentList resultadosArt = null;		
		try
		{ 
			//System.out.println("lista.size(): "+ lista.size() );
		
			String sentencia = "";
			for (int i=0; i <  lista.size(); i++) 
			{
				// System.out.println("lista: "+ lista.get(i).replace("[", "").replace("]", "")  );
				 
				 
				if(lista.get(i).replace("-", "").trim().length() > 0)
				{
					if(i > 0 && !sentencia.equals(""))
					{
						sentencia += " and ";
					}
					sentencia +=   "(marca: OEP OR proveedor:OEP) AND (id:" + lista.get(i).replace("[", "").replace("]", "") +
								
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
			// System.out.println("qryConsultaGeneralAticulosEnSolr querySOLR: "+sentencia );
			 
			 
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
			System.out.println("[Portal OEP ] Error: Consultar articulos por parametro en Solr,  Clase: GESTOR-2.qryConsultaGeneralAticulosEnSolr,  Detalle: " + ex.getMessage().toString() +"]");
			resultadosArt = new SolrDocumentList();	
		}
		return resultadosArt;
	}
	
	private List<Articulos> llenaClaseArticulos2(SolrDocumentList resultadosArt,  String descArticulo, boolean validaCombioNumero, List<String>  lista )
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
			System.out.println("[Portal OEP ] Error: Llenar clase de Articulos con Solr llenaClaseArticulos2() ,  Clase: GestorCarritoDeCompras,  Detalle: " + ex.getMessage().toString() +"]");
		}
		return listaArticulos;
	}
	
	private static String getTwoDecimals(String valor){
	    DecimalFormat df = new DecimalFormat("0.00");
	    return df.format(Double.parseDouble(valor));
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
	
	
	public List<DetalleArticulo> consultaDetalLeArticulo(Connection connBD, List<Querys> listaQuerys, String articulo, List<DetalleArticulo> listaArticulos) 
	{
		PreparedStatement pstm = null;
		
		try 
		{
			String [] querys = new String [25];
			querys = Cls_Querys.LimpiaListaQuerys(querys);
			querys = Cls_Querys.ObtieneQuerys(2, listaQuerys, querys);
			querys= inicializaQueryNumero2(querys,articulo);
			pstm = connBD.prepareStatement("{call " + "comercio_electronico.usp_EXECUTE_QUERY(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			ResultSet rs = Cls_Querys.EjecutarQuery(querys[0], querys[1],querys[2], querys[3], querys[4], querys[5], querys[6],
					 querys[7], querys[8], querys[9],querys[10], querys[11], querys[12], querys[13], 
					 querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], 
					 querys[21], querys[22], querys[23], querys[24], "",pstm, connBD);
		
			
			if(rs != null)
			{
				listaArticulos = llenarDetalleArticulo(rs, listaArticulos);
			}
 
		}
		catch(Exception ex)
		{
			System.out.println("[Portal OEP ] Error: Consultar detalle de articulo,  Clase: GestorCarritoDeCompras,  Detalle: " + ex.getMessage().toString() +"]");
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
			System.out.println("[Portal OEP ]  Error al cargar clientes");
		}
		return listaArticulos;
	}
	
	private String[] inicializaQueryNumero2(String[] ListaQuerys, String articulo) {
		for (int i=0;i <ListaQuerys.length; i++)
		{
			ListaQuerys[i]= ListaQuerys[i].replace("{ARTICULO}", articulo);						
		}
		return ListaQuerys;
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
	
	public List<Articulos> consultaPorVehiculo(List<Querys> listaQuerys, String descMarca, String descAuto, String descModelo )
	{	
		List<Articulos> listaArticulos = new ArrayList<>(); 
		try
		{
			SolrDocumentList resultadosArt = qryConsultaAutomovilAticulosEnSolr(descMarca,descAuto,descModelo);
			listaArticulos = llenaClaseArticulosPorVehiculo(resultadosArt, descMarca,  false,descMarca,descAuto,descModelo);
 
		}
		catch(Exception  ex)
		{
			System.out.println("[ Portal OEP ]  Error: Consultar articulos por vehiculo,  Clase: GestorProductos.consultaPorVehiculo,  Detalle: " + ex.getMessage().toString() +"]");
			
		}
		return listaArticulos;
	}
	
	public List<Articulos> consultaPorGrupo(List<Querys> listaQuerys, String grupo)
	{	
		List<Articulos> listaArticulos = new ArrayList<>(); 
		try
		{
			SolrDocumentList resultadosArt = qryConsultaAutomovilAticulosEnSolrPorGrupo(grupo);
			listaArticulos = llenaClaseArticulosPorGrupo(resultadosArt);
 
		}
		catch(Exception  ex)
		{
			System.out.println("[ Portal OEP ]  Error: Consultar articulos por vehiculo,  Clase: GestorProductos.consultaPorVehiculo,  Detalle: " + ex.getMessage().toString() +"]");
			
		}
		return listaArticulos;
	}
	
	private SolrDocumentList qryConsultaAutomovilAticulosEnSolr(String descMarca,String descAuto, String descModelo)
	{
		SolrDocumentList resultadosArt = null;		
		try
		{
			String sentencia = "(marca: OEP OR proveedor:OEP) AND ";
			if(!descMarca.equals("-- Marca --"))
			{
				sentencia += "modelo:" + descMarca; 
			}
			
			if(!descAuto.equals("0"))
			{
				if(sentencia.length() > 0)
				{
					sentencia +=" AND ";
				}
				sentencia+="submodelo:" + descAuto;
			}
			
			if(!descModelo.equals("0"))
			{
				if(sentencia.length() > 0)
				{
					sentencia +=" AND ";
				}
				sentencia+= "(anio:[" + descModelo + " TO *] AND anio: [* TO " + (Integer.parseInt(descModelo) + 1)+ "])" ;
			}

			
			SolrQuery  query = new SolrQuery();
			query.setStart(0);
			query.setRows(1000);
			query.setSort("orden", ORDER.asc);
			//query.addSort("nombre_producto", ORDER.asc);
			query.addSort("rk", ORDER.asc);
			
			//query.addSort("num_art_cdo", ORDER.asc);
			
			query.setQuery(sentencia);
			QueryResponse respuestaSolr = CLIENTE_SOLR.query(query);
	        resultadosArt = respuestaSolr.getResults();
	        
	      // System.out.println("Query Busqueda por Auto: " + sentencia);
		}
		catch(Exception ex)
		{
			System.out.println("[ Portal OEP ] Error: Consultar articulos por automovil en Solr,  Clase:GestorProductos.qryConsultaAutomovilAticulosEnSolr,  Detalle: " + ex.getMessage().toString() +"]");
		}
		return resultadosArt;
	}
	
	private SolrDocumentList qryConsultaAutomovilAticulosEnSolrPorGrupo(String grupo)
	{
		SolrDocumentList resultadosArt = null;		
		try
		{
			String sentencia = "(marca: OEP OR proveedor:OEP) AND ";
			 
				sentencia += "grupo:" + grupo; 
		 
			
			SolrQuery  query = new SolrQuery();
			query.setStart(0);
			query.setRows(1000);
			query.setSort("orden", ORDER.asc);
			//query.addSort("nombre_producto", ORDER.asc);
			query.addSort("rk", ORDER.asc);
			
			//query.addSort("num_art_cdo", ORDER.asc);
			query.setQuery(sentencia);
			QueryResponse respuestaSolr = CLIENTE_SOLR.query(query);
	        resultadosArt = respuestaSolr.getResults();
	        
	      //  System.out.println("Query Busqueda por Grupo: " + sentencia);
		}
		catch(Exception ex)
		{
			System.out.println("[ Portal OEP ] Error: Consultar articulos por automovil en Solr,  Clase:GestorProductos.qryConsultaAutomovilAticulosEnSolr,  Detalle: " + ex.getMessage().toString() +"]");
		}
		return resultadosArt;
	}
	
	/******  LLENA CLASE DE ARTICULOS   ******/
	private List<Articulos> llenaClaseArticulosPorVehiculo(SolrDocumentList resultadosArt,  String descArticulo, boolean validaCombioNumero, String marca, String subModelo, String anio)
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

					articulo.setAnio(anio);
					articulo.setTipo_catalogo(resultadosArt.get(i).getFieldValue("tipo_catalogo").toString());
					articulo.setPrecio_iva(String.valueOf(getTwoDecimals(String.valueOf(Float.parseFloat(preciolista)*1.16))));
					
					articulo.setArmadora(marca);
					articulo.setCilindros(resultadosArt.get(i).getFieldValue("cilindros").toString().replace("[","").replace("]", ""));
			
					articulo.setDescripcion(validaNombreProducto(resultadosArt.get(i).getFieldValue("descripcion").toString()).toString().replace("[","").replace("]", ""));
					
					articulo.setNombre_producto(resultadosArt.get(i).getFieldValue("nombre_producto").toString());
					articulo.setGrupo(resultadosArt.get(i).getFieldValue("grupo").toString());
					articulo.setDescripcion_producto(String.valueOf(resultadosArt.get(i).getFieldValue("descripcion_producto")));
					articulo.setTipo_gasolina(String.valueOf(resultadosArt.get(i).getFieldValue("tipo_gasolina")));
					articulo.setCaracteristicas(String.valueOf(resultadosArt.get(i).getFieldValue("caracteristicas")).replace("[","").replace("]", ""));
					articulo.setLitros(resultadosArt.get(i).getFieldValue("litros").toString().toString().replace("[","").replace("]", ""));
					articulo.setMarca(resultadosArt.get(i).getFieldValue("marca").toString());
	
					// articulo.setModelo(resultadosArt.get(i).getFieldValue("modelo").toString());
					articulo.setModelo(subModelo);
					
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
			System.out.println("[Portal OEP ] Error: Llenar clase de Articulos con Solr ,  Clase: GestorCarritoDeCompras,  Detalle: " + ex.getMessage().toString() +"]");

		}
		return listaArticulos;
	}
	
	private List<Articulos> llenaClaseArticulosPorGrupo(SolrDocumentList resultadosArt  )
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
 
					articulo.setMarcaIntercambio(validaSiEsIntercambio("",resultadosArt.get(i).getFieldValue("intercambios_sin_guion").toString(), 
																	 resultadosArt.get(i).getFieldValue("num_art_cdo").toString().replace("-", ""),
																	 resultadosArt.get(i).getFieldValue("num_art_anterior").toString().replace("[", "").replace("]", "").trim().replace("-", "")));
				 
					articulo.setCve_venta(resultadosArt.get(i).getFieldValue("cve_venta").toString().replace("[", "").replace("]", "").trim());
					articulo.setMultiplo_rc(resultadosArt.get(i).getFieldValue("multiplo_rc").toString().replace("[", "").replace("]", "").trim());
				
					articulo.setProdutcsId(resultadosArt.get(i).getFieldValue("products_id").toString().trim());
					articulo.setCustomAttrs(resultadosArt.get(i).getFieldValue("custom_attrs").toString().trim());
					
					
					if(validaOrdenamiento("", resultadosArt.get(i).getFieldValue("num_art_cdo").toString().replace("-", "")).equals("*") ||
					   validaOrdenamiento("", resultadosArt.get(i).getFieldValue("num_art_anterior").toString().replace("[", "").replace("]", "").trim().replace("-", "")).equals("*"))
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
			System.out.println("[Portal OEP ] Error: Llenar clase de Articulos con Solr ,  Clase: GestorCarritoDeCompras,  Detalle: " + ex.getMessage().toString() +"]");

		}
		return listaArticulos;
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
}
