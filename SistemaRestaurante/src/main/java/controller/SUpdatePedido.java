package controller;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import datos.Libreria;
import model.BPedido;

@WebServlet("/SUpdatePedido")
public class SUpdatePedido extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}
	
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String codigo = request.getParameter("codigo");
		BPedido bped = new BPedido();
		Statement sen;
		ResultSet rs;
		Libreria lib = new Libreria();
		lib.conectarbd();
		
		try {
			sen = lib.conn.createStatement();
			rs = sen.executeQuery("select * from pedido where idpedido='" + codigo + "'");
			while(rs.next()) {
				bped.setIdpedido(rs.getInt(1));
				bped.setIdempleado(rs.getString(2));
				bped.setCodcliente(rs.getString(3));
				bped.setFecha(rs.getString(4));
				bped.setMonto(rs.getDouble(5));
				bped.setEstado(rs.getString(6));
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "error al procesar la consulta");
		}
		request.setAttribute("DatosPedido", bped);
		RequestDispatcher rd = request.getRequestDispatcher("dataPedido.jsp");
		rd.forward(request, response);
	}

}
