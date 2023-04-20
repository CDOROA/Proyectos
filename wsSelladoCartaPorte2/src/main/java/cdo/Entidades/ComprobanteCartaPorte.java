package cdo.Entidades;

import java.io.Serializable;

@SuppressWarnings("serial")
public class ComprobanteCartaPorte extends Identificadores implements Serializable
{
	private String version;
	private String total_dist_rec;
	private String transp_internac;
	public ComprobanteCartaPorte() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ComprobanteCartaPorte(String uname, String folio, String serie, String carta_porte) {
		super(uname, folio, serie, carta_porte);
		// TODO Auto-generated constructor stub
	}
	public ComprobanteCartaPorte(String version, String total_dist_rec, String transp_internac) {
		super();
		this.version = version;
		this.total_dist_rec = total_dist_rec;
		this.transp_internac = transp_internac;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public String getTotal_dist_rec() {
		return total_dist_rec;
	}
	public void setTotal_dist_rec(String total_dist_rec) {
		this.total_dist_rec = total_dist_rec;
	}
	public String getTransp_internac() {
		return transp_internac;
	}
	public void setTransp_internac(String transp_internac) {
		this.transp_internac = transp_internac;
	}
	@Override
	public String toString() {
		return "ComprobanteCartaPorte [version=" + version + ", total_dist_rec=" + total_dist_rec + ", transp_internac="
				+ transp_internac + "]";
	}
	
	
	
	
	
}
