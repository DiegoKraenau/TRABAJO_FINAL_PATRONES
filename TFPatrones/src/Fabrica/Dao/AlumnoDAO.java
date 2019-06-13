package Fabrica.Dao;

import Persistencia.AlumnoBean;

public interface AlumnoDAO extends CrudDAO<AlumnoBean>{
	public void ValidarLogin(AlumnoBean user);
}
