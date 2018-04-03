<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@page import="modelo.Anuncio"%>
<%@page import="modelo.Cliente"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Registrar mi anuncio</title>
	</head>
	<body>
		
		
		Introduce los datos para el registro<br/>
		<form action = "ServletRegistroAnuncioUsuario" method="post">
				
			titulo: 				<input type="text" name="campoTitulo" required/><br/>
			descripcion: 			<input type="text" name="campoDescripcion" required/><br/>
			dirección:				<input type="text" name="campoDireccion" required/><br/>
			población: 				<input type="text" name="campoPoblacion" required/><br/>
			precio: 				<input type="number" name="campoPrecio" required/><br/>
			Nº de habitaciones: 	<input type="number" name="campoNHabitaciones" required/><br/>
									<input type="hidden" name="campoId" value="${sessionScope.identificado}">			
									<input type="submit" value="ACEPTAR">
									
		</form>
		
		<a href="index.jsp">volver a inicio</a>
	
	</body>
</html>