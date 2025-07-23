package Modelo;
import java.util.ArrayList;

// Clase que gestiona la lista de productos del supermercado
public class Inventario {
    public ArrayList<Producto> listaProductos = new ArrayList<>();

    // Agrega productos de ejemplo al inventario (hardcodeados)
    public void cargarProductos() {
        listaProductos.add(new ProductoAlimentacion(1, "Arroz Blanco", 25, 6, 2025, 1.00, 100));
        listaProductos.add(new ProductoAlimentacion(2, "Huevos Medianos", 2, 7, 2025, 2.50, 80));
        listaProductos.add(new ProductoSalud(3, "Paracetamol 500mg", 10, 8, 2025, 1.50, 60));
        listaProductos.add(new ProductoSalud(4, "Alcohol Antiseptico", 15, 12, 2025, 1.20, 90));
        listaProductos.add(new ProductoVestimenta(5, "Jeans Clasicos", 5, 11, 2025, 18.00, 30));
        listaProductos.add(new ProductoEducacion(6, "Lapiz de Grafito", 10, 10, 2025, 0.30, 200));
        listaProductos.add(new ProductoEducacion(7, "Cuaderno Escolar", 28, 9, 2025, 2.00, 100));
        listaProductos.add(new ProductoVivienda(8, "Jabon de Tocador", 18, 7, 2025, 0.80, 150));
        listaProductos.add(new ProductoAlimentacion(9, "Leche Entera", 4, 7, 2025, 1.10, 60));
        listaProductos.add(new ProductoVivienda(10, "Fosforos", 22, 10, 2025, 0.40, 90));
    }

    // Agrega un nuevo producto al inventario
    public void agregarProducto(Producto p) {
        listaProductos.add(p);
    }

    // Busca un producto en el inventario por su codigo
    public Producto buscarProductoPorCodigo(int codigo) {
        for (Producto p : listaProductos) {
            if (p.codigo == codigo) return p;
        }
        return null;
    }

    // Elimina un producto del inventario por su codigo
    public void eliminarProductoPorCodigo(int codigo) {
        Producto p = buscarProductoPorCodigo(codigo);
        if (p != null) listaProductos.remove(p);
    }

    // Devuelve la lista actual de productos
    public ArrayList<Producto> getListaProductos() {
        return listaProductos;
    }
}



