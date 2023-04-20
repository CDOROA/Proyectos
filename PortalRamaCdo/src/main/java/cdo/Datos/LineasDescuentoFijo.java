package cdo.Datos;

import java.io.Serializable;

public class LineasDescuentoFijo  implements Serializable{

	private static final long serialVersionUID = 1L;
	private String linea;
	private String descuento;
	private int porcanetaje;
	
	public LineasDescuentoFijo() {
		super();
	}

	public LineasDescuentoFijo(String linea, String descuento, int porcanetaje) {
		super();
		this.linea = linea;
		this.descuento = descuento;
		this.porcanetaje = porcanetaje;
	}

	public String getLinea() {
		return linea;
	}

	public void setLinea(String linea) {
		this.linea = linea;
	}

	public String getDescuento() {
		return descuento;
	}

	public void setDescuento(String descuento) {
		this.descuento = descuento;
	}

	public int getPorcanetaje() {
		return porcanetaje;
	}

	public void setPorcanetaje(int porcanetaje) {
		this.porcanetaje = porcanetaje;
	}

	@Override
	public String toString() {
		return "LineasDescuentoFijo [linea=" + linea + ", descuento=" + descuento + ", porcanetaje=" + porcanetaje
				+ "]";
	}
}
