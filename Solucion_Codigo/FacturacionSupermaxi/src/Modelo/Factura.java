package Modelo;
import java.util.ArrayList;

// Clase que representa una factura de compra
public class Factura {
    public DatosCliente datosCliente;
    public ArrayList<Producto> productosComprados = new ArrayList<>();
    public double total;
    public double iva = 0.15;
    public double[] totalesPorCategoria = new double[5];

    // Constructor: genera la factura con todos los productos comprados
    public Factura(DatosCliente cliente, ArrayList<Producto> productos) {
        this.datosCliente = cliente;
        for (Producto p : productos) {
            productosComprados.add(p);
        }
        calcularTotales();
    }

    // Calcula el total a pagar y los totales por cada categoria
    public void calcularTotales() {
        total = 0;
        for (Producto p : productosComprados) {
            double precio = p.obtenerPrecioAplicado() * p.stock;
            total += precio;
            int idx = getCategoriaIndex(p);
            if (idx >= 0) totalesPorCategoria[idx] += precio;
        }
    }

    // Convierte la categoria texto a indice del arreglo
    public static int getCategoriaIndex(Producto p) {
        switch(p.categoria) {
            case "VIVIENDA": return 0;
            case "EDUCACION": return 1;
            case "ALIMENTACION": return 2;
            case "VESTIMENTA": return 3;
            case "SALUD": return 4;
            default: return -1;
        }
    }

    // Devuelve el total con IVA
    public double getTotalConIva() {
        return total * (1 + iva);
    }

    // Devuelve los totales por categoria
    public double[] getTotalesPorCategoria() {
        return totalesPorCategoria;
    }

    // Devuelve la factura como texto
    @Override
    public String toString() {
        String[] categorias = {"Vivienda", "Educacion", "Alimentacion", "Vestimenta", "Salud"};
        StringBuilder sb = new StringBuilder();
        sb.append("------------ FACTURA ------------\n");
        sb.append(datosCliente).append("\n");
        sb.append("Productos:\n");
        for (Producto p : productosComprados) {
            sb.append(p).append("\n");
        }
        sb.append("\nTotales por categoria:\n");
        for (int i = 0; i < categorias.length; i++) {
            sb.append("  ").append(categorias[i]).append(": $").append(String.format("%.2f", totalesPorCategoria[i])).append("\n");
        }
        sb.append("Subtotal: $").append(String.format("%.2f", total)).append("\n");
        sb.append("IVA (15%): $").append(String.format("%.2f", total * iva)).append("\n");
        sb.append("Total: $").append(String.format("%.2f", getTotalConIva())).append("\n");
        sb.append("--------------------\n");
        return sb.toString();
    }
}
