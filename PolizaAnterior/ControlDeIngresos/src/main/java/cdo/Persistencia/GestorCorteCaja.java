package cdo.Persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import cdo.Datos.PrevioDenominacionesBilletes;
import cdo.Datos.PrevioDenominacionesMonedas;
import cdo.Datos.CorteDeCaja;
import cdo.Datos.Egresos;
import cdo.Datos.Log;
import cdo.Datos.PrevioCorteCaja;
import cdo.Datos.PrevioEgresos;
import cdo.Datos.PrevioEgresosBanco;
import cdo.Datos.PrevioIngresosBancos;
import cdo.Datos.PrevioIngresosFormaPago;
import cdo.Datos.PrevioIngresosTipoPago;
import cdo.Datos.Querys;
import cdo.Datos.SemaforoIngresos;
import cdo.Datos.Usuario;
import cdo.util.Cls_Log;
import cdo.util.Cls_MetodosGlobales;
import cdo.util.Cls_Querys;
import cdo.util.ConexionBD;
import cdo.util.EjecutaQuerysBD;

public class GestorCorteCaja {

	DecimalFormat formatoDecimal = new DecimalFormat("#,###.00");
		
	/****  CONSULTA PREVIO DE CORTE DE CAJA  ****/
	public PrevioCorteCaja ConsultaPrevioDeIngresosBD(Usuario infoUsu, List<Querys> ListaQuerys) 
	{
		PrevioCorteCaja previoCorteCaja= null;
		String strQry="";
		Connection connBD = null;
		PreparedStatement pstm= null;		
		connBD = ConexionBD.AbrirConexionBD(infoUsu.getUname());
		try
		{
			String[] querys = new String[25];	
			querys = Cls_Querys.LimpiaListaQuerys(querys);	
			querys = Cls_Querys.ObtieneQuerys(17, ListaQuerys, querys, infoUsu);
			strQry = Cls_MetodosGlobales.obtieneSentenciaDeQrys(querys);
			pstm = connBD.prepareStatement("{call " + "CTRL_INGRESOS.usp_EXECUTE_QUERY(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			ResultSet rs= EjecutaQuerysBD.EjecutarQuery(querys[0], querys[1],querys[2], querys[3], querys[4], querys[5], querys[6],
														 querys[7], querys[8], querys[9],querys[10], querys[11], querys[12], querys[13], 
														 querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], 
														 querys[21], querys[22], querys[23], querys[24], infoUsu.getUname(),pstm, connBD);
		
			if(rs !=null)
				previoCorteCaja=new PrevioCorteCaja(LlenaClasePrevioTipoPago(rs), LlenaClasePrevioFormaPago(rs), 
													LlenaClasePrevioEgresos(rs), LlenaClasesDenominacionesBilletes(rs),
													LlenaClasesDenominacionesMonedas(rs), LlenaClasesIngresosBancos(rs),LlenaClasesEgresosBancos(rs));
			String strLog = "Consulta Corte De caja.  "    +  " QUERIES-17[" + strQry + "]"  ;
			Cls_Log.insertaLog(infoUsu, "", "",  strLog );		
		}
		catch(Exception ex)
		{
			System.out.println("Error al consultar previo de ingresos.");
			Cls_Log.insertaLog(infoUsu, "", "", "Error al consultar previo de ingresos. [" + ex.getMessage().toString()+ "]  "  +  "   QUERIES-17[" + strQry + "]");
		}
		finally
		{
			try {pstm.close();} catch (SQLException e) {e.printStackTrace();}
			try {connBD.close();} catch (SQLException e) {e.printStackTrace();}
		}
		
