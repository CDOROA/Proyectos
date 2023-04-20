package cdo.Datos;

import java.io.Serializable;
import java.sql.Time;

public class InfoCliente implements Serializable{

		private static final long serialVersionUID = 1L;
		private int cve_cliente;
		private String nombre_cliente;
		private String razon_social;
		private String rfc;
		private String saldo_total;
		private String commen_cliente;
		private String lincme_cliente;
		private String limite_credito;
		private int centro;
		private int num_agente;
		private String fecha_contrasena;				
		private String estatus;
		private String vigencia;
		private String letra_descuento;
		private String fac_descuento;
		private String imp_min_de_pedido;
		private String disponible_cte;	
				
		private String uname_bodega;
		private String cve_bodega;
		private String nombre_bodega;
		
		private String ruta_bodega;
		private String transporte_bodega;
		private String syf_bodega;
		private String cond_pago_bodega;
		private String vigencia_bodega;
		private String distancia_bodega;
		private String tipo_lf_bodega;
				
		private String uname_cdo;
		private int cve_cdo;		
		private String nombre_cdo;
		
		private String ruta_cdo;
		private String transporte_cdo;
		private String syf_cdo;
		private String cond_cdo;
		private String vigencia_cdo;
		private String distancia_cdo;
		private String tipo_lf_cdo;
		private int precioConDescuento;
		private String desglosaIva;
		private Time horaIni;
		private Time horaFin;
		private Time horaSabadoIni;
		private Time horaSabadoFin;
		
		private String colorBarra;
		private String colorLetra;
		private String referenciaBancaria;

