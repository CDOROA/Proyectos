package cdo.Persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cdo.Datos.Banners;
import cdo.Datos.Boletines;
import cdo.Datos.CintillosImagenes;
import cdo.Datos.Estados;
import cdo.Datos.InformacionInicial;
import cdo.Datos.Log;
import cdo.Datos.Marcas;
import cdo.Datos.MarcasCdo;
import cdo.Datos.NivelAcademico;
import cdo.Datos.NuestraEmpresa;
import cdo.Datos.Querys;
import cdo.Datos.Grupos;
import cdo.Datos.ValoresEmpresa;
import cdo.Datos.VentajasCompetitivas;
import cdo.Datos.Videos;
import cdo.Util.Cls_Log;
import cdo.Util.Cls_Querys;
import cdo.Util.ConexionBD;
import cdo.Util.EjecutaQuerysBD;

public class GestorPaginaPrincipal {
	
	/*** CONSULTA LISTA DE QUERYS  ***/
	public static List<Querys> ConsultaTablaQuerysBD()
	{
		Connection connBD = null;
		PreparedStatement pstmt =null;
		ResultSet rs=null;
		List<Querys> querys= new ArrayList<>();		
		try
		{
			String qry = "SELECT 		DISTINCT proc_web AS proceso, "+
											"indice_query, "+
											"sub_indice_query, "+
											"descripcion, "+
											"estructura AS query "+
								"  FROM 	comercio_electronico.QUERYS where proc_web = '90' " +
								"  ORDER BY indice_query ASC, " +
											"sub_indice_query ASC;";
			connBD = ConexionBD.abrirConexionBD();
			pstmt = connBD.prepareStatement(qry);
			rs = pstmt.executeQuery();
						
			if (rs != null)
	        {
		        while (rs.next())
		        {
		        	Querys query= new Querys();
		        	query.setProceso(rs.getInt("proceso"));
		        	query.setIndice_query(rs.getInt("indice_query"));
		        	query.setSub_indice_query(rs.getInt("sub_indice_query"));
		        	query.setDescripcion(rs.getString("descripcion"));
		        	query.setQuery(rs.getString("query"));	  
	        		querys.add(query);
		        }
	        }
		}
		catch(Exception ex)
		{
			System.out.println("[NuevoportalRamaCDO.- Error: Consultar tabla de querys ,  Clase: GestorPaginaPrincipal,  Detalle: " + ex.getMessage().toString() +"]");
			Log log=new Log(0,0,0,0, "[Error: Consultar tabla de querys,  Clase: GestorPaginaPrincipal,  Detalle: " + ex.getMessage().toString() +"]");
			Cls_Log.insertaLog(log);
		}
		finally 
		{
			try {pstmt.close();} catch (SQLException e) {e.printStackTrace();}
			try {connBD.close();} catch (SQLException e) {e.printStackTrace();}
		}
		return querys;
	}
	
