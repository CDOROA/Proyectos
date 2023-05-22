package cdo.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.sql.Date;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import cdo.Datos.Ingresos;
import cdo.Datos.Usuario;

public class Cls_CrearTicketDeIngresos {
	
	DecimalFormat formatoDecimal = new DecimalFormat("#,###.00");
	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");  
	DateTimeFormatter df = DateTimeFormatter.ofPattern("dd/MM/yyyy"); 
	
	public void crearArchivoTxtDelTicket(Usuario infoUsu, Ingresos ICapturado, int tipo, boolean aplicacomision, String impresora)
	{
		LocalDateTime now = LocalDateTime.now(); 
		try
		{
			/* Ticket CAJA */			
		    String rutaNombreArchivo1 = "/tmp/" + "Ticket_" + ICapturado.getFolio_caja() + "TP" + ICapturado.getId_tipo_pago() +  dtf.format(now).replace(" ", "").replace("/", "").replace(":", "")+ "_CA.txt";
			File archivoDeTicket = new File(rutaNombreArchivo1);
            archivoDeTicket = validaSiExisteArchivoTxtDelTicket(archivoDeTicket);
            creaCuerpoDelArchivoTxtDelTicket(archivoDeTicket, infoUsu,ICapturado, dtf.format(now), rutaNombreArchivo1, tipo,aplicacomision, impresora, "Caja Administrativa");
           
            /* Ticket CREDITO */
            String rutaNombreArchivo2 = "/tmp/" + "Ticket_" + ICapturado.getFolio_caja() + "TP" + ICapturado.getId_tipo_pago() +  dtf.format(now).replace(" ", "").replace("/", "").replace(":", "")+ "_CR.txt";
			            
            if(infoUsu.getUname().equals(infoUsu.getUname_br()))
            {
            	archivoDeTicket = new File(rutaNombreArchivo2);
                archivoDeTicket = validaSiExisteArchivoTxtDelTicket(archivoDeTicket);
                creaCuerpoDelArchivoTxtDelTicket(archivoDeTicket, infoUsu,ICapturado, dtf.format(now), rutaNombreArchivo2, tipo,aplicacomision, impresora, "Credito y Cobranza");                
            }
            
            /* Ticket USUARIO */
            String rutaNombreArchivo3 = "/tmp/" + "Ticket_" + ICapturado.getFolio_caja() + "TP" + ICapturado.getId_tipo_pago() +  dtf.format(now).replace(" ", "").replace("/", "").replace(":", "")+ "_US.txt";
			archivoDeTicket = new File(rutaNombreArchivo3);
            archivoDeTicket = validaSiExisteArchivoTxtDelTicket(archivoDeTicket);
            creaCuerpoDelArchivoTxtDelTicket(archivoDeTicket, infoUsu,ICapturado, dtf.format(now), rutaNombreArchivo3, tipo,aplicacomision, impresora, generaLeyendaDeUsuario(ICapturado.getId_tipo_pago()).replace(":", ""));
                       
            eliminarTicket(rutaNombreArchivo1, impresora);
            eliminarTicket(rutaNombreArchivo2, impresora);
            eliminarTicket(rutaNombreArchivo3, impresora);
            
        } 
		catch (Exception e)
		{
            e.printStackTrace();
        }
	}
	
	private File validaSiExisteArchivoTxtDelTicket(File archivoDeTicket)
	{
		try
		{
			if (!archivoDeTicket.exists()) 
				archivoDeTicket.createNewFile();
		}
		catch(Exception ex)
		{
			System.out.println("Error al crear el archivo de tickets");
		}
		return archivoDeTicket;
	}
		
	private void creaCuerpoDelArchivoTxtDelTicket(File archivoDeTicket, Usuario infoUsu, Ingresos ICapturado, String fecha_hora,  String rutaNombreArchivo, int tipo, boolean aplicacomision, String impresora, String DestinatarioTicket)
	{
		try
		{
				FileWriter fw = new FileWriter(archivoDeTicket);
		        BufferedWriter bw = new BufferedWriter(fw);
		        bw = crearSeccionDatosEmpresa(bw, infoUsu, tipo);
		        bw = crearSeccionEncabezado(bw, ICapturado, fecha_hora,infoUsu, DestinatarioTicket);
		        bw = crearSeccionDetalleXFactura(bw, ICapturado,infoUsu, aplicacomision);
		        bw = crearSeccionTotalesParaTicket(bw, ICapturado, infoUsu, aplicacomision);
		        bw = crearSeccionDetalleXFormaPago(bw, ICapturado,infoUsu, aplicacomision);
		        bw = crearSeccionObservacionesAdicionales(bw, ICapturado);
		        bw = crearSeccionPieDePagina(bw, DestinatarioTicket);
		        bw.close();		
	        	imprimirTicket(rutaNombreArchivo, impresora);
		}
		catch(Exception ex)
		{
			System.out.println("Error al crear el cuerpo de archivo del ticket");
		}
	}
	
