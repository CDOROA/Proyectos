package web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletQuienesSomos extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ServletQuienesSomos() {
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
	//		consultaQuerys();
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
						RedirecionaVista("QuienesSomos.jsp", request, response);
				break;

		}
		}
		catch(Exception ex)
		{
			String sError= ex.getMessage().toString();
			System.out.println("error en ServletQuienesSomos.ValidaPeticion = " + ex);
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
}
