package cdo.Util;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConexionBD {
//	static final private String USUARIO_BD = "admin.loader";
//	static final private String PASSWORD_BD = "loader.admin";
	
	static final private String USUARIO_BD = "admin.loader";
	static final private String PASSWORD_BD = "loader.admin";
	
	public static Connection AbrirConexionBD(String servidorCdo) throws Exception{
		Connection conexionBD = null;
		String nombreServidorBD = "";
		nombreServidorBD = "jdbc:mysql://"+servidorCdo.toLowerCase()+":3306/"+servidorCdo.toUpperCase();
		Class.forName("com.mysql.jdbc.Driver");
		conexionBD = DriverManager.getConnection(nombreServidorBD, USUARIO_BD, PASSWORD_BD);

		return conexionBD;
	}
}