	/*** TITULO DEL TICKET ***/
	public BufferedWriter crearSeccionDatosEmpresa(BufferedWriter bw, Usuario infoUsu, int tipo)
	{
		try
		{
			if(tipo >= 1)
			{
				bw.write("*********** REIMPRESION DE TICKET **********");				
				bw.newLine();
			}
			
			bw.write("............................................");
			bw.newLine();
			bw.write("                  INGRESOS                  ");
			bw.newLine();
			bw.write("       CENTRO DE DISTRIBUCION ORIENTE       "); 
			bw.newLine();
			int longitud= (44 - infoUsu.getUname_br_nombre().length()) /2;
			bw.write(darFormatoConEspaciosAlosLados(infoUsu.getUname_br_nombre(),longitud, longitud));
			bw.newLine();
			bw.write("............................................");
		}
		catch(Exception ex)
		{
			System.out.println("Error al crear encabezado de ticket.");
		}
		return bw;
	}

	/*** ENCABEZADO DEL TICKET ***/
	private BufferedWriter crearSeccionEncabezado(BufferedWriter bw, Ingresos ICapturado, String fecha_hora, Usuario infoUsu, String DestinatarioTicket)
	{
		try
		{
			bw.newLine();
			String tipoPago=generaLeyendaDeTipoPago(ICapturado.getId_tipo_pago());
			int longitud= (44 - tipoPago.length()) /2;
			bw.write(darFormatoConEspaciosAlosLados(tipoPago,longitud, longitud));
			bw.newLine();
			
			String fechaPol[]= ICapturado.getFecha_poliza().split("-");
			LocalDateTime nowPol = LocalDateTime.of(Integer.parseInt(fechaPol[0]), Integer.parseInt(fechaPol[1]),Integer.parseInt(fechaPol[2]), 0, 0);
			
			if(!String.valueOf(ICapturado.getId_tipo_pago()).equals("3"))
			{
				bw.newLine();
				bw.write(darFormatoConEspaciosDerecha("Fecha Poliza: " , 22)+ darFormatoConEspaciosIzquierda(df.format(nowPol),22));
			}
			else
			{
				if(!DestinatarioTicket.equals("Cliente"))
				{
					bw.newLine();
					bw.write(darFormatoConEspaciosDerecha("Fecha Poliza: " , 22)+ darFormatoConEspaciosIzquierda(df.format(nowPol),22));
				}
			}
			
			bw.newLine();
			bw.write(darFormatoConEspaciosDerecha("Fecha/Hora: " , 22)+
					 darFormatoConEspaciosIzquierda(fecha_hora,22));
			bw.newLine();
			
			bw.write(darFormatoConEspaciosDerecha("Folio: " , 22)+
					 darFormatoConEspaciosIzquierda(ICapturado.getFolio_caja(),22));
			bw.newLine();
			
			if(String.valueOf(ICapturado.getId_tipo_pago()).equals("5"))
			{
				bw.write(darFormatoConEspaciosDerecha("Factura: " , 22)+
						 darFormatoConEspaciosIzquierda(ICapturado.getFactura(),22));
				bw.newLine();
			}
			
			String claveUsu= (ICapturado.getCve_usu().equals("undefined")) ? " " : ICapturado.getCve_usu();
			String nombre = (ICapturado.getNombre_usu().trim().length() >= 29) ? ICapturado.getNombre_usu().trim().substring(0,29): ICapturado.getNombre_usu().trim();
			String  etiquetaUsu=generaLeyendaDeUsuario(ICapturado.getId_tipo_pago());
			bw.write(darFormatoConEspaciosDerecha(etiquetaUsu , 8)+
					 darFormatoConEspaciosIzquierda(claveUsu + "-"+  nombre,36));
			bw.newLine();
						
			String recibe = (infoUsu.getNombre().trim().length()>= 29) ? infoUsu.getNombre().trim().substring(0,29): infoUsu.getNombre().trim();
			bw.write(darFormatoConEspaciosDerecha("Recibe: " , 8)+
					 darFormatoConEspaciosIzquierda(infoUsu.getCve_usuario() +"-"+ recibe ,36));
			bw.newLine();
			
		}
		catch(Exception ex)
		{
			System.out.println("Error al crear encabezado del ticket. Detalle: " + ex.getMessage().toString());
		}
		return bw;
	}
	
