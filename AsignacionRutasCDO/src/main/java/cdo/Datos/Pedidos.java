package cdo.Datos;

public class Pedidos 
{
String orden;
String fecha;
String estatus;
String guia;
public Pedidos() {
	super();
	// TODO Auto-generated constructor stub
}
public Pedidos(String orden, String fecha, String estatus, String guia) {
	super();
	this.orden = orden;
	this.fecha = fecha;
	this.estatus = estatus;
	this.guia = guia;
}
public String getOrden() {
	return orden;
}
public void setOrden(String orden) {
	this.orden = orden;
}
public String getFecha() {
	return fecha;
}
public void setFecha(String fecha) {
	this.fecha = fecha;
}
public String getEstatus() {
	return estatus;
}
public void setEstatus(String estatus) {
	this.estatus = estatus;
}
public String getGuia() {
	return guia;
}
public void setGuia(String guia) {
	this.guia = guia;
}
@Override
public String toString() {
	return "Pedidos [orden=" + orden + ", fecha=" + fecha + ", estatus=" + estatus + ", guia=" + guia + "]";
}

}
