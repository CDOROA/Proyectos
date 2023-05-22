package cdo.Datos;

import java.io.Serializable;

public class Impresoras implements Serializable {	

	private static final long serialVersionUID = 1L;
	
	private String uname;
	private String impresora;
	
	public Impresoras() {
		super();
	}

	public Impresoras(String uname, String impresora) {
		super();
		this.uname = uname;
		this.impresora = impresora;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getImpresora() {
		return impresora;
	}

	public void setImpresora(String impresora) {
		this.impresora = impresora;
	}

	@Override
	public String toString() {
		return "Impresoras [uname=" + uname + ", impresora=" + impresora + "]";
	}
}

