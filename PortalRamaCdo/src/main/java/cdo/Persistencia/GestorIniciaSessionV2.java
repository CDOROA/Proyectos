package cdo.Persistencia;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Properties;

 
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.json.JSONArray;
import org.json.JSONObject;
 
import cdo.Datos.Armandoras;
import cdo.Datos.CdosTraspasosEmergencia;
import cdo.Datos.Cilindros;
import cdo.Datos.Consignatarios;
import cdo.Datos.Distancia;
import cdo.Datos.EjecDemonios;
import cdo.Datos.EstadoDeCuentaPedidosDelDia;
import cdo.Datos.Grupos;
import cdo.Datos.InfoCliente;
import cdo.Datos.InformacionInicial;
import cdo.Datos.InformacionInicialCarrito;
import cdo.Datos.LineasDescuentoFijo;
import cdo.Datos.Litros;
import cdo.Datos.Log;
import cdo.Datos.Marcas;
import cdo.Datos.MarcasDeCalidad;
import cdo.Datos.Querys;
import cdo.Datos.Transportes;
import cdo.Util.Cls_Log;
import cdo.Util.Cls_MetodosGlobales;
import cdo.Util.Cls_Querys;
import cdo.Util.ConexionBD;
import cdo.Util.EjecutaQuerysBD;


public class GestorIniciaSessionV2 extends HttpServlet{
	 private static final long serialVersionUID = 1L;
	 private Client cliente = null;
	 DecimalFormat formatoDecimal = new DecimalFormat("#,###.00");
	 private  static Properties properties = null;
	 private  static Properties propertiesWs = null;
 
	 
	 static 
	 {
	      try  
	      {
		      properties = new Properties();
		      InputStream  inputStream  = GestorIniciaSessionV2.class.getClassLoader().getResourceAsStream("/properties/mail.properties");
		      properties.load(inputStream);
		      
		      propertiesWs = new Properties();
		      InputStream  inputStreamWs  = GestorIniciaSessionV2.class.getClassLoader().getResourceAsStream("/properties/configuracion.properties");
		      propertiesWs.load(inputStreamWs);
	      }
	      catch  (Exception ex) 
	      {
	        ex.printStackTrace();
	      }
	 }	
	 
	 @Override
	 public void init() throws ServletException {
	   	super.init();
	   	this.cliente = ClientBuilder.newClient();
	 }
	     
	 @Override
	 public void destroy() {
			this.cliente.close();
			super.destroy();
	 }
	 
	 
	/**** VALIDA ACCESO AL CARRITO DE COMPRAS ****/
	public String validaInicioDeSession(String usuario, String password, List<Querys> ListaQuerys)
	{
		//System.out.println("validaInicioDeSession...1");
		String respuestaAcceso="Los Datos Ingresados no son correctos.";
		String empresa_cte = usuario.substring((usuario.length() - 2), usuario.length());
		String num_cte = usuario.substring(0,(usuario.length()-2));
		//System.out.println("validaInicioDeSession...6");
		try
		{
			//System.out.println("validaInicioDeSession...3");
			respuestaAcceso = validaNumeroClienteYContrasena(empresa_cte, num_cte, password,ListaQuerys);				
			Log log=new Log(0, Integer.parseInt(empresa_cte),Integer.parseInt(num_cte) ,0, "[Accion: Valida inicio de session , Respuesta:  " + respuestaAcceso +" ]");
			Cls_Log.insertaLog(log);			
			//System.out.println("validaInicioDeSession...4");
		}
		catch(Exception ex)
		{
			System.out.println("[NuevoportalRamaCDO.- Error: Iniciar session,  Clase: GestorIniciaSessionv2,  Detalle: " + ex.getMessage().toString() +"]"); 
			Log log=new Log(0,Integer.parseInt(empresa_cte),Integer.parseInt(num_cte) ,0, "[Error: Iniciar session,  Clase: GestorIniciaSessionV2,  Detalle: " + ex.getMessage().toString() +"]");
			Cls_Log.insertaLog(log);
		}		
		return respuestaAcceso;
	}
	