	/*** CONSULTA INFO INICIAL  ***/
	public InformacionInicial obtieneInformacionInicialDelSistema(List<Querys> listaQuerys)
	{
		InformacionInicial listaInicial=new InformacionInicial();
		Connection connBD = null;
		PreparedStatement pstm= null;
		connBD = ConexionBD.abrirConexionBD();	
		try
		{
			String[] querys = new String[25];	
			querys = Cls_Querys.LimpiaListaQuerys(querys);	
			querys = Cls_Querys.ObtieneQuerys(4, listaQuerys, querys);
			pstm = connBD.prepareStatement("{call " + "comercio_electronico.usp_EXECUTE_QUERY(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			
			//System.out.println("querys 4");
			Cls_Querys.ImprimeQuerysConsola(querys,false,"Query 4");
			
			ResultSet rs=  EjecutaQuerysBD.EjecutarQuery(querys[0], querys[1],querys[2], querys[3], querys[4], querys[5], querys[6],
														 querys[7], querys[8], querys[9],querys[10], querys[11], querys[12], querys[13], 
														 querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], 
														 querys[21], querys[22], querys[23], querys[24], "",pstm, connBD);
			
			listaInicial.setListaBanners(llenarClaseBanners(rs));
			listaInicial.setListaBoletines(llenarClaseBoletines(rs));
			listaInicial.setListaMarcas(llenaClaseMarcas(rs));
			listaInicial.setListaNuestraEmpresa(llenaClaseNuestraEmpresa(rs));
			listaInicial.setListaSistemaAutomotriz(llenaClaseSistemaAutomotriz(rs));
			listaInicial.setListaValores(llenaClaseValoresEmpresa(rs));
			listaInicial.setListaVentajas(llenaClaseVentajasCompetitivas(rs));
			listaInicial.setListaEstados(llenaClasesEstados(rs));
			listaInicial.setListaPoliticasPrivacidad(llenaClasePoliticasPrivacidad(rs));
			listaInicial.setListaMarcasCdo(llenaClaseMarcasCdo(rs));
			listaInicial.setListaNivelAcademico(llenarClaseNivelAcademico(rs));
			listaInicial.setListaCintillosImagenes(llenarClaseCintillos(rs));
			listaInicial.setListaVideos(llenaClaseVideos(rs));
			Log log=new Log(0, 0, 0 ,0, "[Accion: Carga inicial de la informacion del sistema. ]");
			Cls_Log.insertaLog(log);
		}
		catch(Exception ex)
		{
			System.out.println("[NuevoportalRamaCDO.- Error: Consultar informacion inicial par a la carga del sistema ,  Clase: GestorPaginaPrincipal,  Detalle ex.toString(): " + ex.toString() +"]");
			System.out.println("[NuevoportalRamaCDO.- Error: Consultar informacion inicial par a la carga del sistema ,  Clase: GestorPaginaPrincipal,  Detalle ex.getLocalizedMessage().toString():  " + ex.getLocalizedMessage().toString() +"]");
			System.out.println("[NuevoportalRamaCDO.- Error: Consultar informacion inicial par a la carga del sistema ,  Clase: GestorPaginaPrincipal,  Detalle ex.getMessage().toString(): " + ex.getMessage().toString() +"]");


			System.out.println("[NuevoportalRamaCDO.- Error: Consultar informacion inicial par a la carga del sistema ,  Clase: GestorPaginaPrincipal,  Detalle: " + ex.getMessage().toString() +"]");
			Log log=new Log(0,0,0,0, "[Error: Consultar informacion inicial par a la carga del sistema,  Clase: GestorPaginaPrincipal,  Detalle: " + ex.getMessage().toString() +"]");
			Cls_Log.insertaLog(log);
		}
		finally 
		{
			try {pstm.close();} catch (SQLException e) {e.printStackTrace();}
			try {connBD.close();} catch (SQLException e) {e.printStackTrace();}
		}
		return listaInicial;
	}	
		
	/*** LLENA CLASES INICIALES  ***/
	private List<CintillosImagenes> llenarClaseCintillos(ResultSet rs)
	{
		List<CintillosImagenes> cintillos =new ArrayList<>();
		
		try
		{
			rs.beforeFirst();
			while(rs.next())
			{
				if(rs.getString("cintillo").equals("*"))
				{
					CintillosImagenes cintillo=new CintillosImagenes();
					cintillo.setId_cintillo(rs.getInt("id_cintillo"));
					cintillo.setImagen_cintillo(rs.getString("imagen_cintillo"));
					cintillos.add(cintillo);
					
				}
			}		
		}
		catch(Exception ex)
		{
			System.out.println("[NuevoportalRamaCDO.- Error: LLenar clase de marcas para cintillo ,  Clase: GestorPaginaPrincipal,  Detalle: " + ex.getMessage().toString() +"]");
			Log log=new Log(0,0,0,0, "[Error: LLenar clase de marcas para cintillo,  Clase: GestorPaginaPrincipal,  Detalle: " + ex.getMessage().toString() +"]");
			Cls_Log.insertaLog(log);
		}
		
		return cintillos;		
	}
			
	private List<Banners> llenarClaseBanners(ResultSet rs)
	{
		List<Banners> banners =new ArrayList<>();
		int item=0;
		
		try
		{
			rs.beforeFirst();
			while(rs.next())
			{
				if(rs.getString("banner").equals("*"))
				{
					Banners banner=new Banners();
					banner.setId_banner(item);
					banner.setImagen_banner(rs.getString("imagen_banner"));
					banners.add(banner);
					item++;
					//System.out.println("banner " + item + ": " + banner);
				}
			}		
		}
		catch(Exception ex)
		{
			System.out.println("[NuevoportalRamaCDO.- Error: LLenar clase de banners ,  Clase: GestorPaginaPrincipal,  Detalle: " + ex.getMessage().toString() +"]");
			Log log=new Log(0,0,0,0, "[Error: LLenar clase de banners,  Clase: GestorPaginaPrincipal,  Detalle: " + ex.getMessage().toString() +"]");
			Cls_Log.insertaLog(log);
		}
		
		return banners;		
	}
	
