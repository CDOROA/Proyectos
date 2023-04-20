package cdo.Datos;

import java.sql.Time;

public class EjecDemonios {
	
	private String uname;
	private String idPrograma;
	private Time horaIni;
	private Time horaFin;
	private Time horaSabadoIni;
	private Time horaSabadoFin;
	private String estatus;
	

	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getIdPrograma() {
		return idPrograma;
	}
	public void setIdPrograma(String idPrograma) {
		this.idPrograma = idPrograma;
	}
	public Time getHoraIni() {
		return horaIni;
	}
	public void setHoraIni(Time horaIni) {
		this.horaIni = horaIni;
	}
	public Time getHoraFin() {
		return horaFin;
	}
	public void setHoraFin(Time horaFin) {
		this.horaFin = horaFin;
	}
	public Time getHoraSabadoIni() {
		return horaSabadoIni;
	}
	public void setHoraSabadoIni(Time horaSabadoIni) {
		this.horaSabadoIni = horaSabadoIni;
	}
	public Time getHoraSabadoFin() {
		return horaSabadoFin;
	}
	public void setHoraSabadoFin(Time horaSabadoFin) {
		this.horaSabadoFin = horaSabadoFin;
	}
	public String getEstatus() {
		return estatus;
	}
	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}
	
	@SuppressWarnings("deprecation")
	public EjecDemonios() {
		super();
		this.uname = "";
		this.idPrograma = "";
		this.horaIni = new Time(0, 0, 0);
		this.horaFin =  new Time(0, 0, 0);
		this.horaSabadoIni = new Time(0, 0, 0);
		this.horaSabadoFin =  new Time(0, 0, 0);
		this.estatus ="";
	}
	
	
	@Override
	public String toString() {
		return "EjecDemonios [uname=" + uname + ", idPrograma=" + idPrograma + ", horaIni=" + horaIni + ", horaFin="
				+ horaFin + ", horaSabadoIni=" + horaSabadoIni + ", horaSabadoFin=" + horaSabadoFin + ", estatus="
				+ estatus + "]";
	}

}
