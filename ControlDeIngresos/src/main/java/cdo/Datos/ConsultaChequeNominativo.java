package cdo.Datos;

import java.util.List;

public class ConsultaChequeNominativo {
	List<ChequeNominativo> listaChequesNominativos;
	List<Catalogo_Bancos> listBancos;
	
	public ConsultaChequeNominativo() {
		super();
	}
	public ConsultaChequeNominativo(List<ChequeNominativo> listaChequesNominativos, List<Catalogo_Bancos> listBancos) {
		super();
		this.listaChequesNominativos = listaChequesNominativos;
		this.listBancos = listBancos;
	}
	public List<ChequeNominativo> getListaChequesNominativos() {
		return listaChequesNominativos;
	}
	public void setListaChequesNominativos(List<ChequeNominativo> listaChequesNominativos) {
		this.listaChequesNominativos = listaChequesNominativos;
	}
	public List<Catalogo_Bancos> getListBancos() {
		return listBancos;
	}
	public void setListBancos(List<Catalogo_Bancos> listBancos) {
		this.listBancos = listBancos;
	}
	@Override
	public String toString() {
		return "ConsultaChequeNominativo [listaChequesNominativos=" + listaChequesNominativos + ", listBancos="
				+ listBancos + "]";
	}

}
