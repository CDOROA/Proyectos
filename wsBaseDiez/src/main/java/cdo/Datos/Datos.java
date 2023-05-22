package cdo.Datos;

public class Datos {
	private String rean;
	private String ren;
	

	public Datos() {
		super();
	}

	public String getRean() {
		return rean;
	}



	public void setRean(String rean) {
		this.rean = rean;
	}



	public String getRen() {
		return ren;
	}



	public void setRen(String ren) {
		this.ren = ren;
	}





	@Override
	public String toString() {
		return "Datos [rean=" + rean + ", ren=" + ren + "]";
	}
	
}
