package Persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Datos.Pendientes;
import Datos.Querys;
import Util.ClsQuery;

public class GestorSellado {
	public static List<Pendientes> recuperaPendientes(String cdo, Connection connBD, PreparedStatement pstmt,
			List<Querys> listaQuerys, String estatus,String cliente) {
		String[] querys = new String[25];
		List<Pendientes> pendientes = new ArrayList<>(); 
		try {			   
	        querys = ClsQuery.LimpiaListaQuerys(querys);
	        querys = ClsQuery.ObtieneQuerys(1,listaQuerys, querys); 
	        querys = inicializaQuery(cdo,estatus,cliente,querys);
	        ClsQuery.ImprimeQuerysConsola(querys, false, "query 1");
	        ResultSet rs = ClsQuery.EjecutarQuery(querys[0], querys[1], querys[2], querys[3], querys[4], querys[5], querys[6], querys[7], querys[8], querys[9], querys[10], querys[11], 
					querys[12], querys[13], querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], querys[21], querys[22], querys[23], querys[24], cdo, pstmt, connBD);
	        while (rs.next())
            {
                try
                {
                	Pendientes p = new Pendientes();
                	p.setFolio(rs.getString("folio"));
                	p.setSerie(rs.getString("Serie"));
                	p.setTipoDoc(rs.getInt("tipo_documento"));
                	p.setImporteTotal(rs.getDouble("importe_total"));
                	pendientes.add(p);
                }
                catch (Exception e) 
                {	                	 
                    System.out.println( "Error al obtener Pendientes "+ e.toString());
                }
            }
		
		}catch(Exception e) {
			//Cls_Logs.insertarLog(new LogPDF(),cdo,"","","No se pudo recuperar la cadena del PDF del folio: "+folio+", serie: "+serie);
			//System.out.println("Error al entrar al metodo RecuperaRuta: " + e);
		}
		return pendientes;
	}

	private static String[] inicializaQuery(String cdo, String estatus, String cliente,String[] querys) {
		System.out.println();
		for(int i=0;i<querys.length;i++) {
			querys[i]=querys[i].replace("{ESTATUS}", estatus);
			querys[i]=querys[i].replace("{NUM_CLIENTE}",cliente);
		}
		if(estatus.equals("2")) {
			querys[13]=querys[14];
			querys[14]="";
			querys[15]="";
		}else if(estatus.equals("3")) {
			querys[13]=querys[15];
			querys[14]="";
			querys[15]="";
		}else {
			querys[14]="";
			querys[15]="";
		}
		
	
		return querys;
	}

	public static String recuperaImpresora(String cdo, Connection connBD, PreparedStatement pstmt,
			List<Querys> listaQuerys, String serie, String folio) {
		String[] querys = new String[25];
		String impresora = ""; 
		try {			   
	        querys = ClsQuery.LimpiaListaQuerys(querys);
	        querys = ClsQuery.ObtieneQuerys(2,listaQuerys, querys); 
	        querys = inicializaQuery2(cdo,serie,folio,querys);
	        ClsQuery.ImprimeQuerysConsola(querys, false, "query 2 ");
	        ResultSet rs = ClsQuery.EjecutarQuery(querys[0], querys[1], querys[2], querys[3], querys[4], querys[5], querys[6], querys[7], querys[8], querys[9], querys[10], querys[11], 
					querys[12], querys[13], querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], querys[21], querys[22], querys[23], querys[24], cdo, pstmt, connBD);
	        while (rs.next())
            {
                try
                {
                	impresora=rs.getString("impresora");
                }
                catch (Exception e) 
                {	                	 
                    System.out.println( "Error al obtener Pendientes "+ e.toString());
                }
            }
		
		}catch(Exception e) {
			//Cls_Logs.insertarLog(new LogPDF(),cdo,"","","No se pudo recuperar la cadena del PDF del folio: "+folio+", serie: "+serie);
			//System.out.println("Error al entrar al metodo RecuperaRuta: " + e);
		}
		return impresora;
	}

	private static String[] inicializaQuery2(String cdo, String serie, String folio, String[] querys) {
		for(int i=0;i<querys.length;i++) {
			querys[i]=querys[i].replace("{SERIE}", serie);
			querys[i]=querys[i].replace("{FOLIO}", folio);
		}
		return querys;
	}

	public static void cambiaEstatus(String cdo, Connection connBD, PreparedStatement pstmt, List<Querys> listaQuerys,
			String serie, String folio, String estatus, int tipoDoc) {
		String[] querys = new String[25];
		try {			   
	        querys = ClsQuery.LimpiaListaQuerys(querys);
	       
	        if(tipoDoc!=6) {
	        	 querys = ClsQuery.ObtieneQuerys(3,listaQuerys, querys); 
	        	querys = inicializaQuery3(cdo,serie,folio,estatus,querys);
	        }else {
	        	 querys = ClsQuery.ObtieneQuerys(5,listaQuerys, querys); 
	        	querys = inicializaQuery3(cdo,serie,folio,estatus,querys);
	        }
	        ClsQuery.ImprimeQuerysConsola(querys, false, "query 2 ");
	        ClsQuery.EjecutarQuery(querys[0], querys[1], querys[2], querys[3], querys[4], querys[5], querys[6], querys[7], querys[8], querys[9], querys[10], querys[11], 
					querys[12], querys[13], querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], querys[21], querys[22], querys[23], querys[24], cdo, pstmt, connBD);
	       
		
		}catch(Exception e) {
			//Cls_Logs.insertarLog(new LogPDF(),cdo,"","","No se pudo recuperar la cadena del PDF del folio: "+folio+", serie: "+serie);
			//System.out.println("Error al entrar al metodo RecuperaRuta: " + e);
		}
	
	}

	private static String[] inicializaQuery3(String cdo, String serie, String folio, String estatus, String[] querys) {
		for(int i=0;i<querys.length;i++) {
			querys[i]=querys[i].replace("{SERIE}", serie);
			querys[i]=querys[i].replace("{FOLIO}", folio);
			querys[i]=querys[i].replace("{ESTATUS}", estatus);
		}
		return querys;
	}

	public static List<Pendientes> recuperaPagosPendientes(String cdo, Connection connBD, PreparedStatement pstmt,
			List<Querys> listaQuerys, String estatus) {
		String[] querys = new String[25];
		List<Pendientes> pendientes = new ArrayList<>(); 
		try {
			querys = ClsQuery.LimpiaListaQuerys(querys);
		    querys = ClsQuery.ObtieneQuerys(6,listaQuerys, querys); 
		    querys = inicializaQuery(cdo,estatus,querys);
		    ClsQuery.ImprimeQuerysConsola(querys, false, "query 6");
		    ClsQuery.EjecutarQuery(querys[0], querys[1], querys[2], querys[3], querys[4], querys[5], querys[6], querys[7], querys[8], querys[9], querys[10], querys[11], 
			querys[12], querys[13], querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], querys[21], querys[22], querys[23], querys[24], cdo, pstmt, connBD);
			querys = ClsQuery.LimpiaListaQuerys(querys);
		    querys = ClsQuery.ObtieneQuerys(7,listaQuerys, querys); 
		    querys = inicializaQuery(cdo,estatus,querys);
		    ClsQuery.ImprimeQuerysConsola(querys, false, "query 7");
		    ClsQuery.EjecutarQuery(querys[0], querys[1], querys[2], querys[3], querys[4], querys[5], querys[6], querys[7], querys[8], querys[9], querys[10], querys[11], 
			querys[12], querys[13], querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], querys[21], querys[22], querys[23], querys[24], cdo, pstmt, connBD);
	        querys = ClsQuery.LimpiaListaQuerys(querys);
	        querys = ClsQuery.ObtieneQuerys(4,listaQuerys, querys); 
	        querys = inicializaQuery(cdo,estatus,querys);
	        ClsQuery.ImprimeQuerysConsola(querys, false, "query 4");
	        ResultSet rs = ClsQuery.EjecutarQuery(querys[0], querys[1], querys[2], querys[3], querys[4], querys[5], querys[6], querys[7], querys[8], querys[9], querys[10], querys[11], 
					querys[12], querys[13], querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], querys[21], querys[22], querys[23], querys[24], cdo, pstmt, connBD);
	        while (rs.next())
            {
                try
                {
                	Pendientes p = new Pendientes();
                	p.setFolio(rs.getString("folio"));
                	p.setSerie(rs.getString("Serie"));
                	p.setTipoDoc(rs.getInt("tipo_documento"));
                	p.setImporteTotal(rs.getDouble("importe_total"));
                	pendientes.add(p);
                }
                catch (Exception e) 
                {	                	 
                    System.out.println( "Error al obtener Pendientes "+ e.toString());
                }
            }
		
		}catch(Exception e) {
			//Cls_Logs.insertarLog(new LogPDF(),cdo,"","","No se pudo recuperar la cadena del PDF del folio: "+folio+", serie: "+serie);
			//System.out.println("Error al entrar al metodo RecuperaRuta: " + e);
		}
		return pendientes;
	}

	private static String[] inicializaQuery(String cdo, String estatus, String[] querys) {
		for(int i=0;i<querys.length;i++) {
			querys[i]=querys[i].replace("{ESTATUS}", estatus);
		}
		return querys;
	}
}
