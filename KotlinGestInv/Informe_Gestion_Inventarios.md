## Sistema de Gestión de Inventarios en Kotlin

### 1. Introducción

En este informe se presenta el desarrollo de un sistema de gestión de inventarios en Kotlin, aplicado a una aplicación de consola. El sistema permite administrar productos mediante operaciones básicas como agregar, consultar, actualizar y eliminar productos, siguiendo los principios de la Programación Orientada a Objetos (POO). Además, incluye funciones para calcular el precio total de los productos y el IVA correspondiente.

Este documento describe la estructura del código, las decisiones de diseño adoptadas y la funcionalidad implementada. Finalmente, se incluirán capturas de pantalla que evidencian la ejecución del sistema.

### 2. Objetivos

El principal objetivo de este proyecto es desarrollar un sistema funcional que permita gestionar un inventario de productos de manera eficiente. Para lograrlo, se implementan las siguientes características:

- Creación de productos con un identificador único, nombre, cantidad y precio.
- Consulta de productos almacenados en el inventario.
- Actualización de la información de un producto.
- Eliminación de productos del inventario.
- Cálculo del precio total de un producto en función de su cantidad y precio unitario.
- Cálculo del IVA total de la venta (19%).

### 3. Desarrollo

#### 3.1. Diseño del Sistema

El sistema se diseñó utilizando el paradigma de Programación Orientada a Objetos (POO), organizando el código en clases bien definidas para garantizar su modularidad y escalabilidad. Se crearon dos clases principales:

**Clase `Producto`**: Representa cada producto en el inventario, encapsulando sus atributos y proporcionando métodos para acceder y modificar su información. También implementa un método para calcular el precio total del producto.

**Clase `Inventario`**: Gestiona la lista de productos y permite realizar las operaciones CRUD (Crear, Leer, Actualizar y Eliminar). Además, incluye un método para calcular el IVA total de los productos en el inventario.

El siguiente diagrama representa la relación entre estas clases:

```
+------------------+
|    Producto     |
+------------------+
| - id: Int       |
| - nombre: String|
| - cantidad: Int |
| - precio: Double|
+------------------+
| + getId()       |
| + getNombre()   |
| + getCantidad() |
| + getPrecio()   |
| + setNombre()   |
| + setCantidad() |
| + setPrecio()   |
| + calcularPrecioTotal() |
+------------------+

           ▲
           |
           ▼

+------------------+
|   Inventario    |
+------------------+
| - productos: MutableList<Producto> |
| - IVA: Double = 0.19 |
+------------------+
| + createProduct() |
| + read()          |
| + search()        |
| + update()        |
| + delete()        |
| + calcularIVA()   |
+------------------+
```

#### 3.2. Implementación del Menú

Para la interacción con el usuario, se implementó un menú en la función `main()`, donde el usuario puede seleccionar la operación que desea realizar. Se utilizó `readLine()` para capturar las entradas del usuario y se validaron los datos ingresados para evitar errores.

### 4. Decisiones de Diseño

Durante el desarrollo del sistema, se tomaron las siguientes decisiones:

- **Uso de POO**: Se optó por utilizar clases y objetos para garantizar un código estructurado y reutilizable.
- **Encapsulamiento de Datos**: Los atributos de `Producto` son privados para evitar modificaciones no controladas.
- **Lista Mutable para el Inventario**: Se utilizó una `mutableListOf` para almacenar los productos, permitiendo agregar y eliminar elementos dinámicamente.
- **Validaciones en la Entrada de Datos**: Se agregaron controles para evitar errores en el ingreso de información, como IDs negativos o precios inválidos.

### 5. Conclusiones

El sistema desarrollado cumple con los requisitos establecidos, proporcionando una herramienta sencilla y funcional para la gestión de inventarios. La aplicación de principios de POO permitió estructurar el código de manera eficiente, facilitando su mantenimiento y posibles mejoras futuras.

Las capturas de pantalla de la ejecución del programa se presentan a continuación para evidenciar su funcionamiento.

---


