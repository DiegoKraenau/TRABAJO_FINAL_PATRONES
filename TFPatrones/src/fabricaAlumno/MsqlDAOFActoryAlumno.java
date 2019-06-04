package fabricaAlumno;

public class MsqlDAOFActoryAlumno implements DAOFactoryAlumno {

	@Override
	public AlumnoDAO getAlumnoDAO() {
		// TODO Auto-generated method stub
		return new AlumnoDAOImplements();
	}

}
