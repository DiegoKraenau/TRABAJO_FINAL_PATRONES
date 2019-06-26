package Fabrica.Dao;

import java.util.ArrayList;

import Persistencia.SedeBean;

public interface SedeDAO extends CrudDAO<SedeBean> {
	public ArrayList<SedeBean> findbyProf(Object nombreProf);
	
}
