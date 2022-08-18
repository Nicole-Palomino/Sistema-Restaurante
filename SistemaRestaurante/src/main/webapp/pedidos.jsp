<%@page import="model.BPedido"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>RESTAURANTE MONTERRICO - LISTA DE PEDIDOS</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.3/font/bootstrap-icons.css">
<link rel="icon" href="img/1.ico">
</head>
<jsp:useBean id="ListaPedido" class="java.util.ArrayList" scope="request"></jsp:useBean>
<body>
	<ul class="nav nav-tabs pt-2 ps-3">
		  <li class="nav-item">
		    <a class="nav-link text-dark" href="principal.jsp">
		    	<i class="bi bi-house-door-fill"></i> INICIO</a>
		  </li>
		  <li class="nav-item">
		    <a class="nav-link text-dark" href="SListaProducto">
		    	<i class="bi bi-basket-fill"></i> PRODUCTOS</a>
		  </li>
		  <li class="nav-item">
		    <a class="nav-link text-dark" href="SListaEmpleado">
		    	<i class="bi bi-person-circle"></i> EMPLEADOS</a>
		  </li>
		  <li class="nav-item">
		    <a class="nav-link text-dark" href="SListaCliente">
		    	<i class="bi bi-person-fill"></i> CLIENTES</a>
		  </li>
		  <li class="nav-item">
		    <a class="nav-link text-dark fw-bold active" aria-current="page" href="SListaPedido">
		    	<i class="bi bi-basket3-fill"></i> PEDIDOS</a>
		  </li>
		  <li class="nav-item">
		    <a class="nav-link text-dark" href="SListaDetalle">
		    	<i class="bi bi-ticket-detailed-fill"></i> DETALLE DEL PEDIDO</a>
		  </li>
		  <li class="nav-item">
		    <a class="nav-link text-dark" href="pedido.jsp">
		    	<i class="bi bi-card-list"></i> GENERAR PEDIDO</a>
		  </li>
		  <li class="nav-item">
		    <a class="nav-link text-dark" href="index.jsp">
		    	<i class="bi bi-pc-display-horizontal"></i> CERRAR SESIÓN</a>
		  </li>
	</ul>
	<div class="row mt-4 container-fluid">
		<div class="col-sm-7 m-auto">
			<table class="table table-hover">
				  <thead class="table-dark">
				    <tr class="text-center">
						<th>EMPLEADO</th><th>CLIENTE</th><th>FECHA</th><th>MONTO</th><th>ESTADO</th><th>ACCIONES</th>
					</tr>
				  </thead>
				  <tbody>
				   		<%
							BPedido bped = new BPedido();
							for(int i=0; i<ListaPedido.size(); i++){
								bped = (BPedido)ListaPedido.get(i);
						%>
					<tr>
						<td><%=bped.getIdempleado() %></td>
						<td><%=bped.getCodcliente()%></td>
						<td><%=bped.getFecha()%></td>
						<td><%=bped.getMonto() %></td>
						<td><%=bped.getEstado() %></td>
						<td class="text-center">
							<a href='SUpdatePedido?codigo=<%=bped.getIdpedido() %>' class="btn btn-warning text-decoration-none">
							<i class="bi bi-exclamation-circle-fill"></i></a>
							<a href="SDeletePedido?codigo=<%=bped.getIdpedido()%>" class="btn btn-danger text-white text-decoration-none">
							<i class="bi bi-trash3-fill"></i></a>
						</td>
					</tr>
					<%} %>
				  </tbody>
			</table>
		</div>
	</div>
</body>
</html>