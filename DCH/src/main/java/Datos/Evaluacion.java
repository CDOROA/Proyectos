package Datos;

import java.util.Date;

public class Evaluacion {
	private String idEvaluacion;
	private String idEncuesta;
	private String nombre;
	private String estatus;
	private Date vigenciaInicio;
	private Date vigenciaFin;
	
	public Evaluacion() {
		super();
	}
	
	

	public String getIdEncuesta() {
		return idEncuesta;
	}
	public void setIdEncuesta(String idEncuesta) {
		this.idEncuesta = idEncuesta;
	}
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getIdEvaluacion() {
		return idEvaluacion;
	}
	public void setIdEvaluacion(String idEvaluacion) {
		this.idEvaluacion = idEvaluacion;
	}
	public String getEstatus() {
		return estatus;
	}
	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}
	public Date getVigenciaInicio() {
		return vigenciaInicio;
	}
	public void setVigenciaInicio(Date vigenciaInicio) {
		this.vigenciaInicio = vigenciaInicio;
	}
	public Date getVigenciaFin() {
		return vigenciaFin;
	}
	public void setVigenciaFin(Date vigenciaFin) {
		this.vigenciaFin = vigenciaFin;
	}



	@Override
	public String toString() {
		return "Evaluacion [idEvaluacion=" + idEvaluacion + ", idEncuesta=" + idEncuesta + ", nombre=" + nombre
				+ ", estatus=" + estatus + ", vigenciaInicio=" + vigenciaInicio + ", vigenciaFin=" + vigenciaFin + "]";
	}

	
}
