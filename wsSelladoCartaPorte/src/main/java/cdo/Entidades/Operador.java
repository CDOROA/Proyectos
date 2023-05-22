package cdo.Entidades;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Operador extends Identificadores implements Serializable
{
	
	private String residencia_fiscal;
	private String nombre;
	private String licencia;
	private String rfc;
	private String codigo_postal;
	private String pais;
	private String municipio;
	private String localidad;
	private String colonia;
	private String calle;
	public Operador() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Operador(String uname, String folio, String serie, String carta_porte) {
		super(uname, folio, serie, carta_porte);
		// TODO Auto-generated constructor stub
	}
	public Operador(String residencia_fiscal, String nombre, String licencia, String rfc, String codigo_postal,
			String pais, String municipio, String localidad, String colonia, String calle) {
		super();
		this.residencia_fiscal = residencia_fiscal;
		this.nombre = nombre;
		this.licencia = licencia;
		this.rfc = rfc;
		this.codigo_postal = codigo_postal;
		this.pais = pais;
		this.municipio = municipio;
		this.localidad = localidad;
		this.colonia = colonia;
		this.calle = calle;
	}
	public String getResidencia_fiscal() {
		return residencia_fiscal;
	}
	public void setResidencia_fiscal(String residencia_fiscal) {
		this.residencia_fiscal = residencia_fiscal;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getLicencia() {
		return licencia;
	}
	public void setLicencia(String licencia) {
		this.licencia = licencia;
	}
	public String getRfc() {
		return rfc;
	}
	public void setRfc(String rfc) {
		this.rfc = rfc;
	}
	public String getCodigo_postal() {
		return codigo_postal;
	}
	public void setCodigo_postal(String codigo_postal) {
		this.codigo_postal = codigo_postal;
	}
	public String getPais() {
		return pais;
	}
	public void setPais(String pais) {
		this.pais = pais;
	}
	public String getMunicipio() {
		return municipio;
	}
	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}
	public String getLocalidad() {
		return localidad;
	}
	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}
	public String getColonia() {
		return colonia;
	}
	public void setColonia(String colonia) {
		this.colonia = colonia;
	}
	public String getCalle() {
		return calle;
	}
	public void setCalle(String calle) {
		this.calle = calle;
	}
	@Override
	public String toString() {
		return "Operador [residencia_fiscal=" + residencia_fiscal + ", nombre=" + nombre + ", licencia=" + licencia
				+ ", rfc=" + rfc + ", codigo_postal=" + codigo_postal + ", pais=" + pais + ", municipio=" + municipio
				+ ", localidad=" + localidad + ", colonia=" + colonia + ", calle=" + calle + "]";
	}
	
	
}
