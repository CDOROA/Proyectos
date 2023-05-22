package cdo.Datos;

public class Transporte 
{
	String trans = "";
	String minutos = "";
	public Transporte() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Transporte(String trans, String minutos) {
		super();
		this.trans = trans;
		this.minutos = minutos;
	}
	public String getTrans() {
		return trans;
	}
	public void setTrans(String trans) {
		this.trans = trans;
	}
	public String getMinutos() {
		return minutos;
	}
	public void setMinutos(String minutos) {
		this.minutos = minutos;
	}
	@Override
	public String toString() {
		return "Transporte [trans=" + trans + ", minutos=" + minutos + "]";
	}
	
}
