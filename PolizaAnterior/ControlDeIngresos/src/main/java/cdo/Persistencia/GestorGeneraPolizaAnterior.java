package cdo.Persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import cdo.Datos.CortePanamericano;
import cdo.Datos.FichasBancarias;
import cdo.Datos.FichasBancariasEgresos;
import cdo.Datos.PolizaCompleta;
import cdo.Datos.PolizaDiaBancosIngresos;
import cdo.Datos.PolizaDiaOtrosIngresos;
import cdo.Datos.PolizaDiaTipoEgreso;
import cdo.Datos.PolizaDiaTipoIngreso;
import cdo.Datos.Querys;
import cdo.Datos.Usuario;
import cdo.util.Cls_Log;
import cdo.util.Cls_Querys;
import cdo.util.ConexionBD;
import cdo.util.EjecutaQuerysBD;

public class GestorGeneraPolizaAnterior 
{
	
	DecimalFormat formatoDecimal = new DecimalFormat("#,###.00");
	DateTimeFormatter df = DateTimeFormatter.ofPattern("dd/MM/yyyy"); 
	
	/****  CONSULTA SI YA FUE GENERADA LA POLIZA DE DIA  ****/
	public String  validarSiExistenPolizaDelDiaGenerada(Usuario infoUsu, List<Querys> ListaQuerys,String fechaPoliza)
	{
		fechaPoliza = generaSetenciaFecha(fechaPoliza);
		String existePoliza = "";
		Connection connBD = null;
		PreparedStatement pstm= null;		
		connBD = ConexionBD.AbrirConexionBD(infoUsu.getUname());
		try
		{
			String[] querys = new String[25];	
			querys = Cls_Querys.LimpiaListaQuerys(querys);	
			querys = Cls_Querys.ObtieneQuerys(114, ListaQuerys, querys, infoUsu);
			querys = InicializaQueryNumero114(querys, infoUsu, fechaPoliza);			
			pstm = connBD.prepareStatement("{call " + "CTRL_INGRESOS.usp_EXECUTE_QUERY(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			ResultSet rs= EjecutaQuerysBD.EjecutarQuery(querys[0], querys[1],querys[2], querys[3], querys[4], querys[5], querys[6],
														 querys[7], querys[8], querys[9],querys[10], querys[11], querys[12], querys[13], 
														 querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], 
														 querys[21], querys[22], querys[23], querys[24], infoUsu.getUname(),pstm, connBD);
			if(rs !=null)
			{
				rs.beforeFirst();
				while(rs.next())
				{
					if(rs.getString("tipo").equals("POL_EXISTEN"))
					{					
						if(rs.getInt("polizas_generadas") > 0)
						{
							existePoliza =  "¡Ya fue generada una Poliza Del Dia! [ Folio Poliza:"  + rs.getString("folio_poliza") + ", Fecha Poliza:" + rs.getString("fecha_poliza") +"]";
							break;
						}
					}			
				}
			}
		}
		catch(Exception ex)
		{
			String sError= ex.getMessage().toString();
			Cls_Log.insertaLog(infoUsu, "", "", "Error al consultar la poliza del dia actual : [" + sError + "]");
		}
		finally
		{
			try {connBD.close();} catch (SQLException e) {e.printStackTrace();}
			try {pstm.close();} catch (SQLException e) {e.printStackTrace();}
		}
		return existePoliza;
	}
	
	
	/****  CONSULTA POLIZA DEL DIA ACTUAL ****/
	public PolizaCompleta consultaPolizaDelDiaAnterior(Usuario infoUsu, List<Querys> ListaQuerys,HttpSession session ,String fechaPoliza)
	{
		fechaPoliza = generaSetenciaFecha(fechaPoliza);
		PolizaCompleta polizaCompleta = new PolizaCompleta();
		Connection connBD = null;
		PreparedStatement pstm= null;		
		connBD = ConexionBD.AbrirConexionBD(infoUsu.getUname());
		try
		{
			String[] querys = new String[25];	
			querys = Cls_Querys.LimpiaListaQuerys(querys);	
			querys = Cls_Querys.ObtieneQuerys(110, ListaQuerys, querys, infoUsu);/*POLIZA DINAMICA*/			
			querys = InicializaQueryNumero110(querys, infoUsu,fechaPoliza);
			pstm = connBD.prepareStatement("{call " + "CTRL_INGRESOS.usp_EXECUTE_QUERY(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			ResultSet rs1= EjecutaQuerysBD.EjecutarQuery(querys[0], querys[1],querys[2], querys[3], querys[4], querys[5], querys[6],
														 querys[7], querys[8], querys[9],querys[10], querys[11], querys[12], querys[13], 
														 querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], 
														 querys[21], querys[22], querys[23], querys[24], infoUsu.getUname(),pstm, connBD);
			
			querys = Cls_Querys.LimpiaListaQuerys(querys);	
			querys = Cls_Querys.ObtieneQuerys(111, ListaQuerys, querys, infoUsu);/*POLIZA DINAMICA*/
			querys = InicializaQueryNumero111(querys, infoUsu,fechaPoliza);
			pstm = connBD.prepareStatement("{call " + "CTRL_INGRESOS.usp_EXECUTE_QUERY(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			ResultSet rs2= EjecutaQuerysBD.EjecutarQuery(querys[0], querys[1],querys[2], querys[3], querys[4], querys[5], querys[6],
														 querys[7], querys[8], querys[9],querys[10], querys[11], querys[12], querys[13], 
														 querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], 
														 querys[21], querys[22], querys[23], querys[24], infoUsu.getUname(),pstm, connBD);	
			
			querys = Cls_Querys.LimpiaListaQuerys(querys);	
			querys = Cls_Querys.ObtieneQuerys(113, ListaQuerys, querys, infoUsu);/*POLIZA DINAMICA*/
			querys = InicializaQueryNumero113(querys, infoUsu,fechaPoliza);
			pstm = connBD.prepareStatement("{call " + "CTRL_INGRESOS.usp_EXECUTE_QUERY(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			ResultSet rs3= EjecutaQuerysBD.EjecutarQuery(querys[0], querys[1],querys[2], querys[3], querys[4], querys[5], querys[6],
														 querys[7], querys[8], querys[9],querys[10], querys[11], querys[12], querys[13], 
														 querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], 
														 querys[21], querys[22], querys[23], querys[24], infoUsu.getUname(),pstm, connBD);	
			
			querys = Cls_Querys.LimpiaListaQuerys(querys);	
			querys = Cls_Querys.ObtieneQuerys(115, ListaQuerys, querys, infoUsu);/*POLIZA DINAMICA*/
			querys = InicializaQueryNumero115(querys, infoUsu,fechaPoliza);
			for(int i=0; i < querys.length; i++)
			{
				System.out.println("ssf: "+querys[i]);
			}
			pstm = connBD.prepareStatement("{call " + "CTRL_INGRESOS.usp_EXECUTE_QUERY(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			ResultSet rs4= EjecutaQuerysBD.EjecutarQuery(querys[0], querys[1],querys[2], querys[3], querys[4], querys[5], querys[6],
														 querys[7], querys[8], querys[9],querys[10], querys[11], querys[12], querys[13], 
														 querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], 
														 querys[21], querys[22], querys[23], querys[24], infoUsu.getUname(),pstm, connBD);	
			
			querys = Cls_Querys.LimpiaListaQuerys(querys);	
			querys = Cls_Querys.ObtieneQuerys(116, ListaQuerys, querys, infoUsu);/*POLIZA DINAMICA*/
			querys = InicializaQueryNumero116(querys, infoUsu,fechaPoliza);
			pstm = connBD.prepareStatement("{call " + "CTRL_INGRESOS.usp_EXECUTE_QUERY(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			ResultSet rs5= EjecutaQuerysBD.EjecutarQuery(querys[0], querys[1],querys[2], querys[3], querys[4], querys[5], querys[6],
														 querys[7], querys[8], querys[9],querys[10], querys[11], querys[12], querys[13], 
														 querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], 
														 querys[21], querys[22], querys[23], querys[24], infoUsu.getUname(),pstm, connBD);
			
			querys = Cls_Querys.LimpiaListaQuerys(querys);	
			querys = Cls_Querys.ObtieneQuerys(117, ListaQuerys, querys, infoUsu);/*POLIZA DINAMICA*/
			querys = InicializaQueryNumero117(querys, infoUsu,fechaPoliza);
			pstm = connBD.prepareStatement("{call " + "CTRL_INGRESOS.usp_EXECUTE_QUERY(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			ResultSet rs6= EjecutaQuerysBD.EjecutarQuery(querys[0], querys[1],querys[2], querys[3], querys[4], querys[5], querys[6],
														 querys[7], querys[8], querys[9],querys[10], querys[11], querys[12], querys[13], 
														 querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], 
														 querys[21], querys[22], querys[23], querys[24], infoUsu.getUname(),pstm, connBD);
			
			querys = Cls_Querys.LimpiaListaQuerys(querys);	
			querys = Cls_Querys.ObtieneQuerys(120, ListaQuerys, querys, infoUsu);/*POLIZA DINAMICA*/
			pstm = connBD.prepareStatement("{call " + "CTRL_INGRESOS.usp_EXECUTE_QUERY(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			ResultSet rs7=EjecutaQuerysBD.EjecutarQuery(querys[0], querys[1],querys[2], querys[3], querys[4], querys[5], querys[6],
														 querys[7], querys[8], querys[9],querys[10], querys[11], querys[12], querys[13], 
														 querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], 
														 querys[21], querys[22], querys[23], querys[24], infoUsu.getUname(),pstm, connBD);
			
			polizaCompleta= llenaClasesDePolizaDelDia(rs1,rs2,rs3,rs4,rs5,rs6,rs7, infoUsu, session);
			Cls_Log.insertaLog(infoUsu, "", "", " Consulta Poliza Del Dia Actual ");
		}
		catch(Exception ex)
		{
			String sError= ex.getMessage().toString();
			Cls_Log.insertaLog(infoUsu, "", "", "Error al consultar la poliza completa del dia actual : [" + sError + "]");
		}
		finally
		{
			try {connBD.close();} catch (SQLException e) {e.printStackTrace();}
			try {pstm.close();} catch (SQLException e) {e.printStackTrace();}
		}		
		return polizaCompleta;
	}


	private PolizaCompleta  llenaClasesDePolizaDelDia(ResultSet rs1, ResultSet rs2, ResultSet rs3, ResultSet rs4, ResultSet rs5,ResultSet rs6,ResultSet rs7, Usuario infoUsu, HttpSession session)
	{
		PolizaCompleta polizaCompleta = new PolizaCompleta();
		try
		{
			if(rs1 !=null)
			{
				rs1.beforeFirst();
				while(rs1.next())
				{
					if(rs1.getString("tipo_poliza").equals("D"))
					{
						polizaCompleta.setFolio_poliza(rs1.getString("folio_poliza"));
						break;
					}
				}			
				polizaCompleta.setListaPolDiaTipoIngreso(llenaClasePolDiaTipoIngresos(rs1, infoUsu));
				polizaCompleta.setListaPolDiaBancoIngresos(llenaClasePolDiaBancosIngreso(rs1, infoUsu));				
			}
			
			if(rs2 != null)
			{
				polizaCompleta.setListaPolDiaOtrosIngresos(llenaClasePolDiaOtrosIngresos(rs2, infoUsu));
				polizaCompleta.setListaPolDiaTipoEgreso(llenaClasePolDiaEgresos(rs2, infoUsu));
			}
			
			if(rs3 != null)
			{
				polizaCompleta.setListaRecoleccionValores(llenaClaseRecoleccionValores(rs3, infoUsu));
			}
			
			if(rs4 != null)
			{
				rs4.beforeFirst();
				
				polizaCompleta.setTransito_aplicado("0.00");
				polizaCompleta.setTransito_pendiente("0.00");				
				while(rs4.next())
				{
					if(rs4.getString("tipo").equals("T"))
					{
						polizaCompleta.setTransito_pendiente(rs4.getString("importe"));
					} 
					else if(rs4.getString("tipo").equals("A"))
					{
						polizaCompleta.setTransito_aplicado(rs4.getString("importe"));
					}
				}
			}
			
			if(rs5 != null)
			{
				polizaCompleta.setListafichasBancarias(llenarClaseFichasBancarias(rs5, infoUsu));
			}
			
			if(rs6 != null)
			{
				polizaCompleta.setListafichasBancariasEgresos(llenarClaseFichasBancariasEgresos(rs6, infoUsu));
			}
			
			if(rs7 != null)
			{
				polizaCompleta = llenaAjustesDeChequePoliza(polizaCompleta, rs7, infoUsu);
			}
			/*Poliza Contable*/
			//polizaCompleta.setPolizaContable(llenaClasePolizaContable(infoUsu, rs5, rs6,rs3,rs2, polizaCompleta.getTransito_pendiente(), polizaCompleta.getTransito_aplicado(),rs1, session));
		}
		catch(Exception ex)
		{
			Cls_Log.insertaLog(infoUsu, "", "", "Error al llenar las clases de poliza del dia: [" +ex.getMessage().toString() + "]");
		}
		return polizaCompleta;
	}	
		
	private List<FichasBancarias> llenarClaseFichasBancarias(ResultSet rs, Usuario infoUsu)
	{
		List<FichasBancarias> listaFichasBancarias=new ArrayList<>();
		try
		{
			rs.beforeFirst();
			while(rs.next())
			{				
				FichasBancarias ficha= new FichasBancarias();
				ficha.setCve_banco(rs.getInt("cve_banco_caja"));
				ficha.setBanco(rs.getString("nombre_banco"));
				ficha.setFicha_bancaria(rs.getString("ficha_deposito"));
				ficha.setImporte(rs.getString("importe"));
				ficha.setAcumulado(rs.getString("acum"));
				listaFichasBancarias.add(ficha);
			}				
		}
		catch(Exception ex)
		{
			Cls_Log.insertaLog(infoUsu, "", "", "Error al llenar clase fichas bancarias [" +ex.getMessage().toString() + "]");
		}
		return listaFichasBancarias;
	}

	private List<FichasBancariasEgresos> llenarClaseFichasBancariasEgresos(ResultSet rs, Usuario infoUsu)
	{
		List<FichasBancariasEgresos> listaFichasBancariasEgresos=new ArrayList<>();
		try
		{
			rs.beforeFirst();
			while(rs.next())
			{					
				FichasBancariasEgresos ficha= new FichasBancariasEgresos();
				ficha.setCve_banco(rs.getInt("cve_banco"));
				ficha.setBanco(rs.getString("nombre"));
				ficha.setFicha_bancaria(rs.getString("numero_transferencia"));
				ficha.setImporte(rs.getString("importe"));
				ficha.setAcumulado(rs.getString("acum"));
				listaFichasBancariasEgresos.add(ficha);
			}				
		}
		catch(Exception ex)
		{
			Cls_Log.insertaLog(infoUsu, "", "", "Error al llenar clase fichas bancarias de egresos [" +ex.getMessage().toString() + "]");
		}
		return listaFichasBancariasEgresos;
	}
	
	private List<PolizaDiaTipoEgreso> llenaClasePolDiaEgresos(ResultSet rs, Usuario infoUsu)
	{
		List<PolizaDiaTipoEgreso> listaPolDiaEgresos=new ArrayList<>();
		try
		{
			rs.beforeFirst();
			while(rs.next())
			{				
				if(rs.getString("tipo_poliza").equals("D"))
				{
					if(rs.getString("pol_egresos").toString().equals("*"))
					{
						PolizaDiaTipoEgreso polEgresos= new PolizaDiaTipoEgreso();
						polEgresos.setTipo_egreso(rs.getInt("pol_id_tipo_egresos"));
						polEgresos.setNombre_tipo_egreso(rs.getString("pol_nombre_egresos").toUpperCase());
						polEgresos.setImporte_efectivo(rs.getString("pol_egresos_efectivo"));
						polEgresos.setImporte_cheque(rs.getString("pol_egresos_cheque"));
						polEgresos.setImporte_tCredito(rs.getString("pol_egresos_TCredito"));
						polEgresos.setImporte_tDebito(rs.getString("pol_egresos_TDebito"));
						polEgresos.setImporte_transferencia(rs.getString("pol_egresos_transferencia"));
						polEgresos.setImporte_posfechado(rs.getString("pol_egresos_posfechado"));
						polEgresos.setCve_banco(rs.getString("pol_cve_banco_egresos"));
						polEgresos.setNombre_banco(rs.getString("pol_nombre_banco_egresos"));
						listaPolDiaEgresos.add(polEgresos);
					}				
				}		
			}				
		}
		catch(Exception ex)
		{
			Cls_Log.insertaLog(infoUsu, "", "", "Error al llenar clase poliza otros ingresos: [" +ex.getMessage().toString() + "]");
		}
		return listaPolDiaEgresos;
	}
	
	private List<PolizaDiaOtrosIngresos> llenaClasePolDiaOtrosIngresos(ResultSet rs, Usuario infoUsu)
	{
		List<PolizaDiaOtrosIngresos> listaPolDiaOtrosIngreso=new ArrayList<>();
		try
		{
			rs.beforeFirst();
			while(rs.next())
			{
				if(rs.getString("tipo_poliza").equals("D"))
				{
					if(rs.getString("pol_otros_ingresos").toString().equals("*"))
					{
						PolizaDiaOtrosIngresos polOtroIngreso= new PolizaDiaOtrosIngresos();
						polOtroIngreso.setId_otro_ingreso(rs.getInt("pol_id_otros_ingresos"));
						polOtroIngreso.setNombre_otro_ingreso(rs.getString("pol_nombre_otros_ingresos").toUpperCase());
						polOtroIngreso.setImporte_efectivo(rs.getString("pol_otros_efectivo"));
						polOtroIngreso.setImporte_cheque(rs.getString("pol_otros_cheque"));
						polOtroIngreso.setImporte_tCredito(rs.getString("pol_otros_TCredito"));
						polOtroIngreso.setImporte_tDebito(rs.getString("pol_otros_TDebito"));
						polOtroIngreso.setImporte_transferencia(rs.getString("pol_otros_transferencia"));
						polOtroIngreso.setImporte_posfechado(rs.getString("pol_otros_posfechado"));
						listaPolDiaOtrosIngreso.add(polOtroIngreso);
					}				
				}		
			}				
		}
		catch(Exception ex)
		{
			Cls_Log.insertaLog(infoUsu, "", "", "Error al llenar clase poliza otros ingresos: [" +ex.getMessage().toString() + "]");
		}
		return listaPolDiaOtrosIngreso;
	}
		
	private List<PolizaDiaTipoIngreso> llenaClasePolDiaTipoIngresos(ResultSet rs, Usuario infoUsu)
	{
		List<PolizaDiaTipoIngreso> listaPolDiaTipoIngreso=new ArrayList<>();
		PolizaDiaTipoIngreso polTipoIngresoOtro= new PolizaDiaTipoIngreso();		
		try
		{
			rs.beforeFirst();
			while(rs.next())
			{
				if(rs.getString("tipo_poliza").equals("D"))
				{
					if(rs.getString("pol_tipo").toString().equals("*"))
					{
						if(rs.getInt("pol_id_tipo_ingreso") == 4)
						{
							polTipoIngresoOtro.setTipo_pago(rs.getInt("pol_id_tipo_ingreso"));
							polTipoIngresoOtro.setNombre_tipo_pago(rs.getString("pol_nombre_tipo_ingreso").toUpperCase());
							polTipoIngresoOtro.setImporte_efectivo(rs.getString("pol_tipo_efectivo"));
							polTipoIngresoOtro.setImporte_cheque(rs.getString("pol_tipo_cheque"));
							polTipoIngresoOtro.setImporte_tCredito(rs.getString("pol_tipo_TCredito"));
							polTipoIngresoOtro.setImporte_tDebito(rs.getString("pol_tipo_TDebito"));
							polTipoIngresoOtro.setImporte_transferencia(rs.getString("pol_tipo_transferencia"));
							polTipoIngresoOtro.setImporte_posfechado(rs.getString("pol_tipo_posfechado"));	
						}
						else
						{
							PolizaDiaTipoIngreso polTipoIngreso= new PolizaDiaTipoIngreso();
							polTipoIngreso.setTipo_pago(rs.getInt("pol_id_tipo_ingreso"));
							polTipoIngreso.setNombre_tipo_pago(rs.getString("pol_nombre_tipo_ingreso").toUpperCase());
							polTipoIngreso.setImporte_efectivo(rs.getString("pol_tipo_efectivo"));
							polTipoIngreso.setImporte_cheque(rs.getString("pol_tipo_cheque"));
							polTipoIngreso.setImporte_tCredito(rs.getString("pol_tipo_TCredito"));
							polTipoIngreso.setImporte_tDebito(rs.getString("pol_tipo_TDebito"));
							polTipoIngreso.setImporte_transferencia(rs.getString("pol_tipo_transferencia"));
							polTipoIngreso.setImporte_posfechado(rs.getString("pol_tipo_posfechado"));						
							listaPolDiaTipoIngreso.add(polTipoIngreso);
						}
					}				
				}		
			}
			listaPolDiaTipoIngreso.add(polTipoIngresoOtro);
		}
		catch(Exception ex)
		{
			Cls_Log.insertaLog(infoUsu, "", "", "Error al llenar clase poliza tipo de ingreso: [" +ex.getMessage().toString() + "]");
		}
		return listaPolDiaTipoIngreso;
	}
	
	private List<PolizaDiaBancosIngresos> llenaClasePolDiaBancosIngreso(ResultSet rs, Usuario infoUsu)
	{
		List<PolizaDiaBancosIngresos> listaPolDiaBancos=new ArrayList<>();
		try
		{
			rs.beforeFirst();
			double efectivo = 0;
			while(rs.next())
			{
				if(rs.getString("tipo_poliza").equals("D"))
				{
					if(rs.getString("pol_bancos").toString().equals("*"))
					{
						efectivo  = efectivo + Double.parseDouble(rs.getString("pol_banco_efectivo"));
						PolizaDiaBancosIngresos polBanco= new PolizaDiaBancosIngresos();
						polBanco.setCve_banco(rs.getInt("pol_cve_banco_ingreso"));
						polBanco.setNombre_banco(rs.getString("pol_nombre_banco_ingresos"));
						polBanco.setImporte_cheque(rs.getString("pol_banco_cheque"));
						polBanco.setImporte_tCredito(rs.getString("pol_banco_TCredito"));
						polBanco.setImporte_tDebito(rs.getString("pol_banco_TDebito"));
						polBanco.setImporte_transferencia(rs.getString("pol_banco_transferencia"));
						polBanco.setImporte_posfechado(rs.getString("pol_banco_posfechado"));
						polBanco.setImporte_efectivo("0");
						listaPolDiaBancos.add(polBanco);
					}				
				}	
			}
			
			for(PolizaDiaBancosIngresos ban : listaPolDiaBancos)
			{
				if(String.valueOf(ban.getCve_banco()).equals("1"))
				{
					ban.setImporte_efectivo(String.valueOf(efectivo));
					break;
				}
			}
			
		}
		catch(Exception ex)
		{
			Cls_Log.insertaLog(infoUsu, "", "", "Error al llenar clase poliza banco de ingresos: [" +ex.getMessage().toString() + "]");
		}
		return listaPolDiaBancos;
	}
	
	private List<CortePanamericano> llenaClaseRecoleccionValores(ResultSet rs, Usuario infoUsu) 
	{
		List<CortePanamericano> listaPolValores=new ArrayList<>();
		try
		{
			rs.beforeFirst();
			while(rs.next())
			{
				CortePanamericano polValor= new CortePanamericano();
				polValor.setFolio_panamericano(rs.getInt("folio_panamericano"));
				polValor.setImporte(rs.getString("importe"));
				listaPolValores.add(polValor);
			}
		}
		catch(Exception ex)
		{
			Cls_Log.insertaLog(infoUsu, "", "", "Error al llenar clase poliza recoleccion de valores: [" +ex.getMessage().toString() + "]");
		}
		return listaPolValores;
	}
		
	private PolizaCompleta llenaAjustesDeChequePoliza(PolizaCompleta polizaCompleta, ResultSet rs, Usuario infoUsu)
	{
		try
		{
			polizaCompleta.setAjusteMenosCheque("0");	
			polizaCompleta.setAjusteMasCheque("0");
			while(rs.next())
			{
				if(rs.getDouble("ajusteCheque") > 0)
				{
					polizaCompleta.setAjusteMenosCheque("-" + formatoDecimal.format(rs.getDouble("ajusteCheque")));						
				}
				else  if(rs.getDouble("ajusteCheque") < 0)
				{
					polizaCompleta.setAjusteMasCheque(formatoDecimal.format(Double.parseDouble(String.valueOf(rs.getDouble("ajusteCheque")).replace("-", ""))));
				}
			}			
		}
		catch(Exception ex)
		{
			System.out.println("Error al llenar poliza del dia. Detalle:" + ex.getMessage());
		}
		return polizaCompleta;
	}
		
	public String obtieneTotalDePolizanteriorAnterior( List<PolizaDiaTipoIngreso> listaPolizaITipo, List<PolizaDiaTipoEgreso> listaPolizaEgreso)
	{
		double totalPoliza = 0;
		if(listaPolizaITipo.size() > 0)
		{
			for(PolizaDiaTipoIngreso IXTipo: listaPolizaITipo)
			{
				double totalI= Double.parseDouble(IXTipo.getImporte_efectivo().replace(",", "")) + Double.parseDouble(IXTipo.getImporte_cheque().replace(",", ""))+
							  Double.parseDouble(IXTipo.getImporte_tCredito().replace(",", ""))+Double.parseDouble(IXTipo.getImporte_tDebito().replace(",", ""))+
							  Double.parseDouble(IXTipo.getImporte_transferencia().replace(",", ""));
				totalPoliza =  totalPoliza + totalI;
			}
		}
		
		if(listaPolizaEgreso.size() > 0)
		{
			for(PolizaDiaTipoEgreso EXTipo: listaPolizaEgreso)
			{				
				double totalE= Double.parseDouble(EXTipo.getImporte_efectivo().replace(",", "")) + Double.parseDouble(EXTipo.getImporte_cheque().replace(",", ""))+
						  Double.parseDouble(EXTipo.getImporte_tCredito().replace(",", ""))+Double.parseDouble(EXTipo.getImporte_tDebito().replace(",", ""))+
						  Double.parseDouble(EXTipo.getImporte_transferencia().replace(",", ""));
				totalPoliza =  totalPoliza - totalE;
			}
		}
		
		DecimalFormat formatoDecimal = new DecimalFormat("#.##");		
		return String.valueOf(formatoDecimal.format(totalPoliza));
	}
	

	/**** INICIALIZA LOS QUERYS DE EGRESOS ****/				
	private String[] InicializaQueryNumero114(String[] ListaQuerys, Usuario infoUsu, String fechaPoliza) 
	{		
		for (int i=0;i <ListaQuerys.length; i++)
		{
			ListaQuerys[i]= ListaQuerys[i].replace("{FECHA_POLIZA_ANT}", fechaPoliza);			
		}
		return ListaQuerys;
	}
		
	private String[] InicializaQueryNumero111(String[] ListaQuerys, Usuario infoUsu, String fechaPoliza) 
	{		
		for (int i=0;i <ListaQuerys.length; i++)
		{
			ListaQuerys[i]= ListaQuerys[i].replace("{FECHA_POLIZA_ANT}", fechaPoliza);			
		}
		return ListaQuerys;
	}
	
	private String[] InicializaQueryNumero115(String[] ListaQuerys, Usuario infoUsu, String fechaPoliza) 
	{		
		for (int i=0;i <ListaQuerys.length; i++)
		{
			ListaQuerys[i]= ListaQuerys[i].replace("{FECHA_POLIZA_ANT}", fechaPoliza);			
		}
		return ListaQuerys;
	}
	
	private String[] InicializaQueryNumero110(String[] ListaQuerys, Usuario infoUsu, String fechaPoliza) 
	{		
		for (int i=0;i <ListaQuerys.length; i++)
		{
			ListaQuerys[i]= ListaQuerys[i].replace("{BANCO_X_CDO}", String.valueOf(obtenerBancoParaHRyConXCDO(infoUsu.getUname())));
			ListaQuerys[i]= ListaQuerys[i].replace("{FECHA_POLIZA_ANT}", fechaPoliza);	
		}
		return ListaQuerys;
	}
		
	private String[] InicializaQueryNumero112(String[] ListaQuerys, Usuario infoUsu,String insertPolizaIXBanco,String insertPolizaIXTipoPago,String insertPolizaEXTipo,String insertPolizaOI,String importeTotalCorte , String fechaPoliza) 
	{		
		if(insertPolizaEXTipo.length()<=0)
		{
			ListaQuerys[6]="";
		}
		
		if(insertPolizaOI.length()<=0)
		{
			ListaQuerys[5]="";
		}		
		
		for (int i=0;i <ListaQuerys.length; i++)
		{
			ListaQuerys[i]= ListaQuerys[i].replace("{IMPORTE_POLIZA}",importeTotalCorte );
			ListaQuerys[i]= ListaQuerys[i].replace("{USUARIO}",infoUsu.getCve_usuario() );
			ListaQuerys[i]= ListaQuerys[i].replace("{VALUES_TIPO_PAGO}",insertPolizaIXTipoPago);
			ListaQuerys[i]= ListaQuerys[i].replace("{VALUES_BANCOS}",insertPolizaIXBanco);
			ListaQuerys[i]= ListaQuerys[i].replace("{VALUES_OTROS_INGRESOS}",insertPolizaOI );
			ListaQuerys[i]= ListaQuerys[i].replace("{VALUES_EGRESOS_TIPOS}",insertPolizaEXTipo );
			ListaQuerys[i]= ListaQuerys[i].replace("{FECHA_POLIZA_ANT}", fechaPoliza);	
		}
		return ListaQuerys;
	}
	
	private String[] InicializaQueryNumero113(String[] ListaQuerys, Usuario infoUsu , String fechaPoliza) 
	{		
		for (int i=0;i <ListaQuerys.length; i++)
		{
			ListaQuerys[i]= ListaQuerys[i].replace("{FECHA_PANAMERICANO}"," AND fecha_poliza = '" + fechaPoliza +"'");
			ListaQuerys[i]= ListaQuerys[i].replace("{UNAME_CONSULTA}", infoUsu.getUname_br().toLowerCase());
			ListaQuerys[i]= ListaQuerys[i].replace("{FECHA_POLIZA_ANT}", fechaPoliza);	
		}
		return ListaQuerys;
	}
			
	private String[] InicializaQueryNumero116(String[] ListaQuerys, Usuario infoUsu, String fechaPoliza) 
	{		
		for (int i=0;i <ListaQuerys.length; i++)
		{
			ListaQuerys[i]= ListaQuerys[i].replace("{FECHA_POLIZA}", "'" + fechaPoliza +"'");	
			ListaQuerys[i]= ListaQuerys[i].replace("{ESTATUS}", "1");
			ListaQuerys[i]= ListaQuerys[i].replace("{UNAME_CONSULTA}", infoUsu.getUname_br().toLowerCase());
			ListaQuerys[i]= ListaQuerys[i].replace("{FECHA_POLIZA_ANT}", fechaPoliza);	
		}
		return ListaQuerys;
	}
	
	private String[] InicializaQueryNumero117(String[] ListaQuerys, Usuario infoUsu, String fechaPoliza) 
	{		
		for (int i=0;i <ListaQuerys.length; i++)
		{
			ListaQuerys[i]= ListaQuerys[i].replace("{FECHA_POLIZA}", "'" + fechaPoliza +"'");	
			ListaQuerys[i]= ListaQuerys[i].replace("{ESTATUS}", "2,3");
			ListaQuerys[i]= ListaQuerys[i].replace("{UNAME_CONSULTA}", infoUsu.getUname_br().toLowerCase());
			ListaQuerys[i]= ListaQuerys[i].replace("{FECHA_POLIZA_ANT}", fechaPoliza);	
		}
		return ListaQuerys;
	}
	
	private String[] InicializaQueryNumero119(String[] ListaQuerys, Usuario infoUsu, String FolioPoliza, String fechaPoliza) 
	{		
		for (int i=0;i <ListaQuerys.length; i++)
		{
			ListaQuerys[i]= ListaQuerys[i].replace("{FOLIO_POLIZA}", FolioPoliza);	
			ListaQuerys[i]= ListaQuerys[i].replace("{FECHA_POLIZA_ANT}", fechaPoliza);	
		}
		return ListaQuerys;
	}
	
	private int obtenerBancoParaHRyConXCDO(String uname_br)
	{
		int banco = 5;
		return banco;
	}
	
	private String generaSetenciaFecha(String  fecha)
	{
		String arrayFecha[] =  fecha.split("/");
		String sentencia_fecha = ""; 
	
		sentencia_fecha = arrayFecha[2] + "-" + arrayFecha[1] + "-" + arrayFecha[0];
		
		return sentencia_fecha;
	}

}
