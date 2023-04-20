package datos;


import java.io.Serializable;

@SuppressWarnings("serial")
public class SugerenciaBusqueda implements Serializable 
{
	private String articulo;

	public SugerenciaBusqueda() {
		super();
	}

	public SugerenciaBusqueda(String articulo) {
		super();
		this.articulo = articulo;
	}

	public String getArticulo() {
		return articulo;
	}

	public void setArticulo(String articulo) {
		this.articulo = articulo;
	}

	@Override
	public String toString() {
		return "SugerenciaBusqueda [articulo=" + articulo + "]";
	}
	
	
}
