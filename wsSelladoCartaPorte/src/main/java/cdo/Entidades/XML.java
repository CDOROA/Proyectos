package cdo.Entidades;

import java.io.Serializable;
import java.util.List;

@SuppressWarnings("serial")
public class XML implements Serializable
{
	private Comprobante comprobante; 
	private List<Conceptos> conceptos;
	private AutoTransporte autoTransporte;
	private ComprobanteCartaPorte comprobanteCartaPorte;
	private List<Mercancias> mercancias;
	private List<Operador> operador;
	private TotalMercancias totalMercancias;
	private ComprobanteTransporte comprobanteTransporte;
	private List<Ubicaciones> ubicaciones;
	private Emisor emisor;
	private Receptor receptor;
	
	public XML() 
	{
		super();
	}
	
	public XML(Comprobante comprobante, List<Conceptos> conceptos, AutoTransporte autoTransporte,
			ComprobanteCartaPorte comprobanteCartaPorte, List<Mercancias> mercancias, List<Operador> operador,
			TotalMercancias totalMercancias, ComprobanteTransporte comprobanteTransporte, List<Ubicaciones> ubicaciones,
			Emisor emisor, Receptor receptor) 
	{
		super();
		this.comprobante = comprobante;
		this.conceptos = conceptos;
		this.autoTransporte = autoTransporte;
		this.comprobanteCartaPorte = comprobanteCartaPorte;
		this.mercancias = mercancias;
		this.operador = operador;
		this.totalMercancias = totalMercancias;
		this.comprobanteTransporte = comprobanteTransporte;
		this.ubicaciones = ubicaciones;
		this.emisor = emisor;
		this.receptor = receptor;
	}
	public Comprobante getComprobante() {
		return comprobante;
	}
	public void setComprobante(Comprobante comprobante) {
		this.comprobante = comprobante;
	}
	public List<Conceptos> getConceptos() {
		return conceptos;
	}
	public void setConceptos(List<Conceptos> conceptos) {
		this.conceptos = conceptos;
	}
	public AutoTransporte getAutoTransporte() {
		return autoTransporte;
	}
	public void setAutoTransporte(AutoTransporte autoTransporte) {
		this.autoTransporte = autoTransporte;
	}
	public ComprobanteCartaPorte getComprobanteCartaPorte() {
		return comprobanteCartaPorte;
	}
	public void setComprobanteCartaPorte(ComprobanteCartaPorte comprobanteCartaPorte) {
		this.comprobanteCartaPorte = comprobanteCartaPorte;
	}
	public List<Mercancias> getMercancias() {
		return mercancias;
	}
	public void setMercancias(List<Mercancias> mercancias) {
		this.mercancias = mercancias;
	}
	public List<Operador> getOperador() {
		return operador;
	}
	public void setOperador(List<Operador> operador) {
		this.operador = operador;
	}
	public TotalMercancias getTotalMercancias() {
		return totalMercancias;
	}
	public void setTotalMercancias(TotalMercancias totalMercancias) {
		this.totalMercancias = totalMercancias;
	}
	public ComprobanteTransporte getComprobanteTransporte() {
		return comprobanteTransporte;
	}
	public void setComprobanteTransporte(ComprobanteTransporte comprobanteTransporte) {
		this.comprobanteTransporte = comprobanteTransporte;
	}
	public List<Ubicaciones> getUbicaciones() {
		return ubicaciones;
	}
	public void setUbicaciones(List<Ubicaciones> ubicaciones) {
		this.ubicaciones = ubicaciones;
	}
	public Emisor getEmisor() {
		return emisor;
	}
	public void setEmisor(Emisor emisor) {
		this.emisor = emisor;
	}
	public Receptor getReceptor() {
		return receptor;
	}
	public void setReceptor(Receptor receptor) {
		this.receptor = receptor;
	}
	@Override
	public String toString() {
		return "XML [comprobante=" + comprobante + ", conceptos=" + conceptos + ", autoTransporte=" + autoTransporte
				+ ", comprobanteCartaPorte=" + comprobanteCartaPorte + ", mercancias=" + mercancias + ", operador="
				+ operador + ", totalMercancias=" + totalMercancias + ", comprobanteTransporte=" + comprobanteTransporte
				+ ", ubicaciones=" + ubicaciones + ", emisor=" + emisor + ", receptor=" + receptor + "]";
	}
	
	
	
}
