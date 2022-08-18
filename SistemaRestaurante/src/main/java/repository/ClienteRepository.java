package repository;

import java.sql.*;

import javax.swing.JOptionPane;

import datos.Libreria;
import model.BCliente;

public class ClienteRepository {
	Libreria lib = new Libreria();
	Statement sen;
	ResultSet data;
	
	public BCliente buscar(String dni) {
		BCliente bcli = new BCliente();
		String sql = "select * from cliente where activo = '1' and dni="+ dni;
		try {
			lib.conectarbd();
			sen = lib.conn.createStatement();
			data = sen.executeQuery(sql);
			while (data.next()) {
				bcli.setCodcliente(data.getString(1));
				bcli.setDni(data.getString(2));
				bcli.setNombres(data.getString(3));
				bcli.setCorreo(data.getString(4));
				bcli.setActivo(data.getString(5));
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "error al encontrar registro");
		}
		return bcli;
	}
}
