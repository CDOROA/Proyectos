package com.cordina.PortalCordinaKwx.dto;

public class Pais {

	int idPais;
	String descripcionPais;
	
	
	
	public int getIdPais() {
		return idPais;
	}
	public void setIdPais(int idPais) {
		this.idPais = idPais;
	}
	public String getDescripcionPais() {
		return descripcionPais;
	}
	public void setDescripcionPais(String descripcionPais) {
		this.descripcionPais = descripcionPais;
	}
	
	public Pais() {
		super();
	}
	@Override
	public String toString() {
		return "Pais [idPais=" + idPais + ", descripcionPais=" + descripcionPais + "]";
	}
	
	
}
