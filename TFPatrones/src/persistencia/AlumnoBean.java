package persistencia;

import java.io.Serializable;

public class AlumnoBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	public String codigoAlumno;
	public String contrase�aAlumno;
	public String nombreAlumno;
	
	public String getCodigoAlumno() {
		return codigoAlumno;
	}
	public void setCodigoAlumno(String codigoAlumno) {
		this.codigoAlumno = codigoAlumno;
	}
	public String getContrase�aAlumno() {
		return contrase�aAlumno;
	}
	public void setContrase�aAlumno(String contrase�aAlumno) {
		this.contrase�aAlumno = contrase�aAlumno;
	}
	public String getNombreAlumno() {
		return nombreAlumno;
	}
	public void setNombreAlumno(String nombreAlumno) {
		this.nombreAlumno = nombreAlumno;
	}
	
	
	
	
	

	

}
