package cdo.Entidades;

import java.io.Serializable;

@SuppressWarnings("serial")
public class AutoTransporte extends Identificadores implements Serializable 
{
	private String num_poliza;
	private String nombre_aseguradora; 
	private String num_permiso; 
	private String permiso;
	private String anio_modelo; 
	private String placas; 
	private String config_vehicular;
	public AutoTransporte() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AutoTransporte(String uname, String folio, String serie, String carta_porte) {
		super(uname, folio, serie, carta_porte);
		// TODO Auto-generated constructor stub
	}
	public AutoTransporte(String num_poliza, String nombre_aseguradora, String num_permiso, String permiso,
			String anio_modelo, String placas, String config_vehicular) {
		super();
		this.num_poliza = num_poliza;
		this.nombre_aseguradora = nombre_aseguradora;
		this.num_permiso = num_permiso;
		this.permiso = permiso;
		this.anio_modelo = anio_modelo;
		this.placas = placas;
		this.config_vehicular = config_vehicular;
	}
	public String getNum_poliza() {
		return num_poliza;
	}
	public void setNum_poliza(String num_poliza) {
		this.num_poliza = num_poliza;
	}
	public String getNombre_aseguradora() {
		return nombre_aseguradora;
	}
	public void setNombre_aseguradora(String nombre_aseguradora) {
		this.nombre_aseguradora = nombre_aseguradora;
	}
	public String getNum_permiso() {
		return num_permiso;
	}
	public void setNum_permiso(String num_permiso) {
		this.num_permiso = num_permiso;
	}
	public String getPermiso() {
		return permiso;
	}
	public void setPermiso(String permiso) {
		this.permiso = permiso;
	}
	public String getAnio_modelo() {
		return anio_modelo;
	}
	public void setAnio_modelo(String anio_modelo) {
		this.anio_modelo = anio_modelo;
	}
	public String getPlacas() {
		return placas;
	}
	public void setPlacas(String placas) {
		this.placas = placas;
	}
	public String getConfig_vehicular() {
		return config_vehicular;
	}
	public void setConfig_vehicular(String config_vehicular) {
		this.config_vehicular = config_vehicular;
	}
	@Override
	public String toString() {
		return "AutoTransporte [num_poliza=" + num_poliza + ", nombre_aseguradora=" + nombre_aseguradora
				+ ", num_permiso=" + num_permiso + ", permiso=" + permiso + ", anio_modelo=" + anio_modelo + ", placas="
				+ placas + ", config_vehicular=" + config_vehicular + "]";
	}

	
}
