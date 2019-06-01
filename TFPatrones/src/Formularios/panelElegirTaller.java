package Formularios;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTable;

import Codigo.ConexionUPConsulta;

import javax.swing.JButton;
import java.awt.Font;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
		btnInscribirse.setFont(new Font("Rockwell", Font.BOLD, 12));
		btnInscribirse.setBounds(340, 352, 104, 23);
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
		ConexionUPConsulta conexionupc=new ConexionUPConsulta();
		Connection pruebaCn =conexionupc.getConexion();
		
		Statement s;
		ResultSet rs;
		
		String sql="select nombreCurso from Alumno inner join AlumnoCurso on Alumno.codigoAlumno=AlumnoCurso.codigoAlumno2 "+
		"inner join Curso on Curso.codigoCurso=AlumnoCurso.codigoCurso2 where Alumno.codigoAlumno='"+LoginUPConsulta.codigoPrincipal+"'";
		
		
		
		try {
			s=(Statement)pruebaCn.createStatement();
			rs=((java.sql.Statement)s).executeQuery(sql);
			
			while(rs.next()) {
				comboBox.addItem(rs.getString(1));
			}
			
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
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
		
		
		
		JButton btnBuscar = new JButton("OK");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				comboBox_1.setEnabled(true);
				//------------------------CONECTAR PROFESOR----------------
				ConexionUPConsulta conexionupc2=new ConexionUPConsulta();
				Connection pruebaCn2 =conexionupc.getConexion();
				
				Statement s2;
				ResultSet rs2;
				
				String sql2="select nombrePorfesor from Profesor inner join ProfesorCurso on Profesor.codigoProfesor=ProfesorCurso.codigoProfesor2 "+
				"inner join Curso on Curso.codigoCurso=ProfesorCurso.codigoCurso3 where Curso.nombreCurso='"+comboBox.getSelectedItem()+"'";
				
				//JOptionPane.showMessageDialog(null, comboBox.getSelectedItem());
				
				try {
					s2=(Statement)pruebaCn.createStatement();
					rs2=((java.sql.Statement)s2).executeQuery(sql2);
					
					while(rs2.next()) {
						comboBox_1.addItem(rs2.getString(1));
					}
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
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
				ConexionUPConsulta conexionupc2=new ConexionUPConsulta();
				Connection pruebaCn2 =conexionupc.getConexion();
				
				Statement s2;
				ResultSet rs2;
				
				String sql2="select codigoSede2 from SedeProfesor inner join  Profesor on SedeProfesor.codigoProfesor3=Profesor.codigoProfesor\r\n" + 
						"inner join Sede on SedeProfesor.codigoSede2=Sede.codigoSede where Profesor.nombrePorfesor='"+comboBox_1.getSelectedItem()+"'";
				
			
				
				try {
					s2=(Statement)pruebaCn.createStatement();
					rs2=((java.sql.Statement)s2).executeQuery(sql2);
					
					while(rs2.next()) {
						comboBox_2.addItem(rs2.getString(1));
					}
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				//--------------------------------
			}
		});
		btnOk.setFont(new Font("Rockwell", Font.BOLD, 12));
		btnOk.setBounds(304, 81, 89, 23);
		add(btnOk);

	}

}