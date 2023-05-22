package cdo.Datos;

import java.io.Serializable;

public class SubMarcas implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private int cve_submarca;
	private String nombre_submarca;
	
	public SubMarcas() {
		super();
	}

	public SubMarcas(int cve_submarca, String nombre_submarca) {
		super();
		this.cve_submarca = cve_submarca;
		this.nombre_submarca = nombre_submarca;
	}

	public int getCve_submarca() {
		return cve_submarca;
	}

	public void setCve_submarca(int cve_submarca) {
		this.cve_submarca = cve_submarca;
	}

	public String getNombre_submarca() {
		return nombre_submarca;
	}

	public void setNombre_submarca(String nombre_submarca) {
		this.nombre_submarca = nombre_submarca;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "SubMarcas [cve_submarca=" + cve_submarca + ", nombre_submarca=" + nombre_submarca + "]";
	}
}
