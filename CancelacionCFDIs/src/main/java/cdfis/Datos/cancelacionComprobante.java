package cdfis.Datos;

import java.sql.Time;

public class cancelacionComprobante {

	String uname;
	String uname_br;
	String tipo_documento;
	String documento_cancelado;
	String serie;
	int folio;
	int status;
	String fecha_pro;
	Time hora_pro;
	public cancelacionComprobante() {
		super();
		// TODO Auto-generated constructor stub
	}
	public cancelacionComprobante(String uname, String uname_br, String tipo_documento, String documento_cancelado,
			String serie, int folio, int status, String fecha_pro, Time hora_pro) {
		super();
		this.uname = uname;
		this.uname_br = uname_br;
		this.tipo_documento = tipo_documento;
		this.documento_cancelado = documento_cancelado;
		this.serie = serie;
		this.folio = folio;
		this.status = status;
		this.fecha_pro = fecha_pro;
		this.hora_pro = hora_pro;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getUname_br() {
		return uname_br;
	}
	public void setUname_br(String uname_br) {
		this.uname_br = uname_br;
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
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
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
		return "cancelacionComprobante [uname=" + uname + ", uname_br=" + uname_br + ", tipo_documento="
				+ tipo_documento + ", documento_cancelado=" + documento_cancelado + ", serie=" + serie + ", folio="
				+ folio + ", status=" + status + ", fecha_pro=" + fecha_pro + ", hora_pro=" + hora_pro + "]";
	}
	
	
}
