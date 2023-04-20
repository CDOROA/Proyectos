package cdo.ManejoErrores;

public class PersistenciaException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	private String nombreClase;
	private String nombreMetodo;
	private String causa;
	private String msgEx;
	public PersistenciaException(String msg) {
		super(msg);
	}
	public String getNombreClase() {
		return nombreClase;
	}
	public void setNombreClase(String nombreClase) {
		this.nombreClase = nombreClase;
	}
	public String getNombreMetodo() {
		return nombreMetodo;
	}
	public void setNombreMetodo(String nombreMetodo) {
		this.nombreMetodo = nombreMetodo;
	}
	public String getCausa() {
		return causa;
	}
	public void setCausa(String causa) {
		this.causa = causa;
	}
	public String getMsgEx() {
		return msgEx;
	}
	public void setMsgEx(String msgEx) {
		this.msgEx = msgEx;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	

}
