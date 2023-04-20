package cdo.Datos;

import java.io.Serializable;

public class Sucursales  implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private int cve_empresa;
	private int cve_estado;
	private String nombre;
	private String direccion;
	private String telefono;
	private String email;
	private String url;
	private String latitud;
	private String longitud;
	private String cobertura; 
	
	public Sucursales() {
		super();
	}

	public Sucursales(int cve_empresa, int cve_estado, String nombre, String direccion, String telefono, String email,
			String url, String latitud, String longitud, String cobertura) {
		super();
		this.cve_empresa = cve_empresa;
		this.cve_estado = cve_estado;
		this.nombre = nombre;
		this.direccion = direccion;
		this.telefono = telefono;
		this.email = email;
		this.url = url;
		this.latitud = latitud;
		this.longitud = longitud;
		this.cobertura = cobertura;
	}

	public int getCve_empresa() {
		return cve_empresa;
	}

	public void setCve_empresa(int cve_empresa) {
		this.cve_empresa = cve_empresa;
	}

	public int getCve_estado() {
		return cve_estado;
	}

	public void setCve_estado(int cve_estado) {
		this.cve_estado = cve_estado;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getLatitud() {
		return latitud;
	}

	public void setLatitud(String latitud) {
		this.latitud = latitud;
	}

	public String getLongitud() {
		return longitud;
	}

	public void setLongitud(String longitud) {
		this.longitud = longitud;
	}

	public String getCobertura() {
		return cobertura;
	}

	public void setCobertura(String cobertura) {
		this.cobertura = cobertura;
	}

	@Override
	public String toString() {
		return "Sucursales [cve_empresa=" + cve_empresa + ", cve_estado=" + cve_estado + ", nombre=" + nombre
				+ ", direccion=" + direccion + ", telefono=" + telefono + ", email=" + email + ", url=" + url
				+ ", latitud=" + latitud + ", longitud=" + longitud + ", cobertura=" + cobertura + "]";
	}
	
}
