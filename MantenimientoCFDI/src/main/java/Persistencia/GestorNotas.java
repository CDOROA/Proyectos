package Persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Datos.Nota;
import Datos.Querys;
import Datos.Usuario;
import Util.Cls_Querys;
import Util.ConexionBD;

public class GestorNotas {

	public static List<Nota> consultaNotas(List<Querys> listaQuerys, String cdo, Usuario infoUsu) {
		Connection connBD = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		connBD = ConexionBD.AbrirConexionBDD(cdo);	
		List<Nota> ListNota = new ArrayList<>();
		
		try {
			
			String[] querys = new String[25];	
			querys = Cls_Querys.LimpiaListaQuerys(querys);	
			querys = Cls_Querys.ObtieneQuerys(19, listaQuerys, querys);
			pstm = connBD.prepareStatement("{call " + cdo.toUpperCase()+".usp_EXECUTE_QUERY(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			rs=  Cls_Querys.EjecutarQuery(querys[0], querys[1],querys[2], querys[3], querys[4], querys[5], querys[6],
														 querys[7], querys[8], querys[9],querys[10], querys[11], querys[12], querys[13], 
														 querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], 
														 querys[21], querys[22], querys[23], querys[24], "",pstm, connBD,infoUsu);
			
			
			Cls_Querys.ImprimeQuerysConsola(querys,false,"Query 19");
			
			ListNota = llenaClaseCFDI(rs, infoUsu);	
			
			//InsertaLogEncuestas.insertarLog(new LogEncuestas(),cdo,cdo,"Entrada a consultar Evaluaciones Usuario: "+infoUsu.getCveUsuario()+" qry{"+Cls_Querys.regresaQuerys(querys,true)+"}",infoUsu.getCveUsuario());
		}catch(Exception ex)
		{
			System.out.println("Error en el metodo consultaCFDI de la clase GestorCFDI");
			//InsertaLogEncuestas.insertarLog(new LogEncuestas(),cdo,cdo,"Error en el metodo ConsultaEvaluaciones de la clase GestorEvaluaciones. DETALLE: "+ex.getMessage().toString().replace("'", "")+" Usuario: "+infoUsu.getCveUsuario(),infoUsu.getCveUsuario());
		}
		finally {
			try {
				if(connBD != null) {
					connBD.close();
				}
				if(pstm != null) {
					pstm.close();
				}
			} catch (Exception e) {
				System.out.println("ERROR al cerrar conexcion en GestorCFDI.consultaCFDI: " + e);
			}
		}
		return ListNota;
	}

	private static List<Nota> llenaClaseCFDI(ResultSet rs, Usuario infoUsu) {
		List<Nota> ListNota = new ArrayList<>();
		try
		{
			if(rs != null)
			{
				while(rs.next())
				{
					Nota n = new Nota();
					n.setClaveTran(rs.getString("cve_tran"));
					n.setDoctoTran(rs.getString("docto_tran"));
					n.setFechaFactura(rs.getString("fecha_factura"));
					n.setFechaTran(rs.getString("fecha_tran"));
					n.setFolioFiscal(rs.getString("folio_fiscal"));
					n.setNumFactura(rs.getString("num_fac"));
					n.setSerie(rs.getString("docto_serie"));
					n.setTipoTran(rs.getString("tipo_tran"));
					n.setTxtNota(rs.getString("txt_nota"));
					ListNota.add(n);
				}
			}			
		}
		catch(Exception ex)
		{
			//InsertaLogEncuestas.insertarLog(new LogEncuestas(),infoUsu.getUname(),infoUsu.getUname(),"Error en el metodo llenaClaseEvaluacion de la clase GestorEvaluaciones. DETALLE: "+ex.getMessage().toString().replace("'", "")+" Usuario: "+infoUsu.getCveUsuario(),infoUsu.getCveUsuario());
			System.out.println("[Error: Obtener catalogo de sucursales,  Clase: GestorCFDI.llenaClaseCFDI,  Detalle: " + ex.getMessage().toString() +"]");
			 
		}
		return ListNota;
	}

}
