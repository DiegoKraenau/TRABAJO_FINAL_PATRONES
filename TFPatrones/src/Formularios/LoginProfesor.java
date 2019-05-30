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

public class LoginProfesor extends JFrame {

	private JPanel contentPane;

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
		setBounds(100, 100, 738, 518);
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
		label_1.setIcon(new ImageIcon("C:\\Users\\Aspire 5\\Desktop\\Practicando Programacion\\Practicando Java\\TFPatrones\\Imagenes\\usuarioLogo2.png"));
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
		btnAgregarTallerPresencial.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnAgregarTallerPresencial.setForeground(Color.WHITE);
		btnAgregarTallerPresencial.setBackground(Color.DARK_GRAY);
		btnAgregarTallerPresencial.setBounds(0, 11, 190, 34);
		panel_1.add(btnAgregarTallerPresencial);
		
		JButton btnAgregarTallerVirtual = new JButton("Agregar Taller Virtual");
		btnAgregarTallerVirtual.setForeground(Color.WHITE);
		btnAgregarTallerVirtual.setBackground(Color.DARK_GRAY);
		btnAgregarTallerVirtual.setBounds(0, 45, 190, 34);
		panel_1.add(btnAgregarTallerVirtual);
		
		JLabel label_3 = new JLabel("");
		label_3.setIcon(new ImageIcon("C:\\Users\\Aspire 5\\Desktop\\Practicando Programacion\\Practicando Java\\TFPatrones\\Imagenes\\logoUPC4.png"));
		label_3.setBounds(53, 215, 70, 94);
		panel_1.add(label_3);
	}
}
