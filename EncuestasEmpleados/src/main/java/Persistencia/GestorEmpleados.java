package Persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;

import Datos.Empleado;
import Datos.LogEncuestas;
import Datos.Querys;
import Util.Cls_Querys;
import Util.InsertaLogEncuestas;
public class GestorEmpleados extends HttpServlet{
	private static final long serialVersionUID = 1L;

	 private Client cliente = null;
	 
	   public GestorEmpleados() {
	         super();
	        
	     }
	     @Override
	     public void init() throws ServletException {
	     	super.init();
	     	this.cliente = ClientBuilder.newClient();
	     }
	     
	 @Override
	 public void destroy() {
			this.cliente.close();
			super.destroy();
	 }
	   public Empleado consultaUsuario(String noEmpleado, String psw, List<Querys> listaquerys, Connection connBD, String cdo)
	   {
		   Empleado emp = new Empleado();
		   PreparedStatement pstm = null;
		   ResultSet rs = null;
				
				try {
					
					String[] querys = new String[25];	
					querys = Cls_Querys.LimpiaListaQuerys(querys);	
					querys = Cls_Querys.ObtieneQuerys(2, listaquerys, querys);
					querys = inicializaQueryNumero2(querys, noEmpleado, psw,cdo);
					pstm = connBD.prepareStatement("{call " + "DCH.usp_EXECUTE_QUERY(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
					rs=  Cls_Querys.EjecutarQuery(querys[0], querys[1],querys[2], querys[3], querys[4], querys[5], querys[6],
																 querys[7], querys[8], querys[9],querys[10], querys[11], querys[12], querys[13], 
																 querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], 
																 querys[21], querys[22], querys[23], querys[24], "",pstm, connBD, emp);
					
					
					Cls_Querys.ImprimeQuerysConsola(querys,true,"Query 2");
					if(rs != null)
					{
						while(rs.next())
						{
							//System.out.println("ENTRA VALORES"); 
								emp.setNoEmpleado(rs.getString("no_empleado"));
								emp.setIdEmpleado(rs.getString("id_empleado"));
								emp.setEmpresa(rs.getString("empresa"));
								emp.setArea(rs.getString("area"));
								emp.setNombreCompleto(rs.getString("nombre_completo"));
								emp.setFechaIngreso(rs.getDate("fecha_ingreso"));
								emp.setPuesto(rs.getString("puesto"));
						}
					}
					InsertaLogEncuestas.insertarLog(new LogEncuestas(),emp.getEmpresa(),emp.getEmpresa(),"Entrada a consultar Usuario Usuario: "+emp.getNoEmpleado()+"qry{"+Cls_Querys.regresaQuerys(querys,true)+"}",emp.getNoEmpleado());
				}catch(Exception ex)
				{
					InsertaLogEncuestas.insertarLog(new LogEncuestas(),emp.getEmpresa(),emp.getEmpresa(),"Error - GestorEmpleados.ConsultaEmpleados: " + ex.toString().replace("'", "")+" Usuario: "+emp.getNoEmpleado(),emp.getNoEmpleado());
				}
				finally {
					try {
						if(connBD != null) {
							connBD.close();
						}
						if(pstm != null) {
							pstm.close();
						}
					} catch (Exception e) {
						InsertaLogEncuestas.insertarLog(new LogEncuestas(),emp.getEmpresa(),emp.getEmpresa(),"ERROR al cerrar conexion en GestorEmpleados.ConsultaEmpleados: " + e.toString().replace("'", "")+" Usuario: "+emp.getNoEmpleado(),emp.getNoEmpleado());
					}
				}
				return emp;
		   
	   }
	private String[] inicializaQueryNumero2(String[] querys, String noEmpleado, String psw, String cdo) {
		//System.out.println(cdo);
		for (int i=0;i <querys.length; i++)
		{			
			querys[i]= querys[i].replace("{NO_EMPLEADO}", String.valueOf(noEmpleado));	
			querys[i]= querys[i].replace("{CONTRASENA}", String.valueOf(psw));	
			switch(cdo) {
			case "cdf":
				querys[i]=querys[i].replace("{CDO}", String.valueOf("('cdf','cto','ac2','gdl','cq2')"));
				break;
			case "cd2":
				querys[i]=querys[i].replace("{CDO}", String.valueOf("('cd2','pc2','tug','oa2')"));
				break;
				
			case "cdl":
				querys[i]=querys[i].replace("{CDO}", String.valueOf("('cdl','slp','za2')"));
				break;
			case "cdm":
				querys[i]=querys[i].replace("{CDO}", String.valueOf("('cdm','dur')"));
				break;
			}
		}
		return querys;
	}
}