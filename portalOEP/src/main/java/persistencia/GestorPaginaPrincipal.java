package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import datos.Banners;
import datos.Querys;
import util.Cls_Querys;
import util.ConexionBD;

public class GestorPaginaPrincipal {
	/*** CONSULTA LISTA DE QUERYS  ***/
	public static List<Querys> ConsultaTablaQuerysBD(Connection connBD)
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
								"  FROM 	OEP.QUERYS where proc_web = '124' " +
								"  ORDER BY indice_query ASC, " +
											"sub_indice_query ASC;";

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
	
	
	public static List<Banners> ObtenBanners(Connection connBD, List<Querys> listaQuerys)
	{
		PreparedStatement pstm= null;
		List<Banners> listaBanners = null;
		try
		{
			
			String[] querys = new String[25];
			querys = Cls_Querys.LimpiaListaQuerys(querys);
			querys = Cls_Querys.ObtieneQuerys(1, listaQuerys, querys);
			pstm = connBD.prepareStatement("{call " + "OEP.usp_EXECUTE_QUERY(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			Cls_Querys.ImprimeQuerysConsola(querys,false,"Query 1");
			ResultSet rs_Baners=  Cls_Querys.EjecutarQuery(querys[0], querys[1],querys[2], querys[3], querys[4], querys[5], querys[6],
														 querys[7], querys[8], querys[9],querys[10], querys[11], querys[12], querys[13], 
														 querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], 
														 querys[21], querys[22], querys[23], querys[24], "",pstm, connBD);
			if(rs_Baners != null)
			{
				listaBanners = new ArrayList<Banners>();
	    		while (rs_Baners.next())
	    		{
		    		Banners banner = new Banners();
		    		banner.setId_banners(rs_Baners.getInt("id_baner"));
		    		banner.setNombre(rs_Baners.getString("nombre"));
		    		banner.setImagen(rs_Baners.getString("imagen"));
		    		banner.setDuracion(rs_Baners.getInt("duracion"));
		    		banner.setNum_orden(rs_Baners.getInt("orden"));
		    		//	System.out.println("banner: " + banner);
		    		listaBanners.add(banner);
	    		}
			}
		}
		catch(Exception ex)
		{
			System.out.println("[ Portal OEP ] GestorPaginaPrincipal.ObtenBanners Error: " + ex);
		}
		finally 
		{
			try {pstm.close();} catch (SQLException e) {e.printStackTrace();}
		}
		return listaBanners;
		 
	}
	
	public static String consultavideoprincipal(List<Querys> listaQuerys) {
		
		PreparedStatement pstm= null;
		Connection connBD = null;
		connBD = ConexionBD.abrirConexionBD();
		String respuesta = "";
		
		try
		{
			
			String[] querys = new String[25];
			querys = Cls_Querys.LimpiaListaQuerys(querys);
			querys = Cls_Querys.ObtieneQuerys(8, listaQuerys, querys);
			pstm = connBD.prepareStatement("{call " + "OEP.usp_EXECUTE_QUERY(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			Cls_Querys.ImprimeQuerysConsola(querys,false,"Query 8");
			ResultSet rs_Baners=  Cls_Querys.EjecutarQuery(querys[0], querys[1],querys[2], querys[3], querys[4], querys[5], querys[6],
														 querys[7], querys[8], querys[9],querys[10], querys[11], querys[12], querys[13], 
														 querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], 
														 querys[21], querys[22], querys[23], querys[24], "",pstm, connBD);
			if(rs_Baners != null)
			{
				
	    		while (rs_Baners.next())
	    		{
	    			respuesta=rs_Baners.getString("url_video");
	    		}
			}
		}
		catch(Exception ex)
		{
			System.out.println("[ Portal OEP ] GestorPaginaPrincipal.ObtenBanners Error: " + ex);
		}
		finally 
		{
			try {pstm.close();} catch (SQLException e) {e.printStackTrace();}
		}
		
		
		return respuesta;
	}
}
