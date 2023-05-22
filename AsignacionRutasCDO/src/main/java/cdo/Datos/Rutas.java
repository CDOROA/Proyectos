package cdo.Datos;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Rutas implements Serializable
{
	private int num_ruta;
	private String descripcion;
	public Rutas() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Rutas(int num_ruta, String descripcion) {
		super();
		this.num_ruta = num_ruta;
		this.descripcion = descripcion;
	}
	public int getNum_ruta() {
		return num_ruta;
	}
	public void setNum_ruta(int num_ruta) {
		this.num_ruta = num_ruta;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	@Override
	public String toString() {
		return "Rutas [num_ruta=" + num_ruta + ", descripcion=" + descripcion + "]";
	}

	
	
	
	
}
