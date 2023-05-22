package cdo.Persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cdo.Datos.ChequesDevueltos;
import cdo.Datos.MotivosChequesDevueltos;
import cdo.Datos.Querys;
import cdo.Datos.Usuario;
import cdo.util.Cls_Log;
import cdo.util.Cls_MetodosGlobales;
import cdo.util.Cls_Querys;
import cdo.util.ConexionBD;
import cdo.util.EjecutaQuerysBD;

public class GestorChequesDevueltos {
	
	
	public static List<MotivosChequesDevueltos> ListarMotivos(List<Querys> ListaQuerys,Usuario infoUsu)
	{	
		List <MotivosChequesDevueltos> LstMotivosChequesDev = new ArrayList<MotivosChequesDevueltos>();
		String strQry="";
		Connection connBD = null;
		PreparedStatement pstm= null;		
		connBD = ConexionBD.AbrirConexionBD(infoUsu.getUname());
		try
		{
			String[] querys = new String[25];	
			querys = Cls_Querys.LimpiaListaQuerys(querys);
			querys = Cls_Querys.ObtieneQuerys(30, ListaQuerys, querys, infoUsu);	
			strQry = Cls_MetodosGlobales.obtieneSentenciaDeQrys(querys);
			pstm = connBD.prepareStatement("{call " + "CTRL_INGRESOS.usp_EXECUTE_QUERY(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			ResultSet rs = EjecutaQuerysBD.EjecutarQuery(querys[0], querys[1],querys[2], querys[3], querys[4], querys[5], querys[6],
														 querys[7], querys[8], querys[9],querys[10], querys[11], querys[12], querys[13], 
														 querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], 
														 querys[21], querys[22], querys[23], querys[24], infoUsu.getUname(),pstm, connBD);			
			if (rs != null)
			 {
				 while (rs.next())
			        {
					  MotivosChequesDevueltos motivosChqDev = new MotivosChequesDevueltos();
					  motivosChqDev.setId_motivo(rs.getInt("id_motivo"));
					  motivosChqDev.setDescripcion(rs.getString("descripcion"));
					  LstMotivosChequesDev.add(motivosChqDev);
			        }
			 }
			
			Cls_Log.insertaLog(infoUsu, "", "", "Consulta  listado de motivos para cheque devuelto.   "   +  " QUERIES-30[" + strQry + "]");
			
		}
		catch(Exception ex)
		{
			String sError= ex.getMessage().toString();
			Cls_Log.insertaLog(infoUsu, "", "", "Error al consulta listado de motivos para cheque devuelto [" + ex.getMessage().toString()+ "]  "   +  " QUERIES-30[" + strQry + "]");
		}
		finally
		{
			try {connBD.close();} catch (SQLException e) {e.printStackTrace();}
			try {pstm.close();} catch (SQLException e) {e.printStackTrace();}
		}
		return LstMotivosChequesDev;
		
	}

	public List<ChequesDevueltos> consultarChequesRealizados(List<Querys> ListaQuerys, Usuario infoUsu,String fecha_ini, String fecha_fin, String id_estatus,String folio) 
	{
		List<ChequesDevueltos> LstChequesDevueltos = new ArrayList<ChequesDevueltos>();
		String strQry="";
		Connection connBD = null;
		PreparedStatement pstm = null;
		connBD = ConexionBD.AbrirConexionBD(infoUsu.getUname());
		try
		{
			String[] querys = new String [25];
			querys = Cls_Querys.LimpiaListaQuerys(querys);
			querys = Cls_Querys.ObtieneQuerys(35, ListaQuerys, querys, infoUsu);
			querys = InicializaQueryNumero35(querys, infoUsu,fecha_ini,fecha_fin,id_estatus,folio);
			strQry = Cls_MetodosGlobales.obtieneSentenciaDeQrys(querys);
			pstm = connBD.prepareStatement("{call " + "CTRL_INGRESOS.usp_EXECUTE_QUERY(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			ResultSet rs = EjecutaQuerysBD.EjecutarQuery(querys[0], querys[1],querys[2], querys[3], querys[4], querys[5], querys[6],
														 querys[7], querys[8], querys[9],querys[10], querys[11], querys[12], querys[13], 
														 querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], 
														 querys[21], querys[22], querys[23], querys[24], infoUsu.getUname(),pstm, connBD);
		
			if (rs != null)
			 {
				
				LstChequesDevueltos = llenarChequeInicial(rs,infoUsu);
				Cls_Log.insertaLog(infoUsu, "", "", "Consulta cheques realizados [" +LstChequesDevueltos+ "]    "    +  " QUERIES-35[" + strQry + "]");		
			 }
		}
		catch (Exception e) 
		{
			Cls_Log.insertaLog(infoUsu, "", "", "Error al consultar cheques realizados [" + e.getMessage().toString()+ "]  "   +  " QUERIES-35[" + strQry + "]");
		}
		return LstChequesDevueltos;
	}
	
	private List<ChequesDevueltos> llenarChequeInicial(ResultSet rs,Usuario infoUsu) {
		List<ChequesDevueltos> LstDatosCheques = new ArrayList<>();
		try 
		{
			while(rs.next())
			{
				ChequesDevueltos chequesDevueltos  =new ChequesDevueltos();
				chequesDevueltos.setUname(infoUsu.getUname());
				chequesDevueltos.setUname_br(infoUsu.getUname_br());
				chequesDevueltos.setCve_usu(infoUsu.getCve_usuario());
				chequesDevueltos.setFolio_corte_caja(rs.getInt("folio_corte_caja"));
				chequesDevueltos.setFecha_pro(rs.getString("fecha_pro"));
				chequesDevueltos.setFolio_documento(rs.getInt("folio_documento"));
				chequesDevueltos.setImporte(rs.getDouble("importe"));
				chequesDevueltos.setHora_pro(rs.getString("descripcion"));
				chequesDevueltos.setId_status(rs.getInt("id_estatus"));
				
				LstDatosCheques.add(chequesDevueltos);
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return LstDatosCheques;
	}

	public static List<ChequesDevueltos> ConsultarCheques(List<Querys> ListaQuerys,Usuario infoUsu)
	{	
		List <ChequesDevueltos> LstDatosCheques = new ArrayList<ChequesDevueltos>();
		String strQry="";
		Connection connBD = null;
		PreparedStatement pstm= null;		
		connBD = ConexionBD.AbrirConexionBD(infoUsu.getUname());
		try
		{
			String[] querys = new String[25];	
			querys = Cls_Querys.LimpiaListaQuerys(querys);
			querys = Cls_Querys.ObtieneQuerys(31, ListaQuerys, querys, infoUsu);
			strQry = Cls_MetodosGlobales.obtieneSentenciaDeQrys(querys);
			pstm = connBD.prepareStatement("{call " + "CTRL_INGRESOS.usp_EXECUTE_QUERY(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			ResultSet rs = EjecutaQuerysBD.EjecutarQuery(querys[0], querys[1],querys[2], querys[3], querys[4], querys[5], querys[6],
														 querys[7], querys[8], querys[9],querys[10], querys[11], querys[12], querys[13], 
														 querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], 
														 querys[21], querys[22], querys[23], querys[24], infoUsu.getUname(),pstm, connBD);
		
			if (rs != null)
			 {
				LstDatosCheques = llenarDatosCheques(rs);
				Cls_Log.insertaLog(infoUsu, "", "", "Consulta cheques en la BD el usuario: "+infoUsu.getCve_usuario()+" de "+infoUsu.getUname().toUpperCase()+ " " + infoUsu.getUname_br()   +  "   QUERIES-31[" + strQry + "]");
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
		return LstDatosCheques;
		
	}
		
	public static List<ChequesDevueltos> llenarDatosCheques(ResultSet rs)
	{
		List<ChequesDevueltos> LstDatosCheques = new ArrayList<>();
		try 
		{
			while(rs.next())
			{
				ChequesDevueltos chequesDevueltos  =new ChequesDevueltos();
				chequesDevueltos.setUname(rs.getString("uname"));
				chequesDevueltos.setUname_br(rs.getString("uname_br"));
				chequesDevueltos.setFolio_corte_caja(rs.getInt("folio_corte_caja"));
				chequesDevueltos.setFecha_pro(rs.getString("fecha_corte_caja"));
				LstDatosCheques.add(chequesDevueltos);
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return LstDatosCheques;
	}

	public  boolean insertarChequeDevuelto(List<Querys> ListaQuerys,Usuario infoUsu,ChequesDevueltos chequesDevueltos,String DATOSCHEQUES,int CANTIDADCHEQUES, String referencia, String num_corte_caja, String importe, String banco_deposito) 
	{	
		boolean insertoEgreso =false;
		String strQry="";
		Connection connBD = null;
		PreparedStatement pstm= null;		
		connBD = ConexionBD.AbrirConexionBD(infoUsu.getUname());
		int cantidadChqDev=1;
		try
		{
			String[] querys = new String[25];	
			querys = Cls_Querys.LimpiaListaQuerys(querys);
			querys = Cls_Querys.ObtieneQuerys(32, ListaQuerys, querys, infoUsu);	
			querys = InicializaQueryNumero32(querys, infoUsu, chequesDevueltos,DATOSCHEQUES,CANTIDADCHEQUES, referencia,num_corte_caja, importe, banco_deposito);
			strQry = Cls_MetodosGlobales.obtieneSentenciaDeQrys(querys);
			pstm = connBD.prepareStatement("{call " + "CTRL_INGRESOS.usp_EXECUTE_QUERY(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			EjecutaQuerysBD.EjecutarQuery(querys[0], querys[1],querys[2], querys[3], querys[4], querys[5], querys[6],
														 querys[7], querys[8], querys[9],querys[10], querys[11], querys[12], querys[13], 
														 querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], 
														 querys[21], querys[22], querys[23], querys[24], infoUsu.getUname(),pstm, connBD);	
			
			
			Cls_Log.insertaLog(infoUsu, "", "", "Inserta cheque devuelto.   "  + "  QUERIES-32[" + strQry + "]");
			
			querys = Cls_Querys.LimpiaListaQuerys(querys);
			querys = Cls_Querys.ObtieneQuerys(84, ListaQuerys, querys, infoUsu);	
			querys = InicializaQueryNumero84(querys, infoUsu, referencia,num_corte_caja);	
			strQry = Cls_MetodosGlobales.obtieneSentenciaDeQrys(querys);
			pstm = connBD.prepareStatement("{call " + "CTRL_INGRESOS.usp_EXECUTE_QUERY(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			ResultSet rs = EjecutaQuerysBD.EjecutarQuery(querys[0], querys[1],querys[2], querys[3], querys[4], querys[5], querys[6],
														 querys[7], querys[8], querys[9],querys[10], querys[11], querys[12], querys[13], 
														 querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], 
														 querys[21], querys[22], querys[23], querys[24], infoUsu.getUname(),pstm, connBD);	
			
			Cls_Log.insertaLog(infoUsu, "", "", "Busca folio de caja  para cheque devuelto.     "  + "  QUERIES-84[" + strQry + "]");
		
			String folioCaja = "";
			String cve_forma_pago = "";
			int foliosEncontrados=0;
			if(rs != null)
			{
				while(rs.next())
				{
					foliosEncontrados++;
					folioCaja= rs.getString("folio_caja");
					cve_forma_pago =rs.getString("cve_forma_pago");
				}
			}
		
		
			if(String.valueOf(foliosEncontrados).equals("1"))
			{
				querys = Cls_Querys.LimpiaListaQuerys(querys);
				querys = Cls_Querys.ObtieneQuerys(85, ListaQuerys, querys, infoUsu);	
				querys = InicializaQueryNumero85(querys, infoUsu, referencia,folioCaja, cve_forma_pago);
				strQry = Cls_MetodosGlobales.obtieneSentenciaDeQrys(querys);
				pstm = connBD.prepareStatement("{call " + "CTRL_INGRESOS.usp_EXECUTE_QUERY(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
				ResultSet rs1 = EjecutaQuerysBD.EjecutarQuery(querys[0], querys[1],querys[2], querys[3], querys[4], querys[5], querys[6],
															 querys[7], querys[8], querys[9],querys[10], querys[11], querys[12], querys[13], 
															 querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], 
															 querys[21], querys[22], querys[23], querys[24], infoUsu.getUname(),pstm, connBD);
				
				Cls_Log.insertaLog(infoUsu, "", "", "Actualiza pagos  para cheque devuelto.     "  + "   QUERIES-85[" + strQry + "]");
				
			}
			
			insertoEgreso=true;
			Cls_Log.insertaLog(infoUsu, "", "", "Inserta cheque devuelto [Referencia:"+ referencia +", Numero Corte:"+num_corte_caja+" ,Importe: "  + importe +"]");
			Cls_Log.insertaLog(infoUsu, "", "", "Cancela Cheque Nominativo [Referencia:"+ referencia +", Numero Corte:"+num_corte_caja+" ,Importe: "  + importe +"]");
			
		}
		catch(Exception ex)
		{
			//String sError= ex.getMessage().toString();
		}
		finally
		{
			try {connBD.close();} catch (SQLException e) {e.printStackTrace();}
			try {pstm.close();} catch (SQLException e) {e.printStackTrace();}
		}
		return insertoEgreso;
	}

	private String[] InicializaQueryNumero32(String[] ListaQuerys, Usuario infoUsu, ChequesDevueltos chequesDevueltos,String DATOSCHEQUES,int CANTIDADCHEQUES,String  referencia,String num_corte_caja, String importe, String banco_deposito) {
	
		for (int i=0;i <ListaQuerys.length; i++)
		{			
			ListaQuerys[i]= ListaQuerys[i].replace("{DATOSCHEQUES}",DATOSCHEQUES);
			ListaQuerys[i]= ListaQuerys[i].replace("{CANTIDADCHEQUES}",Integer.toString(CANTIDADCHEQUES));
			ListaQuerys[i]= ListaQuerys[i].replace("{CHEQUE}",referencia);
			ListaQuerys[i]= ListaQuerys[i].replace("{IMPORTE}",importe);
			ListaQuerys[i]= ListaQuerys[i].replace("{FOLIO_CORTE}",num_corte_caja);
			ListaQuerys[i]= ListaQuerys[i].replace("{BANCO_DEPOSITO}",banco_deposito);
		}
		return ListaQuerys;
	}
	
	/*public  boolean  insertarVariosCheques(String[] checkbox, String[] noCheque, String[] importeCheque,String[] motivoCheque, String txtCveUsu,List<Querys> ListaQuerys,Usuario infoUsu) {
		int pocision=0;
		boolean insertVariosCheques=false;
		int motivoContiene=0,contadorFolio=0;
		String DATOSCHEQUES="";
		for (String jdk : checkbox)
		{	
			contadorFolio++;
			String checkSplit[]=jdk.split("_");
			pocision=Integer.parseInt(checkSplit[checkSplit.length-1]);
			DATOSCHEQUES+="('"+checkSplit[0]+"','"+checkSplit[1]+"','"+5+"',@folio+'"+contadorFolio+"','"+Integer.parseInt(noCheque[pocision])+"','"+Double.parseDouble(importeCheque[pocision])+"','"+1+"','"+txtCveUsu+"','"+Integer.parseInt(checkSplit[2])+"','"+Integer.parseInt(motivoCheque[motivoContiene])+"','"+2+"',curdate(),curtime()),";
			motivoContiene++;
		}
		ChequesDevueltos ch = new ChequesDevueltos();
		DATOSCHEQUES = DATOSCHEQUES.substring(0, DATOSCHEQUES.length() -1);
		insertVariosCheques=insertarChequeDevuelto(ListaQuerys, infoUsu, ch,DATOSCHEQUES,motivoContiene);
		
		return insertVariosCheques;
	}*/

	public boolean cancelarCheque(List<Querys> ListaQuerys, Usuario infoUsu, String noCheque) {
		boolean chequeCancelado=false;
		Connection connBD = null;
		PreparedStatement pstm= null;		
		connBD = ConexionBD.AbrirConexionBD(infoUsu.getUname());
		int cantidadChqDev=1;
		try
		{
			String[] querys = new String[25];	
			querys = Cls_Querys.LimpiaListaQuerys(querys);
			querys = Cls_Querys.ObtieneQuerys(36, ListaQuerys, querys, infoUsu);	
			querys = InicializaQueryNumero36(querys, infoUsu,noCheque);
			pstm = connBD.prepareStatement("{call " + "CTRL_INGRESOS.usp_EXECUTE_QUERY(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			ResultSet rs = EjecutaQuerysBD.EjecutarQuery(querys[0], querys[1],querys[2], querys[3], querys[4], querys[5], querys[6],
														 querys[7], querys[8], querys[9],querys[10], querys[11], querys[12], querys[13], 
														 querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], 
														 querys[21], querys[22], querys[23], querys[24], infoUsu.getUname(),pstm, connBD);			
			Cls_Log.insertaLog(infoUsu, "", "", "Cancelar cheque " +noCheque+ "");		
			chequeCancelado=true;
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
		return chequeCancelado;
	}

	private String[] InicializaQueryNumero36(String[] ListaQuerys, Usuario infoUsu,String NUMEROCHEQUE) {
		
		for (int i=0;i <ListaQuerys.length; i++)
		{			
			ListaQuerys[i]= ListaQuerys[i].replace("{NUMEROCHEQUE}",NUMEROCHEQUE);
		}
		return ListaQuerys;
	}
	
	private String[] InicializaQueryNumero35(String[] ListaQuerys, Usuario infoUsu,String FECHAINI,String FECHAFIN,String IDESTATUS,String FOLIO) {
		String SQL="";
		if (FOLIO.equals(" ")) 
		{
			if(Integer.parseInt(IDESTATUS)==3) {IDESTATUS="100";}
			if (Integer.parseInt(IDESTATUS)!=100) { SQL="CTRL_INGRESOS.cc_EGRESOS.id_estatus = {IDESTATUS}";}
			if (Integer.parseInt(IDESTATUS)==2	) {IDESTATUS= "2 OR CTRL_INGRESOS.cc_EGRESOS.id_estatus = 3 ";}
		}
		else
		{	if (Integer.parseInt(IDESTATUS)==2	) {IDESTATUS= "2 OR CTRL_INGRESOS.cc_EGRESOS.id_estatus = 3 ";}
			SQL="CTRL_INGRESOS.cc_EGRESOS.folio_corte_caja = {FOLIO} and (CTRL_INGRESOS.cc_EGRESOS.id_estatus = {IDESTATUS})";
		}
		for (int i=0;i <ListaQuerys.length; i++)
		{			
			ListaQuerys[i]= ListaQuerys[i].replace("{SQL}",SQL);
			ListaQuerys[i]= ListaQuerys[i].replace("{FOLIO}",FOLIO);
			ListaQuerys[i]= ListaQuerys[i].replace("{FECHAINICIO}",FECHAINI);
			ListaQuerys[i]= ListaQuerys[i].replace("{FECHAFIN}",FECHAFIN);
			ListaQuerys[i]= ListaQuerys[i].replace("{IDESTATUS}",IDESTATUS);
		}
		return ListaQuerys;
	}

	private String[] InicializaQueryNumero84(String[] ListaQuerys, Usuario infoUsu,String NUMEROCHEQUE , String FOLIO_CORTE_CAJA) {
		
		for (int i=0;i <ListaQuerys.length; i++)
		{			
			ListaQuerys[i]= ListaQuerys[i].replace("{REFERENCIA}",NUMEROCHEQUE);
			ListaQuerys[i]= ListaQuerys[i].replace("{FOLIO_CORTE_CAJA}",FOLIO_CORTE_CAJA);
		}
		return ListaQuerys;
	}
	
	private String[] InicializaQueryNumero85(String[] ListaQuerys, Usuario infoUsu,String NUMEROCHEQUE , String FOLIO_CAJA, String FORMA_PAGO) {
		
		for (int i=0;i <ListaQuerys.length; i++)
		{			
			ListaQuerys[i]= ListaQuerys[i].replace("{REFERENCIA}",NUMEROCHEQUE);
			ListaQuerys[i]= ListaQuerys[i].replace("{FOLIO_CAJA}",FOLIO_CAJA);
			ListaQuerys[i]= ListaQuerys[i].replace("{FORMA_PAGO}",FORMA_PAGO);
		}
		return ListaQuerys;
	}
}
