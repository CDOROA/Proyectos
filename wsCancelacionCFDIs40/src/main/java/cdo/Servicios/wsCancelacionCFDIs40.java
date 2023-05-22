package cdo.Servicios;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import cdo.Datos.Comprobante;
import cdo.Datos.Documento;
import cdo.Datos.Querys;
import cdo.Datos.RespuestaUsuario;
import cdo.Datos.validaVersion;
import cdo.Persistencia.ConsumirServicioWeb;
import cdo.Persistencia.GestorCancela;
import cdo.Util.ClsQuery;
import cdo.Util.Cls_Logs;
import cdo.Util.ConexionBD;

	@Path("/cancelacionCFDI")
	public class wsCancelacionCFDIs40 {
		
		
		List<String> log =new ArrayList<>();
		@GET
		@Path("/cancelaCFDI")
		@Produces({MediaType.TEXT_PLAIN})
		@Consumes(MediaType.APPLICATION_JSON)
	    public String cancelacionCFDI(@QueryParam("cdo")  String cdo, @QueryParam("serie") String serie, @QueryParam ("folio") String folio) {
 // public static String cancelacionCFDI( String cdo, String serie, String folio) {
			String rsp ="false";
			if(serie==null||(serie.replace(" ", "").length()<=0)) {
				rsp ="No se tiene serie";
			}
			if(folio==null||(folio.replace(" ", "").length()<=0)) {
				rsp ="No se tiene folio";
			}
			validaVersion vv=validaVersion(cdo,serie);
			if(vv.isValidaVersion()) {
				boolean validaSellado=validaSellado(cdo,serie,folio);
				if(validaSellado){
					Documento doc=traeInfoDoc(cdo,serie,folio,vv.getTipoDoc());
					RespuestaUsuario resultado = ConsumirServicioWeb.ConsumeWS(doc);
					if(resultado.getRespuestaObjeto41().getAcuses()[0].getOperacionExitosa()) {
						rsp="Documento Cancelado";
						Cls_Logs.insertarLog(cdo, doc.getTipoDoc(), doc.getDocumento(), serie, folio, String.valueOf(resultado.getRespuestaObjeto41().getAcuses()[0].getOperacionExitosa()));
						//System.out.println(doc.getDocumento());
						Cls_Logs.insertarLogCancelado(cdo, doc.getUname_br(), doc.getTipoDoc(), doc.getDocumento(), doc.getSerie(), doc.getFolio(), rsp+": "+resultado.getRespuestaObjeto41().getAcuses()[0].getOperacionExitosa());
					}else {
						rsp="respuesta: "+resultado.getRespuestaObjeto41().getAcuses()[0].getOperacionExitosa()+"\n";
						rsp+="Error: "+resultado.getRespuestaObjeto41().getAcuses()[0].getErrorGeneral()+"\n";
						rsp+="Detalle: "+resultado.getRespuestaObjeto41().getAcuses()[0].getErrorDetallado();
						Cls_Logs.insertarLog(cdo, doc.getTipoDoc(), doc.getDocumento(), serie, folio, rsp+": "+String.valueOf(resultado.getRespuestaObjeto41().getAcuses()[0].getOperacionExitosa()));
						//System.out.println(doc.getDocumento());
						//Cls_Logs.insertarLogCancelado(cdo, doc.getUname_br(), doc.getTipoDoc(), doc.getDocumento(), doc.getSerie(), doc.getFolio(), rsp+": "+resultado.getRespuestaObjeto41().getAcuses()[0].getOperacionExitosa());
					}
				}else {
					rsp="Documento no sellado";
					Cls_Logs.insertarLog(cdo, "0", "0", serie, folio, rsp);
				}
			}else {
				rsp="Version no Valida";
				Cls_Logs.insertarLog(cdo, "0", "0", serie, folio, rsp);
			}
			return rsp;
		}

		private static Documento traeInfoDoc(String cdo, String serie, String folio, String tipoDoc) {
			Connection connBD = null;
			Documento doc=new Documento();
	    	try
	    	{
		    	connBD = ConexionBD.AbrirConexionBD(cdo);
		    	List<Querys> listaQuerys = ClsQuery.ConsultaTablaQuerysBD(cdo, connBD);
		    	PreparedStatement pstmt = null; 	      	
		    	doc = GestorCancela.traerInfoDoc(cdo,connBD,pstmt,listaQuerys, serie,folio,tipoDoc);     	        
	    	}
	    	  catch(Exception ex)
	    	{
	    		System.out.println("Error En metodo consultaDescripcion " + ex.toString() );
	    	}finally
			{
				try {connBD.close();} catch (SQLException e) {e.printStackTrace();}
			}
			return doc;
		}

		private static boolean validaSellado(String cdo, String serie, String folio) {
			Connection connBD = null;
			boolean validar=false;
	    	try
	    	{
		    	connBD = ConexionBD.AbrirConexionBD(cdo);
		    	List<Querys> listaQuerys = ClsQuery.ConsultaTablaQuerysBD(cdo, connBD);
		    	PreparedStatement pstmt = null; 	      	
		    	validar = GestorCancela.validaSellado(cdo,connBD,pstmt,listaQuerys, serie,folio);     	        
	    	}
	    	  catch(Exception ex)
	    	{
	    		System.out.println("Error En metodo consultaDescripcion " + ex.toString() );
	    	}finally
			{
				try {connBD.close();} catch (SQLException e) {e.printStackTrace();}
			}
			return validar;
		}

		private static validaVersion validaVersion(String cdo, String serie) {
			Connection connBD = null;
			validaVersion validar=new validaVersion();
	    	try
	    	{
		    	connBD = ConexionBD.AbrirConexionBD(cdo);
		    	List<Querys> listaQuerys = ClsQuery.ConsultaTablaQuerysBD(cdo, connBD);
		    	PreparedStatement pstmt = null; 	      	
		    	validar = GestorCancela.validaVersion(cdo,connBD,pstmt,listaQuerys, serie);     	        
	    	}
	    	  catch(Exception ex)
	    	{
	    		System.out.println("Error En metodo consultaDescripcion " + ex.toString() );
	    	}finally
			{
				try {connBD.close();} catch (SQLException e) {e.printStackTrace();}
			}
			return validar;
		}

}
