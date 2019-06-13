package Fabrica.Dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import Codigo.ConexionUPConsulta;
import Fabrica.Dao.SalonDAO;
import Persistencia.SalonBean;

public class SalonDAOImplements implements SalonDAO {

	private Connection getConnection(){
		ConexionUPConsulta conex = new ConexionUPConsulta();
		return conex.getConexion();
	}
	
	@Override
	public void save(SalonBean salon) {
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
		try {
			Connection cn = getConnection();
			String sql = "UPDATE Salon SET disponibilidad = '" + salon.disponibilidad + "' WHERE codigoSalon = '" + salon.codigoSalon + "'";
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
	public SalonBean findById(String cod) {
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
	public ArrayList<SalonBean> findAll() {
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
