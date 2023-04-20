package Datos;

public class Empleado {
	private String fechaIngreso;
	private String uname;
	private String nombre;
	private String area;
	private String tipoEncuesta;
	private String puesto;
	private String depto;
	private String subdepto;
	private String correo;
	private String idEmpleado;
	private String idTipoEncuesta;
	
	public Empleado() {
		super();
	}

	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	
	
	public String getIdTipoEncuesta() {
		return idTipoEncuesta;
	}

	public void setIdTipoEncuesta(String idTipoEncuesta) {
		this.idTipoEncuesta = idTipoEncuesta;
	}

	public String getIdEmpleado() {
		return idEmpleado;
	}

	public void setIdEmpleado(String idEmpleado) {
		this.idEmpleado = idEmpleado;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(String fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getArea() {
		return area;
	}



	public void setArea(String area) {
		this.area = area;
	}



	public String getTipoEncuesta() {
		return tipoEncuesta;
	}



	public void setTipoEncuesta(String tipoEncuesta) {
		this.tipoEncuesta = tipoEncuesta;
	}



	public String getPuesto() {
		return puesto;
	}



	public void setPuesto(String puesto) {
		this.puesto = puesto;
	}



	public String getDepto() {
		return depto;
	}



	public void setDepto(String depto) {
		this.depto = depto;
	}



	public String getSubdepto() {
		return subdepto;
	}



	public void setSubdepto(String subdepto) {
		this.subdepto = subdepto;
	}



	@Override
	public String toString() {
		return "Empleado [nombre=" + nombre + ", area=" + area + ", tipoEncuesta=" + tipoEncuesta + ", puesto=" + puesto
				+ ", depto=" + depto + ", subdepto=" + subdepto + "]";
	}
	
	
}
