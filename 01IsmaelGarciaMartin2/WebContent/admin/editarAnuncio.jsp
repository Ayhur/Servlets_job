<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<jsp:include page="menu.jsp"></jsp:include>
	
	
	<form action="ServletGuardarCambiosAnuncios" method="post">
		titulo: <input type="text" name="campoTitulo" value = "${anuncioAeditar.anuncio} "/><br/>
		precio: <input type="number" name="campoPrecio"  value = "${anuncioAeditar.precio}"/><br/>
		email: <input type="text" name="campoEmail"  value = "${anuncioAeditar.email}"/><br/>
		telefono: <input type="text" name="campoTelefono"  value = "${anuncioAeditar.telefono}"/><br/>
		descripcion: 
		<textarea rows="3"cols="20" name="campoDescripcion">${anuncioAeditar.descripcion}</textarea>
		<br/>
		<input type="hidden" name="campoId" value="${anuncioAeditar.id}">
		<input type="submit" value="GUARDAR CAMBIOS"/>
	</form>
	
</body>
</html>