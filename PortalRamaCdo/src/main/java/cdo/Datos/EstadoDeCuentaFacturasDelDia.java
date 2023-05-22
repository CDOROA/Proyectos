package cdo.Datos;

import java.io.Serializable;

public class EstadoDeCuentaFacturasDelDia implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private String fecha_factura;
	private String num_factura;
	private String importe_factura;
	private int ode_factura;
		
	public EstadoDeCuentaFacturasDelDia() {
		super();
	}

	public EstadoDeCuentaFacturasDelDia(String fecha_factura, String num_factura, String importe_factura,
			int ode_factura) {
		super();
		this.fecha_factura = fecha_factura;
		this.num_factura = num_factura;
		this.importe_factura = importe_factura;
		this.ode_factura = ode_factura;
	}

	public String getFecha_factura() {
		return fecha_factura;
	}

	public void setFecha_factura(String fecha_factura) {
		this.fecha_factura = fecha_factura;
	}

	public String getNum_factura() {
		return num_factura;
	}

	public void setNum_factura(String num_factura) {
		this.num_factura = num_factura;
	}

	public String getImporte_factura() {
		return importe_factura;
	}

	public void setImporte_factura(String importe_factura) {
		this.importe_factura = importe_factura;
	}

	public int getOde_factura() {
		return ode_factura;
	}

	public void setOde_factura(int ode_factura) {
		this.ode_factura = ode_factura;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "EstadoDeCuentaFacturasDelDia [fecha_factura=" + fecha_factura + ", num_factura=" + num_factura
				+ ", importe_factura=" + importe_factura + ", ode_factura=" + ode_factura + "]";
	}

}
