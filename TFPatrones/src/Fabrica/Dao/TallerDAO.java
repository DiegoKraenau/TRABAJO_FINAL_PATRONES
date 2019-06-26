package Fabrica.Dao;

import java.util.ArrayList;

import Persistencia.TallerBean;

public interface TallerDAO extends CrudDAO<TallerBean>{
	public ArrayList<TallerBean> findbyAlumno(String codigoAlumno);
	public void deleteByAlumno(int codT, String codA);
	public ArrayList<TallerBean> findbyCurProSed(String curso, String profesor, String sede);
	public void inscripcionTaller(int taller, String alumno);
}
