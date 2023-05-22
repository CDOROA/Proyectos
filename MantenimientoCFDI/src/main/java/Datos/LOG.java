package Datos;

public class LOG {
	private String uname;
	private String serie;
	private String folio;
	private String descripcion;
	private String documento;
	private String documentoCFDI;
	private String ode;
	private String fechaPro;
	private String horaPro;
	public LOG() {
		super();
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getSerie() {
		return serie;
	}
	public void setSerie(String serie) {
		this.serie = serie;
	}
	public String getFolio() {
		return folio;
	}
	public void setFolio(String folio) {
		this.folio = folio;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getDocumento() {
		return documento;
	}
	public void setDocumento(String documento) {
		this.documento = documento;
	}
	public String getDocumentoCFDI() {
		return documentoCFDI;
	}
	public void setDocumentoCFDI(String documentoCFDI) {
		this.documentoCFDI = documentoCFDI;
	}
	public String getOde() {
		return ode;
	}
	public void setOde(String ode) {
		this.ode = ode;
	}
	public String getFechaPro() {
		return fechaPro;
	}
	public void setFechaPro(String fechaPro) {
		this.fechaPro = fechaPro;
	}
	public String getHoraPro() {
		return horaPro;
	}
	public void setHoraPro(String horaPro) {
		this.horaPro = horaPro;
	}
	@Override
	public String toString() {
		return "LOG [uname=" + uname + ", serie=" + serie + ", folio=" + folio + ", descripcion=" + descripcion
				+ ", documento=" + documento + ", documentoCFDI=" + documentoCFDI + ", ode=" + ode + ", fechaPro="
				+ fechaPro + ", horaPro=" + horaPro + "]";
	}
	
}


