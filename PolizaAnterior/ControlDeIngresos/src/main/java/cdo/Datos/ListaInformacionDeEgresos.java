package cdo.Datos;

import java.io.Serializable;
import java.util.List;

public class ListaInformacionDeEgresos implements Serializable {	

	private static final long serialVersionUID = 1L;
	private List<Egresos> listaEgresos;
	private List<SemaforoIngresos> listaSemaforoIngresos;
	private boolean polAntGeneradas;
	
	public ListaInformacionDeEgresos() {
		super();
	}

	public ListaInformacionDeEgresos(List<Egresos> listaEgresos, List<SemaforoIngresos> listaSemaforoIngresos,
			boolean polAntGeneradas) {
		super();
		this.listaEgresos = listaEgresos;
		this.listaSemaforoIngresos = listaSemaforoIngresos;
		this.polAntGeneradas = polAntGeneradas;
	}

	public List<Egresos> getListaEgresos() {
		return listaEgresos;
	}

	public void setListaEgresos(List<Egresos> listaEgresos) {
		this.listaEgresos = listaEgresos;
	}

	public List<SemaforoIngresos> getListaSemaforoIngresos() {
		return listaSemaforoIngresos;
	}

	public void setListaSemaforoIngresos(List<SemaforoIngresos> listaSemaforoIngresos) {
		this.listaSemaforoIngresos = listaSemaforoIngresos;
	}

	public boolean isPolAntGeneradas() {
		return polAntGeneradas;
	}

	public void setPolAntGeneradas(boolean polAntGeneradas) {
		this.polAntGeneradas = polAntGeneradas;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "ListaInformacionDeEgresos [listaEgresos=" + listaEgresos + ", listaSemaforoIngresos="
				+ listaSemaforoIngresos + ", polAntGeneradas=" + polAntGeneradas + "]";
	}
	
}
