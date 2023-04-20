package cdo.Datos;

import java.io.Serializable;
import java.util.List;

public class Linea_Bancaria_Lista_Bancos implements Serializable {	

	private static final long serialVersionUID = 1L;
	
	private List<Linea_Bancaria_Banamex> linea_bancaria_banamex;
	private List<Linea_Bancaria_HSBC> linea_bancaria_HSBC;
	private List<Linea_Bancaria_Banorte> linea_bancaria_banorte;
	private List<Linea_Bancaria_BBVA> linea_bancaria_BBVA;
	private List<Linea_Bancaria_Azteca> linea_bancaria_azteca;
		
	public Linea_Bancaria_Lista_Bancos() {
		super();
	}

	public Linea_Bancaria_Lista_Bancos(List<Linea_Bancaria_Banamex> linea_bancaria_banamex,
			List<Linea_Bancaria_HSBC> linea_bancaria_HSBC, List<Linea_Bancaria_Banorte> linea_bancaria_banorte,
			List<Linea_Bancaria_BBVA> linea_bancaria_BBVA, List<Linea_Bancaria_Azteca> linea_bancaria_azteca) {
		super();
		this.linea_bancaria_banamex = linea_bancaria_banamex;
		this.linea_bancaria_HSBC = linea_bancaria_HSBC;
		this.linea_bancaria_banorte = linea_bancaria_banorte;
		this.linea_bancaria_BBVA = linea_bancaria_BBVA;
		this.linea_bancaria_azteca = linea_bancaria_azteca;
	}

	public List<Linea_Bancaria_Banamex> getLinea_bancaria_banamex() {
		return linea_bancaria_banamex;
	}

	public void setLinea_bancaria_banamex(List<Linea_Bancaria_Banamex> linea_bancaria_banamex) {
		this.linea_bancaria_banamex = linea_bancaria_banamex;
	}

	public List<Linea_Bancaria_HSBC> getLinea_bancaria_HSBC() {
		return linea_bancaria_HSBC;
	}

	public void setLinea_bancaria_HSBC(List<Linea_Bancaria_HSBC> linea_bancaria_HSBC) {
		this.linea_bancaria_HSBC = linea_bancaria_HSBC;
	}

	public List<Linea_Bancaria_Banorte> getLinea_bancaria_banorte() {
		return linea_bancaria_banorte;
	}

	public void setLinea_bancaria_banorte(List<Linea_Bancaria_Banorte> linea_bancaria_banorte) {
		this.linea_bancaria_banorte = linea_bancaria_banorte;
	}

	public List<Linea_Bancaria_BBVA> getLinea_bancaria_BBVA() {
		return linea_bancaria_BBVA;
	}

	public void setLinea_bancaria_BBVA(List<Linea_Bancaria_BBVA> linea_bancaria_BBVA) {
		this.linea_bancaria_BBVA = linea_bancaria_BBVA;
	}

	public List<Linea_Bancaria_Azteca> getLinea_bancaria_azteca() {
		return linea_bancaria_azteca;
	}

	public void setLinea_bancaria_azteca(List<Linea_Bancaria_Azteca> linea_bancaria_azteca) {
		this.linea_bancaria_azteca = linea_bancaria_azteca;
	}

	@Override
	public String toString() {
		return "Linea_Bancaria_Lista_Bancos [linea_bancaria_banamex=" + linea_bancaria_banamex
				+ ", linea_bancaria_HSBC=" + linea_bancaria_HSBC + ", linea_bancaria_banorte=" + linea_bancaria_banorte
				+ ", linea_bancaria_BBVA=" + linea_bancaria_BBVA + ", linea_bancaria_azteca=" + linea_bancaria_azteca
				+ "]";
	}

}
