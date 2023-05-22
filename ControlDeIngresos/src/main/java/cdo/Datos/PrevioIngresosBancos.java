package cdo.Datos;

import java.io.Serializable;

public class PrevioIngresosBancos implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private int cve_banco;
	private String banco_nombre;
	private String importe;
	
		
	public PrevioIngresosBancos() {
		super();
	}


	public PrevioIngresosBancos(int cve_banco, String banco_nombre, String importe) {
		super();
		this.cve_banco = cve_banco;
		this.banco_nombre = banco_nombre;
		this.importe = importe;
	}


	public int getCve_banco() {
		return cve_banco;
	}


	public void setCve_banco(int cve_banco) {
		this.cve_banco = cve_banco;
	}


	public String getBanco_nombre() {
		return banco_nombre;
	}


	public void setBanco_nombre(String banco_nombre) {
		this.banco_nombre = banco_nombre;
	}


	public String getImporte() {
		return importe;
	}


	public void setImporte(String importe) {
		this.importe = importe;
	}


	@Override
	public String toString() {
		return "PrevioIngresosBancos [cve_banco=" + cve_banco + ", banco_nombre=" + banco_nombre + ", importe="
				+ importe + "]";
	}

	
}
