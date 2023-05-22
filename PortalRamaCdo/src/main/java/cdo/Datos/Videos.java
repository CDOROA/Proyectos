package cdo.Datos;

import java.io.Serializable;
 
public class Videos implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	
	private String descripcion;
	private String urlImagen;
	private String urlVideo;
	
	public Videos() {
		super();
	}
	public Videos(String descripcion, String url_imagen, String url_video) {
		super();
		this.descripcion = descripcion;
		this.urlImagen = url_imagen;
		this.urlVideo = url_video;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getUrlImagen() {
		return urlImagen;
	}
	public void setUrlImagen(String url_imagen) {
		this.urlImagen = url_imagen;
	}
	public String getUrlVideo() {
		return urlVideo;
	}
	public void setUrlVideo(String url_video) {
		this.urlVideo = url_video;
	}
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	@Override
	public String toString() {
		return "Videos [descripcion=" + descripcion + ", url_imagen=" + urlImagen + ", url_video=" + urlVideo + "]";
	}
	
}
