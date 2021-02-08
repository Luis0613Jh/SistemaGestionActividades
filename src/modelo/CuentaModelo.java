package modelo;

public class CuentaModelo {

    private int id;
    private int external_id;
    private String usuario;
    private String clave;
    private String estado;

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
     * Metodo obtener usuario
     *
     * @return Un String correspondiente a usuario
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * Metodo enviar usuario
     *
     * @param usuario
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    /**
     * Metodo obtener clave
     *
     * @return Un String correspondiente a clave
     */
    public String getClave() {
        return clave;
    }

    /**
     * Metodo enviar clave
     *
     * @param clave
     */
    public void setClave(String clave) {
        this.clave = clave;
    }

    /**
     * Método que obtiene el dato almacenado en estado.
     * @return Retrona una string correspondiente a estado
     */
    public String getEstado() {
        return estado;
    }

    /**
     * Método que sobreescribe el dato almacenado en estado.
     * @param estado String que va reemplazar el dato en estado.
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     * Método que convierte el objeto CuentaModelo en un string.
     * @return Devuelve un string con el usuario.
     */
    @Override
    public String toString() {
        return usuario;
    }

}
