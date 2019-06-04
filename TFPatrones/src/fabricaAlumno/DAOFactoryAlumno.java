package fabricaAlumno;

public interface DAOFactoryAlumno {
	
	public static final int MYSQL=1;
	public static final int SQL=2;
	public static final int Oracle=3;
	
	public abstract AlumnoDAO getAlumnoDAO();
	
	public static DAOFactoryAlumno getDAOFactoryAlumno(int whichFactory){
	       switch(whichFactory){
	       
	       	case MYSQL:
	       	    return new MsqlDAOFActoryAlumno();
	       	  
	       	case SQL:
	       	    return  new SqlDAOFactoryAlumno();
	       	  
	       	case Oracle:
	       	    return  new OracleDAOFactoryAlumno();
	       	default:
	       	    return null;
	       }
	    }

}
