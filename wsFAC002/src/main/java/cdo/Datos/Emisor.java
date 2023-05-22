package cdo.Datos;

public class Emisor {
	private String rfc_emi;
	private String nombre_emi;
	private String uname_emi; 
	private String calle_emi; 
	private String num_ext_emi; 
	private String num_int_emi; 
	private String colonia; 
	private String referencia_emi; 
	private String municipio;
	private String estado;
	private String pais; 
	private String cp_emi; 
	private String calle_emi_comp;
	private String num_ext_emi_comp; 
	private String num_int_emi_comp; 
	private String colonia_emi_comp;
	private String municipio_emi_comp;
	private String estado_emi_comp; 
	private String pais_emi_comp;
	private String cp_emi_comp; 
	private String na; 
	private String localidad_emi; 
	private String tel_emi; 
	private String localidad_emi_comp; 
	private String referencia_emi_comp; 
	private String telefono_emi_comp;
	
	public Emisor(String rfc_emi, String nombre_emi, String uname_emi, String calle_emi, String num_ext_emi,
			String num_int_emi, String colonia, String referencia_emi, String municipio, String estado, String pais,
			String cp_emi, String calle_emi_comp, String num_ext_emi_comp, String num_int_emi_comp,
			String colonia_emi_comp, String municipio_emi_comp, String estado_emi_comp, String pais_emi_comp,
			String cp_emi_comp, String na, String localidad_emi, String tel_emi, String localidad_emi_comp,
			String referencia_emi_comp, String telefono_emi_comp) {
		super();
		this.rfc_emi = rfc_emi;
		this.nombre_emi = nombre_emi;
		this.uname_emi = uname_emi;
		this.calle_emi = calle_emi;
		this.num_ext_emi = num_ext_emi;
		this.num_int_emi = num_int_emi;
		this.colonia = colonia;
		this.referencia_emi = referencia_emi;
		this.municipio = municipio;
		this.estado = estado;
		this.pais = pais;
		this.cp_emi = cp_emi;
		this.calle_emi_comp = calle_emi_comp;
		this.num_ext_emi_comp = num_ext_emi_comp;
		this.num_int_emi_comp = num_int_emi_comp;
		this.colonia_emi_comp = colonia_emi_comp;
		this.municipio_emi_comp = municipio_emi_comp;
		this.estado_emi_comp = estado_emi_comp;
		this.pais_emi_comp = pais_emi_comp;
		this.cp_emi_comp = cp_emi_comp;
		this.na = na;
		this.localidad_emi = localidad_emi;
		this.tel_emi = tel_emi;
		this.localidad_emi_comp = localidad_emi_comp;
		this.referencia_emi_comp = referencia_emi_comp;
		this.telefono_emi_comp = telefono_emi_comp;
	}
	
	public Emisor() {
		super();
		this.rfc_emi = "";
		this.nombre_emi = "";
		this.uname_emi = "";
		this.calle_emi = "";
		this.num_ext_emi = "";
		this.num_int_emi = "";
		this.colonia = "";
		this.referencia_emi = "";
		this.municipio = "";
		this.estado = "";
		this.pais = "";
		this.cp_emi = "";
		this.calle_emi_comp = "";
		this.num_ext_emi_comp = "";
		this.num_int_emi_comp = "";
		this.colonia_emi_comp = "";
		this.municipio_emi_comp = "";
		this.estado_emi_comp = "";
		this.pais_emi_comp = "";
		this.cp_emi_comp = "";
		this.na = "";
		this.localidad_emi = "";
		this.tel_emi = "";
		this.localidad_emi_comp = "";
		this.referencia_emi_comp = "";
		this.telefono_emi_comp = "";
	}
	
