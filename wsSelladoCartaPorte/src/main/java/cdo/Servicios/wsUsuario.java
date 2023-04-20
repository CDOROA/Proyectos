package cdo.Servicios;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import org.datacontract.schemas._2004._07.Emision_Model_DTO.Credenciales;

import com.google.gson.Gson;

import cdo.Entidades.Querys;
import cdo.Entidades.Respuesta;
import cdo.Persistencia.GestorProcesarXML;
import cdo.Persistencia.GestorRecuperaDocumento;
import cdo.Persistencia.GestorSellado;
import cdo.Persistencia.GestorUsuario;
import cdo.Util.ConexionBD;

@Path("/proceso")
public class wsUsuario
{
    GestorUsuario gUsuario;
    GestorSellado  gestorSellado;
    GestorProcesarXML gestorXML;
    Gson gson;
    String[] querys;
    List<Querys> ListaQuerys ;
    
    private Respuesta respuesta = new Respuesta();    
    public wsUsuario() 
    {
        this.gUsuario = new GestorUsuario();
        this.gestorSellado = new GestorSellado();  
        this.gson = new Gson();
        this.querys = new String[25];
        this.gestorXML = new GestorProcesarXML();
    }

    @GET
    @Path("/selladoCartaPorte")
    @Produces({ "application/json; charset=ISO-8859-1" })
    public List<Respuesta> selladoCartaPorte(@QueryParam("cdo") String cdo, @QueryParam("uname_br") String uname_br, @QueryParam("id_trayecto") String id_trayecto) throws SQLException 
    {
    	List<Respuesta> listarRespuesta = null;
    	listarRespuesta = new ArrayList<Respuesta>();
    	String rsp = "";
    	
    	
    	ListaQuerys = GestorUsuario.ConsultaTablaQuerysBD(cdo.toUpperCase());
    	
    	respuesta = gestorSellado.Sellado(cdo,uname_br,id_trayecto,ListaQuerys);
    	System.out.println("respuesta del Getor: " + respuesta.isRespuesta());
    	respuesta.setCodigoRespuesta(9);
    	respuesta.setMensajeRespuesta(respuesta.getMsjError());
    	
    	if (respuesta.isRespuesta()) 
    	{
    		respuesta.setCodigoRespuesta(3);
        	respuesta.setMensajeRespuesta("Carta Porte Generada.");
        	 		
        	respuesta = gestorXML.GenerarCFDICartaPorte(ListaQuerys,respuesta,cdo,uname_br,id_trayecto);
    		
    		//GestorRecuperaDocumento rPdf = new GestorRecuperaDocumento();
    		//rPdf.Base64DecodePdf(respuesta.getCodigoPDF(), "CartaPorte2_"+ id_trayecto);

		}
    	listarRespuesta.add(respuesta);
	    return listarRespuesta;
	  }


	@GET
    @Path("/recuperaDocumento")
    @Produces({ "application/json; charset=ISO-8859-1" })
    public Respuesta recuperaDoc(@QueryParam("cdo") String cdo, @QueryParam("uname_br") String uname_br, @QueryParam("id_trayecto") String id_trayecto) 
    {
    	String rsp = "";
    	ListaQuerys = GestorUsuario.ConsultaTablaQuerysBD(cdo.toUpperCase());
    	GestorRecuperaDocumento rPdf = new GestorRecuperaDocumento();
    	rPdf.RecuperaDocumento(cdo, uname_br, id_trayecto, ListaQuerys,"31F6EE36-7C90-494A-82AA-E696697F6F95");
	    return respuesta;
	  }
 
}