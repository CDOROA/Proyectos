package cdo.Datos;

import java.io.Serializable;
import java.math.BigDecimal;

public class Catalogo_Otros_Ingresos  implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private int id_otro_ingreso;
	private String descripcion;
	private String regla_contable;
	private BigDecimal precio;
	private int modifica_precio;
	private String uname_usu;
	
	public Catalogo_Otros_Ingresos() {
		super();
	}

	public Catalogo_Otros_Ingresos(int id_otro_ingreso, String descripcion, String regla_contable, BigDecimal precio,
			int modifica_precio, String uname_usu) {
		super();
		this.id_otro_ingreso = id_otro_ingreso;
		this.descripcion = descripcion;
		this.regla_contable = regla_contable;
		this.precio = precio;
		this.modifica_precio = modifica_precio;
		this.uname_usu = uname_usu;
	}

	public int getId_otro_ingreso() {
		return id_otro_ingreso;
	}

	public void setId_otro_ingreso(int id_otro_ingreso) {
		this.id_otro_ingreso = id_otro_ingreso;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getRegla_contable() {
		return regla_contable;
	}

	public void setRegla_contable(String regla_contable) {
		this.regla_contable = regla_contable;
	}

	public BigDecimal getPrecio() {
		return precio;
	}

	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}

	public int getModifica_precio() {
		return modifica_precio;
	}

	public void setModifica_precio(int modifica_precio) {
		this.modifica_precio = modifica_precio;
	}

	public String getUname_usu() {
		return uname_usu;
	}

	public void setUname_usu(String uname_usu) {
		this.uname_usu = uname_usu;
	}

	@Override
	public String toString() {
		return "Catalogo_Otros_Ingresos [id_otro_ingreso=" + id_otro_ingreso + ", descripcion=" + descripcion
				+ ", regla_contable=" + regla_contable + ", precio=" + precio + ", modifica_precio=" + modifica_precio
				+ ", uname_usu=" + uname_usu + "]";
	}

}
