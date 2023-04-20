package cdo.Datos;

import java.io.Serializable;

public class MotivosChequesDevueltos implements Serializable 
{
	private static final long serialVersionUID = 1L;
	
	private String descripcion;
	private int id_motivo;
	 
	public MotivosChequesDevueltos() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MotivosChequesDevueltos(String descripcion, int id_motivo) {
		super();
		this.descripcion = descripcion;
		this.id_motivo = id_motivo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public int getId_motivo() {
		return id_motivo;
	}
	public void setId_motivo(int id_motivo) {
		this.id_motivo = id_motivo;
	}
	@Override
	public String toString() {
		return "MotivosChequesDevueltos [descripcion=" + descripcion + ", id_motivo=" + id_motivo + "]";
	}
 

}
