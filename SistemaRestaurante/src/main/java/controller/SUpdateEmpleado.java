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
import model.BEmpleado;

@WebServlet("/SUpdateEmpleado")
public class SUpdateEmpleado extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}
	
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String codigo = request.getParameter("codigo");
		BEmpleado bemp = new BEmpleado();
		Statement sen;
		ResultSet rs;
		Libreria lib = new Libreria();
		lib.conectarbd();
		
		try {
			sen = lib.conn.createStatement();
			rs = sen.executeQuery("select * from empleado where idempleado='" + codigo + "'");
			while(rs.next()) {
				bemp.setIdempleado(rs.getString(1));
				bemp.setCodigorol(rs.getString(2));
				bemp.setDni(rs.getString(3));
				bemp.setNombres(rs.getString(4));
				bemp.setTelefono(rs.getString(5));
				bemp.setFechanac(rs.getString(6));
				bemp.setPassword(rs.getString(7));
				bemp.setActivo(rs.getString(8));
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "error al procesar la consulta");
		}
		request.setAttribute("DatosEmpleado", bemp);
		RequestDispatcher rd = request.getRequestDispatcher("dataEmpleado.jsp");
		rd.forward(request, response);
	}

}
