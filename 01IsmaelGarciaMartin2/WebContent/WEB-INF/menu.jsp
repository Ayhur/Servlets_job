<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>


<c:if test="${ sessionScope.identificado == null }">
	<span style="color: red;">debes identificarte para regisrar tu anuncio</span><br/>
	<a href="login.jsp">identificarme</a><br/>
	
</c:if>
<c:if test="${ sessionScope.identificado != null }">
	<a href="registrarAnuncio.jsp">					Registrar mi anuncio				</a><br/>
	<a href="ServletListadoAnunciosAdmin">			mostrar anuncios					</a><br/>
	<a href="ServletLogOut">						Cerrar sesion						</a><br/>
</c:if>	
