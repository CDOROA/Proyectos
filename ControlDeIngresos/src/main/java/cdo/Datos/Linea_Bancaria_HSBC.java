package cdo.Datos;

import java.io.Serializable;

public class Linea_Bancaria_HSBC implements Serializable {	

	private static final long serialVersionUID = 1L;
	
	private boolean checked ;
	private int id_linea_bancaria_hsbc;
	private String uname_hsbc;
	private int cve_banco_hsbc ;
	private String cve_usu_hsbc ;
	private String fecha_pro_hsbc ;
	private String cve_usu_cr_hsbc ;
	private String fecha_valor_hsbc;
	private String referencia_banco_hsbc ;
	private String narrativa_hsbc ;
	private String referencia_cliente_hsbc ;
	private String importe_credito_hsbc ;
	private String importe_debito_hsbc ;
	private String saldo_hsbc ;
	private int id_estatus_hsbc;
	private String estatus_hsbc;
	private String nombre_usu_hsbc;
	private int id_tipo_linea_hsbc ;
	private String nombre_tipo_hsbc ;
	private String num_cliente_hsbc;
	private String nombre_cliente_hsbc;
	private String num_agente_hsbc;
	private String nombre_agente_hsbc;
	
	public Linea_Bancaria_HSBC() {
		super();
	}

	public Linea_Bancaria_HSBC(boolean checked, int id_linea_bancaria_hsbc, String uname_hsbc, int cve_banco_hsbc,
			String cve_usu_hsbc, String fecha_pro_hsbc, String cve_usu_cr_hsbc, String fecha_valor_hsbc,
			String referencia_banco_hsbc, String narrativa_hsbc, String referencia_cliente_hsbc,
			String importe_credito_hsbc, String importe_debito_hsbc, String saldo_hsbc, int id_estatus_hsbc,
			String estatus_hsbc, String nombre_usu_hsbc, int id_tipo_linea_hsbc, String nombre_tipo_hsbc,
			String num_cliente_hsbc, String nombre_cliente_hsbc, String num_agente_hsbc, String nombre_agente_hsbc) {
		super();
		this.checked = checked;
		this.id_linea_bancaria_hsbc = id_linea_bancaria_hsbc;
		this.uname_hsbc = uname_hsbc;
		this.cve_banco_hsbc = cve_banco_hsbc;
		this.cve_usu_hsbc = cve_usu_hsbc;
		this.fecha_pro_hsbc = fecha_pro_hsbc;
		this.cve_usu_cr_hsbc = cve_usu_cr_hsbc;
		this.fecha_valor_hsbc = fecha_valor_hsbc;
		this.referencia_banco_hsbc = referencia_banco_hsbc;
		this.narrativa_hsbc = narrativa_hsbc;
		this.referencia_cliente_hsbc = referencia_cliente_hsbc;
		this.importe_credito_hsbc = importe_credito_hsbc;
		this.importe_debito_hsbc = importe_debito_hsbc;
		this.saldo_hsbc = saldo_hsbc;
		this.id_estatus_hsbc = id_estatus_hsbc;
		this.estatus_hsbc = estatus_hsbc;
		this.nombre_usu_hsbc = nombre_usu_hsbc;
		this.id_tipo_linea_hsbc = id_tipo_linea_hsbc;
		this.nombre_tipo_hsbc = nombre_tipo_hsbc;
		this.num_cliente_hsbc = num_cliente_hsbc;
		this.nombre_cliente_hsbc = nombre_cliente_hsbc;
		this.num_agente_hsbc = num_agente_hsbc;
		this.nombre_agente_hsbc = nombre_agente_hsbc;
	}

	public boolean isChecked() {
		return checked;
	}

	public void setChecked(boolean checked) {
		this.checked = checked;
	}

	public int getId_linea_bancaria_hsbc() {
		return id_linea_bancaria_hsbc;
	}

	public void setId_linea_bancaria_hsbc(int id_linea_bancaria_hsbc) {
		this.id_linea_bancaria_hsbc = id_linea_bancaria_hsbc;
	}

	public String getUname_hsbc() {
		return uname_hsbc;
	}

	public void setUname_hsbc(String uname_hsbc) {
		this.uname_hsbc = uname_hsbc;
	}

	public int getCve_banco_hsbc() {
		return cve_banco_hsbc;
	}

	public void setCve_banco_hsbc(int cve_banco_hsbc) {
		this.cve_banco_hsbc = cve_banco_hsbc;
	}

	public String getCve_usu_hsbc() {
		return cve_usu_hsbc;
	}

	public void setCve_usu_hsbc(String cve_usu_hsbc) {
		this.cve_usu_hsbc = cve_usu_hsbc;
	}

	public String getFecha_pro_hsbc() {
		return fecha_pro_hsbc;
	}

	public void setFecha_pro_hsbc(String fecha_pro_hsbc) {
		this.fecha_pro_hsbc = fecha_pro_hsbc;
	}

	public String getCve_usu_cr_hsbc() {
		return cve_usu_cr_hsbc;
	}

	public void setCve_usu_cr_hsbc(String cve_usu_cr_hsbc) {
		this.cve_usu_cr_hsbc = cve_usu_cr_hsbc;
	}

	public String getFecha_valor_hsbc() {
		return fecha_valor_hsbc;
	}

