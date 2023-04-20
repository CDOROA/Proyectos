package cdo.Datos;

import java.io.Serializable;
import java.util.List;

public class ArticulosCarritoPedidoCompleto implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private ArticulosCarritoEncabezado encabezadoPedido;
	private List<ArticulosCarritoDetalle> detallePedido;
	private List<Consignatarios> listConsignatarios;
	private List<Transportes> listTransportes;
	private List<Distancia> listaDistancias;
	private InfoCliente infoCte;
	


	public ArticulosCarritoPedidoCompleto() {
		super();
	}

	public ArticulosCarritoPedidoCompleto(ArticulosCarritoEncabezado encabezadoPedido,
			List<ArticulosCarritoDetalle> detallePedido, List<Consignatarios> listConsignatarios,
			List<Transportes> listTransportes, List<Distancia> listaDistancias,InfoCliente infoCte) {
		super();
		this.encabezadoPedido = encabezadoPedido;
		this.detallePedido = detallePedido;
		this.listConsignatarios = listConsignatarios;
		this.listTransportes = listTransportes;
		this.listaDistancias = listaDistancias;
		this.infoCte = infoCte;
	}

	public ArticulosCarritoEncabezado getEncabezadoPedido() {
		return encabezadoPedido;
	}

	public void setEncabezadoPedido(ArticulosCarritoEncabezado encabezadoPedido) {
		this.encabezadoPedido = encabezadoPedido;
	}

	public List<ArticulosCarritoDetalle> getDetallePedido() {
		return detallePedido;
	}

	public void setDetallePedido(List<ArticulosCarritoDetalle> detallePedido) {
		this.detallePedido = detallePedido;
	}

	public List<Consignatarios> getListConsignatarios() {
		return listConsignatarios;
	}

	public void setListConsignatarios(List<Consignatarios> listConsignatarios) {
		this.listConsignatarios = listConsignatarios;
	}

	public List<Transportes> getListTransportes() {
		return listTransportes;
	}

	public void setListTransportes(List<Transportes> listTransportes) {
		this.listTransportes = listTransportes;
	}

 	public List<Distancia> getListaDistancias() {
		return listaDistancias;
	}

	public void setListaDistancias(List<Distancia> listaDistancias) {
		this.listaDistancias = listaDistancias;
	}
	
	public InfoCliente getInfoCte() {
		return infoCte;
	}

	public void setInfoCte(InfoCliente infoCte) {
		this.infoCte = infoCte;
	}
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "ArticulosCarritoPedidoCompleto [encabezadoPedido=" + encabezadoPedido + ", detallePedido="
				+ detallePedido + ", listConsignatarios=" + listConsignatarios + ", listTransportes=" + listTransportes
				+ ", listaDistancias=" + listaDistancias + ", infoCte=" + infoCte + "]";
	}

	
}
