package cdo.Datos;

import java.io.Serializable;

public class Linea_Bancaria_Azteca implements Serializable {	

	private static final long serialVersionUID = 1L;

	private boolean checked ;
	private int id_linea_bancaria_azteca;
	private String uname_azteca ;
	private int cve_banco_azteca ;
	private String cve_usu_azteca;
	private String fecha_pro_azteca ;
	private String cve_usu_cr_azteca ;
	private String fecha_aplicacion_azteca;
	private String sucursal_operante_azteca ;
	private String referencia_interna_azteca;
	private String referencia_01_azteca ;
	private String referencia_02_azteca;
	private String referencia_03_azteca ;
	private String referencia_04_azteca;
	private String importe_movimiento_azteca ;
	private int id_estatus_azteca ;
	private String estatus_azteca ;
	private String nombre_usu_azteca;
	private int id_tipo_linea_azteca ;
	private String nombre_tipo_azteca ;
	private String num_cliente_azteca;
	private String nombre_cliente_azteca;
	private String num_agente_azteca;
	private String nombre_agente_azteca;
	
	
	public Linea_Bancaria_Azteca() {
		super();
	}


	public Linea_Bancaria_Azteca(boolean checked, int id_linea_bancaria_azteca, String uname_azteca,
			int cve_banco_azteca, String cve_usu_azteca, String fecha_pro_azteca, String cve_usu_cr_azteca,
			String fecha_aplicacion_azteca, String sucursal_operante_azteca, String referencia_interna_azteca,
			String referencia_01_azteca, String referencia_02_azteca, String referencia_03_azteca,
			String referencia_04_azteca, String importe_movimiento_azteca, int id_estatus_azteca, String estatus_azteca,
			String nombre_usu_azteca, int id_tipo_linea_azteca, String nombre_tipo_azteca, String num_cliente_azteca,
			String nombre_cliente_azteca, String num_agente_azteca, String nombre_agente_azteca) {
		super();
		this.checked = checked;
		this.id_linea_bancaria_azteca = id_linea_bancaria_azteca;
		this.uname_azteca = uname_azteca;
		this.cve_banco_azteca = cve_banco_azteca;
		this.cve_usu_azteca = cve_usu_azteca;
		this.fecha_pro_azteca = fecha_pro_azteca;
		this.cve_usu_cr_azteca = cve_usu_cr_azteca;
		this.fecha_aplicacion_azteca = fecha_aplicacion_azteca;
		this.sucursal_operante_azteca = sucursal_operante_azteca;
		this.referencia_interna_azteca = referencia_interna_azteca;
		this.referencia_01_azteca = referencia_01_azteca;
		this.referencia_02_azteca = referencia_02_azteca;
		this.referencia_03_azteca = referencia_03_azteca;
		this.referencia_04_azteca = referencia_04_azteca;
		this.importe_movimiento_azteca = importe_movimiento_azteca;
		this.id_estatus_azteca = id_estatus_azteca;
		this.estatus_azteca = estatus_azteca;
		this.nombre_usu_azteca = nombre_usu_azteca;
		this.id_tipo_linea_azteca = id_tipo_linea_azteca;
		this.nombre_tipo_azteca = nombre_tipo_azteca;
		this.num_cliente_azteca = num_cliente_azteca;
		this.nombre_cliente_azteca = nombre_cliente_azteca;
		this.num_agente_azteca = num_agente_azteca;
		this.nombre_agente_azteca = nombre_agente_azteca;
	}


	public boolean isChecked() {
		return checked;
	}


	public void setChecked(boolean checked) {
		this.checked = checked;
	}


	public int getId_linea_bancaria_azteca() {
		return id_linea_bancaria_azteca;
	}


	public void setId_linea_bancaria_azteca(int id_linea_bancaria_azteca) {
		this.id_linea_bancaria_azteca = id_linea_bancaria_azteca;
	}


	public String getUname_azteca() {
		return uname_azteca;
	}


	public void setUname_azteca(String uname_azteca) {
		this.uname_azteca = uname_azteca;
	}


	public int getCve_banco_azteca() {
		return cve_banco_azteca;
	}


	public void setCve_banco_azteca(int cve_banco_azteca) {
		this.cve_banco_azteca = cve_banco_azteca;
	}


	public String getCve_usu_azteca() {
		return cve_usu_azteca;
	}


	public void setCve_usu_azteca(String cve_usu_azteca) {
		this.cve_usu_azteca = cve_usu_azteca;
	}


	public String getFecha_pro_azteca() {
		return fecha_pro_azteca;
	}


	public void setFecha_pro_azteca(String fecha_pro_azteca) {
		this.fecha_pro_azteca = fecha_pro_azteca;
	}


	public String getCve_usu_cr_azteca() {
		return cve_usu_cr_azteca;
	}


	public void setCve_usu_cr_azteca(String cve_usu_cr_azteca) {
		this.cve_usu_cr_azteca = cve_usu_cr_azteca;
	}


	public String getFecha_aplicacion_azteca() {
		return fecha_aplicacion_azteca;
	}


	public void setFecha_aplicacion_azteca(String fecha_aplicacion_azteca) {
		this.fecha_aplicacion_azteca = fecha_aplicacion_azteca;
	}


	public String getSucursal_operante_azteca() {
		return sucursal_operante_azteca;
	}


