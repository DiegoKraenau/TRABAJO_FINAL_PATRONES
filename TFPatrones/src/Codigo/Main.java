package Codigo;

import java.util.Date;

import Fabrica.DAOFactory;
import Fabrica.Dao.RecomendacionDAO;
import Fabrica.Dao.TallerDAO;
import Persistencia.RecomendacionBean;
import Persistencia.TallerBean;
import Persistencia.TallerVBean;

public class Main {

	public static void main(String[] args) {
		/*RecomendacionBean recomendacion = new RecomendacionBean();*/
		//TallerVBean tallerv=new TallerVBean();
		TallerBean taller=new TallerBean();
		//-------------------------
		DAOFactory fabrica = DAOFactory.getDAOFactory(2);
	//	TallerVDAO dao=fabrica.getTallerVDAO();
		TallerDAO dao1=fabrica.getTallerDAO();
		
		/*
		Date date = new Date();

		
		
		taller.setFechaTaller(date);
		taller.setHoraTaller("15:00");
		taller.setCodigoProfesor("P001");
		taller.setCodigoAula("H205");
		taller.setCodigoCurso("C008");
		taller.setDuracionTaller(2);
		taller.setCodigoSede("Villa");
		taller.setVacantes(36);
		dao1.save(taller);
		*/
		
		/*RecomendacionDAO dao = fabrica.getRecomendacionDAO();
	
		recomendacion.setCodigoRecomendacion(4);
		recomendacion.setCodigoAlumnoReco("u20171A154");
		recomendacion.setCodigoProfesorReco("P001");
		recomendacion.setCodigoCursoReco("C011");
		recomendacion.setDescripcionReco("Es mala profesora");
		recomendacion.setPuntuacion(2);
		
	
		dao.delete("4");*/
		/*tallerv.setCodigoTaller("9090");
		tallerv.setDia("venus");
		tallerv.setCurso("religion");
		tallerv.setProfesor("romero");
		tallerv.setFecha("90/90/99");
		tallerv.setHora("14:00");
		tallerv.setFin("16:00");*/
		
	//	dao.save(tallerv);
		//dao.findById("1010");
	//	dao.delete("9090");
		
	
	}

}
