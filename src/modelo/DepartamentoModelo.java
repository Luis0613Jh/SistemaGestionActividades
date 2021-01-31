package modelo;

public class DepartamentoModelo {

    private String nombreDepartamento;
    private PersonaModelo encargado;
    private int id;
    private int external_id;
    private String descripcion;
    private boolean activo;

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
    public PersonaModelo getEncargado() {
        return encargado;
    }

    /**
     * Metodo enviar encargado
     *
     * @param encargado
     */
    public void setEncargado(PersonaModelo encargado) {
        this.encargado = encargado;
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

    public boolean getActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

}
