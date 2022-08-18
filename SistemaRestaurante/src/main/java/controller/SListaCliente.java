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
import model.BCliente;

@WebServlet("/SListaCliente")
public class SListaCliente extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList lista = new ArrayList();
		BCliente bcli;
		Statement sen;
		ResultSet data;
		Libreria lib = new Libreria();
		lib.conectarbd();
		
		try {
			sen = lib.conn.createStatement();
			data = sen.executeQuery("select * from cliente");
			while (data.next()) {
				bcli = new BCliente();
				bcli.setCodcliente(data.getString(1));
				bcli.setDni(data.getString(2));
				bcli.setNombres(data.getString(3));
				bcli.setCorreo(data.getString(4));
				bcli.setActivo(data.getString(5));
				lista.add(bcli);
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "error en el proceso de consulta");
		}
		request.setAttribute("ListaCliente", lista);
		RequestDispatcher rd = request.getRequestDispatcher("cliente.jsp");
		rd.forward(request, response);
	}
}
