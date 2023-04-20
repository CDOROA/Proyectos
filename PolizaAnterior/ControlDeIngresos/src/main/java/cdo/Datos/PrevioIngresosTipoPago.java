package cdo.Datos;

import java.io.Serializable;

public class PrevioIngresosTipoPago  implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private int id_tipo_pago;
	private String tipo_pago;
	private String importe;
	

	public PrevioIngresosTipoPago() {
		super();
	}

	public PrevioIngresosTipoPago(int id_tipo_pago, String tipo_pago, String importe) {
		super();
		this.id_tipo_pago = id_tipo_pago;
		this.tipo_pago = tipo_pago;
		this.importe = importe;
	}

	public int getId_tipo_pago() {
		return id_tipo_pago;
	}

	public void setId_tipo_pago(int id_tipo_pago) {
		this.id_tipo_pago = id_tipo_pago;
	}

	public String getTipo_pago() {
		return tipo_pago;
	}

	public void setTipo_pago(String tipo_pago) {
		this.tipo_pago = tipo_pago;
	}

	public String getImporte() {
		return importe;
	}

	public void setImporte(String importe) {
		this.importe = importe;
	}

	@Override
	public String toString() {
		return "PrevioIngresosTipoPago [id_tipo_pago=" + id_tipo_pago + ", tipo_pago=" + tipo_pago + ", importe="
				+ importe + "]";
	}
	
	
}
