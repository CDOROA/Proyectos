package cdo.Datos;

import java.io.Serializable;

public class Grupos implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private int cve_grupo;
	private String nombre_grupo;
	private String descripcion_grupo;
	
	public Grupos() {
		super();
	}

	public Grupos(int cve_grupo, String nombre_grupo, String descripcion_grupo) {
		super();
		this.cve_grupo = cve_grupo;
		this.nombre_grupo = nombre_grupo;
		this.descripcion_grupo = descripcion_grupo;
	}

	public int getCve_grupo() {
		return cve_grupo;
	}

	public void setCve_grupo(int cve_grupo) {
		this.cve_grupo = cve_grupo;
	}

	public String getNombre_grupo() {
		return nombre_grupo;
	}

	public void setNombre_grupo(String nombre_grupo) {
		this.nombre_grupo = nombre_grupo;
	}

	public String getDescripcion_grupo() {
		return descripcion_grupo;
	}

	public void setDescripcion_grupo(String descripcion_grupo) {
		this.descripcion_grupo = descripcion_grupo;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Grupos [cve_grupo=" + cve_grupo + ", nombre_grupo=" + nombre_grupo + ", descripcion_grupo="
				+ descripcion_grupo + "]";
	}

}
