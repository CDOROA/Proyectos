package cdo.Datos;

import java.io.Serializable;

public class Catalogo_Formas_Pago  implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private int cve_forma_pago;
	private String nombre_forma_pago;
	
	public Catalogo_Formas_Pago() {
		super();
	}

	public Catalogo_Formas_Pago(int cve_forma_pago, String nombre_forma_pago) {
		super();
		this.cve_forma_pago = cve_forma_pago;
		this.nombre_forma_pago = nombre_forma_pago;
	}

	public int getCve_forma_pago() {
		return cve_forma_pago;
	}

	public void setCve_forma_pago(int cve_forma_pago) {
		this.cve_forma_pago = cve_forma_pago;
	}

	public String getNombre_forma_pago() {
		return nombre_forma_pago;
	}

	public void setNombre_forma_pago(String nombre_forma_pago) {
		this.nombre_forma_pago = nombre_forma_pago;
	}

	@Override
	public String toString() {
		return "Catalogo_Formas_Pago [cve_forma_pago=" + cve_forma_pago + ", nombre_forma_pago=" + nombre_forma_pago
				+ "]";
	}
	
}
