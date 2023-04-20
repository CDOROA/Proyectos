package cdo.Persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.servlet.http.HttpSession;

import cdo.Datos.Choferes;
import cdo.Datos.ClientesCredito;
import cdo.Datos.LogAlmacen;
import cdo.Datos.Querys;
import cdo.Datos.Rutas;
import cdo.Datos.SeriesCfdi;
import cdo.Datos.Usuario;
import cdo.Datos.VariosTickets;
import cdo.Datos.Vehiculos;
import cdo.util.Cls_Querys;
import cdo.util.ConexionBD;
import cdo.util.EjecutaQuerysBD;
import cdo.util.InsertarLogAlamacen;


public class GestorDatosUsuario 
{

	public GestorDatosUsuario()
	{
		
	}
		
	/*** Obtiene Centro de archivo de configuracion ***/
	public static Map<String,String> ObtieneCentros(String ArchivoConfiguracion)
	{
		Map<String, String> mapaCdos= new TreeMap<>();
		try
		{
			mapaCdos.put("cdf", "CDMX");
			mapaCdos.put("cd2", "Puebla");
			mapaCdos.put("cdl", "Leon");
			mapaCdos.put("cdm", "Monterrey");

		}
		catch(Exception ex)
		{	
			System.out.println("Error al obtener centros.");
		}
		return mapaCdos;
	}
	
