package cdo.Persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cdo.Datos.Catalogo_Estatus;
import cdo.Datos.Catalogo_Motivos_Cancelacion_Posfechados;
import cdo.Datos.ChequesPosfechados;
import cdo.Datos.Querys;
import cdo.Datos.Usuario;
import cdo.util.Cls_Log;
import cdo.util.Cls_Querys;
import cdo.util.ConexionBD;
import cdo.util.EjecutaQuerysBD;

public class GestorChequesPosfechados 
{

	public List<ChequesPosfechados> consultarChequesPosfechados(List<Querys> ListaQuerys, Usuario infoUsu,String fecha_ini, String fecha_fin, List<ChequesPosfechados> lstChequesPosfechados,String estatus, String banco, String cve_usu_ecc, String cheque, String tipoFecha) 
	{
		Connection connBD = null;
		PreparedStatement pstm = null;
		connBD = ConexionBD.AbrirConexionBD(infoUsu.getUname());
		try 
		{
			String [] querys = new String [25];
			querys = Cls_Querys.LimpiaListaQuerys(querys);
			querys = Cls_Querys.ObtieneQuerys(56, ListaQuerys, querys, infoUsu);
			String parametros = parametrosDeBuesqueda(Integer.parseInt(estatus),Integer.parseInt(banco),cve_usu_ecc,cheque,infoUsu);
			querys = inicializaQueryNumero56(querys, infoUsu,fecha_ini,fecha_fin,parametros,Integer.parseInt(tipoFecha));
			pstm = connBD.prepareStatement("{call " + "CTRL_INGRESOS.usp_EXECUTE_QUERY(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			ResultSet rs = EjecutaQuerysBD.EjecutarQuery(querys[0], querys[1],querys[2], querys[3], querys[4], querys[5], querys[6],
					 querys[7], querys[8], querys[9],querys[10], querys[11], querys[12], querys[13], 
					 querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], 
					 querys[21], querys[22], querys[23], querys[24], infoUsu.getUname(),pstm, connBD);
			
			if (rs != null)
			{
				lstChequesPosfechados = llenarChequesInicial(rs,infoUsu,lstChequesPosfechados);
			}
			Cls_Log.insertaLog(infoUsu, "", "", "Consulta cheques posfechados: [Fecha Inicio:"+fecha_ini +", Fecha Fin: " + fecha_fin + ", Estatus:" + estatus +" ] ");
		}
		catch(Exception ex)
		{
			String sError= ex.getMessage().toString();
			Cls_Log.insertaLog(infoUsu, "", "", "Error al consultar los cheques posfechados: [" + sError + "]");
		}
		finally
		{
			try {connBD.close();} catch (SQLException e) {e.printStackTrace();}
			try {pstm.close();} catch (SQLException e) {e.printStackTrace();}
		}
		return lstChequesPosfechados;
	}

	private List<ChequesPosfechados> llenarChequesInicial(ResultSet rs, Usuario infoUsu, List<ChequesPosfechados> lstChequesPosfechados) throws SQLException 
	{	
		try
		{
			int contador = 0;
			while (rs.next()) 
			{
				ChequesPosfechados chequesposfechados = new ChequesPosfechados();
				chequesposfechados.setNo(contador);
				chequesposfechados.setFecha_creacion(rs.getString("fecha_creacion"));
				chequesposfechados.setFecha_administrador(rs.getString("fecha_administrador"));
				chequesposfechados.setFecha_pago(rs.getString("fecha_pago"));
				chequesposfechados.setReferencia(rs.getString("referencia"));
				chequesposfechados.setNum_agente(rs.getInt("num_agente"));
				chequesposfechados.setNombre_agente(rs.getString("nombre_agente"));
				chequesposfechados.setCve_usu_ecc(rs.getString("cve_usu_ecc"));
				chequesposfechados.setNombre_ecc(rs.getString("nombre_ecc"));
				chequesposfechados.setNum_cli(rs.getInt("num_cli"));
				chequesposfechados.setNombre_cliente(rs.getString("nombre_cliente"));
				chequesposfechados.setCve_banco(rs.getInt("cve_banco"));
				chequesposfechados.setNombre_banco(rs.getString("nombre_banco"));
				chequesposfechados.setImporte(rs.getString("importe"));
				chequesposfechados.setFolio_caja(rs.getInt("folio_caja"));
				chequesposfechados.setFolio_caja_cheque_nominativo(rs.getInt("folio_caja_cheque_nominativo"));
				chequesposfechados.setFicha_deposito(rs.getString("ficha_deposito"));
				chequesposfechados.setId_estatus(rs.getInt("id_estatus"));
				chequesposfechados.setDescripcion_estatus(rs.getString("descripcion_estatus"));
				chequesposfechados.setDescripcion_cancelacion(rs.getString("descripcion_cancelacion"));
				chequesposfechados.setId_tipo_ingreso(rs.getInt("id_tipo_ingreso"));
				lstChequesPosfechados.add(chequesposfechados);
				contador++;
			}
		}
		catch(Exception ex)
		{
			String sError= ex.getMessage().toString();
			Cls_Log.insertaLog(infoUsu, "", "", "Error al llenar la clase cheques posfechados: [" + sError + "]");
		}
		return lstChequesPosfechados;
	}
	
	public String cambiarEstatusCheques(String splitCheques, List<ChequesPosfechados> lstCP, Usuario infoUsu, List<Querys> ListaQuerys, String estatus, String fichaDeposito, int folio_chequeNominativo) 
	{
		String respuesta = "";
		String cheque[] = splitCheques.split(",");
		String noCheques[] = splitCheques.split(",");
		Connection connBD = null;
		PreparedStatement pstm = null;
		connBD = ConexionBD.AbrirConexionBD(infoUsu.getUname());
		try
		{
			String [] querys = new String [25];
			int tipo[] = obtenerTipoEstatusSubIndiceQry(estatus);
			String valoresInsert = obtenerQryUpdate(noCheques,lstCP,infoUsu,Integer.toString(tipo[0]),fichaDeposito, String.valueOf(folio_chequeNominativo));
			querys = Cls_Querys.LimpiaListaQuerys(querys);
			querys = Cls_Querys.ObtieneQuerys(tipo[1], ListaQuerys, querys, infoUsu);
			querys = inicializaQueryUpdate(querys, infoUsu,valoresInsert);
			pstm = connBD.prepareStatement("{call " + "CTRL_INGRESOS.usp_EXECUTE_QUERY(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			EjecutaQuerysBD.EjecutarQuery(querys[0], querys[1],querys[2], querys[3], querys[4], querys[5], querys[6],
											 querys[7], querys[8], querys[9],querys[10], querys[11], querys[12], querys[13], 
											 querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], 
											 querys[21], querys[22], querys[23], querys[24], infoUsu.getUname(),pstm, connBD);								
			
			respuesta = obtenerRespuesta(Integer.toString(tipo[0]),fichaDeposito,cheque,lstCP);
			Cls_Log.insertaLog(infoUsu, "", "",respuesta);
		} 
		catch (Exception ex) 
		{
			String sError= ex.getMessage().toString();
			Cls_Log.insertaLog(infoUsu, "", "", "Error actualizar estatus de cheques posfechados [" + sError + "]");
		}
		finally
		{
			try {connBD.close();} catch (SQLException e) {e.printStackTrace();}
			try {pstm.close();} catch (SQLException e) {e.printStackTrace();}
		}
		return respuesta;
	}
	
	public int  generaNuevoIngresosChequeNominativo(Usuario infoUsu, List<Querys> ListaQuerys, String splitCheques, List<ChequesPosfechados> listaChequesPosfechados, String estatus, String fichaDeposito)
	{
		int folio_chequeNominativo = 0;
		Connection connBD=null;
		PreparedStatement pstm =null;
		connBD = ConexionBD.AbrirConexionBD(infoUsu.getUname());
		try
		{
			String noChequesPosfechados[] = splitCheques.split(",");
			for (String cheque : noChequesPosfechados) 
			{
				for (ChequesPosfechados posfechado : listaChequesPosfechados) 
				{
					if (Integer.parseInt(cheque) == posfechado.getNo())
					{
						String [] querys = new String [25];
						querys = Cls_Querys.LimpiaListaQuerys(querys);
						querys = Cls_Querys.ObtieneQuerys(71, ListaQuerys, querys, infoUsu);
						querys = inicializaQueryNumero71_72(querys, infoUsu, posfechado.getReferencia(), posfechado.getFolio_caja(), posfechado.getCve_banco());
					
						pstm = connBD.prepareStatement("{call " + "CTRL_INGRESOS.usp_EXECUTE_QUERY(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
						ResultSet rs= EjecutaQuerysBD.EjecutarQuery(querys[0], querys[1],querys[2], querys[3], querys[4], querys[5], querys[6],
									 querys[7], querys[8], querys[9],querys[10], querys[11], querys[12], querys[13], 
									 querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], 
									 querys[21], querys[22], querys[23], querys[24], infoUsu.getUname(),pstm, connBD);
					
					
						Cls_Log.insertaLog(infoUsu, "", "","Genera Ingreso de cheque nominativo y actualiza pagos realcionados. [Folio Caja:" + posfechado.getFolio_caja()+
															",  Referencia:" +posfechado.getReferencia() + ",  Banco:" +posfechado.getCve_banco() + "]");
						if(rs != null)
						{
							while(rs.next())
							{
								folio_chequeNominativo= Integer.parseInt(rs.getString("folio_nominativo"));
								cambiarEstatusCheques(cheque, listaChequesPosfechados, infoUsu, ListaQuerys, estatus , fichaDeposito, folio_chequeNominativo);
							}
						}
						break;
					}
				}
			}	
		}
		catch (Exception ex) 
		{
			String sError= ex.getMessage().toString();
			Cls_Log.insertaLog(infoUsu, "", "", "Error al crear nuevo ingresos de cheque nominativo. [" + sError + "]");
		}
		finally
		{
			try {connBD.close();} catch (SQLException e) {e.printStackTrace();}
			try {pstm.close();} catch (SQLException e) {e.printStackTrace();}
		}
		return folio_chequeNominativo;
	}
	
	public void cancelaChequePosfechadoEnPagos(Usuario infoUsu, List<Querys> ListaQuerys, String splitCheques, List<ChequesPosfechados> listaChequesPosfechados, String estatus, String fichaDeposito)
	{
		Connection connBD=null;
		PreparedStatement pstm =null;
		connBD = ConexionBD.AbrirConexionBD(infoUsu.getUname());
		try
		{
			String noChequesPosfechados[] = splitCheques.split(",");
			for (String cheque : noChequesPosfechados) 
			{
				for (ChequesPosfechados posfechado : listaChequesPosfechados) 
				{
					if (Integer.parseInt(cheque) == posfechado.getNo())
					{
						String [] querys = new String [25];
						querys = Cls_Querys.LimpiaListaQuerys(querys);
						querys = Cls_Querys.ObtieneQuerys(72, ListaQuerys, querys, infoUsu);
						querys = inicializaQueryNumero71_72(querys, infoUsu, posfechado.getReferencia(), posfechado.getFolio_caja(), posfechado.getCve_banco());
						pstm = connBD.prepareStatement("{call " + "CTRL_INGRESOS.usp_EXECUTE_QUERY(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
						ResultSet rs= EjecutaQuerysBD.EjecutarQuery(querys[0], querys[1],querys[2], querys[3], querys[4], querys[5], querys[6],
									 querys[7], querys[8], querys[9],querys[10], querys[11], querys[12], querys[13], 
									 querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], 
									 querys[21], querys[22], querys[23], querys[24], infoUsu.getUname(),pstm, connBD);
				
						Cls_Log.insertaLog(infoUsu, "", "","Cancela cheque posfechado en sistemas pagos. [Folio Caja:" + posfechado.getFolio_caja()+
															",  Referencia:" +posfechado.getReferencia() + ",  Banco:" +posfechado.getCve_banco() + "]");						
						break;
					}
				}
			}	
		}
		catch (Exception ex) 
		{
			String sError= ex.getMessage().toString();
			Cls_Log.insertaLog(infoUsu, "", "", "Error al crear nuevo ingresos de cheque nominativo. [" + sError + "]");
		}
		finally
		{
			try {connBD.close();} catch (SQLException e) {e.printStackTrace();}
			try {pstm.close();} catch (SQLException e) {e.printStackTrace();}
		}
	}

	private int[] obtenerTipoEstatusSubIndiceQry(String estatus)
	{
		int tipoEstatusSubIndiceQry [];
		tipoEstatusSubIndiceQry = new int[2];
		switch (estatus)
		{
		
			case "confirmado":
				tipoEstatusSubIndiceQry [0] = 1;
				tipoEstatusSubIndiceQry [1] = 65;
				break;
			case "transito":
				tipoEstatusSubIndiceQry [0] = 2;
				tipoEstatusSubIndiceQry [1] = 66;
				break;
			case "deposito":
				tipoEstatusSubIndiceQry [0] = 3;
				tipoEstatusSubIndiceQry [1] = 67;
				break;
			case "cancelar":
				tipoEstatusSubIndiceQry [0] = 9;
				tipoEstatusSubIndiceQry [1] = 68;
				break;
		}	
		return tipoEstatusSubIndiceQry;
	}
	
	private String obtenerQryUpdate(String[] noCheques, List<ChequesPosfechados> lstCP, Usuario infoUsu, String estatus,String fichaDeposito, String folioChequeNominativo) 
	{
		String valoresInsert = "";
		for (String noCheque : noCheques) 
		{
			for (ChequesPosfechados cp : lstCP) 
			{
				if (Integer.parseInt(noCheque) == cp.getNo())
				{
					switch (Integer.parseInt(estatus)) 
					{
						case 1:
							valoresInsert = valoresInsert + "('"+cp.getReferencia()+"','"+cp.getFolio_caja()+"','"+cp.getId_tipo_ingreso()+"','1','"+infoUsu.getCve_usuario()+"',CURDATE(),CURTIME(),'" + cp.getCve_banco() + "'),";
						break;
						case 2:
							valoresInsert = valoresInsert + "('"+cp.getReferencia()+"','"+cp.getFolio_caja()+"','"+cp.getId_tipo_ingreso()+"','2','"+infoUsu.getCve_usuario()+"',CURDATE(),CURTIME(),'" + cp.getCve_banco() + "'),";
						break;
						case 3:
							valoresInsert = valoresInsert + "('"+cp.getReferencia()+"','"+cp.getFolio_caja()+"','"+cp.getId_tipo_ingreso()+"','3','"+infoUsu.getCve_usuario()+"',CURDATE(),CURTIME(),'"+fichaDeposito+"','" +folioChequeNominativo +"', '" + cp.getCve_banco() + "'),";
						break;
						case 9:
							valoresInsert = valoresInsert + "('"+cp.getReferencia()+"','"+cp.getFolio_caja()+"','"+cp.getId_tipo_ingreso()+"','9','"+infoUsu.getCve_usuario()+"',CURDATE(),CURTIME(),'"+fichaDeposito+"', '" + cp.getCve_banco() + "'),";
						break;
					}
					break;
				}
			}
		}
		valoresInsert = valoresInsert.substring(0,valoresInsert.length()-1);	
		return valoresInsert;
	}
	
	private String obtenerRespuesta(String estatus, String fichaDeposito, String[] cheque, List<ChequesPosfechados> lstCP) 
	{
		String respuesta = "";
		String referencia = "";
		for (String cheques : cheque)
		{
			for (ChequesPosfechados cp : lstCP) 
			{
				if (Integer.parseInt(cheques) == cp.getNo())
				{
					referencia = referencia + cp.getReferencia()+",";
					break;
				}
			}
		}
		switch (Integer.parseInt(estatus)) 
		{
			case 1:
				respuesta = "Los pofechados ["+referencia.substring(0,referencia.length()-1)+"] cambiaron a estatus: CONFIRMADO POR CLIENTE.";
				break;
			case 2:
				respuesta = "Los pofechados ["+referencia.substring(0,referencia.length()-1)+"]cambiaron a estatus: TRANSITO DE DEPOSITO.";
				break;
			case 3:
				respuesta = "Los pofechados ["+referencia.substring(0,referencia.length()-1)+"] cambiaron a estatus: CONFIRMA DEPOSITO EN BANCO.";
				break;
			case 9:
				respuesta = "Los pofechados ["+referencia.substring(0,referencia.length()-1)+"] cambiaron a estatus: CANCELADO.";
				break;
		}
		return respuesta;
	}
	
	private String parametrosDeBuesqueda(int estatus, int banco, String cve_usu_ecc, String cheque, Usuario infoUsu) 
	{
		if(cheque.equals(""))
		{
			cheque = "00";
		}
		String parametros = "";
		if (estatus != 00) 
		{
			parametros = " and a.id_estatus = '"+estatus+"' ";
		}
		else
		{
			parametros = " and a.id_estatus = '0' ";
		}
		if (banco != 00) 
		{
			parametros = parametros+" and a.cve_banco = '"+banco+"' ";
		}
		if (!cve_usu_ecc.equals("00"))
		{
			parametros = parametros+" and a.cve_usu_ecc = '"+cve_usu_ecc+"' ";
		}
		if (Integer.parseInt(cheque) != 00) 
		{
			parametros = parametros+" and a.referencia = '"+cheque+"' ";
		}
		return parametros;
	}
	
	private String tipoDeFecha(int tipoFecha) 
	{
		String fecha = "";
		switch (tipoFecha)
		{
			case 1:
				fecha = " a.fecha_creacion ";
				break;
			case 2:
				fecha = " a.fecha_administrador ";
				break;
			case 3:
				fecha = " a.fecha_pago ";	
				break;
		}
		return fecha;
	}
	
	public List<Catalogo_Estatus> catalogoEstatusPosfechados(List<Catalogo_Estatus> lstEstatus, Usuario infoUsu, List<Querys> ListaQuerys) 
	{
		Connection connBD = null;
		PreparedStatement pstm = null;
		connBD = ConexionBD.AbrirConexionBD(infoUsu.getUname());
		try
		{
			String [] querys = new String [25];
			querys = Cls_Querys.LimpiaListaQuerys(querys);
			querys = Cls_Querys.ObtieneQuerys(58, ListaQuerys, querys, infoUsu);
			pstm = connBD.prepareStatement("{call " + "CTRL_INGRESOS.usp_EXECUTE_QUERY(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			ResultSet rs = EjecutaQuerysBD.EjecutarQuery(querys[0], querys[1],querys[2], querys[3], querys[4], querys[5], querys[6],
					 querys[7], querys[8], querys[9],querys[10], querys[11], querys[12], querys[13], 
					 querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], 
					 querys[21], querys[22], querys[23], querys[24], infoUsu.getUname(),pstm, connBD);
			while (rs.next())
			{
				Catalogo_Estatus catalogoEstatus = new Catalogo_Estatus();
				catalogoEstatus.setId_estatus(Integer.parseInt(rs.getString("id_estatus")));
				catalogoEstatus.setNombre_estatus(rs.getString("nombre"));
				lstEstatus.add(catalogoEstatus);
			}
		} 
		catch(Exception ex)
		{
			String sError= ex.getMessage().toString();
			Cls_Log.insertaLog(infoUsu, "", "", "Error al consultar catalogo estatus posfechados: [" + sError + "]");
		}
		finally
		{
			try {connBD.close();} catch (SQLException e) {e.printStackTrace();}
			try {pstm.close();} catch (SQLException e) {e.printStackTrace();}
		}
		return lstEstatus;
	}
	
	public List<Catalogo_Motivos_Cancelacion_Posfechados> obtenerMotivosCancelacion(List<Querys> ListaQuerys, Usuario infoUsu) 
	{
		List <Catalogo_Motivos_Cancelacion_Posfechados> LstMotivosCancelacion = new ArrayList<Catalogo_Motivos_Cancelacion_Posfechados>();
		Connection connBD = null;
		PreparedStatement pstm= null;		
		connBD = ConexionBD.AbrirConexionBD(infoUsu.getUname());
		try
		{
			String[] querys = new String[25];	
			querys = Cls_Querys.LimpiaListaQuerys(querys);
			querys = Cls_Querys.ObtieneQuerys(63, ListaQuerys, querys, infoUsu);	
			pstm = connBD.prepareStatement("{call " + "CTRL_INGRESOS.usp_EXECUTE_QUERY(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			ResultSet rs = EjecutaQuerysBD.EjecutarQuery(querys[0], querys[1],querys[2], querys[3], querys[4], querys[5], querys[6],
														 querys[7], querys[8], querys[9],querys[10], querys[11], querys[12], querys[13], 
														 querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], 
														 querys[21], querys[22], querys[23], querys[24], infoUsu.getUname(),pstm, connBD);			
			if (rs != null)
			 {
				 while (rs.next())
			        {
					 Catalogo_Motivos_Cancelacion_Posfechados motivosChqDev = new Catalogo_Motivos_Cancelacion_Posfechados();
					  motivosChqDev.setId_motivo(rs.getInt("id_motivo"));
					  motivosChqDev.setDescripcion(rs.getString("descripcion"));
					  motivosChqDev.setTipo(rs.getString("tipo"));
					  LstMotivosCancelacion.add(motivosChqDev);
			        }
			 }
		}
		catch(Exception ex)
		{
			String sError= ex.getMessage().toString();
			Cls_Log.insertaLog(infoUsu, "", "", "Error al consultar motivos cancelacion posfechados: [" + sError + "]");
		}
		finally
		{
			try {connBD.close();} catch (SQLException e) {e.printStackTrace();}
			try {pstm.close();} catch (SQLException e) {e.printStackTrace();}
		}
		return LstMotivosCancelacion;
	}
	
	private String[] inicializaQueryUpdate(String[] ListaQuerys, Usuario infoUsu, String valoresInsert) 
	{
		for (int i=0;i <ListaQuerys.length; i++)
		{	
			ListaQuerys[i]= ListaQuerys[i].replace("{VALORES}",valoresInsert);
		}
		return ListaQuerys;
	}
	
	private String[] inicializaQueryNumero56(String[] ListaQuerys, Usuario infoUsu, String fecha_ini, String fecha_fin,String parametros, int tipoFecha) 
	{
		for (int i=0;i <ListaQuerys.length; i++)
		{	
			ListaQuerys[i]= ListaQuerys[i].replace("{TIPOFECHA}",tipoDeFecha(tipoFecha));
			ListaQuerys[i]= ListaQuerys[i].replace("{FECHAINI}",fecha_ini);
			ListaQuerys[i]= ListaQuerys[i].replace("{FECHAFIN}",fecha_fin);
			ListaQuerys[i]= ListaQuerys[i].replace("{CDO}",infoUsu.getUname().toUpperCase());
			ListaQuerys[i]= ListaQuerys[i].replace("{PARAMETROS}",parametros);
		}
		return ListaQuerys;
	}

	private String[] inicializaQueryNumero71_72(String[] ListaQuerys, Usuario infoUsu, String referencia, int folioCaja, int cve_banco)
	{
		for (int i=0;i <ListaQuerys.length; i++)
		{	
			ListaQuerys[i]= ListaQuerys[i].replace("{PROCESO}","68");
			ListaQuerys[i]= ListaQuerys[i].replace("{USUARIO}",infoUsu.getCve_usuario());
			ListaQuerys[i]= ListaQuerys[i].replace("{REFERENCIA}",referencia);
			ListaQuerys[i]= ListaQuerys[i].replace("{FOLIO_CAJA}",String.valueOf(folioCaja));
			ListaQuerys[i]= ListaQuerys[i].replace("{BANCO_DEPOSITO}",String.valueOf(cve_banco));
		}
		return ListaQuerys;
	}
	
}
	
