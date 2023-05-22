package cdo.Entidades;

import java.io.Serializable;
import java.util.List;

@SuppressWarnings("serial")
public class Respuesta implements Serializable
{
	private int codigoRespuesta;
	private String mensajeRespuesta;
	private boolean respuesta;
	private String msjError;
	private String codigoXML;
	private String codigoCBB;
	private String codigoPDF;
	private String msjExitoso;
	private List<Conceptos> conceptos;
	private String serie;
	private int folio;
	private String cdo;
	public Respuesta() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	public Respuesta(int codigoRespuesta, String mensajeRespuesta, boolean respuesta, String msjError, String codigoXML,
			String codigoCBB, String codigoPDF, String msjExitoso, List<Conceptos> conceptos, String serie, int folio,
			String cdo) {
		super();
		this.codigoRespuesta = codigoRespuesta;
		this.mensajeRespuesta = mensajeRespuesta;
		this.respuesta = respuesta;
		this.msjError = msjError;
		this.codigoXML = codigoXML;
		this.codigoCBB = codigoCBB;
		this.codigoPDF = codigoPDF;
		this.msjExitoso = msjExitoso;
		this.conceptos = conceptos;
		this.serie = serie;
		this.folio = folio;
		this.cdo = cdo;
	}



	public int getCodigoRespuesta() {
		return codigoRespuesta;
	}
	public void setCodigoRespuesta(int codigoRespuesta) {
		this.codigoRespuesta = codigoRespuesta;
	}
	public String getMensajeRespuesta() {
		return mensajeRespuesta;
	}
	public void setMensajeRespuesta(String mensajeRespuesta) {
		this.mensajeRespuesta = mensajeRespuesta;
	}
	public boolean isRespuesta() {
		return respuesta;
	}
	public void setRespuesta(boolean respuesta) {
		this.respuesta = respuesta;
	}
	public String getMsjError() {
		return msjError;
	}
	public void setMsjError(String msjError) {
		this.msjError = msjError;
	}
	public String getCodigoXML() {
		return codigoXML;
	}
	public void setCodigoXML(String codigoXML) {
		this.codigoXML = codigoXML;
	}
	public String getCodigoCBB() {
		return codigoCBB;
	}
	public void setCodigoCBB(String codigoCBB) {
		this.codigoCBB = codigoCBB;
	}
	public String getCodigoPDF() {
		return codigoPDF;
	}
	public void setCodigoPDF(String codigoPDF) {
		this.codigoPDF = codigoPDF;
	}
	public String getMsjExitoso() {
		return msjExitoso;
	}
	public void setMsjExitoso(String msjExitoso) {
		this.msjExitoso = msjExitoso;
	}
	public List<Conceptos> getConceptos() {
		return conceptos;
	}
	public void setConceptos(List<Conceptos> conceptos) {
		this.conceptos = conceptos;
	}
	public String getSerie() {
		return serie;
	}
	public void setSerie(String serie) {
		this.serie = serie;
	}
	public int getFolio() {
		return folio;
	}
	public void setFolio(int folio) {
		this.folio = folio;
	}
	public String getCdo() {
		return cdo;
	}
	public void setCdo(String cdo) {
		this.cdo = cdo;
	}



	@Override
	public String toString() {
		return "Respuesta [codigoRespuesta=" + codigoRespuesta + ", mensajeRespuesta=" + mensajeRespuesta
				+ ", respuesta=" + respuesta + ", msjError=" + msjError + ", codigoXML=" + codigoXML + ", codigoCBB="
				+ codigoCBB + ", codigoPDF=" + codigoPDF + ", msjExitoso=" + msjExitoso + ", conceptos=" + conceptos
				+ ", serie=" + serie + ", folio=" + folio + ", cdo=" + cdo + "]";
	}

	
	
}