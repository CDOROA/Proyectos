package cdo.Servicios;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import cdo.Datos.Querys;
import cdo.Persistencia.clsFAC002;

@Path("acumuleGana")
public class wsGeneraFAC002 {
	String[] querys;
	List<Querys> listaDeQuerys = null;
	
	public wsGeneraFAC002() {
		this.querys = new String[25];
	}
	
	@GET
	@Path("/insertaInformacion")
	@Produces({MediaType.TEXT_PLAIN + "; charset=ISO-8859-1" })
	public String generaInformacionAcumuleYGane(@QueryParam("cdo") String cdo) {
		//System.out.println("Entra"); 
		clsFAC002 facturar = new clsFAC002();
		String rsp = facturar.Fac_Esp(cdo.toLowerCase());
		return rsp;
	}
}
