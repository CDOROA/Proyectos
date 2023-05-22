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

import javax.security.auth.Subject;
import javax.servlet.http.HttpSession;

import org.eclipse.jdt.internal.compiler.lookup.Scope.Substitutor;

import cdo.Datos.Egresos;
import cdo.Datos.Ingresos;
import cdo.Datos.Querys;
import cdo.Datos.SemaforoIngresos;
import cdo.Datos.Usuario;
import cdo.util.Cls_Log;
import cdo.util.Cls_MetodosGlobales;
import cdo.util.Cls_Querys;
import cdo.util.ConexionBD;
import cdo.util.EjecutaQuerysBD;

public class GestorConfirmaEgresos {

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
			Cls_Log.insertaLog(infoUsu, "", "", "Valida si existe polizas anteriores [Existe Poliza: " +existePolizaAnterior+ "]  "   +  " QUERIES-99[" + strQry + "]");
		}
		catch(Exception ex)
		{
			System.out.println("Error al validar polizas anteriores./Detalle:" + ex.getMessage().toString());
			Cls_Log.insertaLog(infoUsu, "", "", "Error al validar polizas anteriores [" + ex.getMessage().toString()+ "]  "   +  " QUERIES-99[" + strQry + "]");
		}
		finally
		{
			try {pstm.close();} catch (SQLException e) {e.printStackTrace();}
			try {connBD.close();} catch (SQLException e) {e.printStackTrace();}
		}
		return  String.valueOf(existePolizaAnterior)+ "&" + fechaUltimaPoliza;
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
		String strQry = "";
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
			Cls_Log.insertaLog(infoUsu, "", "", "Valida si existen Ingresos con fecha poliza  [Fecha Poliza: " + fecha_poliza + ", ExistenIngreos: " +existenIngresos+ "]  "   +  " QUERIES-100[" + strQry + "]");
		}
		catch(Exception ex)
		{
			System.out.println("Error al validar si existen Ingresos con fecha poliza./Detalle:" + ex.getMessage().toString());
			Cls_Log.insertaLog(infoUsu, "", "", "Error al validar si existen Ingresos con fecha poliza [" + ex.getMessage().toString()+ "]  " +  " QUERIES-100[" + strQry + "]");
		}
		finally
		{
			try {pstm.close();} catch (SQLException e) {e.printStackTrace();}
			try {connBD.close();} catch (SQLException e) {e.printStackTrace();}
		}
		return existenIngresos;
	}
	
	
	
	/****  CONSULTA DE EGRESOS POR PARAMETRO ****/
	public List<Egresos> consultaEgresosPendientesBD(Usuario infoUsu, List<Querys> ListaQuerys, Egresos ECapturado)
	{
		List<Egresos> listaEgresos = new ArrayList<>();
		String strQry = "";
		Connection connBD = null;
		PreparedStatement pstm= null;		
		connBD = ConexionBD.AbrirConexionBD(infoUsu.getUname());
		try
		{
			String[] querys = new String[25];	
			querys = Cls_Querys.LimpiaListaQuerys(querys);	
			querys = Cls_Querys.ObtieneQuerys(15, ListaQuerys, querys, infoUsu);
			querys = InicializaQueryNumero15(querys, infoUsu, ECapturado);	
			strQry = Cls_MetodosGlobales.obtieneSentenciaDeQrys(querys);
			pstm = connBD.prepareStatement("{call " + "CTRL_INGRESOS.usp_EXECUTE_QUERY(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			ResultSet rs= EjecutaQuerysBD.EjecutarQuery(querys[0], querys[1],querys[2], querys[3], querys[4], querys[5], querys[6],
														 querys[7], querys[8], querys[9],querys[10], querys[11], querys[12], querys[13], 
														 querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], 
														 querys[21], querys[22], querys[23], querys[24], infoUsu.getUname(),pstm, connBD);	
			if(rs !=null)
				listaEgresos = llenaClaseEgreso(rs);
			
			Cls_Log.insertaLog(infoUsu, "", "", "Consulta Egresos por Parametros.  " + " QUERYS-15[" + strQry + "]" );
		}
		catch(Exception ex)
		{
			String sError= ex.getMessage().toString();
			Cls_Log.insertaLog(infoUsu, "", "", "Error al consultar los egresos: [" + sError + "]   "  + " QUERYS-15[" + strQry + "]");
		}
		finally
		{
			try {connBD.close();} catch (SQLException e) {e.printStackTrace();}
			try {pstm.close();} catch (SQLException e) {e.printStackTrace();}
		}
		return listaEgresos;
	}
		
	public List<Egresos> llenaClaseEgreso(ResultSet rs)
	{
		List<Egresos> listaEgresos = new ArrayList<>();
		try 
		{
			while(rs.next())
			{
				String[] arrayFecha = rs.getString("fecha_pro").split("-");
				String fecha_pro =  arrayFecha[2] + "/" + arrayFecha[1] + "/" + arrayFecha[0];
				
				arrayFecha = rs.getString("fecha_poliza").split("-");
				String fecha_poliza =  arrayFecha[2] + "/" + arrayFecha[1] + "/" + arrayFecha[0];
				
				Egresos egreso =new Egresos();
				egreso.setUname(rs.getString("uname"));
				egreso.setId_egreso(rs.getInt("id_tipo_egreso"));
				egreso.setNombre_egreso(rs.getString("nombre_egreso"));
				egreso.setFolio_caja(rs.getInt("folio_caja"));
				egreso.setFolio_documento(rs.getInt("folio_documento"));
				egreso.setImporte(Cls_MetodosGlobales.aplicarFormatoImporte(rs.getBigDecimal("importe")));
				egreso.setCve_forma_pago(rs.getInt("cve_forma_pago"));
				egreso.setFormPago(rs.getString("formPago"));
				egreso.setReferencia(rs.getString("referencia_cheque"));
				egreso.setBanco_emisor(rs.getInt("banco_emisor"));
				egreso.setNombre_banco_emisor(rs.getString("nombre_banco_emisor"));
				egreso.setBanco_deposito(rs.getInt("banco_deposito"));
				egreso.setNombre_banco_deposito(rs.getString("nombre_banco_deposito"));
				egreso.setBanco_transferencia(rs.getInt("banco_transferencia"));
				egreso.setNombre_banco_transferencia(rs.getString("nombre_banco_transferencia"));
				egreso.setNumero_transferencia(rs.getString("numero_transferencia"));
				egreso.setCve_usu(rs.getString("cve_usu"));
				egreso.setId_estatus(rs.getString("id_estatus"));
				egreso.setEstatus(rs.getString("estatus"));
				egreso.setFolio_corte_caja(rs.getInt("folio_corte_caja"));
				egreso.setFolio_panamericano(rs.getInt("folio_panamericano"));
				egreso.setFolio_poliza(rs.getInt("folio_poliza"));
				egreso.setFecha_inicio(fecha_pro);
				egreso.setFecha_fin(fecha_pro);
				egreso.setFecha_poliza(fecha_poliza);
				egreso.setColectiva(rs.getString("colectiva"));
				listaEgresos.add(egreso);
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return listaEgresos;
	}
			
	public List<SemaforoIngresos> consultaDatosDelSemaforo(Usuario infoUsu, List<Querys> ListaQuerys)
	{
		List<SemaforoIngresos> listaSemaforo = new ArrayList<>();
		String strQry = "";
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
			
			Cls_Log.insertaLog(infoUsu, "", "", "Consulta datos del semaforo .  " + " QUERYS-23[" + strQry + "]" );
			
		}
		catch(Exception ex)
		{
			System.out.println("Error al consultar parametros del semaforo.");
			Cls_Log.insertaLog(infoUsu, "", "", "Error al consultar parametros del semaforo. [" + ex.getMessage().toString()+ "]  "   + " QUERYS-23[" + strQry + "]");	
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
				String impActual =rs.getString("importe_actual");
				SemaforoIngresos semaforo= new SemaforoIngresos(
													formatoDecimal.format(Double.parseDouble(impActual)), 
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
	
	
	/***  ACTUALIZA FECHA POLIZA XID ***/
	public boolean actualizaFechaPolizaXID(Usuario infoUsu,List<Querys> ListaQuerys, Egresos ICapturado)
	{
		boolean actualizoEgresoXID_BD = false;
		String strQry = "";
		Connection connBD = null;
		PreparedStatement pstm= null;		
		connBD = ConexionBD.AbrirConexionBD(infoUsu.getUname());	
		try
		{
			String[] querys = new String[25];
			querys = Cls_Querys.LimpiaListaQuerys(querys);
			querys = Cls_Querys.ObtieneQuerys(95, ListaQuerys, querys, infoUsu);
			querys = inicializaQueryNumero95( querys, infoUsu, ICapturado);
			strQry = Cls_MetodosGlobales.obtieneSentenciaDeQrys(querys);
			pstm = connBD.prepareStatement("{call " + "CTRL_INGRESOS.usp_EXECUTE_QUERY(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			EjecutaQuerysBD.EjecutarQuery(querys[0], querys[1],querys[2], querys[3], querys[4], querys[5], querys[6],
														 querys[7], querys[8], querys[9],querys[10], querys[11], querys[12], querys[13], 
														 querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], 
														 querys[21], querys[22], querys[23], querys[24], infoUsu.getUname(),pstm, connBD);	
			
			actualizoEgresoXID_BD = true;
			Cls_Log.insertaLog(infoUsu, "", "", "Actualizo la fecha de poliza de Egreso por Id [" + ICapturado + "]  "   + "  QUERYS-95[" + strQry + "]");
		}
		catch(Exception ex)
		{
			System.out.println("Error al actualizar la fecha de poliza por Id../Detalle:" + ex.getMessage().toString());
			Cls_Log.insertaLog(infoUsu, "", "", "Error al actualizar fecha de poliza por Id [" + ex.getMessage().toString()+ "]  "   + "  QUERYS-95[" + strQry + "]");
		}
		finally
		{
			try {pstm.close();} catch (SQLException e) {e.printStackTrace();}
			try {connBD.close();} catch (SQLException e) {e.printStackTrace();}
		}
		return actualizoEgresoXID_BD;
	}
	
	/****  ALTA DE EGRESOS POR PARAMETRO ****/
	public boolean insertaEgresos(Egresos ECapturado, Usuario infoUsu, List<Querys> ListaQuerys)
	{
		boolean  insertoECapturadoBD = insertaEgresoEnBD(infoUsu, ListaQuerys, ECapturado);
		return insertoECapturadoBD;
	}
		
	public boolean insertaEgresoEnBD(Usuario infoUsu, List<Querys> ListaQuerys, Egresos ECapturado)
	{
		boolean  insertoECapturadoBD = false;
		String strQry = "";
		Connection connBD = null;
		PreparedStatement pstm= null;		
		connBD = ConexionBD.AbrirConexionBD(infoUsu.getUname());
		try
		{
			String[] querys = new String[25];	
			querys = Cls_Querys.LimpiaListaQuerys(querys);
			
			if(ECapturado.getId_egreso() == 3 || ECapturado.getId_egreso() == 4)
				querys = Cls_Querys.ObtieneQuerysAnidados(19, 20, 14, ListaQuerys, querys, infoUsu);
			else
				querys = Cls_Querys.ObtieneQuerysAnidados(19,0, 14, ListaQuerys, querys, infoUsu);
			
			querys = InicializaQueryNumero_19_20_14(querys, infoUsu, ECapturado);
			strQry = Cls_MetodosGlobales.obtieneSentenciaDeQrys(querys);
			pstm = connBD.prepareStatement("{call " + "CTRL_INGRESOS.usp_EXECUTE_QUERY(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			EjecutaQuerysBD.EjecutarQuery(querys[0], querys[1],querys[2], querys[3], querys[4], querys[5], querys[6],
														 querys[7], querys[8], querys[9],querys[10], querys[11], querys[12], querys[13], 
														 querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], 
														 querys[21], querys[22], querys[23], querys[24], infoUsu.getUname(),pstm, connBD);			
			
			String strLog = "Inserto  " + ECapturado + ""  +  "   QUERYS-19-20-14[" + strQry + "]";
			Cls_Log.insertaLog(infoUsu, "", "",  strLog );	
			insertoECapturadoBD = true;
		}
		catch(Exception ex)
		{
			String sError= ex.getMessage().toString();
			Cls_Log.insertaLog(infoUsu, "", "", "Error al insertar los egresos: [" + sError + "]  "  +  "   QUERYS-19-20-14[" + strQry + "]");
		}
		finally
		{
			try {connBD.close();} catch (SQLException e) {e.printStackTrace();}
			try {pstm.close();} catch (SQLException e) {e.printStackTrace();}
		}
		return insertoECapturadoBD;
	}
		
	/****  ACTUALIZA EGRESOS POR PARAMETRO ****/
	public boolean actualizaEgresosXID(Usuario infoUsu, List<Querys> ListaQuerys, Egresos ECapturado)
	{
		boolean  actualizoECapturadoBD = false;
		String strQry = "";
		Connection connBD = null;
		PreparedStatement pstm= null;		
		connBD = ConexionBD.AbrirConexionBD(infoUsu.getUname());
		try
		{
			String[] querys = new String[25];	
			querys = Cls_Querys.LimpiaListaQuerys(querys);
			querys = Cls_Querys.ObtieneQuerys(21, ListaQuerys, querys, infoUsu);
			querys = InicializaQueryNumero21(querys, infoUsu, ECapturado);
			strQry = Cls_MetodosGlobales.obtieneSentenciaDeQrys(querys);
			pstm = connBD.prepareStatement("{call " + "CTRL_INGRESOS.usp_EXECUTE_QUERY(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			EjecutaQuerysBD.EjecutarQuery(querys[0], querys[1],querys[2], querys[3], querys[4], querys[5], querys[6],
														 querys[7], querys[8], querys[9],querys[10], querys[11], querys[12], querys[13], 
														 querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], 
														 querys[21], querys[22], querys[23], querys[24], infoUsu.getUname(),pstm, connBD);			
			
			String strLog = "Actualizo  " + ECapturado+ ""   +  "   QUERYS-21[" + strQry + "]";
			Cls_Log.insertaLog(infoUsu, "", "",  strLog );	
			actualizoECapturadoBD = true;
		}
		catch(Exception ex)
		{
			String sError= ex.getMessage().toString();
			Cls_Log.insertaLog(infoUsu, "", "", "Error al actualizar egreso XID: [" + sError + "]   " +  "   QUERYS-21[" + strQry + "]");
		}
		finally
		{
			try {connBD.close();} catch (SQLException e) {e.printStackTrace();}
			try {pstm.close();} catch (SQLException e) {e.printStackTrace();}
		}
		return actualizoECapturadoBD;
	}
		
	/****  CANCELA EGRESOS POR PARAMETRO ****/
	public boolean cancelaEgresosXID(Usuario infoUsu, List<Querys> ListaQuerys, Egresos ECapturado)
	{
		boolean  canceloECapturadoBD = false;
		String strQry = "";
		Connection connBD = null;
		PreparedStatement pstm= null;		
		connBD = ConexionBD.AbrirConexionBD(infoUsu.getUname());
		try
		{
			String[] querys = new String[25];	
			querys = Cls_Querys.LimpiaListaQuerys(querys);	
			querys = Cls_Querys.ObtieneQuerys(16, ListaQuerys, querys, infoUsu);
			querys = InicializaQueryNumero16(querys, infoUsu, ECapturado);
			strQry = Cls_MetodosGlobales.obtieneSentenciaDeQrys(querys);
			pstm = connBD.prepareStatement("{call " + "CTRL_INGRESOS.usp_EXECUTE_QUERY(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			EjecutaQuerysBD.EjecutarQuery(querys[0], querys[1],querys[2], querys[3], querys[4], querys[5], querys[6],
														 querys[7], querys[8], querys[9],querys[10], querys[11], querys[12], querys[13], 
														 querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], 
														 querys[21], querys[22], querys[23], querys[24], infoUsu.getUname(),pstm, connBD);	
		
			String strLog = "Cancelo el  Egreso [Folio: " + ECapturado.getFolio_caja()+  "]  " +  "   QUERYS-16[" + strQry + "]";
			Cls_Log.insertaLog(infoUsu, "", "",  strLog );	
			canceloECapturadoBD = true;
		}
		catch(Exception ex)
		{
			String sError= ex.getMessage().toString();
			Cls_Log.insertaLog(infoUsu, "", "", "Error al cancelar egreso XID: [" + sError + "]  " +  "   QUERYS-16[" + strQry + "]");
		}
		finally
		{
			try {connBD.close();} catch (SQLException e) {e.printStackTrace();}
			try {pstm.close();} catch (SQLException e) {e.printStackTrace();}
		}
		return canceloECapturadoBD;
	}
					
	/****  VALIDA FIRMA MANCOMUNADA PARA EGRESO ****/
	public boolean validaFirmaMancomunadaParaEgresos(Usuario infoUsu, List<Querys> ListaQuerys,String cve_usu, String password)
	{
		boolean  firmaElectronicaCorrecta = false;
		String strQry = "";
		Connection connBD = null;
		PreparedStatement pstm= null;		
		connBD = ConexionBD.AbrirConexionBD(infoUsu.getUname());
		try
		{
			String[] querys = new String[25];	
			querys = Cls_Querys.LimpiaListaQuerys(querys);	
			querys = Cls_Querys.ObtieneQuerys(22, ListaQuerys, querys, infoUsu);
			querys = InicializaQueryNumero22(querys, infoUsu, cve_usu, password);
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
					if(rs.getString("cve_usu") != "" &&  rs.getString("cve_usu") != null)
						firmaElectronicaCorrecta = true;
				}
			}
			
			String strLog = "Valida Firma Mancomunada [Usuario: " + cve_usu + " Password: " +  password +  "]  " +  "   QUERYS-22[" + strQry + "]";
			Cls_Log.insertaLog(infoUsu, "", "",  strLog );
		}
		catch(Exception ex)
		{
			String sError= ex.getMessage().toString();
			Cls_Log.insertaLog(infoUsu, "", "", "Error al validar firma mancomunada: [" + sError + "]   " +  "   QUERYS-22[" + strQry + "]");
		}
		finally
		{
			try {connBD.close();} catch (SQLException e) {e.printStackTrace();}
			try {pstm.close();} catch (SQLException e) {e.printStackTrace();}
		}
		return firmaElectronicaCorrecta;
	}
		
	/**** INICIALIZA LOS QUERYS DE EGRESOS****/
	private String[] InicializaQueryNumero15(String[] ListaQuerys, Usuario infoUsu,Egresos ECapturado) {
		
		for (int i=0;i <ListaQuerys.length; i++)
		{			
			ListaQuerys[i]= ListaQuerys[i].replace("{ESTATUS}", ECapturado.getId_estatus());	
			ListaQuerys[i]= ListaQuerys[i].replace("{FECHA_INICIO}", ECapturado.getFecha_inicio());
			ListaQuerys[i]= ListaQuerys[i].replace("{FECHA_FIN}", ECapturado.getFecha_fin());
			if(ECapturado.getId_egreso() > 0)
				ListaQuerys[i]= ListaQuerys[i].replace("{ID_EGRESO}", String.valueOf(ECapturado.getId_egreso()));
			else
				ListaQuerys[i]= ListaQuerys[i].replace("{ID_EGRESO}","1,2,3,4,5,6,7");
			
		}
		return ListaQuerys;
	}
		
	private String[] InicializaQueryNumero16(String[] ListaQuerys, Usuario infoUsu,Egresos ECapturado) {
		
		for (int i=0;i <ListaQuerys.length; i++)
		{
			ListaQuerys[i]= ListaQuerys[i].replace("{FOLIO_CAJA}", String.valueOf(ECapturado.getFolio_caja()));
			ListaQuerys[i]= ListaQuerys[i].replace("{ID_EGRESO}", String.valueOf(ECapturado.getId_egreso()));
			ListaQuerys[i]= ListaQuerys[i].replace("{ESTATUS}", "9");	
			ListaQuerys[i]= ListaQuerys[i].replace("{USUARIO}", infoUsu.getCve_usuario());
		}
		return ListaQuerys;
	}

	private String[] InicializaQueryNumero_19_20_14(String[] ListaQuerys, Usuario infoUsu,Egresos ECapturado)
	{
		String str_Fecha_Poliza[] = ECapturado.getFecha_poliza().split("/"); 
		String cve_banco_deposito= String.valueOf(ECapturado.getBanco_deposito());
		
		for (int i=0;i <ListaQuerys.length; i++)
		{
			ListaQuerys[i]= ListaQuerys[i].replace("{CONCEPTO}", "2");
			ListaQuerys[i]= ListaQuerys[i].replace("{TEGRESO}", String.valueOf(ECapturado.getId_egreso()));
			ListaQuerys[i]= ListaQuerys[i].replace("{TIPO_EGRESO}", String.valueOf(ECapturado.getId_egreso()));
			if(ECapturado.getId_egreso() == 1 || ECapturado.getId_egreso() == 2)
			{
				ListaQuerys[i]= ListaQuerys[i].replace("@FOLIO_EGRESO", String.valueOf(ECapturado.getFolio_documento()));
				ListaQuerys[i]= ListaQuerys[i].replace("{USUARIO_AUTORIZA}", "");
			}
			else
			{
				ListaQuerys[i]= ListaQuerys[i].replace("{USUARIO_AUTORIZA}", ECapturado.getCve_usu_autoriza());
			}			
			
			if(cve_banco_deposito.equals("0") || cve_banco_deposito.equals("21"))
			{
				cve_banco_deposito = "10";
			}			
			ListaQuerys[i]= ListaQuerys[i].replace("{IMPORTE}", ECapturado.getImporte());
			ListaQuerys[i]= ListaQuerys[i].replace("{BANCO}", String.valueOf(ECapturado.getBanco_emisor()));
			ListaQuerys[i]= ListaQuerys[i].replace("{BANCO_DEPOSITO}", cve_banco_deposito);
			ListaQuerys[i]= ListaQuerys[i].replace("{REFERENCIA}", ECapturado.getReferencia().toUpperCase());
			ListaQuerys[i]= ListaQuerys[i].replace("{USUARIO}", infoUsu.getCve_usuario());	
			ListaQuerys[i]= ListaQuerys[i].replace("{FECHA_POLIZA}", str_Fecha_Poliza[2] + "-" + str_Fecha_Poliza[1] + "-" + str_Fecha_Poliza[0]);
			ListaQuerys[i]= ListaQuerys[i].replace("{COLECTIVA}", String.valueOf(ECapturado.getColectiva()));
		}
		return ListaQuerys;
	}

	private String[] InicializaQueryNumero21(String[] ListaQuerys, Usuario infoUsu,Egresos ECapturado) {
		
		for (int i=0;i <ListaQuerys.length; i++)
		{
			ListaQuerys[i]= ListaQuerys[i].replace("{NUMERO_TRANSFERENCIA}", ECapturado.getNumero_transferencia());
			ListaQuerys[i]= ListaQuerys[i].replace("{CVE_BANCO_TRANSFERENCIA}",String.valueOf(ECapturado.getBanco_transferencia()));
			ListaQuerys[i]= ListaQuerys[i].replace("{ID_EGRESO}", String.valueOf(ECapturado.getId_egreso()));	
			ListaQuerys[i]= ListaQuerys[i].replace("{FOLIO_CAJA}", String.valueOf(ECapturado.getFolio_caja()));
		}
		return ListaQuerys;
	}
	
	private String[] InicializaQueryNumero22(String[] ListaQuerys, Usuario infoUsu,String cve_usu, String password) {
		
		for (int i=0;i <ListaQuerys.length; i++)
		{
			ListaQuerys[i]= ListaQuerys[i].replace("{USUARIO}", cve_usu);
			ListaQuerys[i]= ListaQuerys[i].replace("{PASSWORD}",password);
		}
		return ListaQuerys;
	}

	private String[] inicializaQueryNumero95(String[] ListaQuerys,  Usuario infoUsu, Egresos ICapturado)
	{
		for (int i=0;i <ListaQuerys.length; i++)
		{
			ListaQuerys[i]= ListaQuerys[i].replace("{FECHA}", String.valueOf(ICapturado.getFecha_poliza()));
			ListaQuerys[i]= ListaQuerys[i].replace("{TIPO_PAGO}", String.valueOf(ICapturado.getId_egreso()));
			ListaQuerys[i]= ListaQuerys[i].replace("{FOLIO}", String.valueOf(ICapturado.getFolio_caja()));
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

}
