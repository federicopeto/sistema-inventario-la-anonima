
package com.inventario;

public class Usuario extends Persona {

    private String nombreUsuario;
    private String contrasena;
    private String rol;

    public Usuario(int idUsuario, String nombre,
                   String nombreUsuario, String contrasena,
                   String rol) {

        super(idUsuario, nombre);
        this.nombreUsuario = nombreUsuario;
        this.contrasena = contrasena;
        this.rol = rol;
    }

    public int getIdUsuario() {
        return getId();
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public String getRol() {
        return rol;
    }

    public boolean verificarContrasena(String clave) {
        return contrasena.equals(clave);
    }

    @Override
    public String mostrarRol() {
        return "Rol del usuario: " + rol;
    }
}
