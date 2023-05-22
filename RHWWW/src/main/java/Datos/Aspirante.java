package Datos;

public class Aspirante extends Vacante{
	private int idAspirante;
	private String nombre;
	private String email;
	private String edad;
	private String genero;
	private String telefono;
	private String descriocionNivelEstudios;
	private String nombreEstado;
	private String descripcionEmpresa;
	private String fechaRegistro;
	private String codigoCv;
	private String status;
	private String nombrePuesto;
	
	
	public Aspirante(int idAspirante, String status) {
		this.idAspirante = idAspirante;
		this.status = status;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public int getIdAspirante() {
		return idAspirante;
	}
	public void setIdAspirante(int idAspirante) {
		this.idAspirante = idAspirante;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getEdad() {
		return edad;
	}
	public void setEdad(String edad) {
		this.edad = edad;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public String getDescriocionNivelEstudios() {
		return descriocionNivelEstudios;
	}
	public void setDescriocionNivelEstudios(String descriocionNivelEstudios) {
		this.descriocionNivelEstudios = descriocionNivelEstudios;
	}
	public String getNombreEstado() {
		return nombreEstado;
	}
	public void setNombreEstado(String nombreEstado) {
		this.nombreEstado = nombreEstado;
	}
	public String getDescripcionEmpresa() {
		return descripcionEmpresa;
	}
	public void setDescripcionEmpresa(String descripcionEmpresa) {
		this.descripcionEmpresa = descripcionEmpresa;
	}
	public String getFechaRegistro() {
		return fechaRegistro;
	}
	public void setFechaRegistro(String fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}
	public String getCodigoCv() {
		return codigoCv;
	}
	public void setCodigoCv(String codigoCv) {
		this.codigoCv = codigoCv;
	}
	public String getNombrePuesto() {
		return nombrePuesto;
	}
	public void setNombrePuesto(String nombrePuesto) {
		this.nombrePuesto = nombrePuesto;
	}
	
	public Aspirante() {
		super();
		this.idAspirante = 0;
		this.nombre = "";
		this.email = "";
		this.edad = "";
		this.genero = "";
		this.descriocionNivelEstudios = "";
		this.nombreEstado = "";
		this.descripcionEmpresa = "";
		this.fechaRegistro = "";
		this.codigoCv = "";
		this.nombrePuesto = "";
		this.status="";
		this.telefono="";
	}
	@Override
	public String toString() {
		return "Aspirante [idAspirante=" + idAspirante + ", nombre=" + nombre + ", email=" + email + ", edad=" + edad
				+ ", genero=" + genero + ", telefono=" + telefono 
				+ ", descriocionNivelEstudios=" + descriocionNivelEstudios
				+ ", nombreEstado=" + nombreEstado + ", idCveEmpresa="  + ", descripcionEmpresa="
				+ descripcionEmpresa + ", fechaRegistro=" + fechaRegistro + ", codigoCv=" + codigoCv + ", status="
				+ status +  ", nombrePuesto=" + nombrePuesto + "]";
	}
	
}
