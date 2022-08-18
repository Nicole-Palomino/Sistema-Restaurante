<%@page import="model.BEmpleado"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>RESTAUTANTE MONTERRICO - PRINCIPAL</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.3/font/bootstrap-icons.css">
<link rel="icon" href="img/1.ico">
</head>
<jsp:useBean id="Empleado" class="model.BEmpleado" scope="request"></jsp:useBean>
<body>
	<ul class="nav nav-tabs pt-2 ps-3">
		  <li class="nav-item">
		    <a class="nav-link fw-bold active" aria-current="page" href="principal.jsp">
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
	<div class="container mt-5">
		<div class="row mt-3">
			<h2 class="fw-bold text-center">
				¡BIENVENIDO AL SISTEMA <%=Empleado.getNombres() %>!
			</h2>
			<p class="text-center">Elige una sección</p>
		</div>
		<div class="row mt-3 container text-center mx-auto">
			<div class="col-3 border border-info p-3 border-opacity-50 ms-5 border-2 rounded-2">
				<a href="SListaProducto" class="text-decoration-none text-dark">
					<i class="bi bi-basket-fill"></i> PRODUCTOS</a>
			</div>
			<div class="col-3 border border-success p-3 border-opacity-50 ms-5 border-2 rounded-2">
				<a href="SListaEmpleado" class="text-decoration-none text-dark">
					<i class="bi bi-person-circle"></i> EMPLEADOS</a>
			</div>
			<div class="col-3 border border-warning p-3 border-opacity-50 ms-5 border-2 rounded-2">
				<a href="SListaCliente" class="text-decoration-none text-dark">
					<i class="bi bi-person-fill"></i> CLIENTES</a>
			</div>
		</div>
		<div class="row mt-3 container text-center mx-auto">
			<div class="col-3 border border-secondary p-3 border-opacity-50 ms-5 border-2 rounded-2">
				<a href="SListaPedido" class="text-decoration-none text-dark">
					<i class="bi bi-basket3-fill"></i> PEDIDOS</a>
			</div>
			<div class="col-3 border border-primary p-3 border-opacity-50 ms-5 border-2 rounded-2">
				<a href="SListaDetalle" class="text-decoration-none text-dark">
					<i class="bi bi-ticket-detailed-fill"></i> DETALLE DEL PEDIDO</a>
			</div>
			<div class="col-3 border border-danger p-3 border-opacity-50 ms-5 border-2 rounded-2">
				<a href="pedido.jsp" class="text-decoration-none text-dark">
					<i class="bi bi-bag-fill"></i> GENERAR PEDIDO</a>
			</div>
		</div>
	</div>
	<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.5/dist/umd/popper.min.js" integrity="sha384-Xe+8cL9oJa6tN/veChSP7q+mnSPaj5Bcu9mPX5F5xIGE0DVittaqT5lorf0EI7Vk" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.min.js" integrity="sha384-ODmDIVzN+pFdexxHEHFBQH3/9/vQ9uori45z4JjnFsRydbmQbmL5t1tQ0culUzyK" crossorigin="anonymous"></script>
	
</body>
</html>