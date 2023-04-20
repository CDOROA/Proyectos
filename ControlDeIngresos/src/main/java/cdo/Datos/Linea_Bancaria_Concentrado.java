package cdo.Datos;

import java.io.Serializable;

public class Linea_Bancaria_Concentrado implements Serializable {	

	private static final long serialVersionUID = 1L;
	private String cve_usu_cr;
	private String nombre_cve_usu;
	private String imp_banamex;
	private String imp_hsbc;
	private String imp_bbva;
	private String imp_banorte;
	private String imp_azteca;
	private String imp_total;
	private String id_estatus;
	private String nombre_estatus;
	
	public Linea_Bancaria_Concentrado() {
		super();
	}

	public Linea_Bancaria_Concentrado(String cve_usu_cr, String nombre_cve_usu, String imp_banamex, String imp_hsbc,
			String imp_bbva, String imp_banorte, String imp_azteca, String imp_total, String id_estatus,
			String nombre_estatus) {
		super();
		this.cve_usu_cr = cve_usu_cr;
		this.nombre_cve_usu = nombre_cve_usu;
		this.imp_banamex = imp_banamex;
		this.imp_hsbc = imp_hsbc;
		this.imp_bbva = imp_bbva;
		this.imp_banorte = imp_banorte;
		this.imp_azteca = imp_azteca;
		this.imp_total = imp_total;
		this.id_estatus = id_estatus;
		this.nombre_estatus = nombre_estatus;
	}

	public String getCve_usu_cr() {
		return cve_usu_cr;
	}

	public void setCve_usu_cr(String cve_usu_cr) {
		this.cve_usu_cr = cve_usu_cr;
	}

	public String getNombre_cve_usu() {
		return nombre_cve_usu;
	}

	public void setNombre_cve_usu(String nombre_cve_usu) {
		this.nombre_cve_usu = nombre_cve_usu;
	}

	public String getImp_banamex() {
		return imp_banamex;
	}

	public void setImp_banamex(String imp_banamex) {
		this.imp_banamex = imp_banamex;
	}

	public String getImp_hsbc() {
		return imp_hsbc;
	}

	public void setImp_hsbc(String imp_hsbc) {
		this.imp_hsbc = imp_hsbc;
	}

	public String getImp_bbva() {
		return imp_bbva;
	}

	public void setImp_bbva(String imp_bbva) {
		this.imp_bbva = imp_bbva;
	}

	public String getImp_banorte() {
		return imp_banorte;
	}

	public void setImp_banorte(String imp_banorte) {
		this.imp_banorte = imp_banorte;
	}

	public String getImp_azteca() {
		return imp_azteca;
	}

	public void setImp_azteca(String imp_azteca) {
		this.imp_azteca = imp_azteca;
	}

	public String getImp_total() {
		return imp_total;
	}

	public void setImp_total(String imp_total) {
		this.imp_total = imp_total;
	}

	public String getId_estatus() {
		return id_estatus;
	}

	public void setId_estatus(String id_estatus) {
		this.id_estatus = id_estatus;
	}

	public String getNombre_estatus() {
		return nombre_estatus;
	}

	public void setNombre_estatus(String nombre_estatus) {
		this.nombre_estatus = nombre_estatus;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Linea_Bancaria_Concentrado [cve_usu_cr=" + cve_usu_cr + ", nombre_cve_usu=" + nombre_cve_usu
				+ ", imp_banamex=" + imp_banamex + ", imp_hsbc=" + imp_hsbc + ", imp_bbva=" + imp_bbva
				+ ", imp_banorte=" + imp_banorte + ", imp_azteca=" + imp_azteca + ", imp_total=" + imp_total
				+ ", id_estatus=" + id_estatus + ", nombre_estatus=" + nombre_estatus + "]";
	}

}
