package Formularios;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;
import java.awt.event.MouseMotionAdapter;
import javax.swing.JTabbedPane;
import javax.swing.JSplitPane;
import javax.swing.JLayeredPane;
import javax.swing.JSlider;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.Font;


public class LoginAlumno extends JFrame implements ActionListener {

	private JPanel contentPane;
	int xx,xy;
	panelAgregar p2=new panelAgregar();
	panelVisualizar p3=new panelVisualizar();
	panelElegirTaller p4=new panelElegirTaller();
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginAlumno frame = new LoginAlumno();
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
	public LoginAlumno() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 854, 449);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 69, 0));
		contentPane.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent arg0) {
				
				int x=arg0.getXOnScreen();
				int y=arg0.getYOnScreen();
				LoginAlumno.this.setLocation(x-xx,y-xy);
			}
		});
		contentPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				xx=arg0.getX();
				xy=arg0.getY();
			}
		});
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 190, 76);
		panel.setBackground(Color.GRAY);
		contentPane.add(panel);
		
		JPanel panelGeneral = new JPanel();
		panel.setLayout(null);
		
		
		JLabel lblBienvenido = new JLabel("Bienvenido!");
		lblBienvenido.setBounds(60, 11, 73, 14);
		lblBienvenido.setForeground(Color.WHITE);
		panel.add(lblBienvenido);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBounds(10, 41, 26, 24);
		lblNewLabel_1.setIcon(new ImageIcon("Imagenes\\usuarioLogo2.png"));
		panel.add(lblNewLabel_1);
	
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(46, 46, 134, 19);
		lblNewLabel.setText(LoginUPConsulta.name);
		panel.add(lblNewLabel);
		
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 76, 190, 380);
		panel_1.setBackground(Color.BLACK);
		contentPane.add(panel_1);
		JPanel panelVisualizarRecomendacion = new JPanel();
		panelVisualizarRecomendacion.setVisible(false);
		
		JButton btnNewButton = new JButton("Agregar Recomendaci\u00F3n");
		btnNewButton.setBounds(0, 11, 190, 34);
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
				
				
			}
		});
		btnNewButton.setSelectedIcon(new ImageIcon("Imagenes\\fondoBoton.png"));
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(Color.DARK_GRAY);
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				p2.setVisible(true);
				p3.setVisible(false);
				p4.setVisible(false);
				
			}
		});
		panel_1.setLayout(null);
		panel_1.add(btnNewButton);
		
		JButton btnVisualizarRecomendacin = new JButton("Visualizar Recomendaci\u00F3n");
		btnVisualizarRecomendacin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				panelGeneral.add(p3);
				//panelGeneral.add(p4);
				p2.setVisible(false);
				p3.setVisible(true);
				p4.setVisible(false);
				
			}
			
			
		});
		btnVisualizarRecomendacin.setBounds(0, 45, 190, 34);
		btnVisualizarRecomendacin.setForeground(Color.WHITE);
		btnVisualizarRecomendacin.setBackground(Color.DARK_GRAY);
		panel_1.add(btnVisualizarRecomendacin);
		
		JButton btnElegirTaller = new JButton("Elegir Taller");
		btnElegirTaller.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panelGeneral.add(p4);
				p2.setVisible(false);
				p3.setVisible(false);
				p4.setVisible(true);
				
			}
		});
		btnElegirTaller.setBounds(0, 77, 190, 34);
		btnElegirTaller.setForeground(Color.WHITE);
		btnElegirTaller.setBackground(Color.DARK_GRAY);
		panel_1.add(btnElegirTaller);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("Imagenes\\logoUPC4.png"));
		lblNewLabel_2.setBounds(53, 215, 70, 94);
		panel_1.add(lblNewLabel_2);
		
		JLabel lblNewLabel_4 = new JLabel("New label");
		lblNewLabel_4.setBounds(0, 16, 29, 24);
		panel_1.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("New label");
		lblNewLabel_5.setBounds(0, 21, 46, 14);
		panel_1.add(lblNewLabel_5);
		
		JLabel lblNewLabel_3 = new JLabel("    X");
		lblNewLabel_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(1);
				
			}
		});
		lblNewLabel_3.setBounds(815, 1, 46, 14);
		contentPane.add(lblNewLabel_3);
		
		
		panelGeneral.setBounds(200, 26, 640, 400);
		contentPane.add(panelGeneral);
		panelGeneral.setLayout(new BorderLayout(0, 0));
		
		//panelPrueba.add(p2);//AGREGAR PANEL
		
		
		panelGeneral.add(p2);
		p2.setVisible(true);
		
		
		
		
		panelVisualizarRecomendacion.setBounds(239, 11, 175, 45);
		//panelAgregarRecomendacion.add(panelVisualizarRecomendacion);
		panelVisualizarRecomendacion.setVisible(false);
		panelVisualizarRecomendacion.setVisible(false);
		panelVisualizarRecomendacion.setVisible(false);
		
		//JPanel panelVisualizarRecomendacion = new JPanel();
		panelVisualizarRecomendacion.setBackground(new Color(51, 102, 102));
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
