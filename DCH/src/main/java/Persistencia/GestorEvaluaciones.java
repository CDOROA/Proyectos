package Persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Datos.Areas;
import Datos.Correo;
import Datos.Empleados;
import Datos.Evaluacion;
import Datos.Evaluado;
import Datos.LogEncuestas;
import Datos.Querys;
import Datos.Usuario;
import Util.Cls_Querys;
import Util.ConexionBD;
import Util.InsertaLogEncuestas;

public class GestorEvaluaciones {

	public List<Evaluacion> ConsultaEvaluaciones(List<Querys> listaQuerys, String cdo, Usuario infoUsu) {
		Connection connBD = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		connBD = ConexionBD.AbrirConexionBDD(cdo);	
		List<Evaluacion> ListEvaluaciones = new ArrayList<>();
		
		try {
			
			String[] querys = new String[25];	
			querys = Cls_Querys.LimpiaListaQuerys(querys);	
			querys = Cls_Querys.ObtieneQuerys(1, listaQuerys, querys);
			querys = inicializaQueryNumero1(querys, cdo);
			pstm = connBD.prepareStatement("{call " + "DCH.usp_EXECUTE_QUERY(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			rs=  Cls_Querys.EjecutarQuery(querys[0], querys[1],querys[2], querys[3], querys[4], querys[5], querys[6],
														 querys[7], querys[8], querys[9],querys[10], querys[11], querys[12], querys[13], 
														 querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], 
														 querys[21], querys[22], querys[23], querys[24], "",pstm, connBD,infoUsu);
			
			
			Cls_Querys.ImprimeQuerysConsola(querys,true,"Query 1");
			
			ListEvaluaciones = llenaClaseEvaluacion(rs, infoUsu);
			
			InsertaLogEncuestas.insertarLog(new LogEncuestas(),cdo,cdo,"Entrada a consultar Evaluaciones Usuario: "+infoUsu.getCveUsuario()+" qry{"+Cls_Querys.regresaQuerys(querys,true)+"}",infoUsu.getCveUsuario());
		}catch(Exception ex)
		{
			InsertaLogEncuestas.insertarLog(new LogEncuestas(),cdo,cdo,"Error en el metodo ConsultaEvaluaciones de la clase GestorEvaluaciones. DETALLE: "+ex.getMessage().toString().replace("'", "")+" Usuario: "+infoUsu.getCveUsuario(),infoUsu.getCveUsuario());
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
				System.out.println("ERROR al cerrar conexcion en GestorEvaluaciones.ConsultaEvaluaciones: " + e);
			}
		}
		return ListEvaluaciones;
	}
	private String[] inicializaQueryNumero1(String[] querys, String cdo) {
		for (int i=0;i <querys.length; i++)
		{	
			querys[i]=querys[i].replace("{CDO}", String.valueOf(cdo));
			
		}
		return querys;
	}
	private List<Evaluacion> llenaClaseEvaluacion(ResultSet rs, Usuario infoUsu) {
		List<Evaluacion> ListEvaluaciones = new ArrayList<>();
		try
		{
			
			//System.err.println("hola2");
				while(rs.next())
				{System.out.println("hola");
					Evaluacion evaluacion = new Evaluacion();
					evaluacion.setIdEvaluacion(rs.getString("id_evaluacion"));
					evaluacion.setIdEncuesta(rs.getString("id_encuesta"));
					evaluacion.setNombre(rs.getString("nombre"));
					evaluacion.setEstatus(rs.getString("estatus"));
					evaluacion.setVigenciaInicio(rs.getDate("fecha_vigencia_inicio"));
					evaluacion.setVigenciaFin(rs.getDate("fecha_vigencia_fin"));
					ListEvaluaciones.add(evaluacion);
				}
					
		}
		catch(Exception ex)
		{
			InsertaLogEncuestas.insertarLog(new LogEncuestas(),infoUsu.getUname(),infoUsu.getUname(),"Error en el metodo llenaClaseEvaluacion de la clase GestorEvaluaciones. DETALLE: "+ex.getMessage().toString().replace("'", "")+" Usuario: "+infoUsu.getCveUsuario(),infoUsu.getCveUsuario());
			//System.out.println("[Error: Obtener catalogo de sucursales,  Clase: GestorEvaluaciones.llenaClaseVacantes,  Detalle: " + ex.getMessage().toString() +"]");
			 
		}
		return ListEvaluaciones;
	}
	public List<Areas> consultaAreas(List<Querys> listaQuerys, String cdo, Usuario infoUsu, String idEncuesta) {
		Connection connBD = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		connBD = ConexionBD.AbrirConexionBDD(cdo);	
		List<Areas> ListAreas = new ArrayList<>();
		
		try {
			
			String[] querys = new String[25];	
			querys = Cls_Querys.LimpiaListaQuerys(querys);	
			querys = Cls_Querys.ObtieneQuerys(5, listaQuerys, querys);
			querys = inicializaQueryNumero5(querys, idEncuesta,cdo);
			pstm = connBD.prepareStatement("{call " + "DCH.usp_EXECUTE_QUERY(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			rs=  Cls_Querys.EjecutarQuery(querys[0], querys[1],querys[2], querys[3], querys[4], querys[5], querys[6],
														 querys[7], querys[8], querys[9],querys[10], querys[11], querys[12], querys[13], 
														 querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], 
														 querys[21], querys[22], querys[23], querys[24], "",pstm, connBD, infoUsu);
			
			
			Cls_Querys.ImprimeQuerysConsola(querys,false,"Query 5");
			
			ListAreas = llenaClaseAreas(rs, infoUsu);			
			InsertaLogEncuestas.insertarLog(new LogEncuestas(),cdo,cdo,"Entrada a consultar Areas Usuario: "+infoUsu.getCveUsuario()+" qry{"+Cls_Querys.regresaQuerys(querys,true)+"}",infoUsu.getCveUsuario());
		}catch(Exception ex)
		{
			InsertaLogEncuestas.insertarLog(new LogEncuestas(),cdo,cdo,"Error en el metodo consultaAreas de la clase GestorEvaluaciones. DETALLE: "+ex.getMessage().toString().replace("'", "")+" Usuario: "+infoUsu.getCveUsuario(),infoUsu.getCveUsuario());
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
				InsertaLogEncuestas.insertarLog(new LogEncuestas(),cdo,cdo,"ERROR al cerrar conexion en GestorEvaluacion.ConsultaAreas: " + e.toString().replace("'", "")+" Usuario: "+infoUsu.getCveUsuario(),infoUsu.getCveUsuario());
			}
		}
		return ListAreas;
	}
	
	private String[] inicializaQueryNumero5(String[] querys, String idEncuesta,String cdo) {
		for (int i=0;i <querys.length; i++)
		{	
			querys[i]=querys[i].replace("{ID_ENCUESTA}", String.valueOf(idEncuesta));
			switch(cdo) {
			case "cdf":
				querys[i]=querys[i].replace("{CDO}", String.valueOf("('cdf','cto','ac2','gdl','cq2')"));
				break;
			case "cd2":
				querys[i]=querys[i].replace("{CDO}", String.valueOf("('cd2','pc2','tug','oa2')"));
				break;
			case "cdl":
				querys[i]=querys[i].replace("{CDO}", String.valueOf("('cdl','slp','za2')"));
				break;
			case "cdm":
				querys[i]=querys[i].replace("{CDO}", String.valueOf("('cdm','dur')"));
				break;
			}
			
		}
		return querys;
	}
	private List<Areas> llenaClaseAreas(ResultSet rs, Usuario infoUsu) {
		List<Areas> ListAreas = new ArrayList<>();
		try
		{
			if(rs != null)
			{
				while(rs.next())
				{
					Areas area = new Areas();
					area.setIdArea(rs.getString("id_area"));
					area.setNivelArea(rs.getString("nivel_area"));
					area.setDescripcion(rs.getString("descripcion"));
					area.setEstatus(rs.getString("estatus"));
					area.setTotalEmpleados(rs.getInt("total_empleados"));
					area.setEmpleadosEvaluados(rs.getInt("empleados_evaluados"));
					area.setEmpleadosNoEvaluados(rs.getInt("empleados_no_evaluados"));
					area.setSubdptos(rs.getString("deptos"));
					ListAreas.add(area);
				}
			}			
		}
		catch(Exception ex)
		{
			InsertaLogEncuestas.insertarLog(new LogEncuestas(),infoUsu.getUname(),infoUsu.getUname(),"Error en el metodo llenaClaseAreas de la clase GestorEvaluaciones. DETALLE: "+ex.getMessage().toString().replace("'", "")+" Usuario: "+infoUsu.getCveUsuario(),infoUsu.getCveUsuario());
			//System.out.println("[Error: Obtener catalogo de sucursales,  Clase: GestorEvaluaciones.llenaClaseVacantes1,  Detalle: " + ex.getMessage().toString() +"]");
			 
		}
		return ListAreas;
	}
	public List<Empleados> consultaEmpleados(List<Querys> listaQuerys, String cdo, String idArea, Usuario infoUsu) {
		Connection connBD = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		connBD = ConexionBD.AbrirConexionBDD(cdo);	
		List<Empleados> ListEmple = new ArrayList<>();
		
		try {
			
			String[] querys = new String[25];	
			querys = Cls_Querys.LimpiaListaQuerys(querys);	
			querys = Cls_Querys.ObtieneQuerys(6, listaQuerys, querys);
			querys = inicializaQueryNumero6(querys, idArea, cdo);
			pstm = connBD.prepareStatement("{call " + "DCH.usp_EXECUTE_QUERY(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			rs=  Cls_Querys.EjecutarQuery(querys[0], querys[1],querys[2], querys[3], querys[4], querys[5], querys[6],
														 querys[7], querys[8], querys[9],querys[10], querys[11], querys[12], querys[13], 
														 querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], 
														 querys[21], querys[22], querys[23], querys[24], "",pstm, connBD, infoUsu);
			
			
			Cls_Querys.ImprimeQuerysConsola(querys,false,"Query 1");
			
			ListEmple = llenaClaseEmpleados(rs, infoUsu);			
			InsertaLogEncuestas.insertarLog(new LogEncuestas(),cdo,cdo,"Entrada a consultar Empleados Usuario: "+infoUsu.getCveUsuario()+" qry{"+Cls_Querys.regresaQuerys(querys,true)+"}",infoUsu.getCveUsuario());
			}catch(Exception ex)
		{
			InsertaLogEncuestas.insertarLog(new LogEncuestas(),cdo,cdo,"Error en el metodo ConsultaEmpleados de la clase GestorEvaluaciones. DETALLE: "+ex.getMessage().toString().replace("'", "")+" Usuario: "+infoUsu.getCveUsuario(),infoUsu.getCveUsuario());
			//System.out.println("Error - GestorEvaluaciones.ConsultaEmpleados:" + ex);
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
				InsertaLogEncuestas.insertarLog(new LogEncuestas(),cdo,cdo,"ERROR al cerrar conexion en GestorEvaluacion.ConsultaEmpleados: " + e.toString().replace("'", "")+" Usuario: "+infoUsu.getCveUsuario(),infoUsu.getCveUsuario());
				//System.out.println("ERROR al cerrar conexcion en GestorEvaluaciones.ConsultaEmpleados: " + e);
			}
		}
		return ListEmple;
	}
	private String[] inicializaQueryNumero6(String[] querys, String idArea, String cdo) {
		for (int i=0;i <querys.length; i++)
		{	
			querys[i]=querys[i].replace("{ID_AREA}", String.valueOf(idArea));
			switch(cdo) 
			{
			case "cdf":
				querys[i]=querys[i].replace("{CDO}", String.valueOf("('cdf','cto','ac2','gdl','cq2')"));
				break;
			case "cd2":
				querys[i]=querys[i].replace("{CDO}", String.valueOf("('cd2','pc2','tug','oa2')"));
				break;
			case "cdl":
				querys[i]=querys[i].replace("{CDO}", String.valueOf("('cdl','slp','za2')"));
				break;
			case "cdm":
				querys[i]=querys[i].replace("{CDO}", String.valueOf("('cdm','dur')"));
				break;
			}
			
		}
		return querys;
	}
	private List<Empleados> llenaClaseEmpleados(ResultSet rs, Usuario infoUsu) {
		List<Empleados> ListEmple = new ArrayList<>();
		try
		{
			if(rs != null)
			{
				while(rs.next())
				{
					Empleados emp = new Empleados();
					emp.setIdArea(rs.getString("id_area"));
					emp.setIdEmpleado(rs.getString("id_empleado"));
					emp.setNombre(rs.getString("nombre_completo"));
					emp.setIdPuesto(rs.getString("id_puesto"));
					emp.setNoEmpleado(rs.getString("no_empleado"));
					emp.setJerarquia(rs.getString("id_jerarquia"));
					emp.setNombreArea(rs.getString("area"));
					ListEmple.add(emp);
				}
			}			
		}
		catch(Exception ex)
		{
			InsertaLogEncuestas.insertarLog(new LogEncuestas(),infoUsu.getUname(),infoUsu.getUname(),"Error en el metodo llenaEmpleados de la clase GestorEvaluaciones. DETALLE: "+ex.getMessage().toString().replace("'", "")+" Usuario: "+infoUsu.getCveUsuario(),infoUsu.getCveUsuario());
			//System.out.println("[Error: Obtener catalogo de sucursales,  Clase: GestorEvaluaciones.llenaEmpleados,  Detalle: " + ex.getMessage().toString() +"]");
			 
		}
		return ListEmple;
	}
	public List<Empleados> consultaEmpleadosEv(List<Querys> listaQuerys, String cdo, String idJerarquia, String idArea, Usuario infoUsu) {
		Connection connBD = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		connBD = ConexionBD.AbrirConexionBDD(cdo);	
		List<Empleados> ListEmple = new ArrayList<>();
		
		try {
			
			String[] querys = new String[25];	
			querys = Cls_Querys.LimpiaListaQuerys(querys);	
			querys = Cls_Querys.ObtieneQuerys(7, listaQuerys, querys);
			querys = inicializaQueryNumero8(querys, idJerarquia,idArea,cdo);
			pstm = connBD.prepareStatement("{call " + "DCH.usp_EXECUTE_QUERY(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			rs=  Cls_Querys.EjecutarQuery(querys[0], querys[1],querys[2], querys[3], querys[4], querys[5], querys[6],
														 querys[7], querys[8], querys[9],querys[10], querys[11], querys[12], querys[13], 
														 querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], 
														 querys[21], querys[22], querys[23], querys[24], "",pstm, connBD, infoUsu);
			
			
			Cls_Querys.ImprimeQuerysConsola(querys,false,"Query 1");
			
			ListEmple = llenaClaseEmpleados(rs, infoUsu);			
			InsertaLogEncuestas.insertarLog(new LogEncuestas(),cdo,cdo,"Entrada a consultar EmpleadosEv Usuario: "+infoUsu.getCveUsuario()+" qry{"+Cls_Querys.regresaQuerys(querys,true)+"}",infoUsu.getCveUsuario());
		}catch(Exception ex)
		{
			InsertaLogEncuestas.insertarLog(new LogEncuestas(),cdo,cdo,"Error en el metodo consultaEmpleadosEv de la clase GestorEvaluaciones. DETALLE: "+ex.getMessage().toString().replace("'", "")+" Usuario: "+infoUsu.getCveUsuario(),infoUsu.getCveUsuario());  
			//System.out.println("Error - GestorEvaluaciones.ConsultaVacantes:" + ex);
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
				InsertaLogEncuestas.insertarLog(new LogEncuestas(),cdo,cdo,"ERROR al cerrar conexion en GestorEvaluacion.ConsultaEmpleadosEv: " + e.toString().replace("'", "")+" Usuario: "+infoUsu.getCveUsuario(),infoUsu.getCveUsuario());
			}
		}
		return ListEmple;
	}
	private String[] inicializaQueryNumero7(String[] querys, String idJerarquia, String idArea, String idEvaluado,String cdo) {
		for (int i=0;i <querys.length; i++)
		{	
			querys[i]=querys[i].replace("{ID_JERARQUIA}", String.valueOf(idJerarquia));
			querys[i]=querys[i].replace("{ID_AREA}", String.valueOf(idArea));
			querys[i]=querys[i].replace("{ID_EMPLEADO}", String.valueOf(idEvaluado));
			switch(cdo) 
			{
			case "cdf":
				querys[i]=querys[i].replace("{CDO}", String.valueOf("('cdf','cto','ac2','gdl','cq2')"));
				break;
			case "cd2":
				querys[i]=querys[i].replace("{CDO}", String.valueOf("('cd2','pc2','tug','oa2')"));
				break;
			case "cdl":
				querys[i]=querys[i].replace("{CDO}", String.valueOf("('cdl','slp','za2')"));
				break;
			case "cdm":
				querys[i]=querys[i].replace("{CDO}", String.valueOf("('cdm','dur')"));
				break;
			}
		}
		return querys;
	}
	public List<Empleados> consultaEmpleadosEvS(List<Querys> listaQuerys, String cdo, String idJerarquia,
			String idArea, Usuario infoUsu) {
		Connection connBD = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		connBD = ConexionBD.AbrirConexionBDD(cdo);	
		List<Empleados> ListEmple = new ArrayList<>();
		
		try {
			
			String[] querys = new String[25];	
			querys = Cls_Querys.LimpiaListaQuerys(querys);	
			querys = Cls_Querys.ObtieneQuerys(8, listaQuerys, querys);
			querys = inicializaQueryNumero8(querys, idJerarquia,idArea,cdo);
			pstm = connBD.prepareStatement("{call " + "DCH.usp_EXECUTE_QUERY(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			rs=  Cls_Querys.EjecutarQuery(querys[0], querys[1],querys[2], querys[3], querys[4], querys[5], querys[6],
														 querys[7], querys[8], querys[9],querys[10], querys[11], querys[12], querys[13], 
														 querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], 
														 querys[21], querys[22], querys[23], querys[24], "",pstm, connBD, infoUsu);
			
			
			Cls_Querys.ImprimeQuerysConsola(querys,false,"Query 1");
			
			ListEmple = llenaClaseEmpleados(rs, infoUsu);			
			InsertaLogEncuestas.insertarLog(new LogEncuestas(),cdo,cdo,"Entrada a consultar consultaEmpleadosEvS Usuario: "+infoUsu.getCveUsuario()+" qry{"+Cls_Querys.regresaQuerys(querys,true)+"}",infoUsu.getCveUsuario());
		}catch(Exception ex)
		{	
			InsertaLogEncuestas.insertarLog(new LogEncuestas(),cdo,cdo,"Error en el metodo consultaEmpleadosEvS de la clase GestorEvaluaciones. DETALLE: "+ex.getMessage().toString().replace("'", "")+" Usuario: "+infoUsu.getCveUsuario(),infoUsu.getCveUsuario());  
			//System.out.println("Error - GestorEvaluaciones.ConsultaVacantes:" + ex);
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
				InsertaLogEncuestas.insertarLog(new LogEncuestas(),cdo,cdo,"ERROR al cerrar conexion en GestorEvaluacion.ConsultaEmpleadosS: " + e.toString().replace("'", "")+" Usuario: "+infoUsu.getCveUsuario(),infoUsu.getCveUsuario());
				//System.out.println("ERROR al cerrar conexcion en GestorEvaluaciones.ConsultaEmpleados: " + e);
			}
		}
		return ListEmple;
	}
	private String[] inicializaQueryNumero8(String[] querys, String idJerarquia, String idArea,String cdo) {
		for (int i=0;i <querys.length; i++)
		{	
			querys[i]=querys[i].replace("{ID_JERARQUIA}", String.valueOf(idJerarquia));
			querys[i]=querys[i].replace("{ID_AREA}", String.valueOf(idArea));
			switch(cdo) 
			{
			case "cdf":
				querys[i]=querys[i].replace("{CDO}", String.valueOf("('cdf','cto','ac2','gdl','cq2')"));
				break;
			case "cd2":
				querys[i]=querys[i].replace("{CDO}", String.valueOf("('cd2','pc2','tug','oa2')"));
				break;
			case "cdl":
				querys[i]=querys[i].replace("{CDO}", String.valueOf("('cdl','slp','za2')"));
				break;
			case "cdm":
				querys[i]=querys[i].replace("{CDO}", String.valueOf("('cdm','dur')"));
				break;
			}
		}
		return querys;
	}
	public List<Empleados> consultaEmpleadosEvC(List<Querys> listaQuerys, String cdo, String idJerarquia,
			String idArea, String idEvaluado, Usuario infoUsu) {
		Connection connBD = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		connBD = ConexionBD.AbrirConexionBDD(cdo);	
		List<Empleados> ListEmple = new ArrayList<>();
		
		try {
			
			String[] querys = new String[25];	
			querys = Cls_Querys.LimpiaListaQuerys(querys);	
			querys = Cls_Querys.ObtieneQuerys(9, listaQuerys, querys);
			querys = inicializaQueryNumero7(querys, idJerarquia,idArea,idEvaluado,cdo);
			pstm = connBD.prepareStatement("{call " + "DCH.usp_EXECUTE_QUERY(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			rs=  Cls_Querys.EjecutarQuery(querys[0], querys[1],querys[2], querys[3], querys[4], querys[5], querys[6],
														 querys[7], querys[8], querys[9],querys[10], querys[11], querys[12], querys[13], 
														 querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], 
														 querys[21], querys[22], querys[23], querys[24], "",pstm, connBD, infoUsu);
			
			
			Cls_Querys.ImprimeQuerysConsola(querys,false,"Query 1");
			
			ListEmple = llenaClaseEmpleados(rs, infoUsu);			
			InsertaLogEncuestas.insertarLog(new LogEncuestas(),cdo,cdo,"Entrada a consultar EmpleadosEvC Usuario: "+infoUsu.getCveUsuario()+" qry{"+Cls_Querys.regresaQuerys(querys,true)+"}",infoUsu.getCveUsuario());
		}catch(Exception ex)
		{	
			InsertaLogEncuestas.insertarLog(new LogEncuestas(),cdo,cdo,"Error en el metodo consultaEmpleadosEvC de la clase GestorEvaluaciones. DETALLE: "+ex.getMessage().toString().replace("'", "")+" Usuario: "+infoUsu.getCveUsuario(),infoUsu.getCveUsuario());  
			//System.out.println("Error - GestorEvaluaciones.ConsultaVacantes:" + ex);
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
				InsertaLogEncuestas.insertarLog(new LogEncuestas(),cdo,cdo,"ERROR al cerrar conexion en GestorEvaluacion.ConsultaEmpleadosEvC: " + e.toString().replace("'", "")+" Usuario: "+infoUsu.getCveUsuario(),infoUsu.getCveUsuario());
				//System.out.println("ERROR al cerrar conexcion en GestorEvaluaciones.ConsultaEmpleados: " + e);
			}
		}
		return ListEmple;
	}
	public List<Empleados> consultaEmpleadosEC(List<Querys> listaQuerys, String cdo, String idArea, String idEvaluado, Usuario infoUsu) {
		Connection connBD = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		connBD = ConexionBD.AbrirConexionBDD(cdo);	
		List<Empleados> ListEmple = new ArrayList<>();
		
		try {
			
			String[] querys = new String[25];	
			querys = Cls_Querys.LimpiaListaQuerys(querys);	
			querys = Cls_Querys.ObtieneQuerys(10, listaQuerys, querys);
			querys = inicializaQueryNumero10(querys, idArea, idEvaluado,cdo);
			pstm = connBD.prepareStatement("{call " + "DCH.usp_EXECUTE_QUERY(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			rs=  Cls_Querys.EjecutarQuery(querys[0], querys[1],querys[2], querys[3], querys[4], querys[5], querys[6],
														 querys[7], querys[8], querys[9],querys[10], querys[11], querys[12], querys[13], 
														 querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], 
														 querys[21], querys[22], querys[23], querys[24], "",pstm, connBD, infoUsu);
			
			
			Cls_Querys.ImprimeQuerysConsola(querys,false,"Query 1");
			
			ListEmple = llenaClaseEmpleados(rs, infoUsu);			
			InsertaLogEncuestas.insertarLog(new LogEncuestas(),cdo,cdo,"Entrada a consultar EmpleadosEC Usuario: "+infoUsu.getCveUsuario()+" qry{"+Cls_Querys.regresaQuerys(querys,true)+"}",infoUsu.getCveUsuario());
		}catch(Exception ex)
		{
			InsertaLogEncuestas.insertarLog(new LogEncuestas(),cdo,cdo,"Error en el metodo consultaEmpleadosEC de la clase GestorEvaluaciones. DETALLE: "+ex.getMessage().toString().replace("'", "")+" Usuario: "+infoUsu.getCveUsuario(),infoUsu.getCveUsuario()); 
			//System.out.println("Error - GestorEvaluaciones.ConsultaVacantes:" + ex);
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
				InsertaLogEncuestas.insertarLog(new LogEncuestas(),cdo,cdo,"ERROR al cerrar conexion en GestorEvaluacion.ConsultaEmpleadosEC: " + e.toString().replace("'", "")+" Usuario: "+infoUsu.getCveUsuario(),infoUsu.getCveUsuario());
				//System.out.println("ERROR al cerrar conexcion en GestorEvaluaciones.ConsultaEmpleados: " + e);
			}
		}
		return ListEmple;
	}
	private String[] inicializaQueryNumero10(String[] querys, String idArea, String idEvaluado,String cdo) {
		for (int i=0;i <querys.length; i++)
		{	
			querys[i]=querys[i].replace("{ID_AREA}", String.valueOf(idArea));
			querys[i]=querys[i].replace("{ID_EMPLEADO}", String.valueOf(idEvaluado));
		switch(cdo) 
		{
		case "cdf":
			querys[i]=querys[i].replace("{CDO}", String.valueOf("('cdf','cto','ac2','gdl','cq2')"));
			break;
		case "cd2":
			querys[i]=querys[i].replace("{CDO}", String.valueOf("('cd2','pc2','tug','oa2')"));
			break;
		case "cdl":
			querys[i]=querys[i].replace("{CDO}", String.valueOf("('cdl','slp','za2')"));
			break;
		case "cdm":
			querys[i]=querys[i].replace("{CDO}", String.valueOf("('cdm','dur')"));
			break;
		}
		}
		return querys;
	}
	public List<Evaluado> consultaEvaluados(List<Querys> listaQuerys, String cdo, String idArea, String idEncuesta, String depto, Usuario infoUsu) {
		Connection connBD = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		connBD = ConexionBD.AbrirConexionBDD(cdo);	
		List<Evaluado> ListEmple = new ArrayList<>();
		
		try {
			
			String[] querys = new String[25];	
			querys = Cls_Querys.LimpiaListaQuerys(querys);	
			querys = Cls_Querys.ObtieneQuerys(11, listaQuerys, querys);
			querys = inicializaQueryNumero11(querys, idArea, idEncuesta,depto, cdo);
			pstm = connBD.prepareStatement("{call " + "DCH.usp_EXECUTE_QUERY(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			rs=  Cls_Querys.EjecutarQuery(querys[0], querys[1],querys[2], querys[3], querys[4], querys[5], querys[6],
														 querys[7], querys[8], querys[9],querys[10], querys[11], querys[12], querys[13], 
														 querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], 
														 querys[21], querys[22], querys[23], querys[24], "",pstm, connBD, infoUsu);
			
			
			Cls_Querys.ImprimeQuerysConsola(querys,false,"Query 11");
			
			ListEmple = llenaClaseEvaluados(rs, infoUsu);			
			InsertaLogEncuestas.insertarLog(new LogEncuestas(),cdo,cdo,"Entrada a consultar Evaluados Usuario: "+infoUsu.getCveUsuario()+" qry{"+Cls_Querys.regresaQuerys(querys,true)+"}",infoUsu.getCveUsuario());
		}catch(Exception ex)
		{
			InsertaLogEncuestas.insertarLog(new LogEncuestas(),cdo,cdo,"Error en el metodo consultaEvaluados de la clase GestorEvaluaciones. DETALLE: "+ex.getMessage().toString().replace("'", "")+" Usuario: "+infoUsu.getCveUsuario(),infoUsu.getCveUsuario());  
			//System.out.println("Error - GestorEvaluaciones.ConsultaVacantes:" + ex);
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
				InsertaLogEncuestas.insertarLog(new LogEncuestas(),cdo,cdo,"ERROR al cerrar conexion en GestorEvaluacion.consultaEvaluados: " + e.toString().replace("'", "")+" Usuario: "+infoUsu.getCveUsuario(),infoUsu.getCveUsuario());
				//System.out.println("ERROR al cerrar conexcion en GestorEvaluaciones.ConsultaEmpleados: " + e);
			}
		}
		return ListEmple;
	}
	private String[] inicializaQueryNumero11(String[] querys, String idArea, String idEncuesta, String depto,String cdo) {
		for (int i=0;i <querys.length; i++)
		{	
			if(depto.length() == 0 || depto==" ") {
				querys[i]=querys[i].replace("{ID_DEPTO}", " ");
			}else {
				querys[i]=querys[i].replace("{ID_DEPTO}", " AND b.id_depto="+depto);
			}
			querys[i]=querys[i].replace("{ID_ENCUESTA}", String.valueOf(idEncuesta));
			querys[i]=querys[i].replace("{ID_AREA}", String.valueOf(idArea));
			switch(cdo) {
			case "cdf":
				querys[i]=querys[i].replace("{CDO}", String.valueOf("('cdf','cto','ac2','gdl','cq2')"));
				break;
			case "cd2":
				querys[i]=querys[i].replace("{CDO}", String.valueOf("('cd2','pc2','tug','oa2')"));
				break;
			case "cdl":
				querys[i]=querys[i].replace("{CDO}", String.valueOf("('cdl','slp','za2')"));
				break;
			case "cdm":
				querys[i]=querys[i].replace("{CDO}", String.valueOf("('cdm','dur')"));
				break;
			}
		}
		return querys;
	}
	private List<Evaluado> llenaClaseEvaluados(ResultSet rs, Usuario infoUsu) {
		List<Evaluado> ListEmple = new ArrayList<>();
		int fila=0;
		
		List<String> nombres=new ArrayList<String>();
		String comodin="";
		try
		{
			if(rs != null)
			{
				while(rs.next())
				{
					fila++;
					Evaluado ev = new Evaluado();
					ev.setIdEmpleado(rs.getString("id_empleado"));
					ev.setArea(rs.getString("Area"));
					ev.setNombreEvaluado(rs.getString("Nombre_Evaluado"));
					nombres.add(rs.getString("Nombre_Evaluado"));
					comodin=ponerId(rs.getString("Jefe_Inmediato"), fila, nombres, rs.getString("Nombre_Evaluado"), 1);
					ev.setJefeInmediato(comodin);
					comodin=ponerId(rs.getString("Colega"), fila, nombres, rs.getString("Nombre_Evaluado"), 3);
					ev.setColega(comodin);
					comodin=ponerId(rs.getString("Subordinado"), fila, nombres, rs.getString("Nombre_Evaluado"), 2);
					ev.setSubordinado(comodin);
					comodin=ponerId(rs.getString("Cliente"), fila, nombres, rs.getString("Nombre_Evaluado"), 4);
					ev.setCliente(comodin);
					ListEmple.add(ev);
				}
			}			
		}
		catch(Exception ex)
		{
			InsertaLogEncuestas.insertarLog(new LogEncuestas(),infoUsu.getUname(),infoUsu.getUname(),"Error en el metodo llenaClaseEvaluados de la clase GestorEvaluaciones. DETALLE: "+ex.getMessage().toString().replace("'", "")+" Usuario: "+infoUsu.getCveUsuario(),infoUsu.getCveUsuario());
		//	System.out.println("[Error: Obtener catalogo de sucursales,  Clase: GestorEvaluaciones.llenaEmpleados,  Detalle: " + ex.getMessage().toString() +"]");
			 
		}
		return ListEmple;
	}
	private String ponerId(String cadena, int fila, List<String> nombres, String nombre, int j) {
		String comodin=cadena.replace("*","<br><input type='hidden' id='*' value='");
		comodin=comodin.replace("*",""+fila+"-/-"+j);
		for(int i=0;i<comodin.length();i++) {
			if(nombres.get(fila-1)!=nombre||nombres.isEmpty()) {
					comodin=comodin.replaceFirst("/", ""+(i+1)+"");
					}
				}
		return comodin;
		
	}
	public List<Evaluado> guardaEvaluacion(List<Querys> listaQuerys, String cdo, String idEvaluado, String idEvaluador,
			String pColaborador, String idEncuesta, Usuario infoUsu) {
		Connection connBD = null;
		PreparedStatement pstm = null;
		connBD = ConexionBD.AbrirConexionBDD(cdo);	
		List<Evaluado> ListEmple = new ArrayList<>();
		
		try {
			
			String[] querys = new String[25];	
			querys = Cls_Querys.LimpiaListaQuerys(querys);	
			querys = Cls_Querys.ObtieneQuerys(12, listaQuerys, querys);
			querys = inicializaQueryNumero12(querys, idEvaluado, idEvaluador,pColaborador,idEncuesta);
			pstm = connBD.prepareStatement("{call " + "DCH.usp_EXECUTE_QUERY(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			 Cls_Querys.EjecutarQuery(querys[0], querys[1],querys[2], querys[3], querys[4], querys[5], querys[6],
														 querys[7], querys[8], querys[9],querys[10], querys[11], querys[12], querys[13], 
														 querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], 
														 querys[21], querys[22], querys[23], querys[24], "",pstm, connBD,infoUsu);
			
			
			Cls_Querys.ImprimeQuerysConsola(querys,false,"Query 12");
			
			ListEmple.add(new Evaluado());			
			InsertaLogEncuestas.insertarLog(new LogEncuestas(),cdo,cdo,"Guadando metodo guardaEvaluacion Usuario: "+infoUsu.getCveUsuario()+" qry{"+Cls_Querys.regresaQuerys(querys,true)+"}",infoUsu.getCveUsuario());
		}catch(Exception ex)
		{
			InsertaLogEncuestas.insertarLog(new LogEncuestas(),cdo,cdo,"Error en el metodo guardaEvaluacion de la clase GestorEvaluaciones. DETALLE: "+ex.getMessage().toString().replace("'", "")+" Usuario: "+infoUsu.getCveUsuario(),infoUsu.getCveUsuario());  
			//System.out.println("Error - GestorEvaluaciones.ConsultaVacantes:" + ex);
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
				InsertaLogEncuestas.insertarLog(new LogEncuestas(),cdo,cdo,"ERROR al cerrar conexion en GestorEvaluacion.guadaEvaluacion: " + e.toString().replace("'", "")+" Usuario: "+infoUsu.getCveUsuario(),infoUsu.getCveUsuario());
				//System.out.println("ERROR al cerrar conexcion en GestorEvaluaciones.ConsultaEmpleados: " + e);
			}
		}
		return ListEmple;
	}
	private String[] inicializaQueryNumero12(String[] querys, String idEvaluado, String idEvaluador,
			String pColaborador, String idEncuesta) {
		for (int i=0;i <querys.length; i++)
		{	
			querys[i]=querys[i].replace("{ID_EVALUADO}", String.valueOf(idEvaluado));
			querys[i]=querys[i].replace("{ID_EVALUADOR}", String.valueOf(idEvaluador));
			querys[i]=querys[i].replace("{PERFIL_COLABORADOR}", String.valueOf(pColaborador));
			querys[i]=querys[i].replace("{ID_ENCUESTA}", String.valueOf(idEncuesta));
		}
		return querys;
	}
	public List<Evaluado> borraEvaluacion(List<Querys> listaQuerys, String cdo, String idEvaluado, Usuario infoUsu, String idEncuesta) {{
			Connection connBD = null;
			PreparedStatement pstm = null;
			connBD = ConexionBD.AbrirConexionBDD(cdo);	
			List<Evaluado> ListEmple = new ArrayList<>();
			
			try {
				
				String[] querys = new String[25];	
				querys = Cls_Querys.LimpiaListaQuerys(querys);	
				querys = Cls_Querys.ObtieneQuerys(14, listaQuerys, querys);
				querys = inicializaQueryNumero14(querys, idEvaluado,idEncuesta);
				pstm = connBD.prepareStatement("{call " + "DCH.usp_EXECUTE_QUERY(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
				Cls_Querys.EjecutarQuery(querys[0], querys[1],querys[2], querys[3], querys[4], querys[5], querys[6],
															 querys[7], querys[8], querys[9],querys[10], querys[11], querys[12], querys[13], 
															 querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], 
															 querys[21], querys[22], querys[23], querys[24], "",pstm, connBD, infoUsu);
				
				
				Cls_Querys.ImprimeQuerysConsola(querys,false,"Query 12");
				ListEmple.add(new Evaluado());			
				InsertaLogEncuestas.insertarLog(new LogEncuestas(),cdo,cdo,"Borrado evaluacion en el metodo borraEvaluacion Usuario: "+infoUsu.getCveUsuario()+" qry{"+Cls_Querys.regresaQuerys(querys,true)+"}",infoUsu.getCveUsuario());
			}catch(Exception ex)
			{
				InsertaLogEncuestas.insertarLog(new LogEncuestas(),cdo,cdo,"Error en el metodo borraEvaluacion de la clase GestorEvaluaciones. DETALLE: "+ex.getMessage().toString().replace("'", "")+" Usuario: "+infoUsu.getCveUsuario(),infoUsu.getCveUsuario());  
				//System.out.println("Error - GestorEvaluaciones.ConsultaVacantes:" + ex);
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
					InsertaLogEncuestas.insertarLog(new LogEncuestas(),cdo,cdo,"ERROR al cerrar conexion en GestorEvaluacion.borraEvaluacion: " + e.toString().replace("'", "")+" Usuario: "+infoUsu.getCveUsuario(),infoUsu.getCveUsuario());
					//System.out.println("ERROR al cerrar conexcion en GestorEvaluaciones.ConsultaEmpleados: " + e);
				}
			}
			return ListEmple;
	}
}
	private String[] inicializaQueryNumero14(String[] querys, String idEvaluado, String idEncuesta) {
		for (int i=0;i <querys.length; i++)
		{	
			querys[i]=querys[i].replace("{ID_EVALUADO}", String.valueOf(idEvaluado));
			querys[i]=querys[i].replace("{ID_ENCUESTA}", String.valueOf(idEncuesta));
		}
		return querys;
	}
	public Correo enviarCorreo(List<Querys> listaQuerys, String cdo, String idEmpleado, Usuario infoUsu) {
		Connection connBD = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		connBD = ConexionBD.AbrirConexionBDD(cdo);	
		Correo correo = new Correo();
		
		try {
			
			String[] querys = new String[25];	
			querys = Cls_Querys.LimpiaListaQuerys(querys);	
			querys = Cls_Querys.ObtieneQuerys(15, listaQuerys, querys);
			querys = inicializaQueryNumero15(querys, idEmpleado);
			pstm = connBD.prepareStatement("{call " + "DCH.usp_EXECUTE_QUERY(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			rs=  Cls_Querys.EjecutarQuery(querys[0], querys[1],querys[2], querys[3], querys[4], querys[5], querys[6],
														 querys[7], querys[8], querys[9],querys[10], querys[11], querys[12], querys[13], 
														 querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], 
														 querys[21], querys[22], querys[23], querys[24], "",pstm, connBD,infoUsu);
			
			
			Cls_Querys.ImprimeQuerysConsola(querys,false,"Query 15");
			
			correo=llenaCorreo(rs, infoUsu);
			InsertaLogEncuestas.insertarLog(new LogEncuestas(),cdo,cdo,"Envio de correos  Usuario: "+infoUsu.getCveUsuario()+" qry{"+Cls_Querys.regresaQuerys(querys,true)+"}",infoUsu.getCveUsuario());
		}catch(Exception ex)
		{
			InsertaLogEncuestas.insertarLog(new LogEncuestas(),cdo,cdo,"Error en el metodo enviarCorreo de la clase GestorEvaluaciones. DETALLE: "+ex.getMessage().toString().replace("'", "")+" Usuario: "+infoUsu.getCveUsuario(),infoUsu.getCveUsuario());  
			//System.out.println("Error - GestorEvaluaciones.ConsultaVacantes:" + ex);
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
				InsertaLogEncuestas.insertarLog(new LogEncuestas(),cdo,cdo,"ERROR al cerrar conexion en GestorEvaluacion.enviarCorreo: " + e.toString().replace("'", "")+" Usuario: "+infoUsu.getCveUsuario(),infoUsu.getCveUsuario());
				//System.out.println("ERROR al cerrar conexcion en GestorEvaluaciones.ConsultaEmpleados: " + e);
			}
		}
		return correo;
	}
	private Correo llenaCorreo(ResultSet rs, Usuario infoUsu) {
		Correo correo = new Correo();
		try
		{
			if(rs != null)
			{
				while(rs.next()) {
					correo.setDestinatario(rs.getString("email1"));
					correo.setCuerpo(rs.getString("cuerpo"));
					correo.setEstatus(rs.getInt("estatus_correo"));
				}
			}			
		}
		catch(Exception ex)
		{
			InsertaLogEncuestas.insertarLog(new LogEncuestas(),infoUsu.getUname(),infoUsu.getUname(),"Error en el metodo llenaCorreo de la clase GestorEvaluaciones. DETALLE: "+ex.getMessage().toString().replace("'", "")+" Usuario: "+infoUsu.getCveUsuario(),infoUsu.getCveUsuario());
			//System.out.println("[Error: Obtener catalogo de sucursales,  Clase: GestorEvaluaciones.llenaCorreo,  Detalle: " + ex.getMessage().toString() +"]");
			 
		}
		return correo;
	}
	private String[] inicializaQueryNumero15(String[] querys, String idEmpleado) {
		for (int i=0;i <querys.length; i++)
		{	
			querys[i]=querys[i].replace("{ID_EMPLEADO}", String.valueOf(idEmpleado));
		}
		return querys;
	}
	public int consultaNumEvaluaciones(List<Querys> listaQuerys, String cdo, Usuario infoUsu) {
		Connection connBD = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		connBD = ConexionBD.AbrirConexionBDD(cdo);	
		int numEncuestas = 0;
		
		try {
			
			String[] querys = new String[25];	
			querys = Cls_Querys.LimpiaListaQuerys(querys);	
			querys = Cls_Querys.ObtieneQuerys(35, listaQuerys, querys);
			pstm = connBD.prepareStatement("{call " + "DCH.usp_EXECUTE_QUERY(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			rs=  Cls_Querys.EjecutarQuery(querys[0], querys[1],querys[2], querys[3], querys[4], querys[5], querys[6],
														 querys[7], querys[8], querys[9],querys[10], querys[11], querys[12], querys[13], 
														 querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], 
														 querys[21], querys[22], querys[23], querys[24], "",pstm, connBD,infoUsu);
			
			
			Cls_Querys.ImprimeQuerysConsola(querys,false,"Query 35");
			while(rs.next()) {
				numEncuestas=rs.getInt("numEncuestas");
			}
			InsertaLogEncuestas.insertarLog(new LogEncuestas(),cdo,cdo,"Envio de correos  Usuario: "+infoUsu.getCveUsuario()+" qry{"+Cls_Querys.regresaQuerys(querys,true)+"}",infoUsu.getCveUsuario());
		}catch(Exception ex)
		{
			InsertaLogEncuestas.insertarLog(new LogEncuestas(),cdo,cdo,"Error en el metodo enviarCorreo de la clase GestorEvaluaciones. DETALLE: "+ex.getMessage().toString().replace("'", "")+" Usuario: "+infoUsu.getCveUsuario(),infoUsu.getCveUsuario());  
			//System.out.println("Error - GestorEvaluaciones.ConsultaVacantes:" + ex);
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
				InsertaLogEncuestas.insertarLog(new LogEncuestas(),cdo,cdo,"ERROR al cerrar conexion en GestorEvaluacion.enviarCorreo: " + e.toString().replace("'", "")+" Usuario: "+infoUsu.getCveUsuario(),infoUsu.getCveUsuario());
				//System.out.println("ERROR al cerrar conexcion en GestorEvaluaciones.ConsultaEmpleados: " + e);
			}
		}
		return numEncuestas;
	}
	public static boolean generaNuevaEncuesta(List<Querys> listaQuerys, String cdo, Usuario infoUsu,
			String numEncuestas, String nombre, String fechaFin,String idEvaluacion) {
		Connection connBD = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		connBD = ConexionBD.AbrirConexionBDD(cdo);	
		boolean ListRespuesta = false;
		//System.out.print(infoUsu);
		try {
			
			String[] querys = new String[25];	
			querys = Cls_Querys.LimpiaListaQuerys(querys);	
			querys = Cls_Querys.ObtieneQuerys(36, listaQuerys, querys);
			querys = inicializaQueryNumero36(querys,numEncuestas,idEvaluacion,fechaFin,nombre,cdo);
			pstm = connBD.prepareStatement("{call " + "DCH.usp_EXECUTE_QUERY(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			rs=  Cls_Querys.EjecutarQuery(querys[0], querys[1],querys[2], querys[3], querys[4], querys[5], querys[6],
														 querys[7], querys[8], querys[9],querys[10], querys[11], querys[12], querys[13], 
														 querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], 
														 querys[21], querys[22], querys[23], querys[24], "",pstm, connBD,infoUsu);
			
			//System.out.print(infoUsu);
			Cls_Querys.ImprimeQuerysConsola(querys,false,"Query 36");
			
			ListRespuesta=true;		
			InsertaLogEncuestas.insertarLog(new LogEncuestas(),cdo,cdo,"Entrada a consultar area resultados Detalle Usuario: "+infoUsu.getCveUsuario()+"qry{"+Cls_Querys.regresaQuerys(querys,true)+"}",infoUsu.getCveUsuario());
		}catch(Exception ex)
		{
			InsertaLogEncuestas.insertarLog(new LogEncuestas(),cdo,cdo,"Error en el metodo consultaEmpleado de la clase GestorResultados.consultaAreas DETALLE: "+ex.getMessage().toString().replace("'", "")+" Usuario: "+infoUsu.getCveUsuario(),infoUsu.getCveUsuario());
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
				InsertaLogEncuestas.insertarLog(new LogEncuestas(),cdo,cdo,"ERROR al cerrar conexion en GestorResultados.consultaAreas: " + e.toString().replace("'", "")+" Usuario: "+infoUsu.getCveUsuario(),infoUsu.getCveUsuario());
			}
		}
		return ListRespuesta;
	}
	private static String[] inicializaQueryNumero36(String[] querys, String numEncuestas, String idEvaluacion, String fechaFin,String nombre,String cdo) {
		for (int i=0;i <querys.length; i++)
		{	
			querys[i]=querys[i].replace("{NUM_ENCUESTA}", String.valueOf(numEncuestas));
			querys[i]=querys[i].replace("{ID_EVALUACION}", String.valueOf(idEvaluacion));
			querys[i]=querys[i].replace("{FECHA_FIN}", String.valueOf(fechaFin));
			querys[i]=querys[i].replace("{NOMBRE}", String.valueOf(nombre));
			querys[i]=querys[i].replace("{CDO2}", String.valueOf(cdo));
			switch(cdo) {
			case "cdf":
				querys[i]=querys[i].replace("{CDO}", String.valueOf("('cdf','cto','ac2','gdl','cq2')"));
				break;
			case "cd2":
				querys[i]=querys[i].replace("{CDO}", String.valueOf("('cd2','pc2','tug','oa2')"));
				break;
			case "cdl":
				querys[i]=querys[i].replace("{CDO}", String.valueOf("('cdl','slp','za2')"));
				break;
			case "cdm":
				querys[i]=querys[i].replace("{CDO}", String.valueOf("('cdm','dur')"));
				break;
			}
			
		}
		return querys;
	}
}