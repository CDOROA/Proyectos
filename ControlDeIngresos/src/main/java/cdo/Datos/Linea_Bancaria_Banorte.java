package cdo.Datos;

import java.io.Serializable;

public class Linea_Bancaria_Banorte implements Serializable {	

	private static final long serialVersionUID = 1L;
	
	private boolean checked ;
	private int id_linea_bancaria_banorte;
	private String uname_banorte;
	private int cve_banco_banorte;
	private String cve_usu_banorte ;
	private String fecha_pro_banorte ;
	private String cve_usu_cr_banorte ;
	private String numero_cuenta_banorte  ;
	private String fecha_operacion_banorte ;
	private String fecha_banorte  ;
	private String referencia_banorte  ;
	private String descripcion_banorte;
	private String cod_transaccion_banorte ;
	private String sucursal_banorte  ;
	private String depositos_banorte ;
	private String retiros_banorte ;
	private String saldo_banorte ;
	private String movimiento_banorte;
	private String descripcion_detallada_banorte ;
	private String cheque_banorte;
	private int id_estatus_banorte;
	private String estatus_banorte ;
	private String nombre_usu_banorte;
	private int id_tipo_linea_banorte ;
	private String nombre_tipo_banorte ;
	private String num_cliente_banorte;
	private String nombre_cliente_banorte;
	private String num_agente_banorte;	
	private String nombre_agente_banorte;
	
	
	public Linea_Bancaria_Banorte() {
		super();
	}


	public Linea_Bancaria_Banorte(boolean checked, int id_linea_bancaria_banorte, String uname_banorte,
			int cve_banco_banorte, String cve_usu_banorte, String fecha_pro_banorte, String cve_usu_cr_banorte,
			String numero_cuenta_banorte, String fecha_operacion_banorte, String fecha_banorte,
			String referencia_banorte, String descripcion_banorte, String cod_transaccion_banorte,
			String sucursal_banorte, String depositos_banorte, String retiros_banorte, String saldo_banorte,
			String movimiento_banorte, String descripcion_detallada_banorte, String cheque_banorte,
			int id_estatus_banorte, String estatus_banorte, String nombre_usu_banorte, int id_tipo_linea_banorte,
			String nombre_tipo_banorte, String num_cliente_banorte, String nombre_cliente_banorte,
			String num_agente_banorte, String nombre_agente_banorte) {
		super();
		this.checked = checked;
		this.id_linea_bancaria_banorte = id_linea_bancaria_banorte;
		this.uname_banorte = uname_banorte;
		this.cve_banco_banorte = cve_banco_banorte;
		this.cve_usu_banorte = cve_usu_banorte;
		this.fecha_pro_banorte = fecha_pro_banorte;
		this.cve_usu_cr_banorte = cve_usu_cr_banorte;
		this.numero_cuenta_banorte = numero_cuenta_banorte;
		this.fecha_operacion_banorte = fecha_operacion_banorte;
		this.fecha_banorte = fecha_banorte;
		this.referencia_banorte = referencia_banorte;
		this.descripcion_banorte = descripcion_banorte;
		this.cod_transaccion_banorte = cod_transaccion_banorte;
		this.sucursal_banorte = sucursal_banorte;
		this.depositos_banorte = depositos_banorte;
		this.retiros_banorte = retiros_banorte;
		this.saldo_banorte = saldo_banorte;
		this.movimiento_banorte = movimiento_banorte;
		this.descripcion_detallada_banorte = descripcion_detallada_banorte;
		this.cheque_banorte = cheque_banorte;
		this.id_estatus_banorte = id_estatus_banorte;
		this.estatus_banorte = estatus_banorte;
		this.nombre_usu_banorte = nombre_usu_banorte;
		this.id_tipo_linea_banorte = id_tipo_linea_banorte;
		this.nombre_tipo_banorte = nombre_tipo_banorte;
		this.num_cliente_banorte = num_cliente_banorte;
		this.nombre_cliente_banorte = nombre_cliente_banorte;
		this.num_agente_banorte = num_agente_banorte;
		this.nombre_agente_banorte = nombre_agente_banorte;
	}


