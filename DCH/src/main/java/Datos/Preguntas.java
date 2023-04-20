package Datos;

import java.util.ArrayList;
import java.util.List;

public class Preguntas {
	private String idEmpleado;
	private String preguntas;
	private String competencia;
	private double calif;
	private List<String> comentarios;
	
	
	
	public Preguntas() {
		comentarios=new ArrayList<>();
	}
	
	public List<String> getComentarios() {
		return comentarios;
	}
	public void setComentarios(String comentarios) {
		this.comentarios.add(comentarios);
	}

	public String getCompetencia() {
		return competencia;
	}
	public void setCompetencia(String competencia) {
		this.competencia = competencia;
	}
	public String getIdEmpleado() {
		return idEmpleado;
	}
	public void setIdEmpleado(String idEmpleado) {
		this.idEmpleado = idEmpleado;
	}
	public String getPreguntas() {
		return preguntas;
	}
	public void setPreguntas(String preguntas) {
		this.preguntas = preguntas;
	}
	public double getCalif() {
		return calif;
	}
	public void setCalif(double calif) {
		this.calif = calif;
	}
	
	@Override
	public String toString() {
		return "Preguntas [idEmpleado=" + idEmpleado + ", preguntas=" + preguntas + ", competencia=" + competencia
				+ ", calif=" + calif + ", comentarios=" + comentarios + "]";
	}
	
	
}
