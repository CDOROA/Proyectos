package Persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Datos.CFDI;
import Datos.Cliente;
import Datos.Comprobante;
import Datos.Conceptos;
import Datos.Documentos;
import Datos.Emisor;
import Datos.LOG;
import Datos.Querys;
import Datos.Receptor;
import Datos.Usuario;
import Util.Cls_Querys;
import Util.ConexionBD;
import Util.InsertaLogMantenientoCFDI;

public class GestorCFDI {

	public static List<CFDI> consultaCFDI(List<Querys> listaQuerys, String cdo, Usuario infoUsu, String opcion) {
		Connection connBD = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		connBD = ConexionBD.AbrirConexionBDD(cdo);	
		List<CFDI> ListCFDI = new ArrayList<>();
		
		try {
			
			String[] querys = new String[25];	
			querys = Cls_Querys.LimpiaListaQuerys(querys);	
			querys = Cls_Querys.ObtieneQuerys(1, listaQuerys, querys);
			querys = inicializaQueryNumero1(querys, cdo,opcion);
			pstm = connBD.prepareStatement("{call " + cdo.toUpperCase()+".usp_EXECUTE_QUERY(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			rs=  Cls_Querys.EjecutarQuery(querys[0], querys[1],querys[2], querys[3], querys[4], querys[5], querys[6],
														 querys[7], querys[8], querys[9],querys[10], querys[11], querys[12], querys[13], 
														 querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], 
														 querys[21], querys[22], querys[23], querys[24], "",pstm, connBD,infoUsu);
			
			
			Cls_Querys.ImprimeQuerysConsola(querys,false,"Query 1");
			
			if(opcion.equals("4")||opcion.equals("5")) {
				ListCFDI = llenaNotas(rs,infoUsu);
			}else if(opcion.equals("6")) {
				ListCFDI = llenaPagos(rs, infoUsu);	
			}else {
				ListCFDI = llenaClaseCFDI(rs, infoUsu);	
			}
			
		}catch(Exception ex)
		{
			//System.out.println("Error en el metodo consultaCFDI de la clase GestorCFDI");
			InsertaLogMantenientoCFDI.insertarLog( cdo,"P-175 Error en el metodo consultarCFDI de la clase GestorCFDI error: "+ex," ","0");
			//InsertaLogEncuestas.insertarLog(new LogEncuestas(),cdo,cdo,"Error en el metodo ConsultaEvaluaciones de la clase GestorEvaluaciones. DETALLE: "+ex.getMessage().toString().replace("'", "")+" Usuario: "+infoUsu.getCveUsuario(),infoUsu.getCveUsuario());
		}
		finally {
			try {
				if(connBD != null) {
					connBD.close();
				}
				if(pstm != null) {
					pstm.close();
				}
			} catch (Exception e) {
				InsertaLogMantenientoCFDI.insertarLog( cdo,"P-175 ERROR al cerrar conexcion en GestorCFDI.consultaCFDI: " + e," ","0");
			//	System.out.println("ERROR al cerrar conexcion en GestorCFDI.consultaCFDI: " + e);
			}
		}
		return ListCFDI;
	}

	private static List<CFDI> llenaPagos(ResultSet rs, Usuario infoUsu) {
		List<CFDI> ListCFDI = new ArrayList<>();
		try
		{
			if(rs != null)
			{
				while(rs.next())
				{
					CFDI cfdi = new CFDI();
					cfdi.setDocumento("0");
					cfdi.setDescripcion(rs.getString("descripcion"));
					cfdi.setFecha_pro(rs.getString("fecha_pro"));
					cfdi.setFechaCFDI(rs.getString("fecha_cfdi"));
					cfdi.setFolio(rs.getString("folio"));
					cfdi.setHora_pro(rs.getString("hora_pro"));
					cfdi.setNombreCliente(rs.getString("nombre_cliente"));
					cfdi.setNumCliente(rs.getString("num_cli"));
					cfdi.setSerie(rs.getString("serie"));
					cfdi.setEstatus(rs.getString("estatus"));
					cfdi.setSellado(rs.getString("sellado"));
					cfdi.setTipoDoc(rs.getInt("tipo_documento"));
					ListCFDI.add(cfdi);
				}
			}			
		}
		catch(Exception ex)
		{
			//InsertaLogEncuestas.insertarLog(new LogEncuestas(),infoUsu.getUname(),infoUsu.getUname(),"Error en el metodo llenaClaseEvaluacion de la clase GestorEvaluaciones. DETALLE: "+ex.getMessage().toString().replace("'", "")+" Usuario: "+infoUsu.getCveUsuario(),infoUsu.getCveUsuario());
			System.out.println("[Error: Obtener catalogo de sucursales,  Clase: GestorCFDI.llenaClaseCFDI,  Detalle: " + ex.getMessage().toString() +"]");
			 
		}
		return ListCFDI;
	}

	private static List<CFDI> llenaNotas(ResultSet rs, Usuario infoUsu) {
		List<CFDI> ListCFDI = new ArrayList<>();
		try
		{
			if(rs != null)
			{
				while(rs.next())
				{
					CFDI cfdi = new CFDI();
					cfdi.setDocumento(rs.getString("documento"));
					cfdi.setDescripcion(rs.getString("descripcion"));
					cfdi.setFecha_pro(rs.getString("fecha_pro"));
					cfdi.setFechaCFDI(rs.getString("fecha_cfdi"));
					cfdi.setFolio(rs.getString("folio"));
					cfdi.setHora_pro(rs.getString("hora_pro"));
					cfdi.setNombreCliente(rs.getString("nombre_cliente"));
					cfdi.setNumCliente(rs.getString("num_cli"));
					cfdi.setSerie(rs.getString("serie"));
					cfdi.setEstatus(rs.getString("estatus"));
					cfdi.setSellado(rs.getString("sellado"));
					cfdi.setTipoDoc(rs.getInt("tipo_documento"));
					ListCFDI.add(cfdi);
				}
			}			
		}
		catch(Exception ex)
		{
			//InsertaLogEncuestas.insertarLog(new LogEncuestas(),infoUsu.getUname(),infoUsu.getUname(),"Error en el metodo llenaClaseEvaluacion de la clase GestorEvaluaciones. DETALLE: "+ex.getMessage().toString().replace("'", "")+" Usuario: "+infoUsu.getCveUsuario(),infoUsu.getCveUsuario());
			System.out.println("[Error: Obtener catalogo de sucursales,  Clase: GestorCFDI.llenaClaseCFDI,  Detalle: " + ex.getMessage().toString() +"]");
			 
		}
		return ListCFDI;
	}

	private static String[] inicializaQueryNumero1(String[] querys, String cdo, String opcion) {
		for (int i=0;i <querys.length; i++)
		{	
			querys[i]=querys[i].replace("{TIPO_DOC}",opcion);
		}
		if(opcion.equals("4")||opcion.equals("5")) {
			querys[0]=querys[1];
			querys[1]="";
			querys[2]="";
			querys[3]="";
		}else if(opcion.equals("3")){
			querys[0]=querys[2];
			querys[1]="";
			querys[2]="";
			querys[3]="";
		}else if(opcion.equals("6")){
			querys[0]=querys[3];
			querys[1]="";
			querys[2]="";
			querys[3]="";
		}else {
			querys[1]="";
			querys[2]="";
			querys[3]="";
		}
		//System.out.println("query1: "+querys[0]+"\nquerys2: "+querys[1]+"\nquery3: "+querys[2]);
		return querys;
	}

	private static List<CFDI> llenaClaseCFDI(ResultSet rs, Usuario infoUsu) {
		List<CFDI> ListCFDI = new ArrayList<>();
		try
		{
			if(rs != null)
			{
				while(rs.next())
				{
					CFDI cfdi = new CFDI();
					cfdi.setDocumento(rs.getString("documento"));
					cfdi.setDescripcion(rs.getString("descripcion"));
					cfdi.setFecha_pro(rs.getString("fecha_pro"));
					cfdi.setFechaCFDI(rs.getString("fecha_cfdi"));
					cfdi.setFechaPedido(rs.getString("fecha_pedido"));
					cfdi.setFolio(rs.getString("folio"));
					cfdi.setHora_pro(rs.getString("hora_pro"));
					cfdi.setNombreCliente(rs.getString("nombre_cliente"));
					cfdi.setNumCliente(rs.getString("num_cli"));
					cfdi.setOde(rs.getString("ode"));
					cfdi.setPedido(rs.getString("pedido"));
					cfdi.setSerie(rs.getString("serie"));
					cfdi.setEstatus(rs.getString("estatus"));
					cfdi.setSellado(rs.getString("sellado"));
					cfdi.setPrioridad(rs.getString("prioridad"));
					cfdi.setTipoDoc(rs.getInt("tipo_documento"));
					ListCFDI.add(cfdi);
				}
			}			
		}
		catch(Exception ex)
		{
			//InsertaLogEncuestas.insertarLog(new LogEncuestas(),infoUsu.getUname(),infoUsu.getUname(),"Error en el metodo llenaClaseEvaluacion de la clase GestorEvaluaciones. DETALLE: "+ex.getMessage().toString().replace("'", "")+" Usuario: "+infoUsu.getCveUsuario(),infoUsu.getCveUsuario());
			System.out.println("[Error: Obtener catalogo de sucursales,  Clase: GestorCFDI.llenaClaseCFDI,  Detalle: " + ex.getMessage().toString() +"]");
			 
		}
		return ListCFDI;
	}

	public static List<Comprobante> consultaComprobantes(List<Querys> listaQuerys, String cdo, Usuario infoUsu,
			String serie, String folio) {
		Connection connBD = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		connBD = ConexionBD.AbrirConexionBDD(cdo);	
		List<Comprobante> ListComprobante = new ArrayList<>();
		
		try {
			
			String[] querys = new String[25];	
			querys = Cls_Querys.LimpiaListaQuerys(querys);	
			querys = Cls_Querys.ObtieneQuerys(2, listaQuerys, querys);
			querys = inicializaQueryNumero2(querys, cdo,serie,folio);
			pstm = connBD.prepareStatement("{call " + cdo.toUpperCase()+".usp_EXECUTE_QUERY(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			rs=  Cls_Querys.EjecutarQuery(querys[0], querys[1],querys[2], querys[3], querys[4], querys[5], querys[6],
														 querys[7], querys[8], querys[9],querys[10], querys[11], querys[12], querys[13], 
														 querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], 
														 querys[21], querys[22], querys[23], querys[24], "",pstm, connBD,infoUsu);
			
			
			Cls_Querys.ImprimeQuerysConsola(querys,false,"Query 2");
			
			ListComprobante = llenaClaseComprobante(rs, infoUsu);	
		//	InsertaLogMantenientoCFDI.insertarLog( cdo,"P-175 Entra a consultaComprobantes de la  serie: "+serie+" folio: "+folio+" usuario: "+(infoUsu.getCveUsuario()),serie, folio);
			//InsertaLogEncuestas.insertarLog(new LogEncuestas(),cdo,cdo,"Entrada a consultar Evaluaciones Usuario: "+infoUsu.getCveUsuario()+" qry{"+Cls_Querys.regresaQuerys(querys,false)+"}",infoUsu.getCveUsuario());
		}catch(Exception ex)
		{
			InsertaLogMantenientoCFDI.insertarLog( cdo,"P-175 Error al consultarComprobantes en GestorCFDI.consultaCFDI: " + ex,serie,folio);
			//System.out.println("Error en el metodo consultaCFDI de la clase GestorCFDI");
			//InsertaLogEncuestas.insertarLog(new LogEncuestas(),cdo,cdo,"Error en el metodo ConsultaEvaluaciones de la clase GestorEvaluaciones. DETALLE: "+ex.getMessage().toString().replace("'", "")+" Usuario: "+infoUsu.getCveUsuario(),infoUsu.getCveUsuario());
		}
		finally {
			try {
				if(connBD != null) {
					connBD.close();
				}
				if(pstm != null) {
					pstm.close();
				}
			} catch (Exception e) {
				InsertaLogMantenientoCFDI.insertarLog( cdo,"P-175 ERROR al cerrar conexcion en GestorCFDI.consultaCFDI: " + e,serie,folio);
				//System.out.println("ERROR al cerrar conexcion en GestorCFDI.consultaCFDI: " + e);
			}
		}
		return ListComprobante;
	}

	private static String[] inicializaQueryNumero2(String[] querys, String cdo, String serie, String folio) {
		for (int i=0;i <querys.length; i++)
		{	
			querys[i]=querys[i].replace("{SERIE}", String.valueOf(serie));
			querys[i]=querys[i].replace("{FOLIO}", String.valueOf(folio));
		}
		return querys;
	}

	private static List<Comprobante> llenaClaseComprobante(ResultSet rs, Usuario infoUsu) {
		List<Comprobante> ListComprobante = new ArrayList<>();
		try
		{
			if(rs != null)
			{
				while(rs.next())
				{
					Comprobante c = new Comprobante();
					c.setEstatus(rs.getString("estatus"));
					c.setExportacion(rs.getString("exportacion"));
					c.setFechaCFDI(rs.getString("fecha_cfdi"));
					c.setFechaPro(rs.getString("fecha_pro"));
					c.setHoraPro(rs.getString("hora_pro"));
					c.setFolio(rs.getString("folio"));
					c.setFormaPago(rs.getString("forma_pago"));
					c.setImporteDescuentos(rs.getString("importe_descuentos"));
					c.setImporteSubTotal(rs.getString("importe_subtotal"));
					c.setImporteTotal(rs.getString("importe_total"));
					c.setLugarExpedicion(rs.getString("lugar_expedicion"));
					c.setMetodoPago(rs.getString("metodo_pago"));
					c.setMoneda(rs.getString("moneda"));
					c.setObservaciones(rs.getString("observaciones"));
					c.setOde(rs.getString("ode"));
					c.setSerie(rs.getString("serie"));
					c.setTipoCambio(rs.getString("tipo_cambio"));
					c.setTipoComprobante(rs.getString("tipo_comprobante"));
					c.setTipoDocumento(rs.getString("tipo_documento"));
					ListComprobante.add(c);
				}
			}			
		}
		catch(Exception ex)
		{
			//InsertaLogEncuestas.insertarLog(new LogEncuestas(),infoUsu.getUname(),infoUsu.getUname(),"Error en el metodo llenaClaseEvaluacion de la clase GestorEvaluaciones. DETALLE: "+ex.getMessage().toString().replace("'", "")+" Usuario: "+infoUsu.getCveUsuario(),infoUsu.getCveUsuario());
		//	System.out.println("[Error: Obtener catalogo de sucursales,  Clase: GestorCFDI.llenaClaseComprobante,  Detalle: " + ex.getMessage().toString() +"]");
			 
		}
		return ListComprobante;
	}

