package cdo.Util;

import java.util.List;

import cdo.Entidades.Querys;

public class Cls_Querys {
	
	public static String[] ObtieneQuerys(int noQuery, List<Querys> ListaTodosQuerys, String[] ListaQuerys,  String cdo)
	{
		String[] querys = ListaQuerys;
		int cont = 0;
		String qry="";
		
		for(int item = 0; item < ListaTodosQuerys.size(); item++)
		{
			if(ListaTodosQuerys.get(item).getIndice_query() == noQuery)
			{
				qry= ListaTodosQuerys.get(item).getQuery().toString();
				qry= qry.replace("{CDO}",cdo.toUpperCase());
				qry= qry.replace("{UNAME_BR}",cdo.toLowerCase());
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

	public static void ImprimeQuerysConsola(String[] listaQuerys, boolean imprimir, String leyenda)
	{
		if(imprimir)
		{
			System.out.println(leyenda);
			String[] querys = listaQuerys;
			for (int i = 0; i < querys.length ;i++) 
			{				
				if (!querys[i].contentEquals(""))
				{
					System.out.println( querys[i].toString());
				}
			}		
		}	
	}
	
}
