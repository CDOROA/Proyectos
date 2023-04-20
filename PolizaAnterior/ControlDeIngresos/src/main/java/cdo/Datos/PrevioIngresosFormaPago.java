package cdo.Datos;

import java.io.Serializable;

public class PrevioIngresosFormaPago implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private int cve_forma_pago;
	private String forma_pago;
	private String importe;
	
	public PrevioIngresosFormaPago() {
		super();
	}

	public PrevioIngresosFormaPago(int cve_forma_pago, String forma_pago, String importe) {
		super();
		this.cve_forma_pago = cve_forma_pago;
		this.forma_pago = forma_pago;
		this.importe = importe;
	}

	public int getCve_forma_pago() {
		return cve_forma_pago;
	}

	public void setCve_forma_pago(int cve_forma_pago) {
		this.cve_forma_pago = cve_forma_pago;
	}

	public String getForma_pago() {
		return forma_pago;
	}

	public void setForma_pago(String forma_pago) {
		this.forma_pago = forma_pago;
	}

	public String getImporte() {
		return importe;
	}

	public void setImporte(String importe) {
		this.importe = importe;
	}

	@Override
	public String toString() {
		return "PrevipIngresosFormaPago [cve_forma_pago=" + cve_forma_pago + ", forma_pago=" + forma_pago + ", importe="
				+ importe + "]";
	}
	
}
