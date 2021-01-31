package modelo;

public class PersonaModelo {

    private Integer id;
    private String nombre;
    private String correo;
    private String telefono;
    private int external_id;
    private String cedula;
    private int id_cuenta;
    private int id_rol;
    private String path_imagen;
    private boolean activo;

    /**
     * Metodo obtener id
     *
     * @return Un Integer correspondiente a id
     */
    public Integer getId() {
        return id;
    }

    /**
     * Metodo enviar id
     *
     * @param id
     */
    public void setId(Integer id) {
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
     * Metodo obtener correo
     *
     * @return Un String correspondiente a correo
     */
    public String getCorreo() {
        return correo;
    }

    /**
     * Metodo enviar correo
     *
     * @param correo
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    /**
     * Metodo obtener telefono
     *
     * @return Un String correspondiente a telefono
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * Metodo enviar telefono
     *
     * @param telefono
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * Metodo obtener getExternal_id
     *
     * @return Un int correspondiente a getExternal_id
     */
    public int getExternal_id() {
        return external_id;
    }

    /**
     * Metodo enviar getExternal_id
     *
     * @param external_id
     */
    public void setExternal_id(int external_id) {
        this.external_id = external_id;
    }

    /**
     * Metodo obtener cedula
     *
     * @return Un String correspondiente a cedula
     */
    public String getCedula() {
        return cedula;
    }

    /**
     * Metodo enviar cedula
     *
     * @param cedula
     */
    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    /**
     * Metodo obtener id_cuenta
     *
     * @return Un int correspondiente a id_cuenta
     */
    public int getId_cuenta() {
        return id_cuenta;
    }

    /**
     * Metodo enviar id_cuenta
     *
     * @param id_cuenta
     */
    public void setId_cuenta(int id_cuenta) {
        this.id_cuenta = id_cuenta;
    }

    /**
     * Metodo obtener id_rol
     *
     * @return Un int correspondiente a id_rol
     */
    public int getId_rol() {
        return id_rol;
    }

    /**
     * Modelo enviar id_rol
     *
     * @param id_rol
     */
    public void setId_rol(int id_rol) {
        this.id_rol = id_rol;
    }

    /**
     * Modelo obtener path_imagen
     *
     * @return Un String correspondiente a path_imagen
     */
    public String getPath_imagen() {
        return path_imagen;
    }

    /**
     * Metodo enviar path_imagen
     *
     * @param path
     */
    public void setPath_imagen(String path_imagen) {
        this.path_imagen = path_imagen;
    }

    public boolean getEstaDespedido() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

}
