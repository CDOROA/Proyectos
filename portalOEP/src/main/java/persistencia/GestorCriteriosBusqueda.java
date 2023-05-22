package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import datos.CriteriosBusqueda;
import datos.Querys;
import datos.Videos;
import util.Cls_Querys;

public class GestorCriteriosBusqueda {

	public static void insertaCriteriosBusqueda(Connection connBD, List<Querys> listaQuerys, CriteriosBusqueda criterio)
	{
		PreparedStatement pstm= null;
		List<Videos> listaVideos = null;
		try
		{
			
			String[] querys = new String[25];
			querys = Cls_Querys.LimpiaListaQuerys(querys);
			querys = Cls_Querys.ObtieneQuerys(7, listaQuerys, querys);
			inicializaQueryNumero7(querys, criterio);
			pstm = connBD.prepareStatement("{call " + "OEP.usp_EXECUTE_QUERY(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			Cls_Querys.ImprimeQuerysConsola(querys,false,"Query 7");
			ResultSet rs=  Cls_Querys.EjecutarQuery(querys[0], querys[1],querys[2], querys[3], querys[4], querys[5], querys[6],
														 querys[7], querys[8], querys[9],querys[10], querys[11], querys[12], querys[13], 
														 querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], 
														 querys[21], querys[22], querys[23], querys[24], "",pstm, connBD);
			
		}
		catch(Exception ex)
		{
			System.out.println("[ Portal OEP ] GestorPaginaPrincipal.ObtenVideos Error: " + ex);
		}
		finally 
		{
			try {pstm.close();} catch (SQLException e) {e.printStackTrace();}
		}
  
	}
	 
	
	private static String[] inicializaQueryNumero7(String[] ListaQuerys, CriteriosBusqueda criterio) 
	{
		for (int i=0;i <ListaQuerys.length; i++)
		{
			ListaQuerys[i]= ListaQuerys[i].replace("{DESCRIPCION}", criterio.getDescripcion());	
			ListaQuerys[i]= ListaQuerys[i].replace("{TIPO}",  criterio.getTipo());	
			ListaQuerys[i]= ListaQuerys[i].replace("{CANTIDAD}", Integer.toString(criterio.getCantidad()));	
			ListaQuerys[i]= ListaQuerys[i].replace("{TOTAL_RESULTADOS}", Integer.toString(criterio.getTotalResultado()));	
		}
		return ListaQuerys;
	}
}
