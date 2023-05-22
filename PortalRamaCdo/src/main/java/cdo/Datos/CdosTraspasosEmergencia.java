package cdo.Datos;

import java.io.Serializable;

public class CdosTraspasosEmergencia implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private String empresa;
	private String uname;
	private String nombre_cdo;
	
	public CdosTraspasosEmergencia() {
		super();
	}

	public CdosTraspasosEmergencia(String empresa, String uname, String nombre_cdo) {
		super();
		this.empresa = empresa;
		this.uname = uname;
		this.nombre_cdo = nombre_cdo;
	}

	public String getEmpresa() {
		return empresa;
	}

	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getNombre_cdo() {
		return nombre_cdo;
	}

	public void setNombre_cdo(String nombre_cdo) {
		this.nombre_cdo = nombre_cdo;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "CdosTraspasosEmergencia [empresa=" + empresa + ", uname=" + uname + ", nombre_cdo=" + nombre_cdo + "]";
	}
}
