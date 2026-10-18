# Sistema de Inventario – La Anónima, Sucursal Arroyito

## Descripción

Este proyecto fue realizado para la materia Seminario de Práctica de Informática de la Licenciatura en Informática de la Universidad Siglo 21.

El objetivo fue desarrollar un prototipo en Java que permita llevar un control básico del inventario de la sucursal Arroyito de La Anónima.

El programa funciona por consola y se conecta a una base de datos MySQL para consultar productos y registrar movimientos de stock.

## Herramientas utilizadas

- Java 25
- Visual Studio Code
- Maven
- MySQL y phpMyAdmin
- XAMPP
- JDBC para conectar Java con la base de datos

## Funciones del programa

El sistema permite iniciar sesión, consultar el stock de un producto, registrar entradas y salidas de mercadería y consultar los movimientos realizados.

También controla que no se pueda retirar una cantidad mayor al stock disponible.

## Cómo ejecutar el programa

1. Descargar el proyecto desde este repositorio.
2. Tener instalado Java 25 y abrir el proyecto en Visual Studio Code.
3. Iniciar MySQL desde XAMPP.
4. Entrar a phpMyAdmin y crear una base de datos llamada `inventario_la_anonima`.
5. Importar el archivo `inventario_la_anonima_demo.sql` que está en el repositorio.
6. Revisar los datos de conexión en `ConexionBD.java`, según la configuración de MySQL de la computadora.
7. Ejecutar la clase `Main.java`.

## Usuarios para probar el sistema

**Administrador**
- Usuario: `admin`
- Contraseña: `demo_admin_2026`

**Empleado**
- Usuario: `empleado1`
- Contraseña: `demo_empleado_2026`

Estas cuentas son únicamente para probar el funcionamiento del proyecto.

## Aclaración

El sistema es un prototipo académico. Actualmente trabaja con un producto de ejemplo y permite realizar las operaciones principales de control de stock. La posibilidad de agregar y administrar más productos, categorías y proveedores queda como una mejora para futuras versiones.
