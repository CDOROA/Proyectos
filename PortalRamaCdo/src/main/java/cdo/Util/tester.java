package cdo.Util;

import java.sql.Time;
import java.util.Calendar;

import cdo.Persistencia.GestorAltaArticuloEnCarrito;
//import cdo.Persistencia.GestorConfiguracionDemonios;
import cdo.Persistencia.GestorConfiguracionDemoniosV2;
import cdo.Persistencia.GestorEnvioCorreo72hrs;

public class tester {

	public static void main(String[] args) {
		//ejecucionDeDemonios();
		//EnvioDeDorreo72Hrs();
		
	}
 

	
	
	
	
	private static void EnvioDeDorreo72Hrs() {
		GestorEnvioCorreo72hrs gtr = new GestorEnvioCorreo72hrs();
		
		//gtr.enviarCorreo();
		
	}





	private static void ejecucionDeDemonios() {
		GestorConfiguracionDemoniosV2 dem = new GestorConfiguracionDemoniosV2();
		 
		 
		 dem.ConsultaProcesarPedido("CDF");
		 Calendar c1 = Calendar.getInstance();
			
			@SuppressWarnings("deprecation")
			Time horaEnvio = new  Time(c1.getTime().getHours(),c1.getTime().getMinutes(), c1.getTime().getSeconds());

			System.err.println("horaEnvio:  " + horaEnvio);
	}

}
