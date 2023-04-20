package cdo.Datos;

public class ChequeNominativo {

	String uname;
	String referencia;
	int folio_caja;
	int id_tipo_ingreso;
	String tipo_ingreso;
	int num_cli;
	String nom_cliente;
	String importe;
	int agente;
	String nom_agente;
	String cve_usu_ecc;
	int cve_banco;
	String banco;
	String ficha_deposito;
	int cve_banco_deposito;
	String banco_deposito;
	String fecha_poliza;
	int id_estatus;
	String descripcion_estatus;
	String cve_usu;
	String nom_cve_usu;
	
	public ChequeNominativo() {
		super();
	}

	public ChequeNominativo(String uname, String referencia, int folio_caja, int id_tipo_ingreso, String tipo_ingreso,
			int num_cli, String nom_cliente, String importe, int agente, String nom_agente, String cve_usu_ecc,
			int cve_banco, String banco, String ficha_deposito, int cve_banco_deposito, String banco_deposito,
			String fecha_poliza, int id_estatus, String descripcion_estatus, String cve_usu, String nom_cve_usu) {
		super();
		this.uname = uname;
		this.referencia = referencia;
		this.folio_caja = folio_caja;
		this.id_tipo_ingreso = id_tipo_ingreso;
		this.tipo_ingreso = tipo_ingreso;
		this.num_cli = num_cli;
		this.nom_cliente = nom_cliente;
		this.importe = importe;
		this.agente = agente;
		this.nom_agente = nom_agente;
		this.cve_usu_ecc = cve_usu_ecc;
		this.cve_banco = cve_banco;
		this.banco = banco;
		this.ficha_deposito = ficha_deposito;
		this.cve_banco_deposito = cve_banco_deposito;
		this.banco_deposito = banco_deposito;
		this.fecha_poliza = fecha_poliza;
		this.id_estatus = id_estatus;
		this.descripcion_estatus = descripcion_estatus;
		this.cve_usu = cve_usu;
		this.nom_cve_usu = nom_cve_usu;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getReferencia() {
		return referencia;
	}

	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}

	public int getFolio_caja() {
		return folio_caja;
	}

	public void setFolio_caja(int folio_caja) {
		this.folio_caja = folio_caja;
	}

	public int getId_tipo_ingreso() {
		return id_tipo_ingreso;
	}

	public void setId_tipo_ingreso(int id_tipo_ingreso) {
		this.id_tipo_ingreso = id_tipo_ingreso;
	}

	public String getTipo_ingreso() {
		return tipo_ingreso;
	}

	public void setTipo_ingreso(String tipo_ingreso) {
		this.tipo_ingreso = tipo_ingreso;
	}

	public int getNum_cli() {
		return num_cli;
	}

	public void setNum_cli(int num_cli) {
		this.num_cli = num_cli;
	}

	public String getNom_cliente() {
		return nom_cliente;
	}

	public void setNom_cliente(String nom_cliente) {
		this.nom_cliente = nom_cliente;
	}

	public String getImporte() {
		return importe;
	}

	public void setImporte(String importe) {
		this.importe = importe;
	}

	public int getAgente() {
		return agente;
	}

	public void setAgente(int agente) {
		this.agente = agente;
	}

	public String getNom_agente() {
		return nom_agente;
	}

	public void setNom_agente(String nom_agente) {
		this.nom_agente = nom_agente;
	}

	public String getCve_usu_ecc() {
		return cve_usu_ecc;
	}

	public void setCve_usu_ecc(String cve_usu_ecc) {
		this.cve_usu_ecc = cve_usu_ecc;
	}

	public int getCve_banco() {
		return cve_banco;
	}

	public void setCve_banco(int cve_banco) {
		this.cve_banco = cve_banco;
	}

	public String getBanco() {
		return banco;
	}

	public void setBanco(String banco) {
		this.banco = banco;
	}

	public String getFicha_deposito() {
		return ficha_deposito;
	}

	public void setFicha_deposito(String ficha_deposito) {
		this.ficha_deposito = ficha_deposito;
	}

	public int getCve_banco_deposito() {
		return cve_banco_deposito;
	}

	public void setCve_banco_deposito(int cve_banco_deposito) {
		this.cve_banco_deposito = cve_banco_deposito;
	}

	public String getBanco_deposito() {
		return banco_deposito;
	}

	public void setBanco_deposito(String banco_deposito) {
		this.banco_deposito = banco_deposito;
	}

	public String getFecha_poliza() {
		return fecha_poliza;
	}

	public void setFecha_poliza(String fecha_poliza) {
		this.fecha_poliza = fecha_poliza;
	}

	public int getId_estatus() {
		return id_estatus;
	}

	public void setId_estatus(int id_estatus) {
		this.id_estatus = id_estatus;
	}

	public String getDescripcion_estatus() {
		return descripcion_estatus;
	}

	public void setDescripcion_estatus(String descripcion_estatus) {
		this.descripcion_estatus = descripcion_estatus;
	}

	public String getCve_usu() {
		return cve_usu;
	}

	public void setCve_usu(String cve_usu) {
		this.cve_usu = cve_usu;
	}

	public String getNom_cve_usu() {
		return nom_cve_usu;
	}

	public void setNom_cve_usu(String nom_cve_usu) {
		this.nom_cve_usu = nom_cve_usu;
	}

	@Override
	public String toString() {
		return "ChequeNominativo [uname=" + uname + ", referencia=" + referencia + ", folio_caja=" + folio_caja
				+ ", id_tipo_ingreso=" + id_tipo_ingreso + ", tipo_ingreso=" + tipo_ingreso + ", num_cli=" + num_cli
				+ ", nom_cliente=" + nom_cliente + ", importe=" + importe + ", agente=" + agente + ", nom_agente="
				+ nom_agente + ", cve_usu_ecc=" + cve_usu_ecc + ", cve_banco=" + cve_banco + ", banco=" + banco
				+ ", ficha_deposito=" + ficha_deposito + ", cve_banco_deposito=" + cve_banco_deposito
				+ ", banco_deposito=" + banco_deposito + ", fecha_poliza=" + fecha_poliza + ", id_estatus=" + id_estatus
				+ ", descripcion_estatus=" + descripcion_estatus + ", cve_usu=" + cve_usu + ", nom_cve_usu="
				+ nom_cve_usu + "]";
	}

	
}
