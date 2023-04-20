package Datos;

public class Areas {
	private String idArea;
	private String nivelArea;
	private String descripcion;
	private String estatus;
	private String subdptos;
	private int totalEmpleados;
	private int empleadosEvaluados;
	private int empleadosNoEvaluados;
	
	
	
	
	public String getSubdptos() {
		return subdptos;
	}
	public void setSubdptos(String subdptos) {
		this.subdptos = subdptos;
	}
	public int getTotalEmpleados() {
		return totalEmpleados;
	}
	public void setTotalEmpleados(int totalEmpleados) {
		this.totalEmpleados = totalEmpleados;
	}
	public int getEmpleadosEvaluados() {
		return empleadosEvaluados;
	}
	public void setEmpleadosEvaluados(int empleadosEvaluados) {
		this.empleadosEvaluados = empleadosEvaluados;
	}
	public int getEmpleadosNoEvaluados() {
		return empleadosNoEvaluados;
	}
	public void setEmpleadosNoEvaluados(int empleadosNoEvaluados) {
		this.empleadosNoEvaluados = empleadosNoEvaluados;
	}
	public String getIdArea() {
		return idArea;
	}
	public void setIdArea(String idArea) {
		this.idArea = idArea;
	}
	public String getNivelArea() {
		return nivelArea;
	}
	public void setNivelArea(String nivelArea) {
		this.nivelArea = nivelArea;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getEstatus() {
		return estatus;
	}
	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}
	@Override
	public String toString() {
		return "Areas [idArea=" + idArea + ", nivelArea=" + nivelArea + ", descripcion=" + descripcion + ", estatus="
				+ estatus + ", totalEmpleados=" + totalEmpleados + ", empleadosEvaluados=" + empleadosEvaluados
				+ ", empleadosNoEvaluados=" + empleadosNoEvaluados + "]";
	}
	
}
