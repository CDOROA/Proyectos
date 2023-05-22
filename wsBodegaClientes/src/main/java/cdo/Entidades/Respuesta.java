package cdo.Entidades;

import java.io.Serializable;
import java.util.ArrayList;

@SuppressWarnings("serial")
public class Respuesta implements Serializable
{
	private int registros = 0;
	private String msjRespuesta;
	private ArrayList<Bodega>datos;
	private int status;
	public Respuesta() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Respuesta(int registros, String msjRespuesta, ArrayList<Bodega> datos, int status) {
		super();
		this.registros = registros;
		this.msjRespuesta = msjRespuesta;
		this.datos = datos;
		this.status = status;
	}
	public int getRegistros() {
		return registros;
	}
	public void setRegistros(int registros) {
		this.registros = registros;
	}
	public String getMsjRespuesta() {
		return msjRespuesta;
	}
	public void setMsjRespuesta(String msjRespuesta) {
		this.msjRespuesta = msjRespuesta;
	}
	public ArrayList<Bodega> getDatos() {
		return datos;
	}
	public void setDatos(ArrayList<Bodega> datos) {
		this.datos = datos;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Respuesta [registros=" + registros + ", msjRespuesta=" + msjRespuesta + ", datos=" + datos + ", status="
				+ status + "]";
	}
	
	
}
