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
import model.BProducto;

@WebServlet("/SInsertProducto")
public class SInsertProducto extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}
	
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BProducto bprod = new BProducto();
		Statement sen;
		String consulta;
		String validar = "";
		Libreria lib = new Libreria();
		lib.conectarbd();
		
		bprod.setSerie(request.getParameter("txtSerie"));
		bprod.setNombre(request.getParameter("txtNombre"));
		bprod.setPrecio(Double.parseDouble(request.getParameter("txtPrecio")));
		bprod.setStock(Integer.parseInt(request.getParameter("txtStock")));
		
		String serie = bprod.getSerie();
		String nom = bprod.getNombre();
		Double pre = bprod.getPrecio();
		int stock = bprod.getStock();
		
		try {
			sen = lib.conn.createStatement();
			consulta = "insert into producto(serie,nombre,precio,stock) values ('"
					+ serie + "' , '" + nom + "' , '" + pre + "' , '" + stock + "')";
			sen.executeUpdate(consulta);
			validar += "Producto agregado satisfactoriamente";
			
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "error en el proceso de registro");
		}
		response.sendRedirect("SListaProducto");
	}

}
