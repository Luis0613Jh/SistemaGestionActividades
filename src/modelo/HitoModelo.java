package modelo;

import java.util.Date;

public class HitoModelo {

    private int id;
    private String nombre;
    private String decripcion;
    private Date fechaInicio;
    private String prioridad;
    private PersonaModelo responsable;
    private boolean activo;
    private int external_id;

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
     * Metodo obtener nombre
     *
     * @return Un String correspondiente a nombre
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
     * Metodo obtener descripcion
     *
     * @return Un String correspondiente a descripcion
     */
    public String getDecripcion() {
        return decripcion;
    }

    /**
     * Metodo enviar Descripcion
     *
     * @param decripcion
     */
    public void setDecripcion(String decripcion) {
        this.decripcion = decripcion;
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
     * Metodo obtener prioridad
     *
     * @return
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
     * Metodo obtener responsable
     *
     * @return Un PersonaModelo correspondiente a responsable
     */
    public PersonaModelo getResponsable() {
        return responsable;
    }

    /**
     * Metodo enviar responsable
     *
     * @param responsable
     */
    public void setResponsable(PersonaModelo responsable) {
        this.responsable = responsable;
    }

    /**
     * Metodo obtener estado con boolean activo
     *
     * @return Un boolean correspondiente a activo
     */
    public boolean getActivo() {
        return activo;
    }

    /**
     * Metodo enviar activo
     *
     * @param activo
     */
    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    /**
     * Metodo obtener external_id
     *
     * @return Un String correspondiente a external_id
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
