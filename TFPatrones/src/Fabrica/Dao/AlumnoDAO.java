package Fabrica.Dao;

import Persistencia.AlumnoBean;

public interface AlumnoDAO extends CrudDAO<AlumnoBean>{
	public boolean ValidarLogin(AlumnoBean user);
}
