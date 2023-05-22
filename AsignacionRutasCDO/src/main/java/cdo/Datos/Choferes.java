package cdo.Datos;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Choferes implements Serializable
{
	private String chofer;
	private String nombre;
	private String cve;
	private String uname;
	public Choferes() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Choferes(String chofer, String nombre, String cve, String uname) {
		super();
		this.chofer = chofer;
		this.nombre = nombre;
		this.cve = cve;
		this.uname = uname;
	}
	public String getChofer() {
		return chofer;
	}
	public void setChofer(String chofer) {
		this.chofer = chofer;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCve() {
		return cve;
	}
	public void setCve(String cve) {
		this.cve = cve;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	@Override
	public String toString() {
		return "Choferes [chofer=" + chofer + ", nombre=" + nombre + ", cve=" + cve + ", uname=" + uname + "]";
	} 
	
	
}
