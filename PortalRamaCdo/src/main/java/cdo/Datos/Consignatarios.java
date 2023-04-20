package cdo.Datos;

import java.io.Serializable;

public class Consignatarios implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private String numeroConsignatario;
	private String descripcionConsignatario;
	
	public Consignatarios() {
		super();
		numeroConsignatario = "";
		descripcionConsignatario ="";
	}


	public Consignatarios(String numeroConsignatario, String descripcionConsignatario) {
		super();
		this.numeroConsignatario = numeroConsignatario;
		this.descripcionConsignatario = descripcionConsignatario;
	}

	public String getNumeroConsignatario() {
		return numeroConsignatario;
	}

	public void setNumeroConsignatario(String numeroConsignatario) {
		this.numeroConsignatario = numeroConsignatario;
	}

	public String getDescripcionConsignatario() {
		return descripcionConsignatario;
	}

	public void setDescripcionConsignatario(String descripcionConsignatario) {
		this.descripcionConsignatario = descripcionConsignatario;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Consignatarios [numeroConsignatario=" + numeroConsignatario + ", descripcionConsignatario="
				+ descripcionConsignatario + "]";
	}
}
