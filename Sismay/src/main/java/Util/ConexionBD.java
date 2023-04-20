package Util;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConexionBD {
	//static final private String usuarioBD = "armando.rosas";
	//static final private String passwordBD = "ARosas18982";
	
//	static final private String USUARIO_BD = "admin.www";
//	static final private String PASSWORD_BD = "hENNR5eIGwMz";
//	static final private String SERVIDOR_BD = "webcdobd18.corprama.com.mx";
	static final private String USUARIO_BD = "desmay";
	static final private String PASSWORD_BD = "D3sM4y2020";
	static final private String SERVIDOR_BD = "deswebcdobd18.corprama.com.mx";
////	
	static final private String NOMBRE_BD = "comercio_electronico";
	
	public static Connection abrirConexionBD()
	{		
		String  nombreServidorBD = "jdbc:mysql://" + SERVIDOR_BD + ":3306/" + NOMBRE_BD;
		Connection conexionBD=null;
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			conexionBD = DriverManager.getConnection(nombreServidorBD,USUARIO_BD,PASSWORD_BD); 
		}
		catch(Exception ex)
		{
			System.out.println("NuevoportalRamaCDO.- Error al abrir la conexión a la BD. abrirConexionBD" + nombreServidorBD);
			System.out.println("NuevoportalRamaCDO.- Error al abrir la conexión a la BD. abrirConexionBD" + ex.toString());
		}
		return conexionBD;
	
	}
}