	public boolean isChecked() {
		return checked;
	}


	public void setChecked(boolean checked) {
		this.checked = checked;
	}


	public int getId_linea_bancaria_banorte() {
		return id_linea_bancaria_banorte;
	}


	public void setId_linea_bancaria_banorte(int id_linea_bancaria_banorte) {
		this.id_linea_bancaria_banorte = id_linea_bancaria_banorte;
	}


	public String getUname_banorte() {
		return uname_banorte;
	}


	public void setUname_banorte(String uname_banorte) {
		this.uname_banorte = uname_banorte;
	}


	public int getCve_banco_banorte() {
		return cve_banco_banorte;
	}


	public void setCve_banco_banorte(int cve_banco_banorte) {
		this.cve_banco_banorte = cve_banco_banorte;
	}


	public String getCve_usu_banorte() {
		return cve_usu_banorte;
	}


	public void setCve_usu_banorte(String cve_usu_banorte) {
		this.cve_usu_banorte = cve_usu_banorte;
	}


	public String getFecha_pro_banorte() {
		return fecha_pro_banorte;
	}


	public void setFecha_pro_banorte(String fecha_pro_banorte) {
		this.fecha_pro_banorte = fecha_pro_banorte;
	}


	public String getCve_usu_cr_banorte() {
		return cve_usu_cr_banorte;
	}


	public void setCve_usu_cr_banorte(String cve_usu_cr_banorte) {
		this.cve_usu_cr_banorte = cve_usu_cr_banorte;
	}


	public String getNumero_cuenta_banorte() {
		return numero_cuenta_banorte;
	}


	public void setNumero_cuenta_banorte(String numero_cuenta_banorte) {
		this.numero_cuenta_banorte = numero_cuenta_banorte;
	}


	public String getFecha_operacion_banorte() {
		return fecha_operacion_banorte;
	}


	public void setFecha_operacion_banorte(String fecha_operacion_banorte) {
		this.fecha_operacion_banorte = fecha_operacion_banorte;
	}


	public String getFecha_banorte() {
		return fecha_banorte;
	}


	public void setFecha_banorte(String fecha_banorte) {
		this.fecha_banorte = fecha_banorte;
	}


	public String getReferencia_banorte() {
		return referencia_banorte;
	}


	public void setReferencia_banorte(String referencia_banorte) {
		this.referencia_banorte = referencia_banorte;
	}


	public String getDescripcion_banorte() {
		return descripcion_banorte;
	}


	public void setDescripcion_banorte(String descripcion_banorte) {
		this.descripcion_banorte = descripcion_banorte;
	}


	public String getCod_transaccion_banorte() {
		return cod_transaccion_banorte;
	}


	public void setCod_transaccion_banorte(String cod_transaccion_banorte) {
		this.cod_transaccion_banorte = cod_transaccion_banorte;
	}


	public String getSucursal_banorte() {
		return sucursal_banorte;
	}


	public void setSucursal_banorte(String sucursal_banorte) {
		this.sucursal_banorte = sucursal_banorte;
	}


	public String getDepositos_banorte() {
		return depositos_banorte;
	}


	public void setDepositos_banorte(String depositos_banorte) {
		this.depositos_banorte = depositos_banorte;
	}


	public String getRetiros_banorte() {
		return retiros_banorte;
	}


	public void setRetiros_banorte(String retiros_banorte) {
		this.retiros_banorte = retiros_banorte;
	}


	public String getSaldo_banorte() {
		return saldo_banorte;
	}


	public void setSaldo_banorte(String saldo_banorte) {
		this.saldo_banorte = saldo_banorte;
	}


	public String getMovimiento_banorte() {
		return movimiento_banorte;
	}


	public void setMovimiento_banorte(String movimiento_banorte) {
		this.movimiento_banorte = movimiento_banorte;
	}


	public String getDescripcion_detallada_banorte() {
		return descripcion_detallada_banorte;
	}


	public void setDescripcion_detallada_banorte(String descripcion_detallada_banorte) {
		this.descripcion_detallada_banorte = descripcion_detallada_banorte;
	}


