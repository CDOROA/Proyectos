package Datos;

public class Emisor {
 private String rfc;
 private String regimenFiscal;
 private String nombreEmisor;
 
 
public String getRfc() {
	return rfc;
}
public void setRfc(String rfc) {
	this.rfc = rfc;
}
public String getRegimenFiscal() {
	return regimenFiscal;
}
public void setRegimenFiscal(String regimenFiscal) {
	this.regimenFiscal = regimenFiscal;
}
public String getNombreEmisor() {
	return nombreEmisor;
}
public void setNombreEmisor(String nombreEmisor) {
	this.nombreEmisor = nombreEmisor;
}
@Override
public String toString() {
	return "Emisor [rfc=" + rfc + ", regimenFiscal=" + regimenFiscal + ", nombreEmisor=" + nombreEmisor + "]";
}
 
}
