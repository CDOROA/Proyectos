package Web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;

import Datos.CFDI;
import Datos.Cliente;
import Datos.Comprobante;
import Datos.Conceptos;
import Datos.Documentos;
import Datos.Emisor;
import Datos.LOG;
import Datos.Querys;
import Datos.Receptor;
import Datos.Usuario;
import Persistencia.ConexionShell;
import Persistencia.GestorCFDI;
import Persistencia.wsRfc;
import Persistencia.wsSellado;
/**
 * Servlet implementation class AdministradorCFDI
 */
public class AdministradorCFDI extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdministradorCFDI() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		if(session!=null)
		{
			request.setAttribute("nombre", session.getAttribute("nombre"));
			request.setAttribute("nombreCdo", session.getAttribute("nombreCdo"));
			request.setAttribute("departamento", session.getAttribute("departamento"));
			request.setAttribute("uname", session.getAttribute("uname"));
			validaPeticion(request, response, session);
	    }  
		else  
			if(session == null)
			{
				RequestDispatcher rdIndex = request.getRequestDispatcher("/Inicio.jsp");			    	
				rdIndex.forward(request, response);
			}
		
	} 
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 
		doGet(request, response);
	}

	private void validaPeticion(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		 try {
			// System.out.println("ruta de proyecto:" + this.getServletContext().getRealPath("Images")); ;
			 @SuppressWarnings("unchecked")
			List<Querys> listaQuerys = (List<Querys>) session.getAttribute("querys");
			 String accion = String.valueOf(request.getParameter("accion"));
			 JSONObject listaCFDIJson = new JSONObject();	
			  //System.out.println("accion:" + accion);
					switch (accion) {
					case "Inicio":
						session.setAttribute("accionServlet", "1");
						RedireccionarVista(request, response, "/AdministradorCFDI.jsp");
						break;
					case "Cargar":
						listaCFDIJson=consultaCFDI(request,response, listaQuerys, session);
						EviarRespuestaJsonJS(request,response, "["+ listaCFDIJson.toString()+"]");
						break;
					case "CargarNumeroCliente":
						listaCFDIJson=consultaCFDICliente(request,response, listaQuerys, session);
						EviarRespuestaJsonJS(request,response, "["+ listaCFDIJson.toString()+"]");
						break;
					case "CargarComprobantes":
						listaCFDIJson=consultaComprobante(request,response, listaQuerys, session);
						EviarRespuestaJsonJS(request,response, "["+ listaCFDIJson.toString()+"]");
						break;
					case "CargarEmisor":
						listaCFDIJson=consultaEmisor(request,response, listaQuerys, session);
						EviarRespuestaJsonJS(request,response, "["+ listaCFDIJson.toString()+"]");
						break;
					case "CargaLog":
						listaCFDIJson=consultaLog(request,response, listaQuerys, session);
						EviarRespuestaJsonJS(request,response, "["+ listaCFDIJson.toString()+"]");
						break;
					case "CargaReceptor":
						listaCFDIJson=consultaReceptor(request,response, listaQuerys, session);
						EviarRespuestaJsonJS(request,response, "["+ listaCFDIJson.toString()+"]");
						break;
					case "CargaConceptos":
						listaCFDIJson=consultaConceptos(request,response, listaQuerys, session);
						EviarRespuestaJsonJS(request,response, "["+ listaCFDIJson.toString()+"]");
						break;
					case "CargaDocumentos":
						listaCFDIJson=consultaDocumentos(request,response, listaQuerys, session);
						EviarRespuestaJsonJS(request,response, "["+ listaCFDIJson.toString()+"]");
						break;
					case "ActualizaRegimenReceptor":
						listaCFDIJson=actualizaRegimenReceptor(request,response, listaQuerys, session);
						EviarRespuestaJsonJS(request,response, "["+ listaCFDIJson.toString()+"]");
						break;
					case "ActualizaUsoCFDI":
						listaCFDIJson=actualizaUsoCFDIReceptor(request,response, listaQuerys, session);
						EviarRespuestaJsonJS(request,response, "["+ listaCFDIJson.toString()+"]");
						break;
					case "ActualizaMetodoPago":
						listaCFDIJson=actualizaMetodoPago(request,response, listaQuerys, session);
						EviarRespuestaJsonJS(request,response, "["+ listaCFDIJson.toString()+"]");
						break;
					case "ActualizaFormaPago":
						listaCFDIJson=actualizarFormaPago(request,response, listaQuerys, session);
						EviarRespuestaJsonJS(request,response, "["+ listaCFDIJson.toString()+"]");
						break;
					case "GuardaConcepto":
						listaCFDIJson=guardaConcepto(request,response, listaQuerys, session);
						EviarRespuestaJsonJS(request,response, "["+ listaCFDIJson.toString()+"]");
						break;
					case "GuardaCFDI":
						listaCFDIJson=guardaCFDI(request,response, listaQuerys, session);
						EviarRespuestaJsonJS(request,response, "["+ listaCFDIJson.toString()+"]");
						break;
					case "ConsultaRfc":
						listaCFDIJson=consultaRfc(request,response, listaQuerys, session);
						EviarRespuestaJsonJS(request,response, "["+ listaCFDIJson.toString()+"]");
						break;
					case "RfcReceptor":
						listaCFDIJson=rfcReceptor(request,response, listaQuerys, session);
						EviarRespuestaJsonJS(request,response, "["+ listaCFDIJson.toString()+"]");
						break;
					case "ActualizaReceptor":
						listaCFDIJson=actualizaReceptor(request,response, listaQuerys, session);
						EviarRespuestaJsonJS(request,response, "["+ listaCFDIJson.toString()+"]");
						break;
					case "verificaClaveProdServ":
						listaCFDIJson=verificarProdServ(request,response, listaQuerys, session);
						EviarRespuestaJsonJS(request,response, "["+ listaCFDIJson.toString()+"]");
						break;
					case "ConsultaImpresora":
						listaCFDIJson=consultaImpresora(request,response, listaQuerys, session);
						EviarRespuestaJsonJS(request,response, "["+ listaCFDIJson.toString()+"]");
						break;
					case "SellaNota":
						listaCFDIJson=sellaNota(request,response, listaQuerys, session);
						EviarRespuestaJsonJS(request,response, "["+ listaCFDIJson.toString()+"]");
						break;
					case "CargarFolio":
						listaCFDIJson=cargaFolio(request,response, listaQuerys, session);
						EviarRespuestaJsonJS(request,response, "["+ listaCFDIJson.toString()+"]");
						break;
					case "CargaInfoCliente":
						listaCFDIJson=cargaInfoCliente(request,response, listaQuerys, session);
						EviarRespuestaJsonJS(request,response, "["+ listaCFDIJson.toString()+"]");
						break;
					case "sellaCliente":
						listaCFDIJson=sellaCliente(request,response, listaQuerys, session);
						EviarRespuestaJsonJS(request,response, "["+ listaCFDIJson.toString()+"]");
						break;
					case "ConsultarPendientes":
						listaCFDIJson=consultaPendientes(request,response, listaQuerys, session);
						EviarRespuestaJsonJS(request,response, "["+ listaCFDIJson.toString()+"]");
						break;
					case "validaRfc":
						listaCFDIJson=validaRfc(request,response, listaQuerys, session);
						EviarRespuestaJsonJS(request,response, "["+ listaCFDIJson.toString()+"]");
						break;
					}
		 }
		 catch(Exception ex)
		 {
	
		 }
		}
		



	private JSONObject validaRfc(HttpServletRequest request, HttpServletResponse response, List<Querys> listaQuerys,
			HttpSession session) {
		JSONObject Jsoncfdi = new JSONObject();
		String cdo =  (String) session.getAttribute("uname");
		Usuario infoUsu=(Usuario) session.getAttribute("DatosUsr");
		String rfc = request.getParameter("rfc");
		String respuesta =  wsRfc.consultaRfc(rfc).replace('"', ' ').replace(" ", "");
		Jsoncfdi.put("respuesta",respuesta);
		
		return Jsoncfdi;
	}

	private JSONObject consultaPendientes(HttpServletRequest request, HttpServletResponse response,
			List<Querys> listaQuerys, HttpSession session) {
		JSONObject Jsoncfdi = new JSONObject();
		String cdo =  (String) session.getAttribute("uname");
		Usuario infoUsu=(Usuario) session.getAttribute("DatosUsr");
		
		List <String> pendientes =  GestorCFDI.consultaPendientes(listaQuerys,cdo,infoUsu);
		
		Jsoncfdi.put("pendientes",pendientes);
		
		return Jsoncfdi;
	}

	private JSONObject sellaCliente(HttpServletRequest request, HttpServletResponse response, List<Querys> listaQuerys,
			HttpSession session) {
		JSONObject Jsoncfdi = new JSONObject();
		String cdo =  (String) session.getAttribute("uname");
//		Usuario infoUsu=(Usuario) session.getAttribute("DatosUsr");
		String numeroCliente = request.getParameter("numCliente");
		String actualizar =  ConexionShell.sellaCliente(cdo, numeroCliente);
		
		Jsoncfdi.put("actualizar",actualizar);
		
		return Jsoncfdi;
	}

	private JSONObject consultaCFDICliente(HttpServletRequest request, HttpServletResponse response,
			List<Querys> listaQuerys, HttpSession session) {
		JSONObject Jsoncfdi = new JSONObject();
		String cdo =  (String) session.getAttribute("uname");
		Usuario infoUsu=(Usuario) session.getAttribute("DatosUsr");
		String numCliente = request.getParameter("numCliente");
		String opcion = request.getParameter("opcion");
		List<CFDI> listCFDI =  GestorCFDI.consultaCFDICliente(listaQuerys,cdo,infoUsu,numCliente,opcion);
		
		Jsoncfdi.put("listCFDI",listCFDI);
		
		return Jsoncfdi;
	}

	private JSONObject cargaInfoCliente(HttpServletRequest request, HttpServletResponse response,
			List<Querys> listaQuerys, HttpSession session) {
		JSONObject Jsoncfdi = new JSONObject();
		String cdo =  (String) session.getAttribute("uname");
		Usuario infoUsu=(Usuario) session.getAttribute("DatosUsr");
		String numCliente = request.getParameter("numCliente");
		List<Cliente> listCliente=  GestorCFDI.consultaCliente(listaQuerys,cdo,infoUsu,numCliente);
		
		Jsoncfdi.put("listCliente",listCliente);
		
		return Jsoncfdi;
	}

	private JSONObject cargaFolio(HttpServletRequest request, HttpServletResponse response, List<Querys> listaQuerys,
			HttpSession session) {
		JSONObject Jsoncfdi = new JSONObject();
		String cdo =  (String) session.getAttribute("uname");
		Usuario infoUsu=(Usuario) session.getAttribute("DatosUsr");
		String folio = request.getParameter("folio");
		List<CFDI> listCFDI =  GestorCFDI.consultaFolio(listaQuerys,cdo,infoUsu,folio);
		
		Jsoncfdi.put("listCFDI",listCFDI);
		
		return Jsoncfdi;
	}

	private JSONObject sellaNota(HttpServletRequest request, HttpServletResponse response, List<Querys> listaQuerys,
			HttpSession session) {
		JSONObject Jsoncfdi = new JSONObject();
		wsSellado ws = new wsSellado();
		String cdo =  (String) session.getAttribute("uname");
//		Usuario infoUsu=(Usuario) session.getAttribute("DatosUsr");
		String actualizar ="";
		String serie = request.getParameter("serie");
		String folio=request.getParameter("folio");
		String impresora=request.getParameter("impresora");
		String ode=request.getParameter("ode");
		String numeroCliente = request.getParameter("numCliente");
		int tipoDoc=Integer.parseInt(request.getParameter("tipoDoc"));
		switch(tipoDoc) {
		case 1:
			actualizar =  ConexionShell.sellaCFDI(cdo, serie, folio, impresora);
			break;
		case 2:
			actualizar =  ws.sella(cdo, serie, folio);
			break;
		case 3:
			actualizar =  ws.sella(cdo, serie, folio);
			break;
		case 4:
				actualizar =  ConexionShell.sellaCliente(cdo, numeroCliente);
			break;
		case 5:
				actualizar =  ConexionShell.sellaCliente(cdo, numeroCliente);
			break;
		case 6:
			actualizar =  ws.sella(cdo, serie, folio);
			break;
		}
		
		Jsoncfdi.put("actualizar",actualizar);
		
		return Jsoncfdi;
	}

	private JSONObject consultaImpresora(HttpServletRequest request, HttpServletResponse response,
			List<Querys> listaQuerys, HttpSession session) {
		JSONObject Jsoncfdi = new JSONObject();
		String cdo =  (String) session.getAttribute("uname");
		Usuario infoUsu=(Usuario) session.getAttribute("DatosUsr");
		String serie = request.getParameter("serie");
		String folio = request.getParameter("folio");
		String actualizar =  GestorCFDI.consultaImpresora(listaQuerys,cdo,infoUsu,serie,folio);
		//session.setAttribute("impresora", actualizar);
		Jsoncfdi.put("actualizar",actualizar);
		
		return Jsoncfdi;
	}

	private JSONObject consultaRfc(HttpServletRequest request, HttpServletResponse response, List<Querys> listaQuerys,
			HttpSession session) {
		JSONObject Jsoncfdi = new JSONObject();
		String cdo =  (String) session.getAttribute("uname");
		Usuario infoUsu=(Usuario) session.getAttribute("DatosUsr");
		String numeroCliente = request.getParameter("numeroCliente");
		String serie = request.getParameter("serie");
		String folio = request.getParameter("folio");
		String actualizar =  GestorCFDI.consultaRfc(listaQuerys,cdo,infoUsu,numeroCliente,serie,folio);
		
		Jsoncfdi.put("actualizar",actualizar);
		
		return Jsoncfdi;
	}

	private JSONObject verificarProdServ(HttpServletRequest request, HttpServletResponse response,
			List<Querys> listaQuerys, HttpSession session) {
		JSONObject Jsoncfdi = new JSONObject();
		String cdo =  (String) session.getAttribute("uname");
		Usuario infoUsu=(Usuario) session.getAttribute("DatosUsr");
		String claveProdServ = request.getParameter("claveProdServ");
		String serie = request.getParameter("serie");
		String folio = request.getParameter("folio");
		String noIdentificacion = request.getParameter("noIdentificacion");
		boolean verifica =  GestorCFDI.verificaProdServ(listaQuerys,cdo,infoUsu,claveProdServ,serie,folio,noIdentificacion);
		Jsoncfdi.put("verifica",verifica);
		return Jsoncfdi;
	}

	private JSONObject actualizaReceptor(HttpServletRequest request, HttpServletResponse response,
			List<Querys> listaQuerys, HttpSession session) {
		JSONObject Jsoncfdi = new JSONObject();
		String cdo =  (String) session.getAttribute("uname");
		Usuario infoUsu=(Usuario) session.getAttribute("DatosUsr");
		String serie = request.getParameter("serie");
		String folio = request.getParameter("folio");
		String numeroCliente = request.getParameter("numeroCliente");
		String domicilioFiscal = request.getParameter("domicilioFiscal");
		String etiquetaTransporte = request.getParameter("etiquetaTransporte");
		String etiquetaRuta = request.getParameter("etiquetaRuta");
		String etiquetaCalle = request.getParameter("etiquetaCalle");
		String etiquetaNumExt = request.getParameter("etiquetaNumExt");
		String etiquetaNumInt = request.getParameter("etiquetaNumInt");
		String etiquetaColonia = request.getParameter("etiquetaColonia");
		String etiquetaCodigoPostal = request.getParameter("etiquetaCodigoPostal");
		String etiquetaMunicipio = request.getParameter("etiquetaMunicipio");
		String etiquetaEstado = request.getParameter("etiquetaEstado");
		String etiquetaPais = request.getParameter("etiquetaPais");
		String etiquetaPedido = request.getParameter("etiquetaPedido");
		String etiquetaNumCli = request.getParameter("etiquetaNumCli");
		String etiquetaAgente = request.getParameter("etiquetaAgente");
		String etiquetaCondCred = request.getParameter("etiquetaCondCred");
		String etiquetaTipoFact = request.getParameter("etiquetaTipoFact");
		String etiquetaTipoCliente = request.getParameter("etiquetaTipoCliente");
		String etiquetaTipoDocto = request.getParameter("etiquetaTipoDocto");
		String etiquetaMail = request.getParameter("etiquetaMail");
		String actualizar =  GestorCFDI.actualizaReceptor(listaQuerys,cdo,infoUsu,serie, folio,numeroCliente,domicilioFiscal,etiquetaTransporte,etiquetaRuta,etiquetaCalle,
				etiquetaNumExt,etiquetaNumInt,etiquetaColonia,etiquetaCodigoPostal,etiquetaMunicipio,etiquetaEstado,etiquetaPais,etiquetaPedido,
				etiquetaNumCli,etiquetaAgente,etiquetaCondCred,etiquetaTipoFact,etiquetaTipoCliente,etiquetaTipoDocto,etiquetaMail);
		
		Jsoncfdi.put("actualizar",actualizar);
		
		return Jsoncfdi;
	}

	private JSONObject rfcReceptor(HttpServletRequest request, HttpServletResponse response, List<Querys> listaQuerys,
			HttpSession session) {
		JSONObject Jsoncfdi = new JSONObject();
		String cdo =  (String) session.getAttribute("uname");
		Usuario infoUsu=(Usuario) session.getAttribute("DatosUsr");
		String serie = request.getParameter("serie");
		String folio = request.getParameter("folio");
		String numeroCliente = request.getParameter("numeroCliente");
		String actualizar =  GestorCFDI.actualizaRfcReceptor(listaQuerys,cdo,infoUsu,serie, folio,numeroCliente);
		
		Jsoncfdi.put("actualizar",actualizar);
		
		return Jsoncfdi;
	}

	private JSONObject guardaCFDI(HttpServletRequest request, HttpServletResponse response, List<Querys> listaQuerys,
			HttpSession session) {
		JSONObject Jsoncfdi = new JSONObject();
		String cdo =  (String) session.getAttribute("uname");
		Usuario infoUsu=(Usuario) session.getAttribute("DatosUsr");
		String serie = request.getParameter("serie");
		String serie2 = request.getParameter("serie2");
		String folio = request.getParameter("folio");
		String folio2 = request.getParameter("folio2");
		String moneda = request.getParameter("moneda");
		String tipoCambio = request.getParameter("tipoCambio");
		String exportacion = request.getParameter("exportacion");
		String observaciones = request.getParameter("observaciones");
		String ode = request.getParameter("ode");
		//System.out.println("serie"+serie+"serie2"+serie2+"folio"+folio+"folio2"+folio2+"moneda"+moneda+"tipoCambio"+tipoCambio+"xportacion"+exportacion+"obervaciones"+observaciones+"ode"+ode);
		String  listCampo =  GestorCFDI.guardarCampos(listaQuerys,cdo,infoUsu,serie, folio,moneda,tipoCambio,exportacion,observaciones,ode,serie2,folio2);
		
		Jsoncfdi.put("listCampo",listCampo);
		
		return Jsoncfdi;
	}

	private JSONObject guardaConcepto(HttpServletRequest request, HttpServletResponse response,
			List<Querys> listaQuerys, HttpSession session) {
		JSONObject Jsoncfdi = new JSONObject();
		String cdo =  (String) session.getAttribute("uname");
		Usuario infoUsu=(Usuario) session.getAttribute("DatosUsr");
		String serie = request.getParameter("serie");
		String folio = request.getParameter("folio");
		String numRenglon = request.getParameter("numRenglon");
		String cantidad = request.getParameter("cantidad");
		String descripcionConceptos = ponerTilde(request.getParameter("descripcionConceptos"));
		String valorUnitario = request.getParameter("valorUnitario");
		String importe = request.getParameter("importe");
		String descuento = request.getParameter("descuento");
		String noIdentificacion = request.getParameter("noIdentificacion");
		String objetoImp = request.getParameter("objetoImp");
		String baseTraslado = request.getParameter("baseTraslado");
		String importeTraslado = request.getParameter("importeTraslado");
		String impuestoTraslado = request.getParameter("impuestoTraslado");
		String tasaCuota = request.getParameter("tasaCuota");
		String tipoFactorTranslado = request.getParameter("tipoFactorTranslado");
		String baseRetencion = request.getParameter("baseRetencion");
		String importeRetencion = request.getParameter("importeRetencion");
		String impuestoRetencion = request.getParameter("impuestoRetencion");
		String tipoFactorRetencion = request.getParameter("tipoFactorRetencion");
		String tasaCuotaRetencion = request.getParameter("tasaCuotaRetencion");
		String unidad = request.getParameter("unidad");
		List<String> listCampo =  GestorCFDI.guardarConceptos(listaQuerys,cdo,infoUsu,objetoImp,baseTraslado,importeTraslado,impuestoTraslado,tasaCuota,tipoFactorTranslado,baseRetencion,importeRetencion,impuestoRetencion,tipoFactorRetencion,tasaCuotaRetencion,serie, folio,numRenglon,cantidad,descripcionConceptos,valorUnitario,importe,descuento,noIdentificacion,unidad);
		
		Jsoncfdi.put("listCampo",listCampo);
		
		return Jsoncfdi;
	}

	private JSONObject actualizarFormaPago(HttpServletRequest request, HttpServletResponse response,
			List<Querys> listaQuerys, HttpSession session) {
		JSONObject Jsoncfdi = new JSONObject();
		String cdo =  (String) session.getAttribute("uname");
		Usuario infoUsu=(Usuario) session.getAttribute("DatosUsr");
		String serie = request.getParameter("serie");
		String folio = request.getParameter("folio");
		String numeroCliente = request.getParameter("numeroCliente");
		String actualizar =  GestorCFDI.actualizarFormaPago(listaQuerys,cdo,infoUsu,serie, folio,numeroCliente);
		
		Jsoncfdi.put("actualizar",actualizar);
		
		return Jsoncfdi;
	}

	private JSONObject actualizaMetodoPago(HttpServletRequest request, HttpServletResponse response,
			List<Querys> listaQuerys, HttpSession session) {
		JSONObject Jsoncfdi = new JSONObject();
		String cdo =  (String) session.getAttribute("uname");
		Usuario infoUsu=(Usuario) session.getAttribute("DatosUsr");
		String serie = request.getParameter("serie");
		String folio = request.getParameter("folio");
		String numeroCliente = request.getParameter("numeroCliente");
		String actualizar =  GestorCFDI.actualizarMetodoPago(listaQuerys,cdo,infoUsu,serie, folio,numeroCliente);
		
		Jsoncfdi.put("actualizar",actualizar);
		
		return Jsoncfdi;
	}

	private JSONObject actualizaUsoCFDIReceptor(HttpServletRequest request, HttpServletResponse response,
			List<Querys> listaQuerys, HttpSession session) {
		JSONObject Jsoncfdi = new JSONObject();
		String cdo =  (String) session.getAttribute("uname");
		Usuario infoUsu=(Usuario) session.getAttribute("DatosUsr");
		String serie = request.getParameter("serie");
		String folio = request.getParameter("folio");
		String numeroCliente = request.getParameter("numeroCliente");
		String actualizar =  GestorCFDI.actualizarUsoCFDI(listaQuerys,cdo,infoUsu,serie, folio,numeroCliente);
		
		Jsoncfdi.put("actualizar",actualizar);
		
		return Jsoncfdi;
	}

	private JSONObject actualizaRegimenReceptor(HttpServletRequest request, HttpServletResponse response,
			List<Querys> listaQuerys, HttpSession session) {
		JSONObject Jsoncfdi = new JSONObject();
		String cdo =  (String) session.getAttribute("uname");
		Usuario infoUsu=(Usuario) session.getAttribute("DatosUsr");
		String serie = request.getParameter("serie");
		String folio = request.getParameter("folio");
		String numeroCliente = request.getParameter("numeroCliente");
		String actualizar =  GestorCFDI.actualizarRegimenReceptor(listaQuerys,cdo,infoUsu,serie, folio,numeroCliente);
		
		Jsoncfdi.put("actualizar",actualizar);
		
		return Jsoncfdi;
	}

	private JSONObject consultaDocumentos(HttpServletRequest request, HttpServletResponse response,
			List<Querys> listaQuerys, HttpSession session) {
		JSONObject Jsoncfdi = new JSONObject();
		String cdo =  (String) session.getAttribute("uname");
		Usuario infoUsu=(Usuario) session.getAttribute("DatosUsr");
		String serie = request.getParameter("serie");
		String folio = request.getParameter("folio");
		List<Documentos> listDocumentos =  GestorCFDI.consultaDocumentos(listaQuerys,cdo,infoUsu,serie, folio);
		
		Jsoncfdi.put("listDocumentos",listDocumentos);
		
		return Jsoncfdi;
	}

	private JSONObject consultaConceptos(HttpServletRequest request, HttpServletResponse response,
			List<Querys> listaQuerys, HttpSession session) {
		JSONObject Jsoncfdi = new JSONObject();
		String cdo =  (String) session.getAttribute("uname");
		Usuario infoUsu=(Usuario) session.getAttribute("DatosUsr");
		String serie = request.getParameter("serie");
		String folio = request.getParameter("folio");
		List<Conceptos> listConceptos =  GestorCFDI.consultaConceptos(listaQuerys,cdo,infoUsu,serie, folio);
		
		Jsoncfdi.put("listConceptos",listConceptos);
		
		return Jsoncfdi;
	}

	private JSONObject consultaReceptor(HttpServletRequest request, HttpServletResponse response,
			List<Querys> listaQuerys, HttpSession session) {
		JSONObject Jsoncfdi = new JSONObject();
		String cdo =  (String) session.getAttribute("uname");
		Usuario infoUsu=(Usuario) session.getAttribute("DatosUsr");
		String serie = request.getParameter("serie");
		String folio = request.getParameter("folio");
		List<Receptor> listReceptor =  GestorCFDI.consultaReceptor(listaQuerys,cdo,infoUsu,serie, folio);
		
		Jsoncfdi.put("listReceptor",listReceptor);
		
		return Jsoncfdi;
	}

	private JSONObject consultaLog(HttpServletRequest request, HttpServletResponse response, List<Querys> listaQuerys,
			HttpSession session) {
		JSONObject Jsoncfdi = new JSONObject();
		String cdo =  (String) session.getAttribute("uname");
		Usuario infoUsu=(Usuario) session.getAttribute("DatosUsr");
		String serie = request.getParameter("serie");
		String folio = request.getParameter("folio");
		List<LOG> listLOG =  GestorCFDI.consultaLOG(listaQuerys,cdo,infoUsu,serie, folio);
		
		Jsoncfdi.put("listLOG",listLOG);
		
		return Jsoncfdi;
	}

	private JSONObject consultaEmisor(HttpServletRequest request, HttpServletResponse response,
			List<Querys> listaQuerys, HttpSession session) {
		JSONObject Jsoncfdi = new JSONObject();
		String cdo =  (String) session.getAttribute("uname");
		Usuario infoUsu=(Usuario) session.getAttribute("DatosUsr");
		String serie = request.getParameter("serie");
		String folio = request.getParameter("folio");
		List<Emisor> listEmisor =  GestorCFDI.consultaEmisor(listaQuerys,cdo,infoUsu,serie, folio);
		
		Jsoncfdi.put("listEmisor",listEmisor);
		
		return Jsoncfdi;
	}

	private JSONObject consultaComprobante(HttpServletRequest request, HttpServletResponse response,
			List<Querys> listaQuerys, HttpSession session) {
		JSONObject Jsoncfdi = new JSONObject();
		String cdo =  (String) session.getAttribute("uname");
		Usuario infoUsu=(Usuario) session.getAttribute("DatosUsr");
		String serie = request.getParameter("serie");
		String folio = request.getParameter("folio");
		List<Comprobante> listComprobante =  GestorCFDI.consultaComprobantes(listaQuerys,cdo,infoUsu,serie, folio);
		
		Jsoncfdi.put("listComprobante",listComprobante);
		
		return Jsoncfdi;
	}

	private JSONObject consultaCFDI(HttpServletRequest request, HttpServletResponse response, List<Querys> listaQuerys,
			HttpSession session) {
		JSONObject Jsoncfdi = new JSONObject();
		String cdo =  (String) session.getAttribute("uname");
		Usuario infoUsu=(Usuario) session.getAttribute("DatosUsr");
		String opcion = request.getParameter("opcion");
		List<CFDI> listCFDI =  GestorCFDI.consultaCFDI(listaQuerys,cdo,infoUsu,opcion);
		
		Jsoncfdi.put("listCFDI",listCFDI);
		
		return Jsoncfdi;
	}

	public void RedireccionarVista(HttpServletRequest request, HttpServletResponse response, String vista)
	{
		try
		{
			RequestDispatcher rdIndex = request.getRequestDispatcher("jsp/" + vista);			    	
		    rdIndex.forward(request, response);
		}
		catch(Exception ex)
		{
			try {
			RequestDispatcher rdIndex = request.getRequestDispatcher(vista);			    	
		    rdIndex.forward(request, response);
			}
			catch (Exception e) {
				System.out.println("Error al re-direccionar vista." + e.getMessage().toString());
			}
		}
	}
	
	private void EviarRespuestaJsonJS(HttpServletRequest request, HttpServletResponse response, String respuesta)
	{
		try
		{
			response.setContentType("application/json");
			PrintWriter out = response.getWriter();
			out.write(respuesta);	
		}
		catch(Exception ex)
		{
			System.out.println("Error al re-direccionar vista." + ex.getMessage().toString());
		}
	}
	private String ponerTilde(String palabra) {
		String[] letras= {"a1","A2","e1","E2","i1","I2","o1","O2","u1","U2","n1","N2"};
		String[] codigo= {"á","Á","é","É","í","Í","ó","Ó","ú","Ú","ñ","Ñ"};
		for (int i = 0; i < letras.length; i++) {
			   palabra=palabra.replaceAll(letras[i],codigo[i]);
			  //alert(letras[i]+codigo[i]);
			}
		return palabra;
		
	}
}
