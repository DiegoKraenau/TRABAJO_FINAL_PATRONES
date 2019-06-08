package persistencia;

import java.io.Serializable;

public class SalonBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	public String codigoSalon;
	public int disponibilidad;
	
	public String getCodigoSalon() {
		return codigoSalon;
	}
	public void setCodigoSalon(String codigoSalon) {
		this.codigoSalon = codigoSalon;
	}
	public int getDisponibilidad() {
		return disponibilidad;
	}
	public void setDisponibilidad(int disponibilidad) {
		this.disponibilidad = disponibilidad;
	}
	
	
	
	

}
