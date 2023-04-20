package cdo.Datos;

import java.io.Serializable;

@SuppressWarnings("serial")
public class SeriesCfdi implements Serializable 
{

	private String serieLarga;
	private String serieCorta;
	public SeriesCfdi() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SeriesCfdi(String serieLarga, String serieCorta) {
		super();
		this.serieLarga = serieLarga;
		this.serieCorta = serieCorta;
	}
	public String getSerieLarga() {
		return serieLarga;
	}
	public void setSerieLarga(String serieLarga) {
		this.serieLarga = serieLarga;
	}
	public String getSerieCorta() {
		return serieCorta;
	}
	public void setSerieCorta(String serieCorta) {
		this.serieCorta = serieCorta;
	}
	@Override
	public String toString() {
		return "SeriesCfdi [serieLarga=" + serieLarga + ", serieCorta=" + serieCorta + "]";
	}
	
	
}
