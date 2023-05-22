package cdo.Datos;

public class Distancia {
	private static final long serialVersionUID = 1L;
	private String uname;
	private String tipo;
	private String distancia;
	private double porcManiobra;
	private double porcSeguro;
	
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getDistancia() {
		return distancia;
	}
	public void setDistancia(String distancia) {
		this.distancia = distancia;
	}
	public double getPorcManiobra() {
		return porcManiobra;
	}
	public void setPorcManiobra(double porcManiobra) {
		this.porcManiobra = porcManiobra;
	}
	public double getPorcSeguro() {
		return porcSeguro;
	}
	public void setPorcSeguro(double porcSeguro) {
		this.porcSeguro = porcSeguro;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public Distancia() {
		super();
		this.uname = "";
		this.tipo = "";
		this.distancia = "";
		this.porcManiobra = 0.0000F;
		this.porcSeguro = 0.0000F;
	}
	
	
	
	@Override
	public String toString() {
		return "Distancia [uname=" + uname + ", tipo=" + tipo + ", distancia=" + distancia + ", porcManiobra="
				+ porcManiobra + ", porcSeguro=" + porcSeguro + "]";
	}

}
