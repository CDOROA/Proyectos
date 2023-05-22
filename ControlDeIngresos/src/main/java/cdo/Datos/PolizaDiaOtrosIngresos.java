package cdo.Datos;

import java.io.Serializable;

public class PolizaDiaOtrosIngresos implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private int id_otro_ingreso;
	private String nombre_otro_ingreso;
	private String importe_efectivo;
	private String importe_cheque;
	private String importe_tCredito;
	private String importe_tDebito;
	private String importe_transferencia;
	private String importe_posfechado;
	
	public PolizaDiaOtrosIngresos() {
		super();
	}

	public PolizaDiaOtrosIngresos(int id_otro_ingreso, String nombre_otro_ingreso, String importe_efectivo,
			String importe_cheque, String importe_tCredito, String importe_tDebito, String importe_transferencia,
			String importe_posfechado) {
		super();
		this.id_otro_ingreso = id_otro_ingreso;
		this.nombre_otro_ingreso = nombre_otro_ingreso;
		this.importe_efectivo = importe_efectivo;
		this.importe_cheque = importe_cheque;
		this.importe_tCredito = importe_tCredito;
		this.importe_tDebito = importe_tDebito;
		this.importe_transferencia = importe_transferencia;
		this.importe_posfechado = importe_posfechado;
	}

	public int getId_otro_ingreso() {
		return id_otro_ingreso;
	}

	public void setId_otro_ingreso(int id_otro_ingreso) {
		this.id_otro_ingreso = id_otro_ingreso;
	}

	public String getNombre_otro_ingreso() {
		return nombre_otro_ingreso;
	}

	public void setNombre_otro_ingreso(String nombre_otro_ingreso) {
		this.nombre_otro_ingreso = nombre_otro_ingreso;
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

	@Override
	public String toString() {
		return "PolizaDiaOtrosIngresos [id_otro_ingreso=" + id_otro_ingreso + ", nombre_otro_ingreso="
				+ nombre_otro_ingreso + ", importe_efectivo=" + importe_efectivo + ", importe_cheque=" + importe_cheque
				+ ", importe_tCredito=" + importe_tCredito + ", importe_tDebito=" + importe_tDebito
				+ ", importe_transferencia=" + importe_transferencia + ", importe_posfechado=" + importe_posfechado
				+ "]";
	}
	
}
