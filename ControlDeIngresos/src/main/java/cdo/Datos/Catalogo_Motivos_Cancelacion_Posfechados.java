package cdo.Datos;

import java.io.Serializable;

public class Catalogo_Motivos_Cancelacion_Posfechados  implements Serializable
{
	private static final long serialVersionUID = 1L;
	private int id_motivo;
	private String descripcion;
	private String  tipo;
	
	public Catalogo_Motivos_Cancelacion_Posfechados() {
		super();
	}
	public Catalogo_Motivos_Cancelacion_Posfechados(int id_motivo, String descripcion, String tipo) {
		super();
		this.id_motivo = id_motivo;
		this.descripcion = descripcion;
		this.tipo = tipo;
	}
	public int getId_motivo() {
		return id_motivo;
	}
	public void setId_motivo(int id_motivo) {
		this.id_motivo = id_motivo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	@Override
	public String toString() {
		return "Catalogo_Motivos_Cancelacion_Posfechados [id_motivo=" + id_motivo + ", descripcion=" + descripcion
				+ ", tipo=" + tipo + "]";
	}
	
}
