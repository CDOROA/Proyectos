package cdo.Persistencia;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.naming.spi.DirStateFactory.Result;

import org.apache.poi.hssf.record.PageBreakRecord.Break;
import org.json.JSONArray;
import org.json.JSONObject;

import cdo.Datos.Ingresos;
import cdo.Datos.Linea_Bancaria_Azteca;
import cdo.Datos.Linea_Bancaria_BBVA;
import cdo.Datos.Linea_Bancaria_Banamex;
import cdo.Datos.Linea_Bancaria_Banorte;
import cdo.Datos.Linea_Bancaria_Concentrado;
import cdo.Datos.Linea_Bancaria_Detalle_Concentrado;
import cdo.Datos.Linea_Bancaria_HSBC;
import cdo.Datos.Linea_Bancaria_Layouts;
import cdo.Datos.Linea_Bancaria_Lista_Bancos;
import cdo.Datos.Querys;
import cdo.Datos.Usuario;
import cdo.util.Cls_Log;
import cdo.util.Cls_MetodosGlobales;
import cdo.util.Cls_Querys;
import cdo.util.ConexionBD;
import cdo.util.EjecutaQuerysBD;
import cdo.web.LineaBancariaServlet;

public class GestorLineaBancaria 
{			
	/**** INSERTA LINEAS BANCARIAS ****/
	public List<Linea_Bancaria_Layouts> obtieneLayoutsDeLasLineasBancarias(Usuario infoUsu, List<Querys> ListaQuerys)
	{
		List<Linea_Bancaria_Layouts> lineasBanLayouts= new ArrayList<>();
		Connection connBD = null;
		PreparedStatement pstm= null;		
		connBD = ConexionBD.AbrirConexionBD(infoUsu.getUname());
		
		try
		{
			String[] querys = new String[25];	
			querys = Cls_Querys.LimpiaListaQuerys(querys);	
			querys = Cls_Querys.ObtieneQuerys(37, ListaQuerys, querys, infoUsu);
			pstm = connBD.prepareStatement("{call " + "CTRL_INGRESOS.usp_EXECUTE_QUERY(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			ResultSet rs=  EjecutaQuerysBD.EjecutarQuery(querys[0], querys[1],querys[2], querys[3], querys[4], querys[5], querys[6],
														 querys[7], querys[8], querys[9],querys[10], querys[11], querys[12], querys[13], 
														 querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], 
														 querys[21], querys[22], querys[23], querys[24], infoUsu.getUname(),pstm, connBD);
			
			if (rs != null)
			{
				lineasBanLayouts = cargarClaseLineasBancariasLayout(infoUsu, rs);
			}
		}
		catch(Exception ex)
		{
			System.out.println("Error al consultar layouts de lineas bancarias");
			Cls_Log.insertaLog(infoUsu, "", "", "Error al consultar ingresos por parametro [" + ex.getMessage().toString()+ "]");	
		}
		finally
		{
			try {pstm.close();} catch (SQLException e) {e.printStackTrace();}
			try {connBD.close();} catch (SQLException e) {e.printStackTrace();}
		}
		return lineasBanLayouts;
	}
	
	private List<Linea_Bancaria_Layouts> cargarClaseLineasBancariasLayout(Usuario infoUsu, ResultSet rs)
	{
		List<Linea_Bancaria_Layouts> lineasBanLayouts= new ArrayList<>();
		try
		{
			while(rs.next())
			{
				Linea_Bancaria_Layouts lineaLayout=new Linea_Bancaria_Layouts();
				lineaLayout.setCve_banco(rs.getInt("cve_banco"));
				lineaLayout.setLayout_archivo(rs.getString("layout_archivo"));
				lineaLayout.setColumnas_tabla_bd(rs.getString("columnas_tabla_bd"));
				lineaLayout.setColumnas_excel(rs.getString("columnas_excel"));
				lineaLayout.setNombre_tabla_bd(rs.getString("nombre_tabla_bd"));
				lineaLayout.setUname(rs.getString("uname"));
				lineaLayout.setUname_br(rs.getString("uname_br"));
				lineasBanLayouts.add(lineaLayout);
			}
		}
		catch(Exception ex)
		{
			System.out.println("Error al cargar clase  layouts de lineas bancarias");
			Cls_Log.insertaLog(infoUsu, "", "", "Error al cargar clase  layouts de lineas bancarias [" + ex.getMessage().toString()+ "]");	
		}
		
		return lineasBanLayouts;
	}

	public boolean insertaInformacionLineaBancaria(Usuario infoUsu, String sentenciaDelete, String sentenciaInsert, String banco)
	{
		Connection connBD = null;
		PreparedStatement pstm= null;		
		connBD = ConexionBD.AbrirConexionBD(infoUsu.getUname());
		boolean insertoEnBD = false;
		try
		{
			pstm = connBD.prepareStatement("{call " + "CTRL_INGRESOS.usp_EXECUTE_QUERY(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			ResultSet rs = EjecutaQuerysBD.EjecutarQuery(sentenciaDelete, sentenciaInsert,"","","","","","","","","","","","","","","","","","","","","","","", infoUsu.getUname(),pstm, connBD);
			
			if(rs ==null)
				insertoEnBD = false;
			else
				insertoEnBD = true;
			
			Cls_Log.insertaLog(infoUsu, "", "", " Sube linea bancaria  " + obtieneNombreDelBanco(banco) +" Qry Elimina:[ "+ sentenciaDelete.replace("'", "").replace(",", "|") + " ]  Qry Inserta:[ " + sentenciaInsert.replace("'", "").replace(",", "|") + " ]");
		}
		catch(Exception ex)
		{
			System.out.println("Error al insertar lineas bancarias");
			Cls_Log.insertaLog(infoUsu, "", "", "Error al insertar lineas bancarias [" + ex.getMessage().toString()+ "]");	
		}
		finally
		{
			try {pstm.close();} catch (SQLException e) {e.printStackTrace();}
			try {connBD.close();} catch (SQLException e) {e.printStackTrace();}
		}
		return insertoEnBD;
	}
	
	private String obtieneNombreDelBanco(String banco)
	{
		String nombreBanco="";
		switch(banco)
		{
			case "16"://HSBC
				nombreBanco="Hsbc";
				break;
			
			case "5"://AZTECA
				nombreBanco="Azteca";
				break;
				
			case "12"://BANORTE
				nombreBanco="Banorte";	
				break;
				
			case "4"://BANCOMER
				nombreBanco="Bbva";
				break;
				
			case "10"://BANAMEX
				nombreBanco="Banamex";
				break;
		}
		return nombreBanco;
	}
		
	
	/**** CONSULTA LINEAS BANCARIAS PENDIENTES ****/	
	public Linea_Bancaria_Lista_Bancos consultaLineasBancariasExistentesBD(Usuario infoUsu, List<Querys> ListaQuerys,String IdEstatus)
	{
		Linea_Bancaria_Lista_Bancos lista_lineasBancos= new Linea_Bancaria_Lista_Bancos();
		Connection connBD = null;
		PreparedStatement pstm= null;		
		connBD = ConexionBD.AbrirConexionBD(infoUsu.getUname());
		try
		{
			String[] querys = new String[25];	
			querys = Cls_Querys.LimpiaListaQuerys(querys);	
			querys = Cls_Querys.ObtieneQuerys(38, ListaQuerys, querys, infoUsu);
			querys = inicializaQueryNumero38(querys, infoUsu, IdEstatus );
			
			pstm = connBD.prepareStatement("{call " + "CTRL_INGRESOS.usp_EXECUTE_QUERY(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			ResultSet rs=  EjecutaQuerysBD.EjecutarQuery(querys[0], querys[1],querys[2], querys[3], querys[4], querys[5], querys[6],
														 querys[7], querys[8], querys[9],querys[10], querys[11], querys[12], querys[13], 
														 querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], 
														 querys[21], querys[22], querys[23], querys[24], infoUsu.getUname(),pstm, connBD);

			if (rs != null)
			{
				lista_lineasBancos.setLinea_bancaria_banamex(llenaClaseLineaBanamex(rs,infoUsu));
				lista_lineasBancos.setLinea_bancaria_HSBC(llenaClaseLineaHSBC(rs,infoUsu));
				lista_lineasBancos.setLinea_bancaria_BBVA(llenaClaseLineaBBVA(rs,infoUsu));
				lista_lineasBancos.setLinea_bancaria_azteca(llenaClaseLineaAzteca(rs,infoUsu));
				lista_lineasBancos.setLinea_bancaria_banorte(llenaClaseLineaBanorte(rs,infoUsu));
			}			
			Cls_Log.insertaLog(infoUsu, "", "", "Consulta Lineas Bancarias Pendientes");
		}
		catch(Exception ex)
		{
			String sError= ex.getMessage().toString();
			Cls_Log.insertaLog(infoUsu, "", "", "Error al consultar lineas bancarias [" + ex.getMessage().toString()+ "]");
		}
		finally
		{
			try {pstm.close();} catch (SQLException e) {e.printStackTrace();}
			try {connBD.close();} catch (SQLException e) {e.printStackTrace();}
		}
		return lista_lineasBancos;
	}
			
	private List<Linea_Bancaria_Banamex> llenaClaseLineaBanamex(ResultSet rs , Usuario infoUsu)
	{
		List<Linea_Bancaria_Banamex> lista_lineas_banamex=new ArrayList<>();
		try
		{
			rs.beforeFirst();
			while(rs.next())
			{
				if(rs.getString("banamex").equals("*"))
				{	
					Linea_Bancaria_Banamex lineaBanamex=new Linea_Bancaria_Banamex();
					lineaBanamex.setChecked(false);
					lineaBanamex.setAutorizacion_banamex(rs.getString("autorizacion_banamex"));
					lineaBanamex.setBanco_emisor_banamex(rs.getString("banco_emisor_banamex"));
					lineaBanamex.setCve_banco_banamex(rs.getInt("cve_banco_banamex"));
					lineaBanamex.setCve_movimiento_banamex(rs.getString("cve_movimiento_banamex"));
					lineaBanamex.setCve_usu_banamex(rs.getString("cve_usu_banamex"));
					lineaBanamex.setCve_usu_cr_banamex(rs.getString("cve_usu_cr_banamex"));
					lineaBanamex.setDescripcion_banamex(rs.getString("descripcion_banamex"));
					lineaBanamex.setEstatus_banamex(rs.getString("estatus_banamex"));
					lineaBanamex.setFecha_banamex(rs.getString("fecha_banamex"));
					lineaBanamex.setFecha_pro_banamex(rs.getString("fecha_pro_banamex"));
					lineaBanamex.setId_estatus_banamex(rs.getInt("id_estatus_banamex"));
					lineaBanamex.setId_linea_bancaria_banamex(rs.getInt("id_linea_bancaria_banamex"));
					lineaBanamex.setImporte_banamex(Cls_MetodosGlobales.aplicarFormatoImporte(rs.getBigDecimal("importe_banamex")));
					lineaBanamex.setNumero_cuenta_int_banamex(rs.getString("numero_cuenta_int_banamex"));
					lineaBanamex.setOrdenante_banamex(rs.getString("ordenante_banamex"));
					lineaBanamex.setReferencia_alfanumerica_banamex(rs.getString("referencia_alfanumerica_banamex"));
					lineaBanamex.setReferencia_numerica_banamex(rs.getString("referencia_numerica_banamex"));
					lineaBanamex.setSucursal_banamex(rs.getString("sucursal_banamex"));
					lineaBanamex.setUname_banamex(rs.getString("uname_banamex"));
					lineaBanamex.setNombre_usu_banamex(rs.getString("nombre_usu_cr_banamex"));
					lineaBanamex.setId_tipo_linea_banamex(rs.getInt("id_tipo_linea_banamex"));
					lineaBanamex.setNombre_tipo_linea_banamex(rs.getString("nombre_tipo_linea_banamex"));	
					lineaBanamex.setNum_cliente_banamex(rs.getString("num_cte_banamex"));
					lineaBanamex.setNombre_cliente_banamex(rs.getString("nombre_cte_banamex"));
					lineaBanamex.setNum_agente_banamex(rs.getString("num_agente_banamex"));
					lineaBanamex.setNombre_agente_banamex(rs.getString("nombre_agente_banamex"));
					lista_lineas_banamex.add(lineaBanamex);
				}
			}
		}
		catch(Exception ex)
		{
			String sError= ex.getMessage().toString();
			System.out.println("Error al llenar clase Banamex:" +sError);
			Cls_Log.insertaLog(infoUsu, "", "", "Error al cargar clase linea Banamex  [" + ex.getMessage().toString()+ "]");
		}
		return lista_lineas_banamex;
	}
		
	private List<Linea_Bancaria_HSBC> llenaClaseLineaHSBC(ResultSet rs, Usuario infoUsu)
	{
		List<Linea_Bancaria_HSBC> lista_lineas_HSBC=new ArrayList<>();
		try
		{
			rs.beforeFirst();
			while(rs.next())
			{
				if(rs.getString("hsbc").equals("*"))
				{
					Linea_Bancaria_HSBC lineaHsbc=new Linea_Bancaria_HSBC();
					lineaHsbc.setChecked(false);
					lineaHsbc.setCve_banco_hsbc(rs.getInt("cve_banco_hsbc"));
					lineaHsbc.setCve_usu_cr_hsbc(rs.getString("cve_usu_cr_hsbc"));
					lineaHsbc.setCve_usu_hsbc(rs.getString("cve_usu_hsbc"));
					lineaHsbc.setEstatus_hsbc(rs.getString("estatus_hsbc"));
					lineaHsbc.setFecha_pro_hsbc(rs.getString("fecha_pro_hsbc"));
					lineaHsbc.setFecha_valor_hsbc(rs.getString("fecha_valor_hsbc"));
					lineaHsbc.setId_estatus_hsbc(rs.getInt("id_estatus_hsbc"));
					lineaHsbc.setId_linea_bancaria_hsbc(rs.getInt("id_linea_bancaria_hsbc"));
					lineaHsbc.setImporte_credito_hsbc(Cls_MetodosGlobales.aplicarFormatoImporte(rs.getBigDecimal("importe_credito_hsbc")));
					lineaHsbc.setImporte_debito_hsbc(Cls_MetodosGlobales.aplicarFormatoImporte(rs.getBigDecimal("importe_debito_hsbc")));
					lineaHsbc.setNarrativa_hsbc(rs.getString("narrativa_hsbc"));
					lineaHsbc.setReferencia_banco_hsbc(rs.getString("referencia_banco_hsbc"));
					lineaHsbc.setReferencia_cliente_hsbc(rs.getString("referencia_cliente_hsbc"));
					lineaHsbc.setSaldo_hsbc(Cls_MetodosGlobales.aplicarFormatoImporte(rs.getBigDecimal("saldo_hsbc")));
					lineaHsbc.setUname_hsbc(rs.getString("uname_hsbc"));
					lineaHsbc.setNombre_usu_hsbc(rs.getString("nombre_usu_cr_hsbc"));
					lineaHsbc.setId_tipo_linea_hsbc(rs.getInt("id_tipo_linea_hsbc"));
					lineaHsbc.setNombre_tipo_hsbc(rs.getString("nombre_tipo_linea_hsbc"));
					lineaHsbc.setNum_cliente_hsbc(rs.getString("num_cte_hsbc"));
					lineaHsbc.setNombre_cliente_hsbc(rs.getString("nombre_cte_hsbc"));
					lineaHsbc.setNum_agente_hsbc(rs.getString("num_agente_hsbc"));
					lineaHsbc.setNombre_agente_hsbc(rs.getString("nombre_agente_hsbc"));
					lista_lineas_HSBC.add(lineaHsbc);	
				}
			}
			
		}
		catch(Exception ex)
		{
			String sError= ex.getMessage().toString();
			System.out.println("Error al llenar clase HSBC:" +sError);
			Cls_Log.insertaLog(infoUsu, "", "", "Error al cargar clase linea HSBC  [" + ex.getMessage().toString()+ "]");
		}
		return lista_lineas_HSBC;
	}
	
	private List<Linea_Bancaria_BBVA> llenaClaseLineaBBVA(ResultSet rs, Usuario infoUsu)
	{
		List<Linea_Bancaria_BBVA> lista_lineas_BBVA=new ArrayList<>();
		try
		{
			rs.beforeFirst();			
			while(rs.next())
			{
				if(rs.getString("bbva").equals("*"))
				{
					Linea_Bancaria_BBVA lineaBbva= new Linea_Bancaria_BBVA();
					lineaBbva.setChecked(false);
					lineaBbva.setCodigo_bbva(rs.getString("codigo_bbva"));
					lineaBbva.setConcepto_bbva(rs.getString("concepto_bbva"));
					lineaBbva.setCve_banco_bbva(rs.getInt("cve_banco_bbva"));
					lineaBbva.setCve_usu_bbva(rs.getString("cve_usu_bbva"));
					lineaBbva.setCve_usu_cr_bbva(rs.getString("cve_usu_cr_bbva"));
					lineaBbva.setEstatus_bbva(rs.getString("estatus_bbva"));
					lineaBbva.setFecha_operacion_bbva(rs.getString("fecha_operacion_bbva"));
					lineaBbva.setId_estatus_bbva(rs.getInt("id_estatus_bbva"));
					lineaBbva.setId_linea_bancaria_bbva(rs.getInt("id_linea_bancaria_bbva"));
					lineaBbva.setImporte_bbva(Cls_MetodosGlobales.aplicarFormatoImporte(rs.getBigDecimal("importe_bbva")));
					lineaBbva.setReferencia_ampliada_bbva(rs.getString("referencia_ampliada_bbva"));
					lineaBbva.setReferencia_bbva(rs.getString("referencia_bbva"));
					lineaBbva.setSucursal_bbva(rs.getString("sucursal_bbva"));
					lineaBbva.setUname_bbva(rs.getString("uname_bbva"));
					lineaBbva.setNombre_usu_bbva(rs.getString("nombre_usu_cr_bbva"));
					lineaBbva.setId_tipo_linea_bbva(rs.getInt("id_tipo_linea_bbva"));
					lineaBbva.setNombre_tipo_bbva(rs.getString("nombre_tipo_linea_bbva"));
					lineaBbva.setNum_cliente_bbva(rs.getString("num_cte_bbva"));
					lineaBbva.setNombre_cliente_bbva(rs.getString("nombre_cte_bbva"));
					lineaBbva.setNum_agente_bbva(rs.getString("num_agente_bbva"));
					lineaBbva.setNombre_agente_bbva(rs.getString("nombre_agente_bbva"));
					lineaBbva.setFecha_pro_bbva(rs.getString("fecha_pro_bbva"));
					lista_lineas_BBVA.add(lineaBbva);
				}
			}
		}
		catch(Exception ex)
		{
			String sError = ex.getMessage().toString();
			System.out.println("Error al llenar clase BBVA:" +sError);
			Cls_Log.insertaLog(infoUsu, "", "", "Error al cargar clase linea BBVA  [" + ex.getMessage().toString()+ "]");
		}
		
		return lista_lineas_BBVA;
	}
	
	private List<Linea_Bancaria_Azteca> llenaClaseLineaAzteca(ResultSet rs,Usuario infoUsu)
	{
		List<Linea_Bancaria_Azteca> lista_lineas_Azteca=new ArrayList<>();
		try
		{
			rs.beforeFirst();
			while(rs.next())
			{
				if(rs.getString("azteca").equals("*"))
				{
				Linea_Bancaria_Azteca lineaAzteca=new Linea_Bancaria_Azteca();
				lineaAzteca.setChecked(false);
				lineaAzteca.setCve_banco_azteca(rs.getInt("cve_banco_azteca"));
				lineaAzteca.setCve_usu_azteca(rs.getString("cve_usu_azteca"));
				lineaAzteca.setCve_usu_cr_azteca(rs.getString("cve_usu_cr_azteca"));
				lineaAzteca.setEstatus_azteca(rs.getString("estatus_azteca"));
				lineaAzteca.setFecha_aplicacion_azteca(rs.getString("fecha_aplicacion_azteca"));
				lineaAzteca.setFecha_pro_azteca(rs.getString("fecha_pro_azteca"));
				lineaAzteca.setId_estatus_azteca(rs.getInt("id_estatus_azteca"));
				lineaAzteca.setId_linea_bancaria_azteca(rs.getInt("id_linea_bancaria_azteca"));
				lineaAzteca.setImporte_movimiento_azteca(Cls_MetodosGlobales.aplicarFormatoImporte(rs.getBigDecimal("importe_movimiento_azteca")));
				lineaAzteca.setReferencia_01_azteca(rs.getString("referencia_01_azteca"));
				lineaAzteca.setReferencia_02_azteca(rs.getString("referencia_02_azteca"));
				lineaAzteca.setReferencia_03_azteca(rs.getString("referencia_03_azteca"));
				lineaAzteca.setReferencia_04_azteca(rs.getString("referencia_04_azteca"));
				lineaAzteca.setReferencia_interna_azteca(rs.getString("referencia_interna_azteca"));
				lineaAzteca.setSucursal_operante_azteca(rs.getString("sucursal_operante_azteca"));
				lineaAzteca.setUname_azteca(rs.getString("uname_azteca"));
				lineaAzteca.setNombre_usu_azteca(rs.getString("nombre_usu_cr_azteca"));
				lineaAzteca.setNombre_tipo_azteca(rs.getString("nombre_tipo_linea_azteca"));
				lineaAzteca.setId_tipo_linea_azteca(rs.getInt("id_tipo_linea_azteca"));
				lineaAzteca.setNum_cliente_azteca(rs.getString("num_cte_azteca"));
				lineaAzteca.setNombre_cliente_azteca(rs.getString("nombre_cte_azteca"));
				lineaAzteca.setNum_agente_azteca(rs.getString("num_agente_azteca"));
				lineaAzteca.setNombre_agente_azteca(rs.getString("nombre_agente_azteca"));
				lista_lineas_Azteca.add(lineaAzteca);
				}
			}
		}
		catch(Exception ex)
		{
			String sError= ex.getMessage().toString();
			System.out.println("Error al llenar clase Azteca:" +sError);
			Cls_Log.insertaLog(infoUsu, "", "", "Error al cargar clase linea AZTECA  [" + ex.getMessage().toString()+ "]");
		}
		return lista_lineas_Azteca;
	}
	
	private List<Linea_Bancaria_Banorte> llenaClaseLineaBanorte(ResultSet rs,Usuario infoUsu)
	{
		List<Linea_Bancaria_Banorte> lista_lineas_Banorte=new ArrayList<>();
		try
		{
			rs.beforeFirst();
			while(rs.next())
			{
				if(rs.getString("banorte").equals("*"))
				{
					Linea_Bancaria_Banorte listaBanorte = new Linea_Bancaria_Banorte();
					listaBanorte.setChecked(false);
					listaBanorte.setCheque_banorte(rs.getString("cheque_banorte"));
					listaBanorte.setCod_transaccion_banorte(rs.getString("cod_transaccion_banorte"));
					listaBanorte.setCve_banco_banorte(rs.getInt("cve_banco_banorte"));
					listaBanorte.setCve_usu_banorte(rs.getString("cve_usu_banorte"));
					listaBanorte.setCve_usu_cr_banorte(rs.getString("cve_usu_cr_banorte"));
					listaBanorte.setDepositos_banorte(Cls_MetodosGlobales.aplicarFormatoImporte(rs.getBigDecimal("depositos_banorte")));
					listaBanorte.setDescripcion_banorte(rs.getString("descripcion_banorte"));
					listaBanorte.setDescripcion_detallada_banorte(rs.getString("descripcion_detallada_banorte"));
					listaBanorte.setEstatus_banorte(rs.getString("estatus_banorte"));
					listaBanorte.setFecha_banorte(rs.getString("fecha_banorte"));
					listaBanorte.setFecha_operacion_banorte(rs.getString("fecha_operacion_banorte"));
					listaBanorte.setFecha_pro_banorte(rs.getString("fecha_pro_banorte"));
					listaBanorte.setId_linea_bancaria_banorte(rs.getInt("id_linea_bancaria_banorte"));
					listaBanorte.setId_estatus_banorte(rs.getInt("id_estatus_banorte"));
					listaBanorte.setMovimiento_banorte(rs.getString("movimiento_banorte"));
					listaBanorte.setNumero_cuenta_banorte(rs.getString("numero_cuenta_banorte"));
					listaBanorte.setReferencia_banorte(rs.getString("referencia_banorte"));
					listaBanorte.setRetiros_banorte(Cls_MetodosGlobales.aplicarFormatoImporte(rs.getBigDecimal("retiros_banorte")));
					listaBanorte.setSaldo_banorte(Cls_MetodosGlobales.aplicarFormatoImporte(rs.getBigDecimal("saldo_banorte")));
					listaBanorte.setSucursal_banorte(rs.getString("sucursal_banorte"));
					listaBanorte.setUname_banorte(rs.getString("uname_banorte"));
					listaBanorte.setNombre_usu_banorte(rs.getString("nombre_usu_cr_banorte"));
					listaBanorte.setNombre_tipo_banorte(rs.getString("nombre_tipo_linea_banorte"));
					listaBanorte.setId_tipo_linea_banorte(rs.getInt("id_tipo_linea_banorte"));
					listaBanorte.setNum_cliente_banorte(rs.getString("num_cte_banorte"));
					listaBanorte.setNombre_cliente_banorte(rs.getString("nombre_cte_banorte"));
					listaBanorte.setNum_agente_banorte(rs.getString("num_agente_banorte"));
					listaBanorte.setNombre_agente_banorte(rs.getString("nombre_agente_banorte"));
					lista_lineas_Banorte.add(listaBanorte);
				}
			}
		}
		catch(Exception ex)
		{
			String sError= ex.getMessage().toString();
			System.out.println("Error al llenar clase Banorte:" +sError);
			Cls_Log.insertaLog(infoUsu, "", "", "Error al cargar clase linea Banorte  [" + ex.getMessage().toString()+ "]");
		}		
		return lista_lineas_Banorte;
	}
	
	
	/**** CONSULTA CONCENTRADO Y DETALLE DE LINEAS BANCARIAS ****/	
	public List<Linea_Bancaria_Concentrado> consultaConcentradoDeLineasBancarias(Usuario infoUsu, List<Querys> ListaQuerys, String IdEstatus, String fechaIni, String fechaFin)
	{
		List<Linea_Bancaria_Concentrado> listaConcentrado_linea= new ArrayList<>();
		Connection connBD = null;
		PreparedStatement pstm= null;		
		connBD = ConexionBD.AbrirConexionBD(infoUsu.getUname());
		try
		{
			String[] querys = new String[25];	
			querys = Cls_Querys.LimpiaListaQuerys(querys);	
			querys = Cls_Querys.ObtieneQuerys(40, ListaQuerys, querys, infoUsu);
			querys = inicializaQueryNumero40(querys, infoUsu, IdEstatus, fechaIni,  fechaFin);
			pstm = connBD.prepareStatement("{call " + "CTRL_INGRESOS.usp_EXECUTE_QUERY(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			ResultSet rs=  EjecutaQuerysBD.EjecutarQuery(querys[0], querys[1],querys[2], querys[3], querys[4], querys[5], querys[6],
														 querys[7], querys[8], querys[9],querys[10], querys[11], querys[12], querys[13], 
														 querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], 
														 querys[21], querys[22], querys[23], querys[24], infoUsu.getUname(),pstm, connBD);
			
			if (rs != null)
			{
				while(rs.next())
				{
					Linea_Bancaria_Concentrado concentrado_linea= new Linea_Bancaria_Concentrado();
					concentrado_linea.setCve_usu_cr(rs.getString("cve_usu_cr"));
					concentrado_linea.setImp_azteca(Cls_MetodosGlobales.aplicarFormatoImporte(rs.getBigDecimal("azteca")));
					concentrado_linea.setImp_banamex(Cls_MetodosGlobales.aplicarFormatoImporte(rs.getBigDecimal("banamex")));
					concentrado_linea.setImp_banorte(Cls_MetodosGlobales.aplicarFormatoImporte(rs.getBigDecimal("banorte")));
					concentrado_linea.setImp_bbva(Cls_MetodosGlobales.aplicarFormatoImporte(rs.getBigDecimal("bbva")));
					concentrado_linea.setImp_hsbc(Cls_MetodosGlobales.aplicarFormatoImporte(rs.getBigDecimal("hsbc")));
					concentrado_linea.setNombre_cve_usu(rs.getString("nombre_cve_usu"));
					double total= rs.getDouble("azteca") + rs.getDouble("banamex")+rs.getDouble("banorte")+rs.getDouble("bbva")+rs.getDouble("hsbc");
					concentrado_linea.setImp_total(Cls_MetodosGlobales.aplicarFormatoImporte(new BigDecimal(String.valueOf(total))));
					concentrado_linea.setId_estatus(rs.getString("id_estatus"));
					concentrado_linea.setNombre_estatus(rs.getString("estatus"));
					listaConcentrado_linea.add(concentrado_linea);
				}
			}
			Cls_Log.insertaLog(infoUsu, "", "", "Consulta Concentrado de Lineas Bancarias.");
		}
		catch(Exception ex)
		{
			String sError= ex.getMessage().toString();
			Cls_Log.insertaLog(infoUsu, "", "", "Error al Consulta Concentrado de Lineas Bancarias.");
		}
		finally
		{
			try {pstm.close();} catch (SQLException e) {e.printStackTrace();}
			try {connBD.close();} catch (SQLException e) {e.printStackTrace();}
		}
		return listaConcentrado_linea;
	}
		
	public List<Linea_Bancaria_Detalle_Concentrado> consultaDetalleConcentradoDeLineasBancarias(Usuario infoUsu, List<Querys> ListaQuerys, String IdEstatus)
	{
		List<Linea_Bancaria_Detalle_Concentrado> listaConcentrado_linea= new ArrayList<>();
		Connection connBD = null;
		PreparedStatement pstm= null;		
		connBD = ConexionBD.AbrirConexionBD(infoUsu.getUname());
		try
		{
			String[] querys = new String[25];	
			querys = Cls_Querys.LimpiaListaQuerys(querys);	
			querys = Cls_Querys.ObtieneQuerys(39, ListaQuerys, querys, infoUsu);
			querys = inicializaQueryNumero39(querys, infoUsu, IdEstatus );
			pstm = connBD.prepareStatement("{call " + "CTRL_INGRESOS.usp_EXECUTE_QUERY(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			ResultSet rs=  EjecutaQuerysBD.EjecutarQuery(querys[0], querys[1],querys[2], querys[3], querys[4], querys[5], querys[6],
														 querys[7], querys[8], querys[9],querys[10], querys[11], querys[12], querys[13], 
														 querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], 
														 querys[21], querys[22], querys[23], querys[24], infoUsu.getUname(),pstm, connBD);
		
			if (rs != null)
			{
				while(rs.next())
				{
					Linea_Bancaria_Detalle_Concentrado concentrado_linea= new Linea_Bancaria_Detalle_Concentrado();
					concentrado_linea.setConcepto(rs.getString("concepto"));
					concentrado_linea.setCve_banco(rs.getInt("cve_banco"));
					concentrado_linea.setCve_usu_cr(rs.getString("cve_usu_cr"));
					concentrado_linea.setFecha(rs.getString("fecha"));
					concentrado_linea.setImporte(Cls_MetodosGlobales.aplicarFormatoImporte(rs.getBigDecimal("importe")));
					concentrado_linea.setReferencia1(rs.getString("referencia1"));
					concentrado_linea.setReferencia2(rs.getString("referencia2"));
					concentrado_linea.setSucursal(rs.getString("sucursal"));
					concentrado_linea.setUname(rs.getString("uname"));
					concentrado_linea.setNombre_banco(rs.getString("nombre_banco"));
					listaConcentrado_linea.add(concentrado_linea);
				}
			}
		}
		catch(Exception ex)
		{
			String sError= ex.getMessage().toString();
			Cls_Log.insertaLog(infoUsu, "", "", "Error al llenar concentrado de lineas. Detalle[" + sError +"].");
		}
		finally
		{
			try {pstm.close();} catch (SQLException e) {e.printStackTrace();}
			try {connBD.close();} catch (SQLException e) {e.printStackTrace();}
		}
		return listaConcentrado_linea;
	}
			
	public List<Linea_Bancaria_Detalle_Concentrado> consultaDetalleConcentradoDeLineasBancariasXCveUsu(Usuario infoUsu, List<Querys> ListaQuerys, String CveUsuCr, List<Linea_Bancaria_Detalle_Concentrado> listaDetalleConcentradoAllUsers )
	{
		List<Linea_Bancaria_Detalle_Concentrado> listaDetalleConcentradoOneUser=new ArrayList<>();
		
		
		for(int i=0; i <listaDetalleConcentradoAllUsers.size(); i++)
		{
			if(listaDetalleConcentradoAllUsers.get(i).getCve_usu_cr().equals(CveUsuCr))
			{
				Linea_Bancaria_Detalle_Concentrado detalle= listaDetalleConcentradoAllUsers.get(i);
				listaDetalleConcentradoOneUser.add(detalle);
			}
		}
		return listaDetalleConcentradoOneUser;
	}
	
	
	/**** CONSULTA LINEAS BANCARIAS X ID BANCO  ****/	
	public List<Linea_Bancaria_Banamex> consultaLineaBancariaBanamex(Usuario infoUsu, List<Querys> ListaQuerys, String idEstatus,String fechaIni, String fechaFin)
	{
		List<Linea_Bancaria_Banamex> listalineaBanamex= new ArrayList<>();
		Connection connBD = null;
		PreparedStatement pstm= null;		
		connBD = ConexionBD.AbrirConexionBD(infoUsu.getUname());
		try
		{
			String[] querys = new String[25];	
			querys = Cls_Querys.LimpiaListaQuerys(querys);	
			querys = Cls_Querys.ObtieneQuerys(41, ListaQuerys, querys, infoUsu);
			querys = inicializaQueryNumero_41_42_43_44_45(querys, infoUsu, idEstatus,fechaIni, fechaFin,10);
			pstm = connBD.prepareStatement("{call " + "CTRL_INGRESOS.usp_EXECUTE_QUERY(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			ResultSet rs=  EjecutaQuerysBD.EjecutarQuery(querys[0], querys[1],querys[2], querys[3], querys[4], querys[5], querys[6],
														 querys[7], querys[8], querys[9],querys[10], querys[11], querys[12], querys[13], 
														 querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], 
														 querys[21], querys[22], querys[23], querys[24], infoUsu.getUname(),pstm, connBD);
			if (rs != null)
			{
				while(rs.next())
				{
					listalineaBanamex= llenaClaseLineaBanamex(rs, infoUsu);
				}
			}
			Cls_Log.insertaLog(infoUsu, "", "", "Consulta Linea Bancaria Banamex [ Estatus: " + idEstatus + ", Fecha Inicio: " + fechaIni + ", Fecha Fin: " +  fechaFin +"]");
		}
		catch(Exception ex)
		{
			String sError= ex.getMessage().toString();
			Cls_Log.insertaLog(infoUsu, "", "", "Error al llenar consultar Linea Bancaria Banamex. Detalle[" + sError +"].");
		}
		finally
		{
			try {pstm.close();} catch (SQLException e) {e.printStackTrace();}
			try {connBD.close();} catch (SQLException e) {e.printStackTrace();}
		}
		return listalineaBanamex;
	}
	
	public List<Linea_Bancaria_HSBC> consultaLineaBancariaHSBC(Usuario infoUsu, List<Querys> ListaQuerys, String idEstatus,String fechaIni, String fechaFin)
	{
		List<Linea_Bancaria_HSBC> listalineaHSBC= new ArrayList<>();
		Connection connBD = null;
		PreparedStatement pstm= null;		
		connBD = ConexionBD.AbrirConexionBD(infoUsu.getUname());
		try
		{
			String[] querys = new String[25];	
			querys = Cls_Querys.LimpiaListaQuerys(querys);	
			querys = Cls_Querys.ObtieneQuerys(42, ListaQuerys, querys, infoUsu);
			querys = inicializaQueryNumero_41_42_43_44_45(querys, infoUsu, idEstatus,fechaIni, fechaFin,16);
			pstm = connBD.prepareStatement("{call " + "CTRL_INGRESOS.usp_EXECUTE_QUERY(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			ResultSet rs=  EjecutaQuerysBD.EjecutarQuery(querys[0], querys[1],querys[2], querys[3], querys[4], querys[5], querys[6],
														 querys[7], querys[8], querys[9],querys[10], querys[11], querys[12], querys[13], 
														 querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], 
														 querys[21], querys[22], querys[23], querys[24], infoUsu.getUname(),pstm, connBD);
			if (rs != null)
			{
				while(rs.next())
				{
					listalineaHSBC= llenaClaseLineaHSBC(rs,infoUsu);
				}
			}
			Cls_Log.insertaLog(infoUsu, "", "", "Consulta Linea Bancaria HSBC [ Estatus: " + idEstatus + ", Fecha Inicio: " + fechaIni + ", Fecha Fin: " +  fechaFin +"]");
		}
		catch(Exception ex)
		{
			String sError= ex.getMessage().toString();
			Cls_Log.insertaLog(infoUsu, "", "", "Error al llenar consultar Linea Bancaria HSBC. Detalle[" + sError +"].");
		}
		finally
		{
			try {pstm.close();} catch (SQLException e) {e.printStackTrace();}
			try {connBD.close();} catch (SQLException e) {e.printStackTrace();}
		}
		return listalineaHSBC;
	}
	
	public List<Linea_Bancaria_BBVA> consultaLineaBancariaBBVA(Usuario infoUsu, List<Querys> ListaQuerys, String idEstatus,String fechaIni, String fechaFin)
	{
		List<Linea_Bancaria_BBVA> listalineaBBVA= new ArrayList<>();
		Connection connBD = null;
		PreparedStatement pstm= null;		
		connBD = ConexionBD.AbrirConexionBD(infoUsu.getUname());
		try
		{
			String[] querys = new String[25];	
			querys = Cls_Querys.LimpiaListaQuerys(querys);	
			querys = Cls_Querys.ObtieneQuerys(43, ListaQuerys, querys, infoUsu);
			querys = inicializaQueryNumero_41_42_43_44_45(querys, infoUsu, idEstatus,fechaIni, fechaFin,4);
			pstm = connBD.prepareStatement("{call " + "CTRL_INGRESOS.usp_EXECUTE_QUERY(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			ResultSet rs=  EjecutaQuerysBD.EjecutarQuery(querys[0], querys[1],querys[2], querys[3], querys[4], querys[5], querys[6],
														 querys[7], querys[8], querys[9],querys[10], querys[11], querys[12], querys[13], 
														 querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], 
														 querys[21], querys[22], querys[23], querys[24], infoUsu.getUname(),pstm, connBD);
			if (rs != null)
			{
				while(rs.next())
				{
					listalineaBBVA= llenaClaseLineaBBVA(rs, infoUsu);
				}
			}
			Cls_Log.insertaLog(infoUsu, "", "", "Consulta Linea Bancaria BBVA [ Estatus: " + idEstatus + ", Fecha Inicio: " + fechaIni + ", Fecha Fin: " +  fechaFin +"]");
		}
		catch(Exception ex)
		{
			String sError= ex.getMessage().toString();
			Cls_Log.insertaLog(infoUsu, "", "", "Error al llenar consultar Linea Bancaria BBVA. Detalle[" + sError +"].");
		}
		finally
		{
			try {pstm.close();} catch (SQLException e) {e.printStackTrace();}
			try {connBD.close();} catch (SQLException e) {e.printStackTrace();}
		}
		return listalineaBBVA;
	}
	
	public List<Linea_Bancaria_Banorte> consultaLineaBancariaBanorte(Usuario infoUsu, List<Querys> ListaQuerys, String idEstatus,String fechaIni, String fechaFin)
	{
		List<Linea_Bancaria_Banorte> listalineaBanorte= new ArrayList<>();
		Connection connBD = null;
		PreparedStatement pstm= null;		
		connBD = ConexionBD.AbrirConexionBD(infoUsu.getUname());
		try
		{
			String[] querys = new String[25];	
			querys = Cls_Querys.LimpiaListaQuerys(querys);	
			querys = Cls_Querys.ObtieneQuerys(44, ListaQuerys, querys, infoUsu);
			querys = inicializaQueryNumero_41_42_43_44_45(querys, infoUsu, idEstatus,fechaIni, fechaFin,12);
			pstm = connBD.prepareStatement("{call " + "CTRL_INGRESOS.usp_EXECUTE_QUERY(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			ResultSet rs=  EjecutaQuerysBD.EjecutarQuery(querys[0], querys[1],querys[2], querys[3], querys[4], querys[5], querys[6],
														 querys[7], querys[8], querys[9],querys[10], querys[11], querys[12], querys[13], 
														 querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], 
														 querys[21], querys[22], querys[23], querys[24], infoUsu.getUname(),pstm, connBD);
			if (rs != null)
			{
				while(rs.next())
				{
					listalineaBanorte= llenaClaseLineaBanorte(rs, infoUsu);
				}
			}
			Cls_Log.insertaLog(infoUsu, "", "", "Consulta Linea Bancaria Banorte [ Estatus: " + idEstatus + ", Fecha Inicio: " + fechaIni + ", Fecha Fin: " +  fechaFin +"]");
		}
		catch(Exception ex)
		{
			String sError= ex.getMessage().toString();
			Cls_Log.insertaLog(infoUsu, "", "", "Error al llenar consultar Linea Bancaria Banorte. Detalle[" + sError +"].");
		}
		finally
		{
			try {pstm.close();} catch (SQLException e) {e.printStackTrace();}
			try {connBD.close();} catch (SQLException e) {e.printStackTrace();}
		}
		return listalineaBanorte;
	}
	
	public List<Linea_Bancaria_Azteca> consultaLineaBancariaAzteca(Usuario infoUsu, List<Querys> ListaQuerys, String idEstatus,String fechaIni, String fechaFin)
	{
		List<Linea_Bancaria_Azteca> listalineaAzteca= new ArrayList<>();
		Connection connBD = null;
		PreparedStatement pstm= null;		
		connBD = ConexionBD.AbrirConexionBD(infoUsu.getUname());
		try
		{
			String[] querys = new String[25];	
			querys = Cls_Querys.LimpiaListaQuerys(querys);	
			querys = Cls_Querys.ObtieneQuerys(45, ListaQuerys, querys, infoUsu);
			querys = inicializaQueryNumero_41_42_43_44_45(querys, infoUsu, idEstatus,fechaIni, fechaFin,5);
			pstm = connBD.prepareStatement("{call " + "CTRL_INGRESOS.usp_EXECUTE_QUERY(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			ResultSet rs=  EjecutaQuerysBD.EjecutarQuery(querys[0], querys[1],querys[2], querys[3], querys[4], querys[5], querys[6],
														 querys[7], querys[8], querys[9],querys[10], querys[11], querys[12], querys[13], 
														 querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], 
														 querys[21], querys[22], querys[23], querys[24], infoUsu.getUname(),pstm, connBD);	
			if (rs != null)
			{
				while(rs.next())
				{
					listalineaAzteca= llenaClaseLineaAzteca(rs, infoUsu);
				}
			}
			Cls_Log.insertaLog(infoUsu, "", "", "Consulta Linea Bancaria Azteca [ Estatus: " + idEstatus + ", Fecha Inicio: " + fechaIni + ", Fecha Fin: " +  fechaFin +"]");
		}
		catch(Exception ex)
		{
			String sError= ex.getMessage().toString();
			Cls_Log.insertaLog(infoUsu, "", "", "Error al llenar consultar Linea Bancaria Azteca. Detalle[" + sError +"].");
		}
		finally
		{
			try {pstm.close();} catch (SQLException e) {e.printStackTrace();}
			try {connBD.close();} catch (SQLException e) {e.printStackTrace();}
		}
		return listalineaAzteca;
	}
	
	
	/**** ACTUALIZA CLIENTE DE  BANCARIAS X ID BANCO  ****/	
	public boolean actualizaCteDeLineaBancariaXBanco(Usuario infoUsu, List<Querys> ListaQuerys, String banco, String num_cliente, String idLineaBancaria)
	{
		Connection connBD = null;
		PreparedStatement pstm= null;		
		connBD = ConexionBD.AbrirConexionBD(infoUsu.getUname());
		boolean axtualizaCteBD=false;
		try
		{
			String[] querys = new String[25];	
			querys = Cls_Querys.LimpiaListaQuerys(querys);	
			querys = Cls_Querys.ObtieneQuerys(46, ListaQuerys, querys, infoUsu);
			querys = inicializaQueryNumero_46(querys, infoUsu, banco, num_cliente, idLineaBancaria);
			pstm = connBD.prepareStatement("{call " + "CTRL_INGRESOS.usp_EXECUTE_QUERY(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			ResultSet rs=  EjecutaQuerysBD.EjecutarQuery(querys[0], querys[1],querys[2], querys[3], querys[4], querys[5], querys[6],
														 querys[7], querys[8], querys[9],querys[10], querys[11], querys[12], querys[13], 
														 querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], 
														 querys[21], querys[22], querys[23], querys[24], infoUsu.getUname(),pstm, connBD);
			Cls_Log.insertaLog(infoUsu, "", "", "Actualiza cliente de linea bancaria [ Banco: " + banco + ", Num.Cliente: " + num_cliente + ", Id Linea Bancaria: " +  idLineaBancaria +"]");
			axtualizaCteBD=true;
		}
		catch(Exception ex)
		{
			String sError= ex.getMessage().toString();
			Cls_Log.insertaLog(infoUsu, "", "", "Error al actualizar cliente de  Linea Bancaria Banamex. Detalle[" + sError +"].");
		}
		finally
		{
			try {pstm.close();} catch (SQLException e) {e.printStackTrace();}
			try {connBD.close();} catch (SQLException e) {e.printStackTrace();}
		}
		return axtualizaCteBD;
	}
	
	public boolean actualizaCteMasivoXBanco(Usuario infoUsu, List<Querys> ListaQuerys, String cve_banco, String num_cliente, String lineaBancaria)
	{
		Connection connBD = null;
		PreparedStatement pstm= null;		
		connBD = ConexionBD.AbrirConexionBD(infoUsu.getUname());
		boolean axtualizaCteBD=false;
		try
		{
			String ids_lineas_bancarias_actualizar= obtieneIdsLineasActualizar(cve_banco, lineaBancaria);
			String[] querys = new String[25];	
			querys = Cls_Querys.LimpiaListaQuerys(querys);	
			querys = Cls_Querys.ObtieneQuerys(46, ListaQuerys, querys, infoUsu);
			querys = inicializaQueryNumero_46(querys, infoUsu, cve_banco, num_cliente, ids_lineas_bancarias_actualizar);
			
			pstm = connBD.prepareStatement("{call " + "CTRL_INGRESOS.usp_EXECUTE_QUERY(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			ResultSet rs=  EjecutaQuerysBD.EjecutarQuery(querys[0], querys[1],querys[2], querys[3], querys[4], querys[5], querys[6],
														 querys[7], querys[8], querys[9],querys[10], querys[11], querys[12], querys[13], 
														 querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], 
														 querys[21], querys[22], querys[23], querys[24], infoUsu.getUname(),pstm, connBD);
			Cls_Log.insertaLog(infoUsu, "", "", "Actualiza cliente masivo  de linea bancaria [ Ids Lineas Bancarias: (" +  ids_lineas_bancarias_actualizar + "), Banco: " + cve_banco + ", Num.Cliente: " + num_cliente + "]");
			axtualizaCteBD=true;
		}
		catch(Exception ex)
		{
			String sError= ex.getMessage().toString();
			Cls_Log.insertaLog(infoUsu, "", "", "Error al actualizar cliente de  Linea Bancaria Banamex. Detalle[" + sError +"].");
		}
		finally
		{
			try {pstm.close();} catch (SQLException e) {e.printStackTrace();}
			try {connBD.close();} catch (SQLException e) {e.printStackTrace();}
		}
		return axtualizaCteBD;
	}
	
	
	/**** ACTUALIZA AGENTE DE BANCARIAS X ID BANCO  ****/	
	public String actualizaAgteMasivoXBanco(Usuario infoUsu, List<Querys> ListaQuerys, String cve_banco, String num_agente, String lineaBancaria, String tipoLinea)
	{
		Connection connBD = null;
		PreparedStatement pstm= null;		
		connBD = ConexionBD.AbrirConexionBD(infoUsu.getUname());
		String axtualizaAgteBD = "ErrorAlActualizar";
		String encargadoCredito = "";
		try
		{
			String ids_lineas_bancarias_actualizar= obtieneIdsLineasActualizar(cve_banco, lineaBancaria);
			String[] querys = new String[25];	
			querys = Cls_Querys.LimpiaListaQuerys(querys);	
			querys = Cls_Querys.ObtieneQuerys(62, ListaQuerys, querys, infoUsu);
			querys = inicializaQueryNumero_62(querys, infoUsu, cve_banco, num_agente, ids_lineas_bancarias_actualizar, tipoLinea);
			pstm = connBD.prepareStatement("{call " + "CTRL_INGRESOS.usp_EXECUTE_QUERY(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			ResultSet rs=  EjecutaQuerysBD.EjecutarQuery(querys[0], querys[1],querys[2], querys[3], querys[4], querys[5], querys[6],
														 querys[7], querys[8], querys[9],querys[10], querys[11], querys[12], querys[13], 
														 querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], 
														 querys[21], querys[22], querys[23], querys[24], infoUsu.getUname(),pstm, connBD);
			if(rs != null)
			{
				while(rs.next())
				{
					encargadoCredito = rs.getString("usu_credito");
				}
			}
			if(encargadoCredito.equals(""))
			{
				axtualizaAgteBD = "SinEncargadoCredito";
				Cls_Log.insertaLog(infoUsu, "", "", "Actualiza AV Sin ECC en linea bancaria. [ Ids Lineas Bancarias: ( " +  ids_lineas_bancarias_actualizar + " ), Banco: " + cve_banco + ", Num.Agente: " + num_agente + ", EncargadoCR: " + encargadoCredito +" ]");
			}
			else
			{
				axtualizaAgteBD = "ActualizoCorrectamente";
				Cls_Log.insertaLog(infoUsu, "", "", "Actualiza AV y ECC en linea bancaria [ Ids Lineas Bancarias: ( " +  ids_lineas_bancarias_actualizar + " ), Banco: " + cve_banco + ", Num.Agente: " + num_agente + ", EncargadoCR: " + encargadoCredito +" ]");
			}
		}
		catch(Exception ex)
		{
			String sError= ex.getMessage().toString();
			Cls_Log.insertaLog(infoUsu, "", "", "Error al actualizar AV y ECC en Linea Bancaria. Detalle[" + sError +"].");
		}
		finally
		{
			try {pstm.close();} catch (SQLException e) {e.printStackTrace();}
			try {connBD.close();} catch (SQLException e) {e.printStackTrace();}
		}
		return axtualizaAgteBD;
	}
	
	
	/**** MODIFICA ENCARGADO A  BANCARIAS X ID BANCO  ****/	
	public String modificaEncargadoLineaBancaria(Usuario infoUsu, List<Querys> ListaQuerys,String cve_banco,String encargadoCR, String lineaBancaria )
	{
		Connection connBD = null;
		PreparedStatement pstm= null;		
		connBD = ConexionBD.AbrirConexionBD(infoUsu.getUname());
		String axtualizaEncBD="ErrorAlActualizar";
		try
		{
			String ids_lineas_bancarias_actualizar= obtieneIdsLineasActualizar(cve_banco, lineaBancaria);
		    String[] querys = new String[25];	
			querys = Cls_Querys.LimpiaListaQuerys(querys);	
			querys = Cls_Querys.ObtieneQuerys(47, ListaQuerys, querys, infoUsu);
			querys = inicializaQueryNumero_47(querys, infoUsu,cve_banco, encargadoCR, ids_lineas_bancarias_actualizar);
			pstm = connBD.prepareStatement("{call " + "CTRL_INGRESOS.usp_EXECUTE_QUERY(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			EjecutaQuerysBD.EjecutarQuery(querys[0], querys[1],querys[2], querys[3], querys[4], querys[5], querys[6],
														 querys[7], querys[8], querys[9],querys[10], querys[11], querys[12], querys[13], 
														 querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], 
														 querys[21], querys[22], querys[23], querys[24], infoUsu.getUname(),pstm, connBD);			
			Cls_Log.insertaLog(infoUsu, "", "", "Modifica ECC en linea bancaria. [ Ids Lineas Bancarias: ( " +  ids_lineas_bancarias_actualizar + " ) , Banco: " + cve_banco + ", EnracgardoCr: " + encargadoCR + "]");
			axtualizaEncBD="ActualizoCorrectamente";
		}
		catch(Exception ex)
		{
			String sError= ex.getMessage().toString();
			Cls_Log.insertaLog(infoUsu, "", "", "Error al modificar ECC en de credito manualmente de  Linea Bancaria. Detalle[" + sError +"].");
		}
		finally
		{
			try {pstm.close();} catch (SQLException e) {e.printStackTrace();}
			try {connBD.close();} catch (SQLException e) {e.printStackTrace();}
		}
		return axtualizaEncBD;
	}
	
	
	/**** ASIGNA ENCARGADO A  BANCARIAS X ID BANCO  ****/	
	public boolean asignaDeEncargadosEnLneaBancaria(Usuario infoUsu, List<Querys> ListaQuerys)
	{
		Connection connBD = null;
		PreparedStatement pstm= null;		
		connBD = ConexionBD.AbrirConexionBD(infoUsu.getUname());
		boolean actualizaEstatusBD=false;
		try
		{
			
		    String[] querys = new String[25];	
			querys = Cls_Querys.LimpiaListaQuerys(querys);	
			querys = Cls_Querys.ObtieneQuerys(48, ListaQuerys, querys, infoUsu);
			querys = inicializaQueryNumero_48(querys, infoUsu);
			pstm = connBD.prepareStatement("{call " + "CTRL_INGRESOS.usp_EXECUTE_QUERY(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			EjecutaQuerysBD.EjecutarQuery(querys[0], querys[1],querys[2], querys[3], querys[4], querys[5], querys[6],
														 querys[7], querys[8], querys[9],querys[10], querys[11], querys[12], querys[13], 
														 querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], 
														 querys[21], querys[22], querys[23], querys[24], infoUsu.getUname(),pstm, connBD);
		
			Cls_Log.insertaLog(infoUsu, "", "", "Asigna encargado de credito en linea bancaria.");
			actualizaEstatusBD=true;
		}
		catch(Exception ex)
		{
			String sError= ex.getMessage().toString();
			Cls_Log.insertaLog(infoUsu, "", "", "Error al asignar encargado de credito en Linea Bancaria. Detalle[" + sError +"].");
		}
		finally
		{
			try {pstm.close();} catch (SQLException e) {e.printStackTrace();}
			try {connBD.close();} catch (SQLException e) {e.printStackTrace();}
		}
		return actualizaEstatusBD;
	}
	
	
	/**** APLICA/REGRESA PAGO EN LINEA BANCARIA  ****/	
	public String aplicaRegresarPagoEnLineaBancaria(Usuario infoUsu, List<Querys> ListaQuerys, String accion, String cve_banco, String lineaBancaria, String area,String tipoLinea, String folioPago)
	{
		Connection connBD = null;
		PreparedStatement pstm= null;		
		connBD = ConexionBD.AbrirConexionBD(infoUsu.getUname());
		String actualizaEstatusBD="ErrorAlActualizar";
		try
		{
			String ids_lineas_bancarias_actualizar= obtieneIdsLineasActualizar(cve_banco, lineaBancaria);
		    String[] querys = new String[25];	
			querys = Cls_Querys.LimpiaListaQuerys(querys);	
			querys = Cls_Querys.ObtieneQuerys(50, ListaQuerys, querys, infoUsu);
			querys = inicializaQueryNumero_50(querys, infoUsu,accion, cve_banco, ids_lineas_bancarias_actualizar, area, tipoLinea, folioPago);
			pstm = connBD.prepareStatement("{call " + "CTRL_INGRESOS.usp_EXECUTE_QUERY(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			EjecutaQuerysBD.EjecutarQuery(querys[0], querys[1],querys[2], querys[3], querys[4], querys[5], querys[6],
														 querys[7], querys[8], querys[9],querys[10], querys[11], querys[12], querys[13], 
														 querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], 
														 querys[21], querys[22], querys[23], querys[24], infoUsu.getUname(),pstm, connBD);		
		
			if(area.equals("CajaAdministrativa"))
			{
				Cls_Log.insertaLog(infoUsu, "", "", accion +" de linea bancaria en area de Caja Administrativa [Cve.Banco: " + cve_banco +",  Ids: (" + ids_lineas_bancarias_actualizar + ") ]");
			}
			else
			{
				Cls_Log.insertaLog(infoUsu, "", "", accion +" de linea bancaria en area de Credito y Cobranza [Cve.Banco: " + cve_banco +",  Ids: (" + ids_lineas_bancarias_actualizar + ") ]");
			}
			actualizaEstatusBD="ActualizoCorrectamente";
		}
		catch(Exception ex)
		{
			String sError= ex.getMessage().toString();
			Cls_Log.insertaLog(infoUsu, "", "", "Error al  " + accion + " de Linea Bancaria. Detalle[" + sError +"].");
		}
		finally
		{
			try {pstm.close();} catch (SQLException e) {e.printStackTrace();}
			try {connBD.close();} catch (SQLException e) {e.printStackTrace();}
		}
		return actualizaEstatusBD;
	}
	
	public boolean validaSiLaLineaBancariaTieneCliente(String cve_banco,String lineaBancaria)
	{
		boolean clienteValido = true;
		String columnaCliente = obtieneNombreColumnaClientePorBanco(cve_banco);
		String columnaECC = obtieneNombreColumnaECCPorBanco(cve_banco);
		JSONArray jsonLineaBancaria = new JSONArray(lineaBancaria);
	    for (int i = 0; i < jsonLineaBancaria.length(); i++)
	    {
	        JSONObject rs = jsonLineaBancaria.getJSONObject(i);
	        if(rs.getBoolean("checked"))
	        {
	        	if(Integer.parseInt(rs.getString(columnaCliente)) <= 0 || rs.getString(columnaECC) == "" )
	        	{
	        		clienteValido = false;
	        		break;
	        	}
	        } 
	    }
	    return clienteValido;
	}
		
	public boolean validaSiExistenLineasSeleccionadas(String cve_banco,String lineaBancaria)
	{
		boolean lineaSelecCorrectamente = false;
		JSONArray jsonLineaBancaria = new JSONArray(lineaBancaria);
	    for (int i = 0; i < jsonLineaBancaria.length(); i++)
	    {
	        JSONObject rs = jsonLineaBancaria.getJSONObject(i);
	        if(rs.getBoolean("checked"))
	        {
	        	lineaSelecCorrectamente = true;
	        	break;
	        } 
	    }
	    return lineaSelecCorrectamente;
	}
		
	private String obtieneIdsLineasActualizar(String cve_banco, String lineaBancaria)
	{
		String nombreColumnaBanco= obtieneNombreColumnaPorBanco(cve_banco);
		String ids_lineas_bancarias_actualizar="";
		
		JSONArray jsonLineaBancaria = new JSONArray(lineaBancaria);
	    for (int i = 0; i < jsonLineaBancaria.length(); i++)
	    {
	        JSONObject rs = jsonLineaBancaria.getJSONObject(i);
	        if(rs.getBoolean("checked"))
	        {
	        	ids_lineas_bancarias_actualizar += String.valueOf(rs.getInt(nombreColumnaBanco)) + ",";
	        }
	    }
	    
	    ids_lineas_bancarias_actualizar = ids_lineas_bancarias_actualizar.substring(0,ids_lineas_bancarias_actualizar.length()-1);
	    
	    return ids_lineas_bancarias_actualizar;
	}
	
	/**** INICIALIZA LOS QUERYS DE LINEAS BANCARIAS ****/
	private String[] inicializaQueryNumero38(String[] ListaQuerys, Usuario infoUsu, String IdEstatus) 
	{	
		SimpleDateFormat formatter = new SimpleDateFormat("ddMMyyyy");
		Date fechaHoraSistema = Calendar.getInstance().getTime();
		String fechaSistema = formatter.format(fechaHoraSistema);
		for (int i=0;i <ListaQuerys.length; i++)
		{
			ListaQuerys[i]= ListaQuerys[i].replace("{ID_ESTATUS}", IdEstatus);
			ListaQuerys[i]= ListaQuerys[i].replace("{FECHA_INICIO}", String.valueOf(fechaSistema.substring(4, 8)) + "-" + String.valueOf(fechaSistema.substring(2, 4)) + "-"+ String.valueOf(fechaSistema.substring(0, 2)));
			ListaQuerys[i]= ListaQuerys[i].replace("{FECHA_FIN}", String.valueOf(fechaSistema.substring(4, 8)) + "-" + String.valueOf(fechaSistema.substring(2, 4)) + "-"+ String.valueOf(fechaSistema.substring(0, 2)));
		}
		return ListaQuerys;
	}
	
	private String[] inicializaQueryNumero39(String[] ListaQuerys, Usuario infoUsu, String IdEstatus) 
	{
		for (int i=0;i <ListaQuerys.length; i++)
		{
			ListaQuerys[i]= ListaQuerys[i].replace(" {ID_ESTATUS}", IdEstatus);
		}
		return ListaQuerys;
	}
		
	private String[] inicializaQueryNumero40(String[] ListaQuerys, Usuario infoUsu, String IdEstatus, String fechaIni, String fecha_fin) 
	{
		String  sentenciaFechas="";	
		String FIni= String.valueOf(fechaIni.substring(6, 10)) + "-" + String.valueOf(fechaIni.substring(3, 5)) + "-"+ String.valueOf(fechaIni.substring(0, 2));
		String FFin= String.valueOf(fecha_fin.substring(6, 10)) + "-" + String.valueOf(fecha_fin.substring(3, 5)) + "-"+ String.valueOf(fecha_fin.substring(0, 2));
		
		switch(Integer.parseInt(IdEstatus))
		{
			case 1:
				sentenciaFechas = " AND fecha_pre_asigna_usu_cr >= '" + FIni  + "' AND fecha_pre_asigna_usu_cr <='" + FFin + "'";
				break;
			case 2:
				sentenciaFechas = " AND fecha_asigna_usu_cr >= '" + FIni  + "' AND fecha_asigna_usu_cr <= '" + FFin + "'";
				break;
			case 3:
				sentenciaFechas = " AND fecha_aplica_pago_usu_cr >= '" + FIni  + "' AND fecha_aplica_pago_usu_cr <= '" + FFin + "'";
				break;
		}
		
		for (int i=0;i <ListaQuerys.length; i++)
		{
			ListaQuerys[i]= ListaQuerys[i].replace(" {ID_ESTATUS}", IdEstatus);
			ListaQuerys[i]= ListaQuerys[i].replace(" {SENTENCIA_FECHAS}", sentenciaFechas);
		}
		return ListaQuerys;
	}
	
	private String[] inicializaQueryNumero_41_42_43_44_45(String[] ListaQuerys, Usuario infoUsu, String IdEstatus, String fechaIni, String fechaFin, int cve_banco) 
	{
		String fechaI[] = fechaIni.split("/");
		String fechaF[] = fechaFin.split("/");
		
		for (int i=0;i <ListaQuerys.length; i++)
		{
			if(IdEstatus.equals("6"))
			{
				ListaQuerys[i]= ListaQuerys[i].replace("{ID_ESTATUS}", "0,1,2,3,4,5");
			}
			else
			{
				ListaQuerys[i]= ListaQuerys[i].replace("{ID_ESTATUS}", IdEstatus);
			}			
			ListaQuerys[i]= ListaQuerys[i].replace("{FECHA_INICIO}", fechaI[2] + "-" + fechaI[1] +"-"+ fechaI[0].trim());
			ListaQuerys[i]= ListaQuerys[i].replace("{FECHA_FIN}", fechaF[2] + "-" + fechaF[1] +"-" + fechaF[0].trim());
			if(IdEstatus == "0")
			{
				ListaQuerys[i]= ListaQuerys[i].replace("{SENTENCIA_VALIDA_USUARIO}", ""); 
			}
			else
			{
				if(infoUsu.getNivel_usuario() == 1 && infoUsu.getDato_numerico() == 0)
				{
					if(Integer.parseInt(IdEstatus) >= 2 &&  Integer.parseInt(IdEstatus) != 5)
					{
						ListaQuerys[i]= ListaQuerys[i].replace("{SENTENCIA_VALIDA_USUARIO}", " AND A.cve_usu_cr = '" +infoUsu.getCve_usuario() + "'");
					}
					else
					{
						ListaQuerys[i]= ListaQuerys[i].replace("{SENTENCIA_VALIDA_USUARIO}", ""); 
					}
				}
				else
				{
					ListaQuerys[i]= ListaQuerys[i].replace("{SENTENCIA_VALIDA_USUARIO}", ""); 
				}
			}
		}
		return ListaQuerys;
	}
			
	private String[] inicializaQueryNumero_46(String[] ListaQuerys, Usuario infoUsu, String banco, String num_cliente, String idLineaBancaria) 
	{		
		for (int i=0;i <ListaQuerys.length; i++)
		{
			ListaQuerys[i]= ListaQuerys[i].replace("{TABLA_BANCO}", obtieneNombreTablaPorBanco(banco));
			ListaQuerys[i]= ListaQuerys[i].replace("{CLIENTE}", num_cliente);
			ListaQuerys[i]= ListaQuerys[i].replace("{ID_LINEA_BANCARIA}", idLineaBancaria);
			ListaQuerys[i]= ListaQuerys[i].replace("{COLUMNA_BANCO}", obtieneNombreColumnaPorBanco(banco));			
		}
		return ListaQuerys;
	}
	
	private String[] inicializaQueryNumero_62(String[] ListaQuerys, Usuario infoUsu, String banco, String num_agente, String idLineaBancaria, String id_tipo_linea) 
	{		
		for (int i=0;i <ListaQuerys.length; i++)
		{
			ListaQuerys[i]= ListaQuerys[i].replace("{TABLA_BANCO}", obtieneNombreTablaPorBanco(banco));
			ListaQuerys[i]= ListaQuerys[i].replace("{AGENTE}", num_agente);
			ListaQuerys[i]= ListaQuerys[i].replace("{ID_LINEA_BANCARIA}", idLineaBancaria);
			ListaQuerys[i]= ListaQuerys[i].replace("{COLUMNA_BANCO}", obtieneNombreColumnaPorBanco(banco));	
			ListaQuerys[i]= ListaQuerys[i].replace("{TIPO_LINEA}", id_tipo_linea);	
			ListaQuerys[i]= ListaQuerys[i].replace("{USUARIO}", infoUsu.getCve_usuario());	
		}
		return ListaQuerys;
	}
	
	private String[] inicializaQueryNumero_48(String[] ListaQuerys, Usuario infoUsu) 
	{		
		for (int i=0;i <ListaQuerys.length; i++)
		{
			ListaQuerys[i]= ListaQuerys[i].replace("{USUARIO}", infoUsu.getCve_usuario());	
		}
		return ListaQuerys;
	}
		
	private String[] inicializaQueryNumero_47(String[] ListaQuerys, Usuario infoUsu, String banco, String encargadoCR, String idsLineasBancarias) 
	{		
		for (int i=0;i <ListaQuerys.length; i++)
		{
			ListaQuerys[i]= ListaQuerys[i].replace("{TABLA_BANCO}", obtieneNombreTablaPorBanco(banco));
			ListaQuerys[i]= ListaQuerys[i].replace("{COLUMNA_BANCO}", obtieneNombreColumnaPorBanco(banco));	
			ListaQuerys[i]= ListaQuerys[i].replace("{ENCARGADO_CR}", encargadoCR.trim());
			ListaQuerys[i]= ListaQuerys[i].replace("{IDS_LINEAS_BANCARIAS}", idsLineasBancarias);		
		}
		return ListaQuerys;
	}
		
	private String[] inicializaQueryNumero_50(String[] ListaQuerys, Usuario infoUsu, String accion, String banco,  String idsLineasBancarias, String area, String tipoLinea, String folioPago) 
	{		
		String tipo_linea = "";
		String id_estatus = (accion.equals("Aplicar_Pago")) ? "3" : "2";
		String id_estatusAnt = (accion.equals("Aplicar_Pago")) ? "2" : "3";
		
		String usuario_aplica_linea = (accion.equals("Aplicar_Pago")) ?infoUsu.getCve_usuario() : "";
		String fecha_aplica_linea = (accion.equals("Aplicar_Pago")) ? "CURDATE()" : "'1901-01-01'";
		String hora_aplica_linea = (accion.equals("Aplicar_Pago")) ? "CURTIME()" : "'00:00'";
		
		String usuario_quita_pago = (accion.equals("Aplicar_Pago")) ? "" : infoUsu.getCve_usuario();
		String fecha_quita_pago = (accion.equals("Aplicar_Pago")) ? "'1901-01-01'" : "CURDATE()";
		String hora_quita_pago = (accion.equals("Aplicar_Pago")) ? "'00:00'"  : "CURTIME()";
			
		String folio = (accion.equals("Aplicar_Pago")) ? folioPago : "0";
		String fecha_aplico_pago = (accion.equals("Aplicar_Pago")) ? "CURDATE()" : "'1901-01-01'";
		String cve_usu_aplico_pago = (accion.equals("Aplicar_Pago")) ? infoUsu.getCve_usuario() : "";
		String hora_aplico_pago = (accion.equals("Aplicar_Pago")) ? "CURTIME()" : "'00:00'";
				
		if(accion.equals("Aplicar_Pago") && area.equals("CajaAdministrativa"))
		{
			id_estatusAnt = "0";
			tipo_linea= ", id_tipo_linea= " + tipoLinea;
		}
		
		for (int i=0;i <ListaQuerys.length; i++)
		{
			ListaQuerys[i]= ListaQuerys[i].replace("{TABLA_BANCO}", obtieneNombreTablaPorBanco(banco));
			ListaQuerys[i]= ListaQuerys[i].replace("{COLUMNA_BANCO}", obtieneNombreColumnaPorBanco(banco));	
			ListaQuerys[i]= ListaQuerys[i].replace("{IDS_LINEAS_BANCARIAS}", idsLineasBancarias);
			ListaQuerys[i]= ListaQuerys[i].replace("{ID_ESTATUS}", id_estatus);
			ListaQuerys[i]= ListaQuerys[i].replace("{ID_ESTATUS_ANT}", id_estatusAnt);
			
			ListaQuerys[i]= ListaQuerys[i].replace("{FECHA_APLICA_LINEA}", fecha_aplica_linea);
			ListaQuerys[i]= ListaQuerys[i].replace("{HORA_APLICA_LINEA}", hora_aplica_linea);
			ListaQuerys[i]= ListaQuerys[i].replace("{USUARIO_APLICA_LINEA}", usuario_aplica_linea);	
			
			ListaQuerys[i]= ListaQuerys[i].replace("{USUARIO_QUITA_PAGO}", usuario_quita_pago);	
			ListaQuerys[i]= ListaQuerys[i].replace("{FECHA_QUITA_PAGO}", fecha_quita_pago);
			ListaQuerys[i]= ListaQuerys[i].replace("{HORA_QUITA_PAGO}", hora_quita_pago);
			
			ListaQuerys[i]= ListaQuerys[i].replace("{FOLIO_PAGO}", folio);	
			ListaQuerys[i]= ListaQuerys[i].replace("{FECHA_APLICO_PAGO}", fecha_aplico_pago);		
			ListaQuerys[i]= ListaQuerys[i].replace("{CVE_USU_APLICO_PAGO}", cve_usu_aplico_pago);
			ListaQuerys[i]= ListaQuerys[i].replace("{HORA_APLICO_PAGO}", hora_aplico_pago);
						
			ListaQuerys[i]= ListaQuerys[i].replace("{TIPO_LINEA}", tipo_linea);
		}
		
		return ListaQuerys;
	}
	
	private String  obtieneNombreColumnaPorBanco(String cve_banco)
	{
		String nombreColumna = "";
		switch(cve_banco)
		{
			case "10":/*BANAMEX*/
				nombreColumna= "id_linea_bancaria_banamex";
				break;
			
			case "16":/*HSBC*/
				nombreColumna= "id_linea_bancaria_hsbc";
				break;
				
			case "4":/*BBVA*/
				nombreColumna="id_linea_bancaria_bbva";
				break;
				
			case "12":/*BANORTE*/
				nombreColumna= "id_linea_bancaria_banorte" ;
				break;
			
			case "5":/*AZTECA*/
				nombreColumna="id_linea_bancaria_azteca";
				break;
		}
		return nombreColumna;
	}
		
	private String obtieneNombreColumnaClientePorBanco(String cve_banco)
	{
		String nombreColumna = "";
		switch(cve_banco)
		{
			case "10":/*BANAMEX*/
				nombreColumna= "num_cliente_banamex";
				break;
			
			case "16":/*HSBC*/
				nombreColumna= "num_cliente_hsbc";
				break;
				
			case "4":/*BBVA*/
				nombreColumna="num_cliente_bbva";
				break;
				
			case "12":/*BANORTE*/
				nombreColumna= "num_cliente_banorte" ;
				break;
			
			case "5":/*AZTECA*/
				nombreColumna="num_cliente_azteca";
				break;
		}
		return nombreColumna;
	}
	
	private String obtieneNombreColumnaECCPorBanco(String cve_banco)
	{
		String nombreColumna = "";
		switch(cve_banco)
		{
			case "10":/*BANAMEX*/
				nombreColumna= "cve_usu_cr_banamex";
				break;
			
			case "16":/*HSBC*/
				nombreColumna= "cve_usu_cr_hsbc";
				break;
				
			case "4":/*BBVA*/
				nombreColumna="cve_usu_cr_bbva";
				break;
				
			case "12":/*BANORTE*/
				nombreColumna= "cve_usu_cr_banorte" ;
				break;
			
			case "5":/*AZTECA*/
				nombreColumna="cve_usu_cr_azteca";
				break;
		}
		return nombreColumna;
	}
	
	private String  obtieneNombreTablaPorBanco(String cve_banco)
	{
		String nombreTabla = "";
		switch(cve_banco)
		{
			case "10":/*BANAMEX*/
				nombreTabla= "cc_LINEA_BANCARIA_BANAMEX";
				break;
			
			case "16":/*HSBC*/
				nombreTabla= "cc_LINEA_BANCARIA_HSBC";
				break;
				
			case "4":/*BBVA*/
				nombreTabla = "cc_LINEA_BANCARIA_BBVA";
				break;
				
			case "12":/*BANORTE*/
				nombreTabla= "cc_LINEA_BANCARIA_BANORTE" ;
				break;
			
			case "5":/*AZTECA*/
				nombreTabla="cc_LINEA_BANCARIA_AZTECA" ;
				break;
		}
		return nombreTabla;
	}
	
}
