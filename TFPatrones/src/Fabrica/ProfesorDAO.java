package Fabrica;

import java.util.ArrayList;
import persistencia.ProfesorBean;

public interface ProfesorDAO {

	void InsertarProfesor(ProfesorBean profesor);
	void update(ProfesorBean profesor);
	void delete(String cod);
	void searchxCod(String cod);
	ArrayList<ProfesorBean> listarProfesor();
}
