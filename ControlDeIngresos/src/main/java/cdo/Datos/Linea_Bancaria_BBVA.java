package cdo.Datos;

import java.io.Serializable;

public class Linea_Bancaria_BBVA implements Serializable {	

	private static final long serialVersionUID = 1L;
	
	private boolean checked ;
	private int id_linea_bancaria_bbva;
	private String uname_bbva;
	private int cve_banco_bbva;
	private String cve_usu_bbva;
	private String fecha_pro_bbva;
	private String cve_usu_cr_bbva;
	private String sucursal_bbva;
	private String fecha_operacion_bbva;
	private String codigo_bbva;
	private String referencia_bbva;
	private String referencia_ampliada_bbva;
	private String concepto_bbva;
	private String importe_bbva ;
	private int id_estatus_bbva ;
	private String estatus_bbva ;
	private String nombre_usu_bbva;
	private int id_tipo_linea_bbva ;
	private String nombre_tipo_bbva ;
	private String num_cliente_bbva;
	private String nombre_cliente_bbva;
	private String num_agente_bbva;
	private String nombre_agente_bbva;
	
	public Linea_Bancaria_BBVA() {
		super();
	}

	public Linea_Bancaria_BBVA(boolean checked, int id_linea_bancaria_bbva, String uname_bbva, int cve_banco_bbva,
			String cve_usu_bbva, String fecha_pro_bbva, String cve_usu_cr_bbva, String sucursal_bbva,
			String fecha_operacion_bbva, String codigo_bbva, String referencia_bbva, String referencia_ampliada_bbva,
			String concepto_bbva, String importe_bbva, int id_estatus_bbva, String estatus_bbva, String nombre_usu_bbva,
			int id_tipo_linea_bbva, String nombre_tipo_bbva, String num_cliente_bbva, String nombre_cliente_bbva,
			String num_agente_bbva, String nombre_agente_bbva) {
		super();
		this.checked = checked;
		this.id_linea_bancaria_bbva = id_linea_bancaria_bbva;
		this.uname_bbva = uname_bbva;
		this.cve_banco_bbva = cve_banco_bbva;
		this.cve_usu_bbva = cve_usu_bbva;
		this.fecha_pro_bbva = fecha_pro_bbva;
		this.cve_usu_cr_bbva = cve_usu_cr_bbva;
		this.sucursal_bbva = sucursal_bbva;
		this.fecha_operacion_bbva = fecha_operacion_bbva;
		this.codigo_bbva = codigo_bbva;
		this.referencia_bbva = referencia_bbva;
		this.referencia_ampliada_bbva = referencia_ampliada_bbva;
		this.concepto_bbva = concepto_bbva;
		this.importe_bbva = importe_bbva;
		this.id_estatus_bbva = id_estatus_bbva;
		this.estatus_bbva = estatus_bbva;
		this.nombre_usu_bbva = nombre_usu_bbva;
		this.id_tipo_linea_bbva = id_tipo_linea_bbva;
		this.nombre_tipo_bbva = nombre_tipo_bbva;
		this.num_cliente_bbva = num_cliente_bbva;
		this.nombre_cliente_bbva = nombre_cliente_bbva;
		this.num_agente_bbva = num_agente_bbva;
		this.nombre_agente_bbva = nombre_agente_bbva;
	}

	public boolean isChecked() {
		return checked;
	}

	public void setChecked(boolean checked) {
		this.checked = checked;
	}

	public int getId_linea_bancaria_bbva() {
		return id_linea_bancaria_bbva;
	}

	public void setId_linea_bancaria_bbva(int id_linea_bancaria_bbva) {
		this.id_linea_bancaria_bbva = id_linea_bancaria_bbva;
	}

	public String getUname_bbva() {
		return uname_bbva;
	}

	public void setUname_bbva(String uname_bbva) {
		this.uname_bbva = uname_bbva;
	}

	public int getCve_banco_bbva() {
		return cve_banco_bbva;
	}

	public void setCve_banco_bbva(int cve_banco_bbva) {
		this.cve_banco_bbva = cve_banco_bbva;
	}

	public String getCve_usu_bbva() {
		return cve_usu_bbva;
	}

	public void setCve_usu_bbva(String cve_usu_bbva) {
		this.cve_usu_bbva = cve_usu_bbva;
	}

	public String getFecha_pro_bbva() {
		return fecha_pro_bbva;
	}

	public void setFecha_pro_bbva(String fecha_pro_bbva) {
		this.fecha_pro_bbva = fecha_pro_bbva;
	}

	public String getCve_usu_cr_bbva() {
		return cve_usu_cr_bbva;
	}

	public void setCve_usu_cr_bbva(String cve_usu_cr_bbva) {
		this.cve_usu_cr_bbva = cve_usu_cr_bbva;
	}

	public String getSucursal_bbva() {
		return sucursal_bbva;
	}

