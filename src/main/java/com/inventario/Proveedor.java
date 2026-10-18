
package com.inventario;

public class Proveedor {

    private int idProveedor;
    private String nombre;
    private String telefono;
    private String correoElectronico;

    public Proveedor(int idProveedor, String nombre,
                     String telefono, String correoElectronico) {
        this.idProveedor = idProveedor;
        this.nombre = nombre;
        this.telefono = telefono;
        this.correoElectronico = correoElectronico;
    }

    public int getIdProveedor() {
        return idProveedor;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }
}
