package Formularios;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Codigo.ConexionUPConsulta;
import Fabrica.DAOFactory;
import Fabrica.Dao.CursoDAO;
import Fabrica.Dao.ProfesorDAO;
import Fabrica.Dao.TallerDAO;

import javax.swing.JButton;
import java.awt.Font;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import Persistencia.CursoBean;
import Persistencia.ProfesorBean;
import Persistencia.TallerBean;

public class panelMisTalleres extends JPanel {
	private JTable table;

	/**
	 * Create the panel.
	 */
	public panelMisTalleres() {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Talleres inscritos");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel.setBounds(257, 11, 144, 32);
		add(lblNewLabel);
		
		DefaultTableModel model=new DefaultTableModel();
		model.addColumn("Codigo");
		model.addColumn("Fecha");
		model.addColumn("Hora");
		model.addColumn("Profesor");
		model.addColumn("Duracion");
		model.addColumn("Sede");
		model.addColumn("Curso");
		model.addColumn("Aula");
		model.addColumn("Vacantes");
		
		String[] dato=new String[9];
		
		table = new JTable();
		table.setBounds(28, 95, 602, 246);
		add(table);
		
		JLabel lblResultados = new JLabel("Resultados:");
		lblResultados.setBounds(28, 52, 68, 14);
		add(lblResultados);	
		
		table.setModel(model);
		
		DAOFactory factory=DAOFactory.getDAOFactory(2);
		TallerDAO dao1=factory.getTallerDAO();
		
		ArrayList<TallerBean> listaTalleres=new ArrayList<TallerBean>();
		listaTalleres=dao1.findbyAlumno(LoginUPConsulta.codigoPrincipal);
		
		for (TallerBean tallerBean : listaTalleres) {
			dato[0]= Integer.toString(tallerBean.codigoTaller);
			dato[1]= tallerBean.fechaTaller.toString();
			dato[2]= tallerBean.horaTaller;
			ProfesorDAO dao2 = factory.getProfesorDAO();
			ProfesorBean pro = dao2.findById(tallerBean.codigoProfesor);
			dato[3]= pro.nombreProfesor;
			dato[4]= Integer.toString(tallerBean.duracionTaller);
			dato[5]= tallerBean.codigoSede;
			CursoDAO dao3 = factory.getCursoDAO();
			CursoBean cur = dao3.findById(tallerBean.codigoCurso);
			dato[6]= cur.nombreCurso;
			dato[7]= tallerBean.codigoAula;
			dato[8]= Integer.toString(tallerBean.vacantes);
			model.addRow(dato);
		}
		
		JButton btnBuscar_1 = new JButton("Borrar");
		btnBuscar_1.setFont(new Font("Rockwell", Font.BOLD, 13));
		btnBuscar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dao1.deleteByAlumno(Integer.parseInt((String)table.getValueAt(table.getSelectedRow(), 0)),LoginUPConsulta.codigoPrincipal);
				int c = model.getRowCount();
				for (int j = 0; j < c ; j++) {
					model.removeRow(0);
				}
				ArrayList<TallerBean> listaTalleres=new ArrayList<TallerBean>();
				listaTalleres=dao1.findbyAlumno(LoginUPConsulta.codigoPrincipal);
				
				for (TallerBean tallerBean : listaTalleres) {
					dato[0]= Integer.toString(tallerBean.codigoTaller);
					dato[1]= tallerBean.fechaTaller.toString();
					dato[2]= tallerBean.horaTaller;
					ProfesorDAO dao2 = factory.getProfesorDAO();
					ProfesorBean pro = dao2.findById(tallerBean.codigoProfesor);
					dato[3]= pro.nombreProfesor;
					dato[4]= Integer.toString(tallerBean.duracionTaller);
					dato[5]= tallerBean.codigoSede;
					CursoDAO dao3 = factory.getCursoDAO();
					CursoBean cur = dao3.findById(tallerBean.codigoCurso);
					dato[6]= cur.nombreCurso;
					dato[7]= tallerBean.codigoAula;
					dato[8]= Integer.toString(tallerBean.vacantes);
					model.addRow(dato);
				}
			}
		});
		btnBuscar_1.setBounds(525, 362, 89, 23);
		add(btnBuscar_1);
		
		JLabel lblSiDeseasRetirar = new JLabel("Si deseas retirar tu inscripci\u00F3n, selecciona una inscripci\u00F3n y de click en borrar.");
		lblSiDeseasRetirar.setBounds(38, 352, 890, 44);
		add(lblSiDeseasRetirar);
		
		JLabel lblId = new JLabel("Id");
		lblId.setBounds(53, 77, 46, 14);
		add(lblId);
		
		JLabel lblFecha = new JLabel("Fecha");
		lblFecha.setBounds(99, 77, 46, 14);
		add(lblFecha);
		
		JLabel lblHora = new JLabel("Hora");
		lblHora.setBounds(169, 77, 46, 14);
		add(lblHora);
		
		JLabel lblProfesor = new JLabel("Profesor");
		lblProfesor.setBounds(227, 77, 101, 14);
		add(lblProfesor);
		
		JLabel lblDuracion = new JLabel("Duracion");
		lblDuracion.setBounds(302, 77, 101, 14);
		add(lblDuracion);
		
		JLabel lblSede = new JLabel("Sede");
		lblSede.setBounds(375, 77, 46, 14);
		add(lblSede);
		
		JButton btnF = new JButton("F5");
		btnF.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int c = model.getRowCount();
				for (int j = 0; j < c ; j++) {
					model.removeRow(0);
				}
				ArrayList<TallerBean> listaTalleres=new ArrayList<TallerBean>();
				listaTalleres=dao1.findbyAlumno(LoginUPConsulta.codigoPrincipal);
				
				for (TallerBean tallerBean : listaTalleres) {
					dato[0]= Integer.toString(tallerBean.codigoTaller);
					dato[1]= tallerBean.fechaTaller.toString();
					dato[2]= tallerBean.horaTaller;
					ProfesorDAO dao2 = factory.getProfesorDAO();
					ProfesorBean pro = dao2.findById(tallerBean.codigoProfesor);
					dato[3]= pro.nombreProfesor;
					dato[4]= Integer.toString(tallerBean.duracionTaller);
					dato[5]= tallerBean.codigoSede;
					CursoDAO dao3 = factory.getCursoDAO();
					CursoBean cur = dao3.findById(tallerBean.codigoCurso);
					dato[6]= cur.nombreCurso;
					dato[7]= tallerBean.codigoAula;
					dato[8]= Integer.toString(tallerBean.vacantes);
					model.addRow(dato);
				}
			}
		});
		btnF.setBounds(568, 29, 62, 23);
		add(btnF);
		
		JLabel lblCurso = new JLabel("Curso");
		lblCurso.setBounds(442, 77, 46, 14);
		add(lblCurso);
		
		JLabel lblAula = new JLabel("Aula");
		lblAula.setBounds(508, 77, 46, 14);
		add(lblAula);
		
		JLabel lblVacantes = new JLabel("Vacantes");
		lblVacantes.setBounds(568, 77, 83, 14);
		add(lblVacantes);

	}
}