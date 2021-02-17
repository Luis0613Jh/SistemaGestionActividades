package modelo;

import java.util.Date;

public class HitoModelo {

    private int id;
    private String nombre;
    private String decripcion;
    private Date fechaInicio;
    private String prioridad;
    private int id_responsable;
    private String estado;
    private int external_id;
    private int actividad_id;

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
    public int getId_Responsable() {
        return id_responsable;
    }

    /**
     * Metodo enviar responsable
     *
     * @param id_responsable
     */
    public void setId_Responsable(int id_responsable) {
        this.id_responsable = id_responsable;
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

    public int getActividad_id() {
        return actividad_id;
    }

    public void setActividad_id(int actividad_id) {
        this.actividad_id = actividad_id;
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
     * Método que convierte el objeto HitoModelo en un string.
     * @return Devuelve un string con el nombre del hito.
     */
    @Override
    public String toString() {
        return nombre;
    }
}
