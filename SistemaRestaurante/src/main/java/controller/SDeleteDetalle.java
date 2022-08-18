package controller;

import java.io.IOException;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import datos.Libreria;

@WebServlet("/SDeleteDetalle")
public class SDeleteDetalle extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}
	
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String codigo = request.getParameter("codigo");
		Statement sen;
		String consulta;
		Libreria lib = new Libreria();
		lib.conectarbd();
		
		try {
			sen = lib.conn.createStatement();
			consulta = "delete from detalle_pedido where cod_detalle='"+ codigo + "'";
			sen.executeUpdate(consulta);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "error al eliminar registro");
		}
		response.sendRedirect("SListaDetalle");
	}

}
