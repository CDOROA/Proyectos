package cdo.Datos;

import java.io.Serializable;
import java.util.List;

public class InformacionInicialCarrito implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private List<Marcas> listaMarcas;
	private List<Grupos> listaGrupos;
	private List<Armandoras> listaArmadoras;
	private List<Transportes> listaTransportes;
	private InfoCliente infocliente;
	private List<Consignatarios> listaConsignatrios;
	private List<MarcasDeCalidad> listaMarcasCalidad;
	private List<LineasDescuentoFijo> listaLineasDesFijo;
	private List<CdosTraspasosEmergencia>listaCdosTraspaso;
	private List<Cilindros> listaCilindros;
	private List<Litros> listaLitros;
	private List<Distancia> listaDistancias;
	private int articulosCarrito;
	private String numerpPedidoCarrito;

	public InformacionInicialCarrito() {
		super();
	}

	public InformacionInicialCarrito(List<Marcas> listaMarcas, List<Grupos> listaGrupos,
			List<Armandoras> listaArmadoras, List<Transportes> listaTransportes, InfoCliente infocliente,
			List<Consignatarios> listaConsignatrios, List<MarcasDeCalidad> listaMarcasCalidad,
			List<LineasDescuentoFijo> listaLineasDesFijo, List<CdosTraspasosEmergencia> listaCdosTraspaso,
			List<Cilindros> listaCilindros, List<Litros> listaLitros, List<Distancia> listaDistancias, int articulosCarrito,  String numerpPedidoCarrito) {
		super();
		this.listaMarcas = listaMarcas;
		this.listaGrupos = listaGrupos;
		this.listaArmadoras = listaArmadoras;
		this.listaTransportes = listaTransportes;
		this.infocliente = infocliente;
		this.listaConsignatrios = listaConsignatrios;
		this.listaMarcasCalidad = listaMarcasCalidad;
		this.listaLineasDesFijo = listaLineasDesFijo;
		this.listaCdosTraspaso = listaCdosTraspaso;
		this.listaCilindros = listaCilindros;
		this.listaLitros = listaLitros;
		this.listaDistancias = listaDistancias;
		this.articulosCarrito = articulosCarrito;
		this.numerpPedidoCarrito = numerpPedidoCarrito;
	}

	public List<Marcas> getListaMarcas() {
		return listaMarcas;
	}

	public void setListaMarcas(List<Marcas> listaMarcas) {
		this.listaMarcas = listaMarcas;
	}

	public List<Grupos> getListaGrupos() {
		return listaGrupos;
	}

	public void setListaGrupos(List<Grupos> listaGrupos) {
		this.listaGrupos = listaGrupos;
	}

	public List<Armandoras> getListaArmadoras() {
		return listaArmadoras;
	}

	public void setListaArmadoras(List<Armandoras> listaArmadoras) {
		this.listaArmadoras = listaArmadoras;
	}

	public List<Transportes> getListaTransportes() {
		return listaTransportes;
	}

	public void setListaTransportes(List<Transportes> listaTransportes) {
		this.listaTransportes = listaTransportes;
	}

	public InfoCliente getInfocliente() {
		return infocliente;
	}

	public void setInfocliente(InfoCliente infocliente) {
		this.infocliente = infocliente;
	}

	public List<Consignatarios> getListaConsignatrios() {
		return listaConsignatrios;
	}

	public void setListaConsignatrios(List<Consignatarios> listaConsignatrios) {
		this.listaConsignatrios = listaConsignatrios;
	}

	public List<MarcasDeCalidad> getListaMarcasCalidad() {
		return listaMarcasCalidad;
	}

	public void setListaMarcasCalidad(List<MarcasDeCalidad> listaMarcasCalidad) {
		this.listaMarcasCalidad = listaMarcasCalidad;
	}

	public List<LineasDescuentoFijo> getListaLineasDesFijo() {
		return listaLineasDesFijo;
	}

	public void setListaLineasDesFijo(List<LineasDescuentoFijo> listaLineasDesFijo) {
		this.listaLineasDesFijo = listaLineasDesFijo;
	}

	public List<CdosTraspasosEmergencia> getListaCdosTraspaso() {
		return listaCdosTraspaso;
	}

	public void setListaCdosTraspaso(List<CdosTraspasosEmergencia> listaCdosTraspaso) {
		this.listaCdosTraspaso = listaCdosTraspaso;
	}

	public List<Cilindros> getListaCilindros() {
		return listaCilindros;
	}

	public void setListaCilindros(List<Cilindros> listaCilindros) {
		this.listaCilindros = listaCilindros;
	}

	public List<Litros> getListaLitros() {
		return listaLitros;
	}

	public void setListaLitros(List<Litros> listaLitros) {
		this.listaLitros = listaLitros;
	}

	public int getArticulosCarrito() {
		return articulosCarrito;
	}

	public List<Distancia> getListaDistancias() {
		return listaDistancias;
	}

	public void setListaDistancias(List<Distancia> listaDistancias) {
		this.listaDistancias = listaDistancias;
	}
	
	public void setArticulosCarrito(int articulosCarrito) {
		this.articulosCarrito = articulosCarrito;
	}

	public String getNumerpPedidoCarrito() {
		return numerpPedidoCarrito;
	}

	public void setNumerpPedidoCarrito(String numerpPedidoCarrito) {
		this.numerpPedidoCarrito = numerpPedidoCarrito;
	}

	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "InformacionInicialCarrito [listaMarcas=" + listaMarcas + ", listaGrupos=" + listaGrupos
				+ ", listaArmadoras=" + listaArmadoras + ", listaTransportes=" + listaTransportes + ", infocliente="
				+ infocliente + ", listaConsignatrios=" + listaConsignatrios + ", listaMarcasCalidad="
				+ listaMarcasCalidad + ", listaLineasDesFijo=" + listaLineasDesFijo + ", listaCdosTraspaso="
				+ listaCdosTraspaso + ", listaCilindros=" + listaCilindros + ", listaLitros=" + listaLitros
				+ ", articulosCarrito=" + articulosCarrito + "]";
	}
}
