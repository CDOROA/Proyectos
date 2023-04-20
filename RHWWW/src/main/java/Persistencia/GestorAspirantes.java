package Persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Datos.Aspirante;
import Datos.Querys;
import Datos.Vacante;
import Util.Cls_Querys;
import Util.ConexionBD;

public class GestorAspirantes {
	public List<Aspirante> ConsultaAspirantes(List<Querys> listaQuerys, String cdo){
		Connection connBD = null;
		PreparedStatement pstm = null;
		connBD = ConexionBD.abrirConexionBD();	
		List<Aspirante> ListAspirantes = new ArrayList<>();
		
		try {
			
			String[] querys = new String[25];	
			querys = Cls_Querys.LimpiaListaQuerys(querys);	
			querys = Cls_Querys.ObtieneQuerys(7, listaQuerys, querys);
			querys = inicializaQueryNumero77(querys, cdo);
			pstm = connBD.prepareStatement("{call " + "comercio_electronico.usp_EXECUTE_QUERY(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			ResultSet rs=  Cls_Querys.EjecutarQuery(querys[0], querys[1],querys[2], querys[3], querys[4], querys[5], querys[6],
														 querys[7], querys[8], querys[9],querys[10], querys[11], querys[12], querys[13], 
														 querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], 
														 querys[21], querys[22], querys[23], querys[24], "",pstm, connBD);
			
			
			Cls_Querys.ImprimeQuerysConsola(querys,false,"Query 7");
			if(rs != null) {
				ListAspirantes = llenaClaseAspirantes(rs);	
			}
					
		}catch(Exception ex)
		{
			System.out.println("Error - GestorAspirantess.ConsultaAspirantes: " + ex.toString());
		}
		finally {
			try {
				if(pstm != null) {
					pstm.close();
				}
				if(connBD != null) {
					connBD.close();
				}
			} catch (Exception e) {
				System.out.println("ERROR al cerrar conexcion en GestorAspirantes.ConsultaAspirantes: " + e);
			}
		}
		return ListAspirantes;
	}

	private List<Aspirante> llenaClaseAspirantes(ResultSet rs) {
		List<Aspirante> listAspirantes = new ArrayList<>();
		try
		{
			if(rs != null)
			{
				while(rs.next())
				{
					Aspirante asp = new Aspirante();
					 asp.setIdAspirante(rs.getInt("id_aspirante"));
					 asp.setNombre(rs.getString("nombre").toUpperCase());
					 asp.setEmail(rs.getString("e_mail"));
					 asp.setTelefono(rs.getString("telefono"));
					 asp.setEdad(rs.getString("edad"));
					 asp.setGenero(rs.getString("genero").toUpperCase()); 
					 asp.setDescriocionNivelEstudios(rs.getString("descriocion_nivel_estudios").toUpperCase());
					 asp.setNombreEstado(rs.getString("nombre_estado").toUpperCase());
					 asp.setDescripcionEmpresa(rs.getString("descripcion_empresa").toUpperCase());
					 asp.setFechaRegistro(rs.getString("fecha_registro").toUpperCase());
					 asp.setCodigoCv(rs.getString("cv"));
					 asp.setStatus(rs.getString("status").toUpperCase());
					 asp.setNombrePuesto(rs.getString("nomb_puesto").toUpperCase());
					 asp.setDescripcionVacante(rs.getString("des_vacante").toUpperCase());
					 asp.setHorarioVacante(rs.getString("horario_vacante").toUpperCase());
					 asp.setObservaciones(rs.getString("observaciones").toUpperCase());
					 asp.setLugarTrabajo(rs.getString("lugar_trabajo").toUpperCase());
					 asp.setNombreEmpresa(rs.getString("nom_empresa").toUpperCase());
					 //System.out.print(asp);
					listAspirantes.add(asp);
				}
			}			
		}
		catch(Exception ex)
		{
			System.out.println("[Error: Obtener catalogo de sucursales,  Clase: GestorAspirantess.llenaClaseAspirantess,  Detalle: " + ex.getMessage().toString() +"]");
			 
		}
		return listAspirantes;
	}
	public List<Aspirante> ActualizaEstatus(Connection connBD, Aspirante asp, List<Querys> listaQuerys){
		 
		PreparedStatement pstm = null;
		List<Aspirante> ListAspirantes = new ArrayList<>();
		
		try {
			
			String[] querys = new String[25];	
			querys = Cls_Querys.LimpiaListaQuerys(querys);	
			querys = Cls_Querys.ObtieneQuerys(7, listaQuerys, querys);
			querys = inicializaQueryNumero7(querys, asp);
			pstm = connBD.prepareStatement("{call " + "comercio_electronico.usp_EXECUTE_QUERY(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			ResultSet rs=  Cls_Querys.EjecutarQuery(querys[0], querys[1],querys[2], querys[3], querys[4], querys[5], querys[6],
														 querys[7], querys[8], querys[9],querys[10], querys[11], querys[12], querys[13], 
														 querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], 
														 querys[21], querys[22], querys[23], querys[24], "",pstm, connBD);
			
			
			Cls_Querys.ImprimeQuerysConsola(querys,false,"Query 7");
			if(rs != null) {
				ListAspirantes= llenaClaseAspirantes(rs);	
			}
					
		}catch(Exception ex)
		{
			System.out.println("Error - GestorAspirantes.ActualizaEstatus:" + ex);
		}
		finally {
			try {
				if(pstm != null) {
					pstm.close();
				}
				if(connBD != null) {
					connBD.close();
				}
			} catch (Exception e) {
				System.out.println("ERROR al cerrar conexcion en GestorAspirantes.ActualizaEstatus: " + e);
			}
		}
		return ListAspirantes;
	}
	
	private String[] inicializaQueryNumero7(String[] ListaQuerys, Aspirante asp) {
		for (int i=0;i <ListaQuerys.length; i++)
		{		
			ListaQuerys[i]= ListaQuerys[i].replace("{ID_ASPIRANTE}", String.valueOf(asp.getIdAspirante()));
			ListaQuerys[i]= ListaQuerys[i].replace("{ESTATUS}", String.valueOf(asp.getStatus()));
		}
		return ListaQuerys;
	}
	
	private String[] inicializaQueryNumero77(String[] ListaQuerys,String cdo) {
		for (int i=0;i <ListaQuerys.length; i++)
		{			
			ListaQuerys[i]= ListaQuerys[i].replace("{CVE}", String.valueOf(cdo));	
		}
		ListaQuerys[1] = "";
		return ListaQuerys;
	}
}
