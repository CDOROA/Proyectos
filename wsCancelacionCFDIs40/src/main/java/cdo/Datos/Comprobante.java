package cdo.Datos;

public class Comprobante {
	private String cdo;
	private String serie;
	private String folio;
	public Comprobante() {
		// TODO Auto-generated constructor stub
	}
	
	public String getCdo() {
		return cdo;
	}

	public void setCdo(String cdo) {
		this.cdo = cdo;
	}

	public String getSerie() {
		return serie;
	}
	
	public void setSerie(String serie) {
		this.serie = serie;
	}
	public String getFolio() {
		return folio;
	}
	public void setFolio(String folio) {
		this.folio = folio;
	}
	@Override
	public String toString() {
		return "Comprobante [cdo=" + cdo + ", serie=" + serie + ", folio=" + folio + "]";
	}
	 
}
