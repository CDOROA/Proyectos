package cdo.Entidades;

public class Existencias 
{
	private String uname;
	private String tipo;
	private String articulo;
	private int existencia;
	public Existencias() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Existencias(String uname, String tipo, String articulo, int existencia) {
		super();
		this.uname = uname;
		this.tipo = tipo;
		this.articulo = articulo;
		this.existencia = existencia;
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
	public String getArticulo() {
		return articulo;
	}
	public void setArticulo(String articulo) {
		this.articulo = articulo;
	}
	public int getExistencia() {
		return existencia;
	}
	public void setExistencia(int existencia) {
		this.existencia = existencia;
	}
	@Override
	public String toString() {
		return "Existencias [uname=" + uname + ", tipo=" + tipo + ", articulo=" + articulo + ", existencia="
				+ existencia + "]";
	}
	
	
}
