package cdo.Persistencia;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import cdo.Datos.Catalogo_Bancos;
import cdo.Datos.Catalogo_Formas_Pago;
import cdo.Datos.Catalogo_Otros_Ingresos;
import cdo.Datos.DetalleOtroIngreso;
import cdo.Datos.EncabezadoOtroIngreso;
import cdo.Datos.Log;
import cdo.Datos.Usuario;
import cdo.Datos.Querys;
import cdo.util.Cls_Log;
import cdo.util.Cls_MetodosGlobales;
import cdo.util.Cls_Querys;
import cdo.util.ConexionBD;
import cdo.util.EjecutaQuerysBD;

public class GestorControlIngresos 
{	
	public GestorControlIngresos()
	{
	}
	
	public List<DetalleOtroIngreso> AgregaConceptoDetalleTemporal(HttpServletRequest request, HttpSession session, List<DetalleOtroIngreso> ListdetalleArtTmp, Usuario infoUsu)
	{
		try
		{
			BigDecimal precio =new BigDecimal(request.getParameter("precio"));
			BigDecimal importe =new BigDecimal(request.getParameter("importe"));
			
			ListdetalleArtTmp = RemoverConceptosDuplicados(ListdetalleArtTmp, Integer.parseInt(request.getParameter("concepto")));	
			
			DetalleOtroIngreso detalleArtTmp = new DetalleOtroIngreso(infoUsu.getUname_br(), 0, 
													Integer.parseInt(request.getParameter("concepto")), 
													ObtieneNombreDeConcepto(session, Integer.parseInt(request.getParameter("concepto"))),
													Integer.parseInt(request.getParameter("cantidad")), 
													Integer.parseInt(request.getParameter("kilos")),
													importe, 0,  "",  0,  "", precio);		
			
			ListdetalleArtTmp.add(detalleArtTmp);	
			ListdetalleArtTmp.add(GenerarFilaDeTotales(ListdetalleArtTmp,infoUsu));
			Cls_Log.insertaLog(infoUsu, "", "", "Agrega ingreso temporal [" +detalleArtTmp.toString()+ "]");			
		}
		catch(Exception ex)
		{
			System.out.println("Error al agregar concepto a detalle temporal.");
			Cls_Log.insertaLog(infoUsu, "", "", "Error al agregar concepto a detalle temporal: [ " + ex.getMessage().toString()+ "] ");	
		}
		
		return ListdetalleArtTmp;
	}
	
	public List<DetalleOtroIngreso>  RemoverConceptosDuplicados(List<DetalleOtroIngreso> ListdetalleArtTmp, int concepto)
	{
		for(int i=0; i < ListdetalleArtTmp.size(); i++)
		{
			if(concepto == ListdetalleArtTmp.get(i).getId_otros_ingresos())
			{
				ListdetalleArtTmp.remove(i);
			}
			
			if(ListdetalleArtTmp.get(i).getId_otros_ingresos() == 999)
			{
				ListdetalleArtTmp.remove(i);
			}
		}
		return ListdetalleArtTmp;
	}
	
	public DetalleOtroIngreso  GenerarFilaDeTotales(List<DetalleOtroIngreso> ListdetalleArtTmp, Usuario infoUsu)
	{
		DetalleOtroIngreso detalleArtTmp= null;
		try
		{
			int cantidad=0;
			int kilos=0;
			BigDecimal importeTotal= new BigDecimal("0");
			BigDecimal precioTotal= new BigDecimal("0");
			
			for(int i=0; i < ListdetalleArtTmp.size(); i++)
			{
				cantidad = cantidad + ListdetalleArtTmp.get(i).getCantidad();
				kilos = kilos + ListdetalleArtTmp.get(i).getKilos();
				importeTotal = importeTotal.add(ListdetalleArtTmp.get(i).getImporte());
				precioTotal =  precioTotal.add(ListdetalleArtTmp.get(i).getPrecio());
			}
			
			detalleArtTmp = new DetalleOtroIngreso("", 0,999, "TOTAL", cantidad, kilos, importeTotal, 0, "", 0,"", precioTotal);
		}
		catch(Exception ex)
		{
			System.out.println("Error al generar fila de  totales.");
			Cls_Log.insertaLog(infoUsu, "", "", "Error al generar fila de  totales.: [ " + ex.getMessage().toString()+ "] ");	
		}
		return detalleArtTmp;
	}
	
