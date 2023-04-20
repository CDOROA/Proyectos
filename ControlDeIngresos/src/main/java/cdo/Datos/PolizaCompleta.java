package cdo.Datos;

import java.io.Serializable;
import java.util.List;

public class PolizaCompleta  implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private String folio_poliza;
	private String fecha_poliza;
	private String total_polizaIngresos;
	private String total_polizaEgresos;
	private List<PolizaDiaTipoIngreso> listaPolDiaTipoIngreso;
	private List<PolizaDiaBancosIngresos> listaPolDiaBancoIngresos;
	private List<PolizaDiaTipoEgreso> listaPolDiaTipoEgreso;
	private List<PolizaDiaOtrosIngresos> listaPolDiaOtrosIngresos;
	private List<CortePanamericano> listaRecoleccionValores;
	private List<FichasBancarias> listafichasBancarias;
	private List<FichasBancariasEgresos> listafichasBancariasEgresos;	
	private String transito_pendiente;
	private String transito_aplicado;	
	private String ajusteMasCheque;
	private String ajusteMenosCheque;
	private String existePolizaAnterior;
	
	private List<PolizaContable> polizaContable;
	
	
	public PolizaCompleta() {
		super();
	}


	public PolizaCompleta(String folio_poliza, String fecha_poliza, String total_polizaIngresos,
			String total_polizaEgresos, List<PolizaDiaTipoIngreso> listaPolDiaTipoIngreso,
			List<PolizaDiaBancosIngresos> listaPolDiaBancoIngresos, List<PolizaDiaTipoEgreso> listaPolDiaTipoEgreso,
			List<PolizaDiaOtrosIngresos> listaPolDiaOtrosIngresos, List<CortePanamericano> listaRecoleccionValores,
			List<FichasBancarias> listafichasBancarias, List<FichasBancariasEgresos> listafichasBancariasEgresos,
			String transito_pendiente, String transito_aplicado, String ajusteMasCheque, String ajusteMenosCheque,
			String existePolizaAnterior, List<PolizaContable> polizaContable) {
		super();
		this.folio_poliza = folio_poliza;
		this.fecha_poliza = fecha_poliza;
		this.total_polizaIngresos = total_polizaIngresos;
		this.total_polizaEgresos = total_polizaEgresos;
		this.listaPolDiaTipoIngreso = listaPolDiaTipoIngreso;
		this.listaPolDiaBancoIngresos = listaPolDiaBancoIngresos;
		this.listaPolDiaTipoEgreso = listaPolDiaTipoEgreso;
		this.listaPolDiaOtrosIngresos = listaPolDiaOtrosIngresos;
		this.listaRecoleccionValores = listaRecoleccionValores;
		this.listafichasBancarias = listafichasBancarias;
		this.listafichasBancariasEgresos = listafichasBancariasEgresos;
		this.transito_pendiente = transito_pendiente;
		this.transito_aplicado = transito_aplicado;
		this.ajusteMasCheque = ajusteMasCheque;
		this.ajusteMenosCheque = ajusteMenosCheque;
		this.existePolizaAnterior = existePolizaAnterior;
		this.polizaContable = polizaContable;
	}


	public String getFolio_poliza() {
		return folio_poliza;
	}


	public void setFolio_poliza(String folio_poliza) {
		this.folio_poliza = folio_poliza;
	}


	public String getFecha_poliza() {
		return fecha_poliza;
	}


	public void setFecha_poliza(String fecha_poliza) {
		this.fecha_poliza = fecha_poliza;
	}


	public String getTotal_polizaIngresos() {
		return total_polizaIngresos;
	}


	public void setTotal_polizaIngresos(String total_polizaIngresos) {
		this.total_polizaIngresos = total_polizaIngresos;
	}


	public String getTotal_polizaEgresos() {
		return total_polizaEgresos;
	}


	public void setTotal_polizaEgresos(String total_polizaEgresos) {
		this.total_polizaEgresos = total_polizaEgresos;
	}


	public List<PolizaDiaTipoIngreso> getListaPolDiaTipoIngreso() {
		return listaPolDiaTipoIngreso;
	}


	public void setListaPolDiaTipoIngreso(List<PolizaDiaTipoIngreso> listaPolDiaTipoIngreso) {
		this.listaPolDiaTipoIngreso = listaPolDiaTipoIngreso;
	}


	public List<PolizaDiaBancosIngresos> getListaPolDiaBancoIngresos() {
		return listaPolDiaBancoIngresos;
	}


	public void setListaPolDiaBancoIngresos(List<PolizaDiaBancosIngresos> listaPolDiaBancoIngresos) {
		this.listaPolDiaBancoIngresos = listaPolDiaBancoIngresos;
	}


	public List<PolizaDiaTipoEgreso> getListaPolDiaTipoEgreso() {
		return listaPolDiaTipoEgreso;
	}


	public void setListaPolDiaTipoEgreso(List<PolizaDiaTipoEgreso> listaPolDiaTipoEgreso) {
		this.listaPolDiaTipoEgreso = listaPolDiaTipoEgreso;
	}


	public List<PolizaDiaOtrosIngresos> getListaPolDiaOtrosIngresos() {
		return listaPolDiaOtrosIngresos;
	}


	public void setListaPolDiaOtrosIngresos(List<PolizaDiaOtrosIngresos> listaPolDiaOtrosIngresos) {
		this.listaPolDiaOtrosIngresos = listaPolDiaOtrosIngresos;
	}


	public List<CortePanamericano> getListaRecoleccionValores() {
		return listaRecoleccionValores;
	}


	public void setListaRecoleccionValores(List<CortePanamericano> listaRecoleccionValores) {
		this.listaRecoleccionValores = listaRecoleccionValores;
	}


	public List<FichasBancarias> getListafichasBancarias() {
		return listafichasBancarias;
	}


	public void setListafichasBancarias(List<FichasBancarias> listafichasBancarias) {
		this.listafichasBancarias = listafichasBancarias;
	}


	public List<FichasBancariasEgresos> getListafichasBancariasEgresos() {
		return listafichasBancariasEgresos;
	}


	public void setListafichasBancariasEgresos(List<FichasBancariasEgresos> listafichasBancariasEgresos) {
		this.listafichasBancariasEgresos = listafichasBancariasEgresos;
	}


	public String getTransito_pendiente() {
		return transito_pendiente;
	}


	public void setTransito_pendiente(String transito_pendiente) {
		this.transito_pendiente = transito_pendiente;
	}


	public String getTransito_aplicado() {
		return transito_aplicado;
	}


	public void setTransito_aplicado(String transito_aplicado) {
		this.transito_aplicado = transito_aplicado;
	}


	public String getAjusteMasCheque() {
		return ajusteMasCheque;
	}


	public void setAjusteMasCheque(String ajusteMasCheque) {
		this.ajusteMasCheque = ajusteMasCheque;
	}


	public String getAjusteMenosCheque() {
		return ajusteMenosCheque;
	}


	public void setAjusteMenosCheque(String ajusteMenosCheque) {
		this.ajusteMenosCheque = ajusteMenosCheque;
	}


	public String getExistePolizaAnterior() {
		return existePolizaAnterior;
	}


	public void setExistePolizaAnterior(String existePolizaAnterior) {
		this.existePolizaAnterior = existePolizaAnterior;
	}


	public List<PolizaContable> getPolizaContable() {
		return polizaContable;
	}


	public void setPolizaContable(List<PolizaContable> polizaContable) {
		this.polizaContable = polizaContable;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	@Override
	public String toString() {
		return "PolizaCompleta [folio_poliza=" + folio_poliza + ", fecha_poliza=" + fecha_poliza
				+ ", total_polizaIngresos=" + total_polizaIngresos + ", total_polizaEgresos=" + total_polizaEgresos
				+ ", listaPolDiaTipoIngreso=" + listaPolDiaTipoIngreso + ", listaPolDiaBancoIngresos="
				+ listaPolDiaBancoIngresos + ", listaPolDiaTipoEgreso=" + listaPolDiaTipoEgreso
				+ ", listaPolDiaOtrosIngresos=" + listaPolDiaOtrosIngresos + ", listaRecoleccionValores="
				+ listaRecoleccionValores + ", listafichasBancarias=" + listafichasBancarias
				+ ", listafichasBancariasEgresos=" + listafichasBancariasEgresos + ", transito_pendiente="
				+ transito_pendiente + ", transito_aplicado=" + transito_aplicado + ", ajusteMasCheque="
				+ ajusteMasCheque + ", ajusteMenosCheque=" + ajusteMenosCheque + ", existePolizaAnterior="
				+ existePolizaAnterior + ", polizaContable=" + polizaContable + "]";
	}
}
