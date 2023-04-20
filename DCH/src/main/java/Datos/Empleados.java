package Datos;

public class Empleados {
	private String idEmpleado;
	private String nombre;
	private String noEmpleado;
	private String idPuesto;
	private String jerarquia;
	private String idArea;
	private String nombreArea;
	
	public Empleados() {
		super();
	}
	
	
	
	public String getJerarquia() {
		return jerarquia;
	}


	
	public String getNombreArea() {
		return nombreArea;
	}



	public void setNombreArea(String nombreArea) {
		this.nombreArea = nombreArea;
	}



	public void setJerarquia(String jerarquia) {
		this.jerarquia = jerarquia;
	}



	public String getIdEmpleado() {
		return idEmpleado;
	}
	public void setIdEmpleado(String idEmpleado) {
		this.idEmpleado = idEmpleado;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getNoEmpleado() {
		return noEmpleado;
	}
	public void setNoEmpleado(String noEmpleado) {
		this.noEmpleado = noEmpleado;
	}
	public String getIdPuesto() {
		return idPuesto;
	}
	public void setIdPuesto(String idPuesto) {
		this.idPuesto = idPuesto;
	}
	public String getIdArea() {
		return idArea;
	}
	public void setIdArea(String idArea) {
		this.idArea = idArea;
	}



	@Override
	public String toString() {
		return "Empleados [idEmpleado=" + idEmpleado + ", nombre=" + nombre + ", noEmpleado=" + noEmpleado
				+ ", idPuesto=" + idPuesto + ", jerarquia=" + jerarquia + ", idArea=" + idArea + ", nombreArea="
				+ nombreArea + "]";
	}

	

}
