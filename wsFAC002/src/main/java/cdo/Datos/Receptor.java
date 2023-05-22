package cdo.Datos;

public class Receptor {
	private String num_cte;
	private String nombre_rec; 
	private String uname;
	private String razon_social;
	private String calle_rec;
	private String colonia_rec; 
	private String municipio_rec;
	private String estado_rec; 
	private String cp_rec; 
	private String rfc_rec;
	private String telefono;
	private String vigencia;
	private String bloqueo;
	private String e_mail_rec; 
	private String desglosa_iva;
	private String num_exterior_rec;
	private String num_interior_rec;
	private String sucursal_rec; 
	private String localidad_rec;
	private String referencia_rec;
	private String pais_rec;
	private String pasaporte_rec; 
	private String agte;
	private String cond_pago;
	private String saldo;
	private String transporte;
	private String tipo_lf;
	private String ruta;
	private String nomRuta;
	private String letra_descuento;
	private String nom_trasn;
	private String tipo_cliente;
	private String descripci;	
	private String tipoFac;
	private String regimenFiscal;
	
	public Receptor(String num_cte, String nombre_rec, String uname, String razon_social, String calle_rec,
			String colonia_rec, String municipio_rec, String estado_rec, String cp_rec, String rfc_rec, String telefono,
			String vigencia, String bloqueo, String e_mail_rec, String desglosa_iva, String num_exterior_rec,
			String num_interior_rec, String sucursal_rec, String localidad_rec, String referencia_rec, String pais_rec,
			String pasaporte_rec, String agte, String cond_pago, String saldo, String transporte, String tipo_lf,
			String ruta, String letra_descuento, String nom_trasn, String tipo_cliente, String descripci, String nomRuta,
			String tipoFac,String regimenFiscal) {
		super();
		this.num_cte = num_cte;
		this.nombre_rec = nombre_rec;
		this.uname = uname;
		this.razon_social = razon_social;
		this.calle_rec = calle_rec;
		this.colonia_rec = colonia_rec;
		this.municipio_rec = municipio_rec;
		this.estado_rec = estado_rec;
		this.cp_rec = cp_rec;
		this.rfc_rec = rfc_rec;
		this.telefono = telefono;
		this.vigencia = vigencia;
		this.bloqueo = bloqueo;
		this.e_mail_rec = e_mail_rec;
		this.desglosa_iva = desglosa_iva;
		this.num_exterior_rec = num_exterior_rec;
		this.num_interior_rec = num_interior_rec;
		this.sucursal_rec = sucursal_rec;
		this.localidad_rec = localidad_rec;
		this.referencia_rec = referencia_rec;
		this.pais_rec = pais_rec;
		this.pasaporte_rec = pasaporte_rec;
		this.agte = agte;
		this.cond_pago = cond_pago;
		this.saldo = saldo;
		this.transporte = transporte;
		this.tipo_lf = tipo_lf;
		this.ruta = ruta;
		this.letra_descuento = letra_descuento;
		this.nom_trasn = nom_trasn;
		this.tipo_cliente = tipo_cliente;
		this.descripci = descripci;
		this.nomRuta = nomRuta;
		this.tipoFac = tipoFac;
		this.regimenFiscal = regimenFiscal;
	}
	
	public Receptor() {
		super();
		this.num_cte = "";
		this.nombre_rec = "";
		this.uname = "";
		this.razon_social = "";
		this.calle_rec = "";
		this.colonia_rec = "";
		this.municipio_rec = "";
		this.estado_rec = "";
		this.cp_rec = "";
		this.rfc_rec = "";
		this.telefono = "";
		this.vigencia = "";
		this.bloqueo = "";
		this.e_mail_rec = "";
		this.desglosa_iva = "";
		this.num_exterior_rec = "";
		this.num_interior_rec = "";
		this.sucursal_rec = "";
		this.localidad_rec = "";
		this.referencia_rec = "";
		this.pais_rec = "";
		this.pasaporte_rec = "";
		this.agte = "";
		this.cond_pago = "";
		this.saldo = "";
		this.transporte = "";
		this.tipo_lf = "";
		this.ruta = "";
		this.letra_descuento = "";
		this.nom_trasn = "";
		this.tipo_cliente = "";
		this.descripci = "";
		this.nomRuta = "";
		this.tipoFac = "";
		this.regimenFiscal ="";
	}
	
	public String getRegimenFiscal() {
		return regimenFiscal;
	}

	public void setRegimenFiscal(String regimenFiscal) {
		this.regimenFiscal = regimenFiscal;
	}

