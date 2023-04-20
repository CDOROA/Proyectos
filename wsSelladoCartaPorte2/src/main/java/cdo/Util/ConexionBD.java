package cdo.Util;

import java.sql.DriverManager;
import java.sql.Connection;

public class ConexionBD
{
//    private static final String usuarioBD = "procesos.almacen";
//    private static final String passwordBD = "pr0c3s0s.4lm4c3n";

 //   private static final String usuarioBD = "admin.envios";
 //  private static final String passwordBD = "KjxnpwqzquRtfAJc";
	
 //   private static final String usuarioBD = "armando.rosas";
 //   private static final String passwordBD = "ARosas18982";
    
	// LA QUE ESTA EN USO: 	
	 private static final String usuarioBD = "ws.carta.porte";
	 private static final String passwordBD = "cfd1p0rt#";
	 
//    public static Connection AbrirConexionBDD1(final String cdo) 
//    {
//        Connection conexionBD = null;
//        final String nombreServidorBD = "jdbc:mysql://" + cdo.toUpperCase() + ".corprama.com.mx:3306/" + cdo.toUpperCase();
//        try {
//            Class.forName("com.mysql.jdbc.Driver");
//            conexionBD = DriverManager.getConnection(nombreServidorBD, usuarioBD1, passwordBD1);
//        }
//        catch (Exception ex) {}
//        return conexionBD;
//    }
    
//    private static final String usuarioBD = "wstransportes";
//    private static final String passwordBD = "wsTr5snp0ry643";
    
    public static Connection AbrirConexionBDD(final String cdo) 
    {
        Connection conexionBD = null;
        final String nombreServidorBD = "jdbc:mysql://" + cdo.toUpperCase() + ".corprama.com.mx:3306/" + cdo.toUpperCase();
       // System.out.println("Conexxion: " + nombreServidorBD);
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conexionBD = DriverManager.getConnection(nombreServidorBD, usuarioBD, passwordBD);
        }
        catch (Exception ex) {
        	System.out.println("eRROR AL ABRIR LA CONEXXION:" +  ex);
        }
        return conexionBD;
    }
    
    
}