		public int getCve_cliente() {
			return cve_cliente;
		}
		public void setCve_cliente(int cve_cliente) {
			this.cve_cliente = cve_cliente;
		}
		public String getNombre_cliente() {
			return nombre_cliente;
		}
		public void setNombre_cliente(String nombre_cliente) {
			this.nombre_cliente = nombre_cliente;
		}
		public String getRazon_social() {
			return razon_social;
		}
		public void setRazon_social(String razon_social) {
			this.razon_social = razon_social;
		}
		public String getRfc() {
			return rfc;
		}
		public void setRfc(String rfc) {
			this.rfc = rfc;
		}
		public String getSaldo_total() {
			return saldo_total;
		}
		public void setSaldo_total(String saldo_total) {
			this.saldo_total = saldo_total;
		}
		public String getCommen_cliente() {
			return commen_cliente;
		}
		public void setCommen_cliente(String commen_cliente) {
			this.commen_cliente = commen_cliente;
		}
		public String getLincme_cliente() {
			return lincme_cliente;
		}
		public void setLincme_cliente(String lincme_cliente) {
			this.lincme_cliente = lincme_cliente;
		}
		public String getLimite_credito() {
			return limite_credito;
		}
		public void setLimite_credito(String limite_credito) {
			this.limite_credito = limite_credito;
		}
		public int getCentro() {
			return centro;
		}
		public void setCentro(int centro) {
			this.centro = centro;
		}
		public int getNum_agente() {
			return num_agente;
		}
		public void setNum_agente(int num_agente) {
			this.num_agente = num_agente;
		}
		public String getFecha_contrasena() {
			return fecha_contrasena;
		}
		public void setFecha_contrasena(String fecha_contrasena) {
			this.fecha_contrasena = fecha_contrasena;
		}
		public String getEstatus() {
			return estatus;
		}
		public void setEstatus(String estatus) {
			this.estatus = estatus;
		}
		public String getVigencia() {
			return vigencia;
		}
		public void setVigencia(String vigencia) {
			this.vigencia = vigencia;
		}
		public String getLetra_descuento() {
			return letra_descuento;
		}
		public void setLetra_descuento(String letra_descuento) {
			this.letra_descuento = letra_descuento;
		}
		public String getFac_descuento() {
			return fac_descuento;
		}
		public void setFac_descuento(String fac_descuento) {
			this.fac_descuento = fac_descuento;
		}
		public String getImp_min_de_pedido() {
			return imp_min_de_pedido;
		}
		public void setImp_min_de_pedido(String imp_min_de_pedido) {
			this.imp_min_de_pedido = imp_min_de_pedido;
		}
		public String getDisponible_cte() {
			return disponible_cte;
		}
		public void setDisponible_cte(String disponible_cte) {
			this.disponible_cte = disponible_cte;
		}
		public String getUname_bodega() {
			return uname_bodega;
		}
		public void setUname_bodega(String uname_bodega) {
			this.uname_bodega = uname_bodega;
		}
		public String getCve_bodega() {
			return cve_bodega;
		}
		public void setCve_bodega(String cve_bodega) {
			this.cve_bodega = cve_bodega;
		}
		public String getNombre_bodega() {
			return nombre_bodega;
		}
		public void setNombre_bodega(String nombre_bodega) {
			this.nombre_bodega = nombre_bodega;
		}
		public String getRuta_bodega() {
			return ruta_bodega;
		}
		public void setRuta_bodega(String ruta_bodega) {
			this.ruta_bodega = ruta_bodega;
		}
		public String getTransporte_bodega() {
			return transporte_bodega;
		}
		public void setTransporte_bodega(String transporte_bodega) {
			this.transporte_bodega = transporte_bodega;
		}
		public String getSyf_bodega() {
			return syf_bodega;
		}
		public void setSyf_bodega(String syf_bodega) {
			this.syf_bodega = syf_bodega;
		}
		public String getCond_pago_bodega() {
			return cond_pago_bodega;
		}
		public void setCond_pago_bodega(String cond_pago_bodega) {
			this.cond_pago_bodega = cond_pago_bodega;
		}
		public String getVigencia_bodega() {
			return vigencia_bodega;
		}
		public void setVigencia_bodega(String vigencia_bodega) {
			this.vigencia_bodega = vigencia_bodega;
		}
		public String getDistancia_bodega() {
			return distancia_bodega;
		}
		public void setDistancia_bodega(String distancia_bodega) {
			this.distancia_bodega = distancia_bodega;
		}
		public String getTipo_lf_bodega() {
			return tipo_lf_bodega;
		}
		public void setTipo_lf_bodega(String tipo_lf_bodega) {
			this.tipo_lf_bodega = tipo_lf_bodega;
		}
		public String getUname_cdo() {
			return uname_cdo;
		}
		public void setUname_cdo(String uname_cdo) {
			this.uname_cdo = uname_cdo;
		}
		public int getCve_cdo() {
			return cve_cdo;
		}
		public void setCve_cdo(int cve_cdo) {
			this.cve_cdo = cve_cdo;
		}
		public String getNombre_cdo() {
			return nombre_cdo;
		}
		public void setNombre_cdo(String nombre_cdo) {
			this.nombre_cdo = nombre_cdo;
		}
		public String getRuta_cdo() {
			return ruta_cdo;
		}
		public void setRuta_cdo(String ruta_cdo) {
			this.ruta_cdo = ruta_cdo;
		}
		public String getTransporte_cdo() {
			return transporte_cdo;
		}
		public void setTransporte_cdo(String transporte_cdo) {
			this.transporte_cdo = transporte_cdo;
		}
		public String getSyf_cdo() {
			return syf_cdo;
		}
		public void setSyf_cdo(String syf_cdo) {
			this.syf_cdo = syf_cdo;
		}
		public String getCond_cdo() {
			return cond_cdo;
		}
		public void setCond_cdo(String cond_cdo) {
			this.cond_cdo = cond_cdo;
		}
		public String getVigencia_cdo() {
			return vigencia_cdo;
		}
		public void setVigencia_cdo(String vigencia_cdo) {
			this.vigencia_cdo = vigencia_cdo;
		}
		public String getDistancia_cdo() {
			return distancia_cdo;
		}
		public void setDistancia_cdo(String distancia_cdo) {
			this.distancia_cdo = distancia_cdo;
		}
		public String getTipo_lf_cdo() {
			return tipo_lf_cdo;
		}
		public void setTipo_lf_cdo(String tipo_lf_cdo) {
			this.tipo_lf_cdo = tipo_lf_cdo;
		}
		public int getPrecioConDescuento() {
			return precioConDescuento;
		}
		public void setPrecioConDescuento(int precioConDescuento) {
			this.precioConDescuento = precioConDescuento;
		}
		public String getDesglosaIva() {
			return desglosaIva;
		}
		public void setDesglosaIva(String desglosaIva) {
			this.desglosaIva = desglosaIva;
		}
		public Time getHoraIni() {
			return horaIni;
		}
		public void setHoraIni(Time horaIni) {
			this.horaIni = horaIni;
		}
		public Time getHoraFin() {
			return horaFin;
		}
		public void setHoraFin(Time horaFin) {
			this.horaFin = horaFin;
		}
		public Time getHoraSabadoIni() {
			return horaSabadoIni;
		}
		public void setHoraSabadoIni(Time horaSabadoIni) {
			this.horaSabadoIni = horaSabadoIni;
		}
		public Time getHoraSabadoFin() {
			return horaSabadoFin;
		}
		public void setHoraSabadoFin(Time horaSabadoFin) {
			this.horaSabadoFin = horaSabadoFin;
		}
		public static long getSerialversionuid() {
			return serialVersionUID;
		}
		
