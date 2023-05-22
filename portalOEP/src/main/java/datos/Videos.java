package datos;

public class Videos {

	int cveVideo;
	String descripcion;
	String urlImagen;
	String urlVideo;
	
	public int getCveVideo() {
		return cveVideo;
	}
	public void setCveVideo(int cveVideo) {
		this.cveVideo = cveVideo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getUrlImagen() {
		return urlImagen;
	}
	public void setUrlImagen(String urlImagen) {
		this.urlImagen = urlImagen;
	}
	public String getUrlVideo() {
		return urlVideo;
	}
	public void setUrlVideo(String urlVideo) {
		this.urlVideo = urlVideo;
	}
	
	public Videos() {
		super();
		this.cveVideo = 0;
		this.descripcion = "";
		this.urlImagen = "";
		this.urlVideo = "";
	}
	
	@Override
	public String toString() {
		return "Videos [cveVideo=" + cveVideo + ", descripcion=" + descripcion + ", urlImagen=" + urlImagen
				+ ", urlVideo=" + urlVideo + "]";
	}
}
