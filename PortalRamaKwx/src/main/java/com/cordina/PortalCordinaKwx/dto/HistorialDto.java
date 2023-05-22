package com.cordina.PortalCordinaKwx.dto;

public class HistorialDto {
	
	int year;
	int cont_year;
	String meses;
	String titulo;
		
	public String getMeses() {
		return meses;
	}
	public void setMeses(String meses) {
		this.meses = meses;
	}
		
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	
	public int getCount_year() {
		return cont_year;
	}
	public void setCount_year(int cont_year) {
		this.cont_year = cont_year;
	}
	
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	@Override
	public String toString() {
		return "HistorialDto [meses=" + meses + ", year="
				+ year + ", cont_year="
				+ cont_year + ", titulo=" + titulo + "]";
	}
	
	
}
