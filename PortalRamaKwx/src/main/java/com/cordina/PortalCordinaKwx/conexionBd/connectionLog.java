package com.cordina.PortalCordinaKwx.conexionBd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class connectionLog {
	static final private String USUARIO_BD = "armando.rosas";
	static final private String PASSWORD_BD = "ARosas18982";

	public static Connection AbrirConexionBD(String servidorCdo) throws Exception{
		Connection conexionBD = null;
		String nombreServidorBD = "jdbc:mysql://172.16.251.105:3306/KWX";

		Class.forName("com.mysql.jdbc.Driver");
		conexionBD = DriverManager.getConnection(nombreServidorBD, USUARIO_BD, PASSWORD_BD);

		return conexionBD;
	}
	
	
	public static void closeConnection(Connection conn) {
		try {
			if(conn != null) conn.close();
		} 
		catch(SQLException e){} //Refactory modificar la estructura del codigo pero no la funcionalidad
	}
}
