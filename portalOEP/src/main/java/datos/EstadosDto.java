package datos;

public class EstadosDto {
	
	int cve_estado;
	String descripcion;
	
	
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
	@Override
	public String toString() {
		return "EstadosDto [cve_estado=" + cve_estado + ", descripcion=" + descripcion + "]";
	}

	
}