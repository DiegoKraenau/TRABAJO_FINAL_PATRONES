package fabricaAlumno;

public class OracleDAOFactoryAlumno implements DAOFactoryAlumno {

	@Override
	public AlumnoDAO getAlumnoDAO() {
		// TODO Auto-generated method stub
		return new AlumnoDAOImplements();
	}

}
