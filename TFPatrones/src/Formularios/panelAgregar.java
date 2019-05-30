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

import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
		
		
		//----------------------------------------------
		
		//-------------------CONECTANDO PROFESOR------------
		
		
		
		
		
		
		
		//--------------------------------------------------
		
		DefaultTableModel model=new DefaultTableModel();
		model.addColumn("Codigo");
		model.addColumn("Nombre");
		model.addColumn("Curso");
		model.addColumn("Puntaje");
		model.addColumn("Descripcion:");
		
		
		
		String[] dato=new String[5];
		//String requisito=null;
		
		table = new JTable();
		table.setBounds(47, 154, 520, 183);
		add(table);
		
		table.setModel(model);
		
		JButton btnBuscar = new JButton("OK");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				comboBox_1.setEnabled(true);
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
		lblResultados.setBounds(47, 129, 73, 14);
		add(lblResultados);
		
		JLabel lblRecomendaciones = new JLabel("Recomendaciones");
		lblRecomendaciones.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblRecomendaciones.setBounds(266, 11, 124, 14);
		add(lblRecomendaciones);
		
		JLabel label_1 = new JLabel("----");
		
		JButton btnBuscar_1 = new JButton("Buscar");
		btnBuscar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String requisito=null;
				String promedio=null;
				requisito="select codigoRecomendacion,nombrePorfesor,nombreCurso,descripcionReco,puntuacion from Recomendacion inner join Profesor on Recomendacion.codigoProfesorReco=Profesor.codigoProfesor\r\n" + 
						"inner join Curso on Recomendacion.codigoCursoReco=Curso.codigoCurso "+ "where nombreCurso='"+comboBox.getSelectedItem()+"'";
				
				System.out.println(requisito);;
				
				if(comboBox.isEnabled()) {
					requisito="select codigoRecomendacion,nombrePorfesor,nombreCurso,descripcionReco,puntuacion from Recomendacion inner join Profesor on Recomendacion.codigoProfesorReco=Profesor.codigoProfesor\r\n" + 
							"inner join Curso on Recomendacion.codigoCursoReco=Curso.codigoCurso "+ "where nombreCurso='"+comboBox.getSelectedItem()+"' and nombrePorfesor='"+comboBox_1.getSelectedItem()+"'";
				}
				
				promedio="select SUM(puntuacion)/COUNT(Recomendacion.codigoRecomendacion) from Recomendacion inner join Profesor on Recomendacion.codigoProfesorReco=Profesor.codigoProfesor" + 
						" where Profesor.nombrePorfesor='"+comboBox_1.getSelectedItem()+"'";
			
					
			
				
				
				try {
					
					ConexionUPConsulta conexionupc3=new ConexionUPConsulta();
					Connection pruebaCn3 =conexionupc.getConexion();
					
					ConexionUPConsulta conexionupc_4=new ConexionUPConsulta();
					Connection pruebaCn_4 =conexionupc.getConexion();
					
					Statement s3;
					ResultSet rs3;
					Statement s_4;
					ResultSet rs_4;
					
					s3=(Statement)pruebaCn.createStatement();
					rs3=s3.executeQuery(requisito);
					
					s_4=(Statement)pruebaCn_4.createStatement();
					rs_4=s_4.executeQuery(promedio);
				
					while(rs3.next()) {
						dato[0]=rs3.getString(1);
						dato[1]=rs3.getString(2);
						dato[2]=rs3.getString(3);
						dato[3]=rs3.getString(4);
						dato[4]=rs3.getString(5);
						model.addRow(dato);
					}
					if(rs_4.next()) {
						label_1.setText(rs_4.getString(1));
						
					}
					
					
				}catch(SQLException e1) {
					e1.printStackTrace();
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
		label.setBounds(439, 130, 64, 14);
		add(label);
		
		
		label_1.setBounds(510, 130, 46, 14);
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
		
		

	}
}
