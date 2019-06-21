package Formularios;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Codigo.ConexionUPConsulta;
import Fabrica.DAOFactory;
import Fabrica.Dao.CursoDAO;
import Fabrica.Dao.ProfesorDAO;
import Fabrica.Dao.RecomendacionDAO;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.DropMode;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import com.toedter.calendar.JCalendar;

public class verRecomendacion extends JFrame {

	private JPanel contentPane;
	int xx,xy;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					verRecomendacion frame = new verRecomendacion();
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
	public verRecomendacion() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 403, 310);
		contentPane = new JPanel();
		contentPane.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent arg0) {
				int x=arg0.getXOnScreen();
				int y=arg0.getYOnScreen();
				verRecomendacion.this.setLocation(x-xx,y-xy);
				
			}
		});
		contentPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				xx=e.getX();
				xy=e.getY();
				
			}
		});
		contentPane.setBackground(new Color(255, 255, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		JLabel lblNewLabel = new JLabel("NumRecomendacion :");
		lblNewLabel.setFont(new Font("Rockwell", Font.BOLD, 11));
		lblNewLabel.setBounds(10, 36, 123, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblProfesor = new JLabel("Profesor :");
		lblProfesor.setFont(new Font("Rockwell", Font.BOLD, 11));
		lblProfesor.setBounds(10, 71, 74, 14);
		contentPane.add(lblProfesor);
		
		JLabel lblCurso = new JLabel("Curso :");
		lblCurso.setFont(new Font("Rockwell", Font.BOLD, 11));
		lblCurso.setBounds(10, 108, 46, 14);
		contentPane.add(lblCurso);
		
		JLabel lblPuntaje = new JLabel("Puntaje :");
		lblPuntaje.setFont(new Font("Rockwell", Font.BOLD, 11));
		lblPuntaje.setBounds(10, 149, 74, 14);
		contentPane.add(lblPuntaje);
		
		JLabel lblDescripcion = new JLabel("Descripcion :");
		lblDescripcion.setFont(new Font("Rockwell", Font.BOLD, 11));
		lblDescripcion.setBounds(10, 186, 74, 14);
		contentPane.add(lblDescripcion);
		
		
		
		
		
		JLabel label = new JLabel("------------");
		label.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		label.setBounds(174, 36, 81, 14);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("------------");
		label_1.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		label_1.setBounds(174, 71, 81, 14);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("------------");
		label_2.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		label_2.setBounds(174, 108, 81, 14);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("------------");
		label_3.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		label_3.setBounds(174, 149, 81, 14);
		contentPane.add(label_3);
		
		JLabel lblNewLabel_1 = new JLabel("New label\r\n\r\n\r\n\r\n\r\n");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(174, 186, 166, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblX = new JLabel("    X");
		lblX.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				verRecomendacion.this.hide();
			}
		});
		lblX.setBounds(340, 11, 46, 14);
		contentPane.add(lblX);
		
		//CONECTAR TODO
		
		DAOFactory factory=DAOFactory.getDAOFactory(2);
		RecomendacionDAO dao1=factory.getRecomendacionDAO();
		ProfesorDAO dao2=factory.getProfesorDAO();
		CursoDAO dao3=factory.getCursoDAO();
		
		label.setText(Integer.toString(dao1.findById(panelAgregar.num).getCodigoRecomendacion()));
		
		String var=null;
		var=dao1.findById(panelAgregar.num).getCodigoProfesorReco();
		label_1.setText(dao2.findById(var).getContraseñaProfesor());
		
		
		String var1=null;
		var1=dao1.findById(panelAgregar.num).getCodigoCursoReco();
		label_2.setText(dao3.findById(var1).getNombreCurso());
		
		label_3.setText(Integer.toString(dao1.findById(panelAgregar.num).getPuntuacion()));
		
		lblNewLabel_1.setText(dao1.findById(panelAgregar.num).getDescripcionReco());
		
		
	
	}
}
