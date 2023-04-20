package datos;

public class CriteriosBusqueda {
	String descripcion;
	String tipo;
	int cantidad;
	int totalResultado;
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public int getTotalResultado() {
		return totalResultado;
	}
	public void setTotalResultado(int totalResultado) {
		this.totalResultado = totalResultado;
	}
	
	public CriteriosBusqueda() {
		super();
		this.descripcion = "";
		this.tipo = "";
		this.cantidad = 0;
		this.totalResultado = 0;
	}
	
	
	@Override
	public String toString() {
		return "CriteriosBusqueda [descripcion=" + descripcion + ", tipo=" + tipo + ", cantidad=" + cantidad
				+ ", totalResultado=" + totalResultado + "]";
	}
}
