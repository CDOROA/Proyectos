package com.cordina.PortalCordinaKwx;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cordina.PortalCordinaKwx.Util.clsLog;
import com.cordina.PortalCordinaKwx.conexionBd.connectionManager;
import com.cordina.PortalCordinaKwx.conexionBd.connectionManagerV2;
import com.cordina.PortalCordinaKwx.dto.BannersDto;
import com.cordina.PortalCordinaKwx.dto.BlogSabiasQueDto;
import com.cordina.PortalCordinaKwx.dto.GaleriaVideosDto;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.servlet.RequestDispatcher;


public class ServletInicio extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private Connection conn;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
  
    public ServletInicio() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
        response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
        response.setHeader("Expires", "-1"); // Proxies.

		main(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
        response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
        response.setHeader("Expires", "-1"); // Proxies.

		main(request,response);
	}
	
	
	public void main(HttpServletRequest request, HttpServletResponse response)
	{
		// System.out.println("1. INICIA SERVLET " + request.getContextPath());
		
		try
		{
			int operacion = 1;
			try
			{
				operacion = Integer.parseInt(request.getParameter("operacion"));
			}
			catch(Exception ex)
			{
				String sError= ex.getMessage().toString();
				//System.out.println("main inicio operacion ERROR: " + sError);
			}
			
			//System.out.println("2. INICIA SERVLET OPCION= " + operacion);
			
			switch(operacion)
			{
				case 1:
					//System.out.println("2.1 INICIA SERVLET OPCION= " + operacion);
					List<BannersDto> listaBanners = new ArrayList<BannersDto>();
					listaBanners = ObtenBanners();
					//System.out.println("3. INICIA SERVLET OPCION= " + operacion);
					request.setAttribute("listaBanners", listaBanners);
					RequestDispatcher rd = request.getRequestDispatcher("/jsp/index.jsp");
					//System.out.println("4. INICIA SERVLET OPCION= " + operacion);
					rd.forward(request, response);
				break;
				
				case 2:					
					String productoMes= ObtenerProductoDelMes();
					request.setAttribute("productoMes", productoMes);
					RequestDispatcher rd1 = request.getRequestDispatcher("/jsp/ProductoDelMes.jsp");
					rd1.forward(request, response);
				break;
				
				case 3:
					List<GaleriaVideosDto> ListVideos= new ArrayList<GaleriaVideosDto>();
					ListVideos=ObtenerGaleriaVideos();
					request.setAttribute("listVideos", ListVideos);
					RequestDispatcher rd2= request.getRequestDispatcher("/jsp/GaleriaVideos.jsp");
					rd2.forward(request, response);
					//System.out.println("5. INICIA SERVLET ");
					
				break;
				
				/*case 4:
					List<BlogSabiasQueDto> listBlog = new ArrayList<BlogSabiasQueDto>();
					listBlog = BlogSabiasQue();
					request.setAttribute("listBlog", listBlog);
					RequestDispatcher rd3= request.getRequestDispatcher("/jsp/BlogSabiasQue.jsp");
					rd3.forward(request, response);
				break;*/
			}
		}
		catch(Exception ex)
		{
			String sError= ex.getMessage().toString();
		}
	}
	
	//OPCION 4 BLOGS SABIAS QUE?
	/*public List<BlogSabiasQueDto> BlogSabiasQue()
	{
		List<BlogSabiasQueDto> listBlog =new ArrayList<BlogSabiasQueDto>();
		try
		{
			String Qry = "SELECT 	cve_blog, "+
									"titulo, "+
									"subtitulo, "+
									"fecha, "+
									"IFNULL(parrafo1, 'N-A') AS parrafo1, "+
									"IFNULL(parrafo2, 'N-A') AS parrafo2, "+
									"IFNULL(parrafo3, 'N-A') AS parrafo3, "+
									"IFNULL(parrafo4, 'N-A') AS parrafo4, "+
									"imagen, "+
									"IFNULL(parrafo5, 'N-A') AS parrafo5, "+
									"IFNULL(parrafo6, 'N-A') AS parrafo6, "+
									"IFNULL(parrafo7, 'N-A') AS parrafo7, "+
									"IFNULL(parrafo8, 'N-A') AS parrafo8, "+
									"url_video, "+
									"descripcion_video "+
							"FROM  	comercio_electronico.c_blog_sabiasQue  "+
							"ORDER BY id_blog DESC;";
			
			
			ResultSet rs_blog = CrearConexionBaseDatos(Qry);	
			int index = 1;
			if(rs_blog != null)
			{
	    		while (rs_blog.next())
	    		{
		    		try
		    		{
		    			BlogSabiasQueDto blog= new BlogSabiasQueDto();
		    			blog.setIndex(index);
		    			blog.setId_blog(rs_blog.getInt("cve_blog"));
		    			blog.setTitulo1(rs_blog.getString("titulo"));
		    			blog.setTitulo2(rs_blog.getString("subtitulo"));
		    			blog.setFecha(rs_blog.getString("fecha"));
		    			blog.setParrafo1(rs_blog.getString("parrafo1"));
		    			blog.setParrafo2(rs_blog.getString("parrafo2"));
		    			blog.setParrafo3(rs_blog.getString("parrafo3"));
		    			blog.setParrafo4(rs_blog.getString("parrafo4"));
		    			blog.setImagen(rs_blog.getString("imagen"));
		    			blog.setParrafo5(rs_blog.getString("parrafo5"));
		    			blog.setParrafo6(rs_blog.getString("parrafo6"));
		    			blog.setParrafo7(rs_blog.getString("parrafo7"));
		    			blog.setParrafo8(rs_blog.getString("parrafo8"));
		    			blog.setUrl_video(rs_blog.getString("url_video"));
		    			blog.setDescripcion_video(rs_blog.getString("descripcion_video"));
		    			listBlog.add(blog);
		    			index++;
		    		}
		    		catch(Exception ex)
		    		{
		    			String sError = ex.getMessage().toString();
		    		}
	    		}
			}
		}
		catch(Exception ex)
		{
			String sError= ex.getMessage().toString();
		}
		return listBlog;
	}
	*/
	
	//OPCION 3 GALERIA DE VIDEOS
	public List<GaleriaVideosDto> ObtenerGaleriaVideos()
	{
		List<GaleriaVideosDto> ListVideos= new ArrayList<GaleriaVideosDto>();
		
		try
		{
			// System.out.println("3. INICIA SERVLET ");
			String Qry= "SELECT * "+
						"FROM 	KWX.c_galeria_videos "+
						"ORDER BY fecha,  cve_video;";
			
			ResultSet rs_Videos= CrearConexionBaseDatos(Qry);		
			int cont = 1;
			if(rs_Videos != null)
			{
	    		while (rs_Videos.next())
	    		{
		    		try
		    		{
		    			if(cont == 5)
		    			{
		    				cont=1;
		    			}
		    			
		    			GaleriaVideosDto video = new GaleriaVideosDto();
		    			video.setIndex(cont);
		    			video.setId_video(rs_Videos.getInt("cve_video"));
		    			video.setDescripcion(rs_Videos.getString("descripcion"));
		    			video.setUrl_imagen(rs_Videos.getString("url_imagen"));
		    			video.setUrl_video(rs_Videos.getString("url_video"));
		    			video.setFecha(rs_Videos.getString("fecha"));
		    			ListVideos.add(video);
		    			cont++;
		    		}
		    		catch(Exception ex)
		    		{
		    			String sError= ex.getMessage().toString();
		    			CierraConexion();
		    		}
	    		}
			}
		//	System.out.println("4. INICIA SERVLET ");
			CierraConexion();
		}
		catch(Exception e)
		{
			String sError= e.getMessage().toString();
			clsLog.RegistraLog("ServletInicio.ObtenerGaleriaVideos", "getLocalizedMessage: "+ e.getLocalizedMessage().replace("'",""));
			clsLog.RegistraLog("ServletInicio.ObtenerGaleriaVideos", "getMessage: "+ e.getMessage().replace("'",""));
			clsLog.RegistraLog("ServletInicio.ObtenerGaleriaVideos", "getCause: "+ e.getClass().getName().replace("'",""));
			clsLog.RegistraLog("ServletInicio.ObtenerGaleriaVideos", "getClass().getName: "+ e.getLocalizedMessage().replace("'",""));
		}
		return ListVideos;
	}
		
	
	//OPCION 2 PRODUCTOS DEL MES
	public String ObtenerProductoDelMes()
	{
		String productoMes = "";
		
		try
		{
			String Qry ="SELECT * FROM KWX.c_producto_mes;";
			ResultSet rs_producto= CrearConexionBaseDatos(Qry);	
			if(rs_producto != null)
			{
	    		while (rs_producto.next())
	    		{
		    		try
		    		{
		    			productoMes = rs_producto.getString("descripcion");
		    		}
		    		catch(Exception ex)
		    		{
		    			String sError= ex.getMessage().toString();
		    			CierraConexion();
		    		}
	    		}
			}
			CierraConexion();
			
		}
		catch(Exception e)
		{
			String sError= e.getMessage().toString();
			clsLog.RegistraLog("ServletInicio.ObtenerProductoDelMes", "getLocalizedMessage: "+ e.getLocalizedMessage().replace("'",""));
			clsLog.RegistraLog("ServletInicio.ObtenerProductoDelMes", "getMessage: "+ e.getMessage().replace("'",""));
			clsLog.RegistraLog("ServletInicio.ObtenerProductoDelMes", "getCause: "+ e.getClass().getName().replace("'",""));
			clsLog.RegistraLog("ServletInicio.ObtenerProductoDelMes", "getClass().getName: "+ e.getLocalizedMessage().replace("'",""));
		}
		return productoMes;
	}
	
	
	//OPCION 1 BANNERS
	public List<BannersDto> ObtenBanners()
	{		
		//System.out.println("2.2 INICIA SERVLET OPCION");
		List<BannersDto> listaBanners = new ArrayList<BannersDto>();
		
		try
		{
			
		//	System.out.println("3. INICIA SERVLET OPCION");
			String Qry = "SELECT  	cve_banners, "+
									"nombre, "+
									"imagen, "+
									"duracion, "+
									"num_orden "+
							"FROM 	KWX.c_banners where estatus  = 'A'" +
						//	"FROM 	KWX.c_banners " +
							"ORDER BY num_orden ASC;"; 
			ResultSet rs_Baners= CrearConexionBaseDatos(Qry);		
						
		//	System.out.println("4. INICIA SERVLET OPCION");
			if(rs_Baners != null)
			{
	    		while (rs_Baners.next())
	    		{
		    		try
		    		{
		    			BannersDto banner = new BannersDto();
		    			banner.setId_banners(rs_Baners.getInt("cve_banners"));
		    			banner.setNombre(rs_Baners.getString("nombre"));
		    			banner.setImagen(rs_Baners.getString("imagen"));
		    			banner.setDuracion(rs_Baners.getInt("duracion"));
		    			banner.setNum_orden(rs_Baners.getInt("num_orden"));
		    		//	System.out.println("banner: " + banner);
		    			listaBanners.add(banner);
		    		}
		    		catch(Exception ex)
		    		{
		    			String sError= ex.getMessage().toString();
		    			CierraConexion();
		    		}
	    		}
			}
		//	System.out.println("5. INICIA SERVLET OPCION");
			CierraConexion();
		}
		catch(Exception e)
		{
			String sError= e.getMessage().toString();
			clsLog.RegistraLog("ServletInicio.ObtenBanners", "getLocalizedMessage: "+ e.getLocalizedMessage().replace("'",""));
			clsLog.RegistraLog("ServletInicio.ObtenBanners", "getMessage: "+ e.getMessage().replace("'",""));
			clsLog.RegistraLog("ServletInicio.ObtenBanners", "getCause: "+ e.getClass().getName().replace("'",""));
			clsLog.RegistraLog("ServletInicio.ObtenBanners", "getClass().getName: "+ e.getLocalizedMessage().replace("'",""));
		}
		return listaBanners;
	}
	
	public ResultSet CrearConexionBaseDatos(String sql)
	{
		ResultSet rs1= null;
		try
			{
				//System.out.println("3.1 INICIA SERVLET OPCION");
				conn = connectionManagerV2.getConnection();
				pstmt = conn.prepareStatement(sql);
				//System.out.println("3.2 INICIA SERVLET OPCION");
				rs1 = pstmt.executeQuery();
				
			}catch(Exception e)
			{
				CierraConexion();
				String sError= e.getMessage().toString();
				System.out.println("PortalRama KWX - ERROR EJECU. QUERY: " +  sError);
				clsLog.RegistraLog("PortalRama KWX - ServletInicio.CrearConexionBaseDatos", "getLocalizedMessage: "+ e.getLocalizedMessage().replace("'",""));
				clsLog.RegistraLog("PortalRama KWX - ServletInicio.CrearConexionBaseDatos", "getMessage: "+ e.getMessage().replace("'",""));
				clsLog.RegistraLog("PortalRama KWX - ServletInicio.CrearConexionBaseDatos", "getCause: "+ e.getClass().getName().replace("'",""));
				clsLog.RegistraLog("PortalRama KWX - ServletInicio.CrearConexionBaseDatos", "getClass().getName: "+ e.getLocalizedMessage().replace("'",""));
			}
		return rs1;
	}
	
	public void CierraConexion()
	{
		try
		{
			connectionManagerV2.closeConnection(conn);
			
		}catch(Exception ex)
		{
			String sError= ex.getMessage().toString();
			System.out.println("PortalRama KWX - ERROR CierraConexion: " +  sError);
		}
	}
	

}
