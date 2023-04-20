package datos;


public class DetalleArticulo 
{
	private String num_art_cdo;
	private String armadora;
	private String modelo;
	private String submodelo;
	private String anio;
	private String transmision;
	private String litros;
	private String cilindros;
	private String caracteristicas;
	private String tipo_combustible;
	public DetalleArticulo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public DetalleArticulo(String num_art_cdo, String armadora, String modelo, String submodelo, String anio,
			String transmision, String litros, String cilindros, String caracteristicas, String tipo_combustible) {
		super();
		this.num_art_cdo = num_art_cdo;
		this.armadora = armadora;
		this.modelo = modelo;
		this.submodelo = submodelo;
		this.anio = anio;
		this.transmision = transmision;
		this.litros = litros;
		this.cilindros = cilindros;
		this.caracteristicas = caracteristicas;
		this.tipo_combustible = tipo_combustible;
	}
	public String getNum_art_cdo() {
		return num_art_cdo;
	}
	public void setNum_art_cdo(String num_art_cdo) {
		this.num_art_cdo = num_art_cdo;
	}
	public String getArmadora() {
		return armadora;
	}
	public void setArmadora(String armadora) {
		this.armadora = armadora;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public String getSubmodelo() {
		return submodelo;
	}
	public void setSubmodelo(String submodelo) {
		this.submodelo = submodelo;
	}
	public String getAnio() {
		return anio;
	}
	public void setAnio(String anio) {
		this.anio = anio;
	}
	public String getTransmision() {
		return transmision;
	}
	public void setTransmision(String transmision) {
		this.transmision = transmision;
	}
	public String getLitros() {
		return litros;
	}
	public void setLitros(String litros) {
		this.litros = litros;
	}
	public String getCilindros() {
		return cilindros;
	}
	public void setCilindros(String cilindros) {
		this.cilindros = cilindros;
	}
	public String getCaracteristicas() {
		return caracteristicas;
	}
	public void setCaracteristicas(String caracteristicas) {
		this.caracteristicas = caracteristicas;
	}
	public String getTipo_combustible() {
		return tipo_combustible;
	}
	public void setTipo_combustible(String tipo_combustible) {
		this.tipo_combustible = tipo_combustible;
	}
	@Override
	public String toString() {
		return "DetalleArticulo [num_art_cdo=" + num_art_cdo + ", armadora=" + armadora + ", modelo=" + modelo
				+ ", submodelo=" + submodelo + ", anio=" + anio + ", transmision=" + transmision + ", litros=" + litros
				+ ", cilindros=" + cilindros + ", caracteristicas=" + caracteristicas + ", tipo_combustible="
				+ tipo_combustible + "]";
	}
	
	
	
	
	
}
