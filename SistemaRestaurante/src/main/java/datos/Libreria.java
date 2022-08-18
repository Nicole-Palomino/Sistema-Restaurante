package datos;

import java.sql.*;

import javax.swing.*;

public class Libreria {
	public String driver = "com.mysql.cj.jdbc.Driver";
	public String cadena = "jdbc:mysql://localhost/laboratorio";
	public String usuario = "root";
	public String clave = "emiliapalomino7530";
	public Connection conn;
	
	public void conectarbd() {
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(cadena, usuario, clave);
		} catch (ClassNotFoundException e1) {
			JOptionPane.showMessageDialog(null, "error en el driver");
		} catch (SQLException e2) {
			JOptionPane.showMessageDialog(null, "error en la conexion");
		}
	}
}
