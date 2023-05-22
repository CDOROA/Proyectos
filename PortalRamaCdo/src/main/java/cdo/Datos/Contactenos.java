package cdo.Datos;

import java.io.Serializable;

public class Contactenos implements Serializable{

	private static final long serialVersionUID = 1L;
	private String nombre;
	private String apellido_paterno;
	private String apellido_materno;
	private String telefono;
	private String correo;
	private int es_cliente_cdo;
	private int id_cve_estado;
	private String  nombre_estado;
	private int num_cli;
	private String uname_br;
	private String mensaje;
	private int tipoNegocio;
	private String nombreTipoNegocio;
		
	public Contactenos() {
		super();
	}

	public Contactenos(String nombre, String apellido_paterno, String apellido_materno, String telefono, String correo,
			int es_cliente_cdo, int id_cve_estado, String nombre_estado, int num_cli, String uname_br, String mensaje,
			int tipoNegocio, String nombreTipoNegocio) {
		super();
		this.nombre = nombre;
		this.apellido_paterno = apellido_paterno;
		this.apellido_materno = apellido_materno;
		this.telefono = telefono;
		this.correo = correo;
		this.es_cliente_cdo = es_cliente_cdo;
		this.id_cve_estado = id_cve_estado;
		this.nombre_estado = nombre_estado;
		this.num_cli = num_cli;
		this.uname_br = uname_br;
		this.mensaje = mensaje;
		this.tipoNegocio = tipoNegocio;
		this.nombreTipoNegocio = nombreTipoNegocio;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido_paterno() {
		return apellido_paterno;
	}

	public void setApellido_paterno(String apellido_paterno) {
		this.apellido_paterno = apellido_paterno;
	}

	public String getApellido_materno() {
		return apellido_materno;
	}

	public void setApellido_materno(String apellido_materno) {
		this.apellido_materno = apellido_materno;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public int getEs_cliente_cdo() {
		return es_cliente_cdo;
	}

	public void setEs_cliente_cdo(int es_cliente_cdo) {
		this.es_cliente_cdo = es_cliente_cdo;
	}

	public int getId_cve_estado() {
		return id_cve_estado;
	}

	public void setId_cve_estado(int id_cve_estado) {
		this.id_cve_estado = id_cve_estado;
	}

	public String getNombre_estado() {
		return nombre_estado;
	}

	public void setNombre_estado(String nombre_estado) {
		this.nombre_estado = nombre_estado;
	}

	public int getNum_cli() {
		return num_cli;
	}

	public void setNum_cli(int num_cli) {
		this.num_cli = num_cli;
	}

	public String getUname_br() {
		return uname_br;
	}

	public void setUname_br(String uname_br) {
		this.uname_br = uname_br;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public int getTipoNegocio() {
		return tipoNegocio;
	}

	public void setTipoNegocio(int tipoNegocio) {
		this.tipoNegocio = tipoNegocio;
	}

	public String getNombreTipoNegocio() {
		return nombreTipoNegocio;
	}

	public void setNombreTipoNegocio(String nombreTipoNegocio) {
		this.nombreTipoNegocio = nombreTipoNegocio;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Contactenos [nombre=" + nombre + ", apellido_paterno=" + apellido_paterno + ", apellido_materno="
				+ apellido_materno + ", telefono=" + telefono + ", correo=" + correo + ", es_cliente_cdo="
				+ es_cliente_cdo + ", id_cve_estado=" + id_cve_estado + ", nombre_estado=" + nombre_estado
				+ ", num_cli=" + num_cli + ", uname_br=" + uname_br + ", mensaje=" + mensaje + ", tipoNegocio="
				+ tipoNegocio + ", nombreTipoNegocio=" + nombreTipoNegocio + "]";
	}
}