		return previoCorteCaja;
	}
	
	public List<SemaforoIngresos> consultaDatosDelSemaforo(Usuario infoUsu, List<Querys> ListaQuerys)
	{
		List<SemaforoIngresos> listaSemaforo = new ArrayList<>();
		String strQry="";
		Connection connBD = null;
		PreparedStatement pstm= null;		
		connBD = ConexionBD.AbrirConexionBD(infoUsu.getUname());
		try
		{
			String[] querys = new String[25];	
			querys = Cls_Querys.LimpiaListaQuerys(querys);	
			querys = Cls_Querys.ObtieneQuerys(23, ListaQuerys, querys, infoUsu);
			strQry = Cls_MetodosGlobales.obtieneSentenciaDeQrys(querys);
			pstm = connBD.prepareStatement("{call " + "CTRL_INGRESOS.usp_EXECUTE_QUERY(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			ResultSet rs=  EjecutaQuerysBD.EjecutarQuery(querys[0], querys[1],querys[2], querys[3], querys[4], querys[5], querys[6],
														 querys[7], querys[8], querys[9],querys[10], querys[11], querys[12], querys[13], 
														 querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], 
														 querys[21], querys[22], querys[23], querys[24], infoUsu.getUname(),pstm, connBD);	
			if (rs != null)
				listaSemaforo = crearListaDeSemaforo(rs);
			
		}
		catch(Exception ex)
		{
			System.out.println("Error al consultar parametros del semaforo.");
			Cls_Log.insertaLog(infoUsu, "", "", "Error al consultar parametros del semaforo. [" + ex.getMessage().toString()+ "]  "  +  " QUERIES-23[" + strQry + "]");	
		}
		finally
		{
			try {pstm.close();} catch (SQLException e) {e.printStackTrace();}
			try {connBD.close();} catch (SQLException e) {e.printStackTrace();}
		}
		return listaSemaforo;
	}
	
	public  List<SemaforoIngresos> crearListaDeSemaforo(ResultSet rs)
	{
		List<SemaforoIngresos> listaSemaforo = new ArrayList<>();
		try
		{
			while (rs.next())
	        {
				SemaforoIngresos semaforo= new SemaforoIngresos(
													formatoDecimal.format(rs.getDouble("importe_actual")), 
													formatoDecimal.format(rs.getDouble("importe_minimo")),
													formatoDecimal.format(rs.getDouble("importe_maximo")));
				listaSemaforo.add(semaforo);
	        }
		}
		catch(Exception ex)
		{
			System.out.println("ERROR: " + ex.getMessage().toString());
		}
		
		return listaSemaforo;
	}
	
	
	/****  LLENA LAS CLASES DEL CORTE DE CAJA  ****/
	private List<PrevioIngresosTipoPago> LlenaClasePrevioTipoPago(ResultSet rs)
	{
		List<PrevioIngresosTipoPago> listaPrevioXTP =new  ArrayList<>();
		try
		{
			rs.beforeFirst();
			while(rs.next())
			{
				if(rs.getString("tipo_pago").equals("*"))
				{
					if(rs.getDouble("importe_tipo_pago") > 0)
					{
						PrevioIngresosTipoPago previoTP = new PrevioIngresosTipoPago(rs.getInt("id_tipo_ingreso"), rs.getString("nombre_tipo_pago").toUpperCase(), formatoDecimal.format(rs.getDouble("importe_tipo_pago")));
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
	
	private List<PrevioIngresosFormaPago> LlenaClasePrevioFormaPago(ResultSet rs)
	{
		List<PrevioIngresosFormaPago> listaPrevioXFP =new  ArrayList<>();
		try
		{
			rs.first();
			while(rs.next())
			{
				if(rs.getString("forma_pago").equals("*"))
				{
					if(rs.getDouble("importe_forma_pago") > 0)
					{
						PrevioIngresosFormaPago previoFP= new PrevioIngresosFormaPago(rs.getInt("id_forma_pago"), rs.getString("nombre_forma_pago"), formatoDecimal.format( rs.getDouble("importe_forma_pago")));
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
		
	private List<PrevioEgresos> LlenaClasePrevioEgresos(ResultSet rs)
	{
		List<PrevioEgresos> listaPrevioEgresos =new  ArrayList<>();
		try
		{
			rs.first();
			while(rs.next())
			{
				if(rs.getString("egresos").equals("*"))
				{
					PrevioEgresos previoE= new PrevioEgresos(rs.getInt("id_egreso"), rs.getString("nombre_egreso").toUpperCase(),  formatoDecimal.format( rs.getDouble("importe_egreso")));
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
	
	private List<PrevioDenominacionesBilletes> LlenaClasesDenominacionesBilletes(ResultSet rs)
	{
		List<PrevioDenominacionesBilletes> LlenaClasesDenominacionesBillete =new  ArrayList<>();
		try
		{
			rs.first();
			while(rs.next())
			{
				if(rs.getString("denominaciones").equals("*"))
				{
					if(rs.getString("tipo_denominacion").equals("B"))
					{
						PrevioDenominacionesBilletes denominacion = new PrevioDenominacionesBilletes(rs.getInt("id_denominacion"), rs.getString("denominacion").toUpperCase(), rs.getString("tipo_denominacion").toUpperCase());
						LlenaClasesDenominacionesBillete.add(denominacion);
					}
				}
			}
		}
		catch(Exception ex)
		{
			System.out.println("Error al llenar la clase de previo denominaciones de billete. Detalle: " + ex.getMessage().toString());
		}
		return LlenaClasesDenominacionesBillete;
	}
	
	private List<PrevioDenominacionesMonedas> LlenaClasesDenominacionesMonedas(ResultSet rs)
	{
		List<PrevioDenominacionesMonedas> LlenaClasesDenominacionesMoneda =new  ArrayList<>();
		try
		{
			rs.first();
			while(rs.next())
			{
				if(rs.getString("denominaciones").equals("*"))
				{
					if(rs.getString("tipo_denominacion").equals("M"))
					{
						PrevioDenominacionesMonedas denominacion = new PrevioDenominacionesMonedas(rs.getInt("id_denominacion"), rs.getString("denominacion").toUpperCase(), rs.getString("tipo_denominacion").toUpperCase());
						LlenaClasesDenominacionesMoneda.add(denominacion);
					}
				}
			}
		}
		catch(Exception ex)
		{
			System.out.println("Error al llenar la clase de previo denominaciones de moneda. Detalle" + ex.getMessage().toString());
		}
		return LlenaClasesDenominacionesMoneda;
	}
		
	private List<PrevioIngresosBancos> LlenaClasesIngresosBancos(ResultSet rs)
	{
		List<PrevioIngresosBancos> LlenaClasesBancos =new  ArrayList<>();
		try
		{
			rs.first();
			while(rs.next())
			{
				if(rs.getString("bancos").equals("*"))
				{
					
						PrevioIngresosBancos banco = new PrevioIngresosBancos(rs.getInt("cve_banco"), rs.getString("nombre_banco").toUpperCase(), formatoDecimal.format(rs.getDouble("importe_banco")));
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
	
	private List<PrevioEgresosBanco> LlenaClasesEgresosBancos(ResultSet rs)
	{
		List<PrevioEgresosBanco> LlenaClasesEBancos =new  ArrayList<>();
		try
		{
			rs.first();
			while(rs.next())
			{
				if(rs.getString("bancos_egresos").equals("*"))
				{
					PrevioEgresosBanco banco = new PrevioEgresosBanco(rs.getInt("cve_banco_egresos"), rs.getString("nombre_banco_egresos").toUpperCase(), formatoDecimal.format(rs.getDouble("importe_banco_egresos")));
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
	
	
	/****  ESTA SECCION CALCULA EL PREVIO DE LO QUE NO TIENE BANCO  ****/
	public List<PrevioIngresosBancos> obtienePrevioIngresosBancos(PrevioCorteCaja previoCorteCaja, String uname_br)
	{
		double importePrevioIB = 0;
		int bancoAdicional= obtenerBancoParaHRyConXCDO(uname_br);
		List<PrevioIngresosBancos> listaPrevioBancos = previoCorteCaja.getListaIngresosBancos();
		List<PrevioIngresosTipoPago> listaPrevioTipoPago = previoCorteCaja.getListaPrevioXTP();
		
		for(PrevioIngresosTipoPago tipoPago:listaPrevioTipoPago)
		{
			if(tipoPago.getId_tipo_pago() == 2 || tipoPago.getId_tipo_pago() == 3 || tipoPago.getId_tipo_pago() == 5 || tipoPago.getId_tipo_pago() == 7)
				importePrevioIB += Double.parseDouble(tipoPago.getImporte().replace(",", ""));
		}
		
		for(PrevioIngresosBancos banco:listaPrevioBancos)
		{
			if(banco.getCve_banco() == bancoAdicional)
			{
				double  total = Double.parseDouble(banco.getImporte().replace(",", "")) + importePrevioIB; 
				banco.setImporte(formatoDecimal.format(total));
			}
		}
		return listaPrevioBancos;
	}
	
	private int obtenerBancoParaHRyConXCDO(String uname_br)
	{
		int banco = 0;
		/*switch(uname_br)
		{
			case "cdf":
				banco=5;
				break;
		}*/
		
		banco=5;
		return banco;
	}
		
	
	/****  CALCULA IMPORTES TOTALES  ****/
	public String  calculaImportePrevioIngresos(List<PrevioIngresosTipoPago> listaPrevioI)
	{
		String impPrevIconFormato="";
		double importePrevioI = 0;
		
		for(int i=0; i< listaPrevioI.size(); i++)
			importePrevioI += Double.parseDouble(listaPrevioI.get(i).getImporte().replace(",", ""));
		
		impPrevIconFormato = formatoDecimal.format(importePrevioI);
		return impPrevIconFormato;
	}

	public String calculaImportePrevioEgresos(List<PrevioEgresos> listaPrevioE)
	{
		
		String impPrevEconFormato="";
		double importePrevioE = 0;
		
		for(int i=0; i< listaPrevioE.size(); i++)
			importePrevioE += Double.parseDouble(listaPrevioE.get(i).getImporte_egreso().replace(",", ""));
		
		impPrevEconFormato = formatoDecimal.format(importePrevioE);
		return impPrevEconFormato;
	}
	
	public String calculaImportePrevioTotal(String importePrevioI, String importePrevioE)
	{
		String impPrevTotalconFormato="";
		double importeTotal= Double.parseDouble(importePrevioI.replace(",", "")) -  Double.parseDouble(importePrevioE.replace(",", ""));
		impPrevTotalconFormato = formatoDecimal.format(importeTotal);
		return impPrevTotalconFormato;
	}
		
	public String  calculaImportePrevioIEfectivo(List<PrevioIngresosFormaPago> listaPrevioI)
	{
		String impPrevIEfectivoConFormato="";
		double importePrevioIEfectivo = 0;
		
		for(int i=0; i< listaPrevioI.size(); i++)
			if(listaPrevioI.get(i).getCve_forma_pago() == 1)
				importePrevioIEfectivo += Double.parseDouble(listaPrevioI.get(i).getImporte().replace(",", ""));
	
		impPrevIEfectivoConFormato = formatoDecimal.format(importePrevioIEfectivo);
		return impPrevIEfectivoConFormato;
	}
	
	public String calculaImportePrevioTotalEfectivo (String TotalEfectivo, String TotalEgreso)
	{
		String impPrevTotalEfectivoConFormato="";
		double importePrevioTotalEfectivo = Double.parseDouble(TotalEfectivo.replace(",", "")) - Double.parseDouble(TotalEgreso.replace(",", ""));
		impPrevTotalEfectivoConFormato = formatoDecimal.format(importePrevioTotalEfectivo);
		return impPrevTotalEfectivoConFormato;
	}

		
	/****  INSERTA CORTE DE CAJA EN BD ****/	
	public List<CorteDeCaja> insertaCorteDeCajaEnBD(Usuario infoUsu, List<Querys> ListaQuerys, HttpSession session)
	{
		String strQry="";
		String importeTotalCorte = String.valueOf(session.getAttribute("importePrevioTotal")).replace(",", "");		
		List<CorteDeCaja>listaCorteCaja=null;
		String insertCorteIXBanco = generaInsertXBancoIngresos(infoUsu, (List<PrevioIngresosBancos>) session.getAttribute("ListPrevioIXB"),importeTotalCorte);
		String insertCorteEXBanco =  generaInsertXBancoEgresos(infoUsu, (List<PrevioEgresosBanco>) session.getAttribute("ListPrevioEXB"), importeTotalCorte);
		String insertCorteIXTipoPago = generaInsertXTipoPagoIngresos(infoUsu, (List<PrevioIngresosTipoPago>) session.getAttribute("ListPrevioIXTP"), importeTotalCorte);
		String insertCorteIXFormaPago = generaInsertXFormaPagoIngresos(infoUsu, (List<PrevioIngresosFormaPago>) session.getAttribute("ListPrevioIXFP"), importeTotalCorte);
		String insertCorteEXTipo = generaInsertXTipoEgreso(infoUsu, (List<PrevioEgresos>) session.getAttribute("ListPrevioE"), importeTotalCorte);
		
		Connection connBD = null;
		PreparedStatement pstm= null;		
		connBD = ConexionBD.AbrirConexionBD(infoUsu.getUname());
		try
		{
			String[] querys = new String[25];	
			querys = Cls_Querys.LimpiaListaQuerys(querys);	
			querys = Cls_Querys.ObtieneQuerys(18, ListaQuerys, querys, infoUsu);
			querys = inicializaQuery18(querys, infoUsu, insertCorteIXBanco,insertCorteEXBanco, insertCorteIXTipoPago, insertCorteIXFormaPago, insertCorteEXTipo,importeTotalCorte);
			strQry = Cls_MetodosGlobales.obtieneSentenciaDeQrys(querys);
			pstm = connBD.prepareStatement("{call " + "CTRL_INGRESOS.usp_EXECUTE_QUERY(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			ResultSet rs=  EjecutaQuerysBD.EjecutarQuery(querys[0], querys[1],querys[2], querys[3], querys[4], querys[5], querys[6],
														 querys[7], querys[8], querys[9],querys[10], querys[11], querys[12], querys[13], 
														 querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], 
														 querys[21], querys[22], querys[23], querys[24], infoUsu.getUname(),pstm, connBD);	
		
			listaCorteCaja= creaListaDeDatosDeCorteDeCaja(rs, infoUsu,session);		

			String strLog = "Inserto Corte De caja: [" + listaCorteCaja + "]   "      +  "   QUERIES-18[" + strQry + "]" ;
			Cls_Log.insertaLog(infoUsu, "", "",  strLog );	
		}
		catch(Exception ex)
		{
			System.out.println("Error al insertar previo de ingresos. Detalle: " + ex.getMessage().toString()        +  "    QUERIES-18[" + strQry + "]" );
		}
		finally
		{
			try {pstm.close();} catch (SQLException e) {e.printStackTrace();}
			try {connBD.close();} catch (SQLException e) {e.printStackTrace();}
		}
		return listaCorteCaja;
	}
	
	private List<CorteDeCaja> creaListaDeDatosDeCorteDeCaja(ResultSet rs, Usuario infoUsu, HttpSession session)
	{
		List<CorteDeCaja>listaCorteCaja= new ArrayList<CorteDeCaja>();
		CorteDeCaja datosCorteDeCaja=null;
		try
		{
			if(rs !=null)
			{
				while(rs.next())
				{
					datosCorteDeCaja = new CorteDeCaja();
					datosCorteDeCaja.setUname(rs.getString("uname"));
					datosCorteDeCaja.setUname_br(rs.getString("uname_br"));
					datosCorteDeCaja.setFolio_corte(rs.getString("folio_corte_caja"));
					datosCorteDeCaja.setImporte((String)session.getAttribute("importePrevioTotalEfectivo"));
					datosCorteDeCaja.setUsuario(rs.getString("cve_usu"));
					datosCorteDeCaja.setNombre_usuario(infoUsu.getNombre());
					datosCorteDeCaja.setFecha_corteCaja(rs.getString("fecha_pro"));
					datosCorteDeCaja.setHora_corteCaja(rs.getString("hora_pro"));
				}
			}
			listaCorteCaja.add(datosCorteDeCaja);
			
		}catch(Exception ex)
		{
			System.out.println("Error al crear la lista de corte de caja.");
		}
		return listaCorteCaja;
	}
	
	private String generaInsertXBancoIngresos(Usuario infoUsu, List<PrevioIngresosBancos> listaIXBanco, String importeTotalCorte)
	{
		String str_corteIngresoXBanco ="";
		
		if(Double.parseDouble(importeTotalCorte) >0)
		{
			if(listaIXBanco.size() > 0)
			{
				for(PrevioIngresosBancos IXBanco: listaIXBanco)
				{
					if(Double.parseDouble(IXBanco.getImporte().replace(",", "")) >0)
					{
						str_corteIngresoXBanco+= "('" + infoUsu.getUname().toLowerCase() + "','"+ infoUsu.getUname_br().toLowerCase() + "', @FOLIO ,'" + IXBanco.getCve_banco() + "','"+ IXBanco.getImporte().replace(",", "") + "',CURDATE(), CURTIME()),";
					}
				}
				if(str_corteIngresoXBanco.length() > 0)
				{
					str_corteIngresoXBanco = str_corteIngresoXBanco.substring(0, str_corteIngresoXBanco.length() -1);
				}
			}
		}
		
		return str_corteIngresoXBanco;
	}
	
	private String generaInsertXBancoEgresos(Usuario infoUsu, List<PrevioEgresosBanco> listaEXBanco, String importeTotalCorte)
	{
		String str_corteEgresoXBanco ="";
		if(listaEXBanco.size()>0)
		{
			for(PrevioEgresosBanco EXBanco: listaEXBanco)
			{
				str_corteEgresoXBanco+= "('" + infoUsu.getUname().toLowerCase() + "','"+ infoUsu.getUname_br().toLowerCase() + "', @FOLIO ,'" + EXBanco.getCve_banco() + "','"+ EXBanco.getImporte().replace(",", "") + "',CURDATE(), CURTIME()),";  
			}
			str_corteEgresoXBanco = str_corteEgresoXBanco.substring(0, str_corteEgresoXBanco.length() -1);
		}
		
		return str_corteEgresoXBanco;
	}
	
	private String generaInsertXTipoPagoIngresos(Usuario infoUsu, List<PrevioIngresosTipoPago> listaIXTipoPago, String importeTotalCorte)
	{
		String str_corteIngresoXTipoPago ="";
		if(Double.parseDouble(importeTotalCorte) >0)
		{
			if(listaIXTipoPago.size()>0)
			{
				for(PrevioIngresosTipoPago IXTipoPago: listaIXTipoPago)
				{
					str_corteIngresoXTipoPago+= "('" + infoUsu.getUname().toLowerCase() + "','"+ infoUsu.getUname_br().toLowerCase() + "', @FOLIO ,'" + IXTipoPago.getId_tipo_pago()+ "','"+ IXTipoPago.getImporte().replace(",", "") + "',CURDATE(), CURTIME()),";  
				}
				str_corteIngresoXTipoPago = str_corteIngresoXTipoPago.substring(0, str_corteIngresoXTipoPago.length() -1);
			}
		}
		
		return str_corteIngresoXTipoPago;
	}
	
	private String generaInsertXFormaPagoIngresos(Usuario infoUsu, List<PrevioIngresosFormaPago> listaIXFormaPago, String importeTotalCorte)
	{
		String str_corteIngresoXFormaPago ="";
		if(Double.parseDouble(importeTotalCorte) >0)
		{
			if(listaIXFormaPago.size()>0)
			{
				for(PrevioIngresosFormaPago IXFormaPago: listaIXFormaPago)
				{
					str_corteIngresoXFormaPago+= "('" + infoUsu.getUname().toLowerCase() + "','"+ infoUsu.getUname_br().toLowerCase() + "', @FOLIO ,'" + IXFormaPago.getCve_forma_pago() + "','"+ IXFormaPago.getImporte().replace(",", "") + "',CURDATE(), CURTIME()),";  
				}
				str_corteIngresoXFormaPago = str_corteIngresoXFormaPago.substring(0, str_corteIngresoXFormaPago.length() -1);
			}
		}		
		return str_corteIngresoXFormaPago;
	}
	
	private String generaInsertXTipoEgreso(Usuario infoUsu, List<PrevioEgresos> listaXTipoEgreso, String importeTotalCorte)
	{
		String str_corteEgresoXTipo ="";
		if(listaXTipoEgreso.size()>0)
		{
			for(PrevioEgresos EXTipo: listaXTipoEgreso)
			{
				str_corteEgresoXTipo+= "('" + infoUsu.getUname().toLowerCase() + "','"+ infoUsu.getUname_br().toLowerCase() + "', @FOLIO ,'" + EXTipo.getId_egreso() + "','"+ EXTipo.getImporte_egreso().replace(",", "") + "',CURDATE(), CURTIME()),";  
			}
			str_corteEgresoXTipo = str_corteEgresoXTipo.substring(0, str_corteEgresoXTipo.length() -1);
		}
		return str_corteEgresoXTipo;
	}
		
	
	/****  REDONDEO EN CENTAVOS  ****/
	public boolean cosultaRedondeosPreviosEnBD(Usuario infoUsu, List<Querys> ListaQuerys)
	{
		boolean  existeRedondeoPrevio = false; 
		String strQry="";
		Connection connBD = null;
		PreparedStatement pstm= null;		
		connBD = ConexionBD.AbrirConexionBD(infoUsu.getUname());
		try
		{
			String[] querys = new String[25];	
			querys = Cls_Querys.LimpiaListaQuerys(querys);	
			querys = Cls_Querys.ObtieneQuerys(53, ListaQuerys, querys, infoUsu);
			strQry = Cls_MetodosGlobales.obtieneSentenciaDeQrys(querys);
			pstm = connBD.prepareStatement("{call " + "CTRL_INGRESOS.usp_EXECUTE_QUERY(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			ResultSet rs= EjecutaQuerysBD.EjecutarQuery(querys[0], querys[1],querys[2], querys[3], querys[4], querys[5], querys[6],
														 querys[7], querys[8], querys[9],querys[10], querys[11], querys[12], querys[13], 
														 querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], 
														 querys[21], querys[22], querys[23], querys[24], infoUsu.getUname(),pstm, connBD);	
			if(rs !=null)
			{
				while (rs.next())
		        {
					if(rs.getInt("egreso") > 0 || rs.getInt("OtrosIngresos") > 0)
					{
						existeRedondeoPrevio = true;
					}
		        }
			}		
			Cls_Log.insertaLog(infoUsu, "", "",  "Valida si exiten redondeos Existente "   +  "   QUERIES-53[" + strQry + "]");		
		}
		catch(Exception ex)
		{
			System.out.println("Error al validar si existen redondeos previos.  "    +  "   QUERIES-53[" + strQry + "]");
		}
		finally
		{
			try {pstm.close();} catch (SQLException e) {e.printStackTrace();}
			try {connBD.close();} catch (SQLException e) {e.printStackTrace();}
		}
		return existeRedondeoPrevio;
	}
	
	public boolean eliminaRedondeosPreviosEnBD(Usuario infoUsu, List<Querys> ListaQuerys)
	{
		boolean eliminaRedondeoPrevio = false; 
		String strQry="";
		Connection connBD = null;
		PreparedStatement pstm= null;		
		connBD = ConexionBD.AbrirConexionBD(infoUsu.getUname());
		try
		{
			String[] querys = new String[25];	
			querys = Cls_Querys.LimpiaListaQuerys(querys);	
			querys = Cls_Querys.ObtieneQuerys(54, ListaQuerys, querys, infoUsu);
			strQry = Cls_MetodosGlobales.obtieneSentenciaDeQrys(querys);
			pstm = connBD.prepareStatement("{call " + "CTRL_INGRESOS.usp_EXECUTE_QUERY(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			EjecutaQuerysBD.EjecutarQuery(querys[0], querys[1],querys[2], querys[3], querys[4], querys[5], querys[6],
														 querys[7], querys[8], querys[9],querys[10], querys[11], querys[12], querys[13], 
														 querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], 
														 querys[21], querys[22], querys[23], querys[24], infoUsu.getUname(),pstm, connBD);	
			eliminaRedondeoPrevio = true;
			Cls_Log.insertaLog(infoUsu, "", "",  "Elimina redondeos previos en el Corte de Caja.  "  +  "   QUERIES-54[" + strQry + "]");		
		}
		catch(Exception ex)
		{
			System.out.println("Error al eliminar redondeos previos.   "   +  "   QUERIES-54[" + strQry + "]");
		}
		finally
		{
			try {pstm.close();} catch (SQLException e) {e.printStackTrace();}
			try {connBD.close();} catch (SQLException e) {e.printStackTrace();}
		}
		return eliminaRedondeoPrevio;
	}

	public boolean generaMovimientoPorRedondeo(Usuario infoUsu, List<Querys> ListaQuerys, String tipoRedondeo, String importeRedondeo)
	{
		Connection connBD = null;
		String strQry="";
		PreparedStatement pstm= null;		
		connBD = ConexionBD.AbrirConexionBD(infoUsu.getUname());
		boolean aplicoMovimientoRedondeo = false;
		try
		{
			String[] querys = new String[25];	
			querys = Cls_Querys.LimpiaListaQuerys(querys);	
			
			if(tipoRedondeo.equals("Otro Ingreso"))
			{
				querys = Cls_Querys.ObtieneQuerys(52, ListaQuerys, querys, infoUsu);
				querys = InicializaQueryNumero52(querys, infoUsu, importeRedondeo);
			}
			else
			{
				querys = Cls_Querys.ObtieneQuerysAnidados(19, 20, 14, ListaQuerys, querys, infoUsu);
				querys = InicializaQueryNumero_19_20_14(querys, infoUsu,importeRedondeo);
			}
			strQry = Cls_MetodosGlobales.obtieneSentenciaDeQrys(querys);
			pstm = connBD.prepareStatement("{call " + "CTRL_INGRESOS.usp_EXECUTE_QUERY(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			ResultSet rs= EjecutaQuerysBD.EjecutarQuery(querys[0], querys[1],querys[2], querys[3], querys[4], querys[5], querys[6],
														 querys[7], querys[8], querys[9],querys[10], querys[11], querys[12], querys[13], 
														 querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], 
														 querys[21], querys[22], querys[23], querys[24], infoUsu.getUname(),pstm, connBD);	
			aplicoMovimientoRedondeo = true;
			Cls_Log.insertaLog(infoUsu, "", "",  "Aplico un redondeo al corte de caja [Tipo: " + tipoRedondeo+ ", Importe: " + importeRedondeo + "]    "    +  "   QUERIES-19-20-14[" + strQry + "]");	
		}
		catch(Exception ex)
		{
			String sError= ex.getMessage().toString();
			Cls_Log.insertaLog(infoUsu, "", "", "Error al aplicar redondeo: [" + sError + "]   "     +  "   QUERIES-19-20-14[" + strQry + "]");
		}
		finally
		{
			try {connBD.close();} catch (SQLException e) {e.printStackTrace();}
			try {pstm.close();} catch (SQLException e) {e.printStackTrace();}
		}
		return aplicoMovimientoRedondeo;
	}
	
	/****  INICIALIZA QUERYS ****/
	
	private  String[] InicializaQueryNumero52(String[] ListaQuerys, Usuario infoUsu, String importeRedondeo)
	{
		for (int i=0;i <ListaQuerys.length; i++)
		{
			ListaQuerys[i]= ListaQuerys[i].replace("{IMPORTE}", importeRedondeo);
			ListaQuerys[i]= ListaQuerys[i].replace("{USUARIO}", infoUsu.getCve_usuario());	
		}
		return ListaQuerys;
	}	
		
	private String[] InicializaQueryNumero_19_20_14(String[] ListaQuerys, Usuario infoUsu, String importeRedondeo)
	{
		for (int i=0;i <ListaQuerys.length; i++)
		{
			ListaQuerys[i]= ListaQuerys[i].replace("{CONCEPTO}", "2");
			ListaQuerys[i]= ListaQuerys[i].replace("{TEGRESO}", "6");
			ListaQuerys[i]= ListaQuerys[i].replace("{TIPO_EGRESO}", "6");
		
			ListaQuerys[i]= ListaQuerys[i].replace("{USUARIO_AUTORIZA}", infoUsu.getCve_usuario());
			ListaQuerys[i]= ListaQuerys[i].replace("{IMPORTE}", importeRedondeo);
			ListaQuerys[i]= ListaQuerys[i].replace("{BANCO}", "10");
			ListaQuerys[i]= ListaQuerys[i].replace("{BANCO_DEPOSITO}", "10");
			ListaQuerys[i]= ListaQuerys[i].replace("{REFERENCIA}", "REDONDEO-CORTE CAJA");
			ListaQuerys[i]= ListaQuerys[i].replace("{USUARIO}", infoUsu.getCve_usuario());
			ListaQuerys[i]= ListaQuerys[i].replace("'{FECHA_POLIZA}'", "CURDATE()");
			ListaQuerys[i]= ListaQuerys[i].replace("{COLECTIVA}", "0");
			 
		}
		return ListaQuerys;
	}

	private  String[] inicializaQuery18(String[] ListaQuerys, Usuario infoUsu, String insertCorteIXBanco, String insertCorteEXBanco, String insertCorteIXTipoPago, String  insertCorteIXFormaPago, String insertCorteEXTipo,String importeTotalCorte)
	{
		
		if(insertCorteIXTipoPago =="")
		{
			ListaQuerys = limpiarQuerysDeEgresos(4, ListaQuerys);
			ListaQuerys = limpiarQuerysDeEgresos(5, ListaQuerys);
			ListaQuerys = limpiarQuerysDeEgresos(6, ListaQuerys);
		}
		
		if(insertCorteEXTipo =="")
		{
			ListaQuerys = limpiarQuerysDeEgresos(3, ListaQuerys);
			ListaQuerys = limpiarQuerysDeEgresos(7, ListaQuerys);
		}
		
		for (int i=0;i <ListaQuerys.length; i++)
		{
			ListaQuerys[i]= ListaQuerys[i].replace("{TIPO_CORTE}", "1");
			ListaQuerys[i]= ListaQuerys[i].replace("{IMPORTE}", importeTotalCorte);
			ListaQuerys[i]= ListaQuerys[i].replace("{USUARIO}", infoUsu.getCve_usuario());
			ListaQuerys[i]= ListaQuerys[i].replace("{VALUES_BANCO_EGRESOS}", insertCorteEXBanco);
			ListaQuerys[i]= ListaQuerys[i].replace("{VALUES_BANCO_INGRESOS}", insertCorteIXBanco);
			ListaQuerys[i]= ListaQuerys[i].replace("{VALUES_TIPO_PAGO}", insertCorteIXTipoPago);
			ListaQuerys[i]= ListaQuerys[i].replace("{VALUES_FORMA_PAGO}", insertCorteIXFormaPago);
			ListaQuerys[i]= ListaQuerys[i].replace("{VALUES_EGRESOS}", insertCorteEXTipo);
			ListaQuerys[i]= ListaQuerys[i].replace("{ESTATUS}", "2");		
		}
		return ListaQuerys;
	}	
	
	private String[] limpiarQuerysDeEgresos(int query, String[] ListaQuerys)
	{
		for(int i = 0; i < ListaQuerys.length; i++)
		{
            if(i == query)
            {
            	ListaQuerys[i] = "";  
            	break;
            }
        }
		return ListaQuerys;
	}

}














