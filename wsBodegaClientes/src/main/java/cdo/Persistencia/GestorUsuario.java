package cdo.Persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

import cdo.Entidades.Querys;
import cdo.Entidades.Respuesta;
import cdo.Util.Cls_Querys;
import cdo.Util.ConexionBD;

public class GestorUsuario
{
    public static List<Querys> ConsultaTablaQuerysBD(final String cdo) {
        Connection connBD = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        final List<Querys> querys = new ArrayList<Querys>();
        try {
            final String qry = ObtieneQuery(2, "", "", cdo);
            connBD = ConexionBD.AbrirConexionBDD(cdo);
            pstmt = connBD.prepareStatement(qry);
            rs = pstmt.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    final Querys query = new Querys();
                    query.setProceso(rs.getInt("proceso"));
                    query.setIndice_query(rs.getInt("indice_query"));
                    query.setSub_indice_query(rs.getInt("sub_indice_query"));
                    query.setDescripcion(rs.getString("descripcion"));
                    query.setQuery(rs.getString("query"));
                    querys.add(query);
                }
            }
        }
        catch (Exception ex) {}
        finally {
            try {
                connBD.close();
                pstmt.close();
            }
            catch (Exception ex2) {}
        }
        try {
            connBD.close();
            pstmt.close();
        }
        catch (Exception ex3) {}
        return querys;
    }
    
    public static String ObtieneQuery(final int numQuery, final String usuario, final String password, final String cdo) {
        String qry = "";
        switch (numQuery) {
            case 2: {
                qry = "SELECT"
                		+ " \t\tDISTINCT proc_web AS proceso, indice_query, sub_indice_query, descripcion, estructura AS query   "
                		+ "FROM"
                		+ " \t" + cdo.toUpperCase() + ".QUERYS "
        				+ "where "
        				+ "proc_web = '95' " + "  ORDER BY indice_query ASC, " + "sub_indice_query ASC;";
                break;
            }
        }
        return qry;
    }
    

    public static String Error(final Exception e)
    {
        return e.toString().replace("'", "´");
    }
    
    static String[] InicializaQueryNumero1(final String[] ListaQuerys, final String cdo, String cliente) 
    {
        for (int i = 0; i < ListaQuerys.length; ++i) 
        {
            ListaQuerys[i] = ListaQuerys[i].replace("{UNAME}", cdo.toUpperCase());
            ListaQuerys[i] = ListaQuerys[i].replace("{CDO}", cdo.toLowerCase());
            ListaQuerys[i] = ListaQuerys[i].replace("{CLIENTE}", cliente);
        }
        return ListaQuerys;
    }
    
    

	public String[] inicializacionQrys(String[] querys, List<Querys> ListaQuerys, String cdo, int noQry, String cliente) 
	{
		querys = Cls_Querys.LimpiaListaQuerys(querys);
        querys = Cls_Querys.ObtieneQuerys(noQry, (List)ListaQuerys, querys, cdo);
        querys = GestorUsuario.InicializaQueryNumero1(querys, cdo,cliente);
        
        return querys;
	}

	public void finalizarConexion(Connection connBD, PreparedStatement pstmt) 
	{
		try 
		{
            connBD.close();
            pstmt.close();
        }
        catch (Exception ex) {}
	}

	public String[] inicializacionQrys(String[] querys, List<Querys> listaQuerys, String agente) 
	{
		 querys = GestorUsuario.InicializaQueryNumeroagente(querys, agente);
		return querys;
	}

	private static String[] InicializaQueryNumeroagente(String[] ListaQuerys, String agente)
	{
		for (int i = 0; i < ListaQuerys.length; ++i) {
            ListaQuerys[i] = ListaQuerys[i].replace("{AGENTE}", agente);
        }
        return ListaQuerys;
	}

	public String obtenerCDO(int cdo) 
	{
		switch (cdo) 
		{
		case 7:
			return "cdf";
		case 5:
			return "cdm";
		case 8:
			return "cd2";
		case 4:
			return "cdl";
		default:
			return "";
		}
	}

	public String formatoJson(Gson gson, ArrayList<Respuesta> respuesta)
	{
		String js = "";
    	js = gson.toJson(respuesta);
        js = js.substring(1,js.length());
        js = js.substring(0,js.length()-1);
		return js;
	}

	
    
}