package cdo.Persistencia;

import java.io.StringReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import cdo.Entidades.AutoTransporte;
import cdo.Entidades.Comprobante;
import cdo.Entidades.ComprobanteCartaPorte;
import cdo.Entidades.ComprobanteTransporte;
import cdo.Entidades.Conceptos;
import cdo.Entidades.EjecutaQuerysBD;
import cdo.Entidades.Emisor;
import cdo.Entidades.Mercancias;
import cdo.Entidades.Operador;
import cdo.Entidades.Querys;
import cdo.Entidades.Receptor;
import cdo.Entidades.Respuesta;
import cdo.Entidades.TotalMercancias;
import cdo.Entidades.Ubicaciones;
import cdo.Entidades.XML;
import cdo.Servicios.wsUsuario;
import cdo.Util.Cls_Querys;
import cdo.Util.Cls_log;
import cdo.Util.ConexionBD;

public class GestorProcesarXML {
	 Cls_log log = new Cls_log();
	private static XML objXML = new XML();
	private boolean rsp = false;
	private static Respuesta objRespuesta = new Respuesta();
	private static String trayecto = "0";
	private static String uname_br_gestor = "";
	private static String folio_carta = "";
	private static String serie = "";
	private static int folio = 0;
	public GestorProcesarXML() 
	{
		super();
	}

	public Respuesta GenerarCFDICartaPorte(List<Querys> listaQuerys, Respuesta respuesta, String cdo, String uname_br, String id_trayecto) 
	{
		try 
		{
			folio_carta = "";
			objRespuesta = respuesta;
			trayecto = id_trayecto;
			uname_br_gestor = uname_br;
			serie = respuesta.getSerie();
			folio = respuesta.getFolio();
			
			 llenarObjetosDeXML(listaQuerys);
			 if (rsp) 
			 {
				 ejecutarInsertsEnBD(cdo, listaQuerys);
				 objRespuesta.setConceptos(null);
				 objRespuesta.setCodigoCBB(null);
				 objRespuesta.setCodigoXML(null);
			 }
			 
        } 
		catch (Exception e) 
		{
			log.Insrtalog(cdo, serie, folio, "Error en metodo principal GenerarCFDICartaPorte. ERROR: "+e.getMessage());
			//System.out.println.println("Error al generar CFDI Carta Porte: "+e.getMessage().toString());
        }
		 
		return objRespuesta;
	}

	private void ejecutarInsertsEnBD(String cdo,List<Querys> ListaQuerys) 
	{
		
		try
		{
			//System.out.println.println("ejecutarInsertsEnBD...1");
			Connection connBD = null;
	        PreparedStatement pstmt = null;
	        ResultSet rs = null;
	         
	        try
	        {
	        	
	        	String[] querys = new String[25];
	        	connBD = ConexionBD.AbrirConexionBDD(cdo);
	        	//System.out.println.println("ejecutarInsertsEnBD...2: " + ListaQuerys);
	        	querys = inicializacionQrys(querys, ListaQuerys, cdo, 2);
	        	//System.out.println.println("ejecutarInsertsEnBD...3");
	        	  Cls_Querys.ImprimeQuerysConsola(querys,false, "ejecutarInsertsEnBD query 2");
	        	  
	        	// Arrays.asList(querys).forEach(//System.out.println::println);
	            pstmt = connBD.prepareStatement("{call " + cdo.toUpperCase() + ".usp_EXECUTE_QUERY_CP(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
	            
	            rs = EjecutaQuerysBD.EjecutarQuery(querys[0], querys[1], querys[2], querys[3], querys[4], querys[5], querys[6], querys[7], querys[8], querys[9], querys[10], querys[11], querys[12], querys[13], querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], querys[21], querys[22], querys[23], querys[24], cdo, pstmt, connBD);
	            objRespuesta.setMsjExitoso("Se genero e inserto correctamnete el Sellado de Carta Porte");
	            objRespuesta.setRespuesta(true);
	            
	            //System.out.println.println("ejecutarInsertsEnBD...4");
	        }
	        catch (Exception e) 
	        {
	        	//System.out.println.println("Error al ejecutatar qury en BD: " + e.getMessage());
	        	rsp = false;
			}
	        finally
	        {
				connBD.close();
				pstmt.close();
			}
		}
		catch (Exception e) 
		{
			log.Insrtalog(cdo, serie, folio, "Error al llenar insertar en BD XML. ERROR: "+e.getMessage());
			objRespuesta.setMsjError("Error al llenar insertar en BD XML. ERROR: "+e.getMessage());
			objRespuesta.setRespuesta(false);
			rsp = false;
		}
	}
	
	

