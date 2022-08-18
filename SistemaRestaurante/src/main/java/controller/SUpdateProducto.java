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
import model.BProducto;

@WebServlet("/SUpdateProducto")
public class SUpdateProducto extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}
	
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String codigo = request.getParameter("codigo");
		BProducto bprod = new BProducto();
		Statement sen;
		ResultSet rs;
		Libreria lib = new Libreria();
		lib.conectarbd();
		
		try {
			sen = lib.conn.createStatement();
			rs = sen.executeQuery("select * from producto where idproducto='" + codigo + "'");
			while(rs.next()) {
				bprod.setIdproducto(rs.getInt(1));
				bprod.setSerie(rs.getString(2));
				bprod.setNombre(rs.getString(3));
				bprod.setPrecio(rs.getDouble(4));
				bprod.setStock(rs.getInt(5));
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "error al procesar la consulta");
		}
		request.setAttribute("DatosProducto", bprod);
		RequestDispatcher rd = request.getRequestDispatcher("dataProducto.jsp");
		rd.forward(request, response);
	}

}
