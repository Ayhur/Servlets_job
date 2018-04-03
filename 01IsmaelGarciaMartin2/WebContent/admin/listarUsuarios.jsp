<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@page import="modelo.Cliente"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Lista de usuarios</title>
	</head>
	<body>
			
			
			<c:if test="${usuarioExclusivo != null}">
				
				<c:forEach items="${usuarioExclusivo}" var="usuario">
			
					<form action="ServletGuardarCambiosCliente" method="post">
						<div style="margin: 10px">
						<hr size="2px">
						nombre: 		<input type="text" name="campoNombre" value="${usuario.nombre}" required/><br/>
						calle: 			<input type="text" name="campoCalle" value="${usuario.calle}" required/><br/>
						numeración:		<input type="text" name="campoNumeracion" value="${usuario.numeracion}" required/><br/>
						codigo postal: 	<input type="number" name="campoCodigoPostal" value="${usuario.codigoPostal}" required/><br/>
						población: 		<input type="text" name="campoPoblacion" value="${usuario.poblacion}" required/><br/>
						telefono: 		<input type="text" name="campoTelefono" value="${usuario.telefono}" required/><br/>
						email: 			<input type="email" name="campoEmail" value="${usuario.email}" required/><br/>
						particular: 	<input type="text" name="campoParticular" value="${usuario.particularOempresa}" required/><br/>
						contraseña: 	<input type="text" name="campoContraseña" value="${usuario.contraseña}" required/><br/>
										<input type="hidden" name="campoId" value="${usuario.id}" />
										<input type="submit" value="GUARDAR CAMBIOS" />
						<!-- a href = "ServletGuardarCambiosCliente?id=${usuario.id}">GUARDAR CAMBIOS</a>  -->
						<a href = "ServletListadoUsuariosRegistrados">VOLVER A LISTADO</a>
						</div>
					</form>
						
		
				</c:forEach>

			</c:if>
			
			<c:if test="${usuarios != null}">
				
				<c:forEach items="${usuarios}" var="usuario">
			
					<div style="margin: 10px">
						<hr size="2px">
						nombre: 		${usuario.nombre}<br/>
						calle: 			${usuario.calle}<br/>
						numeración:		${usuario.numeracion}<br/>
						codigo postal: 	${usuario.codigoPostal}<br/>
						población: 		${usuario.poblacion}<br/>
						telefono: 		${usuario.telefono}<br/>
						email: 			${usuario.email}<br/>
						particular: 	${usuario.particularOempresa}<br/>
						contraseña: 	${usuario.contraseña}<br/>
						<a href = "ServletListadoUsuariosRegistrados?id=${usuario.id}">EDITAR</a>
						<a href = "ServletBorrarUsuario?id=${usuario.id}">BORRAR</a>
					</div>
		
				</c:forEach>

			</c:if>
			
			
			
	</body>
</html>