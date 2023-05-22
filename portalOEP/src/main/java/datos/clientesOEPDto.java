package datos;


public class clientesOEPDto {
	 int cve_cliente;
	 String nombre;
	 String razonSocial;
	 String calle;
	 String numInterno;
	 String numExterno;
	 String colonia;
	 String delegacion;
	 String direccion;
	 String cp;
	 int id_cve_edo;
	 String telefono;
	 String correoElectronico;
	 String latitud;
	 String longitud;
	 String coordenadas;
	 int cve_producto_oep;
	 String tel_Whatsapp;
	 String km = "";
 
	 
	 public String getCoordenadas() {
		return coordenadas;
	}
	public void setCoordenadas(String coordenadas) {
		this.coordenadas = coordenadas;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	 	 
	public String getRazonSocial() {
		return razonSocial;
	}
	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}	 
	 
	public String getCalle() {
		return calle;
	}
	public void setCalle(String calle) {
		this.calle = calle;
	}
	 
	public String getNumInterno() {
		return numInterno;
	}
	public void setNumInterno(String numInterno) {
		this.numInterno = numInterno;
	}
	 
	public String getNumExterno() {
		return numExterno;
	}
	public void setNumExterno(String numExterno) {
		this.numExterno = numExterno;
	} 
	
	public String getColonia() {
		return colonia;
	}
	public void setColonia(String colonia) {
		this.colonia = colonia;
	} 
		
	public String getDelegacion() {
		return delegacion;
	}
	public void setDelegacion(String delegacion) {
		this.delegacion = delegacion;
	} 
	
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	} 
	
	public String getTel_Whatsapp() {
		return tel_Whatsapp;
	}
	public void setTel_Whatsapp(String tel_Whatsapp) {
		this.tel_Whatsapp = tel_Whatsapp;
	} 
	
	public String getCorreoElectronico() {
		return correoElectronico;
	}
	public void setCorreoElectronico(String correoElectronico) {
		this.correoElectronico = correoElectronico;
	} 
	
	public String getLatitud() {
		return latitud;
	}
	public void setLatitud(String latitud) {
		this.latitud = latitud;
	} 
	
	public String getLongitud() {
		return longitud;
	}
	public void setLongitud(String longitud) {
		this.longitud = longitud;
	} 
		 
	 public int getCve_producto_oep() {
			return cve_producto_oep;
	}
	public void setCve_producto_oep(int cve_producto_oep) {
		this.cve_producto_oep = cve_producto_oep;
	}
		
	 public int getCve_cliente() {
			return cve_cliente;
	}
	public void setCve_cliente(int cve_cliente) {
		this.cve_cliente = cve_cliente;
	}
		
	 public String getCp() {
			return cp;
	}
	public void setCp(String cp) {
		this.cp = cp;
	}
	
	public int getId_cve_edo() {
		return id_cve_edo;
	}
	public void setId_cve_edo(int id_cve_edo) {
		this.id_cve_edo = id_cve_edo;
	}
	
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getKm() {
		return km;
	}
	public void setKm(String km) {
		this.km = km;
	} 
	
	
	
	

}
