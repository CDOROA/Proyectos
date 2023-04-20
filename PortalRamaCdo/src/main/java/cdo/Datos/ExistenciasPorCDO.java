package cdo.Datos;

import java.io.Serializable;

public class ExistenciasPorCDO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private  boolean existenciaCompleta;
	private String num_art;
	private String cdoMacro;
	private String cdoBr;
	private String cdoTraspaso;
	private int cantidadPedida;
	private int existenciaBR;
	private int exietnciaCDO;
	private int exietnciaTraspaso;
	private String cdoMacroDescripcion;
	private String cdoBrDescripcion;
	private String cdoTraspasoDescripcion;
	private String articuloBloqueo72hrs;
	private String articuloBloqueoExpress;
	
	
	
	public boolean isExistenciaCompleta() {
		return existenciaCompleta;
	}



	public void setExistenciaCompleta(boolean existenciaCompleta) {
		this.existenciaCompleta = existenciaCompleta;
	}



	public String getNum_art() {
		return num_art;
	}



	public void setNum_art(String num_art) {
		this.num_art = num_art;
	}



	public String getCdoMacro() {
		return cdoMacro;
	}



	public void setCdoMacro(String cdoMacro) {
		this.cdoMacro = cdoMacro;
	}



	public String getCdoBr() {
		return cdoBr;
	}



	public void setCdoBr(String cdoBr) {
		this.cdoBr = cdoBr;
	}



	public String getCdoTraspaso() {
		return cdoTraspaso;
	}



	public void setCdoTraspaso(String cdoTraspaso) {
		this.cdoTraspaso = cdoTraspaso;
	}



	public int getCantidadPedida() {
		return cantidadPedida;
	}



	public void setCantidadPedida(int cantidadPedida) {
		this.cantidadPedida = cantidadPedida;
	}



	public int getExistenciaBR() {
		return existenciaBR;
	}



	public void setExistenciaBR(int existenciaBR) {
		this.existenciaBR = existenciaBR;
	}



	public int getExietnciaCDO() {
		return exietnciaCDO;
	}



	public void setExietnciaCDO(int exietnciaCDO) {
		this.exietnciaCDO = exietnciaCDO;
	}



	public int getExietnciaTraspaso() {
		return exietnciaTraspaso;
	}



	public void setExietnciaTraspaso(int exietnciaTraspaso) {
		this.exietnciaTraspaso = exietnciaTraspaso;
	}



	public String getCdoMacroDescripcion() {
		return cdoMacroDescripcion;
	}



	public void setCdoMacroDescripcion(String cdoMacroDescripcion) {
		this.cdoMacroDescripcion = cdoMacroDescripcion;
	}



	public String getCdoBrDescripcion() {
		return cdoBrDescripcion;
	}



	public void setCdoBrDescripcion(String cdoBrDescripcion) {
		this.cdoBrDescripcion = cdoBrDescripcion;
	}



	public String getCdoTraspasoDescripcion() {
		return cdoTraspasoDescripcion;
	}



	public void setCdoTraspasoDescripcion(String cdoTraspasoDescripcion) {
		this.cdoTraspasoDescripcion = cdoTraspasoDescripcion;
	}



	public String getArticuloBloqueo72hrs() {
		return articuloBloqueo72hrs;
	}



	public void setArticuloBloqueo72hrs(String articuloBloqueo72hrs) {
		this.articuloBloqueo72hrs = articuloBloqueo72hrs;
	}



	public String getArticuloBloqueoExpress() {
		return articuloBloqueoExpress;
	}



	public void setArticuloBloqueoExpress(String articuloBloqueoExpress) {
		this.articuloBloqueoExpress = articuloBloqueoExpress;
	}



	public static long getSerialversionuid() {
		return serialVersionUID;
	}



	public ExistenciasPorCDO() {
		super();
	}



	public ExistenciasPorCDO(boolean existenciaCompleta, String num_art, String cdoMacro, String cdoBr,
			String cdoTraspaso, int cantidadPedida, int existenciaBR, int exietnciaCDO, int exietnciaTraspaso,
			String cdoMacroDescripcion, String cdoBrDescripcion, String cdoTraspasoDescripcion,
			String articuloBloquado72hrs, String articuloBloquadoExpress) {
		super();
		this.existenciaCompleta = existenciaCompleta;
		this.num_art = num_art;
		this.cdoMacro = cdoMacro;
		this.cdoBr = cdoBr;
		this.cdoTraspaso = cdoTraspaso;
		this.cantidadPedida = cantidadPedida;
		this.existenciaBR = existenciaBR;
		this.exietnciaCDO = exietnciaCDO;
		this.exietnciaTraspaso = exietnciaTraspaso;
		this.cdoMacroDescripcion = cdoMacroDescripcion;
		this.cdoBrDescripcion = cdoBrDescripcion;
		this.cdoTraspasoDescripcion = cdoTraspasoDescripcion;
		this.articuloBloqueo72hrs = articuloBloquado72hrs;
		this.articuloBloqueoExpress = articuloBloquadoExpress;
	}



	@Override
	public String toString() {
		return "ExistenciasPorCDO [existenciaCompleta=" + existenciaCompleta + ", num_art=" + num_art + ", cdoMacro="
				+ cdoMacro + ", cdoBr=" + cdoBr + ", cdoTraspaso=" + cdoTraspaso + ", cantidadPedida=" + cantidadPedida
				+ ", existenciaBR=" + existenciaBR + ", exietnciaCDO=" + exietnciaCDO + ", exietnciaTraspaso="
				+ exietnciaTraspaso + ", cdoMacroDescripcion=" + cdoMacroDescripcion + ", cdoBrDescripcion="
				+ cdoBrDescripcion + ", cdoTraspasoDescripcion=" + cdoTraspasoDescripcion + ", articuloBloquado72hrs="
				+ articuloBloqueo72hrs + ", articuloBloquadoExpress=" + articuloBloqueoExpress + "]";
	}


	
	
}
