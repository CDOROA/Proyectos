package cdo.Datos;

import java.io.Serializable;

public class FichasBancariasEgresos implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private int cve_banco;
	private String banco;
	private String ficha_bancaria;
	private String importe;
	private String acumulado;
		
	public FichasBancariasEgresos() {
		super();
	}

	public FichasBancariasEgresos(int cve_banco, String banco, String ficha_bancaria, String importe,
			String acumulado) {
		super();
		this.cve_banco = cve_banco;
		this.banco = banco;
		this.ficha_bancaria = ficha_bancaria;
		this.importe = importe;
		this.acumulado = acumulado;
	}

	public int getCve_banco() {
		return cve_banco;
	}

	public void setCve_banco(int cve_banco) {
		this.cve_banco = cve_banco;
	}

	public String getBanco() {
		return banco;
	}

	public void setBanco(String banco) {
		this.banco = banco;
	}

	public String getFicha_bancaria() {
		return ficha_bancaria;
	}

	public void setFicha_bancaria(String ficha_bancaria) {
		this.ficha_bancaria = ficha_bancaria;
	}

	public String getImporte() {
		return importe;
	}

	public void setImporte(String importe) {
		this.importe = importe;
	}

	public String getAcumulado() {
		return acumulado;
	}

	public void setAcumulado(String acumulado) {
		this.acumulado = acumulado;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "FichasBancariasEgresos [cve_banco=" + cve_banco + ", banco=" + banco + ", ficha_bancaria="
				+ ficha_bancaria + ", importe=" + importe + ", acumulado=" + acumulado + "]";
	}
	
	
}