	public String getCheque_banorte() {
		return cheque_banorte;
	}


	public void setCheque_banorte(String cheque_banorte) {
		this.cheque_banorte = cheque_banorte;
	}


	public int getId_estatus_banorte() {
		return id_estatus_banorte;
	}


	public void setId_estatus_banorte(int id_estatus_banorte) {
		this.id_estatus_banorte = id_estatus_banorte;
	}


	public String getEstatus_banorte() {
		return estatus_banorte;
	}


	public void setEstatus_banorte(String estatus_banorte) {
		this.estatus_banorte = estatus_banorte;
	}


	public String getNombre_usu_banorte() {
		return nombre_usu_banorte;
	}


	public void setNombre_usu_banorte(String nombre_usu_banorte) {
		this.nombre_usu_banorte = nombre_usu_banorte;
	}


	public int getId_tipo_linea_banorte() {
		return id_tipo_linea_banorte;
	}


	public void setId_tipo_linea_banorte(int id_tipo_linea_banorte) {
		this.id_tipo_linea_banorte = id_tipo_linea_banorte;
	}


	public String getNombre_tipo_banorte() {
		return nombre_tipo_banorte;
	}


	public void setNombre_tipo_banorte(String nombre_tipo_banorte) {
		this.nombre_tipo_banorte = nombre_tipo_banorte;
	}


	public String getNum_cliente_banorte() {
		return num_cliente_banorte;
	}


	public void setNum_cliente_banorte(String num_cliente_banorte) {
		this.num_cliente_banorte = num_cliente_banorte;
	}


	public String getNombre_cliente_banorte() {
		return nombre_cliente_banorte;
	}


	public void setNombre_cliente_banorte(String nombre_cliente_banorte) {
		this.nombre_cliente_banorte = nombre_cliente_banorte;
	}


	public String getNum_agente_banorte() {
		return num_agente_banorte;
	}


	public void setNum_agente_banorte(String num_agente_banorte) {
		this.num_agente_banorte = num_agente_banorte;
	}


	public String getNombre_agente_banorte() {
		return nombre_agente_banorte;
	}


	public void setNombre_agente_banorte(String nombre_agente_banorte) {
		this.nombre_agente_banorte = nombre_agente_banorte;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	@Override
	public String toString() {
		return "Linea_Bancaria_Banorte [checked=" + checked + ", id_linea_bancaria_banorte=" + id_linea_bancaria_banorte
				+ ", uname_banorte=" + uname_banorte + ", cve_banco_banorte=" + cve_banco_banorte + ", cve_usu_banorte="
				+ cve_usu_banorte + ", fecha_pro_banorte=" + fecha_pro_banorte + ", cve_usu_cr_banorte="
				+ cve_usu_cr_banorte + ", numero_cuenta_banorte=" + numero_cuenta_banorte + ", fecha_operacion_banorte="
				+ fecha_operacion_banorte + ", fecha_banorte=" + fecha_banorte + ", referencia_banorte="
				+ referencia_banorte + ", descripcion_banorte=" + descripcion_banorte + ", cod_transaccion_banorte="
				+ cod_transaccion_banorte + ", sucursal_banorte=" + sucursal_banorte + ", depositos_banorte="
				+ depositos_banorte + ", retiros_banorte=" + retiros_banorte + ", saldo_banorte=" + saldo_banorte
				+ ", movimiento_banorte=" + movimiento_banorte + ", descripcion_detallada_banorte="
				+ descripcion_detallada_banorte + ", cheque_banorte=" + cheque_banorte + ", id_estatus_banorte="
				+ id_estatus_banorte + ", estatus_banorte=" + estatus_banorte + ", nombre_usu_banorte="
				+ nombre_usu_banorte + ", id_tipo_linea_banorte=" + id_tipo_linea_banorte + ", nombre_tipo_banorte="
				+ nombre_tipo_banorte + ", num_cliente_banorte=" + num_cliente_banorte + ", nombre_cliente_banorte="
				+ nombre_cliente_banorte + ", num_agente_banorte=" + num_agente_banorte + ", nombre_agente_banorte="
				+ nombre_agente_banorte + "]";
	}
}
