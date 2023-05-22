package cdo.Datos;

public class EstadoDeCuentaDetalle {
	
	private String factura;
	private String fecha_factura;
	private String importe_real;
	private String saldo;
	private String fecha_vencimiento;
	private String dias_vencidos;
		
	public EstadoDeCuentaDetalle() {
		super();
	}

	public EstadoDeCuentaDetalle(String factura, String fecha_factura, String importe_real, String saldo,
			String fecha_vencimiento, String dias_vencidos) {
		super();
		this.factura = factura;
		this.fecha_factura = fecha_factura;
		this.importe_real = importe_real;
		this.saldo = saldo;
		this.fecha_vencimiento = fecha_vencimiento;
		this.dias_vencidos = dias_vencidos;
	}


	public String getFactura() {
		return factura;
	}


	public void setFactura(String factura) {
		this.factura = factura;
	}


	public String getFecha_factura() {
		return fecha_factura;
	}


	public void setFecha_factura(String fecha_factura) {
		this.fecha_factura = fecha_factura;
	}


	public String getImporte_real() {
		return importe_real;
	}


	public void setImporte_real(String importe_real) {
		this.importe_real = importe_real;
	}


	public String getSaldo() {
		return saldo;
	}


	public void setSaldo(String saldo) {
		this.saldo = saldo;
	}


	public String getFecha_vencimiento() {
		return fecha_vencimiento;
	}


	public void setFecha_vencimiento(String fecha_vencimiento) {
		this.fecha_vencimiento = fecha_vencimiento;
	}


	public String getDias_vencidos() {
		return dias_vencidos;
	}


	public void setDias_vencidos(String dias_vencidos) {
		this.dias_vencidos = dias_vencidos;
	}


	@Override
	public String toString() {
		return "EstadoDeCuentaDetalle [factura=" + factura + ", fecha_factura=" + fecha_factura + ", importe_real="
				+ importe_real + ", saldo=" + saldo + ", fecha_vencimiento=" + fecha_vencimiento + ", dias_vencidos="
				+ dias_vencidos + "]";
	}
	
}
