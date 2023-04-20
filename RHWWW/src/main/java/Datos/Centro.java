package Datos;

public class Centro {

	private int cveEmpresa;
	private String nombreComercial;
	
	
	public int getCveEmpresa() {
		return cveEmpresa;
	}
	public void setCveEmpresa(int cveEmpresa) {
		this.cveEmpresa = cveEmpresa;
	}
	public String getNombreComercial() {
		return nombreComercial;
	}
	public void setNombreComercial(String nombreComercial) {
		this.nombreComercial = nombreComercial;
	}
	
	
	public Centro( ) {
		super();
		this.cveEmpresa = 0;
		this.nombreComercial = "";
	}
	
	
	@Override
	public String toString() {
		return "Centro [cveEmpresa=" + cveEmpresa + ", nombreComercial=" + nombreComercial + "]";
	}

}
