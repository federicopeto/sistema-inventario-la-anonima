
package com.inventario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

public class MovimientoDAO {

    public void guardarMovimiento(MovimientoStock movimiento)
            throws SQLException {

        String sql = "INSERT INTO movimiento_stock "
                + "(fecha, tipo_movimiento, cantidad, "
                + "id_producto, id_usuario) "
                + "VALUES (?, ?, ?, ?, ?)";

        try (Connection conexion = ConexionBD.conectar();
             PreparedStatement consulta =
                     conexion.prepareStatement(sql)) {

            consulta.setTimestamp(1,
                    Timestamp.valueOf(movimiento.getFecha()));

            consulta.setString(2,
                    movimiento.getTipoMovimiento());

            consulta.setInt(3,
                    movimiento.getCantidad());

            consulta.setInt(4,
                    movimiento.getIdProducto());

            consulta.setInt(5,
                    movimiento.getIdUsuario());

            consulta.executeUpdate();
        }
    }
}
