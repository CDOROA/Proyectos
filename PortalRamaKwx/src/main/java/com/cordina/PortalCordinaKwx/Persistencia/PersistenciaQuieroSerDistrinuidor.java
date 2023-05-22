package com.cordina.PortalCordinaKwx.Persistencia;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.glassfish.jersey.internal.guava.ExecutionError;

import com.cordina.PortalCordinaKwx.Util.clsLog;
import com.cordina.PortalCordinaKwx.conexionBd.connectionManagerV2;
import com.cordina.PortalCordinaKwx.conexionBd.connectionManagerV3;
import com.cordina.PortalCordinaKwx.dto.DelegacionDto;
import com.cordina.PortalCordinaKwx.dto.EstadosDto;
import com.cordina.PortalCordinaKwx.dto.Pais;

public class PersistenciaQuieroSerDistrinuidor  {

	public List<Pais> ConsultaListaPaises()
	{
		List<Pais> listPaises = new ArrayList<Pais>();
		try {
			String Qry = "SELECT * FROM KWX.c_pais  where estatus not in('*') order by id_pais asc;";

	// System.out.println(Qry);
			ResultSet rs_estados = connectionManagerV3.EjecutaConsultatBaseDatos(Qry);
			

			if (rs_estados != null) {
				while (rs_estados.next()) {
					try {
						Pais pais = new Pais();
						pais.setIdPais(rs_estados.getInt("id_pais"));
						pais.setDescripcionPais(rs_estados.getString("descripcion"));
						listPaises.add(pais);
						//System.out.println(estado);
					} catch (Exception ex) {
						String sError = ex.getMessage().toString();
					}
				}
			}
			
		}
		catch(Exception e)
		{
		 
			String sError = e.getMessage().toString();
			System.out.println("PersistenciaQuieroSerDistrinuidor.ConsultaPais Error : "  + e );
			clsLog.RegistraLog("PersistenciaQuieroSerDistrinuidor.ConsultaPais", "getLocalizedMessage: "+ e.getLocalizedMessage().replace("'",""));
			clsLog.RegistraLog("PersistenciaQuieroSerDistrinuidor.ConsultaPais", "getMessage: "+ e.getMessage().replace("'",""));
			clsLog.RegistraLog("PersistenciaQuieroSerDistrinuidor.ConsultaPais", "getCause: "+ e.getClass().getName().replace("'",""));
			clsLog.RegistraLog("PersistenciaQuieroSerDistrinuidor.ConsultaPais", "getClass().getName: "+ e.getLocalizedMessage().replace("'",""));
		}
		finally {
			connectionManagerV3.closeConnection();
		}
		return listPaises;
		
	}

	public List<EstadosDto> ConsultaEstatos(int idPais)
	{
		List<EstadosDto> listEstados = new ArrayList<EstadosDto>();
		try {
			String Qry = "SELECT  DISTINCT A.id_cve_edo, "
					+ "A.nombre  "
					+ "FROM 	KWX.c_estados AS A WHERE A.id_pais ='"+idPais+"' ORDER BY A.nombre;";

	// System.out.println(Qry);
			ResultSet rs_estados = connectionManagerV3.EjecutaConsultatBaseDatos(Qry);
			

			if (rs_estados != null) {
				while (rs_estados.next()) {
					try {
						EstadosDto estado = new EstadosDto();
						estado.setCve_estado(rs_estados.getInt("id_cve_edo"));
						estado.setDescripcion(rs_estados.getString("nombre"));
						listEstados.add(estado);
						//System.out.println(estado);
					} catch (Exception ex) {
						String sError = ex.getMessage().toString();
					}
				}
			}
			
		}
		catch(Exception e)
		{
		 
			String sError = e.getMessage().toString();
			System.out.println("PersistenciaQuieroSerDistrinuidor.ConsultaEstatos Error : "  + e );
			clsLog.RegistraLog("PersistenciaQuieroSerDistrinuidor.ConsultaEstatos", "getLocalizedMessage: "+ e.getLocalizedMessage().replace("'",""));
			clsLog.RegistraLog("PersistenciaQuieroSerDistrinuidor.ConsultaEstatos", "getMessage: "+ e.getMessage().replace("'",""));
			clsLog.RegistraLog("PersistenciaQuieroSerDistrinuidor.ConsultaEstatos", "getCause: "+ e.getClass().getName().replace("'",""));
			clsLog.RegistraLog("PersistenciaQuieroSerDistrinuidor.ConsultaEstatos", "getClass().getName: "+ e.getLocalizedMessage().replace("'",""));
		}
		finally {
			connectionManagerV3.closeConnection();
		}
		return listEstados;
		
	}
	//
	
