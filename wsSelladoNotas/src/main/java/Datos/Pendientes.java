package Datos;

public class Pendientes {
	private String serie;
	private String folio;
	private int tipoDoc;
	private double importeTotal;
	
	public Pendientes() {
		super();
	}
	
	public double getImporteTotal() {
		return importeTotal;
	}

	public void setImporteTotal(double importeTotal) {
		this.importeTotal = importeTotal;
	}

	public int getTipoDoc() {
		return tipoDoc;
	}

	public void setTipoDoc(int tipoDoc) {
		this.tipoDoc = tipoDoc;
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
		return "Pendientes [serie=" + serie + ", folio=" + folio + ", tipoDoc=" + tipoDoc + ", importeTotal=" + "]";
	}
	
}
