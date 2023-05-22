package Datos;

public class Seguimiento {
	private String puesto;
	private String departamento;
	private int totalEncuestas;
	private String nombre;
	private String idEmpleado;
	private int totalEncuestasTerm;
	private String estatus;
	
	
	
	
	public String getEstatus() {
		return estatus;
	}
	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}
	public int getTotalEncuestasTerm() {
		return totalEncuestasTerm;
	}
	public void setTotalEncuestasTerm(int totalEncuestasTerm) {
		this.totalEncuestasTerm = totalEncuestasTerm;
	}
	public int getTotalEncuestas() {
		return totalEncuestas;
	}
	public void setTotalEncuestas(int totalEncuestas) {
		this.totalEncuestas = totalEncuestas;
	}
	public String getNombre() {
		return nombre;
	}
	public String getPuesto() {
		return puesto;
	}
	public void setPuesto(String puesto) {
		this.puesto = puesto;
	}
	public String getDepartamento() {
		return departamento;
	}
	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getIdEmpleado() {
		return idEmpleado;
	}
	public void setIdEmpleado(String idEmpleado) {
		this.idEmpleado = idEmpleado;
	}
	
	
	@Override
	public String toString() {
		return "Seguimiento [puesto=" + puesto + ", departamento=" + departamento + ", totalEncuestas=" + totalEncuestas
				+ ", nombre=" + nombre + ", idEmpleado=" + idEmpleado + ", totalEncuestasTerm=" + totalEncuestasTerm
				+ ", estatus=" + estatus + "]";
	}
}
