package cdo.Datos;

import java.io.Serializable;

public class Ingresos implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String uname;
	private String uname_br;
	private int id_tipo_pago;
	private String nombre_pago;  
	private String folio_caja;
	private String cve_usu;
	private String nombre_usu;
	private String fecha_creacion; 
	private String fecha_pro;
	private int estatus;
	private String decripcion_Estatus;
	private String importe ;
	private String efectivo;
	private String cheque;
	private String tarjeta;
	private String debito;
	private String porfechado;
	private String transferencia;
	private String notaCredito;
	private String notaDevolucion;
	private int id_motivo_cancelacion;
	private String motivo_cancelacion;
	private String cve_usu_nota;
	private String observaciones_nota;
	private String documento_credito;
	private String documento_devolucion;
	private String folio_corte_caja;
	private String folio_panamericano;
	private String folio_poliza;
	private String hora_pro; 
	private String fecha_poliza;
	private String factura;
	private String importe_original;
	private String fecha_corte;
	private String hora_corte;
	private String fecha_caja;
	private String hora_caja;
	private String hora_creacion;
	
	public Ingresos() {
		super();
	}

	public Ingresos(String uname, String uname_br, int id_tipo_pago, String nombre_pago, String folio_caja,
			String cve_usu, String nombre_usu, String fecha_creacion, String fecha_pro, int estatus,
			String decripcion_Estatus, String importe, String efectivo, String cheque, String tarjeta, String debito,
			String porfechado, String transferencia, String notaCredito, String notaDevolucion,
			int id_motivo_cancelacion, String motivo_cancelacion, String cve_usu_nota, String observaciones_nota,
			String documento_credito, String documento_devolucion, String folio_corte_caja, String folio_panamericano,
			String folio_poliza, String hora_pro, String fecha_poliza, String factura, String importe_original,
			String fecha_corte, String hora_corte, String fecha_caja, String hora_caja, String hora_creacion) {
		super();
		this.uname = uname;
		this.uname_br = uname_br;
		this.id_tipo_pago = id_tipo_pago;
		this.nombre_pago = nombre_pago;
		this.folio_caja = folio_caja;
		this.cve_usu = cve_usu;
		this.nombre_usu = nombre_usu;
		this.fecha_creacion = fecha_creacion;
		this.fecha_pro = fecha_pro;
		this.estatus = estatus;
		this.decripcion_Estatus = decripcion_Estatus;
		this.importe = importe;
		this.efectivo = efectivo;
		this.cheque = cheque;
		this.tarjeta = tarjeta;
		this.debito = debito;
		this.porfechado = porfechado;
		this.transferencia = transferencia;
		this.notaCredito = notaCredito;
		this.notaDevolucion = notaDevolucion;
		this.id_motivo_cancelacion = id_motivo_cancelacion;
		this.motivo_cancelacion = motivo_cancelacion;
		this.cve_usu_nota = cve_usu_nota;
		this.observaciones_nota = observaciones_nota;
		this.documento_credito = documento_credito;
		this.documento_devolucion = documento_devolucion;
		this.folio_corte_caja = folio_corte_caja;
		this.folio_panamericano = folio_panamericano;
		this.folio_poliza = folio_poliza;
		this.hora_pro = hora_pro;
		this.fecha_poliza = fecha_poliza;
		this.factura = factura;
		this.importe_original = importe_original;
		this.fecha_corte = fecha_corte;
		this.hora_corte = hora_corte;
		this.fecha_caja = fecha_caja;
		this.hora_caja = hora_caja;
		this.hora_creacion = hora_creacion;
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

	public int getId_tipo_pago() {
		return id_tipo_pago;
	}

	public void setId_tipo_pago(int id_tipo_pago) {
		this.id_tipo_pago = id_tipo_pago;
	}

	public String getNombre_pago() {
		return nombre_pago;
	}

	public void setNombre_pago(String nombre_pago) {
		this.nombre_pago = nombre_pago;
	}

	public String getFolio_caja() {
		return folio_caja;
	}

	public void setFolio_caja(String folio_caja) {
		this.folio_caja = folio_caja;
	}

	public String getCve_usu() {
		return cve_usu;
	}

	public void setCve_usu(String cve_usu) {
		this.cve_usu = cve_usu;
	}

	public String getNombre_usu() {
		return nombre_usu;
	}

	public void setNombre_usu(String nombre_usu) {
		this.nombre_usu = nombre_usu;
	}

	public String getFecha_creacion() {
		return fecha_creacion;
	}

	public void setFecha_creacion(String fecha_creacion) {
		this.fecha_creacion = fecha_creacion;
	}

	public String getFecha_pro() {
		return fecha_pro;
	}

	public void setFecha_pro(String fecha_pro) {
		this.fecha_pro = fecha_pro;
	}

	public int getEstatus() {
		return estatus;
	}

	public void setEstatus(int estatus) {
		this.estatus = estatus;
	}

	public String getDecripcion_Estatus() {
		return decripcion_Estatus;
	}

	public void setDecripcion_Estatus(String decripcion_Estatus) {
		this.decripcion_Estatus = decripcion_Estatus;
	}

	public String getImporte() {
		return importe;
	}

	public void setImporte(String importe) {
		this.importe = importe;
	}

	public String getEfectivo() {
		return efectivo;
	}

	public void setEfectivo(String efectivo) {
		this.efectivo = efectivo;
	}

	public String getCheque() {
		return cheque;
	}

	public void setCheque(String cheque) {
		this.cheque = cheque;
	}

	public String getTarjeta() {
		return tarjeta;
	}

	public void setTarjeta(String tarjeta) {
		this.tarjeta = tarjeta;
	}

	public String getDebito() {
		return debito;
	}

	public void setDebito(String debito) {
		this.debito = debito;
	}

	public String getPorfechado() {
		return porfechado;
	}

	public void setPorfechado(String porfechado) {
		this.porfechado = porfechado;
	}

	public String getTransferencia() {
		return transferencia;
	}

	public void setTransferencia(String transferencia) {
		this.transferencia = transferencia;
	}

	public String getNotaCredito() {
		return notaCredito;
	}

	public void setNotaCredito(String notaCredito) {
		this.notaCredito = notaCredito;
	}

	public String getNotaDevolucion() {
		return notaDevolucion;
	}

	public void setNotaDevolucion(String notaDevolucion) {
		this.notaDevolucion = notaDevolucion;
	}

	public int getId_motivo_cancelacion() {
		return id_motivo_cancelacion;
	}

	public void setId_motivo_cancelacion(int id_motivo_cancelacion) {
		this.id_motivo_cancelacion = id_motivo_cancelacion;
	}

	public String getMotivo_cancelacion() {
		return motivo_cancelacion;
	}

	public void setMotivo_cancelacion(String motivo_cancelacion) {
		this.motivo_cancelacion = motivo_cancelacion;
	}

	public String getCve_usu_nota() {
		return cve_usu_nota;
	}

	public void setCve_usu_nota(String cve_usu_nota) {
		this.cve_usu_nota = cve_usu_nota;
	}

	public String getObservaciones_nota() {
		return observaciones_nota;
	}

	public void setObservaciones_nota(String observaciones_nota) {
		this.observaciones_nota = observaciones_nota;
	}

	public String getDocumento_credito() {
		return documento_credito;
	}

	public void setDocumento_credito(String documento_credito) {
		this.documento_credito = documento_credito;
	}

	public String getDocumento_devolucion() {
		return documento_devolucion;
	}

	public void setDocumento_devolucion(String documento_devolucion) {
		this.documento_devolucion = documento_devolucion;
	}

	public String getFolio_corte_caja() {
		return folio_corte_caja;
	}

	public void setFolio_corte_caja(String folio_corte_caja) {
		this.folio_corte_caja = folio_corte_caja;
	}

	public String getFolio_panamericano() {
		return folio_panamericano;
	}

	public void setFolio_panamericano(String folio_panamericano) {
		this.folio_panamericano = folio_panamericano;
	}

	public String getFolio_poliza() {
		return folio_poliza;
	}

	public void setFolio_poliza(String folio_poliza) {
		this.folio_poliza = folio_poliza;
	}

	public String getHora_pro() {
		return hora_pro;
	}

	public void setHora_pro(String hora_pro) {
		this.hora_pro = hora_pro;
	}

	public String getFecha_poliza() {
		return fecha_poliza;
	}

	public void setFecha_poliza(String fecha_poliza) {
		this.fecha_poliza = fecha_poliza;
	}

	public String getFactura() {
		return factura;
	}

	public void setFactura(String factura) {
		this.factura = factura;
	}

	public String getImporte_original() {
		return importe_original;
	}

	public void setImporte_original(String importe_original) {
		this.importe_original = importe_original;
	}

	public String getFecha_corte() {
		return fecha_corte;
	}

	public void setFecha_corte(String fecha_corte) {
		this.fecha_corte = fecha_corte;
	}

	public String getHora_corte() {
		return hora_corte;
	}

	public void setHora_corte(String hora_corte) {
		this.hora_corte = hora_corte;
	}

	public String getFecha_caja() {
		return fecha_caja;
	}

	public void setFecha_caja(String fecha_caja) {
		this.fecha_caja = fecha_caja;
	}

	public String getHora_caja() {
		return hora_caja;
	}

	public void setHora_caja(String hora_caja) {
		this.hora_caja = hora_caja;
	}

	public String getHora_creacion() {
		return hora_creacion;
	}

	public void setHora_creacion(String hora_creacion) {
		this.hora_creacion = hora_creacion;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Ingresos [uname=" + uname + ", uname_br=" + uname_br + ", id_tipo_pago=" + id_tipo_pago
				+ ", nombre_pago=" + nombre_pago + ", folio_caja=" + folio_caja + ", cve_usu=" + cve_usu
				+ ", nombre_usu=" + nombre_usu + ", fecha_creacion=" + fecha_creacion + ", fecha_pro=" + fecha_pro
				+ ", estatus=" + estatus + ", decripcion_Estatus=" + decripcion_Estatus + ", importe=" + importe
				+ ", efectivo=" + efectivo + ", cheque=" + cheque + ", tarjeta=" + tarjeta + ", debito=" + debito
				+ ", porfechado=" + porfechado + ", transferencia=" + transferencia + ", notaCredito=" + notaCredito
				+ ", notaDevolucion=" + notaDevolucion + ", id_motivo_cancelacion=" + id_motivo_cancelacion
				+ ", motivo_cancelacion=" + motivo_cancelacion + ", cve_usu_nota=" + cve_usu_nota
				+ ", observaciones_nota=" + observaciones_nota + ", documento_credito=" + documento_credito
				+ ", documento_devolucion=" + documento_devolucion + ", folio_corte_caja=" + folio_corte_caja
				+ ", folio_panamericano=" + folio_panamericano + ", folio_poliza=" + folio_poliza + ", hora_pro="
				+ hora_pro + ", fecha_poliza=" + fecha_poliza + ", factura=" + factura + ", importe_original="
				+ importe_original + ", fecha_corte=" + fecha_corte + ", hora_corte=" + hora_corte + ", fecha_caja="
				+ fecha_caja + ", hora_caja=" + hora_caja + ", hora_creacion=" + hora_creacion + "]";
	}
}
