

package cdo.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import cdo.Datos.LogAlmacen;
import cdo.Datos.PedidosConsulta;
import cdo.Datos.Usuario;

public class Cls_CrearTicketDeIngresos {
	
	public String crearArchivoTxtDelTicket(String folio, List<PedidosConsulta> p,String usuario,String impresora,String chofer, String uname, String cdo_nombre, String nombre_chofer, String pedidos, HttpSession session, String tipoEnc, Usuario infoUsu, String ticket, String ruta)
	{
		String respuesta = "NO SE PUDO IMPRIMIR";
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");  
		LocalDateTime now = LocalDateTime.now(); 
		try
		{
			String rutas = "ENVIOS,CAJA,CREDITO";
//			String rutas = "ENVIOS,";
			if (ticket.contains("todo") || ticket.equals("")) 
			{
				rutas = rutas;
			}
			else
			{
				rutas = ticket+",";
			}
			String split [] = rutas.split(",");
			
			for (String s : split) 
			{
				String rutaNombreArchivo = "/tmp/" + "Ticket_AsignacionPedidosChofer_"+folio+"_"+s+".txt";
			//	String rutaNombreArchivo = "C:\\Workspace's\\workSpaceAndres\\" + "Ticket_AsignacionPedidosChofer_"+folio+"_"+s+".txt";
			//	String rutaNombreArchivo = "C:\\FTP\\Ticket\\"+ "Ticket_AsignacionPedidosChofer_"+folio+"_"+s+".txt";
	            File archivoDeTicket = new File(rutaNombreArchivo);
	            archivoDeTicket=validaSiExisteArchivoTxtDelTicket(archivoDeTicket,infoUsu,folio);
	            respuesta = creaCuerpoDelArchivoTxtDelTicket(archivoDeTicket, p, dtf.format(now), rutaNombreArchivo,folio,usuario,impresora,chofer,uname,cdo_nombre,nombre_chofer,pedidos,s,tipoEnc,infoUsu,ruta);
	            InsertarLogAlamacen.insertarLog(new LogAlmacen("","",""),infoUsu.getUname(),infoUsu.getUname_br(),"Impresion correcta Ticket: "+s+". Folio: "+folio+", Impresora: "+impresora,infoUsu.getCve_usuario());
			}
            
        } 
		//clave transaccion de los acumuladores   correo a los implicados
		catch (Exception e)
		{
			InsertarLogAlamacen.insertarLog(new LogAlmacen("","",""),infoUsu.getUname(),infoUsu.getUname_br(),"Error en metodo principal, creacion de ticket. Folio: "+folio+" . DETALLE: "+Error(e),infoUsu.getCve_usuario());
        }
		return respuesta;
	}
	
	private static File validaSiExisteArchivoTxtDelTicket(File archivoDeTicket, Usuario infoUsu, String folio)
	{
		try
		{
			if (!archivoDeTicket.exists()) 
				archivoDeTicket.createNewFile();
		}
		catch(Exception ex)
		{
			InsertarLogAlamacen.insertarLog(new LogAlmacen("","",""),infoUsu.getUname(),infoUsu.getUname_br(),"Error validaSiExisteArchivoTxtDelTicket, creacion de ticket. Folio: "+folio+" . DETALLE: "+Error(ex),infoUsu.getCve_usuario());
		}
		return archivoDeTicket;
	}
		
	private String  creaCuerpoDelArchivoTxtDelTicket(File archivoDeTicket,List<PedidosConsulta> p,String fecha_hora,  String rutaNombreArchivo,String folio,String usuario,String impresora,String chofer,String uname, String cdo_nombre, String nombre_chofer, String pedidos, String tipo, String tipoEnc, Usuario infoUsu, String rutas)
	{
		String respuesta = "NO SE PUDO IMPRIMIR";
		try
		{
			FileWriter fw = new FileWriter(archivoDeTicket);
	        BufferedWriter bw = new BufferedWriter(fw);
	        bw = crearSeccionDatosEmpresaParaTicket(bw,p,fecha_hora,folio,chofer,uname,cdo_nombre,nombre_chofer,pedidos,tipo,tipoEnc,infoUsu,rutas);
	        bw.close();
	       
	        respuesta = imprimirTicket(rutaNombreArchivo,usuario,p,folio,impresora,usuario,chofer,tipo,infoUsu);
		}
		catch(Exception ex)
		{
			InsertarLogAlamacen.insertarLog(new LogAlmacen("","",""),infoUsu.getUname(),infoUsu.getUname_br(),"Error en crear cuerpo del ticket, creacion de ticket. Folio: "+folio+" . DETALLE: "+Error(ex),infoUsu.getCve_usuario());
		}
		return respuesta;
	}
	
