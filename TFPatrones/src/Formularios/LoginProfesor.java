package Formularios;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.CardLayout;
import com.toedter.calendar.JCalendar;

public class LoginProfesor extends JFrame {

	private JPanel contentPane;
	panelTallerPresencial pa1=new panelTallerPresencial();
	panelTallerVirtual pa2=new panelTallerVirtual();
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginProfesor frame = new LoginProfesor();
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
	public LoginProfesor() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 854, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.GRAY);
		panel.setBounds(0, 0, 190, 76);
		contentPane.add(panel);
		
		JLabel label = new JLabel("Bienvenido!");
		label.setForeground(Color.WHITE);
		label.setBounds(60, 11, 73, 14);
		panel.add(label);
		
		JLabel label_1 = new JLabel("New label");
		label_1.setIcon(new ImageIcon("Imagenes\\usuarioLogo2.png"));
		label_1.setBounds(10, 41, 26, 24);
		panel.add(label_1);
		
		JLabel label_2 = new JLabel((String) null);
		label_2.setForeground(Color.WHITE);
		label_2.setBounds(46, 46, 134, 19);
		panel.add(label_2);
		label_2.setText(LoginUPConsulta.name);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(Color.BLACK);
		panel_1.setBounds(0, 76, 190, 403);
		contentPane.add(panel_1);
		
	
	
		
		
		JButton btnAgregarTallerPresencial = new JButton("Agregar Taller Presencial");
		btnAgregarTallerPresencial.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
			
			}
		});
		btnAgregarTallerPresencial.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				pa1.setVisible(true);
				pa2.setVisible(false);
			}
		});
		btnAgregarTallerPresencial.setForeground(Color.WHITE);
		btnAgregarTallerPresencial.setBackground(Color.DARK_GRAY);
		btnAgregarTallerPresencial.setBounds(0, 11, 190, 34);
		panel_1.add(btnAgregarTallerPresencial);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 69, 0));
		panel_2.setBounds(189, 0, 649, 411);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(20, 21, 607, 366);
		panel_2.add(panel_3);
		panel_3.setLayout(new BorderLayout(0, 0));
		
		JButton btnAgregarTallerVirtual = new JButton("Agregar Taller Virtual");
		btnAgregarTallerVirtual.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panel_3.add(pa2);
				pa1.setVisible(false);
				pa2.setVisible(true);
			}
		});
		btnAgregarTallerVirtual.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				
			}
		});
		btnAgregarTallerVirtual.setForeground(Color.WHITE);
		btnAgregarTallerVirtual.setBackground(Color.DARK_GRAY);
		btnAgregarTallerVirtual.setBounds(0, 45, 190, 34);
		panel_1.add(btnAgregarTallerVirtual);
		
		JLabel label_3 = new JLabel("");
		label_3.setIcon(new ImageIcon("Imagenes\\logoUPC4.png"));
		label_3.setBounds(53, 215, 70, 94);
		panel_1.add(label_3);
		
		
		
		
	
		panel_3.add(pa1);
		
		
		
		
		
		
		
	}
}

