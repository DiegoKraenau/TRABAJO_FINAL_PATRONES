package Persistencia;

import java.io.Serializable;

public class TallerVBean implements Serializable {
	private static final long serialVersionUID=1L;
	public String codigoTaller;
	public String dia;
	public String curso;
	public String profesor;
	public String fecha;
	public String hora;
	public String fin;
	public String getCodigoTaller() {
		return codigoTaller;
	}
	public void setCodigoTaller(String codigoTaller) {
		this.codigoTaller = codigoTaller;
	}
	public String getDia() {
		return dia;
	}
	public void setDia(String dia) {
		this.dia = dia;
	}
	public String getCurso() {
		return curso;
	}
	public void setCurso(String curso) {
		this.curso = curso;
	}
	public String getProfesor() {
		return profesor;
	}
	public void setProfesor(String profesor) {
		this.profesor = profesor;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public String getHora() {
		return hora;
	}
	public void setHora(String hora) {
		this.hora = hora;
	}
	public String getFin() {
		return fin;
	}
	public void setFin(String fin) {
		this.fin = fin;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
