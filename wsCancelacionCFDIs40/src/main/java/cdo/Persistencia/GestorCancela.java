package cdo.Persistencia;

import java.io.StringReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import cdo.Datos.Comprobante;
import cdo.Datos.Documento;
import cdo.Datos.validaVersion;
import cdo.Datos.Querys;
import cdo.Util.ClsQuery;

public class GestorCancela {

	public static validaVersion validaVersion(String cdo, Connection connBD, PreparedStatement pstmt,
			List<Querys> listaQuerys, String serie) {
		String[] querys = new String[25];
		validaVersion valida = new validaVersion(); 
		try {			   
	        querys = ClsQuery.LimpiaListaQuerys(querys);
	        querys = ClsQuery.ObtieneQuerys(1,listaQuerys, querys);
	        querys = inicializaQuery1(cdo,serie,querys);
	        ClsQuery.ImprimeQuerysConsola(querys, true, "query 1");
	       
	        ResultSet rs = ClsQuery.EjecutarQuery(querys[0], querys[1], querys[2], querys[3], querys[4], querys[5], querys[6], querys[7], querys[8], querys[9], querys[10], querys[11], 
					querys[12], querys[13], querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], querys[21], querys[22], querys[23], querys[24], cdo, pstmt, connBD);
	        while (rs.next())
            {
                try
                {
                	if((rs.getString("validaVersion").replace(" ", "")).length()>0) {
                		valida.setValidaVersion(true);
                		switch(rs.getString("tipo_comp")) {
                		case "PAG":
                			valida.setTipoDoc("6");
                			break;
                			default:
                				valida.setTipoDoc("null");
                		}
                	}else {
                		valida.setValidaVersion(false);
                	}
                }
                catch (Exception e) 
                {	                	 
                	System.out.println( "Error al obtener Ruta de almacenamiento: "+ e.toString());
                }
            }
		
		}catch(Exception e) {
			//Cls_Logs.insertarLog(new LogPDF(),cdo,"","","No se pudo recuperar el cuerpo del correo");
			//
			System.out.println("Error al entrar al metodo RecuperaRuta: " + e);
		}
		return valida;
	}

	private static String[] inicializaQuery1(String cdo, String serie, String[] querys) {
		for(int i=0;i<querys.length;i++) {
			querys[i]=querys[i].replace("{SERIE}", serie);
		}
		return querys;
	}

	public static boolean validaSellado(String cdo, Connection connBD, PreparedStatement pstmt,
			List<Querys> listaQuerys, String serie, String folio) {
		String[] querys = new String[25];
		boolean valida = false; 
		try {			   
	        querys = ClsQuery.LimpiaListaQuerys(querys);
	        querys = ClsQuery.ObtieneQuerys(2,listaQuerys, querys);
	        querys = inicializaQuery2(cdo,serie,folio,querys);
	        ClsQuery.ImprimeQuerysConsola(querys, true, "query 2");
	       
	        ResultSet rs = ClsQuery.EjecutarQuery(querys[0], querys[1], querys[2], querys[3], querys[4], querys[5], querys[6], querys[7], querys[8], querys[9], querys[10], querys[11], 
					querys[12], querys[13], querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], querys[21], querys[22], querys[23], querys[24], cdo, pstmt, connBD);
	        while (rs.next())
            {
                try
                {
                	if((rs.getString("validaSellado").replace(" ", "")).length()>0) {
                		valida=true;
                	}else {
                		valida=false;
                	}
                }
                catch (Exception e) 
                {	                	 
                   // System.out.println( "Error al obtener Ruta de almacenamiento: "+ e.toString());
                }
            }
		
		}catch(Exception e) {
			//Cls_Logs.insertarLog(new LogPDF(),cdo,"","","No se pudo recuperar el cuerpo del correo");
			//System.out.println("Error al entrar al metodo RecuperaRuta: " + e);
		}
		return valida;
	}

	private static String[] inicializaQuery2(String cdo, String serie, String folio, String[] querys) {
		for(int i=0;i<querys.length;i++) {
			querys[i]=querys[i].replace("{SERIE}", serie);
			querys[i]=querys[i].replace("{FOLIO}", folio);
		}
		return querys;
	}

	public static Documento traerInfoDoc(String cdo, Connection connBD, PreparedStatement pstmt,
			List<Querys> listaQuerys, String serie, String folio, String tipoDoc) {
		String[] querys = new String[25];
		Documento d = new Documento();
		try {			   
	        querys = ClsQuery.LimpiaListaQuerys(querys);
	        if(tipoDoc.equalsIgnoreCase("6")) {
	        	querys = ClsQuery.ObtieneQuerys(4,listaQuerys, querys);
	        }else {
	        	querys = ClsQuery.ObtieneQuerys(3,listaQuerys, querys);
	        }
	        querys = inicializaQuery2(cdo,serie,folio,querys);
	        	ClsQuery.ImprimeQuerysConsola(querys, true, "query 1");
	       
	        ResultSet rs = ClsQuery.EjecutarQuery(querys[0], querys[1], querys[2], querys[3], querys[4], querys[5], querys[6], querys[7], querys[8], querys[9], querys[10], querys[11], 
					querys[12], querys[13], querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], querys[21], querys[22], querys[23], querys[24], cdo, pstmt, connBD);
	        while (rs.next())
            {
                try
                {
                	d.setDocumento(rs.getString("documento"));
                	d.setFolio(folio);
                	d.setSerie(serie);
                	d.setUname_br(rs.getString("uname"));
                	d.setPassword(rs.getString("password"));
                	d.setRfcEmisor(rs.getString("rfc"));
                	d.setSucursal(rs.getString("sucursal"));
                	d.setTipoDoc(rs.getString("tipo_documento"));
                	d.setUsuario(rs.getString("usuario"));
                	d.setCuenta(rs.getString("cuenta"));
                	d.setUuid(obtenerValor("tfd:TimbreFiscalDigital","UUID", "0", rs.getString("codigo_xml")));
                }
                catch (Exception e) 
                {	                	 
                   // System.out.println( "Error al obtener Ruta de almacenamiento: "+ e.toString());
                }
            }
		
		}catch(Exception e) {
			//Cls_Logs.insertarLog(new LogPDF(),cdo,"","","No se pudo recuperar el cuerpo del correo");
			//System.out.println("Error al entrar al metodo RecuperaRuta: " + e);
		}
		return d;
	}
	private static String obtenerValor(String nodo, String campo, String funcion,String xml)
	{
	String valor = "";
	if (!nodo.equals("")) 
	{
	
		try
		{	
			Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new InputSource(new StringReader(xml)));
			NodeList nList = document.getElementsByTagName(nodo);
			if (nList.getLength()>0) 
			{
				if (!funcion.equals("size"))
				{
					Node nNode = nList.item(Integer.parseInt(funcion));
					try
					{
						if(nNode.getNodeType() == Node.ELEMENT_NODE) 
						{
							Element eElement = (Element) nNode;
							valor = eElement.getAttribute(campo);
						}
					}
					catch (Exception e) 
					{
//						fillRsp(false,"Error en lectura de XML", false, "");
//						detalle.add("ERROR: "+e.getMessage().toString()+".NODO: "+nodo+". CAMPO: "+campo + ". METODO: "+method+". SECCION: " + funcion );
						valor = "";
					}
				}
				else
				{
					return String.valueOf(nList.getLength());
				}
			}
		}
		catch (Exception e) 
		{
//			fillRsp(false,"Error en lectura de XML", false, "");
//			detalle.add("Error al obtener datos XML. NODO: "+nodo+". CAMPO: "+campo+". METODO: "+method+". ERROR: "+e.getMessage().toString());
		}
		
	}
		return valor;
	}

	public static List<Comprobante> traerComp(String cdo, Connection connBD, PreparedStatement pstmt,
			List<Querys> listaQuerys) {
		String[] querys = new String[25];
		List<Comprobante> c = new ArrayList<Comprobante>();
		try {			   
	        querys = ClsQuery.LimpiaListaQuerys(querys);
	        querys = ClsQuery.ObtieneQuerys(5,listaQuerys, querys);
	        ClsQuery.ImprimeQuerysConsola(querys, true, "query 1");
	        ResultSet rs = ClsQuery.EjecutarQuery(querys[0], querys[1], querys[2], querys[3], querys[4], querys[5], querys[6], querys[7], querys[8], querys[9], querys[10], querys[11], 
					querys[12], querys[13], querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], querys[21], querys[22], querys[23], querys[24], cdo, pstmt, connBD);
	        while (rs.next())
            {
                try
                {	
                	Comprobante cp=new Comprobante();
                	cp.setCdo(rs.getString("cdo"));
                	cp.setFolio(rs.getString("folio"));
                	cp.setSerie(rs.getString("serie"));
                	c.add(cp);
                }
                catch (Exception e) 
                {	                	 
                   // System.out.println( "Error al obtener Ruta de almacenamiento: "+ e.toString());
                }
            }
		
		}catch(Exception e) {
			//Cls_Logs.insertarLog(new LogPDF(),cdo,"","","No se pudo recuperar el cuerpo del correo");
			System.out.println("Error al entrar al metodo RecuperaRuta: " + e);
		}
		return c;
	}

}