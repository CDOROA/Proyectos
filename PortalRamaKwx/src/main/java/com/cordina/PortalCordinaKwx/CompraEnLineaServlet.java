package com.cordina.PortalCordinaKwx;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cordina.PortalCordinaKwx.dto.DelegacionDto;
import com.cordina.PortalCordinaKwx.dto.EstadosDto;
import com.cordina.PortalCordinaKwx.dto.clientesKwxDto;
import com.cordina.PortalCordinaKwx.dto.productosKwxDto;
import com.google.gson.Gson;

/**
 * Servlet implementation class CompraEnLineaServlet
 */
public class CompraEnLineaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public CompraEnLineaServlet() {
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

	@SuppressWarnings("unchecked")
	public void main(HttpServletRequest request, HttpServletResponse response)
	{
		try
		{
			//System.out.println(" 1. INICIO");
			int operacion = 1;
			int producto = 0;
			int estado = 0;
			int delegacion = 0;
			List<EstadosDto> listEstados= new ArrayList<EstadosDto>();
			List<productosKwxDto> lisArticulos = new ArrayList<productosKwxDto>();
			List<DelegacionDto> listDelegaciones= new ArrayList<DelegacionDto>();
			
			List<clientesKwxDto> listClientes= new ArrayList<clientesKwxDto>();
			
		//	System.out.println(" 2. INICIO");
			
			try
			{
				operacion = Integer.parseInt(request.getParameter("operacion"));
			}
			catch(Exception ex)
			{
				String sError= ex.getMessage().toString();
				System.out.println("PortalRama KWX - ERROR: " + sError);
			}
			
			//System.out.println(" 3. INICIO OPERACION= " + operacion);
			
			switch(operacion)
			{
				case 1:
						RequestDispatcher rd = request.getRequestDispatcher("/jsp/CompraEnLinea.jsp");
						rd.forward(request, response);
				break;
				
				
			}
		}
		catch(Exception ex)
		{
			String sError= ex.getMessage().toString();
		}
	}
	
	
}
