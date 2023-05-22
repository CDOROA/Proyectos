package web;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import datos.Banners;
import datos.Querys;
import datos.Videos;
import persistencia.GestorPaginaPrincipal;
import persistencia.GestorVideos;
import util.ConexionBD;

public class ServletVideos extends HttpServlet {
	private static final long serialVersionUID = 1L;
	List<Querys> querys = null;      

    public ServletVideos() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		ValidaPeticion(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

	public void ValidaPeticion(HttpServletRequest request, HttpServletResponse response)
	{
			consultaQuerys();
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
				operacion = 1;
			}
					
			switch(operacion)
			{
				case 1:
					List<Videos> ListVideos= new ArrayList<Videos>();
					ListVideos=ObtenListaVideos();
					request.setAttribute("listaVideos", ListVideos);
					
						RedirecionaVista("Videos.jsp", request, response);			
				break;

		}
		}
		catch(Exception ex)
		{
			String sError= ex.getMessage().toString();
			System.out.println("[ Portal OEP ] error en ServletVideos.ValidaPeticion = " + ex);
		}
	
	}
	
	private void RedirecionaVista(String pagina, HttpServletRequest request, HttpServletResponse response)
	{
		try {
	RequestDispatcher rd = request.getRequestDispatcher("/jsp/" + pagina);
	
	
		rd.forward(request, response);
	} catch (Exception e) {

		
	}
	}
	
	private void consultaQuerys() {
		Connection connBD = null;
		try
		{
		connBD = ConexionBD.abrirConexionBD();
		this.querys = null;
		this.querys = GestorPaginaPrincipal.ConsultaTablaQuerysBD(connBD);
	}
	catch(Exception ex)
	{
		String sError= ex.getMessage().toString();
		System.out.println("[ Portal OEP ] ServletPaginaPrincipal.consultaQuerys Error: " + sError);
	}
		finally {
			try {connBD.close();} catch (SQLException e) {e.printStackTrace();}
		}
	}
	
	private List<Videos> ObtenListaVideos() {
		Connection connBD = null;
		List<Videos> listaVideos =null;
		try
		{
			connBD = ConexionBD.abrirConexionBD();
			listaVideos = GestorVideos.ObtenVideos(connBD, this.querys);
		}
		catch(Exception ex)
		{
			String sError= ex.getMessage().toString();
			System.out.println("[ Portal OEP ] ServletVideos.ObtenListaVideos Error: " + sError);
		}
			finally {
				try {connBD.close();} catch (SQLException e) {e.printStackTrace();}
			}
		return listaVideos;
		}
}
