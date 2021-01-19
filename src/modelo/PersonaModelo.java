package modelo;

public class PersonaModelo {
    private Integer id;
    private String nombre;
    private String correo;
    private String telefono;
    private String external_id;
    private String cedula;
    private int idCuenta;
    private RolModelo rol;
    private String path;

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public CuentaModelo getCuanta() {
        return cuanta;
    }

    public void setCuanta(CuentaModelo cuanta) {
        this.cuanta = cuanta;
    }

    public RolModelo getRol() {
        return rol;
    }

    public void setRol(RolModelo rol) {
        this.rol = rol;
    }
    

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getExternal_id() {
        return external_id;
    }

    public void setExternal_id(String external_id) {
        this.external_id = external_id;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }
    
    
    
}
