package cdo.Entidades;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Receptor  extends Identificadores implements Serializable
{	
	private String rfc; 
	private String nombre; 
	private String uname_rdf; 
	private String num_cli; 
	private String e_mail; 
	private String rdf_calle; 
	private String rdf_noexterior; 
	private String rdf_nointerior; 
	private String rdf_colonia; 
	private String rdf_localidad; 
	private String rdf_referencia; 
	private String rdf_municipio; 
	private String rdf_estado; 
	private String rdf_pais; 
	private String rdf_codigopostal; 
	private String rdf_telefono; 
	private String dcon_calle; 
	private String dcon_noexterior; 
	private String dcon_nointerior; 
	private String dcon_colonia; 
	private String dcon_localidad; 
	private String dcon_referencia; 
	private String dcon_municipio; 
	private String dcon_estado; 
	private String dcon_telefono; 
	private String dcon_pais;
	private String dcon_codigopostal;
	private String dcon_UsoCFDI;
	public Receptor() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Receptor(String uname, String folio, String serie, String carta_porte) {
		super(uname, folio, serie, carta_porte);
		// TODO Auto-generated constructor stub
	}
	public Receptor(String rfc, String nombre, String uname_rdf, String num_cli, String e_mail, String rdf_calle,
			String rdf_noexterior, String rdf_nointerior, String rdf_colonia, String rdf_localidad,
			String rdf_referencia, String rdf_municipio, String rdf_estado, String rdf_pais, String rdf_codigopostal,
			String rdf_telefono, String dcon_calle, String dcon_noexterior, String dcon_nointerior, String dcon_colonia,
			String dcon_localidad, String dcon_referencia, String dcon_municipio, String dcon_estado,
			String dcon_telefono, String dcon_pais, String dcon_codigopostal, String dcon_UsoCFDI) {
		super();
		this.rfc = rfc;
		this.nombre = nombre;
		this.uname_rdf = uname_rdf;
		this.num_cli = num_cli;
		this.e_mail = e_mail;
		this.rdf_calle = rdf_calle;
		this.rdf_noexterior = rdf_noexterior;
		this.rdf_nointerior = rdf_nointerior;
		this.rdf_colonia = rdf_colonia;
		this.rdf_localidad = rdf_localidad;
		this.rdf_referencia = rdf_referencia;
		this.rdf_municipio = rdf_municipio;
		this.rdf_estado = rdf_estado;
		this.rdf_pais = rdf_pais;
		this.rdf_codigopostal = rdf_codigopostal;
		this.rdf_telefono = rdf_telefono;
		this.dcon_calle = dcon_calle;
		this.dcon_noexterior = dcon_noexterior;
		this.dcon_nointerior = dcon_nointerior;
		this.dcon_colonia = dcon_colonia;
		this.dcon_localidad = dcon_localidad;
		this.dcon_referencia = dcon_referencia;
		this.dcon_municipio = dcon_municipio;
		this.dcon_estado = dcon_estado;
		this.dcon_telefono = dcon_telefono;
		this.dcon_pais = dcon_pais;
		this.dcon_codigopostal = dcon_codigopostal;
		this.dcon_UsoCFDI = dcon_UsoCFDI;
	}
	public String getRfc() {
		return rfc;
	}
	public void setRfc(String rfc) {
		this.rfc = rfc;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getUname_rdf() {
		return uname_rdf;
	}
	public void setUname_rdf(String uname_rdf) {
		this.uname_rdf = uname_rdf;
	}
	public String getNum_cli() {
		return num_cli;
	}
	public void setNum_cli(String num_cli) {
		this.num_cli = num_cli;
	}
	public String getE_mail() {
		return e_mail;
	}
	public void setE_mail(String e_mail) {
		this.e_mail = e_mail;
	}
	public String getRdf_calle() {
		return rdf_calle;
	}
	public void setRdf_calle(String rdf_calle) {
		this.rdf_calle = rdf_calle;
	}
	public String getRdf_noexterior() {
		return rdf_noexterior;
	}
	public void setRdf_noexterior(String rdf_noexterior) {
		this.rdf_noexterior = rdf_noexterior;
	}
	public String getRdf_nointerior() {
		return rdf_nointerior;
	}
	public void setRdf_nointerior(String rdf_nointerior) {
		this.rdf_nointerior = rdf_nointerior;
	}
	public String getRdf_colonia() {
		return rdf_colonia;
	}
	public void setRdf_colonia(String rdf_colonia) {
		this.rdf_colonia = rdf_colonia;
	}
	public String getRdf_localidad() {
		return rdf_localidad;
	}
	public void setRdf_localidad(String rdf_localidad) {
		this.rdf_localidad = rdf_localidad;
	}
	public String getRdf_referencia() {
		return rdf_referencia;
	}
	public void setRdf_referencia(String rdf_referencia) {
		this.rdf_referencia = rdf_referencia;
	}
	public String getRdf_municipio() {
		return rdf_municipio;
	}
	public void setRdf_municipio(String rdf_municipio) {
		this.rdf_municipio = rdf_municipio;
	}
	public String getRdf_estado() {
		return rdf_estado;
	}
	public void setRdf_estado(String rdf_estado) {
		this.rdf_estado = rdf_estado;
	}
	public String getRdf_pais() {
		return rdf_pais;
	}
	public void setRdf_pais(String rdf_pais) {
		this.rdf_pais = rdf_pais;
	}
	public String getRdf_codigopostal() {
		return rdf_codigopostal;
	}
	public void setRdf_codigopostal(String rdf_codigopostal) {
		this.rdf_codigopostal = rdf_codigopostal;
	}
	public String getRdf_telefono() {
		return rdf_telefono;
	}
	public void setRdf_telefono(String rdf_telefono) {
		this.rdf_telefono = rdf_telefono;
	}
	public String getDcon_calle() {
		return dcon_calle;
	}
	public void setDcon_calle(String dcon_calle) {
		this.dcon_calle = dcon_calle;
	}
	public String getDcon_noexterior() {
		return dcon_noexterior;
	}
	public void setDcon_noexterior(String dcon_noexterior) {
		this.dcon_noexterior = dcon_noexterior;
	}
	public String getDcon_nointerior() {
		return dcon_nointerior;
	}
	public void setDcon_nointerior(String dcon_nointerior) {
		this.dcon_nointerior = dcon_nointerior;
	}
	public String getDcon_colonia() {
		return dcon_colonia;
	}
	public void setDcon_colonia(String dcon_colonia) {
		this.dcon_colonia = dcon_colonia;
	}
	public String getDcon_localidad() {
		return dcon_localidad;
	}
	public void setDcon_localidad(String dcon_localidad) {
		this.dcon_localidad = dcon_localidad;
	}
	public String getDcon_referencia() {
		return dcon_referencia;
	}
	public void setDcon_referencia(String dcon_referencia) {
		this.dcon_referencia = dcon_referencia;
	}
	public String getDcon_municipio() {
		return dcon_municipio;
	}
	public void setDcon_municipio(String dcon_municipio) {
		this.dcon_municipio = dcon_municipio;
	}
	public String getDcon_estado() {
		return dcon_estado;
	}
	public void setDcon_estado(String dcon_estado) {
		this.dcon_estado = dcon_estado;
	}
	public String getDcon_telefono() {
		return dcon_telefono;
	}
	public void setDcon_telefono(String dcon_telefono) {
		this.dcon_telefono = dcon_telefono;
	}
	public String getDcon_pais() {
		return dcon_pais;
	}
	public void setDcon_pais(String dcon_pais) {
		this.dcon_pais = dcon_pais;
	}
	public String getDcon_codigopostal() {
		return dcon_codigopostal;
	}
	public void setDcon_codigopostal(String dcon_codigopostal) {
		this.dcon_codigopostal = dcon_codigopostal;
	}
	public String getDcon_UsoCFDI() {
		return dcon_UsoCFDI;
	}
	public void setDcon_UsoCFDI(String dcon_UsoCFDI) {
		this.dcon_UsoCFDI = dcon_UsoCFDI;
	}
	@Override
	public String toString() {
		return "Receptor [rfc=" + rfc + ", nombre=" + nombre + ", uname_rdf=" + uname_rdf + ", num_cli=" + num_cli
				+ ", e_mail=" + e_mail + ", rdf_calle=" + rdf_calle + ", rdf_noexterior=" + rdf_noexterior
				+ ", rdf_nointerior=" + rdf_nointerior + ", rdf_colonia=" + rdf_colonia + ", rdf_localidad="
				+ rdf_localidad + ", rdf_referencia=" + rdf_referencia + ", rdf_municipio=" + rdf_municipio
				+ ", rdf_estado=" + rdf_estado + ", rdf_pais=" + rdf_pais + ", rdf_codigopostal=" + rdf_codigopostal
				+ ", rdf_telefono=" + rdf_telefono + ", dcon_calle=" + dcon_calle + ", dcon_noexterior="
				+ dcon_noexterior + ", dcon_nointerior=" + dcon_nointerior + ", dcon_colonia=" + dcon_colonia
				+ ", dcon_localidad=" + dcon_localidad + ", dcon_referencia=" + dcon_referencia + ", dcon_municipio="
				+ dcon_municipio + ", dcon_estado=" + dcon_estado + ", dcon_telefono=" + dcon_telefono + ", dcon_pais="
				+ dcon_pais + ", dcon_codigopostal=" + dcon_codigopostal + ", dcon_UsoCFDI=" + dcon_UsoCFDI + "]";
	}
	
}
