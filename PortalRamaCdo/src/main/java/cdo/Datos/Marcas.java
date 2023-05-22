package cdo.Datos;

import java.io.Serializable;

public class Marcas implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private int cve_marca;
	private String nombre_marca;
	
	public Marcas() {
		super();
	}

	public Marcas(int cve_marca, String nombre_marca) {
		super();
		this.cve_marca = cve_marca;
		this.nombre_marca = nombre_marca;
	}

	public int getCve_marca() {
		return cve_marca;
	}

	public void setCve_marca(int cve_marca) {
		this.cve_marca = cve_marca;
	}

	public String getNombre_marca() {
		return nombre_marca;
	}

	public void setNombre_marca(String nombre_marca) {
		this.nombre_marca = nombre_marca;
	}

	@Override
	public String toString() {
		return "Marcas [cve_marca=" + cve_marca + ", nombre_marca=" + nombre_marca + "]";
	}
}
