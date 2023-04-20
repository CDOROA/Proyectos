package cdo.Persistencia;

import java.io.StringReader;
import java.math.BigDecimal;
import java.rmi.RemoteException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

import javax.xml.parsers.DocumentBuilderFactory;

import org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.*;
import org.tempuri.*;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import cdo.Entidades.Conceptos;
import cdo.Entidades.EjecutaQuerysBD;
import cdo.Entidades.Querys;
import cdo.Entidades.Respuesta;
import cdo.Util.Cls_Querys;
import cdo.Util.Cls_log;
import cdo.Util.ConexionBD;

public class GestorSellado 
{
	 Cls_log log = new Cls_log();
	private Comprobante33R comprobante33r = new Comprobante33R();
	private Respuesta objRespuesta = new Respuesta();
	private boolean rsp = false;

	EmisorR emisor = new EmisorR();
	ReceptorR receptor = new ReceptorR();
	Credenciales credenciales = new Credenciales("","","");
	List<ConceptoR> lstConceptos = new ArrayList<>();
	List<Conceptos> lstConceptosXML = new ArrayList<>();
	List<CartaPorteUbicacion20R> lstUbicacion = new ArrayList<>();
	List<CartaPorteMercanciasMercancia20R> lstMercancias = new ArrayList<>();
    	 
	private static boolean merc=false,conc = false,ubi = false,enc = false;
	private static int folio = 0;
	private static String serie = "";
	//int totalDistanciaRecorrida = 0;
	BigDecimal totalDistanciaRecorrida = new BigDecimal("0.00"); 
	int 		totalMercancias = 0;
	BigDecimal pesoBrutoTotal = new BigDecimal("0.00"); 
	Double pesoNetoTotal = 0.00;
	Double valorMercancia  = 0.00;
	String referenciaCartaPorte = "";
	String tipoCartaPorte = "";
	
	public Respuesta Sellado(String cdo, String uname_br,String trayecto, List<Querys> listaQuerys) throws SQLException 
	{
		objRespuesta.setRespuesta(true);
		tipoCartaPorte = obtenerTipoCartaPorte(cdo,uname_br,trayecto,listaQuerys);
		obtenerInformacionParaSellado(cdo,uname_br,trayecto,listaQuerys,tipoCartaPorte);
		try
		{
			if (objRespuesta.isRespuesta())
			{
				ConexionRemotaLocator conector=new ConexionRemotaLocator();
				IConexionRemota iconexion = conector.getsoapHttpEndpoint();
				RespuestaOperacionCR respuesta = new RespuestaOperacionCR();
				//System.out.println("referenciaCartaPorte: " + referenciaCartaPorte);
				
				objRespuesta.setSerie(serie);
				objRespuesta.setFolio(folio);
				objRespuesta.setCdo(cdo);
				
				objRespuesta.setConceptos(lstConceptosXML);
				//System.out.println("Validando si existe CartaPorte: " + referenciaCartaPorte );
				
				log.Insrtalog(cdo, serie, folio, "Validando si existe CartaPorte: " + referenciaCartaPorte);
				
				recuperaCartaPorte(iconexion, credenciales, referenciaCartaPorte, cdo);
				//System.out.println("Recupero cartaPorte");
				log.Insrtalog(cdo, serie, folio, "Carta Porte ya sellada: " + objRespuesta.isRespuesta() +"." );
				
				if (!objRespuesta.isRespuesta())
				{
					//System.out.println("sellando...");
					log.Insrtalog(cdo, serie, folio, "sellando documento: "+ referenciaCartaPorte );
					respuesta = iconexion.generarCFDI(credenciales,comprobante33r);
					
					imprimirMensajesDeRespuesta(cdo,respuesta);
					if (objRespuesta.isRespuesta())
					{
					RecuperaPDF(iconexion, credenciales, cdo);
					}
				}
			}
		}
		catch (Exception e) 
		{
			objRespuesta.setMsjError("Error en metodo principal sellado. ERROR: "+e.getMessage());
			objRespuesta.setRespuesta(false);
			log.Insrtalog(cdo, serie, folio, "Error en metodo principal sellado. ERROR: "+e.getMessage());
		}
		return objRespuesta;
	}

	
	
	
	private void recuperaCartaPorte(IConexionRemota iconexion, Credenciales credenciales2,
			String referenciaCartaPorte2, String cdo ) {
		 try {
			RespuestaOperacionCR respuesta = iconexion.obtenerXMLPorReferencia(credenciales, referenciaCartaPorte);
			imprimirMensajesDeRespuesta(cdo, respuesta);
			//System.out.println("respuesta de recuperaCartaPorte: " + respuesta.getOperacionExitosa());
			if (respuesta.getOperacionExitosa())
			{
				RecuperaPDF(iconexion, credenciales2, cdo);
			
			}

		} catch (RemoteException e) {
			System.out.println("Error al recuperar la carta porte: " + e);
			objRespuesta.setMsjError("Error en metodo recuperaCartaPorte. ERROR: "+e.getMessage());
			objRespuesta.setRespuesta(false);
		}
		
	}




	private void RecuperaPDF(IConexionRemota iconexion, Credenciales credenciales2, String cdo) throws RemoteException {
		try {
			log.Insrtalog(cdo, serie, folio, "Recuperando codigo del PDF.");
			RespuestaOperacionCR respuesta;
			String uuid = obtenerValor("tfd:TimbreFiscalDigital", "UUID","0"); 
			System.out.println("UUID: " + uuid);
			respuesta = iconexion.obtenerPDF(credenciales2, uuid, cdo);
			objRespuesta.setCodigoPDF(respuesta.getPDF());
		}
		catch (Exception e) {
			log.Insrtalog(cdo, serie, folio, "Error al  recuperar el PDF: " + e);
			System.out.println("Error al  recuperar el PDF: " + e);
		}
	}


