package Modelo;
// Producto de categoria Vestimenta, con su logica de promocion particular

public class ProductoVestimenta extends Producto {

    public ProductoVestimenta(int codigo, String nombre, int dia, int mes, int anio, double precioNormal, int stock) {
        super(codigo, nombre, dia, mes, anio, precioNormal, stock, "VESTIMENTA");
    }

    // True solo si el stock es mayor a 40
    @Override
    public boolean esPrecioPromo() {
        return stock > 40;
    }

    // No considera caducidad para promocion
    @Override
    public boolean estaProximaCaducidad() {
        return false;
    }

    // Aplica 25% de descuento si es promocion, sino precio normal
    @Override
    public double obtenerPrecioAplicado() {
        return esPrecioPromo() ? precioNormal * 0.75 : precioNormal;
    }
}
