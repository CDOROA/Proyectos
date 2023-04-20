package cdo.Web;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class DownloadServlet
 */
@WebServlet("/DownloadServlet")
public class DownloadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DownloadServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet( HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
        response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
        response.setHeader("Expires", "-1"); // Proxies.

		HttpSession session = request.getSession(true);
		if (session != null) 
		{
			String ar = session.getAttribute("urlExcel").toString();
	    	
	    	String fileName = "/tmp/"+ar;
//	    	String fileName = "C:\\FTP\\"+ar;
	        String fileType = "application/vnd.ms- excel";
	        // Find this file id in database to get file name, and file type

	        // You must tell the browser the file type you are going to send
	        // for example application/pdf, text/plain, text/html, image/jpg
	        response.setContentType(fileType);

	        // Make sure to show the download dialog
	        response.setHeader("Content-disposition","attachment; filename="+ar+"");

	        // Assume file name is retrieved from database
	        // For example D:\\file\\test.pdf

	        File my_file = new File(fileName);

	        // This should send the file to browser
	        OutputStream out = response.getOutputStream();
	        FileInputStream in = new FileInputStream(my_file);
	        byte[] buffer = new byte[4096];
	        int length;
	        while ((length = in.read(buffer)) > 0){
	           out.write(buffer, 0, length);
	        }
	        in.close();
	        out.flush();
	    	//String[] commandEliminarArchivo = {"sh","-c","rm " +"/tmp/"+ar};
	    //	final Process processEliminar = Runtime.getRuntime().exec(commandEliminarArchivo);
		}
		else
		{
			if (session == null) 
			{
				RequestDispatcher rdIndex = request.getRequestDispatcher("/index.jsp");
				rdIndex.forward(request, response);
				return;
			}
		}
    	

   }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
