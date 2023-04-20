package cdo.Datos;

import java.io.Serializable;

public class Catalogo_Agentes implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String num_agente;
	private String nombre_agente;
		
	public Catalogo_Agentes() {
		super();
	}

	public Catalogo_Agentes(String num_agente, String nombre_agente) {
		super();
		this.num_agente = num_agente;
		this.nombre_agente = nombre_agente;
	}

	public String getNum_agente() {
		return num_agente;
	}

	public void setNum_agente(String num_agente) {
		this.num_agente = num_agente;
	}

	public String getNombre_agente() {
		return nombre_agente;
	}

	public void setNombre_agente(String nombre_agente) {
		this.nombre_agente = nombre_agente;
	}

	@Override
	public String toString() {
		return "Catalogo_Agentes [num_agente=" + num_agente + ", nombre_agente=" + nombre_agente + "]";
	}
	
}
