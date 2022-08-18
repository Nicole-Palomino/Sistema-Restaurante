<%@page import="model.BPedido"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>RESTAURANTE MONTERRICO - REGISTRAR PEDIDO</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.3/font/bootstrap-icons.css">
<link rel="icon" href="img/1.ico">
<style type="text/css">
	@media print {
		.nav, .parte01, .btn{
			display: none;
		}
	}
</style>
</head>
<jsp:useBean id="lista" class="java.util.ArrayList" scope="request"></jsp:useBean>
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
		    <a class="nav-link text-dark" href="SListaPedido">
		    	<i class="bi bi-basket3-fill"></i> PEDIDOS</a>
		  </li>
		  <li class="nav-item">
		    <a class="nav-link text-dark" href="SListaDetalle">
		    	<i class="bi bi-ticket-detailed-fill"></i> DETALLE DEL PEDIDO</a>
		  </li>
		  <li class="nav-item">
		    <a class="nav-link text-dark fw-bold active" aria-current="page" href="pedido.jsp">
		    	<i class="bi bi-card-list"></i> GENERAR PEDIDO</a>
		  </li>
		  <li class="nav-item">
		    <a class="nav-link text-dark" href="index.jsp">
		    	<i class="bi bi-pc-display-horizontal"></i> CERRAR SESIÓN</a>
		  </li>
	</ul>
	<div class="container mt-2 p-3">
		<div class="row parte01">
			<div class="card">
				<form action="Controller" method="post">
					<div class="card-body">
						<!-- datos del cliente -->
						<div class="form-group">
								<label><i class="bi bi-person-fill"></i> Datos del cliente</label>
						</div>
						<div class="form-group d-flex">
							<div class="col-sm-3 d-flex">
								<div class="input-group flex-nowrap">
									<span class="input-group-text" id="addon-wrapping">
										<i class="bi bi-braces-asterisk"></i>
									</span>
									<input type="text" name="codigocliente" value="${bcli.getDni()}" class="form-control" placeholder="Codigo">
								</div>
								<input type="submit" name="accion" value="Buscar" class="btn btn-outline-info ms-2">
							</div>
							<div class="col-sm-3 ms-3">
								<div class="input-group flex-nowrap">
									<span class="input-group-text" id="addon-wrapping">
										<i class="bi bi-person-fill"></i>
									</span>
									<input type="text" name="nombrecliente" value="${bcli.getNombres()}" class="form-control" placeholder="Datos del cliente" readonly>
								</div>
							</div>
						</div>
						<!-- datos del empleado -->
						<div class="form-group">
								<label><i class="bi bi-person-circle"></i> Datos del empleado</label>
						</div>
						<div class="form-group d-flex">
							<div class="col-sm-4 d-flex">
								<div class="input-group flex-nowrap">
									<span class="input-group-text" id="addon-wrapping">
										<i class="bi bi-braces-asterisk"></i>		
									</span>
									<input type="text" name="codigoempleado" value="${emp.getDni() }" class="form-control" placeholder="Codigo">
								</div>	
								<input type="submit" name="accion" value="BuscarEmpleado" class="btn btn-outline-info ms-2">
							</div>
							<div class="col-sm-3 ms-3">
								<div class="input-group flex-nowrap">
									<span class="input-group-text" id="addon-wrapping">
										<i class="bi bi-person-circle"></i>
									</span>
									<input type="text" name="nombreempleado" value="${emp.getNombres() }" class="form-control" placeholder="Datos del empleado" readonly>
								</div>
							</div>
						</div>
						<!-- datos del producto -->
						<div class="form-group">
							<label>Datos del producto</label>
						</div>
						<div class="form-group d-flex">
							<div class="col-sm-4 d-flex">
								<div class="input-group flex-nowrap">
									<span class="input-group-text" id="addon-wrapping">
										<i class="bi bi-basket-fill"></i>
									</span>
									<input type="text" name="codigoproducto" value="${producto.getIdproducto() }" class="form-control" placeholder="Codigo">
								</div>
								<input type="submit" name="accion" value="BuscarProducto" class="btn btn-outline-info ms-2" placeholder="Datos del producto">
							</div>
							<div class="col-sm-4 ms-3">
								<div class="input-group flex-nowrap">
									<span class="input-group-text" id="addon-wrapping">
										<i class="bi bi-basket-fill"></i>
									</span>
									<input type="text" name="nombreproducto" value="${producto.getNombre() }" class="form-control" placeholder="Datos del producto" readonly>
								</div>
							</div>
							<div class="col-sm-1">
								<input type="number" value="1" name="cantidad" class="form-control ms-2" min="1">
							</div>
						</div>
						<div class="form-group d-flex mt-1">
							<div class="col-sm-2 d-flex">
								<div class="input-group flex-nowrap">
									<span class="input-group-text" id="addon-wrapping">
										<i class="bi bi-tags-fill"></i>
									</span>
									<input type="text" name="precio" value="${producto.getPrecio() }" class="form-control" placeholder="S/ 0.00" readonly>
								</div>
							</div>
							<div class="col-sm-2 ms-2">
								<div class="input-group flex-nowrap">
									<span class="input-group-text" id="addon-wrapping">
										<i class="bi bi-receipt-cutoff"></i>
									</span>
									<input type="text" name="stock" value="${producto.getStock() }" class="form-control" placeholder="Stock" readonly>
								</div>
							</div>
							<div class="col-sm-3">
								<input type="submit" name="accion" value="AGREGAR" class="btn btn-success ms-3">
							</div>
						</div>
					</div>
				</form>
			</div>
		</div>
		<div class="row mt-2">
			<div class="card">
				<div class="card-body">
					<table class="table table-hover">
						<thead>
							<tr>
								<th>Nro</th><th>Codigo</th><th>Descripion</th><th>Precio</th><th>Cantidad</th><th>Subtotal</th>
							</tr>
						</thead>
						<tbody>
							<%
								BPedido bped = new BPedido();
								for(int i=0; i<lista.size(); i++){
									bped = (BPedido)lista.get(i);
							%>
							<tr>
								<td><%=bped.getItem() %></td>
								<td><%=bped.getIdproducto() %></td>
								<td><%=bped.getDescripcion() %></td>
								<td><%=bped.getPrecio() %></td>
								<td><%=bped.getCantidad() %></td>
								<td><%=bped.getSubtotal() %></td>
							</tr>
							<%} %>
						</tbody>
					</table>
				</div>
				<div class="card-footer d-flex">
					<div class="col-sm-8">
						<a href="Controller?accion=GenerarPedido" onclick="print()" class="btn btn-success">
							<i class="bi bi-bag-fill"></i> Generar Pedido</a>
						<a href="Controller?accion=Cancelar" class="btn btn-danger">
							<i class="bi bi-trash-fill"></i> Cancelar</a>
					</div>
					<div class="col-sm-2 ml-auto">
						<input type="text" value="S/ ${totalpagar}" name="txtTotal" class="form-control" readonly>
					</div>
				</div>
			</div>
		</div>	
	</div>
</body>
</html>