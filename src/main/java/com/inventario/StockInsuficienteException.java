
package com.inventario;

public class StockInsuficienteException extends IllegalArgumentException {

    public StockInsuficienteException(String mensaje) {
        super(mensaje);
    }
}
