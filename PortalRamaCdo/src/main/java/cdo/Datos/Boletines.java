package cdo.Datos;

import java.io.Serializable;

public class Boletines  implements Serializable
{
	private static final long serialVersionUID = 1L;
	private int id_boletin;
	private String nombre_boletin;
	private String imagen_boletin;
	private String fecha_inicio;
	private String fecha_fin;
	
	public Boletines() {
		super();
	}

	public Boletines(int id_boletin, String nombre_boletin, String imagen_boletin, String fecha_inicio,
			String fecha_fin) {
		super();
		this.id_boletin = id_boletin;
		this.nombre_boletin = nombre_boletin;
		this.imagen_boletin = imagen_boletin;
		this.fecha_inicio = fecha_inicio;
		this.fecha_fin = fecha_fin;
	}

	public int getId_boletin() {
		return id_boletin;
	}

	public void setId_boletin(int id_boletin) {
		this.id_boletin = id_boletin;
	}

	public String getNombre_boletin() {
		return nombre_boletin;
	}

	public void setNombre_boletin(String nombre_boletin) {
		this.nombre_boletin = nombre_boletin;
	}

	public String getImagen_boletin() {
		return imagen_boletin;
	}

	public void setImagen_boletin(String imagen_boletin) {
		this.imagen_boletin = imagen_boletin;
	}

	public String getFecha_inicio() {
		return fecha_inicio;
	}

	public void setFecha_inicio(String fecha_inicio) {
		this.fecha_inicio = fecha_inicio;
	}

	public String getFecha_fin() {
		return fecha_fin;
	}

	public void setFecha_fin(String fecha_fin) {
		this.fecha_fin = fecha_fin;
	}

	@Override
	public String toString() {
		return "Boletines [id_boletin=" + id_boletin + ", nombre_boletin=" + nombre_boletin + ", imagen_boletin="
				+ imagen_boletin + ", fecha_inicio=" + fecha_inicio + ", fecha_fin=" + fecha_fin + "]";
	}

}
