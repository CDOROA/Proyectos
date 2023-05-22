package cdo.util;

import java.io.FileOutputStream;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.poi.ss.usermodel.IndexedColors;

import cdo.Datos.TrayectoDatos;

public class GenerarExcel 
{
	@SuppressWarnings("deprecation")
	public String generarExcel(HttpSession session, HttpServletRequest request, HttpServletResponse response)
	{
		String rsp = "n";
		LocalDateTime locaDate = LocalDateTime.now();
		int hours  = locaDate.getHour();
		int minutes = locaDate.getMinute();
		int seconds = locaDate.getSecond();
		List<TrayectoDatos> lst = new ArrayList<TrayectoDatos>();
		lst = (List<TrayectoDatos>) session.getAttribute("listaExcel");
		try {

            HSSFWorkbook wb = new HSSFWorkbook();
            
            CellStyle style = wb.createCellStyle();
            CellStyle right = wb.createCellStyle();
            CellStyle left = wb.createCellStyle();
            
            style.setFillForegroundColor(IndexedColors.YELLOW.getIndex());
            style.setFillPattern(CellStyle.SOLID_FOREGROUND);
            HSSFSheet sheet = wb.createSheet("Excel Sheet");
            HSSFRow rowhead = sheet.createRow((short) 0);
            
            style.setAlignment(style.ALIGN_CENTER);
            right.setAlignment(right.ALIGN_RIGHT);
            left.setAlignment(style.ALIGN_LEFT);
            sheet.setColumnWidth(9, 7500);      
            sheet.setColumnWidth(10, 7500);
            sheet.setColumnWidth(8, 7500);
            sheet.setColumnWidth(14, 6500);
            sheet.setColumnWidth(15, 6500);
            sheet.setColumnWidth(17, 6500);
            sheet.setColumnWidth(16, 6500);
            sheet.setColumnWidth(18, 6500);
            sheet.setColumnWidth(11, 7500);
            sheet.setColumnWidth(12, 7500);
            sheet.setColumnWidth(13, 7500);
            sheet.setColumnWidth(19, 17000);
            sheet.setColumnWidth(4, 17000);
            sheet.setColumnWidth(5, 17000);
            sheet.setColumnWidth(0, 3500);
            sheet.setColumnWidth(1, 3500);
            sheet.setColumnWidth(20, 3500);
            
            rowhead.createCell((short) 0).setCellValue("CDO");
            rowhead.createCell((short) 1).setCellValue("CDO ASIGNA");
            rowhead.createCell((short) 2).setCellValue("RUTA");
            rowhead.createCell((short) 3).setCellValue("TIPO");
            rowhead.createCell((short) 4).setCellValue("CLIENTE");
            rowhead.createCell((short) 5).setCellValue("CHOFER");
            rowhead.createCell((short) 6).setCellValue("ODE");
            rowhead.createCell((short) 7).setCellValue("PEDIDO");
            rowhead.createCell((short) 8).setCellValue("IMPORTE");
            rowhead.createCell((short) 9).setCellValue("FECHA PEDIDO");
            rowhead.createCell((short) 10).setCellValue("FECHA ASIGNACION");
            rowhead.createCell((short) 11).setCellValue("FECHA INICIO RUTA");
            rowhead.createCell((short) 12).setCellValue("FECHA FIN RUTA");
            rowhead.createCell((short) 13).setCellValue("FECHA ENTREGA");
            rowhead.createCell((short) 14).setCellValue("TIEMPO PEDIDO");
            rowhead.createCell((short) 15).setCellValue("TIEMPO RUTA"); 
            rowhead.createCell((short) 16).setCellValue("TIEMPO ENTREGA");
            rowhead.createCell((short) 17).setCellValue("TIEMPO ASIGNO");
            rowhead.createCell((short) 18).setCellValue("TIEMPO INICIO");
            rowhead.createCell((short) 19).setCellValue("USUARIO ASIGNO");
            rowhead.createCell((short) 20).setCellValue("FOL CP");
            
            rowhead.getCell(0).setCellStyle(style);
            rowhead.getCell(1).setCellStyle(style);
            rowhead.getCell(2).setCellStyle(style);
            rowhead.getCell(3).setCellStyle(style);
            rowhead.getCell(4).setCellStyle(style);
            rowhead.getCell(5).setCellStyle(style);
            rowhead.getCell(6).setCellStyle(style);
            rowhead.getCell(7).setCellStyle(style);          
            rowhead.getCell(8).setCellStyle(style);
            rowhead.getCell(9).setCellStyle(style);
            rowhead.getCell(10).setCellStyle(style);
            rowhead.getCell(11).setCellStyle(style);
            rowhead.getCell(12).setCellStyle(style);
            rowhead.getCell(13).setCellStyle(style);
            rowhead.getCell(14).setCellStyle(style);
            rowhead.getCell(15).setCellStyle(style);
            rowhead.getCell(16).setCellStyle(style);
            rowhead.getCell(17).setCellStyle(style);
            rowhead.getCell(18).setCellStyle(style);
            rowhead.getCell(19).setCellStyle(style);
            rowhead.getCell(20).setCellStyle(style);

            int index = 1;
            String cliente = "";
            String[] split;
            double suma = 0.0;
        	for (TrayectoDatos l : lst) 
        	{
        	    HSSFRow row = sheet.createRow((short) index);
        	    split = l.getCliente().split("-");
        	    cliente = split[0];
        	    
                row.createCell((short) 0).setCellValue(l.getDescripcion_br());
                row.createCell((short) 1).setCellValue(l.getDescripcion_cdo());
                row.createCell((short) 2).setCellValue(parsear(l.getId_traycto()));
                if (l.getTipo().equalsIgnoreCase("C")) 
                {
                	row.createCell((short) 3).setCellValue("CHOFER");	
				}
                else
                {
                	row.createCell((short) 3).setCellValue("TRANSPORTE");
                }
                row.createCell((short) 4).setCellValue(l.getCliente());
                row.createCell((short) 5).setCellValue(l.getNum_chofer());
                row.createCell((short) 6).setCellValue(parsear(l.getOde()));
                row.createCell((short) 7).setCellValue(parsear(l.getPedido()));
                row.createCell((short) 8).setCellValue("$"+l.getImportePedido());
                row.createCell((short) 9).setCellValue(l.getFechaPedido());
                row.createCell((short) 10).setCellValue(l.getAsignacionConcat());
                row.createCell((short) 11).setCellValue(l.getInicioConcat());
                row.createCell((short) 12).setCellValue(l.getFinConcat());
                row.createCell((short) 13).setCellValue(l.getFecha_inicio_entrega());
                row.createCell((short) 14).setCellValue(l.getHorasPed().replace("-",""));
                row.createCell((short) 15).setCellValue(l.getHorasEnc().replace("-","")); 
                row.createCell((short) 16).setCellValue(l.getHorasEntrega().replace("-",""));
                row.createCell((short) 17).setCellValue(l.getHorasEncPed().replace("-","")); 
                row.createCell((short) 18).setCellValue(l.getHorasInicio().replace("-",""));
                row.createCell((short) 19).setCellValue(l.getUsuario_asignacion());
                row.createCell((short) 20).setCellValue(l.getFolio_carta_porte());
                suma += Double.parseDouble(l.getImportePedido().replace(",", ""));
                index++;
                
			}

        	HSSFRow row = sheet.createRow((short) index);
            row.createCell((short) 8).setCellValue("$"+formatearImporte(String.valueOf(suma)));
            index++;

        	
        	String nombreFile ="ReporteCliente_"+cliente+"_HORA_"+hours+"-"+minutes+"-"+seconds+".xls";
        	
        	session.setAttribute("urlExcel", nombreFile);
          FileOutputStream fileOut = new FileOutputStream("/tmp/"+nombreFile);
     //       FileOutputStream fileOut = new FileOutputStream("C:\\FTP\\"+nombreFile);
            wb.write(fileOut);
            fileOut.close();
            rsp = "s";
    } catch (Exception e) {
    	System.out.println(e.toString());
    }
		return rsp;
	}

