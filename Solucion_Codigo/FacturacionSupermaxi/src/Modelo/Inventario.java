package Modelo;

import java.util.ArrayList;

public class Inventario {
    public ArrayList<Producto> listaProductos = new ArrayList<>();

    public void cargarProductos() {
        listaProductos.add(new ProductoAlimentacion(1, "Arroz Blanco", 25, 6, 2025, 0, 0, 1.00, "ALIMENTACION", 100));
        listaProductos.add(new ProductoAlimentacion(2, "Huevos Medianos", 2, 7, 2025, 0, 0, 2.50, "ALIMENTACION", 80));
        listaProductos.add(new ProductoSalud(3, "Paracetamol 500mg", 10, 8, 2025, 0, 0, 1.50, "SALUD", 60));
        listaProductos.add(new ProductoSalud(4, "Alcohol Antiseptico", 15, 12, 2025, 0, 0, 1.20, "SALUD", 90));
        listaProductos.add(new ProductoVestimenta(5, "Jeans Clasicos", 5, 11, 2025, 0, 0, 18.00, "VESTIMENTA", 30));
        listaProductos.add(new ProductoEducacion(6, "Lapiz de Grafito", 10, 10, 2025, 0, 0, 0.30, "EDUCACION", 200));
        listaProductos.add(new ProductoEducacion(7, "Cuaderno Escolar", 28, 9, 2025, 0, 0, 2.00, "EDUCACION", 100));
        listaProductos.add(new ProductoVivienda(8, "Jabon de Tocador", 18, 7, 2025, 0, 0, 0.80, "VIVIENDA", 150));
        listaProductos.add(new ProductoAlimentacion(9, "Leche Entera", 4, 7, 2025, 0, 0, 1.10, "ALIMENTACION", 60));
        listaProductos.add(new ProductoVivienda(10, "Fosforos", 22, 10, 2025, 0, 0, 0.40, "VIVIENDA", 90));
    }

    public void agregarProducto(Producto producto) {
        listaProductos.add(producto);
    }

    public Producto buscarProductoPorCodigo(int codigo) {
        for (Producto p : listaProductos) {
            if (p.codigo == codigo) {
                return p;
            }
        }
        return null;
    }

    public boolean eliminarProducto(int codigo) {
        Producto p = buscarProductoPorCodigo(codigo);
        if (p != null) {
            listaProductos.remove(p);
            return true;
        }
        return false;
    }

    public void mostrarProductos() {
        for (Producto p : listaProductos) {
            System.out.println(p);
        }
    }
}
