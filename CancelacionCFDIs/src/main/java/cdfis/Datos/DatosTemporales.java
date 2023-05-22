package cdfis.Datos;

import java.io.Serializable;

@SuppressWarnings("serial")
public class DatosTemporales implements Serializable
{

		String cdo;
		String tipodocumento;
		String factura;
		String documentoacancelar;
		String referencia;
		String av;
		String cte;
		String nombre;
		String razonocial;
		String fechadocumento;
		String importe;
		String uuid;
		String cancelado;
		String cuenta;
		String usuario;
		String password;
		public DatosTemporales() {
			super();
			// TODO Auto-generated constructor stub
		}
		public DatosTemporales(String cdo, String tipodocumento, String factura, String documentoacancelar,
				String referencia, String av, String cte, String nombre, String razonocial, String fechadocumento,
				String importe, String uuid, String cancelado, String cuenta, String usuario, String password) {
			super();
			this.cdo = cdo;
			this.tipodocumento = tipodocumento;
			this.factura = factura;
			this.documentoacancelar = documentoacancelar;
			this.referencia = referencia;
			this.av = av;
			this.cte = cte;
			this.nombre = nombre;
			this.razonocial = razonocial;
			this.fechadocumento = fechadocumento;
			this.importe = importe;
			this.uuid = uuid;
			this.cancelado = cancelado;
			this.cuenta = cuenta;
			this.usuario = usuario;
			this.password = password;
		}
		public String getCdo() {
			return cdo;
		}
		public void setCdo(String cdo) {
			this.cdo = cdo;
		}
		public String getTipodocumento() {
			return tipodocumento;
		}
		public void setTipodocumento(String tipodocumento) {
			this.tipodocumento = tipodocumento;
		}
		public String getFactura() {
			return factura;
		}
		public void setFactura(String factura) {
			this.factura = factura;
		}
		public String getDocumentoacancelar() {
			return documentoacancelar;
		}
		public void setDocumentoacancelar(String documentoacancelar) {
			this.documentoacancelar = documentoacancelar;
		}
		public String getReferencia() {
			return referencia;
		}
		public void setReferencia(String referencia) {
			this.referencia = referencia;
		}
		public String getAv() {
			return av;
		}
		public void setAv(String av) {
			this.av = av;
		}
		public String getCte() {
			return cte;
		}
		public void setCte(String cte) {
			this.cte = cte;
		}
		public String getNombre() {
			return nombre;
		}
		public void setNombre(String nombre) {
			this.nombre = nombre;
		}
		public String getRazonocial() {
			return razonocial;
		}
		public void setRazonocial(String razonocial) {
			this.razonocial = razonocial;
		}
		public String getFechadocumento() {
			return fechadocumento;
		}
		public void setFechadocumento(String fechadocumento) {
			this.fechadocumento = fechadocumento;
		}
		public String getImporte() {
			return importe;
		}
		public void setImporte(String importe) {
			this.importe = importe;
		}
		public String getUuid() {
			return uuid;
		}
		public void setUuid(String uuid) {
			this.uuid = uuid;
		}
		public String getCancelado() {
			return cancelado;
		}
		public void setCancelado(String cancelado) {
			this.cancelado = cancelado;
		}
		public String getCuenta() {
			return cuenta;
		}
		public void setCuenta(String cuenta) {
			this.cuenta = cuenta;
		}
		public String getUsuario() {
			return usuario;
		}
		public void setUsuario(String usuario) {
			this.usuario = usuario;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		@Override
		public String toString() {
			return "DatosTemporales [cdo=" + cdo + ", tipodocumento=" + tipodocumento + ", factura=" + factura
					+ ", documentoacancelar=" + documentoacancelar + ", referencia=" + referencia + ", av=" + av
					+ ", cte=" + cte + ", nombre=" + nombre + ", razonocial=" + razonocial + ", fechadocumento="
					+ fechadocumento + ", importe=" + importe + ", uuid=" + uuid + ", cancelado=" + cancelado
					+ ", cuenta=" + cuenta + ", usuario=" + usuario + ", password=" + password + "]";
		}
		
		
		
}
