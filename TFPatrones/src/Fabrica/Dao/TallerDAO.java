package Fabrica.Dao;

import java.util.ArrayList;

import Persistencia.TallerBean;

public interface TallerDAO extends CrudDAO<TallerBean>{
	public ArrayList<TallerBean> findbyAlumno(String codigoAlumno);
	public void deleteByAlumno(int codT, String codA);
}
