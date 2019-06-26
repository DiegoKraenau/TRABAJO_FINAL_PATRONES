package Persistencia;

import java.io.Serializable;
import java.util.Date;

public class AulaBean implements Serializable{
	private static final long serialVersionUID = 1L;
	public String codigoAula;
	public String codigoSede;
	public String nombreDia;
	public Date hora;
	public Date fin;
	public int aforoAula;
	public boolean estado;
	public String nombrePro;
	public String nombreCur;
	
	public String getCodigoAula() {
		return codigoAula;
	}
	public void setCodigoAula(String codigoAula) {
		this.codigoAula = codigoAula;
	}
	public String getCodigoSede() {
		return codigoSede;
	}
	public void setCodigoSede(String codigoSede) {
		this.codigoSede = codigoSede;
	}
	public String getNombreDia() {
		return nombreDia;
	}
	public void setNombreDia(String nombreDia) {
		this.nombreDia = nombreDia;
	}
	public Date getHora() {
		return hora;
	}
	public void setHora(Date hora) {
		this.hora = hora;
	}
	public Date getFin() {
		return fin;
	}
	public void setFin(Date fin) {
		this.fin = fin;
	}
	public boolean getEstado() {
		return estado;
	}
	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	public String getNombrePro() {
		return nombrePro;
	}
	public void setNombrePro(String nombrePro) {
		this.nombrePro = nombrePro;
	}
	public String getNombreCur() {
		return nombreCur;
	}
	public void setNombreCur(String nombreCur) {
		this.nombreCur = nombreCur;
	}
	public int getAforoAula() {
		return aforoAula;
	}
	public void setAforoAula(int aforoAula) {
		this.aforoAula = aforoAula;
	}
	
}
