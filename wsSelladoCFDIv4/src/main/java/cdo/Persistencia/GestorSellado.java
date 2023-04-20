package cdo.Persistencia;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.math.BigDecimal;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;
import java.util.prefs.Preferences;

import javax.imageio.ImageIO;
import javax.xml.parsers.DocumentBuilderFactory;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.datacontract.schemas._2004._07.Emision_Model_DTO.Credenciales;
import org.datacontract.schemas._2004._07.Emision_Model_DTO_Addendas_CFDR.AddendaCFDR;
import org.datacontract.schemas._2004._07.Emision_Model_DTO_Addendas_CFDR.DomicilioClienteR;
import org.datacontract.schemas._2004._07.Emision_Model_DTO_Addendas_CFDR.EtiquetaPersonalizadaR;
import org.datacontract.schemas._2004._07.Emision_Model_DTO_GenerarCfdi.CfdiRelacionadoR;
import org.datacontract.schemas._2004._07.Emision_Model_DTO_GenerarCfdi.CfdiRelacionadosR;
import org.datacontract.schemas._2004._07.Emision_Model_DTO_GenerarCfdi.Comprobante33R;
import org.datacontract.schemas._2004._07.Emision_Model_DTO_GenerarCfdi.ConceptoR;
import org.datacontract.schemas._2004._07.Emision_Model_DTO_GenerarCfdi.EmisorR;
import org.datacontract.schemas._2004._07.Emision_Model_DTO_GenerarCfdi.ErroresCFDI;
import org.datacontract.schemas._2004._07.Emision_Model_DTO_GenerarCfdi.GenerarCFDIResponse;
import org.datacontract.schemas._2004._07.Emision_Model_DTO_GenerarCfdi.ImpuestosConceptoR;
import org.datacontract.schemas._2004._07.Emision_Model_DTO_GenerarCfdi.InformacionGlobalR;
import org.datacontract.schemas._2004._07.Emision_Model_DTO_GenerarCfdi.ReceptorR;
import org.datacontract.schemas._2004._07.Emision_Model_DTO_GenerarCfdi.RetencionConceptoR;
import org.datacontract.schemas._2004._07.Emision_Model_DTO_GenerarCfdi.TrasladoConceptoR;
import org.datacontract.schemas._2004._07.Emision_Model_DTO_Nomina_Mailer.RespuestaOperacionCR;
import org.tempuri.IService;
import org.tempuri.ServiceLocator;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import cdo.Entidades.EjecutaQuerysBD;
import cdo.Entidades.Informacion;
import cdo.Entidades.Querys;
import cdo.Entidades.Respuesta;
import cdo.Util.Cls_Querys;
import cdo.Util.ConexionBD;
public class GestorSellado 
{
	private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
	Calendar cal= Calendar.getInstance();
	int year= cal.get(Calendar.YEAR);
	String mes = obtenerMes((cal.get(Calendar.MONTH)+1));
	String dia = obtenerMes(cal.get(Calendar.DAY_OF_MONTH));
	
	
	String remoteDir = "/GeneradorCFDI/cfdi/"+cal.get(Calendar.YEAR)+"/"+mes+"/"+dia+"/";
	String remoteDirKWX = "/cfdi/"+cal.get(Calendar.YEAR)+"/"+mes+"/"+dia+"/";
	String cbb = "", pdf = "", xml = "", xmlDecodificado = "", nombreFile = "", request = "", grupos = "";
	private GestorValidateParams gVal = new GestorValidateParams();
	private List<Querys> listaQuerys;
	private Connection connBD = null;
	private List<String> detalle = new ArrayList<>();
	private List<String> detalleLog = new ArrayList<>();
	private Respuesta respuesta = new Respuesta();
	Gson gson = new Gson();
	private Informacion info = new Informacion();
	static Preferences preferences = Preferences.userNodeForPackage(Preferences.class);
	String envioCorreo = "", email = "";
	List<HashMap<String,Object>> credencialesBD = new ArrayList<HashMap<String,Object>>();
	List<HashMap<String,Object>> emisorBD = new ArrayList<HashMap<String,Object>>();
	List<HashMap<String,Object>> receptorBD = new ArrayList<HashMap<String,Object>>();
	List<HashMap<String,Object>> conceptosBD = new ArrayList<HashMap<String,Object>>();
	List<HashMap<String,Object>> comprobanteBD = new ArrayList<HashMap<String,Object>>();
	List<HashMap<String,Object>> relacionadosBD = new ArrayList<HashMap<String,Object>>();
	
	AddendaCFDR addenda = new AddendaCFDR();
	GenerarCFDIResponse response = new GenerarCFDIResponse();
	DomicilioClienteR domicilioClienteR = new DomicilioClienteR();
	Comprobante33R comprobante = new Comprobante33R();
	List<ConceptoR> lstConceptos = new ArrayList<>();
	Credenciales credenciales = new Credenciales();
	EmisorR emisor = new EmisorR();
	ConceptoR[] conceptoIArray;
	
	ReceptorR receptor = new ReceptorR();
	Comprobante33R comprobante33r = new Comprobante33R();
	InformacionGlobalR  global = new InformacionGlobalR();
	int log = 0;
	public Respuesta iniciarProceso(String cdo, String serie, String folio, String correo, String request, String grupo) 
	{
		respuesta = gVal.validateParameters(cdo,folio,serie,correo);
		getTableQuerys(cdo,serie,folio,correo,request,grupo);
		processing("getDate");
		processing("setCredenciales");
		processing("setEmisor");
		processing("setReceptor");
		processing("setAddenda");
		processing("setConceptos");
		processing("setGlobal");
		processing("setComprobante");
		processing("setRelacionado");
		processing("addDateComprobante");
		processing("requestResponse");
		closeConection();
		return respuesta;
	}
	

	private String obtenerMes(int valor) 
	{
		String retorna = "";
		if (valor<10) 
		{
			retorna = "0"+valor;
		}
		else
		{
		retorna = String.valueOf(valor);
		}
		return retorna;
	}


	private void closeConection() 
	{
		try{}catch (Exception e){}
		finally 
        {
        	try 
        	{
        		if(connBD != null)
        		{
        			connBD.close();
        			connBD = null;
        		}
			} catch (Exception e) 
        	{				
				fillRsp(false, "Error al cerrar connection", true, e.getMessage().toString());
				
			}
        }
	}
	
	private void processing(String tipo) 
	{
		switch (tipo) 
		{
		case "getDate":
			if (respuesta.isRespuesa()) 
			{
				getDate();
			}	
			break;
		case "setCredenciales":
			if (respuesta.isRespuesa()) 
			{
				setCredenciales();
			}
			break;
		case "setEmisor":
			if (respuesta.isRespuesa()) 
			{
				setEmisor();
			}
			break;
		case "setReceptor":
			if (respuesta.isRespuesa()) 
			{
				setReceptor();
			}
			break;
		case "setConceptos":
			if (respuesta.isRespuesa()) 
			{
				setConcepto();
			}
			break;
		case "setGlobal":
			if (respuesta.isRespuesa()) 
			{
				setGlobal();
			}
			break;
		case "setComprobante":
			if (respuesta.isRespuesa()) 
			{
				setComprobante();
			}
			break;
		case "setRelacionado":
			if (respuesta.isRespuesa()) 
			{
				setRelacionado();
			}
			break;
		case "setAddenda":
			if (respuesta.isRespuesa()) 
			{
				setAddenda();
			}
			break;
		case "addDateComprobante":
			if (respuesta.isRespuesa()) 
			{
				addDateComprobante();
			}
			break;
		case "requestResponse":
			if (respuesta.isRespuesa()) 
			{
				requestResponse();
			}
			break;
		default:
			break;
		}
		
		return;
	}
	
