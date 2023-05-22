package Persistencia;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;

import org.json.JSONArray;
import org.json.JSONObject;

import Datos.Usuario;

public class GestorUsuarios extends HttpServlet{
	private static final long serialVersionUID = 1L;

	 private Client cliente = null;
	 
	   private static final String URI_USUARIO = "http://ws2:8080/wsValidaUsuarios/ws/usuario/proceso";

	   public GestorUsuarios() {
	         super();
	        
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
	   public Usuario consultaUsuario(String cdo, String base, String usuario, String password, int proWeb)
	   {
		   String Parametros = "";
		   Usuario usr = new Usuario();
		   try {
				Parametros = "?cdo=" + cdo.toUpperCase() + "&base=" + base.toUpperCase() + "&usuario=" + usuario +
						"&password=" + password + "&numProcWeb="+ proWeb;
				

				String cadUsisario = this.cliente.target(URI_USUARIO + Parametros)
						.request(MediaType.APPLICATION_JSON).get(String.class);
				//System.out.print(cadUsisario);
				JSONArray jsonArrayMenu = new JSONArray(cadUsisario);
			

				for (int i = 0; i < jsonArrayMenu.length(); i++) {
					JSONObject rs = jsonArrayMenu.getJSONObject(i);
					usr.setCveUsuario(rs.getString("cveUsuario"));
					usr.setDatoAlfanumerico1(rs.getString("datoAlfanumerico1"));
					usr.setDatoAlfanumerico2(rs.getString("datoAlfanumerico2"));
					usr.setDatoNumerico1(rs.getInt("datoNumerico1"));
					usr.setDatoNumerico2(rs.getInt("datoNumerico2"));
					usr.setDepartamento(rs.getInt("departamento"));
					usr.setImpresoras(rs.getString("impresoras"));
					usr.setNivelUsuario(rs.getInt("nivelUsuario"));
					usr.setNombre(rs.getString("nombre"));
					usr.setNombreCotro(rs.getString("nombreCotro"));
					usr.setNombreDepartamento(rs.getString("nombreDepartamento"));
					usr.setNombreProcesoWeb(rs.getString("nombreProcesoWeb"));
					usr.setProcesoWeb(rs.getInt("procesoWeb"));
					usr.setRuta(rs.getString("ruta"));
					usr.setTipoProceso(rs.getString("tipoProceso"));
					usr.setTipoUsuario(rs.getInt("tipoUsuario"));
					usr.setUname(rs.getString("uname"));
					usr.setUnameBr(rs.getString("unameBr"));
					usr.setUnames(rs.getString("unames"));
					usr.setUrl(rs.getString("url"));
					usr.setUsoImpresora(rs.getString("usoImpresora"));
					usr.setUsuarioEnProcesoWeb(rs.getString("usuarioEnProcesoWeb"));
					//System.out.println(usr);
				}
				
				return usr;
			} catch (Exception ex) {
				String uri = "GET " + URI_USUARIO + Parametros;
				// this.invocarVistaError(ex, uri, request, response);
				System.out.println("error uri : " + uri);
				System.out.println("error consultaProcesosUsuario : " + ex);
				return usr;
			}
	   }
}