	private List<NivelAcademico> llenarClaseNivelAcademico(ResultSet rs)
	{
		List<NivelAcademico> niveles =new ArrayList<>();
		try
		{
			rs.beforeFirst();
			while(rs.next())
			{
				if(rs.getString("nivelAcademico").equals("*"))
				{
					NivelAcademico nivel=new NivelAcademico();
					nivel.setId_nivelAcademico(rs.getInt("cve_nivel"));
					nivel.setNivelAcademico(rs.getString("nivel"));
					niveles.add(nivel);
				}
			}		
		}
		catch(Exception ex)
		{
			System.out.println("[NuevoportalRamaCDO.- Error: LLenar clase de niveles academicos ,  Clase: GestorPaginaPrincipal,  Detalle: " + ex.getMessage().toString() +"]");
			Log log=new Log(0,0,0,0, "[Error: LLenar clase de niveles academicos,  Clase: GestorPaginaPrincipal,  Detalle: " + ex.getMessage().toString() +"]");
			Cls_Log.insertaLog(log);
		}
		
		return niveles;		
	}
		
	private List<Boletines> llenarClaseBoletines(ResultSet rs)
	{
		List<Boletines> boletines =new ArrayList<>();
		int item=0;
		try
		{
			rs.beforeFirst();
			while(rs.next())
			{
				if(rs.getString("boletines").equals("*"))
				{
					Boletines boletin=new Boletines();
					boletin.setId_boletin(item);
					boletin.setNombre_boletin(rs.getString("nombre_boletin"));
					boletin.setFecha_inicio(rs.getString("fecha_inicio_boletin"));
					boletin.setFecha_fin(rs.getString("fecha_fin_boletin"));
					boletin.setImagen_boletin(rs.getString("imagen_boletin"));
					boletines.add(boletin);
					item++;
				}
			}		
		}
		catch(Exception ex)
		{
			System.out.println("[NuevoportalRamaCDO.- Error: LLenar clase de boletines ,  Clase: GestorPaginaPrincipal,  Detalle: " + ex.getMessage().toString() +"]");
			Log log=new Log(0,0,0,0, "[Error: LLenar clase de boletines,  Clase: GestorPaginaPrincipal,  Detalle: " + ex.getMessage().toString() +"]");
			Cls_Log.insertaLog(log);
		}
		
		return boletines;		
	}
	
	private List<Marcas> llenaClaseMarcas(ResultSet rs)
	{
		List<Marcas> marcas =new ArrayList<>();
		
		try
		{
			rs.beforeFirst();
			while(rs.next())
			{
				if(rs.getString("marcas").equals("*"))
				{
					Marcas marca=new Marcas();
					marca.setCve_marca(rs.getInt("cve_marca"));
					marca.setNombre_marca(rs.getString("nombre_marca"));
					marcas.add(marca);
				}
			}		
		}
		catch(Exception ex)
		{
			System.out.println("[NuevoportalRamaCDO.- Error: LLenar clase de marcas ,  Clase: GestorPaginaPrincipal,  Detalle: " + ex.getMessage().toString() +"]");
			Log log=new Log(0,0,0,0, "[Error: LLenar clase de marcas,  Clase: GestorPaginaPrincipal,  Detalle: " + ex.getMessage().toString() +"]");
			Cls_Log.insertaLog(log);
		}
		
		return marcas;
	}
	
	private List<Estados> llenaClasesEstados(ResultSet rs)
	{
		List<Estados> listEstados =new ArrayList<>();
		
		try
		{
			rs.beforeFirst();
			while(rs.next())
			{
				if(rs.getString("estados").equals("*"))
				{
					Estados estados=new Estados();
					estados.setCve_Estado(rs.getInt("cve_estado"));
					estados.setNombre_estado(rs.getString("nombre_estado"));
					listEstados.add(estados);
				}
			}		
		}
		catch(Exception ex)
		{
			System.out.println("[NuevoportalRamaCDO.- Error: LLenar clase de estados ,  Clase: GestorPaginaPrincipal,  Detalle: " + ex.getMessage().toString() +"]");
			Log log=new Log(0,0,0,0, "[Error: LLenar clase de estados,  Clase: GestorPaginaPrincipal,  Detalle: " + ex.getMessage().toString() +"]");
			Cls_Log.insertaLog(log);	 
		}
		
		return listEstados;
	}
	