	private String obtenerTipoCartaPorte(String cdo, String uname_br, String trayecto, List<Querys> ListaQuerys) throws SQLException {
		String tipo = "";
		Connection connBD = null;
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;	        
	        try
	        {
	        	String[] querys = new String[25];
	        	connBD = ConexionBD.AbrirConexionBDD(cdo);	        	
	        	querys = inicializacionQrys(querys, ListaQuerys, cdo, 5,uname_br,trayecto);	        	
	        	pstmt = connBD.prepareStatement("{call " + cdo.toUpperCase() + ".usp_EXECUTE_QUERY_CP(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
	            rs = EjecutaQuerysBD.EjecutarQuery(querys[0], querys[1], querys[2], querys[3], querys[4], querys[5], querys[6], querys[7], querys[8], querys[9], querys[10], querys[11], querys[12], querys[13], querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], querys[21], querys[22], querys[23], querys[24], cdo, pstmt, connBD);
	            Cls_Querys.ImprimeQuerysConsola(querys, false, "/*obteniendo Tipo CP*/");
	            if (rs != null) 
	            {
	            	while(rs.next()) {
	            		tipo = rs.getString("tipo");
		            	//System.out.println("tipo: " + tipo);	
	            	}	            	
	            }
	            
	        }
	        catch (Exception e) 
	        {
	        	objRespuesta.setMsjError("Error al obtener informacion del tipo CP. ERROR: "+e.getMessage());
				objRespuesta.setRespuesta(false);
	        	rsp = false;
			}
	        finally
	        {
	        	pstmt.close();
	        	connBD.close();				
			}
	        return tipo;
	}