	private String validaNumeroClienteYContrasena(String empresa_cte, String num_cte, String password, List<Querys> ListaQuerys)
	{
		String respuestaAcceso="Los Datos Ingresados no son correctos.";
		Connection connBD = null;
		PreparedStatement pstm= null;
		connBD = ConexionBD.abrirConexionBD();		
		try
		{			
			String[] querys = new String[25];	
			querys = Cls_Querys.LimpiaListaQuerys(querys);	
			querys = Cls_Querys.ObtieneQuerys(1, ListaQuerys, querys);
			querys = inicializaQueryNumero_1_2_3(querys,empresa_cte,num_cte, password,"");

			pstm = connBD.prepareStatement("{call " + "comercio_electronico.usp_EXECUTE_QUERY(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			ResultSet rs=  EjecutaQuerysBD.EjecutarQuery(querys[0], querys[1],querys[2], querys[3], querys[4], querys[5], querys[6],
														 querys[7], querys[8], querys[9],querys[10], querys[11], querys[12], querys[13], 
														 querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], 
														 querys[21], querys[22], querys[23], querys[24], "",pstm, connBD);
		

			Cls_Querys.ImprimeQuerysConsola(querys,false,"query 1");
			
			if (rs != null)
	        {
		        while (rs.next())
		        {
		        	if(rs.getString("dato").equals("CTE_EXISTE"))
		        	{
		        		if(rs.getString("valor").equals("0"))
		        		{
		        			respuestaAcceso="El usuario ingresado no existe.";
		        			break;
		        		}
		        	}
		        	else if(rs.getString("dato").equals("PSW_CADUCO"))
		        	{
		        		 if(!calcularFechaExpiraContrasena(rs.getDate("valor")))
		        		 {
		        			 respuestaAcceso="Su contraseña cadudo, por favor generarla nuevamente.";
		        			 break;
		        		 }
		        	}
		        	else if(rs.getString("dato").equals("USU_CORRECTO"))
		        	{
		        		 //if(rs.getInt("valor") > 0)
		        		 //{
		        			 respuestaAcceso="DatosCorrectos";
		        			 break;
		        		 //}
		        	}
		        }
	        }
			
			Log log=new Log(0, Integer.parseInt(empresa_cte),Integer.parseInt(num_cte) ,0, "[Accion: Valida cliente y contrasena , Respuesta:  " + respuestaAcceso +" ]");
			Cls_Log.insertaLog(log);
			
		}
		catch(Exception ex)
		{
			System.out.println("[NuevoportalRamaCDO.- Error: Validar credenciales de cliente y contrasena,  Clase: GestorIniciaSessionV2,  Detalle: " + ex.getMessage().toString() +"]"); 
			Log log=new Log(0,Integer.parseInt(empresa_cte),Integer.parseInt(num_cte) ,0, "[Error: Validar credenciales de cliente y contrasena,  Clase: GestorIniciaSessionV2,  Detalle: " + ex.getMessage().toString() +"]");
			Cls_Log.insertaLog(log);
		}
		finally 
		{
			try {pstm.close();} catch (SQLException e) {e.printStackTrace();}
			try {connBD.close();} catch (SQLException e) {e.printStackTrace();}
		}
		return respuestaAcceso;
	}
	
	private boolean calcularFechaExpiraContrasena(Date fechaContrasena) 
	{		
		boolean contrasenaValida;
		Date fechaActual = new Date();
		long diferencia = ( fechaActual.getTime() - fechaContrasena.getTime());
		long diffDays = diferencia / (24 * 60 * 60 * 1000); 
		 
		if (diffDays >= 60)
		{
			contrasenaValida= false;
		}
		else
		{
			contrasenaValida= true;
		}	
	 
		return contrasenaValida;
	}

	/**** CONSULTA INICIAL DE INFORMACION DEL CLIENTE ****/
	public InformacionInicialCarrito consultaInformacionInicialDelCliente(List<Querys> listaQuerys, String usuario)
	{
		String empresa_cte = usuario.substring((usuario.length() - 2), usuario.length());
		String num_cte = usuario.substring(0,(usuario.length()-2));	
		String uname_cte="";
		
		Connection connBD = null;
		PreparedStatement pstm = null;
		connBD = ConexionBD.abrirConexionBD();
		InformacionInicialCarrito infoInicialCarrito = new InformacionInicialCarrito();	
		
		try 
		{
			String [] querys = new String [25];
			querys = Cls_Querys.LimpiaListaQuerys(querys);
			querys = Cls_Querys.ObtieneQuerys(15, listaQuerys, querys);
			querys= inicializaQueryNumero15(querys,empresa_cte,num_cte);
			pstm = connBD.prepareStatement("{call " + "comercio_electronico.usp_EXECUTE_QUERY(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			ResultSet rs2 = EjecutaQuerysBD.EjecutarQuery(querys[0], querys[1],querys[2], querys[3], querys[4], querys[5], querys[6],
					 querys[7], querys[8], querys[9],querys[10], querys[11], querys[12], querys[13], 
					 querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], 
					 querys[21], querys[22], querys[23], querys[24], "",pstm, connBD);
			
			Cls_Querys.ImprimeQuerysConsola(querys,false,"query 15");
			
			
			if(rs2 != null)
			{
				 while(rs2.next())
				 {
					 uname_cte= rs2.getString("nom_empresa").toString().toLowerCase();
					 break;
				 }
			}
			
			querys = Cls_Querys.LimpiaListaQuerys(querys);
			querys = Cls_Querys.ObtieneQuerys(11, listaQuerys, querys);
			querys= inicializaQueryNumero11(querys,uname_cte,num_cte,empresa_cte);
			pstm = connBD.prepareStatement("{call " + "comercio_electronico.usp_EXECUTE_QUERY(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			
			
			Cls_Querys.ImprimeQuerysConsola(querys,false,"Queri 11");
			
			ResultSet rs = EjecutaQuerysBD.EjecutarQuery(querys[0], querys[1],querys[2], querys[3], querys[4], querys[5], querys[6],
					 querys[7], querys[8], querys[9],querys[10], querys[11], querys[12], querys[13], 
					 querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], 
					 querys[21], querys[22], querys[23], querys[24], "",pstm, connBD);
		
			if(rs != null)
			{
				infoInicialCarrito.setInfocliente(llenaClaseInfoCliente(rs, listaQuerys));
				infoInicialCarrito.setListaMarcas(llenaClaseMarcas(rs));
				infoInicialCarrito.setListaArmadoras(llenaClaseArmadoras(rs));
				infoInicialCarrito.setListaGrupos(llenaClaseGrupos(rs));
				infoInicialCarrito.setListaMarcasCalidad(llenarClaseMarcasDeCalidad(rs));
				infoInicialCarrito.setListaLineasDesFijo(llenaClaseLineasDescuentoFijo(rs));
				infoInicialCarrito.setListaCdosTraspaso(llenaClaseCdosConTraspasos(rs));
				infoInicialCarrito.setListaCilindros(llenaClaseCilindros(rs));
				infoInicialCarrito.setListaLitros(llenaClaseLitros(rs));
				infoInicialCarrito.setArticulosCarrito(llenarClaseArticulosEnCarrito(rs));
				infoInicialCarrito.setNumerpPedidoCarrito(llenarClasePedidoEnCarrito(rs));
				infoInicialCarrito.setListaDistancias(llenarClaseDistancia(rs));
			}
		
			
		}
		catch(Exception ex)
		{
			System.out.println("[NuevoportalRamaCDO.- Error: Consultar informacion inicial del cliente,  Clase: GestorIniciaSessionV2.InformacionInicialCarrito,  Detalle: " + ex.toString() +"]"); 
			//Log log=new Log(0,Integer.parseInt(empresa_cte),Integer.parseInt(num_cte) ,Integer.parseInt(infoInicialCarrito.getNumerpPedidoCarrito()), "[Error: Consultar informacion inicial del cliente,  Clase: GestorIniciaSessionInformacionInicialCarrito,  Detalle: " + ex.toString() +"]");
			//Cls_Log.insertaLog(log);
		}
		finally
		{
			try {connBD.close();} catch (SQLException e) {e.printStackTrace();}
			try {pstm.close();} catch (SQLException e) {e.printStackTrace();}
		}		
		return infoInicialCarrito;
	}
	
	private List<Distancia> llenarClaseDistancia(ResultSet rs)
	{
		List<Distancia> listaDistancias =new ArrayList<>();		
		try
		{
			rs.beforeFirst();
			while(rs.next())
			{
				if(rs.getString("distancias").equals("*"))
				{
					Distancia distancia  =  new Distancia();
					distancia.setUname(rs.getString("uname"));
					distancia.setTipo(rs.getString("tipo"));
					distancia.setDistancia(rs.getString("distancia"));
					distancia.setPorcManiobra(rs.getDouble("porc_maniobra"));
					distancia.setPorcSeguro(rs.getDouble("porc_seguro"));
					listaDistancias.add(distancia);
					//System.out.println("Distancia: " + distancia);
				}
			}
		}
		catch(Exception ex)
		{
			Distancia distancia  =  new Distancia();
			listaDistancias.add(distancia);
			 
		}		
		return listaDistancias;
	}
	
	
	private int llenarClaseArticulosEnCarrito(ResultSet rs)
	{
		int articulosenCarrito = 0;	
		try
		{
			rs.beforeFirst();
			while(rs.next())
			{
				if(rs.getString("info_carrito").equals("*"))
				{
					articulosenCarrito  = rs.getInt("art_en_carrito");
				}
			}
		}
		catch(Exception ex)
		{
			System.out.println("[NuevoportalRamaCDO.- Error: Llenar clase de articulos en carrito,  Clase: GestorIniciaSessionV2,  Detalle: " + ex.getMessage().toString() +"]"); 
			//Log log=new Log(0,0,0 ,0, "[Error: Llenar clase de articulos en carrito,  Clase: GestorIniciaSessionV2,  Detalle: " + ex.getMessage().toString() +"]");
			//Cls_Log.insertaLog(log);
		}		
		return articulosenCarrito;
	}
	
	private String llenarClasePedidoEnCarrito(ResultSet rs)
	{
		String pedido = "0";	
		try
		{
			rs.beforeFirst();
			while(rs.next())
			{
				if(rs.getString("info_carrito").equals("*"))
				{
					pedido  = rs.getString("numero_pedido_carrito");
				}
			}
		}
		catch(Exception ex)
		{
			System.out.println("[NuevoportalRamaCDO.- Error: Llenar clase de articulos en carrito,  Clase: GestorIniciaSessionV2,  Detalle: " + ex.getMessage().toString() +"]"); 
			//Log log=new Log(0,0,0 ,0, "[Error: Llenar clase de articulos en carrito,  Clase: GestorIniciaSessionV2,  Detalle: " + ex.getMessage().toString() +"]");
			//Cls_Log.insertaLog(log);
		}		
		return pedido;
	}
	
	private InfoCliente llenaClaseInfoCliente(ResultSet rs, List<Querys> listaQuerys)
	{
		InfoCliente infoCliente=new InfoCliente();
		try
		{
			while(rs.next())
			{	
				if(rs.getString("infoCliente").equals("*"))
				{
					 
					infoCliente.setCentro(rs.getInt("cve_centro"));
					infoCliente.setCommen_cliente(rs.getString("cli_commen"));
					
					infoCliente.setCve_cliente(rs.getInt("cve_client"));
					infoCliente.setCve_cdo(rs.getInt("cve_empresa"));
					
					infoCliente.setEstatus(rs.getString("cli_status"));
					infoCliente.setFac_descuento(rs.getString("fac_des"));
					
					infoCliente.setFecha_contrasena(rs.getString("fecha_contrasena"));
					infoCliente.setLetra_descuento(rs.getString("cli_letcla"));
					
					infoCliente.setLimite_credito("$ " + formatoDecimal.format(Double.parseDouble(rs.getString("cli_limcre"))));
					// System.out.println("limite de BD "  + infoCliente.getLimite_credito());
					//infoCliente.setLincme_cliente(rs.getString("cli_lincme"));					
					infoCliente.setNombre_cdo(rs.getString("nom_cdo"));
				
					infoCliente.setNombre_cliente(rs.getString("cli_nombre").replace(",", "").replace(".", ""));
					infoCliente.setUname_cdo(rs.getString("nom_empresa"));
					
					infoCliente.setNum_agente(rs.getInt("cve_agente"));
					infoCliente.setRazon_social(rs.getString("cli_razons"));
				
					infoCliente.setRfc(rs.getString("cli_rfc"));
					//infoCliente.setSaldo_total("$ " + formatoDecimal.format(Double.parseDouble(rs.getString("cli_totsal"))));
					infoCliente.setVigencia(rs.getString("cli_vig"));
					//double disponibleCte= Double.parseDouble(rs.getString("cli_limcre")) - Double.parseDouble(rs.getString("cli_totsal"));
					//infoCliente.setDisponible_cte("$ " + formatoDecimal.format(disponibleCte));

					infoCliente.setImp_min_de_pedido(rs.getString("imp_min_de_pedido"));
					//System.out.println("[infoCliente: " + infoCliente +"]"); 
					break;
				}
			}
			 
			
			
				infoCliente =  GestorBodegaCliente.consultaRelacionBodegaCteWS(infoCliente);	

		 
			infoCliente.setFac_descuento( ConsultaPorcentajeDeDescuento(listaQuerys, infoCliente.getLetra_descuento()  ) );
		
			infoCliente =  consultaEjecucionDemonios(infoCliente);
		
		}
		catch(Exception ex)
		{
			//System.out.println("[NuevoportalRamaCDO.- Error: Llenar clase de infoCliente llenaClaseInfoCliente(),  Clase: GestorIniciaSessionV2.llenaClaseInfoCliente,  Detalle: " + ex.toString() +"]"); 
			Log log=new Log(0, 0, 0 ,0, "[NuevoportalRamaCDO.- Error: Llenar clase de infoCliente llenaClaseInfoCliente(),  Clase: GestorIniciaSessionV2.llenaClaseInfoCliente,  Detalle: " + ex.toString() +"]");
			Cls_Log.insertaLog(log);
		}
		return infoCliente;		
	}
	
	public InfoCliente consultaEjecucionDemonios(InfoCliente infoCliente) {
		
		try
		{
		  GestorConfiguracionDemoniosV2 dem = new GestorConfiguracionDemoniosV2();
		   try {

			   dem.init();
				EjecDemonios demonio = dem.ConsultaProcesarPedidoWS(infoCliente.getCentro(), infoCliente);
				infoCliente.setHoraIni(demonio.getHoraIni());
				infoCliente.setHoraFin(demonio.getHoraFin());
				infoCliente.setHoraSabadoIni(demonio.getHoraSabadoIni());
				infoCliente.setHoraSabadoFin(demonio.getHoraSabadoFin());	
				dem.destroy();
			} catch (Exception e) {
				Log log=new Log(0, 0, 0 ,0, "[Error consultaEjecucionDemonios,  Clase: GestorIniciaSessionV2,  Detalle: " + e +"]");
				System.out.println("[Error consultaEjecucionDemonios,  Clase: GestorIniciaSessionV2,  Detalle:" + e +"]");
				Cls_Log.insertaLog(log);
				destroy();
			}	
		}
		catch(Exception e)
		{
			throw e;
			//Log log=new Log(0,0,0 ,0, "[Error: Llenar clase de infoCliente,  Clase: consultaEjecucionDemonios,  Detalle: " + e.toString() +"]");
			//Cls_Log.insertaLog(log);	
		}
		return infoCliente;
	}

	private List<Marcas> llenaClaseMarcas(ResultSet rs) throws Exception
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
					marca.setCve_marca(rs.getInt("cve_marca_producto"));
					marca.setNombre_marca(rs.getString("desc_marca_producto"));
					marcas.add(marca);
				}
			}		
		}
		catch(Exception ex)
		{
			System.out.println("[NuevoportalRamaCDO.- Error: Llenar clase de marcas,  Clase: GestorIniciaSessionV2,  Detalle: " + ex.getMessage().toString() +"]"); 
			//Log log=new Log(0,0,0 ,0, "[Error: Llenar clase de marcas,  Clase: GestorIniciaSessionV2,  Detalle: " + ex.getMessage().toString() +"]");
			//Cls_Log.insertaLog(log);
			throw ex;
		}		
		return marcas;
	}
		
	private List<Armandoras> llenaClaseArmadoras(ResultSet rs) throws Exception
	{
		List<Armandoras> listaArmadoras = new ArrayList<>();
		try
		{
			rs.beforeFirst();
			if(rs != null)
			{
				while(rs.next())
				{
					if(rs.getString("armadoras").equals("*"))
					{
						Armandoras armadora= new Armandoras();
						armadora.setCve_armadora(rs.getInt("cve_armadora"));
						armadora.setNombre_armadora(rs.getString("nom_armadora"));
						armadora.setDescripcion_armadora(rs.getString("desc_armadora"));
						listaArmadoras.add(armadora);
					}
				}
			}
		}
		catch(Exception ex)
		{
			System.out.println("[NuevoportalRamaCDO.- Error: Llenar clase de armandoras,  Clase: GestorIniciaSessionV2,  Detalle: " + ex.getMessage().toString() +"]"); 
			//Log log=new Log(0,0,0 ,0, "[Error: Llenar clase de armadoras,  Clase: GestorIniciaSessionV2,  Detalle: " + ex.getMessage().toString() +"]");
			//Cls_Log.insertaLog(log);
			throw ex;
		}
		//System.out.println("Lista Armadoras desde query 11:" + listaArmadoras );
		return listaArmadoras;
	}

	private List<Grupos> llenaClaseGrupos(ResultSet rs) throws Exception
	{
		List<Grupos> grupos =new ArrayList<>();		
		try
		{
			rs.beforeFirst();
			while(rs.next())
			{
				if(rs.getString("grupos").equals("*"))
				{
					Grupos grupo=new Grupos();
					grupo.setCve_grupo(rs.getInt("cve_grupo"));
					grupo.setNombre_grupo(rs.getString("nom_grupo"));
					grupo.setDescripcion_grupo(rs.getString("desc_grupo"));
					grupos.add(grupo);
				}
			}		
		}
		catch(Exception ex)
		{
			System.out.println("[NuevoportalRamaCDO.- Error: Llenar clase de grupos,  Clase: GestorIniciaSessionV2,  Detalle: " + ex.getMessage().toString() +"]"); 
			//Log log=new Log(0,0,0 ,0, "[Error: Llenar clase de grupos,  Clase: GestorIniciaSessionV2,  Detalle: " + ex.getMessage().toString() +"]");
			//Cls_Log.insertaLog(log); 
			throw ex;
		}		
		return grupos;
	}
		
	private List<MarcasDeCalidad> llenarClaseMarcasDeCalidad(ResultSet rs) throws Exception
	{
		List<MarcasDeCalidad> marcasCalidad = new ArrayList<>();		
		try
		{
			rs.beforeFirst();
			while(rs.next())
			{
				if(rs.getString("marcas_calidad").equals("*"))
				{
					MarcasDeCalidad marca = new MarcasDeCalidad();
					marca.setCve_marca(rs.getInt("cve_marca_calidad"));
					marca.setImagen(rs.getString("imagen"));
					marca.setOrden(rs.getInt("ordenamiento"));
					marcasCalidad.add(marca);
				}
			}		
		}
		catch(Exception ex)
		{
			System.out.println("[NuevoportalRamaCDO.- Error: Llenar clase de marcas de calidad,  Clase: GestorIniciaSessionV2,  Detalle: " + ex.getMessage().toString() +"]"); 
			//Log log=new Log(0,0,0 ,0, "[Error: Llenar clase de marcas de calidad,  Clase: GestorIniciaSessionV2,  Detalle: " + ex.getMessage().toString() +"]");
			//Cls_Log.insertaLog(log);	
			throw ex;
		}		
		return marcasCalidad;
	}
	
	private List<LineasDescuentoFijo> llenaClaseLineasDescuentoFijo(ResultSet rs) throws Exception
	{
		List<LineasDescuentoFijo> list_linea_desFijo = new ArrayList<>();
		try
		{
			rs.beforeFirst();
			while(rs.next())
			{
				if(rs.getString("lineas_desc_fijo").equals("*"))
				{
					LineasDescuentoFijo linea = new LineasDescuentoFijo();
					linea.setLinea(rs.getString("linea_fija"));
					linea.setPorcanetaje(rs.getInt("porcentaje_fijo"));
					linea.setDescuento(rs.getString("descuento_fijo"));
					list_linea_desFijo.add(linea);
				}
			}		
		}
		catch(Exception ex)
		{
			System.out.println("[NuevoportalRamaCDO.- Error: Llenar clase de marcas de descuentos fijos por cliente,  Clase: GestorIniciaSessionV2,  Detalle: " + ex.getMessage().toString() +"]"); 
			//Log log=new Log(0,0,0 ,0, "[Error: Llenar clase de marcas de descuentos fijos por cliente,  Clase: GestorIniciaSessionV2,  Detalle: " + ex.getMessage().toString() +"]");
			//Cls_Log.insertaLog(log); 
			throw ex;
		}	
		return list_linea_desFijo;
	}
	
	private List<CdosTraspasosEmergencia> llenaClaseCdosConTraspasos(ResultSet rs) throws Exception
	{
		List<CdosTraspasosEmergencia> list_cdos = new ArrayList<>();
		try
		{
			rs.beforeFirst();
			while(rs.next())
			{
				if(rs.getString("cdos_traspaso").equals("*"))
				{
					CdosTraspasosEmergencia cdo = new CdosTraspasosEmergencia();
					cdo.setEmpresa(rs.getString("cve_empresa_traspaso"));
					cdo.setNombre_cdo(rs.getString("nom_cdo_traspaso"));
					cdo.setUname(rs.getString("uname_traspaso"));
					list_cdos.add(cdo);
				}
			}		
		}
		catch(Exception ex)
		{
			System.out.println("[NuevoportalRamaCDO.- Error: Llenar clase de marcas de cdos con traspaso,  Clase: GestorIniciaSessionV2,  Detalle: " + ex.getMessage().toString() +"]"); 
			//Log log=new Log(0,0,0 ,0, "[Error: Llenar clase de marcas de cdos con traspasos,  Clase: GestorIniciaSessionV2,  Detalle: " + ex.getMessage().toString() +"]");
			//Cls_Log.insertaLog(log);	 
			throw ex;
		}	
		return list_cdos;
	}
	
	private List<Cilindros> llenaClaseCilindros(ResultSet rs) throws Exception
	{
		List<Cilindros> list_cilindros = new ArrayList<>();
		try
		{
			rs.beforeFirst();
			while(rs.next())
			{
				if(rs.getString("cilindros").equals("*"))
				{
					Cilindros cilindro = new Cilindros();
					cilindro.setNom_cilindros(rs.getString("nom_cilindros"));
					list_cilindros.add(cilindro);
				}
			}		
		}
		catch(Exception ex)
		{
			System.out.println("[NuevoportalRamaCDO.- Error: Llenar clase de marcas de cilindros,  Clase: GestorIniciaSessionV2,  Detalle: " + ex.getMessage().toString() +"]"); 
			//Log log=new Log(0,0,0 ,0, "[Error: Llenar clase de marcas de cilindros,  Clase: GestorIniciaSessionV2,  Detalle: " + ex.getMessage().toString() +"]");
			//Cls_Log.insertaLog(log);
			throw ex;
		}	
		return list_cilindros;
	}
	
	private List<Litros> llenaClaseLitros(ResultSet rs) throws Exception
	{
		List<Litros> list_litros = new ArrayList<>();
		try
		{
			rs.beforeFirst();
			while(rs.next())
			{
				if(rs.getString("litros").equals("*"))
				{
					Litros litro = new Litros();
					litro.setNom_litros(rs.getString("nom_litros"));
					list_litros.add(litro);
				}
			}		
		}
		catch(Exception ex)
		{
			System.out.println("[NuevoportalRamaCDO.- Error: Llenar clase de marcas de litros,  Clase: GestorIniciaSessionV2,  Detalle: " + ex.getMessage().toString() +"]"); 
			//Log log=new Log(0,0,0 ,0, "[Error: Llenar clase de marcas de litros,  Clase: GestorIniciaSessionV2,  Detalle: " + ex.getMessage().toString() +"]");
			//Cls_Log.insertaLog(log);
			throw ex;
		}	
		return list_litros;
	}
		


	


	/**** Consutla a pedido estatus 0 ****/
	/*
	public String ConsultaPedidoEstatus0(List<Querys> listaQuerys, InfoCliente infoCliente)
	{
		String pedidoEstatus0="";
		
		Connection connBD = null;
		PreparedStatement pstm = null;
		connBD = ConexionBD.abrirConexionBD();
		InformacionInicialCarrito infoInicialCarrito = new InformacionInicialCarrito();	
		
		try 
		{
			String [] querys = new String [25];
			querys = Cls_Querys.LimpiaListaQuerys(querys);
			querys = Cls_Querys.ObtieneQuerys(48, listaQuerys, querys);
			querys= inicializaQueryNumero48(querys ,infoCliente.getCve_cliente(), infoCliente.getCentro() );
			pstm = connBD.prepareStatement("{call " + "comercio_electronico.usp_EXECUTE_QUERY(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			ResultSet rs2 = EjecutaQuerysBD.EjecutarQuery(querys[0], querys[1],querys[2], querys[3], querys[4], querys[5], querys[6],
					 querys[7], querys[8], querys[9],querys[10], querys[11], querys[12], querys[13], 
					 querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], 
					 querys[21], querys[22], querys[23], querys[24], "",pstm, connBD);
			
			//System.out.println("query 48");
			Cls_Querys.ImprimeQuerysConsola(querys);
			
			
			if(rs2 != null)
			{
				 while(rs2.next())
				 {
					 pedidoEstatus0= rs2.getString("cve_pedido");
					 break;
				 }
			}
			
				
		}
		catch(Exception ex)
		{
			System.out.println("[Error: Consultar informacion inicial del cliente,  Clase: GestorIniciaSessionV2.InformacionInicialCarrito,  Detalle: " + ex.toString() +"]"); 
			//Log log=new Log(0,Integer.parseInt(empresa_cte),Integer.parseInt(num_cte) ,Integer.parseInt(infoInicialCarrito.getNumerpPedidoCarrito()), "[Error: Consultar informacion inicial del cliente,  Clase: GestorIniciaSessionInformacionInicialCarrito,  Detalle: " + ex.toString() +"]");
			//Cls_Log.insertaLog(log);
		}
		finally
		{
			try {connBD.close();} catch (SQLException e) {e.printStackTrace();}
			try {pstm.close();} catch (SQLException e) {e.printStackTrace();}
		}		
		return pedidoEstatus0;
	}
*/
	
	/**** GENERA NUEVA CONTRASEÑA 
	 * @throws Exception ****/
	public String generarNuevaContrasena(String usuario, String password, String passwordEncriptado, List<Querys> ListaQuerys) throws Exception
	{
		String actualizoContrasena="TransaccionIncorrecta";
		String empresa_cte = usuario.substring((usuario.length() - 2), usuario.length());
		String num_cte = usuario.substring(0,(usuario.length()-2));
		String datos_cliente[] = obtenerDatosDelClienteParaContrasena(num_cte, empresa_cte, ListaQuerys);
		String emailCliente = datos_cliente[0];
		String rfcCliente = datos_cliente[1];
		
		if(emailCliente.equals(""))
		{
			return actualizoContrasena;
		}
		
		actualizoContrasena = actualizaContrasenaEnBD(num_cte, empresa_cte, password, passwordEncriptado, ListaQuerys);
		
		if(actualizoContrasena.equals("Psw_Actualizada_BD"))
		{
			actualizoContrasena = enviarContrasenaPorCorreo(emailCliente, rfcCliente, password);
		}
		
		//Log log=new Log(0, Integer.parseInt(empresa_cte),Integer.parseInt(num_cte) ,0, "[Accion: Genera nueva contrasena para el cliente. ]");
		//Cls_Log.insertaLog(log);
		
		return actualizoContrasena;
	}
	
	public String generarNuevaContrasena2(String usuario, String password, String passwordEncriptado, List<Querys> ListaQuerys) throws Exception
	{
		String actualizoContrasena="TransaccionIncorrecta";
		String empresa_cte = usuario.substring((usuario.length() - 2), usuario.length());
		String num_cte = usuario.substring(0,(usuario.length()-2));
		String datos_cliente[] = obtenerDatosDelClienteParaContrasena(num_cte, empresa_cte, ListaQuerys);
		String emailCliente = datos_cliente[0];
		String rfcCliente = datos_cliente[1];
		
		if(emailCliente.equals(""))
		{
			return actualizoContrasena;
		}
		
		actualizoContrasena = actualizaContrasenaEnBD2(num_cte, empresa_cte, password, passwordEncriptado, ListaQuerys);
	//	System.out.println("actualizoContrasena: " + actualizoContrasena);
		if(!actualizoContrasena.equals(""))
		{
			actualizoContrasena = enviarContrasenaPorCorreo2(rfcCliente, emailCliente, num_cte, actualizoContrasena);
		}
		
		//Log log=new Log(0, Integer.parseInt(empresa_cte),Integer.parseInt(num_cte) ,0, "[Accion: Genera nueva contrasena para el cliente. ]");
		//Cls_Log.insertaLog(log);
		
		return actualizoContrasena;
	}
	private String[] obtenerDatosDelClienteParaContrasena(String num_cte, String empresa_cte,List<Querys> ListaQuerys) throws Exception
	{
		String datos_cliente[] = new String[2];
		Connection connBD = null;
		PreparedStatement pstm= null;
		connBD = ConexionBD.abrirConexionBD();	
		try
		{
			String[] querys = new String[25];	
			querys = Cls_Querys.LimpiaListaQuerys(querys);	
			querys = Cls_Querys.ObtieneQuerys(2, ListaQuerys, querys);
			querys = inicializaQueryNumero_1_2_3(querys,empresa_cte,num_cte, "","");
			pstm = connBD.prepareStatement("{call " + "comercio_electronico.usp_EXECUTE_QUERY(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			ResultSet rs=  EjecutaQuerysBD.EjecutarQuery(querys[0], querys[1],querys[2], querys[3], querys[4], querys[5], querys[6],
														 querys[7], querys[8], querys[9],querys[10], querys[11], querys[12], querys[13], 
														 querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], 
														 querys[21], querys[22], querys[23], querys[24], "",pstm, connBD);
			
			Cls_Querys.ImprimeQuerysConsola(querys,false,"query 2");
		
			if (rs != null)
	        {
		        while (rs.next())
		        {
		        	datos_cliente[0] = rs.getString("e_mail");
		        	datos_cliente[1] = rs.getString("cli_rfc");
		        }
	        }
			
			//Log log=new Log(0, Integer.parseInt(empresa_cte),Integer.parseInt(num_cte) ,0, "[Accion: Obtener datos del cliente para nueva contrasena. ]");
			//Cls_Log.insertaLog(log);
		}
		catch(Exception ex)
		{
			System.out.println("[NuevoportalRamaCDO.- Error: Obtener datos del cliente para contrasena,  Clase: GestorIniciaSessionV2,  Detalle: " + ex.getMessage().toString() +"]"); 
			//Log log=new Log(0,Integer.parseInt(empresa_cte),Integer.parseInt(num_cte) ,0, "[Error: Obtener datos del cliente para contrasena,  Clase: GestorIniciaSession,  Detalle: " + ex.getMessage().toString() +"]");
			//Cls_Log.insertaLog(log);
			throw ex;
		}
		finally 
		{
			try {pstm.close();} catch (SQLException e) {e.printStackTrace();}
			try {connBD.close();} catch (SQLException e) {e.printStackTrace();}
		}
		return datos_cliente;
	}
	
	private String actualizaContrasenaEnBD(String num_cte, String empresa_cte, String password, String passwordEncriptado, List<Querys> ListaQuerys) throws Exception
	{
		String actualizoContrasena="TransaccionIncorrecta";
		Connection connBD = null;
		PreparedStatement pstm= null;
		connBD = ConexionBD.abrirConexionBD();	
		try
		{
			String[] querys = new String[25];	
			querys = Cls_Querys.LimpiaListaQuerys(querys);	
			querys = Cls_Querys.ObtieneQuerys(3, ListaQuerys, querys);
			querys = inicializaQueryNumero_1_2_3(querys,empresa_cte,num_cte, password,passwordEncriptado);
			pstm = connBD.prepareStatement("{call " + "comercio_electronico.usp_EXECUTE_QUERY(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			ResultSet rs=  EjecutaQuerysBD.EjecutarQuery(querys[0], querys[1],querys[2], querys[3], querys[4], querys[5], querys[6],
														 querys[7], querys[8], querys[9],querys[10], querys[11], querys[12], querys[13], 
														 querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], 
														 querys[21], querys[22], querys[23], querys[24], "",pstm, connBD);
			
			Cls_Querys.ImprimeQuerysConsola(querys, false, "Query 3");
				
			actualizoContrasena="Psw_Actualizada_BD";
			
		    //Log log=new Log(0, Integer.parseInt(empresa_cte),Integer.parseInt(num_cte) ,0, "[Accion: Actualiza nueva contrasena del cliente  en BD. ]");
			//Cls_Log.insertaLog(log);
		}
		catch(Exception ex)
		{
			System.out.println("[NuevoportalRamaCDO.- Error: Actualizar contrasena por cliente ,  Clase: GestorIniciaSessionV2,  Detalle: " + ex.getMessage().toString() +"]"); 
			//Log log=new Log(0,Integer.parseInt(empresa_cte),Integer.parseInt(num_cte) ,0, "[Error: Actualizar contrasena por cliente,  Clase: GestorIniciaSession,  Detalle: " + ex.getMessage().toString() +"]");
			//Cls_Log.insertaLog(log);
			throw ex;
		}
		finally 
		{
			try {pstm.close();} catch (SQLException e) {e.printStackTrace();}
			try {connBD.close();} catch (SQLException e) {e.printStackTrace();}
		}
		return actualizoContrasena;
	}
	
	private String actualizaContrasenaEnBD2(String num_cte, String empresa_cte, String password, String passwordEncriptado, List<Querys> ListaQuerys) throws Exception
	{
		String actualizoContrasena="TransaccionIncorrecta";
		Connection connBD = null;
		PreparedStatement pstm= null;
		connBD = ConexionBD.abrirConexionBD();	
		String cveCentro = "";
		try
		{
			String[] querys = new String[25];	
			querys = Cls_Querys.LimpiaListaQuerys(querys);	
			querys = Cls_Querys.ObtieneQuerys(50, ListaQuerys, querys);
			querys = inicializaQueryNumero_50(querys,num_cte,empresa_cte);
			pstm = connBD.prepareStatement("{call " + "comercio_electronico.usp_EXECUTE_QUERY(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			ResultSet rs=  EjecutaQuerysBD.EjecutarQuery(querys[0], querys[1],querys[2], querys[3], querys[4], querys[5], querys[6],
														 querys[7], querys[8], querys[9],querys[10], querys[11], querys[12], querys[13], 
														 querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], 
														 querys[21], querys[22], querys[23], querys[24], "",pstm, connBD);
			
			Cls_Querys.ImprimeQuerysConsola(querys, false, "Query 50");

			if(rs != null)
			{
				 while(rs.next())
				 {
					 cveCentro= rs.getString("cve_centro");
					 break;
				 }
			}

			actualizoContrasena="Psw_Actualizada_BD";
			
		    //Log log=new Log(0, Integer.parseInt(empresa_cte),Integer.parseInt(num_cte) ,0, "[Accion: Actualiza nueva contrasena del cliente  en BD. ]");
			//Cls_Log.insertaLog(log);
		}
		catch(Exception ex)
		{
			System.out.println("[NuevoportalRamaCDO.- Error: Actualizar contrasena por cliente ,  Clase: GestorIniciaSessionV2,  Detalle: " + ex.getMessage().toString() +"]"); 
			//Log log=new Log(0,Integer.parseInt(empresa_cte),Integer.parseInt(num_cte) ,0, "[Error: Actualizar contrasena por cliente,  Clase: GestorIniciaSession,  Detalle: " + ex.getMessage().toString() +"]");
			//Cls_Log.insertaLog(log);
			throw ex;
		}
		finally 
		{
			try {pstm.close();} catch (SQLException e) {e.printStackTrace();}
			try {connBD.close();} catch (SQLException e) {e.printStackTrace();}
		}
		return cveCentro;
	}
	
	
	private String enviarContrasenaPorCorreo(String emailCliente, String rfcCliente, String password)
	{
		String actualizoContrasena="Psw_Actualizada_BD";
		String correoEmisor = properties.getProperty("mail.login.username");
		String correoHost = properties.getProperty("mail.smtp.host");
		String correoPass=  properties.getProperty("mail.login.password");
		String asunto = "Acceso para Venta en Línea CDO Autopartes";
		String contenidoDelMensaje = generarContenidoDeCorreoContrasena(password, rfcCliente);
		
		Properties props = System.getProperties();
	    props.put("mail.smtp.host", correoHost); 
	    props.put("mail.smtp.user", correoEmisor);
	    props.put("mail.smtp.clave", correoPass);
	    props.put("mail.smtp.auth", "true"); 
	    props.put("mail.smtp.starttls.enable", "true"); 
	    props.put("mail.smtp.port","587"); 
	    
	    Session session = Session.getDefaultInstance(props);
	    MimeMessage message = new MimeMessage(session);
	
	    try 
	    {
	        message.setFrom(new InternetAddress(correoEmisor));
	        message.addRecipients(Message.RecipientType.TO, emailCliente);
	        message.setSubject(asunto);
	        message.setContent(contenidoDelMensaje, "text/html");
	        Transport transport = session.getTransport("smtp");
	        transport.connect(correoHost, correoEmisor,correoPass);
	        transport.sendMessage(message, message.getAllRecipients());
	        transport.close();
	        actualizoContrasena ="ContrasenaEnviada";
	    }
	    catch (MessagingException me)
	    {
	        me.printStackTrace(); 	       
	    }
	    return actualizoContrasena;
	}
	
	private String enviarContrasenaPorCorreo2(String rfcCliente, String emailCliente, String cliente, String centro)
	{
		String actualizoContrasena="Psw_Actualizada_BD";
		String correoEmisor = properties.getProperty("mail.login.username");
		String correoHost = properties.getProperty("mail.smtp.host");
		String correoPass=  properties.getProperty("mail.login.password");
		String asunto = "Acceso para Venta en Línea CDO Autopartes";
		String contenidoDelMensaje = generarContenidoDeCorreoContrasena2(rfcCliente, cliente, centro);
		
		Properties props = System.getProperties();
	    props.put("mail.smtp.host", correoHost); 
	    props.put("mail.smtp.user", correoEmisor);
	    props.put("mail.smtp.clave", correoPass);
	    props.put("mail.smtp.auth", "true"); 
	    props.put("mail.smtp.starttls.enable", "true"); 
	    props.put("mail.smtp.port", "587"); 
	    
	    Session session = Session.getDefaultInstance(props);
	    MimeMessage message = new MimeMessage(session);
	
	    try 
	    {
	        message.setFrom(new InternetAddress(correoEmisor));
	        message.addRecipients(Message.RecipientType.TO, emailCliente);
	        message.setSubject(asunto);
	        message.setContent(contenidoDelMensaje, "text/html");
	        Transport transport = session.getTransport("smtp");
	        transport.connect(correoHost, correoEmisor,correoPass);
	        transport.sendMessage(message, message.getAllRecipients());
	        transport.close();
	        actualizoContrasena ="ContrasenaEnviada";
	    }
	    catch (MessagingException me)
	    {
	        me.printStackTrace(); 	       
	    }
	    return actualizoContrasena;
	}
	
	private String generarContenidoDeCorreoContrasena(String password, String rfcCliente) 
	{		
		String sFechaHoraSistema = "";
		String contenidoDelMensaje = "";
		
		SimpleDateFormat formatter = new SimpleDateFormat("dd 'de' MMMM 'de' yyyy hh:mm:ss aaa");
		Date fechaHoraSistema = Calendar.getInstance().getTime();
		sFechaHoraSistema = formatter.format(fechaHoraSistema);		
		
		contenidoDelMensaje += "<%@ page language=\"java\" contentType=\"text/html; charset=ISO-8859-1\" pageEncoding=\"ISO-8859-1\"%>";
		contenidoDelMensaje += "<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">";
		contenidoDelMensaje += "<html>";				
		contenidoDelMensaje += "<font size =\"4\" face=\"Arial\" color=#004099>" + sFechaHoraSistema + "</font><br>";
		contenidoDelMensaje += "<h2><font face=\"Arial\" color=#004099>Estimado cliente:</font></h2>";
		contenidoDelMensaje += "<font size =\"14px\" face=\"Arial\" color=#004099>Le hacemos llegar la contrase&ntilde;a que le permite el acceso a nuestro sistema de Venta en L&iacute;nea.</font><br><br>";
		contenidoDelMensaje += "<font size =\"14px\" face=\"Arial\" color=#004099>Para su cuenta conocida con el RFC: " + rfcCliente +"</font><br><br>";
		contenidoDelMensaje += "<b><font size =\"18px\" face=\"Arial\" color=#004099>La Contrase&ntilde;a de Acceso es: " + password + "</font></b><br><br>";
		contenidoDelMensaje += "<font size =\"14px\" face=\"Arial\" color=#004099>Muchas Gracias por su preferencia.</font><br>";
		contenidoDelMensaje += "<h3><font face=\"Arial\" color=#6792A0>Atte. Centro de Distribuci&oacute;n Oriente</font></h3><br>";
		contenidoDelMensaje += "<center><h3><font face=\"Arial\" color=#004099>AVISO DE PRIVACIDAD</font></h3></center>";
		contenidoDelMensaje += "<font size =\"12px;\" face=\"Arial\" color=#004099>Este correo electr&oacute;nico puede contener informaci&oacute;n confidencial y privilegiada, por lo que se proh&iacute;be el uso, reproducci&oacute;n,</font>";
		contenidoDelMensaje += "<font size =\"12px;\" face=\"Arial\" color=#004099>retransmisi&oacute;n o divulgaci&oacute;n no autorizada, parcial o total, de su contenido. Si usted no es el destinatario del presente correo, por </font>";
		contenidoDelMensaje += "<font size =\"12px;\" face=\"Arial\" color=#004099>favor notif&iacute;quelo al remitente y b&oacute;rrelo de inmediato. En Centro de Distribuci&oacute;n Oriente, S.A. de C.V., nos ocupamos de cuidar la </font>";
		contenidoDelMensaje += "<font size =\"12px;\" face=\"Arial\" color=#004099>seguridad y confidencialidad de sus datos.</font>";
		contenidoDelMensaje += "<font size =\"12px;\" face=\"Arial\" color=#004099>Consulte nuestro Aviso de Privacidad actualizado en nuestras instalaciones o accediendo a la siguiente liga:</font><br>";
		contenidoDelMensaje += "<font size =\"12px;\" face=\"Arial\" color=#004099><a href='http://www.cdoautopartes.com.mx/'>https://www.cdoautopartes.com.mx/</a></font><br>";
		contenidoDelMensaje += "</html>";
		return contenidoDelMensaje;
	}
	
	private String generarContenidoDeCorreoContrasena2(String rfc, String cliente, String centro)  
	{		
		String sFechaHoraSistema = "";
		String contenidoDelMensaje = "";
		
		SimpleDateFormat formatter = new SimpleDateFormat("dd 'de' MMMM 'de' yyyy hh:mm:ss aaa");
		Date fechaHoraSistema = Calendar.getInstance().getTime();
		sFechaHoraSistema = formatter.format(fechaHoraSistema);

	

		contenidoDelMensaje += "<%@ page language=\"java\" contentType=\"text/html; charset=ISO-8859-1\" pageEncoding=\"ISO-8859-1\"%>";
		contenidoDelMensaje += "<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">";
		contenidoDelMensaje += "<html>";				
		contenidoDelMensaje += "<font size =\"4\" face=\"Arial\" color=#004099>" + sFechaHoraSistema + "</font><br>";
		contenidoDelMensaje += "<h2><font face=\"Arial\" color=#004099>Estimado cliente:</font></h2>";
		contenidoDelMensaje += "<font size =\"14px\" face=\"Arial\" color=#004099>Le hacemos llegar el siguiente link que le permite cambiar el acceso a nuestro sistema de Venta en Línea.</font><br><br>";
		contenidoDelMensaje += "<font size =\"14px\" face=\"Arial\" color=#004099>Para su cuenta conocida con el RFC: " + rfc +"</font><br><br>";
		contenidoDelMensaje += "<b><font size =\"18px\" face=\"Arial\" color=#004099> <a href='http://webcdo18.corprama.com.mx/CambiarPassword/?clave="+ cliente +"&cliente=&centro="+ centro + "'>CLICK AQUI</a></font></b><br><br>";
		contenidoDelMensaje += "<font size =\"14px\" face=\"Arial\" color=#004099>Muchas Gracias por su preferencia.</font><br>";
		contenidoDelMensaje += "<h3><font face=\"Arial\" color=#6792A0>Atte. Centro de Distribuci&oacute;n Oriente</font></h3><br>";
		contenidoDelMensaje += "<center><h3><font face=\"Arial\" color=#004099>AVISO DE PRIVACIDAD</font></h3></center>";
		contenidoDelMensaje += "<font size =\"12px;\" face=\"Arial\" color=#004099>Este correo electr&oacute;nico puede contener informaci&oacute;n confidencial y privilegiada, por lo que se proh&iacute;be el uso, reproducci&oacute;n,</font>";
		contenidoDelMensaje += "<font size =\"12px;\" face=\"Arial\" color=#004099>retransmisi&oacute;n o divulgaci&oacute;n no autorizada, parcial o total, de su contenido. Si usted no es el destinatario del presente correo, por </font>";
		contenidoDelMensaje += "<font size =\"12px;\" face=\"Arial\" color=#004099>favor notif&iacute;quelo al remitente y b&oacute;rrelo de inmediato. En Centro de Distribuci&oacute;n Oriente, S.A. de C.V., nos ocupamos de cuidar la </font>";
		contenidoDelMensaje += "<font size =\"12px;\" face=\"Arial\" color=#004099>seguridad y confidencialidad de sus datos.</font>";
		contenidoDelMensaje += "<font size =\"12px;\" face=\"Arial\" color=#004099>Consulte nuestro Aviso de Privacidad actualizado en nuestras instalaciones o accediendo a la siguiente liga:</font><br>";
		contenidoDelMensaje += "<font size =\"12px;\" face=\"Arial\" color=#004099><a href='http://www.cdoautopartes.com.mx/'>http://www.cdoautopartes.com.mx/</a></font><br>";
		contenidoDelMensaje += "</html>";
		return contenidoDelMensaje;
	}
	public String ConsultaPorcentajeDeDescuento(List<Querys> ListaQuerys, String clave) throws Exception
	{
		String porDesc = "1.0";
		Connection connBD = null;
		PreparedStatement pstm= null;
		connBD = ConexionBD.abrirConexionBD();	
		try
		{
			String[] querys = new String[25];	
			querys = Cls_Querys.LimpiaListaQuerys(querys);	
			querys = Cls_Querys.ObtieneQuerys(46, ListaQuerys, querys);
			querys = inicializaQueryNumero46(querys,clave);
			pstm = connBD.prepareStatement("{call " + "comercio_electronico.usp_EXECUTE_QUERY(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			ResultSet rs=  EjecutaQuerysBD.EjecutarQuery(querys[0], querys[1],querys[2], querys[3], querys[4], querys[5], querys[6],
														 querys[7], querys[8], querys[9],querys[10], querys[11], querys[12], querys[13], 
														 querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], 
														 querys[21], querys[22], querys[23], querys[24], "",pstm, connBD);
			

			Cls_Querys.ImprimeQuerysConsola(querys,false, "query 46");
		
			if (rs != null)
	        {
		        while (rs.next())
		        {
		        	porDesc = rs.getString("fac_des");
		        }
	        }
 
			

		}
		catch(Exception ex)
		{
			System.out.println("[NuevoportalRamaCDO.- Error: Obtener datos del cliente para contrasena,  Clase: GestorIniciaSessionV2,  Detalle: " + ex.getMessage().toString() +"]"); 
			//Log log=new Log(0,Integer.parseInt(empresa_cte),Integer.parseInt(num_cte) ,0, "[Error: Obtener datos del cliente para contrasena,  Clase: GestorIniciaSession,  Detalle: " + ex.getMessage().toString() +"]");
			//Cls_Log.insertaLog(log);
			throw ex;
		}
		finally 
		{
			try {pstm.close();} catch (SQLException e) {e.printStackTrace();}
			try {connBD.close();} catch (SQLException e) {e.printStackTrace();}
		}
	//	System.out.println("porDesc: " + porDesc);
		return porDesc;
	}
	
	
	/**** INICIALIZA QUERYS  ****/	
	private String[]  inicializaQueryNumero_1_2_3(String[] ListaQuerys, String empresa_cte,String num_cte, String password, String passwordEncriptado)
	{
		for (int i=0;i <ListaQuerys.length; i++)
		{
			ListaQuerys[i]= ListaQuerys[i].replace("{CVE_CLIENTE}", num_cte);
			ListaQuerys[i]= ListaQuerys[i].replace("{CVE_EMPRESA}", empresa_cte);
			ListaQuerys[i]= ListaQuerys[i].replace("{PASSWORD}",password);
			ListaQuerys[i]= ListaQuerys[i].replace("{PASSWORD_ENCRIPTADO}",passwordEncriptado);
		}
		return ListaQuerys;		
	}

	private String[]  inicializaQueryNumero_50(String[] ListaQuerys,  String num_cte, String centro )
	{
	       SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd,HH:mm:ss");
	        Date fechaHoraSistema = Calendar.getInstance().getTime();
	        String sFechaHoraSistema = formatter.format(fechaHoraSistema);    
	      //  System.out.println("sFechaHoraSistema: " + sFechaHoraSistema);
		for (int i=0;i <ListaQuerys.length; i++)
		{
			ListaQuerys[i]= ListaQuerys[i].replace("{FECHA-HORA}", sFechaHoraSistema);
			ListaQuerys[i]= ListaQuerys[i].replace("{CLIENTE}", num_cte);
			ListaQuerys[i]= ListaQuerys[i].replace("{CVE_EMPRESA}",centro);
		}
		return ListaQuerys;		
	}
	
	private String[]  inicializaQueryNumero11(String[] ListaQuerys, String uname_cte,String num_cte, String empresa_cte)
	{
		for (int i=0;i <ListaQuerys.length; i++)
		{
			ListaQuerys[i]= ListaQuerys[i].replace("{CVE_CLIENTE}", num_cte);
			ListaQuerys[i]= ListaQuerys[i].replace("{UNAME}", uname_cte);
			ListaQuerys[i]= ListaQuerys[i].replace("{CVE_EMPRESA}", empresa_cte);
		}
		return ListaQuerys;		
	}
	
	private String[]  inicializaQueryNumero15(String[] ListaQuerys, String empresa_cte,String num_cte)
	{
		for (int i=0;i <ListaQuerys.length; i++)
		{
			ListaQuerys[i]= ListaQuerys[i].replace("{CVE_CLIENTE}", num_cte);
			ListaQuerys[i]= ListaQuerys[i].replace("{CVE_EMPRESA}", empresa_cte);
		}
		return ListaQuerys;		
	}
	
	private String[]  inicializaQueryNumero46(String[] ListaQuerys, String clave)
	{
		for (int i=0;i <ListaQuerys.length; i++)
		{
			ListaQuerys[i]= ListaQuerys[i].replace("{CLAVE}", clave);
			
		}
		return ListaQuerys;		
	}
	
	private String[]  inicializaQueryNumero48(String[] ListaQuerys, int numCte, int cveCentro)
	{
		for (int i=0;i <ListaQuerys.length; i++)
		{
			ListaQuerys[i]= ListaQuerys[i].replace("{CVE_CENTRO}", Integer.toString(cveCentro));
			ListaQuerys[i]= ListaQuerys[i].replace("{CVE_CLIENTE}", Integer.toString(numCte));
			
		}
		return ListaQuerys;		
	}
}


