package Persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Datos.Empleado;
import Datos.LogEncuestas;
import Datos.Querys;
import Datos.Usuario;
import Util.Cls_Querys;
import Util.ConexionBD;
import Util.InsertaLogEncuestas;

public class GestorEmpleados {
	public List<Empleado> consultaEmpleados(List<Querys> listaQuerys, String cdo, Usuario infoUsu) {
		Connection connBD = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		connBD = ConexionBD.AbrirConexionBDD(cdo);	
		List<Empleado> ListEmpleados = new ArrayList<>();
		
		try {
			
			String[] querys = new String[25];	
			querys = Cls_Querys.LimpiaListaQuerys(querys);	
			querys = Cls_Querys.ObtieneQuerys(37, listaQuerys, querys);
			querys = inicializaQueryNumero37(querys, cdo);
			pstm = connBD.prepareStatement("{call " + "DCH.usp_EXECUTE_QUERY(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			rs=  Cls_Querys.EjecutarQuery(querys[0], querys[1],querys[2], querys[3], querys[4], querys[5], querys[6],
														 querys[7], querys[8], querys[9],querys[10], querys[11], querys[12], querys[13], 
														 querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], 
														 querys[21], querys[22], querys[23], querys[24], "",pstm, connBD,infoUsu);
			
			
			Cls_Querys.ImprimeQuerysConsola(querys,false,"Query 1");
			
			ListEmpleados = llenaClaseEmpleados(rs, infoUsu);			
			InsertaLogEncuestas.insertarLog(new LogEncuestas(),cdo,cdo,"Entrada a consultar Evaluaciones Usuario: "+infoUsu.getCveUsuario()+" qry{"+Cls_Querys.regresaQuerys(querys,true)+"}",infoUsu.getCveUsuario());
		}catch(Exception ex){
			System.out.println("error: "+ex);
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
		return ListEmpleados;
	}

	private String[] inicializaQueryNumero37(String[] querys, String cdo) {
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
		}
		return querys;
	}

	private List<Empleado> llenaClaseEmpleados(ResultSet rs, Usuario infoUsu) {
		List<Empleado> ListEmpleados= new ArrayList<>();
		try
		{
			if(rs != null)
			{
				while(rs.next())
				{
					Empleado e = new Empleado();
					e.setIdEmpleado(rs.getString("id_empleado"));
					e.setIdTipoEncuesta(rs.getString("id_tipo_encuesta"));
					e.setArea(rs.getString("area"));
					e.setDepto(rs.getString("depto"));
					e.setFechaIngreso(rs.getString("fechaIngreso"));
					e.setNombre(rs.getString("nombre"));
					e.setPuesto(rs.getString("puesto"));
					e.setSubdepto(rs.getString("subdepto"));
					e.setTipoEncuesta(rs.getString("tipoEncuesta"));
					e.setUname(rs.getString("uname"));
					e.setCorreo(rs.getString("correo"));
					ListEmpleados.add(e);
				}
			}			
		}
		catch(Exception e)
		{
			System.out.println("error: "+e);
			InsertaLogEncuestas.insertarLog(new LogEncuestas(),infoUsu.getUname(),infoUsu.getUname(),"Error en el metodo llenaClaseResultadosEmpDetalle de la clase GestorResultados. DETALLE: "+e.getMessage().toString().replace("'", "")+" Usuario: "+infoUsu.getCveUsuario(),infoUsu.getCveUsuario());
		}
		return ListEmpleados;
	}

	public String cambiaCorreo(List<Querys> listaQuerys, String cdo, Usuario infoUsu, String correo,
			String idTipoEncuesta, String idEmpleado) {
		Connection connBD = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		connBD = ConexionBD.AbrirConexionBDD(cdo);	
		String rsp="false";
		
		try {
			
			String[] querys = new String[25];	
			querys = Cls_Querys.LimpiaListaQuerys(querys);	
			querys = Cls_Querys.ObtieneQuerys(38, listaQuerys, querys);
			querys = inicializaQueryNumero38(querys, cdo, idEmpleado, idTipoEncuesta, correo);
			pstm = connBD.prepareStatement("{call " + "DCH.usp_EXECUTE_QUERY(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			rs=  Cls_Querys.EjecutarQuery(querys[0], querys[1],querys[2], querys[3], querys[4], querys[5], querys[6],
														 querys[7], querys[8], querys[9],querys[10], querys[11], querys[12], querys[13], 
														 querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], 
														 querys[21], querys[22], querys[23], querys[24], "",pstm, connBD,infoUsu);
			
			
			Cls_Querys.ImprimeQuerysConsola(querys,false,"Query 1");
			
			rsp="true";
			InsertaLogEncuestas.insertarLog(new LogEncuestas(),cdo,cdo,"Entrada a cambio correo Usuario: "+infoUsu.getCveUsuario()+" qry{"+Cls_Querys.regresaQuerys(querys,true)+"}",infoUsu.getCveUsuario());
		}catch(Exception ex){
			System.out.println("error1: "+ex);
			InsertaLogEncuestas.insertarLog(new LogEncuestas(),cdo,cdo,"Error en el metodo cambiaCorreo de la clase GestorEvaluaciones. DETALLE: "+ex.getMessage().toString().replace("'", "")+" Usuario: "+infoUsu.getCveUsuario(),infoUsu.getCveUsuario());
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
				System.out.println("ERROR al cerrar conexcion en GestorEmpleados.cambiaCorreo: " + e);
			}
		}
		return rsp;
	}

	private String[] inicializaQueryNumero38(String[] querys, String cdo, String idEmpleado, String idTipoEncuesta,
			String correo) {
		for(int i=0;i<querys.length;i++) {
			querys[i]=querys[i].replace("{ID_EMPLEADO}",idEmpleado);
			querys[i]=querys[i].replace("{ID_TIPO_ENCUESTA}",idTipoEncuesta);
			querys[i]=querys[i].replace("{CORREO}",correo);
		}
		return querys;
	}
}
