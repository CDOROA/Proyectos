package cdfis.Persistencia;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import cdfis.Datos.ConexionBD;
import cdfis.Datos.DatosTemporales;
import cdfis.Datos.EjecutaQuerysBD;
import cdfis.Datos.Querys;
import cdfis.Datos.Usuario;
import cdfis.util.Cls_Querys;

public class GestorCreditoCargoKWX {

	public List<DatosTemporales> consultarNotas(String documento,String tipo_documento, List<DatosTemporales>listaConsultaNota,String cdo,List<Querys> ListaQuerys,Usuario infoUsu) 
	{
		Connection connBD = null;
		PreparedStatement pstm= null;		
		connBD = ConexionBD.AbrirConexionBD(infoUsu.getUname());
		String clave_tran=null;
		if (tipo_documento.equals("2")) 
		{
			clave_tran = "5";
			tipo_documento="Nota de credito";
		}
		if (tipo_documento.equals("3")) 
		{
			clave_tran = "6";
			tipo_documento="Nota de cargo";
		}
		try 
		{
			String[] querys = new String[25];	
			querys = Cls_Querys.LimpiaListaQuerys(querys);
			querys = Cls_Querys.ObtieneQuerys(8, ListaQuerys, querys, cdo);	
			querys = InicializaQueryNumero3(querys, infoUsu,clave_tran,documento);
			pstm = connBD.prepareStatement("{call " + infoUsu.getUname().toUpperCase() +".usp_EXECUTE_QUERY(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			ResultSet rs = EjecutaQuerysBD.EjecutarQuery(querys[0], querys[1],querys[2], querys[3], querys[4], querys[5], querys[6],
					querys[7], querys[8], querys[9],querys[10], querys[11], querys[12], querys[13], 
					querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], 
					querys[21], querys[22], querys[23], querys[24], infoUsu.getUname(),pstm, connBD);
			
			if (rs != null)
			 {
				listaConsultaNota=llenarNota(rs, tipo_documento, documento,listaConsultaNota);
			}

		}
		catch(Exception ex)
		{
			String sError= ex.getMessage().toString();
		}
		finally
		{
			try {connBD.close();} catch (SQLException e) {e.printStackTrace();}
			try {pstm.close();} catch (SQLException e) {e.printStackTrace();}
		}	
		return listaConsultaNota;
	}
	
	
	public static List<DatosTemporales> llenarNota(ResultSet rs,String tipo_documento,String documento, List<DatosTemporales>listaConsultaNota)
	{

		try 
		{
			while(rs.next())
			{
				DatosTemporales datosCancelacion2  =new DatosTemporales();
				datosCancelacion2.setSerie(rs.getString("serie"));
				datosCancelacion2.setFolio(rs.getString("folio"));
				datosCancelacion2.setCdo(rs.getString("nombre_corto"));
				datosCancelacion2.setTipodocumento(tipo_documento);
				datosCancelacion2.setFactura(rs.getString("num_fac"));
				datosCancelacion2.setDocumentoacancelar(documento);
				datosCancelacion2.setReferencia(rs.getString("referencia_tran"));
				datosCancelacion2.setAv(rs.getString("agent_vend"));
				datosCancelacion2.setCte(rs.getString("num_cli"));
				datosCancelacion2.setNombre(rs.getString("nombre"));
				datosCancelacion2.setRazonocial(rs.getString("razon_social"));
				datosCancelacion2.setFechadocumento(rs.getString("fecha_tran"));				
				datosCancelacion2.setImporte(rs.getString("total"));
				datosCancelacion2.setUuid(rs.getString("folio_fiscal"));
				datosCancelacion2.setUsuario(rs.getString("usuario"));
				datosCancelacion2.setPassword(rs.getString("password"));
				datosCancelacion2.setCuenta(rs.getString("cuenta"));
				datosCancelacion2.setSucursal(rs.getString("sucursal"));
				datosCancelacion2.setEmisor(rs.getString("emisor"));
				if (rs.getString("cancelado").equals("NO")) {
					datosCancelacion2.setCancelado("NO");
				}else {
					datosCancelacion2.setCancelado("SI");
				}
				listaConsultaNota.add(datosCancelacion2);
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return listaConsultaNota;
	}
	
	


	public static boolean verificarSelladoNota(List<Querys> ListaQuerys,Usuario infoUsu,String documento,String tipo_documento,String cdo) 
	{
		Connection connBD = null;
		PreparedStatement pstm= null;		
		connBD = ConexionBD.AbrirConexionBD(infoUsu.getUname());
		boolean selladoNota = false;
		String clave_tran=null;
		if (tipo_documento.equals("2"))
		{
			clave_tran = "5";
		}
		if (tipo_documento.equals("3")) 
		{
			clave_tran = "6";
		}
		try 
		{
			
			String[] querys = new String[25];	
			querys = Cls_Querys.LimpiaListaQuerys(querys);
			querys = Cls_Querys.ObtieneQuerys(4, ListaQuerys, querys, cdo);	
			querys = InicializaQueryNumero3(querys, infoUsu,clave_tran,documento);
			pstm = connBD.prepareStatement("{call " + infoUsu.getUname().toUpperCase() +".usp_EXECUTE_QUERY(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			ResultSet rs = EjecutaQuerysBD.EjecutarQuery(querys[0], querys[1],querys[2], querys[3], querys[4], querys[5], querys[6],
					querys[7], querys[8], querys[9],querys[10], querys[11], querys[12], querys[13], 
					querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], 
					querys[21], querys[22], querys[23], querys[24], infoUsu.getUname(),pstm, connBD);
		
				 while (rs.next())
			        {	
					 	String folio_fiscal = rs.getString("folio_fiscal");
						if (folio_fiscal != null) 
						{
							selladoNota=true;
						} 
			        }
			
			
		}
		catch(Exception ex)
		{
			String sError= ex.getMessage().toString();
		}
		finally
		{
			try {connBD.close();} catch (SQLException e) {e.printStackTrace();}
			try {pstm.close();} catch (SQLException e) {e.printStackTrace();}
		}	
		return selladoNota;
		
	}

public boolean existenciaNota(List<Querys> ListaQuerys,Usuario infoUsu,String documento, String tipo_documento,String cdo) {

	Connection connBD = null;
	PreparedStatement pstm= null;		
	connBD = ConexionBD.AbrirConexionBD(infoUsu.getUname());
	boolean existenciaNota = false;
	String clave_tran=null;
	if (tipo_documento.equals("2"))
	{
		clave_tran = "5";
	}
	if (tipo_documento.equals("3")) 
	{
		clave_tran = "6";
	}
	try 
	{
		
		String[] querys = new String[25];	
		querys = Cls_Querys.LimpiaListaQuerys(querys);
		querys = Cls_Querys.ObtieneQuerys(3, ListaQuerys, querys, cdo);	
		querys = InicializaQueryNumero3(querys, infoUsu,clave_tran,documento);
		pstm = connBD.prepareStatement("{call " + infoUsu.getUname().toUpperCase() +".usp_EXECUTE_QUERY(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
		ResultSet rs = EjecutaQuerysBD.EjecutarQuery(querys[0], querys[1],querys[2], querys[3], querys[4], querys[5], querys[6],
				querys[7], querys[8], querys[9],querys[10], querys[11], querys[12], querys[13], 
				querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], 
				querys[21], querys[22], querys[23], querys[24], infoUsu.getUname(),pstm, connBD);

		if (rs != null)
		 {
			 while (rs.next())
		        {
				 existenciaNota = true;
		        }
		 }
		
	}
	catch(Exception ex)
	{
		String sError= ex.getMessage().toString();
	}
	finally
	{
		try {connBD.close();} catch (SQLException e) {e.printStackTrace();}
		try {pstm.close();} catch (SQLException e) {e.printStackTrace();}
	}	
	return existenciaNota;
	
}

private static String[] InicializaQueryNumero3(String[] ListaQuerys, Usuario infoUsu,String CLAVETRAN, String DOCUMENTO) {
	
	for (int i=0;i <ListaQuerys.length; i++)
	{			
		ListaQuerys[i]= ListaQuerys[i].replace("{DOCUMENTO}",DOCUMENTO);
		ListaQuerys[i]= ListaQuerys[i].replace("{CLAVETRAN}",CLAVETRAN);
	}
	return ListaQuerys;
}


}