	public String date()
	{
		DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
		Date date = new Date();
		return ""+cal.get(Calendar.YEAR)+"-"+(cal.get(Calendar.MONTH)+1)+"-"+cal.get(Calendar.DAY_OF_MONTH)+" "+dateFormat.format(date)+""; 
	}
	
	private void requestResponse() 
	{
	    ObjectMapper mapper = new ObjectMapper();
		try {
			String json = mapper.writeValueAsString(comprobante);
//			System.out.println("PETICION: "+json);
			if(request.equals("s")) detalle.add("Peticion: "+json);;
			json = mapper.writeValueAsString(credenciales);
//			System.out.println("CREDENCIALES: "+json);
			if(request.equals("s")) detalle.add("Credenciales: "+json);;
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		detalleLog.add(log()+" Prepara request servicio PAC GenerarCFDI \n");
		response = selladoComprobante(credenciales, comprobante,"GenerarCFDI");
        
		
		
		try {
			String json = mapper.writeValueAsString(response);
//			System.out.println("REPSUESTA: "+json);
			if(request.equals("s")) detalle.add("Respuesta: "+json);;
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
    public GenerarCFDIResponse selladoComprobante(Credenciales credenciales, Comprobante33R comprobante, String metodo) 
    {
    	int count = 1, maxTries = 4;
    	while(true) 
		{
	    	try
	    	{
		    	ServiceLocator conector=new ServiceLocator();
		    	IService iconexion = conector.getBasicHttpBinding_IService();
		    	switch (metodo) 
		    	{
				case "GenerarCFDI":
					response = iconexion.generarCFDI(credenciales, comprobante);
					detalleLog.add(log()+" Responde request servico PAC "+metodo+" \n");
					processingResponse(metodo);
					break;
				case "ObtenerXMLPorReferencia":
					RespuestaOperacionCR responseOperacionXML = iconexion.obtenerXMLPorReferencia(credenciales.getUsuario(), credenciales.getPassword(), comprobante.getReferencia());
					detalleLog.add(log()+" Responde request servico PAC "+metodo+" \n");
					processingResponseObtenerXML("ObtenerXMLPorReferencia",responseOperacionXML);
					break;
				case "ObtenerPDF":
					RespuestaOperacionCR responseOperacionPDF = iconexion.obtenerPDF(credenciales.getUsuario(), credenciales.getPassword(), obtenerValor("tfd:TimbreFiscalDigital","UUID", "0"), null);
					detalleLog.add(log()+" Responde request servico PAC "+metodo+" \n");
					processingResponseObtenerPDF("ObtenerPDF",responseOperacionPDF);
					break;
				default:
					break;
				}
				break;
			}
	    	catch (Exception e) 
	    	{
	    		
	    		if (++count == maxTries) 
				{
	    			detalleLog.add(log()+" Error al mandar request servico PAC "+metodo+". INTENTOS SELLADO: "+(count-1)+". Error: "+e.getMessage().toString()+" \n");
		    		fillRsp(false, "Error al mandar peticion a cliente, INTENTOS SELLADO: "+(count-1)+"", true, e.getMessage().toString());
		    		executeQueryUpdate("9");
		    		break;
				}
	    		else
	    		{
	    			if (e.getMessage().toString().contains("nested exception is")) 
	    			{
	    				detalleLog.add(log()+" Error "+metodo+". Intento sellado: "+(count-1)+". Error: "+e.getMessage().toString()+" \n");
	    				try 
	    				{
	    					Thread.sleep(3*1000);
	    				}
	    				catch (InterruptedException e1) 
	    				{
	    					detalleLog.add(log()+" Error en Sleep "+metodo+", intento sellado: "+(count-1)+". Error: "+e.getMessage().toString()+" \n");
	    				}
				    }
	    			else
	    			{
	    				detalleLog.add(log()+" Error al mandar request servico PAC "+metodo+". Error: "+e.getMessage().toString()+" \n");
			    		fillRsp(false, "Error al mandar peticion a cliente "+metodo+"", true, e.getMessage().toString());
			    		executeQueryUpdate("9");
			    		break;	
	    			}
	    		}
	    		
			}
		}
    	return response;
    }

	private void processingResponse(String metodo) 
	{
		if (respuesta.isRespuesa()) 
		{
			int validateFolioExist = 0;
			if (response.getOperacionExitosa() != null) 
			{
				if (response.getOperacionExitosa()) 
				{
					detalleLog.add(log()+" Procesa request EXITOSO "+metodo+" \n");
					processingRequestTrue();
				}
				else 
				{
					detalleLog.add(log()+" Procesa request FALSE "+metodo+" \n");
					ErroresCFDI[] errores = response.getErrores();
					for (int i = 0; i < errores.length; i++) 
					{
						if (errores[i].getErrorGeneral().contains("El folio ya existe")) 
						{
							validateFolioExist = 1;
						}
						else
						{
							detalle.add("ERROR "+date()+" "+i+": "+errores[i].getErrorGeneral()+". ERROR DETALLADO: "+errores[i].getErrorDetallado());	
						}
					}
					if (validateFolioExist == 0) 
					{
						fillRsp(false, "No se genero CFDI", false, "");
						executeQueryUpdate("9");
						envioWS("log");	
					}
					else
					{
						detalleLog.add(log()+" Procesa FOLIO YA EXISTE  \n");
						processingRequestFolioExiste();
					}
					
				}
			}
			else
			{
				fillRsp(false, "Response is null", true, "Verifique que el request exista o no este comentado.");
			}
		}
	}

	private void processingResponseObtenerXML(String metodo, RespuestaOperacionCR responseOperacionXML) 
	{
		if (respuesta.isRespuesa()) 
		{
			if (responseOperacionXML.getOperacionExitosa() != null) 
			{
				if (responseOperacionXML.getOperacionExitosa()) 
				{
					detalleLog.add(log()+" Procesa request EXITOSO "+metodo+" \n");
					response.setCBB(responseOperacionXML.getCBB());
					response.setXML(responseOperacionXML.getXML());
					response.setOperacionExitosa(true);
					byte[] xmlByte = Base64.getDecoder().decode(response.getXML());
		            xmlDecodificado = new String(xmlByte);	
					xml = response.getXML();
					cbb = response.getCBB();
				}
				else 
				{
					detalleLog.add(log()+" Procesa request FALSE "+metodo+" \n");
					detalle.add("ERROR "+date()+" "+metodo+": "+responseOperacionXML.getErrorGeneral()+". ERROR DETALLADO: "+responseOperacionXML.getErrorDetallado());	
					fillRsp(false, "No se genero CFDI", false, "");
					executeQueryUpdate("9");
					envioWS("log");	
				}
			}
			else
			{
				fillRsp(false, "Response is null", true, "Verifique que el request exista o no este comentado. "+metodo+"");
			}
		}
	}
	

	private void processingRequestFolioExiste() 
	{
		if (respuesta.isRespuesa()) 
		{
			detalleLog.add(log()+" Prepara request servicio PAC ObtenerXMLPorReferencia \n");
			response = selladoComprobante(credenciales, comprobante, "ObtenerXMLPorReferencia");
			if (respuesta.isRespuesa()) 
			{
				detalleLog.add(log()+" Prepara request servicio PAC ObtenerPDF \n");
				response = selladoComprobante(credenciales, comprobante, "ObtenerPDF");
			}
		}
		
		
		
	}


	private void processingResponseObtenerPDF(String metodo, RespuestaOperacionCR responseOperacionPDF) 
	{
		if (respuesta.isRespuesa()) 
		{
			if (responseOperacionPDF.getOperacionExitosa() != null) 
			{
				if (responseOperacionPDF.getOperacionExitosa()) 
				{
					detalleLog.add(log()+" Procesa request EXITOSO "+metodo+" \n");
					response.setPDF(responseOperacionPDF.getPDF());
					response.setCBB(cbb);
					response.setXML(xml);
					response.setOperacionExitosa(true);
					processingRequestTrue();
				}
				else 
				{
					detalleLog.add(log()+" Procesa request FALSE "+metodo+" \n");
					detalle.add("ERROR "+date()+" "+metodo+". UUID: "+obtenerValor("tfd:TimbreFiscalDigital","UUID", "0")+". GENERAL: "+responseOperacionPDF.getErrorGeneral()+". ERROR DETALLADO: "+responseOperacionPDF.getErrorDetallado());	
					fillRsp(false, "No se genero CFDI", false, "");
					executeQueryUpdate("9");
					envioWS("log");	
				}
			}
			else
			{
				fillRsp(false, "Response is null", true, "Verifique que el request exista o no este comentado. "+metodo+"");
			}
		}
	}


	private void processingRequestTrue() 
	{
		if (respuesta.isRespuesa()) 
		{
			byte[] xmlByte = Base64.getDecoder().decode(response.getXML());
            xmlDecodificado = new String(xmlByte);
            executeQueryUpdate("7");
            if (info.getCdo().toLowerCase().equals("kwx") || info.getCdo().toLowerCase().equals("a03")) {
            	nombreFile = info.getSerie()+"."+info.getFolio();
            	cbb = response.getCBB();
            	pdf = response.getPDF();
            	crearPngAndXml();
            	envioWS("insertFacturacion");
			}
            if (info.getCdo().toLowerCase().equals("cdf") || info.getCdo().toLowerCase().equals("cdl") || info.getCdo().toLowerCase().equals("cdm") || info.getCdo().toLowerCase().equals("cd2")) 
            {
            	detalleLog.add(log()+" Envia request insertFacturacion \n");
            	envioWS("insertFacturacion");
            	nombreFile = info.getSerie()+"."+info.getFolio();
            	cbb = response.getCBB();
            	pdf = response.getPDF();
            	crearPngAndXml();
			}
            if (envioCorreo.equals("s")) 
            {
            	email = getValueString("receptor","etiqueta_email",0); 
            	if (email != "") 
            	{
            		detalleLog.add(log()+" Envia request  wsCFDI \n");
            		envioWS("envioCFDI");
            	}
            	else
            	{
            		detalleLog.add(log()+" Correo receptor vacio, no se envia wsCFDI \n");
            	}
			}
            if (respuesta.isRespuesa()) 
            {
            	detalleLog.add(log()+" Se genero correctamente CFDI \n");
            	executeQueryUpdate("9");
            	fillRsp(true, "Exito", true, "Se genero correctamente el CFDI");
			}
            else
            {
            	executeQueryUpdate("9");
            }
		}
	}


	private void envioWS(String tipo) 
	{
//		String log = "http://deswebcdo18.corprama.com.mx:8080/wsProcesosWeb/ws/ProcesosWeb/proceso?cdo="+info.getCdo()+"&serie="+info.getSerie()+"&folio="+info.getFolio()+"";
//		String envioCFDI = "http://deswebcdo18.corprama.com.mx:8080/wsGeneraPDF/ws/PDF/generaPdfXml?cdo="+info.getCdo()+"&serie="+info.getSerie()+"&folio="+info.getFolio()+"&correo="+email+"";
		String insertFacturacion = "http://deswebcdo18.corprama.com.mx:8080/wsFacturacionXML/ws/proceso/xml?cdo="+info.getCdo().toLowerCase()+"&serie="+info.getSerie()+"&folio="+info.getFolio()+"";
//		
		String log = "http://ws1.corprama.com.mx:8080/wsProcesosWeb/ws/ProcesosWeb/proceso?cdo="+info.getCdo()+"&serie="+info.getSerie()+"&folio="+info.getFolio()+"";
		String envioCFDI = "http://ws1:8080/wsGeneraPDF/ws/PDF/generaPdfXml?cdo="+info.getCdo()+"&serie="+info.getSerie()+"&folio="+info.getFolio()+"&correo="+email+"&grupo="+grupos+"";
		
//		String insertFacturacion = "http://ws1:8080/wsFacturacionXML/ws/proceso/xml?cdo="+info.getCdo().toLowerCase()+"&serie="+info.getSerie()+"&folio="+info.getFolio()+"";

//		String log = "http://172.16.251.88:8080/wsProcesosWeb/ws/ProcesosWeb/proceso?cdo="+info.getCdo()+"&serie="+info.getSerie()+"&folio="+info.getFolio()+"";
//		String envioCFDI = "http://172.16.251.88:8080/wsGeneraPDF/ws/PDF/generaPdfXml?cdo="+info.getCdo()+"&serie="+info.getSerie()+"&folio="+info.getFolio()+"&correo="+email+"";
//		String insertFacturacion = "http://172.16.251.88:8080/wsFacturacionXML/ws/proceso/xml?cdo="+info.getCdo().toLowerCase()+"&serie="+info.getSerie()+"&folio="+info.getFolio()+"";
		
		
//		DESARROLLO 
//		String insertFacturacion = "http://deswebcdo18.corprama.com.mx:8080/wsFacturacionXMLDEV/ws/proceso/xml?cdo="+info.getCdo().toLowerCase()+"&serie="+info.getSerie()+"&folio="+info.getFolio()+"";
//		String log = "http://deswebcdo18.corprama.com.mx:8080/wsProcesosWebDEV/ws/ProcesosWeb/proceso?cdo="+info.getCdo()+"&serie="+info.getSerie()+"&folio="+info.getFolio()+"";
//		String envioCFDI = "http://deswebcdo18.corprama.com.mx:8080/wsGeneraPDFDEV/ws/PDF/generaPdfXml?cdo="+info.getCdo()+"&serie="+info.getSerie()+"&folio="+info.getFolio()+"&correo="+email+"&grupo=0";		
		
		String urlCorreo = "";
		
		switch (tipo) 
		{
		case "envioCFDI":
			urlCorreo = envioCFDI;
			break;
		case "insertFacturacion":
			urlCorreo = insertFacturacion;
			break;
		case "log":
			urlCorreo = log;
			break;
		default:
			break;
		}
		try {
		detalleLog.add(log()+" Envia request "+urlCorreo+"\n");
		StringBuilder resultado = new StringBuilder();
		URL url = new URL(urlCorreo);
		HttpURLConnection conexion = (HttpURLConnection) url.openConnection();
		conexion.setRequestMethod("GET");
		BufferedReader rd = new BufferedReader(new InputStreamReader(conexion.getInputStream()));
		String linea;
		while ((linea = rd.readLine()) != null)
		{
			resultado.append(linea);
		}
		rd.close();
		} catch (Exception e) 
		{
        	fillRsp(false, "Error al consumir ws"+tipo+"", true, e.getMessage().toString());
        }
		
	}


	private void addDateComprobante() 
	{
		comprobante.setEmisor(emisor);
		comprobante.setReceptor(receptor);
		comprobante.setAddenda(addenda);
		comprobante.setConceptos(this.conceptoIArray);
		detalleLog.add(log()+" Llena objeto comprobante final \n");
	}

	private void setAddenda() 
	{
		if(!getValueString("receptor","etiqueta_num_cli",0).equals("null")) domicilioClienteR.setCalle(getValueString("receptor","etiqueta_num_cli",0));
        if(!getValueString("receptor","etiqueta_no_exterior",0).equals("null")) domicilioClienteR.setNumeroExterior(getValueString("receptor","etiqueta_no_exterior",0));
        if(!getValueString("receptor","etiqueta_no_interior",0).equals("null")) domicilioClienteR.setNumeroInterior(getValueString("receptor","etiqueta_no_interior",0));
        if(!getValueString("receptor","etiqueta_colonia",0).equals("null")) domicilioClienteR.setColonia(getValueString("receptor","etiqueta_colonia",0));
        if(!getValueString("receptor","etiqueta_codigo_postal",0).equals("null")) domicilioClienteR.setCodigoPostal(getValueString("receptor","etiqueta_codigo_postal",0));
        if(!getValueString("receptor","etiqueta_municipio",0).equals("null")) domicilioClienteR.setMunicipio(getValueString("receptor","etiqueta_municipio",0));
        if(!getValueString("receptor","etiqueta_pais",0).equals("null")) domicilioClienteR.setPais(getValueString("receptor","etiqueta_pais",0));

        if(domicilioClienteR != null) 
        {
        	addenda.setDomicilioReceptor(domicilioClienteR);
        }

        if(!getValueString("receptor","etiqueta_email",0).equals("null")) addenda.setCorreoCliente(getValueString("receptor","etiqueta_email",0));


        EtiquetaPersonalizadaR[] etiquetaPedidoarray = new EtiquetaPersonalizadaR[9];
        boolean hayEtiquetasPersonalizadas = false;
        int aux = 0;
        if(!getValueString("comprobante","observaciones",0).equals("null")) {
            EtiquetaPersonalizadaR etiquetaRuta = new EtiquetaPersonalizadaR();
            etiquetaRuta.setNombre("Observaciones");
            etiquetaRuta.setValor(getValueString("comprobante","observaciones",0));
            etiquetaPedidoarray[aux] = etiquetaRuta;
            aux++;
            hayEtiquetasPersonalizadas = true;
        }
        if(!getValueString("receptor","etiqueta_transporte",0).equals("null")) {
            EtiquetaPersonalizadaR etiquetaTransporte = new EtiquetaPersonalizadaR();
            etiquetaTransporte.setNombre("Transporte");
            etiquetaTransporte.setValor(getValueString("receptor","etiqueta_transporte",0));
            etiquetaPedidoarray[aux] = etiquetaTransporte;
            aux++;
            hayEtiquetasPersonalizadas = true;
        }
        if(!getValueString("receptor","etiqueta_calle",0).equals("null")) {
            EtiquetaPersonalizadaR etiquetaTransporte = new EtiquetaPersonalizadaR();
            etiquetaTransporte.setNombre("Direccion de entrega");
            etiquetaTransporte.setValor(getValueString("receptor","etiqueta_calle",0)+""
            		+ " NO. "+getValueString("receptor","etiqueta_no_exterior",0)+""
            		+ " INT. "+getValueString("receptor","etiqueta_no_interior",0)+""
            		+ " C.P. "+getValueString("receptor","etiqueta_codigo_postal",0)+""
            		+ " COLONIA "+getValueString("receptor","etiqueta_colonia",0)+""
            		+ ", "+getValueString("receptor","etiqueta_municipio",0)+""
            		+ ", "+getValueString("receptor","etiqueta_estado",0)+","
            		+ ", "+getValueString("receptor","etiqueta_pais",0)+".");
            etiquetaPedidoarray[aux] = etiquetaTransporte;
            aux++;
            hayEtiquetasPersonalizadas = true;
        }
        if(!getValueString("comprobante","fecha_cfdi",0).equals("null")) {
            EtiquetaPersonalizadaR etiquetaRuta = new EtiquetaPersonalizadaR();
            etiquetaRuta.setNombre("Fecha de Operacion");
            etiquetaRuta.setValor(getValueString("comprobante","fecha_cfdi",0));
            etiquetaPedidoarray[aux] = etiquetaRuta;
            aux++;
            hayEtiquetasPersonalizadas = true;
        }
        if(!getValueString("receptor","etiqueta_ruta",0).equals("null")) {
            EtiquetaPersonalizadaR etiquetaRuta = new EtiquetaPersonalizadaR();
            etiquetaRuta.setNombre("Ruta");
            etiquetaRuta.setValor(getValueString("receptor","etiqueta_ruta",0));
            etiquetaPedidoarray[aux] = etiquetaRuta;
            aux++;
            hayEtiquetasPersonalizadas = true;
        }
        if(!getValueString("receptor","etiqueta_pedido",0).equals("null")) {
            EtiquetaPersonalizadaR etiquetaRuta = new EtiquetaPersonalizadaR();
            etiquetaRuta.setNombre("Inf complemento");
            etiquetaRuta.setValor("Pedido: "+getValueString("receptor","etiqueta_pedido",0)+" ODE: "+
            		getValueString("receptor","ode",0)+" Cliente: "+getValueString("receptor","etiqueta_num_cli",0)
            		+" Agente: "+getValueString("receptor","etiqueta_agente",0)+" Condiciones de Pago: "+
            		getValueString("receptor","etiqueta_condicion_credito",0));
            etiquetaPedidoarray[aux] = etiquetaRuta;
            aux++;
            hayEtiquetasPersonalizadas = true;
        }
        if(hayEtiquetasPersonalizadas) addenda.setEtiquetasPersonalizadas(etiquetaPedidoarray);
        detalleLog.add(log()+" Llena addenda \n");
	}

	private void setRelacionado() 
	{
		if (relacionadosBD.size()>0) 
		{
			CfdiRelacionadoR cfdiRelacionadoR =  new CfdiRelacionadoR();
			CfdiRelacionadosR cfdiRelacionadosR =  new CfdiRelacionadosR();
			
			cfdiRelacionadoR.setUUID(getValueString("relacionados", "folio_fiscal",0));
	        CfdiRelacionadoR [] cfdiRelacionadoRArray =  new CfdiRelacionadoR[1];
	        cfdiRelacionadoRArray[0] = cfdiRelacionadoR;
	        
	        cfdiRelacionadosR.setTipoRelacion(getValueString("relacionados", "tipo_relacion",0));
	        cfdiRelacionadosR.setCfdiRelacionado(cfdiRelacionadoRArray);
	        
	        CfdiRelacionadosR [] cfdiRelacionadosRArray =  new CfdiRelacionadosR[1];
	        cfdiRelacionadosRArray[0] = cfdiRelacionadosR;
	        
	        comprobante.setCfdiRelacionados(cfdiRelacionadosRArray);
	        detalleLog.add(log()+" Llena documentos relacionados");
		}
	}

	private void setComprobante() 
	{
		comprobante.setClaveCFDI(getValueString("comprobante","tipo_comprobante",0));
        String tipoComprobante = this.getTipoComprobante(getValueString("comprobante","tipo_comprobante",0));
        comprobante.setTipoDeComprobante(tipoComprobante); //revisar de donde se sacara
        comprobante.setDescuento(new BigDecimal(getValueString("comprobante","importe_descuentos_correcto",0)));
        comprobante.setSubTotal(new BigDecimal(getValueString("comprobante","importe_subtotal_correcto",0)));
        comprobante.setTotal(new BigDecimal (getValueString("comprobante","total",0) ));
        comprobante.setExportacion(getValueString("comprobante","exportacion",0) );
        comprobante.setFolio(getValueString("comprobante","folio",0) );
        comprobante.setSerie(getValueString("comprobante","serie",0) );
        comprobante.setFormaPago(getValueString("comprobante","forma_pago",0));
        comprobante.setLugarExpedicion(getValueString("comprobante","lugar_expedicion",0));
        comprobante.setMetodoPago(getValueString("comprobante","metodo_pago",0));
        comprobante.setMoneda(getValueString("comprobante","moneda",0));
        comprobante.setReferencia(getValueString("comprobante","serie",0)+"."+getValueString("comprobante","folio",0));
        comprobante.setFecha(obtenerFecha(getValueString("comprobante","fecha_cfdi_sellado",0)+"T"+getValueString("comprobante","hora_cfdi_sellado",0)));
        detalleLog.add(log()+" Llena comprobante \n");
	}
	
	private Calendar obtenerFecha(String parametroFecha) 
	{
		Calendar fecha = Calendar.getInstance();
		SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
		formatoFecha.setTimeZone(TimeZone.getTimeZone("GMT"));
		try 
		{
			 fecha.setTime(formatoFecha.parse(""+parametroFecha+""));
		}
		catch (ParseException e) 
		{
			fillRsp(false, "Error al parsear fecha", true, "Error al obtener formato de fecha "+parametroFecha+". Error: "+e.getMessage().toString()+" con la SERIE: "+info.getSerie()+". FOLIO: "+info.getFolio()+".");
		}	
		
		return fecha;
	}
	
    public String getTipoComprobante(String claveCfdi){

        String tipoComprobante = "I";
        switch (claveCfdi) {
            case "CAR" :
            case "FAC" :
                tipoComprobante = "I";
                break;
            case "CRE":
                tipoComprobante = "E";
                break;
            case "POR" :
                tipoComprobante = "T";
                break;
            case "CPA" :
                tipoComprobante = "P";
                break;
            case "TRC" :
                tipoComprobante = "T";
                break;   
        }

        return tipoComprobante;
    }
	
	private void setGlobal() 
	{
		if (!getValueString("comprobante","serie",0).equals("null") && getValueString("comprobante","tipo_documento",0).equals("8")) 
		{
			global.setAño(2022);
			global.setPeriodicidad("11");
			global.setMeses("12");
			detalleLog.add(log()+" Llena informacion global \n");
		}
	}

	private void setCredenciales() 
	{
		credenciales.setSucursal(getValueString("credenciales","sucursal",0));
		credenciales.setCuenta(getValueString("credenciales","cuenta",0));
		credenciales.setUsuario(getValueString("credenciales","usuario",0));
		credenciales.setPassword(getValueString("credenciales","password",0));
		detalleLog.add(log()+" Llena credenciales \n");
	}
	
	private void setEmisor() 
	{
		emisor.setNombre(getValueString("emisor","nombre",0));
		emisor.setRegimenFiscal(getValueString("emisor","regimen_fiscal",0));
		emisor.setRfc(getValueString("emisor","rfc",0));
		detalleLog.add(log()+" Llena emisor \n");
	}
	
	private void setReceptor() 
	{
		receptor.setDomicilioFiscalReceptor(getValueString("receptor","domicilio_fiscal",0));
		receptor.setNombre(getValueString("receptor","nombre",0));
		receptor.setRegimenFiscalReceptor(getValueString("receptor","regimen_fiscal_receptor",0));
		receptor.setRfc(getValueString("receptor","rfc",0));
		receptor.setUsoCFDI(getValueString("receptor","uso_cfdi",0));
		detalleLog.add(log()+" Llena receptor \n");
	}

	private void setConcepto() 
	{
		conceptoIArray = new  ConceptoR[conceptosBD.size()];
		int aux = 0;
		for (HashMap<String, Object> hashMap : conceptosBD) 
		{
			ConceptoR conceptoI = new ConceptoR();
			conceptoI.setCantidad(new BigDecimal(getValueString("conceptos", "cantidad",aux)));
			conceptoI.setClaveProdServ( getValueString("conceptos", "c_ClaveProdServ",aux));
            conceptoI.setClaveUnidad(getValueString("conceptos", "clave_unidad",aux));
            conceptoI.setDescripcion( getValueString("conceptos", "descripcion",aux) );
            conceptoI.setDescuento(new BigDecimal( getValueString("conceptos", "descuento",aux) ));
            conceptoI.setImporte(new BigDecimal( getValueString("conceptos", "importe",aux) ));
            conceptoI.setObjetoImp( getValueString("conceptos", "objeto_imp",aux) );
            conceptoI.setNoIdentificacion( getValueString("conceptos", "no_identificacion",aux) );
            conceptoI.setUnidad(getValueString("conceptos", "unidad",aux));
            conceptoI.setValorUnitario(new BigDecimal(getValueString("conceptos", "valor_unitario",aux)));
            conceptoI.setObjetoImp(getValueString("conceptos", "objeto_imp",aux));
            if(!info.getSerie().substring(3).equals("POR")) 
            {
                //Obtener Impuestos
                ImpuestosConceptoR impuestosConceptosI = new ImpuestosConceptoR();

                //Traslado
                TrasladoConceptoR trasladosI = new TrasladoConceptoR();
                trasladosI.setBase(new BigDecimal(getValueString("conceptos", "base_traslado",aux)));
                trasladosI.setImporte(new BigDecimal(getValueString("conceptos", "importe_traslado",aux)));
                trasladosI.setImpuesto(getValueString("conceptos", "impuesto_traslado",aux));
                trasladosI.setTasaOCuota(new BigDecimal(getValueString("conceptos", "tasa_cuota_traslado",aux)));
                trasladosI.setTipoFactor(getValueString("conceptos", "tipo_factor_traslado",aux));

                TrasladoConceptoR[] trasladosArray = new TrasladoConceptoR[1];
                trasladosArray[0] = trasladosI;
                impuestosConceptosI.setTraslados(trasladosArray);

                
                if (new BigDecimal(getValueString("conceptos", "base_retencion",aux)).compareTo(new BigDecimal('0')) == 1) 
                {
                    //Retenciones
                    RetencionConceptoR retencionesI = new RetencionConceptoR();
                    retencionesI.setBase(new BigDecimal(getValueString("conceptos", "base_retencion",aux)));
                    retencionesI.setImporte(new BigDecimal(getValueString("conceptos", "importe_retencion",aux)));
                    retencionesI.setImpuesto(getValueString("conceptos", "impuesto_retencion",aux));
                    retencionesI.setTasaOCuota(new BigDecimal(getValueString("conceptos", "tasa_cuota_retencion",aux)));
                    retencionesI.setTipoFactor(getValueString("conceptos", "tipo_factor_retencion",aux));

                    RetencionConceptoR[] retencionesArray = new RetencionConceptoR[1];
                    retencionesArray[0] = retencionesI;

                    if(!getValueString("receptor", "rfc",0).equals("XAXX010101000") && !getValueString("conceptos", "objeto_imp",aux).equals("01"))
                    {
                    	impuestosConceptosI.setRetenciones(retencionesArray);
                    }
                }
                if (!getValueString("conceptos", "objeto_imp",aux).equals("01")) 
                {
					conceptoI.setImpuestos(impuestosConceptosI);
				}
            }
            conceptoIArray[aux] = conceptoI;
            aux++;
		}
		detalleLog.add(log()+" Llena conceptos \n");
	}
	
	private String getValueString(String lista, String campo, int posicion) 
	{
		String valor = "";
		switch (lista) 
		{
			case "credenciales":
				valor = String.valueOf(credencialesBD.get(0).get(campo));
				break;
			case "emisor":
				valor = String.valueOf(emisorBD.get(0).get(campo));		
				break;
			case "receptor":
				valor = String.valueOf(receptorBD.get(0).get(campo));
				break;
			case "conceptos":
				try 
				{
					valor = String.valueOf(conceptosBD.get(posicion).get(campo));
				}
				catch (Exception e) 
				{
					fillRsp(false, "Error al obtner valor", true, "No existe el campo "+campo+" en la posicion "+posicion+" de la lista "+lista+"BD obtenida. Error: "+e.getMessage().toString()+" con la SERIE: "+info.getSerie()+". FOLIO: "+info.getFolio()+".");
					return "";
				}
				break;
			case "comprobante":
				valor = String.valueOf(comprobanteBD.get(0).get(campo));
				break;
			case "relacionados":
				valor = String.valueOf(relacionadosBD.get(0).get(campo));
				break;
			default:
				break;
			}
		if (valor.equals("null"))
		{
			fillRsp(false, "Error al obtner valor", true, "No existe el campo "+campo+" en la lista  "+lista+"BD obtenida con la SERIE: "+info.getSerie()+". FOLIO: "+info.getFolio()+".");
			return valor;
		}
		
		return valor.trim();
	}

	private void getDate() 
	{
		 Map<String, String> map = new HashMap<>();
		 map.put("credenciales", "1");
		 map.put("emisor", "3");
		 map.put("receptor", "4");
		 map.put("conceptos", "5");
		 map.put("comprobante", "6");
		 map.put("relacionados", "8");
		 
		 map.forEach((k,v) -> executeQueryGet(v,k) );
		 detalleLog.add(" "+log()+" Obtiene informacion para sellado \n");
		 
	}

	public String log()
	{
		log++;
		return date() + " LOG "+log+".";
	}
	
	private void executeQueryGet(String noQuery, String descripcion) 
	{
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			String[] querys = new String[25];
			querys = Cls_Querys.LimpiaListaQuerys(querys);
			querys = Cls_Querys.ObtieneQuerys(Integer.parseInt(noQuery), listaQuerys, querys, info.getCdo());
			querys = InicializaQueryNumero1(querys);
			try
			{
				pstmt = connBD.prepareStatement("{call " + validarCDOxServidor(info.getCdo()) + ".usp_EXECUTE_QUERY_CFDI(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
//				pstmt = connBD.prepareStatement("{call " + validarCDOxServidor(info.getCdo()) + ".usp_EXECUTE_QUERY(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
				rs = EjecutaQuerysBD.EjecutarQuery(querys[0], querys[1], querys[2], querys[3], querys[4], querys[5], querys[6], querys[7], querys[8], querys[9], querys[10], querys[11], querys[12], querys[13], querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], querys[21], querys[22], querys[23], querys[24], "", pstmt, connBD);
				if (preferences.get("detalle", "null").equals("null")) 
				{
					ResultSetMetaData md = rs.getMetaData();
					int columns = md.getColumnCount();
					List<HashMap<String,Object>> list = new ArrayList<HashMap<String,Object>>();
					while (rs.next()) 
					{
						HashMap<String,Object> row = new HashMap<String, Object>(columns);
						for(int i=1; i<=columns; ++i) 
						{
							row.put(md.getColumnName(i),rs.getObject(i));
						}
						list.add(row);
					}
					addValidateList(list,descripcion);
					if (descripcion.equals("comprobante") && String.valueOf(list.get(0).get("serie")).equals("null") && !descripcion.equals("relacionados")) 
					{
					fillRsp(false, "0 registros", true, "No se encontraron registros al obtener "+descripcion+" con la SERIE: "+info.getSerie()+". FOLIO: "+info.getFolio()+".");
					}
					if (list.size()==0 && !descripcion.equals("comprobante") && !descripcion.equals("relacionados")) 
					{
						fillRsp(false, "0 registros", true, "No se encontraron registros al obtener "+descripcion+" con la SERIE: "+info.getSerie()+". FOLIO: "+info.getFolio()+".");
					}
					
				}
				else
				{
					fillRsp(false, "Error al ejecutar query.", true, "No se encontraron registros al obtener "+descripcion+". "+preferences.get("detalle", "null"));
					preferences.clear();
				}
			}
			catch (Exception e) 
			{
				fillRsp(false, "Error al obtener "+descripcion+" en executeQuery", true, e.getMessage().toString());
			}
			finally 
			{
				try 
				{
					pstmt.close();
				} catch (Exception e) 
				{				
					fillRsp(false, "Error al cerrar PReparedStatement in getXML", true, e.getMessage().toString());
				}
		}
	}
	
	private void executeQueryUpdate(String noQuery) 
	{
		
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			String[] querys = new String[25];
			querys = Cls_Querys.LimpiaListaQuerys(querys);
			querys = Cls_Querys.ObtieneQuerys(Integer.parseInt(noQuery), listaQuerys, querys, info.getCdo());
			querys = Integer.parseInt(noQuery) == 7 ? InicializaQueryNumero7(querys) : InicializaQueryNumero9(querys);
			if (noQuery.equals("9")) 
			{
				
				try {
					pstmt = connBD.prepareStatement(querys[0]);
		            pstmt.executeUpdate();
				} catch (SQLException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
				}
				finally 
				{
					try 
					{
						pstmt.close();
					} catch (Exception e) 
					{				
						fillRsp(false, "Error al cerrar pstm in executeQueryUpdate", true, e.getMessage().toString());
					}
				}
			}
			else {
			try
			{
				pstmt = connBD.prepareStatement("{call " + validarCDOxServidor(info.getCdo()) + ".usp_EXECUTE_QUERY_CFDI(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
//				pstmt = connBD.prepareStatement("{call " + validarCDOxServidor(info.getCdo()) + ".usp_EXECUTE_QUERY(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
				rs = EjecutaQuerysBD.EjecutarQuery(querys[0], querys[1], querys[2], querys[3], querys[4], querys[5], querys[6], querys[7], querys[8], querys[9], querys[10], querys[11], querys[12], querys[13], querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], querys[21], querys[22], querys[23], querys[24], "", pstmt, connBD);
				if (!preferences.get("detalle", "null").equals("null")) 
				{
					fillRsp(false, "Error al ejecutar query.", true, "method: executeQueryUpdate processing requestTrue. "+preferences.get("detalle", "null"));
					preferences.clear();	
				}
			}
			catch (Exception e) 
			{
				fillRsp(false, "Error en metodo executeQueryUpdate", true, e.getMessage().toString());
			}
			finally 
			{
				try 
				{
					pstmt.close();
				} catch (Exception e) 
				{				
					fillRsp(false, "Error al cerrar pstm in executeQueryUpdate", true, e.getMessage().toString());
				}
			}}
		
	}
	
	
	private void addValidateList(List<HashMap<String, Object>> list, String descripcion) 
	{
		switch (descripcion) 
		{
		case "credenciales":
			credencialesBD = list;
			break;
		case "emisor":
			emisorBD = list;		
			break;
		case "receptor":
			receptorBD = list;
			break;
		case "conceptos":
			conceptosBD = list;
			break;
		case "comprobante":
			comprobanteBD = list;
			break;
		case "relacionados":
			relacionadosBD = list;
			break;
		default:
			break;
		}
	}

	private String[] InicializaQueryNumero1(final String[] ListaQuerys) 
    {
        for (int i = 0; i < ListaQuerys.length; ++i) 
        {
            ListaQuerys[i] = ListaQuerys[i].replace("{FOLIO}", String.valueOf(info.getFolio()));
            ListaQuerys[i] = ListaQuerys[i].replace("{SERIE}", info.getSerie());
            ListaQuerys[i] = ListaQuerys[i].replace("{CDO}", info.getCdo().toUpperCase());
        }
        return ListaQuerys;
    }
	
	private String[] InicializaQueryNumero9(final String[] ListaQuerys) 
    {
		
//		String values = "('"+info.getCdo().toLowerCase()+"', '"+info.getSerie()+"', "+info.getFolio()+", '"+gson.toJson(respuesta).replace("\"","\\\"")+" \n"+detalleLog.toString().replace("\"","").replace("[","").replace("]","").replace(",","")+"', '"+ getValueString("comprobante","documento",0)+"', '"+getValueString("comprobante","documento_cfdi",0)+"', "+getValueString("comprobante","ode",0)+", CURDATE(), CURTIME())";
		String values = "('"+info.getCdo().toLowerCase()+"', '"+info.getSerie()+"', "+info.getFolio()+", '"+gson.toJson(respuesta).replace("\"","\\\"").replace("{\\", "{\n\\").replace(",\\", ",\n\\").replace("}", "\n}")+" \n"+detalleLog.toString().replace("\"","").replace("[","").replace("]","").replace(",","")+"', '"+ getValueString("comprobante","documento",0)+"', '"+getValueString("comprobante","documento_cfdi",0)+"', "+getValueString("comprobante","ode",0)+", CURDATE(), CURTIME())";
        for (int i = 0; i < ListaQuerys.length; ++i) 
        {
            ListaQuerys[i] = ListaQuerys[i].replace("{VALUES}", values);
        }
        return ListaQuerys;
    }
	
	
	private String[] InicializaQueryNumero7(final String[] ListaQuerys) 
    {
        for (int i = 0; i < ListaQuerys.length; ++i) 
        {
        	ListaQuerys[i] = ListaQuerys[i].replace("{FOLIO}", String.valueOf(info.getFolio()));
            ListaQuerys[i] = ListaQuerys[i].replace("{SERIE}", info.getSerie());
            ListaQuerys[i] = ListaQuerys[i].replace("{CDO}", info.getCdo().toUpperCase());
            ListaQuerys[i] = ListaQuerys[i].replace("{XML}", xmlDecodificado.toString());
            ListaQuerys[i] = ListaQuerys[i].replace("{CBB}", response.getCBB());
            ListaQuerys[i] = ListaQuerys[i].replace("{PDF}", response.getPDF());
            ListaQuerys[i] = ListaQuerys[i].replace("{DOCUMENTO}", getValueString("comprobante","documento",0));
            ListaQuerys[i] = ListaQuerys[i].replace("{DOCUMENTO_CFDI}", getValueString("comprobante","documento_cfdi",0));
            ListaQuerys[i] = ListaQuerys[i].replace("{ODE}", getValueString("comprobante","ode",0));
        }
        return ListaQuerys;
    }
	
	private void getTableQuerys(String cdo, String serie, String folio, String correo, String peticion, String grupo) 
	{
		envioCorreo = correo;
		request =  peticion != null ? peticion : "n";
		grupos =  grupo != null ? grupo : "0";
		if(respuesta.isRespuesa())
		{
			connBD =  ConexionBD.AbrirConexionBDD(cdo);
			if (connBD != null) 
			{
				listaQuerys = GestorUsuario.ConsultaTablaQuerysBD(cdo.toUpperCase(),connBD);
				info.setCdo(cdo);
				info.setFolio(Integer.parseInt(folio));
				info.setSerie(serie);
				if (preferences.get("detalle", "true").equals("true")) 
				{
					if (listaQuerys.size() == 0)  
					{
						fillRsp(false,"Error en querys",true,"La tabla de querys esta vacia");
					}
				}
				else
				{
					String splitMsj []= preferences.get("detalle", "No se pudo abrir la conexión, BD inactiva.").split("splitMsj");
					for (int i = 0; i < splitMsj.length; i++) 
					{
						detalle.add(splitMsj[i]);
					}
					fillRsp(false,"Error en querys",false,"");	
				}
			}
			else
			{
				String splitMsj []= preferences.get("detalle", "No se pudo abrir la conexión, BD inactiva.").split("splitMsj");
				for (int i = 0; i < splitMsj.length; i++) 
				{
					detalle.add(splitMsj[i]);
				}
				fillRsp(false,"Error en conexion",false,"");
			}
		}
		return;
	}
	
	private static String validarCDOxServidor(String cdo) 
    {
    	switch (cdo) 
    	{
			case "a03":
				cdo = "CFDI";
			break;
			default:
			break;
		}
		return cdo.toUpperCase();
	}

	private void fillRsp(boolean rsp, String mensaje, boolean addDetail, String detail) 
	{
		if(addDetail) {detalle.add(detail);}
		detalle.removeAll(Arrays.asList("",null));
		respuesta.setRespuesa(rsp);
		respuesta.setMensaje(mensaje);
		respuesta.setDetalle(detalle);
	}

	public Respuesta crearPngAndXml() 
	{
		createFilePNG();
		crearFileXML();
		if (info.getCdo().equalsIgnoreCase("ao3") || info.getCdo().equalsIgnoreCase("kwx")) 
		{
			createFilePDF();	
		}
		CopyFilesInServer();  
		
		return respuesta;
	}

	private void CopyFilesInServer() 
	{
		if (respuesta.isRespuesa()) 
		{
			String descripcionArchivos = "XML y PNG";
			String type3[] = {"xml","png","pdf"}, type2[] = {"xml","png"}, type[] =type2;
			if (info.getCdo().equalsIgnoreCase("ao3") || info.getCdo().equalsIgnoreCase("kwx")) 
			{
				descripcionArchivos = "XML, PNG y PDF";
				type = type3;
				remoteDir = remoteDirKWX;
			}
			if (info.getCdo().toLowerCase().equals("cdf")) 
			{
				remoteDir = "/usr/acct"+remoteDir;
			}
			try
			{
				 String server = ""+info.getCdo().toLowerCase()+"";
//				 String server = "des"+info.getCdo().toLowerCase()+"";
			        int port = 21;
			        String user = "ftpcfdi";
			        String pass = "$#cfdi2830";
			        FTPClient ftpClient = new FTPClient();
			 try
			 {
			        ftpClient.connect(server, port);
		            ftpClient.login(user, pass);
		            ftpClient.enterLocalPassiveMode();
		            ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
	                if (ftpClient.changeWorkingDirectory(remoteDir)) 
	                {
	                	for (int i = 0; i < type.length; i++) 
		                {
		                	File LocalFile = new File("/tmp/"+nombreFile+"."+type[i]+"");
		                	String remoteFile = remoteDir + nombreFile+"."+type[i]+"";
		                	InputStream inputStream = new FileInputStream(LocalFile);
			                boolean done = ftpClient.storeFile(remoteFile, inputStream);
			                if (done) 
			                {
			                	detalleLog.add(log()+" Se subio "+type[i].toUpperCase()+" al servidor correctamente "+remoteDir+nombreFile+"."+type[i]+" \n");
				                String permisos = 	"chmod " + "777 " +nombreFile+"."+type[i];
		                		if (ftpClient.changeWorkingDirectory(remoteDir)) 
			                    {
			                    	ftpClient.sendSiteCommand(permisos); 
			                    }
			                }
			                else
			                {
			                	detalleLog.add("LOG. "+date()+" No se pudo subir "+remoteDir+nombreFile+"."+type[i]+" al servidor \n");
			                }
			                inputStream.close();
						}	
					}
	                else
	                {
	                	detalleLog.add("LOG. "+date()+" Error al subir "+descripcionArchivos+", no existe directorio: "+remoteDir +" \n");
						fillRsp(false, "Error al subir "+descripcionArchivos+".", true,"No existe directorio: "+remoteDir);
	                }
					eliminaArchivo(""+nombreFile+".png");
					eliminaArchivo(""+nombreFile+".xml");
					if (info.getCdo().equalsIgnoreCase("ao3") || info.getCdo().equalsIgnoreCase("kwx")) 
					{
						eliminaArchivo(""+nombreFile+".pdf");
					}
			 }
			 catch (Exception e) 
			 {
				 detalleLog.add("LOG. "+date()+" No se pudo subir "+descripcionArchivos+" al servidor \n");
				 fillRsp(false, "Error al subir "+descripcionArchivos+" al servidor.", true,e.getMessage().toString());
			 } 
			 finally 
			 {
                    try 
                    {
	                    if (ftpClient.isConnected()) 
	                    {
	                        ftpClient.logout();
	                        ftpClient.disconnect();
	                    }
	                }
                    catch (IOException ex) 
                    {
	                	detalleLog.add("LOG. "+date()+" Error al cerrar cliente FTP: "+ex.getMessage().toString() +" \n");
	                }
	                 
	            } 
			}
			catch (Exception e) 
			{
				System.out.println("Error al conectar FTP: "+e.getMessage().toString());
			}
		}
	}


	public void createFilePNG() 
	{
		if (respuesta.isRespuesa()) 
		{
			try
			{
				
				BufferedImage image = null;
				byte[] imageByte = Base64.getDecoder().decode(cbb);
				ByteArrayInputStream bis = new ByteArrayInputStream(imageByte);
				image = ImageIO.read(bis);
				bis.close();
//				File outputfile = new File("C:\\FTP\\PNG\\image.png");
				File outputfile = new File("/tmp/"+nombreFile+".png");
				ImageIO.write(image, "png", outputfile);
				try
				{
				outputfile.createNewFile();
				}
				catch (Exception e) {
					detalleLog.add("LOG. "+date()+" Error al crear PNG ");
				}
				detalleLog.add(log()+" Se creo archivo PNG correctamente \n");
			}
			catch (Exception e) 
			{
				detalleLog.add("LOG. "+date()+" No se pudo crear archivo PNG \n");
				fillRsp(false, "Error al crear archivo PNG.", true, e.getMessage().toString());
			}
		}
	}

	public void createFilePDF() 
	{
		if (respuesta.isRespuesa()) 
		{
			try
			{
				File file = new File("/tmp/"+nombreFile+".pdf");
			    try ( FileOutputStream fos = new FileOutputStream(file); ) 
			    {
			      byte[] decoder = Base64.getDecoder().decode(pdf);
			      fos.write(decoder);
			      detalleLog.add(log()+" Se creo archivo PDF correctamente \n");
			    } catch (Exception e) {
			    	detalleLog.add("LOG. "+date()+" Error al crear PDF ");
			    }
			}
			catch (Exception e) 
			{
				detalleLog.add("LOG. "+date()+" No se pudo crear archivo PDF \n");
				fillRsp(false, "Error al crear archivo PDF.", true, e.getMessage().toString());
			}
		}
	}

	private void eliminaArchivo(String archivo) 
	{
		try
		{
			String[] commandEliminarArchivo = {"sh","-c","rm " +"/tmp/"+archivo};
			final Process processEliminar = Runtime.getRuntime().exec(commandEliminarArchivo);
		}
		catch (Exception e) 
		{
			detalleLog.add("LOG. "+date()+" No se pudo eliminar "+archivo+" en el servidor \n");
			fillRsp(false, "Error al eliminar "+archivo+" en el servidor.", true, e.getMessage().toString());
		}
	}


	private void crearFileXML() 
	{
		if (respuesta.isRespuesa()) 
		{
			try
			{
//				java.io.FileWriter fw = new java.io.FileWriter("C:\\FTP\\PNG\\"+nombreFile+".xml");
				java.io.FileWriter fw = new java.io.FileWriter("/tmp/"+nombreFile+".xml");
				fw.write(xmlDecodificado);
				fw.close();
				detalleLog.add(log()+" Se creo archivo XML correctamente \n");
			}
			catch (Exception e) 
			{
				detalleLog.add("LOG. "+date()+" No se pudo crear archivo XML  \n");
				fillRsp(false, "Error al crear archivo XML.", true, e.getMessage().toString());
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
			Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new InputSource(new StringReader(xmlDecodificado)));
			NodeList nList = document.getElementsByTagName(nodo);
			if (nList.getLength()>0) 
			{
				if (!funcion.equals("size"))
				{
					Node nNode = nList.item(Integer.parseInt(funcion));
					try
					{
						if(nNode.getNodeType() == Node.ELEMENT_NODE) 
						{
							Element eElement = (Element) nNode;
							valor = eElement.getAttribute(campo);
						}
					}
					catch (Exception e) 
					{
//						fillRsp(false,"Error en lectura de XML", false, "");
//						detalle.add("ERROR: "+e.getMessage().toString()+".NODO: "+nodo+". CAMPO: "+campo + ". METODO: "+method+". SECCION: " + funcion );
						valor = "";
					}
				}
				else
				{
					return String.valueOf(nList.getLength());
				}
			}
		}
		catch (Exception e) 
		{
//			fillRsp(false,"Error en lectura de XML", false, "");
//			detalle.add("Error al obtener datos XML. NODO: "+nodo+". CAMPO: "+campo+". METODO: "+method+". ERROR: "+e.getMessage().toString());
		}
		
	}
		return valor;
	}
}
