package Fabrica.Dao;

import java.util.ArrayList;

import Persistencia.CursoBean;

public interface CursoDAO extends CrudDAO<CursoBean>{
	public ArrayList<CursoBean> findByAlumno(String alumno_id);
	public CursoBean findByNombre(String nombre);
	public ArrayList<CursoBean> findbyAlumno(String codigoAlumno);
}
