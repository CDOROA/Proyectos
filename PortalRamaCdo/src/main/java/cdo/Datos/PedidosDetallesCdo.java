package cdo.Datos;

import java.util.List;

public class PedidosDetallesCdo {
	private List<PedidoCdo> pedidoCdo;
	private List<PedidoCdoDetalle> detallePedidoCdo;
	
	
	public List<PedidoCdo> getPedidoCdo() {
		return pedidoCdo;
	}
	public void setPedidoCdo(List<PedidoCdo> pedidoCdo) {
		this.pedidoCdo = pedidoCdo;
	}
	public List<PedidoCdoDetalle> getDetallePedidoCdo() {
		return detallePedidoCdo;
	}
	public void setDetallePedidoCdo(List<PedidoCdoDetalle> detallePedidoCdo) {
		this.detallePedidoCdo = detallePedidoCdo;
	}
	
	
	public PedidosDetallesCdo() {
		super();
		this.pedidoCdo = null;
		this.detallePedidoCdo = null;
	}
	
	
	
}
