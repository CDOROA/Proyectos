package cdo.Entidades;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Bodega implements Serializable
{
	private String uname_br;
	private int ruta;
	private int transporte;
	private int syf;
	private int cond_pago;
	private String vigencia;
	private int distancia;
	private String tipo_lf;
	public Bodega() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Bodega(String uname_br, int ruta, int transporte, int syf, int cond_pago, String vigencia, int distancia,
			String tipo_lf) {
		super();
		this.uname_br = uname_br;
		this.ruta = ruta;
		this.transporte = transporte;
		this.syf = syf;
		this.cond_pago = cond_pago;
		this.vigencia = vigencia;
		this.distancia = distancia;
		this.tipo_lf = tipo_lf;
	}
	public String getUname_br() {
		return uname_br;
	}
	public void setUname_br(String uname_br) {
		this.uname_br = uname_br;
	}
	public int getRuta() {
		return ruta;
	}
	public void setRuta(int ruta) {
		this.ruta = ruta;
	}
	public int getTransporte() {
		return transporte;
	}
	public void setTransporte(int transporte) {
		this.transporte = transporte;
	}
	public int getSyf() {
		return syf;
	}
	public void setSyf(int syf) {
		this.syf = syf;
	}
	public int getCond_pago() {
		return cond_pago;
	}
	public void setCond_pago(int cond_pago) {
		this.cond_pago = cond_pago;
	}
	public String getVigencia() {
		return vigencia;
	}
	public void setVigencia(String vigencia) {
		this.vigencia = vigencia;
	}
	public int getDistancia() {
		return distancia;
	}
	public void setDistancia(int distancia) {
		this.distancia = distancia;
	}
	public String getTipo_lf() {
		return tipo_lf;
	}
	public void setTipo_lf(String tipo_lf) {
		this.tipo_lf = tipo_lf;
	}
	@Override
	public String toString() {
		return "Bodega [uname_br=" + uname_br + ", ruta=" + ruta + ", transporte=" + transporte + ", syf=" + syf
				+ ", cond_pago=" + cond_pago + ", vigencia=" + vigencia + ", distancia=" + distancia + ", tipo_lf="
				+ tipo_lf + "]";
	}
	
}
