package cdo.Persistencia;

import java.io.BufferedReader;
import java.io.FileReader;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.naming.spi.DirStateFactory.Result;


import com.mysql.jdbc.Statement;

import cdo.Datos.Catalogos_Listas;
import cdo.Datos.Cdos;
import cdo.Datos.Impresoras;
import cdo.Datos.Log;
import cdo.Datos.Catalogo_Estatus;
import cdo.Datos.Catalogo_EstatusLineaBancaria;
import cdo.Datos.CatalogoEstatusChequesNominativos;
import cdo.Datos.Catalogo_Agentes;
import cdo.Datos.Catalogo_Bancos;
import cdo.Datos.Catalogo_Formas_Pago;
import cdo.Datos.Catalogo_Motivos_Cancelacion;
import cdo.Datos.Catalogo_Otros_Ingresos;
import cdo.Datos.Catalogo_TiposLineaBancaria;
import cdo.Datos.Catalogo_Usuarios_Credito;
import cdo.Datos.Usuario;
import cdo.Datos.Querys;
import cdo.util.Cls_Log;
import cdo.util.Cls_Querys;
import cdo.util.ConexionBD;
import cdo.util.EjecutaQuerysBD;

public class GestorDatosUsuario 
{

	public GestorDatosUsuario()
	{
	}
		
	/*** Obtiene Centro de archivo de configuracion ***/
	public static Map<String,String> ObtieneCentros(String ArchivoConfiguracion)
	{
		Map<String, String> mapaCdos= new TreeMap<>();
		
		try
		{
			FileReader fr= new FileReader(ArchivoConfiguracion);
			BufferedReader br=new BufferedReader(fr);
			String linea="";
			
			mapaCdos.put("cdf", "CDMX");
			mapaCdos.put("cd2", "PUEBLA");
			mapaCdos.put("cdl", "LEON");
			mapaCdos.put("cdm", "MONTERREY");
			
		}
		catch(Exception ex)
		{
			System.out.println("Error al obtener centros.");
		}
		return mapaCdos;
	}
	
	/*** Obtiene la lista de querys del proceso 68 (Caja Administrativa) ***/
	public static List<Querys> ConsultaTablaQuerysBD(String cdo)
	{
		Connection connBD = null;
		PreparedStatement pstmt =null;
		ResultSet rs=null;
		List<Querys> querys= new ArrayList<>();
		try
		{
			String qry = ObtieneQuery(2, "", "", cdo);
			connBD = ConexionBD.AbrirConexionBD(cdo);
			pstmt = connBD.prepareStatement(qry);
			rs = pstmt.executeQuery();
						
			if (rs != null)
	        {
		        while (rs.next())
		        {
		        	Querys query= new Querys();
		        	query.setProceso(rs.getInt("proceso"));
		        	query.setIndice_query(rs.getInt("indice_query"));
		        	query.setSub_indice_query(rs.getInt("sub_indice_query"));
		        	query.setDescripcion(rs.getString("descripcion"));
		        	query.setQuery(rs.getString("query"));	  
	        		querys.add(query);
		        }
	        }
			
		}
		catch(Exception ex)
		{
			System.out.println("Error al consultar tabla de Querys: " + ex.getMessage().toString());
		}
		finally 
		{
			try {pstmt.close();} catch (SQLException e) {e.printStackTrace();}
			try {connBD.close();} catch (SQLException e) {e.printStackTrace();}
		}
		return querys;
	}
		
