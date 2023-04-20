package Datos;

public class Vacante {
	private int idVacante;
	private int cveEmpresa;
	private String nombreEmpresa;
	private int idPuesto;
	private String nombrePuesto;
	private String descripcionVacante;
	private String horarioVacante;
	private String lugarTrabajo;
	private String fechaPublicacion;
	private String observaciones;
	private int idEstado;
	private String nombreEstaso;
	private int estatus;
 
	public int getIdVacante() {
		return idVacante;
	}
	public void setIdVacante(int idVacante) {
		this.idVacante = idVacante;
	}

	public int getCveEmpresa() {
		return cveEmpresa;
	}
	public void setCveEmpresa(int cveEmpresa) {
		this.cveEmpresa = cveEmpresa;
	}

	public String getNombreEmpresa() {
		return nombreEmpresa;
	}
	public void setNombreEmpresa(String nombreEmpresa) {
		this.nombreEmpresa = nombreEmpresa;
	}

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

	public String getDescripcionVacante() {
		return descripcionVacante;
	}
	public void setDescripcionVacante(String descripcionVacante) {
		this.descripcionVacante = descripcionVacante;
	}

	public String getHorarioVacante() {
		return horarioVacante;
	}
	public void setHorarioVacante(String horarioVacante) {
		this.horarioVacante = horarioVacante;
	}

	public String getLugarTrabajo() {
		return lugarTrabajo;
	}
	public void setLugarTrabajo(String lugarTrabajo) {
		this.lugarTrabajo = lugarTrabajo;
	}

	public String getFechaPublicacion() {
		return fechaPublicacion;
	}
	public void setFechaPublicacion(String fechaPublicacion) {
		this.fechaPublicacion = fechaPublicacion;
	}

	public String getObservaciones() {
		return observaciones;
	}
	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public int getIdEstado() {
		return idEstado;
	}
	public void setIdEstado(int idEstado) {
		this.idEstado = idEstado;
	}

	public String getNombreEstaso() {
		return nombreEstaso;
	}
	public void setNombreEstaso(String nombreEstaso) {
		this.nombreEstaso = nombreEstaso;
	}

	public int getEstatus() {
		return estatus;
	}
	public void setEstatus(int estatus) {
		this.estatus = estatus;
	}

	public Vacante() {
		super();
		this.idVacante = 0;
		this.cveEmpresa = 0;
		this.nombreEmpresa="";
		this.idPuesto = 0;
		this.nombrePuesto = "";
		this.descripcionVacante = "";
		this.horarioVacante = "";
		this.lugarTrabajo = "";
		this.fechaPublicacion = "";
		this.observaciones = "";
		this.idEstado = 0;
		this.nombreEstaso = "";
		this.estatus = 0;
	}
	
	@Override
	public String toString() {
		return "Vacante [idVacante=" + idVacante + ", cveEmpresa=" + cveEmpresa + ", nombreEmpresa=" + nombreEmpresa
				+ ", idPuesto=" + idPuesto + ", nombrePuesto=" + nombrePuesto + ", descripcionVacante="
				+ descripcionVacante + ", horarioVacante=" + horarioVacante + ", lugarTrabajo=" + lugarTrabajo
				+ ", fechaPublicacion=" + fechaPublicacion + ", observaciones=" + observaciones + ", idEstado="
				+ idEstado + ", nombreEstaso=" + nombreEstaso + ", estatus=" + estatus + "]";
	}

}
