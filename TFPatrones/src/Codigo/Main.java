package Codigo;

import Fabrica.DAOFactory;
import Fabrica.Dao.RecomendacionDAO;
import Persistencia.RecomendacionBean;

public class Main {

	public static void main(String[] args) {
		RecomendacionBean recomendacion = new RecomendacionBean();
		
		DAOFactory fabrica = DAOFactory.getDAOFactory(2);
		RecomendacionDAO dao = fabrica.getRecomendacionDAO();
		
		recomendacion.setCodigoRecomendacion(4);
		recomendacion.setCodigoAlumnoReco("u20171A154");
		recomendacion.setCodigoProfesorReco("P001");
		recomendacion.setCodigoCursoReco("C011");
		recomendacion.setDescripcionReco("Es mala profesora");
		recomendacion.setPuntuacion(2);
		
		dao.delete("4");
	}

}
