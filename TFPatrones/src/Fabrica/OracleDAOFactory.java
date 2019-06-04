package Fabrica;

public class OracleDAOFactory implements DAOFactory {

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

}
