package daosImpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import daos.ClientesDAO;
import daos.ConstantesSQL;
import daos.GenericDAO;
import modelo.Cliente;

public class UsuarioDAOImpl extends GenericDAO implements ClientesDAO {

	@Override
	public void registrarUsuario(Cliente cliente) {
		
		System.out.println(cliente.toString());
		
		conectar();

		try {
			PreparedStatement ps = con.prepareStatement(ConstantesSQL.INSERCION_USUARIO);
			ps.setString(1, cliente.getNombre());
			ps.setString(2, cliente.getCalle());
			ps.setString(3, cliente.getNumeracion());
			ps.setInt(4, cliente.getCodigoPostal());
			ps.setString(5, cliente.getPoblacion());
			ps.setString(6, cliente.getTelefono());
			ps.setString(7, cliente.getEmail());
			ps.setString(8, cliente.getParticularOempresa());
			ps.setString(9, cliente.getContraseña());
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			System.out.println("Error al registrar el usuario en la base de datos");
			e.printStackTrace();
		}
		desconectar();
	}

	@Override
	public List<Cliente> obtenerUsuarios() {

		conectar();

		List<Cliente> usuarios = new ArrayList<Cliente>();
		try {
			PreparedStatement ps = con.prepareStatement(ConstantesSQL.SELECCION_USUARIOS);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Cliente usuario = new Cliente();
				usuario.setNombre(rs.getString("nombre"));
				usuario.setCalle(rs.getString("calle"));
				usuario.setNumeracion(rs.getString("numeracion"));
				usuario.setCodigoPostal(rs.getInt("codigopostal"));
				usuario.setPoblacion(rs.getString("poblacion"));
				usuario.setTelefono(rs.getString("telefono"));
				usuario.setEmail(rs.getString("email"));
				usuario.setParticularOempresa(rs.getString("particularoempresa"));
				usuario.setContraseña(rs.getString("contraseña"));
				usuario.setId(rs.getInt("id"));
				usuarios.add(usuario);
			} // end while
			
			rs.close();
			ps.close();
		} catch (SQLException e) {
			System.out.println("Error en la obtencion de Usuario");
			e.printStackTrace();
		} // end catch

		desconectar();
		return usuarios;
	}

	@Override
	public int identificarUsuario(String email, String pass) {
		int identificado = -1;
		conectar();

		try {
			PreparedStatement ps = con.prepareStatement(ConstantesSQL.IDENTIFICACION_USUARIO);
			ps.setString(1, email);
			ps.setString(2, pass);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				identificado = rs.getInt("id");
			}
			rs.close();
			ps.close();
		} catch (SQLException e) {
			System.out.println("Error al identificar el usuario (error pass/email)");
			e.printStackTrace();
		}

		desconectar();
		return identificado;
	}

	@Override
	public boolean identificarAdmin(String usuario, String pass) {
		boolean identificado = false;
		conectar();

		try {
			PreparedStatement ps = con.prepareStatement(ConstantesSQL.IDENTIFICACION_ADMIN);
			ps.setString(1, usuario);
			ps.setString(2, pass);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				identificado = true;
			}
			ps.close();
		} catch (SQLException e) {
			System.out.println("Error al identificar el admin (error pass/email) o no tiene permisos");
			e.printStackTrace();
		}

		desconectar();
		return identificado;
	}

	@Override
	public void borrarUsuario(int id) {
		
		conectar();

		try {
			PreparedStatement ps = con.prepareStatement(ConstantesSQL.BORRAR_USUARIO);
			ps.setInt(1, id);
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			System.out.println("Error al BORRAR el USUARIOS en la base de datos: 	"+id);
			e.printStackTrace();
		}

		desconectar();
	}

	@Override
	public List<Cliente> obtenerUsuarioAeditar(int id) {
		conectar();

		List<Cliente> usuarios = new ArrayList<Cliente>();
		try {
			PreparedStatement ps = con.prepareStatement(ConstantesSQL.SELECCION_USUARIOS_EXCLUSIVO);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				Cliente usuario = new Cliente();
				usuario.setNombre(rs.getString("nombre"));
				usuario.setCalle(rs.getString("calle"));
				usuario.setNumeracion(rs.getString("numeracion"));
				usuario.setCodigoPostal(rs.getInt("codigopostal"));
				usuario.setPoblacion(rs.getString("poblacion"));
				usuario.setTelefono(rs.getString("telefono"));
				usuario.setEmail(rs.getString("email"));
				usuario.setParticularOempresa(rs.getString("particularoempresa"));
				usuario.setContraseña(rs.getString("contraseña"));
				usuario.setId(rs.getInt("id"));
				usuarios.add(usuario);
			} 
			rs.close();
			ps.close();
		} catch (SQLException e) {
			System.out.println("Error en la obtencion de Usuario");
			e.printStackTrace();
		} // end catch

		desconectar();
		return usuarios;
	}

	@Override
	public void modificarUsuario(Cliente cliente) {
		
		conectar();
		System.out.println("Modificar Usuario: "+cliente.toString());
		try {
			PreparedStatement ps = con.prepareStatement(ConstantesSQL.GUARDAR_CAMBIOS_USUARIO);
			ps.setString(1, cliente.getNombre());
			ps.setString(2, cliente.getCalle());
			ps.setString(3, cliente.getNumeracion());
			ps.setInt(4, cliente.getCodigoPostal());
			ps.setString(5, cliente.getPoblacion());
			ps.setString(6, cliente.getTelefono());
			ps.setString(7, cliente.getEmail());
			ps.setString(8, cliente.getParticularOempresa());
			ps.setString(9, cliente.getContraseña());
			ps.setInt(10, cliente.getId());
			ps.execute();
			ps.close();
		} catch (SQLException e) {
			System.out.println("Error al modificar los anuncios en la base de datos");
			e.printStackTrace();
		}
		System.out.println("CAMBIOS REALIZADOS EN LA TABLA ANUNCIOS");
		desconectar();
		
	}

	@Override
	public int identificarCliente(String email, String pass) {
		int identificado = -1;
		conectar();

		try {
			PreparedStatement ps = con.prepareStatement(ConstantesSQL.IDENTIFICACION_CLIENTE);
			ps.setString(1, email);
			ps.setString(2, pass);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				identificado = rs.getInt("id");
			}
			rs.close();
			ps.close();
		} catch (SQLException e) {
			System.out.println("Error al identificar el usuario (error pass/email)");
			e.printStackTrace();
		}

		desconectar();
		return identificado;
	}
}
