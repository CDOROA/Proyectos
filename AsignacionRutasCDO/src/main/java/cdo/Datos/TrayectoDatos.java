package cdo.Datos;

import java.io.Serializable;

@SuppressWarnings("serial")
public class TrayectoDatos implements Serializable 
{
	private String uname;
	private String bnd = "t";
	private String titulo ;
	private String pedidoPunteo;
	private String facturasPunteo;
	private String clientePunteo;
	private String importePedido;
	private String importeTrayecto;
	private String horasPedido;
	private String horasEntrega;
	private String nombre_cliente;
	private String cliente_nombre;
	private String dias; 
	private String horas;
	private String horasAsig;
	private String diasPed; 
	private String horasPed;
	private String horasInicio;
	private String diasEnc; 
	private String horasEnc;
	private String diasEncPed; 
	private String horasEncPed;
	private String fechaPedido;
	private String descripcion_cdo;
	private String descripcion_br;
	private String repeticion;
	private String uname_br;
	private String id_traycto;
	private String num_chofer;
	private String nombre_chofer;
	private String fecha_asignacion;
	private String hora_asignacion;
	private String usuario_asignacion;
	private String fecha_inicio_trayecto;
	private String fecha_inicio_entrega;
	private String fecha_fin_trayecto;
	private String hora_inicio_trayecto;
	private String hora_fin_trayecto;
	private String cliente;
	private String ode;
	private String pedido;
	private String factura;
	private String facturas;
	private String importe;
	private String estatus;
	private String id_estatus;
	private String latitud_inicio_entrega;
	private String longitud_inicio_entrega;
	private String latitud_fin_entrega;
	private String longitud_fin_entrega;
	private String importe_cobrado;
	private String observaciones;
	private String tipo_cobro;
	private String asignacionConcat;
	private String finConcat;
	private String inicioConcat;
	private String ruta;
	private String direccion;
	private String tipo;
	private String transporteNombre;
	private String numeroChofer;
	private String ingresos = "n";
	private String ingresosCobro = "n";
	private String no;
	private String facturas_cod = "";
	private String latitud_cdo;
	private String longitud_cdo;
	private String folio_corte;
	private String folio_carta_porte;
	private String color;
	
