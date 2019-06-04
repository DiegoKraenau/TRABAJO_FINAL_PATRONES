package fabricaAlumno;

public interface DAOFactory {
	
	public static final int MYSQL=1;
	public static final int SQL=2;
	public static final int Oracle=3;
	
	public abstract AlumnoDAO getAlumnoDAO();
	public abstract CursoDAO getCursoDAO();
	
	public static DAOFactory getDAOFactory(int whichFactory){
	       switch(whichFactory){
	       
	       	case MYSQL:
	       	    return new MsqlDAOFActory();
	       	  
	       	case SQL:
	       	    return  new SqlDAOFactory();
	       	  
	       	case Oracle:
	       	    return  new OracleDAOFactory();
	       	default:
	       	    return null;
	       }
	    }

}
