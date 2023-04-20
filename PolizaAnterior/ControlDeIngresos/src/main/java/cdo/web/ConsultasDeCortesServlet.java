package cdo.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import cdo.Datos.ConsultaCortesCaja;
import cdo.Datos.CorteDeCaja;
import cdo.Datos.CortePanamericano;
import cdo.Datos.PolizaCompleta;
import cdo.Datos.PrevioCorteCaja;
import cdo.Datos.Querys;
import cdo.Datos.Usuario;
import cdo.Persistencia.GestorConsultaDeCortes;

public class ConsultasDeCortesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static List<Querys> querys =null;
	GestorConsultaDeCortes gestorConsultas;
       
    public ConsultasDeCortesServlet() {
        super();
        gestorConsultas = new GestorConsultaDeCortes();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(false);
		if(session!=null)
		{
			this.querys = (List<Querys>) session.getAttribute("querys");
			VerificaPeticionOrigen(request, response,session );		
		}  
		else
		{  
			if(session == null)
			{
				System.out.println("Consultas de Cortes: Session no valida ");
				request.getRequestDispatcher("/index.jsp").forward(request, response);
				return;
			}
		}  
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	private void VerificaPeticionOrigen(HttpServletRequest request, HttpServletResponse response, HttpSession session) 
	{
		String vista= String.valueOf(request.getParameter("vista"));	
		String operacion= String.valueOf(request.getParameter("operacion"));
		String pagina ="";
		Gson gson = new Gson();		
		
		switch(vista)
		{
			case "Menu.html":
				pagina = "ConsultaDeCortes.jsp";
				redireccionarVista(request, response,pagina);
			break;
			
			case "ConsultasDeCortes.jsp":
				switch(operacion)
				{
					case "ConsultarCortesCaja":
						ConsultaCortesCaja previoCorteCaja = consultaCortesDeCajaBD(request, session);
						String listaJsonDetalleXFolio = gson.toJson(previoCorteCaja);
						enviarRespuestaJsonJS(request,response, listaJsonDetalleXFolio);
						break;
					
					case "ConsultarCortesPoliza":
						PolizaCompleta polizaCompleta = consultaCortesDePolizaBD(request, session);
						String listaJsonpolizaCompleta = gson.toJson(polizaCompleta);
						enviarRespuestaJsonJS(request,response, listaJsonpolizaCompleta);
						break;
						
					case "ConsultarCortesPanamericano":
						CortePanamericano cortePanamericano = consultaCortesDePanamericanoBD(request, session);
						String listaJsonPanamericano= gson.toJson(cortePanamericano);
						enviarRespuestaJsonJS(request,response, listaJsonPanamericano);
						break;
				}
			break;
			
		}
	}
	
	private CortePanamericano consultaCortesDePanamericanoBD(HttpServletRequest request, HttpSession session)
	{
		Usuario infoUsu= (Usuario) session.getAttribute("infoUsu");	
		String fechaCortePanamericano = request.getParameter("fechaCortePanamericano").toString();
		String uname_br_consulta = request.getParameter("uname_consulta").toString();
		String folioCortePanamericano = (request.getParameter("folioCortePanamericano").toString().equals("")||
								 request.getParameter("folioCortePanamericano").toString().equals("0")) ? " 0" : request.getParameter("folioCortePanamericano").toString();
		
		CortePanamericano cortePanamericano = gestorConsultas.consultarCortesDePanamericanoEnBD(infoUsu, this.querys, fechaCortePanamericano, folioCortePanamericano,uname_br_consulta);
		return cortePanamericano;
	}
	
	private ConsultaCortesCaja consultaCortesDeCajaBD(HttpServletRequest request, HttpSession session)
	{
		Usuario infoUsu= (Usuario) session.getAttribute("infoUsu");	
		String fechaCorteCaja = request.getParameter("fechaCorteCaja").toString();
		String origen = request.getParameter("origen").toString();
		String uname_br_consulta = request.getParameter("uname_consulta").toString();
		String folioCorteCaja = (request.getParameter("folioCorteCaja").toString().equals("")||
								 request.getParameter("folioCorteCaja").toString().equals("0")) ? " 0" : request.getParameter("folioCorteCaja").toString();
		ConsultaCortesCaja previoCorteCaja = gestorConsultas.consultarCortesDeCajaEnBD(infoUsu, this.querys, fechaCorteCaja, folioCorteCaja, origen, uname_br_consulta);
		return previoCorteCaja;
	}
	
	private PolizaCompleta consultaCortesDePolizaBD(HttpServletRequest request, HttpSession session)
	{
		Usuario infoUsu= (Usuario) session.getAttribute("infoUsu");	
		String fechaCortePoliza = request.getParameter("fechaCortePoliza").toString();
		String uname_br_consulta = request.getParameter("uname_consulta").toString();
		String folioCortePoliza = (request.getParameter("folioCortePoliza").toString().equals("")||
								 request.getParameter("folioCortePoliza").toString().equals("0")) ? " 0" : request.getParameter("folioCortePoliza").toString();
		PolizaCompleta polizaCompleta = gestorConsultas.consultarCortesDePolizaEnBD(infoUsu, this.querys, fechaCortePoliza, folioCortePoliza, uname_br_consulta);
		return polizaCompleta;
	}
		
	private void enviarRespuestaTextoJS(HttpServletRequest request, HttpServletResponse response, String respuesta)
	{
		try
		{
			PrintWriter out = response.getWriter();
		    out.write(respuesta);
		}
		catch(Exception ex)
		{
			System.out.println("Error al re-direccionar vista." + ex.getMessage().toString());
		}
	}
	
	private void enviarRespuestaJsonJS(HttpServletRequest request, HttpServletResponse response, String listaJson)
	{
		try
		{
			response.setContentType("application/json");
			PrintWriter out = response.getWriter();
			out.write(listaJson);	
		}
		catch(Exception ex)
		{
			System.out.println("Error al re-direccionar vista." + ex.getMessage().toString());
		}
	}
	
	private void redireccionarVista(HttpServletRequest request, HttpServletResponse response, String vista)
	{
		try
		{
			RequestDispatcher rdIndex = request.getRequestDispatcher("jsp/" + vista);			    	
		    rdIndex.forward(request, response);
		}
		catch(Exception ex)
		{
			System.out.println("Error al re-direccionar vista." + ex.getMessage().toString());
		}
	}
	
}
