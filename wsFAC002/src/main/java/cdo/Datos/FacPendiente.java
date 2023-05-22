package cdo.Datos;

public class FacPendiente {
	private String uname; 
	private String num_cli;
	private String folio_canje;
	private String num_fac; 
	private String importe_total;
	private String sts; 
	private String cve_concepto; 
	private String fecha_factura;
	private String fecha_pro;
	private String hora_pro;
	private String desglosa_Iva;
	private String rfc;
	
	public FacPendiente(String uname, String num_cli, String folio_canje, String num_fac, String importe_total,
			String sts, String cve_concepto, String fecha_factura, String fecha_pro, String hora_pro, String rfc,
			String desglosa_Iva, String regimenFiscal) {
		super();
		this.uname = uname;
		this.num_cli = num_cli;
		this.folio_canje = folio_canje;
		this.num_fac = num_fac;
		this.importe_total = importe_total;
		this.sts = sts;
		this.cve_concepto = cve_concepto;
		this.fecha_factura = fecha_factura;
		this.fecha_pro = fecha_pro;
		this.hora_pro = hora_pro;
		this.rfc = rfc;
		this.desglosa_Iva = desglosa_Iva;
	}
	
	public FacPendiente() {
		super();
		this.uname = "";
		this.num_cli = "";
		this.folio_canje = "";
		this.num_fac = "";
		this.importe_total = "";
		this.sts = "";
		this.cve_concepto = "";
		this.fecha_factura = "";
		this.fecha_pro = "";
		this.hora_pro = "";
		this.rfc = "";
		this.desglosa_Iva = "";
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
	public String getFolio_canje() {
		return folio_canje;
	}
	public void setFolio_canje(String folio_canje) {
		this.folio_canje = folio_canje;
	}
	public String getNum_fac() {
		return num_fac;
	}
	public void setNum_fac(String num_fac) {
		this.num_fac = num_fac;
	}
	public String getImporte_total() {
		return importe_total;
	}
	public void setImporte_total(String importe_total) {
		this.importe_total = importe_total;
	}
	public String getSts() {
		return sts;
	}
	public void setSts(String sts) {
		this.sts = sts;
	}
	public String getCve_concepto() {
		return cve_concepto;
	}
	public void setCve_concepto(String cve_concepto) {
		this.cve_concepto = cve_concepto;
	}
	public String getFecha_factura() {
		return fecha_factura;
	}
	public void setFecha_factura(String fecha_factura) {
		this.fecha_factura = fecha_factura;
	}
	public String getFecha_pro() {
		return fecha_pro;
	}
	public void setFecha_pro(String fecha_pro) {
		this.fecha_pro = fecha_pro;
	}
	public String getHora_pro() {
		return hora_pro;
	}
	public void setHora_pro(String hora_pro) {
		this.hora_pro = hora_pro;
	}

	public String getDesglosa_Iva() {
		return desglosa_Iva;
	}
	public void setDesglosa_Iva(String desglosa_Iva) {
		this.desglosa_Iva = desglosa_Iva;
	}
	public String getRfc() {
		return rfc;
	}
	public void setRfc(String rfc) {
		this.rfc = rfc;
	}
	
	
}
