package Formularios;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Codigo.ConexionUPConsulta;
import Fabrica.DAOFactory;
import Fabrica.Dao.AlumnoDAO;
import Fabrica.Dao.CursoDAO;
import Fabrica.Dao.ProfesorDAO;
import Fabrica.Dao.RecomendacionDAO;
import Persistencia.CursoBean;
import Persistencia.ProfesorBean;
import Persistencia.RecomendacionBean;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;



public class panelAgregar extends JPanel {
	private JTable table;
	public static String num;
	public static String nombre;
	public static String curso;
	public static int puntaje;
	public static String descripcion;
	

	/**
	 * Create the panel.
	 */
	public panelAgregar() {
		setBackground(Color.LIGHT_GRAY);
		setForeground(Color.GREEN);
		setLayout(null);
		
		JLabel lblBuscarCurso = new JLabel("Buscar Curso :");
		lblBuscarCurso.setFont(new Font("Rockwell", Font.PLAIN, 13));
		lblBuscarCurso.setBounds(47, 48, 89, 14);
		add(lblBuscarCurso);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(229, 45, 89, 20);
		add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setEnabled(false);
		
		//-----------CONECTANDO CURSO----------------
		
		List<CursoBean> cursos;
		
		DAOFactory fabrica = DAOFactory.getDAOFactory(2);
		CursoDAO dao1 = fabrica.getCursoDAO();
		
		cursos = dao1.findByAlumno(LoginUPConsulta.codigoPrincipal);
		
		for (CursoBean cursoBean : cursos) {
			comboBox.addItem(cursoBean.nombreCurso);
		}
		
		
		//----------------------------------------------
		
		//-------------------CONECTANDO PROFESOR------------
		
		
		
		
		
		
		
		//--------------------------------------------------
		
		DefaultTableModel model=new DefaultTableModel();
	
		
		
		
		
		//String requisito=null;
		
		table = new JTable();
		table.setBounds(47, 154, 520, 183);
		add(table);
		
	
		
		JButton btnBuscar = new JButton("OK");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ProfesorDAO dao2 = fabrica.getProfesorDAO();
				
				List<ProfesorBean> profesores = dao2.findByCurso(comboBox.getSelectedItem().toString());
				
				for (ProfesorBean profesorBean : profesores) {
					comboBox_1.addItem(profesorBean.nombreProfesor);
				}
				
				comboBox_1.setEnabled(true);
				
				
			}
		});
		btnBuscar.setFont(new Font("Rockwell", Font.BOLD, 13));
		btnBuscar.setBounds(356, 44, 89, 23);
		add(btnBuscar);
		
		JLabel lblBuscarProfesor = new JLabel("Buscar Profesor:");
		lblBuscarProfesor.setFont(new Font("Rockwell", Font.PLAIN, 13));
		lblBuscarProfesor.setBounds(47, 81, 102, 14);
		add(lblBuscarProfesor);
		
		
		comboBox_1.setBounds(229, 78, 89, 20);
		add(comboBox_1);
		
		
		
		//LoginUPConsulta.codigoPrincipal;
		
		
		JLabel lblResultados = new JLabel("Resultados:");
		lblResultados.setFont(new Font("Rockwell", Font.PLAIN, 13));
		lblResultados.setBounds(47, 106, 73, 14);
		add(lblResultados);
		
		JLabel lblRecomendaciones = new JLabel("Recomendaciones");
		lblRecomendaciones.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblRecomendaciones.setBounds(266, 11, 124, 14);
		add(lblRecomendaciones);
		
		JLabel label_1 = new JLabel("----");
		
		model.addColumn("Codigo");
		model.addColumn("Nombre");
		model.addColumn("Curso");
		model.addColumn("Puntaje");
		model.addColumn("Descripcion:");
		
		DefaultTableModel model2=new DefaultTableModel();
		model2.addColumn("Nombre");
		model2.addColumn("Curso");
		model2.addColumn("Puntaje");	
		
		
		
		
		JLabel lblNewLabel = new JLabel("Codigo");
		lblNewLabel.setBounds(57, 129, 46, 14);
		add(lblNewLabel);
		lblNewLabel.setVisible(false);
		
		JLabel lblNewLabel_1 = new JLabel("Profesor");
		lblNewLabel_1.setBounds(164, 129, 73, 14);
		add(lblNewLabel_1);
		lblNewLabel_1.setVisible(false);
		
		JLabel lblNewLabel_2 = new JLabel("Curso");
		lblNewLabel_2.setBounds(272, 129, 46, 14);
		add(lblNewLabel_2);
		lblNewLabel_2.setVisible(false);
		
		JLabel lblNewLabel_3 = new JLabel("Descripcion");
		lblNewLabel_3.setBounds(476, 129, 79, 14);
		add(lblNewLabel_3);
		lblNewLabel_3.setVisible(false);
		
		JLabel lblNewLabel_4 = new JLabel("Puntaje");
		lblNewLabel_4.setBounds(383, 129, 46, 14);
		add(lblNewLabel_4);
		lblNewLabel_4.setVisible(false);
		
		
		JButton btnBuscar_1 = new JButton("Buscar");
		btnBuscar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				DAOFactory factory=DAOFactory.getDAOFactory(2);
				if(comboBox_1.isEnabled() ) {
					lblNewLabel_1.setBounds(164, 129, 73, 14);
					lblNewLabel_4.setBounds(383, 129, 46, 14);
					lblNewLabel.setVisible(true);
					lblNewLabel_1.setVisible(true);
					lblNewLabel_2.setVisible(true);
					lblNewLabel_3.setVisible(true);
					lblNewLabel_4.setVisible(true);
					
					
				
					String[] dato=new String[5];
					
					table.setModel(model);
					
					int c = model.getRowCount();
					for (int j = 0; j < c ; j++) {
						model.removeRow(0);
					}
				RecomendacionDAO dao1=factory.getRecomendacionDAO();
				ProfesorDAO dao2=factory.getProfesorDAO();
				CursoDAO dao3=factory.getCursoDAO();
				
				ArrayList<RecomendacionBean> listaRecomendacion=new ArrayList<RecomendacionBean>();
				listaRecomendacion=dao1.findByProfesor_Curso(comboBox_1.getSelectedItem().toString(), comboBox.getSelectedItem().toString());
				
				
				
				for (RecomendacionBean recomendacionBean : listaRecomendacion) {
					dato[0]=Integer.toString(recomendacionBean.getCodigoRecomendacion());
					dato[1]=dao2.findById(recomendacionBean.getCodigoProfesorReco()).getContraseñaProfesor();
					dato[2]=dao3.findById(recomendacionBean.getCodigoCursoReco()).getNombreCurso();
					dato[3]=Integer.toString(recomendacionBean.getPuntuacion());
					dato[4]=recomendacionBean.getDescripcionReco();
					model.addRow(dato);
					
					label_1.setText(dao1.findPromedio(comboBox_1.getSelectedItem().toString(), comboBox.getSelectedItem().toString(),model.getRowCount()));
				}
				
				}
				
				
				
				if(comboBox_1.isEnabled()==false) {	
					
				
					lblNewLabel_1.setBounds(57, 129, 56, 14);
					lblNewLabel_4.setBounds(476, 129, 79, 14);
				
					
					lblNewLabel.setVisible(false);
					lblNewLabel_1.setVisible(true);
					lblNewLabel_2.setVisible(true);
					lblNewLabel_3.setVisible(false);
					lblNewLabel_4.setVisible(true);
					
					String[] dato2=new String[3];
					
					
					table.setModel(model2);

					DAOFactory factory2=DAOFactory.getDAOFactory(2);
					RecomendacionDAO dao4=factory.getRecomendacionDAO();
					ProfesorDAO dao5=factory.getProfesorDAO();
					CursoDAO dao6=factory.getCursoDAO();
					System.out.println("dog");
					int c = model2.getRowCount();
					for (int j = 0; j < c ; j++) {
						model2.removeRow(0);
					}
					ArrayList<RecomendacionBean> listaRecomendacion2=new ArrayList<RecomendacionBean>();
					
					listaRecomendacion2=dao4.findRecomendacionCurso(comboBox.getSelectedItem().toString());
					
					for (RecomendacionBean recomendacionBean : listaRecomendacion2) {
						System.out.println(dao5.findById(recomendacionBean.getCodigoProfesorReco()).getNombreProfesor());
						dato2[0]=dao5.findById(recomendacionBean.getCodigoProfesorReco()).getNombreProfesor();
						dato2[1]=dao6.findById(recomendacionBean.getCodigoCursoReco()).getNombreCurso();
						dato2[2]=Integer.toString(recomendacionBean.getPuntuacion());
						model2.addRow(dato2);
						
					}
					

					
				}
				
				
			}
			
			
			
		});
		btnBuscar_1.setFont(new Font("Rockwell", Font.BOLD, 13));
		btnBuscar_1.setBounds(97, 348, 124, 23);
		add(btnBuscar_1);
		
		JButton btnAgregarRecomendacion = new JButton("Agregar");
		btnAgregarRecomendacion.setFont(new Font("Rockwell", Font.BOLD, 13));
		btnAgregarRecomendacion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				agregarRecomendacion p1=new agregarRecomendacion();
				p1.setUndecorated(true);
				p1.show();
				
				
			}
		});
		btnAgregarRecomendacion.setBounds(266, 348, 111, 23);
		add(btnAgregarRecomendacion);
		
		JLabel label = new JLabel("Promedio:");
		label.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		label.setBounds(435, 112, 64, 14);
		add(label);
		
		
		label_1.setBounds(495, 112, 46, 14);
		add(label_1);
		
		JButton btnVer = new JButton("Ver");
		btnVer.setFont(new Font("Rockwell", Font.BOLD, 13));
		btnVer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//JOptionPane.showMessageDialog(null, table.getValueAt(table.getSelectedRow(), table.getSelectedColumn()));
				//table.get
				
				
				panelAgregar.num=(String) table.getValueAt(table.getSelectedRow(), table.getSelectedColumn());
				//JOptionPane.showMessageDialog(null, panelAgregar.num);
				verRecomendacion p1=new verRecomendacion();
				p1.setUndecorated(true);
				p1.show();
			}
		});
		btnVer.setBounds(414, 348, 89, 23);
		add(btnVer);
		
		JButton btnDeshabilitar = new JButton("Disable");
		btnDeshabilitar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				comboBox_1.setEnabled(false);
				
				
			}
		});
		btnDeshabilitar.setFont(new Font("Rockwell", Font.BOLD, 13));
		btnDeshabilitar.setBounds(356, 78, 89, 23);
		add(btnDeshabilitar);
	
		
		

	}
}
