package Formularios;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Codigo.ConexionUPConsulta;

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
				//OBTENER CODIGO CURSO
				String codigo=null;
				ConexionUPConsulta conexionupc4=new ConexionUPConsulta();
				Connection pruebaCn4 =conexionupc.getConexion();
				
				Statement s4;
				ResultSet rs4;
				
				String sql4="select codigoCurso from Curso where Curso.nombreCurso='"+comboBox.getSelectedItem()+"'";
				
				
				
				try {
					s4=(Statement)pruebaCn4.createStatement();
					rs4=((java.sql.Statement)s4).executeQuery(sql4);
					
					while(rs4.next()) {
						codigo=rs4.getString(1);
						
					}
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				//OBTENER CODIGO PROFESOR
				String codigoP=null;
				ConexionUPConsulta conexionupc5=new ConexionUPConsulta();
				Connection pruebaCn5 =conexionupc.getConexion();
				
				Statement s5;
				ResultSet rs5;
				
				String sql5="select codigoProfesor from Profesor where Profesor.nombrePorfesor='"+comboBox_1.getSelectedItem()+"'";
				
			
				
				
				
				try {
					s5=(Statement)pruebaCn5.createStatement();
					rs5=((java.sql.Statement)s5).executeQuery(sql5);
					
					while(rs5.next()) {
						codigoP=rs5.getString(1);
						
					}
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				//AGREGAR COMENTARIO
				ConexionUPConsulta conexionupc3=new ConexionUPConsulta();
				Connection pruebaCn3=conexionupc3.getConexion();
				
				Statement s3;
				int rs3;
				String sql3="insert into Recomendacion values ('"+LoginUPConsulta.codigoPrincipal+"','"+codigoP+"','"+codigo+"','"
				+textField.getText()+"',"+comboBox_2.getSelectedItem()+")";
				
				System.out.println();
				System.out.println(sql3);
				
				try {
					s3=(Statement)pruebaCn3.createStatement();
					rs3=s3.executeUpdate(sql3);
					JOptionPane.showMessageDialog(null, "Recomendacion Agregada");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				
				
			}
		});
		btnNewButton.setBounds(184, 286, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnOk = new JButton("OK");
		btnOk.setFont(new Font("Rockwell", Font.BOLD, 13));
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
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
