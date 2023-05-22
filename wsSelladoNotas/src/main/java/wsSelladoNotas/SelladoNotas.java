package wsSelladoNotas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import Datos.Pendientes;
import Datos.Querys;
import Persistencia.GestorSellado;
import Persistencia.ShellSellado;
import Persistencia.wsSellado;
import Util.ClsQuery;
import Util.Cls_Logs;
import Util.ConexionBD;

public class SelladoNotas{
	
	
	
	public static void main(String[] args) {
		System.out.println(sellaNotas("cdf","0","0"));
	}
	public static List<String> log =new ArrayList<>();
    public static String sellaNotas(String cdo, String estatus, String numeroCliente){
    	log.add(date()+" Entra a wsSellaNotas cdo: "+cdo+" estatus: "+estatus+" numCliente: "+numeroCliente);
		String valida="false";
		List<Pendientes> pendientes= new ArrayList<>();
		if(numeroCliente==null||(numeroCliente.replaceAll(" ", "")).length()<=0) {
			numeroCliente="0";
		}
		System.out.println("Num: "+numeroCliente);
		 pendientes=traePendientes(cdo,estatus,numeroCliente);
		//pendientes.addAll(traePagosPendientes(cdo,estatus));
		if(pendientes.size()>0) {
			valida=sellaPendientes(cdo,pendientes,estatus);
		}else {
			valida="No hay pendientes";
		}
		log.add(date()+" Sale de wsSellaNotas "+valida);
		String log2="";
		for(int i=0;i<log.size();i++) {
			log2+=log.get(i)+"\n";
		}
		Cls_Logs.insertarLog(cdo, "NOTAS", "178", log2);
		return valida;
	
	}
	private static List<Pendientes> traePagosPendientes(String cdo, String estatus) {
		Connection connBD = null;
		List<Pendientes> pendientes= new ArrayList<>();
    	try
    	{	
    		log.add(date()+" Entra a traePendientes ");
	    	connBD = ConexionBD.AbrirConexionBD(cdo);
	    	List<Querys> listaQuerys = ClsQuery.ConsultaTablaQuerysBD(cdo, connBD);
	    	PreparedStatement pstmt = null; 	      	
	    	pendientes = GestorSellado.recuperaPagosPendientes(cdo,connBD,pstmt,listaQuerys, estatus);    
	    	log.add(date()+" Sale de traePagosPendientes con: "+pendientes.size()+" pendientes");
    	}
    	  catch(Exception ex)
    	{
    		System.out.println("Error En metodo consultaDescripcion " + ex.toString() );
    	}finally
		{
			try {connBD.close();} catch (SQLException e) {e.printStackTrace();}
		}
		return pendientes;
	}
	private static String sellaPendientes(String cdo, List<Pendientes> pendientes, String estatus){
		log.add(date()+" Entra a sellaPendientes ");
		String valida="false";
		wsSellado s = new wsSellado();
		for(Pendientes p: pendientes) {
			 try {
				 Thread.sleep(2000);
			if(estatus.equals("0")) {
				//cambiaEstatus(p,cdo, "2");
			}
			if((p.getImporteTotal()==0.0||p.getImporteTotal()<=0.0)/*&&p.getTipoDoc()<6*/){
				//cambiaEstatus(p,cdo,"9");
			}else {
				if(p.getTipoDoc()<=3) {
					
					//String impresora = traeImpresora(cdo,p.getSerie(),p.getFolio());
					//ShellSellado.sellaCFDI(cdo, p.getSerie(), p.getFolio(), impresora);
					//Cls_Logs.insertarLog(cdo, p.getSerie(), p.getFolio(), date()+" Se sello factura por jar de selladoNotas");
					System.out.println("serie: "+p.getSerie()+" folio: "+p.getFolio());
					valida="true";
				}else {
				//System.out.println("entre");
					//s.sella(cdo,p.getSerie(),p.getFolio());
					//Cls_Logs.insertarLog(cdo, p.getSerie(), p.getFolio(), date()+" Se sello nota o cargo por jar de selladoNotas");
					//System.out.print("SELLADO MENOR A 3");
					System.out.println("serie: "+p.getSerie()+" folio: "+p.getFolio());
					valida="true";
				}
			}
			 } catch (InterruptedException e) {

				 log.add(date()+"Error al sellar serie: "+p.getSerie()+" folio: "+p.getFolio());
				 valida="false";
	       }
		}
		log.add(date()+" Sale de sellaPendientes "+valida);
		return valida;
	}
	private static String traeImpresora(String cdo, String serie, String folio) {
		Connection connBD = null;
		String impresora="";
    	try
    	{
	    	connBD = ConexionBD.AbrirConexionBD(cdo);
	    	List<Querys> listaQuerys = ClsQuery.ConsultaTablaQuerysBD(cdo, connBD);
	    	PreparedStatement pstmt = null; 	      	
	    	impresora = GestorSellado.recuperaImpresora(cdo,connBD,pstmt,listaQuerys, serie,folio);     	        
    	}
    	  catch(Exception ex)
    	{
    		System.out.println("Error En metodo consultaDescripcion " + ex.toString() );
    	}finally
		{
			try {connBD.close();} catch (SQLException e) {e.printStackTrace();}
		}
		return impresora;
	}
	public static String date(){
		TimeZone myTimeZoneFile = TimeZone.getTimeZone("America/Mexico_City");
		Calendar cal= Calendar.getInstance(myTimeZoneFile);
		int year= cal.get(Calendar.YEAR);
		String mes = obtenerMes((cal.get(Calendar.MONTH)+1));
		String dia = obtenerMes(cal.get(Calendar.DAY_OF_MONTH));
		TimeZone myTimeZone = TimeZone.getTimeZone("America/Mexico_City");
		DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss.SSS");
		dateFormat.setTimeZone(myTimeZone);
		Date date = new Date();
		return ""+(year)+"-"+(mes)+"-"+(dia)+" "+dateFormat.format(date)+"";
	}
	private static String obtenerMes(int valor){
		String retorna = "";
		if (valor<10){
			retorna = "0"+valor;
		}else{
			retorna = String.valueOf(valor);
		}
		return retorna;
	}
	private static void cambiaEstatus(Pendientes p, String cdo, String estatus) {
		Connection connBD = null;
    	try
    	{
	    	connBD = ConexionBD.AbrirConexionBD(cdo);
	    	List<Querys> listaQuerys = ClsQuery.ConsultaTablaQuerysBD(cdo, connBD);
	    	PreparedStatement pstmt = null; 	      	
	    	GestorSellado.cambiaEstatus(cdo,connBD,pstmt,listaQuerys, p.getSerie(), p.getFolio(), estatus,p.getTipoDoc()); 
	    	Cls_Logs.insertarLog(cdo, p.getSerie(), p.getFolio(), date()+" Se cambia a estatus "+estatus);
    	}
    	  catch(Exception ex)
    	{
    		System.out.println("Error En metodo consultaDescripcion " + ex.toString() );
    	}finally
		{
			try {connBD.close();} catch (SQLException e) {e.printStackTrace();}
		}
		
	}
	private static List<Pendientes> traePendientes(String cdo,String estatus, String numeroCliente) {
		Connection connBD = null;
		List<Pendientes> pendientes= new ArrayList<>();
    	try
    	{	
    		log.add(date()+" Entra a traePendientes ");
	    	connBD = ConexionBD.AbrirConexionBD(cdo);
	    	List<Querys> listaQuerys = ClsQuery.ConsultaTablaQuerysBD(cdo, connBD);
	    	PreparedStatement pstmt = null; 	      	
	    	pendientes = GestorSellado.recuperaPendientes(cdo,connBD,pstmt,listaQuerys, estatus,numeroCliente);    
	    	log.add(date()+" Sale de traePendientes con: "+pendientes.size()+" pendientes");
    	}
    	  catch(Exception ex)
    	{
    		System.out.println("Error En metodo consultaDescripcion " + ex.toString() );
    	}finally
		{
			try {connBD.close();} catch (SQLException e) {e.printStackTrace();}
		}
		return pendientes;
	}
}
