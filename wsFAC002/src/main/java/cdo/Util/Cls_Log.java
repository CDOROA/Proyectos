package cdo.Util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import cdo.Util.ConexionBD;


public class Cls_Log {

	public static void insertaLog(String cdo, String folio, String num_cli, String accion)
	{
		Connection connBD = null;
		PreparedStatement pstm= null;		
		
		try
		{
			connBD = ConexionBD.AbrirConexionBD(cdo);
			String query = InicializaQuery(cdo,folio, num_cli,accion);
			pstm = connBD.prepareStatement("{call " + cdo.toUpperCase()+".usp_EXECUTE_QUERY(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			ClsQuery.EjecutarQuery(query, "","", "", "", "",  "", "", "", "","", "", "","", "", "","", "", "", "", "", "", "","", "", cdo,pstm, connBD);
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
	
	
	public static String InicializaQuery(String cdo, String folio, String num_cli, String accion)
	{
		String Query =  "INSERT INTO CFDI.ag_log"
									+ "(uname,  "
									+ "folio,"
									+ "num_cli, "
									+ "accion, "
									+ "fecha_pro, "
									+ "hora_pro) "
						+"VALUES"
								    + "('" + cdo + "', '"
								    + folio+ "', '"
								    + num_cli +"', '"
								    + accion + "', "
								    + "CURDATE(),"
								    + " CURTIME());";
		return Query;
	}
}
