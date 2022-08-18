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
import model.BCliente;

@WebServlet("/SInsertCliente")
public class SInsertCliente extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BCliente bcli = new BCliente();
		Statement sen;
		String consulta;
		Libreria lib = new Libreria();
		lib.conectarbd();
		
		bcli.setDni(request.getParameter("txtDni"));
		bcli.setNombres(request.getParameter("txtNombres"));
		bcli.setCorreo(request.getParameter("txtCorreo"));
		bcli.setActivo(request.getParameter("txtActivo"));
		
		String dni = bcli.getDni();
		String nombre = bcli.getNombres();
		String correo = bcli.getCorreo();
		String act = bcli.getActivo();
		
		try {
			sen = lib.conn.createStatement();
			consulta = "insert into cliente(dni,nombres,correo,activo) values ('"
					+ dni + "' , '" + nombre+ "' , '" + correo + "' , '" + act + "')";
			sen.executeUpdate(consulta);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "error en el proceso de registro");
		}
		response.sendRedirect("SListaCliente");
	}
}
