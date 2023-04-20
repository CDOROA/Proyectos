package cdo.Datos;

import java.io.Serializable;
import java.util.List;

public class PrevioCorteCaja implements Serializable {

	private static final long serialVersionUID = 1L;
	private List<PrevioIngresosTipoPago> listaPrevioXTP;
	private List<PrevioIngresosFormaPago> listaPrevioXFP;
	private List<PrevioEgresos> listaPrevioEgresos;
	private List<PrevioDenominacionesBilletes> listaDenominacionesBilletes; 
	private List<PrevioDenominacionesMonedas> listaDenominacionesMonedas; 
	private List<PrevioIngresosBancos> listaIngresosBancos; 
	private List<PrevioEgresosBanco> listaEgresosBancos; 
	
	public PrevioCorteCaja() {
		super();
	}

	public PrevioCorteCaja(List<PrevioIngresosTipoPago> listaPrevioXTP, List<PrevioIngresosFormaPago> listaPrevioXFP,
			List<PrevioEgresos> listaPrevioEgresos, List<PrevioDenominacionesBilletes> listaDenominacionesBilletes,
			List<PrevioDenominacionesMonedas> listaDenominacionesMonedas,
			List<PrevioIngresosBancos> listaIngresosBancos, List<PrevioEgresosBanco> listaEgresosBancos) {
		super();
		this.listaPrevioXTP = listaPrevioXTP;
		this.listaPrevioXFP = listaPrevioXFP;
		this.listaPrevioEgresos = listaPrevioEgresos;
		this.listaDenominacionesBilletes = listaDenominacionesBilletes;
		this.listaDenominacionesMonedas = listaDenominacionesMonedas;
		this.listaIngresosBancos = listaIngresosBancos;
		this.listaEgresosBancos = listaEgresosBancos;
	}

	public List<PrevioIngresosTipoPago> getListaPrevioXTP() {
		return listaPrevioXTP;
	}

	public void setListaPrevioXTP(List<PrevioIngresosTipoPago> listaPrevioXTP) {
		this.listaPrevioXTP = listaPrevioXTP;
	}

	public List<PrevioIngresosFormaPago> getListaPrevioXFP() {
		return listaPrevioXFP;
	}

	public void setListaPrevioXFP(List<PrevioIngresosFormaPago> listaPrevioXFP) {
		this.listaPrevioXFP = listaPrevioXFP;
	}

	public List<PrevioEgresos> getListaPrevioEgresos() {
		return listaPrevioEgresos;
	}

	public void setListaPrevioEgresos(List<PrevioEgresos> listaPrevioEgresos) {
		this.listaPrevioEgresos = listaPrevioEgresos;
	}

	public List<PrevioDenominacionesBilletes> getListaDenominacionesBilletes() {
		return listaDenominacionesBilletes;
	}

	public void setListaDenominacionesBilletes(List<PrevioDenominacionesBilletes> listaDenominacionesBilletes) {
		this.listaDenominacionesBilletes = listaDenominacionesBilletes;
	}

	public List<PrevioDenominacionesMonedas> getListaDenominacionesMonedas() {
		return listaDenominacionesMonedas;
	}

	public void setListaDenominacionesMonedas(List<PrevioDenominacionesMonedas> listaDenominacionesMonedas) {
		this.listaDenominacionesMonedas = listaDenominacionesMonedas;
	}

	public List<PrevioIngresosBancos> getListaIngresosBancos() {
		return listaIngresosBancos;
	}

	public void setListaIngresosBancos(List<PrevioIngresosBancos> listaIngresosBancos) {
		this.listaIngresosBancos = listaIngresosBancos;
	}

	public List<PrevioEgresosBanco> getListaEgresosBancos() {
		return listaEgresosBancos;
	}

	public void setListaEgresosBancos(List<PrevioEgresosBanco> listaEgresosBancos) {
		this.listaEgresosBancos = listaEgresosBancos;
	}

	@Override
	public String toString() {
		return "PrevioCorteCaja [listaPrevioXTP=" + listaPrevioXTP + ", listaPrevioXFP=" + listaPrevioXFP
				+ ", listaPrevioEgresos=" + listaPrevioEgresos + ", listaDenominacionesBilletes="
				+ listaDenominacionesBilletes + ", listaDenominacionesMonedas=" + listaDenominacionesMonedas
				+ ", listaIngresosBancos=" + listaIngresosBancos + ", listaEgresosBancos=" + listaEgresosBancos + "]";
	}

}
