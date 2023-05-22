package cdo.Datos;

import java.io.Serializable;

public class Transportes implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private int cve_trasporte;
	private String nombre_trasporte;
	private String tipoTransporte;
	
	public Transportes() {
		super();
		this.cve_trasporte = 0;
		this.nombre_trasporte = "";
		this.tipoTransporte = "";
	}

	public Transportes(int cve_trasporte, String nombre_trasporte, String tipoTransporte) {
		super();
		this.cve_trasporte = cve_trasporte;
		this.nombre_trasporte = nombre_trasporte;
		this.tipoTransporte = tipoTransporte;
	}

	public int getCve_trasporte() {
		return cve_trasporte;
	}

	public void setCve_trasporte(int cve_trasporte) {
		this.cve_trasporte = cve_trasporte;
	}

	public String getNombre_trasporte() {
		return nombre_trasporte;
	}

	public void setNombre_trasporte(String nombre_trasporte) {
		this.nombre_trasporte = nombre_trasporte;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getTipoTransporte() {
		return tipoTransporte;
	}

	public void setTipoTransporte(String tipoTransporte) {
		this.tipoTransporte = tipoTransporte;
	}

	@Override
	public String toString() {
		return "Transportes [cve_trasporte=" + cve_trasporte + ", nombre_trasporte=" + nombre_trasporte
				+ ", tipoTransporte=" + tipoTransporte + "]";
	}

	
}
