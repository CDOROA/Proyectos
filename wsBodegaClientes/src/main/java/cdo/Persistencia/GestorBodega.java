package cdo.Persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

import cdo.Entidades.Bodega;
import cdo.Entidades.EjecutaQuerysBD;
import cdo.Entidades.Querys;
import cdo.Entidades.Respuesta;
import cdo.Util.ConexionBD;

public class GestorBodega 
{

	public ArrayList<Respuesta> ConsultarBodega(String cdo, ArrayList<Bodega> bodega, GestorUsuario gUsuario,Gson gson, String[] querys, String cliente, ArrayList<Respuesta> respuesta) 
	{
		Connection connBD = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        int numReg = 0;
        
        try 
        {
        	List<Querys> ListaQuerys = GestorUsuario.ConsultaTablaQuerysBD("CDF");
            if (ListaQuerys.size()<1)
            {
            	return respuesta = respuesta(bodega,0,"Error al obtener querys, tabla de querys vacia. CLIENTE: "+cliente+". CDO: "+cdo,respuesta,1);
            }
            
	        	try 
	            {
	                connBD = ConexionBD.AbrirConexionBDD(cdo);
	            }
	            catch (Exception e) 
	            {
	            	bodega =  llenarRespuesta("",0,0,0,0,"",0,"",bodega);
	               return respuesta(bodega,numReg,"Error en la conexión a la BD, no se pudo conectar. CLIENTE: "+cliente+". CDO: "+cdo,respuesta,3);
	            }
	            if (connBD == null) 
	            {
	            	return respuesta(bodega,numReg,"Error en la conexión a la BD, no se pudo conectar. articulo: "+cliente+". CDO: "+cdo,respuesta,3);
	            }
	            
	            querys = gUsuario.inicializacionQrys(querys,ListaQuerys,cdo,8,cliente);
	            pstmt = connBD.prepareStatement("{call " + cdo.toUpperCase() + ".usp_EXECUTE_QUERY(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
	            rs = EjecutaQuerysBD.EjecutarQuery(querys[0], querys[1], querys[2], querys[3], querys[4], querys[5], querys[6], querys[7], querys[8], querys[9], querys[10], querys[11], querys[12], querys[13], querys[14], querys[15], querys[16], querys[17], querys[18], querys[19], querys[20], querys[21], querys[22], querys[23], querys[24], cdo, pstmt, connBD);
	            while (rs.next())
	            {
	                try
	                {
	                	bodega = llenarRespuesta(rs.getString("uname_br"),rs.getInt("ruta"),rs.getInt("transporte"),rs.getInt("syf"),rs.getInt("cond_pago"),rs.getString("vigencia"),rs.getInt("distancia"),rs.getString("tipo_lf"),bodega);
	                	numReg ++;
	                }
	                catch (Exception e) 
	                {
	                    bodega = llenarRespuesta("",0,0,0,0,"",0,"",bodega);
	                    return respuesta(bodega,numReg,"Error al cargar relacion bodega. DETALLE: "+gUsuario.Error(e)+". CLIENTE: "+cliente+". CDO: "+cdo,respuesta,0);
	                }
	            }
            if (bodega.size() <= 0) 
            {
            	return respuesta(bodega,numReg,"No se encontraron registros en la BD. CLIENTE: "+cliente+". CDO: "+cdo,respuesta,4);
            }
        }
        catch (Exception e)
        {
        	return respuesta(bodega,numReg,"Error al consultar relacion bodega. DETALLE: "+gUsuario.Error(e)+". CLIENTE: "+cliente+". CDO: "+cdo,respuesta,0);
        }
        finally 
        {
            gUsuario.finalizarConexion(connBD,pstmt);
        }
		return respuesta(bodega,numReg,"Consulta de existencias realizada correctamente.",respuesta,5);
	}



	private ArrayList<Bodega> llenarRespuesta(String uname_br, int ruta, int transporte, int syf, int cond_pago, String vigencia,int distancia, String tipo_lf, ArrayList<Bodega> bodega) 
	{
		Bodega b = new Bodega();
		
		b.setCond_pago(cond_pago);
		b.setDistancia(distancia);
		b.setRuta(ruta);
		b.setSyf(syf);
		b.setTipo_lf(tipo_lf);
		b.setTransporte(transporte);
		b.setUname_br(uname_br);
		b.setVigencia(vigencia);
		
		bodega.add(b);
		
		return bodega;
	}



	public ArrayList<Respuesta> respuesta(ArrayList<Bodega> bodega, int registros, String msjRespuesta, ArrayList<Respuesta> respuesta, int status) 
	{
		Respuesta r = new Respuesta();
		r.setRegistros(registros);
		r.setMsjRespuesta(msjRespuesta);
		r.setDatos(bodega);
		r.setStatus(status);
		respuesta.add(r);
		return respuesta;
	}



}
