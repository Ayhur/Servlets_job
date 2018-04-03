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

@WebServlet("/admin/ServletGuardarCambiosCliente")
public class ServletGuardarCambiosCliente extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String codigoPostal = request.getParameter("campoCodigoPostal");
		String nombre = request.getParameter("campoNombre");
		String calle = request.getParameter("campoCalle");
		String numeracion = request.getParameter("campoNumeracion");
		String poblacion = request.getParameter("campoPoblacion");
		String telefono = request.getParameter("campoTelefono");
		String email = request.getParameter("campoEmail");
		String particularOempresa = request.getParameter("campoParticular");
		String contraseña = request.getParameter("campoContraseña");
		String id = request.getParameter("campoId");
		
		System.out.println(codigoPostal+"-"+nombre+"-"+calle+"-"+numeracion+"-"+poblacion+"-"+telefono+"-"+email+"-"+particularOempresa+"-"+contraseña+"-"+id);
		
		Cliente c = new Cliente(Integer.parseInt(codigoPostal), nombre, calle, numeracion, poblacion, telefono, email, particularOempresa, contraseña);
		c.setId(Integer.parseInt(id));
		ClientesDAO DAOcliente = new UsuarioDAOImpl();
		DAOcliente.modificarUsuario(c);
		
		
		request.setAttribute("cliente", "ok");
		request.getRequestDispatcher("cambiosOK.jsp").forward(request, response);

	}

}
