package cdfis.Persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;




import cdfis.Datos.ConexionBD;
import cdfis.Datos.Usuario;
import cdfis.Datos.Querys;


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
			mapaCdos.put("kwx", "KWX");

		}
		catch(Exception ex)
		{	
			//System.out.println("Error al obtener centros.");
		}
		return mapaCdos;
	}
	
	/*** Obtiene la lista de querys del proceso 68 (Caja Administrativa) ***/
	public static List<Querys> ConsultaTablaQuerysBD(String cdo)
	{
		Connection connBD = null;
		PreparedStatement pstmt =null;
		ResultSet rs=null;
		List<Querys> querys= new ArrayList<>();
		
		try
		{
			String qry = ObtieneQuery(2, "", "", cdo);
			connBD = ConexionBD.AbrirConexionBD(cdo);
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
			//System.out.println("Error al consultar tabla de Querys");
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
			//System.out.println("QRY: "+ qry);
			connBD = ConexionBD.AbrirConexionBD(cdo);
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
			//System.out.println("Error al consultar Usuario. Detalle:" + ex.getMessage().toString());
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
				if (cdo.equalsIgnoreCase("kwx")) 
				{
					qry = "SELECT 	A.cve_usu,  "+
							"A.nombre,   "+
							"A.depto,   "+
							"B.nombre_depto,  "+
							"C.nivel_usuario,  "+
							"C.dato_numerico1,  "+
							"C.dato_alfanumerico1,  "+
							"D.uname AS cdo_macro,  "+
							"D.nombre_corto AS cdo_macro_nombre,   "+
							"IFNULL(D.uname, '') AS cdo_br,  "+
							"D.nombre_corto AS  cdo_br_nombre  "+
				"FROM 		" + cdo.toUpperCase() +".USUARIOS AS A  "+
							"INNER JOIN " + cdo.toUpperCase() +".DEPARTAMENTOS AS B ON A.depto = B.departamento   "+
							"INNER JOIN " + cdo.toUpperCase() +".USU_PROC_WEB AS C ON  A.cve_usu = C.cve_usu    "+
							"INNER JOIN UNAME AS D ON D.uname= '" + cdo.toLowerCase() + "'" +
							
			    "WHERE  	 A.cve_usu = '"+ usuario.toUpperCase() +"'  AND password= '" + password + "' AND C.proc_web= '72'";
				}else {
				qry=	"SELECT 	A.cve_usu,  "+
									"A.nombre,   "+
									"A.depto,   "+
									"B.nombre_depto,  "+
									"C.nivel_usuario,  "+
									"C.dato_numerico1,  "+
									"C.dato_alfanumerico1,  "+
									"D.uname AS cdo_macro,  "+
									"D.nombre_corto AS cdo_macro_nombre,   "+
									"IFNULL(E.uname, '') AS cdo_br,  "+
									"E.nombre_corto AS  cdo_br_nombre  "+
						"FROM 		" + cdo.toUpperCase() +".USUARIOS AS A  "+
									"INNER JOIN " + cdo.toUpperCase() +".DEPARTAMENTOS AS B ON A.depto = B.departamento   "+
									"INNER JOIN " + cdo.toUpperCase() +".USU_PROC_WEB AS C ON  A.cve_usu = C.cve_usu    "+
									"INNER JOIN CECOM.UNAME AS D ON D.uname= '" + cdo.toLowerCase() + "'" +
									"LEFT  JOIN CECOM.UNAME AS E ON E.num_cte = A.num_cli_bod   "+
					    "WHERE  	 A.cve_usu = '"+ usuario.toUpperCase() +"'  AND password= '" + password + "' AND C.proc_web= '72'";}
			break;
				
			case 2:
				qry=  "SELECT 		DISTINCT proc_web AS proceso, "+
									"indice_query, "+
									"sub_indice_query, "+
									"descripcion, "+
									"estructura AS query "+
						"  FROM 	"+cdo.toUpperCase()+ ".QUERYS where proc_web = '72' " +
						"  ORDER BY indice_query ASC, " +
									"sub_indice_query ASC;";
				break;
		}
		return qry;
	}
	
	
	
}