	private String generaLeyendaDeUsuario(int tipo_pago)
	{
		switch(tipo_pago)
		{
			case 1:
				return "AV/ECC:";
				
			case 2:
				return "Chofer:";
				
			case 3:
				return "Cliente:";
				
			case 4:
				return "Usuario:";
			
			case 5:
				return "Usuario:";
				
			case 7:
				return "Chofer:";
		}
		return "";
	}
	
	private String generaLeyendaDeTipoPago(int tipo_pago)
	{
		switch(tipo_pago)
		{
			case 1:
				return "Cobranza";
				
			case 2:
				return "Hoja De Ruta";
				
			case 3:
				return "Pago De Contado";
				
			case 4:
				return "Otros Ingresos";
				
			case 5:
				return "Factura Credito";
				
			case 7:
				return "Folio Hoja De Ruta";
		}
		return "";
	}
		
	private BufferedWriter crearSeccionDetalleXFactura(BufferedWriter bw, Ingresos ICapturado, Usuario infoUsu,  boolean aplicacomision)
	{
		try
		{
			bw.newLine();
			bw.write("============================================");
			bw.newLine();
			bw.write("         DOCUMENTO          IMPORTE        ");
			bw.newLine();
			bw.write("============================================");
			bw.newLine();
			
			
			if(!String.valueOf(ICapturado.getId_tipo_pago()).equals("5"))
			{
				if(!ICapturado.getFactura().equals(""))
				{
					String []Arrayfacturas= ICapturado.getFactura().split(",");	
					for(int i = 0; i< Arrayfacturas.length; i++)
					{
						String []Factura = Arrayfacturas[i].split("/");
						bw.write(darFormatoConEspaciosDerecha("FACTURA:" + Factura[0], 22)+
								 darFormatoConEspaciosIzquierda( "$" + formatoDecimal.format( Double.parseDouble(Factura[1]) ),22));
						bw.newLine();
					}	
				}
				else
				{
					bw.write(darFormatoConEspaciosDerecha("FACTURA(S):" , 11)+
							 darFormatoConEspaciosIzquierda("$" +  formatoDecimal.format( Double.parseDouble(ICapturado.getImporte_original() )),33));
					bw.newLine();
				}
			}
			else
			{
				bw.write(darFormatoConEspaciosDerecha("FACTURA(S):" , 11)+
						 darFormatoConEspaciosIzquierda("$" +  formatoDecimal.format( Double.parseDouble(ICapturado.getImporte_original() )),33));
				bw.newLine();
			}
			
			if(aplicacomision)
			{
				double comision = ((Double.parseDouble(ICapturado.getTarjeta().replace(",", "")) + Double.parseDouble(ICapturado.getDebito().replace(",", "")))  * Integer.parseInt(infoUsu.getDato_alfanumerico())) / 100;
				bw.write(crearFilaPorFormaPago("GASTOS ADMINISTRATIVOS", formatoDecimal.format(comision)));
				bw.newLine();
			}
						
			if(!ICapturado.getNotaCredito().equals(".00") || !ICapturado.getNotaDevolucion().equals(".00")) 
			{
				double ImpNotas = Double.parseDouble(ICapturado.getNotaCredito()) + Double.parseDouble(ICapturado.getNotaDevolucion());
				bw.write(crearFilaPorFormaPago("NOTA DE CREDITO", formatoDecimal.format(ImpNotas)));
				bw.newLine();
			}			
		}
		catch (Exception e) 
		{
			System.out.println("Error al crear detalle por factura del ticket. Detalle: " + e.getMessage().toString());
		}
		return bw;
	}
		
