package Util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class InsertaLogMantenientoCFDI {
	public static void insertarLog( String cdo,String accion,String serie,String folio2)
	{
	int folio=Integer.parseInt(folio2);
	Connection connBD = null;
	PreparedStatement pstmt = null;
	String qry = "";
	try
	{
		 qry = "INSERT INTO CFDI.l_log_cfdi "+
							 "(uname, "+
							  "serie, "+
							  "folio, " +
							  "descripcion, "+
							  "documento,"+
							  "documento_cfdi, "+
							  "ode,"+
							  "fecha_pro,"+
							  "hora_pro) "+
					  "VALUES " +
							"('" + cdo + "'," +
								"'"+serie+"', " +
							 ""+folio+", " +
							 "'"+accion+"', " +
							 "  ' ' , " +
							 "  ' ', " +
							 " 0, " +
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
		System.out.println(ex);
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
