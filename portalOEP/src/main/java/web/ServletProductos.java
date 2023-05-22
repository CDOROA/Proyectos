package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import datos.Armadoras;
import datos.Articulos;
import datos.Banners;
import datos.CriteriosBusqueda;
import datos.DetalleArticulo;
import datos.QueAutoparteBuscaArticulos;
import datos.Querys;
import datos.SugerenciaBusqueda;
import persistencia.GestorArmadoras;
import persistencia.GestorCarritoDeCompras;
import persistencia.GestorCriteriosBusqueda;
import persistencia.GestorPaginaPrincipal;
import persistencia.GestorProductos;
import util.ConexionBD;

public class ServletProductos extends HttpServlet {
	private static final long serialVersionUID = 1L;
	List<Querys> querys;
	Gson gson=new Gson();
	
	public ServletProductos() {
		super();
		 this.querys = null;
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if(session != null)
		{
			ValidaPeticion(request,response, session);
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

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	public void ValidaPeticion(HttpServletRequest request, HttpServletResponse response,HttpSession session) {
		try {
			session.setAttribute("modalAMostrar", "0");
			int operacion = 1;
			try {
				operacion = Integer.parseInt(request.getParameter("operacion"));
			} catch (Exception ex) {
				String sError = ex.getMessage().toString();

			}
 
			switch (operacion) {
			case 1:
				  /* Carga inicial de Pagina */
				List<Armadoras> listaArmadoras = ObtenListaArmadora();
				request.setAttribute("listaArmadoras", listaArmadoras);
				RedirecionaVista("Productos.jsp", request, response);

				break;
			case 2:
                  /* Consulta Sugerencias */
				Collection<SugerenciaBusqueda> listaSugerencias = consultaSugerenciasBusquedaBxA(request );
				
				String listaJsonSugerencias= gson.toJson(listaSugerencias);
				enviarRespuestaJsonJS(request, response, listaJsonSugerencias);
				break;
			case 3:
				 /* Consulta De articulos */
				List<Articulos> listaArticulos = consultaGeneralArticulos(request, session);
				String listaJsonArticulos= gson.toJson(listaArticulos);

				enviarRespuestaJsonJS(request, response, listaJsonArticulos);
			break;
			case 4:
				 /* Consulta Aplicacion del Producto */
				List<DetalleArticulo> listaDetalleArticulo = consultaDetalleArticulo(request);
				String listaJsonDetalleArticulo= gson.toJson(listaDetalleArticulo);
				enviarRespuestaJsonJS(request, response, listaJsonDetalleArticulo);
				break;
			case 5:
				 /* Ordendar Articulos */
				List<Articulos> listaArticuloOrdenado = ordenarProductosCarritoPorParametro(request, session);
				String listaJsonArticuloOrdenado= gson.toJson(listaArticuloOrdenado);
				enviarRespuestaJsonJS(request, response, listaJsonArticuloOrdenado);
				break;
			case 6:
				 /* carga pagina desde la busqueda de inicio*/
				session.setAttribute("modalAMostrar", "9");
				String descMarca = request.getParameter("armadora");
				String auto = request.getParameter("submarca");
				String modelo = request.getParameter("modelo");
				session.setAttribute("parametrosPaginaInicio", descMarca+"|"+ auto+"|"+modelo);
				List<Armadoras> listaArm = ObtenListaArmadora();
				request.setAttribute("listaArmadoras", listaArm);
				RedirecionaVista("Productos.jsp", request, response);
				 
				break;
			case 7:
				 /* Consulta desde pleca de marca-modelo-año */
				List<Articulos> listaArticulosAuto = consultaArticulosPorAutomovil(request, session);
				String listaArticulosAutoS= gson.toJson(listaArticulosAuto);
				session.removeAttribute("ListaArticulosCarrito");
				session.setAttribute("ListaArticulosCarrito", listaArticulosAutoS);
				//  System.out.println("listaArticulosAutoS: " + listaArticulosAutoS);			
				
				enviarRespuestaJsonJS(request, response, listaArticulosAutoS);
				break;
			case 8:
				 /* Consulta por Grupos */
				List<Articulos> listaArticulosGrupo = consultaArticulosPorGrupo(request, session);
				String listaArticulosGrupoS= gson.toJson(listaArticulosGrupo);
				session.removeAttribute("ListaArticulosCarrito");
				session.setAttribute("ListaArticulosCarrito", listaArticulosGrupoS);
				// System.out.println("listaArticulosGrupoS: " + listaArticulosGrupoS);	
				enviarRespuestaJsonJS(request, response, listaArticulosGrupoS);
				break;
			}
		} catch (Exception ex) {
			String sError = ex.getMessage().toString();
			System.out.println("ServletProductos.- ValidaPeticion: " + ex);
		}

	}
	


	private List<Armadoras> ObtenListaArmadora() {
		Connection connBD = null;
		
		List<Armadoras> listaArmadoras =null;
		try
		{
			connBD = ConexionBD.abrirConexionBD();
			this.querys = null;
			this.querys = GestorPaginaPrincipal.ConsultaTablaQuerysBD(connBD); 
			listaArmadoras = GestorArmadoras.ObtenArmadoras(connBD, this.querys);
		}
		catch(Exception ex)
		{
			String sError= ex.getMessage().toString();
			System.out.println("[ Portal OEP ] ServletPaginaPrincipal.ObtenListaArmadora Error: " + sError);
		}
			finally {
				try {connBD.close();} catch (SQLException e) {e.printStackTrace();}
			}
		return listaArmadoras;
		}

	private List<Articulos> consultaArticulosPorGrupo(HttpServletRequest request, HttpSession session) {
		List<Articulos> listaArticulos = new ArrayList<>();
		GestorProductos gestorProd = new GestorProductos();
		try
		{
			// System.out.println("..1");
 
						String grupo = request.getParameter("grupo");
						// System.out.println("..4 modelo" + modelo);
						listaArticulos= gestorProd.consultaPorGrupo(this.querys,grupo);
		}
	    catch (Exception ex) {
	    	System.out.println("[ Portal OEP ] ServletProductos.consultaArticulosPorGrupo Error: " + ex);
	    }
		return listaArticulos;
	}
	
	private List<Articulos> consultaArticulosPorAutomovil(HttpServletRequest request, HttpSession session) {
		List<Articulos> listaArticulos = new ArrayList<>();
		GestorProductos gestorProd = new GestorProductos();
		CriteriosBusqueda criterio = new CriteriosBusqueda();
		String cBusq = "";
		Connection connBD = null;
		try {
			connBD = ConexionBD.abrirConexionBD();
			this.querys = null;
			this.querys = GestorPaginaPrincipal.ConsultaTablaQuerysBD(connBD);
			
		//	 System.out.println("..1");
			String descMarca = request.getParameter("marca");
			cBusq = "Armadora: " + descMarca.trim();
		//	 System.out.println("..2 descMarca" + descMarca);
			String auto = request.getParameter("submarca");
			cBusq += ". Auto: " + auto.trim();
		//	 System.out.println("..3 auto" + auto);
			String modelo = request.getParameter("modelo");
			cBusq += ". Modelo: " + modelo.trim();
		//	 System.out.println("..4 modelo" + modelo);
			listaArticulos= gestorProd.consultaPorVehiculo(this.querys,descMarca, auto, modelo );
			
			criterio.setTipo("L");
			criterio.setDescripcion(cBusq);
			criterio.setCantidad(1);
			criterio.setTotalResultado(listaArticulos.size());
			GestorCriteriosBusqueda criterios = new GestorCriteriosBusqueda();
			criterios.insertaCriteriosBusqueda(connBD,  this.querys, criterio);
					
			
		} catch (Exception ex) {
			System.out.println("[ Portal OEP ] ServletProductos.consultaArticulosPorAutomovil Error: " + ex);
		}
		finally {
			try {connBD.close();} catch (SQLException e) {e.printStackTrace();}
		}
		return listaArticulos;
	}

	private List<Articulos> ordenarProductosCarritoPorParametro(HttpServletRequest request, HttpSession session) {
		List<Articulos> listaArticulosCarrito = null;
		try {
			listaArticulosCarrito = (List<Articulos>) session.getAttribute("ListaArticulosCarrito");
			String orden = request.getParameter("ordenar");
			GestorProductos gestorProd = new GestorProductos();
			listaArticulosCarrito = gestorProd.ordenarProductosCarritoPorParametro(listaArticulosCarrito, orden);

			session.removeAttribute("ListaArticulosCarrito");
			session.setAttribute("ListaArticulosCarrito", listaArticulosCarrito);

		} catch (Exception ex) {
			System.out.println("[ Portal OEP ] ServletProductos.ordenarProductosCarritoPorParametro Error: " + ex);
		}
		return listaArticulosCarrito;
	}

	/* CONSULTA DE ARTICULOS GENERAL */
	private List<Articulos> consultaGeneralArticulos(HttpServletRequest request, HttpSession session) {
		List<Articulos> listaArticulos = new ArrayList<>();
		CriteriosBusqueda criterio = new CriteriosBusqueda();
	 
		Connection connBD = null;
		try {
			connBD = ConexionBD.abrirConexionBD();
			this.querys = null;
			this.querys = GestorPaginaPrincipal.ConsultaTablaQuerysBD(connBD);
			
			session.removeAttribute("ListaArticulosCarrito");
			GestorProductos gestorProd = new GestorProductos();

			String descArticulo = request.getParameter("desc_articulo");

			listaArticulos = gestorProd.consultaGeneralArticulos(this.querys, descArticulo.toUpperCase());
			if (listaArticulos.size() == 0) {

				GestorCarritoDeCompras gestorCarrito = new GestorCarritoDeCompras();
				listaArticulos = gestorCarrito.consultaGeneralArticulos(this.querys, descArticulo.toUpperCase());
			}
			session.setAttribute("ListaArticulosCarrito", listaArticulos);
			
			
			criterio.setTipo("G");
			criterio.setDescripcion(descArticulo);
			criterio.setCantidad(1);
			criterio.setTotalResultado(listaArticulos.size());
			GestorCriteriosBusqueda criterios = new GestorCriteriosBusqueda();
			criterios.insertaCriteriosBusqueda(connBD,  this.querys, criterio);
			
		} catch (Exception ex) {
			System.out.println("[ Portal OEP ] ServletProductos.consultaGeneralArticulos Error: " + ex);
		}
		finally {
			try {connBD.close();} catch (SQLException e) {e.printStackTrace();}
		}
		
		return listaArticulos;

	}
	
	/* CONSULTA SUGERENCIAS */
	private Collection<SugerenciaBusqueda> consultaSugerenciasBusquedaBxA(HttpServletRequest request)
	{
		Collection<SugerenciaBusqueda> listaArticulos = null;
		try 
		{
			GestorProductos gestorProd = new  GestorProductos();
			String descBusqueda= request.getParameter("descBusqueda");
			listaArticulos = gestorProd.consultaSugerenciasBusquedaBxA(descBusqueda);
		}
		catch(Exception ex)
		{	
			System.out.println("[ Portal OEP ] ServletProductos.consultaSugerenciasBusquedaBxA Error: " + ex);
		}
		return listaArticulos;
	}
	
	private void RedirecionaVista(String pagina, HttpServletRequest request, HttpServletResponse response) {
		try {
			RequestDispatcher rd = request.getRequestDispatcher("/jsp/" + pagina);

			rd.forward(request, response);
		} catch (Exception e) {

		}
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

	private List<DetalleArticulo> consultaDetalleArticulo(HttpServletRequest request) 
	{
		List<DetalleArticulo> listaArticulos = new ArrayList<>(); 
		Connection connBD = null;
		try
		{
			connBD = ConexionBD.abrirConexionBD();
		this.querys = null;
		this.querys = GestorPaginaPrincipal.ConsultaTablaQuerysBD(connBD);
		
	
		GestorProductos gtroProd = new GestorProductos();
		listaArticulos= gtroProd.consultaDetalLeArticulo(connBD, this.querys,request.getParameter("articulo").toString().toUpperCase(),listaArticulos);
		System.out.println("listaArticulos: " + listaArticulos );
		}
		catch(Exception ex)
		{
			String sError= ex.getMessage().toString();
			System.out.println("[ Portal OEP ] ServletProductos.consultaDetalleArticulo Error: " + sError);
		}
			finally {
				try {connBD.close();} catch (SQLException e) {e.printStackTrace();}
			}
		
	return listaArticulos;
	}
	
}
