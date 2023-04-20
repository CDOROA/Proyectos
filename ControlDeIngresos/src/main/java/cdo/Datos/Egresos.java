package cdo.Datos;

import java.io.Serializable;

public class Egresos  implements Serializable{

	private static final long serialVersionUID = 1L;
	private String uname;
	private String uname_br;  
	private int id_egreso;
	private String nombre_egreso;  
	private int folio_caja; 
	private int folio_documento; 
	private String importe; 
	private int cve_forma_pago;
	private String formPago; 
	private String referencia;	
	private int banco_emisor; 
	private String nombre_banco_emisor; 
	private int banco_deposito; 
	private String nombre_banco_deposito;
	private int banco_transferencia;
	private String nombre_banco_transferencia;
	private String numero_transferencia;
	private String cve_usu;
	private String id_estatus;
	private String estatus;
	private int folio_corte_caja;
	private int folio_panamericano;
	private int folio_poliza;
	private String fecha_inicio;
	private String fecha_fin;
	private String cve_usu_autoriza;
	private String fecha_poliza;
	private String  colectiva;	
	
	public Egresos() {
		super();
	}

	public Egresos(String uname, String uname_br, int id_egreso, String nombre_egreso, int folio_caja,
			int folio_documento, String importe, int cve_forma_pago, String formPago, String referencia,
			int banco_emisor, String nombre_banco_emisor, int banco_deposito, String nombre_banco_deposito,
			int banco_transferencia, String nombre_banco_transferencia, String numero_transferencia, String cve_usu,
			String id_estatus, String estatus, int folio_corte_caja, int folio_panamericano, int folio_poliza,
			String fecha_inicio, String fecha_fin, String cve_usu_autoriza, String fecha_poliza, String colectiva) {
		super();
		this.uname = uname;
		this.uname_br = uname_br;
		this.id_egreso = id_egreso;
		this.nombre_egreso = nombre_egreso;
		this.folio_caja = folio_caja;
		this.folio_documento = folio_documento;
		this.importe = importe;
		this.cve_forma_pago = cve_forma_pago;
		this.formPago = formPago;
		this.referencia = referencia;
		this.banco_emisor = banco_emisor;
		this.nombre_banco_emisor = nombre_banco_emisor;
		this.banco_deposito = banco_deposito;
		this.nombre_banco_deposito = nombre_banco_deposito;
		this.banco_transferencia = banco_transferencia;
		this.nombre_banco_transferencia = nombre_banco_transferencia;
		this.numero_transferencia = numero_transferencia;
		this.cve_usu = cve_usu;
		this.id_estatus = id_estatus;
		this.estatus = estatus;
		this.folio_corte_caja = folio_corte_caja;
		this.folio_panamericano = folio_panamericano;
		this.folio_poliza = folio_poliza;
		this.fecha_inicio = fecha_inicio;
		this.fecha_fin = fecha_fin;
		this.cve_usu_autoriza = cve_usu_autoriza;
		this.fecha_poliza = fecha_poliza;
		this.colectiva = colectiva;
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

	public int getId_egreso() {
		return id_egreso;
	}

	public void setId_egreso(int id_egreso) {
		this.id_egreso = id_egreso;
	}

	public String getNombre_egreso() {
		return nombre_egreso;
	}

	public void setNombre_egreso(String nombre_egreso) {
		this.nombre_egreso = nombre_egreso;
	}

	public int getFolio_caja() {
		return folio_caja;
	}

	public void setFolio_caja(int folio_caja) {
		this.folio_caja = folio_caja;
	}

	public int getFolio_documento() {
		return folio_documento;
	}

	public void setFolio_documento(int folio_documento) {
		this.folio_documento = folio_documento;
	}

	public String getImporte() {
		return importe;
	}

	public void setImporte(String importe) {
		this.importe = importe;
	}

	public int getCve_forma_pago() {
		return cve_forma_pago;
	}

	public void setCve_forma_pago(int cve_forma_pago) {
		this.cve_forma_pago = cve_forma_pago;
	}

	public String getFormPago() {
		return formPago;
	}

	public void setFormPago(String formPago) {
		this.formPago = formPago;
	}

	public String getReferencia() {
		return referencia;
	}

	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}

	public int getBanco_emisor() {
		return banco_emisor;
	}

