package cdo.Persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cdo.Datos.Armandoras;
import cdo.Datos.Log;
import cdo.Datos.QueAutoparteBuscaArticulos;
import cdo.Datos.Querys;
import cdo.Datos.SubMarcas;
import cdo.Util.Cls_Log;
import cdo.Util.Cls_Querys;
import cdo.Util.ConexionBD;
import cdo.Util.EjecutaQuerysBD;

public class GestorQueAutoparteBusca {

	
	/*** CONSULTA CATALOGO ARMADORAS ****/
	public List<Armandoras> consultaCatalogoDeArmadoras(List<Querys> listaQuerys, String desc_marca, String desc_artriculo)
	{
		List<Armandoras> listaArmadoras = new ArrayList<>();
		Connection connBD = null;
		PreparedStatement pstm= null;
		connBD = ConexionBD.abrirConexionBD();	
		try
		{
			String[] querys = new String[25];	
			querys = Cls_Querys.LimpiaListaQuerys(querys);	
			querys = Cls_Querys.ObtieneQuerys(6, listaQuerys, querys);
			querys = inicializaQueryNumero6(querys, desc_marca, desc_artriculo);
			pstm = connBD.prepareStatement("{call " + "comercio_electronico.usp_EXECUTE_QUERY(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			ResultSet rs=  EjecutaQuerysBD.EjecutarQuery(querys[0], querys[1],querys[2], querys[3], querys[4], querys[5], querys[6],
														 querys[7], querys[8], querys[9],querys[10], querys[11], querys[12], querys[13], 
														 querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], 
														 querys[21], querys[22], querys[23], querys[24], "",pstm, connBD);
			
		//	System.out.println("query 6");
			Cls_Querys.ImprimeQuerysConsola(querys,false,"query 6");
			
			listaArmadoras = llenaClaseArmadoras(rs);
		}
		catch(Exception ex)
		{
			System.out.println("[NuevoportalRamaCDO.- Error: Consulta catalogo de armadoras,  Clase: GestorQueAutoparteBusca,  Detalle: " + ex.getMessage().toString() +"]"); 
			Log log=new Log(0, 0, 0 ,0, "[Error: Consulta catalogo de armadoras,  Clase: GestorQueAutoparteBusca,  Detalle: " + ex.getMessage().toString() +"]");
			Cls_Log.insertaLog(log);
		}
		finally 
		{
			try {pstm.close();} catch (SQLException e) {e.printStackTrace();}
			try {connBD.close();} catch (SQLException e) {e.printStackTrace();}
		}
		return listaArmadoras;
	}
	
	private List<Armandoras> llenaClaseArmadoras(ResultSet rs)
	{
		List<Armandoras> listaArmadoras = new ArrayList<>();
		try
		{
			if(rs != null)
			{
				while(rs.next())
				{
					Armandoras armadora= new Armandoras();
					armadora.setCve_armadora(0);
					armadora.setNombre_armadora(rs.getString("desc_armadora"));
					listaArmadoras.add(armadora);
				}
			}
		}
		catch(Exception ex)
		{
			System.out.println("[NuevoportalRamaCDO.- Error: Llenar clase  de armadoras,  Clase: GestorQueAutoparteBusca,  Detalle: " + ex.getMessage().toString() +"]"); 
			Log log=new Log(0, 0, 0 ,0, "[Error:  Llenar clase  de armadoras,  Clase: GestorQueAutoparteBusca,  Detalle: " + ex.getMessage().toString() +"]");
			Cls_Log.insertaLog(log);
		}
		
		return listaArmadoras;
	}
	
	
	/*** CONSULTA CATALOGO ARMADORAS ****/
	public List<SubMarcas> consultaCatalogoDeSubMarcas(List<Querys> listaQuerys, String desc_marca, String desc_artriculo, String desc_Armadora)
	{
		List<SubMarcas> listaSubMarcas = new ArrayList<>();
		Connection connBD = null;
		PreparedStatement pstm= null;
		connBD = ConexionBD.abrirConexionBD();	
		try
		{
			String[] querys = new String[25];	
			querys = Cls_Querys.LimpiaListaQuerys(querys);	
			querys = Cls_Querys.ObtieneQuerys(7, listaQuerys, querys);
			querys = inicializaQueryNumero7(querys, desc_marca, desc_artriculo,desc_Armadora);
			pstm = connBD.prepareStatement("{call " + "comercio_electronico.usp_EXECUTE_QUERY(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			ResultSet rs=  EjecutaQuerysBD.EjecutarQuery(querys[0], querys[1],querys[2], querys[3], querys[4], querys[5], querys[6],
														 querys[7], querys[8], querys[9],querys[10], querys[11], querys[12], querys[13], 
														 querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], 
														 querys[21], querys[22], querys[23], querys[24], "",pstm, connBD);
			
			//System.out.println("query 7");
			Cls_Querys.ImprimeQuerysConsola(querys,false,"query 7");
			listaSubMarcas = llenaClaseSubmarcas(rs);
		}
		catch(Exception ex)
		{
			System.out.println("[NuevoportalRamaCDO.- Error: Consulta catalogo de submarcas,  Clase: GestorQueAutoparteBusca,  Detalle: " + ex.getMessage().toString() +"]"); 
			Log log=new Log(0, 0, 0 ,0, "[Error: Consulta catalogo de submarcas,  Clase: GestorQueAutoparteBusca,  Detalle: " + ex.getMessage().toString() +"]");
			Cls_Log.insertaLog(log);
		}
		finally 
		{
			try {pstm.close();} catch (SQLException e) {e.printStackTrace();}
			try {connBD.close();} catch (SQLException e) {e.printStackTrace();}
		}
		return listaSubMarcas;
	}
	
	private List<SubMarcas> llenaClaseSubmarcas(ResultSet rs)
	{
		List<SubMarcas> listasubmarca = new ArrayList<>();
		try
		{
			if(rs != null)
			{
				while(rs.next())
				{
					SubMarcas submarca= new SubMarcas();
					submarca.setCve_submarca(0);
					submarca.setNombre_submarca(rs.getString("desc_sub_marca"));
					listasubmarca.add(submarca);
				}
			}
		}
		catch(Exception ex)
		{
			System.out.println("[NuevoportalRamaCDO.- Error: Llenar clase  de submarcas,  Clase: GestorQueAutoparteBusca,  Detalle: " + ex.getMessage().toString() +"]"); 
			Log log=new Log(0, 0, 0 ,0, "[Error:  Llenar clase  de submarcas,  Clase: GestorQueAutoparteBusca,  Detalle: " + ex.getMessage().toString() +"]");
			Cls_Log.insertaLog(log);
		}
		return listasubmarca;
	}
	
	/*** CONSULTA AUTOPARTES ****/	
	public List<QueAutoparteBuscaArticulos> consultaArticulos(List<Querys> listaQuerys, String desc_marca, String desc_artriculo, String desc_Armadora, String desc_submarca, String desc_grupo)
	{
		List<QueAutoparteBuscaArticulos> listaArticulos = new ArrayList<>();
		Connection connBD = null;
		PreparedStatement pstm= null;
		connBD = ConexionBD.abrirConexionBD();	
		try
		{
			String[] querys = new String[25];	
			querys = Cls_Querys.LimpiaListaQuerys(querys);	
			querys = Cls_Querys.ObtieneQuerys(5, listaQuerys, querys);
			querys = inicializaQueryNumero5(querys, desc_marca, desc_artriculo,desc_Armadora, desc_submarca,desc_grupo);
			pstm = connBD.prepareStatement("{call " + "comercio_electronico.usp_EXECUTE_QUERY(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			ResultSet rs=  EjecutaQuerysBD.EjecutarQuery(querys[0], querys[1],querys[2], querys[3], querys[4], querys[5], querys[6],
														 querys[7], querys[8], querys[9],querys[10], querys[11], querys[12], querys[13], 
														 querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], 
														 querys[21], querys[22], querys[23], querys[24], "",pstm, connBD);	
			
			//System.out.println("query 5");
			Cls_Querys.ImprimeQuerysConsola(querys,false,"Query 5");
		
			listaArticulos= llenaClaseArticulos(rs);			
			Log log=new Log(0, 0, 0 ,0, "[Accion: Consulta articulos por parametro, Marca:  " + desc_marca +", Descripcion: " + desc_artriculo + ", Armadora: " + desc_Armadora + ", Submarca:  " + desc_submarca + ", Grupo:  " + desc_grupo+ " ]");
			Cls_Log.insertaLog(log);			
		}
		catch(Exception ex)
		{
			System.out.println("[NuevoportalRamaCDO.- Error: Consulta articulos por parametros,  Clase: GestorQueAutoparteBusca,  Detalle: " + ex.getMessage().toString() +"]"); 
			Log log=new Log(0, 0, 0 ,0, "[Error: Consulta articulos por parametros,  Clase: GestorQueAutoparteBusca,  Detalle: " + ex.getMessage().toString() +"]");
			Cls_Log.insertaLog(log);
		}
		finally 
		{
			try {pstm.close();} catch (SQLException e) {e.printStackTrace();}
			try {connBD.close();} catch (SQLException e) {e.printStackTrace();}
		}
		return listaArticulos;
	}
	
	private List<QueAutoparteBuscaArticulos> llenaClaseArticulos(ResultSet rs)
	{
		List<QueAutoparteBuscaArticulos> listaArticulos = new ArrayList<>();
		try
		{
			if(rs != null)
			{
				while(rs.next())
				{
					QueAutoparteBuscaArticulos articulo= new QueAutoparteBuscaArticulos();
					articulo.setAnio_fin(rs.getString("Modelo Final"));
					articulo.setAnio_ini(rs.getString("Modelo Inicial"));
					articulo.setCaracteristicas(rs.getString("Característica"));
					articulo.setCilindros(rs.getString("Cilindros"));
					articulo.setCve_articulo(rs.getString("nomArticulo"));
					articulo.setDes_marca(rs.getString("Marca Producto"));
					articulo.setDes_submarca(rs.getString("Sub Marca"));
					articulo.setDesc_aramdora(rs.getString("Armadora"));
					articulo.setDesc_articulo(rs.getString("Artículo"));
					articulo.setDesc_grupo(rs.getString("Sistema Automotriz"));
					articulo.setMotor(rs.getString("Litros Motor"));
					articulo.setPosicion(rs.getString("Posición"));
					listaArticulos.add(articulo);
				}
			}
		}
		catch(Exception ex)
		{
			System.out.println("[NuevoportalRamaCDO.- Error: Llenar clase  de articulos,  Clase: GestorQueAutoparteBusca,  Detalle: " + ex.getMessage().toString() +"]"); 
			Log log=new Log(0, 0, 0 ,0, "[Error:  Llenar clase  de articulos,  Clase: GestorQueAutoparteBusca,  Detalle: " + ex.getMessage().toString() +"]");
			Cls_Log.insertaLog(log);
		}
		return listaArticulos;
	}
	
	
	
	/*** INICIALIZA QUERYS ****/
 	private String[] inicializaQueryNumero6(String[] ListaQuerys,String desc_marca, String desc_artriculo)
	{
		for (int i=0;i <ListaQuerys.length; i++)
		{
			ListaQuerys[i]= ListaQuerys[i].replace("{MARCA}", desc_marca);
			if(desc_artriculo != "")
			{
				ListaQuerys[i]= ListaQuerys[i].replace("{PRODUCTO}", "AND desc_articulo_rc LIKE '%" + desc_artriculo + "%'");
			}
			else
			{
				ListaQuerys[i]= ListaQuerys[i].replace("{PRODUCTO}", "");
			}			
		}
		return ListaQuerys;
	}
	
	private String[] inicializaQueryNumero7(String[] ListaQuerys,String desc_marca, String desc_artriculo, String desc_Armadora)
	{
		for (int i=0;i <ListaQuerys.length; i++)
		{
			ListaQuerys[i]= ListaQuerys[i].replace("{MARCA}", desc_marca);
			ListaQuerys[i]= ListaQuerys[i].replace("{ARMADORA}", desc_Armadora);
			if(desc_artriculo != "")
			{
				ListaQuerys[i]= ListaQuerys[i].replace("{PRODUCTO}", "AND desc_articulo_rc LIKE '%" + desc_artriculo + "%'");
			}
			else
			{
				ListaQuerys[i]= ListaQuerys[i].replace("{PRODUCTO}", "");
			}	
		}
		return ListaQuerys;
	}
	
	private String[] inicializaQueryNumero5(String[] ListaQuerys,String desc_marca, String desc_artriculo, String desc_Armadora, String desc_SubMarcas, String desc_grupo)
	{
		for (int i=0;i <ListaQuerys.length; i++)
		{			
			String marca="";
			String armadora="";
			String submarca="";
						
			if(!desc_marca.equals(""))
			{
				marca =" AND desc_marca_producto = '" + desc_marca + "'";			
			
				armadora= (!desc_Armadora.equals("")) ?" AND desc_armadora = '" + desc_Armadora + "'" :"";
				
				if(!desc_SubMarcas.equals(""))
				{
					 submarca= " AND desc_sub_marca = '" + desc_SubMarcas + "'" ;
				}	
			
			}
			String articulo = (!desc_artriculo.equals("")) ? " AND desc_articulo_rc LIKE '%" + desc_artriculo + "%'" :"";	
			String grupo= (!desc_grupo.equals("")) ? " AND desc_grupo = '" + desc_grupo + "'" :"";
			
			ListaQuerys[i]= ListaQuerys[i].replace("{MARCA}", marca);
			ListaQuerys[i]= ListaQuerys[i].replace("{PRODUCTO}", articulo);
			ListaQuerys[i]= ListaQuerys[i].replace("{ARMADORA}", armadora);
			ListaQuerys[i]= ListaQuerys[i].replace("{SUBMARCA}", submarca);
			ListaQuerys[i]= ListaQuerys[i].replace("{GRUPO}", grupo);
					
		}
		return ListaQuerys;
	}
}
