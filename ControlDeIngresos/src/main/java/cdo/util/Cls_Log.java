package cdo.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import cdo.Datos.Log;
import cdo.Datos.Usuario;

public class Cls_Log 
{
	public static void insertaLog(Usuario infoUsu,String dato1, String dato2, String accion)
	{
		Log log = new Log(dato1,dato2,accion);
		insertaSentenciaLogBD(infoUsu, log);
	}
	
	public static void insertaSentenciaLogBD(Usuario infoUsu, Log log)
	{
		Connection connBD = null;
		PreparedStatement pstm= null;		
		connBD = ConexionBD.AbrirConexionBD(infoUsu.getUname());
		try
		{
			String query = InicializaQuery(infoUsu, log);
			pstm = connBD.prepareStatement("{call " + "CTRL_INGRESOS.usp_EXECUTE_QUERY(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			EjecutaQuerysBD.EjecutarQuery(query, "","", "", "", "",  "", "", "", "","", "", "","", "", "","", "", "", "", "", "", "","", "", infoUsu.getUname(),pstm, connBD);
		}
		catch(Exception ex)
		{
			System.out.println("Error al insertar Log.\nDetalle del Error: " + ex.getMessage().toString() );
		}
		finally
		{
			try {pstm.close();} catch (SQLException e) {e.printStackTrace();}
			try {connBD.close();} catch (SQLException e) {e.printStackTrace();}
		}
	}
	
	public static String InicializaQuery(Usuario infoUsu, Log log )
	{
		String Query =  "INSERT INTO CTRL_INGRESOS.cc_LOG_CAJA"
									+ "(uname,  "
									+ "id_origen_ingreso,"
									+ "cve_usuario, "
									+ "dato_1, "
									+ "dato_2, "
									+ "accion, "
									+ "fecha_pro, "
									+ "hora_pro) "
						+"VALUES"
								    + "('" + infoUsu.getUname_br() + "', "
								    + "'3', "
								    + "'" + infoUsu.getCve_usuario() +"', "
								    + "'" + log.getDato_1() + "',"
								    + "'" + log.getDato_2() + "', "
								    + "'" + log.getAccion() + "', "
								    + "CURDATE(),"
								    + " CURTIME());";
		return Query;
	}
	

}