	public void setSucursal_operante_azteca(String sucursal_operante_azteca) {
		this.sucursal_operante_azteca = sucursal_operante_azteca;
	}


	public String getReferencia_interna_azteca() {
		return referencia_interna_azteca;
	}


	public void setReferencia_interna_azteca(String referencia_interna_azteca) {
		this.referencia_interna_azteca = referencia_interna_azteca;
	}


	public String getReferencia_01_azteca() {
		return referencia_01_azteca;
	}


	public void setReferencia_01_azteca(String referencia_01_azteca) {
		this.referencia_01_azteca = referencia_01_azteca;
	}


	public String getReferencia_02_azteca() {
		return referencia_02_azteca;
	}


	public void setReferencia_02_azteca(String referencia_02_azteca) {
		this.referencia_02_azteca = referencia_02_azteca;
	}


	public String getReferencia_03_azteca() {
		return referencia_03_azteca;
	}


	public void setReferencia_03_azteca(String referencia_03_azteca) {
		this.referencia_03_azteca = referencia_03_azteca;
	}


	public String getReferencia_04_azteca() {
		return referencia_04_azteca;
	}


	public void setReferencia_04_azteca(String referencia_04_azteca) {
		this.referencia_04_azteca = referencia_04_azteca;
	}


	public String getImporte_movimiento_azteca() {
		return importe_movimiento_azteca;
	}


	public void setImporte_movimiento_azteca(String importe_movimiento_azteca) {
		this.importe_movimiento_azteca = importe_movimiento_azteca;
	}


	public int getId_estatus_azteca() {
		return id_estatus_azteca;
	}


	public void setId_estatus_azteca(int id_estatus_azteca) {
		this.id_estatus_azteca = id_estatus_azteca;
	}


	public String getEstatus_azteca() {
		return estatus_azteca;
	}


	public void setEstatus_azteca(String estatus_azteca) {
		this.estatus_azteca = estatus_azteca;
	}


	public String getNombre_usu_azteca() {
		return nombre_usu_azteca;
	}


	public void setNombre_usu_azteca(String nombre_usu_azteca) {
		this.nombre_usu_azteca = nombre_usu_azteca;
	}


	public int getId_tipo_linea_azteca() {
		return id_tipo_linea_azteca;
	}


	public void setId_tipo_linea_azteca(int id_tipo_linea_azteca) {
		this.id_tipo_linea_azteca = id_tipo_linea_azteca;
	}


	public String getNombre_tipo_azteca() {
		return nombre_tipo_azteca;
	}


	public void setNombre_tipo_azteca(String nombre_tipo_azteca) {
		this.nombre_tipo_azteca = nombre_tipo_azteca;
	}


	public String getNum_cliente_azteca() {
		return num_cliente_azteca;
	}


	public void setNum_cliente_azteca(String num_cliente_azteca) {
		this.num_cliente_azteca = num_cliente_azteca;
	}


	public String getNombre_cliente_azteca() {
		return nombre_cliente_azteca;
	}


	public void setNombre_cliente_azteca(String nombre_cliente_azteca) {
		this.nombre_cliente_azteca = nombre_cliente_azteca;
	}


	public String getNum_agente_azteca() {
		return num_agente_azteca;
	}


	public void setNum_agente_azteca(String num_agente_azteca) {
		this.num_agente_azteca = num_agente_azteca;
	}


	public String getNombre_agente_azteca() {
		return nombre_agente_azteca;
	}


	public void setNombre_agente_azteca(String nombre_agente_azteca) {
		this.nombre_agente_azteca = nombre_agente_azteca;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	@Override
	public String toString() {
		return "Linea_Bancaria_Azteca [checked=" + checked + ", id_linea_bancaria_azteca=" + id_linea_bancaria_azteca
				+ ", uname_azteca=" + uname_azteca + ", cve_banco_azteca=" + cve_banco_azteca + ", cve_usu_azteca="
				+ cve_usu_azteca + ", fecha_pro_azteca=" + fecha_pro_azteca + ", cve_usu_cr_azteca=" + cve_usu_cr_azteca
				+ ", fecha_aplicacion_azteca=" + fecha_aplicacion_azteca + ", sucursal_operante_azteca="
				+ sucursal_operante_azteca + ", referencia_interna_azteca=" + referencia_interna_azteca
				+ ", referencia_01_azteca=" + referencia_01_azteca + ", referencia_02_azteca=" + referencia_02_azteca
				+ ", referencia_03_azteca=" + referencia_03_azteca + ", referencia_04_azteca=" + referencia_04_azteca
				+ ", importe_movimiento_azteca=" + importe_movimiento_azteca + ", id_estatus_azteca="
				+ id_estatus_azteca + ", estatus_azteca=" + estatus_azteca + ", nombre_usu_azteca=" + nombre_usu_azteca
				+ ", id_tipo_linea_azteca=" + id_tipo_linea_azteca + ", nombre_tipo_azteca=" + nombre_tipo_azteca
				+ ", num_cliente_azteca=" + num_cliente_azteca + ", nombre_cliente_azteca=" + nombre_cliente_azteca
				+ ", num_agente_azteca=" + num_agente_azteca + ", nombre_agente_azteca=" + nombre_agente_azteca + "]";
	}
}

