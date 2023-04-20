package cdo.Datos;

import java.io.Serializable;

public class Log implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private String dato_1;
	private String dato_2;
	private String accion;
	
	public Log() {
		super();
	}

	public Log(String dato_1, String dato_2, String accion) {
		super();
		this.dato_1 = dato_1;
		this.dato_2 = dato_2;
		this.accion = accion;
	}
	
	public String getDato_1() {
		return dato_1;
	}

	public void setDato_1(String dato_1) {
		this.dato_1 = dato_1;
	}

	public String getDato_2() {
		return dato_2;
	}

	public void setDato_2(String dato_2) {
		this.dato_2 = dato_2;
	}

	public String getAccion() {
		return accion;
	}

	public void setAccion(String accion) {
		this.accion = accion;
	}

	@Override
	public String toString() {
		return "Log [dato_1=" + dato_1 + ", dato_2=" + dato_2
				+ ", accion=" + accion + "]";
	}
}
