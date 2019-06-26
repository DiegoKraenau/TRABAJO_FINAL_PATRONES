package Formularios;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Codigo.ConexionUPConsulta;
import Fabrica.DAOFactory;
import Fabrica.Dao.AulaDAO;
import Fabrica.Dao.CursoDAO;
import Fabrica.Dao.ProfesorDAO;
import Fabrica.Dao.SedeDAO;
import Fabrica.Dao.TallerDAO;
import Persistencia.AulaBean;
import Persistencia.CursoBean;
import Persistencia.ProfesorBean;
import Persistencia.SedeBean;
import Persistencia.TallerBean;

import javax.swing.JButton;
import java.awt.Font;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class panelElegirTaller extends JPanel {
	private JTable table;

	/**
	 * Create the panel.
	 */
	public panelElegirTaller() {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Taller");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel.setBounds(294, 11, 99, 14);
		add(lblNewLabel);
		
		table = new JTable();
		table.setBounds(28, 122, 569, 219);
		add(table);
		
		JButton btnInscribirse = new JButton("Inscribirse");
		btnInscribirse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ConexionUPConsulta conexionupc=new ConexionUPConsulta();
				Connection pruebaCn=conexionupc.getConexion();
				
				Statement s;
				int rs=0;
				
				String sql="update Aula set aforoAula=aforoAula-1 where codigoAula='"+table.getValueAt(table.getSelectedRow(), table.getSelectedColumn())+"'" ;
				
				try {
					s=(Statement)pruebaCn.createStatement();
					rs=s.executeUpdate(sql);
					
					
					if(rs==1) {
						JOptionPane.showMessageDialog(null, "Se inscribio al taller");
					}else {
						JOptionPane.showMessageDialog(null, "No se inscribio al taller");
					}
					
					
					
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				
				
			}
		});
		btnInscribirse.setFont(new Font("Rockwell", Font.BOLD, 12));
		btnInscribirse.setBounds(159, 352, 104, 23);
		add(btnInscribirse);
		
		JLabel lblNewLabel_1 = new JLabel("Curso :");
		lblNewLabel_1.setFont(new Font("Rockwell", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(28, 52, 61, 14);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Profesor:");
		lblNewLabel_2.setFont(new Font("Rockwell", Font.PLAIN, 13));
		lblNewLabel_2.setBounds(226, 52, 68, 14);
		add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Sede:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_3.setBounds(449, 52, 46, 14);
		add(lblNewLabel_3);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(99, 49, 81, 20);
		add(comboBox);
		
		//---------------------CONECTAR CURSO-----------------------------
		DAOFactory factory=DAOFactory.getDAOFactory(2);
		CursoDAO dao1=factory.getCursoDAO();
		
		ArrayList<CursoBean> listaCurso=new ArrayList<CursoBean>();
		listaCurso=dao1.findbyAlumno(LoginUPConsulta.codigoPrincipal);
		
		for(CursoBean cur : listaCurso) {
			comboBox.addItem(cur.getNombreCurso());
		}
		
		
		//---------------------------------------------------------
		
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setEnabled(false);
		comboBox_1.setBounds(304, 50, 89, 20);
		add(comboBox_1);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setEnabled(false);
		comboBox_2.setBounds(522, 49, 81, 20);
		add(comboBox_2);
		
		//------------------------CONECTAR PROFESOR----------------
		
		JButton btnBuscar = new JButton("OK");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				comboBox_1.setEnabled(true);
				
				DAOFactory factory=DAOFactory.getDAOFactory(2);
				ProfesorDAO dao1=factory.getProfesorDAO();
				
				ArrayList<ProfesorBean> listaProfesor=new ArrayList<ProfesorBean>();
				listaProfesor=dao1.findbyCurso(comboBox.getSelectedItem());
				
				for(ProfesorBean pro : listaProfesor) {
					comboBox_1.addItem(pro.getNombreProfesor());
				}
				
				//--------------------------------
			}
		});
		btnBuscar.setFont(new Font("Rockwell", Font.BOLD, 12));
		btnBuscar.setBounds(99, 80, 81, 23);
		add(btnBuscar);
		
		JLabel lblResultados = new JLabel("Resultados:");
		lblResultados.setBounds(28, 103, 68, 14);
		add(lblResultados);
		
		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				comboBox_2.setEnabled(true);
				//------------------------CONECTAR PROFESOR----------------
				
				DAOFactory factory=DAOFactory.getDAOFactory(2);
				SedeDAO dao1=factory.getSedeDAO();
				
				ArrayList<SedeBean> listaSede=new ArrayList<SedeBean>();
				listaSede=dao1.findbyProf(comboBox_1.getSelectedItem());
				
				for(SedeBean sed : listaSede) {
					comboBox_2.addItem(sed.getCodigoSede());
				}
				
				//--------------------------------
			}
		});
		btnOk.setFont(new Font("Rockwell", Font.BOLD, 12));
		btnOk.setBounds(304, 81, 89, 23);
		add(btnOk);
		
		
		DefaultTableModel model=new DefaultTableModel();
		model.addColumn("Aula");
		model.addColumn("Sede");
		model.addColumn("Dia");
		model.addColumn("Inicio");
		model.addColumn("Fin");
		model.addColumn("Vacantes");
		
		
		table.setModel(model);
		
		
		JButton btnBuscar_1 = new JButton("Buscar");
		btnBuscar_1.setFont(new Font("Rockwell", Font.BOLD, 13));
		btnBuscar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				ConexionUPConsulta conexionUPC=new ConexionUPConsulta();
				Connection pruebaCn=conexionUPC.getConexion();
				
				//DAOFactory factory=DAOFactory.getDAOFactory(2);
				//AulaDAO dao1=factory.getAulaDAO();
				
				//ArrayList<AulaBean> listaAula=new ArrayList<AulaBean>();
				//listaAula=dao1.findbySede(comboBox.getSelectedItem(), comboBox_1.getSelectedItem());
				
				//String[] dato=new String[6];
				//for(int i=0; i<listaAula.size(); i++) {
					 //dato[0] = listaAula.get(i).getCodigoAula();
					 //dato[1] = listaAula.get(i).getCodigoSede();
					 //dato[2] = listaAula.get(i).getNombreDia();
					 //dato[3] = String.valueOf(listaAula.get(i).getHora());
					 //dato[4] = String.valueOf(listaAula.get(i).getFin());
					 //dato[5] = String.valueOf(listaAula.get(i).getAforoAula());
					 //model.addRow(dato);   
		        //}
				
                Statement s;
				
				ResultSet rs;
				
				String sql=null;
				
				String[] dato=new String[6];
				
				try {
					sql="select codigoAula2,codigoSede3,nombreDia,hora,fin,Aula.aforoAula from AulaSede "
						+ "inner join Aula on AulaSede.codigoAula2=Aula.codigoAula "
						+ " where nombreCur='"+comboBox.getSelectedItem()+"' and nombrePro='"+comboBox_1.getSelectedItem()+"' and"
						+ " estado=0";
				
					
					s=(Statement)pruebaCn.createStatement();
					rs=((java.sql.Statement)s).executeQuery(sql);
					
					while(rs.next()) {
						dato[0]=rs.getString(1);
						dato[1]=rs.getString(2);
						dato[2]=rs.getString(3);
						dato[3]=rs.getString(4);
						dato[4]=rs.getString(5);
						dato[5]=rs.getString(6);
						model.addRow(dato);
						
					}
					
					
				} catch (Exception e) {
					// TODO: handle exception
				}
				
			}
		});
		btnBuscar_1.setBounds(374, 352, 89, 23);
		add(btnBuscar_1);

	}
}
