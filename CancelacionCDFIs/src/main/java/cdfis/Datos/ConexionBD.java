package cdfis.Datos;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConexionBD {
	
	static final private String usuarioBD = "admin.envios";
	static final private String passwordBD = "KjxnpwqzquRtfAJc";
	Connection conexionBD;

	public static Connection AbrirConexionBD(String cdo)
	{		
		
		if (cdo.equalsIgnoreCase("kwx"))
		{
			
			Connection conexionBD=null;
			String  nombreServidorBD = "jdbc:mysql://kwx:3306/KWX";
			 
			try
			{
				Class.forName("com.mysql.jdbc.Driver");
				conexionBD = DriverManager.getConnection(nombreServidorBD,"proc_automaticos","1210procaut"); 
				
			}
			catch(Exception ex)
			{
				System.out.println("Error al abrir la conexión a la BD.");
			}
			return conexionBD;
		}
		else 
		{
		
		
			Connection conexionBD=null;
			String  nombreServidorBD = "jdbc:mysql://"+cdo+":3306/CECOM";
			 
			try
			{
				Class.forName("com.mysql.jdbc.Driver");
				conexionBD = DriverManager.getConnection(nombreServidorBD,usuarioBD,passwordBD); 
				
			}
			catch(Exception ex)
			{
				System.out.println("Error al abrir la conexión a la BDD.");
			}
			return conexionBD;
		}
		
		
		
	}

	
}
