package cdo.Datos;

import java.io.Serializable;

public class ChequesPosfechados implements Serializable 
{
	private static final long serialVersionUID = 1L;
	private int no;
	private String fecha_creacion;
	private String fecha_administrador;
	private String referencia;
	private int num_agente;
	private String nombre_agente;
	private String cve_usu_ecc;
	private String nombre_ecc;
	private int num_cli;
	private String nombre_cliente;
	private int cve_banco;
	private String nombre_banco;
	private String importe;
	private int folio_caja;
	private int folio_caja_cheque_nominativo;
	private String ficha_deposito;
	private int id_estatus;
	private String descripcion_estatus;
	private String fecha_pago;
	private String descripcion_cancelacion;
	private int id_tipo_ingreso;
	
	public ChequesPosfechados() {
		super();
	}
	public ChequesPosfechados(int no, String fecha_creacion, String fecha_administrador, String referencia,
			int num_agente, String nombre_agente, String cve_usu_ecc, String nombre_ecc, int num_cli,
			String nombre_cliente, int cve_banco, String nombre_banco, String importe, int folio_caja,
			int folio_caja_cheque_nominativo, String ficha_deposito, int id_estatus, String descripcion_estatus,
			String fecha_pago, String descripcion_cancelacion, int id_tipo_ingreso) {
		super();
		this.no = no;
		this.fecha_creacion = fecha_creacion;
		this.fecha_administrador = fecha_administrador;
		this.referencia = referencia;
		this.num_agente = num_agente;
		this.nombre_agente = nombre_agente;
		this.cve_usu_ecc = cve_usu_ecc;
		this.nombre_ecc = nombre_ecc;
		this.num_cli = num_cli;
		this.nombre_cliente = nombre_cliente;
		this.cve_banco = cve_banco;
		this.nombre_banco = nombre_banco;
		this.importe = importe;
		this.folio_caja = folio_caja;
		this.folio_caja_cheque_nominativo = folio_caja_cheque_nominativo;
		this.ficha_deposito = ficha_deposito;
		this.id_estatus = id_estatus;
		this.descripcion_estatus = descripcion_estatus;
		this.fecha_pago = fecha_pago;
		this.descripcion_cancelacion = descripcion_cancelacion;
		this.id_tipo_ingreso = id_tipo_ingreso;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getFecha_creacion() {
		return fecha_creacion;
	}
	public void setFecha_creacion(String fecha_creacion) {
		this.fecha_creacion = fecha_creacion;
	}
	public String getFecha_administrador() {
		return fecha_administrador;
	}
	public void setFecha_administrador(String fecha_administrador) {
		this.fecha_administrador = fecha_administrador;
	}
	public String getReferencia() {
		return referencia;
	}
	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}
	public int getNum_agente() {
		return num_agente;
	}
	public void setNum_agente(int num_agente) {
		this.num_agente = num_agente;
	}
	public String getNombre_agente() {
		return nombre_agente;
	}
	public void setNombre_agente(String nombre_agente) {
		this.nombre_agente = nombre_agente;
	}
	public String getCve_usu_ecc() {
		return cve_usu_ecc;
	}
	public void setCve_usu_ecc(String cve_usu_ecc) {
		this.cve_usu_ecc = cve_usu_ecc;
	}
	public String getNombre_ecc() {
		return nombre_ecc;
	}
	public void setNombre_ecc(String nombre_ecc) {
		this.nombre_ecc = nombre_ecc;
	}
	public int getNum_cli() {
		return num_cli;
	}
	public void setNum_cli(int num_cli) {
		this.num_cli = num_cli;
	}
	public String getNombre_cliente() {
		return nombre_cliente;
	}
	public void setNombre_cliente(String nombre_cliente) {
		this.nombre_cliente = nombre_cliente;
	}
	public int getCve_banco() {
		return cve_banco;
	}
	public void setCve_banco(int cve_banco) {
		this.cve_banco = cve_banco;
	}
	public String getNombre_banco() {
		return nombre_banco;
	}
	public void setNombre_banco(String nombre_banco) {
		this.nombre_banco = nombre_banco;
	}
	public String getImporte() {
		return importe;
	}
	public void setImporte(String importe) {
		this.importe = importe;
	}
	public int getFolio_caja() {
		return folio_caja;
	}
	public void setFolio_caja(int folio_caja) {
		this.folio_caja = folio_caja;
	}
	public int getFolio_caja_cheque_nominativo() {
		return folio_caja_cheque_nominativo;
	}
	public void setFolio_caja_cheque_nominativo(int folio_caja_cheque_nominativo) {
		this.folio_caja_cheque_nominativo = folio_caja_cheque_nominativo;
	}
	public String getFicha_deposito() {
		return ficha_deposito;
	}
	public void setFicha_deposito(String ficha_deposito) {
		this.ficha_deposito = ficha_deposito;
	}
	public int getId_estatus() {
		return id_estatus;
	}
	public void setId_estatus(int id_estatus) {
		this.id_estatus = id_estatus;
	}
	public String getDescripcion_estatus() {
		return descripcion_estatus;
	}
	public void setDescripcion_estatus(String descripcion_estatus) {
		this.descripcion_estatus = descripcion_estatus;
	}
	public String getFecha_pago() {
		return fecha_pago;
	}
	public void setFecha_pago(String fecha_pago) {
		this.fecha_pago = fecha_pago;
	}
	public String getDescripcion_cancelacion() {
		return descripcion_cancelacion;
	}
	public void setDescripcion_cancelacion(String descripcion_cancelacion) {
		this.descripcion_cancelacion = descripcion_cancelacion;
	}
	public int getId_tipo_ingreso() {
		return id_tipo_ingreso;
	}
	public void setId_tipo_ingreso(int id_tipo_ingreso) {
		this.id_tipo_ingreso = id_tipo_ingreso;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "ChequesPosfechados [no=" + no + ", fecha_creacion=" + fecha_creacion + ", fecha_administrador="
				+ fecha_administrador + ", referencia=" + referencia + ", num_agente=" + num_agente + ", nombre_agente="
				+ nombre_agente + ", cve_usu_ecc=" + cve_usu_ecc + ", nombre_ecc=" + nombre_ecc + ", num_cli=" + num_cli
				+ ", nombre_cliente=" + nombre_cliente + ", cve_banco=" + cve_banco + ", nombre_banco=" + nombre_banco
				+ ", importe=" + importe + ", folio_caja=" + folio_caja + ", folio_caja_cheque_nominativo="
				+ folio_caja_cheque_nominativo + ", ficha_deposito=" + ficha_deposito + ", id_estatus=" + id_estatus
				+ ", descripcion_estatus=" + descripcion_estatus + ", fecha_pago=" + fecha_pago
				+ ", descripcion_cancelacion=" + descripcion_cancelacion + ", id_tipo_ingreso=" + id_tipo_ingreso + "]";
	}
}
