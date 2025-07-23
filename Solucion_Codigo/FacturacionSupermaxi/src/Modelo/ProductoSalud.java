package Modelo;
// Producto de categoria Salud, con su logica de promocion particular
public class ProductoSalud extends Producto {
    public ProductoSalud(int codigo, String nombre, int dia, int mes, int anio, double precioNormal, int stock) {
        super(codigo, nombre, dia, mes, anio, precioNormal, stock, "SALUD");
    }

    // Retorna true si el producto caduca este mes
    @Override
    public boolean esPrecioPromo() {
        return estaProximaCaducidad();
    }

    // True si caduca este mes y anio
    @Override
    public boolean estaProximaCaducidad() {
        int hoyMes = 6, hoyAnio = 2025;
        return (anioCaduca == hoyAnio && mesCaduca == hoyMes);
    }

    // Aplica 20% de descuento si es promocion, sino precio normal
    @Override
    public double obtenerPrecioAplicado() {
        return esPrecioPromo() ? precioNormal * 0.80 : precioNormal;
    }
}

