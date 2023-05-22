package cdo.Datos;

import java.io.Serializable;
import java.math.BigDecimal;

public class EncabezadoOtroIngreso implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private String uname;
	private int folio_caja;
	private BigDecimal importe;
	private int cve_forma_pago;
	private int cve_banco;
	private int cve_banco_deposito;
	private String  cve_usu;
	private String fecha;
	private int folio_ingreso;
	private int tipo_ingreso;
	private int folio_fisico;
	private String referencia;
		
	public EncabezadoOtroIngreso() {
		super();
	}

	public EncabezadoOtroIngreso(String uname, int folio_caja, BigDecimal importe, int cve_forma_pago, int cve_banco,
			int cve_banco_deposito, String cve_usu, String fecha, int folio_ingreso, int tipo_ingreso, int folio_fisico,
			String referencia) {
		super();
		this.uname = uname;
		this.folio_caja = folio_caja;
		this.importe = importe;
		this.cve_forma_pago = cve_forma_pago;
		this.cve_banco = cve_banco;
		this.cve_banco_deposito = cve_banco_deposito;
		this.cve_usu = cve_usu;
		this.fecha = fecha;
		this.folio_ingreso = folio_ingreso;
		this.tipo_ingreso = tipo_ingreso;
		this.folio_fisico = folio_fisico;
		this.referencia = referencia;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public int getFolio_caja() {
		return folio_caja;
	}

	public void setFolio_caja(int folio_caja) {
		this.folio_caja = folio_caja;
	}

	public BigDecimal getImporte() {
		return importe;
	}

	public void setImporte(BigDecimal importe) {
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

	public String getCve_usu() {
		return cve_usu;
	}

	public void setCve_usu(String cve_usu) {
		this.cve_usu = cve_usu;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public int getFolio_ingreso() {
		return folio_ingreso;
	}

	public void setFolio_ingreso(int folio_ingreso) {
		this.folio_ingreso = folio_ingreso;
	}

	public int getTipo_ingreso() {
		return tipo_ingreso;
	}

	public void setTipo_ingreso(int tipo_ingreso) {
		this.tipo_ingreso = tipo_ingreso;
	}

	public int getFolio_fisico() {
		return folio_fisico;
	}

	public void setFolio_fisico(int folio_fisico) {
		this.folio_fisico = folio_fisico;
	}

	public String getReferencia() {
		return referencia;
	}

	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "EncabezadoOtroIngreso [uname=" + uname + ", folio_caja=" + folio_caja + ", importe=" + importe
				+ ", cve_forma_pago=" + cve_forma_pago + ", cve_banco=" + cve_banco + ", cve_banco_deposito="
				+ cve_banco_deposito + ", cve_usu=" + cve_usu + ", fecha=" + fecha + ", folio_ingreso=" + folio_ingreso
				+ ", tipo_ingreso=" + tipo_ingreso + ", folio_fisico=" + folio_fisico + ", referencia=" + referencia
				+ "]";
	}
}
