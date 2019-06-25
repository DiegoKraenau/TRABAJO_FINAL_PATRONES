package Codigo;

import Fabrica.DAOFactory;
import Fabrica.Dao.RecomendacionDAO;
import Fabrica.Dao.TallerVDAO;
import Persistencia.RecomendacionBean;
import Persistencia.TallerVBean;

public class Main {

	public static void main(String[] args) {
		/*RecomendacionBean recomendacion = new RecomendacionBean();*/
		TallerVBean tallerv=new TallerVBean();
		DAOFactory fabrica = DAOFactory.getDAOFactory(2);
		TallerVDAO dao=fabrica.getTallerVDAO();
		/*RecomendacionDAO dao = fabrica.getRecomendacionDAO();
		
		recomendacion.setCodigoRecomendacion(4);
		recomendacion.setCodigoAlumnoReco("u20171A154");
		recomendacion.setCodigoProfesorReco("P001");
		recomendacion.setCodigoCursoReco("C011");
		recomendacion.setDescripcionReco("Es mala profesora");
		recomendacion.setPuntuacion(2);
		
		dao.delete("4");*/
		tallerv.setCodigoTaller("9090");
		tallerv.setDia("venus");
		tallerv.setCurso("religion");
		tallerv.setProfesor("romero");
		tallerv.setFecha("90/90/99");
		tallerv.setHora("14:00");
		tallerv.setFin("16:00");
		
	//	dao.save(tallerv);
		//dao.findById("1010");
	//	dao.delete("9090");
	}

}