	public void setSucursal_bbva(String sucursal_bbva) {
		this.sucursal_bbva = sucursal_bbva;
	}

	public String getFecha_operacion_bbva() {
		return fecha_operacion_bbva;
	}

	public void setFecha_operacion_bbva(String fecha_operacion_bbva) {
		this.fecha_operacion_bbva = fecha_operacion_bbva;
	}

	public String getCodigo_bbva() {
		return codigo_bbva;
	}

	public void setCodigo_bbva(String codigo_bbva) {
		this.codigo_bbva = codigo_bbva;
	}

	public String getReferencia_bbva() {
		return referencia_bbva;
	}

	public void setReferencia_bbva(String referencia_bbva) {
		this.referencia_bbva = referencia_bbva;
	}

	public String getReferencia_ampliada_bbva() {
		return referencia_ampliada_bbva;
	}

	public void setReferencia_ampliada_bbva(String referencia_ampliada_bbva) {
		this.referencia_ampliada_bbva = referencia_ampliada_bbva;
	}

	public String getConcepto_bbva() {
		return concepto_bbva;
	}

	public void setConcepto_bbva(String concepto_bbva) {
		this.concepto_bbva = concepto_bbva;
	}

	public String getImporte_bbva() {
		return importe_bbva;
	}

	public void setImporte_bbva(String importe_bbva) {
		this.importe_bbva = importe_bbva;
	}

	public int getId_estatus_bbva() {
		return id_estatus_bbva;
	}

	public void setId_estatus_bbva(int id_estatus_bbva) {
		this.id_estatus_bbva = id_estatus_bbva;
	}

	public String getEstatus_bbva() {
		return estatus_bbva;
	}

	public void setEstatus_bbva(String estatus_bbva) {
		this.estatus_bbva = estatus_bbva;
	}

	public String getNombre_usu_bbva() {
		return nombre_usu_bbva;
	}

	public void setNombre_usu_bbva(String nombre_usu_bbva) {
		this.nombre_usu_bbva = nombre_usu_bbva;
	}

	public int getId_tipo_linea_bbva() {
		return id_tipo_linea_bbva;
	}

	public void setId_tipo_linea_bbva(int id_tipo_linea_bbva) {
		this.id_tipo_linea_bbva = id_tipo_linea_bbva;
	}

	public String getNombre_tipo_bbva() {
		return nombre_tipo_bbva;
	}

	public void setNombre_tipo_bbva(String nombre_tipo_bbva) {
		this.nombre_tipo_bbva = nombre_tipo_bbva;
	}

	public String getNum_cliente_bbva() {
		return num_cliente_bbva;
	}

	public void setNum_cliente_bbva(String num_cliente_bbva) {
		this.num_cliente_bbva = num_cliente_bbva;
	}

	public String getNombre_cliente_bbva() {
		return nombre_cliente_bbva;
	}

	public void setNombre_cliente_bbva(String nombre_cliente_bbva) {
		this.nombre_cliente_bbva = nombre_cliente_bbva;
	}

	public String getNum_agente_bbva() {
		return num_agente_bbva;
	}

	public void setNum_agente_bbva(String num_agente_bbva) {
		this.num_agente_bbva = num_agente_bbva;
	}

	public String getNombre_agente_bbva() {
		return nombre_agente_bbva;
	}

	public void setNombre_agente_bbva(String nombre_agente_bbva) {
		this.nombre_agente_bbva = nombre_agente_bbva;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Linea_Bancaria_BBVA [checked=" + checked + ", id_linea_bancaria_bbva=" + id_linea_bancaria_bbva
				+ ", uname_bbva=" + uname_bbva + ", cve_banco_bbva=" + cve_banco_bbva + ", cve_usu_bbva=" + cve_usu_bbva
				+ ", fecha_pro_bbva=" + fecha_pro_bbva + ", cve_usu_cr_bbva=" + cve_usu_cr_bbva + ", sucursal_bbva="
				+ sucursal_bbva + ", fecha_operacion_bbva=" + fecha_operacion_bbva + ", codigo_bbva=" + codigo_bbva
				+ ", referencia_bbva=" + referencia_bbva + ", referencia_ampliada_bbva=" + referencia_ampliada_bbva
				+ ", concepto_bbva=" + concepto_bbva + ", importe_bbva=" + importe_bbva + ", id_estatus_bbva="
				+ id_estatus_bbva + ", estatus_bbva=" + estatus_bbva + ", nombre_usu_bbva=" + nombre_usu_bbva
				+ ", id_tipo_linea_bbva=" + id_tipo_linea_bbva + ", nombre_tipo_bbva=" + nombre_tipo_bbva
				+ ", num_cliente_bbva=" + num_cliente_bbva + ", nombre_cliente_bbva=" + nombre_cliente_bbva
				+ ", num_agente_bbva=" + num_agente_bbva + ", nombre_agente_bbva=" + nombre_agente_bbva + "]";
	}
}
