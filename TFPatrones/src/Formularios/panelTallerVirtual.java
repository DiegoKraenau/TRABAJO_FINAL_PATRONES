package Formularios;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import com.toedter.calendar.JCalendar;
import java.awt.Label;
import java.awt.Choice;
import javax.swing.JComboBox;
import javax.swing.JButton;

public class panelTallerVirtual extends JPanel {

	/**
	 * Create the panel.
	 */
	public panelTallerVirtual() {
		setBackground(Color.LIGHT_GRAY);
		setLayout(null);
		
		JLabel lblTallerVirtual = new JLabel("Taller Virtual");
		lblTallerVirtual.setBounds(274, 11, 100, 25);
		lblTallerVirtual.setFont(new Font("Rockwell", Font.BOLD, 13));
		add(lblTallerVirtual);
		
		JCalendar calendar = new JCalendar();
		calendar.setBounds(39, 58, 184, 153);
		add(calendar);
		
		JLabel lblNewLabel = new JLabel("Curso :");
		lblNewLabel.setBounds(274, 58, 46, 14);
		lblNewLabel.setFont(new Font("Rockwell", Font.PLAIN, 13));
		add(lblNewLabel);
		
		JLabel lblInicio = new JLabel("Inicio :");
		lblInicio.setBounds(274, 120, 46, 14);
		lblInicio.setFont(new Font("Rockwell", Font.PLAIN, 13));
		add(lblInicio);
		
		JLabel lblDuracion = new JLabel("Duracion :");
		lblDuracion.setBounds(274, 186, 79, 14);
		lblDuracion.setFont(new Font("Rockwell", Font.PLAIN, 13));
		add(lblDuracion);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(371, 56, 92, 20);
		add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(371, 118, 92, 20);
		add(comboBox_1);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBounds(371, 184, 92, 20);
		add(comboBox_2);
		
		JButton btnOk = new JButton("OK");
		btnOk.setBounds(522, 54, 60, 23);
		btnOk.setFont(new Font("Rockwell", Font.BOLD, 13));
		add(btnOk);
		
		JButton button = new JButton("OK");
		button.setBounds(522, 116, 60, 23);
		button.setFont(new Font("Rockwell", Font.BOLD, 13));
		add(button);
		
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.setBounds(510, 182, 89, 23);
		btnAgregar.setFont(new Font("Rockwell", Font.BOLD, 13));
		add(btnAgregar);
		
		JLabel lblNota = new JLabel("Nota :");
		lblNota.setFont(new Font("Rockwell", Font.PLAIN, 13));
		lblNota.setBounds(39, 243, 46, 14);
		add(lblNota);
		
		JLabel lblelUsuarioSolo = new JLabel("-El usuario solo puede acumular 4 horas semanales.");
		lblelUsuarioSolo.setFont(new Font("Rockwell", Font.PLAIN, 13));
		lblelUsuarioSolo.setBounds(39, 269, 335, 14);
		add(lblelUsuarioSolo);
		
		JLabel lbllaDuracionMaxima = new JLabel("-La duracion maxima del taller virtual son de 2 horas.");
		lbllaDuracionMaxima.setFont(new Font("Rockwell", Font.PLAIN, 13));
		lbllaDuracionMaxima.setBounds(39, 294, 314, 14);
		add(lbllaDuracionMaxima);

	}
}
