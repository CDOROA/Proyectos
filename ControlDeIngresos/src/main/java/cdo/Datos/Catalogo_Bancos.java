package cdo.Datos;

import java.io.Serializable;

public class Catalogo_Bancos  implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private int cve_banco;
	private String nombre_banco;
	private String deposito;
	
	public Catalogo_Bancos() {
		super();
	}

	public Catalogo_Bancos(int cve_banco, String nombre_banco, String deposito) {
		super();
		this.cve_banco = cve_banco;
		this.nombre_banco = nombre_banco;
		this.deposito = deposito;
	}

	public int getCve_banco() {
		return cve_banco;
	}

	public void setCve_banco(int cve_banco) {
		this.cve_banco = cve_banco;
	}

	public String getNombre_banco() {
		return nombre_banco;
	}

	public void setNombre_banco(String nombre_banco) {
		this.nombre_banco = nombre_banco;
	}

	public String getDeposito() {
		return deposito;
	}

	public void setDeposito(String deposito) {
		this.deposito = deposito;
	}

	@Override
	public String toString() {
		return "Catalogo_Bancos [cve_banco=" + cve_banco + ", nombre_banco=" + nombre_banco + ", deposito=" + deposito
				+ "]";
	}

}