	private List<NuestraEmpresa> llenaClaseNuestraEmpresa(ResultSet rs)
	{
		List<NuestraEmpresa> listNuestraEmpresa =new ArrayList<>();
		
		try
		{
			rs.beforeFirst();
			while(rs.next())
			{
				if(rs.getString("nuestraEmpresa").equals("*") && (rs.getString("id_seccion_empresa").equals("1") || rs.getString("id_seccion_empresa").equals("2")))
				{
					NuestraEmpresa empresa=new NuestraEmpresa();
					empresa.setId_seccion(rs.getInt("id_seccion_empresa"));
					empresa.setSeccion(rs.getString("seccion_empresa"));
					empresa.setTitulo(rs.getString("titulo_empresa"));
					empresa.setDescripcion(rs.getString("descripcion_empresa"));
					listNuestraEmpresa.add(empresa);
				}
			}		
		}
		catch(Exception ex)
		{
			System.out.println("[NuevoportalRamaCDO.- Error: LLenar clase de nuestra empresa ,  Clase: GestorPaginaPrincipal,  Detalle: " + ex.getMessage().toString() +"]");
			Log log=new Log(0,0,0,0, "[Error: LLenar clase de nuestra empresa,  Clase: GestorPaginaPrincipal,  Detalle: " + ex.getMessage().toString() +"]");
			Cls_Log.insertaLog(log);
		}
		
		return listNuestraEmpresa;
	}
		
	private List<ValoresEmpresa> llenaClaseValoresEmpresa(ResultSet rs)
	{
		List<ValoresEmpresa> listValoresEmpresa =new ArrayList<>();
		
		try
		{
			rs.beforeFirst();
			while(rs.next())
			{
				if(rs.getString("nuestraEmpresa").equals("*") && rs.getString("id_seccion_empresa").equals("3"))
				{
					ValoresEmpresa valor=new ValoresEmpresa();
					valor.setId_seccion(rs.getInt("id_seccion_empresa"));
					valor.setSeccion(rs.getString("seccion_empresa"));
					valor.setTitulo(rs.getString("titulo_empresa"));
					valor.setDescripcion(rs.getString("descripcion_empresa"));
					listValoresEmpresa.add(valor);
				}
			}		
		}
		catch(Exception ex)
		{
			System.out.println("[NuevoportalRamaCDO.- Error: LLenar clase de valores de la empresa ,  Clase: GestorPaginaPrincipal,  Detalle: " + ex.getMessage().toString() +"]");
			Log log=new Log(0,0,0,0, "[Error: LLenar clase de valores de la empresa,  Clase: GestorPaginaPrincipal,  Detalle: " + ex.getMessage().toString() +"]");
			Cls_Log.insertaLog(log);	 
		}
		
		return listValoresEmpresa;
	}
		
	private List<VentajasCompetitivas> llenaClaseVentajasCompetitivas(ResultSet rs)
	{
		List<VentajasCompetitivas> listVentajas =new ArrayList<>();
		
		try
		{
			rs.beforeFirst();
			while(rs.next())
			{
				if(rs.getString("nuestraEmpresa").equals("*") && rs.getString("id_seccion_empresa").equals("4"))
				{
					VentajasCompetitivas ventajas=new VentajasCompetitivas();
					ventajas.setId_seccion(rs.getInt("id_seccion_empresa"));
					ventajas.setSeccion(rs.getString("seccion_empresa"));
					ventajas.setTitulo(rs.getString("titulo_empresa"));
					ventajas.setDescripcion(rs.getString("descripcion_empresa"));
					listVentajas.add(ventajas);
				}
			}		
		}
		catch(Exception ex)
		{
			System.out.println("[NuevoportalRamaCDO.- Error: LLenar clase de ventajas competitivas ,  Clase: GestorPaginaPrincipal,  Detalle: " + ex.getMessage().toString() +"]");
			Log log=new Log(0,0,0,0, "[Error: LLenar clase de ventajas competitivas,  Clase: GestorPaginaPrincipal,  Detalle: " + ex.getMessage().toString() +"]");
			Cls_Log.insertaLog(log);	 
		}
		
		return listVentajas;
	}
		
