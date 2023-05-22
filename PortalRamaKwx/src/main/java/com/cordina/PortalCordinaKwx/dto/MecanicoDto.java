package com.cordina.PortalCordinaKwx.dto;

public class MecanicoDto {
	int    idMecanico;
	String estado; 
	String municipio; 
	String colonia; 
	String cp; 
	String calle; 
	String numExt; 
	String numInt; 
	String nombreTaller; 
	String nombreEncargado;
	String servicioDomicilo; 
	String telefono; 
	String whatsapp; 
	String email; 
	String fotografia;
	String recibirInformacion;
	String latitud; 
	String longitud;
	
	public int getIdMecanico() {
		return idMecanico;
	}
	public void setIdMecanico(int idMecanico) {
		this.idMecanico = idMecanico;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getMunicipio() {
		return municipio;
	}
	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}
	public String getColonia() {
		return colonia;
	}
	public void setColonia(String colonia) {
		this.colonia = colonia;
	}
	public String getCp() {
		return cp;
	}
	public void setCp(String cp) {
		this.cp = cp;
	}
	public String getCalle() {
		return calle;
	}
	public void setCalle(String calle) {
		this.calle = calle;
	}
	public String getNumExt() {
		return numExt;
	}
	public void setNumExt(String numExt) {
		this.numExt = numExt;
	}
	public String getNumInt() {
		return numInt;
	}
	public void setNumInt(String numInt) {
		this.numInt = numInt;
	}
	public String getNombreTaller() {
		return nombreTaller;
	}
	public void setNombreTaller(String nombreTaller) {
		this.nombreTaller = nombreTaller;
	}	
	public String getNombreEncargado() {
		return nombreEncargado;
	}
	public void setNombreEncargado(String nombreEncargado) {
		this.nombreEncargado = nombreEncargado;
	}
	public String getServicioDomicilo() {
		return servicioDomicilo;
	}
	public void setServicioDomicilo(String servicioDomicilo) {
		this.servicioDomicilo = servicioDomicilo;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getWhatsapp() {
		return whatsapp;
	}
	public void setWhatsapp(String whatsapp) {
		this.whatsapp = whatsapp;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getFotografia() {
		return fotografia;
	}
	public void setFotografia(String fotografia) {
		this.fotografia = fotografia;
	}
	public String getRecibirInformacion() {
		return recibirInformacion;
	}
	public void setRecibirInformacion(String recibirInformacion) {
		this.recibirInformacion = recibirInformacion;
	}
	public String getLatitud() {
		return latitud;
	}
	public void setLatitud(String latitud) {
		this.latitud = latitud;
	}
	public String getLongitud() {
		return longitud;
	}
	public void setLongitud(String longitud) {
		this.longitud = longitud;
	}
	public MecanicoDto() {
		super();
		this.idMecanico=0;
		this.estado = "";
		this.municipio = "";
		this.colonia = "";
		this.cp = "";
		this.calle = "";
		this.numExt = "";
		this.numInt = "";
		this.nombreTaller = "";
		this.nombreEncargado="";
		this.servicioDomicilo = "";
		this.telefono = "";
		this.whatsapp = "";
		this.email = "";
		this.fotografia="";
		this.recibirInformacion="";
		this.latitud = "";
		this.longitud = "";
	}
	
	@Override
	public String toString() {
		return "MecanicoDto [idMecanico=" + idMecanico + ", estado=" + estado
				+ ", municipio=" + municipio + ", colonia=" + colonia + ", cp="
				+ cp + ", calle=" + calle + ", numExt=" + numExt + ", numInt="
				+ numInt + ", nombreTaller=" + nombreTaller
				+ ", nombreEncargado=" + nombreEncargado
				+ ", servicioDomicilo=" + servicioDomicilo + ", telefono="
				+ telefono + ", whatsapp=" + whatsapp + ", email=" + email
				+ ", fotografia=" + fotografia + ", recibirInformacion="
				+ recibirInformacion + ", latitud=" + latitud + ", longitud="
				+ longitud + "]";
	}
	
}
