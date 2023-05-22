package cdo.Datos;

public class listaNegraArticulos {
	private String numArt;
	private String cveTipo;
	private String descripcion;
	public String getNumArt() {
		return numArt;
	}
	public void setNumArt(String numArt) {
		this.numArt = numArt;
	}
	public String getCveTipo() {
		return cveTipo;
	}
	public void setCveTipo(String cveTipo) {
		this.cveTipo = cveTipo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public listaNegraArticulos() {
		super();
	}
	@Override
	public String toString() {
		return "listaNegraArticulos [numArt=" + numArt + ", cveTipo=" + cveTipo + ", descripcion=" + descripcion + "]";
	}
	
	
}
