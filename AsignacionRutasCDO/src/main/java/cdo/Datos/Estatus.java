package cdo.Datos;

public class Estatus 
{
	String valor;
	String descripcion;
	public Estatus() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Estatus(String valor, String descripcion) {
		super();
		this.valor = valor;
		this.descripcion = descripcion;
	}
	public String getValor() {
		return valor;
	}
	public void setValor(String valor) {
		this.valor = valor;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	@Override
	public String toString() {
		return "Estatus [valor=" + valor + ", descripcion=" + descripcion + "]";
	}
	
}
