package cdo.Entidades;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Identificadores implements Serializable 
{
	private String uname;
	private String folio;
	private String serie;
	private String carta_porte;
	public Identificadores() 
	{
		super();
	}
	public Identificadores(String uname, String folio, String serie, String carta_porte) 
	{
		super();
		this.uname = uname;
		this.folio = folio;
		this.serie = serie;
		this.carta_porte = carta_porte;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getFolio() {
		return folio;
	}
	public void setFolio(String folio) {
		this.folio = folio;
	}
	public String getSerie() {
		return serie;
	}
	public void setSerie(String serie) {
		this.serie = serie;
	}
	public String getCarta_porte() {
		return carta_porte;
	}
	public void setCarta_porte(String carta_porte) {
		this.carta_porte = carta_porte;
	}
	@Override
	public String toString() {
		return "Identificadores [uname=" + uname + ", folio=" + folio + ", serie=" + serie + ", carta_porte="
				+ carta_porte + "]";
	}
	
}
