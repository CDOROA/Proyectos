package cdo.ManejoErrores;

import java.util.Map;

public class ManejadorErrPersistencia {
	public static PersistenciaException crearEx(Map<String,String> detEx,
			Exception ex){
		PersistenciaException pex = new PersistenciaException(detEx.get("msg"));
		pex.setNombreClase(detEx.get("clase"));
		pex.setNombreMetodo(detEx.get("metodo"));
		pex.setCausa(detEx.get("causa"));
		pex.setMsgEx(detEx.get("msgEx"));
		pex.initCause(ex);
		return pex;
	}
	public static String getDescripcionDetallada(PersistenciaException pex){
		StringBuilder sb = new StringBuilder();
		Throwable causa = pex.getCause();
		sb.append(pex.getMessage() + "\n")
		  .append("Clase : " + pex.getNombreClase() + ".\n" )
		  .append("Metodo: " + pex.getNombreMetodo() +  ".\n")
		  .append("Causa : " + pex.getCausa() +  ".")
		  //.append("MsgEx : " + pex.getMsgEx() + ". ")
		  ;
		if(causa != null){
			sb.append("\nExcepcion Causa : " + causa.getClass().getName() + ". ");
			//  .append("Mensaje de excepción causa: " + causa.getMessage().replace("\n", ". ") + ".");
		
		}

		return sb.toString();
	}
}
