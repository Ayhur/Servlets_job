package daos;

import java.util.List;

import modelo.Cliente;

public interface ClientesDAO {
	
	void registrarUsuario(Cliente cliente);
	List<Cliente> obtenerUsuarios();
	int identificarUsuario(String email, String pass);
	int identificarCliente(String email, String pass);
	boolean identificarAdmin(String email, String pass);
	void borrarUsuario(int id);
	List<Cliente> obtenerUsuarioAeditar(int id);
	void modificarUsuario(Cliente cliente);

}
