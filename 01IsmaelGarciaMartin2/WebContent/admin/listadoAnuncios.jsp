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
		
		<c:if test="${anuncioExclusivo != null}">
				
				<c:forEach items="${anuncioExclusivo}" var="anuncio">
			
					<form action="ServletGuardarCambiosAnuncio" method="post">
						<div style="margin: 10px">
						<hr size="2px">
						titulo: 				<input type="text" name="campoTitulo" value="${anuncio.titulo}" required/><br/>
						descripcion: 			<input type="text" name="campoDescripcion" value="${anuncio.descripcion}" required/><br/>
						dirección:				<input type="text" name="campoDireccion" value="${anuncio.direccion}" required/><br/>
						población: 				<input type="text" name="campoPoblacion" value="${anuncio.poblacion}" required/><br/>
						precio: 				<input type="number" name="campoPrecio" value="${anuncio.precio}" required/><br/>
						Nº de habitaciones: 	<input type="text" name="campoNHabitaciones" value="${anuncio.nhabitaciones}" required/><br/>
												<input type="hidden" name="campoId" value="${anuncio.id}" />
												<input type="submit" value="GUARDAR CAMBIOS" />
						<a href = "ServletListadoAnunciosAdmin">VOLVER A LISTADO</a>
						</div>
					</form>
		
				</c:forEach>

			</c:if>
			
			<c:if test="${anuncios != null}">
				
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
						<a href = "ServletListadoAnunciosAdmin?id=${anuncio.id}">EDITAR</a>
						<a href = "ServletBorrarAnuncio?id=${anuncio.id}">BORRAR</a>
					</div>
		
				</c:forEach>
				
				<a href="menu.jsp"> Volver a menu </a><br/>

			</c:if>
	
	</body>
</html>