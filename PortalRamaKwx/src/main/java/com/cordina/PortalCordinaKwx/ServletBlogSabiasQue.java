package com.cordina.PortalCordinaKwx;

import javax.servlet.http.HttpServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cordina.PortalCordinaKwx.Util.clsLog;
import com.cordina.PortalCordinaKwx.conexionBd.connectionManager;
import com.cordina.PortalCordinaKwx.conexionBd.connectionManagerV2;
import com.cordina.PortalCordinaKwx.conexionBd.connectionManagerV3;
import com.cordina.PortalCordinaKwx.dto.BlogSabiasQueDto;
import com.cordina.PortalCordinaKwx.dto.EstadosDto;
import com.cordina.PortalCordinaKwx.dto.GaleriaVideosDto;
import com.cordina.PortalCordinaKwx.dto.HistorialBlogSabiasDto;
import com.cordina.PortalCordinaKwx.dto.HistorialDto;
import com.google.gson.Gson;

public class ServletBlogSabiasQue extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private Connection conn;
	PreparedStatement pstmt = null;
	ResultSet rs = null;       
   
	 public ServletBlogSabiasQue() {
	        super();
	        
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
		try
		{
			int operacion = 1;
			int cve_blog = 0;
			BlogSabiasQueDto BlogActivo =new BlogSabiasQueDto();
			HistorialBlogSabiasDto ListHistorial= new HistorialBlogSabiasDto();
			List<HistorialBlogSabiasDto> ListHistorialBlog= new ArrayList<HistorialBlogSabiasDto>();
						
			try
			{
				operacion = Integer.parseInt(request.getParameter("operacion"));
				cve_blog = Integer.parseInt(request.getParameter("cve_blog"));
			}
			catch(Exception ex)
			{
				String sError= ex.getMessage().toString();
			}
			
			switch(operacion)
			{
				case 0:
					RequestDispatcher rd1 = request.getRequestDispatcher("/jsp/BlogSabiasQue.jsp");
					rd1.forward(request, response);
				break;
			
			
				case 1:
					String fechaActual = buscaFechaActual();
					String[]fechaAc = fechaActual.split("-");
					String anio = fechaAc[0];
					String mes = fechaAc[1];
				
					if(mes.length()<2) {
						mes = "0"+mes;
					}
					String FechaMod =  anio+"-"+mes; 
					if(!fechaActual.equals("")) {
						BlogActivo = ObtieneBlog(cve_blog, FechaMod);
					}					
					request.setAttribute("BlogActivo", BlogActivo);
					Gson gson = new Gson();
					String listaJson =gson.toJson(BlogActivo);
					response.setContentType("application/json");
					PrintWriter out = response.getWriter();
					out.write(listaJson);
					break;
				
				case 2:
					ListHistorialBlog = ObtineHistorialBlog();
					request.setAttribute("ListHistorial", ListHistorialBlog);					
					Gson gson1 = new Gson();
					String listaJson1 =gson1.toJson(ListHistorialBlog);
					response.setContentType("application/json");
					PrintWriter out1 = response.getWriter();
					out1.write(listaJson1);
					break;
			}
			
		}
		catch(Exception ex)
		{
			String sError= ex.getMessage().toString();
		}
	}
	
	public List<HistorialBlogSabiasDto> ObtineHistorialBlog()
	{
		List<HistorialBlogSabiasDto> ListHistorialBlog= new ArrayList<HistorialBlogSabiasDto>();
		
		try
		{
			String Qry = "	SELECT 	X.year,  "+
									 "SUM(X.cont_year) AS cont_year,    "+
									 "GROUP_CONCAT(CONCAT(CAST(X.mes AS CHAR), '(' ,CAST(X.cont_mes AS CHAR)), ') ' SEPARATOR '|') AS meses,    "+
									 "GROUP_CONCAT( X.titulos SEPARATOR '|') AS titulos    "+
							  "FROM     "+
							 "(   "+
								 "SELECT  year,    "+
										 "COUNT(year) cont_year,    "+
										 "CASE  "+
												"WHEN mes = 01 THEN 'ENERO'  "+
												"WHEN mes = 02 THEN 'FEBRERO'  "+
												"WHEN mes = 03 THEN 'MARZO'  "+
												"WHEN mes = 04 THEN 'ABRIL'  "+
												"WHEN mes = 05 THEN 'MAYO'  "+
												"WHEN mes = 06 THEN 'JUNIO'  "+
												"WHEN mes = 07 THEN 'JULIO'  "+
												"WHEN mes = 08 THEN 'AGOSTO'  "+
												"WHEN mes = 09 THEN 'SEPTIEMBRE'  "+
												"WHEN mes = 10 THEN 'OCTUBRE'  "+
												"WHEN mes = 11 THEN 'NOVIEMBRE'  "+
												"WHEN mes = 12 THEN 'DICIEMBRE'  "+
										"END mes,    "+
										"COUNT(mes) cont_mes,    "+
										"GROUP_CONCAT( "+
													"CONCAT(CASE  "+
																"WHEN mes = 01 THEN 'ENERO'  "+
																"WHEN mes = 02 THEN 'FEBRERO'  "+
																"WHEN mes = 03 THEN 'MARZO'  "+
																"WHEN mes = 04 THEN 'ABRIL'  "+
																"WHEN mes = 05 THEN 'MAYO'  "+
																"WHEN mes = 06 THEN 'JUNIO'  "+
																"WHEN mes = 07 THEN 'JULIO'  "+
																"WHEN mes = 08 THEN 'AGOSTO'  "+
																"WHEN mes = 09 THEN 'SEPTIEMBRE'  "+
																"WHEN mes = 10 THEN 'OCTUBRE'  "+
																"WHEN mes = 11 THEN 'NOVIEMBRE'  "+
																"WHEN mes = 12 THEN 'DICIEMBRE'  "+
														"END, '-', cve_blog ,'-',titulo) SEPARATOR '|') AS titulos   "+
								 "FROM 	KWX.c_blog_sabiasQue    "+
								 "GROUP BY year, mes    "+
							 ") AS X    "+
							 "GROUP BY X.year   ";
			ResultSet rs_blog = CrearConexionBaseDatos(Qry);
			if(rs_blog != null)
			{
	    		while (rs_blog.next())
	    		{
		    		try
		    		{
		    			HistorialBlogSabiasDto ListHistorial= new HistorialBlogSabiasDto();
		    			HistorialDto  historial = new HistorialDto();
		    			historial.setYear(rs_blog.getInt("year"));
		    			historial.setCount_year(rs_blog.getInt("cont_year"));
		    			historial.setMeses( rs_blog.getString("meses"));
		    			historial.setTitulo( rs_blog.getString("titulos"));
		    			ListHistorial.setHistorial(historial);
		    			ListHistorialBlog.add(ListHistorial);
		    		}
		    		catch(Exception ex)
		    		{
		    			String sErrror= ex.getMessage();
		    			CierraConexion();
		    		}
		    		
	    		}
			}
			CierraConexion();
			
		}
		catch(Exception e)
		{
			String sError= e.getMessage().toString();
			clsLog.RegistraLog("ServletBlogSabiasQue.ObtineHistorialBlog", "getLocalizedMessage: "+ e.getLocalizedMessage().replace("'",""));
			clsLog.RegistraLog("ServletBlogSabiasQue.ObtineHistorialBlog", "getMessage: "+ e.getMessage().replace("'",""));
			clsLog.RegistraLog("ServletBlogSabiasQue.ObtineHistorialBlog", "getCause: "+ e.getClass().getName().replace("'",""));
			clsLog.RegistraLog("ServletBlogSabiasQue.ObtineHistorialBlog", "getClass().getName: "+ e.getLocalizedMessage().replace("'",""));
		}
		
		return ListHistorialBlog;
	}
	
	public BlogSabiasQueDto ObtieneBlog(int id_blog, String fechaActual)
	{
		// System.out.println("22.BLOG  " );
		BlogSabiasQueDto listBlog =new BlogSabiasQueDto();
		
		try
		{
			int blogAnt =  (id_blog - 1);
		//	System.out.println("2.BLOG  " + blogAnt);
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
									"url_video, " +
									"img_video, "+
									"descripcion_video," +
									"mes," +
									"year  "+
							"FROM  	KWX.c_blog_sabiasQue  ";
			if(id_blog == 0)
			{
				Qry += " WHERE fecha LIKE '"+fechaActual+"%'";
				Qry += " ORDER BY fecha ASC LIMIT 2; ";
			}
			else
			{
				if(blogAnt == 0)
				{
					Qry += " WHERE 	cve_blog IN(" +id_blog+ ", (SELECT  MAX(cve_blog) FROM  KWX.c_blog_sabiasQue)) " +
						   " ORDER BY cve_blog ASC ";
				}
				else
				{
					Qry += " WHERE 	cve_blog IN(" +id_blog+ ", "+ blogAnt +") "+
						   " ORDER BY cve_blog DESC ";
				}
			}
			ResultSet rs_blog = CrearConexionBaseDatos(Qry);
			int cont=1;
			if(rs_blog != null)
			{
	    		while (rs_blog.next())
	    		{
		    		try
		    		{
		    			if(cont == 1)
		    			{
			    			listBlog.setId_blog(rs_blog.getInt("cve_blog"));
			    			listBlog.setTitulo1(rs_blog.getString("titulo"));
			    			listBlog.setTitulo2(rs_blog.getString("subtitulo"));
			    			listBlog.setFecha(rs_blog.getString("fecha"));
			    			listBlog.setParrafo1(rs_blog.getString("parrafo1"));
			    			listBlog.setParrafo2(rs_blog.getString("parrafo2"));
			    			listBlog.setParrafo3(rs_blog.getString("parrafo3"));
			    			listBlog.setParrafo4(rs_blog.getString("parrafo4"));
			    			listBlog.setImagen(rs_blog.getString("imagen"));
			    			listBlog.setParrafo5(rs_blog.getString("parrafo5"));
			    			listBlog.setParrafo6(rs_blog.getString("parrafo6"));
			    			listBlog.setParrafo7(rs_blog.getString("parrafo7"));
			    			listBlog.setParrafo8(rs_blog.getString("parrafo8"));
			    			listBlog.setUrl_video(rs_blog.getString("url_video"));
			    			listBlog.setImg_video(rs_blog.getString("img_video"));
			    			listBlog.setDescripcion_video(rs_blog.getString("descripcion_video"));
			    			listBlog.setMes(rs_blog.getString("mes"));
			    			listBlog.setYear(rs_blog.getString("year"));
			    			listBlog.setDescripcion_anterior("");
			    			listBlog.setImg_anterior("");
			    			cont++;
		    			}
		    			else if(cont == 2)
		    			{
		    				listBlog.setDescripcion_anterior(rs_blog.getString("titulo"));
			    			listBlog.setImg_anterior(rs_blog.getString("imagen"));
		    			}	
		    		}
		    		catch(Exception ex)
		    		{
		    			String sError = ex.getMessage().toString();
		    			CierraConexion();
		    		}
	    		}
			}
			CierraConexion();			
		}
		catch(Exception ex)
		{
			String sError= ex.getMessage().toString();
		}
		return listBlog;
	}
	
	public String buscaFechaActual() {
		String fechaActual = "";
		Connection connBD = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			
			String qry = "SELECT CONCAT(YEAR(NOW()),'-', MONTH (NOW())) as mesActual;";
			connBD = connectionManagerV3.getConnection();
			pstmt = connBD.prepareStatement(qry);
			rs = pstmt.executeQuery();
			if (rs != null) {

				if (rs.next()) {
					rs.beforeFirst();
					while (rs.next()) {
						fechaActual = rs.getString("mesActual");	
					}					
				}
			}

		} catch (Exception ex) {
			System.out.println("Error al consultar Mantenimientowx.GestorOpciones.buscaFechaActual: "+ex.toString());
		} finally {
			try {
				connBD.close();
				pstmt.close();
			} catch (SQLException e) {
				System.out.println(e.toString());
			}
		}
		return fechaActual;
	}
	
	public ResultSet CrearConexionBaseDatos(String sql)
	{
		ResultSet rs1= null;
		try
			{
				conn = connectionManagerV3.getConnection();
				pstmt = conn.prepareStatement(sql);
				rs1 = pstmt.executeQuery();
				
			}catch(Exception e)
			{
				CierraConexion();
				clsLog.RegistraLog("PortalRama KWX - ServletSoyMecanico.CargaInformacionBD", "getLocalizedMessage: "+ e.getLocalizedMessage());
				clsLog.RegistraLog("PortalRama KWX - ServletSoyMecanico.CargaInformacionBD", "getMessage: "+ e.getMessage());
				clsLog.RegistraLog("PortalRama KWX - ServletSoyMecanico.CargaInformacionBD", "getCause: "+ e.getClass().getName());
				clsLog.RegistraLog("PortalRama KWX - ServletSoyMecanico.CargaInformacionBD", "getClass().getName: "+ e.getLocalizedMessage());
			}
		return rs1;
	}
	
	public void CierraConexion()
	{
		try
		{
			connectionManagerV3.closeConnection();
			
		}catch(Exception ex)
		{
			String sError= ex.getMessage().toString();
			System.out.println("PortalRama KWX - ERROR CierraConexion: " +  sError);
		}
	}
	
}

