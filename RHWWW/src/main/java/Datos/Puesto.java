package Datos;

public class Puesto {
	private int idPuesto;
	private String nombrePuesto;
	
	public int getIdPuesto() {
		return idPuesto;
	}
	public void setIdPuesto(int idPuesto) {
		this.idPuesto = idPuesto;
	}
	public String getNombrePuesto() {
		return nombrePuesto;
	}
	public void setNombrePuesto(String nombrePuesto) {
		this.nombrePuesto = nombrePuesto;
	}
	
	public Puesto( ) {
		super();
		this.idPuesto = 0;
		this.nombrePuesto = "";
	}
	
	@Override
	public String toString() {
		return "Puesto [idPuesto=" + idPuesto + ", nombrePuesto=" + nombrePuesto + "]";
	}
	
}
