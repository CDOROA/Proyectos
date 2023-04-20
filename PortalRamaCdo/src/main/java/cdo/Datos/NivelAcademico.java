package cdo.Datos;

import java.io.Serializable;

public class NivelAcademico  implements Serializable
{
	
	private static final long serialVersionUID = 1L;
	private int id_nivelAcademico;
	private String nivelAcademico;
	
	public NivelAcademico() {
		super();
	}

	public NivelAcademico(int id_nivelAcademico, String nivelAcademico) {
		super();
		this.id_nivelAcademico = id_nivelAcademico;
		this.nivelAcademico = nivelAcademico;
	}

	public int getId_nivelAcademico() {
		return id_nivelAcademico;
	}

	public void setId_nivelAcademico(int id_nivelAcademico) {
		this.id_nivelAcademico = id_nivelAcademico;
	}

	public String getNivelAcademico() {
		return nivelAcademico;
	}

	public void setNivelAcademico(String nivelAcademico) {
		this.nivelAcademico = nivelAcademico;
	}

	@Override
	public String toString() {
		return "NivelAcademico [id_nivelAcademico=" + id_nivelAcademico + ", nivelAcademico=" + nivelAcademico + "]";
	}
}
