package cdo.Datos;

public class PedidoCdoDetalle {
	  private int renglon;
	  private String numArt; 
	  private String descripcion;
	  private String cveUnidad;
	  private int cantPedida;
	  private int cantSurt;
	  private int cant72Hrs;
	  private String precioUni;
	  private String importe;
	  private String factura;
	  private String importeFac;
	  private String descuentosFac;
	  private String subtotalFac;
	  private String ivaFac;
	  private String totalFAc;
      private String cdoTraspaso;
	  
	public int getRenglon() {
		return renglon;
	}
	public void setRenglon(int renglon) {
		this.renglon = renglon;
	}
	public String getNumArt() {
		return numArt;
	}
	public void setNumArt(String numArt) {
		this.numArt = numArt;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getCveUnidad() {
		return cveUnidad;
	}
	public void setCveUnidad(String cveUnidad) {
		this.cveUnidad = cveUnidad;
	}
	public int getCantPedida() {
		return cantPedida;
	}
	public void setCantPedida(int cantPedida) {
		this.cantPedida = cantPedida;
	}
	public int getCantSurt() {
		return cantSurt;
	}
	public void setCantSurt(int cantSurt) {
		this.cantSurt = cantSurt;
	}

	public int getCant72Hrs() {
		return cant72Hrs;
	}
	public void setCant72Hrs(int cant72Hrs) {
		this.cant72Hrs = cant72Hrs;
	}
	public String getPrecioUni() {
		return precioUni;
	}
	public void setPrecioUni(String precioUni) {
		this.precioUni = precioUni;
	}
	public String getImporte() {
		return importe;
	}
	public void setImporte(String importe) {
		this.importe = importe;
	}
	
	public String getFactura() {
		return factura;
	}
	public void setFactura(String factura) {
		this.factura = factura;
	}

	public String getImporteFac() {
		return importeFac;
	}
	public void setImporteFac(String importeFac) {
		this.importeFac = importeFac;
	}
	public String getDescuentosFac() {
		return descuentosFac;
	}
	public void setDescuentosFac(String descuentosFac) {
		this.descuentosFac = descuentosFac;
	}
	public String getSubtotalFac() {
		return subtotalFac;
	}
	public void setSubtotalFac(String subtotalFac) {
		this.subtotalFac = subtotalFac;
	}
	public String getIvaFac() {
		return ivaFac;
	}
	public void setIvaFac(String ivaFac) {
		this.ivaFac = ivaFac;
	}
	public String getTotalFAc() {
		return totalFAc;
	}
	public void setTotalFAc(String totalFAc) {
		this.totalFAc = totalFAc;
	}

	public String getCdoTraspaso() {
		return cdoTraspaso;
	}
	public void setCdoTraspaso(String cdp_traspaso) {
		this.cdoTraspaso = cdp_traspaso;
	}
	public PedidoCdoDetalle( ) {
		super();
		this.renglon = 0;
		this.numArt = "";
		this.descripcion = "";
		this.cveUnidad = "";
		this.cantPedida = 0;
		this.cantSurt = 0;
		this.cant72Hrs = 0;
		this.precioUni = "";
		this.importe = "";
		this.factura ="";
		this.importeFac= "";
		this.descuentosFac = "";
		this.subtotalFac= "";
		this.ivaFac= "";
		this.totalFAc= "";
		this.cdoTraspaso="";
	}
	
	@Override
	public String toString() {
		return "PedidoCdoDetalle [renglon=" + renglon + ", numArt=" + numArt + ", descripcion=" + descripcion
				+ ", cveUnidad=" + cveUnidad + ", cantPedida=" + cantPedida + ", cantSurt=" + cantSurt + ", cant72Hrs="
				+ cant72Hrs + ", precioUni=" + precioUni + ", importe=" + importe + ", factura=" + factura
				+ ", importeFac=" + importeFac + ", descuentosFac=" + descuentosFac + ", subtotalFac=" + subtotalFac
				+ ", ivaFac=" + ivaFac + ", totalFAc=" + totalFAc + "]";
	}
	
 
}
