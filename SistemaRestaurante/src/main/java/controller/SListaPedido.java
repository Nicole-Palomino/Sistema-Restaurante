package controller;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import datos.Libreria;
import model.BPedido;
import repository.PedidoRepository;

@WebServlet("/SListaPedido")
public class SListaPedido extends HttpServlet {
	
	BPedido bped = new BPedido();
	PedidoRepository pr = new PedidoRepository();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}
	
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList lista = new ArrayList();
		Statement sen;
		ResultSet data;
		Libreria lib = new Libreria();
		lib.conectarbd();
		
		try {
			sen = lib.conn.createStatement();
			data = sen.executeQuery("select p.*, c.nombres from pedido p inner join cliente c on c.codcliente = p.codcliente "
					+ " order by p.estado desc");
			while (data.next()) {
				bped = new BPedido();
				bped.setIdpedido(data.getInt("idpedido"));
				bped.setIdempleado(data.getString("idempleado"));
				bped.setCodcliente(data.getString("nombres"));
				bped.setFecha(data.getString("fecha"));
				bped.setMonto(data.getDouble("monto"));
				bped.setEstado(data.getString("estado"));
				lista.add(bped); 
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "error en el proceso de consulta");
		}
		request.setAttribute("ListaPedido", lista);
		RequestDispatcher rd = request.getRequestDispatcher("pedidos.jsp");
		rd.forward(request, response);
		
		
	}

}