	private void obtenerInformacionParaSellado(String cdo, String uname_br, String trayecto, List<Querys> ListaQuerys, String tipoCartaPorte) 
	{
		try
		{
			Connection connBD = null;
	        PreparedStatement pstmt = null;
	        ResultSet rs = null;
	        try
	        {
	        	String[] querys = new String[25];
	        	connBD = ConexionBD.AbrirConexionBDD(cdo);
	        	
	        	
	        	querys = inicializacionQrys(querys, ListaQuerys, cdo, 4,uname_br,trayecto);
	        	
	        	pstmt = connBD.prepareStatement("{call " + cdo.toUpperCase() + ".usp_EXECUTE_QUERY_CP(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
	            rs = EjecutaQuerysBD.EjecutarQuery(querys[0], querys[1], querys[2], querys[3], querys[4], querys[5], querys[6], querys[7], querys[8], querys[9], querys[10], querys[11], querys[12], querys[13], querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], querys[21], querys[22], querys[23], querys[24], cdo, pstmt, connBD);
	        	
	            Cls_Querys.ImprimeQuerysConsola(querys, false, "/*actualizando*/");
	         
	         if(tipoCartaPorte.equals("C")) {
	        	 querys = inicializacionQrys(querys, ListaQuerys, cdo, 3,uname_br,trayecto);
		            pstmt = connBD.prepareStatement("{call " + cdo.toUpperCase() + ".usp_EXECUTE_QUERY_CP(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
		            rs = EjecutaQuerysBD.EjecutarQuery(querys[0], querys[1], querys[2], querys[3], querys[4], querys[5], querys[6], querys[7], querys[8], querys[9], querys[10], querys[11], querys[12], querys[13], querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], querys[21], querys[22], querys[23], querys[24], cdo, pstmt, connBD);		            	            
		            Cls_Querys.ImprimeQuerysConsola(querys, true, "/*Recuperando informacion de BD .CDO.*/");
	         }else {
	        	 querys = inicializacionQrys(querys, ListaQuerys, cdo, 6,uname_br,trayecto);
		            pstmt = connBD.prepareStatement("{call " + cdo.toUpperCase() + ".usp_EXECUTE_QUERY_CP(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
		            rs = EjecutaQuerysBD.EjecutarQuery(querys[0], querys[1], querys[2], querys[3], querys[4], querys[5], querys[6], querys[7], querys[8], querys[9], querys[10], querys[11], querys[12], querys[13], querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], querys[21], querys[22], querys[23], querys[24], cdo, pstmt, connBD);		            	            
		            Cls_Querys.ImprimeQuerysConsola(querys, true, "/*Recuperando informacion de BD .RCS.*/");
	         }
	            
	            if (rs != null) 
	            {
	            	//System.out.println("Entra al llenado. ");
	            	llenarInfoSellado(cdo, rs);
				}
	            /*System.out.println("mercancia boolean: "+ merc);
	            System.out.println("conceptos boolean: "+ conc);
	            System.out.println("ubicaciones boolean: "+ ubi);
	            System.out.println("encabezado boolean: "+ enc);*/
	            
	            validarRegistros(merc,conc,ubi,enc);
	            
	        }
	        catch (Exception e) 
	        {
	        	objRespuesta.setMsjError("Error al obtener Informacion Para Sellado. ERROR: "+e.getMessage());
				objRespuesta.setRespuesta(false);
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
			objRespuesta.setMsjError("Error al llenar insertar en BD XML. ERROR: "+e.getMessage());
			objRespuesta.setRespuesta(false);
			rsp = false;
		}
	}

	private void llenarInfoSellado(String cdo, ResultSet rs)
	{
		int idConceptos = 0, idUbicaciones = 0, idMercancias = 0;

		try
		{
			while (rs.next()) 
			{
				String tipo = rs.getString("tipo");
				if (tipo.equals("1mercancia"))
						{
					if (!valor("c_ClaveProdServ_mercancia", rs).equals("80141605")) 
					{
					//	System.out.println("MERCANCIA");
						obtenerCartaMercanciaArray(rs,idMercancias);
						merc = true;
						idMercancias++;
					}
						
				}
				if (tipo.equals("2conceptos")) {
						obtenerConceptos(rs,idConceptos);
					//	System.out.println("CONCEPTOS");
						conc = true;
						idConceptos++;}
					if (tipo.equals("3ubicaciones")) {
					//	System.out.println("UBICACIOMEs");
						obtenerUbicaciones(rs,idUbicaciones);
						
						ubi = true;
						idUbicaciones++;}
					if (tipo.equals("4encabezado")) 
					{
					//	System.out.println("ENCABEZADO");
						obtenerComprobante(cdo, rs);
						enc = true;
					}
			}
			
		}
		catch (Exception e) 
		{
			objRespuesta.setMsjError("Error al llenar info para sellado en BD. "+e.getMessage());
			objRespuesta.setRespuesta(false);
			rsp = false;
		}
	}


	private void validarRegistros(boolean merc, boolean conc, boolean ubi, boolean enc) 
	{
		boolean [] arrayRepsuesta =  {merc,conc,ubi,enc};
		String [] descripcion = {"Mercancias","Conceptos","Ubicaciones","Encabezado"};
		for (int i = 0; i < arrayRepsuesta.length; i++) 
		{
			if (!arrayRepsuesta[i])
			{
				objRespuesta.setRespuesta(false);
				objRespuesta.setMsjError("No se ecnontraron registros en la seccion: "+descripcion[i]);
				System.out.println("No se encontraron registros en la seccion: "+descripcion[i]);
			}
		}
	}


	private Comprobante33R obtenerComprobante(String cdo, ResultSet rs) 
	{
		try
		{
			ConceptoR[] conceptos = new ConceptoR[lstConceptos.size()];
			conceptos = llenarArrayConceptos(conceptos);
			obtenerCredenciales(cdo, rs);
			
			referenciaCartaPorte = valor("serie",rs)+"."+valor("folio", rs);

			serie = valor("serie",rs);
		    folio = Integer.parseInt(valor("folio", rs));
			
		    
			comprobante33r.setCartaPorte20(obtenerCartaPorte(rs));
			
			comprobante33r.setClaveCFDI(valor("tipo_documento", rs));
			
			comprobante33r.setConceptos(conceptos);
			
			comprobante33r.setEmisor(obtenerEmisor(rs));
			
			String exp_codPostal = valor("exp_codigo_postal",rs);
			if(exp_codPostal.length() < 5) {
				exp_codPostal = ("0"+exp_codPostal);
			}
			
			comprobante33r.setLugarExpedicion(exp_codPostal);
			//System.out.println("Lugar Expedicion: "+comprobante33r.getLugarExpedicion());
			comprobante33r.setMoneda(valor("moneda", rs));
			
			comprobante33r.setReceptor(obtenerReceptor(rs));
			
			comprobante33r.setReferencia(referenciaCartaPorte);
			
			/** DATOS EN CEROS **/
     		//comprobante33r.setSubTotal(new BigDecimal(valor("subtotal", rs)));
	
			//comprobante33r.setTotal(new BigDecimal(valor("total", rs)));
			
			comprobante33r.setSubTotal(new BigDecimal("0"));
			
			comprobante33r.setTotal(new BigDecimal("0"));
			
			comprobante33r.setSerie(valor("serie",rs));
			
			comprobante33r.setFolio(valor("folio",rs));

			/* Se omite */
			//comprobante33r.setFecha(obtenerFecha(valor("fecha", rs)));
	
		}
		catch (Exception e) 
		{
			objRespuesta.setMsjError("Error al obtener comprobante. ERROR: "+e.getMessage());
			objRespuesta.setRespuesta(false);
		}
		
		return comprobante33r;
	}

	private ConceptoR[] llenarArrayConceptos(ConceptoR[] conceptos) 
	{
		try
		{
		
		for (int i = 0; i < lstConceptos.size(); i++) 
		{
			conceptos[i] = new ConceptoR(
					lstConceptos.get(i).getCantidad(),
					lstConceptos.get(i).getClaveProdServ(), 
					lstConceptos.get(i).getClaveUnidad(),
					lstConceptos.get(i).getCuentaPredial(),
					lstConceptos.get(i).getDescripcion(),
					lstConceptos.get(i).getDescuento(),
					lstConceptos.get(i).getImporte(),
					lstConceptos.get(i).getImpuestos(),
					lstConceptos.get(i).getInformacionAduanera(),
					lstConceptos.get(i).getInstEducativas(),
					lstConceptos.get(i).getNoIdentificacion(),
					lstConceptos.get(i).getPartes(),
					lstConceptos.get(i).getPorCuentadeTerceros(),
					lstConceptos.get(i).getUnidad(),
					lstConceptos.get(i).getValorUnitario(),
					lstConceptos.get(i).getVentaVehiculos());
//			System.out.println(conceptos[i]);
		}
		
		}
		catch (Exception e) 
		{
			objRespuesta.setMsjError("Error al llenar array conceptos. ERROR: "+e.getMessage());
			objRespuesta.setRespuesta(false);
		}
		return conceptos;
	}


	private String valor(String campo, ResultSet rs) 
	{
		String valor = null;
		try
		{
			valor = rs.getString(campo);
		}
		catch (Exception e) 
		{
			objRespuesta.setMsjError("Error al obtener campo: "+campo+". ERROR: "+e.getMessage());
			objRespuesta.setRespuesta(false);
		}
		return valor;
	}


	private void  obtenerConceptos(ResultSet rs, int idConceptos) 
	{
		try
		{
			/*
			 *  BigDecimal cantidad, 
			 *  String claveProdServ, 
			 *  String claveUnidad,
			 *  CuentaPredialR cuentaPredial, 
			 *  String descripcion, 
			 *  BigDecimal descuento, 
			 *  BigDecimal importe,
			 *  ImpuestosConceptoR impuestos,
			 *  InformacionAduaneraR[] informacionAduanera, 
			 *  InstEducativasR instEducativas,
			 *  String noIdentificacion, 
			 *  ParteR[] partes,
			 *  PorCuentadeTerceros11R porCuentadeTerceros, 
			 *  String unidad, 
			 *  BigDecimal valorUnitario,
			 *  VentaVehiculosR ventaVehiculos
			 */

			lstConceptos.add(new ConceptoR(
					new BigDecimal(valor("CantSurtida", rs)),
					valor("claveProdServ", rs),
					valor("ClaveUnidad", rs),
					null,
					valor("descripcion", rs),
					null,
					new BigDecimal("0"),
					null,
					// ObtenerImpuestos(rs),
					null,
					null,
					valor("numArt", rs),
					null,
					null,
					valor("ClaveUnidad", rs),
					new BigDecimal("0"),
					null));
			Conceptos c = new Conceptos();
			c.setAplicaicon(valor("aplicacion", rs));
			c.setC_ClaveProdServ(valor("claveProdServ", rs));
			c.setC_ClaveUnidad(valor("ClaveUnidad", rs));
			c.setCantidad(valor("CantSurtida", rs));
			c.setNum_renglon(valor("renglon", rs));
			c.setDesc_unidad(valor("desc_unidad", rs));
			c.setNoidentificacion(valor("noidentificacion", rs));
			c.setDescripcion(valor("descripcion", rs));
			c.setValorunitario(valor("valorUnitario", rs));
			c.setFactura(valor("factura", rs));
			c.setOde(valor("ode_conceptos", rs));
			c.setGrupo(valor("grupo", rs));
			c.setImporte(valor("importe", rs));
			c.setProveedor(valor("proveedor", rs));
			// System.out.println("c.setC_ClaveProdServ: " + c.getC_ClaveProdServ());
			lstConceptosXML.add(c);
			
		}
		catch (Exception e) 
		{
			objRespuesta.setMsjError("Error al obtener conceptos. ERROR: "+e.getMessage());
			objRespuesta.setRespuesta(false);
		}
		
		
	}

	private EmisorR obtenerEmisor(ResultSet rs) 
	{
		try
		{
			emisor.setNombre(valor("nombre_fiscal", rs));
			emisor.setRegimenFiscal(valor("regimen_fiscal", rs));
		
		}
		catch (Exception e) 
		{
			objRespuesta.setMsjError("Error al obtener Emisor. ERROR: "+e.getMessage());
			objRespuesta.setRespuesta(false);
		}
		
		return emisor;
	}

	private CartaPorte20R obtenerCartaPorte(ResultSet rs) 
	{
	 	CartaPorte20R cartaPorte20 = new CartaPorte20R();

		try
		{		 
			CartaPorteUbicacion20R[] ubicaciones = new CartaPorteUbicacion20R[lstUbicacion.size()];
			ubicaciones = llenarArrayUbicaciones(ubicaciones);
			
			cartaPorte20.setFiguraTransporte(obtenerFiguraTransporte(rs));
			
			cartaPorte20.setMercancias(obtenerMercancias(rs));
			
			cartaPorte20.setTotalDistRec(totalDistanciaRecorrida);
			
			cartaPorte20.setTranspInternac(valor("transporte_internacional", rs));
			//cartaPorte20.setTranspInternac("N");
			
			cartaPorte20.setUbicaciones(ubicaciones);

		}
		catch (Exception e) 
		{
			System.out.println("Error al obtener ubicaciones. ERROR: "+e);
			objRespuesta.setMsjError("Error al obtener ubicaciones. ERROR: "+e.getMessage());
			objRespuesta.setRespuesta(false);
		}
		
		return cartaPorte20;
	}

	private CartaPorteUbicacion20R[] llenarArrayUbicaciones(CartaPorteUbicacion20R[] ubicaciones) {
		try {
         
			for (int i = 0; i < lstUbicacion.size(); i++) {

	 /*
	  * CartaPorteUbicacion20R(BigDecimal distanciaRecorrida, 
	  * CartaPorteUbicacionDomicilio20R domicilio,
	  * String fechaHoraSalidaLlegada,
	  * String IDUbicacion,
	  * String navegacionTrafico,
	  * String nombreEstacion, 
	  * String nombreRemitenteDestinatario,
	  * String numEstacion,
	  * String numRegIdTrib, 
      * String RFCRemitenteDestinatario,
      * String residenciaFiscal, 
      * String tipoEstacion, String tipoUbicacion)
	  */
	   				ubicaciones[i] = new CartaPorteUbicacion20R(
							lstUbicacion.get(i).getDistanciaRecorrida(),
							lstUbicacion.get(i).getDomicilio(),
							lstUbicacion.get(i).getFechaHoraSalidaLlegada(),
							lstUbicacion.get(i).getIDUbicacion(),
							lstUbicacion.get(i).getNavegacionTrafico(), /* navegacionTrafico */
							lstUbicacion.get(i).getNombreEstacion(), /* nombreEstacion */
							lstUbicacion.get(i).getNombreRemitenteDestinatario(), /* nombreRemitenteDestinatario */
							lstUbicacion.get(i).getNumEstacion(),
							lstUbicacion.get(i).getNumRegIdTrib(),
							lstUbicacion.get(i).getRFCRemitenteDestinatario(),
							lstUbicacion.get(i).getResidenciaFiscal(),
							lstUbicacion.get(i).getTipoEstacion(),
							lstUbicacion.get(i).getTipoUbicacion()
							);

			}
		} catch (Exception e) {
			objRespuesta.setMsjError("Error al llenar array ubicaciones. ERROR: " + e.getMessage());
			objRespuesta.setRespuesta(false);
		}
		return ubicaciones;
	}


	private CartaPorteMercancias20R obtenerMercancias(ResultSet rs) 
	
	{
		CartaPorteMercanciasMercancia20R[] cartaMercanciaArray = new  CartaPorteMercanciasMercancia20R[lstMercancias.size()] ;
		 
		cartaMercanciaArray = llenarArrayMercancias(cartaMercanciaArray);
			
		CartaPorteMercancias20R cartaMercancias = new CartaPorteMercancias20R();
		
		cartaMercancias.setAutotransporte(obtenrCartaAutoTransporte(rs));
		
		cartaMercancias.setMercancia(cartaMercanciaArray);
		
		cartaMercancias.setNumTotalMercancias(totalMercancias);
		
		cartaMercancias.setPesoBrutoTotal(pesoBrutoTotal);
		cartaMercancias.setUnidadPeso("KGM");
		
		  // System.out.println("tPeso Bruto Total: " + pesoBrutoTotal);
		 //  System.out.println("tPeso Bruto Total big decimal: " +new BigDecimal(pesoBrutoTotal));
		// cartaMercancias.setPesoNetoTotal(new BigDecimal(pesoNetoTotal));

		return cartaMercancias;
	}

	private CartaPorteMercanciasMercancia20R[] llenarArrayMercancias(CartaPorteMercanciasMercancia20R[] cartaMercanciaArray)
	{
		try
		{
			for (int i = 0; i < lstMercancias.size(); i++) 
			{
			//	CartaPorteMercanciasMercancia20R merc = new CartaPorteMercanciasMercancia20R();
				
			//	merc.setBienesTransp(lstMercancias.get(i).getBienesTransp());
			//	merc.setCantidad(lstMercancias.get(i).getCantidad());		
			//	merc.setCantidadTransporta(lstMercancias.get(i).getCantidadTransporta());
			//	merc.setDetalleMercancia(lstMercancias.get(i).getDetalleMercancia());
				
			//	System.out.println("Mercancias.BienesTransp: "+lstMercancias.get(i).getBienesTransp()  + ". Mercancia.tDescripcion: "+  lstMercancias.get(i).getDescripcion() + ". MercanciasMaterialPeligroso: " + lstMercancias.get(i).getMaterialPeligroso() + " - " + "Mercancias.CveMaterialPeligroso: " + lstMercancias.get(i).getCveMaterialPeligroso() );
	 
				
				cartaMercanciaArray[i] = new CartaPorteMercanciasMercancia20R(
				lstMercancias.get(i).getBienesTransp(), lstMercancias.get(i).getCantidad(), lstMercancias.get(i).getCantidadTransporta(), 
				lstMercancias.get(i).getClaveSTCC(), lstMercancias.get(i).getClaveUnidad(),lstMercancias.get(i).getCveMaterialPeligroso(), 
				lstMercancias.get(i).getDescripEmbalaje(), lstMercancias.get(i).getDescripcion(), lstMercancias.get(i).getDetalleMercancia(), 
				lstMercancias.get(i).getDimensiones(), lstMercancias.get(i).getEmbalaje(), lstMercancias.get(i).getFraccionArancelaria(), 
				lstMercancias.get(i).getGuiasIdentificacion(), lstMercancias.get(i).getMaterialPeligroso(), lstMercancias.get(i).getMoneda(), 
				lstMercancias.get(i).getPedimentos(), lstMercancias.get(i).getPesoEnKg(),lstMercancias.get(i).getUUIDComercioExt(), 
				lstMercancias.get(i).getUnidad(), lstMercancias.get(i).getValorMercancia()); 
			}
		}
		catch (Exception e) 
		{
			objRespuesta.setMsjError("Error al llenar array mercancias. ERROR: "+e.getMessage());
			objRespuesta.setRespuesta(false);
		}
		return cartaMercanciaArray;
	}


	private void obtenerCartaMercanciaArray(ResultSet rs, int idMercancias)
	{
		try
		{
			lstMercancias.add(obtenerCartaMercancia(valor("idDestino_mercancia", rs),valor("idOrigen_mercancia", rs),rs,idMercancias));
			 totalMercancias++;
			//  totalMercancias = totalMercancias+ Integer.parseInt(valor("cantidad_mercancia", rs));
		}
		catch (Exception e) 
		{
			objRespuesta.setMsjError("Error al obtener mercancias. ERROR: "+e.getMessage());
			objRespuesta.setRespuesta(false);
		}
	
	}

	private CartaPorteMercanciasMercancia20R obtenerCartaMercancia(String destino, String origen, ResultSet rs, int idMercancias) 
	{
		
		CartaPorteMercanciasMercancia20R cartaMercancia = new CartaPorteMercanciasMercancia20R();
		try
		{

			cartaMercancia.setBienesTransp(valor("c_ClaveProdServ_mercancia", rs));
            cartaMercancia.setCantidad(new BigDecimal(valor("cantidad_mercancia", rs)));
            cartaMercancia.setClaveUnidad(valor("c_ClaveUnidad_mercancia", rs));
			cartaMercancia.setDescripcion(valor("descripcion_mercancia", rs));
			cartaMercancia.setMoneda("MXN");
			/*
			double pesoKg = Integer.parseInt(valor("peso_bruto_mercancia", rs));
			if(pesoKg == 0) {
				pesoKg = 0.1;
			}*/
			//cartaMercancia.setPesoEnKg(new BigDecimal(pesoKg));
			cartaMercancia.setPesoEnKg(new BigDecimal(valor("peso_bruto_mercancia", rs)));
			//System.out.println("Peso en Kg: "+cartaMercancia.getPesoEnKg());
			//cartaMercancia.setPesoEnKg(new BigDecimal(pesoBrutoMercancia));
			cartaMercancia.setUnidad("KGM"); 
			cartaMercancia.setValorMercancia(new BigDecimal(valorMercancia));
			
			 String MaterialPeligroso = valor("es_material_Peligroso", rs).trim();
			// System.out.println("Materia peligroso: " + MaterialPeligroso);
			//String MaterialPeligroso = "0";
			// cartaMercancia.setMaterialPeligroso("");	
			// cartaMercancia.setCveMaterialPeligroso("" );
			// cartaMercancia.setEmbalaje("");
			
			 if(!MaterialPeligroso.equalsIgnoreCase("0"))
			{
				MaterialPeligroso = "Sí";
				cartaMercancia.setMaterialPeligroso(MaterialPeligroso);	
				cartaMercancia.setCveMaterialPeligroso(valor("cve_material_peligroso", rs) );
				cartaMercancia.setEmbalaje("4A");
				
				/*System.out.println("Obtiene Material Peligroso:1 " + cartaMercancia.getMaterialPeligroso());
				System.out.println("Obtiene CveMaterialPeligroso:1 "+cartaMercancia.getCveMaterialPeligroso());
				System.out.println("Obtiene el embalaje:1  "+cartaMercancia.getEmbalaje());*/
			}/*else {
				cartaMercancia.setMaterialPeligroso(null);	
				cartaMercancia.setCveMaterialPeligroso(null);
				cartaMercancia.setEmbalaje(null);
				System.out.println("Obtiene Material Peligroso:2 " + cartaMercancia.getMaterialPeligroso());
				System.out.println("Obtiene CveMaterialPeligroso:2 "+cartaMercancia.getCveMaterialPeligroso());
				System.out.println("Obtiene el embalaje:2  "+cartaMercancia.getEmbalaje());
			}*/
			

			
			pesoBrutoTotal = pesoBrutoTotal.add(new BigDecimal(valor("peso_bruto_mercancia", rs)));
            //System.out.println("Peso Mercancia: " + pesoBrutoTotal);
		}
		catch (Exception e) 
		{
			System.out.println("Error al llenar carta mercancia. ERROR: "+e);
			objRespuesta.setMsjError("Error al llenar carta mercancia. ERROR: "+e);
			objRespuesta.setRespuesta(false);
		}

		return cartaMercancia;
		
	}
         	
	@SuppressWarnings("unused")
	private CartaPorteMercanciasMercanciaDetalleMercancia20R GeneraDetalleMercancia(ResultSet rs) {
		CartaPorteMercanciasMercanciaDetalleMercancia20R detalleMerc = new CartaPorteMercanciasMercanciaDetalleMercancia20R();
		try
		{

			detalleMerc.setNumPiezas( Integer.parseInt(valor("cantidad_mercancia", rs))  );

			detalleMerc.setPesoBruto( new BigDecimal(valor("peso_bruto_mercancia", rs)) );

			detalleMerc.setPesoNeto( new BigDecimal(valor("peso_neto_mercancia", rs)) );

			detalleMerc.setPesoTara( new BigDecimal(valor("peso_tara_mercancia", rs)) );

			detalleMerc.setUnidadPesoMerc("KGM");
			
			valorMercancia = valorMercancia +  Double.parseDouble(valor("importe_mercancia", rs)) ;

			pesoNetoTotal = pesoNetoTotal + Double.parseDouble(valor("peso_neto_mercancia", rs));

		}
		catch (Exception e) {
			System.out.println("Error al llenar Detalle Mercancia. ERROR: "+e);
			objRespuesta.setMsjError("Error al Detalle Mercancia. ERROR: "+e);
			objRespuesta.setRespuesta(false);
		}
		return detalleMerc;
	}



            
	private CartaPorteMercanciasAutotransporte20R obtenrCartaAutoTransporte(ResultSet rs) 
	{
		CartaPorteMercanciasAutotransporte20R cartaAutoTransporte = new CartaPorteMercanciasAutotransporte20R();
		//CartaPorteMercanciasMercancia20R cartaMercancia = new CartaPorteMercanciasMercancia20R();
		try
		{ 
			cartaAutoTransporte.setIdentificacionVehicular(obtenerIdentificacionVehicular(rs));
			cartaAutoTransporte.setNumPermisoSCT(valor("numero_permisoSCT", rs));
			cartaAutoTransporte.setPermSCT(valor("tipo_permisoSCT", rs));
			cartaAutoTransporte.setSeguros( obtenerSerugo(rs) );
			
		}
		catch (Exception e) 
		{
			objRespuesta.setMsjError("Error al obtener carta auto transporte. ERROR: "+e.getMessage());
			objRespuesta.setRespuesta(false);
		}

		return cartaAutoTransporte;
	}

         	
	private CartaPorteMercanciasAutotransporteSeguros20R obtenerSerugo(ResultSet rs) {
		CartaPorteMercanciasAutotransporteSeguros20R seguro = new CartaPorteMercanciasAutotransporteSeguros20R();
		//CartaPorteMercanciasMercancia20R cartaMercancia = new CartaPorteMercanciasMercancia20R();
		try {
			seguro.setAseguraRespCivil(valor("nombre_aseguradora", rs));
			seguro.setPolizaRespCivil(valor("numero_poliza", rs));
			//System.out.println("Nombre de la aseguradora: "+seguro.getAseguraRespCivil());
			//System.out.println("Numero de poliza: "+seguro.getPolizaRespCivil());
			//seguro.setAseguraRespCivil("QUALITAS");
			//seguro.setPolizaRespCivil("3190353801");
			/*Opcionales?*/
			
			String materialPeligro = String.valueOf(valor("es_material_Peligroso",rs).trim());
			//System.out.println("material Peligroso 100: " + materialPeligro);
			if(!materialPeligro.equals("0")) {	
				seguro.setAseguraMedAmbiente("Olimpo S.A. de C.V.");
				seguro.setPolizaMedAmbiente("987423");
			}
			      
				//seguro.setAseguraMedAmbiente("Olimpo S.A. de C.V.");
				//System.out.println("AseguraMedAmbiente: " + seguro.getAseguraMedAmbiente());
				seguro.setPolizaCarga("368549");
			
				seguro.setPolizaRespCivil("06292021");
				
				seguro.setPrimaSeguro(new BigDecimal("1200.00"));
			
			
			
			}
	catch (Exception e) 
	{
		objRespuesta.setMsjError("Error al obtener carta auto transporte Seguro. ERROR: "+e.getMessage());
		objRespuesta.setRespuesta(false);
	}
		return seguro;
	}




	private CartaPorteMercanciasAutotransporteIdentificacionVehicular20R obtenerIdentificacionVehicular(ResultSet rs) 
	{
		CartaPorteMercanciasAutotransporteIdentificacionVehicular20R identificacionVehicular= new CartaPorteMercanciasAutotransporteIdentificacionVehicular20R();
		
		try
		{
			identificacionVehicular.setAnioModeloVM(Integer.parseInt(valor("anio", rs)));
			identificacionVehicular.setConfigVehicular(valor("config_vehicular", rs));
			identificacionVehicular.setPlacaVM(valor("placas_vehiculo", rs).replace("-",""));
		}
		catch (Exception e) 
		{
			objRespuesta.setMsjError("Error al obtener identificacion vehicular. ERROR: "+e.getMessage());
			objRespuesta.setRespuesta(false);
		}

		return identificacionVehicular;
	}

	
        
	private CartaPorteTiposFigura20R[] obtenerFiguraTransporte(ResultSet rs) 
	{
		CartaPorteTiposFigura20R[] figuraTransporte = new CartaPorteTiposFigura20R[1];
		try
		{
			figuraTransporte[0] = new CartaPorteTiposFigura20R(
					null, 
					valor("nombre_operador", rs), 
					valor("numero_licencia", rs), 
					null, 
					null, 
					valor("rfc_operador", rs), 
					null, 
					"01") ;
		}
		catch(Exception ex)
		{
			System.out.println("Error al Obtener figuraTransporte: " + ex);	
			objRespuesta.setMsjError("Error al Obtener figuraTransporte: "+ex.getMessage());
			objRespuesta.setRespuesta(false);
		}
		return figuraTransporte;
	}
            
	private void obtenerUbicaciones(ResultSet rs, int idUbicaciones) {

		try {

			CartaPorteUbicacion20R ubicacion20r = new CartaPorteUbicacion20R();

			if (valor("orden", rs).equalsIgnoreCase("0")) {
				/* Oirgen */
				//System.out.println("Entra a orden igual a 0");
				ubicacion20r.setDomicilio(obtenerDomicilio(rs));
				ubicacion20r.setFechaHoraSalidaLlegada(valor("fecha_aprox_llegada", rs));
				ubicacion20r.setIDUbicacion(valor("idOrigen", rs));

				// el de pruebas para pruebas n.setRFCRemitenteDestinatario( valor("rfc", rs) );
				ubicacion20r.setRFCRemitenteDestinatario(valor("rfc_cliente", rs).trim());
				ubicacion20r.setTipoUbicacion("Origen");
			} else {
				/* Destino */
				//System.out.println("Entra a orden diferente a 0");
				ubicacion20r.setDistanciaRecorrida(new BigDecimal(valor("distanciaRecorrida", rs)));
				ubicacion20r.setDomicilio(obtenerDomicilio(rs));
				ubicacion20r.setFechaHoraSalidaLlegada(valor("fecha_aprox_llegada", rs));
				ubicacion20r.setIDUbicacion(valor("idDestino", rs));

				// el de pruebas para pruebas n.setRFCRemitenteDestinatario( valor("rfc", rs) );
				ubicacion20r.setRFCRemitenteDestinatario(valor("rfc_cliente", rs).trim());
				ubicacion20r.setTipoUbicacion("Destino");
			}

			lstUbicacion.add(ubicacion20r);

		
			totalDistanciaRecorrida = totalDistanciaRecorrida.add(new BigDecimal(valor("distanciaRecorrida", rs)));
			//System.out.println("totalDistanciaRecorrida: " + totalDistanciaRecorrida);
		} catch (Exception e) {
			objRespuesta.setMsjError("Error al obtener ubicaciones. ERROR: " + e.getMessage());
			objRespuesta.setRespuesta(false);
		}

	}

	private ReceptorR obtenerReceptor(ResultSet rs) 
	{
		try
		{
		receptor.setRfc(valor("generico", rs));
		receptor.setUsoCFDI(valor("uso_cfdi", rs));
		receptor.setNombre(valor("nombre_operador", rs));
		}
		catch (Exception e) 
		{
			objRespuesta.setMsjError("Error al obtener receptor. ERROR: "+e.getMessage());
			objRespuesta.setRespuesta(false);		}
		return receptor;
	}

	private CartaPorteUbicacionDomicilio20R obtenerDomicilio(ResultSet rs) 
	{
		CartaPorteUbicacionDomicilio20R cartaDomicilio = new CartaPorteUbicacionDomicilio20R();
		try
		{
			cartaDomicilio.setCalle(valor("calle_ubicaciones", rs));
			cartaDomicilio.setCodigoPostal(valor("codigo_postal", rs));
			cartaDomicilio.setColonia(valor("colonia", rs));
			cartaDomicilio.setEstado(valor("estado", rs));
			//cartaDomicilio.setLocalidad(valor("localidad", rs));
			cartaDomicilio.setMunicipio(valor("municipio", rs));
			cartaDomicilio.setPais("MEX");
		}
		catch (Exception e) 
		{
			objRespuesta.setMsjError("Error al obtener domicilio. ERROR: "+e.getMessage());
			objRespuesta.setRespuesta(false);
		}

		return cartaDomicilio;
	}

	private Credenciales obtenerCredenciales(String cdo, ResultSet rs) 
	{
		try
		{
			credenciales.setCuenta(valor("cuenta", rs));
			credenciales.setPassword(valor("password",rs));
			credenciales.setUsuario(valor("usuario", rs));
		}
		catch (Exception e) 
		{
			log.Insrtalog(cdo, serie, folio, "Error al obtener credenciales. ERROR: "+e.getMessage() );
			objRespuesta.setMsjError("Error al obtener credenciales. ERROR: "+e.getMessage());
			objRespuesta.setRespuesta(false);
		}
		return credenciales;
	}
	
	private void imprimirMensajesDeRespuesta(String cdo,RespuestaOperacionCR respuesta) 
	{
		//System.out.println("Codigo de Operacion Existosa en ImprimiMensajeRespuesta: "+respuesta.getOperacionExitosa());
		/*System.out.println("Codigo de Error General: "+respuesta.getErrorGeneral());
		System.out.println("Codigo de Error Detallado: "+respuesta.getErrorDetallado());
		System.out.println("Codigo de Folio Generado: "+respuesta.getFolioGenerado());
		System.out.println("Codigo de Folio Generado: "+respuesta.getFolioGenerado());
		System.out.println("Codigo de confrimacion: "+respuesta.getCodigoConfirmacion());
		System.out.println("Codigo de Error General: "+respuesta.getErrorGeneral());
		System.out.println("Codigo de Error Detallado: "+respuesta.getErrorDetallado());
		*/
		
		
		if (respuesta.getOperacionExitosa()) 
		{	
			objRespuesta.setCodigoXML(respuesta.getXML());
			objRespuesta.setRespuesta(respuesta.getOperacionExitosa());
			objRespuesta.setCodigoCBB(respuesta.getCBB());	
			
			//System.out.println("Codigo de CBB: "+respuesta.getCBB().length());
			//System.out.println("Codigo de Addenda: "+respuesta.getAddenda());
		    // System.out.println("Codigo de PDF: "+respuesta.getPDF());
		    //System.out.println("Codigo de XML: "+respuesta.getXML().length());
		}
		else
		{
			objRespuesta.setConceptos(null);
			objRespuesta.setRespuesta(respuesta.getOperacionExitosa());
			objRespuesta.setMsjError("ERROR GENERAL: "+respuesta.getErrorGeneral().toString()+". DETALLADO: "+ respuesta.getErrorDetallado());
			//System.out.println("ERROR GENERAL: "+respuesta.getErrorGeneral()+". DETALLADO: "+ respuesta.getErrorDetallado());
			log.Insrtalog(cdo, serie, folio, "ERROR GENERAL:" +respuesta.getErrorGeneral().toString() + ". DETALLADO: "+ respuesta.getErrorDetallado() );
		}
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static String[] inicializacionQrys(String[] querys, List<Querys> ListaQuerys, String cdo, int noQry, String uname_br, String trayecto) 
	{
		querys = Cls_Querys.LimpiaListaQuerys(querys);
        querys = ObtieneQuerys(noQry, (List)ListaQuerys, querys, cdo,uname_br,trayecto);
    	return querys;
	}
	
	public static String[] ObtieneQuerys(int noQuery, List<Querys> ListaTodosQuerys, String[] ListaQuerys,  String cdo, String uname_br, String trayecto)
	{
		String[] querys = ListaQuerys;
		int cont = 0;
		String qry="";
		
		for(int item = 0; item < ListaTodosQuerys.size(); item++)
		{
			if(ListaTodosQuerys.get(item).getIndice_query() == noQuery)
			{
				qry= ListaTodosQuerys.get(item).getQuery().toString();
				qry= qry.replace("{CDO}",cdo.toUpperCase());
				qry= qry.replace("{UNAME_BR}",uname_br.toLowerCase());
				qry= qry.replace("{ID_TRAYECTO}",trayecto);
				querys[cont] = qry;
				cont++;
			}
		}
		return querys;
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
					}
				}
				catch (Exception e) 
				{
					//System.err.println("Error: "+e.getMessage()+".NODO: "+nodo+". CAMPO: "+campo);
				}
			}
			else
			{
				return String.valueOf(nList.getLength());
			}
		}
		catch (Exception e) 
		{
			//System.out.println("Error al obtener datos XML. NODO: "+nodo+". CAMPO: "+campo+". ERROR: "+e.getMessage().toString());
		}
	}
		return valor;
	}
}
