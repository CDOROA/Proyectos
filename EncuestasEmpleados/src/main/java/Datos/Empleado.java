package Datos;

import java.util.Date;

public class Empleado {
	private String idEmpleado;
	private String noEmpleado;
	private String nombreCompleto;
	private String curp;
	private String edad;
	private String puesto;
	private Date fechaIngreso;
	private String area;
	private String perfil;
	private String empresa;
	

	public Empleado(String idEmpleado, String noEmpleado, String nombreCompleto, String curp, String edad, String puesto,
			Date fechaIngreso, String area, String perfil, String empresa) {
		super();
		this.idEmpleado = idEmpleado;
		this.noEmpleado = noEmpleado;
		this.nombreCompleto = nombreCompleto;
		this.curp = curp;
		this.edad = edad;
		this.puesto = puesto;
		this.fechaIngreso = fechaIngreso;
		this.area = area;
		this.perfil = perfil;
		this.empresa = empresa;
	}
	
	public Empleado() {
		super();
	}
	
	

	public String getNoEmpleado() {
		return noEmpleado;
	}

	public void setNoEmpleado(String noEmpleado) {
		this.noEmpleado = noEmpleado;
	}

	public String getIdEmpleado() {
		return idEmpleado;
	}
	public void setIdEmpleado(String idEmpleado) {
		this.idEmpleado = idEmpleado;
	}
	
	public String getNombreCompleto() {
		return nombreCompleto;
	}
	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}
	public String getCurp() {
		return curp;
	}
	public void setCurp(String curp) {
		this.curp = curp;
	}
	public String getEdad() {
		return edad;
	}
	public void setEdad(String edad) {
		this.edad = edad;
	}
	public String getPuesto() {
		return puesto;
	}
	public void setPuesto(String puesto) {
		this.puesto = puesto;
	}
	public Date getFechaIngreso() {
		return fechaIngreso;
	}
	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getPerfil() {
		return perfil;
	}
	public void setPerfil(String perfil) {
		this.perfil = perfil;
	}

	public String getEmpresa() {
		return empresa;
	}

	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}

	@Override
	public String toString() {
		return "Empleado [idEmpleado=" + idEmpleado + ", noEmpleado=" + noEmpleado + ", nombreCompleto="
				+ nombreCompleto + ", curp=" + curp + ", edad=" + edad + ", puesto=" + puesto + ", fechaIngreso="
				+ fechaIngreso + ", area=" + area + ", perfil=" + perfil + ", empresa=" + empresa + "]";
	}

	
	
}
