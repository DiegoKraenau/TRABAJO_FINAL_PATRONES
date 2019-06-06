package Fabrica;

import java.sql.Statement;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import Codigo.ConexionUPConsulta;
import persistencia.ProfesorBean;
import persistencia.SedeBean;

public class ProfesorDAOImplements implements ProfesorDAO {

	private Connection getConnection(){
		ConexionUPConsulta conex = new ConexionUPConsulta();
		return conex.getConexion();
	}
	
	@Override
	public void InsertarProfesor(ProfesorBean profesor) {
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
			sql="update Profesor set codigoProfesor='"+Codigonew+"',contraseñaProfesor='"+Passwordnew+"',nombreProfesor='"+Namenew+"' where codigoProfesor='"+profesor.getCodigoProfesor()+"'";
			
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
	public void searchxCod(String cod) {
		// TODO Auto-generated method stub
		Connection con=getConnection();
		Statement st=null;
		ResultSet rs=null;
		String sql;
	
		
		try {
			st=con.createStatement();
		
			sql="select * from Profesor where codigoProfesor='"+cod+"'";
			rs=st.executeQuery(sql);
			if(rs.next()) {
				System.out.println("El profesor existe.");
				System.out.println(rs.getString(1));
				System.out.println(rs.getString(2));
				System.out.println(rs.getString(3));
			}else {
				System.out.println("El Profesor no existe.");
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.print(e);
		}
	}

	@Override
	public  ArrayList<ProfesorBean> listarProfesor() {
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
