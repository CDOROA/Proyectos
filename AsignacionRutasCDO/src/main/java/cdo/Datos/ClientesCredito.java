package cdo.Datos;

import java.io.Serializable;

@SuppressWarnings("serial")
public class ClientesCredito implements Serializable 
{
	private String uname;
	private String uname_br;
	private String cliente;
	private String estatus;
	public ClientesCredito() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ClientesCredito(String uname, String uname_br, String cliente, String estatus) {
		super();
		this.uname = uname;
		this.uname_br = uname_br;
		this.cliente = cliente;
		this.estatus = estatus;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getUname_br() {
		return uname_br;
	}
	public void setUname_br(String uname_br) {
		this.uname_br = uname_br;
	}
	public String getCliente() {
		return cliente;
	}
	public void setCliente(String cliente) {
		this.cliente = cliente;
	}
	public String getEstatus() {
		return estatus;
	}
	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}
	@Override
	public String toString() {
		return "ClientesCredito [uname=" + uname + ", uname_br=" + uname_br + ", cliente=" + cliente + ", estatus="
				+ estatus + "]";
	}
	
	
}
