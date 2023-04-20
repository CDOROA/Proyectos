package Datos;

public class Comprobante {
	private String serie;
	private String folio;
	private String fechaCFDI;
	private String formaPago;
	private String importeDescuentos;
	private String moneda;
	private String tipoCambio;
	private String importeTotal;
	private String tipoComprobante;
	private String exportacion;
	private String metodoPago;
	private String importeSubTotal;
	private String lugarExpedicion;
	private String observaciones;
	private String ode;
	private String estatus;
	private String tipoDocumento;
	private String fechaPro;
	private String horaPro;
	
	public Comprobante() {
		super();
	}

	public String getSerie() {
		return serie;
	}

	public void setSerie(String serie) {
		this.serie = serie;
	}

	public String getFolio() {
		return folio;
	}

	public void setFolio(String folio) {
		this.folio = folio;
	}

	public String getFechaCFDI() {
		return fechaCFDI;
	}

	public void setFechaCFDI(String fechaCFDI) {
		this.fechaCFDI = fechaCFDI;
	}

	public String getFormaPago() {
		return formaPago;
	}

	public void setFormaPago(String formaPago) {
		this.formaPago = formaPago;
	}

	public String getImporteDescuentos() {
		return importeDescuentos;
	}

	public void setImporteDescuentos(String importeDescuentos) {
		this.importeDescuentos = importeDescuentos;
	}

	public String getMoneda() {
		return moneda;
	}

	public void setMoneda(String moneda) {
		this.moneda = moneda;
	}

	public String getTipoCambio() {
		return tipoCambio;
	}

	public void setTipoCambio(String tipoCambio) {
		this.tipoCambio = tipoCambio;
	}

	public String getImporteTotal() {
		return importeTotal;
	}

	public void setImporteTotal(String importeTotal) {
		this.importeTotal = importeTotal;
	}

	public String getTipoComprobante() {
		return tipoComprobante;
	}

	public void setTipoComprobante(String tipoComprobante) {
		this.tipoComprobante = tipoComprobante;
	}

	public String getExportacion() {
		return exportacion;
	}

	public void setExportacion(String exportacion) {
		this.exportacion = exportacion;
	}

	public String getMetodoPago() {
		return metodoPago;
	}

	public void setMetodoPago(String metodoPago) {
		this.metodoPago = metodoPago;
	}

	public String getImporteSubTotal() {
		return importeSubTotal;
	}

	public void setImporteSubTotal(String importeSubTotal) {
		this.importeSubTotal = importeSubTotal;
	}

	public String getLugarExpedicion() {
		return lugarExpedicion;
	}

	public void setLugarExpedicion(String lugarExpedicion) {
		this.lugarExpedicion = lugarExpedicion;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public String getOde() {
		return ode;
	}

	public void setOde(String ode) {
		this.ode = ode;
	}

	public String getEstatus() {
		return estatus;
	}

	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}

	public String getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public String getFechaPro() {
		return fechaPro;
	}

	public void setFechaPro(String fechaPro) {
		this.fechaPro = fechaPro;
	}

	public String getHoraPro() {
		return horaPro;
	}

	public void setHoraPro(String horaPro) {
		this.horaPro = horaPro;
	}

	@Override
	public String toString() {
		return "Comprobante [serie=" + serie + ", folio=" + folio + ", fechaCFDI=" + fechaCFDI + ", formaPago="
				+ formaPago + ", importeDescuentos=" + importeDescuentos + ", moneda=" + moneda + ", tipoCambio="
				+ tipoCambio + ", importeTotal=" + importeTotal + ", tipoComprobante=" + tipoComprobante
				+ ", exportacion=" + exportacion + ", metodoPago=" + metodoPago + ", importeSubTotal=" + importeSubTotal
				+ ", lugarExpedicion=" + lugarExpedicion + ", observaciones=" + observaciones + ", ode=" + ode
				+ ", estatus=" + estatus + ", tipoDocumento=" + tipoDocumento + ", fechaPro=" + fechaPro + ", horaPro="
				+ horaPro + "]";
	}
}