	/*** Valida y Obtiene informacion del usuario de la BD ***/
	public static Usuario consultaInformacionDeUsuarioBD(String usuario, String password, String cdo)
	{
		Usuario infoUsuario = new Usuario();
		Connection connBD = null;
		PreparedStatement pstmt =null;
		ResultSet rs=null;
		
		try 
		{
			String qry = ObtieneQuery(1, usuario, password,cdo);
			connBD = ConexionBD.AbrirConexionBD(cdo);
			pstmt = connBD.prepareStatement(qry);
			rs = pstmt.executeQuery();
			 
			if(rs != null)
			{
				if(rs.next())
				{
					if(rs.getString("cve_usu") != "")
					{
						infoUsuario.setCve_usuario(rs.getString("cve_usu"));
						infoUsuario.setNombre(rs.getString("nombre"));
						infoUsuario.setCve_departamento(rs.getInt("depto"));
						infoUsuario.setDepartamento(rs.getString("nombre_depto"));
						infoUsuario.setNivel_usuario(rs.getInt("nivel_usuario"));
						infoUsuario.setDato_numerico(rs.getInt("dato_numerico1"));
						infoUsuario.setDato_alfanumerico(rs.getString("dato_alfanumerico1"));
						infoUsuario.setUname(rs.getString("cdo_macro"));
						infoUsuario.setUname_nombre(rs.getString("cdo_macro_nombre").toUpperCase());	
						String uname_br = (rs.getString("cdo_br").toString().equals("")) ? rs.getString("cdo_macro") : rs.getString("cdo_br");						
						infoUsuario.setUname_br(uname_br);
						String nombre_uname_br = (rs.getString("cdo_br").toString().equals("")) ? rs.getString("cdo_macro_nombre") : rs.getString("cdo_br_nombre");	
						infoUsuario.setUname_br_nombre(nombre_uname_br.toUpperCase());
					}
				}
			}
		}
		catch(Exception ex)
		{
			System.out.println("Error al consultar Usuario. Detalle:" + ex.getMessage().toString());
		}
		finally 
		{
			try {pstmt.close();} catch (SQLException e) {e.printStackTrace();}
			try {connBD.close();} catch (SQLException e) {e.printStackTrace();}
		}
		
		return infoUsuario;
	}
		
		/*** Genera la sintaxis de los querys iniciales ***/ 
	public static String ObtieneQuery( int numQuery, String usuario, String password, String cdo)
	{
		String qry="";
		switch(numQuery)
		{
			case 1:
				qry=	"SELECT 	A.cve_usu,  "+
									"A.nombre,   "+
									"A.depto,   "+
									"B.nombre_depto,  "+
									"C.nivel_usuario,  "+
									"C.dato_numerico1,  "+
									"C.dato_alfanumerico1,  "+
									"D.uname AS cdo_macro,  "+
									"D.nombre_corto AS cdo_macro_nombre,   "+
									"IFNULL(E.uname, '') AS cdo_br,  "+
									"E.nombre_corto AS  cdo_br_nombre  "+
						"FROM 		" + cdo.toUpperCase() +".USUARIOS AS A  "+
									"INNER JOIN " + cdo.toUpperCase() +".DEPARTAMENTOS AS B ON A.depto = B.departamento   "+
									"INNER JOIN " + cdo.toUpperCase() +".USU_PROC_WEB AS C ON  A.cve_usu = C.cve_usu    "+
									"INNER JOIN CECOM.UNAME AS D ON D.uname= '" + cdo.toLowerCase() + "'" +
									"LEFT  JOIN CECOM.UNAME AS E ON E.num_cte = A.num_cli_bod   "+
					    "WHERE  	 A.cve_usu = '"+ usuario.toUpperCase() +"'  AND password= '" + password + "' AND C.proc_web= '68'";
			break;
				
			case 2:
				qry=  "SELECT 		DISTINCT proc_web AS proceso, "+
									"indice_query, "+
									"sub_indice_query, "+
									"descripcion, "+
									"estructura AS query "+
						"  FROM 	"+cdo.toUpperCase()+ ".QUERYS where proc_web = '68' " +
						"  ORDER BY indice_query ASC, " +
									"sub_indice_query ASC;";
				break;
		}
		return qry;
	}
		