	private List<MarcasCdo> llenaClaseMarcasCdo(ResultSet rs)
	{
		List<MarcasCdo> listMarcasCdo =new ArrayList<>();
		
		try
		{
			rs.beforeFirst();
			while(rs.next())
			{
				if(rs.getString("nuestraEmpresa").equals("*") && rs.getString("id_seccion_empresa").equals("6"))
				{
					MarcasCdo marca=new MarcasCdo();
					marca.setId_seccion(rs.getInt("id_seccion_empresa"));
					marca.setSeccion(rs.getString("seccion_empresa"));
					marca.setTitulo(rs.getString("titulo_empresa"));
					marca.setDescripcion(rs.getString("descripcion_empresa"));
					listMarcasCdo.add(marca);
				}
			}		
		}
		catch(Exception ex)
		{
			System.out.println("[NuevoportalRamaCDO.- Error: LLenar clase de marcas cdo ,  Clase: GestorPaginaPrincipal,  Detalle: " + ex.getMessage().toString() +"]");
			Log log=new Log(0,0,0,0, "[Error: LLenar clase de marcas cdo,  Clase: GestorPaginaPrincipal,  Detalle: " + ex.getMessage().toString() +"]");
			Cls_Log.insertaLog(log);
		}
		
		return listMarcasCdo;
	}
	
	private List<NuestraEmpresa> llenaClasePoliticasPrivacidad(ResultSet rs)
	{
		List<NuestraEmpresa> listPoliticas =new ArrayList<>();
		
		try
		{
			rs.beforeFirst();
			while(rs.next())
			{
				if(rs.getString("nuestraEmpresa").equals("*") && rs.getString("id_seccion_empresa").equals("5"))
				{
					NuestraEmpresa pol=new NuestraEmpresa();
					pol.setId_seccion(rs.getInt("id_seccion_empresa"));
					pol.setSeccion(rs.getString("seccion_empresa"));
					pol.setTitulo(rs.getString("titulo_empresa"));
					pol.setDescripcion(rs.getString("descripcion_empresa"));
					listPoliticas.add(pol);
				}
			}		
		}
		catch(Exception ex)
		{
			System.out.println("[NuevoportalRamaCDO.- Error: LLenar clase de politicas de privacidad ,  Clase: GestorPaginaPrincipal,  Detalle: " + ex.getMessage().toString() +"]");
			Log log=new Log(0,0,0,0, "[Error: LLenar clase de politicas de privacidad,  Clase: GestorPaginaPrincipal,  Detalle: " + ex.getMessage().toString() +"]");
			Cls_Log.insertaLog(log);
		}
		
		return listPoliticas;
	}
		
	private List<Grupos> llenaClaseSistemaAutomotriz(ResultSet rs)
	{
		List<Grupos> grupos =new ArrayList<>();
		
		try
		{
			rs.beforeFirst();
			while(rs.next())
			{
				if(rs.getString("sis_automotriz").equals("*"))
				{
					Grupos grupo=new Grupos();
					grupo.setCve_grupo(rs.getInt("cve_grupo"));
					grupo.setNombre_grupo(rs.getString("nombre_grupo"));
					grupos.add(grupo);
				}
			}		
		}
		catch(Exception ex)
		{
			System.out.println("[NuevoportalRamaCDO.- Error: LLenar clase de sistema automotriz ,  Clase: GestorPaginaPrincipal,  Detalle: " + ex.getMessage().toString() +"]");
			Log log=new Log(0,0,0,0, "[Error: LLenar clase de sistema automotriz,  Clase: GestorPaginaPrincipal,  Detalle: " + ex.getMessage().toString() +"]");
			Cls_Log.insertaLog(log);
		}
		
		return grupos;
	}
	
	private List<Videos> llenaClaseVideos(ResultSet rs)
	{
		List<Videos> videos =new ArrayList<>();
		
		try
		{
			rs.beforeFirst();
			while(rs.next())
			{
				if(rs.getString("videos").equals("*"))
				{
					Videos video=new Videos();
					video.setDescripcion(rs.getString("descripcion_video"));
					video.setUrlImagen(rs.getString("url_imagen_video"));
					video.setUrlVideo(rs.getString("url_video"));
					videos.add(video);
				}
			}		
		}
		catch(Exception ex)
		{
			System.out.println("[NuevoportalRamaCDO.- Error: LLenar clase de Videos ,  Clase: GestorPaginaPrincipal,  Detalle: " + ex.getMessage().toString() +"]");
			Log log=new Log(0,0,0,0, "[Error: LLenar clase de Videos,  Clase: GestorPaginaPrincipal,  Detalle: " + ex.getMessage().toString() +"]");
			Cls_Log.insertaLog(log);
		}
		return videos;
	}

}