		public String getColorBarra() {
			return colorBarra;
		}
		public void setColorBarra(String colorBarra) {
			this.colorBarra = colorBarra;
		}
		public String getColorLetra() {
			return colorLetra;
		}
		public void setColorLetra(String colorLetra) {
			this.colorLetra = colorLetra;
		}
		public String getReferenciaBancaria() {
			return referenciaBancaria;
		}
		public void setReferenciaBancaria(String referenciaBancaria) {
			this.referenciaBancaria = referenciaBancaria;
		}
		 
		public InfoCliente() {
			super();
			this.cve_cliente = 0;
			this.nombre_cliente = "";
			this.razon_social = "";
			this.rfc = "";
			this.saldo_total = "0";
			this.commen_cliente = "0";
			this.lincme_cliente = "0";
			this.limite_credito = "0";
			this.centro = 0;
			this.num_agente = 0;
			this.fecha_contrasena = "0000-00-00";
			this.estatus = "";
			this.vigencia = "";
			this.letra_descuento = "";
			this.fac_descuento = "";
			this.imp_min_de_pedido = "";
			this.disponible_cte = "";
			this.uname_bodega = "";
			this.cve_bodega = "0";
			this.nombre_bodega = "";
			this.ruta_bodega = "0";
			this.transporte_bodega = "0";
			this.syf_bodega = "";
			this.cond_pago_bodega = "";
			this.vigencia_bodega = "";
			this.distancia_bodega = "";
			this.tipo_lf_bodega = "";
			this.uname_cdo = "";
			this.cve_cdo = 0;
			this.nombre_cdo = "";
			this.ruta_cdo = "0";
			this.transporte_cdo = "0";
			this.syf_cdo = "";
			this.cond_cdo = "0";
			this.vigencia_cdo = "";
			this.distancia_cdo = "0";
			this.tipo_lf_cdo = "";
			this.precioConDescuento = 0;
			this.desglosaIva = "";
			/*this.horaIni =    
			this.horaFin = horaFin;
			this.horaSabadoIni = horaSabadoIni;
			this.horaSabadoFin = horaSabadoFin;*/
			this.colorBarra = "";
			this.colorLetra="";
			this.referenciaBancaria = "";
		}
		
