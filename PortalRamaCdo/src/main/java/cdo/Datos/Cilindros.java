package cdo.Datos;

import java.io.Serializable;

public class Cilindros implements Serializable{

	private static final long serialVersionUID = 1L;
	private String nom_cilindros;
	
	public Cilindros() {
		super();
	}
		

	public Cilindros(String nom_cilindros) {
		super();
		this.nom_cilindros = nom_cilindros;
	}

	public String getNom_cilindros() {
		return nom_cilindros;
	}

	public void setNom_cilindros(String nom_cilindros) {
		this.nom_cilindros = nom_cilindros;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	@Override
	public String toString() {
		return "Cilindros [nom_cilindros=" + nom_cilindros + "]";
	}
	
}
