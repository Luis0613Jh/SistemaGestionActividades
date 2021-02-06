package modelo;

import java.util.Date;

public class ActividadModelo {

    private int id;
    private String nombre;
    private Date fechaInicio;
    private Date fechaEntrega;
    private String descripcion;
    private String prioridad;
    private String estado;
    private int external_id;
    private int proyecto_id;
    private int departamento_id;

    public int getDepartamento_id() {
        return departamento_id;
    }

    public void setDepartamento_id(int departamento_id) {
        this.departamento_id = departamento_id;
    }

    /**
     * Metodo obtener id
     *
     * @return Un string correspondiente a id
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

    public int getProyecto_id() {
        return proyecto_id;
    }

    public void setProyecto_id(int proyecto_id) {
        this.proyecto_id = proyecto_id;
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
     * Método que convierte el objeto ActividadModelo en un string.
     * @return Devuelve un string con el nombre de la actividad.
     */
    @Override
    public String toString() {
        return nombre;
    }
}
