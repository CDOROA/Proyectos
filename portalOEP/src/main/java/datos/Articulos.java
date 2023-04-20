package datos;

import java.io.Serializable;

public class Articulos implements Serializable{

	private static final long serialVersionUID = 1L;
	private String num_art_prov;
	private String num_art_cdo;
	private String proveedor;
	private String marca;
	private String descripcion;
	private String armadora;
	private String modelo;
	private String submodelo;
	private String anio;
	private String transmision;
	private String litros;
	private String cilindros;
	private String precio;
	private String precio_iva;
	private String rk;
	private String num_original;
	private int multiplo_venta;
	private String grupo;
	private String posicion;
	private double precio_real;
	private String cambioNumero;
	private String ordenamiento;
	private String intercambios;
	private String num_art_anterior;
	private String vigencia;
	private String num_art_cdo_sin_guion;
	private String num_art_prov_sin_guion;
	private String imagen_bxa;
	private String imagen_ecommerce;
	private String intercambio_sin_guion;
	private String marcaIntercambio;
	private String nombre_producto;
	private String tipo_catalogo;
	private String num_art_marca_propia;
	private String descripcion_producto;
	private double varianza_marca_propia;
	private String tipo_gasolina;
	private String caracteristicas;
	private String cve_venta;
	private String multiplo_rc;
	private String produtcsId;
	private String customAttrs;
	public Articulos() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Articulos(String num_art_prov, String num_art_cdo, String proveedor, String marca, String descripcion,
			String armadora, String modelo, String submodelo, String anio, String transmision, String litros,
			String cilindros, String precio, String precio_iva, String rk, String num_original, int multiplo_venta,
			String grupo, String posicion, double precio_real, String cambioNumero, String ordenamiento,
			String intercambios, String num_art_anterior, String vigencia, String num_art_cdo_sin_guion,
			String num_art_prov_sin_guion, String imagen_bxa, String imagen_ecommerce, String intercambio_sin_guion,
			String marcaIntercambio, String nombre_producto, String tipo_catalogo, String num_art_marca_propia,
			String descripcion_producto, double varianza_marca_propia, String tipo_gasolina, String caracteristicas,
			String cve_venta, String multiplo_rc, String produtcsId, String customAttrs) {
		super();
		this.num_art_prov = num_art_prov;
		this.num_art_cdo = num_art_cdo;
		this.proveedor = proveedor;
		this.marca = marca;
		this.descripcion = descripcion;
		this.armadora = armadora;
		this.modelo = modelo;
		this.submodelo = submodelo;
		this.anio = anio;
		this.transmision = transmision;
		this.litros = litros;
		this.cilindros = cilindros;
		this.precio = precio;
		this.precio_iva = precio_iva;
		this.rk = rk;
		this.num_original = num_original;
		this.multiplo_venta = multiplo_venta;
		this.grupo = grupo;
		this.posicion = posicion;
		this.precio_real = precio_real;
		this.cambioNumero = cambioNumero;
		this.ordenamiento = ordenamiento;
		this.intercambios = intercambios;
		this.num_art_anterior = num_art_anterior;
		this.vigencia = vigencia;
		this.num_art_cdo_sin_guion = num_art_cdo_sin_guion;
		this.num_art_prov_sin_guion = num_art_prov_sin_guion;
		this.imagen_bxa = imagen_bxa;
		this.imagen_ecommerce = imagen_ecommerce;
		this.intercambio_sin_guion = intercambio_sin_guion;
		this.marcaIntercambio = marcaIntercambio;
		this.nombre_producto = nombre_producto;
		this.tipo_catalogo = tipo_catalogo;
		this.num_art_marca_propia = num_art_marca_propia;
		this.descripcion_producto = descripcion_producto;
		this.varianza_marca_propia = varianza_marca_propia;
		this.tipo_gasolina = tipo_gasolina;
		this.caracteristicas = caracteristicas;
		this.cve_venta = cve_venta;
		this.multiplo_rc = multiplo_rc;
		this.produtcsId = produtcsId;
		this.customAttrs = customAttrs;
	}
	public String getNum_art_prov() {
		return num_art_prov;
	}
	public void setNum_art_prov(String num_art_prov) {
		this.num_art_prov = num_art_prov;
	}
	public String getNum_art_cdo() {
		return num_art_cdo;
	}
	public void setNum_art_cdo(String num_art_cdo) {
		this.num_art_cdo = num_art_cdo;
	}
	public String getProveedor() {
		return proveedor;
	}
	public void setProveedor(String proveedor) {
		this.proveedor = proveedor;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
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
	public String getPrecio() {
		return precio;
	}
	public void setPrecio(String precio) {
		this.precio = precio;
	}
	public String getPrecio_iva() {
		return precio_iva;
	}
	public void setPrecio_iva(String precio_iva) {
		this.precio_iva = precio_iva;
	}
	public String getRk() {
		return rk;
	}
	public void setRk(String rk) {
		this.rk = rk;
	}
	public String getNum_original() {
		return num_original;
	}
	public void setNum_original(String num_original) {
		this.num_original = num_original;
	}
	public int getMultiplo_venta() {
		return multiplo_venta;
	}
	public void setMultiplo_venta(int multiplo_venta) {
		this.multiplo_venta = multiplo_venta;
	}
	public String getGrupo() {
		return grupo;
	}
	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}
	public String getPosicion() {
		return posicion;
	}
	public void setPosicion(String posicion) {
		this.posicion = posicion;
	}
	public double getPrecio_real() {
		return precio_real;
	}
	public void setPrecio_real(double precio_real) {
		this.precio_real = precio_real;
	}
	public String getCambioNumero() {
		return cambioNumero;
	}
	public void setCambioNumero(String cambioNumero) {
		this.cambioNumero = cambioNumero;
	}
	public String getOrdenamiento() {
		return ordenamiento;
	}
	public void setOrdenamiento(String ordenamiento) {
		this.ordenamiento = ordenamiento;
	}
	public String getIntercambios() {
		return intercambios;
	}
	public void setIntercambios(String intercambios) {
		this.intercambios = intercambios;
	}
	public String getNum_art_anterior() {
		return num_art_anterior;
	}
	public void setNum_art_anterior(String num_art_anterior) {
		this.num_art_anterior = num_art_anterior;
	}
	public String getVigencia() {
		return vigencia;
	}
	public void setVigencia(String vigencia) {
		this.vigencia = vigencia;
	}
	public String getNum_art_cdo_sin_guion() {
		return num_art_cdo_sin_guion;
	}
	public void setNum_art_cdo_sin_guion(String num_art_cdo_sin_guion) {
		this.num_art_cdo_sin_guion = num_art_cdo_sin_guion;
	}
	public String getNum_art_prov_sin_guion() {
		return num_art_prov_sin_guion;
	}
	public void setNum_art_prov_sin_guion(String num_art_prov_sin_guion) {
		this.num_art_prov_sin_guion = num_art_prov_sin_guion;
	}
	public String getImagen_bxa() {
		return imagen_bxa;
	}
	public void setImagen_bxa(String imagen_bxa) {
		this.imagen_bxa = imagen_bxa;
	}
	public String getImagen_ecommerce() {
		return imagen_ecommerce;
	}
	public void setImagen_ecommerce(String imagen_ecommerce) {
		this.imagen_ecommerce = imagen_ecommerce;
	}
	public String getIntercambio_sin_guion() {
		return intercambio_sin_guion;
	}
	public void setIntercambio_sin_guion(String intercambio_sin_guion) {
		this.intercambio_sin_guion = intercambio_sin_guion;
	}
	public String getMarcaIntercambio() {
		return marcaIntercambio;
	}
	public void setMarcaIntercambio(String marcaIntercambio) {
		this.marcaIntercambio = marcaIntercambio;
	}
	public String getNombre_producto() {
		return nombre_producto;
	}
	public void setNombre_producto(String nombre_producto) {
		this.nombre_producto = nombre_producto;
	}
	public String getTipo_catalogo() {
		return tipo_catalogo;
	}
	public void setTipo_catalogo(String tipo_catalogo) {
		this.tipo_catalogo = tipo_catalogo;
	}
	public String getNum_art_marca_propia() {
		return num_art_marca_propia;
	}
	public void setNum_art_marca_propia(String num_art_marca_propia) {
		this.num_art_marca_propia = num_art_marca_propia;
	}
	public String getDescripcion_producto() {
		return descripcion_producto;
	}
	public void setDescripcion_producto(String descripcion_producto) {
		this.descripcion_producto = descripcion_producto;
	}
	public double getVarianza_marca_propia() {
		return varianza_marca_propia;
	}
	public void setVarianza_marca_propia(double varianza_marca_propia) {
		this.varianza_marca_propia = varianza_marca_propia;
	}
	public String getTipo_gasolina() {
		return tipo_gasolina;
	}
	public void setTipo_gasolina(String tipo_gasolina) {
		this.tipo_gasolina = tipo_gasolina;
	}
	public String getCaracteristicas() {
		return caracteristicas;
	}
	public void setCaracteristicas(String caracteristicas) {
		this.caracteristicas = caracteristicas;
	}
	public String getCve_venta() {
		return cve_venta;
	}
	public void setCve_venta(String cve_venta) {
		this.cve_venta = cve_venta;
	}
	public String getMultiplo_rc() {
		return multiplo_rc;
	}
	public void setMultiplo_rc(String multiplo_rc) {
		this.multiplo_rc = multiplo_rc;
	}
	public String getProdutcsId() {
		return produtcsId;
	}
	public void setProdutcsId(String produtcsId) {
		this.produtcsId = produtcsId;
	}
	public String getCustomAttrs() {
		return customAttrs;
	}
	public void setCustomAttrs(String customAttrs) {
		this.customAttrs = customAttrs;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "Articulos [num_art_prov=" + num_art_prov + ", num_art_cdo=" + num_art_cdo + ", proveedor=" + proveedor
				+ ", marca=" + marca + ", descripcion=" + descripcion + ", armadora=" + armadora + ", modelo=" + modelo
				+ ", submodelo=" + submodelo + ", anio=" + anio + ", transmision=" + transmision + ", litros=" + litros
				+ ", cilindros=" + cilindros + ", precio=" + precio + ", precio_iva=" + precio_iva + ", rk=" + rk
				+ ", num_original=" + num_original + ", multiplo_venta=" + multiplo_venta + ", grupo=" + grupo
				+ ", posicion=" + posicion + ", precio_real=" + precio_real + ", cambioNumero=" + cambioNumero
				+ ", ordenamiento=" + ordenamiento + ", intercambios=" + intercambios + ", num_art_anterior="
				+ num_art_anterior + ", vigencia=" + vigencia + ", num_art_cdo_sin_guion=" + num_art_cdo_sin_guion
				+ ", num_art_prov_sin_guion=" + num_art_prov_sin_guion + ", imagen_bxa=" + imagen_bxa
				+ ", imagen_ecommerce=" + imagen_ecommerce + ", intercambio_sin_guion=" + intercambio_sin_guion
				+ ", marcaIntercambio=" + marcaIntercambio + ", nombre_producto=" + nombre_producto + ", tipo_catalogo="
				+ tipo_catalogo + ", num_art_marca_propia=" + num_art_marca_propia + ", descripcion_producto="
				+ descripcion_producto + ", varianza_marca_propia=" + varianza_marca_propia + ", tipo_gasolina="
				+ tipo_gasolina + ", caracteristicas=" + caracteristicas + ", cve_venta=" + cve_venta + ", multiplo_rc="
				+ multiplo_rc + ", produtcsId=" + produtcsId + ", customAttrs=" + customAttrs + "]";
	}

	
}
