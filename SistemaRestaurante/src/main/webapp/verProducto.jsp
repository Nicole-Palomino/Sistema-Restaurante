<%@page import="datos.Libreria"%>
<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>DATOS DEL PRODUCTO</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.3/font/bootstrap-icons.css">
<link rel="icon" href="img/1.ico">
</head>
<jsp:useBean id="ver" class="model.BProducto" scope="request"></jsp:useBean>
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
	<div class="container mt-3">
		<div class="row">
			<div class="col-sm-5 m-auto">
				<div class="card">
					<div class="card-body">
						<div class="input-group flex-nowrap mt-2">
						  	<span class="input-group-text" id="addon-wrapping">
								<i class="bi bi-person-circle"></i>
							</span>
						  	<input type="text" class="form-control" value="<%=ver.getIdproducto() %>" readonly>
						</div>
						<div class="input-group flex-nowrap mt-4">
						  	<span class="input-group-text" id="addon-wrapping">
								<i class="bi bi-person-circle"></i>
							</span>
						  	<input type="text" class="form-control" value="<%=ver.getSerie() %>" readonly>
						</div>
						<div class="input-group flex-nowrap mt-4">
						  	<span class="input-group-text" id="addon-wrapping">
								<i class="bi bi-person-circle"></i>
							</span>
						  	<input type="text" class="form-control" value="<%=ver.getNombre() %>" readonly>
						</div>
						<a href='SListaDetalle' class="btn btn-warning text-decoration-none mt-4">
							REGRESAR</a>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>