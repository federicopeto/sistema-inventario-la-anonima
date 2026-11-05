

package com.inventario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ControlInventario {

    private List<MovimientoStock> movimientos = new ArrayList<>();
    private MovimientoRepository repositorio = new MovimientoDAO();

    public void registrarEntrada(Producto producto, Usuario usuario,
                                int cantidad) throws SQLException {
        registrarMovimiento(producto, usuario, cantidad, "Entrada");
    }

    public void registrarSalida(Producto producto, Usuario usuario,
                               int cantidad) throws SQLException {
        registrarMovimiento(producto, usuario, cantidad, "Salida");
    }

    private void registrarMovimiento(Producto producto, Usuario usuario,
                                    int cantidad, String tipo)
            throws SQLException {

        if (cantidad <= 0) {
            throw new IllegalArgumentException(
                "La cantidad debe ser mayor a cero");
        }

        int diferencia = tipo.equals("Entrada") ? cantidad : -cantidad;
        int nuevoStock = producto.consultarStock() + diferencia;

        
if (nuevoStock < 0) {
    throw new StockInsuficienteException(
        "Stock insuficiente. Disponible: "
        + producto.consultarStock()
        + ", solicitado: " + cantidad
    );
}


        MovimientoStock movimiento = new MovimientoStock(
            movimientos.size() + 1,
            LocalDateTime.now(),
            tipo,
            cantidad,
            producto.getIdProducto(),
            usuario.getIdUsuario()
        );

        try (Connection conexion = ConexionBD.conectar()) {
            conexion.setAutoCommit(false);

            try {
                String actualizar = "UPDATE producto SET stock_actual = ? "
                        + "WHERE id_producto = ?";

                try (PreparedStatement consulta =
                        conexion.prepareStatement(actualizar)) {

                    consulta.setInt(1, nuevoStock);
                    consulta.setInt(2, producto.getIdProducto());

                    if (consulta.executeUpdate() != 1) {
                        throw new SQLException("Producto no encontrado en MySQL");
                    }
                }

repositorio.guardarMovimiento(conexion, movimiento);

                conexion.commit();

            } catch (SQLException e) {
                conexion.rollback();
                throw e;
            }
        }

        producto.actualizarStock(diferencia);
        movimientos.add(movimiento);

        System.out.println(tipo + " registrada correctamente.");
        System.out.println("Stock actual: " + producto.consultarStock());
    }

    public void consultarMovimientos() {
        if (movimientos.isEmpty()) {
            System.out.println("No hay movimientos registrados.");
            return;
        }

        for (MovimientoStock movimiento : movimientos) {
            System.out.println(
                movimiento.getTipoMovimiento()
                + " - Producto: " + movimiento.getIdProducto()
                + " - Cantidad: " + movimiento.getCantidad()
                + " - Fecha: " + movimiento.getFecha()
            );
        }
    }
}

