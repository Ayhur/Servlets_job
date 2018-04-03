package modelo;

public class Cliente {
	
	private int id, codigoPostal;
	private String nombre, calle, numeracion, poblacion, telefono, email, particularOempresa,contraseña;
	
	public Cliente() {
	}

	public Cliente(int codigoPostal, String nombre, String calle, String numeracion, String poblacion, String telefono,
			String email, String particularOempresa, String contraseña) {
		super();
		this.codigoPostal = codigoPostal;
		this.nombre = nombre;
		this.calle = calle;
		this.numeracion = numeracion;
		this.poblacion = poblacion;
		this.telefono = telefono;
		this.email = email;
		this.particularOempresa = particularOempresa;
		this.contraseña = contraseña;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCodigoPostal() {
		return codigoPostal;
	}

	public void setCodigoPostal(int codigoPostal) {
		this.codigoPostal = codigoPostal;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public String getNumeracion() {
		return numeracion;
	}

	public void setNumeracion(String numeracion) {
		this.numeracion = numeracion;
	}

	public String getPoblacion() {
		return poblacion;
	}

	public void setPoblacion(String poblacion) {
		this.poblacion = poblacion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getParticularOempresa() {
		return particularOempresa;
	}

	public void setParticularOempresa(String particularOempresa) {
		this.particularOempresa = particularOempresa;
	}

	public String getContraseña() {
		return contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}

	@Override
	public String toString() {
		return "Cliente [id=" + id + ", codigoPostal=" + codigoPostal + ", nombre=" + nombre + ", calle=" + calle
				+ ", numeracion=" + numeracion + ", poblacion=" + poblacion + ", telefono=" + telefono + ", email="
				+ email + ", particularOempresa=" + particularOempresa + ", contraseña=" + contraseña + "]";
	}
}
