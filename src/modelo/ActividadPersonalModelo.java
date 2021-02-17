package modelo;

import java.util.Date;

public class ActividadPersonalModelo {

    private int id;
    private String nombre;
    private Date fechaEntrega;
    private String descripcion;
    private String hora;
    private String estado;
    private int persona_id;

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

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public int getPersona_id() {
        return persona_id;
    }

    public void setPersona_id(int persona_id) {
        this.persona_id = persona_id;
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
