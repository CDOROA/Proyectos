package cdo.Datos;

import java.io.Serializable;

public class ExistenciasPorArticulo implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private String num_art;
	private String uname;
	private String tipo;
	private int existencia;
	
	public ExistenciasPorArticulo() {
		super();
	}

	public ExistenciasPorArticulo(String num_art, String uname, String tipo, int existencia) {
		super();
		this.num_art = num_art;
		this.uname = uname;
		this.tipo = tipo;
		this.existencia = existencia;
	}

	public String getNum_art() {
		return num_art;
	}

	public void setNum_art(String num_art) {
		this.num_art = num_art;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public int getExistencia() {
		return existencia;
	}

	public void setExistencia(int existencia) {
		this.existencia = existencia;
	}

	@Override
	public String toString() {
		return "ExistenciasPorArticulo [num_art=" + num_art + ", uname=" + uname + ", tipo=" + tipo + ", existencia="
				+ existencia + "]";
	}
	
	
}
