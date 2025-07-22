package proyectobimestralgrupal.Modelo;

import java.util.ArrayList;

public class CarritoDeCompras {
    public ArrayList<Producto> productosCarrito = new ArrayList<>();

    public void agregarProducto(Producto producto, int cantidad) {
        Producto copia = new ProductoVivienda(
            producto.codigo, producto.nombre, producto.diaCaduca,
            producto.mesCaduca, producto.anioCaduca, producto.precioNormal,
            producto.categoria, cantidad
        );
        productosCarrito.add(copia);
    }

    public void imprimirCarrito() {
        for (Producto p : productosCarrito) {
            System.out.println(p);
        }
    }
}