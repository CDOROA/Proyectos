package com.cordina.PortalCordinaKwx.Util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.HashMap;
import java.util.Map;

import com.cordina.PortalCordinaKwx.conexionBd.connectionLog;

public class clsLog {

	public static void RegistraLog(String modulo, String msg)
	{
		Connection connBD = null;
		PreparedStatement pstmt = null;
		String Qry = "INSERT INTO KWX.t_log_procesos_KWX (fecha ,hora,sistema,modulo,descripcion) VALUES"
				+ "(DATE(NOW()),TIME(NOW()),'portalRamaKWX','"+modulo+"','"+msg.replace("'", "")+"' )";
		try {

			connBD = connectionLog.AbrirConexionBD("");
			pstmt = connBD.prepareStatement(Qry);
			pstmt.executeUpdate();
			
		} catch (Exception ex) {
			System.out.println("PortalRama KWX - ERROR ENJ CLASE LOG: " + ex);
			System.out.println("PortalRama KWX - ERROR ENJ CLASE LOG getLocalizedMessage: " + ex.getLocalizedMessage());
			System.out.println("PortalRama KWX - ERROR ENJ CLASE LOG getMessage: " + ex.getMessage());
			System.out.println("PortalRama KWX - ERROR ENJ CLASE LOG getClass().getName(): " + ex.getClass().getName());
			
		} finally {
			try {
				connBD.close();
				pstmt.close();
			} catch (Exception e) {
			}
		}
	}
}
