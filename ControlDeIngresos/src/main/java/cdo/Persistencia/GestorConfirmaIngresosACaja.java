package cdo.Persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import cdo.Datos.Catalogo_Formas_Pago;
import cdo.Datos.DetalleFolioHojaRuta;
import cdo.Datos.Ingresos;
import cdo.Datos.Querys;
import cdo.Datos.SemaforoIngresos;
import cdo.Datos.Usuario;
import cdo.util.Cls_CrearTicketDeIngresos;
import cdo.util.Cls_Log;
import cdo.util.Cls_MetodosGlobales;
import cdo.util.Cls_Querys;
import cdo.util.ConexionBD;
import cdo.util.EjecutaQuerysBD;

public class GestorConfirmaIngresosACaja {
		
	DecimalFormat formatoDecimal = new DecimalFormat("#,###.00");
	
	/***  VALIDA POLIZAS DE DIAS ANTERIORES ***/	
	public String validaSiSeGeneroPolizaDiaAnterior(Usuario infoUsu, List<Querys> ListaQuerys)
	{
		boolean existePolizaAnterior = false;
		String strQry="";
		String fechaUltimaPoliza="";
		Connection connBD = null;
		PreparedStatement pstm= null;		
		connBD = ConexionBD.AbrirConexionBD(infoUsu.getUname());	
		try
		{
			String[] querys = new String[25];
			querys = Cls_Querys.LimpiaListaQuerys(querys);			
			querys = Cls_Querys.ObtieneQuerys(99, ListaQuerys, querys, infoUsu);
			strQry = Cls_MetodosGlobales.obtieneSentenciaDeQrys(querys);			
			pstm = connBD.prepareStatement("{call " + "CTRL_INGRESOS.usp_EXECUTE_QUERY(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			ResultSet rs= EjecutaQuerysBD.EjecutarQuery(querys[0], querys[1],querys[2], querys[3], querys[4], querys[5], querys[6],
														 querys[7], querys[8], querys[9],querys[10], querys[11], querys[12], querys[13], 
														 querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], 
														 querys[21], querys[22], querys[23], querys[24], infoUsu.getUname(),pstm, connBD);
			
			if(rs != null)
			{
				existePolizaAnterior = validaPolDiasAnteriores(rs,  infoUsu, ListaQuerys);
				
				rs.beforeFirst();
				while(rs.next())
				{
					if(rs.getString("tipo").equals("POL"))
					{
						fechaUltimaPoliza = rs.getString("fecha");
					}
				}
			}
			Cls_Log.insertaLog(infoUsu, "", "", "Valida si existe polizas anteriores [Existe Poliza: " +existePolizaAnterior+ "] " + " QUERIES-99[" + strQry + "]" );
		}
		catch(Exception ex)
		{
			System.out.println("Error al validar polizas anteriores./Detalle:" + ex.getMessage().toString());
			Cls_Log.insertaLog(infoUsu, "", "", "Error al validar polizas anteriores [" + ex.getMessage().toString()+ "] " +  " QUERIES-99[" + strQry + "]");
		}
		finally
		{
			try {pstm.close();} catch (SQLException e) {e.printStackTrace();}
			try {connBD.close();} catch (SQLException e) {e.printStackTrace();}
		}
		return String.valueOf(existePolizaAnterior)+ "&" + fechaUltimaPoliza;
	}
	
	private boolean validaPolDiasAnteriores(ResultSet rs, Usuario infoUsu, List<Querys> ListaQuerys)
	{
		boolean polizasCorrectas = false;
		String fechaUltimaPoliza = "";
		String fechaValidaPoliza = "";
		List<String> fechasCalendario= new ArrayList<>();		
		try
		{
			if(rs != null)
			{
				rs.beforeFirst();
				while(rs.next())
				{
					if(rs.getString("tipo").equals("POL"))
					{
						fechaUltimaPoliza = rs.getString("fecha");
					}
					else if(rs.getString("tipo").equals("CAL"))
					{
						fechasCalendario.add(rs.getString("fecha")+ '#'+ rs.getString("status"));
					}
				}
			}	
			
			SimpleDateFormat sdformat = new SimpleDateFormat("yyyy-MM-dd");
			LocalDate fechaActual = LocalDate.now();
			String mes = (String.valueOf(fechaActual.getMonthValue()).length() > 1) ? String.valueOf(fechaActual.getMonthValue()) : "0" + fechaActual.getMonthValue();			
			String dia = (String.valueOf(fechaActual.getDayOfMonth()).length() > 1) ? String.valueOf(fechaActual.getDayOfMonth()) : "0" + fechaActual.getDayOfMonth();			
		    Date fActual = sdformat.parse(fechaActual.getYear() + "-" + mes + "-" + dia);
		    Date fPoliza = sdformat.parse(fechaUltimaPoliza);
			
		    if(fPoliza.compareTo(fActual) > 0) 
		    {
		    	polizasCorrectas= true;
		    }
		    else if(fPoliza.compareTo(fActual) ==  0) 
		    {
		    	polizasCorrectas= true;
		    }
		    else
		    {
		    	for(int i=0; i< fechasCalendario.size(); i++)
				{
					String[] datos = fechasCalendario.get(i).split("#");				
					if(!datos[1].toString().equals("*"))
					{
						if(validaQueExistanIngresosEnFechaPoliza(infoUsu,ListaQuerys,datos[0].toString()) == true)
						{
							fechaValidaPoliza = datos[0].toString();
							break;
						}
					}
				}
				if(fechaUltimaPoliza.equals(fechaValidaPoliza))
				{
					polizasCorrectas= true;
				}
		    }		    
		}
		catch(Exception ex)
		{
			System.out.println("Error al validar polizas anteriores: " + ex.getMessage().toString());
		}		
		return polizasCorrectas;
	}
	
	private boolean validaQueExistanIngresosEnFechaPoliza(Usuario infoUsu, List<Querys> ListaQuerys,String  fecha_poliza)
	{
		boolean existenIngresos = true;
		String strQry="";
		Connection connBD = null;
		PreparedStatement pstm= null;		
		connBD = ConexionBD.AbrirConexionBD(infoUsu.getUname());	
		try
		{
			String[] querys = new String[25];
			querys = Cls_Querys.LimpiaListaQuerys(querys);			
			querys = Cls_Querys.ObtieneQuerys(100, ListaQuerys, querys, infoUsu);
			querys = inicializaQueryNumero100( querys, infoUsu,fecha_poliza);
			strQry = Cls_MetodosGlobales.obtieneSentenciaDeQrys(querys);
			pstm = connBD.prepareStatement("{call " + "CTRL_INGRESOS.usp_EXECUTE_QUERY(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			ResultSet rs= EjecutaQuerysBD.EjecutarQuery(querys[0], querys[1],querys[2], querys[3], querys[4], querys[5], querys[6],
														 querys[7], querys[8], querys[9],querys[10], querys[11], querys[12], querys[13], 
														 querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], 
														 querys[21], querys[22], querys[23], querys[24], infoUsu.getUname(),pstm, connBD);
			 if(rs != null)
			 {
				 while(rs.next())
				 {
					 if(rs.getInt("numIngresos") <= 0)
					 {
						 existenIngresos= false;
					 }
				 }
			 }
			Cls_Log.insertaLog(infoUsu, "", "", "Valida si existen Ingresos con fecha poliza  [Fecha Poliza: " + fecha_poliza + ", ExistenIngreos: " +existenIngresos+ "]  " + " QUERIES-100[" + strQry + "]" );
		}
		catch(Exception ex)
		{
			System.out.println("Error al validar si existen Ingresos con fecha poliza./Detalle:" + ex.getMessage().toString());
			Cls_Log.insertaLog(infoUsu, "", "", "Error al validar si existen Ingresos con fecha poliza [" + ex.getMessage().toString()+ "]  "  + " QUERIES-100[" + strQry + "]" );
		}
		finally
		{
			try {pstm.close();} catch (SQLException e) {e.printStackTrace();}
			try {connBD.close();} catch (SQLException e) {e.printStackTrace();}
		}
		return existenIngresos;
	}
		
	/***  CONSULTA DE INGRESOS PENDIENTES O POR ESTATUS  ***/
	public List<Ingresos> consultaIngresosXParametro(Usuario infoUsu, List<Querys> ListaQuerys, Ingresos ICapturado, String tipoFecha)
	{
		List<Ingresos> listaIngresosCapturados = new ArrayList<>();
		String strQry="";
		Connection connBD = null;
		PreparedStatement pstm= null;		
		connBD = ConexionBD.AbrirConexionBD(infoUsu.getUname());
		try
		{
			String[] querys = new String[25];	
			querys = Cls_Querys.LimpiaListaQuerys(querys);	
			querys = Cls_Querys.ObtieneQuerys(6, ListaQuerys, querys, infoUsu);
			querys = inicializaQueryNumero6(querys, infoUsu, ICapturado, null, tipoFecha);
			strQry = Cls_MetodosGlobales.obtieneSentenciaDeQrys(querys);
			pstm = connBD.prepareStatement("{call " + "CTRL_INGRESOS.usp_EXECUTE_QUERY(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			ResultSet rs=  EjecutaQuerysBD.EjecutarQuery(querys[0], querys[1],querys[2], querys[3], querys[4], querys[5], querys[6],
														 querys[7], querys[8], querys[9],querys[10], querys[11], querys[12], querys[13], 
														 querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], 
														 querys[21], querys[22], querys[23], querys[24], infoUsu.getUname(),pstm, connBD);
			
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
			
			Cls_Log.insertaLog(infoUsu, "", "", "Consulta Ingresos por Parametros.  " + " QUERYS-6[" + strQry + "]" );
			
			if (rs != null)
				listaIngresosCapturados = crearListaDeICapturados(rs);
		}
		catch(Exception ex)
		{
			System.out.println("Error al consultar ingresos por parametro.");
			Cls_Log.insertaLog(infoUsu, "", "", "Error al consultar ingresos por parametro [" + ex.getMessage().toString()+ "] " + " QUERYS-6[" + strQry + "]");	
		}
		finally
		{
			try {pstm.close();} catch (SQLException e) {e.printStackTrace();}
			try {connBD.close();} catch (SQLException e) {e.printStackTrace();}
		}
		return listaIngresosCapturados;
	}
		
	public  List<Ingresos> crearListaDeICapturados(ResultSet rs)
	{
		List<Ingresos> listaIngresosCapturados = new ArrayList<>();
		try
		{
			while (rs.next())
	        {
				
				String[] arrayFecha = rs.getString("fecha_poliza").trim().split("-");
				String fechaPoliza = (arrayFecha.length >=3) ?  arrayFecha[2] + "/" + arrayFecha[1] + "/" + arrayFecha[0]:"";
				
				arrayFecha = rs.getString("fecha_corte").trim().split("-");				
				String fecha_corte =  (arrayFecha.length >=3 ) ? arrayFecha[2] + "/" + arrayFecha[1] + "/" + arrayFecha[0]:"";
				
				arrayFecha = rs.getString("fecha_creacion").trim().split("-");				
				String fecha_creacion =(arrayFecha.length >=3 ) ?   arrayFecha[2] + "/" + arrayFecha[1] + "/" + arrayFecha[0]:"";
				
				arrayFecha = rs.getString("fecha_caja").trim().split("-");				
				String fecha_caja =(arrayFecha.length >=3 ) ?   arrayFecha[2] + "/" + arrayFecha[1] + "/" + arrayFecha[0]:"";
				
				Ingresos ICapturado = new Ingresos(rs.getString("uname"), 
													rs.getString("uname_br"),
													rs.getInt("id_tipo_ingreso"), 
													rs.getString("nombre_pago"), 
													rs.getString("folio_caja"), 
													rs.getString("cve_usu"), 
													rs.getString("nombre_usu"),
													fecha_creacion, 
													fecha_creacion, 
													rs.getInt("estatus"), 
													rs.getString("descripcionEstatus"),
													Cls_MetodosGlobales.aplicarFormatoImporte(rs.getBigDecimal("importe")),
													Cls_MetodosGlobales.aplicarFormatoImporte(rs.getBigDecimal("efectivo")),
													Cls_MetodosGlobales.aplicarFormatoImporte(rs.getBigDecimal("cheque")),
													Cls_MetodosGlobales.aplicarFormatoImporte(rs.getBigDecimal("tarjeta")),
													Cls_MetodosGlobales.aplicarFormatoImporte(rs.getBigDecimal("debito")),
													Cls_MetodosGlobales.aplicarFormatoImporte(rs.getBigDecimal("porfechado")),
													Cls_MetodosGlobales.aplicarFormatoImporte(rs.getBigDecimal("transferencia")),
													Cls_MetodosGlobales.aplicarFormatoImporte(rs.getBigDecimal("notaCredito")),
													Cls_MetodosGlobales.aplicarFormatoImporte(rs.getBigDecimal("notaDevolucion")),
													rs.getInt("id_motivo_cancelacion"),
													rs.getString("motivo_cancelacion"),
													"","","","",
													rs.getString("folio_corte_caja"),
													rs.getString("folio_panamericano"),
													rs.getString("folio_poliza"),
													"",
													fechaPoliza,"",
													Cls_MetodosGlobales.aplicarFormatoImporte(rs.getBigDecimal("importe_original")),
													fecha_corte,
													rs.getString("hora_corte"),
													fecha_caja,
													rs.getString("hora_caja"),
													rs.getString("hora_creacion"));
				
				listaIngresosCapturados.add(ICapturado);
	        }
		}
		catch(Exception ex)
		{
			System.out.println("ERROR: " + ex.getMessage().toString());
		}
		
		return listaIngresosCapturados;
	}
		
	public List<SemaforoIngresos> consultaDatosDelSemaforo(Usuario infoUsu, List<Querys> ListaQuerys)
	{
		List<SemaforoIngresos> listaSemaforo = new ArrayList<>();
		Connection connBD = null;
		PreparedStatement pstm= null;		
		connBD = ConexionBD.AbrirConexionBD(infoUsu.getUname());
		try
		{
			String[] querys = new String[25];	
			querys = Cls_Querys.LimpiaListaQuerys(querys);	
			querys = Cls_Querys.ObtieneQuerys(23, ListaQuerys, querys, infoUsu);
			for (String string : querys) {
				System.out.println(string);
			}
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
			Cls_Log.insertaLog(infoUsu, "", "", "Error al consultar parametros del semaforo. [" + ex.getMessage().toString()+ "]");	
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
		
	/***  ACTUALIZA INGRESOS XID  ***/
	public boolean actualizaIngresoXID(Usuario infoUsu, List<Querys> ListaQuerys, Ingresos ICapturado, HttpSession session)
	{
		boolean actualizoIngresoXID_BD = false;
		String strQry="";
		Connection connBD = null;
		PreparedStatement pstm= null;		
		connBD = ConexionBD.AbrirConexionBD(infoUsu.getUname());		
		try
		{
			String[] querys = new String[25];	
			querys = Cls_Querys.LimpiaListaQuerys(querys);	
			querys = Cls_Querys.ObtieneQuerys(7, ListaQuerys, querys, infoUsu);
			querys = inicializaQueryNumero7( querys, infoUsu, ICapturado, session);
			strQry = Cls_MetodosGlobales.obtieneSentenciaDeQrys(querys);
			pstm = connBD.prepareStatement("{call " + "CTRL_INGRESOS.usp_EXECUTE_QUERY(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			EjecutaQuerysBD.EjecutarQuery(querys[0], querys[1],querys[2], querys[3], querys[4], querys[5], querys[6],
														 querys[7], querys[8], querys[9],querys[10], querys[11], querys[12], querys[13], 
														 querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], 
														 querys[21], querys[22], querys[23], querys[24], infoUsu.getUname(),pstm, connBD);
			
			actualizoIngresoXID_BD= true;
			
			String strLog = "id_tipo: " + ICapturado.getId_tipo_pago() +" , id_ingreso: " + ICapturado.getFolio_caja() + " ,  efectivo: " + ICapturado.getEfectivo() + " ,  cheque: " + ICapturado.getCheque() + " ,  tarjeta: " + ICapturado.getTarjeta() + " ,  debito: " + ICapturado.getDebito() + " ,  porfechado: " + ICapturado.getPorfechado() + " ,  transferencia: " + ICapturado.getTransferencia() + 
							" ,  notaCredito: " + ICapturado.getNotaCredito() + " ,  notaDevolucion: " + ICapturado.getNotaDevolucion();
			Cls_Log.insertaLog(infoUsu, "", "", "Actualizo Ingreso XID [" + strLog+ "]  " + " QUERIES-7[" + strQry + "]");	
		}
		catch(Exception ex)
		{
			System.out.println("Error al actualizar ingreso por Id.");
			Cls_Log.insertaLog(infoUsu, "", "", "Error al actualizar ingreso por Id [" + ex.getMessage().toString()+ "]  " + " QUERIES-7[" + strQry + "]");
		}
		finally
		{
			try {pstm.close();} catch (SQLException e) {e.printStackTrace();}
			try {connBD.close();} catch (SQLException e) {e.printStackTrace();}
		}
		
		return actualizoIngresoXID_BD;
	}
	
	/***  ACTUALIZA IMPORTE DE NOTA XID  ***/
	public boolean actualizaImporteNotaXID(Usuario infoUsu, List<Querys> ListaQuerys, Ingresos ICapturado, HttpSession session, String tipoNota)
	{
		boolean actualizoIngresoXID_BD = false;
		String strQry="";
		Connection connBD = null;
		PreparedStatement pstm= null;		
		connBD = ConexionBD.AbrirConexionBD(infoUsu.getUname());	
		try
		{
			String[] querys = new String[25];
			querys = Cls_Querys.LimpiaListaQuerys(querys);
			if(tipoNota.equals("Credito"))
			{		
				querys = Cls_Querys.ObtieneQuerys(9, ListaQuerys, querys, infoUsu);
				querys = inicializaQueryNumero9(querys, infoUsu, ICapturado, session);
			}
			else
			{
				querys = Cls_Querys.ObtieneQuerys(13, ListaQuerys, querys, infoUsu);
				querys = inicializaQueryNumero13( querys, infoUsu, ICapturado, session);
			}
			strQry = Cls_MetodosGlobales.obtieneSentenciaDeQrys(querys);
			pstm = connBD.prepareStatement("{call " + "CTRL_INGRESOS.usp_EXECUTE_QUERY(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			EjecutaQuerysBD.EjecutarQuery(querys[0], querys[1],querys[2], querys[3], querys[4], querys[5], querys[6],
														 querys[7], querys[8], querys[9],querys[10], querys[11], querys[12], querys[13], 
														 querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], 
														 querys[21], querys[22], querys[23], querys[24], infoUsu.getUname(),pstm, connBD);			
			actualizoIngresoXID_BD = true;		
			String strLog = "id_tipo: " + ICapturado.getId_tipo_pago() +" , id_ingreso: " + ICapturado.getFolio_caja() + " ,  NotaCre: " + ICapturado.getNotaCredito() + " ,  UsuCredito: " + ICapturado.getCve_usu_nota() + " ,  NotaDev: " + ICapturado.getNotaDevolucion() + " ,  Observaciones: " + ICapturado.getObservaciones_nota() ;
			Cls_Log.insertaLog(infoUsu, "", "", "Actualizo importe de nota XID [" +strLog+ "]  "  + " QUERIES-9-13[" + strQry + "]");
		}
		catch(Exception ex)
		{
			System.out.println("Error al actualizar importe de nota por Id../Detalle:" + ex.getMessage().toString());
			Cls_Log.insertaLog(infoUsu, "", "", "Error al actualizar importe de nota por Id [" + ex.getMessage().toString()+ "]  " + " QUERIES-9-13[" + strQry + "]");
		}
		finally
		{
			try {pstm.close();} catch (SQLException e) {e.printStackTrace();}
			try {connBD.close();} catch (SQLException e) {e.printStackTrace();}
		}
		return actualizoIngresoXID_BD;
	}
	
	/***  CANCELA IMPORTE DE NOTA XID  ***/
	public boolean cancelaImporteNotaXID(Usuario infoUsu, List<Querys> ListaQuerys, Ingresos ICapturado, HttpSession session, String tipoNota)
	{
		boolean canceloImpNota_BD = false;
		String strQry="";
		int numeroQry = (tipoNota.equals("Credito")) ? 10: 11;
		Connection connBD = null;
		PreparedStatement pstm= null;		
		connBD = ConexionBD.AbrirConexionBD(infoUsu.getUname());	
		try
		{
			String[] querys = new String[25];	
			querys = Cls_Querys.LimpiaListaQuerys(querys);
			querys = Cls_Querys.ObtieneQuerys(numeroQry, ListaQuerys, querys, infoUsu);
			querys =  (tipoNota.equals("Credito")) ? inicializaQueryNumero10(querys, infoUsu, ICapturado, session) : inicializaQueryNumero11(querys, infoUsu, ICapturado, session);
			strQry = Cls_MetodosGlobales.obtieneSentenciaDeQrys(querys);
			pstm = connBD.prepareStatement("{call " + "CTRL_INGRESOS.usp_EXECUTE_QUERY(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			EjecutaQuerysBD.EjecutarQuery(querys[0], querys[1],querys[2], querys[3], querys[4], querys[5], querys[6],
														 querys[7], querys[8], querys[9],querys[10], querys[11], querys[12], querys[13], 
														 querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], 
														 querys[21], querys[22], querys[23], querys[24], infoUsu.getUname(),pstm, connBD);
			
			canceloImpNota_BD = true;
			
			String strLog = "id_tipo: " + ICapturado.getId_tipo_pago() +" , id_ingreso: " + ICapturado.getFolio_caja() + " ,  NotaCre: " + ICapturado.getNotaCredito() + " ,  UsuCredito: " + ICapturado.getCve_usu_nota() + " ,  NotaDev: " + ICapturado.getNotaDevolucion() + " ,  Observaciones: " + ICapturado.getObservaciones_nota() ;
			Cls_Log.insertaLog(infoUsu, "", "", "Cancelo importe de nota XID [" +strLog+ "]  "  + " QUERIES-10-11[" + strQry + "]");
		}
		catch(Exception ex){
			System.out.println("Error al cancelar importe de nota por Id.");
			Cls_Log.insertaLog(infoUsu, "", "", "Error al cancelar importe de nota por Id [" + ex.getMessage().toString()+ "]  " + " QUERIES-10-11[" + strQry + "]");
		}
		finally
		{
			try {pstm.close();} catch (SQLException e) {e.printStackTrace();}
			try {connBD.close();} catch (SQLException e) {e.printStackTrace();}
		}
		return canceloImpNota_BD;
	}
	
	/***  CANCELA INGRESO XID  ***/
	public boolean cancelaIngresoXID(Usuario infoUsu, List<Querys> ListaQuerys, Ingresos ICapturado, HttpSession session)
	{
		boolean canceloIngresoXID_BD = false;
		String strQry="";
		Connection connBD = null;
		PreparedStatement pstm= null;		
		connBD = ConexionBD.AbrirConexionBD(infoUsu.getUname());
		try
		{
			String[] querys = new String[25];	
			querys = Cls_Querys.LimpiaListaQuerys(querys);	
			querys = Cls_Querys.ObtieneQuerys(8, ListaQuerys, querys, infoUsu);
			querys = inicializaQueryNumero8( querys, infoUsu, ICapturado, session);
			strQry = Cls_MetodosGlobales.obtieneSentenciaDeQrys(querys);
			pstm = connBD.prepareStatement("{call " + "CTRL_INGRESOS.usp_EXECUTE_QUERY(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			EjecutaQuerysBD.EjecutarQuery(querys[0], querys[1],querys[2], querys[3], querys[4], querys[5], querys[6],
														 querys[7], querys[8], querys[9],querys[10], querys[11], querys[12], querys[13], 
														 querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], 
														 querys[21], querys[22], querys[23], querys[24], infoUsu.getUname(),pstm, connBD);
			
			canceloIngresoXID_BD= true;
			String strLog = "id_tipo: " + ICapturado.getId_tipo_pago() +" , id_ingreso: " + ICapturado.getFolio_caja()  +" , motivoCancelacion: " + ICapturado.getId_motivo_cancelacion();
			Cls_Log.insertaLog(infoUsu, "", "", "Cancelo ingreso  XID [" +strLog+ "]  " + " QUERIES-8[" + strQry + "]");
			
		}
		catch(Exception ex)
		{
			System.out.println("Error al cancelar ingreso por Id.");
			Cls_Log.insertaLog(infoUsu, "", "", "Error al cancelar ingreso por Id [" + ex.getMessage().toString()+ "]  " + " QUERIES-8[" + strQry + "]");
		}
		finally
		{
			try {pstm.close();} catch (SQLException e) {e.printStackTrace();}
			try {connBD.close();} catch (SQLException e) {e.printStackTrace();}
		}
		return canceloIngresoXID_BD;
	}
		
	/***  REVERTIR INGRESO XID  ***/
	public boolean revertirIngresoXID(Usuario infoUsu, List<Querys> ListaQuerys, Ingresos ICapturado, HttpSession session)
	{
		boolean revertirIngresoXID_BD = false;
		String strQry="";
		Connection connBD = null;
		PreparedStatement pstm= null;		
		connBD = ConexionBD.AbrirConexionBD(infoUsu.getUname());
		try
		{
			String[] querys = new String[25];	
			querys = Cls_Querys.LimpiaListaQuerys(querys);	
			querys = Cls_Querys.ObtieneQuerys(55, ListaQuerys, querys, infoUsu);
			querys = inicializaQueryNumero55( querys, infoUsu, ICapturado, session);
			strQry = Cls_MetodosGlobales.obtieneSentenciaDeQrys(querys);
			pstm = connBD.prepareStatement("{call " + "CTRL_INGRESOS.usp_EXECUTE_QUERY(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			EjecutaQuerysBD.EjecutarQuery(querys[0], querys[1],querys[2], querys[3], querys[4], querys[5], querys[6],
														 querys[7], querys[8], querys[9],querys[10], querys[11], querys[12], querys[13], 
														 querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], 
														 querys[21], querys[22], querys[23], querys[24], infoUsu.getUname(),pstm, connBD);
			revertirIngresoXID_BD = true;
			String strLog = "id_tipo: " + ICapturado.getId_tipo_pago() +" , id_ingreso: " + ICapturado.getFolio_caja();
			Cls_Log.insertaLog(infoUsu, "", "", "Revierte ingreso XID [" +strLog+ "] " + " QUERIES-55[" + strQry + "]");
			Cls_Log.insertaLog(infoUsu, "", "", "Se eliminan los Cheques Posfechados. [" +strLog+ "]");
		}
		catch(Exception ex)
		{
			System.out.println("Error al revertir ingreso por Id.");
			Cls_Log.insertaLog(infoUsu, "", "", "Error al revertir ingreso por Id [" + ex.getMessage().toString()+ "] " + " QUERIES-55[" + strQry + "]");
		}
		finally
		{
			try {pstm.close();} catch (SQLException e) {e.printStackTrace();}
			try {connBD.close();} catch (SQLException e) {e.printStackTrace();}
		}
		return revertirIngresoXID_BD;
	}
		
	/***  CONFIRMA INGRESO XID  ***/
	public Ingresos confirmaIngresoXID(Usuario infoUsu, List<Querys> ListaQuerys, Ingresos ICapturado, HttpSession session, boolean aplicacomision,int banco, int bancoDeposito)
	{
		boolean confirmoIngresoXID_BD = false;
		String strQry="";
		Connection connBD = null;
		PreparedStatement pstm= null;		
		connBD = ConexionBD.AbrirConexionBD(infoUsu.getUname());
		try
		{
			String[] querys = new String[25];	
			querys = Cls_Querys.LimpiaListaQuerys(querys);	
			querys = Cls_Querys.ObtieneQuerys(24, ListaQuerys, querys, infoUsu);
			querys = inicializaQueryNumero24( querys, infoUsu, ICapturado,banco, bancoDeposito, aplicacomision);
			strQry = Cls_MetodosGlobales.obtieneSentenciaDeQrys(querys);
			pstm = connBD.prepareStatement("{call " + "CTRL_INGRESOS.usp_EXECUTE_QUERY(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			ResultSet rs = EjecutaQuerysBD.EjecutarQuery(querys[0], querys[1],querys[2], querys[3], querys[4], querys[5], querys[6],
														 querys[7], querys[8], querys[9],querys[10], querys[11], querys[12], querys[13], 
														 querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], 
														 querys[21], querys[22], querys[23], querys[24], infoUsu.getUname(),pstm, connBD);
			
			
			String strLog = "id_tipo: " + ICapturado.getId_tipo_pago() + " , id_ingreso: " + ICapturado.getFolio_caja();
			Cls_Log.insertaLog(infoUsu, "", "", "Confirma ingreso XID [" +strLog+ "]  "  + " QUERIES-24[" + strQry + "]");
			
			
			if(String.valueOf(ICapturado.getId_tipo_pago()).equals("3"))
			{
				pstm = connBD.prepareStatement("{call " + "CTRL_INGRESOS.usp_EXECUTE_QUERY(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
				querys = Cls_Querys.LimpiaListaQuerys(querys);	
				querys = Cls_Querys.ObtieneQuerys(107, ListaQuerys, querys, infoUsu);
				querys = inicializaQueryNumero107( querys, infoUsu, ICapturado);
				strQry = Cls_MetodosGlobales.obtieneSentenciaDeQrys(querys);
				EjecutaQuerysBD.EjecutarQuery(querys[0], querys[1],querys[2], querys[3], querys[4], querys[5], querys[6],
															 querys[7], querys[8], querys[9],querys[10], querys[11], querys[12], querys[13], 
															 querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], 
															 querys[21], querys[22], querys[23], querys[24], infoUsu.getUname(),pstm, connBD);
				Cls_Log.insertaLog(infoUsu, "", "", "Confirma ingreso genera complemento de Ticket Contado XID [" +strLog+ "]  "  + " QUERIES-107[" + strQry + "]");
				
			}
			else if(String.valueOf(ICapturado.getId_tipo_pago()).equals("5"))
			{
				pstm = connBD.prepareStatement("{call " + "CTRL_INGRESOS.usp_EXECUTE_QUERY(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
				querys = Cls_Querys.LimpiaListaQuerys(querys);	
				querys = Cls_Querys.ObtieneQuerys(106, ListaQuerys, querys, infoUsu);
				querys = inicializaQueryNumero106( querys, infoUsu, ICapturado);
				strQry = Cls_MetodosGlobales.obtieneSentenciaDeQrys(querys);
				ResultSet rsFactura = EjecutaQuerysBD.EjecutarQuery(querys[0], querys[1],querys[2], querys[3], querys[4], querys[5], querys[6],
															 querys[7], querys[8], querys[9],querys[10], querys[11], querys[12], querys[13], 
															 querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], 
															 querys[21], querys[22], querys[23], querys[24], infoUsu.getUname(),pstm, connBD);
				Cls_Log.insertaLog(infoUsu, "", "", "Confirma ingreso genera complemento de Factura Manual XID [" +strLog+ "]  "  + " QUERIES-106[" + strQry + "]");
				if (rsFactura != null)
				{
					while(rsFactura.next())
					{
						ICapturado.setFactura(rsFactura.getString("num_fac"));
					}
				}
				else
				{
					ICapturado.setFactura("");
				}
			}
			else
			{
				if (rs != null)
				{
					while(rs.next())
					{
						ICapturado.setFactura(rs.getString("factura"));
					}
				}
				else
				{
					ICapturado.setFactura("");
				}
			}
			
			confirmoIngresoXID_BD= true;
			
		}
		catch(Exception ex)
		{
			System.out.println("Error al confirmar ingreso por Id.");
			Cls_Log.insertaLog(infoUsu, "", "", "Error al confirmar ingreso por Id [" + ex.getMessage().toString()+ "]  " + " QUERIES[" + strQry + "]" );
		}
		finally
		{
			try {pstm.close();} catch (SQLException e) {e.printStackTrace();}
			try {connBD.close();} catch (SQLException e) {e.printStackTrace();}
		}
		return ICapturado;
	}
		
	/***  IMPRIME TICKETS ***/
	public boolean validaSiLaReimpresionaplicaComisionDeTarjeta(Usuario infoUsu, List<Querys> ListaQuerys, Ingresos ICapturado, HttpSession session)
	{
		boolean aplicaComisionXTarjeta = false;
		String strQry="";
		Connection connBD = null;
		PreparedStatement pstm= null;		
		connBD = ConexionBD.AbrirConexionBD(infoUsu.getUname());
		try
		{
			String[] querys = new String[25];	
			querys = Cls_Querys.LimpiaListaQuerys(querys);	
			querys = Cls_Querys.ObtieneQuerys(25, ListaQuerys, querys, infoUsu);
			querys = inicializaQueryNumero25( querys, infoUsu, ICapturado);
			pstm = connBD.prepareStatement("{call " + "CTRL_INGRESOS.usp_EXECUTE_QUERY(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			strQry = Cls_MetodosGlobales.obtieneSentenciaDeQrys(querys);
			ResultSet rs= EjecutaQuerysBD.EjecutarQuery(querys[0], querys[1],querys[2], querys[3], querys[4], querys[5], querys[6],
														 querys[7], querys[8], querys[9],querys[10], querys[11], querys[12], querys[13], 
														 querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], 
														 querys[21], querys[22], querys[23], querys[24], infoUsu.getUname(),pstm, connBD);
			if(rs !=null)
			{
				while(rs.next())
				{
					if(Integer.parseInt(rs.getString("folio_ingreso")) > 0)
						aplicaComisionXTarjeta= true;
				}
			}
			
			String strLog = "id_tipo: " + ICapturado.getId_tipo_pago() +" , id_ingreso: " + ICapturado.getFolio_caja();
			Cls_Log.insertaLog(infoUsu, "", "", "Validar reimpresion de ingreso  XID [" +strLog+ "]  "  + " QUERIES-25[" + strQry + "]");
		}
		catch(Exception ex)
		{
			System.out.println("Error al validar reimpresion de ingreso por Id.");
			Cls_Log.insertaLog(infoUsu, "", "", "Error al validar reimpresion de ingreso por Id [" + ex.getMessage().toString()+ "]  " +  " QUERIES-25[" + strQry + "]" );
		}
		finally
		{
			try {pstm.close();} catch (SQLException e) {e.printStackTrace();}
			try {connBD.close();} catch (SQLException e) {e.printStackTrace();}
		}
		return aplicaComisionXTarjeta;
	}
		
	public void crearArchivoTxtDelTicket(Usuario infoUsu,Ingresos ICapturado, int tipo, boolean aplicacomision, String impresora,HttpSession session)
	{
		Cls_CrearTicketDeIngresos clsTicket=new Cls_CrearTicketDeIngresos();
		clsTicket.crearArchivoTxtDelTicket(infoUsu,ICapturado, tipo, aplicacomision, impresora);
		if(tipo == 1)
		{
			Cls_Log.insertaLog(infoUsu, "", "", "Reimprime tiket  de  ingreso  XID [" +ICapturado+ "]");
		}
	}
	
	private boolean  validaSiElIngresoSeModifico(Ingresos ICapturado, HttpSession session)
	{
		boolean modificoIngreso= false;		
		String idModificados = String.valueOf(session.getAttribute("IdsContadosModificados"));
		String arrayIModificados[] = idModificados.split("/");
		
		for(int i=0; i < arrayIModificados.length; i++)
		{
			if(ICapturado.getFolio_caja().equals(arrayIModificados[i]))
			{
				modificoIngreso= true;
				break;
			}
		}
		return modificoIngreso;
	}
		
	/***  CONFIRMA CHEQUES PODFECHADOS  ***/
	public boolean confirmaChequePorfechado(Usuario infoUsu, List<Querys> ListaQuerys, Ingresos ICapturado, HttpSession session)
	{
		boolean confirmaChequePorcfechado=false;
		String strQry="";
		String sentenciaLog ="";
		Connection connBD=null;
		PreparedStatement pstm=null;
		connBD= ConexionBD.AbrirConexionBD(infoUsu.getUname());
		try
		{
			String []querys = new String[25];
			querys = Cls_Querys.LimpiaListaQuerys(querys);
			querys = Cls_Querys.ObtieneQuerys(64, ListaQuerys, querys, infoUsu);
			querys = inicializaQueryNumero64(querys,infoUsu, ICapturado);
			strQry = Cls_MetodosGlobales.obtieneSentenciaDeQrys(querys);
			pstm = connBD.prepareStatement("{call " + "CTRL_INGRESOS.usp_EXECUTE_QUERY(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			ResultSet rs =EjecutaQuerysBD.EjecutarQuery(querys[0], querys[1],querys[2], querys[3], querys[4], querys[5], querys[6],
														 querys[7], querys[8], querys[9],querys[10], querys[11], querys[12], querys[13], 
														 querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], 
														 querys[21], querys[22], querys[23], querys[24], infoUsu.getUname(),pstm, connBD);	
			
			confirmaChequePorcfechado = true;			
			if(rs != null)
			{
				sentenciaLog ="Se dan de alta los cheques porfechados.  ";
				while(rs.next())
				{
					sentenciaLog += "[Cheque:" + rs.getString("referencia") + ", Folio:"+ rs.getString("folio_caja") + ", Cliente:"+ rs.getString("num_cte") + ", Importe:"+ rs.getString("importe")  + ", Banco:"+ rs.getString("cve_banco_deposito") + "] , ";
				}
			}
			Cls_Log.insertaLog(infoUsu, "", "", sentenciaLog  +  " QUERIES-64[" + strQry + "]"  );
		}
		catch(Exception ex)
		{
			System.out.println("Error al confirmar cheque porfechado.");
			Cls_Log.insertaLog(infoUsu, "", "", "Error al confirmar cheque porfechado [" + ex.getMessage().toString()+ "]  " +  " QUERIES-64[" + strQry + "]" );
		}
		return confirmaChequePorcfechado;
	}
	
	/***  CONFIRMA CHEQUES NOMINATIVO  ***/
	public boolean confirmaChequeNominativo(Usuario infoUsu, List<Querys> ListaQuerys, Ingresos ICapturado, HttpSession session)
	{
		boolean confirmaChequeNominativo=false;
		String strQry="";
		String sentenciaLog ="";
		Connection connBD=null;
		PreparedStatement pstm=null;
		connBD= ConexionBD.AbrirConexionBD(infoUsu.getUname());
		try
		{
			String []querys = new String[25];
			querys = Cls_Querys.LimpiaListaQuerys(querys);
			querys = Cls_Querys.ObtieneQuerys(86, ListaQuerys, querys, infoUsu);
			querys = inicializaQueryNumero86(querys,infoUsu, ICapturado);	
			strQry = Cls_MetodosGlobales.obtieneSentenciaDeQrys(querys);
			pstm = connBD.prepareStatement("{call " + "CTRL_INGRESOS.usp_EXECUTE_QUERY(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			ResultSet rs =EjecutaQuerysBD.EjecutarQuery(querys[0], querys[1],querys[2], querys[3], querys[4], querys[5], querys[6],
														 querys[7], querys[8], querys[9],querys[10], querys[11], querys[12], querys[13], 
														 querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], 
														 querys[21], querys[22], querys[23], querys[24], infoUsu.getUname(),pstm, connBD);	
			
			confirmaChequeNominativo = true;			
			if(rs != null)
			{
				sentenciaLog ="Se dan de alta los cheques nominativos.  ";
				while(rs.next())
				{
					sentenciaLog += "[Cheque:" + rs.getString("referencia") + ", Folio:"+ rs.getString("folio_caja") + ", Cliente:"+ rs.getString("num_cte") + ", Importe:"+ rs.getString("importe")  + ", Banco:"+ rs.getString("cve_banco_deposito") + "] , ";
				}
			}
			Cls_Log.insertaLog(infoUsu, "", "", sentenciaLog  +  "  QUERIES-86[" + strQry + "]");
		}
		catch(Exception ex)
		{
			System.out.println("Error al confirmar cheque nominativos: " + ex.getMessage().toString());
			Cls_Log.insertaLog(infoUsu, "", "", "Error al confirmar cheque nominativos [" + ex.getMessage().toString()+ "]  "  +  " QUERIES-86[" + strQry + "]");
		}
		return confirmaChequeNominativo;
	}
	
	/***  ACTUALIZA FECHA POLIZA XID ***/
	public boolean actualizaFechaPolizaXID(Usuario infoUsu,List<Querys> ListaQuerys,Ingresos ICapturado)
	{
		boolean actualizoIngresoXID_BD = false;
		String strQry="";
		Connection connBD = null;
		PreparedStatement pstm= null;		
		connBD = ConexionBD.AbrirConexionBD(infoUsu.getUname());	
		try
		{
			String[] querys = new String[25];
			querys = Cls_Querys.LimpiaListaQuerys(querys);
			querys = Cls_Querys.ObtieneQuerys(26, ListaQuerys, querys, infoUsu);
			querys = inicializaQueryNumero26( querys, infoUsu, ICapturado);
			strQry = Cls_MetodosGlobales.obtieneSentenciaDeQrys(querys);
			pstm = connBD.prepareStatement("{call " + "CTRL_INGRESOS.usp_EXECUTE_QUERY(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			EjecutaQuerysBD.EjecutarQuery(querys[0], querys[1],querys[2], querys[3], querys[4], querys[5], querys[6],
														 querys[7], querys[8], querys[9],querys[10], querys[11], querys[12], querys[13], 
														 querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], 
														 querys[21], querys[22], querys[23], querys[24], infoUsu.getUname(),pstm, connBD);	
		
			actualizoIngresoXID_BD = true;
			Cls_Log.insertaLog(infoUsu, "", "", "Actualizo la fecha de poliza de Ingreso por Id [" + ICapturado + "]  " + "  QUERIES-26[" + strQry + "]");
		}
		catch(Exception ex)
		{
			System.out.println("Error al actualizar la fecha de poliza por Id../Detalle:" + ex.getMessage().toString());
			Cls_Log.insertaLog(infoUsu, "", "", "Error al actualizar fecha de poliza por Id [" + ex.getMessage().toString()+ "]  " +  "  QUERIES-26[" + strQry + "]");
		}
		finally
		{
			try {pstm.close();} catch (SQLException e) {e.printStackTrace();}
			try {connBD.close();} catch (SQLException e) {e.printStackTrace();}
		}
		return actualizoIngresoXID_BD;
	}
		
	/***  SECCION HOJA DE RUTA MANUALES  ***/
	public boolean existenciaFolioHojaRuta(Usuario infoUsu, List<Querys> ListaQuerys, String folio) 
	{
		boolean existenciaFolioHojaRuta = false;
		Connection connBD = null;
		PreparedStatement pstm= null;		
		connBD = ConexionBD.AbrirConexionBD(infoUsu.getUname());
		try
		{
			String[] querys = new String[25];	
			querys = Cls_Querys.LimpiaListaQuerys(querys);	
			querys = Cls_Querys.ObtieneQuerys(34, ListaQuerys, querys, infoUsu);
			querys = inicializaQueryNumero34(querys, infoUsu,folio);
			pstm = connBD.prepareStatement("{call " + "CTRL_INGRESOS.usp_EXECUTE_QUERY(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			ResultSet rs = EjecutaQuerysBD.EjecutarQuery(querys[0], querys[1],querys[2], querys[3], querys[4], querys[5], querys[6],
														 querys[7], querys[8], querys[9],querys[10], querys[11], querys[12], querys[13], 
														 querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], 
														 querys[21], querys[22], querys[23], querys[24], infoUsu.getUname(),pstm, connBD);

			while (rs.next()) 
			{
				if(!rs.getString("folio").equals("0"))
				{
					existenciaFolioHojaRuta=true;
				}
			}
			Cls_Log.insertaLog(infoUsu, "", "", "Busca Hoja de Ruta Manual [ Folio: " + folio + ", Existe: " + existenciaFolioHojaRuta + "]");
		}
		catch(Exception ex)
		{
			System.out.println("Error al ejecutar query 34.");
		}
		finally
		{
			try {pstm.close();} catch (SQLException e) {e.printStackTrace();}
			try {connBD.close();} catch (SQLException e) {e.printStackTrace();}
		}
		return existenciaFolioHojaRuta;
	}
		
	public boolean insertarHojaDeRuTa(Usuario infoUsu, List<Querys> ListaQuerys,String folio) {
		
		boolean HojaRutaInsertada = false;
		Connection connBD = null;
		PreparedStatement pstm= null;		
		connBD = ConexionBD.AbrirConexionBD(infoUsu.getUname());
		
		try
		{
			String[] querys = new String[25];	
			querys = Cls_Querys.LimpiaListaQuerys(querys);	
			
			querys = Cls_Querys.ObtieneQuerys(33, ListaQuerys, querys, infoUsu);
			querys = inicializaQueryNumero33(querys, infoUsu,folio);
		
			pstm = connBD.prepareStatement("{call " + "CTRL_INGRESOS.usp_EXECUTE_QUERY(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			EjecutaQuerysBD.EjecutarQuery(querys[0], querys[1],querys[2], querys[3], querys[4], querys[5], querys[6],
														 querys[7], querys[8], querys[9],querys[10], querys[11], querys[12], querys[13], 
														 querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], 
														 querys[21], querys[22], querys[23], querys[24], infoUsu.getUname(),pstm, connBD);
		
			Cls_Log.insertaLog(infoUsu, "", "", "Inserta Hoja de Ruta manual  [ Folio: " + folio +  "]");
			HojaRutaInsertada=true;
		}
		catch(Exception ex)
		{
			System.out.println("Error al ejecutar query 33.");
		}
		finally
		{
			try {pstm.close();} catch (SQLException e) {e.printStackTrace();}
			try {connBD.close();} catch (SQLException e) {e.printStackTrace();}
		}
		return HojaRutaInsertada;
	}
		
	/***  SECCION FACTURAS CREDITO MANUALES  ***/	
	public boolean validaSiExisteFacturaCreditoEnElDia(Usuario infoUsu,List<Querys> ListaQuerys,String facturaLarga)
	{
		boolean existeFactura = true;
		String strQry="";
		Connection connBD=null;
		PreparedStatement pstm = null;
		connBD= ConexionBD.AbrirConexionBD(infoUsu.getUname());
		try
		{
			String[] querys = new String[25];
			querys = Cls_Querys.LimpiaListaQuerys(querys);
			querys = Cls_Querys.ObtieneQuerys(101, ListaQuerys, querys, infoUsu);
			querys = inicializaQueryNumero101( querys, infoUsu, facturaLarga);
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
					if(rs.getString("numFacturas").equals("0"))
					{
						existeFactura = false;
					}
					else
					{
						Cls_Log.insertaLog(infoUsu, "", "", "Error, la factura manual ya fue agregada. Detalle:[ " + facturaLarga + " ]  " + "  QUERIES-101[" + strQry + "]");					
					}
				}
			}
		}
		catch(Exception ex)
		{
			System.out.println("Error al buscar la factura credito manual../Detalle:" + ex.getMessage().toString());
			Cls_Log.insertaLog(infoUsu, "", "", "Error al buscar la factura credito manual Detalle:[ " + ex.getMessage().toString()+ " ]  " + "  QUERIES-101[" + strQry + "]");
		}
		finally
		{
			try{pstm.close();}catch(SQLException e) {e.printStackTrace();}
			try {connBD.close();}catch(SQLException e) {e.printStackTrace();}
		}
		return existeFactura;
	}
		
	public boolean validaSiLaFacturaEsValida(Usuario infoUsu,List<Querys> ListaQuerys,String facturaLarga, String formaPagoFac)
	{
		boolean existeFacturaBD = false;
		String strQry="";
		Connection connBD = null;
		PreparedStatement pstm= null;		
		connBD = ConexionBD.AbrirConexionBD(infoUsu.getUname());	
		try
		{
			String[] querys = new String[25];
			querys = Cls_Querys.LimpiaListaQuerys(querys);			
			if(infoUsu.getUname().equals(infoUsu.getUname_br()))
			{
				querys = Cls_Querys.ObtieneQuerys(60, ListaQuerys, querys, infoUsu);
			}
			else
			{
				querys = Cls_Querys.ObtieneQuerys(98, ListaQuerys, querys, infoUsu);
			}
			querys = inicializaQueryNumero60( querys, infoUsu, facturaLarga);
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
					if(!rs.getString("num_facturas").equals("0"))
					{
						insertaFacturaManualmente(infoUsu,ListaQuerys,facturaLarga, formaPagoFac);
						existeFacturaBD = true;
					}	
				}
			}
			
			Cls_Log.insertaLog(infoUsu, "", "", "Busca la factura de credito manual. [" + facturaLarga + "]  "  + "  QUERIES-60-98[" + strQry + "]");
		}
		catch(Exception ex)
		{
			System.out.println("Error al buscar la factura credito manual../Detalle:" + ex.getMessage().toString());
			Cls_Log.insertaLog(infoUsu, "", "", "Error al buscar la factura credito manual Detalle:[ " + ex.getMessage().toString()+ " ]  " +  "  QUERIES-60-98[" + strQry + "]");
		}
		finally
		{
			try {pstm.close();} catch (SQLException e) {e.printStackTrace();}
			try {connBD.close();} catch (SQLException e) {e.printStackTrace();}
		}
		return existeFacturaBD;
	}
		
	public boolean insertaFacturaManualmente(Usuario infoUsu,List<Querys> ListaQuerys,String facturaLarga, String formaPagoFac)
	{
		boolean insertaFacturaBD = false;
		String strQry="";
		Connection connBD = null;
		PreparedStatement pstm= null;		
		connBD = ConexionBD.AbrirConexionBD(infoUsu.getUname());	
		try
		{
			String[] querys = new String[25];
			querys = Cls_Querys.LimpiaListaQuerys(querys);
			querys = Cls_Querys.ObtieneQuerys(61, ListaQuerys, querys, infoUsu);
			querys = inicializaQueryNumero61( querys, infoUsu, facturaLarga, formaPagoFac);	
			strQry = Cls_MetodosGlobales.obtieneSentenciaDeQrys(querys);
			pstm = connBD.prepareStatement("{call " + "CTRL_INGRESOS.usp_EXECUTE_QUERY(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			EjecutaQuerysBD.EjecutarQuery(querys[0], querys[1],querys[2], querys[3], querys[4], querys[5], querys[6],
														 querys[7], querys[8], querys[9],querys[10], querys[11], querys[12], querys[13], 
														 querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], 
														 querys[21], querys[22], querys[23], querys[24], infoUsu.getUname(),pstm, connBD);	
			insertaFacturaBD = true;
			Cls_Log.insertaLog(infoUsu, "", "", "Inserta factura de credito manual. [" + facturaLarga + "]  " + "  QUERIES-61[" + strQry + "]");
		}
		catch(Exception ex)
		{
			System.out.println("Error al insertar la factura credito manual../Detalle:" + ex.getMessage().toString());
			Cls_Log.insertaLog(infoUsu, "", "", "Error al insertar la factura credito manual Detalle:[ " + ex.getMessage().toString()+ " ]  "  +  "  QUERIES-61[" + strQry + "]");
		}
		finally
		{
			try {pstm.close();} catch (SQLException e) {e.printStackTrace();}
			try {connBD.close();} catch (SQLException e) {e.printStackTrace();}
		}
		return insertaFacturaBD;
		
	}
	
	/***  GENERA SENTENCIAS DE IMPORTES  ***/
	private String  generaSentenciaDeImportesFP(Ingresos ICapturado, HttpSession session)
	{
		String StrImportes = "";
		List<Catalogo_Formas_Pago> listaFP = (List<Catalogo_Formas_Pago>) session.getAttribute("listaFormas_Pago");
		
		for(int i = 0; i < listaFP.size(); i++) 
		{
			Catalogo_Formas_Pago fp =listaFP.get(i);
			
			if(fp.getNombre_forma_pago().contains("EFECTIVO"))
				 if(Double.parseDouble(ICapturado.getEfectivo()) > 0)
					 StrImportes +="('" + ICapturado.getId_tipo_pago() + "' , '" +  ICapturado.getFolio_caja() + "' , '" + fp.getCve_forma_pago() + "' , '" +  ICapturado.getEfectivo() +"'),";
			
			if(fp.getNombre_forma_pago().contains("CHEQUE"))
				if(Double.parseDouble(ICapturado.getCheque()) > 0)
					StrImportes +="('" + ICapturado.getId_tipo_pago() + "' , '" +  ICapturado.getFolio_caja() + "' , '" + fp.getCve_forma_pago() + "' , '" +  ICapturado.getCheque() +"'),";
			
			if(fp.getNombre_forma_pago().contains("TARJETA DE CREDITO"))
				if(Double.parseDouble(ICapturado.getTarjeta()) > 0)
				StrImportes +="('" + ICapturado.getId_tipo_pago() + "' , '" +  ICapturado.getFolio_caja() + "' , '" + fp.getCve_forma_pago() + "' , '" +  ICapturado.getTarjeta() +"'),";
			
			if(fp.getNombre_forma_pago().contains("DEBITO"))
				if(Double.parseDouble(ICapturado.getDebito()) > 0)
				StrImportes +="('" + ICapturado.getId_tipo_pago() + "' , '" +  ICapturado.getFolio_caja() + "' , '" + fp.getCve_forma_pago() + "' , '" +  ICapturado.getDebito() +"'),";
			
			if(fp.getNombre_forma_pago().contains("POSFECHADO"))
				if(Double.parseDouble(ICapturado.getPorfechado()) > 0)
				StrImportes +="('" + ICapturado.getId_tipo_pago() + "' , '" +  ICapturado.getFolio_caja() + "' , '" + fp.getCve_forma_pago() + "' , '" +  ICapturado.getPorfechado() +"'),";
			
			if(fp.getNombre_forma_pago().contains("TRANSFERENCIA"))
				if(Double.parseDouble(ICapturado.getTransferencia()) > 0)
				StrImportes +="('" + ICapturado.getId_tipo_pago() + "' , '" +  ICapturado.getFolio_caja() + "' , '" + fp.getCve_forma_pago() + "' , '" +  ICapturado.getTransferencia() +"'),";
			
			
			if(fp.getNombre_forma_pago().contains("NOTA CREDITO"))
				if(Double.parseDouble(ICapturado.getNotaCredito()) < 0)
					StrImportes +="('" + ICapturado.getId_tipo_pago() + "' , '" +  ICapturado.getFolio_caja() + "' , '" + fp.getCve_forma_pago() + "' , '" +  ICapturado.getNotaCredito() +"'),";
			
			
			if(fp.getNombre_forma_pago().contains("NOTA DEVOLUCION"))
				if(Double.parseDouble(ICapturado.getNotaDevolucion()) < 0)
					StrImportes +="('" + ICapturado.getId_tipo_pago() + "' , '" +  ICapturado.getFolio_caja() + "' , '" + fp.getCve_forma_pago() + "' , '" +  ICapturado.getNotaDevolucion() +"'),";
		}
		
		StrImportes= StrImportes.substring(0,StrImportes.length() -1) + ";";
		return StrImportes;
	}
		
	private String[] generaSentenciaDeImportesNC(Ingresos ICapturado, HttpSession session)
	{
		String StrSentencias[] = new String[2];
		String StrImportes = "";
		String formas_pagos = "";		
		List<Catalogo_Formas_Pago> listaFP = (List<Catalogo_Formas_Pago>) session.getAttribute("listaFormas_Pago");		
		for(int i = 0; i < listaFP.size(); i++) 
		{
			Catalogo_Formas_Pago fp =listaFP.get(i);		
			if(fp.getNombre_forma_pago().contains("NOTA CREDITO"))
			{
				if(!ICapturado.getNotaCredito().equals("0"))
				{
					StrImportes +="('" + ICapturado.getId_tipo_pago() + "' , '" +  ICapturado.getFolio_caja() + "' , '" + fp.getCve_forma_pago() + "' , '" +  ICapturado.getNotaCredito() +"'),";
					formas_pagos += fp.getCve_forma_pago() + ","; 
				}
			}
							
			if(fp.getNombre_forma_pago().contains("NOTA DEVOLUCION"))
			{
				if(!ICapturado.getNotaDevolucion().equals("0"))
				{
					StrImportes +="('" + ICapturado.getId_tipo_pago() + "' , '" +  ICapturado.getFolio_caja() + "' , '" + fp.getCve_forma_pago() + "' , '" +  ICapturado.getNotaDevolucion() +"'),";
					formas_pagos += fp.getCve_forma_pago() + ","; 
				}	
			}
		}			
		StrImportes = StrImportes.substring(0,StrImportes.length() -1) + ";";		
		formas_pagos = formas_pagos.substring(0,formas_pagos.length() -1) + ";";		
		StrSentencias [0] = StrImportes;
		StrSentencias [1] = formas_pagos;
		
		return StrSentencias;
	}
	
	/***  VALIDA SI INGRESO DE CONTADO TIENE FACTURA EN ALPHA  ***/
	public boolean validaFacturaEnIngresosContadoXID(Usuario infoUsu, List<Querys> ListaQuerys, Ingresos ICapturado, HttpSession session)
	{
		boolean confirmarIngresoXID_BD = false;
		String strQry="";
		Connection connBD = null;
		PreparedStatement pstm= null;		
		connBD = ConexionBD.AbrirConexionBD(infoUsu.getUname());
		try
		{
			String[] querys = new String[25];	
			querys = Cls_Querys.LimpiaListaQuerys(querys);	
			querys = Cls_Querys.ObtieneQuerys(81, ListaQuerys, querys, infoUsu);
			querys = inicializaQueryNumero81( querys, infoUsu, ICapturado);
			pstm = connBD.prepareStatement("{call " + "CTRL_INGRESOS.usp_EXECUTE_QUERY(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			strQry = Cls_MetodosGlobales.obtieneSentenciaDeQrys(querys);
			ResultSet rs = EjecutaQuerysBD.EjecutarQuery(querys[0], querys[1],querys[2], querys[3], querys[4], querys[5], querys[6],
														 querys[7], querys[8], querys[9],querys[10], querys[11], querys[12], querys[13], 
														 querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], 
														 querys[21], querys[22], querys[23], querys[24], infoUsu.getUname(),pstm, connBD);
		
			if (rs != null)
			{
				while(rs.next())
				{
					confirmarIngresoXID_BD =  (rs.getInt("resultados") > 0) ? true: false;
				}
			}
			
			if(confirmarIngresoXID_BD == false)
			{
				String strLog = "id_tipo: " + ICapturado.getId_tipo_pago() + " , id_ingreso: " + ICapturado.getFolio_caja();
				Cls_Log.insertaLog(infoUsu, "", "", "El Ingreso de Contado no tiene Factura en el Mayorista [" +strLog+ "]  " + "  QUERIES-81[" + strQry + "]");
			}
			
		}
		catch(Exception ex)
		{
			System.out.println("Error al validar ingreso de contado por Id.");
			Cls_Log.insertaLog(infoUsu, "", "", "Error al confirmar ingreso por Id [" + ex.getMessage().toString()+ "]  " + "  QUERIES-81[" + strQry + "]");
		}
		finally
		{
			try {pstm.close();} catch (SQLException e) {e.printStackTrace();}
			try {connBD.close();} catch (SQLException e) {e.printStackTrace();}
		}
		return confirmarIngresoXID_BD;
	}
	
	
	/***  VALIDA NOTAS CREDITO / DEVOLUCION  EN BD  ***/
	public boolean validaExistaNotaEnBD(Usuario infoUsu, List<Querys> ListaQuerys, String tipo_nota, String numNota)
	{
		boolean existeNotaBD=false;
		String strQry="";
		Connection connBD= null;
		PreparedStatement pstm = null;
		connBD = ConexionBD.AbrirConexionBD(infoUsu.getUname());
		try
		{
			String []querys = new String[25];
			querys = Cls_Querys.LimpiaListaQuerys(querys);			
			if(tipo_nota.equals("Credito"))
			{				
				querys = Cls_Querys.ObtieneQuerys(103, ListaQuerys, querys, infoUsu);
				querys = inicializaQueryNumero103(querys, infoUsu, numNota);
			}
			else
			{
				querys = Cls_Querys.ObtieneQuerys(104, ListaQuerys, querys, infoUsu);
				querys = inicializaQueryNumero104( querys, infoUsu, numNota);
			}
			strQry = Cls_MetodosGlobales.obtieneSentenciaDeQrys(querys);
			pstm = connBD.prepareStatement("{call " + "CTRL_INGRESOS.usp_EXECUTE_QUERY(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			ResultSet rs =EjecutaQuerysBD.EjecutarQuery(querys[0], querys[1],querys[2], querys[3], querys[4], querys[5], querys[6],
														 querys[7], querys[8], querys[9],querys[10], querys[11], querys[12], querys[13], 
														 querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], 
														 querys[21], querys[22], querys[23], querys[24], infoUsu.getUname(),pstm, connBD);	
			if(rs != null)
			{
				while(rs.next())
				{
					if(rs.getInt("numFac") > 0)
					{
						existeNotaBD = true;
					}
				}
			}			
			Cls_Log.insertaLog(infoUsu, "", "", "Valida si existe nota en BD [ Existe: " + existeNotaBD + "]  " + "  QUERIES-103-104[" + strQry + "]");
		}
		catch(Exception ex)
		{
			System.out.println("Error al validar nota en BD.");
			Cls_Log.insertaLog(infoUsu, "", "", "Error al validar nota en BD [" + ex.getMessage().toString()+ "]  " + "  QUERIES-103-104[" + strQry + "]");
		}
		finally
		{
			try {pstm.close();} catch (SQLException e) {e.printStackTrace();}
			try {connBD.close();} catch (SQLException e) {e.printStackTrace();}
		}	
		return existeNotaBD;
	}
		
	
	
	/*** CONSULTA DETALLE FOLIO HOJA DE RUTA   ***/
	public List<DetalleFolioHojaRuta> consultaDetallefolioHojaRuta(Usuario infoUsu, List<Querys> ListaQuerys, Ingresos ICapturado)
	{
		Connection connBD= null;
		PreparedStatement pstm = null;
		connBD = ConexionBD.AbrirConexionBD(infoUsu.getUname());
		List<DetalleFolioHojaRuta> listaDetalleFHR = new ArrayList<>();		
		try
		{
			String []querys = new String[25];
			querys = Cls_Querys.LimpiaListaQuerys(querys);
			querys = Cls_Querys.ObtieneQuerys(108, ListaQuerys, querys, infoUsu);
			querys = inicializaQueryNumero108(querys, infoUsu, ICapturado);
			
			pstm = connBD.prepareStatement("{call " + "CTRL_INGRESOS.usp_EXECUTE_QUERY(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			ResultSet rs =EjecutaQuerysBD.EjecutarQuery(querys[0], querys[1],querys[2], querys[3], querys[4], querys[5], querys[6],
														 querys[7], querys[8], querys[9],querys[10], querys[11], querys[12], querys[13], 
														 querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], 
														 querys[21], querys[22], querys[23], querys[24], infoUsu.getUname(),pstm, connBD);
			
			if(rs != null)
			{
				listaDetalleFHR= llenaClaseDetallefolioHojaruta(rs, infoUsu);
			}
		}
		catch(Exception ex)
		{
			System.out.println("Error al obtener detalle folio hoja de ruta .");
			Cls_Log.insertaLog(infoUsu, "", "", "Error al obtener detalle folio hoja de ruta [" + ex.getMessage().toString()+ "]");
		}
		finally
		{
			try {pstm.close();} catch (SQLException e) {e.printStackTrace();}
			try {connBD.close();} catch (SQLException e) {e.printStackTrace();}
		}
		return listaDetalleFHR;
	}
	
	public List<DetalleFolioHojaRuta> llenaClaseDetallefolioHojaruta(ResultSet rs,Usuario infoUsu )
	{
		List<DetalleFolioHojaRuta> listaDetalleFHR = new ArrayList<>();			
		try
		{
			while(rs.next())
			{
				DetalleFolioHojaRuta detalleFHR = new DetalleFolioHojaRuta();
				detalleFHR.setUname_br(rs.getString("uname_br"));
				detalleFHR.setFolio_caja(rs.getString("folio_caja"));
				detalleFHR.setDescripcion(rs.getString("formaPago"));
				detalleFHR.setNum_fac(rs.getString("num_fac"));
				detalleFHR.setImporte( formatoDecimal.format(rs.getDouble("importe")));
				listaDetalleFHR.add(detalleFHR);
			}
		}
		catch(Exception ex)
		{
			System.out.println("Error al llenar clase Detalle Folio Hoja de Ruta.");
			Cls_Log.insertaLog(infoUsu, "", "", "Error al llenar clase Detalle Folio Hoja de Ruta[" + ex.getMessage().toString()+ "]");
		}
		return listaDetalleFHR;		
	}
	
	
	
	
	
	
	
	
	
	/*** INICIAIZA LOS QUERYS SEGUN LA ACCION ***/
	private String[] inicializaQueryNumero6(String[] ListaQuerys,  Usuario infoUsu, Ingresos ICapturado, HttpSession session, String tipoFecha)
	{
		for (int i=0;i <ListaQuerys.length; i++)
		{
			if(ICapturado.getFolio_caja().equals("0"))
			{
				ListaQuerys[i]= ListaQuerys[i].replace("{ESTATUS}", " estatus IN(" + String.valueOf(ICapturado.getEstatus()) + ")" );
				ListaQuerys[i]= ListaQuerys[i].replace("{FOLIO_INGRESO}", "");	
				
				if(ICapturado.getId_tipo_pago() > 0)
					ListaQuerys[i]= ListaQuerys[i].replace("{TIPO_PAGO}"," AND id_tipo_ingreso = " + String.valueOf(ICapturado.getId_tipo_pago()));
				else
					ListaQuerys[i]= ListaQuerys[i].replace("{TIPO_PAGO}", " ");
					
				switch(tipoFecha)
				{
					case "FechaCreacion":
						
						ListaQuerys[i]= ListaQuerys[i].replace("{FECHAS} ", "AND fecha_creacion  BETWEEN '" + ICapturado.getFecha_creacion() + "' AND '" + ICapturado.getFecha_pro() + "'");
						break;
						
					case "FechaCorteCaja":
						ListaQuerys[i]= ListaQuerys[i].replace("{FECHAS} ", "AND fecha_corte  BETWEEN '" + ICapturado.getFecha_creacion() + "' AND '" + ICapturado.getFecha_pro() + "'");
					break;
										
					case "FechaPoliza":
						ListaQuerys[i]= ListaQuerys[i].replace("{FECHAS} ", "AND fecha_poliza  BETWEEN '" + ICapturado.getFecha_creacion() + "' AND '" + ICapturado.getFecha_pro() + "'");
						break;
						
					case "FechaCaja":
						ListaQuerys[i]= ListaQuerys[i].replace("{FECHAS} ", "AND fecha_caja  BETWEEN '" + ICapturado.getFecha_creacion() + "' AND '" + ICapturado.getFecha_pro() + "'");
						break;
						
					case "NA":
						ListaQuerys[i]= ListaQuerys[i].replace("{FECHAS} ", ""); 
						break;
				}
			}
			else
			{
				ListaQuerys[i]= ListaQuerys[i].replace("{ESTATUS}", " " );
				ListaQuerys[i]= ListaQuerys[i].replace("{TIPO_PAGO}", " ");
				ListaQuerys[i]= ListaQuerys[i].replace("{FECHAS} ", " "); 
				ListaQuerys[i]= ListaQuerys[i].replace("{FOLIO_INGRESO}", " folio_caja = " + String.valueOf(ICapturado.getFolio_caja()));
			}
			
			
		}
		return ListaQuerys;
	}
		
	private String[] inicializaQueryNumero7(String[] ListaQuerys,  Usuario infoUsu, Ingresos ICapturado, HttpSession session)
	{
		String StrImportes = "";
		for (int i=0;i <ListaQuerys.length; i++)
		{
			ListaQuerys[i]= ListaQuerys[i].replace(" {FOLIO}", String.valueOf(ICapturado.getFolio_caja()));
			ListaQuerys[i]= ListaQuerys[i].replace("{TIPO_PAGO}", String.valueOf(ICapturado.getId_tipo_pago()));
			ListaQuerys[i]= ListaQuerys[i].replace("{IMPORTE}", String.valueOf(ICapturado.getImporte()));						
		}
	
		StrImportes =generaSentenciaDeImportesFP(ICapturado, session);
		ListaQuerys[1]= ListaQuerys[1].replace("{IMPORTES}", StrImportes);
		return ListaQuerys;
	}
		
	private String[] inicializaQueryNumero8(String[] ListaQuerys,  Usuario infoUsu, Ingresos ICapturado, HttpSession session)
	{
		if(!String.valueOf(ICapturado.getId_tipo_pago()).equals("7"))
		{
			ListaQuerys[1] = "";			
		}
		
		for (int i=0;i <ListaQuerys.length; i++)
		{
			ListaQuerys[i]= ListaQuerys[i].replace("{FOLIO}", String.valueOf(ICapturado.getFolio_caja()));
			ListaQuerys[i]= ListaQuerys[i].replace("{TIPO_PAGO}", String.valueOf(ICapturado.getId_tipo_pago()));
			ListaQuerys[i]= ListaQuerys[i].replace("{USUARIO}", String.valueOf(infoUsu.getCve_usuario()));
			ListaQuerys[i]= ListaQuerys[i].replace("{ESTATUS}", String.valueOf(ICapturado.getEstatus()));
			ListaQuerys[i]= ListaQuerys[i].replace("{MOTIVO}", String.valueOf(ICapturado.getId_motivo_cancelacion()));
		}
		return ListaQuerys;
	}
	
	private String[] inicializaQueryNumero9(String[] ListaQuerys,  Usuario infoUsu, Ingresos ICapturado, HttpSession session)
	{
		String StrImportes = "";
		for (int i=0;i <ListaQuerys.length; i++)
		{
			ListaQuerys[i]= ListaQuerys[i].replace("{FOLIO}", String.valueOf(ICapturado.getFolio_caja()));
			ListaQuerys[i]= ListaQuerys[i].replace("{TIPO_PAGO}", String.valueOf(ICapturado.getId_tipo_pago()));
			ListaQuerys[i]= ListaQuerys[i].replace("{ENCARGADO}", String.valueOf(ICapturado.getCve_usu_nota()));
			ListaQuerys[i]= ListaQuerys[i].replace("{DOCUMENTO_CR}", String.valueOf(ICapturado.getDocumento_credito()));
		}
				
		String StrSentencias[] = generaSentenciaDeImportesNC(ICapturado, session); 
		
		String StrFP = StrSentencias[1].substring(0,StrSentencias[1].length() -1);
		
		StrImportes=  "('" + infoUsu.getUname() +"','" +  infoUsu.getUname_br() +"', "+ StrSentencias[0].substring( 1,StrSentencias[0].length());
		StrImportes= StrImportes.substring(0,StrImportes.length() -2) + " , CURDATE(), CURTIME());";
		
		ListaQuerys[1]= ListaQuerys[1].replace("{NOTA_CREDITO}", StrImportes);
		ListaQuerys[0]= ListaQuerys[0].replace("{FORMAS_PAGO}", StrFP);
		
		return ListaQuerys;
	}
		
	private String[] inicializaQueryNumero10(String[] ListaQuerys,  Usuario infoUsu, Ingresos ICapturado, HttpSession session)
	{
		for (int i=0;i <ListaQuerys.length; i++)
		{
			ListaQuerys[i]= ListaQuerys[i].replace("{FOLIO}", String.valueOf(ICapturado.getFolio_caja()));
			ListaQuerys[i]= ListaQuerys[i].replace("{TIPO_PAGO}", String.valueOf(ICapturado.getId_tipo_pago()));
			ListaQuerys[i]= ListaQuerys[i].replace("{ENCARGADO}", "");
			ListaQuerys[i]= ListaQuerys[i].replace("{DOCUMENTO_CREDITO}", "");
		}
		return ListaQuerys;
	}
		
	private String[] inicializaQueryNumero11(String[] ListaQuerys,  Usuario infoUsu, Ingresos ICapturado, HttpSession session)
	{
		for (int i=0;i <ListaQuerys.length; i++)
		{
			ListaQuerys[i]= ListaQuerys[i].replace("{FOLIO}", String.valueOf(ICapturado.getFolio_caja()));
			ListaQuerys[i]= ListaQuerys[i].replace("{TIPO_PAGO}", String.valueOf(ICapturado.getId_tipo_pago()));
			ListaQuerys[i]= ListaQuerys[i].replace("{OBSERVACIONES}", "");
			ListaQuerys[i]= ListaQuerys[i].replace("{DOCUMENTO_DEVOLUCION}", "");
		}
		return ListaQuerys;
	}
	
	private String[] inicializaQueryNumero13(String[] ListaQuerys,  Usuario infoUsu, Ingresos ICapturado, HttpSession session)
	{
		String StrImportes = "";
		for (int i=0;i <ListaQuerys.length; i++)
		{
			ListaQuerys[i]= ListaQuerys[i].replace("{FOLIO}", String.valueOf(ICapturado.getFolio_caja()));
			ListaQuerys[i]= ListaQuerys[i].replace("{TIPO_PAGO}", String.valueOf(ICapturado.getId_tipo_pago()));
			ListaQuerys[i]= ListaQuerys[i].replace("{OBSERVACIONES}", String.valueOf(ICapturado.getObservaciones_nota()));
			ListaQuerys[i]= ListaQuerys[i].replace("{DOCUMENTO_DV}", String.valueOf(ICapturado.getDocumento_devolucion()));
		}
		
		String StrSentencias[] = generaSentenciaDeImportesNC(ICapturado, session); 
		String StrFP = StrSentencias[1].substring(0,StrSentencias[1].length() -1);
		StrImportes=  "('" + infoUsu.getUname() + "','" +  infoUsu.getUname_br() +"', "+ StrSentencias[0].substring( 1,StrSentencias[0].length());
		StrImportes= StrImportes.substring(0,StrImportes.length() -2) + " , CURDATE(), CURTIME());";
		
		ListaQuerys[1]= ListaQuerys[1].replace("{NOTA_CREDITO}", StrImportes);
		ListaQuerys[0]= ListaQuerys[0].replace("{FORMAS_PAGO}", StrFP);
		return ListaQuerys;
	}
	
	private String[] inicializaQueryNumero33(String[] ListaQuerys,  Usuario infoUsu, String FOLIO)
	{
		for (int i=0;i <ListaQuerys.length; i++)
		{
			ListaQuerys[i]= ListaQuerys[i].replace("{FOLIO}",FOLIO);
			ListaQuerys[i]= ListaQuerys[i].replace("{CVEUSU}",infoUsu.getCve_usuario());
			ListaQuerys[i]= ListaQuerys[i].replace("{USUARIO}",infoUsu.getCve_usuario());
			
		}
		return ListaQuerys;
	}
	
	private String[] inicializaQueryNumero34(String[] ListaQuerys,  Usuario infoUsu, String folioHojaruta)
	{
		for (int i=0;i <ListaQuerys.length; i++)
		{
			ListaQuerys[i]= ListaQuerys[i].replace("{FOLIO}",folioHojaruta);
		}
		return ListaQuerys;
	}
	
	private String[] inicializaQueryNumero24(String[] ListaQuerys,  Usuario infoUsu, Ingresos ICapturado, int banco, int banco_deposito, boolean aplicaComision)
	{	
		int numQueryComplemento= 0;
		
		/*** Actualizar estatus y fecha poliza ***/	
		if(!aplicaComision) 
			for(int i =1; i<=12; i++)
				ListaQuerys[i] ="";
			
		for (int i=0;i <ListaQuerys.length; i++)
		{
			ListaQuerys[i]= ListaQuerys[i].replace("{ESTATUS}","1");
			ListaQuerys[i]= ListaQuerys[i].replace("{USUARIO}", infoUsu.getCve_usuario());
			ListaQuerys[i]= ListaQuerys[i].replace("{FOLIO}", String.valueOf(ICapturado.getFolio_caja()));
			ListaQuerys[i]= ListaQuerys[i].replace("{TIPO_PAGO}", String.valueOf(ICapturado.getId_tipo_pago()));
			ListaQuerys[i]= ListaQuerys[i].replace("{FECHA_POLIZA}", ICapturado.getFecha_poliza());
			String numTicket =  (String.valueOf(ICapturado.getId_tipo_pago()).equals("3")) ? String.valueOf(ICapturado.getFolio_caja()) : "0"; 
			ListaQuerys[i]= ListaQuerys[i].replace("{NUMERO_TICKET_FACTURA}", numTicket);
		}
		
		/*** Actualizar estatus y fecha poliza ***/
		if(aplicaComision) 
		{
			ListaQuerys =  generaOtroIngresoXComisonTC(ICapturado, banco, banco_deposito,ListaQuerys ,infoUsu);
		}
		
		if(String.valueOf(ICapturado.getId_tipo_pago()).equals("3"))
		{
			numQueryComplemento = 13;
			ListaQuerys = generaComplementoDePago(ListaQuerys, ICapturado,infoUsu, numQueryComplemento);
			ListaQuerys[17] = ListaQuerys[17].replace("{FOLIO_CAJA}", ICapturado.getFolio_caja());
			ListaQuerys[14] = "";
			ListaQuerys[15] = "";
			ListaQuerys[16] = "";
			ListaQuerys[13] = "";
		}
		else
		{
			ListaQuerys[13] = "";
			ListaQuerys[17] = "";
		}
		
		if(String.valueOf(ICapturado.getId_tipo_pago()).equals("7"))
		{
			ListaQuerys[14] = ListaQuerys[14].replace("{FOLIO_CAJA}", ICapturado.getFolio_caja());
			ListaQuerys[13] = "";
			ListaQuerys[15] = "";
			ListaQuerys[16] = "";
			ListaQuerys[17] = "";
		}
		else
		{
			ListaQuerys[14] = "";
		}
		
		
		if(String.valueOf(ICapturado.getId_tipo_pago()).equals("5"))
		{
			numQueryComplemento= 15;
			ListaQuerys = generaComplementoDePago(ListaQuerys, ICapturado,infoUsu, numQueryComplemento);
			ListaQuerys[13] = "";
			ListaQuerys[14] = "";
			ListaQuerys[17] = "";
			ListaQuerys[16] = ListaQuerys[16].replace("{FOLIO_CAJA}", ICapturado.getFolio_caja());			
		}
		else
		{
			ListaQuerys[15] = "";
			ListaQuerys[16] = "";
		}
		
		
		return ListaQuerys;
	}
			
	private String[] inicializaQueryNumero55(String[] ListaQuerys,  Usuario infoUsu, Ingresos ICapturado, HttpSession session)
	{
		for (int i=0;i <ListaQuerys.length; i++)
		{
			ListaQuerys[i]= ListaQuerys[i].replace("{FOLIO}", String.valueOf(ICapturado.getFolio_caja()));
			ListaQuerys[i]= ListaQuerys[i].replace("{TIPO_PAGO}", String.valueOf(ICapturado.getId_tipo_pago()));
			ListaQuerys[i]= ListaQuerys[i].replace("{ESTATUS}", String.valueOf(ICapturado.getEstatus()));
		}
		return ListaQuerys;
	}
	
	private String[] inicializaQueryNumero60(String[] ListaQuerys,  Usuario infoUsu, String facturaLarga)
	{
		for (int i=0;i <ListaQuerys.length; i++)
		{
			ListaQuerys[i]= ListaQuerys[i].replace("{FACTURA_LARGA}", facturaLarga);
		}
		return ListaQuerys;
	}
		
	private String[] inicializaQueryNumero61(String[] ListaQuerys,  Usuario infoUsu, String facturaLarga,String formaPagoFac)
	{
		String serie = facturaLarga.substring(0, 5);
		String folio = facturaLarga.substring(9, 15);
		
		for (int i=0;i <ListaQuerys.length; i++)
		{
			ListaQuerys[i]= ListaQuerys[i].replace("{USUARIO}", infoUsu.getCve_usuario());
			ListaQuerys[i]= ListaQuerys[i].replace("{FACTURA_LARGA}", facturaLarga);
			ListaQuerys[i]= ListaQuerys[i].replace("{SERIE_FAC}", serie);
			ListaQuerys[i]= ListaQuerys[i].replace("{FOLIO_FAC}", folio);
			ListaQuerys[i]= ListaQuerys[i].replace("{FORMA_PAGO}", formaPagoFac);
		}
		return ListaQuerys;
	}
	
	private String[] inicializaQueryNumero64(String [] ListaQuerys, Usuario inforUsu, Ingresos ICapturado)
	{
		for(int i =0; i<ListaQuerys.length; i++)
		{
			ListaQuerys[i]= ListaQuerys[i].replace("{USUARIO}", inforUsu.getCve_usuario());
			ListaQuerys[i]= ListaQuerys[i].replace("{FOLIO_CAJA}", ICapturado.getFolio_caja());
		}
		return ListaQuerys;
	}
	
	private String[] inicializaQueryNumero86(String [] ListaQuerys, Usuario inforUsu, Ingresos ICapturado)
	{
		for(int i =0; i<ListaQuerys.length; i++)
		{
			ListaQuerys[i]= ListaQuerys[i].replace("{USUARIO}", inforUsu.getCve_usuario());
			ListaQuerys[i]= ListaQuerys[i].replace("{FOLIO_CAJA}", ICapturado.getFolio_caja());
			ListaQuerys[i]= ListaQuerys[i].replace("{FECHA_POLIZA}", ICapturado.getFecha_poliza());
		}
		return ListaQuerys;
	}
	
	private String[] inicializaQueryNumero81(String[] ListaQuerys,  Usuario infoUsu,  Ingresos ICapturado)
	{
		for (int i=0;i <ListaQuerys.length; i++)
		{
			ListaQuerys[i]= ListaQuerys[i].replace("{TICKET}", ICapturado.getFolio_caja());
		}
		return ListaQuerys;
	}
	
	private String[] inicializaQueryNumero100(String[] ListaQuerys,  Usuario infoUsu,  String fecha_poliza)
	{
		for (int i=0;i <ListaQuerys.length; i++)
		{
			ListaQuerys[i]= ListaQuerys[i].replace("{FECHA_POLIZA}",fecha_poliza);
		}
		return ListaQuerys;
	}
	
	private String[] inicializaQueryNumero103(String[] ListaQuerys,  Usuario infoUsu,  String nota_credito)
	{
		for (int i=0;i <ListaQuerys.length; i++)
		{
			ListaQuerys[i]= ListaQuerys[i].replace("{NOTA_CREDITO}",nota_credito);
		}
		return ListaQuerys;
	}
	
	private String[] inicializaQueryNumero104(String[] ListaQuerys,  Usuario infoUsu,  String nota_devolucion)
	{
		for (int i=0;i <ListaQuerys.length; i++)
		{
			ListaQuerys[i]= ListaQuerys[i].replace("{NOTA_DEVOLUCION}",nota_devolucion);
		}
		return ListaQuerys;
	}
	
	private String[] inicializaQueryNumero106(String[] ListaQuerys,  Usuario infoUsu,  Ingresos ICapturado)
	{
		for (int i=0;i <ListaQuerys.length; i++)
		{
			ListaQuerys[i]= ListaQuerys[i].replace("{NUMERO_TICKET_FACTURA}",ICapturado.getFolio_caja());
		}
		return ListaQuerys;
	}
	
	private String[] inicializaQueryNumero108(String[] ListaQuerys,  Usuario infoUsu,  Ingresos ICapturado)
	{
		for (int i=0;i <ListaQuerys.length; i++)
		{
			ListaQuerys[i]= ListaQuerys[i].replace("{FOLIO_CAJA}",ICapturado.getFolio_caja());
		}
		return ListaQuerys;
	}
	
	private String[]  generaOtroIngresoXComisonTC(Ingresos ICapturado, int banco, int banco_deposito,String[] ListaQuerys, Usuario infoUsu)
	{
		try
		{
			double importeTCredito = Double.parseDouble(ICapturado.getTarjeta().replace(",", ""));
			double importeTDebito = Double.parseDouble(ICapturado.getDebito().replace(",", ""));
						
			if(importeTCredito <= 0 )
			{
				for(int i =1; i<=6; i++)
					ListaQuerys[i] ="";
			}
			else
			{
				double comision =  calculaComisionDePagoPorTarjeta(importeTCredito, infoUsu);
				for(int i =1; i<=6; i++)
				{
					ListaQuerys[i]= ListaQuerys[i].replace("{IMPORTE_COMISION}", String.valueOf(comision));
					ListaQuerys[i]= ListaQuerys[i].replace("{FORMA_PAGO}", "4");
					ListaQuerys[i]= ListaQuerys[i].replace("{CVE_BANCO}", String.valueOf(banco));
					ListaQuerys[i]= ListaQuerys[i].replace("{BANCO_DEPOSITO}", String.valueOf(banco_deposito));
				}
			}
			
			if(importeTDebito <= 0 )
			{
				for(int i =7; i<=12; i++)
					ListaQuerys[i] ="";
			}
			else
			{
				double comision =  calculaComisionDePagoPorTarjeta(importeTDebito, infoUsu);
				for(int i =7; i<=12; i++)
				{
					ListaQuerys[i]= ListaQuerys[i].replace("{IMPORTE_COMISION}", String.valueOf(comision));
					ListaQuerys[i]= ListaQuerys[i].replace("{FORMA_PAGO}", "28");
					ListaQuerys[i]= ListaQuerys[i].replace("{CVE_BANCO}", String.valueOf(banco));
					ListaQuerys[i]= ListaQuerys[i].replace("{BANCO_DEPOSITO}", String.valueOf(banco_deposito));
				}
			}
		}
		catch(Exception ex)
		{
			String sError= ex.getMessage().toString();
		}
		return ListaQuerys;
	}
		
	private String[] generaComplementoDePago( String[] ListaQuerys,Ingresos ICapturado, Usuario infoUsu, int item)
	{
		String qry= ListaQuerys[item];
		String formPagoMayor = "0";
		double importeMayor = 0;
		double importeTotal = 0;
				
		if(Double.parseDouble(ICapturado.getEfectivo().replace(",", "")) > 0)
		{
			formPagoMayor ="1";
			importeMayor =  Double.parseDouble(ICapturado.getEfectivo());
			importeTotal =  importeTotal + Double.parseDouble(ICapturado.getEfectivo());
		}
		
		if(Double.parseDouble(ICapturado.getCheque().replace(",", "")) > 0)
		{
			if(Double.parseDouble(ICapturado.getCheque()) > importeMayor)
			{
				formPagoMayor ="2";
				importeMayor =  Double.parseDouble(ICapturado.getCheque());
			}		
			importeTotal =  importeTotal + Double.parseDouble(ICapturado.getCheque());
		}
		
		if(Double.parseDouble(ICapturado.getTransferencia().replace(",", "")) > 0)
		{
			if(Double.parseDouble(ICapturado.getTransferencia()) > importeMayor)
			{
				formPagoMayor ="3";	
				importeMayor = Double.parseDouble(ICapturado.getTransferencia());
			}
			importeTotal =  importeTotal + Double.parseDouble(ICapturado.getTransferencia());
		}
		
		if(Double.parseDouble(ICapturado.getTarjeta().replace(",", "")) > 0)
		{
			if(Double.parseDouble(ICapturado.getTarjeta()) > importeMayor)
			{
				formPagoMayor ="4";	
				importeMayor = Double.parseDouble(ICapturado.getTarjeta());
			}
			importeTotal =  importeTotal + Double.parseDouble(ICapturado.getTarjeta());
		}
		
		if(Double.parseDouble(ICapturado.getDebito().replace(",", "")) > 0)
		{
			if(Double.parseDouble(ICapturado.getDebito()) > importeMayor)
			{
				formPagoMayor ="28";	
				importeMayor = Double.parseDouble(ICapturado.getDebito());
			}
			importeTotal =  importeTotal + Double.parseDouble(ICapturado.getDebito());
		}
		
		if(Double.parseDouble(ICapturado.getPorfechado().replace(",", "")) > 0)
		{
			if(Double.parseDouble(ICapturado.getPorfechado()) > importeMayor)
			{
				formPagoMayor ="98";	
				importeMayor = Double.parseDouble(ICapturado.getPorfechado());
			}			
			importeTotal =  importeTotal + Double.parseDouble(ICapturado.getPorfechado());
		}
		
		ListaQuerys[item]= generaQryComplementoPago(qry, infoUsu, String.valueOf(importeTotal), formPagoMayor, String.valueOf(ICapturado.getFolio_caja()));
		item++;
		
		return ListaQuerys;
		
	}
			
	private String generaQryComplementoPago(String insertaComplemento,Usuario infoUsu , String importe, String formPago, String tiket) 
	{
		 String agente = obtenesAgenteXCdo(infoUsu.getUname());
			
		insertaComplemento = insertaComplemento.replace("{UNAME}", infoUsu.getUname());
		insertaComplemento = insertaComplemento.replace("{IMPORTE}",importe);
		insertaComplemento = insertaComplemento.replace("{FORMA_PAGO}", formPago);
		if(formPago.equals("98"))
			insertaComplemento = insertaComplemento.replace("{POSFECHADO}", "1");
		else
			insertaComplemento = insertaComplemento.replace("{POSFECHADO}", "0");
		
		
		insertaComplemento = insertaComplemento.replace("{AGENTE}", agente);
		insertaComplemento = insertaComplemento.replace("{NUM_TICKET}", tiket);
		insertaComplemento = insertaComplemento.replace("{FOLIO_CAJA}", tiket);
		insertaComplemento = insertaComplemento.replace("{IMPORTE_COBRADO}", importe);
		
		return insertaComplemento;
	}
		
	private String[] inicializaQueryNumero107(String[] ListaQuerys,  Usuario infoUsu, Ingresos ICapturado)
	{
		String agente = obtenesAgenteXCdo(infoUsu.getUname());
		for (int i=0;i <ListaQuerys.length; i++)
		{
			ListaQuerys[i]= ListaQuerys[i].replace("{AGENTE}", agente);
			ListaQuerys[i]= ListaQuerys[i].replace("{NUM_TICKET}", String.valueOf(ICapturado.getFolio_caja()));
			ListaQuerys[i]= ListaQuerys[i].replace("{FECHA_POLIZA}", ICapturado.getFecha_poliza());
			ListaQuerys[i]= ListaQuerys[i].replace("{FORMA_PAGO}", "1");
			ListaQuerys[i]= ListaQuerys[i].replace("{POSFECHADO}", "0");
		}
		return ListaQuerys;
	}
	 
	private String obtenesAgenteXCdo(String cdo)
	 {
		 String agente = "0";		 
		 switch(cdo)
		 {
			 case "cdf":
				 agente = "9999";
				 break;
				 
			 case "cd2":
				 agente = "9999";
				 break;
				 
			 case "cdl":
				 agente = "9999";
				 break;
				 
			 case "cdm":
				 agente = "9999";
				 break;
		 }		 
		 return agente;
	 }
			
	private double calculaComisionDePagoPorTarjeta(double importe, Usuario infoUsu)
	{
		double comision = importe * Integer.parseInt(infoUsu.getDato_alfanumerico());
		comision = comision / 100;
		return comision;
	}
	
	private String[] inicializaQueryNumero25(String[] ListaQuerys,  Usuario infoUsu, Ingresos ICapturado)
	{
		for (int i=0;i <ListaQuerys.length; i++)
		{
			ListaQuerys[i]= ListaQuerys[i].replace("{FOLIO}", String.valueOf(ICapturado.getFolio_caja()));
			ListaQuerys[i]= ListaQuerys[i].replace("{TIPO_INGRESO}", String.valueOf(ICapturado.getId_tipo_pago()));
		}
		return ListaQuerys;
	}

	private String[] inicializaQueryNumero26(String[] ListaQuerys,  Usuario infoUsu, Ingresos ICapturado)
	{
		for (int i=0;i <ListaQuerys.length; i++)
		{
			ListaQuerys[i]= ListaQuerys[i].replace("{FECHA}", String.valueOf(ICapturado.getFecha_poliza()));
			ListaQuerys[i]= ListaQuerys[i].replace("{TIPO_PAGO}", String.valueOf(ICapturado.getId_tipo_pago()));
			ListaQuerys[i]= ListaQuerys[i].replace("{FOLIO}", String.valueOf(ICapturado.getFolio_caja()));
		}
		return ListaQuerys;
	}
			
	private String[] inicializaQueryNumero101(String[] ListaQuerys,  Usuario infoUsu, String facturaLarga)
	{
		String serie = facturaLarga.substring(0, 5);
		String folio = facturaLarga.substring(9, 15);
		
		for (int i=0;i <ListaQuerys.length; i++)
		{
			ListaQuerys[i]= ListaQuerys[i].replace("{FACTURA_LARGA}", facturaLarga);
			ListaQuerys[i]= ListaQuerys[i].replace("{SERIE_FAC}", serie);
			ListaQuerys[i]= ListaQuerys[i].replace("{FOLIO_FAC}", folio);
		}
		return ListaQuerys;
	}
	
}

