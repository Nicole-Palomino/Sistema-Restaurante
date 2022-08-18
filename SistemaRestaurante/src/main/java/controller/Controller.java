package controller;

import java.io.IOException;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import datos.Libreria;
import model.BCliente;
import model.BEmpleado;
import model.BPedido;
import model.BProducto;
import repository.ClienteRepository;
import repository.EmpleadoRepository;
import repository.PedidoRepository;
import repository.ProductoRepository;

@WebServlet("/Controller")
public class Controller extends HttpServlet {
	
	BCliente bcli = new BCliente();
	ClienteRepository cr = new ClienteRepository();
	
	BProducto bprod = new BProducto();
	ProductoRepository pr = new ProductoRepository();
	
	BEmpleado bemp = new BEmpleado();
	EmpleadoRepository er = new EmpleadoRepository();
	
	BPedido bped = new BPedido();
	PedidoRepository ped =  new PedidoRepository();
	List<BPedido> lista = new ArrayList<>();
	int item;
	int cod;
	String descripcion;
	double precio;
	int cant;
	double subtotal;
	double totalpagar;
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}
	
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String accion = request.getParameter("accion");
		Libreria lib = new Libreria();
		lib.conectarbd();
		
		if (accion.equals("Buscar")) {
			String dni = request.getParameter("codigocliente");
			bcli.setDni(dni);
			bcli = cr.buscar(dni);
			request.setAttribute("bcli", bcli);
			request.getRequestDispatcher("pedido.jsp").forward(request, response);
		} 
		if (accion.equals("BuscarProducto")) {
			int id = Integer.parseInt(request.getParameter("codigoproducto"));
			bprod.setIdproducto(id);
			bprod = pr.buscarProducto(id);
			request.setAttribute("producto", bprod);
			request.setAttribute("lista", lista);
			request.setAttribute("bcli", bcli);
			request.setAttribute("totalpagar", totalpagar);
			request.setAttribute("emp", bemp);
			request.getRequestDispatcher("pedido.jsp").forward(request, response);
		}
		if (accion.equals("BuscarEmpleado")) {
			String dni = request.getParameter("codigoempleado");
			bemp.setDni(dni);
			bemp = er.buscar(dni);
			request.setAttribute("emp", bemp);
			request.setAttribute("bcli", bcli);
			request.getRequestDispatcher("pedido.jsp").forward(request, response);
		}
		if (accion.equals("AGREGAR")) {
			totalpagar = 0.0;
			item = item + 1;
			cod = bprod.getIdproducto();
			descripcion = request.getParameter("nombreproducto");
			precio = Double.parseDouble(request.getParameter("precio"));
			cant = Integer.parseInt(request.getParameter("cantidad"));
			subtotal = precio * cant;
			
			bped = new BPedido();
			bped.setItem(item);
			bped.setIdproducto(cod);
			bped.setDescripcion(descripcion);
			bped.setPrecio(precio);
			bped.setCantidad(cant);
			bped.setSubtotal(subtotal);
			lista.add(bped);
			
			for (int i= 0; i<lista.size(); i++) {
				totalpagar = totalpagar + lista.get(i).getSubtotal();
			}
			request.setAttribute("bcli", bcli);
			request.setAttribute("totalpagar", totalpagar);
			request.setAttribute("lista", lista);
			request.setAttribute("emp", bemp);
			request.getRequestDispatcher("pedido.jsp").forward(request, response);
		}
		if (accion.equals("GenerarPedido")) {
			for (int i = 0; i < lista.size(); i++) {
				BProducto bprod = new BProducto();
				int cantidad = lista.get(i).getCantidad();
				int producto = lista.get(i).getIdproducto();
				
				ProductoRepository prodre = new ProductoRepository();
				bprod = prodre.buscarProducto(producto);
				int act = bprod.getStock()-cantidad;
				prodre.actualizarStock(producto, act);
			}
			
			bped.setCodcliente(bcli.getCodcliente());
			bped.setIdempleado(bemp.getIdempleado());
			bped.setMonto(totalpagar);
			bped.setEstado("L");
			 
			String cli = bped.getCodcliente();
			String emp = bped.getIdempleado();
			Double monto = bped.getMonto();
			String est = bped.getEstado();
			ped.guardarPedido(cli,emp,monto,est);
			
			int idp = Integer.parseInt(ped.idPedido());
			for (int i = 0; i < lista.size(); i++) {
				bped = new BPedido();
				bped.setIdpedido(idp);
				bped.setIdproducto(lista.get(i).getIdproducto());
				bped.setCantidad(lista.get(i).getCantidad());
				bped.setPrecio(lista.get(i).getPrecio());
				bped.setEstado("L");
				
				int idped = bped.getIdpedido();
				int idprod = bped.getIdproducto();
				int cant = bped.getCantidad();
				Double pre = bped.getPrecio();
				String estado = bped.getEstado();
				ped.guardarDetallePedido(idped, idprod, cant, pre, estado);
			}
			lista.removeAll(lista);	
			totalpagar = 0.0;
			request.getRequestDispatcher("pedido.jsp").forward(request, response);
		}
		if (accion.equals("Cancelar")) {
			lista.removeAll(lista);	
			totalpagar = 0.0;
			request.getRequestDispatcher("pedido.jsp").forward(request, response);
		}
		if (accion.equals("ver")) {
			int id = Integer.parseInt(request.getParameter("codigo"));
			bprod.setIdproducto(id);
			bprod = pr.buscarProducto(id);
			request.setAttribute("ver", bprod);
			request.getRequestDispatcher("verProducto.jsp").forward(request, response);
		}
	}

}
