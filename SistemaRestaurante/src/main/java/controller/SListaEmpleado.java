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
import model.BEmpleado;

@WebServlet("/SListaEmpleado")
public class SListaEmpleado extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}
	
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList lista = new ArrayList();
		BEmpleado bemp;
		Statement sen;
		ResultSet data;
		Libreria lib = new Libreria();
		lib.conectarbd();
		
		try {
			sen = lib.conn.createStatement();
			data = sen.executeQuery("select * from empleado");
			while(data.next()) {
				bemp = new BEmpleado();
				bemp.setIdempleado(data.getString(1));
				bemp.setDni(data.getString(3));
				bemp.setNombres(data.getString(4));
				bemp.setTelefono(data.getString(5));
				bemp.setFechanac(data.getString(6));
				bemp.setActivo(data.getString(8));
				lista.add(bemp);
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "error en el proceso de consulta");
		}
		request.setAttribute("ListaEmpleado", lista);
		RequestDispatcher rd = request.getRequestDispatcher("empleado.jsp");
		rd.forward(request, response);
	}

}
