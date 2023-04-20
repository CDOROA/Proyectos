package cdo.Datos;

public class Detalles {
	private String serie;
	private String folio;
	private String descripcion;
	private String fecha;
	private String hora;
	
	
	
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public String getHora() {
		return hora;
	}
	public void setHora(String hora) {
		this.hora = hora;
	}
	public String getSerie() {
		return serie;
	}
	public void setSerie(String serie) {
		this.serie = serie;
	}
	public String getFolio() {
		return folio;
	}
	public void setFolio(String folio) {
		this.folio = folio;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	@Override
	public String toString() {
		return "Detalles [serie=" + serie + ", folio=" + folio + ", descripcion=" + descripcion + ", fecha=" + fecha
				+ ", hora=" + hora + "]";
	}
	
	
}
