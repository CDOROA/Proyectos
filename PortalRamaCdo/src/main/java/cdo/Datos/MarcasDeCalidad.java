package cdo.Datos;

import java.io.Serializable;

public class MarcasDeCalidad implements Serializable {

	private static final long serialVersionUID = 1L;
	private int cve_marca;
	private String imagen;
	private int orden;
	
	public MarcasDeCalidad() {
		super();
	}

	public MarcasDeCalidad(int cve_marca, String imagen, int orden) {
		super();
		this.cve_marca = cve_marca;
		this.imagen = imagen;
		this.orden = orden;
	}

	public int getCve_marca() {
		return cve_marca;
	}

	public void setCve_marca(int cve_marca) {
		this.cve_marca = cve_marca;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public int getOrden() {
		return orden;
	}

	public void setOrden(int orden) {
		this.orden = orden;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "MarcasDeCalidad [cve_marca=" + cve_marca + ", imagen=" + imagen + ", orden=" + orden + "]";
	}
}
