package cdo.Datos;

import java.io.Serializable;

public class Banners  implements Serializable{

	private static final long serialVersionUID = 1L;	
	private int  id_banner ;
	private String imagen_banner;
	
	public Banners() {
		super();
	}

	public Banners(int id_banner, String imagen_banner) {
		super();
		this.id_banner = id_banner;
		this.imagen_banner = imagen_banner;
	}

	public int getId_banner() {
		return id_banner;
	}

	public void setId_banner(int id_banner) {
		this.id_banner = id_banner;
	}

	public String getImagen_banner() {
		return imagen_banner;
	}

	public void setImagen_banner(String imagen_banner) {
		this.imagen_banner = imagen_banner;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Banners [id_banner=" + id_banner + ", imagen_banner=" + imagen_banner + "]";
	}
}