	public static BufferedWriter crearSeccionDatosEmpresaParaTicket(BufferedWriter bw,List<PedidosConsulta> p,String fecha_hora,String folio,String chofer, String uname, String cdo_nombre, String nombre_chofer, String pedidos, String tipo, String tipoEnc, Usuario infoUsu, String rutas)
	{
		try 
		{
			if (!pedidos.contains(","))
			{
				pedidos = pedidos+",";
			}

				List<String> datosLista = new ArrayList<String>();
				String[] fechaHora;
				fechaHora=fecha_hora.split(" ");
			
				String split [] = pedidos.split(",");
				double importe = 0.0;
				int doc = 0;
				int auxiliarTipo = 0;
				int auxiliarTipoCod = 0;
				for (PedidosConsulta d : p) 
				{
					if (d.getCondicion().equals("COD"))
					{
						auxiliarTipo = 1;
					}
					else
					{
						auxiliarTipoCod = 1;
					}
				}
				try
				{	
					bw.newLine();
					datosLista.add("************ ASIGNACION RUTAS ***************");
					bw.write("************ ASIGNACION RUTAS ***************");
					bw.newLine();
					datosLista.add("--------------------------------------------");
					bw.write("--------------------------------------------");
					bw.newLine();
					bw.write("       CENTRO DE DISTRIBUCION ORIENTE       ");
					bw.newLine();
					bw.write("                "+obtenerNombre(infoUsu.getUname_br()));
					bw.newLine();
					datosLista.add("********************************************");
					bw.write("********************************************");
					bw.newLine();
					datosLista.add("  "+String.format("%-32s", "FECHA:")+fechaHora[0]);
					bw.write("  "+String.format("%-32s", "FECHA:")+fechaHora[0]); 
					bw.newLine();
					datosLista.add("  "+String.format("%-34s", "HORA:")+fechaHora[1]);
					bw.write("  "+String.format("%-34s", "HORA:")+fechaHora[1]);
					bw.newLine();
					bw.newLine();
					datosLista.add("  FOLIO: "+folio+"      "+tipoEnc+": "+chofer);
					bw.write("  FOLIO: "+folio+"      "+tipoEnc+": "+chofer);
					bw.newLine();
					datosLista.add("  "+nombre_chofer);
					bw.write("  "+nombre_chofer);
					bw.newLine();
					
					if (rutas.length()>36)
					{
						int tot = rutas.length();
						int ant = 36;
						int dsp = 0;
						int aux = 0;
						for (int i = 0; i <= 80; i++) 
						{
							if (aux == 0)
							{
								bw.write("  RUTAS: "+rutas.substring(0,36));
							}
							else
							{
								
								bw.newLine();
								bw.write("         "+rutas.substring(ant,ant+36));
								ant = ant + 36;
							}
							if ((tot - 36) > 36 ) 
							{
								tot = tot - 36;
								
								aux = 1;
							}
							else
							{
								bw.newLine();
								bw.write("         "+rutas.substring(ant,rutas.length()));
								i = 80;
							}
						}
					}
					else
					{
						bw.write("  RUTAS: "+rutas);
					}
					bw.newLine();   
					datosLista.add("--------------------------------------------");
					bw.write("--------------------------------------------");
	
					if (auxiliarTipoCod == 1)
					{
						double importeCre = 0.0;
						int docCre = 0;
						bw.newLine();
						bw.newLine();
						datosLista.add("         ********  CREDITO  *********");
						bw.write("         ********  CREDITO  *********");
						bw.newLine();
						datosLista.add(" FECHA      CTE    PEDIDO DOCTO      IMPORTE  ");
						bw.write(" FECHA      CTE    PEDIDO DOCTO      IMPORTE  ");
						bw.newLine();
						datosLista.add("------------------------------------------------");
						bw.write("------------------------------------------------");
							      
						for (String s : split) 
						{
							for (PedidosConsulta d : p)
							{
								if (s.equals(d.getNo()))
								{
									if (!d.getCondicion().equals("COD")) 
									{
										bw.newLine();
										docCre++;
										doc++;
										String imp = formatearImporte(Double.parseDouble(d.getImporte()));
										imp = ponerCero(imp);
										importeCre = importeCre+Double.parseDouble(d.getImporte());
										importe = importe+Double.parseDouble(d.getImporte());
										String espacio = " ";
										if (d.getCondicion().equals("COD")) 
										{
											espacio = "*";
										}
										String espTer=" "+formatearFecha(d.getFecha_corta())+" "+String.format("%-7s", ""+d.getCte()+"")+ String.format("%-7s", ""+d.getPedido()+"")+String.format("%-"+((9)+(11-imp.length()))+"s", d.getFactura()+espacio)+imp;
										datosLista.add(espTer);
										bw.write(espTer);
										break;
									}
								}
							}
						}
						bw.newLine();
						bw.newLine();
						datosLista.add("  TOTAL DOCUMENTOS CREDITO:  "+docCre);
						bw.write("  TOTAL DOCUMENTOS CREDITO:  "+docCre);
						bw.newLine();
						
						datosLista.add("  TOTAL IMPORTE CREDITO:  "+ponerCero(formatearImporte(importeCre)));
						bw.write("  TOTAL IMPORTE CREDITO:  "+ponerCero(formatearImporte(importeCre)));
						bw.newLine();
						bw.newLine();
						bw.newLine();
						datosLista.add("  FIRMA CREDITO: _________________");
						bw.write("  FIRMA CREDITO: _________________");
						bw.newLine();
						datosLista.add("============================================");
						bw.write("============================================");
					}
					if (auxiliarTipo == 1) 
					{
					
						double importeCod = 0.0;
						int docCod = 0;
						bw.newLine();
						bw.newLine();
						datosLista.add("         ********  COD   *********");
						bw.write("         ********  COD   *********");
						bw.newLine();
						datosLista.add(" FECHA      CTE    PEDIDO DOCTO      IMPORTE  ");
						bw.write(" FECHA      CTE    PEDIDO DOCTO      IMPORTE  ");
						bw.newLine();
						datosLista.add("------------------------------------------------");
						bw.write("------------------------------------------------");
						for (String s : split) 
						{
							for (PedidosConsulta d : p)
							{
								if (s.equals(d.getNo()))
								{
									if (d.getCondicion().equals("COD")) 
									{
										bw.newLine();
										docCod++;
										doc++;
										String imp = formatearImporte(Double.parseDouble(d.getImporte()));
										imp = ponerCero(imp);
										importeCod = importeCod+Double.parseDouble(d.getImporte());
										importe = importe+Double.parseDouble(d.getImporte());
										String espacio = " ";
										if (d.getCondicion().equals("COD")) 
										{
											espacio = "*";
										}
										String espTer=" "+formatearFecha(d.getFecha_corta())+" "+String.format("%-7s", ""+d.getCte()+"")+ String.format("%-7s", ""+d.getPedido()+"")+String.format("%-"+((9)+(11-imp.length()))+"s", d.getFactura()+espacio)+imp;
										datosLista.add(espTer);
										bw.write(espTer);
										break;
									}
								}
							}
						}
						bw.newLine();
						bw.newLine();
						datosLista.add("  TOTAL DOCUMENTOS COD:  "+docCod);
						bw.write("  TOTAL DOCUMENTOS COD:  "+docCod);
						bw.newLine();
						datosLista.add("  TOTAL IMPORTE COD:  "+ponerCero(formatearImporte(importeCod)));
						bw.write("  TOTAL IMPORTE COD:  "+ponerCero(formatearImporte(importeCod)));
						bw.newLine();
						bw.newLine();
						bw.newLine();
						datosLista.add("  FIRMA CAJA: _________________");
						bw.write("  FIRMA CAJA: _________________");
						bw.newLine();
						datosLista.add("============================================");
						bw.write("============================================");
					}
					if (auxiliarTipo != 0 && auxiliarTipoCod != 0)
					{
						bw.newLine();
						bw.newLine();
						datosLista.add("  TOTAL DOCUMENTOS:  "+doc);
						bw.write("  TOTAL DOCUMENTOS:  "+doc);
						bw.newLine();
						datosLista.add("  TOTAL IMPORTE:  "+ponerCero(formatearImporte(importe)));
						bw.write("  TOTAL IMPORTE:  "+ponerCero(formatearImporte(importe)));	
						bw.newLine();
						datosLista.add("--------------------------------------------");
						bw.write("--------------------------------------------");
					}
					bw.newLine();
					bw.newLine();
					datosLista.add("  FIRMA ADMINISTRADOR: _________________");
					bw.write("  FIRMA ADMINISTRADOR: _________________");
					bw.newLine();
					bw.newLine();
					
					datosLista.add("  FIRMA CHOFER:        _________________");
					bw.write("  FIRMA CHOFER:        _________________");
					bw.newLine();
					bw.newLine();
					datosLista.add("********************************************");
					bw.write("********************************************");
					bw.newLine();
					datosLista.add("                  "+tipo);
					bw.write("                  "+tipo);
	
			}
			catch(Exception e)
			{
				InsertarLogAlamacen.insertarLog(new LogAlmacen("","",""),infoUsu.getUname(),infoUsu.getUname_br(),"Error al hacer el llenado del ticket. Folio: "+folio+" DETALLE: "+Error(e),infoUsu.getCve_usuario());
			}
		}
		catch (Exception e) 
		{
			InsertarLogAlamacen.insertarLog(new LogAlmacen("","",""),infoUsu.getUname(),infoUsu.getUname_br(),"Error en metodo para crear cuerpo de ticket. Folio: "+folio+" DETALLE: "+Error(e),infoUsu.getCve_usuario());
		}
		return bw;
	}
	private static String Error(Exception e) 
	{
		return e.toString().replace("'", "´");
	}
	 private static String ponerCero(String imp) 
	 {
		 imp = ponerDecimales(imp);
		 String splitIm[] = imp.split("\\.");
			if (splitIm[1].length() == 1) 
			{
				imp = splitIm[0]+"."+splitIm[1]+"0";
			}
			return imp;
	}

