package Formularios;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.CardLayout;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import java.awt.event.ActionEvent;
import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;

import Codigo.ConexionUPConsulta;
import javax.swing.DefaultComboBoxModel;

public class panelTallerPresencial extends JPanel {
	private JTable table;
	public static int dia;
	public static String diaOficial;

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
		comboBox.setEnabled(false);
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
		comboBox_1.setEnabled(false);
		comboBox_1.setBounds(379, 119, 87, 20);
		add(comboBox_1);
		
		JLabel lblVacantes = new JLabel("Vacantes :");
		lblVacantes.setFont(new Font("Rockwell", Font.PLAIN, 13));
		lblVacantes.setBounds(288, 165, 78, 14);
		add(lblVacantes);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"20", "30", "40"}));
		comboBox_2.setEnabled(false);
		comboBox_2.setBounds(379, 163, 87, 20);
		add(comboBox_2);
		
		JDateChooser cal = new JDateChooser();
		cal.setBounds(39, 42, 144, 20);
		add(cal);
		
		DefaultTableModel model=new DefaultTableModel();
		model.addColumn("Aula");
		model.addColumn("Sede");
		model.addColumn("Dia");
		model.addColumn("Inicio");
		model.addColumn("Fin");
		
		table.setModel(model);
		
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
                String nombreDIA=null;
				
				dia=cal.getDate().getDay();
				
				switch(dia) {
				case 1: nombreDIA="Lunes";break;
				case 2: nombreDIA="Martes";break;
				case 3: nombreDIA="Miercoles";break;
				case 4: nombreDIA="Jueves";break;
				case 5: nombreDIA="Viernes";break;
				case 6: nombreDIA="Sabado";break;
				
				}
				diaOficial=nombreDIA;
				
				
				ConexionUPConsulta conexionUPC=new ConexionUPConsulta();
				Connection pruebaCn=conexionUPC.getConexion();
                Statement s;
				
				ResultSet rs;
				
				String sql=null;
				
				String[] dato=new String[5];
				
				try {
					sql="select codigoAula2,codigoSede3,nombreDia,hora,fin from AulaSede"
						+ " where nombreDia='"+nombreDIA+"' and hora='"+comboBox.getSelectedItem()+"'";
				
				
					
					s=(Statement)pruebaCn.createStatement();
					rs=((java.sql.Statement)s).executeQuery(sql);
					
					while(rs.next()) {
						dato[0]=rs.getString(1);
						dato[1]=rs.getString(2);
						dato[2]=rs.getString(3);
						dato[3]=rs.getString(4);
						dato[4]=rs.getString(5);
						model.addRow(dato);
						
					}
					
					
				} catch (Exception e) {
					// TODO: handle exception
				}
	
				
				
				
			}
		});
		btnBuscar.setFont(new Font("Rockwell", Font.BOLD, 13));
		btnBuscar.setBounds(481, 232, 104, 23);
		add(btnBuscar);
		
		JButton btnReservar = new JButton("Reservar");
		btnReservar.setFont(new Font("Rockwell", Font.BOLD, 13));
		btnReservar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ConexionUPConsulta conexionupc=new ConexionUPConsulta();
				Connection pruebaCn=conexionupc.getConexion();
				
				Statement s;
				int rs=0;
				
				
				String sql="update AulaSede set nombrePro='"+LoginUPConsulta.name+"' , nombreCur='"+comboBox_1.getSelectedItem()+"' , estado=0 "
						+ "where codigoAula2='"+table.getValueAt(table.getSelectedRow(), table.getSelectedColumn())+"' and "
						+ "codigoSede3='"+table.getValueAt(table.getSelectedRow(), table.getSelectedColumn()+1)+"' and "
						+ "nombreDia='"+table.getValueAt(table.getSelectedRow(), table.getSelectedColumn()+2)+"' and "
						+ "hora='"+table.getValueAt(table.getSelectedRow(), table.getSelectedColumn()+3)+"' and "
						+ "fin='"+table.getValueAt(table.getSelectedRow(), table.getSelectedColumn()+4)+"'";
				
				
				
				//table.getValueAt(table.getSelectedRow(), table.getSelectedColumn())
				
			
				
				
				
			
				
				try {
					s=(Statement)pruebaCn.createStatement();
					rs=s.executeUpdate(sql);
					
					
					if(rs==1) {
						JOptionPane.showMessageDialog(null, "Se reservo el aula");
					}else {
						JOptionPane.showMessageDialog(null, "No se reservo el aula");
					}
					
					
					
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				
				
				
				
				
				
			}
		});
		btnReservar.setBounds(481, 285, 104, 23);
		add(btnReservar);
		
		
	
		
		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				comboBox.setEnabled(true);
				
				String nombreDIA=null;
				
				dia=cal.getDate().getDay();
				
				switch(dia) {
				case 1: nombreDIA="Lunes";break;
				case 2: nombreDIA="Martes";break;
				case 3: nombreDIA="Miercoles";break;
				case 4: nombreDIA="Jueves";break;
				case 5: nombreDIA="Viernes";break;
				case 6: nombreDIA="Sabado";break;
				
				}
				
				
				ConexionUPConsulta conexionUPC=new ConexionUPConsulta();
				Connection pruebaCn=conexionUPC.getConexion();
                Statement s;
				
				ResultSet rs;
				
				String sql=null;
				
				
				try {
					sql="select distinct hora from AulaSede "
					+ " inner join Aula on Aula.codigoAula=AulaSede.codigoAula2"
					+ " inner join Sede on Sede.codigoSede=AulaSede.codigoSede3 "
					+ "where nombreDia='"+nombreDIA+"'";
					
				
					
					s=(Statement)pruebaCn.createStatement();
					rs=((java.sql.Statement)s).executeQuery(sql);
					
					while(rs.next()) {
						comboBox.addItem(rs.getString(1));
						
					}
					
					
				} catch (Exception e) {
					// TODO: handle exception
				}
				
				
				comboBox_1.setEnabled(true);
				
				ConexionUPConsulta conexionUPC1=new ConexionUPConsulta();
				Connection pruebaCn1=conexionUPC1.getConexion();
                Statement s1;
				
				ResultSet rs1;
				
				String sql1=null;
				
				try {
					sql1="select distinct nombreCurso from ProfesorCurso "
						+ " inner join Profesor on Profesor.codigoProfesor=ProfesorCurso.codigoProfesor2 "
						+ " inner join Curso on Curso.codigoCurso=ProfesorCurso.codigoCurso3 "
						+ " where codigoProfesor='"+LoginUPConsulta.codigoPrincipal+"'";
					
				
					
					s1=(Statement)pruebaCn1.createStatement();
					rs1=((java.sql.Statement)s1).executeQuery(sql1);
					
					while(rs1.next()) {
						
						comboBox_1.addItem(rs1.getString(1));
						
					}
					
					
				} catch (Exception e) {
					// TODO: handle exception
				}
				
				comboBox_2.setEnabled(true);
				
				
			}
		});
		btnOk.setFont(new Font("Rockwell", Font.BOLD, 13));
		btnOk.setBounds(496, 65, 67, 23);
		add(btnOk);
		
		
		
		
		

	}
}
