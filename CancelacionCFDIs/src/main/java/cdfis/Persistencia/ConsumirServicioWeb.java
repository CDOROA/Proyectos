package cdfis.Persistencia;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.Marshaller;

import org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.Credenciales;
import org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.DetalleCancelacionCR;
import org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RespuestaCancelacionCR;
import org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.UUIDMotivoCancelacionCR;
import org.tempuri.ConexionRemotaLocator;
import org.tempuri.IConexionRemota;

import com.sun.research.ws.wadl.ObjectFactory;

import cdfis.Datos.DatosTemporales;
import cdfis.Datos.RespuestaUsuario;

public class ConsumirServicioWeb {

	public void main(String[] args) 
	{
		ConsumirServicioWeb(null, null, null, null);
    }
     
    public  RespuestaUsuario ConsumirServicioWeb(String cuenta, String usuario, String password, String uuid) 
    {	
    	RespuestaUsuario respUsu= new RespuestaUsuario(); 
    	String respuestaServicioWeb = "false";
    	
        try 
        {

            	ConexionRemotaLocator conector=new ConexionRemotaLocator();
				
				IConexionRemota iconexion = conector.getsoapHttpEndpointHttps();
				
				Credenciales credenciales = new Credenciales(cuenta,usuario,password);
				System.out.println("Credenciales: "+credenciales);
				System.out.println("Credenciales: "+credenciales.getCuenta());
				System.out.println("Credenciales: "+credenciales.getPassword());
				System.out.println("Credenciales: "+credenciales.getUsuario());
				
				
				
				
				String[] uuids =new String[1];
				System.out.println("ws 2 uuid: "+uuid);
				UUIDMotivoCancelacionCR[] uudiCancel = new UUIDMotivoCancelacionCR[1];
				uudiCancel[0] = new UUIDMotivoCancelacionCR(null, "02", uuid);
				uuids[0]= uuid; 
				System.out.println(uudiCancel.length);
				for (UUIDMotivoCancelacionCR uuidMotivoCancelacionCR : uudiCancel)
				{
					System.out.println("Recorriedno uuid: "+uuidMotivoCancelacionCR.getFolioSustitucion());
					System.out.println("Recorriedno uuid: "+uuidMotivoCancelacionCR.getMotivo());
					System.out.println("Recorriedno uuid: "+uuidMotivoCancelacionCR.getUUID());
					System.out.println("fin");
				}
				
				            
				try 
				{
					RespuestaCancelacionCR respuesta = new RespuestaCancelacionCR();
					System.out.println("antes de ws");
					respuesta = iconexion.cancelarCFDIsConValidacion(credenciales, uudiCancel);
					System.out.println("despues de ws: "+respuesta.toString());
					respUsu.setRespuestaObjeto33(respuesta);
//					procesaRespuesta(respuesta);
					if (respuesta.getOperacionExitosa() == true) 
					{
						respuestaServicioWeb="true";
					}
					else 
					{
					respuestaServicioWeb=respuesta.getErrorGeneral();
					System.out.println("GENERAL: "+respuesta.getErrorGeneral()+ "  DETALLADO: "+respuesta.getErrorDetallado());	
						
					}


				} 
				catch (NullPointerException ex) 
				{
					System.out.println("Error: " + ex.getMessage().toString());
					respuestaServicioWeb=ex.getMessage().toString();
				    	}
                
            	catch (Exception e) 
            	{
            		System.out.println("Error: " + e.getMessage().toString());
            		respuestaServicioWeb=e.getMessage().toString();
    			}
            	
        	
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        if (respuestaServicioWeb.equalsIgnoreCase("Ya se encuentran cancelados 1 comprobantes, revisa tu selección.")) 
        {
        	respuestaServicioWeb = "true";
		}else 
        if (respuestaServicioWeb.contains("No todos los comprobantes se pueden cancelar")) 
        {
        	respuestaServicioWeb = "Favor de revisar que todos los documentos relacionados a la factura esten cancelados (notas de credito, notas de cargo y pagos)";
		}
        respUsu.setRespuestaString(respuestaServicioWeb);
        return respUsu;
    }
    
    private void procesaRespuesta(RespuestaCancelacionCR respuesta)
    {
    	
    	System.out.println("RespuestaServicio: " + respuesta.getErrorDetallado());
		System.out.println("MensajeError     : " + respuesta.getErrorGeneral());
		System.out.println("EsCancelable     : " + respuesta.getOperacionExitosa() );
		try
		{
			System.out.println("eexdf: ");
		System.out.println("EsCancelable     : " + respuesta.getUUIDS());
		}
		catch (Exception e) 
		{
			System.out.println("Error en lo final: "+e.getMessage().toString());
		}
    	try {
		System.out.println("antes de for");
			for( DetalleCancelacionCR resp:respuesta.getUUIDS() )
			{
				System.out.println("despues");
				System.out.println("RespuestaServicio: " + resp.getRespuestaServicio() );
				System.out.println("MensajeError     : " + resp.getMensajeError() );
				System.out.println("EsCancelable     : " + resp.getEsCancelable() );
				System.out.println("UUID             : " + resp.getUUID() );
			}
    		
    	  } catch (Exception ex) {
             System.out.println("Error al procesar Respuesta: " + ex.toString());
          }
    }
}
