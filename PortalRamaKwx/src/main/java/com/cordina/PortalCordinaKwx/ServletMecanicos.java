package com.cordina.PortalCordinaKwx;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
public class ServletMecanicos extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	  
    public ServletMecanicos() {
        super();
      
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	//	System.out.println("ENTRO MECANICOS");
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
        response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
        response.setHeader("Expires", "-1"); // Proxies.
 
		main( request,  response);
	}

	   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
        response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
        response.setHeader("Expires", "-1"); // Proxies.
 
		main( request,  response);
	}

	public void main(HttpServletRequest request, HttpServletResponse response)
	{
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
				System.out.println("PortalRama KWX - ERROR: " + sError);
			}
			switch(operacion)
			{
				case 1:
					RequestDispatcher rd = request.getRequestDispatcher("/jsp/Mecanicos.jsp");
					rd.forward(request, response);	
				break;	
				
				
			}
		}
		catch(Exception ex)
		{
			String sError= ex.getMessage().toString();
			System.out.println("PortalRama KWX - error mecanicos Servlet: " + sError);
		}
	}
}

