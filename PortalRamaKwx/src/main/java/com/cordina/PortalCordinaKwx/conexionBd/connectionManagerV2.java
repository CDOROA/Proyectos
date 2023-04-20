package com.cordina.PortalCordinaKwx.conexionBd;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.cordina.PortalCordinaKwx.Util.clsLog;

public class connectionManagerV2 {
	//static final private String USUARIO_BD = "desmay";
	//static final private String PASSWORD_BD = "D3sM4y2020";
	private static String USUARIO_BD = "admin.kwx";
	private static String PASSWORD_BD = "Qu1MKw8";
	static Connection conexionBD=null;

	public static Connection getConnection() {
		
		 String  nombreServidorBD = "jdbc:mysql://webcdobd18.corprama.com.mx:3306/KWX";
	//	String  nombreServidorBD = "jdbc:mysql://127.0.0.1:3306/KWX";
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			conexionBD = DriverManager.getConnection(nombreServidorBD,USUARIO_BD,PASSWORD_BD); 
		}
		catch(Exception e)
		{
			 
			System.out.println("PortalRama KWX - Error al abrir la conexión a la BD.");
			System.out.println("PortalRama KWX - NombreServidorBD: "+ nombreServidorBD );
			System.out.println("PortalRama KWX - ConnectionManagerV2.getConnection.getLocalizedMessage: "+ e.getLocalizedMessage().replace("'", ""));
			System.out.println("PortalRama KWX - ConnectionManagerV2.getConnection.getMessage         : "+ e.getMessage().replace("'", ""));
			System.out.println("PortalRama KWX - ConnectionManagerV2.getConnection.getCause           : "+ e.getClass().getName().replace("'", ""));
			System.out.println("PortalRama KWX - ConnectionManagerV2.getConnection.getClass().getName : "+ e.getLocalizedMessage().replace("'", ""));
			
			clsLog.RegistraLog("PortalRama KWX - ConnectionManagerV2.getConnection", "getLocalizedMessage: "+ e.getLocalizedMessage().replace("'", ""));
			clsLog.RegistraLog("PortalRama KWX - ConnectionManagerV2.getConnection", "getMessage: "+ e.getMessage().replace("'", ""));
			clsLog.RegistraLog("PortalRama KWX - ConnectionManagerV2.getConnection", "getCause: "+ e.getClass().getName().replace("'", ""));
			clsLog.RegistraLog("PortalRama KWX - ConnectionManagerV2.getConnection", "getClass().getName: "+ e.getLocalizedMessage().replace("'", ""));
		}
		return conexionBD;
	}


	public static void closeConnection(Connection conn) {
		try {
			conexionBD.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
