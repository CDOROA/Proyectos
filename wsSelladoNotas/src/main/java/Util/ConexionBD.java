package Util;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConexionBD {
//	static final private String USUARIO_BD = "admin.cfdi";
//	static final private String PASSWORD_BD = "cfdi130920";
	static private String USUARIO_BD = "admin.loader";
	static private String PASSWORD_BD = "loader.admin";
	public static Connection AbrirConexionBD(String servidorCdo) throws Exception{
		Connection conexionBD = null;
		String nombreServidorBD = "";
		//desarrollo
		if(servidorCdo.equalsIgnoreCase("kwx")) {
			 USUARIO_BD = "admin.cfdi";
			 PASSWORD_BD = "cfdi130920";
			 
		}
		nombreServidorBD = "jdbc:mysql://"+servidorCdo.toLowerCase()+":3306/"+servidorCdo.toUpperCase();
		//productivo
		//nombreServidorBD = "jdbc:mysql://"+servidorCdo.toLowerCase()+":3306/"+servidorCdo.toUpperCase();
		Class.forName("com.mysql.jdbc.Driver");
		conexionBD = DriverManager.getConnection(nombreServidorBD, USUARIO_BD, PASSWORD_BD);

		return conexionBD;
	}
}

