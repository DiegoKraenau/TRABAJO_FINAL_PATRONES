package Persistencia;

import java.io.Serializable;

public class CursoBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	public String codigoCurso;
	public String nombreCurso;
	
	public String getCodigoCurso() {
		return codigoCurso;
	}
	public void setCodigoCurso(String codigoCurso) {
		this.codigoCurso = codigoCurso;
	}
	public String getNombreCurso() {
		return nombreCurso;
	}
	public void setNombreCurso(String nombreCurso) {
		this.nombreCurso = nombreCurso;
	}
}
