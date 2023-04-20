package cdo.Datos;

import java.io.Serializable;

public class Linea_Bancaria_Detalle_Concentrado implements Serializable {	

	private static final long serialVersionUID = 1L;
	private String uname;
	private String cve_usu_cr;
	private int cve_banco ;
	private String nombre_banco;
	private String fecha;  
	private String sucursal;
	private String referencia1; 
	private String referencia2; 
	private String concepto;
	private String importe;
	
	public Linea_Bancaria_Detalle_Concentrado() {
		super();
	}

	public Linea_Bancaria_Detalle_Concentrado(String uname, String cve_usu_cr, int cve_banco, String nombre_banco,
			String fecha, String sucursal, String referencia1, String referencia2, String concepto, String importe) {
		super();
		this.uname = uname;
		this.cve_usu_cr = cve_usu_cr;
		this.cve_banco = cve_banco;
		this.nombre_banco = nombre_banco;
		this.fecha = fecha;
		this.sucursal = sucursal;
		this.referencia1 = referencia1;
		this.referencia2 = referencia2;
		this.concepto = concepto;
		this.importe = importe;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getCve_usu_cr() {
		return cve_usu_cr;
	}

	public void setCve_usu_cr(String cve_usu_cr) {
		this.cve_usu_cr = cve_usu_cr;
	}

	public int getCve_banco() {
		return cve_banco;
	}

	public void setCve_banco(int cve_banco) {
		this.cve_banco = cve_banco;
	}

	public String getNombre_banco() {
		return nombre_banco;
	}

	public void setNombre_banco(String nombre_banco) {
		this.nombre_banco = nombre_banco;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getSucursal() {
		return sucursal;
	}

	public void setSucursal(String sucursal) {
		this.sucursal = sucursal;
	}

	public String getReferencia1() {
		return referencia1;
	}

	public void setReferencia1(String referencia1) {
		this.referencia1 = referencia1;
	}

	public String getReferencia2() {
		return referencia2;
	}

	public void setReferencia2(String referencia2) {
		this.referencia2 = referencia2;
	}

	public String getConcepto() {
		return concepto;
	}

	public void setConcepto(String concepto) {
		this.concepto = concepto;
	}

	public String getImporte() {
		return importe;
	}

	public void setImporte(String importe) {
		this.importe = importe;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Linea_Bancaria_Detalle_Concentrado [uname=" + uname + ", cve_usu_cr=" + cve_usu_cr + ", cve_banco="
				+ cve_banco + ", nombre_banco=" + nombre_banco + ", fecha=" + fecha + ", sucursal=" + sucursal
				+ ", referencia1=" + referencia1 + ", referencia2=" + referencia2 + ", concepto=" + concepto
				+ ", importe=" + importe + "]";
	}

}
