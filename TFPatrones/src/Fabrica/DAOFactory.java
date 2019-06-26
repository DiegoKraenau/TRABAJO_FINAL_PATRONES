package Fabrica;

import Fabrica.Dao.AlumnoDAO;
import Fabrica.Dao.AulaDAO;
import Fabrica.Dao.CursoDAO;
import Fabrica.Dao.ProfesorDAO;
import Fabrica.Dao.RecomendacionDAO;
import Fabrica.Dao.SalonDAO;
import Fabrica.Dao.SedeDAO;
import Fabrica.Dao.TallerDAO;
import Fabrica.Dao.TallerVDAO;

public interface DAOFactory {
	
	public static final int MYSQL=1;
	public static final int SQL=2;
	public static final int Oracle=3;
	
	public abstract AlumnoDAO getAlumnoDAO();
	public abstract CursoDAO getCursoDAO();
	public abstract SedeDAO getSedeDAO();
	public abstract SalonDAO getSalonDAO();
	public abstract ProfesorDAO getProfesorDAO();
	public abstract RecomendacionDAO getRecomendacionDAO();
	public abstract TallerVDAO getTallerVDAO();
	public abstract TallerDAO getTallerDAO();
	public abstract AulaDAO getAulaDAO();
	
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
