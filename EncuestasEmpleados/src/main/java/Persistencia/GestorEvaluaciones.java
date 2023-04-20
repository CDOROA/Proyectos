package Persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Datos.Empleado;
import Datos.Evaluacion;
import Datos.LogEncuestas;
import Datos.Querys;
import Datos.Resultados;
import Util.Cls_Querys;
import Util.ConexionBD;
import Util.InsertaLogEncuestas;

public class GestorEvaluaciones {

	public List<Evaluacion> consultaEvaluaciones(List<Querys> listaQuerys, String cdo, String idEmpleado, Empleado infoUsu) {
		Connection connBD = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		connBD = ConexionBD.AbrirConexionBDD(cdo);	
		List<Evaluacion> ListEvaluaciones = new ArrayList<>();
		String[] querys = new String[25];
		String idEncuesta="2";
		try {
			//System.out.println("Entra ");	
			querys = Cls_Querys.LimpiaListaQuerys(querys);	
			querys = Cls_Querys.ObtieneQuerys(3, listaQuerys, querys);
			//System.out.println("querys3: " + querys);
			querys = inicializaQueryNumero3(querys, idEmpleado, idEncuesta,cdo);
			//System.out.println("DESPUES: querys3: " + querys);
			pstm = connBD.prepareStatement("{call " + "DCH.usp_EXECUTE_QUERY(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			rs=  Cls_Querys.EjecutarQuery(querys[0], querys[1],querys[2], querys[3], querys[4], querys[5], querys[6],
														 querys[7], querys[8], querys[9],querys[10], querys[11], querys[12], querys[13], 
														 querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], 
														 querys[21], querys[22], querys[23], querys[24], "",pstm, connBD, infoUsu);
			
			
			Cls_Querys.ImprimeQuerysConsola(querys,true,"Query 1");
			
			ListEvaluaciones = llenaClaseEvaluacion(rs, idEmpleado, infoUsu);			
			//System.out.print("entre aqui");
			InsertaLogEncuestas.insertarLog(new LogEncuestas(),infoUsu.getEmpresa(),infoUsu.getEmpresa(),"Entrada a consultaEvaluaciones Usuario: "+infoUsu.getNoEmpleado()+"qry{"+Cls_Querys.regresaQuerys(querys,true)+"}",infoUsu.getNoEmpleado());	
		}catch(Exception ex)
		{
			InsertaLogEncuestas.insertarLog(new LogEncuestas(),infoUsu.getEmpresa(),infoUsu.getEmpresa(),"Error - GestorEvaluaciones.consultaEvaluaciones: "+infoUsu.getNoEmpleado()+"qry{"+Cls_Querys.regresaQuerys(querys,true)+"}",infoUsu.getNoEmpleado());
		}
		finally {
			try {
				if(connBD != null) {
					connBD.close();
				}
				if(pstm != null) {
					pstm.close();
				}
			} catch (Exception e) {
				System.out.println("ERROR al cerrar conexcion en GestorVacantes.ConsultaVacantes: " + e);
			}
		}
		return ListEvaluaciones;
	}
	private String[] inicializaQueryNumero3(String[] ListaQuerys, String idEmpleado, String idEncuesta,String cdo) {
		for (int i=0;i <ListaQuerys.length; i++)
		{			
			ListaQuerys[i]= ListaQuerys[i].replace("{ID_EMPLEADO_EVALUADOR}", String.valueOf(idEmpleado));
			ListaQuerys[i]=ListaQuerys[i].replace("{ID_ENCUESTA}", String.valueOf(idEncuesta));
			switch(cdo) {
			case "cdf":
				ListaQuerys[i]=ListaQuerys[i].replace("{CDO}", String.valueOf("('cdf','cto','ac2','gdl','cq2')"));
				break;
			case "cd2":
				ListaQuerys[i]=ListaQuerys[i].replace("{CDO}", String.valueOf("('cd2','pc2','tug','oa2')"));
				break;
			case "cdl":
				ListaQuerys[i]=ListaQuerys[i].replace("{CDO}", String.valueOf("('cdl','slp','za2')"));
				break;
			case "cdm":
				ListaQuerys[i]=ListaQuerys[i].replace("{CDO}", String.valueOf("('cdm','dur')"));
				break;
			}
		}
		return ListaQuerys;
	}
	private List<Evaluacion> llenaClaseEvaluacion(ResultSet rs, String idEmpleado, Empleado infoUsu) {
		List<Evaluacion> ListEvaluaciones = new ArrayList<>();
		//System.out.print("entre aqui llenaClaseEvaluacion");
		int i=0,i2=0,i3=0,i4=0;
		boolean v1=false,v2=false,v3=false,v4=false;
		int contador1=0,contador2=0,contador3=0,contador4=0;
		int contadorR1=0,contadorR2=0,contadorR3=0,contadorR4=0;
		Evaluacion evaluacion1=new Evaluacion();
		Evaluacion evaluacion2=new Evaluacion();
		Evaluacion evaluacion3=new Evaluacion();
		Evaluacion evaluacion4=new Evaluacion();
		Resultados resultado1 =new Resultados();
		Resultados resultado2 =new Resultados();
		Resultados resultado3 =new Resultados();
		Resultados resultado4 =new Resultados();
		try
		{
			if(rs != null)
			{
				while(rs.next())
				{	
					switch (rs.getInt("id_tipo_encuesta")) {
					case 1:
						if(!(evaluacion1.getNombreCompleto().indexOf(rs.getString("nombre_completo"))>=0)) {
							evaluacion1.setNombreCompleto(rs.getString("nombre_completo"));
							evaluacion1.setIdEncuesta(rs.getString("id_encuesta"));
							evaluacion1.setEstatus(rs.getString("estatus"));
							evaluacion1.setVigenciaInicio(rs.getDate("fecha_vigencia_inicio"));
							evaluacion1.setVigenciaFin(rs.getDate("fecha_vigencia_fin"));
							evaluacion1.setPuesto(rs.getString("puesto"));
							evaluacion1.setRelacion(rs.getString("descripcion_perfil_colaborador"));
							evaluacion1.setIdPerfil(rs.getInt("id_perfil_colaborador"));
							evaluacion1.setIdEmpleadoev(rs.getString("id_empleado_evaluado"));
							evaluacion1.setIdEmpleado(rs.getString("id_empleado_evaluador"));
							
						}
							if(!(evaluacion1.getPregunta().indexOf(rs.getString("pregunta"))>=0)) {
								evaluacion1.setPregunta(rs.getString("pregunta"));
								evaluacion1.setIdPregunta(rs.getString("id_pregunta"));
								resultado1.setIdPregunta(rs.getString("id_pregunta"));
								contador1++;
								i++;
								
							}else {
								if(i-rs.getInt("concecutivo_pregunta")==0) {
									v1=true;
								}
								
								if(evaluacion1.getResultado().isEmpty()) {
									evaluacion1.setResultado(resultado1);
									evaluacion1.setPorcentaje(contadorR1);
									resultado1=new Resultados();
									contadorR1=0;
								}
								resultado1.setIdPregunta(rs.getString("id_pregunta"));
								
							}
						if(!(evaluacion1.getCompetencia().indexOf(rs.getString("id_competencia"))>=0)) {
							evaluacion1.setNumP(contador1);
							evaluacion1.setCompetencia(rs.getString("id_competencia"));
							contador1=1;
						}else{
							evaluacion1.getNumP().set(evaluacion1.getCompetencia().indexOf(rs.getString("id_competencia")), contador1);
						}
						evaluacion1.setConsecutivoPregunta(i);
						if(rs.getString("id_pregunta").equalsIgnoreCase(rs.getString("num_pregunta"))||rs.getString("num_pregunta")!=null) {
							if(rs.getString("resultado")!=null) {
								resultado1.setRespuesta(rs.getString("resultado"));
								resultado1.setComentarios(rs.getString("comentarios"));
								contadorR1++;
							}else {
								resultado1.setRespuesta("0");
								resultado1.setComentarios("");
							}
						}else{
							resultado1.setRespuesta("0");
							resultado1.setComentarios("");
						}
						
						if(v1) {
							evaluacion1.setResultado(resultado1);
							evaluacion1.setPorcentaje(contadorR1);
							v1=false;
							resultado1=new Resultados();
							contadorR1=0;
						}
						
						break;
						
					case 2:
						
							if(!(evaluacion2.getNombreCompleto().indexOf(rs.getString("nombre_completo"))>=0)) {
							evaluacion2.setNombreCompleto(rs.getString("nombre_completo"));
							evaluacion2.setIdEncuesta(rs.getString("id_encuesta"));
							evaluacion2.setEstatus(rs.getString("estatus"));
							evaluacion2.setVigenciaInicio(rs.getDate("fecha_vigencia_inicio"));
							evaluacion2.setVigenciaFin(rs.getDate("fecha_vigencia_fin"));
							evaluacion2.setPuesto(rs.getString("puesto"));
							evaluacion2.setRelacion(rs.getString("descripcion_perfil_colaborador"));
							evaluacion2.setIdPerfil(rs.getInt("id_perfil_colaborador"));
							evaluacion2.setIdEmpleadoev(rs.getString("id_empleado_evaluado"));
							evaluacion2.setIdEmpleado(rs.getString("id_empleado_evaluador"));
							
						}
							if(!(evaluacion2.getPregunta().indexOf(rs.getString("pregunta"))>=0)) {
								evaluacion2.setPregunta(rs.getString("pregunta"));
								evaluacion2.setIdPregunta(rs.getString("id_pregunta"));
								resultado2.setIdPregunta(rs.getString("id_pregunta"));
								contador2++;
								i2++;
								
							}else {
								if(i2-rs.getInt("concecutivo_pregunta")==0) {
									v2=true;
								}
								
								if(evaluacion2.getResultado().isEmpty()) {
									evaluacion2.setResultado(resultado2);
									evaluacion2.setPorcentaje(contadorR2);
									resultado2=new Resultados();
									contadorR2=0;
								}
								resultado2.setIdPregunta(rs.getString("id_pregunta"));
								
							}
						if(!(evaluacion2.getCompetencia().indexOf(rs.getString("id_competencia"))>=0)) {
							evaluacion2.setNumP(contador2);
							evaluacion2.setCompetencia(rs.getString("id_competencia"));
							contador2=1;
						}else{
							evaluacion2.getNumP().set(evaluacion2.getCompetencia().indexOf(rs.getString("id_competencia")), contador2);
						}
						evaluacion2.setConsecutivoPregunta(i2);
						if(rs.getString("id_pregunta").equalsIgnoreCase(rs.getString("num_pregunta"))||rs.getString("num_pregunta")!=null) {
							if(rs.getString("resultado")!=null) {
								resultado2.setRespuesta(rs.getString("resultado"));
								resultado2.setComentarios(rs.getString("comentarios"));
								contadorR2++;
							}else {
								resultado2.setRespuesta("0");
								resultado2.setComentarios("");
							}
						}else{
							resultado2.setRespuesta("0");
							resultado2.setComentarios("");
						}
						
						if(v2) {
							evaluacion2.setResultado(resultado2);
							evaluacion2.setPorcentaje(contadorR2);
							v2=false;
							resultado2=new Resultados();
							contadorR2=0;
						}
						
						break;
						
					case 3:
						
						if(!(evaluacion3.getNombreCompleto().indexOf(rs.getString("nombre_completo"))>=0)) {
							evaluacion3.setNombreCompleto(rs.getString("nombre_completo"));
							evaluacion3.setIdEncuesta(rs.getString("id_encuesta"));
							evaluacion3.setEstatus(rs.getString("estatus"));
							evaluacion3.setVigenciaInicio(rs.getDate("fecha_vigencia_inicio"));
							evaluacion3.setVigenciaFin(rs.getDate("fecha_vigencia_fin"));
							evaluacion3.setPuesto(rs.getString("puesto"));
							evaluacion3.setRelacion(rs.getString("descripcion_perfil_colaborador"));
							evaluacion3.setIdPerfil(rs.getInt("id_perfil_colaborador"));
							evaluacion3.setIdEmpleadoev(rs.getString("id_empleado_evaluado"));
							evaluacion3.setIdEmpleado(rs.getString("id_empleado_evaluador"));
							//evaluacion3.setResultado(resultado3);
						
							//resultado3 =new Resultados();
							
							
						}
						if(!(evaluacion3.getPregunta().indexOf(rs.getString("pregunta"))>=0)) {
							evaluacion3.setPregunta(rs.getString("pregunta"));
							evaluacion3.setIdPregunta(rs.getString("id_pregunta"));
							resultado3.setIdPregunta(rs.getString("id_pregunta"));
							contador3++;
							i3++;
						}else {
							
							if(i3-rs.getInt("concecutivo_pregunta")==0) {
								v3=true;
								//System.out.println("holaa");
							}
							resultado3.setIdPregunta(rs.getString("id_pregunta"));
							if(evaluacion3.getResultado().isEmpty()) {
								evaluacion3.setResultado(resultado3);
								evaluacion3.setPorcentaje(contadorR3);
								resultado3=new Resultados();
								contadorR3=0;
							}
							
						}
						if(!(evaluacion3.getCompetencia().indexOf(rs.getString("id_competencia"))>=0)) {
							evaluacion3.setNumP(contador3);
							evaluacion3.setCompetencia(rs.getString("id_competencia"));
							contador3=1;
						}else {
							evaluacion3.getNumP().set(evaluacion3.getCompetencia().indexOf(rs.getString("id_competencia")), contador3);
						}
						
						evaluacion3.setConsecutivoPregunta(i3);
						if(rs.getString("id_pregunta").equalsIgnoreCase(rs.getString("num_pregunta"))||rs.getString("num_pregunta")!=null) {
							if(rs.getString("resultado")!=null) {
							resultado3.setRespuesta(rs.getString("resultado"));
							resultado3.setComentarios(rs.getString("comentarios"));
							contadorR3++;}else {
								resultado3.setRespuesta("0");
								resultado3.setComentarios("");
							}
							
						}else{
							resultado3.setRespuesta("0");
							resultado3.setComentarios("");
						}
						if(v3) {
							evaluacion3.setResultado(resultado3);
							evaluacion3.setPorcentaje(contadorR3);
							v3=false;
							resultado3=new Resultados();
							contadorR3=0;
						}
						break;
						
					case 4:
						
						
						if(!(evaluacion4.getNombreCompleto().indexOf(rs.getString("nombre_completo"))>=0)) {
							evaluacion4.setNombreCompleto(rs.getString("nombre_completo"));
							evaluacion4.setIdEncuesta(rs.getString("id_encuesta"));
							evaluacion4.setEstatus(rs.getString("estatus"));
							evaluacion4.setVigenciaInicio(rs.getDate("fecha_vigencia_inicio"));
							evaluacion4.setVigenciaFin(rs.getDate("fecha_vigencia_fin"));
							evaluacion4.setPuesto(rs.getString("puesto"));
							evaluacion4.setRelacion(rs.getString("descripcion_perfil_colaborador"));
							evaluacion4.setIdPerfil(rs.getInt("id_perfil_colaborador"));
							evaluacion4.setIdEmpleadoev(rs.getString("id_empleado_evaluado"));
							evaluacion4.setIdEmpleado(rs.getString("id_empleado_evaluador"));
							
							
						}
						if(!(evaluacion4.getPregunta().indexOf(rs.getString("pregunta"))>=0)) {
							evaluacion4.setPregunta(rs.getString("pregunta"));
							evaluacion4.setIdPregunta(rs.getString("id_pregunta"));
							resultado4.setIdPregunta(rs.getString("id_pregunta"));
							contador4++;
							i4++;
						}else {
							
							if(i4-rs.getInt("concecutivo_pregunta")==0) {
								v4=true;
								//System.out.println("holaa");
							}
							resultado4.setIdPregunta(rs.getString("id_pregunta"));
							if(evaluacion4.getResultado().isEmpty()) {
								evaluacion4.setResultado(resultado4);
								evaluacion4.setPorcentaje(contadorR4);
								resultado4=new Resultados();
								contadorR4=0;
							}
							
						}
						
						if(!(evaluacion4.getCompetencia().indexOf(rs.getString("id_competencia"))>=0)) {
							evaluacion4.setNumP(contador4);
							evaluacion4.setCompetencia(rs.getString("id_competencia"));
							contador4=1;
						}else {
							evaluacion4.getNumP().set(evaluacion4.getCompetencia().indexOf(rs.getString("id_competencia")), contador4);
						}
						evaluacion4.setConsecutivoPregunta(i4);
						if(rs.getString("id_pregunta").equalsIgnoreCase(rs.getString("num_pregunta"))||rs.getString("num_pregunta")!=null) {
							if(rs.getString("resultado")!=null) {
							resultado4.setRespuesta(rs.getString("resultado"));
							resultado4.setComentarios(rs.getString("comentarios"));
							contadorR4++;}else {
								resultado4.setRespuesta("0");
								resultado4.setComentarios("");
							}
							
						}else{
							resultado4.setRespuesta("0");
							resultado4.setComentarios("");
						}
						if(v4) {
							evaluacion4.setResultado(resultado4);
							evaluacion4.setPorcentaje(contadorR4);
							v4=false;
							resultado4=new Resultados();
							contadorR4=0;
						}
						
						break;
						
					}
					
					
			}
			}
			if(evaluacion1.getConsecutivoPregunta()>0) {
				//porcentaje=evaluacion1.getConsecutivoPregunta()-contadorR1;
				if(evaluacion1.getResultado().isEmpty()) {
					evaluacion1.setResultado(resultado1);
					evaluacion1.setPorcentaje(contadorR1);
				}
				evaluacion1.setPorcentaje(contadorR1);
				evaluacion1.setIdTipoEncuesta(1);
				ListEvaluaciones.add(evaluacion1);
			}
			if(evaluacion2.getConsecutivoPregunta()>0) {
				//porcentaje=evaluacion2.getConsecutivoPregunta()-contadorR2;
				//evaluacion2.setPorcentaje(contadorR2);
				if(evaluacion2.getResultado().isEmpty()) {
					evaluacion2.setResultado(resultado2);
					evaluacion2.setPorcentaje(contadorR2);
				}
				evaluacion2.setIdTipoEncuesta(2);
				ListEvaluaciones.add(evaluacion2);
				//System.out.print("2");
			}
			if(evaluacion3.getConsecutivoPregunta()>0) {
				//porcentaje=evaluacion3.getConsecutivoPregunta()-contadorR3;
				//evaluacion3.setPorcentaje(contadorR3);
				if(evaluacion3.getResultado().isEmpty()) {
					evaluacion3.setResultado(resultado3);
					evaluacion3.setPorcentaje(contadorR3);
				}
				evaluacion3.setIdTipoEncuesta(3);
				ListEvaluaciones.add(evaluacion3);
				//System.out.print("3");
			}
			if(evaluacion4.getConsecutivoPregunta()>0) {
				//porcentaje=evaluacion4.getConsecutivoPregunta()-contadorR4;
				if(evaluacion4.getResultado().isEmpty()) {
					evaluacion4.setResultado(resultado4);
					evaluacion4.setPorcentaje(contadorR4);
				}
				evaluacion4.setIdTipoEncuesta(4);
				ListEvaluaciones.add(evaluacion4);
				//System.out.print("4");
			}
			
			
		}
		catch(Exception ex)
		{
			InsertaLogEncuestas.insertarLog(new LogEncuestas(),infoUsu.getEmpresa(),infoUsu.getEmpresa(),"[Error: Obtener catalogo de sucursales,  Clase: GestorVacantes.llenaEvaluaciones,  Detalle:"+ex.getMessage().toString().replace("'", "")+" Usuario: "+infoUsu.getNoEmpleado(),infoUsu.getNoEmpleado());  
			//System.out.println("[Error: Obtener catalogo de sucursales,  Clase: GestorVacantes.llenaEvaluaciones,  Detalle: " + ex.getMessage().toString() +"]");
			 
		}
		//System.out.println(ListEvaluaciones.size());
		return ListEvaluaciones;
	}
	public List<Evaluacion> verificaRespuesta(String idPregunta, String comentarios,String resultado, String idEmpleadoev, String idEmpleadoer,  List<Querys> listaQuerys, String cdo, Empleado infoUsu, String idEncuesta) {
		Connection connBD = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		connBD = ConexionBD.AbrirConexionBDD(cdo);	
		List<Evaluacion> ListEvaluaciones = new ArrayList<>();
		
		try {
			//System.out.println("Entra ");
			String[] querys = new String[25];	
			querys = Cls_Querys.LimpiaListaQuerys(querys);	
			querys = Cls_Querys.ObtieneQuerys(4, listaQuerys, querys);
			//System.out.println("querys3: " + querys);
			querys = inicializaQueryNumero4(querys, idPregunta, idEmpleadoev,idEmpleadoer,idEncuesta);
			//System.out.println("DESPUES: querys3: " + querys);
			pstm = connBD.prepareStatement("{call " + "DCH.usp_EXECUTE_QUERY(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			rs=  Cls_Querys.EjecutarQuery(querys[0], querys[1],querys[2], querys[3], querys[4], querys[5], querys[6],
														 querys[7], querys[8], querys[9],querys[10], querys[11], querys[12], querys[13], 
														 querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], 
														 querys[21], querys[22], querys[23], querys[24], "",pstm, connBD, infoUsu);
			
			
			Cls_Querys.ImprimeQuerysConsola(querys,false,"Query 4");
			while(rs.next()) {
				if(rs.getInt("valida")==0){
					insertaRespuesta(idPregunta, comentarios , resultado, idEmpleadoev, idEmpleadoer, listaQuerys, cdo, infoUsu,idEncuesta);
				}else {
					actualizaRespuesta(idPregunta, comentarios , resultado, idEmpleadoev, idEmpleadoer, listaQuerys, cdo, infoUsu,idEncuesta);
				}
			}
			ListEvaluaciones.add(new Evaluacion());			
			InsertaLogEncuestas.insertarLog(new LogEncuestas(),infoUsu.getEmpresa(),infoUsu.getEmpresa(),"Entrada a Valida respuesta Usuario: "+infoUsu.getNoEmpleado()+"qry{"+Cls_Querys.regresaQuerys(querys,true)+"}",infoUsu.getNoEmpleado());	
		}catch(Exception ex)
		{
			InsertaLogEncuestas.insertarLog(new LogEncuestas(),infoUsu.getEmpresa(),infoUsu.getEmpresa(),"Error - GestorEvaluaciones.consultaEvaluaciones: "+ex.getMessage().toString().replace("'", "")+" Usuario: "+infoUsu.getNoEmpleado(),infoUsu.getNoEmpleado());  
		}
		finally {
			try {
				if(connBD != null) {
					connBD.close();
				}
				if(pstm != null) {
					pstm.close();
				}
			} catch (Exception e) {
				InsertaLogEncuestas.insertarLog(new LogEncuestas(),infoUsu.getEmpresa(),infoUsu.getEmpresa(),"ERROR al cerrar conexion en GestorEvaluacion.ConsultaEmpleados: " + e.toString().replace("'", "")+" Usuario: "+infoUsu.getNoEmpleado(),infoUsu.getNoEmpleado());

			}
		}
		return ListEvaluaciones;
	}
	private void actualizaRespuesta(String idPregunta, String comentarios, String resultado, String idEmpleadoev, String idEmpleadoer, List<Querys> listaQuerys,
			String cdo, Empleado infoUsu, String idEncuesta) {
		Connection connBD = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		connBD = ConexionBD.AbrirConexionBDD(cdo);	
		
		try {
			//System.out.println("Entra ");
			String[] querys = new String[25];	
			querys = Cls_Querys.LimpiaListaQuerys(querys);	
			querys = Cls_Querys.ObtieneQuerys(4, listaQuerys, querys);
			//System.out.println("querys3: " + querys);
			querys = inicializaQueryNumero42(querys, idPregunta,comentarios,resultado,idEmpleadoev,idEmpleadoer,idEncuesta);
			//System.out.println("DESPUES: querys3: " + querys);
			pstm = connBD.prepareStatement("{call " + "DCH.usp_EXECUTE_QUERY(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			rs=  Cls_Querys.EjecutarQuery(querys[0], querys[1],querys[2], querys[3], querys[4], querys[5], querys[6],
														 querys[7], querys[8], querys[9],querys[10], querys[11], querys[12], querys[13], 
														 querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], 
														 querys[21], querys[22], querys[23], querys[24], "",pstm, connBD, infoUsu);
			
			
			Cls_Querys.ImprimeQuerysConsola(querys,false,"Query 1");		
			InsertaLogEncuestas.insertarLog(new LogEncuestas(),infoUsu.getEmpresa(),infoUsu.getEmpresa(),"Entrada a Actualiza Respuesta Usuario: "+infoUsu.getNoEmpleado()+"qry{"+Cls_Querys.regresaQuerys(querys,true)+"}",infoUsu.getNoEmpleado());	
		}catch(Exception ex)
		{
			InsertaLogEncuestas.insertarLog(new LogEncuestas(),infoUsu.getEmpresa(),infoUsu.getEmpresa(),"Error - GestorEvaluaciones.consultaEvaluaciones: "+ex.getMessage().toString().replace("'", "")+" Usuario: "+infoUsu.getNoEmpleado(),infoUsu.getNoEmpleado());  
		}
		finally {
			try {
				if(connBD != null) {
					connBD.close();
				}
				if(pstm != null) {
					pstm.close();
				}
			} catch (Exception e) {
				InsertaLogEncuestas.insertarLog(new LogEncuestas(),infoUsu.getEmpresa(),infoUsu.getEmpresa(),"ERROR al cerrar conexcion en GestorEvaluaciones.consultaEvaluaciones:"+e.getMessage().toString().replace("'", "")+infoUsu.getNoEmpleado(),infoUsu.getNoEmpleado());	
			}
		}
	}
	private String[] inicializaQueryNumero42(String[] querys, String idPregunta, String comentarios, String resultado, String idEmpleadoev, String idEmpleadoer, String idEncuesta) {
		for (int i=0;i <querys.length; i++)
		{	
			querys[i]=querys[i].replace("{ID_PREGUNTA}", String.valueOf(idPregunta));
			querys[i]=querys[i].replace("{RESULTADO}", String.valueOf(resultado));
			querys[i]=querys[i].replace("{COMENTARIOS}", String.valueOf(comentarios));
			querys[i]=querys[i].replace("{ID_EMPLEADO_EVALUADO}", String.valueOf(idEmpleadoev));
			querys[i]=querys[i].replace("{ID_EMPLEADO_EVALUADOR}", String.valueOf(idEmpleadoer));
			querys[i]=querys[i].replace("{ID_ENCUESTA}", String.valueOf(idEncuesta));
		}
		//querys[0]=" ";
		querys[2]=" ";
		querys[5]=" ";
		return querys;
	
	}
	private void insertaRespuesta(String idPregunta, String comentarios, String resultado, String idEmpleadoev, String idEmpleadoer, List<Querys> listaQuerys,
			String cdo, Empleado infoUsu, String idEncuesta) {
		Connection connBD = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		connBD = ConexionBD.AbrirConexionBDD(cdo);	
		String[] querys = new String[25];
		try {
			//System.out.println("Entra ");
				
			querys = Cls_Querys.LimpiaListaQuerys(querys);	
			querys = Cls_Querys.ObtieneQuerys(4, listaQuerys, querys);
			//System.out.println("querys3: " + querys);
			querys = inicializaQueryNumero43(querys, idPregunta,comentarios,resultado,idEmpleadoev,idEmpleadoer,idEncuesta);
			//System.out.println("DESPUES: querys3: " + querys);
			pstm = connBD.prepareStatement("{call " + "DCH.usp_EXECUTE_QUERY(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			rs=  Cls_Querys.EjecutarQuery(querys[0], querys[1],querys[2], querys[3], querys[4], querys[5], querys[6],
														 querys[7], querys[8], querys[9],querys[10], querys[11], querys[12], querys[13], 
														 querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], 
														 querys[21], querys[22], querys[23], querys[24], "",pstm, connBD, infoUsu);
			
			
			Cls_Querys.ImprimeQuerysConsola(querys,false,"Query 4");
			InsertaLogEncuestas.insertarLog(new LogEncuestas(),infoUsu.getEmpresa(),infoUsu.getEmpresa(),"Entrada a insertaRespuesta Usuario: "+infoUsu.getNoEmpleado()+"qry{"+Cls_Querys.regresaQuerys(querys,true)+"}",infoUsu.getNoEmpleado());	

		}catch(Exception ex)
		{
			InsertaLogEncuestas.insertarLog(new LogEncuestas(),infoUsu.getEmpresa(),infoUsu.getEmpresa(),"ERROR al cerrar conexcion en GestorVacantes.insertaRespuesta:"+ex.getMessage().toString().replace("'", "")+infoUsu.getNoEmpleado()+"qry{"+Cls_Querys.regresaQuerys(querys,true)+"}",infoUsu.getNoEmpleado());	
		}
		finally {
			try {
				if(connBD != null) {
					connBD.close();
				}
				if(pstm != null) {
					pstm.close();
				}
			} catch (Exception e) {
				
				InsertaLogEncuestas.insertarLog(new LogEncuestas(),infoUsu.getEmpresa(),infoUsu.getEmpresa(),"ERROR al cerrar conexcion en GestorVacantes.insertaRespuesta:"+e.getMessage().toString().replace("'", "")+infoUsu.getNoEmpleado(),infoUsu.getNoEmpleado());	
			}
		}
	}
	private String[] inicializaQueryNumero4(String[] querys, String idPregunta, String idEmpleadoev, String idEmpleadoer, String idEncuesta) {
		for (int i=0;i <querys.length; i++)
		{	

			querys[i]=querys[i].replace("{ID_EMPLEADO_EVALUADO}", String.valueOf(idEmpleadoev));
			querys[i]=querys[i].replace("{ID_EMPLEADO_EVALUADOR}", String.valueOf(idEmpleadoer));
			querys[i]=querys[i].replace("{ID_PREGUNTA}", String.valueOf(idPregunta));
			querys[i]=querys[i].replace("{ID_ENCUESTA}", String.valueOf(idEncuesta));
		}
		querys[1]=" ";
		querys[2]=" ";
		return querys;
	}
	
	private String[] inicializaQueryNumero43(String[] querys, String idPregunta, String comentarios, String resultado, String idEmpleadoev, String idEmpleadoer, String idEncuesta) {
	
		for (int i=0;i <querys.length; i++)
		{	
			querys[i]=querys[i].replace("{ID_PREGUNTA}", String.valueOf(idPregunta));
			querys[i]=querys[i].replace("{RESULTADO}", String.valueOf(resultado));
			querys[i]=querys[i].replace("{COMENTARIOS}", String.valueOf(comentarios));
			querys[i]=querys[i].replace("{ID_EMPLEADO_EVALUADO}", String.valueOf(idEmpleadoev));
			querys[i]=querys[i].replace("{ID_EMPLEADO_EVALUADOR}", String.valueOf(idEmpleadoer));
			querys[i]=querys[i].replace("{ID_ENCUESTA}", String.valueOf(idEncuesta));
		}
		//querys[0]=" ";
		querys[1]=" ";
		return querys;
	}
	public List<Evaluacion> actualizaEstatus(String estatus, String idEmpleadoev, String idEmpleadoer,
			List<Querys> listaQuerys, String cdo, Empleado infoUsu) {
		Connection connBD = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		connBD = ConexionBD.AbrirConexionBDD(cdo);	
		List<Evaluacion> ListEvaluaciones = new ArrayList<>();
		String[] querys = new String[25];	
		try {
			//System.out.println("Entra ");
			
			querys = Cls_Querys.LimpiaListaQuerys(querys);	
			querys = Cls_Querys.ObtieneQuerys(13, listaQuerys, querys);
			//System.out.println("querys3: " + querys);
			querys = inicializaQueryNumero13(querys, estatus, idEmpleadoev,idEmpleadoer);
			//System.out.println("DESPUES: querys3: " + querys);
			pstm = connBD.prepareStatement("{call " + "DCH.usp_EXECUTE_QUERY(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			rs=  Cls_Querys.EjecutarQuery(querys[0], querys[1],querys[2], querys[3], querys[4], querys[5], querys[6],
														 querys[7], querys[8], querys[9],querys[10], querys[11], querys[12], querys[13], 
														 querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], 
														 querys[21], querys[22], querys[23], querys[24], "",pstm, connBD, infoUsu);
			
			
			Cls_Querys.ImprimeQuerysConsola(querys,false,"Query 4");
			ListEvaluaciones.add(new Evaluacion());			
			InsertaLogEncuestas.insertarLog(new LogEncuestas(),infoUsu.getEmpresa(),infoUsu.getEmpresa(),"Entrada a actualizar encuesta Usuario: "+infoUsu.getNoEmpleado()+"qry{"+Cls_Querys.regresaQuerys(querys,true)+"}",infoUsu.getNoEmpleado());
		}catch(Exception ex)
		{
			InsertaLogEncuestas.insertarLog(new LogEncuestas(),infoUsu.getEmpresa(),infoUsu.getEmpresa(),"Error - GestorEvaluaciones.consultaEvaluaciones: " + ex.toString().replace("'", "")+" Usuario: "+infoUsu.getNoEmpleado(),infoUsu.getNoEmpleado());
			}
		finally {
			try {
				if(connBD != null) {
					connBD.close();
				}
				if(pstm != null) {
					pstm.close();
				}
			} catch (Exception e) {
				InsertaLogEncuestas.insertarLog(new LogEncuestas(),infoUsu.getEmpresa(),infoUsu.getEmpresa(),"ERROR al cerrar conexion en GestorEvaluacion.actualizaEstatus: " + e.toString().replace("'", "")+" Usuario: "+infoUsu.getNoEmpleado(),infoUsu.getNoEmpleado());
			}
		}
		return ListEvaluaciones;
}
	
	private String[] inicializaQueryNumero13(String[] querys, String estatus, String idEmpleadoev,
			String idEmpleadoer) {
		for (int i=0;i <querys.length; i++)
		{	
			querys[i]=querys[i].replace("{ESTATUS}", String.valueOf(estatus));
			querys[i]=querys[i].replace("{ID_EMPLEADO_EVALUADO}", String.valueOf(idEmpleadoev));
			querys[i]=querys[i].replace("{ID_EMPLEADO_EVALUADOR}", String.valueOf(idEmpleadoer));
			
		}
		if(!estatus.equalsIgnoreCase("2")) {
			querys[1]=" ";
		}
		return querys;
	}
	public boolean validaResultado(List<Querys> listaQuerys, String cdo, String idEmpleadoEvaluado,
			String idEmpleadoEvaluador, String idTipoEncuesta, Empleado infoUsu) {
		Connection connBD = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		connBD = ConexionBD.AbrirConexionBDD(cdo);	
		boolean validaRespuestas = false;
		String[] querys = new String[25];	
		try {
			//System.out.println("Entra ");
			
			querys = Cls_Querys.LimpiaListaQuerys(querys);	
			querys = Cls_Querys.ObtieneQuerys(19, listaQuerys, querys);
			//System.out.println("querys3: " + querys);
			querys = inicializaQueryNumero19(querys, idTipoEncuesta, idEmpleadoEvaluador,idEmpleadoEvaluado, cdo);
			//System.out.println("DESPUES: querys3: " + querys);
			pstm = connBD.prepareStatement("{call " + "DCH.usp_EXECUTE_QUERY(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			rs=  Cls_Querys.EjecutarQuery(querys[0], querys[1],querys[2], querys[3], querys[4], querys[5], querys[6],
														 querys[7], querys[8], querys[9],querys[10], querys[11], querys[12], querys[13], 
														 querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], 
														 querys[21], querys[22], querys[23], querys[24], "",pstm, connBD, infoUsu);
			
			
			Cls_Querys.ImprimeQuerysConsola(querys,false,"Query 19");
			
			while(rs.next()) {
				//System.out.print(rs.getInt("resultados")-rs.getInt("preguntas"));
				if(rs.getInt("resultados")-rs.getInt("preguntas")==0||rs.getInt("resultados")-(rs.getInt("preguntas")-3)==0) {
					validaRespuestas=true;
				}
			}
			InsertaLogEncuestas.insertarLog(new LogEncuestas(),infoUsu.getEmpresa(),infoUsu.getEmpresa(),"Entrada a verificar resultados Usuario: "+infoUsu.getNoEmpleado()+"qry{"+Cls_Querys.regresaQuerys(querys,true)+"}",infoUsu.getNoEmpleado());
		}catch(Exception ex)
		{
			InsertaLogEncuestas.insertarLog(new LogEncuestas(),infoUsu.getEmpresa(),infoUsu.getEmpresa(),"Error - GestorEvaluaciones.validaResultado: " + ex.toString().replace("'", "")+" Usuario: "+infoUsu.getNoEmpleado(),infoUsu.getNoEmpleado());
			}
		finally {
			try {
				if(connBD != null) {
					connBD.close();
				}
				if(pstm != null) {
					pstm.close();
				}
			} catch (Exception e) {
				InsertaLogEncuestas.insertarLog(new LogEncuestas(),infoUsu.getEmpresa(),infoUsu.getEmpresa(),"ERROR al cerrar conexion en GestorEvaluacion.validaResultado: " + e.toString().replace("'", "")+" Usuario: "+infoUsu.getNoEmpleado(),infoUsu.getNoEmpleado());
			}
		}
		return validaRespuestas;
}
	private String[] inicializaQueryNumero19(String[] querys, String idTipoEncuesta, String idEmpleadoEvaluador,
			String idEmpleadoEvaluado, String cdo) {
		for (int i=0;i <querys.length; i++)
		{	
			querys[i]=querys[i].replace("{TIPO_ENCUESTA}", String.valueOf(idTipoEncuesta));
			querys[i]=querys[i].replace("{ID_EMPLEADO_EVALUADO}", String.valueOf(idEmpleadoEvaluado));
			querys[i]=querys[i].replace("{ID_EMPLEADO_EVALUADOR}", String.valueOf(idEmpleadoEvaluador));
			switch(cdo) {
			case "cdf":
				querys[i]=querys[i].replace("{CDO}", String.valueOf("('cdf','cto','ac2','gdl','cq2')"));
				break;
			case "cd2":
				querys[i]=querys[i].replace("{CDO}", String.valueOf("('cd2','pc2','tug','oa2')"));
				break;
			case "cdl":
				querys[i]=querys[i].replace("{CDO}", String.valueOf("('cdl','slp','za2')"));
				break;
			case "cdm":
				querys[i]=querys[i].replace("{CDO}", String.valueOf("('cdm','dur')"));
				break;
			}
		}
		return querys;
	}
}