package util;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConexionBD {

	 
	static final private String USUARIO_BD = "admin.oep";
	static final private String PASSWORD_BD = "4dmin03p";
	static final private String SERVIDOR_BD = "deswebcdobd18.corprama.com.mx";
	static final private String NOMBRE_BD = "OEP";
	
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
