package cdo.Datos;

import java.io.Serializable;

public class Estados  implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private int cve_Estado;
	private String nombre_estado;
	
	public Estados() {
		super();
	}

	public Estados(int cve_Estado, String nombre_estado) {
		super();
		this.cve_Estado = cve_Estado;
		this.nombre_estado = nombre_estado;
	}

	public int getCve_Estado() {
		return cve_Estado;
	}

	public void setCve_Estado(int cve_Estado) {
		this.cve_Estado = cve_Estado;
	}

	public String getNombre_estado() {
		return nombre_estado;
	}

	public void setNombre_estado(String nombre_estado) {
		this.nombre_estado = nombre_estado;
	}

	@Override
	public String toString() {
		return "Estados [cve_Estado=" + cve_Estado + ", nombre_estado=" + nombre_estado + "]";
	}
}
