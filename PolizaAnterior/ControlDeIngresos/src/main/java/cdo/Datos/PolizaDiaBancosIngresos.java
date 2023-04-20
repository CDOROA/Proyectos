package cdo.Datos;

import java.io.Serializable;

public class PolizaDiaBancosIngresos  implements Serializable{

	private static final long serialVersionUID = 1L;
	private int cve_banco;
	private String nombre_banco;
	private String importe_efectivo;
	private String importe_cheque;
	private String importe_tCredito;
	private String importe_tDebito;
	private String importe_transferencia;
	private String importe_posfechado;
	
	public PolizaDiaBancosIngresos() {
		super();
	}

	public PolizaDiaBancosIngresos(int cve_banco, String nombre_banco, String importe_efectivo, String importe_cheque,
			String importe_tCredito, String importe_tDebito, String importe_transferencia, String importe_posfechado) {
		super();
		this.cve_banco = cve_banco;
		this.nombre_banco = nombre_banco;
		this.importe_efectivo = importe_efectivo;
		this.importe_cheque = importe_cheque;
		this.importe_tCredito = importe_tCredito;
		this.importe_tDebito = importe_tDebito;
		this.importe_transferencia = importe_transferencia;
		this.importe_posfechado = importe_posfechado;
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

	public String getImporte_efectivo() {
		return importe_efectivo;
	}

	public void setImporte_efectivo(String importe_efectivo) {
		this.importe_efectivo = importe_efectivo;
	}

	public String getImporte_cheque() {
		return importe_cheque;
	}

	public void setImporte_cheque(String importe_cheque) {
		this.importe_cheque = importe_cheque;
	}

	public String getImporte_tCredito() {
		return importe_tCredito;
	}

	public void setImporte_tCredito(String importe_tCredito) {
		this.importe_tCredito = importe_tCredito;
	}

	public String getImporte_tDebito() {
		return importe_tDebito;
	}

	public void setImporte_tDebito(String importe_tDebito) {
		this.importe_tDebito = importe_tDebito;
	}

	public String getImporte_transferencia() {
		return importe_transferencia;
	}

	public void setImporte_transferencia(String importe_transferencia) {
		this.importe_transferencia = importe_transferencia;
	}

	public String getImporte_posfechado() {
		return importe_posfechado;
	}

	public void setImporte_posfechado(String importe_posfechado) {
		this.importe_posfechado = importe_posfechado;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "PolizaDiaBancosIngresos [cve_banco=" + cve_banco + ", nombre_banco=" + nombre_banco
				+ ", importe_efectivo=" + importe_efectivo + ", importe_cheque=" + importe_cheque
				+ ", importe_tCredito=" + importe_tCredito + ", importe_tDebito=" + importe_tDebito
				+ ", importe_transferencia=" + importe_transferencia + ", importe_posfechado=" + importe_posfechado + "]";
	}
	
}
