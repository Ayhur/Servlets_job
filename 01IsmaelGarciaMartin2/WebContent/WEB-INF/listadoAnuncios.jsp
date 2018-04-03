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
		<title>Portal anuncios</title>
	</head>
	<body>
				
				<c:forEach items="${anuncios}" var="anuncio">
			
					<div style="margin: 10px">
						<hr size="2px">
						titulo: 			${anuncio.titulo}<br/>
						descripcion: 		${anuncio.descripcion}<br/>
						dirección:			${anuncio.direccion}<br/>
						población: 			${anuncio.poblacion}<br/>
						precio:				${anuncio.precio}<br>
						Nº de habitaciones:	${anuncio.nhabitaciones}<br>
						nombre:				${anuncio.cliente.nombre}<br/>
						telefono: 			${anuncio.cliente.telefono}<br/>
						email: 				${anuncio.cliente.email}<br/>
						particular: 		${anuncio.cliente.particularOempresa}<br/>
						<a href = "ServletBorrarAnuncioUsuario?id=${anuncio.id}">BORRAR</a>
					</div>
		
				</c:forEach>
				
				<a href="menu.jsp"> Volver a menu </a><br/>
	</body>
</html>