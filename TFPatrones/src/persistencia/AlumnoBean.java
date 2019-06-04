package persistencia;

import java.io.Serializable;

public class AlumnoBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	public String codigoAlumno;
	public String contraseñaAlumno;
	public String nombreAlumno;
	
	public String getCodigoAlumno() {
		return codigoAlumno;
	}
	public void setCodigoAlumno(String codigoAlumno) {
		this.codigoAlumno = codigoAlumno;
	}
	public String getContraseñaAlumno() {
		return contraseñaAlumno;
	}
	public void setContraseñaAlumno(String contraseñaAlumno) {
		this.contraseñaAlumno = contraseñaAlumno;
	}
	public String getNombreAlumno() {
		return nombreAlumno;
	}
	public void setNombreAlumno(String nombreAlumno) {
		this.nombreAlumno = nombreAlumno;
	}
	
	
	
	
	

	

}
