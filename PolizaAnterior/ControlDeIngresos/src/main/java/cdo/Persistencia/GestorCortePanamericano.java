package cdo.Persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import cdo.Datos.CorteDeCaja;
import cdo.Datos.Querys;
import cdo.Datos.Usuario;
import cdo.util.Cls_Log;
import cdo.util.Cls_MetodosGlobales;
import cdo.util.Cls_Querys;
import cdo.util.ConexionBD;
import cdo.util.EjecutaQuerysBD;

public class GestorCortePanamericano {
	
	DecimalFormat formatoDecimal = new DecimalFormat("#,###.00");
	
	
	/****  CONSULTA DE CORTES DE CAJA POR FECHA Y ESTATUS  ****/
	public List<CorteDeCaja> consultarCortesDeCajaEnBD(Usuario infoUsu, List<Querys> ListaQuerys, String fecha_ini , String fecha_fin, String idEstatus, String origen, String papeleta, 
													   String plomo, String folio_corte, String folio_panamericano)
	{
		List<CorteDeCaja> listaCortesDeCaja = new ArrayList<>();
		String strQry="";
		Connection connBD = null;
		PreparedStatement pstm= null;		
		connBD = ConexionBD.AbrirConexionBD(infoUsu.getUname());
		try
		{
			String[] querys = new String[25];	
			querys = Cls_Querys.LimpiaListaQuerys(querys);	
			querys = Cls_Querys.ObtieneQuerys(27, ListaQuerys, querys, infoUsu);
			querys = InicializaQueryNumero27(querys, infoUsu, fecha_ini,fecha_fin,idEstatus, origen, papeleta, plomo, folio_corte, folio_panamericano);
			strQry = Cls_MetodosGlobales.obtieneSentenciaDeQrys(querys);
//			for (String string : querys) {
//				System.out.println(string);
//			}
			pstm = connBD.prepareStatement("{call " + "CTRL_INGRESOS.usp_EXECUTE_QUERY(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			ResultSet rs= EjecutaQuerysBD.EjecutarQuery(querys[0], querys[1],querys[2], querys[3], querys[4], querys[5], querys[6],
														 querys[7], querys[8], querys[9],querys[10], querys[11], querys[12], querys[13], 
														 querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], 
														 querys[21], querys[22], querys[23], querys[24], infoUsu.getUname(),pstm, connBD);
		
			Cls_Log.insertaLog(infoUsu, "", "", " Consulta Corte Panamericano : [ FechaIni: " +fecha_ini + ", FechaFin: " +fecha_fin + ", Estatus: " + idEstatus  +"]   "  +  "    QUERIES-27[" + strQry + "]");
			
			if(rs !=null)
				listaCortesDeCaja = llenaClaseCorteDeCaja(rs);
		}
		catch(Exception ex)
		{
			String sError= ex.getMessage().toString(); 
			Cls_Log.insertaLog(infoUsu, "", "", "Error al consultar los egresos: [" + sError + "]    "  +  "   QUERIES-27[" + strQry + "]");
		}
		finally
		{
			try {connBD.close();} catch (SQLException e) {e.printStackTrace();}
			try {pstm.close();} catch (SQLException e) {e.printStackTrace();}
		}
		
