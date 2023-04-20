package Persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Datos.Areas;
import Datos.LogEncuestas;
import Datos.Preguntas;
import Datos.Querys;
import Datos.RespuestaEmp;
import Datos.ResultadoAreas;
import Datos.Usuario;
import Util.Cls_Querys;
import Util.ConexionBD;
import Util.InsertaLogEncuestas;

public class GestorResultados {

	public static List<RespuestaEmp> consultaEmpleado1(List<Querys> listaQuerys, String cdo,
			Usuario infoUsu) {
		Connection connBD = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		connBD = ConexionBD.AbrirConexionBDD(cdo);	
		List<RespuestaEmp> ListRespuesta = new ArrayList<>();
		//System.out.print(infoUsu);
		try {
			
			String[] querys = new String[25];	
			querys = Cls_Querys.LimpiaListaQuerys(querys);	
			
			querys = Cls_Querys.ObtieneQuerys(18, listaQuerys, querys);
			querys = inicializaQueryNumero18(querys, cdo);
			pstm = connBD.prepareStatement("{call " + "DCH.usp_EXECUTE_QUERY(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			rs=  Cls_Querys.EjecutarQuery(querys[0], querys[1],querys[2], querys[3], querys[4], querys[5], querys[6],
														 querys[7], querys[8], querys[9],querys[10], querys[11], querys[12], querys[13], 
														 querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], 
														 querys[21], querys[22], querys[23], querys[24], "",pstm, connBD,infoUsu);
			
			//System.out.print(infoUsu);
			Cls_Querys.ImprimeQuerysConsola(querys,true,"Query 18");
			
			ListRespuesta = llenaClaseResultadosEmpDetalle(rs, infoUsu);			
			InsertaLogEncuestas.insertarLog(new LogEncuestas(),cdo,cdo,"Entrada a consultar empleados resultados Detalle Usuario: "+infoUsu.getCveUsuario()+"qry{"+Cls_Querys.regresaQuerys(querys,true)+"}",infoUsu.getCveUsuario());
		}catch(Exception ex)
		{
			InsertaLogEncuestas.insertarLog(new LogEncuestas(),cdo,cdo,"Error en el metodo consultaEmpleado de la clase GestorResultados. DETALLE: "+ex.getMessage().toString().replace("'", "")+" Usuario: "+infoUsu.getCveUsuario(),infoUsu.getCveUsuario());
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
				InsertaLogEncuestas.insertarLog(new LogEncuestas(),cdo,cdo,"ERROR al cerrar conexion en GestorResultados.consultaEmpleado: " + e.toString().replace("'", "")+" Usuario: "+infoUsu.getCveUsuario(),infoUsu.getCveUsuario());
			}
		}
		return ListRespuesta;
	}

	private static String[] inicializaQueryNumero18(String[] querys, String cdo) {
		for (int i=0;i <querys.length; i++)
		{	
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
		}return querys;
	}

	private static List<RespuestaEmp> llenaClaseResultadosEmpDetalle(ResultSet rs, Usuario infoUsu) {
		List<RespuestaEmp> ListRespuesta= new ArrayList<>();
		try
		{
			if(rs != null)
			{
				while(rs.next())
				{
					RespuestaEmp resultado = new RespuestaEmp();
					resultado.setNombre(rs.getString("nombre_completo"));
					resultado.setPuesto(rs.getString("puesto"));
					resultado.setPromedio(rs.getDouble("promedio"));
					ListRespuesta.add(resultado);
				}
			}			
		}
		catch(Exception e)
		{
			InsertaLogEncuestas.insertarLog(new LogEncuestas(),infoUsu.getUname(),infoUsu.getUname(),"Error en el metodo llenaClaseResultadosEmpDetalle de la clase GestorResultados. DETALLE: "+e.getMessage().toString().replace("'", "")+" Usuario: "+infoUsu.getCveUsuario(),infoUsu.getCveUsuario());
		}
		return ListRespuesta;
	}

	public static List<ResultadoAreas> consultaAreas(List<Querys> listaQuerys, String cdo, Usuario infoUsu) {
		Connection connBD = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		connBD = ConexionBD.AbrirConexionBDD(cdo);	
		List<ResultadoAreas> ListRespuesta = new ArrayList<>();
		//System.out.print(infoUsu);
		try {
			
			String[] querys = new String[25];	
			querys = Cls_Querys.LimpiaListaQuerys(querys);	
			
			querys = Cls_Querys.ObtieneQuerys(20, listaQuerys, querys);
			querys = inicializaQueryNumero20(querys, cdo);
			pstm = connBD.prepareStatement("{call " + "DCH.usp_EXECUTE_QUERY(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			rs=  Cls_Querys.EjecutarQuery(querys[0], querys[1],querys[2], querys[3], querys[4], querys[5], querys[6],
														 querys[7], querys[8], querys[9],querys[10], querys[11], querys[12], querys[13], 
														 querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], 
														 querys[21], querys[22], querys[23], querys[24], "",pstm, connBD,infoUsu);
			
			//System.out.print(infoUsu);
			Cls_Querys.ImprimeQuerysConsola(querys,true,"Query 20");
			
			ListRespuesta = llenaClaseResultadosArea(rs, infoUsu, "id_area");			
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

	private static String[] inicializaQueryNumero20(String[] querys, String cdo) {
		for (int i=0;i <querys.length; i++)
		{	
			querys[i]=querys[i].replace("{CDO}", String.valueOf(cdo));
		}
		return querys;
	}

	private static List<ResultadoAreas> llenaClaseResultadosArea(ResultSet rs, Usuario infoUsu,String id) {
		List<ResultadoAreas> ListRespuesta= new ArrayList<>();
		try
		{
			if(rs != null)
			{
				while(rs.next())
				{
					ResultadoAreas ra = new ResultadoAreas();
					ra.setIdEncuesta(rs.getString("id_encuesta"));
					if(id.equalsIgnoreCase("id_empleado")) {
						ra.setDepto(rs.getString("depto"));
						ra.setPuesto(rs.getString("puesto"));
					}
					ra.setId(rs.getInt(id));
					ra.setArea(rs.getString("descripcion"));
					ra.setVmp(rs.getDouble("vmp"));
					ra.setPromedioGral(rs.getDouble("promedio"));
					ra.setValorMaximoUno(rs.getDouble("vm1"));
					if(rs.getDouble("vm1")!=0) {
						ra.setUno((rs.getDouble("r1")*10)/rs.getDouble("vm1"));
					}else {
						ra.setUno(0);
					}
					ra.setValorMaximoDos(rs.getDouble("vm2"));
					if(rs.getDouble("vm2")!=0) {
						ra.setDos((rs.getDouble("r2")*10)/rs.getDouble("vm2"));
					}else {
						ra.setDos(0);
					}
					ra.setValorMaximoTres(rs.getDouble("vm3"));
					if(rs.getDouble("vm3")!=0) {
						ra.setTres((rs.getDouble("r3")*10)/rs.getDouble("vm3"));
					}else {
						ra.setTres(0);
					}
					ra.setValorMaximoCuatro(rs.getDouble("vm4"));
					if(rs.getDouble("vm4")!=0) {
						ra.setCuatro((rs.getDouble("r4")*10)/rs.getDouble("vm4"));
					}else {
						ra.setCuatro(0);
					}
					ra.setValorMaximoCinco(rs.getDouble("vm5"));
					if(rs.getDouble("vm5")!=0) {
						ra.setCinco((rs.getDouble("r5")*10)/rs.getDouble("vm5"));
					}else {
						ra.setCinco(0);
					}
					ra.setValorMaximoSeis(rs.getDouble("vm6"));
					if(rs.getDouble("vm6")!=0) {
						ra.setSeis((rs.getDouble("r6")*10)/rs.getDouble("vm6"));
					}else {
						ra.setSeis(0);
					}
					ra.setValorMaximoSiete(rs.getDouble("vm7"));
					if(rs.getDouble("vm7")!=0) {
						ra.setSiete((rs.getDouble("r7")*10)/rs.getDouble("vm7"));
					}else {
						ra.setSiete(0);
					}
					ra.setValorMaximoOcho(rs.getDouble("vm8"));
					if(rs.getDouble("vm8")!=0) {
						ra.setOcho((rs.getDouble("r8")*10)/rs.getDouble("vm8"));
					}else {
						ra.setOcho(0);
					}
					ra.setValorMaximoNueve(rs.getDouble("vm9"));
					if(rs.getDouble("vm9")!=0) {
						ra.setNueve((rs.getDouble("r9")*10)/rs.getDouble("vm9"));
					}else {
						ra.setNueve(0);
					}
					ra.setValorMaximoDiez(rs.getDouble("vm10"));
					if(rs.getDouble("vm10")!=0) {
						ra.setDiez((rs.getDouble("r10")*10)/rs.getDouble("vm10"));
					}else {
						ra.setDiez(0);
					}
					ra.setValorMaximoOnce(rs.getDouble("vm11"));
					if(rs.getDouble("vm11")!=0) {
						ra.setOnce((rs.getDouble("r11")*10)/rs.getDouble("vm11"));
					}else {
						ra.setOnce(0);
					}
					ra.setValorMaximoDoce(rs.getDouble("vm12"));
					if(rs.getDouble("vm12")!=0) {
						ra.setDoce((rs.getDouble("r12")*10)/rs.getDouble("vm12"));
					}else {
						ra.setDoce(0);
					}
					ra.setValorMaximoTrece(rs.getDouble("vm13"));
					if(rs.getDouble("vm13")!=0) {
						ra.setTrece((rs.getDouble("r13")*10)/rs.getDouble("vm13"));
					}else {
						ra.setTrece(0);
					}
					ListRespuesta.add(ra);
				}
			}
			
		}
		catch(Exception e)
		{
			//InsertaLogEncuestas.insertarLog(new LogEncuestas(),infoUsu.getUname(),infoUsu.getUname(),"Error en el metodo llenaClaseResultadosEmpDetalle de la clase GestorResultados. DETALLE: "+e.getMessage().toString().replace("'", "")+" Usuario: "+infoUsu.getCveUsuario(),infoUsu.getCveUsuario());
			System.out.print("Error en el metodo llenaClaseResultadosEmpDetalle de la clase GestorResultados. DETALLE: "+e.getMessage().toString().replace("'", ""));
		}
		return ListRespuesta;
	}

	public static List<ResultadoAreas> consultaDeptos(List<Querys> listaQuerys, String cdo, Usuario infoUsu) {
		Connection connBD = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		connBD = ConexionBD.AbrirConexionBDD(cdo);	
		List<ResultadoAreas> ListRespuesta = new ArrayList<>();
		//System.out.print(infoUsu);
		try {
			
			String[] querys = new String[25];	
			querys = Cls_Querys.LimpiaListaQuerys(querys);	
			
			querys = Cls_Querys.ObtieneQuerys(21, listaQuerys, querys);
			querys = inicializaQueryNumero20(querys, cdo);
			pstm = connBD.prepareStatement("{call " + "DCH.usp_EXECUTE_QUERY(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			rs=  Cls_Querys.EjecutarQuery(querys[0], querys[1],querys[2], querys[3], querys[4], querys[5], querys[6],
														 querys[7], querys[8], querys[9],querys[10], querys[11], querys[12], querys[13], 
														 querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], 
														 querys[21], querys[22], querys[23], querys[24], "",pstm, connBD,infoUsu);
			
			//System.out.print(infoUsu);
			Cls_Querys.ImprimeQuerysConsola(querys,true,"Query 21");
			
			ListRespuesta = llenaClaseResultadosArea(rs, infoUsu,"id_depto");			
			InsertaLogEncuestas.insertarLog(new LogEncuestas(),cdo,cdo,"Entrada a consultar departamento resultados Detalle Usuario: "+infoUsu.getCveUsuario()+"qry{"+Cls_Querys.regresaQuerys(querys,true)+"}",infoUsu.getCveUsuario());
		}catch(Exception ex)
		{
			InsertaLogEncuestas.insertarLog(new LogEncuestas(),cdo,cdo,"Error en el metodo consultaEmpleado de la clase GestorResultados.consultaDeptos DETALLE: "+ex.getMessage().toString().replace("'", "")+" Usuario: "+infoUsu.getCveUsuario(),infoUsu.getCveUsuario());
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
				InsertaLogEncuestas.insertarLog(new LogEncuestas(),cdo,cdo,"ERROR al cerrar conexion en GestorResultados.consultaDeptos: " + e.toString().replace("'", "")+" Usuario: "+infoUsu.getCveUsuario(),infoUsu.getCveUsuario());
			}
		}
		return ListRespuesta;
	}
	public static List<ResultadoAreas> consultaNiveles(List<Querys> listaQuerys, String cdo, Usuario infoUsu) {
		Connection connBD = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		connBD = ConexionBD.AbrirConexionBDD(cdo);	
		List<ResultadoAreas> ListRespuesta = new ArrayList<>();
		//System.out.print(infoUsu);
		try {
			
			String[] querys = new String[25];	
			querys = Cls_Querys.LimpiaListaQuerys(querys);	
			
			querys = Cls_Querys.ObtieneQuerys(22, listaQuerys, querys);
			querys = inicializaQueryNumero20(querys, cdo);
			pstm = connBD.prepareStatement("{call " + "DCH.usp_EXECUTE_QUERY(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			rs=  Cls_Querys.EjecutarQuery(querys[0], querys[1],querys[2], querys[3], querys[4], querys[5], querys[6],
														 querys[7], querys[8], querys[9],querys[10], querys[11], querys[12], querys[13], 
														 querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], 
														 querys[21], querys[22], querys[23], querys[24], "",pstm, connBD,infoUsu);
			
			//System.out.print(infoUsu);
			Cls_Querys.ImprimeQuerysConsola(querys,true,"Query 22");
			
			ListRespuesta = llenaClaseResultadosArea(rs, infoUsu, "id_nivel");			
			InsertaLogEncuestas.insertarLog(new LogEncuestas(),cdo,cdo,"Entrada a consultar niveles resultados Detalle Usuario: "+infoUsu.getCveUsuario()+"qry{"+Cls_Querys.regresaQuerys(querys,true)+"}",infoUsu.getCveUsuario());
		}catch(Exception ex)
		{
			InsertaLogEncuestas.insertarLog(new LogEncuestas(),cdo,cdo,"Error en el metodo consultaEmpleado de la clase GestorResultados.consultaNiveles DETALLE: "+ex.getMessage().toString().replace("'", "")+" Usuario: "+infoUsu.getCveUsuario(),infoUsu.getCveUsuario());
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
				InsertaLogEncuestas.insertarLog(new LogEncuestas(),cdo,cdo,"ERROR al cerrar conexion en GestorResultados.consultaNiveles: " + e.toString().replace("'", "")+" Usuario: "+infoUsu.getCveUsuario(),infoUsu.getCveUsuario());
			}
		}
		return ListRespuesta;
	}
	public static List<ResultadoAreas> consultaEmpleado(List<Querys> listaQuerys, String cdo, Usuario infoUsu, String idTipoEncuesta, String idEncuesta) {
		Connection connBD = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		connBD = ConexionBD.AbrirConexionBDD(cdo);	
		List<ResultadoAreas> ListRespuesta = new ArrayList<>();
		//System.out.print(infoUsu);
		try {
			
			String[] querys = new String[25];	
			querys = Cls_Querys.LimpiaListaQuerys(querys);	
			querys = Cls_Querys.ObtieneQuerys(23, listaQuerys, querys);
			querys = inicializaQueryNumero23(querys,cdo, idTipoEncuesta,idEncuesta);
			pstm = connBD.prepareStatement("{call " + "DCH.usp_EXECUTE_QUERY(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			rs=  Cls_Querys.EjecutarQuery(querys[0], querys[1],querys[2], querys[3], querys[4], querys[5], querys[6],
														 querys[7], querys[8], querys[9],querys[10], querys[11], querys[12], querys[13], 
														 querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], 
														 querys[21], querys[22], querys[23], querys[24], "",pstm, connBD,infoUsu);
			
			//System.out.print(infoUsu);
			Cls_Querys.ImprimeQuerysConsola(querys,true,"Query 23");
			
			ListRespuesta = llenaClaseResultadosArea(rs, infoUsu, "id_empleado");			
			InsertaLogEncuestas.insertarLog(new LogEncuestas(),cdo,cdo,"Entrada a consultar empleados resultados Detalle Usuario: "+infoUsu.getCveUsuario()+"qry{"+Cls_Querys.regresaQuerys(querys,true)+"}",infoUsu.getCveUsuario());
		}catch(Exception ex)
		{
			InsertaLogEncuestas.insertarLog(new LogEncuestas(),cdo,cdo,"Error en el metodo consultaEmpleado de la clase GestorResultados.consultaEmpleados DETALLE: "+ex.getMessage().toString().replace("'", "")+" Usuario: "+infoUsu.getCveUsuario(),infoUsu.getCveUsuario());
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
				InsertaLogEncuestas.insertarLog(new LogEncuestas(),cdo,cdo,"ERROR al cerrar conexion en GestorResultados.consultaEmpleados: " + e.toString().replace("'", "")+" Usuario: "+infoUsu.getCveUsuario(),infoUsu.getCveUsuario());
			}
		}
		return ListRespuesta;
	}

	private static String[] inicializaQueryNumero23(String[] querys,String cdo, String idTipoEncuesta, String idEncuesta) {
		for (int i=0;i <querys.length; i++)
		{	
			if(!idTipoEncuesta.equals("0")) {
			querys[i]=querys[i].replace("{ID_TIPO_ENCUESTA}", "AND e.id_tipo_encuesta="+idTipoEncuesta);
			}else {
				querys[i]=querys[i].replace("{ID_TIPO_ENCUESTA}", "");
			}
			if(idEncuesta.equalsIgnoreCase("0")) {
				querys[i]=querys[i].replace("{ID_ENCUESTA}", String.valueOf(""));
			}else {
				querys[i]=querys[i].replace("{ID_ENCUESTA}", String.valueOf("="+idEncuesta));
				
			}
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

	public static List<ResultadoAreas> consultaEmpleadoAreas(List<Querys> listaQuerys, String cdo, Usuario infoUsu,
			String idArea, String idEncuesta) {
		Connection connBD = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		connBD = ConexionBD.AbrirConexionBDD(cdo);	
		List<ResultadoAreas> ListRespuesta = new ArrayList<>();
		//System.out.print(infoUsu);
		try {
			
			String[] querys = new String[25];	
			querys = Cls_Querys.LimpiaListaQuerys(querys);	
			querys = Cls_Querys.ObtieneQuerys(24, listaQuerys, querys);
			querys = inicializaQueryNumero24(querys, idArea,idEncuesta);
			pstm = connBD.prepareStatement("{call " + "DCH.usp_EXECUTE_QUERY(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			rs=  Cls_Querys.EjecutarQuery(querys[0], querys[1],querys[2], querys[3], querys[4], querys[5], querys[6],
														 querys[7], querys[8], querys[9],querys[10], querys[11], querys[12], querys[13], 
														 querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], 
														 querys[21], querys[22], querys[23], querys[24], "",pstm, connBD,infoUsu);
			
			//System.out.print(infoUsu);
			Cls_Querys.ImprimeQuerysConsola(querys,true,"Query 24");
			
			ListRespuesta = llenaClaseResultadosArea(rs, infoUsu, "id_depto");			
			InsertaLogEncuestas.insertarLog(new LogEncuestas(),cdo,cdo,"Entrada a consultar empleados resultados Detalle Usuario: "+infoUsu.getCveUsuario()+"qry{"+Cls_Querys.regresaQuerys(querys,true)+"}",infoUsu.getCveUsuario());
		}catch(Exception ex)
		{
			InsertaLogEncuestas.insertarLog(new LogEncuestas(),cdo,cdo,"Error en el metodo consultaEmpleado de la clase GestorResultados.consultaEmpleados DETALLE: "+ex.getMessage().toString().replace("'", "")+" Usuario: "+infoUsu.getCveUsuario(),infoUsu.getCveUsuario());
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
				InsertaLogEncuestas.insertarLog(new LogEncuestas(),cdo,cdo,"ERROR al cerrar conexion en GestorResultados.consultaEmpleados: " + e.toString().replace("'", "")+" Usuario: "+infoUsu.getCveUsuario(),infoUsu.getCveUsuario());
			}
		}
		return ListRespuesta;
	}

	private static String[] inicializaQueryNumero24(String[] querys, String idArea, String idEncuesta) {
		for (int i=0;i <querys.length; i++)
		{	
			querys[i]=querys[i].replace("{ID_AREA}", String.valueOf(idArea));
			querys[i]=querys[i].replace("{ID_ENCUESTA}", String.valueOf(idEncuesta));
		}
		return querys;
	}

	public static List<ResultadoAreas> consultaDetalleEmpleado(List<Querys> listaQuerys, String cdo, Usuario infoUsu,
			String idEmpleado, String idEncuesta) {
		Connection connBD = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		connBD = ConexionBD.AbrirConexionBDD(cdo);	
		List<ResultadoAreas> ListRespuesta = new ArrayList<>();
		//System.out.print(infoUsu);
		try {
			
			String[] querys = new String[25];	
			querys = Cls_Querys.LimpiaListaQuerys(querys);	
			querys = Cls_Querys.ObtieneQuerys(25, listaQuerys, querys);
			querys = inicializaQueryNumero25(querys, idEmpleado,idEncuesta);
			pstm = connBD.prepareStatement("{call " + "DCH.usp_EXECUTE_QUERY(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			rs=  Cls_Querys.EjecutarQuery(querys[0], querys[1],querys[2], querys[3], querys[4], querys[5], querys[6],
														 querys[7], querys[8], querys[9],querys[10], querys[11], querys[12], querys[13], 
														 querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], 
														 querys[21], querys[22], querys[23], querys[24], "",pstm, connBD,infoUsu);
			
			//System.out.print(infoUsu);
			Cls_Querys.ImprimeQuerysConsola(querys,true,"Query 25");
			
			ListRespuesta = llenaClaseResultadosArea(rs, infoUsu, "id_empleado_evaluado");			
			InsertaLogEncuestas.insertarLog(new LogEncuestas(),cdo,cdo,"Entrada a consultar DETALLE empleados resultados Detalle Usuario: "+infoUsu.getCveUsuario()+"qry{"+Cls_Querys.regresaQuerys(querys,true)+"}",infoUsu.getCveUsuario());
		}catch(Exception ex)
		{
			InsertaLogEncuestas.insertarLog(new LogEncuestas(),cdo,cdo,"Error en el metodo consultaEmpleado de la clase GestorResultados.consultaDetalleEmpleado DETALLE: "+ex.getMessage().toString().replace("'", "")+" Usuario: "+infoUsu.getCveUsuario(),infoUsu.getCveUsuario());
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
				InsertaLogEncuestas.insertarLog(new LogEncuestas(),cdo,cdo,"ERROR al cerrar conexion en GestorResultados.consultaDetalleEmpleado: " + e.toString().replace("'", "")+" Usuario: "+infoUsu.getCveUsuario(),infoUsu.getCveUsuario());
			}
		}
		return ListRespuesta;
	}

	private static String[] inicializaQueryNumero25(String[] querys, String idEmpleado, String idEncuesta) {
		for (int i=0;i <querys.length; i++)
		{	
			querys[i]=querys[i].replace("{ID_EMPLEADO}", String.valueOf(idEmpleado));
			querys[i]=querys[i].replace("{ID_ENCUESTA}", String.valueOf(idEncuesta));
		}
		return querys;
	}

	public static List<ResultadoAreas> consultaEmpleadoDeptos(List<Querys> listaQuerys, String cdo, Usuario infoUsu,
			String idDepartamento, String idEncuesta,String idArea) {
		Connection connBD = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		connBD = ConexionBD.AbrirConexionBDD(cdo);	
		List<ResultadoAreas> ListRespuesta = new ArrayList<>();
		//System.out.print(infoUsu);
		try {
			
			String[] querys = new String[25];	
			querys = Cls_Querys.LimpiaListaQuerys(querys);	
			querys = Cls_Querys.ObtieneQuerys(26, listaQuerys, querys);
			querys = inicializaQueryNumero26(querys, idDepartamento,idEncuesta,idArea);
			pstm = connBD.prepareStatement("{call " + "DCH.usp_EXECUTE_QUERY(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			rs=  Cls_Querys.EjecutarQuery(querys[0], querys[1],querys[2], querys[3], querys[4], querys[5], querys[6],
														 querys[7], querys[8], querys[9],querys[10], querys[11], querys[12], querys[13], 
														 querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], 
														 querys[21], querys[22], querys[23], querys[24], "",pstm, connBD,infoUsu);
			
			//System.out.print(infoUsu);
			Cls_Querys.ImprimeQuerysConsola(querys,true,"Query 24");
			
			ListRespuesta = llenaClaseResultadosArea(rs, infoUsu, "id_empleado");			
			InsertaLogEncuestas.insertarLog(new LogEncuestas(),cdo,cdo,"Entrada a consultar empleados resultados Detalle Usuario: "+infoUsu.getCveUsuario()+"qry{"+Cls_Querys.regresaQuerys(querys,true)+"}",infoUsu.getCveUsuario());
		}catch(Exception ex)
		{
			InsertaLogEncuestas.insertarLog(new LogEncuestas(),cdo,cdo,"Error en el metodo consultaEmpleado de la clase GestorResultados.consultaEmpleados DETALLE: "+ex.getMessage().toString().replace("'", "")+" Usuario: "+infoUsu.getCveUsuario(),infoUsu.getCveUsuario());
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
				InsertaLogEncuestas.insertarLog(new LogEncuestas(),cdo,cdo,"ERROR al cerrar conexion en GestorResultados.consultaEmpleados: " + e.toString().replace("'", "")+" Usuario: "+infoUsu.getCveUsuario(),infoUsu.getCveUsuario());
			}
		}
		return ListRespuesta;
	}
	private static String[] inicializaQueryNumero26(String[] querys, String idDepartamento, String idEncuesta,String idArea) {
		for (int i=0;i <querys.length; i++)
		{	
			querys[i]=querys[i].replace("{ID_DEPTO}", String.valueOf(idDepartamento));
			querys[i]=querys[i].replace("{ID_ENCUESTA}", String.valueOf(idEncuesta));
			if(idArea.length()>0) {
				querys[i]=querys[i].replace("{ID_AREA}", String.valueOf("AND e.id_area="+idArea));
			}else {
				querys[i]=querys[i].replace("{ID_AREA}", String.valueOf(""));
			}
		}
		return querys;
	}

	public static boolean guardaRetro(List<Querys> listaQuerys, String cdo, Usuario infoUsu, String idEmpleado,
			String fortalezas, String areas, String idEncuesta) {
		Connection connBD = null;
		PreparedStatement pstm = null;
		ResultSet rs ;
		connBD = ConexionBD.AbrirConexionBDD(cdo);	
		boolean valida=false;
		//System.out.print(infoUsu);
		try {
			
			String[] querys = new String[25];	
			querys = Cls_Querys.LimpiaListaQuerys(querys);	
			querys = Cls_Querys.ObtieneQuerys(27, listaQuerys, querys);
			querys = inicializaQueryNumero27(querys,infoUsu,idEmpleado, fortalezas,areas,idEncuesta);
			pstm = connBD.prepareStatement("{call " + "DCH.usp_EXECUTE_QUERY(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			rs=  Cls_Querys.EjecutarQuery(querys[0], querys[1],querys[2], querys[3], querys[4], querys[5], querys[6],
														 querys[7], querys[8], querys[9],querys[10], querys[11], querys[12], querys[13], 
														 querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], 
														 querys[21], querys[22], querys[23], querys[24], "",pstm, connBD,infoUsu);
			
			//System.out.print(infoUsu);
			Cls_Querys.ImprimeQuerysConsola(querys,true,"Query 24");
			valida=true;		
			InsertaLogEncuestas.insertarLog(new LogEncuestas(),cdo,cdo,"Entrada a consultar empleados resultados Detalle Usuario: "+infoUsu.getCveUsuario()+"qry{"+Cls_Querys.regresaQuerys(querys,true)+"}",infoUsu.getCveUsuario());
		}catch(Exception ex)
		{
			InsertaLogEncuestas.insertarLog(new LogEncuestas(),cdo,cdo,"Error en el metodo consultaEmpleado de la clase GestorResultados.consultaEmpleados DETALLE: "+ex.getMessage().toString().replace("'", "")+" Usuario: "+infoUsu.getCveUsuario(),infoUsu.getCveUsuario());
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
				InsertaLogEncuestas.insertarLog(new LogEncuestas(),cdo,cdo,"ERROR al cerrar conexion en GestorResultados.consultaEmpleados: " + e.toString().replace("'", "")+" Usuario: "+infoUsu.getCveUsuario(),infoUsu.getCveUsuario());
			}
		}
		return valida;
	}
	private static String[] inicializaQueryNumero27(String[] querys, Usuario infoUsu, String idEmpleado,
			String fortalezas, String areas, String idEncuesta) {
		for (int i=0;i <querys.length; i++)
		{	
			querys[i]=querys[i].replace("{ID_ENCUESTA}", String.valueOf(idEncuesta));
			querys[i]=querys[i].replace("{ID_EMPLEADO}", String.valueOf(idEmpleado));
			querys[i]=querys[i].replace("{FORTALEZAS}", String.valueOf(fortalezas));
			querys[i]=querys[i].replace("{AREAS}", String.valueOf(areas));
			querys[i]=querys[i].replace("{USUARIO}", String.valueOf(infoUsu.getCveUsuario()));
		}
		return querys;
	}

	public static List<String> cargaDatos(List<Querys> listaQuerys, String cdo, Usuario infoUsu, String idEmpleado, String idEncuesta) {
		Connection connBD = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		connBD = ConexionBD.AbrirConexionBDD(cdo);	
		List<String> valida= new ArrayList<>();
		//System.out.print(infoUsu);
		try {
			
			String[] querys = new String[25];	
			querys = Cls_Querys.LimpiaListaQuerys(querys);	
			querys = Cls_Querys.ObtieneQuerys(28, listaQuerys, querys);
			querys = inicializaQueryNumero25(querys,idEmpleado,idEncuesta);
			pstm = connBD.prepareStatement("{call " + "DCH.usp_EXECUTE_QUERY(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			rs=  Cls_Querys.EjecutarQuery(querys[0], querys[1],querys[2], querys[3], querys[4], querys[5], querys[6],
														 querys[7], querys[8], querys[9],querys[10], querys[11], querys[12], querys[13], 
														 querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], 
														 querys[21], querys[22], querys[23], querys[24], "",pstm, connBD,infoUsu);
			
			//System.out.print(infoUsu);
			Cls_Querys.ImprimeQuerysConsola(querys,true,"Query 24");
			if(rs != null)
			{
				while(rs.next())
				{
					if(rs.getString("fortalezas").trim().equalsIgnoreCase("")) {
						valida.add("");
					}else {
						valida.add(rs.getString("fortalezas"));
					}
					if(rs.getString("areas").trim().equalsIgnoreCase("")) {
						valida.add("");
					}else {
						valida.add(rs.getString("areas"));
					}
				}
				
			}
			
			InsertaLogEncuestas.insertarLog(new LogEncuestas(),cdo,cdo,"Entrada a consultar empleados resultados Detalle Usuario: "+infoUsu.getCveUsuario()+"qry{"+Cls_Querys.regresaQuerys(querys,true)+"}",infoUsu.getCveUsuario());
		}catch(Exception ex)
		{
			InsertaLogEncuestas.insertarLog(new LogEncuestas(),cdo,cdo,"Error en el metodo consultaEmpleado de la clase GestorResultados.consultaEmpleados DETALLE: "+ex.getMessage().toString().replace("'", "")+" Usuario: "+infoUsu.getCveUsuario(),infoUsu.getCveUsuario());
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
				InsertaLogEncuestas.insertarLog(new LogEncuestas(),cdo,cdo,"ERROR al cerrar conexion en GestorResultados.consultaEmpleados: " + e.toString().replace("'", "")+" Usuario: "+infoUsu.getCveUsuario(),infoUsu.getCveUsuario());
			}
		}
		return valida;
	}

	public static List<Preguntas> cargaPreguntas(List<Querys> listaQuerys, String cdo, Usuario infoUsu,
			String idEmpleado, String consulta, String idEncuesta) {
		Connection connBD = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		connBD = ConexionBD.AbrirConexionBDD(cdo);	
		List<Preguntas> ListPreguntas = new ArrayList<>();
		//System.out.print(infoUsu);
		try {
			
			String[] querys = new String[25];	
			querys = Cls_Querys.LimpiaListaQuerys(querys);	
			querys = Cls_Querys.ObtieneQuerys(29, listaQuerys, querys);
			querys = inicializaQueryNumero29(querys, consulta,idEmpleado,idEncuesta);
			pstm = connBD.prepareStatement("{call " + "DCH.usp_EXECUTE_QUERY(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			rs=  Cls_Querys.EjecutarQuery(querys[0], querys[1],querys[2], querys[3], querys[4], querys[5], querys[6],
														 querys[7], querys[8], querys[9],querys[10], querys[11], querys[12], querys[13], 
														 querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], 
														 querys[21], querys[22], querys[23], querys[24], "",pstm, connBD,infoUsu);
			
			//System.out.print(infoUsu);
			Cls_Querys.ImprimeQuerysConsola(querys,true,"Query 29");
			
			ListPreguntas = llenaClaseResultadosPreguntas(rs, infoUsu,true, "");			
			InsertaLogEncuestas.insertarLog(new LogEncuestas(),cdo,cdo,"Entrada a consultar empleados resultados Detalle Usuario: "+infoUsu.getCveUsuario()+"qry{"+Cls_Querys.regresaQuerys(querys,true)+"}",infoUsu.getCveUsuario());
		}catch(Exception ex)
		{
			InsertaLogEncuestas.insertarLog(new LogEncuestas(),cdo,cdo,"Error en el metodo consultaEmpleado de la clase GestorResultados.consultaEmpleados DETALLE: "+ex.getMessage().toString().replace("'", "")+" Usuario: "+infoUsu.getCveUsuario(),infoUsu.getCveUsuario());
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
				InsertaLogEncuestas.insertarLog(new LogEncuestas(),cdo,cdo,"ERROR al cerrar conexion en GestorResultados.consultaEmpleados: " + e.toString().replace("'", "")+" Usuario: "+infoUsu.getCveUsuario(),infoUsu.getCveUsuario());
			}
		}
		return ListPreguntas;
	}

	private static List<Preguntas> llenaClaseResultadosPreguntas(ResultSet rs, Usuario infoUsu, boolean valida, String idEmpleado) {
		List<Preguntas> ListRespuesta= new ArrayList<>();
		try
		{
			if(rs != null)
			{
				while(rs.next())
				{
					String[] tmp;
					Preguntas p =new Preguntas();
					
					tmp=rs.getString("comentarios").split(",");
					if(valida) {
						p.setCalif(rs.getDouble("calif"));
						p.setCompetencia(rs.getString("descripcion_competencia"));
					}
					p.setIdEmpleado(rs.getString("id_empleado_evaluado"));
					p.setPreguntas(rs.getString("pregunta"));
					for(int i=0;i<tmp.length;i++) {
						if((tmp[i].trim()).length()>3) {
								p.setComentarios(tmp[i]);
							}
						}
					
					ListRespuesta.add(p);
				}
			}
			
		}
		catch(Exception e)
		{
			InsertaLogEncuestas.insertarLog(new LogEncuestas(),infoUsu.getUname(),infoUsu.getUname(),"Error en el metodo llenaClaseResultadosEmpDetalle de la clase GestorResultados. DETALLE: "+e.getMessage().toString().replace("'", "")+" Usuario: "+infoUsu.getCveUsuario(),infoUsu.getCveUsuario());
		}
		return ListRespuesta;
	}

	private static String[] inicializaQueryNumero29(String[] querys, String consulta, String idEmpleado, String idEncuesta) {
		for (int i=0;i <querys.length; i++)
		{	
			querys[i]=querys[i].replace("{ID_EMPLEADO}", String.valueOf(idEmpleado));
			querys[i]=querys[i].replace("{ID_ENCUESTA}", String.valueOf(idEncuesta));
		}
		if(consulta.equalsIgnoreCase("fortalezas")) {
			querys[8]="";
		}else if(consulta.equalsIgnoreCase("areas")) {
			querys[7]="";
		}
		return querys;
	}

	public static List<Preguntas> cargaPreguntasAbiertas(List<Querys> listaQuerys, String cdo, Usuario infoUsu,
			String idEmpleado, String idEncuesta ) {
		Connection connBD = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		connBD = ConexionBD.AbrirConexionBDD(cdo);	
		List<Preguntas> ListPreguntas = new ArrayList<>();
		//System.out.print(infoUsu);
		try {
			
			String[] querys = new String[25];	
			querys = Cls_Querys.LimpiaListaQuerys(querys);	
			querys = Cls_Querys.ObtieneQuerys(30, listaQuerys, querys);
			querys = inicializaQueryNumero25(querys,idEmpleado,idEncuesta);
			pstm = connBD.prepareStatement("{call " + "DCH.usp_EXECUTE_QUERY(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			rs=  Cls_Querys.EjecutarQuery(querys[0], querys[1],querys[2], querys[3], querys[4], querys[5], querys[6],
														 querys[7], querys[8], querys[9],querys[10], querys[11], querys[12], querys[13], 
														 querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], 
														 querys[21], querys[22], querys[23], querys[24], "",pstm, connBD,infoUsu);
			
			//System.out.print(infoUsu);
			Cls_Querys.ImprimeQuerysConsola(querys,true,"Query 30");
			
			ListPreguntas = llenaClaseResultadosPreguntas(rs, infoUsu, false,idEmpleado);			
			InsertaLogEncuestas.insertarLog(new LogEncuestas(),cdo,cdo,"Entrada a consultar empleados resultados Detalle Usuario: "+infoUsu.getCveUsuario()+"qry{"+Cls_Querys.regresaQuerys(querys,true)+"}",infoUsu.getCveUsuario());
		}catch(Exception ex)
		{
			InsertaLogEncuestas.insertarLog(new LogEncuestas(),cdo,cdo,"Error en el metodo consultaEmpleado de la clase GestorResultados.consultaEmpleados DETALLE: "+ex.getMessage().toString().replace("'", "")+" Usuario: "+infoUsu.getCveUsuario(),infoUsu.getCveUsuario());
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
				InsertaLogEncuestas.insertarLog(new LogEncuestas(),cdo,cdo,"ERROR al cerrar conexion en GestorResultados.consultaEmpleados: " + e.toString().replace("'", "")+" Usuario: "+infoUsu.getCveUsuario(),infoUsu.getCveUsuario());
			}
		}
		return ListPreguntas;
	}

	public static List<Areas> cargaAreas(List<Querys> listaQuerys, String cdo, Usuario infoUsu) {
		Connection connBD = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		connBD = ConexionBD.AbrirConexionBDD(cdo);	
		List<Areas> ListPreguntas = new ArrayList<>();
		//System.out.print(infoUsu);
		try {
			
			String[] querys = new String[25];	
			querys = Cls_Querys.LimpiaListaQuerys(querys);	
			querys = Cls_Querys.ObtieneQuerys(31, listaQuerys, querys);
			pstm = connBD.prepareStatement("{call " + "DCH.usp_EXECUTE_QUERY(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			rs=  Cls_Querys.EjecutarQuery(querys[0], querys[1],querys[2], querys[3], querys[4], querys[5], querys[6],
														 querys[7], querys[8], querys[9],querys[10], querys[11], querys[12], querys[13], 
														 querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], 
														 querys[21], querys[22], querys[23], querys[24], "",pstm, connBD,infoUsu);
			
			//System.out.print(infoUsu);
			Cls_Querys.ImprimeQuerysConsola(querys,true,"Query 31");
			ListPreguntas = llenaClaseAreas(rs, infoUsu, "id_area");	
			InsertaLogEncuestas.insertarLog(new LogEncuestas(),cdo,cdo,"Entrada a consultar empleados resultados Detalle Usuario: "+infoUsu.getCveUsuario()+"qry{"+Cls_Querys.regresaQuerys(querys,true)+"}",infoUsu.getCveUsuario());
		}catch(Exception ex)
		{
			InsertaLogEncuestas.insertarLog(new LogEncuestas(),cdo,cdo,"Error en el metodo consultaEmpleado de la clase GestorResultados.consultaEmpleados DETALLE: "+ex.getMessage().toString().replace("'", "")+" Usuario: "+infoUsu.getCveUsuario(),infoUsu.getCveUsuario());
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
				InsertaLogEncuestas.insertarLog(new LogEncuestas(),cdo,cdo,"ERROR al cerrar conexion en GestorResultados.consultaEmpleados: " + e.toString().replace("'", "")+" Usuario: "+infoUsu.getCveUsuario(),infoUsu.getCveUsuario());
			}
		}
		return ListPreguntas;
	}

	private static List<Areas> llenaClaseAreas(ResultSet rs, Usuario infoUsu, String id) {
		List<Areas> ListRespuesta= new ArrayList<>();
		try
		{
			if(rs != null)
			{
				while(rs.next())
				{
					Areas a=new Areas();
					a.setDescripcion(rs.getString("descripcion"));
					a.setIdArea(rs.getString(id));
					ListRespuesta.add(a);
				}
			}
			
		}
		catch(Exception e)
		{
			InsertaLogEncuestas.insertarLog(new LogEncuestas(),infoUsu.getUname(),infoUsu.getUname(),"Error en el metodo llenaClaseResultadosEmpDetalle de la clase GestorResultados. DETALLE: "+e.getMessage().toString().replace("'", "")+" Usuario: "+infoUsu.getCveUsuario(),infoUsu.getCveUsuario());
		}
		return ListRespuesta;
	}

	public static List<Areas> cargaDeptos(List<Querys> listaQuerys, String cdo, Usuario infoUsu) {
		Connection connBD = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		connBD = ConexionBD.AbrirConexionBDD(cdo);	
		List<Areas> ListPreguntas = new ArrayList<>();
		//System.out.print(infoUsu);
		try {
			
			String[] querys = new String[25];	
			querys = Cls_Querys.LimpiaListaQuerys(querys);	
			querys = Cls_Querys.ObtieneQuerys(32, listaQuerys, querys);
			pstm = connBD.prepareStatement("{call " + "DCH.usp_EXECUTE_QUERY(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			rs=  Cls_Querys.EjecutarQuery(querys[0], querys[1],querys[2], querys[3], querys[4], querys[5], querys[6],
														 querys[7], querys[8], querys[9],querys[10], querys[11], querys[12], querys[13], 
														 querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], 
														 querys[21], querys[22], querys[23], querys[24], "",pstm, connBD,infoUsu);
			
			//System.out.print(infoUsu);
			Cls_Querys.ImprimeQuerysConsola(querys,true,"Query 32");
			ListPreguntas = llenaClaseAreas(rs, infoUsu, "id_departamento");	
			InsertaLogEncuestas.insertarLog(new LogEncuestas(),cdo,cdo,"Entrada a consultar empleados resultados Detalle Usuario: "+infoUsu.getCveUsuario()+"qry{"+Cls_Querys.regresaQuerys(querys,true)+"}",infoUsu.getCveUsuario());
		}catch(Exception ex)
		{
			InsertaLogEncuestas.insertarLog(new LogEncuestas(),cdo,cdo,"Error en el metodo consultaEmpleado de la clase GestorResultados.consultaEmpleados DETALLE: "+ex.getMessage().toString().replace("'", "")+" Usuario: "+infoUsu.getCveUsuario(),infoUsu.getCveUsuario());
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
				InsertaLogEncuestas.insertarLog(new LogEncuestas(),cdo,cdo,"ERROR al cerrar conexion en GestorResultados.consultaEmpleados: " + e.toString().replace("'", "")+" Usuario: "+infoUsu.getCveUsuario(),infoUsu.getCveUsuario());
			}
		}
		return ListPreguntas;
	}

	public static List<ResultadoAreas> cargaEmpleadosTipoArea(List<Querys> listaQuerys, String cdo, Usuario infoUsu,
			String idTipoEncuesta, String idArea) {
		Connection connBD = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		connBD = ConexionBD.AbrirConexionBDD(cdo);	
		List<ResultadoAreas> ListRespuesta = new ArrayList<>();
		//System.out.print(infoUsu);
		try {
			
			String[] querys = new String[25];	
			querys = Cls_Querys.LimpiaListaQuerys(querys);	
			querys = Cls_Querys.ObtieneQuerys(34, listaQuerys, querys);
			querys = inicializaQueryNumero34(querys,idTipoEncuesta,idArea);
			pstm = connBD.prepareStatement("{call " + "DCH.usp_EXECUTE_QUERY(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			rs=  Cls_Querys.EjecutarQuery(querys[0], querys[1],querys[2], querys[3], querys[4], querys[5], querys[6],
														 querys[7], querys[8], querys[9],querys[10], querys[11], querys[12], querys[13], 
														 querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], 
														 querys[21], querys[22], querys[23], querys[24], "",pstm, connBD,infoUsu);
			
			//System.out.print(infoUsu);
			Cls_Querys.ImprimeQuerysConsola(querys,true,"Query 34");
			
			ListRespuesta = llenaClaseResultadosArea(rs, infoUsu, "id_empleado");			
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
	private static String[] inicializaQueryNumero34(String[] querys, String idTipoEncuesta, String idArea) {
		for (int i=0;i <querys.length; i++)
		{	
			if(idArea.equalsIgnoreCase("0")) {
				querys[i]=querys[i].replace("{ID_AREA}", String.valueOf(""));
			}else {
				querys[i]=querys[i].replace("{ID_AREA}", String.valueOf("AND e.id_area="+idArea));
			}
			
			querys[i]=querys[i].replace("{ID_TIPO_ENCUESTA}", String.valueOf(idTipoEncuesta));
		}
		return querys;
	}

	public static List<ResultadoAreas> cargaEmpleadosTipoDepto(List<Querys> listaQuerys, String cdo, Usuario infoUsu,
			String idTipoEncuesta, String idDepto) {
		Connection connBD = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		connBD = ConexionBD.AbrirConexionBDD(cdo);	
		List<ResultadoAreas> ListRespuesta = new ArrayList<>();
		//System.out.print(infoUsu);
		try {
			
			String[] querys = new String[25];	
			querys = Cls_Querys.LimpiaListaQuerys(querys);	
			querys = Cls_Querys.ObtieneQuerys(33, listaQuerys, querys);
			querys = inicializaQueryNumero35(querys,idTipoEncuesta,idDepto);
			pstm = connBD.prepareStatement("{call " + "DCH.usp_EXECUTE_QUERY(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			rs=  Cls_Querys.EjecutarQuery(querys[0], querys[1],querys[2], querys[3], querys[4], querys[5], querys[6],
														 querys[7], querys[8], querys[9],querys[10], querys[11], querys[12], querys[13], 
														 querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], 
														 querys[21], querys[22], querys[23], querys[24], "",pstm, connBD,infoUsu);
			
			//System.out.print(infoUsu);
			Cls_Querys.ImprimeQuerysConsola(querys,true,"Query 33");
			
			ListRespuesta = llenaClaseResultadosArea(rs, infoUsu, "id_empleado");			
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
	private static String[] inicializaQueryNumero35(String[] querys, String idTipoEncuesta, String idDepto) {
		for (int i=0;i <querys.length; i++)
		{	
			if(idDepto.equalsIgnoreCase("0")) {
				querys[i]=querys[i].replace("{ID_DEPTO}", String.valueOf(""));
			}else {
				querys[i]=querys[i].replace("{ID_DEPTO}", String.valueOf("AND e.id_depto="+idDepto));
			}
			
			querys[i]=querys[i].replace("{ID_TIPO_ENCUESTA}", String.valueOf(idTipoEncuesta));
		}
		return querys;
	}

	public static boolean cargaResultados(List<Querys> listaQuerys, String cdo, Usuario infoUsu,
			String idTipoEncuesta, String idDepto) {
		Connection connBD = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		connBD = ConexionBD.AbrirConexionBDD(cdo);
		boolean respuesta=false;
		//System.out.print(infoUsu);
		try {
			
			String[] querys = new String[25];	
			querys = Cls_Querys.LimpiaListaQuerys(querys);	
			querys = Cls_Querys.ObtieneQuerys(39, listaQuerys, querys);
			querys = inicializaQueryNumero18(querys,cdo);
			pstm = connBD.prepareStatement("{call " + "DCH.usp_EXECUTE_QUERY(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			rs=  Cls_Querys.EjecutarQuery(querys[0], querys[1],querys[2], querys[3], querys[4], querys[5], querys[6],
														 querys[7], querys[8], querys[9],querys[10], querys[11], querys[12], querys[13], 
														 querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], 
														 querys[21], querys[22], querys[23], querys[24], "",pstm, connBD,infoUsu);
			Cls_Querys.ImprimeQuerysConsola(querys,true,"/*Querys 39*/");
			querys = Cls_Querys.ObtieneQuerys(40, listaQuerys, querys);
			querys = inicializaQueryNumero18(querys,cdo);
			pstm = connBD.prepareStatement("{call " + "DCH.usp_EXECUTE_QUERY(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			rs=  Cls_Querys.EjecutarQuery(querys[0], querys[1],querys[2], querys[3], querys[4], querys[5], querys[6],
														 querys[7], querys[8], querys[9],querys[10], querys[11], querys[12], querys[13], 
														 querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], 
														 querys[21], querys[22], querys[23], querys[24], "",pstm, connBD,infoUsu);
			
			
			//System.out.print(infoUsu);
			Cls_Querys.ImprimeQuerysConsola(querys,true,"/*Querys 40*/");
			respuesta=true;
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
		return respuesta;
	}

	
}