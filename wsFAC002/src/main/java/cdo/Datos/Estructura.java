package cdo.Datos;

public class Estructura {
	private String id;
	private String descripcion;
	
	public Estructura(String id, String descripcion) {
		super();
		this.id = id;
		this.descripcion = descripcion;
	}
	
	public Estructura() {
		super();
		this.id = "";
		this.descripcion = "";
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
}
