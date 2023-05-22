package cdo.Datos;

import java.io.Serializable;

public class EstadoDeCuentaPedidosDelDia implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private String num_ped;
	private String hora_peido;
	private String fecha_pedido;
	
	public EstadoDeCuentaPedidosDelDia() {
		super();
	}

	public EstadoDeCuentaPedidosDelDia(String num_ped, String hora_peido, String fecha_pedido) {
		super();
		this.num_ped = num_ped;
		this.hora_peido = hora_peido;
		this.fecha_pedido = fecha_pedido;
	}

	public String getNum_ped() {
		return num_ped;
	}

	public void setNum_ped(String num_ped) {
		this.num_ped = num_ped;
	}

	public String getHora_peido() {
		return hora_peido;
	}

	public void setHora_peido(String hora_peido) {
		this.hora_peido = hora_peido;
	}

	public String getFecha_pedido() {
		return fecha_pedido;
	}

	public void setFecha_pedido(String fecha_pedido) {
		this.fecha_pedido = fecha_pedido;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "EstadoDeCuentaPedidosDelDia [num_ped=" + num_ped + ", hora_peido=" + hora_peido + ", fecha_pedido="
				+ fecha_pedido + "]";
	}
	
	

}
