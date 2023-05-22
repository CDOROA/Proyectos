package cdo.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import cdo.Datos.LogAlmacen;
import cdo.Datos.Usuario;

public class EjecutaQuerysBD {
	
	public static ResultSet EjecutarQuery(String qry1,String qry2,String qry3,String qry4,String qry5,String qry6,String qry7,String qry8,String qry9,String qry10,String qry11,String qry12,
			 						 String qry13,String qry14,String qry15,String qry16,String qry17,String qry18,String qry19,String qry20,String qry21,String qry22,String qry23,
			 						 String qry24,String qry25,String cdo, PreparedStatement pstmt, Connection conexion, Usuario infoUsu)
	{		
		ResultSet rs = null;
		try
		{
			//conexion =  ConexionBD.AbrirConexionBDD(cdo);
			pstmt.setString(1, qry1);
			pstmt.setString(2, qry2);
			pstmt.setString(3, qry3);
			pstmt.setString(4, qry4);
			pstmt.setString(5, qry5);
			pstmt.setString(6, qry6);
			pstmt.setString(7, qry7);
			pstmt.setString(8, qry8);
			pstmt.setString(9, qry9);
			pstmt.setString(10, qry10);
			pstmt.setString(11, qry11);
			pstmt.setString(12, qry12);
			pstmt.setString(13, qry13);
			pstmt.setString(14, qry14);
			pstmt.setString(15, qry15);
			pstmt.setString(16, qry16);
	      	pstmt.setString(17, qry17);
	      	pstmt.setString(18, qry18);
	      	pstmt.setString(19, qry19);
	      	pstmt.setString(20, qry20);
	      	pstmt.setString(21, qry21);
	      	pstmt.setString(22, qry22);
	      	pstmt.setString(23, qry23);
	      	pstmt.setString(24, qry24);
	      	pstmt.setString(25, qry25);
	      	rs = pstmt.executeQuery(); 
		}
		catch(Exception ex)
		{
			InsertarLogAlamacen.insertarLog(new LogAlmacen("","",""),infoUsu.getUname(),infoUsu.getUname_br(),"Error al ejecutar querys. DETALLE: "+ex.getMessage().toString().replace("'", "´")+"  Qrys["+qry1.toString().replace("'","´")+qry2.toString().replace("'","´")+qry3.toString().replace("'","´")+qry4.toString().replace("'","´")+qry5.toString().replace("'","´")+"]",infoUsu.getCve_usuario());
			if (ex.getMessage().toString().replace("'", "´").contains("Encontrado deadlock cuando tentando obtener el bloqueo") || ex.getMessage().toString().replace("'", "´").contains("Tiempo de bloqueo de espera excedido"))
			{
				try
				{
					//conexion =  ConexionBD.AbrirConexionBDD(cdo);
					
					pstmt.setString(1, qry1);
					pstmt.setString(2, qry2);
					pstmt.setString(3, qry3);
					pstmt.setString(4, qry4);
					pstmt.setString(5, qry5);
					pstmt.setString(6, qry6);
					pstmt.setString(7, qry7);
					pstmt.setString(8, qry8);
					pstmt.setString(9, qry9);
					pstmt.setString(10, qry10);
					pstmt.setString(11, qry11);
					pstmt.setString(12, qry12);
					pstmt.setString(13, qry13);
					pstmt.setString(14, qry14);
					pstmt.setString(15, qry15);
					pstmt.setString(16, qry16);
			      	pstmt.setString(17, qry17);
			      	pstmt.setString(18, qry18);
			      	pstmt.setString(19, qry19);
			      	pstmt.setString(20, qry20);
			      	pstmt.setString(21, qry21);
			      	pstmt.setString(22, qry22);
			      	pstmt.setString(23, qry23);
			      	pstmt.setString(24, qry24);
			      	pstmt.setString(25, qry25);
			      	rs = pstmt.executeQuery();
				}
				catch (Exception e) 
				{
					InsertarLogAlamacen.insertarLog(new LogAlmacen("","",""),infoUsu.getUname(),infoUsu.getUname_br(),"Error al ejecutar querys. DETALLE 2: "+e.getMessage().toString().replace("'", "´")+"  Qrys["+qry1.toString().replace("'","´")+qry2.toString().replace("'","´")+qry3.toString().replace("'","´")+qry4.toString().replace("'","´")+qry5.toString().replace("'","´")+"]",infoUsu.getCve_usuario());
					if (e.getMessage().toString().replace("'", "´").contains("Encontrado deadlock cuando tentando obtener el bloqueo") || e.getMessage().toString().replace("'", "´").contains("Tiempo de bloqueo de espera excedido"))
					{
						try
						{
							//conexion =  ConexionBD.AbrirConexionBDD(cdo);
							
							pstmt.setString(1, qry1);
							pstmt.setString(2, qry2);
							pstmt.setString(3, qry3);
							pstmt.setString(4, qry4);
							pstmt.setString(5, qry5);
							pstmt.setString(6, qry6);
							pstmt.setString(7, qry7);
							pstmt.setString(8, qry8);
							pstmt.setString(9, qry9);
							pstmt.setString(10, qry10);
							pstmt.setString(11, qry11);
							pstmt.setString(12, qry12);
							pstmt.setString(13, qry13);
							pstmt.setString(14, qry14);
							pstmt.setString(15, qry15);
							pstmt.setString(16, qry16);
					      	pstmt.setString(17, qry17);
					      	pstmt.setString(18, qry18);
					      	pstmt.setString(19, qry19);
					      	pstmt.setString(20, qry20);
					      	pstmt.setString(21, qry21);
					      	pstmt.setString(22, qry22);
					      	pstmt.setString(23, qry23);
					      	pstmt.setString(24, qry24);
					      	pstmt.setString(25, qry25);
					      	rs = pstmt.executeQuery();
						}
						catch (Exception e3) 
						{
							InsertarLogAlamacen.insertarLog(new LogAlmacen("","",""),infoUsu.getUname(),infoUsu.getUname_br(),"Error al ejecutar querys. DETALLE 3: "+e3.getMessage().toString().replace("'", "´")+"  Qrys["+qry1.toString().replace("'","´")+qry2.toString().replace("'","´")+qry3.toString().replace("'","´")+qry4.toString().replace("'","´")+qry5.toString().replace("'","´")+"]",infoUsu.getCve_usuario());
							if (e3.getMessage().toString().replace("'", "´").contains("Encontrado deadlock cuando tentando obtener el bloqueo") || e3.getMessage().toString().replace("'", "´").contains("Tiempo de bloqueo de espera excedido"))
							{
								try
								{
									//conexion =  ConexionBD.AbrirConexionBDD(cdo);
									
									pstmt.setString(1, qry1);
									pstmt.setString(2, qry2);
									pstmt.setString(3, qry3);
									pstmt.setString(4, qry4);
									pstmt.setString(5, qry5);
									pstmt.setString(6, qry6);
									pstmt.setString(7, qry7);
									pstmt.setString(8, qry8);
									pstmt.setString(9, qry9);
									pstmt.setString(10, qry10);
									pstmt.setString(11, qry11);
									pstmt.setString(12, qry12);
									pstmt.setString(13, qry13);
									pstmt.setString(14, qry14);
									pstmt.setString(15, qry15);
									pstmt.setString(16, qry16);
							      	pstmt.setString(17, qry17);
							      	pstmt.setString(18, qry18);
							      	pstmt.setString(19, qry19);
							      	pstmt.setString(20, qry20);
							      	pstmt.setString(21, qry21);
							      	pstmt.setString(22, qry22);
							      	pstmt.setString(23, qry23);
							      	pstmt.setString(24, qry24);
							      	pstmt.setString(25, qry25);
							      	rs = pstmt.executeQuery();
								}
								catch (Exception e4) 
								{
									InsertarLogAlamacen.insertarLog(new LogAlmacen("","",""),infoUsu.getUname(),infoUsu.getUname_br(),"Error al ejecutar querys. DETALLE 4: "+e4.getMessage().toString().replace("'", "´")+"  Qrys["+qry1.toString().replace("'","´")+qry2.toString().replace("'","´")+qry3.toString().replace("'","´")+qry4.toString().replace("'","´")+qry5.toString().replace("'","´")+"]",infoUsu.getCve_usuario());
									if (e4.getMessage().toString().replace("'", "´").contains("Encontrado deadlock cuando tentando obtener el bloqueo") || e4.getMessage().toString().replace("'", "´").contains("Tiempo de bloqueo de espera excedido"))
									{
										try
										{
											//conexion =  ConexionBD.AbrirConexionBDD(cdo);
											
											pstmt.setString(1, qry1);
											pstmt.setString(2, qry2);
											pstmt.setString(3, qry3);
											pstmt.setString(4, qry4);
											pstmt.setString(5, qry5);
											pstmt.setString(6, qry6);
											pstmt.setString(7, qry7);
											pstmt.setString(8, qry8);
											pstmt.setString(9, qry9);
											pstmt.setString(10, qry10);
											pstmt.setString(11, qry11);
											pstmt.setString(12, qry12);
											pstmt.setString(13, qry13);
											pstmt.setString(14, qry14);
											pstmt.setString(15, qry15);
											pstmt.setString(16, qry16);
									      	pstmt.setString(17, qry17);
									      	pstmt.setString(18, qry18);
									      	pstmt.setString(19, qry19);
									      	pstmt.setString(20, qry20);
									      	pstmt.setString(21, qry21);
									      	pstmt.setString(22, qry22);
									      	pstmt.setString(23, qry23);
									      	pstmt.setString(24, qry24);
									      	pstmt.setString(25, qry25);
									      	rs = pstmt.executeQuery();
										}
										catch (Exception e5) 
										{
											InsertarLogAlamacen.insertarLog(new LogAlmacen("","",""),infoUsu.getUname(),infoUsu.getUname_br(),"Error al ejecutar querys. DETALLE 5: "+e5.getMessage().toString().replace("'", "´")+"  Qrys["+qry1.toString().replace("'","´")+qry2.toString().replace("'","´")+qry3.toString().replace("'","´")+qry4.toString().replace("'","´")+qry5.toString().replace("'","´")+"]",infoUsu.getCve_usuario());
											if (e5.getMessage().toString().replace("'", "´").contains("Encontrado deadlock cuando tentando obtener el bloqueo") || e5.getMessage().toString().replace("'", "´").contains("Tiempo de bloqueo de espera excedido"))
											{
												try
												{
													//conexion =  ConexionBD.AbrirConexionBDD(cdo);
													
													pstmt.setString(1, qry1);
													pstmt.setString(2, qry2);
													pstmt.setString(3, qry3);
													pstmt.setString(4, qry4);
													pstmt.setString(5, qry5);
													pstmt.setString(6, qry6);
													pstmt.setString(7, qry7);
													pstmt.setString(8, qry8);
													pstmt.setString(9, qry9);
													pstmt.setString(10, qry10);
													pstmt.setString(11, qry11);
													pstmt.setString(12, qry12);
													pstmt.setString(13, qry13);
													pstmt.setString(14, qry14);
													pstmt.setString(15, qry15);
													pstmt.setString(16, qry16);
											      	pstmt.setString(17, qry17);
											      	pstmt.setString(18, qry18);
											      	pstmt.setString(19, qry19);
											      	pstmt.setString(20, qry20);
											      	pstmt.setString(21, qry21);
											      	pstmt.setString(22, qry22);
											      	pstmt.setString(23, qry23);
											      	pstmt.setString(24, qry24);
											      	pstmt.setString(25, qry25);
											      	rs = pstmt.executeQuery();
												}
												catch (Exception e6) 
												{
													InsertarLogAlamacen.insertarLog(new LogAlmacen("","",""),infoUsu.getUname(),infoUsu.getUname_br(),"Error al ejecutar querys. DETALLE 6: "+e6.getMessage().toString().replace("'", "´")+"  Qrys["+qry1.toString().replace("'","´")+qry2.toString().replace("'","´")+qry3.toString().replace("'","´")+qry4.toString().replace("'","´")+qry5.toString().replace("'","´")+"]",infoUsu.getCve_usuario());
													if (e6.getMessage().toString().replace("'", "´").contains("Encontrado deadlock cuando tentando obtener el bloqueo") || e6.getMessage().toString().replace("'", "´").contains("Tiempo de bloqueo de espera excedido"))
													{
														try
														{
															//conexion =  ConexionBD.AbrirConexionBDD(cdo);
															
															pstmt.setString(1, qry1);
															pstmt.setString(2, qry2);
															pstmt.setString(3, qry3);
															pstmt.setString(4, qry4);
															pstmt.setString(5, qry5);
															pstmt.setString(6, qry6);
															pstmt.setString(7, qry7);
															pstmt.setString(8, qry8);
															pstmt.setString(9, qry9);
															pstmt.setString(10, qry10);
															pstmt.setString(11, qry11);
															pstmt.setString(12, qry12);
															pstmt.setString(13, qry13);
															pstmt.setString(14, qry14);
															pstmt.setString(15, qry15);
															pstmt.setString(16, qry16);
													      	pstmt.setString(17, qry17);
													      	pstmt.setString(18, qry18);
													      	pstmt.setString(19, qry19);
													      	pstmt.setString(20, qry20);
													      	pstmt.setString(21, qry21);
													      	pstmt.setString(22, qry22);
													      	pstmt.setString(23, qry23);
													      	pstmt.setString(24, qry24);
													      	pstmt.setString(25, qry25);
													      	rs = pstmt.executeQuery();
														}
														catch (Exception e7) 
														{
															InsertarLogAlamacen.insertarLog(new LogAlmacen("","",""),infoUsu.getUname(),infoUsu.getUname_br(),"Error al ejecutar querys. DETALLE 7: "+e7.getMessage().toString().replace("'", "´")+"  Qrys["+qry1.toString().replace("'","´")+qry2.toString().replace("'","´")+qry3.toString().replace("'","´")+qry4.toString().replace("'","´")+qry5.toString().replace("'","´")+"]",infoUsu.getCve_usuario());
														}
													}
												}
											}	
										}
									}
								}
							}
						}
					}
				}
			}else {
				InsertarLogAlamacen.insertarLog(new LogAlmacen("","",""),infoUsu.getUname(),infoUsu.getUname_br(),"Error al ejecutar querys. DETALLE : "+ex.getMessage().toString().replace("'", "´")+"  Qrys["+qry1.toString().replace("'","´")+qry2.toString().replace("'","´")+qry3.toString().replace("'","´")+qry4.toString().replace("'","´")+qry5.toString().replace("'","´")+"]",infoUsu.getCve_usuario());
				System.out.println("Error al ejecutar Query: "+ex.getMessage().toString());
			}
			
		}
		return rs;
				
	}



}
