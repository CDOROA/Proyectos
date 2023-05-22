package cdo.Datos;

public class FactTransp 
{
	int num_trans;
	String factura;
	public FactTransp() {
		super();
		// TODO Auto-generated constructor stub
	}
	public FactTransp(int num_trans, String factura) {
		super();
		this.num_trans = num_trans;
		this.factura = factura;
	}
	public int getNum_trans() {
		return num_trans;
	}
	public void setNum_trans(int num_trans) {
		this.num_trans = num_trans;
	}
	public String getFactura() {
		return factura;
	}
	public void setFactura(String factura) {
		this.factura = factura;
	}
	@Override
	public String toString() {
		return "FactTransp [num_trans=" + num_trans + ", factura=" + factura + "]";
	}
	
	
}
