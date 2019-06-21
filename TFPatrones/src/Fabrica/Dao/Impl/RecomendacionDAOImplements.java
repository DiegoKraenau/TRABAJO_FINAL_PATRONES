package Fabrica.Dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import Codigo.ConexionUPConsulta;
import Fabrica.Dao.RecomendacionDAO;
import Formularios.LoginUPConsulta;
import Persistencia.RecomendacionBean;

public class RecomendacionDAOImplements implements RecomendacionDAO{

	private Connection getConnection(){
		ConexionUPConsulta conex = new ConexionUPConsulta();
		return conex.getConexion();
	}
	
	@Override
	public void save(RecomendacionBean t) {
		try {
			Connection cn = getConnection();
			String sql = "INSERT INTO Recomendacion VALUES('"+t.getCodigoAlumnoReco()+"','"+t.getCodigoProfesorReco()+"','"+t.getCodigoCursoReco()+"','"+t.getDescripcionReco()+"','"+t.getPuntuacion()+"')";
			Statement stm= cn.createStatement();
			stm.executeUpdate(sql);
			stm.close();
			cn.close();
		}catch (Exception e) {
			System.out.println("Ocurrió una excepcion al insertar " + e);
		}
	}

	@Override
	public void update(RecomendacionBean t) {
		try {
			Connection cn = getConnection();
			String sql = "UPDATE Recomendacion SET codigoAlumnoReco = '" + t.codigoAlumnoReco + "', codigoProfesorReco = '"+t.codigoProfesorReco+"', codigoCursoReco = '"+t.codigoCursoReco+
						"', descripcionReco = '"+t.descripcionReco+"', puntuacion = '"+t.puntuacion+"' WHERE codigoRecomendacion = '" + t.codigoRecomendacion + "'";
			Statement stm= cn.createStatement();
			stm.executeUpdate(sql);
			stm.close();
			cn.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(String cod) {
		String sql;
		Connection con=getConnection();
		Statement st=null;
		int rs;
		
		try {
			st=con.createStatement();
			
			sql="delete Recomendacion where codigoRecomendacion='"+cod+"'";
			
			rs=st.executeUpdate(sql);
		    if(rs==1) {
		    	JOptionPane.showMessageDialog(null, "Se elimino recomendacion");
		    }else {
		    	JOptionPane.showMessageDialog(null, "La recomendacion no se pudo eliminar");
		    }
		} catch (Exception e) {
			// TODO: handle exception
			System.out.print(e);
		} 
	}

	@Override
	public RecomendacionBean findById(String cod) {
		Connection con=getConnection();
		Statement st=null;
		ResultSet rs=null;
		String sql;
		RecomendacionBean recomendacion = new RecomendacionBean();
		try {
			st=con.createStatement();
		
			sql="select * from Recomendacion where codigoRecomendacion='"+cod+"'";
			rs=st.executeQuery(sql);
			if(rs.next()) {
				recomendacion.setCodigoRecomendacion(rs.getInt(1));
				recomendacion.setCodigoAlumnoReco(rs.getString(2));
				recomendacion.setCodigoProfesorReco(rs.getString(3));
				recomendacion.setCodigoCursoReco(rs.getString(4));
				recomendacion.setDescripcionReco(rs.getString(5));
				recomendacion.setPuntuacion(rs.getInt(6));
				System.out.println("El Curso si existe.");
			}else {
				System.out.println("El Curso no existe.");
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.print(e);
		}
		return recomendacion;
	}

	@Override
	public ArrayList<RecomendacionBean> findAll() {
		ArrayList<RecomendacionBean> lista = new ArrayList<RecomendacionBean>();
		RecomendacionBean recomendacion = null;
		Connection con = null;
		PreparedStatement pr = null;
		ResultSet rs = null;
		try {
			con=getConnection();
			String sql = "Select * from Recomendacion";
			pr = con.prepareStatement(sql);
			rs = pr.executeQuery();
			while(rs.next()){
				recomendacion = new RecomendacionBean();
				recomendacion.setCodigoRecomendacion(rs.getInt(1));
				recomendacion.setCodigoAlumnoReco(rs.getString(2));
				recomendacion.setCodigoProfesorReco(rs.getString(3));
				recomendacion.setCodigoCursoReco(rs.getString(4));
				recomendacion.setDescripcionReco(rs.getString(5));
				recomendacion.setPuntuacion(rs.getInt(6));
				lista.add(recomendacion);
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

	@Override
	public ArrayList<RecomendacionBean> findByProfesor_Curso(String profesor, String Curso) {
		ArrayList<RecomendacionBean> lista = new ArrayList<RecomendacionBean>();
		RecomendacionBean recomendacion = null;
		Connection con = null;
		PreparedStatement pr = null;
		ResultSet rs = null;
		try {
			con=getConnection();
			String sql = "Select * from Recomendacion "
					+ "inner join Profesor on Recomendacion.codigoProfesorReco=Profesor.codigoProfesor "
					+ "inner join Curso on Recomendacion.codigoCursoReco=Curso.codigoCurso "
					+ "where nombreProfesor='"+profesor+"' "
					+ "and nombreCurso='"+Curso+"'";
			
			pr = con.prepareStatement(sql);
			rs = pr.executeQuery();
			while(rs.next()){
				recomendacion = new RecomendacionBean();
				recomendacion.setCodigoRecomendacion(rs.getInt("codigoRecomendacion"));
				recomendacion.setCodigoAlumnoReco(rs.getString("codigoAlumnoReco"));
				recomendacion.setCodigoProfesorReco(rs.getString("codigoProfesorReco"));
				recomendacion.setCodigoCursoReco(rs.getString("codigoCursoReco"));
				recomendacion.setDescripcionReco(rs.getString("descripcionReco"));
				recomendacion.setPuntuacion(rs.getInt("puntuacion"));
				lista.add(recomendacion);
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

	@Override
	public String findPromedio(String profesor, String Curso,int num) {
		// TODO Auto-generated method stub
		ArrayList<RecomendacionBean> lista = new ArrayList<RecomendacionBean>();
		RecomendacionBean recomendacion = null;
		Connection con = null;
		PreparedStatement pr = null;
		ResultSet rs = null;
		try {
			con=getConnection();
			String sql = "Select * from Recomendacion "
					+ "inner join Profesor on Recomendacion.codigoProfesorReco=Profesor.codigoProfesor "
					+ "inner join Curso on Recomendacion.codigoCursoReco=Curso.codigoCurso "
					+ "where nombreProfesor='"+profesor+"' "
					+ "and nombreCurso='"+Curso+"'";
			
			pr = con.prepareStatement(sql);
			rs = pr.executeQuery();
			while(rs.next()){
				recomendacion = new RecomendacionBean();
				recomendacion.setCodigoRecomendacion(rs.getInt("codigoRecomendacion"));
				recomendacion.setCodigoAlumnoReco(rs.getString("codigoAlumnoReco"));
				recomendacion.setCodigoProfesorReco(rs.getString("codigoProfesorReco"));
				recomendacion.setCodigoCursoReco(rs.getString("codigoCursoReco"));
				recomendacion.setDescripcionReco(rs.getString("descripcionReco"));
				recomendacion.setPuntuacion(rs.getInt("puntuacion"));
				lista.add(recomendacion);
			}
			rs.close();
			pr.close();
			con.close();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.print(e);
		}
		
		int suma=0;
		for (RecomendacionBean recomendacionBean : lista) {
			suma=suma+recomendacionBean.getPuntuacion();
		}
		return Integer.toString(suma/num);
	}

	@Override
	public ArrayList<RecomendacionBean> findRecomendacionAlumno(String codigo) {
		// TODO Auto-generated method stub
		
		ArrayList<RecomendacionBean> lista = new ArrayList<RecomendacionBean>();
		RecomendacionBean recomendacion = null;
		Connection con = null;
		PreparedStatement pr = null;
		ResultSet rs = null;
		try {
			con=getConnection();
			String sql = "Select * from Recomendacion where codigoAlumnoReco='"+LoginUPConsulta.codigoPrincipal+"'";
			pr = con.prepareStatement(sql);
			rs = pr.executeQuery();
			while(rs.next()){
				recomendacion = new RecomendacionBean();
				recomendacion.setCodigoRecomendacion(rs.getInt(1));
				recomendacion.setCodigoAlumnoReco(rs.getString(2));
				recomendacion.setCodigoProfesorReco(rs.getString(3));
				recomendacion.setCodigoCursoReco(rs.getString(4));
				recomendacion.setDescripcionReco(rs.getString(5));
				recomendacion.setPuntuacion(rs.getInt(6));
				lista.add(recomendacion);
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
