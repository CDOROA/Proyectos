package cdo.Web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

 
import cdo.Datos.Articulos;
import cdo.Datos.CdosTraspasosEmergencia;
import cdo.Datos.DetalleArticulo;
import cdo.Datos.ExistenciasPorCDO;
 
import cdo.Datos.InfoCliente;
import cdo.Datos.LineasDescuentoFijo;
import cdo.Datos.Log;
import cdo.Datos.Querys;
import cdo.Datos.SubMarcas;
import cdo.Datos.SugerenciaBusqueda;
import cdo.ManejoErrores.ManejadorErrPersistencia;
import cdo.ManejoErrores.PersistenciaException;
import cdo.Persistencia.GestorCarritoDeCompras;
import cdo.Persistencia.GestorCarritoDeComprasV3;
import cdo.Persistencia.GestorPaginaPrincipal;
import cdo.Util.Cls_Log;

public class CarritoDeComprasServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	GestorPaginaPrincipal gestorInicial;
	GestorCarritoDeCompras gestorCarrito;
	GestorCarritoDeComprasV3 gestorCarritoV3;
	List<Querys> querys;
  
    public CarritoDeComprasServlet() 
    {
        super();
        gestorInicial=new GestorPaginaPrincipal();
        gestorCarrito= new GestorCarritoDeCompras();
        gestorCarritoV3= new GestorCarritoDeComprasV3();
        this.querys = null;
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
	response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
	response.setHeader("Expires", "-1"); // Proxies.
		HttpSession session = request.getSession(false);
		if(session != null)
		{
			
			this.querys = this.querys = gestorInicial.ConsultaTablaQuerysBD();
			verificaPeticionOrigen(request,response, session);
		}
		else
		{
			if(session == null)
			{
				//System.out.println("Carrito de Compras: Session no valida");
				request.getRequestDispatcher("/index.jsp").forward(request, response);
				return;
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doGet(request, response);
	}
	
	private void verificaPeticionOrigen(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws ServletException, IOException
	{
		String vistaOrigen= String.valueOf(request.getParameter("vista"));
		String operacion = String.valueOf(request.getParameter("operacion"));
		Gson gson=new Gson();
		

		switch(vistaOrigen)
		{
			case "CarritoDeCompras.jsp":
				switch(operacion)
				{
					case "ConsultaArticulos":
						List<Articulos> listaArticulos = consultaGeneralArticulos(request, session);
						String listaJsonArticulos= gson.toJson(listaArticulos);
						//  System.out.println("LISTA ART: " + listaJsonArticulos);
						enviarRespuestaJsonJS(request, response, listaJsonArticulos);
					break;
					
					case "ConsultaArticulosMarcaCalidad":
						List<Articulos> listaArticulosMarca = consultaArticulosXMarca(request, session);
						String listaJsonArticulosMarcas= gson.toJson(listaArticulosMarca);
						enviarRespuestaJsonJS(request, response, listaJsonArticulosMarcas);
					break;
					case "ConsultaPorVeiculo":
						List<Articulos> listaArticulosAuto = consultaArticulosXAutomovil(request, session);
						String listaJsonArticulosAuto= gson.toJson(listaArticulosAuto);
						enviarRespuestaJsonJS(request, response, listaJsonArticulosAuto);
					break;
					
					case "OrdenarArticulosCarrito":
						List<Articulos> listaArticulosOrden = ordenarProductosCarritoPorParametro(request, session);
						String listaJsonArticulosOrden= gson.toJson(listaArticulosOrden);
						enviarRespuestaJsonJS(request, response, listaJsonArticulosOrden);
					break;
					
					case "ConsultaSubMarcas":
						List<SubMarcas> listaSubMarcas = consultaSubmarcas(request, session);
						String listaJsonSubMarcas= gson.toJson(listaSubMarcas);
						enviarRespuestaJsonJS(request, response, listaJsonSubMarcas);
					break;
					
					case "ConsultaSugerencias":
					//	List<Articulos> listaSugerencias = consultaSugerenciasBusqueda(request, session);
						
					//	String listaJsonSugerencias= gson.toJson(listaSugerencias);
					//	enviarRespuestaJsonJS(request, response, listaJsonSugerencias);
						
					//	Collection<SugerenciaBusqueda> listaSugerencias = consultaSugerenciasBusquedaSolr(request, session);
						
						Collection<SugerenciaBusqueda> listaSugerencias = consultaSugerenciasBusquedaBxA(request, session);
						String listaJsonSugerencias= gson.toJson(listaSugerencias);
						enviarRespuestaJsonJS(request, response, listaJsonSugerencias);
					break;
					
					case "ConsultaExistenciaArticulo":
					 
						ExistenciasPorCDO  existenciaArtCDO = consultaExistenciasPorArticulo(request, session);
						String listaJsonExistencia= gson.toJson(existenciaArtCDO);
					 
						enviarRespuestaJsonJS(request, response, listaJsonExistencia);
					break;
					case "ConsultaDetalleArticulo":
						List<DetalleArticulo> listaDetalleArticulo = consultaDetalleArticulo(request, session);
						String listaJsonDetalleArticulo= gson.toJson(listaDetalleArticulo);
						enviarRespuestaJsonJS(request, response, listaJsonDetalleArticulo);
					break;
					case "ConsultaArticuloMarcaPropia":
						List<Articulos> listaArticuloM = consultaArticulo(request, session);
						String listaJsonArticuloM= gson.toJson(listaArticuloM);
						enviarRespuestaJsonJS(request, response, listaJsonArticuloM);
					break;
					case "ArticulosNuevos":
						List<Articulos> listaArticulosAutoNuevos = consultaArticulosNuevos(request, session);
						String listaJsonArticulosAutoNuevos= gson.toJson(listaArticulosAutoNuevos);
						enviarRespuestaJsonJS(request, response, listaJsonArticulosAutoNuevos);
					break;
				}
				break;
		}
	}	
	

	
	private List<DetalleArticulo> consultaDetalleArticulo(HttpServletRequest request, HttpSession session) 
	{
		List<DetalleArticulo> listaArticulos = new ArrayList<>(); 
		InfoCliente cliente = (InfoCliente) session.getAttribute("infoCliente");
		listaArticulos= gestorCarrito.consultaDetalLeArticulo(this.querys,cliente,request.getParameter("articulo").toString().toUpperCase(),listaArticulos);
		if (listaArticulos.size()==0) 
		{
			listaArticulos= gestorCarrito.consultaDetalLeArticulo(this.querys,cliente,request.getParameter("art_prov").toString().toUpperCase(),listaArticulos);	
		}
		return listaArticulos;
	}
	
	/* CONSULTA SUGERENCIAS */
	private List<Articulos> consultaSugerenciasBusqueda(HttpServletRequest request,HttpSession session)
	{
		InfoCliente cliente = (InfoCliente) session.getAttribute("infoCliente");
		String descBusqueda= request.getParameter("descBusqueda");
		List<Articulos> listaArticulos = gestorCarrito.consultaSugerenciasBusqueda(this.querys,descBusqueda,cliente);
		return listaArticulos;
	}
	
	/* CONSULTA SUGERENCIAS POR SOLR */
	private Collection<SugerenciaBusqueda> consultaSugerenciasBusquedaSolr(HttpServletRequest request,HttpSession session)
	{
		InfoCliente cliente = (InfoCliente) session.getAttribute("infoCliente");
		String descBusqueda= request.getParameter("descBusqueda");
		Collection<SugerenciaBusqueda> listaArticulos = gestorCarrito.consultaSugerenciasBusquedaSolr(this.querys,descBusqueda,cliente);
		return listaArticulos;
	}

	/* CONSULTA SUGERENCIAS */
	private Collection<SugerenciaBusqueda> consultaSugerenciasBusquedaBxA(HttpServletRequest request,HttpSession session)
	{
		InfoCliente cliente = (InfoCliente) session.getAttribute("infoCliente");
		String descBusqueda= request.getParameter("descBusqueda");
		Collection<SugerenciaBusqueda> listaArticulos = gestorCarrito.consultaSugerenciasBusquedaBxA(this.querys,descBusqueda,cliente);
		return listaArticulos;
	}
	
	/* CONSULTA DE ARTICULOS GENERAL */
	private List<Articulos> consultaGeneralArticulos( HttpServletRequest request,HttpSession session)
	{
		List<Articulos> listaArticulos = new ArrayList<>();
		try
		{
		session.removeAttribute("ListaArticulosCarrito");
		 
		InfoCliente cliente = (InfoCliente) session.getAttribute("infoCliente");
		List<LineasDescuentoFijo> lineasDesFijo= (List<LineasDescuentoFijo>) session.getAttribute("lineasDescuentoFijo");
		List<CdosTraspasosEmergencia> listaCdosTraspaso = (List<CdosTraspasosEmergencia>) session.getAttribute("cdos_traspaso_emergencia");
		String descArticulo = request.getParameter("desc_articulo");
		listaArticulos= gestorCarritoV3.consultaGeneralArticulos(this.querys,cliente, descArticulo.toUpperCase(), lineasDesFijo, listaCdosTraspaso);
		 // System.out.println(" listaArticulos.size:" +  listaArticulos.size());
		if ( listaArticulos.size() == 0 )
		{
 
			listaArticulos= gestorCarrito.consultaGeneralArticulos(this.querys,cliente, descArticulo.toUpperCase(), lineasDesFijo, listaCdosTraspaso);
 
		}

		session.setAttribute("ListaArticulosCarrito", listaArticulos);
		
		}
		catch (Exception e) {
			listaArticulos = new ArrayList<Articulos>();
			Articulos art = new Articulos();
			listaArticulos.add(art);
		}
		return listaArticulos;
	}
	
	/* CONSULTA DE ARTICULOS Nuevo */
	private List<Articulos> consultaArticulosNuevos( HttpServletRequest request,HttpSession session)
	{
		List<Articulos> listaArticulos = new ArrayList<>();
		try
		{
		session.removeAttribute("ListaArticulosCarrito");
 	
		InfoCliente cliente = (InfoCliente) session.getAttribute("infoCliente");
		List<LineasDescuentoFijo> lineasDesFijo= (List<LineasDescuentoFijo>) session.getAttribute("lineasDescuentoFijo");
		List<CdosTraspasosEmergencia> listaCdosTraspaso = (List<CdosTraspasosEmergencia>) session.getAttribute("cdos_traspaso_emergencia");
		listaArticulos= gestorCarrito.consultaArtNuevos(this.querys,cliente, lineasDesFijo, listaCdosTraspaso);
		 
		session.setAttribute("ListaArticulosCarrito", listaArticulos);
		}
		catch (Exception e) {
			Articulos art = new Articulos();
			listaArticulos.add(art);
		}
		return listaArticulos;
	}
	
	
	/* CONSULTA DE ARTICULOS POR MARCAS DE CALIDAD */
	private List<Articulos> consultaArticulosXMarca( HttpServletRequest request,HttpSession session)
	{
		session.removeAttribute("ListaArticulosCarrito");
		List<Articulos> listaArticulos = new ArrayList<>(); 	
		InfoCliente cliente = (InfoCliente) session.getAttribute("infoCliente");
		List<LineasDescuentoFijo> lineasDesFijo= (List<LineasDescuentoFijo>) session.getAttribute("lineasDescuentoFijo");
		List<CdosTraspasosEmergencia> listaCdosTraspaso = (List<CdosTraspasosEmergencia>) session.getAttribute("cdos_traspaso_emergencia");
		
		String descMarca = request.getParameter("marca");
		listaArticulos= gestorCarrito.consultaPorMarcaArticulos(this.querys,cliente, descMarca, lineasDesFijo, listaCdosTraspaso);
		
		session.setAttribute("ListaArticulosCarrito", listaArticulos);
		return listaArticulos;
	}
			
	/* CONSULTA DE ARTICULOS POR MARCAS DE CALIDAD */
	private List<Articulos> consultaArticulosXAutomovil( HttpServletRequest request,HttpSession session)
	{
		session.removeAttribute("ListaArticulosCarrito");
		List<Articulos> listaArticulos = new ArrayList<>(); 	
		InfoCliente cliente = (InfoCliente) session.getAttribute("infoCliente");
		List<LineasDescuentoFijo> lineasDesFijo= (List<LineasDescuentoFijo>) session.getAttribute("lineasDescuentoFijo");
		List<CdosTraspasosEmergencia> listaCdosTraspaso = (List<CdosTraspasosEmergencia>) session.getAttribute("cdos_traspaso_emergencia");
		String descMarca = request.getParameter("armadora");
		String auto = request.getParameter("submarca");
		String modelo = request.getParameter("modelo");
		String cilindros = request.getParameter("cilindros");
		String litros = request.getParameter("litros");
		listaArticulos= gestorCarrito.consultaPorVehiculo(this.querys,cliente, descMarca, auto, modelo, cilindros ,litros,  lineasDesFijo, listaCdosTraspaso);
		
		session.setAttribute("ListaArticulosCarrito", listaArticulos);
		return listaArticulos;
	}
	
	/* CONSULTA DE SUBMARCAS */
	private List<SubMarcas> consultaSubmarcas( HttpServletRequest request,HttpSession session)
	{
		List<SubMarcas> listSubMarcas= new ArrayList<>();
		try
		{
		InfoCliente cliente = (InfoCliente) session.getAttribute("infoCliente");
		String cve_armadora = request.getParameter("cve_armadora");
		listSubMarcas = gestorCarrito.obtieneSubMarcas(this.querys, cve_armadora,cliente );
		}
		catch (Exception e) {
			
			SubMarcas submarca = new SubMarcas();
			submarca.setCve_submarca(0);
			submarca.setNombre_submarca("");
			listSubMarcas.add(submarca);
			
		}
		return listSubMarcas;		
	}
	
	private List<Articulos> ordenarProductosCarritoPorParametro( HttpServletRequest request,HttpSession session )
	{
		List<Articulos> listaArticulosCarrito = (List<Articulos>) session.getAttribute("ListaArticulosCarrito");
		String orden=request.getParameter("ordenar");		
		listaArticulosCarrito= gestorCarrito.ordenarProductosCarritoPorParametro(listaArticulosCarrito, orden);
		session.removeAttribute("ListaArticulosCarrito");
		session.setAttribute("ListaArticulosCarrito", listaArticulosCarrito);
		return listaArticulosCarrito;
	}
	
	/* CONSULTA EXISTENCIA POR ARTICULO */	
	private ExistenciasPorCDO consultaExistenciasPorArticulo(HttpServletRequest request,HttpSession session )
	{
		InfoCliente cliente = (InfoCliente) session.getAttribute("infoCliente");
		String num_articulo = request.getParameter("num_articulo");
		int cant_pedida = Integer.parseInt(request.getParameter("cant_pedida"));
		ExistenciasPorCDO existenciaArtCDO = null;
		try {
			 
				existenciaArtCDO = gestorCarrito.ConsutkaExistenciaArticuloWS(this.querys, cliente, num_articulo, cant_pedida);
			 
				 Log log=new Log(01,cliente.getCve_cdo(),cliente.getCve_cliente() ,0, "URL_WS_EXISTENCIAS 17.- se enviara la siguiente informacion a ajax del clientes: " + existenciaArtCDO);
				 Cls_Log.insertaLog(log);
 
		} catch (Exception ex) {
			existenciaArtCDO = new  ExistenciasPorCDO();
			existenciaArtCDO.setNum_art(num_articulo);
			existenciaArtCDO.setCantidadPedida(cant_pedida);
			existenciaArtCDO.setCdoMacro("");
			existenciaArtCDO.setCdoMacroDescripcion("");
			existenciaArtCDO.setCdoBr("");
			existenciaArtCDO.setCdoBrDescripcion("");
			
			existenciaArtCDO.setCdoTraspaso("");
			existenciaArtCDO.setCdoTraspasoDescripcion("");
			existenciaArtCDO.setExietnciaCDO(0);
			existenciaArtCDO.setExistenciaBR(0);
			existenciaArtCDO.setExietnciaTraspaso(0);
			existenciaArtCDO.setExistenciaCompleta(true);
			existenciaArtCDO.setArticuloBloqueo72hrs("N");
			existenciaArtCDO.setArticuloBloqueoExpress("N");
		}	
		return existenciaArtCDO;
	}
	
	/* CONSULTA DE ARTICULO Marca Propia */
	private List<Articulos> consultaArticulo( HttpServletRequest request,HttpSession session)
	{
		session.removeAttribute("ListaArticulosCarrito");
		List<Articulos> listaArticulos = new ArrayList<>(); 
		InfoCliente cliente = (InfoCliente) session.getAttribute("infoCliente");
		List<LineasDescuentoFijo> lineasDesFijo= (List<LineasDescuentoFijo>) session.getAttribute("lineasDescuentoFijo");
		List<CdosTraspasosEmergencia> listaCdosTraspaso = (List<CdosTraspasosEmergencia>) session.getAttribute("cdos_traspaso_emergencia");
		String descArticulo = request.getParameter("desc_articulo");
		listaArticulos= gestorCarrito.consultaArticulo(this.querys,cliente, descArticulo.toUpperCase(), lineasDesFijo, listaCdosTraspaso);
		session.setAttribute("ListaArticulosCarrito", listaArticulos);
		
		return listaArticulos;
	}
	
	/* RESPUESTAS AJAX */	
	private void enviarRespuestaJsonJS(HttpServletRequest request, HttpServletResponse response, String listaJson)
	{
		try
		{
			response.setContentType("application/json");
			PrintWriter out = response.getWriter();
			out.write(listaJson);	
		}
		catch(Exception ex)
		{
			//System.out.println("Error al re-direccionar vista." + ex.getMessage().toString());
		}
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
			//System.out.println("Error al re-direccionar vista." + ex.getMessage().toString());
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
			//System.out.println("Error al re-direccionar vista." + ex.getMessage().toString());
		}
	}
	
}
