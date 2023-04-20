package cdo.Persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import cdo.Datos.ChequeNominativo;
import cdo.Datos.Querys;
import cdo.Datos.Usuario;
import cdo.util.Cls_Log;
import cdo.util.Cls_MetodosGlobales;
import cdo.util.Cls_Querys;
import cdo.util.ConexionBD;
import cdo.util.EjecutaQuerysBD;

public class GestorMantoCheques {
	
	DecimalFormat formatoDecimal = new DecimalFormat("#,###.00");
	
	/***  CONSULTA CHEQUES NOMINATIVOS  ***/
	public List<ChequeNominativo> consultaChequesNominativos(Usuario infoUsu, List<Querys> ListaQuerys,String fechaPoliza, String cheque, String estatus, String des_estatus)
	{
		List<ChequeNominativo> listaCheques = new ArrayList<>();
		String strQry="";
		Connection connBD = null;
		PreparedStatement pstm= null;		
		connBD = ConexionBD.AbrirConexionBD(infoUsu.getUname());
		try
		{
			String[] querys = new String[25];	
			querys = Cls_Querys.LimpiaListaQuerys(querys);	
			querys = Cls_Querys.ObtieneQuerys(87, ListaQuerys, querys, infoUsu);
			querys = InicializaQueryNumero87(querys, infoUsu, fechaPoliza, cheque, estatus);
			strQry = Cls_MetodosGlobales.obtieneSentenciaDeQrys(querys);	
			pstm = connBD.prepareStatement("{call " + "CTRL_INGRESOS.usp_EXECUTE_QUERY(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			ResultSet rs= EjecutaQuerysBD.EjecutarQuery(querys[0], querys[1],querys[2], querys[3], querys[4], querys[5], querys[6],
														 querys[7], querys[8], querys[9],querys[10], querys[11], querys[12], querys[13], 
														 querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], 
														 querys[21], querys[22], querys[23], querys[24], infoUsu.getUname(),pstm, connBD);	
			if(rs !=null)
				listaCheques = llenaClaseChequeNominativo(rs, des_estatus);
			
			Cls_Log.insertaLog(infoUsu, "", "", "Consulta los cheques  nominativos.  "  +  "   QUERYS-87[" + strQry + "]" );
			
			
		}
		catch(Exception ex)
		{
			String sError= ex.getMessage().toString();
			Cls_Log.insertaLog(infoUsu, "", "", "Error al consultar los cheques  nominativos: [" + sError + "]   " + "    QUERIES-87[" + strQry + "]");
		}
		finally
		{
			try {connBD.close();} catch (SQLException e) {e.printStackTrace();}
			try {pstm.close();} catch (SQLException e) {e.printStackTrace();}
		}
		return listaCheques;
	
	}
	
	private List<ChequeNominativo>  llenaClaseChequeNominativo(ResultSet rs, String des_estatus)
	{
		boolean agregarCheque= false;
		List<ChequeNominativo> listaCheques = new ArrayList<>();
		try 
		{
			while(rs.next())
			{
				
				if(rs.getString("id_tipo_ingreso").equals("1"))
				{
					if(rs.getInt("estatusIngreso") >=2)
					{
						agregarCheque=true;
					}
				}
				else
				{
					agregarCheque = true;
				}	
				
				if(agregarCheque)
				{
					ChequeNominativo cheque= new ChequeNominativo();
					cheque.setReferencia(rs.getString("referencia"));
					cheque.setFolio_caja(rs.getInt("folio_caja"));
					cheque.setId_tipo_ingreso(rs.getInt("id_tipo_ingreso"));
					cheque.setTipo_ingreso(rs.getString("nombre_corto"));
					cheque.setNum_cli(rs.getInt("num_cli"));
					cheque.setNom_cliente(rs.getString("nom_cliente"));
					cheque.setImporte(formatoDecimal.format(rs.getDouble("importe")));
					cheque.setCve_banco(rs.getInt("cve_banco"));
					cheque.setBanco(rs.getString("nom_banco"));
					cheque.setFicha_deposito(rs.getString("ficha_deposito"));
					cheque.setCve_banco_deposito(rs.getInt("cve_banco_deposito"));
					cheque.setBanco_deposito(rs.getString("banco_deposito"));
					cheque.setCve_usu(rs.getString("cve_usu"));
					cheque.setNom_cve_usu(rs.getString("nom_usuario"));
					cheque.setId_estatus(rs.getInt("id_estatus"));
					cheque.setDescripcion_estatus(rs.getString("des_estatus"));
					cheque.setFecha_poliza(rs.getString("fecha_poliza"));
					cheque.setUname(rs.getString("uname"));
					listaCheques.add(cheque);
				}
			}
		}
		catch (SQLException e) 
		{
			System.out.println("Error al llenar clase de cheque nominativo:" + e.getMessage().toString());
		}
		return listaCheques;
	}
	
	/***  ACTUALIZA CHEQUES NOMINATIVOS  ***/
	public boolean actualizaCheque(Usuario infoUsu, List<Querys> ListaQuerys , ChequeNominativo ChNominativo)
	{
		boolean actualizaCheque = false;
		String strQry="";
		Connection connBD = null;
		PreparedStatement pstm= null;		
		connBD = ConexionBD.AbrirConexionBD(infoUsu.getUname());
		try
		{
			String[] querys = new String[25];	
			querys = Cls_Querys.LimpiaListaQuerys(querys);	
			querys = Cls_Querys.ObtieneQuerys(88, ListaQuerys, querys, infoUsu);
			querys = InicializaQueryNumero88(querys, infoUsu, ChNominativo);
			strQry = Cls_MetodosGlobales.obtieneSentenciaDeQrys(querys);
			pstm = connBD.prepareStatement("{call " + "CTRL_INGRESOS.usp_EXECUTE_QUERY(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			EjecutaQuerysBD.EjecutarQuery(querys[0], querys[1],querys[2], querys[3], querys[4], querys[5], querys[6],
														 querys[7], querys[8], querys[9],querys[10], querys[11], querys[12], querys[13], 
														 querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], 
														 querys[21], querys[22], querys[23], querys[24], infoUsu.getUname(),pstm, connBD);	
			actualizaCheque = true;
			Cls_Log.insertaLog(infoUsu, "", "", "Actualizo Cheque Nominativo [ Cheque:" +ChNominativo.getReferencia()+ ", Folio:" + ChNominativo.getFolio_caja() + 
							   ", TipoPago:" + ChNominativo.getId_tipo_ingreso()+  ", FichaBancaria:" + ChNominativo.getFicha_deposito() +  ", BancoDeposito:" + ChNominativo.getCve_banco_deposito() +   ", Importe:" + ChNominativo.getImporte() +"]   "    +  "   QUERYS-88[" + strQry + "]");
		}
		catch(Exception ex)
		{
			String sError= ex.getMessage().toString();
			Cls_Log.insertaLog(infoUsu, "", "", "Error al actualizar los cheques  nominativos: [" + sError + "]   "   +  "   QUERYS-88[" + strQry + "]");
		}
		finally
		{
			try {connBD.close();} catch (SQLException e) {e.printStackTrace();}
			try {pstm.close();} catch (SQLException e) {e.printStackTrace();}
		}
		return actualizaCheque;
	}
		
	/***  INSERTA CHEQUES NOMINATIVOS  ***/	
	public boolean insertaCheque(Usuario infoUsu, List<Querys> ListaQuerys , ChequeNominativo ChNominativo)
	{
		boolean insertaCheque = false;
		String strQry="";
		Connection connBD = null;
		PreparedStatement pstm= null;		
		connBD = ConexionBD.AbrirConexionBD(infoUsu.getUname());
		try
		{
			String[] querys = new String[25];	
			querys = Cls_Querys.LimpiaListaQuerys(querys);	
			querys = Cls_Querys.ObtieneQuerys(89, ListaQuerys, querys, infoUsu);
			querys = InicializaQueryNumero89(querys, infoUsu, ChNominativo);		
			strQry = Cls_MetodosGlobales.obtieneSentenciaDeQrys(querys);
			pstm = connBD.prepareStatement("{call " + "CTRL_INGRESOS.usp_EXECUTE_QUERY(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			EjecutaQuerysBD.EjecutarQuery(querys[0], querys[1],querys[2], querys[3], querys[4], querys[5], querys[6],
														 querys[7], querys[8], querys[9],querys[10], querys[11], querys[12], querys[13], 
														 querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], 
														 querys[21], querys[22], querys[23], querys[24], infoUsu.getUname(),pstm, connBD);	
			insertaCheque = true;
			Cls_Log.insertaLog(infoUsu, "", "", "Inserto Cheque Nominativo Manual [ Cheque:" +ChNominativo.getReferencia()+ "Folio:" + ChNominativo.getFolio_caja()+  "TipoPago:" + ChNominativo.getId_tipo_ingreso()+  "FichaBancaria:" + ChNominativo.getFicha_deposito() +  "BancoDeposito:" + ChNominativo.getCve_banco_deposito() + "]    "   +  "   QUERYS-89[" + strQry + "]");
		}
		catch(Exception ex)
		{
			String sError= ex.getMessage().toString();
			Cls_Log.insertaLog(infoUsu, "", "", "Error al insertar  los cheques  nominativos: [" + sError + "]     "  +  "   QUERYS-89[" + strQry + "]");
		}
		finally
		{
			try {connBD.close();} catch (SQLException e) {e.printStackTrace();}
			try {pstm.close();} catch (SQLException e) {e.printStackTrace();}
		}
		return insertaCheque;
	}
				
	/***  ELIMINAR CHEQUES NOMINATIVOS  ***/
	public boolean cancelaCheque(Usuario infoUsu, List<Querys> ListaQuerys , ChequeNominativo ChNominativo)
	{
		boolean insertaCheque = false;
		String strQry="";
		Connection connBD = null;
		PreparedStatement pstm= null;		
		connBD = ConexionBD.AbrirConexionBD(infoUsu.getUname());
		try
		{
			String[] querys = new String[25];	
			querys = Cls_Querys.LimpiaListaQuerys(querys);	
			querys = Cls_Querys.ObtieneQuerys(91, ListaQuerys, querys, infoUsu);
			querys = InicializaQueryNumero91(querys, infoUsu, ChNominativo);		
			strQry = Cls_MetodosGlobales.obtieneSentenciaDeQrys(querys);
			pstm = connBD.prepareStatement("{call " + "CTRL_INGRESOS.usp_EXECUTE_QUERY(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			EjecutaQuerysBD.EjecutarQuery(querys[0], querys[1],querys[2], querys[3], querys[4], querys[5], querys[6],
														 querys[7], querys[8], querys[9],querys[10], querys[11], querys[12], querys[13], 
														 querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], 
														 querys[21], querys[22], querys[23], querys[24], infoUsu.getUname(),pstm, connBD);	
			insertaCheque = true;
			Cls_Log.insertaLog(infoUsu, "", "", "Elimino Cheque Nominativo Manual [ Cheque:" +ChNominativo.getReferencia()+ "Folio:" + ChNominativo.getFolio_caja()+  "TipoPago:" + ChNominativo.getId_tipo_ingreso()+  "]    "   +  "   QUERYS-91[" + strQry + "]");
		}
		catch(Exception ex)
		{
			String sError= ex.getMessage().toString();
			Cls_Log.insertaLog(infoUsu, "", "", "Error al eliminar  los cheques  nominativos: [" + sError + "]    "  +  "   QUERYS-91[" + strQry + "]");
		}
		finally
		{
			try {connBD.close();} catch (SQLException e) {e.printStackTrace();}
			try {pstm.close();} catch (SQLException e) {e.printStackTrace();}
		}
		return insertaCheque;
	}
	
	/***  INICIALIZA QUERYS  ***/
	private String[] InicializaQueryNumero87(String[] ListaQuerys, Usuario infoUsu, String fechaPoliza, String cheque, String estatus) 
	{
		String str_fecha="";
		String str_folio="";
		
		if(!cheque.trim().equals("0"))
		{
			str_fecha = "";
			str_folio = " A.referencia = '" + cheque.trim() + "'";
		}
		else
		{
			str_fecha = " A.fecha_poliza  ='" +generaSetenciaFecha(fechaPoliza)+"'" ;
		}
				
		for (int i=0;i <ListaQuerys.length; i++)
		{
			ListaQuerys[i]= ListaQuerys[i].replace("{CHEQUE}", str_folio);
			ListaQuerys[i]= ListaQuerys[i].replace("{FECHA_POLIZA}", str_fecha);
			ListaQuerys[i]= ListaQuerys[i].replace("{ESTATUS}", estatus);
			
		}
		return ListaQuerys;
	}
	
	private String[] InicializaQueryNumero88(String[] ListaQuerys, Usuario infoUsu,  ChequeNominativo ChNominativo) 
	{		
		for (int i=0;i <ListaQuerys.length; i++)
		{
			ListaQuerys[i]= ListaQuerys[i].replace("{FICHA_DEPOSITO}", ChNominativo.getFicha_deposito());
			ListaQuerys[i]= ListaQuerys[i].replace("{BANCO_DEPOSITO}",String.valueOf(ChNominativo.getCve_banco_deposito()));
			ListaQuerys[i]= ListaQuerys[i].replace("{FOLIO_CAJA}", String.valueOf(ChNominativo.getFolio_caja()));
			ListaQuerys[i]= ListaQuerys[i].replace("{REFERENCIA}", ChNominativo.getReferencia());
			ListaQuerys[i]= ListaQuerys[i].replace("{TIPO_INGRESO}",String.valueOf( ChNominativo.getId_tipo_ingreso()));
			ListaQuerys[i]= ListaQuerys[i].replace("{BANCO}", String.valueOf(ChNominativo.getCve_banco()));
			ListaQuerys[i]= ListaQuerys[i].replace("{ESTATUS}", String.valueOf(ChNominativo.getId_estatus()));
			ListaQuerys[i]= ListaQuerys[i].replace("{IMPORTE}", String.valueOf(ChNominativo.getImporte()));
		}
		return ListaQuerys;
	}
	
	private String[] InicializaQueryNumero89(String[] ListaQuerys, Usuario infoUsu,  ChequeNominativo ChNominativo) 
	{	
		for (int i=0;i <ListaQuerys.length; i++)
		{
			ListaQuerys[i]= ListaQuerys[i].replace("{IMPORTE}", ChNominativo.getImporte());
			ListaQuerys[i]= ListaQuerys[i].replace("{USUARIO}", infoUsu.getCve_usuario());
			ListaQuerys[i]= ListaQuerys[i].replace("{FOLIO}", String.valueOf(ChNominativo.getFolio_caja()));
			ListaQuerys[i]= ListaQuerys[i].replace("{REFERENCIA}", ChNominativo.getReferencia());
			ListaQuerys[i]= ListaQuerys[i].replace("{CLIENTE}",  String.valueOf(ChNominativo.getNum_cli()));
			ListaQuerys[i]= ListaQuerys[i].replace("{TIPO_INGRESO}",String.valueOf( ChNominativo.getId_tipo_ingreso()));
			ListaQuerys[i]= ListaQuerys[i].replace("{BANCO}", String.valueOf(ChNominativo.getCve_banco()));
			ListaQuerys[i]= ListaQuerys[i].replace("{ESTATUS}", String.valueOf(ChNominativo.getId_estatus()));
			ListaQuerys[i]= ListaQuerys[i].replace("{FECHA_POLIZA}", generaSetenciaFecha(ChNominativo.getFecha_poliza()));			
		}
		return ListaQuerys;
	}
	
	private String[] InicializaQueryNumero91(String[] ListaQuerys, Usuario infoUsu,  ChequeNominativo ChNominativo) 
	{		
		for (int i=0;i <ListaQuerys.length; i++)
		{			
			ListaQuerys[i]= ListaQuerys[i].replace("{FOLIO_CAJA}", String.valueOf(ChNominativo.getFolio_caja()));
			ListaQuerys[i]= ListaQuerys[i].replace("{REFERENCIA}", ChNominativo.getReferencia());
			ListaQuerys[i]= ListaQuerys[i].replace("{TIPO_INGRESO}",String.valueOf( ChNominativo.getId_tipo_ingreso()));
			ListaQuerys[i]= ListaQuerys[i].replace("{BANCO}", String.valueOf(ChNominativo.getCve_banco()));
			ListaQuerys[i]= ListaQuerys[i].replace("{ESTATUS}", String.valueOf(ChNominativo.getId_estatus()));			
		}
		return ListaQuerys;
	}
		
	private String generaSetenciaFecha(String  fecha)
	{
		String arrayFecha[] =  fecha.split("/");
		String sentencia_fecha = ""; 
	
		sentencia_fecha = arrayFecha[2] + "-" + arrayFecha[1] + "-" + arrayFecha[0];
		
		return sentencia_fecha;
	}
	
}
