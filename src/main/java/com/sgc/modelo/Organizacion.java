
package com.sgc.modelo;

public class Organizacion {

    private int idOrganizacion;
    private String nombre;
    private String identificacion;
    private String direccion;
    private String telefono;
    private String correo;

    // Constructor vacío
    public Organizacion() {
    }

    // Constructor completo
    public Organizacion(int idOrganizacion, String nombre,
            String identificacion, String direccion,
            String telefono, String correo) {

        this.idOrganizacion = idOrganizacion;
        this.nombre = nombre;
        this.identificacion = identificacion;
        this.direccion = direccion;
        this.telefono = telefono;
        this.correo = correo;
    }

    // Constructor para nuevos registros
    public Organizacion(String nombre, String identificacion,
            String direccion, String telefono, String correo) {

        this.nombre = nombre;
        this.identificacion = identificacion;
        this.direccion = direccion;
        this.telefono = telefono;
        this.correo = correo;
    }

    public int getIdOrganizacion() {
        return idOrganizacion;
    }

    public void setIdOrganizacion(int idOrganizacion) {
        this.idOrganizacion = idOrganizacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    @Override
    public String toString() {
        return "Organizacion{" +
                "idOrganizacion=" + idOrganizacion +
                ", nombre='" + nombre + '\'' +
                ", identificacion='" + identificacion + '\'' +
                ", direccion='" + direccion + '\'' +
                ", telefono='" + telefono + '\'' +
                ", correo='" + correo + '\'' +
                '}';
    }
}
