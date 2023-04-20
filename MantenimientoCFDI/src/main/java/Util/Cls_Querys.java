package Util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Datos.Querys;
import Datos.Usuario;

public class Cls_Querys {
	/*** CONSULTA LISTA DE QUERYS  ***/
	public static List<Querys> ConsultaTablaQuerysBD(Connection connBD,String cdo)
	{
		PreparedStatement pstmt =null;
		ResultSet rs=null;
		List<Querys> querys= new ArrayList<>();

		try
		{
			String qry = "SELECT 		DISTINCT proc_web AS proceso, "+
											"indice_query, "+
											"sub_indice_query, "+
											"descripcion, "+
											"estructura AS query "+
								"  FROM 	"+cdo.toUpperCase()+".QUERYS where proc_web = '175' " +
								"  ORDER BY indice_query ASC, " +
											"sub_indice_query ASC;";
// System.out.println(qry);
			pstmt = connBD.prepareStatement(qry);
			rs = pstmt.executeQuery();
			
			if (rs != null)
	        {
		        while (rs.next())
		        {
		        	Querys query= new Querys();
		        	query.setProceso(rs.getInt("proceso"));
		        	query.setIndice_query(rs.getInt("indice_query"));
		        	query.setSub_indice_query(rs.getInt("sub_indice_query"));
		        	query.setDescripcion(rs.getString("descripcion"));
		        	query.setQuery(rs.getString("query"));	  
	        		querys.add(query);
		        }
	        }
		}
		catch(Exception ex)
		{
			System.out.println("[NuevoportalRamaCDO.- Error: Consultar tabla de querys ,  Clase: GestorPaginaPrincipal,  Detalle: " + ex.getMessage().toString() +"]");
			
			
		}
		finally 
		{
			try {pstmt.close();} catch (SQLException e) {e.printStackTrace();}
		}
		return querys;
	}

	public static String[] ObtieneQuerys(int noQuery, List<Querys> ListaTodosQuerys, String[] ListaQuerys) {
		String[] querys = ListaQuerys;
		int cont = 0;
		String qry = "";

		for (int item = 0; item < ListaTodosQuerys.size(); item++) {
			if (ListaTodosQuerys.get(item).getIndice_query() == noQuery) {
				qry = ListaTodosQuerys.get(item).getQuery().toString();
				querys[cont] = qry;
				cont++;
			}
		}
		return querys;
	}

	public static String[] ObtieneQuerysAnidados(int noQuery, int noQuery2, int noQuery3, List<Querys> ListaTodosQuerys,
			String[] ListaQuerys) {
		String[] querys = ListaQuerys;
		int cont = 0;
		String qry = "";

		for (int item = 0; item < ListaTodosQuerys.size(); item++) {
			if (ListaTodosQuerys.get(item).getIndice_query() == noQuery) {
				qry = ListaTodosQuerys.get(item).getQuery().toString();
				qry = qry.replace("{CDO}", "");
				querys[cont] = qry;
				cont++;
			}
		}

		for (int item = 0; item < ListaTodosQuerys.size(); item++) {
			if (ListaTodosQuerys.get(item).getIndice_query() == noQuery2) {
				qry = ListaTodosQuerys.get(item).getQuery().toString();
				qry = qry.replace("{CDO}", "");
				querys[cont] = qry;
				cont++;
			}
		}

		for (int item = 0; item < ListaTodosQuerys.size(); item++) {
			if (ListaTodosQuerys.get(item).getIndice_query() == noQuery3) {
				qry = ListaTodosQuerys.get(item).getQuery().toString();
				qry = qry.replace("{CDO}", "");
				querys[cont] = qry;
				cont++;
			}
		}
		return querys;
	}

	public static String[] LimpiaListaQuerys(String[] listaQuerys) {
		String[] querys = listaQuerys;
		for (int i = 0; i < querys.length; i++) {
			querys[i] = "";
		}
		return querys;
	}

	public static void ImprimeQuerysConsola(String[] listaQuerys, boolean imprimir, String leyenda) {
		if (imprimir) {
			System.out.println(leyenda);
			String[] querys = listaQuerys;
			for (int i = 0; i < querys.length; i++) {
				if (!querys[i].contentEquals("")) {
					System.out.println(querys[i].toString());
				}
			}
		}
	}
	public static String regresaQuerys(String[] listaQuerys, boolean imprimir) {
		String querys2="";
		if (imprimir) {
			//System.out.println(leyenda);
			String[] querys = listaQuerys;
			for (int i = 0; i < querys.length; i++) {
				if (!querys[i].contentEquals("")) {
					querys2+=querys[i].toString().replaceAll("'", "");
				}
			}
		}
		return querys2;
	}
	public static ResultSet EjecutarQuery(String qry1, String qry2, String qry3, String qry4, String qry5, String qry6,
			String qry7, String qry8, String qry9, String qry10, String qry11, String qry12, String qry13, String qry14,
			String qry15, String qry16, String qry17, String qry18, String qry19, String qry20, String qry21,
			String qry22, String qry23, String qry24, String qry25, String cdo, PreparedStatement pstmt,
			Connection conexion, Usuario infoUsu) {

		ResultSet rs = null;
		try {
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
			System.out.println("Error: Cls_Querys.EjecutarQuery Error: " + ex);
			//InsertaLogEncuestas.insertarLog(new LogEncuestas(), infoUsu.getUname(),infoUsu.getUname(),("Error: Cls_Querys.EjecutarQuery Error: " + ex),infoUsu.getCveUsuario());
		}
		return rs;

	}
	
}
