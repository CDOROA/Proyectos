package Datos;

public class Nota {
	private String doctoTran;
	private String claveTran;
	private String tipoTran;
	private String folioFiscal;
	private String fechaTran;
	private String numFactura;
	private String fechaFactura;
	private String serie;
	private String txtNota;
	
	
	public Nota() {
		super();
	}
	
	
	public String getDoctoTran() {
		return doctoTran;
	}
	public void setDoctoTran(String doctoTran) {
		this.doctoTran = doctoTran;
	}
	public String getClaveTran() {
		return claveTran;
	}
	public void setClaveTran(String claveTran) {
		this.claveTran = claveTran;
	}
	public String getTipoTran() {
		return tipoTran;
	}
	public void setTipoTran(String tipoTran) {
		this.tipoTran = tipoTran;
	}
	public String getFolioFiscal() {
		return folioFiscal;
	}
	public void setFolioFiscal(String folioFiscal) {
		this.folioFiscal = folioFiscal;
	}
	public String getFechaTran() {
		return fechaTran;
	}
	public void setFechaTran(String fechaTran) {
		this.fechaTran = fechaTran;
	}
	public String getNumFactura() {
		return numFactura;
	}
	public void setNumFactura(String numFactura) {
		this.numFactura = numFactura;
	}
	public String getFechaFactura() {
		return fechaFactura;
	}
	public void setFechaFactura(String fechaFactura) {
		this.fechaFactura = fechaFactura;
	}
	public String getSerie() {
		return serie;
	}
	public void setSerie(String serie) {
		this.serie = serie;
	}
	public String getTxtNota() {
		return txtNota;
	}
	public void setTxtNota(String txtNota) {
		this.txtNota = txtNota;
	}
	@Override
	public String toString() {
		return "Nota [doctoTran=" + doctoTran + ", claveTran=" + claveTran + ", tipoTran=" + tipoTran + ", folioFiscal="
				+ folioFiscal + ", fechaTran=" + fechaTran + ", numFacura=" + numFactura + ", fechaFactura="
				+ fechaFactura + ", serie=" + serie + ", txtNota=" + txtNota + "]";
	}
	
}
