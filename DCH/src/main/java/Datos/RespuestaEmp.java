package Datos;

public class RespuestaEmp {
	private String nombre;
	private String puesto;
	private double promedio;
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getPuesto() {
		return puesto;
	}
	public void setPuesto(String puesto) {
		this.puesto = puesto;
	}
	public double getPromedio() {
		return promedio;
	}
	public void setPromedio(double promedio) {
		this.promedio = promedio;
	}
	@Override
	public String toString() {
		return "RespuestaEmp [nombre=" + nombre + ", puesto=" + puesto + ", promedio=" + promedio + "]";
	}
}
