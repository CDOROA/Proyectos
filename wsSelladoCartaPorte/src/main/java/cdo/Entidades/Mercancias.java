package cdo.Entidades;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Mercancias extends Identificadores implements Serializable
{
	private String renglon;
	private String id_origen;
	private String id_destino;
	private String peso_kg;
	private String cantidad_transporta;
	public Mercancias() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Mercancias(String uname, String folio, String serie, String carta_porte) {
		super(uname, folio, serie, carta_porte);
		// TODO Auto-generated constructor stub
	}
	public Mercancias(String renglon, String id_origen, String id_destino, String peso_kg, String cantidad_transporta) {
		super();
		this.renglon = renglon;
		this.id_origen = id_origen;
		this.id_destino = id_destino;
		this.peso_kg = peso_kg;
		this.cantidad_transporta = cantidad_transporta;
	}
	public String getRenglon() {
		return renglon;
	}
	public void setRenglon(String renglon) {
		this.renglon = renglon;
	}
	public String getId_origen() {
		return id_origen;
	}
	public void setId_origen(String id_origen) {
		this.id_origen = id_origen;
	}
	public String getId_destino() {
		return id_destino;
	}
	public void setId_destino(String id_destino) {
		this.id_destino = id_destino;
	}
	public String getPeso_kg() {
		return peso_kg;
	}
	public void setPeso_kg(String peso_kg) {
		this.peso_kg = peso_kg;
	}
	public String getCantidad_transporta() {
		return cantidad_transporta;
	}
	public void setCantidad_transporta(String cantidad_transporta) {
		if (cantidad_transporta.equalsIgnoreCase(""))
		{
			this.cantidad_transporta = "0";
		}
		else
		{
			this.cantidad_transporta = cantidad_transporta;
		}
	}
	@Override
	public String toString() {
		return "Mercancias [renglon=" + renglon + ", id_origen=" + id_origen + ", id_destino=" + id_destino
				+ ", peso_kg=" + peso_kg + ", cantidad_transporta=" + cantidad_transporta + "]";
	}

	
}
