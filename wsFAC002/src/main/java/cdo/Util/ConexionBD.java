package cdo.Util;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConexionBD {
		
		static final private String USUARIO_BD = "admin.loader";
		static final private String PASSWORD_BD = "loader.admin";
		
		static final private String USUARIO_BDBM = "proc_automaticos";
		static final private String PASSWORD_BDBM = "1210procaut";

		public static Connection AbrirConexionBD(String servidorCdo) throws Exception{
			Connection conexionBD = null;
			
			//PRODUCTIVO
			 String nombreServidorBD = "jdbc:mysql://" + servidorCdo.toUpperCase() + ":3306/"+ servidorCdo.toUpperCase()  ;
			// System.out.println("Conexion: "+nombreServidorBD);
			//PARA PUEBAS:
			// String nombreServidorBD = "jdbc:mysql://des" + servidorCdo.toUpperCase() + ":3306/CDF";

			Class.forName("com.mysql.jdbc.Driver");
			conexionBD = DriverManager.getConnection(nombreServidorBD, USUARIO_BD, PASSWORD_BD);

			return conexionBD;
		}
		
		public static Connection AbrirConexionBDDBM() throws Exception{
			Connection conexionBD = null;
			
			String nombreServidorBD = "jdbc:mysql://dbm:3307/CDO";

			Class.forName("com.mysql.jdbc.Driver");
			conexionBD = DriverManager.getConnection(nombreServidorBD, USUARIO_BDBM, PASSWORD_BDBM);

			return conexionBD;
		}
}
