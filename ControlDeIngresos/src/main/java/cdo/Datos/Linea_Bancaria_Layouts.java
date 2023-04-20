package cdo.Datos;

import java.io.Serializable;

public class Linea_Bancaria_Layouts implements Serializable{
	private static final long serialVersionUID = 1L;

	private String uname;
	private String uname_br;
	private int cve_banco;
	private String layout_archivo;
	private String nombre_tabla_bd;
	private String columnas_tabla_bd;
	private String columnas_excel;
		
	public Linea_Bancaria_Layouts() {
		super();
	}

	public Linea_Bancaria_Layouts(String uname, String uname_br, int cve_banco, String layout_archivo,
			String nombre_tabla_bd, String columnas_tabla_bd, String columnas_excel) {
		super();
		this.uname = uname;
		this.uname_br = uname_br;
		this.cve_banco = cve_banco;
		this.layout_archivo = layout_archivo;
		this.nombre_tabla_bd = nombre_tabla_bd;
		this.columnas_tabla_bd = columnas_tabla_bd;
		this.columnas_excel = columnas_excel;
	}


	public String getUname() {
		return uname;
	}


	public void setUname(String uname) {
		this.uname = uname;
	}


	public String getUname_br() {
		return uname_br;
	}


	public void setUname_br(String uname_br) {
		this.uname_br = uname_br;
	}


	public int getCve_banco() {
		return cve_banco;
	}


	public void setCve_banco(int cve_banco) {
		this.cve_banco = cve_banco;
	}


	public String getLayout_archivo() {
		return layout_archivo;
	}


	public void setLayout_archivo(String layout_archivo) {
		this.layout_archivo = layout_archivo;
	}


	public String getNombre_tabla_bd() {
		return nombre_tabla_bd;
	}


	public void setNombre_tabla_bd(String nombre_tabla_bd) {
		this.nombre_tabla_bd = nombre_tabla_bd;
	}


	public String getColumnas_tabla_bd() {
		return columnas_tabla_bd;
	}


	public void setColumnas_tabla_bd(String columnas_tabla_bd) {
		this.columnas_tabla_bd = columnas_tabla_bd;
	}


	public String getColumnas_excel() {
		return columnas_excel;
	}


	public void setColumnas_excel(String columnas_excel) {
		this.columnas_excel = columnas_excel;
	}


	@Override
	public String toString() {
		return "Linea_Bancaria_Layouts [uname=" + uname + ", uname_br=" + uname_br + ", cve_banco=" + cve_banco
				+ ", layout_archivo=" + layout_archivo + ", nombre_tabla_bd=" + nombre_tabla_bd + ", columnas_tabla_bd="
				+ columnas_tabla_bd + ", columnas_excel=" + columnas_excel + "]";
	}

}
