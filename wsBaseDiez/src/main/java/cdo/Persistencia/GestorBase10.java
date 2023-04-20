package cdo.Persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import cdo.Datos.Datos;
import cdo.Datos.Querys;
import cdo.Util.ClsQuery;

public class GestorBase10 {
	public static Datos recuperaDatos(String cdo, Connection connBD, PreparedStatement pstmt,
			List<Querys> listaQuerys) {
		Datos d=new Datos();
		String[] querys = new String[25];
		try {			   
	        querys = ClsQuery.LimpiaListaQuerys(querys);
	        querys = ClsQuery.ObtieneQuerys(1,listaQuerys, querys); 
	        querys = inicializaQuery1(cdo,querys);
	        ClsQuery.ImprimeQuerysConsola(querys, false, "query 1");
	        ResultSet rs = ClsQuery.EjecutarQuery(querys[0], querys[1], querys[2], querys[3], querys[4], querys[5], querys[6], querys[7], querys[8], querys[9], querys[10], querys[11], 
					querys[12], querys[13], querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], querys[21], querys[22], querys[23], querys[24], cdo, pstmt, connBD);
	        while (rs.next())
            {
                try
                {
                	d.setRean(rs.getString("referencia"));
                	d.setRen(rs.getString("valor"));
                }
                catch (Exception e) 
                {	                
                //	Cls_Logs.insertarLog(new LogPDF(),cdo,"","","No se pudo recuperar la pass");
                    //System.out.println( "Error al obtener Ruta de almacenamiento: "+ e.toString());
                }
            }
		
		}catch(Exception e) {
			//Cls_Logs.insertarLog(new LogPDF(),cdo,"","","No se pudo recuperar la remitente");
			//System.out.println("Error al entrar al metodo RecuperaRuta: " + e);
		}
		return d;
	}
	private static String[] inicializaQuery1(String cdo, String[] ListaQuerys) {
		for (int i=0;i <ListaQuerys.length; i++)
		{
				ListaQuerys[i]= ListaQuerys[i].replace("{CDO}", cdo);
				
		}
		return ListaQuerys;
	}
	public static boolean cambiaRefCliente(String cdo, Connection connBD, PreparedStatement pstmt,
			List<Querys> listaQuerys, String referencia,String cliente) {
		boolean r=false;
		String[] querys = new String[25];
		try {			   
	        querys = ClsQuery.LimpiaListaQuerys(querys);
	        querys = ClsQuery.ObtieneQuerys(2,listaQuerys, querys); 
	        querys = inicializaQuery2(cdo,referencia,cliente,querys);
	        ClsQuery.ImprimeQuerysConsola(querys, false, "query 1");
	        ClsQuery.EjecutarQuery(querys[0], querys[1], querys[2], querys[3], querys[4], querys[5], querys[6], querys[7], querys[8], querys[9], querys[10], querys[11], 
					querys[12], querys[13], querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], querys[21], querys[22], querys[23], querys[24], cdo, pstmt, connBD);
	        r=true;
		
		}catch(Exception e) {
			//Cls_Logs.insertarLog(new LogPDF(),cdo,"","","No se pudo recuperar la remitente");
			//System.out.println("Error al entrar al metodo RecuperaRuta: " + e);
		}
		return r;
	}
	private static String[] inicializaQuery2(String cdo, String referencia, String cliente, String[] ListaQuerys) {
		for (int i=0;i <ListaQuerys.length; i++)
		{
				//ListaQuerys[i]= ListaQuerys[i].replace("{CDO}", cdo);
				ListaQuerys[i]= ListaQuerys[i].replace("{CLIENTE}", cliente);
				ListaQuerys[i]= ListaQuerys[i].replace("{REFERENCIA}", referencia);
				
		}
		return ListaQuerys;
	}
	public static List<String> traeClientes(String cdo, Connection connBD, PreparedStatement pstmt,
			List<Querys> listaQuerys) {
		List<String> d=new ArrayList<String>();
		String[] querys = new String[25];
		try {			   
	        querys = ClsQuery.LimpiaListaQuerys(querys);
	        querys = ClsQuery.ObtieneQuerys(3,listaQuerys, querys); 
	        querys = inicializaQuery1(cdo,querys);
	        ClsQuery.ImprimeQuerysConsola(querys, true, "query 3");
	        ResultSet rs = ClsQuery.EjecutarQuery(querys[0], querys[1], querys[2], querys[3], querys[4], querys[5], querys[6], querys[7], querys[8], querys[9], querys[10], querys[11], 
					querys[12], querys[13], querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], querys[21], querys[22], querys[23], querys[24], cdo, pstmt, connBD);
	        while (rs.next())
            {
                try
                {
                	d.add(rs.getString("num_cte"));
                }
                catch (Exception e) 
                {	                
                //	Cls_Logs.insertarLog(new LogPDF(),cdo,"","","No se pudo recuperar la pass");
                    //System.out.println( "Error al obtener Ruta de almacenamiento: "+ e.toString());
                }
            }
		
		}catch(Exception e) {
			//Cls_Logs.insertarLog(new LogPDF(),cdo,"","","No se pudo recuperar la remitente");
			//System.out.println("Error al entrar al metodo RecuperaRuta: " + e);
		}
		return d;
	}
}
