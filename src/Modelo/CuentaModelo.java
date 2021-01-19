package modelo;

public class CuentaModelo {
    private String usuario;
    private String clave;

    public String getNombre_Usuario() {
        return usuario;
    }

    public void setNombre_Usuario(String nombre_Usuario) {
        this.usuario = nombre_Usuario;
    }

    public String getContrasenia() {
        return clave;
    }

    public void setContrasenia(String contrasenia) {
        this.clave = contrasenia;
    }
    
    
}
