package Fabrica.Dao.Impl;

import java.sql.Statement;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import Codigo.ConexionUPConsulta;
import Fabrica.Dao.ProfesorDAO;
import Persistencia.ProfesorBean;

public class ProfesorDAOImplements implements ProfesorDAO {

	private Connection getConnection(){
		ConexionUPConsulta conex = new ConexionUPConsulta();
		return conex.getConexion();
	}
	
	@Override
	public void save(ProfesorBean profesor) {
		String sql;
		Statement st;
		int rs=0;
		Connection con=null;
		try {
			con=getConnection();
			sql="insert into Profesor values('"+profesor.getCodigoProfesor()+"','"+profesor.getNombreProfesor()+"','"+profesor.getContraseñaProfesor()+"')";
			st=con.createStatement();
			rs=st.executeUpdate(sql);
			if(rs==1) {
				System.out.println("Se agrego Profesor.");
			}else {
				System.out.println("No se agrego Profesor.");
			}
			st.close();
			con.close();
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Ocurrio una excepcion al insertar "+ e);
		}
	}

	@Override
	public void update(ProfesorBean profesor) {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String sql;
		Connection con=getConnection();
		Statement st=null;
		int rs;
		String Codigonew;
		String Passwordnew;
		String Namenew;
		
		
		try {
			st=con.createStatement();
			System.out.println("Digite el nuevo 'Codigo' del Profesor:");
			Codigonew=br.readLine();
			System.out.println("Digite el nuevo 'Password' del Profesor:");
			Passwordnew=br.readLine();
			System.out.println("Digite el nuevo 'Nombre' del Profesor:");
			Namenew=br.readLine();
			sql="update Profesor set codigoProfesor='"+Codigonew+"',contraseñaProfesor='"+Passwordnew+"',nombrePorfesor='"+Namenew+"' where codigoProfesor='"+profesor.getCodigoProfesor()+"'";
			
			rs=st.executeUpdate(sql);
			
			if(rs==1) {
				//System.out.print(rs);
				System.out.println("Se pudo modificar Profesor");
			
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.print(e);
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
			
			sql="delete Profesor where codigoProfesor='"+cod+"'";
			
			rs=st.executeUpdate(sql);
		    if(rs==1) {
		    	JOptionPane.showMessageDialog(null, "Se elimino Profesor");
		    }else {
		    	JOptionPane.showMessageDialog(null, "Ocurrió un error al eliminar Profesor");
		    }
			
			
			
		
		} catch (Exception e) {
			// TODO: handle exception
			System.out.print(e);
		} 
	}

	@Override
	public ProfesorBean findById(String cod) {
		// TODO Auto-generated method stub
		Connection con=getConnection();
		Statement st=null;
		ResultSet rs=null;
		String sql;
		ProfesorBean profesor = new ProfesorBean();
		try {
			st=con.createStatement();
		
			sql="select * from Profesor where codigoProfesor='"+cod+"'";
			rs=st.executeQuery(sql);
			if(rs.next()) {
				profesor.setCodigoProfesor(rs.getString(1));
				profesor.setContraseñaProfesor(rs.getString(2));
				profesor.setNombreProfesor(rs.getString(3));
				System.out.println("El profesor existe.");
			}else {
				System.out.println("El Profesor no existe.");
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.print(e);
		}
		return profesor;
	}

	@Override
	public  ArrayList<ProfesorBean> findAll() {
		// TODO Auto-generated method stub
		ArrayList<ProfesorBean> listaprofesor = new ArrayList<ProfesorBean>();
		ProfesorBean profesor = null;
		Connection con = null;
		PreparedStatement pr = null;
		ResultSet rs = null;
		try {
			con=getConnection();
			String sql = "Select * from Profesor";
			pr = con.prepareStatement(sql);
			rs = pr.executeQuery();
			while(rs.next()){
				profesor = new ProfesorBean();
				profesor.setCodigoProfesor(rs.getString("codigoProfesor"));
				listaprofesor.add(profesor);
			}
			rs.close();
			pr.close();
			con.close();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.print(e);
		}
		return listaprofesor;
	}

}
