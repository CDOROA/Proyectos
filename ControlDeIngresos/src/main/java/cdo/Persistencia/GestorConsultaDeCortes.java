package cdo.Persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.poi.hssf.record.PageBreakRecord.Break;

import cdo.Datos.ConsultaCortesCaja;
import cdo.Datos.CorteDeCaja;
import cdo.Datos.CortePanamericano;
import cdo.Datos.FichasBancarias;
import cdo.Datos.FichasBancariasEgresos;
import cdo.Datos.PolizaCompleta;
import cdo.Datos.PolizaContable;
import cdo.Datos.PolizaDiaBancosIngresos;
import cdo.Datos.PolizaDiaOtrosIngresos;
import cdo.Datos.PolizaDiaTipoEgreso;
import cdo.Datos.PolizaDiaTipoIngreso;
import cdo.Datos.PrevioCorteCaja;
import cdo.Datos.PrevioEgresos;
import cdo.Datos.PrevioEgresosBanco;
import cdo.Datos.PrevioIngresosBancos;
import cdo.Datos.PrevioIngresosFormaPago;
import cdo.Datos.PrevioIngresosTipoPago;
import cdo.Datos.Querys;
import cdo.Datos.Usuario;
import cdo.util.Cls_Log;
import cdo.util.Cls_MetodosGlobales;
import cdo.util.Cls_Querys;
import cdo.util.ConexionBD;
import cdo.util.EjecutaQuerysBD;

public class GestorConsultaDeCortes {
	
	DecimalFormat formatoDecimal = new DecimalFormat("#,###.00");
	
	/****  CONSULTA DE CORTES DE CAJA  ****/
	public ConsultaCortesCaja consultarCortesDeCajaEnBD(Usuario infoUsu, List<Querys> ListaQuerys, String fechaCorteCaja, String folioCorteCaja, String origen, String uname_br_consulta)
	{
		ConsultaCortesCaja previoCorteCaja=null;
		String strQry="";
		Connection connBD = null;
		PreparedStatement pstm= null;		
		connBD = ConexionBD.AbrirConexionBD(infoUsu.getUname());
		try
		{
			String[] querys = new String[25];	
			querys = Cls_Querys.LimpiaListaQuerys(querys);	
			querys = Cls_Querys.ObtieneQuerys(29, ListaQuerys, querys, infoUsu);
			querys = InicializaQueryNumero29(querys, infoUsu, folioCorteCaja, fechaCorteCaja, origen,uname_br_consulta);
			strQry = Cls_MetodosGlobales.obtieneSentenciaDeQrys(querys);
			pstm = connBD.prepareStatement("{call " + "CTRL_INGRESOS.usp_EXECUTE_QUERY(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			ResultSet rs= EjecutaQuerysBD.EjecutarQuery(querys[0], querys[1],querys[2], querys[3], querys[4], querys[5], querys[6],
														 querys[7], querys[8], querys[9],querys[10], querys[11], querys[12], querys[13], 
														 querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], 
														 querys[21], querys[22], querys[23], querys[24], infoUsu.getUname(),pstm, connBD);
			
			if(rs !=null)
			{
				previoCorteCaja=new ConsultaCortesCaja(LlenaClasesIngresosTipoPago(rs), LlenaClasesIngresosFormaPago(rs), 
						LlenaClaseEgresosTipo(rs),LlenaClasesIngresosBancos(rs),LlenaClasesEgresosBancos(rs),LlenaClasesCortesDeCaja(rs));
			}		
			Cls_Log.insertaLog(infoUsu, "", "", " Consulta cortes de Caja: [Fecha:" + fechaCorteCaja + ", Folio:" + folioCorteCaja+" ]  "   +  " QUERIES-29[" + strQry + "]");
			
		}
		catch(Exception ex)
		{
			String sError= ex.getMessage().toString();
			Cls_Log.insertaLog(infoUsu, "", "", "Error al consultar los egresos: [" + sError + "]  "   +  " QUERIES-29[" + strQry + "]");
		}
		finally
		{
			try {connBD.close();} catch (SQLException e) {e.printStackTrace();}
			try {pstm.close();} catch (SQLException e) {e.printStackTrace();}
		}
		
