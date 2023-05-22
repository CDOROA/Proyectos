package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import datos.Anios;
import datos.Armadoras;
import datos.Banners;
import datos.Querys;
import datos.SubMarcas;
import util.Cls_Querys;

public class GestorArmadoras {
	public static List<Armadoras> ObtenArmadoras(Connection connBD, List<Querys> listaQuerys)
	{
		PreparedStatement pstm= null;
		List<Armadoras> listaArmadoras = null;
		try
		{
			
			String[] querys = new String[25];
			querys = Cls_Querys.LimpiaListaQuerys(querys);
			querys = Cls_Querys.ObtieneQuerys(4, listaQuerys, querys);
			pstm = connBD.prepareStatement("{call " + "OEP.usp_EXECUTE_QUERY(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			Cls_Querys.ImprimeQuerysConsola(querys,false,"Query 1");
			ResultSet rs=  Cls_Querys.EjecutarQuery(querys[0], querys[1],querys[2], querys[3], querys[4], querys[5], querys[6],
														 querys[7], querys[8], querys[9],querys[10], querys[11], querys[12], querys[13], 
														 querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], 
														 querys[21], querys[22], querys[23], querys[24], "",pstm, connBD);
			if(rs != null)
			{
				listaArmadoras = new ArrayList<Armadoras>();
	    		while (rs.next())
	    		{
	    			Armadoras arm = new Armadoras();
	    			arm.setCve_armadora(rs.getInt("cve_armadora"));
	    			arm.setNombre_armadora(rs.getString("nom_marca"));
	    			arm.setDescripcion_armadora(rs.getString("desc_marca"));
		    		listaArmadoras.add(arm);
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
		return listaArmadoras;
		 
	}


/*** CONSULTA DE SUBMARCAS ***/
public static List<SubMarcas> obtieneSubMarcas(Connection connBD, List<Querys> listaQuerys,String cve_armadora)
{
	PreparedStatement pstm= null;
	List<SubMarcas> listaSubMarcas = null;
	try
	{
		
		String[] querys = new String[25];
		querys = Cls_Querys.LimpiaListaQuerys(querys);
		querys = Cls_Querys.ObtieneQuerys(5, listaQuerys, querys);
		querys= inicializaQueryNumero5(querys,cve_armadora);
		pstm = connBD.prepareStatement("{call " + "OEP.usp_EXECUTE_QUERY(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
		Cls_Querys.ImprimeQuerysConsola(querys,false,"Query 5");
		ResultSet rs=  Cls_Querys.EjecutarQuery(querys[0], querys[1],querys[2], querys[3], querys[4], querys[5], querys[6],
													 querys[7], querys[8], querys[9],querys[10], querys[11], querys[12], querys[13], 
													 querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], 
													 querys[21], querys[22], querys[23], querys[24], "",pstm, connBD);
		if(rs != null)
		{
			listaSubMarcas = new ArrayList<SubMarcas>();
    		while (rs.next())
    		{
    			SubMarcas submarca = new SubMarcas();
				submarca.setCve_submarca(0);
				submarca.setNombre_submarca(rs.getString("desc_sub_marca"));
			 
    			listaSubMarcas.add(submarca);
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
	return listaSubMarcas;
	 
}

/*** CONSULTA DE SUBMARCAS ***/
public static List<Anios> obtieneAnios(Connection connBD, List<Querys> listaQuerys,String descSubMArca)
{
	PreparedStatement pstm= null;
	List<Anios> listaAnios = null;
	try
	{
		
		String[] querys = new String[25];
		querys = Cls_Querys.LimpiaListaQuerys(querys);
		querys = Cls_Querys.ObtieneQuerys(6, listaQuerys, querys);
		querys= inicializaQueryNumero6(querys,descSubMArca);
		pstm = connBD.prepareStatement("{call " + "OEP.usp_EXECUTE_QUERY(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
		Cls_Querys.ImprimeQuerysConsola(querys,false,"Query 6");
		ResultSet rs=  Cls_Querys.EjecutarQuery(querys[0], querys[1],querys[2], querys[3], querys[4], querys[5], querys[6],
													 querys[7], querys[8], querys[9],querys[10], querys[11], querys[12], querys[13], 
													 querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], 
													 querys[21], querys[22], querys[23], querys[24], "",pstm, connBD);
		if(rs != null)
		{
			listaAnios = new ArrayList<Anios>();
    		while (rs.next())
    		{
    			Anios an = new Anios();
    			an.setAnio( rs.getString("anio") );
				listaAnios.add(an);
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
	return listaAnios;
	 
}

private static String[] inicializaQueryNumero5(String[] ListaQuerys, String cve_armadora) 
{
	for (int i=0;i <ListaQuerys.length; i++)
	{
		ListaQuerys[i]= ListaQuerys[i].replace("{CVE_ARMADORA}", cve_armadora);						
	}
	return ListaQuerys;
}

private static String[] inicializaQueryNumero6(String[] ListaQuerys, String descSubMarca) 
{
	for (int i=0;i <ListaQuerys.length; i++)
	{
		ListaQuerys[i]= ListaQuerys[i].replace("{DESC_SUB_MARCA}", descSubMarca);						
	}
	return ListaQuerys;

}


}