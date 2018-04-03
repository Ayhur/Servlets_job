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
		<title>Cambios Realizados</title>
	</head>
	<body>
	
	<c:if test="${cliente != null}">
				
		<div>El usuario fue modificado con éxito</div>
		<div>
			<a href="ServletListadoUsuariosRegistrados"> Volver a listado de usuarios </a><br/>
			<a href="menu.jsp"> Volver a menu </a><br/>
		</div>
	</c:if>
	
	<c:if test="${anuncio != null}">
				
		<div>El anuncio fue modificado con éxito</div>
		<div>
			<a href="ServletListadoAnunciosAdmin"> Volver a listado de anuncios </a><br/>
			<a href="menu.jsp"> Volver a menu </a><br/>
		</div>
	</c:if>
	
	</body>
</html>