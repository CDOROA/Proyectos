package cdo.Servicios;

import java.util.ArrayList;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import com.google.gson.Gson;

import cdo.Entidades.Bodega;
import cdo.Entidades.Respuesta;
import cdo.Persistencia.GestorBodega;
import cdo.Persistencia.GestorUsuario;

@Path("/proceso")
public class WsUsuario
{
    GestorUsuario gUsuario;
    Gson gson;
    String[] querys;
    public WsUsuario() 
    {
        this.gUsuario = new GestorUsuario();
        this.gson = new Gson();
        this.querys = new String[25];
    }

    @SuppressWarnings({ })
    @POST
    @Path("/relacionBodega")
    @Produces({ "application/json; charset=ISO-8859-1" })
    public String existencias(@QueryParam("cve_centro")  String cdo, @QueryParam("cliente")  String cliente) 
    {
    	GestorBodega gExistencia = new GestorBodega();
	    String cdoInicial = cdo;
	    
	    ArrayList<Bodega> bodega = new ArrayList<Bodega>();
	    ArrayList<Respuesta> respuesta = new ArrayList<Respuesta>();
	    if (validarParametros(cdo,cliente))
	    {    
	    	cdo = gUsuario.obtenerCDO(Integer.parseInt(cdo));
	    	if (cdo.equals("")) 
		    {
		    	respuesta = gExistencia.respuesta(bodega,0,"El CDO no es valido. CDO: "+cdoInicial,respuesta,2);
		    	return gUsuario.formatoJson(gson, respuesta);
			}
		    
		    try 
	        {
	            respuesta = gExistencia.ConsultarBodega(cdo, bodega,gUsuario,gson,querys,cliente,respuesta);
	        }
	        catch (Exception e) 
	        {
	        	 respuesta = gExistencia.respuesta(bodega,0,"Error al consultar existencias, metodo principal. DETALLE: "+gUsuario.Error(e)+". ARTICULO: "+cliente+". CDO: "+cdo,respuesta,0);
	        	 return gUsuario.formatoJson(gson, respuesta);
	        }
	        return gUsuario.formatoJson(gson, respuesta);
	 
		}
		respuesta = gExistencia.respuesta(bodega,0,"Error, parametros recibidos vacios. CDO: "+cdo+". CLIENTE: "+cliente+".",respuesta,6);
		return gUsuario.formatoJson(gson, respuesta);
	  }
	private boolean validarParametros(String cdo, String articulo) 
	{
		if (!cdo.equals("") && !articulo.equals(""))
		{
			return true;
		}
		return false;
	}
 
}