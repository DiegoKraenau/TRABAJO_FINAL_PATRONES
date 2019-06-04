package fabricaAlumno;

import java.util.ArrayList;

import persistencia.AlumnoBean;

public interface AlumnoDAO {

	public void InsertarAlumno(AlumnoBean user);
	public void ValidarLogin(AlumnoBean user);
	public void update(AlumnoBean user);
	public void delete(String cod);
	public void searchxCod (String cod);
	public ArrayList<AlumnoBean> listarUser(String name);
	
}
