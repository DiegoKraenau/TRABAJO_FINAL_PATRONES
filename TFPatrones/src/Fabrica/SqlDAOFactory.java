package Fabrica;

import Fabrica.Dao.AlumnoDAO;
import Fabrica.Dao.CursoDAO;
import Fabrica.Dao.ProfesorDAO;
import Fabrica.Dao.RecomendacionDAO;
import Fabrica.Dao.SalonDAO;
import Fabrica.Dao.SedeDAO;
import Fabrica.Dao.TallerDAO;
import Fabrica.Dao.TallerVDAO;
import Fabrica.Dao.Impl.AlumnoDAOImplements;
import Fabrica.Dao.Impl.CursoDAOImplements;
import Fabrica.Dao.Impl.ProfesorDAOImplements;
import Fabrica.Dao.Impl.RecomendacionDAOImplements;
import Fabrica.Dao.Impl.SalonDAOImplements;
import Fabrica.Dao.Impl.SedeDAOImplements;
import Fabrica.Dao.Impl.TallerDAOImplements;
import Fabrica.Dao.Impl.TallerVDAOImplements;

public class SqlDAOFactory implements DAOFactory {

	@Override
	public AlumnoDAO getAlumnoDAO() {
		// TODO Auto-generated method stub
		return new AlumnoDAOImplements();
	}

	@Override
	public CursoDAO getCursoDAO() {
		// TODO Auto-generated method stub
		return new CursoDAOImplements();
	}

	@Override
	public SedeDAO getSedeDAO() {
		// TODO Auto-generated method stub
		return new SedeDAOImplements();
	}

	@Override
	public SalonDAO getSalonDAO() {
		// TODO Auto-generated method stub
		return new SalonDAOImplements();
	}

	@Override
	public ProfesorDAO getProfesorDAO() {
		// TODO Auto-generated method stub
		return new ProfesorDAOImplements();
	}

	@Override
	public TallerVDAO getTallerVDAO() {
		// TODO Auto-generated method stub
		return new TallerVDAOImplements();
	}

	@Override
	public RecomendacionDAO getRecomendacionDAO() {
		// TODO Auto-generated method stub
		return new RecomendacionDAOImplements();
	}

	@Override
	public TallerDAO getTallerDAO() {
		// TODO Auto-generated method stub
		return new TallerDAOImplements();
	}

}
