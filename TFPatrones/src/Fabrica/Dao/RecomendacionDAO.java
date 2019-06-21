package Fabrica.Dao;

import java.util.ArrayList;

import Persistencia.RecomendacionBean;

public interface RecomendacionDAO extends CrudDAO<RecomendacionBean> {
	public ArrayList<RecomendacionBean> findByProfesor_Curso(String profesor, String Curso);
	public String findPromedio(String profesor, String Curso,int num);
	public ArrayList<RecomendacionBean> findRecomendacionAlumno(String codigo);
}
