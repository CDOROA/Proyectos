package datos;

public class Anios {

	String anio;

	public String getAnio() {
		return anio;
	}

	public void setAnio(String anio) {
		this.anio = anio;
	}

	public Anios() {
		super();
		this.anio = "";
	}

	@Override
	public String toString() {
		return "Anios [anio=" + anio + "]";
	}
}
