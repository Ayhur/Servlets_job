package servletAdmin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daos.ClientesDAO;
import daosImpl.UsuarioDAOImpl;

@WebServlet("/admin/ServletListadoUsuariosRegistrados")
public class ServletListadoUsuariosRegistrados extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		if(request.getParameter("id")!=null) {
			System.out.println("El id es: "+Integer.parseInt(request.getParameter("id")));
			ClientesDAO daoUsuario = new UsuarioDAOImpl();
			request.setAttribute("usuarioExclusivo", daoUsuario.obtenerUsuarioAeditar(Integer.parseInt(request.getParameter("id"))));
			request.getRequestDispatcher("listarUsuarios.jsp").forward(request, response);
		}else {
			System.out.println("obteniendo USUARIOS para gestionarlos en ADMINISTRACION");
			ClientesDAO daoUsuario = new UsuarioDAOImpl();
			request.setAttribute("usuarios", daoUsuario.obtenerUsuarios());
			request.getRequestDispatcher("listarUsuarios.jsp").forward(request, response);
		}
	}
}
