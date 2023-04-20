package cdo.Datos;

import java.io.Serializable;

public class Linea_Bancaria_Banamex implements Serializable {	

	private static final long serialVersionUID = 1L;

	private boolean checked ;
	private int id_linea_bancaria_banamex ;
	private String uname_banamex ;
	private int cve_banco_banamex ;
	private String cve_usu_banamex ;
	private String fecha_pro_banamex ;
	private String cve_usu_cr_banamex;
	private String fecha_banamex;
	private String numero_cuenta_int_banamex ;
	private String descripcion_banamex;
	private String cve_movimiento_banamex;
	private String sucursal_banamex ;
	private String autorizacion_banamex ;
	private String ordenante_banamex ;
	private String banco_emisor_banamex ;
	private String referencia_numerica_banamex ;
	private String referencia_alfanumerica_banamex;
	private String importe_banamex ;
	private int id_estatus_banamex ;
	private String estatus_banamex ;
	private String nombre_usu_banamex;
	private int id_tipo_linea_banamex ;
	private String nombre_tipo_linea_banamex ;
	private String num_cliente_banamex;
	private String nombre_cliente_banamex;
	private String num_agente_banamex;
	private String nombre_agente_banamex;
	
	public Linea_Bancaria_Banamex() {
		super();
	}

	public Linea_Bancaria_Banamex(boolean checked, int id_linea_bancaria_banamex, String uname_banamex,
			int cve_banco_banamex, String cve_usu_banamex, String fecha_pro_banamex, String cve_usu_cr_banamex,
			String fecha_banamex, String numero_cuenta_int_banamex, String descripcion_banamex,
			String cve_movimiento_banamex, String sucursal_banamex, String autorizacion_banamex,
			String ordenante_banamex, String banco_emisor_banamex, String referencia_numerica_banamex,
			String referencia_alfanumerica_banamex, String importe_banamex, int id_estatus_banamex,
			String estatus_banamex, String nombre_usu_banamex, int id_tipo_linea_banamex,
			String nombre_tipo_linea_banamex, String num_cliente_banamex, String nombre_cliente_banamex,
			String num_agente_banamex, String nombre_agente_banamex) {
		super();
		this.checked = checked;
		this.id_linea_bancaria_banamex = id_linea_bancaria_banamex;
		this.uname_banamex = uname_banamex;
		this.cve_banco_banamex = cve_banco_banamex;
		this.cve_usu_banamex = cve_usu_banamex;
		this.fecha_pro_banamex = fecha_pro_banamex;
		this.cve_usu_cr_banamex = cve_usu_cr_banamex;
		this.fecha_banamex = fecha_banamex;
		this.numero_cuenta_int_banamex = numero_cuenta_int_banamex;
		this.descripcion_banamex = descripcion_banamex;
		this.cve_movimiento_banamex = cve_movimiento_banamex;
		this.sucursal_banamex = sucursal_banamex;
		this.autorizacion_banamex = autorizacion_banamex;
		this.ordenante_banamex = ordenante_banamex;
		this.banco_emisor_banamex = banco_emisor_banamex;
		this.referencia_numerica_banamex = referencia_numerica_banamex;
		this.referencia_alfanumerica_banamex = referencia_alfanumerica_banamex;
		this.importe_banamex = importe_banamex;
		this.id_estatus_banamex = id_estatus_banamex;
		this.estatus_banamex = estatus_banamex;
		this.nombre_usu_banamex = nombre_usu_banamex;
		this.id_tipo_linea_banamex = id_tipo_linea_banamex;
		this.nombre_tipo_linea_banamex = nombre_tipo_linea_banamex;
		this.num_cliente_banamex = num_cliente_banamex;
		this.nombre_cliente_banamex = nombre_cliente_banamex;
		this.num_agente_banamex = num_agente_banamex;
		this.nombre_agente_banamex = nombre_agente_banamex;
	}

	public boolean isChecked() {
		return checked;
	}

