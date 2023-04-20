package Datos;

public class Documentos {
	private String tipoRelacion;
	private String documentoRelacionado;
	private String folioFiscal;
	
	
	public Documentos() {
		super();
	}
	public String getTipoRelacion() {
		return tipoRelacion;
	}
	public void setTipoRelacion(String tipoRelacion) {
		this.tipoRelacion = tipoRelacion;
	}
	public String getDocumentoRelacionado() {
		return documentoRelacionado;
	}
	public void setDocumentoRelacionado(String documentoRelacionado) {
		this.documentoRelacionado = documentoRelacionado;
	}
	public String getFolioFiscal() {
		return folioFiscal;
	}
	public void setFolioFiscal(String folioFiscal) {
		this.folioFiscal = folioFiscal;
	}
	@Override
	public String toString() {
		return "Documentos [tipoRelacion=" + tipoRelacion + ", documentoRelacionado=" + documentoRelacionado
				+ ", folioFiscal=" + folioFiscal + "]";
	}
}