	public void setFecha_valor_hsbc(String fecha_valor_hsbc) {
		this.fecha_valor_hsbc = fecha_valor_hsbc;
	}

	public String getReferencia_banco_hsbc() {
		return referencia_banco_hsbc;
	}

	public void setReferencia_banco_hsbc(String referencia_banco_hsbc) {
		this.referencia_banco_hsbc = referencia_banco_hsbc;
	}

	public String getNarrativa_hsbc() {
		return narrativa_hsbc;
	}

	public void setNarrativa_hsbc(String narrativa_hsbc) {
		this.narrativa_hsbc = narrativa_hsbc;
	}

	public String getReferencia_cliente_hsbc() {
		return referencia_cliente_hsbc;
	}

	public void setReferencia_cliente_hsbc(String referencia_cliente_hsbc) {
		this.referencia_cliente_hsbc = referencia_cliente_hsbc;
	}

	public String getImporte_credito_hsbc() {
		return importe_credito_hsbc;
	}

	public void setImporte_credito_hsbc(String importe_credito_hsbc) {
		this.importe_credito_hsbc = importe_credito_hsbc;
	}

	public String getImporte_debito_hsbc() {
		return importe_debito_hsbc;
	}

	public void setImporte_debito_hsbc(String importe_debito_hsbc) {
		this.importe_debito_hsbc = importe_debito_hsbc;
	}

	public String getSaldo_hsbc() {
		return saldo_hsbc;
	}

	public void setSaldo_hsbc(String saldo_hsbc) {
		this.saldo_hsbc = saldo_hsbc;
	}

	public int getId_estatus_hsbc() {
		return id_estatus_hsbc;
	}

	public void setId_estatus_hsbc(int id_estatus_hsbc) {
		this.id_estatus_hsbc = id_estatus_hsbc;
	}

	public String getEstatus_hsbc() {
		return estatus_hsbc;
	}

	public void setEstatus_hsbc(String estatus_hsbc) {
		this.estatus_hsbc = estatus_hsbc;
	}

	public String getNombre_usu_hsbc() {
		return nombre_usu_hsbc;
	}

	public void setNombre_usu_hsbc(String nombre_usu_hsbc) {
		this.nombre_usu_hsbc = nombre_usu_hsbc;
	}

	public int getId_tipo_linea_hsbc() {
		return id_tipo_linea_hsbc;
	}

	public void setId_tipo_linea_hsbc(int id_tipo_linea_hsbc) {
		this.id_tipo_linea_hsbc = id_tipo_linea_hsbc;
	}

	public String getNombre_tipo_hsbc() {
		return nombre_tipo_hsbc;
	}

	public void setNombre_tipo_hsbc(String nombre_tipo_hsbc) {
		this.nombre_tipo_hsbc = nombre_tipo_hsbc;
	}

	public String getNum_cliente_hsbc() {
		return num_cliente_hsbc;
	}

	public void setNum_cliente_hsbc(String num_cliente_hsbc) {
		this.num_cliente_hsbc = num_cliente_hsbc;
	}

	public String getNombre_cliente_hsbc() {
		return nombre_cliente_hsbc;
	}

	public void setNombre_cliente_hsbc(String nombre_cliente_hsbc) {
		this.nombre_cliente_hsbc = nombre_cliente_hsbc;
	}

	public String getNum_agente_hsbc() {
		return num_agente_hsbc;
	}

	public void setNum_agente_hsbc(String num_agente_hsbc) {
		this.num_agente_hsbc = num_agente_hsbc;
	}

	public String getNombre_agente_hsbc() {
		return nombre_agente_hsbc;
	}

	public void setNombre_agente_hsbc(String nombre_agente_hsbc) {
		this.nombre_agente_hsbc = nombre_agente_hsbc;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Linea_Bancaria_HSBC [checked=" + checked + ", id_linea_bancaria_hsbc=" + id_linea_bancaria_hsbc
				+ ", uname_hsbc=" + uname_hsbc + ", cve_banco_hsbc=" + cve_banco_hsbc + ", cve_usu_hsbc=" + cve_usu_hsbc
				+ ", fecha_pro_hsbc=" + fecha_pro_hsbc + ", cve_usu_cr_hsbc=" + cve_usu_cr_hsbc + ", fecha_valor_hsbc="
				+ fecha_valor_hsbc + ", referencia_banco_hsbc=" + referencia_banco_hsbc + ", narrativa_hsbc="
				+ narrativa_hsbc + ", referencia_cliente_hsbc=" + referencia_cliente_hsbc + ", importe_credito_hsbc="
				+ importe_credito_hsbc + ", importe_debito_hsbc=" + importe_debito_hsbc + ", saldo_hsbc=" + saldo_hsbc
				+ ", id_estatus_hsbc=" + id_estatus_hsbc + ", estatus_hsbc=" + estatus_hsbc + ", nombre_usu_hsbc="
				+ nombre_usu_hsbc + ", id_tipo_linea_hsbc=" + id_tipo_linea_hsbc + ", nombre_tipo_hsbc="
				+ nombre_tipo_hsbc + ", num_cliente_hsbc=" + num_cliente_hsbc + ", nombre_cliente_hsbc="
				+ nombre_cliente_hsbc + ", num_agente_hsbc=" + num_agente_hsbc + ", nombre_agente_hsbc="
				+ nombre_agente_hsbc + "]";
	}
}
