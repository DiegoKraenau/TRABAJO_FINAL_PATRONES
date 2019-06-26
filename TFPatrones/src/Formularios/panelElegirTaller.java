package Formularios;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Codigo.ConexionUPConsulta;
import Fabrica.DAOFactory;
import Fabrica.Dao.AulaDAO;
import Fabrica.Dao.CursoDAO;
import Fabrica.Dao.ProfesorDAO;
import Fabrica.Dao.SedeDAO;
import Fabrica.Dao.TallerDAO;
import Persistencia.AulaBean;
import Persistencia.CursoBean;
import Persistencia.ProfesorBean;
import Persistencia.SedeBean;
import Persistencia.TallerBean;

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

public class panelElegirTaller extends JPanel {
	private JTable table;

	/**
	 * Create the panel.
	 */
	public panelElegirTaller() {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Taller");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel.setBounds(294, 11, 99, 14);
		add(lblNewLabel);
		
		table = new JTable();
		table.setBounds(28, 122, 569, 219);
		add(table);
		
		JButton btnInscribirse = new JButton("Inscribirse");
		btnInscribirse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DAOFactory factory=DAOFactory.getDAOFactory(2);
				TallerDAO dao1=factory.getTallerDAO();
				dao1.inscripcionTaller(Integer.parseInt((String)table.getValueAt(table.getSelectedRow(), 0)),LoginUPConsulta.codigoPrincipal);
			}
		});
		btnInscribirse.setFont(new Font("Rockwell", Font.BOLD, 12));
		btnInscribirse.setBounds(159, 352, 104, 23);
		add(btnInscribirse);
		
		JLabel lblNewLabel_1 = new JLabel("Curso :");
		lblNewLabel_1.setFont(new Font("Rockwell", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(28, 52, 61, 14);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Profesor:");
		lblNewLabel_2.setFont(new Font("Rockwell", Font.PLAIN, 13));
		lblNewLabel_2.setBounds(226, 52, 68, 14);
		add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Sede:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_3.setBounds(449, 52, 46, 14);
		add(lblNewLabel_3);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(99, 49, 81, 20);
		add(comboBox);
		
		//---------------------CONECTAR CURSO-----------------------------
		DAOFactory factory=DAOFactory.getDAOFactory(2);
		CursoDAO dao1=factory.getCursoDAO();
		
		ArrayList<CursoBean> listaCurso=new ArrayList<CursoBean>();
		listaCurso=dao1.findbyAlumno(LoginUPConsulta.codigoPrincipal);
		
		for(CursoBean cur : listaCurso) {
			comboBox.addItem(cur.getNombreCurso());
		}
		
		
		//---------------------------------------------------------
		
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setEnabled(false);
		comboBox_1.setBounds(304, 50, 89, 20);
		add(comboBox_1);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setEnabled(false);
		comboBox_2.setBounds(522, 49, 81, 20);
		add(comboBox_2);
		
		//------------------------CONECTAR PROFESOR----------------
		
		JButton btnBuscar = new JButton("OK");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				comboBox_1.setEnabled(true);
				
				DAOFactory factory=DAOFactory.getDAOFactory(2);
				ProfesorDAO dao1=factory.getProfesorDAO();
				
				ArrayList<ProfesorBean> listaProfesor=new ArrayList<ProfesorBean>();
				listaProfesor=dao1.findbyCurso(comboBox.getSelectedItem());
				
				for(ProfesorBean pro : listaProfesor) {
					comboBox_1.addItem(pro.getNombreProfesor());
				}
				
				//--------------------------------
			}
		});
		btnBuscar.setFont(new Font("Rockwell", Font.BOLD, 12));
		btnBuscar.setBounds(99, 80, 81, 23);
		add(btnBuscar);
		
		JLabel lblResultados = new JLabel("Resultados:");
		lblResultados.setBounds(28, 103, 68, 14);
		add(lblResultados);
		
		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				comboBox_2.setEnabled(true);
				//------------------------CONECTAR PROFESOR----------------
				
				DAOFactory factory=DAOFactory.getDAOFactory(2);
				SedeDAO dao1=factory.getSedeDAO();
				
				ArrayList<SedeBean> listaSede=new ArrayList<SedeBean>();
				listaSede=dao1.findbyProf(comboBox_1.getSelectedItem());
				
				for(SedeBean sed : listaSede) {
					comboBox_2.addItem(sed.getCodigoSede());
				}
				
				//--------------------------------
			}
		});
		btnOk.setFont(new Font("Rockwell", Font.BOLD, 12));
		btnOk.setBounds(304, 81, 89, 23);
		add(btnOk);
		
		
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
		
		
		table.setModel(model);
		
		
		JButton btnBuscar_1 = new JButton("Buscar");
		btnBuscar_1.setFont(new Font("Rockwell", Font.BOLD, 13));
		btnBuscar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int c = model.getRowCount();
				for (int j = 0; j < c ; j++) {
					model.removeRow(0);
				}
				
				DAOFactory factory=DAOFactory.getDAOFactory(2);
				TallerDAO dao1=factory.getTallerDAO();
				ArrayList<TallerBean> listaTalleres=new ArrayList<TallerBean>();
				
				ProfesorDAO dao2 = factory.getProfesorDAO();
				CursoDAO dao3 = factory.getCursoDAO();
				ProfesorBean pro = dao2.findByNombre((String)comboBox_1.getSelectedItem());
				CursoBean cur = dao3.findByNombre((String)comboBox.getSelectedItem());
				
				listaTalleres=dao1.findbyCurProSed(cur.codigoCurso, pro.codigoProfesor, (String)comboBox_2.getSelectedItem());
				for (TallerBean tallerBean : listaTalleres) {
					dato[0]= Integer.toString(tallerBean.codigoTaller);
					dato[1]= tallerBean.fechaTaller.toString();
					dato[2]= tallerBean.horaTaller;
					pro = dao2.findById(tallerBean.codigoProfesor);
					dato[3]= pro.nombreProfesor;
					dato[4]= Integer.toString(tallerBean.duracionTaller);
					dato[5]= tallerBean.codigoSede;
					cur = dao3.findById(tallerBean.codigoCurso);
					dato[6]= cur.nombreCurso;
					dato[7]= tallerBean.codigoAula;
					dato[8]= Integer.toString(tallerBean.vacantes);
					model.addRow(dato);
				}
				
			}
		});
		btnBuscar_1.setBounds(374, 352, 89, 23);
		add(btnBuscar_1);

	}
}
