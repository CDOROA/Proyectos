package cdo.Datos;

public class Documento {
	private String serie;
	private String folio;
	private String uuid;
	private String tipoDoc;
	private String documento;
	private String rfcEmisor;
	private String cuenta;
	private String usuario;
	private String password;
	private String sucursal;
	private String uname_br;
	
	
	public Documento() {
		super();
	}
	
	
	public String getUname_br() {
		return uname_br;
	}


	public void setUname_br(String uname_br) {
		this.uname_br = uname_br;
	}


	public String getCuenta() {
		return cuenta;
	}

	
	public void setCuenta(String cuenta) {
		this.cuenta = cuenta;
	}



	public String getRfcEmisor() {
		return rfcEmisor;
	}

	public void setRfcEmisor(String rfcEmisor) {
		this.rfcEmisor = rfcEmisor;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSucursal() {
		return sucursal;
	}

	public void setSucursal(String sucursal) {
		this.sucursal = sucursal;
	}

	public String getSerie() {
		return serie;
	}
	public void setSerie(String serie) {
		this.serie = serie;
	}
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	public String getFolio() {
		return folio;
	}
	public void setFolio(String folio) {
		this.folio = folio;
	}
	public String getTipoDoc() {
		return tipoDoc;
	}
	public void setTipoDoc(String tipoDoc) {
		this.tipoDoc = tipoDoc;
	}
	public String getDocumento() {
		return documento;
	}
	public void setDocumento(String documento) {
		this.documento = documento;
	}

	@Override
	public String toString() {
		return "Documento [serie=" + serie + ", folio=" + folio + ", uuid=" + uuid + ", tipoDoc=" + tipoDoc
				+ ", documento=" + documento + ", rfcEmisor=" + rfcEmisor + ", cuenta=" + cuenta + ", usuario="
				+ usuario + ", password=" + password + ", sucursal=" + sucursal + ", uname_br=" + uname_br + "]";
	}
	
	
}
