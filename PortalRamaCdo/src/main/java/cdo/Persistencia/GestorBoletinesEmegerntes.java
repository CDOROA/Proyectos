package cdo.Persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import cdo.Datos.Querys;
import cdo.Util.Cls_Querys;
import cdo.Util.ConexionBD;
import cdo.Util.EjecutaQuerysBD;

public class GestorBoletinesEmegerntes {

	public String ConsultaListaDeBoletinesEmegerntes(List<Querys> ListaQuerys) throws Exception
	{
		Connection connBD = null;
		PreparedStatement pstm= null;
		connBD = ConexionBD.abrirConexionBD();	
		String nombreImagen="default.png";
		try
		{
			String[] querys = new String[25];	
			querys = Cls_Querys.LimpiaListaQuerys(querys);	
			querys = Cls_Querys.ObtieneQuerys(56, ListaQuerys, querys);
			//querys = inicializaQueryNumero56(querys);
			pstm = connBD.prepareStatement("{call " + "comercio_electronico.usp_EXECUTE_QUERY(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			ResultSet rs=  EjecutaQuerysBD.EjecutarQuery(querys[0], querys[1],querys[2], querys[3], querys[4], querys[5], querys[6],
														 querys[7], querys[8], querys[9],querys[10], querys[11], querys[12], querys[13], 
														 querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], 
														 querys[21], querys[22], querys[23], querys[24], "",pstm, connBD);
			

			Cls_Querys.ImprimeQuerysConsola(querys,false, "query 56");
		
			if (rs != null)
	        {
		        while (rs.next())
		        {
		        	nombreImagen = rs.getString("imagen");
		        }
	        }
		}
		catch(Exception ex)
		{
			 nombreImagen="default.png";
			//System.out.println("[NuevoportalRamaCDO.- Error: Obtener nombre de la imagen Emergente,  metodo: ConsultaListaDeBoletinesEmegerntes,  Detalle: " + ex.getMessage().toString() +"]"); 
			//Log log=new Log(0,Integer.parseInt(empresa_cte),Integer.parseInt(num_cte) ,0, "[Error: Obtener datos del cliente para contrasena,  Clase: GestorIniciaSession,  Detalle: " + ex.getMessage().toString() +"]");
			//Cls_Log.insertaLog(log);
			throw ex;
		}
		finally 
		{
			try {pstm.close();} catch (SQLException e) {e.printStackTrace();}
			try {connBD.close();} catch (SQLException e) {e.printStackTrace();}
		}
	 	// System.out.println("nombreImagen: " + nombreImagen);
		return nombreImagen;
	}
	
}
