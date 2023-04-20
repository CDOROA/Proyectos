package cdo.Entidades;

import java.io.Serializable;

@SuppressWarnings("serial")
public class TotalMercancias extends Identificadores implements Serializable
{
	private String num_total_mercancias;

	public TotalMercancias() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TotalMercancias(String uname, String folio, String serie, String carta_porte) {
		super(uname, folio, serie, carta_porte);
		// TODO Auto-generated constructor stub
	}

	public TotalMercancias(String num_total_mercancias) {
		super();
		this.num_total_mercancias = num_total_mercancias;
	}

	public String getNum_total_mercancias() {
		return num_total_mercancias;
	}

	public void setNum_total_mercancias(String num_total_mercancias) {
		this.num_total_mercancias = num_total_mercancias;
	}

	@Override
	public String toString() {
		return "TotalMercancias [num_total_mercancias=" + num_total_mercancias + "]";
	}
		
}
