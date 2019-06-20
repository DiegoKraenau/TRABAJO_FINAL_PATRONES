package Fabrica.Dao;

import java.util.ArrayList;

import Persistencia.RecomendacionBean;

public interface RecomendacionDAO extends CrudDAO<RecomendacionBean> {
	public ArrayList<RecomendacionBean> findByProfesor_Curso(String profesor, String Curso);
}
