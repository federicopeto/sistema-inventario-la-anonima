
package com.inventario;

import java.sql.Connection;
import java.sql.SQLException;

public interface MovimientoRepository {

    void guardarMovimiento(
        Connection conexion,
        MovimientoStock movimiento
    ) throws SQLException;
}
