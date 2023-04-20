package cdo.ManejoErrores;

public class NegocioException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	private String servicio;

	public NegocioException(String msj) {
		super(msj);
	}

	public String getServicio() {
		return servicio;
	}

	public void setServicio(String servicio) {
		this.servicio = servicio;
	}
	
}
