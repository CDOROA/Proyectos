//package cdo.Persistencia;
//
//import java.io.StringReader;
//import java.math.BigDecimal;
//import java.rmi.RemoteException;
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.Calendar;
//import java.util.Iterator;
//import java.util.List;
//
//import javax.xml.parsers.DocumentBuilderFactory;
//
//import org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.CartaPorte20R;
//
//import org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.CartaPorteMercancias20R;
//import org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.CartaPorteMercanciasAutotransporte20R;
//
//import org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.CartaPorteMercanciasAutotransporteIdentificacionVehicular20R;
//import org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.CartaPorteMercanciasAutotransporteSeguros20R;
//import org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.CartaPorteMercanciasMercancia20R;
//import org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.CartaPorteMercanciasMercanciaCantidadTransporta20R;
//
//import org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.CartaPorteMercanciasMercanciaDetalleMercancia20R;
//
//import org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.CartaPorteTiposFigura20R;
//import org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.CartaPorteTiposFiguraDomicilio20R;
//import org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.CartaPorteTiposFiguraPartesTransporte20R;
//import org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.CartaPorteUbicacion20R;
//
//import org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.CartaPorteUbicacionDomicilio20R;
//
//import org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.Comprobante33R;
//import org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.ConceptoR;
//import org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.Credenciales;
//import org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.EmisorR;
//import org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.ImpuestosConceptoR;
//import org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.ReceptorR;
//import org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RespuestaOperacionCR;
//import org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RetencionConceptoR;
//import org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RetencionLocalR;
//import org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.TrasladoConceptoR;
//import org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.TrasladoLocalR;
//import org.tempuri.ConexionRemotaLocator;
//import org.tempuri.IConexionRemota;
//import org.w3c.dom.Document;
//import org.w3c.dom.Element;
//import org.w3c.dom.Node;
//import org.w3c.dom.NodeList;
//import org.xml.sax.InputSource;
//
//import cdo.Entidades.Conceptos;
//import cdo.Entidades.EjecutaQuerysBD;
//import cdo.Entidades.Querys;
//import cdo.Entidades.Respuesta;
//import cdo.Util.Cls_Querys;
//import cdo.Util.ConexionBD;
//
//public class GestorSelladoDatosPruebas 
//{
//	
//	private Comprobante33R comprobante33r = null;
//	private Respuesta objRespuesta = new Respuesta();
//	private boolean rsp = false;
//
//	EmisorR emisor = new EmisorR();
//	ReceptorR receptor = new ReceptorR();
//	Credenciales credenciales = new Credenciales("","","");
//	List<ConceptoR> lstConceptos = new ArrayList<>();
//	List<Conceptos> lstConceptosXML = new ArrayList<>();
//	List<CartaPorteUbicacion20R> lstUbicacion = new ArrayList<>();
//	List<CartaPorteMercanciasMercancia20R> lstMercancias = new ArrayList<>();
//    	 
//	private static boolean merc=false,conc = false,ubi = false,enc = false;
//	private static String folio = ""; 
//	int totalDistanciaRecorrida = 0, totalMercancias = 0;
//	Double pesoBrutoTotal = 0.00; 
//	Double pesoNetoTotal = 0.00;
//	Double valorMercancia  = 0.00;
//	String referenciaCartaPorte = "";
//	
//	public Respuesta Sellado(String cdo, String uname_br,String trayecto, List<Querys> listaQuerys) 
//	{
//		objRespuesta.setRespuesta(true);
//		obtenerInformacionParaSellado(cdo,uname_br,trayecto,listaQuerys);
//		try
//		{
//			if (objRespuesta.isRespuesta())
//			{
//				ConexionRemotaLocator conector=new ConexionRemotaLocator();
//				IConexionRemota iconexion = conector.getsoapHttpEndpoint();
//				RespuestaOperacionCR respuesta = new RespuestaOperacionCR();
//				System.out.println("referenciaCartaPorte: " + referenciaCartaPorte);
//				
//				
//				objRespuesta.setConceptos(lstConceptosXML);
//			
//				recuperaCartaPorte(iconexion, credenciales, referenciaCartaPorte, cdo);
//				System.out.println("objRespuesta: " + objRespuesta.isRespuesta());	
//				if (!objRespuesta.isRespuesta())
//				{
//					System.out.println("sellando...");
//					respuesta = iconexion.generarCFDI(credenciales,comprobante33r);
//					
//					imprimirMensajesDeRespuesta(respuesta);
//					if (!objRespuesta.isRespuesta())
//					{
//					RecuperaPDF(iconexion, credenciales, cdo);
//					}
//				}
//
//			}
//		}
//		catch (Exception e) 
//		{
//			objRespuesta.setMsjError("Error en metodo principal sellado. ERROR: "+e.getMessage());
//			objRespuesta.setRespuesta(false);
//		}
//		return objRespuesta;
//	}
//
//	
//	
//	
//	
//	private void recuperaCartaPorte(IConexionRemota iconexion, Credenciales credenciales2,
//			String referenciaCartaPorte2, String cdo ) {
//		 try {
//			RespuestaOperacionCR respuesta = iconexion.obtenerXMLPorReferencia(credenciales, referenciaCartaPorte);
//			System.out.println("respuesta: " + respuesta.getOperacionExitosa());
//			System.out.println("respuesta.getErrorGeneral  : " + respuesta.getErrorGeneral());
//			System.out.println("respuesta.getErrorDetallado: " + respuesta.getErrorDetallado());
//			imprimirMensajesDeRespuesta(respuesta);
//			
//			if (respuesta.getOperacionExitosa())
//			{
//				RecuperaPDF(iconexion, credenciales2, cdo);
//			
//			}
//
//		} catch (RemoteException e) {
//			System.out.println("Error al recuperar la carta porte: " + e);
//			objRespuesta.setMsjError("Error en metodo recuperaCartaPorte. ERROR: "+e.getMessage());
//			objRespuesta.setRespuesta(false);
//		}
//		
//	}
//
//
//
//
//	private void RecuperaPDF(IConexionRemota iconexion, Credenciales credenciales2, String cdo) throws RemoteException {
//		try {
//			RespuestaOperacionCR respuesta;
//			String uuid = obtenerValor("tfd:TimbreFiscalDigital", "UUID","0"); 
//			System.out.println("UUID: " + uuid);
//			respuesta = iconexion.obtenerPDF(credenciales2, uuid, cdo);
//			objRespuesta.setCodigoPDF(respuesta.getPDF());
//		}
//		catch (Exception e) { 
//			System.out.println("Error al  recuperar el PDF: " + e);
//		}
//	}
//
//
//
//
//	private void obtenerInformacionParaSellado(String cdo, String uname_br, String trayecto, List<Querys> ListaQuerys) 
//	{
//		try
//		{
//			Connection connBD = null;
//	        PreparedStatement pstmt = null;
//	        ResultSet rs = null;
//	        try
//	        {
//	        	String[] querys = new String[25];
//	        	connBD = ConexionBD.AbrirConexionBDD(cdo);
//	        	querys = inicializacionQrys(querys, ListaQuerys, cdo, 3,uname_br,trayecto);
//
//	            pstmt = connBD.prepareStatement("{call " + cdo.toUpperCase() + ".usp_EXECUTE_QUERY_CP(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
//	            rs = EjecutaQuerysBD.EjecutarQuery(querys[0], querys[1], querys[2], querys[3], querys[4], querys[5], querys[6], querys[7], querys[8], querys[9], querys[10], querys[11], querys[12], querys[13], querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], querys[21], querys[22], querys[23], querys[24], cdo, pstmt, connBD);
//	            
//	            
//	            Cls_Querys.ImprimeQuerysConsola(querys,true, "Recuperando informacion de BD");
//	            
//	            if (rs != null) 
//	            {
//	            	llenarInfoSellado(rs);
//				}
//	            validarRegistros(merc,conc,ubi,enc);
//	            
//	        }
//	        catch (Exception e) 
//	        {
//	        	objRespuesta.setMsjError("Error al obtener informacion pruebas. ERROR: "+e.getMessage());
//				objRespuesta.setRespuesta(false);
//	        	rsp = false;
//			}
//	        finally
//	        {
//				connBD.close();
//				pstmt.close();
//			}
//		}
//		catch (Exception e) 
//		{
//			objRespuesta.setMsjError("Error al llenar insertar en BD XML. ERROR: "+e.getMessage());
//			objRespuesta.setRespuesta(false);
//			rsp = false;
//		}
//	}
//
//	private void llenarInfoSellado(ResultSet rs)
//	{
//		int idConceptos = 0, idUbicaciones = 0, idMercancias = 0;
//
//		try
//		{
//			while (rs.next()) 
//			{
//				String tipo = rs.getString("tipo");
//				if (tipo.equals("1mercancia"))
//						{
//					if (!valor("c_ClaveProdServ_mercancia", rs).equals("80141605")) 
//					{
////						System.out.println("MERCANCIA");
//						obtenerCartaMercanciaArray(rs,idMercancias);
//						merc = true;
//						idMercancias++;
//					}
//						
//				}
//				if (tipo.equals("2conceptos")) {
//						obtenerConceptos(rs,idConceptos);
////						System.out.println("CONCEPTOS");
//						conc = true;
//						idConceptos++;}
//					if (tipo.equals("3ubicaciones")) {
//						// System.out.println("UBICACIOMEs");
//						obtenerUbicaciones(rs,idUbicaciones);
//						
//						ubi = true;
//						idUbicaciones++;}
//					if (tipo.equals("4encabezado")) 
//					{
////						System.out.println("ENCABEZADO");
//						obtenerComprobante(rs);
//						enc = true;
//					}
//			}
//			
//		}
//		catch (Exception e) 
//		{
//			objRespuesta.setMsjError("Error al llenar info para sellado en BD. "+e.getMessage());
//			objRespuesta.setRespuesta(false);
//			rsp = false;
//		}
//	}
//
//
//	private void validarRegistros(boolean merc, boolean conc, boolean ubi, boolean enc) 
//	{
//		boolean [] arrayRepsuesta =  {merc,conc,ubi,enc};
//		String [] descripcion = {"Mercancias","Conceptos","Ubicaciones","Encabezado"};
//		for (int i = 0; i < arrayRepsuesta.length; i++) 
//		{
//			if (!arrayRepsuesta[i])
//			{
//				objRespuesta.setRespuesta(false);
//				objRespuesta.setMsjError("No se ecnontraron registros en la seccion: "+descripcion[i]);
//			}
//		}
//	}
//
//
//	private Comprobante33R obtenerComprobante(ResultSet rs) 
//	{
//		try
//		{
//			
//			comprobante33r =  new Comprobante33R();
//			ConceptoR[] conceptos = new ConceptoR[1];
//			conceptos = llenarArrayConceptos(conceptos);
//			System.out.println("conceptos: "+conceptos);
//			obtenerCredenciales(rs);
//			referenciaCartaPorte = "0001";
//
//			comprobante33r.setCartaPorte20(obtenerCartaPorte(rs));
//			
//			comprobante33r.setClaveCFDI("POR");
//
//			comprobante33r.setConceptos(conceptos);
//			
//			comprobante33r.setEmisor(obtenerEmisor(rs));
//			
//			comprobante33r.setLugarExpedicion("72200");
//
//			comprobante33r.setMoneda("XXX");
//			
//			comprobante33r.setReceptor(obtenerReceptor(rs));
//
//			comprobante33r.setReferencia(referenciaCartaPorte);
//
//     		comprobante33r.setSubTotal(new BigDecimal("0"));
//	
//			comprobante33r.setTotal(new BigDecimal("0"));
//
//			
//		
//
//			//comprobante33r.setSerie(valor("serie",rs));
//			
////			comprobante33r.setFecha(obtenerFecha(valor("fecha", rs)));
//	
//		}
//		catch (Exception e) 
//		{
//			objRespuesta.setMsjError("Error al obtener comprobante. ERROR: "+e.getMessage());
//			objRespuesta.setRespuesta(false);
//		}
//		
//		return comprobante33r;
//	}
//
//	private ConceptoR[] llenarArrayConceptos(ConceptoR[] conceptos) 
//	{
//		try
//		{
//		
//		 
//
//			
//			
//			conceptos[0] = new ConceptoR(
//					new BigDecimal("1.70"),
//					"01010101",
//					"F52",
//					null,
//                    "ZAMAC",
//					null,
//					new BigDecimal("17000.00"),
//					null,
//					// ObtenerImpuestos(rs),
//					null,
//					null,
//					"00003",
//					null,
//					null,
//					"TONELADA",
//					new BigDecimal("10000.00"),
//					null);
////			System.out.println(conceptos[i]);
//	 
//		
//		}
//		catch (Exception e) 
//		{
//			objRespuesta.setMsjError("Error al llenar array conceptos. ERROR: "+e.getMessage());
//			objRespuesta.setRespuesta(false);
//		}
//		return conceptos;
//	}
//
//
//	private String valor(String campo, ResultSet rs) 
//	{
//		String valor = null;
//		try
//		{
//			valor = rs.getString(campo);
//		}
//		catch (Exception e) 
//		{
//			objRespuesta.setMsjError("Error al obtener campo: "+campo+". ERROR: "+e.getMessage());
//			objRespuesta.setRespuesta(false);
//		}
//		return valor;
//	}
//
//
//	private void  obtenerConceptos(ResultSet rs, int idConceptos) 
//	{
//		try
//		{
//			/*
//			 *  BigDecimal cantidad, 
//			 *  String claveProdServ, 
//			 *  String claveUnidad,
//			 *  CuentaPredialR cuentaPredial, 
//			 *  String descripcion, 
//			 *  BigDecimal descuento, 
//			 *  BigDecimal importe,
//			 *  ImpuestosConceptoR impuestos,
//			 *  InformacionAduaneraR[] informacionAduanera, 
//			 *  InstEducativasR instEducativas,
//			 *  String noIdentificacion, 
//			 *  ParteR[] partes,
//			 *  PorCuentadeTerceros11R porCuentadeTerceros, 
//			 *  String unidad, 
//			 *  BigDecimal valorUnitario,
//			 *  VentaVehiculosR ventaVehiculos
//			 */
//
//			lstConceptos.add(new ConceptoR(
//					new BigDecimal("1.70"),
//					"01010101",
//					"F52",
//					null,
//                    "ZAMAC",
//					null,
//					new BigDecimal("17000.00"),
//					null,
//					// ObtenerImpuestos(rs),
//					null,
//					null,
//					"00003",
//					null,
//					null,
//					"TONELADA",
//					new BigDecimal("10000.00"),
//					null));
//			Conceptos c = new Conceptos();
//			c.setAplicaicon(valor("aplicacion", rs));
//			c.setC_ClaveProdServ(valor("claveProdServ", rs));
//			c.setC_ClaveUnidad(valor("ClaveUnidad", rs));
//			c.setCantidad(valor("CantSurtida", rs));
//			c.setNum_renglon(valor("renglon", rs));
//			c.setDesc_unidad(valor("desc_unidad", rs));
//			c.setNoidentificacion(valor("noidentificacion", rs));
//			c.setDescripcion(valor("descripcion", rs));
//			c.setValorunitario(valor("valorUnitario", rs));
//			c.setFactura(valor("factura", rs));
//			c.setOde(valor("ode_conceptos", rs));
//			c.setGrupo(valor("grupo", rs));
//			c.setImporte(valor("importe", rs));
//			c.setProveedor(valor("proveedor", rs));
//			// System.out.println("c.setC_ClaveProdServ: " + c.getC_ClaveProdServ());
//			lstConceptosXML.add(c);
//			
//		}
//		catch (Exception e) 
//		{
//			objRespuesta.setMsjError("Error al obtener conceptos. ERROR: "+e.getMessage());
//			objRespuesta.setRespuesta(false);
//		}
//		
//		
//	}
//
//	private EmisorR obtenerEmisor(ResultSet rs) 
//	{
//		try
//		{
//			emisor.setNombre("HORACIO PEREZ");
//			emisor.setRegimenFiscal("601");
//		
//		}
//		catch (Exception e) 
//		{
//			objRespuesta.setMsjError("Error al obtener Emisor. ERROR: "+e.getMessage());
//			objRespuesta.setRespuesta(false);
//		}
//		
//		return emisor;
//	}
//
//	
//	private CartaPorte20R obtenerCartaPorte(ResultSet rs) 
//	{
//	 	CartaPorte20R cartaPorte20 = new CartaPorte20R();
//
//		try
//		{		 
//			CartaPorteUbicacion20R[] ubicaciones = new CartaPorteUbicacion20R[2];
//			ubicaciones = llenarArrayUbicaciones(ubicaciones);
//			
//			cartaPorte20.setFiguraTransporte(obtenerFiguraTransporte(rs));
//
//			cartaPorte20.setMercancias(obtenerMercancias(rs));
//
//			cartaPorte20.setTotalDistRec(new BigDecimal("8.0"));
//
//			cartaPorte20.setTranspInternac("N");
//			
//			cartaPorte20.setUbicaciones(ubicaciones);
//			
//
//
//
//		}
//		catch (Exception e) 
//		{
//			System.out.println("Error al obtener ubicaciones. ERROR: "+e);
//			objRespuesta.setMsjError("Error al obtener ubicaciones. ERROR: "+e.getMessage());
//			objRespuesta.setRespuesta(false);
//		}
//		
//		return cartaPorte20;
//	}
//
//	private CartaPorteUbicacion20R[] llenarArrayUbicaciones(CartaPorteUbicacion20R[] ubicaciones) {
//		try {
//         
//			 
//
//	 /*
//	  * CartaPorteUbicacion20R(BigDecimal distanciaRecorrida, 
//	  * CartaPorteUbicacionDomicilio20R domicilio,
//	  * String fechaHoraSalidaLlegada,
//	  * String IDUbicacion,
//	  * String navegacionTrafico,
//	  * String nombreEstacion, 
//	  * String nombreRemitenteDestinatario,
//	  * String numEstacion,
//	  * String numRegIdTrib, 
//      * String RFCRemitenteDestinatario,
//      * String residenciaFiscal, 
//      * String tipoEstacion, String tipoUbicacion)
//	  */
//	   				
//	   				ubicaciones[0] = new CartaPorteUbicacion20R(
//							null, /*distanciaRecorrida*/
//							generaDomicilioOrigen(), /*domicilio*/
//							"2021-11-25T16:39:18", /* fechaHoraSalidaLlegada*/
//							"OR000001", /*IDUbicacion*/
//							null, /* navegacionTrafico */
//							null, /* nombreEstacion */
//							"ALMACEN PRINCIPAL", /* nombreRemitenteDestinatario */
//							null, /* numEstacion */
//							null, /* numRegIdTrib */
//							"TEST010203001", /* RFCRemitenteDestinatario */
//							null, /* residenciaFiscal */
//							null, /* tipoEstacion */
//							"Oigen" /* tipoUbicacion */
//							);
//	   				
//	   				ubicaciones[1] = new CartaPorteUbicacion20R(
//							new BigDecimal("8.00"), /*distanciaRecorrida*/
//							generaDomicilioDestino(), /*domicilio*/
//							"2021-11-25T00:00:00", /* fechaHoraSalidaLlegada*/
//							"DE000001", /*IDUbicacion*/
//							null, /* navegacionTrafico */
//							null, /* nombreEstacion */
//							"Cliente mostrador", /* nombreRemitenteDestinatario */
//							null, /* numEstacion */
//							null, /* numRegIdTrib */
//							"TEST010203001", /* RFCRemitenteDestinatario */
//							null, /* residenciaFiscal */
//							null, /* tipoEstacion */
//							"Destino" /* tipoUbicacion */
//							);
//		} catch (Exception e) {
//			objRespuesta.setMsjError("Error al llenar array ubicaciones. ERROR: " + e.getMessage());
//			objRespuesta.setRespuesta(false);
//		}
//		return ubicaciones;
//	}
//
//
//	private CartaPorteUbicacionDomicilio20R generaDomicilioDestino() {
//		CartaPorteUbicacionDomicilio20R domicilio =  new CartaPorteUbicacionDomicilio20R();
//		domicilio.setCalle("Xola");
//		domicilio.setCodigoPostal("03103");
//		domicilio.setEstado("DIF");
//		domicilio.setLocalidad("03");
//		domicilio.setMunicipio("014");
//		domicilio.setNumeroExterior("536");
//		domicilio.setNumeroInterior("313");
//		domicilio.setPais("MEX");
//		domicilio.setReferencia("2 pisos de color naranja, porton negro");
//		
//		return domicilio;
//	}
//
//
//
//
//	private CartaPorteUbicacionDomicilio20R generaDomicilioOrigen() {
//	 
//		CartaPorteUbicacionDomicilio20R domicilio =  new CartaPorteUbicacionDomicilio20R();
//		domicilio.setCalle("Centro");
//		domicilio.setCodigoPostal("24000");
//		domicilio.setColonia("0001");
//		domicilio.setEstado("CAM");
//		domicilio.setLocalidad("01");
//		domicilio.setMunicipio("002");
//		domicilio.setNumeroExterior("114");
// 
//		domicilio.setPais("MEX");
//		domicilio.setReferencia("2 pisos de color naranja, porton negro");
//		
//		return domicilio;
//	}
//
//
//	private CartaPorteMercancias20R obtenerMercancias(ResultSet rs) 
//	
//	{
//		CartaPorteMercanciasMercancia20R[] cartaMercanciaArray = new  CartaPorteMercanciasMercancia20R[2] ;
//		 
//		cartaMercanciaArray = llenarArrayMercancias(cartaMercanciaArray);
//			
//		CartaPorteMercancias20R cartaMercancias = new CartaPorteMercancias20R();
//		
//		cartaMercancias.setAutotransporte(obtenrCartaAutoTransporte(rs));
//		
//		cartaMercancias.setMercancia(cartaMercanciaArray);
//
//		cartaMercancias.setNumTotalMercancias(2);
//		
//		cartaMercancias.setPesoBrutoTotal(new BigDecimal("35"));
//		
//		cartaMercancias.setUnidadPeso("KGM");
//		
//		//cartaMercancias.setPesoNetoTotal(new BigDecimal(pesoNetoTotal));
//
//		
//		
//
//		return cartaMercancias;
//	}
//
//	private CartaPorteMercanciasMercancia20R[] llenarArrayMercancias(CartaPorteMercanciasMercancia20R[] cartaMercanciaArray)
//	{
//		try
//		{
//			
//				CartaPorteMercanciasMercancia20R merc = new CartaPorteMercanciasMercancia20R();
//				
//
//				cartaMercanciaArray[0] = new CartaPorteMercanciasMercancia20R(
//						
//							"50202306", new BigDecimal("3"), null,  null, "58",
//							null, null, "Artículo Iva Exento",null, null,null,
//							null,null, null,"MXN", null,new BigDecimal("31.500"), null, 
//					        "KGM", new BigDecimal("480.00"));
//				
//				cartaMercanciaArray[1] = new CartaPorteMercanciasMercancia20R(
//						"12131500", new BigDecimal("1"), null,  null, "H87",
//						"0004", null, "Cartuchos de arma.",null, null,"4A",
//						null,null,"Si" ,"MXN", null,new BigDecimal("2.000"), null, 
//				        "KGM", new BigDecimal("300.55"));
//		}
//		catch (Exception e) 
//		{
//			objRespuesta.setMsjError("Error al llenar array mercancias. ERROR: "+e.getMessage());
//			objRespuesta.setRespuesta(false);
//		}
//		return cartaMercanciaArray;
//	}
//
//
//	private void obtenerCartaMercanciaArray(ResultSet rs, int idMercancias)
//	{
//		try
//		{
//			lstMercancias.add(obtenerCartaMercancia(valor("idDestino_mercancia", rs),valor("idOrigen_mercancia", rs),rs,idMercancias));
//			 totalMercancias++;
//			//  totalMercancias = totalMercancias+ Integer.parseInt(valor("cantidad_mercancia", rs));
//		}
//		catch (Exception e) 
//		{
//			objRespuesta.setMsjError("Error al obtener mercancias. ERROR: "+e.getMessage());
//			objRespuesta.setRespuesta(false);
//		}
//	
//	}
//
//	private CartaPorteMercanciasMercancia20R obtenerCartaMercancia(String destino, String origen, ResultSet rs, int idMercancias) 
//	{
//		
//		CartaPorteMercanciasMercancia20R cartaMercancia = new CartaPorteMercanciasMercancia20R();
//		try
//		{
//
//			 
//			 cartaMercancia.setCantidad(new BigDecimal(valor("cantidad_mercancia", rs)));
//			 cartaMercancia.setDescripcion(valor("descripcion_mercancia", rs));
//			 cartaMercancia.setBienesTransp(valor("c_ClaveProdServ_mercancia", rs));
//			 cartaMercancia.setClaveUnidad(valor("c_ClaveUnidad_mercancia", rs));
//			// cartaMercancia.setCantidadTransporta(obtenerCantidadTransporta(origen,destino,rs));
//			 cartaMercancia.setDetalleMercancia( GeneraDetalleMercancia(rs) );
//			
//			 // agregar al query
//			 cartaMercancia.setUnidad(valor("c_desc_unidad", rs));
//			 
//			 // validar l atalogo de cartaporte
//			 cartaMercancia.setMaterialPeligroso("No");
//			 
//			 // en base al catalogo del SAT
//			 //cartaMercancia.setCveMaterialPeligroso("");
//			 
//			 // cuando se transporta material peligroso
//			 //cartaMercancia.setEmbalaje("");
//			 // cartaMercancia.setDescripEmbalaje("");
//			 
//			 cartaMercancia.setPesoEnKg(new BigDecimal(pesoNetoTotal));
//			 cartaMercancia.setValorMercancia(new BigDecimal(valorMercancia));
//			 
//             pesoBrutoTotal = pesoBrutoTotal + Double.parseDouble(valor("peso_bruto_mercancia", rs));
//
//		}
//		catch (Exception e) 
//		{
//			System.out.println("Error al llenar carta mercancia. ERROR: "+e);
//			objRespuesta.setMsjError("Error al llenar carta mercancia. ERROR: "+e);
//			objRespuesta.setRespuesta(false);
//		}
//
//		return cartaMercancia;
//		
//	}
//         	
//	private CartaPorteMercanciasMercanciaDetalleMercancia20R GeneraDetalleMercancia(ResultSet rs) {
//		CartaPorteMercanciasMercanciaDetalleMercancia20R detalleMerc = new CartaPorteMercanciasMercanciaDetalleMercancia20R();
//		try
//		{
//
//			detalleMerc.setNumPiezas( Integer.parseInt(valor("cantidad_mercancia", rs))  );
//
//			detalleMerc.setPesoBruto( new BigDecimal(valor("peso_bruto_mercancia", rs)) );
//
//			detalleMerc.setPesoNeto( new BigDecimal(valor("peso_neto_mercancia", rs)) );
//
//			detalleMerc.setPesoTara( new BigDecimal(valor("peso_tara_mercancia", rs)) );
//
//			detalleMerc.setUnidadPesoMerc("KGM");
//			
//			valorMercancia = valorMercancia +  Double.parseDouble(valor("importe_mercancia", rs)) ;
//
//			pesoNetoTotal = pesoNetoTotal + Double.parseDouble(valor("peso_neto_mercancia", rs));
//
//		}
//		catch (Exception e) {
//			System.out.println("Error al llenar Detalle Mercancia. ERROR: "+e);
//			objRespuesta.setMsjError("Error al Detalle Mercancia. ERROR: "+e);
//			objRespuesta.setRespuesta(false);
//		}
//		return detalleMerc;
//	}
//
//
//
//            
//	private CartaPorteMercanciasAutotransporte20R obtenrCartaAutoTransporte(ResultSet rs) 
//	{
//		CartaPorteMercanciasAutotransporte20R cartaAutoTransporte = new CartaPorteMercanciasAutotransporte20R();
//		try
//		{ 
//			cartaAutoTransporte.setIdentificacionVehicular(obtenerIdentificacionVehicular(rs));
//			cartaAutoTransporte.setNumPermisoSCT("20210629");
//			cartaAutoTransporte.setPermSCT("TPAF01");
//			//cartaAutoTransporte.setRemolques(null);
//			cartaAutoTransporte.setSeguros( obtenerSerugo(rs) );
//
//			
//			System.out.println("AutoTransporteFederal: " +cartaAutoTransporte );
//		}
//		catch (Exception e) 
//		{
//			objRespuesta.setMsjError("Error al obtener carta auto transporte. ERROR: "+e.getMessage());
//			objRespuesta.setRespuesta(false);
//		}
//
//		return cartaAutoTransporte;
//	}
//
//         	
//	private CartaPorteMercanciasAutotransporteSeguros20R obtenerSerugo(ResultSet rs) {
//		CartaPorteMercanciasAutotransporteSeguros20R seguro = new CartaPorteMercanciasAutotransporteSeguros20R();
//		try {
//			seguro.setAseguraRespCivil("Seguros AXA");
//			
//		
//			
//			seguro.setPolizaRespCivil("06292021");
//		
//			seguro.setAseguraMedAmbiente("Olimpo S.A. de C.V.");
//			seguro.setPolizaCarga("368549");
//			
//			seguro.setPolizaMedAmbiente("987423");
//			
//			seguro.setPolizaRespCivil("06292021");
//			
//			seguro.setPrimaSeguro(new BigDecimal("1200.00"));
//			
//			}
//	catch (Exception e) 
//	{
//		objRespuesta.setMsjError("Error al obtener carta auto transporte Seguro. ERROR: "+e.getMessage());
//		objRespuesta.setRespuesta(false);
//	}
//		return seguro;
//	}
//
//
//
//
//	private CartaPorteMercanciasAutotransporteIdentificacionVehicular20R obtenerIdentificacionVehicular(ResultSet rs) 
//	{
//		CartaPorteMercanciasAutotransporteIdentificacionVehicular20R identificacionVehicular= new CartaPorteMercanciasAutotransporteIdentificacionVehicular20R();
//		
//		try
//		{
//			identificacionVehicular.setAnioModeloVM(2010);
//			identificacionVehicular.setConfigVehicular("C2");
//			identificacionVehicular.setPlacaVM("426EE9");
//		}
//		catch (Exception e) 
//		{
//			objRespuesta.setMsjError("Error al obtener identificacion vehicular. ERROR: "+e.getMessage());
//			objRespuesta.setRespuesta(false);
//		}
//
//		return identificacionVehicular;
//	}
//
//	
//        
//	private CartaPorteTiposFigura20R[] obtenerFiguraTransporte(ResultSet rs) 
//	{
//		CartaPorteTiposFigura20R[] figuraTransporte = new CartaPorteTiposFigura20R[1];
//		try
//		{
//			figuraTransporte[0] = new CartaPorteTiposFigura20R(
//					null, 
//					"JUAN CERVANTES GARRIDO", 
//					"01N450316", 
//					null, 
//					null, 
//					"TEST010203001",
//					null, 
//					"01") ;
//			//este ultimo campo se tiene que tomar conforme al catalogo de figura transporte
//			/*01	Operador
//             *02	Propietario
//             *03	Arrendador
//             *04	Notificado 
//			 */
//	
//		}
//		catch(Exception ex)
//		{
//			System.out.println("Error al Obtener figuraTransporte: " + ex);	
//			objRespuesta.setMsjError("Error al Obtener figuraTransporte: "+ex.getMessage());
//			objRespuesta.setRespuesta(false);
//		}
//		return figuraTransporte;
//	}
//            
//
//
//
//
//	private void obtenerUbicaciones(ResultSet rs, int idUbicaciones)
//	{
//		
//		try
//		{
//
//CartaPorteUbicacion20R n = new CartaPorteUbicacion20R();
//                       n.setDistanciaRecorrida( new BigDecimal(valor("distanciaRecorrida", rs)) );
//                       n.setDomicilio( obtenerDomicilio(rs));
//                       
//                       
//                       n.setTipoUbicacion("Origen");
//                       n.setIDUbicacion(valor("idOrigen", rs));
//                       
//                       // el de pruebas para pruebas n.setRFCRemitenteDestinatario( valor("rfc", rs) );
//                       n.setRFCRemitenteDestinatario( valor("rfc_operador", rs) );
//                       
//                       if(!valor("orden", rs).equalsIgnoreCase("0"))
//                       {
//                    	   n.setTipoUbicacion("Destino");
//                    	   n.setIDUbicacion(valor("idDestino", rs));
//                       }
//                       
//                       n.setResidenciaFiscal("MEX");
//                       n.setFechaHoraSalidaLlegada( valor("fecha_aprox_llegada", rs) );
//                       
//                       
//			  lstUbicacion.add(n);
//            			  
//		 	 totalDistanciaRecorrida = totalDistanciaRecorrida + Integer.parseInt(valor("distanciaRecorrida", rs));
//		
//		 	//System.out.println("totalDistanciaRecorrida: " + totalDistanciaRecorrida );
//		}
//		catch (Exception e) 
//		{
//			objRespuesta.setMsjError("Error al obtener ubicaciones. ERROR: "+e.getMessage());
//			objRespuesta.setRespuesta(false);
//		}
//		
//	}
//
//	private ReceptorR obtenerReceptor(ResultSet rs) 
//	{
//		try
//		{
//		receptor.setRfc("TEST010203001");
//		receptor.setUsoCFDI("P01");
//		receptor.setNombre("RAFAEL HERNÁNDEZ");
//		}
//		catch (Exception e) 
//		{
//			objRespuesta.setMsjError("Error al obtener receptor. ERROR: "+e.getMessage());
//			objRespuesta.setRespuesta(false);		}
//		return receptor;
//	}
//
//	private CartaPorteUbicacionDomicilio20R obtenerDomicilio(ResultSet rs) 
//	{
//		CartaPorteUbicacionDomicilio20R cartaDomicilio = new CartaPorteUbicacionDomicilio20R();
//		try
//		{
//			cartaDomicilio.setCalle(valor("calle_ubicaciones", rs));
//			cartaDomicilio.setCodigoPostal(valor("codigo_postal", rs));
//			cartaDomicilio.setEstado(valor("estado", rs));
//			cartaDomicilio.setPais("MEX");
//// 			cartaDomicilio.setColonia(valor("colonia", rs));
//	// 		cartaDomicilio.setLocalidad(valor("localidad", rs));
////			cartaDomicilio.setMunicipio(valor("municipio", rs));
//
//
//
//		}
//		catch (Exception e) 
//		{
//			objRespuesta.setMsjError("Error al obtener domicilio. ERROR: "+e.getMessage());
//			objRespuesta.setRespuesta(false);
//		}
//
//		return cartaDomicilio;
//	}
//
//
//
//	private Calendar obtenerFecha(String parametroFecha) 
//	{
//		Calendar fecha = Calendar.getInstance();
//		SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
//		try 
//		{
//			 fecha.setTime(formatoFecha.parse(""+parametroFecha+""));
//		}
//		catch (ParseException e) 
//		{
//			objRespuesta.setMsjError("Error al parsear fecha. PARAMETRO: "+parametroFecha+". ERROR: "+e.getMessage());
//			objRespuesta.setRespuesta(false);
//		}	
//		return fecha;
//	}
//
//	private Credenciales obtenerCredenciales(ResultSet rs) 
//	{
//		try
//		{
//			credenciales.setCuenta(valor("cuenta", rs));
//			credenciales.setPassword(valor("password",rs));
//			credenciales.setUsuario(valor("usuario", rs));
//			System.out.println("setCuenta  : " + credenciales.getCuenta());
//			System.out.println("setPassword: " + credenciales.getPassword());
//			System.out.println("setUsuario : " + credenciales.getUsuario());
//		}
//		catch (Exception e) 
//		{
//			objRespuesta.setMsjError("Error al obtener credenciales. ERROR: "+e.getMessage());
//			objRespuesta.setRespuesta(false);
//		}
//		return credenciales;
//	}
//	
//	private void imprimirMensajesDeRespuesta(RespuestaOperacionCR respuesta) 
//	{
//		System.out.println("Codigo de Operacion Existosa: "+respuesta.getOperacionExitosa());
//		System.out.println("Codigo de Error General: "+respuesta.getErrorGeneral());
//		System.out.println("Codigo de Error Detallado: "+respuesta.getErrorDetallado());
//		System.out.println("Codigo de Folio Generado: "+respuesta.getFolioGenerado());
//		System.out.println("Codigo de Folio Generado: "+respuesta.getFolioGenerado());
//		/*System.out.println("Codigo de confrimacion: "+respuesta.getCodigoConfirmacion());
//		System.out.println("Codigo de Error General: "+respuesta.getErrorGeneral());
//		System.out.println("Codigo de Error Detallado: "+respuesta.getErrorDetallado());
//		
//		System.out.println("Codigo de CBB: "+respuesta.getCBB());
//		System.out.println("Codigo de Addenda: "+respuesta.getAddenda());
//		System.out.println("Codigo de PDF: "+respuesta.getPDF());
//		System.out.println("Codigo de XML: "+respuesta.getXML());
//	*/	
//		if (respuesta.getOperacionExitosa()) 
//		{	
//			objRespuesta.setCodigoXML(respuesta.getXML());
//			objRespuesta.setRespuesta(respuesta.getOperacionExitosa());
//			objRespuesta.setCodigoCBB(respuesta.getCBB());	
//		}
//		else
//		{
//			objRespuesta.setConceptos(null);
//			objRespuesta.setRespuesta(respuesta.getOperacionExitosa());
//			objRespuesta.setMsjError("ERROR GENERAL: "+respuesta.getErrorGeneral()+". DETALLADO: "+ respuesta.getErrorDetallado());
//		}
//		
//	}
//
//	@SuppressWarnings({ "rawtypes", "unchecked" })
//	public static String[] inicializacionQrys(String[] querys, List<Querys> ListaQuerys, String cdo, int noQry, String uname_br, String trayecto) 
//	{
//		querys = Cls_Querys.LimpiaListaQuerys(querys);
//        querys = ObtieneQuerys(noQry, (List)ListaQuerys, querys, cdo,uname_br,trayecto);
//    	return querys;
//	}
//	
//	public static String[] ObtieneQuerys(int noQuery, List<Querys> ListaTodosQuerys, String[] ListaQuerys,  String cdo, String uname_br, String trayecto)
//	{
//		String[] querys = ListaQuerys;
//		int cont = 0;
//		String qry="";
//		
//		for(int item = 0; item < ListaTodosQuerys.size(); item++)
//		{
//			if(ListaTodosQuerys.get(item).getIndice_query() == noQuery)
//			{
//				qry= ListaTodosQuerys.get(item).getQuery().toString();
//				qry= qry.replace("{CDO}",cdo.toUpperCase());
//				qry= qry.replace("{UNAME_BR}",uname_br.toLowerCase());
//				qry= qry.replace("{ID_TRAYECTO}",trayecto);
//				querys[cont] = qry;
//				cont++;
//			}
//		}
//		return querys;
//	}
//	
//	private String obtenerValor(String nodo, String campo, String funcion)
//	{
//	String valor = "";
//	if (!nodo.equals("")) 
//	{
//	
//		try
//		{	
//			String XML = objRespuesta.getCodigoXML();
//			Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new InputSource(new StringReader(XML)));
//	        NodeList nList = document.getElementsByTagName(nodo);
//	        if (!funcion.equals("size"))
//			{
//				Node nNode = nList.item(Integer.parseInt(funcion));
//				try
//				{
//					if(nNode.getNodeType() == Node.ELEMENT_NODE) 
//					{
//						Element eElement = (Element) nNode;
//						valor = eElement.getAttribute(campo);
//					}
//				}
//				catch (Exception e) 
//				{
//					//System.err.println("Error: "+e.getMessage()+".NODO: "+nodo+". CAMPO: "+campo);
//				}
//			}
//			else
//			{
//				return String.valueOf(nList.getLength());
//			}
//		}
//		catch (Exception e) 
//		{
//			//System.out.println("Error al obtener datos XML. NODO: "+nodo+". CAMPO: "+campo+". ERROR: "+e.getMessage().toString());
//		}
//	}
//		return valor;
//	}
//}
