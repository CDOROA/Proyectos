package cdo.Datos;

import java.io.Serializable;

public class CatalogoEstatusChequesNominativos implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private int id_estatus;
	private String nombre_estatus;
	
	public CatalogoEstatusChequesNominativos() {
		super();
	}

	public CatalogoEstatusChequesNominativos(int id_estatus, String nombre_estatus) {
		super();
		this.id_estatus = id_estatus;
		this.nombre_estatus = nombre_estatus;
	}

	public int getId_estatus() {
		return id_estatus;
	}

	public void setId_estatus(int id_estatus) {
		this.id_estatus = id_estatus;
	}

	public String getNombre_estatus() {
		return nombre_estatus;
	}

	public void setNombre_estatus(String nombre_estatus) {
		this.nombre_estatus = nombre_estatus;
	}

	@Override
	public String toString() {
		return "CatalogoEstatusChequesNominativos [id_estatus=" + id_estatus + ", nombre_estatus=" + nombre_estatus
				+ "]";
	}
}
