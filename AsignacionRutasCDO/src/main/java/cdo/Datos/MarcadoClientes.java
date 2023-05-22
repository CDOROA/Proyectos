package cdo.Datos;

public class MarcadoClientes 
{
	private String id;
	private String facturas;
	private String cliente;
	private String direccion;
	private String ruta;
	private String bolsas;
	private String cajas;
	private String atados;
	private String paquetes;
	private String acumuladores;
	private String tarimas;
	private String otros;
	private String peso;
	public MarcadoClientes() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MarcadoClientes(String id, String facturas, String cliente, String direccion, String ruta, String bolsas,
			String cajas, String atados, String paquetes, String acumuladores, String tarimas, String otros,
			String peso) {
		super();
		this.id = id;
		this.facturas = facturas;
		this.cliente = cliente;
		this.direccion = direccion;
		this.ruta = ruta;
		this.bolsas = bolsas;
		this.cajas = cajas;
		this.atados = atados;
		this.paquetes = paquetes;
		this.acumuladores = acumuladores;
		this.tarimas = tarimas;
		this.otros = otros;
		this.peso = peso;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFacturas() {
		return facturas;
	}
	public void setFacturas(String facturas) {
		this.facturas = facturas;
	}
	public String getCliente() {
		return cliente;
	}
	public void setCliente(String cliente) {
		this.cliente = cliente;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getRuta() {
		return ruta;
	}
	public void setRuta(String ruta) {
		this.ruta = ruta;
	}
	public String getBolsas() {
		return bolsas;
	}
	public void setBolsas(String bolsas) {
		this.bolsas = bolsas;
	}
	public String getCajas() {
		return cajas;
	}
	public void setCajas(String cajas) {
		this.cajas = cajas;
	}
	public String getAtados() {
		return atados;
	}
	public void setAtados(String atados) {
		this.atados = atados;
	}
	public String getPaquetes() {
		return paquetes;
	}
	public void setPaquetes(String paquetes) {
		this.paquetes = paquetes;
	}
	public String getAcumuladores() {
		return acumuladores;
	}
	public void setAcumuladores(String acumuladores) {
		this.acumuladores = acumuladores;
	}
	public String getTarimas() {
		return tarimas;
	}
	public void setTarimas(String tarimas) {
		this.tarimas = tarimas;
	}
	public String getOtros() {
		return otros;
	}
	public void setOtros(String otros) {
		this.otros = otros;
	}
	public String getPeso() {
		return peso;
	}
	public void setPeso(String peso) {
		this.peso = peso;
	}
	
}
