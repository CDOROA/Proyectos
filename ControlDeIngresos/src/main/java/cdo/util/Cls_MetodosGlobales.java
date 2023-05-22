package cdo.util;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;

import javax.servlet.http.HttpSession;

public class Cls_MetodosGlobales {
	
	public static String aplicarFormatoImporte(BigDecimal importe) 
	{
		DecimalFormat df = new DecimalFormat("#,###.00");
	    return  df.format(importe);
	}	
	
	public static void removerParametrosDeSession(HttpSession session, String pagina)
	{
		switch(pagina)
		{
			case"ConfirmaIngresoACaja.jsp":
				session.removeAttribute("exitoInsertar");
				session.removeAttribute("exitoInsertar");
				session.removeAttribute("datoIncorrecto");
				session.removeAttribute("ListDetTmpIngresos");
				session.removeAttribute("ConceptoSession");
				session.removeAttribute("PrecioSession");
				session.removeAttribute("CantidadSession");
				session.removeAttribute("KilosSession");
				session.removeAttribute("ImporteSession");
			break;
		}
	}
	
	
	
	
	public static String obtieneSentenciaDeQrys(String[] querys )
	{
		String strQry="";
		for(int i=0; i < querys.length; i++)
		{
			if(querys[i].length() > 0)
			{
				strQry +=  " Qry" + i +": " + querys[i].replace("'", "´") + ", ";
			}
			
		}
		System.out.println(strQry);
		return strQry;
	}
	
	
	

}
