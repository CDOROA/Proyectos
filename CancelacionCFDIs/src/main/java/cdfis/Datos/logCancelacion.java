package cdfis.Datos;

import java.sql.Time;

public class logCancelacion {
	
	int id_log;
	String tipo_documento;
	String documento_cancelado;
	String accion;
	String cve_usu;
	String serie;
	int folio;
	String fecha_pro;
	Time hora_pro;
	public logCancelacion() {
		super();
		// TODO Auto-generated constructor stub
	}
	public logCancelacion(int id_log, String tipo_documento, String documento_cancelado, String accion, String cve_usu,
			String serie, int folio, String fecha_pro, Time hora_pro) {
		super();
		this.id_log = id_log;
		this.tipo_documento = tipo_documento;
		this.documento_cancelado = documento_cancelado;
		this.accion = accion;
		this.cve_usu = cve_usu;
		this.serie = serie;
		this.folio = folio;
		this.fecha_pro = fecha_pro;
		this.hora_pro = hora_pro;
	}
	public int getId_log() {
		return id_log;
	}
	public void setId_log(int id_log) {
		this.id_log = id_log;
	}
	public String getTipo_documento() {
		return tipo_documento;
	}
	public void setTipo_documento(String tipo_documento) {
		this.tipo_documento = tipo_documento;
	}
	public String getDocumento_cancelado() {
		return documento_cancelado;
	}
	public void setDocumento_cancelado(String documento_cancelado) {
		this.documento_cancelado = documento_cancelado;
	}
	public String getAccion() {
		return accion;
	}
	public void setAccion(String accion) {
		this.accion = accion;
	}
	public String getCve_usu() {
		return cve_usu;
	}
	public void setCve_usu(String cve_usu) {
		this.cve_usu = cve_usu;
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
	public String getFecha_pro() {
		return fecha_pro;
	}
	public void setFecha_pro(String fecha_pro) {
		this.fecha_pro = fecha_pro;
	}
	public Time getHora_pro() {
		return hora_pro;
	}
	public void setHora_pro(Time hora_pro) {
		this.hora_pro = hora_pro;
	}
	@Override
	public String toString() {
		return "logCancelacion [id_log=" + id_log + ", tipo_documento=" + tipo_documento + ", documento_cancelado="
				+ documento_cancelado + ", accion=" + accion + ", cve_usu=" + cve_usu + ", serie=" + serie + ", folio="
				+ folio + ", fecha_pro=" + fecha_pro + ", hora_pro=" + hora_pro + "]";
	}
	
	
}
