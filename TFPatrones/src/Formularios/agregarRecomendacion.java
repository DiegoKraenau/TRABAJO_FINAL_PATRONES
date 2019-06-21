package Formularios;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Codigo.ConexionUPConsulta;
import Fabrica.DAOFactory;
import Fabrica.Dao.AlumnoDAO;
import Fabrica.Dao.CursoDAO;
import Fabrica.Dao.ProfesorDAO;
import Fabrica.Dao.RecomendacionDAO;
import Persistencia.CursoBean;
import Persistencia.ProfesorBean;
import Persistencia.RecomendacionBean;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

public class agregarRecomendacion extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	int xx,xy;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					agregarRecomendacion frame = new agregarRecomendacion();
					frame.setUndecorated(true);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public agregarRecomendacion() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 520, 371);
		contentPane = new JPanel();
		contentPane.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent arg0) {
				int x=arg0.getXOnScreen();
				int y=arg0.getYOnScreen();
				agregarRecomendacion.this.setLocation(x-xx,y-xy);
			}
		});
		contentPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				xx=arg0.getX();
				xy=arg0.getY();
				
				
			}
		});
		contentPane.setBackground(new Color(255, 51, 102));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Curso :");
		lblNewLabel.setBackground(new Color(204, 51, 102));
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblNewLabel.setBounds(43, 47, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblProfesor = new JLabel("Profesor :");
		lblProfesor.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblProfesor.setBounds(43, 82, 63, 14);
		contentPane.add(lblProfesor);
		
		JLabel lblPuntaje = new JLabel("Puntaje :");
		lblPuntaje.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblPuntaje.setBounds(43, 122, 46, 14);
		contentPane.add(lblPuntaje);
		
		JLabel lblDescripcion = new JLabel("Descripcion :");
		lblDescripcion.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblDescripcion.setBounds(43, 163, 90, 14);
		contentPane.add(lblDescripcion);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(165, 44, 87, 20);
		contentPane.add(comboBox);
		
		
		//------------CONECTAR CURSOS---------------
		
		DAOFactory fabrica = DAOFactory.getDAOFactory(2);
		CursoDAO dao1 = fabrica.getCursoDAO();
		ArrayList<CursoBean> listadoCurso=new ArrayList<CursoBean>();
		listadoCurso=dao1.findByAlumno(LoginUPConsulta.codigoPrincipal);
		for (CursoBean cursoBean : listadoCurso) {
			comboBox.addItem(cursoBean.getNombreCurso());
		}
		
		
		

		
		//----------------------------
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(165, 79, 87, 20);
		contentPane.add(comboBox_1);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"}));
		comboBox_2.setBounds(165, 119, 87, 20);
		contentPane.add(comboBox_2);
		
		textField = new JTextField();
		textField.setBounds(165, 161, 217, 102);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Agregar");
		btnNewButton.setFont(new Font("Rockwell", Font.BOLD, 13));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				DAOFactory fabrica=DAOFactory.getDAOFactory(2);
				CursoDAO dao1=fabrica.getCursoDAO();
				ProfesorDAO dao2=fabrica.getProfesorDAO();
				RecomendacionDAO dao3=fabrica.getRecomendacionDAO();
				
				//OBTENER CODIGO CURSO
				String codigo=null;
				codigo=dao1.findByNombre(comboBox.getSelectedItem().toString()).getCodigoCurso();
				
				
				//OBTENER CODIGO PROFESOR
				String codigoP=null;
				codigoP=dao2.findByNombre(comboBox_1.getSelectedItem().toString()).getCodigoProfesor();
				
				
				
				//AGREGAR COMENTARIO
				
				RecomendacionBean recomendacion=new RecomendacionBean();
				recomendacion.setCodigoAlumnoReco(LoginUPConsulta.codigoPrincipal);
				recomendacion.setCodigoCursoReco(codigo);
				recomendacion.setCodigoProfesorReco(codigoP);
				recomendacion.setDescripcionReco(textField.getText());
				recomendacion.setPuntuacion(Integer.parseInt(comboBox_2.getSelectedItem().toString()));
				recomendacion.setCodigoRecomendacion(1);;//Recordar que es IDENTITY
				
				dao3.save(recomendacion);
				
				
				
				
				
			}
		});
		btnNewButton.setBounds(184, 286, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnOk = new JButton("OK");
		btnOk.setFont(new Font("Rockwell", Font.BOLD, 13));
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DAOFactory fabrica = DAOFactory.getDAOFactory(2);
				ProfesorDAO dao1 = fabrica.getProfesorDAO();
				ArrayList<ProfesorBean> listaprofesor = new ArrayList<ProfesorBean>();
				listaprofesor=dao1.findByCurso(comboBox.getSelectedItem().toString());
				
				comboBox_1.setEnabled(true);
				
				 for (ProfesorBean profesorBean : listaprofesor) {
					 comboBox_1.addItem(profesorBean.getNombreProfesor());
				}
				
				
				
				
			}
		});
		btnOk.setBounds(332, 43, 89, 23);
		contentPane.add(btnOk);
		
		JLabel lblNewLabel_1 = new JLabel("  X");
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				agregarRecomendacion.this.hide();
			}
		});
		lblNewLabel_1.setBounds(448, 11, 46, 14);
		contentPane.add(lblNewLabel_1);
	}
}