	/*** TOTALES ***/
	private BufferedWriter crearSeccionTotalesParaTicket(BufferedWriter bw, Ingresos ICapturado,Usuario infoUsu,  boolean aplicacomision)
	{
		String importe = ICapturado.getImporte().replace(",", "");
		
		try
		{
			if(aplicacomision)
			{
				double comision = ((Double.parseDouble(ICapturado.getTarjeta().replace(",", "")) + Double.parseDouble(ICapturado.getDebito().replace(",", "")))  * Integer.parseInt(infoUsu.getDato_alfanumerico())) / 100;
				double importeDecimal= Double.parseDouble(ICapturado.getImporte().replace(",", ""));
				importe = String.valueOf(importeDecimal + comision);
			}		
		
			bw.write("============================================");
			bw.newLine();
			bw.write(darFormatoConEspaciosDerecha("IMPORTE TOTAL: " ,22)+
					 darFormatoConEspaciosIzquierda("$" + formatoDecimal.format(Double.parseDouble(importe)),22 )); 
			bw.newLine();
		}
		catch(Exception ex)
		{
			System.out.println("Error al crear totales del ticket. Detalle: " + ex.getMessage().toString());
		}
		return bw;
	}
	
	/*** DETALLE POR FORMA DE PAGO DEL TICKET ***/
	private BufferedWriter crearSeccionDetalleXFormaPago(BufferedWriter bw, Ingresos ICapturado, Usuario infoUsu, boolean aplicacomision)
	{
		try
		{
			bw.newLine();
			bw.newLine();
			bw.write("--------------------------------------------");
			bw.newLine();
			bw.write("        Forma De Pago        Importe        "); 
			bw.newLine();
			bw.write("--------------------------------------------");
			bw.newLine();
			
			if(!ICapturado.getEfectivo().equals(".00")) {
				bw.write(crearFilaPorFormaPago("EFECTIVO", formatoDecimal.format( Double.parseDouble(ICapturado.getEfectivo().replace(",", "")) )));
				bw.newLine();
			}
						
			if(!ICapturado.getCheque().equals(".00")) {
				bw.write(crearFilaPorFormaPago("CHEQUE NOMINATIVO", formatoDecimal.format( Double.parseDouble(ICapturado.getCheque().replace(",", "")))));
				bw.newLine();
			}
			
			if(!ICapturado.getPorfechado().equals(".00")) {
				bw.write(crearFilaPorFormaPago("POSFECHADO", formatoDecimal.format( Double.parseDouble(ICapturado.getPorfechado().replace(",", "")))));
				bw.newLine();
			}
			
			if(!ICapturado.getTarjeta().equals(".00")) {
				bw.write(crearFilaPorFormaPago("TARJETA DE CREDITO", formatoDecimal.format( Double.parseDouble(ICapturado.getTarjeta().replace(",", "")))));
				bw.newLine();
			}
			
			if(!ICapturado.getDebito().equals(".00")) {
				bw.write(crearFilaPorFormaPago("TARJETA DE DEBITO", formatoDecimal.format( Double.parseDouble(ICapturado.getDebito().replace(",", "")))));
				bw.newLine();
			}
			
			if(!ICapturado.getTransferencia().equals(".00")) 
			{
				bw.write(crearFilaPorFormaPago("TRANSFERENCIA", formatoDecimal.format( Double.parseDouble(ICapturado.getTransferencia().replace(",", "")))));
				bw.newLine();
			}	
			
			if(aplicacomision)
			{
				double comision = ((Double.parseDouble(ICapturado.getTarjeta().replace(",", "")) + Double.parseDouble(ICapturado.getDebito().replace(",", "")))  * Integer.parseInt(infoUsu.getDato_alfanumerico())) / 100;
				bw.write(crearFilaPorFormaPago("GASTOS ADMINISTRATIVOS", formatoDecimal.format(comision)));
				bw.newLine();
			}
			
		}
		catch(Exception ex)
		{
			System.out.println("Error al crear detalles del ticket. " + ex.getMessage().toString());
		}
		return bw;
	}
		
	
	/*** OBSERVACIONES ADICIONALES  ***/
	private BufferedWriter crearSeccionObservacionesAdicionales(BufferedWriter bw, Ingresos ICapturado)
	{
		try
		{
			/*** Nota De Devolucion - Nota De Credito ***/
			ObservacionesNotasDeCredito(bw, ICapturado);
			bw.newLine();
			bw.write(" ");
			bw.newLine();
			bw.write("............................................");
		}
		catch(Exception ex)
		{
			System.out.println("Error al crear totales de nota  del ticket. Detalle: " + ex.getMessage().toString());
		}
		return bw;
	}
	
	
	/***  OBSERVACIONES DE NOTA DE CREDITO  ***/
	private void ObservacionesNotasDeCredito(BufferedWriter bw, Ingresos ICapturado)
	{
		try
		{
			if(!ICapturado.getNotaCredito().equals(".00") ||!ICapturado.getNotaDevolucion().equals(".00")) 
			{
				String mensaje = "Se aplico";
				if(!ICapturado.getNotaCredito().equals(".00"))
					mensaje += " un descuento y";
				if(!ICapturado.getNotaDevolucion().equals(".00"))
					mensaje += " una devolucion";
				else
					mensaje = mensaje.substring(0,mensaje.length() -1);
								
				bw.newLine();
				int longitud= (44 - mensaje.length()) /2;
				bw.write(darFormatoConEspaciosAlosLados(mensaje, longitud, longitud));
				bw.newLine();
				longitud= (44 - "por saldo a favor".length()) /2;
				bw.write(darFormatoConEspaciosAlosLados("por saldo a favor", longitud, longitud));
				bw.newLine();
			}
		}
		catch(Exception ex)
		{
			System.out.println("Error al crear seccion de notas en el ticket.");
		}
	}
	
	
	/*** PIE DE PAGINA ***/
	private BufferedWriter crearSeccionPieDePagina(BufferedWriter bw, String DestinatarioTicket)
	{
		try
		{
			bw.newLine();
			bw.write(" ");
			String linea="_______________________";
			int longitud= (44 - DestinatarioTicket.length()) /2;
			bw.newLine();
			bw.write(darFormatoConEspaciosAlosLados(DestinatarioTicket,longitud, longitud));			
			bw.newLine();
			bw.write(" ");
			bw.newLine();
			longitud= (44 - linea.length()) /2;
			bw.write(darFormatoConEspaciosAlosLados(linea,longitud, longitud));
			bw.newLine();
			bw.write(" ");
		}
		catch(Exception ex)
		{
			System.out.println("Error al crear totales de nota  del ticket. Detalle: " + ex.getMessage().toString());
		}
		return bw;
	}
	
