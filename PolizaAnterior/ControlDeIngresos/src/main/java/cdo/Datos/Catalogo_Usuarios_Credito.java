package cdo.Datos;

import java.io.Serializable;

public class Catalogo_Usuarios_Credito implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String cve_usu_credito; 
	private String nombre_usu_credito;
	
	public Catalogo_Usuarios_Credito() {
		super();
	}

	public Catalogo_Usuarios_Credito(String cve_usu_credito, String nombre_usu_credito) {
		super();
		this.cve_usu_credito = cve_usu_credito;
		this.nombre_usu_credito = nombre_usu_credito;
	}

	public String getCve_usu_credito() {
		return cve_usu_credito;
	}

	public void setCve_usu_credito(String cve_usu_credito) {
		this.cve_usu_credito = cve_usu_credito;
	}

	public String getNombre_usu_credito() {
		return nombre_usu_credito;
	}

	public void setNombre_usu_credito(String nombre_usu_credito) {
		this.nombre_usu_credito = nombre_usu_credito;
	}

	@Override
	public String toString() {
		return "Catalogo_Usuarios_Credito [cve_usu_credito=" + cve_usu_credito + ", nombre_usu_credito="
				+ nombre_usu_credito + "]";
	}
}
