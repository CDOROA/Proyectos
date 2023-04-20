package cdo.Datos;

public class Facturas 
{
	String facturas;

	public Facturas() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Facturas(String facturas) {
		super();
		this.facturas = facturas;
	}

	public String getFacturas() {
		return facturas;
	}

	public void setFacturas(String facturas) {
		this.facturas = facturas;
	}

	@Override
	public String toString() {
		return "Facturas [facturas=" + facturas + "]";
	}
	
}