	public void setBanco_emisor(int banco_emisor) {
		this.banco_emisor = banco_emisor;
	}

	public String getNombre_banco_emisor() {
		return nombre_banco_emisor;
	}

	public void setNombre_banco_emisor(String nombre_banco_emisor) {
		this.nombre_banco_emisor = nombre_banco_emisor;
	}

	public int getBanco_deposito() {
		return banco_deposito;
	}

	public void setBanco_deposito(int banco_deposito) {
		this.banco_deposito = banco_deposito;
	}

	public String getNombre_banco_deposito() {
		return nombre_banco_deposito;
	}

	public void setNombre_banco_deposito(String nombre_banco_deposito) {
		this.nombre_banco_deposito = nombre_banco_deposito;
	}

	public int getBanco_transferencia() {
		return banco_transferencia;
	}

	public void setBanco_transferencia(int banco_transferencia) {
		this.banco_transferencia = banco_transferencia;
	}

	public String getNombre_banco_transferencia() {
		return nombre_banco_transferencia;
	}

	public void setNombre_banco_transferencia(String nombre_banco_transferencia) {
		this.nombre_banco_transferencia = nombre_banco_transferencia;
	}

	public String getNumero_transferencia() {
		return numero_transferencia;
	}

	public void setNumero_transferencia(String numero_transferencia) {
		this.numero_transferencia = numero_transferencia;
	}

	public String getCve_usu() {
		return cve_usu;
	}

	public void setCve_usu(String cve_usu) {
		this.cve_usu = cve_usu;
	}

	public String getId_estatus() {
		return id_estatus;
	}

	public void setId_estatus(String id_estatus) {
		this.id_estatus = id_estatus;
	}

	public String getEstatus() {
		return estatus;
	}

	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}

	public int getFolio_corte_caja() {
		return folio_corte_caja;
	}

	public void setFolio_corte_caja(int folio_corte_caja) {
		this.folio_corte_caja = folio_corte_caja;
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

	public String getFecha_inicio() {
		return fecha_inicio;
	}

	public void setFecha_inicio(String fecha_inicio) {
		this.fecha_inicio = fecha_inicio;
	}

	public String getFecha_fin() {
		return fecha_fin;
	}

	public void setFecha_fin(String fecha_fin) {
		this.fecha_fin = fecha_fin;
	}

	public String getCve_usu_autoriza() {
		return cve_usu_autoriza;
	}

	public void setCve_usu_autoriza(String cve_usu_autoriza) {
		this.cve_usu_autoriza = cve_usu_autoriza;
	}

	public String getFecha_poliza() {
		return fecha_poliza;
	}

	public void setFecha_poliza(String fecha_poliza) {
		this.fecha_poliza = fecha_poliza;
	}

	public String getColectiva() {
		return colectiva;
	}

	public void setColectiva(String colectiva) {
		this.colectiva = colectiva;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Egresos [uname=" + uname + ", uname_br=" + uname_br + ", id_egreso=" + id_egreso + ", nombre_egreso="
				+ nombre_egreso + ", folio_caja=" + folio_caja + ", folio_documento=" + folio_documento + ", importe="
				+ importe + ", cve_forma_pago=" + cve_forma_pago + ", formPago=" + formPago + ", referencia="
				+ referencia + ", banco_emisor=" + banco_emisor + ", nombre_banco_emisor=" + nombre_banco_emisor
				+ ", banco_deposito=" + banco_deposito + ", nombre_banco_deposito=" + nombre_banco_deposito
				+ ", banco_transferencia=" + banco_transferencia + ", nombre_banco_transferencia="
				+ nombre_banco_transferencia + ", numero_transferencia=" + numero_transferencia + ", cve_usu=" + cve_usu
				+ ", id_estatus=" + id_estatus + ", estatus=" + estatus + ", folio_corte_caja=" + folio_corte_caja
				+ ", folio_panamericano=" + folio_panamericano + ", folio_poliza=" + folio_poliza + ", fecha_inicio="
				+ fecha_inicio + ", fecha_fin=" + fecha_fin + ", cve_usu_autoriza=" + cve_usu_autoriza
				+ ", fecha_poliza=" + fecha_poliza + ", colectiva=" + colectiva + "]";
	}

	
}
