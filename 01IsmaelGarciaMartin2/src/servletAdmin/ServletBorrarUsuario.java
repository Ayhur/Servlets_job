package servletAdmin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daos.AnunciosDAO;
import daos.ClientesDAO;
import daosImpl.AnunciosDAOImpl;
import daosImpl.UsuarioDAOImpl;

@WebServlet("/admin/ServletBorrarUsuario")
public class ServletBorrarUsuario extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id = Integer.parseInt(request.getParameter("id"));
		System.out.println("Borrar USUARIO de ID: " + id);
		
		//instancio el objeto
		ClientesDAO daoUser = new UsuarioDAOImpl();
		
		daoUser.borrarUsuario(id);
		request.getRequestDispatcher("borradoOK.jsp").forward(request, response);
		
	}

}
