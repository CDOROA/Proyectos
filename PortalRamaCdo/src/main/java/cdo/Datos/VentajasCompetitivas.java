package cdo.Datos;

import java.io.Serializable;

public class VentajasCompetitivas implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private int id_seccion;
	private String seccion;	
	private String titulo;
	private String descripcion;
	
	public VentajasCompetitivas() {
		super();
	}

	public VentajasCompetitivas(int id_seccion, String seccion, String titulo, String descripcion) {
		super();
		this.id_seccion = id_seccion;
		this.seccion = seccion;
		this.titulo = titulo;
		this.descripcion = descripcion;
	}

	public int getId_seccion() {
		return id_seccion;
	}

	public void setId_seccion(int id_seccion) {
		this.id_seccion = id_seccion;
	}

	public String getSeccion() {
		return seccion;
	}

	public void setSeccion(String seccion) {
		this.seccion = seccion;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "VentajasCompetitivas [id_seccion=" + id_seccion + ", seccion=" + seccion + ", titulo=" + titulo
				+ ", descripcion=" + descripcion + "]";
	}
	
	
}
