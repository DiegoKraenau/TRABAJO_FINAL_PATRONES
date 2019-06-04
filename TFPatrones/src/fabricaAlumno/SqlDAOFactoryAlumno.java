package fabricaAlumno;

public class SqlDAOFactoryAlumno implements DAOFactoryAlumno {

	@Override
	public AlumnoDAO getAlumnoDAO() {
		// TODO Auto-generated method stub
		return new AlumnoDAOImplements();
	}

}
