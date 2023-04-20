package cdo.Datos;

import java.util.List;

public class PedidoCdoFacturas {
	
	  private String numfac;
      private double  importeFac;
      private double descuentosFac;
      private double subtotalFac;
      private double ivaFac;
      private double TotalFac;
      private List<PedidoCdoDetalle> detallePedidoCdo;
      
      

	public String getNumfac() {
		return numfac;
	}
	public void setNumfac(String numfac) {
		this.numfac = numfac;
	}
	public double getImporteFac() {
		return importeFac;
	}
	public void setImporteFac(double importeFac) {
		this.importeFac = importeFac;
	}
	public double getDescuentosFac() {
		return descuentosFac;
	}
	public void setDescuentosFac(double descuentosFac) {
		this.descuentosFac = descuentosFac;
	}
	public double getSubtotalFac() {
		return subtotalFac;
	}
	public void setSubtotalFac(double subtotalFac) {
		this.subtotalFac = subtotalFac;
	}
	public double getIvaFac() {
		return ivaFac;
	}
	public void setIvaFac(double ivaFac) {
		this.ivaFac = ivaFac;
	}
	public double getTotalFac() {
		return TotalFac;
	}
	public void setTotalFac(double totalFac) {
		TotalFac = totalFac;
	}
	
	public PedidoCdoFacturas() {
		super();
		this.numfac = "";
		this.importeFac = 0.0F;
		this.descuentosFac =  0.0F;
		this.subtotalFac =  0.0F;
		this.ivaFac =  0.0F;
		this.TotalFac =  0.0F;
		this.detallePedidoCdo = null;
	}
	public List<PedidoCdoDetalle> getDetallePedidoCdo() {
		return detallePedidoCdo;
	}
	public void setDetallePedidoCdo(List<PedidoCdoDetalle> detallePedidoCdo) {
		this.detallePedidoCdo = detallePedidoCdo;
	}
	
	
	@Override
	public String toString() {
		return "PedidoCdoFacturas [numfac=" + numfac + ", importeFac=" + importeFac + ", descuentosFac=" + descuentosFac
				+ ", subtotalFac=" + subtotalFac + ", ivaFac=" + ivaFac + ", TotalFac=" + TotalFac
				+ ", detallePedidoCdo=" + detallePedidoCdo + "]";
	}
	 

}
