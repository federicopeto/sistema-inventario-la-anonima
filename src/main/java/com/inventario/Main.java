
package com.inventario;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);
        
LoginDAO login = new LoginDAO();
Usuario usuarioAutenticado = null;

try {
    System.out.println("=== INICIO DE SESION ===");

    System.out.print("Usuario: ");
    String nombreUsuario = teclado.nextLine();

    System.out.print("Contrasena: ");
    String contrasena = teclado.nextLine();

    usuarioAutenticado = login.iniciarSesion(nombreUsuario, contrasena);

    if (usuarioAutenticado == null) {
        System.out.println("Usuario o contrasena incorrectos.");
        teclado.close();
        return;
    }

   System.out.println("Bienvenido al Sistema de Inventario de La Anónima, " + usuarioAutenticado.getNombre());
   
Persona persona = usuarioAutenticado;
System.out.println(persona.mostrarRol());


} catch (java.sql.SQLException e) {
    System.out.println("Error al iniciar sesion: " + e.getMessage());
    teclado.close();
    return;
}

        
try (java.sql.Connection conexion = ConexionBD.conectar()) {
    System.out.println("Conexion con MySQL exitosa. Base de datos: "
        + conexion.getCatalog());
} catch (java.sql.SQLException e) {
    System.out.println("Error al conectar con MySQL: " + e.getMessage());
}


      
Producto producto;

try (java.sql.Connection conexion = ConexionBD.conectar();
     java.sql.PreparedStatement consulta = conexion.prepareStatement(
         "SELECT id_producto, nombre, descripcion, stock_actual, stock_minimo "
         + "FROM producto WHERE id_producto = 1");
     java.sql.ResultSet resultado = consulta.executeQuery()) {

    if (resultado.next()) {
        producto = new Producto(
            resultado.getInt("id_producto"),
            resultado.getString("nombre"),
            resultado.getString("descripcion"),
            resultado.getInt("stock_actual"),
            resultado.getInt("stock_minimo")
        );
    } else {
        System.out.println("No se encontro el producto en MySQL.");
        teclado.close();
        return;
    }

} catch (java.sql.SQLException e) {
    System.out.println("Error al cargar el producto: " + e.getMessage());
    teclado.close();
    return;
}


     Usuario usuario = usuarioAutenticado;

        ControlInventario control = new ControlInventario();

        int opcion = 0;

        do {
            System.out.println("\n=== SISTEMA DE INVENTARIO ===");
            System.out.println("1. Consultar producto");
            System.out.println("2. Registrar entrada");
            System.out.println("3. Registrar salida");
            System.out.println("4. Consultar movimientos");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opcion: ");

            try {
                opcion = Integer.parseInt(teclado.nextLine());

                switch (opcion) {
                    case 1:
                        System.out.println("Producto: " + producto.getNombre());
                        System.out.println("Stock actual: " + producto.consultarStock());
                        System.out.println("Stock minimo: " + producto.getStockMinimo());
                        break;

                    case 2:
                        System.out.print("Cantidad recibida: ");
                        int entrada = Integer.parseInt(teclado.nextLine());
                        control.registrarEntrada(producto, usuario, entrada);
                        break;

                    case 3:
                        System.out.print("Cantidad retirada: ");
                        int salida = Integer.parseInt(teclado.nextLine());
                        control.registrarSalida(producto, usuario, salida);
                        break;

                    case 4:
                        ConsultaMovimientosBD.mostrarMovimientos();
                        break;

                    case 5:
                        System.out.println("Programa finalizado.");
                        break;

                    default:
                        System.out.println("Opcion no valida.");
                }


} catch (NumberFormatException e) {
    System.out.println("Debe ingresar un numero valido.");
} catch (IllegalArgumentException e) {
    System.out.println("Error: " + e.getMessage());
} catch (java.sql.SQLException e) {
    System.out.println("Error en la base de datos: " + e.getMessage());
}


        } while (opcion != 5);

        teclado.close();
    }
}
