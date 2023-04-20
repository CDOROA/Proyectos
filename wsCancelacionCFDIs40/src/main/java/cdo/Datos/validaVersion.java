package cdo.Datos;

public class validaVersion {
	private boolean validaVersion;
	private String tipoDoc;
	
	
	public validaVersion() {
		super();
	}
	public boolean isValidaVersion() {
		return validaVersion;
	}
	public void setValidaVersion(boolean validaVersion) {
		this.validaVersion = validaVersion;
	}
	public String getTipoDoc() {
		return tipoDoc;
	}
	public void setTipoDoc(String tipoDoc) {
		this.tipoDoc = tipoDoc;
	}
	@Override
	public String toString() {
		return "validaVersion [validaVersion=" + validaVersion + ", tipoDoc=" + tipoDoc + "]";
	}
	
	
}
