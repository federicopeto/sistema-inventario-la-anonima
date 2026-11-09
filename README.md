# Sistema de Inventario – La Anónima, Sucursal Arroyito

## Descripción

Este proyecto fue realizado para la materia Seminario de Práctica de Informática de la Licenciatura en Informática de la Universidad Siglo 21.

El objetivo fue desarrollar un prototipo en Java para controlar el inventario, tomando como referencia la sucursal Arroyito de La Anónima. Es un proyecto académico realizado con datos de prueba.

El programa funciona por consola y se conecta a MySQL para consultar productos, actualizar existencias y registrar movimientos de stock.

## Herramientas utilizadas

- Java 25
- Visual Studio Code
- Maven
- MySQL, phpMyAdmin y XAMPP
- JDBC para conectar Java con MySQL

## Funciones del programa

El sistema permite iniciar sesión, consultar el stock de un producto, registrar entradas y salidas de mercadería y consultar los movimientos realizados.

También valida las cantidades ingresadas y evita retirar más unidades de las disponibles.

## Implementación

El proyecto utiliza programación orientada a objetos, aplicando encapsulamiento, herencia, polimorfismo y abstracción.

Se implementó el patrón DAO para separar el acceso a MySQL de la lógica del inventario, además de interfaces, arreglos y `ArrayList`.

Las entradas y salidas utilizan transacciones con `commit` y `rollback` para evitar registros incompletos. También se incorporó manejo de excepciones para controlar errores y situaciones de stock insuficiente.

## Cómo ejecutar el programa

1. Descargar el proyecto desde este repositorio.
2. Tener instalado Java 25 y abrir el proyecto en Visual Studio Code.
3. Iniciar MySQL desde XAMPP.
4. Crear en phpMyAdmin la base de datos `inventario_la_anonima`.
5. Importar el archivo `inventario_la_anonima_demo.sql` incluido en el repositorio.
6. Revisar la configuración de conexión en `ConexionBD.java`.
7. Ejecutar la clase `Main.java`.

## Usuarios para probar el sistema

**Administrador**
- Usuario: `admin`
- Contraseña: `demo_admin_2026`

**Empleado**
- Usuario: `empleado1`
- Contraseña: `demo_empleado_2026`

Estas cuentas son únicamente para realizar pruebas.

## Aclaración

El sistema es un prototipo académico que trabaja con un producto de ejemplo. La interfaz gráfica, la administración completa de productos, categorías y proveedores y los permisos diferenciados por rol quedan como mejoras futuras.