		return previoCorteCaja;
	}
	
	private List<CorteDeCaja> LlenaClasesCortesDeCaja(ResultSet rs)
	{
		List<CorteDeCaja> LlenaClasesCaja =new  ArrayList<>();
		try
		{
			rs.beforeFirst();
			while(rs.next())
			{
				if(rs.getString("general").equals("*"))
				{
					CorteDeCaja corte =new CorteDeCaja( "", "", rs.getString("folio_corte"), "$ " + formatoDecimal.format(rs.getDouble("importe_corte")), 
														"", rs.getString("cve_usuario_corte"),  rs.getString("nombre_usuario_corte"), 0, 0, 0, rs.getString("fecha_corte"), 
														rs.getString("hora_corte"), "", "", false, "0","0", "", "");
					LlenaClasesCaja.add(corte);
				}
			}
		}
		catch(Exception ex)
		{
			System.out.println("Error al llenar la clase de cortes de caja. Detalle" + ex.getMessage().toString());
		}
		
		return LlenaClasesCaja;
	}
	
	private List<PrevioIngresosBancos> LlenaClasesIngresosBancos(ResultSet rs)
	{
		List<PrevioIngresosBancos> LlenaClasesBancos =new  ArrayList<>();
		try
		{
			rs.beforeFirst();
			while(rs.next())
			{
				if(rs.getString("ingresosBanco").equals("*"))
				{
					PrevioIngresosBancos banco = new PrevioIngresosBancos(rs.getInt("id_banco_ingreso"), 
																		  rs.getString("nombre_banco_ingreso").toUpperCase(), 
																		  "$ " + formatoDecimal.format(rs.getDouble("importe_banco_ingreso")));
					LlenaClasesBancos.add(banco);
				}
			}
		}
		catch(Exception ex)
		{
			System.out.println("Error al llenar la clase de previo bancos. Detalle" + ex.getMessage().toString());
		}
		return LlenaClasesBancos;
	}
	
	private List<PrevioIngresosTipoPago> LlenaClasesIngresosTipoPago(ResultSet rs)
	{
		List<PrevioIngresosTipoPago> listaPrevioXTP =new  ArrayList<>();
			
		try
		{
			rs.beforeFirst();
			while(rs.next())
			{
				if(rs.getString("ingresosTipo").equals("*"))
				{
					if(rs.getDouble("importe_tipo_ingreso") > 0)
					{
						PrevioIngresosTipoPago previoTP = new PrevioIngresosTipoPago(rs.getInt("tipo_pago_ingreso"), 
																					 rs.getString("nombre_tipo_ingreso").toUpperCase(), 
																					 "$ " + formatoDecimal.format(rs.getDouble("importe_tipo_ingreso")));
						listaPrevioXTP.add(previoTP);
					}
				}
			}
		}
		catch(Exception ex)
		{
			System.out.println("Error al llenar la clase de previo de tipo de pago Detalle:" + ex.getMessage().toString());
		}
		return  listaPrevioXTP;
	}
	
	private List<PrevioIngresosFormaPago> LlenaClasesIngresosFormaPago(ResultSet rs)
	{
		List<PrevioIngresosFormaPago> listaPrevioXFP =new  ArrayList<>();
		try
		{
			rs.beforeFirst();
			while(rs.next())
			{
				if(rs.getString("ingreso_formaPago").equals("*"))
				{
					if(rs.getDouble("importe_formaPago_ingreso") > 0)
					{
						PrevioIngresosFormaPago previoFP= new PrevioIngresosFormaPago(rs.getInt("cve_forma_pago_ingreso"),
																					  rs.getString("forma_pago_ingreso"), 
																					  "$ " + formatoDecimal.format( rs.getDouble("importe_formaPago_ingreso")));
						listaPrevioXFP.add(previoFP);
					}
				}
			}
		}
		catch(Exception ex)
		{
			System.out.println("Error al llenar la clase de previo de forma de pago.");
		}
		return listaPrevioXFP;
	}
	
	private List<PrevioEgresos> LlenaClaseEgresosTipo(ResultSet rs)
	{
		List<PrevioEgresos> listaPrevioEgresos =new  ArrayList<>();
		try
		{
			rs.beforeFirst();
			while(rs.next())
			{
				if(rs.getString("egresos_tipo").equals("*"))
				{
					PrevioEgresos previoE= new PrevioEgresos(rs.getInt("id_tipo_egreso"), 
															 rs.getString("nombre_tipo_egreso").toUpperCase(),  
															 "$ " + formatoDecimal.format( rs.getDouble("importe_tipo_egreso")));
					listaPrevioEgresos.add(previoE);
				}
			}
		}
		catch(Exception ex)
		{
			System.out.println("Error al llenar la clase de previo egresos.");
		}
		
		return listaPrevioEgresos;
	}
	
	private List<PrevioEgresosBanco> LlenaClasesEgresosBancos(ResultSet rs)
	{
		List<PrevioEgresosBanco> LlenaClasesEBancos =new  ArrayList<>();
		try
		{
			rs.beforeFirst();
			while(rs.next())
			{
				if(rs.getString("egresosBanco").equals("*"))
				{
					PrevioEgresosBanco banco = new PrevioEgresosBanco(rs.getInt("id_banco_egreso"),
																	  rs.getString("nombre_banco_egreso").toUpperCase(), 
																	  "$ " + formatoDecimal.format(rs.getDouble("importe_banco_egreso")));
					LlenaClasesEBancos.add(banco);
				}
			}
		}
		catch(Exception ex)
		{
			System.out.println("Error al llenar la clase de previo bancos. Detalle" + ex.getMessage().toString());
		}
		return LlenaClasesEBancos;
	}
	
	
	/**** CONSULTA CORTES DE POLIZA  ****/	
	public PolizaCompleta consultarCortesDePolizaEnBD(Usuario infoUsu, List<Querys> ListaQuerys, String fechaCortePoliza, String folioCortePoliza, String uname_br_consulta)
	{
		PolizaCompleta polizaCompleta=new PolizaCompleta();
		String strQry="";
		Connection connBD = null;
		PreparedStatement pstm= null;		
		connBD = ConexionBD.AbrirConexionBD(infoUsu.getUname());
		try
		{
			String[] querys = new String[25];	
			querys = Cls_Querys.LimpiaListaQuerys(querys);	
			querys = Cls_Querys.ObtieneQuerys(77, ListaQuerys, querys, infoUsu);
			querys = InicializaQueryNumero77(querys, infoUsu, folioCortePoliza, fechaCortePoliza, uname_br_consulta);
			strQry = Cls_MetodosGlobales.obtieneSentenciaDeQrys(querys);
			pstm = connBD.prepareStatement("{call " + "CTRL_INGRESOS.usp_EXECUTE_QUERY(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			ResultSet rs= EjecutaQuerysBD.EjecutarQuery(querys[0], querys[1],querys[2], querys[3], querys[4], querys[5], querys[6],
														 querys[7], querys[8], querys[9],querys[10], querys[11], querys[12], querys[13], 
														 querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], 
														 querys[21], querys[22], querys[23], querys[24], infoUsu.getUname(),pstm, connBD);
					
			
			if(rs !=null)
			{
				while(rs.next())
				{
					polizaCompleta.setFolio_poliza(rs.getString("folio_poliza"));
					polizaCompleta.setFecha_poliza(rs.getString("fecha_poliza"));
					break;
				}
			}
			
			if(polizaCompleta.getFecha_poliza() != null)
			{
				querys = Cls_Querys.LimpiaListaQuerys(querys);	
				querys = Cls_Querys.ObtieneQuerys(78, ListaQuerys, querys, infoUsu);
				querys = InicializaQueryNumero78(querys,polizaCompleta.getFecha_poliza(), infoUsu, uname_br_consulta);
				pstm = connBD.prepareStatement("{call " + "CTRL_INGRESOS.usp_EXECUTE_QUERY(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
				ResultSet rs3= EjecutaQuerysBD.EjecutarQuery(querys[0], querys[1],querys[2], querys[3], querys[4], querys[5], querys[6],
															 querys[7], querys[8], querys[9],querys[10], querys[11], querys[12], querys[13], 
															 querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], 
															 querys[21], querys[22], querys[23], querys[24], infoUsu.getUname(),pstm, connBD);	
			
				querys = Cls_Querys.LimpiaListaQuerys(querys);	
				querys = Cls_Querys.ObtieneQuerys(83, ListaQuerys, querys, infoUsu);
				querys = InicializaQueryNumero83(querys,polizaCompleta.getFolio_poliza(),infoUsu, uname_br_consulta);
				pstm = connBD.prepareStatement("{call " + "CTRL_INGRESOS.usp_EXECUTE_QUERY(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
				ResultSet rs4= EjecutaQuerysBD.EjecutarQuery(querys[0], querys[1],querys[2], querys[3], querys[4], querys[5], querys[6],
															 querys[7], querys[8], querys[9],querys[10], querys[11], querys[12], querys[13], 
															 querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], 
															 querys[21], querys[22], querys[23], querys[24], infoUsu.getUname(),pstm, connBD);	
				
				querys = Cls_Querys.LimpiaListaQuerys(querys);	
				querys = Cls_Querys.ObtieneQuerys(90, ListaQuerys, querys, infoUsu);
				querys = InicializaQueryNumero90(querys, infoUsu, polizaCompleta.getFecha_poliza(),uname_br_consulta);
				pstm = connBD.prepareStatement("{call " + "CTRL_INGRESOS.usp_EXECUTE_QUERY(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
				ResultSet rs5= EjecutaQuerysBD.EjecutarQuery(querys[0], querys[1],querys[2], querys[3], querys[4], querys[5], querys[6],
															 querys[7], querys[8], querys[9],querys[10], querys[11], querys[12], querys[13], 
															 querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], 
															 querys[21], querys[22], querys[23], querys[24], infoUsu.getUname(),pstm, connBD);
			
				querys = Cls_Querys.LimpiaListaQuerys(querys);	
				querys = Cls_Querys.ObtieneQuerys(93, ListaQuerys, querys,infoUsu);
				querys = InicializaQueryNumero93(querys, infoUsu, polizaCompleta.getFecha_poliza(), uname_br_consulta);	
			
				pstm = connBD.prepareStatement("{call " + "CTRL_INGRESOS.usp_EXECUTE_QUERY(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
				ResultSet rs6= EjecutaQuerysBD.EjecutarQuery(querys[0], querys[1],querys[2], querys[3], querys[4], querys[5], querys[6],
															 querys[7], querys[8], querys[9],querys[10], querys[11], querys[12], querys[13], 
															 querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], 
															 querys[21], querys[22], querys[23], querys[24], infoUsu.getUname(),pstm, connBD);
				
				/*querys = Cls_Querys.LimpiaListaQuerys(querys);	
				querys = Cls_Querys.ObtieneQuerys(97, ListaQuerys, querys,infoUsu);		
				querys = InicializaQueryNumero97(querys, infoUsu, polizaCompleta.getFolio_poliza());
				pstm = connBD.prepareStatement("{call " + "CTRL_INGRESOS.usp_EXECUTE_QUERY(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
				ResultSet rs7= EjecutaQuerysBD.EjecutarQuery(querys[0], querys[1],querys[2], querys[3], querys[4], querys[5], querys[6],
															 querys[7], querys[8], querys[9],querys[10], querys[11], querys[12], querys[13], 
															 querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], 
															 querys[21], querys[22], querys[23], querys[24], infoUsu.getUname(),pstm, connBD);
				*/
				if(rs !=null)
				{
					polizaCompleta.setListaPolDiaTipoEgreso(llenaClasePolDiaEgresos(rs,infoUsu));
					polizaCompleta.setListaPolDiaOtrosIngresos(llenaClasePolDiaOtrosIngresos(rs, infoUsu));
					polizaCompleta.setListaPolDiaTipoIngreso(llenaClasePolDiaTipoIngresos(rs, infoUsu));
					polizaCompleta.setListaPolDiaBancoIngresos(llenaClasePolDiaBancosIngreso(rs, infoUsu));
					polizaCompleta.setTotal_polizaIngresos(obtieneTotalIngresosDePoliza(polizaCompleta.getListaPolDiaTipoIngreso()));
					polizaCompleta.setTotal_polizaEgresos(obtieneTotalEgresosDePoliza( polizaCompleta.getListaPolDiaTipoEgreso()));
					
				}
				
				if(rs3 !=null)
				{
					polizaCompleta.setListaRecoleccionValores(llenaClaseRecoleccionValores(rs3,infoUsu));
				}
				
				if(rs4 !=null)
				{
					polizaCompleta.setTransito_pendiente("0.00");
					polizaCompleta.setTransito_aplicado("0.00");
					polizaCompleta.setAjusteMasCheque("0.00");
					polizaCompleta.setAjusteMenosCheque("0.00");
					while(rs4.next())
					{
						if(rs4.getString("id_tipo_ingreso").equals("97"))
						{
							double impAjusteCheque =  rs4.getDouble("importe");
							if(impAjusteCheque > 0)
							{
								polizaCompleta.setAjusteMasCheque(String.valueOf(impAjusteCheque));
							}
							else if(impAjusteCheque < 0)
							{
								polizaCompleta.setAjusteMenosCheque(String.valueOf(impAjusteCheque));
							}								 
						}
						else if(rs4.getString("id_tipo_ingreso").equals("98"))
						{
							polizaCompleta.setTransito_pendiente(formatoDecimal.format(rs4.getDouble("importe")));
						}
						else if(rs4.getString("id_tipo_ingreso").equals("99"))
						{
							polizaCompleta.setTransito_aplicado(formatoDecimal.format(rs4.getDouble("importe")));
						}					
					}
				}
				
				if(rs5 !=null)
				{
					polizaCompleta.setListafichasBancarias(llenarClaseFichasBancarias(rs5, infoUsu));
				}
				
				if(rs6 !=null)
				{
					polizaCompleta.setListafichasBancariasEgresos(llenarClaseFichasBancariasEgresos(rs6, infoUsu));
				}
				
				/*if(rs7 !=null)
				{
					polizaCompleta.setPolizaContable(llenarClasePolizaContable(rs7, infoUsu));
				}*/
			}
			Cls_Log.insertaLog(infoUsu, "", "", " Consulta cortes de Poliza: [Fecha:" + fechaCortePoliza + ", Folio:" + folioCortePoliza+" ]");
		}
		catch(Exception ex)
		{
			String sError= ex.getMessage().toString();
			Cls_Log.insertaLog(infoUsu, "", "", "Error al consultar los egresos: [" + sError + "]");
		}
		finally
		{
			try {connBD.close();} catch (SQLException e) {e.printStackTrace();}
			try {pstm.close();} catch (SQLException e) {e.printStackTrace();}
		}
		return polizaCompleta;
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
				ficha.setImporte(formatoDecimal.format(rs.getDouble(("importe"))));
				ficha.setAcumulado(formatoDecimal.format(rs.getDouble(("acum"))));
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
				if(rs.getString("pol_egreso").toString().equals("*"))
				{
					PolizaDiaTipoEgreso polEgresos= new PolizaDiaTipoEgreso();
					polEgresos.setTipo_egreso(rs.getInt("pol_id_tipo_egreso"));
					polEgresos.setNombre_tipo_egreso(rs.getString("pol_nombre_tipo_egreso").toUpperCase());
					polEgresos.setImporte_efectivo(formatoDecimal.format(rs.getDouble("pol_egreso_efectivo")));
					polEgresos.setImporte_cheque(formatoDecimal.format(rs.getDouble("pol_egreso_cheque")));
					polEgresos.setImporte_tCredito(formatoDecimal.format(rs.getDouble("pol_egreso_TCredito")));
					polEgresos.setImporte_tDebito(formatoDecimal.format(rs.getDouble("pol_egreso_TDebito")));
					polEgresos.setImporte_transferencia(formatoDecimal.format(rs.getDouble("pol_egreso_transferencia")));
					polEgresos.setImporte_posfechado( formatoDecimal.format(rs.getDouble("pol_egreso_posfechado")));
					polEgresos.setCve_banco(rs.getString("cve_banco_deposito_egreso"));
					polEgresos.setNombre_banco(rs.getString("banco_egreso"));
					listaPolDiaEgresos.add(polEgresos);
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
				if(rs.getString("pol_otros").toString().equals("*"))
				{
					PolizaDiaOtrosIngresos polOtroIngreso= new PolizaDiaOtrosIngresos();
					polOtroIngreso.setId_otro_ingreso(rs.getInt("pol_id_tipo_otros"));
					polOtroIngreso.setNombre_otro_ingreso(rs.getString("pol_nombre_tipo_otros").toUpperCase());
					polOtroIngreso.setImporte_efectivo(formatoDecimal.format(rs.getDouble("pol_otros_efectivo")));
					polOtroIngreso.setImporte_cheque(formatoDecimal.format(rs.getDouble("pol_otros_cheque")));
					polOtroIngreso.setImporte_tCredito(formatoDecimal.format(rs.getDouble("pol_otros_TCredito")));
					polOtroIngreso.setImporte_tDebito(formatoDecimal.format(rs.getDouble("pol_otros_TDebito")));
					polOtroIngreso.setImporte_transferencia(formatoDecimal.format(rs.getDouble("pol_otros_transferencia")));
					polOtroIngreso.setImporte_posfechado(formatoDecimal.format(rs.getDouble("pol_otros_posfechado")));
					listaPolDiaOtrosIngreso.add(polOtroIngreso);
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
				if(rs.getString("pol_tipo").toString().equals("*"))
				{
					if(rs.getInt("pol_id_tipo_ingreso") == 4)
					{
						polTipoIngresoOtro.setTipo_pago(rs.getInt("pol_id_tipo_ingreso"));
						polTipoIngresoOtro.setNombre_tipo_pago(rs.getString("pol_nombre_tipo_ingreso").toUpperCase());
						polTipoIngresoOtro.setImporte_efectivo(formatoDecimal.format(rs.getDouble("pol_tipo_efectivo")));
						polTipoIngresoOtro.setImporte_cheque(formatoDecimal.format(rs.getDouble("pol_tipo_cheque")));
						polTipoIngresoOtro.setImporte_tCredito(formatoDecimal.format(rs.getDouble("pol_tipo_TCredito")));
						polTipoIngresoOtro.setImporte_tDebito(formatoDecimal.format(rs.getDouble("pol_tipo_TDebito")));
						polTipoIngresoOtro.setImporte_transferencia(formatoDecimal.format(rs.getDouble("pol_tipo_transferencia")));
						polTipoIngresoOtro.setImporte_posfechado(formatoDecimal.format(rs.getDouble("pol_tipo_posfechado")));						
					}
					else
					{
						PolizaDiaTipoIngreso polTipoIngreso= new PolizaDiaTipoIngreso();
						polTipoIngreso.setTipo_pago(rs.getInt("pol_id_tipo_ingreso"));
						polTipoIngreso.setNombre_tipo_pago(rs.getString("pol_nombre_tipo_ingreso").toUpperCase());
						polTipoIngreso.setImporte_efectivo(formatoDecimal.format(rs.getDouble("pol_tipo_efectivo")));
						polTipoIngreso.setImporte_cheque(formatoDecimal.format(rs.getDouble("pol_tipo_cheque")));
						polTipoIngreso.setImporte_tCredito(formatoDecimal.format(rs.getDouble("pol_tipo_TCredito")));
						polTipoIngreso.setImporte_tDebito(formatoDecimal.format(rs.getDouble("pol_tipo_TDebito")));
						polTipoIngreso.setImporte_transferencia(formatoDecimal.format(rs.getDouble("pol_tipo_transferencia")));
						polTipoIngreso.setImporte_posfechado(formatoDecimal.format(rs.getDouble("pol_tipo_posfechado")));						
						listaPolDiaTipoIngreso.add(polTipoIngreso);
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
				if(rs.getString("pol_bancos").toString().equals("*"))
				{
					efectivo  = efectivo + Double.parseDouble(rs.getString("pol_banco_efectivo"));
					PolizaDiaBancosIngresos polBanco= new PolizaDiaBancosIngresos();
					polBanco.setCve_banco(rs.getInt("pol_cve_banco_ingreso"));
					polBanco.setNombre_banco(rs.getString("pol_nombre_banco_ingresos"));
					polBanco.setImporte_cheque(formatoDecimal.format(rs.getDouble("pol_banco_cheque")));
					polBanco.setImporte_tCredito(formatoDecimal.format(rs.getDouble("pol_banco_TCredito")));
					polBanco.setImporte_tDebito(formatoDecimal.format(rs.getDouble("pol_banco_TDebito")));
					polBanco.setImporte_transferencia(formatoDecimal.format(rs.getDouble("pol_banco_transferencia")));
					polBanco.setImporte_posfechado(formatoDecimal.format(rs.getDouble("pol_banco_posfechado")));
					polBanco.setImporte_efectivo("0.00");
					listaPolDiaBancos.add(polBanco);
				}	
			}
			
			for(PolizaDiaBancosIngresos ban : listaPolDiaBancos)
			{
				if(String.valueOf(ban.getCve_banco()).equals("1"))
				{
					ban.setImporte_efectivo(formatoDecimal.format(efectivo));
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
	
	public String obtieneTotalIngresosDePoliza( List<PolizaDiaTipoIngreso> listaPolizaITipo)
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
		DecimalFormat formatoDecimal = new DecimalFormat("#.##");		
		return String.valueOf(formatoDecimal.format(totalPoliza));
	}
		
	public String obtieneTotalEgresosDePoliza( List<PolizaDiaTipoEgreso> listaPolizaEgreso)
	{
		double totalPoliza = 0;		
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
				polValor.setImporte(formatoDecimal.format(rs.getDouble("importe")));
				listaPolValores.add(polValor);
			}
		}
		catch(Exception ex)
		{
			Cls_Log.insertaLog(infoUsu, "", "", "Error al llenar clase poliza recoleccion de valores: [" +ex.getMessage().toString() + "]");
		}
		return listaPolValores;
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
				ficha.setImporte(formatoDecimal.format(rs.getDouble(("importe"))));
				ficha.setAcumulado(formatoDecimal.format(rs.getDouble(("acum"))));
				listaFichasBancarias.add(ficha);
			}				
		}
		catch(Exception ex)
		{
			Cls_Log.insertaLog(infoUsu, "", "", "Error al llenar clase fichas bancarias [" +ex.getMessage().toString() + "]");
		}
		return listaFichasBancarias;
	}
		
	private List<PolizaContable> llenarClasePolizaContable(ResultSet rs, Usuario infoUsu)
	{
		List<PolizaContable> listaPolizaContable=new ArrayList<>();
		try
		{
			rs.beforeFirst();
			while(rs.next())
			{				
				PolizaContable polCont= new PolizaContable();
				polCont.setDescripcion_contable(rs.getString("descripcion_tracon"));
				polCont.setImporte_total(formatoDecimal.format(rs.getDouble("importe_tot")));
				listaPolizaContable.add(polCont);
			}				
		}
		catch(Exception ex)
		{
			Cls_Log.insertaLog(infoUsu, "", "", "Error al llenar clase poliza contable [" +ex.getMessage().toString() + "]");
		}
		return listaPolizaContable;
	}
	
	
	/**** CONSULTA CORTES DE PANAMERICANO  ****/	
	public CortePanamericano consultarCortesDePanamericanoEnBD(Usuario infoUsu, List<Querys> ListaQuerys, String fechaCortePanamericano, String folioCortePanamericano, String uname_br_consulta)
	{
		CortePanamericano cortePanamericano =new CortePanamericano();
		Connection connBD = null;
		PreparedStatement pstm= null;		
		connBD = ConexionBD.AbrirConexionBD(infoUsu.getUname());
		try
		{
			String[] querys = new String[25];	
			querys = Cls_Querys.LimpiaListaQuerys(querys);	
			querys = Cls_Querys.ObtieneQuerys(80, ListaQuerys, querys, infoUsu);
			querys = InicializaQueryNumero80(querys, infoUsu, folioCortePanamericano, fechaCortePanamericano, uname_br_consulta);
		
			pstm = connBD.prepareStatement("{call " + "CTRL_INGRESOS.usp_EXECUTE_QUERY(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			ResultSet rs= EjecutaQuerysBD.EjecutarQuery(querys[0], querys[1],querys[2], querys[3], querys[4], querys[5], querys[6],
														 querys[7], querys[8], querys[9],querys[10], querys[11], querys[12], querys[13], 
														 querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], 
														 querys[21], querys[22], querys[23], querys[24], infoUsu.getUname(),pstm, connBD);
			if(rs !=null)
			{
				while(rs.next())
				{
					String[] arrayFecha = rs.getString("fecha_pro").split("-");
					String fechaPro =  arrayFecha[2] + "/" + arrayFecha[1] + "/" + arrayFecha[0];
					
					cortePanamericano.setFolio_panamericano(rs.getInt("folio_panamericano"));
					cortePanamericano.setPapeleta(rs.getString("papeleta"));
					cortePanamericano.setPlomo(rs.getString("plomo"));	
					cortePanamericano.setFecha_pro(fechaPro);
					cortePanamericano.setHora_pro(rs.getString("hora_pro"));
					String importe= crearVariableSessionParaFichaBancaria(rs.getString("importe"));					
					cortePanamericano.setImporte(importe);
				}
			}
		
			Cls_Log.insertaLog(infoUsu, "", "", " Consulta cortes de Panamericano: [Fecha:" + fechaCortePanamericano + ", Folio:" + folioCortePanamericano+" ]");
		}
		catch(Exception ex)
		{
			String sError= ex.getMessage().toString();
			Cls_Log.insertaLog(infoUsu, "", "", "Error al consultar los egresos: [" + sError + "]");
		}
		finally
		{
			try {connBD.close();} catch (SQLException e) {e.printStackTrace();}
			try {pstm.close();} catch (SQLException e) {e.printStackTrace();}
		}
		return cortePanamericano;
	}

	public String crearVariableSessionParaFichaBancaria(String importeECorte)
	{
		DecimalFormat formatoDecimal = new DecimalFormat("#,###.00");
		double importeCP = Double.parseDouble(importeECorte);
		importeECorte = formatoDecimal.format(importeCP);
		
		String listaImporteEfectivo = "";
		String importeEfectivo = importeECorte;
		importeEfectivo= importeEfectivo.replace("$", "").replace(" ", "");
		for(String numero : importeEfectivo.split(""))
		    listaImporteEfectivo += numero + "/" ;
	
		listaImporteEfectivo = listaImporteEfectivo.substring(0, listaImporteEfectivo.length()-1);
		return listaImporteEfectivo;
	}
	
	
	/**** INICIALIZA LOS QUERYS DE EGRESOS ****/	
	private String[] InicializaQueryNumero29(String[] ListaQuerys, Usuario infoUsu, String folioCorte, String fechaCorte, String origen, String uname_br_consulta) 
	{
		String str_fecha="";
		String str_folio="";
		String str_folio_corte_caja="";
		String uname_br = (uname_br_consulta.equals("0") || uname_br_consulta.equals("undefined")) ? infoUsu.getUname_br() : uname_br_consulta;
		if(origen.equals("1"))
		{
			str_fecha = " AND A.fecha_pro ='" +generaSetenciaFecha(fechaCorte)+"'" ;
		}
		
		if(!folioCorte.trim().equals("0"))
		{
			str_fecha = "";
			str_folio=" AND A.folio_corte_caja = '" + folioCorte.trim() + "'";
			str_folio_corte_caja=" AND folio_corte = '" + folioCorte.trim() +" '";
		}
		
		for (int i=0;i <ListaQuerys.length; i++)
		{
			ListaQuerys[i]= ListaQuerys[i].replace("{FOLIO_CORTE}", str_folio);
			ListaQuerys[i]= ListaQuerys[i].replace("{FECHA_CORTE}", str_fecha);	
			ListaQuerys[i]= ListaQuerys[i].replace("{FOLIO_CORTE_CAJA}", str_folio_corte_caja);
			ListaQuerys[i]= ListaQuerys[i].replace("{UNAME_CONSULTA}", uname_br);
			
		}
		return ListaQuerys;
	}
	
	private String[] InicializaQueryNumero77(String[] ListaQuerys, Usuario infoUsu, String folioCortePoliza, String fechaCortePoliza, String uname_br_consulta) 
	{
		String str_fecha="";
		String str_folio="";
		
		if(!folioCortePoliza.trim().equals("0"))
		{
			str_fecha = "";
			str_folio=" AND folio_poliza = '" + folioCortePoliza.trim() + "'";
		}
		else
		{
			str_fecha = " AND fecha_pro  ='" +generaSetenciaFecha(fechaCortePoliza)+"'" ;
		}
				
		String uname_br = (uname_br_consulta.equals("0") || uname_br_consulta.equals("undefined")) ? infoUsu.getUname_br() : uname_br_consulta;
		for (int i=0;i <ListaQuerys.length; i++)
		{
			ListaQuerys[i]= ListaQuerys[i].replace("{FOLIO_POLIZA}", str_folio);
			ListaQuerys[i]= ListaQuerys[i].replace("{FECHA_POLIZA}", str_fecha);
			ListaQuerys[i]= ListaQuerys[i].replace("{UNAME_CONSULTA}", uname_br);
		}
		return ListaQuerys;
	}
	
	private String[] InicializaQueryNumero80(String[] ListaQuerys, Usuario infoUsu, String folioCortePanamericano, String fechaCortePanamericano, String uname_br_consulta) 
	{
		String str_fecha="";
		String str_folio="";
		
		if(!folioCortePanamericano.trim().equals("0"))
		{
			str_fecha = "";
			str_folio=" folio_panamericano = '" + folioCortePanamericano.trim() + "'";
		}
		else
		{
			str_fecha = " fecha_pro  ='" +generaSetenciaFecha(fechaCortePanamericano)+"'" ;
		}
		
		String uname_br = (uname_br_consulta.equals("0") || uname_br_consulta.equals("undefined")) ? infoUsu.getUname_br() : uname_br_consulta;
				
		for (int i=0;i <ListaQuerys.length; i++)
		{
			ListaQuerys[i]= ListaQuerys[i].replace("{FOLIO_PANAMERICANO}", str_folio);
			ListaQuerys[i]= ListaQuerys[i].replace("{FECHA_PANAMERICANO}", str_fecha);
			ListaQuerys[i]= ListaQuerys[i].replace("{UNAME_CONSULTA}", uname_br);
		}
		return ListaQuerys;
	}
		
	private String[] InicializaQueryNumero78(String[] ListaQuerys,String  fechaPoliza,Usuario infoUsu, String uname_br_consulta) 
	{		
		String uname_br = (uname_br_consulta.equals("0") || uname_br_consulta.equals("undefined")) ? infoUsu.getUname_br() : uname_br_consulta;
		
		for (int i=0;i <ListaQuerys.length; i++)
		{
			ListaQuerys[i]= ListaQuerys[i].replace("{FECHA_PANAMERICANO}"," AND fecha_poliza ='" +fechaPoliza+ "'" );
			ListaQuerys[i]= ListaQuerys[i].replace("{UNAME_CONSULTA}", uname_br);
		}
		return ListaQuerys;
	}
	
	private String[] InicializaQueryNumero83(String[] ListaQuerys,String  folio_poliza ,Usuario infoUsu, String uname_br_consulta) 
	{		
		String uname_br = (uname_br_consulta.equals("0") || uname_br_consulta.equals("undefined")) ? infoUsu.getUname_br() : uname_br_consulta;
		for (int i=0;i <ListaQuerys.length; i++)
		{
			ListaQuerys[i]= ListaQuerys[i].replace("{FOLIO_POLIZA}" , folio_poliza );
			ListaQuerys[i]= ListaQuerys[i].replace("{UNAME_CONSULTA}", uname_br);
		}
		return ListaQuerys;
	}
	
	private String[] InicializaQueryNumero90(String[] ListaQuerys, Usuario infoUsu, String fecha_poliza, String uname_br_consulta) 
	{		
		String uname_br = (uname_br_consulta.equals("0") || uname_br_consulta.equals("undefined")) ? infoUsu.getUname_br() : uname_br_consulta;
		for (int i=0;i <ListaQuerys.length; i++)
		{
			ListaQuerys[i]= ListaQuerys[i].replace("{FECHA_POLIZA}", "'" + fecha_poliza + "'");		
			ListaQuerys[i]= ListaQuerys[i].replace("{ESTATUS}", "2");
			ListaQuerys[i]= ListaQuerys[i].replace("{UNAME_CONSULTA}", uname_br);
		}
		return ListaQuerys;
	}
	
	private String[] InicializaQueryNumero93(String[] ListaQuerys, Usuario infoUsu, String fecha_poliza,  String uname_br_consulta) 
	{		
		String uname_br = (uname_br_consulta.equals("0") || uname_br_consulta.equals("undefined")) ? infoUsu.getUname_br() : uname_br_consulta;
		for (int i=0;i <ListaQuerys.length; i++)
		{
			ListaQuerys[i]= ListaQuerys[i].replace("{FECHA_POLIZA}", "'" + fecha_poliza + "'");		
			ListaQuerys[i]= ListaQuerys[i].replace("{ESTATUS}", "5");
			ListaQuerys[i]= ListaQuerys[i].replace("{UNAME_CONSULTA}", uname_br);
		}
		return ListaQuerys;
	}
	
	private String[] InicializaQueryNumero97(String[] ListaQuerys, Usuario infoUsu, String folioPoliza) 
	{		
		for (int i=0;i <ListaQuerys.length; i++)
		{
			ListaQuerys[i]= ListaQuerys[i].replace("{FOLIO_POLIZA}", folioPoliza);		
		}
		return ListaQuerys;
	}
	
	private int obtenerBancoParaHRyConXCDO(String uname_br)
	{
		int banco = 0;
		switch(uname_br)
		{
			case "cdf":
				banco=3;
				break;
		}		
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