	public String getRfc_emi() {
		return rfc_emi;
	}
	public void setRfc_emi(String rfc_emi) {
		this.rfc_emi = rfc_emi;
	}
	public String getNombre_emi() {
		return nombre_emi;
	}
	public void setNombre_emi(String nombre_emi) {
		this.nombre_emi = nombre_emi;
	}
	public String getUname_emi() {
		return uname_emi;
	}
	public void setUname_emi(String uname_emi) {
		this.uname_emi = uname_emi;
	}
	public String getCalle_emi() {
		return calle_emi;
	}
	public void setCalle_emi(String calle_emi) {
		this.calle_emi = calle_emi;
	}
	public String getNum_ext_emi() {
		return num_ext_emi;
	}
	public void setNum_ext_emi(String num_ext_emi) {
		this.num_ext_emi = num_ext_emi;
	}
	public String getNum_int_emi() {
		return num_int_emi;
	}
	public void setNum_int_emi(String num_int_emi) {
		this.num_int_emi = num_int_emi;
	}
	public String getColonia() {
		return colonia;
	}
	public void setColonia(String colonia) {
		this.colonia = colonia;
	}
	public String getReferencia_emi() {
		return referencia_emi;
	}
	public void setReferencia_emi(String referencia_emi) {
		this.referencia_emi = referencia_emi;
	}
	public String getMunicipio() {
		return municipio;
	}
	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getPais() {
		return pais;
	}
	public void setPais(String pais) {
		this.pais = pais;
	}
	public String getCp_emi() {
		return cp_emi;
	}
	public void setCp_emi(String cp_emi) {
		this.cp_emi = cp_emi;
	}
	public String getCalle_emi_comp() {
		return calle_emi_comp;
	}
	public void setCalle_emi_comp(String calle_emi_comp) {
		this.calle_emi_comp = calle_emi_comp;
	}
	public String getNum_ext_emi_comp() {
		return num_ext_emi_comp;
	}
	public void setNum_ext_emi_comp(String num_ext_emi_comp) {
		this.num_ext_emi_comp = num_ext_emi_comp;
	}
	public String getNum_int_emi_comp() {
		return num_int_emi_comp;
	}
	public void setNum_int_emi_comp(String num_int_emi_comp) {
		this.num_int_emi_comp = num_int_emi_comp;
	}
	public String getColonia_emi_comp() {
		return colonia_emi_comp;
	}
	public void setColonia_emi_comp(String colonia_emi_comp) {
		this.colonia_emi_comp = colonia_emi_comp;
	}
	public String getMunicipio_emi_comp() {
		return municipio_emi_comp;
	}
	public void setMunicipio_emi_comp(String municipio_emi_comp) {
		this.municipio_emi_comp = municipio_emi_comp;
	}
	public String getEstado_emi_comp() {
		return estado_emi_comp;
	}
	public void setEstado_emi_comp(String estado_emi_comp) {
		this.estado_emi_comp = estado_emi_comp;
	}
	public String getPais_emi_comp() {
		return pais_emi_comp;
	}
	public void setPais_emi_comp(String pais_emi_comp) {
		this.pais_emi_comp = pais_emi_comp;
	}
	public String getCp_emi_comp() {
		return cp_emi_comp;
	}
	public void setCp_emi_comp(String cp_emi_comp) {
		this.cp_emi_comp = cp_emi_comp;
	}
	public String getNa() {
		return na;
	}
	public void setNa(String na) {
		this.na = na;
	}
	public String getLocalidad_emi() {
		return localidad_emi;
	}
	public void setLocalidad_emi(String localidad_emi) {
		this.localidad_emi = localidad_emi;
	}
	public String getTel_emi() {
		return tel_emi;
	}
	public void setTel_emi(String tel_emi) {
		this.tel_emi = tel_emi;
	}
	public String getLocalidad_emi_comp() {
		return localidad_emi_comp;
	}
	public void setLocalidad_emi_comp(String localidad_emi_comp) {
		this.localidad_emi_comp = localidad_emi_comp;
	}
	public String getReferencia_emi_comp() {
		return referencia_emi_comp;
	}
	public void setReferencia_emi_comp(String referencia_emi_comp) {
		this.referencia_emi_comp = referencia_emi_comp;
	}
	public String getTelefono_emi_comp() {
		return telefono_emi_comp;
	}
	public void setTelefono_emi_comp(String telefono_emi_comp) {
		this.telefono_emi_comp = telefono_emi_comp;
	}
	
	
}