	public   String  ObtieneNombreDeConcepto(HttpSession session, int concepto)
	{
		String nombre_concepto="";
		List<Catalogo_Otros_Ingresos> conceptos = (List<Catalogo_Otros_Ingresos>) session.getAttribute("listaOtrosIngresos"); 
		for(int i= 0; i < conceptos.size(); i++)
		{
			if(concepto == conceptos.get(i).getId_otro_ingreso())
			{
				nombre_concepto = conceptos.get(i).getDescripcion();
			}
		}
		return nombre_concepto;
	}
	
	public  String  ObtienePrecioXConcepto(HttpSession session, int concepto)
	{
		String precio="";
		List<Catalogo_Otros_Ingresos> conceptos = (List<Catalogo_Otros_Ingresos>) session.getAttribute("listaOtrosIngresos");
		for(int i= 0; i < conceptos.size(); i++)
		{
			if(concepto == conceptos.get(i).getId_otro_ingreso())
			{
				precio = conceptos.get(i).getModifica_precio() + "|" + conceptos.get(i).getPrecio();
			}
		}
		return precio;
	}
	
	public int  ConsultaFolioSiguienteEnBD(List<Querys> ListaQuerys, Usuario infoUsu)
	{
		int folio = 0;
		String strQry="";
		Connection connBD = null;
		PreparedStatement pstm= null;		
		connBD = ConexionBD.AbrirConexionBD(infoUsu.getUname());
		
		try
		{		
			String[] querys = new String[25];	
			querys = Cls_Querys.LimpiaListaQuerys(querys);	
			querys = Cls_Querys.ObtieneQuerys(2, ListaQuerys, querys, infoUsu);			
			querys = InicializaQuerys(2, querys, null, null, null, null);
			strQry = Cls_MetodosGlobales.obtieneSentenciaDeQrys(querys);		
			pstm = connBD.prepareStatement("{call " + "CTRL_INGRESOS.usp_EXECUTE_QUERY(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			ResultSet rs=  EjecutaQuerysBD.EjecutarQuery(querys[0], querys[1],querys[2], querys[3], querys[4], querys[5], querys[6],
														 querys[7], querys[8], querys[9],querys[10], querys[11], querys[12], querys[13], 
														 querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], 
														 querys[21], querys[22], querys[23], querys[24], infoUsu.getUname(),pstm, connBD);
		
			if (rs != null)
			 {
		        while (rs.next())
		        {
		        	folio = rs.getInt("folio");
		        }
			 }
			
			Cls_Log.insertaLog(infoUsu, "", "", "Consulta folios siguientes para otros ingresos.   "   +  " QUERIES-2[" + strQry + "]");			
		}
		catch(Exception ex)
		{
			System.out.println("Error al consultar folio. Detalle: " + ex.getMessage().toString() );
			Cls_Log.insertaLog(infoUsu, "", "", "Error al consultar folio. Detalle: [ " + ex.getMessage().toString()+ "] "  + " QUERIES-2[" + strQry + "]");
		}
		finally
		{
			try {pstm.close();} catch (SQLException e) {e.printStackTrace();}
			try {connBD.close();} catch (SQLException e) {e.printStackTrace();}
		}
		return folio;
	}
				
	public boolean  InsertaIngresoEnBD( List<Querys> ListaQuerys, List<DetalleOtroIngreso> ListDetTmpIngresos , Usuario infoUsu, Catalogo_Otros_Ingresos conceptoOI, EncabezadoOtroIngreso encabezadoOI)
	{
		boolean insertoIngresoBD = false;
		String strQry="";
		Connection connBD = null;
		PreparedStatement pstm= null;		
		connBD = ConexionBD.AbrirConexionBD(infoUsu.getUname());
		try
		{
			String[] querys = new String[25];	
			querys = Cls_Querys.LimpiaListaQuerys(querys);	
			querys = Cls_Querys.ObtieneQuerys(3, ListaQuerys, querys, infoUsu);
			querys = InicializaQuerys(3, querys, ListDetTmpIngresos, infoUsu, conceptoOI, encabezadoOI);
			strQry = Cls_MetodosGlobales.obtieneSentenciaDeQrys(querys);	
			pstm = connBD.prepareStatement("{call " + "CTRL_INGRESOS.usp_EXECUTE_QUERY(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			EjecutaQuerysBD.EjecutarQuery(querys[0], querys[1],querys[2], querys[3], querys[4], querys[5], querys[6],
														 querys[7], querys[8], querys[9],querys[10], querys[11], querys[12], querys[13], 
														 querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], 
														 querys[21], querys[22], querys[23], querys[24], infoUsu.getUname(),pstm, connBD);
			
			insertoIngresoBD=true;
			
			String strLog= "Encabezado [Folio: " +  encabezadoOI.getFolio_caja()  + "  forma Pago: " +  encabezadoOI.getCve_forma_pago() + "  banco: " +  encabezadoOI.getCve_banco() + "  banco deposito: " +  encabezadoOI.getCve_banco_deposito() +"]  Detalle ";
			for(int i= 0; i < ListDetTmpIngresos.size(); i++)
				strLog += "[Id_ingreso: " +ListDetTmpIngresos.get(i).getId_otros_ingresos()+ " cantidad=" +ListDetTmpIngresos.get(i).getCantidad() +" kilos=" +ListDetTmpIngresos.get(i).getKilos()+ " importe=" +ListDetTmpIngresos.get(i).getImporte() + "],";
		
			Cls_Log.insertaLog(infoUsu, "", "", "Inserta Otro Ingreso. " + strLog.substring(0, strLog.length()-1)  +  " QUERIES-3[" + strQry + "]");	
		}
		catch(Exception ex)
		{
			System.out.println("Error al insertar Otro Ingreso. Detalle: " + ex.getMessage().toString());
			Cls_Log.insertaLog(infoUsu, "", "", "Error al insertar Otro Ingreso. Detalle: [ " + ex.getMessage().toString()+ "] "   +  " QUERIES-3[" + strQry + "]");
		}
		finally
		{
			try {pstm.close();} catch (SQLException e) {e.printStackTrace();}
			try {connBD.close();} catch (SQLException e) {e.printStackTrace();}
		}
		return insertoIngresoBD;
	}
	
	public boolean ActualizaPrecioXConcepto( HttpSession session,List<Querys> ListaQuerys, Catalogo_Otros_Ingresos conceptoOI , Usuario infoUsu)
	{
		boolean actualizoPrecioBD= false;
		String strQry="";
		Connection connBD = null;
		PreparedStatement pstm= null;		
		connBD = ConexionBD.AbrirConexionBD(infoUsu.getUname());
		
		try
		{
			String[] querys = new String[25];	
			querys = Cls_Querys.LimpiaListaQuerys(querys);	
			querys = Cls_Querys.ObtieneQuerys(4,ListaQuerys, querys, infoUsu);
			querys = InicializaQuerys(4, querys, null, infoUsu, conceptoOI, null);
			strQry = Cls_MetodosGlobales.obtieneSentenciaDeQrys(querys);	
			pstm = connBD.prepareStatement("{call " + "CTRL_INGRESOS.usp_EXECUTE_QUERY(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			ResultSet rs = EjecutaQuerysBD.EjecutarQuery(querys[0], querys[1],querys[2], querys[3], querys[4], querys[5], querys[6],
														 querys[7], querys[8], querys[9],querys[10], querys[11], querys[12], querys[13], 
														 querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], 
														 querys[21], querys[22], querys[23], querys[24], infoUsu.getUname(),pstm, connBD);
		
			ActualizaPrecioenListaConceptosTmp(session,conceptoOI);
			actualizoPrecioBD = true;
			Cls_Log.insertaLog(infoUsu, "", "", "Actualiza el precio de un concepto. " + " [Id_concepto: " + conceptoOI.getId_otro_ingreso() + ",  Precio_nuevo: "+  conceptoOI.getPrecio() + "]  "   +  " QUERIES-4[" + strQry + "]");	
			
		}
		catch(Exception ex)
		{
			System.out.println("Error al actualizar el precio de un concepto");
			Cls_Log.insertaLog(infoUsu, "", "", "Error al actualizar el precio de un concepto: [ " + ex.getMessage().toString()+ "] "   +  " QUERIES-4[" + strQry + "]");
		}
		finally
		{
			try {pstm.close();} catch (SQLException e) {e.printStackTrace();}
			try {connBD.close();} catch (SQLException e) {e.printStackTrace();}
		}
		return actualizoPrecioBD;
	}
	
	public boolean InsertaNuevoConceptoEnBD(HttpSession session, List<Querys> ListaQuerys, Usuario infoUsu, Catalogo_Otros_Ingresos conceptoOI)
	{
		boolean insertoConceptoBD = false;
		String strQry="";
		Connection connBD = null;
		PreparedStatement pstm= null;		
		connBD = ConexionBD.AbrirConexionBD(infoUsu.getUname());
		
		try
		{
			String[] querys = new String[25];	
			querys = Cls_Querys.LimpiaListaQuerys(querys);	
			querys = Cls_Querys.ObtieneQuerys(5,ListaQuerys, querys, infoUsu);
			querys = InicializaQuerys(5, querys, null, infoUsu, conceptoOI, null);
			strQry = Cls_MetodosGlobales.obtieneSentenciaDeQrys(querys);	
			pstm = connBD.prepareStatement("{call " + "CTRL_INGRESOS.usp_EXECUTE_QUERY(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			ResultSet rs = EjecutaQuerysBD.EjecutarQuery(querys[0], querys[1],querys[2], querys[3], querys[4], querys[5], querys[6],
														 querys[7], querys[8], querys[9],querys[10], querys[11], querys[12], querys[13], 
														 querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], 
														 querys[21], querys[22], querys[23], querys[24], infoUsu.getUname(),pstm, connBD);
		
			AgregarConceptoEnListaTmp(session, rs,infoUsu);
			insertoConceptoBD = true;
			Cls_Log.insertaLog(infoUsu, "", "", "Inserta nuevo concepto. [" + conceptoOI + "]  "   +  " QUERIES-5[" + strQry + "]");	
		}
		catch(Exception ex)
		{
			System.out.println("Error al insertar un concepto");
			Cls_Log.insertaLog(infoUsu, "", "", "Error al insertar un concepto: [ " + ex.getMessage().toString()+ "] "   +  " QUERIES-5[" + strQry + "]");
		}
		finally
		{
			try {pstm.close();} catch (SQLException e) {e.printStackTrace();}
			try {connBD.close();} catch (SQLException e) {e.printStackTrace();}
		}
		return insertoConceptoBD;
	}
	
	public void AgregarConceptoEnListaTmp(HttpSession session, ResultSet rs, Usuario infoUsu)
	{
		session.removeAttribute("listaOtrosIngresos");
		
		List<Catalogo_Otros_Ingresos> ListCatOtrosIngresos = new ArrayList<>();	
		try
		{
			rs.beforeFirst();
	        while (rs.next())
	        {	    
	    		BigDecimal precio=new BigDecimal(rs.getString("precio"));
	        	Catalogo_Otros_Ingresos catalogo = new Catalogo_Otros_Ingresos(rs.getInt("id_otros_ingresos"), rs.getString("descripcion"), rs.getString("regla_contable"), precio, rs.getInt("modifica_precio"), rs.getString("uname_br"));
	        	ListCatOtrosIngresos.add(catalogo);
	        }
		}
		catch(Exception ex)
		{
			System.out.println("Error al agregar nuevo concepto a la tabla temporal.");
			Cls_Log.insertaLog(infoUsu, "", "", "Error al agregar nuevo concepto a la tabla temporal: [ " + ex.getMessage().toString()+ "] ");
		}
		
		
		session.setAttribute("listaOtrosIngresos", ListCatOtrosIngresos);
	}
	
	public void ActualizaPrecioenListaConceptosTmp(HttpSession session, Catalogo_Otros_Ingresos conceptoOI)
	{
		List<Catalogo_Otros_Ingresos> conceptos = (List<Catalogo_Otros_Ingresos>) session.getAttribute("listaOtrosIngresos");
		for(int i= 0; i < conceptos.size(); i++)
		{
			if(conceptoOI.getId_otro_ingreso() == conceptos.get(i).getId_otro_ingreso())
			{
				conceptos.get(i).setPrecio(conceptoOI.getPrecio());
				break;
			}
		}
		
		session.setAttribute("listaOtrosIngresos", conceptos);
	}
	
	public void EliminaConceptoEnListaTmp(HttpSession session, Catalogo_Otros_Ingresos conceptoOI)
	{
		Usuario infoUsu= (Usuario) session.getAttribute("infoUsu");
		List<DetalleOtroIngreso> ListDetTmpIngresos = (List<DetalleOtroIngreso>) session.getAttribute("ListDetTmpIngresos");
		ListDetTmpIngresos = RemoverConceptosDuplicados(ListDetTmpIngresos, 0);	
		
		for(int i= 0; i < ListDetTmpIngresos.size(); i++)
		{
			if(conceptoOI.getId_otro_ingreso() == ListDetTmpIngresos.get(i).getId_otros_ingresos())
			{
				ListDetTmpIngresos.remove(i);
				break;
			}
		}
		
		if(ListDetTmpIngresos.size() > 0)
			ListDetTmpIngresos.add(GenerarFilaDeTotales(ListDetTmpIngresos,infoUsu));
		else
			ListDetTmpIngresos= null;
		
		Cls_Log.insertaLog(infoUsu, "", "", "Elimina ingreso temporal [ id_concepto : " +conceptoOI.getId_otro_ingreso()+ "]");		
		session.setAttribute("ListDetTmpIngresos", ListDetTmpIngresos);
	}
	
	public String[] InicializaQuerys(int noQuery, String[] querys, List<DetalleOtroIngreso> ListDetTmpIngresos, Usuario infoUsu, Catalogo_Otros_Ingresos conceptoOI, EncabezadoOtroIngreso encabezadoOI)
	{
		String[] ListQuerys =  querys;
			
		switch (noQuery) 
		{
			case 2:		
					for (int i=0;i <ListQuerys.length; i++) 
						ListQuerys[i]= ListQuerys[i].replace("{CONCEPTO}","4");	
				break;
				
			case 3:		
				ListQuerys = InicializaQueryInsertarIngreso(querys,ListDetTmpIngresos, encabezadoOI, infoUsu);
				break;
				
			case 4:		
				for (int i=0;i <ListQuerys.length; i++) 
				{
					ListQuerys[i]= ListQuerys[i].replace("{CONCEPTO}",String.valueOf(conceptoOI.getId_otro_ingreso()));	
					ListQuerys[i]= ListQuerys[i].replace("{USUARIO}", infoUsu.getCve_usuario());
					ListQuerys[i]= ListQuerys[i].replace("{PRECIO}", String.valueOf(conceptoOI.getPrecio()));
					if(infoUsu.getNivel_usuario() == 0)
						ListQuerys[i]= ListQuerys[i].replace("{UNAME_USU}", String.valueOf(conceptoOI.getUname_usu()));	
					else
						ListQuerys[i]= ListQuerys[i].replace("{UNAME_USU}", String.valueOf(infoUsu.getUname_br()));	
				}
				
			case 5:
				for (int i=0;i <ListQuerys.length; i++) 
				{
					ListQuerys[i]= ListQuerys[i].replace("{DESCRIPCION}", conceptoOI.getDescripcion());	
					ListQuerys[i]= ListQuerys[i].replace("{REGLA_CONTABLE}", conceptoOI.getRegla_contable());
					ListQuerys[i]= ListQuerys[i].replace("{PRECIO}", String.valueOf(conceptoOI.getPrecio()));	
					ListQuerys[i]= ListQuerys[i].replace("{MODIFICA_PRECIO}", String.valueOf(conceptoOI.getModifica_precio()));	
					ListQuerys[i]= ListQuerys[i].replace("{USUARIO}", infoUsu.getCve_usuario());
					ListQuerys[i]= ListQuerys[i].replace("{UNAME_USU}", String.valueOf(conceptoOI.getUname_usu()));
				}
			break;	
				
		}
		return ListQuerys;
	}
	
	public String[]  InicializaQueryInsertarIngreso(String[] querys,List<DetalleOtroIngreso> ListDetTmpIngresos,  EncabezadoOtroIngreso encabezadoOI , Usuario infoUsu)
	{
		String[] ListQuerys =  querys;
		
		String detalle_caja = "";
		String detalle_fp_caja = "";
		String detalle_oingreso="";
		BigDecimal total = new BigDecimal("0");
		
		for( int u = 0; u < ListDetTmpIngresos.size(); u++ )
		{
			if(ListDetTmpIngresos.get(u).getId_otros_ingresos()  != 999)
			{		
				detalle_oingreso += "('" + infoUsu.getUname().toLowerCase()+ "','"+ infoUsu.getUname_br() +"', '" + encabezadoOI.getFolio_caja() + "', '"+ ListDetTmpIngresos.get(u).getId_otros_ingresos() +"','"+ ListDetTmpIngresos.get(u).getCantidad() +"','"+ ListDetTmpIngresos.get(u).getKilos() +
									 "','"+ ListDetTmpIngresos.get(u).getImporte() +"', '" +encabezadoOI.getCve_forma_pago() + "', '" + encabezadoOI.getCve_banco()+ "', CURDATE(), CURTIME()),";
				total= total.add(ListDetTmpIngresos.get(u).getImporte());
			}
		}
		
		detalle_caja += "('" + infoUsu.getUname().toLowerCase() + "','"+ infoUsu.getUname_br() + "','" + encabezadoOI.getFolio_caja() + "','4','" + encabezadoOI.getCve_forma_pago() + "','" + total + "',CURDATE(),CURTIME()),";
		
		for (int i=0;i <ListQuerys.length; i++) 
		{
			if(i == 0 || i == 2)
			{
				ListQuerys[i]= ListQuerys[i].replace("{FOLIO}",String.valueOf(encabezadoOI.getFolio_caja()));
				ListQuerys[i]= ListQuerys[i].replace("{IMPORTE_TOTAL}",String.valueOf(total));
				ListQuerys[i]= ListQuerys[i].replace("{USUARIO}", infoUsu.getCve_usuario());
				ListQuerys[i]= ListQuerys[i].replace("{FORMA_PAGO}",String.valueOf(encabezadoOI.getCve_forma_pago()));
				ListQuerys[i]= ListQuerys[i].replace("{CVE_BANCO}",String.valueOf(encabezadoOI.getCve_banco()));
				ListQuerys[i]= ListQuerys[i].replace("{BANCO_DEPOSITO}",String.valueOf(encabezadoOI.getCve_banco_deposito()));
				ListQuerys[i]= ListQuerys[i].replace("{FOLIO_FISICO}",String.valueOf(encabezadoOI.getFolio_fisico()));
				ListQuerys[i]= ListQuerys[i].replace("{REFERENCIA}",encabezadoOI.getReferencia());
				
			}	
			switch(i)
			{
				case 1:
					ListQuerys[i]= ListQuerys[i].replace("{QUERYS}",detalle_caja.substring(0,(detalle_caja.length() - 1)) +";");
					break;
				case 3:
					ListQuerys[i]= ListQuerys[i].replace("{QUERYS}",detalle_oingreso.substring(0,(detalle_oingreso.length() - 1)) +";");
					break;
			}
		}
		return ListQuerys;
	}
	
}