	public void setChecked(boolean checked) {
		this.checked = checked;
	}

	public int getId_linea_bancaria_banamex() {
		return id_linea_bancaria_banamex;
	}

	public void setId_linea_bancaria_banamex(int id_linea_bancaria_banamex) {
		this.id_linea_bancaria_banamex = id_linea_bancaria_banamex;
	}

	public String getUname_banamex() {
		return uname_banamex;
	}

	public void setUname_banamex(String uname_banamex) {
		this.uname_banamex = uname_banamex;
	}

	public int getCve_banco_banamex() {
		return cve_banco_banamex;
	}

	public void setCve_banco_banamex(int cve_banco_banamex) {
		this.cve_banco_banamex = cve_banco_banamex;
	}

	public String getCve_usu_banamex() {
		return cve_usu_banamex;
	}

	public void setCve_usu_banamex(String cve_usu_banamex) {
		this.cve_usu_banamex = cve_usu_banamex;
	}

	public String getFecha_pro_banamex() {
		return fecha_pro_banamex;
	}

	public void setFecha_pro_banamex(String fecha_pro_banamex) {
		this.fecha_pro_banamex = fecha_pro_banamex;
	}

	public String getCve_usu_cr_banamex() {
		return cve_usu_cr_banamex;
	}

	public void setCve_usu_cr_banamex(String cve_usu_cr_banamex) {
		this.cve_usu_cr_banamex = cve_usu_cr_banamex;
	}

	public String getFecha_banamex() {
		return fecha_banamex;
	}

	public void setFecha_banamex(String fecha_banamex) {
		this.fecha_banamex = fecha_banamex;
	}

	public String getNumero_cuenta_int_banamex() {
		return numero_cuenta_int_banamex;
	}

	public void setNumero_cuenta_int_banamex(String numero_cuenta_int_banamex) {
		this.numero_cuenta_int_banamex = numero_cuenta_int_banamex;
	}

	public String getDescripcion_banamex() {
		return descripcion_banamex;
	}

	public void setDescripcion_banamex(String descripcion_banamex) {
		this.descripcion_banamex = descripcion_banamex;
	}

	public String getCve_movimiento_banamex() {
		return cve_movimiento_banamex;
	}

	public void setCve_movimiento_banamex(String cve_movimiento_banamex) {
		this.cve_movimiento_banamex = cve_movimiento_banamex;
	}

	public String getSucursal_banamex() {
		return sucursal_banamex;
	}

	public void setSucursal_banamex(String sucursal_banamex) {
		this.sucursal_banamex = sucursal_banamex;
	}

	public String getAutorizacion_banamex() {
		return autorizacion_banamex;
	}

	public void setAutorizacion_banamex(String autorizacion_banamex) {
		this.autorizacion_banamex = autorizacion_banamex;
	}

	public String getOrdenante_banamex() {
		return ordenante_banamex;
	}

	public void setOrdenante_banamex(String ordenante_banamex) {
		this.ordenante_banamex = ordenante_banamex;
	}

	public String getBanco_emisor_banamex() {
		return banco_emisor_banamex;
	}

	public void setBanco_emisor_banamex(String banco_emisor_banamex) {
		this.banco_emisor_banamex = banco_emisor_banamex;
	}

	public String getReferencia_numerica_banamex() {
		return referencia_numerica_banamex;
	}

	public void setReferencia_numerica_banamex(String referencia_numerica_banamex) {
		this.referencia_numerica_banamex = referencia_numerica_banamex;
	}

	public String getReferencia_alfanumerica_banamex() {
		return referencia_alfanumerica_banamex;
	}

	public void setReferencia_alfanumerica_banamex(String referencia_alfanumerica_banamex) {
		this.referencia_alfanumerica_banamex = referencia_alfanumerica_banamex;
	}

	public String getImporte_banamex() {
		return importe_banamex;
	}

	public void setImporte_banamex(String importe_banamex) {
		this.importe_banamex = importe_banamex;
	}

