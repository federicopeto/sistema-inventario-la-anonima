
package com.inventario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDAO {

    public Usuario iniciarSesion(String nombreUsuario, String contrasena)
            throws SQLException {

        String sql = "SELECT * FROM usuario "
                + "WHERE nombre_usuario = ? AND contrasena = ?";

        try (Connection conexion = ConexionBD.conectar();
             PreparedStatement consulta = conexion.prepareStatement(sql)) {

            consulta.setString(1, nombreUsuario);
            consulta.setString(2, contrasena);

            try (ResultSet resultado = consulta.executeQuery()) {

                if (resultado.next()) {
                    return new Usuario(
                        resultado.getInt("id_usuario"),
                        resultado.getString("nombre"),
                        resultado.getString("nombre_usuario"),
                        resultado.getString("contrasena"),
                        resultado.getString("rol")
                    );
                }
            }
        }

        return null;
    }
}
