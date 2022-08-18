package repository;

import java.sql.*;

import javax.swing.JOptionPane;

import datos.Libreria;
import model.BProducto;

public class ProductoRepository {
	Libreria lib = new Libreria();
	Statement sen;
	ResultSet data;
	int x;
	
	public BProducto buscarProducto(int id) {
		BProducto bprod = new BProducto();
		String sql = "select * from producto where idproducto="+ id;
		try {
			lib.conectarbd();
			sen = lib.conn.createStatement();
			data = sen.executeQuery(sql);
			while (data.next()) {
				bprod.setIdproducto(data.getInt(1));
				bprod.setSerie(data.getString(2));
				bprod.setNombre(data.getString(3));
				bprod.setPrecio(data.getDouble(4));
				bprod.setStock(data.getInt(5));
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "error al encontrar el producto");
		}
		return bprod;
	}
	
	public int actualizarStock(int id, int stock) {
		String sql;
		try {
			lib.conectarbd();
			sen = lib.conn.createStatement();
			sql = "update producto set stock='" + stock + "' where idproducto='" + id + "'";
			sen.executeUpdate(sql);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "error al actualizar producto");
		}
		return x;
	}
}	
