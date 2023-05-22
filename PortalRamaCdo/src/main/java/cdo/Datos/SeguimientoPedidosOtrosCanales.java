package cdo.Datos;

public class SeguimientoPedidosOtrosCanales {
	private String descripcionCanal;
	private int pedido;
	private String fecha;
	private String hora;
	private String transporte;
	private int numArticulos;
	private int cantPedida;
	private String estatusAlmacen;
	private String estatusEntrega;
	private String idEstatusAlmacenPng;
	private String idEstatusEntregaPng;
	public String getDescripcionCanal() {
		return descripcionCanal;
	}
	public void setDescripcionCanal(String descripcionCanal) {
		this.descripcionCanal = descripcionCanal;
	}
	public int getPedido() {
		return pedido;
	}
	public void setPedido(int pedido) {
		this.pedido = pedido;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public String getHora() {
		return hora;
	}
	public void setHora(String hora) {
		this.hora = hora;
	}
	public String getTransporte() {
		return transporte;
	}
	public void setTransporte(String transporte) {
		this.transporte = transporte;
	}
	public int getNumArticulos() {
		return numArticulos;
	}
	public void setNumArticulos(int numArticulos) {
		this.numArticulos = numArticulos;
	}
	public int getCantPedida() {
		return cantPedida;
	}
	public void setCantPedida(int cantPedida) {
		this.cantPedida = cantPedida;
	}
	public String getEstatusAlmacen() {
		return estatusAlmacen;
	}
	public void setEstatusAlmacen(String estatusAlmacen) {
		this.estatusAlmacen = estatusAlmacen;
	}
	public String getEstatusEntrega() {
		return estatusEntrega;
	}
	public void setEstatusEntrega(String estatusEntrega) {
		this.estatusEntrega = estatusEntrega;
	}
	public String getIdEstatusAlmacenPng() {
		return idEstatusAlmacenPng;
	}
	public void setIdEstatusAlmacenPng(String idEstatusAlmacenPng) {
		this.idEstatusAlmacenPng = idEstatusAlmacenPng;
	}
	public String getIdEstatusEntregaPng() {
		return idEstatusEntregaPng;
	}
	public void setIdEstatusEntregaPng(String idEstatusEntregaPng) {
		this.idEstatusEntregaPng = idEstatusEntregaPng;
	}
	
	public SeguimientoPedidosOtrosCanales() {
		super();
		this.descripcionCanal = "";
		this.pedido = 0;
		this.fecha = "";
		this.hora = "";
		this.transporte = "";
		this.numArticulos = 0;
		this.cantPedida = 0;
		this.estatusAlmacen = "";
		this.estatusEntrega = "";
		this.idEstatusAlmacenPng = "";
		this.idEstatusEntregaPng = "";
	}
	@Override
	public String toString() {
		return "SeguimientoPedidosOtrosCanales [descripcionCanal=" + descripcionCanal + ", pedido=" + pedido
				+ ", fecha=" + fecha + ", hora=" + hora + ", transporte=" + transporte + ", numArticulos="
				+ numArticulos + ", cantPedida=" + cantPedida + ", estatusAlmacen=" + estatusAlmacen
				+ ", estatusEntrega=" + estatusEntrega + ", idEstatusAlmacenPng=" + idEstatusAlmacenPng
				+ ", idEstatusEntregaPng=" + idEstatusEntregaPng + "]";
	}
	
	
}
