package controller;

import java.io.IOException;
import java.util.*;
import java.sql.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import datos.Libreria;
import model.BDetallePedido;

@WebServlet("/SListaDetalle")
public class SListaDetalle extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}
	
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList lista = new ArrayList();
		BDetallePedido bdp;
		Statement sen;
		ResultSet data;
		Libreria lib = new Libreria();
		lib.conectarbd();
		
		try {
			sen = lib.conn.createStatement();
			data = sen.executeQuery("select d.*, p.fecha from detalle_pedido d inner join pedido p " 
					+ "on p.idpedido = d.idpedido where p.fecha = curdate() order by estado");
			while (data.next()) {
				bdp = new BDetallePedido();
				bdp.setCod_detalle(data.getString(1));
				bdp.setCantidad(data.getInt(2));
				bdp.setPrecioventa(data.getDouble(3));
				bdp.setIdproducto(data.getString(4));
				bdp.setIdpedido(data.getString(5));
				bdp.setEstado(data.getString(6));			
				lista.add(bdp);
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "error en el proceso de consulta");
		}
		request.setAttribute("DetallePedido", lista);
		RequestDispatcher rd = request.getRequestDispatcher("detalle.jsp");
		rd.forward(request, response);
		
	}

}
