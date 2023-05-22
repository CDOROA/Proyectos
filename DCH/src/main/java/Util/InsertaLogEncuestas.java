package Util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import Datos.LogEncuestas;

public class InsertaLogEncuestas {
	public static void insertarLog(LogEncuestas log, String cdo,String uname,String accion,String usuario)
	{

	Connection connBD = null;
	PreparedStatement pstmt = null;
	String qry = "";
	try
	{
		 qry = "INSERT INTO DCH.encuestas_log "+
							 "(uname, "+
							  "cve_usu, "+
							  "accion, " +
							  "fecha_pro, "+
							  "hora_pro) "+
					  "VALUES " +
							"('" + uname + "'," +
								"'"+usuario+"', " +
							 "'"+accion+"', " +
							 "CURDATE(), " +
							 "CURTIME()); ";
		// System.out.println("qry log almacen: "+qry);
		connBD = ConexionBD.AbrirConexionBDD(cdo);
	//System.out.println(qry);
		pstmt = connBD.prepareStatement(qry);
		pstmt.executeUpdate();
	}
	catch(Exception ex)
	{
	}
	finally 
	{
		try 
		{
			connBD.close();
			pstmt.close();
		} 
		catch (SQLException e) {e.printStackTrace();}
	}
	}
	public static String Qry(String qry) 
	{
		return qry.toString().replace("'","´");
	}
}
