
package com.inventario;

import java.time.LocalDateTime;

public class MovimientoStock {

    private int idMovimiento;
    private LocalDateTime fecha;
    private String tipoMovimiento;
    private int cantidad;
    private int idProducto;
    private int idUsuario;

    public MovimientoStock(int idMovimiento, LocalDateTime fecha,
                           String tipoMovimiento, int cantidad,
                           int idProducto, int idUsuario) {
        this.idMovimiento = idMovimiento;
        this.fecha = fecha;
        this.tipoMovimiento = tipoMovimiento;
        this.cantidad = cantidad;
        this.idProducto = idProducto;
        this.idUsuario = idUsuario;
    }

    public int getIdMovimiento() {
        return idMovimiento;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public String getTipoMovimiento() {
        return tipoMovimiento;
    }

    public int getCantidad() {
        return cantidad;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public int getIdUsuario() {
        return idUsuario;
    }
}