	public List<DelegacionDto> ConsultaMunicipios(int estado)
	{
		List<DelegacionDto> listMunicipios = new ArrayList<DelegacionDto>();
		try {
			String Qry = "SELECT distinct id_cve_municipio, municipio,  id_clave_edo FROM KWX.c_sepomex where id_clave_edo = '"+estado+"' order by id_cve_municipio;";

			//connectionManagerV3.getConnection();
			ResultSet rs_estados = connectionManagerV3.EjecutaConsultatBaseDatos(Qry);
			

			if (rs_estados != null) {
				while (rs_estados.next()) {
					try {
						DelegacionDto municipio = new DelegacionDto();
					 municipio.setCve_delegacion(rs_estados.getInt("id_cve_municipio"));
					 municipio.setDescripcion(rs_estados.getString("municipio"));
					 municipio.setCve_estado(rs_estados.getInt("id_clave_edo"));
					listMunicipios.add(municipio);
					//System.out.println(estado);
					} catch (Exception ex) {
						String sError = ex.getMessage().toString();
					}
				}
			}
			
		}
		catch(Exception e)
		{
			 
			String sError = e.getMessage().toString();
			System.out.println("PersistenciaQuieroSerDistrinuidor.ConsultaMunicipios Error : "  + e );
			clsLog.RegistraLog("PersistenciaQuieroSerDistrinuidor.ConsultaMunicipios", "getLocalizedMessage: "+ e.getLocalizedMessage().replace("'",""));
			clsLog.RegistraLog("PersistenciaQuieroSerDistrinuidor.ConsultaMunicipios", "getMessage: "+ e.getMessage().replace("'",""));
			clsLog.RegistraLog("PersistenciaQuieroSerDistrinuidor.ConsultaMunicipios", "getCause: "+ e.getClass().getName().replace("'",""));
			clsLog.RegistraLog("PersistenciaQuieroSerDistrinuidor.ConsultaMunicipios", "getClass().getName: "+ e.getLocalizedMessage().replace("'",""));
		}
		finally {
			connectionManagerV3.closeConnection();
		}
		return listMunicipios;
		
	}
	

	
	public int InsertaRegistroEnBD(String nombreNegocio,	String giro,	String nombreContacto,
	                                 String puesto,	String correo,	String whatsApp,
	                                 String cvePais, String cveEstado,	String municipio,	String codigoPostal, String fotografia) {
		int resultado = 0;
		try
		{
			String Qry = "INSERT INTO KWX.t_quiero_ser_distribuidor (nombre_negocio, giro_negocio, nombre_contacto, puesto, "
					     + "correo_electronico, whatsapp, pais,estado, alcaldia_municipio, codigo_postal, estatus, fotografia, fecha_pro, hora_pro) VALUES ("
					+ "'"
					+ nombreNegocio.trim()
					+ "', '"
					+ giro.trim()
					+ "', '"
					+ nombreContacto.trim()
					+ "', '"
					+ puesto.trim()
					+ "', '"
					+ correo.trim()
					+ "', '"
					+ whatsApp
					+ "', '"
					+ cvePais
					+ "', '"
					+ cveEstado
					+ "', '"
					+ municipio.trim()
					+ "', '"
					+ codigoPostal
					+ "','"
					+ "P"
					+ "', '"				
					+ fotografia
					+"', "
					+"DATE(NOW()),TIME(NOW()));";

			resultado = connectionManagerV3.EjecutaQueryBaseDatos(Qry);

		}
		catch(Exception e)
		{
			String sError = e.getMessage().toString();
		
			clsLog.RegistraLog("PersistenciaQuieroSerDistrinuidor.ConsultaMunicipios", "getLocalizedMessage: "+ e.getLocalizedMessage().replace("'",""));
			clsLog.RegistraLog("PersistenciaQuieroSerDistrinuidor.ConsultaMunicipios", "getMessage: "+ e.getMessage().replace("'",""));
			clsLog.RegistraLog("PersistenciaQuieroSerDistrinuidor.ConsultaMunicipios", "getCause: "+ e.getClass().getName().replace("'",""));
			clsLog.RegistraLog("PersistenciaQuieroSerDistrinuidor.ConsultaMunicipios", "getClass().getName: "+ e.getLocalizedMessage().replace("'",""));
		}
		finally {
			connectionManagerV3.closeConnection();
		}
		return resultado;
	}
	
	}
