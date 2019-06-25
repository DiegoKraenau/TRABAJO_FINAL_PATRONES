package Codigo;

import java.sql.Connection;

public class ConexionUPConsulta {
	private static Connection cn;
	
	public Connection getConexion() {
		System.out.print("Conexion0 ");
		try	{
			System.out.print("Conexion1 ");
			Class.forName("com.microsoft.jdbc.sqlserver.SQLServerDriver");
			System.out.print("Conexion2 ");
			cn=java.sql.DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=patronesTF","sa", "QWEasd123!");
			System.out.print("Conexion3 ");
		}catch(Exception e){
			cn=null;
		}
		return cn;
		
		
	}
	


}
