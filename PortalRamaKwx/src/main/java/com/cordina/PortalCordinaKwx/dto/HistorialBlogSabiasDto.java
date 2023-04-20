package com.cordina.PortalCordinaKwx.dto;

public class HistorialBlogSabiasDto {
	
	private HistorialDto historial;
		
	public HistorialDto getHistorial() {
		return historial;
	}

	public void setHistorial(HistorialDto historial) {
		this.historial = historial;
	}
	
	@Override
	public String toString() {
		return "HistorialBlogSabiasDto [historial=" + historial + "]";
	}
}