	private int parsear(String cliente)
	{
			return Integer.parseInt(cliente);
	}
	
	private static String formatearImporte(String importe) 
	 {
		 DecimalFormat formateador = new DecimalFormat("###,###.##");
		 String result = "";
		 if (importe.contains(","))
		 {
			String[] split = importe.split(",");
			String imp = "";
			for (String i : split) 
			{
				imp = imp+formateador.format (Double.parseDouble(i))+",";
			}
			imp = imp.substring(0, imp.length()-1);
			result = imp;
		 }
		 else if (!importe.equals("")) 
		 {
			 result = formateador.format (Double.parseDouble(importe));
		 } 
			return result;
	 }

	
	public String generarExcelGeneral(HttpSession session, HttpServletRequest request, HttpServletResponse response)
	{
		String rsp = "n";
		LocalDateTime locaDate = LocalDateTime.now();
		int hours  = locaDate.getHour();
		int minutes = locaDate.getMinute();
		int seconds = locaDate.getSecond();
        
        double suma =0.0;
		List<TrayectoDatos> lst = new ArrayList<TrayectoDatos>();
		lst = (List<TrayectoDatos>) session.getAttribute("listaExcelGeneral");
		try {

            HSSFWorkbook wb = new HSSFWorkbook();
          
            CellStyle style = wb.createCellStyle();
            CellStyle numero = wb.createCellStyle();
            
            CellStyle right = wb.createCellStyle();
            CellStyle left = wb.createCellStyle();
            CellStyle center = wb.createCellStyle();
            
            
            center.setAlignment(center.ALIGN_CENTER);
            right.setAlignment(right.ALIGN_RIGHT);
            left.setAlignment(style.ALIGN_LEFT);
            
            style.setFillForegroundColor(IndexedColors.YELLOW.getIndex());
            style.setFillPattern(CellStyle.SOLID_FOREGROUND);
            style.setAlignment(style.ALIGN_CENTER);
            HSSFSheet sheet = wb.createSheet("Excel Sheet");
            
            HSSFRow rowhead = sheet.createRow((short) 0);
            sheet.setColumnWidth(8, 7500);
            sheet.setColumnWidth(7, 7500); 
            sheet.setColumnWidth(9, 7500);
            sheet.setColumnWidth(4, 17500);
            sheet.setColumnWidth(15, 17500);
            sheet.setColumnWidth(10, 7500);
            sheet.setColumnWidth(12, 6500);
            sheet.setColumnWidth(11, 6500);
            sheet.setColumnWidth(13, 6500);
            sheet.setColumnWidth(0, 3500);
            sheet.setColumnWidth(1, 3500);
            sheet.setColumnWidth(14, 6500);
            sheet.setColumnWidth(5, 6500);
            sheet.setColumnWidth(6, 3500);
            sheet.setColumnWidth(16, 3500);
            
            rowhead.createCell((short) 0).setCellValue("CDO");
            rowhead.createCell((short) 1).setCellValue("CDO ASIGNA");
            rowhead.createCell((short) 2).setCellValue("RUTA");
            rowhead.createCell((short) 3).setCellValue("TIPO");
            rowhead.createCell((short) 4).setCellValue("CHOFER");
            rowhead.createCell((short) 5).setCellValue("FACTURAS COD");
            rowhead.createCell((short) 6).setCellValue("COBRO");
            rowhead.createCell((short) 7).setCellValue("IMPORTE");
            rowhead.createCell((short) 8).setCellValue("FECHA ASIGNACION");
            rowhead.createCell((short) 9).setCellValue("FECHA INICIO-RUTA");
            rowhead.createCell((short) 10).setCellValue("FECHA FIN-RUTA");
            rowhead.createCell((short) 11).setCellValue("TIEMPO INICIO RUTA");
            rowhead.createCell((short) 12).setCellValue("TIEMPO ENVIO");
            rowhead.createCell((short) 13).setCellValue("TIEMPO ASIGNO");
            rowhead.createCell((short) 14).setCellValue("ESTATUS");
            rowhead.createCell((short) 15).setCellValue("USUARIO ASIGNO");
            rowhead.createCell((short) 16).setCellValue("FOL CP");
            
            
            rowhead.getCell(0).setCellStyle(center);
            rowhead.getCell(1).setCellStyle(center);
            rowhead.getCell(2).setCellStyle(center);
            rowhead.getCell(3).setCellStyle(center);
            rowhead.getCell(4).setCellStyle(center);
            rowhead.getCell(5).setCellStyle(center);
            rowhead.getCell(6).setCellStyle(center);
            rowhead.getCell(7).setCellStyle(center);
            rowhead.getCell(8).setCellStyle(center);
            rowhead.getCell(9).setCellStyle(center);
            rowhead.getCell(10).setCellStyle(center);
            rowhead.getCell(11).setCellStyle(center);
            rowhead.getCell(12).setCellStyle(center);
            rowhead.getCell(13).setCellStyle(center);
            rowhead.getCell(14).setCellStyle(center);
            rowhead.getCell(15).setCellStyle(center);
            rowhead.getCell(16).setCellStyle(center);
            
            rowhead.getCell(0).setCellStyle(style);
            rowhead.getCell(1).setCellStyle(style);
            rowhead.getCell(2).setCellStyle(style);
            rowhead.getCell(3).setCellStyle(style);
            rowhead.getCell(4).setCellStyle(style);
            rowhead.getCell(5).setCellStyle(style);
            rowhead.getCell(6).setCellStyle(style);
            rowhead.getCell(7).setCellStyle(style);
            rowhead.getCell(8).setCellStyle(style);
            rowhead.getCell(9).setCellStyle(style);
            rowhead.getCell(10).setCellStyle(style);
            rowhead.getCell(11).setCellStyle(style);
            rowhead.getCell(12).setCellStyle(style);
            rowhead.getCell(13).setCellStyle(style);
            rowhead.getCell(14).setCellStyle(style);
            rowhead.getCell(15).setCellStyle(style);
            rowhead.getCell(16).setCellStyle(style);
            
            int index = 1;
            String cliente = "";
   
        	for (TrayectoDatos l : lst) 
        	{
        		if (l.getRepeticion().equals("n"))
        		{
					HSSFRow row = sheet.createRow((short) index);
				    row.createCell((short) 0).setCellValue(l.getDescripcion_br());
	        	    row.getCell(0).setCellStyle(center);
	        	    row.createCell((short) 1).setCellValue(l.getDescripcion_cdo());
	        	    row.getCell(1).setCellStyle(center);
	                row.createCell((short) 2).setCellValue(parsear(l.getId_traycto()));
	                row.getCell(2).setCellStyle(center);
	                row.createCell((short) 3).setCellValue(l.getTipo());
	                row.getCell(3).setCellStyle(center);
	                row.createCell((short) 4).setCellValue(l.getNum_chofer());
	                row.getCell(4).setCellStyle(left);
	                if (l.getFacturas_cod().equals("COD"))
	                {
	                	row.createCell((short) 5).setCellValue("COD");
					}
	                else
	                {
	                	row.createCell((short) 5).setCellValue("");
	                }
	                row.getCell(5).setCellStyle(center);
	                if (l.getIngresosCobro().equals("n"))
	                {
	                	row.createCell((short) 6).setCellValue("");	
					}
	                else
	                {  
	                	row.createCell((short) 6).setCellValue(l.getIngresosCobro());
	                }
	                row.getCell(6).setCellStyle(center);
	                row.createCell((short) 7).setCellValue(l.getImportePedido());
	                row.createCell((short) 8).setCellValue(l.getAsignacionConcat());
	                row.getCell(8).setCellStyle(center);
	                row.createCell((short) 9).setCellValue(l.getInicioConcat());
	                row.getCell(9).setCellStyle(center);
	                row.createCell((short) 10).setCellValue(l.getFinConcat());
	                row.getCell(10).setCellStyle(center);
	                row.createCell((short) 11).setCellValue(l.getHorasInicio().replace("-",""));
	                row.getCell(11).setCellStyle(center);
	                row.createCell((short) 12).setCellValue(l.getHorasEnc().replace("-",""));
	                row.getCell(12).setCellStyle(center);
	                row.createCell((short) 13).setCellValue(l.getHorasEncPed().replace("-",""));
	                row.getCell(13).setCellStyle(center);
	                row.createCell((short) 14).setCellValue(l.getEstatus());
	                row.getCell(14).setCellStyle(left);
	                row.createCell((short) 15).setCellValue(l.getUsuario_asignacion());
	                row.getCell(15).setCellStyle(left);
	                row.createCell((short) 16).setCellValue(l.getFolio_carta_porte());
	                row.getCell(16).setCellStyle(center);
	                suma += Double.parseDouble(l.getImportePedido().replace(",", ""));
	                index++;
        		}
        		
			}
        	
        	
        	HSSFRow row = sheet.createRow((short) index);
            row.createCell((short) 7).setCellValue("$"+formatearImporte(String.valueOf(suma)));
            index++;
        	
        	
        	String nombreFile ="ReporteGeneral_HORA_"+hours+"-"+minutes+"-"+seconds+".xls";
        	session.setAttribute("urlExcel", nombreFile);
        	FileOutputStream fileOut = new FileOutputStream("/tmp/"+nombreFile);
//        	FileOutputStream fileOut = new FileOutputStream("C:\\FTP\\"+nombreFile);
            wb.write(fileOut);
            fileOut.close();
            rsp = "s";
    } catch (Exception e) {
    	System.out.println(e.toString());
    }
		return rsp;
	}
	

}
