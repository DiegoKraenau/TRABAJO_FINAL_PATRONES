package persistencia;

import java.io.Serializable;

public class ProfesorBean implements Serializable {

	private static final long serialVersionUID=1L;
	public String codigoProfesor;
	public String contraseñaProfesor;
	public String nombreProfesor;
	public String getCodigoProfesor() {
		return codigoProfesor;
	}
	public void setCodigoProfesor(String codigoProfesor) {
		this.codigoProfesor = codigoProfesor;
	}
	public String getContraseñaProfesor() {
		return contraseñaProfesor;
	}
	public void setContraseñaProfesor(String contraseñaProfesor) {
		this.contraseñaProfesor = contraseñaProfesor;
	}
	public String getNombreProfesor() {
		return nombreProfesor;
	}
	public void setNombreProfesor(String nombreProfesor) {
		this.nombreProfesor = nombreProfesor;
	}
	
	
}
