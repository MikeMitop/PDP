## Informe sistema de Gestión de Inventarios en Kotlin

---

### 1. Introducción

En este informe se presenta el desarrollo de un sistema de gestión de inventarios en Kotlin, aplicado a una aplicación de consola. El sistema permite administrar productos mediante operaciones básicas como agregar, consultar, actualizar y eliminar productos, siguiendo los principios de la Programación Orientada a Objetos (POO). Además, incluye funciones para calcular el precio total de los productos y el IVA correspondiente.

---

### 2. Objetivo del proyecto

El principal objetivo de este proyecto es desarrollar un sistema funcional que permita gestionar un inventario de productos de manera eficiente. Para lograrlo, se implementan las siguientes características:

- Creación de productos con un identificador único, nombre, cantidad y precio.
- Consulta de productos almacenados en el inventario.
- Actualización de la información de un producto.
- Eliminación de productos del inventario.
- Cálculo del precio total de un producto en función de su cantidad y precio unitario.
- Cálculo del IVA total de la venta (19%).

---

### 3. Desarrollo

#### 3.1. Diseño del Sistema 

El sistema se diseñó utilizando el paradigma de Programación Orientada a Objetos (POO), organizando el código en clases bien definidas para garantizar su modularidad y escalabilidad. Se crearon dos clases principales:

**Clase `Producto`**: Representa cada producto en el inventario, encapsulando sus atributos y proporcionando métodos para acceder y modificar su información. También implementa un método para calcular el precio total del producto.

**Clase `Inventario`**: Gestiona la lista de productos y permite realizar las operaciones CRUD (Crear, Leer, Actualizar y Eliminar). Además, incluye un método para calcular el IVA total de los productos en el inventario.

---

El siguiente diagrama representa la relación entre estas clases:


```plaintext
+---------------------+
|      Producto       |
+---------------------+
| - id: Int          |
| - nombre: String   |
| - cantidad: Int    |
| - precio: Double   |
+---------------------+
| + getId()          |
| + getNombre()      |
| + getCantidad()    |
| + getPrecio()      |
| + setNombre()      |
| + setCantidad()    |
| + setPrecio()      |
| + calcularPrecioTotal() |
+---------------------+


  
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
---

#### 3.2. Implementación del Menú

Para la interacción con el usuario, se implementó un menú en la función `main()`, donde el usuario puede seleccionar la operación que desea realizar. Se utilizó `readLine()` para capturar las entradas del usuario y se validaron los datos ingresados para evitar errores.

---

### 4. Decisiones de Diseño

Durante el desarrollo del sistema, se tomaron las siguientes decisiones:

- **Uso de POO**: Se optó por utilizar clases y objetos para garantizar un código estructurado y reutilizable.
- **Encapsulamiento de Datos**: Los atributos de `Producto` son privados para evitar modificaciones no controladas.
- **Lista Mutable para el Inventario**: Se utilizó una `mutableListOf` para almacenar los productos, permitiendo agregar y eliminar elementos dinámicamente.
- **Validaciones en la Entrada de Datos**: Se agregaron controles para evitar errores en el ingreso de información, como IDs negativos o precios inválidos.

---

### 5. Conclusiones

El sistema desarrollado cumple con los requisitos establecidos, proporcionando una herramienta sencilla y funcional para la gestión de inventarios. La aplicación de principios de POO permitió estructurar el código de manera eficiente, facilitando su mantenimiento y posibles mejoras futuras.


---

### 6. Evidencias de ejecución del programa:

### El menú en la consola.
![WhatsApp Image 2025-04-01 at 7 24 28 PM](https://github.com/user-attachments/assets/58a52ffa-fcb6-442e-a645-20ac35b01598)

### Producto ingresado en el sistema.
![image](https://github.com/user-attachments/assets/5893a1cf-393a-46b5-95d3-39a92c2466c2)

### En caso de que los valores no sean validos.
![image](https://github.com/user-attachments/assets/3e07b286-2b6c-4732-8b6b-ed4519eab03e)

### Ejemplo de otro producto creado.
![image](https://github.com/user-attachments/assets/d3a196df-23c7-478c-be5c-1fd334900b9d)

### Lista de productos guardados 
![image](https://github.com/user-attachments/assets/3bed4611-a2ff-4781-bccb-85369960b9f3)

### Busqueda de un producto no ingresado en el sistema.
![image](https://github.com/user-attachments/assets/d608b8d5-4278-465b-862f-d78f53b59026)

### Busqueda de un producto con el ID no valido.
![image](https://github.com/user-attachments/assets/5b5de57b-9628-4f64-95c9-439c2949aed2)

### Busqueda de el producto en el inventario.
![image](https://github.com/user-attachments/assets/c2a128cb-3b45-465a-a323-0340b9f6119d)

### Busqueda de ID no registrada
![image](https://github.com/user-attachments/assets/438ecccb-f7d3-483e-857a-3a697becc435)

### Actualizacion de un producto
![image](https://github.com/user-attachments/assets/c34c4a22-57a6-4d21-b092-fc38c764bb05)

### Eliminar el producto que no se encuentra en el inventario.
![image](https://github.com/user-attachments/assets/a2e12c06-2a52-4ac0-a9cc-27f7a47d566b)

###  ID invalida en la eliminacion
![image](https://github.com/user-attachments/assets/16832ae8-bea2-47ee-b119-9f702f77cb47)

### Producto escogido eliminado
![image](https://github.com/user-attachments/assets/286036b3-a8da-4a68-be87-783961328f3f)

### Inventario despues de la eliminacion del producto
![image](https://github.com/user-attachments/assets/19cf2d56-2501-4e9f-81d3-bd59fe6e92d0)

### IVA total del inventario
![image](https://github.com/user-attachments/assets/f10c0ef6-9662-4d13-ae4e-41c33c103e71)
