package cdo.Persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import cdo.Datos.Detalles;
import cdo.Datos.LogPDF;
import cdo.Datos.Querys;
import cdo.Util.ClsQuery;
import cdo.Util.Cls_Logs;

public class GestorProcesos {

	public static List<Detalles> recuperaDescripcion(String cdo, Connection connBD, PreparedStatement pstmt,
			List<Querys> listaQuerys, String serie, String folio) {
		String[] querys = new String[25];
		List<Detalles> descripcion = new ArrayList<>(); 
		try {			   
	        querys = ClsQuery.LimpiaListaQuerys(querys);
	        querys = ClsQuery.ObtieneQuerys(1,listaQuerys, querys); 
	        querys = inicializaQueryNumero1(querys, serie,folio);
	        ClsQuery.ImprimeQuerysConsola(querys, false, "query 1 ");
	        ResultSet rs = ClsQuery.EjecutarQuery(querys[0], querys[1], querys[2], querys[3], querys[4], querys[5], querys[6], querys[7], querys[8], querys[9], querys[10], querys[11], 
					querys[12], querys[13], querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], querys[21], querys[22], querys[23], querys[24], cdo, pstmt, connBD);
	        while (rs.next())
            {
                try
                {	
                	Detalles det= new Detalles();
                	det.setSerie(serie);
                	det.setFolio(folio);
                	det.setDescripcion(rs.getString("descripcion"));
                	det.setFecha(rs.getString("fecha_pro"));
                	det.setHora(rs.getString("hora_pro"));
                	descripcion.add(det);
                }
                catch (Exception e) 
                {	                	 
                    System.out.println( "Error al obtener decripcion de log: "+ e.toString());
                }
            }
		
		}catch(Exception e) {
			Cls_Logs.insertarLog(new LogPDF(),cdo,"","","Error: No se encontro registro del folio: "+folio+" y serie: "+serie+" Metodo: recuperaDescripcion");
			System.out.println("Error al entrar al metodo recuperaDescripcion: " + e);
		}
		return descripcion;
	}

	private static String[] inicializaQueryNumero1(String[] querys, String serie, String folio) {
		for (int i=0;i <querys.length; i++)
		{	
			querys[i]=querys[i].replace("{SERIE}", String.valueOf(serie));
			querys[i]=querys[i].replace("{FOLIO}", String.valueOf(folio));
		}
		return querys;
	}

	public static List<String> consultarCorreos(String cdo, Connection connBD, PreparedStatement pstmt,
			List<Querys> listaQuerys) {
			String[] querys = new String[25];
			List<String> correos=new ArrayList<>(); 
			try {			   
		        querys = ClsQuery.LimpiaListaQuerys(querys);
		        querys = ClsQuery.ObtieneQuerys(2,listaQuerys, querys); 
		        ClsQuery.ImprimeQuerysConsola(querys, false, "query 2 ");
		        ResultSet rs = ClsQuery.EjecutarQuery(querys[0], querys[1], querys[2], querys[3], querys[4], querys[5], querys[6], querys[7], querys[8], querys[9], querys[10], querys[11], 
						querys[12], querys[13], querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], querys[21], querys[22], querys[23], querys[24], cdo, pstmt, connBD);
		        while (rs.next())
	            {
	                try
	                {
	                	correos.add(rs.getString("correo"));
	                }
	                catch (Exception e) 
	                {	                	 
	                    System.out.println( "Error al obtener correos de log: "+ e.toString());
	                }
	            }
			
			}catch(Exception e) {
				Cls_Logs.insertarLog(new LogPDF(),cdo,"proceso","172","Error: No se pudo recuperar el correo Metodo: consultarCorreos");
				System.out.println("Error al entrar al metodo consultarCorreos: " + e);
			}
			return correos;
	}
	public static String recuperaRemitente(String cdo, Connection connBD, PreparedStatement pstmt, List<Querys> listaQuerys) {
		String[] querys = new String[25];
		String remitente = ""; 
		try {			   
	        querys = ClsQuery.LimpiaListaQuerys(querys);
	        querys = ClsQuery.ObtieneQuerys(3,listaQuerys, querys); 
	        ClsQuery.ImprimeQuerysConsola(querys, false, "query 2 ");
	        ResultSet rs = ClsQuery.EjecutarQuery(querys[0], querys[1], querys[2], querys[3], querys[4], querys[5], querys[6], querys[7], querys[8], querys[9], querys[10], querys[11], 
					querys[12], querys[13], querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], querys[21], querys[22], querys[23], querys[24], cdo, pstmt, connBD);
	        while (rs.next())
            {
                try
                {
                	remitente = rs.getString("remitente");
                }
                catch (Exception e) 
                {	                
                	Cls_Logs.insertarLog(new LogPDF(),cdo,"","","No se pudo recuperar la pass");
                    //System.out.println( "Error al obtener Ruta de almacenamiento: "+ e.toString());
                }
            }
		
		}catch(Exception e) {
			Cls_Logs.insertarLog(new LogPDF(),cdo,"","","No se pudo recuperar la remitente");
			//System.out.println("Error al entrar al metodo RecuperaRuta: " + e);
		}
		return remitente;
	}
	public static String recuperaPass(String cdo, Connection connBD, PreparedStatement pstmt,
			List<Querys> listaQuerys) {
		String[] querys = new String[25];
		String pass = ""; 
		try {			   
	        querys = ClsQuery.LimpiaListaQuerys(querys);
	        querys = ClsQuery.ObtieneQuerys(4,listaQuerys, querys); 
	        ClsQuery.ImprimeQuerysConsola(querys, false, "query  ");
	        ResultSet rs = ClsQuery.EjecutarQuery(querys[0], querys[1], querys[2], querys[3], querys[4], querys[5], querys[6], querys[7], querys[8], querys[9], querys[10], querys[11], 
					querys[12], querys[13], querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], querys[21], querys[22], querys[23], querys[24], cdo, pstmt, connBD);
	        while (rs.next())
            {
                try
                {
                	pass = rs.getString("pass");
                }
                catch (Exception e) 
                {	               
                	Cls_Logs.insertarLog(new LogPDF(),cdo,"","","No se pudo recuperar la pass");
                   // System.out.println( "Error al obtener Ruta de almacenamiento: "+ e.toString());
                }
            }
		
		}catch(Exception e) {
			Cls_Logs.insertarLog(new LogPDF(),cdo,"","","No se pudo recuperar la pass");
			//System.out.println("Error al entrar al metodo RecuperaRuta: " + e);
		}
		return pass;
	}

}
