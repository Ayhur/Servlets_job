package servletAdmin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daos.ClientesDAO;
import daosImpl.UsuarioDAOImpl;

@WebServlet("/admin/ServletIdentificacionAdmin")
public class ServletIdentificacionAdmin extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("se ejecuta el servlet de identificacion de admin");
		
		String email = request.getParameter("campoEmail");
		String pass = request.getParameter("campoPass");
		System.out.println("voy a identificar a: "+ email + " - "+ pass);
		
		ClientesDAO usuariosDAO = new UsuarioDAOImpl();
		int idUsuario = usuariosDAO.identificarUsuario(email, pass);
		if(idUsuario != -1) {
			System.out.println("identificado correctamente");
			//admin identificado correctamente
			request.getSession().setAttribute("identificado", idUsuario);
			request.getRequestDispatcher("index.jsp").forward(request, response);
			
		}else {
			System.out.println("identificacion incorrecta");
			//email o pass incorrectos
			request.setAttribute("mensaje", "email/pass incorrectos");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
		
	}

}
