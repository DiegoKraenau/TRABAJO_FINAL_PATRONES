package Persistencia;

import java.io.Serializable;
import java.util.Date;

public class TallerBean implements Serializable {
	private static final long serialVersionUID = 1L;
	public int codigoTaller;
	public Date fechaTaller;
	public String horaTaller;
	public String codigoProfesor;
	public int duracionTaller;
	public String codigoSede;
	public String codigoCurso;
	
	public int getCodigoTaller() {
		return codigoTaller;
	}
	public void setCodigoTaller(int codigoTaller) {
		this.codigoTaller = codigoTaller;
	}
	public Date getFechaTaller() {
		return fechaTaller;
	}
	public void setFechaTaller(Date fechaTaller) {
		this.fechaTaller = fechaTaller;
	}
	public String getHoraTaller() {
		return horaTaller;
	}
	public void setHoraTaller(String horaTaller) {
		this.horaTaller = horaTaller;
	}
	public String getCodigoProfesor() {
		return codigoProfesor;
	}
	public void setCodigoProfesor(String codigoProfesor) {
		this.codigoProfesor = codigoProfesor;
	}
	public int getDuracionTaller() {
		return duracionTaller;
	}
	public void setDuracionTaller(int duracionTaller) {
		this.duracionTaller = duracionTaller;
	}
	public String getCodigoSede() {
		return codigoSede;
	}
	public void setCodigoSede(String codigoSede) {
		this.codigoSede = codigoSede;
	}
	public String getCodigoCurso() {
		return codigoCurso;
	}
	public void setCodigoCurso(String codigoCurso) {
		this.codigoCurso = codigoCurso;
	}
}
