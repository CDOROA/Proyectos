package cdo.Datos;

import java.io.Serializable;
import java.util.List;

public class InformacionInicial  implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private List<NuestraEmpresa> listaNuestraEmpresa;
	private List<ValoresEmpresa> listaValores;
	private List<VentajasCompetitivas>listaVentajas;
	private List<Banners> listaBanners;
	private List<Boletines> listaBoletines;
	private List<Marcas> listaMarcas;
	private List<Grupos> listaSistemaAutomotriz;
	private List<Estados> listaEstados;
	private List<MarcasCdo> listaMarcasCdo;
	private List<NuestraEmpresa> listaPoliticasPrivacidad;
	private List<NivelAcademico> listaNivelAcademico;
	private List<CintillosImagenes> listaCintillosImagenes;
	private List<Videos> listaVideos;
	
	public InformacionInicial() {
		super();
	}

	public InformacionInicial(List<NuestraEmpresa> listaNuestraEmpresa, List<ValoresEmpresa> listaValores,
			List<VentajasCompetitivas> listaVentajas, List<Banners> listaBanners, List<Boletines> listaBoletines,
			List<Marcas> listaMarcas, List<Grupos> listaSistemaAutomotriz, List<Estados> listaEstados,
			List<MarcasCdo> listaMarcasCdo, List<NuestraEmpresa> listaPoliticasPrivacidad,
			List<NivelAcademico> listaNivelAcademico, List<CintillosImagenes> listaCintillosImagenes, List<Videos> listaVideos) {
		super();
		this.listaNuestraEmpresa = listaNuestraEmpresa;
		this.listaValores = listaValores;
		this.listaVentajas = listaVentajas;
		this.listaBanners = listaBanners;
		this.listaBoletines = listaBoletines;
		this.listaMarcas = listaMarcas;
		this.listaSistemaAutomotriz = listaSistemaAutomotriz;
		this.listaEstados = listaEstados;
		this.listaMarcasCdo = listaMarcasCdo;
		this.listaPoliticasPrivacidad = listaPoliticasPrivacidad;
		this.listaNivelAcademico = listaNivelAcademico;
		this.listaCintillosImagenes = listaCintillosImagenes;
		this.listaVideos = listaVideos;
	}

	public List<NuestraEmpresa> getListaNuestraEmpresa() {
		return listaNuestraEmpresa;
	}

	public void setListaNuestraEmpresa(List<NuestraEmpresa> listaNuestraEmpresa) {
		this.listaNuestraEmpresa = listaNuestraEmpresa;
	}

	public List<ValoresEmpresa> getListaValores() {
		return listaValores;
	}

	public void setListaValores(List<ValoresEmpresa> listaValores) {
		this.listaValores = listaValores;
	}

	public List<VentajasCompetitivas> getListaVentajas() {
		return listaVentajas;
	}

	public void setListaVentajas(List<VentajasCompetitivas> listaVentajas) {
		this.listaVentajas = listaVentajas;
	}

	public List<Banners> getListaBanners() {
		return listaBanners;
	}

	public void setListaBanners(List<Banners> listaBanners) {
		this.listaBanners = listaBanners;
	}

	public List<Boletines> getListaBoletines() {
		return listaBoletines;
	}

	public void setListaBoletines(List<Boletines> listaBoletines) {
		this.listaBoletines = listaBoletines;
	}

	public List<Marcas> getListaMarcas() {
		return listaMarcas;
	}

	public void setListaMarcas(List<Marcas> listaMarcas) {
		this.listaMarcas = listaMarcas;
	}

	public List<Grupos> getListaSistemaAutomotriz() {
		return listaSistemaAutomotriz;
	}

	public void setListaSistemaAutomotriz(List<Grupos> listaSistemaAutomotriz) {
		this.listaSistemaAutomotriz = listaSistemaAutomotriz;
	}

	public List<Estados> getListaEstados() {
		return listaEstados;
	}

	public void setListaEstados(List<Estados> listaEstados) {
		this.listaEstados = listaEstados;
	}

	public List<MarcasCdo> getListaMarcasCdo() {
		return listaMarcasCdo;
	}

	public void setListaMarcasCdo(List<MarcasCdo> listaMarcasCdo) {
		this.listaMarcasCdo = listaMarcasCdo;
	}

	public List<NuestraEmpresa> getListaPoliticasPrivacidad() {
		return listaPoliticasPrivacidad;
	}

	public void setListaPoliticasPrivacidad(List<NuestraEmpresa> listaPoliticasPrivacidad) {
		this.listaPoliticasPrivacidad = listaPoliticasPrivacidad;
	}

	public List<NivelAcademico> getListaNivelAcademico() {
		return listaNivelAcademico;
	}

	public void setListaNivelAcademico(List<NivelAcademico> listaNivelAcademico) {
		this.listaNivelAcademico = listaNivelAcademico;
	}

	public List<CintillosImagenes> getListaCintillosImagenes() {
		return listaCintillosImagenes;
	}

	public void setListaCintillosImagenes(List<CintillosImagenes> listaCintillosImagenes) {
		this.listaCintillosImagenes = listaCintillosImagenes;
	}

	public List<Videos> getListaVideos() {
		return listaVideos;
	}

	public void setListaVideos(List<Videos> listaVideos) {
		this.listaVideos = listaVideos;
	}

	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "InformacionInicial [listaNuestraEmpresa=" + listaNuestraEmpresa + ", listaValores=" + listaValores
				+ ", listaVentajas=" + listaVentajas + ", listaBanners=" + listaBanners + ", listaBoletines="
				+ listaBoletines + ", listaMarcas=" + listaMarcas + ", listaSistemaAutomotriz=" + listaSistemaAutomotriz
				+ ", listaEstados=" + listaEstados + ", listaMarcasCdo=" + listaMarcasCdo
				+ ", listaPoliticasPrivacidad=" + listaPoliticasPrivacidad + ", listaNivelAcademico="
				+ listaNivelAcademico + ", listaCintillosImagenes=" + listaCintillosImagenes + ", listaVideos="
				+ listaVideos + "]";
	}

	 
}
