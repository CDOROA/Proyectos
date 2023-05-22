
package cdo.Entidades;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.prefs.Preferences;

public class EjecutaQuerysBD
{
	static Preferences preferences = Preferences.userNodeForPackage(Preferences.class);
	public static ResultSet EjecutarQuery(final String qry1, final String qry2, final String qry3, final String qry4, final String qry5, final String qry6, final String qry7, final String qry8, final String qry9, final String qry10, final String qry11, final String qry12, final String qry13, final String qry14, final String qry15, final String qry16, final String qry17, final String qry18, final String qry19, final String qry20, final String qry21, final String qry22, final String qry23, final String qry24, final String qry25, final String cdo, final PreparedStatement pstmt, Connection conexion) {
        ResultSet rs = null;
        try {
//            conexion = ConexionBD.AbrirConexionBDD(cdo);
            pstmt.setString(1, qry1);
            pstmt.setString(2, qry2);
            pstmt.setString(3, qry3);
            pstmt.setString(4, qry4);
            pstmt.setString(5, qry5);
            pstmt.setString(6, qry6);
            pstmt.setString(7, qry7);
            pstmt.setString(8, qry8);
            pstmt.setString(9, qry9);
            pstmt.setString(10, qry10);
            pstmt.setString(11, qry11);
            pstmt.setString(12, qry12);
            pstmt.setString(13, qry13);
            pstmt.setString(14, qry14);
            pstmt.setString(15, qry15);
            pstmt.setString(16, qry16);
            pstmt.setString(17, qry17);
            pstmt.setString(18, qry18);
            pstmt.setString(19, qry19);
            pstmt.setString(20, qry20);
            pstmt.setString(21, qry21);
            pstmt.setString(22, qry22);
            pstmt.setString(23, qry23);
            pstmt.setString(24, qry24);
            pstmt.setString(25, qry25);
            rs = pstmt.executeQuery();
        }
        catch (Exception ex) 
        {
        	preferences.put("detalle", "ERROR: "+Error(ex)+". [*QUERYS*]: "+Qry(qry1)+Qry(qry2)+Qry(qry3)+Qry(qry4)+Qry(qry5)+Qry(qry6)+Qry(qry7));
        }
        return rs;
    }
    
    private static String Qry(final String qry) {
        return qry.toString().replace("'", "´");
    }
    
    private static String Error(final Exception e) {
        return e.toString().replace("'", "´");
    }
}
