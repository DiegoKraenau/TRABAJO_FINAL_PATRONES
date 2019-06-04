package Fabrica;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import Codigo.ConexionUPConsulta;
import persistencia.CursoBean;

public class CursoDAOImplements implements CursoDAO {
	
	private Connection getConnection(){
		ConexionUPConsulta conex = new ConexionUPConsulta();
		return conex.getConexion();
	}
	
	@Override
	public void InsertarCurso(CursoBean curso) {
		String sql;
		Statement st;
		int rs=0;
		Connection con=null;
		
		try {
			con=getConnection();
			sql="insert into Curso values('"+curso.getCodigoCurso()+"','"+curso.getNombreCurso()+"')";
			st=con.createStatement();
			rs=st.executeUpdate(sql);
			if(rs==1) {
				System.out.println("Se agrego Curso.");
			}else {
				System.out.println("No se agrego Curso.");
			}
			st.close();
			con.close();
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Ocurrió una excepcion al insertar"+e);
		}
		
	}

	@Override
	public void update(CursoBean curso) {
		String sql;
		Statement st;
		int rs=0;
		Connection con=null;
		
		try {
			con=getConnection();
			sql="Update Curso set nombreCurso='"+curso.getNombreCurso()+"where codigoCurso ='"+curso.getCodigoCurso()+"'";
			st=con.createStatement();
			rs=st.executeUpdate(sql);
			if(rs==1) {
				System.out.println("Se modifico Curso.");
			}else {
				System.out.println("No se modifico Curso.");
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
	public CursoBean searchxCod(String cod) {
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
	public ArrayList<CursoBean> listarCursos() {
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
}
