package cdo.Datos;

public class xmlFAC002 {
	private String id_cdo;
	private String correo;
	private String iva;
	
	
	public xmlFAC002(String id_cdo, String correo, String iva) {
		super();
		this.id_cdo = id_cdo;
		this.correo = correo;
		this.iva = iva;
	}
	
	public xmlFAC002() {
		this.id_cdo = "07";
		this.correo = "daniel.calderon@corprama.com.mx";
		this.iva = "0.16";
	}

	public String getId_cdo() {
		return id_cdo;
	}
	public void setId_cdo(String id_cdo) {
		this.id_cdo = id_cdo;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public String getIva() {
		return iva;
	}
	public void setIva(String iva) {
		this.iva = iva;
	}
	
	
}
