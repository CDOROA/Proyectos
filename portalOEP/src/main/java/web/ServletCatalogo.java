package web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletCatalogo extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ServletCatalogo() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RedirecionaVista("Catalogo.jsp", request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
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
