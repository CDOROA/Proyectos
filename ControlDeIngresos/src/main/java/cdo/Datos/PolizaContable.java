package cdo.Datos;

import java.io.Serializable;

public class PolizaContable  implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private String uname;
	private int num_cli_origen;
	private int num_cli_destino;
	private String fecha;
	private int id_transaccion_contable;
	private String descripcion_contable;
	private String tipo_transaccion;
	private int cve_tt;
	private String importe_bruto;
	private String iva;
	private String importe_total;
	int numero_diario;
	
	public PolizaContable() {
		super();
	}

	public PolizaContable(String uname, int num_cli_origen, int num_cli_destino, String fecha,
			int id_transaccion_contable, String descripcion_contable, String tipo_transaccion, int cve_tt,
			String importe_bruto, String iva, String importe_total, int numero_diario) {
		super();
		this.uname = uname;
		this.num_cli_origen = num_cli_origen;
		this.num_cli_destino = num_cli_destino;
		this.fecha = fecha;
		this.id_transaccion_contable = id_transaccion_contable;
		this.descripcion_contable = descripcion_contable;
		this.tipo_transaccion = tipo_transaccion;
		this.cve_tt = cve_tt;
		this.importe_bruto = importe_bruto;
		this.iva = iva;
		this.importe_total = importe_total;
		this.numero_diario = numero_diario;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public int getNum_cli_origen() {
		return num_cli_origen;
	}

	public void setNum_cli_origen(int num_cli_origen) {
		this.num_cli_origen = num_cli_origen;
	}

	public int getNum_cli_destino() {
		return num_cli_destino;
	}

	public void setNum_cli_destino(int num_cli_destino) {
		this.num_cli_destino = num_cli_destino;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public int getId_transaccion_contable() {
		return id_transaccion_contable;
	}

	public void setId_transaccion_contable(int id_transaccion_contable) {
		this.id_transaccion_contable = id_transaccion_contable;
	}

	public String getDescripcion_contable() {
		return descripcion_contable;
	}

	public void setDescripcion_contable(String descripcion_contable) {
		this.descripcion_contable = descripcion_contable;
	}

	public String getTipo_transaccion() {
		return tipo_transaccion;
	}

	public void setTipo_transaccion(String tipo_transaccion) {
		this.tipo_transaccion = tipo_transaccion;
	}

	public int getCve_tt() {
		return cve_tt;
	}

	public void setCve_tt(int cve_tt) {
		this.cve_tt = cve_tt;
	}

	public String getImporte_bruto() {
		return importe_bruto;
	}

	public void setImporte_bruto(String importe_bruto) {
		this.importe_bruto = importe_bruto;
	}

	public String getIva() {
		return iva;
	}

	public void setIva(String iva) {
		this.iva = iva;
	}

	public String getImporte_total() {
		return importe_total;
	}

	public void setImporte_total(String importe_total) {
		this.importe_total = importe_total;
	}

	public int getNumero_diario() {
		return numero_diario;
	}

	public void setNumero_diario(int numero_diario) {
		this.numero_diario = numero_diario;
	}

	@Override
	public String toString() {
		return "PolizaContable [uname=" + uname + ", num_cli_origen=" + num_cli_origen + ", num_cli_destino="
				+ num_cli_destino + ", fecha=" + fecha + ", id_transaccion_contable=" + id_transaccion_contable
				+ ", descripcion_contable=" + descripcion_contable + ", tipo_transaccion=" + tipo_transaccion
				+ ", cve_tt=" + cve_tt + ", importe_bruto=" + importe_bruto + ", iva=" + iva + ", importe_total="
				+ importe_total + ", numero_diario=" + numero_diario + "]";
	}
}
