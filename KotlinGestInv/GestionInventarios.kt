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
                if(id < 0 || cantidad < 0 || precio < 0){
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
                if (id != null) {
                    print("Nuevo nombre (dejar en blanco para no cambiar): ")
                    val nuevoNombre = readLine()?.takeIf { it.isNotBlank() }
                    print("Nueva cantidad (dejar en blanco para no cambiar): ")
                    val nuevaCantidad = readLine()?.toIntOrNull()
                    print("Nuevo precio (dejar en blanco para no cambiar): ")
                    val nuevoPrecio = readLine()?.toDoubleOrNull()
                    inventario.update(id, nuevoNombre, nuevaCantidad, nuevoPrecio)
                } else {
                    println("ID inválido.")
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
