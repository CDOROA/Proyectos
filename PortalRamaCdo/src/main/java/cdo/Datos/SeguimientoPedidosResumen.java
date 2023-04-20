package cdo.Datos;

public class SeguimientoPedidosResumen {
	
	private int pedido;
	private int PedMayCdo;
	private int PedMayBr;
	private String Ped72Hrs;
	private int cantPedida;
	private int cantSurtida;
	private String importePedido;
	private String importeFacturado;
	private String fecha;
	private String hora;
	private String EstatusCdo;
	private String EstatusBr;
	private int cveEstatusCdo;
	private int cveEstatusBr;
	private String estatusEntrega;
	private String transporte;
	private String imgEntrega;
	private String Ped72HrsDescrip;

	
	
	public SeguimientoPedidosResumen() {
		super();
	}



	public int getPedido() {
		return pedido;
	}



	public void setPedido(int pedido) {
		this.pedido = pedido;
	}



	public int getPedMayCdo() {
		return PedMayCdo;
	}



	public void setPedMayCdo(int pedMayCdo) {
		PedMayCdo = pedMayCdo;
	}



	public int getPedMayBr() {
		return PedMayBr;
	}



	public void setPedMayBr(int pedMayBr) {
		PedMayBr = pedMayBr;
	}



	public String getPed72Hrs() {
		return Ped72Hrs;
	}



	public void setPed72Hrs(String ped72Hrs) {
		Ped72Hrs = ped72Hrs;
	}



	public int getCantPedida() {
		return cantPedida;
	}



	public void setCantPedida(int cantPedida) {
		this.cantPedida = cantPedida;
	}



	public int getCantSurtida() {
		return cantSurtida;
	}



	public void setCantSurtida(int cantSurtida) {
		this.cantSurtida = cantSurtida;
	}



	public String getImportePedido() {
		return importePedido;
	}



	public void setImportePedido(String importePedido) {
		this.importePedido = importePedido;
	}



	public String getImporteFacturado() {
		return importeFacturado;
	}



	public void setImporteFacturado(String importeFacturado) {
		this.importeFacturado = importeFacturado;
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



	public String getEstatusCdo() {
		return EstatusCdo;
	}



	public void setEstatusCdo(String estatusCdo) {
		EstatusCdo = estatusCdo;
	}



	public String getEstatusBr() {
		return EstatusBr;
	}



	public void setEstatusBr(String estatusBr) {
		EstatusBr = estatusBr;
	}



	public int getCveEstatusCdo() {
		return cveEstatusCdo;
	}



	public void setCveEstatusCdo(int cveEstatusCdo) {
		this.cveEstatusCdo = cveEstatusCdo;
	}



	public int getCveEstatusBr() {
		return cveEstatusBr;
	}



	public void setCveEstatusBr(int cveEstatusBr) {
		this.cveEstatusBr = cveEstatusBr;
	}



	public String getEstatusEntrega() {
		return estatusEntrega;
	}



	public void setEstatusEntrega(String estatusEntrega) {
		this.estatusEntrega = estatusEntrega;
	}



	public String getTransporte() {
		return transporte;
	}



	public void setTransporte(String transporte) {
		this.transporte = transporte;
	}



	public String getImgEntrega() {
		return imgEntrega;
	}



	public void setImgEntrega(String imgEntrega) {
		this.imgEntrega = imgEntrega;
	}



	public String getPed72HrsDescrip() {
		return Ped72HrsDescrip;
	}



	public void setPed72HrsDescrip(String ped72HrsDescrip) {
		Ped72HrsDescrip = ped72HrsDescrip;
	}



	@Override
	public String toString() {
		return "SeguimientoPedidosResumen [pedido=" + pedido + ", PedMayCdo=" + PedMayCdo + ", PedMayBr=" + PedMayBr
				+ ", Ped72Hrs=" + Ped72Hrs + ", cantPedida=" + cantPedida + ", cantSurtida=" + cantSurtida
				+ ", importePedido=" + importePedido + ", importeFacturado=" + importeFacturado + ", fecha=" + fecha
				+ ", hora=" + hora + ", EstatusCdo=" + EstatusCdo + ", EstatusBr=" + EstatusBr + ", cveEstatusCdo="
				+ cveEstatusCdo + ", cveEstatusBr=" + cveEstatusBr + ", estatusEntrega=" + estatusEntrega
				+ ", transporte=" + transporte + ", imgEntrega=" + imgEntrega + "]";
	}




}


