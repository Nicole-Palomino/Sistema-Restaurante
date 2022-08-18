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

@WebServlet("/SActualizarDetalle")
public class SActualizarDetalle extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}
	
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String codigo = request.getParameter("codigo");
		String est = request.getParameter("txtEst");
		Statement sen;
		String consulta;
		Libreria lib = new Libreria();
		lib.conectarbd();
		
		try {
			sen = lib.conn.createStatement();
			consulta = "update detalle_pedido set estado='"+ est + "' where cod_detalle='" + codigo + "'";
			sen.executeUpdate(consulta);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "error al actualizar registro");
		}
		response.sendRedirect("SListaDetalle");
	}

}
