package cdo.ManejoErrores;

import java.util.Map;

public class ManejadorErrNegocio {
	public static NegocioException crearEx(Map<String,String> detEx,
			Exception ex){
		NegocioException nex = new NegocioException(detEx.get("msg"));
		nex.setServicio(detEx.get("servicio"));
		nex.initCause(ex);
		return nex;
	}
	public static String getDescripcionDetallada(Exception ex){
		StringBuilder sb = new StringBuilder();
		Throwable causa = ex.getCause();
		sb.append(ex.getMessage() + "\n")
		  .append("Excepcion: " + ex.getClass().getName() + "\n" );
		if(ex instanceof NegocioException ){
			NegocioException nex = (NegocioException) ex;
			sb.append("servicio: " + nex.getServicio() + "\n");
		}
		if(causa != null){
			sb.append("\nExcepcion Causa : " + causa.getClass().getName() + "\n")
			  .append("Mensaje de excepción causa: " + causa.getMessage() + "\n");
			if(causa instanceof PersistenciaException){
				PersistenciaException pEx = (PersistenciaException) causa;
				sb.append(ManejadorErrPersistencia.getDescripcionDetallada(pEx));
			}
		}

		return sb.toString();
	}
}
