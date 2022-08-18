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
import model.BEmpleado;
import datos.GetMD5;

@WebServlet("/SSesionEmpleado")
public class SSesionEmpleado extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String dni = request.getParameter("txtDni");
		String pas = request.getParameter("txtPass"); 
		BEmpleado bemp = new BEmpleado();
		Statement sen;
		ResultSet data;
		String validar = "";
		Libreria lib = new Libreria();
		lib.conectarbd();
		GetMD5 enc = new GetMD5();
		
		try {
			sen = lib.conn.createStatement();
			data = sen.executeQuery("select * from empleado "+
					" where dni = '" + dni + "' and password = '"+ enc.getMD5(pas) + "' and activo = '1'");
			
			if (data.next()) {
				bemp.setIdempleado(data.getString("idempleado"));
				bemp.setNombres(data.getString("nombres"));
				bemp.setDni(data.getString("dni"));
				bemp.setTelefono(data.getString("telefono"));
				bemp.setFechanac(data.getString("fechanac"));
				bemp.setPassword(data.getString("password"));
				bemp.setActivo(data.getString("activo"));
				request.setAttribute("Empleado", bemp);
				request.getRequestDispatcher("principal.jsp").forward(request, response);
			} else {
				validar += "Usuario y/o contraseña incorrectas";
				request.setAttribute("validar", validar);
				request.getRequestDispatcher("index.jsp").forward(request, response);
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "error al procesar la consulta");
		}
		
	}
}
