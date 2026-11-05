
package com.inventario;

import java.sql.SQLException;

public interface MovimientoRepository {

    void guardarMovimiento(MovimientoStock movimiento)
            throws SQLException;
}
