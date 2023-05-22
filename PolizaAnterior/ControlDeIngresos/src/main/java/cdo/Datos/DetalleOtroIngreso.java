package cdo.Datos;

import java.io.Serializable;
import java.math.BigDecimal;

public class DetalleOtroIngreso implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String uname;
	private int folio_caja;
	private int id_otros_ingresos;
	private String otros_ingresos;
	private int cantidad;
	private int kilos;
	private BigDecimal importe;
	private int cve_forma_pago;
	private String forma_pago;
	private int cve_banco;
	private String banco;		
	private BigDecimal precio;
	
	
	public DetalleOtroIngreso() {
		super();
	}


	public DetalleOtroIngreso(String uname, int folio_caja, int id_otros_ingresos, String otros_ingresos, int cantidad,
			int kilos, BigDecimal importe, int cve_forma_pago, String forma_pago, int cve_banco, String banco,
			BigDecimal precio) {
		super();
		this.uname = uname;
		this.folio_caja = folio_caja;
		this.id_otros_ingresos = id_otros_ingresos;
		this.otros_ingresos = otros_ingresos;
		this.cantidad = cantidad;
		this.kilos = kilos;
		this.importe = importe;
		this.cve_forma_pago = cve_forma_pago;
		this.forma_pago = forma_pago;
		this.cve_banco = cve_banco;
		this.banco = banco;
		this.precio = precio;
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


	public int getId_otros_ingresos() {
		return id_otros_ingresos;
	}


	public void setId_otros_ingresos(int id_otros_ingresos) {
		this.id_otros_ingresos = id_otros_ingresos;
	}


	public String getOtros_ingresos() {
		return otros_ingresos;
	}


	public void setOtros_ingresos(String otros_ingresos) {
		this.otros_ingresos = otros_ingresos;
	}


	public int getCantidad() {
		return cantidad;
	}


	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}


	public int getKilos() {
		return kilos;
	}


	public void setKilos(int kilos) {
		this.kilos = kilos;
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


	public String getForma_pago() {
		return forma_pago;
	}


	public void setForma_pago(String forma_pago) {
		this.forma_pago = forma_pago;
	}


	public int getCve_banco() {
		return cve_banco;
	}


	public void setCve_banco(int cve_banco) {
		this.cve_banco = cve_banco;
	}


	public String getBanco() {
		return banco;
	}


	public void setBanco(String banco) {
		this.banco = banco;
	}


	public BigDecimal getPrecio() {
		return precio;
	}


	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	@Override
	public String toString() {
		return "DetalleOtroIngreso [uname=" + uname + ", folio_caja=" + folio_caja + ", id_otros_ingresos="
				+ id_otros_ingresos + ", otros_ingresos=" + otros_ingresos + ", cantidad=" + cantidad + ", kilos="
				+ kilos + ", importe=" + importe + ", cve_forma_pago=" + cve_forma_pago + ", forma_pago=" + forma_pago
				+ ", cve_banco=" + cve_banco + ", banco=" + banco + ", precio=" + precio + "]";
	}
}
