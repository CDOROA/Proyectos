package cdo.Datos;

import java.io.Serializable;

public class CintillosImagenes implements Serializable {
	
	private static final long serialVersionUID = 1L;
	int id_cintillo;
	String imagen_cintillo;
	
	
	public CintillosImagenes() {
		super();
	}


	public CintillosImagenes(int id_cintillo, String imagen_cintillo) {
		super();
		this.id_cintillo = id_cintillo;
		this.imagen_cintillo = imagen_cintillo;
	}


	public int getId_cintillo() {
		return id_cintillo;
	}


	public void setId_cintillo(int id_cintillo) {
		this.id_cintillo = id_cintillo;
	}


	public String getImagen_cintillo() {
		return imagen_cintillo;
	}


	public void setImagen_cintillo(String imagen_cintillo) {
		this.imagen_cintillo = imagen_cintillo;
	}


	@Override
	public String toString() {
		return "CintillosImagenes [id_cintillo=" + id_cintillo + ", imagen_cintillo=" + imagen_cintillo + "]";
	}
	
}
