package cdo.Datos;

import java.io.Serializable;
import java.util.List;

public class Catalogos_Listas  implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private List<Catalogo_Otros_Ingresos> listaOtrosIngresos ;
	private List<Catalogo_Formas_Pago> listaFormas_Pago;
	private List<Catalogo_Bancos> listaBancos;
	private List<Catalogo_Motivos_Cancelacion> listaMotivosCancelacion;
	private List<Catalogo_Usuarios_Credito>listaUsuariosCredito;
	private List<Cdos> listaCdos; 
    private List<Catalogo_Estatus> listaEstatus;
	private List<Impresoras> listaImpresoras;
	private List<Catalogo_EstatusLineaBancaria> listaEstatusLinea;
	private List<Catalogo_TiposLineaBancaria> listaTiposLinea;
	private List<Catalogo_Agentes> listaAgentes;
	private List<CatalogoEstatusChequesNominativos> listaEstatusNominativo;
	 
	public Catalogos_Listas() {
		super();
	}

	public Catalogos_Listas(List<Catalogo_Otros_Ingresos> listaOtrosIngresos,
			List<Catalogo_Formas_Pago> listaFormas_Pago, List<Catalogo_Bancos> listaBancos,
			List<Catalogo_Motivos_Cancelacion> listaMotivosCancelacion,
			List<Catalogo_Usuarios_Credito> listaUsuariosCredito, List<Cdos> listaCdos,
			List<Catalogo_Estatus> listaEstatus, List<Impresoras> listaImpresoras,
			List<Catalogo_EstatusLineaBancaria> listaEstatusLinea, List<Catalogo_TiposLineaBancaria> listaTiposLinea,
			List<Catalogo_Agentes> listaAgentes, List<CatalogoEstatusChequesNominativos> listaEstatusNominativo) {
		super();
		this.listaOtrosIngresos = listaOtrosIngresos;
		this.listaFormas_Pago = listaFormas_Pago;
		this.listaBancos = listaBancos;
		this.listaMotivosCancelacion = listaMotivosCancelacion;
		this.listaUsuariosCredito = listaUsuariosCredito;
		this.listaCdos = listaCdos;
		this.listaEstatus = listaEstatus;
		this.listaImpresoras = listaImpresoras;
		this.listaEstatusLinea = listaEstatusLinea;
		this.listaTiposLinea = listaTiposLinea;
		this.listaAgentes = listaAgentes;
		this.listaEstatusNominativo = listaEstatusNominativo;
	}

	public List<Catalogo_Otros_Ingresos> getListaOtrosIngresos() {
		return listaOtrosIngresos;
	}

	public void setListaOtrosIngresos(List<Catalogo_Otros_Ingresos> listaOtrosIngresos) {
		this.listaOtrosIngresos = listaOtrosIngresos;
	}

	public List<Catalogo_Formas_Pago> getListaFormas_Pago() {
		return listaFormas_Pago;
	}

	public void setListaFormas_Pago(List<Catalogo_Formas_Pago> listaFormas_Pago) {
		this.listaFormas_Pago = listaFormas_Pago;
	}

	public List<Catalogo_Bancos> getListaBancos() {
		return listaBancos;
	}

	public void setListaBancos(List<Catalogo_Bancos> listaBancos) {
		this.listaBancos = listaBancos;
	}

	public List<Catalogo_Motivos_Cancelacion> getListaMotivosCancelacion() {
		return listaMotivosCancelacion;
	}

	public void setListaMotivosCancelacion(List<Catalogo_Motivos_Cancelacion> listaMotivosCancelacion) {
		this.listaMotivosCancelacion = listaMotivosCancelacion;
	}

	public List<Catalogo_Usuarios_Credito> getListaUsuariosCredito() {
		return listaUsuariosCredito;
	}

	public void setListaUsuariosCredito(List<Catalogo_Usuarios_Credito> listaUsuariosCredito) {
		this.listaUsuariosCredito = listaUsuariosCredito;
	}

	public List<Cdos> getListaCdos() {
		return listaCdos;
	}

	public void setListaCdos(List<Cdos> listaCdos) {
		this.listaCdos = listaCdos;
	}

	public List<Catalogo_Estatus> getListaEstatus() {
		return listaEstatus;
	}

	public void setListaEstatus(List<Catalogo_Estatus> listaEstatus) {
		this.listaEstatus = listaEstatus;
	}

	public List<Impresoras> getListaImpresoras() {
		return listaImpresoras;
	}

	public void setListaImpresoras(List<Impresoras> listaImpresoras) {
		this.listaImpresoras = listaImpresoras;
	}

	public List<Catalogo_EstatusLineaBancaria> getListaEstatusLinea() {
		return listaEstatusLinea;
	}

	public void setListaEstatusLinea(List<Catalogo_EstatusLineaBancaria> listaEstatusLinea) {
		this.listaEstatusLinea = listaEstatusLinea;
	}

	public List<Catalogo_TiposLineaBancaria> getListaTiposLinea() {
		return listaTiposLinea;
	}

	public void setListaTiposLinea(List<Catalogo_TiposLineaBancaria> listaTiposLinea) {
		this.listaTiposLinea = listaTiposLinea;
	}

	public List<Catalogo_Agentes> getListaAgentes() {
		return listaAgentes;
	}

	public void setListaAgentes(List<Catalogo_Agentes> listaAgentes) {
		this.listaAgentes = listaAgentes;
	}

	public List<CatalogoEstatusChequesNominativos> getListaEstatusNominativo() {
		return listaEstatusNominativo;
	}

	public void setListaEstatusNominativo(List<CatalogoEstatusChequesNominativos> listaEstatusNominativo) {
		this.listaEstatusNominativo = listaEstatusNominativo;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Catalogos_Listas [listaOtrosIngresos=" + listaOtrosIngresos + ", listaFormas_Pago=" + listaFormas_Pago
				+ ", listaBancos=" + listaBancos + ", listaMotivosCancelacion=" + listaMotivosCancelacion
				+ ", listaUsuariosCredito=" + listaUsuariosCredito + ", listaCdos=" + listaCdos + ", listaEstatus="
				+ listaEstatus + ", listaImpresoras=" + listaImpresoras + ", listaEstatusLinea=" + listaEstatusLinea
				+ ", listaTiposLinea=" + listaTiposLinea + ", listaAgentes=" + listaAgentes
				+ ", listaEstatusNominativo=" + listaEstatusNominativo + "]";
	}

}
