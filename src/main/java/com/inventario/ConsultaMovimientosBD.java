
package com.inventario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConsultaMovimientosBD {

    public static void mostrarMovimientos() throws SQLException {

        String sql = "SELECT * FROM movimiento_stock ORDER BY fecha DESC";

        try (Connection conexion = ConexionBD.conectar();
             PreparedStatement consulta = conexion.prepareStatement(sql);
             ResultSet resultado = consulta.executeQuery()) {

            boolean hayMovimientos = false;

            while (resultado.next()) {
                hayMovimientos = true;

                System.out.println(
                    resultado.getString("tipo_movimiento")
                    + " - Producto: " + resultado.getInt("id_producto")
                    + " - Cantidad: " + resultado.getInt("cantidad")
                    + " - Fecha: " + resultado.getTimestamp("fecha")
                );
            }

            if (!hayMovimientos) {
                System.out.println("No hay movimientos registrados.");
            }
        }
    }
}
