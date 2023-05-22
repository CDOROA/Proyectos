package cdo.Persistencia;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.Calendar;
import java.util.List;
import java.util.Properties;

import cdo.Datos.InfoCliente;
import cdo.Datos.Log;
import cdo.Datos.Querys;
import cdo.Util.Cls_Log;
import cdo.Util.Cls_Querys;
import cdo.Util.ConexionBD;
import cdo.Util.EjecutaQuerysBD;

public class GestorAltaArticuloEnCarrito {

	public static int AgregarArticuloACarrito(List<Querys> listaQuerys, InfoCliente infoCliente, String num_art,
			int cantidadPedida, int exietnciaCDO, int existenciaBR, float importe, String generaTraspaso,
			String CdoTraspaso, String pedidoEnCarrito) throws Exception {
		Connection connBD = null;
		PreparedStatement pstm = null;
		connBD = ConexionBD.abrirConexionBD();
		int NvaCantArticulos = 0;
		try {
			String[] querys = new String[25];
			querys = Cls_Querys.LimpiaListaQuerys(querys);
			querys = Cls_Querys.ObtieneQuerys(27, listaQuerys, querys);
			querys = inicializaQueryNumero27(querys, infoCliente, num_art, cantidadPedida, exietnciaCDO, existenciaBR,
					importe, generaTraspaso, CdoTraspaso, pedidoEnCarrito);

			pstm = connBD.prepareStatement("{call "
					+ "comercio_electronico.usp_EXECUTE_QUERY(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");

			Cls_Querys.ImprimeQuerysConsola(querys, false, "query 27");

			ResultSet rs = EjecutaQuerysBD.EjecutarQuery(querys[0], querys[1], querys[2], querys[3], querys[4],
					querys[5], querys[6], querys[7], querys[8], querys[9], querys[10], querys[11], querys[12],
					querys[13], querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20],
					querys[21], querys[22], querys[23], querys[24], "", pstm, connBD);
			if (rs != null) {
				while (rs.next()) {
					NvaCantArticulos = rs.getInt("articulos");
				}
			}

			Log log = new Log(1, infoCliente.getCve_cdo(), infoCliente.getCve_cliente(),
					Integer.parseInt(pedidoEnCarrito),
					"[Accion: Inserta Articulo a pedido actual en el carrito de compras." + num_art
							+ ", Cantidad Pedida: " + cantidadPedida + "]");
			Cls_Log.insertaLog(log);
		} catch (Exception ex) {
			throw ex;
		} finally {
			try {
				pstm.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				connBD.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return NvaCantArticulos;
	}

	public static int AgregarArticuloACarrito72Hrs(List<Querys> listaQuerys, InfoCliente infoCliente, String num_art,
			int exietnciaTraspaso, String cdoTraspaso, float importe) throws Exception {

		insertaHeaderTraspasos(listaQuerys, infoCliente, cdoTraspaso);

		return AgregarDetalle72Hrs(listaQuerys, infoCliente, num_art, exietnciaTraspaso, cdoTraspaso, importe);
	}

	private static boolean insertaHeaderTraspasos(List<Querys> listaQuerys, InfoCliente infoCliente, String cdoTraspaso)
			throws Exception {

		boolean RegistroActualizado = true;
		Connection connBD = null;
		PreparedStatement pstm = null;
		connBD = ConexionBD.abrirConexionBD();
		try {

			String[] querys = new String[25];
			querys = Cls_Querys.LimpiaListaQuerys(querys);
			querys = Cls_Querys.ObtieneQuerys(31, listaQuerys, querys);

			querys = inicializaQueryNumero31(querys, infoCliente, cdoTraspaso);
			pstm = connBD.prepareStatement("{call "
					+ "comercio_electronico.usp_EXECUTE_QUERY(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");

			Cls_Querys.ImprimeQuerysConsola(querys, false, "Query 31");

			ResultSet rs = EjecutaQuerysBD.EjecutarQuery(querys[0], querys[1], querys[2], querys[3], querys[4],
					querys[5], querys[6], querys[7], querys[8], querys[9], querys[10], querys[11], querys[12],
					querys[13], querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20],
					querys[21], querys[22], querys[23], querys[24], "", pstm, connBD);

			Log log = new Log(1, infoCliente.getCve_cdo(), infoCliente.getCve_cliente(), 0,
					"[Accion: Inserta Header de Traspaso 72 Hrs] : " + querys[0].toString().replace("'", ""));

			Cls_Log.insertaLog(log);
		} catch (Exception ex) {
			System.out.println("NuevoportalRamaCDO.- Error en insertaHeaderTraspasos: " + ex);
			RegistroActualizado = false;
			throw ex;
		} finally {
			try {
				pstm.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				connBD.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return RegistroActualizado;
	}

	private static int AgregarDetalle72Hrs(List<Querys> listaQuerys, InfoCliente infoCliente, String num_art,
			int exietnciaTraspaso, String cdoTraspaso, float importe) {
		Connection connBD = null;
		PreparedStatement pstm = null;
		connBD = ConexionBD.abrirConexionBD();
		int NvaCantArticulos = 0;
		try {
			String[] querys = new String[25];
			querys = Cls_Querys.LimpiaListaQuerys(querys);
			querys = Cls_Querys.ObtieneQuerys(28, listaQuerys, querys);

			querys = inicializaQueryNumero28(querys, infoCliente, num_art, exietnciaTraspaso, cdoTraspaso, importe);

			pstm = connBD.prepareStatement("{call "
					+ "comercio_electronico.usp_EXECUTE_QUERY(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");

			ResultSet rs = EjecutaQuerysBD.EjecutarQuery(querys[0], querys[1], querys[2], querys[3], querys[4],
					querys[5], querys[6], querys[7], querys[8], querys[9], querys[10], querys[11], querys[12],
					querys[13], querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20],
					querys[21], querys[22], querys[23], querys[24], "", pstm, connBD);

			Cls_Querys.ImprimeQuerysConsola(querys, false, "query 28");

			if (rs != null) {
				while (rs.next()) {
					// System.out.println("NvaCantArticulos: " + rs.getString("articulos"));
					NvaCantArticulos = rs.getInt("articulos");
				}
			}

			Log log = new Log(1, infoCliente.getCve_cdo(), infoCliente.getCve_cliente(), 0,
					"[Accion: Inserta Articulo a pedido de 72Hrs actual en el carrito de compras." + num_art
							+ ", Cantidad Pedida: " + exietnciaTraspaso + ", CDO " + cdoTraspaso + "  ]");
			Cls_Log.insertaLog(log);
		} catch (Exception ex) {
			System.out.println("NuevoportalRamaCDO.- NuevoportalRamaCDO.- Error al insertar AgregarDetalle72Hrs: "
					+ ex.toString());
			ex.printStackTrace();

		} finally {
			try {
				pstm.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				connBD.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return NvaCantArticulos;
	}

	public static int AgregarPedidoNuevo(List<Querys> listaQuerys, InfoCliente infoCliente, String num_art,
			int cantidadPedida, int exietnciaCDO, int existenciaBR, float importe, String generaTraspaso,
			String CdoTraspaso, String num_pedido_carrito) throws Exception {
		Connection connBD = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		connBD = ConexionBD.abrirConexionBD();
		int NvaCantArticulos = 0;
		try {
			String[] querys = new String[25];
			querys = Cls_Querys.LimpiaListaQuerys(querys);
			querys = Cls_Querys.ObtieneQuerys(29, listaQuerys, querys);
			querys = inicializaQueryNumero29(querys, infoCliente, num_art, cantidadPedida, exietnciaCDO, existenciaBR,
					importe, generaTraspaso, CdoTraspaso, num_pedido_carrito);

			pstm = connBD.prepareStatement("{call "
					+ "comercio_electronico.usp_EXECUTE_QUERY(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");

			Cls_Querys.ImprimeQuerysConsola(querys, false, "Query 29");

			rs = EjecutaQuerysBD.EjecutarQuery(querys[0], querys[1], querys[2], querys[3], querys[4], querys[5],
					querys[6], querys[7], querys[8], querys[9], querys[10], querys[11], querys[12], querys[13],
					querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], querys[21],
					querys[22], querys[23], querys[24], "", pstm, connBD);
			if (rs != null) {
				while (rs.next()) {
					// System.out.println("NvaCantArticulos: " + rs.getString("articulos"));
					NvaCantArticulos = rs.getInt("articulos");
				}
			}

			Log log = new Log(1, infoCliente.getCve_cdo(), infoCliente.getCve_cliente(), 0,
					"[Accion: Inserta Articulo a pedido actual en el carrito de compras." + num_art
							+ ", Cantidad Pedida: " + cantidadPedida + "]");
			Cls_Log.insertaLog(log);
		} catch (Exception ex) {
			System.out.println("NuevoportalRamaCDO.- error AgregarPedidoNuevo: " + ex);
			throw ex;
		} finally {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				pstm.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				connBD.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return NvaCantArticulos;
	}

	public static int EnviaPedido(List<Querys> listaQuerys, InfoCliente infoCliente, String transporte,
			String consignatario, String Pedido) {
		boolean pedidoEnviado = false;
		Connection connBD = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		connBD = ConexionBD.abrirConexionBD();
		int NumeroPedidoAEnviar = 0;
		try {
			String estatus = EvaluaHorasProceso(infoCliente, Pedido);

			String[] querys = new String[25];
			querys = Cls_Querys.LimpiaListaQuerys(querys);
			querys = Cls_Querys.ObtieneQuerys(30, listaQuerys, querys);
			querys = inicializaQueryNumero30_51_52(querys, infoCliente, transporte, consignatario, Pedido, estatus);

			pstm = connBD.prepareStatement("{call "
					+ "comercio_electronico.usp_EXECUTE_QUERY(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");

			Cls_Querys.ImprimeQuerysConsola(querys, false, "Query 30");

			rs = EjecutaQuerysBD.EjecutarQuery(querys[0], querys[1], querys[2], querys[3], querys[4], querys[5],
					querys[6], querys[7], querys[8], querys[9], querys[10], querys[11], querys[12], querys[13],
					querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], querys[21],
					querys[22], querys[23], querys[24], "", pstm, connBD);
			pedidoEnviado = true;
			Log log = new Log(0, infoCliente.getCve_cdo(), infoCliente.getCve_cliente(), Integer.parseInt(Pedido), "");

			if (rs != null) {
				while (rs.next()) {
					// System.out.println("NvaCantArticulos: " + rs.getString("articulos"));
					NumeroPedidoAEnviar = rs.getInt("pedido");
					log.setAccion("[Accion: Actualizacion de pedido, Numero de PEdido a enviar a Sistema Mayorista: "
							+ NumeroPedidoAEnviar + " ]");
					Cls_Log.insertaLog(log);
				}
			}

			if (estatus.equalsIgnoreCase("17")) {
				log.setAccion("[Accion: Actualizacion de pedido, Estatus 17. Pendiente por procesar]");
				Cls_Log.insertaLog(log);
				pedidoEnviado = false;
			} else if (estatus.equalsIgnoreCase("18")) {
				log.setAccion("[Accion: Actualizacion de pedido, Estatus 18. Error al validar Horas proeso.]");
				Cls_Log.insertaLog(log);
				pedidoEnviado = true;
			} else {
				log.setAccion("[Accion: Actualizacion de pedido, Estatus 1. Enviado.]");
				Cls_Log.insertaLog(log);
				pedidoEnviado = true;
			}

		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println("NuevoportalRamaCDO.- Error al actualizar peiddo. EnviaPedido : " + ex);
			NumeroPedidoAEnviar = 0;
		} finally {
			try {
				pstm.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				connBD.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return NumeroPedidoAEnviar;
	}

	public static int ActualizaPedidoEstatus17(List<Querys> listaQuerys, InfoCliente infoCliente, String transporte,
			String consignatario, String Pedido) {
		boolean pedidoEnviado = false;
		Connection connBD = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		connBD = ConexionBD.abrirConexionBD();
		int NumeroPedidoAEnviar = 0;
		try {
			String estatus = "17";

			String[] querys = new String[25];
			querys = Cls_Querys.LimpiaListaQuerys(querys);
			querys = Cls_Querys.ObtieneQuerys(51, listaQuerys, querys);
			querys = inicializaQueryNumero30_51_52(querys, infoCliente, transporte, consignatario, Pedido, estatus);

			pstm = connBD.prepareStatement("{call "
					+ "comercio_electronico.usp_EXECUTE_QUERY(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");

			Cls_Querys.ImprimeQuerysConsola(querys, false, "Query 51");

			rs = EjecutaQuerysBD.EjecutarQuery(querys[0], querys[1], querys[2], querys[3], querys[4], querys[5],
					querys[6], querys[7], querys[8], querys[9], querys[10], querys[11], querys[12], querys[13],
					querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], querys[21],
					querys[22], querys[23], querys[24], "", pstm, connBD);
			pedidoEnviado = true;
			Log log = new Log(0, infoCliente.getCve_cdo(), infoCliente.getCve_cliente(), Integer.parseInt(Pedido), "");

			if (estatus.equalsIgnoreCase("17")) {
				log.setAccion("[Accion: Actualizacion de pedido, Estatus 17. Pendiente por procesar]");
				Cls_Log.insertaLog(log);
				pedidoEnviado = false;
			} else if (estatus.equalsIgnoreCase("18")) {
				log.setAccion("[Accion: Actualizacion de pedido, Estatus 18. Error al validar Horas proeso.]");
				Cls_Log.insertaLog(log);
				pedidoEnviado = true;
			} else {
				log.setAccion("[Accion: Actualizacion de pedido, Estatus 1. Enviado.]");
				Cls_Log.insertaLog(log);
				pedidoEnviado = true;
			}

		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println("NuevoportalRamaCDO.- Error al actualizar peiddo. ActualizaPedidoEstatus17: " + ex);
			NumeroPedidoAEnviar = 0;
		} finally {
			try {
				pstm.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				connBD.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return NumeroPedidoAEnviar;
	}

	public static int ActualizaPedido72HrsEstatus17(List<Querys> listaQuerys, InfoCliente infoCliente,
			String transporte, String consignatario, String Pedido) {
		boolean pedidoEnviado = false;
		Connection connBD = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		int NumeroPedidoAEnviar = 0;
		Log log = new Log(0, infoCliente.getCve_cdo(), infoCliente.getCve_cliente(), Integer.parseInt(Pedido), "");
		try {
			log.setAccion(
					"[ActualizaPedido72HrsEstatus17 : SE incia el proceso de  cambio de estatus a 17/18 para 72hrs ]");
			Cls_Log.insertaLog(log);
			connBD = ConexionBD.abrirConexionBD();
			String estatus = "17";
			log.setAccion(
					"[ActualizaPedido72HrsEstatus17 : Se inicializan queris.]");
			Cls_Log.insertaLog(log);
			String[] querys = new String[25];
			querys = Cls_Querys.LimpiaListaQuerys(querys);
			log.setAccion(
					"[ActualizaPedido72HrsEstatus17 : se obitne el query numero 52 ]");
			Cls_Log.insertaLog(log);
			querys = Cls_Querys.ObtieneQuerys(52, listaQuerys, querys);
			log.setAccion(
					"[ActualizaPedido72HrsEstatus17 : Se forma sentencia del query 52 ]");
			Cls_Log.insertaLog(log);
			querys = inicializaQueryNumero30_51_52(querys, infoCliente, transporte, consignatario, Pedido, estatus);
			log.setAccion(
					"[ActualizaPedido72HrsEstatus17 : se prepara para ejecucion]");
			Cls_Log.insertaLog(log);
			pstm = connBD.prepareStatement("{call "
					+ "comercio_electronico.usp_EXECUTE_QUERY(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");

			Cls_Querys.ImprimeQuerysConsola(querys, false, "Query 52");

			rs = EjecutaQuerysBD.EjecutarQuery(querys[0], querys[1], querys[2], querys[3], querys[4], querys[5],
					querys[6], querys[7], querys[8], querys[9], querys[10], querys[11], querys[12], querys[13],
					querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], querys[21],
					querys[22], querys[23], querys[24], "", pstm, connBD);
			pedidoEnviado = true;
			log.setAccion(
					"[ActualizaPedido72HrsEstatus17 : Termina ejecucion del qury 52 ]");
			Cls_Log.insertaLog(log);
			
			if (estatus.equalsIgnoreCase("17")) {
				log.setAccion("[Accion: Actualizacion de pedido, Estatus 17. Pendiente por procesar]");
				Cls_Log.insertaLog(log);
				pedidoEnviado = false;
			} else if (estatus.equalsIgnoreCase("18")) {
				log.setAccion("[Accion: Actualizacion de pedido, Estatus 18. Error al validar Horas proeso.]");
				Cls_Log.insertaLog(log);
				pedidoEnviado = true;
			} else {
				log.setAccion("[Accion: Actualizacion de pedido, Estatus 1. Enviado.]");
				Cls_Log.insertaLog(log);
				pedidoEnviado = true;
			}
			log.setAccion(
					"[ActualizaPedido72HrsEstatus17 : se prepara a enviar correo ]");
			Cls_Log.insertaLog(log);
			try {

				EnvioDeDorreo72Hrs(listaQuerys, infoCliente, Integer.parseInt(Pedido));
			} catch (Exception ex) {
				log.setAccion(
						"[No se pudo enviar el correo de PEdido de 72 horas . clase: GestorAltaArticuloEnCarrito.ActualizaPedido72HrsEstatus17  subllamado: EnvioDeCorreo72Hrs  "
								+ ex.toString() + " ]");
				Cls_Log.insertaLog(log);
			}
			log.setAccion(
					"[ActualizaPedido72HrsEstatus17 : Fin del proceso de acutalizacion ]");
			Cls_Log.insertaLog(log);
		} catch (Exception ex) {

			log.setAccion(
					"[Error al Actualizar Estatus  PEdido de 72 horas . clase: GestorAltaArticuloEnCarrito.ActualizaPedido72HrsEstatus17  "
							+ ex.toString() + " ]");
			Cls_Log.insertaLog(log);
			NumeroPedidoAEnviar = 0;
		} finally {
			try {
				pstm.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				connBD.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return NumeroPedidoAEnviar;
	}

	public static boolean GeneraNuevoPedidoSiguiente(List<Querys> listaQuerys, InfoCliente infoCliente,
			String transporte, String consignatario, String Pedido) throws Exception {
		boolean pedidoEnviado = false;
		Connection connBD = null;
		PreparedStatement pstm = null;
		connBD = ConexionBD.abrirConexionBD();

		try {

			String[] querys = new String[25];
			querys = Cls_Querys.LimpiaListaQuerys(querys);
			querys = Cls_Querys.ObtieneQuerys(45, listaQuerys, querys);
			querys = inicializaQueryNumero45(querys, infoCliente);

			pstm = connBD.prepareStatement("{call "
					+ "comercio_electronico.usp_EXECUTE_QUERY(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");

			Cls_Querys.ImprimeQuerysConsola(querys, false, "Query 45");

			EjecutaQuerysBD.EjecutarQuery(querys[0], querys[1], querys[2], querys[3], querys[4], querys[5], querys[6],
					querys[7], querys[8], querys[9], querys[10], querys[11], querys[12], querys[13], querys[14],
					querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], querys[21], querys[22],
					querys[23], querys[24], "", pstm, connBD);
			pedidoEnviado = true;
			Log log = new Log(0, infoCliente.getCve_cdo(), infoCliente.getCve_cliente(), Integer.parseInt(Pedido), "");

			log.setAccion("[Accion: Se genero el siguiente pedido en Estatus 0.]");
			Cls_Log.insertaLog(log);

		} catch (Exception ex) {
			throw ex;
		} finally {
			try {
				pstm.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				connBD.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return pedidoEnviado;
	}

	/***********************************************************************************************************************************************************/

	private static String[] inicializaQueryNumero27(String[] ListaQuerys, InfoCliente infoCliente, String num_art,
			int cantidadPedida, int exietnciaCDO, int existenciaBR, float importe, String GeneraTraspaso,
			String cdoTraspaso, String pedidoEnCarrito) {
		for (int i = 0; i < ListaQuerys.length; i++) {
			ListaQuerys[i] = ListaQuerys[i].replace("{CVE_CENTRO}", String.valueOf(infoCliente.getCentro()));
			ListaQuerys[i] = ListaQuerys[i].replace("{CVE_CLIENTE}", String.valueOf(infoCliente.getCve_cliente()));
			ListaQuerys[i] = ListaQuerys[i].replace("{UNAME}", String.valueOf(infoCliente.getUname_cdo()));
			ListaQuerys[i] = ListaQuerys[i].replace("{NUM_ART}", num_art);
			ListaQuerys[i] = ListaQuerys[i].replace("{PRECIO_UNI}", String.valueOf(importe));
			int CantidadSurtida = exietnciaCDO + existenciaBR;
			ListaQuerys[i] = ListaQuerys[i].replace("{CANT_PEDIDO}", String.valueOf(cantidadPedida));
			ListaQuerys[i] = ListaQuerys[i].replace("{CANT_SURT}", String.valueOf(exietnciaCDO));
			ListaQuerys[i] = ListaQuerys[i].replace("{CANT_SURT_BR}", String.valueOf(existenciaBR));
			float importeArticulo = importe * CantidadSurtida;
			ListaQuerys[i] = ListaQuerys[i].replace("{IMPORTE}", String.valueOf(importeArticulo));
			ListaQuerys[i] = ListaQuerys[i].replace("{TRASPASO}", GeneraTraspaso);
			ListaQuerys[i] = ListaQuerys[i].replace("{CDO_TRASPASO}", cdoTraspaso);
			ListaQuerys[i] = ListaQuerys[i].replace("{NUM_PEDIDO}", pedidoEnCarrito);

		}
		return ListaQuerys;
	}

	private static String[] inicializaQueryNumero28(String[] ListaQuerys, InfoCliente infoCliente, String num_art,
			int exietnciaTraspaso, String cdoTraspaso, float importe) {
		for (int i = 0; i < ListaQuerys.length; i++) {
			ListaQuerys[i] = ListaQuerys[i].replace("{CVE_CENTRO}", String.valueOf(infoCliente.getCentro()));
			ListaQuerys[i] = ListaQuerys[i].replace("{CVE_CLIENTE}", String.valueOf(infoCliente.getCve_cliente()));
			ListaQuerys[i] = ListaQuerys[i].replace("{UNAME}", String.valueOf(infoCliente.getUname_cdo()));
			ListaQuerys[i] = ListaQuerys[i].replace("{NUM_ART}", num_art);
			ListaQuerys[i] = ListaQuerys[i].replace("{CANT_PEDIDO}", String.valueOf(exietnciaTraspaso));
			ListaQuerys[i] = ListaQuerys[i].replace("{PRECIO_UNI}", String.valueOf(importe));
			float importeArticulo = importe * exietnciaTraspaso;
			ListaQuerys[i] = ListaQuerys[i].replace("{IMPORTE}", String.valueOf(importeArticulo));
			ListaQuerys[i] = ListaQuerys[i].replace("{CDO_TRASPASO}", cdoTraspaso.toLowerCase());
		}
		return ListaQuerys;
	}

	private static String[] inicializaQueryNumero29(String[] ListaQuerys, InfoCliente infoCliente, String num_art,
			int cantidadPedida, int exietnciaCDO, int existenciaBR, float importe, String GeneraTraspaso,
			String cdoTraspaso, String num_pedido_carrito) {
		for (int i = 0; i < ListaQuerys.length; i++) {
			ListaQuerys[i] = ListaQuerys[i].replace("{CVE_CENTRO}", String.valueOf(infoCliente.getCentro()));
			ListaQuerys[i] = ListaQuerys[i].replace("{CVE_CLIENTE}", String.valueOf(infoCliente.getCve_cliente()));
			ListaQuerys[i] = ListaQuerys[i].replace("{UNAME}", String.valueOf(infoCliente.getUname_cdo()));
			ListaQuerys[i] = ListaQuerys[i].replace("{NUM_ART}", num_art);
			ListaQuerys[i] = ListaQuerys[i].replace("{PRECIO_UNI}", String.valueOf(importe));
			int CantidadSurtida = exietnciaCDO + existenciaBR;
			ListaQuerys[i] = ListaQuerys[i].replace("{CANT_PEDIDO}", String.valueOf(cantidadPedida));
			ListaQuerys[i] = ListaQuerys[i].replace("{CANT_SURT}", String.valueOf(exietnciaCDO));
			ListaQuerys[i] = ListaQuerys[i].replace("{CANT_SURT_BR}", String.valueOf(existenciaBR));
			float importeArticulo = importe * CantidadSurtida;
			ListaQuerys[i] = ListaQuerys[i].replace("{IMPORTE}", String.valueOf(importeArticulo));
			ListaQuerys[i] = ListaQuerys[i].replace("{TRASPASO}", GeneraTraspaso);
			ListaQuerys[i] = ListaQuerys[i].replace("{CDO_TRASPASO}", cdoTraspaso.toLowerCase());
			ListaQuerys[i] = ListaQuerys[i].replace("{NUM_PEDIDO}", num_pedido_carrito);
		}
		return ListaQuerys;
	}

	private static String[] inicializaQueryNumero30_51_52(String[] ListaQuerys, InfoCliente infoCliente,
			String transporte, String consignatario, String Pedido, String estatus) {

		for (int i = 0; i < ListaQuerys.length; i++) {
			ListaQuerys[i] = ListaQuerys[i].replace("{ESTATUS}", estatus);
			ListaQuerys[i] = ListaQuerys[i].replace("{TRANSPORTE}", transporte);
			ListaQuerys[i] = ListaQuerys[i].replace("{CONSIGNATARIO}", consignatario);
			ListaQuerys[i] = ListaQuerys[i].replace("{CVE_CENTRO}", String.valueOf(infoCliente.getCentro()));
			ListaQuerys[i] = ListaQuerys[i].replace("{CVE_CLIENTE}", String.valueOf(infoCliente.getCve_cliente()));
			ListaQuerys[i] = ListaQuerys[i].replace("{PEDIDO}", Pedido);
		}
		return ListaQuerys;
	}

	private static String[] inicializaQueryNumero45(String[] ListaQuerys, InfoCliente infoCliente) {
		for (int i = 0; i < ListaQuerys.length; i++) {
			ListaQuerys[i] = ListaQuerys[i].replace("{CVE_CENTRO}", String.valueOf(infoCliente.getCentro()));
			ListaQuerys[i] = ListaQuerys[i].replace("{CVE_CLIENTE}", String.valueOf(infoCliente.getCve_cliente()));
		}
		return ListaQuerys;
	}

	private static String[] inicializaQueryNumero31(String[] ListaQuerys, InfoCliente infoCliente, String cdoTraspaso) {

		for (int i = 0; i < ListaQuerys.length; i++) {
			ListaQuerys[i] = ListaQuerys[i].replace("{CVE_CENTRO}", String.valueOf(infoCliente.getCentro()));
			ListaQuerys[i] = ListaQuerys[i].replace("{CVE_CLIENTE}", String.valueOf(infoCliente.getCve_cliente()));
			ListaQuerys[i] = ListaQuerys[i].replace("{TRANSPORTE}", infoCliente.getTransporte_cdo());
			ListaQuerys[i] = ListaQuerys[i].replace("{CDO_TRASPASO}", cdoTraspaso.toLowerCase());
		}
		return ListaQuerys;
	}

	@SuppressWarnings("deprecation")
	public static String EvaluaHorasProceso(InfoCliente infoCliente, String Pedido) {
		Log log = null;
		String estatus = "17";
		try {

			log = new Log(0, infoCliente.getCve_cdo(), infoCliente.getCve_cliente(), Integer.parseInt(Pedido),
					"[Accion: Evaluando Horas de Proceso, Estatus Inicial 17.]");
			Cls_Log.insertaLog(log);

			Calendar c1 = Calendar.getInstance();

			Time horaEnvio = new Time(c1.getTime().getHours(), c1.getTime().getMinutes(), c1.getTime().getSeconds());

			// Valida Domingo
			if (c1.getTime().getDay() == 0) {
				log.setAccion("[Accion: Hora de procesamiento de pedidos dia Domingo: Estatus 17]");
				return "17";
			}

			// Valida Sabado
			if (c1.getTime().getDay() == 6) {

				if (infoCliente.getHoraSabadoIni().before(horaEnvio)
						&& infoCliente.getHoraSabadoFin().after(horaEnvio)) {

					estatus = "1";
				}
				log.setAccion("[Accion: Hora de procesamiento de pedidos dia Sabado, Hora de procesamiento de: "
						+ infoCliente.getHoraSabadoIni() + " a " + infoCliente.getHoraSabadoFin()
						+ ". Hora del pedido: " + horaEnvio.toString() + ".]");
			}

			// Valida luenas a viernes
			if (c1.getTime().getDay() >= 1 && c1.getTime().getDay() <= 5) {

				if (infoCliente.getHoraIni().before(horaEnvio) && infoCliente.getHoraFin().after(horaEnvio)) {

					estatus = "1";
				}
				log.setAccion("[Accion: Hora de procesamiento de pedidos de: " + infoCliente.getHoraIni() + " a "
						+ infoCliente.getHoraFin() + ". Hora del pedido: " + horaEnvio.toString() + ".]");
			}
			Cls_Log.insertaLog(log);

			log = new Log(0, infoCliente.getCve_cdo(), infoCliente.getCve_cliente(), Integer.parseInt(Pedido),
					"[Accion: Actualizacion de pedido, Estatus " + estatus + ".]");
			Cls_Log.insertaLog(log);
		} catch (Exception e) {
			log.setAccion(
					"[Error al Validar Hora de procesamiento de pedidos. Estatus de pedido  Actualizado a 18(Pendiente) clase: GestorAltaArticuloEnCarrito.EvaluaHorasProceso  "
							+ e.toString() + " ]");
			Cls_Log.insertaLog(log);
			estatus = "18";
		}

		return estatus;
	}

	private static void EnvioDeDorreo72Hrs(List<Querys> listaQuerys, InfoCliente infoCliente, int pedidoActualizado) {
		GestorEnvioCorreo72hrs gtr = new GestorEnvioCorreo72hrs();
		gtr.enviarCorreo(listaQuerys, infoCliente, pedidoActualizado);
	}
}
