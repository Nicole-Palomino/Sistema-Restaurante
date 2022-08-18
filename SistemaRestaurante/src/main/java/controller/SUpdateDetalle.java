package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import datos.Libreria;
import model.BDetallePedido;

import java.sql.*;

@WebServlet("/SUpdateDetalle")
public class SUpdateDetalle extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}
	
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String codigo = request.getParameter("codigo");
		BDetallePedido bdp = new BDetallePedido();
		Statement sen;
		ResultSet rs;
		Libreria lib = new Libreria();
		lib.conectarbd();
		
		try {
			sen = lib.conn.createStatement();
			rs = sen.executeQuery("select * from detalle_pedido where cod_detalle='" + codigo + "'");
			while(rs.next()) {
				bdp.setCod_detalle(rs.getString(1));
				bdp.setCantidad(rs.getInt(2));
				bdp.setPrecioventa(rs.getDouble(3));
				bdp.setIdproducto(rs.getString(4));
				bdp.setIdpedido(rs.getString(5));
				bdp.setEstado(rs.getString(6));	
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "error al procesar la consulta");
		}
		request.setAttribute("DatosDetalle", bdp);
		RequestDispatcher rd = request.getRequestDispatcher("dataDetalle.jsp");
		rd.forward(request, response);
	}

}
