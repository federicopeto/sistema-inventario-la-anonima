package com.inventario;

public class Producto {

    private int idProducto;
    private String nombre;
    private String descripcion;
    private int stockActual;
    private int stockMinimo;

    // Constructor
    public Producto(int idProducto, String nombre, String descripcion,
                    int stockActual, int stockMinimo) {
        this.idProducto = idProducto;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.stockActual = stockActual;
        this.stockMinimo = stockMinimo;
    }

    // Consultar el stock disponible
    public int consultarStock() {
        return stockActual;
    }

    // Actualizar el stock
    public void actualizarStock(int cantidad) {
        if (stockActual + cantidad < 0) {
            throw new IllegalArgumentException("Stock insuficiente");
        }
        stockActual += cantidad;
    }

    // Obtener los datos del producto
    public int getIdProducto() {
        return idProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getStockMinimo() {
        return stockMinimo;
    }
}
