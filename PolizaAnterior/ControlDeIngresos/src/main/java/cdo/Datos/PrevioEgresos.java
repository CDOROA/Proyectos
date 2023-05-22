package cdo.Datos;

import java.io.Serializable;

public class PrevioEgresos  implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private int id_egreso;
	private String nombre_egreso;
	private String importe_egreso;
	
	
	public PrevioEgresos() {
		super();
	}

	public PrevioEgresos(int id_egreso, String nombre_egreso, String importe_egreso) {
		super();
		this.id_egreso = id_egreso;
		this.nombre_egreso = nombre_egreso;
		this.importe_egreso = importe_egreso;
	}


	public int getId_egreso() {
		return id_egreso;
	}


	public void setId_egreso(int id_egreso) {
		this.id_egreso = id_egreso;
	}


	public String getNombre_egreso() {
		return nombre_egreso;
	}


	public void setNombre_egreso(String nombre_egreso) {
		this.nombre_egreso = nombre_egreso;
	}


	public String getImporte_egreso() {
		return importe_egreso;
	}


	public void setImporte_egreso(String importe_egreso) {
		this.importe_egreso = importe_egreso;
	}


	@Override
	public String toString() {
		return "PrevioEgresos [id_egreso=" + id_egreso + ", nombre_egreso=" + nombre_egreso + ", importe_egreso="
				+ importe_egreso + "]";
	}
	
}
