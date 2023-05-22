package cdo.Datos;

public class DetalleFolioHojaRuta {
	
	private String  uname_br;
	private String  folio_caja;
	private String  num_fac;
	private String  cve_forma_pago;
	private String  descripcion;
	private String  importe;
	
	
	public DetalleFolioHojaRuta() {
		super();
	}

	public DetalleFolioHojaRuta(String uname_br, String folio_caja, String num_fac, String cve_forma_pago,
			String descripcion, String importe) {
		super();
		this.uname_br = uname_br;
		this.folio_caja = folio_caja;
		this.num_fac = num_fac;
		this.cve_forma_pago = cve_forma_pago;
		this.descripcion = descripcion;
		this.importe = importe;
	}

	public String getUname_br() {
		return uname_br;
	}


	public void setUname_br(String uname_br) {
		this.uname_br = uname_br;
	}


	public String getFolio_caja() {
		return folio_caja;
	}


	public void setFolio_caja(String folio_caja) {
		this.folio_caja = folio_caja;
	}


	public String getNum_fac() {
		return num_fac;
	}


	public void setNum_fac(String num_fac) {
		this.num_fac = num_fac;
	}


	public String getCve_forma_pago() {
		return cve_forma_pago;
	}


	public void setCve_forma_pago(String cve_forma_pago) {
		this.cve_forma_pago = cve_forma_pago;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public String getImporte() {
		return importe;
	}


	public void setImporte(String importe) {
		this.importe = importe;
	}


	@Override
	public String toString() {
		return "DetalleFolioHojaRuta [uname_br=" + uname_br + ", folio_caja=" + folio_caja + ", num_fac=" + num_fac
				+ ", cve_forma_pago=" + cve_forma_pago + ", descripcion=" + descripcion + ", importe=" + importe
				+ ", getUname_br()=" + getUname_br() + ", getFolio_caja()=" + getFolio_caja() + ", getNum_fac()="
				+ getNum_fac() + ", getCve_forma_pago()=" + getCve_forma_pago() + ", getDescripcion()="
				+ getDescripcion() + ", getImporte()=" + getImporte() + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
	}

}
