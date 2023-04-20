 package cdfis.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import cdfis.Datos.DatosCancelacion;
import cdfis.Datos.DatosTemporales;
import cdfis.Datos.Usuario;
import cdfis.Datos.cancelacionComprobante;
import cdfis.Datos.logCancelacion;
import cdfis.Persistencia.ConsumirServicioWeb;
import cdfis.Persistencia.GestorCancelacionCfdi;
import cdfis.Persistencia.GestorCreditoCargo;
import cdfis.Datos.Querys;
import cdfis.Datos.RespuestaUsuario;

public class ServidorCancelarCFDIS extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
		GestorCancelacionCfdi gestorCancelacionCfdis = new GestorCancelacionCfdi();
		GestorCreditoCargo gestorCreditoCargo = new GestorCreditoCargo();
		DatosCancelacion datosCancelacion = new DatosCancelacion();
		
		ConsumirServicioWeb gestorServicioWeb = new ConsumirServicioWeb();
		private static List<Querys> querys =null;
	public ServidorCancelarCFDIS()
	{
		super();
	}

	@SuppressWarnings({ "unused", "unchecked" })
	protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException
	{
		HttpSession session = request.getSession(false);
		if(session!=null)
		{
		this.querys = (List<Querys>) session.getAttribute("querys");
		Gson gson = new Gson();
		java.util.Date date = new java.util.Date();
		java.util.Timer time = new java.util.Timer();
		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");
		java.util.Date utilDate = new java.util.Date();
		long hora = utilDate.getTime();
		java.sql.Time sqlTime = new java.sql.Time(hora);
		Usuario infoUsu = (Usuario) session.getAttribute("infoUsu");
		session.removeAttribute("msj");
		session.removeAttribute("tipo_documento");
		String accion = request.getParameter("cancelar");
		String cve_usu = infoUsu.getCve_usuario();
		String uname = infoUsu.getUname();
		String uname_br = infoUsu.getUname_br();
		String fecha_pro = sdf.format(date);
		String serie = "";
		String accionn="true";
		String tipo_documento = request.getParameter("tipo_doc");
		String documento = request.getParameter("documento");
		String documento_cancelado = request.getParameter("documento");
		Time hora_pro = sqlTime;
		int folio=0;
		int status=0;
		int id_log = 0;
		RespuestaUsuario respuestaSW= new RespuestaUsuario();
		boolean servicioWeb = false;
		boolean valida=false;
		String cdoo=(String) session.getAttribute("cdo");
		String cdo=cdoo.toUpperCase();
		//System.out.println("Acion: "+accion);
		try
		{
			switch (accion) {
			case "Cancelar":
				List<DatosTemporales> listaConsultaFactura = new ArrayList<>();
	
				if(accion.equals("Cancelar")) {
					int contador=0;
				listaConsultaFactura = (List<DatosTemporales>)session.getAttribute("listaConsultaNota");
	//System.out.println("sdfsdfs: "+listaConsultaFactura);
				logCancelacion logCancelacion = new logCancelacion(id_log, tipo_documento, documento_cancelado, accionn, cve_usu, serie, folio, fecha_pro, hora_pro);
				for (DatosTemporales datosTemporales : listaConsultaFactura) 
				{	
					
					String cuenta = datosTemporales.getCuenta().replace(" ", "").replace("\n", "");
					String usuario = datosTemporales.getUsuario().replace(" ", "").replace("\n", "");
					String password = datosTemporales.getPassword().replace(" ", "").replace("\n", "");
					String sucursal = datosTemporales.getSucursal().replace(" ", "").replace("\n", "");
					String uuid = datosTemporales.getUuid().replace(" ", "").replace("\n", "");
					String emisor=datosTemporales.getEmisor().replace(" ", "").replace("\n", "");
					System.out.println("Consumir cuenta: "+cuenta);
					System.out.println("Consumir usuario: "+usuario);
					System.out.println("Consumir password: "+password);
					System.out.println("Consumir sucursal: "+sucursal);
					System.out.println("Consumir emisor: "+emisor);
					System.out.println("Consumir uuid: "+uuid);
					
					if(cuenta==null||(cuenta.replace(" ", "")).length()<=0) {
						valida=false;
					}else {
						respuestaSW = gestorServicioWeb.ConsumirServicioWeb(cuenta,usuario,password,uuid,emisor, sucursal);
					//System.out.println("Respuesta: "+respuestaSW.getRespuestaString());
						valida=true;
					}
					servicioWeb = gestorCancelacionCfdis.insertarLog(respuestaSW, documento_cancelado, logCancelacion,listaConsultaFactura.get(contador),cdo);
					if (servicioWeb) 
					{
						cancelacionComprobante cancelacionComprobante = new cancelacionComprobante(uname, uname_br, tipo_documento, documento_cancelado, serie, folio, status, fecha_pro, hora_pro);
						boolean s=gestorCancelacionCfdis.insertarCancelacion(documento,cancelacionComprobante,listaConsultaFactura.get(contador),cdo);
						if (s) {
							
							//System.out.println("La insercción final se hizo correctamente del documento: "+datosTemporales.getDocumentoacancelar());
							//System.out.println("*************************************************************************************************");
							datosTemporales.setCancelado("Sí");
							session.removeAttribute("listaConsultaNota");
							session.setAttribute("listaConsultaNota", listaConsultaFactura);
						}
						else
						{
							//System.out.println("Hubo problema con la insercción final del documento: "+datosTemporales.getDocumentoacancelar());
						}
					}
					else
					{
				        if (respuestaSW.getRespuestaString().contains("No todos los comprobantes se pueden cancelar")) 
				        {
				        	datosTemporales.setCancelado("Favor de revisar que todos los documentos relacionados a la factura esten cancelados (notas de credito, notas de cargo y pagos)");
						}
						//System.out.println("ERROR en la cancelacion del documento: "+datosTemporales.getDocumentoacancelar());
						//System.out.println("*************************************************************************************************");
					}
					contador++;
				}
				String resp = "1";
				resp = gson.toJson(true);
				EviarRespuestaJsonJS(request,response, resp);
				String msj="";
				if(valida) {
					msj="¡Proceso terminado, verifique el status de cada documento!";
				}else {
					msj="¡Favor de cancelar las notas en el sistema anterior!";
				}
				session.setAttribute("msj", msj);
				RequestDispatcher rdIndex = request.getRequestDispatcher("jsp/" + "Cancelacion.jsp");			    	
				rdIndex.forward(request, response);
			}
				break;
				case "Mostrar":
					if (tipo_documento.equals("1")) 
					{		
						boolean existenciaFactura = gestorCancelacionCfdis.existenciaFactura(documento,cdo,querys,infoUsu);
						if (existenciaFactura) 
						{   
							boolean fechaValidada = gestorCancelacionCfdis.verificarFecha(documento_cancelado, cdo,querys,infoUsu);
						if(fechaValidada)
						{
							boolean sellado = gestorCancelacionCfdis.verificarSelladoFactura(documento,cdo,querys,infoUsu);							
							if (sellado) 
							{
								boolean statusCancelado = gestorCancelacionCfdis.statusCancelado(documento,cdo,querys,infoUsu);
								if (statusCancelado)
								{		
									listaConsultaFactura = (List<DatosTemporales>)session.getAttribute("listaConsultaNota");
									boolean mostrarRegistro  = gestorCancelacionCfdis.validarMostrado(documento,listaConsultaFactura,cdo);
									if (mostrarRegistro) 
									{	
							
										listaConsultaFactura = gestorCancelacionCfdis.consultarFactura(documento,tipo_documento,listaConsultaFactura,servicioWeb,cdo,querys,infoUsu);
										session.setAttribute("listaConsultaNota", listaConsultaFactura);										
										session.setAttribute("tipo_documento", tipo_documento);
										session.setAttribute("mostrarTabla", 1);
										session.setAttribute("msj", "");
										RequestDispatcher rdIndex = request.getRequestDispatcher("jsp/" + "Cancelacion.jsp");			    	
									    rdIndex.forward(request, response);			
									}
									else 
									{
										String msj="LA FACTURA YA ESTA LISTADA"; 
										session.setAttribute("msj",msj);
										RequestDispatcher rdIndex = request.getRequestDispatcher("jsp/" + "Cancelacion.jsp");			    	
									    rdIndex.forward(request, response);
									}
								}
								else
								{
									String msj="LA FACTURA YA ESTA CANCELADA";
									session.setAttribute("msj",msj);
									RequestDispatcher rdIndex = request.getRequestDispatcher("jsp/" + "Cancelacion.jsp");			    	
								    rdIndex.forward(request, response);
								}
							} 
							else 
							{
								String msj="LA FACTURA NO ESTA SELLADA";
								session.setAttribute("msj",msj);
								RequestDispatcher rdIndex = request.getRequestDispatcher("jsp/" + "Cancelacion.jsp");			    	
							    rdIndex.forward(request, response);
							}	
						}
						else 
						{	
							String msj="VERSION INCOMPATIBLE FAVOR DE REALIZAR EN EL SISTEMA ANTERIOR";
							session.setAttribute("msj",msj);
							RequestDispatcher rdIndex = request.getRequestDispatcher("jsp/" + "Cancelacion.jsp");			    	
						    rdIndex.forward(request, response);
						}
					}
					else
					{
						String msj="LA FACTURA NO EXISTE";
						session.setAttribute("msj",msj);
						RequestDispatcher rdIndex = request.getRequestDispatcher("jsp/" + "Cancelacion.jsp");			    	
					    rdIndex.forward(request, response);
					}
				}
				else
				{	
					String tipo_documentos="";
					if (tipo_documento.equals("2"))
					{
						tipo_documentos="NOTA DE CREDITO";
					}
					if (tipo_documento.equals("3"))
					{
						tipo_documentos="NOTA DE CARGO";
					}
						boolean existenciaNota = gestorCreditoCargo.existenciaNota(querys,infoUsu,documento_cancelado,tipo_documento,cdo);
						if (existenciaNota) 
						{	
							boolean fechaValidada = gestorCancelacionCfdis.verificarFechaNota(querys,infoUsu,documento_cancelado, cdo,tipo_documento);
							if(fechaValidada)
							{
								boolean sellado = gestorCreditoCargo.verificarSelladoNota(querys,infoUsu,documento_cancelado,tipo_documento,cdo);
								if(sellado) 
								{
									boolean statusCancelado = gestorCancelacionCfdis.statusCancelado(documento,cdo,querys,infoUsu);
									if (statusCancelado)
									{		
										List<DatosTemporales> listaConsultaNota = new ArrayList<>();
										listaConsultaNota = (List<DatosTemporales>)session.getAttribute("listaConsultaNota");
										listaConsultaFactura = (List<DatosTemporales>)session.getAttribute("listaConsultaNota");
										boolean mostrarRegistro  = gestorCancelacionCfdis.validarMostrado(documento,listaConsultaFactura,cdo);
										if (mostrarRegistro) 
										{
									
											listaConsultaNota = gestorCreditoCargo.consultarNotas(documento_cancelado,tipo_documento,listaConsultaNota,cdo,querys,infoUsu);
											session.setAttribute("listaConsultaNota", listaConsultaNota);
											session.setAttribute("tipo_documento", tipo_documento);
											session.setAttribute("mostrarTabla", 1);
											session.setAttribute("msj", "");
											RequestDispatcher rdIndex = request.getRequestDispatcher("jsp/" + "Cancelacion.jsp");			    	
											rdIndex.forward(request, response);
										}
										else 
										{
											String msj="LA "+tipo_documentos+" YA ESTA LISTADA";
											session.setAttribute("msj",msj);
											RequestDispatcher rdIndex = request.getRequestDispatcher("jsp/" + "Cancelacion.jsp");			    	
										    rdIndex.forward(request, response);
										}
									}
									else
									{
										String msj="LA "+tipo_documentos+" YA ESTA CANCELADA";
										session.setAttribute("msj",msj);
										RequestDispatcher rdIndex = request.getRequestDispatcher("jsp/" + "Cancelacion.jsp");			    	
										rdIndex.forward(request, response);
									}
								} 
								else 
								{
									String msj="LA "+tipo_documentos+" NO ESTA SELLADA";
									session.setAttribute("msj",msj);
									RequestDispatcher rdIndex = request.getRequestDispatcher("jsp/" + "Cancelacion.jsp");			    	
									rdIndex.forward(request, response);
								}	
							}
							else 
							{	
								String msj="VERSION INCOMPATIBLE FAVOR DE REALIZAR EN EL SISTEMA ANTERIOR";
								session.setAttribute("msj",msj);
								RequestDispatcher rdIndex = request.getRequestDispatcher("jsp/" + "Cancelacion.jsp");			    	
								rdIndex.forward(request, response);
							}
						}
						else
						{
							String msj="LA "+tipo_documentos+" NO EXISTE";
							session.setAttribute("msj",msj);
							RequestDispatcher rdIndex = request.getRequestDispatcher("jsp/" + "Cancelacion.jsp");			    	
							rdIndex.forward(request, response);
						}
					}
				break;
				case "Eliminar":
					session.setAttribute("msj", "");
					session.removeAttribute("listaCancelacion");
					String valorrr=request.getParameter("documentoEliminar");
					listaConsultaFactura = (List<DatosTemporales>)session.getAttribute("listaConsultaNota");
					gestorCancelacionCfdis.eliminarRegistro(listaConsultaFactura,valorrr,cdo);
					session.setAttribute("tipo_documento", tipo_documento);
					if (listaConsultaFactura.size() == 0) 
					{
						session.setAttribute("mostrarTabla", "");
					}
						RequestDispatcher rdIndex = request.getRequestDispatcher("jsp/" + "Cancelacion.jsp");			    	
						rdIndex.forward(request, response);
						session.setAttribute("msj", "");
				break;
				case "Limpiar":
					session.setAttribute("msj", "");
					session.removeAttribute("listaCancelacion");
					listaConsultaFactura = (List<DatosTemporales>)session.getAttribute("listaConsultaNota");
					gestorCancelacionCfdis.limpiarTabla(listaConsultaFactura,cdo);
					session.setAttribute("tipo_documento", tipo_documento);
					session.setAttribute("msj", "");
					session.setAttribute("mostrarTabla", "");
					RequestDispatcher rdIndexx = request.getRequestDispatcher("jsp/" + "Cancelacion.jsp");			    	
					rdIndexx.forward(request, response);
				break;
				default:
					request.getRequestDispatcher("ServidorCancelarCFDIS?cancelar=Cancelar").forward(request, response);
				break;
			}
			}
			catch (NullPointerException ex) 
			{
				//System.out.println("Exception null: "+ex);
			}
		}  
		
		else
		{  
			if(session == null){
				System.out.println("SESSION INVALIDA. CANCELACION CFDIS");
				request.getRequestDispatcher("/index.jsp").forward(request, response);
				return;
			}
		}
	}

	public void EviarRespuestaJsonJS(HttpServletRequest request, HttpServletResponse response, String resp)
	{
		try
		{
			response.setContentType("application/json");
			PrintWriter out = response.getWriter();
			out.write(resp);	
		}
		catch(Exception ex)
		{
			//System.out.println("Error al re-direccionar vista." + ex.getMessage().toString());
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {doGet(request, response);}

}
