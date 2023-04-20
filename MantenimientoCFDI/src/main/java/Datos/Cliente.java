package Datos;

public class Cliente {
	private String rfc;
	private String formaPago;
	private String descFormaPago;
	private String regimenFiscal;
	private String descRegimenFiscal;
	private String metodoPago;
	private String usoCfdi;
	private String descMetodoPago;
	private String descUsoCfdi;
	
	
	public Cliente() {
		super();
	}
	public String getRfc() {
		return rfc;
	}
	public void setRfc(String rfc) {
		this.rfc = rfc;
	}
	public String getFormaPago() {
		return formaPago;
	}
	public void setFormaPago(String formaPago) {
		this.formaPago = formaPago;
	}
	public String getDescFormaPago() {
		return descFormaPago;
	}
	public void setDescFormaPago(String descFormaPago) {
		this.descFormaPago = descFormaPago;
	}
	public String getRegimenFiscal() {
		return regimenFiscal;
	}
	public void setRegimenFiscal(String regimenFiscal) {
		this.regimenFiscal = regimenFiscal;
	}
	public String getDescRegimenFiscal() {
		return descRegimenFiscal;
	}
	public void setDescRegimenFiscal(String descRegimenFiscal) {
		this.descRegimenFiscal = descRegimenFiscal;
	}
	public String getMetodoPago() {
		return metodoPago;
	}
	public void setMetodoPago(String metodoPago) {
		this.metodoPago = metodoPago;
	}
	public String getUsoCfdi() {
		return usoCfdi;
	}
	public void setUsoCfdi(String usoCfdi) {
		this.usoCfdi = usoCfdi;
	}
	public String getDescMetodoPago() {
		return descMetodoPago;
	}
	public void setDescMetodoPago(String descMetodoPago) {
		this.descMetodoPago = descMetodoPago;
	}
	public String getDescUsoCfdi() {
		return descUsoCfdi;
	}
	public void setDescUsoCfdi(String descUsoCfdi) {
		this.descUsoCfdi = descUsoCfdi;
	}
	@Override
	public String toString() {
		return "Cliente [rfc=" + rfc + ", formaPago=" + formaPago + ", descFormaPago=" + descFormaPago
				+ ", regimenFiscal=" + regimenFiscal + ", descRegimenFiscal=" + descRegimenFiscal + ", metodoPago="
				+ metodoPago + ", usoCfdi=" + usoCfdi + ", descMetodoPago=" + descMetodoPago + ", descUsoCfdi="
				+ descUsoCfdi + "]";
	}
	
	
}
