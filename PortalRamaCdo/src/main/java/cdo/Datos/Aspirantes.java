package cdo.Datos;

import java.io.Serializable;

public class Aspirantes implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private String nombre;
	private String a_paterno;
	private String a_materno;
	private String e_mail;
	private int edad;
	private String telefono;
	private String genero;
	private int id_nivel_ac; 
	private int id_cve_edo;
	private int id_cve_empresa;
	private int id_vacante;
	private String nombre_vacante;
	private String nombre_nAcademico;
	private String nombre_Estado;
	private int Estatus;
	private String codigoCv;
	
	public Aspirantes() {
		super();
	}
	
	public Aspirantes(String nombre, String a_paterno, String a_materno, String e_mail, int edad, String telefono,
			String genero, int id_nivel_ac, int id_cve_edo, int id_cve_empresa, int id_vacante, String nombre_vacante,
			String nombre_nAcademico, String nombre_Estado, int estatus, String codigoCv) {
		super();
		this.nombre = nombre;
		this.a_paterno = a_paterno;
		this.a_materno = a_materno;
		this.e_mail = e_mail;
		this.edad = edad;
		this.telefono = telefono;
		this.genero = genero;
		this.id_nivel_ac = id_nivel_ac;
		this.id_cve_edo = id_cve_edo;
		this.id_cve_empresa = id_cve_empresa;
		this.id_vacante = id_vacante;
		this.nombre_vacante = nombre_vacante;
		this.nombre_nAcademico = nombre_nAcademico;
		this.nombre_Estado = nombre_Estado;
		Estatus = estatus;
		this.codigoCv = codigoCv;
	}
	


	public Aspirantes(String nombre, String a_paterno, String a_materno, String e_mail, int edad, String telefono,
			String genero, int id_nivel_ac, int id_cve_edo, int id_cve_empresa, int id_vacante, String nombre_vacante,
			String nombre_nAcademico, String nombre_Estado) {
		super();
		this.nombre = nombre;
		this.a_paterno = a_paterno;
		this.a_materno = a_materno;
		this.e_mail = e_mail;
		this.edad = edad;
		this.telefono = telefono;
		this.genero = genero;
		this.id_nivel_ac = id_nivel_ac;
		this.id_cve_edo = id_cve_edo;
		this.id_cve_empresa = id_cve_empresa;
		this.id_vacante = id_vacante;
		this.nombre_vacante = nombre_vacante;
		this.nombre_nAcademico = nombre_nAcademico;
		this.nombre_Estado = nombre_Estado;
	}

	public int getEstatus() {
		return Estatus;
	}

	public void setEstatus(int estatus) {
		Estatus = estatus;
	}

	public String getCodigoCv() {
		return codigoCv;
	}

	public void setCodigoCv(String codigoCv) {
		this.codigoCv = codigoCv;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getA_paterno() {
		return a_paterno;
	}

	public void setA_paterno(String a_paterno) {
		this.a_paterno = a_paterno;
	}

	public String getA_materno() {
		return a_materno;
	}

	public void setA_materno(String a_materno) {
		this.a_materno = a_materno;
	}

	public String getE_mail() {
		return e_mail;
	}

	public void setE_mail(String e_mail) {
		this.e_mail = e_mail;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public int getId_nivel_ac() {
		return id_nivel_ac;
	}

	public void setId_nivel_ac(int id_nivel_ac) {
		this.id_nivel_ac = id_nivel_ac;
	}

	public int getId_cve_edo() {
		return id_cve_edo;
	}

	public void setId_cve_edo(int id_cve_edo) {
		this.id_cve_edo = id_cve_edo;
	}

	public int getId_cve_empresa() {
		return id_cve_empresa;
	}

	public void setId_cve_empresa(int id_cve_empresa) {
		this.id_cve_empresa = id_cve_empresa;
	}

	public int getId_vacante() {
		return id_vacante;
	}

	public void setId_vacante(int id_vacante) {
		this.id_vacante = id_vacante;
	}

	public String getNombre_vacante() {
		return nombre_vacante;
	}

	public void setNombre_vacante(String nombre_vacante) {
		this.nombre_vacante = nombre_vacante;
	}

	public String getNombre_nAcademico() {
		return nombre_nAcademico;
	}

	public void setNombre_nAcademico(String nombre_nAcademico) {
		this.nombre_nAcademico = nombre_nAcademico;
	}

	public String getNombre_Estado() {
		return nombre_Estado;
	}

	public void setNombre_Estado(String nombre_Estado) {
		this.nombre_Estado = nombre_Estado;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Aspirantes [nombre=" + nombre + ", a_paterno=" + a_paterno + ", a_materno=" + a_materno + ", e_mail="
				+ e_mail + ", edad=" + edad + ", telefono=" + telefono + ", genero=" + genero + ", id_nivel_ac="
				+ id_nivel_ac + ", id_cve_edo=" + id_cve_edo + ", id_cve_empresa=" + id_cve_empresa + ", id_vacante="
				+ id_vacante + ", nombre_vacante=" + nombre_vacante + ", nombre_nAcademico=" + nombre_nAcademico
				+ ", nombre_Estado=" + nombre_Estado + ", Estatus=" + Estatus + ", codigoCv=" + codigoCv + "]";
	}

	
	
}
