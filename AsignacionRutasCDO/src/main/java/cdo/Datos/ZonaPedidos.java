package cdo.Datos;

public class ZonaPedidos
{
	String ode;
	String ods;
	String pedido;
	String cliente;
	String zona;
	String descripcion;
	String fecha_ped;
	String hora_ped;
	String sts_empaque;
	String emp_empaque;
	String ini_empaque;
	String fin_empaque;
	String sts_repartidor;
	String emp_repartidor;
	String ini_repartidor;
	String fin_repartidor;
	String nombre;
	String nom_emp;
	String nom_chofer;
	String facturas;
	public ZonaPedidos() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ZonaPedidos(String ode, String ods, String pedido, String cliente, String zona, String descripcion,
			String fecha_ped, String hora_ped, String sts_empaque, String emp_empaque, String ini_empaque,
			String fin_empaque, String sts_repartidor, String emp_repartidor, String ini_repartidor,
			String fin_repartidor, String nombre, String nom_emp, String nom_chofer, String facturas) {
		super();
		this.ode = ode;
		this.ods = ods;
		this.pedido = pedido;
		this.cliente = cliente;
		this.zona = zona;
		this.descripcion = descripcion;
		this.fecha_ped = fecha_ped;
		this.hora_ped = hora_ped;
		this.sts_empaque = sts_empaque;
		this.emp_empaque = emp_empaque;
		this.ini_empaque = ini_empaque;
		this.fin_empaque = fin_empaque;
		this.sts_repartidor = sts_repartidor;
		this.emp_repartidor = emp_repartidor;
		this.ini_repartidor = ini_repartidor;
		this.fin_repartidor = fin_repartidor;
		this.nombre = nombre;
		this.nom_emp = nom_emp;
		this.nom_chofer = nom_chofer;
		this.facturas = facturas;
	}
	public String getOde() {
		return ode;
	}
	public void setOde(String ode) {
		this.ode = ode;
	}
	public String getOds() {
		return ods;
	}
	public void setOds(String ods) {
		this.ods = ods;
	}
	public String getPedido() {
		return pedido;
	}
	public void setPedido(String pedido) {
		this.pedido = pedido;
	}
	public String getCliente() {
		return cliente;
	}
	public void setCliente(String cliente) {
		this.cliente = cliente;
	}
	public String getZona() {
		return zona;
	}
	public void setZona(String zona) {
		this.zona = zona;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getFecha_ped() {
		return fecha_ped;
	}
	public void setFecha_ped(String fecha_ped) {
		this.fecha_ped = fecha_ped;
	}
	public String getHora_ped() {
		return hora_ped;
	}
	public void setHora_ped(String hora_ped) {
		this.hora_ped = hora_ped;
	}
	public String getSts_empaque() {
		return sts_empaque;
	}
	public void setSts_empaque(String sts_empaque) {
		this.sts_empaque = sts_empaque;
	}
	public String getEmp_empaque() {
		return emp_empaque;
	}
	public void setEmp_empaque(String emp_empaque) {
		this.emp_empaque = emp_empaque;
	}
	public String getIni_empaque() {
		return ini_empaque;
	}
	public void setIni_empaque(String ini_empaque) {
		this.ini_empaque = ini_empaque;
	}
	public String getFin_empaque() {
		return fin_empaque;
	}
	public void setFin_empaque(String fin_empaque) {
		this.fin_empaque = fin_empaque;
	}
	public String getSts_repartidor() {
		return sts_repartidor;
	}
	public void setSts_repartidor(String sts_repartidor) {
		this.sts_repartidor = sts_repartidor;
	}
	public String getEmp_repartidor() {
		return emp_repartidor;
	}
	public void setEmp_repartidor(String emp_repartidor) {
		this.emp_repartidor = emp_repartidor;
	}
	public String getIni_repartidor() {
		return ini_repartidor;
	}
	public void setIni_repartidor(String ini_repartidor) {
		this.ini_repartidor = ini_repartidor;
	}
	public String getFin_repartidor() {
		return fin_repartidor;
	}
	public void setFin_repartidor(String fin_repartidor) {
		this.fin_repartidor = fin_repartidor;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getNom_emp() {
		return nom_emp;
	}
	public void setNom_emp(String nom_emp) {
		this.nom_emp = nom_emp;
	}
	public String getNom_chofer() {
		return nom_chofer;
	}
	public void setNom_chofer(String nom_chofer) {
		this.nom_chofer = nom_chofer;
	}
	public String getFacturas() {
		return facturas;
	}
	public void setFacturas(String facturas) {
		this.facturas = facturas;
	}
	@Override
	public String toString() {
		return "ZonaPedidos [ode=" + ode + ", ods=" + ods + ", pedido=" + pedido + ", cliente=" + cliente + ", zona="
				+ zona + ", descripcion=" + descripcion + ", fecha_ped=" + fecha_ped + ", hora_ped=" + hora_ped
				+ ", sts_empaque=" + sts_empaque + ", emp_empaque=" + emp_empaque + ", ini_empaque=" + ini_empaque
				+ ", fin_empaque=" + fin_empaque + ", sts_repartidor=" + sts_repartidor + ", emp_repartidor="
				+ emp_repartidor + ", ini_repartidor=" + ini_repartidor + ", fin_repartidor=" + fin_repartidor
				+ ", nombre=" + nombre + ", nom_emp=" + nom_emp + ", nom_chofer=" + nom_chofer + ", facturas="
				+ facturas + "]";
	}
		
}
