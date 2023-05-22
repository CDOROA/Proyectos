package Persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import Datos.Querys;
import Datos.Usuario;
import Util.Cls_Querys;
import Util.ConexionBD;
import Util.InsertaLogMantenientoCFDI;

public class GestorEstatus {

	public static String consultaEstatus(List<Querys> listaQuerys, String cdo, Usuario infoUsu) {
		Connection connBD = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		connBD = ConexionBD.AbrirConexionBDD(cdo);	
		String estatus="";
		
		try {
			
			String[] querys = new String[25];	
			querys = Cls_Querys.LimpiaListaQuerys(querys);	
			querys = Cls_Querys.ObtieneQuerys(26, listaQuerys, querys);
			//querys = inicializaQueryNumero24(querys, );
			pstm = connBD.prepareStatement("{call " + cdo.toUpperCase()+".usp_EXECUTE_QUERY(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			rs=  Cls_Querys.EjecutarQuery(querys[0], querys[1],querys[2], querys[3], querys[4], querys[5], querys[6],
														 querys[7], querys[8], querys[9],querys[10], querys[11], querys[12], querys[13], 
														 querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], 
														 querys[21], querys[22], querys[23], querys[24], "",pstm, connBD,infoUsu);
			
			
			Cls_Querys.ImprimeQuerysConsola(querys,false,"Query 24");
			
			if(rs != null)
			{
				while(rs.next())
				{
					estatus=rs.getString("estatus");
				}
			}			

			
			//InsertaLogEncuestas.insertarLog(new LogEncuestas(),cdo,cdo,"Entrada a consultar Evaluaciones Usuario: "+infoUsu.getCveUsuario()+" qry{"+Cls_Querys.regresaQuerys(querys,true)+"}",infoUsu.getCveUsuario());
		}catch(Exception ex)
		{
			System.out.println("Error en el metodo consultaCFDI de la clase GestorCFDI");
			//InsertaLogEncuestas.insertarLog(new LogEncuestas(),cdo,cdo,"Error en el metodo ConsultaEvaluaciones de la clase GestorEvaluaciones. DETALLE: "+ex.getMessage().toString().replace("'", "")+" Usuario: "+infoUsu.getCveUsuario(),infoUsu.getCveUsuario());
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
				System.out.println("ERROR al cerrar conexcion en GestorCFDI.consultaCFDI: " + e);
			}
		}
		return estatus;
	}

	public static String cambiaEstatus(List<Querys> listaQuerys, String cdo, Usuario infoUsu,String estatus) {
		Connection connBD = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		connBD = ConexionBD.AbrirConexionBDD(cdo);	
		String st="false";
		
		try {
			
			String[] querys = new String[25];	
			querys = Cls_Querys.LimpiaListaQuerys(querys);	
			querys = Cls_Querys.ObtieneQuerys(27, listaQuerys, querys);
			querys = inicializaQueryNumero27(querys, estatus);
			pstm = connBD.prepareStatement("{call " + cdo.toUpperCase()+".usp_EXECUTE_QUERY(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			rs=  Cls_Querys.EjecutarQuery(querys[0], querys[1],querys[2], querys[3], querys[4], querys[5], querys[6],
														 querys[7], querys[8], querys[9],querys[10], querys[11], querys[12], querys[13], 
														 querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], 
														 querys[21], querys[22], querys[23], querys[24], "",pstm, connBD,infoUsu);
			
			
			Cls_Querys.ImprimeQuerysConsola(querys,false,"Query 24");
			st="true";
			String temp="s";
			if(estatus.equals("1")) {
				temp="n";
			}
			InsertaLogMantenientoCFDI.insertarLog(cdo,"P-175 USUARIO: "+String.valueOf(infoUsu.getCveUsuario())+" Cambia estatus a: "+temp,String.valueOf("P175"),String.valueOf("175"));
			}catch(Exception ex)
		{
			System.out.println("Error en el metodo consultaCFDI de la clase GestorCFDI"+ex);
			//InsertaLogEncuestas.insertarLog(new LogEncuestas(),cdo,cdo,"Error en el metodo ConsultaEvaluaciones de la clase GestorEvaluaciones. DETALLE: "+ex.getMessage().toString().replace("'", "")+" Usuario: "+infoUsu.getCveUsuario(),infoUsu.getCveUsuario());
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
				System.out.println("ERROR al cerrar conexcion en GestorCFDI.consultaCFDI: " + e);
			}
		}
		return st;
	}

	private static String[] inicializaQueryNumero27(String[] querys, String estatus) {
		for(int i=0;i<querys.length;i++) {
			if(estatus.equals("1")) {
				querys[i]=querys[i].replace("{ESTATUS}", "n");
			}else {
				querys[i]=querys[i].replace("{ESTATUS}", "s");
			}
			
		}
		return querys;
	}

}
