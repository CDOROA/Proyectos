package cdo.Datos;

public class ValidadorTaspaso72hrs {

	private boolean respuesta;
	private int registros;
	private String cdoTrasp;
	
	public boolean isRespuesta() {
		return respuesta;
	}
	public void setRespuesta(boolean respuesta) {
		this.respuesta = respuesta;
	}
	public int getRegistros() {
		return registros;
	}
	public void setRegistros(int registros) {
		this.registros = registros;
	}
	public String getCdoTrasp() {
		return cdoTrasp;
	}
	public void setCdoTrasp(String cdoTrasp) {
		this.cdoTrasp = cdoTrasp;
	}




	public ValidadorTaspaso72hrs() {
		super();
		this.respuesta = false;
		this.registros = 0;
		this.cdoTrasp = "";
	}
	@Override
	public String toString() {
		return "ValidadorTaspaso72hrs [respuesta=" + respuesta + ", registros=" + registros + ", cdoTrasp=" + cdoTrasp
				+ "]";
	}	
}
