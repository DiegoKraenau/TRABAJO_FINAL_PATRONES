package Fabrica;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import Codigo.ConexionUPConsulta;
import persistencia.AlumnoBean;

public class AlumnoDAOImplements implements AlumnoDAO {
	
	
	private Connection getConnection(){
		ConexionUPConsulta conex = new ConexionUPConsulta();
		return conex.getConexion();
	}
	

	@Override
	public void InsertarAlumno(AlumnoBean user) {
		// TODO Auto-generated method stub
		String sql;
		Statement st;
		int rs=0;
		Connection con=null;
		
		try {
			con=getConnection();
			sql="insert into Alumno values('"+user.getCodigoAlumno()+"','"+user.getContrase�aAlumno()+"','"+user.getNombreAlumno()+"')";
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
			sql="Update Alumno set contrase�aAlumno='"+user.getContrase�aAlumno()+"', nombreAlumno='"+user.getNombreAlumno()+"' where codigoAlumno ='"+user.getCodigoAlumno()+"'";
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
			System.out.println("Ocurri� una excepcion al modificar"+e);
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
	public void searchxCod(String cod) {
		// TODO Auto-generated method stub
		Connection con=getConnection();
		Statement st=null;
		ResultSet rs=null;
		String sql;
	
		
		try {
			st=con.createStatement();
		
			sql="select * from Alumno where codigoAlumno='"+cod+"'";
			rs=st.executeQuery(sql);
			if(rs.next()) {
				System.out.println("El alumno si existe.");
				System.out.println(rs.getString(1));
				System.out.println(rs.getString(2));
				System.out.println(rs.getString(3));
			}else {
				System.out.println("El alumno no existe.");
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.print(e);
		}
		
		
	}

	@Override
	public ArrayList<AlumnoBean> listarUser(String name) {
		// TODO Auto-generated method stub
		return null;
	}

}