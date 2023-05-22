package cdo.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cdo.Datos.Catalogo_Otros_Ingresos;
import cdo.Datos.DetalleOtroIngreso;
import cdo.Datos.EncabezadoOtroIngreso;
import cdo.Datos.Usuario;
import cdo.Datos.Querys;
import cdo.Persistencia.GestorControlIngresos;
import cdo.util.Cls_Log;


public class ControlDeIngresosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static List<Querys>  querys = null;
	private static GestorControlIngresos gestorIngresos;
       
    public ControlDeIngresosServlet() {
        super();
        gestorIngresos = new GestorControlIngresos();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		HttpSession session = request.getSession(false);
		if(session!=null)
		{ 
			this.querys  = (List<Querys>)session.getAttribute("querys");
			verificaPeticionOrigen(request,response, session);
		}  
		else
		{  
			if(session == null){
				System.out.println("Otros Ingresos: Session no valida ");
				request.getRequestDispatcher("/index.jsp").forward(request, response);
				return;
			}
		}  
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	private void verificaPeticionOrigen(HttpServletRequest request, HttpServletResponse response, HttpSession session)
	{
		try
		{
			String vista= String.valueOf(request.getParameter("vista"));	
			String operacion= String.valueOf(request.getParameter("operacion"));
			String datoIncorrecto ="";
			
			switch(vista)
			{
				case "Menu.html":
					String pagina = String.valueOf(request.getParameter("pagina"));	
					session.setAttribute("datoIncorrecto", datoIncorrecto);
					session.setAttribute("exitoInsertar","");
					redireccionarVista(request, response,pagina);
				break;
			
				case "OtrosIngresos.jsp":
					switch(operacion)
					{
						case "ObtenerPrecio":
							String precio= obtienePrecioXConcepto(request, session);
							enviarRespuestaJS(request,response, precio);
						break;
						
						case "IngresaCobroTemporal":
							asignaVariablesCapturadosEnSession(request, session);
							datoIncorrecto= validaDatos(request, "temporal");							
							if(datoIncorrecto.equals(""))
							{
								limpiaVariablesCapturadosEnSession(session);
								ingresaCobroTemporal(request,  session);
							}
							session.setAttribute("exitoInsertar", "");
							session.setAttribute("datoIncorrecto", datoIncorrecto);
							redireccionarVista(request, response,vista);
						break;
						
						case "InsertaIngresosACaja":
							datoIncorrecto = validaDatos(request, "insertar");
							if(datoIncorrecto.equals("")) 
							{
								if(insertarIngreso(request, session))
									session.setAttribute("exitoInsertar", "Datos Guardados Correctamente.");
								else
									session.setAttribute("exitoInsertar", "");
							}
							session.setAttribute("datoIncorrecto", datoIncorrecto);
							redireccionarVista(request, response,vista);
						break;
						
						case "ActualizaPrecio":
							boolean actualizo = actualizaPrecioXConcepto(request, session);
							enviarRespuestaJS(request,response, String.valueOf(actualizo));
							break;
							
						case "InsertaNuevoConcepto":
							
								boolean inserto = insertaConceptoEnBD(request,session);
								if(inserto)
									session.setAttribute("exitoInsertar", "El concepto se guardo ");
								redireccionarVista(request, response,vista);
							break;
					
						case "EliminaConceptoTmpXId":		
							eliminaConceptoTmpXId(request,session);
							redireccionarVista(request, response,vista);
							break;
							
						case "inicializaSemaforo":	
							String valoresSemaforo= session.getAttribute("SemaforoimporteAct") + "&" +
													session.getAttribute("SemaforoimporteMin") + "&" +
													session.getAttribute("SemaforoimporteMax") ;
							enviarRespuestaTextoJS(request, response,valoresSemaforo);
							break;
					}					
				break;
			}		
		}
		catch(Exception ex)
		{
			Usuario infoUsu= (Usuario) session.getAttribute("infoUsu");
			System.out.println("Error al validar la peticion. Detalle:" + ex.getMessage().toString());
			Cls_Log.insertaLog(infoUsu, "", "", "Error al validar la peticion. Detalle: [ " + ex.getMessage().toString()+ "] ");
		}
	}
		
	private void enviarRespuestaJS(HttpServletRequest request, HttpServletResponse response, String respuesta)
	{
		try
		{
			PrintWriter out = response.getWriter();
		    out.write(respuesta);
		}
		catch(Exception ex)
		{
			System.out.println("Error al re-direccionar vista." + ex.getMessage().toString());
		}
	}
	
	private void redireccionarVista(HttpServletRequest request, HttpServletResponse response, String vista)
	{
		try
		{
			RequestDispatcher rdIndex = request.getRequestDispatcher("jsp/" + vista);			    	
		    rdIndex.forward(request, response);
		}
		catch(Exception ex)
		{
			System.out.println("Error al re-direccionar vista." + ex.getMessage().toString());
		}
	}
		
	private  String  obtienePrecioXConcepto(HttpServletRequest request,  HttpSession session)
	{
		String precio = "0";
		Usuario infoUsu= (Usuario) session.getAttribute("infoUsu");
		try
		{
			precio= gestorIngresos.ObtienePrecioXConcepto(session, Integer.parseInt(request.getParameter("concepto")));
		}
		catch(Exception ex)
		{
			System.out.println("Error obtener precio del conpcepto." + ex.getMessage().toString());
			Cls_Log.insertaLog(infoUsu, "", "", "Error obtener precio del conpcepto: [ " + ex.getMessage().toString()+ "] ");
		}
		return precio;
	}
		
	private void ingresaCobroTemporal (HttpServletRequest request,  HttpSession session)
	{
		Usuario infoUsu= (Usuario) session.getAttribute("infoUsu");
		try
		{
			List<DetalleOtroIngreso> ListDetTmpIngresos = new ArrayList<>();
			
			if(session.getAttribute("ListDetTmpIngresos") != null)
				ListDetTmpIngresos = (List<DetalleOtroIngreso>) session.getAttribute("ListDetTmpIngresos");
			
			ListDetTmpIngresos = gestorIngresos.AgregaConceptoDetalleTemporal(request, session, ListDetTmpIngresos, infoUsu);
			
			session.setAttribute("ListDetTmpIngresos", ListDetTmpIngresos);
		}
		catch(Exception ex)
		{
			System.out.println("Error al insertar nuevo concepto Detalle:" + ex.getMessage().toString());
			Cls_Log.insertaLog(infoUsu, "", "", "Error al insertar nuevo concepto Detalle: [ " + ex.getMessage().toString()+ "] ");
		}
	}
	
	private String  validaDatos(HttpServletRequest request,  String tipo)
	{
		if(tipo.equals("temporal"))
		{
			if(Integer.parseInt(request.getParameter("concepto")) == 0)
				return generaMsjRespuesta(1);
			
			if(Double.parseDouble(request.getParameter("precio")) <= 0)
				return generaMsjRespuesta(4);
			
			
			if(Integer.parseInt(request.getParameter("kilos")) == 0)
				return generaMsjRespuesta(3);
			
			if(Integer.parseInt(request.getParameter("cantidad")) == 0)
				return generaMsjRespuesta(2);			
		}
		else if(tipo.equals("insertar"))
		{
			if(Integer.parseInt(request.getParameter("formaPago")) == 0)
				return generaMsjRespuesta(7);
			
			if(Integer.parseInt(request.getParameter("banco")) == 0)
				return generaMsjRespuesta(6);
			
			if(Integer.parseInt(request.getParameter("bancoDeposito")) == 0)
				return generaMsjRespuesta(8);
			
			if(request.getParameter("folioFisico") != "")
			{
				if(Integer.parseInt(request.getParameter("folioFisico")) == 0)
				{
					return generaMsjRespuesta(9);
				}
			}
			else 
			{
				return generaMsjRespuesta(9);
			}
							
			if(request.getParameter("referenciaOI").length() <= 0)
			{
				return generaMsjRespuesta(10);
			}
			
		}
		return "";
	}
	
	private void asignaVariablesCapturadosEnSession(HttpServletRequest request, HttpSession session)
	{
		String ConceptoSession = String.valueOf(request.getParameter("concepto"));
		String PrecioSession = String.valueOf(request.getParameter("precio"));
		String CantidadSession = String.valueOf(request.getParameter("cantidad"));
		String KilosSession = String.valueOf(request.getParameter("kilos"));
		String ImporteSession = String.valueOf(request.getParameter("importe"));
		
		session.setAttribute("ConceptoSession", ConceptoSession);
		session.setAttribute("PrecioSession", PrecioSession);
		session.setAttribute("CantidadSession", CantidadSession);
		session.setAttribute("KilosSession", KilosSession);
		session.setAttribute("ImporteSession", ImporteSession);
	}
	
	private void limpiaVariablesCapturadosEnSession(HttpSession session)
	{
		session.setAttribute("ConceptoSession", "0");
		session.setAttribute("PrecioSession", "0");
		session.setAttribute("CantidadSession", "0");
		session.setAttribute("KilosSession", "1");
		session.setAttribute("ImporteSession", "0");
	}
		
	private String generaMsjRespuesta(int valor)
	{
		String msg = "";
		
		switch(valor)
		{
			case 1:
				msg = "Selecciona un concepto valido";
				break;
			case 2:
				msg = "La cantidad no puede ser 0.";
				break;
			case 3:
				msg = "El numero de kilos no piede ser 0.";
				break;
			case 4:
				msg = "El precio no puede ser 0.";
				break;				
			case 5:
				msg = "Los datos ingresados son incorrectos.";
				break;
			case 6:
				msg = "Selecciona un banco valido.";
				break;				
			case 7:
				msg = "Selecciona una forma de pago valida.";
				break;	
			case 8:
				msg = "Selecciona una banco deposito valido.";
				break;	
				
			case 9:
				msg = "El folio no puede ser 0";
				break;	
				
			case 10:
				msg = "Ingresa una referencia valida.";
				break;	
					
		}
		return msg;
	}
	
	private  boolean insertarIngreso(HttpServletRequest request,  HttpSession session)
	{
		boolean insertoIngresoBD = false;
		Usuario infoUsu= (Usuario) session.getAttribute("infoUsu");
		try
		{
			List<DetalleOtroIngreso> ListDetTmpIngresos = (List<DetalleOtroIngreso>) session.getAttribute("ListDetTmpIngresos");
			
			int folioSiguiente= gestorIngresos.ConsultaFolioSiguienteEnBD(this.querys, infoUsu);
			int cve_forma_pago = Integer.parseInt(request.getParameter("formaPago"));
			int cve_banco = Integer.parseInt(request.getParameter("banco"));
			int cve_banco_deposito = Integer.parseInt(request.getParameter("bancoDeposito"));
			int folio_fisico = Integer.parseInt(request.getParameter("folioFisico"));
			String referencia = request.getParameter("referenciaOI");
			
			EncabezadoOtroIngreso encabezadoOI =new EncabezadoOtroIngreso("", folioSiguiente, null, cve_forma_pago, cve_banco,cve_banco_deposito, "","",0,0, folio_fisico, referencia);
			insertoIngresoBD =gestorIngresos.InsertaIngresoEnBD(this.querys, ListDetTmpIngresos,  infoUsu, null, encabezadoOI);
			
			if(insertoIngresoBD)
			{
				session.removeAttribute("ListDetTmpIngresos");
			}
 		}
		catch (Exception ex)
		{
			System.out.println("Error al insertar otro ingreso. Detalle:" + ex.getMessage().toString());
			Cls_Log.insertaLog(infoUsu, "", "", "Error al insertar otro ingreso. Detalle: [ " + ex.getMessage().toString()+ "] ");
		}
		return insertoIngresoBD;
	}
	
	private boolean actualizaPrecioXConcepto(HttpServletRequest request,  HttpSession session)	
	{
		boolean actualizoIngresoBD = false;
		Usuario infoUsu= (Usuario) session.getAttribute("infoUsu");
		try
		{
			int concepto = Integer.parseInt(request.getParameter("concepto"));
			BigDecimal precio = new BigDecimal(String.valueOf(request.getParameter("precio")));
			String uname_usu = String.valueOf(request.getParameter("uname_usu"));
			
			Catalogo_Otros_Ingresos conceptoOI = new Catalogo_Otros_Ingresos(concepto, "", "", precio, 0, uname_usu); 
			actualizoIngresoBD = gestorIngresos.ActualizaPrecioXConcepto(session, this.querys, conceptoOI, infoUsu);
		}
		catch(Exception ex)
		{
			System.out.println("Error al actualizar el concepto." + ex.getMessage().toString());
			Cls_Log.insertaLog(infoUsu, "", "", "Error al actualizar el concepto.: [ " + ex.getMessage().toString()+ "] ");
		}
		return actualizoIngresoBD;
	}
	
	private boolean insertaConceptoEnBD(HttpServletRequest request,  HttpSession session)
	{
		boolean insertoIngresoBD = false;
		Usuario infoUsu= (Usuario) session.getAttribute("infoUsu");
		try
		{
			BigDecimal precio = new BigDecimal(request.getParameter("precio"));
			String uname_usu = String.valueOf(request.getParameter("uname_usu"));
			
			Catalogo_Otros_Ingresos conceptoOI = new Catalogo_Otros_Ingresos(0, 
																			 String.valueOf(request.getParameter("descripcion")), 
																			 String.valueOf(request.getParameter("reglaContable")), 
																			 precio, 
																			 Integer.parseInt(request.getParameter("modificaPrecio")),
																			 uname_usu);
			
			insertoIngresoBD = gestorIngresos.InsertaNuevoConceptoEnBD(session, this.querys, infoUsu, conceptoOI);
			
		}
		catch(Exception ex)
		{
			System.out.println("Error al insertar el concepto." + ex.getMessage().toString());
			Cls_Log.insertaLog(infoUsu, "", "", "Error al insertar el concepto.: [ " + ex.getMessage().toString()+ "] ");
		}
		return insertoIngresoBD;
	}
	
	private void eliminaConceptoTmpXId(HttpServletRequest request, HttpSession session)
	{
		Catalogo_Otros_Ingresos conceptoOI = new Catalogo_Otros_Ingresos(Integer.parseInt(request.getParameter("conceptoTmp")), 
																		 "", 
																		 "", 
																		 null, 
																		 0,
																		 "");
		gestorIngresos.EliminaConceptoEnListaTmp(session, conceptoOI);
	}
		
	private void enviarRespuestaTextoJS(HttpServletRequest request, HttpServletResponse response, String respuesta)
	{
		try
		{
			PrintWriter out = response.getWriter();
		    out.write(respuesta);
		}
		catch(Exception ex)
		{
			System.out.println("Error al re-direccionar vista." + ex.getMessage().toString());
		}
	}
}
