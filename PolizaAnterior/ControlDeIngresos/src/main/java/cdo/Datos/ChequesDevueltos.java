package cdo.Datos;

import java.io.Serializable;

public class ChequesDevueltos  implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String uname;
	private String uname_br;
	private int id_egreso;
	private int folio_caja;
	private int folio_documento;
	private double importe;
	private int cve_forma_pago;
	private int cve_banco;
	private int cve_banco_deposito;
	private String referencia_cheque;
	private String cve_usu;
	private String cve_usu_autoriza;
	private int folio_corte_caja;
	private int folio_panamericano;
	private int folio_poliza;
	private int numero_transferencia;
	private int cve_banco_transferencia;
	private int id_motivo_cheque_devuelto;
	private int id_status;
	private String fecha_pro;
	private String hora_pro;
	
	public ChequesDevueltos() {
		super();

	}
	public ChequesDevueltos(String uname, String uname_br, int id_egreso, int folio_caja, int folio_documento,
			double importe, int cve_forma_pago, int cve_banco, int cve_banco_deposito, String referencia_cheque,
			String cve_usu, String cve_usu_autoriza, int folio_corte_caja, int folio_panamericano, int folio_poliza,
			int numero_transferencia, int cve_banco_transferencia, int id_motivo_cheque_devuelto, int id_status,
			String fecha_pro, String hora_pro) {
		super();
		this.uname = uname;
		this.uname_br = uname_br;
		this.id_egreso = id_egreso;
		this.folio_caja = folio_caja;
		this.folio_documento = folio_documento;
		this.importe = importe;
		this.cve_forma_pago = cve_forma_pago;
		this.cve_banco = cve_banco;
		this.cve_banco_deposito = cve_banco_deposito;
		this.referencia_cheque = referencia_cheque;
		this.cve_usu = cve_usu;
		this.cve_usu_autoriza = cve_usu_autoriza;
		this.folio_corte_caja = folio_corte_caja;
		this.folio_panamericano = folio_panamericano;
		this.folio_poliza = folio_poliza;
		this.numero_transferencia = numero_transferencia;
		this.cve_banco_transferencia = cve_banco_transferencia;
		this.id_motivo_cheque_devuelto = id_motivo_cheque_devuelto;
		this.id_status = id_status;
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
	public int getId_egreso() {
		return id_egreso;
	}
	public void setId_egreso(int id_egreso) {
		this.id_egreso = id_egreso;
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
	public double getImporte() {
		return importe;
	}
	public void setImporte(double importe) {
		this.importe = importe;
	}
	public int getCve_forma_pago() {
		return cve_forma_pago;
	}
	public void setCve_forma_pago(int cve_forma_pago) {
		this.cve_forma_pago = cve_forma_pago;
	}
	public int getCve_banco() {
		return cve_banco;
	}
	public void setCve_banco(int cve_banco) {
		this.cve_banco = cve_banco;
	}
	public int getCve_banco_deposito() {
		return cve_banco_deposito;
	}
	public void setCve_banco_deposito(int cve_banco_deposito) {
		this.cve_banco_deposito = cve_banco_deposito;
	}
	public String getReferencia_cheque() {
		return referencia_cheque;
	}
	public void setReferencia_cheque(String referencia_cheque) {
		this.referencia_cheque = referencia_cheque;
	}
	public String getCve_usu() {
		return cve_usu;
	}
	public void setCve_usu(String cve_usu) {
		this.cve_usu = cve_usu;
	}
	public String getCve_usu_autoriza() {
		return cve_usu_autoriza;
	}
	public void setCve_usu_autoriza(String cve_usu_autoriza) {
		this.cve_usu_autoriza = cve_usu_autoriza;
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
	public int getNumero_transferencia() {
		return numero_transferencia;
	}
	public void setNumero_transferencia(int numero_transferencia) {
		this.numero_transferencia = numero_transferencia;
	}
	public int getCve_banco_transferencia() {
		return cve_banco_transferencia;
	}
	public void setCve_banco_transferencia(int cve_banco_transferencia) {
		this.cve_banco_transferencia = cve_banco_transferencia;
	}
	public int getId_motivo_cheque_devuelto() {
		return id_motivo_cheque_devuelto;
	}
	public void setId_motivo_cheque_devuelto(int id_motivo_cheque_devuelto) {
		this.id_motivo_cheque_devuelto = id_motivo_cheque_devuelto;
	}
	public int getId_status() {
		return id_status;
	}
	public void setId_status(int id_status) {
		this.id_status = id_status;
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
		return "ChequesDevueltos [uname=" + uname + ", uname_br=" + uname_br + ", id_egreso=" + id_egreso
				+ ", folio_caja=" + folio_caja + ", folio_documento=" + folio_documento + ", importe=" + importe
				+ ", cve_forma_pago=" + cve_forma_pago + ", cve_banco=" + cve_banco + ", cve_banco_deposito="
				+ cve_banco_deposito + ", referencia_cheque=" + referencia_cheque + ", cve_usu=" + cve_usu
				+ ", cve_usu_autoriza=" + cve_usu_autoriza + ", folio_corte_caja=" + folio_corte_caja
				+ ", folio_panamericano=" + folio_panamericano + ", folio_poliza=" + folio_poliza
				+ ", numero_transferencia=" + numero_transferencia + ", cve_banco_transferencia="
				+ cve_banco_transferencia + ", id_motivo_cheque_devuelto=" + id_motivo_cheque_devuelto + ", id_status="
				+ id_status + ", fecha_pro=" + fecha_pro + ", hora_pro=" + hora_pro + "]";
	}
	
}
