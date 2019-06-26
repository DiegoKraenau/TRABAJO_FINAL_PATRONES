package Fabrica.Dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import Codigo.ConexionUPConsulta;
import Fabrica.Dao.TallerDAO;
import Persistencia.AlumnoBean;
import Persistencia.TallerBean;

public class TallerDAOImplements implements TallerDAO {

	private Connection getConnection(){
		ConexionUPConsulta conex = new ConexionUPConsulta();
		return conex.getConexion();
	}
	
	@Override
	public void save(TallerBean t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(TallerBean t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteByAlumno(int codT, String codA) {
		String sql;
		Connection con=getConnection();
		Statement st=null;
		int rs;
		
		try {
			st=con.createStatement();
			
			sql="delete TallerAlumno where codigoAlumno='"+codA+"' and codigoTaller='"+codT+"'" ;
			
			rs=st.executeUpdate(sql);
		    if(rs==1) {
		    	JOptionPane.showMessageDialog(null, "Se elimino tu inscripción para el taller");
		    }else {
		    	JOptionPane.showMessageDialog(null, "No hay taller para eliminar");
		    }
		} catch (Exception e) {
			// TODO: handle exception
			System.out.print(e);
		} 
	}

	@Override
	public TallerBean findById(String cod) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<TallerBean> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<TallerBean> findbyAlumno(String codigoAlumno) {
		ArrayList<TallerBean> listado = new ArrayList<TallerBean>();
		TallerBean taller = null;
		Connection con = null;
		PreparedStatement pr = null;
		ResultSet rs = null;
		try {
			con=getConnection();
			String sql = "Select t.codigoTaller, t.fechaTaller, t.horaTaller, t.codigoProfesor, t.duracionTaller, t.codigoSede, t.codigoCurso, t.codigoAula from Taller t INNER JOIN TallerAlumno ta on t.codigoTaller = ta.codigoTaller WHERE ta.codigoAlumno = '"+codigoAlumno+"'";
			pr = con.prepareStatement(sql);
			rs = pr.executeQuery();
			while(rs.next()){
				taller = new TallerBean();
				taller.setCodigoTaller(rs.getInt("codigoTaller"));
				taller.setFechaTaller(rs.getDate("fechaTaller"));
				taller.setHoraTaller(rs.getString("horaTaller"));
				taller.setCodigoProfesor(rs.getString("codigoProfesor"));
				taller.setDuracionTaller(rs.getInt("duracionTaller"));
				taller.setCodigoSede(rs.getString("codigoSede"));
				taller.setCodigoCurso(rs.getString("codigoCurso"));
				taller.setCodigoAula(rs.getString("codigoAula"));
				listado.add(taller);
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

	@Override
	public void delete(String cod) {
		// TODO Auto-generated method stub
		
	}

}
