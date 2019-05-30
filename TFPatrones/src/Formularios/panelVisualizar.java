package Formularios;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Codigo.ConexionUPConsulta;

import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class panelVisualizar extends JPanel {
	private JTable table;
	private JTable table_1;

	/**
	 * Create the panel.
	 */
	public panelVisualizar() {
		setLayout(null);
		
		table = new JTable();
		table.setBounds(289, 5, 0, 0);
		add(table);
		
		DefaultTableModel model=new DefaultTableModel();
		model.addColumn("CodigoAlumno");
		model.addColumn("NombreProfesor");
		model.addColumn("NombreCursoCurso");
		model.addColumn("Descripcion");
		model.addColumn("Puntaje");
		
		
		
		String[] dato=new String[5];
		
		
		ConexionUPConsulta conexionupc2=new ConexionUPConsulta();
		Connection pruebaCn2 =conexionupc2.getConexion();
		
		Statement s2;
		ResultSet rs2;
		
		String sql2="select codigoAlumnoReco,nombrePorfesor,nombreCurso,descripcionReco,puntuacion from Recomendacion inner join Alumno on Recomendacion.codigoAlumnoReco=Alumno.codigoAlumno " + 
				"inner join Profesor on Recomendacion.codigoProfesorReco=Profesor.codigoProfesor " + 
				"inner join Curso on Recomendacion.codigoCursoReco=Curso.codigoCurso where Alumno.codigoAlumno='"+LoginUPConsulta.codigoPrincipal+"'";
		
		//JOptionPane.showMessageDialog(null, comboBox.getSelectedItem());
		
		try {
			s2=(Statement)pruebaCn2.createStatement();
			rs2=((java.sql.Statement)s2).executeQuery(sql2);
			
			while(rs2.next()) {
				dato[0]=rs2.getString(1);
				dato[1]=rs2.getString(2);
				dato[2]=rs2.getString(3);
				dato[3]=rs2.getString(4);
				dato[4]=rs2.getString(5);
				model.addRow(dato);
			}
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		
		table_1 = new JTable();
		table_1.setBounds(54, 75, 520, 249);
		add(table_1);
		
		table_1.setModel(model);
		
		JLabel lblMisRecomendaciones = new JLabel("Mis Recomendaciones");
		lblMisRecomendaciones.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblMisRecomendaciones.setBounds(245, 16, 146, 14);
		add(lblMisRecomendaciones);
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.setFont(new Font("Rockwell", Font.BOLD, 13));
		btnEditar.setBounds(170, 348, 101, 23);
		add(btnEditar);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.setFont(new Font("Rockwell", Font.BOLD, 13));
		btnEliminar.setBounds(371, 348, 108, 23);
		add(btnEliminar);
		
		JLabel lblResultados = new JLabel("Resultados:");
		lblResultados.setFont(new Font("Rockwell", Font.PLAIN, 13));
		lblResultados.setBounds(59, 50, 75, 14);
		add(lblResultados);
		
		JButton btnF = new JButton("F5");
		btnF.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ConexionUPConsulta conexionupc2=new ConexionUPConsulta();
				Connection pruebaCn2 =conexionupc2.getConexion();
				
				Statement s2;
				ResultSet rs2;
				
				String sql2="select codigoAlumnoReco,nombrePorfesor,nombreCurso,descripcionReco,puntuacion from Recomendacion inner join Alumno on Recomendacion.codigoAlumnoReco=Alumno.codigoAlumno " + 
						"inner join Profesor on Recomendacion.codigoProfesorReco=Profesor.codigoProfesor " + 
						"inner join Curso on Recomendacion.codigoCursoReco=Curso.codigoCurso where Alumno.codigoAlumno='"+LoginUPConsulta.codigoPrincipal+"'";
				
				//JOptionPane.showMessageDialog(null, comboBox.getSelectedItem());
				
				try {
					s2=(Statement)pruebaCn2.createStatement();
					rs2=((java.sql.Statement)s2).executeQuery(sql2);
					
					while(rs2.next()) {
						dato[0]=rs2.getString(1);
						dato[1]=rs2.getString(2);
						dato[2]=rs2.getString(3);
						dato[3]=rs2.getString(4);
						dato[4]=rs2.getString(5);
						model.addRow(dato);
					}
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnF.setBounds(543, 13, 60, 23);
		add(btnF);

	}
}
