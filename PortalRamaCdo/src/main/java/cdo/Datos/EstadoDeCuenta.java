package cdo.Datos;

import java.io.Serializable;
import java.util.List;

public class EstadoDeCuenta implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private int  num_cliente;
	private String saldo_vencido;	
	private String saldo_total;
	private List<EstadoDeCuentaFacturasDelDia> listFacturasDia;
	private List<EstadoDeCuentaPedidosDelDia> listPedidosDia;
			
	public EstadoDeCuenta() {
		super();
	}

	public EstadoDeCuenta(int num_cliente, String saldo_vencido, String saldo_total,
			List<EstadoDeCuentaFacturasDelDia> listFacturasDia, List<EstadoDeCuentaPedidosDelDia> listPedidosDia) {
		super();
		this.num_cliente = num_cliente;
		this.saldo_vencido = saldo_vencido;
		this.saldo_total = saldo_total;
		this.listFacturasDia = listFacturasDia;
		this.listPedidosDia = listPedidosDia;
	}


	public int getNum_cliente() {
		return num_cliente;
	}


	public void setNum_cliente(int num_cliente) {
		this.num_cliente = num_cliente;
	}


	public String getSaldo_vencido() {
		return saldo_vencido;
	}


	public void setSaldo_vencido(String saldo_vencido) {
		this.saldo_vencido = saldo_vencido;
	}


	public String getSaldo_total() {
		return saldo_total;
	}


	public void setSaldo_total(String saldo_total) {
		this.saldo_total = saldo_total;
	}


	public List<EstadoDeCuentaFacturasDelDia> getListFacturasDia() {
		return listFacturasDia;
	}


	public void setListFacturasDia(List<EstadoDeCuentaFacturasDelDia> listFacturasDia) {
		this.listFacturasDia = listFacturasDia;
	}


	public List<EstadoDeCuentaPedidosDelDia> getListPedidosDia() {
		return listPedidosDia;
	}


	public void setListPedidosDia(List<EstadoDeCuentaPedidosDelDia> listPedidosDia) {
		this.listPedidosDia = listPedidosDia;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "EstadoDeCuenta [num_cliente=" + num_cliente + ", saldo_vencido=" + saldo_vencido + ", saldo_total="
				+ saldo_total + ", listFacturasDia=" + listFacturasDia + ", listPedidosDia=" + listPedidosDia + "]";
	}	
}
