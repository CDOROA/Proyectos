package cdo.Persistencia;

import cdo.util.ServicioImpresion;

public class GestorImpresionTickets {
	
	public void imprimir(String tipoTicket)
	{		
		
		switch(tipoTicket)
		{
			case "COB":
				break;
				
			case "OI":
				break;
				
			case "HR":
				break;
		}
		
		/*ServicioImpresion printerService = new ServicioImpresion();		
		System.out.println(printerService.getPrinters());		
		String texto = " CENTRO DE DISTRIBUCION ORIENTE SA DE CV ";
		printerService.printString("Microsoft Print to PDF", texto); 	
		byte[] cutP = new byte[] { 0x1d, 'V', 1 }; 
		printerService.printBytes("Microsoft Print to PDF", cutP);*/
	}
	
	public void generaTicketCOB()
	{
		
	}
	
	
	

}
