package cdo.Datos;

public class FacConceptosEspeciales {
	private String id_cdd;
	private String control;
	private String usuario_capt;
	private String num_cli;
	private String num_fac;
	private String imp_neto;
	private String imp_bruto; 
	private String st;
	private String fecha_fact;
	private String num_agente;
	private String serie_cfd;  
	private String folio_cfd;
	private String iva_retenido;
	private String ode;
	private String fecha_pro;
	private String desc_comp; 
	private String medios_pago;
	private String numero_cuenta; 
	private String obs_comp;
	private String fecha_liquidacion;
	
	public FacConceptosEspeciales(String id_cdd, String control, String usuario_capt, String num_cli, String num_fac,
			String imp_neto, String imp_bruto, String st, String fecha_fact, String num_agente, String serie_cfd,
			String folio_cfd, String iva_retenido, String ode, String fecha_pro, String desc_comp, String medios_pago,
			String numero_cuenta, String obs_comp, String fecha_liquidacion) {
		super();
		this.id_cdd = id_cdd;
		this.control = control;
		this.usuario_capt = usuario_capt;
		this.num_cli = num_cli;
		this.num_fac = num_fac;
		this.imp_neto = imp_neto;
		this.imp_bruto = imp_bruto;
		this.st = st;
		this.fecha_fact = fecha_fact;
		this.num_agente = num_agente;
		this.serie_cfd = serie_cfd;
		this.folio_cfd = folio_cfd;
		this.iva_retenido = iva_retenido;
		this.ode = ode;
		this.fecha_pro = fecha_pro;
		this.desc_comp = desc_comp;
		this.medios_pago = medios_pago;
		this.numero_cuenta = numero_cuenta;
		this.obs_comp = obs_comp;
		this.fecha_liquidacion = fecha_liquidacion;
	}
	
	public FacConceptosEspeciales() {
		super();
		this.id_cdd = "";
		this.control = "";
		this.usuario_capt = "";
		this.num_cli = "";
		this.num_fac = "";
		this.imp_neto = "";
		this.imp_bruto = "";
		this.st = "";
		this.fecha_fact = "";
		this.num_agente = "";
		this.serie_cfd = "";
		this.folio_cfd = "";
		this.iva_retenido = "";
		this.ode = "";
		this.fecha_pro = "";
		this.desc_comp = "";
		this.medios_pago = "";
		this.numero_cuenta = "";
		this.obs_comp = "";
		this.fecha_liquidacion = "";
	}
	
	public String getId_cdd() {
		return id_cdd;
	}
	public void setId_cdd(String id_cdd) {
		this.id_cdd = id_cdd;
	}
	public String getControl() {
		return control;
	}
	public void setControl(String control) {
		this.control = control;
	}
	public String getUsuario_capt() {
		return usuario_capt;
	}
	public void setUsuario_capt(String usuario_capt) {
		this.usuario_capt = usuario_capt;
	}
	public String getNum_cli() {
		return num_cli;
	}
	public void setNum_cli(String num_cli) {
		this.num_cli = num_cli;
	}
	public String getNum_fac() {
		return num_fac;
	}
	public void setNum_fac(String num_fac) {
		this.num_fac = num_fac;
	}
	public String getImp_neto() {
		return imp_neto;
	}
	public void setImp_neto(String imp_neto) {
		this.imp_neto = imp_neto;
	}
	public String getImp_bruto() {
		return imp_bruto;
	}
	public void setImp_bruto(String imp_bruto) {
		this.imp_bruto = imp_bruto;
	}
	public String getSt() {
		return st;
	}
	public void setSt(String st) {
		this.st = st;
	}
	public String getFecha_fact() {
		return fecha_fact;
	}
	public void setFecha_fact(String fecha_fact) {
		this.fecha_fact = fecha_fact;
	}
	public String getNum_agente() {
		return num_agente;
	}
	public void setNum_agente(String num_agente) {
		this.num_agente = num_agente;
	}
	public String getSerie_cfd() {
		return serie_cfd;
	}
	public void setSerie_cfd(String serie_cfd) {
		this.serie_cfd = serie_cfd;
	}
	public String getFolio_cfd() {
		return folio_cfd;
	}
	public void setFolio_cfd(String folio_cfd) {
		this.folio_cfd = folio_cfd;
	}
	public String getIva_retenido() {
		return iva_retenido;
	}
	public void setIva_retenido(String iva_retenido) {
		this.iva_retenido = iva_retenido;
	}
	public String getOde() {
		return ode;
	}
	public void setOde(String ode) {
		this.ode = ode;
	}
	public String getFecha_pro() {
		return fecha_pro;
	}
	public void setFecha_pro(String fecha_pro) {
		this.fecha_pro = fecha_pro;
	}
	public String getDesc_comp() {
		return desc_comp;
	}
	public void setDesc_comp(String desc_comp) {
		this.desc_comp = desc_comp;
	}
	public String getMedios_pago() {
		return medios_pago;
	}
	public void setMedios_pago(String medios_pago) {
		this.medios_pago = medios_pago;
	}
	public String getNumero_cuenta() {
		return numero_cuenta;
	}
	public void setNumero_cuenta(String numero_cuenta) {
		this.numero_cuenta = numero_cuenta;
	}
	public String getObs_comp() {
		return obs_comp;
	}
	public void setObs_comp(String obs_comp) {
		this.obs_comp = obs_comp;
	}
	public String getFecha_liquidacion() {
		return fecha_liquidacion;
	}
	public void setFecha_liquidacion(String fecha_liquidacion) {
		this.fecha_liquidacion = fecha_liquidacion;
	}
	
	
}
