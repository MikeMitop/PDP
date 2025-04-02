# Sistema de Gestión de Inventarios en Kotlin

## Objetivo

Desarollar una aplicación en Kotlin que gestione un inventario de productos aplicando distintos principos de Programación, basandonos en Programación Orientada a Objetos, así mismo permitiendo operaciones con el CRUD (Create, Read, Update, Delete) 

## Descripción del Programa:

Este programa se basa en una aplicación mediante consola, que permite gestionar un inventario de productos mediante operaciones básicas (CRUD)

### Este funciona para:

* Registro de productos con distintos atributos (ID, Nombre, Cantidad y Precio)
* Calcular el valor total por cada producto ingresado y el IVA del inventario
* Ofrecer una interfaz por consola intuitiva que permita al usuario realizar lo que desea hacer dentro de la gestión de inventarios.

# Funcionamiento del Programa:

El programa, es un sistema de gestión de inventarios desarollado en Kotlin, que opera mediente un menú de consola, el cual permite realizar operaciones CRUD sobre los productos almacenados dentro de una lista. Cada producto debe de contener un ID, Nombre, Cantidad y Precio, con validaciones para evitar datos erroneos (Valores negativos, campos en blanco o números decimales donde no deben estar). EL sistema tras colocar el precio total por producto, se encarga de calcular el IVA del 19% sobre el valor total del inventario. La interfaz por consola es intuitiva, por lo tanto es fácil para el usuario entenderla. Este proyecto fue realizado con el Paradigma de Programación Orientada a Objetos, usando clases como Producto e Inventario.

## Código Fuente:

