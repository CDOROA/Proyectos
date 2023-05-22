package cdo.Datos;

public class detalleTraspaso72hrsCorreo {
	private int pedido;
	private String numArt;
    private int cantidad;
	private String cdo72hrs;
	private String descripcionCdo72hrs;
	private String correoCdf;
	private String correoCd2;
	private String correoCdl;
	private String correoCdm;
	private String correoCopiaCdf;
	private String correoCopiaCd2;
	private String correoCopiaCdl;
	private String correoCopiaCdm;
	
	
	public int getPedido() {
		return pedido;
	}
	public void setPedido(int pedido) {
		this.pedido = pedido;
	}
	public String getNumArt() {
		return numArt;
	}
	public void setNumArt(String numArt) {
		this.numArt = numArt;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public String getCdo72hrs() {
		return cdo72hrs;
	}
	public void setCdo72hrs(String cdo72hrs) {
		this.cdo72hrs = cdo72hrs;
	}
	public String getDescripcionCdo72hrs() {
		return descripcionCdo72hrs;
	}
	public void setDescripcionCdo72hrs(String descripcionCdo72hrs) {
		this.descripcionCdo72hrs = descripcionCdo72hrs;
	}
	public String getCorreoCdf() {
		return correoCdf;
	}
	public void setCorreoCdf(String correoCdf) {
		this.correoCdf = correoCdf;
	}
	public String getCorreoCd2() {
		return correoCd2;
	}
	public void setCorreoCd2(String correoCd2) {
		this.correoCd2 = correoCd2;
	}
	public String getCorreoCdl() {
		return correoCdl;
	}
	public void setCorreoCdl(String correoCdl) {
		this.correoCdl = correoCdl;
	}
	public String getCorreoCdm() {
		return correoCdm;
	}
	public void setCorreoCdm(String correoCdm) {
		this.correoCdm = correoCdm;
	}
	public String getCorreoCopiaCdf() {
		return correoCopiaCdf;
	}
	public void setCorreoCopiaCdf(String correoCopiaCdf) {
		this.correoCopiaCdf = correoCopiaCdf;
	}
	public String getCorreoCopiaCd2() {
		return correoCopiaCd2;
	}
	public void setCorreoCopiaCd2(String correoCopiaCd2) {
		this.correoCopiaCd2 = correoCopiaCd2;
	}
	public String getCorreoCopiaCdl() {
		return correoCopiaCdl;
	}
	public void setCorreoCopiaCdl(String correoCopiaCdl) {
		this.correoCopiaCdl = correoCopiaCdl;
	}
	public String getCorreoCopiaCdm() {
		return correoCopiaCdm;
	}
	public void setCorreoCopiaCdm(String correoCopiaCdm) {
		this.correoCopiaCdm = correoCopiaCdm;
	}
	public detalleTraspaso72hrsCorreo() {
		super();
	}
	
	public detalleTraspaso72hrsCorreo(int pedido, String numArt, int cantidad, String cdo72hrs,
			String descripcionCdo72hrs, String correoCdf, String correoCd2, String correoCdl, String correoCdm,
			String correoCopiaCdf, String correoCopiaCd2, String correoCopiaCdl, String correoCopiaCdm) {
		super();
		this.pedido = pedido;
		this.numArt = numArt;
		this.cantidad = cantidad;
		this.cdo72hrs = cdo72hrs;
		this.descripcionCdo72hrs = descripcionCdo72hrs;
		this.correoCdf = correoCdf;
		this.correoCd2 = correoCd2;
		this.correoCdl = correoCdl;
		this.correoCdm = correoCdm;
		this.correoCopiaCdf = correoCopiaCdf;
		this.correoCopiaCd2 = correoCopiaCd2;
		this.correoCopiaCdl = correoCopiaCdl;
		this.correoCopiaCdm = correoCopiaCdm;
	}
	@Override
	public String toString() {
		return "detalleTraspaso72hrsCorreo [pedido=" + pedido + ", numArt=" + numArt + ", cantidad=" + cantidad
				+ ", cdo72hrs=" + cdo72hrs + ", descripcionCdo72hrs=" + descripcionCdo72hrs + ", correoCdf=" + correoCdf
				+ ", correoCd2=" + correoCd2 + ", correoCdl=" + correoCdl + ", correoCdm=" + correoCdm
				+ ", correoCopiaCdf=" + correoCopiaCdf + ", correoCopiaCd2=" + correoCopiaCd2 + ", correoCopiaCdl="
				+ correoCopiaCdl + ", correoCopiaCdm=" + correoCopiaCdm + "]";
	}
	
}
