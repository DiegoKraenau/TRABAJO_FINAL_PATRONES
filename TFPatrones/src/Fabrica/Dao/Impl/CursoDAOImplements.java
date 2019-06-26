package Fabrica.Dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import Codigo.ConexionUPConsulta;
import Fabrica.Dao.CursoDAO;
import Persistencia.CursoBean;

public class CursoDAOImplements implements CursoDAO {
	
	private Connection getConnection(){
		ConexionUPConsulta conex = new ConexionUPConsulta();
		return conex.getConexion();
	}
	
	@Override
	public void save(CursoBean curso) {
		try {
			Connection cn = getConnection();
			String sql = "INSERT INTO Curso VALUES('"+curso.getCodigoCurso()+"','"+curso.getNombreCurso()+"')";
			Statement stm= cn.createStatement();
			stm.executeUpdate(sql);
			stm.close();
			cn.close();
		}catch (Exception e) {
			System.out.println("Ocurrió una excepcion al insertar " + e);
		}
	}

	@Override
	public void update(CursoBean curso) {
		try {
			Connection cn = getConnection();
			String sql = "UPDATE Curso SET nombreCurso = '" + curso.nombreCurso + "' WHERE codigoCurso = '" + curso.codigoCurso + "'";
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
			
			sql="delete Curso where codigoCurso='"+cod+"'";
			
			rs=st.executeUpdate(sql);
		    if(rs==1) {
		    	JOptionPane.showMessageDialog(null, "Se elimino Curso");
		    }else {
		    	JOptionPane.showMessageDialog(null, "El Curso no se pudo eliminar");
		    }
		} catch (Exception e) {
			// TODO: handle exception
			System.out.print(e);
		} 
	}

	@Override
	public CursoBean findById(String cod) {
		Connection con=getConnection();
		Statement st=null;
		ResultSet rs=null;
		String sql;
		CursoBean curso = new CursoBean();
		try {
			st=con.createStatement();
		
			sql="select * from Curso where codigoCurso='"+cod+"'";
			rs=st.executeQuery(sql);
			if(rs.next()) {
				curso.setCodigoCurso(rs.getString(1));
				curso.setNombreCurso(rs.getString(2));
				System.out.println("El Curso si existe.");
				System.out.println(curso.codigoCurso);
				System.out.println(curso.nombreCurso);
			}else {
				System.out.println("El Curso no existe.");
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.print(e);
		}
		return curso;
	}

	@Override
	public ArrayList<CursoBean> findAll() {
		ArrayList<CursoBean> lista = new ArrayList<CursoBean>();
		CursoBean curso = null;
		Connection con = null;
		PreparedStatement pr = null;
		ResultSet rs = null;
		try {
			con=getConnection();
			String sql = "Select * from Curso";
			pr = con.prepareStatement(sql);
			rs = pr.executeQuery();
			while(rs.next()){
				curso = new CursoBean();
				curso.setCodigoCurso(rs.getString("codigoCurso"));
				curso.setNombreCurso(rs.getString("nombreCurso"));
				lista.add(curso);
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
	public ArrayList<CursoBean> findByAlumno(String alumno_id) {
		ArrayList<CursoBean> lista = new ArrayList<CursoBean>();
		CursoBean curso = null;
		Connection con = null;
		PreparedStatement pr = null;
		ResultSet rs = null;
		try {
			con=getConnection();
			String sql = "select * from AlumnoCurso inner join Alumno on Alumno.codigoAlumno=AlumnoCurso.codigoAlumno2 " + 
					"inner join Curso on Curso.codigoCurso=AlumnoCurso.codigoCurso2 where codigoAlumno='"+alumno_id+"'";
			pr = con.prepareStatement(sql);
			rs = pr.executeQuery();
			while(rs.next()){
				curso = new CursoBean();
				curso.setCodigoCurso(rs.getString("codigoCurso"));
				curso.setNombreCurso(rs.getString("nombreCurso"));
				lista.add(curso);
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

    public CursoBean findByNombre(String nombre) {
    	
    	Connection con=getConnection();
		Statement st=null;
		ResultSet rs=null;
		String sql;
		CursoBean curso = new CursoBean();
		try {
			st=con.createStatement();
		
			sql="select * from Curso where nombreCurso='"+nombre+"'";
			rs=st.executeQuery(sql);
			if(rs.next()) {
				curso.setCodigoCurso(rs.getString(1));
				curso.setNombreCurso(rs.getString(2));
				System.out.println("El Curso si existe.");
				
			}else {
				System.out.println("El Curso no existe.");
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.print(e);
		}
		return curso;
    }

	@Override
	public ArrayList<CursoBean> findbyAlumno(String codigoAlumno) {
		ArrayList<CursoBean> listado = new ArrayList<CursoBean>();
		CursoBean curso = null;
		Connection con = null;
		PreparedStatement pr = null;
		ResultSet rs = null;
		try {
			con=getConnection();
			String sql="select nombreCurso from Alumno inner join AlumnoCurso on Alumno.codigoAlumno=AlumnoCurso.codigoAlumno2 "+
					"inner join Curso on Curso.codigoCurso=AlumnoCurso.codigoCurso2 where Alumno.codigoAlumno='"+codigoAlumno+"'";
			pr = con.prepareStatement(sql);
			rs = pr.executeQuery();
			while(rs.next()){
				curso = new CursoBean();
				curso.setNombreCurso(rs.getString("nombreCurso"));
				listado.add(curso);
			}
			rs.close();
			pr.close();
			con.close();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.print(e);
		}
		return listado;
	}

}
