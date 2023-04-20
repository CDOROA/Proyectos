package cdo.Datos;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Vehiculos implements Serializable 
{
	private String placas;
	private String descripcion;
	private String llantas;
	public Vehiculos() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Vehiculos(String placas, String descripcion, String llantas) {
		super();
		this.placas = placas;
		this.descripcion = descripcion;
		this.llantas = llantas;
	}
	public String getPlacas() {
		return placas;
	}
	public void setPlacas(String placas) {
		this.placas = placas;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getLlantas() {
		return llantas;
	}
	public void setLlantas(String llantas) {
		this.llantas = llantas;
	}
	@Override
	public String toString() {
		return "Vehiculos [placas=" + placas + ", descripcion=" + descripcion + ", llantas=" + llantas + "]";
	}
	
}
