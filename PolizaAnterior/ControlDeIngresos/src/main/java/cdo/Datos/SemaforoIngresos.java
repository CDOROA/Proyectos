package cdo.Datos;

import java.io.Serializable;

public class SemaforoIngresos implements Serializable{

	private static final long serialVersionUID = 1L;
	private String importe_actual;
	private String importe_minimo;
	private String importe_maximo;
		
	public SemaforoIngresos() {
		super();
	}

	public SemaforoIngresos(String importe_actual, String importe_minimo, String importe_maximo) {
		super();
		this.importe_actual = importe_actual;
		this.importe_minimo = importe_minimo;
		this.importe_maximo = importe_maximo;
	}

	public String getImporte_actual() {
		return importe_actual;
	}

	public void setImporte_actual(String importe_actual) {
		this.importe_actual = importe_actual;
	}

	public String getImporte_minimo() {
		return importe_minimo;
	}

	public void setImporte_minimo(String importe_minimo) {
		this.importe_minimo = importe_minimo;
	}

	public String getImporte_maximo() {
		return importe_maximo;
	}

	public void setImporte_maximo(String importe_maximo) {
		this.importe_maximo = importe_maximo;
	}

	@Override
	public String toString() {
		return "SemaforoIngresos [importe_actual=" + importe_actual + ", importe_minimo=" + importe_minimo
				+ ", importe_maximo=" + importe_maximo + "]";
	}
}
