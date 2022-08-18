package repository;

import java.sql.*;

import javax.swing.JOptionPane;

import datos.Libreria;
import model.BEmpleado;

public class EmpleadoRepository {
	Libreria lib = new Libreria();
	Statement sen;
	ResultSet data;
	
	public BEmpleado buscar(String dni) {
		BEmpleado bemp = new BEmpleado();
		String sql = "select * from empleado where activo = '1' and dni="+ dni;
		try {
			lib.conectarbd();
			sen = lib.conn.createStatement();
			data = sen.executeQuery(sql);
			while (data.next()) {
				bemp.setIdempleado(data.getString(1));
				bemp.setDni(data.getString(3));
				bemp.setNombres(data.getString(4));
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "error al encontrar registro");
		}
		return bemp;
	}
}
