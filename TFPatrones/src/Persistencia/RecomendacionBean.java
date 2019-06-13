package Persistencia;

import java.io.Serializable;

public class RecomendacionBean implements Serializable{
	private static final long serialVersionUID = 1L;
	public int codigoRecomendacion;
	public String codigoAlumnoReco;
	public String codigoProfesorReco;
	public String codigoCursoReco;
	public String descripcionReco;
	public int puntuacion;
	public int getCodigoRecomendacion() {
		return codigoRecomendacion;
	}
	public void setCodigoRecomendacion(int codigoRecomendacion) {
		this.codigoRecomendacion = codigoRecomendacion;
	}
	public String getCodigoAlumnoReco() {
		return codigoAlumnoReco;
	}
	public void setCodigoAlumnoReco(String codigoAlumnoReco) {
		this.codigoAlumnoReco = codigoAlumnoReco;
	}
	public String getCodigoProfesorReco() {
		return codigoProfesorReco;
	}
	public void setCodigoProfesorReco(String codigoProfesorReco) {
		this.codigoProfesorReco = codigoProfesorReco;
	}
	public String getCodigoCursoReco() {
		return codigoCursoReco;
	}
	public void setCodigoCursoReco(String codigoCursoReco) {
		this.codigoCursoReco = codigoCursoReco;
	}
	public String getDescripcionReco() {
		return descripcionReco;
	}
	public void setDescripcionReco(String descripcionReco) {
		this.descripcionReco = descripcionReco;
	}
	public int getPuntuacion() {
		return puntuacion;
	}
	public void setPuntuacion(int puntuacion) {
		this.puntuacion = puntuacion;
	}
}
