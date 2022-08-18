package repository;

import java.sql.*;

import javax.swing.JOptionPane;

import datos.Libreria;
import model.BPedido;

public class PedidoRepository {
	BPedido bped = new BPedido();
	Libreria lib = new Libreria();
	Statement sen;
	ResultSet data;
	int x;
	
	public String idPedido() {
		String idped="";
		String sql="select max(idpedido) from pedido";
		try {
			lib.conectarbd();
			sen = lib.conn.createStatement();
			data = sen.executeQuery(sql);
			while(data.next()) {
				idped = data.getString(1);
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "error al encontrar registro");
		}
		return idped;
	}
	
	public int guardarPedido(String cli, String emp, Double monto, String est) {

		String sql;
		try {
			lib.conectarbd();
			sen = lib.conn.createStatement();
			sql = "insert into pedido(idempleado,codcliente,fecha,monto,estado) values('" 
					+ emp + "' , '" + cli + "' , curdate(), '" + monto + "' , '" + est + "')";
			sen.executeUpdate(sql);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "error al guardar pedido");
		}
		return x;
	}
	
	public int guardarDetallePedido(int pedido, int prod, int cant, Double precio, String est) {
		String sql;
		try {
			lib.conectarbd();
			sen = lib.conn.createStatement();
			sql = "insert into detalle_pedido(cantidad,precioventa,idproducto,idpedido,estado) values('"
					+ cant + "' , '" + precio + "' , '" + prod + "' , '" + pedido + "' , '" + est + "')";
			sen.executeUpdate(sql);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "error al guardar detalle de pedido");
		}
		return x;
	}
}
