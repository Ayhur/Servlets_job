<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	
	
	<div style="color: red">&nbsp;${mensaje}</div>
	Introduce tus datos de administrador:
	<br />
	<form action="ServletIdentificacionAdmin" method="post">
		email: <input type = "text" name="campoEmail" value="admin"/><br/>
		contraseña: <input type="password" name="campoPass" value="123"/><br/>
		<input type="submit" value="IDENTIICARME"/>
	</form>

</body>
</html>