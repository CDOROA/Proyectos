package cdo.Persistencia;

import java.io.File;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Base64;
import java.util.List;

import org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.Credenciales;
import org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RespuestaOperacionCR;
import org.tempuri.ConexionRemotaLocator;
import org.tempuri.IConexionRemota;

import cdo.Entidades.EjecutaQuerysBD;
import cdo.Entidades.Querys;
import cdo.Entidades.Respuesta;
import cdo.Util.Cls_Querys;
import cdo.Util.ConexionBD;

public class GestorRecuperaDocumento {
	private Respuesta objRespuesta = new Respuesta();
	Credenciales credenciales = new Credenciales("","","");
	public boolean RecuperaDocumento(String cdo, String uname_br,String trayecto, List<Querys> listaQuerys, String folioCfdi) 
	{
		boolean respuestaPac = false;
		RespuestaOperacionCR respuesta = new RespuestaOperacionCR();
		obtenerInformacionParaSellado(cdo,uname_br,trayecto,listaQuerys);
		try
		{
		 
				ConexionRemotaLocator conector=new ConexionRemotaLocator();
				IConexionRemota iconexion = conector.getsoapHttpEndpoint();
				//System.out.println("credenciales" + credenciales.getCuenta());
				//System.out.println("credenciales" + credenciales.getUsuario());
				//System.out.println("credenciales" + credenciales.getPassword());
				
				 respuesta = iconexion.obtenerPDF(credenciales, folioCfdi,  "");
				System.out.println("respuestagetOperacionExitosa." + respuesta.getOperacionExitosa());
				System.out.println("respuestagetErrorGeneral" + respuesta.getErrorGeneral());
				if(respuesta.getOperacionExitosa())
				{
					Base64DecodePdf(respuesta.getPDF(), trayecto);
				}
			 
				respuestaPac = respuesta.getOperacionExitosa();
		}
		catch (Exception e) 
		{
			 
		}
		return respuestaPac;
	}
	private void obtenerInformacionParaSellado(String cdo, String uname_br, String trayecto, List<Querys> ListaQuerys) 
	{
		try
		{
			Connection connBD = null;
	        PreparedStatement pstmt = null;
	        ResultSet rs = null;
	        try
	        {
	        	String[] querys = new String[25];
	        	connBD = ConexionBD.AbrirConexionBDD(cdo);
	        	querys = inicializacionQrys(querys, ListaQuerys, cdo, 3,uname_br,trayecto);
//	        	Arrays.asList(querys).forEach(System.out::println);
	            pstmt = connBD.prepareStatement("{call " + cdo.toUpperCase() + ".usp_EXECUTE_QUERY_CP(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
	            rs = EjecutaQuerysBD.EjecutarQuery(querys[0], querys[1], querys[2], querys[3], querys[4], querys[5], querys[6], querys[7], querys[8], querys[9], querys[10], querys[11], querys[12], querys[13], querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], querys[21], querys[22], querys[23], querys[24], cdo, pstmt, connBD);
	            
	            
	            Cls_Querys.ImprimeQuerysConsola(querys, false, "Recuperando informacion de BD");
	            
	            if (rs != null) 
	            {
	            	
	            	llenarInfoSellado(rs);
				}   
	        }
	        catch (Exception e) 
	        {
	        	objRespuesta.setMsjError("Error al obtener informacion en RecuperaDocumento. ERROR: "+e.getMessage());
				objRespuesta.setRespuesta(false);
			}
	        finally
	        {
				connBD.close();
				pstmt.close();
			}
		}
		catch (Exception e) 
		{
			objRespuesta.setMsjError("Error al llenar insertar en BD XML. ERROR: "+e.getMessage());
			objRespuesta.setRespuesta(false);
		}
	}

	private void llenarInfoSellado(ResultSet rs)
	{
		int idConceptos = 0, idUbicaciones = 0, idMercancias = 0;
		
		try
		{
			while (rs.next()) 
			{
				String tipo = rs.getString("tipo");
					if (tipo.equals("4encabezado")) 
					{
//						System.out.println("ENCABEZADO");
						obtenerCredenciales(rs);
						 
					}
			}
			
		}
		catch (Exception e) 
		{
			objRespuesta.setMsjError("Error al llenar info para sellado en BD. "+e.getMessage());
			objRespuesta.setRespuesta(false);
		}
	}
	
	private Credenciales obtenerCredenciales(ResultSet rs) 
	{
		try
		{
			credenciales.setCuenta(valor("cuenta", rs));
			credenciales.setPassword(valor("password",rs));
			credenciales.setUsuario(valor("usuario", rs));
		}
		catch (Exception e) 
		{
			objRespuesta.setMsjError("Error al obtener credenciales. ERROR: "+e.getMessage());
			objRespuesta.setRespuesta(false);
		}
		return credenciales;
	}
	
	private String valor(String campo, ResultSet rs) 
	{
		String valor = null;
		try
		{
			valor = rs.getString(campo);
		}
		catch (Exception e) 
		{
			objRespuesta.setMsjError("Error al obtener campo: "+campo+". ERROR: "+e.getMessage());
			objRespuesta.setRespuesta(false);
		}
		return valor;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static String[] inicializacionQrys(String[] querys, List<Querys> ListaQuerys, String cdo, int noQry, String uname_br, String trayecto) 
	{
		querys = Cls_Querys.LimpiaListaQuerys(querys);
        querys = ObtieneQuerys(noQry, (List)ListaQuerys, querys, cdo,uname_br,trayecto);
    	return querys;
	}
	
	public static String[] ObtieneQuerys(int noQuery, List<Querys> ListaTodosQuerys, String[] ListaQuerys,  String cdo, String uname_br, String trayecto)
	{
		String[] querys = ListaQuerys;
		int cont = 0;
		String qry="";
		
		for(int item = 0; item < ListaTodosQuerys.size(); item++)
		{
			if(ListaTodosQuerys.get(item).getIndice_query() == noQuery)
			{
				qry= ListaTodosQuerys.get(item).getQuery().toString();
				qry= qry.replace("{CDO}",cdo.toUpperCase());
				qry= qry.replace("{UNAME_BR}",uname_br.toLowerCase());
				qry= qry.replace("{ID_TRAYECTO}",trayecto);
				querys[cont] = qry;
				cont++;
			}
		}
		return querys;
	}

	
	public void Base64DecodePdf(String pdf, String NombreArchivo ) {
		  
		    File file = new File("C:\\FTP\\"+ NombreArchivo + ".pdf");

		    try ( FileOutputStream fos = new FileOutputStream(file); ) {
		      // To be short I use a corrupted PDF string, so make sure to use a valid one if you want to preview the PDF file
		      String b64 = pdf;
		      byte[] decoder = Base64.getDecoder().decode(b64);

		      fos.write(decoder);
		      System.out.println("PDF File Saved");
		    } catch (Exception e) {
		      e.printStackTrace();
		    }
		  }
		
	
}
