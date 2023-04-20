package cdo.Datos;

import java.io.Serializable;

public class Armandoras implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private int cve_armadora;
	private String nombre_armadora;
	private String descripcion_armadora;
	
	public Armandoras() {
		super();
	}

	public Armandoras(int cve_armadora, String nombre_armadora, String descripcion_armadora) {
		super();
		this.cve_armadora = cve_armadora;
		this.nombre_armadora = nombre_armadora;
		this.descripcion_armadora = descripcion_armadora;
	}

	public int getCve_armadora() {
		return cve_armadora;
	}

	public void setCve_armadora(int cve_armadora) {
		this.cve_armadora = cve_armadora;
	}

	public String getNombre_armadora() {
		return nombre_armadora;
	}

	public void setNombre_armadora(String nombre_armadora) {
		this.nombre_armadora = nombre_armadora;
	}

	public String getDescripcion_armadora() {
		return descripcion_armadora;
	}

	public void setDescripcion_armadora(String descripcion_armadora) {
		this.descripcion_armadora = descripcion_armadora;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Armandoras [cve_armadora=" + cve_armadora + ", nombre_armadora=" + nombre_armadora
				+ ", descripcion_armadora=" + descripcion_armadora + "]";
	}
}
