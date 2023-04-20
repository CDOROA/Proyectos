package cdo.Persistencia;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStream;

import  com.jcraft.jsch. * ;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;

import cdo.Datos.Concepto;
import cdo.Datos.Correos;
import cdo.Datos.DetallePendiente;
import cdo.Datos.Emisor;
import cdo.Datos.Estructura;
import cdo.Datos.FacConceptosEspeciales;
import cdo.Datos.FacPendiente;
import cdo.Datos.MetodoPagoYCuenta;
import cdo.Datos.Querys;
import cdo.Datos.Receptor;
import cdo.Util.ClsQuery;
import cdo.Util.Cls_Log;
import cdo.Util.ConexionBD;

public class clsFAC002 {
	//public static String cdo = "cdf"
	public String id_cdo ="";
	public static String correo = "daniel.calderon@corprama.com.mx";
	//public static double iva = 0.16;
	public static String usuFac = "ACUGAN";
	public static String ivaRetenido = "N";
	public static double IVA_CANTIDAD = 1.16;
	public static String ruta_shell = "/usr/acct/centdis/apsh/CDFA427D";
	public  String ruta_fac_esp_2 = "/HPP/interface/fact-esp/cimo/tmp/";
	public  String ruta_fac_esp = "/opt/Web/PDfsPrueba/";
										 
	
	public String Fac_Esp(String cdo) {
		switch(cdo) {
			case "cdf":
				id_cdo="07";
				ruta_fac_esp_2 = "/usr/acct/HPP/interface/fact-esp/cimo/tmp/";
				break;
			case "cd2":
				id_cdo="08";
				break;
			case "cdl":
				id_cdo="04";
			break;
			case "cdm":
				id_cdo="05";
			break;
		}
		
		String respuesta = "";
		List<Correos> listCorreos = consultaListaCorreos(cdo);
		List<FacPendiente> listFacP = consultaFACPendiente(cdo);
		//////////System.out.println("folioCnaje: "+listFacP.getFolio_canje());
		for(int i=0;i<listFacP.size();i++) {
		String folioCanje = listFacP.get(i).getFolio_canje();
		String num_cli = listFacP.get(i).getNum_cli();
		boolean actSts = actualizaSts(listFacP.get(i), cdo);
		if(actSts) {
			List<FacPendiente> listFacPe = consultaClienteDBM(listFacP.get(i), cdo);
			List<DetallePendiente> listDetP = consultaDetallePendiente(listFacP.get(i),cdo);
			int countListDetP = listDetP.size();
			double impNeto = 0.0;
			double impBruto = 0.0;
			double iva = 0.16;
			for (DetallePendiente listDetaPe : listDetP) {
				impNeto = (Double.parseDouble(listDetaPe.getCantidad().toString()) * Double.parseDouble(listDetaPe.getPrecio().toString())) + impNeto; 
			}
			
			System.out.println("impNeto: "+String.format("%.2f", impNeto));
			//////////System.out.println("1.1 impNeto: " + impNeto);
			//////////System.out.println("1.1 IVA "+iva); 
			iva = impNeto * iva;
			System.out.println("iva: "+String.format("%.2f", iva));
			//iva=Math.round(iva*100.0)/100.0;
			//////////System.out.println("1.2 IVA2: " + iva); 
            impBruto = impNeto + iva;
            System.out.println("impbruto: "+String.format("%.2f", impBruto));
           // impBruto=Math.round(impBruto*100.0)/100.0;
			List<Concepto> listConc = consultaDescripConcepto(listFacP.get(i),cdo);
			List<Receptor> listReceptor = consultaReceptor(listFacP.get(i),cdo);
			String folio = consultarFolio(listFacP.get(i),cdo);
			actualizarFolio(listFacP.get(i),cdo);
			List<Emisor> listEmisor = consultaEmisor(listFacP.get(i),cdo);
			List<Estructura> listEstructura = consultaDetalleEstructura(listFacP.get(i),cdo);
			String nombreArch = creaTextLocal(folio,folioCanje, listFacP.get(i).getNum_cli(), listReceptor.get(0).getAgte(), listReceptor.get(0).getCond_pago(),impNeto,iva,impBruto,cdo);
			//////////System.out.println("1.1 uname:  "+listFacP.getUname());
			String uname_tmp = listFacP.get(i).getUname();
			//////////System.out.println("1.2 agnte: "+listReceptor.get(0).getAgte());
			String agente = listReceptor.get(0).getAgte();
			boolean inserConcActual = insertarConcActualizados(countListDetP,listDetP,listConc, uname_tmp, folio, listFacP.get(i), listFacP.get(i), agente, cdo, listCorreos);
			if(inserConcActual) {
				String rsp = ejecutaShell(folio,folioCanje, nombreArch, listFacP, cdo);
				//String rsp="0";
				if(rsp.equals("0")) {
					String dtEstatus = consultarStsFin(folio, listFacP.get(i), cdo);
					if(dtEstatus.toString() != "T") {
						System.out.println("Informacion de factura no generada.");
					}
					List<FacConceptosEspeciales> lstFacConcEspeciales = consultarActConceptosEspeciales(listFacP.get(i),folio,cdo);
					boolean insertaRegisBD = insertaInformacionPedidos(lstFacConcEspeciales,folio,listFacP.get(i),listReceptor, agente,countListDetP,listDetP,cdo);
					if(insertaRegisBD) {
						List<MetodoPagoYCuenta> listMetyPago = consultaMetodoPagoNumeroCuenta(listFacP.get(i),cdo);
						boolean rspFinal = insertaEstructuraTXT(listEstructura,lstFacConcEspeciales,listMetyPago,listFacPe,listDetP,listEmisor,listReceptor, listConc, listFacP.get(i), cdo); 
						GestorSellado gs = new GestorSellado();
						for(FacConceptosEspeciales factura: lstFacConcEspeciales) {
							System.out.println("SERIE: "+factura.getSerie_cfd()+" FOLIO: "+factura.getFolio_cfd());
							gs.sellaFactura(cdo,factura.getSerie_cfd(), factura.getFolio_cfd());
						}
						if(rspFinal) {
							respuesta = "Exito";
						}else {
							respuesta = "Error al generar factura Acumule y Gane.";
						}
					}else {
						//////////System.out.println("Error al insertar información en la BD.");
						respuesta = "Error al insertar información en la BD.";
					}
				}else {
					//////////System.out.println("Error al ejecutar shell.");
					respuesta = "Error al ejecutar shell.";
				}
			}else {
				//////////System.out.println("Error al insertar conceptos Actualizados.");
				respuesta = "Error al insertar conceptos Actualizados.";
			}	
			
		}else{
			//////////System.out.println("Error al actualizar el Sts");
			respuesta = "Error al actualizar el Sts";
		}
		}
		return respuesta;
	}


