package Formularios;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Codigo.ConexionUPConsulta;
import Fabrica.DAOFactory;
import Fabrica.Dao.CursoDAO;
import Fabrica.Dao.ProfesorDAO;
import Fabrica.Dao.RecomendacionDAO;
import Persistencia.RecomendacionBean;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.Font;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import com.toedter.calendar.JDateChooser;

public class panelVisualizar extends JPanel {
	private JTable table;
	private JTable table_1;

	/**
	 * Create the panel.
	 */
	public panelVisualizar() {
		setLayout(null);
		
		table = new JTable();
		table.setBounds(289, 5, 0, 0);
		add(table);
		
		DefaultTableModel model=new DefaultTableModel();
		model.addColumn("CodigoAlumno");
		model.addColumn("NombreProfesor");
		model.addColumn("NombreCursoCurso");
		model.addColumn("Descripcion");
		model.addColumn("Puntaje");
		
		
		
		String[] dato=new String[5];
		
		
		
		
		table_1 = new JTable();
		table_1.setBounds(54, 75, 520, 249);
		add(table_1);
		
		table_1.setModel(model);
		
		
		
		//Cargar tabla
		DAOFactory factory=DAOFactory.getDAOFactory(2);
		RecomendacionDAO dao1=factory.getRecomendacionDAO();
		ProfesorDAO dao2=factory.getProfesorDAO();
		CursoDAO dao3=factory.getCursoDAO();
		ArrayList<RecomendacionBean> listaRecomendacion=new ArrayList<RecomendacionBean>();
		listaRecomendacion=dao1.findRecomendacionAlumno(LoginUPConsulta.codigoPrincipal);
		
		
	
		
		for (RecomendacionBean recomendacionBean : listaRecomendacion) {
			dato[0]=Integer.toString(recomendacionBean.getCodigoRecomendacion());
			dato[1]=dao2.findById(recomendacionBean.getCodigoProfesorReco()).getNombreProfesor();
			dato[2]=dao3.findById(recomendacionBean.getCodigoCursoReco()).getNombreCurso();
			dato[3]=Integer.toString(recomendacionBean.getPuntuacion());
			dato[4]=recomendacionBean.getDescripcionReco();
			model.addRow(dato);
		}
		
		JLabel lblMisRecomendaciones = new JLabel("Mis Recomendaciones");
		lblMisRecomendaciones.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblMisRecomendaciones.setBounds(245, 16, 146, 14);
		add(lblMisRecomendaciones);
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				
			}
		});
		btnEditar.setFont(new Font("Rockwell", Font.BOLD, 13));
		btnEditar.setBounds(170, 348, 101, 23);
		add(btnEditar);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				DAOFactory factory=DAOFactory.getDAOFactory(2);
				RecomendacionDAO dao1=factory.getRecomendacionDAO();
			
				int op;
				op=JOptionPane.showConfirmDialog(null, "¿Seguro que desea eliminarlo?:");

				
				if(op==0) {
					String cod;
					cod= (String) table_1.getValueAt(table_1.getSelectedRow(), 0);
				
					dao1.delete(cod);
				}
				int c = model.getRowCount();
				for (int j = 0; j < c ; j++) {
					model.removeRow(0);
				}
				ArrayList<RecomendacionBean> listaRecomendacion=new ArrayList<RecomendacionBean>();
				listaRecomendacion=dao1.findRecomendacionAlumno(LoginUPConsulta.codigoPrincipal);

				for (RecomendacionBean recomendacionBean : listaRecomendacion) {
					dato[0]=Integer.toString(recomendacionBean.getCodigoRecomendacion());
					dato[1]=dao2.findById(recomendacionBean.getCodigoProfesorReco()).getNombreProfesor();
					dato[2]=dao3.findById(recomendacionBean.getCodigoCursoReco()).getNombreCurso();
					dato[3]=Integer.toString(recomendacionBean.getPuntuacion());
					dato[4]=recomendacionBean.getDescripcionReco();
					model.addRow(dato);
				}
			
				
				
			}
		});
		btnEliminar.setFont(new Font("Rockwell", Font.BOLD, 13));
		btnEliminar.setBounds(371, 348, 108, 23);
		add(btnEliminar);
		
		JLabel lblResultados = new JLabel("Resultados:");
		lblResultados.setFont(new Font("Rockwell", Font.PLAIN, 13));
		lblResultados.setBounds(59, 50, 75, 14);
		add(lblResultados);
		
		JButton btnF = new JButton("F5");
		btnF.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				DAOFactory factory=DAOFactory.getDAOFactory(2);
				RecomendacionDAO dao1=factory.getRecomendacionDAO();
				ProfesorDAO dao2=factory.getProfesorDAO();
				CursoDAO dao3=factory.getCursoDAO();
				int c = model.getRowCount();
				for (int j = 0; j < c ; j++) {
					model.removeRow(0);
				}
				ArrayList<RecomendacionBean> listaRecomendacion=new ArrayList<RecomendacionBean>();
				listaRecomendacion=dao1.findRecomendacionAlumno(LoginUPConsulta.codigoPrincipal);
				
				
			
				
				for (RecomendacionBean recomendacionBean : listaRecomendacion) {
					dato[0]=Integer.toString(recomendacionBean.getCodigoRecomendacion());
					dato[1]=dao2.findById(recomendacionBean.getCodigoProfesorReco()).getNombreProfesor();
					dato[2]=dao3.findById(recomendacionBean.getCodigoCursoReco()).getNombreCurso();
					dato[3]=Integer.toString(recomendacionBean.getPuntuacion());
					dato[4]=recomendacionBean.getDescripcionReco();
					model.addRow(dato);
				}
				
			
			}
			
		});
		btnF.setBounds(543, 13, 60, 23);
		add(btnF);

	}
}