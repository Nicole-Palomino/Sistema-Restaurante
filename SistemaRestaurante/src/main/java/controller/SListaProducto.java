package controller;

import java.io.IOException;
import java.sql.*;
import java.util.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import datos.Libreria;
import model.BProducto;

@WebServlet("/SListaProducto")
public class SListaProducto extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}
	
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList lista = new ArrayList();
		BProducto bprod;
		Statement sen;
		ResultSet data;
		Libreria lib = new Libreria();
		lib.conectarbd();
		
		try {
			sen = lib.conn.createStatement();
			data = sen.executeQuery("select * from producto order by serie");
			while(data.next()) {
				bprod = new BProducto();
				bprod.setIdproducto(data.getInt(1));
				bprod.setSerie(data.getString(2));
				bprod.setNombre(data.getString(3));
				bprod.setPrecio(data.getDouble(4));
				bprod.setStock(data.getInt(5));
				lista.add(bprod);
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "error en el proceso de consulta");
		}
		request.setAttribute("ListaProducto", lista);
		RequestDispatcher rd = request.getRequestDispatcher("producto.jsp");
		rd.forward(request, response);
	}
}
