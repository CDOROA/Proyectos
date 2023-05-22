package cdo.Util;

import java.sql.DriverManager;
import java.util.prefs.Preferences;
import java.sql.Connection;

public class ConexionBD
{
	static Preferences preferences = Preferences.userNodeForPackage(Preferences.class);
    
	private static final String usuarioBD = "admin.cfdi";
    private static final String passwordBD = "cfdi130920";
    
//    private static final String usuarioBD = "daniel.calderon";
//    private static final String passwordBD = "dcalderon";
    
    private static final String usuarioBDA03 = "admin.cfdi";
    private static final String passwordBDA03 = "cfdi030519";
    
    
    public static Connection AbrirConexionBDD(final String cdo) 
    {
        final String nombreServidorBD = "jdbc:mysql://" + cdo.toUpperCase() + ".corprama.com.mx:3306/" + cdo.toUpperCase();
        final String nombreServidorBDA03 = "jdbc:mysql://a03:3306/CFDI";

        Connection conexionBD = null;
//        final String nombreServidorBD = "jdbc:mysql://des" + cdo.toLowerCase() + ":3306/" + cdo.toUpperCase();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            
            if (cdo.equals("a03")) 
            {
            	conexionBD = DriverManager.getConnection(nombreServidorBDA03, usuarioBDA03, passwordBDA03);
			}
            else
            {
            	conexionBD = DriverManager.getConnection(nombreServidorBD, usuarioBD, passwordBD);	
            }
            
        }
        catch (Exception ex) 
        {
        	String error = "";
        	if (ex.getMessage().toString().contains("\n")) 
        	{
        		String [] split = ex.getMessage().toString().split("\n");
        		for (int i = 0; i < split.length; i++) 
        		{
					error += ""+split[i]+"splitMsj";
				}
        		preferences.put("detalle", ""+error+"");
			}
        	preferences.put("detalle", ex.getMessage().toString());
        }
        return conexionBD;
    }
          
}