package cdfis.Persistencia;

import java.io.StringReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import com.mysql.jdbc.Statement;

import cdfis.Datos.ConexionBD;
import cdfis.Datos.DatosCancelacion;
import cdfis.Datos.DatosTemporales;
import cdfis.Datos.cancelacionComprobante;
import cdfis.Datos.logCancelacion;

import cdfis.Datos.Querys;
import cdfis.Datos.RespuestaUsuario;
import cdfis.Datos.Usuario;

import cdfis.util.Cls_Querys;

import cdfis.Datos.EjecutaQuerysBD;


public class GestorCancelacionCfdi 
{
	public List<DatosTemporales> consultarFactura(String documento,String tipo_documento, List<DatosTemporales>	listaConsultaFactura,boolean servicioWeb,String cdo,List<Querys> ListaQuerys,Usuario infoUsu) 
	{
		Connection connBD = null;
		PreparedStatement pstm= null;		
		connBD = ConexionBD.AbrirConexionBD(infoUsu.getUname());
		if (tipo_documento.equals("1")) 
		{
			tipo_documento="Factura";
		}
		String referencia_tran = "Ventas";
		try 
		{
			int noQuery = 109;
			if (cdo.equalsIgnoreCase("kwx"))
			{
				noQuery = 111;
			}
			String[] querys = new String[25];	
			querys = Cls_Querys.LimpiaListaQuerys(querys);
			querys = Cls_Querys.ObtieneQuerys(noQuery, ListaQuerys, querys, cdo);
			System.out.println(querys[0]);
			querys = InicializaQueryNumero2(querys, infoUsu,documento);
			pstm = connBD.prepareStatement("{call " + infoUsu.getUname().toUpperCase() +".usp_EXECUTE_QUERY(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			ResultSet rs = EjecutaQuerysBD.EjecutarQuery(querys[0], querys[1],querys[2], querys[3], querys[4], querys[5], querys[6],
					querys[7], querys[8], querys[9],querys[10], querys[11], querys[12], querys[13], 
					querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], 
					querys[21], querys[22], querys[23], querys[24], infoUsu.getUname(),pstm, connBD);
			
			if (rs != null)
			 {
				listaConsultaFactura=llenarFactura(rs,documento,tipo_documento,referencia_tran,listaConsultaFactura);
				listaConsultaFactura=recuperaFyT(listaConsultaFactura, cdo, ListaQuerys, infoUsu);
			}

		}
		catch(Exception ex)
		{
			String sError= ex.getMessage().toString();
		}
		finally
		{
			try {connBD.close();} catch (SQLException e) {e.printStackTrace();}
			try {pstm.close();} catch (SQLException e) {e.printStackTrace();}
		}	
		return listaConsultaFactura;
	}
			
			
			
			
	private List<DatosTemporales> recuperaFyT(List<DatosTemporales> listaConsultaFactura, String cdo,
			List<Querys> listaQuerys, Usuario infoUsu) {
		for(DatosTemporales d: listaConsultaFactura) {
			Connection connBD = null;
			PreparedStatement pstm= null;		
			connBD = ConexionBD.AbrirConexionBD(infoUsu.getUname());
			try 
			{
				
				String[] querys = new String[25];	
				querys = Cls_Querys.LimpiaListaQuerys(querys);
				querys = Cls_Querys.ObtieneQuerys(112, listaQuerys, querys, cdo);	
				querys = InicializaQueryNumero12(querys, infoUsu,d.getSerie(),d.getFolio());
				pstm = connBD.prepareStatement("{call " + infoUsu.getUname().toUpperCase() +".usp_EXECUTE_QUERY(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
				ResultSet rs = EjecutaQuerysBD.EjecutarQuery(querys[0], querys[1],querys[2], querys[3], querys[4], querys[5], querys[6],
						querys[7], querys[8], querys[9],querys[10], querys[11], querys[12], querys[13], 
						querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], 
						querys[21], querys[22], querys[23], querys[24], infoUsu.getUname(),pstm, connBD);
			
					 while (rs.next())
				        {
						 
						 String xml =  rs.getString("xml");
						 d.setUuid(obtenerValor("tfd:TimbreFiscalDigital","UUID", "0", xml));
				        }
				
				
			}
			catch(Exception ex)
			{
				String sError= ex.getMessage().toString();
			}
			finally
			{
				try {connBD.close();} catch (SQLException e) {e.printStackTrace();}
				try {pstm.close();} catch (SQLException e) {e.printStackTrace();}
			}	
		}

		
		return listaConsultaFactura;
	}




	private String[] InicializaQueryNumero12(String[] querys, Usuario infoUsu, String serie, String folio) {
		for(int i=0;i<querys.length;i++) {
			querys[i]=querys[i].replace("{SERIE}",serie);
			querys[i]=querys[i].replace("{FOLIO}",folio);
		}
		return querys;
	}




	public static List<DatosTemporales> llenarFactura(ResultSet rs,String documento,String tipo_documento, String referencia_tran, List<DatosTemporales> listaConsultaFactura)
	{

		try 
		{
			while(rs.next())
			{
				DatosTemporales datosCancelacion2 = new DatosTemporales();
				datosCancelacion2.setSerie(rs.getString("serie"));
				datosCancelacion2.setFolio(rs.getString("folio"));
				datosCancelacion2.setEmisor(rs.getString("emisor"));
				datosCancelacion2.setCdo(rs.getString("n_corto"));
				datosCancelacion2.setTipodocumento(tipo_documento);
				datosCancelacion2.setFactura(rs.getString("num_fac"));
				datosCancelacion2.setDocumentoacancelar(documento);
				datosCancelacion2.setReferencia(referencia_tran);
				datosCancelacion2.setAv(rs.getString("agent_vend"));
				datosCancelacion2.setCte(rs.getString("num_cli"));
				datosCancelacion2.setNombre(rs.getString("nombre"));
				datosCancelacion2.setRazonocial(rs.getString("razon_social"));
				datosCancelacion2.setFechadocumento(rs.getString("fecha_factura"));				
				datosCancelacion2.setImporte(rs.getString("importe_total"));
				datosCancelacion2.setUuid("NULL");
				if (rs.getString("cancelado").equals("NO")) {
					datosCancelacion2.setCancelado("NO");
				}else {
					datosCancelacion2.setCancelado("SI");
				}
				datosCancelacion2.setCuenta(rs.getString("cuenta"));
				datosCancelacion2.setPassword(rs.getString("password"));
				datosCancelacion2.setUsuario(rs.getString("usuario"));
				datosCancelacion2.setSucursal(rs.getString("sucursal"));
				listaConsultaFactura.add(datosCancelacion2);
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return listaConsultaFactura;
	}
	

	public List<DatosTemporales> actualizarTabla(String documento,String tipo_documento, List<DatosTemporales>	listaConsultaFactura,boolean servicioWeb,String cdo) 
	{
		ConexionBD cn = new ConexionBD();
		Connection con = null;
		PreparedStatement ps=null;
		ResultSet rs;
		Statement st;
		String tipo_doc="";
		String clave_tran=null;
		List<DatosTemporales> listaConsultaFactura2 = new ArrayList<>();
		try 
		{ 
		for (DatosTemporales nombre : listaConsultaFactura) 
		{	
			String cancelado = "Si";
			String sql = "select IFNULL(m.documento_cancelado,'NO') as cancelado,u.nombre_corto,f.num_fac,f.num_fac,f.agent_vend,f.num_cli,c.nombre,c.razon_social,f.fecha_factura,co.total ,co.folio_fiscal,f.uname_br,cre.cuenta,cre.password,cre.usuario,co.serie,co.folio from "+cdo+".FACTURAS as f inner join "+cdo+".CLIENTES as c on f.num_cli = c.num_cte inner join CECOM.UNAME as u on f.uname_br = u.uname left join CFDI.comprobante as co on f.serie_cfd = co.serie and f.folio_cfd = co.folio LEFT JOIN CFDI.cancelacion_comprobante as m on  f.num_fac= documento_cancelado left join CFDI.credenciales_cfdi as cre on f.serie_cfd = cre.serie and cre.uname = f.uname_br and curdate() between cre.fecha_inicio_vig and cre.fecha_fin_vig where f.num_fac = '"+nombre.getDocumentoacancelar()+"' and c.tipo_docto_ft = 'F'";
			String sql2 = "select IFNULL(m.documento_cancelado,'NO') as cancelado,u.nombre_corto,f.num_fac,t.docto_tran,tt.referencia_tran,f.agent_vend,f.num_cli,c.nombre,c.razon_social,t.fecha_tran,co.total,co.folio_fiscal,f.uname,f.uname_br,cre.cuenta,cre.password,cre.usuario,co.serie,co.folio	from "+cdo+".TRANSACFAC as t inner join "+cdo+".FACTURAS as f on t.num_fac = f.num_fac inner join "+cdo+".TIPOTRAN as tt on t.cve_tran = tt.cve_tran and t.tipo_tran = tt.tipo_tran inner join "+cdo+".CLIENTES as c on f.num_cli = c.num_cte inner join CECOM.UNAME as u on f.uname_br = u.uname left join CFDI.ncc_comprobante as co on  t.docto_serie = co.serie and t.docto_folio = co.folio LEFT JOIN CFDI.cancelacion_comprobante as m on  t.docto_tran= documento_cancelado left join CFDI.credenciales_cfdi as cre on t.docto_serie = cre.serie and cre.uname = f.uname_br and curdate() between cre.fecha_inicio_vig and cre.fecha_fin_vig where t.docto_tran = '"+nombre.getDocumentoacancelar()+"' and t.cve_tran = '"+clave_tran+"' group by '"+nombre.getDocumentoacancelar()+"'";
			if (cdo.equalsIgnoreCase("kwx"))
			{
				sql = "select IFNULL(m.documento_cancelado,'NO') as cancelado,u.nombre_corto,f.num_fac,f.num_fac,f.agent_vend,f.num_cli,c.nombre,c.razon_social,f.fecha_factura,co.total ,co.folio_fiscal,f.uname as uname_br,cre.cuenta,cre.password,cre.usuario,co.serie,co.folio from "+cdo+".FACTURAS as f inner join "+cdo+".CLIENTES as c on f.num_cli = c.num_cte inner join "+cdo.toUpperCase()+".UNAME as u on f.uname = u.uname left join CFDI.comprobante as co on f.serie_cfd = co.serie and f.folio_cfd = co.folio LEFT JOIN CFDI.cancelacion_comprobante as m on  f.num_fac= documento_cancelado left join CFDI.credenciales_cfdi as cre on f.serie_cfd = cre.serie and cre.uname = f.uname and curdate() between cre.fecha_inicio_vig and cre.fecha_fin_vig where f.num_fac = '"+nombre.getDocumentoacancelar()+"' and c.tipo_docto_ft = 'F'";
				sql2 = "select IFNULL(m.documento_cancelado,'NO') as cancelado,u.nombre_corto,f.num_fac,t.docto_tran,tt.referencia_tran,f.agent_vend,f.num_cli,c.nombre,c.razon_social,t.fecha_tran,co.total,co.folio_fiscal,f.uname,f.uname as uname_br,cre.cuenta,cre.password,cre.usuario,co.serie,co.folio	from "+cdo+".TRANSACFAC as t inner join "+cdo+".FACTURAS as f on t.num_fac = f.num_fac inner join "+cdo+".TIPOTRAN as tt on t.cve_tran = tt.cve_tran and t.tipo_tran = tt.tipo_tran inner join "+cdo+".CLIENTES as c on f.num_cli = c.num_cte inner join "+cdo+".UNAME as u on f.uname = u.uname left join CFDI.ncc_comprobante as co on  t.docto_serie = co.serie and t.docto_folio = co.folio LEFT JOIN CFDI.cancelacion_comprobante as m on  t.docto_tran= documento_cancelado left join CFDI.credenciales_cfdi as cre on t.docto_serie = cre.serie and cre.uname = f.uname_br and curdate() between cre.fecha_inicio_vig and cre.fecha_fin_vig where t.docto_tran = '"+nombre.getDocumentoacancelar()+"' and t.cve_tran = '"+clave_tran+"' group by '"+nombre.getDocumentoacancelar()+"'";
			}
			
			if(nombre.getTipodocumento().equals("Nota de credito"))	{clave_tran="5";}
			if(nombre.getTipodocumento().equals("Nota de cargo")){clave_tran="6";}
			
			
			try 
			{ 
				con = cn.AbrirConexionBD(cdo);
				st = (Statement) con.createStatement();
				if(nombre.getTipodocumento().equals("Factura"))
				{	
					ps = con.prepareStatement(sql);
					rs = ps.executeQuery();
					
					tipo_doc="Factura";
					if (servicioWeb==true) {
						 cancelado = "No";
					}
					String referencia_tran = "Ventas";
					while (rs.next()) 
					{ 
						DatosTemporales datosCancelacion2 = new DatosTemporales();
						datosCancelacion2.setSerie(rs.getString(rs.getString("serie")));
						datosCancelacion2.setFolio(rs.getString(rs.getString("folio")));
						datosCancelacion2.setCdo(rs.getString("nombre_corto"));
						datosCancelacion2.setTipodocumento(tipo_doc);
						datosCancelacion2.setFactura(rs.getString("num_fac"));
						datosCancelacion2.setDocumentoacancelar(nombre.getDocumentoacancelar());
						datosCancelacion2.setReferencia(referencia_tran);
						datosCancelacion2.setAv(rs.getString("agent_vend"));
						datosCancelacion2.setCte(rs.getString("num_cli"));
						datosCancelacion2.setNombre(rs.getString("nombre"));
						datosCancelacion2.setRazonocial(rs.getString("razon_social"));
						datosCancelacion2.setFechadocumento(rs.getString("fecha_factura"));				
						datosCancelacion2.setImporte(rs.getString("total"));
						datosCancelacion2.setUuid(rs.getString("folio_fiscal"));
						if (rs.getString("cancelado").equals("NO")) {
							datosCancelacion2.setCancelado("NO");
						}else {
							datosCancelacion2.setCancelado("SI");
						}
						listaConsultaFactura2.add(datosCancelacion2);
					}
				}
				else
				{
					if(nombre.getTipodocumento().equals("Nota de credito")){tipo_doc="Nota de credito";}
					if(nombre.getTipodocumento().equals("Nota de cargo")){tipo_doc="Nota de cargo";}
					ps = con.prepareStatement(sql2);
					rs = ps.executeQuery();
					if (servicioWeb==true) {
						 cancelado = "Sí";
					}
					while (rs.next()) 
					{ 
						DatosTemporales datosCancelacion2 = new DatosTemporales();
						datosCancelacion2.setCdo(rs.getString("nombre_corto"));
						datosCancelacion2.setTipodocumento(tipo_doc);
						datosCancelacion2.setFactura(rs.getString("num_fac"));
						datosCancelacion2.setDocumentoacancelar(nombre.getDocumentoacancelar());
						datosCancelacion2.setReferencia(rs.getString("referencia_tran"));
						datosCancelacion2.setAv(rs.getString("agent_vend"));
						datosCancelacion2.setCte(rs.getString("num_cli"));
						datosCancelacion2.setNombre(rs.getString("nombre"));
						datosCancelacion2.setRazonocial(rs.getString("razon_social"));
						datosCancelacion2.setFechadocumento(rs.getString("fecha_tran"));				
						datosCancelacion2.setImporte(rs.getString("total"));
						datosCancelacion2.setUuid(rs.getString("folio_fiscal"));
						if (rs.getString("cancelado").equals("NO")) {
							datosCancelacion2.setCancelado("NO");
						}else {
							datosCancelacion2.setCancelado("SI");
						}
						listaConsultaFactura2.add(datosCancelacion2);
					}
				}
					
			} 
			catch (Exception e) {//System.out.println("el error es: "+e);
				
			}
			
		}
	} 
	catch (Exception e) {} 
	finally 
	{
		try 
		{
			con.close();
			ps.close();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}
		
		return listaConsultaFactura2;
	}
	
	
	
	
	
	
	
	public List<DatosCancelacion> valloresParaServicio(String documento,String tipo_documento,String cdo) 
	{
		ConexionBD cn = new ConexionBD();
		Connection con = null;
		PreparedStatement ps=null;
		ResultSet rs;
		Statement st;
		List<DatosCancelacion> listaConsultaFactura = new ArrayList<>();
		List<DatosTemporales> listaConsultaFactura2 = new ArrayList<>();
		String sql = "select u.nombre_corto,f.num_fac,f.num_fac,f.agent_vend,f.num_cli,c.nombre,c.razon_social,f.fecha_factura,co.total ,co.folio_fiscal,f.uname_br         ,cre.cuenta,cre.password,cre.usuario,co.serie,co.folio from "+cdo+".FACTURAS as f inner join "+cdo+".CLIENTES as c on f.num_cli = c.num_cte inner join CECOM.UNAME as u              on f.uname_br = u.uname left join CFDI.comprobante as co on f.serie_cfd = co.serie and f.folio_cfd = co.folio left join CFDI.credenciales_cfdi as cre on f.serie_cfd = cre.serie and cre.uname = f.uname_br and curdate() between cre.fecha_inicio_vig and cre.fecha_fin_vig where f.num_fac = '"+documento+"' and c.tipo_docto_ft = 'F'";
		if (cdo.equalsIgnoreCase("kwx"))
		{
			sql = "select    u.nombre_corto,f.num_fac,f.num_fac,f.agent_vend,f.num_cli,c.nombre,c.razon_social,f.fecha_factura,co.total ,co.folio_fiscal,f.uname as uname_br,cre.cuenta,cre.password,cre.usuario,co.serie,co.folio from "+cdo+".FACTURAS as f inner join "+cdo+".CLIENTES as c on f.num_cli = c.num_cte inner join "+cdo.toUpperCase()+".UNAME as u on f.uname = u.uname left join CFDI.comprobante as co on f.serie_cfd = co.serie and f.folio_cfd = co.folio LEFT JOIN CFDI.credenciales_cfdi as cre on f.serie_cfd = cre.serie and cre.uname = f.uname and curdate() between cre.fecha_inicio_vig and cre.fecha_fin_vig where f.num_fac = '"+documento+"' and c.tipo_docto_ft = 'F'";
		
		}
		
		
		try 
		{
			con = cn.AbrirConexionBD(cdo);
			st = (Statement) con.createStatement();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
		
			while (rs.next()) 
			{ 
				DatosCancelacion datosCancelacion = new DatosCancelacion();
				datosCancelacion.setNombre_corto(rs.getString("nombre_corto"));
				datosCancelacion.setNum_fac(rs.getString("num_fac"));
				datosCancelacion.setAgent_vend(rs.getInt("agent_vend"));
				datosCancelacion.setNum_cli(rs.getInt("num_cli"));
				datosCancelacion.setNombre(rs.getString("nombre"));
				datosCancelacion.setRazon_social(rs.getString("razon_social"));
				datosCancelacion.setFecha_factura(rs.getString("fecha_factura"));
				datosCancelacion.setTotal(rs.getDouble("total"));
				datosCancelacion.setFolio_fiscal(rs.getString("folio_fiscal"));
				datosCancelacion.setUname_br(rs.getString("uname_br"));				
				datosCancelacion.setCuenta(rs.getString("cuenta"));
				datosCancelacion.setUsuario(rs.getString("usuario"));
				datosCancelacion.setPassword(rs.getString("password"));
				datosCancelacion.setSerie(rs.getString("serie"));
				datosCancelacion.setFolio(rs.getInt("folio"));
				listaConsultaFactura.add(datosCancelacion);
			}

		} 
		catch (Exception e) {} 
		finally 
		{
			try 
			{
				con.close();
				ps.close();
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
		}
		return listaConsultaFactura;
	}
	

	public static boolean insertarCancelacion(String documento, cancelacionComprobante cancelacionComprobante, DatosTemporales datosTemporales,String cdo) 
	{
		ConexionBD cn = new ConexionBD();
		Connection con;
		con = cn.AbrirConexionBD(cdo);
		Statement st;
		PreparedStatement ps=null;
		ResultSet rs = null;
		boolean resultadoSellado = true;
		int tipo_document=0;
		String clave_tran=null;
		try 
		{ 
				
			String sql = "select u.nombre_corto,f.num_fac,f.num_fac,f.agent_vend,f.num_cli,c.nombre,c.razon_social,f.fecha_factura,co.total ,co.folio_fiscal,f.uname_br,         cre.cuenta,cre.password,cre.usuario,co.serie,co.folio from "+cdo+".FACTURAS as f inner join "+cdo+".CLIENTES as c on f.num_cli = c.num_cte inner join CECOM.UNAME as u              on f.uname_br = u.uname left join CFDI.comprobante as co on f.serie_cfd = co.serie and f.folio_cfd = co.folio left join CFDI.credenciales_cfdi as cre on f.serie_cfd = cre.serie and cre.uname = f.uname_br and curdate() between cre.fecha_inicio_vig and cre.fecha_fin_vig where f.num_fac = '"+datosTemporales.getDocumentoacancelar()+"' and c.tipo_docto_ft = 'F'";
			if(datosTemporales.getTipodocumento().equals("Nota de credito"))	{clave_tran="5";}
			if(datosTemporales.getTipodocumento().equals("Nota de cargo")){clave_tran="6";}
			String sql2 = "select u.nombre_corto,f.num_fac,t.docto_tran,tt.referencia_tran,f.agent_vend,f.num_cli,c.nombre,c.razon_social,t.fecha_tran,co.total,co.folio_fiscal,f.uname,f.uname_br,cre.cuenta,cre.password,cre.usuario,co.serie,co.folio	from "+cdo+".TRANSACFAC as t inner join "+cdo+".FACTURAS as f on t.num_fac = f.num_fac inner join "+cdo+".TIPOTRAN as tt on t.cve_tran = tt.cve_tran and t.tipo_tran = tt.tipo_tran inner join "+cdo+".CLIENTES as c on f.num_cli = c.num_cte inner join CECOM.UNAME as u on f.uname_br = u.uname left join CFDI.ncc_comprobante as co on  t.docto_serie = co.serie and t.docto_folio = co.folio left join CFDI.credenciales_cfdi as cre on t.docto_serie = cre.serie and cre.uname = f.uname_br and curdate() between cre.fecha_inicio_vig and cre.fecha_fin_vig where t.docto_tran = '"+datosTemporales.getDocumentoacancelar()+"' and t.cve_tran = '"+clave_tran+"' group by '\"+nombre.getDocumentoacancelar()+\"'";
				//System.out.println("sql: "+sql);
			
			if (cdo.equalsIgnoreCase("kwx"))
			{
				sql = "    select u.nombre_corto,f.num_fac,f.num_fac,f.agent_vend,f.num_cli,c.nombre,c.razon_social,f.fecha_factura,co.total ,co.folio_fiscal,f.uname as uname_br,cre.cuenta,cre.password,cre.usuario,co.serie,co.folio from "+cdo+".FACTURAS as f inner join "+cdo+".CLIENTES as c on f.num_cli = c.num_cte inner join "+cdo.toUpperCase()+".UNAME as u on f.uname = u.uname left join CFDI.comprobante as co on f.serie_cfd = co.serie and f.folio_cfd = co.folio LEFT JOIN CFDI.credenciales as cre on f.serie_cfd = cre.serie and cre.uname = f.uname    and curdate() between cre.fecha_inicio_vig and cre.fecha_fin_vig where f.num_fac = '"+datosTemporales.getDocumentoacancelar()+"' and c.tipo_docto_ft = 'F'";
				sql2 =        "select u.nombre_corto,f.num_fac,t.docto_tran,tt.referencia_tran,f.agent_vend,f.num_cli,c.nombre,c.razon_social,t.fecha_tran,co.total,co.folio_fiscal,f.uname,f.uname as uname_br,cre.cuenta,cre.password,cre.usuario,co.serie,co.folio	from "+cdo+".TRANSACFAC as t inner join "+cdo+".FACTURAS as f on t.num_fac = f.num_fac inner join "+cdo+".TIPOTRAN as tt on t.cve_tran = tt.cve_tran and t.tipo_tran = tt.tipo_tran inner join "+cdo+".CLIENTES as c on f.num_cli = c.num_cte inner join "+cdo+".UNAME as u on f.uname    = u.uname left join CFDI.ncc_comprobante as co on  t.docto_serie = co.serie and t.docto_folio = co.folio LEFT JOIN CFDI.credenciales_cfdi as cre on t.docto_serie = cre.serie and cre.uname = f.uname    and curdate() between cre.fecha_inicio_vig and cre.fecha_fin_vig where t.docto_tran = '"+datosTemporales.getDocumentoacancelar()+"' and t.cve_tran = '"+clave_tran+"' group by '\"+nombre.getDocumentoacancelar()+\"'";
			}
			
			try 
				{
					st = (Statement) con.createStatement();
					if (con != null) 
					{
						
						if(datosTemporales.getTipodocumento().equals("Factura"))
						{	
							tipo_document=1;
							ps = con.prepareStatement(sql);
							rs = ps.executeQuery();
							while (rs.next()) 
							{						
								st.executeUpdate("insert into CFDI.cancelacion_comprobante(`uname`,`uname_br`,`tipo_documento`,`documento_cancelado`,`serie`,`folio`,`status`,`fecha_pro`,`hora_pro`) values ('"+cancelacionComprobante.getUname()+"','"+cancelacionComprobante.getUname_br()+"','"+tipo_document+"','"+datosTemporales.getDocumentoacancelar()+"','"+rs.getString(15)+"','"+rs.getInt(16)+"','"+"1"+"','"+cancelacionComprobante.getFecha_pro()+"','"+cancelacionComprobante.getHora_pro()+"')");
							}
						}
						else
						{
							if(datosTemporales.getTipodocumento().equals("Nota de credito")){tipo_document=2;}
							if(datosTemporales.getTipodocumento().equals("Nota de cargo")){tipo_document=3;}
							ps = con.prepareStatement(sql2);
							rs = ps.executeQuery();
							while (rs.next()) 
							{	
								st.executeUpdate("insert into CFDI.cancelacion_comprobante(`uname`,`uname_br`,`tipo_documento`,`documento_cancelado`,`serie`,`folio`,`status`,`fecha_pro`,`hora_pro`) values ('"+cancelacionComprobante.getUname()+"','"+cancelacionComprobante.getUname_br()+"','"+tipo_document+"','"+datosTemporales.getDocumentoacancelar()+"','"+rs.getString(17)+"','"+rs.getInt(18)+"','"+"1"+"','"+cancelacionComprobante.getFecha_pro()+"','"+cancelacionComprobante.getHora_pro()+"')");
							}
						}

					}
				} 
			catch (SQLException e) 
			{
				//System.out.println("error: "+e);
			} 
	
		} 
		catch (Exception e) {} 
		finally 
		{
			try 
			{
				con.close();
				ps.close();
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
		}
		
		return resultadoSellado;
	}
	
	public static boolean validarMostrado(String documento, List<DatosTemporales>listaConsultaFactura,String cdo) 
	{
		boolean validarMostrado = true;
		if(listaConsultaFactura.size()!=0)
		 {
			 for (DatosTemporales nombre : listaConsultaFactura) {
				 if(documento.equals(nombre.getDocumentoacancelar())) {
				 validarMostrado=false;
				 }
				}

				    
		 }
		return validarMostrado;
	}	
	
	public static boolean insertarLog(RespuestaUsuario respuestaSW,String documento, logCancelacion logCancelacion, DatosTemporales datosTemporales,String cdo) 
	{	
		
		ConexionBD cn = new ConexionBD();
		Connection con;
		con = cn.AbrirConexionBD(cdo);
		Statement st;
		PreparedStatement ps=null;
		ResultSet rs = null;
		boolean respuestaSWW=false;
		if (respuestaSW.getRespuestaString().equals("true")) {
			respuestaSWW=true;
		}
		boolean servicioWeb = respuestaSWW;
		int contador=0;
		int tipo_document=0;
		String clave_tran=null;
		try {
			//System.out.println("log");
			String sql = "select u.nombre_corto,f.num_fac,f.num_fac,f.agent_vend,f.num_cli,c.nombre,c.razon_social,f.fecha_factura,co.total ,co.folio_fiscal,f.uname_br,cre.cuenta,cre.password,cre.usuario,co.serie,co.folio from "+cdo+".FACTURAS as f inner join "+cdo+".CLIENTES as c on f.num_cli = c.num_cte inner join CECOM.UNAME as u on f.uname_br = u.uname left join CFDI.comprobante as co on f.serie_cfd = co.serie and f.folio_cfd = co.folio left join CFDI.credenciales_cfdi as cre on f.serie_cfd = cre.serie and cre.uname = f.uname_br and curdate() between cre.fecha_inicio_vig and cre.fecha_fin_vig where f.num_fac = '"+datosTemporales.getDocumentoacancelar()+"' and c.tipo_docto_ft = 'F'";
			if(datosTemporales.getTipodocumento().equals("Nota de credito"))	{clave_tran="5";}
			if(datosTemporales.getTipodocumento().equals("Nota de cargo")){clave_tran="6";}
			String sql2 = "select  u.nombre_corto,f.num_fac,t.docto_tran,tt.referencia_tran,f.agent_vend,f.num_cli,c.nombre,c.razon_social,t.fecha_tran,co.total,co.folio_fiscal,f.uname,f.uname_br,cre.cuenta,cre.password,cre.usuario,co.serie,co.folio	from "+cdo+".TRANSACFAC as t inner join "+cdo+".FACTURAS as f on t.num_fac = f.num_fac inner join "+cdo+".TIPOTRAN as tt on t.cve_tran = tt.cve_tran and t.tipo_tran = tt.tipo_tran inner join "+cdo+".CLIENTES as c on f.num_cli = c.num_cte inner join CECOM.UNAME as u on f.uname_br = u.uname left join CFDI.ncc_comprobante as co on  t.docto_serie = co.serie and t.docto_folio = co.folio left join CFDI.credenciales_cfdi as cre on t.docto_serie = cre.serie and cre.uname = f.uname_br and curdate() between cre.fecha_inicio_vig and cre.fecha_fin_vig where t.docto_tran = '"+datosTemporales.getDocumentoacancelar()+"' and t.cve_tran = '"+clave_tran+"' group by '"+datosTemporales.getDocumentoacancelar()+"'";
			//System.out.println("LOG sql: "+sql);
			
			if (cdo.equalsIgnoreCase("kwx"))
			{
			
				sql = "    select u.nombre_corto,f.num_fac,f.num_fac,f.agent_vend,f.num_cli,c.nombre,c.razon_social,f.fecha_factura,co.total ,co.folio_fiscal,f.uname as uname_br,cre.cuenta,cre.password,cre.usuario,co.serie,co.folio from "+cdo+".FACTURAS as f inner join "+cdo+".CLIENTES as c on f.num_cli = c.num_cte inner join "+cdo.toUpperCase()+".UNAME as u on f.uname = u.uname left join CFDI.comprobante as co on f.serie_cfd = co.serie and f.folio_cfd = co.folio LEFT JOIN CFDI.credenciales as cre on f.serie_cfd = cre.serie and cre.uname = f.uname    and curdate() between cre.fecha_inicio_vig and cre.fecha_fin_vig where f.num_fac = '"+datosTemporales.getDocumentoacancelar()+"' and c.tipo_docto_ft = 'F'";
				sql2 =        "select  u.nombre_corto,f.num_fac,t.docto_tran,tt.referencia_tran,f.agent_vend,f.num_cli,c.nombre,c.razon_social,t.fecha_tran,co.total,co.folio_fiscal,f.uname,f.uname as uname_br,cre.cuenta,cre.password,cre.usuario,co.serie,co.folio	from "+cdo+".TRANSACFAC as t inner join "+cdo+".FACTURAS as f on t.num_fac = f.num_fac inner join "+cdo+".TIPOTRAN as tt on t.cve_tran = tt.cve_tran and t.tipo_tran = tt.tipo_tran inner join "+cdo+".CLIENTES as c on f.num_cli = c.num_cte inner join "+cdo+".UNAME as u on f.uname    = u.uname left join CFDI.ncc_comprobante as co on  t.docto_serie = co.serie and t.docto_folio = co.folio LEFT JOIN CFDI.credenciales_cfdi as cre on t.docto_serie = cre.serie and cre.uname = f.uname    and curdate() between cre.fecha_inicio_vig and cre.fecha_fin_vig where t.docto_tran = '"+datosTemporales.getDocumentoacancelar()+"' and t.cve_tran = '"+clave_tran+"' group by '"+datosTemporales.getDocumentoacancelar()+"'";
			}
			try 
			{
				//System.out.println("--");
				String CadenaAccion = respuestaSW.getRespuestaString() +  ". OBJETO UUID [ RespuestaServicio: " + respuestaSW.getRespuestaObjeto41().getUUIDS()[0].getRespuestaServicio() + ";  MensajeError : " + respuestaSW.getRespuestaObjeto41().getUUIDS()[0].getMensajeError() + ";  EsCancelable : " + respuestaSW.getRespuestaObjeto41().getUUIDS()[0].getEsCancelable()+ ";  UUID : " + respuestaSW.getRespuestaObjeto41().getUUIDS()[0].getUUID() +" ]" ;
				////System.out.println("--");
				CadenaAccion = CadenaAccion.replace("null", "  ").replace('"', '`').replace("'", "`");
				st = (Statement) con.createStatement();
				if (con != null) 
				{	
					if(datosTemporales.getTipodocumento().equals("Factura"))
					{	
						
						tipo_document=1;
						ps = con.prepareStatement(sql);
						rs = ps.executeQuery();
						while (rs.next()) 
						{	
							////System.out.println("insert into CFDI.t_log_cancelacion_comprobante(`id_log`,`tipo_documento`,`documento_cancelado`,`accion`,`cve_usu`,`serie`,`folio`,`fecha_pro`,`hora_pro`) values ('"+logCancelacion.getId_log()+"','"+tipo_document+"','"+datosTemporales.getDocumentoacancelar()+"','"+CadenaAccion+"','"+logCancelacion.getCve_usu()+"','"+rs.getString(15)+"','"+rs.getInt(16)+"','"+logCancelacion.getFecha_pro()+"','"+logCancelacion.getHora_pro()+"')");
							st.executeUpdate("insert into CFDI.t_log_cancelacion_comprobante(`id_log`,`tipo_documento`,`documento_cancelado`,`accion`,`cve_usu`,`serie`,`folio`,`fecha_pro`,`hora_pro`) values ('"+logCancelacion.getId_log()+"','"+tipo_document+"','"+datosTemporales.getDocumentoacancelar()+"','"+CadenaAccion+"','"+logCancelacion.getCve_usu()+"','"+rs.getString(15)+"','"+rs.getInt(16)+"','"+logCancelacion.getFecha_pro()+"','"+logCancelacion.getHora_pro()+"')");
							
						}
					}
					else
					{
						if(datosTemporales.getTipodocumento().equals("Nota de credito")){tipo_document=2;}
						if(datosTemporales.getTipodocumento().equals("Nota de cargo")){tipo_document=3;}
						ps = con.prepareStatement(sql2);
						rs = ps.executeQuery();
						while (rs.next()) 
						{	
							st.executeUpdate("insert into CFDI.t_log_cancelacion_comprobante(`id_log`,`tipo_documento`,`documento_cancelado`,`accion`,`cve_usu`,`serie`,`folio`,`fecha_pro`,`hora_pro`) values ('"+logCancelacion.getId_log()+"','"+tipo_document+"','"+datosTemporales.getDocumentoacancelar()+"','"+CadenaAccion+"','"+logCancelacion.getCve_usu()+"','"+rs.getString(17)+"','"+rs.getInt(18)+"','"+logCancelacion.getFecha_pro()+"','"+logCancelacion.getHora_pro()+"')");
						}
					}
				}
			} 
			catch (SQLException e) 
			{
				//System.out.println("error: "+e);
			} 
	
	} 
	catch (NullPointerException ex) {//System.out.println("Error nulo: "+ex);
		 
	}
	finally 
	{
		try 
		{
			con.close();
			if (ps != null) 
			{
				ps.close();
			}
				
		} 
		catch (SQLException e) 
		{
//			e.printStackTrace();
		}
	}
		return servicioWeb;
	}
	
	public static void eliminarRegistro(List<DatosTemporales>listaConsultaFactura, String valorrr,String cdo) 
	{
		boolean validarMostrado = true;
		String documento= "";
				int contador=0;
				int posicionElemento=0;
				for (DatosTemporales nombre : listaConsultaFactura) 
				{	
					contador++;
					if(nombre.getDocumentoacancelar().equals(valorrr))
					{	
						posicionElemento=contador;
					}
				}
				listaConsultaFactura.remove(posicionElemento-1);
	}
	
	public static void limpiarTabla(List<DatosTemporales>listaConsultaFactura,String cdo ) 
	{
		boolean validarMostrado = true;
		String documento= "";
		int contador=0;
		int posicionElemento=0;
		listaConsultaFactura.clear();
	}
	
	public static boolean verificarSelladoFactura(String documento,String cdo,List<Querys> ListaQuerys,Usuario infoUsu) 
	{
		Connection connBD = null;
		PreparedStatement pstm= null;		
		connBD = ConexionBD.AbrirConexionBD(infoUsu.getUname());
		boolean selladoFactura = false;
		try 
		{
			
			String[] querys = new String[25];	
			querys = Cls_Querys.LimpiaListaQuerys(querys);
			querys = Cls_Querys.ObtieneQuerys(66, ListaQuerys, querys, cdo);	
			querys = InicializaQueryNumero2(querys, infoUsu,documento);
			pstm = connBD.prepareStatement("{call " + infoUsu.getUname().toUpperCase() +".usp_EXECUTE_QUERY(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			ResultSet rs = EjecutaQuerysBD.EjecutarQuery(querys[0], querys[1],querys[2], querys[3], querys[4], querys[5], querys[6],
					querys[7], querys[8], querys[9],querys[10], querys[11], querys[12], querys[13], 
					querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], 
					querys[21], querys[22], querys[23], querys[24], infoUsu.getUname(),pstm, connBD);
		
				 while (rs.next())
			        {	
					 	String folio_fiscal = rs.getString("folio_fiscal");
						if (folio_fiscal != null) 
						{
							selladoFactura=true;
						} 
			        }
			
			
		}
		catch(Exception ex)
		{
			String sError= ex.getMessage().toString();
		}
		finally
		{
			try {connBD.close();} catch (SQLException e) {e.printStackTrace();}
			try {pstm.close();} catch (SQLException e) {e.printStackTrace();}
		}	
		return selladoFactura;
		}
	
	public static boolean existenciaFactura(String documento,String cdo,List<Querys> ListaQuerys,Usuario infoUsu) 
	{
		Connection connBD = null;
		PreparedStatement pstm= null;		
		connBD = ConexionBD.AbrirConexionBD(infoUsu.getUname());
		boolean existenciaFactura = false;
		try 
		{
			String[] querys = new String[25];	
			querys = Cls_Querys.LimpiaListaQuerys(querys);
			querys = Cls_Querys.ObtieneQuerys(107, ListaQuerys, querys, cdo);	
			querys = InicializaQueryNumero2(querys, infoUsu,documento);
			////System.out.println(querys[0]);
			pstm = connBD.prepareStatement("{call " + infoUsu.getUname().toUpperCase() +".usp_EXECUTE_QUERY(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			ResultSet rs = EjecutaQuerysBD.EjecutarQuery(querys[0], querys[1],querys[2], querys[3], querys[4], querys[5], querys[6],
					querys[7], querys[8], querys[9],querys[10], querys[11], querys[12], querys[13], 
					querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], 
					querys[21], querys[22], querys[23], querys[24], infoUsu.getUname(),pstm, connBD);

			while (rs.next())
			{	
				existenciaFactura=true;
			}	
			
		}
		catch(Exception ex)
		{
			String sError= ex.getMessage().toString();
		}
		finally
		{
			try {connBD.close();} catch (SQLException e) {e.printStackTrace();}
			try {pstm.close();} catch (SQLException e) {e.printStackTrace();}
		}	
		return existenciaFactura;
	}

	
	
	public boolean statusCancelado(String documento,String cdo,List<Querys> ListaQuerys,Usuario infoUsu) 
	{  
		Connection connBD = null;
		PreparedStatement pstm= null;		
		connBD = ConexionBD.AbrirConexionBD(infoUsu.getUname());
		boolean statusCancelado = true;
		try 
		{
			String[] querys = new String[25];	
			querys = Cls_Querys.LimpiaListaQuerys(querys);
			querys = Cls_Querys.ObtieneQuerys(102, ListaQuerys, querys, cdo);	
			querys = InicializaQueryNumero2(querys, infoUsu,documento);
			pstm = connBD.prepareStatement("{call " + infoUsu.getUname().toUpperCase() +".usp_EXECUTE_QUERY(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			ResultSet rs = EjecutaQuerysBD.EjecutarQuery(querys[0], querys[1],querys[2], querys[3], querys[4], querys[5], querys[6],
														 querys[7], querys[8], querys[9],querys[10], querys[11], querys[12], querys[13], 
														 querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], 
														 querys[21], querys[22], querys[23], querys[24], infoUsu.getUname(),pstm, connBD);
			if (rs != null)
			 {
				 while (rs.next())
			        {
					 statusCancelado = false;
			        }
			 }
		} 
		catch(Exception ex)
		{
			String sError= ex.getMessage().toString();
		}
		finally
		{
			try {connBD.close();} catch (SQLException e) {e.printStackTrace();}
			try {pstm.close();} catch (SQLException e) {e.printStackTrace();}
		}	
		return statusCancelado;
    }

public static boolean verificarFecha(String documento,String cdo,List<Querys> ListaQuerys,Usuario infoUsu) 
	{
		Connection connBD = null;
		PreparedStatement pstm= null;		
		connBD = ConexionBD.AbrirConexionBD(infoUsu.getUname());
		boolean fechaFactura = false;
		try 
		{
			String[] querys = new String[25];	
			querys = Cls_Querys.LimpiaListaQuerys(querys);
			querys = Cls_Querys.ObtieneQuerys(105, ListaQuerys, querys, cdo);	
			querys = InicializaQueryNumero105(querys, infoUsu,documento);
			pstm = connBD.prepareStatement("{call " + infoUsu.getUname().toUpperCase() +".usp_EXECUTE_QUERY(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			ResultSet rs = EjecutaQuerysBD.EjecutarQuery(querys[0], querys[1],querys[2], querys[3], querys[4], querys[5], querys[6],
					querys[7], querys[8], querys[9],querys[10], querys[11], querys[12], querys[13], 
					querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], 
					querys[21], querys[22], querys[23], querys[24], infoUsu.getUname(),pstm, connBD);
			if (rs != null)
			{
				while (rs.next())
				{	
					if(rs.getString("verifica").equals("1")) {
						fechaFactura = true;
					}
				}
			}
		}
		catch(Exception ex)
		{
			String sError= ex.getMessage().toString();
		}
		finally
		{
			try {connBD.close();} catch (SQLException e) {e.printStackTrace();}
			try {pstm.close();} catch (SQLException e) {e.printStackTrace();}
		}	
		return fechaFactura;
	}
	
	




	public boolean verificarFechaNota(List<Querys> ListaQuerys,Usuario infoUsu,String documento_cancelado, String cdo, String tipo_documento) {

		Connection connBD = null;
		PreparedStatement pstm= null;		
		connBD = ConexionBD.AbrirConexionBD(infoUsu.getUname());
		boolean recorresql = false;
		if (tipo_documento.equals("2")) {
			tipo_documento="5";
		}
		else {
			tipo_documento="6";
		}
		try 
		{
			String[] querys = new String[25];	
			querys = Cls_Querys.LimpiaListaQuerys(querys);
			querys = Cls_Querys.ObtieneQuerys(105, ListaQuerys, querys, cdo);	
			querys = InicializaQueryNumero105(querys, infoUsu,documento_cancelado);
			pstm = connBD.prepareStatement("{call " + infoUsu.getUname().toUpperCase() +".usp_EXECUTE_QUERY(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			ResultSet rs = EjecutaQuerysBD.EjecutarQuery(querys[0], querys[1],querys[2], querys[3], querys[4], querys[5], querys[6],
					querys[7], querys[8], querys[9],querys[10], querys[11], querys[12], querys[13], 
					querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], 
					querys[21], querys[22], querys[23], querys[24], infoUsu.getUname(),pstm, connBD);
			if (rs != null)
			{
				while (rs.next())
				{
					if(rs.getString("verifica").equals("1")) {
					recorresql = true;
					}
				}
			}
		}
		catch(Exception ex)
		{
			String sError= ex.getMessage().toString();
		}
		finally
		{
			try {connBD.close();} catch (SQLException e) {e.printStackTrace();}
			try {pstm.close();} catch (SQLException e) {e.printStackTrace();}
		}	
		return recorresql;
	}

	private String[] InicializaQueryNumero1(String[] ListaQuerys, Usuario infoUsu,String TIPODOCUMENTO, String DOCUMENTO) {

		for (int i=0;i <ListaQuerys.length; i++)
		{			
			ListaQuerys[i]= ListaQuerys[i].replace("{DOCUMENTO}",DOCUMENTO);
			ListaQuerys[i]= ListaQuerys[i].replace("{TIPODOCUMENTO}",TIPODOCUMENTO);
		}
		return ListaQuerys;
	}
	private static String[] InicializaQueryNumero2(String[] ListaQuerys, Usuario infoUsu, String DOCUMENTO) {

		for (int i=0;i <ListaQuerys.length; i++)
		{			
			ListaQuerys[i]= ListaQuerys[i].replace("{DOCUMENTO}",DOCUMENTO);
		}
		return ListaQuerys;
	}
	private static String[] InicializaQueryNumero105(String[] querys, Usuario infoUsu, String documento) {
		for (int i=0;i <querys.length; i++)
		{			
			querys[i]= querys[i].replace("{SERIE_CORTA}",String.valueOf(documento.charAt(0)));
			System.out.println(String.valueOf(documento.charAt(0)));
		}
		return querys;
}
	private static String[] InicializaQueryNumero22(String[] ListaQuerys, Usuario infoUsu, String serie,String folio) {

		for (int i=0;i <ListaQuerys.length; i++)
		{			
			ListaQuerys[i]= ListaQuerys[i].replace("{SERIE}",serie);
			ListaQuerys[i]= ListaQuerys[i].replace("{FOLIO}",folio);
		}
		return ListaQuerys;
	}
	private static String[] InicializaQueryNumero101(String[] querys, Usuario infoUsu, String documento) {
		for (int i=0;i <querys.length; i++)
		{			
			querys[i]= querys[i].replace("{SERIE_CORTA}",String.valueOf(documento.charAt(0)));
			//System.out.println(String.valueOf(documento.charAt(0)));
		}
		return querys;
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
}

