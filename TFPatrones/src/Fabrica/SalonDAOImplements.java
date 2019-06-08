package Fabrica;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import Codigo.ConexionUPConsulta;
import persistencia.CursoBean;
import persistencia.SalonBean;

public class SalonDAOImplements implements SalonDAO {

	private Connection getConnection(){
		ConexionUPConsulta conex = new ConexionUPConsulta();
		return conex.getConexion();
	}
	
	@Override
	public void InsertarSalon(SalonBean salon) {
		String sql;
		Statement st;
		int rs=0;
		Connection con=null;
		
		try {
			con=getConnection();
			sql="insert into Salon values('"+salon.getCodigoSalon()+"','"+salon.getDisponibilidad()+"')";
			st=con.createStatement();
			rs=st.executeUpdate(sql);
			if(rs==1) {
				System.out.println("Se agrego Salon.");
			}else {
				System.out.println("No se agrego Salon.");
			}
			st.close();
			con.close();
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Ocurrió una excepcion al insertar"+e);
		}

		
	}

	@Override
	public void update(SalonBean salon) {
		String sql;
		Statement st;
		int rs=0;
		Connection con=null;
		
		try {
			con=getConnection();
			sql="Update Salon set disponibilidad='"+salon.getDisponibilidad()+"where codigoSalon ='"+salon.getCodigoSalon()+"'";
			st=con.createStatement();
			rs=st.executeUpdate(sql);
			if(rs==1) {
				System.out.println("Se modifico Salon.");
			}else {
				System.out.println("No se modifico Salon.");
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
			
			sql="delete Salon where codigoSalon='"+cod+"'";
			
			rs=st.executeUpdate(sql);
		    if(rs==1) {
		    	JOptionPane.showMessageDialog(null, "Se elimino Salon");
		    }else {
		    	JOptionPane.showMessageDialog(null, "El Salon no se pudo eliminar");
		    }
		} catch (Exception e) {
			// TODO: handle exception
			System.out.print(e);
		} 
		
	}

	@Override
	public SalonBean searchxCod(String cod) {
		Connection con=getConnection();
		Statement st=null;
		ResultSet rs=null;
		String sql;
		SalonBean salon = new SalonBean();
		try {
			st=con.createStatement();
		
			sql="select * from Salon where codigoSalon='"+cod+"'";
			rs=st.executeQuery(sql);
			if(rs.next()) {
				salon.setCodigoSalon(rs.getString(1));
				salon.setDisponibilidad(rs.getInt(2));
				System.out.println("El Salon si existe.");
				System.out.println(salon.getCodigoSalon());
				System.out.println(salon.getDisponibilidad());
			}else {
				System.out.println("El Salon no existe.");
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.print(e);
		}
		return salon;
	}

	@Override
	public ArrayList<SalonBean> listarSalones() {
		ArrayList<SalonBean> lista = new ArrayList<SalonBean>();
		SalonBean salon = null;
		Connection con = null;
		PreparedStatement pr = null;
		ResultSet rs = null;
		try {
			con=getConnection();
			String sql = "Select * from Salon";
			pr = con.prepareStatement(sql);
			rs = pr.executeQuery();
			while(rs.next()){
				salon = new SalonBean();
				salon.setCodigoSalon(rs.getString(1));
				salon.setDisponibilidad(rs.getInt(2));
				lista.add(salon);
			}
			rs.close();
			pr.close();
			con.close();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.print(e);
		}
		return lista;	}

}