	private void consultarEmisorReceptor(List<Querys> ListaQuerys) 
	{
		if (rsp)
		{
			try
			{
				Connection connBD = null;
		        PreparedStatement pstmt = null;
		        ResultSet rs = null;
		        String cdo = "cdf";
		        Emisor objEmisor = new Emisor();
		        Receptor objReceptor = new Receptor();
		        try
		        {
		        	String[] querys = new String[25];
		        	
		        	connBD = ConexionBD.AbrirConexionBDD(cdo);
		        	querys = GestorUsuario.inicializacionQrys(querys,ListaQuerys,cdo,1,19);
		            pstmt = connBD.prepareStatement("{call " + cdo.toUpperCase() + ".usp_EXECUTE_QUERY_CP(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
		            
		            Cls_Querys.ImprimeQuerysConsola(querys,false, "consultarEmisorReceptor");
		            
		            rs = EjecutaQuerysBD.EjecutarQuery(querys[0], querys[1], querys[2], querys[3], querys[4], querys[5], querys[6], querys[7], querys[8], querys[9], querys[10], querys[11], querys[12], querys[13], querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], querys[21], querys[22], querys[23], querys[24], cdo, pstmt, connBD);
					llenarObjetoEmisorReceptor(rs,objEmisor,objReceptor);
		        }
		        catch (Exception e) 
		        {
		        	//System.out.println.println("Error al consultar emisor en BD+"+e.getMessage());
		        	rsp = false;
				}
		        finally
		        {
					connBD.close();
					pstmt.close();
				}
			}
			catch (Exception e) 
			{
				rsp = false;
			}
		}
		
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static String[] inicializacionQrys(String[] querys, List<Querys> ListaQuerys, String cdo, int noQry) 
	{
		querys = Cls_Querys.LimpiaListaQuerys(querys);
        querys = ObtieneQuerys(noQry, (List)ListaQuerys, querys, cdo,objXML);
    	return querys;
	}

	public static String[] ObtieneQuerys(int noQuery, List<Querys> ListaTodosQuerys, String[] ListaQuerys,  String cdo, XML objXML)
	{
		String[] querys = ListaQuerys;
		int cont = 0;
		String qry="";
		for(int item = 0; item < ListaTodosQuerys.size(); item++)
		{
			if(ListaTodosQuerys.get(item).getIndice_query() == noQuery)
			{
				//  //System.out.println.println("ObtieneQuerys getSub_indice_query "+ListaTodosQuerys.get(item).getSub_indice_query());
				switch (ListaTodosQuerys.get(item).getSub_indice_query()) 
				{
					case 1:
						qry= ListaTodosQuerys.get(item).getQuery().toString();
						qry = sentenciaAutoTransporte(qry,cdo);
						querys[cont] = qry;
						cont++;
						break;
					case 2:
						qry= ListaTodosQuerys.get(item).getQuery().toString();
						qry = sentenciaComprobanteCartaPorte(qry,cdo);
						querys[cont] = qry;
						cont++;
						break;
					case 3:
						qry= ListaTodosQuerys.get(item).getQuery().toString();
						qry = sentenciaComprobanteMercancias(qry,cdo);
						querys[cont] = qry;
						cont++;
						break;
					case 4:
						qry= ListaTodosQuerys.get(item).getQuery().toString();
						qry = sentenciaOperadores(qry,cdo);
						querys[cont] = qry;
						cont++;
						break;
					case 5:
						qry= ListaTodosQuerys.get(item).getQuery().toString();
						qry = sentenciaTotalMercancias(qry,cdo);
						querys[cont] = qry;
						cont++;
						break;
					case 6:
						qry= ListaTodosQuerys.get(item).getQuery().toString();
						qry = sentenciaComprobanteTransporte(qry,cdo);
						querys[cont] = qry;
						cont++;
						break;
					case 7:
						qry= ListaTodosQuerys.get(item).getQuery().toString();
						qry = sentenciaComprobanteUbicaciones(qry,cdo);
						querys[cont] = qry;
						cont++;
						break;
					case 8:
						qry= ListaTodosQuerys.get(item).getQuery().toString();
						qry = sentenciaComprobante(qry,cdo);
						querys[cont] = qry;
						cont++;
						break;
					case 9:
						qry= ListaTodosQuerys.get(item).getQuery().toString();
						qry = sentenciaConceptos(qry,cdo);
						querys[cont] = qry;
						cont++;
						break;
					case 10:
						qry= ListaTodosQuerys.get(item).getQuery().toString();
						qry = sentenciaEmisor(qry,cdo);
						querys[cont] = qry;
						cont++;
						break;
					case 11:
						qry= ListaTodosQuerys.get(item).getQuery().toString();
						qry = sentenciaReceptor(qry,cdo);
						querys[cont] = qry;
						cont++;
						break;
					case 12:
						qry= ListaTodosQuerys.get(item).getQuery().toString();
						qry = sentenciaUpdateFolio(qry,cdo);
						querys[cont] = qry;
						cont++;
						break;
					default:
						break;
				}
			}
		}
		return querys;
	}
	

	private static String sentenciaUpdateFolio(String qry, String cdo)
	{
		//UPDATE ALMACEN.tc_ENCABEZADO_TRAYECTO_CHOFER SET genera_carta_porte='G' WHERE uname_br='{CDO}' and id_trayecto='{TRAYECTO}' and num_chofer='{CHOFER}';
		// qry= qry.replace("{CHOFER}",trayecto);
		qry= qry.replace("{TRAYECTO}",trayecto);
		qry= qry.replace("{CDO}",uname_br_gestor);
		
		return qry;
	}

	private static String sentenciaReceptor(String qry, String cdo) 
	{
		qry= replaceIdentificadores(qry);
		qry= qry.replace("{RFC}",objXML.getReceptor().getRfc());
		qry= qry.replace("{NOMBRE}",objXML.getReceptor().getNombre());
		qry= qry.replace("{UNAME_RDF}",objXML.getReceptor().getUname_rdf());
		qry= qry.replace("{NUM_CLI}",objXML.getReceptor().getNum_cli());
		qry= qry.replace("{E_MAIL}",objXML.getReceptor().getE_mail());
		qry= qry.replace("{RDF_CALLE}",objXML.getReceptor().getRdf_calle());
		qry= qry.replace("{RDF_NOEXTERIOR}",objXML.getReceptor().getRdf_noexterior());
		qry= qry.replace("{RDF_NOINTERIOR}",objXML.getReceptor().getRdf_nointerior());
		qry= qry.replace("{RDF_COLONIA}",objXML.getReceptor().getRdf_colonia());
		qry= qry.replace("{RDF_LOCALIDAD}",objXML.getReceptor().getRdf_localidad());
		qry= qry.replace("{RDF_REFERENCIA}",objXML.getReceptor().getRdf_referencia());
		qry= qry.replace("{RDF_MUNICIPIO}",objXML.getReceptor().getRdf_municipio());
		qry= qry.replace("{RDF_ESTADO}",objXML.getReceptor().getRdf_estado());
		qry= qry.replace("{RDF_PAIS}",objXML.getReceptor().getRdf_pais());
		qry= qry.replace("{RDF_CODIGOPOSTAL}",objXML.getReceptor().getRdf_codigopostal());
		qry= qry.replace("{RDF_TELEFONO}",objXML.getReceptor().getRdf_telefono());
		qry= qry.replace("{DCON_CALLE}",objXML.getReceptor().getDcon_calle());
		qry= qry.replace("{DCON_NOEXTERIOR}",objXML.getReceptor().getDcon_noexterior());
		qry= qry.replace("{DCON_NOINTERIOR}",objXML.getReceptor().getDcon_nointerior());
		qry= qry.replace("{DCON_COLONIA}",objXML.getReceptor().getDcon_colonia());
		qry= qry.replace("{DCON_LOCALIDAD}",objXML.getReceptor().getDcon_localidad());
		qry= qry.replace("{DCON_REFERENCIA}",objXML.getReceptor().getDcon_referencia());
		qry= qry.replace("{DCON_MUNICIPIO}",objXML.getReceptor().getDcon_municipio());
		qry= qry.replace("{DCON_ESTADO}",objXML.getReceptor().getDcon_estado());
		qry= qry.replace("{DCON_PAIS}",objXML.getReceptor().getDcon_pais());
		qry= qry.replace("{DCON_CODIGOPOSTAL}",objXML.getReceptor().getDcon_codigopostal());
		qry= qry.replace("{DCON_TELEFONO}",objXML.getReceptor().getDcon_telefono());
		qry= qry.replace("{DCON_USOCFDI}",objXML.getReceptor().getDcon_UsoCFDI());

		return qry;
	}

	private static String sentenciaEmisor(String qry, String cdo) 
	{
		qry= replaceIdentificadores(qry);
		qry= qry.replace("{RFC}",objXML.getEmisor().getRfc());
		qry= qry.replace("{NOMBRE}",objXML.getEmisor().getNombre());
		qry= qry.replace("{UNAME_EDF}","");
		qry= qry.replace("{NUM_CLI}",objXML.getEmisor().getNum_cli());
		qry= qry.replace("{REGIMENFISCAL}","");
		qry= qry.replace("{EDF_CALLE}","");
		qry= qry.replace("{EDF_NOEXTERIOR}","");
		qry= qry.replace("{EDF_NOINTERIOR}","");
		qry= qry.replace("{EDF_COLONIA}","");
		qry= qry.replace("{EDF_LOCALIDAD}","");
		qry= qry.replace("{EDF_REFERENCIA}","");
		qry= qry.replace("{EDF_MUNICIPIO}","");
		qry= qry.replace("{EDF_ESTADO}","");
		qry= qry.replace("{EDF_PAIS}","");
		qry= qry.replace("{EDF_CODIGOPOSTAL}","");
		qry= qry.replace("{EDF_TELEFONO}","");
		qry= qry.replace("{DEXP_CALLE}","");
		qry= qry.replace("{DEXP_NOEXTERIOR}","");
		qry= qry.replace("{DEXP_NOINTERIOR}","");
		qry= qry.replace("{DEXP_COLONIA}","");
		qry= qry.replace("{DEXP_LOCALIDAD}","");
		qry= qry.replace("{DEXP_REFERENCIA}","");
		qry= qry.replace("{DEXP_MUNICIPIO}","");
		qry= qry.replace("{DEXP_ESTADO}","");
		qry= qry.replace("{DEXP_PAIS}","");
		qry= qry.replace("{DEXP_CODIGOPOSTAL}","");
		qry= qry.replace("{TELEFONO}","");
		qry= qry.replace("{FECHA_PRO}","CURDATE()");
		qry= qry.replace("{HORA_PRO}","CURTIME()");
		
		
		
		/*
		qry= qry.replace("{UNAME_EDF}",objXML.getEmisor().getUname_edf());
		qry= qry.replace("{NUM_CLI}",objXML.getEmisor().getNum_cli());
		qry= qry.replace("{REGIMENFISCAL}",objXML.getEmisor().getRegimenfiscal());
		qry= qry.replace("{EDF_CALLE}",objXML.getEmisor().getEdf_calle());
		qry= qry.replace("{EDF_NOEXTERIOR}",objXML.getEmisor().getEdf_noexterior());
		qry= qry.replace("{EDF_NOINTERIOR}",objXML.getEmisor().getEdf_nointerior());
		qry= qry.replace("{EDF_COLONIA}",objXML.getEmisor().getEdf_colonia());
		qry= qry.replace("{EDF_LOCALIDAD}",objXML.getEmisor().getEdf_localidad());
		qry= qry.replace("{EDF_REFERENCIA}",objXML.getEmisor().getEdf_referencia());
		qry= qry.replace("{EDF_MUNICIPIO}",objXML.getEmisor().getEdf_municipio());
		qry= qry.replace("{EDF_ESTADO}",objXML.getEmisor().getEdf_estado());
		qry= qry.replace("{EDF_PAIS}",objXML.getEmisor().getEdf_pais());
		qry= qry.replace("{EDF_CODIGOPOSTAL}",objXML.getEmisor().getEdf_codigopostal());
		qry= qry.replace("{EDF_TELEFONO}",objXML.getEmisor().getEdf_telefono());
		qry= qry.replace("{DEXP_CALLE}",objXML.getEmisor().getDexp_calle());
		qry= qry.replace("{DEXP_NOEXTERIOR}",objXML.getEmisor().getDexp_noexterior());
		qry= qry.replace("{DEXP_NOINTERIOR}",objXML.getEmisor().getDexp_nointerior());
		qry= qry.replace("{DEXP_COLONIA}",objXML.getEmisor().getDexp_colonia());
		qry= qry.replace("{DEXP_LOCALIDAD}",objXML.getEmisor().getDexp_localidad());
		qry= qry.replace("{DEXP_REFERENCIA}",objXML.getEmisor().getDexp_referencia());
		qry= qry.replace("{DEXP_MUNICIPIO}",objXML.getEmisor().getDexp_municipio());
		qry= qry.replace("{DEXP_ESTADO}",objXML.getEmisor().getDexp_estado());
		qry= qry.replace("{DEXP_PAIS}",objXML.getEmisor().getDexp_pais());
		qry= qry.replace("{DEXP_CODIGOPOSTAL}",objXML.getEmisor().getDexp_codiopostal());
		qry= qry.replace("{TELEFONO}",objXML.getEmisor().getDexp_telefono());
		qry= qry.replace("{FECHA_PRO}",objXML.getEmisor().getFecha_pro());
		qry= qry.replace("{HORA_PRO}",objXML.getEmisor().getHora_pro());
         */
		return qry;
	}

	private static String sentenciaConceptos(String qry, String cdo) 
	{
	 
		String valores = "";
		try
		{
		for (int i = 0; i < objRespuesta.getConceptos().size(); i++) 
		{
			
 
			valores = valores + "('"+objXML.getComprobante().getUname()+"', '"+
			                         objXML.getComprobante().getSerie()+"', '"+
					                 objXML.getComprobante().getFolio()+"', '"+
			                         objXML.getComprobante().getCarta_porte()+"',"+ "'"+
					                 objRespuesta.getConceptos().get(i).getNum_renglon()+"','"+
			                         objRespuesta.getConceptos().get(i).getCantidad()+"',"+ "'"+
					                 objRespuesta.getConceptos().get(i).getC_ClaveProdServ()+"','"+
			                         objRespuesta.getConceptos().get(i).getC_ClaveUnidad()+"',"+ "'"+
					                 objRespuesta.getConceptos().get(i).getDesc_unidad()+"','"+
			                         objRespuesta.getConceptos().get(i).getNoidentificacion()+"',"+ "'"+
					                 objRespuesta.getConceptos().get(i).getDescripcion()+"','"+
			                         validarNumero(objRespuesta.getConceptos().get(i).getValorunitario())+"'"+ ",'"+
					                 validarNumero(objRespuesta.getConceptos().get(i).getImporte())+"','"+
			                         validarNumero("0")+"','"+
					                 validarNumero("0")+"',"+ "'"+
					                 validarNumero("0")+"','"+
					                 validarNumero("0")+"','"+
					                 validarNumero("0")+"'"+ ",'"+
					                 validarNumero("0")+"','"+
					                 validarNumero("0")+"',"
								+ "'"+validarNumero("0")+"','"+validarNumero("0")+"','"+validarNumero("0")+"',"
								+ "'"+validarNumero("0")+"','"+objRespuesta.getConceptos().get(i).getFactura()+"','"+objRespuesta.getConceptos().get(i).getGrupo()+"','"+objRespuesta.getConceptos().get(i).getAplicaicon()+"','"+objRespuesta.getConceptos().get(i).getProveedor()+"','"+objRespuesta.getConceptos().get(i).getOde()+"'),";
			
		}
		qry= replaceIdentificadores(qry);
		qry= qry.replace("{VALORES}",valores.substring(0,valores.length()-1));
		}
		catch (Exception e) {
			//System.out.println.println("error: "+e.getMessage());
			qry="set @VAR= 0;";
		}
		return qry;
	}

	private static String validarNumero(String valorunitario) 
	{
		try
		{
			if (valorunitario.equals("null") || valorunitario.equals("")) 
			{
				return "0";
			}
		}
		catch (Exception e)
		{
		//System.out.println.println("e"+e.getMessage());					
		
		}
		
		return valorunitario;
	}

	private static String sentenciaComprobante(String qry, String cdo) 
	{
		////System.out.println.println("sentenciaComprobante...1");
		qry= replaceIdentificadores(qry);
		////System.out.println.println("sentenciaComprobante...2");
		qry= qry.replace("{FOLIO_FISCAL}",objXML.getComprobante().getFolio_fiscal());
		////System.out.println.println("sentenciaComprobante...3");
		qry= qry.replace("{NOCERTIFICADO_CSD}",objXML.getComprobante().getNoCertificado_csd());
		////System.out.println.println("sentenciaComprobante...4");
		qry= qry.replace("{NOCERTIFICADO_SAT}",objXML.getComprobante().getNoCertificado_sat());
		////System.out.println.println("sentenciaComprobante...5");
		qry= qry.replace("{CERTIFICADO}",objXML.getComprobante().getCertificado());
		////System.out.println.println("sentenciaComprobante...6");
		qry= qry.replace("{SELLO_DIGITAL}",objXML.getComprobante().getSello_digital());
		////System.out.println.println("sentenciaComprobante...7");
		qry= qry.replace("{SELLO_SAT}",objXML.getComprobante().getSello_sat());
		////System.out.println.println("sentenciaComprobante...8");
		qry= qry.replace("{CADENA_ORIGINAL}",objXML.getComprobante().getCadena_original());
		////System.out.println.println("sentenciaComprobante...9");
		qry= qry.replace("{TIPO_MONEDA}",objXML.getComprobante().getTipo_moneda());
		////System.out.println.println("sentenciaComprobante...10");
		qry= qry.replace("{FECHA_CERTIFICACION}",objXML.getComprobante().getFecha_certificacion().replace("T"," "));
		////System.out.println.println("sentenciaComprobante...11");
		qry= qry.replace("{FECHA_EMISION}",objXML.getComprobante().getFecha_emision().replace("T"," "));
		////System.out.println.println("sentenciaComprobante...12");
		qry= qry.replace("{FECHA_PROCESADA}",objXML.getComprobante().getFecha_procesada());
		////System.out.println.println("sentenciaComprobante...13");
		qry= qry.replace("{SUBTOTAL}",objXML.getComprobante().getSubtotal());
		////System.out.println.println("sentenciaComprobante...14");
		qry= qry.replace("{TOTAL}",objXML.getComprobante().getTotal());
		////System.out.println.println("sentenciaComprobante...15");
		qry= qry.replace("{TOTAL_LETRA}",objXML.getComprobante().getTotal_letra());
		////System.out.println.println("sentenciaComprobante...16");
		qry= qry.replace("{TIPO_DE_COMPROBANTE}",objXML.getComprobante().getTipo_de_comprobante());
		////System.out.println.println("sentenciaComprobante...17");
		qry= qry.replace("{LUGAR_EXPEDICION}",objXML.getComprobante().getLugarExpedicion());
		////System.out.println.println("sentenciaComprobante...18");
		qry= qry.replace("{RFC_PROV_CERTIF}",objXML.getComprobante().getRfc_prov_certif());
		////System.out.println.println("sentenciaComprobante...19");
		qry= qry.replace("{CODIGO_CBB}",objXML.getComprobante().getCodigo_cbb());
		////System.out.println.println("sentenciaComprobante...20 : " + objXML.getComprobante().getCodigo_pdf());
		qry= qry.replace("{CODIGO_PDF}",objXML.getComprobante().getCodigo_pdf());
		////System.out.println.println("sentenciaComprobante...21");
		qry= qry.replace("{CODIGO_XML}",objXML.getComprobante().getCodigo_xml());
		////System.out.println.println("sentenciaComprobante...22");
		qry= qry.replace("{ID_TRAYECTO}",trayecto);
		////System.out.println.println("sentenciaComprobante...23");
		qry= qry.replace("{FECHA_PRO}",objXML.getComprobante().getFecha_pro());
		////System.out.println.println("sentenciaComprobante...24");
		qry= qry.replace("{HORA_PRO}",objXML.getComprobante().getHora_pro());
		////System.out.println.println("sentenciaComprobante...25");
	
	//	//System.out.println.println("sentenciaComprobante...26: " + qry);
		return qry;
	}

	private static String sentenciaComprobanteUbicaciones(String qry, String cdo) 
	{
		String valores = "";
		for (int i = 0; i < objXML.getUbicaciones().size(); i++) 
		{
			// //System.out.println.println(" objXML.getUbicaciones().get(i).getDistancia_recorrida() : " +  objXML.getUbicaciones().get(i).getDistancia_recorrida());
			valores = valores + "('"+objXML.getComprobante().getUname()+"', '"+
		                             objXML.getComprobante().getSerie()+"', '"+
					                 objXML.getComprobante().getFolio()+"', '"+
		                             objXML.getComprobante().getCarta_porte()+"','"+
					                 objXML.getUbicaciones().get(i).getRenglon()+"','"+
		                             objXML.getUbicaciones().get(i).getDistancia_recorrida()+"',"+ "'"+
					                 objXML.getUbicaciones().get(i).getTipo_estacion()+"','"+
		                             objXML.getUbicaciones().get(i).getId_origen()+"','"+
					                 objXML.getUbicaciones().get(i).getId_destino()+"',"+ "'"+
		                             objXML.getUbicaciones().get(i).getFecha_hora_salida()+"','"+
					                 objXML.getUbicaciones().get(i).getFecha_hora_llegada()+"','"+
		                             objXML.getUbicaciones().get(i).getCodigo_postal()+"',"+ "'"+
					                 objXML.getUbicaciones().get(i).getPais()+"','"+
		                             objXML.getUbicaciones().get(i).getEstado()+"','"+
					                 objXML.getUbicaciones().get(i).getMunicipio()+"','"+
		                             objXML.getUbicaciones().get(i).getLocalidad()+"','"+
					                 objXML.getUbicaciones().get(i).getCodigo_postal()+"','"+
		                             objXML.getUbicaciones().get(i).getCalle().trim()+"'),";
		}
		////System.out.println.println("VALUES: " + valores);
		qry= replaceIdentificadores(qry);
		qry= qry.replace("{VALORES}",valores.substring(0,valores.length()-1));
		
		return qry;
	}

	private static String sentenciaComprobanteTransporte(String qry, String cdo) 
	{
		qry= replaceIdentificadores(qry);
		qry= qry.replace("{CVE_TRANSPORTE}",objXML.getTotalMercancias().getNum_total_mercancias());
		
		return qry;
	}

	private static String sentenciaTotalMercancias(String qry, String cdo) 
	{
		qry= replaceIdentificadores(qry);
		qry= qry.replace("{NUM_TOTAL_MERCANCIAS}",objXML.getTotalMercancias().getNum_total_mercancias());
		
		return qry;
	}

	private static String sentenciaOperadores(String qry, String cdo) 
	{
		String valores = "";
		////System.out.println.println("bjXML.getOperador().size: " + objXML.getOperador().size());
		for (int i = 0; i < objXML.getOperador().size(); i++) 
		{
			valores = valores + "('"+objXML.getComprobante().getUname()+"', '"+objXML.getComprobante().getSerie()+"', '"+objXML.getComprobante().getFolio()+"', '"+objXML.getComprobante().getCarta_porte()+"','"+objXML.getOperador().get(i).getResidencia_fiscal()+"','"+objXML.getOperador().get(i).getNombre()+"',"
										+ "'"+objXML.getOperador().get(i).getLicencia()+"','"+objXML.getOperador().get(i).getRfc()+"',"
										+ "'"+objXML.getOperador().get(i).getCodigo_postal()+"','"+objXML.getOperador().get(i).getPais()+"','"+objXML.getOperador().get(i).getMunicipio()+"',"
										+ "'"+objXML.getOperador().get(i).getLocalidad()+"','"+objXML.getOperador().get(i).getColonia()+"','"+objXML.getOperador().get(i).getCalle()+"'),";
		}
		qry= replaceIdentificadores(qry);
		qry= qry.replace("{VALORES}",valores.substring(0,valores.length()-1));
		
		return qry;
	}

	private static String sentenciaComprobanteMercancias(String qry, String cdo) 
	{
		String valores = "";
		for (int i = 0; i < objXML.getMercancias().size(); i++) 
		{
			valores = valores + "('"+objXML.getComprobante().getUname()+"', '"+objXML.getComprobante().getSerie()+"', '"+objXML.getComprobante().getFolio()+"', '"+objXML.getComprobante().getCarta_porte()+"','"+objXML.getMercancias().get(i).getRenglon()+"','"+objXML.getMercancias().get(i).getId_origen()+"',"
							  		+ "'"+objXML.getMercancias().get(i).getId_destino()+"','"+objXML.getMercancias().get(i).getPeso_kg()+"','"+objXML.getMercancias().get(i).getCantidad_transporta()+"',0),";
		}
		qry= replaceIdentificadores(qry);
		qry= qry.replace("{VALORES}",valores.substring(0,valores.length()-1));
		
		return qry;
	}

	private static String sentenciaComprobanteCartaPorte(String qry, String cdo) 
	{
		qry= replaceIdentificadores(qry);
		
		qry= qry.replace("{VERSION}",objXML.getComprobanteCartaPorte().getVersion());
		qry= qry.replace("{TOTAL_DIST_REC}",objXML.getComprobanteCartaPorte().getTotal_dist_rec());
		qry= qry.replace("{TRANSP_INTERNAC}",objXML.getComprobanteCartaPorte().getTransp_internac());
		
		return qry;
	}

	private static String replaceIdentificadores(String qry) 
	{
		qry= qry.replace("{UNAME}",objXML.getComprobante().getUname());
		qry= qry.replace("{SERIE}",objXML.getComprobante().getSerie());
		qry= qry.replace("{FOLIO}",objXML.getComprobante().getFolio());
		qry= qry.replace("{CARTA_PORTE}",objXML.getComprobante().getCarta_porte());
		
		return qry;
	}

	private static String sentenciaAutoTransporte(String qry, String cdo) 
	{
		qry= replaceIdentificadores(qry);
		qry= qry.replace("{NUM_POLIZA}",objXML.getAutoTransporte().getNum_poliza());
		qry= qry.replace("{NOMBRE_ASEGURADORA}",objXML.getAutoTransporte().getNombre_aseguradora());
		qry= qry.replace("{NUM_PERMISO}",objXML.getAutoTransporte().getNum_permiso());
		qry= qry.replace("{PERMISO}",objXML.getAutoTransporte().getPermiso());
		qry= qry.replace("{ANIO_MODELO}",objXML.getAutoTransporte().getAnio_modelo());
		qry= qry.replace("{PLACAS}",objXML.getAutoTransporte().getPlacas().trim());
		qry= qry.replace("{CONFIG_VEHICULAR}",objXML.getAutoTransporte().getConfig_vehicular());
		return qry;
	}

	private void llenarObjetosDeXML(List<Querys> listaQuerys) 
	{
		llenarDatosComprobante();
		llenarConceptos();
		llenarComprobanteCartaprote();
		llenarMercancias();
		llenarOperador();
		llenarAutoTransporte();
		llenarUbicaciones();
		consultarEmisorReceptor(listaQuerys);
		llenarTotalMercancias();
		llenarComprobanteTransporte();
	}



	private void llenarUbicaciones() 
	{
		if (rsp)
		{
			try
			{
				List<Ubicaciones> lstUbicaciones = new ArrayList<>();
				int totalSecciones = Integer.parseInt(obtenerValor("cartaporte20:Ubicacion","","size"));
				////System.out.println.println("llenarUbicaciones: " + totalSecciones );
				for (int i = 0; i < totalSecciones; i++) 
				{
					String seccion = ""+i+"";
					Ubicaciones objUbicaciones = new Ubicaciones();
					objUbicaciones.setUname(objXML.getComprobante().getUname());
					objUbicaciones.setFolio(objXML.getComprobante().getFolio());
					objUbicaciones.setSerie(objXML.getComprobante().getSerie());
					objUbicaciones.setCarta_porte(objXML.getComprobante().getCarta_porte());
					objUbicaciones.setRenglon(""+(Integer.parseInt(seccion)+1)+"");
					// objUbicaciones.setDistancia_recorrida(obtenerValor("cartaporte20:Ubicacion", "DistanciaRecorrida",seccion));
					objUbicaciones.setDistancia_recorrida(((obtenerValor("cartaporte20:Ubicacion", "DistanciaRecorrida",seccion) == "") ? "0" : obtenerValor("cartaporte20:Ubicacion", "DistanciaRecorrida",seccion)));
					objUbicaciones.setTipo_estacion(obtenerValor("cartaporte20:Ubicacion","TipoEstacion",seccion));
					////System.out.println.println("IDOrigen seccion: "+ seccion );
					objUbicaciones.setId_origen(obtenerValor("cartaporte20:Origen", "IDOrigen",seccion));
					objUbicaciones.setId_destino(obtenerValor("cartaporte20:Destino", "IDDestino",seccion));
					objUbicaciones.setFecha_hora_salida(obtenerValor("cartaporte20:Origen", "FechaHoraSalida",seccion));
					objUbicaciones.setFecha_hora_llegada(obtenerValor("cartaporte20:Destino", "FechaHoraProgLlegada",seccion));
					objUbicaciones.setCodigo_postal(obtenerValor("cartaporte20:Domicilio", "CodigoPostal",seccion));
					objUbicaciones.setPais(obtenerValor("cartaporte20:Domicilio", "Pais",seccion));
					objUbicaciones.setEstado(obtenerValor("cartaporte20:Domicilio", "Estado",seccion));
					objUbicaciones.setMunicipio(obtenerValor("cartaporte20:Domicilio", "Municipio",seccion));
					objUbicaciones.setLocalidad(obtenerValor("cartaporte20:Domicilio", "Localidad",seccion));
					objUbicaciones.setColonia(obtenerValor("cartaporte20:Domicilio", "Colonia",seccion));
					objUbicaciones.setCalle(obtenerValor("cartaporte20:Domicilio", "Calle",seccion));
					////System.out.println.println("objUbicaciones: " + objUbicaciones);
					lstUbicaciones.add(objUbicaciones);
				}
				objXML.setUbicaciones(lstUbicaciones);
			}
			catch (Exception e) 
			{
				rsp = false;
			}
		}
	}

	private void llenarComprobanteTransporte() 
	{
		if (rsp)
		{
			try
			{
				ComprobanteTransporte objCompTrans = new ComprobanteTransporte();
				objCompTrans.setUname(objXML.getComprobante().getUname());
				objCompTrans.setSerie(objXML.getComprobante().getSerie());
				objCompTrans.setFolio(objXML.getComprobante().getFolio());
				objCompTrans.setCarta_porte(objXML.getComprobante().getCarta_porte());
				objCompTrans.setCve_transporte(obtenerValor("cartaporte20:FiguraTransporte", "CveTransporte","0"));
				objXML.setComprobanteTransporte(objCompTrans);
			}
			catch (Exception e) 
			{
				rsp = false;
			}
		}
	}
	

	private void llenarAutoTransporte() 
	{
		if (rsp)
		{
			try
			{
				AutoTransporte objAutoTrans = new AutoTransporte();
				objAutoTrans.setUname(objXML.getComprobante().getUname());
				objAutoTrans.setSerie(objXML.getComprobante().getSerie());
				objAutoTrans.setFolio(objXML.getComprobante().getFolio());
				objAutoTrans.setCarta_porte(objXML.getComprobante().getCarta_porte());
				objAutoTrans.setNum_poliza(obtenerValor("cartaporte20:AutotransporteFederal", "NumPolizaSeguro", "0"));
				objAutoTrans.setNombre_aseguradora(obtenerValor("cartaporte20:AutotransporteFederal", "NombreAseg", "0"));
				objAutoTrans.setNum_permiso(obtenerValor("cartaporte20:AutotransporteFederal", "NumPermisoSCT", "0"));
				objAutoTrans.setPermiso(obtenerValor("cartaporte20:AutotransporteFederal", "PermSCT", "0"));
				objAutoTrans.setAnio_modelo(obtenerValor("cartaporte20:IdentificacionVehicular","AnioModeloVM", "0"));
				objAutoTrans.setPlacas(obtenerValor("cartaporte20:IdentificacionVehicular", "PlacaVM", "0"));
				objAutoTrans.setConfig_vehicular(obtenerValor("cartaporte20:IdentificacionVehicular", "ConfigVehicular","0"));
				
				objXML.setAutoTransporte(objAutoTrans);
			}
			catch (Exception e) 
			{
				rsp = false;
			}
		}
	}



	private void llenarDatosComprobante() 
	{
		
			try
			{
				Comprobante objComprobante = new Comprobante();
				objComprobante.setUname("CDF");
				objComprobante.setSerie(obtenerValor("cfdi:Comprobante", "Serie","0"));
				objComprobante.setFolio(obtenerValor("cfdi:Comprobante", "Folio","0"));
				objComprobante.setCarta_porte(aplicarFormato(objComprobante));
				objComprobante.setFolio_fiscal(obtenerValor("tfd:TimbreFiscalDigital", "UUID","0"));
				objComprobante.setNoCertificado_csd(obtenerValor("cfdi:Comprobante", "NoCertificado","0"));
				objComprobante.setNoCertificado_sat(obtenerValor("tfd:TimbreFiscalDigital", "NoCertificadoSAT","0"));
				objComprobante.setCertificado(obtenerValor("cfdi:Comprobante", "Certificado","0"));
				objComprobante.setSello_digital(obtenerValor("cfdi:Comprobante", "Sello","0"));
				objComprobante.setSello_sat(obtenerValor("tfd:TimbreFiscalDigital", "SelloSAT","0"));
				objComprobante.setRfc_prov_certif(obtenerValor("tfd:TimbreFiscalDigital", "RfcProvCertif","0"));
				objComprobante.setTipo_moneda(obtenerValor("cfdi:Comprobante", "Moneda","0"));
				objComprobante.setFecha_certificacion(obtenerValor("tfd:TimbreFiscalDigital", "FechaTimbrado","0"));
				objComprobante.setFecha_emision(obtenerValor("cfdi:Comprobante", "Fecha","0"));
				objComprobante.setFecha_procesada("concat(CURDATE(),' ',CURTIME())");
				objComprobante.setSubtotal(obtenerValor("cfdi:Comprobante", "SubTotal","0"));
				objComprobante.setTotal(obtenerValor("cfdi:Comprobante", "Total","0"));
				//System.out.println.println("Tipo de comprobante: "+obtenerValor("cfdi:Comprobante", "TipoDeComprobante","0"));
				objComprobante.setTipo_de_comprobante(obtenerValor("cfdi:Comprobante", "TipoDeComprobante","0"));
				objComprobante.setLugarExpedicion(obtenerValor("cfdi:Comprobante", "LugarExpedicion","0"));
				objComprobante.setFecha_pro("CURDATE()");
				objComprobante.setHora_pro("CURTIME()");
				objComprobante.setCodigo_cbb(objRespuesta.getCodigoCBB());
				////System.out.println.println("getCodigoPDF: " + objRespuesta.getCodigoPDF());
				objComprobante.setCodigo_pdf(objRespuesta.getCodigoPDF());
				objComprobante.setCodigo_xml(objRespuesta.getCodigoXML());
				objComprobante.setCadena_original(obtenerCadenaOriginal(objComprobante));

				objXML.setComprobante(objComprobante);
				rsp = true;
			}
			catch (Exception e) 
			{
				rsp = false;
				objRespuesta.setMsjError("Error al llenar DatosComprobante. ERROR: "+e.getMessage());
				objRespuesta.setRespuesta(false);
			}
		
	}
	
	private void llenarObjetoEmisorReceptor(ResultSet rs, Emisor objEmisor, Receptor objReceptor) 
	{
		if (rsp)
		{
			try
			{
				while (rs.next()) 
				{
					if (rs.getString("tipo").equals("emisor")) 
					{
						objEmisor.setUname(rs.getString("uname_pro"));
						objEmisor.setSerie(objXML.getComprobante().getSerie());
						objEmisor.setFolio(objXML.getComprobante().getFolio());
						objEmisor.setCarta_porte(objXML.getComprobante().getCarta_porte());
						objEmisor.setRfc(rs.getString("rfc"));
						objEmisor.setNombre(rs.getString("nombre_fiscal"));
						objEmisor.setUname_edf(rs.getString("uname"));
						objEmisor.setNum_cli("19");
						objEmisor.setRegimenfiscal("NA");
						objEmisor.setEdf_calle(rs.getString("calle"));
						objEmisor.setEdf_noexterior(rs.getString("num_ext"));
						objEmisor.setEdf_nointerior(rs.getString("num_int"));
						objEmisor.setEdf_colonia(rs.getString("colonia"));
						objEmisor.setEdf_localidad("");
						objEmisor.setEdf_referencia("");
						objEmisor.setEdf_municipio(rs.getString("cd_del_mpo"));
						objEmisor.setEdf_estado(rs.getString("estado"));
						objEmisor.setEdf_pais(rs.getString("pais"));
						objEmisor.setEdf_codigopostal(rs.getString("codigo_postal"));
						objEmisor.setEdf_telefono(rs.getString("referencia"));
						objEmisor.setDexp_calle(rs.getString("calle"));
						objEmisor.setDexp_noexterior(rs.getString("num_ext"));
						objEmisor.setDexp_nointerior(rs.getString("num_int"));
						objEmisor.setDexp_colonia(rs.getString("colonia"));
						objEmisor.setDexp_localidad("");
						objEmisor.setDexp_referencia("");
						objEmisor.setDexp_municipio(rs.getString("cd_del_mpo"));
						objEmisor.setDexp_estado(rs.getString("estado"));
						objEmisor.setDexp_pais(rs.getString("pais"));
						objEmisor.setDexp_codiopostal(rs.getString("codigo_postal"));
						objEmisor.setDexp_telefono(rs.getString("referencia"));
						objEmisor.setFecha_pro("CURDATE()");
						objEmisor.setHora_pro("CURTIME()");
						objXML.setEmisor(objEmisor);
					}
					if (rs.getString("tipo").equals("receptor"))
					{
						objReceptor.setUname(rs.getString("runame"));
						objReceptor.setSerie(objXML.getComprobante().getSerie());
						objReceptor.setFolio(objXML.getComprobante().getFolio());
						objReceptor.setCarta_porte(objXML.getComprobante().getCarta_porte());
						objReceptor.setRfc(rs.getString("rrfc"));
						objReceptor.setNombre(rs.getString("rnombre"));
						objReceptor.setUname_rdf(rs.getString("runame"));
						objReceptor.setNum_cli("19");
						objReceptor.setE_mail(rs.getString("re_mail"));
						objReceptor.setRdf_calle(rs.getString("rcalle_num"));
						objReceptor.setRdf_noexterior(rs.getString("rnum_exterior"));
						objReceptor.setRdf_nointerior(rs.getString("rnum_interior"));
						objReceptor.setRdf_colonia(rs.getString("rcolonia"));
						objReceptor.setRdf_localidad("");
						objReceptor.setRdf_referencia("");
						objReceptor.setRdf_municipio(rs.getString("rciudad_deleg_munic"));
						objReceptor.setRdf_estado(rs.getString("restado"));
						objReceptor.setRdf_pais("MEXICO");
						objReceptor.setRdf_codigopostal(rs.getString("rcodigo_postal"));
						objReceptor.setRdf_telefono(rs.getString("rtelefono"));
						objReceptor.setDcon_calle(rs.getString("rcalle_num"));
						objReceptor.setDcon_noexterior(rs.getString("rnum_exterior"));
						objReceptor.setDcon_nointerior(rs.getString("rnum_interior"));
						objReceptor.setDcon_colonia(rs.getString("rcolonia"));
						objReceptor.setDcon_localidad("");
						objReceptor.setDcon_referencia("");
						objReceptor.setDcon_municipio(rs.getString("rciudad_deleg_munic"));
						objReceptor.setDcon_estado(rs.getString("restado"));
						objReceptor.setDcon_pais("MEXICO");
						objReceptor.setDcon_codigopostal(rs.getString("rcodigo_postal"));
						objReceptor.setDcon_telefono(rs.getString("rtelefono"));
						objReceptor.setDcon_UsoCFDI(rs.getString("ruso_cfdi"));
						objXML.setReceptor(objReceptor);
					}
				}
			}
			catch (Exception e) 
			{
				objRespuesta.setMsjError("Error al llenar EmisorReceptor. ERROR: "+e.getMessage());
				objRespuesta.setRespuesta(false);
				rsp = false;
			}
		}
			
	}

	private String aplicarFormato(Comprobante objComprobante)
	{
		String carta_porte = "";
		carta_porte = objComprobante.getSerie()+String.format("%" + ((15-objComprobante.getSerie().length())-objComprobante.getFolio().length())+ "s",objComprobante.getFolio()).replace(" ","0"); ;
		return carta_porte;
	}

	private String obtenerCadenaOriginal(Comprobante objComprobante) 
	{
		String cadena_original = "";
		
		cadena_original = "||"+obtenerValor("cfdi:Comprobante", "Version","0")+"|"+objComprobante.getFolio_fiscal()+"|"+objComprobante.getFecha_certificacion()+"|"+objComprobante.getRfc_prov_certif()+"|"+objComprobante.getSello_sat()+"|"+objComprobante.getNoCertificado_sat()+"||";
		
		return cadena_original;
	}

	private void llenarTotalMercancias() 
	{
		if (rsp)
		{
			try
			{
				TotalMercancias objTotalMerc = new TotalMercancias();
				objTotalMerc.setUname(objXML.getComprobante().getUname());
				objTotalMerc.setSerie(objXML.getComprobante().getSerie());
				objTotalMerc.setFolio(objXML.getComprobante().getFolio());
				objTotalMerc.setCarta_porte(objXML.getComprobante().getCarta_porte());
				objTotalMerc.setNum_total_mercancias(obtenerValor("cartaporte20:Mercancias", "NumTotalMercancias","0"));
				objXML.setTotalMercancias(objTotalMerc);
			}
			catch (Exception e) 
			{
				objRespuesta.setMsjError("Error al llenar LlenarTotalMercancias. ERROR: "+e.getMessage());
				objRespuesta.setRespuesta(false);
				rsp = false;
			}
		}
	}

	private void llenarConceptos() 
	{
		if (rsp)
		{
			try
			{
				List<Conceptos> lstConceptos = new ArrayList<>();
				int totalSecciones = Integer.parseInt(obtenerValor("cfdi:Concepto","","size"));
				for (int i = 0; i < totalSecciones; i++) 
				{
					String seccion = ""+i+"";
					Conceptos objConceptos = new Conceptos();
					objConceptos.setUname(objXML.getComprobante().getUname());
					objConceptos.setSerie(objXML.getComprobante().getSerie());
					objConceptos.setFolio(objXML.getComprobante().getFolio());
					objConceptos.setCarta_porte(objXML.getComprobante().getCarta_porte());
					objConceptos.setNum_renglon(seccion);
					objConceptos.setCantidad(obtenerValor("cfdi:Concepto", "Cantidad",seccion));
					objConceptos.setC_ClaveProdServ(obtenerValor("cfdi:Concepto", "ClaveProdServ",seccion));
					objConceptos.setC_ClaveUnidad(obtenerValor("cfdi:Concepto", "ClaveUnidad",seccion));
					objConceptos.setDesc_unidad(obtenerValor("", "",seccion));
					objConceptos.setNoidentificacion(obtenerValor("", "",seccion));
					objConceptos.setDescripcion(obtenerValor("cfdi:Concepto", "Descripcion",seccion));
					objConceptos.setValorunitario(obtenerValor("cfdi:Concepto", "ValorUnitario",seccion));
					objConceptos.setImporte(obtenerValor("cfdi:Concepto", "Importe",seccion));
					objConceptos.setDescuento(obtenerValor("", "",seccion));
					objConceptos.setBasetraslado(obtenerValor("", "",seccion));
					objConceptos.setImportetraslado(obtenerValor("", "",seccion));
					objConceptos.setImpuestotraslado(obtenerValor("", "",seccion));
					objConceptos.setTasaocuotatraslado(obtenerValor("", "",seccion));
					objConceptos.setTipofactortraslado(obtenerValor("", "",seccion));
					objConceptos.setBaseretencion(obtenerValor("", "",seccion));
					objConceptos.setImpretencion(obtenerValor("", "",seccion));
					objConceptos.setImpuestoretencion(obtenerValor("", "",seccion));
					objConceptos.setTasaocuotaretencion(obtenerValor("", "",seccion));
					objConceptos.setTipo_factorretencion(obtenerValor("", "",seccion));
					
					lstConceptos.add(objConceptos);
				}
				objXML.setConceptos(lstConceptos);
			}
			catch (Exception e) 
			{
				objRespuesta.setMsjError("Error al llenar llenarConceptos. ERROR: "+e.getMessage());
				objRespuesta.setRespuesta(false);
				rsp = false;
			}
		}
	}
	
	private void llenarOperador() 
	{
		if (rsp)
		{
			try
			{
				List<Operador> lstOperador = new ArrayList<>();
				int totalSecciones = Integer.parseInt(obtenerValor("cartaporte20:Operador","","size"));
				 
					//String seccion = ""+i+"";
					Operador objOperador = new Operador();
					objOperador.setUname(objXML.getComprobante().getUname());
					objOperador.setSerie(objXML.getComprobante().getSerie());
					objOperador.setFolio(objXML.getComprobante().getFolio());
					objOperador.setCarta_porte(objXML.getComprobante().getCarta_porte());
					objOperador.setResidencia_fiscal("");
					//objOperador.setNombre(obtenerValor("cartaporte20:TiposFigura", "NombreFigura","0"));
					//objOperador.setLicencia(obtenerValor("cartaporte20:TiposFigura", "NumLicencia","0"));
					//objOperador.setRfc(obtenerValor("cartaporte20:TiposFigura", "RFCFigura","0"));
					objOperador.setCodigo_postal("");
					objOperador.setPais("");
					objOperador.setMunicipio("");
					objOperador.setLocalidad("");
					objOperador.setColonia("");
					objOperador.setCalle("");
					
					/*objOperador.setResidencia_fiscal(obtenerValor("cartaporte20:Operador", "ResidenciaFiscalOperador",seccion));
					objOperador.setNombre(obtenerValor("cartaporte20:Operador", "NombreOperador",seccion));
					objOperador.setLicencia(obtenerValor("cartaporte20:Operador", "NumLicencia",seccion));
					objOperador.setRfc(obtenerValor("cartaporte20:Operador", "RFCOperador",seccion));
					objOperador.setCodigo_postal(obtenerValor("cartaporte20:Domicilio", "CodigoPostal",seccion));
					objOperador.setPais(obtenerValor("cartaporte20:Domicilio", "Pais",seccion));
					objOperador.setMunicipio(obtenerValor("cartaporte20:Domicilio", "Municipio",seccion));
					objOperador.setLocalidad(obtenerValor("cartaporte20:Domicilio", "Localidad",seccion));
					objOperador.setColonia(obtenerValor("cartaporte20:Domicilio", "Colonia",seccion));
					objOperador.setCalle(obtenerValor("cartaporte20:Domicilio", "Calle",seccion));
					*/
					lstOperador.add(objOperador);
			 
				objXML.setOperador(lstOperador);
			}
			catch (Exception e) 
			{
				objRespuesta.setMsjError("Error al llenar llenaOperador. ERROR: "+e.getMessage());
				objRespuesta.setRespuesta(false);
				rsp = false;
			}
		}
	}

	private void llenarMercancias() 
	{
		List<Mercancias> lstMercancias = new ArrayList<>();
		if (rsp)
		{
			
			try
			{
				
				int totalSecciones = Integer.parseInt(obtenerValor("cartaporte20:Mercancias", "NumTotalMercancias","0"));
				for (int i = 0; i < totalSecciones; i++) 
				{
					String seccion = ""+i+"";
					Mercancias objMercancias = new Mercancias();
					objMercancias.setUname(objXML.getComprobante().getUname());;
					objMercancias.setSerie(objXML.getComprobante().getSerie());;
					objMercancias.setFolio(objXML.getComprobante().getFolio());;
					objMercancias.setCarta_porte(objXML.getComprobante().getCarta_porte());;
					objMercancias.setRenglon(""+(Integer.parseInt(seccion)+1)+"");
					objMercancias.setPeso_kg(obtenerValor("cartaporte20:Mercancia", "PesoEnKg",seccion));;
					objMercancias.setId_destino(obtenerValor("cartaporte20:CantidadTransporta", "IDDestino",seccion));
					objMercancias.setId_origen(obtenerValor("cartaporte20:CantidadTransporta", "IDOrigen",seccion));;
					objMercancias.setCantidad_transporta(obtenerValor("cartaporte20:CantidadTransporta", "Cantidad",seccion));
					lstMercancias.add(objMercancias);
				}
				objXML.setMercancias(lstMercancias);
			}
			catch (Exception e) 
			{
				//System.out.println.println("Error al llenar llenarMercancias. ERROR: " + e);
				objRespuesta.setMsjError("Error al llenar llenarMercancias. ERROR: "+e.getMessage());
				objRespuesta.setRespuesta(false);
				rsp = false;
				Mercancias objMercancias = new Mercancias();
				lstMercancias.add(objMercancias);
			}
		}
	}

	private void llenarComprobanteCartaprote() 
	{
		if (rsp)
		{
			try
			{
				ComprobanteCartaPorte objCompCarta = new ComprobanteCartaPorte();
				objCompCarta.setUname(objXML.getComprobante().getUname());
				objCompCarta.setSerie(objXML.getComprobante().getSerie());
				objCompCarta.setFolio(objXML.getComprobante().getFolio());
				objCompCarta.setCarta_porte(objXML.getComprobante().getCarta_porte());
				objCompCarta.setVersion(obtenerValor("cartaporte20:CartaPorte", "Version","0"));
				objCompCarta.setTotal_dist_rec(obtenerValor("cartaporte20:CartaPorte", "TotalDistRec","0"));
				objCompCarta.setTransp_internac(obtenerValor("cartaporte20:CartaPorte", "TranspInternac","0"));
				objXML.setComprobanteCartaPorte(objCompCarta);
			}
			catch (Exception e) 
			{
				objRespuesta.setMsjError("Error al llenar llenarComprobanteCartaPorte. ERROR: "+e.getMessage());
				objRespuesta.setRespuesta(false);
				rsp = false;
			}
		}
	}
	
	
	private String obtenerValor(String nodo, String campo, String funcion)
	{
	String valor = "";
	if (!nodo.equals("")) 
	{
	
		try
		{	
			String XML = objRespuesta.getCodigoXML();
			 
			Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new InputSource(new StringReader(XML)));
	        NodeList nList = document.getElementsByTagName(nodo);
	        if (!funcion.equals("size"))
			{
				Node nNode = nList.item(Integer.parseInt(funcion));
				try
				{
					if(nNode.getNodeType() == Node.ELEMENT_NODE) 
					{
						Element eElement = (Element) nNode;
						valor = eElement.getAttribute(campo);
						// //System.out.println.println("VALOR. NODO: "+nodo+". CAMPO: "+campo + ". seccion: " + funcion + ". value: " + valor);
					}
				}
				catch (Exception e) 
				{
					//System.err.println("Error: "+e.getMessage()+".NODO: "+nodo+". CAMPO: "+campo + ". seccion: " + funcion );
					valor = "";
				}
			}
			else
			{
				return String.valueOf(nList.getLength());
			}
		}
		catch (Exception e) 
		{
			// //System.out.println.println("Error al obtener datos XML. NODO: "+nodo+". CAMPO: "+campo+". ERROR: "+e.getMessage().toString());
		}
	}
		return valor;
	}

}
