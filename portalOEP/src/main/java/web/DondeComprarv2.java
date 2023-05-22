package web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DondeComprarv2
 */
public class DondeComprarv2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
    

    public DondeComprarv2() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RedirecionaVista("DondeComprar2.jsp",request,response);
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
