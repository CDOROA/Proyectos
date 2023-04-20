package cdo.Datos;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Consecutivo implements Serializable
{
	private int consecutivo;
	private int cliente;
	public Consecutivo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Consecutivo(int consecutivo, int cliente) {
		super();
		this.consecutivo = consecutivo;
		this.cliente = cliente;
	}
	public int getConsecutivo() {
		return consecutivo;
	}
	public void setConsecutivo(int consecutivo) {
		this.consecutivo = consecutivo;
	}
	public int getCliente() {
		return cliente;
	}
	public void setCliente(int cliente) {
		this.cliente = cliente;
	}
	@Override
	public String toString() {
		return "Consecutivo [consecutivo=" + consecutivo + ", cliente=" + cliente + "]";
	}
}