		public InfoCliente(int cve_cliente, String nombre_cliente, String razon_social, String rfc, String saldo_total,
				String commen_cliente, String lincme_cliente, String limite_credito, int centro, int num_agente,
				String fecha_contrasena, String estatus, String vigencia, String letra_descuento, String fac_descuento,
				String imp_min_de_pedido, String disponible_cte, String uname_bodega, String cve_bodega,
				String nombre_bodega, String ruta_bodega, String transporte_bodega, String syf_bodega,
				String cond_pago_bodega, String vigencia_bodega, String distancia_bodega, String tipo_lf_bodega,
				String uname_cdo, int cve_cdo, String nombre_cdo, String ruta_cdo, String transporte_cdo,
				String syf_cdo, String cond_cdo, String vigencia_cdo, String distancia_cdo, String tipo_lf_cdo,
				int precioConDescuento, String desglosaIva, Time horaIni, Time horaFin, Time horaSabadoIni,
				Time horaSabadoFin, String colorBarra, String colorletra, String referenciaBancaria) {
			super();
			this.cve_cliente = cve_cliente;
			this.nombre_cliente = nombre_cliente;
			this.razon_social = razon_social;
			this.rfc = rfc;
			this.saldo_total = saldo_total;
			this.commen_cliente = commen_cliente;
			this.lincme_cliente = lincme_cliente;
			this.limite_credito = limite_credito;
			this.centro = centro;
			this.num_agente = num_agente;
			this.fecha_contrasena = fecha_contrasena;
			this.estatus = estatus;
			this.vigencia = vigencia;
			this.letra_descuento = letra_descuento;
			this.fac_descuento = fac_descuento;
			this.imp_min_de_pedido = imp_min_de_pedido;
			this.disponible_cte = disponible_cte;
			this.uname_bodega = uname_bodega;
			this.cve_bodega = cve_bodega;
			this.nombre_bodega = nombre_bodega;
			this.ruta_bodega = ruta_bodega;
			this.transporte_bodega = transporte_bodega;
			this.syf_bodega = syf_bodega;
			this.cond_pago_bodega = cond_pago_bodega;
			this.vigencia_bodega = vigencia_bodega;
			this.distancia_bodega = distancia_bodega;
			this.tipo_lf_bodega = tipo_lf_bodega;
			this.uname_cdo = uname_cdo;
			this.cve_cdo = cve_cdo;
			this.nombre_cdo = nombre_cdo;
			this.ruta_cdo = ruta_cdo;
			this.transporte_cdo = transporte_cdo;
			this.syf_cdo = syf_cdo;
			this.cond_cdo = cond_cdo;
			this.vigencia_cdo = vigencia_cdo;
			this.distancia_cdo = distancia_cdo;
			this.tipo_lf_cdo = tipo_lf_cdo;
			this.precioConDescuento = precioConDescuento;
			this.desglosaIva = desglosaIva;
			this.horaIni = horaIni;
			this.horaFin = horaFin;
			this.horaSabadoIni = horaSabadoIni;
			this.horaSabadoFin = horaSabadoFin;
			this.colorBarra = colorBarra;
			this.colorLetra= colorletra;
			this.referenciaBancaria = referenciaBancaria;
		}
		@Override
		public String toString() {
			return "InfoCliente [cve_cliente=" + cve_cliente + ", nombre_cliente=" + nombre_cliente + ", razon_social="
					+ razon_social + ", rfc=" + rfc + ", saldo_total=" + saldo_total + ", commen_cliente="
					+ commen_cliente + ", lincme_cliente=" + lincme_cliente + ", limite_credito=" + limite_credito
					+ ", centro=" + centro + ", num_agente=" + num_agente + ", fecha_contrasena=" + fecha_contrasena
					+ ", estatus=" + estatus + ", vigencia=" + vigencia + ", letra_descuento=" + letra_descuento
					+ ", fac_descuento=" + fac_descuento + ", imp_min_de_pedido=" + imp_min_de_pedido
					+ ", disponible_cte=" + disponible_cte + ", uname_bodega=" + uname_bodega + ", cve_bodega="
					+ cve_bodega + ", nombre_bodega=" + nombre_bodega + ", ruta_bodega=" + ruta_bodega
					+ ", transporte_bodega=" + transporte_bodega + ", syf_bodega=" + syf_bodega + ", cond_pago_bodega="
					+ cond_pago_bodega + ", vigencia_bodega=" + vigencia_bodega + ", distancia_bodega="
					+ distancia_bodega + ", tipo_lf_bodega=" + tipo_lf_bodega + ", uname_cdo=" + uname_cdo
					+ ", cve_cdo=" + cve_cdo + ", nombre_cdo=" + nombre_cdo + ", ruta_cdo=" + ruta_cdo
					+ ", transporte_cdo=" + transporte_cdo + ", syf_cdo=" + syf_cdo + ", cond_cdo=" + cond_cdo
					+ ", vigencia_cdo=" + vigencia_cdo + ", distancia_cdo=" + distancia_cdo + ", tipo_lf_cdo="
					+ tipo_lf_cdo + ", precioConDescuento=" + precioConDescuento + ", desglosaIva=" + desglosaIva
					+ ", horaIni=" + horaIni + ", horaFin=" + horaFin + ", horaSabadoIni=" + horaSabadoIni
					+ ", horaSabadoFin=" + horaSabadoFin + ", colorBarra=" + colorBarra + ", referenciaBancaria="
					+ referenciaBancaria + "]";
		}

}
