package cdo.Persistencia;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.prefs.BackingStoreException;
import java.util.prefs.Preferences;

import cdo.Entidades.Respuesta;

public class GestorValidateParams  
{
	private GestorUsuario gUsu = new GestorUsuario();
	public Respuesta respuesta = new Respuesta();
	private List<String> detalle = new ArrayList<>();
	Connection connBD = null;
	static Preferences preferences = Preferences.userNodeForPackage(Preferences.class);
	public Respuesta validateParameters(String cdo, String folio, String serie, String correo) 
	{
		try 
		{
			preferences.clear();
		} catch (BackingStoreException e) 
		{
			detalle.add(e.getMessage().toString());
			fillRsp(false, "Error al limpiar preferencias");
		}
		validateParameters(cdo,"cdo");validateParameters(folio,"folio");validateParameters(serie,"serie");validateParameters(correo,"correo");
		detalle.removeAll(Arrays.asList("",null));
		if (detalle.size()>0) 
		{
			fillRsp(false,"Error en parametros");
		}
		return respuesta;
	}
	
	private void fillRsp(boolean rsp, String mensaje) 
	{
		detalle.removeAll(Arrays.asList("",null));
		
		respuesta.setRespuesa(false);
		respuesta.setMensaje(mensaje);
		respuesta.setDetalle(detalle);
	}
	
	public String validateCDO(String cdo) 
	{
		switch (cdo) 
		{
		case "cdf":
			return "";
		case "cdm":
			return "";
		case "cd2":
			return "";
		case "cdl":
			return "";
		case "a03":
			return "";
		case "kwx":
			return "";
		default:
			return "El cdo no es valido.";
		}
		
	}
	
	public void validateParameters(String value, String description) 
	{
		switch (description) 
		{
			case "cdo":
				detalle.add(value!= null ? !value.trim().equals("") ? !validateCDO(value).equals("") ? "El cdo no es valido. ": "" : "Parametro "+description+" no puede estar vacío." : "Falta parametro "+description+". ");
				break;
			case "folio":
				detalle.add(value != null ? !value.trim().equals("") ?isNumeric(value.trim()) ? "" :  "El valor del parametro "+description+" debe ser numerico. " : "Parametro "+description+" no puede estar vacío." : "Falta parametro "+description+". ");
				break;
			case "serie":
				detalle.add(value != null ? !value.trim().equals("") ? contieneSoloLetras(value.trim()) ? "" :  "El valor del parametro "+description+" debe contener solo letras. "  : "Parametro "+description+" no puede estar vacío." : "Falta parametro "+description+". ");
				break;
			case "correo":
				detalle.add(value != null ? !value.trim().equals("") ? contieneSoloLetras(value.trim()) ? validarParametroCorreo(value) ? "" : "El valor del parametro "+description+" solo admite un caracter s/n" :  "El valor del parametro "+description+" debe contener solo letras. "  : "Parametro "+description+" no puede estar vacío." : "Falta parametro "+description+". ");
				break;			
		}
	}

	private boolean validarParametroCorreo(String correo) 
	{
		if (correo.equalsIgnoreCase("s") || correo.equalsIgnoreCase("n") ) 
		{
			return true;
		}
		return false;
	}

	public static boolean isNumeric(String value)
	{
		try 
		{
			Integer.parseInt(value);
			return true;
		} catch (NumberFormatException nfe)
		{
			return false;
		}
	}
	
	public static boolean contieneSoloLetras(String cadena) 
	{
//		if (cadena.contains(" ")) 
//		{
//			return false;
//		}
//	    for (int x = 0; x < cadena.length(); x++) {
//	        char c = cadena.charAt(x);
//	        // Si no está entre a y z, ni entre A y Z, ni es un espacio
//	        if (!((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || c == ' ')) {
//	            return false;
//	        }
//	    }
	    return true;
	}
}