	public TrayectoDatos() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TrayectoDatos(String uname, String bnd, String titulo, String pedidoPunteo, String facturasPunteo,
			String clientePunteo, String importePedido, String importeTrayecto, String horasPedido, String horasEntrega,
			String nombre_cliente, String cliente_nombre, String dias, String horas, String horasAsig, String diasPed,
			String horasPed, String horasInicio, String diasEnc, String horasEnc, String diasEncPed, String horasEncPed,
			String fechaPedido, String descripcion_cdo, String descripcion_br, String repeticion, String uname_br,
			String id_traycto, String num_chofer, String nombre_chofer, String fecha_asignacion, String hora_asignacion,
			String usuario_asignacion, String fecha_inicio_trayecto, String fecha_inicio_entrega,
			String fecha_fin_trayecto, String hora_inicio_trayecto, String hora_fin_trayecto, String cliente,
			String ode, String pedido, String factura, String facturas, String importe, String estatus,
			String id_estatus, String latitud_inicio_entrega, String longitud_inicio_entrega,
			String latitud_fin_entrega, String longitud_fin_entrega, String importe_cobrado, String observaciones,
			String tipo_cobro, String asignacionConcat, String finConcat, String inicioConcat, String ruta,
			String direccion, String tipo, String transporteNombre, String numeroChofer, String ingresos,
			String ingresosCobro, String no, String facturas_cod, String latitud_cdo, String longitud_cdo,
			String folio_corte, String folio_carta_porte, String color) {
		super();
		this.uname = uname;
		this.bnd = bnd;
		this.titulo = titulo;
		this.pedidoPunteo = pedidoPunteo;
		this.facturasPunteo = facturasPunteo;
		this.clientePunteo = clientePunteo;
		this.importePedido = importePedido;
		this.importeTrayecto = importeTrayecto;
		this.horasPedido = horasPedido;
		this.horasEntrega = horasEntrega;
		this.nombre_cliente = nombre_cliente;
		this.cliente_nombre = cliente_nombre;
		this.dias = dias;
		this.horas = horas;
		this.horasAsig = horasAsig;
		this.diasPed = diasPed;
		this.horasPed = horasPed;
		this.horasInicio = horasInicio;
		this.diasEnc = diasEnc;
		this.horasEnc = horasEnc;
		this.diasEncPed = diasEncPed;
		this.horasEncPed = horasEncPed;
		this.fechaPedido = fechaPedido;
		this.descripcion_cdo = descripcion_cdo;
		this.descripcion_br = descripcion_br;
		this.repeticion = repeticion;
		this.uname_br = uname_br;
		this.id_traycto = id_traycto;
		this.num_chofer = num_chofer;
		this.nombre_chofer = nombre_chofer;
		this.fecha_asignacion = fecha_asignacion;
		this.hora_asignacion = hora_asignacion;
		this.usuario_asignacion = usuario_asignacion;
		this.fecha_inicio_trayecto = fecha_inicio_trayecto;
		this.fecha_inicio_entrega = fecha_inicio_entrega;
		this.fecha_fin_trayecto = fecha_fin_trayecto;
		this.hora_inicio_trayecto = hora_inicio_trayecto;
		this.hora_fin_trayecto = hora_fin_trayecto;
		this.cliente = cliente;
		this.ode = ode;
		this.pedido = pedido;
		this.factura = factura;
		this.facturas = facturas;
		this.importe = importe;
		this.estatus = estatus;
		this.id_estatus = id_estatus;
		this.latitud_inicio_entrega = latitud_inicio_entrega;
		this.longitud_inicio_entrega = longitud_inicio_entrega;
		this.latitud_fin_entrega = latitud_fin_entrega;
		this.longitud_fin_entrega = longitud_fin_entrega;
		this.importe_cobrado = importe_cobrado;
		this.observaciones = observaciones;
		this.tipo_cobro = tipo_cobro;
		this.asignacionConcat = asignacionConcat;
		this.finConcat = finConcat;
		this.inicioConcat = inicioConcat;
		this.ruta = ruta;
		this.direccion = direccion;
		this.tipo = tipo;
		this.transporteNombre = transporteNombre;
		this.numeroChofer = numeroChofer;
		this.ingresos = ingresos;
		this.ingresosCobro = ingresosCobro;
		this.no = no;
		this.facturas_cod = facturas_cod;
		this.latitud_cdo = latitud_cdo;
		this.longitud_cdo = longitud_cdo;
		this.folio_corte = folio_corte;
		this.folio_carta_porte = folio_carta_porte;
		this.color = color;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getBnd() {
		return bnd;
	}
	public void setBnd(String bnd) {
		this.bnd = bnd;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getPedidoPunteo() {
		return pedidoPunteo;
	}
	public void setPedidoPunteo(String pedidoPunteo) {
		this.pedidoPunteo = pedidoPunteo;
	}
	public String getFacturasPunteo() {
		return facturasPunteo;
	}
	public void setFacturasPunteo(String facturasPunteo) {
		this.facturasPunteo = facturasPunteo;
	}
	public String getClientePunteo() {
		return clientePunteo;
	}
	public void setClientePunteo(String clientePunteo) {
		this.clientePunteo = clientePunteo;
	}
	public String getImportePedido() {
		return importePedido;
	}
	public void setImportePedido(String importePedido) {
		this.importePedido = importePedido;
	}
	public String getImporteTrayecto() {
		return importeTrayecto;
	}
	public void setImporteTrayecto(String importeTrayecto) {
		this.importeTrayecto = importeTrayecto;
	}
	public String getHorasPedido() {
		return horasPedido;
	}
	public void setHorasPedido(String horasPedido) {
		this.horasPedido = horasPedido;
	}
	public String getHorasEntrega() {
		return horasEntrega;
	}
	public void setHorasEntrega(String horasEntrega) {
		this.horasEntrega = horasEntrega;
	}
	public String getNombre_cliente() {
		return nombre_cliente;
	}
	public void setNombre_cliente(String nombre_cliente) {
		this.nombre_cliente = nombre_cliente;
	}
	public String getCliente_nombre() {
		return cliente_nombre;
	}
	public void setCliente_nombre(String cliente_nombre) {
		this.cliente_nombre = cliente_nombre;
	}
	public String getDias() {
		return dias;
	}
	public void setDias(String dias) {
		this.dias = dias;
	}
	public String getHoras() {
		return horas;
	}
	public void setHoras(String horas) {
		this.horas = horas;
	}
	public String getHorasAsig() {
		return horasAsig;
	}
	public void setHorasAsig(String horasAsig) {
		this.horasAsig = horasAsig;
	}
	public String getDiasPed() {
		return diasPed;
	}
	public void setDiasPed(String diasPed) {
		this.diasPed = diasPed;
	}
	public String getHorasPed() {
		return horasPed;
	}
	public void setHorasPed(String horasPed) {
		this.horasPed = horasPed;
	}
	public String getHorasInicio() {
		return horasInicio;
	}
	public void setHorasInicio(String horasInicio) {
		this.horasInicio = horasInicio;
	}
	public String getDiasEnc() {
		return diasEnc;
	}
	public void setDiasEnc(String diasEnc) {
		this.diasEnc = diasEnc;
	}
	public String getHorasEnc() {
		return horasEnc;
	}
	public void setHorasEnc(String horasEnc) {
		this.horasEnc = horasEnc;
	}
	public String getDiasEncPed() {
		return diasEncPed;
	}
	public void setDiasEncPed(String diasEncPed) {
		this.diasEncPed = diasEncPed;
	}
	public String getHorasEncPed() {
		return horasEncPed;
	}
	public void setHorasEncPed(String horasEncPed) {
		this.horasEncPed = horasEncPed;
	}
	public String getFechaPedido() {
		return fechaPedido;
	}
	public void setFechaPedido(String fechaPedido) {
		this.fechaPedido = fechaPedido;
	}
	public String getDescripcion_cdo() {
		return descripcion_cdo;
	}
	public void setDescripcion_cdo(String descripcion_cdo) {
		this.descripcion_cdo = descripcion_cdo;
	}
	public String getDescripcion_br() {
		return descripcion_br;
	}
	public void setDescripcion_br(String descripcion_br) {
		this.descripcion_br = descripcion_br;
	}
	public String getRepeticion() {
		return repeticion;
	}
	public void setRepeticion(String repeticion) {
		this.repeticion = repeticion;
	}
	public String getUname_br() {
		return uname_br;
	}
	public void setUname_br(String uname_br) {
		this.uname_br = uname_br;
	}
	public String getId_traycto() {
		return id_traycto;
	}
	public void setId_traycto(String id_traycto) {
		this.id_traycto = id_traycto;
	}
	public String getNum_chofer() {
		return num_chofer;
	}
	public void setNum_chofer(String num_chofer) {
		this.num_chofer = num_chofer;
	}
	public String getNombre_chofer() {
		return nombre_chofer;
	}
	public void setNombre_chofer(String nombre_chofer) {
		this.nombre_chofer = nombre_chofer;
	}
	public String getFecha_asignacion() {
		return fecha_asignacion;
	}
	public void setFecha_asignacion(String fecha_asignacion) {
		this.fecha_asignacion = fecha_asignacion;
	}
	public String getHora_asignacion() {
		return hora_asignacion;
	}
	public void setHora_asignacion(String hora_asignacion) {
		this.hora_asignacion = hora_asignacion;
	}
	public String getUsuario_asignacion() {
		return usuario_asignacion;
	}
	public void setUsuario_asignacion(String usuario_asignacion) {
		this.usuario_asignacion = usuario_asignacion;
	}
	public String getFecha_inicio_trayecto() {
		return fecha_inicio_trayecto;
	}
	public void setFecha_inicio_trayecto(String fecha_inicio_trayecto) {
		this.fecha_inicio_trayecto = fecha_inicio_trayecto;
	}
	public String getFecha_inicio_entrega() {
		return fecha_inicio_entrega;
	}
	public void setFecha_inicio_entrega(String fecha_inicio_entrega) {
		this.fecha_inicio_entrega = fecha_inicio_entrega;
	}
	public String getFecha_fin_trayecto() {
		return fecha_fin_trayecto;
	}
	public void setFecha_fin_trayecto(String fecha_fin_trayecto) {
		this.fecha_fin_trayecto = fecha_fin_trayecto;
	}
	public String getHora_inicio_trayecto() {
		return hora_inicio_trayecto;
	}
	public void setHora_inicio_trayecto(String hora_inicio_trayecto) {
		this.hora_inicio_trayecto = hora_inicio_trayecto;
	}
	public String getHora_fin_trayecto() {
		return hora_fin_trayecto;
	}
	public void setHora_fin_trayecto(String hora_fin_trayecto) {
		this.hora_fin_trayecto = hora_fin_trayecto;
	}
	public String getCliente() {
		return cliente;
	}
	public void setCliente(String cliente) {
		this.cliente = cliente;
	}
	public String getOde() {
		return ode;
	}
	public void setOde(String ode) {
		this.ode = ode;
	}
	public String getPedido() {
		return pedido;
	}
	public void setPedido(String pedido) {
		this.pedido = pedido;
	}
	public String getFactura() {
		return factura;
	}
	public void setFactura(String factura) {
		this.factura = factura;
	}
	public String getFacturas() {
		return facturas;
	}
	public void setFacturas(String facturas) {
		this.facturas = facturas;
	}
	public String getImporte() {
		return importe;
	}
	public void setImporte(String importe) {
		this.importe = importe;
	}
	public String getEstatus() {
		return estatus;
	}
	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}
	public String getId_estatus() {
		return id_estatus;
	}
	public void setId_estatus(String id_estatus) {
		this.id_estatus = id_estatus;
	}
	public String getLatitud_inicio_entrega() {
		return latitud_inicio_entrega;
	}
	public void setLatitud_inicio_entrega(String latitud_inicio_entrega) {
		this.latitud_inicio_entrega = latitud_inicio_entrega;
	}
	public String getLongitud_inicio_entrega() {
		return longitud_inicio_entrega;
	}
	public void setLongitud_inicio_entrega(String longitud_inicio_entrega) {
		this.longitud_inicio_entrega = longitud_inicio_entrega;
	}
	public String getLatitud_fin_entrega() {
		return latitud_fin_entrega;
	}
	public void setLatitud_fin_entrega(String latitud_fin_entrega) {
		this.latitud_fin_entrega = latitud_fin_entrega;
	}
	public String getLongitud_fin_entrega() {
		return longitud_fin_entrega;
	}
	public void setLongitud_fin_entrega(String longitud_fin_entrega) {
		this.longitud_fin_entrega = longitud_fin_entrega;
	}
	public String getImporte_cobrado() {
		return importe_cobrado;
	}
	public void setImporte_cobrado(String importe_cobrado) {
		this.importe_cobrado = importe_cobrado;
	}
	public String getObservaciones() {
		return observaciones;
	}
	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}
	public String getTipo_cobro() {
		return tipo_cobro;
	}
	public void setTipo_cobro(String tipo_cobro) {
		this.tipo_cobro = tipo_cobro;
	}
	public String getAsignacionConcat() {
		return asignacionConcat;
	}
	public void setAsignacionConcat(String asignacionConcat) {
		this.asignacionConcat = asignacionConcat;
	}
	public String getFinConcat() {
		return finConcat;
	}
	public void setFinConcat(String finConcat) {
		this.finConcat = finConcat;
	}
	public String getInicioConcat() {
		return inicioConcat;
	}
	public void setInicioConcat(String inicioConcat) {
		this.inicioConcat = inicioConcat;
	}
	public String getRuta() {
		return ruta;
	}
	public void setRuta(String ruta) {
		this.ruta = ruta;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getTransporteNombre() {
		return transporteNombre;
	}
	public void setTransporteNombre(String transporteNombre) {
		this.transporteNombre = transporteNombre;
	}
	public String getNumeroChofer() {
		return numeroChofer;
	}
	public void setNumeroChofer(String numeroChofer) {
		this.numeroChofer = numeroChofer;
	}
	public String getIngresos() {
		return ingresos;
	}
	public void setIngresos(String ingresos) {
		this.ingresos = ingresos;
	}
	public String getIngresosCobro() {
		return ingresosCobro;
	}
	public void setIngresosCobro(String ingresosCobro) {
		this.ingresosCobro = ingresosCobro;
	}
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public String getFacturas_cod() {
		return facturas_cod;
	}
	public void setFacturas_cod(String facturas_cod) {
		this.facturas_cod = facturas_cod;
	}
	public String getLatitud_cdo() {
		return latitud_cdo;
	}
	public void setLatitud_cdo(String latitud_cdo) {
		this.latitud_cdo = latitud_cdo;
	}
	public String getLongitud_cdo() {
		return longitud_cdo;
	}
	public void setLongitud_cdo(String longitud_cdo) {
		this.longitud_cdo = longitud_cdo;
	}
	public String getFolio_corte() {
		return folio_corte;
	}
	public void setFolio_corte(String folio_corte) {
		this.folio_corte = folio_corte;
	}
	public String getFolio_carta_porte() {
		return folio_carta_porte;
	}
	public void setFolio_carta_porte(String folio_carta_porte) {
		this.folio_carta_porte = folio_carta_porte;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	
	@Override
	public String toString() {
		return "TrayectoDatos [uname=" + uname + ", bnd=" + bnd + ", titulo=" + titulo + ", pedidoPunteo="
				+ pedidoPunteo + ", facturasPunteo=" + facturasPunteo + ", clientePunteo=" + clientePunteo
				+ ", importePedido=" + importePedido + ", importeTrayecto=" + importeTrayecto + ", horasPedido="
				+ horasPedido + ", horasEntrega=" + horasEntrega + ", nombre_cliente=" + nombre_cliente
				+ ", cliente_nombre=" + cliente_nombre + ", dias=" + dias + ", horas=" + horas + ", horasAsig="
				+ horasAsig + ", diasPed=" + diasPed + ", horasPed=" + horasPed + ", horasInicio=" + horasInicio
				+ ", diasEnc=" + diasEnc + ", horasEnc=" + horasEnc + ", diasEncPed=" + diasEncPed + ", horasEncPed="
				+ horasEncPed + ", fechaPedido=" + fechaPedido + ", descripcion_cdo=" + descripcion_cdo
				+ ", descripcion_br=" + descripcion_br + ", repeticion=" + repeticion + ", uname_br=" + uname_br
				+ ", id_traycto=" + id_traycto + ", num_chofer=" + num_chofer + ", nombre_chofer=" + nombre_chofer
				+ ", fecha_asignacion=" + fecha_asignacion + ", hora_asignacion=" + hora_asignacion
				+ ", usuario_asignacion=" + usuario_asignacion + ", fecha_inicio_trayecto=" + fecha_inicio_trayecto
				+ ", fecha_inicio_entrega=" + fecha_inicio_entrega + ", fecha_fin_trayecto=" + fecha_fin_trayecto
				+ ", hora_inicio_trayecto=" + hora_inicio_trayecto + ", hora_fin_trayecto=" + hora_fin_trayecto
				+ ", cliente=" + cliente + ", ode=" + ode + ", pedido=" + pedido + ", factura=" + factura
				+ ", facturas=" + facturas + ", importe=" + importe + ", estatus=" + estatus + ", id_estatus="
				+ id_estatus + ", latitud_inicio_entrega=" + latitud_inicio_entrega + ", longitud_inicio_entrega="
				+ longitud_inicio_entrega + ", latitud_fin_entrega=" + latitud_fin_entrega + ", longitud_fin_entrega="
				+ longitud_fin_entrega + ", importe_cobrado=" + importe_cobrado + ", observaciones=" + observaciones
				+ ", tipo_cobro=" + tipo_cobro + ", asignacionConcat=" + asignacionConcat + ", finConcat=" + finConcat
				+ ", inicioConcat=" + inicioConcat + ", ruta=" + ruta + ", direccion=" + direccion + ", tipo=" + tipo
				+ ", transporteNombre=" + transporteNombre + ", numeroChofer=" + numeroChofer + ", ingresos=" + ingresos
				+ ", ingresosCobro=" + ingresosCobro + ", no=" + no + ", facturas_cod=" + facturas_cod
				+ ", latitud_cdo=" + latitud_cdo + ", longitud_cdo=" + longitud_cdo + ", folio_corte=" + folio_corte + ", folio_carta_porte=" + folio_carta_porte
				+ "]";
	}

	
	
}
