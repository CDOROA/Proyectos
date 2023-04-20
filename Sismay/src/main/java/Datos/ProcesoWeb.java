package Datos;

public class ProcesoWeb {
	private String numProceso;
	private String url;
	private String nombre;
	
	
	public ProcesoWeb(String numProceso, String url, String nombre) {
		super();
		this.numProceso = numProceso;
		this.url = url;
		this.nombre = nombre;
	}
	public ProcesoWeb() {
	}
	public String getNumProceso() {
		return numProceso;
	}
	public void setNumProceso(String numProceso) {
		this.numProceso = numProceso;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	@Override
	public String toString() {
		return "ProcesosWeb [numProceso=" + numProceso + ", url=" + url + ", nombre=" + nombre + "]";
	} 
}
