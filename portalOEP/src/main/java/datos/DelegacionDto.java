package datos;


public class DelegacionDto {
	
	int cve_delegacion;
	String descripcion;
	int cve_estado;
	
	public int getCve_delegacion() {
		return cve_delegacion;
	}
	public void setCve_delegacion(int cve_delegacion) {
		this.cve_delegacion = cve_delegacion;
	}
	
	public int getCve_estado() {
		return cve_estado;
	}
	public void setCve_estado(int cve_estado) {
		this.cve_estado = cve_estado;
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}
