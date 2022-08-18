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
import model.BEmpleado;
import datos.GetMD5;

@WebServlet("/SInsertEmpleado")
public class SInsertEmpleado extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BEmpleado bemp = new BEmpleado();
		Statement sen;
		String consulta;
		Libreria lib = new Libreria();
		lib.conectarbd();
		GetMD5 enc = new GetMD5();
		
		bemp.setCodigorol(request.getParameter("selRol"));	
		bemp.setDni(request.getParameter("txtDni"));
		bemp.setNombres(request.getParameter("txtNombres"));
		bemp.setTelefono(request.getParameter("txtCel"));
		bemp.setFechanac(request.getParameter("txtFechaNac"));
		bemp.setPassword(enc.getMD5(request.getParameter("txtPass")));
		bemp.setActivo(request.getParameter("txtActivo"));
		
		String rol = bemp.getCodigorol();
		String dni = bemp.getDni();
		String nom = bemp.getNombres();
		String cel = bemp.getTelefono();
		String nac = bemp.getFechanac();
		String pas = bemp.getPassword();
		String act = bemp.getActivo();
		
		try {
			sen = lib.conn.createStatement();
			consulta = "insert into empleado(codigorol,dni,nombres,telefono,fechanac,password,activo) values ('"
					+ rol + "' , '" + dni + "' , '" + nom + "' , '" + cel + "' , '" + nac + "' , '" + pas + "' , '" + act + "')";
			sen.executeUpdate(consulta);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "error en el proceso de registro");
		}
		response.sendRedirect("SListaEmpleado");
	}
}