	private static String ponerDecimales(String imp) 
	{
		if (!imp.contains(".")) 
		{
			imp = imp+".00";
		}
		return imp;
	}

	private static String formatearImporte(Double importe) 
	 {
		
		String rsp = "";
		DecimalFormat formateador = new DecimalFormat("###,###.##");
		rsp = formateador.format (importe);
		rsp = ponerDecimales(rsp);
		return rsp;
	 }

	private static String formatearFecha(String fecha_corta) 
	 {
		fecha_corta = fecha_corta.replace("-", "/"); 
		String fecha [] = fecha_corta.split("/");
		fecha_corta = fecha[2]+"/"+fecha[1]+"/"+fecha[0];
		return fecha_corta;
	}

	public String imprimirTicket(String rutaNombreArchivo,String usuario,List <PedidosConsulta> LstDatosOrden,String folio,String impresora,String usu,String chofer, String tipo, Usuario infoUsu)
	{
		 String respuesta = "NO SE PUDO IMPRIMIR";
	    try
	    {            
	    	String[] comandoImprimir = {"sh","-c","cat " +rutaNombreArchivo+ " | lp -s -o cpi=17 -o lpi=6.5 -d"+impresora};
	    	final Process procesoImprimir = Runtime.getRuntime().exec(comandoImprimir);
	    	String[] commandEliminarArchivo = {"sh","-c","rm " +rutaNombreArchivo};
	    	final Process processEliminar = Runtime.getRuntime().exec(commandEliminarArchivo);
			respuesta = "SE HA MANDADO A IMPRIMIR CORRECTAMENTE";
	    } 
	    catch (Throwable t)
	    {
	    	InsertarLogAlamacen.insertarLog(new LogAlmacen("","",""),infoUsu.getUname(),infoUsu.getUname_br(),"Error en imprimir Ticket imprimirTicket. Folio: "+folio+" . DETALLE: "+t,infoUsu.getCve_usuario());
	      t.printStackTrace();
	    }
	    return respuesta;
	}

	 
	 
	 
	private static String obtenerNombre(String uname_br) 
	{
		switch (uname_br) 
		{
		case "cdf":
			uname_br = "CDO CDMX";
			break;
		case "cd2":
			uname_br = "CDO PUEBLA";
			break;
		case "cdl":
			uname_br = "CDO LEON";
			break;
		case "cdm":
			uname_br = "CDO MONTERREY";
			break;
		case "ac2":
			uname_br = "REGIONAL ACAPULCO";
			break;
		case "cto":
			uname_br = "REGIONAL TOLUCA";
			break;
		case "gdl":
			uname_br = "REGIONAL GUDADALAJARA";
			break;
		case "que":
			uname_br = "REGIONAL QUERETARO";
			break;
		case "mor":
			uname_br = "REGIONAL MORELOS";
			break;
		case "pc2":
			uname_br = "REGIONAL PACHUCA";
			break;
		case "tug":
			uname_br = "REGIONAL TUXTLA";
			break;
		case "oa2":
			uname_br = "REGIONAL OAXACA";
			break;
		case "za2":
			uname_br = "REGIONAL ZAMORA";
			break;
		case "slp":
			uname_br = "REGIONAL SAN LUIS";
			break;
		case "dur":
			uname_br = "REGIONAL DURANGO";
			break;

		
		}
		return uname_br;
	}
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
}
