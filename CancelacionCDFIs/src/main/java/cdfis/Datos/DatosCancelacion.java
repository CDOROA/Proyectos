package cdfis.Datos;


public class DatosCancelacion 
{

	String nombre_corto; 
	String num_fac;
	String docto_tran;
	String referencia_tran;
	int agent_vend;
	int num_cli;
	String nombre;
	String razon_social;
	String fecha_factura;
	double total;
	String folio_fiscal;
	String uname_br;
	String cuenta;
	String usuario;
	String password;
	String serie;
	int folio;
	public DatosCancelacion(String nombre_corto, String num_fac,String docto_tran,String referencia_tran,int agent_vend, int num_cli, String nombre, String razon_social,
			String fecha_factura, double total, String folio_fiscal, String uname_br, String cuenta, String usuario,
			String password, String serie, int folio) {
		super();
		this.nombre_corto = nombre_corto;
		this.num_fac = num_fac;
		this.docto_tran = docto_tran;
		this.referencia_tran = referencia_tran;
		this.agent_vend = agent_vend;
		this.num_cli = num_cli;
		this.nombre = nombre;
		this.razon_social = razon_social;
		this.fecha_factura = fecha_factura;
		this.total = total;
		this.folio_fiscal = folio_fiscal;
		this.uname_br = uname_br;
		this.cuenta = cuenta;
		this.usuario = usuario;
		this.password = password;
		this.serie = serie;
		this.folio = folio;
	}
	public DatosCancelacion() {
		super();
		
	}
	public String getNombre_corto() {
		return nombre_corto;
	}
	public void setNombre_corto(String nombre_corto) {
		this.nombre_corto = nombre_corto;
	}
	public String getNum_fac() {
		return num_fac;
	}
	public void setNum_fac(String num_fac) {
		this.num_fac = num_fac;
	}
	public String getDocto_tran() {
		return docto_tran;
	}
	public void setDocto_tran(String docto_tran) {
		this.docto_tran = docto_tran;
	}
	public String getReferencia_tran() {
		return referencia_tran;
	}
	public void setReferencia_tran(String referencia_tran) {
		this.referencia_tran = referencia_tran;
	}
	public int getAgent_vend() {
		return agent_vend;
	}
	
	public int getNum_cli() {
		return num_cli;
	}
	
	public void setNum_cli(int num_cli) {
		this.num_cli = num_cli;
	}
	public void setAgent_vend(int agent_vend) {
		this.agent_vend = agent_vend;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getRazon_social() {
		return razon_social;
	}
	public void setRazon_social(String razon_social) {
		this.razon_social = razon_social;
	}
	public String getFecha_factura() {
		return fecha_factura;
	}
	public void setFecha_factura(String fecha_factura) {
		this.fecha_factura = fecha_factura;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public String getFolio_fiscal() {
		return folio_fiscal;
	}
	public void setFolio_fiscal(String folio_fiscal) {
		this.folio_fiscal = folio_fiscal;
	}
	public String getUname_br() {
		return uname_br;
	}
	public void setUname_br(String uname_br) {
		this.uname_br = uname_br;
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
	public String getSerie() {
		return serie;
	}
	public void setSerie(String serie) {
		this.serie = serie;
	}
	public int getFolio() {
		return folio;
	}
	public void setFolio(int folio) {
		this.folio = folio;
	}
	@Override
	public String toString() {
		return "DatosCancelacion [nombre_corto=" + nombre_corto + ", num_fac=" + num_fac + ", docto_tran=" + docto_tran
				+ ", referencia_tran=" + referencia_tran + ", agent_vend=" + agent_vend + ", num_cli=" + num_cli
				+ ", nombre=" + nombre + ", razon_social=" + razon_social + ", fecha_factura=" + fecha_factura
				+ ", total=" + total + ", folio_fiscal=" + folio_fiscal + ", uname_br=" + uname_br + ", cuenta="
				+ cuenta + ", usuario=" + usuario + ", password=" + password + ", serie=" + serie + ", folio=" + folio
				+ "]";
	}

	
	
	
}
