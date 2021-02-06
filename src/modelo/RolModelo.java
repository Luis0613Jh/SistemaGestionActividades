package modelo;

public class RolModelo {

    private int id;
    private int external_id;
    private String tipo;
    private String estado;

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
    public String getTipo() {
        return tipo;
    }

    /**
     * Metodo enviar tipo
     *
     * @param Rol
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
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
     * Método que convierte el objeto RolModelo en un string.
     * @return Devuelve un string con el tipo de rol.
     */
    @Override
    public String toString() {
        return tipo;
    }
    
}
