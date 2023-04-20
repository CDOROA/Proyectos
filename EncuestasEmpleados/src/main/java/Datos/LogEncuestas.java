package Datos;

public class LogEncuestas {
	private String uname;
	private String accion;
	private String cve_usu;
	
	
	
	public LogEncuestas() {
		super();
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getAccion() {
		return accion;
	}
	public void setAccion(String accion) {
		this.accion = accion;
	}
	public String getCve_usu() {
		return cve_usu;
	}
	public void setCve_usu(String cve_usu) {
		this.cve_usu = cve_usu;
	}
	@Override
	public String toString() {
		return "LogEncuestas [uname=" + uname + ", accion=" + accion + ", cve_usu=" + cve_usu + "]";
	}
	
	
}