	/******* Consulta informacion inicial para al menu del sistema *******/		
	public Catalogos_Listas ObtieneInfoInicialDelSistema(List<Querys> ListaQuerys, Usuario infoUsu)
	{
		Catalogos_Listas listas=new Catalogos_Listas();
		Connection connBD = null;
		PreparedStatement pstm= null;		
		ResultSet rs=null;
		connBD = ConexionBD.AbrirConexionBD(infoUsu.getUname());
		try
		{
			String[] querys = new String[25];	
			querys = Cls_Querys.LimpiaListaQuerys(querys);	
			querys = Cls_Querys.ObtieneQuerys(1, ListaQuerys, querys, infoUsu);			
			pstm = connBD.prepareStatement("{call " + "CTRL_INGRESOS.usp_EXECUTE_QUERY(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			rs=  EjecutaQuerysBD.EjecutarQuery(querys[0], querys[1],querys[2], querys[3], querys[4], querys[5], querys[6],
														 querys[7], querys[8], querys[9],querys[10], querys[11], querys[12], querys[13], 
														 querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], 
														 querys[21], querys[22], querys[23], querys[24], infoUsu.getUname(),pstm, connBD);	
			
			querys = Cls_Querys.ObtieneQuerys(92, ListaQuerys, querys, infoUsu);			
			pstm = connBD.prepareStatement("{call " + "CTRL_INGRESOS.usp_EXECUTE_QUERY(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			ResultSet rs2=  EjecutaQuerysBD.EjecutarQuery(querys[0], querys[1],querys[2], querys[3], querys[4], querys[5], querys[6],
														 querys[7], querys[8], querys[9],querys[10], querys[11], querys[12], querys[13], 
														 querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], 
														 querys[21], querys[22], querys[23], querys[24], infoUsu.getUname(),pstm, connBD);
			if (rs != null)
			 {
				 listas.setListaFormas_Pago(ObtieneCatalogoFormasDePago(rs));
				 listas.setListaOtrosIngresos(ObtieneCatalogoOtrosIngresos(rs));
				 listas.setListaBancos(ObtieneCatalogBancos(rs));
				 listas.setListaMotivosCancelacion(ObtieneMotivosCancelacion(rs));
				 listas.setListaUsuariosCredito(ObtieneCatalogoUsuariosCredito(rs));
				 listas.setListaCdos(ObtieneCdosBD(rs));
				 listas.setListaEstatus(ObtieneEstatusDisponibles(rs));
				 listas.setListaImpresoras(ObtieneImpresorasBD(rs));
				 listas.setListaEstatusLinea(ObtieneCatalogoEstatusLineaBancaria(rs));
				 listas.setListaTiposLinea(ObtieneCatalogoTiposLineaBancaria(rs));
				 listas.setListaAgentes(obtieneCatalogoDeAgentes(rs));
				 listas.setListaEstatusNominativo(ObtieneCatalogoEstatusNominativos(rs2));
			 }
		}
		catch(Exception ex)
		{
			System.out.println("Error al obtener catalogo de otros ingresos. Detalle: " + ex.getMessage().toString());
		}
		finally
		{
			try {pstm.close();} catch (SQLException e) {e.printStackTrace();}
			try {connBD.close();} catch (SQLException e) {e.printStackTrace();}
		}
		return listas;
	}
	
	private List<CatalogoEstatusChequesNominativos> ObtieneCatalogoEstatusNominativos(ResultSet rs)
	{
		List<CatalogoEstatusChequesNominativos> listaEstatusNominativos = new ArrayList<>();	
		try
		{
			rs.beforeFirst();
	        while (rs.next())
	        {	 
        		CatalogoEstatusChequesNominativos estatusNom= new CatalogoEstatusChequesNominativos();
        		estatusNom.setId_estatus(rs.getInt("id_estatus"));
        		estatusNom.setNombre_estatus(rs.getString("descripcion"));
        		listaEstatusNominativos.add(estatusNom);
	        }
		}
		catch(Exception ex)
		{
			System.out.println("Error al obtener catalogo de estatus de Cheque Nominativo. Detalle: " + ex.getMessage().toString());
		}
		return listaEstatusNominativos;
	}
		
	private List<Catalogo_Agentes> obtieneCatalogoDeAgentes(ResultSet rs)
	{
		List<Catalogo_Agentes> listaCatalogoAgentes = new ArrayList<>();	
		try
		{
			rs.beforeFirst();
	        while (rs.next())
	        {	        
	        	if(rs.getString("agentes").equals("*"))
	        	{
	        		Catalogo_Agentes agente = new Catalogo_Agentes();
	        		agente.setNum_agente(rs.getString("num_agente"));
	        		agente.setNombre_agente(rs.getString("nombre_agente"));
	        		listaCatalogoAgentes.add(agente);
	        	}
	        }
		}
		catch(Exception ex)
		{
			System.out.println("Error al obtener catalogo de agentes. Detalle: " + ex.getMessage().toString());
		}
		return listaCatalogoAgentes;
	}
	
	private List<Catalogo_TiposLineaBancaria> ObtieneCatalogoTiposLineaBancaria(ResultSet rs)
	{
		List<Catalogo_TiposLineaBancaria> listaTiposLineaBancaria = new ArrayList<>();	
		try
		{
			rs.beforeFirst();
	        while (rs.next())
	        {	        
	        	if(rs.getString("cat_tipo_linea").equals("*"))
	        	{
	        		Catalogo_TiposLineaBancaria tiposLinea= new Catalogo_TiposLineaBancaria();
	        		tiposLinea.setId_tipo_linea(rs.getInt("id_tipo_linea"));
	        		tiposLinea.setNombre_tipo_linea(rs.getString("decripcion_tipo_linea"));
	        		tiposLinea.setArea_tipo_linea(rs.getInt("area_tipo_linea"));
	        		listaTiposLineaBancaria.add(tiposLinea);
	        	}
	        }
		}
		catch(Exception ex)
		{
			System.out.println("Error al obtener catalogo de tipos de Linea Bancaria. Detalle: " + ex.getMessage().toString());
		}
		return listaTiposLineaBancaria;
	}
	
	private List<Catalogo_EstatusLineaBancaria> ObtieneCatalogoEstatusLineaBancaria(ResultSet rs)
	{
		List<Catalogo_EstatusLineaBancaria> listaEstatusLineaBancaria = new ArrayList<>();	
		try
		{
			rs.beforeFirst();
	        while (rs.next())
	        {	        
	        	if(rs.getString("cat_estatus_linea").equals("*"))
	        	{
	        		Catalogo_EstatusLineaBancaria estatusLinea= new Catalogo_EstatusLineaBancaria();
	        		estatusLinea.setId_estatus(rs.getInt("id_estatus_linea"));
	        		estatusLinea.setNombre_estatus(rs.getString("decripcion_tipo_linea"));
	        		listaEstatusLineaBancaria.add(estatusLinea);
	        	}
	        }
		}
		catch(Exception ex)
		{
			System.out.println("Error al obtener catalogo de estatus de Linea Bancaria. Detalle: " + ex.getMessage().toString());
		}
		return listaEstatusLineaBancaria;
	}
	
	private List<Catalogo_Usuarios_Credito> ObtieneCatalogoUsuariosCredito(ResultSet rs)
	{
		List<Catalogo_Usuarios_Credito> listaUsuariosCredito = new ArrayList<>();	
		try
		{
			rs.beforeFirst();
	        while (rs.next())
	        {	        
	        	if(rs.getString("encargadosCredito").equals("*"))
	        	{
	        		Catalogo_Usuarios_Credito usu_credito= new Catalogo_Usuarios_Credito();
	        		usu_credito.setCve_usu_credito(rs.getString("cve_usu_credito"));
	        		usu_credito.setNombre_usu_credito(rs.getString("nombre_usu_credito"));
	        		listaUsuariosCredito.add(usu_credito);
	        	}
	        }
		}
		catch(Exception ex)
		{
			System.out.println("Error al obtener catalogo de usuarios de credito. Detalle: " + ex.getMessage().toString());
		}
		return listaUsuariosCredito;
	}
	
	private List<Catalogo_Otros_Ingresos> ObtieneCatalogoOtrosIngresos(ResultSet rs)
	{
		List<Catalogo_Otros_Ingresos> ListCatOtrosIngresos = new ArrayList<>();			
		try
		{
			rs.beforeFirst();
	        while (rs.next())
	        {	        
	        	if(rs.getString("otro_ingreso").equals("*"))
	        	{
	        		BigDecimal precio=new BigDecimal(rs.getString("precio"));
		        	Catalogo_Otros_Ingresos catalogo = new Catalogo_Otros_Ingresos(rs.getInt("id_otros_ingresos"), rs.getString("descripcion"), rs.getString("regla_contable"), precio, rs.getInt("modifica_precio"),"");
		        	ListCatOtrosIngresos.add(catalogo);
	        	}
	        }
		}
		catch(Exception ex)
		{
			System.out.println("Error al obtener catalogo de otros ingresos. Detalle: " + ex.getMessage().toString());
		}
		return ListCatOtrosIngresos;
	}
	
	private List<Catalogo_Formas_Pago> ObtieneCatalogoFormasDePago(ResultSet rs )
	{
		List<Catalogo_Formas_Pago> ListCatFormasPago = new ArrayList<>();		
		try
		{
			rs.first();
	        while (rs.next())
	        {
	        	if(rs.getString("formaPago").equals("*"))
	        	{
	        		Catalogo_Formas_Pago formaP = new Catalogo_Formas_Pago(rs.getInt("cve_forma_pago"),rs.getString("nombre_forma_pago"));
		        	ListCatFormasPago.add(formaP);
	        	}
	        }
		}
		catch(Exception ex)
		{
			System.out.println("Error al obtener catalogo de formas de pago. Detalle: " + ex.getMessage().toString());
		}
		
		return ListCatFormasPago;
	}
	
	private List<Catalogo_Bancos> ObtieneCatalogBancos(ResultSet rs )
	{
		List<Catalogo_Bancos> ListCatBancos = new ArrayList<>();		
		try
		{
			rs.first();
	        while (rs.next())
	        {
	        	if(rs.getString("bancos").equals("*"))
	        	{
	        		Catalogo_Bancos formaP = new Catalogo_Bancos(rs.getInt("cve_banco"),rs.getString("nombre_banco"), rs.getString("banco_deposito"));
	        		ListCatBancos.add(formaP);
	        	}
	        }
		}
		catch(Exception ex)
		{
			System.out.println("Error al obtener catalogo de bancos. Detalle: " + ex.getMessage().toString());
		}
		
		return ListCatBancos;
	}

	private List<Catalogo_Motivos_Cancelacion> ObtieneMotivosCancelacion(ResultSet rs)
	{
		List<Catalogo_Motivos_Cancelacion> ListaMotCan = new ArrayList<>();
		try
		{
			rs.beforeFirst();
	        while (rs.next())
	        {
	        	if(rs.getString("cat_cancelacion").equals("*"))
	        	{
	        		Catalogo_Motivos_Cancelacion MCancelacion = new Catalogo_Motivos_Cancelacion(rs.getInt("id_motivo_cancelacion"), rs.getString("cat_cancela_descripcion"));
	        		ListaMotCan.add(MCancelacion);
	        	}
	        }
		}
		catch(Exception ex)
		{
			System.out.println("Error al obtener catalogo de motivos de cancelacion. Detalle: " + ex.getMessage().toString());
		}
		return ListaMotCan;
	}
	
	private List<Catalogo_Estatus> ObtieneEstatusDisponibles(ResultSet rs)
	{
		List<Catalogo_Estatus> ListaEstatus = new ArrayList<>();
		try
		{
			rs.beforeFirst();
	        while (rs.next())
	        {
	        	if(rs.getString("estatus").equals("*"))
	        	{
	        		Catalogo_Estatus MCancelacion = new Catalogo_Estatus(rs.getInt("id_estatus"), rs.getString("nombre_estatus"));
	        		ListaEstatus.add(MCancelacion);
	        	}
	        }
		}
		catch(Exception ex)
		{
			System.out.println("Error al obtener catalogo de motivos de cancelacion. Detalle: " + ex.getMessage().toString());
		}
		return ListaEstatus;
	}
	
	private List<Cdos> ObtieneCdosBD(ResultSet rs)
	{
		List<Cdos> ListaCdos = new ArrayList<>();
		try
		{
			rs.beforeFirst();
	        while (rs.next())
	        {
	        	if(rs.getString("cdos").equals("*"))
	        	{ 
	        		Cdos cdo = new Cdos(rs.getString("cve_cdo"), rs.getString("nombre_cdo"));
	        		ListaCdos.add(cdo);
	        	}
	        }
		}
		catch(Exception ex)
		{
			System.out.println("Error al obtener catalogo de cdos. Detalle: " + ex.getMessage().toString());
		}
		return ListaCdos;
	}
	
	private List<Impresoras> ObtieneImpresorasBD(ResultSet rs)
	{
		List<Impresoras> ListaImpresoras = new ArrayList<>();
		try
		{
			rs.beforeFirst();
	        while (rs.next())
	        {
	        	if(rs.getString("impresoras").equals("*"))
	        	{ 
	        		Impresoras cdo = new Impresoras("", rs.getString("nom_impresora"));
	        		ListaImpresoras.add(cdo);
	        	}
	        }
		}
		catch(Exception ex)
		{
			System.out.println("Error al obtener catalogo de impresoras. Detalle: " + ex.getMessage().toString());
		}
		return ListaImpresoras;
	}
	
}
