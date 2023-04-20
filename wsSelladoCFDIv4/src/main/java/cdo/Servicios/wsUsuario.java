package cdo.Servicios;

import java.sql.SQLException;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import com.google.gson.Gson;

import cdo.Entidades.Respuesta;
import cdo.Persistencia.GestorSellado;

@Path("/comprobante")
public class wsUsuario
{
    GestorSellado  gSell;
    Gson gson;
    
    private Respuesta respuesta = new Respuesta();    
    public wsUsuario() 
    {
        this.gSell = new GestorSellado();  
        this.gson = new Gson();
    }

    @GET
    @Path("/documento")
    @Produces({ "application/json; charset=ISO-8859-1" })
    public String selladoCartaPorte(@QueryParam("cdo") String cdo, @QueryParam("serie") String serie, @QueryParam("folio") String folio,@QueryParam("correo")  String correo, @QueryParam("request")  String request, @QueryParam("grupo")  String grupo) throws SQLException 
    {
    	respuesta = gSell.iniciarProceso(cdo,serie,folio,correo,request,grupo);
    	return gson.toJson(respuesta);
	    
	}
    
    @GET
    @Path("/base64CBB")
    @Produces({ "application/json; charset=ISO-8859-1" })
    public String crearPngServidor(@QueryParam("cdo") String cdo, @QueryParam("serie") String serie, @QueryParam("folio") String folio,@QueryParam("correo")  String correo) throws SQLException 
    {
    	gSell.createFilePNG();
    	return gson.toJson(respuesta);
	    
	 }
    

}