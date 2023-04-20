package cdo.Entidades;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Comprobante extends Identificadores implements Serializable  
{

	private String folio_fiscal;
	private String rfc_prov_certif;
	private String noCertificado_csd;
	private String noCertificado_sat;
	private String certificado;
	private String sello_digital;
	private String sello_sat;
	private String cadena_original;
	private String tipo_moneda;
	private String fecha_certificacion;
	private String fecha_emision;
	private String regimenfiscal;
	private String fecha_procesada;
	private String subtotal;
	private String total;
	private String total_letra = "Cero pesos con Cero centavos";
	private String tipo_de_comprobante;
	private String lugarExpedicion;
	private String codigo_cbb;
	private String codigo_pdf;
	private String codigo_xml;
	private String fecha_pro;
	private String hora_pro;
	public Comprobante() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Comprobante(String uname, String folio, String serie, String carta_porte) {
		super(uname, folio, serie, carta_porte);
		// TODO Auto-generated constructor stub
	}
	public Comprobante(String folio_fiscal, String rfc_prov_certif, String noCertificado_csd, String noCertificado_sat,
			String certificado, String sello_digital, String sello_sat, String cadena_original, String tipo_moneda,
			String fecha_certificacion, String fecha_emision, String regimenfiscal, String fecha_procesada,
			String subtotal, String total, String total_letra, String tipo_de_comprobante, String lugarExpedicion,
			String codigo_cbb, String codigo_pdf,String codigo_xml, String fecha_pro, String hora_pro) {
		super();
		this.folio_fiscal = folio_fiscal;
		this.rfc_prov_certif = rfc_prov_certif;
		this.noCertificado_csd = noCertificado_csd;
		this.noCertificado_sat = noCertificado_sat;
		this.certificado = certificado;
		this.sello_digital = sello_digital;
		this.sello_sat = sello_sat;
		this.cadena_original = cadena_original;
		this.tipo_moneda = tipo_moneda;
		this.fecha_certificacion = fecha_certificacion;
		this.fecha_emision = fecha_emision;
		this.regimenfiscal = regimenfiscal;
		this.fecha_procesada = fecha_procesada;
		this.subtotal = subtotal;
		this.total = total;
		this.total_letra = total_letra;
		this.tipo_de_comprobante = tipo_de_comprobante;
		this.lugarExpedicion = lugarExpedicion;
		this.codigo_cbb = codigo_cbb;
		this.codigo_pdf= codigo_pdf;
		this.codigo_xml = codigo_xml;
		this.fecha_pro = fecha_pro;
		this.hora_pro = hora_pro;
	}
	public String getFolio_fiscal() {
		return folio_fiscal;
	}
	public void setFolio_fiscal(String folio_fiscal) {
		this.folio_fiscal = folio_fiscal;
	}
	public String getRfc_prov_certif() {
		return rfc_prov_certif;
	}
	public void setRfc_prov_certif(String rfc_prov_certif) {
		this.rfc_prov_certif = rfc_prov_certif;
	}
	public String getNoCertificado_csd() {
		return noCertificado_csd;
	}
	public void setNoCertificado_csd(String noCertificado_csd) {
		this.noCertificado_csd = noCertificado_csd;
	}
	public String getNoCertificado_sat() {
		return noCertificado_sat;
	}
	public void setNoCertificado_sat(String noCertificado_sat) {
		this.noCertificado_sat = noCertificado_sat;
	}
	public String getCertificado() {
		return certificado;
	}
	public void setCertificado(String certificado) {
		this.certificado = certificado;
	}
	public String getSello_digital() {
		return sello_digital;
	}
	public void setSello_digital(String sello_digital) {
		this.sello_digital = sello_digital;
	}
	public String getSello_sat() {
		return sello_sat;
	}
	public void setSello_sat(String sello_sat) {
		this.sello_sat = sello_sat;
	}
	public String getCadena_original() {
		return cadena_original;
	}
	public void setCadena_original(String cadena_original) {
		this.cadena_original = cadena_original;
	}
	public String getTipo_moneda() {
		return tipo_moneda;
	}
	public void setTipo_moneda(String tipo_moneda) {
		this.tipo_moneda = tipo_moneda;
	}
	public String getFecha_certificacion() {
		return fecha_certificacion;
	}
	public void setFecha_certificacion(String fecha_certificacion) {
		this.fecha_certificacion = fecha_certificacion;
	}
	public String getFecha_emision() {
		return fecha_emision;
	}
	public void setFecha_emision(String fecha_emision) {
		this.fecha_emision = fecha_emision;
	}
	public String getRegimenfiscal() {
		return regimenfiscal;
	}
	public void setRegimenfiscal(String regimenfiscal) {
		this.regimenfiscal = regimenfiscal;
	}
	public String getFecha_procesada() {
		return fecha_procesada;
	}
	public void setFecha_procesada(String fecha_procesada) {
		this.fecha_procesada = fecha_procesada;
	}
	public String getSubtotal() {
		return subtotal;
	}
	public void setSubtotal(String subtotal) {
		this.subtotal = subtotal;
	}
	public String getTotal() {
		return total;
	}
	public void setTotal(String total) {
		this.total = total;
	}
	public String getTotal_letra() {
		return total_letra;
	}
	public void setTotal_letra(String total_letra) {
		this.total_letra = total_letra;
	}
	public String getTipo_de_comprobante() {
		return tipo_de_comprobante;
	}
	public void setTipo_de_comprobante(String tipo_de_comprobante) {
		this.tipo_de_comprobante = tipo_de_comprobante;
	}
	public String getLugarExpedicion() {
		return lugarExpedicion;
	}
	public void setLugarExpedicion(String lugarExpedicion) {
		this.lugarExpedicion = lugarExpedicion;
	}
	public String getCodigo_cbb() {
		return codigo_cbb;
	}
	public void setCodigo_cbb(String codigo_cbb) {
		this.codigo_cbb = codigo_cbb;
	}
	
	public String getCodigo_pdf() {
		return codigo_pdf;
	}
	public void setCodigo_pdf(String codigo_pdf) {
		this.codigo_pdf = codigo_pdf;
	}
	public String getCodigo_xml() {
		return codigo_xml;
	}
	public void setCodigo_xml(String codigo_xml) {
		this.codigo_xml = codigo_xml;
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
		return "Comprobante [folio_fiscal=" + folio_fiscal + ", rfc_prov_certif=" + rfc_prov_certif
				+ ", noCertificado_csd=" + noCertificado_csd + ", noCertificado_sat=" + noCertificado_sat
				+ ", certificado=" + certificado + ", sello_digital=" + sello_digital + ", sello_sat=" + sello_sat
				+ ", cadena_original=" + cadena_original + ", tipo_moneda=" + tipo_moneda + ", fecha_certificacion="
				+ fecha_certificacion + ", fecha_emision=" + fecha_emision + ", regimenfiscal=" + regimenfiscal
				+ ", fecha_procesada=" + fecha_procesada + ", subtotal=" + subtotal + ", total=" + total
				+ ", total_letra=" + total_letra + ", tipo_de_comprobante=" + tipo_de_comprobante + ", lugarExpedicion="
				+ lugarExpedicion + ", codigo_cbb=" + codigo_cbb + ", codigo_pdf=" + codigo_pdf + ", codigo_xml="
				+ codigo_xml + ", fecha_pro=" + fecha_pro + ", hora_pro=" + hora_pro + "]";
	}

}
