package cdo.Util;

import java.sql.DriverManager;
import java.sql.Connection;

public class ConexionBD
{
//    private static final String usuarioBD = "procesos.almacen";
//    private static final String passwordBD = "pr0c3s0s.4lm4c3n";

    private static final String usuarioBD = "admin.envios";
    private static final String passwordBD = "KjxnpwqzquRtfAJc";
    
    public static Connection AbrirConexionBDD(final String cdo) 
    {
        Connection conexionBD = null;
        final String nombreServidorBD = "jdbc:mysql://" + cdo.toUpperCase() + ".corprama.com.mx:3306/" + cdo.toUpperCase();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conexionBD = DriverManager.getConnection(nombreServidorBD, usuarioBD, passwordBD);
        }
        catch (Exception ex) {}
        return conexionBD;
    }
}