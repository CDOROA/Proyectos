package cdo.Datos;

import java.util.List;

public class PedidoCdo {
	
	  private int numPedido;
	  private String estatus;
      private String descripcionEstatus;
      private String uname;
      private String descripcionUname;
      private String fechaPedido;
  	private String tipo;
    private List<PedidoCdoDetalle> detallePedidoCdo;
    
      public int getNumPedido() {
		return numPedido;
	}
	public void setNumPedido(int numPedido) {
		this.numPedido = numPedido;
	}
	public String getEstatus() {
		return estatus;
	}
	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}
	public String getDescripcionEstatus() {
		return descripcionEstatus;
	}
	public void setDescripcionEstatus(String descripcionEstatus) {
		this.descripcionEstatus = descripcionEstatus;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getDescripcionUname() {
		return descripcionUname;
	}
	public void setDescripcionUname(String descripcionUname) {
		this.descripcionUname = descripcionUname;
	}
	public String getFechaPedido() {
		return fechaPedido;
	}
	public void setFechaPedido(String fechaPedido) {
		this.fechaPedido = fechaPedido;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public List<PedidoCdoDetalle> getDetallePedidoCdo() {
		return detallePedidoCdo;
	}
	public void setDetallePedidoCdo(List<PedidoCdoDetalle> detallePedidoCdo) {
		this.detallePedidoCdo = detallePedidoCdo;
	}


      
      
	@Override
	public String toString() {
		return "PedidoCdo [numPedido=" + numPedido + ", estatus=" + estatus + ", descripcionEstatus="
				+ descripcionEstatus + ", uname=" + uname + ", descripcionUname=" + descripcionUname + ", fechaPedido="
				+ fechaPedido + ", tipo=" + tipo + ", detallePedidoCdo=" + detallePedidoCdo + "]";
	}
      
}
