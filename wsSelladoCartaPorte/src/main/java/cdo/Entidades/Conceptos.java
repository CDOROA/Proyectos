package cdo.Entidades;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Conceptos extends Identificadores implements Serializable
{
	
	private String num_renglon;
	private String cantidad;
	private String c_ClaveProdServ;
	private String c_ClaveUnidad;
	private String desc_unidad;
	private String noidentificacion;
	private String descripcion;
	private String valorunitario;
	private String importe;
	private String descuento;
	private String basetraslado;
	private String importetraslado;
	private String impuestotraslado;
	private String tasaocuotatraslado;
	private String tipofactortraslado;
	private String baseretencion;
	private String impretencion;
	private String impuestoretencion;
	private String tasaocuotaretencion;
	private String tipo_factorretencion;
	private String factura;
	private String grupo;
	private String aplicaicon;
	private String proveedor;
	private String ode;
	
	public Conceptos() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Conceptos(String uname, String folio, String serie, String carta_porte) {
		super(uname, folio, serie, carta_porte);
		// TODO Auto-generated constructor stub
	}
	public Conceptos(String num_renglon, String cantidad, String c_ClaveProdServ, String c_ClaveUnidad,
			String desc_unidad, String noidentificacion, String descripcion, String valorunitario, String importe,
			String descuento, String basetraslado, String importetraslado, String impuestotraslado,
			String tasaocuotatraslado, String tipofactortraslado, String baseretencion, String impretencion,
			String impuestoretencion, String tasaocuotaretencion, String tipo_factorretencion, String factura,
			String grupo, String aplicaicon, String proveedor, String ode) {
		super();
		this.num_renglon = num_renglon;
		this.cantidad = cantidad;
		this.c_ClaveProdServ = c_ClaveProdServ;
		this.c_ClaveUnidad = c_ClaveUnidad;
		this.desc_unidad = desc_unidad;
		this.noidentificacion = noidentificacion;
		this.descripcion = descripcion;
		this.valorunitario = valorunitario;
		this.importe = importe;
		this.descuento = descuento;
		this.basetraslado = basetraslado;
		this.importetraslado = importetraslado;
		this.impuestotraslado = impuestotraslado;
		this.tasaocuotatraslado = tasaocuotatraslado;
		this.tipofactortraslado = tipofactortraslado;
		this.baseretencion = baseretencion;
		this.impretencion = impretencion;
		this.impuestoretencion = impuestoretencion;
		this.tasaocuotaretencion = tasaocuotaretencion;
		this.tipo_factorretencion = tipo_factorretencion;
		this.factura = factura;
		this.grupo = grupo;
		this.aplicaicon = aplicaicon;
		this.proveedor = proveedor;
		this.ode = ode;
	}
	public String getNum_renglon() {
		return num_renglon;
	}
	public void setNum_renglon(String num_renglon) {
		this.num_renglon = num_renglon;
	}
	public String getCantidad() {
		return cantidad;
	}
	public void setCantidad(String cantidad) {
		this.cantidad = cantidad;
	}
	public String getC_ClaveProdServ() {
		return c_ClaveProdServ;
	}
	public void setC_ClaveProdServ(String c_ClaveProdServ) {
		this.c_ClaveProdServ = c_ClaveProdServ;
	}
	public String getC_ClaveUnidad() {
		return c_ClaveUnidad;
	}
	public void setC_ClaveUnidad(String c_ClaveUnidad) {
		this.c_ClaveUnidad = c_ClaveUnidad;
	}
	public String getDesc_unidad() {
		return desc_unidad;
	}
	public void setDesc_unidad(String desc_unidad) {
		this.desc_unidad = desc_unidad;
	}
	public String getNoidentificacion() {
		return noidentificacion;
	}
	public void setNoidentificacion(String noidentificacion) {
		this.noidentificacion = noidentificacion;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getValorunitario() {
		return valorunitario;
	}
	public void setValorunitario(String valorunitario) {
		this.valorunitario = valorunitario;
	}
	public String getImporte() {
		return importe;
	}
	public void setImporte(String importe) {
		this.importe = importe;
	}
	public String getDescuento() {
		return descuento;
	}
	public void setDescuento(String descuento) {
		this.descuento = descuento;
	}
	public String getBasetraslado() {
		return basetraslado;
	}
	public void setBasetraslado(String basetraslado) {
		this.basetraslado = basetraslado;
	}
	public String getImportetraslado() {
		return importetraslado;
	}
	public void setImportetraslado(String importetraslado) {
		this.importetraslado = importetraslado;
	}
	public String getImpuestotraslado() {
		return impuestotraslado;
	}
	public void setImpuestotraslado(String impuestotraslado) {
		this.impuestotraslado = impuestotraslado;
	}
	public String getTasaocuotatraslado() {
		return tasaocuotatraslado;
	}
	public void setTasaocuotatraslado(String tasaocuotatraslado) {
		this.tasaocuotatraslado = tasaocuotatraslado;
	}
	public String getTipofactortraslado() {
		return tipofactortraslado;
	}
	public void setTipofactortraslado(String tipofactortraslado) {
		this.tipofactortraslado = tipofactortraslado;
	}
	public String getBaseretencion() {
		return baseretencion;
	}
	public void setBaseretencion(String baseretencion) {
		this.baseretencion = baseretencion;
	}
	public String getImpretencion() {
		return impretencion;
	}
	public void setImpretencion(String impretencion) {
		this.impretencion = impretencion;
	}
	public String getImpuestoretencion() {
		return impuestoretencion;
	}
	public void setImpuestoretencion(String impuestoretencion) {
		this.impuestoretencion = impuestoretencion;
	}
	public String getTasaocuotaretencion() {
		return tasaocuotaretencion;
	}
	public void setTasaocuotaretencion(String tasaocuotaretencion) {
		this.tasaocuotaretencion = tasaocuotaretencion;
	}
	public String getTipo_factorretencion() {
		return tipo_factorretencion;
	}
	public void setTipo_factorretencion(String tipo_factorretencion) {
		this.tipo_factorretencion = tipo_factorretencion;
	}
	public String getFactura() {
		return factura;
	}
	public void setFactura(String factura) {
		this.factura = factura;
	}
	public String getGrupo() {
		return grupo;
	}
	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}
	public String getAplicaicon() {
		return aplicaicon;
	}
	public void setAplicaicon(String aplicaicon) {
		this.aplicaicon = aplicaicon;
	}
	public String getProveedor() {
		return proveedor;
	}
	public void setProveedor(String proveedor) {
		this.proveedor = proveedor;
	}
	public String getOde() {
		return ode;
	}
	public void setOde(String ode) {
		this.ode = ode;
	}
	@Override
	public String toString() {
		return "Conceptos [num_renglon=" + num_renglon + ", cantidad=" + cantidad + ", c_ClaveProdServ="
				+ c_ClaveProdServ + ", c_ClaveUnidad=" + c_ClaveUnidad + ", desc_unidad=" + desc_unidad
				+ ", noidentificacion=" + noidentificacion + ", descripcion=" + descripcion + ", valorunitario="
				+ valorunitario + ", importe=" + importe + ", descuento=" + descuento + ", basetraslado=" + basetraslado
				+ ", importetraslado=" + importetraslado + ", impuestotraslado=" + impuestotraslado
				+ ", tasaocuotatraslado=" + tasaocuotatraslado + ", tipofactortraslado=" + tipofactortraslado
				+ ", baseretencion=" + baseretencion + ", impretencion=" + impretencion + ", impuestoretencion="
				+ impuestoretencion + ", tasaocuotaretencion=" + tasaocuotaretencion + ", tipo_factorretencion="
				+ tipo_factorretencion + ", factura=" + factura + ", grupo=" + grupo + ", aplicaicon=" + aplicaicon
				+ ", proveedor=" + proveedor + ", ode=" + ode + "]";
	}
	
}
