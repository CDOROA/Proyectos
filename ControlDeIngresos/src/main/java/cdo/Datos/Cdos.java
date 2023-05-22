package cdo.Datos;

import java.io.Serializable;

public class Cdos implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String cve_cdo;
	private String nombre_cdo;
	
	public Cdos() {
		super();
	}

	public Cdos(String cve_cdo, String nombre_cdo) {
		super();
		this.cve_cdo = cve_cdo;
		this.nombre_cdo = nombre_cdo;
	}

	public String getCve_cdo() {
		return cve_cdo;
	}

	public void setCve_cdo(String cve_cdo) {
		this.cve_cdo = cve_cdo;
	}

	public String getNombre_cdo() {
		return nombre_cdo;
	}

	public void setNombre_cdo(String nombre_cdo) {
		this.nombre_cdo = nombre_cdo;
	}

	@Override
	public String toString() {
		return "Cdos [cve_cdo=" + cve_cdo + ", nombre_cdo=" + nombre_cdo + "]";
	}
	
}
