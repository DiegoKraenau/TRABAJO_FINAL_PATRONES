package Formularios;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.CardLayout;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class panelTallerPresencial extends JPanel {
	private JTable table;

	/**
	 * Create the panel.
	 */
	public panelTallerPresencial() {
		setBackground(Color.LIGHT_GRAY);
		setLayout(null);
		
		JLabel lblHorario = new JLabel("Horario :");
		lblHorario.setFont(new Font("Rockwell", Font.PLAIN, 13));
		lblHorario.setBounds(288, 68, 67, 14);
		add(lblHorario);
		
		JLabel lblTallerPresencial = new JLabel("Taller Presencial");
		lblTallerPresencial.setFont(new Font("Rockwell", Font.BOLD, 13));
		lblTallerPresencial.setBounds(265, 11, 130, 14);
		add(lblTallerPresencial);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(379, 66, 87, 20);
		add(comboBox);
		
		table = new JTable();
		table.setBounds(21, 218, 417, 127);
		add(table);
		
		JLabel lblCurso = new JLabel("Curso :");
		lblCurso.setFont(new Font("Rockwell", Font.PLAIN, 13));
		lblCurso.setBounds(288, 121, 46, 14);
		add(lblCurso);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(379, 119, 87, 20);
		add(comboBox_1);
		
		JLabel lblVacantes = new JLabel("Vacantes :");
		lblVacantes.setFont(new Font("Rockwell", Font.PLAIN, 13));
		lblVacantes.setBounds(288, 165, 78, 14);
		add(lblVacantes);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBounds(379, 163, 87, 20);
		add(comboBox_2);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setFont(new Font("Rockwell", Font.BOLD, 13));
		btnBuscar.setBounds(481, 232, 104, 23);
		add(btnBuscar);
		
		JButton btnReservar = new JButton("Reservar");
		btnReservar.setFont(new Font("Rockwell", Font.BOLD, 13));
		btnReservar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnReservar.setBounds(481, 285, 104, 23);
		add(btnReservar);
		
		JButton btnOk = new JButton("OK");
		btnOk.setFont(new Font("Rockwell", Font.BOLD, 13));
		btnOk.setBounds(496, 65, 67, 23);
		add(btnOk);
		
		JButton button = new JButton("OK");
		button.setFont(new Font("Rockwell", Font.BOLD, 13));
		button.setBounds(496, 117, 67, 23);
		add(button);

	}
}
