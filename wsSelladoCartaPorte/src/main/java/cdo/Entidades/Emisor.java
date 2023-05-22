package cdo.Entidades;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Emisor extends Identificadores implements Serializable
{
	private String rfc;
	private String nombre;
	private String uname_edf;
	private String num_cli;
	private String regimenfiscal;
	private String edf_calle;
	private String edf_noexterior;
	private String edf_nointerior;
	private String edf_colonia;
	private String edf_localidad;
	private String edf_referencia;
	private String edf_municipio;
	private String edf_estado;
	private String edf_pais;
	private String edf_codigopostal;
	private String edf_telefono;
	private String dexp_calle;
	private String dexp_noexterior;
	private String dexp_nointerior;
	private String dexp_colonia;
	private String dexp_localidad;
	private String dexp_referencia;
	private String dexp_municipio;
	private String dexp_estado;
	private String dexp_pais;
	private String dexp_codiopostal;
	private String dexp_telefono;
	private String fecha_pro;
	private String hora_pro;
	public Emisor() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Emisor(String uname, String folio, String serie, String carta_porte) {
		super(uname, folio, serie, carta_porte);
		// TODO Auto-generated constructor stub
	}
	public Emisor(String rfc, String nombre, String uname_edf, String num_cli, String regimenfiscal, String edf_calle,
			String edf_noexterior, String edf_nointerior, String edf_colonia, String edf_localidad,
			String edf_referencia, String edf_municipio, String edf_estado, String edf_pais, String edf_codigopostal,
			String edf_telefono, String dexp_calle, String dexp_noexterior, String dexp_nointerior, String dexp_colonia,
			String dexp_localidad, String dexp_referencia, String dexp_municipio, String dexp_estado, String dexp_pais,
			String dexp_codiopostal, String dexp_telefono, String fecha_pro, String hora_pro) {
		super();
		this.rfc = rfc;
		this.nombre = nombre;
		this.uname_edf = uname_edf;
		this.num_cli = num_cli;
		this.regimenfiscal = regimenfiscal;
		this.edf_calle = edf_calle;
		this.edf_noexterior = edf_noexterior;
		this.edf_nointerior = edf_nointerior;
		this.edf_colonia = edf_colonia;
		this.edf_localidad = edf_localidad;
		this.edf_referencia = edf_referencia;
		this.edf_municipio = edf_municipio;
		this.edf_estado = edf_estado;
		this.edf_pais = edf_pais;
		this.edf_codigopostal = edf_codigopostal;
		this.edf_telefono = edf_telefono;
		this.dexp_calle = dexp_calle;
		this.dexp_noexterior = dexp_noexterior;
		this.dexp_nointerior = dexp_nointerior;
		this.dexp_colonia = dexp_colonia;
		this.dexp_localidad = dexp_localidad;
		this.dexp_referencia = dexp_referencia;
		this.dexp_municipio = dexp_municipio;
		this.dexp_estado = dexp_estado;
		this.dexp_pais = dexp_pais;
		this.dexp_codiopostal = dexp_codiopostal;
		this.dexp_telefono = dexp_telefono;
		this.fecha_pro = fecha_pro;
		this.hora_pro = hora_pro;
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
	public String getUname_edf() {
		return uname_edf;
	}
	public void setUname_edf(String uname_edf) {
		this.uname_edf = uname_edf;
	}
	public String getNum_cli() {
		return num_cli;
	}
	public void setNum_cli(String num_cli) {
		this.num_cli = num_cli;
	}
	public String getRegimenfiscal() {
		return regimenfiscal;
	}
	public void setRegimenfiscal(String regimenfiscal) {
		this.regimenfiscal = regimenfiscal;
	}
	public String getEdf_calle() {
		return edf_calle;
	}
	public void setEdf_calle(String edf_calle) {
		this.edf_calle = edf_calle;
	}
	public String getEdf_noexterior() {
		return edf_noexterior;
	}
	public void setEdf_noexterior(String edf_noexterior) {
		this.edf_noexterior = edf_noexterior;
	}
	public String getEdf_nointerior() {
		return edf_nointerior;
	}
	public void setEdf_nointerior(String edf_nointerior) {
		this.edf_nointerior = edf_nointerior;
	}
	public String getEdf_colonia() {
		return edf_colonia;
	}
	public void setEdf_colonia(String edf_colonia) {
		this.edf_colonia = edf_colonia;
	}
	public String getEdf_localidad() {
		return edf_localidad;
	}
	public void setEdf_localidad(String edf_localidad) {
		this.edf_localidad = edf_localidad;
	}
	public String getEdf_referencia() {
		return edf_referencia;
	}
	public void setEdf_referencia(String edf_referencia) {
		this.edf_referencia = edf_referencia;
	}
	public String getEdf_municipio() {
		return edf_municipio;
	}
	public void setEdf_municipio(String edf_municipio) {
		this.edf_municipio = edf_municipio;
	}
	public String getEdf_estado() {
		return edf_estado;
	}
	public void setEdf_estado(String edf_estado) {
		this.edf_estado = edf_estado;
	}
	public String getEdf_pais() {
		return edf_pais;
	}
	public void setEdf_pais(String edf_pais) {
		this.edf_pais = edf_pais;
	}
	public String getEdf_codigopostal() {
		return edf_codigopostal;
	}
	public void setEdf_codigopostal(String edf_codigopostal) {
		this.edf_codigopostal = edf_codigopostal;
	}
	public String getEdf_telefono() {
		return edf_telefono;
	}
	public void setEdf_telefono(String edf_telefono) {
		this.edf_telefono = edf_telefono;
	}
	public String getDexp_calle() {
		return dexp_calle;
	}
	public void setDexp_calle(String dexp_calle) {
		this.dexp_calle = dexp_calle;
	}
	public String getDexp_noexterior() {
		return dexp_noexterior;
	}
	public void setDexp_noexterior(String dexp_noexterior) {
		this.dexp_noexterior = dexp_noexterior;
	}
	public String getDexp_nointerior() {
		return dexp_nointerior;
	}
	public void setDexp_nointerior(String dexp_nointerior) {
		this.dexp_nointerior = dexp_nointerior;
	}
	public String getDexp_colonia() {
		return dexp_colonia;
	}
	public void setDexp_colonia(String dexp_colonia) {
		this.dexp_colonia = dexp_colonia;
	}
	public String getDexp_localidad() {
		return dexp_localidad;
	}
	public void setDexp_localidad(String dexp_localidad) {
		this.dexp_localidad = dexp_localidad;
	}
	public String getDexp_referencia() {
		return dexp_referencia;
	}
	public void setDexp_referencia(String dexp_referencia) {
		this.dexp_referencia = dexp_referencia;
	}
	public String getDexp_municipio() {
		return dexp_municipio;
	}
	public void setDexp_municipio(String dexp_municipio) {
		this.dexp_municipio = dexp_municipio;
	}
	public String getDexp_estado() {
		return dexp_estado;
	}
	public void setDexp_estado(String dexp_estado) {
		this.dexp_estado = dexp_estado;
	}
	public String getDexp_pais() {
		return dexp_pais;
	}
	public void setDexp_pais(String dexp_pais) {
		this.dexp_pais = dexp_pais;
	}
	public String getDexp_codiopostal() {
		return dexp_codiopostal;
	}
	public void setDexp_codiopostal(String dexp_codiopostal) {
		this.dexp_codiopostal = dexp_codiopostal;
	}
	public String getDexp_telefono() {
		return dexp_telefono;
	}
	public void setDexp_telefono(String dexp_telefono) {
		this.dexp_telefono = dexp_telefono;
	}
	public String getFecha_pro() {
		return fecha_pro;
	}
	public void setFecha_pro(String fecha_pro) {
		this.fecha_pro = fecha_pro;
	}
	public String getHora_pro() {
		return hora_pro;
	}
	public void setHora_pro(String hora_pro) {
		this.hora_pro = hora_pro;
	}
	@Override
	public String toString() {
		return "Emisor [rfc=" + rfc + ", nombre=" + nombre + ", uname_edf=" + uname_edf + ", num_cli=" + num_cli
				+ ", regimenfiscal=" + regimenfiscal + ", edf_calle=" + edf_calle + ", edf_noexterior=" + edf_noexterior
				+ ", edf_nointerior=" + edf_nointerior + ", edf_colonia=" + edf_colonia + ", edf_localidad="
				+ edf_localidad + ", edf_referencia=" + edf_referencia + ", edf_municipio=" + edf_municipio
				+ ", edf_estado=" + edf_estado + ", edf_pais=" + edf_pais + ", edf_codigopostal=" + edf_codigopostal
				+ ", edf_telefono=" + edf_telefono + ", dexp_calle=" + dexp_calle + ", dexp_noexterior="
				+ dexp_noexterior + ", dexp_nointerior=" + dexp_nointerior + ", dexp_colonia=" + dexp_colonia
				+ ", dexp_localidad=" + dexp_localidad + ", dexp_referencia=" + dexp_referencia + ", dexp_municipio="
				+ dexp_municipio + ", dexp_estado=" + dexp_estado + ", dexp_pais=" + dexp_pais + ", dexp_codiopostal="
				+ dexp_codiopostal + ", dexp_telefono=" + dexp_telefono + ", fecha_pro=" + fecha_pro + ", hora_pro="
				+ hora_pro + "]";
	}
	
	
}
