package com.cordina.PortalCordinaKwx.conexionBd;

import java.sql.Connection;
import java.sql.SQLException;
import org.apache.tomcat.jdbc.pool.DataSource;
import org.apache.tomcat.jdbc.pool.PoolProperties;

public class connectionManager {
	
	//SERVIDOR PRODUCTIVO COMERCIO
	//private static String url = "jdbc:mysql://webcdo:3306";
	// private static String url = "jdbc:mysql://webcdo:3306";
	//private static String url = "jdbc:mysql://127.0.0.1:3306";
	private static String user = "admin.kwx";
	private static String password = "Qu1MKw8";
	private static String url = "jdbc:mysql://webcdobd18.corprama.com.mx:3306/KWX";
	//static final private String user = "desmay";
	//static final private String password = "D3sM4y2020";
	private static DataSource datasource = null;
	
	public static Connection getConnection(){
		Connection conn = null;
		try {
			
			if(datasource ==  null){
				datasource = new DataSource();
				PoolProperties p = new PoolProperties();
				p.setUrl(url);
				p.setDriverClassName("com.mysql.jdbc.Driver");
				p.setUsername(user);
				p.setPassword(password);
				p.setJmxEnabled(true);
				p.setTestWhileIdle(false);
				p.setTestOnBorrow(true);
				p.setValidationQuery("SELECT 1");
				p.setTestOnReturn(false);
				p.setValidationInterval(30000);
				p.setTimeBetweenEvictionRunsMillis(30000);
				p.setMaxActive(100);
				p.setInitialSize(10);
				p.setMaxWait(10000);
				p.setRemoveAbandonedTimeout(60);
				p.setMinEvictableIdleTimeMillis(30000);
				p.setMinIdle(10);
				p.setLogAbandoned(true);
				p.setRemoveAbandoned(true);
				p.setJdbcInterceptors("org.apache.tomcat.jdbc.pool.interceptor.ConnectionState;"
						+ "org.apache.tomcat.jdbc.pool.interceptor.StatementFinalizer");
				datasource.setPoolProperties(p);
			}			
						
			conn = datasource.getConnection();	
			
		} 
		catch(SQLException ex) {
			String sError= ex.getMessage().toString();
			System.out.println("PortalRama KWX - Error en conexion:" + sError);
		} 		
		
		return conn;
	}
	
	public static void closeConnection(Connection conn) {
		try {
			if(conn != null) conn.close();
		} 
		catch(SQLException e){} //Refactory modificar la estructura del codigo pero no la funcionalidad
	}
	
}