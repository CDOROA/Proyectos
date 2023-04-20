package Datos;

public class Evaluado {
	private String idEmpleado;
	private String area;
	private String nombreEvaluado;
	private String jefeInmediato;
	private String subordinado;
	private String colega;
	private String cliente;
	
	
	
	
	
	public String getIdEmpleado() {
		return idEmpleado;
	}
	public void setIdEmpleado(String idEmpleado) {
		this.idEmpleado = idEmpleado;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getNombreEvaluado() {
		return nombreEvaluado;
	}
	public void setNombreEvaluado(String nombreEvaluado) {
		this.nombreEvaluado = nombreEvaluado;
	}
	public String getJefeInmediato() {
		return jefeInmediato;
	}
	public void setJefeInmediato(String jefeInmediato) {
		this.jefeInmediato = jefeInmediato;
	}
	public String getSubordinado() {
		return subordinado;
	}
	public void setSubordinado(String subordinado) {
		this.subordinado = subordinado;
	}
	public String getColega() {
		return colega;
	}
	public void setColega(String colega) {
		this.colega = colega;
	}
	public String getCliente() {
		return cliente;
	}
	public void setCliente(String cliente) {
		this.cliente = cliente;
	}
	@Override
	public String toString() {
		return "Evaluado [idEmpleado=" + idEmpleado + ", area=" + area + ", nombreEvaluado=" + nombreEvaluado
				+ ", jefeInmediato=" + jefeInmediato + ", subordinado=" + subordinado + ", colega=" + colega
				+ ", cliente=" + cliente + "]";
	}
	
}