	/*** Obtiene la lista de querys del proceso 68 (Caja Administrativa) ***/
	public List<Querys> ConsultaTablaQuerysBD(String cdo)
	{
		Connection connBD = null;
		PreparedStatement pstmt =null;
		ResultSet rs=null;
		List<Querys> querys= new ArrayList<>();
		
		
		
		try
		{
			String qry = ObtieneQuery(2, "", "", cdo);
			connBD = ConexionBD.AbrirConexionBDD(cdo);
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
			System.out.println("Error al consultar tabla de Querys");
		}
		finally 
		{
			try 
			{
				connBD.close();
				pstmt.close();
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
		}
	
		return querys;
	}
		
	/*** Valida y Obtiene informacion del usuario de la BD ***/
	public static Usuario consultaInformacionDeUsuarioBD(String usuario, String password, String cdo)
	{
		Usuario infoUsuario = new Usuario();
		Connection connBD = null;
		PreparedStatement pstmt =null;
		ResultSet rs=null;
		
		try 
		{
			String qry = ObtieneQuery(1, usuario, password,cdo);
			connBD = ConexionBD.AbrirConexionBDD(cdo);
			pstmt = connBD.prepareStatement(qry);
			rs = pstmt.executeQuery();
			if(rs != null)
			{
				if(rs.next())
				{
					if(rs.getString("cve_usu") != "")
					{
						infoUsuario.setCve_usuario(rs.getString("cve_usu"));
						infoUsuario.setNombre(rs.getString("nombre"));
						infoUsuario.setCve_departamento(rs.getInt("depto"));
						infoUsuario.setDepartamento(rs.getString("nombre_depto"));
						infoUsuario.setNivel_usuario(rs.getInt("nivel_usuario"));
						infoUsuario.setDato_numerico(rs.getInt("dato_numerico1"));
						infoUsuario.setDato_alfanumerico(rs.getString("dato_alfanumerico1"));
						infoUsuario.setDato_alfanumerico2(rs.getString("dato_alfanumerico2"));
						infoUsuario.setUname(rs.getString("cdo_macro"));
						infoUsuario.setUname_nombre(rs.getString("cdo_macro_nombre"));	
						String uname_br = (rs.getString("cdo_br").toString().equals("")) ? rs.getString("cdo_macro") : rs.getString("cdo_br");						
						infoUsuario.setUname_br(uname_br);
						infoUsuario.setUname_br_nombre(rs.getString("cdo_br_nombre"));
					}
				}
			}
		}
		catch(Exception ex)
		{
			System.out.println("Error al consultar Usuario. Detalle:" + ex.getMessage().toString());
		}
		finally 
		{
			try 
			{
				connBD.close();
				pstmt.close();
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
		}
		
		return infoUsuario;
	}
	
	
	
	
	
	
	
	
	
	
	
		
		/*** Genera la sintaxis de los querys iniciales ***/ 
	public static String ObtieneQuery( int numQuery, String usuario, String password, String cdo)
	{
		
		String qry="";
		switch(numQuery)
		{
			case 1:
				qry=	"SELECT 	A.cve_usu,  "+
									"A.nombre,   "+
									"A.depto,   "+
									"B.nombre_depto,  "+
									"C.nivel_usuario,  "+
									"C.dato_numerico1,  "+
									"ifnull(C.dato_alfanumerico1,'n') as dato_alfanumerico1 ,  "+
									"ifnull(C.dato_alfanumerico2,'n') as dato_alfanumerico2,  "+
									"D.uname AS cdo_macro,  "+
									"D.nombre_corto AS cdo_macro_nombre,   "+
									"IFNULL(E.uname, '') AS cdo_br,  "+
									"E.nombre_corto AS  cdo_br_nombre  "+
						"FROM 		" + cdo.toUpperCase() +".USUARIOS AS A  "+
									"INNER JOIN " + cdo.toUpperCase() +".DEPARTAMENTOS AS B ON A.depto = B.departamento   "+
									"INNER JOIN " + cdo.toUpperCase() +".USU_PROC_WEB AS C ON  A.cve_usu = C.cve_usu    "+
									"INNER JOIN CECOM.UNAME AS D ON D.uname= '" + cdo.toLowerCase() + "'" +
									"LEFT  JOIN CECOM.UNAME AS E ON E.num_cte = A.num_cli_bod   "+
					    "WHERE  	 A.cve_usu = '"+ usuario.toUpperCase() +"'  AND password= '" + password + "' AND C.proc_web= '93'";
			break;
				
			case 2:
				qry=  "SELECT 		DISTINCT proc_web AS proceso, "+
									"indice_query, "+
									"sub_indice_query, "+
									"descripcion, "+
									"estructura AS query "+
						"  FROM 	"+cdo.toUpperCase()+ ".QUERYS where proc_web = '93' " +
						"  ORDER BY indice_query ASC, " +
									"sub_indice_query ASC;";
				break;
				
		}
		
		return qry;
	}

		public String obtenerHora(String cdo, HttpSession session, List<Querys> ListaQuerys, Usuario infoUsu) 
		{
			String hora = "";
			Connection connBD = null;
			PreparedStatement pstm = null;
			connBD = ConexionBD.AbrirConexionBDD(infoUsu.getUname().toUpperCase());
			String [] querys = new String [25];
			try 
			{
				
				
				querys = Cls_Querys.LimpiaListaQuerys(querys);
				querys = Cls_Querys.ObtieneQuerys(28, ListaQuerys, querys, infoUsu);
				querys = InicializaQueryNumero29(querys, infoUsu);
				pstm = connBD.prepareStatement("{call " + "ALMACEN.usp_EXECUTE_QUERY(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
				ResultSet rs = EjecutaQuerysBD.EjecutarQuery(querys[0], querys[1],querys[2], querys[3], querys[4], querys[5], querys[6],
						 querys[7], querys[8], querys[9],querys[10], querys[11], querys[12], querys[13], 
						 querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], 
						 querys[21], querys[22], querys[23], querys[24], infoUsu.getUname(),pstm, connBD,infoUsu);
				if (connBD != null)
				{
					rs = pstm.executeQuery();
					while (rs.next())
					{
						hora = rs.getString("hora");
						
					}
				}
			} catch (Exception e) 
			{
				InsertarLogAlamacen.insertarLog(new LogAlmacen("","",""),cdo,infoUsu.getUname_br(),"Error obtener hora inicial. DETALLE: "+e.toString().replace("'", "´")+"  Qry["+querys[0].toString().replace("'","´")+"]",infoUsu.getCve_usuario());
			}
			finally 
			{
				try 
				{
					connBD.close();
					pstm.close();
				} 
				catch (SQLException e) 
				{
					InsertarLogAlamacen.insertarLog(new LogAlmacen("","",""),infoUsu.getUname(),infoUsu.getUname_br(),"Error al cerrar conexion y pstm horas. DETALLE: "+e.getMessage().toString().replace("'", "´"),infoUsu.getCve_usuario());
				}
			}
			String split [] = hora.split("/");
			return hora;
		}

		public List<SeriesCfdi> obtenerSeries(String cdo, List<Querys> ListaQuerys, Usuario infoUsu) 
		{
			List<SeriesCfdi> s = new ArrayList<>();
			String hora = "";
			Connection connBD = null;
			PreparedStatement pstm = null;
			connBD = ConexionBD.AbrirConexionBDD(infoUsu.getUname().toUpperCase());
			String [] querys = new String [25];
			try 
			{
				querys = Cls_Querys.LimpiaListaQuerys(querys);
				querys = Cls_Querys.ObtieneQuerys(29, ListaQuerys, querys, infoUsu);
				querys = InicializaQueryNumero29(querys, infoUsu);
				pstm = connBD.prepareStatement("{call " + "ALMACEN.usp_EXECUTE_QUERY(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
				ResultSet rs = EjecutaQuerysBD.EjecutarQuery(querys[0], querys[1],querys[2], querys[3], querys[4], querys[5], querys[6],
						 querys[7], querys[8], querys[9],querys[10], querys[11], querys[12], querys[13], 
						 querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], 
						 querys[21], querys[22], querys[23], querys[24], infoUsu.getUname(),pstm, connBD,infoUsu);
				if (connBD != null)
				{
					rs = pstm.executeQuery();
					while (rs.next())
					{
						SeriesCfdi ss = new SeriesCfdi();
						ss.setSerieCorta(rs.getString("serie_corta"));
						ss.setSerieLarga(rs.getString("serie_larga"));
						
						s.add(ss);

					}
				}
			} catch (Exception e) 
			{
				InsertarLogAlamacen.insertarLog(new LogAlmacen("","",""),cdo,infoUsu.getUname_br(),"Error obtener series inicial. DETALLE: "+e.toString().replace("'", "´")+"  Qry["+querys[0].toString().replace("'","´")+"]",infoUsu.getCve_usuario());
			}
			finally 
			{
				try 
				{
					connBD.close();
					pstm.close();
				} 
				catch (SQLException e) 
				{
					InsertarLogAlamacen.insertarLog(new LogAlmacen("","",""),infoUsu.getUname(),infoUsu.getUname_br(),"Error al cerrar conexion y pstm obtener series. DETALLE: "+e.getMessage().toString().replace("'", "´"),infoUsu.getCve_usuario());
				}
			}
			return s;
		}

		public static List<Choferes> obtenerChoferes(String cdo, List<Querys> ListaQuerys, Usuario infoUsu) 
		{
			List<Choferes> s = new ArrayList<>();
			String hora = "";
			Connection connBD = null;
			PreparedStatement pstm = null;
			connBD = ConexionBD.AbrirConexionBDD(cdo.toUpperCase());
			String [] querys = new String [25];
				try 
				{
					querys = Cls_Querys.LimpiaListaQuerys(querys);
					querys = Cls_Querys.ObtieneQuerys(12, ListaQuerys, querys, infoUsu);
					querys = InicializaQueryNumero12(querys, infoUsu);
					pstm = connBD.prepareStatement("{call " + "ALMACEN.usp_EXECUTE_QUERY(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
					ResultSet rs = EjecutaQuerysBD.EjecutarQuery(querys[0], querys[1],querys[2], querys[3], querys[4], querys[5], querys[6],
							 querys[7], querys[8], querys[9],querys[10], querys[11], querys[12], querys[13], 
							 querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], 
							 querys[21], querys[22], querys[23], querys[24], infoUsu.getUname(),pstm, connBD,infoUsu);
					while (rs.next())
					{
						Choferes ss = new Choferes();
						ss.setChofer(rs.getString("chofer"));
						ss.setNombre(rs.getString("nombre"));
						ss.setCve(rs.getString("cve"));
						ss.setUname(rs.getString("uname"));
						s.add(ss);

					}
				}
				catch (Exception e)
				{
					InsertarLogAlamacen.insertarLog(new LogAlmacen("","",""),cdo,infoUsu.getUname_br(),"Error al obtener choferes. DETALLE: "+e.toString().replace("'", "´")+"  Qry["+querys[0].toString().replace("'","´")+"]",infoUsu.getCve_usuario());
				}
				finally 
				{
					try 
					{
						connBD.close();
						pstm.close();
					} catch (Exception e2)
					{
						InsertarLogAlamacen.insertarLog(new LogAlmacen("","",""),infoUsu.getUname(),infoUsu.getUname_br(),"Error al cerrar conexion y pstm obtener choferes. DETALLE: "+e2.getMessage().toString().replace("'", "´"),infoUsu.getCve_usuario());
					}
				}
			
			return s;
		}



		public List<Choferes> obtenerTransportes(String cdo, List<Querys> ListaQuerys, Usuario infoUsu) 
		{
			List<Choferes> s = new ArrayList<>();
			String hora = "";
			Connection connBD = null;
			PreparedStatement pstm = null;
			connBD = ConexionBD.AbrirConexionBDD(cdo.toUpperCase());
			String [] querys = new String [25];
			try 
			{
				querys = Cls_Querys.LimpiaListaQuerys(querys);
				querys = Cls_Querys.ObtieneQuerys(30, ListaQuerys, querys, infoUsu);
				querys = InicializaQueryNumero29(querys, infoUsu);
				pstm = connBD.prepareStatement("{call " + "ALMACEN.usp_EXECUTE_QUERY(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
				ResultSet rs = EjecutaQuerysBD.EjecutarQuery(querys[0], querys[1],querys[2], querys[3], querys[4], querys[5], querys[6],
						 querys[7], querys[8], querys[9],querys[10], querys[11], querys[12], querys[13], 
						 querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], 
						 querys[21], querys[22], querys[23], querys[24], infoUsu.getUname(),pstm, connBD,infoUsu);
				
				if (connBD != null)
				{
					rs = pstm.executeQuery();
					while (rs.next())
					{
						Choferes ss = new Choferes();
						ss.setChofer(rs.getString("no"));
						ss.setNombre(rs.getString("nombre"));
						s.add(ss);

					}
				}
			} catch (Exception e) 
			{
				InsertarLogAlamacen.insertarLog(new LogAlmacen("","",""),cdo,infoUsu.getUname_br(),"Error al obtener TRANSPORTES. DETALLE: "+e.toString().replace("'", "´")+"  Qry["+querys[0].toString().replace("'","´")+"]",infoUsu.getCve_usuario());
			}
			finally 
			{
				try 
				{
					connBD.close();
					pstm.close();
				} 
				catch (SQLException e) 
				{
					InsertarLogAlamacen.insertarLog(new LogAlmacen("","",""),infoUsu.getUname(),infoUsu.getUname_br(),"Error al cerrar conexion y pstm obtener transportes. DETALLE: "+e.getMessage().toString().replace("'", "´"),infoUsu.getCve_usuario());
				}
			}
			return s;
		}

		public String obtenerImpresora(List<Querys> ListaQuerys, Usuario infoUsu) 
		{
			
			String impresora = "";
			Connection connBD = null;
			PreparedStatement pstm = null;
			connBD = ConexionBD.AbrirConexionBDD(infoUsu.getUname());
			String [] querys = new String [25];
				try 
				{
					querys = Cls_Querys.LimpiaListaQuerys(querys);
					querys = Cls_Querys.ObtieneQuerys(14, ListaQuerys, querys, infoUsu);
					querys = InicializaQueryNumero14(querys, infoUsu);
					pstm = connBD.prepareStatement("{call " + "ALMACEN.usp_EXECUTE_QUERY(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
					ResultSet rs = EjecutaQuerysBD.EjecutarQuery(querys[0], querys[1],querys[2], querys[3], querys[4], querys[5], querys[6],
							 querys[7], querys[8], querys[9],querys[10], querys[11], querys[12], querys[13], 
							 querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], 
							 querys[21], querys[22], querys[23], querys[24], infoUsu.getUname(),pstm, connBD,infoUsu);
					while (rs.next())
					{
						impresora = rs.getString("impresora");
					}
//					InsertarLogAlamacen.insertarLog(new LogAlmacen("","",""),infoUsu.getUname(),infoUsu.getUname_br(),"CONSULTA IMPRESORAS  Qry["+querys[0].toString().replace("'","´")+"]",infoUsu.getCve_usuario());
					
				}
				catch (Exception e)
				{
					InsertarLogAlamacen.insertarLog(new LogAlmacen("","",""),infoUsu.getUname(),infoUsu.getUname_br(),"Error al obtener impresora. DETALLE: "+e.toString().replace("'", "´")+"  Qry["+querys[0].toString().replace("'","´")+"]",infoUsu.getCve_usuario());
				}
				finally 
				{
					try 
					{
						connBD.close();
						pstm.close();
					} catch (Exception e2)
					{
						InsertarLogAlamacen.insertarLog(new LogAlmacen("","",""),infoUsu.getUname(),infoUsu.getUname_br(),"Error al cerrar conexion y pstm impresora. DETALLE: "+e2.toString().replace("'", "´"),infoUsu.getCve_usuario());
					}
				}

			return impresora;
			
		}

		private String[] InicializaQueryNumero14(String[] ListaQuerys, Usuario infoUsu)
		{
			for (int i=0;i <ListaQuerys.length; i++)
			{	
				ListaQuerys[i]= ListaQuerys[i].replace("{UNAME_CDO_}",infoUsu.getUname_br());
				ListaQuerys[i]= ListaQuerys[i].replace("{UNAME_}",infoUsu.getUname().toUpperCase());
			}
			return ListaQuerys;
		}
		private static String[] InicializaQueryNumero12(String[] ListaQuerys, Usuario infoUsu)
		{
			for (int i=0;i <ListaQuerys.length; i++)
			{	
				ListaQuerys[i]= ListaQuerys[i].replace("{UNAME_CDO_}",infoUsu.getUname_br());
				ListaQuerys[i]= ListaQuerys[i].replace("{UNAME_}",infoUsu.getUname().toUpperCase());
				
			}
			return ListaQuerys;
		}

		private static String[] InicializaQueryNumero29(String[] ListaQuerys, Usuario infoUsu)
		{
			for (int i=0;i <ListaQuerys.length; i++)
			{	
				ListaQuerys[i]= ListaQuerys[i].replace("{UNAME_CDO_}",infoUsu.getUname().toUpperCase());
				
				
			}
			return ListaQuerys;
		}
		public List<VariosTickets> obtenerRegionales2(Usuario infoUsu, HttpSession session)
		{
			List<VariosTickets> l = new ArrayList<>();
			List<VariosTickets> ll = new ArrayList<>();
			int aux = 0;
			l = (List<VariosTickets>) session.getAttribute("regionales");
			
			for (VariosTickets vv : l) 
			{
				if (!infoUsu.getUname_br().equals(vv.getUname_br().substring(0, 3))) 
				{
					if (aux == 0) 
					{
						session.setAttribute("unameTrans", vv.getUname_br());
						session.setAttribute("unameNombreTrans", vv.getDescripcion());
						aux++;
					}
					else
					{
					VariosTickets s = new VariosTickets();
					s.setUname(vv.getUname());
					s.setUname_br(vv.getUname_br());
					s.setTitulo(vv.getTitulo());
					s.setDescripcion(vv.getDescripcion());
					ll.add(s);
					}
				}
			}
			
			return ll;
		}

		public List<VariosTickets> obtenerRegionales(Usuario infoUsu, List<Querys> ListaQuerys) 
		{
			List<VariosTickets> v = new ArrayList<>();
			
			Connection connBD = null;
			PreparedStatement pstm = null;
			connBD = ConexionBD.AbrirConexionBDD(infoUsu.getUname());
			String [] querys = new String [25];
				try 
				{
					querys = Cls_Querys.LimpiaListaQuerys(querys);
					querys = Cls_Querys.ObtieneQuerys(45, ListaQuerys, querys, infoUsu);
					querys = InicializaQueryNumero45(querys, infoUsu);
					pstm = connBD.prepareStatement("{call " + "ALMACEN.usp_EXECUTE_QUERY(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
					ResultSet rs = EjecutaQuerysBD.EjecutarQuery(querys[0], querys[1],querys[2], querys[3], querys[4], querys[5], querys[6],
							 querys[7], querys[8], querys[9],querys[10], querys[11], querys[12], querys[13], 
							 querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], 
							 querys[21], querys[22], querys[23], querys[24], infoUsu.getUname(),pstm, connBD,infoUsu);
					while (rs.next())
					{
						
						VariosTickets t  = new VariosTickets();
						t.setUname(rs.getString("uname"));
						t.setUname_br(rs.getString("uname_br"));
						t.setDescripcion(rs.getString("descripcion"));
						t.setTitulo(rs.getString("macro"));
						v.add(t);
					}
				}
				catch (Exception e)
				{
					InsertarLogAlamacen.insertarLog(new LogAlmacen("","",""),infoUsu.getUname(),infoUsu.getUname_br(),"Error al obtener regionalesobtencion. DETALLE: "+e.toString().replace("'", "´")+"  Qry["+querys[0].toString().replace("'","´")+"]",infoUsu.getCve_usuario());
				}
				finally 
				{
					try 
					{
						connBD.close();
						pstm.close();
					} catch (Exception e2)
					{
						InsertarLogAlamacen.insertarLog(new LogAlmacen("","",""),infoUsu.getUname(),infoUsu.getUname_br(),"Error al cerrar conexion y pstm regionalesobtencion. DETALLE: "+e2.toString().replace("'", "´"),infoUsu.getCve_usuario());
					}
				}
			return v;
			
		}

		private String[] InicializaQueryNumero45(String[] ListaQuerys, Usuario infoUsu) 
		{
			for (int i=0;i <ListaQuerys.length; i++)
			{	
				ListaQuerys[i]= ListaQuerys[i].replace("{UNAME_CDO_}",infoUsu.getUname());
			}
			
			return ListaQuerys;
		}

		public List<VariosTickets> tituloRegionales(Usuario infoUsu, List<Querys> querys, HttpSession session) 
		{
			List<VariosTickets> v = new ArrayList<>();
			List<VariosTickets> vvv = new ArrayList<>();
			v = (List<VariosTickets>) session.getAttribute("regionales");
			for (VariosTickets t : v) 
			{
				VariosTickets vv = new VariosTickets();
				vv.setTitulo(t.getTitulo());
				vv.setUname(t.getUname());
				vvv.add(vv);
				break;
			}
			return vvv;
		}

		public List<Rutas> obtenerRutas(List<Querys> ListaQuerys, Usuario infoUsu) 
		{
				List<Rutas> v = new ArrayList<>();
			
			Connection connBD = null;
			PreparedStatement pstm = null;
			connBD = ConexionBD.AbrirConexionBDD(infoUsu.getUname());
			String [] querys = new String [25];
				try 
				{
					querys = Cls_Querys.LimpiaListaQuerys(querys);
					querys = Cls_Querys.ObtieneQuerys(47, ListaQuerys, querys, infoUsu);
					querys = InicializaQueryNumero47(querys, infoUsu);
					pstm = connBD.prepareStatement("{call " + "ALMACEN.usp_EXECUTE_QUERY(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
					ResultSet rs = EjecutaQuerysBD.EjecutarQuery(querys[0], querys[1],querys[2], querys[3], querys[4], querys[5], querys[6],
							 querys[7], querys[8], querys[9],querys[10], querys[11], querys[12], querys[13], 
							 querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], 
							 querys[21], querys[22], querys[23], querys[24], infoUsu.getUname(),pstm, connBD,infoUsu);
					while (rs.next())
					{
						Rutas t  = new Rutas();
						if (rs.getInt("num_ruta") == 0)
						{
							t.setNum_ruta(123456789);
							t.setDescripcion(rs.getString("descripcion"));
						}
						
						else
						{
							t.setNum_ruta(rs.getInt("num_ruta"));
							t.setDescripcion(rs.getString("descripcion"));
						}
						v.add(t);
					}
				}
				catch (Exception e)
				{
					InsertarLogAlamacen.insertarLog(new LogAlmacen("","",""),infoUsu.getUname(),infoUsu.getUname_br(),"Error al obtener rutas. DETALLE: "+e.toString().replace("'", "´")+"  Qry["+querys[0].toString().replace("'","´")+"]",infoUsu.getCve_usuario());
				}
				finally 
				{
					try 
					{
						connBD.close();
						pstm.close();
					} catch (Exception e2)
					{
						InsertarLogAlamacen.insertarLog(new LogAlmacen("","",""),infoUsu.getUname(),infoUsu.getUname_br(),"Error al cerrar conexion y pstm rutas. DETALLE: "+e2.toString().replace("'", "´"),infoUsu.getCve_usuario());
					}
				}
			return v;
		}
		
		
		public List<Vehiculos> obtenerVehiculos(List<Querys> ListaQuerys, Usuario infoUsu) 
		{
			List<Vehiculos> v = new ArrayList<>();
			
			Connection connBD = null;
			PreparedStatement pstm = null;
			connBD = ConexionBD.AbrirConexionBDD(infoUsu.getUname());
			String [] querys = new String [25];
				try 
				{
					querys = Cls_Querys.LimpiaListaQuerys(querys);
					querys = Cls_Querys.ObtieneQuerys(55, ListaQuerys, querys, infoUsu);
					querys = InicializaQueryNumero55(querys, infoUsu);
					pstm = connBD.prepareStatement("{call " + "ALMACEN.usp_EXECUTE_QUERY(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
					ResultSet rs = EjecutaQuerysBD.EjecutarQuery(querys[0], querys[1],querys[2], querys[3], querys[4], querys[5], querys[6],
							 querys[7], querys[8], querys[9],querys[10], querys[11], querys[12], querys[13], 
							 querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], 
							 querys[21], querys[22], querys[23], querys[24], infoUsu.getUname(),pstm, connBD,infoUsu);
					
					//Cls_Querys.ImprimeQuerysConsola(querys, true, "query 55");
					
					while (rs.next())
					{
						Vehiculos objVehiculos = new Vehiculos();
						objVehiculos.setPlacas(rs.getString("placas"));
						objVehiculos.setDescripcion(rs.getString("descripcion"));
						objVehiculos.setLlantas(rs.getString("llantas"));
						v.add(objVehiculos);
					}
				}
				catch (Exception e)
				{
					InsertarLogAlamacen.insertarLog(new LogAlmacen("","",""),infoUsu.getUname(),infoUsu.getUname_br(),"Error al obtener vehiculos. DETALLE: "+e.toString().replace("'", "´")+"  Qry["+querys[0].toString().replace("'","´")+"]",infoUsu.getCve_usuario());
				}
				finally 
				{
					try 
					{
						connBD.close();
						pstm.close();
					} catch (Exception e2)
					{
						InsertarLogAlamacen.insertarLog(new LogAlmacen("","",""),infoUsu.getUname(),infoUsu.getUname_br(),"Error al cerrar conexion y pstm rutas. DETALLE: "+e2.toString().replace("'", "´"),infoUsu.getCve_usuario());
					}
				}
			return v;
		}
		
		private String[] InicializaQueryNumero55(String[] ListaQuerys, Usuario infoUsu) 
		{
			for (int i=0;i <ListaQuerys.length; i++)
			{	
				ListaQuerys[i]= ListaQuerys[i].replace("{UNAME_}",infoUsu.getUname().toUpperCase());
			}
			
			return ListaQuerys;
		}

		private String[] InicializaQueryNumero47(String[] ListaQuerys, Usuario infoUsu) 
		{
			for (int i=0;i <ListaQuerys.length; i++)
			{	
				ListaQuerys[i]= ListaQuerys[i].replace("{UNAME_CDO_}",infoUsu.getUname().toUpperCase());
			}
			
			return ListaQuerys;
		}

		public List<ClientesCredito> obtenerClientesCredito(List<Querys> ListaQuerys, Usuario infoUsu) 
		{
			List<ClientesCredito> v = new ArrayList<>();
			
			Connection connBD = null;
			PreparedStatement pstm = null;
			connBD = ConexionBD.AbrirConexionBDD(infoUsu.getUname());
			String [] querys = new String [25];
				try 
				{
					querys = Cls_Querys.LimpiaListaQuerys(querys);
					querys = Cls_Querys.ObtieneQuerys(49, ListaQuerys, querys, infoUsu);
					querys = InicializaQueryNumero49(querys, infoUsu);
					pstm = connBD.prepareStatement("{call " + "ALMACEN.usp_EXECUTE_QUERY(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
					ResultSet rs = EjecutaQuerysBD.EjecutarQuery(querys[0], querys[1],querys[2], querys[3], querys[4], querys[5], querys[6],
							 querys[7], querys[8], querys[9],querys[10], querys[11], querys[12], querys[13], 
							 querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], 
							 querys[21], querys[22], querys[23], querys[24], infoUsu.getUname(),pstm, connBD,infoUsu);
					while (rs.next())
					{
						ClientesCredito t  = new ClientesCredito();
						t.setUname(rs.getString("uname"));
						t.setUname_br(rs.getString("uname_br"));
						t.setCliente(rs.getString("num_cli"));
						t.setEstatus(rs.getString("estatus"));
						v.add(t);
					}
				}
				catch (Exception e)
				{
					InsertarLogAlamacen.insertarLog(new LogAlmacen("","",""),infoUsu.getUname(),infoUsu.getUname_br(),"Error al obtener clientes de credito. DETALLE: "+e.toString().replace("'", "´")+"  Qry["+querys[0].toString().replace("'","´")+"]",infoUsu.getCve_usuario());
				}
				finally 
				{
					try 
					{
						connBD.close();
						pstm.close();
					} catch (Exception e2)
					{
						InsertarLogAlamacen.insertarLog(new LogAlmacen("","",""),infoUsu.getUname(),infoUsu.getUname_br(),"Error al cerrar conexion y pstm clientes credito. DETALLE: "+e2.toString().replace("'", "´"),infoUsu.getCve_usuario());
					}
				}
			return v;
		}

		private String[] InicializaQueryNumero49(String[] ListaQuerys, Usuario infoUsu) 
		{
			for (int i=0;i <ListaQuerys.length; i++)
			{	
				ListaQuerys[i]= ListaQuerys[i].replace("{UNAME_BR_}",infoUsu.getUname_br());
			}
			
			return ListaQuerys;
		}




		
		
	
	
}