``` kotlin

class Producto(private var id: Int, private var nombre: String, private var cantidad: Int, private var precio: Double) {

    fun getId(): Int = id
    fun getNombre(): String = nombre
    fun getCantidad(): Int = cantidad
    fun getPrecio(): Double = precio

    fun setNombre(nuevoNombre: String) { nombre = nuevoNombre }
    fun setCantidad(nuevaCantidad: Int) { cantidad = nuevaCantidad }
    fun setPrecio(nuevoPrecio: Double) { precio = nuevoPrecio }

    fun calcularPrecioTotal(): Double = cantidad * precio

    override fun toString(): String {
        return "ID: $id | Nombre: $nombre | Cantidad: $cantidad | Precio: $$precio | Total: $${calcularPrecioTotal()}"
    }
}

class Inventario(){
    private val productos = mutableListOf<Producto>()
    private val IVA = 0.19

    fun createProduct(id: Int, nombre: String, cantidad: Int, precio: Double){
            val nProducto = Producto(id, nombre, cantidad, precio)
            productos.add(nProducto)
    }

    fun read(){
        if(productos.isEmpty()){
            println("No hay productos...")
        }else{
            for(producto in productos){
                println(producto.toString())
            }
        }
    }

    fun search(id: Int): Producto? {
        if(productos.isEmpty()){
            println("No hay productos...")
        }else{
            for (producto in productos) {
                if (producto.getId() == id) {
                    return producto // Devuelve el producto si lo encuentra
                }
            }
        }
        return null // Retorna null si no encuentra el producto
    }


    fun update(id: Int, nuevoNombre: String?, nuevaCantidad: Int?, nuevoPrecio: Double?) {
        val producto = search(id) // Llama a search() para obtener el producto
        if (producto != null) {
            if (nuevoNombre != null) producto.setNombre(nuevoNombre)
            if (nuevaCantidad != null) producto.setCantidad(nuevaCantidad)
            if (nuevoPrecio != null) producto.setPrecio(nuevoPrecio)

            println("Producto actualizado exitosamente: $producto")
        } else {
            println("Producto no encontrado.")
        }
    }

    fun delete(id: Int){
        val producto = search(id) // Llama a search() para obtener el producto
        if (producto != null) {
            productos.remove(producto)
            println("Producto eliminado correctamente...")
        }else{
            println("Producto no encontrado.")
        }
    }

    fun calcularIVA(): Double {
        val totalVenta = productos.sumOf { it.calcularPrecioTotal() }
        return totalVenta * IVA
    }
}



fun main() {
    val inventario = Inventario()

    while (true) {
        println("\n===== SISTEMA DE GESTIÓN DE INVENTARIOS =====")
        println("1. Crear nuevo producto")
        println("2. Ver todos los productos")
        println("3. Buscar producto por ID")
        println("4. Actualizar producto")
        println("5. Eliminar producto")
        println("6. Calcular IVA total")
        println("0. Salir")
        print("Seleccione una opción: ")

        val opcion = readLine()?.toIntOrNull()

        when (opcion) {
            1 -> {
                print("Ingrese ID del producto: ")
                val id = readLine()?.toIntOrNull() ?: 0
                print("Ingrese nombre del producto: ")
                val nombre = readLine().orEmpty()
                print("Ingrese cantidad: ")
                val cantidad = readLine()?.toIntOrNull() ?: 0
                print("Ingrese precio: ")
                val precio = readLine()?.toDoubleOrNull() ?: 0.0
                if(id <= 0 || cantidad <= 0 || precio <= 0){
                    println("Valores ingresados son incorrectos")
                }else {
                    inventario.createProduct(id, nombre, cantidad, precio)
                    println("Producto registrado correctamente...")
                }
            }
            2 -> inventario.read()
            3 -> {
                print("Ingrese el ID del producto a buscar: ")
                val id = readLine()?.toIntOrNull() ?: 0
                if(id < 0){
                    println("Valor ingresado no correcto...")
                }else{
                    val producto = id?.let { inventario.search(id) }
                    if (producto != null) {
                        println("Producto encontrado: $producto")
                    } else {
                        println("Producto no encontrado.")
                    }
                }
            }
            4 -> {
                print("Ingrese el ID del producto a actualizar: ")
                val id = readLine()?.toIntOrNull()

                if (id == null || id < 0 || inventario.search(id) == null) {
                    println("ID inválido o producto no encontrado.")
                } else {
                    print("Nuevo nombre (dejar en blanco para no cambiar): ")
                    val nuevoNombre = readLine()?.takeIf { it.isNotBlank() }
                    print("Nueva cantidad (dejar en blanco para no cambiar): ")
                    val nuevaCantidad = readLine()?.toIntOrNull()
                    print("Nuevo precio (dejar en blanco para no cambiar): ")
                    val nuevoPrecio = readLine()?.toDoubleOrNull()

                    inventario.update(id, nuevoNombre, nuevaCantidad, nuevoPrecio)
                }

            }
            5 -> {
                print("Ingrese el ID del producto a eliminar: ")
                val id = readLine()?.toIntOrNull()
                if (id != null) {
                    inventario.delete(id)
                } else {
                    println("ID inválido.")
                }
            }
            6 -> println("El IVA total de los productos es: \$${inventario.calcularIVA()}")
            0 -> {
                println("Saliendo del sistema...")
                break
            }
            else -> println("Opción inválida, intente nuevamente.")
        }
    }
}

```

## Entrada y Salida esperada

### Entrada

```kotlin

===== SISTEMA DE GESTIÓN DE INVENTARIOS =====
1. Crear nuevo producto
2. Ver todos los productos
3. Buscar producto por ID
4. Actualizar producto
5. Eliminar producto
6. Calcular IVA total
0. Salir
Seleccione una opción:

```

