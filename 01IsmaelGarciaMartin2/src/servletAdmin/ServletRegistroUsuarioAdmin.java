package servletAdmin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daos.ClientesDAO;
import daosImpl.UsuarioDAOImpl;
import modelo.Cliente;

@WebServlet("/admin/ServletRegistroUsuarioAdmin")
public class ServletRegistroUsuarioAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String nombre = request.getParameter("campoNombre");
		String calle = request.getParameter("campoCalle");
		String numeracion = request.getParameter("campoNumeracion");
		String codigoPostal  = request.getParameter("campoCodigoPostal");
		String poblacion = request.getParameter("campoPoblacion");
		String telefono = request.getParameter("campoTelefono");
		String email = request.getParameter("campoEmail");
		String particular = request.getParameter("campoParticular");
		String contraseña = request.getParameter("campoContraseña");
		
		Cliente usuario = new Cliente(Integer.parseInt(codigoPostal), nombre, calle, numeracion, poblacion, telefono, email, particular, contraseña);
		
		ClientesDAO DAOCliente = new UsuarioDAOImpl();
		DAOCliente.registrarUsuario(usuario);
				
		request.getRequestDispatcher("RegistroUsuarioOK.jsp").forward(request, response);
	}

}
