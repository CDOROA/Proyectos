package Datos;

public class CFDI {
	private String descripcion;
	private String serie;
	private String folio;
	private String ode;
	private String pedido;
	private String fechaPedido;
	private String fechaCFDI;
	private String numCliente;
	private String nombreCliente;
	private String fecha_pro;
	private String hora_pro;
	private String estatus;
	private String sellado;
	private String prioridad;
	private int tipoDoc;
	private String documento;
	
	
	public CFDI() {
		super();
	}
	
	
	public String getDocumento() {
		return documento;
	}


	public void setDocumento(String documento) {
		this.documento = documento;
	}


	public int getTipoDoc() {
		return tipoDoc;
	}


	public void setTipoDoc(int tipoDoc) {
		this.tipoDoc = tipoDoc;
	}


	public String getSellado() {
		return sellado;
	}


	public void setSellado(String sellado) {
		this.sellado = sellado;
	}


	public String getPrioridad() {
		return prioridad;
	}


	public void setPrioridad(String prioridad) {
		this.prioridad = prioridad;
	}


	public String getEstatus() {
		return estatus;
	}


	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}


	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getSerie() {
		return serie;
	}

	public void setSerie(String serie) {
		this.serie = serie;
	}

	public String getFolio() {
		return folio;
	}

	public void setFolio(String folio) {
		this.folio = folio;
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

	public String getFechaPedido() {
		return fechaPedido;
	}

	public void setFechaPedido(String fechaPedido) {
		this.fechaPedido = fechaPedido;
	}

	public String getFechaCFDI() {
		return fechaCFDI;
	}

	public void setFechaCFDI(String fechaCFDI) {
		this.fechaCFDI = fechaCFDI;
	}

	public String getNumCliente() {
		return numCliente;
	}

	public void setNumCliente(String numCliente) {
		this.numCliente = numCliente;
	}

	public String getNombreCliente() {
		return nombreCliente;
	}

	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}

	public String getFecha_pro() {
		return fecha_pro;
	}

	public void setFecha_pro(String fecha_pro) {
		this.fecha_pro = fecha_pro;
	}

	public String getHora_pro() {
		return hora_pro;
	}

	public void setHora_pro(String hora_pro) {
		this.hora_pro = hora_pro;
	}

	@Override
	public String toString() {
		return "CFDI [descripcion=" + descripcion + ", serie=" + serie + ", folio=" + folio + ", ode=" + ode
				+ ", pedido=" + pedido + ", fechaPedido=" + fechaPedido + ", fechaCFDI=" + fechaCFDI + ", numCliente="
				+ numCliente + ", nombreCliente=" + nombreCliente + ", fecha_pro=" + fecha_pro + ", hora_pro="
				+ hora_pro + ", estatus=" + estatus + ", sellado=" + sellado + ", prioridad=" + prioridad + ", tipoDoc="
				+ tipoDoc + ", documento=" + documento + "]";
	}
	
}
