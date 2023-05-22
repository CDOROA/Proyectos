package cdo.Datos;

import java.io.Serializable;

public class PrevioDenominacionesMonedas implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	private int id_denominacion; 
	private  String denominacion;
	private  String tipo_denominacion;
	 
	 	 
	public PrevioDenominacionesMonedas() {
		super();
	}

	public PrevioDenominacionesMonedas(int id_denominacion, String denominacion, String tipo_denominacion) {
		super();
		this.id_denominacion = id_denominacion;
		this.denominacion = denominacion;
		this.tipo_denominacion = tipo_denominacion;
	}

	public int getId_denominacion() {
		return id_denominacion;
	}

	public void setId_denominacion(int id_denominacion) {
		this.id_denominacion = id_denominacion;
	}

	public String getDenominacion() {
		return denominacion;
	}

	public void setDenominacion(String denominacion) {
		this.denominacion = denominacion;
	}

	public String getTipo_denominacion() {
		return tipo_denominacion;
	}

	public void setTipo_denominacion(String tipo_denominacion) {
		this.tipo_denominacion = tipo_denominacion;
	}

	@Override
	public String toString() {
		return "PrevioDenominaciones [id_denominacion=" + id_denominacion + ", denominacion=" + denominacion
				+ ", tipo_denominacion=" + tipo_denominacion + "]";
	}

}
