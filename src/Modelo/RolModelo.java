package Modelo;

public class RolModelo {
    private int id;
    private int external_id;
    private String tipo;

    public String getRol() {
        return tipo;
    }

    public void setRol(String Rol) {
        this.tipo = Rol;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getExternal_id() {
        return external_id;
    }

    public void setExternal_id(int external_id) {
        this.external_id = external_id;
    }
     
}
