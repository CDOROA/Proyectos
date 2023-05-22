package cdo.Datos;

import java.io.Serializable;
import java.util.List;

public class ConsultaCortesCaja implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private List<PrevioIngresosTipoPago> listaPrevioXTP;
	private List<PrevioIngresosFormaPago> listaPrevioXFP;
	private List<PrevioEgresos> listaPrevioEgresos;
	private List<PrevioIngresosBancos> listaIngresosBancos; 
	private List<PrevioEgresosBanco> listaEgresosBancos; 
	private List<CorteDeCaja> listaCortesCaja;
	
	
	public ConsultaCortesCaja(List<PrevioIngresosTipoPago> listaPrevioXTP, List<PrevioIngresosFormaPago> listaPrevioXFP,
			List<PrevioEgresos> listaPrevioEgresos, List<PrevioIngresosBancos> listaIngresosBancos,
			List<PrevioEgresosBanco> listaEgresosBancos, List<CorteDeCaja> listaCortesCaja) {
		super();
		this.listaPrevioXTP = listaPrevioXTP;
		this.listaPrevioXFP = listaPrevioXFP;
		this.listaPrevioEgresos = listaPrevioEgresos;
		this.listaIngresosBancos = listaIngresosBancos;
		this.listaEgresosBancos = listaEgresosBancos;
		this.listaCortesCaja = listaCortesCaja;
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


	public List<CorteDeCaja> getListaCortesCaja() {
		return listaCortesCaja;
	}


	public void setListaCortesCaja(List<CorteDeCaja> listaCortesCaja) {
		this.listaCortesCaja = listaCortesCaja;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	@Override
	public String toString() {
		return "ConsultaCortesCaja [listaPrevioXTP=" + listaPrevioXTP + ", listaPrevioXFP=" + listaPrevioXFP
				+ ", listaPrevioEgresos=" + listaPrevioEgresos + ", listaIngresosBancos=" + listaIngresosBancos
				+ ", listaEgresosBancos=" + listaEgresosBancos + ", listaCortesCaja=" + listaCortesCaja + "]";
	}	
}
