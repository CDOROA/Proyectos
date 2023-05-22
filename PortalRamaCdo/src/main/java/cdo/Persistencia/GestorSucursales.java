package cdo.Persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cdo.Datos.Armandoras;
import cdo.Datos.Log;
import cdo.Datos.Querys;
import cdo.Datos.Sucursales;
import cdo.Util.Cls_Log;
import cdo.Util.Cls_Querys;
import cdo.Util.ConexionBD;
import cdo.Util.EjecutaQuerysBD;

public class GestorSucursales {
	
	/*** CONSULTA TODAS LAS SUCURSALES DE CDO ***/
	public List<Sucursales> consultaSucursalesCDOs(List<Querys> listaQuerys)
	{
		List<Sucursales> listSucursales = new  ArrayList<>();
		Connection connBD=null;
		PreparedStatement pstm=null;
		connBD = ConexionBD.abrirConexionBD();
		try
		{
			String[] querys = new String[25];	
			querys = Cls_Querys.LimpiaListaQuerys(querys);	
			querys = Cls_Querys.ObtieneQuerys(20, listaQuerys, querys);
			pstm = connBD.prepareStatement("{call " + "comercio_electronico.usp_EXECUTE_QUERY(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			ResultSet rs=  EjecutaQuerysBD.EjecutarQuery(querys[0], querys[1],querys[2], querys[3], querys[4], querys[5], querys[6],
														 querys[7], querys[8], querys[9],querys[10], querys[11], querys[12], querys[13], 
														 querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], 
														 querys[21], querys[22], querys[23], querys[24], "",pstm, connBD);
			if(rs != null)
			{
				listSucursales=llenaClaseSucursalesCDOs(rs);
			}
			
			Log log=new Log(0, 0, 0 ,0, "[Accion: Consulta todas las sucursales de CDO ]");
			Cls_Log.insertaLog(log);

		}
		catch(Exception ex)
		{
			System.out.println("[NuevoportalRamaCDO.- Error: Consulta todas las sucursales de CDO,  Clase: GestorSucursales,  Detalle: " + ex.getMessage().toString() +"]"); 
			Log log=new Log(0, 0, 0 ,0, "[Error: Consulta todas las sucursales de CDO,  Clase: GestorSucursales,  Detalle: " + ex.getMessage().toString() +"]");
			Cls_Log.insertaLog(log);
		}
		finally
		{
			try {pstm.close();} catch (SQLException e) {e.printStackTrace();}
			try {connBD.close();} catch (SQLException e) {e.printStackTrace();}
		}
		return listSucursales;
	}
		
	private List<Sucursales> llenaClaseSucursalesCDOs(ResultSet rs)
	{
		List<Sucursales> listaSucursales= new ArrayList<>();
		try
		{
			while(rs.next())
			{
				Sucursales sucursal= new Sucursales();
				sucursal.setCve_empresa(rs.getInt("cve_empresa"));
				sucursal.setDireccion(rs.getString("direccion"));
				sucursal.setEmail(rs.getString("e_mail_ventas"));
				sucursal.setLatitud(rs.getString("latitud"));
				sucursal.setLongitud(rs.getString("longitud"));
				sucursal.setNombre(rs.getString("nombre_comercial"));
				sucursal.setTelefono(rs.getString("telefonos"));
				sucursal.setUrl(rs.getString("url_google_maps"));
				sucursal.setCobertura(rs.getString("cobertura"));
				listaSucursales.add(sucursal);
			}
		}
		catch(Exception ex)
		{
			System.out.println("[NuevoportalRamaCDO.- Error: Llenar clase de sucursales  CDO,  Clase: GestorSucursales,  Detalle: " + ex.getMessage().toString() +"]"); 
			Log log=new Log(0, 0, 0 ,0, "[Error: Llenar clase de sucursales  CDO,  Clase: GestorSucursales,  Detalle: " + ex.getMessage().toString() +"]");
			Cls_Log.insertaLog(log);
		}
		return listaSucursales;
	}
	
	
	/*** CONSULTA LAS SUCURSALES POR ESTADO  ***/
	public Sucursales consultaSucursalesXEdo(List<Querys> listaQuerys, String cve_edo)
	{
		Sucursales sucursal = new Sucursales();
		Connection connBD = null;
		PreparedStatement pstm= null;
		connBD = ConexionBD.abrirConexionBD();	
		try
		{
			String[] querys = new String[25];	
			querys = Cls_Querys.LimpiaListaQuerys(querys);	
			querys = Cls_Querys.ObtieneQuerys(8, listaQuerys, querys);
			querys = inicializaQueryNumero8(querys, cve_edo);
			pstm = connBD.prepareStatement("{call " + "comercio_electronico.usp_EXECUTE_QUERY(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			ResultSet rs=  EjecutaQuerysBD.EjecutarQuery(querys[0], querys[1],querys[2], querys[3], querys[4], querys[5], querys[6],
														 querys[7], querys[8], querys[9],querys[10], querys[11], querys[12], querys[13], 
														 querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], 
														 querys[21], querys[22], querys[23], querys[24], "",pstm, connBD);
			
		//	System.out.println("query 8");
			Cls_Querys.ImprimeQuerysConsola(querys,false,"Query 8");
			
			sucursal = llenaClaseSucursales(rs);			
			Log log=new Log(0, 0, 0 ,0, "[Accion: Consulta las sucursales de CDO  por estado: " + cve_edo+ "  ] ");
			Cls_Log.insertaLog(log);
		}
		catch(Exception ex)
		{
			System.out.println("[NuevoportalRamaCDO.- Error: Consulta las sucursales por CDO,  Clase: GestorSucursales,  Detalle: " + ex.getMessage().toString() +"]"); 
			Log log=new Log(0, 0, 0 ,0, "[Error: Consulta las sucursales por CDO,  Clase: GestorSucursales,  Detalle: " + ex.getMessage().toString() +"]");
			Cls_Log.insertaLog(log);
		}
		finally 
		{
			try {pstm.close();} catch (SQLException e) {e.printStackTrace();}
			try {connBD.close();} catch (SQLException e) {e.printStackTrace();}
		}
		return sucursal;
	}
		
	private Sucursales llenaClaseSucursales(ResultSet rs)
	{
		Sucursales sucursal = new Sucursales();
		
		try
		{
			if(rs != null)
			{
				while(rs.next())
				{
					
					sucursal.setCve_empresa(rs.getInt("cve_empresa"));
					sucursal.setCve_estado(rs.getInt("cve_estado"));
					sucursal.setDireccion(rs.getString("direccion"));
					sucursal.setEmail(rs.getString("e_mail_ventas"));
					sucursal.setLatitud(rs.getString("latitud"));
					sucursal.setLongitud(rs.getString("longitud"));
					sucursal.setNombre(rs.getString("nombre_comercial"));
					sucursal.setTelefono(rs.getString("telefonos"));
					sucursal.setUrl(rs.getString("url_google_maps"));
					sucursal.setCobertura(rs.getString("cobertura"));
				}
			}
		}
		catch(Exception ex)
		{
			System.out.println("[NuevoportalRamaCDO.- Error: Llenar clase de sucursales  CDO,  Clase: GestorSucursales,  Detalle: " + ex.getMessage().toString() +"]"); 
			Log log=new Log(0, 0, 0 ,0, "[Error: Llenar clase de sucursales  CDO,  Clase: GestorSucursales,  Detalle: " + ex.getMessage().toString() +"]");
			Cls_Log.insertaLog(log);
		}
		return sucursal;
	}
	
	
	/*** INICIALIZA QUERYS ****/
 	private String[] inicializaQueryNumero8(String[] ListaQuerys,String cve_edo)
	{
		for (int i=0;i <ListaQuerys.length; i++)
		{
			ListaQuerys[i]= ListaQuerys[i].replace("{CVE_ESTADO}", cve_edo);				
		}
		return ListaQuerys;
	}
}