```kotlin
Seleccione una opción: 1
Ingrese ID del producto: 01
Ingrese nombre del producto: Manzana
Ingrese cantidad: 10
Ingrese precio: 5000
Producto registrado correctamente...

Seleccione una opción: 2
ID: 1 | Nombre: Manzana | Cantidad: 10 | Precio: $5000.0 | Total: $50000.0

Seleccione una opción: 3
Ingrese el ID del producto a buscar: 01
Producto encontrado: ID: 1 | Nombre: Manzana | Cantidad: 10 | Precio: $5000.0 | Total: $50000.0

Seleccione una opción: 4
Ingrese el ID del producto a actualizar: 01
Nuevo nombre (dejar en blanco para no cambiar): 
Nueva cantidad (dejar en blanco para no cambiar): 5
Nuevo precio (dejar en blanco para no cambiar): 2500
Producto actualizado exitosamente: ID: 1 | Nombre: Manzana | Cantidad: 5 | Precio: $2500.0 | Total: $12500.0

Seleccione una opción: 5
Ingrese el ID del producto a eliminar: 01
Producto eliminado correctamente...

Seleccione una opción: 6
El IVA total de los productos es: $2375.0

Seleccione una opción: 0
Saliendo del sistema...

```

## Estructura del Proyecto y Explicación

### Clase Producto

Esta clase usa atributos privados y exponiendo metodos para permitir el acceso y modificación de sus valores.

**Atributos:**
```
id: Int
nombre: String
cantidad: Int
Precio: Double
```
**Métodos:**

getters y setters

``getId(), getNombre(), getCantidad(), getPrecio()``

``setNombre(nuevoNombre: String), setCantidad(nuevaCantidad: Int), setPrecio(nuevoPrecio: Double)``

Por otro lado, se tiene un método ``calcularPrecioTotal()`` el cual permite multiplicar el precio por la cantidad para así devolver el valor total del producto. 

Por ultimo, se usa un ``toString(): String`` para retornar la representación del producto, incluyendo así el valor total.

-------------------

### Clase Inventario

Esta clase se encarga de manejar los calculos agregados, así como el CRUD.

**Atributos:**

``productos: MutableList<Producto>`` La cual es una lista donde se almacenan todos los productos creados.

``IVA: Double`` Es una constante que representa el valor del IVA (19%)

**Metodos**

``createProduct(id, nombre, cantidad, precio)`` Crea una instancia Producto y la añade al inventario

``read()`` Muestra los productos que están almacenados en caso de que la lista NO esté vacía.

``update(id, nuevoNombre, nuevaCamtidad, nuevoPrecio)`` Modifica los atributos de un producto existente. Verifica si el producto existe anteriormente.

``delete(id)`` Elimina un producto de la lista, dependiendo de su ID

``calcularIVA(): Double`` Suma los precios totales de los productos en la lista, y calcula el 19% de ese resultado para agregarlo como IVA.

**Función main()**

Este permite la funcionalidad del menú interactivo por consola, permite la ejecución correcta de las operaciones del CRUD o el IVA correspondiente.

***¿Cómo funciona?***

1. Crea el producto: Solicita los atos, valida los datos y llama a ``createProduct``
2. Ver Productos: Llama al método ``read()`` para mostrar el inventario.
3. Buscar por ID: Permite buscar el producto mediante su ID y con el método ``search()``
4. Actualizar: Permite hacer modificaciones tales como el nombre, cantidad o precio de un producto que ya se encuentre mediante una ID
5. Eliminar Producto: Busca el producto por su ID y lo elimina en caso de que el ID exista.
6. Calcula el IVA total. Muestra el IVA acumulado de todos los productos.
7. Salir del programa: Finaliza el programa.

## Conclusiones Finales

* El desarollo del proyecto, permitió aplicar de manera práctica los principios fundamentales de la Programación Orientada a Objetos. Permitiendo la modularidad y la reutilización del código.
  
* El Programa tiene una interfaz por consola la cual es intuitiva, lo cual le permite al usuario una experiencia mayor, dado a que permite realizar operaciones básicas, como registrar, consultar, eliminar, actualizar, calcular iva.
  
* Se logró conocer de mayor forma el como funciona el lenguaje de Programación de Kotlin, usando estructuras como clases, funciones, listas, condicionales y ciclos, además de utilizar constructores y encapsulamiento, fundamentales al momento de enfrentarse a Programación Orientada a Objetos.


# Integrantes del grupo:

- Miguel  Celis 
- Santiago Rodriguez
- Juan Barrera
