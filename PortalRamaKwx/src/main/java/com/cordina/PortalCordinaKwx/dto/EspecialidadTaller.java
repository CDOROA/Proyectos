package com.cordina.PortalCordinaKwx.dto;

public class EspecialidadTaller {
	private int id;
	private String descripcion;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public EspecialidadTaller() {
		super();
		this.id = 0;
		this.descripcion = "";
	}
}
