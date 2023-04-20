package cdo.Persistencia;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.eclipse.jdt.internal.compiler.codegen.ObjectCache;
import org.json.JSONArray;
import org.json.JSONObject;

import cdo.Datos.Choferes;
import cdo.Datos.ClientesCredito;
import cdo.Datos.Consecutivo;
import cdo.Datos.Corte;
import cdo.Datos.Credito;
import cdo.Datos.LogAlmacen;
import cdo.Datos.MarcadoClientes;
import cdo.Datos.PedidosConsulta;
import cdo.Datos.PedidosConsultaRC;
import cdo.Datos.Querys;
import cdo.Datos.Rutas;
import cdo.Datos.SeriesCfdi;
import cdo.Datos.TrayectoDatos;
import cdo.Datos.Usuario;
import cdo.Datos.VariosTickets;
import cdo.util.Cls_CrearTicketDeIngresos;
import cdo.util.Cls_Querys;
import cdo.util.ConexionBD;
import cdo.util.EjecutaQuerysBD;
import cdo.util.GenerarCorte;
import cdo.util.InsertarLogAlamacen;

public class GestorPedidos extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private Client cliente = null;
	private  static Properties properties = null;
	private static final String URL_INSERTA_ENCABEZADO_RC = "http://desweb:8080/wsTrasladoRCs/ws/traslado/insertaEncabezado";
	private static final String URL_INSERTA_DETALLE_RC = "http://desweb:8080/wsTrasladoRCs/ws/traslado/insertaDetalle";
	
	static 
	{
	      try  
	      {
	    	  properties = new Properties();
		      InputStream  inputStreamWs  = GestorPedidos.class.getClassLoader().getResourceAsStream("/properties/configuracion.properties");
		      properties.load(inputStreamWs);
	      }
	      catch  (Exception ex) 
	      {
	        ex.printStackTrace();
	      }
	 }
	
	
	public GestorPedidos(){
		super();
	}
	
	@Override
    public void init() throws ServletException {
    	super.init();
    	this.cliente = ClientBuilder.newClient();
    }
    
	@Override
	public void destroy() {
		this.cliente.close();
		super.destroy();
	}
	
	public List<MarcadoClientes> consultaMarcadoClientes(String cdo, String hora, HttpSession session,String cve_usu, String uname_br, String nivel, List<Querys> ListaQuerys, Usuario infoUsu, List<MarcadoClientes> lstMarcado, String ruta, String tipo, String fechaFin, String fechaInicio,String odes) 
	{
		Connection connBD = null;
		PreparedStatement pstm = null;
		connBD = ConexionBD.AbrirConexionBDD(cdo);
		String [] querys = new String [25];
		try
		{
			querys = Cls_Querys.LimpiaListaQuerys(querys);
			querys = Cls_Querys.ObtieneQuerys(53, ListaQuerys, querys, infoUsu);
			querys = InicializaQueryNumero53(querys, infoUsu,"","",session.getAttribute("session_br").toString(),cdo.toUpperCase(),"","",fechaFin,fechaInicio,odes);
//			System.out.println(querys[0]);
			pstm = connBD.prepareStatement("{call " + "ALMACEN.usp_EXECUTE_QUERY(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			
			Cls_Querys.ImprimeQuerysConsola(querys, false, "Query 53.- marcado de clientes para carta porte"); 
			
			ResultSet rs = EjecutaQuerysBD.EjecutarQuery(querys[0], querys[1],querys[2], querys[3], querys[4], querys[5], querys[6],
					 querys[7], querys[8], querys[9],querys[10], querys[11], querys[12], querys[13], 
					 querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], 
					 querys[21], querys[22], querys[23], querys[24], infoUsu.getUname(),pstm, connBD,infoUsu);
			InsertarLogAlamacen.insertarLog(new LogAlmacen("","",""),infoUsu.getUname(),infoUsu.getUname_br(),"Consulta de marcado de clientes. Qry["+Qry(seprado(querys))+"]"+". Usuario: "+session.getAttribute("name").toString()+". Maquina: "+session.getAttribute("maquina").toString()+". Ip: "+session.getAttribute("ip").toString(),infoUsu.getCve_usuario());
			if (rs != null)
			{
				lstMarcado = llenarMarcadoClientes(rs,lstMarcado,session,infoUsu);
			}
		}
		catch (Exception e) 
		{
			InsertarLogAlamacen.insertarLog(new LogAlmacen("","",""),infoUsu.getUname(),infoUsu.getUname_br(),"Error en consulta de marcado de clientes. DETALLE: "+Error(e)+". Qry["+Qry(seprado(querys))+"]"+" Usuario: "+session.getAttribute("name").toString()+". Maquina: "+session.getAttribute("maquina").toString()+". Ip: "+session.getAttribute("ip").toString(),infoUsu.getCve_usuario());
		}
		finally 
		{
			try 
			{
				connBD.close();
				pstm.close();
			} catch (Exception e2)
			{
				InsertarLogAlamacen.insertarLog(new LogAlmacen("","",""),infoUsu.getUname(),infoUsu.getUname_br(),"Error al cerrar conexion y pstm consulta de marcado de clientes. DETALLE: "+Error(e2)+". Usuario: "+session.getAttribute("name").toString()+". Maquina: "+session.getAttribute("maquina").toString()+". Ip: "+session.getAttribute("ip").toString(),infoUsu.getCve_usuario());
			}
		}
		
		return lstMarcado;
	}
	private List<MarcadoClientes> llenarMarcadoClientes(ResultSet rs, List<MarcadoClientes> lstMarcado, HttpSession session, Usuario infoUsu) 
	{
		try
		{
			int aux = 0;
			while (rs.next()) 
			{
				
				MarcadoClientes objMarcado = new MarcadoClientes();
				
				objMarcado.setId(""+aux+++"");
				objMarcado.setRuta(rs.getString("ruta").replace("(","").replace(")", ""));
				objMarcado.setCliente(rs.getString("cte"));
				objMarcado.setFacturas(rs.getString("facturas"));
				objMarcado.setAcumuladores(rs.getString("acumuladores"));
				objMarcado.setAtados(rs.getString("atados"));
				objMarcado.setBolsas(rs.getString("bolsas"));
				objMarcado.setCajas(rs.getString("cajas"));
				objMarcado.setOtros(rs.getString("otros"));
				objMarcado.setPaquetes(rs.getString("paquetes"));
				objMarcado.setPeso(rs.getString("peso"));
				objMarcado.setTarimas(rs.getString("tarimas"));
				objMarcado.setDireccion(rs.getString("direccion"));
				lstMarcado.add(objMarcado);
			}
		}
		catch (Exception e) 
		{
			InsertarLogAlamacen.insertarLog(new LogAlmacen("","",""),infoUsu.getUname(),infoUsu.getUname_br(),"Error al llenar marcado de clientes. DETALLE: "+Error(e)+". Usuario: "+session.getAttribute("name").toString()+". Maquina: "+session.getAttribute("maquina").toString()+". Ip: "+session.getAttribute("ip").toString(),infoUsu.getCve_usuario());
		}
		
		return lstMarcado;
	}
	
	public List<MarcadoClientes> consultaMarcadoClientesRC(String cdo, String hora, HttpSession session,String cve_usu, String uname_br, String nivel, List<Querys> ListaQuerys, Usuario infoUsu, List<MarcadoClientes> lstMarcado, String ruta, String tipo, String fechaFin, String fechaInicio,String facturas) 
	{
		Connection connBD = null;
		PreparedStatement pstm = null;
		connBD = ConexionBD.AbrirConexionBDD(cdo);
		String [] querys = new String [25];
		try
		{
			querys = Cls_Querys.LimpiaListaQuerys(querys);
			querys = Cls_Querys.ObtieneQuerys(72, ListaQuerys, querys, infoUsu);
			querys = InicializaQueryNumero72(querys, infoUsu,"","",session.getAttribute("session_br").toString(),cdo.toUpperCase(),"","",fechaFin,fechaInicio,facturas);
//			System.out.println(querys[0]);
			pstm = connBD.prepareStatement("{call " + cdo.toUpperCase()+".usp_EXECUTE_QUERY(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			
			Cls_Querys.ImprimeQuerysConsola(querys, false, "Query 72.- marcado de clientes para carta porte"); 
			
			ResultSet rs = EjecutaQuerysBD.EjecutarQuery(querys[0], querys[1],querys[2], querys[3], querys[4], querys[5], querys[6],
					 querys[7], querys[8], querys[9],querys[10], querys[11], querys[12], querys[13], 
					 querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], 
					 querys[21], querys[22], querys[23], querys[24], infoUsu.getUname(),pstm, connBD,infoUsu);
			InsertarLogAlamacen.insertarLog(new LogAlmacen("","",""),infoUsu.getUname(),infoUsu.getUname_br(),"Consulta de marcado de clientes. Qry["+Qry(seprado(querys))+"]"+". Usuario: "+session.getAttribute("name").toString()+". Maquina: "+session.getAttribute("maquina").toString()+". Ip: "+session.getAttribute("ip").toString(),infoUsu.getCve_usuario());
			if (rs != null)
			{
				lstMarcado = llenarMarcadoClientesRC(rs,lstMarcado,session,infoUsu);
			}
		}
		catch (Exception e) 
		{
			InsertarLogAlamacen.insertarLog(new LogAlmacen("","",""),infoUsu.getUname(),infoUsu.getUname_br(),"Error en consulta de marcado de clientes. DETALLE: "+Error(e)+". Qry["+Qry(seprado(querys))+"]"+" Usuario: "+session.getAttribute("name").toString()+". Maquina: "+session.getAttribute("maquina").toString()+". Ip: "+session.getAttribute("ip").toString(),infoUsu.getCve_usuario());
		}
		finally 
		{
			try 
			{
				pstm.close();
				connBD.close();
			} catch (Exception e2)
			{
				InsertarLogAlamacen.insertarLog(new LogAlmacen("","",""),infoUsu.getUname(),infoUsu.getUname_br(),"Error al cerrar conexion y pstm consulta de marcado de clientes. DETALLE: "+Error(e2)+". Usuario: "+session.getAttribute("name").toString()+". Maquina: "+session.getAttribute("maquina").toString()+". Ip: "+session.getAttribute("ip").toString(),infoUsu.getCve_usuario());
			}
		}
		
		return lstMarcado;
	}
	
	private List<MarcadoClientes> llenarMarcadoClientesRC(ResultSet rs, List<MarcadoClientes> lstMarcado, HttpSession session, Usuario infoUsu) 
	{
		try
		{
			int aux = 0;
			while (rs.next()) 
			{
				
				MarcadoClientes objMarcado = new MarcadoClientes();
				
				objMarcado.setId(""+aux+++"");
				objMarcado.setRuta(rs.getString("ruta").replace("(","").replace(")", ""));
				objMarcado.setCliente(rs.getString("cte"));
				objMarcado.setFacturas(rs.getString("facturas"));
				objMarcado.setAcumuladores(rs.getString("acumuladores"));
				objMarcado.setAtados(rs.getString("atados"));
				objMarcado.setBolsas(rs.getString("bolsas"));
				objMarcado.setCajas(rs.getString("cajas"));
				objMarcado.setOtros(rs.getString("otros"));
				objMarcado.setPaquetes(rs.getString("paquetes"));
				objMarcado.setPeso(rs.getString("peso"));
				objMarcado.setTarimas(rs.getString("tarimas"));
				objMarcado.setDireccion(rs.getString("direccion").toUpperCase());
				lstMarcado.add(objMarcado);
			}
		}
		catch (Exception e) 
		{
			InsertarLogAlamacen.insertarLog(new LogAlmacen("","",""),infoUsu.getUname(),infoUsu.getUname_br(),"Error al llenar marcado de clientes. DETALLE: "+Error(e)+". Usuario: "+session.getAttribute("name").toString()+". Maquina: "+session.getAttribute("maquina").toString()+". Ip: "+session.getAttribute("ip").toString(),infoUsu.getCve_usuario());
		}
		
		return lstMarcado;
	}
	
	public List<PedidosConsultaRC> consultarPedidosRCDetalle(String cdo, HttpSession session, List<Querys> ListaQuerys, Usuario infoUsu, String factura){
		Connection connBD = null;
		PreparedStatement pstm = null;
		connBD = ConexionBD.AbrirConexionBDD(cdo);
		List<PedidosConsultaRC> lstPedidosDetalleRC = new ArrayList<PedidosConsultaRC>();
		String [] querys = new String [25];
		try {
			querys = Cls_Querys.LimpiaListaQuerys(querys);
			querys = Cls_Querys.ObtieneQuerys(66, ListaQuerys, querys, infoUsu);
			querys = InicializaQueryNumero66(querys,factura, cdo);
			pstm = connBD.prepareStatement("{call " + cdo.toUpperCase()+".usp_EXECUTE_QUERY(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			ResultSet rs = EjecutaQuerysBD.EjecutarQuery(querys[0], querys[1],querys[2], querys[3], querys[4], querys[5], querys[6],
					 querys[7], querys[8], querys[9],querys[10], querys[11], querys[12], querys[13], 
					 querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], 
					 querys[21], querys[22], querys[23], querys[24], infoUsu.getUname(),pstm, connBD,infoUsu);
			Cls_Querys.ImprimeQuerysConsola(querys, false, "Query 66");
			//System.out.println("rs: " + rs);			
			if(rs != null) {
				int aux = 0;
				while(rs.next()) {
					PedidosConsultaRC rc = new PedidosConsultaRC();
					rc.setIdDetalleRC(rs.getString("id"));
					rc.setNoIdentificacion(rs.getString("noidentificacion"));
					rc.setDescUnidad(rs.getString("desc_unidad"));
					rc.setPeso(rs.getString("peso"));
					rc.setCantidad(rs.getString("cantidad"));
					rc.setClvMaterialPeligroso(rs.getString("cp_ClaveMaterialPeligroso"));
					rc.setFacturaTraslado(rs.getString("factura_traslado"));
					rc.setCteDestino(rs.getString("cte_destino"));
					rc.setRemision(rs.getString("remision"));
					aux++;
					lstPedidosDetalleRC.add(rc);
				}
				session.setAttribute("contadorArticulos", aux);
			}
		}catch(Exception e) {
			System.out.println("Error en GestorPedidos.consultarPedidosRCDetalle: " + e.getMessage());
		}finally {
			try{pstm.close();}catch(Exception e) {}
			try{connBD.close();}catch(Exception e) {}
		}
		session.setAttribute("lstPedidosDetalleRC", lstPedidosDetalleRC);
		return lstPedidosDetalleRC;
	}
	
	public List<PedidosConsultaRC> consultarPedidosRC(String cdo, HttpSession session, List<Querys> ListaQuerys, Usuario infoUsu, String fechaInicio, String fechaFin, List<String> lstConsultarTipoCP) {
		Connection connBD = null;
		PreparedStatement pstm = null;
		connBD = ConexionBD.AbrirConexionBDD(cdo);
		List<PedidosConsultaRC> lstPedidosRC = new ArrayList<PedidosConsultaRC>();
		String [] querys = new String [25];
		try {
			querys = Cls_Querys.LimpiaListaQuerys(querys);
			querys = Cls_Querys.ObtieneQuerys(61, ListaQuerys, querys, infoUsu);
			querys = InicializaQueryNumero61(querys,fechaInicio,fechaFin, cdo);
			pstm = connBD.prepareStatement("{call " + cdo.toUpperCase()+".usp_EXECUTE_QUERY(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			ResultSet rs = EjecutaQuerysBD.EjecutarQuery(querys[0], querys[1],querys[2], querys[3], querys[4], querys[5], querys[6],
					 querys[7], querys[8], querys[9],querys[10], querys[11], querys[12], querys[13], 
					 querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], 
					 querys[21], querys[22], querys[23], querys[24], infoUsu.getUname(),pstm, connBD,infoUsu);
			Cls_Querys.ImprimeQuerysConsola(querys, false, "Query 61");
			//System.out.println("rs: " + rs);
			if(rs != null) {
				while(rs.next()) {
					PedidosConsultaRC rc = new PedidosConsultaRC();
					 rc.setRuta(rs.getString("ruta"));
					 rc.setUnameDestino(rs.getString("uname_destino"));
					 rc.setIdentificacionCDD(rs.getString("identificacion_cdd"));
					 rc.setCteDestino(rs.getString("cte_destino"));
					 rc.setFacturaTraslado(rs.getString("factura_traslado"));
					 rc.setRemision(rs.getString("remision"));
					 rc.setFecha(rs.getString("fecha"));
					 rc.setRazonSocial(rs.getString("razon_social"));
					 rc.setDireccion(rs.getString("direccion"));
					 rc.setTrasnporte(rs.getString("transporte"));
					 rc.setEstatus(rs.getString("estatus"));
					 rc.setUnameOrigen(rs.getString("uname_origen"));
					 rc.setProgramada(rs.getString("id_estatus"));
					 rc.setIdTrayectoAnterior(rs.getString("id_trayecto_anterior"));
					 rc.setTipo(rs.getString("tipo"));
					// System.out.println("tipo: "+rc.getTipo().toUpperCase());
					 rc.setDescripcionTipo(rs.getString("descripcion"));			
					 rc.setTotalArticulos(rs.getString("total_articulos"));
					 rc.setNumeroCaja(rs.getString("numero_caja"));  
					lstPedidosRC.add(rc);
				}
			}
			InsertarLogAlamacen.insertarLog(new LogAlmacen("","",""),infoUsu.getUname(),infoUsu.getUname_br(),"ConsultaPedidosRC:"+ ". Qry[ \n "+Qry(seprado(querys))+" \n]"+". Usuario: "+session.getAttribute("name").toString()+". Maquina: "+session.getAttribute("maquina").toString()+". Ip: "+session.getAttribute("ip").toString(),infoUsu.getCve_usuario());
		}catch(Exception e) {
			System.out.println("Error en GestorPedidos.consultarPedidosRC: " + e.getMessage());
		}finally {
			try{pstm.close();}catch(Exception e) {};	
			try{connBD.close();}catch(Exception e) {};
		}
		session.setAttribute("lstPedidosRC", lstPedidosRC);
		return lstPedidosRC;
	}
	
	public List<PedidosConsulta> consultaPedidos(String cdo, String hora, HttpSession session, String cve_usu, String uname_br, String nivel, List<Querys> ListaQuerys, Usuario infoUsu, String ruta, String tipo, String fechaFin, String fechaInicio) 
	{
		//System.out.println("Entra a consultaPedidos...1 ");
		session.setAttribute("choferTipo", "");
		Connection connBD = null;
		PreparedStatement pstm = null;
		connBD = ConexionBD.AbrirConexionBDD(cdo);
		String qyr = "";
		String tipoBusqueda = " ";
		List<PedidosConsulta> lstPedidos = new ArrayList<PedidosConsulta>();
		String [] querys = new String [25];
		try 
		{
			
			querys = Cls_Querys.LimpiaListaQuerys(querys);
			querys = Cls_Querys.ObtieneQuerys(54, ListaQuerys, querys, infoUsu);
			
			List<SeriesCfdi> series = (List<SeriesCfdi>) session.getAttribute("series");
			String split [];
			split = hora.split("/");
			String qryTransporte = complementoQryTransporte(split[1],session);
			if (!ruta.equals(""))
			{
				ruta = " and r.num_ruta = '"+ruta+"' ";
			}
			if (tipo.equals("p"))
			{
				tipoBusqueda = "PEDIDO";
				tipo = " order by r.descripcion asc, b.num_cli asc, b.fecha_pedido asc, b.pedido asc,p.num_fac asc ";
				session.setAttribute("choferTipo", "p");
			}
			else
			{
				tipoBusqueda = "FACTURA";
				session.setAttribute("choferTipo", "f");
				tipo = "order by p.num_fac asc";
			}
			
			querys = InicializaQueryNumero1(querys, infoUsu,split[0],qryTransporte,session.getAttribute("session_br").toString(),cdo.toUpperCase(),ruta,tipo,fechaInicio,fechaFin);
//			System.out.println(querys[0]);
			pstm = connBD.prepareStatement("{call " + "ALMACEN.usp_EXECUTE_QUERY(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			ResultSet rs = EjecutaQuerysBD.EjecutarQuery(querys[0], querys[1],querys[2], querys[3], querys[4], querys[5], querys[6],
					 querys[7], querys[8], querys[9],querys[10], querys[11], querys[12], querys[13], 
					 querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], 
					 querys[21], querys[22], querys[23], querys[24], infoUsu.getUname(),pstm, connBD,infoUsu);
			InsertarLogAlamacen.insertarLog(new LogAlmacen("","",""),infoUsu.getUname(),infoUsu.getUname_br(),"Consulta inicial de pedidos para asignar a chofer por "+tipoBusqueda+". Qry["+Qry(seprado(querys))+"]"+". Usuario: "+session.getAttribute("name").toString()+". Maquina: "+session.getAttribute("maquina").toString()+". Ip: "+session.getAttribute("ip").toString(),infoUsu.getCve_usuario());
			
			Cls_Querys.ImprimeQuerysConsola(querys, false, "qury 54.- consulta inicial");
			
			String splitNivel [] = obtenerNivel(nivel,infoUsu,session);
			
			if (rs != null) 
			{
				lstPedidos = llenarPedidosChofer(rs,infoUsu,lstPedidos,splitNivel,series,nivel,session);
			}
			


		} 
		catch (Exception e) 
		{
			InsertarLogAlamacen.insertarLog(new LogAlmacen("","",""),infoUsu.getUname(),infoUsu.getUname_br(),"Error en consulta inicial de pedidos para asignar a chofer por "+tipoBusqueda+". DETALLE: "+Error(e)+". Qry["+Qry(seprado(querys))+"]"+" Usuario: "+session.getAttribute("name").toString()+". Maquina: "+session.getAttribute("maquina").toString()+". Ip: "+session.getAttribute("ip").toString(),infoUsu.getCve_usuario());
		}
		finally 
		{
			try 
			{
				connBD.close();
				pstm.close();
			} catch (Exception e2)
			{
				InsertarLogAlamacen.insertarLog(new LogAlmacen("","",""),infoUsu.getUname(),infoUsu.getUname_br(),"Error al cerrar conexion y pstm consulta pedidos a chofer por "+tipoBusqueda+". DETALLE: "+Error(e2)+". Usuario: "+session.getAttribute("name").toString()+". Maquina: "+session.getAttribute("maquina").toString()+". Ip: "+session.getAttribute("ip").toString(),infoUsu.getCve_usuario());
			}
		}
		
		
		
		session.setAttribute("listaPedidos", lstPedidos);
	    return lstPedidos;
	}

	private String seprado(String[] querys) 
	{
		String qry = " \n \n";
		
		for (String string : querys) 
		{
			if (!string.equals("")) 
			{
				qry = qry + string + "\n";
			}
			
		}
		qry = qry +" \n \n";
		return qry;
	}

	

	private String Qry(String qry) 
	{
		return qry.toString().replace("'","´");
	}


	private String Error(Exception e) 
	{
		return e.toString().replace("'", "´");
	}



	private List<PedidosConsulta> llenarPedidosChofer(ResultSet rs, Usuario infoUsu, List<PedidosConsulta> lstPedidos,String[] splitNivel, List<SeriesCfdi> series, String nivel, HttpSession session) 
	{
		int no = 0;
		int auxiliarConsec = 0;
		int aux = 0;
		List<Rutas> rutas = new ArrayList<>();
		try 
		{
			
			while (rs.next())
			{
				String aux2 = "n";
				if (nivel.equals("*"))
				{
					aux2 = "s";
				}
				else
				{	
					for (int i = 0; i < splitNivel.length; i++) 
					{
						if (splitNivel[i].equals(rs.getString("numeroTransporte"))) 
						{
							aux2 = "s";
							break;
						}
					}
				}
				if (aux2.equals("s"))
				{
					no = no+1;
					session.setAttribute("consecutivo", no);
					PedidosConsulta p = new PedidosConsulta();
					
					Rutas r = new Rutas();
					if (rs.getInt("num_ruta") == 0) 
					{
						p.setCc(123456789);
						r.setNum_ruta(123456789);
						r.setDescripcion(rs.getString("ruta"));	
					}
					else
					{
						p.setCc(rs.getInt("num_ruta"));
						r.setNum_ruta(rs.getInt("num_ruta"));
						r.setDescripcion(rs.getString("ruta"));
					}
					
					p.setFactura_larga(rs.getString("factura_larga"));
					p.setNo(String.valueOf(no));
					p.setNor(String.valueOf(no)+"r");
					p.setId_estatus(rs.getString("id_estatus"));
					p.setRuta(rs.getString("ruta"));
					p.setUname_entrega(rs.getString("uname_entrega"));
					p.setFecha_ods(rs.getString("fecha_pedido"));
					p.setFecha_factura(rs.getString("fecha_factura"));
					p.setUname_entrega(rs.getString("uname_entrega"));
					p.setUname_br_entrega(rs.getString("uname_br_entrega"));
					p.setFecha_corta(rs.getString("fecha_factura_corta"));
					p.setOds(rs.getString("ods"));
					p.setUname(rs.getString("uname_br"));
					p.setPedido(rs.getString("pedido"));
					p.setOde(rs.getString("ode"));
					p.setOder(rs.getString("ode")+"r");
					p.setProgramada(rs.getString("programada"));
					p.setId_trayecto(rs.getString("id_trayecto"));
					p.setImporte(rs.getString("importe"));
					p.setCondicion(rs.getString("condicion"));
					p.setFactura(rs.getString("num_fac"));
					p.setCte(rs.getString("cte"));
					p.setConsignatario(rs.getString("consignatario"));
					if(rs.getInt("consignatario") > 0)
					{						
						p.setDireccion(rs.getString("direccion"));
						p.setNombre_razon_social(rs.getString("nombre_razon_social"));
					}
					else
					{
						p.setDireccion(rs.getString("direccion_cte"));
						p.setNombre_razon_social(rs.getString("nombre_razon_social_cte"));
					}
					p.setTransporte(rs.getString("transporte"));
					if (aux != 0)
					{
						
						for (PedidosConsulta l : lstPedidos)
						{
							if (l.getOde().equals(p.getOde()) && l.getPedido().equals(p.getPedido()))
							{
								
//								p.setConsecutivo(""+auxiliarConsec+"");
								p.setRepeticion("s");
							}
							else
							{
								p.setRepeticion("n");
//								auxiliarConsec++;
//								p.setConsecutivo(""+auxiliarConsec+"");
							}
						}
						
					}
					else
					{
						p.setRepeticion("n");
					}
					aux++;
					lstPedidos.add(p);
					rutas.add(r);
				}
			}
		}
		catch (Exception e) 
		{
			InsertarLogAlamacen.insertarLog(new LogAlmacen("","",""),infoUsu.getUname(),infoUsu.getUname_br(),"Error al llenar pedidos para asignacion chofer. DETALLE: "+Error(e)+". Usuario: "+session.getAttribute("name").toString()+". Maquina: "+session.getAttribute("maquina").toString()+". Ip: "+session.getAttribute("ip").toString(),infoUsu.getCve_usuario());
		}

		
		return lstPedidos;
	}



	private String[] obtenerNivel(String nivel, Usuario infoUsu, HttpSession session) 
	{
		String splitNivel[] = null;
		if (!nivel.equals("n")) 
		{
			if (nivel.contains(","))
			{
				splitNivel = nivel.split(",");
			}
			else if (!nivel.equals("*")) 
			{
				splitNivel [1]= nivel;
			}
		}
		else
		{
			InsertarLogAlamacen.insertarLog(new LogAlmacen("","",""),infoUsu.getUname(),infoUsu.getUname_br(),"No tiene declarado el tipo de trnasportes a nivel usuario. USU_PROC_WEB-dato_alfanumerico1."+". Usuario: "+session.getAttribute("name").toString()+". Maquina: "+session.getAttribute("maquina").toString()+". Ip: "+session.getAttribute("ip").toString(),infoUsu.getCve_usuario());
		}
		
		return splitNivel;
	}



	private String complementoQryTransporte(String split, HttpSession session) 
	{
		String qryTransporte = " ";
		if (!split.equals("*"))
		{
			 session.setAttribute("transporte", split);
			 qryTransporte = " and t.num_trans in ("+split+") ";
		}
		return qryTransporte;
	}
	
	public boolean actualizarPedidosDetalleRC(String articulos, HttpSession session, Usuario infoUsu, List<Querys> ListaQuerys) {
		Connection connBD = null;
		PreparedStatement pstm = null;
		boolean validacion = false;
		List<PedidosConsultaRC> articulosDetalle = (List<PedidosConsultaRC>) session.getAttribute("lstPedidosDetalleRC");
			try {
				articulos = articulos + ",";
				String split [] = null;
				articulos = articulos.replace(",,",",");
				if (articulos.contains(",")) 
				{						
				}else{
					articulos = articulos+",";
				}
				if (articulos.contains(","))
				{
					split = articulos.split(",");
				}
					for (String s : split) 
					{
						String splitAux [] = s.split("\\*");
						s = splitAux[0];
						for (PedidosConsultaRC pp : articulosDetalle) 
						{
							if (pp.getIdDetalleRC().equals(s)) 
							{				
								validacion = actualizaEncabezadoDetalleRC(infoUsu,connBD,pstm,ListaQuerys,pp.getFacturaTraslado(),pp.getIdDetalleRC());
							}							
						}
					}

			}catch(Exception e) {
				InsertarLogAlamacen.insertarLog(new LogAlmacen("","",""),infoUsu.getUname(),infoUsu.getUname_br(),"Error en metodo de asignacion. DETALLE: "+Error(e)+". Usuario: "+session.getAttribute("name").toString()+". Maquina: "+session.getAttribute("maquina").toString()+". Ip: "+session.getAttribute("ip").toString(),infoUsu.getCve_usuario());
				System.out.println("Error en GestorPedidos.actualizarPedidosDetalleRC: " + e);
			}
			
		return validacion;
	}

	public String asignacionPedidosRC(String pedidosRC, String chofer, String uname, HttpSession session, String usuario, String uname_br, String cdo_nombre, String facturaAgregada, String transporte, Usuario infoUsu, List<Querys> ListaQuerys, String numeroFacturasRC, String vehiculo, String posicionInsert, int nLlantas, String articulosFactura) 
	{	
		Connection connBD = null;
		PreparedStatement pstm = null;
		String validacion = "";
		String respuesta = "n";
		
		List<PedidosConsultaRC> p = (List<PedidosConsultaRC>) session.getAttribute("lstPedidosRC");

		if (!posicionInsert.equals("")) 
		{
			p = llenarPosicionInsertClientesRC(posicionInsert,p);
		}

		String uname_chofer = obtenerUname(session,chofer);
		
		if (!facturaAgregada.equals("")) 
		{
			validacion = consultaExistenciaFactura(pedidosRC,chofer,uname,session,usuario,uname_br,cdo_nombre,facturaAgregada,transporte,infoUsu);;
			pedidosRC = pedidosRC+","+session.getAttribute("valorPed");
		}
		validacion = "true";
		if (validacion.equals("true") || facturaAgregada.equals("")) 
		{
			
			try {
			
					pedidosRC = pedidosRC + ",";
					String split [] = null;
					pedidosRC = pedidosRC.replace(",,",",");
					if (pedidosRC.contains(",")) 
					{						
					}else{
						pedidosRC = pedidosRC+",";
					}
				if (pedidosRC.contains(","))
				{
					split = pedidosRC.split(",");				
				}
				String FOLIO = "";
				String FOLIO_CARTA_PORTE = "0";
				
				consultarArticulosXFactura(split, ListaQuerys, session, uname, infoUsu, p);
				//validacion = validarAsignadasRC(split,ListaQuerys,uname,uname_br,session,uname,infoUsu,p,uname_chofer);
				validacion = "true";
				if (validacion.equals("true"))
				{				
					String llantas = "";
					int numLlantas = 0;
					
					String split2 [] = vehiculo.split("\\*");
					llantas = split2[1].trim();
					numLlantas = Integer.parseInt(llantas);
					FOLIO = obtenerFolioConsecutivo(ListaQuerys,uname,uname_br,connBD,pstm,infoUsu,uname_chofer,session);					
						if(numLlantas >= nLlantas) {
							FOLIO_CARTA_PORTE  = obtenerFolioCartaPorteConsecutivo(ListaQuerys,uname,uname_br,connBD,pstm,infoUsu,uname_chofer,session);							
							actualizarConsecutivoCartaPorte(Integer.parseInt(FOLIO_CARTA_PORTE)+1,uname,uname_br,ListaQuerys,connBD,pstm,infoUsu,pedidosRC,uname_chofer,session);
						}
						actualizarConsecutivo(Integer.parseInt(FOLIO)+1,uname,uname_br,ListaQuerys,connBD,pstm,infoUsu,pedidosRC,uname_chofer,session);
					if(!FOLIO.equals(""))
					{			
							respuesta = obtenerProcesoQryRC(split,chofer,uname,session,p,"",usuario,uname_br,FOLIO,ListaQuerys,infoUsu,connBD,pstm,split,uname_chofer,numeroFacturasRC);
							insertarEncabezadoRC(uname, uname_br, FOLIO, chofer, usuario, p,split,ListaQuerys,infoUsu,connBD,pstm,uname_chofer,session,vehiculo,FOLIO_CARTA_PORTE,nLlantas);
							
							if (respuesta.equals("s"))
							{
							respuesta = FOLIO;	
							}
							List<PedidosConsultaRC> artSel = (List<PedidosConsultaRC>)session.getAttribute("listaArticulosSel");										
							String validador = "entra";
							for (String s : split) 
							{
								for (PedidosConsultaRC pp : p) 
								{								
									if (pp.getFacturaTraslado().equals(s)) 
									{												
										if(artSel == null || artSel.size() == 0 || artSel.isEmpty()) 
										{														
											actualizaEncabezadoRC(infoUsu,connBD,pstm,ListaQuerys,pp.getFacturaTraslado(),FOLIO);											
										}
										else 
										{
											for(PedidosConsultaRC a : artSel) 
											{
												if(pp.getFacturaTraslado().equals(a.getFacturaTraslado())) 
												{													
													actualizaArticulosPedidosRC(infoUsu,connBD,pstm,ListaQuerys,pp.getFacturaTraslado(),FOLIO,a.getIdDetalleRC());													
													validador = "YaAsigno";
												}
												else 
												{
													if (pp.getFacturaTraslado().equals(s)) 
													{														
														if(!validador.equals("YaAsigno")) {																
															actualizaEncabezadoRC(infoUsu,connBD,pstm,ListaQuerys,pp.getFacturaTraslado(),FOLIO);															
														}											
													}
												}												
											 }
										}									 
									}									
								}
							}			
							for (PedidosConsultaRC pp : p) 
							{		
								for(String a : split) 
								{								
									if(pp.getFacturaTraslado().equals(a)) 
									{										
										String existencia = consultarRegistrosEstatusCero(infoUsu,connBD,pstm,ListaQuerys,pp.getFacturaTraslado());									
										if(existencia.equals("0")) {											
											actualizaEstatusFacturaSinPendiente(infoUsu,connBD,pstm,ListaQuerys,pp.getFacturaTraslado());											
										}
									}
								}
							}															
			
							session.setAttribute("choferes", GestorDatosUsuario.obtenerChoferes(uname,ListaQuerys,infoUsu));
							if (!respuesta.equals("n")) 
							{
								imprimirTicketSeparadoRC(FOLIO, infoUsu, p, session,ListaQuerys,infoUsu,uname_chofer,"");
							}								
					}
					validacion = respuesta;
				}
				else
				{
					validacion = validacion;
				}
			
			}
			
			catch (Exception e) 
			{
				InsertarLogAlamacen.insertarLog(new LogAlmacen("","",""),infoUsu.getUname(),infoUsu.getUname_br(),"Error en metodo de asignacion. DETALLE: "+Error(e)+". Usuario: "+session.getAttribute("name").toString()+". Maquina: "+session.getAttribute("maquina").toString()+". Ip: "+session.getAttribute("ip").toString(),infoUsu.getCve_usuario());
			}
		}
	
		return validacion;
	
	}
	
	public String asignacionPedidos(String pedidos, String chofer, String uname, HttpSession session, String usuario, String uname_br, String cdo_nombre, String odeAgregada, String transporte, Usuario infoUsu, List<Querys> ListaQuerys, String pedidosR, String numeroFacturas, String vehiculo, String posicionInsert, int nLlantas) 
	{        
		Connection connBD = null;
		PreparedStatement pstm = null;
		String validacion = "";
		String respuesta = "n";
		List<PedidosConsulta> p = (List<PedidosConsulta>) session.getAttribute("listaPedidos");
		//System.out.println("Entro a asignacion Pedidos");
		if (!posicionInsert.equals("")) 
		{
			p = llenarPosicionInsertClientes(posicionInsert,p);
		}
		
		String uname_chofer = obtenerUname(session,chofer);
		if (!odeAgregada.equals("")) 
		{
			validacion = consultaExistenciaOde(pedidos,chofer,uname,session,usuario,uname_br,cdo_nombre,odeAgregada,transporte,infoUsu);;
			//System.out.println("valorPed: "+session.getAttribute("valorPed"));
			pedidos = pedidos+","+session.getAttribute("valorPed");
		}
		validacion = "true";
		if (validacion.equals("true") || odeAgregada.equals("")) 
		{
			
			try {
			
			pedidos = pedidos + ","+pedidosR;
			String split [] = null;
			pedidos = pedidos.replace(",,",",");
			if (pedidos.contains(",")) 
			{}else {pedidos = pedidos+",";}
			if (pedidos.contains(","))
			{
				split = pedidos.split(",");
				
			}
			String FOLIO = "";
			String FOLIO_CARTA_PORTE = "0";
			
			validacion = validarAsignadas(split,ListaQuerys,uname,uname_br,session,uname,infoUsu,p,uname_chofer);
			validacion = "true";
			if (validacion.equals("true"))
			{
				
				String llantas = "";
				int numLlantas = 0;
				
				String split2 [] = vehiculo.split("\\*");
				llantas = split2[1].trim();
				numLlantas = Integer.parseInt(llantas);
				
				FOLIO = obtenerFolioConsecutivo(ListaQuerys,uname,uname_br,connBD,pstm,infoUsu,uname_chofer,session);
					if(numLlantas >= nLlantas) {
						FOLIO_CARTA_PORTE  = obtenerFolioCartaPorteConsecutivo(ListaQuerys,uname,uname_br,connBD,pstm,infoUsu,uname_chofer,session);
						actualizarConsecutivoCartaPorte(Integer.parseInt(FOLIO_CARTA_PORTE)+1,uname,uname_br,ListaQuerys,connBD,pstm,infoUsu,pedidos,uname_chofer,session);
					}
				actualizarConsecutivo(Integer.parseInt(FOLIO)+1,uname,uname_br,ListaQuerys,connBD,pstm,infoUsu,pedidos,uname_chofer,session);
				if(!FOLIO.equals(""))
				{			
						respuesta = obtenerProcesoQry(split,chofer,uname,session,p,"",usuario,uname_br,FOLIO,ListaQuerys,infoUsu,connBD,pstm,split,uname_chofer,numeroFacturas);
						insertarEncabezado(uname, uname_br, FOLIO, chofer, usuario, p,split,ListaQuerys,infoUsu,connBD,pstm,uname_chofer,session,vehiculo,FOLIO_CARTA_PORTE,nLlantas);
						if (!respuesta.equals("n")) 
						{
							//System.out.println("Entra a ticket cond "+ respuesta);
							imprimirTicketSeparado(FOLIO, infoUsu, p, session,ListaQuerys,infoUsu,uname_chofer,"");
							
						}
						if (respuesta.equals("s"))
						{
						respuesta = FOLIO;	
						}
						session.setAttribute("choferes", GestorDatosUsuario.obtenerChoferes(uname,ListaQuerys,infoUsu));
						
				}
				validacion = respuesta;
			}
			else
			{
				validacion = validacion;
			}
			
			}
			
			catch (Exception e) 
			{
				InsertarLogAlamacen.insertarLog(new LogAlmacen("","",""),infoUsu.getUname(),infoUsu.getUname_br(),"Error en metodo de asignacion. DETALLE: "+Error(e)+". Usuario: "+session.getAttribute("name").toString()+". Maquina: "+session.getAttribute("maquina").toString()+". Ip: "+session.getAttribute("ip").toString(),infoUsu.getCve_usuario());
			}
		}
	
		return validacion;
	}

	private List<PedidosConsultaRC> llenarPosicionInsertClientesRC(String posicionInsert, List<PedidosConsultaRC> pRC){
		posicionInsert = posicionInsert + ",";
		String split [] = posicionInsert.split(",");
		for (String itemPoscionInsert : split) 
		{
			String splitValues [] = itemPoscionInsert.split("\\*");
			for(PedidosConsultaRC itemPedidosRC : pRC) {
				if (itemPedidosRC.getCteDestino().equals(splitValues[1])) 
				{
					itemPedidosRC.setConsecutivo(splitValues[0]);
				}
			}			
		}
		//System.out.println("pRC: "+pRC);
		return pRC;
	}
	private List<PedidosConsulta> llenarPosicionInsertClientes(String posicionInsert, List<PedidosConsulta> p) 
	{
		
		
		posicionInsert = posicionInsert + ",";
		String split [] = posicionInsert.split(",");
		for (String itemPoscionInsert : split) 
		{
			String splitValues [] = itemPoscionInsert.split("\\*");
			for (PedidosConsulta itemPedidos : p) 
			{
				if (itemPedidos.getCte().equals(splitValues[1])) 
				{
					itemPedidos.setConsecutivo(splitValues[0]);
				}
			}
		}
		
		return p;
	}
	
	public List<MarcadoClientes> asignacionPedidosORDENRC(String pedidosRC, String chofer,String uname,HttpSession session,String usuario,String uname_br,String cdo_nombre,String facturaAgregada,String transporte,Usuario infoUsu,List<Querys> ListaQuerys,String numeroFacturasRC,String vehiculo,String fechaFin,String fechaInicio) 
	{        
		List<PedidosConsultaRC> lstPedidosOrden = new ArrayList<>();
		List<MarcadoClientes> lstMarcado = new ArrayList <>();
		String facturas = "";
		if (!facturaAgregada.equals("")) 
		{
			 consultaExistenciaFacturaORDEN(pedidosRC,chofer,uname,session,usuario,uname_br,cdo_nombre,facturaAgregada,transporte,infoUsu);;
			 pedidosRC = pedidosRC+","+session.getAttribute("valorPedORDEN");
		}
		try 
		{
			List<PedidosConsultaRC> lstPedidosRC = (List<PedidosConsultaRC>) session.getAttribute("lstPedidosRC");
			
			pedidosRC = pedidosRC + ",";
			String split [] = null;
			pedidosRC = pedidosRC.replace(",,",",");
//				System.out.println("pedidosRC2: "+pedidosRC);
			if (pedidosRC.contains(",")) 
			{						
			}else{
				pedidosRC = pedidosRC+",";
			}
			if (pedidosRC.contains(","))
			{
				split = pedidosRC.split(",");				
			}
			
			
			for (String item : split) 
			{
				for (PedidosConsultaRC itemPedidos : lstPedidosRC) 
				{
					if (item.contains("r"))
					{
						String splitAux [] = item.split("\\*");
						item = splitAux[0];
					}
					if (item.equals(itemPedidos.getFacturaTraslado())) 
					{
						facturas = facturas + "'"+itemPedidos.getFacturaTraslado() + "',";
					}
				}
			}
			//System.out.println("facturas del marcado: " + facturas);
			if (!facturas.equals("")) 
			{
//				System.out.println("ODES: "+odes );
				lstMarcado = consultaMarcadoClientesRC(infoUsu.getUname(),"", session,infoUsu.getCve_usuario(),infoUsu.getUname_br(), "", ListaQuerys, infoUsu, lstMarcado, "", "", fechaFin, fechaInicio, facturas.substring(0,facturas.length()-1));
				//System.out.println("LISTA MARCADO: "+lstMarcado);
			}
			else
			{
			}
		}
		
		catch (Exception e) 
		{
			InsertarLogAlamacen.insertarLog(new LogAlmacen("","",""),infoUsu.getUname(),infoUsu.getUname_br(),"Error en obtener pedidos para orden. DETALLE: "+Error(e)+". Usuario: "+session.getAttribute("name").toString()+". Maquina: "+session.getAttribute("maquina").toString()+". Ip: "+session.getAttribute("ip").toString(),infoUsu.getCve_usuario());
		}
		
	
		return lstMarcado;
	}
	
	public List<MarcadoClientes> asignacionPedidosORDEN(String pedidos, String chofer, String uname, HttpSession session, String usuario, String uname_br, String cdo_nombre, String odeAgregada, String transporte, Usuario infoUsu, List<Querys> ListaQuerys, String pedidosR, String numeroFacturas, String vehiculo, String fechaFin, String fechaInicio) 
	{        
		List<PedidosConsulta> lstPedidosOrden = new ArrayList<>();
		List<MarcadoClientes> lstMarcado = new ArrayList<>();
		String odes = "";
		if (!odeAgregada.equals("")) 
		{
			 consultaExistenciaOdeORDEN(pedidos,chofer,uname,session,usuario,uname_br,cdo_nombre,odeAgregada,transporte,infoUsu);;
			pedidos = pedidos+","+session.getAttribute("valorPedORDEN");
		}
		try 
		{
			List<PedidosConsulta> lstPedidos = (List<PedidosConsulta>) session.getAttribute("listaPedidos");
			pedidos = pedidos + ","+pedidosR;
			
			String split [] = null;
			pedidos = pedidos.replace(",,",",");
			if (pedidos.contains(",")) 
			{}else {pedidos = pedidos+",";}
			if (pedidos.contains(","))
			{
				split = pedidos.split(",");
			}
			for (String item : split) 
			{
				for (PedidosConsulta itemPedidos : lstPedidos) 
				{
					if (item.contains("r"))
					{
						String splitAux [] = item.split("\\*");
						item = splitAux[0];
					}
					if (item.equals(itemPedidos.getNo())) 
					{
						odes = odes + itemPedidos.getOde() + ",";
					}
				}
			}
			if (!odes.equals("")) 
			{
//				System.out.println("ODES: "+odes );
				lstMarcado = consultaMarcadoClientes(infoUsu.getUname(),"", session,infoUsu.getCve_usuario(),infoUsu.getUname_br(), "", ListaQuerys, infoUsu, lstMarcado, "", "", fechaFin, fechaInicio, odes.substring(0,odes.length()-1));
				//System.out.println("LISTA MARCADO: "+lstMarcado);
			}
			else
			{
			}
		}
		
		catch (Exception e) 
		{
			InsertarLogAlamacen.insertarLog(new LogAlmacen("","",""),infoUsu.getUname(),infoUsu.getUname_br(),"Error en obtener pedidos para orden. DETALLE: "+Error(e)+". Usuario: "+session.getAttribute("name").toString()+". Maquina: "+session.getAttribute("maquina").toString()+". Ip: "+session.getAttribute("ip").toString(),infoUsu.getCve_usuario());
		}
		
	
		return lstMarcado;
	}

	private void consultarArticulosXFactura(String[] split, List<Querys> ListaQuerys,HttpSession session, String uname, Usuario infoUsu,List<PedidosConsultaRC> p) {
		String [] querys = new String [25];
		Connection connBD = null;
		PreparedStatement pstm = null;
		connBD = ConexionBD.AbrirConexionBDD(uname.toUpperCase());
		List<PedidosConsultaRC> listaArticulosSel = new ArrayList<PedidosConsultaRC>();
		String rsp = "false";
		
		String factura = "";
		int aux = 0;
		for ( String s : split) 
		{
			for (PedidosConsultaRC pp : p) 
			{
				if(pp.getFacturaTraslado().equals(s)) {
					if (aux == 0) 
					{
					   factura = "'"+pp.getFacturaTraslado() + "',";
					}else
					{
					   factura = factura +"'"+ pp.getFacturaTraslado() + "',";
					}
				}	
			}
			aux++;
		}
		String facturas = " ";
		String repetidas = "";
		if (factura.length()>0) 
		{
			factura = factura.substring(0,factura.length()-1);
			
			try
			{
			
				querys = Cls_Querys.LimpiaListaQuerys(querys);
				querys = Cls_Querys.ObtieneQuerys(68, ListaQuerys, querys, infoUsu);
				querys = InicializaQueryNumero68(querys,factura, uname);
				
				pstm = connBD.prepareStatement("{call " + uname.toUpperCase()+".usp_EXECUTE_QUERY(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
				ResultSet rs = EjecutaQuerysBD.EjecutarQuery(querys[0], querys[1],querys[2], querys[3], querys[4], querys[5], querys[6],
						 querys[7], querys[8], querys[9],querys[10], querys[11], querys[12], querys[13], 
						 querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], 
						 querys[21], querys[22], querys[23], querys[24], infoUsu.getUname(),pstm, connBD,infoUsu);
				Cls_Querys.ImprimeQuerysConsola(querys, false, "Query 68");
				if (rs != null) 
				{
					while (rs.next())
					{
						PedidosConsultaRC articulosSeleccionados = new PedidosConsultaRC();
						articulosSeleccionados.setIdDetalleRC(rs.getString("id"));
						articulosSeleccionados.setFacturaTraslado(rs.getString("factura_traslado"));
						//System.out.println("ART: "+articulosSeleccionados.getFacturaTraslado());
						listaArticulosSel.add(articulosSeleccionados);
					}
				}
				session.setAttribute("listaArticulosSel", listaArticulosSel);
			} 
			catch (Exception e) 
			{
				rsp = "false";
				//InsertarLogAlamacen.insertarLog(new LogAlmacen("","",""),uname,infoUsu.getUname_br(),"Error al consultar si ya han sido agregadas las ODE("+ode+"). DETALLE: "+Error(e)+". Qry["+Qry(seprado(querys))+"]."+". Usuario: "+session.getAttribute("name").toString()+". Maquina: "+session.getAttribute("name").toString()+". Ip: "+session.getAttribute("ip").toString(),infoUsu.getCve_usuario());
			}finally {
				try{pstm.close();}catch(Exception e) {};	
				try{connBD.close();}catch(Exception e) {};
			}
		}
			
		
	}
	
	private String validarAsignadasRC(String[] split, List<Querys> ListaQuerys, String uname, String uname_br,HttpSession session, String uname2, Usuario infoUsu, List<PedidosConsultaRC> p, String uname_chofer) 
	{
		String [] querys = new String [25];
		Connection connBD = null;
		PreparedStatement pstm = null;
		connBD = ConexionBD.AbrirConexionBDD(uname.toUpperCase());
		String rsp = "false";
		
		String factura = "";
		int aux = 0;
		for ( String s : split) 
		{
			for (PedidosConsultaRC pp : p) 
			{
				if(pp.getFacturaTraslado().equals(s)) {
					if (aux == 0) 
					{
					   factura = "'"+pp.getFacturaTraslado() + "',";
					}else
					{
					   factura = factura +"'"+ pp.getFacturaTraslado() + "',";
					}
				}	
			}
			aux++;
		}
		String facturas = " ";
		String repetidas = "";
		if (factura.length()>0) 
		{
			factura = factura.substring(0,factura.length()-1);
			aux = 0;
			try
			{
			
				querys = Cls_Querys.LimpiaListaQuerys(querys);
				querys = Cls_Querys.ObtieneQuerys(63, ListaQuerys, querys, infoUsu);
				querys = InicializaQueryNumero63(querys,uname,uname_br,factura,uname_chofer);
				
				pstm = connBD.prepareStatement("{call " + "ALMACEN.usp_EXECUTE_QUERY(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
				ResultSet rs = EjecutaQuerysBD.EjecutarQuery(querys[0], querys[1],querys[2], querys[3], querys[4], querys[5], querys[6],
						 querys[7], querys[8], querys[9],querys[10], querys[11], querys[12], querys[13], 
						 querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], 
						 querys[21], querys[22], querys[23], querys[24], infoUsu.getUname(),pstm, connBD,infoUsu);
				Cls_Querys.ImprimeQuerysConsola(querys, false, "Query 63");
				if (rs != null) 
				{
					while (rs.next())
					{					
						//InsertarLogAlamacen.insertarLog(new LogAlmacen("","",""),uname,infoUsu.getUname_br(),"ODE ya asignada: "+rs.getString("ode")+". Qry["+Qry(seprado(querys))+"]."+". Usuario: "+session.getAttribute("name").toString()+". Maquina: "+session.getAttribute("name").toString()+". Ip: "+session.getAttribute("ip").toString(),infoUsu.getCve_usuario());
						aux = 1;
						repetidas = repetidas + rs.getString("factura_traslado")+",";
					}
				}
				if (aux == 0)
				{
					rsp = "true";
				}
				//InsertarLogAlamacen.insertarLog(new LogAlmacen("","",""),uname,infoUsu.getUname_br(),"Consulta si ya han sido agregadas las ODE("+ode+"). Qry["+Qry(seprado(querys))+"]."+". Usuario: "+session.getAttribute("name").toString()+". Maquina: "+session.getAttribute("name").toString()+". Ip: "+session.getAttribute("ip").toString(),infoUsu.getCve_usuario());
				if (aux != 0)
				{
					rsp = "FACTURA ya asignadas en otro folio: "+repetidas;
				}
			}
			catch (Exception e) 
			{
				rsp = "false";
				//InsertarLogAlamacen.insertarLog(new LogAlmacen("","",""),uname,infoUsu.getUname_br(),"Error al consultar si ya han sido agregadas las ODE("+ode+"). DETALLE: "+Error(e)+". Qry["+Qry(seprado(querys))+"]."+". Usuario: "+session.getAttribute("name").toString()+". Maquina: "+session.getAttribute("name").toString()+". Ip: "+session.getAttribute("ip").toString(),infoUsu.getCve_usuario());
			}finally{
				try{pstm.close();}catch(Exception e) {};	
				try{connBD.close();}catch(Exception e) {InsertarLogAlamacen.insertarLog(new LogAlmacen("","",""),infoUsu.getUname(),infoUsu.getUname_br(),"Error al cerrar conexion y pstm consulta si ya agregaron ODE. DETALLE: "+Error(e)+". Usuario: "+session.getAttribute("name").toString()+". Maquina: "+session.getAttribute("maquina").toString()+". Ip: "+session.getAttribute("ip").toString(),infoUsu.getCve_usuario());};
			}
		}
		
		return rsp;
	}

	private String validarAsignadas(String[] split, List<Querys> ListaQuerys, String uname, String uname_br,HttpSession session, String uname2, Usuario infoUsu, List<PedidosConsulta> p, String uname_chofer) 
	{
		String [] querys = new String [25];
		Connection connBD = null;
		PreparedStatement pstm = null;
		connBD = ConexionBD.AbrirConexionBDD(uname.toUpperCase());
		String rsp = "false";
		
		String ode = "";
		int aux = 0;
		for ( String s : split) 
		{
			String pedidoTipo = "";
			//System.out.println("s: "+s);
			if (s.contains("r"))
			{
				String splitAux [] = s.split("\\*");
				pedidoTipo = "s";
				s = splitAux[0];
			}
			for (PedidosConsulta pp : p) 
			{
				 if (pp.getNo().equals(s)) 
				 {
					 if (aux == 0) 
					 {
						 ode = pp.getOde() + ",";
					 }
					 else
					 {
						 ode = ode + pp.getOde() + ",";
					 }
					
				 }
			}
			aux++;
		}
		String odes = " ";
		String repetidas = "";
		if (ode.length()>0) 
		{
			ode = ode.substring(0,ode.length()-1);
			aux = 0;
			try
			{
			
				querys = Cls_Querys.LimpiaListaQuerys(querys);
				querys = Cls_Querys.ObtieneQuerys(52, ListaQuerys, querys, infoUsu);
				querys = InicializaQueryNumero52(querys,uname,uname_br,ode,uname_chofer);
				
				pstm = connBD.prepareStatement("{call " + "ALMACEN.usp_EXECUTE_QUERY(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
				ResultSet rs = EjecutaQuerysBD.EjecutarQuery(querys[0], querys[1],querys[2], querys[3], querys[4], querys[5], querys[6],
						 querys[7], querys[8], querys[9],querys[10], querys[11], querys[12], querys[13], 
						 querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], 
						 querys[21], querys[22], querys[23], querys[24], infoUsu.getUname(),pstm, connBD,infoUsu);
				
				if (rs != null) 
				{
					while (rs.next())
					{
//						
						InsertarLogAlamacen.insertarLog(new LogAlmacen("","",""),uname,infoUsu.getUname_br(),"ODE ya asignada: "+rs.getString("ode")+". Qry["+Qry(seprado(querys))+"]."+". Usuario: "+session.getAttribute("name").toString()+". Maquina: "+session.getAttribute("name").toString()+". Ip: "+session.getAttribute("ip").toString(),infoUsu.getCve_usuario());
						aux = 1;
						repetidas = repetidas + rs.getString("ode")+",";
					}
				}
				if (aux == 0)
				{
					rsp = "true";
				}
				InsertarLogAlamacen.insertarLog(new LogAlmacen("","",""),uname,infoUsu.getUname_br(),"Consulta si ya han sido agregadas las ODE("+ode+"). Qry["+Qry(seprado(querys))+"]."+". Usuario: "+session.getAttribute("name").toString()+". Maquina: "+session.getAttribute("name").toString()+". Ip: "+session.getAttribute("ip").toString(),infoUsu.getCve_usuario());
				if (aux != 0)
				{
					rsp = "ODE ya asignadas en otro folio: "+repetidas;
				}
			}
			catch (Exception e) 
			{
				rsp = "false";
				InsertarLogAlamacen.insertarLog(new LogAlmacen("","",""),uname,infoUsu.getUname_br(),"Error al consultar si ya han sido agregadas las ODE("+ode+"). DETALLE: "+Error(e)+". Qry["+Qry(seprado(querys))+"]."+". Usuario: "+session.getAttribute("name").toString()+". Maquina: "+session.getAttribute("name").toString()+". Ip: "+session.getAttribute("ip").toString(),infoUsu.getCve_usuario());
			}
			
			finally 
			{
				try 
				{
					connBD.close();
					pstm.close();
				} catch (Exception e2)
				{
					InsertarLogAlamacen.insertarLog(new LogAlmacen("","",""),infoUsu.getUname(),infoUsu.getUname_br(),"Error al cerrar conexion y pstm consulta si ya agregaron ODE. DETALLE: "+Error(e2)+". Usuario: "+session.getAttribute("name").toString()+". Maquina: "+session.getAttribute("maquina").toString()+". Ip: "+session.getAttribute("ip").toString(),infoUsu.getCve_usuario());
				}
			}
		}
		
		return rsp;
	}


	private String obtenerUname(HttpSession session, String chofer) 
	{
		String UNAME_BR = "";
		List<Choferes> choferes = (List<Choferes>) session.getAttribute("choferes");
		for (Choferes ch : choferes) 
		{
			if (ch.getChofer().equals(chofer)) 
			{
				UNAME_BR = ch.getUname();
				break;
			}
		}
		return UNAME_BR;
	}



	private void actualizarConsecutivo(int folio, String uname, String uname_br, List<Querys> ListaQuerys, Connection con1nBD,PreparedStatement p1stm, Usuario infoUsu, String pedidos, String uname_chofer, HttpSession session) 
	{
		String [] querys = new String [25];
		Connection connBD = null;
		PreparedStatement pstm = null;
		connBD = ConexionBD.AbrirConexionBDD(infoUsu.getUname().toUpperCase());
		try 
		{
			querys = Cls_Querys.LimpiaListaQuerys(querys);
			querys = Cls_Querys.ObtieneQuerys(11, ListaQuerys, querys, infoUsu);
			querys = InicializaQueryNumero11(querys,uname,uname_br,folio,uname_chofer);
			pstm = connBD.prepareStatement("{call " + "ALMACEN.usp_EXECUTE_QUERY(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			ResultSet rs = EjecutaQuerysBD.EjecutarQuery(querys[0], querys[1],querys[2], querys[3], querys[4], querys[5], querys[6],
					 querys[7], querys[8], querys[9],querys[10], querys[11], querys[12], querys[13], 
					 querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], 
					 querys[21], querys[22], querys[23], querys[24], infoUsu.getUname(),pstm, connBD,infoUsu);
				InsertarLogAlamacen.insertarLog(new LogAlmacen("","",""),uname,uname_br,"Actualizar folio consecutivo a: "+folio+". ODE=("+pedidos+"). Qry["+Qry(seprado(querys))+"]"+". Usuario: "+session.getAttribute("name").toString()+". Maquina: "+session.getAttribute("maquina").toString()+". Ip: "+session.getAttribute("ip").toString(),infoUsu.getCve_usuario());
		}
		catch (Exception e)
		{
			InsertarLogAlamacen.insertarLog(new LogAlmacen("","",""),uname,uname_br,"Error al actualizar folio consecutivo a: "+folio+". ODE=("+pedidos+"). DETALLE: "+Error(e)+".  Qry["+Qry(seprado(querys))+"]"+". Usuario: "+session.getAttribute("name").toString()+". Maquina: "+session.getAttribute("maquina").toString()+". Ip: "+session.getAttribute("ip").toString(),infoUsu.getCve_usuario());
		}
		finally 
		{
			try 
			{
				pstm.close();
				connBD.close();
			} catch (Exception e2)
			{
				InsertarLogAlamacen.insertarLog(new LogAlmacen("","",""),infoUsu.getUname(),infoUsu.getUname_br(),"Error al cerrar conexion y pstm actualizarfoliochofer. DETALLE: "+Error(e2)+". Usuario: "+session.getAttribute("name").toString()+". Maquina: "+session.getAttribute("maquina").toString()+". Ip: "+session.getAttribute("ip").toString(),infoUsu.getCve_usuario());
			}
		}
	}

	private void actualizarConsecutivoCartaPorte(int folio, String uname, String uname_br, List<Querys> ListaQuerys, Connection con1nBD,PreparedStatement p1stm, Usuario infoUsu, String pedidos, String uname_chofer, HttpSession session) 
	{
		String [] querys = new String [25];
		Connection connBD = null;
		PreparedStatement pstm = null;
		connBD = ConexionBD.AbrirConexionBDD(infoUsu.getUname().toUpperCase());
		try 
		{
			querys = Cls_Querys.LimpiaListaQuerys(querys);
			querys = Cls_Querys.ObtieneQuerys(58, ListaQuerys, querys, infoUsu);
			querys = InicializaQueryNumero11(querys,uname,uname_br,folio,uname_chofer);
			pstm = connBD.prepareStatement("{call " + "ALMACEN.usp_EXECUTE_QUERY(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			ResultSet rs = EjecutaQuerysBD.EjecutarQuery(querys[0], querys[1],querys[2], querys[3], querys[4], querys[5], querys[6],
					 querys[7], querys[8], querys[9],querys[10], querys[11], querys[12], querys[13], 
					 querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], 
					 querys[21], querys[22], querys[23], querys[24], infoUsu.getUname(),pstm, connBD,infoUsu);
				InsertarLogAlamacen.insertarLog(new LogAlmacen("","",""),uname,uname_br,"Actualizar folio consecutivo de Carta Porte a: "+folio+". ODE=("+pedidos+"). Qry["+Qry(seprado(querys))+"]"+". Usuario: "+session.getAttribute("name").toString()+". Maquina: "+session.getAttribute("maquina").toString()+". Ip: "+session.getAttribute("ip").toString(),infoUsu.getCve_usuario());
		}
		catch (Exception e)
		{
			InsertarLogAlamacen.insertarLog(new LogAlmacen("","",""),uname,uname_br,"Error al actualizar folio consecutivo de Carta Porte a: "+folio+". ODE=("+pedidos+"). DETALLE: "+Error(e)+".  Qry["+Qry(seprado(querys))+"]"+". Usuario: "+session.getAttribute("name").toString()+". Maquina: "+session.getAttribute("maquina").toString()+". Ip: "+session.getAttribute("ip").toString(),infoUsu.getCve_usuario());
		}
		finally 
		{
			try 
			{
				pstm.close();
				connBD.close();
			} catch (Exception e2)
			{
				InsertarLogAlamacen.insertarLog(new LogAlmacen("","",""),infoUsu.getUname(),infoUsu.getUname_br(),"Error al cerrar conexion y pstm actualizar folio  de Carta Porte. DETALLE: "+Error(e2)+". Usuario: "+session.getAttribute("name").toString()+". Maquina: "+session.getAttribute("maquina").toString()+". Ip: "+session.getAttribute("ip").toString(),infoUsu.getCve_usuario());
			}
		}
	}

	private String[] InicializaQueryNumero11(String[] ListaQuerys, String uname, String uname_br, int folio, String uname_chofer) 
	{
		for (int i=0;i <ListaQuerys.length; i++)
		{	
			ListaQuerys[i]= ListaQuerys[i].replace("{UNAME_CDO_}",uname_chofer);
			ListaQuerys[i]= ListaQuerys[i].replace("{CDO_}",uname);
			ListaQuerys[i]= ListaQuerys[i].replace("{UNAME_}",uname.toUpperCase());
			ListaQuerys[i]= ListaQuerys[i].replace("{FOLIO}",String.valueOf(folio));
		}
		return ListaQuerys;
	}

	private String[] InicializaQueryNumero52(String[] ListaQuerys, String uname, String uname_br, String ode, String uname_chofer)
	{
		for (int i=0;i <ListaQuerys.length; i++)
		{	
			ListaQuerys[i]= ListaQuerys[i].replace("{UNAME_CHOFER}",uname_chofer);
			ListaQuerys[i]= ListaQuerys[i].replace("{ODES}",ode);
		}
		return ListaQuerys;
	}

	private String[] InicializaQueryNumero63(String[] ListaQuerys, String uname, String uname_br, String factura, String uname_chofer)
	{
		for (int i=0;i <ListaQuerys.length; i++)
		{	
			ListaQuerys[i]= ListaQuerys[i].replace("{UNAME_CHOFER}",uname_chofer);
			ListaQuerys[i]= ListaQuerys[i].replace("{FACTURAS}",factura);
		}
		return ListaQuerys;
	}
	
	private String[] InicializaQueryNumero68(String[] ListaQuerys, String factura, String uname)
	{
		for (int i=0;i <ListaQuerys.length; i++)
		{	
			ListaQuerys[i]= ListaQuerys[i].replace("{FACTURAS}",factura);
			ListaQuerys[i]= ListaQuerys[i].replace("{UNAME}",uname.toUpperCase());
		}
		return ListaQuerys;
	}

	private String obtenerFolioConsecutivo(List<Querys> ListaQuerys, String uname, String uname_br, Connection connBDm,PreparedStatement pstmm, Usuario infoUsu, String uname_chofer, HttpSession session) 
	{
		String FOLIO = "";
		String [] querys = new String [25];
		Connection connBD = null;
		PreparedStatement pstm = null;
		connBD = ConexionBD.AbrirConexionBDD(uname.toUpperCase());
		try
		{
			querys = Cls_Querys.LimpiaListaQuerys(querys);
			querys = Cls_Querys.ObtieneQuerys(3, ListaQuerys, querys, infoUsu);
			querys = InicializaQueryNumero3(querys,uname,uname_br,uname_chofer);
			pstm = connBD.prepareStatement("{call " + "ALMACEN.usp_EXECUTE_QUERY(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			ResultSet rs = EjecutaQuerysBD.EjecutarQuery(querys[0], querys[1],querys[2], querys[3], querys[4], querys[5], querys[6],
					 querys[7], querys[8], querys[9],querys[10], querys[11], querys[12], querys[13], 
					 querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], 
					 querys[21], querys[22], querys[23], querys[24], infoUsu.getUname(),pstm, connBD,infoUsu);
			
			if (rs != null) 
			{
				while (rs.next())
				{
					FOLIO = rs.getString("folio");
				}
			}
			InsertarLogAlamacen.insertarLog(new LogAlmacen("","",""),uname,infoUsu.getUname_br(),"Consulta folio consecutivo. FOLIO: "+FOLIO+". Qry["+Qry(seprado(querys))+"]."+". Usuario: "+session.getAttribute("name").toString()+". Maquina: "+session.getAttribute("name").toString()+". Ip: "+session.getAttribute("ip").toString(),infoUsu.getCve_usuario());
		}
		catch (Exception e) 
		{
			InsertarLogAlamacen.insertarLog(new LogAlmacen("","",""),uname,infoUsu.getUname_br(),"Error al obtener folio consecutivo. FOLIO: "+FOLIO+". DETALLE: "+Error(e)+". Qry["+Qry(seprado(querys))+"]."+". Usuario: "+session.getAttribute("name").toString()+". Maquina: "+session.getAttribute("name").toString()+". Ip: "+session.getAttribute("ip").toString(),infoUsu.getCve_usuario());
		}
		finally 
		{
			try 
			{
				pstm.close();
				connBD.close();				
			} catch (Exception e2)
			{
				InsertarLogAlamacen.insertarLog(new LogAlmacen("","",""),infoUsu.getUname(),infoUsu.getUname_br(),"Error al cerrar conexion y pstm folioconsecutivor. FOLIO: "+FOLIO+". DETALLE: "+Error(e2)+". Usuario: "+session.getAttribute("name").toString()+". Maquina: "+session.getAttribute("maquina").toString()+". Ip: "+session.getAttribute("ip").toString(),infoUsu.getCve_usuario());
			}
		}
		
		return FOLIO;
	}

	private String obtenerFolioCartaPorteConsecutivo(List<Querys> ListaQuerys, String uname, String uname_br, Connection connBDm,PreparedStatement pstmm, Usuario infoUsu, String uname_chofer, HttpSession session) 
	{
		String FOLIO = "";
		String [] querys = new String [25];
		Connection connBD = null;
		PreparedStatement pstm = null;
		connBD = ConexionBD.AbrirConexionBDD(uname.toUpperCase());
		try
		{
			querys = Cls_Querys.LimpiaListaQuerys(querys);
			querys = Cls_Querys.ObtieneQuerys(57, ListaQuerys, querys, infoUsu);
			querys = InicializaQueryNumero3(querys,uname,uname_br,uname_chofer);
			pstm = connBD.prepareStatement("{call " + "ALMACEN.usp_EXECUTE_QUERY(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			ResultSet rs = EjecutaQuerysBD.EjecutarQuery(querys[0], querys[1],querys[2], querys[3], querys[4], querys[5], querys[6],
					 querys[7], querys[8], querys[9],querys[10], querys[11], querys[12], querys[13], 
					 querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], 
					 querys[21], querys[22], querys[23], querys[24], infoUsu.getUname(),pstm, connBD,infoUsu);
			
			if (rs != null) 
			{
				while (rs.next())
				{
					FOLIO = rs.getString("folio");
				}
			}
			InsertarLogAlamacen.insertarLog(new LogAlmacen("","",""),uname,infoUsu.getUname_br(),"Consulta folio consecutivo de Carta porte. FOLIO: "+FOLIO+". Qry["+Qry(seprado(querys))+"]."+". Usuario: "+session.getAttribute("name").toString()+". Maquina: "+session.getAttribute("name").toString()+". Ip: "+session.getAttribute("ip").toString(),infoUsu.getCve_usuario());
		}
		catch (Exception e) 
		{
			InsertarLogAlamacen.insertarLog(new LogAlmacen("","",""),uname,infoUsu.getUname_br(),"Error al obtener folio consecutivo de Carta porte. FOLIO: "+FOLIO+". DETALLE: "+Error(e)+". Qry["+Qry(seprado(querys))+"]."+". Usuario: "+session.getAttribute("name").toString()+". Maquina: "+session.getAttribute("name").toString()+". Ip: "+session.getAttribute("ip").toString(),infoUsu.getCve_usuario());
		}
		finally 
		{
			try 
			{
				pstm.close();
				connBD.close();
			} catch (Exception e2)
			{
				InsertarLogAlamacen.insertarLog(new LogAlmacen("","",""),infoUsu.getUname(),infoUsu.getUname_br(),"Error al cerrar conexion y pstm folio consecutivo de Carta porte. FOLIO: "+FOLIO+". DETALLE: "+Error(e2)+". Usuario: "+session.getAttribute("name").toString()+". Maquina: "+session.getAttribute("maquina").toString()+". Ip: "+session.getAttribute("ip").toString(),infoUsu.getCve_usuario());
			}
		}
		return FOLIO;
	}

	private String[] InicializaQueryNumero3(String[] ListaQuerys, String uname, String uname_br, String uname_chofer) 
	{
		for (int i=0;i <ListaQuerys.length; i++)
		{	
			ListaQuerys[i]= ListaQuerys[i].replace("{UNAME_CDO_}",uname.toLowerCase());
			ListaQuerys[i]= ListaQuerys[i].replace("{UNAME_BR_CDO}",uname_chofer);
			ListaQuerys[i]= ListaQuerys[i].replace("{UNAME_}",uname.toUpperCase());
		}
		return ListaQuerys;
	}
	
	private String consultaExistenciaFactura(String pedidosRC, String chofer, String uname, HttpSession session,String usuario, String uname_br, String cdo_nombre, String facturaAgregada, String transporte,Usuario infoUsu) {
		String rsp = "Error al consultar existencia de FACTURA";
		String factura = "";
		String msj = "";
		List<PedidosConsultaRC> lstPedidosRC = (List<PedidosConsultaRC>) session.getAttribute("lstPedidosRC");
		if(!facturaAgregada.contains(",")) {
			facturaAgregada = facturaAgregada+",";
		}
		String split[] = facturaAgregada.split(",");
		
		for(int i = 0; i<split.length; i++) {
			for(int j = 0; j < split.length; j++) {
				if(i != j) {
					if(split[i].equals(split[j])) {
						msj = "INGRESO FACTURA REPETIDAS, VERIFIQUE";
						rsp = "INGRESO FACTURA REPETIDAS, VERIFIQUE";
						break;
					}
				}
			}
		}
		
		if(msj.equals("")) 
		{
			for(String s : split) 
			{
				int aux = 0;
				for(PedidosConsultaRC pRC : lstPedidosRC) 
				{
					if(pRC.getFacturaTraslado().equals(s)) 
					{
						rsp = "true";
						aux = 1;
						factura = factura +","+pRC.getFacturaTraslado();
					}
				}
				if (aux == 0) 
				{
					rsp = "Debe consultar la FACTURA: "+s+" antes de asignarla.";
					break;
				}
			}
			session.setAttribute("valorPed", factura);
		}
		return rsp;	
	}
	
	private String consultaExistenciaFacturaORDEN(String pedidosRC, String chofer, String uname, HttpSession session,String usuario, String uname_br, String cdo_nombre, String facturaAgregada, String transporte,Usuario infoUsu) {
		String rsp = "Error al consultar existencia de FACTURA";
		String factura = "";
		String msj = "";
		List<PedidosConsultaRC> lstPedidosRC = (List<PedidosConsultaRC>) session.getAttribute("lstPedidosRC");
		if(!facturaAgregada.contains(",")) {
			facturaAgregada = facturaAgregada+",";
		}
		String split[] = facturaAgregada.split(",");
		
		for(int i = 0; i<split.length; i++) {
			for(int j = 0; j < split.length; j++) {
				if(i != j) {
					if(split[i].equals(split[j])) {
						msj = "INGRESO FACTURA REPETIDAS, VERIFIQUE";
						rsp = "INGRESO FACTURA REPETIDAS, VERIFIQUE";
						break;
					}
				}
			}
		}
		
		if(msj.equals("")) 
		{
			for(String s : split) 
			{
				int aux = 0;
				for(PedidosConsultaRC pRC : lstPedidosRC) 
				{
					if(pRC.getFacturaTraslado().equals(s)) 
					{
						rsp = "true";
						aux = 1;
						factura = factura +","+pRC.getFacturaTraslado();
					}
				}
				if (aux == 0) 
				{
					rsp = "Debe consultar la FACTURA: "+s+" antes de asignarla.";
					break;
				}
			}
			session.setAttribute("valorPedORDEN", factura);
		}
		return rsp;	
	}

	private String consultaExistenciaOde(String pedidos, String chofer, String uname, HttpSession session,String usuario, String uname_br, String cdo_nombre, String odeAgregada, String transporte,Usuario infoUsu) 
	{
		String rsp = "Error al consultar existencia de ODE";
		String noConsec = "";
		String msj = "";
		List<PedidosConsulta> lstPedidos = (List<PedidosConsulta>) session.getAttribute("listaPedidos");
		if (!odeAgregada.contains(",")) 
		{
			odeAgregada = odeAgregada+",";
		}
		
		String split[] = odeAgregada.split(",");
		
		
		for (int i = 0; i < split.length; i++) 
		{
			for (int j = 0; j < split.length; j++) 
			{
				if (i != j) 
				{
					if (split[i].equals(split[j])) 
					{
						msj = "INGRESO ODE REPETIDAS, VERIFIQUE.";
						rsp = "INGRESO ODE REPETIDAS, VERIFIQUE.";
						break;
					}
				}
			}
		}
		
		if (msj.equals("")) 
		{
			for (String s : split) 
			{
				int aux = 0;
				for (PedidosConsulta p : lstPedidos) 
				{
					if (p.getOde().equals(s))
					{
						rsp = "true";
						aux = 1;
						noConsec = noConsec+","+p.getNo();
					}
					
				}
				if (aux == 0) 
				{
					rsp = "Debe consultar la ODE: "+s+" antes de asignarla.";
					break;
				}
			}
			session.setAttribute("valorPed", noConsec);
		}
		
		return rsp;
	}

	private String consultaExistenciaOdeORDEN(String pedidos, String chofer, String uname, HttpSession session,String usuario, String uname_br, String cdo_nombre, String odeAgregada, String transporte,Usuario infoUsu) 
	{
		String rsp = "Error al consultar existencia de ODE";
		String noConsec = "";
		String msj = "";
		List<PedidosConsulta> lstPedidos = (List<PedidosConsulta>) session.getAttribute("listaPedidos");
		if (!odeAgregada.contains(",")) 
		{
			odeAgregada = odeAgregada+",";
		}
		
		String split[] = odeAgregada.split(",");
		
		
		for (int i = 0; i < split.length; i++) 
		{
			for (int j = 0; j < split.length; j++) 
			{
				if (i != j) 
				{
					if (split[i].equals(split[j])) 
					{
						msj = "INGRESO ODE REPETIDAS, VERIFIQUE.";
						rsp = "INGRESO ODE REPETIDAS, VERIFIQUE.";
						break;
					}
				}
			}
		}
		
		if (msj.equals("")) 
		{
			for (String s : split) 
			{
				int aux = 0;
				for (PedidosConsulta p : lstPedidos) 
				{
					if (p.getOde().equals(s))
					{
						rsp = "true";
						aux = 1;
						noConsec = noConsec+","+p.getNo();
					}
					
				}
				if (aux == 0) 
				{
					rsp = "Debe consultar la ODE: "+s+" antes de asignarla.";
					break;
				}
			}
			session.setAttribute("valorPedORDEN", noConsec);
		}
		
		return rsp;
	}

    public int obtenerNumeroLlantas(List<Querys> ListaQuerys, Usuario infoUsu) {
    	int numeroLlantas = 0;
    	String qry = "";
		Connection connBD = null;
		PreparedStatement pstm = null;
		connBD = ConexionBD.AbrirConexionBDD(infoUsu.getUname().toUpperCase());
    	
    	try {
			String [] querys = new String [25];
			querys = Cls_Querys.LimpiaListaQuerys(querys);
			querys = Cls_Querys.ObtieneQuerys(59, ListaQuerys, querys, infoUsu);
			pstm = connBD.prepareStatement("{call " + "ALMACEN.usp_EXECUTE_QUERY(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			ResultSet rs = EjecutaQuerysBD.EjecutarQuery(querys[0], querys[1],querys[2], querys[3], querys[4], querys[5], querys[6],
					 querys[7], querys[8], querys[9],querys[10], querys[11], querys[12], querys[13], 
					 querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], 
					 querys[21], querys[22], querys[23], querys[24], infoUsu.getUname(),pstm, connBD,infoUsu);
			if(rs!=null) {
				while(rs.next()) {
					numeroLlantas = Integer.parseInt(rs.getString("numero_llantas"));
				}
			}
		}catch(Exception e) {
			   System.out.println("GestorPedidos.insertarEncabezado.- Error al recuperar numero de llantas: "+e);
		}finally {
			try{pstm.close();}catch(Exception e) {};	
			try{connBD.close();}catch(Exception e) {};
		}
    	return numeroLlantas;
    }		
	
    private String insertarEncabezadoRC(String cdo, String uname_br, String fOLIO, String chofer, String usuario,List<PedidosConsultaRC> p, String[] split, List<Querys> ListaQuerys, Usuario infoUsu, Connection connBDm, PreparedStatement pstmm, String uname_chofer, HttpSession session, String vehiculo,String fOLIO_CARTA_PORTE,int nLlantas) {
    	String rsp = "";
		
		String qry = "";
		Connection connBD = null;
		PreparedStatement pstm = null;
		connBD = ConexionBD.AbrirConexionBDD(infoUsu.getUname().toUpperCase());
			
		try 
		{
			for (String s : split) 
			{
				for (PedidosConsultaRC pp : p) 
				{
				
					if (pp.getFacturaTraslado().equals(s)) 
					{
						String [] querys = new String [25];
						try
						{
							querys = Cls_Querys.LimpiaListaQuerys(querys);
							querys = Cls_Querys.ObtieneQuerys(73, ListaQuerys, querys, infoUsu);
							//System.out.println("tipo: "+pp.getTipo());
							
								
							
							querys = InicializaQueryNumero4RC(querys, infoUsu,cdo,pp.getUname(),fOLIO,chofer,usuario,uname_chofer,vehiculo,fOLIO_CARTA_PORTE,nLlantas,pp.getTipo());
							Cls_Querys.ImprimeQuerysConsola(querys,false, "Query 73");
							for (String string : querys) 
							{
								qry = qry + string + ",";
							}
							pstm = connBD.prepareStatement("{call " + "ALMACEN.usp_EXECUTE_QUERY(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
							ResultSet rs = EjecutaQuerysBD.EjecutarQuery(querys[0], querys[1],querys[2], querys[3], querys[4], querys[5], querys[6],
									 querys[7], querys[8], querys[9],querys[10], querys[11], querys[12], querys[13], 
									 querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], 
									 querys[21], querys[22], querys[23], querys[24], infoUsu.getUname(),pstm, connBD,infoUsu);
							
							InsertarLogAlamacen.insertarLog(new LogAlmacen("","",""),cdo,uname_br,"Inserta Encabezado y Chofer por "+session.getAttribute("choferTipo")+", FOLIO: "+fOLIO+". CHOFER: "+chofer+". Qry["+Qry(seprado(querys))+"]",usuario);
							rsp = "true";
						}
						catch (Exception e) 
						{
							InsertarLogAlamacen.insertarLog(new LogAlmacen("","",""),cdo,infoUsu.getUname_br(),"Error al insertar encabezado o chofer por "+session.getAttribute("choferTipo")+", FOLIO: "+fOLIO+". CHOFER: "+chofer+". DETALLE: "+Error(e)+". QRY["+Qry(seprado(querys))+"]"+". Usuario: "+session.getAttribute("name").toString()+". Maquina: "+session.getAttribute("maquina").toString()+". Ip: "+session.getAttribute("ip").toString(),infoUsu.getCve_usuario());
						}
					break;
					}
				}
			}
			
		/*	for (PedidosConsultaRC pp : p) 
			{
				
			}  */
		}
		catch (Exception e) 
		{
			InsertarLogAlamacen.insertarLog(new LogAlmacen("","",""),cdo,infoUsu.getUname_br(),"Error en metodo insertar encabezado o chofer por "+session.getAttribute("choferTipo")+", FOLIO: "+fOLIO+". DETALLE: "+Error(e)+". Usuario: "+session.getAttribute("name").toString()+". Maquina: "+session.getAttribute("maquina").toString()+". Ip: "+session.getAttribute("ip").toString(),infoUsu.getCve_usuario());
		}
		finally 
		{
			try 
			{
				pstm.close();
				connBD.close();
			} catch (Exception e2)
			{
				InsertarLogAlamacen.insertarLog(new LogAlmacen("","",""),infoUsu.getUname(),infoUsu.getUname_br(),"Error al cerrar conexion y pstm insertar encabezado por "+session.getAttribute("choferTipo")+". DETALLE: "+Error(e2)+". Usuario: "+session.getAttribute("name").toString()+". Maquina: "+session.getAttribute("maquina").toString()+". Ip: "+session.getAttribute("ip").toString(),infoUsu.getCve_usuario());
			}
		}
		return rsp;
    }
    
	private String insertarEncabezado(String cdo, String uname_br, String fOLIO, String chofer, String usuario,List<PedidosConsulta> p, String[] split, List<Querys> ListaQuerys, Usuario infoUsu, Connection connBDm, PreparedStatement pstmm, String uname_chofer, HttpSession session, String vehiculo,String fOLIO_CARTA_PORTE,int nLlantas) 
	{
		
		String rsp = "";
		
		String qry = "";
		Connection connBD = null;
		PreparedStatement pstm = null;
		connBD = ConexionBD.AbrirConexionBDD(infoUsu.getUname().toUpperCase());
		
	
		try 
		{
			for (PedidosConsulta pp : p) 
			{
				
				String [] querys = new String [25];
				try
				{
					querys = Cls_Querys.LimpiaListaQuerys(querys);
					querys = Cls_Querys.ObtieneQuerys(4, ListaQuerys, querys, infoUsu);
					querys = InicializaQueryNumero4(querys, infoUsu,cdo,pp.getUname(),fOLIO,chofer,usuario,uname_chofer,vehiculo,fOLIO_CARTA_PORTE,nLlantas);
					for (String string : querys) 
					{
						qry = qry + string + ",";
					}
					pstm = connBD.prepareStatement("{call " + "ALMACEN.usp_EXECUTE_QUERY(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
					ResultSet rs = EjecutaQuerysBD.EjecutarQuery(querys[0], querys[1],querys[2], querys[3], querys[4], querys[5], querys[6],
							 querys[7], querys[8], querys[9],querys[10], querys[11], querys[12], querys[13], 
							 querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], 
							 querys[21], querys[22], querys[23], querys[24], infoUsu.getUname(),pstm, connBD,infoUsu);
					
					InsertarLogAlamacen.insertarLog(new LogAlmacen("","",""),cdo,uname_br,"Inserta Encabezado y Chofer por "+session.getAttribute("choferTipo")+", FOLIO: "+fOLIO+". CHOFER: "+chofer+". Qry["+Qry(seprado(querys))+"]",usuario);
					rsp = "true";
				}
				catch (Exception e) 
				{
					InsertarLogAlamacen.insertarLog(new LogAlmacen("","",""),cdo,infoUsu.getUname_br(),"Error al insertar encabezado o chofer por "+session.getAttribute("choferTipo")+", FOLIO: "+fOLIO+". CHOFER: "+chofer+". DETALLE: "+Error(e)+". QRY["+Qry(seprado(querys))+"]"+". Usuario: "+session.getAttribute("name").toString()+". Maquina: "+session.getAttribute("maquina").toString()+". Ip: "+session.getAttribute("ip").toString(),infoUsu.getCve_usuario());
				}
			break;
			}
		}
		catch (Exception e) 
		{
			InsertarLogAlamacen.insertarLog(new LogAlmacen("","",""),cdo,infoUsu.getUname_br(),"Error en metodo insertar encabezado o chofer por "+session.getAttribute("choferTipo")+", FOLIO: "+fOLIO+". DETALLE: "+Error(e)+". Usuario: "+session.getAttribute("name").toString()+". Maquina: "+session.getAttribute("maquina").toString()+". Ip: "+session.getAttribute("ip").toString(),infoUsu.getCve_usuario());
		}
		finally 
		{
			try 
			{
				connBD.close();
				pstm.close();
			} catch (Exception e2)
			{
				InsertarLogAlamacen.insertarLog(new LogAlmacen("","",""),infoUsu.getUname(),infoUsu.getUname_br(),"Error al cerrar conexion y pstm insertar encabezado por "+session.getAttribute("choferTipo")+". DETALLE: "+Error(e2)+". Usuario: "+session.getAttribute("name").toString()+". Maquina: "+session.getAttribute("maquina").toString()+". Ip: "+session.getAttribute("ip").toString(),infoUsu.getCve_usuario());
			}
		}
		return rsp;
	}
	
	private String[] InicializaQueryNumero4RC(String[] ListaQuerys, Usuario infoUsu, String cdo, String uname, String folio,String chofer, String usuario, String uname_chofer, String vehiculo, String folioCartaPorte, int nLlantas, String tipo) 
	{
		String placa = "";
		String llantas = "";
		String generarCartaPorte = "N";
		int numLlantas = 0;
		try
		{
		String split [] = vehiculo.split("\\*");
		placa = split[0];
		llantas = split[1].trim();
		numLlantas = Integer.parseInt(llantas);
		}
		catch (Exception e) 
		{
			numLlantas = 0;
			generarCartaPorte = "N";
			InsertarLogAlamacen.insertarLog(new LogAlmacen("","",""),infoUsu.getUname(),infoUsu.getUname_br(),"Error al splitear vehiculo encabezdo",infoUsu.getCve_usuario());
		}
		
		
			if(numLlantas >= nLlantas)
			{
				generarCartaPorte = "S";
			}
			

		for (int i=0;i <ListaQuerys.length; i++)
		{	
			ListaQuerys[i]= ListaQuerys[i].replace("{CDO_}",cdo);
			ListaQuerys[i]= ListaQuerys[i].replace("{UNAME_}",uname.toUpperCase());
			ListaQuerys[i]= ListaQuerys[i].replace("{UNAME_CDO_ASIGNACION}",infoUsu.getUname_br());
			ListaQuerys[i]= ListaQuerys[i].replace("{UNAME_CDO_}",uname_chofer);
			ListaQuerys[i]= ListaQuerys[i].replace("{FOLIO}",folio);
			ListaQuerys[i]= ListaQuerys[i].replace("{CHOFER}",chofer);
			ListaQuerys[i]= ListaQuerys[i].replace("{USUARIO}",usuario);
			ListaQuerys[i]= ListaQuerys[i].replace("{LLANTAS}",llantas);
			ListaQuerys[i]= ListaQuerys[i].replace("{PLACA}",placa);
			ListaQuerys[i]= ListaQuerys[i].replace("{GENERA_CARTA}",generarCartaPorte);
			ListaQuerys[i]= ListaQuerys[i].replace("{FOLIO_CARTA}",folioCartaPorte);
			ListaQuerys[i]= ListaQuerys[i].replace("{TIPO}",tipo.toUpperCase());
		}
		return ListaQuerys;
	}
	
	private String[] InicializaQueryNumero4(String[] ListaQuerys, Usuario infoUsu, String cdo, String uname, String folio,String chofer, String usuario, String uname_chofer, String vehiculo, String folioCartaPorte, int nLlantas) 
	{
		String placa = "";
		String llantas = "";
		String generarCartaPorte = "N";
		int numLlantas = 0;
		try
		{
		String split [] = vehiculo.split("\\*");
		placa = split[0];
		llantas = split[1].trim();
		numLlantas = Integer.parseInt(llantas);
		}
		catch (Exception e) 
		{
			numLlantas = 0;
			generarCartaPorte = "N";
			InsertarLogAlamacen.insertarLog(new LogAlmacen("","",""),infoUsu.getUname(),infoUsu.getUname_br(),"Error al splitear vehiculo encabezdo",infoUsu.getCve_usuario());
		}
		
		
			if(numLlantas >= nLlantas)
			{
				generarCartaPorte = "S";
			}
			

		for (int i=0;i <ListaQuerys.length; i++)
		{	
			ListaQuerys[i]= ListaQuerys[i].replace("{CDO_}",cdo);
			ListaQuerys[i]= ListaQuerys[i].replace("{UNAME_}",uname.toUpperCase());
			ListaQuerys[i]= ListaQuerys[i].replace("{UNAME_CDO_ASIGNACION}",infoUsu.getUname_br());
			ListaQuerys[i]= ListaQuerys[i].replace("{UNAME_CDO_}",uname_chofer);
			ListaQuerys[i]= ListaQuerys[i].replace("{FOLIO}",folio);
			ListaQuerys[i]= ListaQuerys[i].replace("{CHOFER}",chofer);
			ListaQuerys[i]= ListaQuerys[i].replace("{USUARIO}",usuario);
			ListaQuerys[i]= ListaQuerys[i].replace("{LLANTAS}",llantas);
			ListaQuerys[i]= ListaQuerys[i].replace("{PLACA}",placa);
			ListaQuerys[i]= ListaQuerys[i].replace("{GENERA_CARTA}",generarCartaPorte);
			ListaQuerys[i]= ListaQuerys[i].replace("{FOLIO_CARTA}",folioCartaPorte);		
		}
		return ListaQuerys;
	}


	private String insertarEncabezadoTrans(String cdo, String uname_br, String fOLIO, String chofer, String usuario,List<PedidosConsulta> p, String[] split, Usuario infoUsu, List<Querys> ListaQuerys, Connection connBD, PreparedStatement pstm, HttpSession session) 
	{
		String rsp = "";
		String pedidos = "";

		String qry = "";
		try 
		{
			for (PedidosConsulta pp : p) 
			{
				String [] querys = new String [25];
				try
				{
					querys = Cls_Querys.LimpiaListaQuerys(querys);
					querys = Cls_Querys.ObtieneQuerys(20, ListaQuerys, querys, infoUsu);
					querys = InicializaQueryNumero20(querys, infoUsu,cdo,pp.getUname(),fOLIO,chofer,usuario);
					Cls_Querys.ImprimeQuerysConsola(querys,false, "Query 20");
					pstm = connBD.prepareStatement("{call " + "ALMACEN.usp_EXECUTE_QUERY(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
					ResultSet rs = EjecutaQuerysBD.EjecutarQuery(querys[0], querys[1],querys[2], querys[3], querys[4], querys[5], querys[6],
							 querys[7], querys[8], querys[9],querys[10], querys[11], querys[12], querys[13], 
							 querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], 
							 querys[21], querys[22], querys[23], querys[24], infoUsu.getUname(),pstm, connBD,infoUsu);
					InsertarLogAlamacen.insertarLog(new LogAlmacen("","",""),cdo,uname_br,"Inserta Encabezado por "+session.getAttribute("transporteTipo")+". TRANSPORTE, FOLIO: "+fOLIO+". TRANSPORTE: "+chofer+". Qry["+Qry(seprado(querys))+"]"+". Usuario: "+session.getAttribute("name").toString()+". Maquina: "+session.getAttribute("maquina").toString()+". Ip: "+session.getAttribute("ip").toString(),usuario);
					rsp = "true";
					break;
				}
				catch (Exception e) 
				{
					InsertarLogAlamacen.insertarLog(new LogAlmacen("","",""),cdo,infoUsu.getUname_br(),"Error al insertar encabezado. TRANSPORTE. FOLIO: "+fOLIO+". TRANSPORTE: "+chofer+". DETALLE: "+Error(e)+". QRY["+Qry(seprado(querys))+"]"+". Usuario: "+session.getAttribute("name").toString()+". Maquina: "+session.getAttribute("maquina").toString()+". Ip: "+session.getAttribute("ip").toString(),infoUsu.getCve_usuario());	
				}
			}
		}
		catch (Exception e) 
		{
			InsertarLogAlamacen.insertarLog(new LogAlmacen("","",""),cdo,infoUsu.getUname_br(),"Error en metodo insertar encabezado, FOLIO: "+fOLIO+". DETALLE: "+Error(e)+". Usuario: "+session.getAttribute("name").toString()+". Maquina: "+session.getAttribute("maquina").toString()+". Ip: "+session.getAttribute("ip").toString(),infoUsu.getCve_usuario());
		}
		return rsp;
	}

	
	private String obtenerProcesoQryDetalleRC(String[] split, String chofer, String cdo, HttpSession session, List<PedidosConsultaRC> articulosDetalle, String ss, String usuario, String uname_br, String FOLIO, List<Querys> listaQuerys, Usuario infoUsu, Connection connBD1, PreparedStatement pstm1, String[] split2, String uname_chofer, String numeroFacturas)
	{
		String respuesta = "n";
		String iinsertFac = "";
		InsertarLogAlamacen.insertarLog(new LogAlmacen("","",""),infoUsu.getUname(),infoUsu.getUname_br(),"Se asignaran por chofer: " + numeroFacturas + ". En el folio: "+FOLIO+".",infoUsu.getCve_usuario());
		String insertSeccion = "";
		String insertDetalle = "";
		String insertAsig = "";
		String insertRepro = "";
		Connection connBD = null;
		PreparedStatement pstm = null;
		List<ClientesCredito> lstCredito = new ArrayList<>();
		
		lstCredito = (List<ClientesCredito>) session.getAttribute("clientesCredito");
		//System.out.println("lstCredito: "+lstCredito);
		List<Consecutivo> lstConsecutivo = new ArrayList<>();
		String insertCliente = "";
		
		
		String validacionFacturaYaInsertada = "";
		int auxiliar = 0;
	//	System.out.println("split: "+split[0]);
		for (String s : split) 
		{
		//	System.out.println("s: "+s);
			String pedidoTipo = "";
			//if (s.contains("r"))
			//{
				String splitAux [] = s.split("\\*");
				pedidoTipo = "s";
				s = splitAux[0];
				//String s2 = splitAux[1];
			//}
		for (PedidosConsultaRC pp : articulosDetalle) 
		{
			
			if (pp.getIdDetalleRC().equals(s)) 
			{
				try 
				{
				List<SeriesCfdi> series = (List<SeriesCfdi>) session.getAttribute("series");

					
						String estatus = "";
						int sts = 1;
						//if (!pp.getProgramada().equals("99")) 
						//{
							sts = 8;
//							insertAsig = insertAsig + "('"+infoUsu.getUname()+"', '"+uname_chofer+"', "+pp.getOde()+", "+pp.getPedido()+", 1,"+pp.getId_trayecto()+", CURDATE(), CURTIME()),";
							
						//	insertAsig = insertAsig + "('"+infoUsu.getUname()+"', '"+pp.getUname()+"', "+pp.getFacturaTraslado()+", "+pp.getRemision()+", 1,"+pp.getIdTrayecto()+", CURDATE(), CURTIME()),";
							
							insertRepro = insertRepro + "('"+infoUsu.getUname()+"', '"+uname_chofer+"', "+pp.getFacturaTraslado()+", "+pp.getRemision()+", "+FOLIO+", 1,CURDATE(), CURTIME()),";
//							actualizarRepro(listaQuerys,session,pp.getOde(),pp.getPedido(),infoUsu,FOLIO);
						//}
						//else
						//{
							insertAsig = insertAsig + "('"+infoUsu.getUname()+"', '"+infoUsu.getUname_br()+"', '0', "+pp.getRemision()+", 1,NULL, CURDATE(), CURTIME()),";
//							actualizarRepro(listaQuerys,session,pp.getOde(),pp.getPedido(),infoUsu,FOLIO);
						//}
						
						
						
						/*if (!pedidoTipo.equals("")){pedidoTipo = "1";}
						else {pedidoTipo = "0";}*/
					//	System.out.println("InsertaCliente.");
					//	System.out.println("pp.getConsecutivo(): "+pp.getConsecutivo().length());
						if (pp.getConsecutivo() != null && pp.getConsecutivo() != "") 
						{
					//		System.out.println("InsertaCliente....1");
							insertCliente = insertCliente  + "('"+infoUsu.getUname()+"', '"+uname_chofer+"','"+FOLIO+"','"+pp.getCteDestino()+"','"+pp.getConsecutivo()+"',CURDATE(),CURTIME()),";
						}
						else
						{
							if (lstConsecutivo.size() > 0) 
							{
					//			System.out.println("InsertaCliente....2");
								boolean rsp = false;
								for (Consecutivo itemConsecutivo : lstConsecutivo) 
								{
									if (Integer.parseInt(pp.getCteDestino()) == itemConsecutivo.getCliente()) 
									{
										rsp = true;
										break;
									}
								}
								if (!rsp) 
								{
									auxiliar++;
									insertCliente = insertCliente  + "('"+infoUsu.getUname()+"', '"+uname_chofer+"','"+FOLIO+"','"+pp.getCteDestino()+"','"+auxiliar+"',CURDATE(),CURTIME()),";
									Consecutivo objConsec = new Consecutivo();
									objConsec.setCliente(Integer.parseInt(pp.getCteDestino()));
									objConsec.setConsecutivo(auxiliar);
									lstConsecutivo.add(objConsec);	
								}
							}
							else
							{
					//			System.out.println("InsertaCliente....3");
								auxiliar++;
								insertCliente = insertCliente  + "('"+infoUsu.getUname()+"', '"+uname_chofer+"','"+FOLIO+"','"+pp.getCteDestino()+"','"+auxiliar+"',CURDATE(),CURTIME()),";
								Consecutivo objConsec = new Consecutivo();
								objConsec.setCliente(Integer.parseInt(pp.getCteDestino()));
								objConsec.setConsecutivo(auxiliar);
								lstConsecutivo.add(objConsec);
							}
						}
						// En caso que se desee cortar la factura a los ultimos 7 digitos. 
						String facturaTraslado = pp.getFacturaTraslado().substring(Math.max(0, pp.getFacturaTraslado().length() - 7));
						
						insertDetalle = insertDetalle + "('"+infoUsu.getUname()+"', '"+infoUsu.getUname_br()+"','"+FOLIO+"', '"+pp.getCteDestino()+"','0','"+pp.getRemision()+"',NULL,NULL,0, 0,0, 0, 0, 0,"+0+"),";
						insertSeccion = insertSeccion + "('"+infoUsu.getUname()+"', '"+infoUsu.getUname_br()+"','0','"+pp.getRemision()+"','"+FOLIO+"', 1, 1, 0),";
						iinsertFac = iinsertFac + "('"+infoUsu.getUname()+"', '"+infoUsu.getUname_br()+"','"+FOLIO+"','0','"+pp.getRemision()+"','"+facturaTraslado+"','0','0','0','0','0','0','0','0','0','','0', 0, '0',CURDATE(), CURTIME()),";
						
						
						/*if (session.getAttribute("choferTipo").equals("p")) 
						{
							for (PedidosConsultaRC l : p)  
							{
								
								if (pp.getFacturaTraslado().equals(l.getFacturaTraslado()) && pp.getRemision().equals(l.getRemision())) 
								{
									String condicion = "1";
									if (l.getCondicion().equals("1"))
									{
										for (ClientesCredito ll : lstCredito)
										{
											if (ll.getCliente().equals(l.getCteDestino()))
											{
												condicion = "0";
												break;
											}
										}
									}
									else
									{
										condicion = "0";
									}
									
									//iinsertFac = iinsertFac + "('"+cdo+"', '"+uname_chofer+"','"+FOLIO+"','"+l.getFacturaTraslado()+"','"+l.getPedido()+"','"+l.getFactura()+"','"+l.getImporte()+"','0','0','0','0','0','0','0','0','','"+condicion+"', 0, '0',CURDATE(), CURTIME()),";
								}
							}
						}
						else
						{
							if(!validacionFacturaYaInsertada.contains(pp.getFacturaTraslado()))
							{
								for (PedidosConsultaRC l : p)  
								{
									
									if (pp.getFacturaTraslado().equals(l.getFacturaTraslado())) 
									{
									//	InsertarLogAlamacen.insertarLog(new LogAlmacen("","",""),cdo,infoUsu.getUname_br(),"ODE: "+l.getOde()+". FACTURA: "+l.getFactura()+". CONDICION:  "+l.getCondicion()+". Usuario: "+session.getAttribute("name").toString()+". Maquina: "+session.getAttribute("maquina").toString()+". Ip: "+session.getAttribute("ip").toString(),infoUsu.getCve_usuario());
										String condicion = "1";
										if (l.getCondicion().equals("1"))
										{
											for (ClientesCredito ll : lstCredito)
											{
												if (ll.getCliente().equals(l.getCteDestino()))
												{
													condicion = "0";
													break;
												}
											}
										}
										else
										{
											condicion = "0";
										}
										
										//iinsertFac = iinsertFac + "('"+cdo+"', '"+uname_chofer+"','"+FOLIO+"','"+0+"','"+l.getPedido()+"','"+l.getFacturaTraslado()+"','"+l.getImporte()+"','0','0','0','0','0','0','0','0','','"+condicion+"', 0, '0',CURDATE(), CURTIME()),";
										validacionFacturaYaInsertada = validacionFacturaYaInsertada + pp.getFacturaTraslado()+ ",";
									}
								}
							}
						}*/
						
						
						respuesta = "s";
						break;
				}
				catch (Exception e) 
				{
					InsertarLogAlamacen.insertarLog(new LogAlmacen("","",""),cdo,infoUsu.getUname_br(),"Error al insertar el detalle de ruta en tablas. DETALLE: "+Error(e)+". Usuario: "+session.getAttribute("name").toString()+". Maquina: "+session.getAttribute("maquina").toString()+". Ip: "+session.getAttribute("ip").toString(),infoUsu.getCve_usuario());
				}

			}	
		}

		}
		if (!insertRepro.equals(""))
		{
			insertarReprogramada(insertRepro.substring(0,insertRepro.length()-1),connBD,pstm,listaQuerys,infoUsu,FOLIO,session);
		}
		insertarCliente(insertCliente.substring(0,insertCliente.length()-1),connBD,pstm,listaQuerys,infoUsu,FOLIO,session);
		if (!insertAsig.equals("") && !insertDetalle.equals("") && !iinsertFac.equals("") && !insertSeccion.equals(""))
		{
			boolean rsp = false;
		//	System.out.println(".1");
			rsp = actualizarOdeAsignada(insertAsig.substring(0,insertAsig.length()-1),infoUsu,connBD,pstm,listaQuerys,FOLIO,session);
		//	System.out.println(".2");
			if (rsp){			
				rsp = insertaDetalleChofer(insertDetalle.substring(0,insertDetalle.length()-1),connBD,pstm,infoUsu,listaQuerys,FOLIO,session);
		//		System.out.println(".3");
				if (rsp) {
					rsp = insertaDetalleFacturas(iinsertFac.substring(0,iinsertFac.length()-1),connBD,pstm,infoUsu,listaQuerys,FOLIO,session);
		//			System.out.println(".4");
					  if (rsp) {
						 rsp = insertaSeccion(insertSeccion.substring(0, insertSeccion.length()-1),connBD,pstm,infoUsu,listaQuerys,FOLIO,session);
		//				 System.out.println(".5");
					  }
				}
			}				
		}
		
		return respuesta;
	}
	
	private String obtenerProcesoQryRC(String[] split, String chofer, String cdo, HttpSession session, List<PedidosConsultaRC> p, String ss, String usuario, String uname_br, String FOLIO, List<Querys> listaQuerys, Usuario infoUsu, Connection connBD1, PreparedStatement pstm1, String[] split2, String uname_chofer, String numeroFacturas)
	{
		String respuesta = "n";
		String iinsertFac = "";
		InsertarLogAlamacen.insertarLog(new LogAlmacen("","",""),infoUsu.getUname(),infoUsu.getUname_br(),"Se asignaran por chofer: " + numeroFacturas + ". En el folio: "+FOLIO+".",infoUsu.getCve_usuario());
		String insertSeccion = "";
		String insertDetalle = "";
		String insertAsig = "";
		String insertRepro = "";
		Connection connBD = null;
		PreparedStatement pstm = null;
		List<ClientesCredito> lstCredito = new ArrayList<>();
		
		lstCredito = (List<ClientesCredito>) session.getAttribute("clientesCredito");
		List<Consecutivo> lstConsecutivo = new ArrayList<>();
		String insertCliente = "";
				
		String validacionFacturaYaInsertada = "";
		int auxiliar = 0;
		for (String s : split) 
		{
			for (PedidosConsultaRC pp : p) 
			{
			
				if (pp.getFacturaTraslado().equals(s)) 
				{
					try 
					{
					List<SeriesCfdi> series = (List<SeriesCfdi>) session.getAttribute("series");
	
						
							String estatus = "";
							int sts = 1;
							if (!pp.getProgramada().equals("0")) 
							{
								sts = 8;
	//							insertAsig = insertAsig + "('"+infoUsu.getUname()+"', '"+uname_chofer+"', "+pp.getOde()+", "+pp.getPedido()+", 1,"+pp.getId_trayecto()+", CURDATE(), CURTIME()),";
								
								insertAsig = insertAsig + "('"+infoUsu.getUname()+"', '"+infoUsu.getUname_br()+"', "+pp.getRemision()+", "+pp.getRemision()+", 1,"+pp.getIdTrayectoAnterior()+", CURDATE(), CURTIME()),";
								
								insertRepro = insertRepro + "('"+infoUsu.getUname()+"', '"+infoUsu.getUname_br()+"', "+pp.getRemision()+", "+pp.getRemision()+", "+FOLIO+", 1,CURDATE(), CURTIME()),";
	//							actualizarRepro(listaQuerys,session,pp.getOde(),pp.getPedido(),infoUsu,FOLIO);
							}
							else
							{
								insertAsig = insertAsig + "('"+infoUsu.getUname()+"', '"+infoUsu.getUname_br()+"', "+pp.getRemision()+" ,"+pp.getRemision()+", 1,NULL, CURDATE(), CURTIME()),";
	//							actualizarRepro(listaQuerys,session,pp.getOde(),pp.getPedido(),infoUsu,FOLIO);
							}
							
							if (pp.getConsecutivo() != null && pp.getConsecutivo() != "") 
							{
						//		System.out.println("InsertaCliente....1");
								insertCliente = insertCliente  + "('"+infoUsu.getUname()+"', '"+uname_chofer+"','"+FOLIO+"','"+pp.getCteDestino()+"','"+pp.getConsecutivo()+"',CURDATE(),CURTIME()),";
							}
							else
							{
								if (lstConsecutivo.size() > 0) 
								{
						//			System.out.println("InsertaCliente....2");
									boolean rsp = false;
									for (Consecutivo itemConsecutivo : lstConsecutivo) 
									{
										if (Integer.parseInt(pp.getCteDestino()) == itemConsecutivo.getCliente()) 
										{
											rsp = true;
											break;
										}
									}
									if (!rsp) 
									{
										auxiliar++;
										insertCliente = insertCliente  + "('"+infoUsu.getUname()+"', '"+uname_chofer+"','"+FOLIO+"','"+pp.getCteDestino()+"','"+auxiliar+"',CURDATE(),CURTIME()),";
										Consecutivo objConsec = new Consecutivo();
										objConsec.setCliente(Integer.parseInt(pp.getCteDestino()));
										objConsec.setConsecutivo(auxiliar);
										lstConsecutivo.add(objConsec);	
									}
								}
								else
								{
									auxiliar++;
									insertCliente = insertCliente  + "('"+infoUsu.getUname()+"', '"+uname_chofer+"','"+FOLIO+"','"+pp.getCteDestino()+"','"+auxiliar+"',CURDATE(),CURTIME()),";
									Consecutivo objConsec = new Consecutivo();
									objConsec.setCliente(Integer.parseInt(pp.getCteDestino()));
									objConsec.setConsecutivo(auxiliar);
									lstConsecutivo.add(objConsec);
								}
							}
							// En caso que se desee cortar la factura a los ultimos 7 digitos. 
							String facturaTraslado = pp.getFacturaTraslado().substring(Math.max(0, pp.getFacturaTraslado().length() - 7));
							
							insertDetalle = insertDetalle + "('"+infoUsu.getUname()+"', '"+infoUsu.getUname_br()+"','"+FOLIO+"', '"+pp.getCteDestino()+"', '"+pp.getRemision()+"', '"+pp.getRemision()+"',NULL,NULL,0, 0,0, 0, 0, 0,"+0+"),";
							insertSeccion = insertSeccion + "('"+infoUsu.getUname()+"', '"+infoUsu.getUname_br()+"','"+pp.getRemision()+"','"+pp.getRemision()+"','"+FOLIO+"', 1, 1, 0),";
							iinsertFac = iinsertFac + "('"+infoUsu.getUname()+"', '"+infoUsu.getUname_br()+"','"+FOLIO+"','"+pp.getRemision()+"','"+pp.getRemision()+"','"+facturaTraslado+"','0','0','0','0','0','0','0','0','0','','0', 0, '0','"+pp.getFacturaTraslado()+"',CURDATE(), CURTIME()),";
													
							respuesta = "s";
							break;
					}
					catch (Exception e) 
					{
						InsertarLogAlamacen.insertarLog(new LogAlmacen("","",""),cdo,infoUsu.getUname_br(),"Error al insertar el detalle de ruta en tablas. DETALLE: "+Error(e)+". Usuario: "+session.getAttribute("name").toString()+". Maquina: "+session.getAttribute("maquina").toString()+". Ip: "+session.getAttribute("ip").toString(),infoUsu.getCve_usuario());
					}
				}	
			}
		}
		if (!insertRepro.equals(""))
		{
			insertarReprogramada(insertRepro.substring(0,insertRepro.length()-1),connBD,pstm,listaQuerys,infoUsu,FOLIO,session);
		}
		insertarCliente(insertCliente.substring(0,insertCliente.length()-1),connBD,pstm,listaQuerys,infoUsu,FOLIO,session);
		if (!insertAsig.equals("") && !insertDetalle.equals("") && !iinsertFac.equals("") && !insertSeccion.equals(""))
		{
			boolean rsp = false;
			
			rsp = actualizarOdeAsignada(insertAsig.substring(0,insertAsig.length()-1),infoUsu,connBD,pstm,listaQuerys,FOLIO,session);
			if (rsp){			
				rsp = insertaDetalleChofer(insertDetalle.substring(0,insertDetalle.length()-1),connBD,pstm,infoUsu,listaQuerys,FOLIO,session);
				if (rsp) {
					rsp = insertaDetalleFacturas(iinsertFac.substring(0,iinsertFac.length()-1),connBD,pstm,infoUsu,listaQuerys,FOLIO,session);
					  if (rsp) {
						 rsp = insertaSeccion(insertSeccion.substring(0, insertSeccion.length()-1),connBD,pstm,infoUsu,listaQuerys,FOLIO,session);
					  }
				}
			}				
		}
		
		return respuesta;
	}
	
	
	private boolean actualizaEncabezadoDetalleRC(Usuario infoUsu, Connection connBD, PreparedStatement pstm, List<Querys> listaQuerys, String factura, String id) {
		boolean facturaActualizada = false;
		String [] querys = new String [25];
		connBD = ConexionBD.AbrirConexionBDD(infoUsu.getUname().toUpperCase());
		try 
		{
			querys = Cls_Querys.LimpiaListaQuerys(querys);
			querys = Cls_Querys.ObtieneQuerys(67, listaQuerys, querys, infoUsu);
			querys = InicializaQueryNumero67(querys,factura,id);
			Cls_Querys.ImprimeQuerysConsola(querys, false, "Query 67");
			pstm = connBD.prepareStatement("{call " +infoUsu.getUname().toUpperCase()+".usp_EXECUTE_QUERY(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			ResultSet rs = EjecutaQuerysBD.EjecutarQuery(querys[0], querys[1],querys[2], querys[3], querys[4], querys[5], querys[6],
					 querys[7], querys[8], querys[9],querys[10], querys[11], querys[12], querys[13], 
					 querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], 
					 querys[21], querys[22], querys[23], querys[24], infoUsu.getUname(),pstm, connBD,infoUsu);
			facturaActualizada = true;
		}
		catch (Exception e)
		{
			System.out.println("Error en GestorPedidos.actualizaEncabezadoRC: " + e);
			facturaActualizada = false;
		}
		finally 
		{
			try 
			{
				pstm.close();
				connBD.close();
			} catch (Exception e2)
			{			
			}
		}
		return  facturaActualizada;
	}
	
	private boolean actualizaArticulosPedidosRC(Usuario infoUsu, Connection connBD, PreparedStatement pstm, List<Querys> listaQuerys, String factura, String FOLIO,String id) {
		boolean facturaActualizada = false;
		String [] querys = new String [25];
		connBD = ConexionBD.AbrirConexionBDD(infoUsu.getUname().toUpperCase());
		try 
		{
			querys = Cls_Querys.LimpiaListaQuerys(querys);
			querys = Cls_Querys.ObtieneQuerys(69, listaQuerys, querys, infoUsu);
			querys = InicializaQueryNumero69(querys,factura,FOLIO,id);
			Cls_Querys.ImprimeQuerysConsola(querys, false, "Query 69");
			pstm = connBD.prepareStatement("{call " + "ALMACEN.usp_EXECUTE_QUERY(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			ResultSet rs = EjecutaQuerysBD.EjecutarQuery(querys[0], querys[1],querys[2], querys[3], querys[4], querys[5], querys[6],
					 querys[7], querys[8], querys[9],querys[10], querys[11], querys[12], querys[13], 
					 querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], 
					 querys[21], querys[22], querys[23], querys[24], infoUsu.getUname(),pstm, connBD,infoUsu);
			facturaActualizada = true;
		}
		catch (Exception e)
		{
			System.out.println("Error en GestorPedidos.actualizaEncabezadoRC: " + e);
			facturaActualizada = false;
		}
		finally 
		{
			try 
			{
				pstm.close();
				connBD.close();
			} catch (Exception e2)
			{
			
			}
		}
		return  facturaActualizada;
	}
	
	private boolean actualizaEstatusFacturaSinPendiente(Usuario infoUsu, Connection connBD, PreparedStatement pstm, List<Querys> listaQuerys, String factura) 
	{
		boolean actualizo = false;
		String [] querys = new String [25];
		connBD = ConexionBD.AbrirConexionBDD(infoUsu.getUname().toUpperCase());
		try 
		{
			querys = Cls_Querys.LimpiaListaQuerys(querys);
			querys = Cls_Querys.ObtieneQuerys(71, listaQuerys, querys, infoUsu);
			querys = InicializaQueryNumero70(querys,factura);
			Cls_Querys.ImprimeQuerysConsola(querys, false, "Query 71");
			pstm = connBD.prepareStatement("{call " +"ALMACEN.usp_EXECUTE_QUERY(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			ResultSet rs = EjecutaQuerysBD.EjecutarQuery(querys[0], querys[1],querys[2], querys[3], querys[4], querys[5], querys[6],
					 querys[7], querys[8], querys[9],querys[10], querys[11], querys[12], querys[13], 
					 querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], 
					 querys[21], querys[22], querys[23], querys[24], infoUsu.getUname(),pstm, connBD,infoUsu);
			actualizo = true;
		}
		catch (Exception e)
		{
			System.out.println("Error en GestorPedidos.actualizaEncabezadoRC: " + e);
			actualizo = false;
		}
		finally 
		{
			try 
			{
				pstm.close();
				connBD.close();
			} catch (Exception e2)
			{
			
			}
		}
		return actualizo;
	}
	
	private String consultarRegistrosEstatusCero(Usuario infoUsu, Connection connBD, PreparedStatement pstm, List<Querys> listaQuerys, String factura)
	{
		String existencia = "1";
		String [] querys = new String [25];
		connBD = ConexionBD.AbrirConexionBDD(infoUsu.getUname().toUpperCase());
		try 
		{
			querys = Cls_Querys.LimpiaListaQuerys(querys);
			querys = Cls_Querys.ObtieneQuerys(70, listaQuerys, querys, infoUsu);
			querys = InicializaQueryNumero70(querys,factura);
			Cls_Querys.ImprimeQuerysConsola(querys, false, "Query 70");
			pstm = connBD.prepareStatement("{call " + infoUsu.getUname().toUpperCase()+".usp_EXECUTE_QUERY(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			ResultSet rs = EjecutaQuerysBD.EjecutarQuery(querys[0], querys[1],querys[2], querys[3], querys[4], querys[5], querys[6],
					 querys[7], querys[8], querys[9],querys[10], querys[11], querys[12], querys[13], 
					 querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], 
					 querys[21], querys[22], querys[23], querys[24], infoUsu.getUname(),pstm, connBD,infoUsu);
			
			if(rs != null) {
				while(rs.next()) {
					existencia = rs.getString("estatus0");
				}
			}
		
		}
		catch (Exception e)
		{
			System.out.println("Error en GestorPedidos.actualizaEncabezadoRC: " + e);
			existencia = "1";
		}
		finally 
		{
			try 
			{
				pstm.close();
				connBD.close();
			} catch (Exception e2)
			{
			
			}
		}
		return existencia;
	}
	
	private boolean actualizaEncabezadoRC(Usuario infoUsu, Connection connBD, PreparedStatement pstm, List<Querys> listaQuerys, String factura, String FOLIO) {
		boolean facturaActualizada = false;
		String [] querys = new String [25];
		connBD = ConexionBD.AbrirConexionBDD(infoUsu.getUname().toUpperCase());
		try 
		{
			querys = Cls_Querys.LimpiaListaQuerys(querys);
			querys = Cls_Querys.ObtieneQuerys(65, listaQuerys, querys, infoUsu);
			querys = InicializaQueryNumero65(querys,factura,FOLIO);
			Cls_Querys.ImprimeQuerysConsola(querys, false, "Query 65");			
			pstm = connBD.prepareStatement("{call " + "ALMACEN.usp_EXECUTE_QUERY(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");						
			//pstm.executeUpdate(querys[0]);
			
			ResultSet rs = EjecutaQuerysBD.EjecutarQuery(querys[0], querys[1],querys[2], querys[3], querys[4], querys[5], querys[6],
					 querys[7], querys[8], querys[9],querys[10], querys[11], querys[12], querys[13], 
					 querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], 
					 querys[21], querys[22], querys[23], querys[24], infoUsu.getUname(),pstm, connBD,infoUsu);		
			facturaActualizada = true;
		}
		catch (Exception e)
		{
			System.out.println("Error en GestorPedidos.actualizaEncabezadoRC: " + e);
			facturaActualizada = false;
		}
		finally 
		{
			try 
			{
				pstm.close();
				connBD.close();
			} catch (Exception e2)
			{
			
			}
		}
		return  facturaActualizada;
	}
	
	private String[] InicializaQueryNumero69(String[] ListaQuerys, String factura, String FOLIO, String id) 
	{		
		for (int i=0;i <ListaQuerys.length; i++)
		{	
			ListaQuerys[i]= ListaQuerys[i].replace("{FACTURA}","'"+factura+"'");
			ListaQuerys[i]= ListaQuerys[i].replace("{TRAYECTO}","'"+FOLIO+"'");
			ListaQuerys[i]= ListaQuerys[i].replace("{ID}","'"+id+"'");
		}
		return ListaQuerys;
	}
	
	
	private String[] InicializaQueryNumero65(String[] ListaQuerys, String factura, String FOLIO) 
	{		
		for (int i=0;i <ListaQuerys.length; i++)
		{	
			ListaQuerys[i]= ListaQuerys[i].replace("{FACTURA}","'"+factura+"'");
			ListaQuerys[i]= ListaQuerys[i].replace("{TRAYECTO}","'"+FOLIO+"'");
		}
		return ListaQuerys;
	}
	
	private String[] InicializaQueryNumero70(String[] ListaQuerys, String factura) 
	{		
		for (int i=0;i <ListaQuerys.length; i++)
		{	
			ListaQuerys[i]= ListaQuerys[i].replace("{FACTURA}","'"+factura+"'");
		}
		return ListaQuerys;
	}
	
	private String[] InicializaQueryNumero67(String[] ListaQuerys, String factura, String id) 
	{		
		for (int i=0;i <ListaQuerys.length; i++)
		{	
			ListaQuerys[i]= ListaQuerys[i].replace("{FACTURA}","'"+factura+"'");
			ListaQuerys[i]= ListaQuerys[i].replace("{ID}","'"+id+"'");
		}
		return ListaQuerys;
	}
	
	private String obtenerProcesoQry(String[] split, String chofer, String cdo, HttpSession session, List<PedidosConsulta> p, String ss, String usuario, String uname_br, String FOLIO, List<Querys> listaQuerys, Usuario infoUsu, Connection connBD1, PreparedStatement pstm1, String[] split2, String uname_chofer, String numeroFacturas) 
	{
		String respuesta = "n";
		String iinsertFac = "";
		InsertarLogAlamacen.insertarLog(new LogAlmacen("","",""),infoUsu.getUname(),infoUsu.getUname_br(),"Se asignaran por chofer: " + numeroFacturas + ". En el folio: "+FOLIO+".",infoUsu.getCve_usuario());
		String insertSeccion = "";
		String insertDetalle = "";
		String insertAsig = "";
		String insertRepro = "";
		Connection connBD = null;
		PreparedStatement pstm = null;
		List<ClientesCredito> lstCredito = new ArrayList<>();
		
		lstCredito = (List<ClientesCredito>) session.getAttribute("clientesCredito");
		List<Consecutivo> lstConsecutivo = new ArrayList<>();
		String insertCliente = "";
		
		
		String validacionOdeYaInsertada = "";
		int auxiliar = 0;
		for (String s : split) 
		{
			String pedidoTipo = "";
			if (s.contains("r"))
			{
				String splitAux [] = s.split("\\*");
				pedidoTipo = "s";
				s = splitAux[0];
			}
		for (PedidosConsulta pp : p) 
		{
			
			if (pp.getNo().equals(s)) 
			{
				try 
				{
				List<SeriesCfdi> series = (List<SeriesCfdi>) session.getAttribute("series");

					
						String estatus = "";
						int sts = 1;
						if (!pp.getProgramada().equals("99")) 
						{
							sts = 8;
//							insertAsig = insertAsig + "('"+infoUsu.getUname()+"', '"+uname_chofer+"', "+pp.getOde()+", "+pp.getPedido()+", 1,"+pp.getId_trayecto()+", CURDATE(), CURTIME()),";
							
							insertAsig = insertAsig + "('"+infoUsu.getUname()+"', '"+pp.getUname()+"', "+pp.getOde()+", "+pp.getPedido()+", 1,"+pp.getId_trayecto()+", CURDATE(), CURTIME()),";
							
							insertRepro = insertRepro + "('"+infoUsu.getUname()+"', '"+uname_chofer+"', "+pp.getOde()+", "+pp.getPedido()+", "+FOLIO+", 1,CURDATE(), CURTIME()),";
//							actualizarRepro(listaQuerys,session,pp.getOde(),pp.getPedido(),infoUsu,FOLIO);
						}
						else
						{
							insertAsig = insertAsig + "('"+infoUsu.getUname()+"', '"+pp.getUname()+"', "+pp.getOde()+", "+pp.getPedido()+", 1,NULL, CURDATE(), CURTIME()),";
//							actualizarRepro(listaQuerys,session,pp.getOde(),pp.getPedido(),infoUsu,FOLIO);
						}
						
						
						
						if (!pedidoTipo.equals("")){pedidoTipo = "1";}
						else {pedidoTipo = "0";}
						if (pp.getConsecutivo() != null) 
						{
							insertCliente = insertCliente  + "('"+infoUsu.getUname()+"', '"+uname_chofer+"','"+FOLIO+"','"+pp.getCte()+"','"+pp.getConsecutivo()+"',CURDATE(),CURTIME()),";
						}
						else
						{
							if (lstConsecutivo.size() > 0) 
							{
								boolean rsp = false;
								for (Consecutivo itemConsecutivo : lstConsecutivo) 
								{
									if (Integer.parseInt(pp.getCte()) == itemConsecutivo.getCliente()) 
									{
										rsp = true;
										break;
									}
								}
								if (!rsp) 
								{
									auxiliar++;
									insertCliente = insertCliente  + "('"+infoUsu.getUname()+"', '"+uname_chofer+"','"+FOLIO+"','"+pp.getCte()+"','"+auxiliar+"',CURDATE(),CURTIME()),";
									Consecutivo objConsec = new Consecutivo();
									objConsec.setCliente(Integer.parseInt(pp.getCte()));
									objConsec.setConsecutivo(auxiliar);
									lstConsecutivo.add(objConsec);	
								}
							}
							else
							{
								auxiliar++;
								insertCliente = insertCliente  + "('"+infoUsu.getUname()+"', '"+uname_chofer+"','"+FOLIO+"','"+pp.getCte()+"','"+auxiliar+"',CURDATE(),CURTIME()),";
								Consecutivo objConsec = new Consecutivo();
								objConsec.setCliente(Integer.parseInt(pp.getCte()));
								objConsec.setConsecutivo(auxiliar);
								lstConsecutivo.add(objConsec);
							}
						}
						insertDetalle = insertDetalle + "('"+infoUsu.getUname()+"', '"+uname_chofer+"','"+FOLIO+"', '"+pp.getCte()+"','"+pp.getOde()+"','"+pp.getPedido()+"',NULL,NULL,0, 0,0, 0, 0, 0,"+pedidoTipo+"),";
						insertSeccion = insertSeccion + "('"+infoUsu.getUname()+"', '"+uname_chofer+"','"+pp.getOde()+"','"+pp.getPedido()+"','"+FOLIO+"', 1, 1, 0),";
						
						
						
						if (session.getAttribute("choferTipo").equals("p")) 
						{
							for (PedidosConsulta l : p)  
							{
								
								if (pp.getOde().equals(l.getOde()) && pp.getPedido().equals(l.getPedido())) 
								{
									String condicion = "1";
									if (l.getCondicion().equals("1"))
									{
										for (ClientesCredito ll : lstCredito)
										{
											if (ll.getCliente().equals(l.getCte()))
											{
												condicion = "0";
												break;
											}
										}
									}
									else
									{
										condicion = "0";
									}
									
									iinsertFac = iinsertFac + "('"+cdo+"', '"+uname_chofer+"','"+FOLIO+"','"+l.getOde()+"','"+l.getPedido()+"','"+l.getFactura()+"','"+l.getImporte()+"','0','0','0','0','0','0','0','0','','"+condicion+"', 0, '0',' ',CURDATE(), CURTIME()),";
								}
							}
						}
						else
						{
							if(!validacionOdeYaInsertada.contains(pp.getOde()))
							{
								for (PedidosConsulta l : p)  
								{
									
									if (pp.getOde().equals(l.getOde()) && pp.getPedido().equals(l.getPedido())) 
									{
										InsertarLogAlamacen.insertarLog(new LogAlmacen("","",""),cdo,infoUsu.getUname_br(),"ODE: "+l.getOde()+". FACTURA: "+l.getFactura()+". CONDICION:  "+l.getCondicion()+". Usuario: "+session.getAttribute("name").toString()+". Maquina: "+session.getAttribute("maquina").toString()+". Ip: "+session.getAttribute("ip").toString(),infoUsu.getCve_usuario());
										String condicion = "1";
										if (l.getCondicion().equals("1"))
										{
											for (ClientesCredito ll : lstCredito)
											{
												if (ll.getCliente().equals(l.getCte()))
												{
													condicion = "0";
													break;
												}
											}
										}
										else
										{
											condicion = "0";
										}
										
										iinsertFac = iinsertFac + "('"+cdo+"', '"+uname_chofer+"','"+FOLIO+"','"+l.getOde()+"','"+l.getPedido()+"','"+l.getFactura()+"','"+l.getImporte()+"','0','0','0','0','0','0','0','0','','"+condicion+"', 0, '0', ' ',CURDATE(), CURTIME()),";
										validacionOdeYaInsertada = validacionOdeYaInsertada + pp.getOde()+ ",";
									}
								}
							}
						}
						
						
						respuesta = "s";
						break;
					}
				catch (Exception e) 
				{
					InsertarLogAlamacen.insertarLog(new LogAlmacen("","",""),cdo,infoUsu.getUname_br(),"Error al insertar el detalle de ruta en tablas. DETALLE: "+Error(e)+". Usuario: "+session.getAttribute("name").toString()+". Maquina: "+session.getAttribute("maquina").toString()+". Ip: "+session.getAttribute("ip").toString(),infoUsu.getCve_usuario());
				}

			}	
		}

		}
		if (!insertRepro.equals(""))
		{
			insertarReprogramada(insertRepro.substring(0,insertRepro.length()-1),connBD,pstm,listaQuerys,infoUsu,FOLIO,session);
		}
		insertarCliente(insertCliente.substring(0,insertCliente.length()-1),connBD,pstm,listaQuerys,infoUsu,FOLIO,session);
		if (!iinsertFac.equals("") && !insertSeccion.equals("") && !insertSeccion.equals("") && !insertAsig.equals(""))
		{
			boolean rsp = false;
			
			rsp = actualizarOdeAsignada(insertAsig.substring(0,insertAsig.length()-1),infoUsu,connBD,pstm,listaQuerys,FOLIO,session);
			if (rsp){
				rsp = insertaDetalleChofer(insertDetalle.substring(0,insertDetalle.length()-1),connBD,pstm,infoUsu,listaQuerys,FOLIO,session);
				if (rsp) {
					rsp = insertaDetalleFacturas(iinsertFac.substring(0,iinsertFac.length()-1),connBD,pstm,infoUsu,listaQuerys,FOLIO,session);
					if (rsp) {
						rsp = insertaSeccion(insertSeccion.substring(0, insertSeccion.length()-1),connBD,pstm,infoUsu,listaQuerys,FOLIO,session);
					}
				}
			}				
		}
		
		return respuesta;
	}
	
	

	
	private void actualizarRepro(List<Querys> ListaQuerys, HttpSession session, String ode, String pedido,
			Usuario infoUsu, String folio)
	{
		boolean rsp = false;
		String [] querys = new String [25];
		Connection connBD = null;
		PreparedStatement pstm = null;
		connBD = ConexionBD.AbrirConexionBDD(infoUsu.getUname().toUpperCase());
		try
		{
			querys = Cls_Querys.LimpiaListaQuerys(querys);
			querys = Cls_Querys.ObtieneQuerys(48, ListaQuerys, querys, infoUsu);	
			querys = InicializaQueryNumero48(querys, infoUsu,ode,pedido);
			pstm = connBD.prepareStatement("{call " + "ALMACEN.usp_EXECUTE_QUERY(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			ResultSet rs = EjecutaQuerysBD.EjecutarQuery(querys[0], querys[1],querys[2], querys[3], querys[4], querys[5], querys[6],
					 querys[7], querys[8], querys[9],querys[10], querys[11], querys[12], querys[13], 
					 querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], 
					 querys[21], querys[22], querys[23], querys[24], infoUsu.getUname(),pstm, connBD,infoUsu);
			InsertarLogAlamacen.insertarLog(new LogAlmacen("","",""),infoUsu.getUname(),infoUsu.getUname_br(),"act, FOLIO: "+folio+". Qry["+Qry(seprado(querys))+"]"+". Usuario: "+session.getAttribute("name").toString()+". Maquina: "+session.getAttribute("maquina").toString()+". Ip: "+session.getAttribute("ip").toString(),infoUsu.getCve_usuario());
			rsp = true;
		}
		catch (Exception e) 
		{
			InsertarLogAlamacen.insertarLog(new LogAlmacen("","",""),infoUsu.getUname(),infoUsu.getUname_br(),"Error al act, FOLIO:"+folio+". DETALLE: "+Error(e)+". Qry["+Qry(seprado(querys))+"]"+". Usuario: "+session.getAttribute("name").toString()+". Maquina: "+session.getAttribute("maquina").toString()+". Ip: "+session.getAttribute("ip").toString(),infoUsu.getCve_usuario());
		}
		finally 
		{
			try 
			{
				connBD.close();
				pstm.close();
			} catch (Exception e2)
			{
				InsertarLogAlamacen.insertarLog(new LogAlmacen("","",""),infoUsu.getUname(),infoUsu.getUname_br(),"Error al cerrar conexion y pstm axt. DETALLE: "+Error(e2)+". Usuario: "+session.getAttribute("name").toString()+". Maquina: "+session.getAttribute("maquina").toString()+". Ip: "+session.getAttribute("ip").toString(),infoUsu.getCve_usuario());
			}
		}

	}


	private void insertarCliente(String insert, Connection connBD1, PreparedStatement pstm1, List<Querys> ListaQuerys,Usuario infoUsu, String folio, HttpSession session) 
	{
		boolean rsp = false;
		String [] querys = new String [25];
		Connection connBD = null;
		PreparedStatement pstm = null;
		connBD = ConexionBD.AbrirConexionBDD(infoUsu.getUname().toUpperCase());
		try
		{
			querys = Cls_Querys.LimpiaListaQuerys(querys);
			querys = Cls_Querys.ObtieneQuerys(56, ListaQuerys, querys, infoUsu);	
			querys = InicializaQueryNumero8(querys, infoUsu,folio,insert);
			Cls_Querys.ImprimeQuerysConsola(querys, false, "Query 56");
			pstm = connBD.prepareStatement("{call " + "ALMACEN.usp_EXECUTE_QUERY(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			ResultSet rs = EjecutaQuerysBD.EjecutarQuery(querys[0], querys[1],querys[2], querys[3], querys[4], querys[5], querys[6],
					 querys[7], querys[8], querys[9],querys[10], querys[11], querys[12], querys[13], 
					 querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], 
					 querys[21], querys[22], querys[23], querys[24], infoUsu.getUname(),pstm, connBD,infoUsu);
			InsertarLogAlamacen.insertarLog(new LogAlmacen("","",""),infoUsu.getUname(),infoUsu.getUname_br(),"Inserta en detalle cliente, FOLIO: "+folio+". Qry["+Qry(seprado(querys))+"]"+". Usuario: "+session.getAttribute("name").toString()+". Maquina: "+session.getAttribute("maquina").toString()+". Ip: "+session.getAttribute("ip").toString(),infoUsu.getCve_usuario());
			rsp = true;
		}
		catch (Exception e) 
		{
			InsertarLogAlamacen.insertarLog(new LogAlmacen("","",""),infoUsu.getUname(),infoUsu.getUname_br(),"Error al insertar detalle cliente, FOLIO:"+folio+". DETALLE: "+Error(e)+". Qry["+Qry(seprado(querys))+"]"+". Usuario: "+session.getAttribute("name").toString()+". Maquina: "+session.getAttribute("maquina").toString()+". Ip: "+session.getAttribute("ip").toString(),infoUsu.getCve_usuario());
		}
		finally 
		{
			try 
			{
				pstm.close();
				connBD.close();
			} catch (Exception e2)
			{
				InsertarLogAlamacen.insertarLog(new LogAlmacen("","",""),infoUsu.getUname(),infoUsu.getUname_br(),"Error al cerrar conexion y pstm detalle cliente. DETALLE: "+Error(e2)+". Usuario: "+session.getAttribute("name").toString()+". Maquina: "+session.getAttribute("maquina").toString()+". Ip: "+session.getAttribute("ip").toString(),infoUsu.getCve_usuario());
			}
		}
	}

	
	private boolean insertaDetalleFacturas(String insert, Connection connBD1, PreparedStatement pstm1, Usuario infoUsu,List<Querys> ListaQuerys, String folio, HttpSession session) 
	{
		boolean rsp = false;
		String [] querys = new String [25];
		Connection connBD = null;
		PreparedStatement pstm = null;
		connBD = ConexionBD.AbrirConexionBDD(infoUsu.getUname().toUpperCase());
		try
		{
			querys = Cls_Querys.LimpiaListaQuerys(querys);
			querys = Cls_Querys.ObtieneQuerys(10, ListaQuerys, querys, infoUsu);	
			querys = InicializaQueryNumero10(querys, infoUsu,insert);
			pstm = connBD.prepareStatement("{call " + "ALMACEN.usp_EXECUTE_QUERY(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			Cls_Querys.ImprimeQuerysConsola(querys, false, "Detalle Factura Query 10");
			ResultSet rs = EjecutaQuerysBD.EjecutarQuery(querys[0], querys[1],querys[2], querys[3], querys[4], querys[5], querys[6],
					 querys[7], querys[8], querys[9],querys[10], querys[11], querys[12], querys[13], 
					 querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], 
					 querys[21], querys[22], querys[23], querys[24], infoUsu.getUname(),pstm, connBD,infoUsu);
			InsertarLogAlamacen.insertarLog(new LogAlmacen("","",""),infoUsu.getUname(),infoUsu.getUname_br(),"Inserta en detalle_facturas, FOLIO: "+folio+". Qry["+Qry(seprado(querys))+"]"+". Usuario: "+session.getAttribute("name").toString()+". Maquina: "+session.getAttribute("maquina").toString()+". Ip: "+session.getAttribute("ip").toString(),infoUsu.getCve_usuario());
			rsp = true;
		}
		catch (Exception e) 
		{
			InsertarLogAlamacen.insertarLog(new LogAlmacen("","",""),infoUsu.getUname(),infoUsu.getUname_br(),"Error al insertar detalle_facturas, FOLIO:"+folio+". DETALLE: "+Error(e)+". Qry["+Qry(seprado(querys))+"]"+". Usuario: "+session.getAttribute("name").toString()+". Maquina: "+session.getAttribute("maquina").toString()+". Ip: "+session.getAttribute("ip").toString(),infoUsu.getCve_usuario());
		}
		finally 
		{
			try 
			{
				pstm.close();
				connBD.close();
			} catch (Exception e2)
			{
				InsertarLogAlamacen.insertarLog(new LogAlmacen("","",""),infoUsu.getUname(),infoUsu.getUname_br(),"Error al cerrar conexion y pstm facturas. DETALLE: "+Error(e2)+". Usuario: "+session.getAttribute("name").toString()+". Maquina: "+session.getAttribute("maquina").toString()+". Ip: "+session.getAttribute("ip").toString(),infoUsu.getCve_usuario());
			}
		}
		return rsp;
	}



	private String[] InicializaQueryNumero10(String[] ListaQuerys, Usuario infoUsu, String INSERT) 
	{
		for (int i=0;i <ListaQuerys.length; i++)
		{	
			ListaQuerys[i]= ListaQuerys[i].replace("{INSERT}",INSERT);
			
		}
		return ListaQuerys;
	}




	private String[] InicializaQueryNumero48(String[] ListaQuerys, Usuario infoUsu, String ode, String pedido)
	{
		for (int i=0;i <ListaQuerys.length; i++)
		{	
			ListaQuerys[i]= ListaQuerys[i].replace("{ODE}",ode);
			ListaQuerys[i]= ListaQuerys[i].replace("{PEDIDO}",pedido);
			
		}
		return ListaQuerys;
	}


	private boolean insertaSeccion(String insert, Connection connBD1,PreparedStatement pstm1, Usuario infoUsu, List<Querys> ListaQuerys, String fOLIO, HttpSession session) 
	{
		boolean rsp = false;
		String [] querys = new String [25];
		Connection connBD = null;
		PreparedStatement pstm = null;
		connBD = ConexionBD.AbrirConexionBDD(infoUsu.getUname().toUpperCase());
		try
		{
			querys = Cls_Querys.LimpiaListaQuerys(querys);
			querys = Cls_Querys.ObtieneQuerys(9, ListaQuerys, querys, infoUsu);	
			querys = InicializaQueryNumero9(querys, infoUsu,fOLIO,insert);
			Cls_Querys.ImprimeQuerysConsola(querys, false, "InsertaSeccion 9");
			pstm = connBD.prepareStatement("{call " + "ALMACEN.usp_EXECUTE_QUERY(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			ResultSet rs = EjecutaQuerysBD.EjecutarQuery(querys[0], querys[1],querys[2], querys[3], querys[4], querys[5], querys[6],
					 querys[7], querys[8], querys[9],querys[10], querys[11], querys[12], querys[13], 
					 querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], 
					 querys[21], querys[22], querys[23], querys[24], infoUsu.getUname(),pstm, connBD,infoUsu);
			InsertarLogAlamacen.insertarLog(new LogAlmacen("","",""),infoUsu.getUname(),infoUsu.getUname_br(),"Inserta seccion, FOLIO: "+fOLIO+". Qry["+Qry(seprado(querys))+"]"+". Usuario: "+session.getAttribute("name").toString()+". Maquina: "+session.getAttribute("maquina").toString()+". Ip: "+session.getAttribute("ip").toString(),infoUsu.getCve_usuario());
			rsp = true;
		}
		catch (Exception e) 
		{
			InsertarLogAlamacen.insertarLog(new LogAlmacen("","",""),infoUsu.getUname(),infoUsu.getUname_br(),"Error al insertar SECCION, FOLIO: "+fOLIO+". DETALLE: "+Error(e)+". Qry["+Qry(seprado(querys))+"]"+". Usuario: "+session.getAttribute("name").toString()+". Maquina: "+session.getAttribute("maquina").toString()+". Ip: "+session.getAttribute("ip").toString(),infoUsu.getCve_usuario());
		}
		finally 
		{
			try 
			{
				pstm.close();
				connBD.close();
			} catch (Exception e2)
			{
				InsertarLogAlamacen.insertarLog(new LogAlmacen("","",""),infoUsu.getUname(),infoUsu.getUname_br(),"Error al cerrar conexion y pstm insertaseccion. DETALLE: "+Error(e2)+". Usuario: "+session.getAttribute("name").toString()+". Maquina: "+session.getAttribute("maquina").toString()+". Ip: "+session.getAttribute("ip").toString(),infoUsu.getCve_usuario());
			}
		}
		return  rsp;
	}



	private String[] InicializaQueryNumero9(String[] ListaQuerys, Usuario infoUsu, String folio, String insert) 
	{
		for (int i=0;i <ListaQuerys.length; i++)
		{	
			ListaQuerys[i]= ListaQuerys[i].replace("{INSERT}",insert);
			
			
		}
		return ListaQuerys;
	}
	private String[] InicializaQueryNumero20(String[] ListaQuerys, Usuario infoUsu, String cdo, String uname, String fOLIO,
			String chofer, String usuario) 
	{
		for (int i=0;i <ListaQuerys.length; i++)
		{	
			ListaQuerys[i]= ListaQuerys[i].replace("{UNAME_CDO_}",infoUsu.getUname());
			ListaQuerys[i]= ListaQuerys[i].replace("{UNAME_ASIGNACION}",infoUsu.getUname_br());
			ListaQuerys[i]= ListaQuerys[i].replace("{UNAME_BR_}",infoUsu.getUname_br());
			ListaQuerys[i]= ListaQuerys[i].replace("{FOLIO}",fOLIO);
			ListaQuerys[i]= ListaQuerys[i].replace("{USUARIO}",infoUsu.getCve_usuario());
			ListaQuerys[i]= ListaQuerys[i].replace("{TRANSPORTE}",chofer);
		}
		return ListaQuerys;
	}


	private boolean insertaDetalleChofer(String insert, Connection connBD1, PreparedStatement pstm1, Usuario infoUsu, List<Querys> ListaQuerys, String fOLIO, HttpSession session) 
	{
		boolean rsp = false;
		String [] querys = new String [25];
		Connection connBD = null;
		PreparedStatement pstm = null;
		connBD = ConexionBD.AbrirConexionBDD(infoUsu.getUname().toUpperCase());
		try
		{
			querys = Cls_Querys.LimpiaListaQuerys(querys);
			querys = Cls_Querys.ObtieneQuerys(8, ListaQuerys, querys, infoUsu);	
			querys = InicializaQueryNumero8(querys, infoUsu,fOLIO,insert);
			Cls_Querys.ImprimeQuerysConsola(querys, false, "DetalleChofer 8");
			pstm = connBD.prepareStatement("{call " + "ALMACEN.usp_EXECUTE_QUERY(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			ResultSet rs = EjecutaQuerysBD.EjecutarQuery(querys[0], querys[1],querys[2], querys[3], querys[4], querys[5], querys[6],
					 querys[7], querys[8], querys[9],querys[10], querys[11], querys[12], querys[13], 
					 querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], 
					 querys[21], querys[22], querys[23], querys[24], infoUsu.getUname(),pstm, connBD,infoUsu);
			InsertarLogAlamacen.insertarLog(new LogAlmacen("","",""),infoUsu.getUname(),infoUsu.getUname_br(),"Inserta en detalle_trayecto_chofer, FOLIO: "+fOLIO+". Qry["+Qry(seprado(querys))+"]"+". Usuario: "+session.getAttribute("name").toString()+". Maquina: "+session.getAttribute("maquina").toString()+". Ip: "+session.getAttribute("ip").toString(),infoUsu.getCve_usuario());
			rsp = true;
		}
		catch (Exception e) 
		{
			InsertarLogAlamacen.insertarLog(new LogAlmacen("","",""),infoUsu.getUname(),infoUsu.getUname_br(),"Error al insertar detalle_trayecto_chofer, FOLIO: "+fOLIO+". DETALLE: "+Error(e)+". Qry["+Qry(seprado(querys))+"]"+". Usuario: "+session.getAttribute("name").toString()+". Maquina: "+session.getAttribute("maquina").toString()+". Ip: "+session.getAttribute("ip").toString(),infoUsu.getCve_usuario());
		}
		finally 
		{
			try 
			{
				pstm.close();
				connBD.close();
			} catch (Exception e2)
			{
				InsertarLogAlamacen.insertarLog(new LogAlmacen("","",""),infoUsu.getUname(),infoUsu.getUname_br(),"Error al cerrar conexion y pstm insertadetallechofer. DETALLE: "+Error(e2)+". Usuario: "+session.getAttribute("name").toString()+". Maquina: "+session.getAttribute("maquina").toString()+". Ip: "+session.getAttribute("ip").toString(),infoUsu.getCve_usuario());
			}
		}
		return rsp;
	}



	private String[] InicializaQueryNumero8(String[] ListaQuerys, Usuario infoUsu, String folio, String insert) 
	{
		
		for (int i=0;i <ListaQuerys.length; i++)
		{	
			ListaQuerys[i]= ListaQuerys[i].replace("{INSERT}",insert);
			
		}
		return ListaQuerys;
	}

	private boolean actualizarFacturaAsignada(String insert, Usuario infoUsu, Connection connBD1, PreparedStatement pstm1, List<Querys> ListaQuerys, String fOLIO, HttpSession session) 
	{
		boolean rsp = false;
		String [] querys = new String [25];
		String qry = "";
		Connection connBD = null;
		PreparedStatement pstm = null;
		connBD = ConexionBD.AbrirConexionBDD(infoUsu.getUname().toUpperCase());
		try
		{
			querys = Cls_Querys.LimpiaListaQuerys(querys);
			querys = Cls_Querys.ObtieneQuerys(64, ListaQuerys, querys, infoUsu);
			querys = InicializaQueryNumero6(querys, infoUsu,insert);
			for (String string : querys) 
			{				
					qry = qry + string + ",";			
			}
			Cls_Querys.ImprimeQuerysConsola(querys, false, "query 64");
			pstm = connBD.prepareStatement("{call " + "ALMACEN.usp_EXECUTE_QUERY(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			ResultSet rs = EjecutaQuerysBD.EjecutarQuery(querys[0], querys[1],querys[2], querys[3], querys[4], querys[5], querys[6],
					 querys[7], querys[8], querys[9],querys[10], querys[11], querys[12], querys[13], 
					 querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], 
					 querys[21], querys[22], querys[23], querys[24], infoUsu.getUname(),pstm, connBD,infoUsu);
			InsertarLogAlamacen.insertarLog(new LogAlmacen("","",""),infoUsu.getUname(),infoUsu.getUname_br(),"Actualiza ODES a asignadas en tc_ODE_ASIGNADA, FOLIO: "+fOLIO+". Qry["+Qry(seprado(querys))+"]"+". Usuario: "+session.getAttribute("name").toString()+". Maquina: "+session.getAttribute("maquina").toString()+". Ip: "+session.getAttribute("ip").toString(),infoUsu.getCve_usuario());
			rsp = true;
		}
		catch (Exception e) 
		{
			InsertarLogAlamacen.insertarLog(new LogAlmacen("","",""),infoUsu.getUname(),infoUsu.getUname_br(),"Error al actualizar ODES a asignadas en tc_ODE_ASIGNADA, FOLIO: "+fOLIO+". DETALLE: "+Error(e)+". Qry["+Qry(seprado(querys))+"]"+". Usuario: "+session.getAttribute("name").toString()+". Maquina: "+session.getAttribute("maquina").toString()+". Ip: "+session.getAttribute("ip").toString(),infoUsu.getCve_usuario());
		}
		finally 
		{
			try 
			{
				connBD.close();
				pstm.close();
			} catch (Exception e2)
			{
				InsertarLogAlamacen.insertarLog(new LogAlmacen("","",""),infoUsu.getUname(),infoUsu.getUname_br(),"Error al cerrar conexion y pstm actualizarOdeasignada. DETALLE: "+Error(e2)+". Usuario: "+session.getAttribute("name").toString()+". Maquina: "+session.getAttribute("maquina").toString()+". Ip: "+session.getAttribute("ip").toString(),infoUsu.getCve_usuario());
			}
		}
		return rsp;
	}

	private boolean actualizarOdeAsignada(String insert, Usuario infoUsu, Connection connBD1, PreparedStatement pstm1, List<Querys> ListaQuerys, String fOLIO, HttpSession session) 
	{
		boolean rsp = false;
		String [] querys = new String [25];
		String qry = "";
		Connection connBD = null;
		PreparedStatement pstm = null;
		connBD = ConexionBD.AbrirConexionBDD(infoUsu.getUname().toUpperCase());
		try
		{
			querys = Cls_Querys.LimpiaListaQuerys(querys);
			querys = Cls_Querys.ObtieneQuerys(37, ListaQuerys, querys, infoUsu);
			querys = InicializaQueryNumero6(querys, infoUsu,insert);
			for (String string : querys) 
			{				
					qry = qry + string + ",";					
			}
			Cls_Querys.ImprimeQuerysConsola(querys, false, "ODE_ASIGNADA 37");
			pstm = connBD.prepareStatement("{call " + "ALMACEN.usp_EXECUTE_QUERY(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			ResultSet rs = EjecutaQuerysBD.EjecutarQuery(querys[0], querys[1],querys[2], querys[3], querys[4], querys[5], querys[6],
					 querys[7], querys[8], querys[9],querys[10], querys[11], querys[12], querys[13], 
					 querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], 
					 querys[21], querys[22], querys[23], querys[24], infoUsu.getUname(),pstm, connBD,infoUsu);
			InsertarLogAlamacen.insertarLog(new LogAlmacen("","",""),infoUsu.getUname(),infoUsu.getUname_br(),"Actualiza ODES a asignadas en tc_ODE_ASIGNADA, FOLIO: "+fOLIO+". Qry["+Qry(seprado(querys))+"]"+". Usuario: "+session.getAttribute("name").toString()+". Maquina: "+session.getAttribute("maquina").toString()+". Ip: "+session.getAttribute("ip").toString(),infoUsu.getCve_usuario());
			rsp = true;
		}
		catch (Exception e) 
		{
			InsertarLogAlamacen.insertarLog(new LogAlmacen("","",""),infoUsu.getUname(),infoUsu.getUname_br(),"Error al actualizar ODES a asignadas en tc_ODE_ASIGNADA, FOLIO: "+fOLIO+". DETALLE: "+Error(e)+". Qry["+Qry(seprado(querys))+"]"+". Usuario: "+session.getAttribute("name").toString()+". Maquina: "+session.getAttribute("maquina").toString()+". Ip: "+session.getAttribute("ip").toString(),infoUsu.getCve_usuario());
		}
		finally 
		{
			try 
			{
				pstm.close();
				connBD.close();
			} catch (Exception e2)
			{
				InsertarLogAlamacen.insertarLog(new LogAlmacen("","",""),infoUsu.getUname(),infoUsu.getUname_br(),"Error al cerrar conexion y pstm actualizarOdeasignada. DETALLE: "+Error(e2)+". Usuario: "+session.getAttribute("name").toString()+". Maquina: "+session.getAttribute("maquina").toString()+". Ip: "+session.getAttribute("ip").toString(),infoUsu.getCve_usuario());
			}
		}
		return rsp;
	}
	private void actualizarOdeAsignadaTrans(int sts, String folio, String cdo, String ode, String pedido,Usuario infoUsu, Connection connBD, PreparedStatement pstm, List<Querys> ListaQuerys,HttpSession session) 
	{
		String [] querys = new String [25];
		try
		{
			querys = Cls_Querys.LimpiaListaQuerys(querys);
			if (sts == 8)
			{
				querys = Cls_Querys.ObtieneQuerys(21, ListaQuerys, querys, infoUsu);	
			}
			else
			{
				querys = Cls_Querys.ObtieneQuerys(23, ListaQuerys, querys, infoUsu);
			}
			
			querys = InicializaQueryNumero21(querys, infoUsu,folio,cdo,ode,pedido);
			pstm = connBD.prepareStatement("{call " + "ALMACEN.usp_EXECUTE_QUERY(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			ResultSet rs = EjecutaQuerysBD.EjecutarQuery(querys[0], querys[1],querys[2], querys[3], querys[4], querys[5], querys[6],
					 querys[7], querys[8], querys[9],querys[10], querys[11], querys[12], querys[13], 
					 querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], 
					 querys[21], querys[22], querys[23], querys[24], infoUsu.getUname(),pstm, connBD,infoUsu);
		}
		catch (Exception e) 
		{
			InsertarLogAlamacen.insertarLog(new LogAlmacen("","",""),cdo,infoUsu.getUname_br(),"Error al actualizar ODE_ASIGNADA transporte  a "+sts+". ODE: "+ode+". PEDIDO: "+pedido+". DETALLE: "+Error(e)+". Qry["+Qry(seprado(querys))+"]"+". Usuario: "+session.getAttribute("name").toString()+". Maquina: "+session.getAttribute("maquina").toString()+". Ip: "+session.getAttribute("ip").toString(),infoUsu.getCve_usuario());
		}
	}


	private String[] InicializaQueryNumero21(String[] ListaQuerys, Usuario infoUsu, String folio, String cdo, String ode,
			String pedido) 
	{
		for (int i=0;i <ListaQuerys.length; i++)
		{	
			ListaQuerys[i]= ListaQuerys[i].replace("{UNAME_CDO_}",infoUsu.getUname());
			ListaQuerys[i]= ListaQuerys[i].replace("{UNAME_BR_}",infoUsu.getUname_br());
			ListaQuerys[i]= ListaQuerys[i].replace("{ID_TRAYECTO}",folio);
			ListaQuerys[i]= ListaQuerys[i].replace("{ODE}",ode);
			ListaQuerys[i]= ListaQuerys[i].replace("{PEDIDO}",pedido);
			
		}
		return ListaQuerys;
	}



	private String[] InicializaQueryNumero6(String[] ListaQuerys, Usuario infoUsu, String insert) 
	{
		
		for (int i=0;i <ListaQuerys.length; i++)
		{	
			ListaQuerys[i]= ListaQuerys[i].replace("{UNAME_BR_}",infoUsu.getUname_br());
			ListaQuerys[i]= ListaQuerys[i].replace("{INSERT}",insert);
		}
		return ListaQuerys;
	}



	private void insertarReprogramada(String insert, Connection connBD1, PreparedStatement pstm1, List<Querys> ListaQuerys, Usuario infoUsu, String folio, HttpSession session) 
	{
		String [] querys = new String [25];
		String qry = "";
		Connection connBD = null;
		PreparedStatement pstm = null;
		connBD = ConexionBD.AbrirConexionBDD(infoUsu.getUname().toUpperCase());
		try
		{
			querys = Cls_Querys.LimpiaListaQuerys(querys);
			querys = Cls_Querys.ObtieneQuerys(32, ListaQuerys, querys, infoUsu);
			querys = InicializaQueryNumero5(querys, infoUsu,insert);
			for (String string : querys) 
			{
					qry = qry + string + ",";
			}
			pstm = connBD.prepareStatement("{call " + "ALMACEN.usp_EXECUTE_QUERY(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			ResultSet rs = EjecutaQuerysBD.EjecutarQuery(querys[0], querys[1],querys[2], querys[3], querys[4], querys[5], querys[6],
					 querys[7], querys[8], querys[9],querys[10], querys[11], querys[12], querys[13], 
					 querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], 
					 querys[21], querys[22], querys[23], querys[24], infoUsu.getUname(),pstm, connBD,infoUsu);
			InsertarLogAlamacen.insertarLog(new LogAlmacen("","",""),infoUsu.getUname(),infoUsu.getUname_br(),"Actualiza estatus a 1 en REPROGRAMA_ENTREGA_PEDIDO, FOLIO: "+folio+". Qry["+Qry(seprado(querys))+"]"+". Usuario: "+session.getAttribute("name").toString()+". Maquina: "+session.getAttribute("maquina").toString()+". Ip: "+session.getAttribute("ip").toString(),infoUsu.getCve_usuario());
		}
		catch (Exception e) 
		{
			InsertarLogAlamacen.insertarLog(new LogAlmacen("","",""),infoUsu.getUname(),infoUsu.getUname_br(),"Error actualizar estatus a 1 en REPROGRAMA_ENTREGA_PEDIDO, FOLIO: "+folio+". DETALLE: "+Error(e)+". Qry["+Qry(seprado(querys))+"]"+". Usuario: "+session.getAttribute("name").toString()+". Maquina: "+session.getAttribute("maquina").toString()+". Ip: "+session.getAttribute("ip").toString(),infoUsu.getCve_usuario());
		}
		finally 
		{
			try 
			{
				pstm.close();
				connBD.close();
			} catch (Exception e2)
			{
				InsertarLogAlamacen.insertarLog(new LogAlmacen("","",""),infoUsu.getUname(),infoUsu.getUname_br(),"Error al cerrar conexion y pstm insertareprogramada. DETALLE: "+Error(e2)+". Usuario: "+session.getAttribute("name").toString()+". Maquina: "+session.getAttribute("maquina").toString()+". Ip: "+session.getAttribute("ip").toString(),infoUsu.getCve_usuario());
			}
		}
	}
	private void insertarReprogramadaReg(String insert, Connection connBD1, PreparedStatement pstm1, List<Querys> ListaQuerys, Usuario infoUsu, String folio, HttpSession session) 
	{
		String [] querys = new String [25];
		String qry = "";
		Connection connBD = null;
		PreparedStatement pstm = null;
		connBD = ConexionBD.AbrirConexionBDD(infoUsu.getUname().toUpperCase());
		try
		{
			querys = Cls_Querys.LimpiaListaQuerys(querys);
			querys = Cls_Querys.ObtieneQuerys(46, ListaQuerys, querys, infoUsu);
			querys = InicializaQueryNumero5(querys, infoUsu,insert);
			pstm = connBD.prepareStatement("{call " + "ALMACEN.usp_EXECUTE_QUERY(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			ResultSet rs = EjecutaQuerysBD.EjecutarQuery(querys[0], querys[1],querys[2], querys[3], querys[4], querys[5], querys[6],
					 querys[7], querys[8], querys[9],querys[10], querys[11], querys[12], querys[13], 
					 querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], 
					 querys[21], querys[22], querys[23], querys[24], infoUsu.getUname(),pstm, connBD,infoUsu);
			InsertarLogAlamacen.insertarLog(new LogAlmacen("","",""),infoUsu.getUname(),infoUsu.getUname_br(),"Actualiza estatus a 1 en REPROGRAMA_ENTREGA_PEDIDO, FOLIO: "+folio+". Qry["+Qry(seprado(querys))+"]"+". Usuario: "+session.getAttribute("name").toString()+". Maquina: "+session.getAttribute("maquina").toString()+". Ip: "+session.getAttribute("ip").toString(),infoUsu.getCve_usuario());
		}
		catch (Exception e) 
		{
			InsertarLogAlamacen.insertarLog(new LogAlmacen("","",""),infoUsu.getUname(),infoUsu.getUname_br(),"Error actualizar estatus a 1 en REPROGRAMA_ENTREGA_PEDIDO, FOLIO: "+folio+". DETALLE: "+Error(e)+". Qry["+Qry(seprado(querys))+"]"+". Usuario: "+session.getAttribute("name").toString()+". Maquina: "+session.getAttribute("maquina").toString()+". Ip: "+session.getAttribute("ip").toString(),infoUsu.getCve_usuario());
		}
		finally 
		{
			try 
			{
				connBD.close();
				pstm.close();
			} catch (Exception e2)
			{
				InsertarLogAlamacen.insertarLog(new LogAlmacen("","",""),infoUsu.getUname(),infoUsu.getUname_br(),"Error al cerrar conexion y pstm insertareprogramada. DETALLE: "+Error(e2)+". Usuario: "+session.getAttribute("name").toString()+". Maquina: "+session.getAttribute("maquina").toString()+". Ip: "+session.getAttribute("ip").toString(),infoUsu.getCve_usuario());
			}
		}
	}

	

	private void insertarReprogramadaTrans(String fOLIO, String cdo, String uname, String ode, String pedido,String usuario, Connection connBD, PreparedStatement pstm, List<Querys> ListaQuerys, Usuario infoUsu,HttpSession session) 
	{
		String [] querys = new String [25];
		try
		{
			querys = Cls_Querys.LimpiaListaQuerys(querys);
			querys = Cls_Querys.ObtieneQuerys(22, ListaQuerys, querys, infoUsu);
			querys = InicializaQueryNumero22(querys, infoUsu,fOLIO,cdo,uname,ode,pedido);
			pstm = connBD.prepareStatement("{call " + "ALMACEN.usp_EXECUTE_QUERY(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			ResultSet rs = EjecutaQuerysBD.EjecutarQuery(querys[0], querys[1],querys[2], querys[3], querys[4], querys[5], querys[6],
					 querys[7], querys[8], querys[9],querys[10], querys[11], querys[12], querys[13], 
					 querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], 
					 querys[21], querys[22], querys[23], querys[24], infoUsu.getUname(),pstm, connBD,infoUsu);
			InsertarLogAlamacen.insertarLog(new LogAlmacen("","",""),cdo,infoUsu.getUname_br(),"Actualiza estatus a 1 en REPROGRAMA_ENTREGA_PEDIDO TRANSPORTE. ode: "+ode+". pedido: "+pedido+". Usuario: "+session.getAttribute("name").toString()+". Maquina: "+session.getAttribute("maquina").toString()+". Ip: "+session.getAttribute("ip").toString(),usuario);
		}
		catch (Exception e) 
		{
			InsertarLogAlamacen.insertarLog(new LogAlmacen("","",""),cdo,infoUsu.getUname_br(),"Error estatus a 1 en REPROGRAMA_ENTREGA_PEDIDO TRANSPORTE. ODE: "+ode+". PEDIDO: "+pedido+". DETALLE: "+Error(e)+". Qry["+Qry(seprado(querys))+"]"+". Usuario: "+session.getAttribute("name").toString()+". Maquina: "+session.getAttribute("maquina").toString()+". Ip: "+session.getAttribute("ip").toString(),usuario);
		}
	}
	


	private String[] InicializaQueryNumero22(String[] ListaQuerys, Usuario infoUsu, String fOLIO, String cdo, String uname,
			String ode, String pedido) 
	{
		
		for (int i=0;i <ListaQuerys.length; i++)
		{	
			ListaQuerys[i]= ListaQuerys[i].replace("{ID_TRAYECTO}",fOLIO);
			ListaQuerys[i]= ListaQuerys[i].replace("{UNAME_CDO_}",infoUsu.getUname());
			ListaQuerys[i]= ListaQuerys[i].replace("{UNAME_BR_}",infoUsu.getUname_br());
			ListaQuerys[i]= ListaQuerys[i].replace("{ODE}",ode);
			ListaQuerys[i]= ListaQuerys[i].replace("{PEDIDO}",pedido);
			
		}
		return ListaQuerys;
	}



	private String[] InicializaQueryNumero5(String[] ListaQuerys, Usuario infoUsu, String insert) 
	{
		for (int i=0;i <ListaQuerys.length; i++)
		{	
			ListaQuerys[i]= ListaQuerys[i].replace("{INSERT}",insert);
			ListaQuerys[i]= ListaQuerys[i].replace("{UNAME_BR_}",infoUsu.getUname_br());
		}
		return ListaQuerys;
	}



	private String obtenerProcesoQryTrans(String[] split, String chofer, String cdo, HttpSession session, List<PedidosConsulta> p, String ss, String usuario, String uname_br, String FOLIO, Usuario infoUsu, List<Querys> listaQuerys, PreparedStatement pstm, Connection connBD, String[] split2, String numeroFacturas) 
	{
		String respuesta = "n";
		String iinsertFac = "";
		String insertSeccion = "";
		String insertDetalle = "";
		String insertAsig = "";
		String insertRepro = "";
		InsertarLogAlamacen.insertarLog(new LogAlmacen("","",""),infoUsu.getUname(),infoUsu.getUname_br(),"Se asignaran por transporte: " + numeroFacturas + ". En el folio: "+FOLIO+".",infoUsu.getCve_usuario());
		String validacionOdeYaInsertada = "";
		for (String s : split) 
		{
		for (PedidosConsulta pp : p) 
		{
			if (pp.getNo().equals(s)) 
			{
				try 
				{
				List<SeriesCfdi> series = (List<SeriesCfdi>) session.getAttribute("series");

					
						String estatus = "";
						int sts = 1;
						if (!pp.getProgramada().equals("99")) 
						{
							sts = 8;
							insertAsig = insertAsig + "('"+infoUsu.getUname()+"', '"+pp.getUname()+"', "+pp.getOde()+", "+pp.getPedido()+", 1,NULL, CURDATE(), CURTIME()),";
//							actualizarRepro(listaQuerys,session,pp.getOde(),pp.getPedido(),infoUsu,FOLIO);
							insertRepro = insertRepro + "('"+infoUsu.getUname()+"', '"+pp.getUname()+"', "+pp.getOde()+", "+pp.getPedido()+", "+FOLIO+", 1,CURDATE(), CURTIME()),";
							
						}
						else
						{
							insertAsig = insertAsig + "('"+infoUsu.getUname()+"', '"+pp.getUname()+"', "+pp.getOde()+", "+pp.getPedido()+", 2,NULL, CURDATE(), CURTIME()),";
//							actualizarRepro(listaQuerys,session,pp.getOde(),pp.getPedido(),infoUsu,FOLIO);
						}
						
						insertDetalle = insertDetalle + "('"+infoUsu.getUname()+"', '"+infoUsu.getUname_br()+"','"+FOLIO+"', '"+pp.getCte()+"','"+pp.getOde()+"','"+pp.getPedido()+"',CURDATE(),CURTIME(),0, 0,0, 0, 2, 0,0),";
						insertSeccion = insertSeccion + "('"+infoUsu.getUname()+"', '"+infoUsu.getUname_br()+"','"+pp.getOde()+"','"+pp.getPedido()+"','"+FOLIO+"', 1, 1, 2),";
						
						if(!validacionOdeYaInsertada.contains(pp.getOde()))
						{
								for (PedidosConsulta l : p)  
								{
									

									if (pp.getOde().equals(l.getOde()) && pp.getPedido().equals(l.getPedido()))
									{
										InsertarLogAlamacen.insertarLog(new LogAlmacen("","",""),cdo,infoUsu.getUname_br(),"ODE: "+l.getOde()+". FACTURA: "+l.getFactura()+". CONDICION:  "+l.getCondicion()+". Usuario: "+session.getAttribute("name").toString()+". Maquina: "+session.getAttribute("maquina").toString()+". Ip: "+session.getAttribute("ip").toString(),infoUsu.getCve_usuario());
										iinsertFac = iinsertFac +"('"+infoUsu.getUname()+"', '"+infoUsu.getUname_br()+"','"+FOLIO+"','"+l.getOde()+"','"+l.getPedido()+"','"+l.getFactura()+"','"+l.getImporte()+"','0','0','0','0','0','0','0','0','','"+l.getCondicion()+"', 2, '0',CURDATE(), CURTIME()),";
										validacionOdeYaInsertada = validacionOdeYaInsertada + pp.getOde()+ ",";
									}
								}
						}
						
						
						
						
						respuesta = "s";
						break;
					}
				

				 catch (Exception e) 
				{
					 InsertarLogAlamacen.insertarLog(new LogAlmacen("","",""),cdo,infoUsu.getUname_br(),"Error al insertar el detalle de transporte en tablaS. DETALLE: "+Error(e)+". Usuario: "+session.getAttribute("name").toString()+". Maquina: "+session.getAttribute("maquina").toString()+". Ip: "+session.getAttribute("ip").toString(),infoUsu.getCve_usuario());
				}
				
			}	
		}
		}
		
		if (!iinsertFac.equals("") && !insertSeccion.equals("") && !insertSeccion.equals("") && !insertAsig.equals(""))
		{
			boolean rsp = false;
			rsp = actualizarOdeAsignada(insertAsig.substring(0,insertAsig.length()-1),infoUsu,connBD,pstm,listaQuerys,FOLIO,session);
			if (rsp) {
				rsp = insertaDetalleTrans(insertDetalle.substring(0,insertDetalle.length()-1),connBD,pstm,infoUsu,listaQuerys,FOLIO,session);
				if (rsp) {
					rsp = insertaSeccionTrans(insertSeccion.substring(0,insertSeccion.length()-1),connBD,pstm,infoUsu,listaQuerys,FOLIO,session);
					if (rsp) {
						rsp = insertaDetalleFacturasTrans(iinsertFac.substring(0,iinsertFac.length()-1),connBD,pstm,infoUsu,listaQuerys,FOLIO,session);
					}
				}
			}
			
			
			
		}
		if (!insertRepro.equals(""))
		{
			insertarReprogramada(insertRepro.substring(0,insertRepro.length()-1),connBD,pstm,listaQuerys,infoUsu,FOLIO,session);
		}
		return respuesta;
	}
	
	
	
	
	
	
	
	
	
	
	
	



	private boolean insertaDetalleFacturasTrans(String insert, Connection connBD, PreparedStatement pstm, Usuario infoUsu,
			List<Querys> ListaQuerys, String fOLIO, HttpSession session) 
	{
		String [] querys = new String [25];
		boolean rsp = false;
		try
		{
			querys = Cls_Querys.LimpiaListaQuerys(querys);
			querys = Cls_Querys.ObtieneQuerys(26, ListaQuerys, querys, infoUsu);	
			querys = InicializaQueryNumero26(querys, infoUsu,insert);
			pstm = connBD.prepareStatement("{call " + "ALMACEN.usp_EXECUTE_QUERY(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			ResultSet rs = EjecutaQuerysBD.EjecutarQuery(querys[0], querys[1],querys[2], querys[3], querys[4], querys[5], querys[6],
					 querys[7], querys[8], querys[9],querys[10], querys[11], querys[12], querys[13], 
					 querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], 
					 querys[21], querys[22], querys[23], querys[24], infoUsu.getUname(),pstm, connBD,infoUsu);
			InsertarLogAlamacen.insertarLog(new LogAlmacen("","",""),infoUsu.getUname(),infoUsu.getUname_br(),"Inserta en detalle_facturas TRANSPORTE, FOLIO: "+fOLIO+". QRY["+Qry(seprado(querys))+"]"+". Usuario: "+session.getAttribute("name").toString()+". Maquina: "+session.getAttribute("maquina").toString()+". Ip: "+session.getAttribute("ip").toString(),infoUsu.getCve_usuario());
			rsp = true;
		}
		catch (Exception e) 
		{
			InsertarLogAlamacen.insertarLog(new LogAlmacen("","",""),infoUsu.getUname(),infoUsu.getUname_br(),"Error al insertar detalle_facturas TRANSPORTE, FOLIO: "+fOLIO+". DETALLE: "+Error(e)+". Qry["+Qry(seprado(querys))+"]"+". Usuario: "+session.getAttribute("name").toString()+". Maquina: "+session.getAttribute("maquina").toString()+". Ip: "+session.getAttribute("ip").toString(),infoUsu.getCve_usuario());
		}
		return rsp;
	}



	private String[] InicializaQueryNumero26(String[] ListaQuerys, Usuario infoUsu, String insert) {
		for (int i=0;i <ListaQuerys.length; i++)
		{
		ListaQuerys[i]= ListaQuerys[i].replace("{INSERT}",insert);
		}
		return ListaQuerys;
	}



	private boolean insertaDetalleTrans(String insert, Connection connBD, PreparedStatement pstm, Usuario infoUsu, List<Querys> ListaQuerys, String fOLIO, HttpSession session) 
	{
		boolean rsp = false;
		String [] querys = new String [25];
		try
		{
			querys = Cls_Querys.LimpiaListaQuerys(querys);
			querys = Cls_Querys.ObtieneQuerys(24, ListaQuerys, querys, infoUsu);	
			querys = InicializaQueryNumero24(querys, infoUsu,insert);
			pstm = connBD.prepareStatement("{call " + "ALMACEN.usp_EXECUTE_QUERY(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			ResultSet rs = EjecutaQuerysBD.EjecutarQuery(querys[0], querys[1],querys[2], querys[3], querys[4], querys[5], querys[6],
					 querys[7], querys[8], querys[9],querys[10], querys[11], querys[12], querys[13], 
					 querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], 
					 querys[21], querys[22], querys[23], querys[24], infoUsu.getUname(),pstm, connBD,infoUsu);
			InsertarLogAlamacen.insertarLog(new LogAlmacen("","",""),infoUsu.getUname(),infoUsu.getUname_br(),"Inserta en detalle_trayecto_chofer transporte, FOLIO: "+fOLIO+". Qry["+Qry(seprado(querys))+"]"+". Usuario: "+session.getAttribute("name").toString()+". Maquina: "+session.getAttribute("maquina").toString()+". Ip: "+session.getAttribute("ip").toString(),infoUsu.getCve_usuario());
			rsp = true;
		}
		catch (Exception e) 
		{
			InsertarLogAlamacen.insertarLog(new LogAlmacen("","",""),infoUsu.getUname(),infoUsu.getUname_br(),"Error al insertar detalle_trayecto_chofer transporte, FOLIO: "+fOLIO+". DETALLE: "+Error(e)+". Qry["+Qry(seprado(querys))+"]"+". Usuario: "+session.getAttribute("name").toString()+". Maquina: "+session.getAttribute("maquina").toString()+". Ip: "+session.getAttribute("ip").toString(),infoUsu.getCve_usuario());
		}
		return rsp;
	}



	private String[] InicializaQueryNumero24(String[] ListaQuerys, Usuario infoUsu, String insert) {
		for (int i=0;i <ListaQuerys.length; i++)
		{	
			ListaQuerys[i]= ListaQuerys[i].replace("{INSERT}",insert);
		}
		return ListaQuerys;
	}



	private boolean insertaSeccionTrans(String insert, Connection connBD, PreparedStatement pstm, Usuario infoUsu, List<Querys> ListaQuerys, String fOLIO, HttpSession session) {
		String [] querys = new String [25];
		boolean rsp = false;
		try
		{
			querys = Cls_Querys.LimpiaListaQuerys(querys);
			querys = Cls_Querys.ObtieneQuerys(25, ListaQuerys, querys, infoUsu);	
			querys = InicializaQueryNumero25(querys, infoUsu,insert);
			pstm = connBD.prepareStatement("{call " + "ALMACEN.usp_EXECUTE_QUERY(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			ResultSet rs = EjecutaQuerysBD.EjecutarQuery(querys[0], querys[1],querys[2], querys[3], querys[4], querys[5], querys[6],
					 querys[7], querys[8], querys[9],querys[10], querys[11], querys[12], querys[13], 
					 querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], 
					 querys[21], querys[22], querys[23], querys[24], infoUsu.getUname(),pstm, connBD,infoUsu);
			InsertarLogAlamacen.insertarLog(new LogAlmacen("","",""),infoUsu.getUname(),infoUsu.getUname_br(),"Inserta SECCION transporte, FOLIO: "+fOLIO+" . Qry["+Qry(seprado(querys))+"]"+". Usuario: "+session.getAttribute("name").toString()+". Maquina: "+session.getAttribute("maquina").toString()+". Ip: "+session.getAttribute("ip").toString(),infoUsu.getCve_usuario());
			rsp = true;
		}
		catch (Exception e) 
		{
			InsertarLogAlamacen.insertarLog(new LogAlmacen("","",""),infoUsu.getUname(),infoUsu.getUname_br(),"Error al insertar SECCION transporte, FOLIO: "+fOLIO+" . DETALLE: "+Error(e)+". Qry["+Qry(seprado(querys))+"]"+". Usuario: "+session.getAttribute("name").toString()+". Maquina: "+session.getAttribute("maquina").toString()+". Ip: "+session.getAttribute("ip").toString(),infoUsu.getCve_usuario());
		}
		return rsp;
	}



	private String[] InicializaQueryNumero25(String[] ListaQuerys, Usuario infoUsu, String insert) 
	{
		for (int i=0;i <ListaQuerys.length; i++)
		{	
			ListaQuerys[i]= ListaQuerys[i].replace("{INSERT}",insert);
			
		}
		return ListaQuerys;
	}



	public List<TrayectoDatos> consultarTrayecto(Usuario infoUsu, String rutaInicio, String rutaFin, List<TrayectoDatos> lstTreyecto, String fechaInicio, String choferInicio,String choferFin, String fechaFin, String cliente, String tipoBusqueda, String clienteFin, String factura, String pedido, List<Querys> ListaQuerys, String check, HttpSession session, List<String>lstConsultarTipoCP) 
	{
		Connection connBD = null;
		PreparedStatement pstm = null;
		String f= "";
		connBD = ConexionBD.AbrirConexionBDD(infoUsu.getUname().toUpperCase());
		String serivdor = infoUsu.getUname().toUpperCase();
		String where = " ";
		String br = " ";
		if (infoUsu.getNivel_usuario() == 1)
		{
			if (!check.equals("")) 
			{
				if (!check.contains("*")) 
				{
					br = "a.uname = '"+check+"' and ";
				}
				else
				{
					br = "a.uname_br = '"+check.substring(0,check.length()-1)+"' and ";
				}
			}
			else
			{
				br = "a.uname_br = '"+infoUsu.getUname_br()+"' and ";
			}
		}
		else
		{
			br = "a.uname_br = '"+infoUsu.getUname_br()+"' and ";
		}
		
		if (!fechaInicio.equals(""))
		{
			f = "  "+br+"  a.fecha_asignacion_chofer BETWEEN  '"+fechaInicio+"' and '"+fechaFin+"' and ";
		}
		else
		{
			f = "  "+br+" a.fecha_asignacion_chofer BETWEEN  CURDATE() and CURDATE() and ";
		}
		
		if (rutaInicio.equals("inicio")) 
		{
			where  = "where "+f;
			where = where.substring(0, where.length()-4);
		}
		else
		{
			String t= "";
			String c= "";
			String cl = "";
			String ped = "";
			String ff = "";
			if (!rutaInicio.equals("")){t = " a.id_trayecto BETWEEN  '"+rutaInicio+"' and '"+rutaFin+"' and ";}
			
			if (!cliente.equals("")){cl = " c.num_cli BETWEEN '"+cliente+"' and '"+clienteFin+"' and ";}
			
			if (!pedido.equals("")){ped = " c.pedido = '"+pedido+"' and ";}
			
			if (!factura.equals("")){ff = " t.num_fac = '"+factura+"' and ";}
			
			if (!choferInicio.equals("")){c = " a.num_chofer BETWEEN  '"+choferInicio+"' and '"+choferFin+"' and ";}
			
			
			where =  " where "+t+c+ff+ped+cl+f;
			where = where.substring(0, where.length()-4);
		}
		
		String qry = "";
		String [] querys = new String [25];
		querys = Cls_Querys.LimpiaListaQuerys(querys);
		String tipo = "";
		if (!cliente.equals("")) 
		{
			tipo = "CLIENTE";
			querys = Cls_Querys.ObtieneQuerys(17, ListaQuerys, querys, infoUsu);
		}
		else
		{
		 tipo = "RUTA";
			querys = Cls_Querys.ObtieneQuerys(16, ListaQuerys, querys, infoUsu);
		}
		querys = InicializaQueryNumero16y17(querys, infoUsu,where);
		try 
		{
			
			pstm = connBD.prepareStatement("{call " + "ALMACEN.usp_EXECUTE_QUERY(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			ResultSet rs = EjecutaQuerysBD.EjecutarQuery(querys[0], querys[1],querys[2], querys[3], querys[4], querys[5], querys[6],
					 querys[7], querys[8], querys[9],querys[10], querys[11], querys[12], querys[13], 
					 querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], 
					 querys[21], querys[22], querys[23], querys[24], infoUsu.getUname(),pstm, connBD,infoUsu);
			Cls_Querys.ImprimeQuerysConsola(querys, false, "Query 16 y 17");
			InsertarLogAlamacen.insertarLog(new LogAlmacen("","",""),infoUsu.getUname(),infoUsu.getUname_br(),"Consulta trayectos "+tipo+". Qry["+Qry(seprado(querys))+"]"+". Usuario: "+session.getAttribute("name").toString()+". Maquina: "+session.getAttribute("maquina").toString()+". Ip: "+session.getAttribute("ip").toString(),infoUsu.getCve_usuario());
			pstm = connBD.prepareStatement(qry);
			
			if (rs != null) 
			{
				lstTreyecto = llenarTrayectos(rs,lstTreyecto,cliente,infoUsu,tipo,session,ListaQuerys,lstConsultarTipoCP);				
			}
		} catch (Exception e) 
		{
			InsertarLogAlamacen.insertarLog(new LogAlmacen("","",""),infoUsu.getUname(),infoUsu.getUname_br(),"Error en consulta trayectos "+tipo+". DETALLE: "+Error(e)+". Usuario: "+session.getAttribute("name").toString()+". Maquina: "+session.getAttribute("maquina").toString()+". Ip: "+session.getAttribute("ip").toString(),infoUsu.getCve_usuario());
		}
		finally 
		{
			try 
			{
				connBD.close();
				pstm.close();
			} catch (Exception e2)
			{
				InsertarLogAlamacen.insertarLog(new LogAlmacen("","",""),infoUsu.getUname(),infoUsu.getUname_br(),"Error al cerrar conexion y pstm consulta trayecto. DETALLE: "+Error(e2)+". Usuario: "+session.getAttribute("name").toString()+". Maquina: "+session.getAttribute("maquina").toString()+". Ip: "+session.getAttribute("ip").toString(),infoUsu.getCve_usuario());
			}
		}
		return lstTreyecto;
	}
	
	 private List<TrayectoDatos> llenarTrayectos(ResultSet rs, List<TrayectoDatos> lstTreyecto, String cliente, Usuario infoUsu, String tipo,HttpSession session,List<Querys> ListaQuerys,List<String>lstConsultarTipoCP) 
	 {
		try
		{ 	 
			 int aux = 0;
			 String facturas_cod= "";
			 String latitud = "";
			 String longitud = "";
			 while (rs.next())
				{
					if (!cliente.equals(""))
					{
						TrayectoDatos t = new TrayectoDatos();
						t.setUname(rs.getString("uname").toUpperCase());
						t.setId_traycto(rs.getString("id_trayecto"));
						t.setDiasEnc(rs.getString("diasEnc"));
						t.setHorasPed(calcularHoras(rs.getInt("diasPed"),rs.getString("horasPed")));
						t.setHorasEnc(calcularHoras(rs.getInt("diasEnc"),rs.getString("horasEnc")));
						t.setHorasEntrega(calcularHoras(rs.getInt("diasEntrega"),rs.getString("horasEntrega")).replace("-",""));
						t.setHorasInicio(calcularHoras(rs.getInt("diasInicio"),rs.getString("horasInicio")).replace("-",""));
						t.setUname_br(rs.getString("uname_br"));
						t.setTipo(rs.getString("tipo"));
						t.setNumeroChofer(rs.getString("num_chofer"));
						t.setTransporteNombre(rs.getString("transporte_nombre"));
						t.setNum_chofer(rs.getString("num_chofer")+" - "+rs.getString("nombre_chofer"));
						t.setDescripcion_cdo(rs.getString("descripcion_cdo"));
						t.setDescripcion_br(rs.getString("descripcion_br"));
						t.setImporteTrayecto(formatearImporte(rs.getString("importeTrayecto")));
						t.setImportePedido(formatearImporte(rs.getString("importePedido")));
						t.setId_traycto(rs.getString("id_trayecto"));
						t.setFecha_asignacion(rs.getString("fecha_asignacion"));
						t.setHora_asignacion(rs.getString("hora_asignacion"));
						t.setAsignacionConcat(rs.getString("fecha_asignacion")+" - "+rs.getString("hora_asignacion"));
						t.setUsuario_asignacion(rs.getString("usuario_asignacion")+" - "+rs.getString("nombre_usuario"));
						t.setFecha_inicio_trayecto(rs.getString("fecha_inicio_trayecto"));
						t.setFecha_inicio_entrega(rs.getString("fecha_inicio_entrega"));
						t.setFecha_fin_trayecto(rs.getString("fecha_fin_trayecto"));
						t.setHora_inicio_trayecto(rs.getString("hora_inicio_trayecto"));
						t.setHora_fin_trayecto(rs.getString("hora_fin_trayecto"));
						t.setFechaPedido(rs.getString("fecha_pedido"));
						t.setHorasEncPed(calcularHoras(rs.getInt("diasEncPed"),rs.getString("horasEncPed")));
						t.setInicioConcat(rs.getString("fecha_inicio_trayecto")+" - "+rs.getString("hora_inicio_trayecto"));
						t.setFinConcat(rs.getString("fecha_fin_trayecto")+" - "+rs.getString("hora_fin_trayecto"));
						t.setCliente(rs.getString("cliente")+"-"+rs.getString("cliente_nombre"));
						t.setOde(rs.getString("ode"));
						t.setPedido(rs.getString("pedido"));
						t.setFolio_carta_porte(rs.getString("folioCartaPorte"));
						//System.out.println("Folio CP: "+t.getFolio_carta_porte());
						if (aux != 0) 
						{
							for (TrayectoDatos tt: lstTreyecto) 
							{
								if (tt.getId_traycto().equals(rs.getString("id_trayecto")) && tt.getUname_br().equals(rs.getString("uname_br"))) 
								{
									t.setRepeticion("s");
								}
								else
								{
									t.setRepeticion("n");
									
								}
							}
						}
						else
						{
							t.setRepeticion("n");
						}
						aux++;
						lstTreyecto.add(t);
					}
					else
					{
						
						TrayectoDatos t = new TrayectoDatos();
						t.setUname(rs.getString("uname").toUpperCase());
						t.setDiasEnc(rs.getString("diasEnc"));
						t.setDiasEncPed(rs.getString("diasEncPed"));
						t.setDias(rs.getString("dias"));
						t.setImportePedido(formatearImporte(rs.getString("importeTrayecto")));
						t.setDiasPed(rs.getString("diasPed"));
						t.setHoras(calcularHoras(rs.getInt("dias"),rs.getString("horas"))); 
						/*PONER CUANDO SE AGREGUEN LAS COLUMNAS DE TIPO_TRAYECTO*/	
						t.setTipo(rs.getString("descripcion_tipo"));
					    t.setColor(rs.getString("color"));
					    /*------------------------------------------*/
						t.setTransporteNombre(rs.getString("transporte_nombre"));
						t.setHorasPed(calcularHoras(rs.getInt("diasPed"),rs.getString("horasPed")));
						
						if (!rs.getString("ingresos").equals("")) 
						{
							t.setIngresos("*");
						}
						else
						{
							t.setIngresos(rs.getString("ingresos"));
						}
						t.setHorasEnc(calcularHoras(rs.getInt("diasEnc"),rs.getString("horasEnc")));
						t.setHorasEncPed(calcularHoras(rs.getInt("diasEncPed"),rs.getString("horasEncPed")));
						t.setFechaPedido(rs.getString("fecha_pedido"));
						t.setNumeroChofer(rs.getString("num_chofer"));
						t.setHorasInicio(calcularHoras(rs.getInt("diasInicio"),rs.getString("horasInicio")).replace("-",""));
						t.setUname_br(rs.getString("uname_br"));
						t.setRuta(rs.getString("ruta"));
						t.setDireccion(rs.getString("direccion"));
						t.setDescripcion_cdo(rs.getString("descripcion_cdo"));
						t.setDescripcion_br(rs.getString("descripcion_br"));
						t.setId_traycto(rs.getString("id_trayecto"));
						if (!t.getIngresos().equals("")) 
						{
							for (TrayectoDatos tt : lstTreyecto) 
							{
								if (tt.getId_traycto().equals(t.getId_traycto())) 
								{
									tt.setIngresosCobro("*");
								}
								
							}
						}
						t.setCliente_nombre(rs.getString("cliente_nombre"));
						t.setNum_chofer(rs.getString("num_chofer")+" - "+rs.getString("nombre_chofer"));
						t.setNombre_chofer(rs.getString("nombre_chofer"));
						t.setFecha_asignacion(rs.getString("fecha_asignacion"));
						t.setHora_asignacion(rs.getString("hora_asignacion"));
						t.setLatitud_cdo(rs.getString("latitud_cdo"));
						t.setLongitud_cdo(rs.getString("longitud_cdo"));
						t.setAsignacionConcat(rs.getString("fecha_asignacion")+" - "+rs.getString("hora_asignacion"));
						t.setUsuario_asignacion(rs.getString("usuario_asignacion")+" - "+rs.getString("nombre_usuario"));
						t.setFecha_inicio_trayecto(rs.getString("fecha_inicio_trayecto"));
						t.setFecha_inicio_entrega(rs.getString("fecha_inicio_entrega"));
						t.setFecha_fin_trayecto(rs.getString("fecha_fin_trayecto"));
						t.setHora_inicio_trayecto(rs.getString("hora_inicio_trayecto"));
						t.setHora_fin_trayecto(rs.getString("hora_fin_trayecto"));
						t.setInicioConcat(rs.getString("fecha_inicio_trayecto")+" - "+rs.getString("hora_inicio_trayecto"));
						t.setFinConcat(rs.getString("fecha_fin_trayecto")+" - "+rs.getString("hora_fin_trayecto"));
						t.setCliente(rs.getString("cliente"));
						t.setOde(rs.getString("ode"));
						t.setPedido(rs.getString("pedido"));
						t.setFactura(rs.getString("factura"));
						t.setFacturas(rs.getString("facturas"));
						t.setImporte(formatearImporte(rs.getString("importe")));
						t.setEstatus(rs.getString("descripcion"));
						t.setId_estatus(rs.getString("id_estatus"));
						t.setImporte_cobrado(formatearImporte(rs.getString("importe_cobrado")));
						t.setObservaciones(rs.getString("observaciones"));
						t.setTipo_cobro(rs.getString("tipo_cobro"));
						if (t.getTipo_cobro().equals("COD")) 
						{
							facturas_cod = facturas_cod+t.getId_traycto()+",";
						}
						t.setLatitud_inicio_entrega(rs.getString("latitud_inicio_entrega"));
						t.setLatitud_fin_entrega(rs.getString("latitud_fin_entrega"));
						t.setLongitud_inicio_entrega(rs.getString("longitud_inicio_entrega"));
						t.setLongitud_fin_entrega(rs.getString("longitud_fin_entrega"));
						t.setFolio_carta_porte(rs.getString("folioCartaPorte"));
						//System.out.println("Folio CP: "+ t.getFolio_carta_porte());
						if (aux != 0) 
						{
							for (TrayectoDatos tt: lstTreyecto) 
							{
								if (tt.getId_traycto().equals(rs.getString("id_trayecto")) && tt.getUname_br().equals(rs.getString("uname_br"))) 
								{
									t.setRepeticion("s");
								}
								else
								{
									t.setRepeticion("n");
									
								}
							}
						}
						else
						{
							t.setRepeticion("n");
						}
						
						aux++;
						lstTreyecto.add(t);
					}
				}
			 	if (lstTreyecto.size() > 0 )
			 	{
					if (!facturas_cod.equals("")) 
					{
						String split [] = facturas_cod.substring(0, facturas_cod.length()-1).split(",");
						for (String ss : split) 
						{
							for (TrayectoDatos s : lstTreyecto)
							{
								if (s.getId_traycto().equals(ss)) 
								{
									s.setFacturas_cod("COD");
								}
							
							}
						}
						
					}
			 		
					
				}
		}
		catch (Exception e) 
		{
			InsertarLogAlamacen.insertarLog(new LogAlmacen("","",""),infoUsu.getUname(),infoUsu.getUname_br(),"Error al llenar datos de consulta trayectos " +tipo+". DETALLE: "+Error(e)+". Usuario: "+session.getAttribute("name").toString()+". Maquina: "+session.getAttribute("maquina").toString()+". Ip: "+session.getAttribute("ip").toString(),infoUsu.getCve_usuario());
		}
		 return lstTreyecto;
		
	}

	 
	public List<String> consultarTipoCP(Usuario infoUsu,HttpSession session, List<Querys> ListaQuerys) {
		Connection connBD = null;
		PreparedStatement pstm = null;
		List<String> lstConsultarTipoCP = new ArrayList<>();
		connBD = ConexionBD.AbrirConexionBDD(infoUsu.getUname().toUpperCase());
		String qry = "";
		String [] querys = new String [25];
		querys = Cls_Querys.LimpiaListaQuerys(querys);
		querys = Cls_Querys.ObtieneQuerys(75, ListaQuerys, querys, infoUsu);
		Cls_Querys.ImprimeQuerysConsola(querys, false, "Query 75");
		try 
		{		
			pstm = connBD.prepareStatement("{call " + "ALMACEN.usp_EXECUTE_QUERY(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			ResultSet rs = EjecutaQuerysBD.EjecutarQuery(querys[0], querys[1],querys[2], querys[3], querys[4], querys[5], querys[6],
					 querys[7], querys[8], querys[9],querys[10], querys[11], querys[12], querys[13], 
					 querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], 
					 querys[21], querys[22], querys[23], querys[24], infoUsu.getUname(),pstm, connBD,infoUsu);
			InsertarLogAlamacen.insertarLog(new LogAlmacen("","",""),infoUsu.getUname(),infoUsu.getUname_br(),"Consulta trayectos "+". Qry["+Qry(seprado(querys))+"]"+". Usuario: "+session.getAttribute("name").toString()+". Maquina: "+session.getAttribute("maquina").toString()+". Ip: "+session.getAttribute("ip").toString(),infoUsu.getCve_usuario());
			pstm = connBD.prepareStatement(qry);		
			if (rs != null) 
			{
				while(rs.next()) {
					lstConsultarTipoCP.add(rs.getString("descripcion"));
				}
			}
		} catch (Exception e) 
		{
			InsertarLogAlamacen.insertarLog(new LogAlmacen("","",""),infoUsu.getUname(),infoUsu.getUname_br(),"Error en consulta trayectos "+". DETALLE: "+Error(e)+". Usuario: "+session.getAttribute("name").toString()+". Maquina: "+session.getAttribute("maquina").toString()+". Ip: "+session.getAttribute("ip").toString(),infoUsu.getCve_usuario());
		}
		finally 
		{
			try 
			{
				connBD.close();
				pstm.close();
			} catch (Exception e2)
			{
				InsertarLogAlamacen.insertarLog(new LogAlmacen("","",""),infoUsu.getUname(),infoUsu.getUname_br(),"Error al cerrar conexion y pstm consulta trayecto. DETALLE: "+Error(e2)+". Usuario: "+session.getAttribute("name").toString()+". Maquina: "+session.getAttribute("maquina").toString()+". Ip: "+session.getAttribute("ip").toString(),infoUsu.getCve_usuario());
			}
		}	
		return lstConsultarTipoCP;
	}

	
	private String[] InicializaQueryNumero16y17(String[] ListaQuerys, Usuario infoUsu, String where) {
		 for (int i=0;i <ListaQuerys.length; i++)
			{	
				
				ListaQuerys[i]= ListaQuerys[i].replace("{UNAME_CDO_}",infoUsu.getUname().toUpperCase());
				ListaQuerys[i]= ListaQuerys[i].replace("{UNAME_BR_}",infoUsu.getUname_br());
				ListaQuerys[i]= ListaQuerys[i].replace("{COMPLEMENTO_QRY}",where);
				
				
			}
			return ListaQuerys;
	}



	private String calcularHoras(int dias, String horas) 
	 {
		 
		 String retorno = horas; 
		
		if (dias > 0)
		{
			if (horas.contains("-"))
			{
				horas = horas.replace("-", "");
				String split []; 
				split = horas.split(":");
				int horasTotales = Integer.parseInt(split[0]);
				horasTotales = (dias*24)+horasTotales;
				retorno = horasTotales+":"+split[1]+":"+split[2];
			}
			else
			{
				horas = horas.replace("-", "");
				String split []; 
				split = horas.split(":");
				int horasTotales = Integer.parseInt(split[0]);
				horasTotales = (dias*24)-horasTotales;
				retorno = horasTotales+":"+split[1]+":"+split[2];
				
			}
			
		} 
		
		return retorno;
	 }



	private static String formatearImporte(String importe) 
	 {
		 DecimalFormat formateador = new DecimalFormat("###,###.##");
		 String result = "";
		 if (importe.contains(","))
		 {
			String[] split = importe.split(",");
			String imp = "";
			for (String i : split) 
			{
				imp = imp+formateador.format (Double.parseDouble(i))+",";
			}
			imp = imp.substring(0, imp.length()-1);
			result = imp;
		 }
		 else if (!importe.equals("")) 
		 {
			 result = formateador.format (Double.parseDouble(importe));
		 } 
			return result;
	 }

	public String consultarFactura(HttpServletRequest request, HttpSession session, String facturaAgregada, Usuario infoUsu, List<Querys> ListaQuerys) {
		String respuesta = "false";
		String dev = "false";
		String msj = "";
		//System.out.println("factura Add: "+facturaAgregada);
		if(!facturaAgregada.contains(",")) {
			facturaAgregada = facturaAgregada+",";
		}
		//System.out.println("fact: "+facturaAgregada);
		String split[] = facturaAgregada.split(",");
		//System.out.println(split[0]);
		//System.out.println("...1");
		for(int i = 0; i < split.length; i++) 
		{
			for(int j = 0; j < split.length; j++) 
			{
				if(i != j) 
				{
					if(split[i].equals(split[j])) 
					{
						msj = "INGRESO DE FACTURA REPETIDAS, VERIFIQUE";
						break;
					}
				}
			}
		}
		//System.out.println("...2");
		if(msj.equals(""))
		{
			for(String fact : split) 
			{
			//	System.out.println("...3");
				respuesta = "false";
				Connection connBD = null;
				PreparedStatement pstm = null;
				connBD = ConexionBD.AbrirConexionBDD(infoUsu.getUname().toUpperCase());
				List<PedidosConsultaRC> lstPedidosRC = (List<PedidosConsultaRC>) session.getAttribute("lstPedidosRC");
				for(PedidosConsultaRC pRC : lstPedidosRC) {
					if(pRC.getFacturaTraslado().equals(fact)) {
						msj = msj + "Cliente Destino: " + pRC.getCteDestino() + " .Factura Traslado: "+ pRC.getFacturaTraslado() +" Remision: "+pRC.getRemision()+". \n";
						respuesta = "true";
					}
				}
				if(!respuesta.equals("true")) {
					String [] querys = new String [25];
					querys = Cls_Querys.LimpiaListaQuerys(querys);
					querys = Cls_Querys.ObtieneQuerys(62, ListaQuerys, querys, infoUsu);
					try {
						querys = InicializaQueryNumero62(querys,fact, infoUsu.getUname());
						
						pstm = connBD.prepareStatement("{call " + infoUsu.getUname().toUpperCase()+".usp_EXECUTE_QUERY(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
						ResultSet rs = EjecutaQuerysBD.EjecutarQuery(querys[0], querys[1],querys[2], querys[3], querys[4], querys[5], querys[6],
								 querys[7], querys[8], querys[9],querys[10], querys[11], querys[12], querys[13], 
								 querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], 
								 querys[21], querys[22], querys[23], querys[24], infoUsu.getUname(),pstm, connBD,infoUsu);
						Cls_Querys.ImprimeQuerysConsola(querys, false, "Query 62");
						//System.out.println("rs: "+rs);
					int num = 0;
					if(rs !=null) {
						int aux  = 0;
						while (rs.next())
						{
							num++;
							PedidosConsultaRC rc = new PedidosConsultaRC();
							 rc.setRuta(rs.getString("ruta"));
							 rc.setUnameDestino(rs.getString("uname_destino"));
							 rc.setCteDestino(rs.getString("cte_destino"));
							 rc.setFacturaTraslado(rs.getString("factura_traslado"));
							 rc.setRemision(rs.getString("remision"));
							 rc.setFecha(rs.getString("fecha"));
							 rc.setRazonSocial(rs.getString("razon_social"));
							 rc.setDireccion(rs.getString("direccion"));
							 rc.setTrasnporte(rs.getString("transporte"));
							 rc.setEstatus(rs.getString("estatus"));
							 rc.setUnameOrigen(rs.getString("uname_origen"));
							 rc.setProgramada(rs.getString("id_estatus"));
							 rc.setIdTrayectoAnterior(rs.getString("id_trayecto_anterior"));
							 rc.setTipo(rs.getString("tipo"));
							 rc.setTotalArticulos(rs.getString("total_articulos"));
							// System.out.println(" Cliente Destino: " + rc.getCteDestino() + "Factura Traslado: " + rc.getFacturaTraslado() +  " Remision: " + rc.getRemision());
							msj = msj + " Cliente Destino: " + rc.getCteDestino() + " Factura Traslado: " + rc.getFacturaTraslado() +  " Remision: " + rc.getRemision() + ". \n";
							lstPedidosRC.add(rc);
							session.setAttribute("lstPedidosRC",lstPedidosRC);
							respuesta = "true";
						}
					}
					if(num == 0) {
						msj = msj + "NO EXISTE LA FACTURA TRASLADO DE RC: " + fact +". \n";
					}
					InsertarLogAlamacen.insertarLog(new LogAlmacen("","",""),infoUsu.getUname(),infoUsu.getUname_br(),"Consulta facturas de RC "+". Qry[ \n "+Qry(seprado(querys))+" \n]"+". Usuario: "+session.getAttribute("name").toString()+". Maquina: "+session.getAttribute("maquina").toString()+". Ip: "+session.getAttribute("ip").toString(),infoUsu.getCve_usuario());	
					}catch(Exception e) {
						System.out.println("Error al cargar informacion en GestorPedidos. consultarFactura: " + e);
					}finally {
						try{pstm.close();}catch(Exception e) {};	
						try{connBD.close();}catch(Exception e) {};
					}
				}				
			}
		}
		dev = msj;
		return dev;
	}
	
	public String consultarOde(HttpServletRequest request, HttpSession session, String odeAgregada, Usuario infoUsu, List<Querys> ListaQuerys) 
	{
		String rsp = "false";
		String dev = "false";
		String noConsec = "";
		String msj = "";
		InsertarLogAlamacen.insertarLog(new LogAlmacen("","",""),infoUsu.getUname(),infoUsu.getUname_br(),"Consulta para agregar las siguientes ODE: "+odeAgregada+". Usuario: "+session.getAttribute("name").toString()+". Maquina: "+session.getAttribute("maquina").toString()+". Ip: "+session.getAttribute("ip").toString(),infoUsu.getCve_usuario());
		if (!odeAgregada.contains(",")) 
		{
			odeAgregada = odeAgregada+",";
		}
		String split [] = odeAgregada.split(",");
		
		for (int i = 0; i < split.length; i++) 
		{
			for (int j = 0; j < split.length; j++) 
			{
				if (i != j) 
				{
					if (split[i].equals(split[j])) 
					{
						msj = "INGRESO ODE REPETIDAS, VERIFIQUE.";
						break;
					}
				}
			}
		}
		if (msj.equals("")) 
		{
			for (String ode : split) 
			{
				rsp = "false";
				Connection connBD = null;
				PreparedStatement pstm = null;
				connBD = ConexionBD.AbrirConexionBDD(infoUsu.getUname().toUpperCase());
				List<PedidosConsulta> lstPedidos = (List<PedidosConsulta>) session.getAttribute("listaPedidos");
				for (PedidosConsulta p : lstPedidos) 
				{
					if (p.getOde().equals(ode))
					{
						 msj= msj +" ODE: "+p.getOde()+". Cliente: "+p.getCte()+". Factura: "+p.getFactura()+". \n";
						 rsp = "true";
					}
				}
				if (!rsp.equals("true")) 
				{
					String [] querys = new String [25];
					querys = Cls_Querys.LimpiaListaQuerys(querys);
					querys = Cls_Querys.ObtieneQuerys(27, ListaQuerys, querys, infoUsu);
					try 
					{
					querys = InicializaQueryNumero27(querys, infoUsu,ode);
					
					pstm = connBD.prepareStatement("{call " + "ALMACEN.usp_EXECUTE_QUERY(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
					ResultSet rs = EjecutaQuerysBD.EjecutarQuery(querys[0], querys[1],querys[2], querys[3], querys[4], querys[5], querys[6],
							 querys[7], querys[8], querys[9],querys[10], querys[11], querys[12], querys[13], 
							 querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], 
							 querys[21], querys[22], querys[23], querys[24], infoUsu.getUname(),pstm, connBD,infoUsu);
					InsertarLogAlamacen.insertarLog(new LogAlmacen("","",""),infoUsu.getUname(),infoUsu.getUname_br(),"Consulta ODE:"+ode+" . Qry["+Qry(seprado(querys))+"]"+". Usuario: "+session.getAttribute("name").toString()+". Maquina: "+session.getAttribute("maquina").toString()+". Ip: "+session.getAttribute("ip").toString(),infoUsu.getCve_usuario());
				
				
					List<SeriesCfdi> series = (List<SeriesCfdi>) session.getAttribute("series");

				int no = 0;
				if (rs != null) 
				{
					
					int aux  = 0;
					while (rs.next())
					{
						no++;
						
							if (rs.getString("id_estatus").equals("0") || rs.getString("id_estatus").equals("4") || rs.getString("id_estatus").equals("8") || rs.getString("id_estatus").equals("99")) 
							{
								PedidosConsulta p = new PedidosConsulta();
								p.setNo(String.valueOf((Integer.parseInt(session.getAttribute("consecutivo").toString())+1)));
//								noConsec = noConsec+","+(Integer.parseInt(session.getAttribute("consecutivo").toString())+1);
								session.setAttribute("consecutivo",(Integer.parseInt(session.getAttribute("consecutivo").toString())+1));
								p.setRuta(rs.getString("ruta"));
								p.setFecha_ods(rs.getString("fecha_pedido"));
								p.setFecha_factura(rs.getString("fecha_factura"));
								p.setFecha_corta(rs.getString("fecha_factura_corta"));
								p.setOds(rs.getString("ods"));
								p.setUname(rs.getString("uname_br"));
								p.setPedido(rs.getString("pedido"));
								p.setOde(rs.getString("ode"));
								p.setProgramada(rs.getString("programada"));
								p.setId_trayecto(rs.getString("id_trayecto"));
								p.setImporte(rs.getString("importe"));
								p.setCondicion(rs.getString("condicion"));
								p.setFactura(rs.getString("num_fac"));
								
								p.setCte(rs.getString("cte"));
								p.setConsignatario(rs.getString("consignatario"));
								if(rs.getInt("consignatario") > 0)
								{						
									p.setDireccion(rs.getString("direccion"));
									p.setNombre_razon_social(rs.getString("nombre_razon_social"));
								}
								else
								{
									p.setDireccion(rs.getString("direccion_cte"));
									p.setNombre_razon_social(rs.getString("nombre_razon_social_cte"));
								}
								p.setTransporte(rs.getString("transporte"));
								String consecutivo = "0";
//								for (PedidosConsulta s : lstPedidos) 
//								{
//									if (s.getOde().equals(rs.getString("ode")) && s.getFactura().equals(rs.getString("num_fac"))) 
//									{
//										aux++;
//									}
//									if (Integer.parseInt(s.getConsecutivo()) > Integer.parseInt(consecutivo)) 
//									{
//										consecutivo = s.getConsecutivo();	
//									}
//								}
//								p.setConsecutivo(String.valueOf(Integer.parseInt(consecutivo)+1));
								if (aux == 0) 
								{
									msj = msj + " ODE: "+p.getOde()+". CLIENTE: "+p.getCte()+". FACTURA: "+p.getFactura()+". \n";
									lstPedidos.add(p);
									session.setAttribute("listaPedidos",lstPedidos);
									rsp = "true";
								}
							}
							else
							{
								msj = msj + "ODE: "+rs.getString("ode")+". FACTURA: "+rs.getString("num_fac")+". YA AGREGADA EN OTRO FOLIO: "+rs.getString("id_trayecto")+" \n";
							}
					}
				}
				if (no == 0)
				{
					msj = msj + "NO EXISTE LA ODE: "+ode+". \n";
				}
				} catch (Exception e) 
				{
					InsertarLogAlamacen.insertarLog(new LogAlmacen("","",""),infoUsu.getUname(),infoUsu.getUname_br(),"Error al CARGAR ODE CONSULTADA. DETALLE: "+Error(e)+" Qry["+Qry(seprado(querys))+"]"+". Usuario: "+session.getAttribute("name").toString()+". Maquina: "+session.getAttribute("maquina").toString()+". Ip: "+session.getAttribute("ip").toString(),infoUsu.getCve_usuario());
				}
				finally 
				{
					try 
					{
						connBD.close();
						pstm.close();
					} catch (Exception e2)
					{
						e2.printStackTrace();
					}
				}
				}
			}
		}
		dev = msj;
		return dev;
	}



	private String[] InicializaQueryNumero27(String[] ListaQuerys, Usuario infoUsu, String ode) {
		for (int i=0;i <ListaQuerys.length; i++)
		{	
			
			ListaQuerys[i]= ListaQuerys[i].replace("{UNAME_CDO_}",infoUsu.getUname().toUpperCase());
			ListaQuerys[i]= ListaQuerys[i].replace("{ODE}",ode);
		}
		return ListaQuerys;
	}

	public String imprimirTicketSeparadoRC(String folio, Usuario infoUsu, List<PedidosConsultaRC> pp, HttpSession session, List<Querys> ListaQuerys, Usuario infoUsu2, String uname_chofer, String ticket)
	{
		//System.out.println("Entra a ticket RC");
		List<PedidosConsulta> lista = new ArrayList<>();
		String pedidos = "0";
		String chofer = "";
		String tipoEnc = "";
		
		String where = "  ";
		if (!uname_chofer.equals("")) 
		{
			where = " and a.uname_br = '"+uname_chofer+"' ";
		}
		String rsp = "false";
		String nombrechofer = "";
		int no = 0;
		
		Connection connBD = null;
		PreparedStatement pstm = null;
		connBD = ConexionBD.AbrirConexionBDD(infoUsu.getUname().toUpperCase());
		String ruta = "";
		String [] querys = new String [25];
		try
		{
			
			querys = Cls_Querys.LimpiaListaQuerys(querys);
			querys = Cls_Querys.ObtieneQuerys(76, ListaQuerys, querys, infoUsu);
			querys = InicializaQueryNumero13(querys, infoUsu,folio,where);
			Cls_Querys.ImprimeQuerysConsola(querys, false, "Query 76 TicketRC");
			pstm = connBD.prepareStatement("{call " + "ALMACEN.usp_EXECUTE_QUERY(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			ResultSet rs = EjecutaQuerysBD.EjecutarQuery(querys[0], querys[1],querys[2], querys[3], querys[4], querys[5], querys[6],
					 querys[7], querys[8], querys[9],querys[10], querys[11], querys[12], querys[13], 
					 querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], 
					 querys[21], querys[22], querys[23], querys[24], infoUsu.getUname(),pstm, connBD,infoUsu);
			InsertarLogAlamacen.insertarLog(new LogAlmacen("","",""),infoUsu.getUname(),infoUsu.getUname_br(),"Consulta datos ticket, folio: "+folio+". Qry["+Qry(seprado(querys))+"]"+". Usuario: "+session.getAttribute("name").toString()+". Maquina: "+session.getAttribute("maquina").toString()+". Ip: "+session.getAttribute("ip").toString(),infoUsu.getCve_usuario());
			if (rs != null) 
			{
				try
				{
					while (rs.next())
					{
						
						PedidosConsulta p = new PedidosConsulta();
						p.setNo(String.valueOf(no));
						p.setFecha_corta(rs.getString("fechaCorta"));
						p.setImporte(rs.getString("importe"));
						p.setFactura(rs.getString("factura"));
						p.setCte(rs.getString("cliente"));
						p.setCondicion(rs.getString("tipo"));
						p.setPedido(rs.getString("pedido"));
						p.setNombre_razon_social(rs.getString("nombreChofer"));
						p.setRuta(rs.getString("ruta1"));
						tipoEnc = rs.getString("descripcion_completa");
						chofer = rs.getString("numChofer");
						
						if (!rs.getString("nombreChofer").equals("n")) 
						{
							nombrechofer = rs.getString("nombreChofer");
						}
						else
						{
							nombrechofer = rs.getString("transporte");
						}
						
						if(no != 0)
						{
							pedidos = pedidos +","+no;
						}
						ruta =  rs.getString("ruta1");
						//System.out.println("ruta " + ruta);
						no ++;
						
						lista.add(p);
					}
				}
				catch (Exception e) 
				{
					InsertarLogAlamacen.insertarLog(new LogAlmacen("","",""),infoUsu.getUname(),infoUsu.getUname_br(),"Error al llenar lista de datos del ticket, folio: "+folio+". DETALLE: "+Error(e)+" Qry["+Qry(seprado(querys))+"]"+". Usuario: "+session.getAttribute("name").toString()+". Maquina: "+session.getAttribute("maquina").toString()+". Ip: "+session.getAttribute("ip").toString(),infoUsu.getCve_usuario());
				}
			}
		}
		catch (Exception e)
		{
			InsertarLogAlamacen.insertarLog(new LogAlmacen("","",""),infoUsu.getUname(),infoUsu.getUname_br(),"Error al consultar datos del ticket, folio: "+folio+". DETALLE: "+Error(e)+" Qry["+Qry(seprado(querys))+"]"+". Usuario: "+session.getAttribute("name").toString()+". Maquina: "+session.getAttribute("maquina").toString()+". Ip: "+session.getAttribute("ip").toString(),infoUsu.getCve_usuario());
		}
		finally 
		{
			try 
			{
				connBD.close();
				pstm.close();
			} catch (Exception e2)
			{
				InsertarLogAlamacen.insertarLog(new LogAlmacen("","",""),infoUsu.getUname(),infoUsu.getUname_br(),"Error al cerrar conexion y pstm imprimirTicketSeparado. DETALLE: "+Error(e2)+". Usuario: "+session.getAttribute("name").toString()+". Maquina: "+session.getAttribute("maquina").toString()+". Ip: "+session.getAttribute("ip").toString(),infoUsu.getCve_usuario());
			}
		}
		//System.out.println("Ticket no: "+no);
		if (no != 0) 
		{
			Cls_CrearTicketDeIngresos c = new Cls_CrearTicketDeIngresos();
			
			rsp = c.crearArchivoTxtDelTicket(folio, lista,infoUsu.getCve_usuario(), session.getAttribute("impresora").toString(),chofer,infoUsu.getUname(),infoUsu.getUname_br_nombre(),nombrechofer,pedidos,session,tipoEnc,infoUsu,ticket,ruta);
		}
		else
		{
			rsp = "EL FOLIO: "+folio+" NO EXISTE";
		}
		
		return rsp;
	}

	public String imprimirTicketSeparado(String folio, Usuario infoUsu, List<PedidosConsulta> pp, HttpSession session, List<Querys> ListaQuerys, Usuario infoUsu2, String uname_chofer, String ticket) 
	{
		//System.out.println("Entra a ticket");
		List<PedidosConsulta> lista = new ArrayList<>();
		String pedidos = "0";
		String chofer = "";
		String tipoEnc = "";
		
		String where = "  ";
		if (!uname_chofer.equals("")) 
		{
			where = " and a.uname_br = '"+uname_chofer+"' ";
		}
		String rsp = "false";
		String nombrechofer = "";
		int no = 0;
		
		Connection connBD = null;
		PreparedStatement pstm = null;
		connBD = ConexionBD.AbrirConexionBDD(infoUsu.getUname().toUpperCase());
		String ruta = "";
		String [] querys = new String [25];
		try
		{
			
			querys = Cls_Querys.LimpiaListaQuerys(querys);
			querys = Cls_Querys.ObtieneQuerys(13, ListaQuerys, querys, infoUsu);
			querys = InicializaQueryNumero13(querys, infoUsu,folio,where);
			Cls_Querys.ImprimeQuerysConsola(querys, false, "Query 13 Ticket");
			pstm = connBD.prepareStatement("{call " + "ALMACEN.usp_EXECUTE_QUERY(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			ResultSet rs = EjecutaQuerysBD.EjecutarQuery(querys[0], querys[1],querys[2], querys[3], querys[4], querys[5], querys[6],
					 querys[7], querys[8], querys[9],querys[10], querys[11], querys[12], querys[13], 
					 querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], 
					 querys[21], querys[22], querys[23], querys[24], infoUsu.getUname(),pstm, connBD,infoUsu);
			InsertarLogAlamacen.insertarLog(new LogAlmacen("","",""),infoUsu.getUname(),infoUsu.getUname_br(),"Consulta datos ticket, folio: "+folio+". Qry["+Qry(seprado(querys))+"]"+". Usuario: "+session.getAttribute("name").toString()+". Maquina: "+session.getAttribute("maquina").toString()+". Ip: "+session.getAttribute("ip").toString(),infoUsu.getCve_usuario());
			if (rs != null) 
			{
				try
				{
					while (rs.next())
					{
						
						PedidosConsulta p = new PedidosConsulta();
						p.setNo(String.valueOf(no));
						p.setFecha_corta(rs.getString("fechaCorta"));
						p.setImporte(rs.getString("importe"));
						p.setFactura(rs.getString("factura"));
						p.setCte(rs.getString("cliente"));
						p.setCondicion(rs.getString("tipo"));
						p.setPedido(rs.getString("pedido"));
						p.setNombre_razon_social(rs.getString("nombreChofer"));
						chofer = rs.getString("numChofer");
						if (!rs.getString("nombreChofer").equals("n")) 
						{
							nombrechofer = rs.getString("nombreChofer");
						}
						else
						{
							nombrechofer = rs.getString("transporte");
						}
						
						if (rs.getString("tipoEnc").equals("T")) 
						{
							tipoEnc = "TRANSPORTE";
						}
						else
						{
							tipoEnc = "CHOFER";
						}
						if(no != 0)
						{
							pedidos = pedidos +","+no;
						}
						ruta =  rs.getString("ruta");
						no ++;
						
						lista.add(p);
					}
				}
				catch (Exception e) 
				{
					InsertarLogAlamacen.insertarLog(new LogAlmacen("","",""),infoUsu.getUname(),infoUsu.getUname_br(),"Error al llenar lista de datos del ticket, folio: "+folio+". DETALLE: "+Error(e)+" Qry["+Qry(seprado(querys))+"]"+". Usuario: "+session.getAttribute("name").toString()+". Maquina: "+session.getAttribute("maquina").toString()+". Ip: "+session.getAttribute("ip").toString(),infoUsu.getCve_usuario());
				}
			}
		}
		catch (Exception e)
		{
			InsertarLogAlamacen.insertarLog(new LogAlmacen("","",""),infoUsu.getUname(),infoUsu.getUname_br(),"Error al consultar datos del ticket, folio: "+folio+". DETALLE: "+Error(e)+" Qry["+Qry(seprado(querys))+"]"+". Usuario: "+session.getAttribute("name").toString()+". Maquina: "+session.getAttribute("maquina").toString()+". Ip: "+session.getAttribute("ip").toString(),infoUsu.getCve_usuario());
		}
		finally 
		{
			try 
			{
				connBD.close();
				pstm.close();
			} catch (Exception e2)
			{
				InsertarLogAlamacen.insertarLog(new LogAlmacen("","",""),infoUsu.getUname(),infoUsu.getUname_br(),"Error al cerrar conexion y pstm imprimirTicketSeparado. DETALLE: "+Error(e2)+". Usuario: "+session.getAttribute("name").toString()+". Maquina: "+session.getAttribute("maquina").toString()+". Ip: "+session.getAttribute("ip").toString(),infoUsu.getCve_usuario());
			}
		}
		//System.out.println("Ticket no: "+no);
		if (no != 0) 
		{
			Cls_CrearTicketDeIngresos c = new Cls_CrearTicketDeIngresos();
			
			rsp = c.crearArchivoTxtDelTicket(folio, lista,infoUsu.getCve_usuario(), session.getAttribute("impresora").toString(),chofer,infoUsu.getUname(),infoUsu.getUname_br_nombre(),nombrechofer,pedidos,session,tipoEnc,infoUsu,ticket,ruta);
		}
		else
		{
			rsp = "EL FOLIO: "+folio+" NO EXISTE";
		}
		
		return rsp;
	}



	public List<VariosTickets> validarExistencia(String folio, Usuario infoUsu, HttpSession session,List<Querys> ListaQuerys, List<VariosTickets> t) 
	{
		Connection connBD = null;
		PreparedStatement pstm = null;
		connBD = ConexionBD.AbrirConexionBDD(infoUsu.getUname().toUpperCase());
		String [] querys = new String [25];
		try
		{
			querys = Cls_Querys.LimpiaListaQuerys(querys);
			querys = Cls_Querys.ObtieneQuerys(44, ListaQuerys, querys, infoUsu);
			querys = InicializaQueryNumero44(querys, infoUsu,folio);
			pstm = connBD.prepareStatement("{call " + "ALMACEN.usp_EXECUTE_QUERY(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			ResultSet rs = EjecutaQuerysBD.EjecutarQuery(querys[0], querys[1],querys[2], querys[3], querys[4], querys[5], querys[6],
					 querys[7], querys[8], querys[9],querys[10], querys[11], querys[12], querys[13], 
					 querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], 
					 querys[21], querys[22], querys[23], querys[24], infoUsu.getUname(),pstm, connBD,infoUsu);
			InsertarLogAlamacen.insertarLog(new LogAlmacen("","",""),infoUsu.getUname(),infoUsu.getUname_br(),"Consulta datos ticket, folio: "+folio+". Qry["+Qry(seprado(querys))+"]"+". Usuario: "+session.getAttribute("name").toString()+". Maquina: "+session.getAttribute("maquina").toString()+". Ip: "+session.getAttribute("ip").toString(),infoUsu.getCve_usuario());
			if (rs != null) 
			{
				try
				{
					while (rs.next())
					{
						VariosTickets v = new VariosTickets();
						v.setUname(rs.getString("uname_br"));
						v.setDescripcion(rs.getString("descripcion"));
						t.add(v);
					}
				}
				catch (Exception e) 
				{
					InsertarLogAlamacen.insertarLog(new LogAlmacen("","",""),infoUsu.getUname(),infoUsu.getUname_br(),"Error al llenar validacion de varios tickets, folio: "+folio+". DETALLE: "+Error(e)+" Qry["+Qry(seprado(querys))+"]"+". Usuario: "+session.getAttribute("name").toString()+". Maquina: "+session.getAttribute("maquina").toString()+". Ip: "+session.getAttribute("ip").toString(),infoUsu.getCve_usuario());
				}
			}
		}
		catch (Exception e) 
		{
			InsertarLogAlamacen.insertarLog(new LogAlmacen("","",""),infoUsu.getUname(),infoUsu.getUname_br(),"Error al consultar validacion de varios tickets, folio: "+folio+". DETALLE: "+Error(e)+" Qry["+Qry(seprado(querys))+"]"+". Usuario: "+session.getAttribute("name").toString()+". Maquina: "+session.getAttribute("maquina").toString()+". Ip: "+session.getAttribute("ip").toString(),infoUsu.getCve_usuario());
		}
		finally 
		{
			try 
			{
				connBD.close();
				pstm.close();
			} catch (Exception e2)
			{
				InsertarLogAlamacen.insertarLog(new LogAlmacen("","",""),infoUsu.getUname(),infoUsu.getUname_br(),"Error al cerrar conexion y pstm variostickets. DETALLE: "+Error(e2)+". Usuario: "+session.getAttribute("name").toString()+". Maquina: "+session.getAttribute("maquina").toString()+". Ip: "+session.getAttribute("ip").toString(),infoUsu.getCve_usuario());
			}
		}
		return t;
	}



	private String[] InicializaQueryNumero44(String[] ListaQuerys, Usuario infoUsu, String folio)
	{
		for (int i=0;i <ListaQuerys.length; i++)
		{	
			ListaQuerys[i]= ListaQuerys[i].replace("{FOLIO}",folio);
			ListaQuerys[i]= ListaQuerys[i].replace("{UNAME_ASIGNACION}",infoUsu.getUname_br());
		}
		return ListaQuerys;
	}



	private String[] InicializaQueryNumero13(String[] ListaQuerys, Usuario infoUsu, String folio, String where) 
		{
			for (int i=0;i <ListaQuerys.length; i++)
			{	
				ListaQuerys[i]= ListaQuerys[i].replace("{FOLIO}",folio);
				ListaQuerys[i]= ListaQuerys[i].replace("{WHERE}",where);
				
				ListaQuerys[i]= ListaQuerys[i].replace("{CDO_}",infoUsu.getUname().toUpperCase());
				ListaQuerys[i]= ListaQuerys[i].replace("{UNAME_}",infoUsu.getUname().toUpperCase());
				ListaQuerys[i]= ListaQuerys[i].replace("{UNAME_ASIGNACION}",infoUsu.getUname_br());
			}
			return ListaQuerys;
		}


	public List<PedidosConsulta> consultaPedidosTrans(String cdo, String hora, HttpSession session, String cve_usu, String uname_br, String nivel, Usuario infoUsu, List<Querys> ListaQuerys, String ruta, String tipo, String fechaFin, String fechaInicio) 
	{
		Connection connBD = null;
		PreparedStatement pstm = null;
		connBD = ConexionBD.AbrirConexionBDD(cdo);
		String qry = "";
		String tipoBusqueda = " ";
		List<PedidosConsulta> lstPedidos = new ArrayList<PedidosConsulta>();
	
		try
		{
			String [] querys = new String [25];
			querys = Cls_Querys.LimpiaListaQuerys(querys);
			querys = Cls_Querys.ObtieneQuerys(19, ListaQuerys, querys, infoUsu);
		
			List<SeriesCfdi> series = (List<SeriesCfdi>) session.getAttribute("series");
			String split [];
			split = hora.split("/");
			
			String qryTransporte = complementoQryTransporteTrans(split[2],session);
			if (!ruta.equals(""))
			{
				
				ruta = " and r.num_ruta = '"+ruta+"' ";
			}
			if (tipo.equals("p"))
			{
				tipoBusqueda = "PEDIDO";
				tipo = " order by r.descripcion asc, b.num_cli asc, b.fecha_pedido asc, b.pedido asc,p.num_fac asc ";
				session.setAttribute("transporteTipo", "p");
			}
			else
			{
				tipoBusqueda = "FACTURA";
				session.setAttribute("transporteTipo", "f");
				tipo = "order by p.num_fac asc";
			}
			querys = InicializaQueryNumero19(querys, infoUsu,split[0],qryTransporte,ruta,tipo,fechaFin,fechaInicio);
			pstm = connBD.prepareStatement("{call " + "ALMACEN.usp_EXECUTE_QUERY(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			ResultSet rs = EjecutaQuerysBD.EjecutarQuery(querys[0], querys[1],querys[2], querys[3], querys[4], querys[5], querys[6],
					 querys[7], querys[8], querys[9],querys[10], querys[11], querys[12], querys[13], 
					 querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], 
					 querys[21], querys[22], querys[23], querys[24], infoUsu.getUname(),pstm, connBD,infoUsu);
			InsertarLogAlamacen.insertarLog(new LogAlmacen("","",""),infoUsu.getUname(),infoUsu.getUname_br(),"Consulta inicial de pedidos para asignar transporte por "+tipoBusqueda+". Qry["+Qry(seprado(querys))+"]"+". Usuario: "+session.getAttribute("name").toString()+". Maquina: "+session.getAttribute("maquina").toString()+". Ip: "+session.getAttribute("ip").toString(),infoUsu.getCve_usuario());
			Cls_Querys.ImprimeQuerysConsola(querys, false, "Query 19");
			String splitNivel[] = obtenerNivelTrans(nivel,infoUsu,session); 
				if (rs != null) 
				{
					lstPedidos = llenarPedidosTransporte(rs,infoUsu,lstPedidos,splitNivel,series,nivel,session);
					
				}

		}

		catch (Exception e) 
		{
			InsertarLogAlamacen.insertarLog(new LogAlmacen("","",""),infoUsu.getUname(),infoUsu.getUname_br(),"Error en consulta inicial de pedidos para asignar transporte por "+tipoBusqueda+". DETALLE: "+Error(e)+". Usuario: "+session.getAttribute("name").toString()+". Maquina: "+session.getAttribute("maquina").toString()+". Ip: "+session.getAttribute("ip").toString(),infoUsu.getCve_usuario());
		}
		
		finally 
		{
			try 
			{
				connBD.close();
				pstm.close();
			} catch (Exception e2)
			{
				InsertarLogAlamacen.insertarLog(new LogAlmacen("","",""),infoUsu.getUname(),infoUsu.getUname_br(),"Error al cerrar conexion y pstm consulta pedidos transporte por "+tipoBusqueda+". DETALLE: "+Error(e2)+". Usuario: "+session.getAttribute("name").toString()+". Maquina: "+session.getAttribute("maquina").toString()+". Ip: "+session.getAttribute("ip").toString(),infoUsu.getCve_usuario());
			}
		}
		
		
		
		session.setAttribute("listaPedidos", lstPedidos);
	    return lstPedidos;
	}



	private List<PedidosConsulta> llenarPedidosTransporte(ResultSet rs, Usuario infoUsu,
			List<PedidosConsulta> lstPedidos, String[] splitNivel, List<SeriesCfdi> series, String nivel,
			HttpSession session)
	{
		
		
		int no = 0;
		int aux = 0;
		try
		{
			while (rs.next())
			{
				String aux2 = "n";
				if (nivel.equals("*"))
				{
					aux2 = "s";
				}
				else
				{	
					for (int i = 0; i < splitNivel.length; i++) 
					{
						if (splitNivel[i].equals(rs.getString("numeroTransporte"))) 
						{
							aux2 = "s";
							break;
						}
					}
				}
				if (aux2.equals("s"))
				{
					

							no = no+1;
							session.setAttribute("consecutivo", no);
							PedidosConsulta p = new PedidosConsulta();
							if (rs.getInt("num_ruta") == 0) 
							{
								p.setCc(123456789);
							}
							else
							{
								p.setCc(rs.getInt("num_ruta"));
							}
							p.setFactura_larga(rs.getString("factura_larga"));
							p.setNo(String.valueOf(no));
							p.setNor(String.valueOf(no)+"r");
							p.setRuta(rs.getString("ruta"));
							p.setFecha_ods(rs.getString("fecha_pedido"));
							p.setFecha_factura(rs.getString("fecha_factura"));
							p.setFecha_corta(rs.getString("fecha_factura_corta"));
							p.setOds(rs.getString("ods"));
							p.setUname(rs.getString("uname_br"));
							p.setPedido(rs.getString("pedido"));
							p.setOde(rs.getString("ode"));
							p.setOder(rs.getString("ode")+"r");
							p.setProgramada(rs.getString("programada"));
							p.setId_trayecto(rs.getString("id_trayecto"));
							p.setImporte(rs.getString("importe"));
							p.setCondicion(rs.getString("condicion"));

							p.setFactura(rs.getString("num_fac"));
							p.setCte(rs.getString("cte"));
							p.setConsignatario(rs.getString("consignatario"));
							if(rs.getInt("consignatario") > 0)
							{						
								p.setDireccion(rs.getString("direccion"));
								p.setNombre_razon_social(rs.getString("nombre_razon_social"));
							}
							else
							{
								p.setDireccion(rs.getString("direccion_cte"));
								p.setNombre_razon_social(rs.getString("nombre_razon_social_cte"));
							}
							p.setTransporte(rs.getString("transporte"));
							if (aux != 0)
							{
								for (PedidosConsulta l : lstPedidos)
								{
									if (l.getOde().equals(p.getOde()) && l.getPedido().equals(p.getPedido()))
									{
										p.setRepeticion("s");
									}
									else
									{
										p.setRepeticion("n");
									}
								}
								
							}
							else
							{
								p.setRepeticion("n");
							}
							aux++;
							lstPedidos.add(p);
						}
			}
		}
		catch (Exception e) 
		{
			InsertarLogAlamacen.insertarLog(new LogAlmacen("","",""),infoUsu.getUname(),infoUsu.getUname_br(),"Error al llenar pedidos para asignacion transportes. DETALLE: "+Error(e)+". Usuario: "+session.getAttribute("name").toString()+". Maquina: "+session.getAttribute("maquina").toString()+". Ip: "+session.getAttribute("ip").toString(),infoUsu.getCve_usuario());
		}
		
		
		return lstPedidos;
	}



	private String[] obtenerNivelTrans(String nivel, Usuario infoUsu, HttpSession session) 
	{
		if (!nivel.equals("n")) 
		{
		
			if (!nivel.contains(","))
			{
				nivel = nivel+",";
			}
			String niv[] = nivel.split(",");
			return niv;
		}
		else
		{
			String niv[] = nivel.split(",");
			InsertarLogAlamacen.insertarLog(new LogAlmacen("","",""),infoUsu.getUname(),infoUsu.getUname_br(),"No tiene declarado el transporte a nivel usuario. USU_PROC_WEB-dato_alfanumerico2."+". Usuario: "+session.getAttribute("name").toString()+". Maquina: "+session.getAttribute("maquina").toString()+". Ip: "+session.getAttribute("ip").toString(),infoUsu.getCve_usuario());
			return niv;
		}
		
	}



	private String complementoQryTransporteTrans(String split, HttpSession session) {
		String qryTransporte = " ";
		if (!split.equals("*"))
		{
			 qryTransporte = " and t.num_trans in ("+split+") ";
		}
		return qryTransporte;
	}



	private String[] InicializaQueryNumero19(String[] ListaQuerys, Usuario infoUsu, String fecha, String qryTransporte, String ruta, String tipo, String fechaFin, String fechaInicio) {
		for (int i=0;i <ListaQuerys.length; i++)
		{	
			ListaQuerys[i]= ListaQuerys[i].replace("{FECHA_INICIO}",fechaInicio);
			ListaQuerys[i]= ListaQuerys[i].replace("{FECHA_FIN}",fechaFin);
			ListaQuerys[i]= ListaQuerys[i].replace("{RUTA}",ruta);
			ListaQuerys[i]= ListaQuerys[i].replace("{COMPLEMENTO_QRY}",qryTransporte);
			ListaQuerys[i]= ListaQuerys[i].replace("{UNAME_BR_}",infoUsu.getUname_br());
			ListaQuerys[i]= ListaQuerys[i].replace("{UNAME_CDO_}",infoUsu.getUname().toUpperCase());
			ListaQuerys[i]= ListaQuerys[i].replace("{ORDER}",tipo);
		}
		return ListaQuerys;
	}



	public String asignacionPedidosTrans(String pedidos, String chofer, String uname, HttpSession session, String usuario, String uname_br, String cdo_nombre, String odeAgregada, String transporte, Usuario infoUsu, List<Querys> ListaQuerys, String pedidosR, String uname_regional, String numeroFacturas) 
	{
//		InsertarLogAlamacen.insertarLog(new LogAlmacen("","",""),infoUsu.getUname(),infoUsu.getUname_br(),"Pedidos R*"+pedidosR+".",infoUsu.getCve_usuario());
		String FOLIO = "";
		String respuesta = "n";
		String validacion = "";
		Connection connBD = null;
		PreparedStatement pstm = null;
		connBD = ConexionBD.AbrirConexionBDD(uname.toUpperCase());
		if (!odeAgregada.equals("")) 
		{
			validacion = consultaExistenciaOde(pedidos,chofer,uname,session,usuario,uname_br,cdo_nombre,odeAgregada,transporte,infoUsu);;
			
			pedidos = pedidos+","+session.getAttribute("valorPed");
		}
		if (validacion.equals("true") || odeAgregada.equals("")) 
		{

			
			try 
			{
			List<PedidosConsulta> p = (List<PedidosConsulta>) session.getAttribute("listaPedidos");
			String split [] = null;
			pedidos = pedidos.replace(",,",",");
			if (pedidos.contains(",")) 
			{}else {pedidos = pedidos+",";}
			if (pedidos.contains(","))
			{
				split = pedidos.split(",");
				
			}
			validacion = validarAsignadas(split,ListaQuerys,uname,uname_br,session,uname,infoUsu,p,uname_br);
			validacion = "true";
			if (validacion.equals("true"))
			{
				
				FOLIO = obtenerFolioConsecutivo(ListaQuerys,uname,uname_br,connBD,pstm,infoUsu,infoUsu.getUname_br(),session);
				actualizarConsecutivo(Integer.parseInt(FOLIO)+1,uname,uname_br,ListaQuerys,connBD,pstm,infoUsu,pedidos,infoUsu.getUname_br(),session);
				if (!FOLIO.equals("")) 
				{
					
					
						
						respuesta = obtenerProcesoQryTrans(split,chofer,uname,session,p,"",usuario,uname_br,FOLIO,infoUsu,ListaQuerys,pstm,connBD,split,numeroFacturas);
						String rsp = insertarEncabezadoTrans(uname, uname_br, FOLIO, chofer, usuario, p,split,infoUsu,ListaQuerys,connBD,pstm,session);
//						InsertarLogAlamacen.insertarLog(new LogAlmacen("","",""),infoUsu.getUname(),infoUsu.getUname_br(),"Metodo principal con respuesta "+respuesta,infoUsu.getCve_usuario());
						if (!pedidosR.equals("")) 
						{
							String splitReg [] = null;
							pedidosR = pedidosR.replace(",,",",");
							if (pedidosR.contains(",")) 
							{}else {pedidosR = pedidosR+",";}
							if (pedidosR.contains(","))
							{
								splitReg = pedidosR.split(",");
								
							}
							
							InsertarLogAlamacen.insertarLog(new LogAlmacen("","",""),infoUsu.getUname(),infoUsu.getUname_br(),"UNAME REGIONAL SELECCIONADO PARA FOLIO: "+FOLIO+" = "+uname_regional+". Usuario: "+session.getAttribute("name").toString()+". Maquina: "+session.getAttribute("maquina").toString()+". Ip: "+session.getAttribute("ip").toString(),infoUsu.getCve_usuario());
							InsertarLogAlamacen.insertarLog(new LogAlmacen("","",""),infoUsu.getUname(),infoUsu.getUname_br(),"Metodo principal regional antes con respuesta:  "+respuesta,infoUsu.getCve_usuario());
							respuesta = obtenerProcesoQryReg(splitReg, chofer, uname, session, p, "", usuario, uname_br, FOLIO, infoUsu, ListaQuerys, pstm, connBD, splitReg,uname_regional,respuesta);
//							InsertarLogAlamacen.insertarLog(new LogAlmacen("","",""),infoUsu.getUname(),infoUsu.getUname_br(),"Metodo principal regional despues con respuesta "+respuesta,infoUsu.getCve_usuario());
						}
						InsertarLogAlamacen.insertarLog(new LogAlmacen("","",""),infoUsu.getUname(),infoUsu.getUname_br(),"Respuesta final: "+respuesta,infoUsu.getCve_usuario());
						if (!respuesta.equals("n")) 
						{
							imprimirTicketSeparado(FOLIO, infoUsu, p, session,ListaQuerys,infoUsu,"","");
						}
						if (respuesta.equals("s"))
						{
						respuesta = FOLIO;	
						}
					}
				
			
			}
			else
			{
				respuesta = validacion;
				
			}
			}
			catch (Exception e)
			{
				InsertarLogAlamacen.insertarLog(new LogAlmacen("","",""),infoUsu.getUname(),infoUsu.getUname_br(),"Error en metodo de asignacion transportes. DETALLE: "+Error(e)+". Usuario: "+session.getAttribute("name").toString()+". Maquina: "+session.getAttribute("maquina").toString()+". Ip: "+session.getAttribute("ip").toString(),infoUsu.getCve_usuario());
			}
			finally 
			{
				try 
				{
					connBD.close();
					pstm.close();
				} catch (Exception e2)
				{
//					InsertarLogAlamacen.insertarLog(new LogAlmacen("","",""),infoUsu.getUname(),infoUsu.getUname_br(),"Error al cerrar conexion y pstm Asignacion transporte. DETALLE: "+Error(e2),infoUsu.getCve_usuario());
				}
			}
			
			
			return respuesta;
		}
		else
		{
			return validacion;
		}
	}



	private String obtenerProcesoQryReg(String[] split, String chofer, String uname, HttpSession session,
			List<PedidosConsulta> p, String string, String usuario, String uname_br, String FOLIO, Usuario infoUsu,
			List<Querys> listaQuerys, PreparedStatement pstm2, Connection connBD2, String[] splitReg, String uname_regional, String respuesta) 
	{
		
//		InsertarLogAlamacen.insertarLog(new LogAlmacen("","",""),infoUsu.getUname(),infoUsu.getUname_br(),"Entra al proceso de inserts para regional",infoUsu.getCve_usuario());
		String iinsertFac = "";
		
		String insertSeccion = "";
		String insertDetalle = "";
		String insertAsig = "";
		String insertRepro = "";
		Connection connBD = null;
		PreparedStatement pstm = null;
		String validacionOdeYaInsertada = "";
		for (String s : split) 
		{
			String pedidoTipo = "";
			if (s.contains("r"))
			{
				String splitAux [] = s.split("\\*");
				pedidoTipo = "s";
				s = splitAux[0];
			}
		for (PedidosConsulta pp : p) 
		{
			
			if (pp.getNo().equals(s)) 
			{
//				InsertarLogAlamacen.insertarLog(new LogAlmacen("","",""),infoUsu.getUname(),infoUsu.getUname_br(),"Entra a la validacion con respuesta "+respuesta,infoUsu.getCve_usuario());
				try 
				{
				List<SeriesCfdi> series = (List<SeriesCfdi>) session.getAttribute("series");

					
						String estatus = "";
						int sts = 1;
//						if (!pp.getProgramada().equals("99")) 
//						{
//							sts = 8;
//							insertAsig = insertAsig + "('"+infoUsu.getUname()+"', '"+infoUsu.getUname_br()+"', "+pp.getOde()+", "+pp.getPedido()+", 1,"+pp.getId_trayecto()+", CURDATE(), CURTIME()),";
							insertRepro = insertRepro + "('"+infoUsu.getUname()+"', '"+infoUsu.getUname_br()+"', "+pp.getOde()+", "+pp.getPedido()+", "+FOLIO+", 4,'"+uname_regional.substring(0, 3)+"',CURDATE(), CURTIME()),";
							
							
//						}
//						else
//						{
							insertAsig = insertAsig + "('"+infoUsu.getUname()+"', '"+infoUsu.getUname_br()+"', "+pp.getOde()+", "+pp.getPedido()+", 4,NULL, CURDATE(), CURTIME()),";
//						}
						
						
						
						if (!pedidoTipo.equals("")){pedidoTipo = "1";}
						else {pedidoTipo.equals("0");}
						insertDetalle = insertDetalle + "('"+infoUsu.getUname()+"', '"+infoUsu.getUname_br()+"','"+FOLIO+"', '"+pp.getCte()+"','"+pp.getOde()+"','"+pp.getPedido()+"',CURDATE(),CURTIME(),0, 0,0, 0, 4, 0,"+pedidoTipo+"),";
						insertSeccion = insertSeccion + "('"+infoUsu.getUname()+"', '"+infoUsu.getUname_br()+"','"+pp.getOde()+"','"+pp.getPedido()+"','"+FOLIO+"', 1, 1, 4),";
						
						
						if(!validacionOdeYaInsertada.contains(pp.getOde()))
						{
							for (PedidosConsulta l : p)  
							{
								if (pp.getOde().equals(l.getOde()) && pp.getPedido().equals(l.getPedido())) 
								{
									iinsertFac = iinsertFac + "('"+infoUsu.getUname()+"', '"+infoUsu.getUname_br()+"','"+FOLIO+"','"+l.getOde()+"','"+l.getPedido()+"','"+l.getFactura()+"','"+l.getImporte()+"','0','0','0','0','0','0','0','0','','"+l.getCondicion()+"', 4, '0', ' ',CURDATE(), CURTIME()),";
									validacionOdeYaInsertada = validacionOdeYaInsertada + pp.getOde()+ ",";
								}
							}
						}
						
						
						
						
						respuesta = "s";
						break;
					}
				catch (Exception e) 
				{
					InsertarLogAlamacen.insertarLog(new LogAlmacen("","",""),infoUsu.getUname(),infoUsu.getUname_br(),"Error al insertar el detalle de ruta en tablas. DETALLE: "+Error(e)+". Usuario: "+session.getAttribute("name").toString()+". Maquina: "+session.getAttribute("maquina").toString()+". Ip: "+session.getAttribute("ip").toString(),infoUsu.getCve_usuario());
				}

			}	
		}

		}
//		InsertarLogAlamacen.insertarLog(new LogAlmacen("","",""),infoUsu.getUname(),infoUsu.getUname_br(),"Termina validacion con respuesta "+respuesta,infoUsu.getCve_usuario());
		if (!insertRepro.equals(""))
		{
			insertarReprogramadaReg(insertRepro.substring(0,insertRepro.length()-1),connBD,pstm,listaQuerys,infoUsu,FOLIO,session);
		}
		if (!iinsertFac.equals("") && !insertSeccion.equals("") && !insertSeccion.equals("") && !insertAsig.equals(""))
		{
			boolean rsp = false;
			
			rsp = actualizarOdeAsignada(insertAsig.substring(0,insertAsig.length()-1),infoUsu,connBD,pstm,listaQuerys,FOLIO,session);
			if (rsp){
				rsp = insertaDetalleChofer(insertDetalle.substring(0,insertDetalle.length()-1),connBD,pstm,infoUsu,listaQuerys,FOLIO,session);
				if (rsp) {
					rsp = insertaDetalleFacturas(iinsertFac.substring(0,iinsertFac.length()-1),connBD,pstm,infoUsu,listaQuerys,FOLIO,session);
					if (rsp) {
						rsp = insertaSeccion(insertSeccion.substring(0, insertSeccion.length()-1),connBD,pstm,infoUsu,listaQuerys,FOLIO,session);
					}
				}
			}
			
			
			
			
			
		}
		
		return respuesta;
	}



	public String cancelarPedido(HttpServletRequest request, HttpSession session, String ode, Usuario infoUsu, List<Querys> ListaQuerys, String uname_br) 
	{
		String rsp = "Error al cancelar la ODE: "+ode;
		
		Connection connBD = null;
		PreparedStatement pstm = null;
		connBD = ConexionBD.AbrirConexionBDD(infoUsu.getUname().toUpperCase());

		try
		{
			String [] querys = new String [25];
			querys = Cls_Querys.LimpiaListaQuerys(querys);
			querys = Cls_Querys.ObtieneQuerys(18, ListaQuerys, querys, infoUsu);
			querys = InicializaQueryNumero18(querys, infoUsu,ode,uname_br);
			pstm = connBD.prepareStatement("{call " + "ALMACEN.usp_EXECUTE_QUERY(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			ResultSet rs = EjecutaQuerysBD.EjecutarQuery(querys[0], querys[1],querys[2], querys[3], querys[4], querys[5], querys[6],
					 querys[7], querys[8], querys[9],querys[10], querys[11], querys[12], querys[13], 
					 querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], 
					 querys[21], querys[22], querys[23], querys[24], infoUsu.getUname(),pstm, connBD,infoUsu);
			String qry = "";
			for (String string : querys) 
			{
				qry = qry +string+",";
			}
			InsertarLogAlamacen.insertarLog(new LogAlmacen("","",""),infoUsu.getUname(),infoUsu.getUname_br(),"Cancela pedido: "+ode+". Qry[ \n "+Qry(seprado(querys))+" \n ]"+". Usuario: "+session.getAttribute("name").toString()+". Maquina: "+session.getAttribute("maquina").toString()+". Ip: "+session.getAttribute("ip").toString(),infoUsu.getCve_usuario());
			rsp = "Pedido cancelado correctamente";
		}
		catch (Exception e)
		{
			InsertarLogAlamacen.insertarLog(new LogAlmacen("","",""),infoUsu.getUname(),infoUsu.getUname_br(),"Error en metodo de cancelacion pedido. DETALLE: "+Error(e)+". Usuario: "+session.getAttribute("name").toString()+". Maquina: "+session.getAttribute("maquina").toString()+". Ip: "+session.getAttribute("ip").toString(),infoUsu.getCve_usuario());
		}
		finally 
		{
			try 
			{
				connBD.close();
				pstm.close();
			} catch (Exception e2)
			{
				InsertarLogAlamacen.insertarLog(new LogAlmacen("","",""),infoUsu.getUname(),infoUsu.getUname_br(),"Error al cerrar conexion y pstm cancelacion pedido. DETALLE: "+Error(e2)+". Usuario: "+session.getAttribute("name").toString()+". Maquina: "+session.getAttribute("maquina").toString()+". Ip: "+session.getAttribute("ip").toString(),infoUsu.getCve_usuario());
			}
		}
		
		return rsp;
	}


	
	
	private String[] InicializaQueryNumero18(String[] ListaQuerys, Usuario infoUsu, String ode, String uname_br) 
	{
		for (int i=0;i <ListaQuerys.length; i++)
		{	
			ListaQuerys[i]= ListaQuerys[i].replace("{ODE}",ode);
			ListaQuerys[i]= ListaQuerys[i].replace("{UNAME_BR_}",uname_br);
			ListaQuerys[i]= ListaQuerys[i].replace("{UNAME_CDO_}",infoUsu.getUname().toUpperCase());
		}
		return ListaQuerys;
	}



	private String[] InicializaQueryNumero15(String[] ListaQuerys, Usuario infoUsu, String folio, String uname) 
	{
		for (int i=0;i <ListaQuerys.length; i++)
		{	
			ListaQuerys[i]= ListaQuerys[i].replace("{FOLIO}",folio);
			ListaQuerys[i]= ListaQuerys[i].replace("{UNAME_CDO_}",infoUsu.getUname().toUpperCase());
			ListaQuerys[i]= ListaQuerys[i].replace("{UNAME_BR_}",uname);
			
		}
		return ListaQuerys;
	}
	
	
	private String[] InicializaQueryNumero53(String[] ListaQuerys, Usuario infoUsu, String split, String qryTransporte, String uname_br, String cdo, String ruta, String tipo, String fechaFin, String fechaInicio,String odes) 
	{
		for (int i=0;i <ListaQuerys.length; i++)
		{	
			ListaQuerys[i]= ListaQuerys[i].replace("{FECHA}",split);
			ListaQuerys[i]= ListaQuerys[i].replace("{RUTA}",ruta);
			ListaQuerys[i]= ListaQuerys[i].replace("{TRANSPORTES}",qryTransporte);
			ListaQuerys[i]= ListaQuerys[i].replace("{UNAME_BR}",uname_br);
			ListaQuerys[i]= ListaQuerys[i].replace("{UNAME_}",infoUsu.getUname().toUpperCase());
			ListaQuerys[i]= ListaQuerys[i].replace("{ORDER}",tipo);
			ListaQuerys[i]= ListaQuerys[i].replace("{ODES}",odes);
			ListaQuerys[i]= ListaQuerys[i].replace("{FECHA_INICIO}",fechaInicio);
			ListaQuerys[i]= ListaQuerys[i].replace("{FECHA_FIN}",fechaFin);
		}
		return ListaQuerys;
	}
	private String[] InicializaQueryNumero72(String[] ListaQuerys, Usuario infoUsu, String split, String qryTransporte, String uname_br, String cdo, String ruta, String tipo, String fechaFin, String fechaInicio,String facturas) 
	{
		for (int i=0;i <ListaQuerys.length; i++)
		{	
			ListaQuerys[i]= ListaQuerys[i].replace("{FECHA}",split);
			ListaQuerys[i]= ListaQuerys[i].replace("{RUTA}",ruta);
			ListaQuerys[i]= ListaQuerys[i].replace("{TRANSPORTES}",qryTransporte);
			ListaQuerys[i]= ListaQuerys[i].replace("{UNAME_BR}",uname_br);
			ListaQuerys[i]= ListaQuerys[i].replace("{UNAME_}",infoUsu.getUname().toUpperCase());
			ListaQuerys[i]= ListaQuerys[i].replace("{ORDER}",tipo);
			ListaQuerys[i]= ListaQuerys[i].replace("{FACTURAS}",facturas);
			ListaQuerys[i]= ListaQuerys[i].replace("{FECHA_INICIO}",fechaInicio);
			ListaQuerys[i]= ListaQuerys[i].replace("{FECHA_FIN}",fechaFin);
			ListaQuerys[i]= ListaQuerys[i].replace("{UNAME}",cdo);
			
		}
		return ListaQuerys;
	}
	private String[] InicializaQueryNumero1(String[] ListaQuerys, Usuario infoUsu, String split, String qryTransporte, String uname_br, String cdo, String ruta, String tipo, String fechaInicio, String fechaFin) 
	{
		for (int i=0;i <ListaQuerys.length; i++)
		{	
			ListaQuerys[i]= ListaQuerys[i].replace("{FECHA}",split);
			ListaQuerys[i]= ListaQuerys[i].replace("{FECHA_INICIO}",fechaInicio);
			ListaQuerys[i]= ListaQuerys[i].replace("{FECHA_FIN}",fechaFin);
			ListaQuerys[i]= ListaQuerys[i].replace("{RUTA}",ruta);
			ListaQuerys[i]= ListaQuerys[i].replace("{TRANSPORTES}",qryTransporte);
			ListaQuerys[i]= ListaQuerys[i].replace("{UNAME_BR}",uname_br);
			ListaQuerys[i]= ListaQuerys[i].replace("{UNAME_}",infoUsu.getUname().toUpperCase());
			ListaQuerys[i]= ListaQuerys[i].replace("{ORDER}",tipo);
		}
		return ListaQuerys;
	}
		
	private String[] InicializaQueryNumero66(String[] ListaQuerys,String factura, String cdo) {
		for(int i = 0; i<ListaQuerys.length; i++) {
			ListaQuerys[i] = ListaQuerys[i].replace("{FACTURA}", factura);
			ListaQuerys[i] = ListaQuerys[i].replace("{UNAME}", cdo.toUpperCase());
		}
		return ListaQuerys; 
	}
	
	private String[] InicializaQueryNumero61(String[] ListaQuerys,String fechaInicio, String fechaFin, String cdo) {
		for(int i = 0; i<ListaQuerys.length; i++) {
			ListaQuerys[i] = ListaQuerys[i].replace("{FECHA_INI}", fechaInicio);
			ListaQuerys[i] = ListaQuerys[i].replace("{FECHA_FIN}", fechaFin);
			ListaQuerys[i] = ListaQuerys[i].replace("{UNAME}", cdo.toUpperCase());
		}
		return ListaQuerys; 
	}
	
	private String[] InicializaQueryNumero62(String[] ListaQuerys, String factura, String cdo) {
		for(int i = 0; i<ListaQuerys.length; i++) {
			ListaQuerys[i] = ListaQuerys[i].replace("{FACTURA_TRASLADO}", factura);	
			ListaQuerys[i] = ListaQuerys[i].replace("{UNAME}", cdo.toUpperCase());
		}
		return ListaQuerys; 
	}
	
	private String[] InicializaQueryNumero2(String[] ListaQuerys, Usuario infoUsu, String cdo, String uname, String ode,String pedido) 
	{
		for (int i=0;i <ListaQuerys.length; i++)
		{	
			ListaQuerys[i]= ListaQuerys[i].replace("{CDO_}",cdo);
			ListaQuerys[i]= ListaQuerys[i].replace("{PED_UNAME}",uname);
			ListaQuerys[i]= ListaQuerys[i].replace("{PED_ODE}",ode);
			ListaQuerys[i]= ListaQuerys[i].replace("{UNAME_}",uname.toUpperCase());
			ListaQuerys[i]= ListaQuerys[i].replace("{PED_PEDIDO}",pedido);
			
		}
		return ListaQuerys;
	}



	public List<TrayectoDatos> consultarDetalle(HttpServletRequest request, HttpSession session, String folio, Usuario infoUsu,
			List<Querys> ListaQuerys, List<TrayectoDatos> lstTreyecto, String uname) 
	{
	
		Connection connBD = null;
		PreparedStatement pstm = null;
		String f= "";
		connBD = ConexionBD.AbrirConexionBDD(infoUsu.getUname().toUpperCase());
		String serivdor = infoUsu.getUname().toUpperCase();
		try 
		{
			String [] querys = new String [25];
			querys = Cls_Querys.LimpiaListaQuerys(querys);
			querys = Cls_Querys.ObtieneQuerys(15, ListaQuerys, querys, infoUsu);
			querys = InicializaQueryNumero15(querys, infoUsu,folio,uname);
			Cls_Querys.ImprimeQuerysConsola(querys, false, "Query 15");
			pstm = connBD.prepareStatement("{call " + "ALMACEN.usp_EXECUTE_QUERY(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			ResultSet rs = EjecutaQuerysBD.EjecutarQuery(querys[0], querys[1],querys[2], querys[3], querys[4], querys[5], querys[6],
					 querys[7], querys[8], querys[9],querys[10], querys[11], querys[12], querys[13], 
					 querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], 
					 querys[21], querys[22], querys[23], querys[24], infoUsu.getUname(),pstm, connBD,infoUsu);
			InsertarLogAlamacen.insertarLog(new LogAlmacen("","",""),infoUsu.getUname(),infoUsu.getUname_br(),"Consulta detalle de trayecto: "+folio+". Qry["+Qry(seprado(querys))+"]"+". Usuario: "+session.getAttribute("name").toString()+". Maquina: "+session.getAttribute("maquina").toString()+". Ip: "+session.getAttribute("ip").toString(),infoUsu.getCve_usuario());
			
			
			if (rs != null) 
			{
				lstTreyecto = llenarDetalleTrayecto(infoUsu,rs,lstTreyecto,folio,session);
			}
		} catch (Exception e) 
		{
			InsertarLogAlamacen.insertarLog(new LogAlmacen("","",""),infoUsu.getUname(),infoUsu.getUname_br(),"Error en consulta detalle trayecto: "+folio+". DETALLE: "+Error(e)+". Usuario: "+session.getAttribute("name").toString()+". Maquina: "+session.getAttribute("maquina").toString()+". Ip: "+session.getAttribute("ip").toString(),infoUsu.getCve_usuario());
		}
		finally 
		{
			try 
			{
				connBD.close();
				pstm.close();
			} catch (Exception e2)
			{
				InsertarLogAlamacen.insertarLog(new LogAlmacen("","",""),infoUsu.getUname(),infoUsu.getUname_br(),"Error al cerrar conexion y pstm consulta detalle trayectos. DETALLE: "+Error(e2)+". Usuario: "+session.getAttribute("name").toString()+". Maquina: "+session.getAttribute("maquina").toString()+". Ip: "+session.getAttribute("ip").toString(),infoUsu.getCve_usuario());
			}
		}
		
		return lstTreyecto;
	}



	private List<TrayectoDatos> llenarDetalleTrayecto(Usuario infoUsu, ResultSet rs, List<TrayectoDatos> lstTreyecto,String folio, HttpSession session)
	{
		int aux = 0;
		try
		{
			while (rs.next())
			{
				
				TrayectoDatos t = new TrayectoDatos();
				
				t.setUname(rs.getString("uname").toUpperCase());
				t.setDiasEnc(rs.getString("diasEnc"));
				t.setDiasEncPed(rs.getString("diasEncPed"));
				t.setDias(rs.getString("dias"));
				t.setFolio_corte(rs.getString("folio_corte"));
				t.setDiasPed(rs.getString("diasPed"));
				t.setHoras(calcularHoras(rs.getInt("dias"),rs.getString("horas")));
				t.setHorasAsig(calcularHoras(rs.getInt("diasAsig"),rs.getString("horasAsig")).replace("-",""));
				if(rs.getString("tipo").equals("T")) {
					t.setTipo("TRANSP");	
				}
				else
				{
					t.setTipo("CHOFER");	
				}
				
				t.setTransporteNombre(rs.getString("transporte_nombre"));
				t.setHorasPed(calcularHoras(rs.getInt("diasPed"),rs.getString("horasPed")));
				t.setIngresos(rs.getString("ingresos"));
				t.setHorasEnc(calcularHoras(rs.getInt("diasEnc"),rs.getString("horasEnc")));
				t.setHorasEncPed(calcularHoras(rs.getInt("diasEncPed"),rs.getString("horasEncPed")));
				t.setFechaPedido(rs.getString("fecha_pedido"));
				t.setNumeroChofer(rs.getString("num_chofer"));
				t.setUname_br(rs.getString("uname_br"));
				t.setRuta(rs.getString("ruta"));
				t.setDireccion(rs.getString("direccion"));
				t.setDescripcion_cdo(rs.getString("descripcion_cdo"));
				t.setId_traycto(rs.getString("id_trayecto"));
				t.setCliente_nombre(rs.getString("cliente_nombre"));
				t.setNum_chofer(rs.getString("num_chofer")+" - "+rs.getString("nombre_chofer"));
				t.setNombre_chofer(rs.getString("nombre_chofer"));
				t.setFecha_asignacion(rs.getString("fecha_asignacion"));
				t.setHora_asignacion(rs.getString("hora_asignacion"));
				t.setAsignacionConcat(rs.getString("fecha_asignacion")+" - "+rs.getString("hora_asignacion"));
				t.setUsuario_asignacion(rs.getString("usuario_asignacion")+" - "+rs.getString("nombre_usuario"));
				t.setFecha_inicio_trayecto(rs.getString("fecha_inicio_trayecto"));
				t.setFecha_inicio_entrega(rs.getString("fecha_inicio_entrega"));
				t.setFecha_fin_trayecto(rs.getString("fecha_fin_trayecto"));
				t.setHora_inicio_trayecto(rs.getString("hora_inicio_trayecto"));
				t.setHora_fin_trayecto(rs.getString("hora_fin_trayecto"));
				t.setInicioConcat(rs.getString("fecha_inicio_trayecto")+" - "+rs.getString("hora_inicio_trayecto"));
				t.setFinConcat(rs.getString("fecha_fin_trayecto")+" - "+rs.getString("hora_fin_trayecto"));
				t.setCliente(rs.getString("cliente")+"-"+rs.getString("nombre_cliente"));
				t.setOde(rs.getString("ode"));
				t.setPedido(rs.getString("pedido"));
				t.setFactura(rs.getString("factura"));
				t.setFacturas(rs.getString("facturas"));
				t.setImporte(formatearImporte(rs.getString("importe")));
				t.setEstatus(rs.getString("descripcion"));
				t.setId_estatus(rs.getString("id_estatus"));
				t.setImporte_cobrado(formatearImporte(rs.getString("importe_cobrado")));
				t.setObservaciones(rs.getString("observaciones"));
				t.setTipo_cobro(rs.getString("tipo_cobro"));
				t.setLatitud_inicio_entrega(rs.getString("latitud_inicio_entrega"));
				t.setLatitud_fin_entrega(rs.getString("latitud_fin_entrega"));
				t.setLongitud_inicio_entrega(rs.getString("longitud_inicio_entrega"));
				t.setLongitud_fin_entrega(rs.getString("longitud_fin_entrega"));
				if (aux != 0) 
				{
					for (TrayectoDatos tt: lstTreyecto) 
					{
						if (tt.getId_traycto().equals(rs.getString("id_trayecto"))) 
						{
							t.setRepeticion("s");
						}
						else
						{
							t.setRepeticion("n");
							
						}
					}
				}
				else
				{
					t.setRepeticion("n");
				}
				aux++;
				t.setNo(String.valueOf(aux));
				lstTreyecto.add(t);
				}
			String lat = "", lon ="";
			int coun = 0, no = 1;
			for (TrayectoDatos x : lstTreyecto) 
			{
				if (coun == 0) 
				{
					lat = x.getLatitud_inicio_entrega();
					lon = x.getLongitud_inicio_entrega();
					x.setNo(String.valueOf(no));
					coun ++;
				}
				else
				{
					if (lat.equals(x.getLatitud_inicio_entrega()) && lon.equals(x.getLongitud_inicio_entrega())) 
					{
						x.setNo(String.valueOf(no));
					}
					else
					{
						no++;
						x.setNo(String.valueOf(no));
					}
					coun++;
				}
			}
		}
		catch (Exception e) 
		{
			InsertarLogAlamacen.insertarLog(new LogAlmacen("","",""),infoUsu.getUname(),infoUsu.getUname_br(),"Error al llenar datos de detalle trayecto: "+folio+". DETALLE: "+Error(e)+". Usuario: "+session.getAttribute("name").toString()+". Maquina: "+session.getAttribute("maquina").toString()+". Ip: "+session.getAttribute("ip").toString(),infoUsu.getCve_usuario());
		}
		return lstTreyecto;
	}



	public String consultarDetalle(HttpServletRequest request, HttpSession session, String fecha, Usuario infoUsu,List<Querys> ListaQuerys, String cdo) 
	{
		session.setAttribute("corte", "");
		String rsp = "No se pudo generar el corte";
		Connection connBD = null;
		PreparedStatement pstm = null;
		connBD = ConexionBD.AbrirConexionBDD(infoUsu.getUname().toUpperCase());
		List<Corte> lstPedidos = new ArrayList<Corte>();
		List<Corte> lstPedidos2 = new ArrayList<Corte>();
		GenerarCorte c = new GenerarCorte();
		int aux = 0;
		try 
		{
			String [] querys = new String [25];
			querys = Cls_Querys.LimpiaListaQuerys(querys);
			querys = Cls_Querys.ObtieneQuerys(33, ListaQuerys, querys, infoUsu);
			String qry = "";
			querys = InicializaQueryNumero33(querys, infoUsu,fecha,cdo);
			for (String string : querys) 
			{
				qry += string+",";
			}
			pstm = connBD.prepareStatement("{call " + "ALMACEN.usp_EXECUTE_QUERY(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			ResultSet rs = EjecutaQuerysBD.EjecutarQuery(querys[0], querys[1],querys[2], querys[3], querys[4], querys[5], querys[6],
					 querys[7], querys[8], querys[9],querys[10], querys[11], querys[12], querys[13], 
					 querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], 
					 querys[21], querys[22], querys[23], querys[24], infoUsu.getUname(),pstm, connBD,infoUsu);
			InsertarLogAlamacen.insertarLog(new LogAlmacen("","",""),infoUsu.getUname(),infoUsu.getUname_br(),"Consulta datos para generar corte. Qry["+Qry(seprado(querys))+"]"+". Usuario: "+session.getAttribute("name").toString()+". Maquina: "+session.getAttribute("maquina").toString()+". Ip: "+session.getAttribute("ip").toString(),infoUsu.getCve_usuario());
			if (rs != null) 
			{
				lstPedidos = llenarCorte(rs,infoUsu,lstPedidos,session);
			}
			if (lstPedidos.size()>0)
			{
				
				aux++;
			}
			
			querys = Cls_Querys.LimpiaListaQuerys(querys);
			querys = Cls_Querys.ObtieneQuerys(34, ListaQuerys, querys, infoUsu);
			querys = InicializaQueryNumero33(querys, infoUsu,fecha,cdo);
			qry = "";
			for (String string : querys) 
			{
				qry += string+",";
			}
			pstm = connBD.prepareStatement("{call " + "ALMACEN.usp_EXECUTE_QUERY(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			 rs = EjecutaQuerysBD.EjecutarQuery(querys[0], querys[1],querys[2], querys[3], querys[4], querys[5], querys[6],
					 querys[7], querys[8], querys[9],querys[10], querys[11], querys[12], querys[13], 
					 querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], 
					 querys[21], querys[22], querys[23], querys[24], infoUsu.getUname(),pstm, connBD,infoUsu);
			InsertarLogAlamacen.insertarLog(new LogAlmacen("","",""),infoUsu.getUname(),infoUsu.getUname_br(),"Consulta datos para generar corte. Qry["+Qry(seprado(querys))+"]"+". Usuario: "+session.getAttribute("name").toString()+". Maquina: "+session.getAttribute("maquina").toString()+". Ip: "+session.getAttribute("ip").toString(),infoUsu.getCve_usuario());
			
			if (rs != null) 
			{
				lstPedidos2 = llenarCorte2(rs,infoUsu,lstPedidos2,session);
			}
			if (lstPedidos2.size()>0)
			{
				
				aux++;
			}
			String updateFacCorte = "";
			String folioCorte="";
			try {
			qry = "";
			querys = Cls_Querys.LimpiaListaQuerys(querys);
			querys = Cls_Querys.ObtieneQuerys(38, ListaQuerys, querys, infoUsu);
			querys = InicializaQueryNumero38(querys, infoUsu,fecha,cdo);
			pstm = connBD.prepareStatement("{call " + "ALMACEN.usp_EXECUTE_QUERY(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			 rs = EjecutaQuerysBD.EjecutarQuery(querys[0], querys[1],querys[2], querys[3], querys[4], querys[5], querys[6],
					 querys[7], querys[8], querys[9],querys[10], querys[11], querys[12], querys[13], 
					 querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], 
					 querys[21], querys[22], querys[23], querys[24], infoUsu.getUname(),pstm, connBD,infoUsu);
			InsertarLogAlamacen.insertarLog(new LogAlmacen("","",""),infoUsu.getUname(),infoUsu.getUname_br(),"Consulta consecutivo corte. Qry["+Qry(seprado(querys))+"]"+". Usuario: "+session.getAttribute("name").toString()+". Maquina: "+session.getAttribute("maquina").toString()+". Ip: "+session.getAttribute("ip").toString(),infoUsu.getCve_usuario());
			
			if (rs != null) 
			{
				while (rs.next()) 
				{
					folioCorte = rs.getString("folio_corte");
				}
			}
			}
			catch (Exception e) 
			{
				InsertarLogAlamacen.insertarLog(new LogAlmacen("","",""),infoUsu.getUname(),infoUsu.getUname_br(),"Error consultar consecutivo corte. DETALLE: "+Error(e)+". Qry["+Qry(seprado(querys))+"]"+". Usuario: "+session.getAttribute("name").toString()+". Maquina: "+session.getAttribute("maquina").toString()+". Ip: "+session.getAttribute("ip").toString(),infoUsu.getCve_usuario());
			}
			
			if (!folioCorte.equals("")) 
			{
				
				try {
					qry = "";
				querys = Cls_Querys.LimpiaListaQuerys(querys);
				querys = Cls_Querys.ObtieneQuerys(39, ListaQuerys, querys, infoUsu);
				querys = InicializaQueryNumero39(querys, infoUsu,folioCorte,fecha);
				pstm = connBD.prepareStatement("{call " + "ALMACEN.usp_EXECUTE_QUERY(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
				 rs = EjecutaQuerysBD.EjecutarQuery(querys[0], querys[1],querys[2], querys[3], querys[4], querys[5], querys[6],
						 querys[7], querys[8], querys[9],querys[10], querys[11], querys[12], querys[13], 
						 querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], 
						 querys[21], querys[22], querys[23], querys[24], infoUsu.getUname(),pstm, connBD,infoUsu);
				InsertarLogAlamacen.insertarLog(new LogAlmacen("","",""),infoUsu.getUname(),infoUsu.getUname_br(),"Actualiza facturas corte generado. Qry["+Qry(seprado(querys))+"]"+". Usuario: "+session.getAttribute("name").toString()+". Maquina: "+session.getAttribute("maquina").toString()+". Ip: "+session.getAttribute("ip").toString(),infoUsu.getCve_usuario());
				}
				catch (Exception e) 
				{
					InsertarLogAlamacen.insertarLog(new LogAlmacen("","",""),infoUsu.getUname(),infoUsu.getUname_br(),"Error actualizar facturas corte generado. DETALLE: "+Error(e)+". Qry["+Qry(seprado(querys))+"]"+". Usuario: "+session.getAttribute("name").toString()+". Maquina: "+session.getAttribute("maquina").toString()+". Ip: "+session.getAttribute("ip").toString(),infoUsu.getCve_usuario());
				}
				try 
				{
					folioCorte = String.valueOf((Integer.parseInt(folioCorte)+1));
					querys = Cls_Querys.LimpiaListaQuerys(querys);
					querys = Cls_Querys.ObtieneQuerys(40, ListaQuerys, querys, infoUsu);
					querys = InicializaQueryNumero40(querys,infoUsu,folioCorte);
					pstm = connBD.prepareStatement("{call " + "ALMACEN.usp_EXECUTE_QUERY(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
					 rs = EjecutaQuerysBD.EjecutarQuery(querys[0], querys[1],querys[2], querys[3], querys[4], querys[5], querys[6],
							 querys[7], querys[8], querys[9],querys[10], querys[11], querys[12], querys[13], 
							 querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], 
							 querys[21], querys[22], querys[23], querys[24], infoUsu.getUname(),pstm, connBD,infoUsu);
						InsertarLogAlamacen.insertarLog(new LogAlmacen("","",""),infoUsu.getUname(),infoUsu.getUname_br(),"Actualizar folio consecutivo corte a: "+folioCorte+". Qry["+Qry(seprado(querys))+"]"+". Usuario: "+session.getAttribute("name").toString()+". Maquina: "+session.getAttribute("maquina").toString()+". Ip: "+session.getAttribute("ip").toString(),infoUsu.getCve_usuario());
				}
				catch (Exception e)
				{
					InsertarLogAlamacen.insertarLog(new LogAlmacen("","",""),infoUsu.getUname(),infoUsu.getUname_br(),"Error al actualizar folio consecutivo corte  a: "+folioCorte+". DETALLE: "+Error(e)+".  Qry["+Qry(seprado(querys))+"]"+". Usuario: "+session.getAttribute("name").toString()+". Maquina: "+session.getAttribute("maquina").toString()+". Ip: "+session.getAttribute("ip").toString(),infoUsu.getCve_usuario());
				}
				
			}
			session.setAttribute("corte", "");
			rsp = c.crearArchivoTxtDelTicket(lstPedidos,infoUsu,session.getAttribute("impresora").toString(),fecha,"0",String.valueOf((Integer.parseInt(folioCorte)-1)),session);
			rsp = c.crearArchivoTxtDelTicket(lstPedidos2,infoUsu,session.getAttribute("impresora").toString(),fecha,"1",String.valueOf((Integer.parseInt(folioCorte)-1)),session);
			
		} 
		catch (Exception e) 
		{
			InsertarLogAlamacen.insertarLog(new LogAlmacen("","",""),infoUsu.getUname(),infoUsu.getUname_br(),"Error en consulta para generar corte. DETALLE: "+Error(e)+". Usuario: "+session.getAttribute("name").toString()+". Maquina: "+session.getAttribute("maquina").toString()+". Ip: "+session.getAttribute("ip").toString(),infoUsu.getCve_usuario());
		}
		finally 
		{
			try 
			{
				connBD.close();
				pstm.close();
			} catch (Exception e2)
			{
				InsertarLogAlamacen.insertarLog(new LogAlmacen("","",""),infoUsu.getUname(),infoUsu.getUname_br(),"Error al cerrar conexion y pstm corte. DETALLE: "+Error(e2)+". Usuario: "+session.getAttribute("name").toString()+". Maquina: "+session.getAttribute("maquina").toString()+". Ip: "+session.getAttribute("ip").toString(),infoUsu.getCve_usuario());
			}
		}
		
		
		if (aux == 0) 
		{
			rsp = "No hay informacion con esa fecha";
		}		
		
		return rsp;
	}



	private String[] InicializaQueryNumero39(String[] ListaQuerys, Usuario infoUsu, String folioCorte, String fecha) {
		for (int i=0;i <ListaQuerys.length; i++)
		{	
			ListaQuerys[i]= ListaQuerys[i].replace("{UNAME_CDO_}",infoUsu.getUname());
			ListaQuerys[i]= ListaQuerys[i].replace("{UNAME_BR_}",infoUsu.getUname_br());
			ListaQuerys[i]= ListaQuerys[i].replace("{FOLIO}",folioCorte);
			ListaQuerys[i]= ListaQuerys[i].replace("{FECHA}",fecha);
			ListaQuerys[i]= ListaQuerys[i].replace("{USUARIO}",infoUsu.getCve_usuario());
			
		}
		return ListaQuerys;
	}



	private String[] InicializaQueryNumero40(String[] ListaQuerys, Usuario infoUsu, String folioCorte) {
		for (int i=0;i <ListaQuerys.length; i++)
		{	
			ListaQuerys[i]= ListaQuerys[i].replace("{UNAME_CDO_}",infoUsu.getUname());
			ListaQuerys[i]= ListaQuerys[i].replace("{UNAME_BR_}",infoUsu.getUname_br());
			ListaQuerys[i]= ListaQuerys[i].replace("{USUARIO}",infoUsu.getCve_usuario());
			ListaQuerys[i]= ListaQuerys[i].replace("{FOLIO}",folioCorte);
			
		}
		return ListaQuerys;
	}



	private String[] InicializaQueryNumero38(String[] ListaQuerys, Usuario infoUsu, String fecha, String cdo) {
			for (int i=0;i <ListaQuerys.length; i++)
			{	
				ListaQuerys[i]= ListaQuerys[i].replace("{UNAME_CDO_}",infoUsu.getUname());
				ListaQuerys[i]= ListaQuerys[i].replace("{UNAME_BR_}",infoUsu.getUname_br());
				ListaQuerys[i]= ListaQuerys[i].replace("{UNAME_}",infoUsu.getUname().toUpperCase());
				ListaQuerys[i]= ListaQuerys[i].replace("{USUARIO}",infoUsu.getCve_usuario());
				
			}
			return ListaQuerys;
	}



	private List<Corte> llenarCorte2(ResultSet rs, Usuario infoUsu, List<Corte> lstPedidos, HttpSession session) 
	{
		try
		{
			while (rs.next())
			{
				
				Corte t = new Corte();
				t.setUname(rs.getString("uname"));
				t.setUname_br(rs.getString("uname_br"));
				t.setPedido(rs.getString("pedido"));
				t.setOde(rs.getString("ode"));
				t.setTransporte(rs.getString("transporte"));
				t.setFacturas(rs.getString("facturas"));
				t.setImporte(formatearImporte(rs.getString("importe")));
				t.setTotalfacturas(rs.getString("facturaTotal"));
				t.setTotalImporte(formatearImporte(rs.getString("importeTotal")));
				lstPedidos.add(t);
			}
		}
		catch (Exception e) 
		{
			InsertarLogAlamacen.insertarLog(new LogAlmacen("","",""),infoUsu.getUname(),infoUsu.getUname_br(),"Error al llenar datos de generar corte2. DETALLE: "+Error(e)+". Usuario: "+session.getAttribute("name").toString()+". Maquina: "+session.getAttribute("maquina").toString()+". Ip: "+session.getAttribute("ip").toString(),infoUsu.getCve_usuario());
		}
		
		return lstPedidos;
	}



	private List<Corte> llenarCorte(ResultSet rs, Usuario infoUsu, List<Corte> lstPedidos, HttpSession session) {
		try
		{
			while (rs.next())
			{
				
				Corte t = new Corte();
				t.setUname(rs.getString("uname"));
				t.setUname_br(rs.getString("uname_br"));
				t.setPedido(rs.getString("pedido"));
				t.setOde(rs.getString("ode"));
				t.setTransporte(rs.getString("transporte"));
				t.setFacturas(rs.getString("facturas"));
				t.setImporte(formatearImporte(rs.getString("importe")));
				t.setTotalfacturas(rs.getString("facturaTotal"));
				t.setTotalImporte(formatearImporte(rs.getString("importeTotal")));
				lstPedidos.add(t);
			}
		}
		catch (Exception e) 
		{
			InsertarLogAlamacen.insertarLog(new LogAlmacen("","",""),infoUsu.getUname(),infoUsu.getUname_br(),"Error al llenar datos de generar corte. DETALLE: "+Error(e)+". Usuario: "+session.getAttribute("name").toString()+". Maquina: "+session.getAttribute("maquina").toString()+". Ip: "+session.getAttribute("ip").toString(),infoUsu.getCve_usuario());
		}
		
		
		return lstPedidos;
	}



	private String[] InicializaQueryNumero33(String[] ListaQuerys, Usuario infoUsu, String fecha, String cdo) 
	{
		String where = "";
		  
		if (infoUsu.getNivel_usuario() == 1)
		{
			if (!cdo.equals("")) 
			{
				if (!cdo.contains("*")) 
				{
					where = " and a.uname = '"+cdo+"'  ";
				}
				else
				{
					where = " and a.uname_br = '"+cdo.substring(0,cdo.length()-1)+"'  ";
				}
			}
			else
			{
				where = " and a.uname_br = '"+infoUsu.getUname_br()+"' ";
			}
		}
		else
		{
			where = " and a.uname_br = '"+infoUsu.getUname_br()+"' ";
		}
		
		
		for (int i=0;i <ListaQuerys.length; i++)
		{	
			ListaQuerys[i]= ListaQuerys[i].replace("{FECHA}",fecha);
			ListaQuerys[i]= ListaQuerys[i].replace("{UNAME_CDO_}",infoUsu.getUname().toUpperCase());
			ListaQuerys[i]= ListaQuerys[i].replace("{USUARIO}",infoUsu.getCve_usuario());
			ListaQuerys[i]= ListaQuerys[i].replace("{COMPLEMENTO_UNAME}",where);
			
			
		}
		return ListaQuerys;
	}






	public List<Credito> consultarCredito(HttpServletRequest request, HttpSession session, Usuario infoUsu,
			List<Querys> ListaQuerys, List<Credito> lstTreyecto, String fecha, String cdoCredito, String tipo, String fechaFin, String corte) 
	{
		Connection connBD = null;
		PreparedStatement pstm = null;
		String f= "";
		connBD = ConexionBD.AbrirConexionBDD(infoUsu.getUname().toUpperCase());
		String serivdor = infoUsu.getUname().toUpperCase();
		try 
		{
			String [] querys = new String [25];
			querys = Cls_Querys.LimpiaListaQuerys(querys);
			querys = Cls_Querys.ObtieneQuerys(35, ListaQuerys, querys, infoUsu);
			querys = InicializaQueryNumero35(querys, infoUsu,fecha,cdoCredito,tipo,fechaFin,corte);
			pstm = connBD.prepareStatement("{call " + "ALMACEN.usp_EXECUTE_QUERY(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			ResultSet rs = EjecutaQuerysBD.EjecutarQuery(querys[0], querys[1],querys[2], querys[3], querys[4], querys[5], querys[6],
					 querys[7], querys[8], querys[9],querys[10], querys[11], querys[12], querys[13], 
					 querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], 
					 querys[21], querys[22], querys[23], querys[24], infoUsu.getUname(),pstm, connBD,infoUsu);
			InsertarLogAlamacen.insertarLog(new LogAlmacen("","",""),infoUsu.getUname(),infoUsu.getUname_br(),"Consulta facturas confirmadas. Qry["+Qry(seprado(querys))+"]"+". Usuario: "+session.getAttribute("name").toString()+". Maquina: "+session.getAttribute("maquina").toString()+". Ip: "+session.getAttribute("ip").toString(),infoUsu.getCve_usuario());
			
			
			if (rs != null) 
			{
				lstTreyecto = llenarDetalleTrayecto(infoUsu,rs,lstTreyecto,session);
			}
		} catch (Exception e) 
		{
			InsertarLogAlamacen.insertarLog(new LogAlmacen("","",""),infoUsu.getUname(),infoUsu.getUname_br(),"Error en Consulta facturas confirmadas. DETALLE: "+Error(e)+". Usuario: "+session.getAttribute("name").toString()+". Maquina: "+session.getAttribute("maquina").toString()+". Ip: "+session.getAttribute("ip").toString(),infoUsu.getCve_usuario());
		}
		finally 
		{
			try 
			{
				connBD.close();
				pstm.close();
			} catch (Exception e2)
			{
				InsertarLogAlamacen.insertarLog(new LogAlmacen("","",""),infoUsu.getUname(),infoUsu.getUname_br(),"Error al cerrar conexion y pstm consulta facturas credito. DETALLE: "+Error(e2)+". Usuario: "+session.getAttribute("name").toString()+". Maquina: "+session.getAttribute("maquina").toString()+". Ip: "+session.getAttribute("ip").toString(),infoUsu.getCve_usuario());
			}
		}
		
		
		session.setAttribute("lstFacturas", lstTreyecto);
		
		return lstTreyecto;
	
	}



	private List<Credito> llenarDetalleTrayecto(Usuario infoUsu, ResultSet rs, List<Credito> lstTreyecto,HttpSession session) {
		try
		{
			int n = 0;
			while (rs.next())
			{
				Credito c = new Credito();
				c.setNo(String.valueOf(n));
				c.setId_traycto(rs.getString("folio"));
				c.setNum_chofer(rs.getString("chofer"));
				c.setCliente(rs.getString("cliente"));
				c.setCondicion(rs.getString("condicion"));
				c.setEstatus(rs.getString("estatus"));
				c.setId_estatus(rs.getString("id_estatus"));
				c.setFactura(rs.getString("factura"));
				c.setUsuario_envios(rs.getString("usuario_envios"));
				c.setUsuario_corte(rs.getString("usuario_corte"));
				c.setUsuario_credito(rs.getString("usuario_credito"));
				c.setFolio_corte(rs.getString("folio_corte"));
				c.setFecha_envios(rs.getString("fecha_envios"));
				c.setFecha_credito(rs.getString("fecha_credito"));
				c.setFecha_corte(rs.getString("fecha_corte"));
				c.setOde(rs.getString("ode"));
				c.setPedido(rs.getString("pedido"));
				c.setImporte(formatearImporte(rs.getString("importe")));
				c.setImporte_cobrado(formatearImporte(rs.getString("importe_cobrado")));
				c.setRuta(rs.getString("ruta"));
				c.setUname(rs.getString("uname"));
				c.setTipo(rs.getString("tipo"));
				c.setUname_br(rs.getString("uname_br"));
				n++;
				lstTreyecto.add(c);
			}
			
		}
		catch (Exception e) 
		{
			InsertarLogAlamacen.insertarLog(new LogAlmacen("","",""),infoUsu.getUname(),infoUsu.getUname_br(),"Error al llenar pedidos para asignacion transportes. DETALLE: "+Error(e)+". Usuario: "+session.getAttribute("name").toString()+". Maquina: "+session.getAttribute("maquina").toString()+". Ip: "+session.getAttribute("ip").toString(),infoUsu.getCve_usuario());
		}
		return lstTreyecto;
	}



	private String[] InicializaQueryNumero35(String[] ListaQuerys, Usuario infoUsu, String fecha, String cdoCredito, String tipo, String fechaFin, String corte) 
	{
		String uname_br = "";
		if (cdoCredito.equals("")) 
		{
			uname_br = infoUsu.getUname_br();
		}
		else
		{
			uname_br = cdoCredito.substring(0,cdoCredito.length()-1);
		}
		
		
		if (tipo.equals("pendientes")) 
		{
			tipo = " and c.id_estatus = '2' ";
		}
		else
		{
			tipo = " ";
		}
		String fechas = " and a.fecha_asignacion_chofer BETWEEN '"+fecha+"' AND '"+fechaFin+"' ";
		if (!corte.equals("")) 
		{
			tipo = " and c.folio_corte = "+corte+" ";
			fechas = " ";
		}
		
		
		for (int i=0;i <ListaQuerys.length; i++)
		{	
			
			ListaQuerys[i]= ListaQuerys[i].replace("{FECHA_INICIO}",fecha);
			ListaQuerys[i]= ListaQuerys[i].replace("{FECHA_FIN}",fechaFin);
			ListaQuerys[i]= ListaQuerys[i].replace("{COMPLEMENTO_ESTATUS}",tipo);
			ListaQuerys[i]= ListaQuerys[i].replace("{COMPLEMENTO_FECHA}",fechas);
			ListaQuerys[i]= ListaQuerys[i].replace("{UNAME_CDO_}",infoUsu.getUname().toUpperCase());
			ListaQuerys[i]= ListaQuerys[i].replace("{UNAME_BR_}",uname_br);
		}
		return ListaQuerys;
	}



	public String actualizarCredito(HttpServletRequest request, HttpSession session, Usuario infoUsu,
			List<Querys> ListaQuerys, String facturas) 
	{
		String rsp = "";
		List<Credito> lstCredito = (List<Credito>) session.getAttribute("lstFacturas");
		String insert = "";
		if (!facturas.contains(",")) 
		{
			facturas = facturas+",";
		}
		String split [] = facturas.split(",");
		for (String s : split) 
		{
			for (Credito c : lstCredito) 
			{
				if (c.getNo().equals(s)) 
				{
					insert += "('"+c.getUname()+"','"+c.getUname_br()+"','"+c.getId_traycto()+"','"+c.getOde()+"','"+c.getPedido()+"','"+c.getFactura()+"','5','"+infoUsu.getCve_usuario()+"',CURDATE(),CURTIME()),";
				}
			}
		}
		
		
		Connection connBD = null;
		PreparedStatement pstm = null;
		connBD = ConexionBD.AbrirConexionBDD(infoUsu.getUname().toUpperCase());
		String [] querys = new String [25];
		String qry = "";
		try
		{
			querys = Cls_Querys.LimpiaListaQuerys(querys);
			querys = Cls_Querys.ObtieneQuerys(36, ListaQuerys, querys, infoUsu);
			querys = InicializaQueryNumero36(querys, infoUsu,insert.substring(0,insert.length()-1));
			for (String string : querys) 
			{
				qry = qry + string + ",";	
			}
			pstm = connBD.prepareStatement("{call " + "ALMACEN.usp_EXECUTE_QUERY(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			ResultSet rs = EjecutaQuerysBD.EjecutarQuery(querys[0], querys[1],querys[2], querys[3], querys[4], querys[5], querys[6],
					 querys[7], querys[8], querys[9],querys[10], querys[11], querys[12], querys[13], 
					 querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], 
					 querys[21], querys[22], querys[23], querys[24], infoUsu.getUname(),pstm, connBD,infoUsu);
			InsertarLogAlamacen.insertarLog(new LogAlmacen("","",""),infoUsu.getUname(),infoUsu.getUname_br(),"Actualiza facturas a confirmado credito. Qry["+Qry(seprado(querys))+"]"+". Usuario: "+session.getAttribute("name").toString()+". Maquina: "+session.getAttribute("maquina").toString()+". Ip: "+session.getAttribute("ip").toString(),infoUsu.getCve_usuario());
			rsp = "true";
		}
		catch (Exception e) 
		{
			InsertarLogAlamacen.insertarLog(new LogAlmacen("","",""),infoUsu.getUname(),infoUsu.getUname_br(),"Error actualizar facturas a confirmado por cliente. DETALLE: "+Error(e)+". Qry["+Qry(seprado(querys))+"]"+". Usuario: "+session.getAttribute("name").toString()+". Maquina: "+session.getAttribute("maquina").toString()+". Ip: "+session.getAttribute("ip").toString(),infoUsu.getCve_usuario());
		}
		finally 
		{
			try 
			{
				connBD.close();
				pstm.close();
			} catch (Exception e2)
			{
				InsertarLogAlamacen.insertarLog(new LogAlmacen("","",""),infoUsu.getUname(),infoUsu.getUname_br(),"Error al cerrar conexion y pstm consulta facturas credito. DETALLE: "+Error(e2)+". Usuario: "+session.getAttribute("name").toString()+". Maquina: "+session.getAttribute("maquina").toString()+". Ip: "+session.getAttribute("ip").toString(),infoUsu.getCve_usuario());
			}
		}
		
		return rsp;
	}



	private String[] InicializaQueryNumero36(String[] ListaQuerys, Usuario infoUsu, String insert) 
	{
		
		for (int i=0;i <ListaQuerys.length; i++)
		{	
			ListaQuerys[i]= ListaQuerys[i].replace("{UNAME_BR_}",infoUsu.getUname_br());
			ListaQuerys[i]= ListaQuerys[i].replace("{INSERT}",insert);
		}
		return ListaQuerys;
	}



	public String imprimirTicketSeparadoCorte(String folio, Usuario infoUsu, HttpSession session, List<Querys> ListaQuerys,
			Usuario infoUsu2) 
	{
		String rsp = "No se pudo generar el corte";
		Connection connBD = null;
		PreparedStatement pstm = null;
		connBD = ConexionBD.AbrirConexionBDD(infoUsu.getUname().toUpperCase());
		List<Corte> lstPedidos = new ArrayList<Corte>();
		List<Corte> lstPedidos2 = new ArrayList<Corte>();
		GenerarCorte c = new GenerarCorte();
		int aux = 0;
		try 
		{
			String [] querys = new String [25];
			querys = Cls_Querys.LimpiaListaQuerys(querys);
			querys = Cls_Querys.ObtieneQuerys(41, ListaQuerys, querys, infoUsu);
			String qry = "";
			querys = InicializaQueryNumero41(querys, infoUsu,folio);
			for (String string : querys) 
			{
				qry += string+",";
			}
			pstm = connBD.prepareStatement("{call " + "ALMACEN.usp_EXECUTE_QUERY(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			ResultSet rs = EjecutaQuerysBD.EjecutarQuery(querys[0], querys[1],querys[2], querys[3], querys[4], querys[5], querys[6],
					 querys[7], querys[8], querys[9],querys[10], querys[11], querys[12], querys[13], 
					 querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], 
					 querys[21], querys[22], querys[23], querys[24], infoUsu.getUname(),pstm, connBD,infoUsu);
			InsertarLogAlamacen.insertarLog(new LogAlmacen("","",""),infoUsu.getUname(),infoUsu.getUname_br(),"Consulta datos para generar corte reimpresion. Qry["+Qry(seprado(querys))+"]"+". Usuario: "+session.getAttribute("name").toString()+". Maquina: "+session.getAttribute("maquina").toString()+". Ip: "+session.getAttribute("ip").toString(),infoUsu.getCve_usuario());
			if (rs != null) 
			{
				lstPedidos = llenarCorte(rs,infoUsu,lstPedidos,session);
			}
			if (lstPedidos.size()>0)
			{
				
				aux++;
			}
			
			querys = Cls_Querys.LimpiaListaQuerys(querys);
			querys = Cls_Querys.ObtieneQuerys(42, ListaQuerys, querys, infoUsu);
			querys = InicializaQueryNumero41(querys, infoUsu,folio);
			qry = "";
			for (String string : querys) 
			{
				qry += string+",";
			}
			pstm = connBD.prepareStatement("{call " + "ALMACEN.usp_EXECUTE_QUERY(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			 rs = EjecutaQuerysBD.EjecutarQuery(querys[0], querys[1],querys[2], querys[3], querys[4], querys[5], querys[6],
					 querys[7], querys[8], querys[9],querys[10], querys[11], querys[12], querys[13], 
					 querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], 
					 querys[21], querys[22], querys[23], querys[24], infoUsu.getUname(),pstm, connBD,infoUsu);
			InsertarLogAlamacen.insertarLog(new LogAlmacen("","",""),infoUsu.getUname(),infoUsu.getUname_br(),"Consulta datos para generar corte reimpresion. Qry["+Qry(seprado(querys))+"]"+". Usuario: "+session.getAttribute("name").toString()+". Maquina: "+session.getAttribute("maquina").toString()+". Ip: "+session.getAttribute("ip").toString(),infoUsu.getCve_usuario());
			
			if (rs != null) 
			{
				lstPedidos2 = llenarCorte2(rs,infoUsu,lstPedidos2,session);
			}
			if (lstPedidos2.size()>0)
			{
				
				aux++;
			}
			
			rsp = c.crearArchivoTxtDelTicket(lstPedidos,infoUsu,session.getAttribute("impresora").toString(),"","0",folio,session);
			rsp = c.crearArchivoTxtDelTicket(lstPedidos2,infoUsu,session.getAttribute("impresora").toString(),"","1",folio,session);
		
			
		} 
		catch (Exception e) 
		{
			InsertarLogAlamacen.insertarLog(new LogAlmacen("","",""),infoUsu.getUname(),infoUsu.getUname_br(),"Error en consulta para generar corte reimpresion. DETALLE: "+Error(e)+". Usuario: "+session.getAttribute("name").toString()+". Maquina: "+session.getAttribute("maquina").toString()+". Ip: "+session.getAttribute("ip").toString(),infoUsu.getCve_usuario());
		}
		finally 
		{
			try 
			{
				connBD.close();
				pstm.close();
			} catch (Exception e2)
			{
				InsertarLogAlamacen.insertarLog(new LogAlmacen("","",""),infoUsu.getUname(),infoUsu.getUname_br(),"Error al cerrar conexion y pstm corte reimpresion. DETALLE: "+Error(e2)+". Usuario: "+session.getAttribute("name").toString()+". Maquina: "+session.getAttribute("maquina").toString()+". Ip: "+session.getAttribute("ip").toString(),infoUsu.getCve_usuario());
			}
		}
		
		
		if (aux == 0) 
		{
			rsp = "No hay informacion con el folio: "+folio;
		}		
		
		return rsp;
	}



	private String[] InicializaQueryNumero41(String[] ListaQuerys, Usuario infoUsu, String folio) {
		
		for (int i=0;i <ListaQuerys.length; i++)
		{	
			ListaQuerys[i]= ListaQuerys[i].replace("{UNAME_BR_}",infoUsu.getUname_br());
			ListaQuerys[i]= ListaQuerys[i].replace("{UNAME_CDO_}",infoUsu.getUname().toUpperCase());
			ListaQuerys[i]= ListaQuerys[i].replace("{FOLIO}",folio);
		}
		return ListaQuerys;
	}



	public String cancelarTrayecto(HttpServletRequest request, HttpSession session, String trayecto, Usuario infoUsu,List<Querys> ListaQuerys, String uname_br, String tipo, List<String> lstConsultarTipoCP) 
	{
		String rsp = "Error al cancelar el trayecto: "+trayecto;
		Connection connBD = null;
		PreparedStatement pstm = null;
		connBD = ConexionBD.AbrirConexionBDD(infoUsu.getUname().toUpperCase());
		ResultSet rs = null;
		try
		{
			//System.out.println("tipo: "+tipo);
			String [] querys = new String [25];
			querys = Cls_Querys.LimpiaListaQuerys(querys);
			querys = Cls_Querys.ObtieneQuerys(50, ListaQuerys, querys, infoUsu);
			querys = InicializaQueryNumero50(querys, infoUsu,trayecto,uname_br);
			pstm = connBD.prepareStatement("{call " + "ALMACEN.usp_EXECUTE_QUERY(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			 rs = EjecutaQuerysBD.EjecutarQuery(querys[0], querys[1],querys[2], querys[3], querys[4], querys[5], querys[6],
					 querys[7], querys[8], querys[9],querys[10], querys[11], querys[12], querys[13], 
					 querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], 
					 querys[21], querys[22], querys[23], querys[24], infoUsu.getUname(),pstm, connBD,infoUsu);
			Cls_Querys.ImprimeQuerysConsola(querys, false, "Query 50");
			String qry = "";
			for (String string : querys) 
			{
				qry = qry +string+",";
			}
			InsertarLogAlamacen.insertarLog(new LogAlmacen("","",""),infoUsu.getUname(),infoUsu.getUname_br(),"Cancela trayecto: "+trayecto+". Qry[ \n "+Qry(seprado(querys))+" \n]"+". Usuario: "+session.getAttribute("name").toString()+". Maquina: "+session.getAttribute("maquina").toString()+". Ip: "+session.getAttribute("ip").toString(),infoUsu.getCve_usuario());
			rsp = "Trayecto: "+trayecto+" cancelado correctamente";
			try {
				//System.out.println("0: "+lstConsultarTipoCP.get(0) +" 3: " + lstConsultarTipoCP.get(2));
				if(tipo.equals(lstConsultarTipoCP.get(0)) || tipo.equals(lstConsultarTipoCP.get(2))) {
					querys = Cls_Querys.ObtieneQuerys(74, ListaQuerys, querys, infoUsu);
					querys = InicializaQueryNumero50(querys, infoUsu,trayecto,uname_br);
					pstm = connBD.prepareStatement("{call " + "ALMACEN.usp_EXECUTE_QUERY(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
					 rs = EjecutaQuerysBD.EjecutarQuery(querys[0], querys[1],querys[2], querys[3], querys[4], querys[5], querys[6],
							 querys[7], querys[8], querys[9],querys[10], querys[11], querys[12], querys[13], 
							 querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], 
							 querys[21], querys[22], querys[23], querys[24], infoUsu.getUname(),pstm, connBD,infoUsu);
					 Cls_Querys.ImprimeQuerysConsola(querys, false, "Query 74");
					 //System.out.println("rs: "+rs);
				}
			}catch(Exception e) {
				System.out.println("Error en la actualizacion de query 74.");
			}
		}
		catch (Exception e)
		{
			InsertarLogAlamacen.insertarLog(new LogAlmacen("","",""),infoUsu.getUname(),infoUsu.getUname_br(),"Error en metodo de cancelacion trayecto. DETALLE: "+Error(e)+". Usuario: "+session.getAttribute("name").toString()+". Maquina: "+session.getAttribute("maquina").toString()+". Ip: "+session.getAttribute("ip").toString(),infoUsu.getCve_usuario());
		}
		finally 
		{
			try 
			{
				pstm.close();
				connBD.close();
			} catch (Exception e2)
			{
				InsertarLogAlamacen.insertarLog(new LogAlmacen("","",""),infoUsu.getUname(),infoUsu.getUname_br(),"Error al cerrar conexion y pstm cancelacion trayecto. DETALLE: "+Error(e2)+". Usuario: "+session.getAttribute("name").toString()+". Maquina: "+session.getAttribute("maquina").toString()+". Ip: "+session.getAttribute("ip").toString(),infoUsu.getCve_usuario());
			}
		}
		
		return rsp;
	}

	
	public List<PedidosConsultaRC> consultaFacturasDetalleRC(Usuario infoUsu, String pedidosRC, String cdoDestino, List<Querys> ListaQuerys){
		List<PedidosConsultaRC> lstFacturasDetalle = new ArrayList<>();
		Connection connBD = null;
		PreparedStatement pstm = null;
		connBD = ConexionBD.AbrirConexionBDD(infoUsu.getUname().toUpperCase());
		ResultSet rs = null;
		try
		{
			String [] querys = new String [25];
			querys = Cls_Querys.LimpiaListaQuerys(querys);
			querys = Cls_Querys.ObtieneQuerys(77, ListaQuerys, querys, infoUsu);
			String qry = "";
			querys = InicializaQueryNumero77(querys, infoUsu,pedidosRC);
			pstm = connBD.prepareStatement("{call " + infoUsu.getUname().toUpperCase()+".usp_EXECUTE_QUERY(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			rs = EjecutaQuerysBD.EjecutarQuery(querys[0], querys[1],querys[2], querys[3], querys[4], querys[5], querys[6],
				 querys[7], querys[8], querys[9],querys[10], querys[11], querys[12], querys[13], 
				 querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], 
				 querys[21], querys[22], querys[23], querys[24], infoUsu.getUname(),pstm, connBD,infoUsu);
			Cls_Querys.ImprimeQuerysConsola(querys, false, "Query 77");
			
			if(rs != null) {
				lstFacturasDetalle = llenadoFacturasDetalleRC(rs,infoUsu,cdoDestino);
			}
			
		}catch (Exception e) {
			System.out.println("Error al consultar las GestorPedidos.FacturasDetalleRC: " + e.toString());
 		}finally {
 			try{
 				if(pstm != null) { pstm.close();}
 				if(connBD != null) {connBD.close();} 
 			}catch (Exception e) {
 				System.out.println("Error al cerrar conexion en GestorPedidos.consultaFacturasDetalleRC: " + e.toString()); 
			}
 		}
		
		return lstFacturasDetalle;		
	}
	
	private List<PedidosConsultaRC> llenadoFacturasDetalleRC(ResultSet rs, Usuario infoUsu, String cdoDestino){
		 List<PedidosConsultaRC> lstFacturasDetalle = new ArrayList<>();
		 try {
			 while(rs.next()) {
				 PedidosConsultaRC facDetRc = new PedidosConsultaRC();
				 facDetRc.setFacturaTraslado(rs.getString("factura_traslado"));
				 facDetRc.setClaveProdServ(rs.getString("c_ClaveProdServ"));
				 facDetRc.setNoIdentificacion(rs.getString("noidentificacion"));
				 facDetRc.setDescUnidad(rs.getString("desc_unidad"));
				 facDetRc.setPeso(rs.getString("peso"));
				 facDetRc.setClvMaterialPeligroso(rs.getString("cp_ClaveMaterialPeligroso"));
				 facDetRc.setCantidad(rs.getString("cantidad"));
				 facDetRc.setClaveUnidad(rs.getString("c_ClaveUnidad"));
				 facDetRc.setNumeroCaja(rs.getString("numero_caja"));
				 facDetRc.setUname(cdoDestino);
				 
				 lstFacturasDetalle.add(facDetRc); 
			 }
		 }catch (Exception e) {
			 System.out.println("Error en GestorPedidos.llenadoFacturasDetalleRC: "+e.toString());
		}
		 return lstFacturasDetalle;
	}
	
	public List<PedidosConsultaRC> consultaFacturasEncabezadoRC(Usuario infoUsu, String pedidosRC, String placa, String chofer, String cdoDestino, List<Querys> ListaQuerys){
		List<PedidosConsultaRC> lstFacturasEncabezado = new ArrayList<>();
		Connection connBD = null;
		PreparedStatement pstm = null;
		connBD = ConexionBD.AbrirConexionBDD(infoUsu.getUname().toUpperCase());
		ResultSet rs = null;
		try
		{
			String [] querys = new String [25];
			querys = Cls_Querys.LimpiaListaQuerys(querys);
			querys = Cls_Querys.ObtieneQuerys(78, ListaQuerys, querys, infoUsu);
			String qry = "";
			querys = InicializaQueryNumero77(querys, infoUsu,pedidosRC);
			pstm = connBD.prepareStatement("{call " + infoUsu.getUname().toUpperCase()+".usp_EXECUTE_QUERY(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			rs = EjecutaQuerysBD.EjecutarQuery(querys[0], querys[1],querys[2], querys[3], querys[4], querys[5], querys[6],
				 querys[7], querys[8], querys[9],querys[10], querys[11], querys[12], querys[13], 
				 querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], 
				 querys[21], querys[22], querys[23], querys[24], infoUsu.getUname(),pstm, connBD,infoUsu);
			Cls_Querys.ImprimeQuerysConsola(querys, false, "Query 78");
			
			if(rs != null) {
				lstFacturasEncabezado = llenadoFacturasEncabezadoRC(rs,placa,chofer,cdoDestino);
			}
			
		}catch (Exception e) {
			System.out.println("Error al consultar las GestorPedidos.consultaFacturasEncabezadoRC: " + e.toString());
 		}finally {
			try {
				if(pstm != null) {pstm.close();}
				if(connBD != null) {connBD.close();}
			}catch(Exception e) {
				System.out.println("Error al cerrar la conexion en GesotrPedidos.consultaFacturasEncabezadoRC: " + e.toString());
			}
		}
		
		return lstFacturasEncabezado;			
	}
	
	private List<PedidosConsultaRC> llenadoFacturasEncabezadoRC(ResultSet rs, String placa, String chofer, String cdoDestino){
		List<PedidosConsultaRC> lstFacturasEncabezado = new ArrayList<>();
		try {
			while(rs.next()) {
				PedidosConsultaRC facEncRc = new PedidosConsultaRC();
				facEncRc.setUnameOrigen(rs.getString("uname_origen"));
				facEncRc.setUnameDestino(rs.getString("uname_destino"));
				facEncRc.setFacturaTraslado(rs.getString("factura_traslado"));
				facEncRc.setUname(cdoDestino);
				facEncRc.setTotalArticulos(rs.getString("total_articulos"));
				facEncRc.setTotalMaterialPeligroso(rs.getString("total_material_peligroso"));
				facEncRc.setRemision(rs.getString("remision"));
				facEncRc.setTipo(rs.getString("tipo"));
				facEncRc.setChofer(chofer);
				facEncRc.setPlacasVehiculo(placa);
				
				lstFacturasEncabezado.add(facEncRc);				
			}
		}catch (Exception e) {
			System.out.println("Error en GestorPedidos.llenadoFacturasEncabezadoRC: "+e.toString());
		}
		return lstFacturasEncabezado;
	}
	
	
	public String enviaTraspasoDetalleRC(List<PedidosConsultaRC> lstFacturasDetalle, int i) {
		String Parametros = "";
		String respuestaJson = "";
		CloseableHttpClient httpClient = HttpClientBuilder.create().build();
		try {
			JSONArray obj = new JSONArray();
			JSONObject object = new JSONObject();
//			{"factura":"cdfat00001111", "claveProd":"25172900", "articulo":"LP-3825",  "descrUnidad":"Motocicleta", "peso":"0.5",  "claveMaterialPeligroso":"0", "cantidad":"2", "claveUnidad":"H87", "numeroCaja":"3",        "cdo":"cdf"}
//			{"factura":"IRPAT.0004",    "claveProd":"25172900", "articulo":"LP-382507","descrUnidad":"PLAYERA",     "peso":"0.5",  "claveMaterialPeligroso":"0", "cantidad":"2", "claveUnidad":"H87", "numeroCaja":"PLAYO-55", "cdo":"cdf"}
			//System.out.println("Longitus de la lista de DETALLE: " + lstFacturasDetalle.size());
			
				object.put("factura", lstFacturasDetalle.get(i).getFacturaTraslado());
				object.put("claveProd", lstFacturasDetalle.get(i).getClaveProdServ());
				object.put("articulo", lstFacturasDetalle.get(i).getNoIdentificacion());
				object.put("descrUnidad", lstFacturasDetalle.get(i).getDescUnidad());
				object.put("peso", lstFacturasDetalle.get(i).getPeso());
				object.put("claveMaterialPeligroso", lstFacturasDetalle.get(i).getClvMaterialPeligroso());
				object.put("cantidad", lstFacturasDetalle.get(i).getCantidad());
				object.put("claveUnidad", lstFacturasDetalle.get(i).getClaveUnidad());
				object.put("numeroCaja", lstFacturasDetalle.get(i).getNumeroCaja());
				object.put("cdo", lstFacturasDetalle.get(i).getUname());
				obj.put(object);
				//System.out.println("DETALLE_RC object a enviar: " + obj);
				
				HttpPost request = new HttpPost(URL_INSERTA_DETALLE_RC); 
				StringEntity params = new StringEntity(obj.toString()); 
				request.addHeader("content-type", "application/json"); 
				request.setEntity(params); 
				httpClient.execute(request);
				respuestaJson = "S";
					
			
//			 Response cadUsisario = this.cliente.target(URL_INSERTA_DETALLE_RC + Parametros)
//						.request(MediaType.APPLICATION_JSON).post(Entity.json(object.toString()));
//
//			 respuestaJson = cadUsisario.readEntity(String.class);
//			 System.out.println("DETALLE_RC respuestaJson : " + respuestaJson);
		} catch (Exception ex) {
			System.out.println("GestorPedidos.enviaTraspasoDetalleRC .- Error al enviar JSON Detalle_RC: " + ex.toString()); 
			try {
				throw ex;
			}catch(Exception e) {
				System.out.println("GestorPedidos.enviaTraspasoDetalleRC .- Error al enviar JSON Detalle_RC: " + e.getMessage()); 
			}
		}finally {
			try {
				httpClient.close();
			}catch (Exception e) {
				System.out.println("GestorPedidos.enviaTraspasoDetalleRC.- Error al cerrar el httpClient: " + e.toString()); 
			}
		}
		 return respuestaJson;	
	}
	
	public String enviaTraspasoEncabezadoRC(List<PedidosConsultaRC> lstFacturasEncabezado) {
		String Parametros = "";
		String respuestaJson = "";
		CloseableHttpClient httpClient = HttpClientBuilder.create().build();
		try {
			JSONObject object = new JSONObject();
//			{"unameOrigen":"irp", "unameDestino":"cel", "factura":"IRPAT.2568", "cdo":"cdl", "totalArticulos":"1", "totalMatePeligroso":"0", "remision":"1124",  "tipo":"R",  "chofer":"14463", "placasVehiculo":"GS5869B"}
//			{"unameOrigen":"irp", "unameDestino":"cel", "factura":"IRPAT.0004", "cdo":"cdf", "totalArticulos":"1", "totalMatePeligroso":"0", "remision":"111114","tipo":"R",  "chofer":"14463", "placasVehiculo":"GS5869B"}
//			{"tipo":"A","factura":"AVHAT-25","unameOrigen":"cpr","chofer":"8067","totalArticulos":"1","unameDestino":"tor","remision":"11094605","cdo":"cd2","totalMatePeligroso":"0","placasVehiculo":"2291-CL"}
			
			//System.out.println("Longitud de la lista de ENCABEZADO: "+lstFacturasEncabezado.size());
			
			for(int i=0; i<lstFacturasEncabezado.size();i++) {
				object.put("unameOrigen", lstFacturasEncabezado.get(i).getUnameOrigen());
				object.put("unameDestino", lstFacturasEncabezado.get(i).getUnameDestino());
				object.put("factura", lstFacturasEncabezado.get(i).getFacturaTraslado());
				object.put("cdo", lstFacturasEncabezado.get(i).getUname());
				object.put("totalArticulos", lstFacturasEncabezado.get(i).getTotalArticulos());
				object.put("totalMatePeligroso", lstFacturasEncabezado.get(i).getTotalMaterialPeligroso().toString());
				object.put("remision", lstFacturasEncabezado.get(i).getRemision());
				object.put("tipo", lstFacturasEncabezado.get(i).getTipo());
				object.put("chofer", lstFacturasEncabezado.get(i).getChofer());
				object.put("placasVehiculo", lstFacturasEncabezado.get(i).getPlacasVehiculo());				
				
//				object.put("cve_centro", Integer.toString(centro));
//				object.put("cliente", Integer.toString(cliente));
//				object.put("mensajes", "[" + mensajes.replace("-", ",") + "]" );
//				object.put("estatus", Integer.toString(estatus));
				
				//System.out.println("ENCABEZADO_RC object a enviar: " + object);
								
				HttpPost request = new HttpPost(URL_INSERTA_ENCABEZADO_RC); 
				StringEntity params = new StringEntity(object.toString()); 
				request.addHeader("content-type", "application/json"); 
				request.setEntity(params); 
				httpClient.execute(request);
				respuestaJson = "S";
			}
						
//			 System.out.println("ENCABEZADO_RC object a enviar: " + object); 
//			 System.out.println("URL ENCABEZADO: "+URL_INSERTA_ENCABEZADO_RC); 
//			 Response cadUsisario = this.cliente.target(URL_INSERTA_ENCABEZADO_RC)
//						.request(MediaType.APPLICATION_JSON).post(Entity.json(object));
//			 System.out.println("..........1");
//			 respuestaJson = cadUsisario.readEntity(String.class);
//			 System.out.println("ENCABEZADO_RC respuestaJson : " + respuestaJson);
		} catch (Exception ex) {
			System.out.println("GestorPedidos.enviaTraspasoEncabezadoRC .- Error al enviar JSON Encabezado_RC: " + ex);
			System.out.println("GestorPedidos.enviaTraspasoEncabezadoRC .- Error al enviar JSON Encabezado_RC: " + ex.getMessage());
			try {
				throw ex;
			}catch (Exception e) {
				System.out.println("Error en enviaTraspasoEncabezadoRC: " + e);
			}			 
		}finally {
			try {
				httpClient.close();
			}catch (Exception e) {
				System.out.println("GestorPedidos.enviaTraspasoEncabezadoRC.- Error al cerrar el httpClient: " + e.toString()); 
			}
		}
		return respuestaJson;		
	}
	
//	public String actualizaMensajes(int centro, int cliente, String mensajes, int estatus)
//	{
//		String Parametros = "";
//		String respuestaJson = "";
//
//		try {
//			JSONObject object = new JSONObject();
//			// {"cve_centro":"7","cliente":"47201","mensajes":"[1,2,10,14]","estatus":"2"}
//			object.put("cve_centro", Integer.toString(centro));
//			object.put("cliente", Integer.toString(cliente));
//			object.put("mensajes", "[" + mensajes.replace("-", ",") + "]" );
//			object.put("estatus", Integer.toString(estatus));
//			
//			 // System.out.println("object a enviar: " + object);
//			
//			 Response cadUsisario = this.cliente.target(properties.getProperty("URL_ACTUALIZA_MENSAJES_WWW") + Parametros)
//						.request(MediaType.APPLICATION_JSON).post(Entity.json(object.toString()));
//
//			 respuestaJson = cadUsisario.readEntity(String.class);
//			// System.out.println("respuestaJson : " + respuestaJson);
//		} catch (Exception ex) {
//			throw ex;
//			 
//			}
//		 return respuestaJson;
//	}
	
	private String[] InicializaQueryNumero77(String[] ListaQuerys, Usuario infoUsu, String pedidosRC)
	{
		for (int i=0;i <ListaQuerys.length; i++)
		{	
			ListaQuerys[i]= ListaQuerys[i].replace("{FACTURAS}",pedidosRC);
		}
		return ListaQuerys;
	}

	private String[] InicializaQueryNumero50(String[] ListaQuerys, Usuario infoUsu, String trayecto, String uname_br)
	{
		for (int i=0;i <ListaQuerys.length; i++)
		{	
			ListaQuerys[i]= ListaQuerys[i].replace("{UNAME_BR_}",uname_br);
			ListaQuerys[i]= ListaQuerys[i].replace("{TRAYECTO}",trayecto);
		}
		return ListaQuerys;
	}

	
	
	
	
	
}
