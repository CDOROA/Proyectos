package cdo.Datos;

import java.io.Serializable;

public class ArticulosCarritoDetalle implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private int num_pedido;
	private String numArticuloCDO;
	private String numArticuloRC;
	private String nombreArticulo;
	private int cantidadPedida;
	private int cantidadPorSurtirCdo;
	private int cantidadPorSurtirBr;
	private int cantidadPorSurtir72;
	private String precioArticulo;
	private String importe;
	private String esTraspaso;
	private String descuentoXMarca;
	private double porcDescuento;
	private String cdoMacro;
	private String cdoBr;
	private String cdoTraspaso;
	private String imagen_bxa;
	private String imagen_ecommerce;
	private String bloqueo72hrs;
	private String bloqueoExpres;
	public int getNum_pedido() {
		return num_pedido;
	}
	public void setNum_pedido(int num_pedido) {
		this.num_pedido = num_pedido;
	}
	public String getNumArticuloCDO() {
		return numArticuloCDO;
	}
	public void setNumArticuloCDO(String numArticuloCDO) {
		this.numArticuloCDO = numArticuloCDO;
	}
	public String getNumArticuloRC() {
		return numArticuloRC;
	}
	public void setNumArticuloRC(String numArticuloRC) {
		this.numArticuloRC = numArticuloRC;
	}
	public String getNombreArticulo() {
		return nombreArticulo;
	}
	public void setNombreArticulo(String nombreArticulo) {
		this.nombreArticulo = nombreArticulo;
	}
	public int getCantidadPedida() {
		return cantidadPedida;
	}
	public void setCantidadPedida(int cantidadPedida) {
		this.cantidadPedida = cantidadPedida;
	}
	public int getCantidadPorSurtirCdo() {
		return cantidadPorSurtirCdo;
	}
	public void setCantidadPorSurtirCdo(int cantidadPorSurtirCdo) {
		this.cantidadPorSurtirCdo = cantidadPorSurtirCdo;
	}
	public int getCantidadPorSurtirBr() {
		return cantidadPorSurtirBr;
	}
	public void setCantidadPorSurtirBr(int cantidadPorSurtirBr) {
		this.cantidadPorSurtirBr = cantidadPorSurtirBr;
	}
	public int getCantidadPorSurtir72() {
		return cantidadPorSurtir72;
	}
	public void setCantidadPorSurtir72(int cantidadPorSurtir72) {
		this.cantidadPorSurtir72 = cantidadPorSurtir72;
	}
	public String getPrecioArticulo() {
		return precioArticulo;
	}
	public void setPrecioArticulo(String precioArticulo) {
		this.precioArticulo = precioArticulo;
	}
	public String getImporte() {
		return importe;
	}
	public void setImporte(String importe) {
		this.importe = importe;
	}
	public String getEsTraspaso() {
		return esTraspaso;
	}
	public void setEsTraspaso(String esTraspaso) {
		this.esTraspaso = esTraspaso;
	}
	public String getDescuentoXMarca() {
		return descuentoXMarca;
	}
	public void setDescuentoXMarca(String descuentoXMarca) {
		this.descuentoXMarca = descuentoXMarca;
	}
	public double getPorcDescuento() {
		return porcDescuento;
	}
	public void setPorcDescuento(double porcDescuento) {
		this.porcDescuento = porcDescuento;
	}
	public String getCdoMacro() {
		return cdoMacro;
	}
	public void setCdoMacro(String cdoMacro) {
		this.cdoMacro = cdoMacro;
	}
	public String getCdoBr() {
		return cdoBr;
	}
	public void setCdoBr(String cdoBr) {
		this.cdoBr = cdoBr;
	}
	public String getCdoTraspaso() {
		return cdoTraspaso;
	}
	public void setCdoTraspaso(String cdoTraspaso) {
		this.cdoTraspaso = cdoTraspaso;
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
	public String getBloqueo72hrs() {
		return bloqueo72hrs;
	}
	public void setBloqueo72hrs(String bloqueo72hrs) {
		this.bloqueo72hrs = bloqueo72hrs;
	}
	public String getBloqueoExpres() {
		return bloqueoExpres;
	}
	public void setBloqueoExpres(String bloqueoExpres) {
		this.bloqueoExpres = bloqueoExpres;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public ArticulosCarritoDetalle() {
		super();
	}
	
	public ArticulosCarritoDetalle(int num_pedido, String numArticuloCDO, String numArticuloRC, String nombreArticulo,
			int cantidadPedida, int cantidadPorSurtirCdo, int cantidadPorSurtirBr, int cantidadPorSurtir72,
			String precioArticulo, String importe, String esTraspaso, String descuentoXMarca, double porcDescuento,
			String cdoMacro, String cdoBr, String cdoTraspaso, String imagen_bxa, String imagen_ecommerce,
			String bloqueo72hrs, String bloqueoExpres) {
		super();
		this.num_pedido = num_pedido;
		this.numArticuloCDO = numArticuloCDO;
		this.numArticuloRC = numArticuloRC;
		this.nombreArticulo = nombreArticulo;
		this.cantidadPedida = cantidadPedida;
		this.cantidadPorSurtirCdo = cantidadPorSurtirCdo;
		this.cantidadPorSurtirBr = cantidadPorSurtirBr;
		this.cantidadPorSurtir72 = cantidadPorSurtir72;
		this.precioArticulo = precioArticulo;
		this.importe = importe;
		this.esTraspaso = esTraspaso;
		this.descuentoXMarca = descuentoXMarca;
		this.porcDescuento = porcDescuento;
		this.cdoMacro = cdoMacro;
		this.cdoBr = cdoBr;
		this.cdoTraspaso = cdoTraspaso;
		this.imagen_bxa = imagen_bxa;
		this.imagen_ecommerce = imagen_ecommerce;
		this.bloqueo72hrs = bloqueo72hrs;
		this.bloqueoExpres = bloqueoExpres;
	}
	
	@Override
	public String toString() {
		return "ArticulosCarritoDetalle [num_pedido=" + num_pedido + ", numArticuloCDO=" + numArticuloCDO
				+ ", numArticuloRC=" + numArticuloRC + ", nombreArticulo=" + nombreArticulo + ", cantidadPedida="
				+ cantidadPedida + ", cantidadPorSurtirCdo=" + cantidadPorSurtirCdo + ", cantidadPorSurtirBr="
				+ cantidadPorSurtirBr + ", cantidadPorSurtir72=" + cantidadPorSurtir72 + ", precioArticulo="
				+ precioArticulo + ", importe=" + importe + ", esTraspaso=" + esTraspaso + ", descuentoXMarca="
				+ descuentoXMarca + ", porcDescuento=" + porcDescuento + ", cdoMacro=" + cdoMacro + ", cdoBr=" + cdoBr
				+ ", cdoTraspaso=" + cdoTraspaso + ", imagen_bxa=" + imagen_bxa + ", imagen_ecommerce="
				+ imagen_ecommerce + ", bloqueo72hrs=" + bloqueo72hrs + ", bloqueoExpres=" + bloqueoExpres + "]";
	}

	

 
}
