package Persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Datos.Centro;
import Datos.Puesto;
import Datos.Querys;
import Datos.Vacante;
import Util.Cls_Querys;
import Util.ConexionBD;

public class GestorVacantes {

	public List<Vacante> ConsultaVacantes(List<Querys> listaQuerys, String cdo){
		Connection connBD = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		connBD = ConexionBD.abrirConexionBD();	
		List<Vacante> ListVacantes = new ArrayList<>();
		
		try {
			
			String[] querys = new String[25];	
			querys = Cls_Querys.LimpiaListaQuerys(querys);	
			querys = Cls_Querys.ObtieneQuerys(1, listaQuerys, querys);
			querys = inicializaQueryNumero77(querys, cdo);
			pstm = connBD.prepareStatement("{call " + "comercio_electronico.usp_EXECUTE_QUERY(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			rs=  Cls_Querys.EjecutarQuery(querys[0], querys[1],querys[2], querys[3], querys[4], querys[5], querys[6],
														 querys[7], querys[8], querys[9],querys[10], querys[11], querys[12], querys[13], 
														 querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], 
														 querys[21], querys[22], querys[23], querys[24], "",pstm, connBD);
			
			
			Cls_Querys.ImprimeQuerysConsola(querys,false,"Query 1");
			
			ListVacantes = llenaClaseVacantes(rs);			

		}catch(Exception ex)
		{
			System.out.println("Error - GestorVacantes.ConsultaVacantes:" + ex);
		}
		finally {
			try {
				if(connBD != null) {
					connBD.close();
				}
				if(pstm != null) {
					pstm.close();
				}
			} catch (Exception e) {
				System.out.println("ERROR al cerrar conexcion en GestorVacantes.ConsultaVacantes: " + e);
			}
		}
		return ListVacantes;
	}

	private List<Vacante> llenaClaseVacantes(ResultSet rs) {
		List<Vacante> listVacantes = new ArrayList<>();
		try
		{
			if(rs != null)
			{
				while(rs.next())
				{
					Vacante vacante = new Vacante();
					vacante.setIdVacante(rs.getInt("id"));
					vacante.setCveEmpresa(rs.getInt("cve_empresa"));
					vacante.setNombreEmpresa(rs.getString("nombre_empresa"));
					vacante.setIdPuesto(rs.getInt("id_puesto"));
					vacante.setNombrePuesto(rs.getString("nombre_puesto"));
					vacante.setDescripcionVacante(rs.getString("des_vacante"));
					vacante.setHorarioVacante(rs.getString("horario_vacante"));
					vacante.setLugarTrabajo(rs.getString("lugar_trabajo"));
					vacante.setFechaPublicacion(rs.getString("fecha_publicacion"));
					vacante.setObservaciones(rs.getString("observaciones"));				
					vacante.setIdEstado(rs.getInt("id_estado"));
					vacante.setNombreEstaso(rs.getString("nombre_estado"));
					vacante.setEstatus(rs.getInt("estatus"));
					listVacantes.add(vacante);
				}
			}			
		}
		catch(Exception ex)
		{
			System.out.println("[Error: Obtener catalogo de sucursales,  Clase: GestorVacantes.llenaClaseVacantes,  Detalle: " + ex.getMessage().toString() +"]");
			 
		}
		return listVacantes;
	}
	
	
	public List<Centro> ConsultaCentros(List<Querys> listaQuerys){
		Connection connBD = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		connBD = ConexionBD.abrirConexionBD();	
		List<Centro> ListVacantes = new ArrayList<>();
		String cdo = "cdf";
		try {
			
			String[] querys = new String[25];	
			querys = Cls_Querys.LimpiaListaQuerys(querys);	
			querys = Cls_Querys.ObtieneQuerys(2, listaQuerys, querys);
			querys = inicializaQueryNumero2(querys, cdo);
			pstm = connBD.prepareStatement("{call " + "comercio_electronico.usp_EXECUTE_QUERY(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			rs=  Cls_Querys.EjecutarQuery(querys[0], querys[1],querys[2], querys[3], querys[4], querys[5], querys[6],
														 querys[7], querys[8], querys[9],querys[10], querys[11], querys[12], querys[13], 
														 querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], 
														 querys[21], querys[22], querys[23], querys[24], "",pstm, connBD);
			
			
			Cls_Querys.ImprimeQuerysConsola(querys,false,"Query 2");
			
			ListVacantes = llenaClaseCentros(rs);			

		}catch(Exception ex)
		{
			System.out.println("Error - GestorVacantes.ConsultaVacantes:" + ex);
		}
		finally {
			try {
				if(connBD != null) {
					connBD.close();
				}
				if(pstm != null) {
					pstm.close();
				}
			} catch (Exception e) {
				System.out.println("ERROR al cerrar conexcion en GestorVacantes.ConsultaVacantes: " + e);
			}
		}
		return ListVacantes;
	}

	private String[] inicializaQueryNumero2(String[] ListaQuerys, String cdo) {
		
		for (int i=0;i <ListaQuerys.length; i++)
		{			
			ListaQuerys[i]= ListaQuerys[i].replace("{CVE_CDO}","");			
				
		}
		return ListaQuerys;
	}
	
	private List<Centro> llenaClaseCentros(ResultSet rs) {
		List<Centro> listVacantes = new ArrayList<>();
		try
		{
			if(rs != null)
			{
				while(rs.next())
				{
					 Centro centro = new Centro();
					 centro.setCveEmpresa(rs.getInt("cve_empresa"));
					 centro.setNombreComercial(rs.getString("nombre_comercial"));
					 listVacantes.add(centro);
				}
			}			
		}
		catch(Exception ex)
		{
			System.out.println("[Error: Obtener catalogo de sucursales,  Clase: GestorVacantes.llenaClaseVacantes,  Detalle: " + ex.getMessage().toString() +"]");
			 
		}
		return listVacantes;
	}

	public List<Puesto> ConsultaPuestos(List<Querys> listaQuerys) {
		Connection connBD = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		connBD = ConexionBD.abrirConexionBD();	
		List<Puesto> ListPuestos = new ArrayList<>();
		
		try {
			
			String[] querys = new String[25];	
			querys = Cls_Querys.LimpiaListaQuerys(querys);	
			querys = Cls_Querys.ObtieneQuerys(3, listaQuerys, querys);
		
			pstm = connBD.prepareStatement("{call " + "comercio_electronico.usp_EXECUTE_QUERY(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			rs=  Cls_Querys.EjecutarQuery(querys[0], querys[1],querys[2], querys[3], querys[4], querys[5], querys[6],
														 querys[7], querys[8], querys[9],querys[10], querys[11], querys[12], querys[13], 
														 querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], 
														 querys[21], querys[22], querys[23], querys[24], "",pstm, connBD);
			
			
			Cls_Querys.ImprimeQuerysConsola(querys,false,"Query 3");
			
			ListPuestos = llenaClasePuestos(rs);			

		}catch(Exception ex)
		{
			System.out.println("Error - GestorVacantes.ConsultaVacantes:" + ex);
		}
		finally {
			try {
				if(connBD != null) {
					connBD.close();
				}
				if(pstm != null) {
					pstm.close();
				}
			} catch (Exception e) {
				System.out.println("ERROR al cerrar conexcion en GestorVacantes.ConsultaPuestos: " + e);
			}
		}
		return ListPuestos;
	}

	private List<Puesto> llenaClasePuestos(ResultSet rs) {
		List<Puesto> listPuestos = new ArrayList<>();
		try
		{
			if(rs != null)
			{
				while(rs.next())
				{
					Puesto puesto = new Puesto();
					puesto.setIdPuesto(rs.getInt("id_puesto"));
					puesto.setNombrePuesto(rs.getString("nombre_puesto"));
					listPuestos.add(puesto);
					//System.out.println(puesto);
				}
			}			
		}
		catch(Exception ex)
		{
			System.out.println("[Error: Obtener catalogo de sucursales,  Clase: GestorVacantes.llenaClasePuestos,  Detalle: " + ex.getMessage().toString() +"]");
		}
		return listPuestos;
	}
	
	
	public List<Vacante> ActualizaVacante(Connection connBD, Vacante vacante, List<Querys> listaQuerys){
		 
		PreparedStatement pstm = null;
		ResultSet rs = null;
		List<Vacante> ListVacantes = new ArrayList<>();
		
		try {
			
			String[] querys = new String[25];	
			querys = Cls_Querys.LimpiaListaQuerys(querys);	
			querys = Cls_Querys.ObtieneQuerys(4, listaQuerys, querys);
			querys = inicializaQueryNumero4(querys, vacante);
			pstm = connBD.prepareStatement("{call " + "comercio_electronico.usp_EXECUTE_QUERY(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			rs=  Cls_Querys.EjecutarQuery(querys[0], querys[1],querys[2], querys[3], querys[4], querys[5], querys[6],
														 querys[7], querys[8], querys[9],querys[10], querys[11], querys[12], querys[13], 
														 querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], 
														 querys[21], querys[22], querys[23], querys[24], "",pstm, connBD);
			
			
			Cls_Querys.ImprimeQuerysConsola(querys,false,"Query 4");
			
			ListVacantes = llenaClaseVacantes(rs);			

		}catch(Exception ex)
		{
			System.out.println("Error - GestorVacantes.ActualizaVacante:" + ex);
		}
		finally {
			try {
				if(connBD != null) {
					connBD.close();
				}
				if(pstm != null) {
					pstm.close();
				}
			} catch (Exception e) {
				System.out.println("ERROR al cerrar conexcion en GestorVacantes.ActualizaVacante: " + e);
			}
		}
		return ListVacantes;
	}
	

	
	public List<Vacante> AgregarVacante(Connection connBD, Vacante vacante, List<Querys> listaQuerys){
		 
		PreparedStatement pstm = null;
		ResultSet rs = null;
		List<Vacante> ListVacantes = new ArrayList<>();
		
		try {
			
			String[] querys = new String[25];	
			querys = Cls_Querys.LimpiaListaQuerys(querys);	
			querys = Cls_Querys.ObtieneQuerys(5, listaQuerys, querys);
			querys = inicializaQueryNumero4(querys, vacante);
			pstm = connBD.prepareStatement("{call " + "comercio_electronico.usp_EXECUTE_QUERY(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			rs=  Cls_Querys.EjecutarQuery(querys[0], querys[1],querys[2], querys[3], querys[4], querys[5], querys[6],
														 querys[7], querys[8], querys[9],querys[10], querys[11], querys[12], querys[13], 
														 querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], 
														 querys[21], querys[22], querys[23], querys[24], "",pstm, connBD);
			
			
			Cls_Querys.ImprimeQuerysConsola(querys,false,"Query 5");
			
			ListVacantes = llenaClaseVacantes(rs);			

		}catch(Exception ex)
		{
			System.out.println("Error - GestorVacantes.AgregarVacante:" + ex);
		}
		finally {
			try {
				if(connBD != null) {
					connBD.close();
				}
				if(pstm != null) {
					pstm.close();
				}
			} catch (Exception e) {
				System.out.println("ERROR al cerrar conexcion en GestorVacantes.AgregarVacante: " + e);
			}
		}
		return ListVacantes;
	}
	
	public List<Vacante> EliminarVacante(Connection connBD, Vacante vacante, List<Querys> listaQuerys){
		 
		PreparedStatement pstm = null;
		ResultSet rs = null;
		List<Vacante> ListVacantes = new ArrayList<>();
		
		try {
			
			String[] querys = new String[25];	
			querys = Cls_Querys.LimpiaListaQuerys(querys);	
			querys = Cls_Querys.ObtieneQuerys(6, listaQuerys, querys);
			querys = inicializaQueryNumero4(querys, vacante);
			pstm = connBD.prepareStatement("{call " + "comercio_electronico.usp_EXECUTE_QUERY(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			rs=  Cls_Querys.EjecutarQuery(querys[0], querys[1],querys[2], querys[3], querys[4], querys[5], querys[6],
														 querys[7], querys[8], querys[9],querys[10], querys[11], querys[12], querys[13], 
														 querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], 
														 querys[21], querys[22], querys[23], querys[24], "",pstm, connBD);
			
			
			Cls_Querys.ImprimeQuerysConsola(querys,false,"Query 6");
			
			ListVacantes = llenaClaseVacantes(rs);			

		}catch(Exception ex)
		{
			System.out.println("Error - GestorVacantes.EliminarVacante:" + ex);
		}
		finally {
			try {
				if(connBD != null) {
					connBD.close();
				}
				if(pstm != null) {
					pstm.close();
				}
			} catch (Exception e) {
				System.out.println("ERROR al cerrar conexcion en GestorVacantes.EliminarVacante: " + e);
			}
		}
		return ListVacantes;
	}
	
	private String[] inicializaQueryNumero4(String[] ListaQuerys, Vacante vacante) {
		for (int i=0;i <ListaQuerys.length; i++)
		{
			ListaQuerys[i]= ListaQuerys[i].replace("{CVE_EMPRESA}",String.valueOf( vacante.getCveEmpresa()));			
			ListaQuerys[i]= ListaQuerys[i].replace("{ID_PUESTO}", String.valueOf(vacante.getIdPuesto()));			
			ListaQuerys[i]= ListaQuerys[i].replace("{DESCRIPCION_VACANTE}", vacante.getDescripcionVacante());			
			ListaQuerys[i]= ListaQuerys[i].replace("{HORARIO}", vacante.getHorarioVacante());			
			ListaQuerys[i]= ListaQuerys[i].replace("{LUGAR_TRABAJO}", vacante.getLugarTrabajo());			
			ListaQuerys[i]= ListaQuerys[i].replace("{FECHA_PUBLICACION}", vacante.getFechaPublicacion());			
			ListaQuerys[i]= ListaQuerys[i].replace("{OBSERVACIONES}", vacante.getObservaciones());			
			ListaQuerys[i]= ListaQuerys[i].replace("{CVE_ESTADO}", String.valueOf(vacante.getIdEstado()));			
			ListaQuerys[i]= ListaQuerys[i].replace("{ESTATUS}", String.valueOf(vacante.getEstatus()));			
			ListaQuerys[i]= ListaQuerys[i].replace("{ID_VACANTE}", String.valueOf(vacante.getIdVacante()));			
		}
		return ListaQuerys;
	}
	private String[] inicializaQueryNumero77(String[] ListaQuerys,String cdo) {
		for (int i=0;i <ListaQuerys.length; i++)
		{			
			ListaQuerys[i]= ListaQuerys[i].replace("{CVE}", String.valueOf(cdo));	
		}
		ListaQuerys[1] = "";
		return ListaQuerys;
	}
	
}
