package cdo.Persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.poi.hssf.record.PageBreakRecord.Break;

import cdo.Datos.Catalogo_Bancos;
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

public class GestorCortePoliza 
{	
	DecimalFormat formatoDecimal = new DecimalFormat("#,###.00");
	DateTimeFormatter df = DateTimeFormatter.ofPattern("dd/MM/yyyy"); 
	
	/****  CONSULTA SI YA FUE GENERADA LA POLIZA DE DIA  ****/
	public String  validarSiExistenPolizaDelDiaGenerada(Usuario infoUsu, List<Querys> ListaQuerys)
	{
		String existePoliza = "";
		String strQry = "";
		Connection connBD = null;
		PreparedStatement pstm= null;		
		connBD = ConexionBD.AbrirConexionBD(infoUsu.getUname());
		try
		{
			String[] querys = new String[25];	
			querys = Cls_Querys.LimpiaListaQuerys(querys);	
			querys = Cls_Querys.ObtieneQuerys(799, ListaQuerys, querys, infoUsu);
			strQry = Cls_MetodosGlobales.obtieneSentenciaDeQrys(querys);
			pstm = connBD.prepareStatement("{call " + "CTRL_INGRESOS.usp_EXECUTE_QUERY(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			System.out.println(querys[0]);
			System.out.println(querys[1]);
			System.out.println(querys[2]);
			System.out.println(querys[3]);
			System.out.println(querys[4]);
			System.out.println(querys[5]);
			System.out.println(querys[6]);
			System.out.println(querys[7]);
			System.out.println(querys[8]);
			System.out.println(querys[9]);
			System.out.println(querys[10]);
			System.out.println(querys[11]);
			System.out.println(querys[12]);
			System.out.println(querys[13]);
			System.out.println(querys[14]);
			System.out.println(querys[15]);
			System.out.println(querys[16]);
			System.out.println(querys[17]);
			System.out.println(querys[18]);
			System.out.println(querys[19]);
			System.out.println(querys[20]);
			System.out.println(querys[21]);
			System.out.println(querys[22]);
			System.out.println(querys[23]);
			System.out.println(querys[24]);
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
							existePoliza =  "¡Ya fue generada una Poliza Del Dia! [ Folio Poliza:"  + rs.getString("folio_poliza") + ", Fecha Poliza:" + rs.getString("fecha_poliza") +"]  "   + "   QUERYS-79[" + strQry + "]";
							break;
						}
					}
					/*else if(rs.getString("tipo").equals("EGRESO_SIN_TRANS"))
					{
						if(rs.getInt("polizas_generadas") > 0)
						{
							existePoliza = "EGRESO_SIN_TRANS";
							break;
						}
					}	*/				
				}
			}
		}
		catch(Exception ex)
		{
			String sError= ex.getMessage().toString();
			Cls_Log.insertaLog(infoUsu, "", "", "Error al consultar la poliza del dia actual : [" + sError + "]    "    + "   QUERYS-79[" + strQry + "]");
		}
		finally
		{
			try {connBD.close();} catch (SQLException e) {e.printStackTrace();}
			try {pstm.close();} catch (SQLException e) {e.printStackTrace();}
		}
		return existePoliza;
	}
			
	/****  CONSULTA POLIZA DEL DIA ACTUAL ****/
	public PolizaCompleta consultaPolizaDelDiaActual(Usuario infoUsu, List<Querys> ListaQuerys,HttpSession session)
	{
		PolizaCompleta polizaCompleta = new PolizaCompleta();
		String strQry = "";
		Connection connBD = null;
		PreparedStatement pstm= null;		
		connBD = ConexionBD.AbrirConexionBD(infoUsu.getUname());
		try
		{
			String[] querys = new String[25];	
			querys = Cls_Querys.LimpiaListaQuerys(querys);	
			querys = Cls_Querys.ObtieneQuerys(744, ListaQuerys, querys, infoUsu);/*POLIZA DINAMICA*/
			querys = InicializaQueryNumero74(querys, infoUsu);
			strQry = Cls_MetodosGlobales.obtieneSentenciaDeQrys(querys);
			pstm = connBD.prepareStatement("{call " + "CTRL_INGRESOS.usp_EXECUTE_QUERY(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			ResultSet rs1= EjecutaQuerysBD.EjecutarQuery(querys[0], querys[1],querys[2], querys[3], querys[4], querys[5], querys[6],
														 querys[7], querys[8], querys[9],querys[10], querys[11], querys[12], querys[13], 
														 querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], 
														 querys[21], querys[22], querys[23], querys[24], infoUsu.getUname(),pstm, connBD);
			
			Cls_Log.insertaLog(infoUsu, "", "", " Consulta Poliza Del Dia Actual.   "      + "   QUERYS-74[" + strQry + "]");
			
			
			querys = Cls_Querys.LimpiaListaQuerys(querys);	
			querys = Cls_Querys.ObtieneQuerys(755, ListaQuerys, querys, infoUsu);/*POLIZA DINAMICA*/	
			strQry = Cls_MetodosGlobales.obtieneSentenciaDeQrys(querys);
			pstm = connBD.prepareStatement("{call " + "CTRL_INGRESOS.usp_EXECUTE_QUERY(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			ResultSet rs2= EjecutaQuerysBD.EjecutarQuery(querys[0], querys[1],querys[2], querys[3], querys[4], querys[5], querys[6],
														 querys[7], querys[8], querys[9],querys[10], querys[11], querys[12], querys[13], 
														 querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], 
														 querys[21], querys[22], querys[23], querys[24], infoUsu.getUname(),pstm, connBD);	
			
			Cls_Log.insertaLog(infoUsu, "", "", " Consulta Poliza Del Dia Actual.   "      + "   QUERYS-75[" + strQry + "]");
			
			
			querys = Cls_Querys.LimpiaListaQuerys(querys);	
			querys = Cls_Querys.ObtieneQuerys(788, ListaQuerys, querys, infoUsu);/*POLIZA DINAMICA*/
			querys = InicializaQueryNumero78(querys, infoUsu);
			strQry = Cls_MetodosGlobales.obtieneSentenciaDeQrys(querys);
			pstm = connBD.prepareStatement("{call " + "CTRL_INGRESOS.usp_EXECUTE_QUERY(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			ResultSet rs3= EjecutaQuerysBD.EjecutarQuery(querys[0], querys[1],querys[2], querys[3], querys[4], querys[5], querys[6],
														 querys[7], querys[8], querys[9],querys[10], querys[11], querys[12], querys[13], 
														 querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], 
														 querys[21], querys[22], querys[23], querys[24], infoUsu.getUname(),pstm, connBD);
			
			
			Cls_Log.insertaLog(infoUsu, "", "", " Consulta Poliza Del Dia Actual.   "      + "   QUERYS-78[" + strQry + "]");
			
			
			querys = Cls_Querys.LimpiaListaQuerys(querys);	
			querys = Cls_Querys.ObtieneQuerys(822, ListaQuerys, querys, infoUsu);/*POLIZA DINAMICA*/
			strQry = Cls_MetodosGlobales.obtieneSentenciaDeQrys(querys);
			pstm = connBD.prepareStatement("{call " + "CTRL_INGRESOS.usp_EXECUTE_QUERY(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			ResultSet rs4= EjecutaQuerysBD.EjecutarQuery(querys[0], querys[1],querys[2], querys[3], querys[4], querys[5], querys[6],
														 querys[7], querys[8], querys[9],querys[10], querys[11], querys[12], querys[13], 
														 querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], 
														 querys[21], querys[22], querys[23], querys[24], infoUsu.getUname(),pstm, connBD);	
			
			Cls_Log.insertaLog(infoUsu, "", "", " Consulta Poliza Del Dia Actual.   "      + "   QUERYS-82[" + strQry + "]");
			
			
			querys = Cls_Querys.LimpiaListaQuerys(querys);	
			querys = Cls_Querys.ObtieneQuerys(900, ListaQuerys, querys, infoUsu);/*POLIZA DINAMICA*/
			querys = InicializaQueryNumero90(querys, infoUsu);
			strQry = Cls_MetodosGlobales.obtieneSentenciaDeQrys(querys);
			pstm = connBD.prepareStatement("{call " + "CTRL_INGRESOS.usp_EXECUTE_QUERY(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			ResultSet rs5= EjecutaQuerysBD.EjecutarQuery(querys[0], querys[1],querys[2], querys[3], querys[4], querys[5], querys[6],
														 querys[7], querys[8], querys[9],querys[10], querys[11], querys[12], querys[13], 
														 querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], 
														 querys[21], querys[22], querys[23], querys[24], infoUsu.getUname(),pstm, connBD);
			
			Cls_Log.insertaLog(infoUsu, "", "", " Consulta Poliza Del Dia Actual.   "      + "   QUERYS-90[" + strQry + "]");
			
			
			querys = Cls_Querys.LimpiaListaQuerys(querys);	
			querys = Cls_Querys.ObtieneQuerys(933, ListaQuerys, querys, infoUsu);/*POLIZA DINAMICA*/
			querys = InicializaQueryNumero93(querys, infoUsu);
			strQry = Cls_MetodosGlobales.obtieneSentenciaDeQrys(querys);
			pstm = connBD.prepareStatement("{call " + "CTRL_INGRESOS.usp_EXECUTE_QUERY(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			ResultSet rs6= EjecutaQuerysBD.EjecutarQuery(querys[0], querys[1],querys[2], querys[3], querys[4], querys[5], querys[6],
														 querys[7], querys[8], querys[9],querys[10], querys[11], querys[12], querys[13], 
														 querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], 
														 querys[21], querys[22], querys[23], querys[24], infoUsu.getUname(),pstm, connBD);
			
			Cls_Log.insertaLog(infoUsu, "", "", " Consulta Poliza Del Dia Actual.   "      + "   QUERYS-93[" + strQry + "]");
			
			
			querys = Cls_Querys.LimpiaListaQuerys(querys);	
			querys = Cls_Querys.ObtieneQuerys(1055, ListaQuerys, querys, infoUsu);/*POLIZA DINAMICA*/
			strQry = Cls_MetodosGlobales.obtieneSentenciaDeQrys(querys);
			pstm = connBD.prepareStatement("{call " + "CTRL_INGRESOS.usp_EXECUTE_QUERY(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			ResultSet rs7=EjecutaQuerysBD.EjecutarQuery(querys[0], querys[1],querys[2], querys[3], querys[4], querys[5], querys[6],
														 querys[7], querys[8], querys[9],querys[10], querys[11], querys[12], querys[13], 
														 querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], 
														 querys[21], querys[22], querys[23], querys[24], infoUsu.getUname(),pstm, connBD);
			
			Cls_Log.insertaLog(infoUsu, "", "", " Consulta Poliza Del Dia Actual.   "      + "   QUERYS-105[" + strQry + "]");
			
			
			polizaCompleta= llenaClasesDePolizaDelDia(rs1,rs2,rs3,rs4,rs5,rs6,rs7, infoUsu, session);
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
	
	/****  POLIZA CONTABLE ****/
	private List<PolizaContable> llenaClasePolizaContable(Usuario infoUsu, ResultSet rsFichasCH, ResultSet rsTransEgresos, ResultSet rsRecVal, 
														 ResultSet rsEgresosOtrosI, String transito, String transitoApli, ResultSet rsIngresos, HttpSession session)
	{
		List<PolizaContable> listaPolizaContable = new ArrayList<>();
		List<Catalogo_Bancos> listaBancos = new ArrayList<>();
		listaBancos = (List<Catalogo_Bancos>) session.getAttribute("listaBancos");
		
		try
		{
			rsEgresosOtrosI.beforeFirst();	
			rsIngresos.beforeFirst();
			
			/** RECOLECCION DE VALORES /  FICHAS BANCARIAS CHEQUES / TRANSACCIONES EGRESOS **/
			listaPolizaContable= llenaClasePolizaContableBancos(infoUsu, listaBancos, rsFichasCH, rsTransEgresos, rsRecVal, listaPolizaContable);
			
			/** NOMINA EGRESOS**/
			listaPolizaContable = llenaClasePolizaContableNominaEgresos(infoUsu, rsEgresosOtrosI, listaPolizaContable);
					
			
			/** TRANSITOS**/
			listaPolizaContable= llenaClasePolizaContableTransitos(infoUsu, transito, transitoApli, listaPolizaContable);
			
			/** TOTAL DE CLIENTES **/
			listaPolizaContable= llenaClasePolizaContableTotalClientes(infoUsu, rsIngresos, listaPolizaContable);
			
			/** OTROS INGRESOS **/
			listaPolizaContable= llenaClasePolizaContableOtrosIngresos(infoUsu, rsEgresosOtrosI, listaPolizaContable);
			
		}
		catch(Exception ex)
		{
			Cls_Log.insertaLog(infoUsu, "", "", "Error al llenar la clase de Poliza Contable : [" +ex.getMessage().toString() + "]");
		}
		return listaPolizaContable;
	}
	
	private List<PolizaContable> llenaClasePolizaContableBancos(Usuario infoUsu,List<Catalogo_Bancos> listaBancos,ResultSet rsFichasCH, ResultSet rsTransEgresos, ResultSet rsRecVal, List<PolizaContable> listaPolizaContable)
	{
		try
		{
			LocalDateTime now = LocalDateTime.now(); 
			
			for(int i=0; i < listaBancos.size() ; i++)
			{
				if(listaBancos.get(i).getDeposito().equals("1"))
				{
					rsFichasCH.beforeFirst();
					rsTransEgresos.beforeFirst();
					rsRecVal.beforeFirst();
					
					if(listaBancos.get(i).getNombre_banco().toString().equals("BANAMEX"))
					{
						if(rsRecVal != null)
						{
							while(rsRecVal.next())/** RECOLECCION DE VALORES **/
							{ 
								PolizaContable polContable = new PolizaContable();	
								polContable.setDescripcion_contable("COBRANZA DEL DIA " + df.format(now) + "-" + listaBancos.get(i).getNombre_banco().toString().toUpperCase()+ "-RECOLECCION VALORES");
								polContable.setImporte_total(rsRecVal.getString("importe"));
								listaPolizaContable.add(polContable);
							}
						}
					}
					
					if(rsFichasCH != null)
					{
						while(rsFichasCH.next())/** FICHAS BANCARIAS CHEQUES**/
						{ 
							if(listaBancos.get(i).getNombre_banco().equals(rsFichasCH.getString("nombre_banco")))
							{
								PolizaContable polContable = new PolizaContable();	
								polContable.setDescripcion_contable("COBRANZA DEL DIA " + df.format(now) + "-" + rsFichasCH.getString("nombre_banco").toUpperCase());
								polContable.setImporte_total(rsFichasCH.getString("importe"));
								listaPolizaContable.add(polContable);
							}
						}
					}
					
					if(rsTransEgresos != null)
					{
						while(rsTransEgresos.next())/** TRANSACCIONES EGRESOS **/
						{ 
							if(listaBancos.get(i).getNombre_banco().equals(rsTransEgresos.getString("nombre")))
							{
								PolizaContable polContable = new PolizaContable();	
								polContable.setDescripcion_contable("COBRANZA DEL DIA " + df.format(now) + "-" + rsTransEgresos.getString("nombre").toUpperCase());
								polContable.setImporte_total(rsTransEgresos.getString("importe"));
								listaPolizaContable.add(polContable);
							}
						}
					}
				}
			}
		}
		catch(Exception ex)
		{
			Cls_Log.insertaLog(infoUsu, "", "", "Error al llenar la clase de Poliza Contable -  Nomina Egresos : [" +ex.getMessage().toString() + "]");
		}
		return listaPolizaContable;
	}
	
	private List<PolizaContable> llenaClasePolizaContableNominaEgresos(Usuario infoUsu,ResultSet rsEgresosOtrosI, List<PolizaContable> listaPolizaContable)
	{
		try
		{
			if(rsEgresosOtrosI != null)
			{
				while(rsEgresosOtrosI.next())
				{				
					if(rsEgresosOtrosI.getString("tipo_poliza").equals("D"))
					{
						if(rsEgresosOtrosI.getString("pol_egresos").toString().equals("*"))
						{
							if(String.valueOf(rsEgresosOtrosI.getInt("pol_id_tipo_egresos")).equals("7"))
							{
								PolizaContable polContable = new PolizaContable();	
								polContable.setDescripcion_contable(rsEgresosOtrosI.getString("pol_nombre_egresos").toUpperCase());
								polContable.setImporte_total(rsEgresosOtrosI.getString("pol_egresos_efectivo"));
								listaPolizaContable.add(polContable);
							}
						}				
					}		
				}	
			}	
		}
		catch(Exception ex)
		{
			Cls_Log.insertaLog(infoUsu, "", "", "Error al llenar la clase de Poliza Contable -  Nomina Egresos : [" +ex.getMessage().toString() + "]");
		}
		return listaPolizaContable;
	}
		
	private List<PolizaContable> llenaClasePolizaContableTransitos(Usuario infoUsu, String transito, String transitoApli, List<PolizaContable> listaPolizaContable)
	{
		PolizaContable polContable = new PolizaContable();	
		polContable.setDescripcion_contable("TRANSITO");
		polContable.setImporte_total(transito);
		listaPolizaContable.add(polContable);
		
		polContable = new PolizaContable();	
		polContable.setDescripcion_contable("TRANSITO APLICADO");
		polContable.setImporte_total(transitoApli);
		listaPolizaContable.add(polContable);
		
		return listaPolizaContable;
	}
		
	private List<PolizaContable> llenaClasePolizaContableTotalClientes(Usuario infoUsu, ResultSet rsIngresos, List<PolizaContable> listaPolizaContable)
	{
		try
		{
			String  totalClientes="";
			if(rsIngresos != null)
			{
				double totalCte= 0;
				while(rsIngresos.next())
				{
					if(rsIngresos.getString("tipo_poliza").equals("D"))
					{
						if(rsIngresos.getString("pol_tipo").toString().equals("*"))
						{
							if(!String.valueOf(rsIngresos.getInt("pol_id_tipo_ingreso")).equals("4"))
							{
								totalCte = totalCte + (rsIngresos.getDouble("pol_tipo_efectivo") + rsIngresos.getDouble("pol_tipo_cheque"));
							}
						}
					}
				}
				totalClientes = String.valueOf(totalCte);
			}
			PolizaContable polContable = new PolizaContable();	
			polContable.setDescripcion_contable("TOTAL CLIENTES - CF-5017 R-731 COBRO COMPLEMENTO DE PAGO");
			polContable.setImporte_total(totalClientes);
			listaPolizaContable.add(polContable);
		}
		catch(Exception ex)
		{
			Cls_Log.insertaLog(infoUsu, "", "", "Error al llenar la clase de Poliza Contable - Total Clientes : [" +ex.getMessage().toString() + "]");
		}
		return listaPolizaContable;
	}
	
	private List<PolizaContable> llenaClasePolizaContableOtrosIngresos(Usuario infoUsu, ResultSet rsEgresosOtrosI ,List<PolizaContable> listaPolizaContable)
	{
		try
		{
			rsEgresosOtrosI.beforeFirst();
			if(rsEgresosOtrosI != null)
			{
				while(rsEgresosOtrosI.next())
				{				
					if(rsEgresosOtrosI.getString("tipo_poliza").equals("D"))
					{
						if(rsEgresosOtrosI.getString("pol_otros_ingresos").toString().equals("*"))
						{
								PolizaContable polContableOI = new PolizaContable();	
								polContableOI.setDescripcion_contable(rsEgresosOtrosI.getString("pol_nombre_otros_ingresos").toUpperCase());
								polContableOI.setImporte_total(rsEgresosOtrosI.getString("pol_otros_efectivo"));
								listaPolizaContable.add(polContableOI);
						}				
					}		
				}	
			}
		}
		catch(Exception ex)
		{
			Cls_Log.insertaLog(infoUsu, "", "", "Error al llenar la clase de Poliza Contable - Otros Ingresos : [" +ex.getMessage().toString() + "]");
		}
		return listaPolizaContable;
	}
		
	
	/****  GENERA POLIZA DEL DIA  ****/	
	public String  validaIngresosEgresosConFechaPolMenor(Usuario infoUsu, List<Querys> ListaQuerys)
	{
		String  fechasPolizaCorrectas= "";
		String strQry = "";
		Connection connBD = null;
		PreparedStatement pstm= null;		
		connBD = ConexionBD.AbrirConexionBD(infoUsu.getUname());
		try
		{
			String[] querys = new String[25];	
			querys = Cls_Querys.LimpiaListaQuerys(querys);	
			querys = Cls_Querys.ObtieneQuerys(944, ListaQuerys, querys, infoUsu);/*POLIZA DINAMICA*/	
			strQry = Cls_MetodosGlobales.obtieneSentenciaDeQrys(querys);
			pstm = connBD.prepareStatement("{call " + "CTRL_INGRESOS.usp_EXECUTE_QUERY(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");		
			ResultSet rs = EjecutaQuerysBD.EjecutarQuery(querys[0], querys[1],querys[2], querys[3], querys[4], querys[5], querys[6],					 
														 querys[7], querys[8], querys[9],querys[10], querys[11], querys[12], querys[13], 
														 querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], 
														 querys[21], querys[22], querys[23], querys[24], infoUsu.getUname(),pstm, connBD);
			if(rs != null)
			{
				while(rs.next())
				{
					if(rs.getInt("folio_caja") > 0)
					{
						fechasPolizaCorrectas = "El " + rs.getString("tipo") + "  [ Folio Caja: " + rs.getInt("folio_caja") +  " ]  tiene configurada una fecha de poliza menor a la del dia actual.";
						break;
					}
				}
			}
			if(!fechasPolizaCorrectas.equals(""))
			{
				Cls_Log.insertaLog(infoUsu, "", "", fechasPolizaCorrectas);
				
			}
			
		}
		catch(Exception ex)
		{
			Cls_Log.insertaLog(infoUsu, "", "", "Error al insertar la poliza del dia en BD: [" +ex.getMessage().toString() + "]");
		}
		finally
		{
			try {connBD.close();} catch (SQLException e) {e.printStackTrace();}
			try {pstm.close();} catch (SQLException e) {e.printStackTrace();}
		}	
		
		//fechasPolizaCorrectas="";/*POLIZA DINAMICA*/
		return fechasPolizaCorrectas;
	}
	
	public boolean generaPolizaDelDiaBD(Usuario infoUsu, List<Querys> ListaQuerys, PolizaCompleta polizaCompleta)
	{
		boolean insertoPolizaBD= false;
		String insertPolizaIXBanco = generaInsertXBancoIngresos(infoUsu, polizaCompleta.getListaPolDiaBancoIngresos());
		String insertPolizaIXTipoPago = generaInsertXTipoIngreso(infoUsu, polizaCompleta.getListaPolDiaTipoIngreso(), polizaCompleta.getTransito_pendiente(),polizaCompleta.getTransito_aplicado() ,polizaCompleta.getAjusteMasCheque(), polizaCompleta.getAjusteMenosCheque());
		String insertPolizaEXTipo = generaInsertXEgresos(infoUsu, polizaCompleta.getListaPolDiaTipoEgreso());
		String insertPolizaOI =  generaInsertXOtrosIngresos(infoUsu, polizaCompleta.getListaPolDiaOtrosIngresos());
		String importeTotalCorte = obtieneTotalDePoliza(polizaCompleta.getListaPolDiaTipoIngreso(), polizaCompleta.getListaPolDiaTipoEgreso());
		Connection connBD = null;
		PreparedStatement pstm= null;		
		connBD = ConexionBD.AbrirConexionBD(infoUsu.getUname());
		try
		{
			String[] querys = new String[25];	
			querys = Cls_Querys.LimpiaListaQuerys(querys);	
			querys = Cls_Querys.ObtieneQuerys(766, ListaQuerys, querys, infoUsu);/*POLIZA DINAMICA*/
			querys = InicializaQueryNumero76(querys, infoUsu,insertPolizaIXBanco, insertPolizaIXTipoPago, insertPolizaEXTipo, insertPolizaOI, importeTotalCorte);		
			pstm = connBD.prepareStatement("{call " + "CTRL_INGRESOS.usp_EXECUTE_QUERY(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			EjecutaQuerysBD.EjecutarQuery(querys[0], querys[1],querys[2], querys[3], querys[4], querys[5], querys[6],
														 querys[7], querys[8], querys[9],querys[10], querys[11], querys[12], querys[13], 
														 querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], 
														 querys[21], querys[22], querys[23], querys[24], infoUsu.getUname(),pstm, connBD);
			Cls_Log.insertaLog(infoUsu, "", "", " Genera e Imprime Poliza del Dia actual. [" +  polizaCompleta.getFolio_poliza() + "]");
			insertoPolizaBD = true;
		}
		catch(Exception ex)
		{
			Cls_Log.insertaLog(infoUsu, "", "", "Error al insertar la poliza del dia en BD: [" +ex.getMessage().toString() + "]");
		}
		finally
		{
			try {connBD.close();} catch (SQLException e) {e.printStackTrace();}
			try {pstm.close();} catch (SQLException e) {e.printStackTrace();}
		}	
		
		return insertoPolizaBD;
	}
	
	private String generaInsertXBancoIngresos(Usuario infoUsu, List<PolizaDiaBancosIngresos> listaPolizaIBancos)
	{
		String str_polIXBanco ="";
		if(listaPolizaIBancos.size() > 0)
		{
			for(PolizaDiaBancosIngresos IXBanco: listaPolizaIBancos)
			{
				double total= Double.parseDouble(IXBanco.getImporte_efectivo().replace(",", "")) + Double.parseDouble(IXBanco.getImporte_cheque().replace(",", ""))+
							  Double.parseDouble(IXBanco.getImporte_tCredito().replace(",", ""))+Double.parseDouble(IXBanco.getImporte_tDebito().replace(",", ""))+
							  Double.parseDouble(IXBanco.getImporte_transferencia().replace(",", ""));
							
				if(total > 0)
				{
					if(Double.parseDouble(IXBanco.getImporte_efectivo().replace(",", "")) > 0)
					{
						str_polIXBanco+= "('" + infoUsu.getUname().toLowerCase() + "','"+ infoUsu.getUname_br().toLowerCase() + "', @FOLIO ,'" + 
								IXBanco.getCve_banco() + "','1','"+ IXBanco.getImporte_efectivo().replace(",", "") + "',CURDATE(), CURTIME()),";
					}
					
					if(Double.parseDouble(IXBanco.getImporte_cheque().replace(",", "")) > 0)
					{
						str_polIXBanco+= "('" + infoUsu.getUname().toLowerCase() + "','"+ infoUsu.getUname_br().toLowerCase() + "', @FOLIO ,'" + 
								IXBanco.getCve_banco() + "','2','"+ IXBanco.getImporte_cheque().replace(",", "") + "',CURDATE(), CURTIME()),";
					}
					
					if(Double.parseDouble(IXBanco.getImporte_tCredito().replace(",", "")) > 0)
					{
						str_polIXBanco+= "('" + infoUsu.getUname().toLowerCase() + "','"+ infoUsu.getUname_br().toLowerCase() + "', @FOLIO ,'" + 
								IXBanco.getCve_banco() + "','4','"+ IXBanco.getImporte_tCredito().replace(",", "") + "',CURDATE(), CURTIME()),";
					}
					
					if(Double.parseDouble(IXBanco.getImporte_tDebito().replace(",", "")) > 0)
					{
						str_polIXBanco+= "('" + infoUsu.getUname().toLowerCase() + "','"+ infoUsu.getUname_br().toLowerCase() + "', @FOLIO ,'" + 
								IXBanco.getCve_banco() + "','28','"+ IXBanco.getImporte_tDebito().replace(",", "") + "',CURDATE(), CURTIME()),";
					}
					
					if(Double.parseDouble(IXBanco.getImporte_transferencia().replace(",", "")) > 0)
					{
						str_polIXBanco+= "('" + infoUsu.getUname().toLowerCase() + "','"+ infoUsu.getUname_br().toLowerCase() + "', @FOLIO ,'" + 
								IXBanco.getCve_banco() + "','3','"+ IXBanco.getImporte_transferencia().replace(",", "") + "',CURDATE(), CURTIME()),";
					}
					
					if(Double.parseDouble(IXBanco.getImporte_posfechado().replace(",", "")) > 0)
					{
						str_polIXBanco+= "('" + infoUsu.getUname().toLowerCase() + "','"+ infoUsu.getUname_br().toLowerCase() + "', @FOLIO ,'" + 
								IXBanco.getCve_banco() + "','98','"+ IXBanco.getImporte_posfechado().replace(",", "") + "',CURDATE(), CURTIME()),";
					}
				
				}
			}
			str_polIXBanco = str_polIXBanco.substring(0, str_polIXBanco.length() -1);
		}
		
		return str_polIXBanco;
	}
		
	private String generaInsertXTipoIngreso(Usuario infoUsu, List<PolizaDiaTipoIngreso> listaPolizaITipo,String imporTransito, String importeTransitoAplicado, String ajusteMasChequePol, String ajusteMenosChequePol)
	{
		String str_polIXTipo ="";
		try 
		{
			if(listaPolizaITipo.size() > 0)
			{
				for(PolizaDiaTipoIngreso IXTipo: listaPolizaITipo)
				{
					double total= Double.parseDouble(IXTipo.getImporte_efectivo().replace(",", "")) + Double.parseDouble(IXTipo.getImporte_cheque().replace(",", ""))+
								  Double.parseDouble(IXTipo.getImporte_tCredito().replace(",", ""))+Double.parseDouble(IXTipo.getImporte_tDebito().replace(",", ""))+
								  Double.parseDouble(IXTipo.getImporte_transferencia().replace(",", ""));
								
					if(total > 0)
					{
						if(Double.parseDouble(IXTipo.getImporte_efectivo().replace(",", "")) > 0)
						{
							str_polIXTipo+= "('" + infoUsu.getUname().toLowerCase() + "','"+ infoUsu.getUname_br().toLowerCase() + "', @FOLIO ,'" + 
									IXTipo.getTipo_pago() + "','1','"+ IXTipo.getImporte_efectivo().replace(",", "") + "',CURDATE(), CURTIME()),";
						}
						if(Double.parseDouble(IXTipo.getImporte_cheque().replace(",", "")) > 0)
						{
							str_polIXTipo+= "('" + infoUsu.getUname().toLowerCase() + "','"+ infoUsu.getUname_br().toLowerCase() + "', @FOLIO ,'" + 
									IXTipo.getTipo_pago() + "','2','"+ IXTipo.getImporte_cheque().replace(",", "") + "',CURDATE(), CURTIME()),";
						}
						if(Double.parseDouble(IXTipo.getImporte_tCredito().replace(",", "")) > 0)
						{
							str_polIXTipo+= "('" + infoUsu.getUname().toLowerCase() + "','"+ infoUsu.getUname_br().toLowerCase() + "', @FOLIO ,'" + 
									IXTipo.getTipo_pago() + "','4','"+ IXTipo.getImporte_tCredito().replace(",", "") + "',CURDATE(), CURTIME()),";
						}
						if(Double.parseDouble(IXTipo.getImporte_tDebito().replace(",", "")) > 0)
						{
							str_polIXTipo+= "('" + infoUsu.getUname().toLowerCase() + "','"+ infoUsu.getUname_br().toLowerCase() + "', @FOLIO ,'" + 
									IXTipo.getTipo_pago() + "','28','"+ IXTipo.getImporte_tDebito().replace(",", "") + "',CURDATE(), CURTIME()),";
						}
						if(Double.parseDouble(IXTipo.getImporte_transferencia().replace(",", "")) > 0)
						{
							str_polIXTipo+= "('" + infoUsu.getUname().toLowerCase() + "','"+ infoUsu.getUname_br().toLowerCase() + "', @FOLIO ,'" + 
									IXTipo.getTipo_pago() + "','3','"+ IXTipo.getImporte_transferencia().replace(",", "") + "',CURDATE(), CURTIME()),";
						}
						if(Double.parseDouble(IXTipo.getImporte_posfechado().replace(",", "")) > 0)
						{
							str_polIXTipo+= "('" + infoUsu.getUname().toLowerCase() + "','"+ infoUsu.getUname_br().toLowerCase() + "', @FOLIO ,'" + 
									IXTipo.getTipo_pago() + "','98','"+ IXTipo.getImporte_posfechado().replace(",", "") + "',CURDATE(), CURTIME()),";
						}				
					}
				}
				
				str_polIXTipo+= "('" + infoUsu.getUname().toLowerCase() + "','"+ infoUsu.getUname_br().toLowerCase() + "', @FOLIO ,'" + 
						"98" + "','0','"+ imporTransito.replace(",", "") + "',CURDATE(), CURTIME()),";
				
				str_polIXTipo+= "('" + infoUsu.getUname().toLowerCase() + "','"+ infoUsu.getUname_br().toLowerCase() + "', @FOLIO ,'" + 
						"99" + "','0','"+ importeTransitoAplicado.replace(",", "") + "',CURDATE(), CURTIME()),";
				
				if(!ajusteMasChequePol.equals("0"))
				{
					str_polIXTipo+= "('" + infoUsu.getUname().toLowerCase() + "','"+ infoUsu.getUname_br().toLowerCase() + "', @FOLIO ,'" + 
							"97" + "','0','"+ ajusteMasChequePol.replace(",", "") + "',CURDATE(), CURTIME()),";
				}
				else if(!ajusteMenosChequePol.equals("0"))
				{
					str_polIXTipo+= "('" + infoUsu.getUname().toLowerCase() + "','"+ infoUsu.getUname_br().toLowerCase() + "', @FOLIO ,'" + 
							"97" + "','0','"+ ajusteMenosChequePol.replace(",", "") + "',CURDATE(), CURTIME()),";
				}
				
				str_polIXTipo = str_polIXTipo.substring(0, str_polIXTipo.length() -1);
			}
		}
		catch(Exception ex)
		{
			System.out.println("Error :" + ex.getMessage().toString());
		}
		
		
		return str_polIXTipo;
	}
	
	private String generaInsertXOtrosIngresos(Usuario infoUsu, List<PolizaDiaOtrosIngresos> listaPolizaIOtros)
	{
		String str_polIOtro ="";
		if(listaPolizaIOtros.size() > 0)
		{
			for(PolizaDiaOtrosIngresos IXOtro: listaPolizaIOtros)
			{				
				if(Double.parseDouble(IXOtro.getImporte_efectivo().replace(",", "")) > 0)
				{
					str_polIOtro+= "('" + infoUsu.getUname().toLowerCase() + "','"+ infoUsu.getUname_br().toLowerCase() + "', @FOLIO ,'" + 
							IXOtro.getId_otro_ingreso() + "','1','"+ IXOtro.getImporte_efectivo().replace(",", "") + "',CURDATE(), CURTIME()),";
				}
				
				if(Double.parseDouble(IXOtro.getImporte_cheque().replace(",", "")) > 0)
				{
					str_polIOtro+= "('" + infoUsu.getUname().toLowerCase() + "','"+ infoUsu.getUname_br().toLowerCase() + "', @FOLIO ,'" + 
							IXOtro.getId_otro_ingreso() + "','2','"+ IXOtro.getImporte_cheque().replace(",", "") + "',CURDATE(), CURTIME()),";
				}
				
				if(Double.parseDouble(IXOtro.getImporte_tCredito().replace(",", "")) > 0)
				{
					str_polIOtro+= "('" + infoUsu.getUname().toLowerCase() + "','"+ infoUsu.getUname_br().toLowerCase() + "', @FOLIO ,'" + 
							IXOtro.getId_otro_ingreso() + "','4','"+ IXOtro.getImporte_tCredito().replace(",", "") + "',CURDATE(), CURTIME()),";
				}
				
				if(Double.parseDouble(IXOtro.getImporte_tDebito().replace(",", "")) > 0)
				{
					str_polIOtro+= "('" + infoUsu.getUname().toLowerCase() + "','"+ infoUsu.getUname_br().toLowerCase() + "', @FOLIO ,'" + 
							IXOtro.getId_otro_ingreso() + "','28','"+ IXOtro.getImporte_tDebito().replace(",", "") + "',CURDATE(), CURTIME()),";
				}
				
				if(Double.parseDouble(IXOtro.getImporte_transferencia().replace(",", "")) > 0)
				{
					str_polIOtro+= "('" + infoUsu.getUname().toLowerCase() + "','"+ infoUsu.getUname_br().toLowerCase() + "', @FOLIO ,'" + 
							IXOtro.getId_otro_ingreso() + "','3','"+ IXOtro.getImporte_transferencia().replace(",", "") + "',CURDATE(), CURTIME()),";
				}
				
				if(Double.parseDouble(IXOtro.getImporte_posfechado().replace(",", "")) > 0)
				{
					str_polIOtro+= "('" + infoUsu.getUname().toLowerCase() + "','"+ infoUsu.getUname_br().toLowerCase() + "', @FOLIO ,'" + 
							IXOtro.getId_otro_ingreso() + "','98','"+ IXOtro.getImporte_posfechado().replace(",", "") + "',CURDATE(), CURTIME()),";
				}	
			}
			str_polIOtro = str_polIOtro.substring(0, str_polIOtro.length() -1);
		}
		
		return str_polIOtro;
	}

	private String generaInsertXEgresos(Usuario infoUsu, List<PolizaDiaTipoEgreso> listaPolizaETipo)
	{
		String str_polIOtro ="";
		if(listaPolizaETipo.size() > 0)
		{
			for(PolizaDiaTipoEgreso EXTipo: listaPolizaETipo)
			{				
				if(Double.parseDouble(EXTipo.getImporte_efectivo().replace(",", "")) > 0)
				{
					str_polIOtro+= "('" + infoUsu.getUname().toLowerCase() + "','"+ infoUsu.getUname_br().toLowerCase() + "', @FOLIO ,'" + 
							EXTipo.getTipo_egreso() + "','1','"+ EXTipo.getImporte_efectivo().replace(",", "") + "',CURDATE(), CURTIME()),";
				}
				
				if(Double.parseDouble(EXTipo.getImporte_cheque().replace(",", "")) > 0)
				{
					str_polIOtro+= "('" + infoUsu.getUname().toLowerCase() + "','"+ infoUsu.getUname_br().toLowerCase() + "', @FOLIO ,'" + 
							EXTipo.getTipo_egreso() + "','2','"+ EXTipo.getImporte_cheque().replace(",", "") + "',CURDATE(), CURTIME()),";
				}
				
				if(Double.parseDouble(EXTipo.getImporte_tCredito().replace(",", "")) > 0)
				{
					str_polIOtro+= "('" + infoUsu.getUname().toLowerCase() + "','"+ infoUsu.getUname_br().toLowerCase() + "', @FOLIO ,'" + 
							EXTipo.getTipo_egreso() + "','4','"+ EXTipo.getImporte_tCredito().replace(",", "") + "',CURDATE(), CURTIME()),";
				}
				
				if(Double.parseDouble(EXTipo.getImporte_tDebito().replace(",", "")) > 0)
				{
					str_polIOtro+= "('" + infoUsu.getUname().toLowerCase() + "','"+ infoUsu.getUname_br().toLowerCase() + "', @FOLIO ,'" + 
							EXTipo.getTipo_egreso() + "','28','"+ EXTipo.getImporte_tDebito().replace(",", "") + "',CURDATE(), CURTIME()),";
				}
				
				if(Double.parseDouble(EXTipo.getImporte_transferencia().replace(",", "")) > 0)
				{
					str_polIOtro+= "('" + infoUsu.getUname().toLowerCase() + "','"+ infoUsu.getUname_br().toLowerCase() + "', @FOLIO ,'" + 
							EXTipo.getTipo_egreso() + "','3','"+ EXTipo.getImporte_transferencia().replace(",", "") + "',CURDATE(), CURTIME()),";
				}
				
				if(Double.parseDouble(EXTipo.getImporte_posfechado().replace(",", "")) > 0)
				{
					str_polIOtro+= "('" + infoUsu.getUname().toLowerCase() + "','"+ infoUsu.getUname_br().toLowerCase() + "', @FOLIO ,'" + 
							EXTipo.getTipo_egreso() + "','98','"+ EXTipo.getImporte_posfechado().replace(",", "") + "',CURDATE(), CURTIME()),";
				}	
			}
			str_polIOtro = str_polIOtro.substring(0, str_polIOtro.length() -1);
		}
		
		return str_polIOtro;
	}
	
	public String obtieneTotalDePoliza( List<PolizaDiaTipoIngreso> listaPolizaITipo, List<PolizaDiaTipoEgreso> listaPolizaEgreso)
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
	
	
	/****  GENERA POLIZA CONTABLE  ****/	
	public boolean generaPolizaContable(Usuario infoUsu, List<Querys> ListaQuerys, PolizaCompleta polizaCompleta)
	{
		boolean insertoPolizaBD= false;
		Connection connBD = null;
		PreparedStatement pstm= null;		
		connBD = ConexionBD.AbrirConexionBD(infoUsu.getUname());
		try
		{
			String[] querys = new String[25];	
			querys = Cls_Querys.LimpiaListaQuerys(querys);	
			querys = Cls_Querys.ObtieneQuerys(966, ListaQuerys, querys, infoUsu);/*POLIZA DINAMICA*/
			querys = InicializaQueryNumero96(querys, infoUsu, polizaCompleta.getFolio_poliza());
		
			pstm = connBD.prepareStatement("{call " + "CTRL_INGRESOS.usp_EXECUTE_QUERY(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			EjecutaQuerysBD.EjecutarQuery(querys[0], querys[1],querys[2], querys[3], querys[4], querys[5], querys[6],
														 querys[7], querys[8], querys[9],querys[10], querys[11], querys[12], querys[13], 
														 querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], 
														 querys[21], querys[22], querys[23], querys[24], infoUsu.getUname(),pstm, connBD);
			Cls_Log.insertaLog(infoUsu, "", "", " Genera e Imprime Poliza del Dia actual. [" +  polizaCompleta.getFolio_poliza() + "]");
			insertoPolizaBD = true;
		}
		catch(Exception ex)
		{
			Cls_Log.insertaLog(infoUsu, "", "", "Error al insertar la poliza del dia en BD: [" +ex.getMessage().toString() + "]");
		}
		finally
		{
			try {connBD.close();} catch (SQLException e) {e.printStackTrace();}
			try {pstm.close();} catch (SQLException e) {e.printStackTrace();}
		}	
		
		return insertoPolizaBD;
	}
	
	/**** INICIALIZA LOS QUERYS DE EGRESOS ****/				
	private String[] InicializaQueryNumero74(String[] ListaQuerys, Usuario infoUsu) 
	{		
		for (int i=0;i <ListaQuerys.length; i++)
		{
			ListaQuerys[i]= ListaQuerys[i].replace("{BANCO_X_CDO}", String.valueOf(obtenerBancoParaHRyConXCDO(infoUsu.getUname())));			
		}
		return ListaQuerys;
	}
		
	private String[] InicializaQueryNumero76(String[] ListaQuerys, Usuario infoUsu,String insertPolizaIXBanco,String insertPolizaIXTipoPago,String insertPolizaEXTipo,String insertPolizaOI,String importeTotalCorte ) 
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
		}
		return ListaQuerys;
	}
	
	private String[] InicializaQueryNumero78(String[] ListaQuerys, Usuario infoUsu) 
	{		
		for (int i=0;i <ListaQuerys.length; i++)
		{
			ListaQuerys[i]= ListaQuerys[i].replace("{FECHA_PANAMERICANO}"," AND fecha_poliza = CURDATE()" );
			ListaQuerys[i]= ListaQuerys[i].replace("{UNAME_CONSULTA}", infoUsu.getUname_br().toLowerCase());
		}
		return ListaQuerys;
	}
			
	private String[] InicializaQueryNumero90(String[] ListaQuerys, Usuario infoUsu) 
	{		
		for (int i=0;i <ListaQuerys.length; i++)
		{
			ListaQuerys[i]= ListaQuerys[i].replace("{FECHA_POLIZA}", "CURDATE()");	
			ListaQuerys[i]= ListaQuerys[i].replace("{ESTATUS}", "1");
			ListaQuerys[i]= ListaQuerys[i].replace("{UNAME_CONSULTA}", infoUsu.getUname_br().toLowerCase());
		}
		return ListaQuerys;
	}
	
	private String[] InicializaQueryNumero93(String[] ListaQuerys, Usuario infoUsu) 
	{		
		for (int i=0;i <ListaQuerys.length; i++)
		{
			ListaQuerys[i]= ListaQuerys[i].replace("{FECHA_POLIZA}", "CURDATE()");	
			ListaQuerys[i]= ListaQuerys[i].replace("{ESTATUS}", "2,3");
			ListaQuerys[i]= ListaQuerys[i].replace("{UNAME_CONSULTA}", infoUsu.getUname_br().toLowerCase());
		}
		return ListaQuerys;
	}
	
	private String[] InicializaQueryNumero96(String[] ListaQuerys, Usuario infoUsu, String FolioPoliza) 
	{		
		for (int i=0;i <ListaQuerys.length; i++)
		{
			ListaQuerys[i]= ListaQuerys[i].replace("{FOLIO_POLIZA}", FolioPoliza);	
		}
		return ListaQuerys;
	}
	
	private int obtenerBancoParaHRyConXCDO(String uname_br)
	{
		int banco = 5;
		/*switch(uname_br)
		{
			case "cdf":
				banco=5;
				break;
		}		*/
		return banco;
	}

}
