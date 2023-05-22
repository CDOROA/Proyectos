package cdo.Datos;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Credito implements Serializable 
{
	private String id_traycto;
	private String no;
	private String num_chofer;
	private String factura;
	private String pedido;
	private String ode;
	private String cliente;
	private String importe;
	private String importe_cobrado;
	private String condicion;
	private String ruta;
	private String id_estatus;
	private String estatus;
	private String uname;
	private String uname_br;
	private String tipo;
	private String usuario_envios;
	private String usuario_corte;
	private String usuario_credito;
	private String fecha_envios;
	private String fecha_corte;
	private String fecha_credito;
	private String folio_corte;
	public Credito() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Credito(String id_traycto, String no, String num_chofer, String factura, String pedido, String ode,
			String cliente, String importe, String importe_cobrado, String condicion, String ruta, String id_estatus,
			String estatus, String uname, String uname_br, String tipo, String usuario_envios, String usuario_corte,
			String usuario_credito, String fecha_envios, String fecha_corte, String fecha_credito, String folio_corte) {
		super();
		this.id_traycto = id_traycto;
		this.no = no;
		this.num_chofer = num_chofer;
		this.factura = factura;
		this.pedido = pedido;
		this.ode = ode;
		this.cliente = cliente;
		this.importe = importe;
		this.importe_cobrado = importe_cobrado;
		this.condicion = condicion;
		this.ruta = ruta;
		this.id_estatus = id_estatus;
		this.estatus = estatus;
		this.uname = uname;
		this.uname_br = uname_br;
		this.tipo = tipo;
		this.usuario_envios = usuario_envios;
		this.usuario_corte = usuario_corte;
		this.usuario_credito = usuario_credito;
		this.fecha_envios = fecha_envios;
		this.fecha_corte = fecha_corte;
		this.fecha_credito = fecha_credito;
		this.folio_corte = folio_corte;
	}
	public String getId_traycto() {
		return id_traycto;
	}
	public void setId_traycto(String id_traycto) {
		this.id_traycto = id_traycto;
	}
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public String getNum_chofer() {
		return num_chofer;
	}
	public void setNum_chofer(String num_chofer) {
		this.num_chofer = num_chofer;
	}
	public String getFactura() {
		return factura;
	}
	public void setFactura(String factura) {
		this.factura = factura;
	}
	public String getPedido() {
		return pedido;
	}
	public void setPedido(String pedido) {
		this.pedido = pedido;
	}
	public String getOde() {
		return ode;
	}
	public void setOde(String ode) {
		this.ode = ode;
	}
	public String getCliente() {
		return cliente;
	}
	public void setCliente(String cliente) {
		this.cliente = cliente;
	}
	public String getImporte() {
		return importe;
	}
	public void setImporte(String importe) {
		this.importe = importe;
	}
	public String getImporte_cobrado() {
		return importe_cobrado;
	}
	public void setImporte_cobrado(String importe_cobrado) {
		this.importe_cobrado = importe_cobrado;
	}
	public String getCondicion() {
		return condicion;
	}
	public void setCondicion(String condicion) {
		this.condicion = condicion;
	}
	public String getRuta() {
		return ruta;
	}
	public void setRuta(String ruta) {
		this.ruta = ruta;
	}
	public String getId_estatus() {
		return id_estatus;
	}
	public void setId_estatus(String id_estatus) {
		this.id_estatus = id_estatus;
	}
	public String getEstatus() {
		return estatus;
	}
	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getUname_br() {
		return uname_br;
	}
	public void setUname_br(String uname_br) {
		this.uname_br = uname_br;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getUsuario_envios() {
		return usuario_envios;
	}
	public void setUsuario_envios(String usuario_envios) {
		this.usuario_envios = usuario_envios;
	}
	public String getUsuario_corte() {
		return usuario_corte;
	}
	public void setUsuario_corte(String usuario_corte) {
		this.usuario_corte = usuario_corte;
	}
	public String getUsuario_credito() {
		return usuario_credito;
	}
	public void setUsuario_credito(String usuario_credito) {
		this.usuario_credito = usuario_credito;
	}
	public String getFecha_envios() {
		return fecha_envios;
	}
	public void setFecha_envios(String fecha_envios) {
		this.fecha_envios = fecha_envios;
	}
	public String getFecha_corte() {
		return fecha_corte;
	}
	public void setFecha_corte(String fecha_corte) {
		this.fecha_corte = fecha_corte;
	}
	public String getFecha_credito() {
		return fecha_credito;
	}
	public void setFecha_credito(String fecha_credito) {
		this.fecha_credito = fecha_credito;
	}
	public String getFolio_corte() {
		return folio_corte;
	}
	public void setFolio_corte(String folio_corte) {
		this.folio_corte = folio_corte;
	}
	@Override
	public String toString() {
		return "Credito [id_traycto=" + id_traycto + ", no=" + no + ", num_chofer=" + num_chofer + ", factura="
				+ factura + ", pedido=" + pedido + ", ode=" + ode + ", cliente=" + cliente + ", importe=" + importe
				+ ", importe_cobrado=" + importe_cobrado + ", condicion=" + condicion + ", ruta=" + ruta
				+ ", id_estatus=" + id_estatus + ", estatus=" + estatus + ", uname=" + uname + ", uname_br=" + uname_br
				+ ", tipo=" + tipo + ", usuario_envios=" + usuario_envios + ", usuario_corte=" + usuario_corte
				+ ", usuario_credito=" + usuario_credito + ", fecha_envios=" + fecha_envios + ", fecha_corte="
				+ fecha_corte + ", fecha_credito=" + fecha_credito + ", folio_corte=" + folio_corte + "]";
	}
	
	
	
}
