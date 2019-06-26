package Fabrica.Dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import Codigo.ConexionUPConsulta;
import Fabrica.Dao.SedeDAO;
import Persistencia.SedeBean;

public class SedeDAOImplements implements SedeDAO {

	private Connection getConnection(){
		ConexionUPConsulta conex = new ConexionUPConsulta();
		return conex.getConexion();
	}
	
	@Override
	public void save(SedeBean sede) {
		String sql;
		Statement st;
		int rs=0;
		Connection con=null;
		
		try {
			con=getConnection();
			sql="insert into Sede values('"+sede.getCodigoSede()+"')";
			st=con.createStatement();
			rs=st.executeUpdate(sql);
			if(rs==1) {
				System.out.println("Se agrego Sede.");
			}else {
				System.out.println("No se agrego Sede.");
			}
			st.close();
			con.close();
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Ocurrió una excepcion al insertar"+e);
		}

	}

	@Override
	public void update(SedeBean sede) {
		// TODO Auto-generated method stub
	}

	@Override
	public void delete(String cod) {
		String sql;
		Connection con=getConnection();
		Statement st=null;
		int rs;
		
		try {
			st=con.createStatement();
			
			sql="delete Sede where codigoSede='"+cod+"'";
			
			rs=st.executeUpdate(sql);
		    if(rs==1) {
		    	JOptionPane.showMessageDialog(null, "Se elimino Sede");
		    }else {
		    	JOptionPane.showMessageDialog(null, "El Sede no se pudo eliminar");
		    }
		} catch (Exception e) {
			// TODO: handle exception
			System.out.print(e);
		} 

	}

	@Override
	public SedeBean findById(String cod) {
		Connection con=getConnection();
		Statement st=null;
		ResultSet rs=null;
		String sql;
		SedeBean sede = new SedeBean();
		try {
			st=con.createStatement();
		
			sql="select * from Sede where codigoSede='"+cod+"'";
			rs=st.executeQuery(sql);
			if(rs.next()) {
				sede.setCodigoSede(rs.getString(1));
				System.out.println("La Sede si existe.");
				System.out.println(sede.codigoSede);
			}else {
				System.out.println("La Sede no existe.");
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.print(e);
		}
		return sede;
	}

	@Override
	public ArrayList<SedeBean> findAll() {
		ArrayList<SedeBean> lista = new ArrayList<SedeBean>();
		SedeBean sede = null;
		Connection con = null;
		PreparedStatement pr = null;
		ResultSet rs = null;
		try {
			con=getConnection();
			String sql = "Select * from Sede";
			pr = con.prepareStatement(sql);
			rs = pr.executeQuery();
			while(rs.next()){
				sede = new SedeBean();
				sede.setCodigoSede(rs.getString("codigoSede"));
				lista.add(sede);
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
	public ArrayList<SedeBean> findbyProf(Object nombreProf) {
		ArrayList<SedeBean> listado = new ArrayList<SedeBean>();
		SedeBean sede = null;
		Connection con = null;
		PreparedStatement pr = null;
		ResultSet rs = null;
		try {
			con=getConnection();
			String sql="select codigoSede from Sede inner join SedeProfesor on Sede.codigoSede=SedeProfesor.codigoSede2 "+
					"inner join Profesor on Profesor.codigoProfesor=SedeProfesor.codigoProfesor3 where Profesor.nombreProfesor='"+nombreProf+"'";
			pr = con.prepareStatement(sql);
			rs = pr.executeQuery();
			while(rs.next()){
				sede = new SedeBean();
				sede.setCodigoSede(rs.getString("codigoSede"));
				listado.add(sede);
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
