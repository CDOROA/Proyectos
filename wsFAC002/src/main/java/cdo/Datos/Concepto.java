package cdo.Datos;

public class Concepto {
	 private String cve_concepto;
	 private String descripcion;
	 private String c_ClaveProdServ;
	 private String c_ClaveUnidad;
	 private String unidad;
	 private String c_UsoCFDI;
	 
	public Concepto(String cve_concepto, String descripcion, String c_ClaveProdServ, String c_ClaveUnidad,
			String unidad, String c_UsoCFDI) {
		super();
		this.cve_concepto = cve_concepto;
		this.descripcion = descripcion;
		this.c_ClaveProdServ = c_ClaveProdServ;
		this.c_ClaveUnidad = c_ClaveUnidad;
		this.unidad = unidad;
		this.c_UsoCFDI = c_UsoCFDI;
	}
	
	public Concepto() {
		super();
		this.cve_concepto = "";
		this.descripcion = "";
		this.c_ClaveProdServ = "";
		this.c_ClaveUnidad = "";
		this.unidad = "";
		this.c_UsoCFDI = "";
	}
	
	public String getCve_concepto() {
		return cve_concepto;
	}
	public void setCve_concepto(String cve_concepto) {
		this.cve_concepto = cve_concepto;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getC_ClaveProdServ() {
		return c_ClaveProdServ;
	}
	public void setC_ClaveProdServ(String c_ClaveProdServ) {
		this.c_ClaveProdServ = c_ClaveProdServ;
	}
	public String getC_ClaveUnidad() {
		return c_ClaveUnidad;
	}
	public void setC_ClaveUnidad(String c_ClaveUnidad) {
		this.c_ClaveUnidad = c_ClaveUnidad;
	}
	public String getUnidad() {
		return unidad;
	}
	public void setUnidad(String unidad) {
		this.unidad = unidad;
	}
	public String getC_UsoCFDI() {
		return c_UsoCFDI;
	}
	public void setC_UsoCFDI(String c_UsoCFDI) {
		this.c_UsoCFDI = c_UsoCFDI;
	}

	 
}
