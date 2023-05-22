package com.cordina.PortalCordinaKwx.dto;

public class GaleriaVideosDto {
	
	int index;
	int id_video;
	String descripcion;
	String url_video;
	String url_imagen;
	String fecha;
	
	
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	
	public int getId_video() {
		return id_video;
	}
	public void setId_video(int id_video) {
		this.id_video = id_video;
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
		
	public String getUrl_video() {
		return url_video;
	}
	public void setUrl_video(String url_video) {
		this.url_video = url_video;
	}
	
	public String getUrl_imagen() {
		return url_imagen;
	}
	public void setUrl_imagen(String url_imagen) {
		this.url_imagen = url_imagen;
	}
	
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

}
