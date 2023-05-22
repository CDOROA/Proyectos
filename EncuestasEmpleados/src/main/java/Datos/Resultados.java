package Datos;

import java.util.ArrayList;
import java.util.List;

public class Resultados {
	private List<String> idPregunta;
	private List<String> respuesta;
	private List<String> comentarios;
	
	
	public Resultados() {
		super();
		this.idPregunta = new ArrayList<String>();
		this.respuesta =  new ArrayList<String>();
		this.comentarios =  new ArrayList<String>();
	}
	
	
	public List<String> getComentarios() {
		return comentarios;
	}


	public void setComentarios(String comentarios) {
		this.comentarios.add(comentarios);
	}


	public List<String> getIdPregunta() {
		return idPregunta;
	}
	public void setIdPregunta(String idPregunta) {
		this.idPregunta.add(idPregunta);
	}
	public List<String> getRespuesta() {
		return respuesta;
	}
	public void setRespuesta(String respuesta) {
		this.respuesta.add(respuesta);
	}


	@Override
	public String toString() {
		return "Resultados [idPregunta=" + idPregunta + ", respuesta=" + respuesta + ", comentarios=" + comentarios
				+ "]";
	}

	
}
