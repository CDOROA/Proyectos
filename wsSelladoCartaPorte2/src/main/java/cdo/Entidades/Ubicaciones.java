package cdo.Entidades;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Ubicaciones extends Identificadores implements Serializable
{
	private String renglon;
	private String distancia_recorrida;
	private String tipo_estacion;
	private String id_origen;
	private String id_destino;
	private String fecha_hora_salida;
	private String fecha_hora_llegada;
	private String codigo_postal;
	private String pais;
	private String estado;
	private String municipio;
	private String localidad;
	private String colonia;
	private String calle;
	public Ubicaciones() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Ubicaciones(String uname, String folio, String serie, String carta_porte) {
		super(uname, folio, serie, carta_porte);
		// TODO Auto-generated constructor stub
	}
	public Ubicaciones(String renglon, String distancia_recorrida, String tipo_estacion, String id_origen,
			String id_destino, String fecha_hora_salida, String fecha_hora_llegada, String codigo_postal, String pais,
			String estado, String municipio, String localidad, String colonia, String calle) {
		super();
		this.renglon = renglon;
		this.distancia_recorrida = distancia_recorrida;
		this.tipo_estacion = tipo_estacion;
		this.id_origen = id_origen;
		this.id_destino = id_destino;
		this.fecha_hora_salida = fecha_hora_salida;
		this.fecha_hora_llegada = fecha_hora_llegada;
		this.codigo_postal = codigo_postal;
		this.pais = pais;
		this.estado = estado;
		this.municipio = municipio;
		this.localidad = localidad;
		this.colonia = colonia;
		this.calle = calle;
	}
	public String getRenglon() {
		return renglon;
	}
	public void setRenglon(String renglon) {
		this.renglon = renglon;
	}
	public String getDistancia_recorrida() {
		return distancia_recorrida;
	}
	public void setDistancia_recorrida(String distancia_recorrida) {
		this.distancia_recorrida = distancia_recorrida;
	}
	public String getTipo_estacion() {
		return tipo_estacion;
	}
	public void setTipo_estacion(String tipo_estacion) {
		this.tipo_estacion = tipo_estacion;
	}
	public String getId_origen() {
		return id_origen;
	}
	public void setId_origen(String id_origen) {
		this.id_origen = id_origen;
	}
	public String getId_destino() {
		return id_destino;
	}
	public void setId_destino(String id_destino) {
		this.id_destino = id_destino;
	}
	public String getFecha_hora_salida() {
		return fecha_hora_salida;
	}
	public void setFecha_hora_salida(String fecha_hora_salida) {
		this.fecha_hora_salida = fecha_hora_salida;
	}
	public String getFecha_hora_llegada() {
		return fecha_hora_llegada;
	}
	public void setFecha_hora_llegada(String fecha_hora_llegada) {
		this.fecha_hora_llegada = fecha_hora_llegada;
	}
	public String getCodigo_postal() {
		return codigo_postal;
	}
	public void setCodigo_postal(String codigo_postal) {
		this.codigo_postal = codigo_postal;
	}
	public String getPais() {
		return pais;
	}
	public void setPais(String pais) {
		this.pais = pais;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getMunicipio() {
		return municipio;
	}
	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}
	public String getLocalidad() {
		return localidad;
	}
	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}
	public String getColonia() {
		return colonia;
	}
	public void setColonia(String colonia) {
		this.colonia = colonia;
	}
	public String getCalle() {
		return calle;
	}
	public void setCalle(String calle) {
		this.calle = calle;
	}
	@Override
	public String toString() {
		return "Ubicaciones [renglon=" + renglon + ", distancia_recorrida=" + distancia_recorrida + ", tipo_estacion="
				+ tipo_estacion + ", id_origen=" + id_origen + ", id_destino=" + id_destino + ", fecha_hora_salida="
				+ fecha_hora_salida + ", fecha_hora_llegada=" + fecha_hora_llegada + ", codigo_postal=" + codigo_postal
				+ ", pais=" + pais + ", estado=" + estado + ", municipio=" + municipio + ", localidad=" + localidad
				+ ", colonia=" + colonia + ", calle=" + calle + "]";
	}
	
	
}
