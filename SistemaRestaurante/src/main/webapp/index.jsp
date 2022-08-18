<%@page import="java.sql.*"%>
<%@page import="datos.Libreria"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>RESTAURANTE MONTERRICO - INICIO DE SESIÓN</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.3/font/bootstrap-icons.css">
<link rel="icon" href="img/1.ico">
</head>
<body>
	<div class="container">
		<div class="row vh-100 justify-content-around align-items-center">
			<div class="col-6 text-center">
				<img alt="logo restaurante monterrico" src="img/1.png" width="500px" height="500px">
			</div>
			<div class="col-6">
				<h3 class="text-center fw-bold fs-3">Iniciar Sesión</h3>
				<form action="SSesionEmpleado" method="post" class="w-50 mx-auto needs-validation" novalidate>
					<div class="align-items-center text-danger" role="alert">
					    	${requestScope.validar }
					</div>
					<div class="input-group flex-nowrap mt-2">
					  	<span class="input-group-text" id="addon-wrapping">
							<i class="bi bi-person-circle"></i>
						</span>
					  	<input type="text" class="form-control" placeholder="Usuario" name="txtDni" value="" required>
					</div>
					<div class="input-group flex-nowrap mt-3">
					  	<span class="input-group-text" id="addon-wrapping">
							<i class="bi bi-lock-fill"></i>
						</span>
					  	<input type="password" class="form-control" placeholder="Contraseña" name="txtPass" value="" required>
					</div>
					<div class="form-group mt-2 mb-3">
					    <button type="submit" class="btn btn-success mt-2 w-100 fw-bold">INGRESAR</button>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>