//	public static List<String> consultaOpciones(List<Querys> listaQuerys, String cdo, Usuario infoUsu) {
//		Connection connBD = null;
//		PreparedStatement pstm = null;
//		ResultSet rs = null;
//		connBD = ConexionBD.AbrirConexionBDD(cdo);	
//		List<String> opciones = new ArrayList<>();
//		
//		try {
//			
//			String[] querys = new String[25];	
//			querys = Cls_Querys.LimpiaListaQuerys(querys);	
//			querys = Cls_Querys.ObtieneQuerys(3, listaQuerys, querys);
//			//querys = inicializaQueryNumero2(querys, cdo,serie,folio);
//			pstm = connBD.prepareStatement("{call " + cdo.toUpperCase()+".usp_EXECUTE_QUERY(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
//			rs=  Cls_Querys.EjecutarQuery(querys[0], querys[1],querys[2], querys[3], querys[4], querys[5], querys[6],
//														 querys[7], querys[8], querys[9],querys[10], querys[11], querys[12], querys[13], 
//														 querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], 
//														 querys[21], querys[22], querys[23], querys[24], "",pstm, connBD,infoUsu);
//			
//			
//			Cls_Querys.ImprimeQuerysConsola(querys,false,"Query 2");
//			
//				if(rs != null)
//				{
//					while(rs.next())
//					{
//						opciones.add(rs.getString("opcion"));
//					}
//				}	
//				InsertaLogMantenientoCFDI.insertarLog( cdo,"P-175 Entra a consultar opciones usuario: "+(infoUsu.getCveUsuario()),serie, folio);
//			//InsertaLogEncuestas.insertarLog(new LogEncuestas(),cdo,cdo,"Entrada a consultar Evaluaciones Usuario: "+infoUsu.getCveUsuario()+" qry{"+Cls_Querys.regresaQuerys(querys,false)+"}",infoUsu.getCveUsuario());
//		}catch(Exception ex)
//		{
//			//System.out.println("Error en el metodo consultaCFDI de la clase GestorCFDI");
//			InsertaLogMantenientoCFDI.insertarLog( cdo,"P-175 Error al consultar opciones GestorCFDI.consultaOpciones: " + ex,serie,folio);
//		}
//		finally {
//			try {
//				if(connBD != null) {
//					connBD.close();
//				}
//				if(pstm != null) {
//					pstm.close();
//				}
//			} catch (Exception e) {
//				InsertaLogMantenientoCFDI.insertarLog( cdo,"P-175 ERROR al cerrar conexcion en GestorCFDI.consultaOpciones: " + e,serie,folio);
//		//		System.out.println("ERROR al cerrar conexcion en GestorCFDI.consulta: " + e);
//			}
//		}
//		return opciones;
//	}

	public static List<Emisor> consultaEmisor(List<Querys> listaQuerys, String cdo, Usuario infoUsu, String serie,
			String folio) {
		Connection connBD = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		connBD = ConexionBD.AbrirConexionBDD(cdo);	
		List<Emisor> ListEmisor = new ArrayList<>();
		
		try {
			
			String[] querys = new String[25];	
			querys = Cls_Querys.LimpiaListaQuerys(querys);	
			querys = Cls_Querys.ObtieneQuerys(4, listaQuerys, querys);
			querys = inicializaQueryNumero2(querys, cdo,serie,folio);
			pstm = connBD.prepareStatement("{call " + cdo.toUpperCase()+".usp_EXECUTE_QUERY(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			rs=  Cls_Querys.EjecutarQuery(querys[0], querys[1],querys[2], querys[3], querys[4], querys[5], querys[6],
														 querys[7], querys[8], querys[9],querys[10], querys[11], querys[12], querys[13], 
														 querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], 
														 querys[21], querys[22], querys[23], querys[24], "",pstm, connBD,infoUsu);
			
			
			Cls_Querys.ImprimeQuerysConsola(querys,false,"Query 2");
			
			if(rs != null)
			{
				while(rs.next())
				{
					Emisor e =new Emisor();
					e.setNombreEmisor(rs.getString("nombre"));
					e.setRegimenFiscal(rs.getString("descripcion"));
					e.setRfc(rs.getString("rfc"));
					ListEmisor.add(e);
				}
			}	
		//	InsertaLogMantenientoCFDI.insertarLog( cdo,"P-175 Entra a consultar datos del emisor de la  serie: "+serie+" folio: "+folio+" usuario: "+(infoUsu.getCveUsuario()),serie, folio);
			//InsertaLogEncuestas.insertarLog(new LogEncuestas(),cdo,cdo,"Entrada a consultar Evaluaciones Usuario: "+infoUsu.getCveUsuario()+" qry{"+Cls_Querys.regresaQuerys(querys,false)+"}",infoUsu.getCveUsuario());
		}catch(Exception ex)
		{
			InsertaLogMantenientoCFDI.insertarLog( cdo,"P-175 Error al consultar emisor GestorCFDI.Emisor: " + ex,serie,folio);
			//System.out.println("Error en el metodo consultaCFDI de la clase GestorCFDI");
			//InsertaLogEncuestas.insertarLog(new LogEncuestas(),cdo,cdo,"Error en el metodo ConsultaEvaluaciones de la clase GestorEvaluaciones. DETALLE: "+ex.getMessage().toString().replace("'", "")+" Usuario: "+infoUsu.getCveUsuario(),infoUsu.getCveUsuario());
		}
		finally {
			try {
				if(connBD != null) {
					connBD.close();
				}
				if(pstm != null) {
					pstm.close();
				}
			} catch (Exception e) {
				InsertaLogMantenientoCFDI.insertarLog( cdo,"P-175 ERROR al cerrar conexcion en GestorCFDI.consultaCFDI: " + e,serie,folio);
	//			System.out.println("ERROR al cerrar conexcion en GestorCFDI.consultaCFDI: " + e);
			}
		}
		return ListEmisor;
	}

	public static List<LOG> consultaLOG(List<Querys> listaQuerys, String cdo, Usuario infoUsu, String serie,
			String folio) {
		Connection connBD = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		connBD = ConexionBD.AbrirConexionBDD(cdo);	
		List<LOG> ListLOG = new ArrayList<>();
		
		try {
			
			String[] querys = new String[25];	
			querys = Cls_Querys.LimpiaListaQuerys(querys);	
			querys = Cls_Querys.ObtieneQuerys(6, listaQuerys, querys);
			querys = inicializaQueryNumero2(querys, cdo,serie,folio);
			pstm = connBD.prepareStatement("{call " + cdo.toUpperCase()+".usp_EXECUTE_QUERY(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			rs=  Cls_Querys.EjecutarQuery(querys[0], querys[1],querys[2], querys[3], querys[4], querys[5], querys[6],
														 querys[7], querys[8], querys[9],querys[10], querys[11], querys[12], querys[13], 
														 querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], 
														 querys[21], querys[22], querys[23], querys[24], "",pstm, connBD,infoUsu);
			
			
			Cls_Querys.ImprimeQuerysConsola(querys,false,"Query 2");
			
			if(rs != null)
			{
				while(rs.next())
				{
					LOG l =new LOG();
					l.setDescripcion(rs.getString("descripcion"));
					l.setDocumento(rs.getString("documento"));
					l.setDocumentoCFDI(rs.getString("documento_cfdi"));
					l.setFechaPro(rs.getString("fecha_pro"));
					l.setFolio(rs.getString("folio"));
					l.setHoraPro(rs.getString("hora_pro"));
					l.setOde(rs.getString("ode"));
					l.setSerie(rs.getString("serie"));
					l.setUname(rs.getString("uname"));
					ListLOG.add(l);
				}
			}	
			//InsertaLogMantenientoCFDI.insertarLog( cdo,"P-175 Entra a consultar log  de la  serie: "+serie+" folio: "+folio+" usuario: "+(infoUsu.getCveUsuario()),serie, folio);
			//InsertaLogEncuestas.insertarLog(new LogEncuestas(),cdo,cdo,"Entrada a consultar Evaluaciones Usuario: "+infoUsu.getCveUsuario()+" qry{"+Cls_Querys.regresaQuerys(querys,false)+"}",infoUsu.getCveUsuario());
		}catch(Exception ex)
		{
			System.out.println("Error en el metodo consultaCFDI de la clase GestorCFDI");
			InsertaLogMantenientoCFDI.insertarLog( cdo,"P-175 Error al consultar log GestorCFDI.consultaLog: " + ex,serie,folio);
			//InsertaLogEncuestas.insertarLog(new LogEncuestas(),cdo,cdo,"Error en el metodo ConsultaEvaluaciones de la clase GestorEvaluaciones. DETALLE: "+ex.getMessage().toString().replace("'", "")+" Usuario: "+infoUsu.getCveUsuario(),infoUsu.getCveUsuario());
		}
		finally {
			try {
				if(connBD != null) {
					connBD.close();
				}
				if(pstm != null) {
					pstm.close();
				}
			} catch (Exception e) {
				InsertaLogMantenientoCFDI.insertarLog( cdo,"P-175 ERROR al cerrar conexcion en GestorCFDI.consultaLog: " + e,serie,folio);
			}
		}
		return ListLOG;
	}

	public static List<Receptor> consultaReceptor(List<Querys> listaQuerys, String cdo, Usuario infoUsu, String serie,
			String folio) {
		Connection connBD = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		connBD = ConexionBD.AbrirConexionBDD(cdo);	
		List<Receptor> ListReceptor = new ArrayList<>();
		
		try {
			
			String[] querys = new String[25];	
			querys = Cls_Querys.LimpiaListaQuerys(querys);	
			querys = Cls_Querys.ObtieneQuerys(5, listaQuerys, querys);
			querys = inicializaQueryNumero2(querys, cdo,serie,folio);
			pstm = connBD.prepareStatement("{call " + cdo.toUpperCase()+".usp_EXECUTE_QUERY(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			rs=  Cls_Querys.EjecutarQuery(querys[0], querys[1],querys[2], querys[3], querys[4], querys[5], querys[6],
														 querys[7], querys[8], querys[9],querys[10], querys[11], querys[12], querys[13], 
														 querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], 
														 querys[21], querys[22], querys[23], querys[24], "",pstm, connBD,infoUsu);
			
			
			Cls_Querys.ImprimeQuerysConsola(querys,false,"Query 2");
			
			ListReceptor = llenaClaseReceptor(rs, infoUsu);	
			//InsertaLogMantenientoCFDI.insertarLog( cdo,"P-175 Entra a consultar receptor de la  serie: "+serie+" folio: "+folio+" usuario: "+(infoUsu.getCveUsuario()),serie, folio);
			//InsertaLogEncuestas.insertarLog(new LogEncuestas(),cdo,cdo,"Entrada a consultar Evaluaciones Usuario: "+infoUsu.getCveUsuario()+" qry{"+Cls_Querys.regresaQuerys(querys,false)+"}",infoUsu.getCveUsuario());
		}catch(Exception ex)
		{
			//System.out.println("Error en el metodo consultaCFDI de la clase GestorCFDI");
			InsertaLogMantenientoCFDI.insertarLog( cdo,"P-175 Error al consultar receptor GestorCFDI.consultarReceptor: " + ex,serie,folio);
			//InsertaLogEncuestas.insertarLog(new LogEncuestas(),cdo,cdo,"Error en el metodo ConsultaEvaluaciones de la clase GestorEvaluaciones. DETALLE: "+ex.getMessage().toString().replace("'", "")+" Usuario: "+infoUsu.getCveUsuario(),infoUsu.getCveUsuario());
		}
		finally {
			try {
				if(connBD != null) {
					connBD.close();
				}
				if(pstm != null) {
					pstm.close();
				}
			} catch (Exception e) {
				InsertaLogMantenientoCFDI.insertarLog( cdo,"P-175 ERROR al cerrar conexcion en GestorCFDI.consultaReceptor: " + e,serie,folio);
				//System.out.println("ERROR al cerrar conexcion en GestorCFDI.consultaCFDI: " + e);
			}
		}
		return ListReceptor;
	}

	private static List<Receptor> llenaClaseReceptor(ResultSet rs, Usuario infoUsu) {
		List<Receptor> ListReceptor = new ArrayList<>();
		try
		{
			if(rs != null)
			{
				while(rs.next())
				{
					Receptor r = new Receptor();
					r.setDomicilioFiscalReceptor(rs.getString("domicilio_fiscal"));
					r.setEtiquetaAgente(rs.getString("etiqueta_agente"));
					r.setEtiquetaCalle(rs.getString("etiqueta_calle"));
					r.setEtiquetaCodigoPostal(rs.getString("etiqueta_codigo_postal"));
					r.setEtiquetaColonia(rs.getString("etiqueta_colonia"));
					r.setEtiquetaCondCred(rs.getString("etiqueta_condicion_credito"));
					r.setEtiquetaEstado(rs.getString("etiqueta_estado"));
					r.setEtiquetaMail(rs.getString("etiqueta_email"));
					r.setEtiquetaMunicipio(rs.getString("etiqueta_municipio"));
					r.setEtiquetaNumCli(rs.getString("etiqueta_num_cli"));
					r.setEtiquetaNumExt(rs.getString("etiqueta_no_exterior"));
					r.setEtiquetaNumInt(rs.getString("etiqueta_no_interior"));
					r.setEtiquetaPais(rs.getString("etiqueta_pais"));
					r.setEtiquetaPedido(rs.getString("etiqueta_pedido"));
					r.setEtiquetaRuta(rs.getString("etiqueta_ruta"));
					r.setEtiquetaTipoCliente(rs.getString("etiqueta_tipo_cte"));
					r.setEtiquetaTipoDocto(rs.getString("etiqueta_tipo_docto_ft"));
					r.setEtiquetaTipoFact(rs.getString("etiqueta_tipo_fact"));
					r.setEtiquetaTransporte(rs.getString("etiqueta_transporte"));
					r.setNombreReceptor(rs.getString("nombre"));
					r.setRegimenFiscalReceptor(rs.getString("regimen_fiscal"));
					r.setRfcReceptor(rs.getString("rfc"));
					r.setUsoCFDIReceptor(rs.getString("uso_cfdi"));
					ListReceptor.add(r);
				}
			}			
		}
		catch(Exception ex)
		{
			//InsertaLogEncuestas.insertarLog(new LogEncuestas(),infoUsu.getUname(),infoUsu.getUname(),"Error en el metodo llenaClaseEvaluacion de la clase GestorEvaluaciones. DETALLE: "+ex.getMessage().toString().replace("'", "")+" Usuario: "+infoUsu.getCveUsuario(),infoUsu.getCveUsuario());
		//	System.out.println("[Error: Obtener catalogo de sucursales,  Clase: GestorCFDI.llenaClaseComprobante,  Detalle: " + ex.getMessage().toString() +"]");
			 
		}
		return ListReceptor;
	}

	public static List<Conceptos> consultaConceptos(List<Querys> listaQuerys, String cdo, Usuario infoUsu, String serie,
			String folio) {
		Connection connBD = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		connBD = ConexionBD.AbrirConexionBDD(cdo);	
		List<Conceptos> ListConceptos = new ArrayList<>();
		
		try {
			
			String[] querys = new String[25];	
			querys = Cls_Querys.LimpiaListaQuerys(querys);	
			querys = Cls_Querys.ObtieneQuerys(7, listaQuerys, querys);
			querys = inicializaQueryNumero2(querys, cdo,serie,folio);
			pstm = connBD.prepareStatement("{call " + cdo.toUpperCase()+".usp_EXECUTE_QUERY(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			rs=  Cls_Querys.EjecutarQuery(querys[0], querys[1],querys[2], querys[3], querys[4], querys[5], querys[6],
														 querys[7], querys[8], querys[9],querys[10], querys[11], querys[12], querys[13], 
														 querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], 
														 querys[21], querys[22], querys[23], querys[24], "",pstm, connBD,infoUsu);
			
			
			Cls_Querys.ImprimeQuerysConsola(querys,false,"Query 2");
			
			ListConceptos = llenaClaseConceptos(rs, infoUsu);	
		//	InsertaLogMantenientoCFDI.insertarLog( cdo,"P-175 Entra a consultar datos del conceptos de la  serie: "+serie+" folio: "+folio+" usuario: "+(infoUsu.getCveUsuario()),serie, folio);
			//InsertaLogEncuestas.insertarLog(new LogEncuestas(),cdo,cdo,"Entrada a consultar Evaluaciones Usuario: "+infoUsu.getCveUsuario()+" qry{"+Cls_Querys.regresaQuerys(querys,false)+"}",infoUsu.getCveUsuario());
		}catch(Exception ex)
		{
			InsertaLogMantenientoCFDI.insertarLog( cdo,"P-175 Error al consultar conceptos GestorCFDI.consultaConceptos: " + ex,serie,folio);
			System.out.println("Error en el metodo consultaCFDI de la clase GestorCFDI");
			//InsertaLogEncuestas.insertarLog(new LogEncuestas(),cdo,cdo,"Error en el metodo ConsultaEvaluaciones de la clase GestorEvaluaciones. DETALLE: "+ex.getMessage().toString().replace("'", "")+" Usuario: "+infoUsu.getCveUsuario(),infoUsu.getCveUsuario());
		}
		finally {
			try {
				if(connBD != null) {
					connBD.close();
				}
				if(pstm != null) {
					pstm.close();
				}
			} catch (Exception e) {
				InsertaLogMantenientoCFDI.insertarLog( cdo,"P-175 ERROR al cerrar conexcion en GestorCFDI.consultaConceptos: " + e,serie,folio);
			//	System.out.println("ERROR al cerrar conexcion en GestorCFDI.consultaCFDI: " + e);
			}
		}
		return ListConceptos;
	}

	private static List<Conceptos> llenaClaseConceptos(ResultSet rs, Usuario infoUsu) {
		List<Conceptos> ListConceptos = new ArrayList<>();
		try
		{
			if(rs != null)
			{
				while(rs.next())
				{
					Conceptos c=new Conceptos();
					c.setBaseRetencion(rs.getString("base_retencion"));
					c.setBaseTraslado(rs.getString("base_traslado"));
					c.setCantidad(rs.getString("cantidad"));
					c.setClaveProdServ(rs.getString("clave_prod_serv"));
					c.setClaveUnidad(rs.getString("clave_unidad"));
					c.setDescripcionConceptos(rs.getString("descripcion"));
					c.setDescuento(rs.getString("descuento"));
					c.setImporte(rs.getString("importe"));
					c.setImporteRetencion(rs.getString("importe_retencion"));
					c.setImporteTraslado(rs.getString("importe_traslado"));
					c.setImpuestoRetencion(rs.getString("impuesto_retencion"));
					c.setImpuestoTraslado(rs.getString("impuesto_traslado"));
					c.setNoIdentificacion(rs.getString("no_identificacion"));
					c.setNumRenglon(rs.getString("num_renglon"));
					c.setObjetoImp(rs.getString("objeto_imp"));
					c.setTasaCuota(rs.getString("tasa_cuota_traslado"));
					c.setTasaCuotaRetencion(rs.getString("tasa_cuota_retencion"));
					c.setTipoFactorRetencion(rs.getString("tipo_factor_retencion"));
					c.setTipoFactorTranslado(rs.getString("tipo_factor_traslado"));
					c.setUnidad(rs.getString("unidad"));
					c.setValorUnitario(rs.getString("valor_unitario"));
					ListConceptos.add(c);
				}
			}			
		}
		catch(Exception ex)
		{
			//InsertaLogEncuestas.insertarLog(new LogEncuestas(),infoUsu.getUname(),infoUsu.getUname(),"Error en el metodo llenaClaseEvaluacion de la clase GestorEvaluaciones. DETALLE: "+ex.getMessage().toString().replace("'", "")+" Usuario: "+infoUsu.getCveUsuario(),infoUsu.getCveUsuario());
			System.out.println("[Error: Obtener catalogo de sucursales,  Clase: GestorCFDI.llenaClaseComprobante,  Detalle: " + ex.getMessage().toString() +"]");
			 
		}
		return ListConceptos;
	}

	public static List<Documentos> consultaDocumentos(List<Querys> listaQuerys, String cdo, Usuario infoUsu,
			String serie, String folio) {
		Connection connBD = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		connBD = ConexionBD.AbrirConexionBDD(cdo);	
		List<Documentos> ListDocumentos = new ArrayList<>();
		
		try {
			
			String[] querys = new String[25];	
			querys = Cls_Querys.LimpiaListaQuerys(querys);	
			querys = Cls_Querys.ObtieneQuerys(8, listaQuerys, querys);
			querys = inicializaQueryNumero2(querys, cdo,serie,folio);
			pstm = connBD.prepareStatement("{call " + cdo.toUpperCase()+".usp_EXECUTE_QUERY(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			rs=  Cls_Querys.EjecutarQuery(querys[0], querys[1],querys[2], querys[3], querys[4], querys[5], querys[6],
														 querys[7], querys[8], querys[9],querys[10], querys[11], querys[12], querys[13], 
														 querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], 
														 querys[21], querys[22], querys[23], querys[24], "",pstm, connBD,infoUsu);
			
			
			Cls_Querys.ImprimeQuerysConsola(querys,false,"Query 2");
			
			if(rs != null)
			{
				while(rs.next())
				{
					Documentos d =new Documentos();
					d.setDocumentoRelacionado(rs.getString("documento_relacionado"));
					d.setFolioFiscal(rs.getString("folio_fiscal"));
					d.setTipoRelacion(rs.getString("tipo_relacion"));
					ListDocumentos.add(d);
				}
			}	
		//	InsertaLogMantenientoCFDI.insertarLog( cdo,"P-175 Entra a consultar datos de los documentos de la  serie: "+serie+" folio: "+folio+" usuario: "+(infoUsu.getCveUsuario()),serie, folio);
			//InsertaLogEncuestas.insertarLog(new LogEncuestas(),cdo,cdo,"Entrada a consultar Evaluaciones Usuario: "+infoUsu.getCveUsuario()+" qry{"+Cls_Querys.regresaQuerys(querys,false)+"}",infoUsu.getCveUsuario());
		}catch(Exception ex)
		{
			//System.out.println("Error en el metodo consultaCFDI de la clase GestorCFDI");
			InsertaLogMantenientoCFDI.insertarLog( cdo,"P-175 Error al consultar documentos GestorCFDI.consultaDocumentos: " + ex,serie,folio);
			//InsertaLogEncuestas.insertarLog(new LogEncuestas(),cdo,cdo,"Error en el metodo ConsultaEvaluaciones de la clase GestorEvaluaciones. DETALLE: "+ex.getMessage().toString().replace("'", "")+" Usuario: "+infoUsu.getCveUsuario(),infoUsu.getCveUsuario());
		}
		finally {
			try {
				if(connBD != null) {
					connBD.close();
				}
				if(pstm != null) {
					pstm.close();
				}
			} catch (Exception e) {
				InsertaLogMantenientoCFDI.insertarLog( cdo,"P-175 ERROR al cerrar conexcion en GestorCFDI.consultaDocumentos: " + e,serie,folio);
				//System.out.println("ERROR al cerrar conexcion en GestorCFDI.consultaCFDI: " + e);
			}
		}
		return ListDocumentos;
	}

	public static String actualizarRegimenReceptor(List<Querys> listaQuerys, String cdo, Usuario infoUsu, String serie,
			String folio, String numeroCliente) {
		Connection connBD = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		connBD = ConexionBD.AbrirConexionBDD(cdo);	
		String respuesta = "";
		
		try {
			
			String[] querys = new String[25];	
			querys = Cls_Querys.LimpiaListaQuerys(querys);	
			querys = Cls_Querys.ObtieneQuerys(9, listaQuerys, querys);
			querys = inicializaQueryNumero9(querys, cdo,serie,folio,numeroCliente);
			pstm = connBD.prepareStatement("{call " + cdo.toUpperCase()+".usp_EXECUTE_QUERY(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			rs=  Cls_Querys.EjecutarQuery(querys[0], querys[1],querys[2], querys[3], querys[4], querys[5], querys[6],
														 querys[7], querys[8], querys[9],querys[10], querys[11], querys[12], querys[13], 
														 querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], 
														 querys[21], querys[22], querys[23], querys[24], "",pstm, connBD,infoUsu);
			
			
			Cls_Querys.ImprimeQuerysConsola(querys,false,"Query 2");
			if(rs != null)
			{
				while(rs.next())
				{
					respuesta=rs.getString("regimenFiscal");
				}
			}
			InsertaLogMantenientoCFDI.insertarLog( cdo,"P-175 Entra a actualizar Regimen fiscal del  de la  serie: "+serie+" folio: "+folio+" usuario: "+(infoUsu.getCveUsuario()),serie, folio);
			//InsertaLogEncuestas.insertarLog(new LogEncuestas(),cdo,cdo,"Entrada a consultar Evaluaciones Usuario: "+infoUsu.getCveUsuario()+" qry{"+Cls_Querys.regresaQuerys(querys,false)+"}",infoUsu.getCveUsuario());
		}catch(Exception ex)
		{
			InsertaLogMantenientoCFDI.insertarLog( cdo,"P-175 Error al actualizar regimen  GestorCFDI.actualizarRegimenReceptor: " + ex,serie,folio);
			//System.out.println("Error en el metodo consultaCFDI de la clase GestorCFDI");
			//InsertaLogEncuestas.insertarLog(new LogEncuestas(),cdo,cdo,"Error en el metodo ConsultaEvaluaciones de la clase GestorEvaluaciones. DETALLE: "+ex.getMessage().toString().replace("'", "")+" Usuario: "+infoUsu.getCveUsuario(),infoUsu.getCveUsuario());
		}
		finally {
			try {
				if(connBD != null) {
					connBD.close();
				}
				if(pstm != null) {
					pstm.close();
				}
			} catch (Exception e) {
				InsertaLogMantenientoCFDI.insertarLog( cdo,"P-175 ERROR al cerrar conexcion en GestorCFDI.actualizarRegimenReceptor: " + e,serie,folio);
				//System.out.println("ERROR al cerrar conexcion en GestorCFDI.consultaCFDI: " + e);
			}
		}
		return respuesta;
	}

	private static String[] inicializaQueryNumero9(String[] querys, String cdo, String serie, String folio,
			String numeroCliente) {
		for (int i=0;i <querys.length; i++)
		{	
			querys[i]=querys[i].replace("{SERIE}", String.valueOf(serie));
			querys[i]=querys[i].replace("{FOLIO}", String.valueOf(folio));
			querys[i]=querys[i].replace("{NUM_CLIENTE}", String.valueOf(numeroCliente));
		}
		return querys;
	}

	public static String actualizarUsoCFDI(List<Querys> listaQuerys, String cdo, Usuario infoUsu, String serie,
			String folio, String numeroCliente) {
		Connection connBD = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		connBD = ConexionBD.AbrirConexionBDD(cdo);	
		String respuesta = "";
		
		try {
			
			String[] querys = new String[25];	
			querys = Cls_Querys.LimpiaListaQuerys(querys);	
			querys = Cls_Querys.ObtieneQuerys(10, listaQuerys, querys);
			querys = inicializaQueryNumero9(querys, cdo,serie,folio,numeroCliente);
			pstm = connBD.prepareStatement("{call " + cdo.toUpperCase()+".usp_EXECUTE_QUERY(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			rs=  Cls_Querys.EjecutarQuery(querys[0], querys[1],querys[2], querys[3], querys[4], querys[5], querys[6],
														 querys[7], querys[8], querys[9],querys[10], querys[11], querys[12], querys[13], 
														 querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], 
														 querys[21], querys[22], querys[23], querys[24], "",pstm, connBD,infoUsu);
			
			
			Cls_Querys.ImprimeQuerysConsola(querys,false,"Query 2");
			if(rs != null)
			{
				while(rs.next())
				{
					respuesta=rs.getString("uso_cfdi");
				}
			}
			InsertaLogMantenientoCFDI.insertarLog( cdo,"P-175 Entra a actualizarUsoCFDI  de la  serie: "+serie+" folio: "+folio+" usuario: "+(infoUsu.getCveUsuario()),serie, folio);
			//InsertaLogEncuestas.insertarLog(new LogEncuestas(),cdo,cdo,"Entrada a consultar Evaluaciones Usuario: "+infoUsu.getCveUsuario()+" qry{"+Cls_Querys.regresaQuerys(querys,false)+"}",infoUsu.getCveUsuario());
		}catch(Exception ex)
		{
			InsertaLogMantenientoCFDI.insertarLog( cdo,"P-175 Error al actualizarUsoCFDI GestorCFDI.actualizarUsoCFDI: " + ex,serie,folio);
			//System.out.println("Error en el metodo consultaCFDI de la clase GestorCFDI");
			//InsertaLogEncuestas.insertarLog(new LogEncuestas(),cdo,cdo,"Error en el metodo ConsultaEvaluaciones de la clase GestorEvaluaciones. DETALLE: "+ex.getMessage().toString().replace("'", "")+" Usuario: "+infoUsu.getCveUsuario(),infoUsu.getCveUsuario());
		}
		finally {
			try {
				if(connBD != null) {
					connBD.close();
				}
				if(pstm != null) {
					pstm.close();
				}
			} catch (Exception e) {
				InsertaLogMantenientoCFDI.insertarLog( cdo,"P-175 ERROR al cerrar conexcion en GestorCFDI.actualizarUsoCFDI: " + e,serie,folio);
				//System.out.println("ERROR al cerrar conexcion en GestorCFDI.consultaCFDI: " + e);
			}
		}
		return respuesta;
	}

	public static String actualizarFormaPago(List<Querys> listaQuerys, String cdo, Usuario infoUsu, String serie,
			String folio, String numeroCliente) {
		Connection connBD = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		connBD = ConexionBD.AbrirConexionBDD(cdo);	
		String respuesta = "";
		
		try {
			
			String[] querys = new String[25];	
			querys = Cls_Querys.LimpiaListaQuerys(querys);	
			querys = Cls_Querys.ObtieneQuerys(11, listaQuerys, querys);
			querys = inicializaQueryNumero9(querys, cdo,serie,folio,numeroCliente);
			pstm = connBD.prepareStatement("{call " + cdo.toUpperCase()+".usp_EXECUTE_QUERY(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			rs=  Cls_Querys.EjecutarQuery(querys[0], querys[1],querys[2], querys[3], querys[4], querys[5], querys[6],
														 querys[7], querys[8], querys[9],querys[10], querys[11], querys[12], querys[13], 
														 querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], 
														 querys[21], querys[22], querys[23], querys[24], "",pstm, connBD,infoUsu);
			
			
			Cls_Querys.ImprimeQuerysConsola(querys,false,"Query 2");
			if(rs != null)
			{
				while(rs.next())
				{
					respuesta=rs.getString("forma_pago");
				}
			}
			InsertaLogMantenientoCFDI.insertarLog( cdo,"P-175 Entra a actualizarFormaPago de la  serie: "+serie+" folio: "+folio+" usuario: "+(infoUsu.getCveUsuario()),serie, folio);
			//InsertaLogEncuestas.insertarLog(new LogEncuestas(),cdo,cdo,"Entrada a consultar Evaluaciones Usuario: "+infoUsu.getCveUsuario()+" qry{"+Cls_Querys.regresaQuerys(querys,false)+"}",infoUsu.getCveUsuario());
		}catch(Exception ex)
		{
			InsertaLogMantenientoCFDI.insertarLog( cdo,"P-175 Error al actualizar forma de pago GestorCFDI.actualizarFormaPago: " + ex,serie,folio);
			//System.out.println("Error en el metodo consultaCFDI de la clase GestorCFDI");
			//InsertaLogEncuestas.insertarLog(new LogEncuestas(),cdo,cdo,"Error en el metodo ConsultaEvaluaciones de la clase GestorEvaluaciones. DETALLE: "+ex.getMessage().toString().replace("'", "")+" Usuario: "+infoUsu.getCveUsuario(),infoUsu.getCveUsuario());
		}
		finally {
			try {
				if(connBD != null) {
					connBD.close();
				}
				if(pstm != null) {
					pstm.close();
				}
			} catch (Exception e) {
				InsertaLogMantenientoCFDI.insertarLog( cdo,"P-175 ERROR al cerrar conexcion en GestorCFDI.actualizarFormaPago: " + e,serie,folio);
//				System.out.println("ERROR al cerrar conexcion en GestorCFDI.consultaCFDI: " + e);
			}
		}
		return respuesta;
	}

	public static String actualizarMetodoPago(List<Querys> listaQuerys, String cdo, Usuario infoUsu, String serie,
			String folio, String numeroCliente) {
		Connection connBD = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		connBD = ConexionBD.AbrirConexionBDD(cdo);	
		String respuesta = "";
		
		try {
			
			String[] querys = new String[25];	
			querys = Cls_Querys.LimpiaListaQuerys(querys);	
			querys = Cls_Querys.ObtieneQuerys(12, listaQuerys, querys);
			querys = inicializaQueryNumero9(querys, cdo,serie,folio,numeroCliente);
			pstm = connBD.prepareStatement("{call " + cdo.toUpperCase()+".usp_EXECUTE_QUERY(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			rs=  Cls_Querys.EjecutarQuery(querys[0], querys[1],querys[2], querys[3], querys[4], querys[5], querys[6],
														 querys[7], querys[8], querys[9],querys[10], querys[11], querys[12], querys[13], 
														 querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], 
														 querys[21], querys[22], querys[23], querys[24], "",pstm, connBD,infoUsu);
			
			
			Cls_Querys.ImprimeQuerysConsola(querys,false,"Query 2");
			if(rs != null)
			{
				while(rs.next())
				{
					respuesta=rs.getString("metodo_pago");
				}
			}
			InsertaLogMantenientoCFDI.insertarLog( cdo,"P-175 Entra a actualizar metodo de pago de la  serie: "+serie+" folio: "+folio+" usuario: "+(infoUsu.getCveUsuario()),serie, folio);
			//InsertaLogEncuestas.insertarLog(new LogEncuestas(),cdo,cdo,"Entrada a consultar Evaluaciones Usuario: "+infoUsu.getCveUsuario()+" qry{"+Cls_Querys.regresaQuerys(querys,false)+"}",infoUsu.getCveUsuario());
		}catch(Exception ex)
		{
			//System.out.println("Error en el metodo consultaCFDI de la clase GestorCFDI");
			InsertaLogMantenientoCFDI.insertarLog( cdo,"P-175 Error al consultar emisor GestorCFDI.actualizarMetodoPago: " + ex,serie,folio);
			//InsertaLogEncuestas.insertarLog(new LogEncuestas(),cdo,cdo,"Error en el metodo ConsultaEvaluaciones de la clase GestorEvaluaciones. DETALLE: "+ex.getMessage().toString().replace("'", "")+" Usuario: "+infoUsu.getCveUsuario(),infoUsu.getCveUsuario());
		}
		finally {
			try {
				if(connBD != null) {
					connBD.close();
				}
				if(pstm != null) {
					pstm.close();
				}
			} catch (Exception e) {
				InsertaLogMantenientoCFDI.insertarLog( cdo,"P-175 ERROR al cerrar conexcion en GestorCFDI.actualizarMetodoPago: " + e,serie,folio);
				//System.out.println("ERROR al cerrar conexcion en GestorCFDI.consultaCFDI: " + e);
			}
		}
		return respuesta;
	}

	public static List<String> guardarConceptos(List<Querys> listaQuerys, String cdo, Usuario infoUsu, String objetoImp, String baseTraslado, String importeTraslado, String impuestoTraslado, String tasaCuota, String tipoFactorTranslado, String baseRetencion, String importeRetencion, String impuestoRetencion, String tipoFactorRetencion, String tasaCuotaRetencion, String serie, String folio, String numRenglon, String cantidad, String descripcionConceptos, String valorUnitario, String importe, String descuento, String noIdentificacion, String unidad) {
		Connection connBD = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		connBD = ConexionBD.AbrirConexionBDD(cdo);	
		List<String> respuesta = new ArrayList<>();
		
		try {
			
			String[] querys = new String[25];	
			querys = Cls_Querys.LimpiaListaQuerys(querys);	
			querys = Cls_Querys.ObtieneQuerys(13, listaQuerys, querys);
			querys = inicializaQueryNumero13(querys, cdo,objetoImp,baseTraslado,importeTraslado,impuestoTraslado,tasaCuota,tipoFactorTranslado,baseRetencion,importeRetencion,impuestoRetencion,tipoFactorRetencion,tasaCuotaRetencion,serie, folio,numRenglon,cantidad,descripcionConceptos,valorUnitario,importe,descuento,noIdentificacion, unidad);
			pstm = connBD.prepareStatement("{call " + cdo.toUpperCase()+".usp_EXECUTE_QUERY(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			rs=  Cls_Querys.EjecutarQuery(querys[0], querys[1],querys[2], querys[3], querys[4], querys[5], querys[6],
														 querys[7], querys[8], querys[9],querys[10], querys[11], querys[12], querys[13], 
														 querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], 
														 querys[21], querys[22], querys[23], querys[24], "",pstm, connBD,infoUsu);
			
			
			Cls_Querys.ImprimeQuerysConsola(querys,false,"Query 2");

			InsertaLogMantenientoCFDI.insertarLog( cdo,"P-175 Entra a guardarConcepto de la  serie: "+serie+" folio: "+folio+" usuario: "+(infoUsu.getCveUsuario()),serie, folio);
			//InsertaLogEncuestas.insertarLog(new LogEncuestas(),cdo,cdo,"Entrada a consultar Evaluaciones Usuario: "+infoUsu.getCveUsuario()+" qry{"+Cls_Querys.regresaQuerys(querys,false)+"}",infoUsu.getCveUsuario());
		}catch(Exception ex)
		{
			InsertaLogMantenientoCFDI.insertarLog( cdo,"P-175 Error al guardarConcepto GestorCFDI.guardarConcepto: " + ex,serie,folio);
		//	System.out.println("Error en el metodo consultaCFDI de la clase GestorCFDI"+ex);
			//InsertaLogEncuestas.insertarLog(new LogEncuestas(),cdo,cdo,"Error en el metodo ConsultaEvaluaciones de la clase GestorEvaluaciones. DETALLE: "+ex.getMessage().toString().replace("'", "")+" Usuario: "+infoUsu.getCveUsuario(),infoUsu.getCveUsuario());
		}
		finally {
			try {
				if(connBD != null) {
					connBD.close();
				}
				if(pstm != null) {
					pstm.close();
				}
			} catch (Exception e) {
				InsertaLogMantenientoCFDI.insertarLog( cdo,"P-175 ERROR al cerrar conexcion en GestorCFDI.guardarConcepto: " + e,serie,folio);
	//			System.out.println("ERROR al cerrar conexcion en GestorCFDI.consultaCFDI: " + e);
			}
		}
		return respuesta;
	}

	private static String[] inicializaQueryNumero13(String[] querys, String cdo, String objetoImp, 
			String baseTraslado, String importeTraslado, String impuestoTraslado, 
			String tasaCuota, String tipoFactorTranslado, String baseRetencion, 
			String importeRetencion, String impuestoRetencion, String tipoFactorRetencion, 
			String tasaCuotaRetencion, String serie, String folio, String numRenglon, 
			String cantidad, String descripcionConceptos, String valorUnitario, 
			String importe, String descuento, String noIdentificacion, String unidad) {
		for (int i=0;i <querys.length; i++)
		{	
			querys[i]=querys[i].replace("{UNIDAD}", String.valueOf(unidad));
			querys[i]=querys[i].replace("{NO_IDENTIFICACION}", String.valueOf(noIdentificacion));
			querys[i]=querys[i].replace("{SERIE}", String.valueOf(serie));
			querys[i]=querys[i].replace("{FOLIO}", String.valueOf(folio));
			querys[i]=querys[i].replace("{NUM_RENGLON}", String.valueOf(numRenglon));
			querys[i]=querys[i].replace("{CANTIDAD}", String.valueOf(cantidad));
			querys[i]=querys[i].replace("{DESCRIPCION}", String.valueOf(descripcionConceptos));
			querys[i]=querys[i].replace("{VALOR}", String.valueOf(valorUnitario));
			querys[i]=querys[i].replace("{IMPORTE}", String.valueOf(importe));
			querys[i]=querys[i].replace("{DESCUENTO}", String.valueOf(descuento));
			querys[i]=querys[i].replace("{OBJETO}", String.valueOf(objetoImp));
			querys[i]=querys[i].replace("{BASE_TRASLADO}", String.valueOf(baseTraslado));
			querys[i]=querys[i].replace("{IMP_TRASLADO}", String.valueOf(importeTraslado));
			querys[i]=querys[i].replace("{IMPU_TRASLADO}", String.valueOf(impuestoTraslado));
			querys[i]=querys[i].replace("{TASA_CUOTA}", String.valueOf(tasaCuota));
			querys[i]=querys[i].replace("{FACTOR_TRASLADO}", String.valueOf(tipoFactorTranslado));
			querys[i]=querys[i].replace("{BASE_RETENCION}", String.valueOf(baseRetencion));
			querys[i]=querys[i].replace("{IMP_RETENCION}", String.valueOf(importeRetencion));
			querys[i]=querys[i].replace("{FACTOR_RETENCION}", String.valueOf(tipoFactorRetencion));
			querys[i]=querys[i].replace("{CUOTA_RETENCION}", String.valueOf(tasaCuotaRetencion));
			querys[i]=querys[i].replace("{IMPU_RETENCION}", String.valueOf(impuestoRetencion));
		}
		return querys;
	}

	public static String guardarCampos(List<Querys> listaQuerys, String cdo, Usuario infoUsu, String serie,
			String folio, String moneda, String tipoCambio, String exportacion, String observaciones, String ode, String serie2, String folio2) {
		Connection connBD = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		connBD = ConexionBD.AbrirConexionBDD(cdo);	
		String  respuesta = "false";
		
		try {
			
			String[] querys = new String[25];	
			querys = Cls_Querys.LimpiaListaQuerys(querys);	
			querys = Cls_Querys.ObtieneQuerys(14, listaQuerys, querys);
			querys = inicializaQueryNumero14(querys, cdo,serie,folio,moneda,tipoCambio,exportacion,observaciones,ode,serie2,folio2);
			pstm = connBD.prepareStatement("{call " + cdo.toUpperCase()+".usp_EXECUTE_QUERY(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			rs=  Cls_Querys.EjecutarQuery(querys[0], querys[1],querys[2], querys[3], querys[4], querys[5], querys[6],
														 querys[7], querys[8], querys[9],querys[10], querys[11], querys[12], querys[13], 
														 querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], 
														 querys[21], querys[22], querys[23], querys[24], "",pstm, connBD,infoUsu);
			
			
			Cls_Querys.ImprimeQuerysConsola(querys,false,"Query 2");
			respuesta="true";
			InsertaLogMantenientoCFDI.insertarLog( cdo,"P-175 Entra a guardarCampos de la  serie: "+serie+" folio: "+folio+" usuario: "+(infoUsu.getCveUsuario()),serie, folio);
			//InsertaLogEncuestas.insertarLog(new LogEncuestas(),cdo,cdo,"Entrada a consultar Evaluaciones Usuario: "+infoUsu.getCveUsuario()+" qry{"+Cls_Querys.regresaQuerys(querys,false)+"}",infoUsu.getCveUsuario());
		}catch(Exception ex)
		{
			InsertaLogMantenientoCFDI.insertarLog( cdo,"P-175 Error al consultar emisor GestorCFDI.guardarCampos: " + ex,serie,folio);
			//System.out.println("Error en el metodo consultaCFDI de la clase GestorCFDI"+ex);
			//InsertaLogEncuestas.insertarLog(new LogEncuestas(),cdo,cdo,"Error en el metodo ConsultaEvaluaciones de la clase GestorEvaluaciones. DETALLE: "+ex.getMessage().toString().replace("'", "")+" Usuario: "+infoUsu.getCveUsuario(),infoUsu.getCveUsuario());
		}
		finally {
			try {
				if(connBD != null) {
					connBD.close();
				}
				if(pstm != null) {
					pstm.close();
				}
			} catch (Exception e) {
				InsertaLogMantenientoCFDI.insertarLog( cdo,"P-175 ERROR al cerrar conexcion en GestorCFDI.guardarCampos: " + e,serie,folio);
				//System.out.println("ERROR al cerrar conexcion en GestorCFDI.consultaCFDI: " + e);
			}
		}
		return respuesta;
	}

	private static String[] inicializaQueryNumero14(String[] querys, String cdo, String serie, String folio,
			String moneda, String tipoCambio, String exportacion, String observaciones, String ode, String serie2, String folio2) {
		for (int i=0;i <querys.length; i++)
		{	
			querys[i]=querys[i].replace("{SERIE}", String.valueOf(serie));
			querys[i]=querys[i].replace("{FOLIO}", String.valueOf(folio));
			querys[i]=querys[i].replace("{MONEDA}", String.valueOf(moneda));
			querys[i]=querys[i].replace("{TIPO_CAMBIO}", String.valueOf(tipoCambio));
			querys[i]=querys[i].replace("{EXPORTACION}", String.valueOf(exportacion));
			querys[i]=querys[i].replace("{OBSERVACIONES}", String.valueOf(observaciones));
			querys[i]=querys[i].replace("{ODE}", String.valueOf(ode));
			querys[i]=querys[i].replace("{SERIE2}", String.valueOf(serie2));
			querys[i]=querys[i].replace("{FOLIO2}", String.valueOf(folio2));
		}
		return querys;
	}

	public static String actualizaRfcReceptor(List<Querys> listaQuerys, String cdo, Usuario infoUsu, String serie,
			String folio, String numeroCliente) {
		Connection connBD = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		connBD = ConexionBD.AbrirConexionBDD(cdo);	
		String respuesta = "";
		
		try {
			
			String[] querys = new String[25];	
			querys = Cls_Querys.LimpiaListaQuerys(querys);	
			querys = Cls_Querys.ObtieneQuerys(15, listaQuerys, querys);
			querys = inicializaQueryNumero9(querys, cdo,serie,folio,numeroCliente);
			pstm = connBD.prepareStatement("{call " + cdo.toUpperCase()+".usp_EXECUTE_QUERY(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			rs=  Cls_Querys.EjecutarQuery(querys[0], querys[1],querys[2], querys[3], querys[4], querys[5], querys[6],
														 querys[7], querys[8], querys[9],querys[10], querys[11], querys[12], querys[13], 
														 querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], 
														 querys[21], querys[22], querys[23], querys[24], "",pstm, connBD,infoUsu);
			
			
			Cls_Querys.ImprimeQuerysConsola(querys,false,"Query 2");
			if(rs != null)
			{
				while(rs.next())
				{
					respuesta=rs.getString("rfc");
				}
			}
			InsertaLogMantenientoCFDI.insertarLog( cdo,"P-175 Entra a actualizaRfcReceptor de la  serie: "+serie+" folio: "+folio+" usuario: "+(infoUsu.getCveUsuario()),serie, folio);
			//InsertaLogEncuestas.insertarLog(new LogEncuestas(),cdo,cdo,"Entrada a consultar Evaluaciones Usuario: "+infoUsu.getCveUsuario()+" qry{"+Cls_Querys.regresaQuerys(querys,false)+"}",infoUsu.getCveUsuario());
		}catch(Exception ex)
		{
			InsertaLogMantenientoCFDI.insertarLog( cdo,"P-175 Error al consultar emisor GestorCFDI.actualizaRfcReceptor: " + ex,serie,folio);
			//System.out.println("Error en el metodo consultaCFDI de la clase GestorCFDI");
			//InsertaLogEncuestas.insertarLog(new LogEncuestas(),cdo,cdo,"Error en el metodo ConsultaEvaluaciones de la clase GestorEvaluaciones. DETALLE: "+ex.getMessage().toString().replace("'", "")+" Usuario: "+infoUsu.getCveUsuario(),infoUsu.getCveUsuario());
		}
		finally {
			try {
				if(connBD != null) {
					connBD.close();
				}
				if(pstm != null) {
					pstm.close();
				}
			} catch (Exception e) {
				InsertaLogMantenientoCFDI.insertarLog( cdo,"P-175 ERROR al cerrar conexcion en GestorCFDI.actualizaRfcReceptor: " + e,serie,folio);
				//System.out.println("ERROR al cerrar conexcion en GestorCFDI.consultaCFDI: " + e);
			}
		}
		return respuesta;
	}

	public static boolean verificaProdServ(List<Querys> listaQuerys, String cdo, Usuario infoUsu,
			String claveProdServ,String serie,String folio,String noIdentificacion) {
		Connection connBD = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		connBD = ConexionBD.AbrirConexionBDD(cdo);	
		boolean respuesta = false;
		
		try {
			
			String[] querys = new String[25];	
			querys = Cls_Querys.LimpiaListaQuerys(querys);	
			querys = Cls_Querys.ObtieneQuerys(17, listaQuerys, querys);
			querys = inicializaQueryNumero17(querys, cdo,claveProdServ);
			pstm = connBD.prepareStatement("{call " + cdo.toUpperCase()+".usp_EXECUTE_QUERY(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			rs=  Cls_Querys.EjecutarQuery(querys[0], querys[1],querys[2], querys[3], querys[4], querys[5], querys[6],
														 querys[7], querys[8], querys[9],querys[10], querys[11], querys[12], querys[13], 
														 querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], 
														 querys[21], querys[22], querys[23], querys[24], "",pstm, connBD,infoUsu);
			
			
			Cls_Querys.ImprimeQuerysConsola(querys,false,"Query 2");
			if(rs != null)
			{
				while(rs.next())
				{
					if(rs.getString("claveProdServ").equalsIgnoreCase(claveProdServ)) {
						actualizaClaveProd(listaQuerys,cdo,infoUsu,claveProdServ,serie,folio,noIdentificacion);
						respuesta=true;
					}
				}
			}
			InsertaLogMantenientoCFDI.insertarLog( cdo,"P-175 Entra a verificaProdServ  de la  serie: "+serie+" folio: "+folio+" usuario: "+(infoUsu.getCveUsuario()),serie, folio);
			//InsertaLogEncuestas.insertarLog(new LogEncuestas(),cdo,cdo,"Entrada a consultar Evaluaciones Usuario: "+infoUsu.getCveUsuario()+" qry{"+Cls_Querys.regresaQuerys(querys,false)+"}",infoUsu.getCveUsuario());
		}catch(Exception ex)
		{
			InsertaLogMantenientoCFDI.insertarLog( cdo,"P-175 Error al consultar emisor GestorCFDI.verificaProdServ: " + ex,serie,folio);
			//System.out.println("Error en el metodo consultaCFDI de la clase GestorCFDI");
			//InsertaLogEncuestas.insertarLog(new LogEncuestas(),cdo,cdo,"Error en el metodo ConsultaEvaluaciones de la clase GestorEvaluaciones. DETALLE: "+ex.getMessage().toString().replace("'", "")+" Usuario: "+infoUsu.getCveUsuario(),infoUsu.getCveUsuario());
		}
		finally {
			try {
				if(connBD != null) {
					connBD.close();
				}
				if(pstm != null) {
					pstm.close();
				}
			} catch (Exception e) {
				InsertaLogMantenientoCFDI.insertarLog( cdo,"P-175 ERROR al cerrar conexcion en GestorCFDI.verificaProdServ: " + e,serie,folio);
				//System.out.println("ERROR al cerrar conexcion en GestorCFDI.consultaCFDI: " + e);
			}
		}
		return respuesta;
	}

	private static void actualizaClaveProd(List<Querys> listaQuerys, String cdo, Usuario infoUsu,
			String claveProdServ, String serie, String folio,String noIdentificacion) {
		Connection connBD = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		connBD = ConexionBD.AbrirConexionBDD(cdo);	
	
		
		try {
			
			String[] querys = new String[25];	
			querys = Cls_Querys.LimpiaListaQuerys(querys);	
			querys = Cls_Querys.ObtieneQuerys(18, listaQuerys, querys);
			querys = inicializaQueryNumero18(querys, cdo,claveProdServ,serie,folio,noIdentificacion);
			pstm = connBD.prepareStatement("{call " + cdo.toUpperCase()+".usp_EXECUTE_QUERY(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			rs=  Cls_Querys.EjecutarQuery(querys[0], querys[1],querys[2], querys[3], querys[4], querys[5], querys[6],
														 querys[7], querys[8], querys[9],querys[10], querys[11], querys[12], querys[13], 
														 querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], 
														 querys[21], querys[22], querys[23], querys[24], "",pstm, connBD,infoUsu);
			
			
			Cls_Querys.ImprimeQuerysConsola(querys,false,"Query 2");
			InsertaLogMantenientoCFDI.insertarLog( cdo,"P-175 Entra a actualizaClaveProd  serie: "+serie+" folio: "+folio+" usuario: "+(infoUsu.getCveUsuario()),serie, folio);
			//InsertaLogEncuestas.insertarLog(new LogEncuestas(),cdo,cdo,"Entrada a consultar Evaluaciones Usuario: "+infoUsu.getCveUsuario()+" qry{"+Cls_Querys.regresaQuerys(querys,false)+"}",infoUsu.getCveUsuario());
		}catch(Exception ex)
		{
			InsertaLogMantenientoCFDI.insertarLog( cdo,"P-175 Error al consultar emisor GestorCFDI.actualizaClaveProd: " + ex,serie,folio);
		//	System.out.println("Error en el metodo consultaCFDI de la clase GestorCFDI");
			//InsertaLogEncuestas.insertarLog(new LogEncuestas(),cdo,cdo,"Error en el metodo ConsultaEvaluaciones de la clase GestorEvaluaciones. DETALLE: "+ex.getMessage().toString().replace("'", "")+" Usuario: "+infoUsu.getCveUsuario(),infoUsu.getCveUsuario());
		}
		finally {
			try {
				if(connBD != null) {
					connBD.close();
				}
				if(pstm != null) {
					pstm.close();
				}
			} catch (Exception e) {
				InsertaLogMantenientoCFDI.insertarLog( cdo,"P-175 ERROR al cerrar conexcion en GestorCFDI.actualizaClaveProd: " + e,serie,folio);
			//	System.out.println("ERROR al cerrar conexcion en GestorCFDI.consultaCFDI: " + e);
			}
		}
		
	}

	private static String[] inicializaQueryNumero18(String[] querys, String cdo, String claveProdServ, String serie,
			String folio, String noIdentificacion) {
		for (int i=0;i <querys.length; i++)
		{	
			querys[i]=querys[i].replace("{CLAVE}", String.valueOf(claveProdServ));
			querys[i]=querys[i].replace("{SERIE}", String.valueOf(serie));
			querys[i]=querys[i].replace("{FOLIO}", String.valueOf(folio));
			querys[i]=querys[i].replace("{NO_IDENTIFICACION}", String.valueOf(noIdentificacion));
		}
		return querys;
	}

	private static String[] inicializaQueryNumero17(String[] querys, String cdo, String claveProdServ) {
		for (int i=0;i <querys.length; i++)
		{	
			querys[i]=querys[i].replace("{CLAVE}", String.valueOf(claveProdServ));
		}
		return querys;
	}

	public static String consultaRfc(List<Querys> listaQuerys, String cdo, Usuario infoUsu, String numeroCliente,String serie,String folio) {
		Connection connBD = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		connBD = ConexionBD.AbrirConexionBDD(cdo);	
		String respuesta ="";
		
		try {
			
			String[] querys = new String[25];	
			querys = Cls_Querys.LimpiaListaQuerys(querys);	
			querys = Cls_Querys.ObtieneQuerys(20, listaQuerys, querys);
			querys = inicializaQueryNumero20(querys, cdo,numeroCliente);
			pstm = connBD.prepareStatement("{call " + cdo.toUpperCase()+".usp_EXECUTE_QUERY(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			rs=  Cls_Querys.EjecutarQuery(querys[0], querys[1],querys[2], querys[3], querys[4], querys[5], querys[6],
														 querys[7], querys[8], querys[9],querys[10], querys[11], querys[12], querys[13], 
														 querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], 
														 querys[21], querys[22], querys[23], querys[24], "",pstm, connBD,infoUsu);
			
			
			Cls_Querys.ImprimeQuerysConsola(querys,false,"Query 2");
			if(rs != null)
			{
				while(rs.next())
				{
					respuesta=rs.getString("rfc");
				}
			}
		//	InsertaLogMantenientoCFDI.insertarLog( cdo,"P-175 Entra a consultaRfc del cliente: "+numeroCliente+" usuario: "+(infoUsu.getCveUsuario()),serie, folio);
			//InsertaLogEncuestas.insertarLog(new LogEncuestas(),cdo,cdo,"Entrada a consultar Evaluaciones Usuario: "+infoUsu.getCveUsuario()+" qry{"+Cls_Querys.regresaQuerys(querys,false)+"}",infoUsu.getCveUsuario());
		}catch(Exception ex)
		{
			InsertaLogMantenientoCFDI.insertarLog( cdo,"P-175 Error al consultar emisor GestorCFDI.consultaRfc: " + ex,serie,folio);
		//	System.out.println("Error en el metodo consultaCFDI de la clase GestorCFDI"+ex);
			//InsertaLogEncuestas.insertarLog(new LogEncuestas(),cdo,cdo,"Error en el metodo ConsultaEvaluaciones de la clase GestorEvaluaciones. DETALLE: "+ex.getMessage().toString().replace("'", "")+" Usuario: "+infoUsu.getCveUsuario(),infoUsu.getCveUsuario());
		}
		finally {
			try {
				if(connBD != null) {
					connBD.close();
				}
				if(pstm != null) {
					pstm.close();
				}
			} catch (Exception e) {
				InsertaLogMantenientoCFDI.insertarLog( cdo,"P-175 ERROR al cerrar conexcion en GestorCFDI.consultaRfc: " + e,serie,folio);
			//	System.out.println("ERROR al cerrar conexcion en GestorCFDI.consultaCFDI: " + e);
			}
		}
		return respuesta;
	}

	private static String[] inicializaQueryNumero20(String[] querys, String cdo, String numeroCliente) {
		for (int i=0;i <querys.length; i++)
		{	
			querys[i]=querys[i].replace("{NUM_CLIENTE}", String.valueOf(numeroCliente));
		}
		return querys;
	}

	public static String actualizaReceptor(List<Querys> listaQuerys, String cdo, Usuario infoUsu, String serie,
			String folio, String numeroCliente, String domicilioFiscal, String etiquetaTransporte, String etiquetaRuta,
			String etiquetaCalle, String etiquetaNumExt, String etiquetaNumInt, String etiquetaColonia,
			String etiquetaCodigoPostal, String etiquetaMunicipio, String etiquetaEstado,
			String etiquetaPais, String etiquetaPedido, String etiquetaNumCli, String etiquetaAgente,
			String etiquetaCondCred, String etiquetaTipoFact, String etiquetaTipoCliente, String etiquetaTipoDocto,
			String etiquetaMail) {
		Connection connBD = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		connBD = ConexionBD.AbrirConexionBDD(cdo);	
		String respuesta = "";
		
		try {
			
			String[] querys = new String[25];	
			querys = Cls_Querys.LimpiaListaQuerys(querys);	
			querys = Cls_Querys.ObtieneQuerys(16, listaQuerys, querys);
			querys = inicializaQueryNumero16(querys, cdo,serie,folio,numeroCliente,domicilioFiscal,etiquetaTransporte,etiquetaRuta,etiquetaCalle,
					etiquetaNumExt,etiquetaNumInt,etiquetaColonia,etiquetaCodigoPostal,etiquetaMunicipio,etiquetaEstado,etiquetaPais,etiquetaPedido,
					etiquetaNumCli,etiquetaAgente,etiquetaCondCred,etiquetaTipoFact,etiquetaTipoCliente,etiquetaTipoDocto,etiquetaMail);
			pstm = connBD.prepareStatement("{call " + cdo.toUpperCase()+".usp_EXECUTE_QUERY(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			rs=  Cls_Querys.EjecutarQuery(querys[0], querys[1],querys[2], querys[3], querys[4], querys[5], querys[6],
														 querys[7], querys[8], querys[9],querys[10], querys[11], querys[12], querys[13], 
														 querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], 
														 querys[21], querys[22], querys[23], querys[24], "",pstm, connBD,infoUsu);
			
			
			Cls_Querys.ImprimeQuerysConsola(querys,false,"Query 2");
			respuesta="true";
			//InsertaLogMantenientoCFDI.insertarLog( cdo,"P-175 Entra a actualizaReceptor de la  serie: "+serie+" folio: "+folio+" usuario: "+(infoUsu.getCveUsuario()),serie, folio);
			//InsertaLogEncuestas.insertarLog(new LogEncuestas(),cdo,cdo,"Entrada a consultar Evaluaciones Usuario: "+infoUsu.getCveUsuario()+" qry{"+Cls_Querys.regresaQuerys(querys,false)+"}",infoUsu.getCveUsuario());
		}catch(Exception ex)
		{
			InsertaLogMantenientoCFDI.insertarLog( cdo,"P-175 Error al consultar emisor GestorCFDI.actualizaReceptor: " + ex,serie,folio);
			//System.out.println("Error en el metodo consultaCFDI de la clase GestorCFDI");
			//InsertaLogEncuestas.insertarLog(new LogEncuestas(),cdo,cdo,"Error en el metodo ConsultaEvaluaciones de la clase GestorEvaluaciones. DETALLE: "+ex.getMessage().toString().replace("'", "")+" Usuario: "+infoUsu.getCveUsuario(),infoUsu.getCveUsuario());
		}
		finally {
			try {
				if(connBD != null) {
					connBD.close();
				}
				if(pstm != null) {
					pstm.close();
				}
			} catch (Exception e) {
				InsertaLogMantenientoCFDI.insertarLog( cdo,"P-175 ERROR al cerrar conexcion en GestorCFDI.actualizaReceptor: " + e,serie,folio);
			//	System.out.println("ERROR al cerrar conexcion en GestorCFDI.consultaCFDI: " + e);
			}
		}
		return respuesta;
	}

	private static String[] inicializaQueryNumero16(String[] querys, String cdo, String serie, String folio,
			String numeroCliente, String domicilioFiscal, String etiquetaTransporte, String etiquetaRuta,
			String etiquetaCalle, String etiquetaNumExt, String etiquetaNumInt, String etiquetaColonia,
			String etiquetaCodigoPostal, String etiquetaMunicipio, String etiquetaEstado,
			String etiquetaPais, String etiquetaPedido, String etiquetaNumCli, String etiquetaAgente,
			String etiquetaCondCred, String etiquetaTipoFact, String etiquetaTipoCliente, String etiquetaTipoDocto,
			String etiquetaMail) {
		for (int i=0;i <querys.length; i++)
		{	
			querys[i]=querys[i].replace("{SERIE}", String.valueOf(serie));
			querys[i]=querys[i].replace("{FOLIO}", String.valueOf(folio));
			querys[i]=querys[i].replace("{NUM_CLIENTE}", String.valueOf(numeroCliente));
			querys[i]=querys[i].replace("{EMAIL}", String.valueOf(etiquetaMail));
			querys[i]=querys[i].replace("{DOMICILIO}", String.valueOf(domicilioFiscal));
			querys[i]=querys[i].replace("{TRASPORTE}", String.valueOf(etiquetaTransporte));
			querys[i]=querys[i].replace("{RUTA}", String.valueOf(etiquetaRuta));
			querys[i]=querys[i].replace("{CALLE}", String.valueOf(etiquetaCalle));
			querys[i]=querys[i].replace("{NUM_EXT}", String.valueOf(etiquetaNumExt));
			querys[i]=querys[i].replace("{NUM_INT}", String.valueOf(etiquetaNumInt));
			querys[i]=querys[i].replace("{COLONIA}", String.valueOf(etiquetaColonia));
			querys[i]=querys[i].replace("{CP}", String.valueOf(etiquetaCodigoPostal));
			querys[i]=querys[i].replace("{MUNICIPIO}", String.valueOf(etiquetaMunicipio));
			querys[i]=querys[i].replace("{ESTADO}", String.valueOf(etiquetaEstado));
			querys[i]=querys[i].replace("{PAIS}", String.valueOf(etiquetaPais));
			querys[i]=querys[i].replace("{PEDIDO}", String.valueOf(etiquetaPedido));
			querys[i]=querys[i].replace("{NUM_CLI}", String.valueOf(etiquetaNumCli));
			querys[i]=querys[i].replace("{AGENTE}", String.valueOf(etiquetaAgente));
			querys[i]=querys[i].replace("{COND_CREDITO}", String.valueOf(etiquetaCondCred));
			querys[i]=querys[i].replace("{TIPO_FACT}", String.valueOf(etiquetaTipoFact));
			querys[i]=querys[i].replace("{TIPO_CLIENTE}", String.valueOf(etiquetaTipoCliente));
			querys[i]=querys[i].replace("{TIPO_DOCTO}", String.valueOf(etiquetaTipoDocto));
		}
		return querys;
	}

	public static String consultaImpresora(List<Querys> listaQuerys, String cdo, Usuario infoUsu, String serie,String folio) {
		Connection connBD = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		connBD = ConexionBD.AbrirConexionBDD(cdo);	
		String respuesta = "";
		
		try {
			
			String[] querys = new String[25];	
			querys = Cls_Querys.LimpiaListaQuerys(querys);	
			querys = Cls_Querys.ObtieneQuerys(21, listaQuerys, querys);
			querys = inicializaQueryNumero21(querys, cdo,serie);
			pstm = connBD.prepareStatement("{call " + cdo.toUpperCase()+".usp_EXECUTE_QUERY(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			rs=  Cls_Querys.EjecutarQuery(querys[0], querys[1],querys[2], querys[3], querys[4], querys[5], querys[6],
														 querys[7], querys[8], querys[9],querys[10], querys[11], querys[12], querys[13], 
														 querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], 
														 querys[21], querys[22], querys[23], querys[24], "",pstm, connBD,infoUsu);
			
			
			Cls_Querys.ImprimeQuerysConsola(querys,false,"Query 2");
			//respuesta="true";
			if(rs != null)
			{
				while(rs.next())
				{
					respuesta=rs.getString("impresora");
				}
			}
			//InsertaLogMantenientoCFDI.insertarLog( cdo,"P-175 Entra a consultaImpresora de la  serie: "+serie+" usuario: "+(infoUsu.getCveUsuario()),serie, folio);
			//InsertaLogEncuestas.insertarLog(new LogEncuestas(),cdo,cdo,"Entrada a consultar Evaluaciones Usuario: "+infoUsu.getCveUsuario()+" qry{"+Cls_Querys.regresaQuerys(querys,false)+"}",infoUsu.getCveUsuario());
		}catch(Exception ex)
		{
			InsertaLogMantenientoCFDI.insertarLog( cdo,"P-175 Error al consultar emisor GestorCFDI.consultaImpresora: " + ex,serie, folio);
			//System.out.println("Error en el metodo consultaCFDI de la clase GestorCFDI");
			//InsertaLogEncuestas.insertarLog(new LogEncuestas(),cdo,cdo,"Error en el metodo ConsultaEvaluaciones de la clase GestorEvaluaciones. DETALLE: "+ex.getMessage().toString().replace("'", "")+" Usuario: "+infoUsu.getCveUsuario(),infoUsu.getCveUsuario());
		}
		finally {
			try {
				if(connBD != null) {
					connBD.close();
				}
				if(pstm != null) {
					pstm.close();
				}
			} catch (Exception e) {
				InsertaLogMantenientoCFDI.insertarLog( cdo,"P-175 ERROR al cerrar conexcion en GestorCFDI.consultaImpresora: " + e, serie, folio);
				//System.out.println("ERROR al cerrar conexcion en GestorCFDI.consultaCFDI: " + e);
			}
		}
		return respuesta;
	}

	private static String[] inicializaQueryNumero21(String[] querys, String cdo, String serie) {
		for (int i=0;i <querys.length; i++)
		{	
			querys[i]=querys[i].replace("{SERIE}", String.valueOf(serie));
		}
		return querys;
	}

	public static List<CFDI> consultaFolio(List<Querys> listaQuerys, String cdo, Usuario infoUsu, String folio) {
		Connection connBD = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		connBD = ConexionBD.AbrirConexionBDD(cdo);	
		List<CFDI> ListCFDI = new ArrayList<>();
		
		try {
			
			String[] querys = new String[25];	
			querys = Cls_Querys.LimpiaListaQuerys(querys);	
			querys = Cls_Querys.ObtieneQuerys(22, listaQuerys, querys);
			querys = inicializaQueryNumero22(querys, cdo,folio);
			pstm = connBD.prepareStatement("{call " + cdo.toUpperCase()+".usp_EXECUTE_QUERY(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			rs=  Cls_Querys.EjecutarQuery(querys[0], querys[1],querys[2], querys[3], querys[4], querys[5], querys[6],
														 querys[7], querys[8], querys[9],querys[10], querys[11], querys[12], querys[13], 
														 querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], 
														 querys[21], querys[22], querys[23], querys[24], "",pstm, connBD,infoUsu);
			
			
			Cls_Querys.ImprimeQuerysConsola(querys,false,"Query 22");
			
			ListCFDI = llenaClaseCFDI(rs, infoUsu);	
			
			//InsertaLogMantenientoCFDI.insertarLog( cdo,"P-175 Entra a consultaFolio de la  usuario: "+(infoUsu.getCveUsuario())," ", folio);
		}catch(Exception ex)
		{
			//System.out.println("Error en el metodo consultaCFDI de la clase GestorCFDI");
			InsertaLogMantenientoCFDI.insertarLog( cdo,"P-175 Error en el metodo consultaFolio de la clase GestorCFDI error: "+ex," ","0");
			//InsertaLogEncuestas.insertarLog(new LogEncuestas(),cdo,cdo,"Error en el metodo ConsultaEvaluaciones de la clase GestorEvaluaciones. DETALLE: "+ex.getMessage().toString().replace("'", "")+" Usuario: "+infoUsu.getCveUsuario(),infoUsu.getCveUsuario());
		}
		finally {
			try {
				if(connBD != null) {
					connBD.close();
				}
				if(pstm != null) {
					pstm.close();
				}
			} catch (Exception e) {
				InsertaLogMantenientoCFDI.insertarLog( cdo,"P-175 ERROR al cerrar conexcion en GestorCFDI.consultaFolio: " + e," ","0");
			//	System.out.println("ERROR al cerrar conexcion en GestorCFDI.consultaCFDI: " + e);
			}
		}
		return ListCFDI;
	}

	private static String[] inicializaQueryNumero22(String[] querys, String cdo, String folio) {
		for (int i=0;i <querys.length; i++)
		{	
			querys[i]=querys[i].replace("{FOLIO}", String.valueOf(folio));
		}
		return querys;
	}

	public static List<Cliente> consultaCliente(List<Querys> listaQuerys, String cdo, Usuario infoUsu,
			String numCliente) {
		Connection connBD = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		connBD = ConexionBD.AbrirConexionBDD(cdo);	
		List<Cliente> ListCFDI = new ArrayList<>();
		
		try {
			
			String[] querys = new String[25];	
			querys = Cls_Querys.LimpiaListaQuerys(querys);	
			querys = Cls_Querys.ObtieneQuerys(23, listaQuerys, querys);
			querys = inicializaQueryNumero23(querys, cdo,numCliente);
			pstm = connBD.prepareStatement("{call " + cdo.toUpperCase()+".usp_EXECUTE_QUERY(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			rs=  Cls_Querys.EjecutarQuery(querys[0], querys[1],querys[2], querys[3], querys[4], querys[5], querys[6],
														 querys[7], querys[8], querys[9],querys[10], querys[11], querys[12], querys[13], 
														 querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], 
														 querys[21], querys[22], querys[23], querys[24], "",pstm, connBD,infoUsu);
			
			
			Cls_Querys.ImprimeQuerysConsola(querys,false,"Query 22");
			
			ListCFDI = llenaClaseCliente(rs, infoUsu);	
			
			//InsertaLogMantenientoCFDI.insertarLog( cdo,"P-175 Entra a consultaFolio de la  usuario: "+(infoUsu.getCveUsuario())," ", folio);
		}catch(Exception ex)
		{
			//System.out.println("Error en el metodo consultaCFDI de la clase GestorCFDI");
			InsertaLogMantenientoCFDI.insertarLog( cdo,"P-175 Error en el metodo consultaFolio de la clase GestorCFDI error: "+ex," ","0");
			//InsertaLogEncuestas.insertarLog(new LogEncuestas(),cdo,cdo,"Error en el metodo ConsultaEvaluaciones de la clase GestorEvaluaciones. DETALLE: "+ex.getMessage().toString().replace("'", "")+" Usuario: "+infoUsu.getCveUsuario(),infoUsu.getCveUsuario());
		}
		finally {
			try {
				if(connBD != null) {
					connBD.close();
				}
				if(pstm != null) {
					pstm.close();
				}
			} catch (Exception e) {
				InsertaLogMantenientoCFDI.insertarLog( cdo,"P-175 ERROR al cerrar conexcion en GestorCFDI.consultaFolio: " + e," ","0");
			//	System.out.println("ERROR al cerrar conexcion en GestorCFDI.consultaCFDI: " + e);
			}
		}
		return ListCFDI;
	}

	private static List<Cliente> llenaClaseCliente(ResultSet rs, Usuario infoUsu) {
		List<Cliente> listCliente = new ArrayList<>();
		try
		{
			if(rs != null)
			{
				while(rs.next())
				{
					Cliente c =new Cliente();
					c.setDescFormaPago(rs.getString("DescFormaPago"));
					c.setDescMetodoPago(rs.getString("DescMetodoPago"));
					c.setDescRegimenFiscal(rs.getString("DescRegimefiscal"));
					c.setDescUsoCfdi(rs.getString("DescUsoCFDI"));
					c.setFormaPago(rs.getString("FormaPago"));
					c.setMetodoPago(rs.getString("MetodoPago"));
					c.setRegimenFiscal(rs.getString("Regimefiscal"));
					c.setRfc(rs.getString("rfc"));
					c.setUsoCfdi(rs.getString("UsoCFDI"));
					listCliente.add(c);
				}
			}			
		}
		catch(Exception ex)
		{
			//InsertaLogEncuestas.insertarLog(new LogEncuestas(),infoUsu.getUname(),infoUsu.getUname(),"Error en el metodo llenaClaseEvaluacion de la clase GestorEvaluaciones. DETALLE: "+ex.getMessage().toString().replace("'", "")+" Usuario: "+infoUsu.getCveUsuario(),infoUsu.getCveUsuario());
			//System.out.println("[Error: Obtener catalogo de sucursales,  Clase: GestorCFDI.llenaClaseCFDI,  Detalle: " + ex.getMessage().toString() +"]");
			 
		}
		return listCliente;
	}

	private static String[] inicializaQueryNumero23(String[] querys, String cdo, String numCliente) {
		for (int i=0;i <querys.length; i++)
		{	
			querys[i]=querys[i].replace("{NUM_CLIENTE}", String.valueOf(numCliente));
		}
		return querys;
	}

	public static List<CFDI> consultaCFDICliente(List<Querys> listaQuerys, String cdo, Usuario infoUsu,
			String numCliente,String opcion) {
		Connection connBD = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		connBD = ConexionBD.AbrirConexionBDD(cdo);	
		List<CFDI> ListCFDI = new ArrayList<>();
		
		try {
			
			String[] querys = new String[25];	
			querys = Cls_Querys.LimpiaListaQuerys(querys);	
			querys = Cls_Querys.ObtieneQuerys(25, listaQuerys, querys);
			querys = inicializaQueryNumero24(querys, cdo,numCliente,opcion);
			pstm = connBD.prepareStatement("{call " + cdo.toUpperCase()+".usp_EXECUTE_QUERY(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			rs=  Cls_Querys.EjecutarQuery(querys[0], querys[1],querys[2], querys[3], querys[4], querys[5], querys[6],
														 querys[7], querys[8], querys[9],querys[10], querys[11], querys[12], querys[13], 
														 querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], 
														 querys[21], querys[22], querys[23], querys[24], "",pstm, connBD,infoUsu);
			
			
			Cls_Querys.ImprimeQuerysConsola(querys,false,"Query 25");
			
			ListCFDI = llenaNotas(rs, infoUsu);	
			
			
		}catch(Exception ex)
		{
			System.out.println("Error en el metodo consultaCFDI de la clase GestorCFDI");
			InsertaLogMantenientoCFDI.insertarLog( cdo,"P-175 Error en el metodo consultarCFDI de la clase GestorCFDI error: "+ex," ","0");
			//InsertaLogEncuestas.insertarLog(new LogEncuestas(),cdo,cdo,"Error en el metodo ConsultaEvaluaciones de la clase GestorEvaluaciones. DETALLE: "+ex.getMessage().toString().replace("'", "")+" Usuario: "+infoUsu.getCveUsuario(),infoUsu.getCveUsuario());
		}
		finally {
			try {
				if(connBD != null) {
					connBD.close();
				}
				if(pstm != null) {
					pstm.close();
				}
			} catch (Exception e) {
				InsertaLogMantenientoCFDI.insertarLog( cdo,"P-175 ERROR al cerrar conexcion en GestorCFDI.consultaCFDI: " + e," ","0");
				System.out.println("ERROR al cerrar conexcion en GestorCFDI.consultaCFDI: " + e);
			}
		}
		return ListCFDI;
	}

	private static String[] inicializaQueryNumero24(String[] querys, String cdo, String numCliente, String opcion) {
		for(int i=0;i<querys.length;i++) {
			querys[i]=querys[i].replace("{NUM_CLIENTE}",numCliente);
			querys[i]=querys[i].replace("{TIPO_DOC}",opcion);
		}
		return querys;
	}

	public static List<String> consultaPendientes(List<Querys> listaQuerys, String cdo, Usuario infoUsu) {
		Connection connBD = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		connBD = ConexionBD.AbrirConexionBDD(cdo);	
		List<String> ListPendientes = new ArrayList<>();
		String f="0";
		String t="0";
		String tcdo="0";
		String n="0";
		String c="0";
		String p="0";
		try {
			for(int i=1;i<=6;i++) {
				List<CFDI> tmp=consultaCFDI( listaQuerys,  cdo, infoUsu, String.valueOf(i));
				if(tmp.size()>0) {
					switch(i) {
					case 1:
						f="1";
						break;
					case 2:
						t="1";
						break;
					case 3:
						tcdo="1";
						break;
					case 4:
						n="1";
						break;
					case 5:
						c="1";
						break;
					case 6:
						p="1";
						break;
					}
				}
			}
			ListPendientes.add(f);
			ListPendientes.add(t);
			ListPendientes.add(tcdo);
			ListPendientes.add(n);
			ListPendientes.add(c);
			ListPendientes.add(p);
		}catch(Exception ex)
		{
			System.out.println("Error en el metodo consultaCFDI de la clase GestorCFDI");
			InsertaLogMantenientoCFDI.insertarLog( cdo,"P-175 Error en el metodo consultarCFDI de la clase GestorCFDI error: "+ex," ","0");
			//InsertaLogEncuestas.insertarLog(new LogEncuestas(),cdo,cdo,"Error en el metodo ConsultaEvaluaciones de la clase GestorEvaluaciones. DETALLE: "+ex.getMessage().toString().replace("'", "")+" Usuario: "+infoUsu.getCveUsuario(),infoUsu.getCveUsuario());
		}
		return ListPendientes;
	}
}