	private String crearFilaPorFormaPago(String formaPago, String importe)
	{
		String fila = darFormatoConEspaciosDerecha(formaPago,22) +
				     darFormatoConEspaciosIzquierda("$" + importe,22);
		return fila;
	}
	
	private String darFormatoConEspaciosIzquierda(String texto, int longitud)
	{
		 if (texto.length() >= longitud)
		        return texto;
		 
		 StringBuilder sb = new StringBuilder();
		 while (sb.length() < longitud - texto.length()) 
		      sb.append(" ");
		 
		 sb.append(texto);
		 
		 return sb.toString();
	}

	private String darFormatoConEspaciosDerecha(String texto, int longitud)
	{
		 if (texto.length() >= longitud)
		        return texto;
		 
		 StringBuilder sb = new StringBuilder();
		 sb.append(texto);
		 
		 while (sb.length() < longitud) 
		      sb.append(" ");
		 
		 return sb.toString();
	}

	private String darFormatoConEspaciosAlosLados(String texto, int longitudIzq, int logitudDer)
	{
		 if (texto.length() >= 44)
		        return texto;
		 
		 StringBuilder sb = new StringBuilder();
		 while (sb.length() < longitudIzq) 
		      sb.append(" ");

		 sb.append(texto);
		 
		 while (sb.length() < logitudDer) 
		      sb.append(" ");
		 
		 return sb.toString();
	}
	
	public static void imprimirTicket(String rutaNombreArchivo, String impresora)
	{
	    try
	    {     
	    	String[] comandoImprimir = {"sh","-c","cat " +rutaNombreArchivo+ " | lp -s -o cpi=17 -o lpi=6.5 -d" + impresora};
	    	Process procesoImprimir = Runtime.getRuntime().exec(comandoImprimir);
	    } 
	    catch (Throwable t)
	    {
	    	System.out.println("ERROR AL IMPRIMIR TICKET ");
	    	t.printStackTrace();
	    }
	}
	
	public static void eliminarTicket(String rutaNombreArchivo, String impresora)
	{
	    try
	    { 
	    	String[] commandEliminarArchivo = {"sh","-c","rm " +rutaNombreArchivo};
	    	final Process processEliminar = Runtime.getRuntime().exec(commandEliminarArchivo);
	    } 
	    catch (Throwable t)
	    {
	    	System.out.println("ERROR AL ELIMINAR TICKET");
	      t.printStackTrace();
	    }
	}
	

}
