package cdfis.util;

import java.util.List;

import cdfis.Datos.Querys;

public class Cls_Querys {
	
	public static String[] ObtieneQuerys(int noQuery, List<Querys> ListaTodosQuerys, String[] ListaQuerys,  String cdo)
	{
		String[] querys = ListaQuerys;
		int cont = 0;
		String qry="";
		
		for(int item = 0; item < ListaTodosQuerys.size(); item++)
		{
			ListaTodosQuerys.get(item).getProceso();
			if(ListaTodosQuerys.get(item).getIndice_query() == noQuery)
			{
				qry= ListaTodosQuerys.get(item).getQuery().toString();
				qry= qry.replace("{CDO}",cdo.toUpperCase());
				qry= qry.replace("{UNAME}",cdo.toLowerCase());
				querys[cont] = qry;
				cont++;
			}
		}
		return querys;
	}
	
	
	public static String[] LimpiaListaQuerys(String[] listaQuerys)
	{
		String[] querys = listaQuerys;
		for (int i = 0; i < querys.length ;i++) 
		{						
			querys[i] = "";
		}
		return querys;				
	}

}
