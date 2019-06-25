package Fabrica.Dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import Codigo.ConexionUPConsulta;
import Fabrica.Dao.TallerVDAO;
import Persistencia.AlumnoBean;
import Persistencia.TallerVBean;

public class TallerVDAOImplements implements TallerVDAO{
	private Connection getConnection(){
		ConexionUPConsulta conex = new ConexionUPConsulta();
		return conex.getConexion();
	}
	@Override
	public void save(TallerVBean t) {
		// TODO Auto-generated method stub
		String sql;
		Statement st;
		int rs=0;
		Connection con=null;
		
		try {
			con=getConnection();
			sql="insert into TallerVirtual values('"+t.getCodigoTaller()+"','"+t.getDia()+"','"+t.getCurso()+t.getProfesor()+t.getFecha()+t.getHora()+t.getFin()+"')";
			st=con.createStatement();
			rs=st.executeUpdate(sql);
			if(rs==1) {
				System.out.println("Se agrego nuevo Taller.");
			}else {
				System.out.println("No se pudo agregar Taller.");
			}
			st.close();
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		
	}

	@Override
	public void update(TallerVBean t) {
		// TODO Auto-generated method stub
		String sql;
		Statement st;
		int rs=0;
		Connection con=null;
		
		try {
			con=getConnection();
			sql="Update TallerVirtual set nombreDia='"+
			t.getDia()+
			"', nombreCur='"+
			t.getCurso()+
			"', nombrePro='"+
			t.getProfesor()+
			"', fecha='"+
			t.getFecha()+
			"', hora='"+
			t.getHora()+
			"', fin='"+
			t.getFin()+"' where codigoTaller ='"+t.getCodigoTaller()+"'";
			st=con.createStatement();
			rs=st.executeUpdate(sql);
			if(rs==1) {
				System.out.println("Se modifico Taller Virtual.");
			}else {
				System.out.println("No se pudo modificar Taller Virtual.");
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
			
			sql="delete TallerVirtual where codigoTaller='"+cod+"'";
			
			rs=st.executeUpdate(sql);
		    if(rs==1) {
		    	JOptionPane.showMessageDialog(null, "Se elimino Taller Virtual");
		    }else {
		    	JOptionPane.showMessageDialog(null, "El Taller Virtual no se pudo Eliminar");
		    }
			
			
			
		
		} catch (Exception e) {
			// TODO: handle exception
			System.out.print(e);
		} 
	}

	@Override
	public TallerVBean findById(String cod) {
		// TODO Auto-generated method stub
		Connection con=getConnection();
		Statement st=null;
		ResultSet rs=null;
		String sql;
		TallerVBean TallerV = new TallerVBean();
		try {
			st=con.createStatement();
		
			sql="select * from TallerVirtual where codigoTaller='"+cod+"'";
			rs=st.executeQuery(sql);
			if(rs.next()) {
				TallerV.setCodigoTaller(rs.getString(1));
				TallerV.setDia(rs.getString(2));
				TallerV.setCurso(rs.getString(3));
				TallerV.setProfesor(rs.getString(4));
				TallerV.setFecha(rs.getString(5));
				TallerV.setHora(rs.getString(6));
				TallerV.setFin(rs.getString(7));
				System.out.println("El Taller Virtual si existe.");
			}else {
				System.out.println("El Taller Virtual no existe.");
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.print(e);
		}
		
		return TallerV;
	}

	@Override
	public ArrayList<TallerVBean> findAll() {
		// TODO Auto-generated method stub
		ArrayList<TallerVBean> lista = new ArrayList<TallerVBean>();
		TallerVBean TallerV = null;
		Connection con = null;
		PreparedStatement pr = null;
		ResultSet rs = null;
		try {
			con=getConnection();
			String sql = "Select * from Alumno";
			pr = con.prepareStatement(sql);
			rs = pr.executeQuery();
			while(rs.next()){
				TallerV = new TallerVBean();
				TallerV.setCodigoTaller(rs.getString("codigoTaller"));
				TallerV.setDia(rs.getString("nombreDia"));
				TallerV.setCurso(rs.getString("nombreCur"));
				
				TallerV.setProfesor(rs.getString("nombrePro"));
				TallerV.setFecha(rs.getString("fecha"));
				TallerV.setHora(rs.getString("hora"));
				
				TallerV.setFin(rs.getString("fin"));
				lista.add(TallerV);
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
