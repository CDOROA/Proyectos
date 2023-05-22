package cdo.Entidades;

import java.io.Serializable;

@SuppressWarnings("serial")
public class ComprobanteTransporte extends Identificadores  implements Serializable
{
	private String cve_transporte;

	public ComprobanteTransporte() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ComprobanteTransporte(String uname, String folio, String serie, String carta_porte) {
		super(uname, folio, serie, carta_porte);
		// TODO Auto-generated constructor stub
	}

	public ComprobanteTransporte(String cve_transporte) {
		super();
		this.cve_transporte = cve_transporte;
	}

	public String getCve_transporte() {
		return cve_transporte;
	}

	public void setCve_transporte(String cve_transporte) {
		this.cve_transporte = cve_transporte;
	}

	@Override
	public String toString() {
		return "ComprobanteTransporte [cve_transporte=" + cve_transporte + "]";
	}
	
	
}
