package Util;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConexionBD {
	static final private String USUARIO_BD = "admin.loader";
	static final private String PASSWORD_BD = "loader.admin";

//	static final private String USUARIO_BD = "armando.rosas";
//	static final private String PASSWORD_BD = "ARosas18982";

//	
//	CONEXION A DESARROLLO
	public static Connection AbrirConexionBDD(String cdo)
	{		
		Connection conexionBD=null;
		String  nombreServidorBD = "jdbc:mysql://"+cdo.toUpperCase()+":3306/"+cdo.toUpperCase();
		//System.out.println(nombreServidorBD);
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			conexionBD = DriverManager.getConnection(nombreServidorBD,USUARIO_BD,PASSWORD_BD); 
		}
		catch(Exception ex)
		{
			System.out.println(ex);
			System.out.println("Error al abrir la conexión a la BD.");
			System.out.println("nombreServidorBD: "+ nombreServidorBD );
		}
		return conexionBD;
	}



//	CONEXION A PRODUCTIVO 
//	public static Connection AbrirConexionBDD(String cdo)
//	{		
//		Connection conexionBD=null;
//		String  nombreServidorBD = "jdbc:mysql://"+cdo.toUpperCase()+":3306/"+cdo.toUpperCase() ;
//		//System.out.println(nombreServidorBD);
//		try
//		{
//			Class.forName("com.mysql.jdbc.Driver");
//			conexionBD = DriverManager.getConnection(nombreServidorBD,USUARIO_BD,PASSWORD_BD); 
//		}
//		catch(Exception ex)
//		{
//			System.out.print(ex);
//			System.out.println("Error al abrir la conexión a la BD.");
//		}
//		return conexionBD;
//	}
}
