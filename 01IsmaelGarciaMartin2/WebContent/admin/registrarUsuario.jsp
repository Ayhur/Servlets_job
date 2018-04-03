<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Registro de usuarios</title>
	</head>
	<body>
		
		
		Introduce los datos para el registro:<br/>
		<form action = "ServletRegistroUsuarioAdmin" method="post">
				
			nombre: <input type="text" name="campoNombre"/><br/>
			calle: <input type="text" name="campoCalle"/><br/>
			numeracion: <input type="text" name="campoNumeracion"/><br/>
			codigo postal: <input type="text" name="campoCodigoPostal"/><br/>
			poblacion: <input type="text" name="campoPoblacion"/><br/>
			telefono: <input type="text" name="campoTelefono"/><br/>
			email: <input type="text" name="campoEmail"/><br/>
			Particular o empresa: <input type="text" name="campoParticular"/><br/>
			contraseña: <input type="text" name="campoContraseña"/><br/>
			<input type="submit" value="ACEPTAR">
			
		</form>
		
		<a href="index.jsp">volver a inicio</a>
		
	
	</body>
</html>