package cdo.Datos;

import java.io.Serializable;

public class Catalogo_Motivos_Cancelacion  implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private int id_motivo_cancelacion;
	private String motivo_cancelacion;
	
	public Catalogo_Motivos_Cancelacion() {
		super();
	}

	public Catalogo_Motivos_Cancelacion(int id_motivo_cancelacion, String motivo_cancelacion) {
		super();
		this.id_motivo_cancelacion = id_motivo_cancelacion;
		this.motivo_cancelacion = motivo_cancelacion;
	}

	public int getId_motivo_cancelacion() {
		return id_motivo_cancelacion;
	}

	public void setId_motivo_cancelacion(int id_motivo_cancelacion) {
		this.id_motivo_cancelacion = id_motivo_cancelacion;
	}

	public String getMotivo_cancelacion() {
		return motivo_cancelacion;
	}

	public void setMotivo_cancelacion(String motivo_cancelacion) {
		this.motivo_cancelacion = motivo_cancelacion;
	}

	@Override
	public String toString() {
		return "Catalogo_Motivos_Cancelacion [id_motivo_cancelacion=" + id_motivo_cancelacion + ", motivo_cancelacion="
				+ motivo_cancelacion + "]";
	}
}
