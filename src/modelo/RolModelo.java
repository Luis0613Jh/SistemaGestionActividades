package modelo;

public class RolModelo {

    private int id;
    private int external_id;
    private String tipo;
    private boolean activo;

    public RolModelo(int id, int external_id, String tipo) {
        this.id = id;
        this.external_id = external_id;
        this.tipo = tipo;
    }

    public RolModelo() {
       
    }

    /**
     * Metodo obtener tipo
     *
     * @return Un String correspondiente a id
     */
    public String getRol() {
        return tipo;
    }

    /**
     * Metodo enviar tipo
     *
     * @param Rol
     */
    public void setRol(String Rol) {
        this.tipo = Rol;
    }

    /**
     * Metodo obtener id
     *
     * @return Un int correspondiente a id
     */
    public int getId() {
        return id;
    }

    /**
     * Metodo enviar id
     *
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Metodo obtener external_id
     *
     * @return Un int correspondiente a external_id
     */
    public int getExternal_id() {
        return external_id;
    }

    /**
     * Metodo enviar external_id
     *
     * @param external_id
     */
    public void setExternal_id(int external_id) {
        this.external_id = external_id;
    }
    
    public boolean getActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    @Override
    public String toString() {
        return tipo; 
    }
    
}
