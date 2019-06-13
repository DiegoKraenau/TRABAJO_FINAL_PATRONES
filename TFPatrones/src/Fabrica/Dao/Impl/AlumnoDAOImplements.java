package Fabrica.Dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import Codigo.ConexionUPConsulta;
import Fabrica.Dao.AlumnoDAO;
import Persistencia.AlumnoBean;

public class AlumnoDAOImplements implements AlumnoDAO {
	
	
	private Connection getConnection(){
		ConexionUPConsulta conex = new ConexionUPConsulta();
		return conex.getConexion();
	}
	

	@Override
	public void save(AlumnoBean user) {
		// TODO Auto-generated method stub
		String sql;
		Statement st;
		int rs=0;
		Connection con=null;
		
		try {
			con=getConnection();
			sql="insert into Alumno values('"+user.getCodigoAlumno()+"','"+user.getContraseñaAlumno()+"','"+user.getNombreAlumno()+"')";
			st=con.createStatement();
			rs=st.executeUpdate(sql);
			if(rs==1) {
				System.out.println("Se agrego alumno.");
			}else {
				System.out.println("No se agrego alumno.");
			}
			st.close();
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		
	}

	@Override
	public void ValidarLogin(AlumnoBean user) {
		// TODO Auto-generated method stub
		String sql=null;
		
		
		ResultSet rs=null;
		Statement st=null;
		Connection con=getConnection();
		
		try {
			
			sql="select *from Alumno where codigoAlumno='"+user.getCodigoAlumno()+"'";
			st=con.createStatement();
			rs=st.executeQuery(sql);
			
		    if(rs.next()) {
		    	JOptionPane.showMessageDialog(null, "Existe el alumno");
		    }else {
		    	JOptionPane.showMessageDialog(null, "No existe el alumno");
		    }
		    st.close();
		    con.close();
	
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.print("No se puede conectar"+e);
		}
		
		
	}

	@Override
	public void update(AlumnoBean user) {
		// TODO Auto-generated method stub
		String sql;
		Statement st;
		int rs=0;
		Connection con=null;
		
		try {
			con=getConnection();
			sql="Update Alumno set contraseñaAlumno='"+user.getContraseñaAlumno()+"', nombreAlumno='"+user.getNombreAlumno()+"' where codigoAlumno ='"+user.getCodigoAlumno()+"'";
			st=con.createStatement();
			rs=st.executeUpdate(sql);
			if(rs==1) {
				System.out.println("Se modifico Alumno.");
			}else {
				System.out.println("No se modifico Alumno.");
			}
			st.close();
			con.close();
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Ocurrió una excepcion al modificar"+e);
		}
		
		
	}

	@Override
	public void delete(String cod) {
		// TODO Auto-generated method stub
		String sql;
		Connection con=getConnection();
		Statement st=null;
		int rs;
		
		
		try {
			st=con.createStatement();
			
			sql="delete Alumno where codigoAlumno='"+cod+"'";
			
			rs=st.executeUpdate(sql);
		    if(rs==1) {
		    	JOptionPane.showMessageDialog(null, "Se elimino al Alumno");
		    }else {
		    	JOptionPane.showMessageDialog(null, "El alumno no se pudo eliminar");
		    }
			
			
			
		
		} catch (Exception e) {
			// TODO: handle exception
			System.out.print(e);
		} 
		
	}

	@Override
	public AlumnoBean findById(String cod) {
		// TODO Auto-generated method stub
		Connection con=getConnection();
		Statement st=null;
		ResultSet rs=null;
		String sql;
		AlumnoBean alumno = new AlumnoBean();
		try {
			st=con.createStatement();
		
			sql="select * from Alumno where codigoAlumno='"+cod+"'";
			rs=st.executeQuery(sql);
			if(rs.next()) {
				alumno.setCodigoAlumno(rs.getString(1));
				alumno.setContraseñaAlumno(rs.getString(2));
				alumno.setNombreAlumno(rs.getString(3));
				System.out.println("El alumno si existe.");
			}else {
				System.out.println("El alumno no existe.");
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.print(e);
		}
		
		return alumno;
	}

	@Override
	public ArrayList<AlumnoBean> findAll() {
		ArrayList<AlumnoBean> lista = new ArrayList<AlumnoBean>();
		AlumnoBean alumno = null;
		Connection con = null;
		PreparedStatement pr = null;
		ResultSet rs = null;
		try {
			con=getConnection();
			String sql = "Select * from Alumno";
			pr = con.prepareStatement(sql);
			rs = pr.executeQuery();
			while(rs.next()){
				alumno = new AlumnoBean();
				alumno.setCodigoAlumno(rs.getString("codigoAlumno"));
				alumno.setContraseñaAlumno(rs.getString("contraseñaAlumno"));
				alumno.setNombreAlumno(rs.getString("nombreAlumno"));
				lista.add(alumno);
			}
			rs.close();
			pr.close();
			con.close();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.print(e);
		}
		return lista;
	}

}
