package Modelo;
// Producto de categoria Educacion, con su logica de promocion particular

public class ProductoEducacion extends Producto {

    public ProductoEducacion(int codigo, String nombre, int dia, int mes, int anio, double precioNormal, int stock) {
        super(codigo, nombre, dia, mes, anio, precioNormal, stock, "EDUCACION");
    }

    // True solo si el stock es mayor a 150
    @Override
    public boolean esPrecioPromo() {
        return stock > 150;
    }

    // No considera caducidad para promocion
    @Override
    public boolean estaProximaCaducidad() {
        return false;
    }

    // Aplica 5% de descuento si es promocion, sino precio normal
    @Override
    public double obtenerPrecioAplicado() {
        return esPrecioPromo() ? precioNormal * 0.95 : precioNormal;
    }
}
