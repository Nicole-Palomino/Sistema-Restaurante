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
import model.BCliente;

@WebServlet("/SUpdateCliente")
public class SUpdateCliente extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}
	
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String codigo = request.getParameter("codigo");
		BCliente bcli = new BCliente();
		Statement sen;
		ResultSet rs;
		Libreria lib = new Libreria();
		lib.conectarbd();
		
		try {
			sen = lib.conn.createStatement();
			rs = sen.executeQuery("select * from cliente where codcliente='" + codigo + "'");
			while(rs.next()) {
				bcli.setCodcliente(rs.getString(1));
				bcli.setDni(rs.getString(2));
				bcli.setNombres(rs.getString(3));
				bcli.setCorreo(rs.getString(4));
				bcli.setActivo(rs.getString(5));
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "error al procesar la consulta");
		}
		request.setAttribute("DatosCliente", bcli);
		RequestDispatcher rd = request.getRequestDispatcher("dataCliente.jsp");
		rd.forward(request, response);
	}

}
