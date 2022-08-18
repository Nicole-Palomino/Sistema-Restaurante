<%@page import="datos.Libreria"%>
<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>DATOS DEL EMPLEADO</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.3/font/bootstrap-icons.css">
<link rel="icon" href="img/1.ico">
</head>
<jsp:useBean id="DatosEmpleado" class="model.BEmpleado" scope="request"></jsp:useBean>
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
		    <a class="nav-link text-dark fw-bold active" aria-current="page" href="SListaEmpleado">
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
	<div class="container mt-3">
		<div class="border border-4 w-50 mx-auto rounded-4 border-dark p-2 mb-2 border-opacity-50">
			<h3 class="text-center fw-bold fs-3">Actualizar datos del empleado</h3>
			<form action="SActualizarEmpleado" method="post" class="w-75 mx-auto needs-validation">
				<div class="input-group flex-nowrap mt-4">
					<span class="input-group-text" id="addon-wrapping">
						<i class="bi bi-card-heading"></i>
					</span>
					<select name="selRol" class="form-select" readonly>
					    	<%
					    		String codigo =  request.getParameter("codigo");
					    		Statement sen;
					    		ResultSet rs;
					    		Libreria lib = new Libreria();
					    		lib.conectarbd();
					    		try {
					    			sen = lib.conn.createStatement();
					    			rs = sen.executeQuery("select * from roles r inner join empleado e on r.codigorol = e.codigorol where idempleado ='" + codigo + "'");
					    			while(rs.next()){ 
					    			%>
					    				<option value="<%=rs.getString(1)%>" readonly><%=rs.getString(2)%></option>
					    			<% 	
					    			} 
					    		} catch (Exception e){
				    				out.print(e.toString());	
				    			}
					    	 %>
					    </select>
				</div>
				<div class="input-group flex-nowrap mt-4">
					<span class="input-group-text" id="addon-wrapping">
						<i class="bi bi-card-heading"></i>
					</span>
					<input type="text" class="form-control" name="txtDni" value="<%=DatosEmpleado.getDni()%>" readonly>
				</div>
				<div class="input-group flex-nowrap mt-4">
					<span class="input-group-text" id="addon-wrapping">
						<i class="bi bi-person-circle"></i>
					</span>
					<input type="text" class="form-control" name="txtNombres" value="<%=DatosEmpleado.getNombres() %>" readonly>
				</div>
				<div class="input-group flex-nowrap mt-4">
					<span class="input-group-text" id="addon-wrapping">
						<i class="bi bi-telephone-fill"></i>
					</span>
					<input type="text" class="form-control" name="txtCel" value="<%=DatosEmpleado.getTelefono() %>" readonly>
				</div>
				<div class="input-group flex-nowrap mt-4">
					<span class="input-group-text" id="addon-wrapping">
						<i class="bi bi-calendar-week-fill"></i>
					</span>
					<input type="date" class="form-control" name="txtFechaNac" value="<%=DatosEmpleado.getFechanac() %>" readonly>
				</div>
				<div class="input-group flex-nowrap mt-4">
					<span class="input-group-text" id="addon-wrapping">
						<i class="bi bi-lock-fill"></i>
					</span>
					<input type="password" class="form-control" name="txtPass" value="<%=DatosEmpleado.getPassword() %>" readonly>
				</div>
				<div class="input-group flex-nowrap mt-4">
					<span class="input-group-text" id="addon-wrapping">
						<i class="bi bi-person-workspace"></i>
					</span>
					<input type="number" class="form-control" name="txtActivo" value="<%=DatosEmpleado.getActivo() %>" max=1 min=0 required>
				</div>
				<div class="form-group mt-2 mb-3">
				    <button type="submit" class="btn btn-success mt-2 w-100">ACTUALIZAR</button>
				    <a class="btn btn-danger mt-2 w-100" href="SListaEmpleado">CANCELAR</a>
				</div>
				
				<input type="hidden" name="codigo" value="<%= DatosEmpleado.getIdempleado() %>">
			</form>
		</div>
	</div>
	<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.5/dist/umd/popper.min.js" integrity="sha384-Xe+8cL9oJa6tN/veChSP7q+mnSPaj5Bcu9mPX5F5xIGE0DVittaqT5lorf0EI7Vk" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.min.js" integrity="sha384-ODmDIVzN+pFdexxHEHFBQH3/9/vQ9uori45z4JjnFsRydbmQbmL5t1tQ0culUzyK" crossorigin="anonymous"></script>
		
</body>
</html>