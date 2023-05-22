package cdo.Datos;

import java.io.Serializable;

public class PolizaDiaTipoIngreso implements Serializable{

	
	private static final long serialVersionUID = 1L;
	private int tipo_pago;
	private String nombre_tipo_pago;
	private String importe_efectivo;
	private String importe_cheque;
	private String importe_tCredito;
	private String importe_tDebito;
	private String importe_transferencia;
	private String importe_posfechado;
	
	public PolizaDiaTipoIngreso() {
		super();
	}

	public PolizaDiaTipoIngreso(int tipo_pago, String nombre_tipo_pago, String importe_efectivo, String importe_cheque,
			String importe_tCredito, String importe_tDebito, String importe_transferencia, String importe_posfechado) {
		super();
		this.tipo_pago = tipo_pago;
		this.nombre_tipo_pago = nombre_tipo_pago;
		this.importe_efectivo = importe_efectivo;
		this.importe_cheque = importe_cheque;
		this.importe_tCredito = importe_tCredito;
		this.importe_tDebito = importe_tDebito;
		this.importe_transferencia = importe_transferencia;
		this.importe_posfechado = importe_posfechado;
	}

	public int getTipo_pago() {
		return tipo_pago;
	}

	public void setTipo_pago(int tipo_pago) {
		this.tipo_pago = tipo_pago;
	}

	public String getNombre_tipo_pago() {
		return nombre_tipo_pago;
	}

	public void setNombre_tipo_pago(String nombre_tipo_pago) {
		this.nombre_tipo_pago = nombre_tipo_pago;
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
		return "PolizaDiaTipoIngreso [tipo_pago=" + tipo_pago + ", nombre_tipo_pago=" + nombre_tipo_pago
				+ ", importe_efectivo=" + importe_efectivo + ", importe_cheque=" + importe_cheque
				+ ", importe_tCredito=" + importe_tCredito + ", importe_tDebito=" + importe_tDebito
				+ ", importe_transferencia=" + importe_transferencia + ", importe_posfechado=" + importe_posfechado + "]";
	}
			
}
