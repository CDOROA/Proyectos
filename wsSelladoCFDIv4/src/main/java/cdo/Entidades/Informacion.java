package cdo.Entidades;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Informacion implements Serializable 
{
	private String xml;
	private String cdo;
	private int ode;
	private int ods;
	private int pedido;
	private String documento_largo;
	private String documento_corto;
	private String serie;
	private int folio;
	private int tipo;
	private String descripcion;
	public Informacion() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Informacion(String xml, String cdo, int ode, int ods, int pedido, String documento_largo,
			String documento_corto, String serie, int folio, int tipo, String descripcion) {
		super();
		this.xml = xml;
		this.cdo = cdo;
		this.ode = ode;
		this.ods = ods;
		this.pedido = pedido;
		this.documento_largo = documento_largo;
		this.documento_corto = documento_corto;
		this.serie = serie;
		this.folio = folio;
		this.tipo = tipo;
		this.descripcion = descripcion;
	}
	public String getXml() {
		return xml;
	}
	public void setXml(String xml) {
		this.xml = xml;
	}
	public String getCdo() {
		return cdo;
	}
	public void setCdo(String cdo) {
		this.cdo = cdo;
	}
	public int getOde() {
		return ode;
	}
	public void setOde(int ode) {
		this.ode = ode;
	}
	public int getOds() {
		return ods;
	}
	public void setOds(int ods) {
		this.ods = ods;
	}
	public int getPedido() {
		return pedido;
	}
	public void setPedido(int pedido) {
		this.pedido = pedido;
	}
	public String getDocumento_largo() {
		return documento_largo;
	}
	public void setDocumento_largo(String documento_largo) {
		this.documento_largo = documento_largo;
	}
	public String getDocumento_corto() {
		return documento_corto;
	}
	public void setDocumento_corto(String documento_corto) {
		this.documento_corto = documento_corto;
	}
	public String getSerie() {
		return serie;
	}
	public void setSerie(String serie) {
		this.serie = serie;
	}
	public int getFolio() {
		return folio;
	}
	public void setFolio(int folio) {
		this.folio = folio;
	}
	public int getTipo() {
		return tipo;
	}
	public void setTipo(int tipo) {
		this.tipo = tipo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	@Override
	public String toString() {
		return "Informacion [xml=" + xml + ", cdo=" + cdo + ", ode=" + ode + ", ods=" + ods + ", pedido=" + pedido
				+ ", documento_largo=" + documento_largo + ", documento_corto=" + documento_corto + ", serie=" + serie
				+ ", folio=" + folio + ", tipo=" + tipo + ", descripcion=" + descripcion + "]";
	}
	
	
}
