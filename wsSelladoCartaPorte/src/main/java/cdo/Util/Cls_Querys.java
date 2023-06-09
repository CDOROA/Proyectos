package cdo.Util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import cdo.Entidades.Querys;

public class Cls_Querys {
	
	public static String[] ObtieneQuerys(int noQuery, List<Querys> ListaTodosQuerys, String[] ListaQuerys,  String cdo)
	{
		String[] querys = ListaQuerys;
		int cont = 0;
		String qry="";
		
		for(int item = 0; item < ListaTodosQuerys.size(); item++)
		{
			if(ListaTodosQuerys.get(item).getIndice_query() == noQuery)
			{
				qry= ListaTodosQuerys.get(item).getQuery().toString();
				qry= qry.replace("{CDO}",cdo.toUpperCase());
				qry= qry.replace("{UNAME_BR}",cdo.toLowerCase());
				querys[cont] = qry;
				cont++;
			}
		}
		return querys;
	}
	
	
	public static String[] LimpiaListaQuerys(String[] listaQuerys)
	{
		String[] querys = listaQuerys;
		for (int i = 0; i < querys.length ;i++) 
		{						
			querys[i] = "";
		}		
		return querys;				
	}

	public static void ImprimeQuerysConsola(String[] listaQuerys, boolean imprimir, String leyenda)
	{
		if(imprimir)
		{
			System.out.println(leyenda);
			String[] querys = listaQuerys;
			for (int i = 0; i < querys.length ;i++) 
			{				
				if (!querys[i].contentEquals(""))
				{
					System.out.println( querys[i].toString());
				}
			}		
		}	
	}
	
	public static ResultSet EjecutarQuery(String qry1, String qry2, String qry3, String qry4, String qry5, String qry6,
			String qry7, String qry8, String qry9, String qry10, String qry11, String qry12, String qry13, String qry14,
			String qry15, String qry16, String qry17, String qry18, String qry19, String qry20, String qry21,
			String qry22, String qry23, String qry24, String qry25, String cdo, PreparedStatement pstmt,
			Connection conexionBD) throws Exception{

		ResultSet rs = null;
		try {
			if(cdo.equalsIgnoreCase("a03")) {
				pstmt = conexionBD.prepareStatement("{call CFDI.usp_EXECUTE_QUERY(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			}else {
				pstmt = conexionBD.prepareStatement("{call "+cdo.toUpperCase()+".usp_EXECUTE_QUERY(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			}
			// conexion = ConexionBD.abrirConexionBD();
			pstmt.setString(1, qry1);
			pstmt.setString(2, qry2);
			pstmt.setString(3, qry3);
			pstmt.setString(4, qry4);
			pstmt.setString(5, qry5);
			pstmt.setString(6, qry6);
			pstmt.setString(7, qry7);
			pstmt.setString(8, qry8);
			pstmt.setString(9, qry9);
			pstmt.setString(10, qry10);
			pstmt.setString(11, qry11);
			pstmt.setString(12, qry12);
			pstmt.setString(13, qry13);
			pstmt.setString(14, qry14);
			pstmt.setString(15, qry15);
			pstmt.setString(16, qry16);
			pstmt.setString(17, qry17);
			pstmt.setString(18, qry18);
			pstmt.setString(19, qry19);
			pstmt.setString(20, qry20);
			pstmt.setString(21, qry21);
			pstmt.setString(22, qry22);
			pstmt.setString(23, qry23);
			pstmt.setString(24, qry24);
			pstmt.setString(25, qry25);
			rs = pstmt.executeQuery();
		} catch (Exception ex) {
			System.out.println("Error al  ejecutar querys:" + ex.toString());
			throw new Exception("Error al  ejecutar querys:" + ex.toString(),ex) ;
		}
		return rs;

	}
}
