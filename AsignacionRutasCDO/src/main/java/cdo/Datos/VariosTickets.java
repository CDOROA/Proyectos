package cdo.Datos;

import java.io.Serializable;

@SuppressWarnings("serial")
public class VariosTickets implements Serializable

{
	private String uname;
	private String descripcion;
	private String titulo;
	private String uname_br;
	public VariosTickets() {
		super();
		// TODO Auto-generated constructor stub
	}
	public VariosTickets(String uname, String descripcion, String titulo, String uname_br) {
		super();
		this.uname = uname;
		this.descripcion = descripcion;
		this.titulo = titulo;
		this.uname_br = uname_br;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getUname_br() {
		return uname_br;
	}
	public void setUname_br(String uname_br) {
		this.uname_br = uname_br;
	}
	@Override
	public String toString() {
		return "VariosTickets [uname=" + uname + ", descripcion=" + descripcion + ", titulo=" + titulo + ", uname_br="
				+ uname_br + "]";
	}
	
	
	}
