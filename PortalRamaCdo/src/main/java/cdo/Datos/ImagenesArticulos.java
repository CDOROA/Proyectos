package cdo.Datos;

import java.io.Serializable;

public class ImagenesArticulos implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String num_art_cdo; 
	private String imagen_bxa;
	private String imagen_ecommerce;
	
	public ImagenesArticulos() {
		super();
	}

	public ImagenesArticulos(String num_art_cdo, String imagen_bxa, String imagen_ecommerce) {
		super();
		this.num_art_cdo = num_art_cdo;
		this.imagen_bxa = imagen_bxa;
		this.imagen_ecommerce = imagen_ecommerce;
	}

	public String getNum_art_cdo() {
		return num_art_cdo;
	}

	public void setNum_art_cdo(String num_art_cdo) {
		this.num_art_cdo = num_art_cdo;
	}

	public String getImagen_bxa() {
		return imagen_bxa;
	}

	public void setImagen_bxa(String imagen_bxa) {
		this.imagen_bxa = imagen_bxa;
	}

	public String getImagen_ecommerce() {
		return imagen_ecommerce;
	}

	public void setImagen_ecommerce(String imagen_ecommerce) {
		this.imagen_ecommerce = imagen_ecommerce;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "ImagenesArticulos [num_art_cdo=" + num_art_cdo + ", imagen_bxa=" + imagen_bxa + ", imagen_ecommerce="
				+ imagen_ecommerce + "]";
	}
}
