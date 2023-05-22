package cdo.Datos;

import java.io.Serializable;

public class Vacantes  implements Serializable{

	private static final long serialVersionUID = 1L;
	private int cve_vacante;
	private int cve_empresa;
	private String nombre_empresa;
	private int cve_puesto;
	private String nombre_puesto;
	private String descripcion_vacantes;
	private String fecha_publicacion;
	private String horario_vacante;
	private String lugar_trabajo;
	private String observaciones;
	
	
	public Vacantes() {
		super();
	}

	public Vacantes(int cve_vacante, int cve_empresa, String nombre_empresa, int cve_puesto, String nombre_puesto,
			String descripcion_vacantes, String fecha_publicacion, String horario_vacante, String lugar_trabajo,
			String observaciones) {
		super();
		this.cve_vacante = cve_vacante;
		this.cve_empresa = cve_empresa;
		this.nombre_empresa = nombre_empresa;
		this.cve_puesto = cve_puesto;
		this.nombre_puesto = nombre_puesto;
		this.descripcion_vacantes = descripcion_vacantes;
		this.fecha_publicacion = fecha_publicacion;
		this.horario_vacante = horario_vacante;
		this.lugar_trabajo = lugar_trabajo;
		this.observaciones = observaciones;
	}



	public String getObservaciones() {
		return observaciones;
	}



	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}



	public int getCve_vacante() {
		return cve_vacante;
	}

	public void setCve_vacante(int cve_vacante) {
		this.cve_vacante = cve_vacante;
	}

	public int getCve_empresa() {
		return cve_empresa;
	}

	public void setCve_empresa(int cve_empresa) {
		this.cve_empresa = cve_empresa;
	}

	public String getNombre_empresa() {
		return nombre_empresa;
	}

	public void setNombre_empresa(String nombre_empresa) {
		this.nombre_empresa = nombre_empresa;
	}

	public int getCve_puesto() {
		return cve_puesto;
	}

	public void setCve_puesto(int cve_puesto) {
		this.cve_puesto = cve_puesto;
	}

	public String getNombre_puesto() {
		return nombre_puesto;
	}

	public void setNombre_puesto(String nombre_puesto) {
		this.nombre_puesto = nombre_puesto;
	}

	public String getDescripcion_vacantes() {
		return descripcion_vacantes;
	}

	public void setDescripcion_vacantes(String descripcion_vacantes) {
		this.descripcion_vacantes = descripcion_vacantes;
	}

	public String getFecha_publicacion() {
		return fecha_publicacion;
	}

	public void setFecha_publicacion(String fecha_publicacion) {
		this.fecha_publicacion = fecha_publicacion;
	}

	public String getHorario_vacante() {
		return horario_vacante;
	}

	public void setHorario_vacante(String horario_vacante) {
		this.horario_vacante = horario_vacante;
	}

	public String getLugar_trabajo() {
		return lugar_trabajo;
	}

	public void setLugar_trabajo(String lugar_trabajo) {
		this.lugar_trabajo = lugar_trabajo;
	}

	@Override
	public String toString() {
		return "Vacantes [cve_vacante=" + cve_vacante + ", cve_empresa=" + cve_empresa + ", nombre_empresa="
				+ nombre_empresa + ", cve_puesto=" + cve_puesto + ", nombre_puesto=" + nombre_puesto
				+ ", descripcion_vacantes=" + descripcion_vacantes + ", fecha_publicacion=" + fecha_publicacion
				+ ", horario_vacante=" + horario_vacante + ", lugar_trabajo=" + lugar_trabajo + ", observaciones="
				+ observaciones + "]";
	}
	
}
