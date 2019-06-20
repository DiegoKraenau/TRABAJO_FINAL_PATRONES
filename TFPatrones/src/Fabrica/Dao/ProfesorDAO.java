package Fabrica.Dao;

import java.util.ArrayList;

import Persistencia.ProfesorBean;

public interface ProfesorDAO extends CrudDAO<ProfesorBean> {
	public boolean ValidarLogin(ProfesorBean user);
	public ArrayList<ProfesorBean> findByCurso(String Curso);
}