	public String getNum_cte() {
		return num_cte;
	}
	public void setNum_cte(String num_cte) {
		this.num_cte = num_cte;
	}
	public String getNombre_rec() {
		return nombre_rec;
	}
	public void setNombre_rec(String nombre_rec) {
		this.nombre_rec = nombre_rec;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getRazon_social() {
		return razon_social;
	}
	public void setRazon_social(String razon_social) {
		this.razon_social = razon_social;
	}
	public String getCalle_rec() {
		return calle_rec;
	}
	public void setCalle_rec(String calle_rec) {
		this.calle_rec = calle_rec;
	}
	public String getColonia_rec() {
		return colonia_rec;
	}
	public void setColonia_rec(String colonia_rec) {
		this.colonia_rec = colonia_rec;
	}
	public String getMunicipio_rec() {
		return municipio_rec;
	}
	public void setMunicipio_rec(String municipio_rec) {
		this.municipio_rec = municipio_rec;
	}
	public String getEstado_rec() {
		return estado_rec;
	}
	public void setEstado_rec(String estado_rec) {
		this.estado_rec = estado_rec;
	}
	public String getCp_rec() {
		return cp_rec;
	}
	public void setCp_rec(String cp_rec) {
		this.cp_rec = cp_rec;
	}
	public String getRfc_rec() {
		return rfc_rec;
	}
	public void setRfc_rec(String rfc_rec) {
		this.rfc_rec = rfc_rec;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getVigencia() {
		return vigencia;
	}
	public void setVigencia(String vigencia) {
		this.vigencia = vigencia;
	}
	public String getBloqueo() {
		return bloqueo;
	}
	public void setBloqueo(String bloqueo) {
		this.bloqueo = bloqueo;
	}
	public String getE_mail_rec() {
		return e_mail_rec;
	}
	public void setE_mail_rec(String e_mail_rec) {
		this.e_mail_rec = e_mail_rec;
	}
	public String getDesglosa_iva() {
		return desglosa_iva;
	}
	public void setDesglosa_iva(String desglosa_iva) {
		this.desglosa_iva = desglosa_iva;
	}
	public String getNum_exterior_rec() {
		return num_exterior_rec;
	}
	public void setNum_exterior_rec(String num_exterior_rec) {
		this.num_exterior_rec = num_exterior_rec;
	}
	public String getNum_interior_rec() {
		return num_interior_rec;
	}
	public void setNum_interior_rec(String num_interior_rec) {
		this.num_interior_rec = num_interior_rec;
	}
	public String getSucursal_rec() {
		return sucursal_rec;
	}
	public void setSucursal_rec(String sucursal_rec) {
		this.sucursal_rec = sucursal_rec;
	}
	public String getLocalidad_rec() {
		return localidad_rec;
	}
	public void setLocalidad_rec(String localidad_rec) {
		this.localidad_rec = localidad_rec;
	}
	public String getReferencia_rec() {
		return referencia_rec;
	}
	public void setReferencia_rec(String referencia_rec) {
		this.referencia_rec = referencia_rec;
	}
	public String getPais_rec() {
		return pais_rec;
	}
	public void setPais_rec(String pais_rec) {
		this.pais_rec = pais_rec;
	}
	public String getPasaporte_rec() {
		return pasaporte_rec;
	}
	public void setPasaporte_rec(String pasaporte_rec) {
		this.pasaporte_rec = pasaporte_rec;
	}
	public String getAgte() {
		return agte;
	}
	public void setAgte(String agte) {
		this.agte = agte;
	}
	public String getCond_pago() {
		return cond_pago;
	}
	public void setCond_pago(String cond_pago) {
		this.cond_pago = cond_pago;
	}
	public String getSaldo() {
		return saldo;
	}
	public void setSaldo(String saldo) {
		this.saldo = saldo;
	}
	public String getTransporte() {
		return transporte;
	}
	public void setTransporte(String transporte) {
		this.transporte = transporte;
	}
	public String getTipo_lf() {
		return tipo_lf;
	}
	public void setTipo_lf(String tipo_lf) {
		this.tipo_lf = tipo_lf;
	}
	public String getRuta() {
		return ruta;
	}
	public void setRuta(String ruta) {
		this.ruta = ruta;
	}
	public String getLetra_descuento() {
		return letra_descuento;
	}
	public void setLetra_descuento(String letra_descuento) {
		this.letra_descuento = letra_descuento;
	}
	public String getNom_trasn() {
		return nom_trasn;
	}
	public void setNom_trasn(String nom_trasn) {
		this.nom_trasn = nom_trasn;
	}
	public String getTipo_cliente() {
		return tipo_cliente;
	}
	public void setTipo_cliente(String tipo_cliente) {
		this.tipo_cliente = tipo_cliente;
	}
	public String getDescripci() {
		return descripci;
	}
	public void setDescripci(String descripci) {
		this.descripci = descripci;
	}
	public String getNomRuta() {
		return nomRuta;
	}
	public void setNomRuta(String nomRuta) {
		this.nomRuta = nomRuta;
	}
	public String getTipoFac() {
		return tipoFac;
	}
	public void setTipoFac(String tipoFac) {
		this.tipoFac = tipoFac;
	}

	@Override
	public String toString() {
		return "Receptor [num_cte=" + num_cte + ", nombre_rec=" + nombre_rec + ", uname=" + uname + ", razon_social="
				+ razon_social + ", calle_rec=" + calle_rec + ", colonia_rec=" + colonia_rec + ", municipio_rec="
				+ municipio_rec + ", estado_rec=" + estado_rec + ", cp_rec=" + cp_rec + ", rfc_rec=" + rfc_rec
				+ ", telefono=" + telefono + ", vigencia=" + vigencia + ", bloqueo=" + bloqueo + ", e_mail_rec="
				+ e_mail_rec + ", desglosa_iva=" + desglosa_iva + ", num_exterior_rec=" + num_exterior_rec
				+ ", num_interior_rec=" + num_interior_rec + ", sucursal_rec=" + sucursal_rec + ", localidad_rec="
				+ localidad_rec + ", referencia_rec=" + referencia_rec + ", pais_rec=" + pais_rec + ", pasaporte_rec="
				+ pasaporte_rec + ", agte=" + agte + ", cond_pago=" + cond_pago + ", saldo=" + saldo + ", transporte="
				+ transporte + ", tipo_lf=" + tipo_lf + ", ruta=" + ruta + ", nomRuta=" + nomRuta + ", letra_descuento="
				+ letra_descuento + ", nom_trasn=" + nom_trasn + ", tipo_cliente=" + tipo_cliente + ", descripci="
				+ descripci + ", tipoFac=" + tipoFac + ", regimenFiscal=" + regimenFiscal + "]";
	}
	
	
}
