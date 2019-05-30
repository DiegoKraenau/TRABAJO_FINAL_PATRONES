package Formularios;

import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Codigo.ConexionUPConsulta;


import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.naming.spi.DirStateFactory.Result;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JPasswordField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

public class LoginUPConsulta extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	public static String name;
	public static String codigoPrincipal;
	int xx,xy;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginUPConsulta frame = new LoginUPConsulta();
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
	public LoginUPConsulta() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 752, 408);
		contentPane = new JPanel();
		contentPane.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent arg0) {
				int x=arg0.getXOnScreen();
				int y=arg0.getYOnScreen();
				LoginUPConsulta.this.setLocation(x-xx,y-xy);
			}
		});
		contentPane.addMouseListener(new MouseAdapter() {
			@Override
			
			public void mousePressed(MouseEvent e) {
				xx=e.getX();
				xy=e.getY();
			}
		});
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblX = new JLabel("   X");
		lblX.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
	         System.exit(0);
			}
		});
		lblX.setBounds(685, 11, 46, 14);
		contentPane.add(lblX);
		
		JLabel lblNewLabel = new JLabel("UPConsulta");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 68));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(32, 13, 358, 55);
		contentPane.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 51, 51));
		panel_1.setBounds(0, 0, 436, 415);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(219, 5, 1, 1);
		panel_1.add(panel);
		panel.setForeground(Color.MAGENTA);
		panel.setLayout(null);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\Aspire 5\\Desktop\\Practicando Programacion\\Practicando Java\\TFPatrones\\Imagenes\\logo3.png"));
		label.setBounds(10, 84, 411, 287);
		panel_1.add(label);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.LIGHT_GRAY);
		panel_2.setForeground(Color.YELLOW);
		panel_2.setBounds(476, 89, 243, 282);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(105, 54, 105, 20);
		panel_2.add(textField);
		textField.setColumns(10);
		
		JButton btnLogIn = new JButton("Log in");
		btnLogIn.setBounds(77, 209, 89, 23);
		panel_2.add(btnLogIn);
		btnLogIn.setFont(new Font("Times New Roman", Font.BOLD, 15));
		
		JLabel lblContrasea = new JLabel("Password :");
		lblContrasea.setBounds(10, 141, 86, 14);
		panel_2.add(lblContrasea);
		lblContrasea.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 20));
		
		passwordField = new JPasswordField();
		passwordField.setBounds(105, 141, 105, 20);
		panel_2.add(passwordField);
		
		JLabel lblCodigo = new JLabel("User :");
		lblCodigo.setBounds(9, 60, 86, 14);
		panel_2.add(lblCodigo);
		lblCodigo.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 20));
		
		JLabel lblInicioDeSesin = new JLabel("Inicio de Sesi\u00F3n");
		lblInicioDeSesin.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 14));
		lblInicioDeSesin.setBounds(557, 66, 110, 16);
		contentPane.add(lblInicioDeSesin);
		btnLogIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				ConexionUPConsulta conexionUPC=new ConexionUPConsulta();
				Connection pruebaCn=conexionUPC.getConexion();
				
				Statement s2;
				Statement s;
				
				ResultSet rs;
				ResultSet rs2;
				
				String sql="select* from Alumno where codigoAlumno='"+textField.getText()+"' and contraseñaAlumno='"+passwordField.getText()+"'";
				String sql2="select* from Profesor where codigoProfesor='"+textField.getText()+"' and contraseñaProfesor='"+passwordField.getText()+"'";
				
				/*
				try {
					s2=(Statement)pruebaCn.createStatement();
					rs2=((java.sql.Statement)s2).executeQuery(sql2);
					JOptionPane.showMessageDialog(null, "Profesor");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			    */
			
				try {
					s=(Statement)pruebaCn.createStatement();
					s2=(Statement)pruebaCn.createStatement();
					rs=((java.sql.Statement)s).executeQuery(sql);
					//rs2=((java.sql.Statement)s).executeQuery(sql2);
					
					rs2=((java.sql.Statement)s2).executeQuery(sql2);
					
					if(rs.next()) {
						
						codigoPrincipal=rs.getString(1);
						name=rs.getString(3);
						LoginAlumno d2=new LoginAlumno();
						d2.setUndecorated(true);
						d2.show();
						LoginUPConsulta.this.hide();
						
					}else if(rs2.next()){
						codigoPrincipal=rs2.getString(1);
						name=rs2.getString(2);
						LoginProfesor d3=new LoginProfesor();
						d3.show();
						LoginUPConsulta.this.hide();
					}else {
						JOptionPane.showMessageDialog(null, "Contraseña Incorrecta");
					}
					
					
					
					//JOptionPane.showMessageDialog(null, name);
					
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
				
				
				//HOLA AMIGOS DE TODO EL MUNDO
				//ME LLEGAN AL PINCHO CSM
				//AEA LLAMA
			
				
			
				
				
			}
		});
	}
}
