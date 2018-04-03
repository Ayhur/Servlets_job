package daos;

public class ConstantesSQL {

	public static final String INSERCION_ANUNCIO = "INSERT INTO anuncios (`titulo`,"
			+ " `descripcion`, `direccion`, `poblacion`, `precio`, Nhabitaciones, cliente) VALUES (?,?,?,?,?,?,?)";
	public static final String SELECCION_ANUNCIOS = "SELECT * FROM anuncios";
	public static final String SELECCION_USUARIOS = "SELECT * FROM clientes";
	public static final String SELECCION_USUARIOS_EXCLUSIVO = "SELECT * FROM clientes WHERE id = ?";
	public static final String SELECCION_ANUNCIO_EXCLUSIVO = "SELECT * FROM anuncios WHERE id = ?";
	public static final String INSERCION_USUARIO = "INSERT INTO `clientes`(`nombre`, `calle`, `numeracion`, `codigopostal`,"
			+ "poblacion, telefono, email, particularoempresa, contraseña) VALUES (?,?,?,?,?,?,?,?,?)";
	public static final String IDENTIFICACION_USUARIO = "SELECT id FROM administradores WHERE usuario = ? and contraseña = ?";
	public static final String IDENTIFICACION_CLIENTE = "SELECT id FROM clientes WHERE email = ? and contraseña = ?";
	public static final String IDENTIFICACION_ADMIN = "SELECT id FROM `administradores` WHERE `usuario` = ? and"
			+ " `contraseña` = ?";
	public static final String BORRAR_ANUNCIO = "DELETE FROM `anuncios` WHERE id = ?";
	public static final String BORRAR_ANUNCIO_USER = "DELETE FROM `anuncios` WHERE id = ? and cliente = ?";
	public static final String BORRAR_USUARIO = "DELETE FROM `clientes` WHERE id = ?";
	public static final String OBTENER_ANUNCIO_POR_ID = "SELECT * FROM tabla_anuncios WHERE id = ?";
	public static final String GUARDAR_CAMBIOS_USUARIO = "UPDATE clientes set nombre = ?, calle = ?, numeracion = ?,"
			+ " codigopostal = ?, poblacion = ?, telefono = ?, email = ?, particularoempresa = ?, contraseña = ?"
			+ " WHERE id = ?";
	public static final String GUARDAR_CAMBIOS_ANUNCIO = "UPDATE anuncios SET titulo=?, descripcion=?,direccion=?,poblacion= ?,precio=?,Nhabitaciones=? WHERE id = ?";

}
