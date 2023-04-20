package datos;

public class Banners {
	
	int id_banners;
	String nombre;
	String imagen;
	int duracion;
	int num_orden;
		
	public int getId_banners() {
		return id_banners;
	}
	public void setId_banners(int id_banners) {
		this.id_banners = id_banners;
	}
	
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
	public String getImagen() {
		return imagen;
	}
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	
	
	public int getDuracion() {
		return duracion;
	}
	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}
	
	
	public int getNum_orden() {
		return num_orden;
	}
	public void setNum_orden(int num_orden) {
		this.num_orden = num_orden;
	}
	
	@Override
	public String toString() {
		return "BannersDto [id_banners=" + id_banners + ", nombre=" + nombre + ", imagen=" + imagen + ", duracion="
				+ duracion + ", num_orden=" + num_orden + "]";
	}
}
