package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import datos.Banners;
import datos.Querys;
import datos.Videos;
import util.Cls_Querys;

public class GestorVideos {

	public static List<Videos> ObtenVideos(Connection connBD, List<Querys> listaQuerys)
	{
		PreparedStatement pstm= null;
		List<Videos> listaVideos = null;
		try
		{
			
			String[] querys = new String[25];
			querys = Cls_Querys.LimpiaListaQuerys(querys);
			querys = Cls_Querys.ObtieneQuerys(3, listaQuerys, querys);
			pstm = connBD.prepareStatement("{call " + "OEP.usp_EXECUTE_QUERY(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			Cls_Querys.ImprimeQuerysConsola(querys,false,"Query 3");
			ResultSet rs=  Cls_Querys.EjecutarQuery(querys[0], querys[1],querys[2], querys[3], querys[4], querys[5], querys[6],
														 querys[7], querys[8], querys[9],querys[10], querys[11], querys[12], querys[13], 
														 querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], 
														 querys[21], querys[22], querys[23], querys[24], "",pstm, connBD);
			if(rs != null)
			{
				listaVideos = new ArrayList<Videos>();
	    		while (rs.next())
	    		{
	    			Videos video = new Videos();
	    			video.setCveVideo(rs.getInt("cve_video"));
	    			video.setDescripcion(rs.getString("descripcion"));
	    			video.setUrlImagen(rs.getString("url_imagen"));
	    			video.setUrlVideo(rs.getString("url_video"));
	    			listaVideos.add(video);
	    		}
			}
		}
		catch(Exception ex)
		{
			System.out.println("[ Portal OEP ] GestorPaginaPrincipal.ObtenVideos Error: " + ex);
		}
		finally 
		{
			try {pstm.close();} catch (SQLException e) {e.printStackTrace();}
		}
		return listaVideos;
		 
	}
}
