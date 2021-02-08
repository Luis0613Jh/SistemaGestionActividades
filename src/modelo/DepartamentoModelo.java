package modelo;

public class DepartamentoModelo {

    private String nombreDepartamento;
    private int id_encargado;
    private int id;
    private int external_id;
    private String descripcion;
    private String estado;

    /**
     * Metodo obtener nombreDepartamento
     *
     * @return Un String correspondiente a nombreDepartamento
     */
    public String getNombreDepartamento() {
        return nombreDepartamento;
    }

    /**
     * Metodo enviar nombreDepartamento
     *
     * @param nombreDepartamento
     */
    public void setNombreDepartamento(String nombreDepartamento) {
        this.nombreDepartamento = nombreDepartamento;
    }

    /**
     * Metodo obtener encargado
     *
     * @return Un PersonaModelo correspondinete a encargado
     */
    public int getId_Encargado() {
        return id_encargado;
    }

    /**
     * Metodo enviar encargado
     *
     * @param id_encargado
     */
    public void setId_Encargado(int id_encargado) {
        this.id_encargado = id_encargado;
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
     * Metodo obtener descripcion
     *
     * @return Un String correspondiente a descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Metodo enviar descripcion
     *
     * @param descripcion
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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
     * Método que convierte el objeto DepartamentoModelo en un string.
     * @return Devuelve un string con el nombre del departamento.
     */
    @Override
    public String toString() {
        return nombreDepartamento;
    }

}
