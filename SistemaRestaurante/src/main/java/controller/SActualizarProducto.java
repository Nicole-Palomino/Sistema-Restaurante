package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import datos.Libreria;

@WebServlet("/SActualizarProducto")
public class SActualizarProducto extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}	

	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String codigo = request.getParameter("codigo");
		String serie = request.getParameter("txtSerie");
		String nom = request.getParameter("txtNombre");
		Double precio = Double.parseDouble(request.getParameter("txtPrecio"));
		int stock = Integer.parseInt(request.getParameter("txtStock"));
		Statement sen;
		String consulta;
		Libreria lib = new Libreria();
		lib.conectarbd();
		
		try {
			sen = lib.conn.createStatement();
			consulta = "update producto set serie='"+ serie+ "', nombre='" + nom 
					+ "', precio='" + precio + "', stock='" + stock + "' where idproducto='" + codigo + "'";
			sen.executeUpdate(consulta);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "error al actualizar registro");
		}
		response.sendRedirect("SListaProducto");
	}
}
