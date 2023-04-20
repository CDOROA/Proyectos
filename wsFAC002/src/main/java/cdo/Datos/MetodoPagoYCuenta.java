package cdo.Datos;

public class MetodoPagoYCuenta {
	
	private String uname;
	private String num_cli;
	private String cve_medio_pago;
	private String num_cuenta;
	private String observacion;
	
	
	public MetodoPagoYCuenta(String uname, String num_cli, String cve_medio_pago, String num_cuenta,
			String observacion) {
		super();
		this.uname = uname;
		this.num_cli = num_cli;
		this.cve_medio_pago = cve_medio_pago;
		this.num_cuenta = num_cuenta;
		this.observacion = observacion;
	}
	
	public MetodoPagoYCuenta() {
		super();
		this.uname = "";
		this.num_cli = "";
		this.cve_medio_pago = "99";
		this.num_cuenta = "";
		this.observacion = "";
	}
	
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getNum_cli() {
		return num_cli;
	}
	public void setNum_cli(String num_cli) {
		this.num_cli = num_cli;
	}
	public String getCve_medio_pago() {
		return cve_medio_pago;
	}
	public void setCve_medio_pago(String cve_medio_pago) {
		this.cve_medio_pago = cve_medio_pago;
	}
	public String getNum_cuenta() {
		return num_cuenta;
	}
	public void setNum_cuenta(String num_cuenta) {
		this.num_cuenta = num_cuenta;
	}
	public String getObservacion() {
		return observacion;
	}
	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}
	
	
}
