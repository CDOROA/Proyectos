package Persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Datos.LogEncuestas;
import Datos.Querys;
import Util.Cls_Querys;
import Util.ConexionBD;
import Util.InsertaLogEncuestas;
import Datos.Seguimiento;
import Datos.SeguimientoDetalle;
import Datos.Usuario;

public class GestorSeguimiento {

	public static List<Seguimiento> consultaSeguimiento(List<Querys> listaQuerys, String cdo, Usuario infoUsu, String idEncuesta) {
		Connection connBD = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		connBD = ConexionBD.AbrirConexionBDD(cdo);	
		List<Seguimiento> ListSeguimiento = new ArrayList<>();
		//System.out.print(infoUsu);
		try {
			
			String[] querys = new String[25];	
			querys = Cls_Querys.LimpiaListaQuerys(querys);	
			querys = Cls_Querys.ObtieneQuerys(16, listaQuerys, querys);
			querys = inicializaQueryNumero16(querys, cdo,idEncuesta);
			pstm = connBD.prepareStatement("{call " + "DCH.usp_EXECUTE_QUERY(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			rs=  Cls_Querys.EjecutarQuery(querys[0], querys[1],querys[2], querys[3], querys[4], querys[5], querys[6],
														 querys[7], querys[8], querys[9],querys[10], querys[11], querys[12], querys[13], 
														 querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], 
														 querys[21], querys[22], querys[23], querys[24], "",pstm, connBD, infoUsu);
			
			//System.out.print(infoUsu);
			Cls_Querys.ImprimeQuerysConsola(querys,false,"Query 16");
			
			ListSeguimiento = llenaClaseSeguimiento(rs, infoUsu);			
			InsertaLogEncuestas.insertarLog(new LogEncuestas(),cdo,cdo,"Entrada a consultar Seguimiento Usuario: "+infoUsu.getCveUsuario()+"qry{"+Cls_Querys.regresaQuerys(querys,true)+"}",infoUsu.getCveUsuario());
		}catch(Exception ex)
		{
			InsertaLogEncuestas.insertarLog(new LogEncuestas(),cdo,cdo,"Error en el metodo consultaSeguimiento de la clase GestorSeguimiento. DETALLE: "+ex.getMessage().toString().replace("'", "")+" Usuario: "+infoUsu.getCveUsuario(),infoUsu.getCveUsuario());
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
				InsertaLogEncuestas.insertarLog(new LogEncuestas(),cdo,cdo,"ERROR al cerrar conexion en GestorSeguimiento.ConsultaSeguimiento: " + e.toString().replace("'", "")+" Usuario: "+infoUsu.getCveUsuario(),infoUsu.getCveUsuario());
			}
		}
		return ListSeguimiento;
	}
	private static String[] inicializaQueryNumero16(String[] querys, String cdo, String idEncuesta) {
		for (int i=0;i <querys.length; i++)
		{	
			querys[i]=querys[i].replace("{ID_ENCUESTA}", String.valueOf(idEncuesta));
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
	
	private static List<Seguimiento> llenaClaseSeguimiento(ResultSet rs, Usuario infoUsu) {
		List<Seguimiento> listSeguimiento= new ArrayList<>();
		try
		{
			if(rs != null)
			{
				while(rs.next())
				{
					Seguimiento seguimiento = new Seguimiento();
					seguimiento.setDepartamento(rs.getString("departamento"));
					seguimiento.setPuesto(rs.getString("puesto"));
					seguimiento.setNombre(rs.getString("nombre_completo"));
					seguimiento.setTotalEncuestas(rs.getInt("total_encuestas"));
					seguimiento.setTotalEncuestasTerm(rs.getInt("total_encuestas_term"));
					seguimiento.setIdEmpleado(rs.getString("id_empleado_evaluador"));
					seguimiento.setEstatus(rs.getString("desc_estatus"));
					listSeguimiento.add(seguimiento);
				}
			}			
		}
		catch(Exception e)
		{
			InsertaLogEncuestas.insertarLog(new LogEncuestas(),infoUsu.getUname(),infoUsu.getUname(),"Error en el metodo llenaClaseSeguimiento de la clase GestorSeguimiento. DETALLE: "+e.getMessage().toString().replace("'", "")+" Usuario: "+infoUsu.getCveUsuario(),infoUsu.getCveUsuario());
		}
		return listSeguimiento;
	}

	public static List<SeguimientoDetalle> consultaSeguimientoDetalle(List<Querys> listaQuerys, String cdo, String idEmpleado,
			Usuario infoUsu) {
		Connection connBD = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		connBD = ConexionBD.AbrirConexionBDD(cdo);	
		List<SeguimientoDetalle> ListSeguimiento = new ArrayList<>();
		//System.out.print(infoUsu);
		try {
			
			String[] querys = new String[25];	
			querys = Cls_Querys.LimpiaListaQuerys(querys);	
			querys = Cls_Querys.ObtieneQuerys(17, listaQuerys, querys);
			querys = inicializaQueryNumero17(querys, idEmpleado,cdo);
			pstm = connBD.prepareStatement("{call " + "DCH.usp_EXECUTE_QUERY(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			rs=  Cls_Querys.EjecutarQuery(querys[0], querys[1],querys[2], querys[3], querys[4], querys[5], querys[6],
														 querys[7], querys[8], querys[9],querys[10], querys[11], querys[12], querys[13], 
														 querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], 
														 querys[21], querys[22], querys[23], querys[24], "",pstm, connBD,infoUsu);
			
			//System.out.print(infoUsu);
			Cls_Querys.ImprimeQuerysConsola(querys,false,"Query 17");
			
			ListSeguimiento = llenaClaseSeguimientoDetalle(rs, infoUsu);			
			InsertaLogEncuestas.insertarLog(new LogEncuestas(),cdo,cdo,"Entrada a consultar Seguimiento Detalle Usuario: "+infoUsu.getCveUsuario()+"qry{"+Cls_Querys.regresaQuerys(querys,true)+"}",infoUsu.getCveUsuario());
		}catch(Exception ex)
		{
			InsertaLogEncuestas.insertarLog(new LogEncuestas(),cdo,cdo,"Error en el metodo consultaSeguimientoDetalle de la clase GestorSeguimiento. DETALLE: "+ex.getMessage().toString().replace("'", "")+" Usuario: "+infoUsu.getCveUsuario(),infoUsu.getCveUsuario());
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
				InsertaLogEncuestas.insertarLog(new LogEncuestas(),cdo,cdo,"ERROR al cerrar conexion en GestorSeguimiento.ConsultaSeguimientoDetalle: " + e.toString().replace("'", "")+" Usuario: "+infoUsu.getCveUsuario(),infoUsu.getCveUsuario());
			}
		}
		return ListSeguimiento;
	}

	private static List<SeguimientoDetalle> llenaClaseSeguimientoDetalle(ResultSet rs, Usuario infoUsu) {
		List<SeguimientoDetalle> listSeguimiento= new ArrayList<>();
		try
		{
			if(rs != null)
			{
				while(rs.next())
				{
					SeguimientoDetalle seguimiento = new SeguimientoDetalle();
					seguimiento.setNombre(rs.getString("nombre_completo"));
					seguimiento.setEstatus(rs.getString("estatus"));
					seguimiento.setFechaFin(rs.getString("fecha_vigencia_fin"));
					seguimiento.setFechaInicio(rs.getString("fecha_vigencia_Inicio"));
					seguimiento.setIdEmpleadoEv(rs.getString("id_empleado_evaluado"));
					seguimiento.setPerfil(rs.getString("descripcion_perfil_colaborador"));
					seguimiento.setPreguntasContestadas(rs.getInt("num_pregunta"));
					seguimiento.setPuesto(rs.getString("puesto"));
					seguimiento.setTotalPreguntas(rs.getInt("todas_preguntas"));
					listSeguimiento.add(seguimiento);
				}
			}			
		}
		catch(Exception e)
		{
			InsertaLogEncuestas.insertarLog(new LogEncuestas(),infoUsu.getUname(),infoUsu.getUname(),"Error en el metodo llenaClaseSeguimiento de la clase GestorSeguimiento. DETALLE: "+e.getMessage().toString().replace("'", "")+" Usuario: "+infoUsu.getCveUsuario(),infoUsu.getCveUsuario());
		}
		return listSeguimiento;
	}

	private static String[] inicializaQueryNumero17(String[] querys, String idEmpleado, String cdo) {
		for (int i=0;i <querys.length; i++)
		{	
			querys[i]=querys[i].replace("{ID_EMPLEADO_EVALUADOR}", String.valueOf(idEmpleado));
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
}
