package cdo.Persistencia;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import cdo.Datos.Aspirantes;
import cdo.Datos.Log;
import cdo.Datos.Querys;
import cdo.Datos.Vacantes;
import cdo.Util.Cls_Log;
import cdo.Util.Cls_Querys;
import cdo.Util.ConexionBD;
import cdo.Util.EjecutaQuerysBD;

public class GestorBolsaDeTrabajo {
	
	 private  static Properties properties = null;	 
	
	 static 
	 {
	      try  
	      {
		      properties = new Properties();
		      InputStream  inputStream  = GestorBolsaDeTrabajo.class.getClassLoader().getResourceAsStream("/properties/mail.properties");
		      properties.load(inputStream);
		      
	      }
	      catch  (Exception ex) 
	      {
	        ex.printStackTrace();
	      }
	 }	
	 
	/*** CONSULTA BOLSA DE TRABAJO POR ESTADO  ****/
	public List<Vacantes> consultaVacantesXEstado(List<Querys> listaQuerys, String cve_edo)
	{
		List<Vacantes> ListVacantes = new ArrayList<>();
		Connection connBD = null;
		PreparedStatement pstm= null;
		connBD = ConexionBD.abrirConexionBD();	
		try
		{
			String[] querys = new String[25];	
			querys = Cls_Querys.LimpiaListaQuerys(querys);	
			querys = Cls_Querys.ObtieneQuerys(9, listaQuerys, querys);
			querys = inicializaQueryNumero9(querys, cve_edo);
		
			pstm = connBD.prepareStatement("{call " + "comercio_electronico.usp_EXECUTE_QUERY(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			ResultSet rs=  EjecutaQuerysBD.EjecutarQuery(querys[0], querys[1],querys[2], querys[3], querys[4], querys[5], querys[6],
														 querys[7], querys[8], querys[9],querys[10], querys[11], querys[12], querys[13], 
														 querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], 
														 querys[21], querys[22], querys[23], querys[24], "",pstm, connBD);
			
			
			Cls_Querys.ImprimeQuerysConsola(querys,false,"Query 9");
			ListVacantes = llenaClaseVacantes(rs);			
			Log log=new Log(0, 0, 0 ,0, "[Accion: Consulta vacantes por estado, CveEstado:  " + cve_edo +" ]");
			Cls_Log.insertaLog(log);
			
		}
		catch(Exception ex)
		{
			System.out.println("[NuevoportalRamaCDO.- Error: Consulta vacantes por estado,  Clase: GestorBolsaDeTrabajo,  Detalle: " + ex.getMessage().toString() +"]"); 
			Log log=new Log(0, 0, 0 ,0, "[Error: Consulta vacantes por estado,  Clase: GestorBolsaDeTrabajo,  Detalle: " + ex.getMessage().toString() +"]");
			Cls_Log.insertaLog(log);
		}
		finally 
		{
			try {pstm.close();} catch (SQLException e) {e.printStackTrace();}
			try {connBD.close();} catch (SQLException e) {e.printStackTrace();}
		}
		return ListVacantes;
	}
	
	private List<Vacantes> llenaClaseVacantes(ResultSet rs)
	{
		List<Vacantes> listVacantes = new ArrayList<>();
		try
		{
			if(rs != null)
			{
				while(rs.next())
				{
					Vacantes vacante = new Vacantes();
					vacante.setCve_empresa(rs.getInt("id_cve_empresa"));
					vacante.setCve_puesto(rs.getInt("id_puesto"));
					vacante.setCve_vacante(rs.getInt("id_vacante"));
					vacante.setDescripcion_vacantes(rs.getString("des_vacante"));
					vacante.setFecha_publicacion(rs.getString("fecha_publicacion"));
					vacante.setHorario_vacante(rs.getString("horario_vacante"));
					vacante.setLugar_trabajo(rs.getString("lugar_trabajo"));
					vacante.setNombre_empresa(rs.getString("desc_empresa"));
					vacante.setNombre_puesto(rs.getString("nomb_puesto"));
					vacante.setObservaciones(rs.getString("observaciones"));
					listVacantes.add(vacante);
				}
			}			
		}
		catch(Exception ex)
		{
			Log log=new Log(0, 0, 0 ,0, "[Error: Obtener catalogo de sucursales,  Clase: GestorBolsaDeTrabajo,  Detalle: " + ex.getMessage().toString() +"]");
			Cls_Log.insertaLog(log);
		}
		return listVacantes;
	}
	
	/*** ALTA DE ASPIRANTES ****/
	public boolean altaAspirantesBD(List<Querys> listaQuerys, Aspirantes aspirante, String nombreVacante,  String nivelAcademico, String estado)
	{
		boolean aspiranteEnviado=false;
		Connection connBD = null;
		PreparedStatement pstm= null;
		connBD = ConexionBD.abrirConexionBD();	
		try
		{
			String[] querys = new String[25];	
			querys = Cls_Querys.LimpiaListaQuerys(querys);	
			querys = Cls_Querys.ObtieneQuerys(10, listaQuerys, querys);
			querys = inicializaQueryNumero10(querys, aspirante);
			pstm = connBD.prepareStatement("{call " + "comercio_electronico.usp_EXECUTE_QUERY_CV(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			EjecutaQuerysBD.EjecutarQuery(querys[0], querys[1],querys[2], querys[3], querys[4], querys[5], querys[6],
														 querys[7], querys[8], querys[9],querys[10], querys[11], querys[12], querys[13], 
														 querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], 
														 querys[21], querys[22], querys[23], querys[24], "",pstm, connBD);
			
			Cls_Querys.ImprimeQuerysConsola(querys,false,"Query 10");
			aspiranteEnviado= true;
			Log log=new Log(0, 0, 0 ,0, "[Accion: Alta de nuevo aspirante.]");
			Cls_Log.insertaLog(log);
		}
		catch(Exception ex)
		{
			System.out.println("[NuevoportalRamaCDO.- Error: Alta de aspirantes,  Clase: GestorBolsaDeTrabajo,  Detalle: " + ex.getMessage().toString() +"]"); 
			Log log=new Log(0, 0, 0 ,0, "[Error: Alta de aspirantes,  Clase: GestorBolsaDeTrabajo,  Detalle: " + ex.getMessage().toString() +"]");
			Cls_Log.insertaLog(log);
		}
		finally 
		{
			try {pstm.close();} catch (SQLException e) {e.printStackTrace();}
			try {connBD.close();} catch (SQLException e) {e.printStackTrace();}
		}
		return aspiranteEnviado;
	}
		
	
	/*** INICIALIZA QUERYS ****/
 	private String[] inicializaQueryNumero9(String[] ListaQuerys,String cve_edo)
	{
		for (int i=0;i <ListaQuerys.length; i++)
		{
			if(!cve_edo.equals("0"))
			{
				ListaQuerys[i]= ListaQuerys[i].replace("{ESTADO}", " WHERE A.id_cve_edo = '" + cve_edo + "AND A.sts=0"+"'");
			}
			else
			{
				ListaQuerys[i]= ListaQuerys[i].replace("{ESTADO}", "AND A.sts=0;");
			}
							
		}
		return ListaQuerys;
	}
	
 	private String[] inicializaQueryNumero10(String[] ListaQuerys,Aspirantes aspirante)
	{
		for (int i=0;i <ListaQuerys.length; i++)
		{	
			ListaQuerys[i]= ListaQuerys[i].replace("{NOMBRE}", aspirante.getNombre());
			ListaQuerys[i]= ListaQuerys[i].replace("{A_PATERNO}", aspirante.getA_paterno());
			ListaQuerys[i]= ListaQuerys[i].replace("{A_MATERNO}", aspirante.getA_materno());
			ListaQuerys[i]= ListaQuerys[i].replace("{EMAIL}", aspirante.getE_mail());
			ListaQuerys[i]= ListaQuerys[i].replace("{EDAD}", String.valueOf(aspirante.getEdad()));
			ListaQuerys[i]= ListaQuerys[i].replace("{TELEFONO}",aspirante.getTelefono());
			ListaQuerys[i]= ListaQuerys[i].replace("{GENERO}",aspirante.getGenero());
			ListaQuerys[i]= ListaQuerys[i].replace("{NIVEL_ACADEMICO}",String.valueOf( aspirante.getId_nivel_ac()));
			ListaQuerys[i]= ListaQuerys[i].replace("{ESTADO}",String.valueOf(aspirante.getId_cve_edo()));
			ListaQuerys[i]= ListaQuerys[i].replace("{CVE_EMPRESA}",String.valueOf(aspirante.getId_cve_empresa()));
			ListaQuerys[i]= ListaQuerys[i].replace("{CVE_VACANTE}", String.valueOf(aspirante.getId_vacante()));
			ListaQuerys[i]= ListaQuerys[i].replace("{CODIGO}",aspirante.getCodigoCv());
			//ListaQuerys[i]= ListaQuerys[i].replace("{FECHA_REGISTRO}",String.valueOf(LocalDate.now()));
			
		}
		return ListaQuerys;
	}
	
}
