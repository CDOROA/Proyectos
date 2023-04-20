package Datos;

public class SeguimientoDetalle {
	private int totalPreguntas;
	private String idEmpleadoEv;
	private String nombre;
	private String estatus;
	private String fechaInicio;
	private String fechaFin;
	private String puesto;
	private String perfil;
	private int preguntasContestadas;
	
	public int getTotalPreguntas() {
		return totalPreguntas;
	}
	public void setTotalPreguntas(int totalPreguntas) {
		this.totalPreguntas = totalPreguntas;
	}
	public String getIdEmpleadoEv() {
		return idEmpleadoEv;
	}
	public void setIdEmpleadoEv(String idEmpleadoEv) {
		this.idEmpleadoEv = idEmpleadoEv;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getEstatus() {
		return estatus;
	}
	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}
	public String getFechaInicio() {
		return fechaInicio;
	}
	public void setFechaInicio(String fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	public String getFechaFin() {
		return fechaFin;
	}
	public void setFechaFin(String fechaFin) {
		this.fechaFin = fechaFin;
	}
	public String getPuesto() {
		return puesto;
	}
	public void setPuesto(String puesto) {
		this.puesto = puesto;
	}
	public String getPerfil() {
		return perfil;
	}
	public void setPerfil(String perfil) {
		this.perfil = perfil;
	}
	public int getPreguntasContestadas() {
		return preguntasContestadas;
	}
	public void setPreguntasContestadas(int preguntasContestadas) {
		this.preguntasContestadas = preguntasContestadas;
	}
	@Override
	public String toString() {
		return "SeguimientoDetalle [totalPreguntas=" + totalPreguntas + ", idEmpleadoEv=" + idEmpleadoEv + ", nombre="
				+ nombre + ", estatus=" + estatus + ", fechaInicio=" + fechaInicio + ", fechaFin=" + fechaFin
				+ ", puesto=" + puesto + ", perfil=" + perfil + ", preguntasContestadas=" + preguntasContestadas + "]";
	}
}
