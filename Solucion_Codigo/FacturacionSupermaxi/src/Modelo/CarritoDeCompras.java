package Modelo;
import java.util.ArrayList;

// Clase que representa el carrito de compras
public class CarritoDeCompras {
    public ArrayList<Producto> productosCarrito = new ArrayList<>();

    // Agrega un producto (en copia) al carrito y descuenta stock del original
    public void agregarProducto(Producto producto, int cantidad) {
        try {
            Producto copia = producto.getClass()
                .getConstructor(int.class, String.class, int.class, int.class, int.class, double.class, int.class)
                .newInstance(producto.codigo, producto.nombre,
                             producto.diaCaduca, producto.mesCaduca, producto.anioCaduca,
                             producto.precioNormal, cantidad);
            productosCarrito.add(copia);
            producto.stock -= cantidad;
        } catch (Exception e) {
            productosCarrito.add(producto);
        }
    }

    // Limpia el carrito para una nueva compra
    public void limpiarCarrito() {
        productosCarrito.clear();
    }

    // Devuelve los productos actualmente en el carrito
    public ArrayList<Producto> getProductosCarrito() {
        return productosCarrito;
    }
}
