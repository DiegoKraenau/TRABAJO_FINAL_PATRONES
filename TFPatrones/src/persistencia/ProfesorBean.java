package persistencia;

import java.io.Serializable;

public class ProfesorBean implements Serializable {

	private static final long serialVersionUID=1L;
	public String codigoProfesor;
	public String contrase�aProfesor;
	public String nombreProfesor;
	public String getCodigoProfesor() {
		return codigoProfesor;
	}
	public void setCodigoProfesor(String codigoProfesor) {
		this.codigoProfesor = codigoProfesor;
	}
	public String getContrase�aProfesor() {
		return contrase�aProfesor;
	}
	public void setContrase�aProfesor(String contrase�aProfesor) {
		this.contrase�aProfesor = contrase�aProfesor;
	}
	public String getNombreProfesor() {
		return nombreProfesor;
	}
	public void setNombreProfesor(String nombreProfesor) {
		this.nombreProfesor = nombreProfesor;
	}
	
	
}
