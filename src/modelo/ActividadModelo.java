package modelo;

import java.util.Date;

public class ActividadModelo {

    private String id;
    private String nombre;
    private Date fechaInicio;
    private Date fechaEntrega;
    private String descripcion;
    private String prioridad;
    private boolean finalizado;
    private int external_id;

    /**
     * Metodo obtener id
     *
     * @return Un string correspondiente a id
     */
    public String getId() {
        return id;
    }

    /**
     * Metodo enviar id
     *
     * @param id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Metodo obtener nombre
     *
     * @return Un string correspondiente a nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Metodo enviar nombre
     *
     * @param nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Metodo obtener fechaInicio
     *
     * @return Un Date correspondiente a fechaInicio
     */
    public Date getFechaInicio() {
        return fechaInicio;
    }

    /**
     * Metodo enviar fechaInicio
     *
     * @param fechaInicio
     */
    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    /**
     * Metodo obtener fechaEntrega
     *
     * @return Un Date correspondiente a fechaEntrega
     */
    public Date getFechaEntrega() {
        return fechaEntrega;
    }

    /**
     * Metodo enviar fechaEntrega
     *
     * @param fechaEntrega
     */
    public void setFechaEntrega(Date fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
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
     * Metodo obtener prioridad
     *
     * @return Un String correspondiente a prioridad
     */
    public String getPrioridad() {
        return prioridad;
    }

    /**
     * Metodo enviar prioridad
     *
     * @param prioridad
     */
    public void setPrioridad(String prioridad) {
        this.prioridad = prioridad;
    }

    /**
     * Metodo enviar finalizado
     *
     * @return Un boolean que corresponde a finalizado
     */
    public boolean isFinalizado() {
        return finalizado;
    }

    /**
     * Metodo enviar finalizado
     *
     * @param finalizado
     */
    public void setFinalizado(boolean finalizado) {
        this.finalizado = finalizado;
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

}
