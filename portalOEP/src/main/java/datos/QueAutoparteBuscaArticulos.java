package datos;


import java.io.Serializable;

public class QueAutoparteBuscaArticulos implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private String desc_grupo;
	private String desc_aramdora;
	private String des_submarca;
	private String cve_articulo;
	private String desc_articulo;
	private String des_marca;
	private String anio_ini;
	private String anio_fin;
	private String posicion;
	private String cilindros;
	private String caracteristicas;
	private String motor;
	
	public QueAutoparteBuscaArticulos() {
		super();
	}

	public QueAutoparteBuscaArticulos(String desc_grupo, String desc_aramdora, String des_submarca, String cve_articulo,
			String desc_articulo, String des_marca, String anio_ini, String anio_fin, String posicion, String cilindros,
			String caracteristicas, String motor) {
		super();
		this.desc_grupo = desc_grupo;
		this.desc_aramdora = desc_aramdora;
		this.des_submarca = des_submarca;
		this.cve_articulo = cve_articulo;
		this.desc_articulo = desc_articulo;
		this.des_marca = des_marca;
		this.anio_ini = anio_ini;
		this.anio_fin = anio_fin;
		this.posicion = posicion;
		this.cilindros = cilindros;
		this.caracteristicas = caracteristicas;
		this.motor = motor;
	}

	public String getDesc_grupo() {
		return desc_grupo;
	}

	public void setDesc_grupo(String desc_grupo) {
		this.desc_grupo = desc_grupo;
	}

	public String getDesc_aramdora() {
		return desc_aramdora;
	}

	public void setDesc_aramdora(String desc_aramdora) {
		this.desc_aramdora = desc_aramdora;
	}

	public String getDes_submarca() {
		return des_submarca;
	}

	public void setDes_submarca(String des_submarca) {
		this.des_submarca = des_submarca;
	}

	public String getCve_articulo() {
		return cve_articulo;
	}

	public void setCve_articulo(String cve_articulo) {
		this.cve_articulo = cve_articulo;
	}

	public String getDesc_articulo() {
		return desc_articulo;
	}

	public void setDesc_articulo(String desc_articulo) {
		this.desc_articulo = desc_articulo;
	}

	public String getDes_marca() {
		return des_marca;
	}

	public void setDes_marca(String des_marca) {
		this.des_marca = des_marca;
	}

	public String getAnio_ini() {
		return anio_ini;
	}

	public void setAnio_ini(String anio_ini) {
		this.anio_ini = anio_ini;
	}

	public String getAnio_fin() {
		return anio_fin;
	}

	public void setAnio_fin(String anio_fin) {
		this.anio_fin = anio_fin;
	}

	public String getPosicion() {
		return posicion;
	}

	public void setPosicion(String posicion) {
		this.posicion = posicion;
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

	public String getMotor() {
		return motor;
	}

	public void setMotor(String motor) {
		this.motor = motor;
	}

	@Override
	public String toString() {
		return "QueAutoparteBuscaArticulos [desc_grupo=" + desc_grupo + ", desc_aramdora=" + desc_aramdora
				+ ", des_submarca=" + des_submarca + ", cve_articulo=" + cve_articulo + ", desc_articulo="
				+ desc_articulo + ", des_marca=" + des_marca + ", anio_ini=" + anio_ini + ", anio_fin=" + anio_fin
				+ ", posicion=" + posicion + ", cilindros=" + cilindros + ", caracteristicas=" + caracteristicas
				+ ", motor=" + motor + "]";
	}
}
