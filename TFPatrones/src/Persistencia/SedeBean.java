package Persistencia;

import java.io.Serializable;

public class SedeBean implements Serializable{

	private static final long serialVersionUID = 1L;
	public String codigoSede;
	
	public String getCodigoSede() {
		return codigoSede;
	}
	public void setCodigoSede(String codigoSede) {
		this.codigoSede = codigoSede;
	}	
	
}
