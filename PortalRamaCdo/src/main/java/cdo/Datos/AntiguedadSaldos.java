package cdo.Datos;

import java.io.Serializable;

public class AntiguedadSaldos implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private int num_agente;
	private String num_fac;
	private String fecha_fac;
	private String fecha_dev;
	private String importe_fac;
	private String saldo_fac;
	private String marca_fac;
	private String fecha_pro;
	private String relacion;
	private String dias_vencidos;
	
	public AntiguedadSaldos() {
		super();
	}

	public AntiguedadSaldos(int num_agente, String num_fac, String fecha_fac, String fecha_dev, String importe_fac,
			String saldo_fac, String marca_fac, String fecha_pro, String relacion, String dias_vencidos) {
		super();
		this.num_agente = num_agente;
		this.num_fac = num_fac;
		this.fecha_fac = fecha_fac;
		this.fecha_dev = fecha_dev;
		this.importe_fac = importe_fac;
		this.saldo_fac = saldo_fac;
		this.marca_fac = marca_fac;
		this.fecha_pro = fecha_pro;
		this.relacion = relacion;
		this.dias_vencidos = dias_vencidos;
	}

	public int getNum_agente() {
		return num_agente;
	}

	public void setNum_agente(int num_agente) {
		this.num_agente = num_agente;
	}

	public String getNum_fac() {
		return num_fac;
	}

	public void setNum_fac(String num_fac) {
		this.num_fac = num_fac;
	}

	public String getFecha_fac() {
		return fecha_fac;
	}

	public void setFecha_fac(String fecha_fac) {
		this.fecha_fac = fecha_fac;
	}

	public String getFecha_dev() {
		return fecha_dev;
	}

	public void setFecha_dev(String fecha_dev) {
		this.fecha_dev = fecha_dev;
	}

	public String getImporte_fac() {
		return importe_fac;
	}

	public void setImporte_fac(String importe_fac) {
		this.importe_fac = importe_fac;
	}

	public String getSaldo_fac() {
		return saldo_fac;
	}

	public void setSaldo_fac(String saldo_fac) {
		this.saldo_fac = saldo_fac;
	}

	public String getMarca_fac() {
		return marca_fac;
	}

	public void setMarca_fac(String marca_fac) {
		this.marca_fac = marca_fac;
	}

	public String getFecha_pro() {
		return fecha_pro;
	}

	public void setFecha_pro(String fecha_pro) {
		this.fecha_pro = fecha_pro;
	}

	public String getRelacion() {
		return relacion;
	}

	public void setRelacion(String relacion) {
		this.relacion = relacion;
	}

	public String getDias_vencidos() {
		return dias_vencidos;
	}

	public void setDias_vencidos(String dias_vencidos) {
		this.dias_vencidos = dias_vencidos;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "AntiguedadSaldos [num_agente=" + num_agente + ", num_fac=" + num_fac + ", fecha_fac=" + fecha_fac
				+ ", fecha_dev=" + fecha_dev + ", importe_fac=" + importe_fac + ", saldo_fac=" + saldo_fac
				+ ", marca_fac=" + marca_fac + ", fecha_pro=" + fecha_pro + ", relacion=" + relacion
				+ ", dias_vencidos=" + dias_vencidos + "]";
	}

}
