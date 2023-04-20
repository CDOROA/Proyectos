package Datos;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Evaluacion {
	private int consecutivoPregunta;
	private List<String> pregunta;
	private int idTipoEncuesta;
	private List<String> competencia;
	private List<Integer> numP;
	private List<String> nombreCompleto;
	private List<String> estatus;
	private List<Date> vigenciaInicio;
	private List<Date> vigenciaFin;
	private	List<String> puesto;
	private	List<String> relacion;
	private List<Integer> idPerfil;
	private List<String> idEmpleadoev;
	private List<String> idPregunta;
	private List<Resultados> resultado;
	private String idEmpleado;
	private List<Double> porcentaje;
	private List<String> idEncuesta;
	
	public Evaluacion() {
		super();
		pregunta=new ArrayList<String>();
		competencia=new ArrayList<String>();
		nombreCompleto=new ArrayList<String>();
		numP = new ArrayList<Integer>();
		estatus=new ArrayList<String>();
		vigenciaInicio=new ArrayList<Date>();
		vigenciaFin=new ArrayList<Date>();
		puesto=new ArrayList<String>();
		relacion=new ArrayList<String>();
		idPerfil = new ArrayList<Integer>();
		idEmpleadoev=new ArrayList<String>();
		idPregunta=new ArrayList<String>();;
		resultado=new ArrayList<Resultados>();
		porcentaje=new ArrayList<Double>();
		idEncuesta=new ArrayList<String>();
	}
	
	
	
	public List<Double> getPorcentaje() {
		return porcentaje;
	}
	


	
	public void setPorcentaje(double porcentaje) {
		this.porcentaje.add(porcentaje);
	}



	public String getIdEmpleado() {
		return idEmpleado;
	}



	public void setIdEncuesta(String idEncuesta) {
		this.idEncuesta.add(idEncuesta);
	}
	
	

	public List<String> getIdEncuesta() {
		return idEncuesta;
	}



	public void setIdEmpleado(String idEmpleado) {
		this.idEmpleado = idEmpleado;
	}



	public List<Resultados> getResultado() {
		return resultado;
	}


	public void setResultado(Resultados resultado) {
		this.resultado.add(resultado);
	}


	public List<String> getIdPregunta() {
		return idPregunta;
	}
	public void setIdPregunta(String idPregunta) {
		this.idPregunta.add(idPregunta);
	}
	
	public List<String> getIdEmpleadoev() {
		return idEmpleadoev;
	}
	public void setIdEmpleadoev(String idEmpleadoev) {
		this.idEmpleadoev.add(idEmpleadoev);
	}
	public List<Integer> getIdPerfil() {
		return idPerfil;
	}
	public void setIdPerfil(int idPerfil) {
		this.idPerfil.add(idPerfil);
	}
	public List<String> getPuesto() {
		return puesto;
	}
	public void setPuesto(String puesto) {
		this.puesto.add(puesto);
	}
	public List<String> getRelacion() {
		return relacion;
	}
	public void setRelacion(String relacion) {
		this.relacion.add(relacion);
	}
	public List<Date> getVigenciaInicio() {
		return vigenciaInicio;
	}
	public void setVigenciaInicio(Date vigenciaInicio) {
		this.vigenciaInicio.add(vigenciaInicio);
	}
	public List<Date> getVigenciaFin() {
		return vigenciaFin;
	}
	public void setVigenciaFin(Date vigenciaFin) {
		this.vigenciaFin.add(vigenciaFin);
	}
	public List<Integer> getNumP() {
		return numP;
	}
	public void setNumP(int numP) {
		this.numP.add(numP);
	}
	public List<String> getEstatus() {
		return estatus;
	}
	public void setEstatus(String estatus) {
		this.estatus.add(estatus);
	}
	public int getConsecutivoPregunta() {
		return consecutivoPregunta;
	}
	public void setConsecutivoPregunta(int consecutivoPregunta) {
		this.consecutivoPregunta = consecutivoPregunta;
	}
	public List<String> getPregunta() {
		return pregunta;
	}
	public void setPregunta(String pregunta) {
		this.pregunta.add(pregunta);
	}
	public int getIdTipoEncuesta() {
		return idTipoEncuesta;
	}
	public void setIdTipoEncuesta(int idTipoEncuesta) {
		this.idTipoEncuesta = idTipoEncuesta;
	}
	public List<String> getCompetencia() {
		return competencia;
	}
	public void setCompetencia(String competencia) {
		this.competencia.add(competencia);
	}
	public List<String> getNombreCompleto() {
		return nombreCompleto;
	}
	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto.add(nombreCompleto);
	}



	@Override
	public String toString() {
		return "Evaluacion [consecutivoPregunta=" + consecutivoPregunta + ", pregunta=" + pregunta + ", idTipoEncuesta="
				+ idTipoEncuesta + ", competencia=" + competencia + ", numP=" + numP + ", nombreCompleto="
				+ nombreCompleto + ", estatus=" + estatus + ", vigenciaInicio=" + vigenciaInicio + ", vigenciaFin="
				+ vigenciaFin + ", puesto=" + puesto + ", relacion=" + relacion + ", idPerfil=" + idPerfil
				+ ", idEmpleadoev=" + idEmpleadoev + ", idPregunta=" + idPregunta + ", resultado=" + resultado
				+ ", idEmpleado=" + idEmpleado + ", porcentaje=" + porcentaje + "]";
	}
}