	public int getId_estatus_banamex() {
		return id_estatus_banamex;
	}

	public void setId_estatus_banamex(int id_estatus_banamex) {
		this.id_estatus_banamex = id_estatus_banamex;
	}

	public String getEstatus_banamex() {
		return estatus_banamex;
	}

	public void setEstatus_banamex(String estatus_banamex) {
		this.estatus_banamex = estatus_banamex;
	}

	public String getNombre_usu_banamex() {
		return nombre_usu_banamex;
	}

	public void setNombre_usu_banamex(String nombre_usu_banamex) {
		this.nombre_usu_banamex = nombre_usu_banamex;
	}

	public int getId_tipo_linea_banamex() {
		return id_tipo_linea_banamex;
	}

	public void setId_tipo_linea_banamex(int id_tipo_linea_banamex) {
		this.id_tipo_linea_banamex = id_tipo_linea_banamex;
	}

	public String getNombre_tipo_linea_banamex() {
		return nombre_tipo_linea_banamex;
	}

	public void setNombre_tipo_linea_banamex(String nombre_tipo_linea_banamex) {
		this.nombre_tipo_linea_banamex = nombre_tipo_linea_banamex;
	}

	public String getNum_cliente_banamex() {
		return num_cliente_banamex;
	}

	public void setNum_cliente_banamex(String num_cliente_banamex) {
		this.num_cliente_banamex = num_cliente_banamex;
	}

	public String getNombre_cliente_banamex() {
		return nombre_cliente_banamex;
	}

	public void setNombre_cliente_banamex(String nombre_cliente_banamex) {
		this.nombre_cliente_banamex = nombre_cliente_banamex;
	}

	public String getNum_agente_banamex() {
		return num_agente_banamex;
	}

	public void setNum_agente_banamex(String num_agente_banamex) {
		this.num_agente_banamex = num_agente_banamex;
	}

	public String getNombre_agente_banamex() {
		return nombre_agente_banamex;
	}

	public void setNombre_agente_banamex(String nombre_agente_banamex) {
		this.nombre_agente_banamex = nombre_agente_banamex;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Linea_Bancaria_Banamex [checked=" + checked + ", id_linea_bancaria_banamex=" + id_linea_bancaria_banamex
				+ ", uname_banamex=" + uname_banamex + ", cve_banco_banamex=" + cve_banco_banamex + ", cve_usu_banamex="
				+ cve_usu_banamex + ", fecha_pro_banamex=" + fecha_pro_banamex + ", cve_usu_cr_banamex="
				+ cve_usu_cr_banamex + ", fecha_banamex=" + fecha_banamex + ", numero_cuenta_int_banamex="
				+ numero_cuenta_int_banamex + ", descripcion_banamex=" + descripcion_banamex
				+ ", cve_movimiento_banamex=" + cve_movimiento_banamex + ", sucursal_banamex=" + sucursal_banamex
				+ ", autorizacion_banamex=" + autorizacion_banamex + ", ordenante_banamex=" + ordenante_banamex
				+ ", banco_emisor_banamex=" + banco_emisor_banamex + ", referencia_numerica_banamex="
				+ referencia_numerica_banamex + ", referencia_alfanumerica_banamex=" + referencia_alfanumerica_banamex
				+ ", importe_banamex=" + importe_banamex + ", id_estatus_banamex=" + id_estatus_banamex
				+ ", estatus_banamex=" + estatus_banamex + ", nombre_usu_banamex=" + nombre_usu_banamex
				+ ", id_tipo_linea_banamex=" + id_tipo_linea_banamex + ", nombre_tipo_linea_banamex="
				+ nombre_tipo_linea_banamex + ", num_cliente_banamex=" + num_cliente_banamex
				+ ", nombre_cliente_banamex=" + nombre_cliente_banamex + ", num_agente_banamex=" + num_agente_banamex
				+ ", nombre_agente_banamex=" + nombre_agente_banamex + "]";
	}

}
