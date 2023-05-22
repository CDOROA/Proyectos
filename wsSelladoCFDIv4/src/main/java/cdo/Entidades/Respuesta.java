package cdo.Entidades;

import java.io.Serializable;
import java.util.List;

@SuppressWarnings("serial")
public class Respuesta implements Serializable
{
	private boolean respuesa = true;
	private String mensaje;
	private String documento;
	private String tipo;
	private List<String> detalle;
	public Respuesta() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Respuesta(boolean respuesa, String mensaje, String documento, String tipo, List<String> detalle) {
		super();
		this.respuesa = respuesa;
		this.mensaje = mensaje;
		this.documento = documento;
		this.tipo = tipo;
		this.detalle = detalle;
	}
	public boolean isRespuesa() {
		return respuesa;
	}
	public void setRespuesa(boolean respuesa) {
		this.respuesa = respuesa;
	}
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	public String getDocumento() {
		return documento;
	}
	public void setDocumento(String documento) {
		this.documento = documento;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public List<String> getDetalle() {
		return detalle;
	}
	public void setDetalle(List<String> detalle) {
		this.detalle = detalle;
	}
	
}
