package cdo.Datos;

import java.io.Serializable;

public class Zonas implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String letra_zona;
	String descripcion;
	String tipo_zona;
	public Zonas() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Zonas(String letra_zona, String descripcion, String tipo_zona) {
		super();
		this.letra_zona = letra_zona;
		this.descripcion = descripcion;
		this.tipo_zona = tipo_zona;
	}
	public String getLetra_zona() {
		return letra_zona;
	}
	public void setLetra_zona(String letra_zona) {
		this.letra_zona = letra_zona;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getTipo_zona() {
		return tipo_zona;
	}
	public void setTipo_zona(String tipo_zona) {
		this.tipo_zona = tipo_zona;
	}
	@Override
	public String toString() {
		return "Zonas [letra_zona=" + letra_zona + ", descripcion=" + descripcion + ", tipo_zona=" + tipo_zona + "]";
	}
	
	
}
