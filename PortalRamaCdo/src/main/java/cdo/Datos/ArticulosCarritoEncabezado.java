package cdo.Datos;

import java.io.Serializable;

public class ArticulosCarritoEncabezado implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private int cve_centro;
	private int num_cliente;
	private String nombre_cliente;
	private int num_pedido;
	private String fecha_pedido;
	private int totalArticulosEnCarrito;
	
	
	public int getTotalArticulosEnCarrito() {
		return totalArticulosEnCarrito;
	}

	public void setTotalArticulosEnCarrito(int totalArticulosEnCarrito) {
		this.totalArticulosEnCarrito = totalArticulosEnCarrito;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public ArticulosCarritoEncabezado() {
		super();
	}

	public ArticulosCarritoEncabezado(int cve_centro, int num_cliente, String nombre_cliente, int num_pedido,
			String fecha_pedido,  int totalArticulosEnCarrito) {
		super();
		this.cve_centro = cve_centro;
		this.num_cliente = num_cliente;
		this.nombre_cliente = nombre_cliente;
		this.num_pedido = num_pedido;
		this.fecha_pedido = fecha_pedido;
		this.totalArticulosEnCarrito = totalArticulosEnCarrito;
	}

	public int getCve_centro() {
		return cve_centro;
	}

	public void setCve_centro(int cve_centro) {
		this.cve_centro = cve_centro;
	}

	public int getNum_cliente() {
		return num_cliente;
	}

	public void setNum_cliente(int num_cliente) {
		this.num_cliente = num_cliente;
	}

	public String getNombre_cliente() {
		return nombre_cliente;
	}

	public void setNombre_cliente(String nombre_cliente) {
		this.nombre_cliente = nombre_cliente;
	}

	public int getNum_pedido() {
		return num_pedido;
	}

	public void setNum_pedido(int num_pedido) {
		this.num_pedido = num_pedido;
	}

	public String getFecha_pedido() {
		return fecha_pedido;
	}

	public void setFecha_pedido(String fecha_pedido) {
		this.fecha_pedido = fecha_pedido;
	}

	@Override
	public String toString() {
		return "EncabezadoArticulosCarrito [cve_centro=" + cve_centro + ", num_cliente=" + num_cliente
				+ ", nombre_cliente=" + nombre_cliente + ", num_pedido=" + num_pedido + ", fecha_pedido=" + fecha_pedido
				+ "]";
	}
	
}
