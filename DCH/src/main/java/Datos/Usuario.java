package Datos;

public class Usuario {

	private String cveUsuario;
	private int tipoUsuario;
	private String nombre;
	private int departamento;
	private String nombreDepartamento;
	private String uname;
	private String unameBr;
	private String unames;
	private String nombreCotro;
	private int nivelUsuario;
	private int procesoWeb;
	private String nombreProcesoWeb;
	private String tipoProceso;
	private String url;
	private String ruta;  
	private String usoImpresora;  
	private String usuarioEnProcesoWeb;
	private int datoNumerico1;
	private int datoNumerico2;
	private String datoAlfanumerico1;
	private String datoAlfanumerico2;
    private String impresoras;
	


	public String getCveUsuario() {
		return cveUsuario;
	}
	public void setCveUsuario(String cveUsuario) {
		this.cveUsuario = cveUsuario;
	}

	
	
	public int getTipoUsuario() {
		return tipoUsuario;
	}
	public void setTipoUsuario(int tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getDepartamento() {
		return departamento;
	}
	public void setDepartamento(int departamento) {
		this.departamento = departamento;
	}
	public String getNombreDepartamento() {
		return nombreDepartamento;
	}
	public void setNombreDepartamento(String nombreDepartamento) {
		this.nombreDepartamento = nombreDepartamento;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getUnameBr() {
		return unameBr;
	}
	public void setUnameBr(String unameBr) {
		this.unameBr = unameBr;
	}
	public String getUnames() {
		return unames;
	}
	public void setUnames(String unames) {
		this.unames = unames;
	}
	public String getNombreCotro() {
		return nombreCotro;
	}
	public void setNombreCotro(String nombreCotro) {
		this.nombreCotro = nombreCotro;
	}
	public int getNivelUsuario() {
		return nivelUsuario;
	}
	public void setNivelUsuario(int nivelUsuario) {
		this.nivelUsuario = nivelUsuario;
	}
	public int getProcesoWeb() {
		return procesoWeb;
	}
	public void setProcesoWeb(int procesoWeb) {
		this.procesoWeb = procesoWeb;
	}
	public String getNombreProcesoWeb() {
		return nombreProcesoWeb;
	}
	public void setNombreProcesoWeb(String nombreProcesoWeb) {
		this.nombreProcesoWeb = nombreProcesoWeb;
	}
	public String getTipoProceso() {
		return tipoProceso;
	}
	public void setTipoProceso(String tipoProceso) {
		this.tipoProceso = tipoProceso;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getRuta() {
		return ruta;
	}
	public void setRuta(String ruta) {
		this.ruta = ruta;
	}
	public String getUsoImpresora() {
		return usoImpresora;
	}
	public void setUsoImpresora(String usoImpresora) {
		this.usoImpresora = usoImpresora;
	}
	public String getUsuarioEnProcesoWeb() {
		return usuarioEnProcesoWeb;
	}
	public void setUsuarioEnProcesoWeb(String usuarioEnProcesoWeb) {
		this.usuarioEnProcesoWeb = usuarioEnProcesoWeb;
	}
	public int getDatoNumerico1() {
		return datoNumerico1;
	}
	public void setDatoNumerico1(int datoNumerico1) {
		this.datoNumerico1 = datoNumerico1;
	}
	public int getDatoNumerico2() {
		return datoNumerico2;
	}
	public void setDatoNumerico2(int datoNumerico2) {
		this.datoNumerico2 = datoNumerico2;
	}
	public String getDatoAlfanumerico1() {
		return datoAlfanumerico1;
	}
	public void setDatoAlfanumerico1(String datoAlfanumerico1) {
		this.datoAlfanumerico1 = datoAlfanumerico1;
	}
	public String getDatoAlfanumerico2() {
		return datoAlfanumerico2;
	}
	public void setDatoAlfanumerico2(String datoAlfanumerico2) {
		this.datoAlfanumerico2 = datoAlfanumerico2;
	}
	public String getImpresoras() {
		return impresoras;
	}
	public void setImpresoras(String impresoras) {
		this.impresoras = impresoras;
	}
	
	
	
	public Usuario() {
		super();
		this.cveUsuario = "";
		this.tipoUsuario = 0;
		this.nombre = "";
		this.departamento = 0;
		this.nombreDepartamento = "";
		this.uname = "";
		this.unameBr = "";
		this.unames = "";
		this.nombreCotro = "";
		this.nivelUsuario = 0;
		this.procesoWeb = 0;
		this.nombreProcesoWeb = "";
		this.tipoProceso = "";
		this.url = "";
		this.ruta = "";
		this.usoImpresora = "";
		this.usuarioEnProcesoWeb = "";
		this.datoNumerico1 = 0;
		this.datoNumerico2 = 0;
		this.datoAlfanumerico1 = "";
		this.datoAlfanumerico2 = "";
		this.impresoras = "";
	}
	@Override
	public String toString() {
		return "Usuario [cveUsuario=" + cveUsuario + ", TipoUsuario=" + tipoUsuario + ", nombre=" + nombre
				+ ", departamento=" + departamento + ", nombreDepartamento=" + nombreDepartamento + ", uname=" + uname
				+ ", unameBr=" + unameBr + ", unames=" + unames + ", nombreCotro=" + nombreCotro + ", nivelUsuario="
				+ nivelUsuario + ", procesoWeb=" + procesoWeb + ", nombreProcesoWeb=" + nombreProcesoWeb
				+ ", tipoProceso=" + tipoProceso + ", url=" + url + ", ruta=" + ruta + ", usoImpresora=" + usoImpresora
				+ ", usuarioEnProcesoWeb=" + usuarioEnProcesoWeb + ", datoNumerico1=" + datoNumerico1
				+ ", datoNumerico2=" + datoNumerico2 + ", datoAlfanumerico1=" + datoAlfanumerico1
				+ ", datoAlfanumerico2=" + datoAlfanumerico2 + ", impresoras=" + impresoras + "]";
	}

	
}
