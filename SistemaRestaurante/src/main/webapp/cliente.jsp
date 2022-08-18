<%@page import="datos.Libreria"%>
<%@page import="java.sql.*"%>
<%@page import="model.BCliente"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>RESTAURANTE MONTERRICO - LISTA DE CLIENTES</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.3/font/bootstrap-icons.css">
<link rel="icon" href="img/1.ico">
</head>
<jsp:useBean id="ListaCliente" class="java.util.ArrayList" scope="request"></jsp:useBean>
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
		    <a class="nav-link text-dark fw-bold active" aria-current="page" href="SListaCliente">
		    	<i class="bi bi-person-fill"></i> CLIENTES</a>
		  </li>
		  <li class="nav-item">
		    <a class="nav-link text-dark" href="SListaPedido">
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
	<div class="row mt-5 container-fluid">
		<div class="col-4">
			<h3 class="text-center fw-bold fs-3">Registrar un cliente</h3>
			<form action="SInsertCliente" method="post" class="w-75 mx-auto needs-validation">
				<div class="input-group flex-nowrap mt-4">
					<span class="input-group-text" id="addon-wrapping">
						<i class="bi bi-card-heading"></i>
					</span>
					<input type="text" class="form-control" placeholder="DNI" name="txtDni" value="" required>
				</div>
				<div class="input-group flex-nowrap mt-4">
					<span class="input-group-text" id="addon-wrapping">
						<i class="bi bi-person-circle"></i>
					</span>
					<input type="text" class="form-control" placeholder="Nombres" name="txtNombres" value="" required>
				</div>
				<div class="input-group flex-nowrap mt-4">
					<span class="input-group-text" id="addon-wrapping">
						<i class="bi bi-envelope-fill"></i>
					</span>
					<input type="email" class="form-control" placeholder="Correo Electrónico" name="txtCorreo" value="" required>
				</div>
				<div class="input-group flex-nowrap mt-4">
					<span class="input-group-text" id="addon-wrapping">
						<i class="bi bi-check-circle-fill"></i>
					</span>
					<input type="number" class="form-control" placeholder="Activo" name="txtActivo" value="" required max=1 min=0>
				</div>
				<div class="form-group mt-2 mb-3">
				    <button type="submit" class="btn btn-success mt-2 w-100">REGISTRAR</button>
				</div>
			</form>
		</div>
		<div class="col-8">
			<table class="table table-hover">
				  <thead class="table-dark">
				    <tr class="text-center">
						<th>DNI</th><th>NOMBRES</th><th>CORREO</th><th>ACTIVO</th><th>ACCIONES</th>
					</tr>
				  </thead>
				  <tbody>
				   		<%
							BCliente bcli = new BCliente();
							for(int i=0; i<ListaCliente.size(); i++){
								bcli = (BCliente)ListaCliente.get(i);
						%>
					<tr>
						<td><%=bcli.getDni() %></td>
						<td><%=bcli.getNombres() %></td>
						<td><%=bcli.getCorreo()%></td>
						<td><%=bcli.getActivo() %></td>
						<td class="text-center">
							<a href='SUpdateCliente?codigo=<%=bcli.getCodcliente() %>' class="btn btn-warning text-decoration-none">
							<i class="bi bi-exclamation-circle-fill"></i></a>
							<a href="SDeleteCliente?codigo=<%=bcli.getCodcliente() %>" class="btn btn-danger text-white text-decoration-none">
							<i class="bi bi-trash3-fill"></i></a>
						</td>
					</tr>
					<%} %>
				  </tbody>
			</table>
		</div>
	</div>
	<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.5/dist/umd/popper.min.js" integrity="sha384-Xe+8cL9oJa6tN/veChSP7q+mnSPaj5Bcu9mPX5F5xIGE0DVittaqT5lorf0EI7Vk" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.min.js" integrity="sha384-ODmDIVzN+pFdexxHEHFBQH3/9/vQ9uori45z4JjnFsRydbmQbmL5t1tQ0culUzyK" crossorigin="anonymous"></script>
	
</body>
</html>