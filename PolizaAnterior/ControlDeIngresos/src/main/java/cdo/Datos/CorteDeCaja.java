package cdo.Datos;

import java.io.Serializable;

public class CorteDeCaja implements Serializable{

	private static final long serialVersionUID = 1L;
	private String uname;
	private String uname_br;
	private String  folio_corte;
	private String importe;
	private String importeEfectivo;
	private String usuario;
	private String nombre_usuario;
	private int folio_panamericano;
	private int folio_poliza;
	private int estatus;
	private String fecha_corteCaja;
	private String hora_corteCaja;
	private String fecha_poliza;
	private String fecha_panamericano;
	private boolean checked;
	private String papeleta;
	private String plomo;
	private String usuario_panamericano;
	private String nombre_usuario_panamericano;
		
	public CorteDeCaja() {
		super();
	}

	public CorteDeCaja(String uname, String uname_br, String folio_corte, String importe, String importeEfectivo,
			String usuario, String nombre_usuario, int folio_panamericano, int folio_poliza, int estatus,
			String fecha_corteCaja, String hora_corteCaja, String fecha_poliza, String fecha_panamericano,
			boolean checked, String papeleta, String plomo, String usuario_panamericano,
			String nombre_usuario_panamericano) {
		super();
		this.uname = uname;
		this.uname_br = uname_br;
		this.folio_corte = folio_corte;
		this.importe = importe;
		this.importeEfectivo = importeEfectivo;
		this.usuario = usuario;
		this.nombre_usuario = nombre_usuario;
		this.folio_panamericano = folio_panamericano;
		this.folio_poliza = folio_poliza;
		this.estatus = estatus;
		this.fecha_corteCaja = fecha_corteCaja;
		this.hora_corteCaja = hora_corteCaja;
		this.fecha_poliza = fecha_poliza;
		this.fecha_panamericano = fecha_panamericano;
		this.checked = checked;
		this.papeleta = papeleta;
		this.plomo = plomo;
		this.usuario_panamericano = usuario_panamericano;
		this.nombre_usuario_panamericano = nombre_usuario_panamericano;
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

	public String getFolio_corte() {
		return folio_corte;
	}

	public void setFolio_corte(String folio_corte) {
		this.folio_corte = folio_corte;
	}

	public String getImporte() {
		return importe;
	}

	public void setImporte(String importe) {
		this.importe = importe;
	}

	public String getImporteEfectivo() {
		return importeEfectivo;
	}

	public void setImporteEfectivo(String importeEfectivo) {
		this.importeEfectivo = importeEfectivo;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getNombre_usuario() {
		return nombre_usuario;
	}

	public void setNombre_usuario(String nombre_usuario) {
		this.nombre_usuario = nombre_usuario;
	}

	public int getFolio_panamericano() {
		return folio_panamericano;
	}

	public void setFolio_panamericano(int folio_panamericano) {
		this.folio_panamericano = folio_panamericano;
	}

	public int getFolio_poliza() {
		return folio_poliza;
	}

	public void setFolio_poliza(int folio_poliza) {
		this.folio_poliza = folio_poliza;
	}

	public int getEstatus() {
		return estatus;
	}

	public void setEstatus(int estatus) {
		this.estatus = estatus;
	}

	public String getFecha_corteCaja() {
		return fecha_corteCaja;
	}

	public void setFecha_corteCaja(String fecha_corteCaja) {
		this.fecha_corteCaja = fecha_corteCaja;
	}

	public String getHora_corteCaja() {
		return hora_corteCaja;
	}

	public void setHora_corteCaja(String hora_corteCaja) {
		this.hora_corteCaja = hora_corteCaja;
	}

	public String getFecha_poliza() {
		return fecha_poliza;
	}

	public void setFecha_poliza(String fecha_poliza) {
		this.fecha_poliza = fecha_poliza;
	}

	public String getFecha_panamericano() {
		return fecha_panamericano;
	}

	public void setFecha_panamericano(String fecha_panamericano) {
		this.fecha_panamericano = fecha_panamericano;
	}

	public boolean isChecked() {
		return checked;
	}

	public void setChecked(boolean checked) {
		this.checked = checked;
	}

	public String getPapeleta() {
		return papeleta;
	}

	public void setPapeleta(String papeleta) {
		this.papeleta = papeleta;
	}

	public String getPlomo() {
		return plomo;
	}

	public void setPlomo(String plomo) {
		this.plomo = plomo;
	}

	public String getUsuario_panamericano() {
		return usuario_panamericano;
	}

	public void setUsuario_panamericano(String usuario_panamericano) {
		this.usuario_panamericano = usuario_panamericano;
	}

	public String getNombre_usuario_panamericano() {
		return nombre_usuario_panamericano;
	}

	public void setNombre_usuario_panamericano(String nombre_usuario_panamericano) {
		this.nombre_usuario_panamericano = nombre_usuario_panamericano;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "CorteDeCaja [uname=" + uname + ", uname_br=" + uname_br + ", folio_corte=" + folio_corte + ", importe="
				+ importe + ", importeEfectivo=" + importeEfectivo + ", usuario=" + usuario + ", nombre_usuario="
				+ nombre_usuario + ", folio_panamericano=" + folio_panamericano + ", folio_poliza=" + folio_poliza
				+ ", estatus=" + estatus + ", fecha_corteCaja=" + fecha_corteCaja + ", hora_corteCaja=" + hora_corteCaja
				+ ", fecha_poliza=" + fecha_poliza + ", fecha_panamericano=" + fecha_panamericano + ", checked="
				+ checked + ", papeleta=" + papeleta + ", plomo=" + plomo + ", usuario_panamericano="
				+ usuario_panamericano + ", nombre_usuario_panamericano=" + nombre_usuario_panamericano + "]";
	}
}