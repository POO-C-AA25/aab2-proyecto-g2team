package Modelo;
import java.util.ArrayList;

public class CarritoDeCompras {
    public ArrayList<Producto> productosCarrito = new ArrayList<>();

    public void agregarProducto(Producto producto, int cantidad) {
        Producto prodCarrito = new ProductoAlimentacion(
            producto.codigo,
            producto.nombre,
            producto.diaCaduca,
            producto.mesCaduca,
            producto.anioCaduca,
            producto.mesCaducaInt,
            producto.anioCaducaInt,
            producto.precioNormal,
            producto.categoria,
            cantidad
        );
        productosCarrito.add(prodCarrito);
    }

    public void eliminarProducto(int codigo) {
        productosCarrito.removeIf(p -> p.codigo == codigo);
    }

    public void limpiarCarrito() {
        productosCarrito.clear();
    }

    public double calcularTotal() {
        double suma = 0;
        for (Producto p : productosCarrito) {
            suma += p.obtenerPrecioAplicado() * p.stock;
        }
        return suma * 1.15; // total con IVA (ejemplo)
    }

    public double[] calcularTotalesPorCategoria() {
        double[] cat = new double[5]; // Suponiendo 5 categorías
        for (Producto p : productosCarrito) {
            int index = 0; // Puedes ajustar esto según cómo manejes las categorías
            switch (p.categoria) {
                case "VIVIENDA": index = 0; break;
                case "EDUCACION": index = 1; break;
                case "ALIMENTACION": index = 2; break;
                case "VESTIMENTA": index = 3; break;
                case "SALUD": index = 4; break;
            }
            cat[index] += p.obtenerPrecioAplicado() * p.stock;
        }
        return cat;
    }
}

