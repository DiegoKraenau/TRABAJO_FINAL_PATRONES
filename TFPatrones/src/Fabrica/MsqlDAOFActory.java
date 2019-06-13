package Fabrica;

import Fabrica.Dao.AlumnoDAO;
import Fabrica.Dao.CursoDAO;
import Fabrica.Dao.ProfesorDAO;
import Fabrica.Dao.RecomendacionDAO;
import Fabrica.Dao.SalonDAO;
import Fabrica.Dao.SedeDAO;
import Fabrica.Dao.Impl.AlumnoDAOImplements;
import Fabrica.Dao.Impl.SedeDAOImplements;

public class MsqlDAOFActory implements DAOFactory {

	@Override
	public AlumnoDAO getAlumnoDAO() {
		// TODO Auto-generated method stub
		return new AlumnoDAOImplements();
	}

	@Override
	public CursoDAO getCursoDAO() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SedeDAO getSedeDAO() {
		// TODO Auto-generated method stub
		return new SedeDAOImplements();
	}

	@Override
	public SalonDAO getSalonDAO() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProfesorDAO getProfesorDAO() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RecomendacionDAO getRecomendacionDAO() {
		// TODO Auto-generated method stub
		return null;
	}

}
