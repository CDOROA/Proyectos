package cdo.Util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;



public class Cls_Logs {
	public static void insertarLog(String cdo,String tipoDoc,String documento, String serie,String folio,String accion)
	{

	Connection connBD = null;
	PreparedStatement pstmt = null;
	String qry = "";
	try
	{
		qry = "INSERT INTO CFDI.t_log_cancelacion_comprobante "+
				 "(tipo_documento, "+
				  "documento_cancelado, "+
				  "accion, " +
				  "cve_usu, "+
				  "serie,"+
				  "folio, "+
				  "fecha_pro,"+
				  "hora_pro) "+
		  "VALUES " +
				"('" + tipoDoc + "'," +
					"'"+documento+"', " +
				 "'"+accion+"', " +
				 "' ', " +
				 "  '"+serie+" ' , " +
				 "  '"+folio+"', " +
				 "CURDATE(), " +
				 "CURTIME()); ";
		//System.out.println(qry);
		connBD = ConexionBD.AbrirConexionBD(cdo);
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
	public static void insertarLogCancelado(String cdo,String uname_br,String tipoDoc,String documento, String serie,String folio,String accion)
	{

	Connection connBD = null;
	PreparedStatement pstmt = null;
	String qry = "";
	try
	{
		qry = "INSERT INTO CFDI.cancelacion_comprobante "+
				 "(uname, "+
				  "uname_br, "+
				  "tipo_documento, " +
				  "documento_cancelado, " +
				  "serie, "+
				  "folio,"+
				  "status, "+
				  "fecha_pro,"+
				  "hora_pro) "+
		  "VALUES " +
				"('" + cdo + "'," +
					"'"+uname_br+"', " +
				 "'"+tipoDoc+"', " +
				 "'"+documento+"', " +
				 "  '"+serie+" ' , " +
				 "  '"+folio+"', " +
				 "  '1', " +
				 "CURDATE(), " +
				 "CURTIME()); ";
		// System.out.println(qry);
		connBD = ConexionBD.AbrirConexionBD(cdo);
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
}
