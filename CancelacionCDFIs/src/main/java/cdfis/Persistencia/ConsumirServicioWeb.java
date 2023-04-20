package cdfis.Persistencia;

//import org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.Credenciales;
import org.datacontract.schemas._2004._07.Emision_Model_DTO.Credenciales;
//import org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.DetalleCancelacionCR;
//import org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RespuestaCancelacionCR;
//import org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.UUIDMotivoCancelacionCR;
import org.datacontract.schemas._2004._07.CancelarCFDIsConValidacion.CancelarCFDIConValidacionResponse;
import org.datacontract.schemas._2004._07.CancelarCFDIsConValidacion.DetalleCancelacionCR;
import org.datacontract.schemas._2004._07.CancelarCFDIsConValidacion.ListaUUID;
//import org.datacontract.schemas._2004._07.CancelarCFDIsConValidacion;
//import org.tempuri.ConexionRemotaLocator;
//import org.tempuri.IConexionRemota;
import org.tempuri.IService;
import org.tempuri.ServiceLocator;

import cdfis.Datos.RespuestaUsuario;

public class ConsumirServicioWeb {
    public  RespuestaUsuario ConsumirServicioWeb(String cuenta, String usuario, String password, String uuid, String rfcEmisor,String sucursal) 
    {	
    	RespuestaUsuario respUsu= new RespuestaUsuario(); 
    	String respuestaServicioWeb = "false";
    	
        try 
        {
        		ServiceLocator conector=new ServiceLocator();
	    		IService iconexion = conector.getBasicHttpBinding_IService();
				
				
				Credenciales credenciales = new Credenciales(cuenta,password,sucursal,usuario);
				System.out.println("Credenciales: "+credenciales.toString());
				System.out.println("Credenciales: "+credenciales.getCuenta());
				System.out.println("Credenciales: "+credenciales.getPassword());
				System.out.println("Credenciales: "+credenciales.getUsuario());
				System.out.println("Credenciales: "+credenciales.getSucursal());
				
				
				
				
				//String[] uuids =new String[1];
				//System.out.println("ws 2 uuid: "+uuid);
				ListaUUID[] uuidcanc = new ListaUUID[1];
				uuidcanc[0]= new ListaUUID ("","","02",rfcEmisor.trim(),uuid.trim(),"");
//				for(int i=0;i<uuidcanc.length;i++) {
//				uuidcanc[i].setUUID(uuid);
//				uuidcanc[i].setMotivo("02");
//				uuidcanc[i].setRfcEmisor(rfcEmisor);
//				}
//				UUIDMotivoCancelacionCR[] uudiCancel = new UUIDMotivoCancelacionCR[1];
//				uudiCancel[0] = new UUIDMotivoCancelacionCR(null, "02", uuid);
//				uuids[0]= uuid; 
				//System.out.println(uuidcanc.length);
				for (ListaUUID uuidMotivoCancelacionCR : uuidcanc)
				{
					//System.out.println("Recorriedno uuid: "+uuidMotivoCancelacionCR.getFolioSustitucion());
					//System.out.println("Recorriedno uuid: "+uuidMotivoCancelacionCR.getMotivo());
					//System.out.println("Recorriedno uuid: "+uuidMotivoCancelacionCR.getUUID());
					//System.out.println("fin");
				}
				
				            
				try 
				{
					CancelarCFDIConValidacionResponse respuesta = new CancelarCFDIConValidacionResponse();
					//System.out.println("antes de ws");
					respuesta = iconexion.cancelarCFDIConValidacion(credenciales, uuidcanc);
					//System.out.println("despues de ws: "+respuesta.toString());
					respUsu.setRespuestaObjeto41(respuesta);
			procesaRespuesta(respuesta);
					if (respuesta.getAcuses()[0].getOperacionExitosa() == true) 
					{
						respuestaServicioWeb="true";
					}
					else 
					{
					respuestaServicioWeb=respuesta.getAcuses()[0].getErrorGeneral();
					System.out.println("GENERAL: "+respuesta.getAcuses()[0].getErrorGeneral()+ "  DETALLADO: "+respuesta.getAcuses()[0].getErrorDetallado());	
						
					}


				} 
				catch (NullPointerException ex) 
				{
					//System.out.println("Error: " + ex.getMessage().toString());
					respuestaServicioWeb=ex.getMessage().toString();
				    	}
                
            	catch (Exception e) 
            	{
            		//System.out.println("Error: " + e.getMessage().toString());
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
    
    private void procesaRespuesta(CancelarCFDIConValidacionResponse respuesta)
    {
    	
    	//System.out.println("RespuestaServicio: " + respuesta.getAcuses()[0].getErrorDetallado());
		//System.out.println("MensajeError     : " + respuesta.getAcuses()[0].getErrorGeneral());
		//System.out.println("EsCancelable     : " + respuesta.getAcuses()[0].getOperacionExitosa() );
		try
		{
			//System.out.println("eexdf: ");
		//System.out.println("EsCancelable     : " + respuesta.getUUIDS());
		}
		catch (Exception e) 
		{
			//System.out.println("Error en lo final: "+e.getMessage().toString());
		}
    	try {
		//System.out.println("antes de for");
			for( DetalleCancelacionCR resp:respuesta.getUUIDS() )
			{
				System.out.println("despues");
				System.out.println("RespuestaServicio: " + resp.getRespuestaServicio() );
				System.out.println("MensajeError     : " + resp.getMensajeError() );
				System.out.println("EsCancelable     : " + resp.getEsCancelable() );
				System.out.println("UUID             : " + resp.getUUID() );
			}
    		
    	  } catch (Exception ex) {
             //System.out.println("Error al procesar Respuesta: " + ex.toString());
          }
    }
}
