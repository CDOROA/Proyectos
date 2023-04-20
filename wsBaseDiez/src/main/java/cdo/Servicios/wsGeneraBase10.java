package cdo.Servicios;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import cdo.Datos.Datos;
import cdo.Datos.Querys;
import cdo.Persistencia.GestorBase10;
import cdo.Util.ClsQuery;
import cdo.Util.ConexionBD;



@Path("/basediez")
public class wsGeneraBase10 {
	
	List<String> log =new ArrayList<>();
	
	@GET
	@Path("/generaBaseDiez")
	@Produces({MediaType.TEXT_PLAIN})
    public static String generaBaseDiez(@QueryParam("numCli") String numCli,@QueryParam("cdo") String cdo,@QueryParam("cambiar") String cambiar) {
		Datos d=traerDatos(cdo.toLowerCase());
		//System.out.println(d.toString());
		String respuesta="false";
		String valor="";
		switch(d.getRean()) {
		case "MX":
			valor="12";
			break;
		case "PU":
			valor="08";
			break;
		case "LE":
			valor="01";
			break;
		case "MT":
			valor="00";
			break;
		}	
	
		if(cambiar.equals("0")) {
			respuesta=realizaOperacion(numCli,valor,d,cdo);
        }else {
        	List<String> clientes = traerClientes(cdo);
        	if(numCli.length()>1&&!clientes.contains(numCli)) {
        		clientes.add(numCli);
    		}
        	
        	for(int i=0;i<clientes.size();i++) {
        		System.out.println(clientes.get(i));
        		respuesta+=realizaOperacion(clientes.get(i),valor,d,cdo)+"\n";
        	}
        }
		
		
		return respuesta;	
	}
	private static List<String> traerClientes(String cdo) {
		Connection connBD = null;
		List<String> d=new ArrayList<String>();
    	try
    	{
	    	connBD = ConexionBD.AbrirConexionBD(cdo);
	    	List<Querys> listaQuerys = ClsQuery.ConsultaTablaQuerysBD(cdo, connBD);
	    	PreparedStatement pstmt = null; 	      	
	    	d = GestorBase10.traeClientes(cdo,connBD,pstmt,listaQuerys);
    	}
    	  catch(Exception ex)
    	{
    		System.out.println("Error En metodo traerDatos " + ex.toString() );
    	}finally
		{
			try {connBD.close();} catch (SQLException e) {e.printStackTrace();}
		}
		return d;
	}
	private static String realizaOperacion(String numCli, String valor, Datos d, String cdo) {
		String respuesta="false";
		boolean valCli=true;
		while(valCli) {
			if(numCli.length()<5) {
				numCli="0"+numCli;
			}else {
				valCli=false;
			}
		}
		String cadena=valor+d.getRen()+numCli;
		//System.out.println("1"+cadena);
		int sum=numValidador(cadena);
		boolean valida2=true;
		int control=0;
		while(valida2) {
        	if(sum%10!=0) {
        		control++;
        		sum=numValidador(String.valueOf(cadena+control));
        	}else {
        		boolean checa=cambiaReferenciaCliente((d.getRean()+d.getRen()+numCli+control),cdo,numCli);
        		if(checa) {
        			respuesta="true"+" se cambio referencia a cliente: "+numCli;
        		}else {
        			respuesta="false"+" no se cambio referencia a cliente: "+numCli;
        		}
        		valida2=false;
        	}
		}
		return respuesta;
	}
	private static boolean cambiaReferenciaCliente(String referencia, String cdo,String cliente) {
		boolean respuesta= false;
		Connection connBD = null;
		Datos d=new Datos();
    	try
    	{
	    	connBD = ConexionBD.AbrirConexionBD(cdo);
	    	List<Querys> listaQuerys = ClsQuery.ConsultaTablaQuerysBD(cdo, connBD);
	    	PreparedStatement pstmt = null; 	      	
	    	respuesta = GestorBase10.cambiaRefCliente(cdo,connBD,pstmt,listaQuerys,referencia,cliente);
    	}
    	  catch(Exception ex)
    	{
    		System.out.println("Error En metodo traerDatos " + ex.toString() );
    	}finally
		{
			try {connBD.close();} catch (SQLException e) {e.printStackTrace();}
		}
		return respuesta;
		
	}
	private static Datos traerDatos(String cdo) {
		Connection connBD = null;
		Datos d=new Datos();
    	try
    	{
	    	connBD = ConexionBD.AbrirConexionBD(cdo);
	    	List<Querys> listaQuerys = ClsQuery.ConsultaTablaQuerysBD(cdo, connBD);
	    	PreparedStatement pstmt = null; 	      	
	    	d = GestorBase10.recuperaDatos(cdo,connBD,pstmt,listaQuerys);
    	}
    	  catch(Exception ex)
    	{
    		System.out.println("Error En metodo traerDatos " + ex.toString() );
    	}finally
		{
			try {connBD.close();} catch (SQLException e) {e.printStackTrace();}
		}
		return d;
	}
	public static int numValidador(String cardNumber)
    {
        // int array for processing the cardNumber
        int[] cardIntArray=new int[cardNumber.length()];
 
        for(int i=0;i<cardNumber.length();i++)
        {
            char c= cardNumber.charAt(i);
            cardIntArray[i]=  Integer.parseInt(""+c);
        }
 
        for(int i=cardIntArray.length-2;i>=0;i=i-2)
        {
            int num = cardIntArray[i];
            num = num * 2;  // step 1
            
            if(num>9)
            {
                num = num%10 + num/10;  // step 2
            }
            
            cardIntArray[i]=num;
            //System.out.println(num);
        }
        
        int sum = sumDigits(cardIntArray);  // step 3
 
       // System.out.println(sum);
       
        return sum;
 
    }
	 public static int sumDigits(int[] arr)
	    {
	        return Arrays.stream(arr).sum();
	    }
}