		return listaCortesDeCaja;
		
	}
		
	public List<CorteDeCaja> llenaClaseCorteDeCaja(ResultSet rs)
	{
		List<CorteDeCaja> listaCortesDeCaja = new ArrayList<>();
		try 
		{
			while(rs.next())
			{
				String[] arrayFecha = rs.getString("fecha_pro").split("-");
				String fechaCorte =  arrayFecha[2] + "/" + arrayFecha[1] + "/" + arrayFecha[0];
						
				arrayFecha = rs.getString("fecha_panamericano").trim().split("-");		
				String fechaPanamericano =(arrayFecha.length >=3) ? arrayFecha[2] + "/" + arrayFecha[1] + "/" + arrayFecha[0] : "";
	
				CorteDeCaja corteCaja =new CorteDeCaja();
				corteCaja.setUname(rs.getString("uname"));
				corteCaja.setUname_br(rs.getString("uname_br"));
				corteCaja.setEstatus(rs.getInt("id_estatus"));
				corteCaja.setFecha_corteCaja(fechaCorte);
				corteCaja.setFolio_corte(rs.getString("folio_corte_caja"));
				corteCaja.setFolio_panamericano(rs.getInt("folio_panamericano"));
				corteCaja.setFolio_poliza(rs.getInt("folio_poliza"));
				corteCaja.setHora_corteCaja(rs.getString("hora_pro"));
				corteCaja.setImporte(formatoDecimal.format(rs.getDouble("importe")));
				corteCaja.setImporteEfectivo(formatoDecimal.format(rs.getDouble("importeEfectivo")));
				corteCaja.setNombre_usuario(rs.getString("nombre"));
				corteCaja.setUsuario(rs.getString("cve_usu"));
				corteCaja.setFecha_panamericano(fechaPanamericano);
				corteCaja.setFolio_panamericano(rs.getInt("folio_panamericano"));
				corteCaja.setFecha_poliza("1900-01-01");
				corteCaja.setChecked(false);
				corteCaja.setPapeleta(rs.getString("papeleta"));
				corteCaja.setPlomo(rs.getString("plomo"));
				corteCaja.setUsuario_panamericano(rs.getString("cve_usu_panamericano"));
				corteCaja.setNombre_usuario_panamericano(rs.getString("nombre_usu_panamericano"));
				listaCortesDeCaja.add(corteCaja);
			}
		} 
		catch (Exception ex) 
		{
			ex.getMessage().toString();
			System.out.println("Error al llenar clase cortes de caja pendientes. Detalle: " + ex.getMessage().toString() );
		}
		return listaCortesDeCaja;
	}
		
	private String generaSetenciaFecha(String  fecha)
	{
		String arrayFecha[] =  fecha.split("/");
		String sentencia_fecha = ""; 
		sentencia_fecha = arrayFecha[2] + "-" + arrayFecha[1] + "-" + arrayFecha[0];
		return sentencia_fecha;
	}

	
	/****  GENERA CORTE DE PANAMERICANO ****/	
	public boolean generaCortePanamericano(Usuario infoUsu, List<Querys> ListaQuerys,String importe, String NumPlomo, String NumPapeleta, String strJsonCortesCaja, String fechaPolizaRecValores)
	{
		Connection connBD = null;
		String strQry="";
		PreparedStatement pstm= null;		
		connBD = ConexionBD.AbrirConexionBD(infoUsu.getUname());
		boolean generoCortePanamericano = false;
		try
		{
			String[] querys = new String[25];	
			
			querys = Cls_Querys.LimpiaListaQuerys(querys);	
			querys = Cls_Querys.ObtieneQuerys(79, ListaQuerys, querys, infoUsu);
			strQry = Cls_MetodosGlobales.obtieneSentenciaDeQrys(querys);
			pstm = connBD.prepareStatement("{call " + "CTRL_INGRESOS.usp_EXECUTE_QUERY(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			ResultSet rsValida= EjecutaQuerysBD.EjecutarQuery(querys[0], querys[1],querys[2], querys[3], querys[4], querys[5], querys[6],
														 querys[7], querys[8], querys[9],querys[10], querys[11], querys[12], querys[13], 
														 querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], 
														 querys[21], querys[22], querys[23], querys[24], infoUsu.getUname(),pstm, connBD);
						
			Cls_Log.insertaLog(infoUsu, "", "", "  Panamericano valida si existe poliza del dia actual.    "  +  " QUERIES-79[" + strQry + "]");
			
			
			String fecha_poliza = obtieneFechaPolizaParaPanamericano(rsValida, fechaPolizaRecValores,infoUsu );			
			querys = Cls_Querys.LimpiaListaQuerys(querys);	
			querys = Cls_Querys.ObtieneQuerys(49, ListaQuerys, querys, infoUsu);
			String foliosDeCorteCaja= obtieneFoliosDeCorteDeCaja(infoUsu,strJsonCortesCaja);
			querys = InicializaQueryNumero49(querys, infoUsu, importe, NumPlomo, NumPapeleta,foliosDeCorteCaja, fecha_poliza);		
			strQry = Cls_MetodosGlobales.obtieneSentenciaDeQrys(querys);
			pstm = connBD.prepareStatement("{call " + "CTRL_INGRESOS.usp_EXECUTE_QUERY(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");			
			EjecutaQuerysBD.EjecutarQuery(querys[0], querys[1],querys[2], querys[3], querys[4], querys[5], querys[6],
														 querys[7], querys[8], querys[9],querys[10], querys[11], querys[12], querys[13], 
														 querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], 
														 querys[21], querys[22], querys[23], querys[24], infoUsu.getUname(),pstm, connBD);
			Cls_Log.insertaLog(infoUsu, "", "", "Genero corte Panamericano : [ Folios Corte Caja: (" + foliosDeCorteCaja + "), Importe:" +  importe + ", Plomo:" +  NumPlomo + ", Papeleta:" +  NumPapeleta + ", Fecha Poliza: " +fecha_poliza.replace("'", "")+ "]     "    +  "   QUERIES-49[" + strQry + "]");
			generoCortePanamericano = true;
		}
		catch(Exception ex)
		{
			String sError= ex.getMessage().toString();
			Cls_Log.insertaLog(infoUsu, "", "", "Error al consultar los egresos: [" + sError + "]    " +  "   QUERIES-49[" + strQry + "]");
		}
		finally
		{
			try {connBD.close();} catch (SQLException e) {e.printStackTrace();}
			try {pstm.close();} catch (SQLException e) {e.printStackTrace();}
		}
		
		return generoCortePanamericano;
	}
	
	
	private String  obtieneFechaPolizaParaPanamericano(ResultSet rsValida, String fechaPolizaRecValores,Usuario infoUsu)
	{
		Cls_Log.insertaLog(infoUsu, "", "", "Ingresa fecha de poliza para corte panamericano. " + "[Fecha Usuario: " + fechaPolizaRecValores + "]");
		boolean existePoliza= false;
		String fecha_poliza = "";		
		try
		{	
			SimpleDateFormat sdformat = new SimpleDateFormat("yyyy-MM-dd");	    	
			String []array= fechaPolizaRecValores.split("/");
		    Date fechaPolizaRecVal = sdformat.parse(array[2] + "-" + array[1] + "-" + array[0]);
		    	
		    Cls_Log.insertaLog(infoUsu, "", "", "Sistema formatea fecha para corte panamericano. " + "[Fecha Usuario con Formato: " + fechaPolizaRecVal +"]");

		    LocalDate fechaActual = LocalDate.now();
			String mes = (String.valueOf(fechaActual.getMonthValue()).length() > 1) ? String.valueOf(fechaActual.getMonthValue()) : "0" + fechaActual.getMonthValue();			
			String dia = (String.valueOf(fechaActual.getDayOfMonth()).length() > 1) ? String.valueOf(fechaActual.getDayOfMonth()) : "0" + fechaActual.getDayOfMonth();			
		    Date fActual = sdformat.parse(fechaActual.getYear() + "-" + mes + "-" + dia);
		    
		    Cls_Log.insertaLog(infoUsu, "", "", "Sistema obtiene fecha actual. [Fecha Actual: "  + fActual + "] ");
		    	    
			if(rsValida !=null)
			{
				rsValida.beforeFirst();
				while(rsValida.next())
				{
					if(rsValida.getString("tipo").equals("POL_EXISTEN"))
					{					
						if(rsValida.getInt("polizas_generadas") > 0)
						{
							existePoliza = true;
							break;
						}
					}
				}
			}
			
			Cls_Log.insertaLog(infoUsu, "", "", "Sistema valida si existe un poliza del dia. [Existe poliza: "  + existePoliza + "] ");
			
			Date dateSabado= new Date();
			Calendar cal = Calendar.getInstance();
			cal.setTime(dateSabado);			
			if(cal.get(Calendar.DAY_OF_WEEK)  == 7)
			{
				fecha_poliza = " '" + array[2] + "-" + array[1] + "-" + array[0] + "' ";
			}
			else
			{
				if(existePoliza == true)
				{
					if(fechaPolizaRecVal.compareTo(fActual) > 0) 
				    {
				    	fecha_poliza = " '" + array[2] + "-" + array[1] + "-" + array[0] + "' ";
				    }
					else
					{
						SimpleDateFormat formatter = new SimpleDateFormat("ddMMyyyy");					
						Calendar c = Calendar.getInstance(); 
						c.add(Calendar.DATE, 1);	
						Date fechaHoraSistema = c.getTime();
						String fechaSistema = formatter.format(fechaHoraSistema);			        
						fecha_poliza = " '" + String.valueOf(fechaSistema.substring(4, 8)) + "-" + String.valueOf(fechaSistema.substring(2, 4)) + "-"+ String.valueOf(fechaSistema.substring(0, 2)) +  "' " ;					
					}
				}
				else
				{
				    fecha_poliza = " CURDATE()";
				}
			}
			Cls_Log.insertaLog(infoUsu, "", "", "Genera Fecha poliza para corte panamericano. [Fecha Poliza: "  + fecha_poliza.replace("'", "") + "] ");
			
		}
		catch(Exception ex)
		{
			System.out.println("Error al obtener fecha de poliza de panamericano." + ex.getMessage().toString());
			Cls_Log.insertaLog(infoUsu, "", "", "Error al obtener fecha de poliza de panamericano: [" + ex.getMessage().toString() + "]");
		}
		return fecha_poliza;
	}
	
	private String  obtieneFoliosDeCorteDeCaja(Usuario infoUsu,String strJsonCortesCaja)
	{
		String foliosDeCorteCaja= "";
		try
		{
			JSONArray jsonCortesCaja = new JSONArray(strJsonCortesCaja);
		    for (int i = 0; i < jsonCortesCaja.length(); i++)
		    {
		        JSONObject rs = jsonCortesCaja.getJSONObject(i);
		        if(rs.getBoolean("checked"))
		        {
		        	foliosDeCorteCaja += String.valueOf(rs.getInt("folio_corte")) + ",";
		        }
		    }
		    foliosDeCorteCaja = foliosDeCorteCaja.substring(0,foliosDeCorteCaja.length()-1);
		}
		catch(Exception ex)
		{
			String sError= ex.getMessage().toString();
			Cls_Log.insertaLog(infoUsu, "", "", "Error al consultar los egresos: [" + sError + "]");
		}
		return foliosDeCorteCaja;
	}


	
	/**** INICIALIZA LOS QUERYS DE EGRESOS****/	
	private String[] InicializaQueryNumero27(String[] ListaQuerys, Usuario infoUsu, String fecha_ini , String fecha_fin, String idEstatus, String origen, String papeleta,  String plomo,String folio_corte, String folio_panamericano) {
		
		for (int i=0;i <ListaQuerys.length; i++)
		{
			ListaQuerys[i]= ListaQuerys[i].replace("{ESTATUS}",idEstatus);
			String str_papeleta=(papeleta.trim().equals(""))? "": " AND C.papeleta = '" + papeleta.trim() + "' " ;
			String str_plomo=(plomo.trim().equals(""))? "": " AND C.plomo = '" + plomo.trim() + "' ";
			String str_folio_corte=(folio_corte.trim().equals(""))? "": " AND A.folio_corte_caja = '" + folio_corte.trim() + "' ";
			String str_folio_panamericano=(folio_panamericano.trim().equals(""))? "":  " AND A.folio_panamericano = '" + folio_panamericano.trim() + "' ";				
			
			if(!origen.equals("0"))
			{				
				ListaQuerys[i]= ListaQuerys[i].replace("{FECHAS}", " AND  A.fecha_pro >= '" + generaSetenciaFecha(fecha_ini) + "' AND A.fecha_pro <= '" + generaSetenciaFecha(fecha_fin)+ "'");
				ListaQuerys[i]= ListaQuerys[i].replace("{PAPELETA}",str_papeleta);
				ListaQuerys[i]= ListaQuerys[i].replace("{PLOMO}", str_plomo );
				ListaQuerys[i]= ListaQuerys[i].replace("{FOLIO_CORTE}", str_folio_corte);
				ListaQuerys[i]= ListaQuerys[i].replace("{FOLIO_PANAMERICANO}",str_folio_panamericano);
			}
			else
			{
				ListaQuerys[i]= ListaQuerys[i].replace("{FECHAS}", " ");
				ListaQuerys[i]= ListaQuerys[i].replace("{PAPELETA}","");
				ListaQuerys[i]= ListaQuerys[i].replace("{PLOMO}", "" );
				ListaQuerys[i]= ListaQuerys[i].replace("{FOLIO_CORTE}", "");
				ListaQuerys[i]= ListaQuerys[i].replace("{FOLIO_PANAMERICANO}","");
			}
		}
		return ListaQuerys;
	}
	
	private String[] InicializaQueryNumero49(String[] ListaQuerys, Usuario infoUsu, String importe , String plomo, String papeleta, String foliosDeCorteCaja, String fecha_poliza) {		
		for (int i=0;i <ListaQuerys.length; i++)
		{
			ListaQuerys[i]= ListaQuerys[i].replace("'{TIPO_CORTE}'","2");
			ListaQuerys[i]= ListaQuerys[i].replace("{IMPORTE}", importe);
			ListaQuerys[i]= ListaQuerys[i].replace("{PLOMO}", plomo);
			ListaQuerys[i]= ListaQuerys[i].replace("{PAPELETA}", papeleta);
			ListaQuerys[i]= ListaQuerys[i].replace("{CVE_USU}", infoUsu.getCve_usuario());
			ListaQuerys[i]= ListaQuerys[i].replace("{FOLIOS_CORTES_CAJA}", foliosDeCorteCaja);
			ListaQuerys[i]= ListaQuerys[i].replace("{FECHA_POLIZA}", fecha_poliza);
		}
		return ListaQuerys;
	}
	
	

}
