package cdo.Util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Cls_log {

	public void Insrtalog(String cdo, String serie, int folio,String menasje )
	{
		Connection connBD = null;
		PreparedStatement pstmt= null;
		try
		{
			String Query = "INSERT INTO CFDI.cp_log (serie, folio, fecha, hora, accion, id_catalogo, id_tipo) VALUES ('"+serie+"', '"+folio+"', DATE(NOW()), TIME(NOW()), '"+menasje+"', '', '');";

			connBD = ConexionBD.AbrirConexionBDD(cdo);	
			pstmt = connBD.prepareStatement(Query);
			pstmt.executeUpdate();
		}
		catch(Exception ex)
		{
			System.out.println("wsSelladoCartaPorte.- Error al insertar Log.Insrtalog. Detalle del Error: " + ex );
		}
		finally
		{
			try {pstmt.close();} catch (SQLException e) {}
			try {connBD.close();} catch (SQLException e) {}
		}
	}
}
