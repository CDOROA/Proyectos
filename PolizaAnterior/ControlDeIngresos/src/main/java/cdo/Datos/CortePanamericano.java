package cdo.Datos;

import java.io.Serializable;

public class CortePanamericano implements Serializable{

	private static final long serialVersionUID = 1L;
	private String uname;
	private String uname_br;
	private int folio_panamericano;
	private String importe;
	private String plomo;
	private String papeleta;
	private String cve_usuario;
	private int folio_poliza;
	private int id_estatus;
	private String fecha_pro;
	private String hora_pro;
	
	public CortePanamericano() {
		super();
	}

	public CortePanamericano(String uname, String uname_br, int folio_panamericano, String importe, String plomo,
			String papeleta, String cve_usuario, int folio_poliza, int id_estatus, String fecha_pro, String hora_pro) {
		super();
		this.uname = uname;
		this.uname_br = uname_br;
		this.folio_panamericano = folio_panamericano;
		this.importe = importe;
		this.plomo = plomo;
		this.papeleta = papeleta;
		this.cve_usuario = cve_usuario;
		this.folio_poliza = folio_poliza;
		this.id_estatus = id_estatus;
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

	public int getFolio_panamericano() {
		return folio_panamericano;
	}

	public void setFolio_panamericano(int folio_panamericano) {
		this.folio_panamericano = folio_panamericano;
	}

	public String getImporte() {
		return importe;
	}

	public void setImporte(String importe) {
		this.importe = importe;
	}

	public String getPlomo() {
		return plomo;
	}

	public void setPlomo(String plomo) {
		this.plomo = plomo;
	}

	public String getPapeleta() {
		return papeleta;
	}

	public void setPapeleta(String papeleta) {
		this.papeleta = papeleta;
	}

	public String getCve_usuario() {
		return cve_usuario;
	}

	public void setCve_usuario(String cve_usuario) {
		this.cve_usuario = cve_usuario;
	}

	public int getFolio_poliza() {
		return folio_poliza;
	}

	public void setFolio_poliza(int folio_poliza) {
		this.folio_poliza = folio_poliza;
	}

	public int getId_estatus() {
		return id_estatus;
	}

	public void setId_estatus(int id_estatus) {
		this.id_estatus = id_estatus;
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
		return "CortePanamericano [uname=" + uname + ", uname_br=" + uname_br + ", folio_panamericano="
				+ folio_panamericano + ", importe=" + importe + ", plomo=" + plomo + ", papeleta=" + papeleta
				+ ", cve_usuario=" + cve_usuario + ", folio_poliza=" + folio_poliza + ", id_estatus=" + id_estatus
				+ ", fecha_pro=" + fecha_pro + ", hora_pro=" + hora_pro + "]";
	}

}
