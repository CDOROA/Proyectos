package cdo.Datos;

import java.io.Serializable;
import java.util.List;

public class ListaInformacionDeIngresos implements Serializable {	

	private static final long serialVersionUID = 1L;
	private List<Ingresos> listaIngresos;
	private List<SemaforoIngresos> listaSemaforoIngresos;
	private boolean polAntGeneradas;
	private String fechaUltimaPoliza;
	
	public ListaInformacionDeIngresos() {
		super();
	}

	public ListaInformacionDeIngresos(List<Ingresos> listaIngresos, List<SemaforoIngresos> listaSemaforoIngresos,
			boolean polAntGeneradas, String fechaUltimaPoliza) {
		super();
		this.listaIngresos = listaIngresos;
		this.listaSemaforoIngresos = listaSemaforoIngresos;
		this.polAntGeneradas = polAntGeneradas;
		this.fechaUltimaPoliza = fechaUltimaPoliza;
	}

	public List<Ingresos> getListaIngresos() {
		return listaIngresos;
	}

	public void setListaIngresos(List<Ingresos> listaIngresos) {
		this.listaIngresos = listaIngresos;
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

	public String getFechaUltimaPoliza() {
		return fechaUltimaPoliza;
	}

	public void setFechaUltimaPoliza(String fechaUltimaPoliza) {
		this.fechaUltimaPoliza = fechaUltimaPoliza;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "ListaInformacionDeIngresos [listaIngresos=" + listaIngresos + ", listaSemaforoIngresos="
				+ listaSemaforoIngresos + ", polAntGeneradas=" + polAntGeneradas + ", fechaUltimaPoliza="
				+ fechaUltimaPoliza + "]";
	}
}
