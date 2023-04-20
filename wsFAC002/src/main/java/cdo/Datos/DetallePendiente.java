package cdo.Datos;

public class DetallePendiente {
	private String uname;
	private String folio_canje;
	private String id_articulo;
	private String articulo;
	private String serie;
	private String motor;
	private String observaciones;
	private String sts;
	private String cantidad;
	private String precio;
	
	public DetallePendiente(String uname, String folio_canje, String id_articulo, String articulo, String serie,
			String motor, String observaciones, String sts, String cantidad, String precio) {
		super();
		this.uname = uname;
		this.folio_canje = folio_canje;
		this.id_articulo = id_articulo;
		this.articulo = articulo;
		this.serie = serie;
		this.motor = motor;
		this.observaciones = observaciones;
		this.sts = sts;
		this.cantidad = cantidad;
		this.precio = precio;
	}
	
	public DetallePendiente() {
		super();
		this.uname = "";
		this.folio_canje = "";
		this.id_articulo = "";
		this.articulo = "";
		this.serie = "";
		this.motor = "";
		this.observaciones = "";
		this.sts = "";
		this.cantidad = "";
		this.precio = "";
	}
	
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getFolio_canje() {
		return folio_canje;
	}
	public void setFolio_canje(String folio_canje) {
		this.folio_canje = folio_canje;
	}
	public String getId_articulo() {
		return id_articulo;
	}
	public void setId_articulo(String id_articulo) {
		this.id_articulo = id_articulo;
	}
	public String getArticulo() {
		return articulo;
	}
	public void setArticulo(String articulo) {
		this.articulo = articulo;
	}
	public String getSerie() {
		return serie;
	}
	public void setSerie(String serie) {
		this.serie = serie;
	}
	public String getMotor() {
		return motor;
	}
	public void setMotor(String motor) {
		this.motor = motor;
	}
	public String getObservaciones() {
		return observaciones;
	}
	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}
	public String getSts() {
		return sts;
	}
	public void setSts(String sts) {
		this.sts = sts;
	}
	public String getCantidad() {
		return cantidad;
	}
	public void setCantidad(String cantidad) {
		this.cantidad = cantidad;
	}
	public String getPrecio() {
		return precio;
	}
	public void setPrecio(String precio) {
		this.precio = precio;
	}
	
	
}
