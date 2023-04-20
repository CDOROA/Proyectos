package cdo.Datos;

import java.io.Serializable;

public class Catalogo_TiposLineaBancaria implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private int id_tipo_linea;
	private String nombre_tipo_linea;
	private int area_tipo_linea ;
	
	public Catalogo_TiposLineaBancaria() {
		super();
	}

	public Catalogo_TiposLineaBancaria(int id_tipo_linea, String nombre_tipo_linea, int area_tipo_linea) {
		super();
		this.id_tipo_linea = id_tipo_linea;
		this.nombre_tipo_linea = nombre_tipo_linea;
		this.area_tipo_linea = area_tipo_linea;
	}

	public int getId_tipo_linea() {
		return id_tipo_linea;
	}

	public void setId_tipo_linea(int id_tipo_linea) {
		this.id_tipo_linea = id_tipo_linea;
	}

	public String getNombre_tipo_linea() {
		return nombre_tipo_linea;
	}

	public void setNombre_tipo_linea(String nombre_tipo_linea) {
		this.nombre_tipo_linea = nombre_tipo_linea;
	}

	public int getArea_tipo_linea() {
		return area_tipo_linea;
	}

	public void setArea_tipo_linea(int area_tipo_linea) {
		this.area_tipo_linea = area_tipo_linea;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Catalogo_TiposLineaBancaria [id_tipo_linea=" + id_tipo_linea + ", nombre_tipo_linea="
				+ nombre_tipo_linea + ", area_tipo_linea=" + area_tipo_linea + "]";
	}

}