	private List<Correos> consultaListaCorreos(String cdo) {
		Connection connBD = null;	
		PreparedStatement pstmt = null; 
		String[] querys = new String[25];
		String sntQry = ""; 
		List<Correos> listCorreos = new ArrayList<>();
		try {
			connBD = ConexionBD.AbrirConexionBD(cdo);
			List<Querys> listaQuerys = ClsQuery.ConsultaTablaQuerysBD(cdo, connBD);
			querys = ClsQuery.LimpiaListaQuerys(querys);
	        querys = ClsQuery.ObtieneQuerys(20,listaQuerys, querys);
	        querys = inicializaQuery20(querys,cdo);
	        sntQry = ClsQuery.obtieneSentenciaDeQrys(querys);
	        ClsQuery.ImprimeQuerysConsola(querys, false, "query 20 ");
	        
	        ResultSet rs = ClsQuery.EjecutarQuery(querys[0], querys[1], querys[2], querys[3], querys[4], querys[5], querys[6], querys[7], querys[8], querys[9], querys[10], querys[11], 
					querys[12], querys[13], querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], querys[21], querys[22], querys[23], querys[24], cdo, pstmt, connBD);
	 
			if(rs != null) {
				while(rs.next()) {
					Correos correo = new Correos();
					correo.setCorreo(rs.getString("email"));
					listCorreos.add(correo);
				}
			}	
		}catch(Exception e) {
			//////////System.out.println("Error al consultar correos: " + e.toString()); 
		}finally {
			try{if(connBD != null) {connBD.close();}}catch(Exception e) {}
			try{if(pstmt != null) {pstmt.close();}}catch(Exception e) {}
		}
		return listCorreos;
	}

	public static List<FacPendiente> consultaFACPendiente(String cdo) {
		Connection connBD = null;	
		Connection connBDM = null;
		PreparedStatement pstmt = null; 
		String[] querys = new String[25];
		List<FacPendiente> listFacP = new ArrayList<>();
		String sntQry = ""; 
		try {
			connBD = ConexionBD.AbrirConexionBD(cdo);
			List<Querys> listaQuerys = ClsQuery.ConsultaTablaQuerysBD(cdo, connBD);
			querys = ClsQuery.LimpiaListaQuerys(querys);
	        querys = ClsQuery.ObtieneQuerys(1,listaQuerys, querys);
	        querys = inicializaQuery1(querys,cdo);
	        sntQry = ClsQuery.obtieneSentenciaDeQrys(querys);
	        ClsQuery.ImprimeQuerysConsola(querys, false, "query 1 ");
	        	
			
	        connBDM = ConexionBD.AbrirConexionBDDBM();
	        ResultSet rs = ClsQuery.EjecutarQueryDBM(querys[0], querys[1], querys[2], querys[3], querys[4], querys[5], querys[6], querys[7], querys[8], querys[9], querys[10], querys[11], 
					querys[12], querys[13], querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], querys[21], querys[22], querys[23], querys[24], cdo, pstmt, connBDM);
	 
			if(rs != null) {
				while(rs.next()) {
					FacPendiente facP = new FacPendiente();
					facP.setUname(rs.getString("uname"));
					facP.setNum_cli(rs.getString("num_cli"));
					facP.setFolio_canje(rs.getString("folio_canje"));
					facP.setCve_concepto(rs.getString("cve_concepto"));
					
					//////////System.out.println("uname: " + facP.getUname());
					//////////System.out.println("num_cli: " + facP.getNum_cli());
					//////////System.out.println("folioCanje: " + facP.getFolio_canje());
					//////////System.out.println("cveConcepto: " + facP.getCve_concepto());
					listFacP.add(facP);
				}
			}
		Cls_Log.insertaLog(cdo, listFacP.get(0).getFolio_canje(), listFacP.get(0).getNum_cli(), "INICIALIZA CONSULTA FACTURAS PENDIENTE ACUMGANE QUERY 1 "+sntQry.replace("´","")+" . ");	
		//////////System.out.println(sntQry);
		}catch(Exception e) {
			//////////System.out.println("Error en consultaFACPendiente(): " + e.toString());
			Cls_Log.insertaLog(cdo, listFacP.get(0).getFolio_canje(), listFacP.get(0).getNum_cli(), "ERROR AL INICIALIZAR CONSULTA FACTURAS PENDIENTE ACUMGANE QUERY 1 "+sntQry.replace("´","")+" . ");
		}finally {
			try{if(connBD != null) {connBD.close();}}catch(Exception e) {}
			try{if(connBDM != null) {connBDM.close();}}catch(Exception e) {}
			try{if(pstmt != null) {pstmt.close();}}catch(Exception e) {}
		}
		return listFacP;
	}
	

	private boolean actualizaSts(FacPendiente facP, String cdo) {
		Connection connBD = null;	
		Connection connBDM = null;
		PreparedStatement pstmt = null; 
		String[] querys = new String[25];
		boolean actSts = false;
		String sntQry = ""; 
		try {
			connBD = ConexionBD.AbrirConexionBD(cdo);
			List<Querys> listaQuerys = ClsQuery.ConsultaTablaQuerysBD(cdo, connBD);
			querys = ClsQuery.LimpiaListaQuerys(querys);
	        querys = ClsQuery.ObtieneQuerys(6,listaQuerys, querys);
	        querys = inicializaQuery6(querys,cdo, facP);
	        sntQry = ClsQuery.obtieneSentenciaDeQrys(querys);
	        ClsQuery.ImprimeQuerysConsola(querys, false, "query 6 ");
	        	
			
	        connBDM = ConexionBD.AbrirConexionBDDBM();
	        ClsQuery.EjecutarQueryDBM(querys[0], querys[1], querys[2], querys[3], querys[4], querys[5], querys[6], querys[7], querys[8], querys[9], querys[10], querys[11], 
					querys[12], querys[13], querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], querys[21], querys[22], querys[23], querys[24], cdo, pstmt, connBDM);	 
	        actSts = true;
	        Cls_Log.insertaLog(cdo, facP.getFolio_canje(), facP.getNum_cli(), "ACTUALIZA ESTATUS ACUMGANE QUERY 6 "+sntQry.replace("´","")+" . ");
		}catch(Exception e) {
			actSts = false;
			//////////System.out.println("Error en actualizaSts(): " + e.toString());
			Cls_Log.insertaLog(cdo, facP.getFolio_canje(), facP.getNum_cli(), "ERROR AL ACTUALIZAR ESTATUS ACUMGANE QUERY 6 "+sntQry.replace("´","")+" . ");
		}finally {
			try{if(connBD != null) {connBD.close();}}catch(Exception e) {}
			try{if(connBDM != null) {connBDM.close();}}catch(Exception e) {}
			try{if(pstmt != null) {pstmt.close();}}catch(Exception e) {}
		}
		return actSts;
	}
	
	private List<FacPendiente> consultaClienteDBM(FacPendiente facP, String cdo) {
		Connection connBD = null;	
		Connection connBDM = null;
		PreparedStatement pstmt = null; 
		String[] querys = new String[25];
		List<FacPendiente> listFacPe = new ArrayList<>();
		String sntQry = "";
		try {
			connBD = ConexionBD.AbrirConexionBD(cdo);
			List<Querys> listaQuerys = ClsQuery.ConsultaTablaQuerysBD(cdo, connBD);
			querys = ClsQuery.LimpiaListaQuerys(querys);
	        querys = ClsQuery.ObtieneQuerys(15,listaQuerys, querys);
	        querys = inicializaQuery15(querys,cdo,facP);
	        sntQry = ClsQuery.obtieneSentenciaDeQrys(querys);
	        ClsQuery.ImprimeQuerysConsola(querys, false, "query 15 ");
	        	
			
	        connBDM = ConexionBD.AbrirConexionBDDBM();
	        ResultSet rs = ClsQuery.EjecutarQueryDBM(querys[0], querys[1], querys[2], querys[3], querys[4], querys[5], querys[6], querys[7], querys[8], querys[9], querys[10], querys[11], 
					querys[12], querys[13], querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], querys[21], querys[22], querys[23], querys[24], cdo, pstmt, connBDM);
	 
			if(rs != null) {
				while(rs.next()) {
					FacPendiente facPe = new FacPendiente();
					facPe.setNum_cli(rs.getString("num_cte"));
					facPe.setRfc(rs.getString("rfc"));
					facPe.setDesglosa_Iva(rs.getString("desglosa_iva"));
					
					//////////System.out.println("num_cli: " + facPe.getNum_cli());
					//////////System.out.println("rfc: " + facPe.getRfc());
					//////////System.out.println("desglosaIva: " + facPe.getDesglosa_Iva());
					listFacPe.add(facPe);
				}
			}
			Cls_Log.insertaLog(cdo, facP.getFolio_canje(), facP.getNum_cli(), "CONSULTA CLIENTE DBM ACUMGANE QUERY 15 "+sntQry.replace("´","")+" . ");	
		}catch(Exception e) {
			//////////System.out.println("Error en consultaClienteDBM(): " + e.toString());
			Cls_Log.insertaLog(cdo, facP.getFolio_canje(), facP.getNum_cli(), "ERROR AL CONSULTAR CLIENTE DBM ACUMGANE QUERY 15 "+sntQry.replace("´","")+" . ");
		}finally {
			try{if(connBD != null) {connBD.close();}}catch(Exception e) {}
			try{if(connBDM != null) {connBDM.close();}}catch(Exception e) {}
			try{if(pstmt != null) {pstmt.close();}}catch(Exception e) {}
		}
		return listFacPe;
	}
	

	private List<DetallePendiente> consultaDetallePendiente(FacPendiente facP, String cdo) {
		Connection connBD = null;	
		Connection connBDM = null;
		PreparedStatement pstmt = null; 
		String[] querys = new String[25];
		List<DetallePendiente> listDetP = new ArrayList<>();
		String sntQry = "";
		try {
			connBD = ConexionBD.AbrirConexionBD(cdo);
			List<Querys> listaQuerys = ClsQuery.ConsultaTablaQuerysBD(cdo, connBD);
			querys = ClsQuery.LimpiaListaQuerys(querys);
	        querys = ClsQuery.ObtieneQuerys(2,listaQuerys, querys);
	        querys = inicializaQuery6(querys,cdo,facP);
	        sntQry = ClsQuery.obtieneSentenciaDeQrys(querys);
	        ClsQuery.ImprimeQuerysConsola(querys, false, "query 2 ");
	        	
			
	        connBDM = ConexionBD.AbrirConexionBDDBM();
	        ResultSet rs = ClsQuery.EjecutarQueryDBM(querys[0], querys[1], querys[2], querys[3], querys[4], querys[5], querys[6], querys[7], querys[8], querys[9], querys[10], querys[11], 
					querys[12], querys[13], querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], querys[21], querys[22], querys[23], querys[24], cdo, pstmt, connBDM);
	 
			if(rs != null) {
				while(rs.next()) {
					DetallePendiente detPe = new DetallePendiente();
					detPe.setFolio_canje(rs.getString("folio_canje"));
					detPe.setId_articulo(rs.getString("id_articulo"));
					detPe.setArticulo(rs.getString("articulo"));
					detPe.setSerie(rs.getString("serie"));
					detPe.setMotor(rs.getString("motor"));
					detPe.setObservaciones(rs.getString("observaciones"));
					detPe.setSts(rs.getString("sts"));
					detPe.setCantidad(rs.getString("cantidad"));
					detPe.setPrecio(rs.getString("precio"));
					listDetP.add(detPe);
				}
			}
			Cls_Log.insertaLog(cdo, facP.getFolio_canje(), facP.getNum_cli(),"CONSULTA DETALLE PENDIENTE ACUMGANE QUERY 2 "+sntQry.replace("´","")+" . ");	
		}catch(Exception e) {
			//////////System.out.println("Error en consultaDetallePendiente(): " + e.toString());
			Cls_Log.insertaLog(cdo, facP.getFolio_canje(), facP.getNum_cli(), "ERROR AL CONSULTAR DETALLE PENDIENTE ACUMGANE QUERY 2 "+sntQry.replace("´","")+" . ");
		}finally {
			try{if(connBD != null) {connBD.close();}}catch(Exception e) {}
			try{if(connBDM != null) {connBDM.close();}}catch(Exception e) {}
			try{if(pstmt != null) {pstmt.close();}}catch(Exception e) {}
		}
		return listDetP;
	}

	private List<Concepto> consultaDescripConcepto(FacPendiente facP, String cdo) {
		Connection connBD = null;	
		PreparedStatement pstmt = null; 
		String[] querys = new String[25];
		List<Concepto> listConcepto = new ArrayList<>();
		String sntQry = "";
		try {
			connBD = ConexionBD.AbrirConexionBD(cdo);
			List<Querys> listaQuerys = ClsQuery.ConsultaTablaQuerysBD(cdo, connBD);
			querys = ClsQuery.LimpiaListaQuerys(querys);
	        querys = ClsQuery.ObtieneQuerys(14,listaQuerys, querys);
	        querys = inicializaQuery14(querys,cdo,facP,id_cdo); 
	        sntQry = ClsQuery.obtieneSentenciaDeQrys(querys);
	        ClsQuery.ImprimeQuerysConsola(querys, false, "query 14 ");
	        	
	        ResultSet rs = ClsQuery.EjecutarQuery(querys[0], querys[1], querys[2], querys[3], querys[4], querys[5], querys[6], querys[7], querys[8], querys[9], querys[10], querys[11], 
					querys[12], querys[13], querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], querys[21], querys[22], querys[23], querys[24], cdo, pstmt, connBD);
	 
			if(rs != null) {
				while(rs.next()) {
					Concepto conc = new Concepto();
					conc.setCve_concepto(rs.getString("cve_concepto"));
					conc.setDescripcion(rs.getString("descripcion"));
					conc.setC_ClaveProdServ(rs.getString("c_ClaveProdServ"));
					conc.setC_ClaveUnidad(rs.getString("c_ClaveUnidad"));
					conc.setUnidad(rs.getString("UNIDAD"));
					conc.setC_UsoCFDI(rs.getString("c_UsoCFDI"));
					listConcepto.add(conc);
				}
			}
			Cls_Log.insertaLog(cdo, facP.getFolio_canje(), facP.getNum_cli(), "CONSULTA DESCRIPCION CONCEPTO ACUMGANE QUERY 14 "+sntQry.replace("´","")+" . ");	
		}catch(Exception e) {
			//////////System.out.println("Error en consultaDescripConcepto(): " + e.toString());
			Cls_Log.insertaLog(cdo, facP.getFolio_canje(), facP.getNum_cli(), "ERROR AL CONSULTAR DESCRIPCION CONCEPTO ACUMGANE QUERY 14 "+sntQry.replace("´","")+" . ");
		}finally {
			try{if(connBD != null) {connBD.close();}}catch(Exception e) {}
			try{if(pstmt != null) {pstmt.close();}}catch(Exception e) {}
		}
		return listConcepto;
	}
	
	private List<Receptor> consultaReceptor(FacPendiente facP, String cdo) {
		Connection connBD = null;	
		PreparedStatement pstmt = null; 
		String[] querys = new String[25];
		List<Receptor> listReceptor = new ArrayList<>();
		String sntQry = "";
		try {
			connBD = ConexionBD.AbrirConexionBD(cdo);
			List<Querys> listaQuerys = ClsQuery.ConsultaTablaQuerysBD(cdo, connBD);
			querys = ClsQuery.LimpiaListaQuerys(querys);
	        querys = ClsQuery.ObtieneQuerys(3,listaQuerys, querys);
	        querys = inicializaQuery3(querys,cdo,facP); 
	        sntQry = ClsQuery.obtieneSentenciaDeQrys(querys);
	        ClsQuery.ImprimeQuerysConsola(querys, false, "query 3 ");
	        	
	        ResultSet rs = ClsQuery.EjecutarQuery(querys[0], querys[1], querys[2], querys[3], querys[4], querys[5], querys[6], querys[7], querys[8], querys[9], querys[10], querys[11], 
					querys[12], querys[13], querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], querys[21], querys[22], querys[23], querys[24], cdo, pstmt, connBD);
	 
			if(rs != null) {
				while(rs.next()) {
					Receptor rec = new Receptor();
					rec.setNum_cte(rs.getString("num_cte"));
					rec.setNombre_rec(rs.getString("{NOMBRE_REC}"));
					rec.setUname(rs.getString("uname"));
					rec.setRazon_social(rs.getString("razon_social"));
					rec.setCalle_rec(rs.getString("{CALLE_REC}"));
					rec.setColonia_rec(rs.getString("{COLONIA_REC}"));
					rec.setMunicipio_rec(rs.getString("{MUNICIPIO_REC}"));
					rec.setEstado_rec(rs.getString("{ESTADO_REC}"));
					rec.setCp_rec(rs.getString("{CP_REC}"));
					rec.setRfc_rec(rs.getString("{RFC_REC}").replace("-", ""));
					rec.setTelefono(rs.getString("telefono"));
					rec.setVigencia(rs.getString("vigencia"));
					rec.setBloqueo(rs.getString("bloqueo"));
					rec.setE_mail_rec(rs.getString("{EMAIL_REC}"));
					rec.setRegimenFiscal(rs.getString("regimen_fiscal"));
					if(rs.getString("desglosa_iva").toString().equals("S")) {
						rec.setDesglosa_iva("Desglosa IVA");
					}else {
						rec.setDesglosa_iva("No desglosa IVA");
					}					
					rec.setNum_exterior_rec(rs.getString("{NUM_EXT_REC}"));
					rec.setNum_interior_rec(rs.getString("{NUM_INT_REC}"));
					rec.setSucursal_rec(rs.getString("{SUCURSAL_REC}"));
					rec.setLocalidad_rec(rs.getString("{LOCALIDAD_REC}"));
					rec.setReferencia_rec(rs.getString("{REFERENCIA_REC}"));
					rec.setPais_rec(rs.getString("{PAIS_REC}"));
					rec.setPasaporte_rec(rs.getString("{PASAPORTE_REC}"));
					rec.setCond_pago(rs.getString("cond_pago"));
					rec.setSaldo(rs.getString("saldo"));
					rec.setTransporte(rs.getString("transporte"));
					rec.setRuta(rs.getString("ruta"));
					rec.setLetra_descuento(rs.getString("letra_descuento"));
					rec.setNom_trasn(rs.getString("nom_trasn"));					
					rec.setDescripci(rs.getString("descripci"));					
					rec.setTipo_lf(rs.getString("tipo_lf"));
					rec.setTipo_cliente(rs.getString("tipo_cliente"));
					rec.setNomRuta(rs.getString("nom_ruta"));
					rec.setTipoFac(rs.getString("tipo_fac"));
					//////////System.out.println("tipo Cliente: " +  rs.getString("tipo_cliente").toString());
					//////////System.out.println("tipo_lf: " + rs.getString("tipo_lf").toString()); 
					if (rs.getString("tipo_cliente").equals("F"))
                    {
                        if (rs.getString("tipo_lf").equals("L"))
                        {
                        	//////////System.out.println("1. Entra a agente");
                        	rec.setAgte("2901"); 
                        }
                        else if (rs.getString("tipo_lf").equals("F"))
                        {
                        	//////////System.out.println("2. Entra a agente");
                        	rec.setAgte("2903");
                        }
                    }
                    else if (rs.getString("tipo_cliente").equals("T"))
                    {
                        if (rs.getString("tipo_lf").equals("L"))
                        {
                        	//////////System.out.println("3. Entra a agente");
                        	rec.setAgte("2902");
                        }
                        else if (rs.getString("tipo_lf").equals("F"))
                        {
                        	//////////System.out.println("4. Entra a agente");
                        	rec.setAgte("2904");
                        }
                    }
					//////////System.out.println("agnte: "+rec.getAgte()); 
					listReceptor.add(rec);
				}
			}
			Cls_Log.insertaLog(cdo, facP.getFolio_canje(), facP.getNum_cli(), "CONSULTA RECEPTOR ACUMGANE QUERY 3 "+sntQry.replace("´","")+" . ");	
		}catch(Exception e) {
			//////////System.out.println("Error en consultaReceptor(): " + e.toString());
			Cls_Log.insertaLog(cdo, facP.getFolio_canje(), facP.getNum_cli(), "ERROR AL CONSULTAR RECEPTOR ACUMGANE QUERY 3 "+sntQry.replace("´","")+" . ");
		}finally {
			try{if(connBD != null) {connBD.close();}}catch(Exception e) {}
			try{if(pstmt != null) {pstmt.close();}}catch(Exception e) {}
		}
		return listReceptor;
	}
	
	private String consultarFolio(FacPendiente facP, String cdo) {
		Connection connBD = null;	
		PreparedStatement pstmt = null; 
		String[] querys = new String[25];
		String folio = "";
		String sntQry = "";
		try {
			connBD = ConexionBD.AbrirConexionBD(cdo);
			List<Querys> listaQuerys = ClsQuery.ConsultaTablaQuerysBD(cdo, connBD);
			querys = ClsQuery.LimpiaListaQuerys(querys);
	        querys = ClsQuery.ObtieneQuerys(7,listaQuerys, querys);
	        //////////System.out.println("7.- uname_br "+facP.get(0).getUname());
	        querys = inicializaQuery7(querys,cdo,facP.getUname()); 
	        sntQry = ClsQuery.obtieneSentenciaDeQrys(querys);
	        ClsQuery.ImprimeQuerysConsola(querys, false, "query 7 ");
	        	
	        ResultSet rs = ClsQuery.EjecutarQuery(querys[0], querys[1], querys[2], querys[3], querys[4], querys[5], querys[6], querys[7], querys[8], querys[9], querys[10], querys[11], 
					querys[12], querys[13], querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], querys[21], querys[22], querys[23], querys[24], cdo, pstmt, connBD);
	 
			if(rs != null) {
				while(rs.next()) {
					folio = rs.getString("folio");
				}
			}
			//////////System.out.println("folio: " + folio); 
			Cls_Log.insertaLog(cdo, facP.getFolio_canje(), facP.getNum_cli(), "CONSULTA FOLIO ACUMGANE QUERY 7 "+sntQry.replace("´","")+" . ");	
		}catch(Exception e) {
			//////////System.out.println("Error en consultarFolio(): " + e.toString());
			Cls_Log.insertaLog(cdo, facP.getFolio_canje(), facP.getNum_cli(), "ERROR AL CONSULTAR FOLIO ACUMGANE QUERY 7 "+sntQry.replace("´","")+" . ");
		}finally {
			try{if(connBD != null) {connBD.close();}}catch(Exception e) {}
			try{if(pstmt != null) {pstmt.close();}}catch(Exception e) {}
		}
		return folio;		
	}
	
	private boolean actualizarFolio(FacPendiente facP, String cdo) {
		Connection connBD = null;	
		PreparedStatement pstmt = null; 
		String[] querys = new String[25];
		boolean folio = false;
		String sntQry = "";
		try {
			connBD = ConexionBD.AbrirConexionBD(cdo);
			List<Querys> listaQuerys = ClsQuery.ConsultaTablaQuerysBD(cdo, connBD);
			querys = ClsQuery.LimpiaListaQuerys(querys);
	        querys = ClsQuery.ObtieneQuerys(8,listaQuerys, querys);
	        querys = inicializaQuery7(querys,cdo,facP.getUname()); 
	        sntQry = ClsQuery.obtieneSentenciaDeQrys(querys);
	        ClsQuery.ImprimeQuerysConsola(querys, false, "query 8 ");
	        	
	        ClsQuery.EjecutarQuery(querys[0], querys[1], querys[2], querys[3], querys[4], querys[5], querys[6], querys[7], querys[8], querys[9], querys[10], querys[11], 
					querys[12], querys[13], querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], querys[21], querys[22], querys[23], querys[24], cdo, pstmt, connBD);
	 
			folio = true;
			Cls_Log.insertaLog(cdo, facP.getFolio_canje(), facP.getNum_cli(), "ACTUALIZA FOLIO ACUMGANE QUERY 8 "+sntQry.replace("´","")+" . ");
		}catch(Exception e) {
			//////////System.out.println("Error en actualizarFolio(): " + e.toString());
			Cls_Log.insertaLog(cdo, facP.getFolio_canje(), facP.getNum_cli(), "ERROR AL ACTUALIZAR FOLIO ACUMGANE QUERY 8 "+sntQry.replace("´","")+" . ");
		}finally {
			try{if(connBD != null) {connBD.close();}}catch(Exception e) {}
			try{if(pstmt != null) {pstmt.close();}}catch(Exception e) {}
		}
		return folio;		
	}

	private List<Emisor> consultaEmisor(FacPendiente facP, String cdo) {
		Connection connBD = null;	
		PreparedStatement pstmt = null; 
		String[] querys = new String[25];
		List<Emisor> listEmisor = new ArrayList<>();
		String sntQry = "";
		try {
			connBD = ConexionBD.AbrirConexionBD(cdo);
			List<Querys> listaQuerys = ClsQuery.ConsultaTablaQuerysBD(cdo, connBD);
			querys = ClsQuery.LimpiaListaQuerys(querys);
	        querys = ClsQuery.ObtieneQuerys(4,listaQuerys, querys);
	        querys = inicializaQuery4(querys,cdo,facP); 
	        sntQry = ClsQuery.obtieneSentenciaDeQrys(querys);
	        ClsQuery.ImprimeQuerysConsola(querys, false, "query 4 ");
	        	
	        ResultSet rs = ClsQuery.EjecutarQuery(querys[0], querys[1], querys[2], querys[3], querys[4], querys[5], querys[6], querys[7], querys[8], querys[9], querys[10], querys[11], 
					querys[12], querys[13], querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], querys[21], querys[22], querys[23], querys[24], cdo, pstmt, connBD);
	 
			if(rs != null) {
				while(rs.next()) {
					Emisor emis = new Emisor();
					emis.setRfc_emi(rs.getString("{RFC_EMI}"));
					emis.setNombre_emi(rs.getString("{NOMBRE_EMI}"));
					emis.setUname_emi(rs.getString("{UNAME_EMI}"));
					emis.setCalle_emi(rs.getString("{CALLE_EMI}"));
					emis.setNum_ext_emi(rs.getString("{NUM_EXT_EMI}"));
					emis.setNum_int_emi(rs.getString("{NUM_INT_EMI}"));
					emis.setColonia(rs.getString("{COLONIA}"));
					emis.setReferencia_emi(rs.getString("{REFERENCIA_EMI}"));
					emis.setMunicipio(rs.getString("{MUNICIPIO}"));
					emis.setEstado(rs.getString("{ESTADO}"));
					emis.setPais(rs.getString("{PAIS}"));
					emis.setCp_emi(rs.getString("{CP_EMI}"));
					emis.setCalle_emi_comp(rs.getString("{CALLE_EMI_COMP}"));
					emis.setNum_ext_emi_comp(rs.getString("{NUM_EXT_EMI_COMP}"));
					emis.setNum_int_emi_comp(rs.getString("{NUM_INT_EMI_COMP}"));
					emis.setColonia_emi_comp(rs.getString("{COLONIA_EMI_COMP}"));
					emis.setMunicipio_emi_comp(rs.getString("{MUNICIPIO_EMI_COMP}"));
					emis.setEstado_emi_comp(rs.getString("{ESTADO_EMI_COMP}"));
					emis.setPais_emi_comp(rs.getString("{PAIS_EMI_COMP}"));
					emis.setCp_emi_comp(rs.getString("{CP_EMI_COMP}"));				
					emis.setNa(rs.getString("{NA}"));
					emis.setLocalidad_emi_comp(rs.getString("{LOCALIDAD_EMI}"));
					emis.setTel_emi(rs.getString("{TEL_EMI}"));
					emis.setLocalidad_emi_comp(rs.getString("{LOCALIDAD_EMI_COMP}"));
					emis.setReferencia_emi_comp(rs.getString("{REFERENCIA_EMI_COMP}"));
					emis.setTelefono_emi_comp(rs.getString("{TELEFONO_EMI_COMP}"));
					listEmisor.add(emis);
				}
			}
			Cls_Log.insertaLog(cdo, facP.getFolio_canje(), facP.getNum_cli(), "CONSULTA EMISOR ACUMGANE QUERY 4 "+sntQry.replace("´","")+" . ");	
		}catch(Exception e) {
			//////////System.out.println("Error en consultaEmisor(): " + e.toString());
			Cls_Log.insertaLog(cdo, facP.getFolio_canje(), facP.getNum_cli(), "ERROR EN CONSULTA EMISOR ACUMGANE QUERY 4 "+sntQry.replace("´","")+" . ");
		}finally {
			try{if(connBD != null) {connBD.close();}}catch(Exception e) {}
			try{if(pstmt != null) {pstmt.close();}}catch(Exception e) {}
		}
		
		return listEmisor;
	}
	

	private List<Estructura> consultaDetalleEstructura(FacPendiente facP, String cdo) {
		Connection connBD = null;	
		PreparedStatement pstmt = null; 
		String[] querys = new String[25];
		List<Estructura> listEstructura = new ArrayList<>();
		String sntQry = "";
		try {
			connBD = ConexionBD.AbrirConexionBD(cdo);
			List<Querys> listaQuerys = ClsQuery.ConsultaTablaQuerysBD(cdo, connBD);
			querys = ClsQuery.LimpiaListaQuerys(querys);
	        querys = ClsQuery.ObtieneQuerys(5,listaQuerys, querys);	
	        querys = inicializaQuery5(querys,cdo); 
	        sntQry = ClsQuery.obtieneSentenciaDeQrys(querys);
	        ClsQuery.ImprimeQuerysConsola(querys, false, "query 5 ");
	        	
	        ResultSet rs = ClsQuery.EjecutarQuery(querys[0], querys[1], querys[2], querys[3], querys[4], querys[5], querys[6], querys[7], querys[8], querys[9], querys[10], querys[11], 
					querys[12], querys[13], querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], querys[21], querys[22], querys[23], querys[24], cdo, pstmt, connBD);
	  
			if(rs != null) {
				while(rs.next()) {
					Estructura estructura = new Estructura();
					estructura.setId(rs.getString("id"));
					estructura.setDescripcion(rs.getString("descripcion"));
					listEstructura.add(estructura);
				}
			}
			Cls_Log.insertaLog(cdo, facP.getFolio_canje(), facP.getNum_cli(), "DETALLE DE LA ESTRUCTURA ACUMGANE QUERY 5 "+sntQry.replace("´","")+" . ");	
		}catch(Exception e) {
			//////////System.out.println("Error en consultaDetalleEstructura(): " + e.toString());
			Cls_Log.insertaLog(cdo, facP.getFolio_canje(), facP.getNum_cli(), "ERROR EN RECUPERAR DETALLE DE LA ESTRUCTURA ACUMGANE QUERY 5 "+sntQry.replace("´","")+" . ");
		}finally {
			try{if(connBD != null) {connBD.close();}}catch(Exception e) {}
			try{if(pstmt != null) {pstmt.close();}}catch(Exception e) {}
		}
		return listEstructura;
		
	}
	
	/*CREA ARCHIVO PLANO*/
	private String creaTextLocal(String folio,String folioCanje, String num_cli, String agente, String cond_pago, double impNeto, double iva, double impBruto,  String cdo) 
	{
		 
		 
		String rutProc = ruta_fac_esp.toString();
		String ruta = ObtieneRutaPDF(rutProc);
		while(folio.length() < 7) {
			folio =  "0" + folio; 
		}
		
		while(folioCanje.length() < 9) {
			folioCanje = "0" + folioCanje;
		}
		
		while(num_cli.length() < 5) {
			num_cli = "0"+num_cli;
		}
		
		while(agente.length() < 4) {
			agente = "0"+agente;
		}
		
		String nombreArch = id_cdo + folio +"1"+ folioCanje+".txt"; 
		try {
			//System.out.println("importe neto String: "+impNet2[0]+impNet2[1]);
			String impt=String.format("%.2f", impNeto).replace(".", ""), ivat=String.format("%.2f", iva).replace(".", "") ,imbt=String.format("%.2f", impBruto).replace(".", "");
			
			boolean cond=true,imp=true,i=true,imb=true;
			do {
				if(impt.length()<11) {
					impt="0"+impt;
				}else {
					imp=false;
				}
				if(ivat.length()<9) {
					ivat="0"+ivat;
				}else {
					i=false;
				}
				if(imbt.length()<11) {
					imbt="0"+imbt;
				}else {
					imb=false;
				}
				if(cond_pago.length()<2) {
					cond_pago="0"+cond_pago;
				}else {
					cond=false;
				}
			}while(cond||imp||i||imb);
			File myObj = new File(ruta + nombreArch);
		      if (myObj.createNewFile()) {
		    	FileWriter myWriter = new FileWriter(myObj);
		    	
		    	myWriter.write(id_cdo.toString() + folio + num_cli + agente + cond_pago + impt + ivat + imbt + usuFac.toString() + ivaRetenido.toString());
		        myWriter.close();	
		      } else {
		        //////////System.out.println("File ya existe.");
		      }
		
		FTPClient client = new FTPClient();
		 String ftp = cdo.toLowerCase(); // También puede ir la IP
		 String user = "ftpcfdi";
		 String password = "$#cfdi2830";
			 client.connect(ftp);
			 boolean login = client.login(user, password);
			 
			 if(login!=true){
					
					System.out.println("no pude conectarme");
										
				}else{
					System.out.println("conectado");
					client.changeWorkingDirectory(ruta_fac_esp_2);
					 System.out.println(client.printWorkingDirectory());
		                FileInputStream input = new FileInputStream(myObj);
		                System.out.println(input);
		                client.setFileType(FTP.BINARY_FILE_TYPE, FTP.BINARY_FILE_TYPE);
		                client.setFileTransferMode(FTP.BINARY_FILE_TYPE);
		                client.enterLocalPassiveMode();
		                System.out.println("Subió satisfactoriamente el archivo");
		                
		                if (!client.storeFile(myObj.getName(),input)){
		                    System.out.println("Subida fallida!");
		                }
		               // myObj.delete();
				}
			 client.logout();
             client.disconnect();
		 }catch(Exception e) {
			 
	 }
		return nombreArch;
	}
	

	private boolean insertarConcActualizados(int regDetP, List<DetallePendiente> listDetaP, List<Concepto> listConc, String uname_tmp, String folio, FacPendiente listFacPe, 
			FacPendiente listFacP, String agente, String cdo, List<Correos> listCorreos) {
		Connection connBD = null;	
		PreparedStatement pstmt = null; 
		String[] querys = new String[25];
		String query1 = "";
		String query2 = "";
		int row = 0;
		double impNeto = 0.0;
		double impBruto = 0.0;
		boolean inserConcActual = false; 
		String sntQry = "";
		double iva = 0.16;
		// QUERY 2
//		   dtRenglon.TableName = "Renglon";
//         dtRenglon.Columns.Add("concepto");
//         dtRenglon.Columns.Add("observaciones");
//         dtRenglon.Columns.Add("precio");
//         dtRenglon.Columns.Add("cantidad");
//         dtRenglon.Columns.Add("importe");
//         dtRenglon.Columns.Add("idConcepto");
//		   ro = dtRenglon.NewRow();
//         ro[0] = descConcepto.ToString().Trim();
//         ro[1] = r["articulo"].ToString().Trim() + " " + r["serie"].ToString().Trim() + " " + r["motor"].ToString().Trim() + " " + r["observaciones"].ToString().Trim();
//         ro[2] = r["precio"].ToString();
//         ro[3] = r["cantidad"].ToString();
//         impNeto = (double.Parse(r["cantidad"].ToString()) * double.Parse(r["precio"].ToString())) + impNeto;
//         ro[4] = (double.Parse(r["cantidad"].ToString()) * double.Parse(r["precio"].ToString())).ToString();
//         ro[5] = cve_concepto.ToString().Trim();
		try {
			String correos = "";
			for(int i = 0;i < listCorreos.size()  ;i++) {
				correos += listCorreos.get(0).getCorreo()+ ",";
			}
			
			correos = correos.substring(0, correos.length() - 1);
			
			for (DetallePendiente listDetaPe : listDetaP) {
				row = row + 1;
				String observaciones = reemplazarCaracteresEspeciales(listDetaPe.getArticulo()+" "+listDetaPe.getSerie()+" "+listDetaPe.getMotor()+" "+listDetaPe.getObservaciones());
				//System.out.println(observaciones);
				if(row != regDetP) {
					//System.out.println("Observaciones: "+listDetaPe.getObservaciones());
					query1 = query1 + "('"+uname_tmp+"','0000-00-00','" + id_cdo +"','"+folio+"','"+listConc.get(0).getCve_concepto()+"','"+listDetaPe.getPrecio()+"','"+listDetaPe.getCantidad()+"','"+observaciones
					+"','0','"+row+"','"+ listConc.get(0).getC_ClaveProdServ() + "','"+listConc.get(0).getC_ClaveUnidad() +"', CURDATE(), CURTIME() ),"; 
					//System.out.println(" QUERY 9 1.1 query1: " + query1);
				}else {
					query1 = query1 + "('"+uname_tmp+"','0000-00-00','" + id_cdo +"','"+folio+"','"+listConc.get(0).getCve_concepto()+"','"+listDetaPe.getPrecio()+"','"+listDetaPe.getCantidad()+"','"+observaciones
					+"','0','"+row+"','"+ listConc.get(0).getC_ClaveProdServ() + "','"+listConc.get(0).getC_ClaveUnidad() +"', CURDATE(), CURTIME() )";
					//System.out.println(" QUERY 9 1.2 query1: " + query1);
				}
				impNeto = (Double.parseDouble(listDetaPe.getCantidad().toString()) * Double.parseDouble(listDetaPe.getPrecio().toString())) + impNeto; 
			}
			//System.out.println("9.1 impNeto: "+query1);
			////////System.out.println("IVA: " + iva);
			iva = impNeto * iva;
			////////System.out.println("2. IVA: "+iva);
			impBruto = impNeto + iva;
			////////System.out.println("impBruto: "+impBruto);
			if(listFacPe.getRfc().trim() == "XAXX010101000" || listFacPe.getRfc().trim() == "XEXX010101000") 
			{
				query2 = query2 + "('" + uname_tmp +"','" + id_cdo.toString() +"','"+folio+"','" + usuFac.toString() + "','" + listFacP.getNum_cli() + "',' ','0000-00-00','" + impBruto + "','" + impBruto + "','G','E','"
						+ agente +"',' ','0','"+ ivaRetenido + "','0','0000-00-00', CURTIME(), '"+ correos.toString() + "','"+ listFacP.getFolio_canje() + "','" + listConc.get(0).getC_UsoCFDI() + "','"+iva+"',0 CURDATE(), CURTIME() )";
			}else {
				query2 = query2 + "('" + uname_tmp +"','" + id_cdo.toString() +"','"+folio+"','" + usuFac.toString() + "','" + listFacP.getNum_cli() + "',' ','0000-00-00','" + impNeto + "','" + impBruto + "','G','E','"
						+ agente +"',' ','0','"+ ivaRetenido + "','0','0000-00-00', CURTIME(), '"+ correos.toString() + "','"+ listFacP.getFolio_canje() + "','" + listConc.get(0).getC_UsoCFDI() + "','"+iva+"',0, CURDATE(), CURTIME() )";
			}
			connBD = ConexionBD.AbrirConexionBD(cdo);
			List<Querys> listaQuerys = ClsQuery.ConsultaTablaQuerysBD(cdo, connBD);
			querys = ClsQuery.LimpiaListaQuerys(querys);
	        querys = ClsQuery.ObtieneQuerys(9,listaQuerys, querys);	  
	        querys = inicializaQuery9(querys,cdo,listFacP.getNum_cli(),query1,query2); 
	        sntQry = ClsQuery.obtieneSentenciaDeQrys(querys);
	        ClsQuery.ImprimeQuerysConsola(querys, false, "query 9 ");
	        	
	        ClsQuery.EjecutarQuery(querys[0].replace("{CDO}", cdo.toUpperCase()), querys[1], querys[2], querys[3], querys[4], querys[5], querys[6], querys[7], querys[8], querys[9], querys[10], querys[11], 
					querys[12], querys[13], querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], querys[21], querys[22], querys[23], querys[24], cdo, pstmt, connBD);
	  
	        inserConcActual = true;
	        Cls_Log.insertaLog(cdo, listFacP.getFolio_canje(), listFacP.getNum_cli(), "INSERTA CONCEPTOS ACTUALIZADOS ACUMGANE QUERY 9 "+sntQry.replace("´","")+" . ");    
		}catch(Exception e) {
			inserConcActual = false;
			////////System.out.println("Error en insertarConcActualizados(): " + e.toString());
			Cls_Log.insertaLog(cdo, listFacP.getFolio_canje(), listFacP.getNum_cli(), "ERROR EN INSERTA CONCEPTOS ACTUALIZADOS ACUMGANE QUERY 9 "+sntQry.replace("´","")+" . ");
		}finally {
			try{if(connBD != null) {connBD.close();}}catch(Exception e) {}
			try{if(pstmt != null) {pstmt.close();}}catch(Exception e) {}
		}
		return inserConcActual;
	}
	
	private String ejecutaShell(String folio, String folioCanje, String nombreArch, List<FacPendiente> facP, String cdo) {
		String str_ruta_shell = ruta_shell.toString();
		
		////////System.out.println("nombreArch: " + nombreArch); 
		String sNO = str_ruta_shell + " " + nombreArch + " &";
		
		// Java code illustrating destroyForcibly()
		// method for windows operating ////////System
		
		 String ruta = "";
	     if (cdo.equals("cdf") || cdo.equals("cd2"))
	     {
	         ruta = "centdis";
	     }
	     else
	     {
	         ruta = "roa";
	     }
	     String host=cdo.toLowerCase();
	     String user="desmay";
	     String password="M261086";
	     String rsp = "false";
	    // String command1="ls -lt /usr/acct/centdis/armando";
//	      String command1="cd /usr/acct/centdis/armando; sh correBD "+ode+"";
	     //					/usr/acct/centdis/apsh/CDFA427D + " " + nombreArch + " &";
	     //String command1="cd /usr/acct/"+ruta+"/apsh; sh CDMLFN04.sh "+ode;
	     String command1="cd /usr/acct/"+ruta+"/apsh; ./CDFA427D" + " " + nombreArch + " ";
	     ////////System.out.println("command1: " + command1); 
	     try{
	         
	         java.util.Properties config = new java.util.Properties();
	         config.put("StrictHostKeyChecking", "no");
	         JSch jsch = new JSch();
	         Session session=jsch.getSession(user, host, 22);
	         session.setPassword(password);
	         session.setConfig(config);
	         session.connect();
	         Channel channel=session.openChannel("exec");
	         ((ChannelExec)channel).setCommand(command1);
	         channel.setInputStream(null);
	         ((ChannelExec)channel).setErrStream(System.err);
	         
	         InputStream in=channel.getInputStream();
	         channel.connect();
	         byte[] tmp=new byte[1024];
	         while(true){
	           while(in.available()>0){
	             int i=in.read(tmp, 0, 1024);
	             if(i<0)break;
	             //////////System.out.print(new String(tmp, 0, i));
	           }
	           if(channel.isClosed()){
	            rsp = String.valueOf(channel.getExitStatus());
	            ////////System.out.println("Respuesta shell: "+rsp);
	             break;
	           }
	           try{Thread.sleep(1000);}catch(Exception ee){}
	         }
	         channel.disconnect();
	         session.disconnect();
	         rsp="0";
//	         StringBuilder message = new StringBuilder();
//	         BufferedReader reader = new BufferedReader(new InputStreamReader(in));
//	         String line = null;
//	         while ((line = reader.readLine()) != null)
//	         {
//	             message.append(line).append("\n");
//	         }
//	         channel.disconnect();
//	         while (!channel.isClosed()) {
//
//	         }
	         //////////System.out.println((channel.getExitStatus()+" "+message.toString()));
	     }catch(Exception e){
	         //InsertarLogAlamacen.insertarLog(new LogAlmacen(Integer.parseInt(ode), "Error catch interface facturacion. Error: ["+e.getMessage().toString().replace("'", "´")+"]. Usuario: "+empleado+". Ode: "+ode+". Pedido: "+pedido+"","t"), uname);
	         e.printStackTrace();
	         rsp="1";
	         Cls_Log.insertaLog(cdo, facP.get(0).getFolio_canje(), facP.get(0).getNum_cli(), "ERROR AL EJECUTAR SHELL ACUMGANE ");
	     }
	   return rsp;
			
	}
	
	
	
	private String consultarStsFin(String folio,FacPendiente listFacP, String cdo) {
		Connection connBD = null;	
		PreparedStatement pstmt = null; 
		String[] querys = new String[25];
		String dtEstatus = "";
		String sntQry = "";
		try {
			connBD = ConexionBD.AbrirConexionBD(cdo);
			List<Querys> listaQuerys = ClsQuery.ConsultaTablaQuerysBD(cdo, connBD);
			querys = ClsQuery.LimpiaListaQuerys(querys);
	        querys = ClsQuery.ObtieneQuerys(10,listaQuerys, querys);
	        querys = inicializaQuery10(querys,cdo,id_cdo,usuFac, folio,listFacP.getUname(),listFacP.getNum_cli()); 
	        sntQry = ClsQuery.obtieneSentenciaDeQrys(querys);
	        ClsQuery.ImprimeQuerysConsola(querys, false, "query 10 ");
	        	
	        ResultSet rs = ClsQuery.EjecutarQuery(querys[0].replace("{CDO}", cdo.toUpperCase()), querys[1], querys[2], querys[3], querys[4], querys[5], querys[6], querys[7], querys[8], querys[9], querys[10], querys[11], 
					querys[12], querys[13], querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], querys[21], querys[22], querys[23], querys[24], cdo, pstmt, connBD);
	  
			if(rs != null) {
				while(rs.next()) {
					dtEstatus = rs.getString("st");					
				}
			}
			Cls_Log.insertaLog(cdo, listFacP.getFolio_canje(), listFacP.getNum_cli(), "CONSULTAR ESTATUS FIN ACUMGANE QUERY 10 "+sntQry.replace("´","")+" . ");	
		}catch(Exception e) {
			////////System.out.println("Error en consultarStsFin(): " + e.toString());
			Cls_Log.insertaLog(cdo, listFacP.getFolio_canje(), listFacP.getNum_cli(), "ERROR EN CONSULTAR ESTATUS FIN ACUMGANE QUERY 10 "+sntQry.replace("´","")+" . ");
		}finally {
			try{if(connBD != null) {connBD.close();}}catch(Exception e) {}
			try{if(pstmt != null) {pstmt.close();}}catch(Exception e) {}
		}
		return dtEstatus;
	}

	private List<FacConceptosEspeciales> consultarActConceptosEspeciales(FacPendiente listFacP, String folio, String cdo) {
		Connection connBD = null;	
		PreparedStatement pstmt = null; 
		String[] querys = new String[25];
		List<FacConceptosEspeciales> lstFacConcEspeciales = new ArrayList<>();
		String sntQry = "";
		try {
			connBD = ConexionBD.AbrirConexionBD(cdo);
			List<Querys> listaQuerys = ClsQuery.ConsultaTablaQuerysBD(cdo, connBD);
			querys = ClsQuery.LimpiaListaQuerys(querys);
	        querys = ClsQuery.ObtieneQuerys(11,listaQuerys, querys);
	        querys = inicializaQuery11(querys,cdo,id_cdo,listFacP.getUname(),listFacP.getNum_cli(),folio);
	        sntQry = ClsQuery.obtieneSentenciaDeQrys(querys);
	        ClsQuery.ImprimeQuerysConsola(querys, false, "query 11 ");
	        	
	        ResultSet rs = ClsQuery.EjecutarQuery(querys[0].replace("{CDO}", cdo.toUpperCase()), querys[1], querys[2], querys[3], querys[4], querys[5], querys[6], querys[7], querys[8], querys[9], querys[10], querys[11], 
					querys[12], querys[13], querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], querys[21], querys[22], querys[23], querys[24], cdo, pstmt, connBD);
	  
			if(rs != null) {
				while(rs.next()) {
					FacConceptosEspeciales fcConceEspe = new FacConceptosEspeciales();
					fcConceEspe.setId_cdd(rs.getString("id_cdd"));
					fcConceEspe.setControl(rs.getString("control"));
					fcConceEspe.setUsuario_capt(rs.getString("usuario_capt"));
					fcConceEspe.setNum_cli(rs.getString("num_cli"));
					fcConceEspe.setNum_fac(rs.getString("num_fac"));
					fcConceEspe.setImp_neto(rs.getString("{IMP_NETO}"));
					fcConceEspe.setImp_bruto(rs.getString("{TOTAL_COMP}"));
					fcConceEspe.setSt(rs.getString("st"));
					fcConceEspe.setFecha_fact(rs.getString("fecha_fact"));
					fcConceEspe.setNum_agente(rs.getString("num_agente"));
					fcConceEspe.setSerie_cfd(rs.getString("{SERIE_CFD}"));
					fcConceEspe.setFolio_cfd(rs.getString("{FOLIO_CFD}"));
					fcConceEspe.setIva_retenido(rs.getString("iva_retenido"));
					fcConceEspe.setOde(rs.getString("ode"));
					fcConceEspe.setFecha_pro(rs.getString("fecha_pro"));
					fcConceEspe.setDesc_comp(rs.getString("{DESC_COMP}"));
					fcConceEspe.setMedios_pago(rs.getString("{MEDIOS_PAGO}"));
					fcConceEspe.setNumero_cuenta(rs.getString("{NUMERO_CUENTA}"));
					fcConceEspe.setObs_comp(rs.getString("{OBS_COMP}"));
					fcConceEspe.setFecha_liquidacion(rs.getString("fecha_liquidacion"));
					lstFacConcEspeciales.add(fcConceEspe);
				}
			}
			Cls_Log.insertaLog(cdo, listFacP.getFolio_canje(), listFacP.getNum_cli(), "CONSULTAR CONCEPTOS ESPECIALES ACTUALIZAODS  ACUMGANE QUERY 11 "+sntQry.replace("´","")+" . ");	
		}catch(Exception e) {
			////////System.out.println("Error en consultarActConceptosEspeciales(): " + e.toString());
			Cls_Log.insertaLog(cdo, listFacP.getFolio_canje(), listFacP.getNum_cli(), "ERROR EN CONSULTAR CONCEPTOS ESPECIALES ACTUALIZAODS  ACUMGANE QUERY 11 "+sntQry.replace("´","")+" . ");
		}finally {
			try{if(connBD != null) {connBD.close();}}catch(Exception e) {}
			try{if(pstmt != null) {pstmt.close();}}catch(Exception e) {}
		}
		return lstFacConcEspeciales;
	}
	
	private boolean insertaInformacionPedidos(List<FacConceptosEspeciales> lstFacConcEspeciales, String folio,FacPendiente listFacP,List<Receptor> listReceptor, String agente, int countListDetP,List<DetallePendiente> listDetP, String cdo) {
		String serie = "";
        String folioSER = "";
        char valReg = '0';
        String queryHP = "";
        String queryDP = "";
        String querySP = "";
        String queryIC = "";
        String queryICat = "";
        double iva = 0.16;
        int row = 0;
        double impNeto = 0.0;
        double impBruto = 0.0;
        boolean regInsertados = false;
        Connection connBD = null;	
		PreparedStatement pstmt = null; 
		String[] querys = new String[25];
		String sntQry = "";
		
		try {
			for (DetallePendiente listDetaPe : listDetP) {
				impNeto = (Double.parseDouble(listDetaPe.getCantidad().toString()) * Double.parseDouble(listDetaPe.getPrecio().toString())) + impNeto; 
			}
			iva = impNeto * iva;
            impBruto = impNeto + iva;
			for(FacConceptosEspeciales lstFacConEspe : lstFacConcEspeciales) {
				serie = lstFacConEspe.getSerie_cfd();
				folioSER = lstFacConEspe.getFolio_cfd();
				//////System.out.println();
				if(cdo.equals("cdf")) {
				queryHP = "('" + lstFacConEspe.getOde() + "','0','" + folio +"','"+ listFacP.getNum_cli()+"','"+listReceptor.get(0).getCond_pago()+"','"+agente+"','0','"+listReceptor.get(0).getSaldo()+"','"+listReceptor.get(0).getTransporte()
						+"','E','"+listReceptor.get(0).getTipo_cliente()+"','1',CURDATE(),CURTIME(),CURTIME(),'00:00:00','00:00:00','00:00:00','00:00:00','00:00:00',CURTIME(),CURTIME(),'00:00:00','00:00:00','00:00:00','00:00:00','00:00:00',"
								+ "'00:00:00','"+lstFacConEspe.getFecha_liquidacion()+"','0','1','C','"+countListDetP+"','0','I','1','"+usuFac.toString()+"','"+usuFac.toString()+"','0','"+listReceptor.get(0).getTipo_lf()+"','"+listReceptor.get(0).getRuta()
								+"','"+listFacP.getUname()+"','0','0','0','2','0','0','0','0','0','0','0','0','0','0','0','0',CURDATE(),CURTIME() )";
				////////System.out.println("queryHP: " + queryHP); 
				}else {
					queryHP = "('" + lstFacConEspe.getOde() + "','0','" + folio +"','"+ listFacP.getNum_cli()+"','"+listReceptor.get(0).getCond_pago()+"','"+agente+"','0','"+listReceptor.get(0).getSaldo()+"','"+listReceptor.get(0).getTransporte()
							+"','E','"+listReceptor.get(0).getTipo_cliente()+"','1',CURDATE(),CURTIME(),CURTIME(),'00:00:00','00:00:00','00:00:00','00:00:00','00:00:00',CURTIME(),CURTIME(),'00:00:00','00:00:00','00:00:00','00:00:00','00:00:00',"
									+ "'00:00:00','"+lstFacConEspe.getFecha_liquidacion()+"','0','1','C','"+countListDetP+"','0','I','1','"+usuFac.toString()+"','"+usuFac.toString()+"','0','"+listReceptor.get(0).getTipo_lf()+"','"+listReceptor.get(0).getRuta()
									+"','"+listFacP.getUname()+"',CURDATE(),CURTIME() )";
				}
				row = 0;
				for(DetallePendiente listDetPe : listDetP) {
					String observaciones = reemplazarCaracteresEspeciales(listDetPe.getArticulo()+" "+listDetPe.getSerie()+" "+listDetPe.getMotor()+" "+listDetPe.getObservaciones());
					row = row + 1;
					//////System.out.println(observaciones);
					if(row != countListDetP) 
					{
						queryDP = queryDP + "('" + lstFacConEspe.getOde() + "','0','"+lstFacConEspe.getSerie_cfd()+"','"+lstFacConEspe.getFolio_cfd()+"','"+row+"','"+row+"-"+listFacP.getCve_concepto()+"','"+observaciones
								+ "','"+listDetPe.getCantidad()+"','"+listDetPe.getCantidad()+"','"+listDetPe.getPrecio()+"',' ','CPP',' ',' ','000-00-00',' ','0','"+listFacP.getCve_concepto()+" "+observaciones.toString()+"','NA','"
								+(Double.parseDouble(listDetPe.getCantidad().toString()) * Double.parseDouble(listDetPe.getPrecio().toString()))+"',CURDATE(),CURTIME() ),"; 
						////////System.out.println("1.1 queryDP: " + queryDP);
					}
					else 
					{
						String D = lstFacConEspe.getFolio_cfd().toString();
						queryDP = queryDP + "('" + lstFacConEspe.getOde() + "','0','"+lstFacConEspe.getSerie_cfd()+"','"+lstFacConEspe.getFolio_cfd()+"','"+row+"','"+row+"-"+listFacP.getCve_concepto()+"','"+observaciones
								+ "','"+listDetPe.getCantidad()+"','"+listDetPe.getCantidad()+"','"+listDetPe.getPrecio()+"',' ','CPP',' ',' ','000-00-00',' ','0','"+listFacP.getCve_concepto()+" "+observaciones.toString()+"','NA','"
								+(Double.parseDouble(listDetPe.getCantidad().toString()) * Double.parseDouble(listDetPe.getPrecio().toString()))+"',CURDATE(),CURTIME() )";
						////////System.out.println("1.2 queryDP: " + queryDP);
					}
				}
			querySP = "('" + lstFacConEspe.getOde() + "','0','" + lstFacConEspe.getSerie_cfd() + lstFacConEspe.getFolio_cfd()+"','" + impNeto + "','0','0','0',' ','" + impNeto + "','" + iva + "','0.16','" + impBruto + "',' ','C','1','0','1',CURDATE(),CURTIME() )";	
			//////System.out.println("querySP: "+querySP);
			queryIC = "('" + lstFacConEspe.getSerie_cfd() + "','" + lstFacConEspe.getFolio_cfd() + "','" + listFacP.getNum_cli()+"','" + agente + "','" + listReceptor.get(0).getNom_trasn() + "','" + lstFacConEspe.getOde() + "','0','" + folio + "','" + listReceptor.get(0).getLetra_descuento() + "','0','0' )";
			//////System.out.println("queryIC: " + queryIC); 
			}
			
			connBD = ConexionBD.AbrirConexionBD(cdo);
			List<Querys> listaQuerys = ClsQuery.ConsultaTablaQuerysBD(cdo, connBD);
			querys = ClsQuery.LimpiaListaQuerys(querys);
	        querys = ClsQuery.ObtieneQuerys(12,listaQuerys, querys);
	        querys = inicializaQuery12(querys,cdo,queryHP,queryDP,querySP, queryIC, queryICat);
	        sntQry = ClsQuery.obtieneSentenciaDeQrys(querys);
	        ClsQuery.ImprimeQuerysConsola(querys, false, "query 12 ");
	        	
	        ClsQuery.EjecutarQuery(querys[0].replace("{CDO}", cdo.toUpperCase()), querys[1], querys[2], querys[3], querys[4], querys[5], querys[6], querys[7], querys[8], querys[9], querys[10], querys[11], 
					querys[12], querys[13], querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], querys[21], querys[22], querys[23], querys[24], cdo, pstmt, connBD);
	        
	        regInsertados = true;
			
	        Cls_Log.insertaLog(cdo, listFacP.getFolio_canje(), listFacP.getNum_cli(), "INSERTA INFORMACION PEDIDOS ACUMGANE QUERY 12 "+sntQry.replace("´","")+" . ");	
		}catch(Exception e) {
			////////System.out.println("Error en insertaInformacionPedidos(): " + e.toString());
			regInsertados = false;
			Cls_Log.insertaLog(cdo, listFacP.getFolio_canje(), listFacP.getNum_cli(), "ERROR EN INSERTA INFORMACION PEDIDOS ACUMGANE QUERY 12 "+sntQry.replace("´","")+" . ");
		}finally {
			try{if(connBD != null) {connBD.close();}}catch(Exception e) {}
			try{if(pstmt != null) {pstmt.close();}}catch(Exception e) {}
		}
		return regInsertados;
	}
	
	private List<MetodoPagoYCuenta> consultaMetodoPagoNumeroCuenta(FacPendiente listFacP, String cdo) {
		Connection connBD = null;	
		PreparedStatement pstmt = null; 
		String[] querys = new String[25];
		List<MetodoPagoYCuenta> listMetyPago = new ArrayList<>();
		String numCuenta = " ";
		String vlrDiv = "";
		String sntQry = "";
		try {
			connBD = ConexionBD.AbrirConexionBD(cdo);
			List<Querys> listaQuerys = ClsQuery.ConsultaTablaQuerysBD(cdo, connBD);
			querys = ClsQuery.LimpiaListaQuerys(querys);
	        querys = ClsQuery.ObtieneQuerys(13,listaQuerys, querys);
	        querys = inicializaQuery13(querys,cdo,listFacP.getNum_cli());
	        sntQry = ClsQuery.obtieneSentenciaDeQrys(querys);
	        ClsQuery.ImprimeQuerysConsola(querys, false, "query 13 ");
	        	
	        ResultSet rs = ClsQuery.EjecutarQuery(querys[0].replace("{CDO}", cdo.toUpperCase()), querys[1], querys[2], querys[3], querys[4], querys[5], querys[6], querys[7], querys[8], querys[9], querys[10], querys[11], 
					querys[12], querys[13], querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], querys[21], querys[22], querys[23], querys[24], cdo, pstmt, connBD);
	        
			if(rs != null) {
				while(rs.next()) {
					MetodoPagoYCuenta mp = new MetodoPagoYCuenta();
					mp.setUname(rs.getString("uname"));
					mp.setCve_medio_pago(rs.getString("cve_medio_pago"));
					mp.setNum_cli(rs.getString("num_cli"));
					numCuenta = rs.getString("num_cuenta").toString().replace("0000", "");
					numCuenta = rs.getString("num_cuenta").toString().replace("0000", "");
//					if(numCuenta.toString().trim() != "") 
//					{
//						if(numCuenta.toString().length()>1) {
//							vlrDiv = numCuenta.toString().substring(numCuenta.toString().length() -1,1);
//							if(vlrDiv.equals(",")) 
//							{
//								numCuenta = numCuenta.toString().substring(0,numCuenta.toString().length() -1);
//							}
//						}
//					}
					mp.setNum_cuenta(numCuenta);
					mp.setObservacion(rs.getString("observacion"));
					listMetyPago.add(mp);
				}
			}
			Cls_Log.insertaLog(cdo, listFacP.getFolio_canje(), listFacP.getNum_cli(), "CONSULTA METODO DE PAGO Y NUMERO DE CUENTA ACUMGANE QUERY 13 "+sntQry.replace("´","")+" . ");	
		}catch(Exception e ) {
			////////System.out.println("Error en consultaMetodoPagoNumeroCuenta(): " + e.toString());
			Cls_Log.insertaLog(cdo, listFacP.getFolio_canje(), listFacP.getNum_cli(), "ERROR EN CONSULTA METODO DE PAGO Y NUMERO DE CUENTA ACUMGANE QUERY 13 "+sntQry.replace("´","")+" . ");
		}finally {
			try{if(connBD != null) {connBD.close();}}catch(Exception e) {}
			try{if(pstmt != null) {pstmt.close();}}catch(Exception e) {}
		}
		return listMetyPago;
	}

	private boolean insertaEstructuraTXT(List<Estructura> listEstructura, List<FacConceptosEspeciales> lstFacConcEspeciales,List<MetodoPagoYCuenta> listMetyPago,List<FacPendiente> listFacPe, List<DetallePendiente> listDetP, List<Emisor> listEmisor, List<Receptor> listReceptor,
						List<Concepto> listConc, FacPendiente listFacP, String cdo) {
		boolean rsp = false;
		String sntQry = "";
		double iva = 0.16;
		/*COMPROBANTE*/
		int ren = 0;
		String rTxt = "";
		String serieCfd = "";
		String folioCfd = "";
		String metodo_pago = "99";
		String descuentos = "0.00";
		String total = "";
		double impNeto = 0.0;
		double impBruto = 0.0;
		String obs = "";
		String numFac = "";
		String ode = "";
		String condicionPago = " ";
		String control = "";
		/*EMISOR*/
		String rfc_emi = "";
		String regimenFiscal = "601";
		String nombre_emi = "";
		/*RECEPTOR*/
		String rfc_rec = "";
		String nombre_rec = "";
		String codigo_postal = "";
		String c_UsoCFDI = "";
		String descRuta = "";
		String descTransp = "";
		String calleRec = "";
		String numExterior = "";
		String numInterior = "";
		String colonia = "";
		String ciudadDelegMunic = "";
		String estado = "";
		String numCte = "";
		String numAgente = "";
		String tipoCliente = "";
		String tipoDoctoFt = "";
		String e_mail = "";
		String tipoFac = "";
		/*CONCEPTOS*/
		String c_ClaveProdServ = "";
		String idConcepto = "";
		String cantidad = "";
		String c_ClaveUnidad = "";
		String UNIDAD = "";
		String concepto = "";
		double precio = 0.0;
		double importe = 0.0;
		double descuento = 0.0;
		String base_traslaso = "0.00";
		String imp_traslado = "0.00";
		String tasa_cuota = "0.160000";
		String base_retension = "0.00";
		String imp_retension = "0.00";
		String impuesto_retension = "002";
		String tasa_cuota_retension = "0.00";
		
		Connection connBD = null;	
		PreparedStatement pstmt = null; 
		String[] querys = new String[25];
		try {
			for (DetallePendiente listDetaPe : listDetP) {
				impNeto = (Double.parseDouble(listDetaPe.getCantidad().toString()) * Double.parseDouble(listDetaPe.getPrecio().toString())) + impNeto; 
			}
			iva = impNeto * iva;
            impBruto = impNeto + iva;
            
			for(Estructura estructura : listEstructura) {
				ren = ren +1;
				rTxt = estructura.getDescripcion();
				if(Integer.parseInt(estructura.getId()) == 1) 
				{
					for(FacConceptosEspeciales facConcEspec : lstFacConcEspeciales) 
					{
						serieCfd = facConcEspec.getSerie_cfd().toString().trim();
						folioCfd = facConcEspec.getFolio_cfd().toString().trim();
						//metodo_pago = listMetyPago.get(0).getCve_medio_pago().trim();
						metodo_pago="01";
						control = facConcEspec.getControl().toString().trim();
						if(listFacPe.get(0).getRfc().toString().trim() == "XAXX010101000" || listFacPe.get(0).getRfc().toString().trim() == "XEXX010101000") {
							total = String.valueOf(impNeto);
						}else {
							total = String.valueOf(impBruto);
						}
						obs = facConcEspec.getNum_cli();
						numFac = facConcEspec.getNum_fac();
						ode = facConcEspec.getOde();
												
						connBD = ConexionBD.AbrirConexionBD(cdo);
						List<Querys> listaQuerys = ClsQuery.ConsultaTablaQuerysBD(cdo, connBD);
						querys = ClsQuery.LimpiaListaQuerys(querys);
				        querys = ClsQuery.ObtieneQuerys(16,listaQuerys, querys);
				        querys = inicializaQuery16(querys,cdo,serieCfd,folioCfd,metodo_pago,descuentos,total,condicionPago,String.valueOf(impNeto),obs,numFac,ode);
				        sntQry = ClsQuery.obtieneSentenciaDeQrys(querys);
				        ClsQuery.ImprimeQuerysConsola(querys, false, "query 16 ");				        	
				        ClsQuery.EjecutarQuery(querys[0].replace("{CDO}", cdo.toUpperCase()), querys[1], querys[2], querys[3], querys[4], querys[5], querys[6], querys[7], querys[8], querys[9], querys[10], querys[11], 
								querys[12], querys[13], querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], querys[21], querys[22], querys[23], querys[24], cdo, pstmt, connBD);
				       
				        Cls_Log.insertaLog(cdo, listFacP.getFolio_canje(), listFacP.getNum_cli(), "INSERTA COMPROBANTE ACUMGANE QUERY 16 "+sntQry.replace("´","")+" . "); 
					}
				}
				else if(Integer.parseInt(estructura.getId()) == 2) 
				{
					for(Emisor emi : listEmisor) 
					{
						rfc_emi = emi.getRfc_emi();
						nombre_emi = emi.getNombre_emi();
						connBD = ConexionBD.AbrirConexionBD(cdo);
						List<Querys> listaQuerys = ClsQuery.ConsultaTablaQuerysBD(cdo, connBD);
						querys = ClsQuery.LimpiaListaQuerys(querys);
				        querys = ClsQuery.ObtieneQuerys(17,listaQuerys, querys);
				        querys = inicializaQuery17(querys,cdo,serieCfd,folioCfd,rfc_emi,regimenFiscal, nombre_emi, numFac,ode);
				        sntQry = ClsQuery.obtieneSentenciaDeQrys(querys);
				        ClsQuery.ImprimeQuerysConsola(querys, false, "query 17 ");				        	
				        ClsQuery.EjecutarQuery(querys[0].replace("{CDO}", cdo.toUpperCase()), querys[1], querys[2], querys[3], querys[4], querys[5], querys[6], querys[7], querys[8], querys[9], querys[10], querys[11], 
								querys[12], querys[13], querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], querys[21], querys[22], querys[23], querys[24], cdo, pstmt, connBD);
				        Cls_Log.insertaLog(cdo, listFacP.getFolio_canje(), listFacP.getNum_cli(), "INSERTA EMISOR ACUMGANE QUERY 17 "+sntQry.replace("´","")+" . "); 
					}
				}
				else if(Integer.parseInt(estructura.getId()) == 3) 
				{
					
					for(Receptor rec : listReceptor) 
					{
						rfc_rec = rec.getRfc_rec();
						nombre_rec = rec.getNombre_rec();
						if(rec.getRfc_rec().toString().trim() == "XAXX010101000" || rec.getRfc_rec().toString().trim() == "XEXX010101000") {
							switch(cdo) {
							case "cdf":
								codigo_postal = "09209";
								break;
							case "cd2":
								codigo_postal = "72225";
								break;
							case "cdl":
								codigo_postal = "37390";
								break;
							case "cdm":
								codigo_postal = "66484";
								break;
							}
							
						}else{
							codigo_postal = rec.getCp_rec();
						}
						descTransp = rec.getNom_trasn();
						descRuta = rec.getNomRuta();
						calleRec = rec.getCalle_rec();
						numExterior = rec.getNum_exterior_rec();
						numInterior = rec.getNum_interior_rec();
						colonia = rec.getColonia_rec();
						ciudadDelegMunic = rec.getMunicipio_rec();
						estado = rec.getEstado_rec();
						numCte = rec.getNum_cte();
						numAgente = rec.getAgte();
						regimenFiscal = rec.getRegimenFiscal();
						tipoCliente = rec.getTipo_cliente();
						tipoDoctoFt = rec.getTipo_lf();
						e_mail = rec.getE_mail_rec();
						c_UsoCFDI = listConc.get(0).getC_UsoCFDI();
						connBD = ConexionBD.AbrirConexionBD(cdo);
						List<Querys> listaQuerys = ClsQuery.ConsultaTablaQuerysBD(cdo, connBD);
						querys = ClsQuery.LimpiaListaQuerys(querys);
				        querys = ClsQuery.ObtieneQuerys(18,listaQuerys, querys);
				        querys = inicializaQuery18(querys,cdo,serieCfd,folioCfd,rfc_rec,nombre_rec,codigo_postal,regimenFiscal,c_UsoCFDI,descTransp,descRuta,calleRec,numExterior,numInterior,colonia,codigo_postal,ciudadDelegMunic,estado,control,numCte,
				        			numAgente,tipoFac,tipoCliente,tipoDoctoFt,e_mail,numFac,ode);
				        sntQry = ClsQuery.obtieneSentenciaDeQrys(querys);
				        ClsQuery.ImprimeQuerysConsola(querys, false, "query 18 ");				        	
				        ClsQuery.EjecutarQuery(querys[0].replace("{CDO}", cdo.toUpperCase()), querys[1], querys[2], querys[3], querys[4], querys[5], querys[6], querys[7], querys[8], querys[9], querys[10], querys[11], 
								querys[12], querys[13], querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], querys[21], querys[22], querys[23], querys[24], cdo, pstmt, connBD);
				        Cls_Log.insertaLog(cdo, listFacP.getFolio_canje(), listFacP.getNum_cli(), "INSERTA RECEPTOR ACUMGANE QUERY 18 "+sntQry.replace("´","")+" . ");
					}
				}
				else if(Integer.parseInt(estructura.getId()) == 4) 
				{
//						dtRenglon = new DataTable();
//		                dtRenglon.TableName = "Renglon";
//		                dtRenglon.Columns.Add("concepto");
//		                dtRenglon.Columns.Add("observaciones");
//		                dtRenglon.Columns.Add("precio");
//		                dtRenglon.Columns.Add("cantidad");
//		                dtRenglon.Columns.Add("importe");
//		                dtRenglon.Columns.Add("idConcepto");
//		                
//		                ro = dtRenglon.NewRow();
//	                    ro[0] = descConcepto.ToString().Trim();
//	                    ro[1] = r["articulo"].ToString().Trim() + " " + r["serie"].ToString().Trim() + " " + r["motor"].ToString().Trim() + " " + r["observaciones"].ToString().Trim();
//	                    ro[2] = r["precio"].ToString();
//	                    ro[3] = r["cantidad"].ToString();
//	                    impNeto = (double.Parse(r["cantidad"].ToString()) * double.Parse(r["precio"].ToString())) + impNeto;
//	                    ro[4] = (double.Parse(r["cantidad"].ToString()) * double.Parse(r["precio"].ToString())).ToString();
//	                    ro[5] = cve_concepto.ToString().Trim();
//	                    dtRenglon.Rows.Add(ro);
	                    
	                    int row = 0; 
	                    for (DetallePendiente listDetaPen : listDetP) {
	        				 row = row + 1;
	        				 c_ClaveProdServ = listConc.get(0).getC_ClaveProdServ();
	        				 idConcepto = listFacP.getCve_concepto();
	        				 cantidad = listDetaPen.getCantidad();
	        				 c_ClaveUnidad = listConc.get(0).getC_ClaveUnidad();
	        				 UNIDAD = listConc.get(0).getUnidad();
	        				 concepto =reemplazarCaracteresEspeciales(listConc.get(0).getDescripcion()+" "+listDetaPen.getArticulo()+" "+listDetaPen.getSerie()+" "+listDetaPen.getMotor()+" "+listDetaPen.getObservaciones());
	        				 if(listFacPe.get(0).getRfc().toString().trim() == "XAXX010101000" || listFacPe.get(0).getRfc().toString().trim() == "XEXX010101000") 
	        				 {
	        					 precio = (Double.parseDouble(listDetaPen.getPrecio()) * IVA_CANTIDAD);
	        					 importe = ((Double.parseDouble(listDetaPen.getPrecio())) * (Double.parseDouble(listDetaPen.getCantidad())) * (IVA_CANTIDAD));
	        					 descuento = ((Double.parseDouble(listDetaPen.getPrecio())) * (Double.parseDouble(listDetaPen.getCantidad())) * (IVA_CANTIDAD));
	        				 }else 
	        				 {
	        					 precio = Double.parseDouble(listDetaPen.getPrecio());
	        					 importe = (Double.parseDouble(listDetaPen.getCantidad()) * Double.parseDouble(listDetaPen.getPrecio()));
	        					 descuento = (Double.parseDouble(listDetaPen.getCantidad()) * Double.parseDouble(listDetaPen.getPrecio()));
	        				 }
	        				 
	        				 
	        				connBD = ConexionBD.AbrirConexionBD(cdo);
	 						List<Querys> listaQuerys = ClsQuery.ConsultaTablaQuerysBD(cdo, connBD);
	 						querys = ClsQuery.LimpiaListaQuerys(querys);
	 				        querys = ClsQuery.ObtieneQuerys(19,listaQuerys, querys);
	 				        querys = inicializaQuery19(querys,cdo,serieCfd,folioCfd,row,c_ClaveProdServ,idConcepto,cantidad,c_ClaveUnidad,UNIDAD,concepto,precio,importe,descuento,base_traslaso,imp_traslado,tasa_cuota,base_retension,imp_retension,impuesto_retension,tasa_cuota_retension, numFac,ode);
	 				        sntQry = ClsQuery.obtieneSentenciaDeQrys(querys);
	 				        ClsQuery.ImprimeQuerysConsola(querys, false, "query 19 ");				        	
	 				        ClsQuery.EjecutarQuery(querys[0].replace("{CDO}", cdo.toUpperCase()), querys[1], querys[2], querys[3], querys[4], querys[5], querys[6], querys[7], querys[8], querys[9], querys[10], querys[11], 
	 								querys[12], querys[13], querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], querys[21], querys[22], querys[23], querys[24], cdo, pstmt, connBD);
	 				       Cls_Log.insertaLog(cdo, listFacP.getFolio_canje(), listFacP.getNum_cli(), "INSERTA CONCEPTOS ACUMGANE QUERY 19 "+sntQry.replace("´","")+" . "); 
	        			} 
	                  row = 0;  
	                    
				}
			}
			Cls_Log.insertaLog(cdo, listFacP.getFolio_canje(), listFacP.getNum_cli(), "INSERTAR ESTRUCTURA TXT ACUMGANE QUERYS 16 17 18 19 "+sntQry.replace("´","")+" . ");
			rsp = true;
		}catch(Exception e) {
			//////////System.out.println("Error en insertaEstructuraTXT(): " + e.toString());
			rsp = false;
			Cls_Log.insertaLog(cdo, listFacP.getFolio_canje(), listFacP.getNum_cli(), "ERROR EN INSERTAR ESTRUCTURA TXT ACUMGANE QUERYS 16 17 18 19 "+sntQry.replace("´","")+" . ");
		}finally {
			try{if(connBD != null) {connBD.close();}}catch(Exception e) {}
			try{if(pstmt != null) {pstmt.close();}}catch(Exception e) {}
		}
		return rsp;
	}


	/*CREAR DIRECTORIO*/
	private String ObtieneRutaPDF(String ruta) {
		String rut = ruta;
		File directorio = new File(ruta);
        if (!directorio.exists()) {
            if (directorio.mkdirs()) {
                //////////System.out.println("Directorio creado");
            } else {
                //////////System.out.println("Error al crear directorio");
            }
        }
        return rut;
	}
	
	/*INICIALIZA VARIABLES DE QUERYS*/
	private static String[] inicializaQuery1(String[] ListaQuerys,String cdo) {
		for (int i=0;i <ListaQuerys.length; i++)
		{
			ListaQuerys[i]= ListaQuerys[i].replace("{UNAME}", cdo);
		}
		return ListaQuerys;
	}
	
	private static String[] inicializaQuery6(String[] ListaQuerys,String cdo, FacPendiente facPe) {
		for (int i=0;i <ListaQuerys.length; i++)
		{
			ListaQuerys[i]= ListaQuerys[i].replace("{UNAME}", cdo);
			ListaQuerys[i]= ListaQuerys[i].replace("{FOLIO}", facPe.getFolio_canje());
		}
		return ListaQuerys;
	}
	
	private static String[] inicializaQuery15(String[] ListaQuerys,String cdo, FacPendiente facPe) {
		for (int i=0;i <ListaQuerys.length; i++)
		{
			ListaQuerys[i]= ListaQuerys[i].replace("{CDO}", cdo.toUpperCase());
			ListaQuerys[i]= ListaQuerys[i].replace("{CLIENTE}", facPe.getNum_cli());
		}
		return ListaQuerys;
	}
	private static String[] inicializaQuery14(String[] ListaQuerys,String cdo, FacPendiente facPe, String id_cdo) {
		for (int i=0;i <ListaQuerys.length; i++)
		{
			ListaQuerys[i]= ListaQuerys[i].replace("{CDO}", cdo.toUpperCase());
			ListaQuerys[i]= ListaQuerys[i].replace("{UNAME}", facPe.getUname());
			ListaQuerys[i]= ListaQuerys[i].replace("{CVECONCEPTO}", facPe.getCve_concepto());
			ListaQuerys[i]= ListaQuerys[i].replace("{ID_CDO}", id_cdo);
		}
		return ListaQuerys;
	}
	
	private static String[] inicializaQuery3(String[] ListaQuerys,String cdo, FacPendiente facPe) {
		for (int i=0;i <ListaQuerys.length; i++)
		{
			ListaQuerys[i]= ListaQuerys[i].replace("{CDO}", cdo.toUpperCase());
			ListaQuerys[i]= ListaQuerys[i].replace("{uname_br}", facPe.getUname().trim());
			ListaQuerys[i]= ListaQuerys[i].replace("{uname_cli}", facPe.getUname());
			ListaQuerys[i]= ListaQuerys[i].replace("{numCte}", facPe.getNum_cli());
		}
		return ListaQuerys;
	}
	
	private static String[] inicializaQuery7(String[] ListaQuerys,String cdo, String uname_br) {
		for (int i=0;i <ListaQuerys.length; i++)
		{
			ListaQuerys[i]= ListaQuerys[i].replace("{CDO}", cdo.toUpperCase());
			ListaQuerys[i]= ListaQuerys[i].replace("{UNAME_BR}", uname_br);
		}
		return ListaQuerys;
	}
	
	private static String[] inicializaQuery4(String[] ListaQuerys,String cdo, FacPendiente facPe) {
		for (int i=0;i <ListaQuerys.length; i++)
		{
			ListaQuerys[i]= ListaQuerys[i].replace("{CDO}", cdo.toUpperCase());
			ListaQuerys[i]= ListaQuerys[i].replace("{uname}", facPe.getUname());
		}
		return ListaQuerys;
	}
	
	private static String[] inicializaQuery5(String[] ListaQuerys,String cdo) {
		for (int i=0;i <ListaQuerys.length; i++)
		{
			ListaQuerys[i]= ListaQuerys[i].replace("{CDO}", cdo.toUpperCase());
		}
		return ListaQuerys;
	}
	
	private static String[] inicializaQuery9(String[] ListaQuerys, String cdo, String num_cli, String query1, String query2) {
		for(int i=0;i <ListaQuerys.length; i++) 
		{
			ListaQuerys[i]= ListaQuerys[i].replace("{CDO}", cdo.toUpperCase());
			ListaQuerys[i]= ListaQuerys[i].replace("{uname}", cdo);
			ListaQuerys[i]= ListaQuerys[i].replace("{cliente}", num_cli);
			ListaQuerys[i]= ListaQuerys[i].replace("{RegConcepto}", query1);
			ListaQuerys[i]= ListaQuerys[i].replace("{RegConFact}", query2);
		}
		return ListaQuerys;
	}
	

	private static String[] inicializaQuery10(String[] ListaQuerys, String cdo, String id_cdo, String usuFac, String folio,
			String uname, String num_cli) {
		for(int i=0;i <ListaQuerys.length; i++) 
		{
			ListaQuerys[i]= ListaQuerys[i].replace("{CDO}", cdo.toUpperCase());
			ListaQuerys[i]= ListaQuerys[i].replace("{UNAME}", uname);
			ListaQuerys[i]= ListaQuerys[i].replace("{NUM_CTE}", num_cli);
			ListaQuerys[i]= ListaQuerys[i].replace("{ID_CDO}", id_cdo);
			ListaQuerys[i]= ListaQuerys[i].replace("{CONTROL}", folio);
			ListaQuerys[i]= ListaQuerys[i].replace("{CVE_USU}", usuFac);
		}
		return ListaQuerys;
	}
	
	
	private static String[] inicializaQuery11(String[] ListaQuerys, String cdo, String id_cdo, String uname, String num_cli,String folio) {
		for(int i=0;i <ListaQuerys.length; i++) 
		{
			ListaQuerys[i]= ListaQuerys[i].replace("{CDO}", cdo.toUpperCase());
			ListaQuerys[i]= ListaQuerys[i].replace("{CLIENTE}", num_cli);
			ListaQuerys[i]= ListaQuerys[i].replace("{UNAME}", uname);
			ListaQuerys[i]= ListaQuerys[i].replace("{NUM_CTE}", num_cli);
			ListaQuerys[i]= ListaQuerys[i].replace("{ID_CDO}", id_cdo);
			ListaQuerys[i]= ListaQuerys[i].replace("{FOLIO}", folio);
			
		}
		return ListaQuerys;
	}
	
	private static String[] inicializaQuery12(String[] ListaQuerys, String cdo, String queryHP, String queryDP, String querySP,
			String queryIC, String queryICat) {
		if(queryICat == "") {
			ListaQuerys[4] = "";
		}
		for(int i=0;i <ListaQuerys.length; i++) 
		{
			ListaQuerys[i]= ListaQuerys[i].replace("{CDO}", cdo.toUpperCase());
			ListaQuerys[i]= ListaQuerys[i].replace("{RegHeader}", queryHP);
			ListaQuerys[i]= ListaQuerys[i].replace("{RegDetPedidos}", queryDP);
			ListaQuerys[i]= ListaQuerys[i].replace("{RegSeccPedidos}", querySP);
			ListaQuerys[i]= ListaQuerys[i].replace("{RegComplementaria}", queryIC);
			ListaQuerys[i]= ListaQuerys[i].replace("{regCatalogo}", queryICat);
			
		}
		return ListaQuerys;
	}
	
	private static String[] inicializaQuery13(String[] ListaQuerys, String cdo, String num_cli) {
		for(int i=0;i <ListaQuerys.length; i++) 
		{
			ListaQuerys[i]= ListaQuerys[i].replace("{CDO}", cdo.toUpperCase());
			ListaQuerys[i]= ListaQuerys[i].replace("{UNAME}", cdo.toLowerCase());
			ListaQuerys[i]= ListaQuerys[i].replace("{CLIENTE}", num_cli);
		}
		return ListaQuerys;
	}
	
	private static String[] inicializaQuery16(String[] ListaQuerys,String cdo,String serieCfd,String folioCfd,String metodo_pago, String descuentos, String total,String condicionPago,String impNeto,String obs,String numFac,String ode) {
		for(int i=0;i <ListaQuerys.length; i++) 
		{
			while (folioCfd.length() < 6) {
                if (folioCfd.length() < 6)
                {
                    folioCfd = "0" + folioCfd;
                }
            } 
			ListaQuerys[i]= ListaQuerys[i].replace("{CDO}", cdo.toUpperCase());
			ListaQuerys[i]= ListaQuerys[i].replace("{UNAME}", cdo.toLowerCase());
			ListaQuerys[i]= ListaQuerys[i].replace("{SERIE}", serieCfd);
			ListaQuerys[i]= ListaQuerys[i].replace("{FOLIO}", folioCfd);
			ListaQuerys[i]= ListaQuerys[i].replace("{FECHA_CFDI}", "CURDATE() T CURTIME()");
			ListaQuerys[i]= ListaQuerys[i].replace("{FORMA_PAGO}", metodo_pago);
			ListaQuerys[i]= ListaQuerys[i].replace("{COND_PAGO}", "");
			ListaQuerys[i]= ListaQuerys[i].replace("{IMPOR_DESC}", descuentos);
			ListaQuerys[i]= ListaQuerys[i].replace("{MONEDA}", "MXN");
			ListaQuerys[i]= ListaQuerys[i].replace("{IMP_TOTAL}", total);
			ListaQuerys[i]= ListaQuerys[i].replace("{TIPO_COMPRO}", "FAC");
			ListaQuerys[i]= ListaQuerys[i].replace("{METODO_PAGO}", condicionPago);
			ListaQuerys[i]= ListaQuerys[i].replace("{IMPOR_SUBTOTAL}", impNeto);
			ListaQuerys[i]= ListaQuerys[i].replace("{OBSERVACIONES}", obs);
			ListaQuerys[i]= ListaQuerys[i].replace("{DOCUMENTO}", numFac);
			ListaQuerys[i]= ListaQuerys[i].replace("{DOCUMENTO_CFDI}", serieCfd +"0000"+ folioCfd);
			ListaQuerys[i]= ListaQuerys[i].replace("{ODE}", ode);
			ListaQuerys[i]= ListaQuerys[i].replace("{TIPO_DOCUMENTO}", "1");
			
		}
		return ListaQuerys;
	}
	
	private static String[] inicializaQuery17(String[] ListaQuerys, String cdo, String serieCfd, String folioCfd, String rfc_emi,String regimenFiscal, String nombre_emi, String numFac, String ode) 
	{
		for(int i=0;i <ListaQuerys.length; i++) 
		{
			while (folioCfd.length() < 6) {
                if (folioCfd.length() < 6)
                {
                    folioCfd = "0" + folioCfd;
                }
            } 
			ListaQuerys[i]= ListaQuerys[i].replace("{CDO}", cdo.toUpperCase());
			ListaQuerys[i]= ListaQuerys[i].replace("{UNAME}", cdo.toLowerCase());
			ListaQuerys[i]= ListaQuerys[i].replace("{SERIE}", serieCfd);
			ListaQuerys[i]= ListaQuerys[i].replace("{FOLIO}", folioCfd);			
			ListaQuerys[i]= ListaQuerys[i].replace("{RFC}", rfc_emi);
			ListaQuerys[i]= ListaQuerys[i].replace("{REGIMEN_FISCAL}", regimenFiscal);
			ListaQuerys[i]= ListaQuerys[i].replace("{NOMBRE}", nombre_emi);
			ListaQuerys[i]= ListaQuerys[i].replace("{FAC_ATRADQUIRENTE}", "");
			ListaQuerys[i]= ListaQuerys[i].replace("{DOCUMENTO}", numFac);
			ListaQuerys[i]= ListaQuerys[i].replace("{DOCUMENTO_CFDI}", serieCfd +"0000"+ folioCfd);
			ListaQuerys[i]= ListaQuerys[i].replace("{ODE}", ode);
			
		}
		return ListaQuerys;
	}
	
	private static String[] inicializaQuery18(String[] ListaQuerys, String cdo, String serieCfd, String folioCfd, String rfc_rec,String nombre_rec, String codigo_postal, String regimenFiscal, String c_UsoCFDI, 
			String descTransp,String descRuta, String calleRec, String numExterior, String numInterior, String colonia,String codigo_postal2, String ciudadDelegMunic, String estado, String control, String numCte,
			String numAgente, String tipoFac, String tipoCliente, String tipoDoctoFt, String e_mail, String numFac,String ode) 
	{
		for(int i=0;i <ListaQuerys.length; i++) 
		{
			while (folioCfd.length() < 6) {
                if (folioCfd.length() < 6)
                {
                    folioCfd = "0" + folioCfd;
                }
            } 
			ListaQuerys[i]= ListaQuerys[i].replace("{CDO}", cdo.toUpperCase());
			ListaQuerys[i]= ListaQuerys[i].replace("{UNAME}", cdo.toLowerCase());
			ListaQuerys[i]= ListaQuerys[i].replace("{SERIE}", serieCfd);
			ListaQuerys[i]= ListaQuerys[i].replace("{FOLIO}", folioCfd);		
			ListaQuerys[i]= ListaQuerys[i].replace("{RFC}", rfc_rec);
			ListaQuerys[i]= ListaQuerys[i].replace("{NOMBRE}", nombre_rec);
			ListaQuerys[i]= ListaQuerys[i].replace("{DOMICILIO_FISCAL}", codigo_postal);
			ListaQuerys[i]= ListaQuerys[i].replace("{RESIDENCIA_FISCAL}", "");
			ListaQuerys[i]= ListaQuerys[i].replace("{NUM_REG_TRIB}", "");
			ListaQuerys[i]= ListaQuerys[i].replace("{REG_FISCAL_REC}", regimenFiscal);
			ListaQuerys[i]= ListaQuerys[i].replace("{USO_CFDI}", c_UsoCFDI);
			ListaQuerys[i]= ListaQuerys[i].replace("{ETIQU_TRANSP}", descTransp);
			ListaQuerys[i]= ListaQuerys[i].replace("{ETIQU_RUTA}", descRuta);
			ListaQuerys[i]= ListaQuerys[i].replace("{ETIQU_CALLE}", calleRec);
			ListaQuerys[i]= ListaQuerys[i].replace("{ETIQU_NO_EXT}", numExterior);
			ListaQuerys[i]= ListaQuerys[i].replace("{ETIQU_NO_INT}", numInterior);
			ListaQuerys[i]= ListaQuerys[i].replace("{ETIQU_COLONIA}", colonia);
			ListaQuerys[i]= ListaQuerys[i].replace("{ETIQ_CP}", codigo_postal);
			ListaQuerys[i]= ListaQuerys[i].replace("{ETIQU_MUNICI}", ciudadDelegMunic);
			ListaQuerys[i]= ListaQuerys[i].replace("{ETIQU_ESTADO}", estado);
			ListaQuerys[i]= ListaQuerys[i].replace("{ETIQU_PEDIDO}", control);
			ListaQuerys[i]= ListaQuerys[i].replace("{ETIQU_NUM_CLI}", numCte);
			ListaQuerys[i]= ListaQuerys[i].replace("{ETIQ_AGEN}", numAgente);
			ListaQuerys[i]= ListaQuerys[i].replace("{ETIQ_COND_CRED}", "");
			ListaQuerys[i]= ListaQuerys[i].replace("{ETIQ_TIPO_FAC}", tipoFac);
			ListaQuerys[i]= ListaQuerys[i].replace("{ETIQU_TIPO_CTE}", tipoCliente);
			ListaQuerys[i]= ListaQuerys[i].replace("{ETIQU_TIPO_DOCTO}", tipoDoctoFt);
			ListaQuerys[i]= ListaQuerys[i].replace("{ETIQU_MAIL}", e_mail);
			ListaQuerys[i]= ListaQuerys[i].replace("{DOCUMENTO}", numFac);
			ListaQuerys[i]= ListaQuerys[i].replace("{DOCUMENTO_CFDI}", serieCfd +"0000"+ folioCfd);
			ListaQuerys[i]= ListaQuerys[i].replace("{ODE}", ode);
		}
		return ListaQuerys;
	}
	
	private static String[] inicializaQuery19(String[] ListaQuerys, String cdo, String serieCfd, String folioCfd, int row,
			String c_ClaveProdServ, String idConcepto, String cantidad, String c_ClaveUnidad, String uNIDAD,
			String concepto, double precio, double importe, double descuento, String base_traslaso, String imp_traslado,
			String tasa_cuota, String base_retension, String imp_retension, String impuesto_retension,
			String tasa_cuota_retension, String numFac, String ode) 
	{
		for(int i=0;i <ListaQuerys.length; i++) 
		{
			while (folioCfd.length() < 6) {
                if (folioCfd.length() < 6)
                {
                    folioCfd = "0" + folioCfd;
                }
            } 
			ListaQuerys[i]= ListaQuerys[i].replace("{CDO}", cdo.toUpperCase());
			ListaQuerys[i]= ListaQuerys[i].replace("{UNAME}", cdo.toLowerCase());
			ListaQuerys[i]= ListaQuerys[i].replace("{SERIE}", serieCfd);
			ListaQuerys[i]= ListaQuerys[i].replace("{FOLIO}", folioCfd);			
			ListaQuerys[i]= ListaQuerys[i].replace("{NUM_REG}", String.valueOf(row));
			ListaQuerys[i]= ListaQuerys[i].replace("{C_CLAVE_PROD_SERV}", c_ClaveProdServ);
			ListaQuerys[i]= ListaQuerys[i].replace("{NO_IDENTI}", idConcepto);
			ListaQuerys[i]= ListaQuerys[i].replace("{CANTIDAD}", cantidad);
			ListaQuerys[i]= ListaQuerys[i].replace("{CLAVE_UNIDAD}", c_ClaveUnidad);
			ListaQuerys[i]= ListaQuerys[i].replace("{UNIDAD}", uNIDAD);
			ListaQuerys[i]= ListaQuerys[i].replace("{DESCRIPCION}", concepto);
			ListaQuerys[i]= ListaQuerys[i].replace("{VALOR_UNIT}", String.valueOf(precio));
			ListaQuerys[i]= ListaQuerys[i].replace("{IMPORTE}", String.valueOf(importe));
			ListaQuerys[i]= ListaQuerys[i].replace("{DESCUENTO}", String.valueOf(descuento));
			ListaQuerys[i]= ListaQuerys[i].replace("{BASE_TRASL}", base_traslaso);
			ListaQuerys[i]= ListaQuerys[i].replace("{IMPORTE_TRASLADO}", imp_traslado);
			ListaQuerys[i]= ListaQuerys[i].replace("{TASA_CUOTA_TRAS}", tasa_cuota);
			ListaQuerys[i]= ListaQuerys[i].replace("{BASE_RETEN}", base_retension);
			ListaQuerys[i]= ListaQuerys[i].replace("{IMPOR_RETEN}", imp_retension);
			ListaQuerys[i]= ListaQuerys[i].replace("{IMPUES_RETEN}", impuesto_retension);
			ListaQuerys[i]= ListaQuerys[i].replace("{TASA_CUOTA_RETEN}", tasa_cuota_retension);
			ListaQuerys[i]= ListaQuerys[i].replace("{DOCUMENTO}", numFac);
			ListaQuerys[i]= ListaQuerys[i].replace("{DOCUMENTO_CFDI}", serieCfd +"0000"+ folioCfd);
			ListaQuerys[i]= ListaQuerys[i].replace("{ODE}", ode);
			 
		}
		return ListaQuerys;
	}
	

	private String[] inicializaQuery20(String[] ListaQuerys, String cdo) {
		for(int i=0;i <ListaQuerys.length; i++) 
		{
			ListaQuerys[i]= ListaQuerys[i].replace("{CDO}", cdo.toUpperCase());	
		}
		return ListaQuerys;
	}
	
	private String reemplazarCaracteresEspeciales(String palabra) {
        String[] caracteresMalos = {"ñ","à","á","À","Á","è","é","È","É","ì","í","Ì","Í","ò","ó","Ò","Ó","ù","ú","Ù","Ú","-","Ñ"};
        String[] caracteresBuenos = {"n","a","a","A","A","e","e","E","E","i","i","I","I","o","o","O","O","u","u","U","U"," ","N"};

        for (String letraMala : caracteresMalos) {
            if(palabra.contains(letraMala)){
                palabra = palabra.replace(letraMala,caracteresBuenos[Arrays.asList(caracteresMalos).indexOf(letraMala)]);
            }
        }

        return palabra;

    }
	
}
