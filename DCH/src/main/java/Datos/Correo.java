package Datos;

public class Correo {
	private String destinatario;
	private String cuerpo;
	private int estatus;
	
	

	public int getEstatus() {
		return estatus;
	}

	public void setEstatus(int estatus) {
		this.estatus = estatus;
	}

	public String getDestinatario() {
		return destinatario;
	}

	public void setDestinatario(String destinatarios) {
		this.destinatario = destinatarios;
	}

	public String getCuerpo() {
		return cuerpo;
	}

	public void setCuerpo(String cuerpo) {
		this.cuerpo = cuerpo;
	}

	@Override
	public String toString() {
		return "Correo [destinatarios=" + destinatario + ", cuerpo=" + cuerpo + "]";
	}
	
	
	
}
