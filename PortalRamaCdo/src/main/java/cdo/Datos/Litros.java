package cdo.Datos;

import java.io.Serializable;

public class Litros implements Serializable{

	private static final long serialVersionUID = 1L;
	private String nom_litros;
	
	public Litros() {
		super();
	}
	
	public Litros(String nom_litros) {
		super();
		this.nom_litros = nom_litros;
	}

	public String getNom_litros() {
		return nom_litros;
	}

	public void setNom_litros(String nom_litros) {
		this.nom_litros = nom_litros;
	}

	@Override
	public String toString() {
		return "Litros [nom_litros=" + nom_litros + "]";
	}
}
